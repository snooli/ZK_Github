package dots.tool.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;


import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;

import dots.export.arkivstruktur.ArchiveStructure;
import dots.export.arkivuttrekk.ArchiveExtraction;
import dots.export.endringslogg.ChangeLog;
import dots.export.loepende.RunningRecords;
import dots.export.offentlig.PublicRecords;
import dots.module.base.entitybeans.FondsBean;
import dots.tool.config.Config;
import dots.tool.helpers.TarGZHelper;

public class N5ExportTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {
			// initialize
			init();

			List<FondsBean> fondsList = N5Client.get().getSearchService()
					.fondsFindTopLevel();

			// generate the archive structure
			ArchiveStructure.generate(fondsList.get(0));

			// generate the change log
			ChangeLog.generate();

			// generate the running records
			RunningRecords.generate(fondsList.get(0));

			// generate the public records
			PublicRecords.generate(fondsList.get(0));

			// generate the archive extraction
			ArchiveExtraction.generate(fondsList.get(0));

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			cleanup();
		}

	}

	private static void init() throws Exception {

		XMLConfiguration config = null;
		
		try {
		// initialize the configuration
		 config = new XMLConfiguration("config/config.xml");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		// get the address and port of the Noark 5 core
		Config.n5Address = config.getString("n5address");
		Config.n5Port = config.getString("n5port");

		String targetDir = config.getString("targetDir");
		String timeNow = new SimpleDateFormat("yyyy-MM-dd'_'HH-mm-ss")
				.format(Calendar.getInstance().getTime());
		String tmpRoot = System.getProperty("java.io.tmpdir") + File.separator
				+ timeNow;

		Config.tmpRoot = new File(tmpRoot);
		Config.tmpDocuments = new File(tmpRoot + File.separator + "dokumenter");
		Config.outputFile = new File(targetDir + File.separator + timeNow
				+ ".tar.gz");

		// copy the schemas to the temporary directory
		Collection<File> schemas = FileUtils.listFiles(new File("schemas"),
				new String[] { "xsd" }, false);

		for (File schema : schemas) {

			File destFile = new File(tmpRoot + File.separator
					+ schema.getName());

			FileUtils.copyFile(schema, destFile);
		}

		Config.archiveStructureFile = new File(tmpRoot + File.separator
				+ "arkivstruktur.xml");
		Config.archiveStructureSchema = new File(tmpRoot + File.separator
				+ "arkivstruktur.xsd");

		Config.publicRecordsFile = new File(tmpRoot + File.separator
				+ "offentligJournal.xml");
		Config.publicRecordsSchema = new File(tmpRoot + File.separator
				+ "offentligJournal.xsd");

		Config.runningRecordsFile = new File(tmpRoot + File.separator
				+ "loependeJournal.xml");
		Config.runningRecordsSchema = new File(tmpRoot + File.separator
				+ "loependeJournal.xsd");

		Config.changeLogFile = new File(tmpRoot + File.separator
				+ "endringslogg.xml");
		Config.changeLogSchema = new File(tmpRoot + File.separator
				+ "endringslogg.xsd");

		Config.archiveExtractionFile = new File(tmpRoot + File.separator
				+ "arkivuttrekk.xml");
		Config.archiveExtractionSchema = new File(tmpRoot + File.separator
				+ "addml.xsd");

		Config.metadataCatalogSchema = new File(tmpRoot + File.separator
				+ "metadatakatalog.xsd");

		Config.tmpRoot.mkdir();
		Config.tmpDocuments.mkdir();

	}

	private static void cleanup() throws Exception {

		TarGZHelper.createTarGZ(Config.tmpRoot.getAbsolutePath(),
				Config.outputFile.getAbsolutePath());

		// delete the temp directory
		FileUtils.deleteDirectory(Config.tmpRoot);
	}
}

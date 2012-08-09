package dots.export.arkivuttrekk;

import java.util.List;


import com.ociweb.xml.ElementWAX;
import com.ociweb.xml.StartTagWAX;
import com.ociweb.xml.WAX;

import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.tool.config.Config;
import dots.tool.helpers.ChecksumHelper;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class ArchiveExtraction {

	public static void generate(FondsBean fonds) throws Exception {

		// calculate checksums
		String metadataCatalogSchemaChecksum = 
			ChecksumHelper.getFileChecksum(Config.metadataCatalogSchema);
		
		String archiveStructureFileChecksum =
			ChecksumHelper.getFileChecksum(Config.archiveStructureFile);
			
		String archiveStructureSchemaChecksum =
			ChecksumHelper.getFileChecksum(Config.archiveStructureSchema);

		String changeLogFileChecksum =
			ChecksumHelper.getFileChecksum(Config.changeLogFile);
		
		String changeLogSchemaChecksum =
			ChecksumHelper.getFileChecksum(Config.changeLogSchema);

		String runningRecordsFileChecksum = 
			ChecksumHelper.getFileChecksum(Config.runningRecordsFile);
			
		String runningRecordsSchemaChecksum =
			ChecksumHelper.getFileChecksum(Config.runningRecordsSchema);

		String publicRecordsFileChecksum = 
			ChecksumHelper.getFileChecksum(Config.publicRecordsFile);
		
		String publicRecordsSchemaChecksum =
			ChecksumHelper.getFileChecksum(Config.publicRecordsSchema);
		
		// get the number of documents
		int numDocuments = Config.tmpDocuments.list().length;
		
		// get the number of files
		int numFiles = N5Client.get().getSearchService().caseFileFindAll().size();
		
		// get the number of records
		int numRecords = N5Client.get().getSearchService().registryEntryFindAll().size();
		
		// get the fonds creators
		List<FondsCreatorBean> fondsCreators = N5Client.get().getBaseService()
			.fondsGetFondsCreators(fonds.getSystemId());
		
		// start the XML output
		WAX wax = new WAX(Config.archiveExtractionFile.getAbsolutePath());
		wax.setIndent(2);

		StartTagWAX rootEl = wax.start("addml")
				.defaultNamespace("http://www.arkivverket.no/standarder/addml")
				.attr("name", "Noark 5-arkivuttrekk");

		// description
		StartTagWAX referenceEl = rootEl
			.start("dataset")
			.child("description", "Noark 5-arkivuttrekk")
			.start("reference");

		// context
		StartTagWAX additionalElementsEl = referenceEl.start("context")
				.start("additionalElements").start("additionalElement")
				.attr("name", "recordCreators").start("additionalElements");

		for(FondsCreatorBean creator : fondsCreators) {
			additionalElementsEl.start("additionalElement")
			.attr("name", "recordCreator")
			.child("value", creator.getFondsCreatorName()).end();
		}
		
		ElementWAX tempEl = additionalElementsEl.end().end();
		
		tempEl = tempEl.start("additionalElement").attr("name", "systemType")
			.child("value", "Sakarkiv (Noark-5)").end()
			.start("additionalElement").attr("name", "systemName")
			.child("value","arkivlab").end()
			.start("additionalElement").attr("name", "archive")
			.child("value", fonds.getTitle()).end().end().end();
		
		// content
		tempEl = tempEl.start("content").start("additionalElements")
			.start("additionalElement").attr("name", "archivalPeriod")
			.start("properties").start("property").attr("name", "startDate")
			.child("value", ValueHelper.getDate(fonds.getCreatedDate())).end()
			.start("property").attr("name", "endDate")
			.child("value", ValueHelper.getDate(fonds.getFinalisedDate())).end()
			.end().end().end().end().end();
		

		// Noark 5 arkivuttrekk - info
		tempEl = referenceEl.start("dataObjects").start("dataObject")
			.attr("name", "Noark 5 arkivuttrekk").start("properties")
			.start("property").attr("name", "info").start("properties")
			.start("property").attr("name", "type")
			.child("value", "Noark 5").start("properties")
			.start("property").attr("name", "version")
			.child("value", "3.0").end().end().end()
			.start("property").attr("name", "additionalInfo")
			.start("properties").start("property").attr("name", "periode")
			.start("properties").start("property").attr("name", "inngaaendeSkille")
			.child("value", "mykt").end()
			.start("property").attr("name", "utgaaendeSkille")
			.child("value", "mykt").end().end().end()
			.start("property").attr("dataType", "boolean")
			.attr("name", "inneholderSkjermetInformasjon")
			.child("value", "false").end()
			.start("property").attr("dataType", "boolean")
			.attr("name", "omfatterDokumenterSomErKassert")
			.child("value", "false").end()
			.start("property").attr("dataType", "boolean")
			.attr("name", "inneholderDokumenterSomSkalKasseres")
			.child("value", "false").end()
			.start("property").attr("dataType", "boolean")
			.attr("name", "inneholderVirksomhetsspesifikkeMetadata")
			.child("value", "false").end()
			.start("property").attr("dataType", "integer")
			.attr("name", "antallDokumentfiler")
			.child("value", numDocuments + "").end()
			.end().end().end().end().end();
		
		// archive structure file
		tempEl = tempEl.start("dataObjects")
			.start("dataObject").attr("name", "arkivstruktur")
			.start("properties").start("property").attr("name", "file")
			.start("properties").start("property").attr("name", "name")
			.child("value", "arkivstruktur.xml").end()
			.start("property").attr("name", "format")
			.child("value", "XML")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum")
			.start("properties").start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", archiveStructureFileChecksum)
			.end().end().end().end().end();
			
		// archive structure file - schema
		tempEl = tempEl.start("property").attr("name", "schema")
			.child("value", "main")
			.start("properties").start("property").attr("name", "file")
			.start("properties").start("property").attr("name", "name")
			.child("value", "arkivstruktur.xsd").end()
			.start("property").attr("name", "format")
			.child("value", "XML")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum")
			.start("properties").start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", archiveStructureSchemaChecksum)
			.end().end().end().end().end()
			.start("property").attr("name", "type")
			.child("value", "XML Schema")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end().end().end();
			
		// archive structure file - metadata catalog			
		tempEl = tempEl.start("property").attr("name", "schema")
			.start("properties").start("property").attr("name", "file")
			.start("properties").start("property").attr("name", "name")
			.child("value","metadatakatalog.xsd").end()
			.start("property").attr("name", "format")
			.child("value", "XML")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum")
			.start("properties").start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", metadataCatalogSchemaChecksum)
			.end().end().end().end().end()
			.start("property").attr("name", "type")
			.child("value", "XML Schema")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end().end().end();
			
		// archive structure file - files and records
		tempEl = tempEl.start("property").attr("name", "info").start("properties")
			.start("property").attr("name", "numberOfOccurrences")
			.child("value", "mappe").start("properties")
			.start("property").attr("name", "elementPath")
			.child("value", "//mappe").end()
			.start("property").attr("dataType", "integer")
			.attr("name", "value")
			.child("value", numFiles + "").end().end().end()
			.start("property").attr("name", "numberOfOccurrences")
			.child("value", "registrering")
			.start("properties").start("property").attr("name", "elementPath")
			.child("value", "//registrering").end()
			.start("property").attr("dataType", "integer").attr("name", "value")
			.child("value", numRecords + "")
			.end().end().end().end().end().end().end();
			
		// change log file
		tempEl = tempEl.start("dataObject").attr("name", "endringslogg")
			.start("properties").start("property").attr("name", "file")
			.start("properties").start("property").attr("name", "name")
			.child("value", "endringslogg.xml").end()
			.start("property").attr("name", "format")
			.child("value", "XML")
			.start("properties").start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", changeLogFileChecksum)
			.end().end().end().end().end();
			
		// change log file - schema
		tempEl = tempEl.start("property").attr("name", "schema")
			.child("value", "main").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "endringslogg.xsd").end()
			.start("property").attr("name", "format")
			.child("value", "XML").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", changeLogSchemaChecksum).end().end().end().end().end()
			.start("property").attr("name", "type")
			.child("value", "XML Schema").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end().end().end();
			
		// change log file - metadata catalog
		tempEl = tempEl.start("property").attr("name", "schema").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "metadatakatalog.xsd")
			.end().end().end().end().end().end().end();
		
		// running records file
		tempEl = tempEl.start("dataObject").attr("name", "loependeJournal")
			.start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "loependeJournal.xml").end()
			.start("property").attr("name", "format")
			.child("value", "XML").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", runningRecordsFileChecksum)
			.end().end().end().end().end();
			
		// running records file - schema	
		tempEl = tempEl.start("property").attr("name", "schema")
			.child("value", "main").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "loependeJournal.xsd").end()
			.start("property").attr("name", "format")
			.child("value", "XML").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", runningRecordsSchemaChecksum)
			.end().end().end().end().end()
			.start("property").attr("name", "type")
			.child("value", "XML Schema").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end().end().end();
			
		// running records file - metadata catalog
		tempEl = tempEl.start("property").attr("name", "schema").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "metadatakatalog.xsd").end().end().end().end().end();
			
		// running records file - info
		tempEl = tempEl.start("property").attr("name", "info").start("properties")
			.start("property").attr("name", "numberOfOccurrences")
			.child("value","registrering").start("properties")
			.start("property").attr("name", "elementPath")
			.child("value", "//registrering").end()
			.start("property").attr("dataType", "integer")
			.attr("name", "value")
			.child("value", numRecords + "")
			.end().end().end().end().end().end().end();
			
		// public records file
		tempEl = tempEl.start("dataObject").attr("name", "offentligJournal")
			.start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "offentligJournal.xml").end()
			.start("property").attr("name", "format")
			.child("value", "XML").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA-256").end()
			.start("property").attr("name", "value")
			.child("value", publicRecordsFileChecksum)
			.end().end().end().end().end();
			
		// public records file - schema
		tempEl = tempEl.start("property").attr("name", "schema")
			.child("value", "main").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "offentligJournal.xsd").end()
			.start("property").attr("name", "format")
			.child("value", "XML").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end()
			.start("property").attr("name", "checksum").start("properties")
			.start("property").attr("name", "algorithm")
			.child("value", "SHA256").end()
			.start("property").attr("name", "value")
			.child("value", publicRecordsSchemaChecksum)
			.end().end().end().end().end()
			.start("property").attr("name", "type")
			.child("value", "XML Schema").start("properties")
			.start("property").attr("name", "version")
			.child("value", "1.0").end().end().end().end().end();
			
		// public records file - metadata catalog
		tempEl = tempEl.start("property").attr("name", "schema").start("properties")
			.start("property").attr("name", "file").start("properties")
			.start("property").attr("name", "name")
			.child("value", "metadatakatalog.xsd").end().end().end().end().end();

		// public records file - records
		tempEl = tempEl.start("property").attr("name", "info").start("properties")
			.start("property").attr("name", "numberOfOccurrences")
			.child("value", "registrering").start("properties")
			.start("property").attr("name", "elementPath")
			.child("value", "//registrering").end()
			.start("property").attr("dataType", "integer").attr("name", "value")
			.child("value", numRecords + "");

		// close the output XML file
		tempEl.close();
	}

}

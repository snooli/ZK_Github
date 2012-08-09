package dots.export.arkivstruktur;

import java.io.File;


import org.apache.commons.io.FileUtils;

import com.ociweb.xml.ElementWAX;

import dots.module.base.entitybeans.DocumentObjectBean;
import dots.tool.config.Config;
import dots.tool.helpers.ValueHelper;

public class DocumentObjectWriter {

	public static void writeDocumentObjectRecursive(DocumentObjectBean dobj,
			ElementWAX parentEl) {

		// copy the document to the output documents folder
		File sourceFile = new File(dobj.getReferenceDocumentFile());
		File targetFile = new File(Config.tmpDocuments.getAbsolutePath()
				+ File.separator + sourceFile.getName());

		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		ElementWAX dobjEl = parentEl
				.start("dokumentobjekt")
				.child("versjonsnummer",
						ValueHelper.getInt1(dobj.getVersionNumber()))
				.child("variantformat",
						ValueHelper.getVariantFormat(dobj.getVariantFormat()))
				.child("format", dobj.getFormat())
				.child("opprettetDato",
						ValueHelper.getDateTime(dobj.getCreatedDate()))
				.child("opprettetAv", dobj.getCreatedBy())
				.child("referanseDokumentfil", targetFile.getName())
				.child("sjekksum", dobj.getChecksum())
				.child("sjekksumAlgoritme", dobj.getChecksumAlgorithm())
				.child("filstoerrelse", dobj.getFileSize().intValue() + "");

		dobjEl.end();
	}
}

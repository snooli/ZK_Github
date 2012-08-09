package dots.export.arkivstruktur;

import java.util.List;


import com.ociweb.xml.ElementWAX;

import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class DocumentDescriptionWriter {

	public static void writeDocumentDescriptionRecursive(
			DocumentDescriptionBean dd, ElementWAX parentEl) {

		ElementWAX ddEl = parentEl
				.start("dokumentbeskrivelse")
				.child("systemID", dd.getSystemId())
				.child("dokumenttype", dd.getDocumentType())
				.child("dokumentstatus",
						ValueHelper.getDocumentStatus(dd.getDocumentStatus()))
				.child("tittel", dd.getTitle())
				.child("beskrivelse", dd.getDescription())
				.child("opprettetDato",
						ValueHelper.getDateTime(dd.getCreatedDate()))
				.child("opprettetAv", ValueHelper.getName(dd.getCreatedBy()))
				.child("tilknyttetRegistreringSom",
						ValueHelper.getAssociatedWithRecordAs(dd
								.getAssociatedWithRecordAs()))
				.child("dokumentnummer",
						ValueHelper.getInt1(dd.getDocumentNumber()))
				.child("tilknyttetDato",
						ValueHelper.getDate(dd.getAssociationDate()))
				.child("tilknyttetAv",
						ValueHelper.getName(dd.getAssociatedBy()));

		// get the document objects
		List<DocumentObjectBean> dobjs = N5Client.get().getBaseService()
				.documentDescriptionGetDocumentObjects(dd.getSystemId());

		// go through each of them
		for (DocumentObjectBean dobj : dobjs) {
			DocumentObjectWriter.writeDocumentObjectRecursive(dobj, parentEl);
		}

		ddEl.end();
	}

}

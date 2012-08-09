package dots.export.arkivstruktur;

import java.util.List;


import com.ociweb.xml.ElementWAX;

import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class RecordWriter {

	public static void writeRecordRecursive(RegistryEntryBean record,
			ElementWAX parentEl) {

		ElementWAX recordEl = parentEl
				.start("registrering")
				.child("systemID", record.getSystemId())
				.child("opprettetDato",
						ValueHelper.getDateTime(record.getCreatedDate()))
				.child("opprettetAv", record.getCreatedBy())
				.child("arkivertDato",
						ValueHelper.getDateTime(record.getArchivedDate()))
				.child("arkivertAv",
						ValueHelper.getName(record.getArchivedBy()));

		// get the document descriptions
		List<DocumentDescriptionBean> dds = N5Client.get().getBaseService()
				.registryEntryGetDocumentDescriptions(record.getSystemId());

		// go through each of them
		for (DocumentDescriptionBean dd : dds) {
			DocumentDescriptionWriter.writeDocumentDescriptionRecursive(dd,
					recordEl);
		}

		recordEl.end();
	}
}

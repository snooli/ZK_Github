package dots.export.arkivstruktur;

import java.util.List;


import com.ociweb.xml.ElementWAX;

import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class FileWriter {

	public static void writeFileRecursive(CaseFileBean file, ElementWAX parentEl) {

		ElementWAX fileEl = parentEl
				.start("mappe")
				.child("systemID", file.getSystemId())
				.child("mappeID", ValueHelper.getFileId(file.getFileId()))
				.child("tittel", file.getTitle())
				.child("opprettetDato",
						ValueHelper.getDateTime(file.getCreatedDate()))
				.child("opprettetAv", file.getCreatedBy())
				.child("avsluttetDato",
						ValueHelper.getDateTime(file.getFinalisedDate()))
				.child("avsluttetAv",
						ValueHelper.getName(file.getFinalisedBy()));

		// get the child files
		List<CaseFileBean> childFiles = N5Client.get().getBaseService()
				.caseFileGetChildCaseFiles(file.getSystemId());

		// go through each child
		for (CaseFileBean child : childFiles) {
			writeFileRecursive(child, parentEl);
		}

		// get the records
		List<RegistryEntryBean> records = N5Client.get().getBaseService()
				.caseFileGetRegistryEntries(file.getSystemId());
		
		// go through each record
		for(RegistryEntryBean record : records) {
			RecordWriter.writeRecordRecursive(record, fileEl);
		}

		fileEl.end();
	}

}

package dots.export.endringslogg;

import java.util.List;


import com.ociweb.xml.StartTagWAX;
import com.ociweb.xml.WAX;

import dots.module.base.entitybeans.ChangeLogEntryBean;
import dots.tool.config.Config;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class ChangeLog {

	public static void generate() throws Exception {

		List<ChangeLogEntryBean> logEntries = N5Client.get().getSearchService()
				.changeLogEntryFindAll();

		WAX wax = new WAX(Config.changeLogFile.getAbsolutePath());
		wax.setIndent(2);

		StartTagWAX rootEl = wax.start("endringslogg").defaultNamespace(
				"http://www.arkivverket.no/standarder/noark5/endringslogg");

		// go through each log entry
		for (ChangeLogEntryBean entry : logEntries) {

			// add it to the XML
			rootEl.start("endring")
					.child("referanseArkivenhet", entry.getReferenceToEntity())
					.child("referanseMetadata", entry.getElementName())
					.child("endretDato",
							ValueHelper.getDateTime(entry.getChangedDate()))
					.child("endretAv", entry.getChangedBy())
					.child("tidligereVerdi", entry.getOldValue())
					.child("nyVerdi", entry.getNewValue()).end();
		}

		// close the output XML file
		rootEl.close();
	}

}

package dots.export.offentlig;

import java.util.List;


import com.ociweb.xml.StartTagWAX;
import com.ociweb.xml.WAX;

import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.tool.config.Config;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class PublicRecords {

	public static void generate(FondsBean fonds) {

		int numRecords = N5Client.get().getSearchService()
				.registryEntryFindAll().size();

		WAX wax = new WAX(Config.publicRecordsFile.getAbsolutePath());
		wax.setIndent(2);

		StartTagWAX rootEl = wax.start("offentligJournal").defaultNamespace(
				"http://www.arkivverket.no/standarder/noark5/offentligJournal");

		StartTagWAX headerEl = rootEl.start("journalhode");
		headerEl.child("journalStartDato",
				ValueHelper.getDate(fonds.getCreatedDate()))
				.child("journalSluttDato",
						ValueHelper.getDate(fonds.getFinalisedDate()))
				.child("antallJournalposter", numRecords + "");

		List<FondsCreatorBean> fondsCreators = N5Client.get().getBaseService()
				.fondsGetFondsCreators(fonds.getSystemId());

		for (FondsCreatorBean fondsCreator : fondsCreators) {

			headerEl.start("arkivskaper")
					.child("arkivskaperID", fondsCreator.getFondsCreatorId())
					.child("arkivskaperNavn",
							fondsCreator.getFondsCreatorName())
					.child("beskrivelse", fondsCreator.getDescription()).end();
		}

		headerEl.end();

		// get all records
		List<RegistryEntryBean> records = N5Client.get().getSearchService()
				.registryEntryFindAll();

		// go through each of them
		for (RegistryEntryBean record : records) {

			// get the file for this record
			CaseFileBean file = N5Client.get().getBaseService()
					.registryEntryGetCaseFile(record.getSystemId());

			StartTagWAX currentRecordEl = rootEl.start("journalregistrering");

			currentRecordEl
					.start("saksmappe")
					.child("saksaar", ValueHelper.getYear(file.getCaseYear()))
					.child("sakssekvensnummer",
							ValueHelper.getInt0(file.getCaseSequenceNumber()))
					.child("offentligTittel", file.getOfficialTitle()).end();

			currentRecordEl
					.start("journalpost")
					.child("systemID", record.getSystemId())
					.child("journalaar",
							ValueHelper.getYear(record.getRecordYear()))
					.child("journalsekvensnummer",
							ValueHelper.getInt0(record
									.getRecordSequenceNumber()))
					.child("journalpostnummer",
							ValueHelper.getInt0(record.getRegistryEntryNumber()))
					.child("offentligTittel", record.getOfficialTitle())
					.child("journaldato",
							ValueHelper.getDate(record.getRecordDate()))
					.start("korrespondansepart")
					.child("korrespondanseparttype", "Avsender")
					.child("korrespondansepartNavn", ValueHelper.getName(null))
					.end().end();

			currentRecordEl.end();

		}

		rootEl.close();

	}

}

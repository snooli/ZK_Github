package dots.export.arkivstruktur;

import java.io.File;
import java.util.List;


import com.ociweb.xml.ElementWAX;
import com.ociweb.xml.StartTagWAX;
import com.ociweb.xml.WAX;

import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.tool.config.Config;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class FondsWriter {

	public static void writeFondsRecursive(FondsBean fonds, ElementWAX parentEl) {

		StartTagWAX fondsEl = null;
		Boolean isRoot = false;

		if (parentEl == null) {
			WAX wax = new WAX(Config.tmpRoot + File.separator
					+ "arkivstruktur.xml");
			wax.setIndent(2);

			fondsEl = wax.start("arkiv");
			fondsEl.namespace("xsi",
					"http://www.w3.org/2001/XMLSchema-instance")
					.defaultNamespace(
							"http://www.arkivverket.no/standarder/noark5/arkivstruktur")
					.namespace("n5mdk",
							"http://www.arkivverket.no/standarder/noark5/metadatakatalog");
			fondsEl.blankLine();

			isRoot = true;
		} else {
			fondsEl = parentEl.start("arkiv");
		}

		fondsEl.child("systemID", fonds.getSystemId())
				.child("tittel", fonds.getTitle())
				.child("beskrivelse", fonds.getDescription())
				.child("arkivstatus",
						ValueHelper.getFondsStatus(fonds.getFondsStatus()))
				.child("dokumentmedium", fonds.getDocumentMedium())
				.child("opprettetDato",
						ValueHelper.getDateTime(fonds.getCreatedDate()))
				.child("opprettetAv", fonds.getCreatedBy())
				.child("avsluttetDato",
						ValueHelper.getDateTime(fonds.getFinalisedDate()))
				.child("avsluttetAv",
						ValueHelper.getName(fonds.getFinalisedBy()));

		// get fonds creators
		List<FondsCreatorBean> fondsCreators = N5Client.get().getBaseService()
				.fondsGetFondsCreators(fonds.getSystemId());

		for (FondsCreatorBean fondsCreator : fondsCreators) {

			fondsEl.start("arkivskaper")
					.child("arkivskaperID", fondsCreator.getFondsCreatorId())
					.child("arkivskaperNavn",
							fondsCreator.getFondsCreatorName())
					.child("beskrivelse", fondsCreator.getDescription()).end();
		}

		// get subfonds
		List<FondsBean> childFonds = N5Client.get().getBaseService()
				.fondsGetChildFonds(fonds.getSystemId());

		// go through each of them
		for (FondsBean child : childFonds) {

			writeFondsRecursive(child, fondsEl);
		}

		// get series
		List<SeriesBean> childSeries = N5Client.get().getBaseService()
				.fondsGetSeries(fonds.getSystemId());

		// go through each of them
		for (SeriesBean series : childSeries) {

			SeriesWriter.writeSeriesRecursive(series, fondsEl);
		}

		if (isRoot) {
			// close the root element
			fondsEl.close();
		} else {
			// close the current element
			fondsEl.end();
		}

	}

}

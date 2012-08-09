package dots.export.arkivstruktur;

import java.util.List;


import com.ociweb.xml.ElementWAX;

import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.tool.helpers.ValueHelper;
import dots.tool.main.N5Client;

public class SeriesWriter {

	public static void writeSeriesRecursive(SeriesBean series,
			ElementWAX parentEl) {

		ElementWAX seriesEl = parentEl
				.start("arkivdel")
				.child("systemID", series.getSystemId())
				.child("tittel", series.getTitle())
				.child("beskrivelse", series.getDescription())
				.child("arkivdelstatus",
						ValueHelper.getSeriesStatus(series.getSeriesStatus()))
				.child("dokumentmedium", series.getDocumentMedium())
				.child("opprettetDato",
						ValueHelper.getDateTime(series.getCreatedDate()))
				.child("opprettetAv", series.getCreatedBy())
				.child("avsluttetDato",
						ValueHelper.getDateTime(series.getFinalisedDate()))
				.child("avsluttetAv",
						ValueHelper.getName(series.getFinalisedBy()));

		// get the files in this series
		List<CaseFileBean> files = N5Client.get().getBaseService()
				.seriesGetCaseFiles(series.getSystemId());

		// go through each file
		for (CaseFileBean file : files) {

			FileWriter.writeFileRecursive(file, parentEl);
		}

		seriesEl.end();

	}

}

package n5.ui.listeners.trees;

import n5.ui.helpers.FilesUIHelper;
import n5.ui.helpers.FondsUIHelper;
import n5.ui.helpers.RecordsUIHelper;
import n5.ui.helpers.SeriesUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class SelectFondsEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// get the ID of the selected fonds
		String fondsSystemId = FondsUIHelper.getSelectedFonds().getId();

		// clear series, files, and records
		SeriesUIHelper.clearSeries();
		FilesUIHelper.clearFiles();
		RecordsUIHelper.clearRecords();

		// populate the series tree
		SeriesUIHelper.populateSeries(fondsSystemId);
	}
}

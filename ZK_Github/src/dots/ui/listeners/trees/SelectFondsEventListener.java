package dots.ui.listeners.trees;

import dots.ui.helpers.FilesUIHelper;
import dots.ui.helpers.FondsUIHelper;
import dots.ui.helpers.RecordsUIHelper;
import dots.ui.helpers.SeriesUIHelper;

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

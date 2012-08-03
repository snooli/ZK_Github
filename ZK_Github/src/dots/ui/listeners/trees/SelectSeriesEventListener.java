package dots.ui.listeners.trees;

import dots.ui.helpers.FilesUIHelper;
import dots.ui.helpers.RecordsUIHelper;
import dots.ui.helpers.SeriesUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class SelectSeriesEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// get the ID of the selected series
		String seriesSystemId = SeriesUIHelper.getSelectedSeries().getId();

		// clear files and records
		FilesUIHelper.clearFiles();
		RecordsUIHelper.clearRecords();

		// populate the files tree
		FilesUIHelper.populateFiles(seriesSystemId);
	}

}

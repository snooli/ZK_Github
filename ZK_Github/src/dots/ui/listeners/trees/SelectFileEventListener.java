package dots.ui.listeners.trees;

import dots.ui.helpers.FilesUIHelper;
import dots.ui.helpers.RecordsUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class SelectFileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// get the ID of the selected file
		String fileSystemId = FilesUIHelper.getSelectedFile().getId();
		
		// clear records
		RecordsUIHelper.clearRecords();
		
		// populate the records three
		RecordsUIHelper.populateRecords(fileSystemId);

	}

}

package n5.ui.listeners.trees;

import n5.ui.helpers.FilesUIHelper;
import n5.ui.helpers.RecordsUIHelper;

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

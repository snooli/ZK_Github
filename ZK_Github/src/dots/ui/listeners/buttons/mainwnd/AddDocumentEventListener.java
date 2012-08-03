package dots.ui.listeners.buttons.mainwnd;

import dots.ui.helpers.ModalWindowHelper;
import dots.ui.helpers.RecordsUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddDocumentEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected record
		if (!RecordsUIHelper.isRecordSelected()) {
			// show an error message
			Messagebox.show("Select a Record first.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {
			ModalWindowHelper.openWindow("add_document.zul");
		}

	}

}

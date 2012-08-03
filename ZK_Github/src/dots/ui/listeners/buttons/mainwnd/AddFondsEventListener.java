package dots.ui.listeners.buttons.mainwnd;

import dots.ui.helpers.ModalWindowHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class AddFondsEventListener implements EventListener {

	@Override
	public void onEvent(Event arg0) throws Exception {

		ModalWindowHelper.openWindow("add_fonds.zul");

	}

}

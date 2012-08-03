package dots.ui.listeners.buttons.modwnd;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Fileupload;

public class DocumentUploadClickEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		Component comp = event.getTarget().getFellow("attachBtn");

		Executions.getCurrent().getDesktop()
				.setAttribute("org.zkoss.zul.Fileupload.target", comp);

		Fileupload.get(true);
	}

}

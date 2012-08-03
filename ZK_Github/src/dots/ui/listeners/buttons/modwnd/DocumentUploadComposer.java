package dots.ui.listeners.buttons.modwnd;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;

public class DocumentUploadComposer implements Composer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		comp.addEventListener("onClick", new DocumentUploadClickEventListener());
		comp.addEventListener("onUpload", new DocumentUploadDoneEventListener());

	}

}

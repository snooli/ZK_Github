package dots.ui.listeners.trees;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;

public class DoubleClickDocumentComposer implements Composer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		comp.addEventListener("onDoubleClick",
				new DoubleClickDocumentEventListener());

	}

}

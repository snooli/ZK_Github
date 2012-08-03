package n5.ui.app;

import java.io.File;

import n5.ui.config.Config;
import n5.ui.n5client.N5Client;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.DesktopCleanup;
import org.zkoss.zk.ui.util.SessionCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class InitAndCleanup implements WebAppInit, DesktopCleanup,
		SessionCleanup {

	@Override
	public void init(WebApp webapp) throws Exception {

		// get the configuration file
		File configFile = new File(webapp.getRealPath("META-INF/ui-config.xml"));

		// initialize the configuration
		Config.init(configFile);
	}

	@Override
	public void cleanup(Desktop desktop) throws Exception {

		N5Client.destroy(desktop.getSession().toString());
	}

	@Override
	public void cleanup(Session session) throws Exception {

		N5Client.destroy(session.toString());
	}

}

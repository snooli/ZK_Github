package dots.ui.app;

import java.io.File;

import dots.ui.config.Config;
import dots.ui.dotsClient.dotsClient;

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

		dotsClient.destroy(desktop.getSession().toString());
	}

	@Override
	public void cleanup(Session session) throws Exception {

		dotsClient.destroy(session.toString());
	}

}

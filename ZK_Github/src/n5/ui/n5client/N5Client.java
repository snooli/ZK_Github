package n5.ui.n5client;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import dots.module.base.service3.INoark5BaseService3;
import dots.module.base.service3.INoark5SearchService3;

import org.zkoss.zk.ui.Sessions;

public class N5Client {

	// <session ID, client>
	private static Map<String, N5ClientImpl> clients = new HashMap<String, N5ClientImpl>();

	public static N5ClientImpl get() {

		String sessionId = Sessions.getCurrent().toString();

		// create a new client
		if (!clients.containsKey(sessionId)) {
			clients.put(sessionId, new N5ClientImpl());
		}

		return clients.get(sessionId);
	}

	public static void destroy(String sessionId) {

		// remove the client associated with the current session
		if (clients.containsKey(sessionId)) {
			clients.get(sessionId).cleanup();
			clients.remove(sessionId);
		}

	}

	public static class N5ClientImpl {

		private InitialContext ctx = null;

		public N5ClientImpl() {

			try {
				Properties props = new Properties();
				props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");

				props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming.client");

				props.setProperty(Context.PROVIDER_URL, "127.0.0.1:1099");

				ctx = new InitialContext(props);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public INoark5BaseService3 getBaseService() {

			INoark5BaseService3 service = null;

			try {
				service = (INoark5BaseService3) ctx
						.lookup("Noark5BaseService3");
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return service;
		}

		public INoark5SearchService3 getSearchService() {

			INoark5SearchService3 service = null;

			try {
				service = (INoark5SearchService3) ctx
						.lookup("Noark5SearchService3");
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return service;
		}

		public void cleanup() {
			try {
				ctx.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}

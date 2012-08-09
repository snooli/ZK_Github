package dots.tool.main;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import dots.module.base.service3.INoark5BaseService3;
import dots.module.base.service3.INoark5SearchService3;
import dots.tool.config.Config;

public class N5Client {

	private static N5ClientImpl client = new N5ClientImpl();

	public static N5ClientImpl get() {

		return client;
	}

	public static class N5ClientImpl {

		private InitialContext ctx = null;

		public N5ClientImpl() {

			try {
				Properties props = new Properties();
				props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");

				props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming.client");

				props.setProperty(Context.PROVIDER_URL, Config.n5Address + ":"
						+ Config.n5Port);

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

	}

}

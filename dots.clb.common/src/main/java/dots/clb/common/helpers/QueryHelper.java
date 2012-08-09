package dots.clb.common.helpers;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QueryHelper {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Query createAndPrepareQuery(EntityManager em,
			String queryName, java.lang.Class klass, Object... params) {

		Query query = null;

		if (klass == null) {
			query = em.createNamedQuery(queryName);
		} else {
			query = em.createNamedQuery(queryName, klass);
		}

		for (int c = 0; c < params.length; c++) {
			query.setParameter(c + 1, params[c]);
		}

		return query;
	}

}

package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Keyword;
import dots.clb.common.helpers.QueryHelper;


public class LLKeywordFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Keyword> findAll(EntityManager em) {

		return (List<Keyword>) QueryHelper.createAndPrepareQuery(em,
				Queries.keywordFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static Keyword findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.keywordFindBySystemId, null, systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Keyword) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Keyword> findAllByKeyword(EntityManager em,
			String keyword) {

		return (List<Keyword>) QueryHelper.createAndPrepareQuery(em,
				Queries.keywordFindAllByKeyword, null, "%" + keyword + "%")
				.getResultList();
	}

}

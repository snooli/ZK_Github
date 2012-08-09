package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Author;
import dots.clb.common.helpers.QueryHelper;


public class LLAuthorFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Author> findAll(EntityManager em) {

		return (List<Author>) QueryHelper.createAndPrepareQuery(em,
				Queries.authorFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static Author findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.authorFindBySystemId, null, systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Author) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Author> findAllByAuthor(EntityManager em, String author) {
		return (List<Author>) QueryHelper.createAndPrepareQuery(em,
				Queries.authorFindAllByAuthor, null, "%" + author + "%")
				.getResultList();
	}

}

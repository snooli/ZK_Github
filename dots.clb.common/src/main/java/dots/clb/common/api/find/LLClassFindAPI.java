package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Class;
import dots.clb.common.helpers.QueryHelper;


public class LLClassFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Class> findAll(EntityManager em) {

		return (List<Class>) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static Class findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.classFindBySystemId, null, systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Class) resultList.get(0);
		}
	}

	public static Class findByClassId(EntityManager em, String classId) {

		return (Class) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindByClassId, null, classId).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Class> findAllByTitle(EntityManager em, String title) {

		return (List<Class>) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindAllByTitle, null, "%" + title + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Class> findAllByDescription(EntityManager em,
			String description) {

		return (List<Class>) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Class> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<Class>) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindAllByCreatedBy, null, "%" + createdBy + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Class> findAllByFinalisedBy(EntityManager em,
			String finalisedBy) {

		return (List<Class>) QueryHelper.createAndPrepareQuery(em,
				Queries.classFindAllByFinalisedBy, null,
				"%" + finalisedBy + "%").getResultList();
	}

}

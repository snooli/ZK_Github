package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.ClassificationSystem;
import dots.clb.common.helpers.QueryHelper;


public class LLClassificationSystemFindAPI {

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAll(EntityManager em) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static ClassificationSystem findBySystemId(EntityManager em,
			String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.classificationSystemFindBySystemId, null, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (ClassificationSystem) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAllByClassificationType(
			EntityManager em, String classificationType) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAllByClassificationType,
				null, classificationType).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAllByTitle(EntityManager em,
			String title) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAllByTitle, null,
				"%" + title + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAllByDescription(
			EntityManager em, String description) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAllByCreatedBy(
			EntityManager em, String createdBy) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAllByCreatedBy, null,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<ClassificationSystem> findAllByFinalisedBy(
			EntityManager em, String finalisedBy) {

		return (List<ClassificationSystem>) QueryHelper.createAndPrepareQuery(
				em, Queries.classificationSystemFindAllByFinalisedBy, null,
				"%" + finalisedBy + "%").getResultList();
	}

}

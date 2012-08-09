package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Fonds;
import dots.clb.common.helpers.QueryHelper;


public class LLFondsFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAll(EntityManager em) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAll, null).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findTopLevel(EntityManager em) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindTopLevel, null).getResultList();

	}

	@SuppressWarnings("rawtypes")
	public static Fonds findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindBySystemId, null, systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Fonds) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByTitle(EntityManager em, String title) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByTitle, null, "%" + title + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByDescription(EntityManager em,
			String description) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByFondsStatus(EntityManager em,
			String fondsStatus) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByFondsStatus, null, fondsStatus)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByDocumentMedium, null, documentMedium)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByCreatedBy, null, "%" + createdBy + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Fonds> findAllByFinalisedBy(EntityManager em,
			String finalisedBy) {

		return (List<Fonds>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsFindAllByFinalisedBy, null,
				"%" + finalisedBy + "%").getResultList();
	}

}

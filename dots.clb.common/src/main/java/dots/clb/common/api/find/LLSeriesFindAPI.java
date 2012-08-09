package dots.clb.common.api.find;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Series;
import dots.clb.common.helpers.QueryHelper;


public class LLSeriesFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Series> findAll(EntityManager em) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static Series findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindBySystemId, null, systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Series) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllByTitle(EntityManager em, String title) {
		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllByTitle, null, "%" + title + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllByDescription(EntityManager em,
			String description) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllBySeriesStatus(EntityManager em,
			String seriesStatus) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllBySeriesStatus, null, seriesStatus)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllByDocumentMedium, null, documentMedium)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllByCreatedBy, null, "%" + createdBy + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllByFinalisedBy(EntityManager em,
			String finalisedBy) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllByFinalisedBy, null,
				"%" + finalisedBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllBySeriesStartDate(EntityManager em,
			Date seriesStartDate) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllBySeriesStartDate, null, seriesStartDate)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Series> findAllBySeriesEndDate(EntityManager em,
			Date seriesEndDate) {

		return (List<Series>) QueryHelper.createAndPrepareQuery(em,
				Queries.seriesFindAllBySeriesEndDate, null, seriesEndDate)
				.getResultList();
	}

}

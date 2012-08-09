package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.BasicRecord;
import dots.clb.common.helpers.QueryHelper;


public class LLBasicRecordFindAPI {

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAll(EntityManager em) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAll, BasicRecord.class).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static BasicRecord findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindBySystemId, BasicRecord.class, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (BasicRecord) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByCreatedBy, BasicRecord.class,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByArchivedBy(EntityManager em,
			String archivedBy) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByArchivedBy, BasicRecord.class,
				"%" + archivedBy + "%").getResultList();
	}

	public static BasicRecord findByRecordId(EntityManager em, String recordId) {

		return (BasicRecord) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindByRecordId, BasicRecord.class, recordId)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByTitle(EntityManager em,
			String title) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByTitle, BasicRecord.class,
				"%" + title + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByOfficialTitle(EntityManager em,
			String officialTitle) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByOfficialTitle, BasicRecord.class,
				"%" + officialTitle + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByDescription(EntityManager em,
			String description) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByDescription, BasicRecord.class,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<BasicRecord> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<BasicRecord>) QueryHelper.createAndPrepareQuery(em,
				Queries.basicRecordFindAllByDocumentMedium, BasicRecord.class,
				documentMedium).getResultList();
	}

}

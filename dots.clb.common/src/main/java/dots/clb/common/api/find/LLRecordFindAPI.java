package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.Record;
import dots.clb.common.helpers.QueryHelper;


public class LLRecordFindAPI {

	@SuppressWarnings("unchecked")
	public static List<Record> findAll(EntityManager em) {

		return (List<Record>) QueryHelper.createAndPrepareQuery(em,
				Queries.recordFindAll, Record.class).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static Record findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.recordFindBySystemId, Record.class, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (Record) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Record> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<Record>) QueryHelper.createAndPrepareQuery(em,
				Queries.recordFindAllByCreatedBy, Record.class,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Record> findAllByArchivedBy(EntityManager em,
			String archivedBy) {

		return (List<Record>) QueryHelper.createAndPrepareQuery(em,
				Queries.recordFindAllByArchivedBy, Record.class,
				"%" + archivedBy + "%").getResultList();
	}

}

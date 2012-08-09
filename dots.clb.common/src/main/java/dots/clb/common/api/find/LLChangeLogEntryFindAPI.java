package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.ChangeLogEntry;
import dots.clb.common.helpers.QueryHelper;


public class LLChangeLogEntryFindAPI {

	@SuppressWarnings("unchecked")
	public static List<ChangeLogEntry> findAll(EntityManager em) {

		return (List<ChangeLogEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.changeLogEntryFindAll, null).getResultList();
	}

}

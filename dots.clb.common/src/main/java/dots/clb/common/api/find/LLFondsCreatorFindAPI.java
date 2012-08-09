package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.FondsCreator;
import dots.clb.common.helpers.QueryHelper;


public class LLFondsCreatorFindAPI {

	@SuppressWarnings("unchecked")
	public static List<FondsCreator> findAll(EntityManager em) {

		return (List<FondsCreator>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsCreatorFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static FondsCreator findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.fondsCreatorFindBySystemId, null, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (FondsCreator) resultList.get(0);
		}
	}

	@SuppressWarnings("rawtypes")
	public static FondsCreator findByFondsCreatorId(EntityManager em,
			String fondsCreatorId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.fondsCreatorFindByFondsCreatorId, null, fondsCreatorId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (FondsCreator) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<FondsCreator> findAllByFondsCreatorName(
			EntityManager em, String fondsCreatorName) {

		return (List<FondsCreator>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsCreatorFindAllByFondsCreatorName, null,
				"%" + fondsCreatorName + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<FondsCreator> findAllByDescription(EntityManager em,
			String description) {

		return (List<FondsCreator>) QueryHelper.createAndPrepareQuery(em,
				Queries.fondsCreatorFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

}

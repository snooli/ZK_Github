package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.StorageLocation;
import dots.clb.common.helpers.QueryHelper;


public class LLStorageLocationFindAPI {

	@SuppressWarnings("unchecked")
	public static List<StorageLocation> findAll(EntityManager em) {

		return (List<StorageLocation>) QueryHelper.createAndPrepareQuery(em,
				Queries.storageLocationFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static StorageLocation findBySystemId(EntityManager em,
			String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.storageLocationFindBySystemId, null, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (StorageLocation) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<StorageLocation> findAllByStorageLocation(
			EntityManager em, String storageLocation) {

		return (List<StorageLocation>) QueryHelper.createAndPrepareQuery(em,
				Queries.storageLocationFindAllByStorageLocation, null,
				storageLocation).getResultList();
	}

}

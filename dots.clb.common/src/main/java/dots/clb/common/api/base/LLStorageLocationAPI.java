package dots.clb.common.api.base;

import java.util.UUID;

import javax.persistence.EntityManager;

import dots.clb.common.entities.StorageLocation;


public class LLStorageLocationAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String storageLocation) {

		StorageLocation location = new StorageLocation();
		setSystemId(em, location, UUID.randomUUID().toString());

		setStorageLocation(em, location, storageLocation);

		em.persist(location);

		return location.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, StorageLocation location) {

		em.remove(location);
	}

	/** Set **/

	public void setSystemId(EntityManager em, StorageLocation location,
			String systemId) {
		if (location != null && systemId != null) {
			location.setSystemId(systemId);
		}
	}

	public void setStorageLocation(EntityManager em, StorageLocation location,
			String storageLocation) {
		if (location != null && storageLocation != null) {
			location.setStorageLocation(storageLocation);
		}
	}

}

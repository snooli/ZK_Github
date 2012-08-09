package dots.clb.common.api.base;

import java.util.UUID;

import javax.persistence.EntityManager;

import dots.clb.common.entities.FondsCreator;


public class LLFondsCreatorAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String fondsCreatorId,
			String fondsCreatorName, String description) {

		FondsCreator fondsCreator = new FondsCreator();
		setSystemId(em, fondsCreator, UUID.randomUUID().toString());

		setFondsCreatorId(em, fondsCreator, fondsCreatorId);
		setFondsCreatorName(em, fondsCreator, fondsCreatorName);
		setDescription(em, fondsCreator, description);

		em.persist(fondsCreator);

		return fondsCreator.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, FondsCreator fondsCreator) {

		em.remove(fondsCreator);
	}

	/** Set **/

	public void setSystemId(EntityManager em, FondsCreator creator,
			String systemId) {
		if (creator != null && systemId != null) {
			creator.setSystemId(systemId);
		}
	}

	public void setFondsCreatorId(EntityManager em, FondsCreator creator,
			String fondsCreatorId) {
		if (creator != null && fondsCreatorId != null) {
			creator.setFondsCreatorId(fondsCreatorId);
		}
	}

	public void setFondsCreatorName(EntityManager em, FondsCreator creator,
			String fondsCreatorName) {
		if (creator != null && fondsCreatorName != null) {
			changeLog(em, creator.getSystemId(), "arkivskaperNavn",
					creator.getFondsCreatorName(), fondsCreatorName);
			creator.setFondsCreatorName(fondsCreatorName);
		}
	}

	public void setDescription(EntityManager em, FondsCreator creator,
			String description) {
		if (creator != null && description != null) {
			creator.setDescription(description);
		}
	}

}

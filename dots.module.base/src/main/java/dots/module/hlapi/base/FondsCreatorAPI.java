package dots.module.hlapi.base;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.api.base.LLFondsCreatorAPI;
import dots.module.base.beans.Result;

public class FondsCreatorAPI {

	/** Create **/

	public static Result create(EntityManager em, String fondsCreatorId,
			String fondsCreatorName, String description) {

		if (fondsCreatorId == null) {
			throw new EJBException();
		}

		String fondsCreatorSystemId = new LLFondsCreatorAPI().create(em,
				fondsCreatorId, fondsCreatorName, description);

		return new Result(true, fondsCreatorSystemId);
	}

	/** Delete **/

	public static Result delete(String systemId) {
		// TODO
		return null;
	}

}

package dots.clb.common.api.base;

import java.util.UUID;

import javax.persistence.EntityManager;

import dots.clb.common.entities.Keyword;


public class LLKeywordAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String keyword) {

		Keyword kw = new Keyword();
		setSystemId(em, kw, UUID.randomUUID().toString());

		setKeyword(em, kw, keyword);

		em.persist(kw);

		return kw.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, Keyword keyword) {

		em.remove(keyword);
	}

	/** Set **/

	public void setSystemId(EntityManager em, Keyword keyword, String systemId) {
		if (keyword != null && systemId != null) {
			keyword.setSystemId(systemId);
		}
	}

	public void setKeyword(EntityManager em, Keyword k, String keyword) {
		if (k != null && keyword != null) {
			k.setKeyword(keyword);
		}
	}

}

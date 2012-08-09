package dots.clb.common.api.base;

import java.util.UUID;

import javax.persistence.EntityManager;

import dots.clb.common.entities.Author;


public class LLAuthorAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String author) {

		Author a = new Author();

		setSystemId(em, a, UUID.randomUUID().toString());
		setAuthor(em, a, author);

		em.persist(a);

		return a.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, Author author) {

		em.remove(author);
	}

	/** Set **/

	public void setSystemId(EntityManager em, Author author, String systemId) {
		if (author != null && systemId != null) {
			author.setSystemId(systemId);
		}
	}

	public void setAuthor(EntityManager em, Author a, String author) {
		if (a != null && author != null) {
			a.setAuthor(author);
		}
	}

}

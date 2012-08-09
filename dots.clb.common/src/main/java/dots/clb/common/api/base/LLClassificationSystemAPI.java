package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.Class;
import dots.clb.common.entities.ClassificationSystem;


public class LLClassificationSystemAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String classificationType,
			String title, String description, String createdBy) {

		ClassificationSystem cs = new ClassificationSystem();
		setSystemId(em, cs, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, cs, createdBy);
		setCreatedDate(em, cs, Calendar.getInstance().getTime());

		setClassificationType(em, cs, classificationType);
		setTitle(em, cs, title);
		setDescription(em, cs, description);

		em.persist(cs);

		return cs.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, ClassificationSystem cs) {

		em.remove(cs);
	}

	/** Add **/

	public Boolean addChildClass(ClassificationSystem cs, Class klass) {

		if (cs != null && klass != null
				&& !cs.getReferenceClass().contains(klass)
				&& klass.getReferenceClassificationSystem() == null) {

			cs.getReferenceClass().add(klass);
			klass.setReferenceClassificationSystem(cs);

			return true;
		} else {
			return false;
		}
	}

	/** Set **/

	public void setSystemId(EntityManager em, ClassificationSystem cs,
			String systemId) {
		if (cs != null && systemId != null) {
			cs.setSystemId(systemId);
		}
	}

	public void setClassificationType(EntityManager em,
			ClassificationSystem cs, String classificationType) {
		if (cs != null && classificationType != null) {
			changeLog(em, cs.getSystemId(), "klassifikasjonstype",
					cs.getClassificationType(), classificationType);
			cs.setClassificationType(classificationType);
		}
	}

	public void setTitle(EntityManager em, ClassificationSystem cs, String title) {
		if (cs != null && title != null) {
			changeLog(em, cs.getSystemId(), "tittel", cs.getTitle(), title);
			cs.setTitle(title);
		}
	}

	public void setDescription(EntityManager em, ClassificationSystem cs,
			String description) {
		if (cs != null && description != null) {
			cs.setDescription(description);
		}
	}

	public void setCreatedDate(EntityManager em, ClassificationSystem cs,
			Date createdDate) {
		if (cs != null && createdDate != null) {
			cs.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, ClassificationSystem cs,
			String createdBy) {
		if (cs != null && createdBy != null) {
			cs.setCreatedBy(createdBy);
		}
	}

	public void setFinalisedDate(EntityManager em, ClassificationSystem cs,
			Date finalisedDate) {
		if (cs != null && finalisedDate != null) {
			cs.setFinalisedDate(finalisedDate);
		}
	}

	public void setFinalisedBy(EntityManager em, ClassificationSystem cs,
			String finalisedBy) {
		if (cs != null && finalisedBy != null) {
			cs.setFinalisedBy(finalisedBy);
		}
	}

}

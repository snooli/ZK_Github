package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.Class;
import dots.clb.common.entities.File;
import dots.clb.common.entities.Keyword;
import dots.clb.common.entities.Record;


public class LLClassAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String classId, String title,
			String description, String createdBy) {

		Class klass = new Class();
		setSystemId(em, klass, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, klass, createdBy);
		setCreatedDate(em, klass, Calendar.getInstance().getTime());
		setClassId(em, klass, classId);
		setTitle(em, klass, title);
		setDescription(em, klass, description);

		em.persist(klass);

		return klass.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, Class klass) {

		em.remove(klass);
	}

	/** Add **/

	public Boolean addKeyword(Class klass, Keyword keyword) {

		if (klass != null && keyword != null
				&& !klass.getReferenceKeyword().contains(keyword)
				&& !keyword.getReferenceClass().contains(klass)) {

			klass.getReferenceKeyword().add(keyword);
			keyword.getReferenceClass().add(klass);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addChildClass(Class klass, Class child) {

		if (klass != null && child != null
				&& !klass.getReferenceChildClass().contains(child)
				&& child.getReferenceParentClass() == null) {

			klass.getReferenceChildClass().add(child);
			child.setReferenceParentClass(klass);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addFile(Class klass, File file) {

		if (klass != null & file != null
				&& !klass.getReferenceFile().contains(file)
				&& file.getReferenceClass() == null) {

			klass.getReferenceFile().add(file);
			file.setReferenceClass(klass);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addRecord(Class klass, Record record) {

		if (klass != null && record != null
				&& !klass.getReferenceRecord().contains(record)
				&& record.getReferenceClass() == null) {

			klass.getReferenceRecord().add(record);
			record.setReferenceClass(klass);

			return true;
		} else {
			return false;
		}

	}

	/** Set **/

	public void setSystemId(EntityManager em, Class klass, String systemId) {
		if (klass != null && systemId != null) {
			klass.setSystemId(systemId);
		}
	}

	public void setClassId(EntityManager em, Class klass, String classId) {
		if (klass != null && classId != null) {
			klass.setClassId(classId);
		}
	}

	public void setTitle(EntityManager em, Class klass, String title) {
		if (klass != null && title != null) {
			klass.setTitle(title);
		}
	}

	public void setDescription(EntityManager em, Class klass, String description) {
		if (klass != null && description != null) {
			klass.setDescription(description);
		}
	}

	public void setCreatedDate(EntityManager em, Class klass, Date createdDate) {
		if (klass != null && createdDate != null) {
			klass.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, Class klass, String createdBy) {
		if (klass != null && createdBy != null) {
			klass.setCreatedBy(createdBy);
		}
	}

	public void setFinalisedDate(EntityManager em, Class klass,
			Date finalisedDate) {
		if (klass != null && finalisedDate != null) {
			klass.setFinalisedDate(finalisedDate);
		}
	}

	public void setFinalisedBy(EntityManager em, Class klass, String finalisedBy) {
		if (klass != null && finalisedBy != null) {
			klass.setFinalisedBy(finalisedBy);
		}
	}

}

package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.DocumentDescription;
import dots.clb.common.entities.DocumentObject;


public class LLDocumentDescriptionAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String documentType,
			String documentStatus, String title, String description,
			String createdBy, String documentMedium) {

		DocumentDescription dd = new DocumentDescription();
		setSystemId(em, dd, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, dd, createdBy);
		setCreatedDate(em, dd, Calendar.getInstance().getTime());
		setDocumentType(em, dd, documentType);
		setDocumentStatus(em, dd, documentStatus);
		setTitle(em, dd, title);
		setDescription(em, dd, description);
		setDocumentMedium(em, dd, documentMedium);

		em.persist(dd);

		return dd.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, DocumentDescription dd) {

		em.remove(dd);
	}

	/** Add **/

	public Boolean addDocumentObject(DocumentDescription dd, DocumentObject dobj) {

		if (dd != null && dobj != null
				&& !dd.getReferenceDocumentObject().contains(dobj)
				&& dobj.getReferenceDocumentDescription() == null) {

			dd.getReferenceDocumentObject().add(dobj);
			dobj.setReferenceDocumentDescription(dd);

			return true;
		} else {
			return false;
		}
	}

	/** Set **/

	public void setSystemId(EntityManager em, DocumentDescription dd,
			String systemId) {
		if (dd != null && systemId != null) {
			dd.setSystemId(systemId);
		}
	}

	public void setDocumentType(EntityManager em, DocumentDescription dd,
			String documentType) {
		if (dd != null && documentType != null) {
			dd.setDocumentType(documentType);
		}
	}

	public void setDocumentStatus(EntityManager em, DocumentDescription dd,
			String documentStatus) {
		if (dd != null && documentStatus != null) {
			changeLog(em, dd.getSystemId(), "dokumentstatus",
					dd.getDocumentStatus(), documentStatus);
			dd.setDocumentStatus(documentStatus);
		}
	}

	public void setTitle(EntityManager em, DocumentDescription dd, String title) {
		if (dd != null && title != null) {
			changeLog(em, dd.getSystemId(), "tittel", dd.getTitle(), title);
			dd.setTitle(title);
		}
	}

	public void setDescription(EntityManager em, DocumentDescription dd,
			String description) {
		if (dd != null && description != null) {
			dd.setDescription(description);
		}
	}

	public void setCreatedDate(EntityManager em, DocumentDescription dd,
			Date createdDate) {
		if (dd != null && createdDate != null) {
			dd.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, DocumentDescription dd,
			String createdBy) {
		if (dd != null && createdBy != null) {
			dd.setCreatedBy(createdBy);
		}
	}

	public void setDocumentMedium(EntityManager em, DocumentDescription dd,
			String documentMedium) {
		if (dd != null && documentMedium != null) {
			dd.setDocumentMedium(documentMedium);
		}
	}

	public void setAssociatedWithRecordAs(EntityManager em,
			DocumentDescription dd, String associatedWithRecordAs) {
		if (dd != null && associatedWithRecordAs != null) {
			dd.setAssociatedWithRecordAs(associatedWithRecordAs);
		}
	}

	public void setDocumentNumber(EntityManager em, DocumentDescription dd,
			Integer documentNumber) {
		if (dd != null && documentNumber != null) {
			dd.setDocumentNumber(documentNumber);
		}
	}

	public void setAssociationDate(EntityManager em, DocumentDescription dd,
			Date associationDate) {
		if (dd != null && associationDate != null) {
			dd.setAssociationDate(associationDate);
		}
	}

	public void setAssociatedBy(EntityManager em, DocumentDescription dd,
			String associatedBy) {
		if (dd != null && associatedBy != null) {
			dd.setAssociatedBy(associatedBy);
		}
	}

}

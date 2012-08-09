package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.DocumentDescription;
import dots.clb.common.entities.DocumentObject;
import dots.clb.common.entities.Record;


public class LLRecordAPI extends LLChangeLogAPI {

	/** Create **/

	public String createRecord(EntityManager em, String createdBy) {

		Record record = new Record();
		setSystemId(em, record, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, record, createdBy);
		setCreatedDate(em, record, Calendar.getInstance().getTime());

		em.persist(record);

		return record.getSystemId();
	}

	/** Delete **/

	public void deleteRecord(EntityManager em, Record record) {

		em.remove(record);
	}

	/** Add **/

	public Boolean addDocumentDescription(Record record, DocumentDescription dd) {

		if (record != null && dd != null
				&& !record.getReferenceDocumentDescription().contains(dd)
				&& !dd.getReferenceRecord().contains(record)) {

			record.getReferenceDocumentDescription().add(dd);
			dd.getReferenceRecord().add(record);

			return true;
		} else {
			return false;
		}

	}

	public Boolean addDocumentObject(Record record, DocumentObject dobj) {

		if (record != null && dobj != null
				&& !record.getReferenceDocumentObject().contains(dobj)
				&& dobj.getReferenceRecord() == null) {

			record.getReferenceDocumentObject().add(dobj);
			dobj.setReferenceRecord(record);

			return true;
		} else {
			return false;
		}

	}

	/** Set **/

	public void setSystemId(EntityManager em, Record record, String systemId) {
		if (record != null && systemId != null) {
			record.setSystemId(systemId);
		}
	}

	public void setCreatedDate(EntityManager em, Record record, Date createdDate) {
		if (record != null && createdDate != null) {
			record.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, Record record, String createdBy) {
		if (record != null && createdBy != null) {
			record.setCreatedBy(createdBy);
		}
	}

	public void setArchivedDate(EntityManager em, Record record,
			Date archivedDate) {
		if (record != null && archivedDate != null) {
			record.setArchivedDate(archivedDate);
		}
	}

	public void setArchivedBy(EntityManager em, Record record, String archivedBy) {
		if (record != null && archivedBy != null) {
			record.setArchivedBy(archivedBy);
		}
	}

}

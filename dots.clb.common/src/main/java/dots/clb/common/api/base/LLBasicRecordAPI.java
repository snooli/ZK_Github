package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.BasicRecord;
import dots.clb.common.entities.StorageLocation;


public class LLBasicRecordAPI extends LLRecordAPI {

	/** Create **/

	public String createBasicRecord(EntityManager em, String createdBy,
			String recordId, String title, String officialTitle,
			String description, String documentMedium) {

		BasicRecord record = new BasicRecord();
		setSystemId(em, record, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, record, createdBy);
		setCreatedDate(em, record, Calendar.getInstance().getTime());
		setRecordId(em, record, recordId);
		setTitle(em, record, title);
		setOfficialTitle(em, record, officialTitle);
		setDescription(em, record, description);
		setDocumentMedium(em, record, documentMedium);

		em.persist(record);

		return record.getSystemId();
	}

	/** Delete **/

	public void deleteBasicRecord(EntityManager em, BasicRecord record) {

		em.remove(record);
	}

	/** Set **/

	public Boolean setStorageLocation(BasicRecord record,
			StorageLocation location) {

		if (record != null & location != null
				&& record.getReferenceStorageLocation() == null
				&& !location.getReferenceRecord().contains(record)) {

			record.setReferenceStorageLocation(location);
			location.getReferenceRecord().add(record);

			return true;
		} else {
			return false;
		}
	}

	public void setRecordId(EntityManager em, BasicRecord record,
			String recordId) {
		if (record != null && recordId != null) {
			record.setRecordId(recordId);
		}
	}

	public void setTitle(EntityManager em, BasicRecord record, String title) {
		if (record != null && title != null) {
			changeLog(em, record.getSystemId(), "tittel", record.getTitle(),
					title);
			record.setTitle(title);
		}
	}

	public void setOfficialTitle(EntityManager em, BasicRecord record,
			String officialTitle) {
		if (record != null && officialTitle != null) {
			record.setOfficialTitle(officialTitle);
		}
	}

	public void setDescription(EntityManager em, BasicRecord record,
			String description) {
		if (record != null && description != null) {
			record.setDescription(description);
		}
	}

	public void setDocumentMedium(EntityManager em, BasicRecord record,
			String documentMedium) {
		if (record != null && documentMedium != null) {
			record.setDocumentMedium(documentMedium);
		}
	}

}

package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.File;
import dots.clb.common.entities.Keyword;
import dots.clb.common.entities.Record;
import dots.clb.common.entities.StorageLocation;


public class LLFileAPI extends LLChangeLogAPI {

	/** Create **/

	public String createFile(EntityManager em, String fileId, String title,
			String officialTitle, String description, String documentMedium,
			String createdBy) {

		File file = new File();
		setSystemId(em, file, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, file, createdBy);
		setCreatedDate(em, file, Calendar.getInstance().getTime());
		setFileId(em, file, fileId);
		setTitle(em, file, title);
		setOfficialTitle(em, file, officialTitle);
		setDescription(em, file, description);
		setDocumentMedium(em, file, documentMedium);

		em.persist(file);

		return file.getSystemId();
	}

	/** Delete **/

	public void deleteFile(EntityManager em, File file) {

		em.remove(file);
	}

	/** Add **/

	public Boolean addKeyword(File file, Keyword keyword) {

		if (file != null && keyword != null
				&& !file.getReferenceKeyword().contains(keyword)
				&& !keyword.getReferenceFile().contains(file)) {

			file.getReferenceKeyword().add(keyword);
			keyword.getReferenceFile().add(file);

			return true;
		} else {
			return true;
		}
	}

	public Boolean addChildFile(File file, File childFile) {

		if (file != null && childFile != null
				&& !file.getReferenceChildFile().contains(childFile)
				&& childFile.getReferenceParentFile() == null) {

			file.getReferenceChildFile().add(childFile);
			childFile.setReferenceParentFile(file);

			return true;
		} else {
			return false;
		}

	}

	public Boolean addRecord(File file, Record record) {

		if (file != null && record != null
				&& !file.getReferenceRecord().contains(record)
				&& record.getReferenceFile() == null) {

			file.getReferenceRecord().add(record);
			record.setReferenceFile(file);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addStorageLocation(File file, StorageLocation location) {

		if (file != null && location != null
				&& file.getReferenceStorageLocation() == null
				&& !location.getReferenceFile().contains(file)) {

			file.setReferenceStorageLocation(location);
			location.getReferenceFile().add(file);

			return true;
		} else {
			return false;
		}
	}

	/** Set **/

	public void setSystemId(EntityManager em, File file, String systemId) {
		if (file != null && systemId != null) {
			file.setSystemId(systemId);
		}
	}

	public void setFileId(EntityManager em, File file, String fileId) {
		if (file != null && fileId != null) {
			file.setFileId(fileId);
		}
	}

	public void setTitle(EntityManager em, File file, String title) {
		if (file != null && title != null) {
			changeLog(em, file.getSystemId(), "tittel", file.getTitle(), title);
			file.setTitle(title);
		}
	}

	public void setOfficialTitle(EntityManager em, File file,
			String officialTitle) {
		if (file != null && officialTitle != null) {
			file.setOfficialTitle(officialTitle);
		}
	}

	public void setDescription(EntityManager em, File file, String description) {
		if (file != null && description != null) {
			file.setDescription(description);
		}
	}

	public void setDocumentMedium(EntityManager em, File file,
			String documentMedium) {
		if (file != null && documentMedium != null) {
			file.setDocumentMedium(documentMedium);
		}
	}

	public void setCreatedDate(EntityManager em, File file, Date createdDate) {
		if (file != null && createdDate != null) {
			file.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, File file, String createdBy) {
		if (file != null && createdBy != null) {
			file.setCreatedBy(createdBy);
		}
	}

	public void setFinalisedDate(EntityManager em, File file, Date finalisedDate) {
		if (file != null && finalisedDate != null) {
			file.setFinalisedDate(finalisedDate);
		}
	}

	public void setFinalisedBy(EntityManager em, File file, String finalisedBy) {
		if (file != null && finalisedBy != null) {
			file.setFinalisedBy(finalisedBy);
		}
	}

}

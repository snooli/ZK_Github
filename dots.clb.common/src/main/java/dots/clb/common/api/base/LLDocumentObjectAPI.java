package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.DocumentObject;


public class LLDocumentObjectAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, Integer versionNumber,
			String variantFormat, String format, String formatDetails,
			String createdBy, String referenceDocumentFile, String checksum,
			String checksumAlgorithm, Long fileSize) {

		DocumentObject dobj = new DocumentObject();
		setSystemId(em, dobj, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, dobj, createdBy);
		setCreatedDate(em, dobj, Calendar.getInstance().getTime());
		setVersionNumber(em, dobj, versionNumber);
		setVariantFormat(em, dobj, variantFormat);
		setFormat(em, dobj, format);
		setFormatDetails(em, dobj, formatDetails);
		setReferenceDocumentFile(em, dobj, referenceDocumentFile);
		setChecksum(em, dobj, checksum);
		setChecksumAlgorithm(em, dobj, checksumAlgorithm);
		setFileSize(em, dobj, fileSize);

		em.persist(dobj);

		return dobj.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, DocumentObject dobj) {

		em.remove(dobj);
	}

	/** Set **/

	public void setSystemId(EntityManager em, DocumentObject dobj,
			String systemId) {
		if (dobj != null && systemId != null) {
			dobj.setSystemId(systemId);
		}
	}

	public void setVersionNumber(EntityManager em, DocumentObject dobj,
			Integer versionNumber) {
		if (dobj != null && versionNumber != null) {
			dobj.setVersionNumber(versionNumber);
		}
	}

	public void setVariantFormat(EntityManager em, DocumentObject dobj,
			String variantFormat) {
		if (dobj != null && variantFormat != null) {
			dobj.setVariantFormat(variantFormat);
		}
	}

	public void setFormat(EntityManager em, DocumentObject dobj, String format) {
		if (dobj != null && format != null) {
			dobj.setFormat(format);
		}
	}

	public void setFormatDetails(EntityManager em, DocumentObject dobj,
			String formatDetails) {
		if (dobj != null && formatDetails != null) {
			dobj.setFormatDetails(formatDetails);
		}
	}

	public void setCreatedDate(EntityManager em, DocumentObject dobj,
			Date createdDate) {
		if (dobj != null && createdDate != null) {
			dobj.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, DocumentObject dobj,
			String createdBy) {
		if (dobj != null && createdBy != null) {
			dobj.setCreatedBy(createdBy);
		}
	}

	public void setReferenceDocumentFile(EntityManager em, DocumentObject dobj,
			String referenceDocumentFile) {
		if (dobj != null && referenceDocumentFile != null) {
			changeLog(em, dobj.getSystemId(), "referanseDokumentfil",
					dobj.getReferenceDocumentFile(), referenceDocumentFile);
			dobj.setReferenceDocumentFile(referenceDocumentFile);
		}
	}

	public void setChecksum(EntityManager em, DocumentObject dobj,
			String checksum) {
		if (dobj != null && checksum != null) {
			dobj.setChecksum(checksum);
		}
	}

	public void setChecksumAlgorithm(EntityManager em, DocumentObject dobj,
			String checksumAlgorithm) {
		if (dobj != null && checksumAlgorithm != null) {
			dobj.setChecksumAlgorithm(checksumAlgorithm);
		}
	}

	public void setFileSize(EntityManager em, DocumentObject dobj, Long fileSize) {
		if (dobj != null && fileSize != null) {
			dobj.setFileSize(fileSize);
		}
	}

}

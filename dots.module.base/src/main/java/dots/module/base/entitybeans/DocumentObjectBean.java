package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class DocumentObjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M005 - versjonsnummer */
	protected int versionNumber;

	/** M700 - variantformat */
	protected String variantFormat;

	/** M701 - format */
	protected String format;

	/** M702 - formatDetaljer */
	protected String formatDetails;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M218 - referanseDokumentfil */
	protected String referenceDocumentFile;

	/** M705 - sjekksum */
	protected String checksum;

	/** M706 - sjekksumAlgoritme */
	protected String checksumAlgorithm;

	/** M707 - filstoerrelse */
	protected Long fileSize;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M005 - versjonsnummer */
	public int getVersionNumber() {
		return versionNumber;
	}

	/** M005 - versjonsnummer */
	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	/** M700 - variantformat */
	public String getVariantFormat() {
		return variantFormat;
	}

	/** M700 - variantformat */
	public void setVariantFormat(String variantFormat) {
		this.variantFormat = variantFormat;
	}

	/** M701 - format */
	public String getFormat() {
		return format;
	}

	/** M701 - format */
	public void setFormat(String format) {
		this.format = format;
	}

	/** M702 - formatDetaljer */
	public String getFormatDetails() {
		return formatDetails;
	}

	/** M702 - formatDetaljer */
	public void setFormatDetails(String formatDetails) {
		this.formatDetails = formatDetails;
	}

	/** M600 - opprettetDato */
	public Date getCreatedDate() {
		return createdDate;
	}

	/** M600 - opprettetDato */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/** M601 - opprettetAv */
	public String getCreatedBy() {
		return createdBy;
	}

	/** M601 - opprettetAv */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/** M218 - referanseDokumentfil */
	public String getReferenceDocumentFile() {
		return referenceDocumentFile;
	}

	/** M218 - referanseDokumentfil */
	public void setReferenceDocumentFile(String referenceDocumentFile) {
		this.referenceDocumentFile = referenceDocumentFile;
	}

	/** M705 - sjekksum */
	public String getChecksum() {
		return checksum;
	}

	/** M705 - sjekksum */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/** M706 - sjekksumAlgoritme */
	public String getChecksumAlgorithm() {
		return checksumAlgorithm;
	}

	/** M706 - sjekksumAlgoritme */
	public void setChecksumAlgorithm(String checksumAlgorithm) {
		this.checksumAlgorithm = checksumAlgorithm;
	}

	/** M707 - filstoerrelse */
	public Long getFileSize() {
		return fileSize;
	}

	/** M707 - filstoerrelse */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

}

package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class DocumentDescriptionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M083 - dokumenttype */
	protected String documentType;

	/** M054 - dokumentstatus */
	protected String documentStatus;

	/** M020 - tittel */
	protected String title;

	/** M021 - beskrivelse */
	protected String description;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M300 - dokumentmedium */
	protected String documentMedium;

	/** M217 - tilknyttetRegistreringSom */
	protected String associatedWithRecordAs;

	/** M007 - dokumentnummer */
	protected Integer documentNumber;

	/** M620 - tilknyttetDato */
	protected Date associationDate;

	/** M621 - tilknyttetAv */
	protected String associatedBy;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M083 - dokumenttype */
	public String getDocumentType() {
		return documentType;
	}

	/** M083 - dokumenttype */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	/** M054 - dokumentstatus */
	public String getDocumentStatus() {
		return documentStatus;
	}

	/** M054 - dokumentstatus */
	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	/** M020 - tittel */
	public String getTitle() {
		return title;
	}

	/** M020 - tittel */
	public void setTitle(String title) {
		this.title = title;
	}

	/** M601 - opprettetAv */

	/** M021 - beskrivelse */
	public String getDescription() {
		return description;
	}

	/** M021 - beskrivelse */
	public void setDescription(String description) {
		this.description = description;
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

	/** M300 - dokumentmedium */
	public String getDocumentMedium() {
		return documentMedium;
	}

	/** M300 - dokumentmedium */
	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
	}

	/** M217 - tilknyttetRegistreringSom */
	public String getAssociatedWithRecordAs() {
		return associatedWithRecordAs;
	}

	/** M217 - tilknyttetRegistreringSom */
	public void setAssociatedWithRecordAs(String associatedWithRecordAs) {
		this.associatedWithRecordAs = associatedWithRecordAs;
	}

	/** M007 - dokumentnummer */
	public Integer getDocumentNumber() {
		return documentNumber;
	}

	/** M007 - dokumentnummer */
	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	/** M620 - tilknyttetDato */
	public Date getAssociationDate() {
		return associationDate;
	}

	/** M620 - tilknyttetDato */
	public void setAssociationDate(Date associationDate) {
		this.associationDate = associationDate;
	}

	/** M621 - tilknyttetAv */
	public String getAssociatedBy() {
		return associatedBy;
	}

	/** M621 - tilknyttetAv */
	public void setAssociatedBy(String associatedBy) {
		this.associatedBy = associatedBy;
	}

}

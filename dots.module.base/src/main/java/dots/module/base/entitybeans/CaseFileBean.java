package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class CaseFileBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M003 - mappeID */
	protected String fileId;

	/** M020 - tittel */
	protected String title;

	/** M025 - offentligTittel */
	protected String officialTitle;

	/** M021 - beskrivelse */
	protected String description;

	/** M300 - dokumentmedium */
	protected String documentMedium;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M602 - avsluttetDato */
	protected Date finalisedDate;

	/** M603 - avsluttetAv */
	protected String finalisedBy;

	/** M011 - saksaar */
	protected Integer caseYear;

	/** M012 - sakssekvensnummer */
	protected Integer caseSequenceNumber;

	/** M100 - saksdato */
	protected Date caseDate;

	/** M305 - administrativEnhet */
	protected String administrativeUnit;

	/** M306 - saksansvarlig */
	protected String caseResponsible;

	/** M308 - journalenhet */
	protected String recordsManagementUnit;

	/** M052 - saksstatus */
	protected String caseStatus;

	/** M106 - utlaantDato */
	protected Date loanedDate;

	/** M309 - utlaantTil */
	protected String loanedTo;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M003 - mappeID */
	public String getFileId() {
		return fileId;
	}

	/** M003 - mappeID */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/** M020 - tittel */
	public String getTitle() {
		return title;
	}

	/** M020 - tittel */
	public void setTitle(String title) {
		this.title = title;
	}

	/** M025 - offentligTittel */
	public String getOfficialTitle() {
		return officialTitle;
	}

	/** M025 - offentligTittel */
	public void setOfficialTitle(String officialTitle) {
		this.officialTitle = officialTitle;
	}

	/** M021 - beskrivelse */
	public String getDescription() {
		return description;
	}

	/** M021 - beskrivelse */
	public void setDescription(String description) {
		this.description = description;
	}

	/** M300 - dokumentmedium */
	public String getDocumentMedium() {
		return documentMedium;
	}

	/** M300 - dokumentmedium */
	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
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

	/** M602 - avsluttetDato */
	public Date getFinalisedDate() {
		return finalisedDate;
	}

	/** M602 - avsluttetDato */
	public void setFinalisedDate(Date finalisedDate) {
		this.finalisedDate = finalisedDate;
	}

	/** M603 - avsluttetAv */
	public String getFinalisedBy() {
		return finalisedBy;
	}

	/** M603 - avsluttetAv */
	public void setFinalisedBy(String finalisedBy) {
		this.finalisedBy = finalisedBy;
	}

	/** M011 - saksaar */
	public Integer getCaseYear() {
		return caseYear;
	}

	/** M011 - saksaar */
	public void setCaseYear(Integer caseYear) {
		this.caseYear = caseYear;
	}

	/** M012 - sakssekvensnummer */
	public Integer getCaseSequenceNumber() {
		return caseSequenceNumber;
	}

	/** M012 - sakssekvensnummer */
	public void setCaseSequenceNumber(Integer caseSequenceNumber) {
		this.caseSequenceNumber = caseSequenceNumber;
	}

	/** M100 - saksdato */
	public Date getCaseDate() {
		return caseDate;
	}

	/** M100 - saksdato */
	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	/** M305 - administrativEnhet */
	public String getAdministrativeUnit() {
		return administrativeUnit;
	}

	/** M305 - administrativEnhet */
	public void setAdministrativeUnit(String administrativeUnit) {
		this.administrativeUnit = administrativeUnit;
	}

	/** M306 - saksansvarlig */
	public String getCaseResponsible() {
		return caseResponsible;
	}

	/** M306 - saksansvarlig */
	public void setCaseResponsible(String caseResponsible) {
		this.caseResponsible = caseResponsible;
	}

	/** M308 - journalenhet */
	public String getRecordsManagementUnit() {
		return recordsManagementUnit;
	}

	/** M308 - journalenhet */
	public void setRecordsManagementUnit(String recordsManagementUnit) {
		this.recordsManagementUnit = recordsManagementUnit;
	}

	/** M052 - saksstatus */
	public String getCaseStatus() {
		return caseStatus;
	}

	/** M052 - saksstatus */
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	/** M106 - utlaantDato */
	public Date getLoanedDate() {
		return loanedDate;
	}

	/** M106 - utlaantDato */
	public void setLoanedDate(Date loanedDate) {
		this.loanedDate = loanedDate;
	}

	/** M309 - utlaantTil */
	public String getLoanedTo() {
		return loanedTo;
	}

	/** M309 - utlaantTil */
	public void setLoanedTo(String loanedTo) {
		this.loanedTo = loanedTo;
	}

}

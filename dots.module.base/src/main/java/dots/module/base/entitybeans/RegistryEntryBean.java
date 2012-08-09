package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class RegistryEntryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M604 - arkivertDato */
	protected Date archivedDate;

	/** M605 - arkivertAv */
	protected String archivedBy;

	/** M004 - registreringsID */
	protected String recordId;

	/** M020 - tittel */
	protected String title;

	/** M025 - offentligTittel */
	protected String officialTitle;

	/** M021 - beskrivelse */
	protected String description;

	/** M300 - dokumentmedium */
	protected String documentMedium;

	/** M013 - journalaar */
	protected Integer recordYear;

	/** M014 - journalsekvensnummer */
	protected Integer recordSequenceNumber;

	/** M015 - journalpostnummer */
	protected Integer registryEntryNumber;

	/** M082 - journalposttype */
	protected String registryEntryType;

	/** M053 - journalstatus */
	protected String recordStatus;

	/** M101 - journaldato */
	protected Date recordDate;

	/** M103 - dokumentetsDato */
	protected Date documentDate;

	/** M104 - mottattDato */
	protected Date receivedDate;

	/** M105 - sendtDato */
	protected Date sentDate;

	/** M109 - forfallsdato */
	protected Date dueDate;

	/** M110 - offentlighetsvurdertDato */
	protected Date freedomAssessmentDate;

	/** M304 - antallVedlegg */
	protected Integer numberOfAttachments;

	/** M106 - utlaantDato */
	protected Date loanedDate;

	/** M309 - utlaantTil */
	protected Date loanedTo;

	/** M308 - journalenhet */
	protected String recordsManagementUnit;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	/** M604 - arkivertDato */
	public Date getArchivedDate() {
		return archivedDate;
	}

	/** M604 - arkivertDato */
	public void setArchivedDate(Date archivedDate) {
		this.archivedDate = archivedDate;
	}

	/** M605 - arkivertAv */
	public String getArchivedBy() {
		return archivedBy;
	}

	/** M605 - arkivertAv */
	public void setArchivedBy(String archivedBy) {
		this.archivedBy = archivedBy;
	}

	/** M004 - registreringsID */
	public String getRecordId() {
		return recordId;
	}

	/** M004 - registreringsID */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
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

	/** M013 - journalaar */
	public Integer getRecordYear() {
		return recordYear;
	}

	/** M013 - journalaar */
	public void setRecordYear(Integer recordYear) {
		this.recordYear = recordYear;
	}

	/** M014 - journalsekvensnummer */
	public Integer getRecordSequenceNumber() {
		return recordSequenceNumber;
	}

	/** M014 - journalsekvensnummer */
	public void setRecordSequenceNumber(Integer recordSequenceNumber) {
		this.recordSequenceNumber = recordSequenceNumber;
	}

	/** M015 - journalpostnummer */
	public Integer getRegistryEntryNumber() {
		return registryEntryNumber;
	}

	/** M015 - journalpostnummer */
	public void setRegistryEntryNumber(Integer registryEntryNumber) {
		this.registryEntryNumber = registryEntryNumber;
	}

	/** M082 - journalposttype */
	public String getRegistryEntryType() {
		return registryEntryType;
	}

	/** M082 - journalposttype */
	public void setRegistryEntryType(String registryEntryType) {
		this.registryEntryType = registryEntryType;
	}

	/** M053 - journalstatus */
	public String getRecordStatus() {
		return recordStatus;
	}

	/** M053 - journalstatus */
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	/** M101 - journaldato */
	public Date getRecordDate() {
		return recordDate;
	}

	/** M101 - journaldato */
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	/** M103 - dokumentetsDato */
	public Date getDocumentDate() {
		return documentDate;
	}

	/** M103 - dokumentetsDato */
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	/** M104 - mottattDato */
	public Date getReceivedDate() {
		return receivedDate;
	}

	/** M104 - mottattDato */
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	/** M105 - sendtDato */
	public Date getSentDate() {
		return sentDate;
	}

	/** M105 - sendtDato */
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	/** M109 - forfallsdato */
	public Date getDueDate() {
		return dueDate;
	}

	/** M109 - forfallsdato */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/** M110 - offentlighetsvurdertDato */
	public Date getFreedomAssessmentDate() {
		return freedomAssessmentDate;
	}

	/** M110 - offentlighetsvurdertDato */
	public void setFreedomAssessmentDate(Date freedomAssessmentDate) {
		this.freedomAssessmentDate = freedomAssessmentDate;
	}

	/** M304 - antallVedlegg */
	public Integer getNumberOfAttachments() {
		return numberOfAttachments;
	}

	/** M304 - antallVedlegg */
	public void setNumberOfAttachments(Integer numberOfAttachments) {
		this.numberOfAttachments = numberOfAttachments;
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
	public Date getLoanedTo() {
		return loanedTo;
	}

	/** M309 - utlaantTil */
	public void setLoanedTo(Date loanedTo) {
		this.loanedTo = loanedTo;
	}

	/** M308 - journalenhet */
	public String getRecordsManagementUnit() {
		return recordsManagementUnit;
	}

	/** M308 - journalenhet */
	public void setRecordsManagementUnit(String recordsManagementUnit) {
		this.recordsManagementUnit = recordsManagementUnit;
	}

}

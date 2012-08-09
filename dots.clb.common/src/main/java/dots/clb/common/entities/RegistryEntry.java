package dots.clb.common.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "registry_entry")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(
		name = Queries.registryEntryFindAll,
		query = "SELECT re FROM RegistryEntry re"
	),
	@NamedQuery(
		name = Queries.registryEntryFindBySystemId,
		query = "SELECT re FROM RegistryEntry re WHERE re.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByCreatedBy,
		query = "SELECT re FROM RegistryEntry re WHERE re.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByArchivedBy,
		query = "SELECT re FROM RegistryEntry re WHERE re.archivedBy LIKE ?1"
	),	
	@NamedQuery(
		name = Queries.registryEntryFindByRecordId, 
		query = "SELECT re FROM RegistryEntry re WHERE re.recordId = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByTitle, 
		query = "SELECT re FROM RegistryEntry re WHERE re.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByOfficialTitle, 
		query = "SELECT re FROM RegistryEntry re WHERE re.officialTitle LIKE ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByDescription, 
		query = "SELECT re FROM RegistryEntry re WHERE re.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByDocumentMedium, 
		query = "SELECT re FROM RegistryEntry re WHERE re.documentMedium = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRecordYear,
		query = "SELECT re FROM RegistryEntry re WHERE re.recordYear = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRecordSequenceNumber,
		query = "SELECT re FROM RegistryEntry re WHERE re.recordSequenceNumber = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRegistryEntryNumber,
		query = "SELECT re FROM RegistryEntry re WHERE re.registryEntryNumber = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRegistryEntryType,
		query = "SELECT re FROM RegistryEntry re WHERE re.registryEntryType = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRecordStatus,
		query = "SELECT re FROM RegistryEntry re WHERE re.recordStatus = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRecordDate,
		query = "SELECT re FROM RegistryEntry re WHERE re.recordDate = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByDocumentDate,
		query = "SELECT re FROM RegistryEntry re WHERE re.documentDate = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByDueDate,
		query = "SELECT re FROM RegistryEntry re WHERE re.dueDate = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByFreedomAssessmentDate,
		query = "SELECT re FROM RegistryEntry re WHERE re.freedomAssessmentDate = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByNumberOfAttachments,
		query = "SELECT re FROM RegistryEntry re WHERE re.numberOfAttachments = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByLoanedDate,
		query = "SELECT re FROM RegistryEntry re WHERE re.loanedDate = ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByLoanedTo,
		query = "SELECT re FROM RegistryEntry re WHERE re.loanedTo LIKE ?1"
	),
	@NamedQuery(
		name = Queries.registryEntryFindAllByRecordsManagementUnit,
		query = "SELECT re FROM RegistryEntry re WHERE re.recordsManagementUnit = ?1"
	)
})
public class RegistryEntry extends BasicRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M013 - journalaar (xs:integer) */
	@Column(name="record_year")
	protected Integer recordYear;
	
	/** M014 - journalsekvensnummer (xs:integer) */
	@Column(name="record_sequence_number")
	protected Integer recordSequenceNumber;
	
	/** M015 - journalpostnummer (xs:integer) */
	@Column(name="registry_entry_number")
	protected Integer registryEntryNumber;
	
	/** M082 - journalposttype (xs:string) */
	@Column(name="registry_entry_type")
	protected String registryEntryType;
	
	/** M053 - journalstatus (xs:string) */
	@Column(name="record_status")
	protected String recordStatus;

	/** M101 - journaldato (xs:date) */
	@Column(name="record_date")
	@Temporal(TemporalType.DATE)
	protected Date recordDate;
	
	/** M103 - dokumentetsDato (xs:date) */
	@Column(name="document_date")
	@Temporal(TemporalType.DATE)
	protected Date documentDate;

	/** M104 - mottattDato (xs:dateTime) */
	@Column(name="received_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date receivedDate;

	/** M105 - sendtDato (xs:dateTime) */ 
	@Column(name="sent_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date sentDate;
	
	/** M109 - forfallsdato (xs:date) */
	@Column(name="due_date")
	@Temporal(TemporalType.DATE)
	protected Date dueDate;

	/** M110 - offentlighetsvurdertDato (xs:date) */
	@Column(name="freedom_assessment_date")
	@Temporal(TemporalType.DATE)
	protected Date freedomAssessmentDate;
	
	/** M304 - antallVedlegg (xs:integer) */
	@Column(name="number_of_attachments")
	protected Integer numberOfAttachments;
	
	/** M106 - utlaantDato (xs:date) */
	@Column(name="loaned_date")
	@Temporal(TemporalType.DATE)
	protected Date loanedDate;
	
	/** M309 - utlaantTil (xs:string) */
	@Column(name="loaned_to")
	protected Date loanedTo;
	
	/** M308 - journalenhet (xs:string) */
	@Column(name="records_management_unit")
	protected String recordsManagementUnit;

	public Integer getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(Integer recordYear) {
		this.recordYear = recordYear;
	}

	public Integer getRecordSequenceNumber() {
		return recordSequenceNumber;
	}

	public void setRecordSequenceNumber(Integer recordSequenceNumber) {
		this.recordSequenceNumber = recordSequenceNumber;
	}

	public Integer getRegistryEntryNumber() {
		return registryEntryNumber;
	}

	public void setRegistryEntryNumber(Integer registryEntryNumber) {
		this.registryEntryNumber = registryEntryNumber;
	}

	public String getRegistryEntryType() {
		return registryEntryType;
	}

	public void setRegistryEntryType(String registryEntryType) {
		this.registryEntryType = registryEntryType;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getFreedomAssessmentDate() {
		return freedomAssessmentDate;
	}

	public void setFreedomAssessmentDate(Date freedomAssessmentDate) {
		this.freedomAssessmentDate = freedomAssessmentDate;
	}

	public Integer getNumberOfAttachments() {
		return numberOfAttachments;
	}

	public void setNumberOfAttachments(Integer numberOfAttachments) {
		this.numberOfAttachments = numberOfAttachments;
	}

	public Date getLoanedDate() {
		return loanedDate;
	}

	public void setLoanedDate(Date loanedDate) {
		this.loanedDate = loanedDate;
	}

	public Date getLoanedTo() {
		return loanedTo;
	}

	public void setLoanedTo(Date loanedTo) {
		this.loanedTo = loanedTo;
	}

	public String getRecordsManagementUnit() {
		return recordsManagementUnit;
	}

	public void setRecordsManagementUnit(String recordsManagementUnit) {
		this.recordsManagementUnit = recordsManagementUnit;
	}

}

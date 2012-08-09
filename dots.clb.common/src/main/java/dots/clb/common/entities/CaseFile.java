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
@Table(name = "case_file")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(
		name = Queries.caseFileFindAll,
		query = "SELECT cf FROM CaseFile cf"
	),
	@NamedQuery(
		name = Queries.caseFileFindBySystemId,
		query = "SELECT cf FROM CaseFile cf WHERE cf.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindByFileId,
		query = "SELECT cf FROM CaseFile cf WHERE cf.fileId = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByTitle,
		query = "SELECT cf FROM CaseFile cf WHERE cf.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByOfficialTitle,
		query = "SELECT cf FROM CaseFile cf WHERE cf.officialTitle LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByDescription,
		query = "SELECT cf FROM CaseFile cf WHERE cf.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByDocumentMedium,
		query = "SELECT cf FROM CaseFile cf WHERE cf.documentMedium = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCreatedBy,
		query = "SELECT cf FROM CaseFile cf WHERE cf.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByFinalisedBy,
		query = "SELECT cf FROM CaseFile cf WHERE cf.finalisedBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCaseYear,
		query = "SELECT cf FROM CaseFile cf WHERE cf.caseYear = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCaseSequenceNumber,
		query = "SELECT cf FROM CaseFile cf WHERE cf.caseSequenceNumber = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCaseDate,
		query = "SELECT cf FROM CaseFile cf WHERE cf.caseDate = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByAdministrativeUnit,
		query = "SELECT cf FROM CaseFile cf WHERE cf.administrativeUnit = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCaseResponsible,
		query = "SELECT cf FROM CaseFile cf WHERE cf.caseResponsible LIKE ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByRecordsManagementUnit,
		query = "SELECT cf FROM CaseFile cf WHERE cf.recordsManagementUnit = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByCaseStatus,
		query = "SELECT cf FROM CaseFile cf WHERE cf.caseStatus = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByLoanedDate,
		query = "SELECT cf FROM CaseFile cf WHERE cf.loanedDate = ?1"
	),
	@NamedQuery(
		name = Queries.caseFileFindAllByLoanedTo,
		query = "SELECT cf FROM CaseFile cf WHERE cf.loanedTo LIKE ?1"
	)
})
public class CaseFile extends File implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M011 - saksaar (xs:integer) */
	@Column(name="case_year")
	protected Integer caseYear;
	
	/** M012 - sakssekvensnummer (xs:integer) */
	@Column(name="case_sequence_number")
	protected Integer caseSequenceNumber;
	
	/** M100 - saksdato (xs:date) */
	@Column(name="case_date")
	@Temporal(TemporalType.DATE)
	protected Date caseDate;
	
	/** M305 - administrativEnhet (xs:string) */
	@Column(name="administrative_unit")
	protected String administrativeUnit;
	
	/** M306 - saksansvarlig (xs:string) */
	@Column(name="case_responsible")
	protected String caseResponsible;
	
	/** M308 - journalenhet (xs:string) */
	@Column(name="records_management_unit")
	protected String recordsManagementUnit;
	
	/** M052 - saksstatus (xs:string) */
	@Column(name="case_status")
	protected String caseStatus;
	
	/** M106 - utlaantDato (xs:date) */
	@Column(name="loaned_date")
	@Temporal(TemporalType.DATE)
	protected Date loanedDate;
	
	/** M309 - utlaantTil (xs:string) */
	@Column(name="loaned_to")
	protected String loanedTo;

	public Integer getCaseYear() {
		return caseYear;
	}

	public void setCaseYear(Integer caseYear) {
		this.caseYear = caseYear;
	}

	public Integer getCaseSequenceNumber() {
		return caseSequenceNumber;
	}

	public void setCaseSequenceNumber(Integer caseSequenceNumber) {
		this.caseSequenceNumber = caseSequenceNumber;
	}

	public Date getCaseDate() {
		return caseDate;
	}

	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	public String getAdministrativeUnit() {
		return administrativeUnit;
	}

	public void setAdministrativeUnit(String administrativeUnit) {
		this.administrativeUnit = administrativeUnit;
	}

	public String getCaseResponsible() {
		return caseResponsible;
	}

	public void setCaseResponsible(String caseResponsible) {
		this.caseResponsible = caseResponsible;
	}

	public String getRecordsManagementUnit() {
		return recordsManagementUnit;
	}

	public void setRecordsManagementUnit(String recordsManagementUnit) {
		this.recordsManagementUnit = recordsManagementUnit;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Date getLoanedDate() {
		return loanedDate;
	}

	public void setLoanedDate(Date loanedDate) {
		this.loanedDate = loanedDate;
	}

	public String getLoanedTo() {
		return loanedTo;
	}

	public void setLoanedTo(String loanedTo) {
		this.loanedTo = loanedTo;
	}

}

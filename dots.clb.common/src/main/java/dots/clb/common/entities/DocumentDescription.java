package dots.clb.common.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "document_description")
@NamedQueries({
	@NamedQuery(
		name = Queries.documentDescriptionFindAll,
		query = "SELECT d FROM DocumentDescription d"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindBySystemId,
		query = "SELECT d FROM DocumentDescription d WHERE d.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByDocumentType,
		query = "SELECT d FROM DocumentDescription d WHERE d.documentType = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByDocumentStatus,
		query = "SELECT d FROM DocumentDescription d WHERE d.documentStatus = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByTitle,
		query = "SELECT d FROM DocumentDescription d WHERE d.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByDescription,
		query = "SELECT d FROM DocumentDescription d WHERE d.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByCreatedBy,
		query = "SELECT d FROM DocumentDescription d WHERE d.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByDocumentMedium,
		query = "SELECT d FROM DocumentDescription d WHERE d.documentMedium = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByAssociatedWithRecordAs,
		query = "SELECT d FROM DocumentDescription d WHERE d.associatedWithRecordAs = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByDocumentNumber,
		query = "SELECT d FROM DocumentDescription d WHERE d.documentNumber = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByAssociationDate,
		query = "SELECT d FROM DocumentDescription d WHERE d.associationDate = ?1"
	),
	@NamedQuery(
		name = Queries.documentDescriptionFindAllByAssociatedBy,
		query = "SELECT d FROM DocumentDescription d WHERE d.associatedBy LIKE ?1"
	)
})
public class DocumentDescription implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_document_description_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M083 - dokumenttype (xs:string) */
	@Column(name="document_type")
	protected String documentType;
	
	/** M054 - dokumentstatus (xs:string) */
	@Column(name="document_status")
	protected String documentStatus;
	
	/** M020 - tittel (xs:string) */
	@Column(name="title")
	protected String title;
	
	/** M021 - beskrivelse (xs:string) */
	@Column(name="description")
	protected String description;
	
	/** M600 - opprettetDato (xs:dateTime) */
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	/** M601 - opprettetAv (xs:string) */
	@Column(name="created_by")
	protected String createdBy;
	
	/** M300 - dokumentmedium (xs:string) */
	@Column(name="document_medium")
	protected String documentMedium;
	
	/** M217 - tilknyttetRegistreringSom (xs:string) */
	@Column(name="associated_with_record_as")
	protected String associatedWithRecordAs;
	
	/** M007 - dokumentnummer (xs:integer) */
	@Column(name="document_number")
	protected Integer documentNumber;
	
	/** M620 - tilknyttetDato (xs:date) */
	@Column(name="association_date")
	@Temporal(TemporalType.DATE)
	protected Date associationDate;
	
	/** M621 - tilknyttetAv (xs:string) */
	@Column(name="associated_by")
	protected String associatedBy;
	
	// Links to Records
	@ManyToMany(mappedBy="referenceDocumentDescription")
	protected Set<Record> referenceRecord = new HashSet<Record>();
	
	// Links to DocumentObjects
	@OneToMany(mappedBy="referenceDocumentDescription")
	protected Set<DocumentObject> referenceDocumentObject = new HashSet<DocumentObject>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDocumentMedium() {
		return documentMedium;
	}

	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
	}

	public String getAssociatedWithRecordAs() {
		return associatedWithRecordAs;
	}

	public void setAssociatedWithRecordAs(String associatedWithRecordAs) {
		this.associatedWithRecordAs = associatedWithRecordAs;
	}

	public Integer getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getAssociationDate() {
		return associationDate;
	}

	public void setAssociationDate(Date associationDate) {
		this.associationDate = associationDate;
	}

	public String getAssociatedBy() {
		return associatedBy;
	}

	public void setAssociatedBy(String associatedBy) {
		this.associatedBy = associatedBy;
	}

	public Set<Record> getReferenceRecord() {
		return referenceRecord;
	}

	public void setReferenceRecord(Set<Record> referenceRecord) {
		this.referenceRecord = referenceRecord;
	}

	public Set<DocumentObject> getReferenceDocumentObject() {
		return referenceDocumentObject;
	}

	public void setReferenceDocumentObject(
			Set<DocumentObject> referenceDocumentObject) {
		this.referenceDocumentObject = referenceDocumentObject;
	}

}

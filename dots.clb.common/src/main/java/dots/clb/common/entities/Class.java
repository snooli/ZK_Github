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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "class")
@NamedQueries({
	@NamedQuery(
		name = Queries.classFindAll,
		query = "SELECT c FROM Class c"
	),
	@NamedQuery(
		name = Queries.classFindBySystemId,
		query = "SELECT c FROM Class c WHERE c.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.classFindByClassId,
		query = "SELECT c FROM Class c WHERE c.classId = ?1"
	),
	@NamedQuery(
			name = Queries.classFindAllByTitle,
			query = "SELECT c FROM Class c WHERE c.title LIKE ?1"
	),
	@NamedQuery(
			name = Queries.classFindAllByDescription,
			query = "SELECT c FROM Class c WHERE c.description LIKE ?1"
	),
	@NamedQuery(
			name = Queries.classFindAllByCreatedBy,
			query = "SELECT c FROM Class c WHERE c.createdBy LIKE ?1"
	),
	@NamedQuery(
			name = Queries.classFindAllByFinalisedBy,
			query = "SELECT c FROM Class c WHERE c.finalisedBy LIKE ?1"
	)
})
public class Class implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_class_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M002 - klasseID (xs:string) */
	@Column(name="class_id")
	protected String classId;
	
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
	
	/** M602 - avsluttetDato (xs:dateTime) */
	@Column(name="finalised_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date finalisedDate;
	
	/** M603 - avsluttetAv (xs:string) */
	@Column(name="finalised_by")
	protected String finalisedBy;
	
	// Links to Keywords
	@ManyToMany
	@JoinTable(name="class_keyword",
		joinColumns=@JoinColumn(
			name="f_pk_class_id",
			referencedColumnName="pk_class_id"),
		inverseJoinColumns=@JoinColumn(
			name="f_pk_keyword_id",
			referencedColumnName="pk_keyword_id"))
	protected Set<Keyword> referenceKeyword = new HashSet<Keyword>();
	
	// Link to ClassificationSystem
	@ManyToOne
	@JoinColumn(name="class_classification_system_id",
			referencedColumnName="pk_classification_system_id")
	protected ClassificationSystem referenceClassificationSystem;

	// Link to parent Class
	@ManyToOne
	protected Class referenceParentClass;
	
	// Links to child Classes
	@OneToMany(mappedBy="referenceParentClass")
	protected Set<Class> referenceChildClass = new HashSet<Class>();
	
	// Links to Files
	@OneToMany(mappedBy="referenceClass")
	protected Set<File> referenceFile = new HashSet<File>();
	
	// Links to Records
	@OneToMany(mappedBy="referenceClass")
	protected Set<Record> referenceRecord = new HashSet<Record>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
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

	public Date getFinalisedDate() {
		return finalisedDate;
	}

	public void setFinalisedDate(Date finalisedDate) {
		this.finalisedDate = finalisedDate;
	}

	public String getFinalisedBy() {
		return finalisedBy;
	}

	public void setFinalisedBy(String finalisedBy) {
		this.finalisedBy = finalisedBy;
	}

	public Set<Keyword> getReferenceKeyword() {
		return referenceKeyword;
	}

	public void setReferenceKeyword(Set<Keyword> referenceKeyword) {
		this.referenceKeyword = referenceKeyword;
	}

	public ClassificationSystem getReferenceClassificationSystem() {
		return referenceClassificationSystem;
	}

	public void setReferenceClassificationSystem(
			ClassificationSystem referenceClassificationSystem) {
		this.referenceClassificationSystem = referenceClassificationSystem;
	}

	public Class getReferenceParentClass() {
		return referenceParentClass;
	}

	public void setReferenceParentClass(Class referenceParentClass) {
		this.referenceParentClass = referenceParentClass;
	}

	public Set<Class> getReferenceChildClass() {
		return referenceChildClass;
	}

	public void setReferenceChildClass(Set<Class> referenceChildClass) {
		this.referenceChildClass = referenceChildClass;
	}

	public Set<File> getReferenceFile() {
		return referenceFile;
	}

	public void setReferenceFile(Set<File> referenceFile) {
		this.referenceFile = referenceFile;
	}

	public Set<Record> getReferenceRecord() {
		return referenceRecord;
	}

	public void setReferenceRecord(Set<Record> referenceRecord) {
		this.referenceRecord = referenceRecord;
	}

}

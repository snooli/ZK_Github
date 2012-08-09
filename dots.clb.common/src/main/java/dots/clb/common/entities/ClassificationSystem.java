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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "classification_system")
@NamedQueries({
	@NamedQuery(
		name = Queries.classificationSystemFindAll,
		query = "SELECT cs FROM ClassificationSystem cs"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindBySystemId,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindAllByClassificationType,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.classificationType = ?1"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindAllByTitle,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindAllByDescription,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindAllByCreatedBy,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.classificationSystemFindAllByFinalisedBy,
		query = "SELECT cs FROM ClassificationSystem cs WHERE cs.finalisedBy LIKE ?1"
	)
})
public class ClassificationSystem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_classification_system_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M086 - klassifikasjonstype (xs:string) */
	@Column(name="classification_type")
	protected String classificationType;
	
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
	
	// Links to Series
	@OneToMany(mappedBy="referenceClassificationSystem")
	protected Set<Series> referenceSeries = new HashSet<Series>();
	
	// Links to child Classes
	@OneToMany(mappedBy="referenceClassificationSystem")
	protected Set<Class> referenceClass = new HashSet<Class>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getClassificationType() {
		return classificationType;
	}

	public void setClassificationType(String classificationType) {
		this.classificationType = classificationType;
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

	public Set<Series> getReferenceSeries() {
		return referenceSeries;
	}

	public void setReferenceSeries(Set<Series> referenceSeries) {
		this.referenceSeries = referenceSeries;
	}

	public Set<Class> getReferenceClass() {
		return referenceClass;
	}

	public void setReferenceClass(Set<Class> referenceClass) {
		this.referenceClass = referenceClass;
	}

}

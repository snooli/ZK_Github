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
@Table(name = "fonds")
@NamedQueries({
	@NamedQuery(
		name = Queries.fondsFindAll,
		query = "SELECT f FROM Fonds f"
	),
	@NamedQuery(
		name = Queries.fondsFindTopLevel,
		query = "SELECT f FROM Fonds f WHERE f.referenceParentFonds IS NULL"
	),
	@NamedQuery(
		name = Queries.fondsFindBySystemId,
		query = "SELECT f FROM Fonds f WHERE f.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByTitle,
		query = "SELECT f FROM Fonds f WHERE f.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByDescription,
		query = "SELECT f FROM Fonds f WHERE f.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByFondsStatus,
		query = "SELECT f FROM Fonds f WHERE f.fondsStatus = ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByDocumentMedium,
		query = "SELECT f FROM Fonds f WHERE f.documentMedium = ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByCreatedBy,
		query = "SELECT f FROM Fonds f WHERE f.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.fondsFindAllByFinalisedBy,
		query = "SELECT f FROM Fonds f WHERE f.finalisedBy LIKE ?1"
	)
})
public class Fonds implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_fonds_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M020 - tittel (xs:string) */
	@Column(name="title")
	protected String title;
	
	/** M021 - beskrivelse (xs:string) */
	@Column(name="description")
	protected String description;
	
	/** M050 - arkivstatus (xs:string) */
	@Column(name="fonds_status")
	protected String fondsStatus;
	
	/** M300 - dokumentmedium (xs:string) */
	@Column(name="document_medium")
	protected String documentMedium;

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
	@OneToMany(mappedBy="referenceFonds")
	protected Set<Series> referenceSeries = new HashSet<Series>();

	// Link to parent Fonds
	@ManyToOne
	protected Fonds referenceParentFonds;
	
	// Links to child Fonds
	@OneToMany(mappedBy="referenceParentFonds")
	protected Set<Fonds> referenceChildFonds = new HashSet<Fonds>();
	
	// Links to StorageLocations
	@ManyToMany
	@JoinTable(name="fonds_storage_location",
		joinColumns=@JoinColumn(
				name="f_pk_fonds_id",
				referencedColumnName="pk_fonds_id"),
		inverseJoinColumns=@JoinColumn(
				name="f_pk_storage_location_id",
				referencedColumnName="pk_storage_location_id"))
	protected Set<StorageLocation> referenceStorageLocation = new HashSet<StorageLocation>();
	
	// Links to FondsCreators
	@ManyToMany
	@JoinTable(name="fonds_fonds_creator",
		joinColumns=@JoinColumn(
				name="f_pk_fonds_id",
				referencedColumnName="pk_fonds_id"),
		inverseJoinColumns=@JoinColumn(
				name="f_pk_fonds_creator_id",
				referencedColumnName="pk_fonds_creator_id"))
	protected Set<FondsCreator> referenceFondsCreator = new HashSet<FondsCreator>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	public String getFondsStatus() {
		return fondsStatus;
	}

	public void setFondsStatus(String fondsStatus) {
		this.fondsStatus = fondsStatus;
	}

	public String getDocumentMedium() {
		return documentMedium;
	}

	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
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

	public Fonds getReferenceParentFonds() {
		return referenceParentFonds;
	}

	public void setReferenceParentFonds(Fonds referenceParentFonds) {
		this.referenceParentFonds = referenceParentFonds;
	}

	public Set<Fonds> getReferenceChildFonds() {
		return referenceChildFonds;
	}

	public void setReferenceChildFonds(Set<Fonds> referenceChildFonds) {
		this.referenceChildFonds = referenceChildFonds;
	}

	public Set<StorageLocation> getReferenceStorageLocation() {
		return referenceStorageLocation;
	}

	public void setReferenceStorageLocation(
			Set<StorageLocation> referenceStorageLocation) {
		this.referenceStorageLocation = referenceStorageLocation;
	}

	public Set<FondsCreator> getReferenceFondsCreator() {
		return referenceFondsCreator;
	}

	public void setReferenceFondsCreator(Set<FondsCreator> referenceFondsCreator) {
		this.referenceFondsCreator = referenceFondsCreator;
	}

}

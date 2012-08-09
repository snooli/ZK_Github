package dots.clb.common.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "basic_record")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(
		name = Queries.basicRecordFindAll,
		query = "SELECT br FROM BasicRecord br"
	),
	@NamedQuery(
		name = Queries.basicRecordFindBySystemId,
		query = "SELECT br FROM BasicRecord br WHERE br.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByCreatedBy,
		query = "SELECT br FROM BasicRecord br WHERE br.createdBy LIKE ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByArchivedBy,
		query = "SELECT br FROM BasicRecord br WHERE br.archivedBy LIKE ?1"
	),	
	@NamedQuery(
		name = Queries.basicRecordFindByRecordId, 
		query = "SELECT br FROM BasicRecord br WHERE br.recordId = ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByTitle, 
		query = "SELECT br FROM BasicRecord br WHERE br.title LIKE ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByOfficialTitle, 
		query = "SELECT br FROM BasicRecord br WHERE br.officialTitle LIKE ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByDescription, 
		query = "SELECT br FROM BasicRecord br WHERE br.description LIKE ?1"
	),
	@NamedQuery(
		name = Queries.basicRecordFindAllByDocumentMedium, 
		query = "SELECT br FROM BasicRecord br WHERE br.documentMedium = ?1"
	)
})
public class BasicRecord extends Record implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M004 - registreringsID (xs:string) */
	@Column(name = "record_id")
	protected String recordId;

	/** M020 - tittel (xs:string) */
	@Column(name = "title")
	protected String title;

	/** M025 - offentligTittel (xs:string) */
	@Column(name = "official_title")
	protected String officialTitle;

	/** M021 - beskrivelse (xs:string) */
	@Column(name = "description")
	protected String description;

	/** M300 - dokumentmedium (xs:string) */
	@Column(name = "document_medium")
	protected String documentMedium;

	// Link to StorageLocation
	@ManyToOne
	@JoinColumn(name = "basic_record_storage_location_id", 
			referencedColumnName = "pk_storage_location_id")
	protected StorageLocation referenceStorageLocation;

	// Links to Keywords
	@ManyToMany
	@JoinTable(name = "basic_record_keyword", 
			joinColumns = @JoinColumn(name = "f_pk_record_id", 
				referencedColumnName = "pk_record_id"), 
			inverseJoinColumns = @JoinColumn(name = "f_pk_keyword_id", 
				referencedColumnName = "pk_keyword_id"))
	protected Set<Keyword> referenceKeyword = new HashSet<Keyword>();

	// Links to Authors
	@ManyToMany
	@JoinTable(name = "basic_record_author", 
			joinColumns = @JoinColumn(name = "f_pk_record_id", 
				referencedColumnName = "pk_record_id"), 
			inverseJoinColumns = @JoinColumn(name = "f_pk_author_id", 
				referencedColumnName = "pk_author_id"))
	protected Set<Author> referenceAuthor = new HashSet<Author>();

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOfficialTitle() {
		return officialTitle;
	}

	public void setOfficialTitle(String officialTitle) {
		this.officialTitle = officialTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentMedium() {
		return documentMedium;
	}

	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
	}

	public StorageLocation getReferenceStorageLocation() {
		return referenceStorageLocation;
	}

	public void setReferenceStorageLocation(StorageLocation referenceStorageLocation) {
		this.referenceStorageLocation = referenceStorageLocation;
	}

	public Set<Keyword> getReferenceKeyword() {
		return referenceKeyword;
	}

	public void setReferenceKeyword(Set<Keyword> referenceKeyword) {
		this.referenceKeyword = referenceKeyword;
	}

	public Set<Author> getReferenceAuthor() {
		return referenceAuthor;
	}

	public void setReferenceAuthor(Set<Author> referenceAuthor) {
		this.referenceAuthor = referenceAuthor;
	}

}

package dots.clb.common.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "author")
@NamedQueries({
	@NamedQuery(
		name = Queries.authorFindAll,
		query = "SELECT a FROM Author a"
	),
	@NamedQuery(
		name = Queries.authorFindBySystemId,
		query = "SELECT a FROM Author a WHERE a.systemId = ?1"
	),
	@NamedQuery(
		name = Queries.authorFindAllByAuthor,
		query = "SELECT a FROM Author a WHERE a.author LIKE ?1"
	)
})
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_author_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M024 - forfatter (xs:string) */
	@Column(name="author")
	protected String author;
	
	// Links to BasicRecords
	@ManyToMany(mappedBy="referenceAuthor")
	protected Set<BasicRecord> referenceBasicRecord = new HashSet<BasicRecord>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<BasicRecord> getReferenceBasicRecord() {
		return referenceBasicRecord;
	}

	public void setReferenceBasicRecord(Set<BasicRecord> referenceBasicRecord) {
		this.referenceBasicRecord = referenceBasicRecord;
	}

}

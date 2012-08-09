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
@Table(name = "fonds_creator")
@NamedQueries({
	@NamedQuery(
		name = Queries.fondsCreatorFindAll,
		query = "SELECT f FROM FondsCreator f"
	),
	@NamedQuery(
		name=Queries.fondsCreatorFindBySystemId,
		query = "SELECT f FROM FondsCreator f WHERE f.systemId = ?1 AND f.isDisposed = false"
	),
	@NamedQuery(
		name = Queries.fondsCreatorFindByFondsCreatorId,
		query = "SELECT f FROM FondsCreator f WHERE f.fondsCreatorId = ?1 AND f.isDisposed = false"
	),
	@NamedQuery(
		name = Queries.fondsCreatorFindAllByFondsCreatorName,
		query = "SELECT f FROM FondsCreator f where f.fondsCreatorName LIKE ?1 AND f.isDisposed = false"
	),
	@NamedQuery(
		name = Queries.fondsCreatorFindAllByDescription,
		query = "SELECT f FROM FondsCreator f where f.description LIKE ?1 AND f.isDisposed = false"
	)
})
public class FondsCreator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_fonds_creator_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	/** M001 - systemID (xs:string) */
	@Column(name="system_id")
	protected String systemId;
	
	/** M006 - arkivskaperID (xs:string) */
	@Column(name="fonds_creator_id")
	protected String fondsCreatorId;
	
	/** M023 - arkivskaperNavn (xs:string) */
	@Column(name="fonds_creator_name")
	protected String fondsCreatorName;
	
	/** M021 - beskrivelse (xs:string) */
	@Column(name="description")
	protected String description;
	
	// Links to Fonds
	@ManyToMany(mappedBy="referenceFondsCreator")
	protected Set<Fonds> referenceFonds = new HashSet<Fonds>();

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getFondsCreatorId() {
		return fondsCreatorId;
	}

	public void setFondsCreatorId(String fondsCreatorId) {
		this.fondsCreatorId = fondsCreatorId;
	}

	public String getFondsCreatorName() {
		return fondsCreatorName;
	}

	public void setFondsCreatorName(String fondsCreatorName) {
		this.fondsCreatorName = fondsCreatorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Fonds> getReferenceFonds() {
		return referenceFonds;
	}

	public void setReferenceFonds(Set<Fonds> referenceFonds) {
		this.referenceFonds = referenceFonds;
	}

}

package dots.clb.common.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dots.clb.common.constants.Queries;


@Entity
@Table(name = "changelog_entry")
@NamedQueries({
	@NamedQuery(
		name = Queries.changeLogEntryFindAll,
		query = "SELECT c FROM ChangeLogEntry c"
	)
})
public class ChangeLogEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pk_changelog_entry_id", nullable=false, insertable=true, updatable=false)
	protected long id;
	
	@Column(name="reference_to_entity")
	protected String referenceToEntity;
	
	@Column(name="element_name")
	protected String elementName;
	
	@Column(name="changed_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date changedDate;
	
	@Column(name="changed_by")
	protected String changedBy;
	
	@Column(name="old_value")
	protected String oldValue;
	
	@Column(name="new_value")
	protected String newValue;

	public String getReferenceToEntity() {
		return referenceToEntity;
	}

	public void setReferenceToEntity(String referenceToEntity) {
		this.referenceToEntity = referenceToEntity;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

}

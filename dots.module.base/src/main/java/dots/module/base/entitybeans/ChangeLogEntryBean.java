package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class ChangeLogEntryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String referenceToEntity;

	protected String elementName;

	protected Date changedDate;

	protected String changedBy;

	protected String oldValue;

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

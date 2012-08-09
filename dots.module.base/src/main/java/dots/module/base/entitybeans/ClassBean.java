package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class ClassBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M002 - klasseID */
	protected String classId;

	/** M020 - tittel */
	protected String title;

	/** M021 - beskrivelse */
	protected String description;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M602 - avsluttetDato */
	protected Date finalisedDate;

	/** M603 - avsluttetAv */
	protected String finalisedBy;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M002 - klasseID */
	public String getClassId() {
		return classId;
	}

	/** M002 - klasseID */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/** M020 - tittel */
	public String getTitle() {
		return title;
	}

	/** M020 - tittel */
	public void setTitle(String title) {
		this.title = title;
	}

	/** M021 - beskrivelse */
	public String getDescription() {
		return description;
	}

	/** M021 - beskrivelse */
	public void setDescription(String description) {
		this.description = description;
	}

	/** M600 - opprettetDato */
	public Date getCreatedDate() {
		return createdDate;
	}

	/** M600 - opprettetDato */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/** M601 - opprettetAv */
	public String getCreatedBy() {
		return createdBy;
	}

	/** M601 - opprettetAv */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/** M602 - avsluttetDato */
	public Date getFinalisedDate() {
		return finalisedDate;
	}

	/** M602 - avsluttetDato */
	public void setFinalisedDate(Date finalisedDate) {
		this.finalisedDate = finalisedDate;
	}

	/** M603 - avsluttetAv */
	public String getFinalisedBy() {
		return finalisedBy;
	}

	/** M603 - avsluttetAv */
	public void setFinalisedBy(String finalisedBy) {
		this.finalisedBy = finalisedBy;
	}

}

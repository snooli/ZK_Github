package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class ClassificationSystemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M086 - klassifikasjonstype */
	protected String classificationType;

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

	/** M086 - klassifikasjonstype */
	public String getClassificationType() {
		return classificationType;
	}

	/** M086 - klassifikasjonstype */
	public void setClassificationType(String classificationType) {
		this.classificationType = classificationType;
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

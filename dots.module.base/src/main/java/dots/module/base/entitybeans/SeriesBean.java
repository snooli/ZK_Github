package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class SeriesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M020 - tittel */
	protected String title;

	/** M021 - beskrivelse */
	protected String description;

	/** M051 - arkivdelstatus */
	protected String seriesStatus;

	/** M300 - dokumentmedium */
	protected String documentMedium;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M602 - avsluttetDato */
	protected Date finalisedDate;

	/** M603 - avsluttetAv */
	protected String finalisedBy;

	/** M107 - arkivperiodeStartDato */
	protected Date seriesStartDate;

	/** M108 - arkivperiodeSluttDato */
	protected Date seriesEndDate;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	/** M051 - arkivdelstatus */
	public String getSeriesStatus() {
		return seriesStatus;
	}

	/** M051 - arkivdelstatus */
	public void setSeriesStatus(String seriesStatus) {
		this.seriesStatus = seriesStatus;
	}

	/** M300 - dokumentmedium */
	public String getDocumentMedium() {
		return documentMedium;
	}

	/** M300 - dokumentmedium */
	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
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

	/** M107 - arkivperiodeStartDato */
	public Date getSeriesStartDate() {
		return seriesStartDate;
	}

	/** M107 - arkivperiodeStartDato */
	public void setSeriesStartDate(Date seriesStartDate) {
		this.seriesStartDate = seriesStartDate;
	}

	/** M108 - arkivperiodeSluttDato */
	public Date getSeriesEndDate() {
		return seriesEndDate;
	}

	/** M108 - arkivperiodeSluttDato */
	public void setSeriesEndDate(Date seriesEndDate) {
		this.seriesEndDate = seriesEndDate;
	}

}

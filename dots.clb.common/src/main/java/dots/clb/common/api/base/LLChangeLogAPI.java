package dots.clb.common.api.base;

import java.util.Calendar;

import javax.persistence.EntityManager;

import dots.clb.common.entities.ChangeLogEntry;


public class LLChangeLogAPI {

	public void changeLog(EntityManager em, String systemId,
			String elementName, String oldValue, String newValue) {

		if (systemId == null) {
			return;
		}

		ChangeLogEntry entry = new ChangeLogEntry();

		entry.setReferenceToEntity(systemId);
		entry.setElementName(elementName);

		if (oldValue == null) {
			entry.setOldValue("NULL");
		} else {
			entry.setOldValue(oldValue);
		}

		entry.setNewValue(newValue);
		entry.setChangedBy(getUserId());
		entry.setChangedDate(Calendar.getInstance().getTime());

		em.persist(entry);
	}

	private String getUserId() {

		return "system";
	}

}

package n5.ui.listeners.buttons.modwnd;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.api.Button;
import org.zkoss.zul.api.Label;

public class DocumentUploadDoneEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// get the uploaded file
		Media media = ((UploadEvent) event).getMedia();

		// set the hidden file name field
		((Label) event.getTarget().getFellow("fileName")).setValue(media
				.getName());

		// set the hidden extension field
		((Label) event.getTarget().getFellow("extension")).setValue(media
				.getFormat());

		// set the hidden content type file
		((Label) event.getTarget().getFellow("contentType")).setValue(media
				.getContentType());

		// create a temp file for the uploaded file
		File tempFile = File.createTempFile(UUID.randomUUID().toString(), null);
		FileUtils.writeByteArrayToFile(tempFile,
				IOUtils.toByteArray(media.getStreamData()));

		// set the hidden temp file field
		((Label) event.getTarget().getFellow("tempFile")).setValue(tempFile
				.getAbsolutePath());

		// make the attach button invisible
		((Button) event.getTarget().getFellow("attachBtn")).setVisible(false);

		// show the file name
		((Label) event.getTarget().getFellow("displayedFileName"))
				.setValue(media.getName());
		((Label) event.getTarget().getFellow("displayedFileName"))
				.setVisible(true);
		((Label) event.getTarget().getFellow("displayedFileName")).invalidate();
	}

}

package dots.tool.helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.IOUtils;

public class TarGZHelper {

	public static void createTarGZ(String directoryPath, String tarGzPath)
			throws IOException {

		FileOutputStream fOut = null;
		BufferedOutputStream bOut = null;
		GzipCompressorOutputStream gzOut = null;
		TarArchiveOutputStream tOut = null;

		try {

			fOut = new FileOutputStream(new File(tarGzPath));
			bOut = new BufferedOutputStream(fOut);
			gzOut = new GzipCompressorOutputStream(bOut);
			tOut = new TarArchiveOutputStream(gzOut);
			addFileToTarGz(tOut, directoryPath, "");

		} finally {

			tOut.finish();
			tOut.close();
			gzOut.close();
			bOut.close();
			fOut.close();
		}

	}

	private static void addFileToTarGz(TarArchiveOutputStream out, String path,
			String base) throws IOException {

		File f = new File(path);

		String entryName = base + f.getName();

		TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);

		out.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);

		out.putArchiveEntry(tarEntry);

		if (f.isFile()) {

			IOUtils.copy(new FileInputStream(f), out);
			out.closeArchiveEntry();

		} else {

			out.closeArchiveEntry();

			File[] children = f.listFiles();

			if (children != null) {

				for (File child : children) {

					addFileToTarGz(out, child.getAbsolutePath(), entryName
							+ File.separator);
				}
			}
		}
	}

}

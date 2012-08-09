package dots.tool.helpers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class ChecksumHelper {

	public static String getFileChecksum(File file) throws Exception {

		return DigestUtils.sha256Hex(new BufferedInputStream(
				new FileInputStream(file)));

	}

}

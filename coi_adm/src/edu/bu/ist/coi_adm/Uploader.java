package edu.bu.ist.coi_adm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

import org.apache.log4j.Logger;

public class Uploader  {
//  private static final long serialVersionUID = 1L;
  private static final String uploadFolderName = "Uploads";
  private static volatile String uploadFolder = null;
  private static Logger logger = Logger.getLogger(Uploader.class);
	
	static String getUploadFolder() { //TODO: synchronization not handled.
	    if (uploadFolder == null) {
//	      uploadFolder = getServletContext().getRealPath("/");
	      uploadFolder = System.getProperty("catalina.base");

	      if (!uploadFolder.endsWith(File.separator)) uploadFolder += File.separator;
	      uploadFolder += uploadFolderName;
	      File dir = new File(uploadFolder);
	      if (!dir.exists()) {
	        boolean create = dir.mkdir();
	        if (create) {
	          logger.info("Uploads directory created: " + uploadFolder);
	        } else {
	          throw new RuntimeException("Directory Cannot Be Created!");
	        }
	      }
	    }
	    return uploadFolder;
	  }

	static void writeToFileUsingFileOutputStream(InputStream filecontent, String filePath) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(filePath));
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
	}

	static String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		String[] sections = partHeader.split(";");
		for (String content : sections) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd_HHmm-ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
}

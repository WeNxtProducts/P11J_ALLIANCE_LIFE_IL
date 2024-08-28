package com.iii.pel.jasperreports;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenJasPerReport {
	public void generateReport(HttpServletRequest request,
			HttpServletResponse response, FacesContext context,
			String generatedFileName) throws Exception {
		try {
			OutputStream outputStream = response.getOutputStream();
			String path = request.getRealPath("/") + "jasperreports//";
			String filename = path + generatedFileName + ".pdf";
			String downloadfile = generatedFileName + ".pdf";
			response.setContentType("APPLICATION/OCTET-STREAM");
			String disHeader = "Attachment; Filename=\"" + downloadfile + "\"";
			response.setHeader("Content-Disposition", disHeader);
			File fileToDownload = new File(filename);
			FileInputStream fileInputStream = new FileInputStream(
					fileToDownload);
			int i;
			while ((i = fileInputStream.read()) != -1) {
				outputStream.write(i);
			}
			outputStream.flush();
			outputStream.close();
			context.getCurrentInstance().responseComplete();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

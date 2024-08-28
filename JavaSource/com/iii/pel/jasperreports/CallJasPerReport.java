package com.iii.pel.jasperreports;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.iii.premia.common.utils.CommonUtils;

public class CallJasPerReport {
	private Connection connection = null;

	public void generateReport(HttpServletRequest request, String filename,

	String generatedFileName, Map params) throws Exception {
		String path = request.getRealPath("/") + "jasperreports//";
		String reportFileName = filename;
		String reportSource = path + reportFileName;
		String pdfreportDest = path + generatedFileName + ".pdf";
		try {
			JasperReport jasperReport = JasperCompileManager
					.compileReport(reportSource);
			connection = CommonUtils.getConnection();
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, params, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					pdfreportDest);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

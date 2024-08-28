package com.iii.premia.common.login.home;

import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author 55222 Yalamanda 
 *
 */
public class DashBoardBean extends BaseValueBean {
	
	private String chartID;   
	private String chartType; 
	private String reportCaption; 
	private String reportID;
	private String reportPDFURL;
	private String reportExcelURL;
	
	public String getChartID() {
		return chartID;
	}
	public void setChartID(String chartID) {
		this.chartID = chartID;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	public String getReportCaption() {
		return reportCaption;
	}
	public void setReportCaption(String reportCaption) {
		this.reportCaption = reportCaption;
	}
	public String getReportID() {
		return reportID;
	}
	public void setReportID(String reportID) {
		this.reportID = reportID;
	}
	public String getReportPDFURL() {
		return reportPDFURL;
	}
	public void setReportPDFURL(String reportPDFURL) {
		this.reportPDFURL = reportPDFURL;
	}
	public String getReportExcelURL() {
		return reportExcelURL;
	}
	public void setReportExcelURL(String reportExcelURL) {
		this.reportExcelURL = reportExcelURL;
	}
	
    	
}

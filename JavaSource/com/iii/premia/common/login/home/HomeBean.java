package com.iii.premia.common.login.home;

import java.util.ArrayList;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.commonimpl.chartimpl.bean.ChartQueryBean;

public class HomeBean extends BaseValueBean{
	private ArrayList<ChartQueryBean> chartList;
//  [ Added by Yalamanda for DashBaord Reports
	private ArrayList<DashBoardBean> reportList;
	//  Added by Yalamanda for DashBaord Reports ]
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HomeBean(){
		chartList = new ArrayList<ChartQueryBean>();
	}

	public ArrayList<ChartQueryBean> getChartList() {
		return chartList;
	}

	public void setChartList(ArrayList<ChartQueryBean> chartList) {
		this.chartList = chartList;
	}
	
	public int getChartListSize(){
		return chartList.size();
	}
	
	public int getNumberOfColumns(){
		return chartList.size()>1?2:1;
	}

	public ArrayList<DashBoardBean> getReportList() {
		return reportList;
	}

	public void setReportList(ArrayList<DashBoardBean> reportList) {
		this.reportList = reportList;
	}
	
	public Integer getReportListSize(){
		return (reportList!=null)?reportList.size():0;
	}
}

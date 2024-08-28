package com.iii.pel.forms.CHART;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PGIM_PORTAL_CHART_QUERY")
public class ChartBean extends BaseValueBean {
	@Column(name="CHART_ID")
	private String CHART_ID;
	@Column(name="CHART_DESC")
	private String CHART_DESC;
	@Column(name="CHART_TYPE")
	private String CHART_TYPE;
	@Column(name="CHART_QUERY")
	private String CHART_QUERY;
	@Column(name="UPDATED_BY")
	private String UPDATED_BY;
	@Column(name="UPDATED_DATE")
	private Date UPDATED_DATE;
	
	private String UI_CHART_URL;
	private ChartQueryResultSet queryResults = new ChartQueryResultSet();
	private String[] associatedUserList = new String[]{};
	
	public ChartQueryResultSet getQueryResults() {
		return queryResults;
	}
	public void setQueryResults(ChartQueryResultSet queryResults) {
		this.queryResults = queryResults;
	}
	public String getUI_CHART_URL() {
		return UI_CHART_URL;
	}
	public void setUI_CHART_URL(String ui_chart_url) {
		UI_CHART_URL = ui_chart_url;
	}
	public String getCHART_ID() {
		return CHART_ID;
	}
	public void setCHART_ID(String chart_id) {
		CHART_ID = chart_id;
	}
	public String getCHART_DESC() {
		return CHART_DESC;
	}
	public void setCHART_DESC(String chart_desc) {
		CHART_DESC = chart_desc;
	}
	public String getCHART_TYPE() {
		return CHART_TYPE;
	}
	public void setCHART_TYPE(String chart_type) {
		CHART_TYPE = chart_type;
	}
	public String getCHART_QUERY() {
		return CHART_QUERY;
	}
	public void setCHART_QUERY(String chart_query) {
		CHART_QUERY = chart_query;
	}
	public String getUPDATED_BY() {
		return UPDATED_BY;
	}
	public void setUPDATED_BY(String updated_by) {
		UPDATED_BY = updated_by;
	}
	public Date getUPDATED_DATE() {
		return UPDATED_DATE;
	}
	public void setUPDATED_DATE(Date updated_date) {
		UPDATED_DATE = updated_date;
	}
	public String[] getAssociatedUserList() {
		return associatedUserList;
	}
	public void setAssociatedUserList(String[] associatedUserList) {
		this.associatedUserList = associatedUserList;
	}
}

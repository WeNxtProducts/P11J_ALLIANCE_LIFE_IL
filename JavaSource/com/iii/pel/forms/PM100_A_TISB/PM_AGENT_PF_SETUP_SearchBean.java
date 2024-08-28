package com.iii.pel.forms.PM100_A_TISB;

public class PM_AGENT_PF_SETUP_SearchBean {
	
	
	private String APS_MKT_CODE;
	private String APS_RANK_CODE;
	private Double APS_EXP_MONTHS;
	private Double APS_COMM_PER;
	private Double APS_COMM_RATE_PER;
	
	private String APS_COMM_TYPE;
	private String ROWID;
	
	private String searchText;

	
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getAPS_MKT_CODE() {
		return APS_MKT_CODE;
	}
	public void setAPS_MKT_CODE(String aps_mkt_code) {
		APS_MKT_CODE = aps_mkt_code;
	}
	public String getAPS_RANK_CODE() {
		return APS_RANK_CODE;
	}
	public void setAPS_RANK_CODE(String aps_rank_code) {
		APS_RANK_CODE = aps_rank_code;
	}
	public Double getAPS_EXP_MONTHS() {
		return APS_EXP_MONTHS;
	}
	public void setAPS_EXP_MONTHS(Double aps_exp_months) {
		APS_EXP_MONTHS = aps_exp_months;
	}
	public Double getAPS_COMM_PER() {
		return APS_COMM_PER;
	}
	public void setAPS_COMM_PER(Double aps_comm_per) {
		APS_COMM_PER = aps_comm_per;
	}
	public Double getAPS_COMM_RATE_PER() {
		return APS_COMM_RATE_PER;
	}
	public void setAPS_COMM_RATE_PER(Double aps_comm_rate_per) {
		APS_COMM_RATE_PER = aps_comm_rate_per;
	}
	
	public String getAPS_COMM_TYPE() {
		return APS_COMM_TYPE;
	}
	public void setAPS_COMM_TYPE(String aps_comm_type) {
		APS_COMM_TYPE = aps_comm_type;
	}
	public String getROWID() {
		return ROWID;
	}
	public void setROWID(String rowid) {
		ROWID = rowid;
	}

}

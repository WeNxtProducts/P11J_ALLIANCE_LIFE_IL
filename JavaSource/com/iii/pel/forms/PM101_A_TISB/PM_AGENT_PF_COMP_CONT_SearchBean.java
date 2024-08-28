package com.iii.pel.forms.PM101_A_TISB;

public class PM_AGENT_PF_COMP_CONT_SearchBean {
	
	private String APCC_MKT_CODE;
	//private String APCC_RANK_CODE;
	private String APCC_PROD_TYPE;
	//private String APCC_CONT_TYPE;
	private Double APCC_CONT_FM;
	//private Double APCC_CONT_TO;
	private Double APCC_RATE;
	//private Double APCC_RATE_PER;	
	private String ROWID;	
	private String searchText;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getAPCC_PROD_TYPE() {
		return APCC_PROD_TYPE;
	}

	public void setAPCC_PROD_TYPE(String apcc_prod_type) {
		APCC_PROD_TYPE = apcc_prod_type;
	}

	/*public String getAPCC_CONT_TYPE() {
		return APCC_CONT_TYPE;
	}

	public void setAPCC_CONT_TYPE(String apcc_cont_type) {
		APCC_CONT_TYPE = apcc_cont_type;
	}
*/
	public Double getAPCC_RATE() {
		return APCC_RATE;
	}

	public void setAPCC_RATE(Double apcc_rate) {
		APCC_RATE = apcc_rate;
	}

	/*public Double getAPCC_RATE_PER() {
		return APCC_RATE_PER;
	}

	public void setAPCC_RATE_PER(Double apcc_rate_per) {
		APCC_RATE_PER = apcc_rate_per;
	}*/

	public String getAPCC_MKT_CODE() {
		return APCC_MKT_CODE;
	}

	public void setAPCC_MKT_CODE(String apcc_mkt_code) {
		APCC_MKT_CODE = apcc_mkt_code;
	}

	/*public String getAPCC_RANK_CODE() {
		return APCC_RANK_CODE;
	}

	public void setAPCC_RANK_CODE(String apcc_rank_code) {
		APCC_RANK_CODE = apcc_rank_code;
	}*/

	public Double getAPCC_CONT_FM() {
		return APCC_CONT_FM;
	}

	public void setAPCC_CONT_FM(Double apcc_cont_fm) {
		APCC_CONT_FM = apcc_cont_fm;
	}

/*	public Double getAPCC_CONT_TO() {
		return APCC_CONT_TO;
	}

	public void setAPCC_CONT_TO(Double apcc_cont_to) {
		APCC_CONT_TO = apcc_cont_to;
	}*/

}

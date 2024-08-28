package com.iii.pel.forms.PM103_A_TISB;


public class PolicyDetails 
//Contains Getter & Setter Items to be displayed in the search screen
{
	/*private String POL_SYS_ID;
	private String POL_UW_YEAR;
	private String POL_NO;
	private String POL_CUST_CODE;
	private String POL_ASSURED_NAME;
	private String POL_PERIOD;
	private String POL_START_DT;
	private String POL_EXPIRY_DT;
*/	
	
	/*private String BANK_CUST_BANK_CODE;
	private String BANK_CUST_OUR_CODE;
	private String BANK_MAIN_ACNT_CODE;
	private String BANK_SUB_ACNT_CODE;
	private String BANK_BRANCH;
	private String BANK_VALUE_FROM;
	private String BANK_VALUE_TO;*/
	
	
	private Double APIS_RATE;
	private Double APIS_RATE_PER;
	private String APIS_EFF_FM_DT;
	private String APIS_EFF_TO_DT;

	private String ROWID;
	
	
	public String getROWID() {
		return ROWID;
	}
	public void setROWID(String rowid) {
		ROWID = rowid;
	}
	/*public String getAPAT_CODE() {
		return APAT_CODE;
	}
	public void setAPAT_CODE(String apat_code) {
		APAT_CODE = apat_code;
	}
	public Double getAPAT_RATE() {
		return APAT_RATE;
	}
	public void setAPAT_RATE(Double apat_rate) {
		APAT_RATE = apat_rate;
	}
	public Double getAPAT_AGE() {
		return APAT_AGE;
	}
	public void setAPAT_AGE(Double apat_age) {
		APAT_AGE = apat_age;
	}*/
	public Double getAPIS_RATE() {
		return APIS_RATE;
	}
	public void setAPIS_RATE(Double apis_rate) {
		APIS_RATE = apis_rate;
	}
	public Double getAPIS_RATE_PER() {
		return APIS_RATE_PER;
	}
	public void setAPIS_RATE_PER(Double apis_rate_per) {
		APIS_RATE_PER = apis_rate_per;
	}
	public String getAPIS_EFF_FM_DT() {
		return APIS_EFF_FM_DT;
	}
	public void setAPIS_EFF_FM_DT(String apis_eff_fm_dt) {
		APIS_EFF_FM_DT = apis_eff_fm_dt;
	}
	public String getAPIS_EFF_TO_DT() {
		return APIS_EFF_TO_DT;
	}
	public void setAPIS_EFF_TO_DT(String apis_eff_to_dt) {
		APIS_EFF_TO_DT = apis_eff_to_dt;
	}
	
	
	
}

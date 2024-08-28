package com.iii.pel.forms.PILT003_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_AGENT_COMM_VALUES")
public class PT_AGENT_COMM_VALUES extends BaseValueBean {

	@Column(name="ACV_MOD_CODE")
	private String ACV_MOD_CODE;

	@Column(name="ACV_POL_SYS_ID")
	private Long ACV_POL_SYS_ID;

	@Column(name="ACV_PC_SYS_ID")
	private Long ACV_PC_SYS_ID;

	@Column(name="ACV_COMM_TYPE")
	private String ACV_COMM_TYPE;

	@Column(name="ACV_COVER_CODE")
	private String ACV_COVER_CODE;

	@Column(name="ACV_LEVEL")
	private Double ACV_LEVEL;

	@Column(name="ACV_AGENT_CODE")
	private String ACV_AGENT_CODE;

	@Column(name="ACV_AGENT_RANK_CODE")
	private String ACV_AGENT_RANK_CODE;

	@Column(name="ACV_CURR_CODE")
	private String ACV_CURR_CODE;

	@Column(name="ACV_YEAR")
	private Double ACV_YEAR;

	@Column(name="ACV_COMM_CODE")
	private String ACV_COMM_CODE;

	@Column(name="ACV_RATE")
	private Double ACV_RATE;

	@Column(name="ACV_RATE_PER")
	private Double ACV_RATE_PER;

	@Column(name="ACV_FC_VALUE")
	private Double ACV_FC_VALUE;

	@Column(name="ACV_LC_VALUE")
	private Double ACV_LC_VALUE;

	@Column(name="ACV_CR_DT")
	private Date ACV_CR_DT;

	@Column(name="ACV_CR_UID")
	private String ACV_CR_UID;

	@Column(name="ACV_MKT_CODE")
	private String ACV_MKT_CODE;

	@Column(name="ACV_UNIT_CODE")
	private String ACV_UNIT_CODE;

	@Column(name="ACV_AGENCY_CODE")
	private String ACV_AGENCY_CODE;

	@Column(name="ACV_AGENCY_BRANCH_CODE")
	private String ACV_AGENCY_BRANCH_CODE;

	@Column(name="ACV_REGION_CODE")
	private String ACV_REGION_CODE;

	@Column(name="ACV_RECRUITER_CODE")
	private String ACV_RECRUITER_CODE;

	@Column(name="ACV_TU_SYS_ID")
	private Long ACV_TU_SYS_ID;

	private String UI_M_ACV_AGENT_DESC;
	private String UI_M_ACV_COMM_DESC;
	private String UI_M_ACV_COVER_DESC;
	private String UI_M_ACV_AGENT_RANK_CODE;
//newly added for broker deductions
	@Column(name="ACV_TOT_FC_DED")
	private Double ACV_TOT_FC_DED;
	@Column(name="ACV_TOT_LC_DED")
	private Double ACV_TOT_LC_DED;
	@Column(name="ACV_NET_FC_VALUE")
	private Double ACV_NET_FC_VALUE;
	@Column(name="ACV_NET_LC_VALUE")
	private Double ACV_NET_LC_VALUE;
	
	
	
	/*ADDED BY DHINESH 3 NEW FIELDS ON 17.3.2016*/
	
	
	@Column(name="ACV_FLEX_04")
	private String ACV_FLEX_04_VALUE;
	private String ACV_FLEX_04_VALUE_DESC;
	
	
	public String getACV_FLEX_04_VALUE_DESC() {
		return ACV_FLEX_04_VALUE_DESC;
	}
	public void setACV_FLEX_04_VALUE_DESC(String aCV_FLEX_04_VALUE_DESC) {
		ACV_FLEX_04_VALUE_DESC = aCV_FLEX_04_VALUE_DESC;
	}
	@Column(name="ACV_FLEX_05")
	private String ACV_FLEX_05_VALUE;
	
	@Column(name="ACV_FLEX_06")
	private Date ACV_FLEX_06_VALUE;
	
	
	public String getACV_FLEX_04_VALUE() {
		return ACV_FLEX_04_VALUE;
	}
	public void setACV_FLEX_04_VALUE(String aCV_FLEX_04_VALUE) {
		ACV_FLEX_04_VALUE = aCV_FLEX_04_VALUE;
	}
	
	public Date getACV_FLEX_06_VALUE() {
		return ACV_FLEX_06_VALUE;
	}
	public void setACV_FLEX_06_VALUE(Date aCV_FLEX_06_VALUE) {
		ACV_FLEX_06_VALUE = aCV_FLEX_06_VALUE;
	}
	
	
	public String getACV_FLEX_05_VALUE() {
		return ACV_FLEX_05_VALUE;
	}
	public void setACV_FLEX_05_VALUE(String aCV_FLEX_05_VALUE) {
		ACV_FLEX_05_VALUE = aCV_FLEX_05_VALUE;
	}
	
	/*END*/
	
	
	
	public void setACV_LC_VALUE(Double ACV_LC_VALUE) {
		this.ACV_LC_VALUE = ACV_LC_VALUE;
	}
	public Double getACV_LC_VALUE() {
		 return ACV_LC_VALUE;
	}
	public void setACV_COVER_CODE(String ACV_COVER_CODE) {
		this.ACV_COVER_CODE = ACV_COVER_CODE;
	}
	public String getACV_COVER_CODE() {
		 return ACV_COVER_CODE;
	}
	public void setUI_M_ACV_AGENT_DESC(String UI_M_ACV_AGENT_DESC) {
		this.UI_M_ACV_AGENT_DESC = UI_M_ACV_AGENT_DESC;
	}
	public String getUI_M_ACV_AGENT_DESC() {
		 return UI_M_ACV_AGENT_DESC;
	}
	public void setACV_AGENT_CODE(String ACV_AGENT_CODE) {
		this.ACV_AGENT_CODE = ACV_AGENT_CODE;
	}
	public String getACV_AGENT_CODE() {
		 return ACV_AGENT_CODE;
	}
	public void setACV_COMM_CODE(String ACV_COMM_CODE) {
		this.ACV_COMM_CODE = ACV_COMM_CODE;
	}
	public String getACV_COMM_CODE() {
		 return ACV_COMM_CODE;
	}
	public void setACV_CURR_CODE(String ACV_CURR_CODE) {
		this.ACV_CURR_CODE = ACV_CURR_CODE;
	}
	public String getACV_CURR_CODE() {
		 return ACV_CURR_CODE;
	}
	public void setACV_FC_VALUE(Double ACV_FC_VALUE) {
		this.ACV_FC_VALUE = ACV_FC_VALUE;
	}
	public Double getACV_FC_VALUE() {
		 return ACV_FC_VALUE;
	}
	public void setACV_REGION_CODE(String ACV_REGION_CODE) {
		this.ACV_REGION_CODE = ACV_REGION_CODE;
	}
	public String getACV_REGION_CODE() {
		 return ACV_REGION_CODE;
	}
	public void setACV_AGENCY_BRANCH_CODE(String ACV_AGENCY_BRANCH_CODE) {
		this.ACV_AGENCY_BRANCH_CODE = ACV_AGENCY_BRANCH_CODE;
	}
	public String getACV_AGENCY_BRANCH_CODE() {
		 return ACV_AGENCY_BRANCH_CODE;
	}
	public void setUI_M_ACV_COVER_DESC(String UI_M_ACV_COVER_DESC) {
		this.UI_M_ACV_COVER_DESC = UI_M_ACV_COVER_DESC;
	}
	public String getUI_M_ACV_COVER_DESC() {
		 return UI_M_ACV_COVER_DESC;
	}
	public void setACV_LEVEL(Double ACV_LEVEL) {
		this.ACV_LEVEL = ACV_LEVEL;
	}
	public Double getACV_LEVEL() {
		 return ACV_LEVEL;
	}
	public void setACV_POL_SYS_ID(Long ACV_POL_SYS_ID) {
		this.ACV_POL_SYS_ID = ACV_POL_SYS_ID;
	}
	public Long getACV_POL_SYS_ID() {
		 return ACV_POL_SYS_ID;
	}
	public void setACV_MKT_CODE(String ACV_MKT_CODE) {
		this.ACV_MKT_CODE = ACV_MKT_CODE;
	}
	public String getACV_MKT_CODE() {
		 return ACV_MKT_CODE;
	}
	public void setACV_TU_SYS_ID(Long ACV_TU_SYS_ID) {
		this.ACV_TU_SYS_ID = ACV_TU_SYS_ID;
	}
	public Long getACV_TU_SYS_ID() {
		 return ACV_TU_SYS_ID;
	}
	public void setACV_YEAR(Double ACV_YEAR) {
		this.ACV_YEAR = ACV_YEAR;
	}
	public Double getACV_YEAR() {
		 return ACV_YEAR;
	}
	public void setACV_MOD_CODE(String ACV_MOD_CODE) {
		this.ACV_MOD_CODE = ACV_MOD_CODE;
	}
	public String getACV_MOD_CODE() {
		 return ACV_MOD_CODE;
	}
	public void setACV_RATE(Double ACV_RATE) {
		this.ACV_RATE = ACV_RATE;
	}
	public Double getACV_RATE() {
		 return ACV_RATE;
	}
	public void setACV_AGENT_RANK_CODE(String ACV_AGENT_RANK_CODE) {
		this.ACV_AGENT_RANK_CODE = ACV_AGENT_RANK_CODE;
	}
	public String getACV_AGENT_RANK_CODE() {
		 return ACV_AGENT_RANK_CODE;
	}
	public void setUI_M_ACV_AGENT_RANK_CODE(String UI_M_ACV_AGENT_RANK_CODE) {
		this.UI_M_ACV_AGENT_RANK_CODE = UI_M_ACV_AGENT_RANK_CODE;
	}
	public String getUI_M_ACV_AGENT_RANK_CODE() {
		 return UI_M_ACV_AGENT_RANK_CODE;
	}
	public void setACV_AGENCY_CODE(String ACV_AGENCY_CODE) {
		this.ACV_AGENCY_CODE = ACV_AGENCY_CODE;
	}
	public String getACV_AGENCY_CODE() {
		 return ACV_AGENCY_CODE;
	}
	public void setACV_RATE_PER(Double ACV_RATE_PER) {
		this.ACV_RATE_PER = ACV_RATE_PER;
	}
	public Double getACV_RATE_PER() {
		 return ACV_RATE_PER;
	}
	public void setACV_RECRUITER_CODE(String ACV_RECRUITER_CODE) {
		this.ACV_RECRUITER_CODE = ACV_RECRUITER_CODE;
	}
	public String getACV_RECRUITER_CODE() {
		 return ACV_RECRUITER_CODE;
	}
	public void setACV_UNIT_CODE(String ACV_UNIT_CODE) {
		this.ACV_UNIT_CODE = ACV_UNIT_CODE;
	}
	public String getACV_UNIT_CODE() {
		 return ACV_UNIT_CODE;
	}
	public void setACV_COMM_TYPE(String ACV_COMM_TYPE) {
		this.ACV_COMM_TYPE = ACV_COMM_TYPE;
	}
	public String getACV_COMM_TYPE() {
		 return ACV_COMM_TYPE;
	}
	public void setACV_CR_DT(Date ACV_CR_DT) {
		this.ACV_CR_DT = ACV_CR_DT;
	}
	public Date getACV_CR_DT() {
		 return ACV_CR_DT;
	}
	public void setACV_CR_UID(String ACV_CR_UID) {
		this.ACV_CR_UID = ACV_CR_UID;
	}
	public String getACV_CR_UID() {
		 return ACV_CR_UID;
	}
	public void setACV_PC_SYS_ID(Long ACV_PC_SYS_ID) {
		this.ACV_PC_SYS_ID = ACV_PC_SYS_ID;
	}
	public Long getACV_PC_SYS_ID() {
		 return ACV_PC_SYS_ID;
	}
	public void setUI_M_ACV_COMM_DESC(String UI_M_ACV_COMM_DESC) {
		this.UI_M_ACV_COMM_DESC = UI_M_ACV_COMM_DESC;
	}
	public String getUI_M_ACV_COMM_DESC() {
		 return UI_M_ACV_COMM_DESC;
	}
	public Double getACV_TOT_FC_DED() {
		return ACV_TOT_FC_DED;
	}
	public void setACV_TOT_FC_DED(Double acv_tot_fc_ded) {
		ACV_TOT_FC_DED = acv_tot_fc_ded;
	}
	public Double getACV_TOT_LC_DED() {
		return ACV_TOT_LC_DED;
	}
	public void setACV_TOT_LC_DED(Double acv_tot_lc_ded) {
		ACV_TOT_LC_DED = acv_tot_lc_ded;
	}
	public Double getACV_NET_FC_VALUE() {
		return ACV_NET_FC_VALUE;
	}
	public void setACV_NET_FC_VALUE(Double acv_net_fc_value) {
		ACV_NET_FC_VALUE = acv_net_fc_value;
	}
	public Double getACV_NET_LC_VALUE() {
		return ACV_NET_LC_VALUE;
	}
	public void setACV_NET_LC_VALUE(Double acv_net_lc_value) {
		ACV_NET_LC_VALUE = acv_net_lc_value;
	}

}
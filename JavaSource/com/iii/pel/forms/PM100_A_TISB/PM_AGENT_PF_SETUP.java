package com.iii.pel.forms.PM100_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_PF_SETUP")
public class PM_AGENT_PF_SETUP extends BaseValueBean {
	
	@Id
	@Column(name="ROWID")
	private String ROWID;
 
	@Column(name="APS_MKT_CODE")
	private String APS_MKT_CODE;

	@Column(name="APS_RANK_CODE")
	private String APS_RANK_CODE;

	@Column(name="APS_EXP_MONTHS")
	private Integer APS_EXP_MONTHS;

	@Column(name="APS_COMM_PER")
	private Double APS_COMM_PER;

	@Column(name="APS_COMM_RATE_PER")
	private Double APS_COMM_RATE_PER;

	@Column(name="APS_COMM_TYPE")
	private String APS_COMM_TYPE;

	@Column(name="APS_PROMOTE_YN")
	private String APS_PROMOTE_YN;

	@Column(name="APS_DEDUCT_YN")
	private String APS_DEDUCT_YN;
	
	@Column(name="APS_CR_UID")
	private String APS_CR_UID;
	
	@Column(name="APS_CR_DT")
	private Date APS_CR_DT;
	
	@Column(name="APS_UPD_UID")
	private String APS_UPD_UID;
	
	@Column(name="APS_UPD_DT")
	private Date APS_UPD_DT;

	private String UI_M_APS_MKT_CODE_DESC;

	private String UI_M_APS_RANK_CODE_DESC;
	
	private boolean selected;
	
	private String searchText;



	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getAPS_MKT_CODE() {
		return APS_MKT_CODE;
	}

	public void setAPS_MKT_CODE(String APS_MKT_CODE) {
		this.APS_MKT_CODE = APS_MKT_CODE;
	}

	public String getAPS_RANK_CODE() {
		return APS_RANK_CODE;
	}

	public void setAPS_RANK_CODE(String APS_RANK_CODE) {
		this.APS_RANK_CODE = APS_RANK_CODE;
	}

	public Integer getAPS_EXP_MONTHS() {
		return APS_EXP_MONTHS;
	}

	public void setAPS_EXP_MONTHS(Integer APS_EXP_MONTHS) {
		this.APS_EXP_MONTHS = APS_EXP_MONTHS;
	}

	public Double getAPS_COMM_PER() {
		return APS_COMM_PER;
	}

	public void setAPS_COMM_PER(Double APS_COMM_PER) {
		this.APS_COMM_PER = APS_COMM_PER;
	}

	public Double getAPS_COMM_RATE_PER() {
		return APS_COMM_RATE_PER;
	}

	public void setAPS_COMM_RATE_PER(Double APS_COMM_RATE_PER) {
		this.APS_COMM_RATE_PER = APS_COMM_RATE_PER;
	}

	public String getAPS_COMM_TYPE() {
		return APS_COMM_TYPE;
	}

	public void setAPS_COMM_TYPE(String APS_COMM_TYPE) {
		this.APS_COMM_TYPE = APS_COMM_TYPE;
	}

	public String getAPS_PROMOTE_YN() {
		return APS_PROMOTE_YN;
	}

	public void setAPS_PROMOTE_YN(String APS_PROMOTE_YN) {
		this.APS_PROMOTE_YN = APS_PROMOTE_YN;
	}

	public String getAPS_DEDUCT_YN() {
		return APS_DEDUCT_YN;
	}

	public void setAPS_DEDUCT_YN(String APS_DEDUCT_YN) {
		this.APS_DEDUCT_YN = APS_DEDUCT_YN;
	}

	public String getUI_M_APS_MKT_CODE_DESC() {
		return UI_M_APS_MKT_CODE_DESC;
	}

	public void setUI_M_APS_MKT_CODE_DESC(String UI_M_APS_MKT_CODE_DESC) {
		this.UI_M_APS_MKT_CODE_DESC = UI_M_APS_MKT_CODE_DESC;
	}

	public String getUI_M_APS_RANK_CODE_DESC() {
		return UI_M_APS_RANK_CODE_DESC;
	}

	public void setUI_M_APS_RANK_CODE_DESC(String UI_M_APS_RANK_CODE_DESC) {
		this.UI_M_APS_RANK_CODE_DESC = UI_M_APS_RANK_CODE_DESC;
	}
	

	public String getROWID() {
	  return ROWID;
	}	 

	public void setROWID(String rowid) {
	  ROWID = rowid;
	}

	public String getAPS_CR_UID() {
		return APS_CR_UID;
	}

	public void setAPS_CR_UID(String aps_cr_uid) {
		APS_CR_UID = aps_cr_uid;
	}

	public Date getAPS_CR_DT() {
		return APS_CR_DT;
	}

	public void setAPS_CR_DT(Date aps_cr_dt) {
		APS_CR_DT = aps_cr_dt;
	}

	public String getAPS_UPD_UID() {
	    return APS_UPD_UID;
	}

	public void setAPS_UPD_UID(String aps_upd_uid) {
	    APS_UPD_UID = aps_upd_uid;
	}

	public Date getAPS_UPD_DT() {
	    return APS_UPD_DT;
	}

	public void setAPS_UPD_DT(Date aps_upd_dt) {
	    APS_UPD_DT = aps_upd_dt;
	}
}

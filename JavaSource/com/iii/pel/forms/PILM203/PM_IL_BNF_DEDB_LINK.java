package com.iii.pel.forms.PILM203;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BNF_DEDB_LINK")
public class PM_IL_BNF_DEDB_LINK extends BaseValueBean {

	@Column(name="BDL_FRZ_FLAG")
	private String BDL_FRZ_FLAG;
	
	private boolean freezSelect;

	@Column(name="BDL_COVER_CODE")
	private String BDL_COVER_CODE;
	
	@Column(name="BDL_BNF_CODE")
	private String BDL_BNF_CODE;
	
	@Column(name="BDEL_DEDB_CODE")
	private String BDEL_DEDB_CODE;

	private String UI_M_BDEL_BNF_DESC;

	@Column(name="BDL_DEDB_NO_OF_DAYS")
	private Double BDL_DEDB_NO_OF_DAYS;

	@Column(name="BDL_DEDB_PERC")
	private Double BDL_DEDB_PERC;

	@Column(name="BDL_DEDB_MIN_AMT")
	private Double BDL_DEDB_MIN_AMT;

	@Column(name="BDL_DEDB_DFLT_YN")
	private String BDL_DEDB_DFLT_YN;
	
	@Column(name="BDL_CR_DT")
	private Date BDL_CR_DT;

	@Column(name="BDL_CR_UID")
	private String BDL_CR_UID;
	
	@Column(name="BDL_UPD_DT")
	private Date BDL_UPD_DT;
	
	@Column(name="BDL_UPD_UID")
	private String BDL_UPD_UID;	
	
	private boolean CHECK_BOX;
	
	private boolean daysDisabled;
	private boolean percDisabled;
	
	public String getBDL_FRZ_FLAG() {
		if(isFreezSelect() == true) {
			setBDL_FRZ_FLAG("Y");
		} else {
			setBDL_FRZ_FLAG("N");
		}
		return BDL_FRZ_FLAG;
	}

	public void setBDL_FRZ_FLAG(String BDL_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(BDL_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.BDL_FRZ_FLAG = BDL_FRZ_FLAG;
	}

	public String getBDEL_DEDB_CODE() {
		return BDEL_DEDB_CODE;
	}

	public void setBDEL_DEDB_CODE(String BDEL_DEDB_CODE) {
		this.BDEL_DEDB_CODE = BDEL_DEDB_CODE;
	}

	public String getUI_M_BDEL_BNF_DESC() {
		return UI_M_BDEL_BNF_DESC;
	}

	public void setUI_M_BDEL_BNF_DESC(String UI_M_BDEL_BNF_DESC) {
		this.UI_M_BDEL_BNF_DESC = UI_M_BDEL_BNF_DESC;
	}

	public Double getBDL_DEDB_NO_OF_DAYS() {
		return BDL_DEDB_NO_OF_DAYS;
	}

	public void setBDL_DEDB_NO_OF_DAYS(Double BDL_DEDB_NO_OF_DAYS) {
		this.BDL_DEDB_NO_OF_DAYS = BDL_DEDB_NO_OF_DAYS;
	}

	public Double getBDL_DEDB_PERC() {
		return BDL_DEDB_PERC;
	}

	public void setBDL_DEDB_PERC(Double BDL_DEDB_PERC) {
		this.BDL_DEDB_PERC = BDL_DEDB_PERC;
	}

	public Double getBDL_DEDB_MIN_AMT() {
		return BDL_DEDB_MIN_AMT;
	}

	public void setBDL_DEDB_MIN_AMT(Double BDL_DEDB_MIN_AMT) {
		this.BDL_DEDB_MIN_AMT = BDL_DEDB_MIN_AMT;
	}

	public String getBDL_DEDB_DFLT_YN() {
		return BDL_DEDB_DFLT_YN;
	}

	public void setBDL_DEDB_DFLT_YN(String BDL_DEDB_DFLT_YN) {
		this.BDL_DEDB_DFLT_YN = BDL_DEDB_DFLT_YN;
	}

	public Date getBDL_CR_DT() {
		return BDL_CR_DT;
	}

	public void setBDL_CR_DT(Date bdl_cr_dt) {
		BDL_CR_DT = bdl_cr_dt;
	}

	public String getBDL_CR_UID() {
		return BDL_CR_UID;
	}

	public void setBDL_CR_UID(String bdl_cr_uid) {
		BDL_CR_UID = bdl_cr_uid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
	}

	public String getBDL_COVER_CODE() {
		return BDL_COVER_CODE;
	}

	public void setBDL_COVER_CODE(String bdl_cover_code) {
		BDL_COVER_CODE = bdl_cover_code;
	}

	public String getBDL_BNF_CODE() {
		return BDL_BNF_CODE;
	}

	public void setBDL_BNF_CODE(String bdl_bnf_code) {
		BDL_BNF_CODE = bdl_bnf_code;
	}

	public Date getBDL_UPD_DT() {
		return BDL_UPD_DT;
	}

	public void setBDL_UPD_DT(Date bdl_upd_dt) {
		BDL_UPD_DT = bdl_upd_dt;
	}

	public String getBDL_UPD_UID() {
		return BDL_UPD_UID;
	}

	public void setBDL_UPD_UID(String bdl_upd_uid) {
		BDL_UPD_UID = bdl_upd_uid;
	}

	public boolean isDaysDisabled() {
		return daysDisabled;
	}

	public void setDaysDisabled(boolean daysDisabled) {
		this.daysDisabled = daysDisabled;
	}

	public boolean isPercDisabled() {
		return percDisabled;
	}

	public void setPercDisabled(boolean percDisabled) {
		this.percDisabled = percDisabled;
	}

}
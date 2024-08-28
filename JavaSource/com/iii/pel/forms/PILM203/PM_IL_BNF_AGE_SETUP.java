package com.iii.pel.forms.PILM203;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BNF_AGE_SETUP")
public class PM_IL_BNF_AGE_SETUP extends BaseValueBean {

	@Column(name="BAS_FRZ_FLAG")
	private String BAS_FRZ_FLAG;

	private boolean freezSelect;

	@Column(name="BAS_AS_CODE")
	private String BAS_AS_CODE;

	@Column(name="BAS_COVER_CODE")
	private String BAS_COVER_CODE;

	@Column(name="BAS_BNF_CODE")
	private String BAS_BNF_CODE;	

	private String UI_M_AS_DESC;

	@Column(name="BAS_CATG_CODE")
	private String BAS_CATG_CODE;

	@Column(name="BAS_CR_DT")
	private Date BAS_CR_DT;

	@Column(name="BAS_CR_UID")
	private String BAS_CR_UID;

	@Column(name="BAS_UPD_DT")
	private Date BAS_UPD_DT;

	@Column(name="BAS_UPD_UID")
	private String BAS_UPD_UID;	

	private boolean CHECK_BOX;

	public String getBAS_FRZ_FLAG() {
		if(isFreezSelect() == true) {
			setBAS_FRZ_FLAG("Y");
		} else {
			setBAS_FRZ_FLAG("N");
		}
		return BAS_FRZ_FLAG;
	}

	public void setBAS_FRZ_FLAG(String BAS_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(BAS_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.BAS_FRZ_FLAG = BAS_FRZ_FLAG;
	}

	public String getBAS_AS_CODE() {
		return BAS_AS_CODE;
	}

	public void setBAS_AS_CODE(String BAS_AS_CODE) {
		this.BAS_AS_CODE = BAS_AS_CODE;
	}

	public String getUI_M_AS_DESC() {
		return UI_M_AS_DESC;
	}

	public void setUI_M_AS_DESC(String UI_M_AS_DESC) {
		this.UI_M_AS_DESC = UI_M_AS_DESC;
	}

	public String getBAS_CATG_CODE() {
		return BAS_CATG_CODE;
	}

	public void setBAS_CATG_CODE(String BAS_CATG_CODE) {
		this.BAS_CATG_CODE = BAS_CATG_CODE;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getBAS_CR_DT() {
		return BAS_CR_DT;
	}

	public void setBAS_CR_DT(Date bas_cr_dt) {
		BAS_CR_DT = bas_cr_dt;
	}

	public String getBAS_CR_UID() {
		return BAS_CR_UID;
	}

	public void setBAS_CR_UID(String bas_cr_uid) {
		BAS_CR_UID = bas_cr_uid;
	}

	public Date getBAS_UPD_DT() {
		return BAS_UPD_DT;
	}

	public void setBAS_UPD_DT(Date bas_upd_dt) {
		BAS_UPD_DT = bas_upd_dt;
	}

	public String getBAS_UPD_UID() {
		return BAS_UPD_UID;
	}

	public void setBAS_UPD_UID(String bas_upd_uid) {
		BAS_UPD_UID = bas_upd_uid;
	}

	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
	}

	public String getBAS_COVER_CODE() {
		return BAS_COVER_CODE;
	}

	public void setBAS_COVER_CODE(String bas_cover_code) {
		BAS_COVER_CODE = bas_cover_code;
	}

	public String getBAS_BNF_CODE() {
		return BAS_BNF_CODE;
	}

	public void setBAS_BNF_CODE(String bas_bnf_code) {
		BAS_BNF_CODE = bas_bnf_code;
	}
}
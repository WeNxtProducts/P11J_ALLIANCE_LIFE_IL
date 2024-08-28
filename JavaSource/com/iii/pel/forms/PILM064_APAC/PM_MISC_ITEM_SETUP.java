package com.iii.pel.forms.PILM064_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_MISC_ITEM_SETUP")
public class PM_MISC_ITEM_SETUP extends BaseValueBean {

	@Column(name="MIS_SETUP_TYPE")
	private String MIS_SETUP_TYPE;

	@Column(name="MIS_BUS_FM_CODE")
	private String MIS_BUS_FM_CODE;

	@Column(name="MIS_BUS_TO_CODE")
	private String MIS_BUS_TO_CODE;

	@Column(name="MIS_DIVN_FM_CODE")
	private String MIS_DIVN_FM_CODE;

	@Column(name="MIS_DIVN_TO_CODE")
	private String MIS_DIVN_TO_CODE;

	@Column(name="MIS_DEPT_FM_CODE")
	private String MIS_DEPT_FM_CODE;

	@Column(name="MIS_DEPT_TO_CODE")
	private String MIS_DEPT_TO_CODE;

	@Column(name="MIS_DOC_FM_TYPE")
	private String MIS_DOC_FM_TYPE;

	@Column(name="MIS_DOC_TO_TYPE")
	private String MIS_DOC_TO_TYPE;

	@Column(name="MIS_TYPE_FM_CODE")
	private String MIS_TYPE_FM_CODE;

	@Column(name="MIS_TYPE_TO_CODE")
	private String MIS_TYPE_TO_CODE;

	@Column(name="MIS_FORCE_DIVN_YN")
	private String MIS_FORCE_DIVN_YN;

	@Column(name="MIS_FORCE_DEPT_YN")
	private String MIS_FORCE_DEPT_YN;

	@Column(name="MIS_MAIN_ACNT_CODE")
	private String MIS_MAIN_ACNT_CODE;

	@Column(name="MIS_SUB_ACNT_CODE")
	private String MIS_SUB_ACNT_CODE;

	@Column(name="MIS_DIVN_CODE")
	private String MIS_DIVN_CODE;

	@Column(name="MIS_DEPT_CODE")
	private String MIS_DEPT_CODE;

	@Column(name="MIS_ANLY_CODE_1")
	private String MIS_ANLY_CODE_1;

	@Column(name="MIS_ANLY_CODE_2")
	private String MIS_ANLY_CODE_2;

	@Column(name="MIS_ACTY_CODE_1")
	private String MIS_ACTY_CODE_1;

	@Column(name="MIS_ACTY_CODE_2")
	private String MIS_ACTY_CODE_2;

	@Column(name="MIS_FRZ_FLAG")
	private String MIS_FRZ_FLAG;

	@Column(name="MIS_CR_DT")
	private Date MIS_CR_DT;

	@Column(name="MIS_CR_UID")
	private String MIS_CR_UID;

	@Column(name="MIS_UPD_DT")
	private Date MIS_UPD_DT;

	@Column(name="MIS_UPD_UID")
	private String MIS_UPD_UID;

	@Column(name="MIS_YRS_FM")
	private Integer MIS_YRS_FM;

	@Column(name="MIS_YRS_TO")
	private Integer MIS_YRS_TO;

	@Column(name="MIS_SETUP_FOR")
	private String MIS_SETUP_FOR;

	@Column(name="MIS_ASSURED_TYPE")
	private String MIS_ASSURED_TYPE;

	@Column(name="MIS_SRC_BUS_FM")
	private String MIS_SRC_BUS_FM;

	@Column(name="MIS_SRC_BUS_TO")
	private String MIS_SRC_BUS_TO;

	@Column(name="MIS_PROD_CODE_FM")
	private String MIS_PROD_CODE_FM;

	@Column(name="MIS_PROD_CODE_TO")
	private String MIS_PROD_CODE_TO;

	@Column(name="MIS_COVER_CODE_FM")
	private String MIS_COVER_CODE_FM;

	@Column(name="MIS_COVER_CODE_TO")
	private String MIS_COVER_CODE_TO;
	private String MIS_TYPE_FM_CODE_DESC;

	private String UI_M_MAIN_ACNT_NAME;
	private String UI_M_SUB_ACNT_NAME;
	private String UI_M_DIVN_NAME;
	private String UI_M_DEPT_NAME;
	private String UI_M_ANLY_NAME;
	private String UI_M_ANLY_NAME_1;
	private String UI_M_ACTY_NAME;
	private String UI_M_ACTY_NAME_1;
	private String UI_M_ACTY_HEAD_1;
	private String UI_M_ACTY_HEAD_2;
	private String UI_M_ACTY_1;
	private String UI_M_ACTY_2;
	private boolean MIS_FRZ_FLAG_VALUE;
	public String getUI_M_ACTY_1() {
		return UI_M_ACTY_1;
		
	}
	public void setUI_M_ACTY_1(String m_acty_1) {
		UI_M_ACTY_1 = m_acty_1;
	}
	public String getUI_M_ACTY_2() {
		return UI_M_ACTY_2;
	}
	public void setUI_M_ACTY_2(String m_acty_2) {
		UI_M_ACTY_2 = m_acty_2;
	}
	public void setMIS_ASSURED_TYPE(String MIS_ASSURED_TYPE) {
		this.MIS_ASSURED_TYPE = MIS_ASSURED_TYPE;
	}
	public String getMIS_ASSURED_TYPE() {
		 return MIS_ASSURED_TYPE;
	}
	public void setMIS_MAIN_ACNT_CODE(String MIS_MAIN_ACNT_CODE) {
		this.MIS_MAIN_ACNT_CODE = MIS_MAIN_ACNT_CODE;
	}
	public String getMIS_MAIN_ACNT_CODE() {
		 return MIS_MAIN_ACNT_CODE;
	}
	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}
	public String getUI_M_MAIN_ACNT_NAME() {
		 return UI_M_MAIN_ACNT_NAME;
	}
	public void setMIS_DOC_FM_TYPE(String MIS_DOC_FM_TYPE) {
		this.MIS_DOC_FM_TYPE = MIS_DOC_FM_TYPE;
	}
	public String getMIS_DOC_FM_TYPE() {
		 return MIS_DOC_FM_TYPE;
	}
	public void setMIS_DIVN_TO_CODE(String MIS_DIVN_TO_CODE) {
		this.MIS_DIVN_TO_CODE = MIS_DIVN_TO_CODE;
	}
	public String getMIS_DIVN_TO_CODE() {
		 return MIS_DIVN_TO_CODE;
	}
	public void setMIS_ACTY_CODE_1(String MIS_ACTY_CODE_1) {
		this.MIS_ACTY_CODE_1 = MIS_ACTY_CODE_1;
	}
	public String getMIS_ACTY_CODE_1() {
		 return MIS_ACTY_CODE_1;
	}
	public void setMIS_ACTY_CODE_2(String MIS_ACTY_CODE_2) {
		this.MIS_ACTY_CODE_2 = MIS_ACTY_CODE_2;
	}
	public String getMIS_ACTY_CODE_2() {
		 return MIS_ACTY_CODE_2;
	}
	public void setMIS_ANLY_CODE_1(String MIS_ANLY_CODE_1) {
		this.MIS_ANLY_CODE_1 = MIS_ANLY_CODE_1;
	}
	public String getMIS_ANLY_CODE_1() {
		 return MIS_ANLY_CODE_1;
	}
	public void setMIS_CR_UID(String MIS_CR_UID) {
		this.MIS_CR_UID = MIS_CR_UID;
	}
	public String getMIS_CR_UID() {
		 return MIS_CR_UID;
	}
	public void setMIS_ANLY_CODE_2(String MIS_ANLY_CODE_2) {
		this.MIS_ANLY_CODE_2 = MIS_ANLY_CODE_2;
	}
	public String getMIS_ANLY_CODE_2() {
		 return MIS_ANLY_CODE_2;
	}
	public void setMIS_FRZ_FLAG(String MIS_FRZ_FLAG) {
		this.MIS_FRZ_FLAG = MIS_FRZ_FLAG;
		if (MIS_FRZ_FLAG.equals("N")) {
			MIS_FRZ_FLAG_VALUE = false;
		}else if (MIS_FRZ_FLAG.equals("Y")) {
			MIS_FRZ_FLAG_VALUE = true;
		}
	}
	public String getMIS_FRZ_FLAG() {
		 return MIS_FRZ_FLAG;
	}
	public void setMIS_BUS_FM_CODE(String MIS_BUS_FM_CODE) {
		this.MIS_BUS_FM_CODE = MIS_BUS_FM_CODE;
	}
	public String getMIS_BUS_FM_CODE() {
		 return MIS_BUS_FM_CODE;
	}
	public void setMIS_COVER_CODE_FM(String MIS_COVER_CODE_FM) {
		this.MIS_COVER_CODE_FM = MIS_COVER_CODE_FM;
	}
	public String getMIS_COVER_CODE_FM() {
		 return MIS_COVER_CODE_FM;
	}
	public void setMIS_FORCE_DEPT_YN(String MIS_FORCE_DEPT_YN) {
		this.MIS_FORCE_DEPT_YN = MIS_FORCE_DEPT_YN;
	}
	public String getMIS_FORCE_DEPT_YN() {
		 return MIS_FORCE_DEPT_YN;
	}
	public void setMIS_DOC_TO_TYPE(String MIS_DOC_TO_TYPE) {
		this.MIS_DOC_TO_TYPE = MIS_DOC_TO_TYPE;
	}
	public String getMIS_DOC_TO_TYPE() {
		 return MIS_DOC_TO_TYPE;
	}
	public void setMIS_BUS_TO_CODE(String MIS_BUS_TO_CODE) {
		this.MIS_BUS_TO_CODE = MIS_BUS_TO_CODE;
	}
	public String getMIS_BUS_TO_CODE() {
		 return MIS_BUS_TO_CODE;
	}
	public void setMIS_PROD_CODE_FM(String MIS_PROD_CODE_FM) {
		this.MIS_PROD_CODE_FM = MIS_PROD_CODE_FM;
	}
	public String getMIS_PROD_CODE_FM() {
		 return MIS_PROD_CODE_FM;
	}
	public void setMIS_SUB_ACNT_CODE(String MIS_SUB_ACNT_CODE) {
		this.MIS_SUB_ACNT_CODE = MIS_SUB_ACNT_CODE;
	}
	public String getMIS_SUB_ACNT_CODE() {
		 return MIS_SUB_ACNT_CODE;
	}
	public void setMIS_SRC_BUS_FM(String MIS_SRC_BUS_FM) {
		this.MIS_SRC_BUS_FM = MIS_SRC_BUS_FM;
	}
	public String getMIS_SRC_BUS_FM() {
		 return MIS_SRC_BUS_FM;
	}
	public void setMIS_SETUP_FOR(String MIS_SETUP_FOR) {
		this.MIS_SETUP_FOR = MIS_SETUP_FOR;
	}
	public String getMIS_SETUP_FOR() {
		 return MIS_SETUP_FOR;
	}
	public void setMIS_DEPT_FM_CODE(String MIS_DEPT_FM_CODE) {
		this.MIS_DEPT_FM_CODE = MIS_DEPT_FM_CODE;
	}
	public String getMIS_DEPT_FM_CODE() {
		 return MIS_DEPT_FM_CODE;
	}
	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}
	public String getUI_M_SUB_ACNT_NAME() {
		 return UI_M_SUB_ACNT_NAME;
	}
	public void setMIS_DIVN_CODE(String MIS_DIVN_CODE) {
		this.MIS_DIVN_CODE = MIS_DIVN_CODE;
	}
	public String getMIS_DIVN_CODE() {
		 return MIS_DIVN_CODE;
	}
	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}
	public String getUI_M_ACTY_NAME_1() {
		 return UI_M_ACTY_NAME_1;
	}
	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}
	public String getUI_M_ACTY_NAME() {
		 return UI_M_ACTY_NAME;
	}
	public void setMIS_UPD_DT(Date MIS_UPD_DT) {
		this.MIS_UPD_DT = MIS_UPD_DT;
	}
	public Date getMIS_UPD_DT() {
		 return MIS_UPD_DT;
	}
	public void setMIS_PROD_CODE_TO(String MIS_PROD_CODE_TO) {
		this.MIS_PROD_CODE_TO = MIS_PROD_CODE_TO;
	}
	public String getMIS_PROD_CODE_TO() {
		 return MIS_PROD_CODE_TO;
	}
	public void setMIS_CR_DT(Date MIS_CR_DT) {
		this.MIS_CR_DT = MIS_CR_DT;
	}
	public Date getMIS_CR_DT() {
		 return MIS_CR_DT;
	}
	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}
	public String getUI_M_ANLY_NAME() {
		 return UI_M_ANLY_NAME;
	}
	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}
	public String getUI_M_DEPT_NAME() {
		 return UI_M_DEPT_NAME;
	}
	public void setMIS_COVER_CODE_TO(String MIS_COVER_CODE_TO) {
		this.MIS_COVER_CODE_TO = MIS_COVER_CODE_TO;
	}
	public String getMIS_COVER_CODE_TO() {
		 return MIS_COVER_CODE_TO;
	}
	public void setMIS_UPD_UID(String MIS_UPD_UID) {
		this.MIS_UPD_UID = MIS_UPD_UID;
	}
	public String getMIS_UPD_UID() {
		 return MIS_UPD_UID;
	}
	public void setMIS_FORCE_DIVN_YN(String MIS_FORCE_DIVN_YN) {
		this.MIS_FORCE_DIVN_YN = MIS_FORCE_DIVN_YN;
	}
	public String getMIS_FORCE_DIVN_YN() {
		 return MIS_FORCE_DIVN_YN;
	}
	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}
	public String getUI_M_DIVN_NAME() {
		 return UI_M_DIVN_NAME;
	}
	public void setMIS_SRC_BUS_TO(String MIS_SRC_BUS_TO) {
		this.MIS_SRC_BUS_TO = MIS_SRC_BUS_TO;
	}
	public String getMIS_SRC_BUS_TO() {
		 return MIS_SRC_BUS_TO;
	}
	public void setMIS_DEPT_TO_CODE(String MIS_DEPT_TO_CODE) {
		this.MIS_DEPT_TO_CODE = MIS_DEPT_TO_CODE;
	}
	public String getMIS_DEPT_TO_CODE() {
		 return MIS_DEPT_TO_CODE;
	}

	public void setMIS_TYPE_FM_CODE(String MIS_TYPE_FM_CODE) {
		this.MIS_TYPE_FM_CODE = MIS_TYPE_FM_CODE;
	}
	public String getMIS_TYPE_FM_CODE() {
		 return MIS_TYPE_FM_CODE;
	}
	public void setMIS_TYPE_TO_CODE(String MIS_TYPE_TO_CODE) {
		this.MIS_TYPE_TO_CODE = MIS_TYPE_TO_CODE;
	}
	public String getMIS_TYPE_TO_CODE() {
		 return MIS_TYPE_TO_CODE;
	}
	public void setMIS_DEPT_CODE(String MIS_DEPT_CODE) {
		this.MIS_DEPT_CODE = MIS_DEPT_CODE;
	}
	public String getMIS_DEPT_CODE() {
		 return MIS_DEPT_CODE;
	}
	public void setMIS_DIVN_FM_CODE(String MIS_DIVN_FM_CODE) {
		this.MIS_DIVN_FM_CODE = MIS_DIVN_FM_CODE;
	}
	public String getMIS_DIVN_FM_CODE() {
		 return MIS_DIVN_FM_CODE;
	}
	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}
	public String getUI_M_ANLY_NAME_1() {
		 return UI_M_ANLY_NAME_1;
	}
	public void setMIS_SETUP_TYPE(String MIS_SETUP_TYPE) {
		this.MIS_SETUP_TYPE = MIS_SETUP_TYPE;
	}
	public String getMIS_SETUP_TYPE() {
		 return MIS_SETUP_TYPE;
	}
	public String getUI_M_ACTY_HEAD_1() {
		return UI_M_ACTY_HEAD_1;
	}
	public void setUI_M_ACTY_HEAD_1(String ui_m_acty_head_1) {
		UI_M_ACTY_HEAD_1 = ui_m_acty_head_1;
	}
	public String getUI_M_ACTY_HEAD_2() {
		return UI_M_ACTY_HEAD_2;
	}
	public void setUI_M_ACTY_HEAD_2(String ui_m_acty_head_2) {
		UI_M_ACTY_HEAD_2 = ui_m_acty_head_2;
	}
	public Integer getMIS_YRS_FM() {
		return MIS_YRS_FM;
	}
	public void setMIS_YRS_FM(Integer mis_yrs_fm) {
		MIS_YRS_FM = mis_yrs_fm;
	}
	public Integer getMIS_YRS_TO() {
		return MIS_YRS_TO;
	}
	public void setMIS_YRS_TO(Integer mis_yrs_to) {
		MIS_YRS_TO = mis_yrs_to;
	}
	public String getMIS_TYPE_FM_CODE_DESC() {
		return MIS_TYPE_FM_CODE_DESC;
	}
	public void setMIS_TYPE_FM_CODE_DESC(String mis_type_fm_code_desc) {
		MIS_TYPE_FM_CODE_DESC = mis_type_fm_code_desc;
	}
	public boolean isMIS_FRZ_FLAG_VALUE() {
		return MIS_FRZ_FLAG_VALUE;
	}

	public void setMIS_FRZ_FLAG_VALUE(boolean mis_frz_flag_value) {
		if (mis_frz_flag_value == true) {
			MIS_FRZ_FLAG = "Y";
		}else if (mis_frz_flag_value == false) {
			MIS_FRZ_FLAG = "N";
		}
		
		
	}
	
	
}
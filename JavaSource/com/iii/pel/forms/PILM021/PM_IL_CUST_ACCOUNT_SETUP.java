package com.iii.pel.forms.PILM021;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CUST_ACCOUNT_SETUP")
public class PM_IL_CUST_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="CAS_FRZ_FLAG")
	private String CAS_FRZ_FLAG;

	private boolean FRZ_FLAG;
	
	@Column(name="CAS_SRC_BUS_FM")
	private String CAS_SRC_BUS_FM;

	@Column(name="CAS_SRC_BUS_TO")
	private String CAS_SRC_BUS_TO;

	@Column(name="CAS_CUST_FM_CLASS")
	private String CAS_CUST_FM_CLASS;

	@Column(name="CAS_CUST_TO_CLASS")
	private String CAS_CUST_TO_CLASS;

	@Column(name="CAS_DIVN_FM_CODE")
	private String CAS_DIVN_FM_CODE;

	@Column(name="CAS_DIVN_TO_CODE")
	private String CAS_DIVN_TO_CODE;

	@Column(name="CAS_DEPT_FM_CODE")
	private String CAS_DEPT_FM_CODE;

	@Column(name="CAS_DEPT_TO_CODE")
	private String CAS_DEPT_TO_CODE;

	@Column(name="CAS_BUS_TYPE_FM")
	private String CAS_BUS_TYPE_FM;

	@Column(name="CAS_BUS_TYPE_TO")
	private String CAS_BUS_TYPE_TO;

	@Column(name="CAS_ASSURED_TYPE")
	private String CAS_ASSURED_TYPE;

	@Column(name="CAS_FORCE_DIVN_YN")
	private String CAS_FORCE_DIVN_YN;

	@Column(name="CAS_FORCE_DEPT_YN")
	private String CAS_FORCE_DEPT_YN;

	@Column(name="CAS_MAIN_ACNT_CODE")
	private String CAS_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="CAS_DIVN_CODE")
	private String CAS_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="CAS_DEPT_CODE")
	private String CAS_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="CAS_ANLY_CODE_1")
	private String CAS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="CAS_ANLY_CODE_2")
	private String CAS_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="CAS_ACTY_CODE_1")
	private String CAS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="CAS_ACTY_CODE_2")
	private String CAS_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	private String UI_M_BUS_TYPE_FM_DESC;

	private String UI_M_BUS_TYPE_TO_DESC;

	String CAS_FORCE_DIVN_YN_LIST;

	String CAS_FORCE_DEPT_YN_LIST;

	String CAS_ASSURED_TYPE_LIST;
	
	private String focusBean;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	public String getROWID() {
	  return ROWID;
	}

	public void setROWID(String rowid) {
	  ROWID = rowid;
	}
	
	@Column(name="CAS_CR_DT")
	private Date CAS_CR_DT;
	
	@Column(name="CAS_CR_UID")
	private String CAS_CR_UID;
	
	@Column(name="CAS_UPD_DT")
	private Date CAS_UPD_DT;
	
	@Column(name="CAS_UPD_UID")
	private String CAS_UPD_UID;
	
	private boolean rendered=false;

	private boolean insertMode=true;
	
	private boolean CHECK_BOX = false;
	
	private boolean selected;
	
	
	
	
	
	

	  /*As suggested by siva sir sadded by gopi for toi on 04/09/2018*/
		@Column(name = "CAS_DOC_DRCR")
		private String CAS_DOC_DRCR;


		public String getCAS_DOC_DRCR() {
			return CAS_DOC_DRCR;
		}

		public void setCAS_DOC_DRCR(String cAS_DOC_DRCR) {
			CAS_DOC_DRCR = cAS_DOC_DRCR;
		} 
		
	//end

	public String getCAS_FRZ_FLAG() {
		return CAS_FRZ_FLAG;
	}

	public void setCAS_FRZ_FLAG(String CAS_FRZ_FLAG) {
		this.CAS_FRZ_FLAG = CAS_FRZ_FLAG;
	}

	public String getCAS_SRC_BUS_FM() {
		return CAS_SRC_BUS_FM;
	}

	public void setCAS_SRC_BUS_FM(String CAS_SRC_BUS_FM) {
		this.CAS_SRC_BUS_FM = CAS_SRC_BUS_FM;
	}

	public String getCAS_SRC_BUS_TO() {
		return CAS_SRC_BUS_TO;
	}

	public void setCAS_SRC_BUS_TO(String CAS_SRC_BUS_TO) {
		this.CAS_SRC_BUS_TO = CAS_SRC_BUS_TO;
	}

	public String getCAS_CUST_FM_CLASS() {
		return CAS_CUST_FM_CLASS;
	}

	public void setCAS_CUST_FM_CLASS(String CAS_CUST_FM_CLASS) {
		this.CAS_CUST_FM_CLASS = CAS_CUST_FM_CLASS;
	}

	public String getCAS_CUST_TO_CLASS() {
		return CAS_CUST_TO_CLASS;
	}

	public void setCAS_CUST_TO_CLASS(String CAS_CUST_TO_CLASS) {
		this.CAS_CUST_TO_CLASS = CAS_CUST_TO_CLASS;
	}

	public String getCAS_DIVN_FM_CODE() {
		return CAS_DIVN_FM_CODE;
	}

	public void setCAS_DIVN_FM_CODE(String CAS_DIVN_FM_CODE) {
		this.CAS_DIVN_FM_CODE = CAS_DIVN_FM_CODE;
	}

	public String getCAS_DIVN_TO_CODE() {
		return CAS_DIVN_TO_CODE;
	}

	public void setCAS_DIVN_TO_CODE(String CAS_DIVN_TO_CODE) {
		this.CAS_DIVN_TO_CODE = CAS_DIVN_TO_CODE;
	}

	public String getCAS_DEPT_FM_CODE() {
		return CAS_DEPT_FM_CODE;
	}

	public void setCAS_DEPT_FM_CODE(String CAS_DEPT_FM_CODE) {
		this.CAS_DEPT_FM_CODE = CAS_DEPT_FM_CODE;
	}

	public String getCAS_DEPT_TO_CODE() {
		return CAS_DEPT_TO_CODE;
	}

	public void setCAS_DEPT_TO_CODE(String CAS_DEPT_TO_CODE) {
		this.CAS_DEPT_TO_CODE = CAS_DEPT_TO_CODE;
	}

	public String getCAS_BUS_TYPE_FM() {
		return CAS_BUS_TYPE_FM;
	}

	public void setCAS_BUS_TYPE_FM(String CAS_BUS_TYPE_FM) {
		this.CAS_BUS_TYPE_FM = CAS_BUS_TYPE_FM;
	}

	public String getCAS_BUS_TYPE_TO() {
		return CAS_BUS_TYPE_TO;
	}

	public void setCAS_BUS_TYPE_TO(String CAS_BUS_TYPE_TO) {
		this.CAS_BUS_TYPE_TO = CAS_BUS_TYPE_TO;
	}

	public String getCAS_ASSURED_TYPE() {
		return CAS_ASSURED_TYPE;
	}

	public void setCAS_ASSURED_TYPE(String CAS_ASSURED_TYPE) {
		this.CAS_ASSURED_TYPE = CAS_ASSURED_TYPE;
	}

	public String getCAS_FORCE_DIVN_YN() {
		return CAS_FORCE_DIVN_YN;
	}

	public void setCAS_FORCE_DIVN_YN(String CAS_FORCE_DIVN_YN) {
		this.CAS_FORCE_DIVN_YN = CAS_FORCE_DIVN_YN;
		this.setCAS_FORCE_DEPT_YN(CAS_FORCE_DIVN_YN);
	}

	public String getCAS_FORCE_DEPT_YN() {
		return CAS_FORCE_DEPT_YN;
	}

	public void setCAS_FORCE_DEPT_YN(String CAS_FORCE_DEPT_YN) {
		this.CAS_FORCE_DEPT_YN = CAS_FORCE_DEPT_YN;
	}

	public String getCAS_MAIN_ACNT_CODE() {
		return CAS_MAIN_ACNT_CODE;
	}

	public void setCAS_MAIN_ACNT_CODE(String CAS_MAIN_ACNT_CODE) {
		this.CAS_MAIN_ACNT_CODE = CAS_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getCAS_DIVN_CODE() {
		return CAS_DIVN_CODE;
	}

	public void setCAS_DIVN_CODE(String CAS_DIVN_CODE) {
		this.CAS_DIVN_CODE = CAS_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getCAS_DEPT_CODE() {
		return CAS_DEPT_CODE;
	}

	public void setCAS_DEPT_CODE(String CAS_DEPT_CODE) {
		this.CAS_DEPT_CODE = CAS_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getCAS_ANLY_CODE_1() {
		return CAS_ANLY_CODE_1;
	}

	public void setCAS_ANLY_CODE_1(String CAS_ANLY_CODE_1) {
		this.CAS_ANLY_CODE_1 = CAS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getCAS_ANLY_CODE_2() {
		return CAS_ANLY_CODE_2;
	}

	public void setCAS_ANLY_CODE_2(String CAS_ANLY_CODE_2) {
		this.CAS_ANLY_CODE_2 = CAS_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getCAS_ACTY_CODE_1() {
		return CAS_ACTY_CODE_1;
	}

	public void setCAS_ACTY_CODE_1(String CAS_ACTY_CODE_1) {
		this.CAS_ACTY_CODE_1 = CAS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getCAS_ACTY_CODE_2() {
		return CAS_ACTY_CODE_2;
	}

	public void setCAS_ACTY_CODE_2(String CAS_ACTY_CODE_2) {
		this.CAS_ACTY_CODE_2 = CAS_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getUI_M_BUS_TYPE_FM_DESC() {
		return UI_M_BUS_TYPE_FM_DESC;
	}

	public void setUI_M_BUS_TYPE_FM_DESC(String UI_M_BUS_TYPE_FM_DESC) {
		this.UI_M_BUS_TYPE_FM_DESC = UI_M_BUS_TYPE_FM_DESC;
	}

	public String getUI_M_BUS_TYPE_TO_DESC() {
		return UI_M_BUS_TYPE_TO_DESC;
	}

	public void setUI_M_BUS_TYPE_TO_DESC(String UI_M_BUS_TYPE_TO_DESC) {
		this.UI_M_BUS_TYPE_TO_DESC = UI_M_BUS_TYPE_TO_DESC;
	}

	public Date getCAS_CR_DT() {
		return CAS_CR_DT;
	}

	public void setCAS_CR_DT(Date cas_cr_dt) {
		CAS_CR_DT = cas_cr_dt;
	}

	public String getCAS_CR_UID() {
		return CAS_CR_UID;
	}

	public void setCAS_CR_UID(String cas_cr_uid) {
		CAS_CR_UID = cas_cr_uid;
	}

	public Date getCAS_UPD_DT() {
		return CAS_UPD_DT;
	}

	public void setCAS_UPD_DT(Date cas_upd_dt) {
		CAS_UPD_DT = cas_upd_dt;
	}

	public String getCAS_UPD_UID() {
		return CAS_UPD_UID;
	}

	public void setCAS_UPD_UID(String cas_upd_uid) {
		CAS_UPD_UID = cas_upd_uid;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isInsertMode() {
		return insertMode;
	}

	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getFocusBean() {
		return focusBean;
	}

	public void setFocusBean(String focusBean) {
		this.focusBean = focusBean;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean frz_flag) {
		FRZ_FLAG = frz_flag;
	}

	public String getCAS_FORCE_DIVN_YN_LIST() {
		return CAS_FORCE_DIVN_YN_LIST;
	}

	public void setCAS_FORCE_DIVN_YN_LIST(String cas_force_divn_yn_list) {
		CAS_FORCE_DIVN_YN_LIST = cas_force_divn_yn_list;
	}

	public String getCAS_FORCE_DEPT_YN_LIST() {
		return CAS_FORCE_DEPT_YN_LIST;
	}

	public void setCAS_FORCE_DEPT_YN_LIST(String cas_force_dept_yn_list) {
		CAS_FORCE_DEPT_YN_LIST = cas_force_dept_yn_list;
	}

	public String getCAS_ASSURED_TYPE_LIST() {
		return CAS_ASSURED_TYPE_LIST;
	}

	public void setCAS_ASSURED_TYPE_LIST(String cas_assured_type_list) {
		CAS_ASSURED_TYPE_LIST = cas_assured_type_list;
	}
}

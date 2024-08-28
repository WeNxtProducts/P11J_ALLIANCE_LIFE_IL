package com.iii.pel.forms.PILM052_APAC;

import java.util.Date;

import org.syntax.jedit.InputHandler.prev_char;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PM_DEPT_DRCR_LINK")
public class PM_DEPT_DRCR_LINK extends BaseValueBean {

	@Column(name = "DDL_DIVN_CODE")
	private String DDL_DIVN_CODE;

	@Column(name = "DDL_DEPT_CODE")
	private String DDL_DEPT_CODE;

	@Column(name = "DDL_DR_TXN_CODE")
	private String DDL_DR_TXN_CODE;

	@Column(name = "DDL_CR_TXN_CODE")
	private String DDL_CR_TXN_CODE;

	@Column(name = "DDL_RCT_TXN_CODE")
	private String DDL_RCT_TXN_CODE;

	@Column(name = "DDL_PAY_TXN_CODE")
	private String DDL_PAY_TXN_CODE;

	@Column(name = "DDL_FRZ_FLAG")
	private String DDL_FRZ_FLAG;

	@Column(name = "DDL_CR_DT")
	private Date DDL_CR_DT;

	@Column(name = "DDL_CR_UID")
	private String DDL_CR_UID;

	@Column(name = "DDL_UPD_DT")
	private Date DDL_UPD_DT;

	@Column(name = "DDL_UPD_UID")
	private String DDL_UPD_UID;

	@Column(name = "DDL_TXN_TYPE_FM")
	private String DDL_TXN_TYPE_FM;

	@Column(name = "DDL_TXN_TYPE_TO")
	private String DDL_TXN_TYPE_TO;

	@Column(name = "DDL_JV_TXN_CODE")
	private String DDL_JV_TXN_CODE;

	private String UI_M_DIVN_NAME;
	private String UI_M_DEPT_NAME;
	private String UI_M_TXN_DR_NAME;
	private String UI_M_TXN_CR_NAME;
	private String UI_M_TXN_RCT_NAME;
	private String UI_M_TXN_PAY_NAME;
	private String UI_M_TXN_JV_NAME;
	private String CHECK_DDL_FRZ_FLAG;
	private String UI_M_TXN_FM_DESC;
	private String UI_M_TXN_TO_DESC;
	private boolean DDL_FRZ_FLAG_VALUE;
	
	public void setDDL_PAY_TXN_CODE(String DDL_PAY_TXN_CODE) {
		this.DDL_PAY_TXN_CODE = DDL_PAY_TXN_CODE;
	}

	public String getDDL_PAY_TXN_CODE() {
		return DDL_PAY_TXN_CODE;
	}

	public void setDDL_DEPT_CODE(String DDL_DEPT_CODE) {
		this.DDL_DEPT_CODE = DDL_DEPT_CODE;
	}

	public String getDDL_DEPT_CODE() {
		return DDL_DEPT_CODE;
	}

	public void setDDL_TXN_TYPE_FM(String DDL_TXN_TYPE_FM) {
		this.DDL_TXN_TYPE_FM = DDL_TXN_TYPE_FM;
	}

	public String getDDL_TXN_TYPE_FM() {
		return DDL_TXN_TYPE_FM;
	}

	public void setDDL_CR_UID(String DDL_CR_UID) {
		this.DDL_CR_UID = DDL_CR_UID;
	}

	public String getDDL_CR_UID() {
		return DDL_CR_UID;
	}

	public void setUI_M_TXN_DR_NAME(String UI_M_TXN_DR_NAME) {
		this.UI_M_TXN_DR_NAME = UI_M_TXN_DR_NAME;
	}

	public String getUI_M_TXN_DR_NAME() {
		return UI_M_TXN_DR_NAME;
	}

	public void setUI_M_TXN_PAY_NAME(String UI_M_TXN_PAY_NAME) {
		this.UI_M_TXN_PAY_NAME = UI_M_TXN_PAY_NAME;
	}

	public String getUI_M_TXN_PAY_NAME() {
		return UI_M_TXN_PAY_NAME;
	}

	public void setUI_M_TXN_RCT_NAME(String UI_M_TXN_RCT_NAME) {
		this.UI_M_TXN_RCT_NAME = UI_M_TXN_RCT_NAME;
	}

	public String getUI_M_TXN_RCT_NAME() {
		return UI_M_TXN_RCT_NAME;
	}

	public void setDDL_CR_DT(Date DDL_CR_DT) {
		this.DDL_CR_DT = DDL_CR_DT;
	}

	public Date getDDL_CR_DT() {
		return DDL_CR_DT;
	}

	public void setUI_M_TXN_JV_NAME(String UI_M_TXN_JV_NAME) {
		this.UI_M_TXN_JV_NAME = UI_M_TXN_JV_NAME;
	}

	public String getUI_M_TXN_JV_NAME() {
		return UI_M_TXN_JV_NAME;
	}

	public void setDDL_TXN_TYPE_TO(String DDL_TXN_TYPE_TO) {
		this.DDL_TXN_TYPE_TO = DDL_TXN_TYPE_TO;
	}

	public String getDDL_TXN_TYPE_TO() {
		return DDL_TXN_TYPE_TO;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setDDL_UPD_DT(Date DDL_UPD_DT) {
		this.DDL_UPD_DT = DDL_UPD_DT;
	}

	public Date getDDL_UPD_DT() {
		return DDL_UPD_DT;
	}

	public void setDDL_DIVN_CODE(String DDL_DIVN_CODE) {
		this.DDL_DIVN_CODE = DDL_DIVN_CODE;
	}

	public String getDDL_DIVN_CODE() {
		return DDL_DIVN_CODE;
	}

	public void setDDL_CR_TXN_CODE(String DDL_CR_TXN_CODE) {
		this.DDL_CR_TXN_CODE = DDL_CR_TXN_CODE;
	}

	public String getDDL_CR_TXN_CODE() {
		return DDL_CR_TXN_CODE;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_TXN_CR_NAME(String UI_M_TXN_CR_NAME) {
		this.UI_M_TXN_CR_NAME = UI_M_TXN_CR_NAME;
	}

	public String getUI_M_TXN_CR_NAME() {
		return UI_M_TXN_CR_NAME;
	}

	public void setDDL_DR_TXN_CODE(String DDL_DR_TXN_CODE) {
		this.DDL_DR_TXN_CODE = DDL_DR_TXN_CODE;
	}

	public String getDDL_DR_TXN_CODE() {
		return DDL_DR_TXN_CODE;
	}

	public void setDDL_JV_TXN_CODE(String DDL_JV_TXN_CODE) {
		this.DDL_JV_TXN_CODE = DDL_JV_TXN_CODE;
	}

	public String getDDL_JV_TXN_CODE() {
		return DDL_JV_TXN_CODE;
	}

	public void setDDL_RCT_TXN_CODE(String DDL_RCT_TXN_CODE) {
		this.DDL_RCT_TXN_CODE = DDL_RCT_TXN_CODE;
	}

	public String getDDL_RCT_TXN_CODE() {
		return DDL_RCT_TXN_CODE;
	}

	public void setDDL_UPD_UID(String DDL_UPD_UID) {
		this.DDL_UPD_UID = DDL_UPD_UID;
	}

	public String getDDL_UPD_UID() {
		return DDL_UPD_UID;
	}

	public String getCHECK_DDL_FRZ_FLAG() {
		return CHECK_DDL_FRZ_FLAG;
	}

	public void setCHECK_DDL_FRZ_FLAG(String check_ddl_frz_flag) {
		CHECK_DDL_FRZ_FLAG = check_ddl_frz_flag;
	}

	public String getUI_M_TXN_FM_DESC() {
		return UI_M_TXN_FM_DESC;
	}

	public void setUI_M_TXN_FM_DESC(String ui_m_txn_fm_desc) {
		UI_M_TXN_FM_DESC = ui_m_txn_fm_desc;
	}

	public String getUI_M_TXN_TO_DESC() {
		return UI_M_TXN_TO_DESC;
	}

	public void setUI_M_TXN_TO_DESC(String ui_m_txn_to_desc) {
		UI_M_TXN_TO_DESC = ui_m_txn_to_desc;
	}

	public String getDDL_FRZ_FLAG() {
		return DDL_FRZ_FLAG;
	}

	public void setDDL_FRZ_FLAG(String DDL_FRZ_FLAG) {
		this.DDL_FRZ_FLAG = DDL_FRZ_FLAG;
		DDL_FRZ_FLAG_VALUE = DDL_FRZ_FLAG.equals("Y");
	}

	public boolean isDDL_FRZ_FLAG_VALUE() {
		return DDL_FRZ_FLAG_VALUE;
	}

	public void setDDL_FRZ_FLAG_VALUE(boolean ddl_frz_flag_value) {
		CommonUtils commonUtils = new CommonUtils();
		DDL_FRZ_FLAG = commonUtils.booleanToStriingConvertor(DDL_FRZ_FLAG_VALUE);
		DDL_FRZ_FLAG_VALUE = ddl_frz_flag_value;
	}
}
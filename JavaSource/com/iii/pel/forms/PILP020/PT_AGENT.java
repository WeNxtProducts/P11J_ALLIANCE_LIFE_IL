package com.iii.pel.forms.PILP020;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PT_AGENT extends BaseValueBean {

	private String UI_M_CUST_CLASS_FM;

	private String UI_M_CUST_CLASS_TO;

	private String UI_M_AGENCY_FM;

	private String UI_M_AGENCY_TO;

	private String UI_M_AGENT_FM;

	private String UI_M_AGENT_TO;
	
	private String CCLAS_CLASS_DESC_TO;
	
	private String UI_M_CUST_CLASS_FM_DESC;

	private Date UI_M_FM_DT;

	private Date UI_M_TO_DT;
	
	private String UI_M_AMB_SYS_ID;
	
	// Added By Sundar - FROM
		private String CCLAS_CODE;
		
		private String CCLAS_CLASS_DESC;
		
		private String CUST_CODE;
		
		private String CUST_NAME;
		
		private String CUST_ADDR1;
		
		private String CUST_REF_ID1;
		
		private String CUST_LONG_NAME;
	// END



	public String getUI_M_CUST_CLASS_FM() {
		return UI_M_CUST_CLASS_FM;
	}

	public void setUI_M_CUST_CLASS_FM(String UI_M_CUST_CLASS_FM) {
		this.UI_M_CUST_CLASS_FM = UI_M_CUST_CLASS_FM;
	}

	public String getUI_M_CUST_CLASS_TO() {
		return UI_M_CUST_CLASS_TO;
	}

	public void setUI_M_CUST_CLASS_TO(String UI_M_CUST_CLASS_TO) {
		this.UI_M_CUST_CLASS_TO = UI_M_CUST_CLASS_TO;
	}

	public String getUI_M_AGENCY_FM() {
		return UI_M_AGENCY_FM;
	}

	public void setUI_M_AGENCY_FM(String UI_M_AGENCY_FM) {
		this.UI_M_AGENCY_FM = UI_M_AGENCY_FM;
	}

	public String getUI_M_AGENCY_TO() {
		return UI_M_AGENCY_TO;
	}

	public void setUI_M_AGENCY_TO(String UI_M_AGENCY_TO) {
		this.UI_M_AGENCY_TO = UI_M_AGENCY_TO;
	}

	public String getUI_M_AGENT_FM() {
		return UI_M_AGENT_FM;
	}

	public void setUI_M_AGENT_FM(String UI_M_AGENT_FM) {
		this.UI_M_AGENT_FM = UI_M_AGENT_FM;
	}

	public String getUI_M_AGENT_TO() {
		return UI_M_AGENT_TO;
	}

	public void setUI_M_AGENT_TO(String UI_M_AGENT_TO) {
		this.UI_M_AGENT_TO = UI_M_AGENT_TO;
	}

	public Date getUI_M_FM_DT() {
		 return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date UI_M_FM_DT) {
		this.UI_M_FM_DT = UI_M_FM_DT;
	}

	public Date getUI_M_TO_DT() {
		 return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date UI_M_TO_DT) {
		this.UI_M_TO_DT = UI_M_TO_DT;
	}

	public String getCCLAS_CODE() {
		return CCLAS_CODE;
	}

	public void setCCLAS_CODE(String cclas_code) {
		CCLAS_CODE = cclas_code;
	}

	public String getCCLAS_CLASS_DESC() {
		return CCLAS_CLASS_DESC;
	}

	public void setCCLAS_CLASS_DESC(String cclas_class_desc) {
		CCLAS_CLASS_DESC = cclas_class_desc;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cust_name) {
		CUST_NAME = cust_name;
	}

	public String getCUST_ADDR1() {
		return CUST_ADDR1;
	}

	public void setCUST_ADDR1(String cust_addr1) {
		CUST_ADDR1 = cust_addr1;
	}

	public String getCUST_REF_ID1() {
		return CUST_REF_ID1;
	}

	public void setCUST_REF_ID1(String cust_ref_id1) {
		CUST_REF_ID1 = cust_ref_id1;
	}

	public String getCUST_LONG_NAME() {
		return CUST_LONG_NAME;
	}

	public void setCUST_LONG_NAME(String cust_long_name) {
		CUST_LONG_NAME = cust_long_name;
	}

	public String getUI_M_AMB_SYS_ID() {
		return UI_M_AMB_SYS_ID;
	}

	public void setUI_M_AMB_SYS_ID(String ui_m_amb_sys_id) {
		UI_M_AMB_SYS_ID = ui_m_amb_sys_id;
	}

	public String getUI_M_CUST_CLASS_FM_DESC() {
		return UI_M_CUST_CLASS_FM_DESC;
	}

	public void setUI_M_CUST_CLASS_FM_DESC(String ui_m_cust_class_fm_desc) {
		UI_M_CUST_CLASS_FM_DESC = ui_m_cust_class_fm_desc;
	}

	public String getCCLAS_CLASS_DESC_TO() {
		return CCLAS_CLASS_DESC_TO;
	}

	public void setCCLAS_CLASS_DESC_TO(String cclas_class_desc_to) {
		CCLAS_CLASS_DESC_TO = cclas_class_desc_to;
	}
}

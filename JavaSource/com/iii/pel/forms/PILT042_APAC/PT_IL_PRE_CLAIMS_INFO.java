package com.iii.pel.forms.PILT042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PRE_CLAIMS_INFO")
public class PT_IL_PRE_CLAIMS_INFO extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Column(name = "PCI_ASSRD_REF_ID2")
	private String PCI_ASSRD_REF_ID2;

	@Column(name = "PCI_ASSRD_REF_ID1")
	private String PCI_ASSRD_REF_ID1;

	@Column(name = "PCI_POL_NO")
	private String PCI_POL_NO;

	@Column(name = "PCI_CLAIM_TYPE")
	private String PCI_CLAIM_TYPE;

	@Column(name = "PCI_LOSS_DT")
	private Date PCI_LOSS_DT;

	@Column(name = "PCI_REPORT_DT")
	private Date PCI_REPORT_DT;

	@Column(name = "PCI_INTIMATION_MODE")
	private String PCI_INTIMATION_MODE;

	private String UI_M_PCI_INTIMATION_MODE;

	@Column(name = "PCI_REF_NO")
	private String PCI_REF_NO;

	@Column(name = "PCI_RES_ADDRESS_1")
	private String PCI_RES_ADDRESS_1;

	@Column(name = "PCI_RES_ADDRESS_2")
	private String PCI_RES_ADDRESS_2;

	@Column(name = "PCI_RES_ADDRESS_3")
	private String PCI_RES_ADDRESS_3;

	private String UI_M_RES_AREA_NAME;

	@Column(name = "PCI_RES_AREA_CODE")
	private String PCI_RES_AREA_CODE;

	private String UI_M_PCI_CITY_NAME;

	@Column(name = "PCI_CITY_CODE")
	private String PCI_CITY_CODE;

	@Column(name = "PCI_COUNTRY_CODE")
	private String PCI_COUNTRY_CODE;

	private String UI_M_PCI_COUNTRY_CODE;

	@Column(name = "PCI_STATE_CODE")
	private String PCI_STATE_CODE;
	
	@Column(name = "PCI_ASSRD_CODE")
	private String PCI_ASSRD_CODE;

	private String UI_M_PCI_STATE_CODE;

	@Column(name = "PCI_ACTION_TAKEN")
	private String PCI_ACTION_TAKEN;

	@Column(name = "PCI_REMARKS")
	private String PCI_REMARKS;

	@Column(name = "PCI_SYS_ID")
	private int PCI_SYS_ID;
	
	@Column(name = "PCI_ADDL_STATUS")
	private String PCI_ADDL_STATUS;
	
	@Column(name = "PCI_CR_UID")
	private String PCI_CR_UID;
	
	@Column(name = "PCI_CR_DT")
	private Date PCI_CR_DT;
	
	@Column(name = "PCI_UPD_UID")
	private String PCI_UPD_UID;
	
	@Column(name = "PCI_UPD_DT")
	private Date PCI_UPD_DT;
	
	private String UI_M_PCI_ADDL_STATUS;
	
	private String UI_M_POL_DIVN_CODE;
	
	private String UI_M_POL_CLASS_CODE;
	
	private String UI_M_POL_PLAN_CODE;
	
	private String UI_M_POL_PROD_CODE;
	
	private int UI_M_POL_UW_YEAR; 
	
	private String UI_M_PS_CODE_DESC;
	
	private Date UI_M_POL_START_DT;
	
	private Date UI_M_POL_EXPIRY_DT;
	
	private String UI_M_PS_VALUE;
	
	private String UI_M_PCI_CUST_NAME;
	
	// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
	private String UI_M_PCI_CUST_CODE;
	
	public String getUI_M_PCI_CUST_CODE() {
		return UI_M_PCI_CUST_CODE;
	}

	public void setUI_M_PCI_CUST_CODE(String uI_M_PCI_CUST_CODE) {
		UI_M_PCI_CUST_CODE = uI_M_PCI_CUST_CODE;
	}
//end
	private String UI_M_PCI_ASSRD_NAME;
	
	private String M_DISABLE_YN;
	
	
	private boolean INSERT_ALLOWED = true;

	private boolean UPDATE_ALLOWED = true;

	private boolean DELETE_ALLOWED = true;
	

	public boolean isINSERT_ALLOWED() {
		return INSERT_ALLOWED;
	}

	public void setINSERT_ALLOWED(boolean insert_allowed) {
		INSERT_ALLOWED = insert_allowed;
	}

	public boolean isUPDATE_ALLOWED() {
		return UPDATE_ALLOWED;
	}

	public void setUPDATE_ALLOWED(boolean update_allowed) {
		UPDATE_ALLOWED = update_allowed;
	}

	public boolean isDELETE_ALLOWED() {
		return DELETE_ALLOWED;
	}

	public void setDELETE_ALLOWED(boolean delete_allowed) {
		DELETE_ALLOWED = delete_allowed;
	}

	public String getUI_M_PS_CODE_DESC() {
		return UI_M_PS_CODE_DESC;
	}

	public void setUI_M_PS_CODE_DESC(String ui_m_ps_code_desc) {
		UI_M_PS_CODE_DESC = ui_m_ps_code_desc;
	}

	public int getUI_M_POL_UW_YEAR() {
		return UI_M_POL_UW_YEAR;
	}

	public void setUI_M_POL_UW_YEAR(int ui_m_pol_uw_year) {
		UI_M_POL_UW_YEAR = ui_m_pol_uw_year;
	}

	public String getUI_M_PCI_ADDL_STATUS() {
		return UI_M_PCI_ADDL_STATUS;
	}

	public void setUI_M_PCI_ADDL_STATUS(String ui_m_pci_addl_status) {
		UI_M_PCI_ADDL_STATUS = ui_m_pci_addl_status;
	}

	public String getPCI_ASSRD_REF_ID2() {
		return PCI_ASSRD_REF_ID2;
	}

	public void setPCI_ASSRD_REF_ID2(String PCI_ASSRD_REF_ID2) {
		this.PCI_ASSRD_REF_ID2 = PCI_ASSRD_REF_ID2;
	}

	public String getPCI_ASSRD_REF_ID1() {
		return PCI_ASSRD_REF_ID1;
	}

	public void setPCI_ASSRD_REF_ID1(String PCI_ASSRD_REF_ID1) {
		this.PCI_ASSRD_REF_ID1 = PCI_ASSRD_REF_ID1;
	}

	public String getPCI_POL_NO() {
		return PCI_POL_NO;
	}

	public void setPCI_POL_NO(String PCI_POL_NO) {
		this.PCI_POL_NO = PCI_POL_NO;
	}

	public String getPCI_CLAIM_TYPE() {
		return PCI_CLAIM_TYPE;
	}

	public void setPCI_CLAIM_TYPE(String PCI_CLAIM_TYPE) {
		this.PCI_CLAIM_TYPE = PCI_CLAIM_TYPE;
	}

	public Date getPCI_LOSS_DT() {
		return PCI_LOSS_DT;
	}

	public void setPCI_LOSS_DT(Date PCI_LOSS_DT) {
		this.PCI_LOSS_DT = PCI_LOSS_DT;
	}

	public Date getPCI_REPORT_DT() {
		return PCI_REPORT_DT;
	}

	public void setPCI_REPORT_DT(Date PCI_REPORT_DT) {
		this.PCI_REPORT_DT = PCI_REPORT_DT;
	}

	public String getPCI_INTIMATION_MODE() {
		return PCI_INTIMATION_MODE;
	}

	public void setPCI_INTIMATION_MODE(String PCI_INTIMATION_MODE) {
		this.PCI_INTIMATION_MODE = PCI_INTIMATION_MODE;
	}

	public String getUI_M_PCI_INTIMATION_MODE() {
		return UI_M_PCI_INTIMATION_MODE;
	}

	public void setUI_M_PCI_INTIMATION_MODE(String UI_M_PCI_INTIMATION_MODE) {
		this.UI_M_PCI_INTIMATION_MODE = UI_M_PCI_INTIMATION_MODE;
	}

	public String getPCI_REF_NO() {
		return PCI_REF_NO;
	}

	public void setPCI_REF_NO(String PCI_REF_NO) {
		this.PCI_REF_NO = PCI_REF_NO;
	}

	public String getPCI_RES_ADDRESS_1() {
		return PCI_RES_ADDRESS_1;
	}

	public void setPCI_RES_ADDRESS_1(String PCI_RES_ADDRESS_1) {
		this.PCI_RES_ADDRESS_1 = PCI_RES_ADDRESS_1;
	}

	public String getPCI_RES_ADDRESS_2() {
		return PCI_RES_ADDRESS_2;
	}

	public void setPCI_RES_ADDRESS_2(String PCI_RES_ADDRESS_2) {
		this.PCI_RES_ADDRESS_2 = PCI_RES_ADDRESS_2;
	}

	public String getPCI_RES_ADDRESS_3() {
		return PCI_RES_ADDRESS_3;
	}

	public void setPCI_RES_ADDRESS_3(String PCI_RES_ADDRESS_3) {
		this.PCI_RES_ADDRESS_3 = PCI_RES_ADDRESS_3;
	}

	public String getUI_M_RES_AREA_NAME() {
		return UI_M_RES_AREA_NAME;
	}

	public void setUI_M_RES_AREA_NAME(String UI_M_RES_AREA_NAME) {
		this.UI_M_RES_AREA_NAME = UI_M_RES_AREA_NAME;
	}

	public String getPCI_RES_AREA_CODE() {
		return PCI_RES_AREA_CODE;
	}

	public void setPCI_RES_AREA_CODE(String PCI_RES_AREA_CODE) {
		this.PCI_RES_AREA_CODE = PCI_RES_AREA_CODE;
	}

	public String getUI_M_PCI_CITY_NAME() {
		return UI_M_PCI_CITY_NAME;
	}

	public void setUI_M_PCI_CITY_NAME(String UI_M_PCI_CITY_NAME) {
		this.UI_M_PCI_CITY_NAME = UI_M_PCI_CITY_NAME;
	}

	public String getPCI_CITY_CODE() {
		return PCI_CITY_CODE;
	}

	public void setPCI_CITY_CODE(String PCI_CITY_CODE) {
		this.PCI_CITY_CODE = PCI_CITY_CODE;
	}

	public String getPCI_COUNTRY_CODE() {
		return PCI_COUNTRY_CODE;
	}

	public void setPCI_COUNTRY_CODE(String PCI_COUNTRY_CODE) {
		this.PCI_COUNTRY_CODE = PCI_COUNTRY_CODE;
	}

	public String getUI_M_PCI_COUNTRY_CODE() {
		return UI_M_PCI_COUNTRY_CODE;
	}

	public void setUI_M_PCI_COUNTRY_CODE(String UI_M_PCI_COUNTRY_CODE) {
		this.UI_M_PCI_COUNTRY_CODE = UI_M_PCI_COUNTRY_CODE;
	}

	public String getPCI_STATE_CODE() {
		return PCI_STATE_CODE;
	}

	public void setPCI_STATE_CODE(String PCI_STATE_CODE) {
		this.PCI_STATE_CODE = PCI_STATE_CODE;
	}

	public String getUI_M_PCI_STATE_CODE() {
		return UI_M_PCI_STATE_CODE;
	}

	public void setUI_M_PCI_STATE_CODE(String UI_M_PCI_STATE_CODE) {
		this.UI_M_PCI_STATE_CODE = UI_M_PCI_STATE_CODE;
	}

	public String getPCI_ACTION_TAKEN() {
		return PCI_ACTION_TAKEN;
	}

	public void setPCI_ACTION_TAKEN(String PCI_ACTION_TAKEN) {
		this.PCI_ACTION_TAKEN = PCI_ACTION_TAKEN;
	}

	public String getPCI_REMARKS() {
		return PCI_REMARKS;
	}

	public void setPCI_REMARKS(String PCI_REMARKS) {
		this.PCI_REMARKS = PCI_REMARKS;
	}

	public int getPCI_SYS_ID() {
		return PCI_SYS_ID;
	}

	public void setPCI_SYS_ID(int pci_sys_id) {
		PCI_SYS_ID = pci_sys_id;
	}

	public String getPCI_ADDL_STATUS() {
		return PCI_ADDL_STATUS;
	}

	public void setPCI_ADDL_STATUS(String pci_addl_status) {
		PCI_ADDL_STATUS = pci_addl_status;
	}

	public String getPCI_CR_UID() {
		return PCI_CR_UID;
	}

	public void setPCI_CR_UID(String pci_cr_uid) {
		PCI_CR_UID = pci_cr_uid;
	}

	public Date getPCI_CR_DT() {
		return PCI_CR_DT;
	}

	public void setPCI_CR_DT(Date pci_cr_dt) {
		PCI_CR_DT = pci_cr_dt;
	}

	public String getPCI_UPD_UID() {
		return PCI_UPD_UID;
	}

	public void setPCI_UPD_UID(String pci_upd_uid) {
		PCI_UPD_UID = pci_upd_uid;
	}

	public Date getPCI_UPD_DT() {
		return PCI_UPD_DT;
	}

	public void setPCI_UPD_DT(Date pci_upd_dt) {
		PCI_UPD_DT = pci_upd_dt;
	}

	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	public String getUI_M_POL_CLASS_CODE() {
		return UI_M_POL_CLASS_CODE;
	}

	public void setUI_M_POL_CLASS_CODE(String ui_m_pol_class_code) {
		UI_M_POL_CLASS_CODE = ui_m_pol_class_code;
	}

	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}

	public void setUI_M_POL_PLAN_CODE(String ui_m_pol_plan_code) {
		UI_M_POL_PLAN_CODE = ui_m_pol_plan_code;
	}

	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}

	public void setUI_M_POL_PROD_CODE(String ui_m_pol_prod_code) {
		UI_M_POL_PROD_CODE = ui_m_pol_prod_code;
	}

	public Date getUI_M_POL_START_DT() {
		return UI_M_POL_START_DT;
	}

	public void setUI_M_POL_START_DT(Date ui_m_pol_start_dt) {
		UI_M_POL_START_DT = ui_m_pol_start_dt;
	}

	public Date getUI_M_POL_EXPIRY_DT() {
		return UI_M_POL_EXPIRY_DT;
	}

	public void setUI_M_POL_EXPIRY_DT(Date ui_m_pol_expiry_dt) {
		UI_M_POL_EXPIRY_DT = ui_m_pol_expiry_dt;
	}

	public String getUI_M_PS_VALUE() {
		return UI_M_PS_VALUE;
	}

	public void setUI_M_PS_VALUE(String ui_m_ps_value) {
		UI_M_PS_VALUE = ui_m_ps_value;
	}

	public String getUI_M_PCI_CUST_NAME() {
		return UI_M_PCI_CUST_NAME;
	}

	public void setUI_M_PCI_CUST_NAME(String ui_m_pci_cust_name) {
		UI_M_PCI_CUST_NAME = ui_m_pci_cust_name;
	}

	public String getM_DISABLE_YN() {
		return M_DISABLE_YN;
	}

	public void setM_DISABLE_YN(String m_disable_yn) {
		M_DISABLE_YN = m_disable_yn;
	}

	public String getPCI_ASSRD_CODE() {
		return PCI_ASSRD_CODE;
	}

	public void setPCI_ASSRD_CODE(String pci_assrd_code) {
		PCI_ASSRD_CODE = pci_assrd_code;
	}

	public String getUI_M_PCI_ASSRD_NAME() {
		return UI_M_PCI_ASSRD_NAME;
	}

	public void setUI_M_PCI_ASSRD_NAME(String ui_m_pci_assrd_name) {
		UI_M_PCI_ASSRD_NAME = ui_m_pci_assrd_name;
	}
	
	
	
/*Added by Janani on 25.05.2017 for ZBILQC-1727100*/
	
	@Column(name = "PCI_INTIMATION_SRC")
	private String PCI_INTIMATION_SRC;
	
	@Column(name = "PCI_INTIMATOR_NAME")
	private String PCI_INTIMATOR_NAME;
	
	@Column(name = "PCI_INTIMATOR_MOBILE")
	private String PCI_INTIMATOR_MOBILE;
	
	@Column(name = "PCI_INTIMATOR_EMAIL")
	private String PCI_INTIMATOR_EMAIL;

	public String getPCI_INTIMATION_SRC() {
		return PCI_INTIMATION_SRC;
	}

	public void setPCI_INTIMATION_SRC(String pCI_INTIMATION_SRC) {
		PCI_INTIMATION_SRC = pCI_INTIMATION_SRC;
	}

	public String getPCI_INTIMATOR_NAME() {
		return PCI_INTIMATOR_NAME;
	}

	public void setPCI_INTIMATOR_NAME(String pCI_INTIMATOR_NAME) {
		PCI_INTIMATOR_NAME = pCI_INTIMATOR_NAME;
	}


	public String getPCI_INTIMATOR_MOBILE() {
		return PCI_INTIMATOR_MOBILE;
	}

	public void setPCI_INTIMATOR_MOBILE(String pCI_INTIMATOR_MOBILE) {
		PCI_INTIMATOR_MOBILE = pCI_INTIMATOR_MOBILE;
	}

	public String getPCI_INTIMATOR_EMAIL() {
		return PCI_INTIMATOR_EMAIL;
	}

	public void setPCI_INTIMATOR_EMAIL(String pCI_INTIMATOR_EMAIL) {
		PCI_INTIMATOR_EMAIL = pCI_INTIMATOR_EMAIL;
	}
	
	
	/*eND*/

}

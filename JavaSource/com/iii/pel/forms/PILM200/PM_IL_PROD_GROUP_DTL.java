package com.iii.pel.forms.PILM200;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_GROUP_DTL")
public class PM_IL_PROD_GROUP_DTL extends BaseValueBean {

	@Column(name="PGD_FRZ_FLAG")
	private String PGD_FRZ_FLAG;

	@Column(name="PGD_PROD_CODE")
	private String PGD_PROD_CODE;

	private String UI_M_PROD_DESC;
	
	@Column(name="PGD_GROUP_CODE")
	private String PGD_GROUP_CODE;
	
	private String UI_M_GROUP_CODE_DESC;

	@Column(name="PGD_MAIN_PROD_YN")
	private String PGD_MAIN_PROD_YN = "N";

	@Column(name="PGD_MANDATORY_YN")
	private String PGD_MANDATORY_YN;

	@Column(name="PGD_DEFAULT_YN")
	private String PGD_DEFAULT_YN;

	private boolean CHECK_BOX;
	
	private boolean freezSelect;
	
	@Column(name="PGD_CR_DT")
	private Date PGD_CR_DT;
	
	@Column(name="PGD_CR_UID")
	private String PGD_CR_UID;
	
	@Column(name="PGD_UPD_DT")
	private Date PGD_UPD_DT;
	
	@Column(name="PGD_UPD_UID")
	private String PGD_UPD_UID;
	
	private boolean PGD_MAIN_PROD_STATUS=false ;
	private boolean PGD_MANDATORY_STATUS=false ;
	private boolean PGD_DEFAULT_STATUS=false ;
	
	private String simpleTest;
	
	private boolean defaultYN=false;
	
	private boolean mandYN;
	
	
	public String getSimpleTest() {
		return simpleTest;
	}

	public void setSimpleTest(String simpleTest) {
		this.simpleTest = simpleTest;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		System.out.println("PM_IL_PROD_GROUP_DTL.setCHECK_BOX()---["+check_box+"]");
		CHECK_BOX = check_box;
	}

	public String getPGD_FRZ_FLAG() {
		
		if(isFreezSelect() == true) {
			setPGD_FRZ_FLAG("Y");
		} else {
			setPGD_FRZ_FLAG("N");
		}
		return PGD_FRZ_FLAG;
	}

	public void setPGD_FRZ_FLAG(String PGD_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(PGD_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.PGD_FRZ_FLAG = PGD_FRZ_FLAG;
	}

	public String getPGD_PROD_CODE() {
		return PGD_PROD_CODE;
	}

	public void setPGD_PROD_CODE(String PGD_PROD_CODE) {
		this.PGD_PROD_CODE = PGD_PROD_CODE;
	}

	public String getUI_M_PROD_DESC() {
		return UI_M_PROD_DESC;
	}

	public void setUI_M_PROD_DESC(String UI_M_PROD_DESC) {
		this.UI_M_PROD_DESC = UI_M_PROD_DESC;
	}

	public String getPGD_MAIN_PROD_YN() {
		return PGD_MAIN_PROD_YN;
	}

	public void setPGD_MAIN_PROD_YN(String PGD_MAIN_PROD_YN) {
		this.PGD_MAIN_PROD_YN = PGD_MAIN_PROD_YN;
	}

	public String getPGD_MANDATORY_YN() {
		return PGD_MANDATORY_YN;
	}

	public void setPGD_MANDATORY_YN(String PGD_MANDATORY_YN) {
		this.PGD_MANDATORY_YN = PGD_MANDATORY_YN;
	}

	public String getPGD_DEFAULT_YN() {
		return PGD_DEFAULT_YN;
	}

	public void setPGD_DEFAULT_YN(String PGD_DEFAULT_YN) {
		this.PGD_DEFAULT_YN = PGD_DEFAULT_YN;
	}

	public Date getPGD_CR_DT() {
		return PGD_CR_DT;
	}

	public void setPGD_CR_DT(Date pgd_cr_dt) {
		PGD_CR_DT = pgd_cr_dt;
	}

	public String getPGD_CR_UID() {
		return PGD_CR_UID;
	}

	public void setPGD_CR_UID(String pgd_cr_uid) {
		PGD_CR_UID = pgd_cr_uid;
	}

	

	public boolean isPGD_MAIN_PROD_STATUS() {
		return PGD_MAIN_PROD_STATUS;
	}

	public void setPGD_MAIN_PROD_STATUS(boolean pgd_main_prod_status) {
		PGD_MAIN_PROD_STATUS = pgd_main_prod_status;
	}

	public boolean isPGD_MANDATORY_STATUS() {
		return PGD_MANDATORY_STATUS;
	}

	public void setPGD_MANDATORY_STATUS(boolean pgd_mandatory_status) {
		PGD_MANDATORY_STATUS = pgd_mandatory_status;
	}

	public boolean isPGD_DEFAULT_STATUS() {
		return PGD_DEFAULT_STATUS;
	}

	public void setPGD_DEFAULT_STATUS(boolean pgd_default_status) {
		PGD_DEFAULT_STATUS = pgd_default_status;
	}

	public String getPGD_GROUP_CODE() {
		return PGD_GROUP_CODE;
	}

	public void setPGD_GROUP_CODE(String pgd_group_code) {
		PGD_GROUP_CODE = pgd_group_code;
	}

	public String getUI_M_GROUP_CODE_DESC() {
		return UI_M_GROUP_CODE_DESC;
	}

	public void setUI_M_GROUP_CODE_DESC(String ui_m_group_code_desc) {
		UI_M_GROUP_CODE_DESC = ui_m_group_code_desc;
	}

	public Date getPGD_UPD_DT() {
		return PGD_UPD_DT;
	}

	public void setPGD_UPD_DT(Date pgd_upd_dt) {
		PGD_UPD_DT = pgd_upd_dt;
	}

	public String getPGD_UPD_UID() {
		return PGD_UPD_UID;
	}

	public void setPGD_UPD_UID(String pgd_upd_uid) {
		PGD_UPD_UID = pgd_upd_uid;
	}

	public boolean isDefaultYN() {
		return defaultYN;
	}

	public void setDefaultYN(boolean defaultYN) {
		this.defaultYN = defaultYN;
	}

	public boolean isMandYN() {
		return mandYN;
	}

	public void setMandYN(boolean mandYN) {
		this.mandYN = mandYN;
	}

	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
	}

	
}

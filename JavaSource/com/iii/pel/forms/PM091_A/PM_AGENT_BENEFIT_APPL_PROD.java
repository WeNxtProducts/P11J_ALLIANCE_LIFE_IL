package com.iii.pel.forms.PM091_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BENEFIT_APPL_PROD")
public class PM_AGENT_BENEFIT_APPL_PROD extends BaseValueBean {

	@Column(name="ABNFAP_MODULE_ID")
	private String ABNFAP_MODULE_ID;

	@Column(name="ABNFAP_ABH_BNF_CODE")
	private String ABNFAP_ABH_BNF_CODE;
	
	@Column(name="ABNFAP_PROD_CODE")
	private String ABNFAP_PROD_CODE;
	
	@Column(name="ABNFAP_UPD_DT")
	private Date ABNFAP_UPD_DT;

	@Column(name="ABNFAP_UPD_UID")
	private String ABNFAP_UPD_UID;
	
	@Column(name="ABNFAP_CR_DT")
	private Date ABNFAP_CR_DT;

	@Column(name="ABNFAP_CR_UID")
	private String ABNFAP_CR_UID;
	
	private String UI_M_ABNFAP_PROD_CODE_DESC;
	
	private boolean selected;
	
	private boolean CHECK_BOX;



	public String getABNFAP_MODULE_ID() {
		return ABNFAP_MODULE_ID;
	}

	public void setABNFAP_MODULE_ID(String ABNFAP_MODULE_ID) {
		this.ABNFAP_MODULE_ID = ABNFAP_MODULE_ID;
	}

	public String getABNFAP_PROD_CODE() {
		return ABNFAP_PROD_CODE;
	}

	public void setABNFAP_PROD_CODE(String ABNFAP_PROD_CODE) {
		this.ABNFAP_PROD_CODE = ABNFAP_PROD_CODE;
	}

	public String getUI_M_ABNFAP_PROD_CODE_DESC() {
		return UI_M_ABNFAP_PROD_CODE_DESC;
	}

	public void setUI_M_ABNFAP_PROD_CODE_DESC(String UI_M_ABNFAP_PROD_CODE_DESC) {
		this.UI_M_ABNFAP_PROD_CODE_DESC = UI_M_ABNFAP_PROD_CODE_DESC;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		System.out.println("PM_AGENT_BENEFIT_APPL_PROD.setSelected()----_SELECTED--["+selected+"]");
		this.selected = selected;
	}

	public String getABNFAP_ABH_BNF_CODE() {
		return ABNFAP_ABH_BNF_CODE;
	}

	public void setABNFAP_ABH_BNF_CODE(String abnfap_abh_bnf_code) {
		ABNFAP_ABH_BNF_CODE = abnfap_abh_bnf_code;
	}

	public Date getABNFAP_UPD_DT() {
		return ABNFAP_UPD_DT;
	}

	public void setABNFAP_UPD_DT(Date abnfap_upd_dt) {
		ABNFAP_UPD_DT = abnfap_upd_dt;
	}

	public String getABNFAP_UPD_UID() {
		return ABNFAP_UPD_UID;
	}

	public void setABNFAP_UPD_UID(String abnfap_upd_uid) {
		ABNFAP_UPD_UID = abnfap_upd_uid;
	}

	public Date getABNFAP_CR_DT() {
		return ABNFAP_CR_DT;
	}

	public void setABNFAP_CR_DT(Date abnfap_cr_dt) {
		ABNFAP_CR_DT = abnfap_cr_dt;
	}

	public String getABNFAP_CR_UID() {
		return ABNFAP_CR_UID;
	}

	public void setABNFAP_CR_UID(String abnfap_cr_uid) {
		ABNFAP_CR_UID = abnfap_cr_uid;
	}
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}
	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}


}

package com.iii.pel.forms.PT044_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_TRAN_DTLS")
public class PT_AGENT_TRAN_DTLS extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Column(name="ATD_AGENT_CODE")
	private String ATD_AGENT_CODE;

	@Column(name="ATD_OLD_PARENT_CODE")
	private String ATD_OLD_PARENT_CODE;

	@Column(name="ATD_OLD_AGENCY_CODE")
	private String ATD_OLD_AGENCY_CODE;

	@Column(name="ATD_NEW_PARENT_CODE")
	private String ATD_NEW_PARENT_CODE;

	@Column(name="ATD_NEW_AGENCY_CODE")
	private String ATD_NEW_AGENCY_CODE;

	@Column(name="ATD_NEW_UNIT_CODE")
	private String ATD_NEW_UNIT_CODE;

	@Column(name="ATD_SYS_ID")
	private int ATD_SYS_ID;

	@Column(name="ATD_ATH_SYS_ID")
	private int ATD_ATH_SYS_ID;

	@Column(name="ATD_CR_UID")
	private String ATD_CR_UID;

	@Column(name="ATD_CR_DT")
	private Date ATD_CR_DT;

	@Column(name="ATD_UPD_UID")
	private String ATD_UPD_UID;

	@Column(name="ATD_UPD_DT")
	private Date ATD_UPD_DT;

	@Column(name="ATD_OLD_UNIT_CODE")
	private String ATD_OLD_UNIT_CODE;                                                                                                                                                                                  
	
	private String UI_M_AGENT_NAME;

	private String UI_M_ATD_NEW_PARENT_NAME;

	private String UI_M_OLD_PARENT_NAME;

	private String UI_M_ATD_NEW_AGENCY_NAME;

	private String UI_M_OLD_AGENCY_NAME;

	private String UI_M_NEW_UNIT_DESC;
	
	private boolean CHECK_BOX;
	
	private String UI_M_CUST_FULL_NAME;
	
	private String UI_M_CUST_REF_ID1;
	
	private String UI_M_CUST_ADDR1;
	
	
	/*added by nadhiya on 30.3.2016*/
	
	/*@Column(name="ATD_AGENT_NAME")*/
	private String ATD_AGENT_NAME;
	
	/*@Column(name="ATD_OLD_PARENT_NAME")*/
	private String ATD_OLD_PARENT_NAME;
	
	
	
	public String getATD_AGENT_NAME() {
		return ATD_AGENT_NAME;
	}

	public void setATD_AGENT_NAME(String aTD_AGENT_NAME) {
		ATD_AGENT_NAME = aTD_AGENT_NAME;
	}

	public String getATD_OLD_PARENT_NAME() {
		return ATD_OLD_PARENT_NAME;
	}

	public void setATD_OLD_PARENT_NAME(String aTD_OLD_PARENT_NAME) {
		ATD_OLD_PARENT_NAME = aTD_OLD_PARENT_NAME;
	}
	
	/*end*/
	

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getATD_AGENT_CODE() {
		return ATD_AGENT_CODE;
	}

	public void setATD_AGENT_CODE(String ATD_AGENT_CODE) {
		this.ATD_AGENT_CODE = ATD_AGENT_CODE;
	}

	public String getATD_OLD_PARENT_CODE() {
		return ATD_OLD_PARENT_CODE;
	}

	public void setATD_OLD_PARENT_CODE(String ATD_OLD_PARENT_CODE) {
		this.ATD_OLD_PARENT_CODE = ATD_OLD_PARENT_CODE;
//		Commented by Amit Gupta - 36077
		/*System.out.println("PT_AGENT_TRAN_DTLS.setATD_OLD_PARENT_CODE(ATD_OLD_PARENT_CODE)--["+this.ATD_OLD_PARENT_CODE+"]");
		new Exception("vandhutean..........").printStackTrace();*/
	}

	public String getATD_OLD_AGENCY_CODE() {
		return ATD_OLD_AGENCY_CODE;
	}

	public void setATD_OLD_AGENCY_CODE(String ATD_OLD_AGENCY_CODE) {
		this.ATD_OLD_AGENCY_CODE = ATD_OLD_AGENCY_CODE;
	}

	public String getATD_NEW_PARENT_CODE() {
		return ATD_NEW_PARENT_CODE;
	}

	public void setATD_NEW_PARENT_CODE(String ATD_NEW_PARENT_CODE) {
		this.ATD_NEW_PARENT_CODE = ATD_NEW_PARENT_CODE;
	}

	public String getATD_NEW_AGENCY_CODE() {
		return ATD_NEW_AGENCY_CODE;
	}

	public void setATD_NEW_AGENCY_CODE(String ATD_NEW_AGENCY_CODE) {
		this.ATD_NEW_AGENCY_CODE = ATD_NEW_AGENCY_CODE;
	}

	public String getATD_NEW_UNIT_CODE() {
		return ATD_NEW_UNIT_CODE;
	}

	public void setATD_NEW_UNIT_CODE(String ATD_NEW_UNIT_CODE) {
		this.ATD_NEW_UNIT_CODE = ATD_NEW_UNIT_CODE;
	}

	public String getUI_M_AGENT_NAME() {
		return UI_M_AGENT_NAME;
	}

	public void setUI_M_AGENT_NAME(String UI_M_AGENT_NAME) {
		this.UI_M_AGENT_NAME = UI_M_AGENT_NAME;
	}

	public String getUI_M_ATD_NEW_PARENT_NAME() {
		return UI_M_ATD_NEW_PARENT_NAME;
	}

	public void setUI_M_ATD_NEW_PARENT_NAME(String UI_M_ATD_NEW_PARENT_NAME) {
		this.UI_M_ATD_NEW_PARENT_NAME = UI_M_ATD_NEW_PARENT_NAME;
	}

	public String getUI_M_OLD_PARENT_NAME() {
		return UI_M_OLD_PARENT_NAME;
	}

	public void setUI_M_OLD_PARENT_NAME(String UI_M_OLD_PARENT_NAME) {
		this.UI_M_OLD_PARENT_NAME = UI_M_OLD_PARENT_NAME;
	}

	public String getUI_M_ATD_NEW_AGENCY_NAME() {
		return UI_M_ATD_NEW_AGENCY_NAME;
	}

	public void setUI_M_ATD_NEW_AGENCY_NAME(String UI_M_ATD_NEW_AGENCY_NAME) {
		this.UI_M_ATD_NEW_AGENCY_NAME = UI_M_ATD_NEW_AGENCY_NAME;
	}

	public String getUI_M_OLD_AGENCY_NAME() {
		return UI_M_OLD_AGENCY_NAME;
	}

	public void setUI_M_OLD_AGENCY_NAME(String UI_M_OLD_AGENCY_NAME) {
		this.UI_M_OLD_AGENCY_NAME = UI_M_OLD_AGENCY_NAME;
	}

	public String getUI_M_NEW_UNIT_DESC() {
		return UI_M_NEW_UNIT_DESC;
	}

	public void setUI_M_NEW_UNIT_DESC(String UI_M_NEW_UNIT_DESC) {
		this.UI_M_NEW_UNIT_DESC = UI_M_NEW_UNIT_DESC;
	}

	public int getATD_SYS_ID() {
		return ATD_SYS_ID;
	}

	public void setATD_SYS_ID(int atd_sys_id) {
		ATD_SYS_ID = atd_sys_id;
	}

	public int getATD_ATH_SYS_ID() {
		return ATD_ATH_SYS_ID;
	}

	public void setATD_ATH_SYS_ID(int atd_ath_sys_id) {
		ATD_ATH_SYS_ID = atd_ath_sys_id;
	}

	public String getATD_CR_UID() {
		return ATD_CR_UID;
	}

	public void setATD_CR_UID(String atd_cr_uid) {
		ATD_CR_UID = atd_cr_uid;
	}

	public Date getATD_CR_DT() {
		return ATD_CR_DT;
	}

	public void setATD_CR_DT(Date atd_cr_dt) {
		ATD_CR_DT = atd_cr_dt;
	}

	public String getATD_UPD_UID() {
		return ATD_UPD_UID;
	}

	public void setATD_UPD_UID(String atd_upd_uid) {
		ATD_UPD_UID = atd_upd_uid;
	}

	public Date getATD_UPD_DT() {
		return ATD_UPD_DT;
	}

	public void setATD_UPD_DT(Date atd_upd_dt) {
		ATD_UPD_DT = atd_upd_dt;
	}

	public String getATD_OLD_UNIT_CODE() {
		return ATD_OLD_UNIT_CODE;
	}

	public void setATD_OLD_UNIT_CODE(String atd_old_unit_code) {
		ATD_OLD_UNIT_CODE = atd_old_unit_code;
	}

	public String getUI_M_CUST_FULL_NAME() {
		return UI_M_CUST_FULL_NAME;
	}

	public void setUI_M_CUST_FULL_NAME(String ui_m_cust_full_name) {
		UI_M_CUST_FULL_NAME = ui_m_cust_full_name;
	}

	public String getUI_M_CUST_REF_ID1() {
		return UI_M_CUST_REF_ID1;
	}

	public void setUI_M_CUST_REF_ID1(String ui_m_cust_ref_id1) {
		UI_M_CUST_REF_ID1 = ui_m_cust_ref_id1;
	}

	public String getUI_M_CUST_ADDR1() {
		return UI_M_CUST_ADDR1;
	}

	public void setUI_M_CUST_ADDR1(String ui_m_cust_addr1) {
		UI_M_CUST_ADDR1 = ui_m_cust_addr1;
	}
}

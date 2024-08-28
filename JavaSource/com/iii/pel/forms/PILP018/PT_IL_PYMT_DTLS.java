package com.iii.pel.forms.PILP018;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS extends BaseValueBean {

	private String UI_M_PD_TXN_TYPE_DESC;

	private String UI_M_PD_CURR_CODE_DESC;
    
	@Column(name="PD_FC_AMT")
	private Double PD_FC_AMT;
    
	@Column(name="PD_LC_AMT")
	private Double PD_LC_AMT;

	@Column(name="PD_BRANCH_NAME")
	private String PD_BRANCH_NAME;

	@Column(name="PD_CUST_NAME")
	private String PD_CUST_NAME;

	@Column(name="PD_ADDR_01")
	private String PD_ADDR_01;
	
    @Column(name="PD_ADDR_02")
	private String PD_ADDR_02;

    @Column(name="PD_ADDR_03")
	private String PD_ADDR_03;
    
	//ADDED XTRA
    @Column(name ="PD_TXN_TYPE")
	private String PD_TXN_TYPE;
    
    @Column(name="PD_DPD_REF_ID")
    private String PD_DPD_REF_ID;
    
    @Column(name = "PD_SYS_ID")
    private int PD_SYS_ID;
    
    @Column(name = "PD_TXN_SYS_ID")
    private int PD_TXN_SYS_ID;
    
    @Column(name="PD_PAY_MODE")
    private String PD_PAY_MODE;
    
    @Column(name="PD_CURR_CODE")
    private String PD_CURR_CODE;
    
    private boolean CHECK_BOX;
    
    



	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getPD_PAY_MODE() {
		return PD_PAY_MODE;
	}

	public void setPD_PAY_MODE(String pd_pay_mode) {
		PD_PAY_MODE = pd_pay_mode;
	}

	public String getPD_CURR_CODE() {
		return PD_CURR_CODE;
	}

	public void setPD_CURR_CODE(String pd_curr_code) {
		PD_CURR_CODE = pd_curr_code;
	}

	public int getPD_TXN_SYS_ID() {
		return PD_TXN_SYS_ID;
	}

	public void setPD_TXN_SYS_ID(int pd_txn_sys_id) {
		PD_TXN_SYS_ID = pd_txn_sys_id;
	}

	public int getPD_SYS_ID() {
		return PD_SYS_ID;
	}

	public void setPD_SYS_ID(int pd_sys_id) {
		PD_SYS_ID = pd_sys_id;
	}

	public String getPD_DPD_REF_ID() {
		return PD_DPD_REF_ID;
	}

	public void setPD_DPD_REF_ID(String pd_dpd_ref_id) {
		PD_DPD_REF_ID = pd_dpd_ref_id;
	}

	public String getUI_M_PD_TXN_TYPE_DESC() {
		return UI_M_PD_TXN_TYPE_DESC;
	}

	public void setUI_M_PD_TXN_TYPE_DESC(String UI_M_PD_TXN_TYPE_DESC) {
		this.UI_M_PD_TXN_TYPE_DESC = UI_M_PD_TXN_TYPE_DESC;
	}

	public String getUI_M_PD_CURR_CODE_DESC() {
		return UI_M_PD_CURR_CODE_DESC;
	}

	public void setUI_M_PD_CURR_CODE_DESC(String UI_M_PD_CURR_CODE_DESC) {
		this.UI_M_PD_CURR_CODE_DESC = UI_M_PD_CURR_CODE_DESC;
	}

	public Double getPD_FC_AMT() {
		return PD_FC_AMT;
	}

	public void setPD_FC_AMT(Double PD_FC_AMT) {
		this.PD_FC_AMT = PD_FC_AMT;
	}

	public Double getPD_LC_AMT() {
		return PD_LC_AMT;
	}

	public void setPD_LC_AMT(Double PD_LC_AMT) {
		this.PD_LC_AMT = PD_LC_AMT;
	}

	public String getPD_BRANCH_NAME() {
		return PD_BRANCH_NAME;
	}

	public void setPD_BRANCH_NAME(String PD_BRANCH_NAME) {
		this.PD_BRANCH_NAME = PD_BRANCH_NAME;
	}

	public String getPD_CUST_NAME() {
		return PD_CUST_NAME;
	}

	public void setPD_CUST_NAME(String PD_CUST_NAME) {
		this.PD_CUST_NAME = PD_CUST_NAME;
	}

	public String getPD_ADDR_01() {
		return PD_ADDR_01;
	}

	public void setPD_ADDR_01(String PD_ADDR_01) {
		this.PD_ADDR_01 = PD_ADDR_01;
	}

	public String getPD_ADDR_02() {
		return PD_ADDR_02;
	}

	public void setPD_ADDR_02(String PD_ADDR_02) {
		this.PD_ADDR_02 = PD_ADDR_02;
	}

	public String getPD_ADDR_03() {
		return PD_ADDR_03;
	}

	public void setPD_ADDR_03(String PD_ADDR_03) {
		this.PD_ADDR_03 = PD_ADDR_03;
	}

	public String getPD_TXN_TYPE() {
		return PD_TXN_TYPE;
	}

	public void setPD_TXN_TYPE(String pd_txn_type) {
		PD_TXN_TYPE = pd_txn_type;
	}
}

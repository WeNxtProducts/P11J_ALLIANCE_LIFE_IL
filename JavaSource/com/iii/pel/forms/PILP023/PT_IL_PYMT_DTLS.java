package com.iii.pel.forms.PILP023;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS extends BaseValueBean {

	@Column(name="UI_M_PD_TXN_TYPE_DESC")
	private String UI_M_PD_TXN_TYPE_DESC;

	@Column(name="UI_M_PD_CURR_CODE_DESC")
	private String UI_M_PD_CURR_CODE_DESC;

	@Column(name="PD_FC_AMT")
	private Double PD_FC_AMT;

	@Column(name="PD_LC_AMT")
	private Double PD_LC_AMT;

	@Column(name="PD_BRANCH_NAME")
	private String PD_BRANCH_NAME;

	@Column(name="PD_CHQ_NO")
	private String PD_CHQ_NO;

	@Column(name="PD_CUST_NAME")
	private String PD_CUST_NAME;

	@Column(name="PD_ADDR_01")
	private String PD_ADDR_01;

	@Column(name="PD_ADDR_02")
	private String PD_ADDR_02;

	@Column(name="PD_ADDR_03")
	private String PD_ADDR_03;
	
	@Column(name="PD_SYS_ID")
	private Long PD_SYS_ID;
	
	@Column(name="PD_CURR_CODE")
	private String PD_CURR_CODE;
	
	@Column(name="PD_TXN_TYPE")
	private String PD_TXN_TYPE;
	
	@Column(name="PD_TXN_SYS_ID")
	private Double PD_TXN_SYS_ID;
	
	@Column(name="PD_SR_NO")
	private Double PD_SR_NO;

	
	private boolean selected;
	
	private boolean checkBoxValue;

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getPD_TXN_SYS_ID() {
		return PD_TXN_SYS_ID;
	}

	public void setPD_TXN_SYS_ID(Double pd_txn_sys_id) {
		PD_TXN_SYS_ID = pd_txn_sys_id;
	}

	public String getPD_TXN_TYPE() {
		return PD_TXN_TYPE;
	}

	public void setPD_TXN_TYPE(String pd_txn_type) {
		PD_TXN_TYPE = pd_txn_type;
	}

	

	/**
	 * @return the pD_SYS_ID
	 */
	public Long getPD_SYS_ID() {
		return PD_SYS_ID;
	}

	/**
	 * @param pd_sys_id the pD_SYS_ID to set
	 */
	public void setPD_SYS_ID(Long pd_sys_id) {
		PD_SYS_ID = pd_sys_id;
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

	public String getPD_CHQ_NO() {
		return PD_CHQ_NO;
	}

	public void setPD_CHQ_NO(String PD_CHQ_NO) {
		this.PD_CHQ_NO = PD_CHQ_NO;
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

	public String getPD_CURR_CODE() {
		return PD_CURR_CODE;
	}

	public void setPD_CURR_CODE(String pd_curr_code) {
		PD_CURR_CODE = pd_curr_code;
	}

	/**
	 * @return the pD_SR_NO
	 */
	public Double getPD_SR_NO() {
		return PD_SR_NO;
	}

	/**
	 * @param pd_sr_no the pD_SR_NO to set
	 */
	public void setPD_SR_NO(Double pd_sr_no) {
		PD_SR_NO = pd_sr_no;
	}
}

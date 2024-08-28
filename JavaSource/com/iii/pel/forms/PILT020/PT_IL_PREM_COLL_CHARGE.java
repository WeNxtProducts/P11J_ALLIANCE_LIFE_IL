package com.iii.pel.forms.PILT020;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PT_IL_PREM_COLL_CHARGE")
public class PT_IL_PREM_COLL_CHARGE extends BaseValueBean {

	@Column(name="PCC_CHARGE_CODE")
	private String PCC_CHARGE_CODE;

	
	@Column(name="PCC_SYS_ID")
	private int PCC_SYS_ID;
	
	@Column(name="PCC_FC_CHARGE_AMT")
	private Double PCC_FC_CHARGE_AMT;

	@Column(name="PCC_FC_INS_CHARGE_AMT")
	private Double PCC_FC_INS_CHARGE_AMT;

	private String UI_M_CHARGE_DESC;

	@Column(name="PCC_CUST_SHARE_PERC")
	private Double PCC_CUST_SHARE_PERC;

	@Column(name="PCC_APPLY_PERIOD")
	private String PCC_APPLY_PERIOD;

	@Column(name="PCC_LC_CHARGE_AMT")
	private Double PCC_LC_CHARGE_AMT;

	@Column(name="PCC_LC_INS_CHARGE_AMT")
	private Double PCC_LC_INS_CHARGE_AMT;

	private String UI_B_CHARGE_DESC;



	public String getPCC_CHARGE_CODE() {
		return PCC_CHARGE_CODE;
	}

	public void setPCC_CHARGE_CODE(String PCC_CHARGE_CODE) {
		this.PCC_CHARGE_CODE = PCC_CHARGE_CODE;
	}

	public Double getPCC_FC_CHARGE_AMT() {
		return PCC_FC_CHARGE_AMT;
	}

	public void setPCC_FC_CHARGE_AMT(Double PCC_FC_CHARGE_AMT) {
		this.PCC_FC_CHARGE_AMT = PCC_FC_CHARGE_AMT;
	}

	public Double getPCC_FC_INS_CHARGE_AMT() {
		return PCC_FC_INS_CHARGE_AMT;
	}

	public void setPCC_FC_INS_CHARGE_AMT(Double PCC_FC_INS_CHARGE_AMT) {
		this.PCC_FC_INS_CHARGE_AMT = PCC_FC_INS_CHARGE_AMT;
	}

	public String getUI_M_CHARGE_DESC() {
		return UI_M_CHARGE_DESC;
	}

	public void setUI_M_CHARGE_DESC(String UI_M_CHARGE_DESC) {
		this.UI_M_CHARGE_DESC = UI_M_CHARGE_DESC;
	}

	public Double getPCC_CUST_SHARE_PERC() {
		return PCC_CUST_SHARE_PERC;
	}

	public void setPCC_CUST_SHARE_PERC(Double PCC_CUST_SHARE_PERC) {
		this.PCC_CUST_SHARE_PERC = PCC_CUST_SHARE_PERC;
	}

	public String getPCC_APPLY_PERIOD() {
		return PCC_APPLY_PERIOD;
	}

	public void setPCC_APPLY_PERIOD(String PCC_APPLY_PERIOD) {
		this.PCC_APPLY_PERIOD = PCC_APPLY_PERIOD;
	}

	public Double getPCC_LC_CHARGE_AMT() {
		return PCC_LC_CHARGE_AMT;
	}

	public void setPCC_LC_CHARGE_AMT(Double PCC_LC_CHARGE_AMT) {
		this.PCC_LC_CHARGE_AMT = PCC_LC_CHARGE_AMT;
	}

	public Double getPCC_LC_INS_CHARGE_AMT() {
		return PCC_LC_INS_CHARGE_AMT;
	}

	public void setPCC_LC_INS_CHARGE_AMT(Double PCC_LC_INS_CHARGE_AMT) {
		this.PCC_LC_INS_CHARGE_AMT = PCC_LC_INS_CHARGE_AMT;
	}



	public int getPCC_SYS_ID() {
		return PCC_SYS_ID;
	}

	public void setPCC_SYS_ID(int pcc_sys_id) {
		PCC_SYS_ID = pcc_sys_id;
	}

	public String getUI_B_CHARGE_DESC() {
		return UI_B_CHARGE_DESC;
	}

	public void setUI_B_CHARGE_DESC(String UI_B_CHARGE_DESC) {
		UI_B_CHARGE_DESC = UI_B_CHARGE_DESC;
	}
}

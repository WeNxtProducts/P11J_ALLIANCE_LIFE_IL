package com.iii.pel.forms.PILM063_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_GROUP_THRESHOLD_DTL")
public class PM_IL_GROUP_THRESHOLD_DTL extends BaseValueBean {

	@Column(name="GTD_COVER_CODE")
	private String GTD_COVER_CODE;

	@Column(name="GTD_GROUP_CODE")
	private String GTD_GROUP_CODE;
	
	@Column(name="GTD_CR_UID")
	private String GTD_CR_UID;
	
	@Column(name="GTD_CR_DT")
	private Date GTD_CR_DT;   
	
	@Column(name="GTD_UPD_UID")
	private String GTD_UPD_UID;
	
	@Column(name="GTD_UPD_DT")
	private Date GTD_UPD_DT; 

	
	private String UI_M_GTD_COVER_CODE_DESC;
	
	private boolean checkBoxValue;

	public PM_IL_GROUP_THRESHOLD_DTL(){}
	
	public PM_IL_GROUP_THRESHOLD_DTL(String GTD_GROUP_CODE){
		this.GTD_COVER_CODE=GTD_GROUP_CODE;
	}
	
	public String getGTD_COVER_CODE() {
		return GTD_COVER_CODE;
	}

	public void setGTD_COVER_CODE(String GTD_COVER_CODE) {
		this.GTD_COVER_CODE = GTD_COVER_CODE;
	}

	public String getUI_M_GTD_COVER_CODE_DESC() {
		return UI_M_GTD_COVER_CODE_DESC;
	}

	public void setUI_M_GTD_COVER_CODE_DESC(String UI_M_GTD_COVER_CODE_DESC) {
		this.UI_M_GTD_COVER_CODE_DESC = UI_M_GTD_COVER_CODE_DESC;
	}

	public String getGTD_GROUP_CODE() {
		return GTD_GROUP_CODE;
	}

	public void setGTD_GROUP_CODE(String gtd_group_code) {
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Setting Group Code = "+gtd_group_code);
		GTD_GROUP_CODE = gtd_group_code;
	}

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public String getGTD_CR_UID() {
		return GTD_CR_UID;
	}

	public void setGTD_CR_UID(String gtd_cr_uid) {
		GTD_CR_UID = gtd_cr_uid;
	}

	public Date getGTD_CR_DT() {
		return GTD_CR_DT;
	}

	public void setGTD_CR_DT(Date gtd_cr_dt) {
		GTD_CR_DT = gtd_cr_dt;
	}

	public String getGTD_UPD_UID() {
		return GTD_UPD_UID;
	}

	public void setGTD_UPD_UID(String gtd_upd_uid) {
		GTD_UPD_UID = gtd_upd_uid;
	}

	public Date getGTD_UPD_DT() {
		return GTD_UPD_DT;
	}

	public void setGTD_UPD_DT(Date gtd_upd_dt) {
		GTD_UPD_DT = gtd_upd_dt;
	}
		
}

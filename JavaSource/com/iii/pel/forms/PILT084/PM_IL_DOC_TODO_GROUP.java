package com.iii.pel.forms.PILT084;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_TODO_GROUP")
public class PM_IL_DOC_TODO_GROUP extends BaseValueBean {

	@Column(name="DTG_DS_TYPE")
	private String DTG_DS_TYPE;

	@Column(name="DTG_DS_CODE")
	private String DTG_DS_CODE;

	@Column(name="DTG_GROUP_CODE")
	private String DTG_GROUP_CODE;

	@Column(name="DTG_RESULT")
	private String DTG_RESULT;

	@Column(name="DTG_CR_DT")
	private Date DTG_CR_DT;

	@Column(name="DTG_CR_UID")
	private String DTG_CR_UID;

	@Column(name="DTG_UPD_DT")
	private Date DTG_UPD_DT;

	@Column(name="DTG_UPD_UID")
	private String DTG_UPD_UID;

	@Column(name="DTG_GROUP_TYPE")
	private String DTG_GROUP_TYPE;

	@Column(name="DTG_GROUP_DESC")
	private String DTG_GROUP_DESC;

	private String UI_M_DTG_GROUP_CODE_DESC;
	public void setDTG_GROUP_TYPE(String DTG_GROUP_TYPE) {
		this.DTG_GROUP_TYPE = DTG_GROUP_TYPE;
	}
	public String getDTG_GROUP_TYPE() {
		 return DTG_GROUP_TYPE;
	}
	public void setDTG_DS_TYPE(String DTG_DS_TYPE) {
		this.DTG_DS_TYPE = DTG_DS_TYPE;
	}
	public String getDTG_DS_TYPE() {
		 return DTG_DS_TYPE;
	}
	public void setDTG_UPD_UID(String DTG_UPD_UID) {
		this.DTG_UPD_UID = DTG_UPD_UID;
	}
	public String getDTG_UPD_UID() {
		 return DTG_UPD_UID;
	}
	public void setDTG_CR_DT(Date DTG_CR_DT) {
		this.DTG_CR_DT = DTG_CR_DT;
	}
	public Date getDTG_CR_DT() {
		 return DTG_CR_DT;
	}
	public void setDTG_UPD_DT(Date DTG_UPD_DT) {
		this.DTG_UPD_DT = DTG_UPD_DT;
	}
	public Date getDTG_UPD_DT() {
		 return DTG_UPD_DT;
	}
	public void setUI_M_DTG_GROUP_CODE_DESC(String UI_M_DTG_GROUP_CODE_DESC) {
		this.UI_M_DTG_GROUP_CODE_DESC = UI_M_DTG_GROUP_CODE_DESC;
	}
	public String getUI_M_DTG_GROUP_CODE_DESC() {
		 return UI_M_DTG_GROUP_CODE_DESC;
	}
	public void setDTG_GROUP_DESC(String DTG_GROUP_DESC) {
		this.DTG_GROUP_DESC = DTG_GROUP_DESC;
	}
	public String getDTG_GROUP_DESC() {
		 return DTG_GROUP_DESC;
	}
	public void setDTG_CR_UID(String DTG_CR_UID) {
		this.DTG_CR_UID = DTG_CR_UID;
	}
	public String getDTG_CR_UID() {
		 return DTG_CR_UID;
	}
	public void setDTG_GROUP_CODE(String DTG_GROUP_CODE) {
		this.DTG_GROUP_CODE = DTG_GROUP_CODE;
	}
	public String getDTG_GROUP_CODE() {
		 return DTG_GROUP_CODE;
	}
	public void setDTG_RESULT(String DTG_RESULT) {
		this.DTG_RESULT = DTG_RESULT;
	}
	public String getDTG_RESULT() {
		 return DTG_RESULT;
	}
	public void setDTG_DS_CODE(String DTG_DS_CODE) {
		this.DTG_DS_CODE = DTG_DS_CODE;
	}
	public String getDTG_DS_CODE() {
		 return DTG_DS_CODE;
	}
	
	

}

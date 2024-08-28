package com.iii.pel.forms.PILM016_APAC;

import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PM_IL_CLASS")
public class PM_IL_CLASS {

	@Column(name="CLASS_CODE")
	private String CLASS_CODE;

	@Column(name="CLASS_NAME")
	private String CLASS_NAME;

	@Column(name="CLASS_SHORT_NAME")
	private String CLASS_SHORT_NAME;

	@Column(name="CLASS_FACIN_YN")
	private String CLASS_FACIN_YN;

	@Column(name="CLASS_FRZ_FLAG")
	private String CLASS_FRZ_FLAG;


	@Column(name="CLASS_CR_DT")
	private String CLASS_CR_DT;
	
	@Column(name="CLASS_CR_UID")
	private String CLASS_CR_UID;

	private String errorMessage="";
	
	private List FACIN_LIST=new ArrayList();
	
	private boolean rendered=false;


	public String getCLASS_CODE() {
		return CLASS_CODE;
	}

	public void setCLASS_CODE(String CLASS_CODE) {
		this.CLASS_CODE = CLASS_CODE;
	}

	public String getCLASS_NAME() {
		return CLASS_NAME;
	}

	public void setCLASS_NAME(String CLASS_NAME) {
		this.CLASS_NAME = CLASS_NAME;
	}

	public String getCLASS_SHORT_NAME() {
		return CLASS_SHORT_NAME;
	}

	public void setCLASS_SHORT_NAME(String CLASS_SHORT_NAME) {
		this.CLASS_SHORT_NAME = CLASS_SHORT_NAME;
	}

	public String getCLASS_FACIN_YN() {
		return CLASS_FACIN_YN;
	}

	public void setCLASS_FACIN_YN(String CLASS_FACIN_YN) {
		this.CLASS_FACIN_YN = CLASS_FACIN_YN;
	}

	public String getCLASS_FRZ_FLAG() {
		return CLASS_FRZ_FLAG;
	}

	public void setCLASS_FRZ_FLAG(String CLASS_FRZ_FLAG) {
		this.CLASS_FRZ_FLAG = CLASS_FRZ_FLAG;
	}

	public String getCLASS_CR_DT() {
		return CLASS_CR_DT;
	}

	public String getCLASS_CR_UID() {
		return CLASS_CR_UID;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List getFACIN_LIST() {
		return FACIN_LIST;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setCLASS_CR_DT(String class_cr_dt) {
		CLASS_CR_DT = class_cr_dt;
	}

	public void setCLASS_CR_UID(String class_cr_uid) {
		CLASS_CR_UID = class_cr_uid;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFACIN_LIST(List facin_list) {
		FACIN_LIST = facin_list;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}
}

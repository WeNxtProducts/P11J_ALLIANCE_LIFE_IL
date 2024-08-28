package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
/**
 * @author PIDUGU RAJ dt:23-08-2018
 *
 */
@Table(name="PT_IL_POL_CUST_DTLS")
public class PT_IL_POL_CUST_DTLS extends BaseValueBean{
	
	
	@Column(name="PCD_SYS_ID")
	private int PCD_SYS_ID;

	
	@Column(name="PCD_POL_SYS_ID")
	private int PCD_POL_SYS_ID;
	
	@Column(name="PCD_CUST_NAME")
	private String PCD_CUST_NAME;
	
	@Column(name="PCD_CIVIL_ID")
	private String PCD_CIVIL_ID;
	
	
	@Column(name="PCD_RELATION_TYPE")
	private String PCD_RELATION_TYPE;
	
	
	@Column(name="PCD_DOB")
	private Date PCD_DOB;


	


	

	public int getPCD_SYS_ID() {
		return PCD_SYS_ID;
	}


	public void setPCD_SYS_ID(int pCD_SYS_ID) {
		PCD_SYS_ID = pCD_SYS_ID;
	}


	public int getPCD_POL_SYS_ID() {
		return PCD_POL_SYS_ID;
	}


	public void setPCD_POL_SYS_ID(int pCD_POL_SYS_ID) {
		PCD_POL_SYS_ID = pCD_POL_SYS_ID;
	}


	public String getPCD_CUST_NAME() {
		return PCD_CUST_NAME;
	}


	public void setPCD_CUST_NAME(String pCD_CUST_NAME) {
		PCD_CUST_NAME = pCD_CUST_NAME;
	}


	public String getPCD_CIVIL_ID() {
		return PCD_CIVIL_ID;
	}


	public void setPCD_CIVIL_ID(String pCD_CIVIL_ID) {
		PCD_CIVIL_ID = pCD_CIVIL_ID;
	}


	public String getPCD_RELATION_TYPE() {
		return PCD_RELATION_TYPE;
	}


	public void setPCD_RELATION_TYPE(String pCD_RELATION_TYPE) {
		PCD_RELATION_TYPE = pCD_RELATION_TYPE;
	}


	public Date getPCD_DOB() {
		return PCD_DOB;
	}


	public void setPCD_DOB(Date pCD_DOB) {
		PCD_DOB = pCD_DOB;
	}

	private String UI_M_PFMD_RELATION_DESC;



	public String getUI_M_PFMD_RELATION_DESC() {
		return UI_M_PFMD_RELATION_DESC;
	}



	public void setUI_M_PFMD_RELATION_DESC(String uI_M_PFMD_RELATION_DESC) {
		UI_M_PFMD_RELATION_DESC = uI_M_PFMD_RELATION_DESC;
	}
	
	
	
}

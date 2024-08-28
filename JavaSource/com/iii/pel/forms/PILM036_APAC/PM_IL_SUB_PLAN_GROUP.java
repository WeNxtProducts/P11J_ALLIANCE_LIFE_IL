package com.iii.pel.forms.PILM036_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_SUB_PLAN_GROUP")
public class PM_IL_SUB_PLAN_GROUP extends BaseValueBean{

	@Column(name="SPG_CODE")
	private String SPG_CODE;

	@Column(name="SPG_DESC")
	private String SPG_DESC;

	@Column(name="SPG_MEMB_TYPE")
	private String SPG_MEMB_TYPE;
	
	@Column(name="SPG_MEMB_DESC")
	private String SPG_MEMB_DESC;
	
	@Column(name="SPG_MEMB_COUNT")
	private int SPG_MEMB_COUNT;
		
	@Column(name="SPG_CR_DT")
	private Date SPG_CR_DT;

	@Column(name="SPG_CR_UID")
	private String SPG_CR_UID;

	@Column(name="SPG_UPD_DT")
	private Date SPG_UPD_DT;

	@Column(name="SPG_UPD_UID")
	private String SPG_UPD_UID;
	

	
	/* Newly Added By Dhinesh on 13-06-2018 for FLA ssp call id  : FLALIFEQC-1754262 */
	@Column(name="SPG_SPLAN_CODE")
	private String SPG_SPLAN_CODE;

	public String getSPG_SPLAN_CODE() {
		return SPG_SPLAN_CODE;
	}

	public void setSPG_SPLAN_CODE(String sPG_SPLAN_CODE) {
		SPG_SPLAN_CODE = sPG_SPLAN_CODE;
	}

	/* End */
	
	
	
	public String getSPG_CODE() {
		return SPG_CODE;
	}

	public void setSPG_CODE(String sPG_CODE) {
		SPG_CODE = sPG_CODE;
	}

	public String getSPG_DESC() {
		return SPG_DESC;
	}

	public void setSPG_DESC(String sPG_DESC) {
		SPG_DESC = sPG_DESC;
	}

	public String getSPG_MEMB_TYPE() {
		return SPG_MEMB_TYPE;
	}

	public void setSPG_MEMB_TYPE(String sPG_MEMB_TYPE) {
		SPG_MEMB_TYPE = sPG_MEMB_TYPE;
	}

	public String getSPG_MEMB_DESC() {
		return SPG_MEMB_DESC;
	}

	public void setSPG_MEMB_DESC(String sPG_MEMB_DESC) {
		SPG_MEMB_DESC = sPG_MEMB_DESC;
	}

	public int getSPG_MEMB_COUNT() {
		return SPG_MEMB_COUNT;
	}

	public void setSPG_MEMB_COUNT(int sPG_MEMB_COUNT) {
		SPG_MEMB_COUNT = sPG_MEMB_COUNT;
	}

	public Date getSPG_CR_DT() {
		return SPG_CR_DT;
	}

	public void setSPG_CR_DT(Date sPG_CR_DT) {
		SPG_CR_DT = sPG_CR_DT;
	}

	public String getSPG_CR_UID() {
		return SPG_CR_UID;
	}

	public void setSPG_CR_UID(String sPG_CR_UID) {
		SPG_CR_UID = sPG_CR_UID;
	}

	public Date getSPG_UPD_DT() {
		return SPG_UPD_DT;
	}

	public void setSPG_UPD_DT(Date sPG_UPD_DT) {
		SPG_UPD_DT = sPG_UPD_DT;
	}

	public String getSPG_UPD_UID() {
		return SPG_UPD_UID;
	}

	public void setSPG_UPD_UID(String sPG_UPD_UID) {
		SPG_UPD_UID = sPG_UPD_UID;
	}

	
	
	
	
}

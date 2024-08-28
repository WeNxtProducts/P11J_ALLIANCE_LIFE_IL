package com.iii.pel.forms.PILM031;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.pel.forms.PILM052_APAC.PM_DEPT_DRCR_LINK;
import com.iii.pel.forms.PILM052_APAC.PM_DEPT_DRCR_LINK_HELPER;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_DISC_AGE")
public class PM_IL_DISC_AGE extends BaseValueBean {

	@Column(name = "DA_ADDL_RISK_CODE")
	private String DA_ADDL_RISK_CODE;

	@Column(name = "DA_CATG_CODE")
	private String DA_CATG_CODE;

	@Column(name = "DA_UW_AGE")
	private Integer DA_UW_AGE;

	@Column(name = "DA_RI_AGE")
	private Integer DA_RI_AGE;

	@Column(name = "DA_EFF_FM_DT")
	private Date DA_EFF_FM_DT;

	@Column(name = "DA_EFF_TO_DT")
	private Date DA_EFF_TO_DT;

	@Column(name = "DA_CR_UID")
	private String DA_CR_UID;

	@Column(name = "DA_CR_DT")
	private Date DA_CR_DT;

	@Column(name = "DA_UPD_UID")
	private String DA_UPD_UID;

	@Column(name = "DA_UPD_DT")
	private Date DA_UPD_DT;

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	private String UI_M_DA_ADDL_RISK_DESC;
	private String UI_M_DA_CATG_DESC;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
	
	public void setUI_M_DA_ADDL_RISK_DESC(String UI_M_DA_ADDL_RISK_DESC) {
		this.UI_M_DA_ADDL_RISK_DESC = UI_M_DA_ADDL_RISK_DESC;
	}

	public String getUI_M_DA_ADDL_RISK_DESC() {
		return UI_M_DA_ADDL_RISK_DESC;
	}

	public void setDA_UPD_DT(Date DA_UPD_DT) {
		this.DA_UPD_DT = DA_UPD_DT;
	}

	public Date getDA_UPD_DT() {
		return DA_UPD_DT;
	}

	public void setDA_CR_DT(Date DA_CR_DT) {
		this.DA_CR_DT = DA_CR_DT;
	}

	public Date getDA_CR_DT() {
		return DA_CR_DT;
	}

	public void setDA_RI_AGE(Integer DA_RI_AGE) {
		this.DA_RI_AGE = DA_RI_AGE;
	}

	public Integer getDA_RI_AGE() {
		return DA_RI_AGE;
	}

	public void setUI_M_DA_CATG_DESC(String UI_M_DA_CATG_DESC) {
		this.UI_M_DA_CATG_DESC = UI_M_DA_CATG_DESC;
	}

	public String getUI_M_DA_CATG_DESC() {
		return UI_M_DA_CATG_DESC;
	}

	public void setDA_UPD_UID(String DA_UPD_UID) {
		this.DA_UPD_UID = DA_UPD_UID;
	}

	public String getDA_UPD_UID() {
		return DA_UPD_UID;
	}

	public void setDA_ADDL_RISK_CODE(String DA_ADDL_RISK_CODE) {
		this.DA_ADDL_RISK_CODE = DA_ADDL_RISK_CODE;
	}

	public String getDA_ADDL_RISK_CODE() {
		return DA_ADDL_RISK_CODE;
	}

	public void setDA_UW_AGE(Integer DA_UW_AGE) {
		this.DA_UW_AGE = DA_UW_AGE;
	}

	public Integer getDA_UW_AGE() {
		return DA_UW_AGE;
	}

	public void setDA_CR_UID(String DA_CR_UID) {
		this.DA_CR_UID = DA_CR_UID;
	}

	public String getDA_CR_UID() {
		return DA_CR_UID;
	}

	public void setDA_EFF_TO_DT(Date DA_EFF_TO_DT) {
		this.DA_EFF_TO_DT = DA_EFF_TO_DT;
	}

	public Date getDA_EFF_TO_DT() {
		return DA_EFF_TO_DT;
	}

	public void setDA_EFF_FM_DT(Date DA_EFF_FM_DT) {
		this.DA_EFF_FM_DT = DA_EFF_FM_DT;
	}

	public Date getDA_EFF_FM_DT() {
		return DA_EFF_FM_DT;
	}

	public void setDA_CATG_CODE(String DA_CATG_CODE) {
		this.DA_CATG_CODE = DA_CATG_CODE;
	}

	public String getDA_CATG_CODE() {
		return DA_CATG_CODE;
	}
}
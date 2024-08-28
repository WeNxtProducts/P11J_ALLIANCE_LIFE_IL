package com.iii.pel.forms.PILM204;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_FORMULA_PARAM")
public class PM_IL_FORMULA_PARAM extends BaseValueBean {

	@Column(name="FP_SRNO")
	private int FP_SRNO;

	@Column(name="FP_CAPTION")
	private String FP_CAPTION;

	@Column(name="FP_WHERE_CLAUSE")
	private String FP_WHERE_CLAUSE;

	@Column(name="FP_BL_CAPTION")
	private String FP_BL_CAPTION;

	@Column(name="FP_DATA_TYPE")
	private String FP_DATA_TYPE;

	@Column(name="FP_TABLE_NAME")
	private String FP_TABLE_NAME;

	@Column(name="FP_COL_NAME")
	private String FP_COL_NAME;
	
	@Column(name="FP_CR_DT")
	private Date FP_CR_DT;
	
	@Column(name="FP_CR_UID")
	private String FP_CR_UID;
	
	@Column(name="FP_UPD_DT")
	private Date FP_UPD_DT;
	
	@Column(name="FP_UPD_UID")
	private String FP_UPD_UID;
	
	private boolean selected = false;


	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getFP_SRNO() {
		return FP_SRNO;
	}

	public void setFP_SRNO(int FP_SRNO) {
		this.FP_SRNO = FP_SRNO;
	}

	public String getFP_CAPTION() {
		return FP_CAPTION;
	}

	public void setFP_CAPTION(String FP_CAPTION) {
		this.FP_CAPTION = FP_CAPTION;
	}

	public String getFP_WHERE_CLAUSE() {
		return FP_WHERE_CLAUSE;
	}

	public void setFP_WHERE_CLAUSE(String FP_WHERE_CLAUSE) {
		this.FP_WHERE_CLAUSE = FP_WHERE_CLAUSE;
	}

	public String getFP_BL_CAPTION() {
		return FP_BL_CAPTION;
	}

	public void setFP_BL_CAPTION(String FP_BL_CAPTION) {
		this.FP_BL_CAPTION = FP_BL_CAPTION;
	}

	public String getFP_DATA_TYPE() {
		return FP_DATA_TYPE;
	}

	public void setFP_DATA_TYPE(String FP_DATA_TYPE) {
		this.FP_DATA_TYPE = FP_DATA_TYPE;
	}

	public String getFP_TABLE_NAME() {
		return FP_TABLE_NAME;
	}

	public void setFP_TABLE_NAME(String FP_TABLE_NAME) {
		this.FP_TABLE_NAME = FP_TABLE_NAME;
	}

	public String getFP_COL_NAME() {
		return FP_COL_NAME;
	}

	public void setFP_COL_NAME(String FP_COL_NAME) {
		this.FP_COL_NAME = FP_COL_NAME;
	}

	public Date getFP_CR_DT() {
		return FP_CR_DT;
	}

	public void setFP_CR_DT(Date FP_cr_dt) {
		FP_CR_DT = FP_cr_dt;
	}

	public String getFP_CR_UID() {
		return FP_CR_UID;
	}

	public void setFP_CR_UID(String FP_cr_uid) {
		FP_CR_UID = FP_cr_uid;
	}

	public Date getFP_UPD_DT() {
		return FP_UPD_DT;
	}

	public void setFP_UPD_DT(Date FP_upd_dt) {
		FP_UPD_DT = FP_upd_dt;
	}

	public String getFP_UPD_UID() {
		return FP_UPD_UID;
	}

	public void setFP_UPD_UID(String FP_upd_uid) {
		FP_UPD_UID = FP_upd_uid;
	}
}

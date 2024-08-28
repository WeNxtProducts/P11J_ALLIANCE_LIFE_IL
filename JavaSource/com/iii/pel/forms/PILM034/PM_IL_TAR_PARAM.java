package com.iii.pel.forms.PILM034;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_TAR_PARAM")
public class PM_IL_TAR_PARAM extends BaseValueBean {

	@Column(name="TP_SRNO")
	private int TP_SRNO;

	@Column(name="TP_CAPTION")
	private String TP_CAPTION;

	@Column(name="TP_WHERE_CLAUSE")
	private String TP_WHERE_CLAUSE;

	@Column(name="TP_BL_CAPTION")
	private String TP_BL_CAPTION;

	@Column(name="TP_DATA_TYPE")
	private String TP_DATA_TYPE;

	@Column(name="TP_TABLE_NAME")
	private String TP_TABLE_NAME;

	@Column(name="TP_COL_NAME")
	private String TP_COL_NAME;
	
	@Column(name="TP_CR_DT")
	private Date TP_CR_DT;
	
	@Column(name="TP_CR_UID")
	private String TP_CR_UID;
	
	@Column(name="TP_UPD_DT")
	private Date TP_UPD_DT;
	
	@Column(name="TP_UPD_UID")
	private String TP_UPD_UID;
	
	private boolean selected = false;


	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getTP_SRNO() {
		return TP_SRNO;
	}

	public void setTP_SRNO(int TP_SRNO) {
		this.TP_SRNO = TP_SRNO;
	}

	public String getTP_CAPTION() {
		return TP_CAPTION;
	}

	public void setTP_CAPTION(String TP_CAPTION) {
		this.TP_CAPTION = TP_CAPTION;
	}

	public String getTP_WHERE_CLAUSE() {
		return TP_WHERE_CLAUSE;
	}

	public void setTP_WHERE_CLAUSE(String TP_WHERE_CLAUSE) {
		this.TP_WHERE_CLAUSE = TP_WHERE_CLAUSE;
	}

	public String getTP_BL_CAPTION() {
		return TP_BL_CAPTION;
	}

	public void setTP_BL_CAPTION(String TP_BL_CAPTION) {
		this.TP_BL_CAPTION = TP_BL_CAPTION;
	}

	public String getTP_DATA_TYPE() {
		return TP_DATA_TYPE;
	}

	public void setTP_DATA_TYPE(String TP_DATA_TYPE) {
		this.TP_DATA_TYPE = TP_DATA_TYPE;
	}

	public String getTP_TABLE_NAME() {
		return TP_TABLE_NAME;
	}

	public void setTP_TABLE_NAME(String TP_TABLE_NAME) {
		this.TP_TABLE_NAME = TP_TABLE_NAME;
	}

	public String getTP_COL_NAME() {
		return TP_COL_NAME;
	}

	public void setTP_COL_NAME(String TP_COL_NAME) {
		this.TP_COL_NAME = TP_COL_NAME;
	}

	public Date getTP_CR_DT() {
		return TP_CR_DT;
	}

	public void setTP_CR_DT(Date tp_cr_dt) {
		TP_CR_DT = tp_cr_dt;
	}

	public String getTP_CR_UID() {
		return TP_CR_UID;
	}

	public void setTP_CR_UID(String tp_cr_uid) {
		TP_CR_UID = tp_cr_uid;
	}

	public Date getTP_UPD_DT() {
		return TP_UPD_DT;
	}

	public void setTP_UPD_DT(Date tp_upd_dt) {
		TP_UPD_DT = tp_upd_dt;
	}

	public String getTP_UPD_UID() {
		return TP_UPD_UID;
	}

	public void setTP_UPD_UID(String tp_upd_uid) {
		TP_UPD_UID = tp_upd_uid;
	}
}

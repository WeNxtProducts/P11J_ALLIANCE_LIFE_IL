package com.iii.pel.forms.PILM203;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_COVER")
public class PM_IL_COVER extends BaseValueBean {

	@Column(name="COVER_CODE")
	private String COVER_CODE;

	@Column(name="COVER_DESC")
	private String COVER_DESC;

	@Column(name="COVER_LIMIT_TYPE")
	private String COVER_LIMIT_TYPE;

	@Column(name="COVER_PER_DAY_LC_AMT")
	private Double COVER_PER_DAY_LC_AMT;

	@Column(name="COVER_LIMIT_DAYS")
	private Double COVER_LIMIT_DAYS;

	@Column(name="COVER_LC_LIMIT")
	private Double COVER_LC_LIMIT;
	
	@Column(name="COVER_UPD_DT")
	private Date COVER_UPD_DT;
	
	@Column(name="COVER_UPD_UID")
	private String COVER_UPD_UID;
	
	@Column(name="COVER_FRZ_FLAG")
	private String COVER_FRZ_FLAG;

	public String getCOVER_CODE() {
		return COVER_CODE;
	}

	public void setCOVER_CODE(String COVER_CODE) {
		this.COVER_CODE = COVER_CODE;
	}

	public String getCOVER_DESC() {
		return COVER_DESC;
	}

	public void setCOVER_DESC(String COVER_DESC) {
		this.COVER_DESC = COVER_DESC;
	}

	public String getCOVER_LIMIT_TYPE() {
		return COVER_LIMIT_TYPE;
	}

	public void setCOVER_LIMIT_TYPE(String COVER_LIMIT_TYPE) {
		this.COVER_LIMIT_TYPE = COVER_LIMIT_TYPE;
	}

	public Double getCOVER_PER_DAY_LC_AMT() {
		return COVER_PER_DAY_LC_AMT;
	}

	public void setCOVER_PER_DAY_LC_AMT(Double COVER_PER_DAY_LC_AMT) {
		this.COVER_PER_DAY_LC_AMT = COVER_PER_DAY_LC_AMT;
	}

	public Double getCOVER_LIMIT_DAYS() {
		return COVER_LIMIT_DAYS;
	}

	public void setCOVER_LIMIT_DAYS(Double COVER_LIMIT_DAYS) {
		this.COVER_LIMIT_DAYS = COVER_LIMIT_DAYS;
	}

	public Double getCOVER_LC_LIMIT() {
		return COVER_LC_LIMIT;
	}

	public void setCOVER_LC_LIMIT(Double COVER_LC_LIMIT) {
		this.COVER_LC_LIMIT = COVER_LC_LIMIT;
	}

	public Date getCOVER_UPD_DT() {
		return COVER_UPD_DT;
	}

	public void setCOVER_UPD_DT(Date cover_upd_dt) {
		COVER_UPD_DT = cover_upd_dt;
	}

	public String getCOVER_UPD_UID() {
		return COVER_UPD_UID;
	}

	public void setCOVER_UPD_UID(String cover_upd_uid) {
		COVER_UPD_UID = cover_upd_uid;
	}

	public String getCOVER_FRZ_FLAG() {
		return COVER_FRZ_FLAG;
	}

	public void setCOVER_FRZ_FLAG(String cover_frz_flag) {
		COVER_FRZ_FLAG = cover_frz_flag;
	}
}
package com.iii.pel.forms.PILM062_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_GROUP")
public class PM_IL_PROD_GROUP extends BaseValueBean {

	@Column(name="PG_CODE")
	private String PG_CODE;

	private String PG_CODE_DESC;

	@Column(name="PG_PROD_CODE")
	private String PG_PROD_CODE;

	private String PG_PROD_CODE_DESC;

	@Column(name="PG_CR_UID")
	private String PG_CR_UID;
	
	@Column(name="PG_CR_DT")
	private Date PG_CR_DT;
	
	private boolean checked;


	public String getPG_CODE() {
		return PG_CODE;
	}

	public void setPG_CODE(String PG_CODE) {
		this.PG_CODE = PG_CODE;
	}

	public String getPG_CODE_DESC() {
		return PG_CODE_DESC;
	}

	public void setPG_CODE_DESC(String PG_CODE_DESC) {
		this.PG_CODE_DESC = PG_CODE_DESC;
	}

	public String getPG_PROD_CODE() {
		return PG_PROD_CODE;
	}

	public void setPG_PROD_CODE(String PG_PROD_CODE) {
		this.PG_PROD_CODE = PG_PROD_CODE;
	}

	public String getPG_PROD_CODE_DESC() {
		return PG_PROD_CODE_DESC;
	}

	public void setPG_PROD_CODE_DESC(String PG_PROD_CODE_DESC) {
		this.PG_PROD_CODE_DESC = PG_PROD_CODE_DESC;
	}

	public String getPG_CR_UID() {
		return PG_CR_UID;
	}

	public void setPG_CR_UID(String pg_cr_uid) {
		PG_CR_UID = pg_cr_uid;
	}

	public Date getPG_CR_DT() {
		return PG_CR_DT;
	}

	public void setPG_CR_DT(Date pg_cr_dt) {
		PG_CR_DT = pg_cr_dt;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

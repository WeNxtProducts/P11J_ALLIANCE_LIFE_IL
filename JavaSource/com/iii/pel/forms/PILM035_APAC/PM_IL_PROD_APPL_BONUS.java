package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_BONUS")
public class PM_IL_PROD_APPL_BONUS extends BaseValueBean{

	@Column(name="PAB_PROD_CODE")
	private String PAB_PROD_CODE;

	@Column(name="PAB_BONUS_CODE")
	private String PAB_BONUS_CODE;

	@Column(name="PAB_CR_DT")
	private Date PAB_CR_DT;

	@Column(name="PAB_CR_UID")
	private String PAB_CR_UID;

	@Column(name="PAB_UPD_DT")
	private Date PAB_UPD_DT;

	@Column(name="PAB_UPD_UID")
	private String PAB_UPD_UID;
	
	private String PAB_BONUS_CODE_DESC;
	
	private String PROD_BONUS_EARN_INT;



	public String getPROD_BONUS_EARN_INT() {
		return PROD_BONUS_EARN_INT;
	}

	public void setPROD_BONUS_EARN_INT(String prod_bonus_earn_int) {
		PROD_BONUS_EARN_INT = prod_bonus_earn_int;
	}

	public String getPAB_BONUS_CODE_DESC() {
		return PAB_BONUS_CODE_DESC;
	}

	public void setPAB_BONUS_CODE_DESC(String pab_bonus_code_desc) {
		PAB_BONUS_CODE_DESC = pab_bonus_code_desc;
	}

	public String getPAB_PROD_CODE() {
		 return PAB_PROD_CODE;
	}

	public void setPAB_PROD_CODE(String PAB_PROD_CODE) {
		this.PAB_PROD_CODE = PAB_PROD_CODE;
	}

	public String getPAB_BONUS_CODE() {
		 return PAB_BONUS_CODE;
	}

	public void setPAB_BONUS_CODE(String PAB_BONUS_CODE) {
		this.PAB_BONUS_CODE = PAB_BONUS_CODE;
	}

	public Date getPAB_CR_DT() {
		 return PAB_CR_DT;
	}

	public void setPAB_CR_DT(Date PAB_CR_DT) {
		this.PAB_CR_DT = PAB_CR_DT;
	}

	public String getPAB_CR_UID() {
		 return PAB_CR_UID;
	}

	public void setPAB_CR_UID(String PAB_CR_UID) {
		this.PAB_CR_UID = PAB_CR_UID;
	}

	public Date getPAB_UPD_DT() {
		 return PAB_UPD_DT;
	}

	public void setPAB_UPD_DT(Date PAB_UPD_DT) {
		this.PAB_UPD_DT = PAB_UPD_DT;
	}

	public String getPAB_UPD_UID() {
		 return PAB_UPD_UID;
	}

	public void setPAB_UPD_UID(String PAB_UPD_UID) {
		this.PAB_UPD_UID = PAB_UPD_UID;
	}
}

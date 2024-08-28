package com.iii.pel.forms.PILM037;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BONUS_SETUP")
public class PM_IL_BONUS_SETUP extends BaseValueBean {
	
	@Column(name="BSET_PLAN_CODE")
	private String BSET_PLAN_CODE;

	private String UI_M_PLAN_CODE_DESC;
	
	
	@Column(name="BSET_BONUS_CODE")
	private String BSET_BONUS_CODE;

	private String UI_M_BSET_BONUS_CODE_DESC;

	@Column(name="BSET_YEAR")
	private Integer BSET_YEAR;

	@Column(name="BSET_RATE")
	private Double BSET_RATE;

	@Column(name="BSET_RATE_PER")
	private Double BSET_RATE_PER;
	
	@Column(name="BSET_CR_DT")
	private Date BSET_CR_DT;
	
	@Column(name="BSET_CR_UID")
	private String BSET_CR_UID;
	
	@Column(name="BSET_UPD_DT")
	private Date BSET_UPD_DT;
	
	@Column(name="BSET_UPD_UID")
	private String BSET_UPD_UID;
	
	@Column(name="BSET_BONUS_GIVEN_IN")
	private String BSET_BONUS_GIVEN_IN;
	
	@Column(name="BSET_APPLIED_ON")
	private String BSET_APPLIED_ON;
	
	@Column(name="BSET_UNIT_PUR_YN")
	private String BSET_UNIT_PUR_YN ;
	
	@Column(name="BSET_BUY_SELL")
	private String BSET_BUY_SELL;
	

	private boolean selected = false;	
	

	public String getBSET_PLAN_CODE() {
		return BSET_PLAN_CODE;
	}

	public void setBSET_PLAN_CODE(String bset_plan_code) {
		BSET_PLAN_CODE = bset_plan_code;
	}

	public String getUI_M_PLAN_CODE_DESC() {
		return UI_M_PLAN_CODE_DESC;
	}

	public void setUI_M_PLAN_CODE_DESC(String ui_m_plan_code_desc) {
		UI_M_PLAN_CODE_DESC = ui_m_plan_code_desc;
	}

	public String getBSET_BONUS_CODE() {
		return BSET_BONUS_CODE;
	}

	public void setBSET_BONUS_CODE(String bset_bonus_code) {
		BSET_BONUS_CODE = bset_bonus_code;
	}

	public String getUI_M_BSET_BONUS_CODE_DESC() {
		return UI_M_BSET_BONUS_CODE_DESC;
	}

	public void setUI_M_BSET_BONUS_CODE_DESC(String ui_m_bset_bonus_code_desc) {
		UI_M_BSET_BONUS_CODE_DESC = ui_m_bset_bonus_code_desc;
	}

	
	public Integer getBSET_YEAR() {
		return BSET_YEAR;
	}

	public void setBSET_YEAR(Integer bset_year) {
		BSET_YEAR = bset_year;
	}
	

	public Double getBSET_RATE() {
		return BSET_RATE;
	}

	public void setBSET_RATE(Double bset_rate) {
		BSET_RATE = bset_rate;
	}

	public Double getBSET_RATE_PER() {
		return BSET_RATE_PER;
	}

	public void setBSET_RATE_PER(Double bset_rate_per) {
		BSET_RATE_PER = bset_rate_per;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Date getBSET_CR_DT() {
		return BSET_CR_DT;
	}

	public void setBSET_CR_DT(Date bset_cr_dt) {
		BSET_CR_DT = bset_cr_dt;
	}

	public String getBSET_CR_UID() {
		return BSET_CR_UID;
	}

	public void setBSET_CR_UID(String bset_cr_uid) {
		BSET_CR_UID = bset_cr_uid;
	}

	public Date getBSET_UPD_DT() {
		return BSET_UPD_DT;
	}

	public void setBSET_UPD_DT(Date bset_upd_dt) {
		BSET_UPD_DT = bset_upd_dt;
	}

	public String getBSET_UPD_UID() {
		return BSET_UPD_UID;
	}

	public void setBSET_UPD_UID(String bset_upd_uid) {
		BSET_UPD_UID = bset_upd_uid;
	}

	public String getBSET_BONUS_GIVEN_IN() {
		return BSET_BONUS_GIVEN_IN;
	}

	public void setBSET_BONUS_GIVEN_IN(String bset_bonus_given_in) {
		BSET_BONUS_GIVEN_IN = bset_bonus_given_in;
	}

	public String getBSET_APPLIED_ON() {
		return BSET_APPLIED_ON;
	}

	public void setBSET_APPLIED_ON(String bset_applied_on) {
		BSET_APPLIED_ON = bset_applied_on;
	}

	public String getBSET_UNIT_PUR_YN() {
		return BSET_UNIT_PUR_YN;
	}

	public void setBSET_UNIT_PUR_YN(String bset_unit_pur_yn) {
		BSET_UNIT_PUR_YN = bset_unit_pur_yn;
	}

	public String getBSET_BUY_SELL() {
		return BSET_BUY_SELL;
	}

	public void setBSET_BUY_SELL(String bset_buy_sell) {
		BSET_BUY_SELL = bset_buy_sell;
	}
	
	

}

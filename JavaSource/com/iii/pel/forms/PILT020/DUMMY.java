package com.iii.pel.forms.PILT020;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="")
public class DUMMY extends BaseValueBean {

	private Date UI_M_REINS_DATE;
    
	private String UI_PD_CUST_NAME;
	
	private String UI_PD_ADDR_01;
	
	private String UI_PD_ADDR_02;
	
	private String UI_PD_ADDR_03;
	
	private String UI_PD_REMARKS;
	
	private String UI_BASE_CURR_CODE;
	
	private int UI_M_LOAN_DURATION;
	
	private String PT_IL_POLICY_CF;
	
	private String PT_IL_LOAN_INT_COLL_CF;
	
	private String PT_IL_PREM_COLL_CF;
	
	private String UI_M_BUY_SELL;
	
	



	public Date getUI_M_REINS_DATE() {
		 return UI_M_REINS_DATE;
	}

	public void setUI_M_REINS_DATE(Date UI_M_REINS_DATE) {
		this.UI_M_REINS_DATE = UI_M_REINS_DATE;
	}

	public String getUI_PD_CUST_NAME() {
		return UI_PD_CUST_NAME;
	}

	public void setUI_PD_CUST_NAME(String ui_pd_cust_name) {
		UI_PD_CUST_NAME = ui_pd_cust_name;
	}

	public String getUI_PD_ADDR_01() {
		return UI_PD_ADDR_01;
	}

	public void setUI_PD_ADDR_01(String ui_pd_addr_01) {
		UI_PD_ADDR_01 = ui_pd_addr_01;
	}

	public String getUI_PD_ADDR_02() {
		return UI_PD_ADDR_02;
	}

	public void setUI_PD_ADDR_02(String ui_pd_addr_02) {
		UI_PD_ADDR_02 = ui_pd_addr_02;
	}

	public String getUI_PD_ADDR_03() {
		return UI_PD_ADDR_03;
	}

	public void setUI_PD_ADDR_03(String ui_pd_addr_03) {
		UI_PD_ADDR_03 = ui_pd_addr_03;
	}

	public String getUI_PD_REMARKS() {
		return UI_PD_REMARKS;
	}

	public void setUI_PD_REMARKS(String ui_pd_remarks) {
		UI_PD_REMARKS = ui_pd_remarks;
	}

	public String getUI_BASE_CURR_CODE() {
		return UI_BASE_CURR_CODE;
	}

	public void setUI_BASE_CURR_CODE(String ui_base_curr_code) {
		UI_BASE_CURR_CODE = ui_base_curr_code;
	}

	public int getUI_M_LOAN_DURATION() {
		return UI_M_LOAN_DURATION;
	}

	public void setUI_M_LOAN_DURATION(int ui_m_loan_duration) {
		UI_M_LOAN_DURATION = ui_m_loan_duration;
	}

	public String getPT_IL_POLICY_CF() {
		return PT_IL_POLICY_CF;
	}

	public void setPT_IL_POLICY_CF(String pt_il_policy_cf) {
		PT_IL_POLICY_CF = pt_il_policy_cf;
	}

	public String getPT_IL_LOAN_INT_COLL_CF() {
		return PT_IL_LOAN_INT_COLL_CF;
	}

	public void setPT_IL_LOAN_INT_COLL_CF(String pt_il_loan_int_coll_cf) {
		PT_IL_LOAN_INT_COLL_CF = pt_il_loan_int_coll_cf;
	}

	public String getPT_IL_PREM_COLL_CF() {
		return PT_IL_PREM_COLL_CF;
	}

	public void setPT_IL_PREM_COLL_CF(String pt_il_prem_coll_cf) {
		PT_IL_PREM_COLL_CF = pt_il_prem_coll_cf;
	}

	public String getUI_M_BUY_SELL() {
		return UI_M_BUY_SELL;
	}

	public void setUI_M_BUY_SELL(String ui_m_buy_sell) {
		UI_M_BUY_SELL = ui_m_buy_sell;
	}
}

package com.iii.pel.forms.PILT003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {

	private Date UI_M_REINS_DATE;

	/*  [ BugId:PREMIAGDC-AGENCY-0036 Rajesh 04-Feb-09 */
    private Double M_AVLB_AMT;

    private Double UI_M_SHORT_AMT;
    //ADDED FOR PREMIAGDC-278143 VIJAYANAND 10-08-2009
    private Integer UI_M_IL_ENDEXCHRT;
    
    private String UI_M_ADDL_STATUS_DESC;
    
    private String UI_M_IL_BROK_CALC;
    
    private String UI_M_BASE_CURR_CODE;
    
    private String  UI_M_BUY_SELL;
    //ADDED FOR PREMIAGDC-278143 VIJAYANAND 10-08-2009
    
	public Double getUI_M_SHORT_AMT() {
		return UI_M_SHORT_AMT;
	}

	public void setUI_M_SHORT_AMT(Double ui_m_short_amt) {
		UI_M_SHORT_AMT = ui_m_short_amt;
	}

	public Double getM_AVLB_AMT() {
		return M_AVLB_AMT;
	}

	public void setM_AVLB_AMT(Double m_avlb_amt) {
		M_AVLB_AMT = m_avlb_amt;
	}

	public Date getUI_M_REINS_DATE() {
		 return UI_M_REINS_DATE;
	}

	public void setUI_M_REINS_DATE(Date UI_M_REINS_DATE) {
		this.UI_M_REINS_DATE = UI_M_REINS_DATE;
	}

	public Integer getUI_M_IL_ENDEXCHRT() {
		return UI_M_IL_ENDEXCHRT;
	}

	public void setUI_M_IL_ENDEXCHRT(Integer ui_m_il_endexchrt) {
		UI_M_IL_ENDEXCHRT = ui_m_il_endexchrt;
	}

	public String getUI_M_BUY_SELL() {
		return UI_M_BUY_SELL;
	}

	public void setUI_M_BUY_SELL(String ui_m_buy_sell) {
		UI_M_BUY_SELL = ui_m_buy_sell;
	}

	public String getUI_M_ADDL_STATUS_DESC() {
		return UI_M_ADDL_STATUS_DESC;
	}

	public void setUI_M_ADDL_STATUS_DESC(String ui_m_addl_status_desc) {
		UI_M_ADDL_STATUS_DESC = ui_m_addl_status_desc;
	}

	public String getUI_M_BASE_CURR_CODE() {
		return UI_M_BASE_CURR_CODE;
	}

	public void setUI_M_BASE_CURR_CODE(String ui_m_base_curr_code) {
		UI_M_BASE_CURR_CODE = ui_m_base_curr_code;
	}

	public String getUI_M_IL_BROK_CALC() {
		return UI_M_IL_BROK_CALC;
	}

	public void setUI_M_IL_BROK_CALC(String ui_m_il_brok_calc) {
		UI_M_IL_BROK_CALC = ui_m_il_brok_calc;
	}


}

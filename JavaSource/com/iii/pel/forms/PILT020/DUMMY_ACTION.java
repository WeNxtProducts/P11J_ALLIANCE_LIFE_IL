package com.iii.pel.forms.PILT020;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION {

	private HtmlOutputLabel COMP_UI_M_REINS_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_REINS_DATE;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private DUMMY DUMMY_BEAN;
	
	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public HtmlOutputLabel getCOMP_UI_M_REINS_DATE_LABEL() {
		return COMP_UI_M_REINS_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_REINS_DATE() {
		return COMP_UI_M_REINS_DATE;
	}

	public void setCOMP_UI_M_REINS_DATE_LABEL(HtmlOutputLabel COMP_UI_M_REINS_DATE_LABEL) {
		this.COMP_UI_M_REINS_DATE_LABEL = COMP_UI_M_REINS_DATE_LABEL;
	}

	public void setCOMP_UI_M_REINS_DATE(HtmlCalendar COMP_UI_M_REINS_DATE) {
		this.COMP_UI_M_REINS_DATE = COMP_UI_M_REINS_DATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	
	
	public void pt_il_loan_populate_details() throws Exception
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
//		PT_IL_PREM_COLL premCollBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		System.out.println("method call in action class..............");
//		PT_IL_PREM_COLL premCollBean1 = new PT_IL_PREM_COLL();
		System.out.println("Changed PC_POLsysid........................"+PT_IL_PREM_COLL_BEAN.getPC_SYS_ID());
		PT_IL_INT_LOAN_DELEGATE delegateBean  = new PT_IL_INT_LOAN_DELEGATE();
		actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().setPT_IL_LOAN_INT_COLL_BEAN(delegateBean.populateDetails(PT_IL_PREM_COLL_BEAN));
		System.out.println(actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN().getUI_M_FC_BAL_LOAN_AMT());
		
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL pt_il_prem_coll_bean) {
		PT_IL_PREM_COLL_BEAN = pt_il_prem_coll_bean;
	}
}

package com.iii.pel.forms.PILP001_APAC;

import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlCalendar;


public class Main_Action {
	private Main bean;
	
	public Main getBean() {
		return bean;
	}


	public void setBean(Main bean) {
		this.bean = bean;
	}


	public Main_Action() {
		bean = new Main();
	}
	Map session =null;
	
	private HtmlInputText UI_M_PROP_NO;
	
	private HtmlCalendar COMP_UI_M_APPRV_DATE;
	
	
	public HtmlCalendar getCOMP_UI_M_APPRV_DATE() {
		return COMP_UI_M_APPRV_DATE;
	}


	public void setCOMP_UI_M_APPRV_DATE(HtmlCalendar comp_ui_m_apprv_date) {
		COMP_UI_M_APPRV_DATE = comp_ui_m_apprv_date;
	}


	public HtmlInputText getUI_M_PROP_NO() {
		return UI_M_PROP_NO;
	}


	public void setUI_M_PROP_NO(HtmlInputText ui_m_prop_no) {
		UI_M_PROP_NO = ui_m_prop_no;
	}


	public String MainJSP(){
		System.out.println("CheckMAINJSP()");
		session=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("ProposalNo",bean.getUI_M_PROP_NO());
		session.put("ApproveDate",bean.getUI_M_APPRV_DATE());
		System.out.println(getUI_M_PROP_NO());
		System.out.println(getCOMP_UI_M_APPRV_DATE());
		return "quotation";
	}
	
}

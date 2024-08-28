package com.iii.pel.forms.PILP002_APAC;

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
	
	private HtmlInputText UI_M_POL_NO;
	
	private HtmlCalendar UI_M_APPRV_DATE;
	
	private HtmlInputText UI_M_CUST_CODE;
	
	private HtmlInputText UI_M_POL_CUST_DESC;
	
	
	public String MainJSP(){
		System.out.println("CheckMAINJSP()");
		session=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("key",bean.getUI_M_POL_NO());
		session.put("key1", bean.getUI_M_APPRV_DATE());
		session.put("key2", bean.getUI_M_CUST_CODE());
		session.put("key3", bean.getUI_M_POL_CUST_DESC());
		System.out.println(getUI_M_POL_NO());
		System.out.println(getUI_M_APPRV_DATE());
		System.out.println(getUI_M_CUST_CODE());
		System.out.println(getUI_M_POL_CUST_DESC());
		//System.out.println(getUI_M_POL_NO());
		return "quotation";
	}


	public HtmlInputText getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}


	public void setUI_M_POL_NO(HtmlInputText ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}


	public HtmlCalendar getUI_M_APPRV_DATE() {
		return UI_M_APPRV_DATE;
	}


	public void setUI_M_APPRV_DATE(HtmlCalendar ui_m_apprv_date) {
		UI_M_APPRV_DATE = ui_m_apprv_date;
	}


	public HtmlInputText getUI_M_CUST_CODE() {
		return UI_M_CUST_CODE;
	}


	public void setUI_M_CUST_CODE(HtmlInputText ui_m_cust_code) {
		UI_M_CUST_CODE = ui_m_cust_code;
	}


	public HtmlInputText getUI_M_POL_CUST_DESC() {
		return UI_M_POL_CUST_DESC;
	}


	public void setUI_M_POL_CUST_DESC(HtmlInputText ui_m_pol_cust_desc) {
		UI_M_POL_CUST_DESC = ui_m_pol_cust_desc;
	}


	
	
}

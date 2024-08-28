package com.iii.pel.forms.PILP049_APAC;

import java.text.ParseException;
import java.util.Date;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="")
public class DUMMY1 extends BaseValueBean {
		
	private String UI_M_FM_FUND_CODE;
	private String UI_M_TO_FUND_CODE;
	private Date UI_M_FM_DT;
	private Date UI_M_TO_DT;
	
	public DUMMY1() {
		CommonUtils utility=new CommonUtils();
	
		try {
			UI_M_FM_DT=utility.getCurrentDate();
			UI_M_TO_DT=utility.getCurrentDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	public String getUI_M_FM_FUND_CODE() {
		return UI_M_FM_FUND_CODE;
	}


	public void setUI_M_FM_FUND_CODE(String ui_m_fm_fund_code) {
		UI_M_FM_FUND_CODE = ui_m_fm_fund_code;
	}


	public String getUI_M_TO_FUND_CODE() {
		return UI_M_TO_FUND_CODE;
	}


	public void setUI_M_TO_FUND_CODE(String ui_m_to_fund_code) {
		UI_M_TO_FUND_CODE = ui_m_to_fund_code;
	}


	public Date getUI_M_FM_DT() {
		return UI_M_FM_DT;
	}


	public void setUI_M_FM_DT(Date ui_m_fm_dt) {
		UI_M_FM_DT = ui_m_fm_dt;
	}


	public Date getUI_M_TO_DT() {
		return UI_M_TO_DT;
	}


	public void setUI_M_TO_DT(Date ui_m_to_dt) {
		UI_M_TO_DT = ui_m_to_dt;
	}
	
}
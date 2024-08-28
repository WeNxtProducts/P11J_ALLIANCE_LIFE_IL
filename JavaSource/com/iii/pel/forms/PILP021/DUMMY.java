package com.iii.pel.forms.PILP021;

import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_FM_PROD_CODE;

	private String UI_M_FM_PROD_DESC;

	private String UI_M_TO_PROD_CODE;

	private String UI_M_TO_PROD_DESC;

	private Date UI_M_FM_DT;

	private Date UI_M_TO_DT;

	private String UI_M_FM_PROP_NO;

	private String UI_M_TO_PROP_NO;

	private String POL_ASSURED_NAME;

	public DUMMY() {
		CommonUtils utility=new CommonUtils();
	
		try {
			//setting the default value to current date
			UI_M_FM_DT=utility.getCurrentDate();
			UI_M_TO_DT=utility.getCurrentDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUI_M_FM_PROD_CODE() {
		return UI_M_FM_PROD_CODE;
	}

	public void setUI_M_FM_PROD_CODE(String UI_M_FM_PROD_CODE) {
		this.UI_M_FM_PROD_CODE = UI_M_FM_PROD_CODE;
	}

	public String getUI_M_FM_PROD_DESC() {
		return UI_M_FM_PROD_DESC;
	}

	public void setUI_M_FM_PROD_DESC(String UI_M_FM_PROD_DESC) {
		this.UI_M_FM_PROD_DESC = UI_M_FM_PROD_DESC;
	}

	public String getUI_M_TO_PROD_CODE() {
		return UI_M_TO_PROD_CODE;
	}

	public void setUI_M_TO_PROD_CODE(String UI_M_TO_PROD_CODE) {
		this.UI_M_TO_PROD_CODE = UI_M_TO_PROD_CODE;
	}

	public String getUI_M_TO_PROD_DESC() {
		return UI_M_TO_PROD_DESC;
	}

	public void setUI_M_TO_PROD_DESC(String UI_M_TO_PROD_DESC) {
		this.UI_M_TO_PROD_DESC = UI_M_TO_PROD_DESC;
	}

	public Date getUI_M_FM_DT() {
		 return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date UI_M_FM_DT) {
		this.UI_M_FM_DT = UI_M_FM_DT;
	}

	public Date getUI_M_TO_DT() {
		 return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date UI_M_TO_DT) {
		this.UI_M_TO_DT = UI_M_TO_DT;
	}

	public String getUI_M_FM_PROP_NO() {
		return UI_M_FM_PROP_NO;
	}

	public void setUI_M_FM_PROP_NO(String UI_M_FM_PROP_NO) {
		this.UI_M_FM_PROP_NO = UI_M_FM_PROP_NO;
	}

	public String getUI_M_TO_PROP_NO() {
		return UI_M_TO_PROP_NO;
	}

	public void setUI_M_TO_PROP_NO(String UI_M_TO_PROP_NO) {
		this.UI_M_TO_PROP_NO = UI_M_TO_PROP_NO;
	}

	public String getPOL_ASSURED_NAME() {
		return POL_ASSURED_NAME;
	}

	public void setPOL_ASSURED_NAME(String pol_assured_name) {
		POL_ASSURED_NAME = pol_assured_name;
	}
}

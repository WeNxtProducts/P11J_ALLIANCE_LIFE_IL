package com.iii.pel.forms.PILP024;

import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_POLICY_FM;

	private String UI_M_POLICY_TO;

	private String UI_M_DIVN_FM;

	private String UI_M_DIVN_TO;

	private String UI_M_DEPT_FM;

	private String UI_M_DEPT_TO;

	private Date UI_M_FM_DT;

	private Date UI_M_TO_DT;

	private Date UI_M_PROCESS_DT;

	public DUMMY(){
		CommonUtils utils=new CommonUtils();
		Connection con=null;
		try {
			
			UI_M_FM_DT=utils.getCurrentDate();
			UI_M_TO_DT=utils.getCurrentDate();
			UI_M_PROCESS_DT=utils.getCurrentDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getUI_M_POLICY_FM() {
		return UI_M_POLICY_FM;
	}

	public void setUI_M_POLICY_FM(String UI_M_POLICY_FM) {
		this.UI_M_POLICY_FM = UI_M_POLICY_FM;
	}

	public String getUI_M_POLICY_TO() {
		return UI_M_POLICY_TO;
	}

	public void setUI_M_POLICY_TO(String UI_M_POLICY_TO) {
		this.UI_M_POLICY_TO = UI_M_POLICY_TO;
	}

	public String getUI_M_DIVN_FM() {
		return UI_M_DIVN_FM;
	}

	public void setUI_M_DIVN_FM(String UI_M_DIVN_FM) {
		this.UI_M_DIVN_FM = UI_M_DIVN_FM;
	}

	public String getUI_M_DIVN_TO() {
		return UI_M_DIVN_TO;
	}

	public void setUI_M_DIVN_TO(String UI_M_DIVN_TO) {
		this.UI_M_DIVN_TO = UI_M_DIVN_TO;
	}

	public String getUI_M_DEPT_FM() {
		return UI_M_DEPT_FM;
	}

	public void setUI_M_DEPT_FM(String UI_M_DEPT_FM) {
		this.UI_M_DEPT_FM = UI_M_DEPT_FM;
	}

	public String getUI_M_DEPT_TO() {
		return UI_M_DEPT_TO;
	}

	public void setUI_M_DEPT_TO(String UI_M_DEPT_TO) {
		this.UI_M_DEPT_TO = UI_M_DEPT_TO;
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

	public Date getUI_M_PROCESS_DT() {
		 return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date UI_M_PROCESS_DT) {
		this.UI_M_PROCESS_DT = UI_M_PROCESS_DT;
	}
}

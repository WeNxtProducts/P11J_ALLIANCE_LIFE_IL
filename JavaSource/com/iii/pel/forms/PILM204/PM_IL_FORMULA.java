package com.iii.pel.forms.PILM204;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PM_IL_FORMULA")
public class PM_IL_FORMULA extends BaseValueBean {

	@Column(name="FRM_CODE")
	private String FRM_CODE;

	@Column(name="FRM_DESC")
	private String FRM_DESC;

	@Column(name="FRM_FORMULA")
	private String FRM_FORMULA;
	
	@Column(name="FRM_UPD_DT")
	private Date FRM_UPD_DT;
	
	private Integer UI_FRM_CONS;
	
	private String UI_LIST_PARAM;
	private String UI_LIST_OPERATOR;
	

	public String getUI_LIST_OPERATOR() {
		return UI_LIST_OPERATOR;
	}

	public void setUI_LIST_OPERATOR(String ui_list_operator) {
		UI_LIST_OPERATOR = ui_list_operator;
	}

	public String getUI_LIST_PARAM() {
		return UI_LIST_PARAM;
	}

	public void setUI_LIST_PARAM(String ui_list_param) {
		UI_LIST_PARAM = ui_list_param;
	}

	public Integer getUI_FRM_CONS() {
		return UI_FRM_CONS;
	}

	public void setUI_FRM_CONS(Integer ui_frm_cons) {
		UI_FRM_CONS = ui_frm_cons;
	}

	public Date getFRM_UPD_DT() {
		return FRM_UPD_DT;
	}

	public void setFRM_UPD_DT(Date frm_upd_dt) {
		FRM_UPD_DT = frm_upd_dt;
	}

	public String getFRM_CODE() {
		return FRM_CODE;
	}

	public void setFRM_CODE(String FRM_CODE) {
		this.FRM_CODE = FRM_CODE;
	}

	public String getFRM_DESC() {
		return FRM_DESC;
	}

	public void setFRM_DESC(String FRM_DESC) {
		this.FRM_DESC = FRM_DESC;
	}

	public String getFRM_FORMULA() {
		return FRM_FORMULA;
	}

	public void setFRM_FORMULA(String FRM_FORMULA) {
		this.FRM_FORMULA = FRM_FORMULA;
	}
	
	@Column(name="FRM_UPD_UID")
	private String FRM_UPD_UID;


	public String getFRM_UPD_UID() {
		return FRM_UPD_UID;
	}

	public void setFRM_UPD_UID(String fRM_UPD_UID) {
		FRM_UPD_UID = fRM_UPD_UID;
	}
	//ADDED BY KRITHIKA  for call id FALCONQC-1716554
		private String FRM_HIDE;
		private String FRM_HIDE_TO;


		public String getFRM_HIDE() {
			return FRM_HIDE;
		}

		public void setFRM_HIDE(String fRM_HIDE) {
			FRM_HIDE = fRM_HIDE;
		}

		public String getFRM_HIDE_TO() {
			return FRM_HIDE_TO;
		}

		public void setFRM_HIDE_TO(String fRM_HIDE_TO) {
			FRM_HIDE_TO = fRM_HIDE_TO;
		}
	//END
}
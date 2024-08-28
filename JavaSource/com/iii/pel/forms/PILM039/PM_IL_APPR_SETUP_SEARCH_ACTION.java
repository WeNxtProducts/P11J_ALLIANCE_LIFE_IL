package com.iii.pel.forms.PILM039;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;

import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPR_SETUP_SEARCH_ACTION extends CommonAction {
	private HtmlDataTable dataTable;
	private ArrayList<PM_IL_APPR_SETUP> listValue;

	private String initPolCustCode;
	private int initPolPeriod;

	private String initUserId;
	private String initFromCode;
	private String initToCode;
	private String initUserdesc;
	private String initUserGroup;

	private CTRL_1_ACTION CTRL_1_ACTION_BEAN;

	public PM_IL_APPR_SETUP_SEARCH_ACTION() {
		CTRL_1_ACTION_BEAN = new CTRL_1_ACTION();
	}

	public String fetchSearchDetails() {
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		listValue = deligate.fetchSearchDetails(this);
		if (listValue.size() == 0) {
			getWarningMap()
					.put(
							"current",
							Messages
									.getString("messageProperties_PILM039",
											"PILM039$PILM039_PM_IL_END_APPR_SETUP_SEARCH$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
		return null;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_APPR_SETUP> getListValue() {
		return listValue;
	}

	public void setListValue(ArrayList<PM_IL_APPR_SETUP> listValue) {
		this.listValue = listValue;
	}

	public String getInitPolCustCode() {
		return initPolCustCode;
	}

	public void setInitPolCustCode(String initPolCustCode) {
		this.initPolCustCode = initPolCustCode;
	}

	public int getInitPolPeriod() {
		return initPolPeriod;
	}

	public void setInitPolPeriod(int initPolPeriod) {
		this.initPolPeriod = initPolPeriod;
	}

	public String getInitUserId() {
		return initUserId;
	}

	public void setInitUserId(String initUserId) {
		this.initUserId = initUserId;
	}

	public String getInitFromCode() {
		return initFromCode;
	}

	public void setInitFromCode(String initFromCode) {
		this.initFromCode = initFromCode;
	}

	public String getInitToCode() {
		return initToCode;
	}

	public void setInitToCode(String initToCode) {
		this.initToCode = initToCode;
	}

	public String clearList() {
		String returnStr = "headerMainPage";
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		String rowId = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN()
				.getPM_IL_APPR_SETUP_BEAN().getROWID();
		System.out.println(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN()
				.getPM_IL_APPR_SETUP_BEAN().getROWID());

		compositeAction
				.setPM_IL_APPR_SETUP_ACTION_BEAN(new PM_IL_APPR_SETUP_ACTION());
		// compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().setPM_IL_APPR_SETUP_BEAN(delegate.fetchUpprovalDetailValues(rowId));
		compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().setNonUpdatable(true);

		this.listValue = null;

		return returnStr;
	}

	public String getInitUserdesc() {
		return initUserdesc;
	}

	public void setInitUserdesc(String initUserdesc) {
		this.initUserdesc = initUserdesc;
	}

	public String getInitUserGroup() {
		return initUserGroup;
	}

	public void setInitUserGroup(String initUserGroup) {
		this.initUserGroup = initUserGroup;
	}

	public String newRecordAction() {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		compositeAction.resetAllValues();
		compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN()
				.setNonUpdatable(false);
		return "newRecord";
	}

	public CTRL_1_ACTION getCTRL_1_ACTION_BEAN() {
		return CTRL_1_ACTION_BEAN;
	}

	public void setCTRL_1_ACTION_BEAN(CTRL_1_ACTION ctrl_1_action_bean) {
		CTRL_1_ACTION_BEAN = ctrl_1_action_bean;
	}
	
	public String updateButtonAction(String rowId) {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction= new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_APPR_SETUP_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().setROWID(rowId);
	
		outcome = "headerMainPage";
		return outcome;
    }

    public String insertButtonAction() {
    	PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction= new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PM_IL_APPR_SETUP_COMPOSITE_ACTION",
				compositeAction);
		outcome = "headerMainPage";

		return outcome;
	
    }
}

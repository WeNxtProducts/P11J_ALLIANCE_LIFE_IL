package com.iii.pel.forms.PILM037;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_ACTION;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class SearchAction {
	private String planCode;
	private HtmlInputText COMP_UI_M_BSET_PLAN_CODE;
	private UIData dataTable;

	private ArrayList<PM_IL_BONUS_SETUP> planCodeList = new ArrayList<PM_IL_BONUS_SETUP>();
	private ArrayList<PM_IL_BONUS_SETUP> tableList = new ArrayList<PM_IL_BONUS_SETUP>();
	private PM_IL_BONUS_SETUP valueBean;
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public ArrayList<PM_IL_BONUS_SETUP> getPlanCodeList() {
		return planCodeList;
	}

	public void setPlanCodeList(ArrayList<PM_IL_BONUS_SETUP> planCodeList) {
		this.planCodeList = planCodeList;
	}

	public PM_IL_BONUS_SETUP getValueBean() {
		return valueBean;
	}

	public void setValueBean(PM_IL_BONUS_SETUP valueBean) {
		this.valueBean = valueBean;
	}

	public HtmlInputText getCOMP_UI_M_BSET_PLAN_CODE() {
		return COMP_UI_M_BSET_PLAN_CODE;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE(
			HtmlInputText comp_ui_m_bset_plan_code) {
		COMP_UI_M_BSET_PLAN_CODE = comp_ui_m_bset_plan_code;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public String clearList() {
		CommonUtils commonUtils = new CommonUtils();
		FacesContext context = FacesContext.getCurrentInstance();
		
		PM_IL_BONUS_SETUP_ACTION actionBean = null; 
		HtmlInputText pCode = null;
		HtmlInputText pCodeDescription = null;
		
		
		
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		PILM037_COMPOSITE_ACTION compositeBean = (PILM037_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PILM037_COMPOSITE_ACTION");

		String planCode = req.getParameter("plCode");
		String description = req.getParameter("plCodeDesc");
		String outCome = "success";
		return fetchBonusRecord(outCome,planCode, description, compositeBean,false);
	}

	public String fetchBonusRecord(String outCome,String planCode,String description,PILM037_COMPOSITE_ACTION compositeAction,boolean isCheck){
		String returnStr = "bonusSetUp";
		PM_IL_BONUS_SETUP_ACTION actionBean = null; 
		HtmlInputText pCode = null;
		HtmlInputText pCodeDescription = null;
		DelegateDb dbHelper = new DelegateDb();
		actionBean = compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN();
		
		tableList = dbHelper.dataBaseCallForTableValues(planCode);
		if(tableList.isEmpty()){
			PM_IL_BONUS_SETUP pm_il_bonus_setup = new PM_IL_BONUS_SETUP();
			actionBean.setPM_IL_BONUS_SETUP_BEAN(pm_il_bonus_setup);
			//Set the Value Bean
			HtmlInputText bCode = new HtmlInputText();
			HtmlInputText bCodeDesc = new HtmlInputText();
			HtmlInputText year = new HtmlInputText();
			HtmlInputText rate = new HtmlInputText();
			HtmlInputText ratePer = new HtmlInputText();
			bCode.setSubmittedValue("");
			bCodeDesc.setSubmittedValue("");
			year.setSubmittedValue("");
			rate.setSubmittedValue("");
			ratePer.setSubmittedValue("");

			actionBean.setCOMP_BSET_BONUS_CODE(bCode);
			actionBean.setCOMP_BSET_YEAR(year);
			actionBean.setCOMP_BSET_RATE_PER(ratePer);
			actionBean.setCOMP_BSET_RATE(rate);
			actionBean.setCOMP_UI_M_BSET_BONUS_CODE_DESC(bCodeDesc);
		}
		
		actionBean.getPM_IL_BONUS_SETUP_BEAN().setBSET_PLAN_CODE(planCode);
		actionBean.getPM_IL_BONUS_SETUP_BEAN().setUI_M_PLAN_CODE_DESC(description);
		
		pCode = new HtmlInputText();
		pCodeDescription = new HtmlInputText();
		pCode.setSubmittedValue(planCode);
		pCodeDescription.setSubmittedValue(description);
		actionBean.setCOMP_BSET_PLAN_CODE(pCode);
		actionBean.setCOMP_UI_M_PLAN_CODE_DESC(pCodeDescription);
		
		actionBean.setTableList(tableList);
		
		
		for(int i =0 ;i<actionBean.getTableList().size();i++){
			PM_IL_BONUS_SETUP pm_il_bonus_setup = (PM_IL_BONUS_SETUP)actionBean.getTableList().get(i);
			if(i==0){
				pm_il_bonus_setup.setRowSelected(true);
				
				HtmlInputText bCode = new HtmlInputText();
				HtmlInputText bCodeDesc = new HtmlInputText();
				HtmlInputText year = new HtmlInputText();
				HtmlInputText rate = new HtmlInputText();
				HtmlInputText ratePer = new HtmlInputText();
				
				bCode.setSubmittedValue(pm_il_bonus_setup.getBSET_BONUS_CODE());
				bCodeDesc.setSubmittedValue(pm_il_bonus_setup.getUI_M_BSET_BONUS_CODE_DESC());

				year.setSubmittedValue(String.valueOf(pm_il_bonus_setup.getBSET_YEAR()));
				rate.setSubmittedValue(String.valueOf(pm_il_bonus_setup.getBSET_RATE()));
				ratePer.setSubmittedValue(String.valueOf(pm_il_bonus_setup.getBSET_RATE_PER()));

				actionBean.setCOMP_BSET_BONUS_CODE(bCode);
				actionBean.setCOMP_BSET_YEAR(year);
				actionBean.setCOMP_BSET_RATE_PER(ratePer);
				actionBean.setCOMP_BSET_RATE(rate);
				actionBean.setCOMP_UI_M_BSET_BONUS_CODE_DESC(bCodeDesc);
				
				actionBean.setPM_IL_BONUS_SETUP_BEAN(pm_il_bonus_setup);
			}else{
				pm_il_bonus_setup.setRowSelected(false);
			}
		}
		
		//actionBean.resetAllComponent();
		
		//actionBean.setOutCome(outCome);
		if(isCheck == false){
			actionBean.setBackCheck(true);	
			actionBean.setMainCheck(false);
		}else{
			actionBean.setBackCheck(false);	
			actionBean.setMainCheck(true);
		}
		return returnStr;
	}
	
	/*PM_IL_DOC_NO_RANGE PM_IL_DOC_NO_RANGE_BEAN = null;
						Iterator<PM_IL_DOC_NO_RANGE> iterator = getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList().iterator();
						while(iterator.hasNext()){
							PM_IL_DOC_NO_RANGE_BEAN = iterator.next();
							PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(false);
						}
						
						//this.setInterestDetailList(interestList);
						if (getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList().size() !=0){					
							PM_IL_DOC_NO_RANGE_BEAN =(PM_IL_DOC_NO_RANGE)getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList().get(0);
							getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setPM_IL_DOC_NO_RANGE_BEAN(PM_IL_DOC_NO_RANGE_BEAN);
							PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
						}*/
	/**
	 * Method to fetch the plan code list
	 * @return
	 */
	public String fetchPlanCodeDetails() {
		String typedString = getPlanCode();
		DelegateDb dbHelper = new DelegateDb();
		planCodeList = dbHelper.populatePlanCodeLov(typedString);

		return null;
	}

	/*
	 * Delete record from searchPage
	 */
	
	public void DeleteRow(ActionEvent ae) throws Exception
	{
		System.out.println("SearchPage.DeleteRow()");
		Connection connection = null;
		ConnectionAgent connectionAgent = null;
		connectionAgent = new ConnectionAgent();
		CRUDHandler handler = new CRUDHandler();
		
		PM_IL_BONUS_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		connection = connectionAgent.getConnection();
//		DelegateDb dbHelper = new DelegateDb();
//		tableList = dbHelper.dataBaseCallForTableValues(planCode);
		System.out.println("************************");
		System.out.println(planCodeList.size()); 
		System.out.println("************************");
		if(tableList != null){
			System.out.println("list_size :"+ planCodeList.size());
			for(int index =0 ;index<planCodeList.size();){
				System.out.println("inside for loop.....");
				valuebean = planCodeList.get(index);
				System.out.println("VALUE: "+ valuebean);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isSelected());
				if(valuebean.isSelected()){
					planCodeList.remove(valuebean);
					int n = handler.executeDelete(valuebean, connection);
					System.out.println("Connection :" +connection.isClosed());
					System.out.println("PILM037_pm_il_bonus_setup.deleteRow()-n"+n);
					connection.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}
	
	
	 public String updateButtonAction(String rowId) {
	     PILM037_COMPOSITE_ACTION  pilm037_composite_action = new PILM037_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
		CommonUtils.setGlobalObject("PILM037_COMPOSITE_ACTION", pilm037_composite_action);
		pilm037_composite_action.getPM_IL_BONUS_SETUP_ACTION_BEAN().getPM_IL_PLAN_BEAN().setROWID(rowId);
		outcome = "bonusSetUp";
		return outcome;
}
	
	

 public String insertButtonAction() {
     PILM037_COMPOSITE_ACTION  pilm037_composite_action = new PILM037_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM037_COMPOSITE_ACTION",pilm037_composite_action);
		outcome = "bonusSetUp";
		return outcome;
 }

}

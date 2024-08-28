package com.iii.pel.forms.PILP060_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PT_IL_BONUS_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_BON_SR_NO_LABEL;

	private HtmlInputText COMP_UI_M_BON_SR_NO;

	private HtmlOutputLabel COMP_BON_YEAR_LABEL;

	private HtmlInputText COMP_BON_YEAR;

	private HtmlOutputLabel COMP_UI_M_BON_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_BON_POL_NO;

	private HtmlOutputLabel COMP_BON_FC_BONUS_AMT_LABEL;

	private HtmlInputText COMP_BON_FC_BONUS_AMT;

	private HtmlOutputLabel COMP_BON_LC_BONUS_AMT_LABEL;

	private HtmlInputText COMP_BON_LC_BONUS_AMT;

	private HtmlOutputLabel COMP_BON_PAID_YN_LABEL;

	private HtmlSelectOneMenu COMP_BON_PAID_YN;

	private HtmlOutputLabel COMP_BON_PAY_TO_LABEL;

	private HtmlSelectOneMenu COMP_BON_PAY_TO;

	private PT_IL_BONUS PT_IL_BONUS_BEAN;
	
	private List <SelectItem> BON_PAID_YN_ITEMS;
	private List <SelectItem> BON_PAY_TO_ITEMS; 
	private List<PT_IL_BONUS> dataTableList;
	private UIDataTable dataTableComponent;
	private String WHERE;
	
	private int recordsPerPage=5;
	private int currentPage;

	public PT_IL_BONUS_ACTION() {
		PT_IL_BONUS_BEAN = new PT_IL_BONUS();
		PT_IL_BONUS_DELEGATE delegate=new PT_IL_BONUS_DELEGATE();
		dataTableList = new ArrayList<PT_IL_BONUS>();
	//	this.BON_PAY_TO_ITEMS=delegate.getSelectItems("PT_IL_BONUS.BON_PAY_TO", comboFieldId);
		this.BON_PAID_YN_ITEMS=delegate.getSelectItems("PT_IL_BONUS.BON_PAID_YN", "PROCYN");
		currentPage=1;
	}
	
	public String getWHERE() {
		return WHERE;
	}

	public void setWHERE(String where) {
		WHERE = where;
	}
	
	public HtmlOutputLabel getCOMP_UI_M_BON_SR_NO_LABEL() {
		return COMP_UI_M_BON_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_SR_NO() {
		return COMP_UI_M_BON_SR_NO;
	}

	public void setCOMP_UI_M_BON_SR_NO_LABEL(HtmlOutputLabel COMP_UI_M_BON_SR_NO_LABEL) {
		this.COMP_UI_M_BON_SR_NO_LABEL = COMP_UI_M_BON_SR_NO_LABEL;
	}

	public void setCOMP_UI_M_BON_SR_NO(HtmlInputText COMP_UI_M_BON_SR_NO) {
		this.COMP_UI_M_BON_SR_NO = COMP_UI_M_BON_SR_NO;
	}

	public HtmlOutputLabel getCOMP_BON_YEAR_LABEL() {
		return COMP_BON_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_BON_YEAR() {
		return COMP_BON_YEAR;
	}

	public void setCOMP_BON_YEAR_LABEL(HtmlOutputLabel COMP_BON_YEAR_LABEL) {
		this.COMP_BON_YEAR_LABEL = COMP_BON_YEAR_LABEL;
	}

	public void setCOMP_BON_YEAR(HtmlInputText COMP_BON_YEAR) {
		this.COMP_BON_YEAR = COMP_BON_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_BON_POL_NO_LABEL() {
		return COMP_UI_M_BON_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_POL_NO() {
		return COMP_UI_M_BON_POL_NO;
	}

	public void setCOMP_UI_M_BON_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_BON_POL_NO_LABEL) {
		this.COMP_UI_M_BON_POL_NO_LABEL = COMP_UI_M_BON_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_BON_POL_NO(HtmlInputText COMP_UI_M_BON_POL_NO) {
		this.COMP_UI_M_BON_POL_NO = COMP_UI_M_BON_POL_NO;
	}

	public HtmlOutputLabel getCOMP_BON_FC_BONUS_AMT_LABEL() {
		return COMP_BON_FC_BONUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BON_FC_BONUS_AMT() {
		return COMP_BON_FC_BONUS_AMT;
	}

	public void setCOMP_BON_FC_BONUS_AMT_LABEL(HtmlOutputLabel COMP_BON_FC_BONUS_AMT_LABEL) {
		this.COMP_BON_FC_BONUS_AMT_LABEL = COMP_BON_FC_BONUS_AMT_LABEL;
	}

	public void setCOMP_BON_FC_BONUS_AMT(HtmlInputText COMP_BON_FC_BONUS_AMT) {
		this.COMP_BON_FC_BONUS_AMT = COMP_BON_FC_BONUS_AMT;
	}

	public HtmlOutputLabel getCOMP_BON_LC_BONUS_AMT_LABEL() {
		return COMP_BON_LC_BONUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BON_LC_BONUS_AMT() {
		return COMP_BON_LC_BONUS_AMT;
	}

	public void setCOMP_BON_LC_BONUS_AMT_LABEL(HtmlOutputLabel COMP_BON_LC_BONUS_AMT_LABEL) {
		this.COMP_BON_LC_BONUS_AMT_LABEL = COMP_BON_LC_BONUS_AMT_LABEL;
	}

	public void setCOMP_BON_LC_BONUS_AMT(HtmlInputText COMP_BON_LC_BONUS_AMT) {
		this.COMP_BON_LC_BONUS_AMT = COMP_BON_LC_BONUS_AMT;
	}

	public HtmlOutputLabel getCOMP_BON_PAID_YN_LABEL() {
		return COMP_BON_PAID_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BON_PAID_YN() {
		return COMP_BON_PAID_YN;
	}

	public void setCOMP_BON_PAID_YN_LABEL(HtmlOutputLabel COMP_BON_PAID_YN_LABEL) {
		this.COMP_BON_PAID_YN_LABEL = COMP_BON_PAID_YN_LABEL;
	}

	public void setCOMP_BON_PAID_YN(HtmlSelectOneMenu COMP_BON_PAID_YN) {
		this.COMP_BON_PAID_YN = COMP_BON_PAID_YN;
	}

	public HtmlOutputLabel getCOMP_BON_PAY_TO_LABEL() {
		return COMP_BON_PAY_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BON_PAY_TO() {
		return COMP_BON_PAY_TO;
	}

	public void setCOMP_BON_PAY_TO_LABEL(HtmlOutputLabel COMP_BON_PAY_TO_LABEL) {
		this.COMP_BON_PAY_TO_LABEL = COMP_BON_PAY_TO_LABEL;
	}

	public void setCOMP_BON_PAY_TO(HtmlSelectOneMenu COMP_BON_PAY_TO) {
		this.COMP_BON_PAY_TO = COMP_BON_PAY_TO;
	}

	public PT_IL_BONUS getPT_IL_BONUS_BEAN() {
		return PT_IL_BONUS_BEAN;
	}

	public void setPT_IL_BONUS_BEAN(PT_IL_BONUS PT_IL_BONUS_BEAN) {
		this.PT_IL_BONUS_BEAN = PT_IL_BONUS_BEAN;
	}

	public List<SelectItem> getBON_PAID_YN_ITEMS() {
		return BON_PAID_YN_ITEMS;
	}

	public void setBON_PAID_YN_ITEMS(List<SelectItem> bon_paid_yn_items) {
		BON_PAID_YN_ITEMS = bon_paid_yn_items;
	}

	public List<SelectItem> getBON_PAY_TO_ITEMS() {
		return BON_PAY_TO_ITEMS;
	}

	public void setBON_PAY_TO_ITEMS(List<SelectItem> bon_pay_to_items) {
		BON_PAY_TO_ITEMS = bon_pay_to_items;
	}

	public List<PT_IL_BONUS> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PT_IL_BONUS> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIDataTable getDataTableComponent() {
		return dataTableComponent;
	}

	public void setDataTableComponent(UIDataTable dataTableComponent) {
		this.dataTableComponent = dataTableComponent;
	}
	

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void selectItemValueChangeListener(ActionEvent event){
		String value=(String)this.COMP_BON_PAID_YN.getSubmittedValue();
		int currentIndex=this.dataTableComponent.getRowIndex();
		((PT_IL_BONUS)dataTableList.get(currentIndex)).setBON_PAY_TO(value);
	}
	
	public void updateRecordsPT_IL_BONUS(){
		System.out.println("PT_IL_BONUS_ACTION.updateRecordsPT_IL_BONUS()");
		int iCount=0;
		PT_IL_BONUS_DELEGATE delegate=new PT_IL_BONUS_DELEGATE();
		while(iCount <  dataTableList.size()){
			try {
				PT_IL_BONUS bean=((PT_IL_BONUS)dataTableList.get(iCount));
				delegate.updateRecord(bean, false);
				//				if("P".equals(bean.getBON_PAID_YN())){
//					delegate.updateRecord(bean, false);
//					System.out
//							.println("PT_IL_BONUS_ACTION.updateRecordsPT_IL_BONUS----[updating row] "+iCount);
//				}
				iCount++;
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().clear();
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("key", e.getMessage());
			}
		}
	}
	/******************Triggers Start*********************/
	public void whenNewBlockInstancePT_IL_BONUS(DUMMY bean){
		PT_IL_BONUS_HELPER helper=new PT_IL_BONUS_HELPER();
		helper.preQuery();
		this.dataTableList=helper.fetchBlockDataPT_IL_BONUS(bean);
		helper.postQuery(dataTableList);
		
	}


	public void setAllBON_PAID_YN() {
		if(dataTableList != null && dataTableList.size() > 0){
			int iCount=0;
			while(iCount < dataTableList.size()){
				((PT_IL_BONUS)dataTableList.get(iCount)).setBON_PAID_YN("P");
				iCount++;
			}
		}
		
	}
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated: 18-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTableComponent.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				//lastColomnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: S.Mallika, Dated: 18-Feb-2009 ]
}

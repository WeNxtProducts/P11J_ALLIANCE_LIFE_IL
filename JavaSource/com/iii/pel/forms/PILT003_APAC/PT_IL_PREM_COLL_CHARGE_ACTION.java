package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCC_CHARGE_CODE_LABEL;

	private HtmlInputText COMP_PCC_CHARGE_CODE;

	private HtmlOutputLabel COMP_PCC_FC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_FC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PCC_FC_INS_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_FC_INS_CHARGE_AMT;

	private HtmlOutputLabel COMP_PCC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_PCC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_PCC_APPLY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_PCC_APPLY_PERIOD;

	private HtmlOutputLabel COMP_PCC_LC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_LC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PCC_LC_INS_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_LC_INS_CHARGE_AMT;

	private HtmlOutputLabel COMP_UI_M_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_CHG_MAIN;

	private PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_CHARGE_HELPER helper;

	private List<PT_IL_PREM_COLL_CHARGE> dataList_PT_IL_PREM_COLL_CHARGE = new ArrayList<PT_IL_PREM_COLL_CHARGE>();

	 private UIData dataTable;

	private List<SelectItem> listPCC_APPLY_PERIOD = new ArrayList<SelectItem>();
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
		    resetSelectedRow();
		    PT_IL_PREM_COLL_CHARGE_BEAN = (PT_IL_PREM_COLL_CHARGE) dataTable.getRowData();
		    PT_IL_PREM_COLL_CHARGE_BEAN.setRowSelected(true);
		    resetAllComponent();
		} catch (Exception exc) {
		    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
		    getErrorMap().put("displayRecords", exc.getMessage());
		}

	    }


	public PT_IL_PREM_COLL_CHARGE_ACTION(){
	
	
	PT_IL_PREM_COLL_CHARGE_BEAN = new PT_IL_PREM_COLL_CHARGE();
	helper = new PT_IL_PREM_COLL_CHARGE_HELPER();
	}

	public HtmlOutputLabel getCOMP_PCC_CHARGE_CODE_LABEL() {
		return COMP_PCC_CHARGE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCC_CHARGE_CODE() {
		return COMP_PCC_CHARGE_CODE;
	}

	public void setCOMP_PCC_CHARGE_CODE_LABEL(HtmlOutputLabel COMP_PCC_CHARGE_CODE_LABEL) {
		this.COMP_PCC_CHARGE_CODE_LABEL = COMP_PCC_CHARGE_CODE_LABEL;
	}

	public void setCOMP_PCC_CHARGE_CODE(HtmlInputText COMP_PCC_CHARGE_CODE) {
		this.COMP_PCC_CHARGE_CODE = COMP_PCC_CHARGE_CODE;
	}

	public HtmlOutputLabel getCOMP_PCC_FC_CHARGE_AMT_LABEL() {
		return COMP_PCC_FC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_FC_CHARGE_AMT() {
		return COMP_PCC_FC_CHARGE_AMT;
	}

	public void setCOMP_PCC_FC_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_FC_CHARGE_AMT_LABEL) {
		this.COMP_PCC_FC_CHARGE_AMT_LABEL = COMP_PCC_FC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_FC_CHARGE_AMT(HtmlInputText COMP_PCC_FC_CHARGE_AMT) {
		this.COMP_PCC_FC_CHARGE_AMT = COMP_PCC_FC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCC_FC_INS_CHARGE_AMT_LABEL() {
		return COMP_PCC_FC_INS_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_FC_INS_CHARGE_AMT() {
		return COMP_PCC_FC_INS_CHARGE_AMT;
	}

	public void setCOMP_PCC_FC_INS_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_FC_INS_CHARGE_AMT_LABEL) {
		this.COMP_PCC_FC_INS_CHARGE_AMT_LABEL = COMP_PCC_FC_INS_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_FC_INS_CHARGE_AMT(HtmlInputText COMP_PCC_FC_INS_CHARGE_AMT) {
		this.COMP_PCC_FC_INS_CHARGE_AMT = COMP_PCC_FC_INS_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCC_CUST_SHARE_PERC_LABEL() {
		return COMP_PCC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PCC_CUST_SHARE_PERC() {
		return COMP_PCC_CUST_SHARE_PERC;
	}

	public void setCOMP_PCC_CUST_SHARE_PERC_LABEL(HtmlOutputLabel COMP_PCC_CUST_SHARE_PERC_LABEL) {
		this.COMP_PCC_CUST_SHARE_PERC_LABEL = COMP_PCC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_PCC_CUST_SHARE_PERC(HtmlInputText COMP_PCC_CUST_SHARE_PERC) {
		this.COMP_PCC_CUST_SHARE_PERC = COMP_PCC_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_PCC_APPLY_PERIOD_LABEL() {
		return COMP_PCC_APPLY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PCC_APPLY_PERIOD() {
		return COMP_PCC_APPLY_PERIOD;
	}

	public void setCOMP_PCC_APPLY_PERIOD_LABEL(HtmlOutputLabel COMP_PCC_APPLY_PERIOD_LABEL) {
		this.COMP_PCC_APPLY_PERIOD_LABEL = COMP_PCC_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_PCC_APPLY_PERIOD(HtmlSelectOneMenu COMP_PCC_APPLY_PERIOD) {
		this.COMP_PCC_APPLY_PERIOD = COMP_PCC_APPLY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PCC_LC_CHARGE_AMT_LABEL() {
		return COMP_PCC_LC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_LC_CHARGE_AMT() {
		return COMP_PCC_LC_CHARGE_AMT;
	}

	public void setCOMP_PCC_LC_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_LC_CHARGE_AMT_LABEL) {
		this.COMP_PCC_LC_CHARGE_AMT_LABEL = COMP_PCC_LC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_LC_CHARGE_AMT(HtmlInputText COMP_PCC_LC_CHARGE_AMT) {
		this.COMP_PCC_LC_CHARGE_AMT = COMP_PCC_LC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCC_LC_INS_CHARGE_AMT_LABEL() {
		return COMP_PCC_LC_INS_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_LC_INS_CHARGE_AMT() {
		return COMP_PCC_LC_INS_CHARGE_AMT;
	}

	public void setCOMP_PCC_LC_INS_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_LC_INS_CHARGE_AMT_LABEL) {
		this.COMP_PCC_LC_INS_CHARGE_AMT_LABEL = COMP_PCC_LC_INS_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_LC_INS_CHARGE_AMT(HtmlInputText COMP_PCC_LC_INS_CHARGE_AMT) {
		this.COMP_PCC_LC_INS_CHARGE_AMT = COMP_PCC_LC_INS_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHARGE_DESC_LABEL() {
		return COMP_UI_M_CHARGE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CHARGE_DESC() {
		return COMP_UI_M_CHARGE_DESC;
	}

	public void setCOMP_UI_M_CHARGE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CHARGE_DESC_LABEL) {
		this.COMP_UI_M_CHARGE_DESC_LABEL = COMP_UI_M_CHARGE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CHARGE_DESC(HtmlInputText COMP_UI_M_CHARGE_DESC) {
		this.COMP_UI_M_CHARGE_DESC = COMP_UI_M_CHARGE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHG_MAIN() {
		return COMP_UI_M_BUT_CHG_MAIN;
	}

	public void setCOMP_UI_M_BUT_CHG_MAIN(HtmlCommandButton COMP_UI_M_BUT_CHG_MAIN) {
		this.COMP_UI_M_BUT_CHG_MAIN = COMP_UI_M_BUT_CHG_MAIN;
	}

	public PT_IL_PREM_COLL_CHARGE getPT_IL_PREM_COLL_CHARGE_BEAN() {
		return PT_IL_PREM_COLL_CHARGE_BEAN;
	}

	public void setPT_IL_PREM_COLL_CHARGE_BEAN(PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN) {
		this.PT_IL_PREM_COLL_CHARGE_BEAN = PT_IL_PREM_COLL_CHARGE_BEAN;
	}

	public List<PT_IL_PREM_COLL_CHARGE> getDataList_PT_IL_PREM_COLL_CHARGE() {
		return dataList_PT_IL_PREM_COLL_CHARGE;
	}

	public void setDataListPT_IL_PREM_COLL_CHARGE(List<PT_IL_PREM_COLL_CHARGE> dataList_PT_IL_PREM_COLL_CHARGE) {
		this.dataList_PT_IL_PREM_COLL_CHARGE = dataList_PT_IL_PREM_COLL_CHARGE;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PREM_COLL_CHARGE_BEAN = new PT_IL_PREM_COLL_CHARGE();
				 resetAllComponent();
				 resetSelectedRow();
				 PT_IL_PREM_COLL_CHARGE_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}
	
	public void deleteRow(ActionEvent event){
		try{
			if (isDELETE_ALLOWED()){

				new CRUDHandler().executeDelete(PT_IL_PREM_COLL_CHARGE_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_PREM_COLL_CHARGE.remove(PT_IL_PREM_COLL_CHARGE_BEAN);
				if(dataList_PT_IL_PREM_COLL_CHARGE.size()>0){

					PT_IL_PREM_COLL_CHARGE_BEAN=dataList_PT_IL_PREM_COLL_CHARGE.get(0);
				}else if(dataList_PT_IL_PREM_COLL_CHARGE.size()==0){
					addRow(null);
				}
				resetAllComponent();
				PT_IL_PREM_COLL_CHARGE_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
	}
	
	private void resetSelectedRow(){
		Iterator<PT_IL_PREM_COLL_CHARGE> PT_IL_PREM_COLL_CHARGE = 
			dataList_PT_IL_PREM_COLL_CHARGE.iterator();
		while (PT_IL_PREM_COLL_CHARGE.hasNext()) {
			PT_IL_PREM_COLL_CHARGE.next().setRowSelected(false);
		}
	}
	

	/**
	 * Resets all components in PT_IL_PREM_COLL_CHARGE_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PCC_CHARGE_CODE.resetValue();
		COMP_PCC_FC_CHARGE_AMT.resetValue();
		COMP_PCC_FC_INS_CHARGE_AMT.resetValue();
		COMP_PCC_CUST_SHARE_PERC.resetValue();
		COMP_PCC_LC_CHARGE_AMT.resetValue();
		COMP_PCC_LC_INS_CHARGE_AMT.resetValue();
		COMP_UI_M_CHARGE_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PCC_APPLY_PERIOD.resetValue();


	}
	public void postRecord(ActionEvent event) {
		try {
			if (PT_IL_PREM_COLL_CHARGE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_PREM_COLL_CHARGE_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PT_IL_PREM_COLL_CHARGE
						.add(PT_IL_PREM_COLL_CHARGE_BEAN);
			} else if (PT_IL_PREM_COLL_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_CHARGE_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PT_IL_PREM_COLL_CHARGE_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	
	public void onLoad(PhaseEvent event){
		 try {
				if (isBlockFlag()) {
					helper.WHEN_NEW_BLOCK_INSTANCE(PT_IL_PREM_COLL_CHARGE_BEAN, compositeAction);
					if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getROWID() != null){
						helper.executeQuery(compositeAction);
						helper.POST_QUERY(PT_IL_PREM_COLL_CHARGE_BEAN);
					}
					}
					setBlockFlag(false);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			} 
	 }


	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String mainAction(){
		return "PILT003_APAC_PT_IL_PREM_COLL";
	}


	public List<SelectItem> getListPCC_APPLY_PERIOD() {
		if (listPCC_APPLY_PERIOD.size() == 0) {
			listPCC_APPLY_PERIOD.clear();
			try {
				Connection con = CommonUtils.getConnection();
				listPCC_APPLY_PERIOD = new ArrayList<SelectItem>();
				listPCC_APPLY_PERIOD = new ArrayList<SelectItem>();
				listPCC_APPLY_PERIOD = ListItemUtil.getDropDownListValue(con,
						"PILT003_APAC", "PT_IL_PREM_COLL_CHARGE",
						"PT_IL_PREM_COLL_CHARGE.PCC_APPLY_PERIOD", "IL_CHG_PRD");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPCC_APPLY_PERIOD;
	}

	public void setListPCC_APPLY_PERIOD(List<SelectItem> listPCC_APPLY_PERIOD) {
		this.listPCC_APPLY_PERIOD = listPCC_APPLY_PERIOD;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}

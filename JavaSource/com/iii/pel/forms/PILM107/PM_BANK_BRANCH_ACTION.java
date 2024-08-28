package com.iii.pel.forms.PILM107;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_BANK_BRANCH_ACTION extends CommonAction {

	
	private PM_BANK_BRANCH PM_BANK_BRANCH_BEAN;;

	public PILM107_COMPOSITE_ACTION compositeAction;

	private PM_BANK_BRANCH_HELPER helper;

	private List<PM_BANK_BRANCH> dataList_PM_BANK_BRANCH = new ArrayList<PM_BANK_BRANCH>();

	private UIData dataTable;

	public PM_BANK_BRANCH_ACTION() {

		PM_BANK_BRANCH_BEAN = new PM_BANK_BRANCH();
		helper = new PM_BANK_BRANCH_HELPER();
		instantiateAllComponent();
	}

	
	public PM_BANK_BRANCH getPM_BANK_BRANCH_BEAN() {
		return PM_BANK_BRANCH_BEAN;
	}

	public void setPM_BANK_BRANCH_BEAN(PM_BANK_BRANCH PM_BANK_BRANCH_BEAN) {
		this.PM_BANK_BRANCH_BEAN = PM_BANK_BRANCH_BEAN;
	}

	public void validatorBR_BANK_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		CommonUtils.clearMaps(this);
		try {
			PM_BANK_BRANCH_BEAN.setBR_BANK_CODE((String)value);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorBR_BANK_SORT_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		CommonUtils.clearMaps(this);
		try {
			
			PM_BANK_BRANCH_BEAN.setBR_BANK_SORT_CODE((String)value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<PM_BANK_BRANCH> getDataList_PM_BANK_BRANCH() {
		return dataList_PM_BANK_BRANCH;
	}

	public void setDataListPM_BANK_BRANCH(List<PM_BANK_BRANCH> dataList_PM_BANK_BRANCH) {
		this.dataList_PM_BANK_BRANCH = dataList_PM_BANK_BRANCH;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_BANK_BRANCH_BEAN = new PM_BANK_BRANCH();
				PM_BANK_BRANCH_BEAN.setBR_BANK_CODE(compositeAction.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().getBANK_CODE());
				resetAllComponent();
				resetSelectedRow();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_BANK_BRANCH_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_BANK_BRANCH.remove(PM_BANK_BRANCH_BEAN);
				if (dataList_PM_BANK_BRANCH.size() > 0) {

					PM_BANK_BRANCH_BEAN = dataList_PM_BANK_BRANCH.get(0);
				} else if (dataList_PM_BANK_BRANCH.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_BANK_BRANCH_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			
			if (PM_BANK_BRANCH_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preInsert(PM_BANK_BRANCH_BEAN, compositeAction.getPM_CUSTOMER_ACTION_BEAN().getPM_CUSTOMER_BEAN());
				new CRUDHandler().executeInsert(PM_BANK_BRANCH_BEAN, CommonUtils.getConnection());			
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
				dataList_PM_BANK_BRANCH.add(PM_BANK_BRANCH_BEAN);
			} else if (PM_BANK_BRANCH_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				//helper.preUpdate(PM_BANK_BRANCH_BEAN);
				new CRUDHandler().executeUpdate(PM_BANK_BRANCH_BEAN, CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		
			}

			PM_BANK_BRANCH_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_BANK_BRANCH_BEAN = (PM_BANK_BRANCH) dataTable.getRowData();
			PM_BANK_BRANCH_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			/*Added by janani on 10-07-2017, ZBILQC-1730996*/
			exc.printStackTrace();
			/*end*/
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_BANK_BRANCH> PM_BANK_BRANCH_ITR = dataList_PM_BANK_BRANCH
				.iterator();
		while (PM_BANK_BRANCH_ITR.hasNext()) {
			PM_BANK_BRANCH_ITR.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_BR_BANK_CODE.resetValue();
		COMP_BR_BANK_SORT_CODE.resetValue();
		COMP_BANK_BRANCH_NAME.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString("messageProperties","errorPanel$message$save"));
			getWarningMap().put("SAVE_RECORD", Messages.getString("messageProperties","errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);				
				
				if (PM_BANK_BRANCH_BEAN.getROWID() == null){
					PM_BANK_BRANCH_BEAN.setBR_BANK_CODE(compositeAction.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().getBANK_CODE());
					resetAllComponent();
				}
				if(compositeAction.getPM_BANK_ACTION_BEAN().getCOMP_BANK_FRZ_FLAG_NUM().isSelected()){
					disableAllComponents(true);
				}else{
					disableAllComponents(false);
				}
				setBlockFlag(false);
			}
			
		} catch (Exception e) {			
			e.printStackTrace();			
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	
	 public ArrayList<LovBean> lovCDIV_DIVN_CODE(Object object) {
	    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			String query = "SELECT DIVN_CODE,DIVN_NAME  FROM PM_DIVISION WHERE  DIVN_FRZ_FLAG = 'N'   " +
					"AND ( DIVN_CODE LIKE ?  OR  DIVN_NAME LIKE ? ) AND ROWNUM < ? ORDER BY 1";
			Object[] values = null;
			String currentValue = (String) object;

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

				values = new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize };
				lovList = ListItemUtil.prepareSuggestionList(query, values);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	    }
	 
	 private HtmlInputText COMP_BR_BANK_CODE;
	 private HtmlInputText COMP_BR_BANK_SORT_CODE;
	 private HtmlInputText COMP_BANK_BRANCH_NAME;
	 
	 public HtmlInputText getCOMP_BR_BANK_CODE() {
		return COMP_BR_BANK_CODE;
	}


	public void setCOMP_BR_BANK_CODE(HtmlInputText cOMP_BR_BANK_CODE) {
		COMP_BR_BANK_CODE = cOMP_BR_BANK_CODE;
	}


	public HtmlInputText getCOMP_BR_BANK_SORT_CODE() {
		return COMP_BR_BANK_SORT_CODE;
	}


	public void setCOMP_BR_BANK_SORT_CODE(HtmlInputText cOMP_BR_BANK_SORT_CODE) {
		COMP_BR_BANK_SORT_CODE = cOMP_BR_BANK_SORT_CODE;
	}


	public HtmlInputText getCOMP_BANK_BRANCH_NAME() {
		return COMP_BANK_BRANCH_NAME;
	}


	public void setCOMP_BANK_BRANCH_NAME(HtmlInputText cOMP_BANK_BRANCH_NAME) {
		COMP_BANK_BRANCH_NAME = cOMP_BANK_BRANCH_NAME;
	}


	public void instantiateAllComponent() {		 
		 COMP_BR_BANK_CODE = new HtmlInputText();
		 COMP_BR_BANK_SORT_CODE =  new HtmlInputText();
		 COMP_BANK_BRANCH_NAME = new HtmlInputText();
	 }
	 
	 public String backToBank(){
		 
		 return "PILM107";
	 }
	 public void disableAllComponents(boolean disabled)
		{
		 	COMP_BR_BANK_CODE.setDisabled(disabled);
			COMP_BR_BANK_SORT_CODE.setDisabled(disabled);
			COMP_BANK_BRANCH_NAME.setDisabled(disabled);
		 
		}
	 
}

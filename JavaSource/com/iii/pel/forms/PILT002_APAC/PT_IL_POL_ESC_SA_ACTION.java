package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ESC_SA_ACTION extends CommonAction {
	
    private PT_IL_POL_ESC_SA PT_IL_POL_ESC_SA_BEAN;

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_ESC_SA_HELPER helper;

    private List<PT_IL_POL_ESC_SA> dataList_PT_IL_POL_ESC_SA = new ArrayList<PT_IL_POL_ESC_SA>();

    private UIData dataTable;

	public PT_IL_POL_ESC_SA_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PT_IL_POL_ESC_SA_HELPER helper) {
		this.helper = helper;
	}
	public List<PT_IL_POL_ESC_SA> getDataList_PT_IL_POL_ESC_SA() {
		return dataList_PT_IL_POL_ESC_SA;
	}
	public void setDataList_PT_IL_POL_ESC_SA(
			List<PT_IL_POL_ESC_SA> dataList_PT_IL_POL_ESC_SA) {
		this.dataList_PT_IL_POL_ESC_SA = dataList_PT_IL_POL_ESC_SA;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
    
    public PT_IL_POL_ESC_SA getPT_IL_POL_ESC_SA_BEAN() {
		return PT_IL_POL_ESC_SA_BEAN;
	}
	public void setPT_IL_POL_ESC_SA_BEAN(PT_IL_POL_ESC_SA pT_IL_POL_ESC_SA_BEAN) {
		PT_IL_POL_ESC_SA_BEAN = pT_IL_POL_ESC_SA_BEAN;
	}
	
	public PT_IL_POL_ESC_SA_ACTION() {

    	PT_IL_POL_ESC_SA_BEAN = new PT_IL_POL_ESC_SA();
    	helper = new PT_IL_POL_ESC_SA_HELPER();
    	instantiateAllComponent();
        }
	private HtmlOutputLabel COMP_PES_COVER_CODE_LABEL;
	
	private HtmlInputText COMP_PES_COVER_CODE;
	
	private HtmlInputText COMP_UI_M_PES_COVER_CODE_DESC;
	
	private HtmlOutputLabel COMP_PES_MONTH_LABEL;
	
	private HtmlInputText COMP_PES_MONTH;
	
	private HtmlOutputLabel COMP_PES_FC_SA_LABEL;
	
	private HtmlInputText COMP_PES_FC_SA;
	
	private HtmlOutputLabel COMP_PES_LC_SA_LABEL;
	
	private HtmlInputText COMP_PES_LC_SA;
	
	
    public HtmlOutputLabel getCOMP_PES_COVER_CODE_LABEL() {
		return COMP_PES_COVER_CODE_LABEL;
	}
	public void setCOMP_PES_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_PES_COVER_CODE_LABEL) {
		COMP_PES_COVER_CODE_LABEL = cOMP_PES_COVER_CODE_LABEL;
	}
	public HtmlInputText getCOMP_PES_COVER_CODE() {
		return COMP_PES_COVER_CODE;
	}
	public void setCOMP_PES_COVER_CODE(HtmlInputText cOMP_PES_COVER_CODE) {
		COMP_PES_COVER_CODE = cOMP_PES_COVER_CODE;
	}
	public HtmlInputText getCOMP_UI_M_PES_COVER_CODE_DESC() {
		return COMP_UI_M_PES_COVER_CODE_DESC;
	}
	public void setCOMP_UI_M_PES_COVER_CODE_DESC(
			HtmlInputText cOMP_UI_M_PES_COVER_CODE_DESC) {
		COMP_UI_M_PES_COVER_CODE_DESC = cOMP_UI_M_PES_COVER_CODE_DESC;
	}
	public HtmlOutputLabel getCOMP_PES_MONTH_LABEL() {
		return COMP_PES_MONTH_LABEL;
	}
	public void setCOMP_PES_MONTH_LABEL(HtmlOutputLabel cOMP_PES_MONTH_LABEL) {
		COMP_PES_MONTH_LABEL = cOMP_PES_MONTH_LABEL;
	}
	public HtmlInputText getCOMP_PES_MONTH() {
		return COMP_PES_MONTH;
	}
	public void setCOMP_PES_MONTH(HtmlInputText cOMP_PES_MONTH) {
		COMP_PES_MONTH = cOMP_PES_MONTH;
	}
	public HtmlOutputLabel getCOMP_PES_FC_SA_LABEL() {
		return COMP_PES_FC_SA_LABEL;
	}
	public void setCOMP_PES_FC_SA_LABEL(HtmlOutputLabel cOMP_PES_FC_SA_LABEL) {
		COMP_PES_FC_SA_LABEL = cOMP_PES_FC_SA_LABEL;
	}
	public HtmlInputText getCOMP_PES_FC_SA() {
		return COMP_PES_FC_SA;
	}
	public void setCOMP_PES_FC_SA(HtmlInputText cOMP_PES_FC_SA) {
		COMP_PES_FC_SA = cOMP_PES_FC_SA;
	}
	public HtmlOutputLabel getCOMP_PES_LC_SA_LABEL() {
		return COMP_PES_LC_SA_LABEL;
	}
	public void setCOMP_PES_LC_SA_LABEL(HtmlOutputLabel cOMP_PES_LC_SA_LABEL) {
		COMP_PES_LC_SA_LABEL = cOMP_PES_LC_SA_LABEL;
	}
	public HtmlInputText getCOMP_PES_LC_SA() {
		return COMP_PES_LC_SA;
	}
	public void setCOMP_PES_LC_SA(HtmlInputText cOMP_PES_LC_SA) {
		COMP_PES_LC_SA = cOMP_PES_LC_SA;
	}
	public void onLoad(PhaseEvent event) {
    	try {
    	    if (isBlockFlag()) {
    		helper.executeQuery(compositeAction);
    		setBlockFlag(false);
    	    }
    	} catch (Exception e) {
    		e.printStackTrace();
    	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    		    e.getMessage());
    	    getErrorMap().put("onLoad", e.getMessage());
    	}
        }
    
    public void instantiateAllComponent(){
    	COMP_UI_M_BUT_ANNU_ESC=new HtmlCommandButton();	
    }
   
	private HtmlCommandButton COMP_UI_M_BUT_ANNU_ESC;

	public HtmlCommandButton getCOMP_UI_M_BUT_ANNU_ESC() {
		return COMP_UI_M_BUT_ANNU_ESC;
	}

	public void setCOMP_UI_M_BUT_ANNU_ESC(HtmlCommandButton cOMP_UI_M_BUT_ANNU_ESC) {
		COMP_UI_M_BUT_ANNU_ESC = cOMP_UI_M_BUT_ANNU_ESC;
	}
	 public String UI_M_BUT_ANNU_ESC() {

	    	//PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	    	try {
	    		
	    		/*Added by saritha on 04-08-2017 for ssp call id ZBILQC-1734015*/
	    		setBlockFlag(true);
	    		/*End*/
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	return "PILT002_APAC_PT_IL_POL_ESC_SA";
	    }
	
	 public String  mainAction() {

	    	//PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	    	try {
	    		/*compositeAction.getPT_IL_POLICY2_ACTION_BEAN().onLoad(null);
	    		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setBlockFlag(true);
	    		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setFormFlag(true);*/
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	return "PT_IL_PREM_DTLS";
	    }
	 public void disableAllComponent(boolean disabled){
		 
	 }
	    public void addRow(ActionEvent event) {
	    	try {
	    	    if (isINSERT_ALLOWED()) {

	    	    	PT_IL_POL_ESC_SA_BEAN = new PT_IL_POL_ESC_SA();
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

	    		new CRUDHandler().executeDelete(PT_IL_POL_ESC_SA_BEAN,
	    			CommonUtils.getConnection());
	    		getWarningMap().put(
	    			"deleteRow",
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$delete"));
	    		getWarningMap().put(
	    			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$delete"));
	    		dataList_PT_IL_POL_ESC_SA.remove(PT_IL_POL_ESC_SA_BEAN);
	    		if (dataList_PT_IL_POL_ESC_SA.size() > 0) {

	    			PT_IL_POL_ESC_SA_BEAN = dataList_PT_IL_POL_ESC_SA.get(0);
	    		} else if (dataList_PT_IL_POL_ESC_SA.size() == 0) {

	    		    addRow(null);
	    		}

	    		resetAllComponent();
	    		PT_IL_POL_ESC_SA_BEAN.setRowSelected(true);
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
	    	try {
	    	    if (PT_IL_POL_ESC_SA_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

	    		new CRUDHandler().executeInsert(PT_IL_POL_ESC_SA_BEAN,
	    			CommonUtils.getConnection());
	    		getWarningMap().put(
	    			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$save"));
	    		getWarningMap().put(
	    			"postRecord",
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$save"));
	    		dataList_PT_IL_POL_ESC_SA.add(PT_IL_POL_ESC_SA_BEAN);
	    	    } else if (PT_IL_POL_ESC_SA_BEAN.getROWID() != null
	    		     && isUPDATE_ALLOWED()) {

	    		new CRUDHandler().executeUpdate(PT_IL_POL_ESC_SA_BEAN,
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

	    	    PT_IL_POL_ESC_SA_BEAN.setRowSelected(true);
	    	} catch (Exception exc) {
	    	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	    		    "Record not Inserted/Updated :: " + exc.getMessage());
	    	    getErrorMap().put("postRecord",
	    		    "Record not Inserted/Updated :: " + exc.getMessage());
	    	}

	        }

	        public void displayRecords() {
	    	CommonUtils.clearMaps(this);
	    	try {
	    	    resetSelectedRow();
	    	    PT_IL_POL_ESC_SA_BEAN = (PT_IL_POL_ESC_SA) dataTable.getRowData();
	    	    PT_IL_POL_ESC_SA_BEAN.setRowSelected(true);
	    	    resetAllComponent();
	    	} catch (Exception exc) {
	    	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	    		    exc.getMessage());
	    	    getErrorMap().put("displayRecords", exc.getMessage());
	    	}

	        }

	        private void resetSelectedRow() {
	    	Iterator<PT_IL_POL_ESC_SA> PT_IL_POL_ESC_SA_ITR = dataList_PT_IL_POL_ESC_SA
	    		.iterator();
	    	while (PT_IL_POL_ESC_SA_ITR.hasNext()) {
	    		PT_IL_POL_ESC_SA_ITR.next().setRowSelected(false);
	    	}
	        }

	        private void resetAllComponent() {
	        }
	        public void saveRecord() {
	        	try {
	        	    CommonUtils.getConnection().commit();
	        	} catch (Exception e) {
	        	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	        		    e.getMessage());
	        	    getErrorMap().put("SAVE", e.getMessage());
	        	}
	            }

	            public void fireFieldValidation(ActionEvent actionEvent) {
	        	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	        	ErrorHelpUtil.validate(input, getErrorMap());
	            }
}

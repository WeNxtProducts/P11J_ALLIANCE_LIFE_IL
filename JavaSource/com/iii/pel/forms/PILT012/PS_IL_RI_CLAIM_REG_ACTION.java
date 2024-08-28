package com.iii.pel.forms.PILT012;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM003_APAC.PM_IL_RED_SA_DELEGATE;
import com.iii.pel.forms.PILM003_APAC.PM_IL_RED_SA_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_RI_CLAIM_REG_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_RI_CLOSE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_RCR_DT_LABEL;

	
	private UIData dataTable;	
	
	private HtmlCalendar COMP_RCR_DT;

	private HtmlOutputLabel COMP_RCR_RET_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_RCR_RET_FC_CLM_PAID;

	private HtmlOutputLabel COMP_RCR_QS_LC_CLM_PAID_LABEL;

	private HtmlInputText COMP_RCR_QS_LC_CLM_PAID;

	private HtmlOutputLabel COMP_RCR_1S_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_RCR_1S_FC_CLM_PAID;

	private HtmlOutputLabel COMP_RCR_2S_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_RCR_2S_FC_CLM_PAID;

	private HtmlOutputLabel COMP_RCR_3S_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_RCR_3S_FC_CLM_PAID;

	private HtmlCommandButton COMP_UI_M_BUT_CLM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_COVER_CODE_LOV;

	private PS_IL_RI_CLAIM_REG PS_IL_RI_CLAIM_REG_BEAN;
	
	ArrayList<PS_IL_RI_CLAIM_REG> list = new ArrayList<PS_IL_RI_CLAIM_REG>();
	
	private String filterByRCR_RET_FC_CLM_PAID;

	private String filterByRCR_1S_FC_CLM_PAID;
	
	private String filterByRCR_QS_LC_CLM_PAID;
	
	private UIDataTable dataTableForgrid;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	PILT012_COMPOSITE_ACTION compositeAction;
	
	
		
	private List<PS_IL_RI_CLAIM_REG> dataList = new ArrayList<PS_IL_RI_CLAIM_REG>();
	
	private UIData data;
	//[PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix
	private boolean onLoadFlag = false;
	//PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix]
	public PS_IL_RI_CLAIM_REG_ACTION() {
		PS_IL_RI_CLAIM_REG_BEAN = new PS_IL_RI_CLAIM_REG();
	}

	public HtmlOutputLabel getCOMP_UI_M_RI_CLOSE() {
		return COMP_UI_M_RI_CLOSE;
	}

	public void setCOMP_UI_M_RI_CLOSE(HtmlOutputLabel COMP_UI_M_RI_CLOSE) {
		this.COMP_UI_M_RI_CLOSE = COMP_UI_M_RI_CLOSE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_RCR_DT_LABEL() {
		return COMP_RCR_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RCR_DT() {
		return COMP_RCR_DT;
	}

	public void setCOMP_RCR_DT_LABEL(HtmlOutputLabel COMP_RCR_DT_LABEL) {
		this.COMP_RCR_DT_LABEL = COMP_RCR_DT_LABEL;
	}

	public void setCOMP_RCR_DT(HtmlCalendar COMP_RCR_DT) {
		this.COMP_RCR_DT = COMP_RCR_DT;
	}

	public HtmlOutputLabel getCOMP_RCR_RET_FC_CLM_PAID_LABEL() {
		return COMP_RCR_RET_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RCR_RET_FC_CLM_PAID() {
		return COMP_RCR_RET_FC_CLM_PAID;
	}

	public void setCOMP_RCR_RET_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_RCR_RET_FC_CLM_PAID_LABEL) {
		this.COMP_RCR_RET_FC_CLM_PAID_LABEL = COMP_RCR_RET_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_RCR_RET_FC_CLM_PAID(HtmlInputText COMP_RCR_RET_FC_CLM_PAID) {
		this.COMP_RCR_RET_FC_CLM_PAID = COMP_RCR_RET_FC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RCR_QS_LC_CLM_PAID_LABEL() {
		return COMP_RCR_QS_LC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RCR_QS_LC_CLM_PAID() {
		return COMP_RCR_QS_LC_CLM_PAID;
	}

	public void setCOMP_RCR_QS_LC_CLM_PAID_LABEL(HtmlOutputLabel COMP_RCR_QS_LC_CLM_PAID_LABEL) {
		this.COMP_RCR_QS_LC_CLM_PAID_LABEL = COMP_RCR_QS_LC_CLM_PAID_LABEL;
	}

	public void setCOMP_RCR_QS_LC_CLM_PAID(HtmlInputText COMP_RCR_QS_LC_CLM_PAID) {
		this.COMP_RCR_QS_LC_CLM_PAID = COMP_RCR_QS_LC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RCR_1S_FC_CLM_PAID_LABEL() {
		return COMP_RCR_1S_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RCR_1S_FC_CLM_PAID() {
		return COMP_RCR_1S_FC_CLM_PAID;
	}

	public void setCOMP_RCR_1S_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_RCR_1S_FC_CLM_PAID_LABEL) {
		this.COMP_RCR_1S_FC_CLM_PAID_LABEL = COMP_RCR_1S_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_RCR_1S_FC_CLM_PAID(HtmlInputText COMP_RCR_1S_FC_CLM_PAID) {
		this.COMP_RCR_1S_FC_CLM_PAID = COMP_RCR_1S_FC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RCR_2S_FC_CLM_PAID_LABEL() {
		return COMP_RCR_2S_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RCR_2S_FC_CLM_PAID() {
		return COMP_RCR_2S_FC_CLM_PAID;
	}

	public void setCOMP_RCR_2S_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_RCR_2S_FC_CLM_PAID_LABEL) {
		this.COMP_RCR_2S_FC_CLM_PAID_LABEL = COMP_RCR_2S_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_RCR_2S_FC_CLM_PAID(HtmlInputText COMP_RCR_2S_FC_CLM_PAID) {
		this.COMP_RCR_2S_FC_CLM_PAID = COMP_RCR_2S_FC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RCR_3S_FC_CLM_PAID_LABEL() {
		return COMP_RCR_3S_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RCR_3S_FC_CLM_PAID() {
		return COMP_RCR_3S_FC_CLM_PAID;
	}

	public void setCOMP_RCR_3S_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_RCR_3S_FC_CLM_PAID_LABEL) {
		this.COMP_RCR_3S_FC_CLM_PAID_LABEL = COMP_RCR_3S_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_RCR_3S_FC_CLM_PAID(HtmlInputText COMP_RCR_3S_FC_CLM_PAID) {
		this.COMP_RCR_3S_FC_CLM_PAID = COMP_RCR_3S_FC_CLM_PAID;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLM_LOV() {
		return COMP_UI_M_BUT_CLM_LOV;
	}

	public void setCOMP_UI_M_BUT_CLM_LOV(HtmlCommandButton COMP_UI_M_BUT_CLM_LOV) {
		this.COMP_UI_M_BUT_CLM_LOV = COMP_UI_M_BUT_CLM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LOV() {
		return COMP_UI_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_BUT_POL_LOV) {
		this.COMP_UI_M_BUT_POL_LOV = COMP_UI_M_BUT_POL_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COVER_CODE_LOV() {
		return COMP_UI_M_BUT_COVER_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_COVER_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_COVER_CODE_LOV) {
		this.COMP_UI_M_BUT_COVER_CODE_LOV = COMP_UI_M_BUT_COVER_CODE_LOV;
	}

	public PS_IL_RI_CLAIM_REG getPS_IL_RI_CLAIM_REG_BEAN() {
		return PS_IL_RI_CLAIM_REG_BEAN;
	}

	public void setPS_IL_RI_CLAIM_REG_BEAN(PS_IL_RI_CLAIM_REG PS_IL_RI_CLAIM_REG_BEAN) {
		this.PS_IL_RI_CLAIM_REG_BEAN = PS_IL_RI_CLAIM_REG_BEAN;
	}
	
	public String previousPageButtonClickAction(){
		String returnString="GO_TO_PILT012_PS_IL_RI_CLAIM_REG_1";
		return returnString;
	}

	public UIData getData() {
		return data;
	}

	public void setData(UIData data) {
		this.data = data;
	}

	public List<PS_IL_RI_CLAIM_REG> getDataList() {
		return dataList;
	}

	public void setDataList(List<PS_IL_RI_CLAIM_REG> dataList) {
		this.dataList = dataList;
	}
	//[PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event){
		try {
			if(!isOnLoadFlag()){
				populateGrid(compositeAction);
				setOnLoadFlag(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String tryToAddARow(){
		System.out.println("ADD ROW");
		PS_IL_RI_CLAIM_REG tempBean= new PS_IL_RI_CLAIM_REG();
		dataList.add(tempBean);
		//tempBean.setRSA_RATE_PER(3.0);
		return null;
	}
	//PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix]
	public String populateGrid( PILT012_COMPOSITE_ACTION compositeAction)throws Exception{
		
		Map m = getSessionMap();
		try {
				PS_IL_RI_CLAIM_REG_1_ACTION psIlRiClaimReg1Action = compositeAction.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN();
				String selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* from PS_IL_RI_CLAIM_REG WHERE RCR_DIVN_CODE='"+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_DIVN_CODE()+"' " +
				"AND RCR_CLASS_CODE='"+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLASS_CODE()+"' " +
				"AND RCR_TREATY_CODE='"+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_TREATY_CODE()+"' " +
				"AND RCR_CLM_COVER_CODE='"+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE()+"' " +
				"AND RCR_CLM_SYS_ID='"+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID()+"'";
				
				dataList = getHandler().fetch(selectQuery, "com.iii.pel.forms.PILT012.PS_IL_RI_CLAIM_REG", CommonUtils.getConnection());
				System.out.println("INSIDE THE populate grid: "+psIlRiClaimReg1Action.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID());
				System.out.println("The Size is "+dataList.size());
				PS_IL_RI_CLAIM_REG_ACTION psIlRiClaimRegAction = compositeAction.getPS_IL_RI_CLAIM_REG_ACTION_BEAN();
				
				//Added for aligning the grid value properly
				Iterator<PS_IL_RI_CLAIM_REG> it = dataList.iterator();
				PS_IL_RI_CLAIM_REG PS_IL_RI_CLAIM_REG_BEAN = null;
				while(it.hasNext()){
					PS_IL_RI_CLAIM_REG_BEAN = it.next();
					PS_IL_RI_CLAIM_REG_BEAN.setRowSelected(false);
				}
				
				psIlRiClaimRegAction.setDataList(dataList);
				if (dataList.size() !=0){					
					psIlRiClaimRegAction.setPS_IL_RI_CLAIM_REG_BEAN(dataList.get(0));
					psIlRiClaimRegAction.getPS_IL_RI_CLAIM_REG_BEAN().setRowSelected(true);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		return null;
	}
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	
	public String prevPage(){
		return "PILT012_PS_IL_RI_CLAIM_REG_1";
	}
	
	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void resetAllComponent(){
		COMP_RCR_DT.resetValue();
		COMP_RCR_RET_FC_CLM_PAID.resetValue();
		COMP_RCR_QS_LC_CLM_PAID.resetValue();
		COMP_RCR_1S_FC_CLM_PAID.resetValue();
		
		COMP_RCR_2S_FC_CLM_PAID.resetValue();
		COMP_RCR_3S_FC_CLM_PAID.resetValue();
	}

	
	public void AddRow(ActionEvent event){

		
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PS_IL_RI_CLAIM_REG_BEAN = new PS_IL_RI_CLAIM_REG();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
		
	}

public void deleteRow(ActionEvent ae) {
		
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PS_IL_RI_CLAIM_REG_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PS_IL_RI_CLAIM_REG_BEAN, CommonUtils.getConnection());
					list.remove(PS_IL_RI_CLAIM_REG_BEAN);
				}
				
				if(list.size() > 0) {
					setPS_IL_RI_CLAIM_REG_BEAN(list.get(0));
				} else {
					AddRow(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
		
	}

public void post(ActionEvent ae) {
	
	
	PM_IL_RED_SA_DELEGATE delegate = new PM_IL_RED_SA_DELEGATE();
	PM_IL_RED_SA_HELPER helper = new PM_IL_RED_SA_HELPER();

	try{
		if(PS_IL_RI_CLAIM_REG_BEAN.getROWID() != null) {
			if(isUPDATE_ALLOWED()) {

				//helper.pilm003_apac_pm_fm_year_pre_update(PM_IL_RED_SA_BEAN);
				new CRUDHandler().executeInsert(PS_IL_RI_CLAIM_REG_BEAN, new CommonUtils().getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				getWarningMap().put("post",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
				getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
			}
		} else {

			if(isINSERT_ALLOWED()) {
				//helper.pilm003_apac_pm_fm_year_pre_insert(this.PM_IL_RED_SA_BEAN);
				PS_IL_RI_CLAIM_REG_BEAN.setRCR_PLAN_CODE("dee");
				new CRUDHandler().executeInsert(PS_IL_RI_CLAIM_REG_BEAN, new CommonUtils().getConnection());					
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put("post",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				list.add(PS_IL_RI_CLAIM_REG_BEAN);
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
			}
		}
		resetAllComponent();

	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("post", e.getMessage());
	}
} 

	
	public void getDetails() {
	try {
		if (dataList.size() != 0) {				
			PS_IL_RI_CLAIM_REG_BEAN = (PS_IL_RI_CLAIM_REG) dataTableForgrid.getRowData();
		}	
		resetAllComponent();			
		resetSelectedRow();
		PS_IL_RI_CLAIM_REG_BEAN.setRowSelected(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	private void resetSelectedRow() {
		Iterator<PS_IL_RI_CLAIM_REG> iterator = dataList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the list
	 */
	public ArrayList<PS_IL_RI_CLAIM_REG> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<PS_IL_RI_CLAIM_REG> list) {
		this.list = list;
	}

	/**
	 * @return the filterByRCR_RET_FC_CLM_PAID
	 */
	public String getFilterByRCR_RET_FC_CLM_PAID() {
		return filterByRCR_RET_FC_CLM_PAID;
	}

	/**
	 * @param filterByRCR_RET_FC_CLM_PAID the filterByRCR_RET_FC_CLM_PAID to set
	 */
	public void setFilterByRCR_RET_FC_CLM_PAID(String filterByRCR_RET_FC_CLM_PAID) {
		this.filterByRCR_RET_FC_CLM_PAID = filterByRCR_RET_FC_CLM_PAID;
	}

	/**
	 * @return the filterByRCR_1S_FC_CLM_PAID
	 */
	public String getFilterByRCR_1S_FC_CLM_PAID() {
		return filterByRCR_1S_FC_CLM_PAID;
	}

	/**
	 * @param filterByRCR_1S_FC_CLM_PAID the filterByRCR_1S_FC_CLM_PAID to set
	 */
	public void setFilterByRCR_1S_FC_CLM_PAID(String filterByRCR_1S_FC_CLM_PAID) {
		this.filterByRCR_1S_FC_CLM_PAID = filterByRCR_1S_FC_CLM_PAID;
	}

	/**
	 * @return the dataTableForgrid
	 */
	public UIDataTable getDataTableForgrid() {
		return dataTableForgrid;
	}

	/**
	 * @param dataTableForgrid the dataTableForgrid to set
	 */
	public void setDataTableForgrid(UIDataTable dataTableForgrid) {
		this.dataTableForgrid = dataTableForgrid;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the filterByRCR_QS_LC_CLM_PAID
	 */
	public String getFilterByRCR_QS_LC_CLM_PAID() {
		return filterByRCR_QS_LC_CLM_PAID;
	}

	/**
	 * @param filterByRCR_QS_LC_CLM_PAID the filterByRCR_QS_LC_CLM_PAID to set
	 */
	public void setFilterByRCR_QS_LC_CLM_PAID(String filterByRCR_QS_LC_CLM_PAID) {
		this.filterByRCR_QS_LC_CLM_PAID = filterByRCR_QS_LC_CLM_PAID;
	}


	
}

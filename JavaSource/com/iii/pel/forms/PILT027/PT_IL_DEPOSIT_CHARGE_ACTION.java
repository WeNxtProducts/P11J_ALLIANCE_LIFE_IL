package com.iii.pel.forms.PILT027;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_DEPOSIT_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DCHRG_CODE_LABEL;

	private HtmlInputText COMP_DCHRG_CODE;

	private HtmlOutputLabel COMP_UI_M_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_DESC;

	private HtmlOutputLabel COMP_DCHRG_RATE_LABEL;

	private HtmlInputText COMP_DCHRG_RATE;
	
	private HtmlOutputLabel COMP_DCHRG_RATE_PER_LABEL;

	private HtmlInputText COMP_DCHRG_RATE_PER;

	private HtmlOutputLabel COMP_DCHRG_FLEX_01_LABEL;

	private HtmlSelectOneMenu COMP_DCHRG_FLEX_01;
		
	private HtmlOutputLabel COMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_DCHRG_TOTAL_LC_AMT;

	private PT_IL_DEPOSIT_CHARGE PT_IL_DEPOSIT_CHARGE_BEAN;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlCommandLink COMP_UI_M_BUT_SAVE;
	
	private UIData chargeTable;
	
	private List<PT_IL_DEPOSIT_CHARGE> fetchList = new ArrayList<PT_IL_DEPOSIT_CHARGE>();
	
	public PILT027_COMPOSITE_ACTION composite_action;
	
	private List<SelectItem> listSelect = new ArrayList<SelectItem>();

	public PT_IL_DEPOSIT_CHARGE_ACTION() {
		List<SelectItem> tmpList = new ArrayList<SelectItem>();
		tmpList.add(new SelectItem("4","Percentage"));
		tmpList.add(new SelectItem("3","Fixed"));
		setListSelect(tmpList);
		PT_IL_DEPOSIT_CHARGE_BEAN = new PT_IL_DEPOSIT_CHARGE();
		fetchList = new ArrayList<PT_IL_DEPOSIT_CHARGE>();
		 
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_DCHRG_CODE_LABEL() {
		return COMP_DCHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DCHRG_CODE() {
		return COMP_DCHRG_CODE;
	}

	public void setCOMP_DCHRG_CODE_LABEL(HtmlOutputLabel COMP_DCHRG_CODE_LABEL) {
		this.COMP_DCHRG_CODE_LABEL = COMP_DCHRG_CODE_LABEL;
	}

	public void setCOMP_DCHRG_CODE(HtmlInputText COMP_DCHRG_CODE) {
		this.COMP_DCHRG_CODE = COMP_DCHRG_CODE;
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

	public HtmlOutputLabel getCOMP_DCHRG_RATE_LABEL() {
		return COMP_DCHRG_RATE_LABEL;
	}

	public HtmlInputText getCOMP_DCHRG_RATE() {
		return COMP_DCHRG_RATE;
	}

	public void setCOMP_DCHRG_RATE_LABEL(HtmlOutputLabel COMP_DCHRG_RATE_LABEL) {
		this.COMP_DCHRG_RATE_LABEL = COMP_DCHRG_RATE_LABEL;
	}

	public void setCOMP_DCHRG_RATE(HtmlInputText COMP_DCHRG_RATE) {
		this.COMP_DCHRG_RATE = COMP_DCHRG_RATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL() {
		return COMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DCHRG_TOTAL_LC_AMT() {
		return COMP_UI_M_DCHRG_TOTAL_LC_AMT;
	}

	public void setCOMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL(HtmlOutputLabel COMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL) {
		this.COMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL = COMP_UI_M_DCHRG_TOTAL_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_DCHRG_TOTAL_LC_AMT(HtmlInputText COMP_UI_M_DCHRG_TOTAL_LC_AMT) {
		this.COMP_UI_M_DCHRG_TOTAL_LC_AMT = COMP_UI_M_DCHRG_TOTAL_LC_AMT;
	}

	public PT_IL_DEPOSIT_CHARGE getPT_IL_DEPOSIT_CHARGE_BEAN() {
		return PT_IL_DEPOSIT_CHARGE_BEAN;
	}

	public void setPT_IL_DEPOSIT_CHARGE_BEAN(PT_IL_DEPOSIT_CHARGE PT_IL_DEPOSIT_CHARGE_BEAN) {
		this.PT_IL_DEPOSIT_CHARGE_BEAN = PT_IL_DEPOSIT_CHARGE_BEAN;
	}
	
	public String nextPageButtonClickAction(){
		String returnString="GO_TO_PILT027_PT_IL_TOP_UP_1";
		return returnString;
	}
	
	public String saveNextButtonClickAction(){
		String returnString="GO_TO_PILT027_PT_IL_TOP_UP_1";
		return returnString;
	}
	
	public String previousPageButtonClickAction(){
		String returnString="GO_TO_PILT027_PT_IL_TOP_UP";
		return returnString;
	}
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = chargeTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				//lastColumnListener();
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
	// Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009 ]

	public UIData getChargeTable() {
		return chargeTable;
	}

	public void setChargeTable(UIData chargeTable) {
		this.chargeTable = chargeTable;
	}

	public List<PT_IL_DEPOSIT_CHARGE> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PT_IL_DEPOSIT_CHARGE> fetchList) {
		this.fetchList = fetchList;
	}
	
	
	public void getDetails(ActionEvent event) {
		try {
			int rowIndex = chargeTable.getRowIndex();
			if (fetchList.size() != 0) {
				PT_IL_DEPOSIT_CHARGE_BEAN = (PT_IL_DEPOSIT_CHARGE) chargeTable.getRowData();
				//resetRowSelection();
				resetSelectedRow();
				PT_IL_DEPOSIT_CHARGE_BEAN.setRowSelected(true);
				resetAllComponent();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PT_IL_DEPOSIT_CHARGE_BEAN=null;
			if (isINSERT_ALLOWED()){		
				PT_IL_DEPOSIT_CHARGE_BEAN = new PT_IL_DEPOSIT_CHARGE();
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
	
	
	
	 private void resetAllComponent() {
		
			 COMP_DCHRG_CODE.resetValue();
			 COMP_UI_M_CHARGE_DESC.resetValue();
			 COMP_DCHRG_RATE.resetValue();
			 COMP_UI_M_DCHRG_TOTAL_LC_AMT.resetValue();
			 COMP_DCHRG_FLEX_01.resetValue();
	}
	 
	 private void resetSelectedRow() {
			Iterator<PT_IL_DEPOSIT_CHARGE> iterator = fetchList.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}

	public void deleteRow(ActionEvent ae) {
			
			try{
				getErrorMap().clear();
				getWarningMap().clear();

				if(isDELETE_ALLOWED()) {
					if(PT_IL_DEPOSIT_CHARGE_BEAN.getROWID() != null) {
						//executeDelete(PM_CUST_DIVN_BEAN);
						new CRUDHandler().executeDelete(PT_IL_DEPOSIT_CHARGE_BEAN, CommonUtils.getConnection());
						fetchList.remove(PT_IL_DEPOSIT_CHARGE_BEAN);
					}
					
					if(fetchList.size() > 0) {
						setPT_IL_DEPOSIT_CHARGE_BEAN(fetchList.get(0));
						PT_IL_DEPOSIT_CHARGE_BEAN.setRowSelected(true);
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
		   PT_IL_DEPOSIT_CHARGE_DELEGATE delegate= new PT_IL_DEPOSIT_CHARGE_DELEGATE();
		   try{
			if(PT_IL_DEPOSIT_CHARGE_BEAN.getROWID() != null) {
				//if(isUPDATE_ALLOWED()) {
					delegate.preUpdate();
					//helper.pmAgentContestApplRankPreUpdate(PT_IL_DEPOSIT_CHARGE_BEAN);
				    new CRUDHandler().executeUpdate(PT_IL_DEPOSIT_CHARGE_BEAN, CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {

				/*if(isINSERT_ALLOWED()) {*/
					
					delegate.preInsert();
					//helper.pmAgentContestApplRankPreInsert(PT_IL_DEPOSIT_CHARGE_BEAN);
					new CRUDHandler().executeInsert(PT_IL_DEPOSIT_CHARGE_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					fetchList.add(PT_IL_DEPOSIT_CHARGE_BEAN);
					
				} 
			resetAllComponent();
			resetSelectedRow();
			PT_IL_DEPOSIT_CHARGE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public void populateBlockDEPOSIT_CHARGE() {
		//get details from database for the block
		PT_IL_DEPOSIT_CHARGE_DELEGATE delegate= new PT_IL_DEPOSIT_CHARGE_DELEGATE();
		 
		composite_action.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().setFetchList(delegate.getBlockDataForDEPOSIT_CHARGE());
		try {
			new PT_IL_TOP_UP_HELPER().isFundAllocationCompleted(composite_action);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String saveButtonClickAction(){
		
		String returnString = "";
		String message = null;
		try {
			message = Messages.getString("messageProperties",
			"errorPanel$message$save");
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("commkey", "Error on commit, cause: "+e.getMessage());
			getErrorMap().put("current", "Error on commit");
		}
		return returnString;
	}
	
	public List<LovBean> lovDCHRG_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_DEPOSIT_CHARGE",
					"DCHRG_CODE","IL_CHARGE", null, null, null, null,
					(String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}
	
	public void setErrorMessagesInMap(ActionEvent event){
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	
	public void validateDCHRG_CODE(FacesContext context, UIComponent component, Object value) {
		String currValue = (String) value;
		String beanValue = PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_CODE();
		try {
			PT_IL_DEPOSIT_CHARGE_BEAN.setUI_M_CHARGE_DESC(new DBProcedures().
					P_VAL_CODES("IL_CHARGE", (String) value, "L", "E", null).get(0));
			if(!(currValue.equalsIgnoreCase(beanValue))){
			new PT_IL_DEPOSIT_CHARGE_DELEGATE().IL_UNIQUE_CHRG_CODE(PT_IL_DEPOSIT_CHARGE_BEAN,currValue);
			PT_IL_DEPOSIT_CHARGE_BEAN.setDCHRG_CODE((String) value);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateDCHRG_RATE(FacesContext context ,UIComponent component,Object value){
		try{
			PT_IL_DEPOSIT_CHARGE_BEAN.setDCHRG_RATE((Double)value);
			new PT_IL_DEPOSIT_CHARGE_DELEGATE().validateDCHRG_RATE(PT_IL_DEPOSIT_CHARGE_BEAN, 
					composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN());
			COMP_UI_M_DCHRG_TOTAL_LC_AMT.resetValue();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDCHRG_RATE_PER(FacesContext context ,UIComponent component,Object value){
		try{
			PT_IL_DEPOSIT_CHARGE_BEAN.setDCHRG_RATE_PER((Double)value);
			new PT_IL_DEPOSIT_CHARGE_DELEGATE().calcLcAmt(composite_action.getPT_IL_TOP_UP_ACTION_BEAN(),PT_IL_DEPOSIT_CHARGE_BEAN);
			COMP_UI_M_DCHRG_TOTAL_LC_AMT.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCalcType(FacesContext context ,UIComponent component ,Object value){
		try{
			String obValue = (String)value;
			if("F".equals(obValue)){
				COMP_DCHRG_RATE.setDisabled(true);
				COMP_DCHRG_RATE_PER.setDisabled(true);
			}else{
				COMP_DCHRG_RATE.setDisabled(false);
				COMP_DCHRG_RATE_PER.setDisabled(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void calcHeaderNetAmount(){
		Double depAmt = composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT();
		Double netAmt = 0.0;
		Double sumLcChargeAmt = 0.0;
		populateBlockDEPOSIT_CHARGE();
		for(PT_IL_DEPOSIT_CHARGE chargeBean : fetchList){
			sumLcChargeAmt = sumLcChargeAmt + CommonUtils.nvl(chargeBean.getUI_M_DCHRG_TOTAL_LC_AMT(),0);
			System.out.println("lc amount ----->"+chargeBean.getUI_M_DCHRG_TOTAL_LC_AMT());
		}
		netAmt = depAmt - sumLcChargeAmt;
		System.out.println("lc amount ----->"+netAmt);
		composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setTU_LC_TOPUP_CHRG_AMT(sumLcChargeAmt);
		composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setTU_LC_TOPUP_NET_AMT(netAmt);
		System.out.println("Total Sum ----->"+sumLcChargeAmt);
		CommonUtils.setGlobalObject("TOp_UP_LX", sumLcChargeAmt);
		composite_action.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().setFetchList(new PT_IL_DEPOSIT_CHARGE_DELEGATE().getBlockDataForDEPOSIT_CHARGE());
	}
	
	
	public List<SelectItem> getListSelect() {
		return listSelect;
	}

	public void setListSelect(List<SelectItem> listSelect) {
		this.listSelect = listSelect;
	}

	public PILT027_COMPOSITE_ACTION getComposite_action() {
		return composite_action;
	}

	public void setComposite_action(PILT027_COMPOSITE_ACTION composite_action) {
		this.composite_action = composite_action;
	}

	public HtmlOutputLabel getCOMP_DCHRG_RATE_PER_LABEL() {
		return COMP_DCHRG_RATE_PER_LABEL;
	}

	public void setCOMP_DCHRG_RATE_PER_LABEL(
			HtmlOutputLabel comp_dchrg_rate_per_label) {
		COMP_DCHRG_RATE_PER_LABEL = comp_dchrg_rate_per_label;
	}

	public HtmlInputText getCOMP_DCHRG_RATE_PER() {
		return COMP_DCHRG_RATE_PER;
	}

	public void setCOMP_DCHRG_RATE_PER(HtmlInputText comp_dchrg_rate_per) {
		COMP_DCHRG_RATE_PER = comp_dchrg_rate_per;
	}

	public HtmlOutputLabel getCOMP_DCHRG_FLEX_01_LABEL() {
		return COMP_DCHRG_FLEX_01_LABEL;
	}

	public void setCOMP_DCHRG_FLEX_01_LABEL(HtmlOutputLabel comp_dchrg_flex_01_label) {
		COMP_DCHRG_FLEX_01_LABEL = comp_dchrg_flex_01_label;
	}

	public HtmlSelectOneMenu getCOMP_DCHRG_FLEX_01() {
		return COMP_DCHRG_FLEX_01;
	}

	public void setCOMP_DCHRG_FLEX_01(HtmlSelectOneMenu comp_dchrg_flex_01) {
		COMP_DCHRG_FLEX_01 = comp_dchrg_flex_01;
	}

	/*public String toString(double d ){
		
		return s;
	}*/
	

	/**
	 * Disables all components in PT_IL_DEPOSIT_CHARGE_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_DCHRG_CODE.setDisabled(disabled);
		COMP_UI_M_CHARGE_DESC.setDisabled(disabled);
		COMP_DCHRG_RATE.setDisabled(disabled);
		COMP_DCHRG_RATE_PER.setDisabled(disabled);
		COMP_UI_M_DCHRG_TOTAL_LC_AMT.setDisabled(disabled);
		COMP_UI_M_BUT_SAVE.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_DCHRG_FLEX_01.setDisabled(disabled);
		this.setINSERT_ALLOWED(false);
		this.setUPDATE_ALLOWED(false);
		this.setDELETE_ALLOWED(false);
	}


	/**
	 * Instantiates all components in PT_IL_DEPOSIT_CHARGE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DCHRG_CODE					 = new HtmlInputText();
		COMP_UI_M_CHARGE_DESC				 = new HtmlInputText();
		COMP_DCHRG_RATE					 = new HtmlInputText();
		COMP_DCHRG_RATE_PER				 = new HtmlInputText();
		COMP_UI_M_DCHRG_TOTAL_LC_AMT			 = new HtmlInputText();
		COMP_UI_M_BUT_SAVE = new HtmlCommandLink();
		// Instantiating HtmlSelectOneMenu
		COMP_DCHRG_FLEX_01				 = new HtmlSelectOneMenu();

	}

	public HtmlCommandLink getCOMP_UI_M_BUT_SAVE() {
		return COMP_UI_M_BUT_SAVE;
	}

	public void setCOMP_UI_M_BUT_SAVE(HtmlCommandLink comp_ui_m_but_save) {
		COMP_UI_M_BUT_SAVE = comp_ui_m_but_save;
	}


	
}

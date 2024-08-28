package com.iii.pel.forms.PILT027;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FUND_DETAIL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TOFD_FUND_CODE_LABEL;

	private HtmlInputText COMP_TOFD_FUND_CODE;

	private HtmlInputText COMP_M_FUND_DESC;

	private HtmlOutputLabel COMP_TOFD_FUND_PERC_LABEL;

	private HtmlInputText COMP_TOFD_FUND_PERC;

	private HtmlOutputLabel COMP_TOFD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TOFD_EFF_FM_DT;
	
	private HtmlOutputLabel COMP_TOFD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TOFD_EFF_TO_DT;

	private PT_IL_FUND_DETAIL PT_IL_FUND_DETAIL_BEAN;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlCommandLink COMP_UI_M_BUT_SAVE;
	
	private UIData chargeTable;
	
	private List<PT_IL_FUND_DETAIL> fetchList;
	
	public PILT027_COMPOSITE_ACTION composite_action;
	
	List<PT_IL_FUND_DETAIL> dataList=new ArrayList<PT_IL_FUND_DETAIL>();
	
	public PT_IL_FUND_DETAIL_HELPER helper;

	public List<PT_IL_FUND_DETAIL> getDataList() {
		return dataList;
	}

	public void setDataList(List<PT_IL_FUND_DETAIL> dataList) {
		this.dataList = dataList;
	}

	public PT_IL_FUND_DETAIL_ACTION() {
		helper = new PT_IL_FUND_DETAIL_HELPER();
		PT_IL_FUND_DETAIL_BEAN = new PT_IL_FUND_DETAIL();
		fetchList = new ArrayList<PT_IL_FUND_DETAIL>();
		COMP_TOFD_FUND_CODE=new HtmlInputText();
		COMP_M_FUND_DESC=new HtmlInputText();
		COMP_TOFD_FUND_PERC=new HtmlInputText();
		COMP_TOFD_EFF_FM_DT=new HtmlCalendar();
		COMP_TOFD_EFF_TO_DT=new HtmlCalendar();
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
		String returnString = null;
		try{
			chkFundPerc();
			returnString="GO_TO_PILT027_PT_IL_TOP_UP";
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return returnString;
	}
	
	
	public void chkFundPerc() throws Exception{
		Double sumperc = 0.0;
		try{
			for(PT_IL_FUND_DETAIL fundBean : fetchList){
				sumperc  = sumperc + fundBean.getTOFD_FUND_PERC();
			}
			if(sumperc > 100.0 || sumperc < 100){
				throw new Exception("The Fund Percentage must be 100 % .");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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

	public UIData getChargeTable() {
		return chargeTable;
	}

	public void setChargeTable(UIData chargeTable) {
		this.chargeTable = chargeTable;
	}

	public List<PT_IL_FUND_DETAIL> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PT_IL_FUND_DETAIL> fetchList) {
		this.fetchList = fetchList;
	}
	
	
	public void getDetails(ActionEvent event) {
		try {
			int rowIndex = chargeTable.getRowIndex();
			if (fetchList.size() != 0) {
				PT_IL_FUND_DETAIL_BEAN = (PT_IL_FUND_DETAIL) chargeTable.getRowData();
				//resetRowSelection();
				resetSelectedRow();
				PT_IL_FUND_DETAIL_BEAN.setRowSelected(true);
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
			PT_IL_FUND_DETAIL_BEAN=null;
			if (isINSERT_ALLOWED()){		
				PT_IL_FUND_DETAIL_DELEGATE delegate= new PT_IL_FUND_DETAIL_DELEGATE();
				PT_IL_FUND_DETAIL_BEAN = new PT_IL_FUND_DETAIL();
				
				delegate.setPolDetails(this.PT_IL_FUND_DETAIL_BEAN);
				
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
		
		    COMP_TOFD_FUND_CODE.resetValue();
			COMP_M_FUND_DESC.resetValue();
			COMP_TOFD_FUND_PERC.resetValue();
			COMP_TOFD_EFF_FM_DT.resetValue();
			COMP_TOFD_EFF_TO_DT.resetValue(); 
	}
	 
	 public HtmlOutputLabel getCOMP_TOFD_FUND_CODE_LABEL() {
		return COMP_TOFD_FUND_CODE_LABEL;
	}




	public void setCOMP_TOFD_FUND_CODE_LABEL(
			HtmlOutputLabel comp_tofd_fund_code_label) {
		COMP_TOFD_FUND_CODE_LABEL = comp_tofd_fund_code_label;
	}




	public HtmlInputText getCOMP_TOFD_FUND_CODE() {
		return COMP_TOFD_FUND_CODE;
	}




	public void setCOMP_TOFD_FUND_CODE(HtmlInputText comp_tofd_fund_code) {
		COMP_TOFD_FUND_CODE = comp_tofd_fund_code;
	}




	public HtmlInputText getCOMP_M_FUND_DESC() {
		return COMP_M_FUND_DESC;
	}




	public void setCOMP_M_FUND_DESC(HtmlInputText comp_m_fund_desc) {
		COMP_M_FUND_DESC = comp_m_fund_desc;
	}




	public HtmlOutputLabel getCOMP_TOFD_FUND_PERC_LABEL() {
		return COMP_TOFD_FUND_PERC_LABEL;
	}




	public void setCOMP_TOFD_FUND_PERC_LABEL(
			HtmlOutputLabel comp_tofd_fund_perc_label) {
		COMP_TOFD_FUND_PERC_LABEL = comp_tofd_fund_perc_label;
	}




	public HtmlInputText getCOMP_TOFD_FUND_PERC() {
		return COMP_TOFD_FUND_PERC;
	}




	public void setCOMP_TOFD_FUND_PERC(HtmlInputText comp_tofd_fund_perc) {
		COMP_TOFD_FUND_PERC = comp_tofd_fund_perc;
	}




	public HtmlOutputLabel getCOMP_TOFD_EFF_FM_DT_LABEL() {
		return COMP_TOFD_EFF_FM_DT_LABEL;
	}




	public void setCOMP_TOFD_EFF_FM_DT_LABEL(
			HtmlOutputLabel comp_tofd_eff_fm_dt_label) {
		COMP_TOFD_EFF_FM_DT_LABEL = comp_tofd_eff_fm_dt_label;
	}




	public HtmlCalendar getCOMP_TOFD_EFF_FM_DT() {
		return COMP_TOFD_EFF_FM_DT;
	}




	public void setCOMP_TOFD_EFF_FM_DT(HtmlCalendar comp_tofd_eff_fm_dt) {
		COMP_TOFD_EFF_FM_DT = comp_tofd_eff_fm_dt;
	}




	public HtmlOutputLabel getCOMP_TOFD_EFF_TO_DT_LABEL() {
		return COMP_TOFD_EFF_TO_DT_LABEL;
	}




	public void setCOMP_TOFD_EFF_TO_DT_LABEL(
			HtmlOutputLabel comp_tofd_eff_to_dt_label) {
		COMP_TOFD_EFF_TO_DT_LABEL = comp_tofd_eff_to_dt_label;
	}




	public HtmlCalendar getCOMP_TOFD_EFF_TO_DT() {
		return COMP_TOFD_EFF_TO_DT;
	}




	public void setCOMP_TOFD_EFF_TO_DT(HtmlCalendar comp_tofd_eff_to_dt) {
		COMP_TOFD_EFF_TO_DT = comp_tofd_eff_to_dt;
	}




	private void resetSelectedRow() {
			Iterator<PT_IL_FUND_DETAIL> iterator = fetchList.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}

	public void deleteRow(ActionEvent ae) {
			
			try{
				getErrorMap().clear();
				getWarningMap().clear();

				if(isDELETE_ALLOWED()) {
					if(PT_IL_FUND_DETAIL_BEAN.getROWID() != null) {
						//executeDelete(PM_CUST_DIVN_BEAN);
						new CRUDHandler().executeDelete(PT_IL_FUND_DETAIL_BEAN, CommonUtils.getConnection());
						fetchList.remove(PT_IL_FUND_DETAIL_BEAN);
					}
					
					if(fetchList.size() > 0) {
						setPT_IL_FUND_DETAIL_BEAN(fetchList.get(0));
						PT_IL_FUND_DETAIL_BEAN.setRowSelected(true);
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
		   PT_IL_FUND_DETAIL_DELEGATE delegate= new PT_IL_FUND_DETAIL_DELEGATE();
		   try{
			if(PT_IL_FUND_DETAIL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					//helper.pmAgentContestApplRankPreUpdate(PT_IL_FUND_DETAIL_BEAN);
					PT_IL_FUND_DETAIL_BEAN.setTOFD_TU_SYS_ID(composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_SYS_ID());
					PT_IL_FUND_DETAIL_BEAN.setTOFD_POL_SYS_ID(composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID());
				    new CRUDHandler().executeUpdate(PT_IL_FUND_DETAIL_BEAN, CommonUtils.getConnection());
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
					PT_IL_FUND_DETAIL_BEAN.setTOFD_TU_SYS_ID(composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_SYS_ID());
					PT_IL_FUND_DETAIL_BEAN.setTOFD_POL_SYS_ID(composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID());
					delegate.preInsert(this.PT_IL_FUND_DETAIL_BEAN);
					//helper.pmAgentContestApplRankPreInsert(PT_IL_FUND_DETAIL_BEAN);
					new CRUDHandler().executeInsert(PT_IL_FUND_DETAIL_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					fetchList.add(PT_IL_FUND_DETAIL_BEAN);
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_FUND_DETAIL_BEAN.setRowSelected(true);

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

	/*public void populateBlockDEPOSIT_CHARGE() {
		//get details from database for the block
		
		dataList=delegate.getBlockDataForDEPOSIT_CHARGE();
		helper.setPolDetails(PT_IL_FUND_DETAIL_BEAN);
		System.out.println("size of list-------------"+dataList.size());
		//Populate the block
		String mappedBeanName="PILT027_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT027_COMPOSITE_ACTION compositeActionBean=
			(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN().setFetchList(dataList);
	
	}*/
	
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				CommonUtils.clearMaps(this);
				helper.preQuery(PT_IL_FUND_DETAIL_BEAN);
				 helper.executeQuery(composite_action );
				helper.setPolDetails(PT_IL_FUND_DETAIL_BEAN);
				this.setFetchList(dataList);
				setBlockFlag(false);
			}
			new PT_IL_TOP_UP_HELPER().isFundAllocationCompleted(composite_action);
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	
	public String saveButtonClickAction(){
		
		String returnString = "";
		String message = null;
		try {
			message = Messages.getString("messageProperties",
			"errorPanel$message$save");

			 /*Added by Janani on 11.10.2018 for KIC 
			  issue : Top Up - The fund choice needs to be editable…currently its default and min 10% has to be in liq fund
			  * 
			  * 
			  * */
			new CRUDHandler().executeUpdate(PT_IL_FUND_DETAIL_BEAN,
					CommonUtils.getConnection());
			/*End*/
			
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
	
	public List<LovBean> lovFUND_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOPUP_FUND_DTL",
					"TOFD_FUND_CODE",PT_IL_FUND_DETAIL_BEAN.getM_POL_PROD_CODE(), "P", null, null, null,
					(String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("TOFD_FUND_CODE", e.getMessage());
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

	public PT_IL_FUND_DETAIL getPT_IL_FUND_DETAIL_BEAN() {
		return PT_IL_FUND_DETAIL_BEAN;
	}

	public void setPT_IL_FUND_DETAIL_BEAN(PT_IL_FUND_DETAIL pt_il_fund_detail_bean) {
		PT_IL_FUND_DETAIL_BEAN = pt_il_fund_detail_bean;
	}

	public void navigate_to_Fund_Details() {
		//get details from database for the block
		PT_IL_FUND_DETAIL_DELEGATE delegate= new PT_IL_FUND_DETAIL_DELEGATE();
		List<PT_IL_FUND_DETAIL> dataList=new ArrayList<PT_IL_FUND_DETAIL>();
		//dataList=delegate.getBlockDataForDEPOSIT_CHARGE();
		System.out.println("size of list-------------"+dataList.size());
		//Populate the block
		String mappedBeanName="PILT027_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT027_COMPOSITE_ACTION compositeActionBean=
			(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN().setFetchList(dataList);
	
	}
	
	
	
	public void validateFUND_CODE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		if (null != value) {
			PT_IL_FUND_DETAIL_BEAN.setTOFD_FUND_CODE(value.toString());
		}
		PT_IL_FUND_DETAIL_HELPER helper = new PT_IL_FUND_DETAIL_HELPER();
		helper.when_validate_tu_cust_code();
	}
	
	public void validateTOFD_FUND_PERC(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		if (null != value) {
			
			Integer fundPerc=Integer.parseInt(value.toString());
			PT_IL_FUND_DETAIL_BEAN.setTOFD_FUND_PERC(fundPerc);
		}
		PT_IL_FUND_DETAIL_HELPER helper = new PT_IL_FUND_DETAIL_HELPER();
		helper.when_validate_tofd_fund_perc();
	}
	
	
	public void TOFD_EFF_FM_DT_VALIDATOR(FacesContext fc, UIComponent component,
			Object value) {
		Date tempDate = null;

		if (null != value) {
			tempDate = (Date) value;
			PT_IL_FUND_DETAIL_BEAN.setTOFD_EFF_FM_DT(tempDate);
		}
		
	}

	
	
	public void TOFD_EFF_TO_DT_VALIDATOR(FacesContext fc, UIComponent component,
			Object value) {
		getErrorMap().clear();
		String message = null;
		Date tempDate = null;

		if (null != value) {
			tempDate = (Date) value;
			PT_IL_FUND_DETAIL_BEAN.setTOFD_EFF_TO_DT(tempDate);
		}
		Date d1 = PT_IL_FUND_DETAIL_BEAN.getTOFD_EFF_FM_DT();
		Date d2 = PT_IL_FUND_DETAIL_BEAN.getTOFD_EFF_TO_DT();
		Date d3 = PT_IL_FUND_DETAIL_BEAN.getM_POL_EXPIRY_DT();
		try {

			if (null != d1 && null != d2) {
				int results = d1.compareTo(d2);
				if (results > 0) {
					message = Messages.getString(
							PELConstants.pelErrorMessagePath, "91001");
					throw new ValidatorException(new FacesMessage(message));
				}
			}
			
			if(null != d2 && null != d3){
				int results = d2.compareTo(d3);
				if (results > 0) {
					message = Messages.getString(
							PELConstants.pelErrorMessagePath, "71196");
					throw new ValidatorException(new FacesMessage(message));
				}
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}


	/**
	 * Disables all components in PT_IL_FUND_DETAIL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_TOFD_FUND_CODE.setDisabled(disabled);
		COMP_M_FUND_DESC.setDisabled(disabled);
		COMP_TOFD_FUND_PERC.setDisabled(disabled);
		//COMP_UI_M_BUT_SAVE.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_TOFD_EFF_FM_DT.setDisabled(disabled);
		COMP_TOFD_EFF_TO_DT.setDisabled(disabled);
		this.setINSERT_ALLOWED(false);
		this.setUPDATE_ALLOWED(false);
		this.setDELETE_ALLOWED(false);
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_SAVE() {
		return COMP_UI_M_BUT_SAVE;
	}

	public void setCOMP_UI_M_BUT_SAVE(HtmlCommandLink comp_ui_m_but_save) {
		COMP_UI_M_BUT_SAVE = comp_ui_m_but_save;
	}
	
}

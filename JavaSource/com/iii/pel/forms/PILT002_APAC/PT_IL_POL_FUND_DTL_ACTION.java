package com.iii.pel.forms.PILT002_APAC;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.taglib.html.jsp.AjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.b.a4;

public class PT_IL_POL_FUND_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POFD_FUND_CODE_LABEL;

	private HtmlInputText COMP_POFD_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FUND_DESC;

	private HtmlOutputLabel COMP_POFD_FUND_PERC_LABEL;

	private HtmlInputText COMP_POFD_FUND_PERC;

	private HtmlOutputLabel COMP_POFD_EFF_FM_DT_LABEL;
	
	private HtmlOutputLabel COMP_FUND_DTL_FORM_CAPTION;

	private HtmlCalendar COMP_POFD_EFF_FM_DT;

	private HtmlOutputLabel COMP_POFD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_POFD_EFF_TO_DT;

	private PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_FUND_DTL_HELPER helper;
	
	private HtmlCommandButton COMP_UI_M_BUT_MAIN_FUND;
	
	private HtmlCommandButton COMP_UI_M_BUT_TOP_UP;
	
	private HtmlCommandButton COMP_ADD;
	
	private HtmlCommandButton COMP_DEL;
	
	private HtmlCommandButton COMP_POST;

	private List<PT_IL_POL_FUND_DTL> dataList_PT_IL_POL_FUND_DTL = new ArrayList<PT_IL_POL_FUND_DTL>();

	private UIData dataTable;

	public PT_IL_POL_FUND_DTL_ACTION() {

		PT_IL_POL_FUND_DTL_BEAN = new PT_IL_POL_FUND_DTL();
		helper = new PT_IL_POL_FUND_DTL_HELPER();
		instantiateAllComponent();
	}
	 
	public HtmlOutputLabel getCOMP_POFD_FUND_CODE_LABEL() {
		return COMP_POFD_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POFD_FUND_CODE() {
		return COMP_POFD_FUND_CODE;
	}

	public void setCOMP_POFD_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_POFD_FUND_CODE_LABEL) {
		this.COMP_POFD_FUND_CODE_LABEL = COMP_POFD_FUND_CODE_LABEL;
	}

	public void setCOMP_POFD_FUND_CODE(HtmlInputText COMP_POFD_FUND_CODE) {
		this.COMP_POFD_FUND_CODE = COMP_POFD_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FUND_DESC_LABEL() {
		return COMP_UI_M_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FUND_DESC() {
		return COMP_UI_M_FUND_DESC;
	}

	public void setCOMP_UI_M_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL) {
		this.COMP_UI_M_FUND_DESC_LABEL = COMP_UI_M_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_FUND_DESC(HtmlInputText COMP_UI_M_FUND_DESC) {
		this.COMP_UI_M_FUND_DESC = COMP_UI_M_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_POFD_FUND_PERC_LABEL() {
		return COMP_POFD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_POFD_FUND_PERC() {
		return COMP_POFD_FUND_PERC;
	}

	public void setCOMP_POFD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_POFD_FUND_PERC_LABEL) {
		this.COMP_POFD_FUND_PERC_LABEL = COMP_POFD_FUND_PERC_LABEL;
	}

	public void setCOMP_POFD_FUND_PERC(HtmlInputText COMP_POFD_FUND_PERC) {
		this.COMP_POFD_FUND_PERC = COMP_POFD_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_POFD_EFF_FM_DT_LABEL() {
		return COMP_POFD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POFD_EFF_FM_DT() {
		return COMP_POFD_EFF_FM_DT;
	}

	public void setCOMP_POFD_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_POFD_EFF_FM_DT_LABEL) {
		this.COMP_POFD_EFF_FM_DT_LABEL = COMP_POFD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_POFD_EFF_FM_DT(HtmlCalendar COMP_POFD_EFF_FM_DT) {
		this.COMP_POFD_EFF_FM_DT = COMP_POFD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POFD_EFF_TO_DT_LABEL() {
		return COMP_POFD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POFD_EFF_TO_DT() {
		return COMP_POFD_EFF_TO_DT;
	}

	public void setCOMP_POFD_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_POFD_EFF_TO_DT_LABEL) {
		this.COMP_POFD_EFF_TO_DT_LABEL = COMP_POFD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_POFD_EFF_TO_DT(HtmlCalendar COMP_POFD_EFF_TO_DT) {
		this.COMP_POFD_EFF_TO_DT = COMP_POFD_EFF_TO_DT;
	}

	public PT_IL_POL_FUND_DTL getPT_IL_POL_FUND_DTL_BEAN() {
		return PT_IL_POL_FUND_DTL_BEAN;
	}

	public void setPT_IL_POL_FUND_DTL_BEAN(
			PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_BEAN) {
		this.PT_IL_POL_FUND_DTL_BEAN = PT_IL_POL_FUND_DTL_BEAN;
	}

	public List<PT_IL_POL_FUND_DTL> getDataList_PT_IL_POL_FUND_DTL() {
		return dataList_PT_IL_POL_FUND_DTL;
	}

	public void setDataListPT_IL_POL_FUND_DTL(
			List<PT_IL_POL_FUND_DTL> dataList_PT_IL_POL_FUND_DTL) {
		this.dataList_PT_IL_POL_FUND_DTL = dataList_PT_IL_POL_FUND_DTL;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_FUND_DTL_BEAN = new PT_IL_POL_FUND_DTL();
				helper.WHEN_CREATE_RECORD(compositeAction);
				resetAllComponent();
				resetSelectedRow();
				/*Modified by pidugu raj dt: 26-08-2018 for KICLIFEQC-1762429*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("G01") || compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("G02")){
				disableAllComponent(false);
				/*End by pidugu rat dt: 26-08-2018 KICLIFEQC-1762429*/
				}
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed");
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PT_IL_POL_FUND_DTL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				getWarningMap().put("deleteRow",message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				dataList_PT_IL_POL_FUND_DTL.remove(PT_IL_POL_FUND_DTL_BEAN);
				if (dataList_PT_IL_POL_FUND_DTL.size() > 0) {
					PT_IL_POL_FUND_DTL_BEAN = dataList_PT_IL_POL_FUND_DTL.get(0);
				} else if (dataList_PT_IL_POL_FUND_DTL.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_POL_FUND_DTL_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
				getErrorMap().put("deleteRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
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
			if (PT_IL_POL_FUND_DTL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				
				helper.fundPercentageCheck(compositeAction);
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PT_IL_POL_FUND_DTL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
				dataList_PT_IL_POL_FUND_DTL.add(PT_IL_POL_FUND_DTL_BEAN);
			} else if (PT_IL_POL_FUND_DTL_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.fundPercentageCheck(compositeAction);
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_POL_FUND_DTL_BEAN,CommonUtils.getConnection());
				message =  Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
			}
			PT_IL_POL_FUND_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
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
			PT_IL_POL_FUND_DTL_BEAN = (PT_IL_POL_FUND_DTL) dataTable.getRowData();
			helper.POST_QUERY(compositeAction);
			//helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
			PT_IL_POL_FUND_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_FUND_DTL> PT_IL_POL_FUND_DTL_ITR = dataList_PT_IL_POL_FUND_DTL.iterator();
		while (PT_IL_POL_FUND_DTL_ITR.hasNext()) {
			PT_IL_POL_FUND_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POFD_FUND_CODE.resetValue();
		COMP_UI_M_FUND_DESC.resetValue();
		COMP_POFD_FUND_PERC.resetValue();
		COMP_POFD_EFF_FM_DT.resetValue();
		COMP_POFD_EFF_TO_DT.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
 		String message = null;
 		double fundTotal = 0.0;
		try {
			//As discussed with siva sir ,added by gopi for kic 29/01/19
			for(int i = 0;i<compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().size();i++){
				PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_val = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().get(i);
				fundTotal += PT_IL_POL_FUND_DTL_val.getPOFD_FUND_PERC();
				System.out.println(" fundTotal >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fundTotal);
				if(fundTotal>100){
					throw new Exception("Fund allocation percentage should not be more than 100");
				}
				
			}
			if(fundTotal<100)
			{
				throw new Exception("Fund allocation percentage should not be less than 100");
			}
			//end
			
			
			/*Added by Janani on 04.04.2018 for KIC Fund issue*/
			//As discussed with siva sir below postrecord commanted by gopi for kic 29/01/19
			//postRecord(null);
			/*End*/	
			
			/*Added by pidugu raj dt: 03-09-2018 for KICLIFEQC-1763231*/
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(false);
			/*End Added by pidugu raj dt: 03-09-2018 for KICLIFEQC-1763231*/
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,message);
			/*Added by Sivarajan on 17/11/2019 for SARWA IL*/
			 //helper.executeQuery(compositeAction);
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public List<LovBean> lovPOFD_FUND_CODE(Object obj) throws Exception {
        	ArrayList<LovBean> suggestionList = null;
        
        	String currentValue = (String) obj;
        	String lovQuery = "SELECT FS_CODE,FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE "
        		+ "IN (SELECT PAF_FUND_CODE  FROM PM_IL_PROD_APPL_FUND WHERE PAF_PROD_CODE= ? "
        		+ "AND PAF_FUND_DIR_TYPE='P')  AND (FS_CODE LIKE ? OR  FS_DESC LIKE ? ) AND ROWNUM < 25 ORDER BY 1 ";
        
        	currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
        	Object[] value = {
        		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
        			.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),
        		currentValue, currentValue };
        	try {
        	    suggestionList = ListItemUtil
        		    .prepareSuggestionList(lovQuery, value);
        
        	} catch (Exception e) {
        
        	}
        	return suggestionList;
    }

	public void validatePOFD_FUND_CODE(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_FUND_CODE((String) value);
			/*Newly Added by pidugu raj dt: 27-08-2018 KICLIFEQC-1762429*/
			PT_IL_POL_FUND_DTL pT_IL_POL_FUND_DTL = helper.POFD_FUND_CODE_WHEN_VALIDATE_ITEM( compositeAction, (String) value);
			if(pT_IL_POL_FUND_DTL.getPOFD_EFF_FM_DT() != null){
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_FM_DT(pT_IL_POL_FUND_DTL.getPOFD_EFF_FM_DT());
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_TO_DT(pT_IL_POL_FUND_DTL.getPOFD_EFF_TO_DT());
			}
			/*End Added by pidugu raj dt: 27-08-2018 KICLIFEQC-1762429*/
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_FUND_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validatePOFD_FUND_PERC(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_FUND_PERC((Double) value);
			/*
			 * modified by Ameen on 15-03-2018 to have overall total 100 as per Siva sugg. 
			 * helper.POFD_FUND_PERC_WHEN_VALIDATE_ITEM((Double) value);*/
			/*Newly added by pidugu raj dt: 20-11-2018 for handling liquid fund value*/
			String IL_FUND_VAL = CommonUtils.getPPSystemParameterValue("IL_FUND_VAL").toString();
			int fundParameterValue = Integer.valueOf(IL_FUND_VAL);
			if(PT_IL_POL_FUND_DTL_BEAN.getPOFD_FUND_CODE().equalsIgnoreCase("LIQUID FUND") && (PT_IL_POL_FUND_DTL_BEAN.getPOFD_FUND_PERC().equals(0.0) || PT_IL_POL_FUND_DTL_BEAN.getPOFD_FUND_PERC() < fundParameterValue )){
				
				throw new Exception("Liquid fund allocated percentage should not be less than "+fundParameterValue+"%");
			}
			
			/*End Newly added by pidugu raj dt: 20-11-2018 for handling liquid fund value*/
			/*As discussed with siva and sree Commanted by gopi for kic on 29/01/19*/
			/*helper.POFD_FUND_PERC_WHEN_VALIDATE_ITEM((Double) value,compositeAction);*/
			//end
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_FUND_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validatePOFD_EFF_FM_DT(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			//modified by gopi for toi 16/06/2018
			//Date curDate = (Date) value;
			Date policy_fm_date = (Date) value;
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String polFmdate = dateformate.format(policy_fm_date);
			Date policy_fm_dt = dateformate.parse(polFmdate);
			//PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_FM_DT(curDate);
			//helper.POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM( compositeAction, curDate);
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_FM_DT(policy_fm_dt);
			helper.POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM( compositeAction, policy_fm_dt);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_EFF_FM_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOFD_EFF_TO_DT(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			Date curDate = (Date) value;
			PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_TO_DT(curDate);
			helper.POFD_EFF_TO_DT_WHEN_VALIDATE_ITEM( compositeAction, curDate);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_EFF_TO_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void onLoad(PhaseEvent event) {
		/*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
		String allocQry = "SELECT ASD_FLAG FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE = 'CHG_FUND_PER'";
		ResultSet allocRS = null;
		String allocEn = "1";
		/*End*/
		try {
			
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_FUND_DTL_BEAN.getROWID()!=null){
					helper.POST_QUERY(compositeAction);
				}else{
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			helper.percEnableDisable(compositeAction);
			enableDisableForApproveCondition();
			//helper.executeQuery(compositeAction);
			/*Added by Ameen on 13-03-2018 for FSD_IL_04_GOLDA*/
			allocRS = new CRUDHandler().executeSelectStatement(allocQry, CommonUtils.getConnection());
			if(allocRS.next()){
				allocEn = allocRS.getString("ASD_FLAG");
			}
			
			if("2".equalsIgnoreCase(allocEn)){
				COMP_POFD_FUND_PERC.setDisabled(false);
			}else{
				COMP_POFD_FUND_PERC.setDisabled(true);
			}
			/*End*/
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	void enableDisableForApproveCondition() {

		if (("A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS()) || "Y"
				.equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())))
		{
			disableAllComponent(true);
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_FUND() {
		return COMP_UI_M_BUT_MAIN_FUND;
	}

	public void setCOMP_UI_M_BUT_MAIN_FUND(HtmlCommandButton comp_ui_m_but_main_fund) {
		COMP_UI_M_BUT_MAIN_FUND = comp_ui_m_but_main_fund;
	}

	public void setDataList_PT_IL_POL_FUND_DTL(
			List<PT_IL_POL_FUND_DTL> dataList_PT_IL_POL_FUND_DTL) {
		this.dataList_PT_IL_POL_FUND_DTL = dataList_PT_IL_POL_FUND_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TOP_UP() {
		return COMP_UI_M_BUT_TOP_UP;
	}

	public void setCOMP_UI_M_BUT_TOP_UP(HtmlCommandButton comp_ui_m_but_top_up) {
		COMP_UI_M_BUT_TOP_UP = comp_ui_m_but_top_up;
	}
	
	public String backToMain(){
		setBlockFlag(true);
		String  outCome = null;
		 outCome = "PILT002_APAC_PT_IL_POLICY";
		return outCome;
		
	}
	
	public String topUp(){
		String  outCome = null;
		 outCome = "PILT002_APAC_PT_IL_POL_FUND_DTL_1";
		return outCome;
	}
	


	/**
	 * Disables all components in PT_IL_POL_FUND_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POFD_FUND_CODE.setDisabled(disabled);
		COMP_UI_M_FUND_DESC.setDisabled(disabled);
		//COMP_POFD_FUND_PERC.setDisabled(disabled);
		// Disabling HtmlCalendar
		COMP_POFD_EFF_FM_DT.setDisabled(disabled);
		COMP_POFD_EFF_TO_DT.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_FUND_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POFD_FUND_CODE				 = new HtmlInputText();
		COMP_UI_M_FUND_DESC				 = new HtmlInputText();
		COMP_POFD_FUND_PERC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POFD_FUND_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FUND_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_FUND_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_EFF_FM_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_EFF_TO_DT_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCalendar
		COMP_POFD_EFF_FM_DT				 = new HtmlCalendar();
		COMP_POFD_EFF_TO_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_MAIN_FUND				 = new HtmlCommandButton();
		COMP_UI_M_BUT_TOP_UP				 = new HtmlCommandButton();

	}

	public HtmlOutputLabel getCOMP_FUND_DTL_FORM_CAPTION() {
	    return COMP_FUND_DTL_FORM_CAPTION;
	}

	public void setCOMP_FUND_DTL_FORM_CAPTION(
		HtmlOutputLabel comp_fund_dtl_form_caption) {
	    COMP_FUND_DTL_FORM_CAPTION = comp_fund_dtl_form_caption;
	}

	public void setCOMP_ADD(HtmlCommandButton comp_add) {
		COMP_ADD = comp_add;
	}

	public void setCOMP_DEL(HtmlCommandButton comp_del) {
		COMP_DEL = comp_del;
	}

	public void setCOMP_POST(HtmlCommandButton comp_post) {
		COMP_POST = comp_post;
	}

	public HtmlCommandButton getCOMP_ADD() {
		return COMP_ADD;
	}

	public HtmlCommandButton getCOMP_DEL() {
		return COMP_DEL;
	}

	public HtmlCommandButton getCOMP_POST() {
		return COMP_POST;
	}


}

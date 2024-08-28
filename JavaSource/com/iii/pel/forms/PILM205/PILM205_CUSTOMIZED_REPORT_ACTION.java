package com.iii.pel.forms.PILM205;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlInputTextarea;
import org.richfaces.component.html.HtmlTab;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM021_A.PP_SYSTEM_1;
import com.iii.pel.forms.PM023_A.PM_CUSTOMIZED_REPORT;
import com.iii.pel.forms.REPORT_CONFIG.PM_COMMON_RI_CONFIG_DTL;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_PROC_PARAMS;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_TAB_HDR;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

/**
 * @author 1001061
 *
 */
public class PILM205_CUSTOMIZED_REPORT_ACTION extends CommonReportAction implements
		Serializable {

	private static final long serialVersionUID = -4614917398669389317L;

	public PILM205_COMPOSITE_ACTION compositeAction;
	private PILM205_CUSTOMIZED_REPORT PILM205_CUSTOMIZED_REPORT_BEAN;
	private PILM205_CUSTOMIZED_REPORT_HELPER helper;
	private UIData dataTable;
	private UIData dataTable2;
	private UIData dataTable3;
	
	
	
	
	
	private List<PM_COMMON_RI_CONFIG_DTL> tableList = new ArrayList<PM_COMMON_RI_CONFIG_DTL>();
	private List<PM_REP_TAB_HDR> PM_REP_TAB_HDR_LIST = new ArrayList<PM_REP_TAB_HDR>();
	private List<PM_REP_PROC_PARAMS> PM_REP_PROC_PARAMS_LIST = new ArrayList<PM_REP_PROC_PARAMS>();
	private PM_COMMON_RI_CONFIG_DTL PM_COMMON_RI_CONFIG_DTL_BEAN;
	private PM_REP_TAB_HDR PM_REP_TAB_HDR_BEAN;
	private PM_REP_PROC_PARAMS PM_REP_PROC_PARAMS_BEAN;
	
	private HtmlCommandButton UI_M_BUT_ADD;
	private HtmlCommandButton UI_M_BUT_POST;
	private HtmlCommandButton UI_M_BUT_ADD_REP_TAB_HDR;
	private HtmlCommandButton UI_M_BUT_ADD_REP_PROC_PARAMS;
	private HtmlCommandButton UI_M_BUT_POST_REP_TAB_HDR;
	private HtmlCommandButton UI_M_BUT_POST_REP_PROC_PARAMS;
	private HtmlCommandButton UI_M_BUT_DELETE;
	private HtmlCommandButton UI_M_BUT_DELETE_REP_TAB_HDR;
	private HtmlCommandButton UI_M_BUT_DELETE_REP_PROC_PARAMS;
	
	private HtmlSelectOneMenu COMP_PARAM_TYPE;
	private HtmlOutputLabel COMP_REP_ID_LABEL;
	private HtmlOutputLabel COMP_PARAM_NAME_LABEL;
	private HtmlOutputLabel COMP_PARAM_ORDER_LABEL;
	private HtmlOutputLabel COMP_PARAM_LOV_QUERY_LABEL;
	private HtmlOutputLabel COMP_SRNO_LABEL;
	private HtmlOutputLabel COMP_PARAM_ID_LABEL;
	private HtmlOutputLabel COMP_PARAM_IP_REP_COL_LABEL;
	private HtmlOutputLabel COMP_UI_PARAM_IP_REP_COL_LABEL;
	private HtmlOutputLabel COMP_PARM_FROMTO_REL_LABEL;
	private HtmlOutputLabel COMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL;
	private HtmlOutputLabel COMP_PARAM_DEPEND_COL_LABEL;
	private HtmlOutputLabel COMP_PMRTH_SR_NUM_LABEL;
	private HtmlOutputLabel COMP_PMRTH_MODULE_ID_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REP_NAME_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REP_CATG_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REP_ID_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REP_TEMP_NAME_ID_LABEL;
	private HtmlOutputLabel COMP_PMRTH_CONN_REQD_LABEL;
	private HtmlOutputLabel COMP_PMRTH_PROC_REQD_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REPORT_CATG_LABEL;
	private HtmlOutputLabel COMP_PMRTH_SR_NO_LABEL;
	private HtmlOutputLabel COMP_PMRTH_REP_IDEN_LABEL;
	private HtmlOutputLabel COMP_PMRTH_PROC_NAME_LABEL;
	private HtmlOutputLabel COMP_PMRTH_PARAM_TYPE_LABEL;
	private HtmlOutputLabel COMP_PMRTH_PARAM_DATATYPE_LABEL;
	private HtmlOutputLabel COMP_PARAM_TYPE_LABEL;
	private HtmlOutputLabel COMP_PM_REQUIRED_LABEL;
	
	
	
	private HtmlInputText COMP_REP_ID_TEXT;
	private HtmlInputText COMP_PARAM_NAME_TEXT;
	private HtmlSelectOneMenu COMP_PARAM_TYPE_TEXT;
	private HtmlInputText COMP_PARAM_ORDER_TEXT;
	private HtmlInputTextarea COMP_PARAM_LOV_QUERY_INPUT_TEXT;
	private HtmlInputText COMP_SRNO_TEXT;
	private HtmlInputText COMP_PARAM_ID_TEXT;
	private HtmlInputText COMP_UI_PARAM_IP_REP_COL_TEXT;
	private HtmlSelectOneMenu COMP_PARAM_TYPE_MENU ;
	private HtmlSelectOneMenu COMP_PARM_FROMTO_REL_MENU;
	private HtmlInputTextarea COMP_PARAM_DEPEN_ID_INPUT_TEXT;
	private HtmlInputText COMP_PARAM_DEPEND_COL_TEXT;
	private HtmlInputText COMP_PMRTH_SR_NUM_TEXT;
	private HtmlInputText COMP_PMRTH_MODULE_ID_TEXT;
	private HtmlInputText COMP_PMRTH_REP_NAME_TEXT;
	private HtmlSelectOneMenu COMP_PMRTH_REP_CATG_MENU;
	private HtmlInputText COMP_PMRTH_REP_ID_TEXT;
	private HtmlInputText COMP_PMRTH_REP_TEMP_NAME_ID_TEXT;
	private HtmlSelectOneMenu COMP_PMRTH_CONN_REQD_MENU;
	private HtmlSelectOneMenu COMP_PMRTH_PROC_REQD_MENU;
	private HtmlSelectOneMenu COMP_PMRTH_REPORT_CATG_MENU;
	private HtmlInputText COMP_PMRTH_SR_NO_TEXT;
	private HtmlInputText COMP_PMRTH_REP_IDEN_TEXT;
	private HtmlInputText COMP_PMRTH_PROC_NAME_TEXT;
	private HtmlSelectOneMenu COMP_PMRTH_PARAM_TYPE_TEXT;
	private HtmlInputText COMP_PMRTH_PARAM_DATATYPE_MENU;
	private HtmlInputText COMP_PARAM_IP_REP_COL_TEXT;
	
	private HtmlInputText COMP_PMRTH_PARAM_DATATYPE_DESC;
	
	
	
	
	private List<PP_SYSTEM_1> repCatgList = new ArrayList<PP_SYSTEM_1>();
	private List<SelectItem> repCatgSelectList = new ArrayList<SelectItem>();
	private List<SelectItem> repCatgSelectList1 = new ArrayList<SelectItem>();
	
	private HtmlTab COMP_REP_PROC_PARAMS;
	

	
	
	
	

	public PILM205_CUSTOMIZED_REPORT_ACTION() {
		PM_COMMON_RI_CONFIG_DTL_BEAN = new PM_COMMON_RI_CONFIG_DTL();
		PM_REP_TAB_HDR_BEAN = new PM_REP_TAB_HDR();
		PM_REP_PROC_PARAMS_BEAN = new PM_REP_PROC_PARAMS();
		helper = new PILM205_CUSTOMIZED_REPORT_HELPER();
		initiatecomponent();
	}
	
	public void instantiateAllComponent() {
		/*Intializing Output components*/
		COMP_REP_ID_TEXT = new HtmlInputText();
		UI_M_BUT_ADD = new HtmlCommandButton();
		UI_M_BUT_POST = new HtmlCommandButton();
		UI_M_BUT_DELETE = new HtmlCommandButton();
		UI_M_BUT_DELETE_REP_TAB_HDR = new HtmlCommandButton();
		UI_M_BUT_DELETE_REP_PROC_PARAMS = new HtmlCommandButton();
		
		UI_M_BUT_ADD_REP_TAB_HDR = new HtmlCommandButton();
		UI_M_BUT_ADD_REP_PROC_PARAMS = new HtmlCommandButton();
		UI_M_BUT_POST_REP_TAB_HDR = new HtmlCommandButton();
		UI_M_BUT_POST_REP_PROC_PARAMS = new HtmlCommandButton();
		
		COMP_PARAM_NAME_TEXT = new HtmlInputText();
		COMP_PARAM_TYPE = new HtmlSelectOneMenu();
		COMP_REP_ID_LABEL   = new HtmlOutputLabel();                                     
		COMP_PARAM_NAME_LABEL = new HtmlOutputLabel();
		COMP_PARAM_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PARAM_ORDER_LABEL = new HtmlOutputLabel();
		COMP_PARAM_LOV_QUERY_LABEL = new HtmlOutputLabel();
		COMP_SRNO_LABEL = new HtmlOutputLabel();
		COMP_PARAM_ID_LABEL = new HtmlOutputLabel();
		COMP_PARAM_IP_REP_COL_LABEL = new HtmlOutputLabel();
		COMP_UI_PARAM_IP_REP_COL_LABEL = new HtmlOutputLabel();
		COMP_PM_REQUIRED_LABEL = new HtmlOutputLabel();
		COMP_PARM_FROMTO_REL_LABEL = new HtmlOutputLabel();
		COMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL = new HtmlOutputLabel();
		COMP_PARAM_DEPEND_COL_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_SR_NUM_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_MODULE_ID_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_REP_NAME_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_REP_CATG_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_REP_ID_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_REP_TEMP_NAME_ID_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_CONN_REQD_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_PROC_REQD_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_REPORT_CATG_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_SR_NO_LABEL	 = new HtmlOutputLabel();
		COMP_PMRTH_REP_IDEN_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_PROC_NAME_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_PARAM_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PMRTH_PARAM_DATATYPE_LABEL = new HtmlOutputLabel();
		
		/*Intializing input components*/
		COMP_REP_ID_TEXT = new HtmlInputText();
		COMP_PARAM_NAME_TEXT = new HtmlInputText();
		COMP_PARAM_TYPE_TEXT = new HtmlSelectOneMenu();
		COMP_PARAM_ORDER_TEXT = new HtmlInputText();
		COMP_PARAM_LOV_QUERY_INPUT_TEXT = new HtmlInputTextarea();
		COMP_SRNO_TEXT = new HtmlInputText();
		COMP_PARAM_ID_TEXT = new HtmlInputText();
		COMP_UI_PARAM_IP_REP_COL_TEXT = new HtmlInputText();
		COMP_PARAM_TYPE_MENU = new HtmlSelectOneMenu();
		COMP_PARM_FROMTO_REL_MENU = new HtmlSelectOneMenu();
		COMP_PARAM_DEPEN_ID_INPUT_TEXT = new HtmlInputTextarea();
		COMP_PARAM_DEPEND_COL_TEXT = new HtmlInputText();
		COMP_PMRTH_SR_NUM_TEXT = new HtmlInputText();
		COMP_PMRTH_MODULE_ID_TEXT = new HtmlInputText();
		COMP_PMRTH_REP_NAME_TEXT = new HtmlInputText();
		COMP_PMRTH_REP_CATG_MENU = new HtmlSelectOneMenu();
		COMP_PMRTH_REP_ID_TEXT = new HtmlInputText();
		COMP_PMRTH_REP_TEMP_NAME_ID_TEXT = new HtmlInputText();
		COMP_PMRTH_CONN_REQD_MENU = new HtmlSelectOneMenu();
		COMP_PMRTH_PROC_REQD_MENU = new HtmlSelectOneMenu();
		COMP_PMRTH_REPORT_CATG_MENU = new HtmlSelectOneMenu();
		COMP_PMRTH_SR_NO_TEXT = new HtmlInputText();
		COMP_PMRTH_REP_IDEN_TEXT = new HtmlInputText();
		COMP_PMRTH_PROC_NAME_TEXT = new HtmlInputText();
		COMP_PMRTH_PARAM_TYPE_TEXT = new HtmlSelectOneMenu();
		COMP_PMRTH_PARAM_DATATYPE_MENU = new HtmlInputText();
		COMP_PARAM_IP_REP_COL_TEXT = new HtmlInputText();
		COMP_PMRTH_PARAM_DATATYPE_DESC = new HtmlInputText();
		COMP_REP_PROC_PARAMS = new HtmlTab();
	}
	
	
	public void onLoad(PhaseEvent phaseEvent){
		try{
			if(isBlockFlag()){
			
			PM_REP_TAB_HDR_LIST = helper.executeQueryForRepTabHdr(compositeAction);
			PM_REP_PROC_PARAMS_LIST = helper.executeQueryRepProcParams(compositeAction);
			tableList = helper.executeQuery(compositeAction);
			//repCatgList = helper.doGetRepCat();
			repCatgSelectList = ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "GNMNF003_A", "DUMMY",
					"DUMMY.M_REP_CATG", "IL_CATG");
			repCatgSelectList1 = ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "GNMNF003_A", "DUMMY",
					"DUMMY.M_REP_CATG1", "IL_CATG1");
			setBlockFlag(false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void saveRecord() {
		try {
			
			CommonUtils.getConnection().commit();
			compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().setROWID("");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString("messageProperties","errorPanel$message$save"));
			//getWarningMap().put("SAVE_RECORD", Messages.getString("messageProperties","errorPanel$message$save"));
			new FacesMessage(Messages.getString("messageProperties","errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	
	public ArrayList<com.iii.premia.common.bean.LovBean> doGetLovCustomReport(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			

			suggestionList = listitemutil.P_CALL_LOV("GNMNF003_A",
					"DUMMY", "M_DATA_TYPE", "IL_DATA_TYPE", null, null, null, null,
					(String) currValue);
			if(currValue == null || currValue.toString().isEmpty()){
				PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_DATATYPE_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	
	
	public void doValidateReportId(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setREP_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	
	public void doValidateReportParamName(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_NAME((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void doValidateParamType(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_TYPE((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void doValidateReportParamOrder(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ORDER((Integer)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidateSRNO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			/*String repId = PM_COMMON_RI_CONFIG_DTL_BEAN.getREP_ID();
			boolean srNoExist = false;
			srNoExist = helper.dovalidateSerialNumber(repId,(Integer)value);
			if(srNoExist == false){*/
			PM_COMMON_RI_CONFIG_DTL_BEAN.setSRNO((Integer)value);
		/*	}else{
				throw new ValidatorException(new FacesMessage("Serial Number Already exist for the report id, kindly enter new serial number"));
			}*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePARAM_ID(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePARAM_IP_REP_COL(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_IP_REP_COL((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidateUI_PARAM_IP_REP_COL(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setUI_PARAM_IP_REP_COL((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePM_REQUIRED(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePARM_FROMTO_REL(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARM_FROMTO_REL((Integer)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePARAM_DEPEN_ID(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEN_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePARAM_DEPEND_COL(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEND_COL((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_SR_NUM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_SR_NO((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePMRTH_MODULE_ID(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_MODULE_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePMRTH_REP_NAME(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_NAME((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_REP_CATG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_CATG((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_REP_ID(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePMRTH_REP_TEMP_NAME_ID(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TEMP_NAME_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_CONN_REQD(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_PROC_REQD(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_PROC_REQD((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePMRTH_REPORT_CATG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_REPORT_CATG((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePMRTH_SR_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_TAB_HDR_BEAN.setPMRTH_SR_NO((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

public void doValidatePMRTH_REP_IDEN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_REP_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}


public void doValidatePMRTH_PROC_NAME(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PROC_NAME((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePMRTH_PARAM_TYPE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_TYPE((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}



public void doValidatePMRTH_PARAM_DATATYPE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_DATATYPE((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	
	
	
	
public void AddRow(ActionEvent event){
	try {
		getErrorMap().clear();
		getWarningMap().clear();
		
		if (isINSERT_ALLOWED()){	
		
			PM_COMMON_RI_CONFIG_DTL_BEAN = new PM_COMMON_RI_CONFIG_DTL();
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


public void AddRowForRePTabHdr(ActionEvent event){
	try {
		getErrorMap().clear();
		getWarningMap().clear();
		
		if (isINSERT_ALLOWED()){	
			PM_REP_TAB_HDR_BEAN = new PM_REP_TAB_HDR();
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



public void AddRowForRePRepProcParams(ActionEvent event){
	try {
		getErrorMap().clear();
		getWarningMap().clear();
		
		if (isINSERT_ALLOWED()){	
			PM_REP_PROC_PARAMS_BEAN = new PM_REP_PROC_PARAMS();
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
	
	
	
	
	
	
public void postRecord(ActionEvent event) {
	String message = null;
	try {
		if(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getREP_ID() != null){
			PM_COMMON_RI_CONFIG_DTL_BEAN = helper.getDetails(compositeAction);
			//PM_REP_TAB_HDR_BEAN = helper.getRepHeaderDetails(compositeAction);
		}
		if (PM_COMMON_RI_CONFIG_DTL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			//While First Time inserting the record check the same sr no exist if so throw error
			String repId = PM_COMMON_RI_CONFIG_DTL_BEAN.getREP_ID();
			boolean srNoExist = false;
			srNoExist = helper.dovalidateSerialNumber(repId,(Integer)PM_COMMON_RI_CONFIG_DTL_BEAN.getSRNO());
			if(srNoExist){
				throw new ValidatorException(new FacesMessage("Serial Number Already exist for the report id, kindly enter new serial number"));
			}else{
			new CRUDHandler().executeInsert(PM_COMMON_RI_CONFIG_DTL_BEAN, CommonUtils.getConnection());
			helper.postQuery(PM_COMMON_RI_CONFIG_DTL_BEAN);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
			tableList.add(PM_COMMON_RI_CONFIG_DTL_BEAN);
			}
		} else if (PM_COMMON_RI_CONFIG_DTL_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
			new CRUDHandler().executeUpdate(PM_COMMON_RI_CONFIG_DTL_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		}
		//CommonUtils.getConnection().commit();
		PM_COMMON_RI_CONFIG_DTL_BEAN.setRowSelected(true);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		CommonUtils.getConnection().commit();
		//getWarningMap().put("postRecord",message);

	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
	}

}	










public void postRecordForRepTabHdr(ActionEvent event) {
	String message = null;
	try {
		if(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_ID() != null){
			//PM_COMMON_RI_CONFIG_DTL_BEAN = helper.getDetails(compositeAction);
 			PM_REP_TAB_HDR_BEAN = helper.getRepHeaderDetails(compositeAction);
		}
		if (PM_REP_TAB_HDR_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			new CRUDHandler().executeInsert(PM_REP_TAB_HDR_BEAN, CommonUtils.getConnection());
			//helper.postQuery(PM_COMMON_RI_CONFIG_DTL_BEAN);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
			PM_REP_TAB_HDR_LIST.add(PM_REP_TAB_HDR_BEAN);
		}/*else if (PM_REP_TAB_HDR_BEAN.getPMRTH_REP_ID() != null && isINSERT_ALLOWED()) {
			new CRUDHandler().executeInsert(PM_REP_TAB_HDR_BEAN, CommonUtils.getConnection());
			//helper.postQuery(PM_COMMON_RI_CONFIG_DTL_BEAN);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
			PM_REP_TAB_HDR_LIST.add(PM_REP_TAB_HDR_BEAN);
		}*/
		
		
		else if (PM_REP_TAB_HDR_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
			new CRUDHandler().executeUpdate(PM_REP_TAB_HDR_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
	
		}
		//CommonUtils.getConnection().commit();
		PM_REP_TAB_HDR_BEAN.setRowSelected(true);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		CommonUtils.getConnection().commit();
		//getWarningMap().put("postRecord",message);

	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
	}

}	


public void postRecordForRepProcParams(ActionEvent event) {
	String message = null;
	try {
		
		if (PM_REP_PROC_PARAMS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			new CRUDHandler().executeInsert(PM_REP_PROC_PARAMS_BEAN, CommonUtils.getConnection());
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
			PM_REP_PROC_PARAMS_LIST.add(PM_REP_PROC_PARAMS_BEAN);
		}
		
		else if(PM_REP_PROC_PARAMS_BEAN.getROWID() != null && isUPDATE_ALLOWED()){
			new CRUDHandler().executeUpdate(PM_REP_PROC_PARAMS_BEAN, CommonUtils.getConnection());
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			
			
			
		}
			PM_REP_PROC_PARAMS_BEAN.setRowSelected(true);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		
		CommonUtils.getConnection().commit();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString("messageProperties","errorPanel$message$save"));
		new FacesMessage(Messages.getString("messageProperties","errorPanel$message$save"));

	} catch (Exception exc) {
		exc.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
	}

}	











	
	
	
	public void getDetails() {
		try {
			if (tableList != null && tableList.size() != 0) {
				PM_COMMON_RI_CONFIG_DTL_BEAN = (PM_COMMON_RI_CONFIG_DTL) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_COMMON_RI_CONFIG_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getDetailsForRepTabHdr() {
		try {
			if (PM_REP_TAB_HDR_LIST != null && PM_REP_TAB_HDR_LIST.size() != 0) {
				PM_REP_TAB_HDR_BEAN = (PM_REP_TAB_HDR) dataTable2
						.getRowData();
				if(PM_REP_TAB_HDR_BEAN.getPMRTH_PROC_REQD().equalsIgnoreCase("N")){
					COMP_REP_PROC_PARAMS.setDisabled(true);
				}else{
					COMP_REP_PROC_PARAMS.setDisabled(false);
				}
				PM_REP_PROC_PARAMS_BEAN.setPMRTH_REP_ID(PM_REP_TAB_HDR_BEAN.getPMRTH_REP_ID());
			}
			resetAllComponent();
			resetSelectedRowForRepTabHdr();
			PM_REP_TAB_HDR_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void getDetailsForRepProcParams() {
		try {
			if (PM_REP_PROC_PARAMS_LIST != null && PM_REP_PROC_PARAMS_LIST.size() != 0) {
				PM_REP_PROC_PARAMS_BEAN = (PM_REP_PROC_PARAMS) dataTable3
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRowForRepProcParams();
			PM_REP_PROC_PARAMS_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PM_COMMON_RI_CONFIG_DTL> iterator = tableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	
	
	private void resetSelectedRowForRepTabHdr() {
		Iterator<PM_REP_TAB_HDR> iterator = PM_REP_TAB_HDR_LIST.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	
	
	private void resetSelectedRowForRepProcParams() {
		Iterator<PM_REP_PROC_PARAMS> iterator = PM_REP_PROC_PARAMS_LIST.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	

	private void resetAllComponent() {
		COMP_REP_ID_TEXT.resetValue();
		COMP_PARAM_NAME_TEXT.resetValue();
		COMP_PARAM_TYPE_TEXT.resetValue();
		COMP_PARAM_ORDER_TEXT.resetValue();
		COMP_PARAM_LOV_QUERY_INPUT_TEXT.resetValue();
		COMP_SRNO_TEXT.resetValue();
		COMP_PARAM_ID_TEXT.resetValue();
		COMP_UI_PARAM_IP_REP_COL_TEXT.resetValue();
		COMP_PARAM_TYPE_MENU.resetValue();
		COMP_PARM_FROMTO_REL_MENU.resetValue();
		COMP_PARAM_DEPEN_ID_INPUT_TEXT.resetValue();
		COMP_PARAM_DEPEND_COL_TEXT.resetValue();
		COMP_PMRTH_SR_NUM_TEXT.resetValue();
		COMP_PMRTH_MODULE_ID_TEXT.resetValue();
		COMP_PMRTH_REP_NAME_TEXT.resetValue();
		COMP_PMRTH_REP_CATG_MENU.resetValue();
		COMP_PMRTH_REP_ID_TEXT.resetValue();
		COMP_PMRTH_REP_TEMP_NAME_ID_TEXT.resetValue();
		COMP_PMRTH_CONN_REQD_MENU.resetValue();
		COMP_PMRTH_PROC_REQD_MENU.resetValue();
		COMP_PMRTH_REPORT_CATG_MENU.resetValue();
		COMP_PMRTH_SR_NO_TEXT.resetValue();
		COMP_PMRTH_REP_IDEN_TEXT.resetValue();
		COMP_PMRTH_PROC_NAME_TEXT.resetValue();
		COMP_PMRTH_PARAM_TYPE_TEXT.resetValue();
		COMP_PMRTH_PARAM_DATATYPE_MENU.resetValue();
		COMP_PARAM_IP_REP_COL_TEXT.resetValue();
	
}
	
	
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				tableList.remove(PM_COMMON_RI_CONFIG_DTL_BEAN);
				helper.executeDelete(PM_COMMON_RI_CONFIG_DTL_BEAN);
				//CommonUtils.getConnection().commit();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				//tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				if (tableList.size() > 0) {

					PM_COMMON_RI_CONFIG_DTL_BEAN = tableList.get(0);
				} else if (tableList.size() == 0) {

					AddRow(null);
				}

				resetAllComponent();
				PM_COMMON_RI_CONFIG_DTL_BEAN.setRowSelected(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void deleteRowForRepTabHdr(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				PM_REP_TAB_HDR_LIST.remove(PM_REP_TAB_HDR_BEAN);
				helper.executeDelete(PM_REP_TAB_HDR_BEAN);
				//CommonUtils.getConnection().commit();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				//tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				if (PM_REP_TAB_HDR_LIST.size() > 0) {

					PM_REP_TAB_HDR_BEAN = PM_REP_TAB_HDR_LIST.get(0);
				} else if (PM_REP_TAB_HDR_LIST.size() == 0) {

					AddRowForRePTabHdr(null);
				}

				resetAllComponent();
				PM_REP_TAB_HDR_BEAN.setRowSelected(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void deleteRowForProcParams(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				PM_REP_PROC_PARAMS_LIST.remove(PM_REP_PROC_PARAMS_BEAN);
				helper.executeDelete(PM_REP_PROC_PARAMS_BEAN);
				//CommonUtils.getConnection().commit();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				//tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				if (PM_REP_PROC_PARAMS_LIST.size() > 0) {

					PM_REP_PROC_PARAMS_BEAN = PM_REP_PROC_PARAMS_LIST.get(0);
				} else if (PM_REP_TAB_HDR_LIST.size() == 0) {

					AddRowForRePRepProcParams(null);
				}

				resetAllComponent();
				PM_REP_PROC_PARAMS_BEAN.setRowSelected(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public PILM205_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM205_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PILM205_CUSTOMIZED_REPORT getPILP_237_CUSTOMIZED_REPORT_BEAN() {
		return PILM205_CUSTOMIZED_REPORT_BEAN;
	}

	public void setPILP_237_CUSTOMIZED_REPORT_BEAN(
			PILM205_CUSTOMIZED_REPORT PILM205_CUSTOMIZED_REPORT_BEAN) {
		PILM205_CUSTOMIZED_REPORT_BEAN = PILM205_CUSTOMIZED_REPORT_BEAN;
	}

	public PILM205_CUSTOMIZED_REPORT_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PILM205_CUSTOMIZED_REPORT_HELPER helper) {
		this.helper = helper;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PM_COMMON_RI_CONFIG_DTL> getTableList() {
		return tableList;
	}

	public void setTableList(List<PM_COMMON_RI_CONFIG_DTL> tableList) {
		this.tableList = tableList;
	}

	public PM_COMMON_RI_CONFIG_DTL getPM_COMMON_RI_CONFIG_DTL_BEAN() {
		return PM_COMMON_RI_CONFIG_DTL_BEAN;
	}

	public void setPM_COMMON_RI_CONFIG_DTL_BEAN(
			PM_COMMON_RI_CONFIG_DTL pM_COMMON_RI_CONFIG_DTL_BEAN) {
		PM_COMMON_RI_CONFIG_DTL_BEAN = pM_COMMON_RI_CONFIG_DTL_BEAN;
	}

	public PM_REP_TAB_HDR getPM_REP_TAB_HDR_BEAN() {
		return PM_REP_TAB_HDR_BEAN;
	}

	public void setPM_REP_TAB_HDR_BEAN(PM_REP_TAB_HDR pM_REP_TAB_HDR_BEAN) {
		PM_REP_TAB_HDR_BEAN = pM_REP_TAB_HDR_BEAN;
	}

	public PM_REP_PROC_PARAMS getPM_REP_PROC_PARAMS_BEAN() {
		return PM_REP_PROC_PARAMS_BEAN;
	}

	public void setPM_REP_PROC_PARAMS_BEAN(
			PM_REP_PROC_PARAMS pM_REP_PROC_PARAMS_BEAN) {
		PM_REP_PROC_PARAMS_BEAN = pM_REP_PROC_PARAMS_BEAN;
	}

	public HtmlCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlCommandButton uI_M_BUT_ADD) {
		UI_M_BUT_ADD = uI_M_BUT_ADD;
	}

	public HtmlCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlCommandButton uI_M_BUT_POST) {
		UI_M_BUT_POST = uI_M_BUT_POST;
	}

	public HtmlInputText getCOMP_REP_ID_TEXT() {
		return COMP_REP_ID_TEXT;
	}

	public void setCOMP_REP_ID_TEXT(HtmlInputText cOMP_REP_ID_TEXT) {
		COMP_REP_ID_TEXT = cOMP_REP_ID_TEXT;
	}

	public HtmlInputText getCOMP_PARAM_NAME_TEXT() {
		return COMP_PARAM_NAME_TEXT;
	}

	public void setCOMP_PARAM_NAME_TEXT(HtmlInputText cOMP_PARAM_NAME_TEXT) {
		COMP_PARAM_NAME_TEXT = cOMP_PARAM_NAME_TEXT;
	}

	public HtmlSelectOneMenu getCOMP_PARAM_TYPE() {
		return COMP_PARAM_TYPE;
	}

	public void setCOMP_PARAM_TYPE(HtmlSelectOneMenu cOMP_PARAM_TYPE) {
		COMP_PARAM_TYPE = cOMP_PARAM_TYPE;
	}

	public HtmlOutputLabel getCOMP_REP_ID_LABEL() {
		return COMP_REP_ID_LABEL;
	}

	public void setCOMP_REP_ID_LABEL(HtmlOutputLabel cOMP_REP_ID_LABEL) {
		COMP_REP_ID_LABEL = cOMP_REP_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_NAME_LABEL() {
		return COMP_PARAM_NAME_LABEL;
	}

	public void setCOMP_PARAM_NAME_LABEL(HtmlOutputLabel cOMP_PARAM_NAME_LABEL) {
		COMP_PARAM_NAME_LABEL = cOMP_PARAM_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_ORDER_LABEL() {
		return COMP_PARAM_ORDER_LABEL;
	}

	public void setCOMP_PARAM_ORDER_LABEL(HtmlOutputLabel cOMP_PARAM_ORDER_LABEL) {
		COMP_PARAM_ORDER_LABEL = cOMP_PARAM_ORDER_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_LOV_QUERY_LABEL() {
		return COMP_PARAM_LOV_QUERY_LABEL;
	}

	public void setCOMP_PARAM_LOV_QUERY_LABEL(
			HtmlOutputLabel cOMP_PARAM_LOV_QUERY_LABEL) {
		COMP_PARAM_LOV_QUERY_LABEL = cOMP_PARAM_LOV_QUERY_LABEL;
	}

	public HtmlOutputLabel getCOMP_SRNO_LABEL() {
		return COMP_SRNO_LABEL;
	}

	public void setCOMP_SRNO_LABEL(HtmlOutputLabel cOMP_SRNO_LABEL) {
		COMP_SRNO_LABEL = cOMP_SRNO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_ID_LABEL() {
		return COMP_PARAM_ID_LABEL;
	}

	public void setCOMP_PARAM_ID_LABEL(HtmlOutputLabel cOMP_PARAM_ID_LABEL) {
		COMP_PARAM_ID_LABEL = cOMP_PARAM_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_IP_REP_COL_LABEL() {
		return COMP_PARAM_IP_REP_COL_LABEL;
	}

	public void setCOMP_PARAM_IP_REP_COL_LABEL(
			HtmlOutputLabel cOMP_PARAM_IP_REP_COL_LABEL) {
		COMP_PARAM_IP_REP_COL_LABEL = cOMP_PARAM_IP_REP_COL_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_PARAM_IP_REP_COL_LABEL() {
		return COMP_UI_PARAM_IP_REP_COL_LABEL;
	}

	public void setCOMP_UI_PARAM_IP_REP_COL_LABEL(
			HtmlOutputLabel cOMP_UI_PARAM_IP_REP_COL_LABEL) {
		COMP_UI_PARAM_IP_REP_COL_LABEL = cOMP_UI_PARAM_IP_REP_COL_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARM_FROMTO_REL_LABEL() {
		return COMP_PARM_FROMTO_REL_LABEL;
	}

	public void setCOMP_PARM_FROMTO_REL_LABEL(
			HtmlOutputLabel cOMP_PARM_FROMTO_REL_LABEL) {
		COMP_PARM_FROMTO_REL_LABEL = cOMP_PARM_FROMTO_REL_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL() {
		return COMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL;
	}

	public void setCOMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL(
			HtmlOutputLabel cOMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL) {
		COMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL = cOMP_PARAM_DEPEN_ID_INPUT_TEXT_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_DEPEND_COL_LABEL() {
		return COMP_PARAM_DEPEND_COL_LABEL;
	}

	public void setCOMP_PARAM_DEPEND_COL_LABEL(
			HtmlOutputLabel cOMP_PARAM_DEPEND_COL_LABEL) {
		COMP_PARAM_DEPEND_COL_LABEL = cOMP_PARAM_DEPEND_COL_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_SR_NUM_LABEL() {
		return COMP_PMRTH_SR_NUM_LABEL;
	}

	public void setCOMP_PMRTH_SR_NUM_LABEL(HtmlOutputLabel cOMP_PMRTH_SR_NUM_LABEL) {
		COMP_PMRTH_SR_NUM_LABEL = cOMP_PMRTH_SR_NUM_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_MODULE_ID_LABEL() {
		return COMP_PMRTH_MODULE_ID_LABEL;
	}

	public void setCOMP_PMRTH_MODULE_ID_LABEL(
			HtmlOutputLabel cOMP_PMRTH_MODULE_ID_LABEL) {
		COMP_PMRTH_MODULE_ID_LABEL = cOMP_PMRTH_MODULE_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REP_NAME_LABEL() {
		return COMP_PMRTH_REP_NAME_LABEL;
	}

	public void setCOMP_PMRTH_REP_NAME_LABEL(
			HtmlOutputLabel cOMP_PMRTH_REP_NAME_LABEL) {
		COMP_PMRTH_REP_NAME_LABEL = cOMP_PMRTH_REP_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REP_CATG_LABEL() {
		return COMP_PMRTH_REP_CATG_LABEL;
	}

	public void setCOMP_PMRTH_REP_CATG_LABEL(
			HtmlOutputLabel cOMP_PMRTH_REP_CATG_LABEL) {
		COMP_PMRTH_REP_CATG_LABEL = cOMP_PMRTH_REP_CATG_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REP_ID_LABEL() {
		return COMP_PMRTH_REP_ID_LABEL;
	}

	public void setCOMP_PMRTH_REP_ID_LABEL(HtmlOutputLabel cOMP_PMRTH_REP_ID_LABEL) {
		COMP_PMRTH_REP_ID_LABEL = cOMP_PMRTH_REP_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REP_TEMP_NAME_ID_LABEL() {
		return COMP_PMRTH_REP_TEMP_NAME_ID_LABEL;
	}

	public void setCOMP_PMRTH_REP_TEMP_NAME_ID_LABEL(
			HtmlOutputLabel cOMP_PMRTH_REP_TEMP_NAME_ID_LABEL) {
		COMP_PMRTH_REP_TEMP_NAME_ID_LABEL = cOMP_PMRTH_REP_TEMP_NAME_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_CONN_REQD_LABEL() {
		return COMP_PMRTH_CONN_REQD_LABEL;
	}

	public void setCOMP_PMRTH_CONN_REQD_LABEL(
			HtmlOutputLabel cOMP_PMRTH_CONN_REQD_LABEL) {
		COMP_PMRTH_CONN_REQD_LABEL = cOMP_PMRTH_CONN_REQD_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_PROC_REQD_LABEL() {
		return COMP_PMRTH_PROC_REQD_LABEL;
	}

	public void setCOMP_PMRTH_PROC_REQD_LABEL(
			HtmlOutputLabel cOMP_PMRTH_PROC_REQD_LABEL) {
		COMP_PMRTH_PROC_REQD_LABEL = cOMP_PMRTH_PROC_REQD_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REPORT_CATG_LABEL() {
		return COMP_PMRTH_REPORT_CATG_LABEL;
	}

	public void setCOMP_PMRTH_REPORT_CATG_LABEL(
			HtmlOutputLabel cOMP_PMRTH_REPORT_CATG_LABEL) {
		COMP_PMRTH_REPORT_CATG_LABEL = cOMP_PMRTH_REPORT_CATG_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_SR_NO_LABEL() {
		return COMP_PMRTH_SR_NO_LABEL;
	}

	public void setCOMP_PMRTH_SR_NO_LABEL(HtmlOutputLabel cOMP_PMRTH_SR_NO_LABEL) {
		COMP_PMRTH_SR_NO_LABEL = cOMP_PMRTH_SR_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_REP_IDEN_LABEL() {
		return COMP_PMRTH_REP_IDEN_LABEL;
	}

	public void setCOMP_PMRTH_REP_IDEN_LABEL(
			HtmlOutputLabel cOMP_PMRTH_REP_IDEN_LABEL) {
		COMP_PMRTH_REP_IDEN_LABEL = cOMP_PMRTH_REP_IDEN_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_PROC_NAME_LABEL() {
		return COMP_PMRTH_PROC_NAME_LABEL;
	}

	public void setCOMP_PMRTH_PROC_NAME_LABEL(
			HtmlOutputLabel cOMP_PMRTH_PROC_NAME_LABEL) {
		COMP_PMRTH_PROC_NAME_LABEL = cOMP_PMRTH_PROC_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_PARAM_TYPE_LABEL() {
		return COMP_PMRTH_PARAM_TYPE_LABEL;
	}

	public void setCOMP_PMRTH_PARAM_TYPE_LABEL(
			HtmlOutputLabel cOMP_PMRTH_PARAM_TYPE_LABEL) {
		COMP_PMRTH_PARAM_TYPE_LABEL = cOMP_PMRTH_PARAM_TYPE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PMRTH_PARAM_DATATYPE_LABEL() {
		return COMP_PMRTH_PARAM_DATATYPE_LABEL;
	}

	public void setCOMP_PMRTH_PARAM_DATATYPE_LABEL(
			HtmlOutputLabel cOMP_PMRTH_PARAM_DATATYPE_LABEL) {
		COMP_PMRTH_PARAM_DATATYPE_LABEL = cOMP_PMRTH_PARAM_DATATYPE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PARAM_TYPE_LABEL() {
		return COMP_PARAM_TYPE_LABEL;
	}

	public void setCOMP_PARAM_TYPE_LABEL(HtmlOutputLabel cOMP_PARAM_TYPE_LABEL) {
		COMP_PARAM_TYPE_LABEL = cOMP_PARAM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PARAM_TYPE_TEXT() {
		return COMP_PARAM_TYPE_TEXT;
	}

	public void setCOMP_PARAM_TYPE_TEXT(HtmlSelectOneMenu cOMP_PARAM_TYPE_TEXT) {
		COMP_PARAM_TYPE_TEXT = cOMP_PARAM_TYPE_TEXT;
	}

	public HtmlInputText getCOMP_PARAM_ORDER_TEXT() {
		return COMP_PARAM_ORDER_TEXT;
	}

	public void setCOMP_PARAM_ORDER_TEXT(HtmlInputText cOMP_PARAM_ORDER_TEXT) {
		COMP_PARAM_ORDER_TEXT = cOMP_PARAM_ORDER_TEXT;
	}



	public HtmlInputTextarea getCOMP_PARAM_LOV_QUERY_INPUT_TEXT() {
		return COMP_PARAM_LOV_QUERY_INPUT_TEXT;
	}

	public void setCOMP_PARAM_LOV_QUERY_INPUT_TEXT(
			HtmlInputTextarea cOMP_PARAM_LOV_QUERY_INPUT_TEXT) {
		COMP_PARAM_LOV_QUERY_INPUT_TEXT = cOMP_PARAM_LOV_QUERY_INPUT_TEXT;
	}

	public void setCOMP_PARAM_DEPEN_ID_INPUT_TEXT(
			HtmlInputTextarea cOMP_PARAM_DEPEN_ID_INPUT_TEXT) {
		COMP_PARAM_DEPEN_ID_INPUT_TEXT = cOMP_PARAM_DEPEN_ID_INPUT_TEXT;
	}

	public HtmlInputText getCOMP_SRNO_TEXT() {
		return COMP_SRNO_TEXT;
	}

	public void setCOMP_SRNO_TEXT(HtmlInputText cOMP_SRNO_TEXT) {
		COMP_SRNO_TEXT = cOMP_SRNO_TEXT;
	}

	public HtmlInputText getCOMP_PARAM_ID_TEXT() {
		return COMP_PARAM_ID_TEXT;
	}

	public void setCOMP_PARAM_ID_TEXT(HtmlInputText cOMP_PARAM_ID_TEXT) {
		COMP_PARAM_ID_TEXT = cOMP_PARAM_ID_TEXT;
	}

	public HtmlInputText getCOMP_UI_PARAM_IP_REP_COL_TEXT() {
		return COMP_UI_PARAM_IP_REP_COL_TEXT;
	}

	public void setCOMP_UI_PARAM_IP_REP_COL_TEXT(
			HtmlInputText cOMP_UI_PARAM_IP_REP_COL_TEXT) {
		COMP_UI_PARAM_IP_REP_COL_TEXT = cOMP_UI_PARAM_IP_REP_COL_TEXT;
	}

	public HtmlSelectOneMenu getCOMP_PARAM_TYPE_MENU() {
		return COMP_PARAM_TYPE_MENU;
	}

	public void setCOMP_PARAM_TYPE_MENU(HtmlSelectOneMenu cOMP_PARAM_TYPE_MENU) {
		COMP_PARAM_TYPE_MENU = cOMP_PARAM_TYPE_MENU;
	}

	public HtmlSelectOneMenu getCOMP_PARM_FROMTO_REL_MENU() {
		return COMP_PARM_FROMTO_REL_MENU;
	}

	public void setCOMP_PARM_FROMTO_REL_MENU(
			HtmlSelectOneMenu cOMP_PARM_FROMTO_REL_MENU) {
		COMP_PARM_FROMTO_REL_MENU = cOMP_PARM_FROMTO_REL_MENU;
	}


	public HtmlInputText getCOMP_PARAM_DEPEND_COL_TEXT() {
		return COMP_PARAM_DEPEND_COL_TEXT;
	}

	public void setCOMP_PARAM_DEPEND_COL_TEXT(
			HtmlInputText cOMP_PARAM_DEPEND_COL_TEXT) {
		COMP_PARAM_DEPEND_COL_TEXT = cOMP_PARAM_DEPEND_COL_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_SR_NUM_TEXT() {
		return COMP_PMRTH_SR_NUM_TEXT;
	}

	public void setCOMP_PMRTH_SR_NUM_TEXT(HtmlInputText cOMP_PMRTH_SR_NUM_TEXT) {
		COMP_PMRTH_SR_NUM_TEXT = cOMP_PMRTH_SR_NUM_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_MODULE_ID_TEXT() {
		return COMP_PMRTH_MODULE_ID_TEXT;
	}

	public void setCOMP_PMRTH_MODULE_ID_TEXT(HtmlInputText cOMP_PMRTH_MODULE_ID_TEXT) {
		COMP_PMRTH_MODULE_ID_TEXT = cOMP_PMRTH_MODULE_ID_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_REP_NAME_TEXT() {
		return COMP_PMRTH_REP_NAME_TEXT;
	}

	public void setCOMP_PMRTH_REP_NAME_TEXT(HtmlInputText cOMP_PMRTH_REP_NAME_TEXT) {
		COMP_PMRTH_REP_NAME_TEXT = cOMP_PMRTH_REP_NAME_TEXT;
	}

	public HtmlSelectOneMenu getCOMP_PMRTH_REP_CATG_MENU() {
		return COMP_PMRTH_REP_CATG_MENU;
	}

	public void setCOMP_PMRTH_REP_CATG_MENU(
			HtmlSelectOneMenu cOMP_PMRTH_REP_CATG_MENU) {
		COMP_PMRTH_REP_CATG_MENU = cOMP_PMRTH_REP_CATG_MENU;
	}

	public HtmlInputText getCOMP_PMRTH_REP_ID_TEXT() {
		return COMP_PMRTH_REP_ID_TEXT;
	}

	public void setCOMP_PMRTH_REP_ID_TEXT(HtmlInputText cOMP_PMRTH_REP_ID_TEXT) {
		COMP_PMRTH_REP_ID_TEXT = cOMP_PMRTH_REP_ID_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_REP_TEMP_NAME_ID_TEXT() {
		return COMP_PMRTH_REP_TEMP_NAME_ID_TEXT;
	}

	public void setCOMP_PMRTH_REP_TEMP_NAME_ID_TEXT(
			HtmlInputText cOMP_PMRTH_REP_TEMP_NAME_ID_TEXT) {
		COMP_PMRTH_REP_TEMP_NAME_ID_TEXT = cOMP_PMRTH_REP_TEMP_NAME_ID_TEXT;
	}

	public HtmlSelectOneMenu getCOMP_PMRTH_CONN_REQD_MENU() {
		return COMP_PMRTH_CONN_REQD_MENU;
	}

	public void setCOMP_PMRTH_CONN_REQD_MENU(
			HtmlSelectOneMenu cOMP_PMRTH_CONN_REQD_MENU) {
		COMP_PMRTH_CONN_REQD_MENU = cOMP_PMRTH_CONN_REQD_MENU;
	}

	public HtmlSelectOneMenu getCOMP_PMRTH_PROC_REQD_MENU() {
		return COMP_PMRTH_PROC_REQD_MENU;
	}

	public void setCOMP_PMRTH_PROC_REQD_MENU(
			HtmlSelectOneMenu cOMP_PMRTH_PROC_REQD_MENU) {
		COMP_PMRTH_PROC_REQD_MENU = cOMP_PMRTH_PROC_REQD_MENU;
	}

	public HtmlSelectOneMenu getCOMP_PMRTH_REPORT_CATG_MENU() {
		return COMP_PMRTH_REPORT_CATG_MENU;
	}

	public void setCOMP_PMRTH_REPORT_CATG_MENU(
			HtmlSelectOneMenu cOMP_PMRTH_REPORT_CATG_MENU) {
		COMP_PMRTH_REPORT_CATG_MENU = cOMP_PMRTH_REPORT_CATG_MENU;
	}

	public HtmlInputText getCOMP_PMRTH_SR_NO_TEXT() {
		return COMP_PMRTH_SR_NO_TEXT;
	}

	public void setCOMP_PMRTH_SR_NO_TEXT(HtmlInputText cOMP_PMRTH_SR_NO_TEXT) {
		COMP_PMRTH_SR_NO_TEXT = cOMP_PMRTH_SR_NO_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_REP_IDEN_TEXT() {
		return COMP_PMRTH_REP_IDEN_TEXT;
	}

	public void setCOMP_PMRTH_REP_IDEN_TEXT(HtmlInputText cOMP_PMRTH_REP_IDEN_TEXT) {
		COMP_PMRTH_REP_IDEN_TEXT = cOMP_PMRTH_REP_IDEN_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_PROC_NAME_TEXT() {
		return COMP_PMRTH_PROC_NAME_TEXT;
	}

	public void setCOMP_PMRTH_PROC_NAME_TEXT(HtmlInputText cOMP_PMRTH_PROC_NAME_TEXT) {
		COMP_PMRTH_PROC_NAME_TEXT = cOMP_PMRTH_PROC_NAME_TEXT;
	}

	public HtmlSelectOneMenu getCOMP_PMRTH_PARAM_TYPE_TEXT() {
		return COMP_PMRTH_PARAM_TYPE_TEXT;
	}

	public void setCOMP_PMRTH_PARAM_TYPE_TEXT(
			HtmlSelectOneMenu cOMP_PMRTH_PARAM_TYPE_TEXT) {
		COMP_PMRTH_PARAM_TYPE_TEXT = cOMP_PMRTH_PARAM_TYPE_TEXT;
	}

	public HtmlInputText getCOMP_PMRTH_PARAM_DATATYPE_MENU() {
		return COMP_PMRTH_PARAM_DATATYPE_MENU;
	}

	public void setCOMP_PMRTH_PARAM_DATATYPE_MENU(
			HtmlInputText cOMP_PMRTH_PARAM_DATATYPE_MENU) {
		COMP_PMRTH_PARAM_DATATYPE_MENU = cOMP_PMRTH_PARAM_DATATYPE_MENU;
	}

	public HtmlInputTextarea getCOMP_PARAM_DEPEN_ID_INPUT_TEXT() {
		return COMP_PARAM_DEPEN_ID_INPUT_TEXT;
	}

	public HtmlInputText getCOMP_PARAM_IP_REP_COL_TEXT() {
		return COMP_PARAM_IP_REP_COL_TEXT;
	}

	public void setCOMP_PARAM_IP_REP_COL_TEXT(HtmlInputText cOMP_PARAM_IP_REP_COL_TEXT) {
		COMP_PARAM_IP_REP_COL_TEXT = cOMP_PARAM_IP_REP_COL_TEXT;
	}

	public HtmlOutputLabel getCOMP_PM_REQUIRED_LABEL() {
		return COMP_PM_REQUIRED_LABEL;
	}

	public void setCOMP_PM_REQUIRED_LABEL(HtmlOutputLabel cOMP_PM_REQUIRED_LABEL) {
		COMP_PM_REQUIRED_LABEL = cOMP_PM_REQUIRED_LABEL;
	}

	public List<PM_REP_TAB_HDR> getPM_REP_TAB_HDR_LIST() {
		return PM_REP_TAB_HDR_LIST;
	}

	public void setPM_REP_TAB_HDR_LIST(List<PM_REP_TAB_HDR> pM_REP_TAB_HDR_LIST) {
		PM_REP_TAB_HDR_LIST = pM_REP_TAB_HDR_LIST;
	}

	public List<PM_REP_PROC_PARAMS> getPM_REP_PROC_PARAMS_LIST() {
		return PM_REP_PROC_PARAMS_LIST;
	}

	public void setPM_REP_PROC_PARAMS_LIST(
			List<PM_REP_PROC_PARAMS> pM_REP_PROC_PARAMS_LIST) {
		PM_REP_PROC_PARAMS_LIST = pM_REP_PROC_PARAMS_LIST;
	}

	public HtmlCommandButton getUI_M_BUT_ADD_REP_TAB_HDR() {
		return UI_M_BUT_ADD_REP_TAB_HDR;
	}

	public void setUI_M_BUT_ADD_REP_TAB_HDR(
			HtmlCommandButton uI_M_BUT_ADD_REP_TAB_HDR) {
		UI_M_BUT_ADD_REP_TAB_HDR = uI_M_BUT_ADD_REP_TAB_HDR;
	}

	public HtmlCommandButton getUI_M_BUT_ADD_REP_PROC_PARAMS() {
		return UI_M_BUT_ADD_REP_PROC_PARAMS;
	}

	public void setUI_M_BUT_ADD_REP_PROC_PARAMS(
			HtmlCommandButton uI_M_BUT_ADD_REP_PROC_PARAMS) {
		UI_M_BUT_ADD_REP_PROC_PARAMS = uI_M_BUT_ADD_REP_PROC_PARAMS;
	}

	public HtmlCommandButton getUI_M_BUT_POST_REP_TAB_HDR() {
		return UI_M_BUT_POST_REP_TAB_HDR;
	}

	public void setUI_M_BUT_POST_REP_TAB_HDR(
			HtmlCommandButton uI_M_BUT_POST_REP_TAB_HDR) {
		UI_M_BUT_POST_REP_TAB_HDR = uI_M_BUT_POST_REP_TAB_HDR;
	}

	public HtmlCommandButton getUI_M_BUT_POST_REP_PROC_PARAMS() {
		return UI_M_BUT_POST_REP_PROC_PARAMS;
	}

	public void setUI_M_BUT_POST_REP_PROC_PARAMS(
			HtmlCommandButton uI_M_BUT_POST_REP_PROC_PARAMS) {
		UI_M_BUT_POST_REP_PROC_PARAMS = uI_M_BUT_POST_REP_PROC_PARAMS;
	}

	public UIData getDataTable2() {
		return dataTable2;
	}

	public void setDataTable2(UIData dataTable2) {
		this.dataTable2 = dataTable2;
	}

	public UIData getDataTable3() {
		return dataTable3;
	}

	public void setDataTable3(UIData dataTable3) {
		this.dataTable3 = dataTable3;
	}

	public HtmlCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlCommandButton uI_M_BUT_DELETE) {
		UI_M_BUT_DELETE = uI_M_BUT_DELETE;
	}

	public HtmlCommandButton getUI_M_BUT_DELETE_REP_TAB_HDR() {
		return UI_M_BUT_DELETE_REP_TAB_HDR;
	}

	public void setUI_M_BUT_DELETE_REP_TAB_HDR(
			HtmlCommandButton uI_M_BUT_DELETE_REP_TAB_HDR) {
		UI_M_BUT_DELETE_REP_TAB_HDR = uI_M_BUT_DELETE_REP_TAB_HDR;
	}

	public HtmlCommandButton getUI_M_BUT_DELETE_REP_PROC_PARAMS() {
		return UI_M_BUT_DELETE_REP_PROC_PARAMS;
	}

	public void setUI_M_BUT_DELETE_REP_PROC_PARAMS(
			HtmlCommandButton uI_M_BUT_DELETE_REP_PROC_PARAMS) {
		UI_M_BUT_DELETE_REP_PROC_PARAMS = uI_M_BUT_DELETE_REP_PROC_PARAMS;
	}

	public HtmlInputText getCOMP_PMRTH_PARAM_DATATYPE_DESC() {
		return COMP_PMRTH_PARAM_DATATYPE_DESC;
	}

	public void setCOMP_PMRTH_PARAM_DATATYPE_DESC(
			HtmlInputText cOMP_PMRTH_PARAM_DATATYPE_DESC) {
		COMP_PMRTH_PARAM_DATATYPE_DESC = cOMP_PMRTH_PARAM_DATATYPE_DESC;
	}

	public List<PP_SYSTEM_1> getRepCatgList() {
		return repCatgList;
	}

	public void setRepCatgList(List<PP_SYSTEM_1> repCatgList) {
		this.repCatgList = repCatgList;
	}

	public List<SelectItem> getRepCatgSelectList() {
		return repCatgSelectList;
	}

	public void setRepCatgSelectList(List<SelectItem> repCatgSelectList) {
		this.repCatgSelectList = repCatgSelectList;
	}

	public List<SelectItem> getRepCatgSelectList1() {
		return repCatgSelectList1;
	}

	public void setRepCatgSelectList1(List<SelectItem> repCatgSelectList1) {
		this.repCatgSelectList1 = repCatgSelectList1;
	}

	public HtmlTab getCOMP_REP_PROC_PARAMS() {
		return COMP_REP_PROC_PARAMS;
	}

	public void setCOMP_REP_PROC_PARAMS(HtmlTab cOMP_REP_PROC_PARAMS) {
		COMP_REP_PROC_PARAMS = cOMP_REP_PROC_PARAMS;
	}

	
	

}

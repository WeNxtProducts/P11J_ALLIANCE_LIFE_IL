package com.iii.pel.forms.PILM042;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DUDD_SERIAL_NO_LABEL;

	private HtmlInputText COMP_DUDD_SERIAL_NO;

	private HtmlOutputLabel COMP_DUDD_PARA_NAME_LABEL;

	private HtmlInputText COMP_DUDD_PARA_NAME;

	private HtmlOutputLabel COMP_DUDD_PARA_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_DUDD_PARA_TYPE;

	private HtmlOutputLabel COMP_DUDD_INPUT_DATA_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_DUDD_INPUT_DATA_TYPE;

	private HtmlOutputLabel COMP_DUDD_FORMAT_LABEL;

	private HtmlInputText COMP_DUDD_FORMAT;

	private HtmlOutputLabel COMP_DUDD_TABLE_NAME_LABEL;

	private HtmlInputText COMP_DUDD_TABLE_NAME;

	private HtmlOutputLabel COMP_DUDD_FIELD_NAME_LABEL;

	private HtmlInputText COMP_DUDD_FIELD_NAME;

	private HtmlOutputLabel COMP_DUDD_LINK_COLUMN_LABEL;

	private HtmlInputText COMP_DUDD_LINK_COLUMN;

	private HtmlOutputLabel COMP_DUDD_RET_PARA_LABEL;

	private HtmlSelectOneMenu COMP_DUDD_RET_PARA;

	private HtmlOutputLabel COMP_DUDD_STORAGE_YN_LABEL;

	private HtmlSelectOneMenu COMP_DUDD_STORAGE_YN;

	private HtmlOutputLabel COMP_DUDD_LINK_SERIAL_NO_LABEL;

	private HtmlInputText COMP_DUDD_LINK_SERIAL_NO;

	private HtmlCommandButton COMP_UI_M_EDIT_PARA_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_DUDD_FORMAT_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV;

	private PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN;

	private List fetchList = new ArrayList();

	private List<SelectItem> DUDD_PARA_TYPE_LIST = new ArrayList<SelectItem>();

	private List<SelectItem> DUDD_RET_PARA_LIST = new ArrayList<SelectItem>();

	private List<SelectItem> DUDD_INPUT_DATA_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> DUDD_STORAGE_YN = new ArrayList<SelectItem>();

	private UIData dataTable;
	private List<PM_IL_DATA_UPLOAD_DEFN_DTL> dataList_PM_IL_DATA_UPLOAD_DEFN_DTL = new ArrayList<PM_IL_DATA_UPLOAD_DEFN_DTL>();

	
	private PM_IL_DATA_UPLOAD_DEFN_DTL_HELPER helper ;
	
	public PILM042_COMPOSITE_ACTION compositeAction;
	
	public List<LovBean> suggesionList = null;

	public PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION() {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = new PM_IL_DATA_UPLOAD_DEFN_DTL();
			helper = new PM_IL_DATA_UPLOAD_DEFN_DTL_HELPER();
			instantiateAllComponent();
			setDUDD_PARA_TYPE_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL","PM_IL_DATA_UPLOAD_DEFN_DTL.DUDD_PARA_TYPE", "PARATYPE"));
			setDUDD_RET_PARA_LIST(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL","PM_IL_DATA_UPLOAD_DEFN_DTL.DUDD_RET_PARA", "RETPARA"));
			setDUDD_INPUT_DATA_TYPE(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL","PM_IL_DATA_UPLOAD_DEFN_DTL.DUDD_INPUT_DATA_TYPE","IL_DAT_TYP"));
			setDUDD_STORAGE_YN(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL","PM_IL_DATA_UPLOAD_DEFN_DTL.DUDD_STORAGE_YN", "YESNO"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_DUDD_SERIAL_NO_LABEL() {
		return COMP_DUDD_SERIAL_NO_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_SERIAL_NO() {
		return COMP_DUDD_SERIAL_NO;
	}

	public void setCOMP_DUDD_SERIAL_NO_LABEL(
			HtmlOutputLabel COMP_DUDD_SERIAL_NO_LABEL) {
		COMP_DUDD_SERIAL_NO_LABEL = COMP_DUDD_SERIAL_NO_LABEL;
	}

	public void setCOMP_DUDD_SERIAL_NO(HtmlInputText NO) {
		COMP_DUDD_SERIAL_NO = NO;
	}

	public HtmlOutputLabel getCOMP_DUDD_PARA_NAME_LABEL() {
		return COMP_DUDD_PARA_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_PARA_NAME() {
		return COMP_DUDD_PARA_NAME;
	}

	public void setCOMP_DUDD_PARA_NAME_LABEL(
			HtmlOutputLabel COMP_DUDD_PARA_NAME_LABEL) {
		this.COMP_DUDD_PARA_NAME_LABEL = COMP_DUDD_PARA_NAME_LABEL;
	}

	public void setCOMP_DUDD_PARA_NAME(HtmlInputText COMP_DUDD_PARA_NAME) {
		this.COMP_DUDD_PARA_NAME = COMP_DUDD_PARA_NAME;
	}

	public HtmlOutputLabel getCOMP_DUDD_PARA_TYPE_LABEL() {
		return COMP_DUDD_PARA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUDD_PARA_TYPE() {
		return COMP_DUDD_PARA_TYPE;
	}

	public void setCOMP_DUDD_PARA_TYPE_LABEL(
			HtmlOutputLabel COMP_DUDD_PARA_TYPE_LABEL) {
		this.COMP_DUDD_PARA_TYPE_LABEL = COMP_DUDD_PARA_TYPE_LABEL;
	}

	public void setCOMP_DUDD_PARA_TYPE(HtmlSelectOneMenu COMP_DUDD_PARA_TYPE) {
		this.COMP_DUDD_PARA_TYPE = COMP_DUDD_PARA_TYPE;
	}

	public HtmlOutputLabel getCOMP_DUDD_INPUT_DATA_TYPE_LABEL() {
		return COMP_DUDD_INPUT_DATA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUDD_INPUT_DATA_TYPE() {
		return COMP_DUDD_INPUT_DATA_TYPE;
	}

	public void setCOMP_DUDD_INPUT_DATA_TYPE_LABEL(
			HtmlOutputLabel COMP_DUDD_INPUT_DATA_TYPE_LABEL) {
		this.COMP_DUDD_INPUT_DATA_TYPE_LABEL = COMP_DUDD_INPUT_DATA_TYPE_LABEL;
	}

	public void setCOMP_DUDD_INPUT_DATA_TYPE(
			HtmlSelectOneMenu COMP_DUDD_INPUT_DATA_TYPE) {
		this.COMP_DUDD_INPUT_DATA_TYPE = COMP_DUDD_INPUT_DATA_TYPE;
	}

	public HtmlOutputLabel getCOMP_DUDD_FORMAT_LABEL() {
		return COMP_DUDD_FORMAT_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_FORMAT() {
		return COMP_DUDD_FORMAT;
	}

	public void setCOMP_DUDD_FORMAT_LABEL(HtmlOutputLabel COMP_DUDD_FORMAT_LABEL) {
		this.COMP_DUDD_FORMAT_LABEL = COMP_DUDD_FORMAT_LABEL;
	}

	public void setCOMP_DUDD_FORMAT(HtmlInputText COMP_DUDD_FORMAT) {
		this.COMP_DUDD_FORMAT = COMP_DUDD_FORMAT;
	}

	public HtmlOutputLabel getCOMP_DUDD_TABLE_NAME_LABEL() {
		return COMP_DUDD_TABLE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_TABLE_NAME() {
		return COMP_DUDD_TABLE_NAME;
	}

	public void setCOMP_DUDD_TABLE_NAME_LABEL(
			HtmlOutputLabel COMP_DUDD_TABLE_NAME_LABEL) {
		this.COMP_DUDD_TABLE_NAME_LABEL = COMP_DUDD_TABLE_NAME_LABEL;
	}

	public void setCOMP_DUDD_TABLE_NAME(HtmlInputText COMP_DUDD_TABLE_NAME) {
		this.COMP_DUDD_TABLE_NAME = COMP_DUDD_TABLE_NAME;
	}

	public HtmlOutputLabel getCOMP_DUDD_FIELD_NAME_LABEL() {
		return COMP_DUDD_FIELD_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_FIELD_NAME() {
		return COMP_DUDD_FIELD_NAME;
	}

	public void setCOMP_DUDD_FIELD_NAME_LABEL(
			HtmlOutputLabel COMP_DUDD_FIELD_NAME_LABEL) {
		this.COMP_DUDD_FIELD_NAME_LABEL = COMP_DUDD_FIELD_NAME_LABEL;
	}

	public void setCOMP_DUDD_FIELD_NAME(HtmlInputText COMP_DUDD_FIELD_NAME) {
		this.COMP_DUDD_FIELD_NAME = COMP_DUDD_FIELD_NAME;
	}

	public HtmlOutputLabel getCOMP_DUDD_LINK_COLUMN_LABEL() {
		return COMP_DUDD_LINK_COLUMN_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_LINK_COLUMN() {
		return COMP_DUDD_LINK_COLUMN;
	}

	public void setCOMP_DUDD_LINK_COLUMN_LABEL(
			HtmlOutputLabel COMP_DUDD_LINK_COLUMN_LABEL) {
		this.COMP_DUDD_LINK_COLUMN_LABEL = COMP_DUDD_LINK_COLUMN_LABEL;
	}

	public void setCOMP_DUDD_LINK_COLUMN(HtmlInputText COMP_DUDD_LINK_COLUMN) {
		this.COMP_DUDD_LINK_COLUMN = COMP_DUDD_LINK_COLUMN;
	}

	public HtmlOutputLabel getCOMP_DUDD_RET_PARA_LABEL() {
		return COMP_DUDD_RET_PARA_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUDD_RET_PARA() {
		return COMP_DUDD_RET_PARA;
	}

	public void setCOMP_DUDD_RET_PARA_LABEL(
			HtmlOutputLabel COMP_DUDD_RET_PARA_LABEL) {
		this.COMP_DUDD_RET_PARA_LABEL = COMP_DUDD_RET_PARA_LABEL;
	}

	public void setCOMP_DUDD_RET_PARA(HtmlSelectOneMenu COMP_DUDD_RET_PARA) {
		this.COMP_DUDD_RET_PARA = COMP_DUDD_RET_PARA;
	}

	public HtmlOutputLabel getCOMP_DUDD_STORAGE_YN_LABEL() {
		return COMP_DUDD_STORAGE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUDD_STORAGE_YN() {
		return COMP_DUDD_STORAGE_YN;
	}

	public void setCOMP_DUDD_STORAGE_YN_LABEL(
			HtmlOutputLabel COMP_DUDD_STORAGE_YN_LABEL) {
		this.COMP_DUDD_STORAGE_YN_LABEL = COMP_DUDD_STORAGE_YN_LABEL;
	}

	public void setCOMP_DUDD_STORAGE_YN(HtmlSelectOneMenu COMP_DUDD_STORAGE_YN) {
		this.COMP_DUDD_STORAGE_YN = COMP_DUDD_STORAGE_YN;
	}

	public HtmlOutputLabel getCOMP_DUDD_LINK_SERIAL_NO_LABEL() {
		return COMP_DUDD_LINK_SERIAL_NO_LABEL;
	}

	public HtmlInputText getCOMP_DUDD_LINK_SERIAL_NO() {
		return COMP_DUDD_LINK_SERIAL_NO;
	}

	public void setCOMP_DUDD_LINK_SERIAL_NO_LABEL(
			HtmlOutputLabel COMP_DUDD_LINK_SERIAL_NO_LABEL) {
		this.COMP_DUDD_LINK_SERIAL_NO_LABEL = COMP_DUDD_LINK_SERIAL_NO_LABEL;
	}

	public void setCOMP_DUDD_LINK_SERIAL_NO(
			HtmlInputText COMP_DUDD_LINK_SERIAL_NO) {
		this.COMP_DUDD_LINK_SERIAL_NO = COMP_DUDD_LINK_SERIAL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_PARA_NAME() {
		return COMP_UI_M_EDIT_PARA_NAME;
	}

	public void setCOMP_UI_M_EDIT_PARA_NAME(
			HtmlCommandButton COMP_UI_M_EDIT_PARA_NAME) {
		this.COMP_UI_M_EDIT_PARA_NAME = COMP_UI_M_EDIT_PARA_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUDD_FORMAT_LOV() {
		return COMP_UI_M_BUT_DUDD_FORMAT_LOV;
	}

	public void setCOMP_UI_M_BUT_DUDD_FORMAT_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUDD_FORMAT_LOV) {
		this.COMP_UI_M_BUT_DUDD_FORMAT_LOV = COMP_UI_M_BUT_DUDD_FORMAT_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUDD_TABLE_NAME_LOV() {
		return COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV;
	}

	public void setCOMP_UI_M_BUT_DUDD_TABLE_NAME_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV) {
		this.COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV = COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUDD_FIELD_NAME_LOV() {
		return COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV;
	}

	public void setCOMP_UI_M_BUT_DUDD_FIELD_NAME_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV) {
		this.COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV = COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV() {
		return COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV;
	}

	public void setCOMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV) {
		this.COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV = COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV;
	}

	public PM_IL_DATA_UPLOAD_DEFN_DTL getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN() {
		return PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(
			PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN) {
		this.PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN;
	}

	public List getFetchList() {
		return fetchList;
	}

	public void setFetchList(List fetchList) {
		this.fetchList = fetchList;
	}


	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	CommonUtils util = new CommonUtils();

	public String saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		try {
			if (PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getROWID() != null) {
				if (isINSERT_ALLOWED()) {
					helper.preUpdate(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN, compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN());
					new CRUDHandler().executeInsert(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,CommonUtils.getConnection());
					message = Messages.getString("messageProperties","errorPanel$message$update");
				} else {
					message = Messages.getString("messageProperties","errorPanel$message$updatenotallowed");
					throw new Exception(message);
				}
			} else {
				if (isUPDATE_ALLOWED()) {
					helper.preInsert(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN, compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN());
					new CRUDHandler().executeInsert(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,CommonUtils.getConnection());
					message = Messages.getString("messageProperties","errorPanel$message$save");
				} else {
					message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
					throw new Exception(message);
				}
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{CommonUtils.getConnection().commit();}catch(Exception exception){exception.printStackTrace();}
		}
		return null;
	}
	
	



	public List<SelectItem> getDUDD_PARA_TYPE_LIST() {
		return DUDD_PARA_TYPE_LIST;
	}

	public void setDUDD_PARA_TYPE_LIST(List<SelectItem> dudd_para_type_list) {
		DUDD_PARA_TYPE_LIST = dudd_para_type_list;
	}

	public List<SelectItem> getDUDD_RET_PARA_LIST() {
		return DUDD_RET_PARA_LIST;
	}

	public void setDUDD_RET_PARA_LIST(List<SelectItem> dudd_ret_para_list) {
		DUDD_RET_PARA_LIST = dudd_ret_para_list;
	}

	public List<SelectItem> getDUDD_INPUT_DATA_TYPE() {
		return DUDD_INPUT_DATA_TYPE;
	}

	public void setDUDD_INPUT_DATA_TYPE(List<SelectItem> dudd_input_data_type) {
		DUDD_INPUT_DATA_TYPE = dudd_input_data_type;
	}

	public List<SelectItem> getDUDD_STORAGE_YN() {
		return DUDD_STORAGE_YN;
	}

	public void setDUDD_STORAGE_YN(List<SelectItem> dudd_storage_yn) {
		DUDD_STORAGE_YN = dudd_storage_yn;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getROWID() != null) {
					//helper.postQuery(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				} else {
					helper.whenCreateRecord(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorDUDD_SERIAL_NO(FacesContext context,UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_SERIAL_NO((Integer)value);
			if(value!=null){
				helper.L_UNIQUE_SERIAL_NO(compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getDUDH_DEF_CODE(), 
						value.toString(), PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getROWID());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean> tableLOV(Object event){
		suggesionList = new ArrayList<LovBean>();
		ResultSet rsSug1 = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT TABLE_NAME FROM USER_TABLES WHERE ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT TABLE_NAME FROM USER_TABLES WHERE " +
							" TABLE_NAME LIKE '%"+event.toString() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				suggesionList.add(lovBean);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("Product Code Suggestion", e.getMessage());
			}finally{try {CommonUtils.closeCursor(rsSug1);} catch (Exception e) {}}
			return suggesionList;
	}
	
	
	public void validatorDUDD_TableName(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_TABLE_NAME((String)value);
			if(value!=null){
				helper.validateTableName((String)value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validateDUDD_INPUT_DATA_TYPE(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_INPUT_DATA_TYPE(value);
	}
	
	public List<LovBean> duddFormatSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		suggesionList = new ArrayList<LovBean>();
		
		try {
			if("N".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_INPUT_DATA_TYPE())){
				suggesionList = itemUtil.P_CALL_LOV("PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL",
						"DUDD_FORMAT", "IL_NUM_FMT", null, null, null, null,
						(String) event);
			}else if ("D".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_INPUT_DATA_TYPE())){
				suggesionList = itemUtil.P_CALL_LOV("PILM042", "PM_IL_DATA_UPLOAD_DEFN_DTL",
						"DUDD_FORMAT", "IL_DATE_FMT", null, null, null, null,
						(String) event);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	
	public void validatorDUDD_FORMAT(FacesContext context,UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_FORMAT((String)value);
			if(value!=null){
				helper.validateDuddFormat((String)value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List<LovBean> fieldNameSugg(Object event){
		suggesionList = new ArrayList<LovBean>();
		ResultSet rsSug1 =null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT COLUMN_NAME,TABLE_NAME FROM USER_TAB_COLS WHERE TABLE_NAME ='PT_IL_POLICY' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT COLUMN_NAME,TABLE_NAME FROM USER_TAB_COLS WHERE TABLE_NAME ='PT_IL_POLICY' AND " +
							" COLUMN_NAME LIKE '%"+event.toString() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggesionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("Product Code Suggestion", e.getMessage());
			}finally{try {CommonUtils.closeCursor(rsSug1);} catch (Exception e) {}}
			return suggesionList;
	}
	
	public void validatorDUDD_FieldName(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_FIELD_NAME((String)value);
			if(value!=null){
				helper.validateDuddFieldName(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_FIELD_NAME(), PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_TABLE_NAME(),compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List<LovBean> linkColoumnSugg(Object event){
		suggesionList = new ArrayList<LovBean>();
		ResultSet rsSug1 = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT COLUMN_NAME,TABLE_NAME FROM USER_TAB_COLS WHERE TABLE_NAME ='PT_IL_POLICY' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT COLUMN_NAME,TABLE_NAME FROM USER_TAB_COLS WHERE TABLE_NAME ='PT_IL_POLICY' WHERE " +
							" COLUMN_NAME LIKE '%"+event.toString() +"%' AND ROWNUM < 20 ORDER BY 1 ASC ";
			}
			rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggesionList.add(lovBean);
			}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("Product Code Suggestion", e.getMessage());
			}finally{try {CommonUtils.closeCursor(rsSug1);} catch (Exception e) {}}
			return suggesionList;
	}

	public void validatorDUDD_linkColoumn(FacesContext context,UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_LINK_COLUMN((String)value);
			if(value!=null ){
				helper.validateDuddLink(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_LINK_COLUMN(), PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_TABLE_NAME(),compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorDUDD_RetPara(FacesContext context,UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_RET_PARA((String)value);
			if(value!=null){
				helper.retParaWhenValidator(compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN(),
						this);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorDUDD_linkSerialNo(FacesContext context,UIComponent component, Object value) {
		try {
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_LINK_SERIAL_NO((Integer)value);
			if(value!=null ){
				helper.whenValidateDUDDLinkSerialNo(compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN(),
						PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	/**
	 * Instantiates all components in PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DUDD_SERIAL_NO				 = new HtmlInputText();
		COMP_DUDD_PARA_NAME				 = new HtmlInputText();
		COMP_DUDD_FORMAT				 = new HtmlInputText();
		COMP_DUDD_TABLE_NAME				 = new HtmlInputText();
		COMP_DUDD_FIELD_NAME				 = new HtmlInputText();
		COMP_DUDD_LINK_COLUMN				 = new HtmlInputText();
		COMP_DUDD_LINK_SERIAL_NO			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_DUDD_PARA_TYPE				 = new HtmlSelectOneMenu();
		COMP_DUDD_INPUT_DATA_TYPE			 = new HtmlSelectOneMenu();
		COMP_DUDD_RET_PARA				 = new HtmlSelectOneMenu();
		COMP_DUDD_STORAGE_YN				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_EDIT_PARA_NAME			 = new HtmlCommandButton();
		COMP_UI_M_BUT_DUDD_FORMAT_LOV			 = new HtmlCommandButton();
		COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV		 = new HtmlCommandButton();
		COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV		 = new HtmlCommandButton();
		COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV		 = new HtmlCommandButton();

	}

	/**
	 * Resets all components in PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_DUDD_SERIAL_NO.resetValue();
		COMP_DUDD_PARA_NAME.resetValue();
		COMP_DUDD_FORMAT.resetValue();
		COMP_DUDD_TABLE_NAME.resetValue();
		COMP_DUDD_FIELD_NAME.resetValue();
		COMP_DUDD_LINK_COLUMN.resetValue();
		COMP_DUDD_LINK_SERIAL_NO.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_DUDD_PARA_TYPE.resetValue();
		COMP_DUDD_INPUT_DATA_TYPE.resetValue();
		COMP_DUDD_RET_PARA.resetValue();
		COMP_DUDD_STORAGE_YN.resetValue();
	}

	/**
	 * Disables all components in PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_DUDD_SERIAL_NO.setDisabled(disabled);
		COMP_DUDD_PARA_NAME.setDisabled(disabled);
		COMP_DUDD_FORMAT.setDisabled(disabled);
		COMP_DUDD_TABLE_NAME.setDisabled(disabled);
		COMP_DUDD_FIELD_NAME.setDisabled(disabled);
		COMP_DUDD_LINK_COLUMN.setDisabled(disabled);
		COMP_DUDD_LINK_SERIAL_NO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_DUDD_PARA_TYPE.setDisabled(disabled);
		COMP_DUDD_INPUT_DATA_TYPE.setDisabled(disabled);
		COMP_DUDD_RET_PARA.setDisabled(disabled);
		COMP_DUDD_STORAGE_YN.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_EDIT_PARA_NAME.setDisabled(disabled);
		COMP_UI_M_BUT_DUDD_FORMAT_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_DUDD_TABLE_NAME_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_DUDD_FIELD_NAME_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_DUDD_LINK_COLUMN_LOV.setDisabled(disabled);

	}
	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = new PM_IL_DATA_UPLOAD_DEFN_DTL();
				helper.whenCreateRecord(getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN());
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				/*helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(), 
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/
				new CRUDHandler().executeDelete(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				dataList_PM_IL_DATA_UPLOAD_DEFN_DTL.remove(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN);
				if (dataList_PM_IL_DATA_UPLOAD_DEFN_DTL.size() > 0) {

					PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = dataList_PM_IL_DATA_UPLOAD_DEFN_DTL
					.get(0);
				} else if (dataList_PM_IL_DATA_UPLOAD_DEFN_DTL.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
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
			if (PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(), compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN()
						
						);
				new CRUDHandler().executeInsert(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
				dataList_PM_IL_DATA_UPLOAD_DEFN_DTL.add(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN);
			} else if (PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getROWID() != null
					 && isUPDATE_ALLOWED()) {
				helper.preUpdate(getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(), compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN());
				new CRUDHandler().executeUpdate(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
			}
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setRowSelected(true);
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
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = (PM_IL_DATA_UPLOAD_DEFN_DTL) dataTable.getRowData();
			//helper.postQuery(this);
			// commeneted by akash( they are called execute and post query)
			//helper.whenNewBlockInstance(compositeAction);
			PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PM_IL_DATA_UPLOAD_DEFN_DTL> PM_IL_DATA_UPLOAD_DEFN_DTL_ITR = dataList_PM_IL_DATA_UPLOAD_DEFN_DTL
		.iterator();
		while (PM_IL_DATA_UPLOAD_DEFN_DTL_ITR.hasNext()) {
			PM_IL_DATA_UPLOAD_DEFN_DTL_ITR.next().setRowSelected(false);
		}
	}

	public List<PM_IL_DATA_UPLOAD_DEFN_DTL> getDataList_PM_IL_DATA_UPLOAD_DEFN_DTL() {
		return dataList_PM_IL_DATA_UPLOAD_DEFN_DTL;
	}

	public void setDataList_PM_IL_DATA_UPLOAD_DEFN_DTL(
			List<PM_IL_DATA_UPLOAD_DEFN_DTL> dataList_PM_IL_DATA_UPLOAD_DEFN_DTL) {
		this.dataList_PM_IL_DATA_UPLOAD_DEFN_DTL = dataList_PM_IL_DATA_UPLOAD_DEFN_DTL;
	}


}

package com.iii.pel.forms.PILM012;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BROKER_SETUP_ACTION extends CommonAction {

	private PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN;

	public PILM012_COMPOSITE_ACTION compositeAction;

	private PM_IL_BROKER_SETUP_HELPER helper;

	private List<PM_IL_BROKER_SETUP> dataList_PM_IL_BROKER_SETUP = new ArrayList<PM_IL_BROKER_SETUP>();

	private HtmlOutputLabel COMP_BS_CUST_CLASS_LABEL;
	
	private  HtmlInputText COMP_UI_M_BS_CUST_CLASS;
	
	private  HtmlInputText COMP_UI_M_BS_COVER_CODE;

	private HtmlInputText COMP_BS_CUST_CLASS;
	
	private HtmlOutputLabel COMP_BS_COVER_CODE_LABEL;

	private HtmlInputText COMP_BS_COVER_CODE;
	
	private HtmlOutputLabel COMP_BS_YEARS_FROM_LABEL;

	private HtmlInputText COMP_BS_YEARS_FROM;

	private HtmlOutputLabel COMP_BS_YEARS_TO_LABEL;

	private HtmlInputText COMP_BS_YEARS_TO;
	
	private HtmlOutputLabel COMP_BS_PERC_LABEL;

	private HtmlInputText COMP_BS_PERC;

	private HtmlOutputLabel COMP_BS_CR_DT_LABEL;

	private HtmlInputText COMP_BS_CR_DT;
	
	private HtmlOutputLabel COMP_BS_CR_UID_LABEL;

	private HtmlInputText COMP_BS_CR_UID;

	private HtmlOutputLabel COMP_BS_UPD_DT_LABEL;

	private HtmlInputText COMP_BS_UPD_DT;

	private HtmlOutputLabel COMP_BS_UPD_UID_LABEL;

	private HtmlInputText COMP_BS_UPD_UID;

	private HtmlOutputLabel COMP_BS_COMM_CODE_LABEL;

	private HtmlOutputLabel COMP_BS_TERM_FM_LABEL;
	
	private HtmlInputText COMP_BS_TERM_FM;

	private HtmlOutputLabel COMP_BS_TERM_TO_LABEL;

	private HtmlInputText COMP_BS_TERM_TO;
	
	private HtmlOutputLabel COMP_BS_SA_FM_LABEL;

	private HtmlInputText COMP_BS_SA_FM;
	
	private HtmlOutputLabel COMP_BS_SA_TO_LABEL;

	private HtmlInputText COMP_BS_SA_TO;
	
	private HtmlOutputLabel COMP_BS_RATE_PER_LABEL;

	private HtmlInputText COMP_BS_RATE_PER;
	
	private HtmlOutputLabel COMP_BS_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_BS_EFF_TO_DT;

	private HtmlCalendar COMP_BS_EFF_FM_DT;
	
	private HtmlOutputLabel COMP_BS_EFF_TO_DT_LABEL;

	private HtmlOutputLabel COMP_BS_APPLY_ON_LABEL;
	
	private HtmlSelectOneMenu COMP_BS_APPLY_ON;
	
	private HtmlSelectOneMenu COMP_BS_COMM_CODE;
	
	private List<SelectItem> listBS_APPLY_ON = new ArrayList<SelectItem>();
	
	private List<SelectItem> listBS_COMM_CODE = new ArrayList<SelectItem>();
	
	private UIData dataTable;

	public PM_IL_BROKER_SETUP_ACTION() {

		PM_IL_BROKER_SETUP_BEAN = new PM_IL_BROKER_SETUP();
		helper = new PM_IL_BROKER_SETUP_HELPER();
		prepareDropDowns();
	
	}
	
	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setListBS_APPLY_ON(ListItemUtil.getDropDownListValue_1(
					connection, "PILM012", "PM_IL_BROKER_SETUP",
					"PM_IL_BROKER_SETUP.BS_APPLY_ON", null));
			setListBS_COMM_CODE(ListItemUtil.getDropDownListValue_1(
					connection, "PILM012", "PM_IL_BROKER_SETUP",
					"PM_IL_BROKER_SETUP.BS_COMM_CODE", null));

		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	

	public PM_IL_BROKER_SETUP getPM_IL_BROKER_SETUP_BEAN() {
		return PM_IL_BROKER_SETUP_BEAN;
	}

	public void setPM_IL_BROKER_SETUP_BEAN(
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN) {
		this.PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_BEAN;
	}

	public List<PM_IL_BROKER_SETUP> getDataList_PM_IL_BROKER_SETUP() {
		return dataList_PM_IL_BROKER_SETUP;
	}

	public void setDataListPM_IL_BROKER_SETUP(
			List<PM_IL_BROKER_SETUP> dataList_PM_IL_BROKER_SETUP) {
		this.dataList_PM_IL_BROKER_SETUP = dataList_PM_IL_BROKER_SETUP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_BROKER_SETUP_BEAN = new PM_IL_BROKER_SETUP();
				// resetAllComponent();
				// resetSelectedRow();
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

	
	
	public void saveRecord(){
		String message = "";
		try{
			CommonUtils.clearMaps(this);
		if(getPM_IL_BROKER_SETUP_BEAN().getROWID() == null){
				if(isINSERT_ALLOWED()){
					helper.pre_Insert(this);
				new CRUDHandler().executeInsert(getPM_IL_BROKER_SETUP_BEAN(),CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("SAVE", message);
			}else{
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
		}else{
				if(isUPDATE_ALLOWED()){
					helper.pre_Update(this);
				new CRUDHandler().executeInsert(getPM_IL_BROKER_SETUP_BEAN(),
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				getWarningMap().put("UPDATE", message);
			} else{
				message = Messages.getString("messageProperties",
				"errorPanel$message$updatenotallowed");
		getErrorMap()
				.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
		getErrorMap().put("UPDATE", message);
			}
		}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{
				CommonUtils utils = new CommonUtils();
				utils.doComitt();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}

	public String backToSearch() {
    	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		PM_IL_BROKER_SETUP_DELEGATE degate = new PM_IL_BROKER_SETUP_DELEGATE();
		try {
			if (isBlockFlag()) {
				degate.executeSelectStatement(compositeAction);
				if(PM_IL_BROKER_SETUP_BEAN.getROWID() != null){
					helper.postQuery(this);
				}else{
					helper.when_Create_Record(this);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PILM012_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM012_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_BROKER_SETUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_BROKER_SETUP_HELPER helper) {
		this.helper = helper;
	}

	public HtmlOutputLabel getCOMP_BS_CUST_CLASS_LABEL() {
		return COMP_BS_CUST_CLASS_LABEL;
	}

	public void setCOMP_BS_CUST_CLASS_LABEL(HtmlOutputLabel comp_bs_cust_class_label) {
		COMP_BS_CUST_CLASS_LABEL = comp_bs_cust_class_label;
	}

	public HtmlInputText getCOMP_BS_CUST_CLASS() {
		return COMP_BS_CUST_CLASS;
	}

	public void setCOMP_BS_CUST_CLASS(HtmlInputText comp_bs_cust_class) {
		COMP_BS_CUST_CLASS = comp_bs_cust_class;
	}

	public HtmlOutputLabel getCOMP_BS_COVER_CODE_LABEL() {
		return COMP_BS_COVER_CODE_LABEL;
	}

	public void setCOMP_BS_COVER_CODE_LABEL(HtmlOutputLabel comp_bs_cover_code_label) {
		COMP_BS_COVER_CODE_LABEL = comp_bs_cover_code_label;
	}

	public HtmlInputText getCOMP_BS_COVER_CODE() {
		return COMP_BS_COVER_CODE;
	}

	public void setCOMP_BS_COVER_CODE(HtmlInputText comp_bs_cover_code) {
		COMP_BS_COVER_CODE = comp_bs_cover_code;
	}

	public HtmlOutputLabel getCOMP_BS_YEARS_FROM_LABEL() {
		return COMP_BS_YEARS_FROM_LABEL;
	}

	public void setCOMP_BS_YEARS_FROM_LABEL(HtmlOutputLabel comp_bs_years_from_label) {
		COMP_BS_YEARS_FROM_LABEL = comp_bs_years_from_label;
	}

	public HtmlInputText getCOMP_BS_YEARS_FROM() {
		return COMP_BS_YEARS_FROM;
	}

	public void setCOMP_BS_YEARS_FROM(HtmlInputText comp_bs_years_from) {
		COMP_BS_YEARS_FROM = comp_bs_years_from;
	}

	public HtmlOutputLabel getCOMP_BS_YEARS_TO_LABEL() {
		return COMP_BS_YEARS_TO_LABEL;
	}

	public void setCOMP_BS_YEARS_TO_LABEL(HtmlOutputLabel comp_bs_years_to_label) {
		COMP_BS_YEARS_TO_LABEL = comp_bs_years_to_label;
	}

	public HtmlInputText getCOMP_BS_YEARS_TO() {
		return COMP_BS_YEARS_TO;
	}

	public void setCOMP_BS_YEARS_TO(HtmlInputText comp_bs_years_to) {
		COMP_BS_YEARS_TO = comp_bs_years_to;
	}

	public HtmlOutputLabel getCOMP_BS_PERC_LABEL() {
		return COMP_BS_PERC_LABEL;
	}

	public void setCOMP_BS_PERC_LABEL(HtmlOutputLabel comp_bs_perc_label) {
		COMP_BS_PERC_LABEL = comp_bs_perc_label;
	}

	public HtmlInputText getCOMP_BS_PERC() {
		return COMP_BS_PERC;
	}

	public void setCOMP_BS_PERC(HtmlInputText comp_bs_perc) {
		COMP_BS_PERC = comp_bs_perc;
	}

	public HtmlOutputLabel getCOMP_BS_CR_DT_LABEL() {
		return COMP_BS_CR_DT_LABEL;
	}

	public void setCOMP_BS_CR_DT_LABEL(HtmlOutputLabel comp_bs_cr_dt_label) {
		COMP_BS_CR_DT_LABEL = comp_bs_cr_dt_label;
	}

	public HtmlInputText getCOMP_BS_CR_DT() {
		return COMP_BS_CR_DT;
	}

	public void setCOMP_BS_CR_DT(HtmlInputText comp_bs_cr_dt) {
		COMP_BS_CR_DT = comp_bs_cr_dt;
	}

	public HtmlOutputLabel getCOMP_BS_CR_UID_LABEL() {
		return COMP_BS_CR_UID_LABEL;
	}

	public void setCOMP_BS_CR_UID_LABEL(HtmlOutputLabel comp_bs_cr_uid_label) {
		COMP_BS_CR_UID_LABEL = comp_bs_cr_uid_label;
	}

	public HtmlInputText getCOMP_BS_CR_UID() {
		return COMP_BS_CR_UID;
	}

	public void setCOMP_BS_CR_UID(HtmlInputText comp_bs_cr_uid) {
		COMP_BS_CR_UID = comp_bs_cr_uid;
	}

	public HtmlOutputLabel getCOMP_BS_UPD_DT_LABEL() {
		return COMP_BS_UPD_DT_LABEL;
	}

	public void setCOMP_BS_UPD_DT_LABEL(HtmlOutputLabel comp_bs_upd_dt_label) {
		COMP_BS_UPD_DT_LABEL = comp_bs_upd_dt_label;
	}

	public HtmlInputText getCOMP_BS_UPD_DT() {
		return COMP_BS_UPD_DT;
	}

	public void setCOMP_BS_UPD_DT(HtmlInputText comp_bs_upd_dt) {
		COMP_BS_UPD_DT = comp_bs_upd_dt;
	}

	public HtmlOutputLabel getCOMP_BS_UPD_UID_LABEL() {
		return COMP_BS_UPD_UID_LABEL;
	}

	public void setCOMP_BS_UPD_UID_LABEL(HtmlOutputLabel comp_bs_upd_uid_label) {
		COMP_BS_UPD_UID_LABEL = comp_bs_upd_uid_label;
	}

	public HtmlInputText getCOMP_BS_UPD_UID() {
		return COMP_BS_UPD_UID;
	}

	public void setCOMP_BS_UPD_UID(HtmlInputText comp_bs_upd_uid) {
		COMP_BS_UPD_UID = comp_bs_upd_uid;
	}

	public HtmlOutputLabel getCOMP_BS_COMM_CODE_LABEL() {
		return COMP_BS_COMM_CODE_LABEL;
	}

	public void setCOMP_BS_COMM_CODE_LABEL(HtmlOutputLabel comp_bs_comm_code_label) {
		COMP_BS_COMM_CODE_LABEL = comp_bs_comm_code_label;
	}

	public HtmlInputText getCOMP_BS_TERM_FM() {
		return COMP_BS_TERM_FM;
	}

	public void setCOMP_BS_TERM_FM(HtmlInputText comp_bs_term_fm) {
		COMP_BS_TERM_FM = comp_bs_term_fm;
	}

	public HtmlOutputLabel getCOMP_BS_TERM_TO_LABEL() {
		return COMP_BS_TERM_TO_LABEL;
	}

	public void setCOMP_BS_TERM_TO_LABEL(HtmlOutputLabel comp_bs_term_to_label) {
		COMP_BS_TERM_TO_LABEL = comp_bs_term_to_label;
	}

	public HtmlInputText getCOMP_BS_TERM_TO() {
		return COMP_BS_TERM_TO;
	}

	public void setCOMP_BS_TERM_TO(HtmlInputText comp_bs_term_to) {
		COMP_BS_TERM_TO = comp_bs_term_to;
	}

	public HtmlOutputLabel getCOMP_BS_SA_FM_LABEL() {
		return COMP_BS_SA_FM_LABEL;
	}

	public void setCOMP_BS_SA_FM_LABEL(HtmlOutputLabel comp_bs_sa_fm_label) {
		COMP_BS_SA_FM_LABEL = comp_bs_sa_fm_label;
	}

	public HtmlInputText getCOMP_BS_SA_FM() {
		return COMP_BS_SA_FM;
	}

	public void setCOMP_BS_SA_FM(HtmlInputText comp_bs_sa_fm) {
		COMP_BS_SA_FM = comp_bs_sa_fm;
	}

	public HtmlOutputLabel getCOMP_BS_SA_TO_LABEL() {
		return COMP_BS_SA_TO_LABEL;
	}

	public void setCOMP_BS_SA_TO_LABEL(HtmlOutputLabel comp_bs_sa_to_label) {
		COMP_BS_SA_TO_LABEL = comp_bs_sa_to_label;
	}

	public HtmlInputText getCOMP_BS_SA_TO() {
		return COMP_BS_SA_TO;
	}

	public void setCOMP_BS_SA_TO(HtmlInputText comp_bs_sa_to) {
		COMP_BS_SA_TO = comp_bs_sa_to;
	}

	public HtmlOutputLabel getCOMP_BS_RATE_PER_LABEL() {
		return COMP_BS_RATE_PER_LABEL;
	}

	public void setCOMP_BS_RATE_PER_LABEL(HtmlOutputLabel comp_bs_rate_per_label) {
		COMP_BS_RATE_PER_LABEL = comp_bs_rate_per_label;
	}

	public HtmlInputText getCOMP_BS_RATE_PER() {
		return COMP_BS_RATE_PER;
	}

	public void setCOMP_BS_RATE_PER(HtmlInputText comp_bs_rate_per) {
		COMP_BS_RATE_PER = comp_bs_rate_per;
	}

	public HtmlOutputLabel getCOMP_BS_APPLY_ON_LABEL() {
		return COMP_BS_APPLY_ON_LABEL;
	}

	public void setCOMP_BS_APPLY_ON_LABEL(HtmlOutputLabel comp_bs_apply_on_label) {
		COMP_BS_APPLY_ON_LABEL = comp_bs_apply_on_label;
	}

	public HtmlOutputLabel getCOMP_BS_EFF_FM_DT_LABEL() {
		return COMP_BS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_BS_EFF_FM_DT_LABEL(HtmlOutputLabel comp_bs_eff_fm_dt_label) {
		COMP_BS_EFF_FM_DT_LABEL = comp_bs_eff_fm_dt_label;
	}

	
	public HtmlOutputLabel getCOMP_BS_EFF_TO_DT_LABEL() {
		return COMP_BS_EFF_TO_DT_LABEL;
	}

	public void setDataList_PM_IL_BROKER_SETUP(
			List<PM_IL_BROKER_SETUP> dataList_PM_IL_BROKER_SETUP) {
		this.dataList_PM_IL_BROKER_SETUP = dataList_PM_IL_BROKER_SETUP;
	}


	public HtmlOutputLabel getCOMP_BS_TERM_FM_LABEL() {
		return COMP_BS_TERM_FM_LABEL;
	}

	public void setCOMP_BS_TERM_FM_LABEL(HtmlOutputLabel comp_bs_term_fm_label) {
		COMP_BS_TERM_FM_LABEL = comp_bs_term_fm_label;
	}

	public void validateBS_CUST_CLASS(FacesContext fc, UIComponent component,
			Object value){
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_CUST_CLASS((String) value);
		helper.when_Validate_Cust_Class(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_COVER_CODE(FacesContext fc, UIComponent component,
			Object value){
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_COVER_CODE((String) value);
		helper.when_Validate_Cover_Code(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateBS_APPLY_ON(FacesContext fc, UIComponent component,
			Object value){
		try{
		UIInput input = (UIInput) component;
		PM_IL_BROKER_SETUP_BEAN.setBS_APPLY_ON((String) value);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_COMM_CODE(FacesContext fc, UIComponent component,
			Object value){
		try{
		UIInput input = (UIInput) component;
		PM_IL_BROKER_SETUP_BEAN.setBS_COMM_CODE((String) value);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateBS_TERM_FM(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_TERM_FM((Integer) value);
		helper.when_Validate_BS_TERM_FM(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateBS_TERM_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_TERM_TO((Integer) value);
		helper.when_Validate_BS_TERM_TO(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_SA_FM(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_SA_FM((Double) value);
		helper.when_Validate_BS_SA_FM(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateBS_SA_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_SA_TO((Double) value);
		helper.when_Validate_BS_SA_TO(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_YEARS_FROM(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		UIInput input = (UIInput) component;
		PM_IL_BROKER_SETUP_BEAN.setBS_YEARS_FROM((Integer) value);
		helper.when_Validate_BS_YEARS_FROM(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_YEARS_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_YEARS_TO((Integer) value);
		helper.when_Validate_BS_YEARS_TO(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateBS_PERC(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_PERC((Double) value);
		helper.when_Validate_BS_PERC(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateBS_RATE_PER(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_RATE_PER((Double) value);
		helper.when_Validate_BS_RATE_PER(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateBS_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_EFF_FM_DT((Date) value);
		helper.when_Validate_BS_EFF_FM_DT(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateBS_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		try{
		PM_IL_BROKER_SETUP_BEAN.setBS_EFF_TO_DT((Date) value);
		helper.when_Validate_BS_EFF_TO_DT(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List<LovBean> lovBS_CUST_CLASS(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM012",
					"PM_IL_BROKER_SETUP", "BS_CUST_CLASS",
					PM_IL_BROKER_SETUP_BEAN.getBS_CUST_CLASS(),null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovBS_COVER_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM012",
					"PM_IL_BROKER_SETUP", "BS_COVER_CODE",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public void validateDS_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date fromDate = htmlCalendar
				.getAsDate(htmlCalendar.getSubmittedValue());
		PM_IL_BROKER_SETUP_BEAN.setBS_EFF_FM_DT(fromDate);
		Date toDate = (Date) PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT();
		helper.when_Validate_BS_EFF_FM_DT(this);
	}

	public void validateDS_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date toDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
		PM_IL_BROKER_SETUP_BEAN.setBS_EFF_TO_DT(toDate);
		Date fromDate = (Date) PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT();
		helper.when_Validate_BS_EFF_TO_DT(this);
	}

	public HtmlCalendar getCOMP_BS_EFF_TO_DT() {
		return COMP_BS_EFF_TO_DT;
	}

	public void setCOMP_BS_EFF_TO_DT(HtmlCalendar comp_bs_eff_to_dt) {
		COMP_BS_EFF_TO_DT = comp_bs_eff_to_dt;
	}

	public HtmlCalendar getCOMP_BS_EFF_FM_DT() {
		return COMP_BS_EFF_FM_DT;
	}

	public void setCOMP_BS_EFF_FM_DT(HtmlCalendar comp_bs_eff_fm_dt) {
		COMP_BS_EFF_FM_DT = comp_bs_eff_fm_dt;
	}

	public void setCOMP_BS_EFF_TO_DT_LABEL(HtmlOutputLabel comp_bs_eff_to_dt_label) {
		COMP_BS_EFF_TO_DT_LABEL = comp_bs_eff_to_dt_label;
	}

	public void setCOMP_BS_APPLY_ON(HtmlSelectOneMenu comp_bs_apply_on) {
		COMP_BS_APPLY_ON = comp_bs_apply_on;
	}

	public List<SelectItem> getListBS_APPLY_ON() {
		return listBS_APPLY_ON;
	}

	public void setListBS_APPLY_ON(List<SelectItem> listBS_APPLY_ON) {
		this.listBS_APPLY_ON = listBS_APPLY_ON;
	}

	public HtmlSelectOneMenu getCOMP_BS_APPLY_ON() {
		return COMP_BS_APPLY_ON;
	}

	public HtmlSelectOneMenu getCOMP_BS_COMM_CODE() {
		return COMP_BS_COMM_CODE;
	}

	public void setCOMP_BS_COMM_CODE(HtmlSelectOneMenu comp_bs_comm_code) {
		COMP_BS_COMM_CODE = comp_bs_comm_code;
	}

	public List<SelectItem> getListBS_COMM_CODE() {
		return listBS_COMM_CODE;
	}

	public void setListBS_COMM_CODE(List<SelectItem> listBS_COMM_CODE) {
		this.listBS_COMM_CODE = listBS_COMM_CODE;
	}

	public HtmlInputText getCOMP_UI_M_BS_CUST_CLASS() {
		return COMP_UI_M_BS_CUST_CLASS;
	}

	public void setCOMP_UI_M_BS_CUST_CLASS(HtmlInputText comp_ui_m_bs_cust_class) {
		COMP_UI_M_BS_CUST_CLASS = comp_ui_m_bs_cust_class;
	}

	public HtmlInputText getCOMP_UI_M_BS_COVER_CODE() {
		return COMP_UI_M_BS_COVER_CODE;
	}

	public void setCOMP_UI_M_BS_COVER_CODE(HtmlInputText comp_ui_m_bs_cover_code) {
		COMP_UI_M_BS_COVER_CODE = comp_ui_m_bs_cover_code;
	}

}

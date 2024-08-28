package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxRegion;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_SA_INST_PYMT_HEAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SIPH_NAV_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_SIPH_NAV_TYPE;

	private HtmlOutputLabel COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_SIPH_PROD_MAT_AMT_TYPE;

	private HtmlOutputLabel COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL;

	private HtmlInputText COMP_SIPH_PROD_SURR_PLUS_FACTOR;

	private HtmlOutputLabel COMP_UI_M_PT_SID_FACTOR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PT_SID_FACTOR_DESC;

	private HtmlOutputLabel COMP_SIPH_PROD_MAT_RATE_LABEL;

	private HtmlInputText COMP_SIPH_PROD_MAT_RATE;

	private HtmlOutputLabel COMP_SIPH_PROD_MAT_RATE_PER_LABEL;

	private HtmlInputText COMP_SIPH_PROD_MAT_RATE_PER;

	private HtmlOutputLabel COMP_SIPH_MAT_AGE_LABEL;

	private HtmlInputText COMP_SIPH_MAT_AGE;
	
	private HtmlAjaxRegion COMP_PROD_SURR_PLUS_FACTOR_A4J;


	private PT_IL_POL_SA_INST_PYMT_HEAD PT_IL_POL_SA_INST_PYMT_HEAD_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_SA_INST_PYMT_HEAD_HELPER helper;

	private List<SelectItem> listSIPH_NAV_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listSIPH_PROD_MAT_AMT_TYPE = new ArrayList<SelectItem>();

	public PT_IL_POL_SA_INST_PYMT_HEAD_ACTION() {

		PT_IL_POL_SA_INST_PYMT_HEAD_BEAN = new PT_IL_POL_SA_INST_PYMT_HEAD();
		helper = new PT_IL_POL_SA_INST_PYMT_HEAD_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}
	
	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listSIPH_NAV_TYPE = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_SA_INST_PYMT_HEAD", 
					"PT_IL_POL_SA_INST_PYMT_HEAD.SIPH_NAV_TYPE", "POL_NAV_TYPE");
			listSIPH_PROD_MAT_AMT_TYPE = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_SA_INST_PYMT_HEAD", 
					"PT_IL_POL_SA_INST_PYMT_HEAD.SIPH_PROD_MAT_AMT_TYPE", "IL_MAT_AMT");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_SIPH_NAV_TYPE_LABEL() {
		return COMP_SIPH_NAV_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_SIPH_NAV_TYPE() {
		return COMP_SIPH_NAV_TYPE;
	}

	public void setCOMP_SIPH_NAV_TYPE_LABEL(
			HtmlOutputLabel COMP_SIPH_NAV_TYPE_LABEL) {
		this.COMP_SIPH_NAV_TYPE_LABEL = COMP_SIPH_NAV_TYPE_LABEL;
	}

	public void setCOMP_SIPH_NAV_TYPE(HtmlSelectOneMenu COMP_SIPH_NAV_TYPE) {
		this.COMP_SIPH_NAV_TYPE = COMP_SIPH_NAV_TYPE;
	}

	public HtmlOutputLabel getCOMP_SIPH_PROD_MAT_AMT_TYPE_LABEL() {
		return COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_SIPH_PROD_MAT_AMT_TYPE() {
		return COMP_SIPH_PROD_MAT_AMT_TYPE;
	}

	public void setCOMP_SIPH_PROD_MAT_AMT_TYPE_LABEL(
			HtmlOutputLabel COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL) {
		this.COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL = COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL;
	}

	public void setCOMP_SIPH_PROD_MAT_AMT_TYPE(
			HtmlSelectOneMenu COMP_SIPH_PROD_MAT_AMT_TYPE) {
		this.COMP_SIPH_PROD_MAT_AMT_TYPE = COMP_SIPH_PROD_MAT_AMT_TYPE;
	}

	public HtmlOutputLabel getCOMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL() {
		return COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_SIPH_PROD_SURR_PLUS_FACTOR() {
		return COMP_SIPH_PROD_SURR_PLUS_FACTOR;
	}

	public void setCOMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL(
			HtmlOutputLabel COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL) {
		this.COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL = COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL;
	}

	public void setCOMP_SIPH_PROD_SURR_PLUS_FACTOR(
			HtmlInputText COMP_SIPH_PROD_SURR_PLUS_FACTOR) {
		this.COMP_SIPH_PROD_SURR_PLUS_FACTOR = COMP_SIPH_PROD_SURR_PLUS_FACTOR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PT_SID_FACTOR_DESC_LABEL() {
		return COMP_UI_M_PT_SID_FACTOR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PT_SID_FACTOR_DESC() {
		return COMP_UI_M_PT_SID_FACTOR_DESC;
	}

	public void setCOMP_UI_M_PT_SID_FACTOR_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PT_SID_FACTOR_DESC_LABEL) {
		this.COMP_UI_M_PT_SID_FACTOR_DESC_LABEL = COMP_UI_M_PT_SID_FACTOR_DESC_LABEL;
	}

	public void setCOMP_UI_M_PT_SID_FACTOR_DESC(
			HtmlInputText COMP_UI_M_PT_SID_FACTOR_DESC) {
		this.COMP_UI_M_PT_SID_FACTOR_DESC = COMP_UI_M_PT_SID_FACTOR_DESC;
	}

	public HtmlOutputLabel getCOMP_SIPH_PROD_MAT_RATE_LABEL() {
		return COMP_SIPH_PROD_MAT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_SIPH_PROD_MAT_RATE() {
		return COMP_SIPH_PROD_MAT_RATE;
	}

	public void setCOMP_SIPH_PROD_MAT_RATE_LABEL(
			HtmlOutputLabel COMP_SIPH_PROD_MAT_RATE_LABEL) {
		this.COMP_SIPH_PROD_MAT_RATE_LABEL = COMP_SIPH_PROD_MAT_RATE_LABEL;
	}

	public void setCOMP_SIPH_PROD_MAT_RATE(HtmlInputText COMP_SIPH_PROD_MAT_RATE) {
		this.COMP_SIPH_PROD_MAT_RATE = COMP_SIPH_PROD_MAT_RATE;
	}

	public HtmlOutputLabel getCOMP_SIPH_PROD_MAT_RATE_PER_LABEL() {
		return COMP_SIPH_PROD_MAT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_SIPH_PROD_MAT_RATE_PER() {
		return COMP_SIPH_PROD_MAT_RATE_PER;
	}

	public void setCOMP_SIPH_PROD_MAT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_SIPH_PROD_MAT_RATE_PER_LABEL) {
		this.COMP_SIPH_PROD_MAT_RATE_PER_LABEL = COMP_SIPH_PROD_MAT_RATE_PER_LABEL;
	}

	public void setCOMP_SIPH_PROD_MAT_RATE_PER(
			HtmlInputText COMP_SIPH_PROD_MAT_RATE_PER) {
		this.COMP_SIPH_PROD_MAT_RATE_PER = COMP_SIPH_PROD_MAT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_SIPH_MAT_AGE_LABEL() {
		return COMP_SIPH_MAT_AGE_LABEL;
	}

	public HtmlInputText getCOMP_SIPH_MAT_AGE() {
		return COMP_SIPH_MAT_AGE;
	}

	public void setCOMP_SIPH_MAT_AGE_LABEL(
			HtmlOutputLabel COMP_SIPH_MAT_AGE_LABEL) {
		this.COMP_SIPH_MAT_AGE_LABEL = COMP_SIPH_MAT_AGE_LABEL;
	}

	public void setCOMP_SIPH_MAT_AGE(HtmlInputText COMP_SIPH_MAT_AGE) {
		this.COMP_SIPH_MAT_AGE = COMP_SIPH_MAT_AGE;
	}

	public PT_IL_POL_SA_INST_PYMT_HEAD getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN() {
		return PT_IL_POL_SA_INST_PYMT_HEAD_BEAN;
	}

	public void setPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(
			PT_IL_POL_SA_INST_PYMT_HEAD PT_IL_POL_SA_INST_PYMT_HEAD_BEAN) {
		this.PT_IL_POL_SA_INST_PYMT_HEAD_BEAN = PT_IL_POL_SA_INST_PYMT_HEAD_BEAN;
	}

	public void saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().getROWID() == null) {
				helper.preInsert(getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(
						getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(), CommonUtils
								.getConnection());
				
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
				helper.postInsert(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			} else if (getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().getROWID() != null )  {
				helper.preUpdate(getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(
						getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(), CommonUtils
								.getConnection());
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
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListSIPH_NAV_TYPE() {
		if (listSIPH_NAV_TYPE.size() == 0) {
			listSIPH_NAV_TYPE.clear();
			try {
				listSIPH_NAV_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listSIPH_NAV_TYPE;
	}

	public void setListSIPH_NAV_TYPE(List<SelectItem> listSIPH_NAV_TYPE) {
		this.listSIPH_NAV_TYPE = listSIPH_NAV_TYPE;
	}

	public List<SelectItem> getListSIPH_PROD_MAT_AMT_TYPE() {
		if (listSIPH_PROD_MAT_AMT_TYPE.size() == 0) {
			listSIPH_PROD_MAT_AMT_TYPE.clear();
			try {
				listSIPH_PROD_MAT_AMT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listSIPH_PROD_MAT_AMT_TYPE;
	}

	public void setListSIPH_PROD_MAT_AMT_TYPE(
			List<SelectItem> listSIPH_PROD_MAT_AMT_TYPE) {
		this.listSIPH_PROD_MAT_AMT_TYPE = listSIPH_PROD_MAT_AMT_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String fireFieldValidation1() {
		System.out.println("--------------->Nav type action called...");
		ErrorHelpUtil.validate(COMP_SIPH_NAV_TYPE, getErrorMap());
		return null;
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.getROWID() != null){
					helper.postQuery(this,
							compositeAction.getDUMMY_ACTION_BEAN(),
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}else{
					helper.whenCreateRecord(getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN());
				}
				helper.whenNewRecordInstance(this,compositeAction.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN());
				
				if("Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())){
					COMP_SIPH_PROD_MAT_RATE_PER.setDisabled(true);
					COMP_SIPH_PROD_MAT_RATE.setDisabled(true);
				}
				setBlockFlag(false);
			}if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD()== 2){
				COMP_PROD_SURR_PLUS_FACTOR_A4J.setRendered(false);
			}
							else{
								COMP_PROD_SURR_PLUS_FACTOR_A4J.setRendered(true);					
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void SIPH_NAV_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().setSIPH_NAV_TYPE((String)value);
			helper.SIPH_NAV_TYPE_WHEN_VALIDATE_ITEM(this,
					compositeAction.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN(),
					compositeAction.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN(),compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void SIPH_PROD_MAT_AMT_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		try {
			getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().setSIPH_PROD_MAT_AMT_TYPE((String)value);
			helper.SIPH_PROD_MAT_AMT_TYPE_WHEN_VALIDATE_ITEM(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void SIPH_PROD_SURR_PLUS_FACTOR_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		try {
			getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().setSIPH_PROD_SURR_PLUS_FACTOR((String)value);
			helper.SIPH_PROD_SURR_PLUS_FACTOR_WHEN_VALIDATE_ITEM(getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	public void SIPH_PROD_MAT_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		try {
			getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().setSIPH_PROD_MAT_RATE((Double)value);
			helper.SIPH_PROD_MAT_RATE_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void SIPH_PROD_MAT_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		try {
			getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().setSIPH_PROD_MAT_RATE_PER((Double)value);
			helper.SIPH_PROD_MAT_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	public ArrayList<LovBean> prepareSuggestionList_SIPH_PROD_SURR_PLUS_FACTOR(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_SA_INST_PYMT_HEAD";
		String fieldName = "SIPH_PROD_SURR_PLUS_FACTOR";
		Object param1 = "IL_VAL_TAR";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	public void delete() {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.preDelete(getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_SA_INST_PYMT_HEAD_BEAN,
						CommonUtils.getConnection());

				CommonUtils.getConnection().commit();
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				resetAllComponent();
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN = new PT_IL_POL_SA_INST_PYMT_HEAD();
				setBlockFlag(false);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	public void resetAllComponent(){
		
	}


	/**
	 * Disables all components in PT_IL_POL_SA_INST_PYMT_HEAD_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_SIPH_PROD_SURR_PLUS_FACTOR.setDisabled(disabled);
		COMP_UI_M_PT_SID_FACTOR_DESC.setDisabled(disabled);
		COMP_SIPH_PROD_MAT_RATE.setDisabled(disabled);
		COMP_SIPH_PROD_MAT_RATE_PER.setDisabled(disabled);
		COMP_SIPH_MAT_AGE.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_SIPH_NAV_TYPE.setDisabled(disabled);
		COMP_SIPH_PROD_MAT_AMT_TYPE.setDisabled(disabled);

	}

	/**
	 * Instantiates all components in PT_IL_POL_SA_INST_PYMT_HEAD_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_SIPH_PROD_SURR_PLUS_FACTOR			 = new HtmlInputText();
		COMP_UI_M_PT_SID_FACTOR_DESC			 = new HtmlInputText();
		COMP_SIPH_PROD_MAT_RATE				 = new HtmlInputText();
		COMP_SIPH_PROD_MAT_RATE_PER			 = new HtmlInputText();
		COMP_SIPH_MAT_AGE				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_SIPH_NAV_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_SIPH_PROD_MAT_AMT_TYPE_LABEL		 = new HtmlOutputLabel();
		COMP_SIPH_PROD_SURR_PLUS_FACTOR_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_PT_SID_FACTOR_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_SIPH_PROD_MAT_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_SIPH_PROD_MAT_RATE_PER_LABEL		 = new HtmlOutputLabel();
		COMP_SIPH_MAT_AGE_LABEL				 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_SIPH_NAV_TYPE				 = new HtmlSelectOneMenu();
		COMP_SIPH_PROD_MAT_AMT_TYPE			 = new HtmlSelectOneMenu();

	}

	public HtmlAjaxRegion getCOMP_PROD_SURR_PLUS_FACTOR_A4J() {
		return COMP_PROD_SURR_PLUS_FACTOR_A4J;
	}

	public void setCOMP_PROD_SURR_PLUS_FACTOR_A4J(
			HtmlAjaxRegion comp_prod_surr_plus_factor_a4j) {
		COMP_PROD_SURR_PLUS_FACTOR_A4J = comp_prod_surr_plus_factor_a4j;
	}



}

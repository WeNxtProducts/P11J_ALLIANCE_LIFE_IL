package com.iii.pel.forms.PILM060_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.xml.bind.ValidationException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UICalendar;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE_CONSTANTS;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_CONTRI_CHARGE;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_HELPER;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ASSURED_DTLS_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PM_IL_WDS_CHARGES_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_WCS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_WCS_FRZ_FLAG;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_WCS_CHARGE_CODE_LABEL;

	private HtmlInputText COMP_WCS_CHARGE_CODE;

	private HtmlOutputLabel COMP_WCS_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WCS_SETUP_TYPE;

	private HtmlOutputLabel COMP_WCS_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_WCS_EFF_FM_DT;

	private HtmlOutputLabel COMP_WCS_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_WCS_EFF_TO_DT;

	private HtmlOutputLabel COMP_WCS_YRS_FM_LABEL;

	private HtmlInputText COMP_WCS_YRS_FM;

	private HtmlOutputLabel COMP_WCS_YRS_TO_LABEL;

	private HtmlInputText COMP_WCS_YRS_TO;

	private HtmlOutputLabel COMP_WCS_NO_OF_TRANS_LABEL;

	private HtmlInputText COMP_WCS_NO_OF_TRANS;

	private HtmlOutputLabel COMP_WCS_RATE_LABEL;

	private HtmlInputText COMP_WCS_RATE;

	private HtmlOutputLabel COMP_WCS_RATE_PER_LABEL;

	private HtmlInputText COMP_WCS_RATE_PER;

	private HtmlOutputLabel COMP_WCS_MIN_VALUE_LABEL;

	private HtmlInputText COMP_WCS_MIN_VALUE;

	private HtmlOutputLabel COMP_WCS_MAX_VALUE_LABEL;

	private HtmlInputText COMP_WCS_MAX_VALUE;

	private HtmlOutputLabel COMP_UI_M_CHARGE_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CHARGE_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE;

	private HtmlOutputLabel COMP_WCS_AGE_FM_LABEL;

	private HtmlInputText COMP_WCS_AGE_FM;

	private HtmlOutputLabel COMP_WCS_AGE_TO_LABEL;

	private HtmlInputText COMP_WCS_AGE_TO;

	private PM_IL_WDS_CHARGES_SETUP PM_IL_WDS_CHARGES_SETUP_BEAN;

	private UIData dataTable;

	private HtmlCommandButton onloadButton;

	// filters
	private String filterByWCS_CHARGE_CODE;
	private String filterByWCS_SETUP_TYPE;
	private String filterByWCS_YRS_FM;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlOutputLabel COMP_WCS_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_WCS_APPLIED_ON;
	
	
	
	

	public HtmlSelectOneMenu getCOMP_WCS_APPLIED_ON() {
		return COMP_WCS_APPLIED_ON;
	}

	public void setCOMP_WCS_APPLIED_ON(HtmlSelectOneMenu cOMP_WCS_APPLIED_ON) {
		COMP_WCS_APPLIED_ON = cOMP_WCS_APPLIED_ON;
	}

	private List<SelectItem> LIST_WCS_SETUP_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> WCS_APPLIED_ON_ARRAYLIST =  new ArrayList<SelectItem>();
	private List<SelectItem> WCS_FORUMULACODE_ARRAYLIST =  new ArrayList<SelectItem>();

	List<PILM060_APAC_SuggestionBean> prodCodeLOV = new ArrayList<PILM060_APAC_SuggestionBean>();
	List<PILM060_APAC_SuggestionBean> chargeCodeLOV = new ArrayList<PILM060_APAC_SuggestionBean>();
	
	

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int currPage;

	private List<PM_IL_WDS_CHARGES_SETUP> gridValueList = new ArrayList<PM_IL_WDS_CHARGES_SETUP>();;

	private ListDataModel dataModel = null;
	private int lastUpdatedRowIndex;

	private boolean update;

	private Map<String, Object> session = null;
	
	
	/*Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
	private HtmlSelectOneMenu	COMP_WCS_FORMULA_CODE;
	private HtmlOutputLabel COMP_WCS_FORMULA_CODE_LABEL;
	private List<SelectItem> WCS_FORUMULA_CODE_ARRAYLIST =  new ArrayList<SelectItem>();
	
	public List<SelectItem> getWCS_FORUMULA_CODE_ARRAYLIST() {
		return WCS_FORUMULA_CODE_ARRAYLIST;
	}

	public void setWCS_FORUMULA_CODE_ARRAYLIST(
			List<SelectItem> wCS_FORUMULA_CODE_ARRAYLIST) {
		WCS_FORUMULA_CODE_ARRAYLIST = wCS_FORUMULA_CODE_ARRAYLIST;
	}
	public HtmlSelectOneMenu getCOMP_WCS_FORMULA_CODE() {
		return COMP_WCS_FORMULA_CODE;
	}

	public void setCOMP_WCS_FORMULA_CODE(HtmlSelectOneMenu cOMP_WCS_FORMULA_CODE) {
		COMP_WCS_FORMULA_CODE = cOMP_WCS_FORMULA_CODE;
	}
	
	public HtmlOutputLabel getCOMP_WCS_FORMULA_CODE_LABEL() {
		return COMP_WCS_FORMULA_CODE_LABEL;
	}

	public void setCOMP_WCS_FORMULA_CODE_LABEL(
			HtmlOutputLabel cOMP_WCS_FORMULA_CODE_LABEL) {
		COMP_WCS_FORMULA_CODE_LABEL = cOMP_WCS_FORMULA_CODE_LABEL;
	}

	/*END Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
	CommonUtils commonUtils = new CommonUtils();
	private PM_IL_WDS_CHARGES_SETUP_DataGridDelegate gridDelegate;

	public PM_IL_WDS_CHARGES_SETUP_ACTION() {
		PM_IL_WDS_CHARGES_SETUP_BEAN = new PM_IL_WDS_CHARGES_SETUP();
		gridValueList = new ArrayList<PM_IL_WDS_CHARGES_SETUP>();
		gridDelegate = new PM_IL_WDS_CHARGES_SETUP_DataGridDelegate();
		prevRowIndex = 0;
		currPage = 1;
		Connection con = getConnection();
		LIST_WCS_SETUP_TYPE = ListItemUtil.getDropDownListValue(con,
				"PILM060_APAC", "PM_IL_WDS_CHARGES_SETUP",
				"PM_IL_WDS_CHARGES_SETUP.WCS_SETUP_TYPE", "IL_CHG_TYP");
		
		WCS_APPLIED_ON_ARRAYLIST = ListItemUtil.getDropDownListValue(con,
				"PILM060_APAC", "PM_IL_WDS_CHARGES_SETUP",
				"PM_IL_WDS_CHARGES_SETUP.WCS_APPLIED_ON", "IL_WDCHGAPON");
		
		/*Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
		WCS_FORUMULACODE_ARRAYLIST = ListItemUtil.getDropDownListValue(con,
				"PILM060_APAC", "PM_IL_WDS_CHARGES_SETUP",
				"PM_IL_WDS_CHARGES_SETUP.WCS_FORMULA_CODE", "IL_FORM_CODE");
		/*End Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
		
		
		/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
		
		initializeAllComponent();
		
		/*End*/
		
		

	}
	
	
	
	
	/*Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
	 public void validateWCS_FORMULA_CODE(FacesContext fc,
				UIComponent component, Object value)throws ValidatorException, Exception {
			try
			{
				PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE((String) value);
				
		             }
		             catch (Exception e) { 
		     throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
			
			
		}
	 /*End Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
	public HtmlOutputLabel getCOMP_WCS_FRZ_FLAG_LABEL() {
		return COMP_WCS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_WCS_FRZ_FLAG() {
		return COMP_WCS_FRZ_FLAG;
	}

	public void setCOMP_WCS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_WCS_FRZ_FLAG_LABEL) {
		this.COMP_WCS_FRZ_FLAG_LABEL = COMP_WCS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_WCS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_WCS_FRZ_FLAG) {
		this.COMP_WCS_FRZ_FLAG = COMP_WCS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_LABEL() {
		return COMP_UI_M_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE() {
		return COMP_UI_M_PROD_CODE;
	}

	public void setCOMP_UI_M_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL) {
		this.COMP_UI_M_PROD_CODE_LABEL = COMP_UI_M_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE(HtmlInputText COMP_UI_M_PROD_CODE) {
		this.COMP_UI_M_PROD_CODE = COMP_UI_M_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE_DESC() {
		return COMP_UI_M_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_PROD_CODE_DESC_LABEL = COMP_UI_M_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_PROD_CODE_DESC) {
		this.COMP_UI_M_PROD_CODE_DESC = COMP_UI_M_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_WCS_CHARGE_CODE_LABEL() {
		return COMP_WCS_CHARGE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WCS_CHARGE_CODE() {
		return COMP_WCS_CHARGE_CODE;
	}

	public void setCOMP_WCS_CHARGE_CODE_LABEL(
			HtmlOutputLabel COMP_WCS_CHARGE_CODE_LABEL) {
		this.COMP_WCS_CHARGE_CODE_LABEL = COMP_WCS_CHARGE_CODE_LABEL;
	}

	public void setCOMP_WCS_CHARGE_CODE(HtmlInputText COMP_WCS_CHARGE_CODE) {
		this.COMP_WCS_CHARGE_CODE = COMP_WCS_CHARGE_CODE;
	}

	public HtmlOutputLabel getCOMP_WCS_SETUP_TYPE_LABEL() {
		return COMP_WCS_SETUP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WCS_SETUP_TYPE() {
		return COMP_WCS_SETUP_TYPE;
	}

	public void setCOMP_WCS_SETUP_TYPE_LABEL(
			HtmlOutputLabel COMP_WCS_SETUP_TYPE_LABEL) {
		this.COMP_WCS_SETUP_TYPE_LABEL = COMP_WCS_SETUP_TYPE_LABEL;
	}

	public void setCOMP_WCS_SETUP_TYPE(HtmlSelectOneMenu COMP_WCS_SETUP_TYPE) {
		this.COMP_WCS_SETUP_TYPE = COMP_WCS_SETUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_WCS_EFF_FM_DT_LABEL() {
		return COMP_WCS_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WCS_EFF_FM_DT() {
		return COMP_WCS_EFF_FM_DT;
	}

	public void setCOMP_WCS_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_WCS_EFF_FM_DT_LABEL) {
		this.COMP_WCS_EFF_FM_DT_LABEL = COMP_WCS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_WCS_EFF_FM_DT(HtmlCalendar COMP_WCS_EFF_FM_DT) {
		this.COMP_WCS_EFF_FM_DT = COMP_WCS_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_WCS_EFF_TO_DT_LABEL() {
		return COMP_WCS_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WCS_EFF_TO_DT() {
		return COMP_WCS_EFF_TO_DT;
	}

	public void setCOMP_WCS_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_WCS_EFF_TO_DT_LABEL) {
		this.COMP_WCS_EFF_TO_DT_LABEL = COMP_WCS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_WCS_EFF_TO_DT(HtmlCalendar COMP_WCS_EFF_TO_DT) {
		this.COMP_WCS_EFF_TO_DT = COMP_WCS_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_WCS_YRS_FM_LABEL() {
		return COMP_WCS_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_WCS_YRS_FM() {
		return COMP_WCS_YRS_FM;
	}

	public void setCOMP_WCS_YRS_FM_LABEL(HtmlOutputLabel COMP_WCS_YRS_FM_LABEL) {
		this.COMP_WCS_YRS_FM_LABEL = COMP_WCS_YRS_FM_LABEL;
	}

	public void setCOMP_WCS_YRS_FM(HtmlInputText COMP_WCS_YRS_FM) {
		this.COMP_WCS_YRS_FM = COMP_WCS_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_WCS_YRS_TO_LABEL() {
		return COMP_WCS_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_WCS_YRS_TO() {
		return COMP_WCS_YRS_TO;
	}

	public void setCOMP_WCS_YRS_TO_LABEL(HtmlOutputLabel COMP_WCS_YRS_TO_LABEL) {
		this.COMP_WCS_YRS_TO_LABEL = COMP_WCS_YRS_TO_LABEL;
	}

	public void setCOMP_WCS_YRS_TO(HtmlInputText COMP_WCS_YRS_TO) {
		this.COMP_WCS_YRS_TO = COMP_WCS_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_WCS_NO_OF_TRANS_LABEL() {
		return COMP_WCS_NO_OF_TRANS_LABEL;
	}

	public HtmlInputText getCOMP_WCS_NO_OF_TRANS() {
		return COMP_WCS_NO_OF_TRANS;
	}

	public void setCOMP_WCS_NO_OF_TRANS_LABEL(
			HtmlOutputLabel COMP_WCS_NO_OF_TRANS_LABEL) {
		this.COMP_WCS_NO_OF_TRANS_LABEL = COMP_WCS_NO_OF_TRANS_LABEL;
	}

	public void setCOMP_WCS_NO_OF_TRANS(HtmlInputText COMP_WCS_NO_OF_TRANS) {
		this.COMP_WCS_NO_OF_TRANS = COMP_WCS_NO_OF_TRANS;
	}

	public HtmlOutputLabel getCOMP_WCS_RATE_LABEL() {
		return COMP_WCS_RATE_LABEL;
	}

	public HtmlInputText getCOMP_WCS_RATE() {
		return COMP_WCS_RATE;
	}

	public void setCOMP_WCS_RATE_LABEL(HtmlOutputLabel COMP_WCS_RATE_LABEL) {
		this.COMP_WCS_RATE_LABEL = COMP_WCS_RATE_LABEL;
	}

	public void setCOMP_WCS_RATE(HtmlInputText COMP_WCS_RATE) {
		this.COMP_WCS_RATE = COMP_WCS_RATE;
	}

	public HtmlOutputLabel getCOMP_WCS_RATE_PER_LABEL() {
		return COMP_WCS_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_WCS_RATE_PER() {
		return COMP_WCS_RATE_PER;
	}

	public void setCOMP_WCS_RATE_PER_LABEL(
			HtmlOutputLabel COMP_WCS_RATE_PER_LABEL) {
		this.COMP_WCS_RATE_PER_LABEL = COMP_WCS_RATE_PER_LABEL;
	}

	public void setCOMP_WCS_RATE_PER(HtmlInputText COMP_WCS_RATE_PER) {
		this.COMP_WCS_RATE_PER = COMP_WCS_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_WCS_MIN_VALUE_LABEL() {
		return COMP_WCS_MIN_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WCS_MIN_VALUE() {
		return COMP_WCS_MIN_VALUE;
	}

	public void setCOMP_WCS_MIN_VALUE_LABEL(
			HtmlOutputLabel COMP_WCS_MIN_VALUE_LABEL) {
		this.COMP_WCS_MIN_VALUE_LABEL = COMP_WCS_MIN_VALUE_LABEL;
	}

	public void setCOMP_WCS_MIN_VALUE(HtmlInputText COMP_WCS_MIN_VALUE) {
		this.COMP_WCS_MIN_VALUE = COMP_WCS_MIN_VALUE;
	}

	public HtmlOutputLabel getCOMP_WCS_MAX_VALUE_LABEL() {
		return COMP_WCS_MAX_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WCS_MAX_VALUE() {
		return COMP_WCS_MAX_VALUE;
	}

	public void setCOMP_WCS_MAX_VALUE_LABEL(
			HtmlOutputLabel COMP_WCS_MAX_VALUE_LABEL) {
		this.COMP_WCS_MAX_VALUE_LABEL = COMP_WCS_MAX_VALUE_LABEL;
	}

	public void setCOMP_WCS_MAX_VALUE(HtmlInputText COMP_WCS_MAX_VALUE) {
		this.COMP_WCS_MAX_VALUE = COMP_WCS_MAX_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHARGE_CODE_DESC_LABEL() {
		return COMP_UI_M_CHARGE_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CHARGE_CODE_DESC() {
		return COMP_UI_M_CHARGE_CODE_DESC;
	}

	public void setCOMP_UI_M_CHARGE_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CHARGE_CODE_DESC_LABEL) {
		this.COMP_UI_M_CHARGE_CODE_DESC_LABEL = COMP_UI_M_CHARGE_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CHARGE_CODE_DESC(
			HtmlInputText COMP_UI_M_CHARGE_CODE_DESC) {
		this.COMP_UI_M_CHARGE_CODE_DESC = COMP_UI_M_CHARGE_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CHARGE_CODE() {
		return COMP_UI_M_BUT_LOV_CHARGE_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_CHARGE_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CHARGE_CODE) {
		this.COMP_UI_M_BUT_LOV_CHARGE_CODE = COMP_UI_M_BUT_LOV_CHARGE_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROD_CODE() {
		return COMP_UI_M_BUT_LOV_PROD_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PROD_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE) {
		this.COMP_UI_M_BUT_LOV_PROD_CODE = COMP_UI_M_BUT_LOV_PROD_CODE;
	}

	public PM_IL_WDS_CHARGES_SETUP getPM_IL_WDS_CHARGES_SETUP_BEAN() {
		return PM_IL_WDS_CHARGES_SETUP_BEAN;
	}

	public void setPM_IL_WDS_CHARGES_SETUP_BEAN(
			PM_IL_WDS_CHARGES_SETUP PM_IL_WDS_CHARGES_SETUP_BEAN) {
		this.PM_IL_WDS_CHARGES_SETUP_BEAN = PM_IL_WDS_CHARGES_SETUP_BEAN;
	}

	public void preForm() {
		System.out
				.println("PM_IL_WDS_CHARGES_SETUP_ACTION.preForm()--------------------------");

		ArrayList<OracleParameter> list = null;
		Map<String, Object> session = getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();

		Connection con = getConnection();
		LIST_WCS_SETUP_TYPE = ListItemUtil.getDropDownListValue(con,
				"PILM060_APAC", "PM_IL_WDS_CHARGES_SETUP",
				"PM_IL_WDS_CHARGES_SETUP.WCS_SETUP_TYPE", "IL_CHG_TYP");

		getOnloadButton().setDisabled(true);
	}

	public void STD_PRE_FORM() {

		ControlBean ctrlBean = CommonUtils.getControlBean();
		Map<String, Object> session = getSessionMap();
		ctrlBean.setM_PARA_1((String) session.get("GLOBAL.M_PARA_1"));

		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("STD_PRE_FORM()--- \n " + ctrlBean.getM_LANG_CODE()
				+ "\t" + ctrlBean.getM_COMP_CODE() + "\t"
				+ ctrlBean.getM_PARA_1());
	}

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public HtmlCommandButton getOnloadButton() {
		return onloadButton;
	}

	public void setOnloadButton(HtmlCommandButton onloadButton) {
		this.onloadButton = onloadButton;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void callRowChangeListener(ActionEvent ae) {
		CommonUtils.clearMaps(this);

		if (getCurrentValue(ae) != null) {
			String prodCode = getCurrentValue(ae);
			PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_PROD_CODE(prodCode);
			//validateChargeCode(chargeCode);
		} else {
			throw new ValidatorException(new FacesMessage(
					"Charge Code Cannot be Empty. Enter a value"));
		}
	}
	
	/*public void validateChargeCode(String prodCode) {
		try{
			if(prodCode!= null || !"".equals(prodCode)){
			
			this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_CHARGE_CODE(chargeCode);
			
			Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion
			if (chargeCode.equals("G01") || chargeCode.equals("G02")) {
				COMP_WCS_FORMULA_CODE.setDisabled(false);
				COMP_WCS_FORMULA_CODE.resetValue();
				COMP_WCS_FORMULA_CODE_LABEL.setRendered(true);
				
			}else{

				COMP_WCS_FORMULA_CODE.setDisabled(true);
				COMP_WCS_FORMULA_CODE.resetValue();
				COMP_WCS_FORMULA_CODE_LABEL.setRendered(false);
			}
			End Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void lastColumnListener() {
		int currentRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_WDS_CHARGES_SETUP valueBean = null;
		CRUDHandler handler = new CRUDHandler();
		String message = null;
		try {
			if (currentRowIndex != -1) {
				valueBean = gridValueList.get(currentRowIndex);
				if (valueBean.getWCS_PROD_CODE() == null
						&& "null".equals(valueBean.getWCS_PROD_CODE())) {
					valueBean.setWCS_PROD_CODE(PM_IL_WDS_CHARGES_SETUP_BEAN
							.getUI_M_PROD_CODE());
				}
				if (valueBean.getROWID() != null) {
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
					preUpDate();
				} else {
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert");
					preInsert();
				}

				rowUpdated = handler.executeInsert(valueBean, getConnection());
				lastUpdatedRowIndex = currentRowIndex;
				if (rowUpdated == 1) {
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
				}
			}
		} catch (ValidatorException e1) {
			getErrorMap().put("somekey", e1.getMessage());
			getErrorMap().put("current", e1.getMessage());
			throw new ValidatorException(new FacesMessage(e1.getMessage()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	public void callWCS_SETUP_TYPE(ActionEvent event) {
		String setUp = getCurrentValue(event);
		
		/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
		
		if(setUp.equalsIgnoreCase("S"))
		{
			this.getCOMP_WCS_YRS_FM_LABEL().setValue("Term from");
			this.getCOMP_WCS_YRS_TO_LABEL().setValue("Term To");
			
		}
		else if(setUp.equalsIgnoreCase("W"))
		{
			System.out.println("getWCS_SETUP_TYPE is W");
			
			this.getCOMP_WCS_YRS_FM_LABEL().setValue("Premium Paying years from");
			this.getCOMP_WCS_YRS_TO_LABEL().setValue("Premium Paying years to");
		}
		
		/*End*/
		
		
			if(!setUp.equals(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_SETUP_TYPE()))
		{
		this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_SETUP_TYPE(setUp);

		if ("H".equals(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_SETUP_TYPE())) {
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE_PER(1.0);
			COMP_WCS_MAX_VALUE.setDisabled(true);
			COMP_WCS_MIN_VALUE.setDisabled(true);
			this.getCOMP_WCS_RATE_PER().setDisabled(true);
			
		} else {
			COMP_WCS_MAX_VALUE.setDisabled(false);
			COMP_WCS_MIN_VALUE.setDisabled(false);
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE_PER(100.0);
			this.getCOMP_WCS_RATE_PER().setDisabled(false);
		}
		}
		COMP_WCS_RATE_PER.resetValue();
		
	}

	public String deleteRow() {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_WDS_CHARGES_SETUP bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (gridValueList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < gridValueList.size();) {
					bean = (PM_IL_WDS_CHARGES_SETUP) gridValueList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						gridValueList.remove(bean);
						deletedRecordIndex = gridDelegate.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (gridValueList.size() > 0) {
					setPM_IL_WDS_CHARGES_SETUP_BEAN((PM_IL_WDS_CHARGES_SETUP) gridValueList
							.get(0));
					PM_IL_WDS_CHARGES_SETUP_BEAN.setRowSelected(true);
				} else {
					addNewRow(null);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_WDS_CHARGES_SETUP_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
		return "";
	}

	public String combinedSave() {
		try {
			new CommonUtils().doComitt();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ListDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(ListDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void addNewRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				String prodCode = this.getPM_IL_WDS_CHARGES_SETUP_BEAN()
						.getUI_M_PROD_CODE();
				PM_IL_WDS_CHARGES_SETUP_BEAN = new PM_IL_WDS_CHARGES_SETUP();
				// PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_PROD_CODE(COMP_UI_M_PROD_CODE.getSubmittedValue().toString());
				resetAllComponent();
				resetSelectedRow();
				PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_PROD_CODE(prodCode);
				PM_IL_WDS_CHARGES_SETUP_BEAN.setRowSelected(true);
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	public List<SelectItem> getLIST_WCS_SETUP_TYPE() {
		return LIST_WCS_SETUP_TYPE;
	}

	public void setLIST_WCS_SETUP_TYPE(List<SelectItem> list_wcs_setup_type) {
		LIST_WCS_SETUP_TYPE = list_wcs_setup_type;
	}

	
	/*public ArrayList<LovBean> lovM_PROD_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList  = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM060_APAC",
					"DUMMY", "M_PROD_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
		 
	}*/
	
	
	
	/*Modified by Janani on 14.07.2017 for ZBILQC-1724475 */
	
	/*public ArrayList<LovBean> lovM_PROD_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT PROD_CODE ,PROD_DESC ,PLAN_TYPE FROM PM_IL_PRODUCT,PM_IL_PLAN WHERE " +
				"PLAN_TYPE = 'U' AND PROD_PLAN_CODE=PLAN_CODE AND (PROD_CODE LIKE ? OR PROD_DESC LIKE ?) AND ROWNUM < ?";
			
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
	}*/
	

	
	public HtmlOutputLabel getCOMP_WCS_APPLIED_ON_LABEL() {
		return COMP_WCS_APPLIED_ON_LABEL;
	}

	public void setCOMP_WCS_APPLIED_ON_LABEL(
			HtmlOutputLabel cOMP_WCS_APPLIED_ON_LABEL) {
		COMP_WCS_APPLIED_ON_LABEL = cOMP_WCS_APPLIED_ON_LABEL;
	}

	public List<SelectItem> getWCS_APPLIED_ON_ARRAYLIST() {
		return WCS_APPLIED_ON_ARRAYLIST;
	}

	public void setWCS_APPLIED_ON_ARRAYLIST(
			List<SelectItem> wCS_APPLIED_ON_ARRAYLIST) {
		WCS_APPLIED_ON_ARRAYLIST = wCS_APPLIED_ON_ARRAYLIST;
	}

	public ArrayList<LovBean> lovM_PROD_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILM060_APAC";
		String blockName = "DUMMY";
		String fieldName = "M_PROD_CODE";
		//Object param1 = "IL_MED_EXM";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					null, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	/*End*/
	
	
	public List<PILM060_APAC_SuggestionBean> popLov4ProdCode(Object event) {

		System.out
				.println("PM_IL_WDS_CHARGES_SETUP_ACTION.popLov4ProdCode()-Inside");
		String suggestQuery = null;
		String textEntered = event.toString().trim();
		ResultSet rsSug = null;
		prodCodeLOV.clear();
		System.out
				.println("PM_IL_WDS_CHARGES_SETUP_ACTION.popLov4ProdCode()----["
						+ textEntered + "]");
		if (event.toString().trim().equals("*")) {

			suggestQuery = "SELECT  PROD_CODE,PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT,PM_IL_PLAN WHERE PROD_PLAN_CODE = PLAN_CODE AND PLAN_TYPE = 'U'";
			System.out.println("suggestQuery11" + suggestQuery);
		}

		else {
			suggestQuery = "SELECT  PROD_CODE,PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT,PM_IL_PLAN WHERE PROD_PLAN_CODE = PLAN_CODE AND PLAN_TYPE = 'U' and PROD_CODE like '"
					+ textEntered + "%'";

			System.out.println("suggestQuery22" + suggestQuery);
		}

		try {

			rsSug = getHandler().executeSelectStatement(suggestQuery,
					getConnection());

			while (rsSug.next()) {

				PILM060_APAC_SuggestionBean sug1bean = new PILM060_APAC_SuggestionBean();
				sug1bean.setLOV_UI_M_PROD_CODE(rsSug.getString(1));
				sug1bean.setLOV_UI_M_PROD_CODE_DESC(rsSug.getString(2));
				prodCodeLOV.add(sug1bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				rsSug.close();
			} catch (Exception ev) {
				ev.printStackTrace();
			}
		}
		return prodCodeLOV;
	}

	public String popProdCodeDesc() throws SQLException {
		ResultSet rs = null;
		String prodDesc = null;
		String codeValue = getCOMP_UI_M_PROD_CODE().getSubmittedValue()
				.toString();
		if (!codeValue.equals("") || codeValue != null) {
			System.out
					.println("PM_AGENT_PF_SETUP_ACTION.popMktCodeDesc()----------------------------["
							+ getCOMP_UI_M_PROD_CODE().getSubmittedValue()
							+ "]");
			String desc = "SELECT  PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE ='"
					+ codeValue + "'";

			rs = getHandler().executeSelectStatement(desc, getConnection());
			if (rs.next()) {
				prodDesc = rs.getString(1);
				getCOMP_UI_M_PROD_CODE_DESC().setSubmittedValue(prodDesc);
			} else {

			}

			rs.close();

		}
		return prodDesc;
	}

	public List<PILM060_APAC_SuggestionBean> popLov4ChargeCode(Object event) {
		String suggestQuery = null;
		String textEntered = event.toString();
		ResultSet rsSug = null;
		chargeCodeLOV.clear();
		if (event.toString().equals("*")) {
			suggestQuery = "SELECT  PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE= 'IL_CHARGE' AND NVL(PC_FRZ_FLAG,'N') = 'N'";
		} else {
			suggestQuery = "SELECT  PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE= 'IL_CHARGE' AND NVL(PC_FRZ_FLAG,'N') = 'N' and PC_CODE like '"
					+ textEntered + "%'";

		}

		try {

			rsSug = getHandler().executeSelectStatement(suggestQuery,
					getConnection());

			while (rsSug.next()) {

				PILM060_APAC_SuggestionBean sug1bean = new PILM060_APAC_SuggestionBean();
				sug1bean.setLOV_WCS_CHARGE_CODE(rsSug.getString(1));
				sug1bean.setLOV_UI_M_CHARGE_CODE_DESC(rsSug.getString(2));
				chargeCodeLOV.add(sug1bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				rsSug.close();
			} catch (Exception ev) {
				ev.printStackTrace();
			}
		}
		return chargeCodeLOV;
	}

	public String popChargeCodeDesc() throws SQLException {
		String codeValue = getCOMP_WCS_CHARGE_CODE().getSubmittedValue()
				.toString();
		getChargeDescription(codeValue);
		return null;

	}

	public void postQuery(PM_IL_WDS_CHARGES_SETUP withdrwalBean)
			throws Exception {

		ResultSet rs = null;

		try {
			if (withdrwalBean.getWCS_CHARGE_CODE() != null) {
				String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE= 'IL_CHARGE' AND PC_CODE =   ?  AND NVL(PC_FRZ_FLAG,'N') = 'N'";
				rs = new CRUDHandler().executeSelectStatement(desc, CommonUtils
						.getConnection(), new Object[] { withdrwalBean
						.getWCS_CHARGE_CODE() });
				if (rs.next()) {
					withdrwalBean.setUI_M_CHARGE_CODE_DESC(rs.getString(1));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	public String getChargeDescription(String code) throws SQLException {
		ResultSet rs = null;
		String chargeDesc = null;
		String codeValue = code;
		/* int rowIndex = getDataTable().getRowIndex(); */
		PM_IL_WDS_CHARGES_SETUP valueBean = this.PM_IL_WDS_CHARGES_SETUP_BEAN;
		if (!codeValue.equals("") || codeValue != null) {
			String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE= 'IL_CHARGE' AND PC_CODE ='"
					+ codeValue + "'AND NVL(PC_FRZ_FLAG,'N') = 'N'";
			System.out
					.println("PM_IL_WDS_CHARGES_SETUP_ACTION.getChargeDescription()12312312312--["
							+ desc + "]");

			rs = getHandler().executeSelectStatement(desc, getConnection());
			if (rs.next()) {
				chargeDesc = rs.getString(1);
				System.out
						.println("PM_IL_WDS_CHARGES_SETUP_ACTION.getChargeDescription()-----chrgdesc======["
								+ chargeDesc + "]");
				valueBean.setWCS_CHARGE_CODE(code);
				valueBean.setUI_M_CHARGE_CODE_DESC(chargeDesc);
				getCOMP_UI_M_CHARGE_CODE_DESC().resetValue();
				// getCOMP_UI_M_CHARGE_CODE_DESC().setSubmittedValue(chargeDesc);
			} else {

				// WHEN-VALIDATE-ITEM
				/*
				 * STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE); RAISE
				 * FORM_TRIGGER_FAILURE;
				 */
			}

			rs.close();
		}
		return chargeDesc;
	}

	public void preInsert() throws Exception {

		// int rowIndex = getDataTable().getRowIndex();
		try {

			PM_IL_WDS_CHARGES_SETUP valueBean = this.PM_IL_WDS_CHARGES_SETUP_BEAN;
			getPM_IL_WDS_CHARGES_SETUP_BEAN().setWCS_PROD_CODE(
					getPM_IL_WDS_CHARGES_SETUP_BEAN().getUI_M_PROD_CODE());
			valueBean
					.setWCS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			valueBean.setWCS_CR_DT(new Date());
			valueBean.setWCS_PROD_CODE(getPM_IL_WDS_CHARGES_SETUP_BEAN()
					.getUI_M_PROD_CODE());
			// valueBean.setWCS_PROD_CODE(COMP_UI_M_PROD_CODE.getSubmittedValue().toString());
			L_OVERLAP_CHECK(valueBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpDate() throws Exception {
		/* int rowIndex = getDataTable().getRowIndex(); */
		try {
			PM_IL_WDS_CHARGES_SETUP valueBean = this.PM_IL_WDS_CHARGES_SETUP_BEAN;
			// [ Removed Hard coded user id: added by: Shankar bodduluri Dated:
			// 19-Mar-2009 ]
			valueBean.setWCS_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			valueBean.setWCS_UPD_DT(new Date());
			valueBean.setWCS_PROD_CODE(getPM_IL_WDS_CHARGES_SETUP_BEAN()
					.getUI_M_PROD_CODE());
			getPM_IL_WDS_CHARGES_SETUP_BEAN().setWCS_PROD_CODE(
					getPM_IL_WDS_CHARGES_SETUP_BEAN().getUI_M_PROD_CODE());

			L_OVERLAP_CHECK(valueBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preQuery() {
		getPM_IL_WDS_CHARGES_SETUP_BEAN().setWCS_PROD_CODE(
				getPM_IL_WDS_CHARGES_SETUP_BEAN().getUI_M_PROD_CODE());
	}

	// ******************************************Validation************************

	public void validateRate(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validatorRate(FacesContext fc, UIComponent component,
			Object value) {
		try {
			Double rate = (Double) value;
			
			if ("W".equals(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_SETUP_TYPE())) {
			
				/*commented by dhinesh on 28-3-2018*/
				/*if((rate > 1.0) && (rate <=100.0))*/
					/*End*/
				if((rate >= 1.0) && (rate <=100.0))
			{
				PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE(rate);
			
		    } else {
		    	throw new Exception("Rate must be between 1 and 100 ");
		    }

		}else{
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE(rate);
		}

			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateRatePer(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validatorRatePer(FacesContext fc, UIComponent component,
			Object value) {
		try {
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE_PER((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateMaxValue(ActionEvent ae) {
		CommonUtils.clearMaps(this);

		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		// comp
		System.out.println("dfhg"
				+ input.getClientId(FacesContext.getCurrentInstance()));
		System.out.println("validate password");
		System.out.println(getErrorMap());
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateMax(FacesContext fc, UIComponent component, Object value) {
		try {
			/*
			 * 
			 * COMMENTED BY DHINESH ON 06-04-2018 
			 * 
			 * String dMaxValue = (String) ((UIInput) component)
					.getSubmittedValue();
			String dMinValue = (String) getCOMP_WCS_MIN_VALUE()
					.getSubmittedValue();*/
			
			Double dMaxValue = (Double) value ;
			Double dMinValue = PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MIN_VALUE() ;
			
			if (dMaxValue != null && !dMaxValue.equals("")) {
				Double MaxVal = dMaxValue;
				this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_MAX_VALUE(MaxVal);
				if (MaxVal < 0) {
					throw new Exception("Must be greater than 0");
				}
				if (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MIN_VALUE() != null) {
					if (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MAX_VALUE() < PM_IL_WDS_CHARGES_SETUP_BEAN
							.getWCS_MIN_VALUE()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "81086"));

					}
				}
			}

			/*if ("S".equals(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_SETUP_TYPE())) {
				this.getCOMP_WCS_AGE_FM().setDisabled(false);
				this.getCOMP_WCS_AGE_TO().setDisabled(false);
				this.getCOMP_WCS_AGE_FM().setRequired(true);
				this.getCOMP_WCS_AGE_TO().setRequired(true);
			} else {
				this.getCOMP_WCS_AGE_FM().setDisabled(true);
				this.getCOMP_WCS_AGE_TO().setDisabled(true);
				this.getCOMP_WCS_AGE_FM().setRequired(false);
				this.getCOMP_WCS_AGE_TO().setRequired(false);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateMinValue(ActionEvent ae) {
		CommonUtils.clearMaps(this);

		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		// comp

		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateMin(FacesContext fc, UIComponent component, Object value) {
		try {
			/*
			 * COMMNETED BY DHIENSH ON 06-04-2018 
			 * 
			 * String dMinValue = (String) ((UIInput) component)
					.getSubmittedValue();
			String dMaxValue = (String) getCOMP_WCS_MAX_VALUE()
					.getSubmittedValue();*/
			
			Double dMinValue = (Double) value ;
			Double dMaxValue = PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MAX_VALUE();
			Double rate = (Double) value;
			
			
			if (dMinValue != null && !dMinValue.equals("")) {
				Double MinVal = dMinValue;
				this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_MIN_VALUE(MinVal);
				if (MinVal < 0) {
					throw new Exception("Must be greater than 0");
				}
				if (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MAX_VALUE() != null) {
					if (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_MAX_VALUE() < PM_IL_WDS_CHARGES_SETUP_BEAN
							.getWCS_MIN_VALUE()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91238"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateYearsFrom(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateYearFrom(FacesContext fc, UIComponent component,
			Object value) {
		try {
			String fromYear = (String) ((UIInput) component)
					.getSubmittedValue();
			String toYear = (String) getCOMP_WCS_YRS_TO().getSubmittedValue();
			if (fromYear != null && !fromYear.equals("")) {
				Integer dfromYear = Integer.parseInt(fromYear);
				this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_YRS_FM(dfromYear);
				if (dfromYear < 0 || dfromYear > 1000) {
					throw new Exception("Must be in range 0 to 999");
				}
			}

			if (toYear != null && !toYear.equals("")) {
				System.out
						.println("PM_IL_WDS_CHARGES_SETUP_ACTION.validateNumber()--["
								+ fromYear + "]---[" + toYear + "]");

				if (fromYear != null && !fromYear.equals("")) {
					Integer dfromYear = Integer.parseInt(fromYear);
					Integer dtoYear = Integer.parseInt(toYear);

					if (dfromYear > dtoYear) {
						System.out
								.println("PM_IL_WDS_CHARGES_SETUP_ACTION.validateNumber()---VALIDATE");
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91054"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateYearsTo(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		// comp

		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateYearTo(FacesContext fc, UIComponent component,
			Object value) {
		try {
			String toYear = (String) ((UIInput) component).getSubmittedValue();

			String fromYear = (String) getCOMP_WCS_YRS_FM().getSubmittedValue();
			if (toYear != null && !toYear.equals("")) {
				Integer dtoYear = Integer.parseInt(toYear);
				this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_YRS_TO(dtoYear);
				if (dtoYear < 0 || dtoYear > 1000) {
					throw new Exception("Must be in range 0 to 999");

				}
			}

			if (fromYear != null && !fromYear.equals("")) {
				if (toYear != null && !toYear.equals("")) {
					Double dfromYear = Double.parseDouble(fromYear);
					Double dtoYear = Double.parseDouble(toYear);
					if (dfromYear > dtoYear) {
						System.out
								.println("PM_IL_WDS_CHARGES_SETUP_ACTION.validateNumber()---VALIDATE");
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "80015"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateFromDateAction(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		// comp

		ErrorHelpUtil.validate(input, getErrorMap());
		System.out
				.println("PM_IL_WDS_CHARGES_SETUP_ACTION.validateFromDateAction()=====0");

	}

	public void validateFromDate(FacesContext fc, UIComponent component,
			Object value) {
		try {
			UICalendar cala = (UICalendar) component;
			Date fromDate = (Date) cala.getAsDate(cala.getSubmittedValue());
			this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_EFF_FM_DT(fromDate);
			if ((getCOMP_WCS_EFF_TO_DT().getSubmittedValue() != null)
					&& (!(getCOMP_WCS_EFF_TO_DT().getSubmittedValue()
							.equals("")))) {
				Date toDate = ((UICalendar) getCOMP_WCS_EFF_TO_DT())
						.getAsDate(getCOMP_WCS_EFF_TO_DT().getSubmittedValue());
				if (toDate.before(fromDate)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateToDateAction(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		// comp

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateToDate(FacesContext fc, UIComponent component,
			Object value) {
		try {
			UICalendar cala = (UICalendar) component;
			Date toDate = (Date) cala.getAsDate(cala.getSubmittedValue());
			this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_EFF_TO_DT(toDate);
			if ((getCOMP_WCS_EFF_FM_DT().getSubmittedValue() != null)
					&& (!(""
							.equals(getCOMP_WCS_EFF_FM_DT().getSubmittedValue())))) {
				Date fromDate = ((UICalendar) getCOMP_WCS_EFF_FM_DT())
						.getAsDate(getCOMP_WCS_EFF_FM_DT().getSubmittedValue());
				if (toDate.before(fromDate)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateNoOfChargeLess(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent(); // input
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorNoOfChargeLess(FacesContext fc, UIComponent component,
			Object value) {
		try {
			Integer charge = (Integer) value;
			this.PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_NO_OF_TRANS(charge);
			if (charge < 0 || charge > 9999) {
				throw new Exception("Must be in range 0 to 9999");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	// ****************************************************************************************

	public Connection getConnection() {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	// [ Added for grid implementation change, Added by: S.Mallika, Dated:
	// 20-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
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
	// 20-Feb-2009 ]

	public void checkBoxStatus(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean isChecked = Boolean.parseBoolean(getCurrentValue(event));
		int rowIndex = getDataTable().getRowIndex();
		gridValueList.get(rowIndex).setSelected(isChecked);
		System.out.println("CK_BOX:::" + isChecked);
	}

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
	}

	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public void L_OVERLAP_CHECK(PM_IL_WDS_CHARGES_SETUP valueBean)
	throws Exception {
String sql_C3 = "SELECT ROWID FROM PM_IL_WDS_CHARGES_SETUP WHERE WCS_PROD_CODE = ? "
		+ " AND (? BETWEEN WCS_YRS_FM AND WCS_YRS_TO OR ? BETWEEN "
		+ " WCS_YRS_FM AND WCS_YRS_TO OR WCS_YRS_FM BETWEEN ? AND ? "
		+ " OR WCS_YRS_TO BETWEEN ? AND ?) AND    (? BETWEEN WCS_EFF_FM_DT "
		+ " AND WCS_EFF_TO_DT OR "
		+ " ? BETWEEN WCS_EFF_FM_DT AND WCS_EFF_TO_DT OR WCS_EFF_FM_DT BETWEEN ? "
		+ " AND ? OR WCS_EFF_TO_DT BETWEEN ? AND ?) "
		+ " AND (? BETWEEN WCS_AGE_FM AND WCS_AGE_TO OR "
       + " ? BETWEEN WCS_AGE_FM AND WCS_AGE_TO OR WCS_AGE_FM BETWEEN ? AND ? OR "
       + " WCS_AGE_TO BETWEEN ?  AND ?)"
        + " AND    (? = WCS_SETUP_TYPE) AND    (? = WCS_CHARGE_CODE)";

String sql_C2 = "SELECT ROWID FROM PM_IL_WDS_CHARGES_SETUP WHERE WCS_PROD_CODE = ? "
	+ " AND (? BETWEEN WCS_YRS_FM AND WCS_YRS_TO OR ? BETWEEN "
	+ " WCS_YRS_FM AND WCS_YRS_TO OR WCS_YRS_FM BETWEEN ? AND ? "
	+ " OR WCS_YRS_TO BETWEEN ? AND ?) AND    (? BETWEEN WCS_EFF_FM_DT "
	+ " AND WCS_EFF_TO_DT OR "
	+ " ? BETWEEN WCS_EFF_FM_DT AND WCS_EFF_TO_DT OR WCS_EFF_FM_DT BETWEEN ? "
	+ " AND ? OR WCS_EFF_TO_DT BETWEEN ? AND ?) "
	//+ " AND (? BETWEEN WCS_AGE_FM AND WCS_AGE_TO OR "
 //   + " ? BETWEEN WCS_AGE_FM AND WCS_AGE_TO OR WCS_AGE_FM BETWEEN ? AND ? OR "
 //   + " WCS_AGE_TO BETWEEN ?  AND ?)"
    + " AND    (? = WCS_SETUP_TYPE) AND    (? = WCS_CHARGE_CODE)";
String M_DUMMY = null;
Connection connection = null;
String sql_C1=null;
ResultSet rst_C1 = null;
ResultSet rst_C2 = null;
CRUDHandler handler = new CRUDHandler();
Object[] objects2 = { valueBean.getWCS_PROD_CODE(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		valueBean.getWCS_SETUP_TYPE(), valueBean.getWCS_CHARGE_CODE() };
Object[] objects1 = { valueBean.getWCS_PROD_CODE(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_YRS_FM(), valueBean.getWCS_YRS_TO(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		valueBean.getWCS_EFF_FM_DT(), valueBean.getWCS_EFF_TO_DT(),
		//valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		//valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		//valueBean.getWCS_AGE_FM(),valueBean.getWCS_AGE_TO(),
		valueBean.getWCS_SETUP_TYPE(), valueBean.getWCS_CHARGE_CODE() };

Object[] objects ={};

try {

	connection = CommonUtils.getConnection();

	if("H".equalsIgnoreCase(valueBean.getWCS_SETUP_TYPE())){
		sql_C1=sql_C2;
		objects=objects1;
	}else{
		sql_C1=sql_C3;
		objects=objects2;
	}
	
	rst_C2 = handler
			.executeSelectStatement(sql_C1, connection, objects);
	if (rst_C2.next()) {
		M_DUMMY = rst_C2.getString(1);
	}
	System.out.println("M_DUMMY---------------------" + M_DUMMY);
	if (M_DUMMY != null) {
		if (CommonUtils.isDuplicate(valueBean.getROWID(), M_DUMMY)) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "80031"));
		}
	}
} catch (Exception e) {
	e.printStackTrace();
	throw new Exception(e.getMessage());
} finally {
	try {
		CommonUtils.closeCursor(rst_C1);
	} catch (Exception e) {
	}
}
}


	public void post(ActionEvent ae) {

		try {
			if (PM_IL_WDS_CHARGES_SETUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpDate();
					new CRUDHandler().executeInsert(
							PM_IL_WDS_CHARGES_SETUP_BEAN, commonUtils
									.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(
							PM_IL_WDS_CHARGES_SETUP_BEAN, commonUtils
									.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					gridValueList.add(PM_IL_WDS_CHARGES_SETUP_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_WDS_CHARGES_SETUP_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void getDetails() {
		try {
			if (gridValueList.size() != 0) {
				resetSelectedRow();
				PM_IL_WDS_CHARGES_SETUP_BEAN = (PM_IL_WDS_CHARGES_SETUP) dataTable
						.getRowData();
				this.postQuery(PM_IL_WDS_CHARGES_SETUP_BEAN);
				if("H".equalsIgnoreCase(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_SETUP_TYPE())){
					//PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_RATE_PER(1.0);
					this.getCOMP_WCS_RATE_PER().setDisabled(true);
				}else{
					this.getCOMP_WCS_RATE_PER().setDisabled(false);
				}
				PM_IL_WDS_CHARGES_SETUP_BEAN.setRowSelected(true);
				resetAllComponent();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_WCS_CHARGE_CODE.resetValue();
		COMP_UI_M_CHARGE_CODE_DESC.resetValue();
		COMP_WCS_SETUP_TYPE.resetValue();
		COMP_WCS_EFF_FM_DT.resetValue();
		COMP_WCS_EFF_TO_DT.resetValue();
		COMP_WCS_YRS_FM.resetValue();
		COMP_WCS_YRS_TO.resetValue();
		COMP_WCS_NO_OF_TRANS.resetValue();
		COMP_WCS_RATE.resetValue();
		COMP_WCS_RATE_PER.resetValue();
		COMP_WCS_MIN_VALUE.resetValue();
		COMP_WCS_MAX_VALUE.resetValue();
		COMP_WCS_FRZ_FLAG.resetValue();
		COMP_WCS_APPLIED_ON.resetValue();
		//COMP_WCS_AGE_FM.resetValue();
		//COMP_WCS_AGE_TO.resetValue();
		
		/*Newly added by pidugu raj dt: 12-10-2018 for kic as suggested by srinivas reddy and sivaraman*/
		COMP_WCS_FORMULA_CODE.resetValue();
		COMP_UI_M_FORMULA_CODE_DESC.resetValue();
		COMP_PCC_FLEX_01.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_WDS_CHARGES_SETUP> iterator = gridValueList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByWCS_CHARGE_CODE() {
		return filterByWCS_CHARGE_CODE;
	}

	public void setFilterByWCS_CHARGE_CODE(String filterByWCS_CHARGE_CODE) {
		this.filterByWCS_CHARGE_CODE = filterByWCS_CHARGE_CODE;
	}

	public String getFilterByWCS_SETUP_TYPE() {
		return filterByWCS_SETUP_TYPE;
	}

	public void setFilterByWCS_SETUP_TYPE(String filterByWCS_SETUP_TYPE) {
		this.filterByWCS_SETUP_TYPE = filterByWCS_SETUP_TYPE;
	}

	public String getFilterByWCS_YRS_FM() {
		return filterByWCS_YRS_FM;
	}

	public void setFilterByWCS_YRS_FM(String filterByWCS_YRS_FM) {
		this.filterByWCS_YRS_FM = filterByWCS_YRS_FM;
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

	public void validateCGH_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_IL_WDS_CHARGES_SETUP_BEAN
						.setWCS_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_IL_WDS_CHARGES_SETUP_BEAN
						.setWCS_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/*Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion
	public void doValidateFormulaCode(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			String productCode = (String)value;
			if (productCode.equals("G01") || productCode.equals("G02")) {
				COMP_WCS_FORMULA_CODE.setDisabled(false);
				COMP_WCS_FORMULA_CODE.resetValue();
				COMP_WCS_FORMULA_CODE_LABEL.setRendered(true);
				
			}else{

				COMP_WCS_FORMULA_CODE.setDisabled(true);
				COMP_WCS_FORMULA_CODE.resetValue();
				COMP_WCS_FORMULA_CODE_LABEL.setRendered(false);
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	End Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion*/
	

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_WCS_AGE_FM_LABEL() {
		return COMP_WCS_AGE_FM_LABEL;
	}

	public void setCOMP_WCS_AGE_FM_LABEL(HtmlOutputLabel comp_wcs_age_fm_label) {
		COMP_WCS_AGE_FM_LABEL = comp_wcs_age_fm_label;
	}

	public HtmlInputText getCOMP_WCS_AGE_FM() {
		return COMP_WCS_AGE_FM;
	}

	public void setCOMP_WCS_AGE_FM(HtmlInputText comp_wcs_age_fm) {
		COMP_WCS_AGE_FM = comp_wcs_age_fm;
	}

	public HtmlOutputLabel getCOMP_WCS_AGE_TO_LABEL() {
		return COMP_WCS_AGE_TO_LABEL;
	}

	public void setCOMP_WCS_AGE_TO_LABEL(HtmlOutputLabel comp_wcs_age_to_label) {
		COMP_WCS_AGE_TO_LABEL = comp_wcs_age_to_label;
	}

	public HtmlInputText getCOMP_WCS_AGE_TO() {
		return COMP_WCS_AGE_TO;
	}

	public void setCOMP_WCS_AGE_TO(HtmlInputText comp_wcs_age_to) {
		COMP_WCS_AGE_TO = comp_wcs_age_to;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void setGridValueList(List<PM_IL_WDS_CHARGES_SETUP> gridValueList) {
		this.gridValueList = gridValueList;
	}

	public void validateWCS_AGE_FM(FacesContext context, UIComponent component,
			Object value) {
		try {
			Integer ageValueFm = (Integer) value;
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_AGE_FM(ageValueFm);
			if (ageValueFm != null) {
				if (ageValueFm < 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91341"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWCS_AGE_To(FacesContext context, UIComponent component,
			Object value) {
		try {
			Integer ageValueTo = (Integer) value;
			if (ageValueTo != null) {
				if (ageValueTo < 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91341"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<PM_IL_WDS_CHARGES_SETUP> getGridValueList() {
		return gridValueList;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
	 private void initializeAllComponent() {
	
		 COMP_UI_M_PROD_CODE = new HtmlInputText();
		 COMP_WCS_YRS_FM_LABEL = new HtmlOutputLabel();
		 COMP_WCS_YRS_TO_LABEL = new HtmlOutputLabel();
		 COMP_WCS_APPLIED_ON = new HtmlSelectOneMenu();
		 COMP_WCS_APPLIED_ON_LABEL = new HtmlOutputLabel();
		 /*Newly added by pidugu raj*/
		 COMP_WCS_FORMULA_CODE = new HtmlSelectOneMenu();
		 COMP_WCS_FORMULA_CODE_LABEL = new HtmlOutputLabel();
		 COMP_UI_M_FORMULA_CODE_DESC		 = new HtmlInputText();
		 COMP_PCC_FLEX_01 = new HtmlInputText();
		 
	 }
	 
	 /*End*/
	 
	 
	 public void validateWCS_APPLIED_ON(FacesContext fc,
				UIComponent component, Object value)throws ValidatorException, Exception {
			try
			{

				String appliedOn = (String) value;
				/*Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion*/
				
				
				
				if(appliedOn.equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() !=null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() !=null)){
					COMP_WCS_FORMULA_CODE.setDisabled(false);
					COMP_WCS_FORMULA_CODE.resetValue();
				}if(appliedOn.equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() !=null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() ==null)){
					COMP_WCS_FORMULA_CODE.setDisabled(false);
					COMP_WCS_FORMULA_CODE.resetValue();
				}if(appliedOn.equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() ==null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() !=null)){
					COMP_WCS_FORMULA_CODE.setDisabled(false);
					COMP_WCS_FORMULA_CODE.resetValue();
				}if(appliedOn.equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() ==null && PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() ==null)){
					COMP_WCS_FORMULA_CODE.setDisabled(true);
					COMP_WCS_FORMULA_CODE.resetValue();
				}
				
				
				
				
				
				
				
				/*if(appliedOn.equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE().equalsIgnoreCase("G01") || PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE().equalsIgnoreCase("G02"))){
					COMP_WCS_FORMULA_CODE.setDisabled(false);
					COMP_WCS_FORMULA_CODE.resetValue();
				}else{
					COMP_WCS_FORMULA_CODE.setDisabled(true);
					COMP_WCS_FORMULA_CODE.resetValue();
				}*/
				/*End Newly added by pidugu raj dt: 16-10-2018 as per srinivas reddy suggestion*/
				PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_APPLIED_ON((String) value);
				resetAllComponent();
		             }
			
		             catch (Exception e) { 
		     throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
			
			
		}

	public List<SelectItem> getWCS_FORUMULACODE_ARRAYLIST() {
		return WCS_FORUMULACODE_ARRAYLIST;
	}

	public void setWCS_FORUMULACODE_ARRAYLIST(
			List<SelectItem> wCS_FORUMULACODE_ARRAYLIST) {
		WCS_FORUMULACODE_ARRAYLIST = wCS_FORUMULACODE_ARRAYLIST;
	}

	/* Newly added for withdrawal setup onload Formula code disable added by rakesh on 19-10-2018*/
	public void onLoad(PhaseEvent event) {
	try {
		
		COMP_PCC_FLEX_01.setDisabled(true);
		COMP_PCC_FLEX_01.resetValue();
		
		if((PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() != null || PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() != null) && !"".equals((PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() != null || PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() != null))){
			ResultSet rs = null;
			String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN where PLAN_CODE=?";
			if(PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() != null){
			rs = getHandler().executeSelectStatement(query,getConnection(),new Object[] {PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE()});
			}else if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() != null){
				rs = getHandler().executeSelectStatement(query,getConnection(),new Object[] {PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE()});	
			}

			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase("U"))
				{
					if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON()!=null && PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON()!="")
					{
						
						COMP_PCC_FLEX_01.setDisabled(true);
						COMP_PCC_FLEX_01.resetValue();
						if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equalsIgnoreCase("3")){
							COMP_PCC_FLEX_01.setDisabled(false);
							COMP_PCC_FLEX_01.resetValue();
						}else{
							PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
							PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
							COMP_PCC_FLEX_01.setDisabled(true);
							COMP_PCC_FLEX_01.resetValue();
						}
					}
				}
				else
				{
					PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
					PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
					COMP_PCC_FLEX_01.setDisabled(true);
					COMP_PCC_FLEX_01.resetValue();
				}
			}
		}
		else
		{
			if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() !=null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() !=null)){
				COMP_PCC_FLEX_01.setDisabled(false);
				COMP_PCC_FLEX_01.resetValue();
			}
			else if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() !=null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() ==null)){
				COMP_PCC_FLEX_01.setDisabled(false);
				COMP_PCC_FLEX_01.resetValue();
			}
			else if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() ==null || PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() !=null)){
				COMP_PCC_FLEX_01.setDisabled(false);
				COMP_PCC_FLEX_01.resetValue();
			}
			else if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equals("3") && (PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_PROD_CODE() ==null && PM_IL_WDS_CHARGES_SETUP_BEAN.getUI_M_PROD_CODE() ==null)){
				COMP_PCC_FLEX_01.setDisabled(false);
				COMP_PCC_FLEX_01.resetValue();
			}
			else{
				PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
				PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
				COMP_PCC_FLEX_01.setDisabled(true);
				COMP_PCC_FLEX_01.resetValue();
			}
			
			/*if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_CHARGE_CODE() != null && !"".equals(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_CHARGE_CODE())){
				if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_CHARGE_CODE().equalsIgnoreCase("G01") || PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_CHARGE_CODE().equalsIgnoreCase("G02"))
				{
						if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON()!=null && PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON()!="")
						{
							if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_APPLIED_ON().equalsIgnoreCase("3")){
								COMP_PCC_FLEX_01.setDisabled(false);
								COMP_PCC_FLEX_01.resetValue();
							}else{
								PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
								PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
								COMP_PCC_FLEX_01.setDisabled(true);
								COMP_PCC_FLEX_01.resetValue();
							}
						}
						else
						{
							PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
							PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
							COMP_PCC_FLEX_01.setDisabled(true);
							COMP_PCC_FLEX_01.resetValue();
						}
				}
				else
				{
					PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
					PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
					COMP_PCC_FLEX_01.setDisabled(true);
					COMP_PCC_FLEX_01.resetValue();
				}
			}
			else
			{
				PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE("");
				PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC("");
				COMP_PCC_FLEX_01.setDisabled(true);
				COMP_PCC_FLEX_01.resetValue();
			}*/
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("onLoad", e.getMessage());
	}

		/*Newly added by pidugu raj dt: 19-10-2018 as per sivaraman suggestion*/
		try{
		if(PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_FORMULA_CODE() != null && !PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_FORMULA_CODE().isEmpty()){
			ResultSet rs = null;
			String query = "SELECT FRM_DESC FROM PM_IL_FORMULA where FRM_CODE =?";
			
			rs = getHandler().executeSelectStatement(query,getConnection(),new Object[] {PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_FORMULA_CODE()});

			while (rs.next()) {
				PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC(rs.getString(1));
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
/*END*/
	
	/*Newly added by pidugu raj dt: 19-10-2018 as per sivaraman suggestion*/
	public List<LovBean> lovUI_M_FORMULA_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE  " +
					"(FRM_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("FORMULA_CODE", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	public void validateFormulaCode(FacesContext context,UIComponent component ,Object value){
		try{
			String formulaCode=(String)value;
			PM_IL_WDS_CHARGES_SETUP_BEAN.setWCS_FORMULA_CODE(formulaCode);
			whenValidateFormulaCode(formulaCode,PM_IL_WDS_CHARGES_SETUP_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void whenValidateFormulaCode(String formulaCode,
			PM_IL_WDS_CHARGES_SETUP PM_IL_WDS_CHARGES_SETUP_BEAN)
	throws Exception {
		//ArrayList<String> list = null;
		String query = "SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE LIKE ?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String frmCodeDesc=null;
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, con,new Object[]{formulaCode});
			if(rs.next())
			{
		
				frmCodeDesc=rs.getString(1);
			}
			PM_IL_WDS_CHARGES_SETUP_BEAN.setUI_M_FORMULA_CODE_DESC(frmCodeDesc);
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	public HtmlInputText getCOMP_UI_M_FORMULA_CODE_DESC() {
		return COMP_UI_M_FORMULA_CODE_DESC;
	}

	public void setCOMP_UI_M_FORMULA_CODE_DESC(
			HtmlInputText cOMP_UI_M_FORMULA_CODE_DESC) {
		COMP_UI_M_FORMULA_CODE_DESC = cOMP_UI_M_FORMULA_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FLEX1_LABEL() {
		return COMP_UI_M_FLEX1_LABEL;
	}

	public void setCOMP_UI_M_FLEX1_LABEL(HtmlOutputLabel cOMP_UI_M_FLEX1_LABEL) {
		COMP_UI_M_FLEX1_LABEL = cOMP_UI_M_FLEX1_LABEL;
	}

	public HtmlInputText getCOMP_PCC_FLEX_01() {
		return COMP_PCC_FLEX_01;
	}

	public void setCOMP_PCC_FLEX_01(HtmlInputText cOMP_PCC_FLEX_01) {
		COMP_PCC_FLEX_01 = cOMP_PCC_FLEX_01;
	}

	private HtmlInputText COMP_UI_M_FORMULA_CODE_DESC;
	private HtmlOutputLabel COMP_UI_M_FLEX1_LABEL;
	private HtmlInputText COMP_PCC_FLEX_01;
}

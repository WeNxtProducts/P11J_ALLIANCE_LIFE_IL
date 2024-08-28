package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
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
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ADDL_COVER_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POAC_ASSR_CODE_LABEL;

	private HtmlInputText COMP_POAC_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_POAC_ASSR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POAC_ASSR_NAME;

	private HtmlOutputLabel COMP_POAC_FM_DT_LABEL;

	private HtmlCalendar COMP_POAC_FM_DT;

	private HtmlOutputLabel COMP_POAC_PERIOD_LABEL;

	private HtmlInputText COMP_POAC_PERIOD;

	private HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_POAC_FC_SA_LABEL;

	private HtmlInputText COMP_POAC_FC_SA;

	private HtmlOutputLabel COMP_POAC_LC_SA_LABEL;

	private HtmlInputText COMP_POAC_LC_SA;

	private HtmlOutputLabel COMP_POAC_WOP_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAC_WOP_FLAG;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC;

	private HtmlOutputLabel COMP_POAC_OCC_RATE_LABEL;

	private HtmlInputText COMP_POAC_OCC_RATE;

	private HtmlOutputLabel COMP_POAC_ORG_FC_SA_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_FC_SA;

	private HtmlOutputLabel COMP_POAC_ORG_LC_SA_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_LC_SA;

	private HtmlOutputLabel COMP_POAC_ORG_FC_PREM_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_FC_PREM;

	private HtmlOutputLabel COMP_POAC_ORG_LC_PREM_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_LC_PREM;

	private HtmlOutputLabel COMP_POAC_ORG_RATE_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_RATE;

	private HtmlOutputLabel COMP_POAC_ORG_RATE_PER_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_RATE_PER;

	private HtmlOutputLabel COMP_POAC_ORG_PERIOD_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_PERIOD;

	private HtmlOutputLabel COMP_POAC_ORG_PREM_PAY_YRS_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PCG_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PCG_CODE;

	private HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_POAC_COVER_CODE;

	private HtmlOutputLabel COMP_POAC_TO_DT_LABEL;

	private HtmlCalendar COMP_POAC_TO_DT;

	private HtmlOutputLabel COMP_POAC_LIMIT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POAC_LIMIT_TYPE;

	private HtmlOutputLabel COMP_POAC_PER_DAY_LC_AMT_LABEL;

	private HtmlInputText COMP_POAC_PER_DAY_LC_AMT;

	private HtmlOutputLabel COMP_POAC_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_POAC_LIMIT_DAYS;

	private HtmlOutputLabel COMP_POAC_LC_LIMIT_LABEL;

	private HtmlInputText COMP_POAC_LC_LIMIT;

	private HtmlOutputLabel COMP_UI_M_POAC_ASSR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POAC_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE_1;

	private HtmlOutputLabel COMP_UI_M_PCG_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_PCG_CODE_1;

	private HtmlOutputLabel COMP_POAC_RATE_LABEL;

	private HtmlInputText COMP_POAC_RATE;

	private HtmlOutputLabel COMP_POAC_RATE_PER_LABEL;

	private HtmlInputText COMP_POAC_RATE_PER;

	private HtmlOutputLabel COMP_POAC_FC_PREM_LABEL;

	private HtmlInputText COMP_POAC_FC_PREM;

	private HtmlOutputLabel COMP_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_POAC_LC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_CODE_PAYEE_1_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_CODE_PAYEE_1;

	private HtmlOutputLabel COMP_POAC_TARIFF_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAC_TARIFF_TERM_FLAG;

	private HtmlOutputLabel COMP_POAC_RATE_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_POAC_RATE_APPLIED_ON;

	private HtmlOutputLabel COMP_UI_M_POAC_FC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_FC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_LC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_CODE_PAYEE_2_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_CODE_PAYEE_2;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_2_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC_2;

	private HtmlOutputLabel COMP_POAC_MED_DAYS_LABEL;

	private HtmlInputText COMP_POAC_MED_DAYS;

	private HtmlOutputLabel COMP_POAC_LC_MED_AMT_LABEL;

	private HtmlInputText COMP_POAC_LC_MED_AMT;
	
	private HtmlOutputLabel COMP_POAC_NO_OF_UNIT_LABEL;
	
	private HtmlInputText COMP_POAC_NO_OF_UNIT;
	
	private HtmlOutputLabel COMP_POAC_ORG_NO_OF_UNIT_LABEL;
	
	private HtmlInputText COMP_POAC_ORG_NO_OF_UNIT;
	
	private HtmlSelectOneMenu COMP_POAC_APPL_ALL;
	
	private HtmlCommandButton COMP_UI_M_BTN_BENEFIT_DTLS_1;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_ADDL_COVER;

	private HtmlCommandButton COMP_UI_M_BUT_MORE_COVER_1;
	
	private PT_IL_POL_ADDL_COVER_1 PT_IL_POL_ADDL_COVER_1_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ADDL_COVER_1_HELPER helper;

	private List<PT_IL_POL_ADDL_COVER_1> dataList_PT_IL_POL_ADDL_COVER_1 = new ArrayList<PT_IL_POL_ADDL_COVER_1>();

	private UIData dataTable;

	private List<SelectItem> listPOAC_WOP_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_LIMIT_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_RATE_APPLIED_ON = new ArrayList<SelectItem>();

	public PT_IL_POL_ADDL_COVER_1_ACTION(){
		PT_IL_POL_ADDL_COVER_1_BEAN = new PT_IL_POL_ADDL_COVER_1();
		helper = new PT_IL_POL_ADDL_COVER_1_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
		
	}

	/**
	 * Instantiates all components in PT_IL_POL_ADDL_COVER_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POAC_ASSR_CODE				 = new HtmlInputText();
		COMP_UI_M_POAC_ASSR_NAME			 = new HtmlInputText();
		COMP_POAC_PERIOD				 = new HtmlInputText();
		COMP_POAC_PREM_PAY_YRS				 = new HtmlInputText();
		COMP_POAC_FC_SA					 = new HtmlInputText();
		COMP_POAC_LC_SA					 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_DESC			 = new HtmlInputText();
		COMP_POAC_OCC_RATE				 = new HtmlInputText();
		COMP_POAC_ORG_FC_SA				 = new HtmlInputText();
		COMP_POAC_ORG_LC_SA				 = new HtmlInputText();
		COMP_POAC_ORG_FC_PREM				 = new HtmlInputText();
		COMP_POAC_ORG_LC_PREM				 = new HtmlInputText();
		COMP_POAC_ORG_RATE				 = new HtmlInputText();
		COMP_POAC_ORG_RATE_PER				 = new HtmlInputText();
		COMP_POAC_ORG_PERIOD				 = new HtmlInputText();
		COMP_POAC_ORG_PREM_PAY_YRS			 = new HtmlInputText();
		COMP_UI_M_PROD_CODE				 = new HtmlInputText();
		COMP_UI_M_PCG_CODE				 = new HtmlInputText();
		COMP_POAC_COVER_CODE				 = new HtmlInputText();
		COMP_POAC_PER_DAY_LC_AMT			 = new HtmlInputText();
		COMP_POAC_LIMIT_DAYS				 = new HtmlInputText();
		COMP_POAC_LC_LIMIT				 = new HtmlInputText();
		COMP_UI_M_POAC_ASSR_CODE			 = new HtmlInputText();
		COMP_UI_M_PROD_CODE_1				 = new HtmlInputText();
		COMP_UI_M_PCG_CODE_1				 = new HtmlInputText();
		COMP_POAC_RATE					 = new HtmlInputText();
		COMP_POAC_RATE_PER				 = new HtmlInputText();
		COMP_POAC_FC_PREM				 = new HtmlInputText();
		COMP_POAC_LC_PREM				 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1		 = new HtmlInputText();
		COMP_UI_M_POAC_FC_PREM				 = new HtmlInputText();
		COMP_UI_M_POAC_LC_PREM				 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2		 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_DESC_2			 = new HtmlInputText();
		COMP_POAC_MED_DAYS				 = new HtmlInputText();
		COMP_POAC_LC_MED_AMT				 = new HtmlInputText();
		COMP_POAC_NO_OF_UNIT				 = new HtmlInputText();
		COMP_POAC_ORG_NO_OF_UNIT			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_POAC_WOP_FLAG				 = new HtmlSelectOneMenu();
		COMP_POAC_LIMIT_TYPE				 = new HtmlSelectOneMenu();
		COMP_POAC_TARIFF_TERM_FLAG			 = new HtmlSelectOneMenu();
		COMP_POAC_RATE_APPLIED_ON			 = new HtmlSelectOneMenu();
		COMP_POAC_APPL_ALL				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_POAC_FM_DT					 = new HtmlCalendar();
		COMP_POAC_TO_DT					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BTN_BENEFIT_DTLS_1			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_ADDL_COVER			 = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE_COVER_1			 = new HtmlCommandButton();

	}


	
	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPOAC_WOP_FLAG = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_ADDL_COVER", "PT_IL_POL_ADDL_COVER.POAC_WOP_FLAG", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_LABEL() {
		return COMP_UI_M_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE() {
		return COMP_UI_M_PROD_CODE;
	}

	public void setCOMP_UI_M_PROD_CODE_LABEL(HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL) {
		this.COMP_UI_M_PROD_CODE_LABEL = COMP_UI_M_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE(HtmlInputText COMP_UI_M_PROD_CODE) {
		this.COMP_UI_M_PROD_CODE = COMP_UI_M_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCG_CODE_LABEL() {
		return COMP_UI_M_PCG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCG_CODE() {
		return COMP_UI_M_PCG_CODE;
	}

	public void setCOMP_UI_M_PCG_CODE_LABEL(HtmlOutputLabel COMP_UI_M_PCG_CODE_LABEL) {
		this.COMP_UI_M_PCG_CODE_LABEL = COMP_UI_M_PCG_CODE_LABEL;
	}

	public void setCOMP_UI_M_PCG_CODE(HtmlInputText COMP_UI_M_PCG_CODE) {
		this.COMP_UI_M_PCG_CODE = COMP_UI_M_PCG_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_COVER_CODE_LABEL() {
		return COMP_POAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_COVER_CODE() {
		return COMP_POAC_COVER_CODE;
	}

	public void setCOMP_POAC_COVER_CODE_LABEL(HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL) {
		this.COMP_POAC_COVER_CODE_LABEL = COMP_POAC_COVER_CODE_LABEL;
	}

	public void setCOMP_POAC_COVER_CODE(HtmlInputText COMP_POAC_COVER_CODE) {
		this.COMP_POAC_COVER_CODE = COMP_POAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_FM_DT_LABEL() {
		return COMP_POAC_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_FM_DT() {
		return COMP_POAC_FM_DT;
	}

	public void setCOMP_POAC_FM_DT_LABEL(HtmlOutputLabel COMP_POAC_FM_DT_LABEL) {
		this.COMP_POAC_FM_DT_LABEL = COMP_POAC_FM_DT_LABEL;
	}

	public void setCOMP_POAC_FM_DT(HtmlCalendar COMP_POAC_FM_DT) {
		this.COMP_POAC_FM_DT = COMP_POAC_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_TO_DT_LABEL() {
		return COMP_POAC_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_TO_DT() {
		return COMP_POAC_TO_DT;
	}

	public void setCOMP_POAC_TO_DT_LABEL(HtmlOutputLabel COMP_POAC_TO_DT_LABEL) {
		this.COMP_POAC_TO_DT_LABEL = COMP_POAC_TO_DT_LABEL;
	}

	public void setCOMP_POAC_TO_DT(HtmlCalendar COMP_POAC_TO_DT) {
		this.COMP_POAC_TO_DT = COMP_POAC_TO_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_PERIOD_LABEL() {
		return COMP_POAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PERIOD() {
		return COMP_POAC_PERIOD;
	}

	public void setCOMP_POAC_PERIOD_LABEL(HtmlOutputLabel COMP_POAC_PERIOD_LABEL) {
		this.COMP_POAC_PERIOD_LABEL = COMP_POAC_PERIOD_LABEL;
	}

	public void setCOMP_POAC_PERIOD(HtmlInputText COMP_POAC_PERIOD) {
		this.COMP_POAC_PERIOD = COMP_POAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POAC_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PREM_PAY_YRS() {
		return COMP_POAC_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_PREM_PAY_YRS_LABEL(HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL) {
		this.COMP_POAC_PREM_PAY_YRS_LABEL = COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_PREM_PAY_YRS(HtmlInputText COMP_POAC_PREM_PAY_YRS) {
		this.COMP_POAC_PREM_PAY_YRS = COMP_POAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_POAC_FC_SA_LABEL() {
		return COMP_POAC_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_FC_SA() {
		return COMP_POAC_FC_SA;
	}

	public void setCOMP_POAC_FC_SA_LABEL(HtmlOutputLabel COMP_POAC_FC_SA_LABEL) {
		this.COMP_POAC_FC_SA_LABEL = COMP_POAC_FC_SA_LABEL;
	}

	public void setCOMP_POAC_FC_SA(HtmlInputText COMP_POAC_FC_SA) {
		this.COMP_POAC_FC_SA = COMP_POAC_FC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_SA_LABEL() {
		return COMP_POAC_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_SA() {
		return COMP_POAC_LC_SA;
	}

	public void setCOMP_POAC_LC_SA_LABEL(HtmlOutputLabel COMP_POAC_LC_SA_LABEL) {
		this.COMP_POAC_LC_SA_LABEL = COMP_POAC_LC_SA_LABEL;
	}

	public void setCOMP_POAC_LC_SA(HtmlInputText COMP_POAC_LC_SA) {
		this.COMP_POAC_LC_SA = COMP_POAC_LC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_WOP_FLAG_LABEL() {
		return COMP_POAC_WOP_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAC_WOP_FLAG() {
		return COMP_POAC_WOP_FLAG;
	}

	public void setCOMP_POAC_WOP_FLAG_LABEL(HtmlOutputLabel COMP_POAC_WOP_FLAG_LABEL) {
		this.COMP_POAC_WOP_FLAG_LABEL = COMP_POAC_WOP_FLAG_LABEL;
	}

	public void setCOMP_POAC_WOP_FLAG(HtmlSelectOneMenu COMP_POAC_WOP_FLAG) {
		this.COMP_POAC_WOP_FLAG = COMP_POAC_WOP_FLAG;
	}

	public HtmlOutputLabel getCOMP_POAC_LIMIT_TYPE_LABEL() {
		return COMP_POAC_LIMIT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAC_LIMIT_TYPE() {
		return COMP_POAC_LIMIT_TYPE;
	}

	public void setCOMP_POAC_LIMIT_TYPE_LABEL(HtmlOutputLabel COMP_POAC_LIMIT_TYPE_LABEL) {
		this.COMP_POAC_LIMIT_TYPE_LABEL = COMP_POAC_LIMIT_TYPE_LABEL;
	}

	public void setCOMP_POAC_LIMIT_TYPE(HtmlSelectOneMenu COMP_POAC_LIMIT_TYPE) {
		this.COMP_POAC_LIMIT_TYPE = COMP_POAC_LIMIT_TYPE;
	}

	public HtmlOutputLabel getCOMP_POAC_PER_DAY_LC_AMT_LABEL() {
		return COMP_POAC_PER_DAY_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PER_DAY_LC_AMT() {
		return COMP_POAC_PER_DAY_LC_AMT;
	}

	public void setCOMP_POAC_PER_DAY_LC_AMT_LABEL(HtmlOutputLabel COMP_POAC_PER_DAY_LC_AMT_LABEL) {
		this.COMP_POAC_PER_DAY_LC_AMT_LABEL = COMP_POAC_PER_DAY_LC_AMT_LABEL;
	}

	public void setCOMP_POAC_PER_DAY_LC_AMT(HtmlInputText COMP_POAC_PER_DAY_LC_AMT) {
		this.COMP_POAC_PER_DAY_LC_AMT = COMP_POAC_PER_DAY_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_POAC_LIMIT_DAYS_LABEL() {
		return COMP_POAC_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LIMIT_DAYS() {
		return COMP_POAC_LIMIT_DAYS;
	}

	public void setCOMP_POAC_LIMIT_DAYS_LABEL(HtmlOutputLabel COMP_POAC_LIMIT_DAYS_LABEL) {
		this.COMP_POAC_LIMIT_DAYS_LABEL = COMP_POAC_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_POAC_LIMIT_DAYS(HtmlInputText COMP_POAC_LIMIT_DAYS) {
		this.COMP_POAC_LIMIT_DAYS = COMP_POAC_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_LIMIT_LABEL() {
		return COMP_POAC_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_LIMIT() {
		return COMP_POAC_LC_LIMIT;
	}

	public void setCOMP_POAC_LC_LIMIT_LABEL(HtmlOutputLabel COMP_POAC_LC_LIMIT_LABEL) {
		this.COMP_POAC_LC_LIMIT_LABEL = COMP_POAC_LC_LIMIT_LABEL;
	}

	public void setCOMP_POAC_LC_LIMIT(HtmlInputText COMP_POAC_LC_LIMIT) {
		this.COMP_POAC_LC_LIMIT = COMP_POAC_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC() {
		return COMP_UI_M_POAC_COVER_DESC;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL) {
		this.COMP_UI_M_POAC_COVER_DESC_LABEL = COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC(HtmlInputText COMP_UI_M_POAC_COVER_DESC) {
		this.COMP_UI_M_POAC_COVER_DESC = COMP_UI_M_POAC_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_POAC_OCC_RATE_LABEL() {
		return COMP_POAC_OCC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_OCC_RATE() {
		return COMP_POAC_OCC_RATE;
	}

	public void setCOMP_POAC_OCC_RATE_LABEL(HtmlOutputLabel COMP_POAC_OCC_RATE_LABEL) {
		this.COMP_POAC_OCC_RATE_LABEL = COMP_POAC_OCC_RATE_LABEL;
	}

	public void setCOMP_POAC_OCC_RATE(HtmlInputText COMP_POAC_OCC_RATE) {
		this.COMP_POAC_OCC_RATE = COMP_POAC_OCC_RATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_ASSR_CODE_LABEL() {
		return COMP_UI_M_POAC_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_ASSR_CODE() {
		return COMP_UI_M_POAC_ASSR_CODE;
	}

	public void setCOMP_UI_M_POAC_ASSR_CODE_LABEL(HtmlOutputLabel COMP_UI_M_POAC_ASSR_CODE_LABEL) {
		this.COMP_UI_M_POAC_ASSR_CODE_LABEL = COMP_UI_M_POAC_ASSR_CODE_LABEL;
	}

	public void setCOMP_UI_M_POAC_ASSR_CODE(HtmlInputText COMP_UI_M_POAC_ASSR_CODE) {
		this.COMP_UI_M_POAC_ASSR_CODE = COMP_UI_M_POAC_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_1_LABEL() {
		return COMP_UI_M_PROD_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE_1() {
		return COMP_UI_M_PROD_CODE_1;
	}

	public void setCOMP_UI_M_PROD_CODE_1_LABEL(HtmlOutputLabel COMP_UI_M_PROD_CODE_1_LABEL) {
		this.COMP_UI_M_PROD_CODE_1_LABEL = COMP_UI_M_PROD_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE_1(HtmlInputText COMP_UI_M_PROD_CODE_1) {
		this.COMP_UI_M_PROD_CODE_1 = COMP_UI_M_PROD_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCG_CODE_1_LABEL() {
		return COMP_UI_M_PCG_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCG_CODE_1() {
		return COMP_UI_M_PCG_CODE_1;
	}

	public void setCOMP_UI_M_PCG_CODE_1_LABEL(HtmlOutputLabel COMP_UI_M_PCG_CODE_1_LABEL) {
		this.COMP_UI_M_PCG_CODE_1_LABEL = COMP_UI_M_PCG_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_PCG_CODE_1(HtmlInputText COMP_UI_M_PCG_CODE_1) {
		this.COMP_UI_M_PCG_CODE_1 = COMP_UI_M_PCG_CODE_1;
	}


	public HtmlOutputLabel getCOMP_POAC_MED_DAYS_LABEL() {
		return COMP_POAC_MED_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_MED_DAYS() {
		return COMP_POAC_MED_DAYS;
	}

	public void setCOMP_POAC_MED_DAYS_LABEL(HtmlOutputLabel COMP_POAC_MED_DAYS_LABEL) {
		this.COMP_POAC_MED_DAYS_LABEL = COMP_POAC_MED_DAYS_LABEL;
	}

	public void setCOMP_POAC_MED_DAYS(HtmlInputText COMP_POAC_MED_DAYS) {
		this.COMP_POAC_MED_DAYS = COMP_POAC_MED_DAYS;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_BENEFIT_DTLS_1() {
		return COMP_UI_M_BTN_BENEFIT_DTLS_1;
	}

	public void setCOMP_UI_M_BTN_BENEFIT_DTLS_1(HtmlCommandButton COMP_UI_M_BTN_BENEFIT_DTLS_1) {
		this.COMP_UI_M_BTN_BENEFIT_DTLS_1 = COMP_UI_M_BTN_BENEFIT_DTLS_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_ADDL_COVER() {
		return COMP_UI_M_BUT_LOV_ADDL_COVER;
	}

	public void setCOMP_UI_M_BUT_LOV_ADDL_COVER(HtmlCommandButton COMP_UI_M_BUT_LOV_ADDL_COVER) {
		this.COMP_UI_M_BUT_LOV_ADDL_COVER = COMP_UI_M_BUT_LOV_ADDL_COVER;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE_COVER_1() {
		return COMP_UI_M_BUT_MORE_COVER_1;
	}

	public void setCOMP_UI_M_BUT_MORE_COVER_1(HtmlCommandButton COMP_UI_M_BUT_MORE_COVER_1) {
		this.COMP_UI_M_BUT_MORE_COVER_1 = COMP_UI_M_BUT_MORE_COVER_1;
	}

	public PT_IL_POL_ADDL_COVER_1 getPT_IL_POL_ADDL_COVER_1_BEAN() {
		return PT_IL_POL_ADDL_COVER_1_BEAN;
	}

	public void setPT_IL_POL_ADDL_COVER_1_BEAN(PT_IL_POL_ADDL_COVER_1 PT_IL_POL_ADDL_COVER_1_BEAN) {
		this.PT_IL_POL_ADDL_COVER_1_BEAN = PT_IL_POL_ADDL_COVER_1_BEAN;
	}

	public List<PT_IL_POL_ADDL_COVER_1> getDataList_PT_IL_POL_ADDL_COVER_1() {
		return dataList_PT_IL_POL_ADDL_COVER_1;
	}

	public void setDataListPT_IL_POL_ADDL_COVER_1(
			List<PT_IL_POL_ADDL_COVER_1> dataList_PT_IL_POL_ADDL_COVER_1) {
		this.dataList_PT_IL_POL_ADDL_COVER_1 = dataList_PT_IL_POL_ADDL_COVER_1;
	}

	public void addRow(ActionEvent event){
		try{
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){
				PT_IL_POL_ADDL_COVER_1_BEAN = new PT_IL_POL_ADDL_COVER_1();
				helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_1_BEAN, 
					compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN(), 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN());
				resetAllComponent();
				resetSelectedRow();
			}else{
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow",exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent event){
		try{
			if (isDELETE_ALLOWED()){

				new CRUDHandler().executeDelete(PT_IL_POL_ADDL_COVER_1_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_POL_ADDL_COVER_1.remove(PT_IL_POL_ADDL_COVER_1_BEAN);
				if(dataList_PT_IL_POL_ADDL_COVER_1.size()>0){

					PT_IL_POL_ADDL_COVER_1_BEAN=dataList_PT_IL_POL_ADDL_COVER_1.get(0);
				}else if(dataList_PT_IL_POL_ADDL_COVER_1.size()==0){
					addRow(null);
				}
				resetAllComponent();
				PT_IL_POL_ADDL_COVER_1_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
	}

	public void postRecord(ActionEvent event){
		try{
			if(PT_IL_POL_ADDL_COVER_1_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				helper.preInsert( PT_IL_POL_ADDL_COVER_1_BEAN, 
					compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_ADDL_COVER_1_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				dataList_PT_IL_POL_ADDL_COVER_1.add(PT_IL_POL_ADDL_COVER_1_BEAN);
			}else if(PT_IL_POL_ADDL_COVER_1_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
				helper.preUpdate(PT_IL_POL_ADDL_COVER_1_BEAN, 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_ADDL_COVER_1_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			}

			PT_IL_POL_ADDL_COVER_1_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}
	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);try{
			resetSelectedRow();
			PT_IL_POL_ADDL_COVER_1_BEAN = (PT_IL_POL_ADDL_COVER_1)dataTable.getRowData();
			helper.postQuery(this, 
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(), 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(), 
					this ,compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN(),
					compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN());
			PT_IL_POL_ADDL_COVER_1_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}
	}

	private void resetSelectedRow(){
		Iterator<PT_IL_POL_ADDL_COVER_1> PT_IL_POL_ADDL_COVER_1_ITR = 
			dataList_PT_IL_POL_ADDL_COVER_1.iterator();
		while (PT_IL_POL_ADDL_COVER_1_ITR.hasNext()) {
			PT_IL_POL_ADDL_COVER_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent(){
		COMP_POAC_ASSR_CODE.resetValue();
		COMP_POAC_ASSR_CODE.resetValue();
		COMP_UI_M_POAC_ASSR_NAME.resetValue();
		COMP_UI_M_POAC_ASSR_NAME.resetValue();
		COMP_POAC_COVER_CODE.resetValue();
		COMP_POAC_FM_DT.resetValue();
		COMP_POAC_TO_DT.resetValue();
		COMP_POAC_PERIOD.resetValue();
		COMP_POAC_PREM_PAY_YRS.resetValue();
		COMP_POAC_FC_SA.resetValue();
		COMP_POAC_LC_SA.resetValue();
		COMP_POAC_WOP_FLAG.resetValue();
		COMP_UI_M_POAC_COVER_DESC.resetValue();
		COMP_POAC_OCC_RATE.resetValue();
		COMP_UI_M_PROD_CODE.resetValue();
		COMP_UI_M_PCG_CODE.resetValue();
		COMP_POAC_COVER_CODE.resetValue();
		COMP_POAC_FM_DT.resetValue();
		COMP_POAC_TO_DT.resetValue();
		COMP_POAC_PERIOD.resetValue();
		COMP_POAC_PREM_PAY_YRS.resetValue();
		COMP_POAC_FC_SA.resetValue();
		COMP_POAC_LC_SA.resetValue();
		COMP_POAC_WOP_FLAG.resetValue();
		COMP_POAC_LIMIT_TYPE.resetValue();
		COMP_POAC_PER_DAY_LC_AMT.resetValue();
		COMP_POAC_LIMIT_DAYS.resetValue();
		COMP_POAC_LC_LIMIT.resetValue();
		COMP_UI_M_POAC_COVER_DESC.resetValue();
		COMP_POAC_OCC_RATE.resetValue();
		COMP_UI_M_POAC_ASSR_CODE.resetValue();
		COMP_UI_M_PROD_CODE_1.resetValue();
		COMP_UI_M_PCG_CODE_1.resetValue();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1.resetValue();
		COMP_POAC_TARIFF_TERM_FLAG.resetValue();
		COMP_POAC_RATE_APPLIED_ON.resetValue();
		COMP_POAC_RATE.resetValue();
		COMP_POAC_RATE_PER.resetValue();
		COMP_POAC_FC_PREM.resetValue();
		COMP_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1.resetValue();
		COMP_POAC_TARIFF_TERM_FLAG.resetValue();
		COMP_POAC_RATE_APPLIED_ON.resetValue();
		COMP_POAC_RATE.resetValue();
		COMP_POAC_RATE_PER.resetValue();
		COMP_POAC_FC_PREM.resetValue();
		COMP_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_FC_PREM.resetValue();
		COMP_UI_M_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_FC_PREM.resetValue();
		COMP_UI_M_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2.resetValue();
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2.resetValue();
		COMP_UI_M_POAC_COVER_DESC_2.resetValue();
		COMP_UI_M_POAC_COVER_DESC_2.resetValue();
		COMP_POAC_MED_DAYS.resetValue();
		COMP_POAC_MED_DAYS.resetValue();
		COMP_POAC_LC_MED_AMT.resetValue();
		COMP_POAC_LC_MED_AMT.resetValue();
		COMP_POAC_TARIFF_TERM_FLAG.resetValue();
	}

	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPOAC_WOP_FLAG() {
		if (listPOAC_WOP_FLAG.size() == 0) {
			listPOAC_WOP_FLAG.clear();
			try {
				listPOAC_WOP_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_WOP_FLAG;
	}

	public void setListPOAC_WOP_FLAG(List<SelectItem> listPOAC_WOP_FLAG) {
		this.listPOAC_WOP_FLAG = listPOAC_WOP_FLAG;
	}

	public List<SelectItem> getListPOAC_LIMIT_TYPE() {
		if (listPOAC_LIMIT_TYPE.size() == 0) {
			listPOAC_LIMIT_TYPE.clear();
			try {
				listPOAC_LIMIT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_LIMIT_TYPE;
	}

	public void setListPOAC_LIMIT_TYPE(List<SelectItem> listPOAC_LIMIT_TYPE) {
		this.listPOAC_LIMIT_TYPE = listPOAC_LIMIT_TYPE;
	}


	public List<SelectItem> getListPOAC_TARIFF_TERM_FLAG() {
		if (listPOAC_TARIFF_TERM_FLAG.size() == 0) {
			listPOAC_TARIFF_TERM_FLAG.clear();
			try {
				listPOAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_TARIFF_TERM_FLAG;
	}

	public void setListPOAC_TARIFF_TERM_FLAG(List<SelectItem> listPOAC_TARIFF_TERM_FLAG) {
		this.listPOAC_TARIFF_TERM_FLAG = listPOAC_TARIFF_TERM_FLAG;
	}

	public List<SelectItem> getListPOAC_RATE_APPLIED_ON() {
		if (listPOAC_RATE_APPLIED_ON.size() == 0) {
			listPOAC_RATE_APPLIED_ON.clear();
			try {
				listPOAC_RATE_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_RATE_APPLIED_ON;
	}

	public void setListPOAC_RATE_APPLIED_ON(List<SelectItem> listPOAC_RATE_APPLIED_ON) {
		this.listPOAC_RATE_APPLIED_ON = listPOAC_RATE_APPLIED_ON;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				helper.onPopulateDetail(compositeAction);
				if(PT_IL_POL_ADDL_COVER_1_BEAN.getROWID() != null){
					helper.postQuery(this, 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(), 
								this,compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN(),
								compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN());
				}else{
					helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_1_BEAN, 
						compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN());
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_POAC_ASSR_CODE_LABEL() {
		return COMP_POAC_ASSR_CODE_LABEL;
	}

	public void setCOMP_POAC_ASSR_CODE_LABEL(
			HtmlOutputLabel comp_poac_assr_code_label) {
		COMP_POAC_ASSR_CODE_LABEL = comp_poac_assr_code_label;
	}

	public HtmlInputText getCOMP_POAC_ASSR_CODE() {
		return COMP_POAC_ASSR_CODE;
	}

	public void setCOMP_POAC_ASSR_CODE(HtmlInputText comp_poac_assr_code) {
		COMP_POAC_ASSR_CODE = comp_poac_assr_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_ASSR_NAME_LABEL() {
		return COMP_UI_M_POAC_ASSR_NAME_LABEL;
	}

	public void setCOMP_UI_M_POAC_ASSR_NAME_LABEL(
			HtmlOutputLabel comp_ui_m_poac_assr_name_label) {
		COMP_UI_M_POAC_ASSR_NAME_LABEL = comp_ui_m_poac_assr_name_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_ASSR_NAME() {
		return COMP_UI_M_POAC_ASSR_NAME;
	}

	public void setCOMP_UI_M_POAC_ASSR_NAME(HtmlInputText comp_ui_m_poac_assr_name) {
		COMP_UI_M_POAC_ASSR_NAME = comp_ui_m_poac_assr_name;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_LABEL() {
		return COMP_POAC_RATE_LABEL;
	}

	public void setCOMP_POAC_RATE_LABEL(HtmlOutputLabel comp_poac_rate_label) {
		COMP_POAC_RATE_LABEL = comp_poac_rate_label;
	}

	public HtmlInputText getCOMP_POAC_RATE() {
		return COMP_POAC_RATE;
	}

	public void setCOMP_POAC_RATE(HtmlInputText comp_poac_rate) {
		COMP_POAC_RATE = comp_poac_rate;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_PER_LABEL() {
		return COMP_POAC_RATE_PER_LABEL;
	}

	public void setCOMP_POAC_RATE_PER_LABEL(HtmlOutputLabel comp_poac_rate_per_label) {
		COMP_POAC_RATE_PER_LABEL = comp_poac_rate_per_label;
	}

	public HtmlInputText getCOMP_POAC_RATE_PER() {
		return COMP_POAC_RATE_PER;
	}

	public void setCOMP_POAC_RATE_PER(HtmlInputText comp_poac_rate_per) {
		COMP_POAC_RATE_PER = comp_poac_rate_per;
	}

	public HtmlOutputLabel getCOMP_POAC_FC_PREM_LABEL() {
		return COMP_POAC_FC_PREM_LABEL;
	}

	public void setCOMP_POAC_FC_PREM_LABEL(HtmlOutputLabel comp_poac_fc_prem_label) {
		COMP_POAC_FC_PREM_LABEL = comp_poac_fc_prem_label;
	}

	public HtmlInputText getCOMP_POAC_FC_PREM() {
		return COMP_POAC_FC_PREM;
	}

	public void setCOMP_POAC_FC_PREM(HtmlInputText comp_poac_fc_prem) {
		COMP_POAC_FC_PREM = comp_poac_fc_prem;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_PREM_LABEL() {
		return COMP_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_LC_PREM_LABEL(HtmlOutputLabel comp_poac_lc_prem_label) {
		COMP_POAC_LC_PREM_LABEL = comp_poac_lc_prem_label;
	}

	public HtmlInputText getCOMP_POAC_LC_PREM() {
		return COMP_POAC_LC_PREM;
	}

	public void setCOMP_POAC_LC_PREM(HtmlInputText comp_poac_lc_prem) {
		COMP_POAC_LC_PREM = comp_poac_lc_prem;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_CODE_PAYEE_1_LABEL() {
		return COMP_UI_M_POAC_COVER_CODE_PAYEE_1_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_PAYEE_1_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_code_payee_1_label) {
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1_LABEL = comp_ui_m_poac_cover_code_payee_1_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_CODE_PAYEE_1() {
		return COMP_UI_M_POAC_COVER_CODE_PAYEE_1;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_PAYEE_1(
			HtmlInputText comp_ui_m_poac_cover_code_payee_1) {
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1 = comp_ui_m_poac_cover_code_payee_1;
	}

	public HtmlOutputLabel getCOMP_POAC_TARIFF_TERM_FLAG_LABEL() {
		return COMP_POAC_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_POAC_TARIFF_TERM_FLAG_LABEL(
			HtmlOutputLabel comp_poac_tariff_term_flag_label) {
		COMP_POAC_TARIFF_TERM_FLAG_LABEL = comp_poac_tariff_term_flag_label;
	}

	public HtmlSelectOneMenu getCOMP_POAC_TARIFF_TERM_FLAG() {
		return COMP_POAC_TARIFF_TERM_FLAG;
	}

	public void setCOMP_POAC_TARIFF_TERM_FLAG(
			HtmlSelectOneMenu comp_poac_tariff_term_flag) {
		COMP_POAC_TARIFF_TERM_FLAG = comp_poac_tariff_term_flag;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_APPLIED_ON_LABEL() {
		return COMP_POAC_RATE_APPLIED_ON_LABEL;
	}

	public void setCOMP_POAC_RATE_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_poac_rate_applied_on_label) {
		COMP_POAC_RATE_APPLIED_ON_LABEL = comp_poac_rate_applied_on_label;
	}

	public HtmlSelectOneMenu getCOMP_POAC_RATE_APPLIED_ON() {
		return COMP_POAC_RATE_APPLIED_ON;
	}

	public void setCOMP_POAC_RATE_APPLIED_ON(
			HtmlSelectOneMenu comp_poac_rate_applied_on) {
		COMP_POAC_RATE_APPLIED_ON = comp_poac_rate_applied_on;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_FC_PREM_LABEL() {
		return COMP_UI_M_POAC_FC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POAC_FC_PREM_LABEL(
			HtmlOutputLabel comp_ui_m_poac_fc_prem_label) {
		COMP_UI_M_POAC_FC_PREM_LABEL = comp_ui_m_poac_fc_prem_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_FC_PREM() {
		return COMP_UI_M_POAC_FC_PREM;
	}

	public void setCOMP_UI_M_POAC_FC_PREM(HtmlInputText comp_ui_m_poac_fc_prem) {
		COMP_UI_M_POAC_FC_PREM = comp_ui_m_poac_fc_prem;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_LC_PREM_LABEL() {
		return COMP_UI_M_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POAC_LC_PREM_LABEL(
			HtmlOutputLabel comp_ui_m_poac_lc_prem_label) {
		COMP_UI_M_POAC_LC_PREM_LABEL = comp_ui_m_poac_lc_prem_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_LC_PREM() {
		return COMP_UI_M_POAC_LC_PREM;
	}

	public void setCOMP_UI_M_POAC_LC_PREM(HtmlInputText comp_ui_m_poac_lc_prem) {
		COMP_UI_M_POAC_LC_PREM = comp_ui_m_poac_lc_prem;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_CODE_PAYEE_2_LABEL() {
		return COMP_UI_M_POAC_COVER_CODE_PAYEE_2_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_PAYEE_2_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_code_payee_2_label) {
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2_LABEL = comp_ui_m_poac_cover_code_payee_2_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_CODE_PAYEE_2() {
		return COMP_UI_M_POAC_COVER_CODE_PAYEE_2;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_PAYEE_2(
			HtmlInputText comp_ui_m_poac_cover_code_payee_2) {
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2 = comp_ui_m_poac_cover_code_payee_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_2_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_2_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_2_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_desc_2_label) {
		COMP_UI_M_POAC_COVER_DESC_2_LABEL = comp_ui_m_poac_cover_desc_2_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC_2() {
		return COMP_UI_M_POAC_COVER_DESC_2;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_2(
			HtmlInputText comp_ui_m_poac_cover_desc_2) {
		COMP_UI_M_POAC_COVER_DESC_2 = comp_ui_m_poac_cover_desc_2;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_MED_AMT_LABEL() {
		return COMP_POAC_LC_MED_AMT_LABEL;
	}

	public void setCOMP_POAC_LC_MED_AMT_LABEL(
			HtmlOutputLabel comp_poac_lc_med_amt_label) {
		COMP_POAC_LC_MED_AMT_LABEL = comp_poac_lc_med_amt_label;
	}

	public HtmlInputText getCOMP_POAC_LC_MED_AMT() {
		return COMP_POAC_LC_MED_AMT;
	}

	public void setCOMP_POAC_LC_MED_AMT(HtmlInputText comp_poac_lc_med_amt) {
		COMP_POAC_LC_MED_AMT = comp_poac_lc_med_amt;
	}

	public void setDataList_PT_IL_POL_ADDL_COVER_1(
			List<PT_IL_POL_ADDL_COVER_1> dataList_PT_IL_POL_ADDL_COVER_1) {
		this.dataList_PT_IL_POL_ADDL_COVER_1 = dataList_PT_IL_POL_ADDL_COVER_1;
	}


	public void POAC_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_COVER_CODE((String) value);

			helper.POAC_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_NO_OF_UNIT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_NO_OF_UNIT((Integer) value);

			helper.POAC_NO_OF_UNIT_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_FM_DT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_FM_DT((Date) value);

			helper.POAC_FM_DT_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_TO_DT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_TO_DT((Date) value);

			helper.POAC_TO_DT_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_PERIOD_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_PERIOD((Integer) value);

			helper.POAC_PERIOD_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_FC_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_FC_SA((Double) value);

			helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_LC_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_LC_SA((Double) value);

			helper.POAC_LC_SA_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_RATE((Double) value);

			helper.POAC_RATE_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_RATE_PER((Double) value);

			helper.POAC_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_MED_DAYS_WHEN_VALIADTE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_MED_DAYS((Integer) value);

			helper.POAC_MED_DAYS_WHEN_VALIADTE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_WOP_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_WOP_FLAG((String) value);

			helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_LC_MED_AMT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_LC_MED_AMT((Double) value);

			helper.POAC_LC_MED_AMT_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_APPL_ALL_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_APPL_ALL((String) value);

			helper.POAC_APPL_ALL_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_PREM__PAY_YRS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_PREM_PAY_YRS((Integer)value);

			helper.POAC_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
					.getPT_IL_POL_ADDL_COVER_1_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_COVER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ADDL_COVER_1";
		String fieldName = "POAC_COVER_CODE";
		Object param1 = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
		.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
		Object param2 = "E";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1,
					param2, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public HtmlOutputLabel getCOMP_POAC_NO_OF_UNIT_LABEL() {
		return COMP_POAC_NO_OF_UNIT_LABEL;
	}

	public void setCOMP_POAC_NO_OF_UNIT_LABEL(
			HtmlOutputLabel comp_poac_no_of_unit_label) {
		COMP_POAC_NO_OF_UNIT_LABEL = comp_poac_no_of_unit_label;
	}

	public HtmlInputText getCOMP_POAC_NO_OF_UNIT() {
		return COMP_POAC_NO_OF_UNIT;
	}

	public void setCOMP_POAC_NO_OF_UNIT(HtmlInputText comp_poac_no_of_unit) {
		COMP_POAC_NO_OF_UNIT = comp_poac_no_of_unit;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_FC_SA_LABEL() {
		return COMP_POAC_ORG_FC_SA_LABEL;
	}

	public void setCOMP_POAC_ORG_FC_SA_LABEL(
			HtmlOutputLabel comp_poac_org_fc_sa_label) {
		COMP_POAC_ORG_FC_SA_LABEL = comp_poac_org_fc_sa_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_LC_SA_LABEL() {
		return COMP_POAC_ORG_LC_SA_LABEL;
	}

	public void setCOMP_POAC_ORG_LC_SA_LABEL(
			HtmlOutputLabel comp_poac_org_lc_sa_label) {
		COMP_POAC_ORG_LC_SA_LABEL = comp_poac_org_lc_sa_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_FC_PREM_LABEL() {
		return COMP_POAC_ORG_FC_PREM_LABEL;
	}

	public void setCOMP_POAC_ORG_FC_PREM_LABEL(
			HtmlOutputLabel comp_poac_org_fc_prem_label) {
		COMP_POAC_ORG_FC_PREM_LABEL = comp_poac_org_fc_prem_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_LC_PREM_LABEL() {
		return COMP_POAC_ORG_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_ORG_LC_PREM_LABEL(
			HtmlOutputLabel comp_poac_org_lc_prem_label) {
		COMP_POAC_ORG_LC_PREM_LABEL = comp_poac_org_lc_prem_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_RATE_LABEL() {
		return COMP_POAC_ORG_RATE_LABEL;
	}

	public void setCOMP_POAC_ORG_RATE_LABEL(HtmlOutputLabel comp_poac_org_rate_label) {
		COMP_POAC_ORG_RATE_LABEL = comp_poac_org_rate_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_RATE_PER_LABEL() {
		return COMP_POAC_ORG_RATE_PER_LABEL;
	}

	public void setCOMP_POAC_ORG_RATE_PER_LABEL(
			HtmlOutputLabel comp_poac_org_rate_per_label) {
		COMP_POAC_ORG_RATE_PER_LABEL = comp_poac_org_rate_per_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_PERIOD_LABEL() {
		return COMP_POAC_ORG_PERIOD_LABEL;
	}

	public void setCOMP_POAC_ORG_PERIOD_LABEL(
			HtmlOutputLabel comp_poac_org_period_label) {
		COMP_POAC_ORG_PERIOD_LABEL = comp_poac_org_period_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_ORG_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_ORG_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel comp_poac_org_prem_pay_yrs_label) {
		COMP_POAC_ORG_PREM_PAY_YRS_LABEL = comp_poac_org_prem_pay_yrs_label;
	}

	public HtmlInputText getCOMP_POAC_ORG_FC_SA() {
		return COMP_POAC_ORG_FC_SA;
	}

	public void setCOMP_POAC_ORG_FC_SA(HtmlInputText comp_poac_org_fc_sa) {
		COMP_POAC_ORG_FC_SA = comp_poac_org_fc_sa;
	}

	public HtmlInputText getCOMP_POAC_ORG_LC_SA() {
		return COMP_POAC_ORG_LC_SA;
	}

	public void setCOMP_POAC_ORG_LC_SA(HtmlInputText comp_poac_org_lc_sa) {
		COMP_POAC_ORG_LC_SA = comp_poac_org_lc_sa;
	}

	public HtmlInputText getCOMP_POAC_ORG_FC_PREM() {
		return COMP_POAC_ORG_FC_PREM;
	}

	public void setCOMP_POAC_ORG_FC_PREM(HtmlInputText comp_poac_org_fc_prem) {
		COMP_POAC_ORG_FC_PREM = comp_poac_org_fc_prem;
	}

	public HtmlInputText getCOMP_POAC_ORG_LC_PREM() {
		return COMP_POAC_ORG_LC_PREM;
	}

	public void setCOMP_POAC_ORG_LC_PREM(HtmlInputText comp_poac_org_lc_prem) {
		COMP_POAC_ORG_LC_PREM = comp_poac_org_lc_prem;
	}

	public HtmlInputText getCOMP_POAC_ORG_RATE() {
		return COMP_POAC_ORG_RATE;
	}

	public void setCOMP_POAC_ORG_RATE(HtmlInputText comp_poac_org_rate) {
		COMP_POAC_ORG_RATE = comp_poac_org_rate;
	}

	public HtmlInputText getCOMP_POAC_ORG_RATE_PER() {
		return COMP_POAC_ORG_RATE_PER;
	}

	public void setCOMP_POAC_ORG_RATE_PER(HtmlInputText comp_poac_org_rate_per) {
		COMP_POAC_ORG_RATE_PER = comp_poac_org_rate_per;
	}

	public HtmlInputText getCOMP_POAC_ORG_PERIOD() {
		return COMP_POAC_ORG_PERIOD;
	}

	public void setCOMP_POAC_ORG_PERIOD(HtmlInputText comp_poac_org_period) {
		COMP_POAC_ORG_PERIOD = comp_poac_org_period;
	}

	public HtmlInputText getCOMP_POAC_ORG_PREM_PAY_YRS() {
		return COMP_POAC_ORG_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_ORG_PREM_PAY_YRS(
			HtmlInputText comp_poac_org_prem_pay_yrs) {
		COMP_POAC_ORG_PREM_PAY_YRS = comp_poac_org_prem_pay_yrs;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_NO_OF_UNIT_LABEL() {
		return COMP_POAC_ORG_NO_OF_UNIT_LABEL;
	}

	public void setCOMP_POAC_ORG_NO_OF_UNIT_LABEL(
			HtmlOutputLabel comp_poac_org_no_of_unit_label) {
		COMP_POAC_ORG_NO_OF_UNIT_LABEL = comp_poac_org_no_of_unit_label;
	}

	public HtmlInputText getCOMP_POAC_ORG_NO_OF_UNIT() {
		return COMP_POAC_ORG_NO_OF_UNIT;
	}

	public void setCOMP_POAC_ORG_NO_OF_UNIT(HtmlInputText comp_poac_org_no_of_unit) {
		COMP_POAC_ORG_NO_OF_UNIT = comp_poac_org_no_of_unit;
	}

	public HtmlSelectOneMenu getCOMP_POAC_APPL_ALL() {
		return COMP_POAC_APPL_ALL;
	}

	public void setCOMP_POAC_APPL_ALL(HtmlSelectOneMenu comp_poac_appl_all) {
		COMP_POAC_APPL_ALL = comp_poac_appl_all;
	}


	/**
	 * Disables all components in PT_IL_POL_ADDL_COVER_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POAC_ASSR_CODE.setDisabled(disabled);
		COMP_UI_M_POAC_ASSR_NAME.setDisabled(disabled);
		COMP_POAC_PERIOD.setDisabled(disabled);
		COMP_POAC_PREM_PAY_YRS.setDisabled(disabled);
		COMP_POAC_FC_SA.setDisabled(disabled);
		COMP_POAC_LC_SA.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_DESC.setDisabled(disabled);
		COMP_POAC_OCC_RATE.setDisabled(disabled);
		COMP_POAC_ORG_FC_SA.setDisabled(disabled);
		COMP_POAC_ORG_LC_SA.setDisabled(disabled);
		COMP_POAC_ORG_FC_PREM.setDisabled(disabled);
		COMP_POAC_ORG_LC_PREM.setDisabled(disabled);
		COMP_POAC_ORG_RATE.setDisabled(disabled);
		COMP_POAC_ORG_RATE_PER.setDisabled(disabled);
		COMP_POAC_ORG_PERIOD.setDisabled(disabled);
		COMP_POAC_ORG_PREM_PAY_YRS.setDisabled(disabled);
		COMP_UI_M_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_PCG_CODE.setDisabled(disabled);
		COMP_POAC_COVER_CODE.setDisabled(disabled);
		COMP_POAC_PER_DAY_LC_AMT.setDisabled(disabled);
		COMP_POAC_LIMIT_DAYS.setDisabled(disabled);
		COMP_POAC_LC_LIMIT.setDisabled(disabled);
		COMP_UI_M_POAC_ASSR_CODE.setDisabled(disabled);
		COMP_UI_M_PROD_CODE_1.setDisabled(disabled);
		COMP_UI_M_PCG_CODE_1.setDisabled(disabled);
		COMP_POAC_RATE.setDisabled(disabled);
		COMP_POAC_RATE_PER.setDisabled(disabled);
		COMP_POAC_FC_PREM.setDisabled(disabled);
		COMP_POAC_LC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_CODE_PAYEE_1.setDisabled(disabled);
		COMP_UI_M_POAC_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_LC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_CODE_PAYEE_2.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_DESC_2.setDisabled(disabled);
		COMP_POAC_MED_DAYS.setDisabled(disabled);
		COMP_POAC_LC_MED_AMT.setDisabled(disabled);
		COMP_POAC_NO_OF_UNIT.setDisabled(disabled);
		COMP_POAC_ORG_NO_OF_UNIT.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POAC_WOP_FLAG.setDisabled(disabled);
		COMP_POAC_LIMIT_TYPE.setDisabled(disabled);
		COMP_POAC_TARIFF_TERM_FLAG.setDisabled(disabled);
		COMP_POAC_RATE_APPLIED_ON.setDisabled(disabled);
		COMP_POAC_APPL_ALL.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POAC_FM_DT.setDisabled(disabled);
		COMP_POAC_TO_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BTN_BENEFIT_DTLS_1.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_ADDL_COVER.setDisabled(disabled);
		COMP_UI_M_BUT_MORE_COVER_1.setDisabled(disabled);

	}

	public String beneDetail(){
		String outcome = null;
		outcome = "PILT002_APAC_PT_IL_POL_BENEFICIARY";
		return outcome;
	}
	public String back(){
		String outcome = null;
		outcome = "PILT002_APAC_PT_IL_POL_COVER_GROUP_1";
		return outcome;
	}
	 
}

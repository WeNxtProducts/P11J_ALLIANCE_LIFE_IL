package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.pel.forms.PILT011.PILT011_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_PAID_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CP_PAID_DT_1_LABEL;

	private HtmlCalendar COMP_CP_PAID_DT_1;

	private HtmlOutputLabel COMP_CCD_PROD_CODE_1_LABEL;

	private HtmlInputText COMP_CCD_PROD_CODE_1;

	private HtmlOutputLabel COMP_UI_M_CCD_PROD_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_PROD_CODE_1_DESC;

	private HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_CCD_COVER_CODE_1;

	private HtmlOutputLabel COMP_CP_ACCNT_PAY_CODE_1_LABEL;

	private HtmlInputText COMP_CP_ACCNT_PAY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_CP_CURR_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_CURR_CODE_1;

	private HtmlOutputLabel COMP_CP_FC_PAID_AMT_1_LABEL;

	private HtmlInputText COMP_CP_FC_PAID_AMT_1;

	private HtmlOutputLabel COMP_CP_LC_PAID_AMT_1_LABEL;

	private HtmlInputText COMP_CP_LC_PAID_AMT_1;

	private HtmlOutputLabel COMP_CP_SET_FLAG_1_LABEL;

	private HtmlSelectOneMenu COMP_CP_SET_FLAG_1;

	private HtmlOutputLabel COMP_CP_CLM_PAID_STATUS_1_LABEL;

	private HtmlSelectOneMenu COMP_CP_CLM_PAID_STATUS_1;

	private HtmlOutputLabel COMP_CP_APPR_FLAG_1_LABEL;

	private HtmlSelectOneMenu COMP_CP_APPR_FLAG_1;

	private HtmlOutputLabel COMP_CP_CLAIM_REJ_REASON_1_LABEL;

	private HtmlInputText COMP_CP_CLAIM_REJ_REASON_1;

	private HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_CCD_COVER_CODE_DESC_1;

	private HtmlOutputLabel COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1;

	private HtmlOutputLabel COMP_CP_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_CP_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_CP_CLAIM_PAID_TO_1_LABEL;

	private HtmlSelectOneMenu COMP_CP_CLAIM_PAID_TO_1;

	private HtmlOutputLabel COMP_UI_M_CP_FC_TOT_EST_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_TOT_EST_1;

	private HtmlOutputLabel COMP_UI_M_CP_LC_TOT_EST_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_TOT_EST_1;

	private HtmlOutputLabel COMP_UI_M_CP_FC_TOT_PAID_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_TOT_PAID_1;

	private HtmlOutputLabel COMP_UI_M_CP_LC_TOT_PAID_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_TOT_PAID_1;

	private HtmlOutputLabel COMP_UI_M_CP_FC_BALANCE_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_BALANCE_1;

	private HtmlOutputLabel COMP_UI_M_CP_LC_BALANCE_1_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_BALANCE_1;

	private PT_IL_CLAIM_PAID_1 PT_IL_CLAIM_PAID_1_BEAN;

	private List<PT_IL_CLAIM_PAID_1> PT_IL_CLAIM_PAID_1_BEAN_LIST;

	private UIData PT_IL_CLAIM_PAID_1_DATALIST;

	private List<SelectItem> approvalList;

	private List<SelectItem> claimPayToList;

	private List<SelectItem> statusList;

	private List<SelectItem> flagList;

	int lastUpdatedRowIndex = 0;

	int prevRowIndex = 0;

	private String filterByCCD_PROD_CODE_1;

	private String filterByUI_M_CCD_COVER_CODE_1;

	private String filterByCP_ACCNT_PAY_CODE_1;
	
	private String filterByCP_FC_PAID_AMT_1;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	PILT007_COMPOSITE_ACTION compositeAction;
	
	/*Added by saritha on 16-02-2018 for RI Recovery tab should be in enabled status and show details before and after of Claim Settlement.
	 * Now the TAB is getting disabled on Approval.That is the issue,as per thiag &siva sir sugg.*/ 
	
	public PILT011_COMPOSITE_ACTION PILT011compositeAction;

	public PILT011_COMPOSITE_ACTION getPILT011compositeAction() {
		return PILT011compositeAction;
	}

	public void setPILT011compositeAction(
			PILT011_COMPOSITE_ACTION pILT011compositeAction) {
		PILT011compositeAction = pILT011compositeAction;
	}
	
	/*End*/
	
	private PT_IL_CLAIM_PAID_1_HELPER helper;
	private HtmlSelectOneMenu COMP_TYPE;
	private HtmlInputText COMP_MICR_CODE;
	private HtmlInputText COMP_ACC_NO;
	private HtmlOutputLabel COMP_TYPE_LABEL;
	private HtmlOutputLabel COMP_MICR_CODE_LABEL;
	private HtmlOutputLabel COMP_ACC_NO_LABEL;
	private HtmlAjaxCommandButton COMP_EFT_BUT;
	private List<SelectItem> listLOAN_FLEX_04 = new ArrayList<SelectItem>();

	public void setListItemValues(){
		List<SelectItem> listStandard = new ArrayList<SelectItem>();
		/*listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		listStandard.add(new SelectItem("EFT", "EFT"));*/
		
		
		/*NEWLY ADDED BY DHINESH ON 6-6-2017*/ 
		listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		listStandard.add(new SelectItem("EFT", "Paynet"));
		listStandard.add(new SelectItem("CHK", "Cheque"));
		/*End*/
		
		
		/*Commented by Janani on 15.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
		//setListLOAN_FLEX_04(listStandard);
		/*End*/
	}

	/**
	 * @return the filterByCCD_PROD_CODE_1
	 */
	public String getFilterByCCD_PROD_CODE_1() {
		return filterByCCD_PROD_CODE_1;
	}

	/**
	 * @param filterByCCD_PROD_CODE_1
	 *            the filterByCCD_PROD_CODE_1 to set
	 */
	public void setFilterByCCD_PROD_CODE_1(String filterByCCD_PROD_CODE_1) {
		this.filterByCCD_PROD_CODE_1 = filterByCCD_PROD_CODE_1;
	}

	/**
	 * @return the filterByUI_M_CCD_COVER_CODE_1
	 */
	public String getFilterByUI_M_CCD_COVER_CODE_1() {
		return filterByUI_M_CCD_COVER_CODE_1;
	}

	/**
	 * @param filterByUI_M_CCD_COVER_CODE_1
	 *            the filterByUI_M_CCD_COVER_CODE_1 to set
	 */
	public void setFilterByUI_M_CCD_COVER_CODE_1(
			String filterByUI_M_CCD_COVER_CODE_1) {
		this.filterByUI_M_CCD_COVER_CODE_1 = filterByUI_M_CCD_COVER_CODE_1;
	}

	/**
	 * @return the filterByCP_ACCNT_PAY_CODE_1
	 */
	public String getFilterByCP_ACCNT_PAY_CODE_1() {
		return filterByCP_ACCNT_PAY_CODE_1;
	}

	/**
	 * @param filterByCP_ACCNT_PAY_CODE_1
	 *            the filterByCP_ACCNT_PAY_CODE_1 to set
	 */
	public void setFilterByCP_ACCNT_PAY_CODE_1(
			String filterByCP_ACCNT_PAY_CODE_1) {
		this.filterByCP_ACCNT_PAY_CODE_1 = filterByCP_ACCNT_PAY_CODE_1;
	}

	public PT_IL_CLAIM_PAID_1_ACTION() {
		PT_IL_CLAIM_PAID_1_BEAN = new PT_IL_CLAIM_PAID_1();
		instantiateAllComponent();
		PT_IL_CLAIM_PAID_1_BEAN_LIST = new ArrayList<PT_IL_CLAIM_PAID_1>();
		helper = new PT_IL_CLAIM_PAID_1_HELPER();
		prepareDropDowns();
		setListItemValues();
	}
	
	private void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			
			approvalList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID_1",
					"PT_IL_CLAIM_PAID_1.CP_APPR_FLAG_1", "IL_PREM_STAT");
			claimPayToList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID_1",
					"PT_IL_CLAIM_PAID_1.CP_CLAIM_PAID_TO_1", "PAYTO");
			statusList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID_1",
					"PT_IL_CLAIM_PAID_1.CP_CLM_PAID_STATUS_1", "CPSTATUS");
			flagList = ListItemUtil.getDropDownListValue(connection, "PILT007",
					"PT_IL_CLAIM_PAID_1", "PT_IL_CLAIM_PAID_1.CP_SET_FLAG_1",
					"IL_SA_PA");
			
			listSMV_PAYTO = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_SURR_MAT_VALUES", "PT_IL_SURR_MAT_VALUES.SMV_PAYTO", null);
			
			
			/*Added by Janani on 15.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
			
			listLOAN_FLEX_04 = ListItemUtil.getDropDownListValue(connection, "PILT007",
					"PT_IL_CLAIM_PAID", "PT_IL_CLAIM_PAID.CP_TYPE",
			"IL_CP_TYPE");
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public UIData getPT_IL_CLAIM_PAID_1_DATALIST() {
		return PT_IL_CLAIM_PAID_1_DATALIST;
	}

	public void setPT_IL_CLAIM_PAID_1_DATALIST(
			UIData pt_il_claim_paid_1_datalist) {
		PT_IL_CLAIM_PAID_1_DATALIST = pt_il_claim_paid_1_datalist;
	}

	public HtmlOutputLabel getCOMP_CP_PAID_DT_1_LABEL() {
		return COMP_CP_PAID_DT_1_LABEL;
	}

	public HtmlCalendar getCOMP_CP_PAID_DT_1() {
		return COMP_CP_PAID_DT_1;
	}

	public void setCOMP_CP_PAID_DT_1_LABEL(
			HtmlOutputLabel COMP_CP_PAID_DT_1_LABEL) {
		this.COMP_CP_PAID_DT_1_LABEL = COMP_CP_PAID_DT_1_LABEL;
	}

	public void setCOMP_CP_PAID_DT_1(HtmlCalendar COMP_CP_PAID_DT_1) {
		this.COMP_CP_PAID_DT_1 = COMP_CP_PAID_DT_1;
	}

	public HtmlOutputLabel getCOMP_CCD_PROD_CODE_1_LABEL() {
		return COMP_CCD_PROD_CODE_1_LABEL;
	}

	public void setCOMP_CCD_PROD_CODE_1_LABEL(
			HtmlOutputLabel comp_ccd_prod_code_1_label) {
		COMP_CCD_PROD_CODE_1_LABEL = comp_ccd_prod_code_1_label;
	}

	public HtmlInputText getCOMP_CCD_PROD_CODE_1() {
		return COMP_CCD_PROD_CODE_1;
	}

	public void setCOMP_CCD_PROD_CODE_1(HtmlInputText comp_ccd_prod_code_1) {
		COMP_CCD_PROD_CODE_1 = comp_ccd_prod_code_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCD_PROD_CODE_1_DESC_LABEL() {
		return COMP_UI_M_CCD_PROD_CODE_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_CCD_PROD_CODE_1_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ccd_prod_code_1_desc_label) {
		COMP_UI_M_CCD_PROD_CODE_1_DESC_LABEL = comp_ui_m_ccd_prod_code_1_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CCD_PROD_CODE_1_DESC() {
		return COMP_UI_M_CCD_PROD_CODE_1_DESC;
	}

	public void setCOMP_UI_M_CCD_PROD_CODE_1_DESC(
			HtmlInputText comp_ui_m_ccd_prod_code_1_desc) {
		COMP_UI_M_CCD_PROD_CODE_1_DESC = comp_ui_m_ccd_prod_code_1_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCD_COVER_CODE_1_LABEL() {
		return COMP_UI_M_CCD_COVER_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCD_COVER_CODE_1() {
		return COMP_UI_M_CCD_COVER_CODE_1;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_1_LABEL) {
		this.COMP_UI_M_CCD_COVER_CODE_1_LABEL = COMP_UI_M_CCD_COVER_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_1(
			HtmlInputText COMP_UI_M_CCD_COVER_CODE_1) {
		this.COMP_UI_M_CCD_COVER_CODE_1 = COMP_UI_M_CCD_COVER_CODE_1;
	}

	public HtmlOutputLabel getCOMP_CP_ACCNT_PAY_CODE_1_LABEL() {
		return COMP_CP_ACCNT_PAY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CP_ACCNT_PAY_CODE_1() {
		return COMP_CP_ACCNT_PAY_CODE_1;
	}

	public void setCOMP_CP_ACCNT_PAY_CODE_1_LABEL(
			HtmlOutputLabel COMP_CP_ACCNT_PAY_CODE_1_LABEL) {
		this.COMP_CP_ACCNT_PAY_CODE_1_LABEL = COMP_CP_ACCNT_PAY_CODE_1_LABEL;
	}

	public void setCOMP_CP_ACCNT_PAY_CODE_1(
			HtmlInputText COMP_CP_ACCNT_PAY_CODE_1) {
		this.COMP_CP_ACCNT_PAY_CODE_1 = COMP_CP_ACCNT_PAY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_CURR_CODE_1_LABEL() {
		return COMP_UI_M_CP_CURR_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_CURR_CODE_1() {
		return COMP_UI_M_CP_CURR_CODE_1;
	}

	public void setCOMP_UI_M_CP_CURR_CODE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_CURR_CODE_1_LABEL) {
		this.COMP_UI_M_CP_CURR_CODE_1_LABEL = COMP_UI_M_CP_CURR_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_CP_CURR_CODE_1(
			HtmlInputText COMP_UI_M_CP_CURR_CODE_1) {
		this.COMP_UI_M_CP_CURR_CODE_1 = COMP_UI_M_CP_CURR_CODE_1;
	}

	public HtmlOutputLabel getCOMP_CP_FC_PAID_AMT_1_LABEL() {
		return COMP_CP_FC_PAID_AMT_1_LABEL;
	}

	public HtmlInputText getCOMP_CP_FC_PAID_AMT_1() {
		return COMP_CP_FC_PAID_AMT_1;
	}

	public void setCOMP_CP_FC_PAID_AMT_1_LABEL(
			HtmlOutputLabel COMP_CP_FC_PAID_AMT_1_LABEL) {
		this.COMP_CP_FC_PAID_AMT_1_LABEL = COMP_CP_FC_PAID_AMT_1_LABEL;
	}

	public void setCOMP_CP_FC_PAID_AMT_1(HtmlInputText COMP_CP_FC_PAID_AMT_1) {
		this.COMP_CP_FC_PAID_AMT_1 = COMP_CP_FC_PAID_AMT_1;
	}

	public HtmlOutputLabel getCOMP_CP_LC_PAID_AMT_1_LABEL() {
		return COMP_CP_LC_PAID_AMT_1_LABEL;
	}

	public HtmlInputText getCOMP_CP_LC_PAID_AMT_1() {
		return COMP_CP_LC_PAID_AMT_1;
	}

	public void setCOMP_CP_LC_PAID_AMT_1_LABEL(
			HtmlOutputLabel COMP_CP_LC_PAID_AMT_1_LABEL) {
		this.COMP_CP_LC_PAID_AMT_1_LABEL = COMP_CP_LC_PAID_AMT_1_LABEL;
	}

	public void setCOMP_CP_LC_PAID_AMT_1(HtmlInputText COMP_CP_LC_PAID_AMT_1) {
		this.COMP_CP_LC_PAID_AMT_1 = COMP_CP_LC_PAID_AMT_1;
	}

	public HtmlOutputLabel getCOMP_CP_SET_FLAG_1_LABEL() {
		return COMP_CP_SET_FLAG_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_SET_FLAG_1() {
		return COMP_CP_SET_FLAG_1;
	}

	public void setCOMP_CP_SET_FLAG_1_LABEL(
			HtmlOutputLabel COMP_CP_SET_FLAG_1_LABEL) {
		this.COMP_CP_SET_FLAG_1_LABEL = COMP_CP_SET_FLAG_1_LABEL;
	}

	public void setCOMP_CP_SET_FLAG_1(HtmlSelectOneMenu COMP_CP_SET_FLAG_1) {
		this.COMP_CP_SET_FLAG_1 = COMP_CP_SET_FLAG_1;
	}

	public HtmlOutputLabel getCOMP_CP_CLM_PAID_STATUS_1_LABEL() {
		return COMP_CP_CLM_PAID_STATUS_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_CLM_PAID_STATUS_1() {
		return COMP_CP_CLM_PAID_STATUS_1;
	}

	public void setCOMP_CP_CLM_PAID_STATUS_1_LABEL(
			HtmlOutputLabel COMP_CP_CLM_PAID_STATUS_1_LABEL) {
		this.COMP_CP_CLM_PAID_STATUS_1_LABEL = COMP_CP_CLM_PAID_STATUS_1_LABEL;
	}

	public void setCOMP_CP_CLM_PAID_STATUS_1(
			HtmlSelectOneMenu COMP_CP_CLM_PAID_STATUS_1) {
		this.COMP_CP_CLM_PAID_STATUS_1 = COMP_CP_CLM_PAID_STATUS_1;
	}

	public HtmlOutputLabel getCOMP_CP_APPR_FLAG_1_LABEL() {
		return COMP_CP_APPR_FLAG_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_APPR_FLAG_1() {
		return COMP_CP_APPR_FLAG_1;
	}

	public void setCOMP_CP_APPR_FLAG_1_LABEL(
			HtmlOutputLabel COMP_CP_APPR_FLAG_1_LABEL) {
		this.COMP_CP_APPR_FLAG_1_LABEL = COMP_CP_APPR_FLAG_1_LABEL;
	}

	public void setCOMP_CP_APPR_FLAG_1(HtmlSelectOneMenu COMP_CP_APPR_FLAG_1) {
		this.COMP_CP_APPR_FLAG_1 = COMP_CP_APPR_FLAG_1;
	}

	public HtmlOutputLabel getCOMP_CP_CLAIM_REJ_REASON_1_LABEL() {
		return COMP_CP_CLAIM_REJ_REASON_1_LABEL;
	}

	public HtmlInputText getCOMP_CP_CLAIM_REJ_REASON_1() {
		return COMP_CP_CLAIM_REJ_REASON_1;
	}

	public void setCOMP_CP_CLAIM_REJ_REASON_1_LABEL(
			HtmlOutputLabel COMP_CP_CLAIM_REJ_REASON_1_LABEL) {
		this.COMP_CP_CLAIM_REJ_REASON_1_LABEL = COMP_CP_CLAIM_REJ_REASON_1_LABEL;
	}

	public void setCOMP_CP_CLAIM_REJ_REASON_1(
			HtmlInputText COMP_CP_CLAIM_REJ_REASON_1) {
		this.COMP_CP_CLAIM_REJ_REASON_1 = COMP_CP_CLAIM_REJ_REASON_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL() {
		return COMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCD_COVER_CODE_DESC_1() {
		return COMP_UI_M_CCD_COVER_CODE_DESC_1;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL) {
		this.COMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL = COMP_UI_M_CCD_COVER_CODE_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_DESC_1(
			HtmlInputText COMP_UI_M_CCD_COVER_CODE_DESC_1) {
		this.COMP_UI_M_CCD_COVER_CODE_DESC_1 = COMP_UI_M_CCD_COVER_CODE_DESC_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL() {
		return COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1() {
		return COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1;
	}

	public void setCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL) {
		this.COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL = COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1(
			HtmlInputText COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1) {
		this.COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1 = COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1;
	}

	public HtmlOutputLabel getCOMP_CP_SCHD_PYMT_DT_LABEL() {
		return COMP_CP_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CP_SCHD_PYMT_DT() {
		return COMP_CP_SCHD_PYMT_DT;
	}

	public void setCOMP_CP_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_CP_SCHD_PYMT_DT_LABEL) {
		this.COMP_CP_SCHD_PYMT_DT_LABEL = COMP_CP_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_CP_SCHD_PYMT_DT(HtmlCalendar COMP_CP_SCHD_PYMT_DT) {
		this.COMP_CP_SCHD_PYMT_DT = COMP_CP_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_CP_CLAIM_PAID_TO_1_LABEL() {
		return COMP_CP_CLAIM_PAID_TO_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_CLAIM_PAID_TO_1() {
		return COMP_CP_CLAIM_PAID_TO_1;
	}

	public void setCOMP_CP_CLAIM_PAID_TO_1_LABEL(
			HtmlOutputLabel COMP_CP_CLAIM_PAID_TO_1_LABEL) {
		this.COMP_CP_CLAIM_PAID_TO_1_LABEL = COMP_CP_CLAIM_PAID_TO_1_LABEL;
	}

	public void setCOMP_CP_CLAIM_PAID_TO_1(
			HtmlSelectOneMenu COMP_CP_CLAIM_PAID_TO_1) {
		this.COMP_CP_CLAIM_PAID_TO_1 = COMP_CP_CLAIM_PAID_TO_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_TOT_EST_1_LABEL() {
		return COMP_UI_M_CP_FC_TOT_EST_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_TOT_EST_1() {
		return COMP_UI_M_CP_FC_TOT_EST_1;
	}

	public void setCOMP_UI_M_CP_FC_TOT_EST_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_TOT_EST_1_LABEL) {
		this.COMP_UI_M_CP_FC_TOT_EST_1_LABEL = COMP_UI_M_CP_FC_TOT_EST_1_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_TOT_EST_1(
			HtmlInputText COMP_UI_M_CP_FC_TOT_EST_1) {
		this.COMP_UI_M_CP_FC_TOT_EST_1 = COMP_UI_M_CP_FC_TOT_EST_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_TOT_EST_1_LABEL() {
		return COMP_UI_M_CP_LC_TOT_EST_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_TOT_EST_1() {
		return COMP_UI_M_CP_LC_TOT_EST_1;
	}

	public void setCOMP_UI_M_CP_LC_TOT_EST_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_TOT_EST_1_LABEL) {
		this.COMP_UI_M_CP_LC_TOT_EST_1_LABEL = COMP_UI_M_CP_LC_TOT_EST_1_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_TOT_EST_1(
			HtmlInputText COMP_UI_M_CP_LC_TOT_EST_1) {
		this.COMP_UI_M_CP_LC_TOT_EST_1 = COMP_UI_M_CP_LC_TOT_EST_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_TOT_PAID_1_LABEL() {
		return COMP_UI_M_CP_FC_TOT_PAID_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_TOT_PAID_1() {
		return COMP_UI_M_CP_FC_TOT_PAID_1;
	}

	public void setCOMP_UI_M_CP_FC_TOT_PAID_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_TOT_PAID_1_LABEL) {
		this.COMP_UI_M_CP_FC_TOT_PAID_1_LABEL = COMP_UI_M_CP_FC_TOT_PAID_1_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_TOT_PAID_1(
			HtmlInputText COMP_UI_M_CP_FC_TOT_PAID_1) {
		this.COMP_UI_M_CP_FC_TOT_PAID_1 = COMP_UI_M_CP_FC_TOT_PAID_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_TOT_PAID_1_LABEL() {
		return COMP_UI_M_CP_LC_TOT_PAID_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_TOT_PAID_1() {
		return COMP_UI_M_CP_LC_TOT_PAID_1;
	}

	public void setCOMP_UI_M_CP_LC_TOT_PAID_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_TOT_PAID_1_LABEL) {
		this.COMP_UI_M_CP_LC_TOT_PAID_1_LABEL = COMP_UI_M_CP_LC_TOT_PAID_1_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_TOT_PAID_1(
			HtmlInputText COMP_UI_M_CP_LC_TOT_PAID_1) {
		this.COMP_UI_M_CP_LC_TOT_PAID_1 = COMP_UI_M_CP_LC_TOT_PAID_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_BALANCE_1_LABEL() {
		return COMP_UI_M_CP_FC_BALANCE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_BALANCE_1() {
		return COMP_UI_M_CP_FC_BALANCE_1;
	}

	public void setCOMP_UI_M_CP_FC_BALANCE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_BALANCE_1_LABEL) {
		this.COMP_UI_M_CP_FC_BALANCE_1_LABEL = COMP_UI_M_CP_FC_BALANCE_1_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_BALANCE_1(
			HtmlInputText COMP_UI_M_CP_FC_BALANCE_1) {
		this.COMP_UI_M_CP_FC_BALANCE_1 = COMP_UI_M_CP_FC_BALANCE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_BALANCE_1_LABEL() {
		return COMP_UI_M_CP_LC_BALANCE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_BALANCE_1() {
		return COMP_UI_M_CP_LC_BALANCE_1;
	}

	public void setCOMP_UI_M_CP_LC_BALANCE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_BALANCE_1_LABEL) {
		this.COMP_UI_M_CP_LC_BALANCE_1_LABEL = COMP_UI_M_CP_LC_BALANCE_1_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_BALANCE_1(
			HtmlInputText COMP_UI_M_CP_LC_BALANCE_1) {
		this.COMP_UI_M_CP_LC_BALANCE_1 = COMP_UI_M_CP_LC_BALANCE_1;
	}

	public PT_IL_CLAIM_PAID_1 getPT_IL_CLAIM_PAID_1_BEAN() {
		return PT_IL_CLAIM_PAID_1_BEAN;
	}

	public void setPT_IL_CLAIM_PAID_1_BEAN(
			PT_IL_CLAIM_PAID_1 PT_IL_CLAIM_PAID_1_BEAN) {
		this.PT_IL_CLAIM_PAID_1_BEAN = PT_IL_CLAIM_PAID_1_BEAN;
	}

	public List<PT_IL_CLAIM_PAID_1> getPT_IL_CLAIM_PAID_1_BEAN_LIST() {
		return PT_IL_CLAIM_PAID_1_BEAN_LIST;
	}

	public void setPT_IL_CLAIM_PAID_1_BEAN_LIST(
			List<PT_IL_CLAIM_PAID_1> pt_il_claim_paid_1_bean_list) {
		PT_IL_CLAIM_PAID_1_BEAN_LIST = pt_il_claim_paid_1_bean_list;
	}

	public List<SelectItem> getApprovalList() {
		return approvalList;
	}

	public void setApprovalList(List<SelectItem> approvalList) {
		this.approvalList = approvalList;
	}

	public List<SelectItem> getClaimPayToList() {
		return claimPayToList;
	}

	public void setClaimPayToList(List<SelectItem> claimPayToList) {
		this.claimPayToList = claimPayToList;
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public List<SelectItem> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<SelectItem> flagList) {
		this.flagList = flagList;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenCreateRecord(compositeAction);
				helper.executeQuery(compositeAction);
				/*COMP_UI_M_CP_FC_TOT_EST_1.resetValue();
				COMP_UI_M_CP_LC_TOT_EST_1.resetValue();
				COMP_UI_M_CP_FC_TOT_PAID_1.resetValue();
				COMP_UI_M_CP_LC_TOT_PAID_1.resetValue();*/
				helper.preBlock();
				helper.whenNewBlockInstance(compositeAction);
				
				/*Commentted by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
				
				/*if(PT_IL_CLAIM_PAID_1_BEAN.getROWID() != null){
					PT_IL_CLAIM_PAID_1 paidbean = (PT_IL_CLAIM_PAID_1)CommonUtils.getGlobalObject("paidbean");
					COMP_UI_M_CP_FC_TOT_EST_1.setValue(paidbean.getUI_M_CP_FC_TOT_EST_1());
					COMP_UI_M_CP_LC_TOT_EST_1.setValue(paidbean.getUI_M_CP_LC_TOT_EST_1());
					COMP_UI_M_CP_FC_TOT_PAID_1.setValue(paidbean.getUI_M_CP_FC_TOT_PAID_1());
					COMP_UI_M_CP_LC_TOT_PAID_1.setValue(paidbean.getUI_M_CP_LC_TOT_PAID_1());
					COMP_UI_M_CP_FC_BALANCE_1.setValue(paidbean.getUI_M_CP_FC_BALANCE_1());
					COMP_UI_M_CP_LC_BALANCE_1.setValue(paidbean.getUI_M_CP_LC_BALANCE_1());
				}*/
				setBlockFlag(false);
				
				//setFormFlag(false);
			}
			
			if(PT_IL_CLAIM_PAID_1_BEAN.getROWID() != null){
				PT_IL_CLAIM_PAID_1 paidbean = (PT_IL_CLAIM_PAID_1)CommonUtils.getGlobalObject("paidbean");
				COMP_UI_M_CP_FC_TOT_EST_1.setValue(paidbean.getUI_M_CP_FC_TOT_EST_1());
				COMP_UI_M_CP_LC_TOT_EST_1.setValue(paidbean.getUI_M_CP_LC_TOT_EST_1());
				COMP_UI_M_CP_FC_TOT_PAID_1.setValue(paidbean.getUI_M_CP_FC_TOT_PAID_1());
				COMP_UI_M_CP_LC_TOT_PAID_1.setValue(paidbean.getUI_M_CP_LC_TOT_PAID_1());
				COMP_UI_M_CP_FC_BALANCE_1.setValue(paidbean.getUI_M_CP_FC_BALANCE_1());
				COMP_UI_M_CP_LC_BALANCE_1.setValue(paidbean.getUI_M_CP_LC_BALANCE_1());
			}
			
			
			/*Added by Saritha on 10.01.2018 for claim issue */
			
			System.out.println("getCP_CLAIM_PAID_TO in onload        "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().getPT_IL_CLAIM_PAID_1_BEAN().getCP_CLAIM_PAID_TO_1());
			
			if(compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().getPT_IL_CLAIM_PAID_1_BEAN().getCP_CLAIM_PAID_TO_1().equalsIgnoreCase("B"))
			{
				compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
			}
			else
			{
				compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(true);
			}	
			/*End of ZBILQC-1732254*/
			
			/*End*/
			
			
			
			/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/

			System.out.println("getCP_PYMT_MTD                        "+PT_IL_CLAIM_PAID_1_BEAN.getCP_FLEX_04());
			
			   if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_1_BEAN.getCP_FLEX_04(),""),"1","3"))	
			   {					

				   COMP_UI_M_BANK_CODE.setRequired(true);
				   COMP_UI_M_DIVISION.setRequired(true);
				   COMP_ACC_NO.setRequired(true);
				   COMP_UI_M_ACNT_NAME.setRequired(true);

			   }
			   else
			   {
				   COMP_UI_M_BANK_CODE.setRequired(false);
				   COMP_UI_M_DIVISION.setRequired(false);
				   COMP_ACC_NO.setRequired(false);
				   COMP_UI_M_ACNT_NAME.setRequired(false);
			   }
			   
			   
			   if(PT_IL_CLAIM_PAID_1_BEAN.getCP_FLEX_04().equalsIgnoreCase("2"))
			   {
				   COMP_CP_PAYEE_NAME.resetValue();
			   }
			   else
			   {
				   COMP_CP_PAYEE_NAME.resetValue();
			   }
			   /*End*/
			
			
			
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public void validateCP_APPR_FLAG_1() {
		try {
			helper.cpApprFlag1WhenListChanged(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCP_ACCNT_PAY_CODE_1(FacesContext context, UIComponent component,
			Object value)throws ValidatorException {
		try {
			helper.cpAccntPayCodeWhenValidateItem(compositeAction);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validateCP_CLM_PAID_STATUS_1() {
		try {
			helper.cpClmPaidStatus1WhenListChanged(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCP_FC_PAID_AMT_1(FacesContext context,
				UIComponent component,Object value)throws ValidatorException {
		try {
			helper.cpFcPaidAmt1WhenValidateItem(compositeAction);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validateCP_PAID_DT_1(FacesContext context, UIComponent component,
			Object value)throws ValidatorException {
		try {
			helper.cpPaidDateWhenValidateItem(compositeAction);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	

	List<PT_IL_CLAIM_PAID_1> accntPayCodeList = null;

	public List<PT_IL_CLAIM_PAID_1> cpAccntPayCodeSuggestionValue(Object value) {
		try {
			accntPayCodeList = helper.cpAccntPayCode((String) value,
					compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accntPayCodeList;
	}

	public String beneficiaryDetails() {
		String outCome = null;
		try {
			outCome = helper.claimPaidBeneficiary(compositeAction);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
		return outCome;
	}

	

	
	/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
	
	/*public void getDetails() {
		try {
			
			if (PT_IL_CLAIM_PAID_1_BEAN_LIST.size() != 0) {
				PT_IL_CLAIM_PAID_1_BEAN = (PT_IL_CLAIM_PAID_1) PT_IL_CLAIM_PAID_1_DATALIST
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_CLAIM_PAID_1_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	}*/
	
	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			
			resetSelectedRow();
			if (PT_IL_CLAIM_PAID_1_BEAN_LIST.size() != 0) {
  				PT_IL_CLAIM_PAID_1_BEAN = (PT_IL_CLAIM_PAID_1) PT_IL_CLAIM_PAID_1_DATALIST
						.getRowData();
			}
			PT_IL_CLAIM_PAID_1_BEAN.setRowSelected(true);
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	}
	
	/*End*/

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_PAID_1> iterator = PT_IL_CLAIM_PAID_1_BEAN_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_CP_PAID_DT_1.resetValue();
		COMP_CCD_PROD_CODE_1.resetValue();
		COMP_UI_M_CCD_PROD_CODE_1_DESC.resetValue();
		COMP_UI_M_CCD_COVER_CODE_1.resetValue();
		COMP_UI_M_CCD_COVER_CODE_DESC_1.resetValue();
		COMP_CP_ACCNT_PAY_CODE_1.resetValue();
		COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1.resetValue();
		COMP_UI_M_CP_CURR_CODE_1.resetValue();
		COMP_CP_FC_PAID_AMT_1.resetValue();
		COMP_CP_LC_PAID_AMT_1.resetValue();
		COMP_CP_SET_FLAG_1.resetValue();
		COMP_CP_CLM_PAID_STATUS_1.resetValue();
		COMP_CP_APPR_FLAG_1.resetValue();
		COMP_CP_CLAIM_REJ_REASON_1.resetValue();
		COMP_CP_SCHD_PYMT_DT.resetValue();
		COMP_CP_CLAIM_PAID_TO_1.resetValue();
		COMP_UI_M_CP_FC_TOT_EST_1.resetValue();
		COMP_UI_M_CP_LC_TOT_EST_1.resetValue();
		COMP_UI_M_CP_FC_TOT_PAID_1.resetValue();
		COMP_UI_M_CP_LC_TOT_PAID_1.resetValue();
		/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
		COMP_UI_M_CP_FC_BALANCE_1.resetValue();
		COMP_UI_M_CP_LC_BALANCE_1.resetValue();
		/*End*/
		
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		COMP_UI_M_BANK_NAME.resetValue();
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		COMP_ACC_NO.resetValue();
		/*end*/
	}

	
	public void disableAllComponent(boolean disabled) {
	COMP_CP_PAID_DT_1.setDisabled(disabled);
	COMP_CCD_PROD_CODE_1.setDisabled(disabled);
	COMP_UI_M_CCD_PROD_CODE_1_DESC.setDisabled(disabled);
	COMP_UI_M_CCD_COVER_CODE_1.setDisabled(disabled);
	COMP_UI_M_CCD_COVER_CODE_DESC_1.setDisabled(disabled);
	COMP_CP_ACCNT_PAY_CODE_1.setDisabled(disabled);
	COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1.setDisabled(disabled);
	COMP_UI_M_CP_CURR_CODE_1.setDisabled(disabled);
	COMP_CP_FC_PAID_AMT_1.setDisabled(disabled);
	COMP_CP_LC_PAID_AMT_1.setDisabled(disabled);
	COMP_CP_SET_FLAG_1.setDisabled(disabled);
	COMP_CP_CLM_PAID_STATUS_1.setDisabled(disabled);
	COMP_CP_APPR_FLAG_1.setDisabled(disabled);
	COMP_CP_CLAIM_REJ_REASON_1.setDisabled(disabled);
	COMP_CP_SCHD_PYMT_DT.setDisabled(disabled);
	COMP_CP_CLAIM_PAID_TO_1.setDisabled(disabled);
	COMP_UI_M_CP_FC_TOT_EST_1.setDisabled(disabled);
	COMP_UI_M_CP_LC_TOT_EST_1.setDisabled(disabled);
	COMP_UI_M_CP_FC_TOT_PAID_1.setDisabled(disabled);
	COMP_UI_M_CP_LC_TOT_PAID_1.setDisabled(disabled);
	/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
	COMP_UI_M_CP_FC_BALANCE_1.setDisabled(disabled);
	COMP_UI_M_CP_LC_BALANCE_1.setDisabled(disabled);
	
	/*Modified by Janani on  21.08.2017 for ZBILQC-1732254 */
	//COMP_TYPE.setDisabled(disabled);
	//COMP_CP_TYPE.setDisabled(disabled);
	/*End of  ZBILQC-1732254 */
	
	
	/*End*/
	
	/*added by raja on 10-06-2017 for ZBILQC-1728216 */
	COMP_UI_M_BANK_NAME.setDisabled(disabled);
	COMP_UI_M_BANK_CODE.setDisabled(disabled);
	COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
	COMP_CP_PAID_TO.setDisabled(disabled);
	/*end*/
	
}	
	
	public void instantiateAllComponent(){
		COMP_CP_PAID_DT_1= new HtmlCalendar();
		COMP_CCD_PROD_CODE_1=new HtmlInputText();
		COMP_UI_M_CCD_PROD_CODE_1_DESC=new HtmlInputText();
		COMP_UI_M_CCD_COVER_CODE_1=new HtmlInputText();
		COMP_UI_M_CCD_COVER_CODE_DESC_1=new HtmlInputText();
		COMP_CP_ACCNT_PAY_CODE_1=new HtmlInputText();
		COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_1=new HtmlInputText();
		COMP_UI_M_CP_CURR_CODE_1=new HtmlInputText();
		COMP_CP_FC_PAID_AMT_1=new HtmlInputText();
		COMP_CP_LC_PAID_AMT_1=new HtmlInputText();
		COMP_CP_SET_FLAG_1= new HtmlSelectOneMenu();
		COMP_CP_CLM_PAID_STATUS_1= new HtmlSelectOneMenu();
		COMP_CP_APPR_FLAG_1= new HtmlSelectOneMenu();
		COMP_CP_CLAIM_REJ_REASON_1=new HtmlInputText();
		COMP_CP_SCHD_PYMT_DT= new HtmlCalendar();
		COMP_CP_CLAIM_PAID_TO_1= new HtmlSelectOneMenu();
		COMP_UI_M_CP_FC_TOT_EST_1=new HtmlInputText();
		COMP_UI_M_CP_LC_TOT_EST_1=new HtmlInputText();
		COMP_UI_M_CP_FC_TOT_PAID_1=new HtmlInputText();
		COMP_UI_M_CP_LC_TOT_PAID_1=new HtmlInputText();
		
		/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
		COMP_UI_M_CP_FC_BALANCE_1=new HtmlInputText();
		COMP_UI_M_CP_LC_BALANCE_1=new HtmlInputText();
		/*End*/
		
		COMP_TYPE = new HtmlSelectOneMenu();
		COMP_MICR_CODE = new HtmlInputText();
		COMP_ACC_NO = new HtmlInputText();
		
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		COMP_UI_M_BANK_NAME=new HtmlInputText();
		COMP_UI_M_BANK_CODE=new HtmlInputText();
		COMP_UI_M_BRANCH_CODE=new HtmlInputText();
		COMP_CP_PAID_TO=new HtmlSelectOneMenu();
		/*end*/
		
	}
	
	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
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
	 * @param ui_m_but_delete
	 *            the uI_M_BUT_DELETE to set
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
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getFilterByCP_FC_PAID_AMT_1() {
		return filterByCP_FC_PAID_AMT_1;
	}

	public void setFilterByCP_FC_PAID_AMT_1(String filterByCP_FC_PAID_AMT_1) {
		this.filterByCP_FC_PAID_AMT_1 = filterByCP_FC_PAID_AMT_1;
	}

	public HtmlSelectOneMenu getCOMP_TYPE() {
		return COMP_TYPE;
	}

	public void setCOMP_TYPE(HtmlSelectOneMenu comp_type) {
		COMP_TYPE = comp_type;
	}

	public HtmlInputText getCOMP_MICR_CODE() {
		return COMP_MICR_CODE;
	}

	public void setCOMP_MICR_CODE(HtmlInputText comp_micr_code) {
		COMP_MICR_CODE = comp_micr_code;
	}

	public HtmlInputText getCOMP_ACC_NO() {
		return COMP_ACC_NO;
	}

	public void setCOMP_ACC_NO(HtmlInputText comp_acc_no) {
		COMP_ACC_NO = comp_acc_no;
	}

	public HtmlOutputLabel getCOMP_TYPE_LABEL() {
		return COMP_TYPE_LABEL;
	}

	public void setCOMP_TYPE_LABEL(HtmlOutputLabel comp_type_label) {
		COMP_TYPE_LABEL = comp_type_label;
	}

	public HtmlOutputLabel getCOMP_MICR_CODE_LABEL() {
		return COMP_MICR_CODE_LABEL;
	}

	public void setCOMP_MICR_CODE_LABEL(HtmlOutputLabel comp_micr_code_label) {
		COMP_MICR_CODE_LABEL = comp_micr_code_label;
	}

	public HtmlOutputLabel getCOMP_ACC_NO_LABEL() {
		return COMP_ACC_NO_LABEL;
	}

	public void setCOMP_ACC_NO_LABEL(HtmlOutputLabel comp_acc_no_label) {
		COMP_ACC_NO_LABEL = comp_acc_no_label;
	}

	public HtmlAjaxCommandButton getCOMP_EFT_BUT() {
		return COMP_EFT_BUT;
	}

	public void setCOMP_EFT_BUT(HtmlAjaxCommandButton comp_eft_but) {
		COMP_EFT_BUT = comp_eft_but;
	}

	public List<SelectItem> getListLOAN_FLEX_04() {
		return listLOAN_FLEX_04;
	}

	public void setListLOAN_FLEX_04(List<SelectItem> listLOAN_FLEX_04) {
		this.listLOAN_FLEX_04 = listLOAN_FLEX_04;
	}
	
	
	/*added by raja on 10-06-2017 for ZBILQC-1728216 */
	private HtmlInputText COMP_UI_M_BANK_NAME;

	private HtmlInputText COMP_UI_M_BANK_CODE;

	private HtmlInputText COMP_UI_M_BRANCH_CODE;
	
	private HtmlSelectOneMenu COMP_CP_PAID_TO;


	public HtmlInputText getCOMP_UI_M_BANK_NAME() {
		return COMP_UI_M_BANK_NAME;
	}

	public void setCOMP_UI_M_BANK_NAME(HtmlInputText cOMP_UI_M_BANK_NAME) {
		COMP_UI_M_BANK_NAME = cOMP_UI_M_BANK_NAME;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
		return COMP_UI_M_BANK_CODE;
	}

	public void setCOMP_UI_M_BANK_CODE(HtmlInputText cOMP_UI_M_BANK_CODE) {
		COMP_UI_M_BANK_CODE = cOMP_UI_M_BANK_CODE;
	}

	public HtmlInputText getCOMP_UI_M_BRANCH_CODE() {
		return COMP_UI_M_BRANCH_CODE;
	}

	public void setCOMP_UI_M_BRANCH_CODE(HtmlInputText cOMP_UI_M_BRANCH_CODE) {
		COMP_UI_M_BRANCH_CODE = cOMP_UI_M_BRANCH_CODE;
	}

	public HtmlSelectOneMenu getCOMP_CP_PAID_TO() {
		return COMP_CP_PAID_TO;
	}

	public void setCOMP_CP_PAID_TO(HtmlSelectOneMenu cOMP_CP_PAID_TO) {
		COMP_CP_PAID_TO = cOMP_CP_PAID_TO;
	}

	private List<SelectItem> listSMV_PAYTO;


	public List<SelectItem> getListSMV_PAYTO() {
		return listSMV_PAYTO;
	}

	public void setListSMV_PAYTO(List<SelectItem> listSMV_PAYTO) {
		this.listSMV_PAYTO = listSMV_PAYTO;
	}
	
	/*end*/

	/*Added by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
	
	private HtmlOutputLabel COMP_CP_PAYEE_NAME_LABEL;

	private HtmlInputText COMP_CP_PAYEE_NAME;
	
	private HtmlOutputLabel COMP_UI_M_DIVISION_LABEL;

	private HtmlInputText COMP_UI_M_DIVISION;

	private HtmlOutputLabel COMP_UI_M_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACNT_NAME;
	
	private HtmlOutputLabel COMP_UI_M_CUST_MOBILE_LABEL;

	private HtmlInputText COMP_UI_M_CUST_MOBILE;
	
	private HtmlOutputLabel COMP_UI_M_BILLER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_BILLER_CODE;

	private HtmlInputText COMP_UI_M_DIVISION_DESC;
	
	
	
	public HtmlInputText getCOMP_UI_M_DIVISION_DESC() {
		return COMP_UI_M_DIVISION_DESC;
	}

	public void setCOMP_UI_M_DIVISION_DESC(HtmlInputText cOMP_UI_M_DIVISION_DESC) {
		COMP_UI_M_DIVISION_DESC = cOMP_UI_M_DIVISION_DESC;
	}

	public HtmlOutputLabel getCOMP_CP_PAYEE_NAME_LABEL() {
		return COMP_CP_PAYEE_NAME_LABEL;
	}

	public void setCOMP_CP_PAYEE_NAME_LABEL(HtmlOutputLabel cOMP_CP_PAYEE_NAME_LABEL) {
		COMP_CP_PAYEE_NAME_LABEL = cOMP_CP_PAYEE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CP_PAYEE_NAME() {
		return COMP_CP_PAYEE_NAME;
	}

	public void setCOMP_CP_PAYEE_NAME(HtmlInputText cOMP_CP_PAYEE_NAME) {
		COMP_CP_PAYEE_NAME = cOMP_CP_PAYEE_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVISION_LABEL() {
		return COMP_UI_M_DIVISION_LABEL;
	}

	public void setCOMP_UI_M_DIVISION_LABEL(HtmlOutputLabel cOMP_UI_M_DIVISION_LABEL) {
		COMP_UI_M_DIVISION_LABEL = cOMP_UI_M_DIVISION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVISION() {
		return COMP_UI_M_DIVISION;
	}

	public void setCOMP_UI_M_DIVISION(HtmlInputText cOMP_UI_M_DIVISION) {
		COMP_UI_M_DIVISION = cOMP_UI_M_DIVISION;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACNT_NAME_LABEL() {
		return COMP_UI_M_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACNT_NAME_LABEL(
			HtmlOutputLabel cOMP_UI_M_ACNT_NAME_LABEL) {
		COMP_UI_M_ACNT_NAME_LABEL = cOMP_UI_M_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACNT_NAME() {
		return COMP_UI_M_ACNT_NAME;
	}

	public void setCOMP_UI_M_ACNT_NAME(HtmlInputText cOMP_UI_M_ACNT_NAME) {
		COMP_UI_M_ACNT_NAME = cOMP_UI_M_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_MOBILE_LABEL() {
		return COMP_UI_M_CUST_MOBILE_LABEL;
	}

	public void setCOMP_UI_M_CUST_MOBILE_LABEL(
			HtmlOutputLabel cOMP_UI_M_CUST_MOBILE_LABEL) {
		COMP_UI_M_CUST_MOBILE_LABEL = cOMP_UI_M_CUST_MOBILE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_MOBILE() {
		return COMP_UI_M_CUST_MOBILE;
	}

	public void setCOMP_UI_M_CUST_MOBILE(HtmlInputText cOMP_UI_M_CUST_MOBILE) {
		COMP_UI_M_CUST_MOBILE = cOMP_UI_M_CUST_MOBILE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BILLER_CODE_LABEL() {
		return COMP_UI_M_BILLER_CODE_LABEL;
	}

	public void setCOMP_UI_M_BILLER_CODE_LABEL(
			HtmlOutputLabel cOMP_UI_M_BILLER_CODE_LABEL) {
		COMP_UI_M_BILLER_CODE_LABEL = cOMP_UI_M_BILLER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BILLER_CODE() {
		return COMP_UI_M_BILLER_CODE;
	}

	public void setCOMP_UI_M_BILLER_CODE(HtmlInputText cOMP_UI_M_BILLER_CODE) {
		COMP_UI_M_BILLER_CODE = cOMP_UI_M_BILLER_CODE;
	}
	
	
	
	
	/*End*/
	
	
	
}

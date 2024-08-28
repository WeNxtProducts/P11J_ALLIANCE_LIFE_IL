package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT006_APAC.DUMMY;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_ACTION;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_PAID_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CP_CLM_PAID_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_CP_CLM_PAID_STATUS;

	private HtmlOutputLabel COMP_CP_APPR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CP_APPR_FLAG;

	private HtmlOutputLabel COMP_CCD_PROD_CODE_LABEL;

	private HtmlInputText COMP_CCD_PROD_CODE;

	private HtmlOutputLabel COMP_CCD_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CCD_COVER_CODE;

	private HtmlOutputLabel COMP_CP_PAID_DT_LABEL;

	private HtmlCalendar COMP_CP_PAID_DT;

	private HtmlOutputLabel COMP_CP_ACCNT_PAY_CODE_LABEL;

	private HtmlInputText COMP_CP_ACCNT_PAY_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_CURR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CP_CURR_CODE;

	private HtmlOutputLabel COMP_CP_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_CP_FC_PAID_AMT;

	private HtmlOutputLabel COMP_CP_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_CP_LC_PAID_AMT;

	private HtmlOutputLabel COMP_CP_SET_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CP_SET_FLAG;

	private HtmlOutputLabel COMP_CP_CLAIM_REJ_REASON_LABEL;

	private HtmlInputText COMP_CP_CLAIM_REJ_REASON;

	private HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CCD_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CP_ACCNT_PAY_CODE_DESC;

	private HtmlOutputLabel COMP_CP_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_CP_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_CP_CLAIM_PAID_TO_LABEL;

	private HtmlSelectOneMenu COMP_CP_CLAIM_PAID_TO;

	private HtmlOutputLabel COMP_UI_M_CP_FC_TOT_EST_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_TOT_EST;

	private HtmlOutputLabel COMP_UI_M_CP_LC_TOT_EST_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_TOT_EST;

	private HtmlOutputLabel COMP_UI_M_CP_FC_TOT_PAID_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_TOT_PAID;

	private HtmlOutputLabel COMP_UI_M_CP_LC_TOT_PAID_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_TOT_PAID;

	private HtmlOutputLabel COMP_UI_M_CP_FC_BALANCE_LABEL;

	private HtmlInputText COMP_UI_M_CP_FC_BALANCE;

	private HtmlOutputLabel COMP_UI_M_CP_LC_BALANCE_LABEL;

	private HtmlInputText COMP_UI_M_CP_LC_BALANCE;

	private PT_IL_CLAIM_PAID PT_IL_CLAIM_PAID_BEAN;

	private UIData COMP_CLAIM_PAID_DATATABLE;

	private List<PT_IL_CLAIM_PAID> PT_IL_CLAIM_PAID_BEAN_LIST;

	private List<SelectItem> approvedList;

	private List<SelectItem> claimPayToList;

	private List<SelectItem> statusList;

	private List<SelectItem> flagList;
	
	private List<SelectItem> CP_TYPE_list;
	
	private HtmlOutputLabel COMP_CP_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_CP_TYPE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlCommandButton UI_M_BUT_POST;

	private String filterByCCD_PROD_CODE;

	private String filterByUI_M_CCD_COVER_CODE;

	private String filterByCP_ACCNT_PAY_CODE;

	private String filterByCP_PROD_CODE;

	PILT007_COMPOSITE_ACTION compositeAction;

	PT_IL_CLAIM_PAID_HELPER helper;

	List<PT_IL_CLAIM_PAID> cpAccntPayCodeList = null;
	
	P9ILPK_CLAIM p9ilpk_claim = new P9ILPK_CLAIM();
	
	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;
	
	
	private HtmlSelectOneMenu COMP_TYPE;
	private HtmlInputText COMP_MICR_CODE;
	private HtmlInputText COMP_ACC_NO;
	private HtmlOutputLabel COMP_TYPE_LABEL;
	private HtmlOutputLabel COMP_MICR_CODE_LABEL;
	private HtmlOutputLabel COMP_ACC_NO_LABEL;
	private HtmlAjaxCommandButton COMP_EFT_BUT;
	private List<SelectItem> listLOAN_FLEX_04 = new ArrayList<SelectItem>();
	

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

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public PILT007_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT007_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the filterByCP_PROD_CODE
	 */
	public String getFilterByCP_PROD_CODE() {
		return filterByCP_PROD_CODE;
	}

	/**
	 * @param filterByCP_PROD_CODE
	 *            the filterByCP_PROD_CODE to set
	 */
	public void setFilterByCP_PROD_CODE(String filterByCP_PROD_CODE) {
		this.filterByCP_PROD_CODE = filterByCP_PROD_CODE;
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
	 * @return the filterByCCD_PROD_CODE
	 */
	public String getFilterByCCD_PROD_CODE() {
		return filterByCCD_PROD_CODE;
	}

	/**
	 * @param filterByCCD_PROD_CODE
	 *            the filterByCCD_PROD_CODE to set
	 */
	public void setFilterByCCD_PROD_CODE(String filterByCCD_PROD_CODE) {
		this.filterByCCD_PROD_CODE = filterByCCD_PROD_CODE;
	}

	/**
	 * @return the filterByUI_M_CCD_COVER_CODE
	 */
	public String getFilterByUI_M_CCD_COVER_CODE() {
		return filterByUI_M_CCD_COVER_CODE;
	}

	/**
	 * @param filterByUI_M_CCD_COVER_CODE
	 *            the filterByUI_M_CCD_COVER_CODE to set
	 */
	public void setFilterByUI_M_CCD_COVER_CODE(
			String filterByUI_M_CCD_COVER_CODE) {
		this.filterByUI_M_CCD_COVER_CODE = filterByUI_M_CCD_COVER_CODE;
	}

	/**
	 * @return the filterByCP_ACCNT_PAY_CODE
	 */
	public String getFilterByCP_ACCNT_PAY_CODE() {
		return filterByCP_ACCNT_PAY_CODE;
	}

	/**
	 * @param filterByCP_ACCNT_PAY_CODE
	 *            the filterByCP_ACCNT_PAY_CODE to set
	 */
	public void setFilterByCP_ACCNT_PAY_CODE(String filterByCP_ACCNT_PAY_CODE) {
		this.filterByCP_ACCNT_PAY_CODE = filterByCP_ACCNT_PAY_CODE;
	}

	public PT_IL_CLAIM_PAID_ACTION() {
		PT_IL_CLAIM_PAID_BEAN = new PT_IL_CLAIM_PAID();
		instantiateAllComponent();
		PT_IL_CLAIM_PAID_BEAN_LIST = new ArrayList<PT_IL_CLAIM_PAID>();
		helper = new PT_IL_CLAIM_PAID_HELPER();
		prepareDropDowns();
		setListItemValues();
	}
	public void setListItemValues(){
		List<SelectItem> listStandard = new ArrayList<SelectItem>();
		listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		listStandard.add(new SelectItem("CHK", "Cheque"));
		listStandard.add(new SelectItem("EFT", "Paynet"));
		/*end*/
		setListLOAN_FLEX_04(listStandard);

	}
	private void prepareDropDowns() {

		try {
			Connection connection = CommonUtils.getConnection();
			approvedList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID",
					"PT_IL_CLAIM_PAID.CP_APPR_FLAG", "IL_PREM_STAT");
			claimPayToList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID",
					"PT_IL_CLAIM_PAID.CP_CLAIM_PAID_TO", "PAYTO");
			statusList = ListItemUtil.getDropDownListValue(connection,
					"PILT007", "PT_IL_CLAIM_PAID",
					"PT_IL_CLAIM_PAID.CP_CLM_PAID_STATUS", "CPSTATUS");
			flagList = ListItemUtil.getDropDownListValue(connection, "PILT007",
					"PT_IL_CLAIM_PAID", "PT_IL_CLAIM_PAID.CP_SET_FLAG",
					"IL_SA_PA");
			
			CP_TYPE_list = ListItemUtil.getDropDownListValue(connection, "PILT007",
					"PT_IL_CLAIM_PAID", "PT_IL_CLAIM_PAID.CP_TYPE",
			"IL_CP_TYPE");
			
			
			/*added by raja on 10-06-2017 for ZBILQC-1728216 */
			listSMV_PAYTO = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_SURR_MAT_VALUES", "PT_IL_SURR_MAT_VALUES.SMV_PAYTO", null);
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public HtmlOutputLabel getCOMP_CP_CLM_PAID_STATUS_LABEL() {
		return COMP_CP_CLM_PAID_STATUS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_CLM_PAID_STATUS() {
		return COMP_CP_CLM_PAID_STATUS;
	}

	public void setCOMP_CP_CLM_PAID_STATUS_LABEL(
			HtmlOutputLabel COMP_CP_CLM_PAID_STATUS_LABEL) {
		this.COMP_CP_CLM_PAID_STATUS_LABEL = COMP_CP_CLM_PAID_STATUS_LABEL;
	}

	public void setCOMP_CP_CLM_PAID_STATUS(
			HtmlSelectOneMenu COMP_CP_CLM_PAID_STATUS) {
		this.COMP_CP_CLM_PAID_STATUS = COMP_CP_CLM_PAID_STATUS;
	}

	public HtmlOutputLabel getCOMP_CP_APPR_FLAG_LABEL() {
		return COMP_CP_APPR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_APPR_FLAG() {
		return COMP_CP_APPR_FLAG;
	}

	public void setCOMP_CP_APPR_FLAG_LABEL(
			HtmlOutputLabel COMP_CP_APPR_FLAG_LABEL) {
		this.COMP_CP_APPR_FLAG_LABEL = COMP_CP_APPR_FLAG_LABEL;
	}

	public void setCOMP_CP_APPR_FLAG(HtmlSelectOneMenu COMP_CP_APPR_FLAG) {
		this.COMP_CP_APPR_FLAG = COMP_CP_APPR_FLAG;
	}

	public HtmlOutputLabel getCOMP_CCD_PROD_CODE_LABEL() {
		return COMP_CCD_PROD_CODE_LABEL;
	}

	public void setCOMP_CCD_PROD_CODE_LABEL(
			HtmlOutputLabel comp_ccd_prod_code_label) {
		COMP_CCD_PROD_CODE_LABEL = comp_ccd_prod_code_label;
	}

	public HtmlInputText getCOMP_CCD_PROD_CODE() {
		return COMP_CCD_PROD_CODE;
	}

	public void setCOMP_CCD_PROD_CODE(HtmlInputText comp_ccd_prod_code) {
		COMP_CCD_PROD_CODE = comp_ccd_prod_code;
	}

	public HtmlOutputLabel getCOMP_CCD_PROD_CODE_DESC_LABEL() {
		return COMP_CCD_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_CCD_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ccd_prod_code_desc_label) {
		COMP_CCD_PROD_CODE_DESC_LABEL = comp_ccd_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CCD_PROD_CODE_DESC() {
		return COMP_UI_M_CCD_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_CCD_PROD_CODE_DESC(
			HtmlInputText comp_ccd_prod_code_desc) {
		COMP_UI_M_CCD_PROD_CODE_DESC = comp_ccd_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCD_COVER_CODE_LABEL() {
		return COMP_UI_M_CCD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCD_COVER_CODE() {
		return COMP_UI_M_CCD_COVER_CODE;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_LABEL) {
		this.COMP_UI_M_CCD_COVER_CODE_LABEL = COMP_UI_M_CCD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE(
			HtmlInputText COMP_UI_M_CCD_COVER_CODE) {
		this.COMP_UI_M_CCD_COVER_CODE = COMP_UI_M_CCD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_CP_PAID_DT_LABEL() {
		return COMP_CP_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CP_PAID_DT() {
		return COMP_CP_PAID_DT;
	}

	public void setCOMP_CP_PAID_DT_LABEL(HtmlOutputLabel COMP_CP_PAID_DT_LABEL) {
		this.COMP_CP_PAID_DT_LABEL = COMP_CP_PAID_DT_LABEL;
	}

	public void setCOMP_CP_PAID_DT(HtmlCalendar COMP_CP_PAID_DT) {
		this.COMP_CP_PAID_DT = COMP_CP_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_CP_ACCNT_PAY_CODE_LABEL() {
		return COMP_CP_ACCNT_PAY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CP_ACCNT_PAY_CODE() {
		return COMP_CP_ACCNT_PAY_CODE;
	}

	public void setCOMP_CP_ACCNT_PAY_CODE_LABEL(
			HtmlOutputLabel COMP_CP_ACCNT_PAY_CODE_LABEL) {
		this.COMP_CP_ACCNT_PAY_CODE_LABEL = COMP_CP_ACCNT_PAY_CODE_LABEL;
	}

	public void setCOMP_CP_ACCNT_PAY_CODE(HtmlInputText COMP_CP_ACCNT_PAY_CODE) {
		this.COMP_CP_ACCNT_PAY_CODE = COMP_CP_ACCNT_PAY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_CURR_CODE_LABEL() {
		return COMP_UI_M_CP_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_CURR_CODE() {
		return COMP_UI_M_CP_CURR_CODE;
	}

	public void setCOMP_UI_M_CP_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_CURR_CODE_LABEL) {
		this.COMP_UI_M_CP_CURR_CODE_LABEL = COMP_UI_M_CP_CURR_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_CURR_CODE(HtmlInputText COMP_UI_M_CP_CURR_CODE) {
		this.COMP_UI_M_CP_CURR_CODE = COMP_UI_M_CP_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_CP_FC_PAID_AMT_LABEL() {
		return COMP_CP_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CP_FC_PAID_AMT() {
		return COMP_CP_FC_PAID_AMT;
	}

	public void setCOMP_CP_FC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_CP_FC_PAID_AMT_LABEL) {
		this.COMP_CP_FC_PAID_AMT_LABEL = COMP_CP_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_CP_FC_PAID_AMT(HtmlInputText COMP_CP_FC_PAID_AMT) {
		this.COMP_CP_FC_PAID_AMT = COMP_CP_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_CP_LC_PAID_AMT_LABEL() {
		return COMP_CP_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CP_LC_PAID_AMT() {
		return COMP_CP_LC_PAID_AMT;
	}

	public void setCOMP_CP_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_CP_LC_PAID_AMT_LABEL) {
		this.COMP_CP_LC_PAID_AMT_LABEL = COMP_CP_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_CP_LC_PAID_AMT(HtmlInputText COMP_CP_LC_PAID_AMT) {
		this.COMP_CP_LC_PAID_AMT = COMP_CP_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_CP_SET_FLAG_LABEL() {
		return COMP_CP_SET_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_SET_FLAG() {
		return COMP_CP_SET_FLAG;
	}

	public void setCOMP_CP_SET_FLAG_LABEL(HtmlOutputLabel COMP_CP_SET_FLAG_LABEL) {
		this.COMP_CP_SET_FLAG_LABEL = COMP_CP_SET_FLAG_LABEL;
	}

	public void setCOMP_CP_SET_FLAG(HtmlSelectOneMenu COMP_CP_SET_FLAG) {
		this.COMP_CP_SET_FLAG = COMP_CP_SET_FLAG;
	}

	public HtmlOutputLabel getCOMP_CP_CLAIM_REJ_REASON_LABEL() {
		return COMP_CP_CLAIM_REJ_REASON_LABEL;
	}

	public HtmlInputText getCOMP_CP_CLAIM_REJ_REASON() {
		return COMP_CP_CLAIM_REJ_REASON;
	}

	public void setCOMP_CP_CLAIM_REJ_REASON_LABEL(
			HtmlOutputLabel COMP_CP_CLAIM_REJ_REASON_LABEL) {
		this.COMP_CP_CLAIM_REJ_REASON_LABEL = COMP_CP_CLAIM_REJ_REASON_LABEL;
	}

	public void setCOMP_CP_CLAIM_REJ_REASON(
			HtmlInputText COMP_CP_CLAIM_REJ_REASON) {
		this.COMP_CP_CLAIM_REJ_REASON = COMP_CP_CLAIM_REJ_REASON;
	}

	public HtmlOutputLabel getCOMP_UI_M_CCD_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_CCD_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CCD_COVER_CODE_DESC() {
		return COMP_UI_M_CCD_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CCD_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_CCD_COVER_CODE_DESC_LABEL = COMP_UI_M_CCD_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CCD_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_CCD_COVER_CODE_DESC) {
		this.COMP_UI_M_CCD_COVER_CODE_DESC = COMP_UI_M_CCD_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL() {
		return COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC() {
		return COMP_UI_M_CP_ACCNT_PAY_CODE_DESC;
	}

	public void setCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL) {
		this.COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL = COMP_UI_M_CP_ACCNT_PAY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC(
			HtmlInputText COMP_UI_M_CP_ACCNT_PAY_CODE_DESC) {
		this.COMP_UI_M_CP_ACCNT_PAY_CODE_DESC = COMP_UI_M_CP_ACCNT_PAY_CODE_DESC;
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

	public HtmlOutputLabel getCOMP_CP_CLAIM_PAID_TO_LABEL() {
		return COMP_CP_CLAIM_PAID_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CP_CLAIM_PAID_TO() {
		return COMP_CP_CLAIM_PAID_TO;
	}

	public void setCOMP_CP_CLAIM_PAID_TO_LABEL(
			HtmlOutputLabel COMP_CP_CLAIM_PAID_TO_LABEL) {
		this.COMP_CP_CLAIM_PAID_TO_LABEL = COMP_CP_CLAIM_PAID_TO_LABEL;
	}

	public void setCOMP_CP_CLAIM_PAID_TO(HtmlSelectOneMenu COMP_CP_CLAIM_PAID_TO) {
		this.COMP_CP_CLAIM_PAID_TO = COMP_CP_CLAIM_PAID_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_TOT_EST_LABEL() {
		return COMP_UI_M_CP_FC_TOT_EST_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_TOT_EST() {
		return COMP_UI_M_CP_FC_TOT_EST;
	}

	public void setCOMP_UI_M_CP_FC_TOT_EST_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_TOT_EST_LABEL) {
		this.COMP_UI_M_CP_FC_TOT_EST_LABEL = COMP_UI_M_CP_FC_TOT_EST_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_TOT_EST(HtmlInputText COMP_UI_M_CP_FC_TOT_EST) {
		this.COMP_UI_M_CP_FC_TOT_EST = COMP_UI_M_CP_FC_TOT_EST;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_TOT_EST_LABEL() {
		return COMP_UI_M_CP_LC_TOT_EST_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_TOT_EST() {
		return COMP_UI_M_CP_LC_TOT_EST;
	}

	public void setCOMP_UI_M_CP_LC_TOT_EST_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_TOT_EST_LABEL) {
		this.COMP_UI_M_CP_LC_TOT_EST_LABEL = COMP_UI_M_CP_LC_TOT_EST_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_TOT_EST(HtmlInputText COMP_UI_M_CP_LC_TOT_EST) {
		this.COMP_UI_M_CP_LC_TOT_EST = COMP_UI_M_CP_LC_TOT_EST;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_TOT_PAID_LABEL() {
		return COMP_UI_M_CP_FC_TOT_PAID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_TOT_PAID() {
		return COMP_UI_M_CP_FC_TOT_PAID;
	}

	public void setCOMP_UI_M_CP_FC_TOT_PAID_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_TOT_PAID_LABEL) {
		this.COMP_UI_M_CP_FC_TOT_PAID_LABEL = COMP_UI_M_CP_FC_TOT_PAID_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_TOT_PAID(
			HtmlInputText COMP_UI_M_CP_FC_TOT_PAID) {
		this.COMP_UI_M_CP_FC_TOT_PAID = COMP_UI_M_CP_FC_TOT_PAID;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_TOT_PAID_LABEL() {
		return COMP_UI_M_CP_LC_TOT_PAID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_TOT_PAID() {
		return COMP_UI_M_CP_LC_TOT_PAID;
	}

	public void setCOMP_UI_M_CP_LC_TOT_PAID_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_TOT_PAID_LABEL) {
		this.COMP_UI_M_CP_LC_TOT_PAID_LABEL = COMP_UI_M_CP_LC_TOT_PAID_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_TOT_PAID(
			HtmlInputText COMP_UI_M_CP_LC_TOT_PAID) {
		this.COMP_UI_M_CP_LC_TOT_PAID = COMP_UI_M_CP_LC_TOT_PAID;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FC_BALANCE_LABEL() {
		return COMP_UI_M_CP_FC_BALANCE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_FC_BALANCE() {
		return COMP_UI_M_CP_FC_BALANCE;
	}

	public void setCOMP_UI_M_CP_FC_BALANCE_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_FC_BALANCE_LABEL) {
		this.COMP_UI_M_CP_FC_BALANCE_LABEL = COMP_UI_M_CP_FC_BALANCE_LABEL;
	}

	public void setCOMP_UI_M_CP_FC_BALANCE(HtmlInputText COMP_UI_M_CP_FC_BALANCE) {
		this.COMP_UI_M_CP_FC_BALANCE = COMP_UI_M_CP_FC_BALANCE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_LC_BALANCE_LABEL() {
		return COMP_UI_M_CP_LC_BALANCE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_LC_BALANCE() {
		return COMP_UI_M_CP_LC_BALANCE;
	}

	public void setCOMP_UI_M_CP_LC_BALANCE_LABEL(
			HtmlOutputLabel COMP_UI_M_CP_LC_BALANCE_LABEL) {
		this.COMP_UI_M_CP_LC_BALANCE_LABEL = COMP_UI_M_CP_LC_BALANCE_LABEL;
	}

	public void setCOMP_UI_M_CP_LC_BALANCE(HtmlInputText COMP_UI_M_CP_LC_BALANCE) {
		this.COMP_UI_M_CP_LC_BALANCE = COMP_UI_M_CP_LC_BALANCE;
	}

	public UIData getCOMP_CLAIM_PAID_DATATABLE() {
		return COMP_CLAIM_PAID_DATATABLE;
	}

	public void setCOMP_CLAIM_PAID_DATATABLE(UIData comp_claim_paid_datatable) {
		COMP_CLAIM_PAID_DATATABLE = comp_claim_paid_datatable;
	}

	public PT_IL_CLAIM_PAID getPT_IL_CLAIM_PAID_BEAN() {
		return PT_IL_CLAIM_PAID_BEAN;
	}

	public void setPT_IL_CLAIM_PAID_BEAN(PT_IL_CLAIM_PAID PT_IL_CLAIM_PAID_BEAN) {
		this.PT_IL_CLAIM_PAID_BEAN = PT_IL_CLAIM_PAID_BEAN;
	}

	public List<PT_IL_CLAIM_PAID> getPT_IL_CLAIM_PAID_BEAN_LIST() {
		return PT_IL_CLAIM_PAID_BEAN_LIST;
	}

	public void setPT_IL_CLAIM_PAID_BEAN_LIST(
			List<PT_IL_CLAIM_PAID> pt_il_claim_paid_bean_list) {
		PT_IL_CLAIM_PAID_BEAN_LIST = pt_il_claim_paid_bean_list;
	}

	public List<SelectItem> getApprovedList() {
		return approvedList;
	}

	public void setApprovedList(List<SelectItem> approvedList) {
		this.approvedList = approvedList;
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
				CommonUtils.clearMaps(this);
				
				/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
				COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
				/*End*/
				
				new PT_IL_CLAIM_HELPER().executeQuery(compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN());
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				if (PT_IL_CLAIM_PAID_BEAN.getROWID() != null) {
					helper.postQuery(PT_IL_CLAIM_PAID_BEAN, compositeAction);
				} else {
					helper.whenCreateRecord(compositeAction);
				}
				helper.whenNewRecordInstance(compositeAction);
				
				setBlockFlag(false);
				
				/*Added by Ameen on 30-12-2017 for ZBLIFE-1458892*/
				   if(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08() == null){
					if("B".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())){
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_ACC_NO.setRequired(false);
						COMP_UI_M_ACNT_NAME.setRequired(false);
						COMP_UI_M_DIVISION.setRequired(false);
						COMP_UI_M_CUST_MOBILE.setDisabled(true);
						COMP_UI_M_BILLER_CODE.setDisabled(true);
						
						
						/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/

						COMP_UI_M_BANK_CODE.setDisabled(true);
						COMP_UI_M_DIVISION.setDisabled(true);
						COMP_ACC_NO.setDisabled(true);
						COMP_UI_M_ACNT_NAME.setDisabled(true);
					
						/*End*/
						
					}else if("C".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())){
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_ACC_NO.setRequired(true);
						COMP_UI_M_ACNT_NAME.setRequired(true);
						COMP_UI_M_DIVISION.setRequired(true);
						COMP_UI_M_CUST_MOBILE.setDisabled(false);
						COMP_UI_M_BILLER_CODE.setDisabled(false);
						
						String query = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
								+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
								+ "PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
								+ "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
						ResultSet rs = null;
						rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_ACCNT_PAY_CODE()});
						if(rs.next()){
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(rs.getString("CBAD_CUST_BANK_CODE"));
								PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(rs.getString("CBAD_ACNT_NO"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(rs.getString("CBAD_DIVISION"));
								if(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()!=null){
									String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
									ResultSet sortCodeRS = null;
									sortCodeRS = new CRUDHandler().executeSelectStatement
											(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(),PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()});
									if(sortCodeRS.next()){
										PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
									}
								}
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(rs.getString("CBAD_ACNT_NAME"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(rs.getString("CUST_MOBILE"));
						}
					}else if("A".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())){
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_ACC_NO.setRequired(true);
						COMP_UI_M_ACNT_NAME.setRequired(true);
						COMP_UI_M_DIVISION.setRequired(true);
						COMP_UI_M_CUST_MOBILE.setDisabled(false);
						COMP_UI_M_BILLER_CODE.setDisabled(false);
						
						String query = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
								+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
								+ "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
								+ "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
								+ "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
								+ "PT_IL_POLICY WHERE POL_NO = ?)";
						ResultSet rs = null;
						rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
									new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
						if(rs.next()){
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(rs.getString("CBAD_CUST_BANK_CODE"));
								PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(rs.getString("CBAD_ACNT_NO"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(rs.getString("CBAD_DIVISION"));
								if(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()!=null){
									String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
									ResultSet sortCodeRS = null;
									sortCodeRS = new CRUDHandler().executeSelectStatement
											(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(),PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()});
									if(sortCodeRS.next()){
										PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
									}
								}
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(rs.getString("CBAD_ACNT_NAME"));
								PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(rs.getString("CUST_MOBILE"));
								
						}
					}
				}
				/*End*/
				   
				}
				enableDisableButtons(compositeAction);
				partialSettlCheck(compositeAction);
				/*Added by Ameen on 19-12-2017 for ZBLIFE-1464092*/
				disableFcAmt();
				/*End*/
				String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM_POL");
				if("PILT002_APAC".equalsIgnoreCase(CommonUtils.nvl(callingForm,""))){
					compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getCOMP_CP_PAID_DT().setDisabled(true);
					compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getCOMP_CP_CLM_PAID_STATUS().setDisabled(true);
					//compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getUI_M_BUT_POST().setDisabled(true);
				
				}
				if(null == getPT_IL_CLAIM_PAID_BEAN().getCP_FC_PAID_AMT() || 
						getPT_IL_CLAIM_PAID_BEAN().getCP_FC_PAID_AMT() == 0.0){
					getUI_M_BUT_POST().setDisabled(true);
					//compositeAction.getWizard().disableWizardItem("PT_IL_CLAIM_PAID");
				}
				else{
					getUI_M_BUT_POST().setDisabled(false);
					//compositeAction.getWizard().enableWizardItem("PT_IL_CLAIM_PAID");
				}
				
				
				//Added by saritha on 23-03-2017 for interest delay claims 
				if(PT_IL_CLAIM_PAID_BEAN_LIST.size()<=0){
				COMP_ACC_NO.setDisabled(true);
				COMP_MICR_CODE.setDisabled(true);
				
				/*Modified by Janani on  21.08.2017 for ZBILQC-1732254 */
				
				//COMP_TYPE.setDisabled(true);
				COMP_CP_TYPE.setDisabled(true);
				
				/*End*/
				
				
				COMP_CP_CLM_PAID_STATUS.setDisabled(true);
				COMP_CP_PAID_DT.setDisabled(true);
				disableAllComponent(true);
				}
				/*End*/
				
				
				/*Added by Janani on 22.08.2017 for ZBILQC-1732254 */
				
				System.out.println("getCP_CLAIM_PAID_TO in onload        "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
						getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO());
				
				if(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO().equalsIgnoreCase("B"))
				{
					compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
				}
				else
				{
					compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(true);
				}	
				/*End of ZBILQC-1732254*/
				
				
				/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
				
				System.out.println("getCP_PYMT_MTD in onload        "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
						getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD());

				   if(CommonUtils.isIN(CommonUtils.nvl(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
							getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD(),""),"1","3") && (!compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
									getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO().equalsIgnoreCase("B")))	
				   {					

					   
					   COMP_UI_M_BANK_CODE.setDisabled(false);
					   COMP_UI_M_DIVISION.setDisabled(false);
					   COMP_ACC_NO.setDisabled(false);
					   COMP_UI_M_ACNT_NAME.setDisabled(false);

					   COMP_UI_M_BANK_CODE.setRequired(true);
					   COMP_UI_M_DIVISION.setRequired(true);
					   COMP_ACC_NO.setRequired(true);
					   COMP_UI_M_ACNT_NAME.setRequired(true);

				   }
				   else
				   {
					  
					   COMP_UI_M_BANK_CODE.setDisabled(true);
					   COMP_UI_M_DIVISION.setDisabled(true);
					   COMP_ACC_NO.setDisabled(true);
					   COMP_UI_M_ACNT_NAME.setDisabled(true);
					   
					   PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(null);
						PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(null);
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(null);
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(null);
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(null);
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(null);
						PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(null);

					   COMP_UI_M_BANK_CODE.setRequired(false);
					   COMP_UI_M_DIVISION.setRequired(false);
					   COMP_ACC_NO.setRequired(false);
					   COMP_UI_M_ACNT_NAME.setRequired(false);
				   }
				   
				   
				   if(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
							getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD().equalsIgnoreCase("2") && 
							(!compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
									getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO().equalsIgnoreCase("B")))
				   {
					   COMP_CP_PAYEE_NAME.setDisabled(false);
					   COMP_CP_PAYEE_NAME.resetValue();
				   }
				   else
				   {
					   COMP_CP_PAYEE_NAME.setDisabled(true);
					   COMP_CP_PAYEE_NAME.resetValue();
				   }
				   /*End*/
				
				
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				setErrorMessages(e.getMessage());
			}
	}

	private void enableDisableButtons(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String C_query="SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID=? AND CP_SYS_ID=?";
		Connection con=null;
		ResultSet rs=null;
		String M_CP_APPR_FLAG=null;
		CRUDHandler handler= new CRUDHandler();
		
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(C_query, con, 
					new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID(),PT_IL_CLAIM_PAID_BEAN.getCP_SYS_ID()});
			while(rs.next())
			{
				M_CP_APPR_FLAG=rs.getString(1);
			}
			if ("A".equalsIgnoreCase(CommonUtils.nvl(M_CP_APPR_FLAG,"N"))||"R".equalsIgnoreCase(CommonUtils.nvl(M_CP_APPR_FLAG,"N"))) {
				COMP_UI_M_BUT_APPROVE.setDisabled(true);
				COMP_CP_CLM_PAID_STATUS.setDisabled(true);
			}
			else
			{
				COMP_UI_M_BUT_APPROVE.setDisabled(false);
				COMP_CP_CLM_PAID_STATUS.setDisabled(false);
			}
			
			/*added by raja on 16-06-2017 for ZBILQC-1728176*/
			
			if(PT_IL_CLAIM_PAID_BEAN_LIST.size()>0)
			{
				COMP_UI_M_BUT_APPROVE.setDisabled(false);
			}
			else
			{
				COMP_UI_M_BUT_APPROVE.setDisabled(true);
			}
			/*end*/
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		
		
	}

	public List<PT_IL_CLAIM_PAID> cpAccntPayCodeList(Object obj) {
		try {
			cpAccntPayCodeList = helper.cpAccntPayCode((String) obj,
					compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpAccntPayCodeList;
	}

	public void setCpAccntPayCodeDescList() throws Exception {
		try {
			String cpAccntPayCode = (String) getCOMP_CP_ACCNT_PAY_CODE()
					.getSubmittedValue();
			Iterator<PT_IL_CLAIM_PAID> paidItr = cpAccntPayCodeList.iterator();
			while (paidItr.hasNext()) {
				PT_IL_CLAIM_PAID claimPaidBean = paidItr.next();
				if (claimPaidBean.getCP_ACCNT_PAY_CODE().equals(cpAccntPayCode)) {
					getCOMP_UI_M_CP_ACCNT_PAY_CODE_DESC().setSubmittedValue(
							claimPaidBean.getUI_M_CP_ACCNT_PAY_CODE_DESC());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void validateCP_FC_PAID_AMT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.cpFcPaidAmtWhenValidateItem(compositeAction);
			PT_IL_CLAIM_PAID_BEAN.setCP_FC_PAID_AMT((Double)value);
			PT_IL_CLAIM_PAID_BEAN.setCP_LC_PAID_AMT((Double)value);
			COMP_CP_LC_PAID_AMT.resetValue();
			helper.partialSettlementValidation(compositeAction);
		} catch (Exception e) {
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
	
	public void validateCP_LC_PAID_AMT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			//helper.cpFcPaidAmtWhenValidateItem(compositeAction);
			PT_IL_CLAIM_PAID_BEAN.setCP_LC_PAID_AMT((Double)value);
			//COMP_CP_LC_PAID_AMT.resetValue();
		} catch (Exception e) {
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

	public void validateCP_APPR_FLAG(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.cpApprFlagWhenListChanged(compositeAction);
			helper.cpApprFlagWhenValidateItem(compositeAction);
		} catch (Exception e) {
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
	
	/*Modified by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
		
	/*public void validateCP_CLAIM_PAID_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {*/
		
	
		public void actionListenerCP_CLAIM_PAID_TO(ActionEvent event) {
			getErrorMap().clear();
			getWarningMap().clear();
			
			ResultSet rs = null;
			
		try {
			
			
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputvalue= (String)input.getSubmittedValue();
			compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION()
					.getPT_IL_CLAIM_PAID_BEAN().setCP_CLAIM_PAID_TO(
							((String) inputvalue));
		
			
			/*Added by Ameen on 30-12-2017 for ZBLIFE-1458892*/
			if("B".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())){
				COMP_UI_M_BANK_CODE.setRequired(false);
				COMP_ACC_NO.setRequired(false);
				COMP_UI_M_ACNT_NAME.setRequired(false);
				COMP_UI_M_DIVISION.setRequired(false);
				COMP_UI_M_CUST_MOBILE.setDisabled(true);
				COMP_UI_M_BILLER_CODE.setDisabled(true);
				
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12("");
				
				/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/

				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_DIVISION.setDisabled(true);
				COMP_ACC_NO.setDisabled(true);
				COMP_UI_M_ACNT_NAME.setDisabled(true);
			
				/*End*/
				
			}
			
			/*Modified by Janani on 14.02.2018 for ZB as per Thiags sugges*/
			/*else if("C".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO()))*/
			else if("C".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())  &&
			(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD(),""),"1","3")))		
			
			/*End*/	
				
			{
				COMP_UI_M_BANK_CODE.setRequired(true);
				COMP_ACC_NO.setRequired(true);
				COMP_UI_M_ACNT_NAME.setRequired(true);
				COMP_UI_M_DIVISION.setRequired(true);
				COMP_UI_M_CUST_MOBILE.setDisabled(false);
				COMP_UI_M_BILLER_CODE.setDisabled(false);
				
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12("");
				
				String query = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
						+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
						+ "PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
						+ "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
				 rs = null;
				rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_ACCNT_PAY_CODE()});
				if(rs.next()){
					if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
							rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						throw new Exception("Enter the Bank Details in Customer Master");
					}else{
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(rs.getString("CBAD_CUST_BANK_CODE"));
						PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(rs.getString("CBAD_ACNT_NO"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(rs.getString("CBAD_DIVISION"));
						if(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()!=null){
							String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
							ResultSet sortCodeRS = null;
							sortCodeRS = new CRUDHandler().executeSelectStatement
									(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(),PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()});
							if(sortCodeRS.next()){
								PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
							}
						}
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(rs.getString("CBAD_ACNT_NAME"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(rs.getString("CUST_MOBILE"));
						
					}
				}else{
					throw new Exception("Enter the Bank Details in Customer Master");
				}
			}			
				/*Modified by Janani on 14.02.2018 for ZB as per Thiags sugges*/
				/*else if("C".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO()))*/
				else if("A".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())  &&
				(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD(),""),"1","3")))		
				
				/*End*/	
			
			{
				COMP_UI_M_BANK_CODE.setRequired(true);
				COMP_ACC_NO.setRequired(true);
				COMP_UI_M_ACNT_NAME.setRequired(true);
				COMP_UI_M_DIVISION.setRequired(true);
				COMP_UI_M_CUST_MOBILE.setDisabled(false);
				COMP_UI_M_BILLER_CODE.setDisabled(false);
				
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11("");
				PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10("");
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12("");
				
				String query = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
						+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
						+ "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
						+ "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
						+ "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
						+ "PT_IL_POLICY WHERE POL_NO = ?)";
				 rs = null;
				rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
				if(rs.next()){
					if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
							rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						throw new Exception("Enter the Bank Details in Customer Master");
					}else{
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(rs.getString("CBAD_CUST_BANK_CODE"));
						PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(rs.getString("CBAD_ACNT_NO"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(rs.getString("CBAD_DIVISION"));
						if(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()!=null){
							String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
							ResultSet sortCodeRS = null;
							sortCodeRS = new CRUDHandler().executeSelectStatement
									(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(),PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_11()});
							if(sortCodeRS.next()){
								PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
							}
						}
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(rs.getString("CBAD_ACNT_NAME"));
						PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(rs.getString("CUST_MOBILE"));
						
					}
				}else{
					throw new Exception("Enter the Bank Details in Customer Master");
				}
			}
			
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_NAME.resetValue();
			COMP_ACC_NO.resetValue();
			COMP_UI_M_ACNT_NAME.resetValue();
			COMP_UI_M_DIVISION.resetValue();
			COMP_UI_M_DIVISION_DESC.resetValue();
			COMP_UI_M_CUST_MOBILE.resetValue();
			COMP_CP_PAYEE_NAME.resetValue();
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		} finally {
			try {
				 CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validateCP_PAID_DT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			helper.cpPaidDateWhenValidateItem(compositeAction);
		} catch (Exception e) {
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

	public void validateCP_CLM_PAID_STATUS(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.cpClmPaidStatusWhenListChanged(compositeAction);
			COMP_CP_FC_PAID_AMT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				/*Added by saritha on 23-06-2017 for ssp call id ZBILQC-1728094*/
				e.printStackTrace();
				/*End*/
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public String beneficiaryDetails() {
		String outCome = null;
		try {
			outCome = helper.claimPaidBeneficiary(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return outCome;
	}

	public void commitChanges() {
		try {
			helper.keyCommit(compositeAction);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			helper.keyCommit(compositeAction);
			getWarningMap().put(
					"current",
					Messages.getString("messageProperties",
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public String post() {
		try {
			if (PT_IL_CLAIM_PAID_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.chkMICRCode(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_05());
				new CRUDHandler().executeInsert(PT_IL_CLAIM_PAID_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			} else if (PT_IL_CLAIM_PAID_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				//helper.chkMICRCode(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_05());
				helper.preUpdate(PT_IL_CLAIM_PAID_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_CLAIM_PAID_BEAN,
						CommonUtils.getConnection());
				
				/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/	
					
					System.out.println("getCP_SET_FLAG       "+PT_IL_CLAIM_PAID_BEAN.getCP_SET_FLAG());
					System.out.println("getCP_CLM_PAID_STATUS                 "+PT_IL_CLAIM_PAID_BEAN.getCP_CLM_PAID_STATUS());
					System.out.println("CLAIM_SYS_ID in  post        "+PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_SYS_ID());
					System.out.println("CP_CE_SYS_ID in post             "+PT_IL_CLAIM_PAID_BEAN.getCP_CE_SYS_ID());
					System.out.println("CP_SYS_ID in post             "+PT_IL_CLAIM_PAID_BEAN.getCP_SYS_ID());
					System.out.println("getCP_CLAIM_PAID_TO in post             "+PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO());
					
				new PILT007_PROCEDURE().P_UPD_CLM_BENEFICIARY(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_SYS_ID(),PT_IL_CLAIM_PAID_BEAN.getCP_CE_SYS_ID(),
						PT_IL_CLAIM_PAID_BEAN.getCP_SYS_ID(),PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO());
				
				/*End*/
				
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			}
			PT_IL_CLAIM_PAID_BEAN.setRowSelected(true);
			
			
			/* added by raja on 12-06-2017 for ZBILQC-1723007*/
			CommonUtils.getConnection().commit();
			helper.keyCommit(compositeAction);
			/*end*/
			
			/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/	
			
			String cf_check_query = "SELECT 'X' FROM PT_IL_CLAIM_PAID WHERE CP_CE_SYS_ID = ?  AND CP_SET_FLAG='CF'";
			
			ResultSet rst = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();

			Object[] value = {PT_IL_CLAIM_PAID_BEAN.getCP_CE_SYS_ID()};
			
			System.out.println("getCP_CE_SYS_ID                 "+value);
			rst = handler.executeSelectStatement(cf_check_query, connection, value);
			while (rst.next()) {
				setBlockFlag(true);
				onLoad(null);
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				
			}
		
			/*End*/
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

		return "";

	}

	public String approveAction(){
		String outCome = "";
		try {
			

			/*added by raja on 07-06-2017 for hands on points*/
			/*boolean flag=false;
			 flag=approveAccessValidation();
			if(flag==false)
			{
				throw new Exception("User not authorized");
			}*/
			
			/*end*/
			
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			List<PT_IL_CLAIM_PAID> claimPaidList = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN_LIST();
			PT_IL_CLAIM_PAID claimPaidBean = claimPaidList.get(0);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CLAIM_SYS_ID(
					claimPaidBean.getCP_CLAIM_SYS_ID());
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CCD_SYS_ID(
					claimPaidBean.getCP_CCD_SYS_ID());
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CE_SYS_ID(
					claimPaidBean.getCP_CE_SYS_ID());
			outCome = new DUMMY_HELPER()
					.approveButtonWhenButtonPressed(compositeAction);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("approveAction", e.getMessage());
		}

		return outCome;
	}

	public void setSelectedRow(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		boolean value = (Boolean) input.getSubmittedValue();
		System.out.println("setSelectedRow:::::" + value);

		getPT_IL_CLAIM_PAID_BEAN().setSelected(true);
	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CLAIM_PAID_BEAN = (PT_IL_CLAIM_PAID) COMP_CLAIM_PAID_DATATABLE
					.getRowData();
			PT_IL_CLAIM_PAID_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_PAID> iterator = PT_IL_CLAIM_PAID_BEAN_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_CCD_COVER_CODE.resetValue();
		COMP_UI_M_CCD_COVER_CODE_DESC.resetValue();
		COMP_CP_PAID_DT.resetValue();
		COMP_CP_ACCNT_PAY_CODE.resetValue();
		COMP_UI_M_CP_ACCNT_PAY_CODE_DESC.resetValue();
		COMP_UI_M_CP_CURR_CODE.resetValue();
		COMP_CP_FC_PAID_AMT.resetValue();
		COMP_CP_LC_PAID_AMT.resetValue();
		COMP_CP_SET_FLAG.resetValue();
		COMP_CP_CLM_PAID_STATUS.resetValue();
		COMP_CP_APPR_FLAG.resetValue();
		COMP_CP_CLAIM_REJ_REASON.resetValue();
		COMP_CP_SCHD_PYMT_DT.resetValue();
		COMP_CP_CLAIM_PAID_TO.resetValue();
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		COMP_UI_M_BANK_NAME.resetValue();
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		//COMP_CP_PAID_TO.resetValue(); Commented by Janani on  21.08.2017 for ZBILQC-1732254
	/*end*/
		/*added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
		COMP_UI_M_CUST_MOBILE.resetValue();
		COMP_UI_M_ACNT_NAME.resetValue();
		COMP_UI_M_DIVISION.resetValue();
		COMP_UI_M_BILLER_CODE.resetValue();
		/*End*/
		
		/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
		COMP_CP_PAYEE_NAME.resetValue();
		/*End*/
	}
	
	
	public void disableAllComponent(boolean disabled) {
		COMP_UI_M_CCD_COVER_CODE.setDisabled(disabled);
		COMP_UI_M_CCD_COVER_CODE_DESC.setDisabled(disabled);
		COMP_CP_PAID_DT.setDisabled(disabled);
		COMP_CP_ACCNT_PAY_CODE.setDisabled(disabled);
		COMP_UI_M_CP_ACCNT_PAY_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CP_CURR_CODE.setDisabled(disabled);
		COMP_CP_FC_PAID_AMT.setDisabled(disabled);
		COMP_CP_LC_PAID_AMT.setDisabled(disabled);
		COMP_CP_SET_FLAG.setDisabled(disabled);
		//COMP_CP_CLM_PAID_STATUS.setDisabled(disabled);
		COMP_CP_APPR_FLAG.setDisabled(disabled);
		COMP_CP_CLAIM_REJ_REASON.setDisabled(disabled);
		COMP_CP_SCHD_PYMT_DT.setDisabled(disabled);
		COMP_CP_CLAIM_PAID_TO.setDisabled(disabled);
		COMP_CP_TYPE.setDisabled(disabled);
	
		COMP_UI_M_CP_FC_TOT_EST.setDisabled(disabled);
		COMP_UI_M_CP_LC_TOT_EST.setDisabled(disabled);
		COMP_UI_M_CP_FC_TOT_PAID.setDisabled(disabled);
		COMP_UI_M_CP_LC_TOT_PAID.setDisabled(disabled);
		COMP_UI_M_CP_FC_BALANCE.setDisabled(disabled);
		COMP_UI_M_CP_LC_BALANCE.setDisabled(disabled);
		
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		COMP_UI_M_BANK_NAME.setDisabled(disabled);
		COMP_UI_M_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
		//COMP_CP_PAID_TO.setDisabled(disabled); Commented by Janani on  21.08.2017 for ZBILQC-1732254
		/*end*/
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
		COMP_UI_M_CUST_MOBILE.setDisabled(disabled);
		COMP_UI_M_ACNT_NAME.setDisabled(disabled);
		COMP_UI_M_DIVISION.setDisabled(disabled);
		COMP_UI_M_BILLER_CODE.setDisabled(disabled);
		/*end*/
		
		/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
		COMP_CP_PAYEE_NAME.setDisabled(disabled);
		/*End*/
	}

	public void instantiateAllComponent(){
		
		COMP_UI_M_CCD_COVER_CODE =new HtmlInputText();
		COMP_UI_M_CCD_COVER_CODE_DESC=new HtmlInputText();
		COMP_CP_PAID_DT=new HtmlCalendar();
		COMP_CP_ACCNT_PAY_CODE=new HtmlInputText();
		COMP_UI_M_CP_CURR_CODE=new HtmlInputText();
		COMP_UI_M_CP_ACCNT_PAY_CODE_DESC=new HtmlInputText();
		COMP_CP_FC_PAID_AMT=new HtmlInputText();
		COMP_CP_LC_PAID_AMT=new HtmlInputText();
		COMP_CP_SET_FLAG=new HtmlSelectOneMenu();
		COMP_CP_CLM_PAID_STATUS=new HtmlSelectOneMenu();
		COMP_CP_APPR_FLAG=new HtmlSelectOneMenu();
		COMP_CP_CLAIM_REJ_REASON=new HtmlInputText();
		COMP_CP_SCHD_PYMT_DT=new HtmlCalendar();
		COMP_CP_CLAIM_PAID_TO=new HtmlSelectOneMenu();
		COMP_CP_TYPE=new HtmlSelectOneMenu();
		
		COMP_UI_M_CP_FC_TOT_EST=new HtmlInputText();
		COMP_UI_M_CP_LC_TOT_EST=new HtmlInputText();
		COMP_UI_M_CP_FC_TOT_PAID=new HtmlInputText();
		COMP_UI_M_CP_LC_TOT_PAID=new HtmlInputText();
		COMP_UI_M_CP_FC_BALANCE=new HtmlInputText();
		COMP_UI_M_CP_LC_BALANCE=new HtmlInputText();
		UI_M_BUT_POST=new HtmlCommandButton();
		
		COMP_TYPE = new HtmlSelectOneMenu();
		COMP_MICR_CODE = new HtmlInputText();
		COMP_ACC_NO = new HtmlInputText();
		/*added by raja on 10-06-2017 for ZBILQC-1728216 */
		COMP_UI_M_BANK_NAME=new HtmlInputText();
		COMP_UI_M_BANK_CODE=new HtmlInputText();
		COMP_UI_M_BRANCH_CODE=new HtmlInputText();
		COMP_CP_PAID_TO=new HtmlSelectOneMenu();
		/*end*/
		
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
		COMP_UI_M_CUST_MOBILE=new HtmlInputText();
		COMP_UI_M_ACNT_NAME=new HtmlInputText();
		COMP_UI_M_DIVISION=new HtmlInputText();
		COMP_UI_M_BILLER_CODE=new HtmlInputText();
		/*End*/
		
		/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
		COMP_CP_PAYEE_NAME = new HtmlInputText();
		/*End*/
	}
	
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public void validateBAL_AMT(FacesContext context, UIComponent component,
			Object object) {
		PT_IL_CLAIM_PAID_BEAN.setUI_M_CP_FC_TOT_PAID((Double) object);
		PT_IL_CLAIM_PAID_BEAN.setUI_M_CP_LC_TOT_PAID((Double) object);
		Double TOTAL_ESTIMATE_AMT = PT_IL_CLAIM_PAID_BEAN
				.getUI_M_CP_FC_TOT_EST();
		Double PAID_AMT = (Double) object;
		try {
			Double BAL_AMT = TOTAL_ESTIMATE_AMT - PAID_AMT;
			PT_IL_CLAIM_PAID_BEAN.setUI_M_CP_FC_BALANCE(BAL_AMT);
			PT_IL_CLAIM_PAID_BEAN.setUI_M_CP_LC_BALANCE(BAL_AMT);
			COMP_UI_M_CP_FC_BALANCE.resetValue();
			COMP_UI_M_CP_LC_BALANCE.resetValue();
			COMP_UI_M_CP_LC_TOT_PAID.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<SelectItem> getCP_TYPE_list() {
		return CP_TYPE_list;
	}

	public void setCP_TYPE_list(List<SelectItem> cp_type_list) {
		CP_TYPE_list = cp_type_list;
	}

	public HtmlOutputLabel getCOMP_CP_TYPE_LABEL() {
		return COMP_CP_TYPE_LABEL;
	}

	public void setCOMP_CP_TYPE_LABEL(HtmlOutputLabel comp_cp_type_label) {
		COMP_CP_TYPE_LABEL = comp_cp_type_label;
	}

	public HtmlSelectOneMenu getCOMP_CP_TYPE() {
		return COMP_CP_TYPE;
	}

	public void setCOMP_CP_TYPE(HtmlSelectOneMenu comp_cp_type) {
		COMP_CP_TYPE = comp_cp_type;
	}

	public void partialSettlCheck(PILT007_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String C_query = "SELECT CLAIM_TYPE FROM PT_IL_CLAIM WHERE CLAIM_SYS_ID=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String M_CLM_TYPE = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C_query, con,
					new Object[] { compositeAction
							.getPILT007_PT_IL_CLAIM_PAID_ACTION()
							.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID() });
			while (rs.next()) {
				M_CLM_TYPE = rs.getString(1);
			}
			if ("D".equalsIgnoreCase(M_CLM_TYPE)) {
				/*
				 * commented by Ameen on 19-12-2017 for ZBLIFE-1464092
				 * compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().COMP_CP_FC_PAID_AMT
						.setDisabled(true);*/
				compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().COMP_CP_LC_PAID_AMT
						.setDisabled(true);
			}
		} catch (DBException e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*Modified by Janani on  21.08.2017 for ZBILQC-1732254 */
	
	/*public void validateCP_FLEX_04(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException*/
	
	public void validateCP_TYPE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException
			{
		
	/*End*/		
		CommonUtils.clearMaps(this);
		try {
			/*helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction,
					(Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);*/
			/*Modified by Janani on  21.08.2017 for ZBILQC-1732254 */
			//getPT_IL_CLAIM_PAID_BEAN().setCP_FLEX_04((String)value);
			
			getPT_IL_CLAIM_PAID_BEAN().setCP_PYMT_MTD((String)value);
			/*End*/
			
			/*if((PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_05()==null)&&(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_06()==null)){
			helper.fetchDetails(compositeAction);
			}*/
			/*if((PT_IL_LOAN_BEAN.getLOAN_FLEX_04().equalsIgnoreCase("EFT"))){*/
			
			/*Modified by Janani on  21.08.2017 for ZBILQC-1732254 */
			//if("EFT".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_04()))
			
			
			/*Modified by Janani on 14.02.2018 for ZB as per Thiags sugges*/
			//if("1".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_TYPE()))
			
			if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO(),""),"A","C") &&
					(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD(),""),"1","3")))		
			
			/*End*/	
			
			/*End of ZBILQC-1732254*/	
			
			{
				this.getCOMP_ACC_NO().setRequired(true);
				//this.getCOMP_MICR_CODE().setRequired(true);
				
				/*added by raja on 03-05-2017*/
				
				/*
				 * Modified by Janani on 15.02.2018 for ZB bank dtls enabling disabling, as per Thiags sugges
				 * 
				 * String Bankquery="SELECT CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NO,CBAD_DIVISION FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE=?";*/
				
				String Bankquery="SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NO,CBAD_DIVISION,BANK_NAME FROM "
						+ "PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
						+ "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
				
				
				ResultSet resultsetbank=new CRUDHandler().executeSelectStatement(
						Bankquery, CommonUtils.getConnection(), new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_ACCNT_PAY_CODE()});
				while(resultsetbank.next())
				{
					PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(resultsetbank.getString("CBAD_CUST_BANK_CODE"));
				
					PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(resultsetbank.getString("CBAD_ACNT_NO"));
					
					/*MOdified by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
					/*PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_09(resultsetbank.getString("CBAD_DIVISION"));
					PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(resultsetbank.getString("CBAD_BANK_NAME"));*/
					PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(resultsetbank.getString("CBAD_DIVISION"));
					PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(resultsetbank.getString("BANK_NAME"));
					
					/*End*/
				}
				/*end*/
				
				/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
				
				COMP_UI_M_BANK_CODE.setDisabled(false);
				COMP_UI_M_DIVISION.setDisabled(false);
				COMP_ACC_NO.setDisabled(false);
				COMP_UI_M_ACNT_NAME.setDisabled(false);
				
				COMP_UI_M_BANK_CODE.setRequired(true);
				COMP_UI_M_DIVISION.setRequired(true);
				COMP_ACC_NO.setRequired(true);
				COMP_UI_M_ACNT_NAME.setRequired(true);
				/*End*/
				
			}else{
				this.getCOMP_ACC_NO().setRequired(false);
				this.getCOMP_MICR_CODE().setRequired(false);
				
				/*added by raja on 03-05-2017*/
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08(null);
				PT_IL_CLAIM_PAID_BEAN.setUI_M_BANK_NAME(null);
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(null);
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_09(null);
				
				/*end*/
				
				/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
				
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_DIVISION.setDisabled(true);
				COMP_ACC_NO.setDisabled(true);
				COMP_UI_M_ACNT_NAME.setDisabled(true);

				COMP_UI_M_BANK_CODE.setRequired(false);
				COMP_UI_M_DIVISION.setRequired(false);
				COMP_ACC_NO.setRequired(false);
				COMP_UI_M_ACNT_NAME.setRequired(false);
				
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11(null);
				PT_IL_CLAIM_PAID_BEAN.setUI_M_DIVISION_DESC(null);
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10(null);
				PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12(null);
				/*End*/
				
				
			}
			
			/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
			if(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD().equalsIgnoreCase("2") && 
					(!compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
							getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO().equalsIgnoreCase("B")))
			{
				COMP_CP_PAYEE_NAME.setDisabled(false);

			}
			else
			{
				PT_IL_CLAIM_PAID_BEAN.setCP_PAYEE_NAME(null);
				COMP_CP_PAYEE_NAME.setSubmittedValue(null);
				COMP_CP_PAYEE_NAME.setValue(null);
				COMP_CP_PAYEE_NAME.setDisabled(true);
			}

			/*End*/
			
			//COMP_TYPE.resetValue();
			COMP_MICR_CODE.resetValue();
			COMP_ACC_NO.resetValue();
			
			/*added by raja on 10-06-2017 for ZBILQC-1728216 */
			COMP_UI_M_BANK_NAME.resetValue();
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_ACC_NO.resetValue();
			COMP_CP_PAYEE_NAME.resetValue();
			/*end*/
		} catch (Exception exception) {
			exception.printStackTrace();
			
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				/*Modified by Janani on  21.08.2017 for ZBILQC-1732254*/
				
				/*ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "CP_FLEX_04", getWarningMap());*/
				
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "CP_PYMT_MTD", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validateCP_FLEX_05(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			/*helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction,
					(Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);*/
			String value_1=(String)value;
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_05((String)value);
			helper.chkMICRCode(value_1);
			
			//COMP_MICR_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validateCP_FLEX_06(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06((String)value);
			
			//COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*added by raja on 07-06-2017 for hands on points*/
	public boolean approveAccessValidation() throws Exception
	{
		try
		{
			boolean accessFlag=false;
			int shareRatioSystemParam =0;	
			String flag=null;
		/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
		if(shareRatioSystemParam == 2){*/
		String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='MOD_EXCL_CLM'";
		ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(rs.next())
		{
			shareRatioSystemParam=rs.getInt("PS_VALUE");
		}
		if(shareRatioSystemParam == 2){
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();

			String userID=session.get("GLOBAL.M_USER_ID").toString();
			String queryUserApprSetup="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
					+ "ASD_FLAG = '2' AND ASD_CODE='MOD_EXCL_CLM' AND "
					+ "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
					+ "ASD_TO_PROD_CODE = ?";
			
			ResultSet UserApprSetup=new CRUDHandler().executeSelectStatement(queryUserApprSetup, CommonUtils.getConnection(), new Object[]{userID,
				getPROD_CODE(),
				getPROD_CODE()});
			
			while(UserApprSetup.next())
			{
				flag=UserApprSetup.getString("ASD_CHAR_VALUE");
			}
			
			if(flag!=null && flag.equalsIgnoreCase("N"))
			{
				accessFlag=false;
			}
			else
			{
				accessFlag=true;
			}
			
		}
		return accessFlag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	public String getPROD_CODE()
	{
		String plantype=null;
		try{
			
		String query="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID="+compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()+"";
		ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(resultset.next())
		{
			plantype=resultset.getString("POL_PROD_CODE");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return plantype;
		
	}
	
	/*end*/
	
	
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
	
	/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
	private HtmlModalPanel COMP_CONTEST_PERIOD_MODAL_PANEL;
	public HtmlModalPanel getCOMP_CONTEST_PERIOD_MODAL_PANEL() {
		return COMP_CONTEST_PERIOD_MODAL_PANEL;
	}

	public void setCOMP_CONTEST_PERIOD_MODAL_PANEL(
			HtmlModalPanel cOMP_CONTEST_PERIOD_MODAL_PANEL) {
		COMP_CONTEST_PERIOD_MODAL_PANEL = cOMP_CONTEST_PERIOD_MODAL_PANEL;
	}

	public void OkModalPanel() throws Exception{
		System.out.println("enter into the ok model panal");
		getCOMP_CONTEST_PERIOD_MODAL_PANEL().setShowWhenRendered(false);
			
	}
	
	public void fireFieldSettlementDecision(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		if(value.equalsIgnoreCase("A")){

			compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().checkContestabilityPeriod(COMP_CONTEST_PERIOD_MODAL_PANEL);

		}else{
			COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
		}

		//ErrorHelpUtil.validate(input, getErrorMap());
	}


	Connection connection = null;
	ResultSet rs1Contest = null;
	ResultSet rs2Contest = null;
	public void checkContestabilityPeriod(HtmlModalPanel MODAL_PANEL_BINDING){
		int PLAN_CONT_PERIOD = 0;
		String POL_END_TYPE = null;
		Date M_POL_START_DT = null;
		Date M_POL_END_DT =null;
		Date CLAIM_LOSS_DT=null;

		try{
			String contPeriodQuery ="SELECT PLAN_CONT_PERIOD FROM PT_IL_POLICY,PM_IL_PLAN,PT_IL_CLAIM WHERE PLAN_CODE=POL_PLAN_CODE AND POL_SYS_ID=CLAIM_POL_SYS_ID AND CLAIM_SYS_ID=?";
			connection = CommonUtils.getConnection();
			rs1Contest = new CRUDHandler().executeSelectStatement(contPeriodQuery, connection,
					new Object[] {getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID()});
			if (rs1Contest.next()) {
				PLAN_CONT_PERIOD=rs1Contest.getInt(1);
				System.out.println("Contestability Period      :"+PLAN_CONT_PERIOD);
			}

			String polClaimQuery ="SELECT POL_START_DT,POL_EXPIRY_DT,CLAIM_LOSS_DT,POL_END_TYPE FROM PT_IL_POLICY,PT_IL_CLAIM WHERE CLAIM_SYS_ID=? AND POL_SYS_ID=CLAIM_POL_SYS_ID"; 

			rs2Contest = new CRUDHandler().executeSelectStatement(polClaimQuery, connection,
					new Object[] {getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID()});
			if (rs2Contest.next()) {
				M_POL_START_DT = rs2Contest.getDate(1);
				M_POL_END_DT = rs2Contest.getDate(2);
				CLAIM_LOSS_DT= rs2Contest.getDate(3);
				POL_END_TYPE = rs2Contest.getString(4);
			}
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(CLAIM_LOSS_DT);
			int claimYear = cal.get(Calendar.YEAR);
			Calendar cal1 = Calendar.getInstance();
			cal.setTime(M_POL_START_DT);
			int polYear = cal.get(Calendar.YEAR);
			int M_DIFF_DATE_POL=claimYear-polYear;
			System.out.println("M_DIFF_DATE_POL  ====  "+M_DIFF_DATE_POL);		


			if((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006")))
			{
				System.out.println(" end type equals of 006");

				cal = Calendar.getInstance();
				cal.setTime(CLAIM_LOSS_DT);
				int claimYears = cal.get(Calendar.YEAR);

				cal1 = Calendar.getInstance();
				cal.setTime(M_POL_END_DT);
				int endYear = cal1.get(Calendar.YEAR);

				int M_DIFF_DATE_END=claimYears-endYear;
				System.out.println("M_DIFF_DATE_END  ====  "+M_DIFF_DATE_END);

				if(M_DIFF_DATE_END<PLAN_CONT_PERIOD)
				{
					System.out.println("inside DIFF_DATE_END<PLAN_CONT_PERIOD ");					
					MODAL_PANEL_BINDING.setShowWhenRendered(true);

				}
			}
			else
			{
				System.out.println(" end type !equals of 006");

				if(M_DIFF_DATE_POL<PLAN_CONT_PERIOD)
				{
					System.out.println("inside DIFF_DATE_POL<PLAN_CONT_PERIOD ");

					MODAL_PANEL_BINDING.setShowWhenRendered(true);
					MODAL_PANEL_BINDING.resetValue();

				}

			}

		}catch(Exception e){
			e.printStackTrace();

		}

	}
	
	/*End*/
	/*Added by Ameen as per Ajay sugg. for ZBLIFE-1458892*/
	
	private HtmlOutputLabel COMP_UI_M_CUST_MOBILE_LABEL;
	
	private HtmlInputText COMP_UI_M_CUST_MOBILE;
	
	private HtmlOutputLabel COMP_UI_M_ACNT_NAME_LABEL;
	
	private HtmlInputText COMP_UI_M_ACNT_NAME;
	
	private HtmlOutputLabel COMP_UI_M_DIVISION_LABEL;
	
	private HtmlInputText COMP_UI_M_DIVISION;
	
	private HtmlInputText COMP_UI_M_DIVISION_DESC;
	
	private HtmlOutputLabel COMP_UI_M_BILLER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_BILLER_CODE;
	
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
	
	public HtmlInputText getCOMP_UI_M_DIVISION_DESC() {
		return COMP_UI_M_DIVISION_DESC;
	}

	public void setCOMP_UI_M_DIVISION_DESC(HtmlInputText cOMP_UI_M_DIVISION_DESC) {
		COMP_UI_M_DIVISION_DESC = cOMP_UI_M_DIVISION_DESC;
	}

	public void validateCP_FLEX_12(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_12((String)value);
			COMP_UI_M_CUST_MOBILE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} 
	}
	
	public void validateCP_FLEX_10(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_10((String)value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} 
	}

	public void validateCP_FLEX_11(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_11((String)value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} 
	}
	
	public ArrayList<LovBean> prepareSuggestionList_UI_M_DIVISION_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(), PELConstants.suggetionRecordSize };
				
				
				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_08(), code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				
				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND"
						+ "(UPPER(BR_BANK_SORT_CODE) LIKE UPPER(?) OR UPPER(BR_BANK_BRANCH_CODE) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
				/*End*/
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	

	/*End*/
	
	/*Added by Ameen on 19-12-2017 for ZBLIFE-1464092*/
	public void disableFcAmt(){
		try {
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			
			String PAID_STATUS = PT_IL_CLAIM_PAID_BEAN.getCP_CLM_PAID_STATUS();
			
			String CP_APPR_FLAG = PT_IL_CLAIM_PAID_BEAN.getCP_APPR_FLAG();
			if(PT_IL_CLAIM_PAID_BEAN.getCP_SYS_ID() != null){
			if (PAID_STATUS.equals("R")) {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_FC_PAID_AMT_DIS(true);
			}else{
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_FC_PAID_AMT_DIS(false);
			}
			
			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("N")) {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_FC_PAID_AMT_DIS(false);
				
			} else {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_FC_PAID_AMT_DIS(true);
				
			}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
	}
	/*End*/
	
	/*Added by Saritha on 27-12-2017 for ssp call id : ZBLIFE-1458892*/
	public void validateCP_FLEX_13(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {

			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_13((String)value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} 
	}
	/*End*/
	
	/*Added by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
	
	private HtmlOutputLabel COMP_CP_PAYEE_NAME_LABEL;

	private HtmlInputText COMP_CP_PAYEE_NAME;

	
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

	public void validateCP_PAYEE_NAME(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		
		try {
			
			PT_IL_CLAIM_PAID_BEAN.setCP_PAYEE_NAME((String)value);
			
			//COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "CP_PAYEE_NAME", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_UI_M_BANK_CODE(Object object){
		
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PM006_A_APAC";
		String blockName = "PM_CUST_BANK_ACNT_DTLS";
		String fieldName = "CBAD_CUST_BANK_CODE";
		

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null, 

					null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	public void validateUI_M_BANK_CODE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		
		try {
			PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_08((String)value);
		
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
		
	public void validateCP_CLAIM_PAID_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		
		ResultSet rs = null;
			try {
				compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION()
						.getPT_IL_CLAIM_PAID_BEAN().setCP_CLAIM_PAID_TO(
								((String) value));
				helper.CP_CLAIM_PAID_TOWhenListChanged(compositeAction);
			
		
			
			
			if("C".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())  &&
			(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD(),""),"1","3")))		
			{
				
				String query = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
						+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
						+ "PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
						+ "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
				
				rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_ACCNT_PAY_CODE()});
				if(rs.next()){
					if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
							rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						throw new Exception("Enter the Bank Details in Customer Master");
				}
			}else{
				throw new Exception("Enter the Bank Details in Customer Master");
			}	
			}
				else if("A".equalsIgnoreCase(PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_PAID_TO())  &&
				(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_PAID_BEAN.getCP_PYMT_MTD(),""),"1","3")))		
				
			
			{
				
				String query = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
						+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
						+ "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
						+ "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
						+ "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
						+ "PT_IL_POLICY WHERE POL_NO = ?)";
				
				rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
				if(rs.next()){
					if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
							rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						throw new Exception("Enter the Bank Details in Customer Master");
				}
			}else{
				throw new Exception("Enter the Bank Details in Customer Master");
			}
			
			}	
			
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_NAME.resetValue();
			COMP_ACC_NO.resetValue();
			COMP_UI_M_ACNT_NAME.resetValue();
			COMP_UI_M_DIVISION.resetValue();
			COMP_UI_M_DIVISION_DESC.resetValue();
			COMP_UI_M_CUST_MOBILE.resetValue();
			COMP_CP_PAYEE_NAME.resetValue();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				
				CommonUtils.closeCursor(rs);
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "CP_CLAIM_PAID_TO", getWarningMap());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*End*/
	
}

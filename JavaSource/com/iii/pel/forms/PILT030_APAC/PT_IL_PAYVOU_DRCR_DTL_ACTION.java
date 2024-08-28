package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PAYVOU_DRCR_DTL_ACTION extends CommonAction {

	private String filterByPADD_MAIN_ACNT_CODE;
	private String filterByPADD_SUB_ACNT_CODE;
	private String filterByPADD_POL_NO;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private HtmlOutputLabel COMP_PADD_MAIN_ACNT_CODE_LABEL;
	private HtmlOutputLabel COMP_PADD_SUB_ACNT_CODE_LABEL;
	private HtmlOutputLabel COMP_PADD_ANLY_CODE_1_LABEL;
	private HtmlOutputLabel COMP_PADD_ANLY_CODE_2_LABEL;
	private HtmlOutputLabel COMP_PADD_CUST_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PADD_CUST_DESC_LABEL;
	private HtmlOutputLabel COMP_PADD_DRCR_FLAG_LABEL;
	private HtmlOutputLabel COMP_PADD_TXN_CODE_LABEL;
	private HtmlOutputLabel COMP_PADD_DOC_NO_LABEL;
	private HtmlOutputLabel COMP_PADD_SEQ_NO_LABEL;
	private HtmlOutputLabel COMP_PADD_DOC_DT_LABEL;
	private HtmlOutputLabel COMP_PADD_FC_AMT_LABEL;
	private HtmlOutputLabel COMP_PADD_LC_AMT_LABEL;
	private HtmlOutputLabel COMP_PADD_POL_NO_LABEL;
	private HtmlOutputLabel COMP_PADD_CLAIM_NO_LABEL;
	private HtmlOutputLabel COMP_PADD_SELECTED_YN_LABEL;

	private HtmlInputText COMP_PADD_MAIN_ACNT_CODE;
	private HtmlInputText COMP_PADD_SUB_ACNT_CODE;
	private HtmlInputText COMP_PADD_ANLY_CODE_1;
	private HtmlInputText COMP_PADD_ANLY_CODE_2;
	private HtmlInputText COMP_PADD_CUST_CODE;
	private HtmlInputText COMP_UI_M_PADD_CUST_DESC;
	private HtmlInputText COMP_PADD_DRCR_FLAG;
	private HtmlInputText COMP_PADD_TXN_CODE;
	private HtmlInputText COMP_PADD_DOC_NO;
	private HtmlInputText COMP_PADD_SEQ_NO;
	private HtmlCalendar COMP_PADD_DOC_DT;
	private HtmlInputText COMP_PADD_FC_AMT;
	private HtmlInputText COMP_PADD_LC_AMT;
	private HtmlInputText COMP_PADD_POL_NO;
	private HtmlInputText COMP_PADD_CLAIM_NO;

	private HtmlSelectOneMenu COMP_PADD_SELECTED_YN;

	private PT_IL_PAYVOU_DRCR_DTL PT_IL_PAYVOU_DRCR_DTL_BEAN;

	private UIData PT_IL_PAYVOU_DRCR_DTL_DT;

	private List<PT_IL_PAYVOU_DRCR_DTL> PT_IL_PAYVOU_DRCR_DTL_LIST;

	private boolean onLoadFlag = false;

	private List<SelectItem> PADD_SELECTED_YN_LIST = null;

	public PT_IL_PAYVOU_DRCR_DTL_ACTION() {
		PT_IL_PAYVOU_DRCR_DTL_BEAN = new PT_IL_PAYVOU_DRCR_DTL();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PADD_SELECTED_YN_LIST = ListItemUtil.getDropDownListValue(connection,
				"PILT030_APAC", "PT_IL_PAYVOU_DRCR_DTL",
				"PT_IL_PAYVOU_DRCR_DTL.PADD_SELECTED_YN", "YESNO");
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByPADD_MAIN_ACNT_CODE() {
		return filterByPADD_MAIN_ACNT_CODE;
	}

	public void setFilterByPADD_MAIN_ACNT_CODE(
			String filterByPADD_MAIN_ACNT_CODE) {
		this.filterByPADD_MAIN_ACNT_CODE = filterByPADD_MAIN_ACNT_CODE;
	}

	public String getFilterByPADD_SUB_ACNT_CODE() {
		return filterByPADD_SUB_ACNT_CODE;
	}

	public void setFilterByPADD_SUB_ACNT_CODE(String filterByPADD_SUB_ACNT_CODE) {
		this.filterByPADD_SUB_ACNT_CODE = filterByPADD_SUB_ACNT_CODE;
	}

	public String getFilterByPADD_POL_NO() {
		return filterByPADD_POL_NO;
	}

	public void setFilterByPADD_POL_NO(String filterByPADD_POL_NO) {
		this.filterByPADD_POL_NO = filterByPADD_POL_NO;
	}

	public List<SelectItem> getPADD_SELECTED_YN_LIST() {
		return PADD_SELECTED_YN_LIST;
	}

	public void setPADD_SELECTED_YN_LIST(List<SelectItem> padd_selected_yn_list) {
		PADD_SELECTED_YN_LIST = padd_selected_yn_list;
	}

	public UIData getPT_IL_PAYVOU_DRCR_DTL_DT() {
		return PT_IL_PAYVOU_DRCR_DTL_DT;
	}

	public void setPT_IL_PAYVOU_DRCR_DTL_DT(UIData pt_il_payvou_drcr_dtl_dt) {
		PT_IL_PAYVOU_DRCR_DTL_DT = pt_il_payvou_drcr_dtl_dt;
	}

	public List<PT_IL_PAYVOU_DRCR_DTL> getPT_IL_PAYVOU_DRCR_DTL_LIST() {
		return PT_IL_PAYVOU_DRCR_DTL_LIST;
	}

	public void setPT_IL_PAYVOU_DRCR_DTL_LIST(
			List<PT_IL_PAYVOU_DRCR_DTL> pt_il_payvou_drcr_dtl_list) {
		PT_IL_PAYVOU_DRCR_DTL_LIST = pt_il_payvou_drcr_dtl_list;
	}

	public HtmlOutputLabel getCOMP_PADD_MAIN_ACNT_CODE_LABEL() {
		return COMP_PADD_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PADD_MAIN_ACNT_CODE() {
		return COMP_PADD_MAIN_ACNT_CODE;
	}

	public void setCOMP_PADD_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PADD_MAIN_ACNT_CODE_LABEL) {
		this.COMP_PADD_MAIN_ACNT_CODE_LABEL = COMP_PADD_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_PADD_MAIN_ACNT_CODE(
			HtmlInputText COMP_PADD_MAIN_ACNT_CODE) {
		this.COMP_PADD_MAIN_ACNT_CODE = COMP_PADD_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_PADD_SUB_ACNT_CODE_LABEL() {
		return COMP_PADD_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PADD_SUB_ACNT_CODE() {
		return COMP_PADD_SUB_ACNT_CODE;
	}

	public void setCOMP_PADD_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PADD_SUB_ACNT_CODE_LABEL) {
		this.COMP_PADD_SUB_ACNT_CODE_LABEL = COMP_PADD_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_PADD_SUB_ACNT_CODE(HtmlInputText COMP_PADD_SUB_ACNT_CODE) {
		this.COMP_PADD_SUB_ACNT_CODE = COMP_PADD_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_PADD_ANLY_CODE_1_LABEL() {
		return COMP_PADD_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PADD_ANLY_CODE_1() {
		return COMP_PADD_ANLY_CODE_1;
	}

	public void setCOMP_PADD_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PADD_ANLY_CODE_1_LABEL) {
		this.COMP_PADD_ANLY_CODE_1_LABEL = COMP_PADD_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PADD_ANLY_CODE_1(HtmlInputText COMP_PADD_ANLY_CODE_1) {
		this.COMP_PADD_ANLY_CODE_1 = COMP_PADD_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_PADD_ANLY_CODE_2_LABEL() {
		return COMP_PADD_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PADD_ANLY_CODE_2() {
		return COMP_PADD_ANLY_CODE_2;
	}

	public void setCOMP_PADD_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PADD_ANLY_CODE_2_LABEL) {
		this.COMP_PADD_ANLY_CODE_2_LABEL = COMP_PADD_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PADD_ANLY_CODE_2(HtmlInputText COMP_PADD_ANLY_CODE_2) {
		this.COMP_PADD_ANLY_CODE_2 = COMP_PADD_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_PADD_CUST_CODE_LABEL() {
		return COMP_PADD_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PADD_CUST_CODE() {
		return COMP_PADD_CUST_CODE;
	}

	public void setCOMP_PADD_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_PADD_CUST_CODE_LABEL) {
		this.COMP_PADD_CUST_CODE_LABEL = COMP_PADD_CUST_CODE_LABEL;
	}

	public void setCOMP_PADD_CUST_CODE(HtmlInputText COMP_PADD_CUST_CODE) {
		this.COMP_PADD_CUST_CODE = COMP_PADD_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PADD_CUST_DESC_LABEL() {
		return COMP_UI_M_PADD_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PADD_CUST_DESC() {
		return COMP_UI_M_PADD_CUST_DESC;
	}

	public void setCOMP_UI_M_PADD_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PADD_CUST_DESC_LABEL) {
		this.COMP_UI_M_PADD_CUST_DESC_LABEL = COMP_UI_M_PADD_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_PADD_CUST_DESC(
			HtmlInputText COMP_UI_M_PADD_CUST_DESC) {
		this.COMP_UI_M_PADD_CUST_DESC = COMP_UI_M_PADD_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_PADD_DRCR_FLAG_LABEL() {
		return COMP_PADD_DRCR_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_PADD_DRCR_FLAG() {
		return COMP_PADD_DRCR_FLAG;
	}

	public void setCOMP_PADD_DRCR_FLAG_LABEL(
			HtmlOutputLabel COMP_PADD_DRCR_FLAG_LABEL) {
		this.COMP_PADD_DRCR_FLAG_LABEL = COMP_PADD_DRCR_FLAG_LABEL;
	}

	public void setCOMP_PADD_DRCR_FLAG(HtmlInputText COMP_PADD_DRCR_FLAG) {
		this.COMP_PADD_DRCR_FLAG = COMP_PADD_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_PADD_TXN_CODE_LABEL() {
		return COMP_PADD_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PADD_TXN_CODE() {
		return COMP_PADD_TXN_CODE;
	}

	public void setCOMP_PADD_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_PADD_TXN_CODE_LABEL) {
		this.COMP_PADD_TXN_CODE_LABEL = COMP_PADD_TXN_CODE_LABEL;
	}

	public void setCOMP_PADD_TXN_CODE(HtmlInputText COMP_PADD_TXN_CODE) {
		this.COMP_PADD_TXN_CODE = COMP_PADD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_PADD_DOC_NO_LABEL() {
		return COMP_PADD_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_PADD_DOC_NO() {
		return COMP_PADD_DOC_NO;
	}

	public void setCOMP_PADD_DOC_NO_LABEL(HtmlOutputLabel COMP_PADD_DOC_NO_LABEL) {
		this.COMP_PADD_DOC_NO_LABEL = COMP_PADD_DOC_NO_LABEL;
	}

	public void setCOMP_PADD_DOC_NO(HtmlInputText COMP_PADD_DOC_NO) {
		this.COMP_PADD_DOC_NO = COMP_PADD_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_PADD_SEQ_NO_LABEL() {
		return COMP_PADD_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_PADD_SEQ_NO() {
		return COMP_PADD_SEQ_NO;
	}

	public void setCOMP_PADD_SEQ_NO_LABEL(HtmlOutputLabel COMP_PADD_SEQ_NO_LABEL) {
		this.COMP_PADD_SEQ_NO_LABEL = COMP_PADD_SEQ_NO_LABEL;
	}

	public void setCOMP_PADD_SEQ_NO(HtmlInputText COMP_PADD_SEQ_NO) {
		this.COMP_PADD_SEQ_NO = COMP_PADD_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_PADD_DOC_DT_LABEL() {
		return COMP_PADD_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PADD_DOC_DT() {
		return COMP_PADD_DOC_DT;
	}

	public void setCOMP_PADD_DOC_DT_LABEL(HtmlOutputLabel COMP_PADD_DOC_DT_LABEL) {
		this.COMP_PADD_DOC_DT_LABEL = COMP_PADD_DOC_DT_LABEL;
	}

	public void setCOMP_PADD_DOC_DT(HtmlCalendar COMP_PADD_DOC_DT) {
		this.COMP_PADD_DOC_DT = COMP_PADD_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_PADD_FC_AMT_LABEL() {
		return COMP_PADD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PADD_FC_AMT() {
		return COMP_PADD_FC_AMT;
	}

	public void setCOMP_PADD_FC_AMT_LABEL(HtmlOutputLabel COMP_PADD_FC_AMT_LABEL) {
		this.COMP_PADD_FC_AMT_LABEL = COMP_PADD_FC_AMT_LABEL;
	}

	public void setCOMP_PADD_FC_AMT(HtmlInputText COMP_PADD_FC_AMT) {
		this.COMP_PADD_FC_AMT = COMP_PADD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PADD_LC_AMT_LABEL() {
		return COMP_PADD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PADD_LC_AMT() {
		return COMP_PADD_LC_AMT;
	}

	public void setCOMP_PADD_LC_AMT_LABEL(HtmlOutputLabel COMP_PADD_LC_AMT_LABEL) {
		this.COMP_PADD_LC_AMT_LABEL = COMP_PADD_LC_AMT_LABEL;
	}

	public void setCOMP_PADD_LC_AMT(HtmlInputText COMP_PADD_LC_AMT) {
		this.COMP_PADD_LC_AMT = COMP_PADD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PADD_POL_NO_LABEL() {
		return COMP_PADD_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PADD_POL_NO() {
		return COMP_PADD_POL_NO;
	}

	public void setCOMP_PADD_POL_NO_LABEL(HtmlOutputLabel COMP_PADD_POL_NO_LABEL) {
		this.COMP_PADD_POL_NO_LABEL = COMP_PADD_POL_NO_LABEL;
	}

	public void setCOMP_PADD_POL_NO(HtmlInputText COMP_PADD_POL_NO) {
		this.COMP_PADD_POL_NO = COMP_PADD_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PADD_CLAIM_NO_LABEL() {
		return COMP_PADD_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_PADD_CLAIM_NO() {
		return COMP_PADD_CLAIM_NO;
	}

	public void setCOMP_PADD_CLAIM_NO_LABEL(
			HtmlOutputLabel COMP_PADD_CLAIM_NO_LABEL) {
		this.COMP_PADD_CLAIM_NO_LABEL = COMP_PADD_CLAIM_NO_LABEL;
	}

	public void setCOMP_PADD_CLAIM_NO(HtmlInputText COMP_PADD_CLAIM_NO) {
		this.COMP_PADD_CLAIM_NO = COMP_PADD_CLAIM_NO;
	}

	public HtmlOutputLabel getCOMP_PADD_SELECTED_YN_LABEL() {
		return COMP_PADD_SELECTED_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PADD_SELECTED_YN() {
		return COMP_PADD_SELECTED_YN;
	}

	public void setCOMP_PADD_SELECTED_YN_LABEL(
			HtmlOutputLabel COMP_PADD_SELECTED_YN_LABEL) {
		this.COMP_PADD_SELECTED_YN_LABEL = COMP_PADD_SELECTED_YN_LABEL;
	}

	public void setCOMP_PADD_SELECTED_YN(HtmlSelectOneMenu COMP_PADD_SELECTED_YN) {
		this.COMP_PADD_SELECTED_YN = COMP_PADD_SELECTED_YN;
	}

	public PT_IL_PAYVOU_DRCR_DTL getPT_IL_PAYVOU_DRCR_DTL_BEAN() {
		return PT_IL_PAYVOU_DRCR_DTL_BEAN;
	}

	public void setPT_IL_PAYVOU_DRCR_DTL_BEAN(
			PT_IL_PAYVOU_DRCR_DTL PT_IL_PAYVOU_DRCR_DTL_BEAN) {
		this.PT_IL_PAYVOU_DRCR_DTL_BEAN = PT_IL_PAYVOU_DRCR_DTL_BEAN;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event) {
		if (!isOnLoadFlag()) {
			getErrorMap().clear();
			PT_IL_PAYVOU_DRCR_DTL_HELPER helper = new PT_IL_PAYVOU_DRCR_DTL_HELPER();
			helper.whenNewBlockInstance();
			setOnLoadFlag(true);
		}
	}

	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.keyCommit();
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
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

	public void saveRecord(ActionEvent actionEvent) {
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.keyCommit();
			PILT030_APAC_ACTION_INSTANCE.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	
	
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_DRCR_DTL_BEAN = new PT_IL_PAYVOU_DRCR_DTL();
				this.setPT_IL_PAYVOU_DRCR_DTL_BEAN(PT_IL_PAYVOU_DRCR_DTL_BEAN);
				resetAllComponent();
				resetSelectedRow();
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
	

	public void getDetails() {
		System.out.println("----Get Details() Method Executed---------");
		getErrorMap().clear();
		try {
			if (PT_IL_PAYVOU_DRCR_DTL_LIST.size() != 0) {
				PT_IL_PAYVOU_DRCR_DTL_BEAN = (PT_IL_PAYVOU_DRCR_DTL) PT_IL_PAYVOU_DRCR_DTL_DT
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_PAYVOU_DRCR_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {

		COMP_PADD_MAIN_ACNT_CODE.resetValue();
		COMP_PADD_SUB_ACNT_CODE.resetValue();
		COMP_PADD_ANLY_CODE_1.resetValue();
		COMP_PADD_ANLY_CODE_2.resetValue();
		// COMP_PADD_CUST_CODE.resetValue();
		COMP_UI_M_PADD_CUST_DESC.resetValue();
		COMP_PADD_DRCR_FLAG.resetValue();
		COMP_PADD_TXN_CODE.resetValue();
		COMP_PADD_DOC_NO.resetValue();
		COMP_PADD_SEQ_NO.resetValue();
		COMP_PADD_DOC_DT.resetValue();
		COMP_PADD_FC_AMT.resetValue();
		COMP_PADD_LC_AMT.resetValue();
		COMP_PADD_POL_NO.resetValue();
		COMP_PADD_CLAIM_NO.resetValue();

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PAYVOU_DRCR_DTL> iterator = PT_IL_PAYVOU_DRCR_DTL_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	
	public void post(ActionEvent event) {
		
		try {
			if (PT_IL_PAYVOU_DRCR_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				new CRUDHandler().executeInsert(PT_IL_PAYVOU_DRCR_DTL_BEAN,
						CommonUtils.getConnection());
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
				PT_IL_PAYVOU_DRCR_DTL_LIST.add(PT_IL_PAYVOU_DRCR_DTL_BEAN);
			} else if (PT_IL_PAYVOU_DRCR_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				new CRUDHandler().executeUpdate(PT_IL_PAYVOU_DRCR_DTL_BEAN,
						CommonUtils.getConnection());
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

			PT_IL_PAYVOU_DRCR_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	/*public void post(ActionEvent ae) {
		PT_IL_PAYVOU_DRCR_DTL_BEAN = this.getPT_IL_PAYVOU_DRCR_DTL_BEAN();
		CommonUtils commonUtils = new CommonUtils();

		try {
			if (PT_IL_PAYVOU_DRCR_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					new CRUDHandler().executeInsert(PT_IL_PAYVOU_DRCR_DTL_BEAN,
							new CommonUtils().getConnection());
					new CommonUtils().getConnection().commit();
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
					new CRUDHandler().executeInsert(PT_IL_PAYVOU_DRCR_DTL_BEAN,
							commonUtils.getConnection());
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
					PT_IL_PAYVOU_DRCR_DTL_LIST.add(PT_IL_PAYVOU_DRCR_DTL_BEAN);
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

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/
	
	
	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PAYVOU_DRCR_DTL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PAYVOU_DRCR_DTL_BEAN,
							CommonUtils.getConnection());
					PT_IL_PAYVOU_DRCR_DTL_LIST.remove(PT_IL_PAYVOU_DRCR_DTL_BEAN);
				}

				if (PT_IL_PAYVOU_DRCR_DTL_LIST.size() > 0) {
					setPT_IL_PAYVOU_DRCR_DTL_BEAN(PT_IL_PAYVOU_DRCR_DTL_LIST
							.get(0));
					
				} else {
					AddRow(null);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setRowSelected(true);

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	

	/*public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PAYVOU_DRCR_DTL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PAYVOU_DRCR_DTL_BEAN,
							CommonUtils.getConnection());
					PT_IL_PAYVOU_DRCR_DTL_LIST
							.remove(PT_IL_PAYVOU_DRCR_DTL_BEAN);
				}

				if (PT_IL_PAYVOU_DRCR_DTL_LIST.size() > 0) {
					setPT_IL_PAYVOU_DRCR_DTL_BEAN(PT_IL_PAYVOU_DRCR_DTL_LIST
							.get(0));
					PT_IL_PAYVOU_DRCR_DTL_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}*/

}

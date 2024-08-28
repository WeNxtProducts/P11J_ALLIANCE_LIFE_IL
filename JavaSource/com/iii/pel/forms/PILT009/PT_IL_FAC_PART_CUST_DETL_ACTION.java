package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_PART_CUST_DETL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FPCUD_COVER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FPCUD_COVER_CODE;
	
	private HtmlInputText COMP_UI_M_FPCUD_COVER_DESC;
	
	private HtmlOutputLabel COMP_UI_M_FPCUD_CUST_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FPCUD_CUST_CODE;
	
	private HtmlInputText COMP_UI_M_FPCUD_CUST_DESC;
	
	private HtmlOutputLabel COMP_FPCUD_FC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_FPCUD_FC_SUM_ASSURED;

	private HtmlOutputLabel COMP_FPCUD_FC_PREM_LABEL;

	private HtmlInputText COMP_FPCUD_FC_PREM;

	private HtmlOutputLabel COMP_FPCUD_FC_COMM_LABEL;

	private HtmlInputText COMP_FPCUD_FC_COMM;

	private HtmlOutputLabel COMP_FPCUD_FC_TAX_LABEL;

	private HtmlInputText COMP_FPCUD_FC_TAX;

	private HtmlOutputLabel COMP_FPCUD_SCHD_DT_LABEL;

	private HtmlCalendar COMP_FPCUD_SCHD_DT;

	private HtmlOutputLabel COMP_FPCUD_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_FPCUD_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_FPCUD_LC_COMM_LABEL;

	private HtmlInputText COMP_FPCUD_LC_COMM;

	private HtmlOutputLabel COMP_FPCUD_LC_PREM_LABEL;

	private HtmlInputText COMP_FPCUD_LC_PREM;

	private HtmlOutputLabel COMP_FPCUD_LC_TAX_LABEL;

	private HtmlInputText COMP_FPCUD_LC_TAX;
	
	private HtmlCommandButton COMP_UI_M_BUT_CHARGE_DTLS;

	private PT_IL_FAC_PART_CUST PT_IL_FAC_PART_CUST_BEAN;
	
	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;
	
	private PT_IL_FAC_PART_CUST_DETL  PT_IL_FAC_PART_CUST_DETL_BEAN;

	private List<PT_IL_FAC_PART_CUST_DETL> dataListPT_IL_FAC_PART_CUST_DETL = null;
	
	private UIData dataTable;
	
	private boolean onLoadFlag;

	PILT009_COMPOSITE_ACTION compositeAction;
	
	public PT_IL_FAC_PART_CUST_DETL_ACTION() {
		dataListPT_IL_FAC_PART_CUST_DETL = new ArrayList<PT_IL_FAC_PART_CUST_DETL>();
		  PT_IL_FAC_PART_CUST_DETL_BEAN = new PT_IL_FAC_PART_CUST_DETL();
		  instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_FPCUD_FC_SUM_ASSURED_LABEL() {
		return COMP_FPCUD_FC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_FC_SUM_ASSURED() {
		return COMP_FPCUD_FC_SUM_ASSURED;
	}

	public void setCOMP_FPCUD_FC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_FPCUD_FC_SUM_ASSURED_LABEL) {
		this.COMP_FPCUD_FC_SUM_ASSURED_LABEL = COMP_FPCUD_FC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_FPCUD_FC_SUM_ASSURED(HtmlInputText COMP_FPCUD_FC_SUM_ASSURED) {
		this.COMP_FPCUD_FC_SUM_ASSURED = COMP_FPCUD_FC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_FPCUD_FC_PREM_LABEL() {
		return COMP_FPCUD_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_FC_PREM() {
		return COMP_FPCUD_FC_PREM;
	}

	public void setCOMP_FPCUD_FC_PREM_LABEL(HtmlOutputLabel COMP_FPCUD_FC_PREM_LABEL) {
		this.COMP_FPCUD_FC_PREM_LABEL = COMP_FPCUD_FC_PREM_LABEL;
	}

	public void setCOMP_FPCUD_FC_PREM(HtmlInputText COMP_FPCUD_FC_PREM) {
		this.COMP_FPCUD_FC_PREM = COMP_FPCUD_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_FPCUD_FC_COMM_LABEL() {
		return COMP_FPCUD_FC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_FC_COMM() {
		return COMP_FPCUD_FC_COMM;
	}

	public void setCOMP_FPCUD_FC_COMM_LABEL(HtmlOutputLabel COMP_FPCUD_FC_COMM_LABEL) {
		this.COMP_FPCUD_FC_COMM_LABEL = COMP_FPCUD_FC_COMM_LABEL;
	}

	public void setCOMP_FPCUD_FC_COMM(HtmlInputText COMP_FPCUD_FC_COMM) {
		this.COMP_FPCUD_FC_COMM = COMP_FPCUD_FC_COMM;
	}

	public HtmlOutputLabel getCOMP_FPCUD_FC_TAX_LABEL() {
		return COMP_FPCUD_FC_TAX_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_FC_TAX() {
		return COMP_FPCUD_FC_TAX;
	}

	public void setCOMP_FPCUD_FC_TAX_LABEL(HtmlOutputLabel COMP_FPCUD_FC_TAX_LABEL) {
		this.COMP_FPCUD_FC_TAX_LABEL = COMP_FPCUD_FC_TAX_LABEL;
	}

	public void setCOMP_FPCUD_FC_TAX(HtmlInputText COMP_FPCUD_FC_TAX) {
		this.COMP_FPCUD_FC_TAX = COMP_FPCUD_FC_TAX;
	}

	public HtmlOutputLabel getCOMP_FPCUD_SCHD_DT_LABEL() {
		return COMP_FPCUD_SCHD_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FPCUD_SCHD_DT() {
		return COMP_FPCUD_SCHD_DT;
	}

	public void setCOMP_FPCUD_SCHD_DT_LABEL(HtmlOutputLabel COMP_FPCUD_SCHD_DT_LABEL) {
		this.COMP_FPCUD_SCHD_DT_LABEL = COMP_FPCUD_SCHD_DT_LABEL;
	}

	public void setCOMP_FPCUD_SCHD_DT(HtmlCalendar COMP_FPCUD_SCHD_DT) {
		this.COMP_FPCUD_SCHD_DT = COMP_FPCUD_SCHD_DT;
	}

	public HtmlOutputLabel getCOMP_FPCUD_LC_SUM_ASSURED_LABEL() {
		return COMP_FPCUD_LC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_LC_SUM_ASSURED() {
		return COMP_FPCUD_LC_SUM_ASSURED;
	}

	public void setCOMP_FPCUD_LC_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_FPCUD_LC_SUM_ASSURED_LABEL) {
		this.COMP_FPCUD_LC_SUM_ASSURED_LABEL = COMP_FPCUD_LC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_FPCUD_LC_SUM_ASSURED(HtmlInputText COMP_FPCUD_LC_SUM_ASSURED) {
		this.COMP_FPCUD_LC_SUM_ASSURED = COMP_FPCUD_LC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_FPCUD_LC_COMM_LABEL() {
		return COMP_FPCUD_LC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_LC_COMM() {
		return COMP_FPCUD_LC_COMM;
	}

	public void setCOMP_FPCUD_LC_COMM_LABEL(HtmlOutputLabel COMP_FPCUD_LC_COMM_LABEL) {
		this.COMP_FPCUD_LC_COMM_LABEL = COMP_FPCUD_LC_COMM_LABEL;
	}

	public void setCOMP_FPCUD_LC_COMM(HtmlInputText COMP_FPCUD_LC_COMM) {
		this.COMP_FPCUD_LC_COMM = COMP_FPCUD_LC_COMM;
	}

	public HtmlOutputLabel getCOMP_FPCUD_LC_PREM_LABEL() {
		return COMP_FPCUD_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_LC_PREM() {
		return COMP_FPCUD_LC_PREM;
	}

	public void setCOMP_FPCUD_LC_PREM_LABEL(HtmlOutputLabel COMP_FPCUD_LC_PREM_LABEL) {
		this.COMP_FPCUD_LC_PREM_LABEL = COMP_FPCUD_LC_PREM_LABEL;
	}

	public void setCOMP_FPCUD_LC_PREM(HtmlInputText COMP_FPCUD_LC_PREM) {
		this.COMP_FPCUD_LC_PREM = COMP_FPCUD_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_FPCUD_LC_TAX_LABEL() {
		return COMP_FPCUD_LC_TAX_LABEL;
	}

	public HtmlInputText getCOMP_FPCUD_LC_TAX() {
		return COMP_FPCUD_LC_TAX;
	}

	public void setCOMP_FPCUD_LC_TAX_LABEL(HtmlOutputLabel COMP_FPCUD_LC_TAX_LABEL) {
		this.COMP_FPCUD_LC_TAX_LABEL = COMP_FPCUD_LC_TAX_LABEL;
	}

	public void setCOMP_FPCUD_LC_TAX(HtmlInputText COMP_FPCUD_LC_TAX) {
		this.COMP_FPCUD_LC_TAX = COMP_FPCUD_LC_TAX;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHARGE_DTLS() {
		return COMP_UI_M_BUT_CHARGE_DTLS;
	}

	public void setCOMP_UI_M_BUT_CHARGE_DTLS(
			HtmlCommandButton comp_ui_m_but_charge_dtls) {
		COMP_UI_M_BUT_CHARGE_DTLS = comp_ui_m_but_charge_dtls;
	}

	public PT_IL_FAC_PART_CUST getPT_IL_FAC_PART_CUST_BEAN() {
		return PT_IL_FAC_PART_CUST_BEAN;
	}

	public void setPT_IL_FAC_PART_CUST_BEAN(
			PT_IL_FAC_PART_CUST pt_il_fac_part_cust_bean) {
		PT_IL_FAC_PART_CUST_BEAN = pt_il_fac_part_cust_bean;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public List<PT_IL_FAC_PART_CUST_DETL> getDataListPT_IL_FAC_PART_CUST_DETL() {
		return dataListPT_IL_FAC_PART_CUST_DETL;
	}

	public void setDataListPT_IL_FAC_PART_CUST_DETL(
			List<PT_IL_FAC_PART_CUST_DETL> dataListPT_IL_FAC_PART_CUST_DETL) {
		this.dataListPT_IL_FAC_PART_CUST_DETL = dataListPT_IL_FAC_PART_CUST_DETL;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_COVER_CODE_LABEL() {
		return COMP_UI_M_FPCUD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fpcud_cover_code_label) {
		COMP_UI_M_FPCUD_COVER_CODE_LABEL = comp_ui_m_fpcud_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_COVER_CODE() {
		return COMP_UI_M_FPCUD_COVER_CODE;
	}

	public void setCOMP_UI_M_FPCUD_COVER_CODE(
			HtmlInputText comp_ui_m_fpcud_cover_code) {
		COMP_UI_M_FPCUD_COVER_CODE = comp_ui_m_fpcud_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_COVER_DESC() {
		return COMP_UI_M_FPCUD_COVER_DESC;
	}

	public void setCOMP_UI_M_FPCUD_COVER_DESC(
			HtmlInputText comp_ui_m_fpcud_cover_desc) {
		COMP_UI_M_FPCUD_COVER_DESC = comp_ui_m_fpcud_cover_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_CUST_CODE_LABEL() {
		return COMP_UI_M_FPCUD_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_CUST_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fpcud_cust_code_label) {
		COMP_UI_M_FPCUD_CUST_CODE_LABEL = comp_ui_m_fpcud_cust_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_CUST_CODE() {
		return COMP_UI_M_FPCUD_CUST_CODE;
	}

	public void setCOMP_UI_M_FPCUD_CUST_CODE(HtmlInputText comp_ui_m_fpcud_cust_code) {
		COMP_UI_M_FPCUD_CUST_CODE = comp_ui_m_fpcud_cust_code;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_CUST_DESC() {
		return COMP_UI_M_FPCUD_CUST_DESC;
	}

	public void setCOMP_UI_M_FPCUD_CUST_DESC(HtmlInputText comp_ui_m_fpcud_cust_desc) {
		COMP_UI_M_FPCUD_CUST_DESC = comp_ui_m_fpcud_cust_desc;
	}

	public void onPageLoad(PhaseEvent event) {
		
		if (isBlockFlag()) {
			PT_IL_FAC_PART_CUST_DETL_HELPER helper = new PT_IL_FAC_PART_CUST_DETL_HELPER();
			try {
				helper.fetchRecord(this);
				COMP_FPCUD_LC_PREM.resetValue();
				COMP_UI_M_FPCUD_COVER_CODE.resetValue();
				COMP_UI_M_FPCUD_CUST_CODE.resetValue();
				COMP_FPCUD_SCHD_DT.resetValue();
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current",
						"Error occured while loading the page");
				getErrorMap().put("detail",
						"Error occured while loading the page");
			}
			//setOnLoadFlag(true);
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_FAC_PART_CUST_DETL_BEAN = (PT_IL_FAC_PART_CUST_DETL) dataTable
					.getRowData();
			PT_IL_FAC_PART_CUST_DETL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_FAC_PART_CUST_DETL> PT_IL_POL_BROKER_DTL_ITR = dataListPT_IL_FAC_PART_CUST_DETL
				.iterator();
		while (PT_IL_POL_BROKER_DTL_ITR.hasNext()) {
			PT_IL_POL_BROKER_DTL_ITR.next().setRowSelected(false);
		}
	}

	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_FPCUD_COVER_CODE.resetValue();
		COMP_UI_M_FPCUD_COVER_DESC.resetValue();
		COMP_UI_M_FPCUD_CUST_CODE.resetValue();
		COMP_UI_M_FPCUD_CUST_DESC.resetValue();
		COMP_FPCUD_FC_SUM_ASSURED.resetValue();
		COMP_FPCUD_FC_PREM.resetValue();
		COMP_FPCUD_FC_COMM.resetValue();
		COMP_FPCUD_FC_TAX.resetValue();
		COMP_FPCUD_LC_SUM_ASSURED.resetValue();
		COMP_FPCUD_LC_COMM.resetValue();
		COMP_FPCUD_LC_PREM.resetValue();
		COMP_FPCUD_LC_TAX.resetValue();

		// Reseting HtmlCalendar
		COMP_FPCUD_SCHD_DT.resetValue();

		// Reseting HtmlCommandButton

	}
	

	/**
	 * Instantiates all components in PT_IL_FAC_PART_CUST_DETL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_FPCUD_COVER_CODE			 = new HtmlInputText();
		COMP_UI_M_FPCUD_COVER_DESC			 = new HtmlInputText();
		COMP_UI_M_FPCUD_CUST_CODE			 = new HtmlInputText();
		COMP_UI_M_FPCUD_CUST_DESC			 = new HtmlInputText();
		COMP_FPCUD_FC_SUM_ASSURED			 = new HtmlInputText();
		COMP_FPCUD_FC_PREM				 = new HtmlInputText();
		COMP_FPCUD_FC_COMM				 = new HtmlInputText();
		COMP_FPCUD_FC_TAX				 = new HtmlInputText();
		COMP_FPCUD_LC_SUM_ASSURED			 = new HtmlInputText();
		COMP_FPCUD_LC_COMM				 = new HtmlInputText();
		COMP_FPCUD_LC_PREM				 = new HtmlInputText();
		COMP_FPCUD_LC_TAX				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_FPCUD_SCHD_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_CHARGE_DTLS			 = new HtmlCommandButton();

	}


	
	public void checkBoxStatus(ActionEvent actionEvent)	{

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataListPT_IL_FAC_PART_CUST_DETL().get(rowIndex).setCHECK_BOX(check);
	}
	
	private String getCurrentValue(ActionEvent event) {
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
	
	private PT_IL_FAC_PART_CUST_DETL getSelectedBean() throws Exception {

		PT_IL_FAC_PART_CUST_DETL facPartCustDtlBean = null;
		int clickCount = 0;

		for(PT_IL_FAC_PART_CUST_DETL tempBean : getDataListPT_IL_FAC_PART_CUST_DETL()) {

			if(tempBean.isCHECK_BOX()) {
				facPartCustDtlBean = tempBean;
				clickCount++;
			}
		}

		if(clickCount < 1) {
			throw new Exception("Please select one row");
		} else if(clickCount > 1) {
			throw new Exception("Please select only one row");
		}

		return facPartCustDtlBean;
	}
	
	public String backToFAC_CUST() {
		
		return "gotoFacPartCust";
	}
	
	public String callChargeDtls() {

		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			PT_IL_FAC_PART_CUST_DETL facPartCustDtlBean = getPT_IL_FAC_PART_CUST_DETL_BEAN();
			
			compositeAction.getPILT009_PT_IL_FAC_PART_CHRG_ACTION().setPT_IL_FAC_PART_CUST_DETL_BEAN(facPartCustDtlBean);
			compositeAction.getPILT009_PT_IL_FAC_PART_CHRG_ACTION().setPT_IL_FAC_OUT_BEAN(getPT_IL_FAC_OUT_BEAN());
			compositeAction.getPILT009_PT_IL_FAC_PART_CHRG_ACTION().setPT_IL_FAC_PART_CUST_BEAN(getPT_IL_FAC_PART_CUST_BEAN());
			
			returnValue = "gotoFacChargeDtls";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
	}

	public PT_IL_FAC_PART_CUST_DETL getPT_IL_FAC_PART_CUST_DETL_BEAN() {
		return PT_IL_FAC_PART_CUST_DETL_BEAN;
	}

	public void setPT_IL_FAC_PART_CUST_DETL_BEAN(
			PT_IL_FAC_PART_CUST_DETL pt_il_fac_part_cust_detl_bean) {
		PT_IL_FAC_PART_CUST_DETL_BEAN = pt_il_fac_part_cust_detl_bean;
	}
}

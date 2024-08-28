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

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CUST_RETRO_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FCR_COVER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FCR_COVER_CODE;
	
	private HtmlInputText COMP_UI_M_FCR_COVER_DESC;
	
	private HtmlOutputLabel COMP_FCR_SHARE_PERC_LABEL;

	private HtmlInputText COMP_FCR_SHARE_PERC;

	private HtmlOutputLabel COMP_FCR_RETRO_COMM_FIRST_YR_LABEL;

	private HtmlInputText COMP_FCR_RETRO_COMM_FIRST_YR;

	private HtmlOutputLabel COMP_FCR_RETRO_COMM_SUB_YRS_LABEL;

	private HtmlInputText COMP_FCR_RETRO_COMM_SUB_YRS;

	private HtmlOutputLabel COMP_FCR_RETRO_TAX_FIRST_YR_LABEL;

	private HtmlInputText COMP_FCR_RETRO_TAX_FIRST_YR;

	private HtmlOutputLabel COMP_FCR_RETRO_TAX_SUB_YRS_LABEL;

	private HtmlInputText COMP_FCR_RETRO_TAX_SUB_YRS;

	private HtmlOutputLabel COMP_FCR_REF_NO_LABEL;

	private HtmlInputText COMP_FCR_REF_NO;
	
	private HtmlCommandButton COMP_UI_M_BUT_CUST_RETRO_DTLS;

	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;
	
	private PT_IL_FAC_CUST_RETRO PT_IL_FAC_CUST_RETRO_BEAN; 

	private List<PT_IL_FAC_CUST_RETRO> dataListPT_IL_FAC_CUST_RETRO = null;

	private UIData dataTable;
	
	private boolean onLoadFlag;
	
	PILT009_COMPOSITE_ACTION compositeAction;
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public PT_IL_FAC_CUST_RETRO_ACTION() {
		dataListPT_IL_FAC_CUST_RETRO = new ArrayList<PT_IL_FAC_CUST_RETRO>();
		PT_IL_FAC_CUST_RETRO_BEAN=new PT_IL_FAC_CUST_RETRO();
	}

	public HtmlOutputLabel getCOMP_FCR_SHARE_PERC_LABEL() {
		return COMP_FCR_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FCR_SHARE_PERC() {
		return COMP_FCR_SHARE_PERC;
	}

	public void setCOMP_FCR_SHARE_PERC_LABEL(HtmlOutputLabel COMP_FCR_SHARE_PERC_LABEL) {
		this.COMP_FCR_SHARE_PERC_LABEL = COMP_FCR_SHARE_PERC_LABEL;
	}

	public void setCOMP_FCR_SHARE_PERC(HtmlInputText COMP_FCR_SHARE_PERC) {
		this.COMP_FCR_SHARE_PERC = COMP_FCR_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_FCR_RETRO_COMM_FIRST_YR_LABEL() {
		return COMP_FCR_RETRO_COMM_FIRST_YR_LABEL;
	}

	public HtmlInputText getCOMP_FCR_RETRO_COMM_FIRST_YR() {
		return COMP_FCR_RETRO_COMM_FIRST_YR;
	}

	public void setCOMP_FCR_RETRO_COMM_FIRST_YR_LABEL(HtmlOutputLabel COMP_FCR_RETRO_COMM_FIRST_YR_LABEL) {
		this.COMP_FCR_RETRO_COMM_FIRST_YR_LABEL = COMP_FCR_RETRO_COMM_FIRST_YR_LABEL;
	}

	public void setCOMP_FCR_RETRO_COMM_FIRST_YR(HtmlInputText COMP_FCR_RETRO_COMM_FIRST_YR) {
		this.COMP_FCR_RETRO_COMM_FIRST_YR = COMP_FCR_RETRO_COMM_FIRST_YR;
	}

	public HtmlOutputLabel getCOMP_FCR_RETRO_COMM_SUB_YRS_LABEL() {
		return COMP_FCR_RETRO_COMM_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_FCR_RETRO_COMM_SUB_YRS() {
		return COMP_FCR_RETRO_COMM_SUB_YRS;
	}

	public void setCOMP_FCR_RETRO_COMM_SUB_YRS_LABEL(HtmlOutputLabel COMP_FCR_RETRO_COMM_SUB_YRS_LABEL) {
		this.COMP_FCR_RETRO_COMM_SUB_YRS_LABEL = COMP_FCR_RETRO_COMM_SUB_YRS_LABEL;
	}

	public void setCOMP_FCR_RETRO_COMM_SUB_YRS(HtmlInputText COMP_FCR_RETRO_COMM_SUB_YRS) {
		this.COMP_FCR_RETRO_COMM_SUB_YRS = COMP_FCR_RETRO_COMM_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_FCR_RETRO_TAX_FIRST_YR_LABEL() {
		return COMP_FCR_RETRO_TAX_FIRST_YR_LABEL;
	}

	public HtmlInputText getCOMP_FCR_RETRO_TAX_FIRST_YR() {
		return COMP_FCR_RETRO_TAX_FIRST_YR;
	}

	public void setCOMP_FCR_RETRO_TAX_FIRST_YR_LABEL(HtmlOutputLabel COMP_FCR_RETRO_TAX_FIRST_YR_LABEL) {
		this.COMP_FCR_RETRO_TAX_FIRST_YR_LABEL = COMP_FCR_RETRO_TAX_FIRST_YR_LABEL;
	}

	public void setCOMP_FCR_RETRO_TAX_FIRST_YR(HtmlInputText COMP_FCR_RETRO_TAX_FIRST_YR) {
		this.COMP_FCR_RETRO_TAX_FIRST_YR = COMP_FCR_RETRO_TAX_FIRST_YR;
	}

	public HtmlOutputLabel getCOMP_FCR_RETRO_TAX_SUB_YRS_LABEL() {
		return COMP_FCR_RETRO_TAX_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_FCR_RETRO_TAX_SUB_YRS() {
		return COMP_FCR_RETRO_TAX_SUB_YRS;
	}

	public void setCOMP_FCR_RETRO_TAX_SUB_YRS_LABEL(HtmlOutputLabel COMP_FCR_RETRO_TAX_SUB_YRS_LABEL) {
		this.COMP_FCR_RETRO_TAX_SUB_YRS_LABEL = COMP_FCR_RETRO_TAX_SUB_YRS_LABEL;
	}

	public void setCOMP_FCR_RETRO_TAX_SUB_YRS(HtmlInputText COMP_FCR_RETRO_TAX_SUB_YRS) {
		this.COMP_FCR_RETRO_TAX_SUB_YRS = COMP_FCR_RETRO_TAX_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_FCR_REF_NO_LABEL() {
		return COMP_FCR_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_FCR_REF_NO() {
		return COMP_FCR_REF_NO;
	}

	public void setCOMP_FCR_REF_NO_LABEL(HtmlOutputLabel COMP_FCR_REF_NO_LABEL) {
		this.COMP_FCR_REF_NO_LABEL = COMP_FCR_REF_NO_LABEL;
	}

	public void setCOMP_FCR_REF_NO(HtmlInputText COMP_FCR_REF_NO) {
		this.COMP_FCR_REF_NO = COMP_FCR_REF_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCR_COVER_CODE_LABEL() {
		return COMP_UI_M_FCR_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FCR_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fcr_cover_code_label) {
		COMP_UI_M_FCR_COVER_CODE_LABEL = comp_ui_m_fcr_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FCR_COVER_CODE() {
		return COMP_UI_M_FCR_COVER_CODE;
	}

	public void setCOMP_UI_M_FCR_COVER_CODE(HtmlInputText comp_ui_m_fcr_cover_code) {
		COMP_UI_M_FCR_COVER_CODE = comp_ui_m_fcr_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FCR_COVER_DESC() {
		return COMP_UI_M_FCR_COVER_DESC;
	}

	public void setCOMP_UI_M_FCR_COVER_DESC(HtmlInputText comp_ui_m_fcr_cover_desc) {
		COMP_UI_M_FCR_COVER_DESC = comp_ui_m_fcr_cover_desc;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_RETRO_DTLS() {
		return COMP_UI_M_BUT_CUST_RETRO_DTLS;
	}

	public void setCOMP_UI_M_BUT_CUST_RETRO_DTLS(
			HtmlCommandButton comp_ui_m_but_cust_retro_dtls) {
		COMP_UI_M_BUT_CUST_RETRO_DTLS = comp_ui_m_but_cust_retro_dtls;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public List<PT_IL_FAC_CUST_RETRO> getDataListPT_IL_FAC_CUST_RETRO() {
		return dataListPT_IL_FAC_CUST_RETRO;
	}

	public void setDataListPT_IL_FAC_CUST_RETRO(
			List<PT_IL_FAC_CUST_RETRO> dataListPT_IL_FAC_CUST_RETRO) {
		this.dataListPT_IL_FAC_CUST_RETRO = dataListPT_IL_FAC_CUST_RETRO;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public String backToFAC_OUT() {
				return "gotoFacOut";
	}
	
	public void onPageLoad(PhaseEvent event) {
		
		if (!isOnLoadFlag()) {
			PT_IL_FAC_CUST_RETRO_HELPER helper = new PT_IL_FAC_CUST_RETRO_HELPER();
			try {
				helper.fetchRecord(this);
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
	
	private PT_IL_FAC_CUST_RETRO getSelectedBean() throws Exception {

		PT_IL_FAC_CUST_RETRO facPartCustRetroBean = null;
		int clickCount = 0;

		for(PT_IL_FAC_CUST_RETRO tempBean : getDataListPT_IL_FAC_CUST_RETRO()) {

			if(tempBean.isCHECK_BOX()) {
				facPartCustRetroBean = tempBean;
				clickCount++;
			}
		}

		if(clickCount < 1) {
			throw new Exception("Please select one row");
		} else if(clickCount > 1) {
			throw new Exception("Please select only one row");
		}

		return facPartCustRetroBean;
	}
	
	public String callCustRetroDtls() {

		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			
			PT_IL_FAC_CUST_RETRO facPartCustRetroBean = getPT_IL_FAC_CUST_RETRO_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_DETL_ACTION().setPT_IL_FAC_CUST_RETRO_BEAN(facPartCustRetroBean);
			compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_DETL_ACTION().setPT_IL_FAC_OUT_BEAN(getPT_IL_FAC_OUT_BEAN());
			returnValue = "gotoCustRetroDtls";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
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
	
	public void checkBoxStatus(ActionEvent actionEvent)	{

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataListPT_IL_FAC_CUST_RETRO().get(rowIndex).setCHECK_BOX(check);
	}

	public PT_IL_FAC_CUST_RETRO getPT_IL_FAC_CUST_RETRO_BEAN() {
		return PT_IL_FAC_CUST_RETRO_BEAN;
	}

	public void setPT_IL_FAC_CUST_RETRO_BEAN(
			PT_IL_FAC_CUST_RETRO pt_il_fac_cust_retro_bean) {
		PT_IL_FAC_CUST_RETRO_BEAN = pt_il_fac_cust_retro_bean;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_CUST_RETRO_BEAN = (PT_IL_FAC_CUST_RETRO) dataTable
					.getRowData();
			resetSelectedRow();
			resetAllComponent();
			PT_IL_FAC_CUST_RETRO_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_CUST_RETRO> iterator = dataListPT_IL_FAC_CUST_RETRO
				.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_FCR_COVER_CODE.resetValue();
		COMP_UI_M_FCR_COVER_DESC.resetValue();
		COMP_FCR_SHARE_PERC.resetValue();
		COMP_FCR_RETRO_COMM_FIRST_YR.resetValue();
		COMP_FCR_RETRO_COMM_SUB_YRS.resetValue();
		COMP_FCR_RETRO_TAX_FIRST_YR.resetValue();
		COMP_FCR_RETRO_TAX_SUB_YRS.resetValue();
		COMP_FCR_REF_NO.resetValue();

	}
}

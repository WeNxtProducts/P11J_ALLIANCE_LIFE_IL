package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FAC_PART_CUST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FPCU_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FPCU_COVER_CODE;

	private HtmlInputText COMP_UI_M_FPCU_COVER_DESC;

	private HtmlOutputLabel COMP_FPCU_CUST_CODE_LABEL;

	private HtmlInputText COMP_FPCU_CUST_CODE;

	private HtmlOutputLabel COMP_FPCU_RETRO_YN_LABEL;

	private HtmlSelectOneMenu COMP_FPCU_RETRO_YN;

	private HtmlOutputLabel COMP_FPCU_SHARE_PERC_LABEL;

	private HtmlInputText COMP_FPCU_SHARE_PERC;

	private HtmlOutputLabel COMP_FPCU_COMM_FIRST_YR_LABEL;

	private HtmlInputText COMP_FPCU_COMM_FIRST_YR;

	private HtmlOutputLabel COMP_FPCU_COMM_SUB_YRS_LABEL;

	private HtmlInputText COMP_FPCU_COMM_SUB_YRS;

	private HtmlOutputLabel COMP_FPCU_TAX_FIRST_YR_LABEL;

	private HtmlInputText COMP_FPCU_TAX_FIRST_YR;

	private HtmlOutputLabel COMP_FPCU_TAX_SUB_YRS_LABEL;

	private HtmlInputText COMP_FPCU_TAX_SUB_YRS;

	private HtmlOutputLabel COMP_UI_M_FPCU_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FPCU_CUST_DESC;

	private HtmlOutputLabel COMP_UI_M_FCR_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FCR_CUST_DESC;

	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;

	private PT_IL_FAC_PART_CUST PT_IL_FAC_PART_CUST_BEAN;

	private List<PT_IL_FAC_PART_CUST> dataListPT_IL_FAC_PART_CUST = null;

	private List<SelectItem> retroDrpDwn;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_PART_CUST_DETL;

	private UIData dataTable;
	
	PILT009_COMPOSITE_ACTION compositeAction;

	private boolean onLoadFlag;;

	public PT_IL_FAC_PART_CUST_ACTION() {
		dataListPT_IL_FAC_PART_CUST = new ArrayList<PT_IL_FAC_PART_CUST>();
		PT_IL_FAC_PART_CUST_BEAN = new PT_IL_FAC_PART_CUST();

		try {
			retroDrpDwn = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT009", "PT_IL_FAC_PART_CUST",
					"PT_IL_FAC_PART_CUST.FPCU_RETRO_YN", "YESNO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_FPCU_CUST_CODE_LABEL() {
		return COMP_FPCU_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_CUST_CODE() {
		return COMP_FPCU_CUST_CODE;
	}

	public void setCOMP_FPCU_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_FPCU_CUST_CODE_LABEL) {
		this.COMP_FPCU_CUST_CODE_LABEL = COMP_FPCU_CUST_CODE_LABEL;
	}

	public void setCOMP_FPCU_CUST_CODE(HtmlInputText COMP_FPCU_CUST_CODE) {
		this.COMP_FPCU_CUST_CODE = COMP_FPCU_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_FPCU_RETRO_YN_LABEL() {
		return COMP_FPCU_RETRO_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FPCU_RETRO_YN() {
		return COMP_FPCU_RETRO_YN;
	}

	public void setCOMP_FPCU_RETRO_YN_LABEL(
			HtmlOutputLabel COMP_FPCU_RETRO_YN_LABEL) {
		this.COMP_FPCU_RETRO_YN_LABEL = COMP_FPCU_RETRO_YN_LABEL;
	}

	public void setCOMP_FPCU_RETRO_YN(HtmlSelectOneMenu COMP_FPCU_RETRO_YN) {
		this.COMP_FPCU_RETRO_YN = COMP_FPCU_RETRO_YN;
	}

	public HtmlOutputLabel getCOMP_FPCU_SHARE_PERC_LABEL() {
		return COMP_FPCU_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_SHARE_PERC() {
		return COMP_FPCU_SHARE_PERC;
	}

	public void setCOMP_FPCU_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_FPCU_SHARE_PERC_LABEL) {
		this.COMP_FPCU_SHARE_PERC_LABEL = COMP_FPCU_SHARE_PERC_LABEL;
	}

	public void setCOMP_FPCU_SHARE_PERC(HtmlInputText COMP_FPCU_SHARE_PERC) {
		this.COMP_FPCU_SHARE_PERC = COMP_FPCU_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_FPCU_COMM_FIRST_YR_LABEL() {
		return COMP_FPCU_COMM_FIRST_YR_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_COMM_FIRST_YR() {
		return COMP_FPCU_COMM_FIRST_YR;
	}

	public void setCOMP_FPCU_COMM_FIRST_YR_LABEL(
			HtmlOutputLabel COMP_FPCU_COMM_FIRST_YR_LABEL) {
		this.COMP_FPCU_COMM_FIRST_YR_LABEL = COMP_FPCU_COMM_FIRST_YR_LABEL;
	}

	public void setCOMP_FPCU_COMM_FIRST_YR(HtmlInputText COMP_FPCU_COMM_FIRST_YR) {
		this.COMP_FPCU_COMM_FIRST_YR = COMP_FPCU_COMM_FIRST_YR;
	}

	public HtmlOutputLabel getCOMP_FPCU_COMM_SUB_YRS_LABEL() {
		return COMP_FPCU_COMM_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_COMM_SUB_YRS() {
		return COMP_FPCU_COMM_SUB_YRS;
	}

	public void setCOMP_FPCU_COMM_SUB_YRS_LABEL(
			HtmlOutputLabel COMP_FPCU_COMM_SUB_YRS_LABEL) {
		this.COMP_FPCU_COMM_SUB_YRS_LABEL = COMP_FPCU_COMM_SUB_YRS_LABEL;
	}

	public void setCOMP_FPCU_COMM_SUB_YRS(HtmlInputText COMP_FPCU_COMM_SUB_YRS) {
		this.COMP_FPCU_COMM_SUB_YRS = COMP_FPCU_COMM_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_FPCU_TAX_FIRST_YR_LABEL() {
		return COMP_FPCU_TAX_FIRST_YR_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_TAX_FIRST_YR() {
		return COMP_FPCU_TAX_FIRST_YR;
	}

	public void setCOMP_FPCU_TAX_FIRST_YR_LABEL(
			HtmlOutputLabel COMP_FPCU_TAX_FIRST_YR_LABEL) {
		this.COMP_FPCU_TAX_FIRST_YR_LABEL = COMP_FPCU_TAX_FIRST_YR_LABEL;
	}

	public void setCOMP_FPCU_TAX_FIRST_YR(HtmlInputText COMP_FPCU_TAX_FIRST_YR) {
		this.COMP_FPCU_TAX_FIRST_YR = COMP_FPCU_TAX_FIRST_YR;
	}

	public HtmlOutputLabel getCOMP_FPCU_TAX_SUB_YRS_LABEL() {
		return COMP_FPCU_TAX_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_FPCU_TAX_SUB_YRS() {
		return COMP_FPCU_TAX_SUB_YRS;
	}

	public void setCOMP_FPCU_TAX_SUB_YRS_LABEL(
			HtmlOutputLabel COMP_FPCU_TAX_SUB_YRS_LABEL) {
		this.COMP_FPCU_TAX_SUB_YRS_LABEL = COMP_FPCU_TAX_SUB_YRS_LABEL;
	}

	public void setCOMP_FPCU_TAX_SUB_YRS(HtmlInputText COMP_FPCU_TAX_SUB_YRS) {
		this.COMP_FPCU_TAX_SUB_YRS = COMP_FPCU_TAX_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCU_CUST_DESC_LABEL() {
		return COMP_UI_M_FPCU_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCU_CUST_DESC() {
		return COMP_UI_M_FPCU_CUST_DESC;
	}

	public void setCOMP_UI_M_FPCU_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FPCU_CUST_DESC_LABEL) {
		this.COMP_UI_M_FPCU_CUST_DESC_LABEL = COMP_UI_M_FPCU_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_FPCU_CUST_DESC(
			HtmlInputText COMP_UI_M_FPCU_CUST_DESC) {
		this.COMP_UI_M_FPCU_CUST_DESC = COMP_UI_M_FPCU_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCR_CUST_DESC_LABEL() {
		return COMP_UI_M_FCR_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCR_CUST_DESC() {
		return COMP_UI_M_FCR_CUST_DESC;
	}

	public void setCOMP_UI_M_FCR_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FCR_CUST_DESC_LABEL) {
		this.COMP_UI_M_FCR_CUST_DESC_LABEL = COMP_UI_M_FCR_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_FCR_CUST_DESC(HtmlInputText COMP_UI_M_FCR_CUST_DESC) {
		this.COMP_UI_M_FCR_CUST_DESC = COMP_UI_M_FCR_CUST_DESC;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public List<PT_IL_FAC_PART_CUST> getDataListPT_IL_FAC_PART_CUST() {
		return dataListPT_IL_FAC_PART_CUST;
	}

	public void setDataListPT_IL_FAC_PART_CUST(
			List<PT_IL_FAC_PART_CUST> dataListPT_IL_FAC_PART_CUST) {
		this.dataListPT_IL_FAC_PART_CUST = dataListPT_IL_FAC_PART_CUST;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCU_COVER_CODE_LABEL() {
		return COMP_UI_M_FPCU_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPCU_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fpcu_cover_code_label) {
		COMP_UI_M_FPCU_COVER_CODE_LABEL = comp_ui_m_fpcu_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FPCU_COVER_CODE() {
		return COMP_UI_M_FPCU_COVER_CODE;
	}

	public void setCOMP_UI_M_FPCU_COVER_CODE(
			HtmlInputText comp_ui_m_fpcu_cover_code) {
		COMP_UI_M_FPCU_COVER_CODE = comp_ui_m_fpcu_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FPCU_COVER_DESC() {
		return COMP_UI_M_FPCU_COVER_DESC;
	}

	public void setCOMP_UI_M_FPCU_COVER_DESC(
			HtmlInputText comp_ui_m_fpcu_cover_desc) {
		COMP_UI_M_FPCU_COVER_DESC = comp_ui_m_fpcu_cover_desc;
	}

	public List<SelectItem> getRetroDrpDwn() {
		return retroDrpDwn;
	}

	public void setRetroDrpDwn(List<SelectItem> retroDrpDwn) {
		this.retroDrpDwn = retroDrpDwn;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_PART_CUST_DETL() {
		return COMP_UI_M_BUT_FAC_PART_CUST_DETL;
	}

	public void setCOMP_UI_M_BUT_FAC_PART_CUST_DETL(
			HtmlCommandButton comp_ui_m_but_fac_part_cust_detl) {
		COMP_UI_M_BUT_FAC_PART_CUST_DETL = comp_ui_m_but_fac_part_cust_detl;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void onPageLoad(PhaseEvent event) {

		if (isBlockFlag()) {
			PT_IL_FAC_PART_CUST_HELPER helper = new PT_IL_FAC_PART_CUST_HELPER();
			try {
				helper.fetchRecord(this);
				COMP_UI_M_FPCU_COVER_CODE.resetValue();
				setBlockFlag(false);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current",
						"Error occured while loading the page");
				getErrorMap().put("detail",
						"Error occured while loading the page");
			}
			///setOnLoadFlag(true);
		}
	}

	
	
	
	
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PT_IL_FAC_PART_CUST_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_FAC_PART_CUST_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
				dataListPT_IL_FAC_PART_CUST.add(PT_IL_FAC_PART_CUST_BEAN);
			} else if (PT_IL_FAC_PART_CUST_BEAN.getROWID() != null
					 && isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PT_IL_FAC_PART_CUST_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
			}
			PT_IL_FAC_PART_CUST_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
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

	public void checkBoxStatus(ActionEvent actionEvent) {

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataListPT_IL_FAC_PART_CUST().get(rowIndex).setCHECK_BOX(check);
	}

	private PT_IL_FAC_PART_CUST getSelectedBean() throws Exception {

		PT_IL_FAC_PART_CUST facPartCustBean = null;
		int clickCount = 0;

		for (PT_IL_FAC_PART_CUST tempBean : getDataListPT_IL_FAC_PART_CUST()) {

			if (tempBean.isCHECK_BOX()) {
				facPartCustBean = tempBean;
				clickCount++;
			}
		}

		if (clickCount < 1) {
			throw new Exception("Please select one row");
		} else if (clickCount > 1) {
			throw new Exception("Please select only one row");
		}

		return facPartCustBean;
	}

	public String backToFAC_OUT() {
            
		return "gotoFacOut";
	}

	public String callFacPartCustDtls() {

		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			PT_IL_FAC_PART_CUST facPartCustBean = getPT_IL_FAC_PART_CUST_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_PART_CUST_DETL_ACTION()
					.setPT_IL_FAC_PART_CUST_BEAN(facPartCustBean);
			compositeAction.getPILT009_PT_IL_FAC_PART_CUST_DETL_ACTION()
					.setPT_IL_FAC_OUT_BEAN(getPT_IL_FAC_OUT_BEAN());
			returnValue = "gotoFacPartCustDtls";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
	}
	
	
	public void saveRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_FAC_PART_CUST_BEAN = (PT_IL_FAC_PART_CUST) dataTable.getRowData();
			
			PT_IL_FAC_PART_CUST_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_FAC_PART_CUST> PT_IL_FAC_PART_CUST_ITR = dataListPT_IL_FAC_PART_CUST
		.iterator();
		while (PT_IL_FAC_PART_CUST_ITR.hasNext()) {
			PT_IL_FAC_PART_CUST_ITR.next().setRowSelected(false);
		}
	}
	
	
	

	public void resetAllComponent() {
		COMP_FPCU_CUST_CODE.resetValue();
		COMP_FPCU_RETRO_YN.resetValue();
		COMP_FPCU_SHARE_PERC.resetValue();
		COMP_FPCU_COMM_FIRST_YR.resetValue();
		COMP_FPCU_COMM_SUB_YRS.resetValue();
		COMP_FPCU_TAX_FIRST_YR.resetValue();
		COMP_FPCU_TAX_SUB_YRS.resetValue();
		//COMP_UI_M_FPCU_CUST_DESC.resetValue();
	}

	public PT_IL_FAC_PART_CUST getPT_IL_FAC_PART_CUST_BEAN() {
		return PT_IL_FAC_PART_CUST_BEAN;
	}

	public void setPT_IL_FAC_PART_CUST_BEAN(
			PT_IL_FAC_PART_CUST pt_il_fac_part_cust_bean) {
		PT_IL_FAC_PART_CUST_BEAN = pt_il_fac_part_cust_bean;
	}
}

package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAID_ILLNESS_CODE_LABEL;

	private HtmlInputText COMP_PAID_ILLNESS_CODE;

	private HtmlOutputLabel COMP_UI_M_PAID_ILL_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAID_ILL_CODE_DESC;

	private PT_IL_POL_ASSR_ILLNESS_DTLS PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSR_ILLNESS_DTLS_HELPER helper;

	private List<PT_IL_POL_ASSR_ILLNESS_DTLS> dataList_PT_IL_POL_ASSR_ILLNESS_DTLS = new ArrayList<PT_IL_POL_ASSR_ILLNESS_DTLS>();

	private UIData dataTable;

	public PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION() {

		PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = new PT_IL_POL_ASSR_ILLNESS_DTLS();
		helper = new PT_IL_POL_ASSR_ILLNESS_DTLS_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_POL_ASSR_ILLNESS_DTLS getPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN() {
		return PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN;
	}

	public void setPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN(
			PT_IL_POL_ASSR_ILLNESS_DTLS PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN) {
		this.PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN;
	}

	public List<PT_IL_POL_ASSR_ILLNESS_DTLS> getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS() {
		return dataList_PT_IL_POL_ASSR_ILLNESS_DTLS;
	}

	public void setDataListPT_IL_POL_ASSR_ILLNESS_DTLS(
			List<PT_IL_POL_ASSR_ILLNESS_DTLS> dataList_PT_IL_POL_ASSR_ILLNESS_DTLS) {
		this.dataList_PT_IL_POL_ASSR_ILLNESS_DTLS = dataList_PT_IL_POL_ASSR_ILLNESS_DTLS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = new PT_IL_POL_ASSR_ILLNESS_DTLS();
				resetAllComponent();
				resetSelectedRow();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
			
				new CRUDHandler().executeDelete(
						PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN, CommonUtils
								.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_POL_ASSR_ILLNESS_DTLS
						.remove(PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
				if (dataList_PT_IL_POL_ASSR_ILLNESS_DTLS.size() > 0) {

					PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = dataList_PT_IL_POL_ASSR_ILLNESS_DTLS
							.get(0);
				} else if (dataList_PT_IL_POL_ASSR_ILLNESS_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN().getPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(
						PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN, CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				helper.postInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				dataList_PT_IL_POL_ASSR_ILLNESS_DTLS
						.add(PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
			} else if (PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpadate(compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN().getPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(
						PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN, CommonUtils
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

			PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = (PT_IL_POL_ASSR_ILLNESS_DTLS) dataTable
					.getRowData();
			helper.postQuery(PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
			PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_ASSR_ILLNESS_DTLS> PT_IL_POL_ASSR_ILLNESS_DTLS_ITR = dataList_PT_IL_POL_ASSR_ILLNESS_DTLS
				.iterator();
		while (PT_IL_POL_ASSR_ILLNESS_DTLS_ITR.hasNext()) {
			PT_IL_POL_ASSR_ILLNESS_DTLS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAID_ILLNESS_CODE.resetValue();
		COMP_PAID_ILLNESS_CODE.resetValue();
		COMP_UI_M_PAID_ILL_CODE_DESC.resetValue();
		COMP_UI_M_PAID_ILL_CODE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		String message = null; 
		try {
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE",message);
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.getROWID() != null){
				helper.postQuery(PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
				}
				
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PAID_ILLNESS_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN().setPAID_ILLNESS_CODE(
					(String) value);

			helper.PAID_ILLNESS_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			getCOMP_UI_M_PAID_ILL_CODE_DESC().resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_PAID_ILLNESS_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSR_ILLNESS_DTLS";
		String fieldName = "PAID_ILLNESS_CODE";
		Object param1 = "IL_ILL_CODE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =	itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public HtmlOutputLabel getCOMP_PAID_ILLNESS_CODE_LABEL() {
		return COMP_PAID_ILLNESS_CODE_LABEL;
	}

	public void setCOMP_PAID_ILLNESS_CODE_LABEL(
			HtmlOutputLabel comp_paid_illness_code_label) {
		COMP_PAID_ILLNESS_CODE_LABEL = comp_paid_illness_code_label;
	}

	public HtmlInputText getCOMP_PAID_ILLNESS_CODE() {
		return COMP_PAID_ILLNESS_CODE;
	}

	public void setCOMP_PAID_ILLNESS_CODE(HtmlInputText comp_paid_illness_code) {
		COMP_PAID_ILLNESS_CODE = comp_paid_illness_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAID_ILL_CODE_DESC_LABEL() {
		return COMP_UI_M_PAID_ILL_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAID_ILL_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_paid_ill_code_desc_label) {
		COMP_UI_M_PAID_ILL_CODE_DESC_LABEL = comp_ui_m_paid_ill_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PAID_ILL_CODE_DESC() {
		return COMP_UI_M_PAID_ILL_CODE_DESC;
	}

	public void setCOMP_UI_M_PAID_ILL_CODE_DESC(
			HtmlInputText comp_ui_m_paid_ill_code_desc) {
		COMP_UI_M_PAID_ILL_CODE_DESC = comp_ui_m_paid_ill_code_desc;
	}

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ASSR_ILLNESS_DTLS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ASSR_ILLNESS_DTLS_HELPER helper) {
		this.helper = helper;
	}

	public void setDataList_PT_IL_POL_ASSR_ILLNESS_DTLS(
			List<PT_IL_POL_ASSR_ILLNESS_DTLS> dataList_PT_IL_POL_ASSR_ILLNESS_DTLS) {
		this.dataList_PT_IL_POL_ASSR_ILLNESS_DTLS = dataList_PT_IL_POL_ASSR_ILLNESS_DTLS;
	}


	/**
	 * Disables all components in PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PAID_ILLNESS_CODE.setDisabled(disabled);
		COMP_UI_M_PAID_ILL_CODE_DESC.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PAID_ILLNESS_CODE				 = new HtmlInputText();
		COMP_UI_M_PAID_ILL_CODE_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PAID_ILLNESS_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PAID_ILL_CODE_DESC_LABEL		 = new HtmlOutputLabel();

	}


}

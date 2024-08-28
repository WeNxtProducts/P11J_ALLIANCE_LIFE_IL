package com.iii.pel.forms.PILM035_APAC;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_CVR_GRP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PACG_CVR_GROUP_CODE_LABEL;

	private HtmlInputText COMP_PACG_CVR_GROUP_CODE;

	private HtmlOutputLabel COMP_UI_M_CVR_GROUP_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CVR_GROUP_DESC;

	private HtmlOutputLabel COMP_PACG_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PACG_MANDATORY_YN;

	private HtmlOutputLabel COMP_PACG_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PACG_DEFAULT_YN;

	private PM_IL_PROD_APPL_CVR_GRP PM_IL_PROD_APPL_CVR_GRP_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_CVR_GRP_HELPER helper;

	private List<PM_IL_PROD_APPL_CVR_GRP> dataList_PM_IL_PROD_APPL_CVR_GRP = new ArrayList<PM_IL_PROD_APPL_CVR_GRP>();

	private UIData dataTable;

	private List<SelectItem> listPACG_MANDATORY_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPACG_DEFAULT_YN = new ArrayList<SelectItem>();

	public PM_IL_PROD_APPL_CVR_GRP_ACTION() {

		PM_IL_PROD_APPL_CVR_GRP_BEAN = new PM_IL_PROD_APPL_CVR_GRP();
		helper = new PM_IL_PROD_APPL_CVR_GRP_HELPER();
		listPACG_DEFAULT_YN.add(new SelectItem("Y","YES"));
		listPACG_DEFAULT_YN.add(new SelectItem("N","NO"));
		listPACG_MANDATORY_YN.add(new SelectItem("Y","YES"));
		listPACG_MANDATORY_YN.add(new SelectItem("N","NO"));
	}

	public HtmlOutputLabel getCOMP_PACG_CVR_GROUP_CODE_LABEL() {
		return COMP_PACG_CVR_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PACG_CVR_GROUP_CODE() {
		return COMP_PACG_CVR_GROUP_CODE;
	}

	public void setCOMP_PACG_CVR_GROUP_CODE_LABEL(
			HtmlOutputLabel COMP_PACG_CVR_GROUP_CODE_LABEL) {
		this.COMP_PACG_CVR_GROUP_CODE_LABEL = COMP_PACG_CVR_GROUP_CODE_LABEL;
	}

	public void setCOMP_PACG_CVR_GROUP_CODE(
			HtmlInputText COMP_PACG_CVR_GROUP_CODE) {
		this.COMP_PACG_CVR_GROUP_CODE = COMP_PACG_CVR_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CVR_GROUP_DESC_LABEL() {
		return COMP_UI_M_CVR_GROUP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CVR_GROUP_DESC() {
		return COMP_UI_M_CVR_GROUP_DESC;
	}

	public void setCOMP_UI_M_CVR_GROUP_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CVR_GROUP_DESC_LABEL) {
		this.COMP_UI_M_CVR_GROUP_DESC_LABEL = COMP_UI_M_CVR_GROUP_DESC_LABEL;
	}

	public void setCOMP_UI_M_CVR_GROUP_DESC(
			HtmlInputText COMP_UI_M_CVR_GROUP_DESC) {
		this.COMP_UI_M_CVR_GROUP_DESC = COMP_UI_M_CVR_GROUP_DESC;
	}

	public HtmlOutputLabel getCOMP_PACG_MANDATORY_YN_LABEL() {
		return COMP_PACG_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PACG_MANDATORY_YN() {
		return COMP_PACG_MANDATORY_YN;
	}

	public void setCOMP_PACG_MANDATORY_YN_LABEL(
			HtmlOutputLabel COMP_PACG_MANDATORY_YN_LABEL) {
		this.COMP_PACG_MANDATORY_YN_LABEL = COMP_PACG_MANDATORY_YN_LABEL;
	}

	public void setCOMP_PACG_MANDATORY_YN(
			HtmlSelectOneMenu COMP_PACG_MANDATORY_YN) {
		this.COMP_PACG_MANDATORY_YN = COMP_PACG_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_PACG_DEFAULT_YN_LABEL() {
		return COMP_PACG_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PACG_DEFAULT_YN() {
		return COMP_PACG_DEFAULT_YN;
	}

	public void setCOMP_PACG_DEFAULT_YN_LABEL(
			HtmlOutputLabel COMP_PACG_DEFAULT_YN_LABEL) {
		this.COMP_PACG_DEFAULT_YN_LABEL = COMP_PACG_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PACG_DEFAULT_YN(HtmlSelectOneMenu COMP_PACG_DEFAULT_YN) {
		this.COMP_PACG_DEFAULT_YN = COMP_PACG_DEFAULT_YN;
	}

	public PM_IL_PROD_APPL_CVR_GRP getPM_IL_PROD_APPL_CVR_GRP_BEAN() {
		return PM_IL_PROD_APPL_CVR_GRP_BEAN;
	}

	public void setPM_IL_PROD_APPL_CVR_GRP_BEAN(
			PM_IL_PROD_APPL_CVR_GRP PM_IL_PROD_APPL_CVR_GRP_BEAN) {
		this.PM_IL_PROD_APPL_CVR_GRP_BEAN = PM_IL_PROD_APPL_CVR_GRP_BEAN;
	}

	public List<PM_IL_PROD_APPL_CVR_GRP> getDataList_PM_IL_PROD_APPL_CVR_GRP() {
		return dataList_PM_IL_PROD_APPL_CVR_GRP;
	}

	public void setDataListPM_IL_PROD_APPL_CVR_GRP(
			List<PM_IL_PROD_APPL_CVR_GRP> dataList_PM_IL_PROD_APPL_CVR_GRP) {
		this.dataList_PM_IL_PROD_APPL_CVR_GRP = dataList_PM_IL_PROD_APPL_CVR_GRP;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_IL_PROD_APPL_CVR_GRP_BEAN = new PM_IL_PROD_APPL_CVR_GRP();
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
				helper.preDelete(PM_IL_PROD_APPL_CVR_GRP_BEAN);
				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_CVR_GRP_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_IL_PROD_APPL_CVR_GRP
						.remove(PM_IL_PROD_APPL_CVR_GRP_BEAN);
				if (dataList_PM_IL_PROD_APPL_CVR_GRP.size() > 0) {
					PM_IL_PROD_APPL_CVR_GRP_BEAN = dataList_PM_IL_PROD_APPL_CVR_GRP
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_CVR_GRP.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PM_IL_PROD_APPL_CVR_GRP_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_APPL_CVR_GRP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper
						.preInsert(PM_IL_PROD_APPL_CVR_GRP_BEAN,
								compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
										.getPM_IL_PRODUCT_BEAN());
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_CVR_GRP_BEAN,
						CommonUtils.getConnection());
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
				dataList_PM_IL_PROD_APPL_CVR_GRP
						.add(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			} else if (PM_IL_PROD_APPL_CVR_GRP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_PROD_APPL_CVR_GRP_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_CVR_GRP_BEAN,
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
			PM_IL_PROD_APPL_CVR_GRP_BEAN.setRowSelected(true);
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
			PM_IL_PROD_APPL_CVR_GRP_BEAN = (PM_IL_PROD_APPL_CVR_GRP) dataTable
					.getRowData();
			PM_IL_PROD_APPL_CVR_GRP_BEAN.setRowSelected(true);
			helper.postQuery(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_CVR_GRP> PM_IL_PROD_APPL_CVR_GRP_ITR = dataList_PM_IL_PROD_APPL_CVR_GRP
				.iterator();
		while (PM_IL_PROD_APPL_CVR_GRP_ITR.hasNext()) {
			PM_IL_PROD_APPL_CVR_GRP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PACG_CVR_GROUP_CODE.resetValue();
		COMP_UI_M_CVR_GROUP_DESC.resetValue();
		COMP_PACG_MANDATORY_YN.resetValue();
		COMP_PACG_DEFAULT_YN.resetValue();
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
			message = Messages.getString("messageProperties",
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPACG_MANDATORY_YN() {
		if (listPACG_MANDATORY_YN.size() == 0) {
			listPACG_MANDATORY_YN.clear();
			try {
				listPACG_MANDATORY_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPACG_MANDATORY_YN;
	}

	public void setListPACG_MANDATORY_YN(List<SelectItem> listPACG_MANDATORY_YN) {
		this.listPACG_MANDATORY_YN = listPACG_MANDATORY_YN;
	}

	public List<SelectItem> getListPACG_DEFAULT_YN() {
		if (listPACG_DEFAULT_YN.size() == 0) {
			listPACG_DEFAULT_YN.clear();
			try {
				listPACG_DEFAULT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPACG_DEFAULT_YN;
	}

	public void setListPACG_DEFAULT_YN(List<SelectItem> listPACG_DEFAULT_YN) {
		this.listPACG_DEFAULT_YN = listPACG_DEFAULT_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				helper.onPopulateDetail(compositeAction);
				helper.postQuery(PM_IL_PROD_APPL_CVR_GRP_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PACG_CVR_GROUP_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_CVR_GRP_BEAN().setPACG_CVR_GROUP_CODE(
					(String) value);
			helper
					.PACG_CVR_GROUP_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			COMP_UI_M_CVR_GROUP_DESC.resetValue();
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

	public ArrayList<LovBean> prepareSuggestionList_PACG_CVR_GROUP_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = " SELECT CGH_GROUP_CODE,CGH_DESC,CGH_SHORT_DESC  FROM   PM_IL_CVR_GROUP_HDR WHERE  (CGH_GROUP_CODE LIKE ? OR CGH_DESC LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[]{currentValue, currentValue,
					PELConstants.suggetionRecordSize};
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public void PACG_MANDATORY_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_CVR_GRP_BEAN().setPACG_MANDATORY_YN(
					(String) value);
			helper
					.PACG_MANDATORY_YN_WHEN_VALIDATE_ITEM(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			COMP_PACG_DEFAULT_YN.resetValue();
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

	public void PACG_DEFAULT_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_CVR_GRP_BEAN()
					.setPACG_DEFAULT_YN((String) value);
			helper
					.PACG_DEFAULT_YN_WHEN_VALIDATE_ITEM(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			COMP_PACG_DEFAULT_YN.resetValue();
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

}

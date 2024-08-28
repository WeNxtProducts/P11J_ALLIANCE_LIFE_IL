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

public class PM_IL_PROD_APPL_BONUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAB_BONUS_CODE_LABEL;

	private HtmlInputText COMP_PAB_BONUS_CODE;

	private HtmlOutputLabel COMP_UI_M_PAB_BONUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAB_BONUS_CODE_DESC;
	
	private HtmlOutputLabel COMP_PROD_BONUS_EARN_INT_LABEL;
	
	private HtmlSelectOneMenu COMP_PROD_BONUS_EARN_INT;

	private PM_IL_PROD_APPL_BONUS PM_IL_PROD_APPL_BONUS_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_BONUS_HELPER helper;

	private List<PM_IL_PROD_APPL_BONUS> dataList_PM_IL_PROD_APPL_BONUS = new ArrayList<PM_IL_PROD_APPL_BONUS>();
	
	private List<SelectItem> listPROD_BONUS_EARN_INT = new ArrayList<SelectItem>();
	
	private UIData dataTable;

	public PM_IL_PROD_APPL_BONUS_ACTION() {

		PM_IL_PROD_APPL_BONUS_BEAN = new PM_IL_PROD_APPL_BONUS();
		helper = new PM_IL_PROD_APPL_BONUS_HELPER();
		List<SelectItem> listValues = new ArrayList<SelectItem>();
		listValues.add(new SelectItem("Y","Yes"));
		listValues.add(new SelectItem("N","No"));
		setListPROD_BONUS_EARN_INT(listValues);
		
	}

	public HtmlOutputLabel getCOMP_PAB_BONUS_CODE_LABEL() {
		return COMP_PAB_BONUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAB_BONUS_CODE() {
		return COMP_PAB_BONUS_CODE;
	}

	public void setCOMP_PAB_BONUS_CODE_LABEL(
			HtmlOutputLabel COMP_PAB_BONUS_CODE_LABEL) {
		this.COMP_PAB_BONUS_CODE_LABEL = COMP_PAB_BONUS_CODE_LABEL;
	}

	public void setCOMP_PAB_BONUS_CODE(HtmlInputText COMP_PAB_BONUS_CODE) {
		this.COMP_PAB_BONUS_CODE = COMP_PAB_BONUS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAB_BONUS_CODE_DESC_LABEL() {
		return COMP_UI_M_PAB_BONUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAB_BONUS_CODE_DESC() {
		return COMP_UI_M_PAB_BONUS_CODE_DESC;
	}

	public void setCOMP_UI_M_PAB_BONUS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAB_BONUS_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAB_BONUS_CODE_DESC_LABEL = COMP_UI_M_PAB_BONUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAB_BONUS_CODE_DESC(
			HtmlInputText COMP_UI_M_PAB_BONUS_CODE_DESC) {
		this.COMP_UI_M_PAB_BONUS_CODE_DESC = COMP_UI_M_PAB_BONUS_CODE_DESC;
	}

	public PM_IL_PROD_APPL_BONUS getPM_IL_PROD_APPL_BONUS_BEAN() {
		return PM_IL_PROD_APPL_BONUS_BEAN;
	}

	public void setPM_IL_PROD_APPL_BONUS_BEAN(
			PM_IL_PROD_APPL_BONUS PM_IL_PROD_APPL_BONUS_BEAN) {
		this.PM_IL_PROD_APPL_BONUS_BEAN = PM_IL_PROD_APPL_BONUS_BEAN;
	}

	public List<PM_IL_PROD_APPL_BONUS> getDataList_PM_IL_PROD_APPL_BONUS() {
		return dataList_PM_IL_PROD_APPL_BONUS;
	}

	public void setDataListPM_IL_PROD_APPL_BONUS(
			List<PM_IL_PROD_APPL_BONUS> dataList_PM_IL_PROD_APPL_BONUS) {
		this.dataList_PM_IL_PROD_APPL_BONUS = dataList_PM_IL_PROD_APPL_BONUS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_PROD_APPL_BONUS_BEAN = new PM_IL_PROD_APPL_BONUS();
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

				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_BONUS_BEAN,
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
				dataList_PM_IL_PROD_APPL_BONUS
						.remove(PM_IL_PROD_APPL_BONUS_BEAN);
				if (dataList_PM_IL_PROD_APPL_BONUS.size() > 0) {

					PM_IL_PROD_APPL_BONUS_BEAN = dataList_PM_IL_PROD_APPL_BONUS
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_BONUS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_BONUS_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_APPL_BONUS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_BONUS_BEAN,
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
								"errorPanel$message$save"));
				
				dataList_PM_IL_PROD_APPL_BONUS.add(PM_IL_PROD_APPL_BONUS_BEAN);
				
			} else if (PM_IL_PROD_APPL_BONUS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_BONUS_BEAN,
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

			PM_IL_PROD_APPL_BONUS_BEAN.setRowSelected(true);
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
			PM_IL_PROD_APPL_BONUS_BEAN = (PM_IL_PROD_APPL_BONUS) dataTable
					.getRowData();
			PM_IL_PROD_APPL_BONUS_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_BONUS> PM_IL_PROD_APPL_BONUS_ITR = dataList_PM_IL_PROD_APPL_BONUS
				.iterator();
		while (PM_IL_PROD_APPL_BONUS_ITR.hasNext()) {
			PM_IL_PROD_APPL_BONUS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAB_BONUS_CODE.resetValue();
		COMP_UI_M_PAB_BONUS_CODE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
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
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				if(getPM_IL_PROD_APPL_BONUS_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public List<LovBean> lovPAB_BONUS_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_BONUS", "PAB_BONUS_CODE",null,null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("lovPAB_BONUS_CODE", e.getMessage());
		}
		return suggestionList;
	}
	public void PAB_BONUS_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PAB_BONUS_CODE(compositeAction, value);
			getPM_IL_PROD_APPL_BONUS_BEAN().setPAB_BONUS_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public String navigationEnabled() {
		getErrorMap().clear();
		return "";

	}

	public HtmlOutputLabel getCOMP_PROD_BONUS_EARN_INT_LABEL() {
		return COMP_PROD_BONUS_EARN_INT_LABEL;
	}

	public void setCOMP_PROD_BONUS_EARN_INT_LABEL(
			HtmlOutputLabel comp_prod_bonus_earn_int_label) {
		COMP_PROD_BONUS_EARN_INT_LABEL = comp_prod_bonus_earn_int_label;
	}

	public HtmlSelectOneMenu getCOMP_PROD_BONUS_EARN_INT() {
		return COMP_PROD_BONUS_EARN_INT;
	}

	public void setCOMP_PROD_BONUS_EARN_INT(
			HtmlSelectOneMenu comp_prod_bonus_earn_int) {
		COMP_PROD_BONUS_EARN_INT = comp_prod_bonus_earn_int;
	}

	public List<SelectItem> getListPROD_BONUS_EARN_INT() {
		if (listPROD_BONUS_EARN_INT.size() == 0) {
			listPROD_BONUS_EARN_INT.clear();
			try {
				listPROD_BONUS_EARN_INT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_BONUS_EARN_INT;
	}

	public void setListPROD_BONUS_EARN_INT(List<SelectItem> listPROD_BONUS_EARN_INT) {
		this.listPROD_BONUS_EARN_INT = listPROD_BONUS_EARN_INT;
	}
}

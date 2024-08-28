package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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

public class PM_IL_PROD_APPL_PLANS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAP_PROD_CODE_LABEL;

	private HtmlInputText COMP_PAP_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PAP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAP_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_PAP_SR_NO_LABEL;

	private HtmlInputText COMP_PAP_SR_NO;

	private HtmlOutputLabel COMP_PAP_SUB_PLAN_CODE_LABEL;

	private HtmlInputText COMP_PAP_SUB_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_PAP_SUB_PLAN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PAP_SUB_PLAN_CODE;

	private HtmlCommandButton COMP_UI_M_PAP_SUB_PLAN_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_1;

	private PM_IL_PROD_APPL_SUB_PLAN PM_IL_PROD_APPL_PLANS_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_PLANS_HELPER helper;

	private List<PM_IL_PROD_APPL_SUB_PLAN> dataList_PM_IL_PROD_APPL_PLANS = new ArrayList<PM_IL_PROD_APPL_SUB_PLAN>();

	private UIData dataTable;

	public PM_IL_PROD_APPL_PLANS_ACTION() {

		PM_IL_PROD_APPL_PLANS_BEAN = new PM_IL_PROD_APPL_SUB_PLAN();
		helper = new PM_IL_PROD_APPL_PLANS_HELPER();
		intiateAllComponents();
	}

	public HtmlOutputLabel getCOMP_PAP_PROD_CODE_LABEL() {
		return COMP_PAP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAP_PROD_CODE() {
		return COMP_PAP_PROD_CODE;
	}

	public void setCOMP_PAP_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_PAP_PROD_CODE_LABEL) {
		this.COMP_PAP_PROD_CODE_LABEL = COMP_PAP_PROD_CODE_LABEL;
	}

	public void setCOMP_PAP_PROD_CODE(HtmlInputText COMP_PAP_PROD_CODE) {
		this.COMP_PAP_PROD_CODE = COMP_PAP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAP_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_PAP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAP_PROD_CODE_DESC() {
		return COMP_UI_M_PAP_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_PAP_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAP_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAP_PROD_CODE_DESC_LABEL = COMP_UI_M_PAP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAP_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_PAP_PROD_CODE_DESC) {
		this.COMP_UI_M_PAP_PROD_CODE_DESC = COMP_UI_M_PAP_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAP_SR_NO_LABEL() {
		return COMP_PAP_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_PAP_SR_NO() {
		return COMP_PAP_SR_NO;
	}

	public void setCOMP_PAP_SR_NO_LABEL(HtmlOutputLabel COMP_PAP_SR_NO_LABEL) {
		this.COMP_PAP_SR_NO_LABEL = COMP_PAP_SR_NO_LABEL;
	}

	public void setCOMP_PAP_SR_NO(HtmlInputText COMP_PAP_SR_NO) {
		this.COMP_PAP_SR_NO = COMP_PAP_SR_NO;
	}

	public HtmlOutputLabel getCOMP_PAP_SUB_PLAN_CODE_LABEL() {
		return COMP_PAP_SUB_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAP_SUB_PLAN_CODE() {
		return COMP_PAP_SUB_PLAN_CODE;
	}

	public void setCOMP_PAP_SUB_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_PAP_SUB_PLAN_CODE_LABEL) {
		this.COMP_PAP_SUB_PLAN_CODE_LABEL = COMP_PAP_SUB_PLAN_CODE_LABEL;
	}

	public void setCOMP_PAP_SUB_PLAN_CODE(HtmlInputText COMP_PAP_SUB_PLAN_CODE) {
		this.COMP_PAP_SUB_PLAN_CODE = COMP_PAP_SUB_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAP_SUB_PLAN_CODE_LABEL() {
		return COMP_UI_M_PAP_SUB_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAP_SUB_PLAN_CODE() {
		return COMP_UI_M_PAP_SUB_PLAN_CODE;
	}

	public void setCOMP_UI_M_PAP_SUB_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PAP_SUB_PLAN_CODE_LABEL) {
		this.COMP_UI_M_PAP_SUB_PLAN_CODE_LABEL = COMP_UI_M_PAP_SUB_PLAN_CODE_LABEL;
	}

	public void setCOMP_UI_M_PAP_SUB_PLAN_CODE(
			HtmlInputText COMP_UI_M_PAP_SUB_PLAN_CODE) {
		this.COMP_UI_M_PAP_SUB_PLAN_CODE = COMP_UI_M_PAP_SUB_PLAN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_PAP_SUB_PLAN_CODE_LOV() {
		return COMP_UI_M_PAP_SUB_PLAN_CODE_LOV;
	}

	public void setCOMP_UI_M_PAP_SUB_PLAN_CODE_LOV(
			HtmlCommandButton COMP_UI_M_PAP_SUB_PLAN_CODE_LOV) {
		this.COMP_UI_M_PAP_SUB_PLAN_CODE_LOV = COMP_UI_M_PAP_SUB_PLAN_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_1() {
		return COMP_UI_M_BUT_MAIN_1;
	}

	public void setCOMP_UI_M_BUT_MAIN_1(HtmlCommandButton COMP_UI_M_BUT_MAIN_1) {
		this.COMP_UI_M_BUT_MAIN_1 = COMP_UI_M_BUT_MAIN_1;
	}

	public PM_IL_PROD_APPL_SUB_PLAN getPM_IL_PROD_APPL_PLANS_BEAN() {
		return PM_IL_PROD_APPL_PLANS_BEAN;
	}

	public void setPM_IL_PROD_APPL_PLANS_BEAN(
			PM_IL_PROD_APPL_SUB_PLAN PM_IL_PROD_APPL_PLANS_BEAN) {
		this.PM_IL_PROD_APPL_PLANS_BEAN = PM_IL_PROD_APPL_PLANS_BEAN;
	}

	public List<PM_IL_PROD_APPL_SUB_PLAN> getDataList_PM_IL_PROD_APPL_PLANS() {
		return dataList_PM_IL_PROD_APPL_PLANS;
	}

	public void setDataListPM_IL_PROD_APPL_PLANS(
			List<PM_IL_PROD_APPL_SUB_PLAN> dataList_PM_IL_PROD_APPL_PLANS) {
		this.dataList_PM_IL_PROD_APPL_PLANS = dataList_PM_IL_PROD_APPL_PLANS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_APPL_PLANS_BEAN = new PM_IL_PROD_APPL_SUB_PLAN();
				PM_IL_PROD_APPL_PLANS_BEAN.setPAP_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
				
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
	public String mainAction(){
		return "PILM035_APAC_PM_IL_PRODUCT";
	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_PLANS_BEAN,
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
				dataList_PM_IL_PROD_APPL_PLANS
						.remove(PM_IL_PROD_APPL_PLANS_BEAN);
				if (dataList_PM_IL_PROD_APPL_PLANS.size() > 0) {

					PM_IL_PROD_APPL_PLANS_BEAN = dataList_PM_IL_PROD_APPL_PLANS
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_PLANS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_PLANS_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_APPL_PLANS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_PLANS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				/*getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));*/
				dataList_PM_IL_PROD_APPL_PLANS.add(PM_IL_PROD_APPL_PLANS_BEAN);
			} else if (PM_IL_PROD_APPL_PLANS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_PLANS_BEAN,
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

			/*Added by Janani on 19.05.2018 for records getting saved in table*/
			CommonUtils.getConnection().commit();
			
			PM_IL_PROD_APPL_PLANS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
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
			PM_IL_PROD_APPL_PLANS_BEAN = (PM_IL_PROD_APPL_SUB_PLAN) dataTable
					.getRowData();
			PM_IL_PROD_APPL_PLANS_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_SUB_PLAN> PM_IL_PROD_APPL_PLANS_ITR = dataList_PM_IL_PROD_APPL_PLANS
				.iterator();
		while (PM_IL_PROD_APPL_PLANS_ITR.hasNext()) {
			PM_IL_PROD_APPL_PLANS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAP_PROD_CODE.resetValue();
		COMP_UI_M_PAP_PROD_CODE_DESC.resetValue();
		COMP_PAP_SR_NO.resetValue();
		COMP_PAP_SUB_PLAN_CODE.resetValue();
		COMP_UI_M_PAP_SUB_PLAN_CODE.resetValue();
	}
	
	private void intiateAllComponents(){
		COMP_PAP_PROD_CODE = new HtmlInputText();
		COMP_UI_M_PAP_PROD_CODE_DESC = new HtmlInputText();
		COMP_PAP_SR_NO = new HtmlInputText();
		COMP_PAP_SUB_PLAN_CODE = new HtmlInputText();
		COMP_UI_M_PAP_SUB_PLAN_CODE = new HtmlInputText();
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
			e.printStackTrace();
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
				if(getPM_IL_PROD_APPL_PLANS_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void PAP_SUB_PLAN_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.PAP_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(compositeAction);
			getPM_IL_PROD_APPL_PLANS_BEAN().setPAP_SUB_PLAN_CODE((String) value);
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

	public List<LovBean> lovPAP_SUB_PLAN_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			/*Modified by kavitha on 20.07.2018 for FLALIFEQC-1757107 */
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_SUB_PLAN", "PAP_SUB_PLAN_CODE",
					null, null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/*Added by kavitha on 20.07.2018 for FLALIFEQC-1757107 */
	public void UI_M_PAP_SUB_PLAN_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_PLANS_BEAN().setUI_M_PAP_SUB_PLAN_CODE((String) value);
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

}

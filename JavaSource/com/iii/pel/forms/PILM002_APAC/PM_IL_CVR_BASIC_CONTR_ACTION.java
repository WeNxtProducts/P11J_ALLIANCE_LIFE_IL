package com.iii.pel.forms.PILM002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_BASIC_CONTR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CVR_BASIC_CONTRIBUTION_FROM_LABEL;

	private HtmlInputText COMP_CVR_BASIC_CONTRIBUTION_FROM;

	private HtmlOutputLabel COMP_CVR_BASIC_CONTRIBUTION_TO_LABEL;

	private HtmlInputText COMP_CVR_BASIC_CONTRIBUTION_TO;

	private HtmlOutputLabel COMP_CVR_BASIC_CONTRIBUTION_LC_LABEL;

	private HtmlInputText COMP_CVR_BASIC_CONTRIBUTION_LC;

	private PM_IL_BASIC_CONTRIBUTION PM_IL_BASIC_CONTRIBUTION_BEAN;

	private List<PM_IL_BASIC_CONTRIBUTION> recordList;

	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_REMOVE_ROW;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	private UIDataTable COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE;
	private List<PM_IL_BASIC_CONTRIBUTION> suggestionList;
	private int recordsPerPage = 5;
	private int currPage;
	public PILM002_APAC_COMPOSITE_ACTION compositeAction;
	private String filterByBC_AGE_FROM;
	private String filterByBC_AGE_TO;

	public PM_IL_CVR_BASIC_CONTR_ACTION() {

		PM_IL_BASIC_CONTRIBUTION_BEAN = new PM_IL_BASIC_CONTRIBUTION();

		if (this.recordList == null) {
			this.recordList = new ArrayList<PM_IL_BASIC_CONTRIBUTION>();
			currPage = 1;
		}
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<PM_IL_BASIC_CONTRIBUTION> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_BASIC_CONTRIBUTION> recordList) {
		this.recordList = recordList;
	}

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public UIDataTable getCOMP_PM_IL_CVR_WAITING_PRD_TABLE() {
		return COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE;
	}

	public void setCOMP_PM_IL_CVR_WAITING_PRD_TABLE(
			UIDataTable comp_pm_il_cvr_waiting_prd_table) {
		COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE = comp_pm_il_cvr_waiting_prd_table;
	}

	public List<PM_IL_BASIC_CONTRIBUTION> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<PM_IL_BASIC_CONTRIBUTION> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public void addRowButtonClickAction(ActionEvent event) {
		CommonUtils.clearMaps(this);
		PM_IL_BASIC_CONTRIBUTION bean = new PM_IL_BASIC_CONTRIBUTION();
		this.recordList.add(bean);
		int rowCount = this.COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE.getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		System.out.println(recordList.size());
	}

	

	public void setFieldUI_CWP_ILLNESS_TYP_DESC(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String selectedCode = (String) ((UIInput) (event.getComponent()
				.getParent().getParent().findComponent("CWP_ILLNESS_TYP")))
				.getSubmittedValue();
		boolean keepLooking = true;
		Iterator<PM_IL_BASIC_CONTRIBUTION> iterator = suggestionList.iterator();
		while (iterator.hasNext() && keepLooking) {
			PM_IL_BASIC_CONTRIBUTION suggestionListBean = (PM_IL_BASIC_CONTRIBUTION) iterator.next();
			int currentIndex = this.COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE.getRowIndex();
			PM_IL_BASIC_CONTRIBUTION recordListBean = (PM_IL_BASIC_CONTRIBUTION) this.recordList
					.get(currentIndex);
			recordList.set(currentIndex, recordListBean);
			keepLooking = false;
		}
	}

	public void freezeFlagWhenValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void setBC_COVER_CODE() {
		CommonUtils utility = new CommonUtils();
		String coverCode = compositeAction.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		this.PM_IL_BASIC_CONTRIBUTION_BEAN.setBC_COVER_CODE(coverCode);
	}

	private boolean isNullCWP_ILLNESS_TYP() {
		boolean isNull = true;
		PM_IL_CVR_BASIC_CONTR_ACTION actionBean = compositeAction
				.getPM_IL_CVR_BASIC_CONTR_ACTION_BEAN();
		PM_IL_BASIC_CONTRIBUTION recordListBean = (PM_IL_BASIC_CONTRIBUTION) actionBean
				.getPM_IL_BASIC_CONTRIBUTION_BEAN();
		isNull = false;
		return isNull;
	}

	public String saveButtonClickAction() {
		String returnString = "";
		PM_IL_CVR_WAITING_PRD_DELEGATE delegate = new PM_IL_CVR_WAITING_PRD_DELEGATE();
		boolean status = delegate.commitData();
		getWarningMap().put(
				"current",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"errorPanel$message$save"));
		getWarningMap().put(
				"somekey",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"errorPanel$message$save"));
		return returnString;
	}

	public String previousPageButtonAction() {
		String returnString = "GO_TO_PILM002_APAC_PM_IL_APPL_WOP_COVER";
		return returnString;
	}

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * CWP_ILLNESS_TYP field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemCWP_ILLNESS_TYP(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) (event.getComponent().getParent());
		ErrorHelpUtil.validate(component, getErrorMap());
	}

	/**
	 * Validator method for validating field CWP_ILLNESS_TYP
	 * 
	 * @param FacesContext
	 *            context
	 * @param UIComponent
	 *            component
	 * @param Object
	 *            value
	 * @return
	 * @throws
	 */
	public void validateBC_AGE_FROM(FacesContext context,UIComponent component, Object value) {
		PM_IL_CVR_BASIC_CONTR_HELPER helper = new PM_IL_CVR_BASIC_CONTR_HELPER();
		PM_IL_BASIC_CONTRIBUTION_BEAN.setBC_AGE_FROM(Integer.parseInt(value.toString()));
		try {
			helper.whenValidateItemBC_AGE_FROM(component, PM_IL_BASIC_CONTRIBUTION_BEAN.getBC_AGE_FROM());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateBC_AGE_TO(FacesContext context,UIComponent component, Object value) {
		PM_IL_CVR_BASIC_CONTR_HELPER helper = new PM_IL_CVR_BASIC_CONTR_HELPER();
		PM_IL_BASIC_CONTRIBUTION_BEAN.setBC_AGE_TO(Integer.parseInt(value.toString()));
		try {
			helper.whenValidateItemBC_AGE_TO(component,PM_IL_BASIC_CONTRIBUTION_BEAN.getBC_AGE_FROM(),PM_IL_BASIC_CONTRIBUTION_BEAN.getBC_AGE_TO());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * CWP_WAITING_PRD field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemCWP_WAITING_PRD(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) (event.getComponent().getParent());
		ErrorHelpUtil.validate(component, getErrorMap());
	}


	/**
	 * @return the cOMP_REMOVE_ROW
	 */
	public HtmlAjaxCommandButton getCOMP_REMOVE_ROW() {
		return COMP_REMOVE_ROW;
	}

	/**
	 * @param comp_remove_row
	 *            the cOMP_REMOVE_ROW to set
	 */
	public void setCOMP_REMOVE_ROW(HtmlAjaxCommandButton comp_remove_row) {
		COMP_REMOVE_ROW = comp_remove_row;
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

	public void getDetails() {
		try {

			if (recordList.size() != 0) {
				PM_IL_BASIC_CONTRIBUTION_BEAN = (PM_IL_BASIC_CONTRIBUTION) COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE
						.getRowData();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_BASIC_CONTRIBUTION_BEAN.setRowSelected(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void resetAllComponent() {
		COMP_CVR_BASIC_CONTRIBUTION_FROM.resetValue();
		COMP_CVR_BASIC_CONTRIBUTION_TO.resetValue();
		COMP_CVR_BASIC_CONTRIBUTION_LC.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PM_IL_BASIC_CONTRIBUTION> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void AddRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_IL_BASIC_CONTRIBUTION_BEAN = new PM_IL_BASIC_CONTRIBUTION();
				resetAllComponent();
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
	
	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_IL_BASIC_CONTRIBUTION_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(
							PM_IL_BASIC_CONTRIBUTION_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();
					recordList.remove(PM_IL_BASIC_CONTRIBUTION_BEAN);
				}
				
				if(recordList.size() ==0) {
					AddRow(null);
				} else {
					PM_IL_BASIC_CONTRIBUTION_BEAN = recordList.get(0);
					PM_IL_BASIC_CONTRIBUTION_BEAN.setRowSelected(true);
					resetAllComponent();
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
	}

	public void post(ActionEvent ae) {

		boolean isNull = isNullCWP_ILLNESS_TYP();
		PM_IL_CVR_BASIC_CONTR_ACTION actionBean = compositeAction
				.getPM_IL_CVR_BASIC_CONTR_ACTION_BEAN();
		PM_IL_BASIC_CONTRIBUTION PM_IL_CVR_WAITING_PRD_BEAN = (PM_IL_BASIC_CONTRIBUTION) actionBean
				.getPM_IL_BASIC_CONTRIBUTION_BEAN();

		PM_IL_CVR_BASIC_CONTR_HELPER helper = new PM_IL_CVR_BASIC_CONTR_HELPER();

		if (!isNull) {
			try {

				if (PM_IL_CVR_WAITING_PRD_BEAN.getROWID() != null) {
					if (isUPDATE_ALLOWED()) {
						helper.preUpdate(PM_IL_CVR_WAITING_PRD_BEAN);
						new CRUDHandler().executeInsert(
								PM_IL_CVR_WAITING_PRD_BEAN, CommonUtils
										.getConnection());
						getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$Grid$update"));
						getWarningMap().put(
								"post",
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$Grid$update"));
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
						setBC_COVER_CODE();
						new CRUDHandler().executeInsert(PM_IL_CVR_WAITING_PRD_BEAN, CommonUtils.getConnection());
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
						getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
						recordList.add(PM_IL_CVR_WAITING_PRD_BEAN);
					} else {
						getErrorMap().clear();
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
						getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insertnotallowed"));
					}
				}
				resetAllComponent();
				resetSelectedRow();
				PM_IL_CVR_WAITING_PRD_BEAN.setRowSelected(true);

			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("post", e.getMessage());
			}
		}
	}
	
	
	public void populateBlockPM_IL_CVR_CONTR_PRD(){
		PM_IL_CVR_BASIC_CONTR_DELEGATE delegate = new PM_IL_CVR_BASIC_CONTR_DELEGATE();
		recordList=delegate.getBlockDataForPM_IL_CVR_CONTR_PRD();
		if(recordList.size()>0){
			this.setPM_IL_BASIC_CONTRIBUTION_BEAN(recordList.get(0));
			recordList.get(0).setRowSelected(true);
		}
	}
	
	

	public HtmlOutputLabel getCOMP_CVR_BASIC_CONTRIBUTION_FROM_LABEL() {
		return COMP_CVR_BASIC_CONTRIBUTION_FROM_LABEL;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_FROM_LABEL(
			HtmlOutputLabel comp_cvr_basic_contribution_from_label) {
		COMP_CVR_BASIC_CONTRIBUTION_FROM_LABEL = comp_cvr_basic_contribution_from_label;
	}

	public HtmlInputText getCOMP_CVR_BASIC_CONTRIBUTION_FROM() {
		return COMP_CVR_BASIC_CONTRIBUTION_FROM;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_FROM(
			HtmlInputText comp_cvr_basic_contribution_from) {
		COMP_CVR_BASIC_CONTRIBUTION_FROM = comp_cvr_basic_contribution_from;
	}

	public HtmlOutputLabel getCOMP_CVR_BASIC_CONTRIBUTION_TO_LABEL() {
		return COMP_CVR_BASIC_CONTRIBUTION_TO_LABEL;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_TO_LABEL(
			HtmlOutputLabel comp_cvr_basic_contribution_to_label) {
		COMP_CVR_BASIC_CONTRIBUTION_TO_LABEL = comp_cvr_basic_contribution_to_label;
	}

	public HtmlInputText getCOMP_CVR_BASIC_CONTRIBUTION_TO() {
		return COMP_CVR_BASIC_CONTRIBUTION_TO;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_TO(
			HtmlInputText comp_cvr_basic_contribution_to) {
		COMP_CVR_BASIC_CONTRIBUTION_TO = comp_cvr_basic_contribution_to;
	}

	public HtmlOutputLabel getCOMP_CVR_BASIC_CONTRIBUTION_LC_LABEL() {
		return COMP_CVR_BASIC_CONTRIBUTION_LC_LABEL;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_LC_LABEL(
			HtmlOutputLabel comp_cvr_basic_contribution_lc_label) {
		COMP_CVR_BASIC_CONTRIBUTION_LC_LABEL = comp_cvr_basic_contribution_lc_label;
	}

	public HtmlInputText getCOMP_CVR_BASIC_CONTRIBUTION_LC() {
		return COMP_CVR_BASIC_CONTRIBUTION_LC;
	}

	public void setCOMP_CVR_BASIC_CONTRIBUTION_LC(
			HtmlInputText comp_cvr_basic_contribution_lc) {
		COMP_CVR_BASIC_CONTRIBUTION_LC = comp_cvr_basic_contribution_lc;
	}

	public PM_IL_BASIC_CONTRIBUTION getPM_IL_BASIC_CONTRIBUTION_BEAN() {
		return PM_IL_BASIC_CONTRIBUTION_BEAN;
	}

	public void setPM_IL_BASIC_CONTRIBUTION_BEAN(
			PM_IL_BASIC_CONTRIBUTION pm_il_basic_contribution_bean) {
		PM_IL_BASIC_CONTRIBUTION_BEAN = pm_il_basic_contribution_bean;
	}

	public UIDataTable getCOMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE() {
		return COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE;
	}

	public void setCOMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE(
			UIDataTable comp_pm_il_cvr_basic_contr_prd_table) {
		COMP_PM_IL_CVR_BASIC_CONTR_PRD_TABLE = comp_pm_il_cvr_basic_contr_prd_table;
	}

	public String getFilterByBC_AGE_FROM() {
		return filterByBC_AGE_FROM;
	}

	public void setFilterByBC_AGE_FROM(String filterByBC_AGE_FROM) {
		this.filterByBC_AGE_FROM = filterByBC_AGE_FROM;
	}

	public String getFilterByBC_AGE_TO() {
		return filterByBC_AGE_TO;
	}

	public void setFilterByBC_AGE_TO(String filterByBC_AGE_TO) {
		this.filterByBC_AGE_TO = filterByBC_AGE_TO;
	}

}

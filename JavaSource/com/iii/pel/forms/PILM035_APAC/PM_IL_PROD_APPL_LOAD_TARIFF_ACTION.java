package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_LOAD_TARIFF_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PALT_SRNO_LABEL;

	private HtmlInputText COMP_PALT_SRNO;

	private HtmlOutputLabel COMP_PALT_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_PALT_APPLIED_ON;

	private HtmlOutputLabel COMP_PALT_TH_PARAM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PALT_TH_PARAM_TYPE;

	private HtmlOutputLabel COMP_PALT_TH_CODE_LABEL;

	private HtmlInputText COMP_PALT_TH_CODE;

	private HtmlOutputLabel COMP_UI_M_PALT_TH_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PALT_TH_CODE_DESC;

	private HtmlOutputLabel COMP_PALT_LOAD_APPL_PERC_LABEL;

	private HtmlInputText COMP_PALT_LOAD_APPL_PERC;

	private HtmlOutputLabel COMP_PALT_APPL_UPTO_LABEL;

	private HtmlInputText COMP_PALT_APPL_UPTO;

	private HtmlOutputLabel COMP_PALT_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PALT_DEFAULT_YN;

	//added by agalya
	private HtmlOutputLabel COMP_PALT_COVER_CODE_LABEL;

	private HtmlInputText COMP_PALT_COVER_CODE;

	private HtmlInputText COMP_UI_M_PALT_COVER_CODE_DESC;
	public HtmlInputText getCOMP_UI_M_PALT_COVER_CODE_DESC() {
		return COMP_UI_M_PALT_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_PALT_COVER_CODE_DESC(
			HtmlInputText cOMP_UI_M_PALT_COVER_CODE_DESC) {
		COMP_UI_M_PALT_COVER_CODE_DESC = cOMP_UI_M_PALT_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PALT_COVER_CODE_LABEL() {
		return COMP_PALT_COVER_CODE_LABEL;
	}

	public void setCOMP_PALT_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_PALT_COVER_CODE_LABEL) {
		COMP_PALT_COVER_CODE_LABEL = cOMP_PALT_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PALT_COVER_CODE() {
		return COMP_PALT_COVER_CODE;
	}

	public void setCOMP_PALT_COVER_CODE(HtmlInputText cOMP_PALT_COVER_CODE) {
		COMP_PALT_COVER_CODE = cOMP_PALT_COVER_CODE;
	}
	//end

	private PM_IL_PROD_APPL_LOAD_TARIFF PM_IL_PROD_APPL_LOAD_TARIFF_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_LOAD_TARIFF_HELPER helper;

	private List<PM_IL_PROD_APPL_LOAD_TARIFF> dataList_PM_IL_PROD_APPL_LOAD_TARIFF = new ArrayList<PM_IL_PROD_APPL_LOAD_TARIFF>();

	private UIData dataTable;

	private List<SelectItem> listPALT_APPLIED_ON = new ArrayList<SelectItem>();

	private List<SelectItem> listPALT_TH_PARAM_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPALT_DEFAULT_YN = new ArrayList<SelectItem>();

	public PM_IL_PROD_APPL_LOAD_TARIFF_ACTION() {

		COMP_PALT_LOAD_APPL_PERC = new HtmlInputText();
		PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = new PM_IL_PROD_APPL_LOAD_TARIFF();
		helper = new PM_IL_PROD_APPL_LOAD_TARIFF_HELPER();
		prepareDropDowns();
	}

	public void PALT_TH_PARAM_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_TH_PARAM_TYPE((String) value);
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

	private void prepareDropDowns() {
		try {
			setListPALT_APPLIED_ON(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_APPL_LOAD_TARIFF",
					"PM_IL_PROD_APPL_LOAD_TARIFF.PALT_APPLIED_ON",
					"IL_APPLIEDON"));

			setListPALT_TH_PARAM_TYPE(getListPALT_TH_PARAM_TYPE_MANUAL());

			setListPALT_DEFAULT_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_APPL_LOAD_TARIFF",
					"PM_IL_PROD_APPL_LOAD_TARIFF.PALT_DEFAULT_YN",
					"YESNO"));

		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	/*
	 * We are getting the values in the drop down that is more than one digit
	 * but the column allows only one value, so as suggested by vishnu doing
	 * manually
	 * 
	 */
	public List<SelectItem> getListPALT_TH_PARAM_TYPE_MANUAL(){
		List<SelectItem> retList = new ArrayList<SelectItem>();
		SelectItem item1 = new SelectItem();
		item1.setLabel("Discount");
		item1.setValue("D");

		SelectItem item2 = new SelectItem();
		item2.setLabel("Loading");
		item2.setValue("L");

		retList.add(item1);
		retList.add(item2);

		return retList;
	}

	public HtmlOutputLabel getCOMP_PALT_SRNO_LABEL() {
		return COMP_PALT_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_PALT_SRNO() {
		return COMP_PALT_SRNO;
	}

	public void setCOMP_PALT_SRNO_LABEL(HtmlOutputLabel COMP_PALT_SRNO_LABEL) {
		this.COMP_PALT_SRNO_LABEL = COMP_PALT_SRNO_LABEL;
	}

	public void setCOMP_PALT_SRNO(HtmlInputText COMP_PALT_SRNO) {
		this.COMP_PALT_SRNO = COMP_PALT_SRNO;
	}

	public HtmlOutputLabel getCOMP_PALT_APPLIED_ON_LABEL() {
		return COMP_PALT_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PALT_APPLIED_ON() {
		return COMP_PALT_APPLIED_ON;
	}

	public void setCOMP_PALT_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_PALT_APPLIED_ON_LABEL) {
		this.COMP_PALT_APPLIED_ON_LABEL = COMP_PALT_APPLIED_ON_LABEL;
	}

	public void setCOMP_PALT_APPLIED_ON(HtmlSelectOneMenu COMP_PALT_APPLIED_ON) {
		this.COMP_PALT_APPLIED_ON = COMP_PALT_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_PALT_TH_PARAM_TYPE_LABEL() {
		return COMP_PALT_TH_PARAM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PALT_TH_PARAM_TYPE() {
		return COMP_PALT_TH_PARAM_TYPE;
	}

	public void setCOMP_PALT_TH_PARAM_TYPE_LABEL(
			HtmlOutputLabel COMP_PALT_TH_PARAM_TYPE_LABEL) {
		this.COMP_PALT_TH_PARAM_TYPE_LABEL = COMP_PALT_TH_PARAM_TYPE_LABEL;
	}

	public void setCOMP_PALT_TH_PARAM_TYPE(
			HtmlSelectOneMenu COMP_PALT_TH_PARAM_TYPE) {
		this.COMP_PALT_TH_PARAM_TYPE = COMP_PALT_TH_PARAM_TYPE;
	}

	public HtmlOutputLabel getCOMP_PALT_TH_CODE_LABEL() {
		return COMP_PALT_TH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PALT_TH_CODE() {
		return COMP_PALT_TH_CODE;
	}

	public void setCOMP_PALT_TH_CODE_LABEL(
			HtmlOutputLabel COMP_PALT_TH_CODE_LABEL) {
		this.COMP_PALT_TH_CODE_LABEL = COMP_PALT_TH_CODE_LABEL;
	}

	public void setCOMP_PALT_TH_CODE(HtmlInputText COMP_PALT_TH_CODE) {
		this.COMP_PALT_TH_CODE = COMP_PALT_TH_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PALT_TH_CODE_DESC_LABEL() {
		return COMP_UI_M_PALT_TH_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PALT_TH_CODE_DESC() {
		return COMP_UI_M_PALT_TH_CODE_DESC;
	}

	public void setCOMP_UI_M_PALT_TH_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PALT_TH_CODE_DESC_LABEL) {
		this.COMP_UI_M_PALT_TH_CODE_DESC_LABEL = COMP_UI_M_PALT_TH_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PALT_TH_CODE_DESC(
			HtmlInputText COMP_UI_M_PALT_TH_CODE_DESC) {
		this.COMP_UI_M_PALT_TH_CODE_DESC = COMP_UI_M_PALT_TH_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PALT_LOAD_APPL_PERC_LABEL() {
		return COMP_PALT_LOAD_APPL_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PALT_LOAD_APPL_PERC() {
		return COMP_PALT_LOAD_APPL_PERC;
	}

	public void setCOMP_PALT_LOAD_APPL_PERC_LABEL(
			HtmlOutputLabel COMP_PALT_LOAD_APPL_PERC_LABEL) {
		this.COMP_PALT_LOAD_APPL_PERC_LABEL = COMP_PALT_LOAD_APPL_PERC_LABEL;
	}

	public void setCOMP_PALT_LOAD_APPL_PERC(
			HtmlInputText COMP_PALT_LOAD_APPL_PERC) {
		this.COMP_PALT_LOAD_APPL_PERC = COMP_PALT_LOAD_APPL_PERC;
	}

	public HtmlOutputLabel getCOMP_PALT_APPL_UPTO_LABEL() {
		return COMP_PALT_APPL_UPTO_LABEL;
	}

	public HtmlInputText getCOMP_PALT_APPL_UPTO() {
		return COMP_PALT_APPL_UPTO;
	}

	public void setCOMP_PALT_APPL_UPTO_LABEL(
			HtmlOutputLabel COMP_PALT_APPL_UPTO_LABEL) {
		this.COMP_PALT_APPL_UPTO_LABEL = COMP_PALT_APPL_UPTO_LABEL;
	}

	public void setCOMP_PALT_APPL_UPTO(HtmlInputText COMP_PALT_APPL_UPTO) {
		this.COMP_PALT_APPL_UPTO = COMP_PALT_APPL_UPTO;
	}

	public HtmlOutputLabel getCOMP_PALT_DEFAULT_YN_LABEL() {
		return COMP_PALT_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PALT_DEFAULT_YN() {
		return COMP_PALT_DEFAULT_YN;
	}

	public void setCOMP_PALT_DEFAULT_YN_LABEL(
			HtmlOutputLabel COMP_PALT_DEFAULT_YN_LABEL) {
		this.COMP_PALT_DEFAULT_YN_LABEL = COMP_PALT_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PALT_DEFAULT_YN(HtmlSelectOneMenu COMP_PALT_DEFAULT_YN) {
		this.COMP_PALT_DEFAULT_YN = COMP_PALT_DEFAULT_YN;
	}

	public PM_IL_PROD_APPL_LOAD_TARIFF getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN() {
		return PM_IL_PROD_APPL_LOAD_TARIFF_BEAN;
	}

	public void setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
			PM_IL_PROD_APPL_LOAD_TARIFF PM_IL_PROD_APPL_LOAD_TARIFF_BEAN) {
		this.PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = PM_IL_PROD_APPL_LOAD_TARIFF_BEAN;
	}

	public List<PM_IL_PROD_APPL_LOAD_TARIFF> getDataList_PM_IL_PROD_APPL_LOAD_TARIFF() {
		return dataList_PM_IL_PROD_APPL_LOAD_TARIFF;
	}

	public void setDataListPM_IL_PROD_APPL_LOAD_TARIFF(
			List<PM_IL_PROD_APPL_LOAD_TARIFF> dataList_PM_IL_PROD_APPL_LOAD_TARIFF) {
		this.dataList_PM_IL_PROD_APPL_LOAD_TARIFF = dataList_PM_IL_PROD_APPL_LOAD_TARIFF;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				COMP_PALT_COVER_CODE.setDisabled(true);
				helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = new PM_IL_PROD_APPL_LOAD_TARIFF();
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
						PM_IL_PROD_APPL_LOAD_TARIFF_BEAN, CommonUtils
						.getConnection());
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
				dataList_PM_IL_PROD_APPL_LOAD_TARIFF
				.remove(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
				if (dataList_PM_IL_PROD_APPL_LOAD_TARIFF.size() > 0) {

					PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = dataList_PM_IL_PROD_APPL_LOAD_TARIFF
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_LOAD_TARIFF.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				//added by agalya to set product code value for duplicate combination exits or not
				System.out.println("**** DISCOUNT LOADING postRecord METHOD ****");
				
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN().getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
				//end
				boolean isexist = helper.duplicateCheck(compositeAction);
				System.out.println("compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN().getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_DEFAULT_YN()   :  "+compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN().getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_DEFAULT_YN());
				System.out.println("isexist   : "+isexist);
				if (!isexist) {
					
					System.out.println();
					helper.PRE_INSERT(compositeAction);
					System.out.println("pm_il_prod_appl_load_tariff_bean.getPALT_DEFAULT_YN()    : "+PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_DEFAULT_YN());
					
					new CRUDHandler().executeInsert(
							PM_IL_PROD_APPL_LOAD_TARIFF_BEAN, CommonUtils
							.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					dataList_PM_IL_PROD_APPL_LOAD_TARIFF
					.add(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
				}else{
					getErrorMap().put("current","Cover Code Already Exists.Please Re-Enter");
				}
			} else if (PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(
						PM_IL_PROD_APPL_LOAD_TARIFF_BEAN, CommonUtils
						.getConnection());
			
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().clear();
			
			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Code Already Exists.Please Re-Enter");
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					"Code Already Exists.Please Re-Enter");*/
			//getErrorMap().put("current","Cover Code Already Exists.Please Re-Enter");
			throw new ValidatorException(new FacesMessage(exc.getMessage()));

		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = (PM_IL_PROD_APPL_LOAD_TARIFF) dataTable
					.getRowData();
			PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_LOAD_TARIFF> PM_IL_PROD_APPL_LOAD_TARIFF_ITR = dataList_PM_IL_PROD_APPL_LOAD_TARIFF
				.iterator();
		while (PM_IL_PROD_APPL_LOAD_TARIFF_ITR.hasNext()) {
			PM_IL_PROD_APPL_LOAD_TARIFF_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PALT_SRNO.resetValue();
		COMP_PALT_APPLIED_ON.resetValue();
		COMP_PALT_TH_PARAM_TYPE.resetValue();
		COMP_PALT_TH_CODE.resetValue();
		COMP_UI_M_PALT_TH_CODE_DESC.resetValue();
		COMP_PALT_LOAD_APPL_PERC.resetValue();
		COMP_PALT_APPL_UPTO.resetValue();
		COMP_PALT_DEFAULT_YN.resetValue();
		//added by agalya
		COMP_PALT_COVER_CODE.resetValue();
		COMP_UI_M_PALT_COVER_CODE_DESC.resetValue();
		//end
		
		/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */
		COMP_PALT_FORMULA_CODE.resetValue();
		COMP_UI_M_FORMULA_CODE_DESC.resetValue();
		/*End*/
		
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
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
	}


	//added by agalya 

	public ArrayList<LovBean> prepareSuggestionList_PALT_COVER_CODE(Object object) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String currentValue = (String) object;

		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_LOAD_TARIFF", "PALT_COVER_CODE", 
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE(), null, null, null,
					null, (String) currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return suggestionList;
	}

	public void PALT_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String curr=(String) value;
			String prev=getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_COVER_CODE();
			getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_COVER_CODE((String) value);
			/*
			if(!prev.equalsIgnoreCase(curr)){
			helper.PDL_COVER_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		}*/
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	//end
	public List<SelectItem> getListPALT_APPLIED_ON() {
		if (listPALT_APPLIED_ON.size() == 0) {
			listPALT_APPLIED_ON.clear();
			try {
				listPALT_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPALT_APPLIED_ON;
	}

	public void setListPALT_APPLIED_ON(List<SelectItem> listPALT_APPLIED_ON) {
		this.listPALT_APPLIED_ON = listPALT_APPLIED_ON;
	}

	public List<SelectItem> getListPALT_TH_PARAM_TYPE() {
		if (listPALT_TH_PARAM_TYPE.size() == 0) {
			listPALT_TH_PARAM_TYPE.clear();
			try {
				listPALT_TH_PARAM_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPALT_TH_PARAM_TYPE;
	}

	public void setListPALT_TH_PARAM_TYPE(
			List<SelectItem> listPALT_TH_PARAM_TYPE) {
		this.listPALT_TH_PARAM_TYPE = listPALT_TH_PARAM_TYPE;
	}

	public List<SelectItem> getListPALT_DEFAULT_YN() {
		if (listPALT_DEFAULT_YN.size() == 0) {
			listPALT_DEFAULT_YN.clear();
			try {
				listPALT_DEFAULT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPALT_DEFAULT_YN;
	}

	public void setListPALT_DEFAULT_YN(List<SelectItem> listPALT_DEFAULT_YN) {
		this.listPALT_DEFAULT_YN = listPALT_DEFAULT_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		getErrorMap().clear(); 
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				if(getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			
			/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */

			System.out.println("applied on value    :"+ getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_APPLIED_ON());

			if(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON().equalsIgnoreCase("15"))
			{
				COMP_PALT_FORMULA_CODE.setDisabled(false);
				  COMP_PALT_FORMULA_CODE.resetValue();
			}else
			{
				COMP_PALT_FORMULA_CODE.setDisabled(true);
				  COMP_PALT_FORMULA_CODE.resetValue();
			}
			/*End*/
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void PALT_SRNO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_SRNO((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PALT_SRNO(compositeAction, value);
			
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

	public void PALT_APPLIED_ON_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {		
			helper.WHEN_VALIDATE_ITEM_PALT_APPLIED_ON(compositeAction, value);
			getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_APPLIED_ON((String) value);

			//added by agalya
			if ("10".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON())				
					|| "3".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON())
					|| "6".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON())
					|| "7".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON())
					|| "8".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON())
					|| "9".equals(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON()))

			{
				System.out.println("applied on value    :"+ getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_APPLIED_ON());
				COMP_PALT_COVER_CODE.setDisabled(false);			


			}
			else
			{
				System.out.println("applied on value    :"+ getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_APPLIED_ON());
				COMP_PALT_COVER_CODE.setDisabled(true);
			}

			//end

			/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */
			
			System.out.println("applied on value    :"+ getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_APPLIED_ON());
			
			if(PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_APPLIED_ON().equalsIgnoreCase("15"))
			{
                
                 COMP_PALT_FORMULA_CODE.resetValue();
                 COMP_PALT_FORMULA_CODE.setDisabled(false);
                 
			}else
			{
				
				 COMP_PALT_FORMULA_CODE.setDisabled(true);
				 
				 /* Newly Added By Dhinesh on 10.05.2018 */
				 
				 PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_FORMULA_CODE(null);
				 PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setUI_M_FORMULA_CODE_DESC(null);
				 COMP_PALT_FORMULA_CODE.resetValue();
				 COMP_UI_M_FORMULA_CODE_DESC.resetValue();
				 
				 /* End */
			}
			/*End*/

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
	
	
	
	public void PALT_DEFAULT_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {	
			
			System.out.println("ENTER PALT_DEFAULT_YN_Validator METHOD  ");
			System.out.println("(String) value    :  "+(String) value);
			//helper.WHEN_VALIDATE_ITEM_PALT_DEFAULT_YN(compositeAction);
			System.out.println("(String) value    :  "+(String) value);
			compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN().getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_DEFAULT_YN((String) value);
			//getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_DEFAULT_YN((String) value);
			System.out.println("getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_DEFAULT_YN   : "+getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().getPALT_DEFAULT_YN());
			COMP_PALT_DEFAULT_YN.resetValue();

			//end


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
	
	public void PALT_TH_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PALT_TH_CODE(compositeAction, value);
			getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_TH_CODE((String) value);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_FROM().resetValue();
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_PERIOD_TO().resetValue();
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PLAN_MAX_AGE_ON_MAT().resetValue();
			COMP_PALT_LOAD_APPL_PERC.resetValue();
			COMP_UI_M_PALT_TH_CODE_DESC.resetValue();
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
	public void PALT_LOAD_APPL_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PALT_LOAD_APPL_PERC(compositeAction, value);
			getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN().setPALT_LOAD_APPL_PERC((Double) value);
			COMP_UI_M_PALT_TH_CODE_DESC.resetValue();
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

	public List<LovBean> lovPALT_TH_CODE(Object currValue) {		
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN().getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();

		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_LOAD_TARIFF", "PALT_TH_CODE", pm_il_prod_appl_load_tariff_bean.getPALT_TH_PARAM_TYPE(), null, null, null,
					null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */

	private HtmlOutputLabel COMP_PALT_FORMULA_CODE_LABEL;

	private HtmlInputText COMP_PALT_FORMULA_CODE;
	
	private HtmlInputText COMP_UI_M_FORMULA_CODE_DESC;
	
	
	public HtmlInputText getCOMP_UI_M_FORMULA_CODE_DESC() {
		return COMP_UI_M_FORMULA_CODE_DESC;
	}

	public void setCOMP_UI_M_FORMULA_CODE_DESC(
			HtmlInputText cOMP_UI_M_FORMULA_CODE_DESC) {
		COMP_UI_M_FORMULA_CODE_DESC = cOMP_UI_M_FORMULA_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PALT_FORMULA_CODE_LABEL() {
		return COMP_PALT_FORMULA_CODE_LABEL;
	}

	public void setCOMP_PALT_FORMULA_CODE_LABEL(
			HtmlOutputLabel cOMP_PALT_FORMULA_CODE_LABEL) {
		COMP_PALT_FORMULA_CODE_LABEL = cOMP_PALT_FORMULA_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PALT_FORMULA_CODE() {
		return COMP_PALT_FORMULA_CODE;
	}

	public void setCOMP_PALT_FORMULA_CODE(HtmlInputText cOMP_PALT_FORMULA_CODE) {
		COMP_PALT_FORMULA_CODE = cOMP_PALT_FORMULA_CODE;
	}
	
	
	public void PALT_FORMULA_CODE_Validator(FacesContext context ,UIComponent component ,Object value){
		try{
			System.out.println("enters into PALT_FORMULA_CODE_Validator");
		
			String objValue = (String)value;
			PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_FORMULA_CODE(objValue);
		
			System.out.println("getPALT_FORMULA_CODE               "+PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_FORMULA_CODE());
			COMP_PALT_FORMULA_CODE.resetValue();
			COMP_UI_M_FORMULA_CODE_DESC.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}	

	public List<LovBean> lovUI_M_FORMULA_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE  " +
					"(FRM_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("FORMULA_CODE", e.getMessage());
		}
		return suggestionList;
	}


	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	public void instantiateAllComponent() {
		
		COMP_PALT_FORMULA_CODE_LABEL = new HtmlOutputLabel();
		COMP_PALT_FORMULA_CODE = new HtmlInputText();
		COMP_UI_M_FORMULA_CODE_DESC = new HtmlInputText();
	}
	/*End*/
	
}

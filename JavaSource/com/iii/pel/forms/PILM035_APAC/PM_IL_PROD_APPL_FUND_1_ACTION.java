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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_FUND_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAF_FUND_CODE_LABEL;

	private HtmlInputText COMP_PAF_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FUND_DESC;

	private HtmlOutputLabel COMP_PAF_FUND_PERC_LABEL;

	private HtmlInputText COMP_PAF_FUND_PERC;

	private HtmlOutputLabel COMP_PAF_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAF_DEFAULT_YN;

	private HtmlOutputLabel COMP_UI_M_SUM_FUND_PERC_LABEL;

	private HtmlInputText COMP_UI_M_SUM_FUND_PERC;

	private PM_IL_PROD_APPL_FUND_1 PM_IL_PROD_APPL_FUND_1_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_FUND_1_HELPER helper;

	private List<PM_IL_PROD_APPL_FUND_1> dataList_PM_IL_PROD_APPL_FUND_1 = new ArrayList<PM_IL_PROD_APPL_FUND_1>();

	private UIData dataTable;
	
	private Double totalPerc = 0.0;

	private List<SelectItem> listPAF_DEFAULT_YN = new ArrayList<SelectItem>();

	public PM_IL_PROD_APPL_FUND_1_ACTION() {

		PM_IL_PROD_APPL_FUND_1_BEAN = new PM_IL_PROD_APPL_FUND_1();
		helper = new PM_IL_PROD_APPL_FUND_1_HELPER();
		
		prepareDropDowns();
	}
	
	private void prepareDropDowns(){
		try {
			setListPAF_DEFAULT_YN(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_FUND",
					"PM_IL_PROD_APPL_FUND.PAF_DEFAULT_YN", "YESNO"));
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_PAF_FUND_CODE_LABEL() {
		return COMP_PAF_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAF_FUND_CODE() {
		return COMP_PAF_FUND_CODE;
	}

	public void setCOMP_PAF_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_PAF_FUND_CODE_LABEL) {
		this.COMP_PAF_FUND_CODE_LABEL = COMP_PAF_FUND_CODE_LABEL;
	}

	public void setCOMP_PAF_FUND_CODE(HtmlInputText COMP_PAF_FUND_CODE) {
		this.COMP_PAF_FUND_CODE = COMP_PAF_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FUND_DESC_LABEL() {
		return COMP_UI_M_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FUND_DESC() {
		return COMP_UI_M_FUND_DESC;
	}

	public void setCOMP_UI_M_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL) {
		this.COMP_UI_M_FUND_DESC_LABEL = COMP_UI_M_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_FUND_DESC(HtmlInputText COMP_UI_M_FUND_DESC) {
		this.COMP_UI_M_FUND_DESC = COMP_UI_M_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_PAF_FUND_PERC_LABEL() {
		return COMP_PAF_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAF_FUND_PERC() {
		return COMP_PAF_FUND_PERC;
	}

	public void setCOMP_PAF_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_PAF_FUND_PERC_LABEL) {
		this.COMP_PAF_FUND_PERC_LABEL = COMP_PAF_FUND_PERC_LABEL;
	}

	public void setCOMP_PAF_FUND_PERC(HtmlInputText COMP_PAF_FUND_PERC) {
		this.COMP_PAF_FUND_PERC = COMP_PAF_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_PAF_DEFAULT_YN_LABEL() {
		return COMP_PAF_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAF_DEFAULT_YN() {
		return COMP_PAF_DEFAULT_YN;
	}

	public void setCOMP_PAF_DEFAULT_YN_LABEL(
			HtmlOutputLabel COMP_PAF_DEFAULT_YN_LABEL) {
		this.COMP_PAF_DEFAULT_YN_LABEL = COMP_PAF_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PAF_DEFAULT_YN(HtmlSelectOneMenu COMP_PAF_DEFAULT_YN) {
		this.COMP_PAF_DEFAULT_YN = COMP_PAF_DEFAULT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_FUND_PERC_LABEL() {
		return COMP_UI_M_SUM_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_FUND_PERC() {
		return COMP_UI_M_SUM_FUND_PERC;
	}

	public void setCOMP_UI_M_SUM_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_FUND_PERC_LABEL) {
		this.COMP_UI_M_SUM_FUND_PERC_LABEL = COMP_UI_M_SUM_FUND_PERC_LABEL;
	}

	public void setCOMP_UI_M_SUM_FUND_PERC(HtmlInputText COMP_UI_M_SUM_FUND_PERC) {
		this.COMP_UI_M_SUM_FUND_PERC = COMP_UI_M_SUM_FUND_PERC;
	}

	public PM_IL_PROD_APPL_FUND_1 getPM_IL_PROD_APPL_FUND_1_BEAN() {
		return PM_IL_PROD_APPL_FUND_1_BEAN;
	}

	public void setPM_IL_PROD_APPL_FUND_1_BEAN(
			PM_IL_PROD_APPL_FUND_1 PM_IL_PROD_APPL_FUND_1_BEAN) {
		this.PM_IL_PROD_APPL_FUND_1_BEAN = PM_IL_PROD_APPL_FUND_1_BEAN;
	}

	public List<PM_IL_PROD_APPL_FUND_1> getDataList_PM_IL_PROD_APPL_FUND_1() {
		return dataList_PM_IL_PROD_APPL_FUND_1;
	}

	public void setDataListPM_IL_PROD_APPL_FUND_1(
			List<PM_IL_PROD_APPL_FUND_1> dataList_PM_IL_PROD_APPL_FUND_1) {
		this.dataList_PM_IL_PROD_APPL_FUND_1 = dataList_PM_IL_PROD_APPL_FUND_1;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				
				if("S".equalsIgnoreCase(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_FUND_ALLOWED())){
					if(PM_IL_PROD_APPL_FUND_1_BEAN.getROWID()!=null){
					throw new Exception("For Fund Allowed 'Single' only one fund is allowed");
				}
				
			}else{
				helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_APPL_FUND_1_BEAN = new PM_IL_PROD_APPL_FUND_1();
				}
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

				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_FUND_1_BEAN,
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
				dataList_PM_IL_PROD_APPL_FUND_1
						.remove(PM_IL_PROD_APPL_FUND_1_BEAN);
				if (dataList_PM_IL_PROD_APPL_FUND_1.size() > 0) {

					PM_IL_PROD_APPL_FUND_1_BEAN = dataList_PM_IL_PROD_APPL_FUND_1
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_FUND_1.size() == 0) {
					PM_IL_PROD_APPL_FUND_1_BEAN=new PM_IL_PROD_APPL_FUND_1();
					addRow(null);
				}
				resetAllComponent();
				PM_IL_PROD_APPL_FUND_1_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_APPL_FUND_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_FUND_1_BEAN,
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
				dataList_PM_IL_PROD_APPL_FUND_1
						.add(PM_IL_PROD_APPL_FUND_1_BEAN);
			} else if (PM_IL_PROD_APPL_FUND_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_FUND_1_BEAN,
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

			PM_IL_PROD_APPL_FUND_1_BEAN.setRowSelected(true);
			calcTotalAllocationPerc();
			if(totalPerc > 100){
				throw new Exception("Fund Percentage total should be 100");
			}
			/*......*/
			PM_IL_PROD_APPL_FUND_1_BEAN.setRowSelected(true);
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
			PM_IL_PROD_APPL_FUND_1_BEAN = (PM_IL_PROD_APPL_FUND_1) dataTable
					.getRowData();
			PM_IL_PROD_APPL_FUND_1_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			calcTotalAllocationPerc();
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_FUND_1> PM_IL_PROD_APPL_FUND_1_ITR = dataList_PM_IL_PROD_APPL_FUND_1
				.iterator();
		while (PM_IL_PROD_APPL_FUND_1_ITR.hasNext()) {
			PM_IL_PROD_APPL_FUND_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAF_FUND_CODE.resetValue();
		COMP_UI_M_FUND_DESC.resetValue();
		COMP_PAF_FUND_PERC.resetValue();
		COMP_PAF_DEFAULT_YN.resetValue();
		COMP_UI_M_SUM_FUND_PERC.resetValue();
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
	public List<SelectItem> getListPAF_DEFAULT_YN() {
		if (listPAF_DEFAULT_YN.size() == 0) {
			listPAF_DEFAULT_YN.clear();
			try {
				listPAF_DEFAULT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAF_DEFAULT_YN;
	}

	public void setListPAF_DEFAULT_YN(List<SelectItem> listPAF_DEFAULT_YN) {
		this.listPAF_DEFAULT_YN = listPAF_DEFAULT_YN;
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
				if(getPM_IL_PROD_APPL_FUND_1_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
					calcTotalAllocationPerc();
				}
				helper.WHEN_NEW_RECORD_INSTANACE(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void PAF_FUND_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_FUND_1_BEAN().setPAF_FUND_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PAF_FUND_CODE(compositeAction, value);
			COMP_PAF_FUND_PERC.resetValue();
			COMP_PAF_DEFAULT_YN.resetValue();
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
	public void PAF_FUND_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_FUND_1_BEAN().setPAF_FUND_PERC((Double) value);
			helper.WHEN_VALIDATE_ITEM_PAF_FUND_PERC(compositeAction, value);
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
	public void PAF_DEFAULT_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_FUND_1_BEAN().setPAF_DEFAULT_YN((String) value);
			helper.WHEN_VALIDATE_ITEM_PAF_DEFAULT_YN(compositeAction, value);
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
	
	public List<LovBean> lovPAF_FUND_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_FUND_1", "PAF_FUND_CODE", null, null, null, null,
					null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String goBack(){
		return "PILM035_APAC_PM_IL_PROD_APPL_FUND";
	}

	public Double getTotalPerc() {
		return totalPerc;
	}

	public void setTotalPerc(Double totalPerc) {
		this.totalPerc = totalPerc;
	}
	
	private void calcTotalAllocationPerc(){
		Double sumTotal = 0.0;
		for(PM_IL_PROD_APPL_FUND_1 PM_IL_PROD_APPL_FUND_1_BEAN : getDataList_PM_IL_PROD_APPL_FUND_1()){
			sumTotal = sumTotal + PM_IL_PROD_APPL_FUND_1_BEAN.getPAF_FUND_PERC();
		}
		setTotalPerc(sumTotal);
	}
}

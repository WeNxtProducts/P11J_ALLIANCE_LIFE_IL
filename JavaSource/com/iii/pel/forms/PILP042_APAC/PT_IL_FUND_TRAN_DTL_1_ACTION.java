package com.iii.pel.forms.PILP042_APAC;

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
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FTD_FUND_CODE_1_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE_1;

	private HtmlOutputLabel COMP_UI_M_FUND_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_FUND_DESC_1;

	private HtmlOutputLabel COMP_FTD_UNIT_TYPE_1_LABEL;

	private HtmlSelectOneMenu COMP_FTD_UNIT_TYPE_1;

	private HtmlOutputLabel COMP_FTD_SELECT_YN_LABEL;

	private HtmlSelectOneMenu COMP_FTD_SELECT_YN;

	private HtmlOutputLabel COMP_FTD_NO_OF_UNITS_1_LABEL;

	private HtmlInputText COMP_FTD_NO_OF_UNITS_1;

	private HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL;

	private HtmlInputText COMP_FTD_FUND_PERC;

	private HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_1_LABEL;

	private HtmlInputText COMP_FTD_UNIT_SEL_PRICE_1;

	private HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_1_LABEL;

	private HtmlInputText COMP_FTD_UNIT_LC_AMT_1;

	private HtmlOutputLabel COMP_FTD_NO_SEL_UNITS_1_LABEL;

	private HtmlInputText COMP_FTD_NO_SEL_UNITS_1;

	private HtmlOutputLabel COMP_FTD_NO_ALLOC_LC_AMT_1_LABEL;

	private HtmlInputText COMP_FTD_NO_ALLOC_LC_AMT_1;

	private HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL;

	private HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE_P;

	private HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL;

	private HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE_T;

	private HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL;
	
	private HtmlOutputLabel COMP_FTD_BEF_SWT_PERC_LABEL;

	private HtmlInputText COMP_FTD_BEF_SWT_PERC;
	
	private HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE;
	
	private HtmlInputText COMP_UI_M_PFTD_FUND_DESC;

	/* Newly Added By Dhinesh on 26-7-2017 */

	private HtmlOutputLabel COMP_FTD_SWITCH_BASED_ON_LABEL;

	private HtmlSelectOneMenu COMP_FTD_SWITCH_BASED_ON;
	
	/* End */
	
	private PT_IL_FUND_TRAN_DTL_1 PT_IL_FUND_TRAN_DTL_1_BEAN;

	private boolean DELETE_ALLOWED = true;

	private boolean UPDATE_ALLOWED = true;

	private boolean INSERT_ALLOWED = true;

	private List<PT_IL_FUND_TRAN_DTL_1> dataTableList1;

	private UIData dataTable1;

	private int recordsPerPage = 10;

	private int prevRowIndex;

	private int currentpage;

	private int lastUpdateRowIndex;

	private List<SelectItem> unitTypeList = new ArrayList<SelectItem>();

	private List<SelectItem> selectYnList = new ArrayList<SelectItem>();
	
	private List<SelectItem> ftd_Switch_Based_Onlist = new ArrayList<SelectItem>();

	PT_IL_FUND_TRAN_DTL_DELEGATE delegate = new PT_IL_FUND_TRAN_DTL_DELEGATE();

	PT_IL_FUND_TRAN_DTL_1_HELPER helper = new PT_IL_FUND_TRAN_DTL_1_HELPER();

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();
	
	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}
	
	public PILP042_APAC_COMPOSITE_ACTION compositeAction;

	public PT_IL_FUND_TRAN_DTL_1_ACTION() {
		PT_IL_FUND_TRAN_DTL_1_BEAN = new PT_IL_FUND_TRAN_DTL_1();
		unitTypeList = delegate.comboBoxValues("PILP042_APAC",
				"PT_IL_FUND_TRAN_DTL_1", "PT_IL_FUND_TRAN_DTL_1.FTD_UNIT_TYPE",
				"IL_FUND_DIR");
		selectYnList = delegate.comboBoxValues("PILP042_APAC",
				"PT_IL_FUND_TRAN_DTL_1", "PT_IL_FUND_TRAN_DTL_1.FTD_SELECT_YN",
				"YESNO");
		
		ftd_Switch_Based_Onlist = delegate.comboBoxValues("PILP042_APAC",
				"PT_IL_FUND_TRAN_DTL", "PT_IL_FUND_TRAN_DTL.FTD_SWITCH_BASED_ON",
				"IL_FUND_SWCH");
		
		instantiateAllComponent();
	}

	/**
	 * Grid Tab Listener is used to update Component Values.
	 */
	public void gridtabListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable1().getRowIndex();
		int rowUpdated = 0;
		PT_IL_FUND_TRAN_DTL_1 gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PT_IL_FUND_TRAN_DTL_1) dataTableList1
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Updated");
						} else {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;
	}

	/**
	 * Used For inserting & Updating Values after Tabbing out of last column
	 */
	public void lastColumnListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable1().getRowIndex();
		int rowUpdated = 0;
		PT_IL_FUND_TRAN_DTL_1 gridValueBean = null;
		ControlBean controlBean = new ControlBean();
		try {

			// Get the bean based on row index
			gridValueBean = (PT_IL_FUND_TRAN_DTL_1) dataTableList1
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
                System.out.println("ROW ID IS :"+gridValueBean.getROWID());
//                gridValueBean.setFTD_SELECT_YN("N");
                gridValueBean.setFTD_TRAN_TYPE("H");
                gridValueBean.setFTD_TRAN_FLAG("S");
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {

			
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}
		return;
	}

	

	public HtmlOutputLabel getCOMP_FTD_SELECT_YN_LABEL() {
		return COMP_FTD_SELECT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FTD_SELECT_YN() {
		return COMP_FTD_SELECT_YN;
	}

	public void setCOMP_FTD_SELECT_YN_LABEL(
			HtmlOutputLabel COMP_FTD_SELECT_YN_LABEL) {
		this.COMP_FTD_SELECT_YN_LABEL = COMP_FTD_SELECT_YN_LABEL;
	}

	public void setCOMP_FTD_SELECT_YN(HtmlSelectOneMenu COMP_FTD_SELECT_YN) {
		this.COMP_FTD_SELECT_YN = COMP_FTD_SELECT_YN;
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_PERC_LABEL() {
		return COMP_FTD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_PERC() {
		return COMP_FTD_FUND_PERC;
	}

	public void setCOMP_FTD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL) {
		this.COMP_FTD_FUND_PERC_LABEL = COMP_FTD_FUND_PERC_LABEL;
	}

	public void setCOMP_FTD_FUND_PERC(HtmlInputText COMP_FTD_FUND_PERC) {
		this.COMP_FTD_FUND_PERC = COMP_FTD_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_ALLOC_LC_VALUE_P() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE_P;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL = COMP_UI_M_SUM_ALLOC_LC_VALUE_P_LABEL;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE_P(
			HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE_P) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE_P = COMP_UI_M_SUM_ALLOC_LC_VALUE_P;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_ALLOC_LC_VALUE_T() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE_T;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL = COMP_UI_M_SUM_ALLOC_LC_VALUE_T_LABEL;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE_T(
			HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE_T) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE_T = COMP_UI_M_SUM_ALLOC_LC_VALUE_T;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_ALLOC_LC_VALUE() {
		return COMP_UI_M_SUM_ALLOC_LC_VALUE;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL = COMP_UI_M_SUM_ALLOC_LC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_SUM_ALLOC_LC_VALUE(
			HtmlInputText COMP_UI_M_SUM_ALLOC_LC_VALUE) {
		this.COMP_UI_M_SUM_ALLOC_LC_VALUE = COMP_UI_M_SUM_ALLOC_LC_VALUE;
	}

	public PT_IL_FUND_TRAN_DTL_1 getPT_IL_FUND_TRAN_DTL_1_BEAN() {
		return PT_IL_FUND_TRAN_DTL_1_BEAN;
	}

	public void setPT_IL_FUND_TRAN_DTL_1_BEAN(
			PT_IL_FUND_TRAN_DTL_1 PT_IL_FUND_TRAN_DTL_1_BEAN) {
		this.PT_IL_FUND_TRAN_DTL_1_BEAN = PT_IL_FUND_TRAN_DTL_1_BEAN;
	}

	public boolean isDELETE_ALLOWED() {
		return DELETE_ALLOWED;
	}

	public void setDELETE_ALLOWED(boolean delete_allowed) {
		DELETE_ALLOWED = delete_allowed;
	}

	public boolean isUPDATE_ALLOWED() {
		return UPDATE_ALLOWED;
	}

	public void setUPDATE_ALLOWED(boolean update_allowed) {
		UPDATE_ALLOWED = update_allowed;
	}

	public boolean isINSERT_ALLOWED() {
		return INSERT_ALLOWED;
	}

	public void setINSERT_ALLOWED(boolean insert_allowed) {
		INSERT_ALLOWED = insert_allowed;
	}

	public List<PT_IL_FUND_TRAN_DTL_1> getDataTableList1() {
		return dataTableList1;
	}

	public void setDataTableList1(List<PT_IL_FUND_TRAN_DTL_1> dataTableList1) {
		this.dataTableList1 = dataTableList1;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public List<SelectItem> getUnitTypeList() {
		return unitTypeList;
	}

	public void setUnitTypeList(List<SelectItem> unitTypeList) {
		this.unitTypeList = unitTypeList;
	}

	public List<SelectItem> getSelectYnList() {
		return selectYnList;
	}

	public void setSelectYnList(List<SelectItem> selectYnList) {
		this.selectYnList = selectYnList;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}
	
	public void selectedCheckbox(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();

		String selected = (String) (input.getSubmittedValue());
		int row = dataTable1.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}

		PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl = dataTableList1.get(row);

		if (selected.equals("true"))
			pt_il_fund_tran_dtl.setSelected(true);
		else
			pt_il_fund_tran_dtl.setSelected(false);
		System.out.println("SELETED LIST" + selectedList);
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void fireFieldValidation() {
		try {
			Object value = compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_FUND_PERC().getSubmittedValue();
			PT_IL_FUND_TRAN_DTL_1 dtl1Bean=this.getPT_IL_FUND_TRAN_DTL_1_BEAN();
			String fundPerc = (String) value;
			dtl1Bean.setFTD_FUND_PERC(new Double(fundPerc==null?"0":fundPerc));
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public void selectYNValidation(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		if (value != null) {
			String selectYN = (String) value;
			int rowIndex = getDataTable1().getRowIndex();
			PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1 = dataTableList1
					.get(rowIndex);
			pt_il_fund_tran_dtl_1.setFTD_SELECT_YN(selectYN);

		}

	}

	public void fundPercentageWhenValidate(PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1) throws ValidatorException {
			try {
				helper.whenValidateFundPercentage(pt_il_fund_tran_dtl_1);
				lastColumnListener();
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setTempBean(
						pt_il_fund_tran_dtl_1);
			} catch (Exception exception) {
				throw new ValidatorException(new FacesMessage(exception.getMessage()));

			}
	}
	// display method added by Akash Singh date:-8july2011
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			
			resetSelectedRow();
			PT_IL_FUND_TRAN_DTL_1_BEAN = (PT_IL_FUND_TRAN_DTL_1)dataTable1
						.getRowData();
			// Reset selection for other beans
			PT_IL_FUND_TRAN_DTL_1_BEAN.setRowSelected(true);
			
			enableDisabledComponent(PT_IL_FUND_TRAN_DTL_1_BEAN);
			resetAllComponent();
			
			
			
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PT_IL_FUND_TRAN_DTL_1> iterator = dataTableList1.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	
	public void enableDisabledComponent( PT_IL_FUND_TRAN_DTL_1 PT_IL_FUND_TRAN_DTL_1_BEAN) {
		
		
		if("P".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SWITCH_BASED_ON()))
		{
			getCOMP_FTD_FUND_PERC().setDisabled(false);
			getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
			/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_OF_UNITS_1(null);
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_LC_AMT_1(null);*/
		}
		else if("F".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SWITCH_BASED_ON()))
		{
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(false);
			getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
			getCOMP_FTD_FUND_PERC().setDisabled(true);
			
			/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_OF_UNITS_1(null);
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC(null);*/
		}else
		{
			getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(false);
			getCOMP_FTD_FUND_PERC().setDisabled(true);
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
				/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_LC_AMT_1(null);
				PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC(null);*/
		}
		
		if("Y".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN()) && "N".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_TRAN_STATUS_ACTION().getPT_IL_TRAN_STATUS_BEAN().getTS_STATUS_CODE(),"N")))
		{
			getCOMP_FTD_SWITCH_BASED_ON().setDisabled(false);
			
		}else
		{
			getCOMP_FTD_SWITCH_BASED_ON().setDisabled(true);
			getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
			getCOMP_FTD_FUND_PERC().setDisabled(true);
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
			
		}
	}
	
	public void resetAllComponent() {
		COMP_UI_M_SUM_ALLOC_LC_VALUE_T.resetValue();
		COMP_UI_M_SUM_ALLOC_LC_VALUE_P.resetValue();
		COMP_FTD_FUND_PERC.resetValue();		
		COMP_FTD_NO_ALLOC_LC_AMT_1.resetValue();
		COMP_FTD_SELECT_YN.resetValue();
		COMP_FTD_UNIT_TYPE_1.resetValue();
		COMP_FTD_BEF_SWT_PERC.resetValue();
		COMP_FTD_FUND_CODE_1.resetValue();
		COMP_FTD_NO_OF_UNITS_1.resetValue();
		COMP_FTD_NO_SEL_UNITS_1.resetValue();
		COMP_FTD_UNIT_LC_AMT_1.resetValue();
		COMP_UI_M_FUND_DESC_1.resetValue();
		COMP_FTD_SWITCH_BASED_ON.resetValue();
	}
	
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (dataTableList1 == null){
				dataTableList1 = new ArrayList<PT_IL_FUND_TRAN_DTL_1>();
			}
			if (isINSERT_ALLOWED()) {
				PT_IL_FUND_TRAN_DTL_1_BEAN = new PT_IL_FUND_TRAN_DTL_1();
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
				if (PT_IL_FUND_TRAN_DTL_1_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_FUND_TRAN_DTL_1_BEAN,
							CommonUtils.getConnection());
					dataTableList1.remove(PT_IL_FUND_TRAN_DTL_1_BEAN);
				}

				if (dataTableList1.size() > 0) {
					setPT_IL_FUND_TRAN_DTL_1_BEAN(dataTableList1.get(0));
					PT_IL_FUND_TRAN_DTL_1_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
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
	
	public String postRecord() {
		try {
			if (PT_IL_FUND_TRAN_DTL_1_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_DTL_1_BEAN,CommonUtils.getConnection());

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
				dataTableList1.add(PT_IL_FUND_TRAN_DTL_1_BEAN);
			} else if (PT_IL_FUND_TRAN_DTL_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PT_IL_FUND_TRAN_DTL_1_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}
			
			PT_IL_FUND_TRAN_DTL_1_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

		return null;

	}
	
	

	public PT_IL_FUND_TRAN_DTL_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PT_IL_FUND_TRAN_DTL_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public PT_IL_FUND_TRAN_DTL_1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_FUND_TRAN_DTL_1_HELPER helper) {
		this.helper = helper;
	}
	
	public void validatorFTD_SELECT_YN(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_SELECT_YN((String) value);
			helper.when_validate_item_FTD_SELECT_YN(compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
					                                .getPT_IL_FUND_TRAN_HDR_BEAN(), this);
			COMP_FTD_FUND_PERC.resetValue();
			if("Y".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN()))
			{
				getCOMP_FTD_SWITCH_BASED_ON().setDisabled(false);
				
			}else
			{
				getCOMP_FTD_SWITCH_BASED_ON().setDisabled(true);
				getCOMP_FTD_FUND_PERC().setDisabled(true);
				getCOMP_FTD_NO_OF_UNITS_1().setDisabled(true);
				getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
			}
			getCOMP_FTD_SWITCH_BASED_ON().resetValue();
			getCOMP_FTD_FUND_PERC().resetValue();
			getCOMP_FTD_NO_OF_UNITS_1().resetValue();
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().resetValue();
			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void listener_WHEN_LIST_CHANGED_FTD_SELECT_YN(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputData = input.getSubmittedValue().toString();
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_SELECT_YN((String) inputData);
			helper.whenListChangedSelectYN(compositeAction);
			COMP_FTD_FUND_PERC.resetValue();
			COMP_FTD_NO_SEL_UNITS_1.resetValue();
			COMP_FTD_NO_ALLOC_LC_AMT_1.resetValue();
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
	}
	
	public void validatorFTD_FUND_PERC(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC((Double) value);
			helper.whenValidateFundPercentage(PT_IL_FUND_TRAN_DTL_1_BEAN);
			COMP_FTD_NO_SEL_UNITS_1.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE.resetValue();
			COMP_FTD_NO_ALLOC_LC_AMT_1.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_P.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_T.resetValue();
			
			/*Newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
			if(compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1().equalsIgnoreCase("LIQUID FUND")){
				
			
			long l = compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();
			int pol_Sys_Id = (int)l;
			
			
			Double d = new Double(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_PERC());
			int FTD_FUND_PERC = d.intValue();
			
			new P9ILPK_FUND_ALLOC().P_LIQUID_FUND_VALIDATION(pol_Sys_Id,
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1(),
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_SWITCH_BASED_ON(),
					FTD_FUND_PERC);
			}
			/*End newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public UIData getDataTable1() {
		return dataTable1;
	}

	public void setDataTable1(UIData dataTable1) {
		this.dataTable1 = dataTable1;
	}

	public HtmlInputText getCOMP_UI_M_PFTD_FUND_DESC() {
		return COMP_UI_M_PFTD_FUND_DESC;
	}

	public void setCOMP_UI_M_PFTD_FUND_DESC(HtmlInputText comp_ui_m_pftd_fund_desc) {
		COMP_UI_M_PFTD_FUND_DESC = comp_ui_m_pftd_fund_desc;
	}

	public HtmlOutputLabel getCOMP_FTD_BEF_SWT_PERC_LABEL() {
		return COMP_FTD_BEF_SWT_PERC_LABEL;
	}

	public void setCOMP_FTD_BEF_SWT_PERC_LABEL(
			HtmlOutputLabel comp_ftd_bef_swt_perc_label) {
		COMP_FTD_BEF_SWT_PERC_LABEL = comp_ftd_bef_swt_perc_label;
	}

	public HtmlInputText getCOMP_FTD_BEF_SWT_PERC() {
		return COMP_FTD_BEF_SWT_PERC;
	}

	public void setCOMP_FTD_BEF_SWT_PERC(HtmlInputText comp_ftd_bef_swt_perc) {
		COMP_FTD_BEF_SWT_PERC = comp_ftd_bef_swt_perc;
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_CODE_1_LABEL() {
		return COMP_FTD_FUND_CODE_1_LABEL;
	}

	public void setCOMP_FTD_FUND_CODE_1_LABEL(
			HtmlOutputLabel comp_ftd_fund_code_1_label) {
		COMP_FTD_FUND_CODE_1_LABEL = comp_ftd_fund_code_1_label;
	}

	public HtmlInputText getCOMP_FTD_FUND_CODE_1() {
		return COMP_FTD_FUND_CODE_1;
	}

	public void setCOMP_FTD_FUND_CODE_1(HtmlInputText comp_ftd_fund_code_1) {
		COMP_FTD_FUND_CODE_1 = comp_ftd_fund_code_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_FUND_DESC_1_LABEL() {
		return COMP_UI_M_FUND_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_FUND_DESC_1_LABEL(
			HtmlOutputLabel comp_ui_m_fund_desc_1_label) {
		COMP_UI_M_FUND_DESC_1_LABEL = comp_ui_m_fund_desc_1_label;
	}

	public HtmlInputText getCOMP_UI_M_FUND_DESC_1() {
		return COMP_UI_M_FUND_DESC_1;
	}

	public void setCOMP_UI_M_FUND_DESC_1(HtmlInputText comp_ui_m_fund_desc_1) {
		COMP_UI_M_FUND_DESC_1 = comp_ui_m_fund_desc_1;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_TYPE_1_LABEL() {
		return COMP_FTD_UNIT_TYPE_1_LABEL;
	}

	public void setCOMP_FTD_UNIT_TYPE_1_LABEL(
			HtmlOutputLabel comp_ftd_unit_type_1_label) {
		COMP_FTD_UNIT_TYPE_1_LABEL = comp_ftd_unit_type_1_label;
	}

	public HtmlSelectOneMenu getCOMP_FTD_UNIT_TYPE_1() {
		return COMP_FTD_UNIT_TYPE_1;
	}

	public void setCOMP_FTD_UNIT_TYPE_1(HtmlSelectOneMenu comp_ftd_unit_type_1) {
		COMP_FTD_UNIT_TYPE_1 = comp_ftd_unit_type_1;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_OF_UNITS_1_LABEL() {
		return COMP_FTD_NO_OF_UNITS_1_LABEL;
	}

	public void setCOMP_FTD_NO_OF_UNITS_1_LABEL(
			HtmlOutputLabel comp_ftd_no_of_units_1_label) {
		COMP_FTD_NO_OF_UNITS_1_LABEL = comp_ftd_no_of_units_1_label;
	}

	public HtmlInputText getCOMP_FTD_NO_OF_UNITS_1() {
		return COMP_FTD_NO_OF_UNITS_1;
	}

	public void setCOMP_FTD_NO_OF_UNITS_1(HtmlInputText comp_ftd_no_of_units_1) {
		COMP_FTD_NO_OF_UNITS_1 = comp_ftd_no_of_units_1;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_SEL_PRICE_1_LABEL() {
		return COMP_FTD_UNIT_SEL_PRICE_1_LABEL;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE_1_LABEL(
			HtmlOutputLabel comp_ftd_unit_sel_price_1_label) {
		COMP_FTD_UNIT_SEL_PRICE_1_LABEL = comp_ftd_unit_sel_price_1_label;
	}

	public HtmlInputText getCOMP_FTD_UNIT_SEL_PRICE_1() {
		return COMP_FTD_UNIT_SEL_PRICE_1;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE_1(HtmlInputText comp_ftd_unit_sel_price_1) {
		COMP_FTD_UNIT_SEL_PRICE_1 = comp_ftd_unit_sel_price_1;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_LC_AMT_1_LABEL() {
		return COMP_FTD_UNIT_LC_AMT_1_LABEL;
	}

	public void setCOMP_FTD_UNIT_LC_AMT_1_LABEL(
			HtmlOutputLabel comp_ftd_unit_lc_amt_1_label) {
		COMP_FTD_UNIT_LC_AMT_1_LABEL = comp_ftd_unit_lc_amt_1_label;
	}

	public HtmlInputText getCOMP_FTD_UNIT_LC_AMT_1() {
		return COMP_FTD_UNIT_LC_AMT_1;
	}

	public void setCOMP_FTD_UNIT_LC_AMT_1(HtmlInputText comp_ftd_unit_lc_amt_1) {
		COMP_FTD_UNIT_LC_AMT_1 = comp_ftd_unit_lc_amt_1;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_ALLOC_LC_AMT_1_LABEL() {
		return COMP_FTD_NO_ALLOC_LC_AMT_1_LABEL;
	}

	public void setCOMP_FTD_NO_ALLOC_LC_AMT_1_LABEL(
			HtmlOutputLabel comp_ftd_no_alloc_lc_amt_1_label) {
		COMP_FTD_NO_ALLOC_LC_AMT_1_LABEL = comp_ftd_no_alloc_lc_amt_1_label;
	}

	public HtmlInputText getCOMP_FTD_NO_ALLOC_LC_AMT_1() {
		return COMP_FTD_NO_ALLOC_LC_AMT_1;
	}

	public void setCOMP_FTD_NO_ALLOC_LC_AMT_1(
			HtmlInputText comp_ftd_no_alloc_lc_amt_1) {
		COMP_FTD_NO_ALLOC_LC_AMT_1 = comp_ftd_no_alloc_lc_amt_1;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_SEL_UNITS_1_LABEL() {
		return COMP_FTD_NO_SEL_UNITS_1_LABEL;
	}

	public void setCOMP_FTD_NO_SEL_UNITS_1_LABEL(
			HtmlOutputLabel comp_ftd_no_sel_units_1_label) {
		COMP_FTD_NO_SEL_UNITS_1_LABEL = comp_ftd_no_sel_units_1_label;
	}

	public HtmlInputText getCOMP_FTD_NO_SEL_UNITS_1() {
		return COMP_FTD_NO_SEL_UNITS_1;
	}

	public void setCOMP_FTD_NO_SEL_UNITS_1(HtmlInputText comp_ftd_no_sel_units_1) {
		COMP_FTD_NO_SEL_UNITS_1 = comp_ftd_no_sel_units_1;
	}

	public HtmlOutputLabel getCOMP_FTD_SWITCH_BASED_ON_LABEL() {
		return COMP_FTD_SWITCH_BASED_ON_LABEL;
	}

	public void setCOMP_FTD_SWITCH_BASED_ON_LABEL(
			HtmlOutputLabel cOMP_FTD_SWITCH_BASED_ON_LABEL) {
		COMP_FTD_SWITCH_BASED_ON_LABEL = cOMP_FTD_SWITCH_BASED_ON_LABEL;
	}

	
	

	public HtmlSelectOneMenu getCOMP_FTD_SWITCH_BASED_ON() {
		return COMP_FTD_SWITCH_BASED_ON;
	}

	public void setCOMP_FTD_SWITCH_BASED_ON(
			HtmlSelectOneMenu cOMP_FTD_SWITCH_BASED_ON) {
		COMP_FTD_SWITCH_BASED_ON = cOMP_FTD_SWITCH_BASED_ON;
	}

	public List<SelectItem> getFtd_Switch_Based_Onlist() {
		return ftd_Switch_Based_Onlist;
	}

	public void setFtd_Switch_Based_Onlist(List<SelectItem> ftd_Switch_Based_Onlist) {
		this.ftd_Switch_Based_Onlist = ftd_Switch_Based_Onlist;
	}

	public void instantiateAllComponent()
	{
		COMP_FTD_SWITCH_BASED_ON = new HtmlSelectOneMenu();
	}


	public void listener_WHEN_LIST_CHANGED_FTD_SWITCH_BASED_ON(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputData = input.getSubmittedValue().toString();
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_SWITCH_BASED_ON((String) inputData);
			if("Y".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN()))
			{
			if("P".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SWITCH_BASED_ON()))
			{
				getCOMP_FTD_FUND_PERC().setDisabled(false);
				/*getCOMP_FTD_NO_OF_UNITS_1().setDisabled(true);*/
				getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
				getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
				/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_OF_UNITS_1(null);
				PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_LC_AMT_1(null);*/
			}
			else if("F".equalsIgnoreCase(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SWITCH_BASED_ON()))
			{
				getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(false);
				/*getCOMP_FTD_NO_OF_UNITS_1().setDisabled(true);*/
				getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
				getCOMP_FTD_FUND_PERC().setDisabled(true);
				
				/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_OF_UNITS_1(null);
				PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC(null);*/
			}else
			{
				/*getCOMP_FTD_NO_OF_UNITS_1().setDisabled(false);*/
				getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(false);
				getCOMP_FTD_FUND_PERC().setDisabled(true);
				getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
				/*PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_LC_AMT_1(null);
				PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC(null);*/
			}
			}else
			{
				getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
				/*getCOMP_FTD_NO_OF_UNITS_1().setDisabled(true);*/
				getCOMP_FTD_NO_SEL_UNITS_1().setDisabled(true);
				getCOMP_FTD_FUND_PERC().setDisabled(true);
			}
			/*getCOMP_FTD_NO_OF_UNITS_1().resetValue();*/
			getCOMP_FTD_NO_SEL_UNITS_1().resetValue();
			getCOMP_FTD_FUND_PERC().resetValue();
			getCOMP_FTD_NO_ALLOC_LC_AMT_1().resetValue();
			
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
	}
	
	

	public void validatorFTD_NO_ALLOC_LC_AMT_1(FacesContext context, UIComponent component,
			Object value)  throws ValidatorException {
		try {
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_ALLOC_LC_AMT_1((Double) value);
			helper.whenValidateFTD_NO_ALLOC_LC_AMT_1(PT_IL_FUND_TRAN_DTL_1_BEAN);
			COMP_FTD_NO_SEL_UNITS_1.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE.resetValue();
			COMP_FTD_FUND_PERC.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_P.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_T.resetValue();
			COMP_FTD_NO_ALLOC_LC_AMT_1.resetValue();
			/*Newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
			if(compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1().equalsIgnoreCase("LIQUID FUND")){
			long l = compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();
			int pol_Sys_Id = (int) l;
			
			
			
			Double d = new Double(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_NO_ALLOC_LC_AMT_1());
			int FTD_NO_ALLOC_LC_AMT_1 = d.intValue();
			
			new P9ILPK_FUND_ALLOC().P_LIQUID_FUND_VALIDATION(pol_Sys_Id,
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1(),
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_SWITCH_BASED_ON(),
					FTD_NO_ALLOC_LC_AMT_1);
			}
			/*End newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorFTD_NO_SEL_UNITS_1(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_SEL_UNITS_1((Double) value);
			helper.whenValidateFTD_NO_SEL_UNITS_1(PT_IL_FUND_TRAN_DTL_1_BEAN);
			COMP_FTD_FUND_PERC.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE.resetValue();
			COMP_FTD_NO_ALLOC_LC_AMT_1.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_P.resetValue();
			COMP_UI_M_SUM_ALLOC_LC_VALUE_T.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*Newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
	public void doValidateNoOfUnits(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_NO_OF_UNITS_1((Double) value);
			if(compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1().equalsIgnoreCase("LIQUID FUND")){
			long l = compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();
			int pol_Sys_Id = (int) l;
			
			
			
			Double d = new Double(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_NO_OF_UNITS_1());
			int FTD_NO_OF_UNITS_1 = d.intValue();
			
			
			new P9ILPK_FUND_ALLOC().P_LIQUID_FUND_VALIDATION(pol_Sys_Id,
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_FUND_CODE_1(),
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN().getFTD_SWITCH_BASED_ON(),
					FTD_NO_OF_UNITS_1);
			}
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
}

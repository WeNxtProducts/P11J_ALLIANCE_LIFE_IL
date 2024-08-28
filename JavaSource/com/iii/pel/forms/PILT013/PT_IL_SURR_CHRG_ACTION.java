package com.iii.pel.forms.PILT013;

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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT021.PT_IL_WITHDRAWAL_CHARGE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_SURR_CHRG_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SRC_CHRG_CODE_LABEL;

	private HtmlInputText COMP_SRC_CHRG_CODE;

	private HtmlOutputLabel COMP_SRC_RATE_LABEL;

	private HtmlInputText COMP_SRC_RATE;

	private HtmlOutputLabel COMP_SRC_RATE_PER_LABEL;

	private HtmlInputText COMP_SRC_RATE_PER;

	private HtmlOutputLabel COMP_SRC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_SRC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_SRC_CHG_FC_VALUE_LABEL;

	private HtmlInputText COMP_SRC_CHG_FC_VALUE;

	private HtmlOutputLabel COMP_SRC_CHG_LC_VALUE_LABEL;

	private HtmlInputText COMP_SRC_CHG_LC_VALUE;

	private HtmlOutputLabel COMP_SRC_SMV_FC_VALUE_LABEL;

	private HtmlInputText COMP_SRC_SMV_FC_VALUE;

	private HtmlOutputLabel COMP_SRC_SMV_LC_VALUE_LABEL;

	private HtmlInputText COMP_SRC_SMV_LC_VALUE;

	private HtmlOutputLabel COMP_SRC_CHG_SUM_FC_LABEL;

	private HtmlInputText COMP_SRC_CHG_SUM_FC;

	private HtmlOutputLabel COMP_SRC_SUM_CHG_LABEL;

	private HtmlInputText COMP_SRC_SUM_CHG;
	
	private HtmlOutputLabel COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE_LABEL;
	
	private HtmlInputText COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE;
	
	private HtmlOutputLabel COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE_LABEL;
	
	private HtmlInputText COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE;

	private PT_IL_SURR_CHRG PT_IL_SURR_CHRG_BEAN;

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_SURR_CHRG_HELPER helper;

	private List<PT_IL_SURR_CHRG> dataList_PT_IL_SURR_CHRG = new ArrayList<PT_IL_SURR_CHRG>();

	private UIData dataTable;

	public PT_IL_SURR_CHRG_ACTION() {

		PT_IL_SURR_CHRG_BEAN = new PT_IL_SURR_CHRG();
		helper = new PT_IL_SURR_CHRG_HELPER();
		
		/*Added by Janani on 16.02.2018 for showing only charges in setup as per Thiags and Sivaram sugges.*/


		PT_IL_SURR_CHRG_DELEGATE_BEAN = new PT_IL_SURR_CHRG_DELEGATE();

		/*End*/
		
		/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
		
		initializeAllComponent();
		
		/*End*/
	}

	public HtmlOutputLabel getCOMP_SRC_CHRG_CODE_LABEL() {
		return COMP_SRC_CHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_CHRG_CODE() {
		return COMP_SRC_CHRG_CODE;
	}

	public void setCOMP_SRC_CHRG_CODE_LABEL(
			HtmlOutputLabel COMP_SRC_CHRG_CODE_LABEL) {
		this.COMP_SRC_CHRG_CODE_LABEL = COMP_SRC_CHRG_CODE_LABEL;
	}

	public void setCOMP_SRC_CHRG_CODE(HtmlInputText COMP_SRC_CHRG_CODE) {
		this.COMP_SRC_CHRG_CODE = COMP_SRC_CHRG_CODE;
	}

	public HtmlOutputLabel getCOMP_SRC_RATE_LABEL() {
		return COMP_SRC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_RATE() {
		return COMP_SRC_RATE;
	}

	public void setCOMP_SRC_RATE_LABEL(HtmlOutputLabel COMP_SRC_RATE_LABEL) {
		this.COMP_SRC_RATE_LABEL = COMP_SRC_RATE_LABEL;
	}

	public void setCOMP_SRC_RATE(HtmlInputText COMP_SRC_RATE) {
		this.COMP_SRC_RATE = COMP_SRC_RATE;
	}

	public HtmlOutputLabel getCOMP_SRC_RATE_PER_LABEL() {
		return COMP_SRC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_SRC_RATE_PER() {
		return COMP_SRC_RATE_PER;
	}

	public void setCOMP_SRC_RATE_PER_LABEL(
			HtmlOutputLabel COMP_SRC_RATE_PER_LABEL) {
		this.COMP_SRC_RATE_PER_LABEL = COMP_SRC_RATE_PER_LABEL;
	}

	public void setCOMP_SRC_RATE_PER(HtmlInputText COMP_SRC_RATE_PER) {
		this.COMP_SRC_RATE_PER = COMP_SRC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_SRC_CUST_SHARE_PERC_LABEL() {
		return COMP_SRC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_SRC_CUST_SHARE_PERC() {
		return COMP_SRC_CUST_SHARE_PERC;
	}

	public void setCOMP_SRC_CUST_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_SRC_CUST_SHARE_PERC_LABEL) {
		this.COMP_SRC_CUST_SHARE_PERC_LABEL = COMP_SRC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_SRC_CUST_SHARE_PERC(
			HtmlInputText COMP_SRC_CUST_SHARE_PERC) {
		this.COMP_SRC_CUST_SHARE_PERC = COMP_SRC_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_SRC_CHG_FC_VALUE_LABEL() {
		return COMP_SRC_CHG_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_CHG_FC_VALUE() {
		return COMP_SRC_CHG_FC_VALUE;
	}

	public void setCOMP_SRC_CHG_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_SRC_CHG_FC_VALUE_LABEL) {
		this.COMP_SRC_CHG_FC_VALUE_LABEL = COMP_SRC_CHG_FC_VALUE_LABEL;
	}

	public void setCOMP_SRC_CHG_FC_VALUE(HtmlInputText COMP_SRC_CHG_FC_VALUE) {
		this.COMP_SRC_CHG_FC_VALUE = COMP_SRC_CHG_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_SRC_CHG_LC_VALUE_LABEL() {
		return COMP_SRC_CHG_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_CHG_LC_VALUE() {
		return COMP_SRC_CHG_LC_VALUE;
	}

	public void setCOMP_SRC_CHG_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_SRC_CHG_LC_VALUE_LABEL) {
		this.COMP_SRC_CHG_LC_VALUE_LABEL = COMP_SRC_CHG_LC_VALUE_LABEL;
	}

	public void setCOMP_SRC_CHG_LC_VALUE(HtmlInputText COMP_SRC_CHG_LC_VALUE) {
		this.COMP_SRC_CHG_LC_VALUE = COMP_SRC_CHG_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_SRC_SMV_FC_VALUE_LABEL() {
		return COMP_SRC_SMV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_SMV_FC_VALUE() {
		return COMP_SRC_SMV_FC_VALUE;
	}

	public void setCOMP_SRC_SMV_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_SRC_SMV_FC_VALUE_LABEL) {
		this.COMP_SRC_SMV_FC_VALUE_LABEL = COMP_SRC_SMV_FC_VALUE_LABEL;
	}

	public void setCOMP_SRC_SMV_FC_VALUE(HtmlInputText COMP_SRC_SMV_FC_VALUE) {
		this.COMP_SRC_SMV_FC_VALUE = COMP_SRC_SMV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_SRC_SMV_LC_VALUE_LABEL() {
		return COMP_SRC_SMV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SRC_SMV_LC_VALUE() {
		return COMP_SRC_SMV_LC_VALUE;
	}

	public void setCOMP_SRC_SMV_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_SRC_SMV_LC_VALUE_LABEL) {
		this.COMP_SRC_SMV_LC_VALUE_LABEL = COMP_SRC_SMV_LC_VALUE_LABEL;
	}

	public void setCOMP_SRC_SMV_LC_VALUE(HtmlInputText COMP_SRC_SMV_LC_VALUE) {
		this.COMP_SRC_SMV_LC_VALUE = COMP_SRC_SMV_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_SRC_CHG_SUM_FC_LABEL() {
		return COMP_SRC_CHG_SUM_FC_LABEL;
	}

	public HtmlInputText getCOMP_SRC_CHG_SUM_FC() {
		return COMP_SRC_CHG_SUM_FC;
	}

	public void setCOMP_SRC_CHG_SUM_FC_LABEL(
			HtmlOutputLabel COMP_SRC_CHG_SUM_FC_LABEL) {
		this.COMP_SRC_CHG_SUM_FC_LABEL = COMP_SRC_CHG_SUM_FC_LABEL;
	}

	public void setCOMP_SRC_CHG_SUM_FC(HtmlInputText COMP_SRC_CHG_SUM_FC) {
		this.COMP_SRC_CHG_SUM_FC = COMP_SRC_CHG_SUM_FC;
	}

	public HtmlOutputLabel getCOMP_SRC_SUM_CHG_LABEL() {
		return COMP_SRC_SUM_CHG_LABEL;
	}

	public HtmlInputText getCOMP_SRC_SUM_CHG() {
		return COMP_SRC_SUM_CHG;
	}

	public void setCOMP_SRC_SUM_CHG_LABEL(HtmlOutputLabel COMP_SRC_SUM_CHG_LABEL) {
		this.COMP_SRC_SUM_CHG_LABEL = COMP_SRC_SUM_CHG_LABEL;
	}

	public void setCOMP_SRC_SUM_CHG(HtmlInputText COMP_SRC_SUM_CHG) {
		this.COMP_SRC_SUM_CHG = COMP_SRC_SUM_CHG;
	}

	public PT_IL_SURR_CHRG getPT_IL_SURR_CHRG_BEAN() {
		return PT_IL_SURR_CHRG_BEAN;
	}

	public void setPT_IL_SURR_CHRG_BEAN(PT_IL_SURR_CHRG PT_IL_SURR_CHRG_BEAN) {
		this.PT_IL_SURR_CHRG_BEAN = PT_IL_SURR_CHRG_BEAN;
	}

	public List<PT_IL_SURR_CHRG> getDataList_PT_IL_SURR_CHRG() {
		return dataList_PT_IL_SURR_CHRG;
	}

	public void setDataListPT_IL_SURR_CHRG(
			List<PT_IL_SURR_CHRG> dataList_PT_IL_SURR_CHRG) {
		this.dataList_PT_IL_SURR_CHRG = dataList_PT_IL_SURR_CHRG;
	}

	public void addRow(ActionEvent event) {
		try {
			
			if (isINSERT_ALLOWED()) {
				
				PT_IL_SURR_CHRG_BEAN = new PT_IL_SURR_CHRG();
				
				/*Added by Janani on 13.02.2018 for enabling Create button as per Sivaram's sugges.*/
				PT_IL_SURR_CHRG_BEAN.setSRC_CUST_SHARE_PERC(100.00);
				if(PT_IL_SURR_CHRG_BEAN.getROWID() == null)
				{
					getTotalCharge();
				}
				
				/*End*/
				resetAllComponent();
				resetSelectedRow();
			} else {
				throw new Exception(Messages.getString(
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

				new CRUDHandler().executeDelete(PT_IL_SURR_CHRG_BEAN,
						CommonUtils.getConnection());
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
				dataList_PT_IL_SURR_CHRG.remove(PT_IL_SURR_CHRG_BEAN);
				if (dataList_PT_IL_SURR_CHRG.size() > 0) {

					PT_IL_SURR_CHRG_BEAN = dataList_PT_IL_SURR_CHRG.get(0);
				} else if (dataList_PT_IL_SURR_CHRG.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_SURR_CHRG_BEAN.setRowSelected(true);
				
				/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
				
				getTotalCharge();
				updateTot_chrg_amt();
				
				/*End*/
				
				/*Added  by Janani on 13.02.2018 as per Sivaram's sugges.*/
				
				CommonUtils.getConnection().commit();
				
				/*End*/
				
				
				
			} else {

				throw new Exception(Messages.getString(
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
	
		/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/
		String exst_chk_query = null;
		Object[] params = null;
		CRUDHandler handler;
		ResultSet resultSet = null;
		
		/*End*/
		
		try {
			if (PT_IL_SURR_CHRG_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					helper.preInsert(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN(),
							PT_IL_SURR_CHRG_BEAN);
					
					/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	
					

						exst_chk_query = "SELECT 'X' FROM PT_IL_SURR_CHRG WHERE SRC_CHRG_CODE=? AND SRC_SMV_SYS_ID = ?";
						params = new Object[]{PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE(),compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().
								getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID()};
					

					handler = new CRUDHandler();
					Connection connection = CommonUtils.getConnection();

					resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
					if(resultSet.next()){

						throw new Exception("Charge already exists.");
					}
					else
					{
						/*End*/
					
					/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
					
					//getTotalCharge();
					
					/*End*/
					
					new CRUDHandler().executeInsert(PT_IL_SURR_CHRG_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
					dataList_PT_IL_SURR_CHRG.add(PT_IL_SURR_CHRG_BEAN);
				}
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_SURR_CHRG_BEAN.getROWID() != null) {

				if(isUPDATE_ALLOWED()){
					
					/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	
					
						exst_chk_query = "SELECT 'X' FROM PT_IL_SURR_CHRG WHERE SRC_CHRG_CODE=? AND SRC_SMV_SYS_ID = ? AND ROWID<> ?";
						params = new Object[]{PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE(),compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().
								getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID(),PT_IL_SURR_CHRG_BEAN.getROWID()};

					

					handler = new CRUDHandler();
					Connection connection = CommonUtils.getConnection();

					resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
					if(resultSet.next()){

						throw new Exception("Charge already exists.");
					}
					else
					{
						/*End*/
					
					
					/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
					
					getTotalCharge();
					updateTot_chrg_amt();
					
					/*End*/
					
					
					new CRUDHandler().executeUpdate(PT_IL_SURR_CHRG_BEAN,
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
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}

			
			/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			CommonUtils.getConnection().commit();
			getTotalCharge();
			updateTot_chrg_amt();
			
			/*End*/
			
			PT_IL_SURR_CHRG_BEAN.setRowSelected(true);
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
			PT_IL_SURR_CHRG_BEAN = (PT_IL_SURR_CHRG) dataTable.getRowData();
			helper.POST_QUERY(compositeAction);
			PT_IL_SURR_CHRG_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_SURR_CHRG> PT_IL_SURR_CHRG_ITR = dataList_PT_IL_SURR_CHRG
				.iterator();
		while (PT_IL_SURR_CHRG_ITR.hasNext()) {
			PT_IL_SURR_CHRG_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SRC_CHRG_CODE.resetValue();
		COMP_SRC_RATE.resetValue();
		COMP_SRC_RATE_PER.resetValue();
		COMP_SRC_CUST_SHARE_PERC.resetValue();
		COMP_SRC_CHG_FC_VALUE.resetValue();
		COMP_SRC_CHG_LC_VALUE.resetValue();
		COMP_SRC_SMV_FC_VALUE.resetValue();
		COMP_SRC_SMV_LC_VALUE.resetValue();
		COMP_SRC_CHG_SUM_FC.resetValue();
		COMP_SRC_SUM_CHG.resetValue();


		/*Added by Janani on 13.02.2018 for ZB as per Sivaram's suggs.*/	
		COMP_UI_M_SRC_CHRG_CODE_DESC.resetValue();
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
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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

	public void SRC_RATE_Validator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_CHRG_BEAN().setSRC_RATE((Double) value);
			helper.SRC_RATE_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void SRC_RATE_PER_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_CHRG_BEAN().setSRC_RATE_PER((Double) value);
			helper.SRC_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction, value);
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

	public void SRC_CUST_SHARE_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_CHRG_BEAN().setSRC_CUST_SHARE_PERC((Double) value);
			helper.SRC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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
	
	

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				
				//helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);  commented  by Janani on 17.07.2017 for ZBILQC-1724475
				helper.executeQuery(compositeAction);
				
				/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
				
				//getTotalCharge();
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				
				/*End*/
				
				if(compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN().getROWID()!=null)
				helper.POST_QUERY(compositeAction);
				setBlockFlag(false);
				
				/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
				if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_APPRV_FLAG() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
				{
					disableAllComponent(true);
				}
				
				/*End*/
				
			}
			
			/*Added by Janani on 13.02.2018 for enabling Create button as per Sivaram's sugges.*/
			if(PT_IL_SURR_CHRG_BEAN.getROWID() == null)
			{
				COMP_SRC_CHRG_CODE.setDisabled(false);
			}else
			{
				COMP_SRC_CHRG_CODE.setDisabled(true);
			}
			/*End*/
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_TOTAL_SRC_SMV_LC_VALUE_LABEL() {
		return COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_TOTAL_SRC_SMV_LC_VALUE_LABEL(
			HtmlOutputLabel comp_ui_m_total_src_smv_lc_value_label) {
		COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE_LABEL = comp_ui_m_total_src_smv_lc_value_label;
	}

	public HtmlInputText getCOMP_UI_M_TOTAL_SRC_SMV_LC_VALUE() {
		return COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE;
	}

	public void setCOMP_UI_M_TOTAL_SRC_SMV_LC_VALUE(
			HtmlInputText comp_ui_m_total_src_smv_lc_value) {
		COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE = comp_ui_m_total_src_smv_lc_value;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOTAL_SRC_SMV_FC_VALUE_LABEL() {
		return COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_TOTAL_SRC_SMV_FC_VALUE_LABEL(
			HtmlOutputLabel comp_ui_m_total_src_smv_fc_value_label) {
		COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE_LABEL = comp_ui_m_total_src_smv_fc_value_label;
	}

	public HtmlInputText getCOMP_UI_M_TOTAL_SRC_SMV_FC_VALUE() {
		return COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE;
	}

	public void setCOMP_UI_M_TOTAL_SRC_SMV_FC_VALUE(
			HtmlInputText comp_ui_m_total_src_smv_fc_value) {
		COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE = comp_ui_m_total_src_smv_fc_value;
	}

	/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
	
	public Double getTotalCharge(){
		System.out.println("****************>ENTERING INTO TOTAL_RiRATE method<***********");
		CRUDHandler handler;
		String query=null;
		Double total_charge=0.0;
		ResultSet resultSet = null;
		try{
			handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			query="SELECT NVL(SUM(SRC_CHG_FC_VALUE),0) FROM PT_IL_SURR_CHRG WHERE SRC_SMV_SYS_ID = ?";
			resultSet = handler.executeSelectStatement(query,connection,new Object[] {compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().
					getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID()});
			if(resultSet.next()){
				total_charge += resultSet.getDouble(1);
			}
			System.out.println("***************VALUE OF total_riRate**********"+total_charge);			
			PT_IL_SURR_CHRG_BEAN.setSRC_CHG_SUM_FC(total_charge);
			PT_IL_SURR_CHRG_BEAN.setSRC_SUM_CHG(total_charge);
			
			System.out.println("getSRC_SUM_CHG in getTotalCharge           "+PT_IL_SURR_CHRG_BEAN.getSRC_SUM_CHG());
			System.out.println("getSRC_CHG_SUM_FC  in getTotalCharge           "+PT_IL_SURR_CHRG_BEAN.getSRC_CHG_SUM_FC());
			
			}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return total_charge;
		
	}
		
		public void updateTot_chrg_amt()
		{
			System.out.println("enters into updateTot_chrg_amt");

			CRUDHandler handler;
			String query=null;
			Double total_charge=0.0;
			ResultSet resultSet = null;
			PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			
			try{
				handler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();	
				
				System.out.println("getPOL_SYS_ID                   "+pt_il_policy_bean.getPOL_SYS_ID());
				System.out.println("getSRC_SUM_CHG            "+PT_IL_SURR_CHRG_BEAN.getSRC_SUM_CHG());
				System.out.println("getSRC_CHG_SUM_FC            "+PT_IL_SURR_CHRG_BEAN.getSRC_CHG_SUM_FC());
				
				query = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_FC_CHARGE_AMT = ?,SMV_LC_CHARGE_AMT = ? WHERE SMV_POL_SYS_ID = ? ";
				new CRUDHandler().executeUpdateStatement(query, connection, new Object[]{PT_IL_SURR_CHRG_BEAN.getSRC_CHG_SUM_FC(),
						PT_IL_SURR_CHRG_BEAN.getSRC_SUM_CHG(),pt_il_policy_bean.getPOL_SYS_ID()});
				connection.commit();
				connection.close();

				System.out.println("getSMV_FC_CHARGE_AMT          "+PT_IL_SURR_CHRG_BEAN.getSRC_SUM_CHG());
				System.out.println("getSMV_LC_CHARGE_AMT           "+PT_IL_SURR_CHRG_BEAN.getSRC_CHG_SUM_FC());
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();

			}
		}
		
		
		
		private void initializeAllComponent() {
			
			COMP_SRC_CHRG_CODE = new HtmlInputText();
			COMP_SRC_RATE = new HtmlInputText();
			COMP_SRC_RATE_PER = new HtmlInputText();
			COMP_SRC_CUST_SHARE_PERC = new HtmlInputText();
			COMP_SRC_CHG_FC_VALUE = new HtmlInputText();
			COMP_SRC_CHG_LC_VALUE = new HtmlInputText();
			COMP_SRC_SMV_FC_VALUE = new HtmlInputText();
			COMP_SRC_SMV_LC_VALUE = new HtmlInputText();
			COMP_SRC_CHG_SUM_FC = new HtmlInputText();
			COMP_SRC_SUM_CHG = new HtmlInputText();
			COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE = new HtmlInputText();
			COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE = new HtmlInputText();
			COMP_UI_M_SRC_CHRG_CODE_DESC = new HtmlInputText();
		}
		
		public void disableAllComponent(boolean disabled) {
			
			COMP_SRC_CHRG_CODE.setDisabled(disabled);
			COMP_SRC_RATE.setDisabled(disabled);
			COMP_SRC_RATE_PER.setDisabled(disabled);
			COMP_SRC_CUST_SHARE_PERC.setDisabled(disabled);
			COMP_SRC_CHG_FC_VALUE.setDisabled(disabled);
			COMP_SRC_CHG_LC_VALUE.setDisabled(disabled);
			COMP_SRC_SMV_FC_VALUE.setDisabled(disabled);
			COMP_SRC_SMV_LC_VALUE.setDisabled(disabled);
			COMP_SRC_CHG_SUM_FC.setDisabled(disabled);
			COMP_SRC_SUM_CHG.setDisabled(disabled);
			COMP_UI_M_TOTAL_SRC_SMV_LC_VALUE.setDisabled(disabled);
			COMP_UI_M_TOTAL_SRC_SMV_FC_VALUE.setDisabled(disabled);
			COMP_UI_M_SRC_CHRG_CODE_DESC.setDisabled(disabled);
		}
		
		/*End*/
		
		/*Added by Janani on 13.02.2018 for ZB as per Sivaram's suggs.*/	
		
		private HtmlInputText COMP_UI_M_SRC_CHRG_CODE_DESC;
		
		/*Modified by Janani on 16.02.2018 for showing only charges in setup as per Thiags and Sivaram sugges.*/
		
		/*ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		
		public ArrayList<LovBean> getLovList() {
			return lovList;
		}

		public void setLovList(ArrayList<LovBean> lovList) {
			this.lovList = lovList;
		}*/
		
		private List lovList;

		public List getLovList() {
			return lovList;
		}

		public void setLovList(List lovList) {
			this.lovList = lovList;
		}

		/*End*/
		
		public HtmlInputText getCOMP_UI_M_SRC_CHRG_CODE_DESC() {
			return COMP_UI_M_SRC_CHRG_CODE_DESC;
		}

		public void setCOMP_UI_M_SRC_CHRG_CODE_DESC(
				HtmlInputText cOMP_UI_M_SRC_CHRG_CODE_DESC) {
			COMP_UI_M_SRC_CHRG_CODE_DESC = cOMP_UI_M_SRC_CHRG_CODE_DESC;
		}
		
		
		/*Modified by Janani on 16.02.2018 for showing only charges in setup as per Thiags and Sivaram sugges.*/

	/*	public List<LovBean> prepareLOV(Object value) {
			try {
				ListItemUtil itemUtil = new ListItemUtil();
				lovList = itemUtil.P_CALL_LOV("PILT021", "PT_IL_WITHDRAWAL_CHARGE",
						"WDC_CHRG_CODE", "IL_CHARGE", null, null, null, null,
						(String) value);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("CHRG_CODE_SUGGESTION", e.getMessage());
			}
			return lovList;
		}*/
		
		
		public List prepareLOV(Object event) {
			String catgCode = (String) event;
			try {
				
				lovList = PT_IL_SURR_CHRG_DELEGATE_BEAN.prepareCatgCodeList(
						catgCode, lovList,compositeAction);
				
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lovList;
		}
		
		
		/*End*/
		
		
		public void validateSRC_CHRG_CODE(FacesContext context,
				UIComponent component, Object value) {

			ArrayList<String> list = null;
			DBProcedures procedures = new  DBProcedures();
			String exst_chk_query = null;
			Object[] params = null;
			CRUDHandler handler;
			ResultSet resultSet = null;


			try {

				PT_IL_SURR_CHRG_BEAN.setSRC_CHRG_CODE((String) value);

				System.out.println("getSRC_CHRG_CODE                  "+PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE());

				if(PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE()!=null)
				{
					list = procedures.P_VAL_CODES("IL_CHARGE",PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE(),
							PT_IL_SURR_CHRG_BEAN.getUI_M_SRC_CHRG_DESC(),"N","N",null);
					if (list != null && !list.isEmpty()) {
						if (list.get(0)!= null) {
							PT_IL_SURR_CHRG_BEAN.setUI_M_SRC_CHRG_CODE_DESC(list.get(0));

							System.out.println("getUI_M_SRC_CHRG_CODE_DESC  in validator                    "+ PT_IL_SURR_CHRG_BEAN.getUI_M_SRC_CHRG_CODE_DESC());
						}
					}
				}


				COMP_UI_M_SRC_CHRG_CODE_DESC.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

		/*End*/		
		
		/*Added by Janani on 16.02.2018 for showing only charges in setup as per Thiags and Sivaram sugges.*/

		
		private PT_IL_SURR_CHRG_DELEGATE PT_IL_SURR_CHRG_DELEGATE_BEAN;

		public PT_IL_SURR_CHRG_DELEGATE getPT_IL_SURR_CHRG_DELEGATE_BEAN() {
			return PT_IL_SURR_CHRG_DELEGATE_BEAN;
		}

		public void setPT_IL_SURR_CHRG_DELEGATE_BEAN(
				PT_IL_SURR_CHRG_DELEGATE pT_IL_SURR_CHRG_DELEGATE_BEAN) {
			PT_IL_SURR_CHRG_DELEGATE_BEAN = pT_IL_SURR_CHRG_DELEGATE_BEAN;
		}
		
		/*End*/
}
	
	
	

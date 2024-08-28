package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_WITHDRAWAL_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_WDC_CHRG_CODE_LABEL;

	private HtmlInputText COMP_WDC_CHRG_CODE;

	private HtmlOutputLabel COMP_WDC_RATE_LABEL;

	private HtmlInputText COMP_WDC_RATE;

	private HtmlOutputLabel COMP_WDC_RATE_PER_LABEL;

	private HtmlInputText COMP_WDC_RATE_PER;

	private HtmlOutputLabel COMP_WDC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_WDC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_WDC_PREM_LC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_PREM_LC_VALUE;

	private HtmlOutputLabel COMP_WDC_PREM_FC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_PREM_FC_VALUE;

	private HtmlOutputLabel COMP_WDC_TOP_UP_LC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_TOP_UP_LC_VALUE;

	private HtmlOutputLabel COMP_WDC_TOP_UP_FC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_TOP_UP_FC_VALUE;

	private HtmlOutputLabel COMP_WDC_FC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_FC_VALUE;

	private HtmlOutputLabel COMP_WDC_LC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_LC_VALUE;

	private HtmlOutputLabel COMP_UI_M_WDC_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WDC_CHARGE_DESC;

	private PT_IL_WITHDRAWAL_CHARGE PT_IL_WITHDRAWAL_CHARGE_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PT_IL_WITHDRAWAL_CHARGE_HELPER helper;

	private List<PT_IL_WITHDRAWAL_CHARGE> dataList_PT_IL_WITHDRAWAL_CHARGE = new ArrayList<PT_IL_WITHDRAWAL_CHARGE>();

	private UIData dataTable;

	ArrayList<LovBean> lovList = new ArrayList<LovBean>();

	String DEFAULT_WHERE;
	
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	private HtmlAjaxCommandButton COMP_POST_ROW;

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}

	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton comp_del_row) {
		COMP_DEL_ROW = comp_del_row;
	}

	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}

	public void setCOMP_POST_ROW(HtmlAjaxCommandButton comp_post_row) {
		COMP_POST_ROW = comp_post_row;
	}

	public PT_IL_WITHDRAWAL_CHARGE_ACTION() {

		PT_IL_WITHDRAWAL_CHARGE_BEAN = new PT_IL_WITHDRAWAL_CHARGE();
		helper = new PT_IL_WITHDRAWAL_CHARGE_HELPER();
	}

	public HtmlOutputLabel getCOMP_WDC_CHRG_CODE_LABEL() {
		return COMP_WDC_CHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_CHRG_CODE() {
		return COMP_WDC_CHRG_CODE;
	}

	public void setCOMP_WDC_CHRG_CODE_LABEL(
			HtmlOutputLabel COMP_WDC_CHRG_CODE_LABEL) {
		this.COMP_WDC_CHRG_CODE_LABEL = COMP_WDC_CHRG_CODE_LABEL;
	}

	public void setCOMP_WDC_CHRG_CODE(HtmlInputText COMP_WDC_CHRG_CODE) {
		this.COMP_WDC_CHRG_CODE = COMP_WDC_CHRG_CODE;
	}

	public HtmlOutputLabel getCOMP_WDC_RATE_LABEL() {
		return COMP_WDC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_RATE() {
		return COMP_WDC_RATE;
	}

	public void setCOMP_WDC_RATE_LABEL(HtmlOutputLabel COMP_WDC_RATE_LABEL) {
		this.COMP_WDC_RATE_LABEL = COMP_WDC_RATE_LABEL;
	}

	public void setCOMP_WDC_RATE(HtmlInputText COMP_WDC_RATE) {
		this.COMP_WDC_RATE = COMP_WDC_RATE;
	}

	public HtmlOutputLabel getCOMP_WDC_RATE_PER_LABEL() {
		return COMP_WDC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_WDC_RATE_PER() {
		return COMP_WDC_RATE_PER;
	}

	public void setCOMP_WDC_RATE_PER_LABEL(
			HtmlOutputLabel COMP_WDC_RATE_PER_LABEL) {
		this.COMP_WDC_RATE_PER_LABEL = COMP_WDC_RATE_PER_LABEL;
	}

	public void setCOMP_WDC_RATE_PER(HtmlInputText COMP_WDC_RATE_PER) {
		this.COMP_WDC_RATE_PER = COMP_WDC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_WDC_CUST_SHARE_PERC_LABEL() {
		return COMP_WDC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_WDC_CUST_SHARE_PERC() {
		return COMP_WDC_CUST_SHARE_PERC;
	}

	public void setCOMP_WDC_CUST_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_WDC_CUST_SHARE_PERC_LABEL) {
		this.COMP_WDC_CUST_SHARE_PERC_LABEL = COMP_WDC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_WDC_CUST_SHARE_PERC(
			HtmlInputText COMP_WDC_CUST_SHARE_PERC) {
		this.COMP_WDC_CUST_SHARE_PERC = COMP_WDC_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_WDC_PREM_LC_VALUE_LABEL() {
		return COMP_WDC_PREM_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_PREM_LC_VALUE() {
		return COMP_WDC_PREM_LC_VALUE;
	}

	public void setCOMP_WDC_PREM_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_PREM_LC_VALUE_LABEL) {
		this.COMP_WDC_PREM_LC_VALUE_LABEL = COMP_WDC_PREM_LC_VALUE_LABEL;
	}

	public void setCOMP_WDC_PREM_LC_VALUE(HtmlInputText COMP_WDC_PREM_LC_VALUE) {
		this.COMP_WDC_PREM_LC_VALUE = COMP_WDC_PREM_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WDC_PREM_FC_VALUE_LABEL() {
		return COMP_WDC_PREM_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_PREM_FC_VALUE() {
		return COMP_WDC_PREM_FC_VALUE;
	}

	public void setCOMP_WDC_PREM_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_PREM_FC_VALUE_LABEL) {
		this.COMP_WDC_PREM_FC_VALUE_LABEL = COMP_WDC_PREM_FC_VALUE_LABEL;
	}

	public void setCOMP_WDC_PREM_FC_VALUE(HtmlInputText COMP_WDC_PREM_FC_VALUE) {
		this.COMP_WDC_PREM_FC_VALUE = COMP_WDC_PREM_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WDC_TOP_UP_LC_VALUE_LABEL() {
		return COMP_WDC_TOP_UP_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_TOP_UP_LC_VALUE() {
		return COMP_WDC_TOP_UP_LC_VALUE;
	}

	public void setCOMP_WDC_TOP_UP_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_TOP_UP_LC_VALUE_LABEL) {
		this.COMP_WDC_TOP_UP_LC_VALUE_LABEL = COMP_WDC_TOP_UP_LC_VALUE_LABEL;
	}

	public void setCOMP_WDC_TOP_UP_LC_VALUE(
			HtmlInputText COMP_WDC_TOP_UP_LC_VALUE) {
		this.COMP_WDC_TOP_UP_LC_VALUE = COMP_WDC_TOP_UP_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WDC_TOP_UP_FC_VALUE_LABEL() {
		return COMP_WDC_TOP_UP_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_TOP_UP_FC_VALUE() {
		return COMP_WDC_TOP_UP_FC_VALUE;
	}

	public void setCOMP_WDC_TOP_UP_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_TOP_UP_FC_VALUE_LABEL) {
		this.COMP_WDC_TOP_UP_FC_VALUE_LABEL = COMP_WDC_TOP_UP_FC_VALUE_LABEL;
	}

	public void setCOMP_WDC_TOP_UP_FC_VALUE(
			HtmlInputText COMP_WDC_TOP_UP_FC_VALUE) {
		this.COMP_WDC_TOP_UP_FC_VALUE = COMP_WDC_TOP_UP_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WDC_FC_VALUE_LABEL() {
		return COMP_WDC_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_FC_VALUE() {
		return COMP_WDC_FC_VALUE;
	}

	public void setCOMP_WDC_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_FC_VALUE_LABEL) {
		this.COMP_WDC_FC_VALUE_LABEL = COMP_WDC_FC_VALUE_LABEL;
	}

	public void setCOMP_WDC_FC_VALUE(HtmlInputText COMP_WDC_FC_VALUE) {
		this.COMP_WDC_FC_VALUE = COMP_WDC_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WDC_LC_VALUE_LABEL() {
		return COMP_WDC_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WDC_LC_VALUE() {
		return COMP_WDC_LC_VALUE;
	}

	public void setCOMP_WDC_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WDC_LC_VALUE_LABEL) {
		this.COMP_WDC_LC_VALUE_LABEL = COMP_WDC_LC_VALUE_LABEL;
	}

	public void setCOMP_WDC_LC_VALUE(HtmlInputText COMP_WDC_LC_VALUE) {
		this.COMP_WDC_LC_VALUE = COMP_WDC_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WDC_CHARGE_DESC_LABEL() {
		return COMP_UI_M_WDC_CHARGE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WDC_CHARGE_DESC() {
		return COMP_UI_M_WDC_CHARGE_DESC;
	}

	public void setCOMP_UI_M_WDC_CHARGE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WDC_CHARGE_DESC_LABEL) {
		this.COMP_UI_M_WDC_CHARGE_DESC_LABEL = COMP_UI_M_WDC_CHARGE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WDC_CHARGE_DESC(
			HtmlInputText COMP_UI_M_WDC_CHARGE_DESC) {
		this.COMP_UI_M_WDC_CHARGE_DESC = COMP_UI_M_WDC_CHARGE_DESC;
	}

	public PT_IL_WITHDRAWAL_CHARGE getPT_IL_WITHDRAWAL_CHARGE_BEAN() {
		return PT_IL_WITHDRAWAL_CHARGE_BEAN;
	}

	public void setPT_IL_WITHDRAWAL_CHARGE_BEAN(
			PT_IL_WITHDRAWAL_CHARGE PT_IL_WITHDRAWAL_CHARGE_BEAN) {
		this.PT_IL_WITHDRAWAL_CHARGE_BEAN = PT_IL_WITHDRAWAL_CHARGE_BEAN;
	}

	public List<PT_IL_WITHDRAWAL_CHARGE> getDataList_PT_IL_WITHDRAWAL_CHARGE() {
		return dataList_PT_IL_WITHDRAWAL_CHARGE;
	}

	public void setDataListPT_IL_WITHDRAWAL_CHARGE(
			List<PT_IL_WITHDRAWAL_CHARGE> dataList_PT_IL_WITHDRAWAL_CHARGE) {
		this.dataList_PT_IL_WITHDRAWAL_CHARGE = dataList_PT_IL_WITHDRAWAL_CHARGE;
	}

	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				PT_IL_WITHDRAWAL_CHARGE_BEAN = new PT_IL_WITHDRAWAL_CHARGE();
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

				new CRUDHandler().executeDelete(PT_IL_WITHDRAWAL_CHARGE_BEAN,
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
				dataList_PT_IL_WITHDRAWAL_CHARGE
				.remove(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				if (dataList_PT_IL_WITHDRAWAL_CHARGE.size() > 0) {

					PT_IL_WITHDRAWAL_CHARGE_BEAN = dataList_PT_IL_WITHDRAWAL_CHARGE
					.get(0);
				} else if (dataList_PT_IL_WITHDRAWAL_CHARGE.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setRowSelected(true);
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

			
			/*Added by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
			CommonUtils.getConnection().commit();
			/*End*/
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		
		/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/
		String exst_chk_query = null;
		Object[] params = null;
		CRUDHandler handler;
		ResultSet resultSet = null;
		
		/*End*/
		
		try {
			if (PT_IL_WITHDRAWAL_CHARGE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	

				exst_chk_query = "SELECT 'X' FROM   PT_IL_WITHDRAWAL_CHARGE WHERE WDC_CHRG_CODE = ? AND WDC_WD_SYS_ID =?";
				params = new Object[]{PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_CHRG_CODE(),compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getPT_IL_WITHDRAWAL_CHARGE_BEAN().
						getWDC_WD_SYS_ID()};



				handler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
				if(resultSet.next()){

					throw new Exception("Charge already exists.");
				}else
				{
					/*End*/
				
				/*
				 * Modified by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.
				 * 
				 * 
				 * new CRUDHandler().executeInsert(PT_IL_WITHDRAWAL_CHARGE_BEAN,
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
						"errorPanel$message$insert"));*/
				
				
				new CRUDHandler().executeInsert(PT_IL_WITHDRAWAL_CHARGE_BEAN,
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
				
				
				/*End*/
				
				dataList_PT_IL_WITHDRAWAL_CHARGE
				.add(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				
			}
			} else if (PT_IL_WITHDRAWAL_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.preUpdate(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	

				exst_chk_query = "SELECT 'X' FROM   PT_IL_WITHDRAWAL_CHARGE WHERE WDC_CHRG_CODE = ? AND WDC_WD_SYS_ID =?  AND ROWID<> ?";
				params = new Object[]{PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_CHRG_CODE(),compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getPT_IL_WITHDRAWAL_CHARGE_BEAN().
						getWDC_WD_SYS_ID(),PT_IL_WITHDRAWAL_CHARGE_BEAN.getROWID()};



				handler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
				if(resultSet.next()){

					throw new Exception("Charge already exists.");
				}else
				{
					/*End*/
				new CRUDHandler().executeUpdate(PT_IL_WITHDRAWAL_CHARGE_BEAN,
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
			}
			
			
			/*Added by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
			ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
			pOrclValList = new ArrayList<OracleParameter>();
			
			pOrclValList = pkg_pilt021.L_POP_WT_CHRG_SAVE( 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_SYS_ID()	);
			
			
			CommonUtils.getConnection().commit();
			/*End*/
			
			
			PT_IL_WITHDRAWAL_CHARGE_BEAN.setRowSelected(true);
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
			PT_IL_WITHDRAWAL_CHARGE_BEAN = (PT_IL_WITHDRAWAL_CHARGE) dataTable
			.getRowData();
			helper.postQuery(PT_IL_WITHDRAWAL_CHARGE_BEAN);
			PT_IL_WITHDRAWAL_CHARGE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_WITHDRAWAL_CHARGE> PT_IL_WITHDRAWAL_CHARGE_ITR = dataList_PT_IL_WITHDRAWAL_CHARGE
		.iterator();
		while (PT_IL_WITHDRAWAL_CHARGE_ITR.hasNext()) {
			PT_IL_WITHDRAWAL_CHARGE_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_WDC_CHRG_CODE.resetValue();
		COMP_WDC_RATE.resetValue();
		COMP_WDC_RATE_PER.resetValue();
		COMP_WDC_CUST_SHARE_PERC.resetValue();
		COMP_WDC_PREM_LC_VALUE.resetValue();
		COMP_WDC_PREM_FC_VALUE.resetValue();
		COMP_WDC_TOP_UP_LC_VALUE.resetValue();
		COMP_WDC_TOP_UP_FC_VALUE.resetValue();
		COMP_WDC_FC_VALUE.resetValue();
		COMP_WDC_LC_VALUE.resetValue();
		COMP_UI_M_WDC_CHARGE_DESC.resetValue();
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
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
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

	public void onLoad(PhaseEvent event) {
		try {
			
			/*Commented by Janani on 14.08.2017 for ZBILQC-1732415*/
			
			/*if("G".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){*/
			
			/*End of ZBILQC-1732415*/
				if (isBlockFlag()) {
					
					/*Commentted by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
				   //helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN(),this,compositeAction);
					/*End*/
				helper.executeQuery(compositeAction);
					if(PT_IL_WITHDRAWAL_CHARGE_BEAN.getROWID() != null){
						helper.postQuery(PT_IL_WITHDRAWAL_CHARGE_BEAN);
					}
					COMP_WDC_CHRG_CODE.resetValue();
					setBlockFlag(false);
					
				}
			
			/*Commented by Janani on 14.08.2017 for ZBILQC-1732415*/
				
			/*}else{
				disableAllComponent(true);
			}*/
				
				/*End of ZBILQC-1732415*/	
				
			/*UnCommented by Janani on 04.09.2017 for ZBILQC-1732415*/
				// For display purpose made disable true
			if("A".equals(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS())){
				disableAllComponent(true);
			}
			
			/*End of ZBILQC-1732415*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List<LovBean> prepareLOV(Object value) {
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
	}

	public void validateWDC_CHRG_CODE(FacesContext context,
			UIComponent component, Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CHRG_CODE((String) value);
		try {
			helper.WHEN_VALIDATE_WDC_CHRG_CODE((String) value,
					PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_SYS_ID(),
					PT_IL_WITHDRAWAL_CHARGE_BEAN.getROWID(),
					PT_IL_WITHDRAWAL_CHARGE_BEAN);
			COMP_UI_M_WDC_CHARGE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWDC_RATE(FacesContext context, UIComponent component,
			Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_RATE((Double) value);
		try {
			helper.WHEN_VALIDATE_WDC_RATE((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWDC_RATE_PER(FacesContext context,
			UIComponent component, Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_RATE_PER((Double) value);
		try {
			helper.WHEN_VALIDATE_WDC_RATE_PER((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWDC_CUST_SHARE_PERC(FacesContext context,
			UIComponent component, Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CUST_SHARE_PERC((Double) value);
		try {
			
			/*MOdified by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
			
			//helper.WHEN_VALIDATE_WDC_CUST_SHARE_PERC((Double) value);
			
			helper.WHEN_VALIDATE_WDC_CUST_SHARE_PERC((Double) value,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN(),PT_IL_WITHDRAWAL_CHARGE_BEAN);
			
			/*End*/
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWDC_FC_VALUE(FacesContext context,
			UIComponent component, Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_FC_VALUE((Double) value);
		try {
			helper.WHEN_VALIDATE_WDC_FC_VALUE((Double) value,compositeAction);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWDC_LC_VALUE(FacesContext context,
			UIComponent component, Object value) {
		PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_LC_VALUE((Double) value);
		try {
			helper.WHEN_VALIDATE_WDC_LC_VALUE((Double) value,compositeAction);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}
	

	/**
	 * Disables all components in PT_IL_WITHDRAWAL_CHARGE_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_WDC_CHRG_CODE.setDisabled(disabled);
		COMP_WDC_RATE.setDisabled(disabled);
		COMP_WDC_RATE_PER.setDisabled(disabled);
		COMP_WDC_CUST_SHARE_PERC.setDisabled(disabled);
		COMP_WDC_PREM_LC_VALUE.setDisabled(disabled);
		COMP_WDC_PREM_FC_VALUE.setDisabled(disabled);
		COMP_WDC_TOP_UP_LC_VALUE.setDisabled(disabled);
		COMP_WDC_TOP_UP_FC_VALUE.setDisabled(disabled);
		COMP_WDC_FC_VALUE.setDisabled(disabled);
		COMP_WDC_LC_VALUE.setDisabled(disabled);
		COMP_UI_M_WDC_CHARGE_DESC.setDisabled(disabled);
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		/* Added by ganesh on 11-05-2017 for handson feedback */
		COMP_WDC_SAVE.setDisabled(disabled);
		COMP_WDC_SAVE_DOWN.setDisabled(disabled);
		/*end*/

	}

	public PILT021_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT021_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_WITHDRAWAL_CHARGE_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_WITHDRAWAL_CHARGE_HELPER helper) {
		this.helper = helper;
	}

	public ArrayList<LovBean> getLovList() {
		return lovList;
	}

	public void setLovList(ArrayList<LovBean> lovList) {
		this.lovList = lovList;
	}

	public void setDataList_PT_IL_WITHDRAWAL_CHARGE(
			List<PT_IL_WITHDRAWAL_CHARGE> dataList_PT_IL_WITHDRAWAL_CHARGE) {
		this.dataList_PT_IL_WITHDRAWAL_CHARGE = dataList_PT_IL_WITHDRAWAL_CHARGE;
	}

	/* Added by ganesh on 11-05-2017 for handson feedback*/
	private HtmlCommandLink COMP_WDC_SAVE;

	public HtmlCommandLink getCOMP_WDC_SAVE() {
		return COMP_WDC_SAVE;
	}

	public void setCOMP_WDC_SAVE(HtmlCommandLink cOMP_WDC_SAVE) {
		COMP_WDC_SAVE = cOMP_WDC_SAVE;
	}
	
	private HtmlCommandLink COMP_WDC_SAVE_DOWN;

	public HtmlCommandLink getCOMP_WDC_SAVE_DOWN() {
		return COMP_WDC_SAVE_DOWN;
	}

	public void setCOMP_WDC_SAVE_DOWN(HtmlCommandLink cOMP_WDC_SAVE_DOWN) {
		COMP_WDC_SAVE_DOWN = cOMP_WDC_SAVE_DOWN;
	}
	/*END*/

	/*Added by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
	
	PKG_PILT021 pkg_pilt021 = new PKG_PILT021();
	
	/*End*/
	
}

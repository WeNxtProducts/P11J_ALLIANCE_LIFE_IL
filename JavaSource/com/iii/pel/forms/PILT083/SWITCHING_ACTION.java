package com.iii.pel.forms.PILT083;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SWITCHING_ACTION extends CommonAction{
	
	private List<SWITCHING> listSWITCHING = new ArrayList<SWITCHING>();
	private UIData dataTable;
	private SWITCHING SWITCHING_BEAN;

	public SWITCHING_ACTION(){
		SWITCHING_BEAN = new SWITCHING();
	}

	
	public void onLoad(PhaseEvent ae){
		try{
			if(isBlockFlag()){
				executeQuery();
				setBlockFlag(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage()); 
		}
	}
	
	
	public void addRow(ActionEvent event) { 
		try {
			if (isINSERT_ALLOWED()) {
				SWITCHING_BEAN = new SWITCHING();
				resetAllComponent();
			} else {
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
				PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
			}
			// Row highlight changes
			resetSelectedRow();
			SWITCHING_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	// to be attached with delete button in the grid 
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

			if(SWITCHING_BEAN.getROWID()!=null){	 
				new CRUDHandler().executeDelete(SWITCHING_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
								PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				listSWITCHING.remove(SWITCHING_BEAN);
			}else{
				listSWITCHING.remove(SWITCHING_BEAN);
			}
				/*if (listSWITCHING.size() > 0) {
					SWITCHING_BEAN= listSWITCHING().get(0);
				} else if (getBeanList().size() == 0) {
					addRow(null);
				}*/
				resetAllComponent();
				
				 
				
			} else {
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
								PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	// to be attached with post button in the grid 
	public void postRecord(ActionEvent event) {
		 
		String message = "";
		try {
			if (SWITCHING_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(SWITCHING_BEAN, CommonUtils.getConnection());
				getWarningMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(
								PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put( "postRecord", Messages.getString( PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				listSWITCHING.add(SWITCHING_BEAN);
				} else if (SWITCHING_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				
					//helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(SWITCHING_BEAN, CommonUtils.getConnection());
				getWarningMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(
								PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				getWarningMap().put( "postRecord", Messages.getString( PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
			// Row highlight changes
				resetSelectedRow();
				SWITCHING_BEAN.setRowSelected(true);
			} catch (Exception exc) {
			getErrorMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record not Inserted/Updated :: "
					+ exc.getMessage());
					getErrorMap().put( "postRecord", "Record not Inserted/Updated :: " + exc.getMessage());
				}
			}
		

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			SWITCHING_BEAN = (SWITCHING) dataTable.getRowData();
			//helper.LOAD_FRZ_UNFRZ_LABEL(this);
			resetAllComponent();
			// Row highlight changes
			resetSelectedRow();
			SWITCHING_BEAN.setRowSelected(true);	
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetAllComponent() {
		/*COMP_SRST_POL_CENTER.resetValue();
		COMP_SRST_POL_CUST_CODE.resetValue();
		COMP_SRST_POL_CUST_NAME.resetValue();
		COMP_SRST_POL_NO.resetValue();
		COMP_SRST_POL_REF_NO.resetValue();
		COMP_SRST_POL_PROD_NAME.resetValue();
		COMP_SRST_DT.resetValue();*/
	}	

	private void resetSelectedRow() {
		Iterator<SWITCHING> iterator = listSWITCHING.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}

	}

	
	
	public void executeQuery(){
		Connection connection = null;
		String query ="SELECT * FROM  PM_IL_PROD_APPL_FUND WHERE PAF_PROD_CODE = 'BJCRP'";
		ResultSet resultSet = null;
		listSWITCHING.clear();
		SWITCHING switchingBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			while(resultSet.next()){
				switchingBean = new SWITCHING();
				switchingBean.setSW_FM_FUND_NAME(resultSet.getString("PAF_FUND_CODE"));
				switchingBean.setSW_TO_FUND_NAME(resultSet.getString("PAF_FUND_CODE"));
				switchingBean.setSW_FM_FUND_PERC(resultSet.getDouble("PAF_FUND_PERC"));
				switchingBean.setSW_TO_FUND_PERC(resultSet.getDouble("PAF_FUND_PERC"));
				listSWITCHING.add(switchingBean);
			}
			if(listSWITCHING.size() > 0){
				this.setSWITCHING_BEAN(listSWITCHING.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}
	
	public SWITCHING getSWITCHING_BEAN() {
		return SWITCHING_BEAN;
	}


	public void setSWITCHING_BEAN(SWITCHING switching_bean) {
		SWITCHING_BEAN = switching_bean;
	}


	public List<SWITCHING> getListSWITCHING() {
		return listSWITCHING;
	}


	public void setListSWITCHING(List<SWITCHING> listSWITCHING) {
		this.listSWITCHING = listSWITCHING;
	}


	public UIData getDataTable() {
		return dataTable;
	}


	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}

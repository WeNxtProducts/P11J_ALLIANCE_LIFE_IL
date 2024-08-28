package com.iii.pel.forms.PILT083;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class SUBSCRIPTION_ACTION extends CommonAction{
	
	private UIData dataTable;
	
	private SUBSCRIPTION SUBSCRIPTION_BEAN;
	
	public SUBSCRIPTION getSUBSCRIPTION_BEAN() {
		return SUBSCRIPTION_BEAN;
	}
	
	public SUBSCRIPTION_ACTION(){
		SUBSCRIPTION_BEAN = new SUBSCRIPTION();
	}


	public void setSUBSCRIPTION_BEAN(SUBSCRIPTION sUBSCRIPTION_BEAN) {
		SUBSCRIPTION_BEAN = sUBSCRIPTION_BEAN;
	}

	private List<SUBSCRIPTION> dataList_SUBSCRIPTION = new ArrayList<SUBSCRIPTION>();
	
	
	
	public UIData getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public List<SUBSCRIPTION> getDataList_SUBSCRIPTION() {
		return dataList_SUBSCRIPTION;
	}



	public void setDataList_SUBSCRIPTION(List<SUBSCRIPTION> dataList_SUBSCRIPTION) {
		this.dataList_SUBSCRIPTION = dataList_SUBSCRIPTION;
	}



	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				executeQuery();
				setBlockFlag(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void saveRecord() {
		try {
		    CommonUtils.getConnection().commit();
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
		} catch (Exception e) {
		    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    e.getMessage());
		    getErrorMap().put("SAVE", e.getMessage());
		}
	    }
	
	
	public void executeQuery(){
		Connection connection = null;
		String query ="SELECT * FROM  PM_IL_PROD_APPL_FUND WHERE PAF_PROD_CODE = 'BJCRP'";
		ResultSet resultSet = null;
		dataList_SUBSCRIPTION.clear();
		SUBSCRIPTION SUBSCRIPTION_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			while(resultSet.next()){
				SUBSCRIPTION_BEAN = new SUBSCRIPTION();
				SUBSCRIPTION_BEAN.setSUBSCR_FUND_NAME(resultSet.getString("PAF_FUND_CODE"));
				SUBSCRIPTION_BEAN.setSUBSCR_FUND_ALLOCATION(resultSet.getDouble("PAF_FUND_PERC"));
				dataList_SUBSCRIPTION.add(SUBSCRIPTION_BEAN);
			}
			if(dataList_SUBSCRIPTION.size() > 0){
				this.setSUBSCRIPTION_BEAN(dataList_SUBSCRIPTION.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}
}



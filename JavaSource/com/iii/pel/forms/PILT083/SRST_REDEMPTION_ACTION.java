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

public class SRST_REDEMPTION_ACTION extends CommonAction{
	
	private SRST_REDEMPTION_DELEGATE SRST_REDEMPTION_DELEGATE_BEAN;
	
	private SRST_REDEMPTION_HELPER  SRST_REDEMPTION_HELPER_BEAN;
	
	private SRST_REDEMPTION  SRST_REDEMPTION_BEAN;
	
	private UIData dataTable;
	
	private List<SRST_REDEMPTION> dataList_REDEMPTION = new ArrayList<SRST_REDEMPTION>();
	
	public SRST_REDEMPTION_ACTION(){
		
		SRST_REDEMPTION_DELEGATE_BEAN = new SRST_REDEMPTION_DELEGATE();
		SRST_REDEMPTION_HELPER_BEAN = new SRST_REDEMPTION_HELPER();
		SRST_REDEMPTION_BEAN = new SRST_REDEMPTION();
	}
	
	


	public SRST_REDEMPTION_DELEGATE getSRST_REDEMPTION_DELEGATE_BEAN() {
		return SRST_REDEMPTION_DELEGATE_BEAN;
	}


	public void setSRST_REDEMPTION_DELEGATE_BEAN(
			SRST_REDEMPTION_DELEGATE sRST_REDEMPTION_DELEGATE_BEAN) {
		SRST_REDEMPTION_DELEGATE_BEAN = sRST_REDEMPTION_DELEGATE_BEAN;
	}


	public SRST_REDEMPTION_HELPER getSRST_REDEMPTION_HELPER_BEAN() {
		return SRST_REDEMPTION_HELPER_BEAN;
	}


	public void setSRST_REDEMPTION_HELPER_BEAN(
			SRST_REDEMPTION_HELPER sRST_REDEMPTION_HELPER_BEAN) {
		SRST_REDEMPTION_HELPER_BEAN = sRST_REDEMPTION_HELPER_BEAN;
	}


	public SRST_REDEMPTION getSRST_REDEMPTION_BEAN() {
		return SRST_REDEMPTION_BEAN;
	}


	public void setSRST_REDEMPTION_BEAN(SRST_REDEMPTION sRST_REDEMPTION_BEAN) {
		SRST_REDEMPTION_BEAN = sRST_REDEMPTION_BEAN;
	}




	public UIData getDataTable() {
		return dataTable;
	}




	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}




	public List<SRST_REDEMPTION> getDataList_REDEMPTION() {
		return dataList_REDEMPTION;
	}




	public void setDataList_REDEMPTION(List<SRST_REDEMPTION> dataList_REDEMPTION) {
		this.dataList_REDEMPTION = dataList_REDEMPTION;
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
		dataList_REDEMPTION.clear();
		SRST_REDEMPTION SRST_REDEMPTION_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			while(resultSet.next()){
				SRST_REDEMPTION_BEAN = new SRST_REDEMPTION();
				SRST_REDEMPTION_BEAN.setRDMP_FUND_NAME(resultSet.getString("PAF_FUND_CODE"));
				SRST_REDEMPTION_BEAN.setRDMP_FUND_ALLOCATION(resultSet.getDouble("PAF_FUND_PERC"));
				dataList_REDEMPTION.add(SRST_REDEMPTION_BEAN);
			}
			if(dataList_REDEMPTION.size() > 0){
				this.setSRST_REDEMPTION_BEAN(dataList_REDEMPTION.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}
	
  
}

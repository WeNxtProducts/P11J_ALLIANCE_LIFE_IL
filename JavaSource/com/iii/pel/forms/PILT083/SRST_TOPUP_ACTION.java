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

public class SRST_TOPUP_ACTION extends CommonAction{
	
	
	private UIData dataTable;
	
	private List<SRST_TOPUP> dataList_TOPUP = new ArrayList<SRST_TOPUP>();
	
	
	private SRST_TOPUP_DELEGATE SRST_TOPUP_DELEGATE_BEAN;
	
	private SRST_TOPUP_HELPER SRST_TOPUP_HELPER_BEAN;
	
	private SRST_TOPUP SRST_TOPUP_BEAN;
	
	public SRST_TOPUP_ACTION(){
	
		SRST_TOPUP_DELEGATE_BEAN = new SRST_TOPUP_DELEGATE();
		SRST_TOPUP_HELPER_BEAN = new SRST_TOPUP_HELPER();
		SRST_TOPUP_BEAN = new SRST_TOPUP();
	}

	
	
	public UIData getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public List<SRST_TOPUP> getDataList_TOPUP() {
		return dataList_TOPUP;
	}



	public void setDataList_TOPUP(List<SRST_TOPUP> dataList_TOPUP) {
		this.dataList_TOPUP = dataList_TOPUP;
	}



	public SRST_TOPUP_DELEGATE getSRST_TOPUP_DELEGATE_BEAN() {
		return SRST_TOPUP_DELEGATE_BEAN;
	}

	public void setSRST_TOPUP_DELEGATE_BEAN(
			SRST_TOPUP_DELEGATE sRST_TOPUP_DELEGATE_BEAN) {
		SRST_TOPUP_DELEGATE_BEAN = sRST_TOPUP_DELEGATE_BEAN;
	}

	public SRST_TOPUP_HELPER getSRST_TOPUP_HELPER_BEAN() {
		return SRST_TOPUP_HELPER_BEAN;
	}

	public void setSRST_TOPUP_HELPER_BEAN(SRST_TOPUP_HELPER sRST_TOPUP_HELPER_BEAN) {
		SRST_TOPUP_HELPER_BEAN = sRST_TOPUP_HELPER_BEAN;
	}

	public SRST_TOPUP getSRST_TOPUP_BEAN() {
		return SRST_TOPUP_BEAN;
	}

	public void setSRST_TOPUP_BEAN(SRST_TOPUP sRST_TOPUP_BEAN) {
		SRST_TOPUP_BEAN = sRST_TOPUP_BEAN;
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
		dataList_TOPUP.clear();
		SRST_TOPUP SRST_TOPUP_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			while(resultSet.next()){
				SRST_TOPUP_BEAN = new SRST_TOPUP();
				SRST_TOPUP_BEAN.setTUP_FUND_NAME(resultSet.getString("PAF_FUND_CODE"));
				SRST_TOPUP_BEAN.setTUP_FUND_ALLOCATION(resultSet.getDouble("PAF_FUND_PERC"));
				dataList_TOPUP.add(SRST_TOPUP_BEAN);
			}
			if(dataList_TOPUP.size() > 0){
				this.setSRST_TOPUP_BEAN(dataList_TOPUP.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}
	

}

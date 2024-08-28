package com.iii.pel.forms.PILM054_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DelegateDb {

	public DelegateDb() {
		super();
	}
	
	public ArrayList<PM_IL_RI_ACCOUNT_SETUP> populateCodeDetails(String 
		typedmAcctCode, String typedsAcctCode, String typedDivnCode){
		
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_IL_RI_ACCOUNT_SETUP> list=null;
		PM_IL_RI_ACCOUNT_SETUP valueBean = null;
		ResultSet resultSet=null;
		Connection connection = null;
		String query = PILM054_APAC_SQL_CONSTANTS.SEARCH_ACCT_CODE_LIST;
		if(typedmAcctCode!=null){
			typedmAcctCode += "%";
		}else
			typedmAcctCode = "%";
		
		if(typedsAcctCode!=null)
			typedsAcctCode += "%";
		else
			typedsAcctCode = "%";
		
		if(typedDivnCode!=null)
			typedDivnCode += "%";
		else
			typedDivnCode = "%";
		
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {typedmAcctCode,
					typedsAcctCode,
					typedDivnCode};
			resultSet=handler.executeSelectStatement(query,connection,values);
			
			if (resultSet != null) {
				list = new ArrayList<PM_IL_RI_ACCOUNT_SETUP>();
				while (resultSet.next()) {
					valueBean = new PM_IL_RI_ACCOUNT_SETUP();
					valueBean.setROWID(resultSet.getString("ROWID"));
					valueBean.setRAS_MAIN_ACNT_CODE(resultSet.getString(1));
					valueBean.setRAS_SUB_ACNT_CODE(resultSet.getString(2));
					valueBean.setRAS_DIVN_CODE(resultSet.getString(3));
					list.add(valueBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}



	public ArrayList<SelectItem> selectValueForComboBox(String formName, String blockName, String fieldName) {
		Connection con = null;
		ResultSet resultSet=null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		Object value[]={}; 
		try {
			con= CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			queryString = PILM054_APAC_SQL_CONSTANTS.PM_IL_RI_ACCOUNT_SETUP_SelectDrpDwnValues;
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);
			
			resultSet = handler.executeSelectStatement(queryString, con, value);
			
			drpDwn = new ArrayList<SelectItem>();
			while(resultSet.next()){
				System.out.println(">>Comming here");
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				System.out.println("Item: "+selectItem.getLabel()+", "+selectItem.getValue());
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;		
	}

	public ArrayList<LOV_POP> populateLovs(String query, Object values[]) {
	ArrayList<LOV_POP> list=null;
		ResultSet resultSet=null;
		Connection connection = null;
		
		LOV_POP lovPop = null;
		CRUDHandler handler = new CRUDHandler();
		try 
		{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			list = new ArrayList<LOV_POP>();
			while(resultSet.next()){
				lovPop = new LOV_POP();
				lovPop.setLOV_CODE(resultSet.getString(1));
				lovPop.setLOV_DESC(resultSet.getString(2));
				list.add(lovPop);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(resultSet != null){
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return list;
	}
	
	public void saveForm(PM_IL_RI_ACCOUNT_SETUP_ACTION actionBean) throws ValidatorException {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_RI_ACCOUNT_SETUP valueBean = null;
		PILM054_APAC_Helper helper = new PILM054_APAC_Helper();
		try{
			connection = CommonUtils.getConnection();
			valueBean = actionBean.getPM_IL_RI_ACCOUNT_SETUP_BEAN();
			if(valueBean.getROWID()==null){
				helper.preInsert();
				handler.executeInsert(valueBean, connection);
				actionBean.getWarningMap().put("current", "Record Inserted");
				actionBean.setWarningMessages("Record Inserted");
			}else{
				helper.preUpdate();
				int records = handler.executeInsert(valueBean, connection);
				actionBean.getWarningMap().put("current", records+" record(s) updated");
				actionBean.setWarningMessages(records+" record(s) updated");
			}
			connection.commit();
			
			
			
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
		
}

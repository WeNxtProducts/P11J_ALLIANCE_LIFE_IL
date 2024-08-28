package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILQ111_APAC_HELPER {
	
	public void loadingBaseValues(String rowId) throws Exception{
		PILQ111_APAC_COMPOSITE_ACTION compositeAction = new PILQ111_APAC_COMPOSITE_ACTION();
		CommonUtils.setGlobalObject("PILQ111_APAC_COMPOSITE_ACTION", compositeAction);
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try {
			delegate.fetchRiAllocDetails(rowId, compositeAction);
			delegate.fetchRiAllocCustDtls(compositeAction);
			PT_IL_RI_ALLOC_POST_QUERY(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	
	// Only setting parameters That are already set on menu.
	public void callPreFrom(){
		
	}
	
	/*
	 * Block Level Triggers (PT_IL_RI_ALLOC)
	 */

	public void PT_IL_RI_ALLOC_POST_QUERY(PILQ111_APAC_COMPOSITE_ACTION compositeAction){
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		PT_IL_RI_ALLOC_ACTION actionBean = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		PT_IL_RI_ALLOC valueBean = actionBean.getPT_IL_RI_ALLOC_BEAN();
		ControlBean ctrBean = CommonUtils.getControlBean();
		DBProcedures procedures = new DBProcedures();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try{
			connection = CommonUtils.getConnection();
			String Query1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
			Object[] values1 = {valueBean.getRIA_PROD_CODE()};
			String Query2 = "SELECT COVER_DESC FROM PM_IL_COVER WHERE  COVER_CODE = ?";
			Object[] values2 = {valueBean.getRIA_COVER_CODE()};
			
			if(valueBean.getRIA_PROD_CODE() != null){
				resultSet1 = handler.executeSelectStatement(Query1, connection, values1);
				if(resultSet1.next()){
					valueBean.setUI_M_PROD_DESC(resultSet1.getString(1));
				}
			}
			
			if(valueBean.getRIA_COVER_CODE()!= null){
				resultSet2 = handler.executeSelectStatement(Query2, connection, values2);
				if(resultSet2.next()){
					valueBean.setUI_M_COVER_DESC(resultSet2.getString(1));
				}
			}
			
			if(valueBean.getRIA_DIVN_CODE()!= null){
				ArrayList<String> list = procedures.callP_VAL_DIVN(valueBean.getRIA_DIVN_CODE(), "N", "N");
				if(list!= null && list.size()>0){
					valueBean.setUI_M_DIVN_DESC(list.get(0));
				}
			}
			
			if(valueBean.getRIA_PROD_CODE() != null && valueBean.getRIA_COVER_CODE()!= null){
				ArrayList<String> list1 = procedures.callP_VAL_DEPT(valueBean.getRIA_DIVN_CODE(), valueBean.getRIA_DEPT_CODE(), "N", "N");
				if(list1 != null && list1.size()>0){
					valueBean.setUI_M_DEPT_DESC(list1.get(0));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/*
	 * Field Level Triggers (PT_IL_RI_ALLOC)
	 */
	
	public void ria_divn_code_when_validate_item(PILQ111_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		DBProcedures procedures = new DBProcedures();
		PT_IL_RI_ALLOC_ACTION action = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		
		try{
			if((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_DIVN_CODE())!= null ){
				ArrayList<OracleParameter> list = procedures.P_VAL_DIVN((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_DIVN_CODE()),action.getPT_IL_RI_ALLOC_BEAN().getUI_M_DIVN_DESC(), "N", "E");
				if(list!= null && list.size()>0){
					action.getPT_IL_RI_ALLOC_BEAN().setUI_M_DIVN_DESC(list.get(0).getValue());
				}
			}
		}catch (Exception e) {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					action.getCOMP_RIA_DIVN_CODE().getId(), action.getErrorMap());
			throw new Exception(e.getMessage());
		}
	}
	
	public void ria_dept_code_when_validate_item(PILQ111_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		DBProcedures procedures = new DBProcedures();
		PT_IL_RI_ALLOC_ACTION action = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		try{
			if((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_DEPT_CODE())!= null ){
				ArrayList<String> list = procedures.callP_VAL_DEPT((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_DIVN_CODE()), (String)CommonUtils.getCurrentValue(action.getCOMP_RIA_DEPT_CODE()), "N", "E");
				if(list!= null && list.size()>0){
					action.getPT_IL_RI_ALLOC_BEAN().setUI_M_DEPT_DESC(list.get(0));
				}
			}
		}catch (SQLException e) {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					action.getCOMP_RIA_DEPT_CODE().getId(), action.getErrorMap(), action.getWarningMap());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void ria_prod_code_when_validate_item(PILQ111_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_RI_ALLOC_ACTION action = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			String Query = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
			Object[] values = {(String)CommonUtils.getCurrentValue(action.getCOMP_RIA_PROD_CODE())};
			if((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_PROD_CODE())!= null){
				resultSet = handler.executeSelectStatement(Query, connection, values);
			}
			if(resultSet.next()){
				action.getPT_IL_RI_ALLOC_BEAN().setUI_M_PROD_DESC(resultSet.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ria_cover_code_when_validate_item(PILQ111_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_RI_ALLOC_ACTION action = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			String Query = " SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE = ? ";
			Object[] values = {(String)CommonUtils.getCurrentValue(action.getCOMP_RIA_COVER_CODE())};
			if((String)CommonUtils.getCurrentValue(action.getCOMP_RIA_COVER_CODE())!= null){
				resultSet= handler.executeSelectStatement(Query, connection, values);
			}
			if(resultSet.next()){
				action.getPT_IL_RI_ALLOC_BEAN().setUI_M_COVER_DESC(resultSet.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
}

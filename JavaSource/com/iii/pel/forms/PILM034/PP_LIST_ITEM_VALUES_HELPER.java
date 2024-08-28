package com.iii.pel.forms.PILM034;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LIST_ITEM_VALUES_HELPER {

	public void executeQuery(PILM034_COMPOSITE_ACTION compositeAction) throws Exception {
		new PP_LIST_ITEM_VALUES_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void WHEN_NEW_BLOCK_INSTANCE(){
		//  POST;                    
		//:PM_IL_TAR_PARAM.TP_WHERE_CLAUSE  := :PM_IL_TAR_PARAM.TP_WHERE_CLAUSE;
	}

	public void postQuery(PP_LIST_ITEM_VALUES pp_list_item_values) throws Exception{
		String M_LIV_CODE = null;
		String M_LIV_CODE_DESC = null;

		String C1 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ? AND " +
		"LIV_SYS_PARAM = 'IL_TAR_TYP'";
		ResultSet resultSetC1 = null;
		try{
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			M_LIV_CODE = pp_list_item_values.getLIV_CODE();
			resultSetC1 = handler.executeSelectStatement(C1, connection,new Object[]{M_LIV_CODE});
			if (resultSetC1.next()) {
				M_LIV_CODE_DESC = resultSetC1.getString(1);
			}
			pp_list_item_values.setLIV_CODE_DESC(M_LIV_CODE_DESC);
		}catch(DBException e){
			throw new Exception(e.getMessage());
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSetC1);}catch(Exception e){}
		}
	}

	public void ON_POPULATE_DETAILS(PILM034_COMPOSITE_ACTION compositeAction, 
			String TH_PARAM_TYPE) throws Exception{
		if ( compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
				getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE() != null) {
			try {
				//new PM_IL_TAR_HDR_DELEGATE().executeSelectStatement(compositeAction, TH_PARAM_TYPE);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	public void ON_CHECK_DELETE_MASTER(PP_LIST_ITEM_VALUES pp_list_item_values) throws Exception{
		String dummy_define = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String PM_IL_TAR_HDR_cur = "SELECT 1 FROM PM_IL_TAR_HDR P WHERE " +
			"P.TH_PARAM_TYPE = ?";
			resultSet = handler.executeSelectStatement(PM_IL_TAR_HDR_cur, 
					connection, new Object[]{pp_list_item_values.getLIV_CODE()});
			if(resultSet.next()){
				dummy_define = resultSet.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
						"ON_CHECK_DELETE_MASTER"));
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_LIV_CODE(PP_LIST_ITEM_VALUES pp_list_item_values, 
			String LIV_CODE) throws Exception{
		String M_LIV_CODE = null;
		String M_LIV_CODE_DESC = null;
		String M_VAR = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;

		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String C1 = "SELECT 'X' FROM PP_LIST_ITEM_VALUES WHERE  LIV_CODE = ?";
			String C2 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?" +
			"AND LIV_SYS_PARAM = 'IL_TAR_TYP'";
			M_LIV_CODE = CommonUtils.nvl(LIV_CODE, " ");
			resultSetC1 = handler.executeSelectStatement(C1, connection, new Object[]{M_LIV_CODE});
			resultSetC2 = handler.executeSelectStatement(C2, connection, new Object[]{M_LIV_CODE});
			if(resultSetC1.next()){
				M_VAR = resultSetC1.getString(1);
			}else{
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1802"));
			}
			if(resultSetC2.next()){
				M_LIV_CODE_DESC = resultSetC2.getString(1);
			}
			pp_list_item_values.setLIV_CODE_DESC(M_LIV_CODE_DESC);
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}


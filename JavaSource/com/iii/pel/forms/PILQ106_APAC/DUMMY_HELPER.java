package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	public void preForm(DUMMY_ACTION dummy_action,DUMMY dummyBean){
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		
		if("PILT002_APAC".equals(CALLING_FORM) || "PILT003_APAC".equals(CALLING_FORM) || "PILT021".equals(CALLING_FORM)){
			dummyBean.setUI_M_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
			dummy_action.getUI_M_POL_NO().setDisabled(true);
			
		}else{
			dummy_action.getCOMP_Render_Back_Button().setRendered(false);
		}
		
	}
	
	public void whenNewFormInstance(PT_IL_UNIT_FUND_REG_HDR_ACTION unitFundRegHdrAction,
			PT_IL_UNIT_FUND_REG_DTL_ACTION unitFundRegDtlAction,
			PS_IL_UNIT_FUND_REG_ACTION unitFundRegAction){
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		
		if("PILT002_APAC".equals(CALLING_FORM) || "PILT003_APAC".equals(CALLING_FORM)){
			
			// perform execute query will be taken separately in onload method
		}else if(CALLING_FORM != null && CALLING_FORM.startsWith("PILT021")){
			// will load dummy page automatically
			//	GO_BLOCK('DUMMY');
		}
		
		unitFundRegHdrAction.setINSERT_ALLOWED(false);
		unitFundRegHdrAction.setUPDATE_ALLOWED(false);
		unitFundRegHdrAction.setDELETE_ALLOWED(false);
		
		unitFundRegDtlAction.setINSERT_ALLOWED(false);
		unitFundRegDtlAction.setUPDATE_ALLOWED(false);
		unitFundRegDtlAction.setDELETE_ALLOWED(false);

		unitFundRegAction.setINSERT_ALLOWED(false);
		unitFundRegAction.setUPDATE_ALLOWED(false);
		unitFundRegAction.setDELETE_ALLOWED(false);
	}
	
	// Block level triggers
	public void onPopulateDetails(PILQ106_APAC_COMPOSITE_ACTION compositeAction, DUMMY dummyBean) throws Exception{
		if(dummyBean.getPOL_SYS_ID() != null){
			compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().loadBlock();
		}
	}
	
	public void onCheckDeleteMaster(DUMMY dummyBean) throws Exception{
		Object[] values = null;
		String PT_IL_UNIT_FUND_REG_HDR_CUR = "SELECT 1 FROM PT_IL_UNIT_FUND_REG_HDR P "     
			+ "WHERE P.UFRH_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String dummyDefine = null;
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{dummyBean.getPOL_SYS_ID()};
			resultSet = handler.executeSelectStatement(PT_IL_UNIT_FUND_REG_HDR_CUR, 
					connection, values);
			if(resultSet.next()){
				dummyDefine = resultSet.getString(1);
				throw new Exception("Cannot delete master record when matching detail records exist.");
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	/**
	 * Rerender CUST_NAME, PROD_DESC
	 * @param dummyBean
	 * @throws Exception
	 */
	public void postQuery(DUMMY dummyBean) throws Exception{
		Object[] values = null;
		String POST_QUERY_CURSOR_C1 = "SELECT POL_CUST_CODE,POL_PROD_CODE "
			+ "FROM   PT_IL_POLICY "
			+ "WHERE  POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			if(dummyBean.getPOL_SYS_ID() != null){
				connection = CommonUtils.getConnection();
				values = new Object[]{dummyBean.getPOL_SYS_ID()};
				resultSet = handler.executeSelectStatement(POST_QUERY_CURSOR_C1, 
						connection, values);
				if(resultSet.next()){
					dummyBean.setCUST_CODE(resultSet.getString("POL_CUST_CODE"));
					dummyBean.setPROD_CODE(resultSet.getString("POL_PROD_CODE"));
				}else{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
							"71081"));
				}
				
				dummyBean.setCUST_NAME(PILQ106_APAC_PROGRAM_UNITS.P_VAL_CUST(dummyBean.getCUST_CODE(),
			            dummyBean.getCUST_NAME(),
			            "N",
			            "N"));
			  
				dummyBean.setPROD_DESC(PILQ106_APAC_PROGRAM_UNITS.P_VAL_PRODUCT(dummyBean.getPROD_CODE(),
   						new CommonUtils().getCurrentDate(),
			   	 		dummyBean.getPROD_DESC(),
 						"N"));  
			}
			
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void preQuery(DUMMY dummyBean){
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		
		if("PILT002_APAC".equals(CALLING_FORM) || "PILT003_APAC".equals(CALLING_FORM)){
			dummyBean.setUI_M_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
		}
		if(CALLING_FORM != null && CALLING_FORM.startsWith("PILT021")){
			dummyBean.setUI_M_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.POL_NO"));
		}
	}
	
	public void executeQuery(DUMMY_ACTION dummyAction) throws Exception{
		Object[] values = null;
		String EXECUTE_QUERY_CURSOR_C1 = "SELECT * FROM PT_IL_POLICY WHERE POL_NO = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		DUMMY dummyBean = dummyAction.getDUMMY_BEAN();

		try {
			connection = CommonUtils.getConnection();
			if(dummyAction.getDEFAULT_WHERE() != null){
				EXECUTE_QUERY_CURSOR_C1 = EXECUTE_QUERY_CURSOR_C1 + " AND " +dummyAction.getDEFAULT_WHERE();
			}
			values = new Object[]{dummyBean.getUI_M_POL_NO()};
			resultSet = handler.executeSelectStatement(EXECUTE_QUERY_CURSOR_C1, connection, values);
			if(resultSet.next()){
				dummyBean.setUI_M_POL_NO(resultSet.getString("POL_NO"));
				dummyBean.setUI_M_POL_PLAN_CODE(resultSet.getString("POL_PLAN_CODE"));
				dummyBean.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
			}
			
			// On populate details
			onPopulateDetails(dummyAction.compositeAction, dummyBean);
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	// Validators
	/**
	 * Rerender CUST_NAME, PROD_DESC
	 */
	public void whenValidateItem_UI_M_POL_NO(DUMMY dummyBean) throws Exception{
		Object[] values = null;
		String WVI_UI_M_POL_NO_CURSOR_C1 = "SELECT POL_SYS_ID,POL_CUST_CODE,POL_PROD_CODE "
			+ "FROM   PT_IL_POLICY "
			+ "WHERE  POL_NO=?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{dummyBean.getUI_M_POL_NO()};
			resultSet = handler.executeSelectStatement(WVI_UI_M_POL_NO_CURSOR_C1, 
					connection, values);
			if(resultSet.next()){
				dummyBean.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
				dummyBean.setCUST_CODE(resultSet.getString("POL_CUST_CODE"));
				dummyBean.setPROD_CODE(resultSet.getString("POL_PROD_CODE"));
			}else{
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
						"71081"));
			}
			
			dummyBean.setCUST_NAME(PILQ106_APAC_PROGRAM_UNITS.P_VAL_CUST(dummyBean.getCUST_CODE(),
		            dummyBean.getCUST_NAME(),
		            "N",
		            "N"));
		  
			dummyBean.setPROD_DESC(PILQ106_APAC_PROGRAM_UNITS.P_VAL_PRODUCT(dummyBean.getPROD_CODE(),
					new CommonUtils().getCurrentDate(),
		   	 		dummyBean.getPROD_DESC(),
					"N"));  

		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
}

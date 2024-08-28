package com.iii.pel.forms.PILM105_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class PM_PROD_APPL_FIELDS_HELPER {
	
	/**
	 * 
	 * @param PM_PROD_APPL_FIELDS_BEAN
	 */
	public void preInsert(PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN) throws Exception{
		Connection connection =null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String C1="SELECT 'X' FROM PM_PROD_APPL_FIELDS	WHERE PPAF_COL_CODE = ? AND PPAF_PROD_CODE = ?";
		String M_EXITS=null;
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PM_PROD_APPL_FIELDS_BEAN.getPPAF_COL_CODE(),PM_PROD_APPL_FIELDS_BEAN.getPPAF_PROD_CODE()});
			if(resultSet.next()){
				M_EXITS = resultSet.getString(1);
			    throw new Exception(
					    Messages
						    .getString(
							    PELConstants.pelErrorMessagePath,
							    "91028"));
			}
			PM_PROD_APPL_FIELDS_BEAN.setPPAF_CR_DT(new CommonUtils().getCurrentDate());
			PM_PROD_APPL_FIELDS_BEAN.setPPAF_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/**
	 * 
	 * @param PM_PROD_APPL_FIELDS_BEAN
	 */
	public void preUpdate(PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN) throws Exception{
		Connection connection =null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String C1="SELECT 'X' FROM PM_PROD_APPL_FIELDS	WHERE PPAF_COL_CODE = ?	AND PPAF_PROD_CODE = ?	AND ROWID != ? ";
		String M_EXITS=null;
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PM_PROD_APPL_FIELDS_BEAN.getPPAF_COL_CODE(),
																					PM_PROD_APPL_FIELDS_BEAN.getPPAF_PROD_CODE(),
																					PM_PROD_APPL_FIELDS_BEAN.getROWID()});
			if(resultSet.next()){
				M_EXITS = resultSet.getString(1);
			    throw new Exception(
					    Messages
						    .getString(
							    PELConstants.pelErrorMessagePath,
							    "91028"));
			}
			PM_PROD_APPL_FIELDS_BEAN.setPPAF_UPD_DT(new CommonUtils().getCurrentDate());
			PM_PROD_APPL_FIELDS_BEAN.setPPAF_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void whenNewBlockInstance(PILM105_APAC_COMPOSITE_ACTION compositeAction){
		if("Y".equalsIgnoreCase(compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getPM_PROD_APPL_FIELDS_BEAN().getPPAF_MAND_YN())){
			compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getCOMP_NMAND_YN().setValue("Y");
			compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getCOMP_MAND_YN().setDisabled(true);
		}else{
			compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getCOMP_MAND_YN().setDisabled(false);
		}
	}
	
	public void executeSelect(PILM105_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		new PM_PROD_APPL_FIELDS_DELEGATE().executeSelectStatement(compositeAction);
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void validateCOL_CODE(PILM105_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection =null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String C1="	SELECT  PC_LONG_DESC,PC_CODE	FROM PM_CODES	WHERE PC_TYPE = 'IL_UPD_COL' AND PC_CODE = ? ";
		String M_EXITS=null;
		String desc = null;
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getPM_PROD_APPL_FIELDS_BEAN().getPPAF_COL_CODE()});
			if(resultSet.next()){
				desc = resultSet.getString(1);
				M_EXITS  = resultSet.getString(2);
			}
			compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getPM_PROD_APPL_FIELDS_BEAN().setPPAF_COL_NAME(desc);
			if(M_EXITS==null || "".equalsIgnoreCase(M_EXITS)){
				
				throw new Exception(
						Messages
						.getString(
								PELConstants.pelErrorMessagePath,
						"91377"));
			}
			
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void validatePPAF_MAND_YN(PM_PROD_APPL_FIELDS_ACTION PM_PROD_APPL_FIELDS_ACTION_BEAN) throws Exception{
		if("Y".equalsIgnoreCase(PM_PROD_APPL_FIELDS_ACTION_BEAN.getPM_PROD_APPL_FIELDS_BEAN().getPPAF_MAND_YN())){
			PM_PROD_APPL_FIELDS_ACTION_BEAN.getPM_PROD_APPL_FIELDS_BEAN().setPPAF_NMAND_YN("N");
			PM_PROD_APPL_FIELDS_ACTION_BEAN.getCOMP_NMAND_YN().setDisabled(true);
		}else{
			PM_PROD_APPL_FIELDS_ACTION_BEAN.getCOMP_NMAND_YN().setDisabled(false);
		}
	}
	
    public void validateProductCode(String polCode) throws Exception{
    	Connection connection =null;
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	String C1="select prod_code from PM_IL_PRODUCT where prod_code=?";
    	try{
    		connection = CommonUtils.getConnection();
    		resultSet = handler.executeSelectStatement(C1, connection,new Object[]{polCode});
    		if(!resultSet.next()){
    			throw new Exception("Invalid Product Code");
    		}
    		
    	}catch(Exception exception){
    		exception.printStackTrace();
    		throw exception;
    	}finally{
    		CommonUtils.closeCursor(resultSet);
    	}
    }
}


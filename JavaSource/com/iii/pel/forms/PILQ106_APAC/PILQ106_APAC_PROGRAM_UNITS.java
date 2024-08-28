package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ106_APAC_PROGRAM_UNITS {
	public static String P_VAL_CUST(String P_CUST_CODE,
			String P_CUST_NAME,
			String P_NAME_FLAG,
			String P_ERR_FLAG) throws Exception{
		Object[] values = null;
		String CURSOR_C1 = "SELECT " 
			+ "DECODE(?,'N',CUST_NAME,CUST_SHORT_NAME), "
            + "DECODE(?,'N',CUST_BL_NAME,CUST_BL_SHORT_NAME), "
            + "CUST_FRZ_FLAG "
            + "FROM   PM_CUSTOMER "
            + "WHERE  CUST_CODE = ?";
		String M_NAME = null;
		String M_BL_NAME = null;
		String M_FRZ_FLAG = null;
		String langCode = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{P_NAME_FLAG, P_NAME_FLAG, P_CUST_CODE};
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, values);
			if(resultSet.next()){
				M_NAME = resultSet.getString(1);
				M_BL_NAME = resultSet.getString(2);
				M_FRZ_FLAG = resultSet.getString(3);
			}else{
				if("E".equals(P_ERR_FLAG) || "W".equals(P_ERR_FLAG)){
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1007"));
					}
				}
			}
			
			if("Y".equals(M_FRZ_FLAG)){
				if("E".equals(P_ERR_FLAG) || "W".equals(P_ERR_FLAG)){
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1024"));
					}
				}
			}
			
			langCode = CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
			if (langCode != null
					&& (langCode.length() > 4 && '1' == langCode.charAt(4))
					|| "ENG".equals(CommonUtils.getGlobalObject("GLOBAL.M_LANG_CODE"))) {
				P_CUST_NAME = M_NAME;
			} else {
				P_CUST_NAME = M_BL_NAME;
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return P_CUST_NAME;
	}
	
	public static String P_VAL_PRODUCT(String P_PROD_CODE,
			Date P_POL_ISSUE_DT,
			String P_PROD_DESC,
			String P_ERR_FLAG) throws Exception{
		Object[] values = null;
		String CURSOR_C1 = "SELECT PROD_DESC,PROD_BL_DESC "
			+ "FROM   PM_IL_PRODUCT " 
			+ "WHERE  PROD_CODE = ? "
			+ "AND    ? "
            + "BETWEEN NVL(PROD_EFF_FM_DT, TO_DATE('01/01/1900','DD/MM/RRRR')) " 
            + 		"AND NVL(PROD_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))";
		String M_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		String langCode = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{P_PROD_CODE, P_POL_ISSUE_DT};
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, values);
			if(resultSet.next()){
				M_PROD_DESC = resultSet.getString(1);
				M_PROD_BL_DESC = resultSet.getString(2);
				
				langCode = CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
				if (langCode != null && langCode.length() > 4
						&& (langCode.length() > 4 && '1' == langCode.charAt(4))
						|| "ENG".equals(CommonUtils.getGlobalObject("GLOBAL.M_LANG_CODE"))) {
					P_PROD_DESC = M_PROD_DESC;
				} else {
					P_PROD_DESC = M_PROD_BL_DESC;
				}
			}else{
				if("E".equals(P_ERR_FLAG) || "W".equals(P_ERR_FLAG)){
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91074"));
					}
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return P_PROD_DESC;
	}
}

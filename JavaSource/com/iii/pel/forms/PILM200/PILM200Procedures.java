package com.iii.pel.forms.PILM200;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM200Procedures {
//added by dileshwar for product group master
	
	public void L_VAL_PROD_UNIQUE(String PGD_PROD_CODE, String PGD_GROUP_CODE,
			String ROWID) throws Exception {
		String CURSOR_C1 = "SELECT 'X' FROM   PM_IL_PROD_GROUP_DTL WHERE  PGD_PROD_CODE  = ? AND PGD_GROUP_CODE =? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PM_IL_PROD_GROUP_DTL WHERE  PGD_PROD_CODE  = ? AND	PGD_GROUP_CODE =? AND ROWID <> ? ";
		String M_DUMMY = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (ROWID == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { PGD_PROD_CODE,
								PGD_GROUP_CODE });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91983"));
				}
			} else {
				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { PGD_PROD_CODE,
								PGD_GROUP_CODE, ROWID });
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91983"));
				}
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	//added by dileshwar for product group master
	public String P_VAL_PROD(String P_PROD_CODE ,
		    				 String P_PROD_DESC ,
		    				 String P_NAME_FLAG ,
		    				 String  P_ERR_FLAG) throws Exception{   
	
			String CURSOR_C1 = "SELECT DECODE(? , 'N', PROD_DESC, PROD_LONG_DESC)," +
			"DECODE( ? ,'N',PROD_BL_DESC,PROD_BL_LONG_DESC) FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? ";
	
			String M_NAME = null;
			String M_BL_NAME  = null;
			ResultSet resultSet = null;
			CRUDHandler handler = new CRUDHandler();
			Connection connection;
			try {
				connection = CommonUtils.getConnection();
				resultSet =  handler.executeSelectStatement(CURSOR_C1, connection, new Object[]{P_NAME_FLAG,P_NAME_FLAG,P_PROD_CODE});
				if (resultSet.next() ) {
					M_NAME = resultSet.getString(1);
					M_BL_NAME = resultSet.getString(2);
				}else{
					if ("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath ,"91982"));
					}
				}
				if ("1".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),5,1)) || 
						"ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")))  {
					P_PROD_DESC = M_NAME;
				}else {
					P_PROD_DESC = M_BL_NAME;
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage()); 
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			return P_PROD_DESC;
	} 
}

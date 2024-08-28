package com.iii.pel.forms.PILM200;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_GROUP_DTL_DELEGATE {

	public void executeSelectStatement(PILM200_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_IL_PROD_GROUP_DTL_ACTION_BEAN().dataList.clear();
	
			try {
				connection = CommonUtils.getConnection();
			
			
				String selectStatement = "SELECT ROWID, PM_IL_PROD_GROUP_DTL.* FROM PM_IL_PROD_GROUP_DTL WHERE PGD_GROUP_CODE = ? ";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_GROUP_CODE()});
				while (resultSet.next()) {
					PM_IL_PROD_GROUP_DTL PM_IL_PROD_GROUP_DTL_BEAN = new PM_IL_PROD_GROUP_DTL();
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_GROUP_CODE(resultSet.getString("PGD_GROUP_CODE"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_DEFAULT_YN(resultSet.getString("PGD_DEFAULT_YN"));
					
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_MANDATORY_YN(resultSet.getString("PGD_MANDATORY_YN"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_MAIN_PROD_YN(resultSet.getString("PGD_MAIN_PROD_YN"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_CR_DT(resultSet.getDate("PGD_CR_DT"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_CR_UID(resultSet.getString("PGD_CR_UID"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_UPD_DT(resultSet.getDate("PGD_UPD_DT"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_UPD_UID(resultSet.getString("PGD_UPD_UID"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_PROD_CODE(resultSet.getString("PGD_PROD_CODE"));
					PM_IL_PROD_GROUP_DTL_BEAN.setPGD_FRZ_FLAG(resultSet.getString("PGD_FRZ_FLAG"));
					PM_IL_PROD_GROUP_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				
					new PM_IL_PROD_GROUP_DTL_HELPER().postQuery(PM_IL_PROD_GROUP_DTL_BEAN);
					compositeAction.getPM_IL_PROD_GROUP_DTL_ACTION_BEAN().dataList.add(PM_IL_PROD_GROUP_DTL_BEAN);
			
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
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
				

		
	}

}

package com.iii.pel.forms.PILM200;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_GROUP_HDR_DELEGATE {

	public void excuteQuery(PM_IL_PROD_GROUP_HDR headerBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String Select_query = "SELECT PM_IL_PROD_GROUP_HDR.*,ROWID FROM  PM_IL_PROD_GROUP_HDR WHERE ROWID = ? ";
		//PM_IL_PROD_GROUP_HDR header = null;
		try {
			resultSet = handler.executeSelectStatement(Select_query,CommonUtils.getConnection(),
					new Object[]{headerBean.getROWID()});
			//PM_IL_PROD_GROUP_HDR header = new PM_IL_PROD_GROUP_HDR();
			if (resultSet.next()) {
				headerBean.setPGH_APPL_PLAN_CODE(resultSet.getString("PGH_APPL_PLAN_CODE"));
				headerBean.setPGH_GROUP_CODE(resultSet.getString("PGH_GROUP_CODE"));
				headerBean.setPGH_DESC(resultSet.getString("PGH_DESC"));
				headerBean.setPGH_SHORT_DESC(resultSet.getString("PGH_SHORT_DESC"));
				headerBean.setPGH_LONG_DESC(resultSet.getString("PGH_LONG_DESC"));
				headerBean.setPGH_BL_DESC(resultSet.getString("PGH_BL_DESC"));
				headerBean.setPGH_BL_SHORT_DESC(resultSet.getString("PGH_BL_SHORT_DESC"));
				headerBean.setPGH_BL_LONG_DESC(resultSet.getString("PGH_BL_LONG_DESC"));
				headerBean.setPGH_FRZ_FLAG(resultSet.getString("PGH_FRZ_FLAG"));
				headerBean.setPGH_CR_DT(resultSet.getDate("PGH_CR_DT"));
				headerBean.setPGH_CR_UID(resultSet.getString("PGH_CR_UID"));
				headerBean.setPGH_UPD_DT(resultSet.getDate("PGH_UPD_DT"));
				headerBean.setPGH_UPD_UID(resultSet.getString("PGH_UPD_UID"));
			}
			//compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().setPM_IL_PROD_GROUP_HDR_BEAN(header);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
}
				
		


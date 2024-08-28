package com.iii.pel.forms.PM101_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_COMP_CONT_HELPER {
	public String validateAPCC_MKT_CODE(String value) throws Exception {
		String C1 = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' "
				+ "AND PC_CODE = ?";
		Connection connection;
		ResultSet resultSet = null;
		CRUDHandler handler;
		String PC_DESC = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {value});
			if (resultSet.next()) {
				PC_DESC = resultSet.getString(1);
			}
			if (PC_DESC == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80223"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return PC_DESC;
	}
	
	public String validateAPCC_RANK_CODE(String value) throws Exception {
		String C1 = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' "
				+ "AND PC_CODE = ?";
		Connection connection;
		ResultSet resultSet = null;
		CRUDHandler handler;
		String PC_DESC = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { value});
			if (resultSet.next()) {
				PC_DESC = resultSet.getString(1);
			}
			if (PC_DESC == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80223"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return PC_DESC;
	}

}

package com.iii.pel.forms.PILM071_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PILM071_APAC_HELPER {

	public void pre_insert(PM_LIFE_ENDT_NUMBER_SETUP endBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		int M_EXISTS = 0;

		try {

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PILM071_APAC_QUERY_CONSTANT.SELECT_PRE_INSERT, connection);
			if (resultSet.next()) {
				M_EXISTS = resultSet.getInt(1);
			}
			if (MigratingFunctions.nvl(M_EXISTS, 0) == 1) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80031"));
			}
			if (endBean.getENS_ZERO_PAD() > 9) {
				throw new Exception(Messages.getString("messageProperties_PILM071_APAC","PILM071_APAC$ENS_ZERO_PAD$error"));
			}
			if (endBean.getENS_ZERO_PAD() < 0) {
				throw new Exception(Messages.getString("messageProperties_PILM071_APAC","PILM071_APAC$ENS_ZERO_PAD$NEGATIVE$ERROR"));
			}
			endBean.setENS_CR_DT(new Date());
			endBean.setENS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void pre_update(PM_LIFE_ENDT_NUMBER_SETUP endBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		int M_EXISTS = 0;
		String updateQuery = PILM071_APAC_QUERY_CONSTANT.SELECT_PRE_UPDATE;
		try {
			connection = CommonUtils.getConnection();
			Object[] values = { endBean.getROWID() };
			resultSet = handler.executeSelectStatement(updateQuery, connection,values);

			if (resultSet.next()) {
				M_EXISTS = resultSet.getInt(1);
			}
			if (MigratingFunctions.nvl(M_EXISTS, 0) == 1) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80031"));
			}
			if (endBean.getENS_ZERO_PAD() > 9) {
				throw new Exception(Messages.getString("messageProperties_PILM071_APAC","PILM071_APAC$ENS_ZERO_PAD$error"));
			}
			if (endBean.getENS_ZERO_PAD() < 0) {
				throw new Exception(Messages.getString("messageProperties_PILM071_APAC","PILM071_APAC$ENS_ZERO_PAD$NEGATIVE$ERROR"));
			}
			endBean.setENS_UPD_DT(new Date());
			endBean.setENS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void when_create_record(PM_LIFE_ENDT_NUMBER_SETUP endBean) {
		endBean.setENS_ZERO_PAD(0);
	}
}

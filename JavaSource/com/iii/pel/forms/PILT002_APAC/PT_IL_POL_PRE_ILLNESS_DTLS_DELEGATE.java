package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PRODUCT;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_INTREST;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_PRE_ILLNESS_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION COMPOSITE_ACTION_BEAN)
					throws Exception {
		PT_IL_POLICY POLICY_BEAN = COMPOSITE_ACTION_BEAN
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_FUNERAL_MEMB_DTLS MEMB_BEAN=COMPOSITE_ACTION_BEAN
				.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN();	
		String selectStatement = "SELECT ROWID, PT_IL_POL_PRE_ILLNESS_DTLS.* FROM PT_IL_POL_PRE_ILLNESS_DTLS "
				+ "WHERE PPID_POL_SYS_ID=? AND PPID_PFMD_SYS_ID = ?";
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] c1values = null;
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		COMPOSITE_ACTION_BEAN
		.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN()
		.getDataList_PT_IL_POL_PRE_ILLNESS_DTLS().clear();

		try {
			connection = CommonUtils.getConnection();
			c1values = new Object[] { POLICY_BEAN.getPOL_SYS_ID(),MEMB_BEAN.getPFMD_SYS_ID() };
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, c1values);
			while (resultSet.next()) {

				PT_IL_POL_PRE_ILLNESS_DTLS PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = new PT_IL_POL_PRE_ILLNESS_DTLS();
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN
				.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_CR_DT(resultSet
						.getDate("PPID_CR_DT"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_UPD_DT(resultSet
						.getDate("PPID_UPD_DT"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_CR_UID(resultSet
						.getString("PPID_CR_UID"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_UPD_UID(resultSet
						.getString("PPID_CR_UID"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_PRE_ILNS_DT(resultSet
						.getDate("PPID_PRE_ILNS_DT"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_PRE_ILNS_CODE(resultSet
						.getString("PPID_PRE_ILNS_CODE"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_SYS_ID(resultSet
						.getLong("PPID_SYS_ID"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_POL_SYS_ID(resultSet
						.getLong("PPID_POL_SYS_ID"));
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_PFMD_SYS_ID(resultSet
						.getLong("PPID_PFMD_SYS_ID"));
				
				list = procedures.P_VAL_CODES("IL_ILL_CODE", PT_IL_POL_PRE_ILLNESS_DTLS_BEAN
						.getPPID_PRE_ILNS_CODE(), PT_IL_POL_PRE_ILLNESS_DTLS_BEAN
						.getUI_PPID_PRE_ILNS_DES(), "N", "E", null);
				if(list != null && !list.isEmpty()){
					PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setUI_PPID_PRE_ILNS_DES(list.get(0));
				}
				COMPOSITE_ACTION_BEAN
				.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_PRE_ILLNESS_DTLS().add(
						PT_IL_POL_PRE_ILLNESS_DTLS_BEAN);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}

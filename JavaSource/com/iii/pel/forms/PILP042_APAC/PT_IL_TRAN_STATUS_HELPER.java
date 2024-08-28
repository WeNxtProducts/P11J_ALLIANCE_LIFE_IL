package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_TRAN_STATUS_HELPER {

	public void pilp042_apac_dummy_m_wd_status_dt_when_validate()
			throws ValidatorException {
		CommonUtils commonUtils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_TRAN_STATUS_ACTION dummyAction = compositeAction
				.getPT_IL_TRAN_STATUS_ACTION();
		PT_IL_TRAN_STATUS dummyBean = dummyAction.getPT_IL_TRAN_STATUS_BEAN();
		try {
			if (dummyBean.getUI_M_WD_STATUS_DT().after(
					commonUtils.getCurrentDate())) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Less than or equal to"
								+ commonUtils.getCurrentDate() }));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pilp042_apac_dummy_m_wd_status_code_when_validate_item()
			throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION hdrAction = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR hdrBean = hdrAction.getPT_IL_FUND_TRAN_HDR_BEAN();
		PT_IL_TRAN_STATUS_ACTION dummyAction = compositeAction
				.getPT_IL_TRAN_STATUS_ACTION();
		PT_IL_TRAN_STATUS dummyBean = dummyAction.getPT_IL_TRAN_STATUS_BEAN();
		DBProcedures dbProcedures = new DBProcedures();

		String M_PS_VALUE = null;
		String M_DUMMY = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		System.out.println("HEADER SYS ID IS :" + hdrBean.getFTH_SYS_ID());
		System.out.println("POLICY SYS ID IS :" + hdrBean.getFTH_POL_SYS_ID());
		try {
			String sql_C1 = "SELECT FTH_STATUS_CODE FROM  PT_IL_FUND_TRAN_HDR  WHERE  FTH_SYS_ID  = ?  AND FTH_POL_SYS_ID  = ? ";
			Object[] object = { hdrBean.getFTH_SYS_ID(),
					hdrBean.getFTH_POL_SYS_ID() };
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(sql_C1, connection,
					object);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
			}

			if (dummyBean.getUI_M_WD_STATUS_CODE() != null) {
				if (M_DUMMY.equals(dummyBean.getUI_M_WD_STATUS_CODE())) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91156"));
				}
				ArrayList<String> list = dbProcedures
						.callP_VAL_SYSTEM("IL_TRAN_STAT", dummyBean
								.getUI_M_WD_STATUS_CODE(), "E");
				if (list != null && list.size() > 0) {
					dummyBean.setUI_M_WD_STATUS_CODE_DESC(list.get(0));
					M_PS_VALUE = list.get(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void okButtonPressed() throws ValidatorException {

		String M_DUMMY = null;
		Connection connection = null;
		ResultSet resultSet = null;
		int update = -1;
		int insert = -1;
		ControlBean ctrlBean = CommonUtils.getControlBean();
		CRUDHandler handler = new CRUDHandler();
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");

		PT_IL_FUND_TRAN_HDR pt_il_fund_tran_hdr = compAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		PT_IL_TRAN_STATUS dummy = compAction.getPT_IL_TRAN_STATUS_ACTION()
				.getPT_IL_TRAN_STATUS_BEAN();
		double FTH_SYS_ID = pt_il_fund_tran_hdr.getFTH_SYS_ID();
		System.out.println("FTH_SYS_ID :" + FTH_SYS_ID);
		double FTH_POL_SYS_ID = pt_il_fund_tran_hdr.getFTH_POL_SYS_ID();
		System.out.println("FTH_POL_SYS_ID :" + FTH_POL_SYS_ID);
		String query = " SELECT FTH_STATUS_CODE " + "FROM PT_IL_FUND_TRAN_HDR "
				+ "WHERE  FTH_SYS_ID = '" + FTH_SYS_ID + "'"
				+ "AND FTH_POL_SYS_ID = '" + FTH_POL_SYS_ID + "'";

		if (dummy.getTS_STATUS_CODE() == null) {
			// SET_ITEM_PROPERTY('DUMMY.M_WD_STATUS_CODE',REQUIRED,PROPERTY_TRUE);

		}

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);

			while (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				System.out.println("M_DUMMY" + M_DUMMY);
				System.out.println("dummy.getM_WD_STATUS_CODE()"
						+ dummy.getUI_M_WD_STATUS_CODE());
			}

			/*
			 * } catch(Exception exception){ }
			 */

			if (dummy.getUI_M_WD_STATUS_CODE() != null) {
				if (dummy.getUI_M_WD_STATUS_CODE() == (M_DUMMY)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91156"));
					// STD_MESSAGE_ROUTINE(91156,:CTRL.M_LANG_CODE);
				}
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dummy.getUI_M_WD_STATUS_DT());
			System.out.println("status date :" + calendar.getTimeInMillis()
					+ "status code :" + dummy.getUI_M_WD_STATUS_CODE()
					+ "Reason code :" + dummy.getUI_M_WD_REASON_CODE());
			
			String updateQuery ="UPDATE PT_IL_FUND_TRAN_HDR SET FTH_STATUS_DT=?,FTH_STATUS_CODE=?,FTH_REASON_CODE=?,FTH_STATUS_REMARKS=? WHERE FTH_SYS_ID=? AND FTH_POL_SYS_ID=?";
			Object value[]={dummy.getUI_M_WD_STATUS_DT(),dummy.getUI_M_WD_STATUS_CODE(),dummy.getUI_M_WD_REASON_CODE(),dummy.getUI_M_WD_REMARKS(),FTH_SYS_ID,FTH_POL_SYS_ID};
			/*String updateQuery = "UPDATE PT_IL_FUND_TRAN_HDR "
					+ " SET FTH_STATUS_DT = '"
					+ new java.sql.Date(calendar.getTimeInMillis()) + "'"
					+ ",FTH_STATUS_CODE ='" + dummy.getUI_M_WD_STATUS_CODE()
					+ "'" + ",FTH_REASON_CODE  ='"
					+ dummy.getUI_M_WD_REASON_CODE() + "'"
					+ ",FTH_STATUS_REMARKS = '" + dummy.getUI_M_WD_REMARKS()
					+ "'" + " WHERE FTH_SYS_ID = '" + FTH_SYS_ID + "'"
					+ " AND FTH_POL_SYS_ID ='" + FTH_POL_SYS_ID + "'";*/
			update = handler.executeUpdateStatement(updateQuery,connection,value);
			System.out.println("UPDATE :" + update);
			if (dummy.getUI_M_WD_STATUS_CODE()!=null) {

				String insertQuery = "INSERT INTO PT_IL_TRAN_STATUS (TS_POL_SYS_ID ,TS_TRAN_SYS_ID ,TS_TRAN_TYPE ,TS_END_NO_IDX ,TS_STATUS_DT ,TS_STATUS_CODE ,TS_REASON_CODE ,TS_REMARKS ,TS_STATUS_UID ,TS_STATUS_TYPE ,TS_CR_UID ,TS_CR_DT ) VALUES ( ? ,? ,'H' ,NULL ,SYSDATE ,? ,? ,? ,? ,NULL ,? ,SYSDATE )";
				Object[] values = { pt_il_fund_tran_hdr.getFTH_POL_SYS_ID(),
						pt_il_fund_tran_hdr.getFTH_SYS_ID(),
						dummy.getUI_M_WD_STATUS_CODE(),
						dummy.getUI_M_WD_REASON_CODE(),
						dummy.getUI_M_WD_REMARKS(), ctrlBean.getM_USER_ID(),
						ctrlBean.getM_USER_ID() };
				insert = handler.executeInsertStatement(insertQuery,
						connection, values);
				System.out.println("INSERT :"+insert);

			}

			ctrlBean.setM_COMM_DEL("C");
			// COPY(20,"SYSTEM.MESSAGE_LEVEL");
			connection.commit();
			// COPY("0","SYSTEM.MESSAGE_LEVEL");
			ctrlBean.setM_COMM_DEL(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("going out");
	}

}

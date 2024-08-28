package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;



public class PT_IL_POL_PRE_ILLNESS_DTLS_HELPER {


	public void  preInsert(PT_IL_POL_PRE_ILLNESS_DTLS Bean,PILT002_APAC_COMPOSITE_ACTION compositeAction){

		PT_IL_POLICY POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_FUNERAL_MEMB_DTLS MEMB_BEAN=compositeAction
				.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN();
		String C1="SELECT PPID_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if (resultSet.next()) {
				Bean.setPPID_SYS_ID(resultSet.getLong(1));
			}
			
		Bean.setPPID_POL_SYS_ID(POLICY_BEAN.getPOL_SYS_ID());
		Bean.setPPID_PFMD_SYS_ID(MEMB_BEAN.getPFMD_SYS_ID());
		Bean.setPPID_CR_DT(new CommonUtils().getCurrentDate());
		Bean.setPPID_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void  preUpdate(PT_IL_POL_PRE_ILLNESS_DTLS Bean,PILT002_APAC_COMPOSITE_ACTION compositeAction){

		
		try{
				
		Bean.setPPID_UPD_DT(new CommonUtils().getCurrentDate());
		Bean.setPPID_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void PAID_ILLNESS_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_PRE_ILLNESS_DTLS illnessDetail, PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY policybean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		String CURSOR_C1 = "SELECT ROWID FROM   PT_IL_POL_PRE_ILLNESS_DTLS WHERE  PPID_POL_SYS_ID = ? "
							+ " AND  PPID_PFMD_SYS_ID = ? AND    PPID_PRE_ILNS_CODE = ? ";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (illnessDetail.getPPID_PRE_ILNS_CODE() != null) {
				list = procedures.P_VAL_CODES("IL_ILL_CODE", illnessDetail
						.getPPID_PRE_ILNS_CODE(), illnessDetail
						.getUI_PPID_PRE_ILNS_DES(), "N", "E", null);
				if(list != null && !list.isEmpty()){
				illnessDetail.setUI_PPID_PRE_ILNS_DES(list.get(0));
				}
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {policybean.getPOL_SYS_ID(),
								illnessDetail.getPPID_PFMD_SYS_ID(),
								illnessDetail.getPPID_PRE_ILNS_CODE() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
					if (CommonUtils.isDuplicate(illnessDetail.getROWID(), M_TEMP)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71018"));
					}
				}
				CommonUtils.closeCursor(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
							}
		}

	}


	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction){
		try {
			new PT_IL_POL_PRE_ILLNESS_DTLS_DELEGATE().executeSelectStatement(compositeAction);


			List<PT_IL_POL_PRE_ILLNESS_DTLS> dataList = compositeAction
					.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN()
					.getDataList_PT_IL_POL_PRE_ILLNESS_DTLS();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_POL_PRE_ILLNESS_DTLS PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = dataList
						.get(0);
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_PRE_ILLNESS_DTLS_ACTION_BEAN()
				.setPT_IL_POL_PRE_ILLNESS_DTLS_BEAN(
						PT_IL_POL_PRE_ILLNESS_DTLS_BEAN);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

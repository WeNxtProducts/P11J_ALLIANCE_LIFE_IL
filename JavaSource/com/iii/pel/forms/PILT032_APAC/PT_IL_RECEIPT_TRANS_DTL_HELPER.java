package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_RECEIPT_TRANS_DTL_HELPER {

	public void executeQuery(PILT032_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		new PT_IL_RECEIPT_TRANS_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);
		List<PT_IL_RECEIPT_TRANS_DTL> dataList = compositeAction.
		getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().getDataList_PT_IL_RECEIPT_TRANS_DTL();
		if(dataList !=null && dataList.size() > 0){
			PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN = dataList.get(0);
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN()
			.setPT_IL_RECEIPT_TRANS_DTL_BEAN(PT_IL_RECEIPT_TRANS_DTL_BEAN);
		}
	}

	public void PRE_UPDATE(PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN)
			throws Exception {
		try {
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_UPD_DT(new CommonUtils()
					.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POST_QUERY(PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			String C1 = "SELECT DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT FROM   PT_IL_DEPOSIT WHERE  "
					+ "DEP_SYS_ID = ?";
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_RECEIPT_TRANS_DTL_BEAN
							.getRTD_SRC_DEP_SYS_ID() });
			if (resultSet.next()) {
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_RTD_TXN_CODE(resultSet
						.getString(1));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DOC_NO(resultSet
						.getString(2));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DOC_DT(resultSet
						.getDate(3));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_ACC_YEAR(resultSet
						.getString(4));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DEP_LC_DEP_AMT(resultSet
						.getDouble(5));
			}
			if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_REASON_CODE() != null) {
				ArrayList<String> list = new DBProcedures()
						.P_VAL_CODES("REV_REASON", PT_IL_RECEIPT_TRANS_DTL_BEAN
								.getRTD_REASON_CODE(),
								PT_IL_RECEIPT_TRANS_DTL_BEAN
										.getUI_M_REASON_CODE_DESC(), "N", "E");
				if (list.isEmpty() && list != null) {
					PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_REASON_CODE_DESC(list
							.get(0));
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
			} catch (Exception e) {
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_RTD_DES_POL_NO(
			PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN,
			PILT032_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN = compositeAction
					.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN()
					.getPT_IL_RECEIPT_TRANS_HDR_BEAN();
			
			/*Commentted &Modified by saritha on 11-09-2017 for ssp call id ZBILQC-1718875*/ 
			
			/*String C1 = "SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_CUST_CODE IN(SELECT POL_CUST_CODE "
					+ "FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ?) "
					+ "AND   ((POL_DS_TYPE     =  ? AND  NVL(POL_CONVERT_YN,'N')  = ? ) OR   "
					+ " (POL_DS_TYPE      =  ? AND  NVL(POL_APPRV_STATUS,'N') = ?) "
					+ "AND NVL(POL_STATUS,'N') NOT IN ('S','P','D','M')) AND    "
					+ "POL_NO          !=  ? " + "AND    POL_NO           =  ?";*/
			/*Modified by ganesh on 08-05-2018 as suggested by gaurav for ZB requirement */
			/*String C1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?"
					+ "AND ((POL_DS_TYPE = '1' AND NVL(POL_CONVERT_YN, 'N') = 'N') OR POL_DS_TYPE = '2') "
					+ "AND  NVL(POL_STATUS, 'N')  NOT IN ('S', 'P', 'D', 'M', 'C')) AND POL_NO!= ? ";*/
			
			String C1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?"
					+ "AND ((POL_DS_TYPE = '1' AND NVL(POL_CONVERT_YN, 'N') = 'N') OR POL_DS_TYPE = '2') "
					+ "AND  NVL(POL_STATUS, 'N')  NOT IN ('S', 'P', 'D', 'M', 'C')) AND POL_NO!= ? "
					+ "UNION "
					+ "SELECT POL_SYS_ID FROM PT_IL_POLICY,PM_CUSTOMER "
					+ "WHERE POL_NO = CUST_CODE "
					+ "AND POL_SYS_ID = ? AND POL_NO = ?";
			
			if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_DES_POL_NO() != null) {
				resultSet = handler.executeSelectStatement(C1, connection,
						
						/*
						 * Modified by ganesh on 08-05-2018 as suggested by gaurav for ZB Requirement
						 * new Object[] {
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_SYS_ID(),
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO()});*/
						new Object[] {
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_SYS_ID(),
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO(),
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_SYS_ID(),
						compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO()});
				
								/*"1",
								"N",
								"2",
								"A",
								PT_IL_RECEIPT_TRANS_HDR_BEAN
										.getRTH_SRC_POL_NO(),
								PT_IL_RECEIPT_TRANS_DTL_BEAN
										.getRTD_DES_POL_NO()});*/
				
				if (resultSet.next()) {
					PT_IL_RECEIPT_TRANS_DTL_BEAN
							.setRTD_DES_POL_SYS_ID(resultSet.getLong(1));
				
				/*End*/	
					
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71153",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
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
			} catch (Exception e) {
			}
		}
	}
	
	public void WHEN_VALIDATE_ITEM_RTD_REASON_CODE(
			PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN)
			throws Exception {
		try {
			if (PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_REASON_CODE() != null) {

				ArrayList<String> list = new DBProcedures()
						.P_VAL_CODES("REV_REASON", PT_IL_RECEIPT_TRANS_DTL_BEAN
								.getRTD_REASON_CODE(),
								PT_IL_RECEIPT_TRANS_DTL_BEAN
										.getUI_M_REASON_CODE_DESC(), "N", "E",
								null);
				if (list.isEmpty() && list != null) {
					PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_REASON_CODE_DESC(list
							.get(0));
				}
			} else {
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_REASON_CODE_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	

}
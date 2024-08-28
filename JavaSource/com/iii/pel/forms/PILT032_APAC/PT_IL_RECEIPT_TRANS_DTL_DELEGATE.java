package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RECEIPT_TRANS_DTL_DELEGATE {
	public void executeSelectStatement(
			PILT032_APAC_COMPOSITE_ACTION PILT032_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		/*Modified by ganesh on 30-05-2018 to avoid record not displaying properly in datatable suggested by girish */
		/*String selectStatement = "SELECT ROWID, PT_IL_RECEIPT_TRANS_DTL.* FROM PT_IL_RECEIPT_TRANS_DTL"
				+ " WHERE PT_IL_RECEIPT_TRANS_DTL.RTD_RTH_SYS_ID = ? ";*/
		String selectStatement = "SELECT DEP_SYS_ID,DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT,PT_IL_RECEIPT_TRANS_DTL.ROWID ROWWID,PT_IL_RECEIPT_TRANS_DTL.* "
				+ "FROM PT_IL_RECEIPT_TRANS_DTL,PT_IL_DEPOSIT "
				+ "WHERE RTD_RTH_SYS_ID = ? AND  RTD_SRC_DEP_SYS_ID=DEP_SYS_ID";
		
		/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
		
		 String Remarkquery="SELECT  PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND  PC_CODE= ?";
		 ResultSet resultSet1=null;
		/*End*/
		 
		 
		Connection connection = null;
		ResultSet resultSet = null;
		PILT032_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN()
				.getDataList_PT_IL_RECEIPT_TRANS_DTL().clear();
		PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN = PILT032_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN()
				.getPT_IL_RECEIPT_TRANS_HDR_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler()
					.executeSelectStatement(selectStatement, connection,
							new Object[] {PT_IL_RECEIPT_TRANS_HDR_BEAN
									.getRTH_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN = new PT_IL_RECEIPT_TRANS_DTL();
				/*PT_IL_RECEIPT_TRANS_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));*/
				/*Modified by ganesh on 30-05-2018 to avoid record not displaying properly in datatable suggested by girish */
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setROWID(resultSet
						.getString("ROWWID"));
				/*end*/
				
				System.out.println("getROWID           "+PT_IL_RECEIPT_TRANS_DTL_BEAN.getROWID());
				
				
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_SYS_ID(resultSet
						.getLong("RTD_SYS_ID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_RTH_SYS_ID(resultSet
						.getLong("RTD_RTH_SYS_ID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_SRC_DEP_SYS_ID(resultSet
						.getLong("RTD_SRC_DEP_SYS_ID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DEP_LC_AMT(resultSet
						.getDouble("RTD_DEP_LC_AMT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN
						.setRTD_DEPOSIT_DEP_LC_AMT(resultSet
								.getDouble("RTD_DEPOSIT_DEP_LC_AMT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN
						.setRTD_DEPOSIT_OTH_LC_AMT(resultSet
								.getDouble("RTD_DEPOSIT_OTH_LC_AMT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DES_POL_SYS_ID(resultSet
						.getLong("RTD_DES_POL_SYS_ID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DES_POL_NO(resultSet
						.getString("RTD_DES_POL_NO"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_TRNS_YN(resultSet
						.getString("RTD_TRNS_YN"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DES_DEP_SYS_ID(resultSet
						.getLong("RTD_DES_DEP_SYS_ID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REASON_CODE(resultSet
						.getString("RTD_REASON_CODE"));
				
				/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
				
				System.out.println("getRTD_REASON_CODE  in delegate               "+PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_REASON_CODE());
				
				resultSet1=new CRUDHandler().executeSelectStatement(Remarkquery,connection , new Object[]{PT_IL_RECEIPT_TRANS_DTL_BEAN.getRTD_REASON_CODE()});
				if(resultSet1.next()){
					PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_REASON_CODE_DESC(resultSet1.getString("PC_DESC"));
				} 
				
				System.out.println("getUI_M_REASON_CODE_DESC  in delegate                "+PT_IL_RECEIPT_TRANS_DTL_BEAN.getUI_M_REASON_CODE_DESC());
				
				/*End*/
				
				
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REV_REMARKS(resultSet
						.getString("RTD_REV_REMARKS"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_TXN_CODE(resultSet
						.getString("RTD_TXN_CODE"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DOC_NO(resultSet
						.getString("RTD_DOC_NO"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_DOC_DT(resultSet
						.getDate("RTD_DOC_DT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_ACNT_YR(resultSet
						.getString("RTD_ACNT_YR"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_CR_UID(resultSet
						.getString("RTD_CR_UID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_CR_DT(resultSet
						.getDate("RTD_CR_DT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_UPD_UID(resultSet
						.getString("RTD_UPD_UID"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_UPD_DT(resultSet
						.getDate("RTD_UPD_DT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REV_TXN_CODE(resultSet
						.getString("RTD_REV_TXN_CODE"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REV_DOC_NO(resultSet
						.getString("RTD_REV_DOC_NO"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REV_DOC_DT(resultSet
						.getDate("RTD_REV_DOC_DT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_REV_ACNT_YR(resultSet
						.getString("RTD_REV_ACNT_YR"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setRTD_EXCESS_REFUND(resultSet
						.getString("RTD_EXCESS_REFUND"));

				/*Modified by ganesh on 30-05-2018 to avoid record not displaying properly in datatable suggested by girish */
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_RTD_TXN_CODE(resultSet
						.getString("DEP_TXN_CODE"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DOC_NO(resultSet
						.getString("DEP_DOC_NO"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DOC_DT(resultSet
						.getDate("DEP_DOC_DT"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_ACC_YEAR(resultSet
						.getString("DEP_ACNT_YEAR"));
				PT_IL_RECEIPT_TRANS_DTL_BEAN.setUI_M_DEP_LC_DEP_AMT(resultSet
						.getDouble("DEP_LC_DEP_AMT"));
				/*end*/
				PILT032_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN()
						.getDataList_PT_IL_RECEIPT_TRANS_DTL().add(
								PT_IL_RECEIPT_TRANS_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
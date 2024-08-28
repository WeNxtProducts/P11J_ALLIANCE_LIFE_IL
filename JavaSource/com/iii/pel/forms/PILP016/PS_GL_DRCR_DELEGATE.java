package com.iii.pel.forms.PILP016;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_GL_DRCR_DELEGATE {
	public void executeSelectStatement(
			PILP016_COMPOSITE_ACTION PGLP016_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PS_GL_DRCR.* FROM PS_GL_DRCR WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PS_GL_DRCR PS_GL_DRCR_BEAN = new PS_GL_DRCR();
			while (resultSet.next()) {
				PS_GL_DRCR_BEAN.setROWID(resultSet.getString("ROWID"));
				PS_GL_DRCR_BEAN.setDRCR_TXN_CODE(resultSet
						.getString("DRCR_TXN_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_DOC_NO(resultSet
						.getDouble("DRCR_DOC_NO"));
				PS_GL_DRCR_BEAN.setDRCR_SEQ_NO(resultSet
						.getDouble("DRCR_SEQ_NO"));
				PS_GL_DRCR_BEAN
						.setDRCR_DOC_DT(resultSet.getDate("DRCR_DOC_DT"));
				PS_GL_DRCR_BEAN.setDRCR_INT_DOC_NO(resultSet
						.getDouble("DRCR_INT_DOC_NO"));
				PS_GL_DRCR_BEAN.setDRCR_POL_SYS_ID(resultSet
						.getLong("DRCR_POL_SYS_ID"));
				PS_GL_DRCR_BEAN.setDRCR_POL_NO(resultSet
						.getString("DRCR_POL_NO"));
				PS_GL_DRCR_BEAN.setDRCR_END_NO_IDX(resultSet
						.getDouble("DRCR_END_NO_IDX"));
				PS_GL_DRCR_BEAN.setDRCR_END_NO(resultSet
						.getString("DRCR_END_NO"));
				PS_GL_DRCR_BEAN.setDRCR_CLAIM_NO(resultSet
						.getString("DRCR_CLAIM_NO"));
				PS_GL_DRCR_BEAN.setDRCR_CLM_SYS_ID(resultSet
						.getLong("DRCR_CLM_SYS_ID"));
				PS_GL_DRCR_BEAN.setDRCR_CUST_CODE(resultSet
						.getString("DRCR_CUST_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_MAIN_ACNT_CODE(resultSet
						.getString("DRCR_MAIN_ACNT_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_SUB_ACNT_CODE(resultSet
						.getString("DRCR_SUB_ACNT_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_DIVN_CODE(resultSet
						.getString("DRCR_DIVN_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_DEPT_CODE(resultSet
						.getString("DRCR_DEPT_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_ANLY_CODE_1(resultSet
						.getString("DRCR_ANLY_CODE_1"));
				PS_GL_DRCR_BEAN.setDRCR_ANLY_CODE_2(resultSet
						.getString("DRCR_ANLY_CODE_2"));
				PS_GL_DRCR_BEAN.setDRCR_ACTY_CODE_1(resultSet
						.getString("DRCR_ACTY_CODE_1"));
				PS_GL_DRCR_BEAN.setDRCR_ACTY_CODE_2(resultSet
						.getString("DRCR_ACTY_CODE_2"));
				PS_GL_DRCR_BEAN.setDRCR_INT_ENT_YN(resultSet
						.getString("DRCR_INT_ENT_YN"));
				PS_GL_DRCR_BEAN.setDRCR_DRCR_FLAG(resultSet
						.getString("DRCR_DRCR_FLAG"));
				PS_GL_DRCR_BEAN.setDRCR_CURR_CODE(resultSet
						.getString("DRCR_CURR_CODE"));
				PS_GL_DRCR_BEAN.setDRCR_FC_AMT(resultSet
						.getDouble("DRCR_FC_AMT"));
				PS_GL_DRCR_BEAN.setDRCR_LC_AMT(resultSet
						.getDouble("DRCR_LC_AMT"));
				PS_GL_DRCR_BEAN.setDRCR_CHQ_NO(resultSet
						.getString("DRCR_CHQ_NO"));
				PS_GL_DRCR_BEAN
						.setDRCR_CHQ_DT(resultSet.getDate("DRCR_CHQ_DT"));
				PS_GL_DRCR_BEAN.setDRCR_BANK_NAME(resultSet
						.getString("DRCR_BANK_NAME"));
				PS_GL_DRCR_BEAN.setDRCR_NARRATION(resultSet
						.getString("DRCR_NARRATION"));
				PS_GL_DRCR_BEAN.setDRCR_BL_NARRATION(resultSet
						.getString("DRCR_BL_NARRATION"));
				PS_GL_DRCR_BEAN.setDRCR_PRINT_YN(resultSet
						.getString("DRCR_PRINT_YN"));
				PS_GL_DRCR_BEAN.setDRCR_POST_YN(resultSet
						.getString("DRCR_POST_YN"));
				PS_GL_DRCR_BEAN.setDRCR_DOC_TYPE(resultSet
						.getString("DRCR_DOC_TYPE"));
				PS_GL_DRCR_BEAN.setDRCR_CR_UID(resultSet
						.getString("DRCR_CR_UID"));
				PS_GL_DRCR_BEAN.setDRCR_CR_DT(resultSet.getDate("DRCR_CR_DT"));
				PS_GL_DRCR_BEAN.setDRCR_REMARKS(resultSet
						.getString("DRCR_REMARKS"));
				PS_GL_DRCR_BEAN.setDRCR_SURPLUS_CONSIDER_YN(resultSet
						.getString("DRCR_SURPLUS_CONSIDER_YN"));
				PS_GL_DRCR_BEAN.setDRCR_QUOT_NO(resultSet
						.getString("DRCR_QUOT_NO"));
				PS_GL_DRCR_BEAN.setDRCR_QUOT_SYS_ID(resultSet
						.getLong("DRCR_QUOT_SYS_ID"));
				PS_GL_DRCR_BEAN.setDRCR_MATCH_STATUS(resultSet
						.getString("DRCR_MATCH_STATUS"));
				PS_GL_DRCR_BEAN.setDRCR_ACNT_YEAR(resultSet
						.getDouble("DRCR_ACNT_YEAR"));
				PS_GL_DRCR_BEAN
						.setDRCR_DUE_DT(resultSet.getDate("DRCR_DUE_DT"));
				PS_GL_DRCR_BEAN.setDRCR_PUH_SYS_ID(resultSet
						.getLong("DRCR_PUH_SYS_ID"));
				PS_GL_DRCR_BEAN.setDRCR_BANK_IN_SLIP_NO(resultSet
						.getString("DRCR_BANK_IN_SLIP_NO"));
				PS_GL_DRCR_BEAN.setDRCR_FLEX_01(resultSet
						.getString("DRCR_FLEX_01"));
				PS_GL_DRCR_BEAN.setDRCR_FLEX_02(resultSet
						.getString("DRCR_FLEX_02"));
				PS_GL_DRCR_BEAN.setDRCR_PAYOUT_TYPE(resultSet
						.getString("DRCR_PAYOUT_TYPE"));

			}
			PGLP016_COMPOSITE_ACTION_BEAN.getPS_GL_DRCR_ACTION_BEAN()
					.setPS_GL_DRCR_BEAN(PS_GL_DRCR_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	//added by krithika on 25-03-2016
	public ArrayList<SelectItem> TYPE_ITEM(String Polno) throws Exception{
		ArrayList<SelectItem> list = null;
		int i=0;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			/*query = "SELECT POLH_END_NO_IDX  FROM PH_IL_POLICY WHERE POLH_SYS_ID = ? "; commented by ameen  on 12.9.2016*/
			/*Added BY Ameen for ssp call id :  FALCONQC-1714579   ---- Start ----
			query = "SELECT POLH_END_NO_IDX  FROM PH_IL_POLICY WHERE POLH_SYS_ID = ? ORDER BY POLH_END_NO_IDX DESC";
			end*/
			/*Modified by Ram on 01/11/2016 for Endorsement Slip Report Issue*/
			query = "SELECT POLH_END_NO_IDX AS ENDIDX FROM PH_IL_POLICY WHERE POLH_SYS_ID = ? UNION "
					+ "SELECT POL_END_NO_IDX  AS ENDIDX  FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ORDER BY ENDIDX";
			
			/*end*/
			resultSet = handler.executeSelectStatement(query, connection, new Object[] { Polno,Polno});
			if(resultSet.next()==false)
			{
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(" ");
				selectItem.setValue(" ");
				selectItem.setLabel("0");
				selectItem.setValue("0");
				
				list.add(selectItem);
			}
			else
			{
			do{
		
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(1));
				list.add(selectItem);

				
			}while(resultSet.next());
			}
		
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
//end
}
package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_POL_INVEST_SUMMARY_DELEGATE {

	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		/*ADDED BY RAJA ON 15-07-2017 FOR ZBILQC-1731999*/
		/*String selectStatement = "SELECT ROWID, PS_IL_POL_INVEST_SUMMARY.* FROM PS_IL_POL_INVEST_SUMMARY WHERE PIS_POL_SYS_ID = ?";*/
		String selectStatement = "SELECT ROWID, PS_IL_POL_INVEST_SUMMARY.* FROM PS_IL_POL_INVEST_SUMMARY WHERE PIS_POL_SYS_ID = ? ORDER BY PIS_SR_NO";
		/*end*/
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN;
			while (resultSet.next()) {
				PS_IL_POL_INVEST_SUMMARY_BEAN = new PS_IL_POL_INVEST_SUMMARY();
				PS_IL_POL_INVEST_SUMMARY_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_SYS_ID(resultSet
						.getLong("PIS_SYS_ID"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_POL_SYS_ID(resultSet
						.getLong("PIS_POL_SYS_ID"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_PC_SYS_ID(resultSet
						.getLong("PIS_PC_SYS_ID"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_PCD_SYS_ID(resultSet
						.getLong("PIS_PCD_SYS_ID"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_SR_NO(resultSet
						.getInt("PIS_SR_NO"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_DT(resultSet
						.getDate("PIS_DT"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_FC_MOP_INVEST_AMT(resultSet
								.getDouble("PIS_FC_MOP_INVEST_AMT"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_LC_MOP_INVEST_AMT(resultSet
								.getDouble("PIS_LC_MOP_INVEST_AMT"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_FC_MOP_GROSS_CONTR(resultSet
								.getDouble("PIS_FC_MOP_GROSS_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_LC_MOP_GROSS_CONTR(resultSet
								.getDouble("PIS_LC_MOP_GROSS_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_MOP_NET_CONTR(resultSet
						.getDouble("PIS_FC_MOP_NET_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_MOP_NET_CONTR(resultSet
						.getDouble("PIS_LC_MOP_NET_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_OPBAL(resultSet
						.getDouble("PIS_FC_OPBAL"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_OPBAL(resultSet
						.getDouble("PIS_LC_OPBAL"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_TOTAL_CONTR(resultSet
						.getDouble("PIS_FC_TOTAL_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_TOTAL_CONTR(resultSet
						.getDouble("PIS_LC_TOTAL_CONTR"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_MOP_INTEREST(resultSet
						.getDouble("PIS_FC_MOP_INTEREST"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_MOP_INTEREST(resultSet
						.getDouble("PIS_LC_MOP_INTEREST"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_FC_OPBAL_INTEREST(resultSet
								.getDouble("PIS_FC_OPBAL_INTEREST"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_LC_OPBAL_INTEREST(resultSet
								.getDouble("PIS_LC_OPBAL_INTEREST"));
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_FC_TOTAL_INTEREST(resultSet
								.getDouble("PIS_FC_TOTAL_INTEREST"));
				
				PS_IL_POL_INVEST_SUMMARY_BEAN
						.setPIS_LC_TOTAL_INTEREST(resultSet
								.getDouble("PIS_LC_TOTAL_INTEREST"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_CLBAL(resultSet
						.getDouble("PIS_FC_CLBAL"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_CLBAL(resultSet
						.getDouble("PIS_LC_CLBAL"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_CURR_SA(resultSet
						.getDouble("PIS_FC_CURR_SA"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_CURR_SA(resultSet
						.getDouble("PIS_LC_CURR_SA"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FC_RISK_SA(resultSet
						.getDouble("PIS_FC_RISK_SA"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_LC_RISK_SA(resultSet
						.getDouble("PIS_LC_RISK_SA"));
				
				/*Added By Ameen on 26-05-2017 as per gaurav sugg.*/
				
				/*Modified by Janani on 12.01.2018 as per Gaurav sugges.*/
				
				/*PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_01(resultSet
				.getDouble("PIS_FLEX_01"));
		PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_02(resultSet
				.getDouble("PIS_FLEX_02"));*/
				if(resultSet.getDouble("PIS_FLEX_01") != 0 || resultSet.getDouble("PIS_FLEX_01") != 0)
				{
														
					PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_01(-resultSet
							.getDouble("PIS_FLEX_01"));
					PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_02(-resultSet
							.getDouble("PIS_FLEX_02"));
					
					PS_IL_POL_INVEST_SUMMARY_BEAN.setEvenrecord("withdrawalRecord");	
				}
				else if(resultSet.getDouble("PIS_FLEX_05") != 0)
				{
					PS_IL_POL_INVEST_SUMMARY_BEAN.setEvenrecord("topupRecord");	
				}
				else
				{
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_01(resultSet
						.getDouble("PIS_FLEX_01"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_02(resultSet
						.getDouble("PIS_FLEX_02"));
				
				/*ADDED BY RAJA ON 15-07-2017 FOR ZBILQC-1731999*/
				if(PS_IL_POL_INVEST_SUMMARY_BEAN.getPIS_SR_NO()!=null)
				{
					
					if(PS_IL_POL_INVEST_SUMMARY_BEAN.getPIS_SR_NO()%2==0)
					{
						if(PS_IL_POL_INVEST_SUMMARY_BEAN.getPIS_FC_TOTAL_INTEREST()>0)
						{
							PS_IL_POL_INVEST_SUMMARY_BEAN.setEvenrecord("evenrecord");
						}
					}
				}
				/*end*/
				
				}
				
				/*End of Janani on 12.01.2018 as per Gaurav sugges.*/
				/*End*/
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_03(resultSet
						.getDate("PIS_FLEX_03"));
				PS_IL_POL_INVEST_SUMMARY_BEAN.setPIS_FLEX_04(resultSet
						.getDate("PIS_FLEX_04"));
				/*End*/
				

				compositeAction.getPS_IL_POL_INVEST_SUMMARY_ACTION_BEAN()
						.getDataList_PS_IL_POL_INVEST_SUMMARY().add(
								PS_IL_POL_INVEST_SUMMARY_BEAN);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}

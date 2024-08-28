package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_FUNERAL_BENEFIT_MORE_DELEGATE {
	public void executeQuery(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	
		/*changed by raja for funeral benifit fsd*/
		/*	String selectStatement = "SELECT   PFMD_RELATION_TYPE, COUNT(PFMD_RELATION_TYPE) R_COUNT,"
				+ "SUM(PFMD_SA) SA_SUM, SUM(PFMD_PREMIUM) PRE_SUM, COUNT(PFMD_STATUS) STATUS_COUNT "
				+ "FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_POL_SYS_ID = ?	GROUP BY "
				+ "PFMD_RELATION_TYPE	ORDER BY 1";
*/
		
		String selectStatement = "SELECT   PFMD_RELATION_TYPE, COUNT(PFMD_RELATION_TYPE) R_COUNT,"
				+ "SUM(PFMD_SA) SA_SUM, SUM(PFMD_PREMIUM) PRE_SUM "
				+ "FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_POL_SYS_ID = ?	GROUP BY "
				+ "PFMD_RELATION_TYPE	ORDER BY 1";

		/*end*/
		
		/*changed by raja on 23-05-2017 for ZBILQC-1727275*/
		/*String relationshipQuery = "SELECT PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_PAR_MEMB' AND PS_CODE = ?";*/
		String relationshipQuery = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES "
				+ "WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
				+ "LIV_SYS_PARAM  = 'IL_PAR_MEMB' AND LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND "
				+ "LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' AND LIV_CODE=?";
		/*end*/

		String summeryQuery = " SELECT  COUNT(PFMD_RELATION_TYPE) R_COUNT,SUM(PFMD_SA) SA_SUM, SUM(PFMD_PREMIUM)"
				+ "PRE_SUM FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_POL_SYS_ID =?";
		/*added by raja for funeral benifit fsd*/
		String claimQuery="select COUNT(1) from pt_il_claim, PT_IL_POL_FUNERAL_MEMB_DTLS WHERE PFMD_POL_SYS_ID = ? "
				+ "AND CLAIM_POL_SYS_ID = PFMD_POL_SYS_ID AND PFMD_CUST_CODE = CLAIM_MEMB_CODE AND PFMD_RELATION_TYPE =?";
		/*end*/

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSetClaim=null;
		compositeAction.getDUMMY_FUNERAL_BENEFIT_MORE_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MORE_DTLS().clear();
		try {
			DUMMY_FUNERAL_BENEFIT_MORE_BEAN BEAN = new DUMMY_FUNERAL_BENEFIT_MORE_BEAN();
			connection = CommonUtils.getConnection();
			
			compositeAction.getDUMMY_FUNERAL_BENEFIT_MORE_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MORE_DTLS().clear();
			System.out.println("pol_ sys id =====>"+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });


			while (resultSet.next()) {
				DUMMY_FUNERAL_BENEFIT_MORE_BEAN BEAN1 = new DUMMY_FUNERAL_BENEFIT_MORE_BEAN();
				BEAN1.setDUMMY_CODE(resultSet
						.getString("PFMD_RELATION_TYPE"));
				BEAN1.setDUMMY_NO_LIVES(resultSet
						.getInt("R_COUNT"));
				BEAN1.setDUMMY_TOTAL_SA(resultSet
						.getLong("SA_SUM"));
				BEAN1.setDUMMY_TOTAL_PREMIUM(resultSet
						.getDouble("PRE_SUM"));
				/*commented by raja for funeral benifit fsd*/
				/*BEAN1.setDUMMY_CLAIM(resultSet
						.getInt("STATUS_COUNT"));*/

				System.out.println("dummy code ===> "+BEAN1.getDUMMY_CODE());
				resultSet1 = new CRUDHandler().executeSelectStatement(
						relationshipQuery, connection, new Object[] { BEAN1.getDUMMY_CODE()});
				while(resultSet1.next())
				{
					/*changed by raja on 23-05-2017 for ZBILQC-1727275*/
					/*BEAN1.setDUMMY_RELATIONSHIP(resultSet1.getString("PS_CODE_DESC"));*/
					BEAN1.setDUMMY_RELATIONSHIP(resultSet1.getString("LIV_CODE_DESC"));
					/*end*/
				}
				
				/*added by raja for funeral benifit fsd*/
				resultSetClaim = new CRUDHandler().executeSelectStatement(
						claimQuery, connection, new Object[] {compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),BEAN1.getDUMMY_CODE()});
				while(resultSetClaim.next())
				{
					BEAN1.setDUMMY_CLAIM(resultSetClaim.getInt(1));
				}
				/*end*/
				compositeAction.getDUMMY_FUNERAL_BENEFIT_MORE_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MORE_DTLS().add(BEAN1);

			}
			resultSet2 = new CRUDHandler().executeSelectStatement(
					summeryQuery, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
		while(resultSet2.next())
			{
				BEAN.setDUMMY_SUMMERY_COUNT(resultSet2.getInt("R_COUNT"));
				BEAN.setDUMMY_SUMMERY_SA(resultSet2.getDouble("SA_SUM"));
				BEAN.setDUMMY_SUMMERY_PREMIUM(resultSet2.getDouble("PRE_SUM") );
			}
			compositeAction.getDUMMY_FUNERAL_BENEFIT_MORE_ACTION_BEAN().
			setDUMMY_FUNERAL_BENEFIT_BEAN(BEAN);
			// }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);

		}
	}


}

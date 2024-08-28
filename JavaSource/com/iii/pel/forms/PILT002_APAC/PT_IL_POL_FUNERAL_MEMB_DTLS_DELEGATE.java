package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_FUNERAL_MEMB_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_FUNERAL_MEMB_DTLS.* FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE  PFMD_POL_SYS_ID  = ? ORDER BY PFMD_SYS_ID";
		Connection connection = null;
		ResultSet resultSet = null,resultSet1=null;
		String depDescQry = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DEP_TYP' AND PC_CODE = ?";
		ResultSet depDescRS = null;
		compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().clear();
		
		/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
		String relTypeDescQuery = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_PAR_MEMB' AND PC_CODE = ?";
		ResultSet relTypeDescRS = null;
		CRUDHandler relTypeDescCRUD = new CRUDHandler();
		/*end*/
		try {
			/*changed by raja for funeral benifit fsd*/
			boolean flag=false;
			/*end*/
			connection = CommonUtils.getConnection();
			compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS().clear();
			System.out.println("pol_ sys id =====>"+ compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			
			while (resultSet.next()) {
				/*changed by raja for funeral benifit fsd*/
				flag =true;
				/*end*/
				PT_IL_POL_FUNERAL_MEMB_DTLS PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = new PT_IL_POL_FUNERAL_MEMB_DTLS();
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SYS_ID(resultSet
						.getLong("PFMD_SYS_ID"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_POL_SYS_ID(resultSet
						.getLong("PFMD_POL_SYS_ID"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CUST_CODE(resultSet
						.getString("PFMD_CUST_CODE"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CUST_DESC(resultSet
						.getString("PFMD_CUST_DESC"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_DOB(resultSet
						.getDate("PFMD_MEMB_DOB"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_AGE(resultSet
						.getInt("PFMD_MEMB_AGE"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_RELATION_TYPE(resultSet
						.getString("PFMD_RELATION_TYPE"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SA(resultSet
						.getDouble("PFMD_SA"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREMIUM(resultSet
						.getDouble("PFMD_PREMIUM"));
				
				/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
				relTypeDescRS =  relTypeDescCRUD.executeSelectStatement(relTypeDescQuery, connection, 
						new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
				if(relTypeDescRS.next()){
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setUI_M_PFMD_RELATION_DESC(relTypeDescRS.getString("PC_DESC"));
				}
				/*end*/
				
				/*Newly Added By Dhinesh on 15-06-2017 for ssp call id  */
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setUI_M_PFMD_MEMB_DOB(CommonUtils.dateToStringFormat(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_DOB()));
				
				/*End*/
				
				
				/*aDDED BY SANKARA NARAYANAN FOR hOSPITAL CASH pLAN ON 25/04/2017*/
				String C2 ="SELECT PMEN_NO_OF_DAYS FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? AND PMEM_PLAN_CODE=? ";
				CRUDHandler handler = new CRUDHandler();
				ResultSet resultSet3 = null;
						resultSet3 = handler.executeSelectStatement(C2, CommonUtils.getConnection(),
							new Object[] {PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
					if (resultSet3.next()) {
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_NO_OF_DAYS( resultSet3.getInt("PMEN_NO_OF_DAYS"));
						
					} 
					/*END*/
				
				/*PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR(resultSet.getString("PFMD_CURR_ASSR"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_WOP(resultSet.getString("PFMD_WOP"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_STATUS(resultSet.getString("PFMD_STATUS"));*/
				
				/*aded by raja on 27-03-2017 for ZBILQC-1722140 */
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_AGE_PROOF_FLAG(resultSet.getString("PFMD_AGE_PROOF_FLAG"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_AGE_PROOF_OTHERS(resultSet.getString("PFMD_AGE_PROOF_OTHERS"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_HIV_TEST_YN(resultSet.getString("PFMD_HIV_TEST_YN"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_LC_THRESHOLD_LMT(resultSet.getDouble("PFMD_LC_THRESHOLD_LMT"));
				/*end*/
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR(resultSet.getString("PFMD_CURR_ASSR"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_WOP(resultSet.getString("PFMD_WOP"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_STATUS(resultSet.getString("PFMD_STATUS"));
				
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CURR_ASSR()!=null)
				{
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CURR_ASSR().equalsIgnoreCase("Y"))
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR_UI(true);
				}
				else
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CURR_ASSR_UI(false);
				}
				}
			
			if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_STATUS()!=null)
			{
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_STATUS().equalsIgnoreCase("Y"))
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_STATUS_UI(true);
				}
				else
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_STATUS_UI(false);
				}
			}
			
			if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_WOP()!=null)
					{
				if(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_WOP().equalsIgnoreCase("Y"))
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_WOP_UI(true);
				}
				else
				{
					PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_WOP_UI(false);
				}
					}
			/*	PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS1(resultSet.getString("PFMD_ADDRESS1"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS2(resultSet.getString("PFMD_ADDRESS2"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS3(resultSet.getString("PFMD_ADDRESS3"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CANTACT(resultSet.getString("PFMD_CANTACT"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PHONE(resultSet.getString("PFMD_PHONE"));*/
			
			String query="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
					+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
					+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
					+ "AND liv_code=?";	
		
			resultSet1=new CRUDHandler().executeSelectStatement(query, connection, 
					new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
			
			while(resultSet1.next())
			{
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_RELATION_DESC(resultSet1.getString("LIV_CODE_DESC"));
			}
			
			String querynondbfields="select * from pm_customer where cust_code=?";
			 ResultSet resultsetnondbfields=new CRUDHandler().executeSelectStatement(querynondbfields, 
					 CommonUtils.getConnection(), new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_CUST_CODE()});
			while(resultsetnondbfields.next())
			{
				
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS1(resultsetnondbfields.getString("CUST_ADDR1"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS2(resultsetnondbfields.getString("CUST_ADDR2"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_ADDRESS3(resultsetnondbfields.getString("CUST_ADDR3"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_CANTACT(resultsetnondbfields.getString("CUST_CONTACT"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PHONE(resultsetnondbfields.getString("CUST_PHONE"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setUI_M_NATIONAL_ID(resultsetnondbfields.getString("CUST_REF_ID1"));
			}

			/*added by gopi for showing description for relation type on 01/02/17*/
			/*
			 * modified by Ameen on 11-07-2017 for ZBILQC-1731204
			 * String query1="SELECT LIV_CODE_DESC,LIV_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'FUN_MEM_TYPE' AND LIV_CODE = ? ";	
		
			ResultSet resultSet2=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
					new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE()});
			
			while(resultSet2.next())
			{
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_TYPE(resultSet2.getString("LIV_CODE_DESC"));
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_TYPE_DESC(resultSet2.getString("LIV_DESC"));
			}*/
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_TYPE(resultSet.getString("PFMD_MEMB_TYPE"));
			depDescRS =  new CRUDHandler().executeSelectStatement(depDescQry, connection, 
					new Object[]{PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE()});
			if(depDescRS.next()){
				PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_MEMB_TYPE_DESC(depDescRS
						.getString("PC_DESC"));
			}
			/*END*/
			
			/*Added by sankara narayanan on 22/04/2017 for Hospital Cash  Plan */
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_GENDER(resultSet
					.getString("PFMD_GENDER"));
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_SMOKER_TEST_YN(resultSet
					.getString("PFMD_SMOKER_TEST_YN"));
			
			/*end*/
			
/*added by raja on 22-05-2017*/
			
			ArrayList<String> list3 = null;
			
			
			if (PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_GENDER() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM("CATG", PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.getPFMD_GENDER(), PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN
						.getUI_M_PFMD_GENDER_DESC(), "E",null);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setUI_M_PFMD_GENDER_DESC(list3.get(0));
					}
					
				}
			}
			/*end */
			/*added by raja on 17-05-2017*/
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_REC_TYPE(resultSet
					.getInt("PFMD_REC_TYPE"));
			
			/*end*/
			
			/*added by Ameen on 12-07-2017 for ZBILQC-1731216*/
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_BASIC_RATE(resultSet
					.getDouble("PFMD_BASIC_RATE"));
			
			/*end*/
			
			/*added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_FM_DT(resultSet.getDate("PFMD_EFF_FM_DT"));
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_EFF_TO_DT(resultSet.getDate("PFMD_EFF_TO_DT"));
			/*end*/
			/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREM_CALC_TYPE(resultSet.getString("PFMD_PREM_CALC_TYPE"));
			/*End*/
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().
				add(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDummy_dataList_PT_IL_POL_FUNERAL_MEMB_DTLS()
				.add(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
			}
			// }
			/*changed by raja for funeral benifit fsd*/
			if(flag ==false)
			{
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().
				getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setROWID(null);
			}
			/*end*/
			
			
			
			
			
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

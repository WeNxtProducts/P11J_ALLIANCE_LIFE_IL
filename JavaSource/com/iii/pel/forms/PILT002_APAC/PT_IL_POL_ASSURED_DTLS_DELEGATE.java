package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSURED_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("executeSelectStatement for PT_IL_POL_ASSURED_DTLS_HELPER class          "+compositeAction
				.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_ASSURED_DTLS.* FROM PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ?  AND POAD_TYPE = 'R'";

		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			// Default and relation is same
			 //if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getDEFAULT_WHERE()
			// != null){
			// selectStatement = selectStatement +
			// compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getDEFAULT_WHERE();
			
			compositeAction
			.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_CATG_CODE().setValid(false);
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = new PT_IL_POL_ASSURED_DTLS();
			while (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SYS_ID(resultSet.getLong("POAD_SYS_ID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_POL_SYS_ID(resultSet.getLong("POAD_POL_SYS_ID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SERIAL_NO(resultSet.getDouble("POAD_SERIAL_NO"));
				//commented by gopinath on 04-05-2016
				/*PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSR_CODE(resultSet.getString("POAD_ASSR_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSURED_NAME(resultSet.getString("POAD_ASSURED_NAME"));*/
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BIRTH_PLACE(resultSet.getString("POAD_BIRTH_PLACE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet.getDate("POAD_DOB"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet.getInt("POAD_AGE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(resultSet.getString("POAD_NATIONALITY"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_MAR_STATUS(resultSet.getString("POAD_MAR_STATUS"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(resultSet.getString("POAD_OCC_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATURE_OF_WORK(resultSet.getString("POAD_NATURE_OF_WORK"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEALTH_CODE(resultSet.getString("POAD_HEALTH_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(resultSet.getString("POAD_REMARKS"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CR_DT(resultSet.getDate("POAD_CR_DT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CR_UID(resultSet.getString("POAD_CR_UID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_UPD_DT(resultSet.getDate("POAD_UPD_DT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_UPD_UID(resultSet.getString("POAD_UPD_UID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SUM_ASSURED(resultSet.getDouble("POAD_FC_SUM_ASSURED"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SUM_ASSURED(resultSet.getDouble("POAD_LC_SUM_ASSURED"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_AMAN_PREM(resultSet.getDouble("POAD_FC_AMAN_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_PREM(resultSet.getDouble("POAD_LC_AMAN_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SENABEL_PREM(resultSet.getDouble("POAD_FC_SENABEL_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SENABEL_PREM(resultSet.getDouble("POAD_LC_SENABEL_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_AMAN_LOAD_PREM(resultSet.getDouble("POAD_FC_AMAN_LOAD_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_LOAD_PREM(resultSet.getDouble("POAD_LC_AMAN_LOAD_PREM"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(resultSet.getString("POAD_CATG_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEALTH_RATE(resultSet.getDouble("POAD_HEALTH_RATE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(resultSet.getDouble("POAD_HEIGHT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(resultSet.getDouble("POAD_WEIGHT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(resultSet.getInt("POAD_DISC_AGE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ADDL_RISK_CODE(resultSet.getString("POAD_ADDL_RISK_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG(resultSet.getString("POAD_AGE_PROOF_FLAG"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_OTHERS(resultSet.getString("POAD_AGE_PROOF_OTHERS"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(resultSet.getString("POAD_REF_ID1"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(resultSet.getString("POAD_REF_ID2"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CLASS(resultSet.getString("POAD_OCC_CLASS"));
				//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND((resultSet.getDouble("POAD_BMI")),2));
				//ADDED BY SARANYA on 31-03-2016 for BMI
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet.getDouble("POAD_BMI"));
				System.out.println("saranya  "+resultSet.getDouble("POAD_BMI") +","+CommonUtils.ROUND((resultSet.getDouble("POAD_BMI")),2));
				//END
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(resultSet.getString("POAD_RACE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_THRESHOLD_LMT(resultSet.getDouble("POAD_LC_THRESHOLD_LMT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ORG_LC_THRESHOLD_LMT(resultSet.getDouble("POAD_ORG_LC_THRESHOLD_LMT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RELIGION_CODE(resultSet.getString("POAD_RELIGION_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE(resultSet.getString("POAD_TYPE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT_UNIT(resultSet.getString("POAD_HEIGHT_UNIT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT_UNIT(resultSet.getString("POAD_WEIGHT_UNIT"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SALARY(resultSet.getDouble("POAD_FC_SALARY"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(resultSet.getDouble("POAD_LC_SALARY"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(resultSet.getString("POAD_SMOKE_YN"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(resultSet.getInt("POAD_NO_OF_CIGAR"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_POL_OWNER_YN(resultSet.getString("POAD_POL_OWNER_YN"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ALCHOHALIC_YN(resultSet.getString("POAD_ALCHOHALIC_YN"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ALCOHOL_QUAN(resultSet.getDouble("POAD_ALCOHOL_QUAN"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_ADMITTED(resultSet.getString("POAD_AGE_ADMITTED"));
				/*Added by Saritha on 09-12-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HIV_TEST_YN(resultSet.getString("POAD_HIV_TEST_YN"));
				/*End*/
				
				/*Added by Ram on 14/11/2016 for BP High & Low factor*/
				System.out.println("POAD_BPH     "+resultSet.getDouble("POAD_BPH")+"     POAD_BPL      "+resultSet.getDouble("POAD_BPL"));
				if(resultSet.getDouble("POAD_BPH") == 0.0)
				{
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPH(null);
				}
				else
				{
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPH(resultSet.getDouble("POAD_BPH"));
				}
				if(resultSet.getDouble("POAD_BPL") == 0.0)
				{
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPL(null);
				}
				else
				{
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPL(resultSet.getDouble("POAD_BPL"));
				}
				
				/*End*/
				
				/*Added by Ram on 09/12/2016 for Medical Info Tab*/
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_01(resultSet.getString("POAD_FLEX_01"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_02(resultSet.getString("POAD_FLEX_02"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_03(resultSet.getString("POAD_FLEX_03"));
				 
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_04(resultSet.getString("POAD_FLEX_04"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_05(resultSet.getString("POAD_FLEX_05"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_06(resultSet.getString("POAD_FLEX_06"));
				 /*Added by sivarajan on 30/10/2019 for sarwa IL*/
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_11(resultSet.getString("POAD_FLEX_11"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_12(resultSet.getString("POAD_FLEX_12"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_13(resultSet.getString("POAD_FLEX_13"));
				 
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_14(resultSet.getString("POAD_FLEX_14"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_15(resultSet.getString("POAD_FLEX_15"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FLEX_16(resultSet.getString("POAD_FLEX_16"));
				 
				 /*End*/
				 
				 /*End*/
				 /*Added by Ram on 21/01/2017 for Praganancy field capturing*/
				 System.out.println("resultSet.getString(POAD_PREGNENT_YN)        "+resultSet.getString("POAD_PREGNENT_YN"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_PREGNENT_YN(resultSet.getString("POAD_PREGNENT_YN"));
				 
				 compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().enablePraganacyField();
				 /*End*/
				 
				 
				 /*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
					
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FAMILY_YN(resultSet.getString("POAD_FAMILY_YN"));
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_YN(resultSet.getString("POAD_OCC_YN"));
				 
				 System.out.println("getPOAD_FAMILY_YN                          "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FAMILY_YN());
				 System.out.println("getPOAD_OCC_YN                          "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_YN());
				
				 /*End of FSD_FLA_IL_008*/
				 /*Added by Ameen on 12-04-2018 for KIC medical ocupation code*/
				 PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_MED_OCC_CLASS(resultSet.getString("POAD_MED_OCC_CLASS"));
				 if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_MED_OCC_CLASS() != null){
					 ResultSet medOccRS = new CRUDHandler().executeSelectStatement
							 ("SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE ='IL_MED_OCC' AND PC_CODE = ?", CommonUtils.getConnection(),
									 new Object[]{PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_MED_OCC_CLASS()});
					 if(medOccRS.next()){
						 PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_MED_OCC_CLASS_DESC(medOccRS.getString("PC_DESC"));
					 }
				 }
				 /*End*/

			}
			System.out.println(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FC_SUM_ASSURED());
			System.out.println("PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SUM_ASSURED()   : "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SUM_ASSURED());
			if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SUM_ASSURED() == null)
			{
				System.out.println("True");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SUM_ASSURED(
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED());
				System.out.println("False");
			}
			System.out.println(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SUM_ASSURED());
 System.out.println("PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT           "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT());
 System.out.println("PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT           "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT());
 
 
			compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.setPT_IL_POL_ASSURED_DTLS_BEAN(PT_IL_POL_ASSURED_DTLS_BEAN);
			// }
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}

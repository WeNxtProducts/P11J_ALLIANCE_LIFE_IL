package com.iii.pel.forms.PILT013;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SURR_MAT_VALUES_DELEGATE {
	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
			throws Exception {
		//added by saranya for ssp call_id FALCONQC-1715555  paidup issue
		PT_IL_POLICY pt_il_policy_bean = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		//modified,smv_sys_id added.. by gopi for ssp call id ZBLIFE-1465513
		String selectStatement = "SELECT ROWID, PT_IL_SURR_MAT_VALUES.* FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ? AND SMV_TYPE IN ('S','R','M','P','PM') ORDER BY SMV_SYS_ID ";
		//end
		Connection connection = null;
		ResultSet resultSet = null;
		PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getDataList_PT_IL_SURR_MAT_VALUES().clear();
		try {
			connection = CommonUtils.getConnection();
			//added by saranya for paidup issue
			String C6 = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_LOAN_INT_YN ='Y' WHERE SMV_POL_SYS_ID = ? AND SMV_TYPE IN ('S','R','M','P','PM')";
			new CRUDHandler().executeUpdateStatement(C6, connection, new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});
			connection.commit();
			connection.close();
			connection = CommonUtils.getConnection();
			
			/*String C7 = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_UNPAID_PREM_YN ='Y' WHERE SMV_POL_SYS_ID = ? AND SMV_TYPE IN ('S','R','M')";
			new CRUDHandler().executeUpdateStatement(C7, connection, new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});*/
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
				PT_IL_SURR_MAT_VALUES_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_SYS_ID(resultSet.getLong("SMV_SYS_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_POL_SYS_ID(resultSet.getLong("SMV_POL_SYS_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DATE(resultSet.getDate("SMV_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_RED_SA(resultSet.getDouble("SMV_FC_RED_SA"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA(resultSet.getDouble("SMV_LC_RED_SA"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT(resultSet.getDouble("SMV_FC_ACC_PROFIT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_ACC_PROFIT(resultSet.getDouble("SMV_LC_ACC_PROFIT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(resultSet.getDouble("SMV_FC_GROSS_VALUE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(resultSet.getDouble("SMV_LC_GROSS_VALUE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_UNPAID_PREM(resultSet.getDouble("SMV_FC_UNPAID_PREM"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_UNPAID_PREM(resultSet.getDouble("SMV_LC_UNPAID_PREM"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_BAL_LOAN(resultSet.getDouble("SMV_FC_BAL_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_BAL_LOAN(resultSet.getDouble("SMV_LC_BAL_LOAN"));
				System.out.println("resultSet.getDouble(SMV_FC_LOAN_INT)"+resultSet.getDouble("SMV_FC_LOAN_INT"));
				System.out.println("resultSet.getDouble(SMV_LC_LOAN_INT)"+resultSet.getDouble("SMV_LC_LOAN_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_LOAN_INT(resultSet.getDouble("SMV_FC_LOAN_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_LOAN_INT(resultSet.getDouble("SMV_LC_LOAN_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_TYPE(resultSet.getString("SMV_TYPE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DEL_FLAG(resultSet.getString("SMV_DEL_FLAG"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CR_DT(resultSet.getDate("SMV_CR_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CR_UID(resultSet.getString("SMV_CR_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_DT(resultSet.getDate("SMV_UPD_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_UID(resultSet.getString("SMV_UPD_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_NET_PAID_AMT(resultSet.getDouble("SMV_FC_NET_PAID_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAID_DT(resultSet.getDate("SMV_PAID_DT"));
				
				String SMV_FC_NET_PAID_AMT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_NET_PAID_AMT());
								
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_FC_NET_PAID_AMT(CommonUtils.Decimal_Convert(SMV_FC_NET_PAID_AMT));
				
				
				
				
				
				/*Modified by Janani on 24.07.2017.07.2017 for ZBILQC-1731896 */
				
				//PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_FLAG(resultSet.getString("SMV_APPRV_FLAG"));
				
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_FLAG(CommonUtils.nvl(resultSet.getString("SMV_APPRV_FLAG"), "N"));
				
				System.out.println("getSMV_APPRV_FLAG            "+PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG());
				
				/*End*/
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UNPAID_PREM_YN(resultSet.getString("SMV_UNPAID_PREM_YN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LOAN_INT_YN(resultSet.getString("SMV_LOAN_INT_YN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CHARGE_CODE(resultSet.getString("SMV_CHARGE_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_CHARGE_AMT(resultSet.getDouble("SMV_FC_CHARGE_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_CHARGE_AMT(resultSet.getDouble("SMV_LC_CHARGE_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REF_NO(resultSet.getString("SMV_REF_NO"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UNPAID_PREM_INT_CODE(resultSet.getString("SMV_UNPAID_PREM_INT_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_UNPAID_PREM_INT(resultSet.getDouble("SMV_FC_UNPAID_PREM_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_UNPAID_PREM_INT(resultSet.getDouble("SMV_LC_UNPAID_PREM_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_OS_LOAN(resultSet.getDouble("SMV_FC_OS_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_OS_LOAN(resultSet.getDouble("SMV_LC_OS_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LOAN_CODE(resultSet.getString("SMV_LOAN_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_RESERVE_FLAG(resultSet.getString("SMV_RESERVE_FLAG"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PREV_SCH_DATE(resultSet.getDate("SMV_PREV_SCH_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LETTER_DATE(resultSet.getDate("SMV_LETTER_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_TRAN_DATE(resultSet.getDate("SMV_TRAN_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REASON_CODE(resultSet.getString("SMV_REASON_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REMARKS(resultSet.getString("SMV_REMARKS"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT1(resultSet.getDouble("SMV_AMT1"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT2(resultSet.getDouble("SMV_AMT2"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT3(resultSet.getDouble("SMV_AMT3"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT4(resultSet.getDouble("SMV_AMT4"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT5(resultSet.getDouble("SMV_AMT5"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_STATUS_CODE(resultSet.getString("SMV_STATUS_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_UID(resultSet.getString("SMV_APPRV_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_DT(resultSet.getDate("SMV_APPRV_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DOC_ID(resultSet.getString("SMV_DOC_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYTO(resultSet.getString("SMV_PAYTO"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX01(resultSet.getString("SMV_FLEX01"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX02(resultSet.getString("SMV_FLEX02"));
				//PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX03(resultSet.getString("SMV_FLEX03"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX04(resultSet.getString("SMV_FLEX04"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX05(resultSet.getString("SMV_FLEX05"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(resultSet.getString("SMV_FLEX06"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_NET_PAID_AMT(resultSet.getDouble("SMV_LC_NET_PAID_AMT"));
				
				String SMV_FC_RED_SA=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA());
				String SMV_FC_ACC_PROFIT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
				String SMV_FC_GROSS_VALUE=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE());
				
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_SMV_FC_ACC_PROFIT(CommonUtils.Decimal_Convert(SMV_FC_ACC_PROFIT));
				
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_SMV_FC_GROSS_VALUE(CommonUtils.Decimal_Convert(SMV_FC_GROSS_VALUE));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_SMV_FC_RED_SA(CommonUtils.Decimal_Convert(SMV_FC_RED_SA));
				
				
				/*added by raja on 03-05-2017*/
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(resultSet.getString("SMV_FLEX07"));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(resultSet.getString("SMV_FLEX09"));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(resultSet.getString("SMV_FLEX08"));
				/*end*/
				
			
				/* Newly Added By Dhinesh on 17-7-2017 for ssp call id : ZBILQC-1720021 */
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_INT_VALUE(resultSet.getDouble("SMV_INT_VALUE"));
				/* End */
				
				/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
				if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement
							(sortCodeQry, connection,new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
					if(sortCodeRS.next()){
						PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(resultSet.getString("SMV_FLEX10"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(resultSet.getString("SMV_FLEX11"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX12(resultSet.getString("SMV_FLEX12"));
				/*End*/
				
				/*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
				
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYEE_NAME(resultSet.getString("SMV_PAYEE_NAME"));
				//added by gopi on 09/11/2022
				if(PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE() != null && PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE().equalsIgnoreCase("R")){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_STATUS_CODE("Cashback");
				}else if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE() != null && PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE().equalsIgnoreCase("PM")){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_STATUS_CODE("Partial Maturity");
				}else if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE() != null && PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE().equalsIgnoreCase("S")){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_STATUS_CODE("Surrender");
				}else if(PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE() != null && PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE().equalsIgnoreCase("M")){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_STATUS_CODE("Maturity");
				}else if(PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE() != null && PT_IL_SURR_MAT_VALUES_BEAN.
						getSMV_TYPE().equalsIgnoreCase("P")){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_STATUS_CODE("PaidUp");
				}
			
				/*Double cash_back_interest = PT_IL_SURR_MAT_VALUES_BEAN.getSMV_INT_VALUE();
				
				
					PT_IL_SURR_MAT_VALUES_BEAN
					.setUI_M_TOTAL_FC_AMT(CommonUtils.nvl(
							PT_IL_SURR_MAT_VALUES_BEAN
									.getSMV_FC_CHARGE_AMT(), 0)
							+ CommonUtils
									.nvl(PT_IL_SURR_MAT_VALUES_BEAN
											.getSMV_FC_OS_LOAN(), 0)
							+ CommonUtils
									.nvl(
											PT_IL_SURR_MAT_VALUES_BEAN
													.getSMV_FC_BAL_LOAN(),
											0)
							+ CommonUtils.nvl(
									PT_IL_SURR_MAT_VALUES_BEAN
											.getSMV_FC_UNPAID_PREM(), 0));
								
				System.out.println("****>> grossvalue " + PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE()+ "backinterest" + CommonUtils.nvl(cash_back_interest, 0.0)
						+ "UI_M_TOTAL_FC_AMT" + PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_TOTAL_FC_AMT() + "Cashback_amt" + PT_IL_SURR_MAT_VALUES_BEAN.getCashback_amt() );
				

				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT((CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE(),0) + CommonUtils.nvl(cash_back_interest, 0.0))- 
						CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_TOTAL_FC_AMT(),0) -CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getCashback_amt(),0));
				
				System.out.println("****UI_M_FC_NET_PAID_AMT******" + PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
*/				
				/*End*/
						
				PILT013_COMPOSITE_ACTION_BEAN
						.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getDataList_PT_IL_SURR_MAT_VALUES().add(
								PT_IL_SURR_MAT_VALUES_BEAN);
				
				
				
				if (PILT013_COMPOSITE_ACTION_BEAN
						.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getDataList_PT_IL_SURR_MAT_VALUES().size() > 0) {
					PILT013_COMPOSITE_ACTION_BEAN
					.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setPT_IL_SURR_MAT_VALUES_BEAN(PILT013_COMPOSITE_ACTION_BEAN
						.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getDataList_PT_IL_SURR_MAT_VALUES().get(0));
					
				}
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=0;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}

}

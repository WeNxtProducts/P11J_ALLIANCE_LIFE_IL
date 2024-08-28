package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILT013_PROCS_HELPER {

	CRUDHandler handler = new CRUDHandler();
	PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
	DBProcedures dbProcedure = new DBProcedures();

	public void L_CHECK_LIST_STATUS(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		// TODO Auto-generated method stub
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		String M_DUMMY = null;
		String C4 = " SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_SMV_SYS_ID=? "
				+ "AND DTLS_MANDATORY_YN='Y' AND NVL(DTLS_APPR_STS,'N')='N'";
		Connection con = null;
		ResultSet rs = null;
		try {
			con = CommonUtils.getConnection();
			if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
					|| "M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), "N")
						.equals("A")
						|| CommonUtils
								.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_STATUS_CODE(), "N")
								.equals("R")) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
							.setDisabled(true);
				} else {
					if("R".equalsIgnoreCase(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG())){
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
						.setDisabled(true);
					}else{
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
							.setDisabled(false);
					}
				}
				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), "N")
						.equals("R")
						|| CommonUtils
								.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_STATUS_CODE(), "N")
								.equals("A")) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
				} else {
					if (pt_il_surr_mat_values_bean.getSMV_FC_NET_PAID_AMT() != null) {
						if (!CommonUtils.nvl(
								pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
								"N").equals("A"))
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(false);
						else
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(true);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN()
								.getCOMP_M_BUT_APPROVE().setDisabled(true);
					}
				}

				rs = handler.executeSelectStatement(C4, con,
						new Object[] { pt_il_surr_mat_values_bean
								.getSMV_SYS_ID() });
				while (rs.next()) {
					M_DUMMY = rs.getString(1);
				}
				if (CommonUtils.nvl(M_DUMMY, "N").equals("X")) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void L_POP_SMV_PAID_AMT(PILT013_COMPOSITE_ACTION compositeAction,
			Object currValue) throws ProcedureException {

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();

		if (/*!CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
				"N").equals("A")
				&&*/ "S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

			
			/*Modified  by Janani on 28.06.2017 for ZBILQC-1724475*/
			
			/*if (currValue.equals("N"))*/ 
			
			if (currValue != null && currValue.equals("N")) 
			
			/*End*/	
				
				
			{
				if(pt_il_surr_mat_values_bean.getSMV_FC_LOAN_INT()>0 && pt_il_surr_mat_values_bean
						.getSMV_LC_LOAN_INT()>0){
				pt_il_surr_mat_values_bean.setSMV_FLEX01(CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_FC_LOAN_INT(), 0).toString());
				pt_il_surr_mat_values_bean.setSMV_FLEX02(CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_LC_LOAN_INT(), 0).toString());
				}
				
				pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(0.0);
				pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(0.0);
				
				/*Modified by Janani on 25.07.2017 ZBILQC-1731997*/
				
				/*pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_OS_LOAN(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_BAL_LOAN(), 0));*/
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)
						+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))				
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_OS_LOAN(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_BAL_LOAN(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getCashback_amt(), 0));
				
				/*End*/
				
				

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_LC_GROSS_VALUE(), 0)
						/*+ CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_UNPAID_PREM(), 0)*/- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_OS_LOAN(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_BAL_LOAN(), 0));
			} else {
				
				if(pt_il_surr_mat_values_bean.getSMV_FLEX01()!=null){
					
					/*commented by raja on 13-06-2017 for wrong to assign loan intrest to document no ZBILQC-1720738*/
					/*pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(Double.parseDouble(pt_il_surr_mat_values_bean.getSMV_FLEX01()));
					pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(Double.parseDouble(pt_il_surr_mat_values_bean.getSMV_FLEX02()));*/
					/*end*/
					
				}
				
				/*Modified by Janani on 25.07.2017 ZBILQC-1731997*/
				
				/*pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)-
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0));
																		
																		
																		
																		
						pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0));
																		
																		
																										*
																										*/
				
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)-
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0)
																		- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));
				
				
				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0)
																	- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));
				
				
				
				
				
				
				/*End*/

				

			}
			pt_il_surr_mat_values_bean
					.setSMV_FC_NET_PAID_AMT(pt_il_surr_mat_values_bean
							.getUI_M_FC_NET_PAID_AMT()
							- CommonUtils.nvl(pt_il_surr_mat_values_bean
									.getSMV_FC_CHARGE_AMT(), 0));
			pt_il_surr_mat_values_bean
					.setSMV_LC_NET_PAID_AMT(pt_il_surr_mat_values_bean
							.getUI_M_LC_NET_PAID_AMT()
							- CommonUtils.nvl(pt_il_surr_mat_values_bean
									.getSMV_LC_CHARGE_AMT(), 0));

			if (pt_il_surr_mat_values_bean.getSMV_LC_NET_PAID_AMT() < 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(0.0);
				pt_il_surr_mat_values_bean.setSMV_LC_NET_PAID_AMT(0.0);
			}

			ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(),  String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_FC_NET_PAID_AMT()), "R", null, null);
			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue().toString()));
			}
			outList.clear();
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_NET_PAID_AMT()), "R", null, null);
			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

		}else if (/*!CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
		"N").equals("A")
		&&*/ "M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
			
			/*Commentted & modified by saritha on 10-11-2017 Paid amount null values coming */
			
			//if (currValue.equals("N")) {
				if(currValue!=null && currValue.equals("N")) {
					
			/*End*/	
				
				pt_il_surr_mat_values_bean.setSMV_FLEX01(CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_FC_LOAN_INT(), 0).toString());
				pt_il_surr_mat_values_bean.setSMV_FLEX02(CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_LC_LOAN_INT(), 0).toString());
				
				/*
				 * 
				 * Commented By Dhinesh on 27.02.2017 SUGGESTED BY VINOTH
				 * 
				 * 
				 * pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(0.0);
				pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(0.0);
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_UNPAID_PREM(), 0));

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_LC_GROSS_VALUE(), 0)- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_UNPAID_PREM(), 0));*/
				
				/*NEWLY ADDED BY DHINESH ON 07-03-2017*/
				
			
				/*Modified by Janani on 25.07.2017 ZBILQC-1731997*/
				
				/*pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)
											- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0));

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										   - CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0));*/
				
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)
											- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0)
																		- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										   - CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0)
																		- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));
				
				
				/*End*/
				
				/* End */
				
				
			}else{
				
				if(pt_il_surr_mat_values_bean.getSMV_FLEX01()!=null){
					
					/*commented by raja on 13-06-2017 for wrong to assign loan intrest to document no ZBILQC-1720738*/
					
					/*pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(Double.parseDouble(pt_il_surr_mat_values_bean.getSMV_FLEX01()));
					pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(Double.parseDouble(pt_il_surr_mat_values_bean.getSMV_FLEX02()));*/
					
					/*end*/
				}
				
				
				/*Modified by Janani on 25.07.2017 ZBILQC-1731997*/
				
				
				/*pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0));

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0));*/
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_FC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_FC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_FC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_FC_LOAN_INT(), 0)
																		- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));

				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
								.getSMV_LC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_UNPAID_PREM(), 0)
										- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_UNPAID_PREM_INT(), 0)
												- CommonUtils.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(), 0)
														- CommonUtils.nvl(pt_il_surr_mat_values_bean
																.getSMV_LC_OS_LOAN(), 0)
																- CommonUtils.nvl(pt_il_surr_mat_values_bean
																		.getSMV_LC_LOAN_INT(), 0)
																		- CommonUtils.nvl(pt_il_surr_mat_values_bean
																				.getCashback_amt(), 0));
				
				
				/*End*/
				

			}
			
			
			pt_il_surr_mat_values_bean
			.setSMV_FC_NET_PAID_AMT(CommonUtils
					.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_FC_GROSS_VALUE(), 0));
	pt_il_surr_mat_values_bean
			.setSMV_LC_NET_PAID_AMT(CommonUtils
					.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_LC_GROSS_VALUE(), 0));

	if (pt_il_surr_mat_values_bean.getSMV_LC_NET_PAID_AMT() < 0) {
		pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(0.0);
		pt_il_surr_mat_values_bean.setSMV_LC_NET_PAID_AMT(0.0);
	}
			
	ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
			pt_il_policy_bean.getPOL_SA_CURR_CODE(),  String
			.valueOf(pt_il_surr_mat_values_bean
					.getSMV_FC_NET_PAID_AMT()), "R", null, null);
	if (outList != null && outList.size() > 0) {
		pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(Double
				.parseDouble(outList.get(0).getValue().toString()));
	}
	outList.clear();
	outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
			.getUI_M_BASE_CURR(), String
			.valueOf(pt_il_surr_mat_values_bean
					.getSMV_LC_NET_PAID_AMT()), "R", null, null);
	if (outList != null && outList.size() > 0) {
		pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(Double
				.parseDouble(outList.get(0).getValue()));
	}	
			
		}

	}

	public void L_CHECK_REPLACE_POLICY(PILT013_COMPOSITE_ACTION compositeAction) throws Exception{

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN();

		String M_POAD_REF_ID1	=null;
		String M_POAD_REF_ID2	=null;
		String M_NO_MONTH 		=null;
		Integer M_REP_COUNT		=null;
		String M_MON_DESC     	=null;
		String M_REP_DESC       =null;
		String M_REP_CODE       =null;
		Integer M_POL_COUNT     =null;  
		Integer M_ANS			=null;
		String M_COMM_CODE      =null;       
		String M_PROD_BCH_CODE  =null;
		  
		  String C1 ="SELECT DISTINCT POAD_REF_ID1, POAD_REF_ID2 FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND    POAD_TYPE       ='R'";
		          
		  String C2 ="SELECT COUNT(POL_SYS_ID) FROM   PT_IL_POLICY,  PT_IL_POL_ASSURED_DTLS " +
		  		"WHERE  POL_SYS_ID      = POAD_POL_SYS_ID " +
		  		"AND    POL_STATUS IN ('A','E') " +
		  		"AND    POL_DS_TYPE   =2 " +
		  		"AND   (POAD_REF_ID1   = ? OR POAD_REF_ID2 = ?) " +
		  		"AND   MONTHS_BETWEEN(POL_ISSUE_DT, SYSDATE )<= ? " +
		  		"AND   POL_SYS_ID    <> ? ";
		     
		  String C3 =" SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_REP_STAT'";
		     
		  String C4 ="SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE='IL_REP_COMM'";
		   
		  String C5 ="SELECT PROD_BCH_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE=(SELECT POL_PROD_CODE FROM   PT_IL_POLICY WHERE  POL_SYS_ID=?)";
		    
		  Connection con = null;
		  ResultSet rs1 = null;
		  ResultSet rs2 = null;
		  ResultSet rs3 = null;
		  ResultSet rs4 = null;
		  ResultSet rs5 = null;
		  
		try{
			con =CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con, new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});
			while(rs1.next()){
				M_POAD_REF_ID1 = rs1.getString(1);
				M_POAD_REF_ID2 = rs1.getString(2);
			}
			
			ArrayList<String> outList = dbProcedure.callP_VAL_SYSTEM(
					"IL_B21_MON", "IL_B21_MON", "E");
			if(outList!=null && outList.size()>0){
				M_MON_DESC = outList.get(0);
				M_NO_MONTH = outList.get(1);
			}
			outList.clear();
			outList = dbProcedure.callP_VAL_SYSTEM(
					"IL_REPL_POL", "IL_REPL_POL", "E");
			
			if(outList!=null && outList.size()>0){
				M_REP_DESC = outList.get(0);
				M_REP_COUNT = outList.get(1)!=null?Integer.parseInt(outList.get(1)):0;
			}
			
			rs2 = handler.executeSelectStatement(C2, con, new Object[]{M_POAD_REF_ID1,
																	   M_POAD_REF_ID2,
																	   M_NO_MONTH,
																	   pt_il_policy_bean.getPOL_SYS_ID()
																	   });
			while(rs2.next()){
				M_POL_COUNT = rs2.getInt(1);
			}
			
			rs3 = handler.executeSelectStatement(C3, con);
			while(rs3.next()){
				M_REP_CODE = rs3.getString(1);
			}
			
			rs4 = handler.executeSelectStatement(C4, con);
			while(rs4.next()){
				M_COMM_CODE = rs4.getString(1);
			}
			
			String query ="select NVL (LTRIM (RTRIM (REPLACE (?, '''', NULL))), '***') from dual";
			ResultSet rs = handler.executeSelectStatement(query, con, new Object[]{M_COMM_CODE});
			while(rs.next()){
				M_COMM_CODE = rs.getString(1);
			}
		  
			rs5 = handler.executeSelectStatement(C5, con,new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});
			while(rs5.next()){
				M_PROD_BCH_CODE = rs5.getString(1);
			}
			
//			if(M_POL_COUNT >M_REP_COUNT){
//		     SET_ALERT_PROPERTY('REPLACE_CONFIRM',ALERT_MESSAGE_TEXT,'This is a Replacement Policy case. Do you want to proceed?');
//		     M_ANS := SHOW_ALERT('REPLACE_CONFIRM');
		  
//		    IF M_ANS = ALERT_BUTTON1 THEN{ 
		       String updateQuery ="UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = ? WHERE  POL_SYS_ID = ?";
			   String updateQuery1 ="UPDATE PT_IL_POL_BROKER_HEAD SET    POBH_COMM_CODE =  ? WHERE  POBH_POL_SYS_ID = ?";
			   int row = handler.executeUpdateStatement(updateQuery, con, new Object[]{M_REP_CODE, pt_il_policy_bean.getPOL_SYS_ID()});
			   if(row>0){
				   System.out.println("Updated..PT_IL_POLICY table");
			   }
			   int row1 = handler.executeUpdateStatement(updateQuery1, con, new Object[]{M_COMM_CODE,pt_il_policy_bean.getPOL_SYS_ID()});
			   if(row1>0){
				   System.out.println("Updated..PT_IL_POL_BROKER_HEAD table");
			   }
//		}   
		    
//		}
		
		
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}
	finally{
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
			CommonUtils.closeCursor(rs3);
			CommonUtils.closeCursor(rs4);
			CommonUtils.closeCursor(rs5);
		}
	}
}

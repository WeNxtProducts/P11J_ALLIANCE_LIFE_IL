package com.iii.pel.forms.PILT013;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.pel.utils.PKG_PILT013;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY_HELPER {

	public void M_APPROVAL_DT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Date appr_date = (Date) currValue;
		try {
			if (appr_date == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Approval Date", "Entered !" }));
			}
			if (appr_date.after(new CommonUtils().getCurrentDate())) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] {
												"Approval Date",
												"<=",
												CommonUtils
														.dateToStringFormatter(new CommonUtils()
																.getCurrentDate()) }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction){
		
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
				DUMMY_BEAN.setSMV_APPRV_FLAG(
						compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
								.getPT_IL_SURR_MAT_VALUES_BEAN()
								.getSMV_APPRV_FLAG());
	}

	public void M_USE_POL_CUST_CODE_YN_WHEN_LIST_CHANGED(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {

			/*
			 * if("N".equals(dummy_bean.getUI_M_USE_POL_CUST_CODE_YN())){
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE',VISIBLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('DUMMY.M_LOV_CUST_CODE',VISIBLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE_DESC',VISIBLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('BP.B_M_CUST_CODE',VISIBLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE',ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('DUMMY.M_LOV_CUST_CODE',ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE_DESC',ENABLED,PROPERTY_TRUE);
			 * 
			 * }else {
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE',VISIBLE,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('DUMMY.M_LOV_CUST_CODE',VISIBLE,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE_DESC',VISIBLE,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('BP.B_M_CUST_CODE',VISIBLE,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE',ENABLED,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('DUMMY.M_LOV_CUST_CODE',ENABLED,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('DUMMY.M_CUST_CODE_DESC',ENABLED,PROPERTY_FALSE);
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void M_CUST_CODE_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		
		
		/*Added by Janani on 24.07.2017 for ZBILQC-1731997*/
		
		PT_IL_POLICY policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		/*End*/
		
		try {
			if ("N".equals(dummy_bean.getUI_M_USE_POL_CUST_CODE_YN())) {
				
				
				/*Modified by Janani on 24.07.2017 for ZBILQC-1731997*/
				
				/*ArrayList<String> outList = new PKG_PILT002_APAC()
						.PILT002_P_VAL_CLASS_CUST("CASH", dummy_bean
								.getUI_M_CUST_CODE(), "N", "E", "");*/
				
				System.out.println("getPOL_CUST_CODE           "+policy_bean
						.getPOL_CUST_CODE());
				
				ArrayList<String> outList = new PKG_PILT002_APAC()
				.PILT002_P_VAL_CLASS_CUST("CASH", policy_bean
						.getPOL_CUST_CODE(), "N", "E", "");
				/*End*/
				
				if (outList != null && outList.size() > 0) {
					dummy_bean.setUI_M_CUST_CODE_DESC(outList.get(0));
				}
				/*
				 * dbProcedure.P_VAL_CLASS_CUST('CASH', :DUMMY.M_CUST_CODE,
				 * :M_CUST_CODE_DESC, 'N', 'E', :CTRL.M_DIVN_CODE);
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String OK_BUTTON_PRESSED(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_SURR_CHRG pt_il_surr_chrg_bean = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN();
		Long GLOBAL_M_POL_SYS_ID = null;
		Long GLOBAL_M_CLM_SYS_ID = null;
		String CALL_FORM = null;
		String P_M_COMM_DEL = null;
		Long P_M_CLM_SYS_ID = null;
		String M_DS_POST_BO = null;
		String P_SUCCESS_MAT = null;
		String P_SUCCESS_PREM = null;
		String P_M_CUST_CODE = null;
		String P_SMV_TYPE = null;
		ArrayList<OracleParameter> outList = null;
		
		
		/*Added by Saritha on 22.03.2017 for ZB*/
		
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String product_code=null;
		Long pol_sys_id=null;
		String message = "";

		/*End*/
		
/*Added by Janani on 24.07.2017 for ZBILQC-1731997*/
		
		PT_IL_POLICY policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		System.out.println("getPOL_CUST_CODE           "+policy_bean
				.getPOL_CUST_CODE());
		
		/*End*/
		
		
		try {
			PKG_PILT013 pkg_pilt013 = new PKG_PILT013();
			outList = pkg_pilt013.M_BUT_OK(
					String.valueOf(pt_il_policy_bean.getPOL_SYS_ID()),
					pt_il_policy_bean.getPOL_NO(), 
					String.valueOf(CommonUtils.nvl(pt_il_surr_chrg_bean.getSRC_SUM_CHG(), 0)),
					String.valueOf(CommonUtils.nvl(pt_il_surr_chrg_bean.getSRC_CHG_SUM_FC(), 0)), 
					
					/*Added by Janani on 24.07.2017 for ZBILQC-1731997*/
					//dummy_bean.getUI_M_CUST_CODE(),
					policy_bean.getPOL_CUST_CODE(),
				
					/*ENd*/
					
					dummy_bean.getUI_M_ACNT_CODE(), 
					dummy_bean.getUI_M_USE_POL_CUST_CODE_YN(), 
					dummy_bean.getUI_M_PREM_GEN_YN(), 
					dummy_bean.getUI_M_BROK_GEN_YN(), 
					dummy_bean.getUI_M_BASE_CURR(), 
					CommonUtils.dateToStringFormatter(dummy_bean.getUI_M_APPROVAL_DT()), 
					String.valueOf(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")),
					String.valueOf(pt_il_surr_mat_values_bean.getSMV_SYS_ID()==null?"":pt_il_surr_mat_values_bean.getSMV_SYS_ID()),
					pt_il_surr_mat_values_bean.getSMV_TYPE(),
					pt_il_surr_mat_values_bean.getSMV_UNPAID_PREM_YN(),
					pt_il_policy_bean.getPOL_SA_CURR_CODE(), 
					dummy_bean.getUI_M_IL_RSRV_MAT(), 
					CommonUtils.dateToStringFormatter(pt_il_surr_mat_values_bean.getSMV_PAID_DT()),
					pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(), 
					String.valueOf(CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_FC_BAL_LOAN(),0)), 
					String.valueOf(CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_LC_BAL_LOAN(),0)), 
					String.valueOf(GLOBAL_M_POL_SYS_ID), 
					String.valueOf(GLOBAL_M_CLM_SYS_ID), 
					P_M_COMM_DEL, 
					String.valueOf(P_M_CLM_SYS_ID), 
					M_DS_POST_BO,
					P_SUCCESS_MAT, 
					P_SUCCESS_PREM);
			System.out.println("ok button   :");
		//	CommonUtils.objectSysout(outList);
			
			
			 /*outList =pkg_pilt013.M_BUT_OK(
					 String.valueOf(445),
					 pt_il_policy_bean.getPOL_NO(), 
					 String.valueOf(445),
					 String.valueOf(445), 
					 dummy_bean.getUI_M_CUST_CODE(),
					 dummy_bean.getUI_M_ACNT_CODE(),
					 dummy_bean.getUI_M_USE_POL_CUST_CODE_YN(),
					 dummy_bean.getUI_M_PREM_GEN_YN(),
					 dummy_bean.getUI_M_BROK_GEN_YN(), 
					 dummy_bean.getUI_M_BASE_CURR(),
					 CommonUtils.dateToStringFormatter(dummy_bean.getUI_M_APPROVAL_DT()),
					 String.valueOf(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")),
					 String.valueOf(44444), 
					 pt_il_surr_mat_values_bean.getSMV_TYPE(),
					 pt_il_surr_mat_values_bean.getSMV_UNPAID_PREM_YN(),
					 pt_il_policy_bean.getPOL_SA_CURR_CODE(),
					 dummy_bean.getUI_M_IL_RSRV_MAT(),
					 CommonUtils.dateToStringFormatter(pt_il_surr_mat_values_bean.getSMV_PAID_DT()),
					 pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
					 String.valueOf(0), 
					 String.valueOf(0),
					 String.valueOf(GLOBAL_M_POL_SYS_ID),
					 String.valueOf(GLOBAL_M_CLM_SYS_ID), 
					 P_M_COMM_DEL,
					 String.valueOf(P_M_CLM_SYS_ID), 
					 M_DS_POST_BO, 
					 P_SUCCESS_MAT,
					 P_SUCCESS_PREM);*/
			 

			if (outList != null && outList.size() > 0) {
				P_M_CUST_CODE = outList.get(0).getValue();
				
				P_SMV_TYPE = outList.get(1).getValue();
				
				GLOBAL_M_POL_SYS_ID = outList.get(2).getValue() != null ? Long
						.parseLong(outList.get(2).getValue()) : null;
				GLOBAL_M_CLM_SYS_ID = outList.get(3).getValue() != null ? Long
						.parseLong(outList.get(3).getValue()) : null;
				P_M_COMM_DEL = outList.get(4).getValue();
				P_M_CLM_SYS_ID = outList.get(5).getValue() != null ? Long
						.parseLong(outList.get(5).getValue()) : null;
				M_DS_POST_BO = outList.get(6).getValue();
				P_SUCCESS_MAT = outList.get(7).getValue();
				P_SUCCESS_PREM = outList.get(8).getValue();
			}
             System.out.println("M_DS_POST_BO  :"+M_DS_POST_BO);
		
             /*Added by saritha on 21-Mar-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
 			 email should be sent to finance user.*/ 
            System.out.println("pol no::::"+dummy_bean.getUI_M_POL_NO());
 			String C1 ="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
 			resultSet = handler.executeSelectStatement(C1, connection,
 					new Object[] {dummy_bean.getUI_M_POL_NO()});
 			while(resultSet.next()) {
 				product_code =resultSet.getString("POL_PROD_CODE");
 				pol_sys_id =resultSet.getLong("POL_SYS_ID");
 				System.out.println("product code::::"+product_code);
 				System.out.println("pol_sys_id--------------"+pol_sys_id);
 			}
 			
 			if ("M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){

 			String P_CUST_TYPE=" ";
 			String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"MAA",String.valueOf(pol_sys_id),"U","");
 			message = message + emailStatusMessage;
 			
 			}
 			
 			if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
 				String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"SUR",String.valueOf(pol_sys_id),"U","");
 				message = message + emailStatusMessage;
 			
 			}
 			
 			/*End*/
             
             
             if ("O".equals(M_DS_POST_BO)) {
				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", GLOBAL_M_POL_SYS_ID);
				CommonUtils.setGlobalVariable("GLOBAL.M_CLM_SYS_ID", String.valueOf(GLOBAL_M_CLM_SYS_ID));
				CALL_FORM = "PILP010";
				//CommonUtils.setGlobalVariable("CALLING_FORM",CALL_FORM);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
				return "PILT013_PT_IL_POLICY";
				
			}
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT013");

			/*
			 * if("Y".equals(P_SUCCESS_MAT) || "Y".equals(P_SUCCESS_PREM)) throw
			 * new
			 * Exception(Messages.getString(PELConstants.pelErrorMessagePath,
			 * "3083"));
			 */

			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SURR_OK_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		String P_M_COMM_DEL = null;
		try {
			PKG_PILT013 pkg_pilt013 = new PKG_PILT013();
			ArrayList<OracleParameter> outList = pkg_pilt013.M_BUT_SURR_OK(String.valueOf(pt_il_policy_bean.getPOL_SYS_ID()), 
																		   pt_il_policy_bean.getPOL_PROD_CODE(), 
																		   String.valueOf(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")), 
																		   pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), 
																		   dummy_bean.getSMV_APPRV_FLAG(), 
																		   dummy_bean.getUI_M_REASON_CODE(), 
																		   dummy_bean.getUI_M_REMARK(), 
																		   String.valueOf(pt_il_policy_bean.getPOL_END_NO_IDX()), 
																		   P_M_COMM_DEL);

			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
			if (outList != null && outList.size() > 0) {
                P_M_COMM_DEL = outList.get(0).getValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

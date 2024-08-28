package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILP002_APAC.COMPOSITE_ACTION_BEAN;
import com.iii.pel.utils.PKG_PILT013;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_HELPER {

	CRUDHandler handler = new CRUDHandler();
	DBProcedures dbProcedure = new DBProcedures();
	PILT013_PROCS_HELPER pilt013_procs_helper = new PILT013_PROCS_HELPER();

	public void PRE_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			if (CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID") != null) {
				pt_il_policy_bean.setPOL_SYS_ID(Long.parseLong((CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString())));
				System.out.println("AFTER CONVERT TO LONG   "+pt_il_policy_bean.getPOL_SYS_ID());
				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;

		}

	}

	public void POST_QUERY(PILT013_COMPOSITE_ACTION compositeAction)throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES maturityBean = compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_POL_CUST_CODE = null;
		String M_POL_CASH_YN = null;
		try {
			con = CommonUtils.getConnection();
			Double M_SURR_YRS = null;
			Object[] rsObj1 = new Object[1];
			rsObj1[0] = pt_il_policy_bean.getPOL_PLAN_CODE();

			rs1 = handler.executeSelectStatement(PILT013_QUERYCONSTANTS.POST_QUERY_CURSOR_QRY_1_1, con,rsObj1);
			while (rs1.next()) {
				M_SURR_YRS = rs1.getDouble(1);
			}

			Object[] rsObj2 = new Object[1];
			rsObj2[0] = pt_il_policy_bean.getPOL_NO();

			rs2 = handler.executeSelectStatement(PILT013_QUERYCONSTANTS.POST_QUERY_CURSOR_QRY_2,con, rsObj2);
			while (rs2.next()) {
				M_POL_CUST_CODE = rs2.getString(1);
				M_POL_CASH_YN = rs2.getString(2);
			}

			if ("Y".equals(M_POL_CASH_YN)) {
				dummy_bean.setUI_M_ACNT_CODE(M_POL_CUST_CODE);
				if (compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_ACNT_CODE().isDisabled()) {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_ACNT_CODE().setDisabled(false);
				}
			} else {
				dummy_bean.setUI_M_ACNT_CODE(M_POL_CUST_CODE);
				if (!compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_ACNT_CODE().isDisabled()) {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_ACNT_CODE().setDisabled(true);
				}
			}

			ArrayList<String> list = dbProcedure.callP_VAL_PLAN(pt_il_policy_bean.getPOL_PLAN_CODE(), "N", "E");
			if (list != null && list.size() > 0){
				pt_il_policy_bean.setUI_M_PLAN_DESC(list.get(0));
			}
			
			String Query="SELECT COVER_LONG_DESC FROM PM_IL_COVER, PM_IL_PLAN WHERE  COVER_CODE = PLAN_CODE AND  PLAN_CODE  = ? AND COVER_TYPE = 'B' ";
				
			ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{pt_il_policy_bean.getPOL_PLAN_CODE()});

			while(rs.next())
			{
				pt_il_policy_bean.setUI_M_PLAN_DESC(rs.getString("COVER_LONG_DESC"));
			}
			//Commented since the following codes are avilable in second block post query
			if (CommonUtils.nvl(maturityBean.getSMV_APPRV_FLAG(),"N").equals("A")) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
			} else {
				if (!"S".equals(maturityBean.getSMV_TYPE())) {
					if (!"A".equals(CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(), "N"))
							|| (!"R".equals(CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(), "N")))) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
					}
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
					if (CommonUtils.nvl(dummy_bean.getUI_M_IL_RSRV_MAT(), "9").equals("1")) {
						if (CommonUtils.nvl(maturityBean.getSMV_RESERVE_FLAG(), "N").equals("Y")) {
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setLabel("Reverse");
							if (!CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(), "N").equals("A")
									|| !CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(), "N").equals("R"))
								compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
						} else {
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setLabel("Reserve");
							compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
						}
					}
				} else {
					if (!CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(),"N").equals("A")
							|| !CommonUtils.nvl(maturityBean.getSMV_STATUS_CODE(), "N").equals("R")) {
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
					}
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
				}
			}
			/*--Added by Indraneel.K*/
		//commented by gopi on 09/11/2022
		/*	if ("S".equals(maturityBean.getSMV_TYPE())) {

				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_LABEL().setValue("Surrender Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Surrender Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Surrender Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_LABEL().setValue("Surrender Paid Dt");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Surrender Value");
				
				End
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Surrender Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Surrender Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Surrender Paid Date");
				
			} else if (("M").equals(maturityBean.getSMV_TYPE())) {

				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_LABEL().setValue("Maturity Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Maturity Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Maturity Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_LABEL().setValue("Maturity Paid Dt");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Maturity Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Maturity Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Maturity Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Maturity Paid Date");
				end
				
			}
			
else if (("P").equals(maturityBean.getSMV_TYPE())) {
				
				System.out.println("getSMV_TYPE               :"+maturityBean.getSMV_TYPE());
				
				
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_DATE_LABEL().setValue("PaidUp Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"PaidUp Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter PaidUp Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"PaidUp Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter PaidUp Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT_LABEL().setValue(
								"PaidUp Paid Date");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross PaidUp Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("PaidUp Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross PaidUp Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("PaidUp Paid Date");
			end
			}
			
			
else if (("R").equals(maturityBean.getSMV_TYPE()))
			{
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_LABEL().setValue("Cashback Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Cashback Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue("Cashback Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_LABEL().setValue("Cashback Paid Dt");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Cashback Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Cashback Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Cashback Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Cashback Paid Date");
			end
				
			}
*/			
			pilt013_procs_helper.L_CHECK_LIST_STATUS(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(con);
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
		}
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> POL_PLAN_CODE_KEY_LISTVAL(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		ArrayList<com.iii.premia.common.bean.LovBean> lovList = null;
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			// P_CALL_LOV('PT_IL_POLICY.POL_PLAN_CODE','B');
			lovList = itemUtil.P_CALL_LOV("PILT013", "PT_IL_POLICY",
					"POL_PLAN_CODE", "B", null, null, null, null,
					(String) currValue);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return lovList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> POL_STATUS_KEY_LISTVAL(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		ArrayList<com.iii.premia.common.bean.LovBean> lovList = null;
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			// P_CALL_LOV('PT_IL_POLICY.POL_NO');
			lovList = itemUtil.P_CALL_LOV("PILT013", "PT_IL_POLICY",
					"POL_STATUS", null, null, null, null, null,
					(String) currValue);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return lovList;
	}

	public void WHEN_NEW_RECORD_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_VALUE = null;
		String M_TYPE = null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES maturityBean = compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();

		try {
			if (policyBean.getPOL_NO() != null) {
				//Commented since  maturityBean is a second block
				
				if ("R".equals(maturityBean.getSMV_TYPE()))
					M_TYPE = "T";
				else
					M_TYPE = maturityBean.getSMV_TYPE();

				if ("S".equals(maturityBean.getSMV_TYPE())
						&& "R".equals(maturityBean
								.getSMV_STATUS_CODE())) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.setUI_B_SMV_FLAG("Rejected");
				} else {
					ArrayList<String> outList = dbProcedure.callP_VAL_SYSTEM(
							"IL_REC_STA", CommonUtils.nvl(M_TYPE, "X"), "N");
					if (outList != null && outList.size() > 0) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_POL_STATUS(outList.get(0));
						M_VALUE = outList.get(1);
					}
					
					/*added by raja on 13-06--2017 for ZBILQC-1727296*/
					/*if ("A".equals(maturityBean
							.getSMV_APPRV_FLAG())){
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.setUI_B_SMV_FLAG1("Approved");
					}else if("R".equals(maturityBean
							.getSMV_APPRV_FLAG())){
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.setUI_B_SMV_FLAG1("Rejected");
					}else{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.setUI_B_SMV_FLAG1("Not Approved");*/
					
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()!= null){
						String Query="select SMV_APPRV_FLAG from PT_IL_SURR_MAT_VALUES where smv_pol_sys_id=?";
						String Status=null;
						
						ResultSet rst=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(),new Object[]{
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						while(rst.next())
						{
							Status=rst.getString("SMV_APPRV_FLAG");
						}
						
						
						System.out.println("SMV_APPRV_FLAG in new record instance                   "+Status);
						
						
						/*Modified by Janani on 17.07.2017 for ZBILQC-1724475*/
						
						/*if (Status!=null && "A".equals(Status!=null)){
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.setUI_B_SMV_FLAG1("Approved");
				}else if(Status!=null && "R".equals(Status!=null)){
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.setUI_B_SMV_FLAG1("Rejected");
				}else{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.setUI_B_SMV_FLAG1("Not Approved");
				}*/
						/*added by gopi for ssp call id ZBLIFE-1465513 on 06/01/18*/
						//if (!"R".equals(maturityBean.getSMV_TYPE())){
						if (Status!=null && "A".equalsIgnoreCase(Status)){
							//MODIFIED BYGOPI FOR KIC MATURITY PROCESS AS SUGGESTED BY VIJAY SIR ON 19/03/2019
							/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.setUI_B_SMV_FLAG1("Approved");*/
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Approved");
						}else if(Status!=null && "R".equalsIgnoreCase(Status)){
							/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.setUI_B_SMV_FLAG1("Rejected");*/
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Rejected");
						}else{
							/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.setUI_B_SMV_FLAG1("Not Approved");*/
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Pending");
						}
						/*}else{
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setRendered(false);
						}*/
						/*End*/
						
						
						}
					/*end*/
				}
			
				if ("A".equals(CommonUtils.nvl(maturityBean
						.getSMV_STATUS_CODE(), "X"))
						|| "R".equals(CommonUtils
								.nvl(maturityBean
										.getSMV_STATUS_CODE(), "X"))) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
							.setDisabled(true);
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
							.setDisabled(false);
				}

				pilt013_procs_helper.L_CHECK_LIST_STATUS(compositeAction);

				if ("R".equals(CommonUtils.nvl(policyBean.getPOL_STATUS(), "N"))) {

					ArrayList<String> outList = dbProcedure.callP_VAL_SYSTEM(
							"IL_REC_STA", CommonUtils.nvl(compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getUI_B_POL_STATUS(), "N"), "N");
					if (outList != null && outList.size() > 0) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_POL_STATUS(outList.get(0));
						M_VALUE = outList.get(1);
					}
				}

				//Commented since  maturityBean is a second block
				
				/*if (CommonUtils.nvl(maturityBean
						.getSMV_FC_UNPAID_PREM(), 0) == 0) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(true);
				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(false);
				}
				if (CommonUtils.nvl(maturityBean
						.getSMV_FC_LOAN_INT(), 0) == 0) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);
				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(false);
				}

				if ("S".equals(maturityBean.getSMV_TYPE())) {

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_DATE_LABEL().setValue("Surr. Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Surr Amt");

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Surr Paid");

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_PAID_DT_LABEL().setValue(
									"Surr Paid Dt");
				} else if (("M").equals(maturityBean
						.getSMV_TYPE())) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_DATE_LABEL().setValue("Mat. Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Mat Amt");

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Mat Paid");

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_PAID_DT_LABEL()
							.setValue("Mat Paid Dt");
				}*/
				//added for checklist 
				if ("S".equals(maturityBean.getSMV_TYPE()))
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("8");
				else if ("M".equals(maturityBean.getSMV_TYPE())
						/*|| "R".equals(maturityBean.getSMV_TYPE())*/)
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("M");
				else if ("R".equals(maturityBean.getSMV_TYPE()))
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("R");
				else if ("P".equals(maturityBean.getSMV_TYPE()))
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("P");
				}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}

	public void ON_CHECK_DELETE_MASTER(PT_IL_POLICY pt_il_policy_bean)
			throws Exception {

		String Dummy_Define = null;
		String selectQuery = "SELECT 1 FROM PT_IL_SURR_MAT_VALUES P  WHERE P.SMV_POL_SYS_ID = ? ";
		Connection con = null;
		ResultSet rs = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs.next()) {
				Dummy_Define = rs.getString(1);
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_FORM(PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		
		dummy_bean.setUI_M_BASE_CURR(CommonUtils
				.getGlobalVariable("GLOBAL.M_BASE_CURR"));
		String selectQuery = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_RSRV_MAT'";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String amount = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con);
			if (rs.next()) {
				amount = rs.getString(1);
			}
			dummy_bean.setUI_M_IL_RSRV_MAT(amount);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_NEW_FORM_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction) {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		if (dummy_bean.getUI_M_SMV_STATUS_CODE() == null) {
			dummy_bean.setUI_M_SMV_STATUS_CODE("P");
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void M_BUT_REP_POLICY_WHEN_BUTTON_PRESSED(
			PT_IL_POLICY pt_il_policy_bean) throws Exception {
		String C1 = "SELECT POAD_REF_ID1, POAD_REF_ID2 FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND POAD_TYPE ='R'";
		String M_POAD_REF_ID1 = null;
		String M_POAD_REF_ID2 = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs.next()) {
				M_POAD_REF_ID1 = rs.getString(1);
				M_POAD_REF_ID2 = rs.getString(2);
			}

			CommonUtils.setGlobalVariable("GLOBAL.M_POAD_REF_ID1",
					M_POAD_REF_ID1);
			CommonUtils.setGlobalVariable("GLOBAL.M_POAD_REF_ID2",
					M_POAD_REF_ID2);
			CommonUtils.setGlobalVariable("GLOBAL.M_COMP_NAME", CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_NAME"));
			CommonUtils.setGlobalVariable("GLOBAL.M_SCR_NAME", CommonUtils
					.getGlobalVariable("CTRL.M_SCR_NAME"));
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_START_DATE",
					CommonUtils.dateToStringFormat(pt_il_policy_bean
							.getPOL_START_DT()));
			// CommonUtils.setGlobalVariable("CALLING_FORM", "PILT013");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}

	public void M_BUT_APPROVE_WHEN_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_SURR_MAT_VALUES maturityBean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		String C1 = "SELECT POL_CASH_YN FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ?";
		String C2 = " SELECT SMV_DATE FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_POL_SYS_ID = ?";
		String C3 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE ='SURR_YN' AND   ASD_USER_ID = ? "
				+ "AND  ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String C4 = "SELECT ASD_NUM_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE ='MAX_SURR_AMT' AND   ASD_USER_ID = ? AND ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String C4_MAT = "SELECT ASD_NUM_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE ='MAX_MAT_AMT' AND   ASD_USER_ID = ? AND ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String C0="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_MANDATORY_YN='Y' AND" 
				+" DTLS_APPR_STS ='N' AND DTLS_SMV_SYS_ID = ? AND DTLS_GROUP_CODE = ?";
		String c6 = "SELECT DTG_GROUP_CODE FROM PM_IL_DOC_TODO_GROUP WHERE DTG_DS_TYPE = ? ";
		String M_POL_CASH_YN = null;
		Date M_SMV_DATE = null;
		String M_CHAR_VALUE = null;
		Double M_ASD_NUM_VALUE = null;
		String M_CHAR_VALUE_MAT = null;
		Connection con = null;
		ResultSet rs0 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs6 = null;
		ResultSet rs4_MAT = null;
		String m_doc_group_code = null;
		ResultSet resultSet = null;
		String pol_status=null;
		try {
			con = CommonUtils.getConnection();
			rs6 = handler.executeSelectStatement(c6, con, new Object[]
			                             {compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().
					getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_TYPE()});
			if(rs6.next()){
				m_doc_group_code = rs6.getString(1);
			}
			//added to check checklist details were filled 
			
			rs0 = handler.executeSelectStatement(C0, con, new Object[] {
					maturityBean.getSMV_SYS_ID(),m_doc_group_code
					/*compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.getPT_IL_DOC_TODO_LIST_STATUS_BEAN()
							.getDTLS_GROUP_CODE() */});
			if (rs0.next()) {
				throw new Exception(
						"Mandatory Checklist verification is pending." );
			}
			
			//added ends 	
			rs3 = handler.executeSelectStatement(C3, con, new Object[] {
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
					pt_il_policy_bean.getPOL_PROD_CODE() });
			while (rs3.next()) {
				M_CHAR_VALUE = rs3.getString(1);
			}

			if (CommonUtils.nvl(M_CHAR_VALUE, "N").equals("N"))
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91569"));

			if ("S".equals(maturityBean.getSMV_TYPE())) {
				rs4 = handler.executeSelectStatement(C4, con, new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
						pt_il_policy_bean.getPOL_PROD_CODE() });
				while (rs4.next())
					M_ASD_NUM_VALUE = rs4.getDouble(1);

				if (maturityBean.getSMV_FC_NET_PAID_AMT() > CommonUtils
						.nvl(M_ASD_NUM_VALUE, 0))
					throw new Exception("Surrender Amount "+maturityBean.getSMV_FC_NET_PAID_AMT()+" exceeds User Limit "+M_ASD_NUM_VALUE);
			}
			//added to check maturity
			if ("M".equals(maturityBean.getSMV_TYPE())) {
				rs4_MAT = handler.executeSelectStatement(C4_MAT, con, new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
						pt_il_policy_bean.getPOL_PROD_CODE() });
				while (rs4_MAT.next())
					M_ASD_NUM_VALUE = rs4_MAT.getDouble(1);

				if (maturityBean.getSMV_FC_NET_PAID_AMT() > CommonUtils
						.nvl(M_ASD_NUM_VALUE, 0))
					throw new Exception("Maturity Amount "+maturityBean.getSMV_FC_NET_PAID_AMT()+" exceeds User Limit "+M_ASD_NUM_VALUE);
			}
			//added ends
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs1.next()) {
				M_POL_CASH_YN = rs1.getString(1);
			}

			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs2.next()) {
				M_SMV_DATE = rs2.getDate(1);
			}
			/*Commented by gopi for ssp call id ZBLIFE-1465513 on 09/01/18*/
			//pilt013_procs_helper.L_CHECK_REPLACE_POLICY(compositeAction);
			/*end*/
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CUST_CODE()
					.setRendered(false);
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_CUST_CODE_DESC().setRendered(false);
			// SET_ITEM_PROPERTY('BP.B_M_CUST_CODE',VISIBLE,PROPERTY_FALSE);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CUST_CODE()
					.setDisabled(true);
			// SET_ITEM_PROPERTY('DUMMY.M_LOV_CUST_CODE',ENABLED,PROPERTY_FALSE);
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_CUST_CODE_DESC().setDisabled(true);

			dummy_bean.setUI_M_USE_POL_CUST_CODE_YN("Y");

			if (CommonUtils.nvl(M_POL_CASH_YN, "N").equals("N")) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_USE_POL_CUST_CODE_YN().setDisabled(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_USE_POL_CUST_CODE_YN().setDisabled(false);
			}

			dummy_bean.setUI_M_BROK_GEN_YN("Y");
			dummy_bean.setUI_M_PREM_GEN_YN("Y");
			
			/*
			 * as per suggestion smv_apprv_date defaluted in sysdate modified by Dhinesh
			 * 
			 * dummy_bean.setUI_M_APPROVAL_DT(M_SMV_DATE);*/
			
			/*Newly modified by dhinesh on 7.3.2017*/
			
			dummy_bean.setUI_M_APPROVAL_DT(new CommonUtils().getCurrentDate());
			
			/*End*/
			
			dummy_bean.setUI_M_POL_NO(pt_il_policy_bean.getPOL_NO()); 
			/*Commentted by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.*/
			/*Uncommented by Pidugu raj dt: 11-10-2020 as suggested by kk to enable for Alliance IL*/
			if ("M".equals(maturityBean.getSMV_TYPE())) {

				emailTriggerProcCallMaturity();

			}
			
			if ("S".equals(maturityBean.getSMV_TYPE())) {

				emailTriggerProcCallSurrender();

			}
			
			/*End*/	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void M_BUT_RESERVE_WHEN_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES maturityBean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
				
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String M_COMM_DEL = null;
		Long GLOBAL_M_POL_SYS_ID = null;
		Connection connection = null;
		String P_M_BUT_RESERVE_ENBLD_YN = null;
		/*Modified by saranya for RM018T - DEV_IL_ZB Life_028-Cash Back on 27/02/2017*/
		/*String query = "SELECT 'X' FROM PM_IL_DOC_TODO_GROUP WHERE DTG_/-DS_TYPE = ?";*/
		String query ="SELECT  'X' FROM PT_IL_DOC_TODO_LIST_STATUS, PM_IL_DOC_TODO_GROUP"
				+ " WHERE DTLS_SMV_SYS_ID = ?  AND DTLS_GROUP_CODE = DTG_GROUP_CODE"
				+ " AND DTG_DS_TYPE = 'M' AND DTLS_MANDATORY_YN='Y' AND NVL(DTLS_APPR_STS,'N')= 'N'";

		ResultSet resultSet = null;
		// TODO Auto-generated method stub
		try {
			//added for doc checklist
			if (compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
					.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getROWID() == null) {
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(query,
						connection, new Object[] { maturityBean.getSMV_SYS_ID() });
				if (resultSet.next()) {
					throw new Exception("Verify the Document checklist");
				}
			}
		/*End*/
			//added ends 
			PKG_PILT013 pkg_pilt013 = new PKG_PILT013();
			ArrayList<OracleParameter> outList = pkg_pilt013.M_BUT_RESERVE(
					String.valueOf(pt_il_policy_bean.getPOL_SYS_ID()),
					pt_il_policy_bean.getPOL_NO(), maturityBean.getSMV_TYPE(),
					String.valueOf(maturityBean.getSMV_SYS_ID() == null ? ""
							: maturityBean.getSMV_SYS_ID()), 
					CommonUtils.dateToStringFormatter(
							dummy_bean.getUI_M_APPROVAL_DT()), 
					maturityBean.getSMV_RESERVE_FLAG(), 
					M_COMM_DEL, String.valueOf(GLOBAL_M_POL_SYS_ID),
					P_M_BUT_RESERVE_ENBLD_YN);
			if (outList != null && outList.size() > 0) {
				maturityBean.setSMV_RESERVE_FLAG(outList.get(0)
						.getValue());
				M_COMM_DEL = outList.get(1).getValue();
				GLOBAL_M_POL_SYS_ID = outList.get(2).getValue() != null ? Long
						.parseLong(outList.get(2).getValue().toString()) : null;
				P_M_BUT_RESERVE_ENBLD_YN = outList.get(3).getValue();
			}

			if (CommonUtils.nvl(
					maturityBean.getSMV_RESERVE_FLAG(), "X")
					.equals("Y"))
				/*
				 * Commented by Dhinesh on 10.3.2017
				 * 
				 * compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE()
				.setDisabled(true);*/
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Process Successfully Completed");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put("Current_1","Process Successfully Completed");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void loadcurrency() throws DBException, Exception{
		String base_currency = null;

		ArrayList<String> pValList = new ArrayList<String>();

		pValList = DBProcedures.P_VAL_FINAL_PARAMETER(CommonUtils.getConnection(),
				"BASE.CURR", "E");
		// ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
		if (pValList != null && pValList.size() > 0) {
			base_currency=pValList.get(0);
		}
		CommonUtils.setGlobalObject("CURRENCY", makeCurrDecimalglobal(base_currency));	

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********"    +CommonUtils.getGlobalObject("CURRENCY"));
	}


	public int makeCurrDecimalglobal(String currcode){

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
		System.out.println("currcode    : "+currcode);

		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";

		int CURR_DECI = 0;

		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { currcode });
			if (resultSet.next()) {
				CURR_DECI = resultSet.getInt("CURR_DECIMAL");
			}

			System.out.println("CURR_DECI    : "+CURR_DECI);
			CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
			System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CURR_DECI;
	} 
	
	/*Commented by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
	 email should be sent to finance user.
	 *
	 */
	/*Uncommented by Pidugu raj dt: 11-10-2020 as suggested by kk to enable for Alliance IL*/
	 public String emailTriggerProcCallMaturity() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'MAA'";
		   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
		   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		   	String out="N";
		   	ResultSet rs2=null;
		   	ResultSet rs3=null;
		   
		   	int seqno = 0;
		   	String productcode = null;
		   	String sub = null;
		   	String body = null;
		   	String mailid = null;
		   	Connection con=CommonUtils.getConnection();
		   	System.out.println("Connection :"+con);

		   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
		   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
		  
		   	if(rs2.next()){
		   		productcode=rs2.getString("PMT_PROD_CODE");
		   		sub=rs2.getString("PMT_MAIL_SUB");
		   		body=rs2.getString("PMT_MAIL_TEXT");
		   	}
		   	if(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"MAA",mailid,sub,body,"N" };
				   	new CRUDHandler().executeInsertStatement(insert, con, values1);
				   	con.commit();
		   			
		   		out="Y";
		   		}
		   	}
		   	System.out.println("seqno  :"+seqno);
		   	System.out.println("mailid  :"+mailid);
			System.out.println("sub  :"+sub);
			System.out.println("body  :"+body);
		   	
			return out;
			}

	 		/*End*/
	 
	 
	 /*Commented by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
	 email should be sent to finance user.
	 *
	 */
	/*Uncommented by Pidugu raj dt: 11-10-2020 as suggested by kk to enable for Alliance IL*/
	 public String emailTriggerProcCallSurrender() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'SUA'";
		   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
		   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		   	String out="N";
		   	ResultSet rs2=null;
		   	ResultSet rs3=null;
		   
		   	int seqno = 0;
		   	String productcode = null;
		   	String sub = null;
		   	String body = null;
		   	String mailid = null;
		   	Connection con=CommonUtils.getConnection();
		   	System.out.println("Connection :"+con);

		   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
		   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
		  
		   	if(rs2.next()){
		   		productcode=rs2.getString("PMT_PROD_CODE");
		   		sub=rs2.getString("PMT_MAIL_SUB");
		   		body=rs2.getString("PMT_MAIL_TEXT");
		   	}
		   	if(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"SUA",mailid,sub,body,"N" };
				   	new CRUDHandler().executeInsertStatement(insert, con, values1);
				   	con.commit();
		   			
		   		out="Y";
		   		}
		   	}
		   	System.out.println("seqno  :"+seqno);
		   	System.out.println("mailid  :"+mailid);
			System.out.println("sub  :"+sub);
			System.out.println("body  :"+body);
		   	
			return out;
			}

	 		/*End*/
}


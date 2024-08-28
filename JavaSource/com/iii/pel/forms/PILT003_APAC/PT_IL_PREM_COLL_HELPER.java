package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.richfaces.renderkit.html.iconimages.DisabledCalendarIcon;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.P9ILPK_CHEQ_VALIDATION;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PKG_PILT003_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PT_IL_PREM_COLL_HELPER {
	P9ILPK_PREM_COLL p9ilpk_prem_coll=new P9ILPK_PREM_COLL();

	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_PREM_COLL_DELEGATE()
					.executeSelectStatement(compositeAction);
			if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getDataList_PT_IL_PREM_COLL().size()>0){
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().setPT_IL_PREM_COLL_BEAN(
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getDataList_PT_IL_PREM_COLL().get(0));
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setRowSelected(true);
			} // Newly Added By Dhinesh on 16.3.2017
			else
			{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().setPT_IL_PREM_COLL_BEAN(new PT_IL_PREM_COLL());
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPOL_STS_FLAG(CommonUtils.getGlobalVariable("PREM_COLL.POL_STS"));


			} //End
	/*		Newly Added Below Else conditon by ram
			else
			{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().setPT_IL_PREM_COLL_BEAN(new PT_IL_PREM_COLL());
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPOL_STS_FLAG(CommonUtils.getGlobalVariable("PREM_COLL.POL_STS"));


			}
			
			End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_FORM(PILT003_APAC_COMPOSITE_ACTION compositeAction,
			DUMMY dummyBean) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_FILE = null;
		String M_TITLE = null;
		String M_DESC = null;
		String M_VALUE = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT PARA_VALUE FROM   FP_PARAMETER WHERE  PARA_ID = 'BASE.CURR'";

			String C2 = "SELECT DS_CURR_RATE_BS FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '2'"
					+ " AND    DS_FRZ_FLAG = 'N' AND    DS_CODE = ?";

			//  STD_PRE_FORM;
			if ("1".equals(CommonUtils.SUBSTR("GLOBAL.M_FOR_LANG_CODE", 4, 6))) {
				//SUBSTR(:GLOBAL.M_FOR_LANG_CODE,5,1) = '1' THEN
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(true);
				// SET_ITEM_PROPERTY('DUMMY.M_BUT_BROKER_DTLS',ENABLED,PROPERTY_FALSE);
			}
			// M_TITLE:= :CTRL.M_USER_ID ||'                 '||:CTRL.M_SCR_NAME||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');

			resultSet1 = handler.executeSelectStatement(C1, connection);
			if (resultSet1.next()) {
				dummyBean.setUI_M_BASE_CURR_CODE(resultSet1.getString(1));
			}

			// DEFAULT_VALUE (NULL, 'GLOBAL.M_POL_NO');
			// dummyBean.setPT_IL_POLICY_CF := 'N';
			//:DUMMY.PT_IL_LOAN_INT_COLL_CF := 'P';

			DBProcedures.P_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC", M_DESC,
					"E", dummyBean.getUI_M_IL_BROK_CALC());

			/*PCOPK_SYS_VARS.P_SET_PARA_VALUES(:GLOBAL.M_LANG_CODE,
			:GLOBAL.M_FOR_LANG_CODE,
			:GLOBAL.M_USER_ID,
			:CTRL.M_COMP_CODE,
			SUBSTR(:GLOBAL.M_DFLT_VALUES,4,6),
			SUBSTR(:GLOBAL.M_DFLT_VALUES,10,6),
			:CTRL.M_BASE_CURR,
			2,
			'PILT003');*/
			Object[] c2values = { CommonUtils.nvl(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARA_1"),"PILR050") };
			resultSet2 = handler.executeSelectStatement(C2, connection,
					c2values);
			if (resultSet2.next()) {
				dummyBean.setUI_M_BUY_SELL(resultSet2.getString(1));
			}

			/* EXCEPTION
			    WHEN OTHERS THEN
			    :GLOBAL.M_SUCC := 'N';
			    L_DISPLAY_ERROR_MESSAGE;
			    RAISE FORM_TRIGGER_FAILURE;
			 END;*/
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*public void WHEN_NEW_BLOCK_INSTANCE(){
		
	P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 


	IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
	   :SYSTEM.MESSAGE_LEVEL := '10';
	   :CTRL.M_COMM_DEL := 'P';
	   POST;
	   :CTRL.M_COMM_DEL := NULL;
	   :PT_IL_POLICY.POL_CUST_CURR_CODE := :PT_IL_POLICY.POL_CUST_CURR_CODE ;
	   :SYSTEM.MESSAGE_LEVEL := 0;
	   
	END IF;
	
	}*/

	public void postQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction,PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		
		//PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummybean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		
		System.out.println("PT_IL_PREM_COLL_ACTION.post_query()");
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet2A = null;
		ResultSet resultSet2B = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4A = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		int M_IL_RND_TYPE = 0;
		String M_PLAN_TYPE = null;
		int M_COUNT = 0;
		Double M_TOT = 0.0;
		int M_MON_1 = 0;
		int M_MON = 0;
		String M_POL_MODE_OF_PYMT = null;
		Double M_PC_LC_GROSS_PREM_1 = 0.0;
		Date M_POL_END_DT = null;
		Double M_PC_LC_GROSS_PREM = 0.0;
		Date M_PC_SCHD_PYMT_DT = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT  PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_RND_TYPE'";
			String C2 = "SELECT SUM(PC_LC_GROSS_PREM) FROM   PT_IL_PREM_COLL "
					+ "WHERE  PC_SCHD_PYMT_DT <= (SELECT POL_END_DT  FROM PT_IL_POLICY "
					+ "WHERE POL_SYS_ID=?) AND    "
					+ "PC_POL_SYS_ID = ? AND    PC_PAID_FLAG <> 'A' ";

			String C2A = "SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL "
					+ "WHERE PC_POL_SYS_ID=? AND PC_PAID_FLAG <> 'A'";

			String C2B = "SELECT TRUNC(MONTHS_BETWEEN(?,?))+1 FROM DUAL";

			String C3 = "SELECT PC_LC_GROSS_PREM FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    PC_PAID_FLAG <> 'A'AND   "
					+ " PC_SCHD_PYMT_DT <= (SELECT ADD_MONTHS(MIN(PC_SCHD_PYMT_DT),?)-1 FROM   "
					+ "PT_IL_PREM_COLL,PT_IL_POLICY WHERE  PC_PAID_FLAG <> 'A' AND    "
					+ "PC_POL_SYS_ID = ? AND    PC_SCHD_PYMT_DT<=POL_END_DT)";

			String C4A = "SELECT DECODE(?,'M',(6-?),'Q',(2-?),1)  FROM DUAL ";

			String C4 = "SELECT PLAN_TYPE,POL_MODE_OF_PYMT,POL_END_DT  FROM   PM_IL_PLAN,PT_IL_POLICY  "
					+ "WHERE  PLAN_CODE =POL_PLAN_CODE  AND POL_SYS_ID= ? ";

			String C5 = "SELECT PC_LC_GROSS_PREM FROM PT_IL_PREM_COLL WHERE "
					+ "PC_POL_SYS_ID = ? AND  PC_PAID_FLAG = 'A' AND  "
					+ "PC_SCHD_PYMT_DT < (SELECT POL_END_DT FROM PT_IL_POLICY WHERE "
					+ "POL_SYS_ID=?)  AND PC_SCHD_PYMT_DT >=  "
					+ "(SELECT MIN (B.PS_STATUS_DT)  FROM PT_IL_POL_STATUS B  WHERE "
					+ "PS_POL_SYS_ID = ?  AND PS_STATUS_TYPE = 'S' "
					+ "AND PS_STATUS = 'I06')";

			L_LOAN_APPBL(policyBean, PT_IL_PREM_COLL_BEAN, compositeAction);
			L_BROK_APPBL(policyBean, PT_IL_PREM_COLL_BEAN, dummybean,
					compositeAction);
			Object[] c2vaues = { policyBean.getPOL_SYS_ID(),
					policyBean.getPOL_SYS_ID() };
			resultSet2 = handler
					.executeSelectStatement(C2, connection, c2vaues);
			if (resultSet2.next()) {
				PT_IL_PREM_COLL_BEAN.setUI_M_PREM_TO_PAY(resultSet2
						.getDouble(1));
			}
			Object[] c4values = { policyBean.getPOL_SYS_ID() };
			resultSet4 = handler.executeSelectStatement(C4, connection,
					c4values);
			if (resultSet4.next()) {
				M_PLAN_TYPE = resultSet4.getString(1);
				M_POL_MODE_OF_PYMT = resultSet4.getString(2);
				M_POL_END_DT = resultSet4.getDate(3);
			}

			if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
				Object[] c2Avalues = { policyBean.getPOL_SYS_ID() };
				resultSet2A = handler.executeSelectStatement(C2A, connection,
						c2Avalues);
				if (resultSet2A.next()) {
					M_PC_SCHD_PYMT_DT = CommonUtils.sqlToUtilDate(resultSet2A.getDate(1));
				}
				Object[] c2values = {M_POL_END_DT,M_PC_SCHD_PYMT_DT};
				resultSet2B = handler.executeSelectStatement(C2B, connection,c2values);
				if (resultSet2B.next()) {
					M_MON_1 = resultSet2B.getInt(1);
				}

				if (M_MON_1 < 6) {
					M_MON_1 = M_MON_1;
				} else {
					M_MON_1 = 6;
				}

				M_TOT = 0.0;
				M_COUNT = 0;
				Object[] c3values = { policyBean.getPOL_SYS_ID(),M_MON_1,
						policyBean.getPOL_SYS_ID() };
				resultSet3 = handler.executeSelectStatement(C3, connection,
						c3values);
				if (resultSet3.next()) {
					M_PC_LC_GROSS_PREM = resultSet3.getDouble(1);
				} else {
					M_TOT = M_PC_LC_GROSS_PREM + M_TOT;
					M_COUNT = M_COUNT + 1;
				}
				Object[] c4Avalues = {M_POL_MODE_OF_PYMT,M_COUNT,M_COUNT};
				resultSet4A = handler.executeSelectStatement(C4A, connection,c4Avalues);
				if (resultSet4A.next()) {
					M_MON = resultSet4A.getInt(1);
				}
				Object[] c5values = {policyBean.getPOL_SYS_ID(),policyBean.getPOL_SYS_ID(),
						policyBean.getPOL_SYS_ID() };
				resultSet5 = handler.executeSelectStatement(C5, connection,
						c5values);
				if (resultSet5.next()) {
					M_PC_LC_GROSS_PREM_1 = resultSet5.getDouble(1);
				}
				if (M_MON_1 >= 6) {
					PT_IL_PREM_COLL_BEAN.setUI_M_PREM_AMT(M_TOT
							+ M_PC_LC_GROSS_PREM * M_MON);
				} else {
					PT_IL_PREM_COLL_BEAN.setUI_M_PREM_AMT(M_TOT);
				}
				PT_IL_PREM_COLL_BEAN.setUI_M_PREM_AMT(PT_IL_PREM_COLL_BEAN
						.getUI_M_PREM_AMT()
						- CommonUtils.nvl(M_PC_LC_GROSS_PREM_1, 0));
			    }
			if(PT_IL_PREM_COLL_BEAN.getUI_M_PREM_AMT()!=null){
				PT_IL_PREM_COLL_BEAN.setUI_M_PREM_FC_AMT(PT_IL_PREM_COLL_BEAN.getUI_M_PREM_AMT() / compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_EXCH_RATE());
			}
			if(PT_IL_PREM_COLL_BEAN.getUI_M_PREM_TO_PAY()!=null){
				PT_IL_PREM_COLL_BEAN.setUI_M_PREM_FC_TO_PAY(PT_IL_PREM_COLL_BEAN.getUI_M_PREM_TO_PAY() / compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_EXCH_RATE());
			}

			if (!("R".equalsIgnoreCase(policyBean.getPOL_STATUS()))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_TO_PAY().setRendered(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_TO_PAY().setRendered(false);
				//SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT',VISIBLE,PROPERTY_FALSE); 
			}
			if (("U".equals(M_PLAN_TYPE))
					|| (!("R".equalsIgnoreCase(policyBean.getPOL_STATUS())))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_AMT().setRendered(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_AMT().setRendered(false);
				// SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT_1',VISIBLE,PROPERTY_FALSE); 
			}
			//P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE );   

			/*Modified by Ram on 02/02/2017 for Waive Process calculation*/
			/*PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
					+ CommonUtils
							.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
					+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
							.getPC_FC_UNPAID_PREM_INT(), 0),2));

			PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
					+ CommonUtils
							.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
					+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT(), 0),2));*/


			System.out.println("PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN() in postQuery     "+PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN());
			if(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN() != null && PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN().equals("N"))
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0),2));

				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0),2));

			}
			else
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_WAIVE_PREM_INT(), 0))),2));

				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_WAIVE_PREM_INT(), 0))),2));
			}
			/*End*/
			
			/*Newly Added By Ram on 10.3.2017*/
			System.out.println("PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN() in postQuery     "+PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN());
			if(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN() != null && PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN().equals("N"))
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0),2));

				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0),2));

			}
			else
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_WAIVE_PREM_INT(), 0))),2));

				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_WAIVE_PREM_INT(), 0))),2));
			}
			/*End*/
			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getUI_M_FC_NET_PREM(), "R", null);

			new DBProcedures().P_VAL_ROUND_AMT(dummybean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getUI_M_LC_NET_PREM(), "R", null);
			resultSet1 = handler.executeSelectStatement(C1, connection);
			if (resultSet1.next()) {
				M_IL_RND_TYPE = resultSet1.getInt(1);
			}

			if (M_IL_RND_TYPE == 1) {
				// PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(Math.round(PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM()));//(Math.round(PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM());
				//PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(Math.rint(PT_IL_PREM_COLL_BEAN.getUI_M_LC_NET_PREM());
			}
			new DBProcedures().P_VAL_CODES("IL_PRM_INT", PT_IL_PREM_COLL_BEAN
					.getPC_UNPAID_PREM_INT_CODE(), PT_IL_PREM_COLL_BEAN
					.getUI_M_CODE_DESC(), "N", "N", null);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2A);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2B);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet4A);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}
	
	/**
	 * 
	 * @param policyBean
	 * @param PT_IL_PREM_COLL_BEAN
	 * @param compositeAction
	 * @throws Exception
	 */
	public void L_LOAN_APPBL(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN,
			PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Long M_LOAN_SYS_ID = 0L;
		Double M_LC_LOAN_INT_AMT = 0.0;
		Double M_FC_LOAN_INT_AMT = 0.0;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT LOAN_SYS_ID FROM   PT_IL_LOAN WHERE  "
					+ "LOAN_POL_SYS_ID  =  ? AND LOAN_STATUS != 'N' ";

			String C2 = "SELECT LIC_LC_INT_AMT,LIC_FC_INT_AMT FROM   PT_IL_LOAN_INT_COLL WHERE  "
					+ "LIC_PC_SYS_ID   = ?";

			Object[] c1values = { policyBean.getPOL_SYS_ID() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					c1values);
			if (resultSet1.next()) {
				M_LOAN_SYS_ID = resultSet1.getLong(1);

			}
			if (M_LOAN_SYS_ID != 0L) {
				Object[] c2values = { PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet2 = handler.executeSelectStatement(C2, connection,
						c2values);
				if (resultSet2.next()) {
					M_LC_LOAN_INT_AMT = resultSet2.getDouble(1);
					M_FC_LOAN_INT_AMT = resultSet2.getDouble(1);
					PT_IL_PREM_COLL_BEAN.setUI_M_LC_LOAN_INT(M_LC_LOAN_INT_AMT);
					PT_IL_PREM_COLL_BEAN.setUI_M_FC_LOAN_INT(M_FC_LOAN_INT_AMT);
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_LOAN_INT().setDisabled(false);
				} else {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_LOAN_INT().setDisabled(true);
				}

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LOAN_INT().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LOAN_IN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_LOAN_INT().setDisabled(true);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

	}
	
	/**
	 * 
	 * @param policyBean
	 * @param PT_IL_PREM_COLL_BEAN
	 * @param dummyBean
	 * @param compositeAction
	 * @throws Exception
	 */
	public void L_BROK_APPBL(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean,
			PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Long M_POL_SYS_ID = 0L;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT BV_POL_SYS_ID FROM   PT_IL_BROKER_VALUES WHERE BV_POL_SYS_ID = ? AND BV_PC_SYS_ID  = ?";

			String C2 = "SELECT ACV_POL_SYS_ID FROM   PT_AGENT_COMM_VALUES WHERE  "
					+ "ACV_POL_SYS_ID = ? AND   " + " ACV_PC_SYS_ID  = ?";

			if ("1".equals(CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(),
					"1"))) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet1 = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet1.next()) {
					M_POL_SYS_ID = resultSet1.getLong(1);
				}

				else if ("2".equals(CommonUtils.nvl(dummyBean
						.getUI_M_IL_BROK_CALC(), "1"))) {
					Object[] c2values = { policyBean.getPOL_SYS_ID(),
							PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
					resultSet2 = handler.executeSelectStatement(C2, connection,
							c2values);
					if (resultSet2.next()) {
						M_POL_SYS_ID = resultSet2.getLong(1);
					}
				}
			}
			 if(M_POL_SYS_ID != null){
			   compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(false); 
			 }else{
				 compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(true);
			 }
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void whenNewRecordInstance(
			PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Long M_PC_SYS_ID = 0L;
		String M_POL_CUST_CURR_CODE = null;
		String M_ASD_CHAR_VALUE = null;
		String M_PC_PAID_FLAG = null;
		String M_DUMMY = null;
		Date M_PC_SCHD_PYMT_DT = null;
		String M_PLAN_TYPE = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
			PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			
			connection = CommonUtils.getConnection();
			String C1 = "SELECT MAX(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_SCHD_PYMT_DT < ?";

			String C2 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    "
					+ "PC_SCHD_PYMT_DT > ?";

			String C3 = "SELECT NVL(PC_PAID_FLAG,'N') FROM   PT_IL_PREM_COLL WHERE "
					+ " PC_POL_SYS_ID = ? AND    "
					+ "PC_SCHD_PYMT_DT = ? AND    PC_PREM_TYPE <> 'A'";

			String C4 = "SELECT POL_CUST_CURR_CODE FROM   PT_IL_POLICY WHERE  "
					+ "POL_SYS_ID = ?";

			String C5 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  "
					+ "PLAN_CODE = :PT_IL_POLICY.POL_PLAN_CODE AND    PLAN_FRZ_FLAG = 'N'";

			String C5A = "SELECT  ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE   "
					+ "ASD_USER_ID = ? AND "
					+ "ASD_CODE    = 'FAC_YN' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

			if ("N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(true);
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(false);
				//SET_ITEM_PROPERTY('DUMMY.M_BUT_PYMT_DTLS', ENABLED, PROPERTY_TRUE);
			}
			Object[] c4values = { policyBean.getPOL_SYS_ID() };
			resultSet4 = handler.executeSelectStatement(C4, connection,
					c4values);
			if (resultSet4.next()) {
				M_POL_CUST_CURR_CODE = resultSet4.getString(1);
			}

			if (CommonUtils.isIN(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"), "A", "Y")) {
				L_LOAN_APPBL(policyBean, PT_IL_PREM_COLL_BEAN, compositeAction);
				L_BROK_APPBL(policyBean, PT_IL_PREM_COLL_BEAN, dummyBean,
						compositeAction);
			}
			if(!(validateOnClaimregister(PT_IL_PREM_COLL_BEAN) == true)){
			if (!("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE()))) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT() };
				resultSet1 = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet1.next()) {
					M_PC_SCHD_PYMT_DT = resultSet1.getDate(1);
				}
				Object[] c3values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						M_PC_SCHD_PYMT_DT};
				resultSet3 = handler.executeSelectStatement(C3, connection,
						c3values);
				if (resultSet3.next()) {
					M_PC_PAID_FLAG = resultSet3.getString(1);
				}
				if (!("N"
						.equalsIgnoreCase(CommonUtils.nvl(M_PC_PAID_FLAG, "N")))
						|| ("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
								.getPC_PREM_TYPE()))) {
					Object[] c2values = {policyBean.getPOL_SYS_ID(),M_PC_SCHD_PYMT_DT};
					resultSet2 = handler.executeSelectStatement(C2, connection,
							c2values);
					if (resultSet2.next()) {
						M_PC_SCHD_PYMT_DT = resultSet2.getDate(1);
					}
					resultSet3 = handler.executeSelectStatement(C3, connection,
							c3values);
					if (resultSet3.next()) {
						M_PC_PAID_FLAG = resultSet3.getString(1);
					} else {
						M_PC_PAID_FLAG = "N";
					}
					if ("N".equalsIgnoreCase(CommonUtils.nvl(M_PC_PAID_FLAG,
							"N"))) {
						if ("A".equalsIgnoreCase(CommonUtils.nvl(
								PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG(), "N"))) {
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_PAID_DT().setDisabled(false);
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_PAID_FLAG().setDisabled(false);
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_FC_UNPAID_PREM_INT()
									.setDisabled(false);
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_LC_UNPAID_PREM_INT()
									.setDisabled(false);
						} else {
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_PAID_DT().setDisabled(true);
							compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getCOMP_PC_PAID_FLAG().setDisabled(true);
						}

					/*if (PT_IL_PREM_COLL_BEAN
							.getPC_LC_PAID_AMT()) {
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_LC_PAID_AMT().setRendered(true);

						// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_PAID_AMT', NAVIGABLE, PROPERTY_TRUE);
						//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_PAID_AMT', UPDATEABLE, PROPERTY_TRUE);
					}*/

					//	SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', NAVIGABLE, PROPERTY_TRUE);
					// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', UPDATEABLE, PROPERTY_TRUE);
				 }

				else {

					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_PAID_DT().setDisabled(false);
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_LC_PAID_AMOUNT().setDisabled(false);
					/*compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_FC_PAID_AMOUNT().setDisabled(false);*/

					//  SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_PAID_AMT', NAVIGABLE, PROPERTY_FALSE);

					//			        SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', NAVIGABLE, PROPERTY_FALSE);
				}
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_DT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_FLAG().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
			}
			}
			
			else if ("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_DT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_FLAG().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(false);
			} else {

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_DT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_PAID_FLAG().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
			}
		}
			if (!"P".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_STATUS(), "N")) || 
					!"C".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_STATUS(), "N"))) {
				//SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_FALSE);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_REINSTATE().setDisabled(true);
				if ("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getPC_PAID_FLAG(), "N"))) {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				} else {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
					//SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE', ENABLED, PROPERTY_TRUE);
				}
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_REINSTATE().setDisabled(false);
				//      SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_TRUE);
			}
			
			if(("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE()) || "R".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE()) ||
					"A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE())) &&
					"N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_FAC_CLOSE_FLAG(), "N"))
					&& "Y".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_FAC_YN(), "N"))){
				resultSet5 = handler.executeSelectStatement(C5A, connection,new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),policyBean.getPOL_PROD_CODE()});
				if(resultSet5.next()){
					M_ASD_CHAR_VALUE = resultSet5.getString(1);
				}
				
				if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE, "N"))){
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(true);
				}else{
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(false);
				}
			}else{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(true);
			}
			
			
			if(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getUI_M_FC_LOAN_INT(), 0) != CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getUI_M_FC_LOAN_INT(), 0)){
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_LOAN_INT(PT_IL_PREM_COLL_BEAN.getUI_M_FC_LOAN_INT());
			}
			
			if(M_POL_CUST_CURR_CODE!=null && M_POL_CUST_CURR_CODE.equalsIgnoreCase(dummyBean.getUI_M_BASE_CURR_CODE())){
				if(!compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_PAID_AMOUNT().isDisabled()){
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_PAID_AMOUNT().setDisabled(true);	
				}
			}else{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_PAID_AMOUNT().setDisabled(false);
			}
			
			/*IF C5%ISOPEN THEN
		   	  CLOSE C5;
		   END IF;
		   OPEN C5;
		   FETCH C5 INTO M_PLAN_TYPE;
		   CLOSE C5;*/
			
			/*if("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())){
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().disableAllComponent(true);
				
			}*/
			if(!(validateOnClaimregister(PT_IL_PREM_COLL_BEAN) == true)){
			if("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())){
				//compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_PAID_AMOUNT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_FLAG().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_DT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_REF_NO().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_APPRV_DT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_WAIVE_PREM_YN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PREM_HOLIDAY_YN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FLEX_01().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_FC_UNPAID_PREM_INT()
				.setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_LC_UNPAID_PREM_INT()
				.setDisabled(true);
			}else{
			//	compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_PAID_AMOUNT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_PAID_AMOUNT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_FLAG().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_DT().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_REF_NO().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_APPRV_DT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_WAIVE_PREM_YN().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PREM_HOLIDAY_YN().setDisabled(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FLEX_01().setDisabled(false);
			}
			}
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_UNPAID_WAIVE_PREM_INT().setDisabled(true);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_LC_UNPAID_WAIVE_PREM_INT().setDisabled(true);
			//newly added to restrict renewal premium collection for cancelled policy
			String M_POL_END_TYPE= chkendtype(PT_IL_PREM_COLL_BEAN);
			if ("009".equalsIgnoreCase(M_POL_END_TYPE)){
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().disableAllComponent(true);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}
	public String chkendtype(PT_IL_PREM_COLL collBean) throws Exception {
		String C1 = "select pol_end_type from pt_il_policy where pol_sys_id = ? ";
		String M_POL_END_TYPE = null;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { collBean.getPC_POL_SYS_ID() });
			if (rs.next()) {
				M_POL_END_TYPE = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs);
		}
		return M_POL_END_TYPE;
	}


	public void preUpdate(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN)
			throws Exception {
		int L_CHECK_MIN_NO = 0;
		int L_CHECK_MAX_NO = 0;
		int M_DUMMY = 0;
		String M_PROD_PREM_HOLIDAY_CODE = null;
		Long M_POL_SYS_ID = 0L;
		Long M_POAD_SYS_ID = 0L;
		Double M_TD_RATE = 0d;
		Double M_TD_RATE_PER = 0d;
		Double L_MAX_CURR_YEAR = 0d;
		int L_MAX_UPTO_YEAR = 0;
		String M_ERR_FLAG = null;

		try {
			String C1 = "SELECT PROD_PREM_HOLIDAY_CODE FROM   PM_IL_PRODUCT WHERE  "
					+ "PROD_CODE = ? ";

			String C2 = "SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_NO = ?";

			String C3 = "SELECT POAD_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE  "
					+ "POAD_POL_SYS_ID = ? ";
			L_CHECK_PREM_HOLIDAY(L_CHECK_MIN_NO, L_CHECK_MAX_NO,
					PT_IL_PREM_COLL_BEAN);
			new P9ILPK_FUND_ALLOC().P_CURR_YEAR_CHECK(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()), String
					.valueOf(L_MAX_CURR_YEAR), String.valueOf(L_MAX_UPTO_YEAR));

			if (L_CHECK_MIN_NO > L_MAX_CURR_YEAR) {
				PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN("N");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91444",
						new Object[] {
								"For Current Policy Year" + L_CHECK_MIN_NO,
								L_MAX_CURR_YEAR }));
				/*STD_MESSAGE_ROUTINE(91445,:CTRL.M_LANG_CODE,
					  'For Current Policy Year '||L_CHECK_MIN_NO,L_MAX_CURR_YEAR);*/
			}
			if (L_CHECK_MAX_NO > L_MAX_UPTO_YEAR) {
				PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN("N");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91445",
						new Object[] { "Upto Term" + L_CHECK_MAX_NO,
								L_MAX_UPTO_YEAR }));
				//STD_MESSAGE_ROUTINE(91445,:CTRL.M_LANG_CODE,'Upto Term '||L_CHECK_MAX_NO,L_MAX_UPTO_YEAR);
			}
			L_VAL_REF_NO(PT_IL_PREM_COLL_BEAN);
			PT_IL_PREM_COLL_BEAN.setPC_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_PREM_COLL_BEAN.setPC_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void L_CHECK_PREM_HOLIDAY(int L_PREMIUM_MIN_C, int L_PREMIUM_MAX_C,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String PREMIUM_HOLIDAY_N = null;
		String PREMIUM_HOLIDAY_Y = null;
		int PREMIUM_HOLIDAY_C = 0;
		String M_PC_PREM_HOLIDAY_YN = null;
		String PREV_PREMIUM_N = null;
		String NEXT_PREMIUM_N = null;
		String PREV_PREMIUM_Y = null;
		String NEXT_PREMIUM_Y = null;
		Date M_PC_SCHD_PYMT_DT = null;
		Date M_DATE = null;
		Date M_DATE_1 = null;
		Date M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT   PC_PREM_HOLIDAY_YN FROM     PT_IL_PREM_COLL WHERE    "
					+ "PC_POL_SYS_ID=? AND      PC_PAID_FLAG <> 'A' AND      "
					+ "PC_SCHD_PYMT_DT < ? AND      "
					+ "PC_SYS_ID <> ?  ORDER BY PC_SCHD_PYMT_DT ";

			String C2 = "SELECT PC_PREM_HOLIDAY_YN ,PC_SCHD_PYMT_DT FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID=? AND    PC_PAID_FLAG <> 'A'  AND    PC_SYS_ID <> ? ORDER  BY PC_SCHD_PYMT_DT";

			String C3 = "SELECT COUNT(*) FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND  "
					+ "  PC_SYS_ID <> ? AND    PC_PREM_HOLIDAY_YN = 'Y'";

			String C4 = "SELECT MAX(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_PREM_TYPE IN ('R','N') AND    PC_POL_SYS_ID = ? AND    "
					+ "PC_SCHD_PYMT_DT <= ? ORDER BY PC_SCHD_PYMT_DT";

			String C5 = "SELECT ADD_MONTHS(?,12) - 1  FROM   DUAL";

			String C6 = "SELECT COUNT(*) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND    "
					+ "PC_SYS_ID     <> ? AND "
					+ " PC_PREM_HOLIDAY_YN = 'Y AND PC_SCHD_PYMT_DT BETWEEN ?	AND ? ";

			PREMIUM_HOLIDAY_N = null;
			PREMIUM_HOLIDAY_Y = null;
			PREV_PREMIUM_N = null;
			NEXT_PREMIUM_N = null;
			PREV_PREMIUM_Y = null;
			NEXT_PREMIUM_Y = null;
			Object[] c1values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT(),
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					c1values);
			if (resultSet1.next()) {
				M_PC_PREM_HOLIDAY_YN = resultSet1.getString(1);
			} else if ("Y".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN)) {
				PREMIUM_HOLIDAY_Y = "Y";
			} else if (("N".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN))
					&& ("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_Y))) {
				PREMIUM_HOLIDAY_N = "Y";
			}
			if (("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_Y))
					&& ("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_N))) {
				if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
						.getPC_PREM_HOLIDAY_YN())) {
					PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN("N");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91444"));
					// STD_MESSAGE_ROUTINE(91444,:CTRL.M_LANG_CODE);
				}
			}

			if ("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_HOLIDAY_YN())) {
				Object[] c2values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet2 = handler.executeSelectStatement(C2, connection,
						c2values);
				if (resultSet2.next()) {
					M_PC_PREM_HOLIDAY_YN = resultSet2.getString(1);
					M_PC_SCHD_PYMT_DT = CommonUtils.sqlToUtilDate(resultSet2.getDate(2));
				} else if (("Y".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN))
						&& (M_PC_SCHD_PYMT_DT.before(PT_IL_PREM_COLL_BEAN
								.getPC_SCHD_PYMT_DT()))) {
					PREV_PREMIUM_N = "Y";
				} else if (("Y".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN))
						&& (M_PC_SCHD_PYMT_DT.after(PT_IL_PREM_COLL_BEAN
								.getPC_SCHD_PYMT_DT()))) {
					NEXT_PREMIUM_N = "Y";
				}

				if (("Y".equalsIgnoreCase(PREV_PREMIUM_N))
						&& ("Y".equalsIgnoreCase(NEXT_PREMIUM_N))) {
					PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN("Y");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91444"));
					// STD_MESSAGE_ROUTINE(91444,:CTRL.M_LANG_CODE);
				} else if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
						.getPC_PREM_HOLIDAY_YN())) {
					PREMIUM_HOLIDAY_N = null;
					PREMIUM_HOLIDAY_Y = null;
				}
				resultSet2 = handler.executeSelectStatement(C2, connection,
						c2values);
				if (resultSet2.next()) {
					M_PC_PREM_HOLIDAY_YN = resultSet2.getString(1);
					M_PC_SCHD_PYMT_DT = CommonUtils.sqlToUtilDate(resultSet2.getDate(2));
				} else if ("N".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN)
						&& (M_PC_SCHD_PYMT_DT.after(PT_IL_PREM_COLL_BEAN
								.getPC_SCHD_PYMT_DT()))) {
					PREMIUM_HOLIDAY_N = "Y";
				} else if (("Y".equalsIgnoreCase(M_PC_PREM_HOLIDAY_YN))
						&& ("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_N))
						&& (M_PC_SCHD_PYMT_DT.after(PT_IL_PREM_COLL_BEAN
								.getPC_SCHD_PYMT_DT()))) {
					PREMIUM_HOLIDAY_Y = "Y";
				}
				if (("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_Y))
						&& ("Y".equalsIgnoreCase(PREMIUM_HOLIDAY_N))) {
					PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN("N");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91444"));
					// STD_MESSAGE_ROUTINE(91444,:CTRL.M_LANG_CODE);
				}
			}
			Object[] c3values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
			resultSet3 = handler.executeSelectStatement(C3, connection,
					c3values);
			if (resultSet3.next()) {
				PREMIUM_HOLIDAY_C = resultSet3.getInt(1);
			}

			if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_HOLIDAY_YN())) {
				L_PREMIUM_MAX_C = PREMIUM_HOLIDAY_C + 1;
			}

			Object[] c4values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT() };
			resultSet4 = handler.executeSelectStatement(C4, connection,
					c4values);
			if (resultSet4.next()) {
				M_DATE = resultSet4.getDate(1);
			}
			resultSet5 = handler.executeSelectStatement(C5, connection,new Object[]{M_DATE});
			if (resultSet5.next()) {
				M_DATE_1 = resultSet5.getDate(1);
			}
			/*Object[] c6values = { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), M_DATE, M_DATE_1 };
			resultSet6 = handler.executeSelectStatement(C6, connection,
					c6values);
			if (resultSet6.next()) {
				PREMIUM_HOLIDAY_C = resultSet6.getInt(1);
			}
			if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_HOLIDAY_YN())) {
				L_PREMIUM_MIN_C = PREMIUM_HOLIDAY_C + 1;
			}*/

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void L_VAL_REF_NO(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_DUMMY = null;
		String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL  WHERE  "
				+ "PC_REF_NO = ?";
		try {
			connection = CommonUtils.getConnection();
			Object[] c1values = { PT_IL_PREM_COLL_BEAN.getPC_REF_NO() };
			resultSet = handler
					.executeSelectStatement(C1, connection, c1values);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71251"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_ITEM_PC_PAID_DT(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		ResultSet resultSet = null;
		ResultSet rs2a = null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		String M_DESC = null;
		ArrayList<String> pvalList = new ArrayList<String>();
		String  M_RI_CFG =null;
		String  M_RECORD_EXISTS =null;
		String  M_PC_PREM_TYPE =null;
		Double dt_amt=null;
		Date M_PC_SCHD_PYMT_DT =null;

		try {
			String C1 = " SELECT 'X'  FROM   PT_IL_PREM_COLL  WHERE "
					+ " PC_POL_SYS_ID = ?  AND    "
					+ "PC_PAID_DT    > ? AND   " + " PC_SYS_ID     < ? ";
			
			String cursorC2A = "SELECT PC_PREM_TYPE,PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL " +
			" WHERE  PC_POL_SYS_ID = ? AND PC_PAID_FLAG = 'Y'";
	
			String cursorc2 ="  SELECT 'X'   FROM   PT_IL_RI_PREM_ALLOC" +
			"  WHERE  RPA_POL_SYS_ID = ? " +
			"  AND    RPA_PRD_TO_DT < =? " +
			
			"  AND    NVL(RPA_FRZ_FLAG,'N') != 'Y' " ;
	

			//below query modified by dhinesh on 16.1.2017 suggested by kuzhandaivel sir
			//String C3="SELECT (CONT_LC_POL_DEP_AMT - CONT_LC_POL_UTIL_AMT) FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ? ";

						
			String C3="SELECT (NVL(CONT_LC_POL_DEP_AMT,0) - NVL(CONT_LC_POL_UTIL_AMT,0)) FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ? ";
			
			/*Added by kavitha on 13.08.2018 for FLALIFEQC-1760998*/
			String C4="SELECT (NVL(PDU_DEP_AMT,0) - NVL(PDU_UTIL_AMT,0)) FROM PT_IL_POL_DEPUTIL WHERE PDU_POL_SYS_ID = ? ";
			ResultSet rs4=null;
			/*End*/

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				connection = CommonUtils.getConnection();
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}else{
				if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
							.getPC_PAID_FLAG())) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "60034"));
						// STD_MESSAGE_ROUTINE (60034, :CTRL.M_LANG_CODE);
					}
			}
			 
			/*  rs2a = handler.executeSelectStatement(cursorC2A, connection,
						 new Object[]{policyBean.getPOL_SYS_ID()});
					     while(rs2a.next()){
						 M_PC_PREM_TYPE = rs2a.getString(1);
						 M_PC_SCHD_PYMT_DT = CommonUtils.sqlToUtilDate(rs2a.getDate(2));
					 
			    	        if("R".equals( M_PC_PREM_TYPE )){ 
			    	           rs2 = new CRUDHandler().executeSelectStatement(cursorc2, connection,
			    				 new Object[]{policyBean.getPOL_SYS_ID(),
			    	        	M_PC_SCHD_PYMT_DT});
			    		     while (rs2.next()) {
			    			 M_RI_CFG = rs2.getString(1);
			    			 throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
			    	        			"71185",new Object[] {policyBean.getPOL_NO()}));
			    		     }
			    		     CommonUtils.closeCursor(rs2);
			    	        }
					     }
					     CommonUtils.closeCursor(rs2a);
			*/
			
			if (CommonUtils.nvl(dummyBean.getM_AVLB_AMT(), 0) > 0) {
				PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT((CommonUtils.nvl(
						dummyBean.getM_AVLB_AMT(), 0))
						+ (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getUI_M_TOT_EXCESS_AMT(), 0))
						- (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getUI_M_TOT_UTL_AMT(), 0)));

				new DBProcedures().P_VAL_ROUND_AMT(policyBean
						.getPOL_CUST_CURR_CODE(), PT_IL_PREM_COLL_BEAN
						.getPC_FC_AVLB_BAL_AMT(), "R", null);

				PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(PT_IL_PREM_COLL_BEAN
						.getPC_FC_AVLB_BAL_AMT()
						* policyBean.getPOL_CUST_EXCH_RATE());

				new DBProcedures().P_VAL_ROUND_AMT(dummyBean
						.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
						.getPC_LC_AVLB_BAL_AMT(), "R", null);

			}
			 /*rs3 = handler.executeSelectStatement(C3, connection,
					 new Object[]{policyBean.getPOL_CONT_CODE()});
				     if(rs3.next()){
				    	 dt_amt = rs3.getDouble(1);
				    	 PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(dt_amt);
				    	 PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(dt_amt);
		
				     }
			*/
			
			/*Added by kavitha on 13.08.2018 for FLALIFEQC-1760998*/
			 String IL_DEP_COLL = CommonUtils.getPPSystemParameterValue("IL_DEP_COLL").toString();
				
			 System.out.println("IL_DEP_COLL           "+IL_DEP_COLL);
			 
			if(IL_DEP_COLL.equalsIgnoreCase("1")){
			
			 rs3 = handler.executeSelectStatement(C3, connection,
					 new Object[]{policyBean.getPOL_CONT_CODE()});
				     if(rs3.next()){
				    	 dt_amt = rs3.getDouble(1);
				    	 PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(dt_amt);
				    	 PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(dt_amt);
		
				     }
			}else if(IL_DEP_COLL.equalsIgnoreCase("2")){
				
				 rs4 = handler.executeSelectStatement(C4, connection,
						 new Object[]{policyBean.getPOL_SYS_ID()});
					     if(rs4.next()){
					    	 dt_amt = rs4.getDouble(1);
					    	 PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(dt_amt);
					    	 PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(dt_amt);
			
					     }
				
			}
			
			/*End*/
			
			pvalList = new ArrayList<String>();
			pvalList = DBProcedures.P_VAL_SYSTEM("IL_SHORTCOLL", "P", M_DESC, "E",
					null);
			if (!pvalList.isEmpty()) {
				PT_IL_PREM_COLL_BEAN.setUI_M_CODE_DESC(pvalList.get(0));
			    }
			if ((!("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_TYPE(), "I"))))
					&& (PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT()
							.before(PT_IL_PREM_COLL_BEAN.getPC_PAID_DT()))) {
				/*new PILT003_PROCEDURES().calL_CALC_UNPAID_PREM_INT(
						PT_IL_PREM_COLL_BEAN, policyBean);*/
				ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
				listUnpaid = p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(policyBean.getPOL_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(), null, null, null, null);
				if(listUnpaid.size() > 0 ){
					if(listUnpaid.get(2).getValueObject() != null ){
						PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT((Double)listUnpaid.get(2).getValueObject());
				}
				
				if(listUnpaid.get(3).getValueObject() != null ){
					PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT((Double)listUnpaid.get(3).getValueObject());
				}
			}
			}
			/*Added By Dhinesh for the ssp call id : FALCONQC-1715078*/
			else if ((!("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PREM_TYPE(), "I"))))
					&& (PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT()
							.equals(PT_IL_PREM_COLL_BEAN.getPC_PAID_DT()))){
				ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
				listUnpaid = p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(policyBean.getPOL_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(), null, null, null, null);
				if(listUnpaid.size() > 0 ){
					if(listUnpaid.get(2).getValueObject() != null ){
						PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT((Double)listUnpaid.get(2).getValueObject());
				}
				
				if(listUnpaid.get(3).getValueObject() != null ){
					PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT((Double)listUnpaid.get(3).getValueObject());
				}
			}
			}
			/*else{
				throw new Exception("Paid date should be greater than scheduled date");
			}*/
			/*End*/
			//PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT(0.0);
			//NEWLY ADDED TO DEFAULT 
			/*Modified by Ram on 02/02/2017 for Waive Processing*/
			System.out.println("PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN()      "+PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN());
			if(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN() != null && PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN().equals("N"))
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0),2));
				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0),2));

			}
			else
			{
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_WAIVE_PREM_INT(), 0))),2));

				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(CommonUtils.ROUND(((CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
						.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT(), 0))-(CommonUtils.nvl(
										PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_WAIVE_PREM_INT(), 0))),2));
			}

			/*End*/
			
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

	}

	public void WHEN_VALIDATE_ITEM_PC_FC_BASIC_PREM(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, PT_IL_POLICY policyBean)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
					+ "AND    PC_PAID_DT    > ? AND    " + "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
			 }
			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PC_LC_BASIC_PREM(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, PT_IL_POLICY policyBean)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
					+ "AND    PC_PAID_DT    > ?AND    " + "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PC_FC_ADDL_PREM(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
					+ "AND    PC_PAID_DT    > ?AND    " + "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PC_LC_ADDL_PREM(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
					+ "AND    PC_PAID_DT    > ?AND    " + "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PC_FC_LOAD_AMT(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, PT_IL_POLICY policyBean)
			throws Exception {
		String M_DUMMY = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
					+ "AND    PC_PAID_DT    > ?AND    " + "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
				// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_PC_LC_LOAD_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_M_FC_TOT_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_M_LC_TOT_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				if (M_DUMMY == null) {
					//C1%FOUND THEN
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_PC_FC_CHARGE_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_PC_LC_CHARGE_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_M_FC_TOT_DUE_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_M_LC_TOT_DUE_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  "
					+ "PC_POL_SYS_ID = ? AND    " + "PC_PAID_DT    > ? AND    "
					+ "PC_SYS_ID     < ?";

			if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() != null) {
				Object[] c1values = { policyBean.getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71075"));
					//STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
				}
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71030"));
					//STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	public void WHEN_VALIDATE_PC_FC_PAID_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		ResultSet resultSet0 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet16 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Double M_AMT;
		Double M_GROSS_NET_AMT = 0.0;
		Double M_TOT_AMT = 0.0;
		Double M_PAID_AMT;
		Double M_AVAIL_AMT =0.0;
		Double M_EXHG_RATE = 0.0;
		String M_MODE_OF_PYMT = null;
		String M_POL_PLAN_CODE = null;
		String M_PLAN_TYPE = null;
		Double M_POL_FC_ADDL_PREM = 0.0;
		Double M_POL_MODE_OF_PYMT = 0.0;
		Double M_POL_MODE_OF_PYMT_RATE = 0.0;
		String M_DEP_GROSS_NET_FLAG = null;
		String M_POL_PROP_NO = null;
		String M_DESC = null;
		int M_PS_VALUE = 0;
		int M_CALC_METHOD = 0;
		String M_MOP_FACTOR;
		Double M_MODAL_FACTOR;
		String M_IL_RND_TYPE = null;
		Double M_PMOP_SHORT_RATE = 0.0;
		Double M_PMOP_SHORT_RATE_PER = 0.0;
		String M_PMOP_TOLL_TYP = null;
		ArrayList<OracleParameter> M_MOP_FACTORlist = new ArrayList<OracleParameter>();
		try {
			connection = CommonUtils.getConnection();
			String C0 = "SELECT  PS_VALUE FROM    PP_SYSTEM WHERE   PS_TYPE = 'IL_RND_TYPE'";
			String C1 = "SELECT POL_MODE_OF_PYMT,POL_PROP_NO,POL_PLAN_CODE,POL_FC_ADDL_PREM,"
					+ "POL_MODE_OF_PYMT_RATE  FROM   PT_IL_POLICY WHERE  "
					+ "POL_SYS_ID = ?";
			String C2 = "SELECT DEP_GROSS_NET_FLAG FROM   PT_IL_DEPOSIT WHERE  "
					+ "DEP_REF_NO   = ?";
			String C3 = "SELECT PLAN_TYPE  FROM   PM_IL_PLAN WHERE  "
					+ "PLAN_CODE  =  ? AND   " + " PLAN_FRZ_FLAG = 'N'";
			String C16 = "SELECT PMOP_SHORT_RATE, PMOP_SHORT_RATE_PER, "
					+ "PMOP_TOLL_TYP FROM PM_IL_PLAN_MOP "
					+ "WHERE PMOP_PLAN_CODE=? AND PMOP_TYPE=?";
			Object[] c1values = { policyBean.getPOL_SYS_ID() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					c1values);
			if (resultSet1.next()) {
				M_MODE_OF_PYMT = resultSet1.getString(1);
				M_POL_PROP_NO = resultSet1.getString(2);
				M_POL_PLAN_CODE = resultSet1.getString(3);
				M_POL_FC_ADDL_PREM = resultSet1.getDouble(4);
				M_POL_MODE_OF_PYMT_RATE = resultSet1.getDouble(5);
			}
			Object[] c2values = {M_POL_PROP_NO};
			resultSet2 = handler.executeSelectStatement(C2, connection,c2values);
			if (resultSet2.next()) {
				M_DEP_GROSS_NET_FLAG = resultSet2.getString(1);
			}
			Object[] c3values = { policyBean.getPOL_PLAN_CODE() };
			resultSet3 = handler.executeSelectStatement(C3, connection,
					c3values);
			if (resultSet3.next()) {
				M_PLAN_TYPE = resultSet3.getString(1);
			}
			DBProcedures.callP_VAL_SYSTEM("IL_CALC_MTHD", "IL_CALC_MTHD",
					M_DESC, "N", String.valueOf(M_CALC_METHOD));

			DBProcedures.callP_VAL_SYSTEM("IL_SHORT_COL", M_MODE_OF_PYMT,
					M_DESC, "E", (PT_IL_PREM_COLL_BEAN
					.getUI_M_TOL_LIMIT_AMT()!=null ?String.valueOf(PT_IL_PREM_COLL_BEAN
							.getUI_M_TOL_LIMIT_AMT()) : ""));

			DBProcedures.callP_VAL_SYSTEM("IL_TOLL_TYPE", "IL_TOLL_TYPE",
					M_DESC, "N", String.valueOf(M_PS_VALUE));

			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_FC_PAID_AMT(), "V", null);

			if (dummyBean.getUI_M_IL_ENDEXCHRT()!= null && !("1".equals(dummyBean.getUI_M_IL_ENDEXCHRT()))) {
				new PCOPK_GENERAL().P_GET_EXCHANGE_RATE(policyBean
						.getPOL_CUST_CURR_CODE(), dummyBean.getUI_M_BUY_SELL(),
						CommonUtils.dateToStringFormatter(PT_IL_PREM_COLL_BEAN
								.getPC_PAID_DT()), String.valueOf(policyBean
								.getPOL_CUST_EXCH_RATE()), "E", CommonUtils
								.getControlBean().getM_LANG_CODE(), CommonUtils
								.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			}

			PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_AMT(PT_IL_PREM_COLL_BEAN
					.getPC_FC_PAID_AMT()
					* policyBean.getPOL_CUST_EXCH_RATE());

			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_PAID_AMT(), "R", null);
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO WORK CALC METHOD 2
			
			if ((("1".equals(CommonUtils.nvl(M_CALC_METHOD, 1) )
					|| "1".equals(CommonUtils.nvl(M_CALC_METHOD, 2))))
					&& ("N".equalsIgnoreCase(CommonUtils.nvl(
							M_DEP_GROSS_NET_FLAG, "G")))) {
				M_MOP_FACTORlist = new ArrayList<OracleParameter>();
				M_MOP_FACTORlist = new P9ILPK_POLICY()
						.F_GET_MOP_VALUE(M_MODE_OF_PYMT);
				M_MODAL_FACTOR = CommonUtils.nvl(M_POL_MODE_OF_PYMT_RATE, 0);
				M_POL_FC_ADDL_PREM = CommonUtils.nvl(M_POL_FC_ADDL_PREM, 0)
						* M_MODAL_FACTOR;
				new DBProcedures().callP_VAL_ROUND_AMT(policyBean
						.getPOL_CUST_CURR_CODE(), String
						.valueOf(M_POL_FC_ADDL_PREM), "R");
				M_GROSS_NET_AMT = CommonUtils.nvl(M_POL_FC_ADDL_PREM, 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_LOAD_AMT(), 0)
						- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_DISCOUNT(), 0);
			} else {
				M_GROSS_NET_AMT = CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getPC_FC_GROSS_PREM(), 0);
			}
			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), M_GROSS_NET_AMT, "R", null);
			if (M_PS_VALUE == 1) {
				M_AMT = (CommonUtils.nvl(M_GROSS_NET_AMT, 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_CHARGE(), 0) + CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0)
						* CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getUI_M_TOL_LIMIT_AMT(), 0) / 100);
			} else {
				M_AMT = CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getUI_M_TOL_LIMIT_AMT(), 0);
			}
			Object[] c16values = { M_POL_PLAN_CODE, M_MODE_OF_PYMT };
			resultSet16 = handler.executeSelectStatement(C16, connection,
					c16values);

			if (resultSet16.next()) {
				M_PMOP_SHORT_RATE = resultSet16.getDouble(1);
				M_PMOP_SHORT_RATE_PER = resultSet16.getDouble(2);
				M_PMOP_TOLL_TYP = resultSet16.getString(3);
			}

			if ("P".equalsIgnoreCase(M_PMOP_TOLL_TYP)) {
				M_AMT = (CommonUtils.nvl(M_GROSS_NET_AMT, 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_CHARGE(), 0) + CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0)
						* CommonUtils.nvl(M_PMOP_SHORT_RATE, 0)
						/ CommonUtils.nvl(M_PMOP_SHORT_RATE_PER, 0));
			} else {
				M_AMT = CommonUtils.nvl(M_PMOP_SHORT_RATE, 0);
			}
			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), M_AMT, "R", null);

			M_TOT_AMT = (CommonUtils.nvl(M_GROSS_NET_AMT, 0)
					+ CommonUtils
							.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE(), 0)
					+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
							.getPC_FC_UNPAID_PREM_INT(), 0) - M_AMT-CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
									.getPC_FC_UNPAID_WAIVE_PREM_INT(), 0));

			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), M_TOT_AMT, "R", null);
			
			M_TOT_AMT =	CommonUtils.ROUND(M_TOT_AMT,3);

			resultSet0 = handler.executeSelectStatement(C0, connection);
			if (resultSet0.next()) {
				M_IL_RND_TYPE = resultSet0.getString(1);
			}

			if ("1".equalsIgnoreCase(M_IL_RND_TYPE)) {
				//need to confirm
				// M_TOT_AMT = Math.round(M_TOT_AMT);	   
			}
				M_AVAIL_AMT = CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_FC_AVLB_BAL_AMT(), 0);
					
				M_PAID_AMT =CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(),
							0);
			//NEWLY ADDED TO CHECK DEPOSIT + GIVEN AMOUNT >= TOTAL AMOUNT
				
			if(M_AVAIL_AMT > 0){
				if(M_PAID_AMT  < M_TOT_AMT){
					if((M_PAID_AMT + M_AVAIL_AMT ) >= M_TOT_AMT){
						M_PAID_AMT = M_TOT_AMT;
					}
				}
			}
			
			//added ends 
			new DBProcedures().P_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), M_PAID_AMT, "R", null);
			if (("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG()))
					&& ("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
							.getPC_PREM_HOLIDAY_YN()))) {
				if (CommonUtils.nvl(M_PAID_AMT, 0) < CommonUtils.nvl(M_TOT_AMT,
						0)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91084"));
					//STD_MESSAGE_ROUTINE(91084,:CTRL.M_LANG_CODE);
				}
			}
			if (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(), 0) > 0
					&& CommonUtils.ROUND(CommonUtils.nvl(M_PAID_AMT, 0),2) > CommonUtils.ROUND(CommonUtils.nvl(
							M_TOT_AMT, 0)
							+ CommonUtils.nvl(M_AMT, 0),2)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91070"));
				//STD_MESSAGE_ROUTINE(91070,:CTRL.M_LANG_CODE);
			}
			if (PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM()
					- PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT() > 0) {
				PT_IL_PREM_COLL_BEAN.setUI_M_UTL_AMT(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM(), 0)
						- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_FC_PAID_AMT(), 0));
			} else {
				PT_IL_PREM_COLL_BEAN.setUI_M_EXCESS_AMT(CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(), 0)
						- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getUI_M_FC_NET_PREM(), 0));
				PT_IL_PREM_COLL_BEAN.setUI_M_SHORT_AMT(0.0);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet0);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet16);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

	}

	public void WHEN_VALIDATE_PC_LC_PAID_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet16 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Double M_AMT = 0.0;
		Double M_TOT_AMT = 0.0;
		Double M_PAID_AMT = 0.0;
		Double M_PMOP_SHORT_RATE = 0.0;
		int M_PMOP_SHORT_RATE_PER = 0;
		String M_PMOP_TOLL_TYP = null;
		String M_MODE_OF_PYMT = null;
		String M_POL_PLAN_CODE = null;
		String M_DEP_GROSS_NET_FLAG = null;
		String M_POL_PROP_NO = null;
		Double M_POL_FC_ADDL_PREM = 0.0;
		Double M_POL_MODE_OF_PYMT_RATE = 0.0;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT POL_MODE_OF_PYMT,POL_PROP_NO,POL_PLAN_CODE,POL_FC_ADDL_PREM,POL_MODE_OF_PYMT_RATE FROM  "
					+ " PT_IL_POLICY WHERE  POL_SYS_ID = ?";
			String C16 = "SELECT PMOP_SHORT_RATE, PMOP_SHORT_RATE_PER, PMOP_TOLL_TYP FROM  "
					+ "PM_IL_PLAN_MOP WHERE PMOP_PLAN_CODE=? AND PMOP_TYPE=?";

			if (PT_IL_PREM_COLL_BEAN.getPC_LC_PAID_AMT() != null) {
				new DBProcedures().P_VAL_ROUND_AMT(dummyBean
						.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
						.getPC_LC_PAID_AMT(), "V", null);

				if (!("1".equals(dummyBean.getUI_M_IL_ENDEXCHRT()))) {
					new PCOPK_GENERAL()
							.P_GET_EXCHANGE_RATE(
									policyBean.getPOL_CUST_CURR_CODE(),
									dummyBean.getUI_M_BUY_SELL(),
									CommonUtils
											.dateToStringFormatter(PT_IL_PREM_COLL_BEAN
													.getPC_PAID_DT()),
									String.valueOf(policyBean
											.getPOL_CUST_EXCH_RATE()),
									"E",
									CommonUtils.getControlBean()
											.getM_LANG_CODE(),
									CommonUtils
											.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				}

				new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
						.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT()),
						String
								.valueOf(PT_IL_PREM_COLL_BEAN
										.getPC_LC_PAID_AMT()), String
								.valueOf(policyBean.getPOL_CUST_EXCH_RATE()),
						"E");

				Object[] c1values = { policyBean.getPOL_SYS_ID() };
				resultSet1 = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet1.next()) {
					M_MODE_OF_PYMT = resultSet1.getString(1);
					M_POL_PROP_NO = resultSet1.getString(2);
					M_POL_PLAN_CODE = resultSet1.getString(3);
					M_POL_FC_ADDL_PREM = resultSet1.getDouble(4);
					M_POL_MODE_OF_PYMT_RATE = resultSet1.getDouble(5);
				}

				M_AMT = (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_CHARGE(), 0)
						- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_DISCOUNT(), 0) + CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT(), 0))
						* (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getUI_M_TOL_LIMIT_AMT(), 0) / 100);

				Object[] c16values = { M_POL_PLAN_CODE, M_MODE_OF_PYMT };
				resultSet16 = handler.executeSelectStatement(C16, connection,
						c16values);
				if (resultSet16.next()) {
					M_PMOP_SHORT_RATE = resultSet16.getDouble(1);
					M_PMOP_SHORT_RATE_PER = resultSet16.getInt(2);
					M_PMOP_TOLL_TYP = resultSet16.getString(3);
				}
				if ("P".equalsIgnoreCase(M_PMOP_TOLL_TYP)) {
					M_AMT = (CommonUtils.nvl(CommonUtils.nvl(
							PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM(), 0)
							+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
									.getPC_LC_CHARGE(), 0)
							- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
									.getPC_LC_DISCOUNT(), 0)
							+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
									.getPC_LC_UNPAID_PREM_INT(), 0), 0) * (CommonUtils
							.nvl(M_PMOP_SHORT_RATE, 0) / CommonUtils.nvl(
							M_PMOP_SHORT_RATE_PER, 0)));
				} else {
					M_AMT = CommonUtils.nvl(M_PMOP_SHORT_RATE, 0);
				}

				M_TOT_AMT = (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_CHARGE(), 0)
						- CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_DISCOUNT(), 0) + CommonUtils.nvl(
						PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT(), 0))
						- M_AMT;

				M_PAID_AMT = CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getPC_LC_AVLB_BAL_AMT(), 0)
						+ CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
								.getPC_LC_PAID_AMT(), 0);
				if ("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN
						.getPC_PREM_HOLIDAY_YN())) {

					if (CommonUtils.nvl(M_PAID_AMT, 0) < CommonUtils.nvl(
							M_TOT_AMT, 0)) {
						//STD_MESSAGE_ROUTINE(91084,:CTRL.M_LANG_CODE);
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91084"));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet16);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void PC_PAID_FLAG_KEY_NEXT_ITEM(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		PT_IL_PREM_COLL_BEAN.getPC_REF_NO();
	}

	public void PC_PAID_FLAG_WHEN_LIST_CHANGED(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN,
			PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			
			
			
			
			if ("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())) {
				
				checkprvReceipt(compositeAction);
				
				//need to do
				//L_CHECK_SURR_MAT_VAL('G');
			}
			//need to do
			//L_INSERT_LOAN_INT;

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"))) {

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
				//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_TRUE);
				// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_TRUE);
				/*compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_PAID_AMOUNT().setDisabled(false);*/
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_PAID_AMOUNT().setDisabled(false);
				if (PT_IL_PREM_COLL_BEAN.getPC_PAID_DT() == null) {
					PT_IL_PREM_COLL_BEAN.setPC_PAID_DT(PT_IL_PREM_COLL_BEAN
							.getPC_PAID_DT());
				}
				if (!(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(),
						0)).equals(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
						.getUI_M_FC_NET_PREM(), 0))) {
					/* suji2 compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);*/
					//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', UPDATEABLE, PROPERTY_TRUE);   	     		
					/*PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT(PT_IL_PREM_COLL_BEAN
							.getPC_FC_PAID_AMT());*/
				}
			} else if("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"))){
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
				// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_FALSE);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
				//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_FALSE);
				//compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
					//	.getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);
				//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', UPDATEABLE, PROPERTY_TRUE);
			}else{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
		// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_FALSE);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
		//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_LC_UNPAID_PREM_INT', UPDATEABLE, PROPERTY_FALSE);
		/* suji1 compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);*/
		//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_FC_PAID_AMT', UPDATEABLE, PROPERTY_TRUE);

			}

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_REF_NO().setDisabled(true);
				//SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_REF_NO', UPDATEABLE, PROPERTY_TRUE);
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_REF_NO().setDisabled(false);
				// SET_ITEM_PROPERTY('PT_IL_PREM_COLL.PC_REF_NO', UPDATEABLE, PROPERTY_FALSE);
			}
          if(!("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE()))){
			if ("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN
					.getPC_PAID_FLAG(), "N"))) {
				PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG("N");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91123"));
				//STD_MESSAGE_ROUTINE(91123,:CTRL.M_LANG_CODE);
			}
          }
          
          if("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())){
        		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_WAIVE_PREM_YN().setDisabled(true);
          }else{
        	  compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_PC_WAIVE_PREM_YN().setDisabled(false);
          }
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_PC_REF_NO(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN)
			throws Exception {
		try {
			L_VAL_REF_NO(PT_IL_PREM_COLL_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_PC_UNPAID_PREM_INT_CODE(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN,
			PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			if (PT_IL_PREM_COLL_BEAN.getPC_UNPAID_PREM_INT_CODE() != null) {
				new DBProcedures().P_VAL_CODES("IL_PRM_INT",
						PT_IL_PREM_COLL_BEAN.getPC_UNPAID_PREM_INT_CODE(),
						PT_IL_PREM_COLL_BEAN.getUI_M_CODE_DESC(), "N", "E",
						null);

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_PREM_COLL_BEAN
						.setPC_FC_UNPAID_PREM_INT(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT());
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_PREM_COLL_BEAN
						.setPC_FC_UNPAID_PREM_INT(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT());
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_FC_UNPAID_PREM_INT().setRequired(false);
				PT_IL_PREM_COLL_BEAN
						.setPC_FC_UNPAID_PREM_INT(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT());
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_PC_LC_UNPAID_PREM_INT().setRequired(false);
				PT_IL_PREM_COLL_BEAN
						.setPC_FC_UNPAID_PREM_INT(PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_PC_FC_UNPAID_PREM_INT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					"R");
			PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(PT_IL_PREM_COLL_BEAN
					.getPC_FC_UNPAID_PREM_INT()
					* policyBean.getPOL_CUST_EXCH_RATE());
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "R", null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_PC_LC_UNPAID_PREM_INT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(policyBean
					.getPOL_CUST_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_PC_TEMP_RCPT_NO(
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception {
		String M_C1FOUND = null;
		String M_C2FOUND = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT	'X' FROM PT_IL_DEPOSIT WHERE "
					+ " DEP_TEMP_RCPT_NO = ?";
			String C2 = "SELECT	'X' FROM PT_IL_PREM_COLL WHERE   PC_TEMP_RCPT_NO = ?";
			Object[] c1values = { PT_IL_PREM_COLL_BEAN.getPC_TEMP_RCPT_NO() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					c1values);
			if (resultSet1.next()) {
				M_C1FOUND = resultSet1.getString(1);
			}
			Object[] c2values = { PT_IL_PREM_COLL_BEAN.getPC_TEMP_RCPT_NO() };
			resultSet1 = handler.executeSelectStatement(C2, connection,
					c2values);
			if (resultSet2.next()) {
				M_C2FOUND = resultSet2.getString(1);
			}
			if (M_C1FOUND != null || M_C2FOUND != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91267"));
				//STD_MESSAGE_ROUTINE(91267,:CTRL.M_LANG_CODE);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void WHEN_VALIDATE_M_TOT_UTL_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_UTL_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_M_TOT_EXCESS_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_M_EXCESS_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_M_SHORT_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_M_TOL_LIMIT_AMT(PT_IL_POLICY policyBean,
			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, DUMMY dummyBean)
			throws Exception {
		try {
			new DBProcedures().callP_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT()),
					"R");
			new DBProcedures().P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR_CODE(), PT_IL_PREM_COLL_BEAN
					.getPC_LC_UNPAID_PREM_INT(), "V", null);
			new PCOPK_GENERAL().P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT()),
					String.valueOf(PT_IL_PREM_COLL_BEAN
							.getPC_LC_UNPAID_PREM_INT()), String
							.valueOf(policyBean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(
					PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT(), 0) == 0) {
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	public void WHEN_BTN_PRESSED_M_BUT_FAC(PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 ="SELECT PC_SYS_ID FROM   PT_IL_PREM_COLL WHERE  " +
					"PC_POL_SYS_ID  = ? AND    NVL(PC_PREM_TYPE, 'N')     " +
					"IN ('R', 'N','A') AND    NVL(PC_PAID_FLAG, 'N')     = 'A' " +
					"AND    NVL(PC_FAC_CLOSE_FLAG,'N') = 'N'";
			
			  Object[] c1values = {policyBean.getPOL_SYS_ID()};
			  resultSet = handler.executeSelectStatement(C1, connection,c1values);
			  if(resultSet.next()){
				  CommonUtils.setGlobalVariable("GLOBAL.M_PC_SYS_ID",resultSet.getString(1));
			  }
			  else{
				  throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71173"));
			  }
			   CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
			   //CALL_FORM('PILT009', NO_HIDE, NO_REPLACE);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_BTN_PRESSED_M_FUND_QUERY_DETAILS(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN,PT_IL_POLICY policyBean){
		CommonUtils.setGlobalVariable("GLOBAL.G_PC_SYS_ID",String.valueOf(PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()));
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",policyBean.getPOL_NO()); 
		//CALL_FORM('PILQ106_APAC',NO_HIDE,NO_REPLACE);
	}
	
	public String apprBtnAction(PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		String custCode = null;
		String output = null;
		int PC_POL_SYS_ID = 0;
		int M_COUNT = 0;
		int M_DUMMY = 0;
		Date tranDate = null;
		String cursorC1 = "SELECT COUNT(*) FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? " +
				" AND NVL(PC_PREM_TYPE,'N')  IN ('R', 'N') AND NVL(PC_PAID_FLAG,'N')  = 'A' " +
				" AND NVL(PC_RI_CLOSE_FLAG,'N') != 'Y'";
		//(NVL(PC_FAC_CLOSE_FLAG,'N') != 'Y' OR
		String cursorC2A = "SELECT PC_PREM_TYPE,PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL " +
				" WHERE  PC_POL_SYS_ID = ? AND PC_PAID_FLAG = 'Y'";
		
		String cursorc2 ="  SELECT 'X'   FROM   PT_IL_RI_PREM_ALLOC" +
				"  WHERE  RPA_POL_SYS_ID = ? " +
				"  AND    RPA_PRD_TO_DT <= ? " +
				"  AND    NVL(ABS(RPA_RI_FC_PREM),0) > 0" +
				"  AND    NVL(ABS(RPA_RI_LC_PRD_PREM),0)      > 0" +
				"  AND    NVL(RPA_FRZ_FLAG,'N') = 'N' " ;
		
		String cursorc3 = " SELECT 'X' FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? " +
				" AND NVL(PC_PAID_FLAG,'N')  = 'Y' AND PC_PAID_DT IS NOT NULL" +
				"  AND NVL(PC_FC_AVLB_BAL_AMT,0) + NVL(PC_LC_PAID_AMT,0) > 0";

		String cursorC4 = " SELECT COUNT(*) FROM PT_IL_PYMT_DTLS WHERE  PD_TXN_SYS_ID=(SELECT MIN(PC_SYS_ID) " +
				" FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N')  = 'Y'AND " +
				" PC_PAID_DT IS NOT NULL) AND PD_TXN_TYPE='PC'";


		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		 Connection connection=null;
		 
		 PT_IL_POLICY_ACTION policyAction = compositeAction.getPT_IL_POLICY_ACTION_BEAN();
		 PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String policyNumber = policyAction.getPT_IL_POLICY_BEAN().getPOL_NO();
		ResultSet rs =null,rs1=null,rs2a=null,rs2=null;
		String  M_RI_CFG =null;
		String  M_RECORD_EXISTS =null;
		String  M_PC_PREM_TYPE =null;
		Date M_PC_SCHD_PYMT_DT =null;
	 try {
	     connection = CommonUtils.getConnection();
	     /*Modified if condition by ganesh on 05-02-2018 to validate direct collectio also suggested by ajoy from onsite*/
	     if( PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT() > 0 || PT_IL_PREM_COLL_BEAN.getPC_FC_AVLB_BAL_AMT() > 0){  										
	       rs = new CRUDHandler().executeSelectStatement(cursorC4, connection,new Object[]{policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
        	     while (rs.next()) {
        		M_COUNT = rs.getInt(1);
        	     }

        	     if (M_COUNT == 0 &&  !("Y".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PREM_HOLIDAY_YN()))) {
        		 throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
        						"91171"));
        	     }
	     }
	     CommonUtils.closeCursor(rs);
	     if("Y".equals(CommonUtils.nvl(policyAction.getPT_IL_POLICY_BEAN().getPOL_FAC_YN(),"N") )){
		 rs = new CRUDHandler().executeSelectStatement(cursorC1, connection,
			 new Object[]{policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		     while (rs.next()) {
			 M_DUMMY = rs.getInt(1);
		     }
    	     /*
    	      * Commened By Haneef testing purpose
    	      */
		     /*if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_PREM_TYPE(),"N"),"N","R") &&	    
    		      (!"Y".equals(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_FAC_CLOSE_FLAG(),"N")) ||
    		      (!"Y".equals(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_RI_CLOSE_FLAG(),"N"))) &&
    	         CommonUtils.nvl(M_DUMMY,0)>=1){
    		  throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
    			"71151",new Object[] {policyAction.getPT_IL_POLICY_BEAN().getPOL_NO()}));
    	            //STD_MESSAGE_ROUTINE(71151, :CTRL.M_LANG_CODE, :PT_IL_POLICY.POL_NO);
    	      }*/
	     }
		     rs2a = new CRUDHandler().executeSelectStatement(cursorC2A, connection,
			 new Object[]{policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		     while(rs2a.next()){
			 M_PC_PREM_TYPE = rs2a.getString(1);
			 M_PC_SCHD_PYMT_DT = CommonUtils.sqlToUtilDate(rs2a.getDate(2));
		 
    	        if("R".equals( M_PC_PREM_TYPE )){ 
    	           rs2 = new CRUDHandler().executeSelectStatement(cursorc2, connection,
  				 new Object[]{policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
    	        	M_PC_SCHD_PYMT_DT});
    		     while (rs2.next()) {
    			 M_RI_CFG = rs2.getString(1);
    			 /*Commented By vinoj
    			 throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,           
    	        			"71185",new Object[] {policyAction.getPT_IL_POLICY_BEAN().getPOL_NO()}));*/
    		     }
    		     CommonUtils.closeCursor(rs2);
    	        }
		     }
		     CommonUtils.closeCursor(rs2a);
		    new PKG_PILT003_APAC().L_CHECK_SURR_MAT_VAL("R",
			    	PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(), 
			    	PT_IL_PREM_COLL_BEAN.getPC_SCHD_PYMT_DT(),
			    	policyAction.getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE());
		    new PKG_PILT003_APAC().L_CHECK_PYMT_DTLS(policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
			    PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM());
	     rs  = new CRUDHandler().executeSelectStatement(cursorc3, connection,
			 new Object[]{policyAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	     while (rs .next()) {
		 M_RECORD_EXISTS = rs.getString(1);
	     }
	     if ("X".equals(M_RECORD_EXISTS)) {
		 CommonUtils.setGlobalVariable( "GLOBAL.M_POL_NO", policyAction.getPT_IL_POLICY_BEAN().getPOL_NO());
		CommonUtils.setGlobalObject( "GLOBAL.M_PAID_DT", new CommonUtils().getCurrentDate());
		CommonUtils.setGlobalVariable( "GLOBAL.M_CUST_CODE", policyAction.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE());
		CommonUtils.setGlobalObject( "GLOBAL.M_TRAN_DATE", new CommonUtils().getCurrentDate());
		output ="PILP003_APAC";
		if("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SUCC"))){	  
		    /*throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
			"60315" )); */	
	      	 // STD_MESSAGE_ROUTINE(60315, :GLOBAL.M_LANG_CODE);
		}
	     }else{
		 throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
	    			"71078" )); 
	     }
	     CommonUtils.setGlobalVariable( "GLOBAL.M_POL_NO", policyAction.getPT_IL_POLICY_BEAN().getPOL_NO());
			CommonUtils.setGlobalObject( "GLOBAL.M_PAID_DT", new CommonUtils().getCurrentDate());
			CommonUtils.setGlobalVariable( "GLOBAL.M_CUST_CODE", policyAction.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE());
			CommonUtils.setGlobalObject( "GLOBAL.M_TRAN_DATE", new CommonUtils().getCurrentDate());
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT003_APAC");
	  }
	 
	 
	 catch (Exception e) {
	    // TODO: handle exception
	     e.printStackTrace();
	     throw new Exception(e.getMessage()); 
	}
	 finally{
	     CommonUtils.closeCursor(rs);
	     CommonUtils.closeCursor(rs1);
	     CommonUtils.closeCursor(rs2);
	     CommonUtils.closeCursor(rs2a);
	 }
		return output;
	}
	
	/**
	 * 
	 * @param PT_IL_PREM_COLL_BEAN
	 * @param policyBean
	 * @throws Exception
	 */
	public void WHEN_BTN_PRESSED_PYMT_DETAILS(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN,PT_IL_POLICY policyBean) throws Exception{
		Double M_LC_DEP_AVAI_AMT = 0.0;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet4 = null;
		long pc_sysid=0l;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
        try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) FROM	" +
					" PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? " +
					" AND PC_PAID_DT IS NOT NULL";
			String C2 = "SELECT MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) FROM	" +
			" PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N')= 'Y' " +
			" AND PC_PAID_DT IS NOT NULL";
			String C3 = "SELECT MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) FROM	" +
			" PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? ";
			String C4="SELECT MIN(DEP_SYS_ID) FROM PT_IL_DEPOSIT WHERE DEP_REF_NO =?";
			String C5= "SELECT 'X' FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ?";
			
				 if("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG())){
					 //added by mohan to get first prem coll payment details
					 Object[] c2values = {policyBean.getPOL_SYS_ID()};
					 resultSet1 = handler.executeSelectStatement(C3, connection, c2values);
					 if(resultSet1.next()){
						 pc_sysid=resultSet1.getLong(1);
						 }
					 if(pc_sysid==PT_IL_PREM_COLL_BEAN.getPC_SYS_ID().longValue()){
						 Object[] c3values = {policyBean.getPOL_NO()};
						 resultSet2 = handler.executeSelectStatement(C4, connection, c3values);
						 if(resultSet2.next()){
							 CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",resultSet2.getLong(1));
							 
						 }
						//.... 
					 }else{
					 Object[] c1values = {policyBean.getPOL_SYS_ID()};
					 resultSet = handler.executeSelectStatement(C1, connection, c1values);
					 if(resultSet.next()){
						 CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",PT_IL_PREM_COLL_BEAN.getPC_SYS_ID());
						 CommonUtils.setGlobalObject("GLOBAL.FC_AMT",resultSet.getDouble(2));
						 CommonUtils.setGlobalObject("GLOBAL.LC_AMT",resultSet.getDouble(3));
					 }
				    }
				 }
					 else{
						Object[] c1values = {policyBean.getPOL_SYS_ID()};
						 resultSet = handler.executeSelectStatement(C2, connection, c1values);
						 if(resultSet.next()){
							 CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",resultSet.getLong(1));
							 CommonUtils.setGlobalObject("GLOBAL.FC_AMT",resultSet.getDouble(2));
							 CommonUtils.setGlobalObject("GLOBAL.LC_AMT",resultSet.getDouble(3));
						 }
						 
						// CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",PT_IL_PREM_COLL_BEAN.getPC_SYS_ID());
					 }
				 
				 //my ref 
				 list =  new  P9ILPK_CHEQ_VALIDATION().GET_AVAILABLE_DEPOSIT(PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						  M_LC_DEP_AVAI_AMT);
					 if(list.size() > 0){
						 M_LC_DEP_AVAI_AMT = (Double) list.get(0).getValueObject();
					 }
					 
			if(!("A".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_PAID_FLAG()))){
				/*Added by Ram on 05/03/2017 for DepRefId is null issue*/

	 			/*
	 			 * commented by Dhinesh on 14-06-2017 for ssp call id ZBILQC-1725859
	 			 * if(PT_IL_PREM_COLL_BEAN.getOLD_PC_FC_PAID_AMT()== null || (PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT().compareTo(PT_IL_PREM_COLL_BEAN.getOLD_PC_FC_PAID_AMT()) != 0))
	 			 */
				/*Newly added by Dhinesh on 14-06-2017 for ssp call id ZBILQC-1725859*/
				if(CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getOLD_PC_FC_PAID_AMT(),0) == 0 || (PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT().compareTo(PT_IL_PREM_COLL_BEAN.getOLD_PC_FC_PAID_AMT()) != 0))
				{
					System.out.println("Values are not Same.Procedure is call");
					/*End*/
					String deleteQuery = "DELETE FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? AND PD_TXN_TYPE ='PC' ";
					handler.executeDeleteStatement(deleteQuery, connection, new Object[]{PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()});
					if(0 == PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT()){

						resultSet4 = handler.executeSelectStatement(C5, connection, new Object[]{PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()});
						if (!(resultSet4.next())) {
							new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
									PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), M_LC_DEP_AVAI_AMT,
									0.0, "D", "PC", policyBean.getPOL_CUST_EXCH_RATE(),"DP");
						}
					}
					if(PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT() > 0 ){
						/* resultSet4 = handler.executeSelectStatement(C5, connection, new Object[]{PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()});
					 if (!(resultSet4.next())) {*/

						//}
						Double balance = PT_IL_PREM_COLL_BEAN.getUI_M_FC_NET_PREM()-PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT();
						if(M_LC_DEP_AVAI_AMT > 0 && balance > 0 ){
							if(M_LC_DEP_AVAI_AMT >=balance) {
								new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
										PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), balance,
										0.0, "D", "PC", policyBean.getPOL_CUST_EXCH_RATE(),"DP");
							}else{
								new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
										PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), M_LC_DEP_AVAI_AMT,
										0.0, "D", "PC", policyBean.getPOL_CUST_EXCH_RATE(),"DP");
							}
						}
						/*new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
								PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(),PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(),
								0.0, "D", "PC", policyBean.getPOL_CUST_EXCH_RATE(),"P");*/
						new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT_RP(
								PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(),
								PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(), 0.0, "D",
								"PC", policyBean.getPOL_CUST_EXCH_RATE());
					}
					/*Added by Ram on 05/03/2017 for DepRefId is null issue*/
				}
				else
				{
					System.out.println("Values are Same.Procedure is not call");
				}
				/*End*/
				 //CommonUtils.setGlobalObject("GLOBAL.FC_AMT",PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT());
				 //CommonUtils.setGlobalObject("GLOBAL.LC_AMT",PT_IL_PREM_COLL_BEAN.getPC_LC_PAID_AMT());
			     if(pc_sysid==PT_IL_PREM_COLL_BEAN.getPC_SYS_ID().longValue()){
			      CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE","PD");
			     }else{
			    	 CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE","PC");
			     }
				 CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", policyBean.getPOL_CUST_EXCH_RATE());
				 CommonUtils.setGlobalVariable("GLOBAL.CURR_CODE" , policyBean.getPOL_CUST_CURR_CODE());
				 CommonUtils.setGlobalObject("GLOBAL.FC_AVLB_BAL_AMT " , PT_IL_PREM_COLL_BEAN.getPC_FC_AVLB_BAL_AMT());
			}
			} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void whenNewBlockInstance(){
		/*P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 


		IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		   :SYSTEM.MESSAGE_LEVEL := '10';
		   :CTRL.M_COMM_DEL := 'P';
		   POST;
		   :CTRL.M_COMM_DEL := NULL;
		   :PT_IL_POLICY.POL_CUST_CURR_CODE := :PT_IL_POLICY.POL_CUST_CURR_CODE ;
		   :SYSTEM.MESSAGE_LEVEL := 0;
		   
		END IF;*/
	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void onPopulateDetails(PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
			new PT_IL_LOAN_INT_COLL_DELEGATE().executeSelectStatement(compositeAction);
			new PT_IL_PREM_COLL_CHARGE_DELEGATE().executeSelectStatement(compositeAction);
			new PT_IL_BROKER_VALUES_DELEGATE().executeSelectStatement(compositeAction);
			new PT_AGENT_COMM_VALUES_DELEGATE().executeSelectStatement(compositeAction);
			new PT_IL_PREM_COLL_CVR_DTL_DELEGATE().executeSelectStatement(compositeAction);
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param PT_IL_PREM_COL_BEAN
	 * @throws Exception
	 */
	public void preDelete(PT_IL_PREM_COLL PT_IL_PREM_COL_BEAN) throws Exception{
		String C1 = "DELETE FROM PT_IL_LOAN_INT_COLL  WHERE LIC_PC_SYS_ID = ?";
		String C2 = "DELETE FROM PT_IL_PREM_COLL_CHARGE P  WHERE P.PCC_SYS_ID = ?";
		String C3 = "DELETE FROM PT_AGENT_COMM_VALUES P WHERE P.ACV_PC_SYS_ID = ?";
		try{
			CRUDHandler handler = new CRUDHandler();
			int i = handler.executeDeleteStatement(C1, CommonUtils.getConnection(),new Object[]{PT_IL_PREM_COL_BEAN.getPC_SYS_ID()});
			int j = handler.executeDeleteStatement(C2, CommonUtils.getConnection(),new Object[]{PT_IL_PREM_COL_BEAN.getPC_SYS_ID()});
			int k = handler.executeDeleteStatement(C3, CommonUtils.getConnection(),new Object[]{PT_IL_PREM_COL_BEAN.getPC_SYS_ID()});
			System.out.println(i+"j"+j+"k"+k);
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		
	}
	
	
	
	


    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PREM_GEN_YN-IN
      * @param P_BROK_GEN_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CHCK_BOUNCE_ACC_CANC(
                      Object P_POL_SYS_ID,
                      Object P_PC_SYS_ID,
				       Object P_PREM_GEN_YN,
				       Object P_BROK_GEN_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PREM_GEN_YN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BROK_GEN_YN);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CHCK_BOUNCE_ACC_CANC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
	 public void checkprvReceipt(PILT003_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		 
		 	Date M_PY_DT=null;
		 	ResultSet resultSet = null;
			CRUDHandler handler = new CRUDHandler();
			Connection connection = null;
			
	        try {
				connection = CommonUtils.getConnection();
				Object[] values = {compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID()};
				String C1 = " SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE  PC_PAID_DT IS NULL "+
								 " AND PC_PAID_FLAG NOT IN ('A') "+
								 	" AND PC_POL_SYS_ID = ? ";
		 
				resultSet=handler.executeSelectStatement(C1, connection, values);
			if(resultSet!=null){
				if(resultSet.next()){
					M_PY_DT=resultSet.getDate(1);
					
				}
			}
				
              if(M_PY_DT!=null){			
			if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SCHD_PYMT_DT().after(M_PY_DT)){
					
					SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String M_S_PY_DT=sdf.format(M_PY_DT);
					
					
					throw new Exception(
							 "Please collect the renewal premium for  " +  M_S_PY_DT);
				}
              }
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
	 }	
	 
	 public void WHEN_VALIDATE_PC_WAIVE_PREM_YN(PT_IL_PREM_COLL_ACTION action,
			String value) throws Exception{

		if ("Y".equalsIgnoreCase(value)
				&& "N".equalsIgnoreCase(action.getPT_IL_PREM_COLL_BEAN()
						.getPC_PAID_FLAG()) && action.getPT_IL_PREM_COLL_BEAN()
						.getPC_FC_UNPAID_PREM_INT() >0 ) {
			action.getPT_IL_PREM_COLL_BEAN().setPC_FLEX_06(
					action.getPT_IL_PREM_COLL_BEAN()
							.getPC_LC_UNPAID_WAIVE_PREM_INT().toString());
			action.getCOMP_PC_FC_UNPAID_WAIVE_PREM_INT().setDisabled(false);
			action.getCOMP_PC_LC_UNPAID_WAIVE_PREM_INT().setDisabled(false);
		} else if ("N".equalsIgnoreCase(value)
				&& "N".equalsIgnoreCase(action.getPT_IL_PREM_COLL_BEAN()
						.getPC_PAID_FLAG())) {
			PT_IL_PREM_COLL bean = action.getPT_IL_PREM_COLL_BEAN();
			if (bean.getPC_FLEX_06() != null) {
				
				Double val = CommonUtils.nvl(Double.parseDouble(bean
						.getPC_FLEX_06()), 0);
				// Double total = bean.getUI_M_LC_NET_PREM() - val;
				Double total = bean.getUI_M_LC_NET_PREM()
						+ bean.getPC_FC_UNPAID_WAIVE_PREM_INT();
				bean.setUI_M_LC_NET_PREM(CommonUtils.ROUND(total,3));
				bean.setUI_M_FC_NET_PREM(CommonUtils.ROUND(total,3));
				bean.setPC_FC_UNPAID_WAIVE_PREM_INT(val);
				bean.setPC_LC_UNPAID_WAIVE_PREM_INT(val);
			}
			action.getCOMP_PC_FC_UNPAID_WAIVE_PREM_INT().setDisabled(true);
			action.getCOMP_PC_LC_UNPAID_WAIVE_PREM_INT().setDisabled(true);
		}
	}
	 
	 public void WHEN_VALIDATE_PC_FC_UNPAID_WAIVE_PREM_INT(
			PT_IL_PREM_COLL_ACTION action, Double value) throws Exception {
		try {
			if (value < 0) {
				throw new Exception("Value cannot be less than Zero");
			}

			PT_IL_PREM_COLL bean = action.getPT_IL_PREM_COLL_BEAN();
			if ("Y".equalsIgnoreCase(bean.getPC_WAIVE_PREM_YN())) {
				Double currentPrem = CommonUtils.ROUND(CommonUtils.nvl(
						bean.getPC_LC_GROSS_PREM(), 0)
						+ CommonUtils
								.nvl(bean.getPC_LC_CHARGE(), 0)
						+ CommonUtils.nvl(bean
								.getPC_LC_UNPAID_PREM_INT(), 0),2);
				bean.setPC_LC_UNPAID_WAIVE_PREM_INT(value);
				Double total = currentPrem - value;
				bean.setUI_M_LC_NET_PREM(CommonUtils.ROUND(total,3));
				bean.setUI_M_FC_NET_PREM(CommonUtils.ROUND(total,3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	 
	 public Boolean validateOnClaimregister(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) throws Exception{
			ResultSet resultSet = null;
			CRUDHandler crudHandler = new CRUDHandler();
			Connection connection = null;
			String C1 = "SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = ? AND CLAIM_TYPE IN ('A','D')";
			try {
				connection = CommonUtils.getConnection();
				resultSet = crudHandler.executeSelectStatement(C1, connection, 
						new Object[]{PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID()});
				if(resultSet.next()){
					return true;
					//throw new Exception("Death Claim Already Registered Cannot Proceed");
				}
				else{
				   return false;
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			
		}

}
    


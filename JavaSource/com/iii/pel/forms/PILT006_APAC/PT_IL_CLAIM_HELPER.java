package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP016.PRINT_ACTION;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_HELPER {
    
	public static final Log log = LogFactory.getLog(PT_IL_CLAIM_HELPER.class);

	Map<String, Object> sessionMap = null;

	/**
	 * Preinsert the values.
	 * 
	 * @param ptClaim
	 * @throws Exception
	 */
	public void preInsert(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String C1 = "SELECT PIL_CLAIM_SYS_ID.NEXTVAL FROM DUAL";
		String C2 = "SELECT POL_SYS_ID,POL_SA_CURR_CODE FROM PT_IL_POLICY WHERE  POL_NO = ? "
				+ "AND POL_DS_TYPE = '2'";

		PILT006_APAC_PROCEDURE pt_il_claim_procedure = new PILT006_APAC_PROCEDURE();
		PT_IL_CLAIM PT_IL_CLAIM_BEAN = compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		CTRL CTRL_BEAN = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN();
		Object policyNo = PT_IL_CLAIM_BEAN.getCLAIM_POL_NO();
		String policy = "";
		
		
		
		if (policyNo != null) {
			policy = policyNo.toString();
		}else
		{
			throw new ValidatorException(new FacesMessage("Policy No is empty"));
		}
		pt_il_claim_procedure.L_CLAIM_VALID_POL_NO(policy, compositeAction);
		pt_il_claim_procedure.L_CLAIM_ASSR_VALID(PT_IL_CLAIM_BEAN,PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE());
		if (PT_IL_CLAIM_BEAN.getCLAIM_NO() != null) {
			pt_il_claim_procedure.L_UNIQUE_CLAIM_NO(PT_IL_CLAIM_BEAN);
		}

		ResultSet C2_REC = null;
		ResultSet C1_REC = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection);
			if (C1_REC.next()) {
				PT_IL_CLAIM_BEAN.setCLAIM_SYS_ID(C1_REC.getLong(1));
			}

			Object[] object = { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() };

			C2_REC = handler.executeSelectStatement(C2, connection, object);
			if (C2_REC.next()) {
				PT_IL_CLAIM_BEAN.setCLAIM_POL_SYS_ID(C2_REC
						.getLong("POL_SYS_ID"));
				PT_IL_CLAIM_BEAN.setUI_M_POL_SA_CURR_CODE(C2_REC
						.getString("POL_SA_cURR_CODE"));
			}

			PT_IL_CLAIM_BEAN.setCLAIM_DS_CODE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			PT_IL_CLAIM_BEAN.setCLAIM_CR_UID(CTRL_BEAN.getUI_M_USER_ID());
			PT_IL_CLAIM_BEAN.setCLAIM_CR_DT(new CommonUtils().getCurrentDate());

			

			/*Added by sankara narayanan for  Hands on feed back point num 16 in ZB on 05/03/2017*/
			if(PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()!=null && !PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP().equalsIgnoreCase("O"))
			{

				/*commneted by raja on 16-05-2017*/
				PT_IL_CLAIM_BEAN.setCLAIM_ADDL_STATUS("CL02");
				/*end*/
			
			}
			
			 /* end*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
		}

	}

	/**
	 * 
	 * @param pt_il_claim
	 * @throws Exception
	 */
	public void postInsert(PT_IL_CLAIM claimBean) throws Exception {
		String M_CLAIM_TYPE = null;
		try {
			Long P_POL_SYS_ID = claimBean.getCLAIM_POL_SYS_ID();
			Long P_CLM_SYS_ID = claimBean.getCLAIM_SYS_ID();
			String P_CLAIM_TYPE = claimBean.getCLAIM_TYPE();
			Date CLAIM_LOSS_DT = claimBean.getCLAIM_LOSS_DT();
			SimpleDateFormat df = new SimpleDateFormat(
					PELConstants.dbDateAndTimeFormat);
			Date P_EFF_DT = null;

			if ("A".equalsIgnoreCase(claimBean.getCLAIM_TYPE())) {
				M_CLAIM_TYPE = "D";
			} else {
				M_CLAIM_TYPE = claimBean.getCLAIM_TYPE();
			}

			if (CLAIM_LOSS_DT != null) {
				P_EFF_DT = CommonUtils.stringToUtilDate(df
						.format(CLAIM_LOSS_DT));
			}
			if (P_POL_SYS_ID != null && P_CLM_SYS_ID != null) {
				new PILT006_APAC_PROCEDURE().P_INS_CLM_DOLIST(P_POL_SYS_ID,
						P_CLM_SYS_ID, P_CLAIM_TYPE, P_EFF_DT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preUpdate() {
	}

	public void preBlock() {

		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE");
	}

	/**
	 * 
	 * @param claimBean
	 * @param dummyBean
	 * @throws Exception
	 */
	public void whenCreateRecord(PT_IL_CLAIM claimBean, DUMMY dummyBean)
			throws Exception {

		try {
			if (claimBean.getROWID() == null) {
				claimBean.setCLAIM_INTM_DT(new CommonUtils().getCurrentDate());
				claimBean.setCLAIM_TYPE("D");
				claimBean.setCLAIM_CLOSE_FLAG("N");
				claimBean.setCLAIM_STATUS("N");
				claimBean.setCLAIM_POL_VALID_YN("N");
				dummyBean.setM_AUTO_MAN_FLAG("X");
				dummyBean.setM_POLICY_YN_FL("X");
				dummyBean.setM_CLAIM_STATUS(null);
				dummyBean.setM_CONFIRM_FLAG("Y");
				dummyBean.setM_SUM_ASSURED(null);
				claimBean.setCLAIM_CR_DT(new CommonUtils().getCurrentDate());
				claimBean.setCLAIM_FRZ_FLAG("N");
			}

		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * When New Record Instance Created.
	 * 
	 * @param pilt006_apac_composite_action
	 */
	public void whenNewRecordInstance(
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_DEATH = null;
		String M_FLAG = null;
		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_DUMMY2 = null;
		String M_DUMMY_ST = null;
		Double M_ILCLMCUST = 0.0;
		String M_CS_STATUS_CODE = null;
		String M_PS_CODE_DESC = null;
		String M_DS_CLM_PARSET = null;
		String M_DS_CLM_FULSET = null;
		String M_CHECK = null;
		String M_UWQ = null;
		String M_COUNT_2 = null;

		String FLAG = "SELECT POL_FAC_YN FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ";

		String C_DEATH = "SELECT PS_CODE FROM	PP_SYSTEM WHERE  PS_TYPE = 'IL_DEATH'";

		String C1 = "SELECT 1 FROM  PM_IL_CLM_REPAY WHERE  CR_COVER_CODE IN "
				+ "(SELECT  POAC_COVER_CODE  FROM PT_IL_POL_ADDL_COVER "
				+ "WHERE   POAC_POL_SYS_ID = ? "
				+ "UNION SELECT  POL_PLAN_CODE " + "FROM  PT_IL_POLICY "
				+ "WHERE POL_SYS_ID  = ? ) AND CR_LOSS_TYPE = ? ";

		String C2 = "SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS WHERE  NVL(CCD_FRZ_FLAG,'N') = 'Y' "
				+ "AND CCD_CLAIM_SYS_ID = ? ";

		String C3 = "SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS WHERE  CCD_CLAIM_SYS_ID = ? ";

		String C4 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE = 'ILCLMCUST' ";

		String C5 = "SELECT CS_STATUS_CODE FROM PT_IL_CLAIM_STATUS WHERE "
				+ "CS_SYS_ID = (SELECT MAX(CS_SYS_ID) FROM PT_IL_CLAIM_STATUS WHERE  CS_CLM_SYS_ID = ? ) ";

		String C6 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ADDL_STAT' AND PS_CODE =  ? ";

		String C7 = "SELECT 'X' FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? AND CP_APPR_FLAG IN('A','R') AND CP_CLM_PAID_STATUS = 'A'";

		String C9 = "SELECT DS_CLM_PARSET, DS_CLM_FULSET FROM PM_IL_DOC_SETUP WHERE DS_CODE = ? ";

		ResultSet FLAG_REC = null;
		ResultSet C_DEATH_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C9_REC = null;

		try {

			PT_IL_CLAIM_ACTION claimAction = compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN();
			PT_IL_CLAIM claimBean = claimAction.getPT_IL_CLAIM_BEAN();
			DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
			DUMMY dummyBean = dummyAction.getDUMMY_BEAN();

			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			
			///COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK/
			
			/*if (dummyBean.getM_CALC_METHOD() == 2) {
				if ("Y".equals(CommonUtils.nvl(claimBean.getCLAIM_FRZ_FLAG(),
						"N"))) {
					dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				} else {
					dummyAction.getCOMP_UI_M_BUT_SETTLEMENT()
							.setDisabled(false);
				}
			}
*/
			C_DEATH_REC = handler.executeSelectStatement(C_DEATH, connection);
			if (C_DEATH_REC.next()) {
				M_DEATH = C_DEATH_REC.getString("PS_CODE");
			}

			Object[] flagObj = { claimBean.getCLAIM_SYS_ID() };
			FLAG_REC = handler
					.executeSelectStatement(FLAG, connection, flagObj);
			if (FLAG_REC.next()) {
				M_FLAG = FLAG_REC.getString("POL_FAC_YN");
			}

			Object[] c1_Obj = { claimBean.getCLAIM_SYS_ID(),
					claimBean.getCLAIM_SYS_ID(), M_DEATH };
			C1_REC = handler.executeSelectStatement(C1, connection, c1_Obj);
			if (C1_REC.next()) {
				M_COUNT_2 = C1_REC.getString(1);
			}

			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			
			if ((dummyBean.getM_CALC_METHOD() == 1 ||dummyBean.getM_CALC_METHOD() == 2)
					&& "Y".equalsIgnoreCase(dummyBean.getCLAIM_CLOSE_FLAG())) {
				dummyAction.getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
				dummyBean.setM_CLOSE_FLAG("Closed");
			} else {
				dummyAction.getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
				dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
				dummyBean.setM_CLOSE_FLAG("Open");
			}

			if (claimBean.getROWID() != null) {
				if ("Y".equalsIgnoreCase(claimBean.getCLAIM_FRZ_FLAG())) {
					claimAction.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
				} else {
					claimAction.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
					dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);

					Object[] c3_Obj = { claimBean.getCLAIM_SYS_ID() };
					C3_REC = handler.executeSelectStatement(C3, connection,
							c3_Obj);
					if (C3_REC.next()) {
						M_DUMMY = C3_REC.getString(1);
						claimAction.getCOMP_CLAIM_TYPE().setDisabled(true);
					} else {
						claimAction.getCOMP_CLAIM_TYPE().setDisabled(false);
					}
				}
			} else {
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				claimAction.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(false);
			}

			Object[] c2_Obj = { claimBean.getCLAIM_SYS_ID() };
			C2_REC = handler.executeSelectStatement(C2, connection, c2_Obj);
			if (C2_REC.next()) {
				M_DUMMY2 = C2_REC.getString(1);
				if ("N".equals(CommonUtils.nvl(claimBean.getCLAIM_CLOSE_FLAG(),
						"N"))) {
					dummyAction.getCOMP_UI_M_BUT_SETTLEMENT()
							.setDisabled(false);
					dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(
							false);
				}
			} else {
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
			}

			dummyBean.setM_POL_SYS_ID(claimBean.getCLAIM_POL_SYS_ID());
			PILT006_APAC_PROCEDURE claimProcedure = new PILT006_APAC_PROCEDURE();
			claimProcedure.L_VALUE_FETCH(compositeAction);

			C4_REC = handler.executeSelectStatement(C4, connection);
			if (C4_REC.next()) {
				M_ILCLMCUST = C4_REC.getDouble("PS_VALUE");
			}
			/*commented by sujatha to disable that field
			/*if (M_ILCLMCUST == 1) {
				claimAction.getCOMP_CLAIM_ACCNT_PAY_CODE().setDisabled(true);
			} else {
				claimAction.getCOMP_CLAIM_ACCNT_PAY_CODE().setDisabled(false);
			}*/

			Object[] c5_Obj = { claimBean.getCLAIM_SYS_ID() };
			C5_REC = handler.executeSelectStatement(C5, connection, c5_Obj);
			if (C5_REC.next()) {
				M_CS_STATUS_CODE = C5_REC.getString("CS_STATUS_CODE");
			}
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.

			if (dummyBean.getM_CALC_METHOD() == 1 || dummyBean.getM_CALC_METHOD() == 2) {
				Object[] c6_Obj = { claimBean.getCLAIM_DS_CODE() };
				C6_REC = handler.executeSelectStatement(C6, connection, c6_Obj);
				if (C6_REC.next()) {
					M_PS_CODE_DESC = C6_REC.getString("PS_CODE_DESC");
					
					System.out.println("M_PS_CODE_DESC  1             "+M_PS_CODE_DESC);
					
					dummyBean.setUI_M_CLAIM_ADDL_STATUS(M_PS_CODE_DESC);
					
					System.out.println("getUI_M_CLAIM_ADDL_STATUS  1             "+dummyBean.getUI_M_CLAIM_ADDL_STATUS());
					
					
				}

				if ("C".equalsIgnoreCase(M_CS_STATUS_CODE)) {
					// dummyAction.disableAllComponent(true);
					claimAction.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
				} else {
					claimAction.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
				}
			}

			claimProcedure.L_ED_SETTL_BUT(claimAction);
			claimProcedure.IL_QUERY_DISABLE();

			Object[] c7_Obj = { claimBean.getCLAIM_SYS_ID() };
			C7_REC = handler.executeSelectStatement(C7, connection, c7_Obj);
			if (C7_REC.next()) {
				M_DUMMY1 = C7_REC.getString(1);
				claimAction.getCOMP_CLAIM_LC_RLA_AMOUNT().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
			}

			Object[] c9_Obj = { claimBean.getCLAIM_DS_CODE() };
			C9_REC = handler.executeSelectStatement(C9, connection, c9_Obj);
			if (C9_REC.next()) {
				M_DS_CLM_PARSET = C9_REC.getString("DS_CLM_PARSET");
				M_DS_CLM_FULSET = C9_REC.getString("DS_CLM_FULSET");
			}

			if ("CL05".equalsIgnoreCase(M_CS_STATUS_CODE)) {
				claimAction.disableAllComponent(true);
				//claimAction.getCOMP_UI_M_BUT_FRZ().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(true);
			} else {
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(false);
			}

			if (M_DS_CLM_PARSET != null && M_DS_CLM_FULSET != null) {
				if ("CL05".equalsIgnoreCase(claimBean.getCLAIM_ADDL_STATUS())
						|| M_DS_CLM_PARSET.equalsIgnoreCase(claimBean
								.getCLAIM_ADDL_STATUS())
						|| M_DS_CLM_FULSET.equalsIgnoreCase(claimBean
								.getCLAIM_ADDL_STATUS())) {
					claimAction.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
							.disableAllComponent(true);
				}
				if (!"CL05".equalsIgnoreCase(claimBean.getCLAIM_ADDL_STATUS())) {
					claimAction.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.disableAllComponent(true);
				}
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
			CommonUtils.closeCursor(FLAG_REC);
			CommonUtils.closeCursor(C_DEATH_REC);
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C9_REC);
		}
	}

	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @throws Exception
	 */
	public void postQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		CTRL controlBean = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN();
		PILT006_APAC_PROCEDURE claimProcedure = new PILT006_APAC_PROCEDURE();

		String M_DUMMY = null;
		String M_FLAG = null;
		String M_DUMMY_ST = null;
		String M_DUMMY1 = null;
		Long M_CS_SYS_ID = null;
		String M_CS_STATUS_CODE = null;
		String M_DESC = null;
		String M_TEMP = null;
		String M_PLAN_TYPE = null;
		String M_DS_CLM_PARSET = null;
		String M_DS_CLM_FULSET = null;

		String C1 = "SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS WHERE  NVL(CCD_FRZ_FLAG,'N') = 'Y' "
				+ "AND CCD_CLAIM_SYS_ID = ? ";

		String FLAG = "SELECT POL_FAC_YN FROM   PT_IL_POLICY WHERE POL_SYS_ID = ? ";
		String C2 = "SELECT MAX(CS_SYS_ID) FROM PT_IL_CLAIM_STATUS WHERE  "
				+ "CS_CLM_SYS_ID = ? ";

		String C3 = "SELECT CS_STATUS_CODE FROM PT_IL_CLAIM_STATUS "
				+ "WHERE CS_CLM_SYS_ID = ? AND CS_SYS_ID = ?";

		String C4 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ADDL_STAT' "
				+ "AND PS_CODE = ?";

		String C1A = " SELECT 'X' FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID= ? "
				+ "AND ASD_CODE = 'CLM_CLO_OPEN' AND ASD_CHAR_VALUE ='Y'";

		String C5 = " SELECT  PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE IN (SELECT POL_PLAN_CODE "
				+ "FROM PT_IL_POLICY WHERE  POL_NO = ? )";

		String C7 = "SELECT DS_CLM_PARSET, DS_CLM_FULSET FROM PM_IL_DOC_SETUP WHERE DS_CODE = ?";

		String C8 = "SELECT CP_CLM_PAID_STATUS  FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? ";
		
		
		ResultSet C2_REC = null;
		ResultSet C1_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C7_REC = null;
		ResultSet C1A_REC = null;
		ResultSet FLAG_REC = null;
		ResultSet C8_REC = null;
		try {
			sessionMap = getSessionMap();
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			Object[] object = { claimBean.getCLAIM_SYS_ID() };
			C2_REC = handler.executeSelectStatement(C2, connection, object);
			if (C2_REC.next()) {
				M_CS_SYS_ID = C2_REC.getLong(1);
			}

			Object[] object2 = { claimBean.getCLAIM_SYS_ID(), M_CS_SYS_ID };
			C3_REC = handler.executeSelectStatement(C3, connection, object2);
			if (C3_REC.next()) {
				M_CS_STATUS_CODE = C3_REC.getString("CS_STATUS_CODE");
			}

			Object[] object4 = { M_CS_STATUS_CODE };
			if (dummyBean.getM_CALC_METHOD() == 2) {
				C4_REC = handler
						.executeSelectStatement(C4, connection, object4);
				if (C4_REC.next()) {
					/* added by gopi for ssp call ZBILQC-1721875 on 04/03/17*/
					dummyBean.setCS_STATUS_CODE(M_CS_STATUS_CODE);
					
					System.out.println("getCS_STATUS_CODE 2            "+dummyBean.getCS_STATUS_CODE());
					
					
					//COMMENTED BY AKASH TO UPDATE ADDL STATUS
					dummyBean.setUI_M_CLAIM_ADDL_STATUS(M_CS_STATUS_CODE
							+ ":- " + C4_REC.getString("PS_CODE_DESC"));
					/*dummyBean.setUI_M_CLAIM_STATUS(M_CS_STATUS_CODE + ":- "
							+ C4_REC.getString("PS_CODE_DESC"));*/
					
					System.out.println("getUI_M_CLAIM_ADDL_STATUS 2            "+dummyBean.getUI_M_CLAIM_ADDL_STATUS());
					
					
					
				} else {
					dummyBean.setUI_M_CLAIM_STATUS("Registered");
				}
			} else {
				C4_REC = handler
						.executeSelectStatement(C4, connection, object4);
				if (C4_REC.next()) {
					M_DESC = C4_REC.getString("PS_CODE_DESC");
					
					System.out.println("M_DESC 2            "+M_DESC);
					
					
					dummyBean.setUI_M_CLAIM_ADDL_STATUS(M_CS_STATUS_CODE
							+ ":- " + M_DESC);
					System.out.println("getUI_M_CLAIM_ADDL_STATUS 3           "+dummyBean.getUI_M_CLAIM_ADDL_STATUS());
					
					
				} else {
					dummyBean.setUI_M_CLAIM_STATUS("Registered");
				}
			}

			Object[] cia = { controlBean.getUSER_ID() };
			C1A_REC = handler.executeSelectStatement(C1A, connection, cia);
			if (C1A_REC.next()) {
				M_TEMP = C1A_REC.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
				if ("Y".equalsIgnoreCase(claimBean.getCLAIM_CLOSE_FLAG())) {
					C8_REC = new CRUDHandler().executeSelectStatement(C8,
							CommonUtils.getConnection(),
							new Object[] { claimBean.getCLAIM_SYS_ID() });
					if (!(C8_REC.next())) {
						dummyAction.getCOMP_UI_M_BUT_REOPEN()
								.setDisabled(false);
					}

					dummyAction.getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
				}
			else {
				dummyAction.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
			}
			}
			Object[] flag = { claimBean.getCLAIM_SYS_ID() };
			FLAG_REC = handler.executeSelectStatement(FLAG, connection, flag);
			if (FLAG_REC.next()) {
				M_DUMMY = FLAG_REC.getString(1);
			}

			if ("C".equalsIgnoreCase(M_CS_STATUS_CODE)) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			} else if ("N".equals(CommonUtils.nvl(claimBean
					.getCLAIM_CLOSE_FLAG(), "N"))) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(false);
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			}

			if ("P".equalsIgnoreCase(M_CS_STATUS_CODE)
					&& "N".equals(CommonUtils.nvl(claimBean
							.getCLAIM_CLOSE_FLAG(), "N"))) {
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			} else {
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			}
			dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);

			Object[] c1 = { claimBean.getCLAIM_SYS_ID() };
			C1_REC = handler.executeSelectStatement(C1, connection, c1);
			if (C1_REC.next()) {
				M_DUMMY1 = C1_REC.getString(1);
			}

			if (M_DUMMY1 != null
					&& "N".equals(CommonUtils.nvl(claimBean
							.getCLAIM_CLOSE_FLAG(), "N"))) {
				dummyAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				dummyAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
			}
			claimProcedure.L_CLAIM_VALID_POL_NO_1(dummyAction.getDUMMY_BEAN());
			claimProcedure.L_VALUE_FETCH(compositeAction);
			claimProcedure.L_CLAIM_ASSR_DESC(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN());

			DBProcedures procedures = new DBProcedures();

			List<String> currList = procedures.P_VAL_CURR(claimBean
					.getCLAIM_CURR_CODE(), "N", "N", claimBean
					.getCLAIM_CUST_CODE());
			if (currList != null && !currList.isEmpty()) {
				claimBean.setUI_M_CLAIM_CURR_CODE_DESC(currList.get(0));
			}
			if (claimBean.getCLAIM_CUST_CODE() != null) {
			
/*Modified by Janani on 19.06.2017 for ZBILQC-1722179 */
				
				/*List<String> custList = procedures.helperP_VAL_CLASS_CUST(
						"CUSTOMER", CommonUtils.getProcedureValue(claimBean
								.getCLAIM_CUST_CODE()), "N", "N");*/
				
			
				List<String> custList = procedures.helperP_VAL_CUST_NAME(
						claimBean.getCLAIM_CUST_CODE(),claimBean.getUI_M_CUST_DESC(), 
						"N", "N",CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));
							
				/*End*/
						
				
				if (custList != null && !custList.isEmpty()) {
					claimBean.setUI_M_CUST_DESC(custList.get(0));
				}
			}

			if (claimBean.getCLAIM_ACCNT_PAY_CODE() != null) {
				
				

				/*Modified by Janani on 19.06.2017 for ZBILQC-1722179 */
				
				/*List<String> acctList = procedures.helperP_VAL_CLASS_CUST(
						"CUSTOMER", CommonUtils.getProcedureValue(claimBean
								.getCLAIM_ACCNT_PAY_CODE()), "N", "N");*/
				
			
				List<String> acctList = procedures.helperP_VAL_CUST_NAME(
						claimBean.getCLAIM_ACCNT_PAY_CODE(),claimBean
						.getUI_M_CLAIM_ACCNT_PAY_CODE_DESC() , "N", "N",CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));
							
				/*End*/
				
				
				
				
				
				if (acctList != null && !acctList.isEmpty()) {
					claimBean
							.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(acctList.get(0));
				}
			}

			// pt_il_claim_procedure.L_ED_SETTL_BUT(pilt006_apac_composite_action);
			claimProcedure.L_ED_SETTL_BUT(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN());

			if ("Y".equals(CommonUtils
					.nvl(claimBean.getCLAIM_CLOSE_FLAG(), "N"))) {
				dummyBean.setCLAIM_CLOSE_FLAG("Y");
				dummyBean.setUI_M_CLOSE_FLAG("Closed");
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
						.disableAllComponent(true);

			} else {
				dummyBean.setCLAIM_CLOSE_FLAG("N");
				dummyBean.setUI_M_CLOSE_FLAG("Open");
			}
			// sessionMap.put("CLAIM_TYPE", pt_il_claim.getCLAIM_TYPE());//
			// Session
			CommonUtils.setGlobalVariable("GLOBAL.CLAIM_TYPE", claimBean
					.getCLAIM_TYPE());
			if ("A".equals(claimBean.getCLAIM_TYPE())) {
				dummyAction.getM_BUTT_ACC_FIR_DTLS().setDisabled(true);

				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_MED_CODE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_MED_CODE().setRendered(true);
				/*compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_MED_CODE().setRequired(true);*/
			} else {
				dummyAction.getM_BUTT_ACC_FIR_DTLS().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_MED_CODE().setDisabled(true);
			}

			if (claimBean.getCLAIM_MED_CODE() != null) {
				List<String> medList = procedures.helperP_VAL_CUST(claimBean
						.getCLAIM_MED_CODE(), "N", "N");
				if (medList != null && !medList.isEmpty()) {
					claimBean.setUI_M_CLAIM_MED_CODE_NAME(medList.get(0));
				}
			}

			Object[] obj5 = { claimBean.getCLAIM_POL_NO() };
			C5_REC = handler.executeSelectStatement(C5, connection, obj5);
			if (C5_REC.next()) {
				M_PLAN_TYPE = C5_REC.getString("PLAN_TYPE");
			}

			if ("M".equalsIgnoreCase(M_PLAN_TYPE)
					&& ("A".equalsIgnoreCase(claimBean.getCLAIM_TYPE()) || "D"
							.equalsIgnoreCase(claimBean.getCLAIM_TYPE()))) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_LC_RLA_AMOUNT().setDisabled(false);

			} else {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_LC_RLA_AMOUNT().setDisabled(true);
			}

			if (claimBean.getCLAIM_PCI_REF_NO() != null) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_POL_NO().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PRE_CLAIM_DTLS().setDisabled(false);
			} else {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_POL_NO().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PRE_CLAIM_DTLS().setDisabled(true);
			}

			if (claimBean.getCLAIM_NO() != null) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_NO()
						.setDisabled(true);
			}
			if (claimBean.getCLAIM_PCI_REF_NO() != null) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_CLAIM_PCI_REF_NO().setDisabled(true);
			}

			Object[] obj7 = { claimBean.getCLAIM_DS_CODE() };
			C7_REC = handler.executeSelectStatement(C7, connection, obj7);
			if (C7_REC.next()) {
				M_DS_CLM_PARSET = C7_REC.getString("DS_CLM_PARSET");
				M_DS_CLM_FULSET = C7_REC.getString("DS_CLM_FULSET");
			}
			if ("CL05".equalsIgnoreCase(M_CS_STATUS_CODE)) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(false);
			}
			List<String> list = new ArrayList<String>();
			list.add("CL05");
			list.add(M_DS_CLM_PARSET);
			list.add(M_DS_CLM_FULSET);

			if (list.contains(claimBean.getCLAIM_ADDL_STATUS())) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
						.disableAllComponent(true);
			}

			if ("CL05".equalsIgnoreCase(claimBean.getUI_M_CLAIM_ADDL_STATUS())) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(true);
			}
			//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
			if(M_CS_STATUS_CODE!=null && M_CS_STATUS_CODE.equalsIgnoreCase("CL05")){
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(true);	
			}else{
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(false);
			}
			compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().setCS_STATUS_CODE(M_CS_STATUS_CODE);
			//end
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException("Exception", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Exception" + e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C1A_REC);
			CommonUtils.closeCursor(FLAG_REC);
		}

	}

	/*
	 * Delete the current instance
	 * 
	 */
	public void preDelete(PT_IL_CLAIM claimBean) throws Exception {
		String DELETE_QUERY = "DELETE PT_IL_CLAIM_ESTIMATE WHERE CE_CLAIM_SYS_ID = ? ";
		String DELETE_QUERY1 = "DELETE PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_CLM_SYS_ID = ? ";
		String DELETE_QUERY2 = "DELETE PT_IL_CLAIM_STATUS WHERE  CS_CLM_SYS_ID = ? ";
		String DELETE_QUERY3 = "DELETE PT_IL_CLAIM_COVER_DTLS WHERE  CCD_CLAIM_SYS_ID = ? ";
		String DELETE_QUERY4 = "DELETE PT_IL_CLAIM_ACC_FIR_DTLS WHERE CAFD_CLAIM_SYS_ID = ? ";
		String DELETE_QUERY5 = "DELETE PT_IL_CLAIM_STATUS WHERE P.CS_CLM_SYS_ID =? ";
		try {
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY1, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY2, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY3, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY4, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
			new CRUDHandler().executeDeleteStatement(DELETE_QUERY5, CommonUtils
					.getConnection(), new Object[] { claimBean
					.getCLAIM_SYS_ID() });
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action)
			throws Exception {
		String M_TEMP = null;
		String C1 = "SELECT 'X' FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? "
				+ "AND  NVL(CP_APPR_FLAG,'N')IN ('A' ,'R') AND   NVL(CP_CLM_PAID_STATUS,'N')='A'";
		ResultSet C1_REC = null;

		if (pilt006_apac_composite_action.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID() != null) {
			try {
				Connection con = CommonUtils.getConnection();
				C1_REC = getHandler().executeSelectStatement(
						C1,
						con,
						new Object[] { pilt006_apac_composite_action
								.getPT_IL_CLAIM_ACTION_BEAN()
								.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID() });

				if (C1_REC.next()) {
					M_TEMP = C1_REC.getString(1);
				}
				if ("X".equals(CommonUtils.nvl(M_TEMP, "N"))) {
					pilt006_apac_composite_action.getPT_IL_CLAIM_ACTION_BEAN()
							.disableAllComponent(true);
					pilt006_apac_composite_action
							.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
				}

			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				CommonUtils.closeCursor(C1_REC);
			}
		}
	}

	/**
	 * It validates the claim Ref number is correct or not.
	 * 
	 * @param pilt006_apac_composite_action
	 *            composite.
	 * @param value
	 *            value.
	 * @throws Exception
	 */
	public void whenValidateClaimRefNo(
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN, Object value,PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_PCI_CLAIM_TYPE = null;
		Date M_PCI_LOSS_DT = null;
		Date M_PCI_REPORT_DT = null;
		String M_PCI_ADDL_STATUS = null;
		String PCI_POL_NO = null;
		String M_CUST_CODE=null;
		String M_ASSR_CODE=null;
		String M_DUMMY = null;
		ResultSet C3_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet query_rs=null;
		ResultSet C4_REC=null;
		//Added By Dhinesh 07-09-2016 for this call id : FALCONQC-1716916
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		String  POL_SYS_ID=null;
		String M_PCI_POL_NO=null;
		/*End*/
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		
		PT_IL_CLAIM claimBean = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN();
		
		
		/*
		 * 
		 *  CHANGED BY SANKARA NARAYANAN  ON 18/03/2017
		 * 
		 * String C1 = "SELECT PCI_CLAIM_TYPE, PCI_LOSS_DT, PCI_REPORT_DT,PCI_POL_NO,PCI_ASSRD_CODE "
				+ "FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_REF_NO  = ? ";*/
		
		// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		String C1 = "SELECT * FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_REF_NO  = ? ";
//end
		String C2 = "SELECT PCI_ADDL_STATUS FROM PT_IL_PRE_CLAIMS_INFO WHERE  PCI_REF_NO = ? ";

		String C3 = "SELECT 'X' FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_REF_NO = ? ";
		String C4 = "SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_PCI_REF_NO = ?";
		
		String C5="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		String C6="SELECT 'X' FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID=?";

		if (value != null && !"".equalsIgnoreCase(value.toString())) {
			try {
				Object[] values = { value };
				Connection con = CommonUtils.getConnection();
				C3_REC = getHandler().executeSelectStatement(C3, con, values);
				if (C3_REC.next()) {
					M_DUMMY = C3_REC.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Not a Valid Pre Claims Number" }));
				}
				
				
				
				
				C4_REC = getHandler().executeSelectStatement(C4, con, values);	
				String curvalue = (String)value;
					if(!curvalue.equalsIgnoreCase(claimBean.getCLAIM_PCI_REF_NO())){
				if(C4_REC.next()){
					throw new Exception("Claim Already registered for this Preclaim No");
				}
				}
					
				C2_REC = getHandler().executeSelectStatement(C2, con, values);
				while (C2_REC.next()) {
					M_PCI_ADDL_STATUS = C2_REC.getString("PCI_ADDL_STATUS");
				}
				if ("R".equalsIgnoreCase(M_PCI_ADDL_STATUS)) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Cannot Proceed - Pre Claims entry is Rejected" }));
				}

				   /*    Added By Dhinesh 08.09.2016 for this call id : FALCONQC-1716916 	*/   
			       
				Object[] M_PCI_REF_NO = { value.toString() };
				C5_REC = getHandler().executeSelectStatement(C1, con, M_PCI_REF_NO);
				if (C5_REC.next()) {
					M_PCI_POL_NO = C5_REC.getString("PCI_POL_NO");
				}
				System.out.println("M_PCI_POL_NO    :  "+M_PCI_POL_NO);
				Object[] M_POL_No = { M_PCI_POL_NO.toString() };
				C5_REC = getHandler().executeSelectStatement(C5, con, M_POL_No);
				if (C5_REC.next()) {
					POL_SYS_ID = C5_REC.getString("POL_SYS_ID");
				}
				System.out.println("POL_SYS_ID   :  "+POL_SYS_ID);
				Object[] M_POL_BEN_SIZE = { POL_SYS_ID.toString() };
				C6_REC = getHandler().executeSelectStatement(C6, con, M_POL_BEN_SIZE);
				System.out.println("M_POL_BEN_SIZE    :  "+M_POL_BEN_SIZE);
				if (C6_REC.next()) {
					POL_SYS_ID = C6_REC.getString(1);
				}
				else {

				/*	
				 * 
				 * cOMMENTED BY SANKARA NARAYANAN on 18/03/2017 for zb pre claim issue
				 * 
				 * throw new Exception(" There is no Beneficiary for this policy no. ");*/
				PT_IL_CLAIM_ACTION_BEAN.getWarningMap().put("current","Benificiary Details Not Available For This Policy Cannot Proceed");
				}
				/*End*/
				
				
				C1_REC = getHandler().executeSelectStatement(C1, con, values);
				while (C1_REC.next()) {/*
					M_PCI_CLAIM_TYPE = C1_REC.getString("PCI_CLAIM_TYPE");
					M_PCI_REPORT_DT = C1_REC.getDate("PCI_REPORT_DT");
					M_PCI_LOSS_DT = C1_REC.getDate("PCI_LOSS_DT");
					PCI_POL_NO = C1_REC.getString("PCI_POL_NO");
					M_ASSR_CODE = C1_REC.getString("PCI_ASSRD_CODE");
					claimBean.setCLAIM_TYPE(M_PCI_CLAIM_TYPE);
					claimBean.setCLAIM_LOSS_DT(M_PCI_LOSS_DT);
					claimBean.setCLAIM_POL_NO(PCI_POL_NO);
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_TYPE()
							.setSubmittedValue(M_PCI_CLAIM_TYPE);
					PT_IL_CLAIM_ACTION_BEAN
							.getCOMP_CLAIM_LOSS_DT()
							.setSubmittedValue(
									CommonUtils
											.dateToPELStringFormatter(M_PCI_LOSS_DT));
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_POL_NO()
							.setSubmittedValue(PCI_POL_NO);
					claimBean.setCLAIM_ASSR_CODE(M_ASSR_CODE);
				*/
	
				
					claimBean.setCLAIM_TYPE(C1_REC.getString("PCI_CLAIM_TYPE"));
					claimBean.setCLAIM_LOSS_DT(C1_REC.getDate("PCI_LOSS_DT"));
					claimBean.setCLAIM_POL_NO(C1_REC.getString("PCI_POL_NO"));
					/*Commentted by saritha on 01-11-2017 */
					//claimBean.setCLAIM_ASSR_CODE(C1_REC.getString("PCI_ASSRD_CODE"));
					
					claimBean.setUI_M_CLAIM_ASS_NAME("");
					claimBean.setCLAIM_INTM_DT(C1_REC.getDate("PCI_REPORT_DT"));
					claimBean.setCLAIM_ASSRD_REF_ID1(C1_REC.getString("PCI_ASSRD_REF_ID1"));
					
					/*Added by saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
					claimBean.setCLAIM_CLAIMANT_CODE(C1_REC.getString("PCI_INTIMATOR_NAME"));
					claimBean.setCLAIM_INT_MOBILE(C1_REC.getString("PCI_INTIMATOR_MOBILE"));
					claimBean.setCLAIM_INT_EMAIL(C1_REC.getString("PCI_INTIMATOR_EMAIL"));
					/*End*/
					
					/*Commentted by saritha on 30-10-2017 for ssp call id ZBLIFE-1445282*/
					//claimBean.setCLAIM_MEMB_CODE(C1_REC.getString("PCI_ASSRD_CODE"));
					/*End*/
					
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_POL_NO()
					.setSubmittedValue(claimBean.getCLAIM_POL_NO());
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_TYPE()
					.setSubmittedValue(claimBean.getCLAIM_TYPE());
			PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LOSS_DT()
					.setSubmittedValue(CommonUtils
									.dateToPELStringFormatter(claimBean.getCLAIM_LOSS_DT()));
			PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_ASSR_CODE().setSubmittedValue(claimBean.getCLAIM_ASSR_CODE());
					
					fetchPolicyAddress(PT_IL_CLAIM_ACTION_BEAN,"POL_NO",claimBean.getCLAIM_POL_NO());
				
				}
				
				if (value != null) {
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_POL_NO().setDisabled(
							false);
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_BUT_PRE_CLAIM_DTLS()
							.setDisabled(false);
					
				} else {
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_POL_NO().setDisabled(
							true);
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_BUT_PRE_CLAIM_DTLS()
							.setDisabled(true);
				}
				
				
				} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}catch(Exception e){
				e.printStackTrace();
				throw e;
				//throw new Exception(e.getMessage());
				
			
			}finally {
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
				CommonUtils.closeCursor(C4_REC);
				CommonUtils.closeCursor(C5_REC);
				CommonUtils.closeCursor(C6_REC);
				CommonUtils.closeCursor(C7_REC);
				//CommonUtils.closeCursor(C8_REC);
			}

		}

	}

	private void setPlanType(String planType) {
		// TODO Auto-generated method stub
		
	}

	

	/**
	 * TODO
	 */

	public void CLAIM_PCI_REF_NO_LOV() {

	}

	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 */
	public void whenValidateClaimPolicyNo(PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			DUMMY DUMMY_BEAN, String value,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PILT006_APAC_PROCEDURE pt_il_claim_procedure = new PILT006_APAC_PROCEDURE();
		String M_PLAN_TYPE = null;
		String M_POL_STATUS = null;
		
		String C1 = "SELECT CURR_NAME FROM   PM_CURRENCY WHERE  CURR_CODE = ? ";
		String C2 = "SELECT  PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = (SELECT POL_PLAN_CODE FROM PT_IL_POLICY"
				+ "WHERE  POL_NO = ?)";
		String C3 = "SELECT POL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		String C4 = "SELECT POL_JOINT_LIFE_YN,POL_SYS_ID,POL_APPRV_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		String C5 = "SELECT POAD_TYPE FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_ASSR_CODE = ? AND " +
					"POAD_POL_SYS_ID = ? ";
		String C0 = "SELECT CLAIM_SYS_ID FROM PT_IL_CLAIM WHERE CLAIM_POL_NO=? AND CLAIM_TYPE='D' ";
		String C6 = "SELECT CLAIM_SYS_ID FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = ? AND CLAIM_ASSR_CODE = ? AND CLAIM_TYPE = ? ";
		String C7 = "select 'X' from pt_il_policy where pol_no = ? and NVL(pol_ri_close_flag,'N') <> 'Y' AND "
				+ "NVL(pol_fac_close_flag,'N') <> 'Y'";
		
		String C8 = "SELECT 'X' FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ?";
		
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		String C10 = "SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO= ?";
		String C11 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String C12 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =?  AND" +
					" ASD_CODE = 'PRE_LAP_POL' AND " +
					" ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE";
		String C13="SELECT POL_APPRV_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		
		/*End*/
		
		/*Added by Janani on 17.07.2017 as per Sivarams suggestion*/
	
		String C14="SELECT * FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
		String C15="SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String C17="SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT WHERE PROD_CODE= ?";
		
	    /*eND*/	
	
		ResultSet C0_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null; 
		ResultSet C7_REC = null; 
		ResultSet rst8   = null;
		String jointYN  = null;
		Long polSysId = null;
		String assrType = null;
		String status = null;
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		ResultSet rs2 = null; 
		ResultSet rs3 = null; 
		ResultSet rs4 = null; 
		String ASD_CHAR_VALUE =null;
		String M_POL_ADDL_STATUS = null;
		String POL_PROD_CODE= null;
		String POL_SYS_ID =null;
	
		/*End*/
		
		/*Added by Janani on 17.07.2017 as per Sivarams suggestion*/
		
		ResultSet C14_REC = null;
		ResultSet C15_REC = null;
		ResultSet C17_REC = null;
		String PLAN_CODE = null;
		String PLAN_TYPE = null;
		String UNIT_LINK_TYPE = null;
		/*eND*/
		
		try {
			
			Object[] values = { value };
			Connection connection = CommonUtils.getConnection();
			C4_REC = getHandler().executeSelectStatement(C4, connection, new Object[]{value});
			C7_REC =getHandler().executeSelectStatement(C7, connection, values);
			
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			rs2= getHandler().executeSelectStatement(C10, connection,
					new Object[] {value});
			while (rs2.next()) {
				POL_PROD_CODE = rs2.getString("POL_PROD_CODE");
				POL_SYS_ID= rs2.getString("POL_SYS_ID");
				System.out.println("Product Code****************"+POL_PROD_CODE);
			}
		
			rs3 = getHandler().executeSelectStatement(C11, connection,
					new Object[] {POL_SYS_ID});
			System.out.println("Addtional Status"+POL_SYS_ID);
			while (rs3.next()) {
				M_POL_ADDL_STATUS = rs3.getString("POL_ADDL_STATUS");
				System.out.println("Additional Status****************"+M_POL_ADDL_STATUS);
			}
		
			String Userid=CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID");
			System.out.println("User Id*************"+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			
			rs4 = getHandler().executeSelectStatement(C12, connection,
					new Object[] { Userid,POL_PROD_CODE});
			System.out.println("User id"+Userid);
			System.out.println("Product Code"+POL_PROD_CODE);
			if (rs4.next()) {
				ASD_CHAR_VALUE = rs4.getString(1);
				System.out.println("ASD_CHAR_VALUE::::::::::::::::::::::::"+ASD_CHAR_VALUE);
			}

			if(("N".equalsIgnoreCase(ASD_CHAR_VALUE))&&(("L01".equalsIgnoreCase(M_POL_ADDL_STATUS))||("L02".equalsIgnoreCase(M_POL_ADDL_STATUS)))){
				throw new Exception(
						"The policy is in Pre-lapse state,only authorized User is allowed to do the Claim Registration.");
				
				}
			
			if(C4_REC.next()){
				jointYN = C4_REC.getString(1);
				polSysId = C4_REC.getLong(2);
				status = C4_REC.getString(3);
			}
			
			/*Added by Janani on 17.07.2017 as per Sivarams suggestion*/
			
			/*
			 * Commented by Janani on 17.07.2017 as per Sivarams suggestion
			 * 
			 * if(C7_REC.next()){
				throw new Exception("Close RI and Fac to apply Claim");
			}*/
			
			
			C15_REC = getHandler().executeSelectStatement(C15, connection,
					new Object[] {POL_PROD_CODE});
			while (C15_REC.next())
			{
				PLAN_TYPE = C15_REC.getString("PLAN_TYPE");
			}
			
			C17_REC =getHandler().executeSelectStatement(C17, connection,
					new Object[] {POL_PROD_CODE});
			while (C17_REC.next())
			{
				UNIT_LINK_TYPE = C17_REC.getString("PROD_UNIT_LINK_TYPE");
			}
			
			C14_REC = getHandler().executeSelectStatement(C14, connection,
					new Object[] {POL_SYS_ID});
			System.out.println("SYS_ID  "+POL_SYS_ID);
			System.out.println("UNIT_LINK_TYPE  "+UNIT_LINK_TYPE);
			System.out.println("PLAN_TYPE  "+PLAN_TYPE);
			System.out.println("PLAN_CODE  "+PLAN_CODE);
			System.out.println("getCLAIM_POL_NO     "+PT_IL_CLAIM_BEAN.getCLAIM_POL_NO());
			
			/*Commented by ganesh on 02-08-2017, as suggested by gaurav */
			/*if (C14_REC.next() && (PLAN_TYPE.equalsIgnoreCase("L") || PLAN_TYPE.equalsIgnoreCase("H"))) {
				
				if(C7_REC.next()){
					throw new Exception("Close RI and Fac to apply Claim");
				}
			}
			else if(PLAN_TYPE.equalsIgnoreCase("u") && UNIT_LINK_TYPE.equalsIgnoreCase("NA") && C14_REC.next())
			{
				if(C7_REC.next()){
					throw new Exception("Close RI and Fac to apply Claim");
				}
			}
			else
			{
				if(C7_REC.next()){
					throw new Exception("Close RI and Fac to apply Claim");
				}
			}*/
			/*Modified by ganesh on 02-08-2017, as suggested by gaurav */
			String closeRIFACQuery = "Select P9ILPK_RI_ALLOC.F_RI_CLOSE_FLAG(?) from dual";
			
			ResultSet closeRIFACResultset = getHandler().executeSelectStatement(closeRIFACQuery, connection,
					new Object[] {POL_SYS_ID});
			if(closeRIFACResultset.next()){
				String closeRI_FACFlag = closeRIFACResultset.getString(1);
				if(closeRI_FACFlag!=null && closeRI_FACFlag.equalsIgnoreCase("N")){
					/*Modified by Ganesh on 04-09-2017, for ZBILQC-1719381*/
					//throw new Exception("Close RI and Fac to apply Claim");
					throw new Exception("Close Fac to apply Claim");
					/*end*/
				}
			}
			
			/*end*/
			/*End*/
			System.out.println("status                    "+status);
			
			
			if("A".equalsIgnoreCase(status)){
			if("N".equalsIgnoreCase(jointYN)){
			if((!(value.equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()))) || 
					(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO() != null && 
							!(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO().isEmpty()))){

				/*rst8 = getHandler().executeSelectStatement(C8, connection, new Object[]{polSysId});
							if(rst8.next()){
								
							}
							else{
								throw new Exception("Benificiary Details Not Available For This Policy Cannot Proceed");
							}*/
				
				/*changed by raja on 07-03-2017*/
				String plantype=null;
				String query="select plan_type from pm_il_plan,pt_il_policy where pol_plan_code=plan_code and pol_no='"+value+"'";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
				while(resultset.next())
				{
					plantype=resultset.getString("plan_type");
				}
				
				/*Added by Janani on 28.06.2017 for ZBILQC-1728704*/
				System.out.println("getROWID()    "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getROWID());
				if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getROWID() == null)
				{
					
				/*End*/	
					if(!plantype.equalsIgnoreCase("L"))
					{
						/*end*/
					C0_REC = getHandler()
					.executeSelectStatement(C0, connection,new Object[]{value});
					if(C0_REC.next()){
						throw new Exception("Death Claim has been already applied");
					}
					}
				}
			
			}
			}
			C3_REC = getHandler()
					.executeSelectStatement(C3, connection, values);
			while (C3_REC.next()) {
				M_POL_STATUS = C3_REC.getString("POL_STATUS");
			}

			if ("S".equals(CommonUtils.nvl(M_POL_STATUS, "N"))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91535"));//91535 = Selected policy is already Surrendered
			}
			if((!(value.equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()))) || 
					(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO() != null && !(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO().isEmpty()))){
			pt_il_claim_procedure.L_CLAIM_VALID_POL_NO(value.toString(),
					compositeAction);
			
			
			pt_il_claim_procedure.L_VALUE_FETCH(compositeAction);
			
			PT_IL_CLAIM_BEAN
					.setCLAIM_CUST_CODE(DUMMY_BEAN.getCLAIM_CUST_CODE());
			PT_IL_CLAIM_BEAN.setCLAIM_CURR_CODE(DUMMY_BEAN
					.getM_POL_CUST_CURR_CODE_1());
			/*Modified by saranya for Hands on point num 11 on 10-02-2017*/
/*			if(PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE() == null){*/
				System.out.println("assr code =====>"+DUMMY_BEAN.getCLAIM_ASSR_CODE());
			   PT_IL_CLAIM_BEAN
					.setCLAIM_ASSR_CODE(DUMMY_BEAN.getCLAIM_ASSR_CODE());
	/*		}
			else{
				PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE(PT_IL_CLAIM_BEAN
								.getCLAIM_ASSR_CODE());
			}
			*/
			   /*End*/
			
	
			PT_IL_CLAIM_BEAN.setCLAIM_ACCNT_PAY_CODE(DUMMY_BEAN.getCLAIM_CUST_CODE());
			
			/*Commentted by saranya  by saranya for Hands on ponit num 11 on 05-02-2017*/
			
			/*compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getCOMP_CLAIM_CUST_CODE().resetValue();
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getCOMP_CLAIM_ASSR_CODE().resetValue();
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getCOMP_CLAIM_CURR_CODE().resetValue();
			*/
			System.out.println("PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE()   ===========>"+PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE());
			/*End*/
			/*if("Y".equalsIgnoreCase(jointYN)){
				if(!(value.equalsIgnoreCase(PT_IL_CLAIM_BEAN
						.getCLAIM_ASSR_CODE()))){
				C5_REC = getHandler().executeSelectStatement(C5, connection, new Object[]{PT_IL_CLAIM_BEAN
						.getCLAIM_ASSR_CODE(),polSysId});
				if(C5_REC.next()){
					assrType = C5_REC.getString(1);
					if("E".equalsIgnoreCase(assrType)){
						C6_REC = getHandler().executeSelectStatement(C6, connection,new Object[]{value,PT_IL_CLAIM_BEAN
								.getCLAIM_ASSR_CODE(),"D"});
						if(C6_REC.next()){
							throw new Exception("Death Claim already applied for payee");
						}
					}
					else{
						C6_REC = getHandler().executeSelectStatement(C6, connection,new Object[]{value,PT_IL_CLAIM_BEAN
								.getCLAIM_ASSR_CODE(),"D"});
						if(C6_REC.next()){
							throw new Exception("Death Claim already applied for payor");
						}
					}
				}
				
			}
			}*/
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			String Customer_code=PT_IL_CLAIM_BEAN.getCLAIM_CUST_CODE();
			if (Customer_code != null) {
				DBProcedures procedures = new DBProcedures();
				try {
					
					/*Modified by Janani on 19.06.2017 for ZBILQC-1722179 */
					
					/*ArrayList<String> custCodeList = procedures
							.helperP_VAL_CLASS_CUST("CUSTOMER",Customer_code,
									"N", "E");*/
					
					ArrayList<String> custCodeList = procedures
							.helperP_VAL_CUST_NAME(Customer_code,PT_IL_CLAIM_BEAN.getUI_M_CUST_DESC(),
									"N", "N",CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));
					
					/*End*/

					if (!custCodeList.isEmpty()) {
						for (String custCodeDesc : custCodeList) {
							PT_IL_CLAIM_BEAN.setUI_M_CUST_DESC(custCodeDesc);
							PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(custCodeDesc);
							PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ASS_NAME(custCodeDesc);
						}
					}
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//END
			}
			}
		
			else{
				throw new Exception("Invalid policy");
			}
		
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C0_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			CommonUtils.closeCursor(rs2);
			CommonUtils.closeCursor(rs3);
			CommonUtils.closeCursor(rs4);
			/*End*/	
			
		}
	}

	/**
	 * It validate the claim customer code.
	 * 
	 * @param object
	 */
	public void whenValidateClaimCustCode(Object object,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) {
		if (object != null) {
			DBProcedures procedures = new DBProcedures();
			try {
				
				
				/*Modified by Janani on 19.06.2017 for ZBILQC-1722179 */
				
				/*	ArrayList<String> custCodeList = procedures
						.helperP_VAL_CLASS_CUST("CUSTOMER", object.toString(),
								"N", "E");*/
				
				ArrayList<String> custCodeList = procedures
						.helperP_VAL_CUST_NAME(object.toString(),PT_IL_CLAIM_BEAN.getUI_M_CUST_DESC(),
								"N", "N",CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));

				
				/*End*/
				
				
			
				if (!custCodeList.isEmpty()) {
					for (String custCodeDesc : custCodeList) {
						PT_IL_CLAIM_BEAN.setUI_M_CUST_DESC(custCodeDesc);
						PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(custCodeDesc);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * It validate the claim customer code.
	 * 
	 * @param object
	 */
	public void whenValidateACCNT_PAY_CODE(Object object,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws SQLException, Exception {
		if (object != null) {
			DBProcedures procedures = new DBProcedures();
		
			/*Modified by Janani on 19.06.2017 for ZBILQC-1722179 */
						
			/*ArrayList<String> custCodeList = procedures.helperP_VAL_CLASS_CUST(
					"CUSTOMER", PT_IL_CLAIM_BEAN.getCLAIM_ACCNT_PAY_CODE(),
					"N", "E");*/
			
			ArrayList<String> custCodeList = procedures
					.helperP_VAL_CUST_NAME(PT_IL_CLAIM_BEAN.getCLAIM_ACCNT_PAY_CODE(),PT_IL_CLAIM_BEAN.getUI_M_CUST_DESC(),
							"N", "N",CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));

			
			/*End*/
			
			
			
			
			log.info("custCodeList Size=======>" + custCodeList.size());

		}

	}

	/**
	 * Validates the claim type.
	 * 
	 * @param object
	 * @param pt_il_claim_action
	 * @throws Exception 
	 */
	public void whenValidateClaimType(Object object,
			DUMMY_ACTION DUMMY_ACTION_BEAN,
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN) throws Exception {
		/*if (object != null && "A".equalsIgnoreCase(object.toString())) {
			DUMMY_ACTION_BEAN.getM_BUTT_ACC_FIR_DTLS().setDisabled(false);
			PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setDisabled(false);
			PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setRendered(true);
		} else {
			PT_IL_CLAIM_ACTION_BEAN.setCOMP_CLAIM_MED_CODE(null);
			DUMMY_ACTION_BEAN.getM_BUTT_ACC_FIR_DTLS().setDisabled(true);
			DUMMY_ACTION_BEAN.getM_BUTT_ACC_FIR_DTLS().setDisabled(true);
		}*/

	//	String q1="select CR_PAY_TO from pm_il_clm_repay where CR_COVER_CODE in( SELECT CC_COVER_CODE FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ?)";
		
		String q1="select CR_PAY_TO from pm_il_clm_repay   where CR_COVER_CODE in (select pol_plan_code from pt_il_policy " 
				 + " where pol_sys_id = ?  union  select poac_coveR_code  from pt_il_pol_addl_cover  where poac_pol_sys_id = ?) "
		   + " and exists (SELECT '1'   FROM PM_IL_CLAIM_COVER   WHERE CC_CLAIM_TYPE = 'D'   and CC_COVER_CODE = CR_COVER_CODE)";


		/*Modified by ganesh on 16-02-2018 as suggested by sivaram*/
		/*String selectQuery4 = "SELECT 'X' FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ?"
				+ " AND EXISTS (SELECT '1' FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? "
				+ " AND POAC_COVER_CODE = CC_COVER_CODE)";*/
		String selectQuery4 = "SELECT 'X' FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ?  "
				+ " AND EXISTS (SELECT '1' FROM PT_IL_POL_ADDL_COVER  WHERE POAC_POL_SYS_ID = ? "
				+ " AND POAC_COVER_CODE = CC_COVER_CODE) "
				+ " UNION "
				+ " SELECT 'X' FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ? "
				+ " AND EXISTS (SELECT '1' FROM PT_IL_POLICY WHERE POL_SYS_ID = ? "
				+ " AND POL_PLAN_CODE = CC_COVER_CODE)";

		String C8 = "SELECT 'X' FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ?";
		
		String M_CHAR = null;
		String clm_pay_to = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		try {
			
			/*Added by Ram on 26/11/2016 for Claim Others type issue*/
			System.out.println("getClaimType in whenValidateClaimType        "+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE()
					+"    "+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE_CPY());
			
			 
			ResultSet rs1=null;
			rs1=new CRUDHandler().executeSelectStatement("SELECT PS_CODE_DESC,PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CLM_TYPE' AND PS_VALUE = 0  AND PS_CODE = ?", 
					CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE_CPY()});
			if(rs1.next()){
				System.out.println("inside RS1");
				PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().setCLAIM_TYPE("O");
				
			}
			else
			{
				PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().setCLAIM_TYPE(PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE_CPY());
			}
			 
			System.out.println("getClaimType in whenValidateClaimType  second      "+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE());
			/*End*/
			con = CommonUtils.getConnection();
			/*Modified by ganesh on 16-02-2018 as suggested by siva */
			/*rst = handler.executeSelectStatement(selectQuery4, con,
					new Object[] {
							(String) object,
							PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID() });*/
			
			rst = handler.executeSelectStatement(selectQuery4, con,
					new Object[] {
							(String) object,
							PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID(),(String) object,
							PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID() });
			/*end*/

			if (rst.next()) {
				M_CHAR = rst.getString(1);
			}
			//
			/*added by raja on 28-04-2017*/
			
			String Query="SELECT PLAN_TYPE FROM PM_IL_PLAN,PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID =?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID()});
			String plan_type=null;
			while(rs.next())
			{
				plan_type=rs.getString("PLAN_TYPE");
			}

			if(plan_type!=null && !plan_type.equalsIgnoreCase("H"))
			{
			if (!("D".equalsIgnoreCase((String) object))) {

				if (!("X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "Y")))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "98401"));
				}
			}
			}
				rst1 = handler.executeSelectStatement(q1, con,
						new Object[] {
						PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
						.getCLAIM_POL_SYS_ID(),PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
						.getCLAIM_POL_SYS_ID()});

				while (rst1.next()) {
					clm_pay_to = rst1.getString(1);
					
					if("B".equalsIgnoreCase(clm_pay_to)){
						rst2 = getHandler().executeSelectStatement(C8, con, new Object[]{PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
								.getCLAIM_POL_SYS_ID()});
						if(rst2.next()){
							
						}
						else{
						
							/*changed by raja on 07-03-2017 for funeral benefit fsd*/
							/*throw new Exception("Benificiary Details Not Available For This Policy Cannot Proceed");*/
							PT_IL_CLAIM_ACTION_BEAN.getWarningMap().put("current","Benificiary Details Not Available For This Policy Cannot Proceed");
							/*end*/
						}
					}
					
				}

		//	}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}

	}

	/**
	 * Validates when Item instance.
	 * 
	 * @param object
	 * @param pilt006_apac_composite_action
	 * @throws Exception
	 */
	public void whenNewItemInstance(Object object,
			PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action)
			throws Exception {

		String M_ANN_EXIST = null;

		String C1 = "SELECT 'X' " + "FROM "
				+ "PT_IL_CLAIM_COVER_DTLS A,PM_IL_CLM_REPAY B "
				+ "WHERE  A.CCD_COVER_CODE = B.CR_COVER_CODE "
				+ "AND A.CCD_LOSS_TYPE = B.CR_LOSS_TYPE "
				+ "AND A.CCD_DISAB_TYPE = B.CR_DISABLE_TYPE "
				+ "AND NVL(CR_POLICY_VALID_YN,'N') = 'N' "
				+ "AND NVL(CR_APPLIED_ON,'X') IN ('ANSA','ANSP','ASPP') "
				+ "AND A.CCD_CLAIM_SYS_ID IN ( SELECT CLAIM_SYS_ID  "
				+ "FROM   PT_IL_CLAIM  " + "WHERE  CLAIM_POL_NO = ? "
				+ "AND    CLAIM_TYPE   = ? )";
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		try {
			log.info("POLICY NUMBER=======>"
					+ pilt006_apac_composite_action
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
							.getCLAIM_POL_NO());
			log.info("CLAIM TYPE============>" + object.toString());
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] {
							pilt006_apac_composite_action
									.getPT_IL_CLAIM_ACTION_BEAN()
									.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO(),
							object.toString() });
			while (C1_REC.next()) {
				M_ANN_EXIST = C1_REC.getString(1);
			}

			Object[] object2 = {
					"001",
					pilt006_apac_composite_action.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO(),
					"Registered", "Others" };

			if ("X".equals(CommonUtils.nvl(M_ANN_EXIST, "Y"))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91179", object2));
			}
			sessionMap = getSessionMap();
			sessionMap.put("CLAIM_TYPE", object.toString());

		} catch (DBException exception) {
			log.debug("DB EXCEPTION" + exception);
		} catch (SQLException e) {
			log.debug("SQL EXCEPTION" + e);
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}

	}

	/**
	 * 
	 * @param value
	 * @param pilt006_apac_composite_action
	 * @throws Exception
	 */
	public void whenListChangedClaimType(Object value,
			DUMMY_ACTION DUMMY_ACTION_BEAN,
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN) throws Exception {

		log.info("CLAIM TYPE=========>" + value);

		String M_PLAN_TYPE = null;
		String M_ANN_EXIST = null;

		String C1 = "SELECT  PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = (SELECT POL_PLAN_CODE "
				+ "FROM PT_IL_POLICY " + "WHERE POL_NO = ? )";

		String C2 = "SELECT 'X' "
				+ "FROM   PT_IL_CLAIM_COVER_DTLS A,PM_IL_CLM_REPAY B "
				+ "WHERE  A.CCD_COVER_CODE = B.CR_COVER_CODE "
				+ "AND    A.CCD_LOSS_TYPE = B.CR_LOSS_TYPE "
				+ "AND    A.CCD_DISAB_TYPE = B.CR_DISABLE_TYPE "
				+ "AND    NVL(CR_POLICY_VALID_YN,'N') = 'N' "
				+ "AND    NVL(CR_APPLIED_ON,'X') IN ('ANSA','ANSP','ASPP') "
				+ "AND    A.CCD_CLAIM_SYS_ID IN ( SELECT CLAIM_SYS_ID  "
				+ "FROM  PT_IL_CLAIM  " + "WHERE  CLAIM_POL_NO = ? "
				+ "AND  CLAIM_TYPE   = ? )";
		if (PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_NO() != null) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91527", new Object[] {
							"001", "Claim" }));
		}
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		try {
			Connection connection = CommonUtils.getConnection();
			C2_REC = handler.executeSelectStatement(C2, connection,
					new Object[] {
							PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_NO(), value.toString() });
			while (C2_REC.next()) {
				M_ANN_EXIST = C2_REC.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_ANN_EXIST, "Y"))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91179",
						new Object[] {
								PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
										.getCLAIM_POL_NO(), "Registered",
								"Others" }));
			}

			if (value != null && "A".equalsIgnoreCase(value.toString())) {
				DUMMY_ACTION_BEAN.getM_BUTT_ACC_FIR_DTLS().setDisabled(false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setDisabled(
						false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setRendered(
						false);
				/*PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setRequired(
						false);*/
			} else {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setDisabled(true);
				PT_IL_CLAIM_ACTION_BEAN.setCOMP_CLAIM_MED_CODE(null);
				DUMMY_ACTION_BEAN.getM_BUTT_ACC_FIR_DTLS().setDisabled(true);
				
			}

			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_CLAIM_ACTION_BEAN
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO() });
			while (C1_REC.next()) {
				M_PLAN_TYPE = C1_REC.getString("PLAN_TYPE");
			}

			if (M_PLAN_TYPE != null
					&& "M".equalsIgnoreCase(M_PLAN_TYPE)
					&& value != null
					&& ("A".equalsIgnoreCase(value.toString()) || "D"
							.equalsIgnoreCase(value.toString()))) {

				if (PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
						.isDisabled()) {
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
							.setDisabled(false);
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
							.setRendered(false);
				}

			} else {
				if (!PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
						.isDisabled()) {
					PT_IL_CLAIM_ACTION_BEAN.setCOMP_CLAIM_LC_RLA_AMOUNT(null);
					PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
							.setDisabled(true);
				}

			}
			
			/*Added by saritha on 16-10-2017 for ssp call id ZBLIFE-1445721*/
			if(("H".equalsIgnoreCase(M_PLAN_TYPE))&& ("HB".equalsIgnoreCase(value.toString())))
					
			{

				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_ADDM_DT().setDisabled(false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setDisabled(false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setRequired(true);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setRequired(true);	

			}

			else {

				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_ADDM_DT().setDisabled(true);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setDisabled(true);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setRequired(false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_HOSP_DSCHG_DT().setRequired(false);

			}
			
			/*End*/
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
		}
	}

	/**
	 * It validate the claim customer code.
	 * 
	 * @param object
	 */
	public void whenValidateMED_CODE(Object object) throws SQLException,
			Exception {
		if (object != null) {
			DBProcedures procedures = new DBProcedures();
			try {
				ArrayList<String> custCodeList = procedures.helperP_VAL_CUST(
						object.toString(), "N", "E");
				log.info("custCodeList Size=======>" + custCodeList.size());
				
/*added by dhinesh*/
				
				Iterator iterator = custCodeList.iterator();
		        while (iterator.hasNext()) {
		            System.out.println("custCodeList  value : "+iterator.next());
		        }
			/*end*/
				
				
			} catch (SQLException e) {
				log.debug(e);
				throw new SQLException("Exception" + e.getMessage());
			} catch (Exception exception) {
				log.debug(exception);
				throw new Exception("Exception" + exception.getMessage());
			}
		}

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	/**
	 * 
	 * @param CLAIM_LOSS_DT
	 * @param pt_il_claim_action
	 * @throws Exception
	 */
	

	
	public void whenValidateClaimLossDate(Date CLAIM_LOSS_DT, DUMMY DUMMY_BEAN)
			throws Exception {
		String M_PLAN_POL_VALID_AFTER_MAT_YN = null;
		Date M_PS_CR_DT = null;
		String M_POL_ADDL_STATUS = null;

		String C1 = "SELECT PLAN_POL_VALID_AFTER_MAT_YN "
				+ "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE = (SELECT POL_PLAN_CODE "
				+ "FROM   PT_IL_POLICY " + "WHERE  POL_SYS_ID = ? )";

		String C3 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String C2 = "SELECT PS_CR_DT FROM PT_IL_POL_STATUS WHERE "
				+ "PS_POL_SYS_ID = ?	AND PS_STATUS = ? ";

		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		try {

			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID() });
			while (C1_REC.next()) {
				M_PLAN_POL_VALID_AFTER_MAT_YN = C1_REC
						.getString("PLAN_POL_VALID_AFTER_MAT_YN");
			}
			Date M_POL_START_DT = DUMMY_BEAN.getM_POL_START_DT();
			Date M_POL_END_DT =DUMMY_BEAN.getM_POL_END_DT();

			if (CLAIM_LOSS_DT != null && M_POL_START_DT != null
 					&& CLAIM_LOSS_DT.before(M_POL_START_DT)) {
				
				/*Modified by Janani on 15.06.2017 for ZBILQC-1723154*/
				
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " should be grater than or equal to ", M_POL_START_DT }));*/
				
				System.out.println("M_POL_START_DT            "+M_POL_START_DT);
				
				
				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " greater than or equal to ", M_POL_START_DT }));
				
				
				/*End*/
				
			}

			if (CLAIM_LOSS_DT != null && M_POL_END_DT != null
					&& CLAIM_LOSS_DT.after(M_POL_END_DT)) {
				
				/*Modified by Janani on 15.06.2017 for ZBILQC-1723154*/
								
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " should be less than or equal to ", M_POL_END_DT }));*/
				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " less than or equal to ", M_POL_END_DT }));
				
				/*End*/
			}

			if (DUMMY_BEAN.getM_POL_NL_FM_DT() != null
					&& DUMMY_BEAN.getM_POL_NL_TO_DT() != null) {

				if (CLAIM_LOSS_DT.after(DUMMY_BEAN.getM_POL_NL_FM_DT())
						&& CLAIM_LOSS_DT.before(DUMMY_BEAN.getM_POL_NL_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71160",
							new Object[] { DUMMY_BEAN.getM_POL_NL_FM_DT(),
									DUMMY_BEAN.getM_POL_NL_TO_DT() }));
				}

			}

			if ("N".equals(CommonUtils.nvl(M_PLAN_POL_VALID_AFTER_MAT_YN, "N"))) {
				if (CLAIM_LOSS_DT != null
						&& DUMMY_BEAN.getM_POL_NL_FM_DT() != null
						&& DUMMY_BEAN.getM_POL_NL_TO_DT() != null
						&& !CLAIM_LOSS_DT.after(DUMMY_BEAN.getM_POL_NL_FM_DT())
						&& !CLAIM_LOSS_DT
								.before(DUMMY_BEAN.getM_POL_NL_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71191",
							new Object[] { DUMMY_BEAN.getM_POL_NL_FM_DT(),
									DUMMY_BEAN.getM_POL_NL_TO_DT() }));
				}
			}
			CommonUtils utils = new CommonUtils();

			if (CLAIM_LOSS_DT != null
					&& CLAIM_LOSS_DT.after(utils.getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60021"));
			}

			C3_REC = handler.executeSelectStatement(C3, connection,
					new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID() });
			while (C3_REC.next()) {
				M_POL_ADDL_STATUS = C3_REC.getString("POL_ADDL_STATUS");
			}

			CommonUtils.nvl(M_POL_ADDL_STATUS, "XXX");
			List<String> addStatus = new ArrayList<String>();
			addStatus.add("L01");
			addStatus.add("L02");
			addStatus.add("I05");

			if (addStatus.contains(M_POL_ADDL_STATUS)) {
				C2_REC = handler.executeSelectStatement(C2, connection,
						new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID(),
								M_POL_ADDL_STATUS });
				while (C2_REC.next()) {
					M_PS_CR_DT = C2_REC.getDate("PS_CR_DT");
				}
			}

			if (M_PS_CR_DT != null) {
				if (CommonUtils.nvl(CLAIM_LOSS_DT, utils.getCurrentDate())
						.after(
								CommonUtils.nvl(M_PS_CR_DT, utils
										.getCurrentDate()))) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91091",
											new Object[] { "Less than the','Policy Lapse / Pre Lapse date" }));
				}
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
		}
	}

	/**
	 * 
	 * @param object
	 * @param pt_il_claim_action
	 * @throws Exception
	 */
	public void whenValidateIntimationDate(Date CLAIM_INTIMATION_DT,
			DUMMY DUMMY_BEAN, Date CLAIM_LOSS_DATE) throws Exception {

		CommonUtils utils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		
		System.out.println("CLAIM_INTIMATION_DT               "+CLAIM_INTIMATION_DT);
		System.out.println("CLAIM_LOSS_DATE               "+CLAIM_LOSS_DATE);
		
		
		if (CLAIM_INTIMATION_DT != null && CLAIM_LOSS_DATE != null 
				&& CLAIM_INTIMATION_DT.before(CLAIM_LOSS_DATE)
				|| CLAIM_INTIMATION_DT.after(utils.getCurrentDate())) {

			
			System.out.println("CLAIM_INTIMATION_DT is before loss date");
			
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71100"));
		}
		procedures.call_PKG_PILT002_P_SET_DOC_NO_PROP("4", null, DUMMY_BEAN
				.getM_POL_DIVN_CODE(), DUMMY_BEAN.getM_POL_CLASS_CODE(),
				DUMMY_BEAN.getM_POL_PLAN_CODE(), DUMMY_BEAN
						.getM_POL_PROD_CODE(), String.valueOf(DUMMY_BEAN
						.getM_POL_UW_YEAR()), null, null, null, null,
				DUMMY_BEAN.getCLAIM_NO(), null, null);

	}

	/**
	 * 
	 * @param object
	 * @param pt_il_claim_action
	 * @throws Exception
	 */
	public void whenValidateClaimRLAAmount(Object object,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN, DUMMY DUMMY_BEAN, Date CLAIM_LOSS_DT,
			Date CLAIM_INT_DT) throws Exception {
		CommonUtils utils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		if (CLAIM_LOSS_DT != null && CLAIM_INT_DT != null) {
			if (CLAIM_INT_DT.before(CLAIM_LOSS_DT)
					|| CLAIM_INT_DT.after(utils.getCurrentDateAndTimeNew())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71100"));
			}
		}
		procedures.call_PKG_PILT002_P_SET_DOC_NO_PROP("4", null, DUMMY_BEAN
				.getM_POL_DIVN_CODE(), DUMMY_BEAN.getM_POL_CLASS_CODE(),
				DUMMY_BEAN.getM_POL_PLAN_CODE(), DUMMY_BEAN
						.getM_POL_PROD_CODE(), String.valueOf(DUMMY_BEAN
						.getM_POL_UW_YEAR()), null, null, null, null,
				PT_IL_CLAIM_BEAN.getCLAIM_NO(), null, null);

	}

	/**
	 * 
	 * @param object
	 * @param pilt006_apac_composite_action
	 * @throws Exception
	 */
	public void whenValidateUniqueClaimNo(Object object,
			PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action)
			throws Exception {
		String C1 = "SELECT CLAIM_NO FROM PT_IL_CLAIM WHERE CLAIM_NO = ? ";
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		try {
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { object.toString() });
			if (C1_REC.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71101"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	
	/*added by dhinesh*/

	
	public void claimCurrCodeWhenValidateItem(Object value,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) {
		try {
			ArrayList<OracleParameter> exchList = new PILT006_APAC_PROCEDURE()
					.P_GET_EXCHANGE_RATE(PT_IL_CLAIM_BEAN.getCLAIM_CURR_CODE(),
							PT_IL_CLAIM_BEAN.getUI_M_BUY_SELL(),
							PT_IL_CLAIM_BEAN.getCLAIM_INTM_DT(),
							PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(), "E");
			PT_IL_CLAIM_BEAN.setCLAIM_EXCH_RATE((Double) exchList.get(0)
					.getValueObject());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	/*end*/
	

	public void whenValidateClaimCurrCode(Object object,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws SQLException,
			Exception {
		DBProcedures procedures = new DBProcedures();
		String Query = "SELECT CURR_NAME FROM FM_CURRENCY WHERE CURR_CODE  = ? ";
		ResultSet resultSet = null;
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		ArrayList<OracleParameter> list = null;
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN();

		if (object != null) {
			resultSet = new CRUDHandler().executeSelectStatement(Query,
					CommonUtils.getConnection(), new Object[] { object });
			if (resultSet.next()) {
				pt_il_claim
						.setUI_M_CLAIM_CURR_CODE_DESC(resultSet.getString(1));
			}

			list = procedure.P_GET_EXCHANGE_RATE(pt_il_claim
					.getCLAIM_CURR_CODE(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_BUY_SELL(),
					pt_il_claim.getCLAIM_INTM_DT(), pt_il_claim
							.getCLAIM_EXCH_RATE(), "E");
			if (list != null && !(list.isEmpty())) {
				pt_il_claim.setCLAIM_EXCH_RATE((Double) list.get(0)
						.getValueObject());
			}

		}
	}

	/**
	 * 
	 * @param object
	 * @param pilt006_apac_composite_action
	 * @throws Exception
	 */
	public void whenValidateClaimRefNumber(Object object,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception {
		String C1 = " SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_REF_NO = ? AND CLAIM_SYS_ID <> ? ";
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		try {
			log.info("CLAIM NUMBER=======>" + object);
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { object.toString(),
							PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID() });
			while (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
			}

			if (object != null && M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91323"));
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}
	}

	/**
	 * 
	 * @param pt_il_claim
	 */
	public void preQuery(PT_IL_CLAIM pt_il_claim) {
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		// String CALLING_FORM =
		// CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_NAME");
		if (CALLING_FORM != null && CALLING_FORM.startsWith("PILQ104_APAC")) {
			pt_il_claim.setCLAIM_DS_CODE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
		}
		Long STRING_CLAIM_SYS_ID = (Long) CommonUtils
				.getGlobalObject("GLOBAL.M_CLM_SYS_ID");
		if (STRING_CLAIM_SYS_ID != null) {
			pt_il_claim.setCLAIM_SYS_ID(STRING_CLAIM_SYS_ID);
		}
		String claimCallingForm = CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
		if(claimCallingForm!=null){
			
		}
	}

	/**
	 * When New Form Instance For Form level triggers.
	 * 
	 * @param pt_il_claim
	 */
	public void whenNewFormInstanceForm(PT_IL_CLAIM pt_il_claim) {
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		String CLAIM_CALLING_FORM = CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
		log.info("CALLING_FORM" + CALLING_FORM);
		if (CALLING_FORM != null && CALLING_FORM.startsWith("PILQ104_APAC")) {
			CommonUtils.setGlobalVariable("GLOBAL.M_CLAIM_SYS_ID", String
					.valueOf(pt_il_claim.getCLAIM_SYS_ID()));
		} else if (CALLING_FORM != null && CALLING_FORM.startsWith("PQ123")) {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID_2", String
					.valueOf(pt_il_claim.getCLAIM_POL_SYS_ID()));
		}else if(CLAIM_CALLING_FORM != null &&  CLAIM_CALLING_FORM.equalsIgnoreCase("PILT002_APAC") ){
			pt_il_claim.setROWID(CommonUtils.getGlobalVariable("CLAIM_ROW_ID"));
			CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM",null);
			CommonUtils.setGlobalVariable("CLAIM_ROW_ID",null);
		}
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		// EXECUTE_QUERY
		procedure.IL_QUERY_DISABLE();
	}

	/**
	 * PreForm
	 * 
	 * @param dummyAction
	 * @throws DBException
	 * @throws SQLException
	 */
	
	
	
	public void preForm(DUMMY_ACTION dummyAction, CTRL_ACTION CTRL_ACTION_BEAN,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception,
			SQLException {
		DUMMY dummy = dummyAction.getDUMMY_BEAN();
		String M_FILE = null;
		String M_TITLE = null;
		String M_DESC = null;
		String M_PS_CODE_DESC = null;
		String M_PS_DESC = null;
		String BASE_CURR = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE  PARA_ID = 'BASE.CURR'";

		String BUY_SELL = "SELECT DS_CURR_RATE_BS FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '4' AND DS_CODE = ? ";

		/*Uncommented by ganesh on 18-05-2017 due to userid is going null*/
		STD_PRE_FORM(CTRL_ACTION_BEAN,compositeAction);
		/*end*/

		String forLangCode = CommonUtils
				.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");

		CRUDHandler handler = new CRUDHandler();
		ResultSet BASE_CURR_REC = null;
		ResultSet BUY_SELL_REC = null;
		PCOPK_SYS_VARS pcopk_sys_vars = new PCOPK_SYS_VARS();
		try {
			pcopk_sys_vars.P_SET_PARA_VALUES(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"), CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DEPT_CODE"), CommonUtils.getControlBean()
					.getM_BASE_CURR(), "2", CommonUtils.getControlBean()
					.getM_PROG_NAME());
			
			ArrayList<OracleParameter> list = null;
			Connection connection = CommonUtils.getConnection();
			BASE_CURR_REC = handler.executeSelectStatement(BASE_CURR,
					connection);
			while (BASE_CURR_REC.next()) {
				dummy.setM_BASE_CURR(BASE_CURR_REC.getString("PARA_VALUE"));
			}
			BUY_SELL_REC = handler.executeSelectStatement(BUY_SELL, connection,
					new Object[] { CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1") });
			while (BUY_SELL_REC.next()) {
				dummy.setM_BUY_SELL(BUY_SELL_REC.getString("DS_CURR_RATE_BS"));
			}

			dummy.setPT_IL_CLAIM_CF("N");
			dummy.setPT_IL_CLAIM_COVER_DTLS_CF("N");
			dummy.setPT_IL_CLAIM_ESTIMATE_CF("N");
			dummy.setPT_IL_DOC_TODO_LIST_STATUS_CF("N");

			CommonUtils.setGlobalObject("GLOBAL.M_CLM_SYS_ID", null);
			CommonUtils.setGlobalVariable("GLOBAL.CLM_SYS_ID", null);
			CommonUtils.setGlobalVariable("GLOBAL.CLAIMM_SYS_ID", null);
			
			/*commented by raja on 24-06-2017 for hands on points*/
			//CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_11", null);

			ArrayList<String> list2 = DBProcedures.P_VAL_SYSTEM("LOAD_CLMFR",
					"LOAD_CLMFR", M_DESC, "E", dummy.getM_LOAD_CLMFR());
			M_DESC = list2.get(0);
			dummy.setM_LOAD_CLMFR(list2.get(1));

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Map<String, Object> session = getSessionMap();

			ArrayList<String> resultList = DBProcedures.P_VAL_SYSTEM(
					"IL_CALC_MTHD", "IL_CALC_MTHD", M_PS_CODE_DESC, "E", String
							.valueOf(dummy.getM_CALC_METHOD()));
			M_PS_CODE_DESC = resultList.get(0);
			dummy.setM_CALC_METHOD(Integer.parseInt(resultList.get(1)));

			ArrayList<String> resultList1 = DBProcedures.P_VAL_SYSTEM(
					"IL_RSRV_CLM", "IL_RSRV_CLM", M_PS_DESC, "E", dummy
							.getM_RSRV_CLM());
			M_PS_DESC = resultList1.get(0);
			dummy.setM_RSRV_CLM(resultList1.get(1));

			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			
			if (1 == CommonUtils.nvl(dummy.getM_CALC_METHOD(), 1) || 2 == CommonUtils.nvl(dummy.getM_CALC_METHOD(), 1)) {
				dummyAction.getM_BUT_FRZ().setDisabled(true);
			} else {
				dummyAction.getM_BUT_FRZ().setDisabled(false);
			}

			CommonUtils.setGlobalVariable("GLOBAL.CLAIM_TYPE", null);

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(BASE_CURR_REC);
			CommonUtils.closeCursor(BUY_SELL_REC);
		}

	}

	public ArrayList<OracleParameter> prepareOracleParam(
			Map<String, Object> session) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				"ENG");
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				"CHN");
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				"LIFEALL");
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				"001");
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				"HO");
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				"ADM");
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				"BND");
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN", "2");
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				"PM101_A_TISB");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}

	/**
	 * 
	 * @throws Exception 
	 * @throws DBException
	 * @throws SQLException
	 * @throws Exception
	 */
	public void whenValidateCLAIM_ASSR_VALID(
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN,PT_IL_CLAIM PT_IL_CLAIM_BEAN,String value) throws Exception {
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		String jointYN  = null;
		Long polSysId = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String dbRowId = null;
		String beanRowId = null;
		String claim_sys_id=null;
		
		String C1 = "SELECT POL_JOINT_LIFE_YN,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ";
		
		String C2 = "SELECT * FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID  = ? " +
				"AND EXISTS (SELECT 1 FROM PT_IL_POL_ASSURED_DTLS " +
				"WHERE POAD_POL_SYS_ID = ? AND POAD_ASSR_CODE  = ? " +
				"AND POAD_ASSR_CODE  = CLAIM_ASSR_CODE) AND CLAIM_TYPE != 'O' ";
		
		String C3 = "SELECT ROWID ,CLAIM_SYS_ID FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = ? AND CLAIM_ASSR_CODE = ?";
			
		try {
			connection = CommonUtils.getConnection();
			procedure.L_CLAIM_ASSR_VALID(PT_IL_CLAIM_ACTION_BEAN
					.getPT_IL_CLAIM_BEAN(),value);
			if(PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getROWID() != null){
			   beanRowId = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getROWID();
			}
			C3_REC = handler.executeSelectStatement(C3, connection, new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(),
					PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE()});
			if(C3_REC.next()){
				dbRowId = C3_REC.getString(1);
				claim_sys_id=C3_REC.getString(2);
			}
			if (!(dbRowId == null && beanRowId == null)) {  
				if(!(dbRowId.equalsIgnoreCase(beanRowId))){
					if(null == beanRowId){
					C1_REC = handler.executeSelectStatement(C1, connection,
							new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() });
					// if(!value.equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE())){
					if (C1_REC.next()) {
						jointYN = C1_REC.getString(1);
						polSysId = C1_REC.getLong(2);
						if ("Y".equalsIgnoreCase(jointYN)) {
							C2_REC = handler.executeSelectStatement(C2, connection,
									new Object[] { polSysId, polSysId, value });
							if (C2_REC.next()) {
								throw new Exception(
										"Assured not valid Death Claim Already Registered");
						}
					}
				}
			}
		    }
			}
			
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try{CommonUtils.closeCursor(C1_REC);}catch (Exception e) {}
			try{CommonUtils.closeCursor(C2_REC);}catch (Exception e) {}
			try{CommonUtils.closeCursor(C3_REC);}catch (Exception e) {}
		}
	}

	public List<PT_IL_CLAIM> lovCustCode(FacesContext context, String CUST_CODE) {
		/*
		 * 
		 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String selectQuery = "SELECT CUST_CODE,CUST_NAME,CUST_LONG_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PM_CUSTOMER "
				+ "WHERE CUST_CLASS IN ("
				+ "SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ "WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) "
				+ "IN ('001','002','003','004','005','006','009','020') "
				+ "AND PS_CODE ='CUSTOMER' AND PS_TYPE ='LOV_CUST') "
				+ "AND CUST_FRZ_FLAG = 'N' "
				+ "AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN ("
				+ "SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ "WHERE CDIV_DIVN_CODE = NVL ('YHW04', CDIV_DIVN_CODE))) "
				+ "AND CUST_CODE LIKE NVL(?, CUST_CODE) AND ROWNUM<21";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016 
		String selectQuery = "SELECT CUST_CODE,CUST_NAME,CUST_LONG_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PM_CUSTOMER "
				+ "WHERE CUST_CLASS IN ("
				+ "SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ "WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) "
				+ "IN ('001','002','003','004','005','006','009','020') "
				+ "AND PS_CODE ='CUSTOMER' AND PS_TYPE ='LOV_CUST') "
				+ "AND CUST_FRZ_FLAG = 'N' "
				+ "AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN ("
				+ "SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ "WHERE CDIV_DIVN_CODE = NVL ('YHW04', CDIV_DIVN_CODE))) "
				+ "AND UPPER(CUST_CODE) LIKE UPPER(NVL(?, CUST_CODE)) AND ROWNUM<21";
		/*end*/
		
		/*Modified by Dhinesh on 26.11.2016*/ 
		String selectQuery = "SELECT CUST_CODE,CUST_NAME,CUST_LONG_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PT_IL_POLICY,PM_CUSTOMER "
						+ "WHERE CUST_CLASS IN ("
						+ "SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
						+ "WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) "
						+ "IN ('001','002','003','004','005','006','009','020') "
						+ "AND PS_CODE ='CUSTOMER' AND PS_TYPE ='LOV_CUST') "
						+ "AND CUST_FRZ_FLAG = 'N' "
						+ "AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN ("
						+ "SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
						+ "WHERE CDIV_DIVN_CODE = NVL ('YHW04', CDIV_DIVN_CODE))) "
						+ "AND UPPER(CUST_CODE) LIKE UPPER(NVL(?, CUST_CODE))"
						+ "AND POL_CUST_CODE = CUST_CODE "
						+ "AND POL_NO = ? AND ROWNUM<21";
						
		String CLAIM_POL_NO = CommonUtils.getGlobalVariable("GLOBAL.CLAIM_POL_NO");
		
		 /*  End*/
		
		// PT_IL_CLAIM_ACTION claimAction = (PT_IL_CLAIM_ACTION)
		// sessionMap.get("PILT006_APAC_PT_IL_CLAIM_ACTION");
		if (CUST_CODE != null)
			if (CUST_CODE.equals("*"))
				CUST_CODE = "%";
			else
				CUST_CODE += "%";
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM> claimList = null;
		try {
			Connection connection = CommonUtils.getConnection();
			
			/*ResultSet rst = handler.executeSelectStatement(selectQuery,
					connection, new Object[] { CUST_CODE });*/
			
			ResultSet rst = handler.executeSelectStatement(selectQuery,
					connection, new Object[] { CUST_CODE,CLAIM_POL_NO });
			
			PT_IL_CLAIM claimBean = null;
			claimList = new ArrayList<PT_IL_CLAIM>();
			while (rst.next()) {
				claimBean = new PT_IL_CLAIM();
				claimBean.setCLAIM_CUST_CODE(rst.getString(1));
				claimBean.setUI_M_CUST_DESC(rst.getString(2));
				claimBean.setCustFullName(rst.getString(3));
				claimBean.setCustICNO(rst.getString(4));
				claimBean.setCustAddress(rst.getString(5));

				claimList.add(claimBean);
			}
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claimList;
	}

	/*public void claimCurrCodeWhenValidateItem(Object value,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) {
		try {
			ArrayList<OracleParameter> exchList = new PILT006_APAC_PROCEDURE()
					.P_GET_EXCHANGE_RATE(PT_IL_CLAIM_BEAN.getCLAIM_CURR_CODE(),
							PT_IL_CLAIM_BEAN.getUI_M_BUY_SELL(),
							PT_IL_CLAIM_BEAN.getCLAIM_INTM_DT(),
							PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(), "E");
			PT_IL_CLAIM_BEAN.setCLAIM_EXCH_RATE((Double) exchList.get(0)
					.getValueObject());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void validateCLAIM_TYPE_WHEN_CHANGED(
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN)
			throws ValidatorException {
		String CLAIM_TYPE = (String) PT_IL_CLAIM_ACTION_BEAN
				.getCOMP_CLAIM_TYPE().getSubmittedValue();

		// claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_TYPE(CLAIM_TYPE);
		String sql_C1 = "SELECT PLAN_TYPE FROM  PM_IL_PLAN  "
				+ "WHERE  PLAN_CODE = ("
				+ "SELECT POL_PLAN_CODE  FROM  PT_IL_POLICY   "
				+ "WHERE  POL_NO  = ? ) ";
		
		String CURSOR_C1 ="	SELECT CC_FLEX_01 	FROM PM_IL_CLAIM_COVER 	WHERE CC_CLAIM_TYPE = ? ";
		
		String CURSOR_C2 = " SELECT POL_ISSUE_DT	FROM PT_IL_POLICY	WHERE POL_NO= ? ";
		String CLAIM_POL_NO = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO();
		CRUDHandler handler = new CRUDHandler();
		String M_PLAN_TYPE = null;
		Integer M_CC_FLEX_01=null;
		Date M_POL_ISSUE_DT=null;
		try {
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_POL_NO });
			
			while (rst.next()) {
				M_PLAN_TYPE = rst.getString("PLAN_TYPE");
			}
			rst.close();

			String CLAIM_NO = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
					.getCLAIM_NO();
			if (CLAIM_NO != null) {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_TYPE().setSubmittedValue(
						PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
								.getCLAIM_TYPE());
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91527",
						new Object[] { "Claim" }));

			} else
				PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().setCLAIM_TYPE(
						CLAIM_TYPE);
			if (CLAIM_TYPE.equals("A") || CLAIM_TYPE.equals("O")) {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_BUTT_ACC_FIR_DTLS()
						.setDisabled(false);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setDisabled(
						false);
			} else {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_BUTT_ACC_FIR_DTLS()
						.setDisabled(true);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE()
						.setSubmittedValue(null);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_CLAIM_MED_CODE_NAME()
						.setSubmittedValue(null);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_MED_CODE().setDisabled(
						true);
			}

			if ((M_PLAN_TYPE == null ? "" : M_PLAN_TYPE).equals("M")
					&& CLAIM_TYPE.equals("A") || CLAIM_TYPE.equals("D")) {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
						.setDisabled(false);
			} else {
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_LC_RLA_AMOUNT()
						.setDisabled(true);
			} 
			ResultSet rs1 = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { CLAIM_TYPE });
			if(rs1.next()){
				M_CC_FLEX_01=rs1.getInt(1);
			}
			ResultSet rs2 = handler.executeSelectStatement( CURSOR_C2, connection,
					new Object[] {  CLAIM_POL_NO });
			if(rs2.next()){
				M_POL_ISSUE_DT=rs1.getDate(1);
			}
			 
			if( (PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT()).before(
					( CommonUtils.addDaysToDate(M_POL_ISSUE_DT, CommonUtils.nvl(M_CC_FLEX_01,0))))){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "710500",
						new Object[] { M_POL_ISSUE_DT}));	
			/* STD_ERROR(:GLOBAL.M_LOGIN_APP_CODE,710500,NAME_IN('GLOBAL.M_LANG_CODE'),
		                      TO_CHAR(M_POL_ISSUE_DT,'DD/MM/YY'));*/	
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateClaimNo(PT_IL_CLAIM PT_IL_CLAIM_BEAN)
			throws Exception {
		try {
			PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
			pilt006_apac_procedure.L_UNIQUE_CLAIM_NO(PT_IL_CLAIM_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * 
	 */
	public void executeQuery(PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN) {
		try {
			PT_IL_CLAIM PT_IL_CLAIM_BEAN = PT_IL_CLAIM_ACTION_BEAN
					.getPT_IL_CLAIM_BEAN();

			String selectQuery = "SELECT PT_IL_CLAIM.ROWID, PT_IL_CLAIM.*"
					+ "FROM PT_IL_CLAIM WHERE ROWID = ?";
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			String query1="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CLM_EXCL' AND PC_CODE=? ";
			//END
			/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
			String query2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DISEASES' AND PC_CODE= ? ";
			/*end*/
			
			/*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
			String query3="SELECT CUST_NAME FROM PM_CUSTOMER  WHERE CUST_CODE=?";
			//end
			/*added BY Ameen on 22-07-2017 CLAIM_ICD_DISEASES_DTL not came*/
			String icdDescQry = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_ICD_CODE' AND PC_CODE = ?";
			ResultSet icdDescRS = null;
			/*End*/
			System.out.println(selectQuery);
			System.out.println(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID());
			CRUDHandler handler = new CRUDHandler();
			ResultSet result = handler.executeSelectStatement(selectQuery,
					CommonUtils.getConnection(),
					new Object[] { PT_IL_CLAIM_BEAN.getROWID() });
			// PT_IL_CLAIM claim = claimAction.getPT_IL_CLAIM_BEAN();
			while (result.next()) {

				PT_IL_CLAIM_BEAN.setROWID(result.getString(1));
				PT_IL_CLAIM_BEAN.setCLAIM_SYS_ID(result.getLong(2));
				PT_IL_CLAIM_BEAN.setCLAIM_POL_SYS_ID(result.getLong(3));
				PT_IL_CLAIM_BEAN.setCLAIM_POL_NO(result.getString(4));
				PT_IL_CLAIM_BEAN.setCLAIM_DS_CODE(result.getString(5));
				// claim.setCLAIM_POAD_SERIAL_NO(result.getDouble(6));
				PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE(result.getString(7));
				PT_IL_CLAIM_BEAN.setCLAIM_CURR_CODE(result.getString(8));
				PT_IL_CLAIM_BEAN
						.setCLAIM_EXCH_RATE(result.getDouble(9) == 0.0 ? null
								: result.getDouble(9));
				PT_IL_CLAIM_BEAN.setCLAIM_LOSS_DT(result.getDate(10));
				PT_IL_CLAIM_BEAN.setCLAIM_INTM_DT(result.getDate(11));
				PT_IL_CLAIM_BEAN.setCLAIM_NO(result.getString(12));
				PT_IL_CLAIM_BEAN.setCLAIM_TYPE(result.getString(13));
				PT_IL_CLAIM_BEAN.setCLAIM_REMARKS(result.getString(14));
				PT_IL_CLAIM_BEAN.setCLAIM_REF_NO(result.getString(15));
				// claim.setCLAIM_PAY_TO(result.getString(16));
				PT_IL_CLAIM_BEAN.setCLAIM_CLOSE_FLAG(result.getString(17));
				PT_IL_CLAIM_BEAN.setCLAIM_STATUS(result.getString(18));
				PT_IL_CLAIM_BEAN.setCLAIM_FRZ_FLAG(result.getString(19));
				PT_IL_CLAIM_BEAN.setCLAIM_CR_UID(result.getString(20));
				PT_IL_CLAIM_BEAN.setCLAIM_CR_DT(result.getDate(21));
				PT_IL_CLAIM_BEAN.setCLAIM_UPD_UID(result.getString(22));
				PT_IL_CLAIM_BEAN.setCLAIM_UPD_DT(result.getDate(23));
				PT_IL_CLAIM_BEAN.setCLAIM_CUST_CODE(result.getString(24));
				PT_IL_CLAIM_BEAN.setCLAIM_ACCNT_PAY_CODE(result.getString(25));
				PT_IL_CLAIM_BEAN.setCLAIM_ADDL_STATUS(result.getString(26));
				// claim.setCLAIM_REV_RES_FLAG(result.getString(27));
				PT_IL_CLAIM_BEAN.setCLAIM_RESV_AMT(result.getDouble(28));
				PT_IL_CLAIM_BEAN.setCLAIM_UTIL_AMT(result.getDouble(29));
				// claim.setCLAIM_APPRV_DT(result.getDate(30));
				// claim.setCLAIM_APPRV_STATUS(result.getString(31));
				// claim.setCLAIM_UNIT_SELL_YN(result.getString(32));
				PT_IL_CLAIM_BEAN.setCLAIM_REOPEN_DT(result.getDate(33));
				PT_IL_CLAIM_BEAN.setCLAIM_REOPEN_REASON(result.getString(34));
				PT_IL_CLAIM_BEAN.setCLAIM_POL_VALID_YN(result.getString(35));
				PT_IL_CLAIM_BEAN.setCLAIM_MED_CODE(result.getString(36));
				PT_IL_CLAIM_BEAN.setCLAIM_LC_RLA_AMOUNT(result.getDouble(37));
				PT_IL_CLAIM_BEAN.setCLAIM_PCI_REF_NO(result.getString(38));
				//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
				PT_IL_CLAIM_BEAN.setCLAIM_DIS_CERT_DT(result.getDate(42));
				PT_IL_CLAIM_BEAN.setCLAIM_MED_EXP_DT(result.getDate(43));
				PT_IL_CLAIM_BEAN.setCLAIM_SICKNESS_DT(result.getDate(44));
				/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
				PT_IL_CLAIM_BEAN.setCLAIM_DISEASES_CODE(result.getString("CLAIM_DISEASES_CODE"));
				/*Added by Sivarajan on 30/04/2021 for Allaince IL*/
				PT_IL_CLAIM_BEAN.setCLAIM_DTH_CERTI_NO(result.getString("CLAIM_DTH_CERTI_NO"));
				PT_IL_CLAIM_BEAN.setCLAIM_BURIAL_PERMIT_NO(result.getString("CLAIM_BURIAL_PERMIT_NO"));
				/*End*/
				ResultSet result1 = handler.executeSelectStatement(query2,
						CommonUtils.getConnection(),
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_DISEASES_CODE()});
				if(result1.next()){
				PT_IL_CLAIM_BEAN.setUI_M_CLAIM_DISEASES_CODE_DESC(result1.getString("PC_DESC"));
				}
				/*end*/
				/*added BY Ameen on 22-07-2017 CLAIM_ICD_DISEASES_DTL not came*/
				PT_IL_CLAIM_BEAN.setCLAIM_ICD_DISEASES_DTL(result.getString("CLAIM_ICD_DISEASES_DTL"));
				icdDescRS = new CRUDHandler().executeSelectStatement(icdDescQry, CommonUtils.getConnection(),new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_ICD_DISEASES_DTL()});
				if(icdDescRS.next()){
					PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ICD_DISEASES_DTL_DESC(icdDescRS.getString("PC_DESC"));
				}
				/*End*/
				/*Added by saranya for Hands on point num 11 on 08-02-2017*/
				PT_IL_CLAIM_BEAN.setCLAIM_ASSRD_REF_ID1(result.getString("CLAIM_ASSRD_REF_ID1"));
				/*End*/
				System.out.println("PT_IL_CLAIM ROWID"+PT_IL_CLAIM_BEAN.getROWID()+"CLAIM_DIS_CERT_DT ::"+PT_IL_CLAIM_BEAN.getCLAIM_DIS_CERT_DT()+"CLAIM_MED_EXP_DT ::"+PT_IL_CLAIM_BEAN.getCLAIM_MED_EXP_DT()+"CLAIM_SICKNESS_DT ::"+PT_IL_CLAIM_BEAN.getCLAIM_SICKNESS_DT());
				//END CLAIM TYPE = OTHERS
				/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
				PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP(result.getString("CLAIM_EXCL_TYP"));
				System.out.println("**********value of CLAIM_EXCL_TYP------------>"+PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP());
				ResultSet resultSetClaimDisable = handler.executeSelectStatement(query1,
						CommonUtils.getConnection(),
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()});
				if(resultSetClaimDisable.next()){
				PT_IL_CLAIM_BEAN.setUI_M_CLAIM_EXCL_TYP_DESC(resultSetClaimDisable.getString("PC_DESC"));
				System.out.println("********************VALUE OF UI_M_CLAIM_EXCL_TYP_DESC********"+PT_IL_CLAIM_BEAN.getUI_M_CLAIM_EXCL_TYP_DESC());
				}
				
				PT_IL_CLAIM_BEAN.setCLAIM_EXCL_REASON(result.getString("CLAIM_EXCL_REASON"));
				//END
				/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017
				PT_IL_CLAIM_BEAN.setCLAIM_FEE_HOSPITALS(result.getDouble("CLAIM_FEE_HOSPITALS"));
				end*/
				
				/*added by raja on 07-03-2017 for funeral benefit fsd*/ 
				
				PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE(result.getString("CLAIM_MEMB_CODE"));
				if(PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()!=null)
				{
					String QueryMEMB="select CUST_NAME from pm_customer where cust_code=?";
				ResultSet resultMEMB = handler.executeSelectStatement(QueryMEMB,
						CommonUtils.getConnection(),
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()});
				if(resultMEMB.next()){
				PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE_DESC(resultMEMB.getString("CUST_NAME"));
				}
				}
				/*end*/
				/*added by raja on 04-05-2017 for Hospital cash plan*/
				PT_IL_CLAIM_BEAN.setCLAIM_HOSP_ADDM_DT(result.getTimestamp("CLAIM_HOSP_ADDM_DT"));
				PT_IL_CLAIM_BEAN.setCLAIM_HOSP_DSCHG_DT(result.getTimestamp("CLAIM_HOSP_DSCHG_DT"));
				/*END*/
				
				/*added by raja on 13-05-2017*/
				PT_IL_CLAIM_BEAN.setCLM_EXCL_YN(result.getString("CLM_EXCL_YN"));
				/*end*/
				/*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
				PT_IL_CLAIM_BEAN.setCLAIM_CLAIMANT_CODE(result.getString("CLAIM_CLAIMANT_CODE"));
				/*end*/
				ResultSet claimant_code = handler.executeSelectStatement(query3,
						CommonUtils.getConnection(),
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_CLAIMANT_CODE()});
				if(claimant_code.next()){
				PT_IL_CLAIM_BEAN.setUI_M_CLAIM_CLAIMANT_CODE_DESC(claimant_code.getString("CUST_NAME"));
				}
				
				/*Added by saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
				PT_IL_CLAIM_BEAN.setCLAIM_INT_MOBILE(result.getString("CLAIM_INT_MOBILE"));
				PT_IL_CLAIM_BEAN.setCLAIM_INT_EMAIL(result.getString("CLAIM_INT_EMAIL"));
				/*End*/
				
			}
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PT_IL_CLAIM_ACTION_BEAN.setPT_IL_CLAIM_BEAN(PT_IL_CLAIM_BEAN);
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * @param PT_IL_CLAIM_ACTION_BEAN
	 */
	public void STD_PRE_FORM(CTRL_ACTION CTRL_ACTION_BEAN,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) {

		String M_SCR_NAME = null;
		String M_COMP_CODE = null;
		String M_DIVN_CODE = null;
		String M_DEPT_CODE = null;

		String M_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		String M_NAME = CommonUtils.getGlobalVariable("GLOBAL.M_NAME");
		String LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
		String M_DFLT_VALUES = CommonUtils
				.getGlobalVariable("GLOBAL.M_DFLT_VALUES");

		if (M_NAME != null) {
			M_SCR_NAME = M_NAME.substring(30);
		}
		if (M_DFLT_VALUES == null || "".equalsIgnoreCase(M_DFLT_VALUES)) {
			M_COMP_CODE = "001";
			M_DIVN_CODE = "HO";
			M_DEPT_CODE = "001";
		}

		CTRL CTRL_BEAN = new CTRL();
		CTRL_BEAN.setUI_M_PARA_1(M_PARA_1);
		CTRL_BEAN.setUI_M_USER_ID(M_USER_ID);
		CTRL_BEAN.setUI_M_LANG_CODE(LANG_CODE);
		CTRL_BEAN.setUI_M_COMP_CODE(M_COMP_CODE);
		CTRL_BEAN.setUI_M_DIVN_CODE(M_DIVN_CODE);
		CTRL_BEAN.setUI_M_DEPT_CODE(M_DEPT_CODE);
		CTRL_BEAN.setUI_M_SCR_NAME(M_SCR_NAME);

		CTRL_ACTION_BEAN.setCTRL_BEAN(CTRL_BEAN);
		/*
		 * Commented by ganesh on 18-05-2017, for unused code 
		 * CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "false");
		LOAD_ENG_BP(compositeAction);*/
	}

	/**
	 * 
	 * @param DUMMY_BEAN
	 * @param PT_IL_CLAIM_BEAN
	 * @throws Exception
	 */
	public void whenSettlementButPress(
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_CLAIM PT_IL_CLAIM_BEAN = compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		CTRL CTRL_BEAN = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN();

		String C1 = "SELECT 'X'  FROM  PT_IL_CLAIM_PAID  WHERE  "
				+ "CP_CLAIM_SYS_ID = ?  AND CP_APPR_FLAG  = 'A'  "
				+ "AND CP_CLM_PAID_STATUS = 'A'";

		String C2 = "SELECT 1 FROM   PT_IL_POLICY WHERE  POL_NO = ? "
				+ "AND NVL(POL_STATUS,'N') = 'L' AND    POL_DS_TYPE = 2";

		String C3 = "SELECT PS_STATUS_DT FROM PT_IL_POL_STATUS WHERE "
				+ "PS_POL_SYS_ID = ? AND PS_STATUS ='L02'";
		// PILT007_COMPOSITE_ACTION
		HttpSession session = CommonUtils.getSession();
		if (session.getAttribute("PILT007_COMPOSITE_ACTION") instanceof PILT007_COMPOSITE_ACTION) {
			session.removeAttribute("PILT007_COMPOSITE_ACTION");
		}
		
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		/*Newly added by pidugu raj dt: 12-12-2020 for Alliance IL since calling form from cusotmer login coming null*/
		if(CommonUtils.getGlobalVariable("CALLING_FORM") == null){
			callingForm = "";//setting empty string because if we go in normal flow that time calling form value is empty string 
			}
		/*End Newly added by pidugu raj dt: 12-12-2020 for Alliance IL since calling form from cusotmer login coming null*/
		if(callingForm.equalsIgnoreCase("PILT002_APAC")){
		CommonUtils.setGlobalVariable("CALLING_FORM_POL","PILT002_APAC");
		}else{
			CommonUtils.setGlobalVariable("CALLING_FORM_POL","PILT006_APAC");
		}
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
		CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME", "claimsEntry");
		CommonUtils.setGlobalVariable("GLOBAL.M_CLAIM_POL_NO", PT_IL_CLAIM_BEAN
				.getCLAIM_POL_NO());
		CommonUtils.setGlobalVariable("GLOBAL.M_CLAIM_NO", PT_IL_CLAIM_BEAN
				.getCLAIM_NO());
		CommonUtils.setGlobalObject("GLOBAL.M_CLM_SYS_ID", PT_IL_CLAIM_BEAN
				.getCLAIM_SYS_ID());
		CommonUtils.setGlobalObject("GLOBAL.CLAIM_SYS_ID", PT_IL_CLAIM_BEAN
				.getCLAIM_SYS_ID());
		CommonUtils.setGlobalObject("GLOBAL.CLAIM_POL_SYS_ID", PT_IL_CLAIM_BEAN
				.getCLAIM_POL_SYS_ID());
		CommonUtils.setGlobalVariable("CALLING_FORM_SETTL","PILT006_APAC");

		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		String M_DUMMY = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C2_REC = handler.executeSelectStatement(C2, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() });
			if (C2_REC.next()) {
				M_DUMMY = C2_REC.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "92093"));
			}

			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID() });
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
		}

	}

	/**
	 * 
	 * @param DUMMY_BEAN
	 * @param PT_IL_CLAIM_BEAN
	 * @throws Exception
	 */
	public void whenCloseButPress(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_CLAIM PT_IL_CLAIM_BEAN = compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		CTRL CTRL_BEAN = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN();

		String C1 = "SELECT 'X' FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID= ? "
				+ "AND ASD_CODE = 'CLM_CLO_OPEN'AND ASD_CHAR_VALUE ='Y'";
		String C3 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID= ? AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')" 
			+ "AND ASD_CODE = 'CLM_CLO_OPEN'";
		String C2 = "SELECT CP_CLM_PAID_STATUS  FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? ";
		String C4="SELECT POL_PROD_CODE  FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		String M_TEMP = null;
		String M_ASD_CHAR_VALUE = null;
		String prod_code =null;
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C4_REC=handler.executeSelectStatement(C4, connection,new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			while(C4_REC.next()){
				prod_code=C4_REC.getString(1);
			}
			C3_REC= handler.executeSelectStatement(C3, connection,new Object[]{CommonUtils.getControlBean().getUSER_ID(),prod_code});
			while(C3_REC.next()){
				M_ASD_CHAR_VALUE= C3_REC.getString(1);
			}if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE,"N"))){
				throw new Exception("User not authorized to close the claim");
			}
			if ("N".equals(CommonUtils.nvl(PT_IL_CLAIM_BEAN
					.getCLAIM_CLOSE_FLAG(), "N"))) {
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_FRZ_FLAG().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_CONFIRM_FLAG().setDisabled(true);
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] { CTRL_BEAN.getUSER_ID() });
				if (C1_REC.next()) {
					M_TEMP = C1_REC.getString(1);
				}
				C2_REC = handler.executeSelectStatement(C2, CommonUtils
						.getConnection(), new Object[] { PT_IL_CLAIM_BEAN
						.getCLAIM_SYS_ID() });
				if (C2_REC.next()) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
				} else {
					if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
						compositeAction.getDUMMY_ACTION_BEAN()
								.getCOMP_UI_M_BUT_REOPEN().setDisabled(false);
					} else {
						compositeAction.getDUMMY_ACTION_BEAN()
								.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
					}
				}

				pilt006_apac_procedure.REV_CLM_RESERVE(PT_IL_CLAIM_BEAN
						.getCLAIM_SYS_ID(), "C");
				CTRL_BEAN.setUI_M_COMM_DEL("C");
				DUMMY_BEAN.setM_CLOSE_FLAG("Closed");
			
			
				/*Added by Janani on 14.06.2017 for ZBILQC-1723180*/
				//DUMMY_BEAN.setUI_M_CLAIM_ADDL_STATUS("C");
				
				PT_IL_CLAIM_BEAN.setCLAIM_ADDL_STATUS("C");
				DUMMY_BEAN.setUI_M_CLOSE_FLAG("Closed");
				
				if(DUMMY_BEAN.getUI_M_CLOSE_FLAG().equalsIgnoreCase("closed"))
				{
				
				DUMMY_BEAN.setUI_M_CLAIM_ADDL_STATUS("C:- Closed");
				
				}
				
				System.out.println("getUI_M_CLOSE_FLAG  in close button             "+DUMMY_BEAN.getUI_M_CLOSE_FLAG());
				System.out.println("getUI_M_CLAIM_ADDL_STATUS  in close button             "+DUMMY_BEAN.getUI_M_CLAIM_ADDL_STATUS());
				System.out.println("getCLAIM_ADDL_STATUS in close button             "+PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS());
				
				
				/*End*/
				
				pilt006_apac_procedure.P_INSERT_CLAIM_STATUS(PT_IL_CLAIM_BEAN
						.getCLAIM_SYS_ID(), "C", new CommonUtils()
						.getCurrentDate(), "Closed", null);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_CLOSE_FLAG("Y");
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71048"));
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());

		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);

		}

	}

	/**
	 * 
	 */
	public void whenReopenButtonPress(PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN();
		String CLAIM_UPDATE = "UPDATE PT_IL_CLAIM SET CLAIM_REOPEN_DT = ? , CLAIM_REOPEN_REASON = ?  WHERE ROWID = ?  ";
		if ("Y".equals(claimBean.getCLAIM_CLOSE_FLAG())) {
			if (claimBean.getCLAIM_REOPEN_DT() != null) {
				new CRUDHandler().executeSelectStatement(CLAIM_UPDATE,
						CommonUtils.getConnection(), new Object[] {
								claimBean.getCLAIM_REOPEN_DT(),
								claimBean.getCLAIM_REOPEN_REASON(),
								claimBean.getROWID() });
				new PILT006_APAC_PROCEDURE().REV_CLM_RESERVE(claimBean
						.getCLAIM_SYS_ID(), "R");
				CommonUtils.getConnection().commit();
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE()
						.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_M_CLOSE_FLAG("ReOpen");
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_M_CLAIM_ADDL_STATUS("P : ReOpen");
				
				System.out.println("UI_M_CLAIM_ADDL_STATUS                      "+compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.getUI_M_CLAIM_ADDL_STATUS());
				
				
				new PILT006_APAC_PROCEDURE().P_INSERT_CLAIM_STATUS(claimBean
						.getCLAIM_SYS_ID(), "P", new CommonUtils()
						.getCurrentDate(), null, claimBean
						.getCLAIM_REOPEN_REASON());
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().setBlockFlag(true);
			}
		}
	}

	/**
	 * 
	 * @param compositeAction
	 */
	public String whenFreezeButton(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN();
		PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN =compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN(); 
		String M_FLAG = null;
		String M_CCD_COVER_CODE = null;
		String M_CCD_LOSS_TYPE = null;
		String M_CCD_DISAB_TYPE = null;
		String M_CR_POLICY_VALID_YN = null;
		String M_CR_PREM_PAYABLE_YN = null;
		Double M_CE_FC_PREM_OS = 0.0;
		Double M_CE_LC_PREM_OS = 0.0;
		Double M_CE_FC_PREM_OS_INT = 0.0;
		Double M_CE_LC_PREM_OS_INT = 0.0;
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		int M_COUNT = 0;
		int M_POL_END_NO_IDX=0;
		String C1 = "SELECT POL_FAC_YN  FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ";
		String C2 = "SELECT CCD_COVER_CODE , CCD_LOSS_TYPE , CCD_DISAB_TYPE FROM   "
				+ "PT_IL_CLAIM_COVER_DTLS WHERE  CCD_CLAIM_SYS_ID = ? ";
		String C3 = "SELECT CR_POLICY_VALID_YN, CR_PREM_PAYABLE_YN FROM   PM_IL_CLM_REPAY "
				+ "WHERE  CR_COVER_CODE   = ? "
				+ "AND    CR_LOSS_TYPE    = ? "
				+ "AND    CR_DISABLE_TYPE = ? "
				+ "AND    NVL(CR_POLICY_VALID_YN,'N') = 'Y' "
				+ "AND    NVL(CR_PREM_PAYABLE_YN,'N')= 'N'";
		/*
		 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		 * STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE); RAISE
		 * FORM_TRIGGER_FAILURE; END IF;
		 */
		String updateByPolId = "UPDATE PT_IL_POLICY  SET POL_PREM_WAIVE_YN = 'Y' ,POL_ADDL_STATUS= 'I08'"
				+ "WHERE POL_SYS_ID = ? ";
		
		String statusinsert="INSERT INTO PT_IL_POL_STATUS"+
       " (PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT, PS_STATUS,PS_STATUS_UID, PS_CR_UID, PS_CR_DT,PS_STATUS_TYPE)"+
" VALUES (?,?,?,?,?,?,?,?)";
		String C4="SELECT POL_END_NO_IDX  FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
		
		String updateByPolId1 = "UPDATE PT_IL_POLICY  SET  "
			+ "WHERE POL_SYS_ID = ? ";

		String updateByPolNo = "UPDATE  PT_IL_POLICY  SET POL_STATUS = 'D' "
				+ "WHERE POL_SYS_ID = ? ";

		String premColl = "UPDATE PT_IL_PREM_COLL "
				+ "SET    PC_PAID_FLAG     = 'Y' , PC_PAID_DT = ? "
				+ "WHERE  PC_SCHD_PYMT_DT  < ? "
				+ "AND    PC_POL_SYS_ID    = ? "
				+ "AND    NVL(PC_PAID_FLAG, 'N') != 'A'";
		
		/*Commentted & Query Modified by saritha on 20-12-2017 as per siva sir sugg.*/ 
		
		/*String deleteQuery = "DELETE FROM PT_IL_PREM_COLL WHERE  PC_SCHD_PYMT_DT  >= ? "
				+ "AND    PC_POL_SYS_ID    =  ? OR PC_PAID_FLAG<>'A'";*/
		
		String deleteQuery = "DELETE FROM PT_IL_PREM_COLL WHERE  PC_SCHD_PYMT_DT  >= ? "
				+ "AND    PC_POL_SYS_ID    =  ? AND PC_PAID_FLAG<>'A'";
		
		/*End*/
		
		String CLAIM_UPDATE = "UPDATE PT_IL_CLAIM SET CLAIM_FRZ_FLAG = ? WHERE CLAIM_NO = ? ";

		String claimFreezQuery = "SELECT CLAIM_FRZ_FLAG FROM PT_IL_CLAIM WHERE CLAIM_NO = ?";
		String PremPayQuery="SELECT CR_PREM_PAYABLE_YN FROM PM_IL_CLM_REPAY WHERE CR_COVER_CODE=?";

		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		int updateValue = 0;
		String freezFlag = null;
		String m_prem_pay =null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID() });
			if (C1_REC.next()) {
				M_FLAG = C1_REC.getString(1);
			}

			rs1 = handler.executeSelectStatement(claimFreezQuery, connection,
					new Object[] { compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_NO() });

			if (rs1.next()) {
				freezFlag = rs1.getString(1);
			}

			//claimBean.setCLAIM_FRZ_FLAG("Y");
			CommonUtils.getConnection().commit();

			if ("Y".equalsIgnoreCase(claimBean.getCLAIM_FRZ_FLAG())) {
				C2_REC = handler.executeSelectStatement(C2, connection,
						new Object[] { compositeAction
								.getPT_IL_CLAIM_ACTION_BEAN()
								.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID() });

				while (C2_REC.next()) {
					M_CCD_COVER_CODE = C2_REC.getString("CCD_COVER_CODE");
					M_CCD_LOSS_TYPE = C2_REC.getString("CCD_LOSS_TYPE");
					M_CCD_DISAB_TYPE = C2_REC.getString("CCD_DISAB_TYPE");

					C3_REC = handler.executeSelectStatement(C3, connection,
							new Object[] { M_CCD_COVER_CODE, M_CCD_LOSS_TYPE,
									M_CCD_DISAB_TYPE });
					if (C3_REC.next()) {
						M_CR_POLICY_VALID_YN = C3_REC.getString(1);
						M_CR_PREM_PAYABLE_YN = C3_REC.getString(2);
						M_COUNT = M_COUNT + 1;
					}
				}
				C4_REC=handler.executeSelectStatement(C4, connection, new Object[]{claimBean.getCLAIM_POL_SYS_ID()});
				while(C4_REC.next()){
					M_POL_END_NO_IDX=C4_REC.getInt(1);
				}
				if (M_COUNT > 0) {
					updateValue = handler.executeUpdateStatement(updateByPolId,
							connection, new Object[] { compositeAction
									.getPT_IL_CLAIM_ACTION_BEAN()
									.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID() });
					handler.executeInsertStatement(statusinsert, connection, new Object[]{claimBean.getCLAIM_POL_SYS_ID(),M_POL_END_NO_IDX,new CommonUtils().getCurrentDateAndTime(),"I08",claimBean.getCLAIM_CR_UID(),claimBean.getCLAIM_CR_UID(),claimBean.getCLAIM_CR_DT(),"S"});

				}
				

				if (("D".equalsIgnoreCase(claimBean.getCLAIM_TYPE()) || "A"
						.equalsIgnoreCase(claimBean.getCLAIM_TYPE()))
						&& ("N".equalsIgnoreCase(CommonUtils.nvl(
								compositeAction.getDUMMY_ACTION_BEAN()
										.getDUMMY_BEAN().getM_POLICY_YN_FL(),
								"X")))) {
					updateValue = handler.executeUpdateStatement(updateByPolNo,
							connection, new Object[] { claimBean
									.getCLAIM_POL_SYS_ID() });

				}

				if ("P".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN().getM_POL_STATUS())) {
					M_CE_FC_PREM_OS = 0.0;
					M_CE_LC_PREM_OS = 0.0;
					M_CE_FC_PREM_OS_INT = 0.0;
					M_CE_LC_PREM_OS_INT = 0.0;
				} else {

					ArrayList<OracleParameter> list = procedure
							.P_CALC_UNPAID_PREM_INT(claimBean
									.getCLAIM_POL_SYS_ID(), null, claimBean
									.getCLAIM_LOSS_DT(), M_CE_FC_PREM_OS,
									M_CE_LC_PREM_OS, M_CE_FC_PREM_OS_INT,
									M_CE_LC_PREM_OS_INT);
					if ((list.isEmpty()) && list != null) {
						M_CE_FC_PREM_OS = (Double) list.get(0).getValueObject();
						M_CE_LC_PREM_OS = (Double) list.get(1).getValueObject();
						M_CE_FC_PREM_OS_INT = (Double) list.get(2)
								.getValueObject();
						M_CE_LC_PREM_OS_INT = (Double) list.get(3)
								.getValueObject();
					}

				}

				if (M_CE_FC_PREM_OS > 0) {
					updateValue = handler.executeUpdateStatement(premColl,
							connection, new Object[] {
									claimBean.getCLAIM_LOSS_DT(),
									claimBean.getCLAIM_LOSS_DT(),
									claimBean.getCLAIM_POL_SYS_ID() });

					Long polSysId = claimBean.getCLAIM_POL_SYS_ID();
					Date lossDate = claimBean.getCLAIM_LOSS_DT();

					CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", claimBean
							.getCLAIM_POL_NO());
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
							polSysId != null ? String.valueOf(polSysId) : "");
					CommonUtils.setGlobalVariable("GLOBAL.M_APPRV_DATE",
							lossDate != null ? String.valueOf(lossDate) : "");
					CommonUtils.setGlobalVariable("GLOBAL.M_BROK_GEN_YN", null);
					return "PILP003";
				}
				
				/*changed by raja on 16-08-2017 for discussd with gourav*/
				String covercode=null;
				String Query_covercode="SELECT CCD_COVER_CODE FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID IN (?) AND NVL(CCD_FC_EST_AMT, 0) <> 0";
				ResultSet RScovercode=new CRUDHandler().executeSelectStatement(Query_covercode, CommonUtils.getConnection(), new Object[]{compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
				while(RScovercode.next())
				{
					covercode=RScovercode.getString("CCD_COVER_CODE");
				}
				/*end*/
				
				C5_REC=handler.executeSelectStatement(PremPayQuery, connection, new Object[]{/*PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE()*/covercode});
				while(C5_REC.next()){
					m_prem_pay = C5_REC.getString(1);
				}
				if("N".equalsIgnoreCase(m_prem_pay)){				
				int deleteInt = handler.executeDeleteStatement(deleteQuery,
						connection, new Object[] {
								claimBean.getCLAIM_LOSS_DT(),
								claimBean.getCLAIM_POL_SYS_ID() });
				}
				CommonUtils.getConnection().commit();

				compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN()
						.setUI_M_COMM_DEL("C");

				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(true);

				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN().getM_BUT_FRZ()
						.setDisabled(true);

				/*new CRUDHandler().executeSelectStatement(CLAIM_UPDATE,
						CommonUtils.getConnection(), new Object[] { "N",
								claimBean.getCLAIM_NO() });
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getPT_IL_CLAIM_BEAN().setCLAIM_FRZ_FLAG("N");*/
				/*
				 * compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				 * .getCOMP_UI_M_BUT_FRZ().setValue("UnFreeze");
				 */
			} else {
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(false);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(false);
				/*new CRUDHandler().executeSelectStatement(CLAIM_UPDATE,
						CommonUtils.getConnection(), new Object[] { "Y",
								claimBean.getCLAIM_NO() });
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getPT_IL_CLAIM_BEAN().setCLAIM_FRZ_FLAG("Y");*/
				/*
				 * compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				 * .getCOMP_UI_M_BUT_FRZ().setValue("Freeze");
				 */
				
				/*Commented by saranya on24-04-2017
				 * 
				 * Added by saranya for Education Endowment on 10-04-2017 
				Long claimSysId=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
				System.out.println("claimSysId  :"+claimSysId);
				P9ILPK_CLAIM.P_INS_CLM_ANN_DTLS(claimSysId);
				End*/
			}
			
			/*Added by saranya for Education Endowment on 24-04-2017 */
			Long claimSysId=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
			System.out.println("claimSysId  :"+claimSysId);
			P9ILPK_CLAIM.P_INS_CLM_ANN_DTLS(claimSysId);
			/*End*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);

			connection.commit();
		}

		return null;
	}

	/**
	 * 
	 * @param compositeAction
	 */
	public void policyButPressed(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String C1 = " SELECT POL_DS_CODE,POL_DS_TYPE,POL_PLAN_CODE, POL_PROD_CODE "
				+ "FROM PT_IL_POLICY WHERE  POL_SYS_ID = ?";

		String M_POL_DS_CODE = null;
		String M_POL_DS_TYPE = null;
		String M_POL_PLAN_CODE = null;
		String M_POL_PROD_CODE = null;
		ResultSet C1_REC = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID() });
			if (C1_REC.next()) {
				M_POL_DS_CODE = C1_REC.getString(1);
				M_POL_DS_TYPE = C1_REC.getString(2);
				M_POL_PLAN_CODE = C1_REC.getString(3);
				M_POL_PROD_CODE = C1_REC.getString(4);
			}

			Long polSysId = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
			if(!"PILT002_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))){
				CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
			}
			CommonUtils
					.setGlobalVariable("CALLING_FORM_OUTCOME", "claimsEntry");
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_1", M_POL_DS_CODE);
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_1", M_POL_DS_CODE);
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
					polSysId != null ? polSysId : "");
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_11", M_POL_DS_TYPE);
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_3", M_POL_PLAN_CODE);
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_6", M_POL_PROD_CODE);

		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}

	}

	/**
	 * 
	 * @param compositeAction
	 */
	public void onPopulateDetails(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN();

		if (pt_il_claim.getROWID() != null) {
			PT_IL_CLAIM_ESTIMATE_HELPER estimateHelper = new PT_IL_CLAIM_ESTIMATE_HELPER();
			estimateHelper.executeQuery(compositeAction);

			PM_IL_DOC_TODO_GROUP_HELPER todoGroupHelper = new PM_IL_DOC_TODO_GROUP_HELPER();
			todoGroupHelper.executeQuery(compositeAction);

			PT_IL_CLAIM_STATUS_1_HELPER pt_il_claim_status_1_helper = new PT_IL_CLAIM_STATUS_1_HELPER();
			pt_il_claim_status_1_helper.executeQuery(compositeAction);

			PT_IL_CLAIM_COVER_DTLS_HELPER pt_il_claim_cover_dtls_helper = new PT_IL_CLAIM_COVER_DTLS_HELPER();
			pt_il_claim_cover_dtls_helper.executeQuery(compositeAction);

			PT_IL_CLAIM_ACC_FIR_DTLS_HELPER pt_il_claim_acc_fir_dtls_helper = new PT_IL_CLAIM_ACC_FIR_DTLS_HELPER();
			pt_il_claim_acc_fir_dtls_helper.executeQuery(compositeAction);

			PT_IL_CLAIM_STATUS_3_HELPER pt_il_claim_status_3_helper = new PT_IL_CLAIM_STATUS_3_HELPER();
			pt_il_claim_status_3_helper.executeQuery(compositeAction);

			PT_IL_CLAIM_STATUS_2_HELPER pt_il_claim_status_2_helper = new PT_IL_CLAIM_STATUS_2_HELPER();
			pt_il_claim_status_2_helper.executeQuery(compositeAction);

			PT_IL_DOC_TODO_LIST_STATUS_HELPER pt_il_doc_todo_list_status_helper = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
			pt_il_doc_todo_list_status_helper.executeQuery(compositeAction);
		}
	}

	// The button enabling and disabling are mentioned in load_eng_bp
	public void LOAD_ENG_BP(PILT006_APAC_COMPOSITE_ACTION compositeAction) {

		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REOPEN()
				.setDisabled(true);
		// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getCOMP_CCD_SET_FLAG().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getCOMP_UI_M_BUT_HISTORY().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getCOMP_UI_M_BUT_RI().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getCOMP_UI_M_BUT_FAC().setDisabled(true);
		/*
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_SETTLEMENT', ENABLED, PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('PT_IL_CLAIM_COVER_DTLS.CCD_SET_FLAG',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('PT_IL_CLAIM_COVER_DTLS.M_BUT_HISTORY',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('PT_IL_CLAIM_COVER_DTLS.M_BUT_RI',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('PT_IL_CLAIM_COVER_DTLS.M_BUT_FAC',ENABLED,PROPERTY_FALSE);
		 */
	}
	
	//newly added by sujatha for checking the fund details block enabled or disabled
	
	public void fundDeatilsEnableOrDisable(DUMMY DUMMY_BEAN,PILT006_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE  NVL(PLAN_FRZ_FLAG,'N') = 'N' " +
		"AND PLAN_CODE = (SELECT POL_PLAN_CODE FROM PT_IL_POLICY WHERE POL_NO = ? " +
		"AND POL_DS_TYPE = '2')";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()});
			while(resultSet.next()){
				DUMMY_BEAN.setM_PLAN_TYPE(resultSet.getString(1));
			}
			if("U".equalsIgnoreCase(DUMMY_BEAN.getM_PLAN_TYPE())){
				compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
			}
			else{
				compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}
			catch (Exception e) {
			}
		}

	}
	
	public String getdbRowid(String currValue) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String dbRowId = null;
		String C1 = "SELECT ROWID FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{currValue});
			if(resultSet.next()){
				dbRowId = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return dbRowId;
		
	}
	public void chkRiFacClose(Date claim_loss_date ,Long pol_sys_id)throws Exception{
		String M_POL_FAC_YN = null;
		String M_POL_FAC_BASIS = null;

		String C1 = "SELECT 'X' FROM PT_IL_FAC_OUT, PT_IL_FAC_DETL "
				+ " WHERE FO_POL_SYS_ID = ? "
				+ " AND FD_FO_SYS_ID = FO_SYS_ID "
				+ " AND FD_SCHD_PYMT_DT <= ? "
				+ " AND NVL(FO_AC_CLOSE_YN,'N') = 'N' ";

		String C2 = " SELECT 'X' FROM PT_IL_RI_DETL WHERE RD_POL_SYS_ID = ? "+
                " AND NVL(RD_FRZ_FLAG,'N') = 'N' "+
                " AND ? > RD_PRD_TO_DT "+
                " AND ? NOT BETWEEN RD_PRD_FM_DT AND RD_PRD_TO_DT ";

			String C3="SELECT POL_FAC_YN,POL_FAC_BASIS FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
			CRUDHandler handler = new CRUDHandler();
			Connection connection = null;
			ResultSet C1_REC = null;
			ResultSet C2_REC = null;
			ResultSet C3_REC = null;
			Object [] values = new Object[]{ pol_sys_id ,claim_loss_date,claim_loss_date };
			try {
				connection = CommonUtils.getConnection();	
			
		C3_REC=handler.executeSelectStatement(C3, connection, new Object[]{ pol_sys_id });
         if(C3_REC.next()){
        	 M_POL_FAC_YN=C3_REC.getString(1);
        	 M_POL_FAC_BASIS=C3_REC.getString(2);
         }
         if("N".equalsIgnoreCase(CommonUtils.nvl(M_POL_FAC_YN, "X"))){
        	 C2_REC=handler.executeSelectStatement(C2, connection,values);
        	 if(C2_REC.next()){
            	 /*
            	  * Commented by Janani on 07.02.2017 as per Girish suggestion as it is not ZB requirement
            	  * 
            	  * 
            	  * throw new Exception("Close RI and Fac to apply Claim");*/
        		 
        		 System.out.println("C1_REC in RIFAC M_POL_FAC_YN is N           :"+C2_REC);
             }

         }
         else if("Y".equalsIgnoreCase(CommonUtils.nvl(M_POL_FAC_YN, "X"))){
        	 if("A".equalsIgnoreCase(CommonUtils.nvl(M_POL_FAC_BASIS, "X"))){
        		 C1_REC=handler.executeSelectStatement(C1, connection, new Object[]{ pol_sys_id,claim_loss_date });
        		 if(C1_REC.next()){
        	     	 /*
                	  * Commented by Janani on 07.02.2017 as per Girish suggestion as it is not ZB requirement
                	  * 
                	  * 
                	  * throw new Exception("Close RI and Fac to apply Claim");*/
        			 
        			 System.out.println("C1_REC in RIFAC            :"+C1_REC);
        			 
                 }
        		 C2_REC=handler.executeSelectStatement(C2, connection,values);
            	 if(C2_REC.next()){
                 	 /*
                	  * Commented by Janani on 07.02.2017 as per Girish suggestion as it is not ZB requirement
                	  * 
                	  * 
                	  * throw new Exception("Close RI and Fac to apply Claim");*/
            		 System.out.println("C2_REC in RIFAC            :"+C2_REC);
                 }

        	 }else  if("B".equalsIgnoreCase(CommonUtils.nvl(M_POL_FAC_BASIS, "X"))){
        		 C1_REC=handler.executeSelectStatement(C1, connection, new Object[]{ pol_sys_id,claim_loss_date });	
        		 if(C1_REC.next()){
        	     	 /*
                	  * Commented by Janani on 07.02.2017 as per Girish suggestion as it is not ZB requirement
                	  * 
                	  * 
                	  * throw new Exception("Close RI and Fac to apply Claim");*/
        			 
        			 System.out.println("C1_REC in RIFAC M_POL_FAC_BASIS is B           :"+C1_REC);
                 }
        	 }
         }
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	/*
	 * newly added 
	 */
	public void updatePolStatus(PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String updateQuery = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = ? WHERE POL_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			if("O".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())){
				handler.executeUpdateStatement(updateQuery, 
						connection,new Object[]{"",PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			}
			else{
			handler.executeUpdateStatement(updateQuery, 
					connection,new Object[]{"D01",PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		 
		
	}
	public void whenreopenButPressed(PILT006_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		
		String C3 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID= ? AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')" 
			+ "AND ASD_CODE = 'CLM_CLO_OPEN'";
		String C4="SELECT POL_PROD_CODE  FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
		ResultSet C4_REC = null;
		ResultSet C3_REC = null;
		String prod_code =null;
		String M_ASD_CHAR_VALUE=null;
		try{
			PT_IL_CLAIM PT_IL_CLAIM_BEAN= compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			Connection connection =CommonUtils.getConnection();
	   CRUDHandler handler= new CRUDHandler();
			C4_REC=handler.executeSelectStatement(C4, connection,new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			while(C4_REC.next()){
				prod_code=C4_REC.getString(1);
			}
			C3_REC= handler.executeSelectStatement(C3, connection,new Object[]{CommonUtils.getControlBean().getUSER_ID(),prod_code});
			while(C3_REC.next()){
				M_ASD_CHAR_VALUE= C3_REC.getString(1);
			}if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE,"N"))){
				throw new Exception("User not authorized to open the claim");

		
			} }catch(Exception e){
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	
		
	}
	

	/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	public void whenValidateClaimLossDate(Date CLAIM_LOSS_DT, DUMMY DUMMY_BEAN,PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN,String CLAIM_NO)
			throws Exception {

		/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		ResultSet resultSet2=null;
		Integer PLAN_CONT_PERIOD=null;
		String POAD_HIV_TEST_YN=null;
		String POL_END_TYPE=null;
		/*End*/
  		String M_PLAN_POL_VALID_AFTER_MAT_YN = null;
		Date M_PS_CR_DT = null;
		String M_POL_ADDL_STATUS = null;
		String C1 = "SELECT PLAN_POL_VALID_AFTER_MAT_YN "
				+ "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE = (SELECT POL_PLAN_CODE "
				+ "FROM   PT_IL_POLICY " + "WHERE  POL_SYS_ID = ? )";

		String C3 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String C2 = "SELECT PS_CR_DT FROM PT_IL_POL_STATUS WHERE "
				+ "PS_POL_SYS_ID = ?	AND PS_STATUS = ? ";

		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		try {

			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID() });
			while (C1_REC.next()) {
				M_PLAN_POL_VALID_AFTER_MAT_YN = C1_REC
						.getString("PLAN_POL_VALID_AFTER_MAT_YN");
			}
			Date M_POL_START_DT = DUMMY_BEAN.getM_POL_START_DT();
			Date M_POL_END_DT =DUMMY_BEAN.getM_POL_END_DT();

			if (CLAIM_LOSS_DT != null && M_POL_START_DT != null
 					&& CLAIM_LOSS_DT.before(M_POL_START_DT)) {
                /*Modified by Janani on 15.06.2017 for ZBILQC-1723154*/
				
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " should be grater than or equal to ", M_POL_START_DT }));*/
				
				System.out.println("M_POL_START_DT in helper           "+new SimpleDateFormat("dd/MM/yyyy").format(M_POL_START_DT));
				
				
				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " greater than or equal to ", new SimpleDateFormat("dd/MM/yyyy").format(M_POL_START_DT) }));
				
				
				/*End*/
			}

			if (CLAIM_LOSS_DT != null && M_POL_END_DT != null
					&& CLAIM_LOSS_DT.after(M_POL_END_DT)) {
				
				/*Modified by Janani on 15.06.2017 for ZBILQC-1723154*/

				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " should be less than or equal to ", M_POL_END_DT }));*/

				
				System.out.println("M_POL_END_DT            "+new SimpleDateFormat("dd/MM/yyyy").format(M_POL_END_DT));
				

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91091",
						new Object[] { " less than or equal to ", new SimpleDateFormat("dd/MM/yyyy").format(M_POL_END_DT) }));


				/*End*/
			}

			if (DUMMY_BEAN.getM_POL_NL_FM_DT() != null
					&& DUMMY_BEAN.getM_POL_NL_TO_DT() != null) {

				if (CLAIM_LOSS_DT.after(DUMMY_BEAN.getM_POL_NL_FM_DT())
						&& CLAIM_LOSS_DT.before(DUMMY_BEAN.getM_POL_NL_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71160",
							new Object[] { DUMMY_BEAN.getM_POL_NL_FM_DT(),
									DUMMY_BEAN.getM_POL_NL_TO_DT() }));
				}

			}

			if ("N".equals(CommonUtils.nvl(M_PLAN_POL_VALID_AFTER_MAT_YN, "N"))) {
				if (CLAIM_LOSS_DT != null
						&& DUMMY_BEAN.getM_POL_NL_FM_DT() != null
						&& DUMMY_BEAN.getM_POL_NL_TO_DT() != null
						&& !CLAIM_LOSS_DT.after(DUMMY_BEAN.getM_POL_NL_FM_DT())
						&& !CLAIM_LOSS_DT
								.before(DUMMY_BEAN.getM_POL_NL_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71191",
							new Object[] { DUMMY_BEAN.getM_POL_NL_FM_DT(),
									DUMMY_BEAN.getM_POL_NL_TO_DT() }));
				}
			}
			CommonUtils utils = new CommonUtils();

			if (CLAIM_LOSS_DT != null
					&& CLAIM_LOSS_DT.after(utils.getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60021"));
			}

			C3_REC = handler.executeSelectStatement(C3, connection,
					new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID() });
			while (C3_REC.next()) {
				M_POL_ADDL_STATUS = C3_REC.getString("POL_ADDL_STATUS");
			}

			CommonUtils.nvl(M_POL_ADDL_STATUS, "XXX");
			List<String> addStatus = new ArrayList<String>();
			addStatus.add("L01");
			addStatus.add("L02");
			addStatus.add("I05");

			if (addStatus.contains(M_POL_ADDL_STATUS)) {
				C2_REC = handler.executeSelectStatement(C2, connection,
						new Object[] { DUMMY_BEAN.getCLAIM_SYS_ID(),
								M_POL_ADDL_STATUS });
				while (C2_REC.next()) {
					M_PS_CR_DT = C2_REC.getDate("PS_CR_DT");
				}
			}

			if (M_PS_CR_DT != null) {
				if (CommonUtils.nvl(CLAIM_LOSS_DT, utils.getCurrentDate())
						.after(
								CommonUtils.nvl(M_PS_CR_DT, utils
										.getCurrentDate()))) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91091",
											new Object[] { "Less than the','Policy Lapse / Pre Lapse date" }));
				}
			}
			
			/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			System.out.println("M_POL_STATUS  ====  "+DUMMY_BEAN.getM_POL_STATUS());
			String query = "SELECT POAD_HIV_TEST_YN FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID=? AND POAD_ASSR_CODE = ?";
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] {PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(),PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_ASSR_CODE()});
			System.out.println("pol_sys_id****************"+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
			System.out.println("Assured code**************"+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_ASSR_CODE());
			if (resultSet.next()) {
				POAD_HIV_TEST_YN = resultSet.getString(1);
				System.out.println("HIV TEST Y/N::::::::::::::::::::::::"+POAD_HIV_TEST_YN);
			}
			
			/*Added by Saritha on 09-Jan-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			String cont_period_query ="SELECT PLAN_CONT_PERIOD FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE=POL_PLAN_CODE AND POL_SYS_ID=?";
			connection = CommonUtils.getConnection();
			resultSet2 = handler.executeSelectStatement(cont_period_query, connection,
					new Object[] {PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
			if (resultSet2.next()) {
				PLAN_CONT_PERIOD=resultSet2.getInt(1);
				System.out.println("Contestability Period::::::::::::::::::::::::"+PLAN_CONT_PERIOD);
			}
			
			/*End*/
			
			/*Commentted by saritha on 28-Feb-2017 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			
			/*if("N".equalsIgnoreCase(POAD_HIV_TEST_YN)) {*/

				Calendar cal = Calendar.getInstance();
				cal.setTime(CLAIM_LOSS_DT);
				int claimYear = cal.get(Calendar.YEAR);
				Calendar cal1 = Calendar.getInstance();
				cal.setTime(M_POL_START_DT);
				int polYear = cal.get(Calendar.YEAR);
				int M_DIFF_DATE_POL=claimYear-polYear;
				/*Newly added by pidugu raj dt: 10-11-2020 for Claim Contestiblity period check*/
				Calendar calClaimLoss = Calendar.getInstance();
				calClaimLoss.setTime(CLAIM_LOSS_DT);
				String claimLossDate = calClaimLoss.get(Calendar.DATE) + "-" + (calClaimLoss.get(Calendar.MONTH) + 1) + "-" +calClaimLoss.get(Calendar.YEAR);
				int numberOfMonths = 0;
				String policyStartDate = new SimpleDateFormat("MM-dd-yyyy").format(M_POL_START_DT);
				
				
				numberOfMonths = P_CLAIM_DATE_DIFF(claimLossDate, policyStartDate);
				/*End Newly added by pidugu raj dt: 10-11-2020 for Claim Contestiblity period check*/
				System.out.println("M_DIFF_DATE_POL  ====  "+M_DIFF_DATE_POL);
				/*if(M_DIFF_DATE_POL<5)
				{
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().resetValue();
				}*/

				String query1 = "SELECT POL_END_TYPE FROM PT_IL_POLICY WHERE POL_SYS_ID=? ";
				System.out.println("pol_sys_id****************"+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
				connection = CommonUtils.getConnection();
				resultSet1 = handler.executeSelectStatement(query1, connection,
						new Object[] {PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
				if (resultSet1.next()) {
					POL_END_TYPE = resultSet1.getString(1);
					System.out.println("Endorsement Type::::::::::::::::::::::::"+POL_END_TYPE);
				}

				/*if(DUMMY_BEAN.getM_POL_STATUS().equalsIgnoreCase("R"))*/
				/*if(POL_END_TYPE.equalsIgnoreCase("006"))*/
				if((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006")))
				{
					System.out.println(" end type equals of 006");

					cal = Calendar.getInstance();
					cal.setTime(CLAIM_LOSS_DT);
					int claimYears = cal.get(Calendar.YEAR);

					cal1 = Calendar.getInstance();
					cal.setTime(M_POL_END_DT);
					int endYear = cal1.get(Calendar.YEAR);

					int M_DIFF_DATE_END=claimYears-endYear;
					System.out.println("M_DIFF_DATE_END  ====  "+M_DIFF_DATE_END);
					/*Added by Saritha on 09-Jan-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc
					if(M_DIFF_DATE_END<PLAN_CONT_PERIOD)
					{
						System.out.println("inside DIFF_DATE_END<PLAN_CONT_PERIOD ");
						
						PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);*/
					if(numberOfMonths < 3){
						
						/*Modified by saritha on 03-08-2017 for ssp call id ZBILQC-1731636*/
						/*PT_IL_CLAIM_ACTION_BEAN.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please request for medical reports of the Assured");*/
						PT_IL_CLAIM_ACTION_BEAN.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"Record not Inserted/Updated :: " + "Claim is within Contestability Period");
						/*PT_IL_CLAIM_ACTION_BEAN.getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Claim is within Contestability Period. Please request for medical reports of the Assured");*/
						/*End*/
						
						
					}
				}
				else
				{
					System.out.println(" end type !equals of 006");

					/*if(M_DIFF_DATE_POL<PLAN_CONT_PERIOD)
					{

						System.out.println("inside DIFF_DATE_POL<PLAN_CONT_PERIOD ");*/
					if(numberOfMonths < 3){
						
						//PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
						//PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().resetValue();
						
						/*Modified by saritha on 03-08-2017 for ssp call id ZBILQC-1731636*/
						/*PT_IL_CLAIM_ACTION_BEAN.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please request for medical reports of the Assured");*/
						PT_IL_CLAIM_ACTION_BEAN.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"Record not Inserted/Updated :: " + "Claim is within Contestability Period");
						
						/*End*/
					}

				}

			/*}*/
			
			if (CLAIM_NO != null) {
				System.out.println("inside if");
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);			
			}

			/* End*/

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			/* End*/
			
		}
	}

	/* End*/
	
	/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
	
	public void whenValidateCLAIM_MEMB_CODE(PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN,Object value) {
		try {
			boolean flag=false;
			String queryMEMB="SELECT 'X' FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE "
					+ "PFMD_POL_SYS_ID = ? AND PFMD_CUST_CODE = ? AND  PFMD_STATUS = 'Y'";
			ResultSet rs=new CRUDHandler().executeSelectStatement(queryMEMB, CommonUtils.getConnection(), 
					new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),value});
			
			while(rs.next())
			{
				flag=true;
			}
			
			if(flag==true)
			{
				throw new Exception("Already claim registered for this Member");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	
	}
	
	/*end*/
	//Added by Ameen
		/*public String WHEN_BUTTON_PRESSED_M_BUT_OK()
		{
			System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
			String url = null;
				
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			url = request.getContextPath() + "/ReportServlet?";
			url = "http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath() + "/PREMIASchedule?";
			System.out.println("url   :  "+url);
		return url;	
		}*/
	/*ADDED BY SANKARA NARAYANAN ON 18/03/2017*/
	
	
	//Added by gopi for toi
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK(PILT006_APAC_PRINT_ACTION PILT006_APAC_PRINT_ACTION_BEAN) throws Exception
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
		String ScheduleReportType = null;
		
		ScheduleReportType = PILT006_APAC_PRINT_ACTION_BEAN.getScheduleReportType();
		
		System.out.println("ScheduleReportType in WHEN_BUTTON_PRESSED_M_BUT               :"+ScheduleReportType);
		
		/*added by gopi on 25/07/17*/
		String REPORT_CATG = null;
		String reportQuery1 = "select pmrth_report_catg from pm_rep_tab_hdr where pmrth_rep_id=?";
		ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{PILT006_APAC_PRINT_ACTION_BEAN.getUI_M_CLAIM_REPORT()});
		while(reportRSSS.next())
		{
			REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
		}
	
				
					if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
						ScheduleReportType = "1";	
					}else{
						ScheduleReportType = "2";
					}
				
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
		if(ScheduleReportType.equalsIgnoreCase("2"))   /*2-- Mdocs*/
		{
			url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		}
		else
		{
			url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/PREMIASchedule?";
		}
		
		
		
		System.out.println("url   :  "+url);
	return url;	
	}
	
	//end
	
	
	
	
	
	
	
	public void fetchPolicyAddress(PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN,String filedName,String fieldVale) throws Exception{
		CRUDHandler handler = null;
		Connection con = null;
		ResultSet rst = null;
		String polNumber = fieldVale;
		PT_IL_CLAIM claimsBean= PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN();
		/*
		 * Commented by sankara narayanan on 17/03/2017
		 * String selectQuery = "SELECT POL_RES_ADDRESS_1,POL_RES_ADDRESS_2,POL_RES_ADDRESS_3 FROM PT_IL_POLICY WHERE  "+filedName+"= ?";*/
		
		
		String selectQuery ="SELECT CUST_CODE,CUST_NAME,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3 FROM PM_CUSTOMER WHERE CUST_CODE =(SELECT POL_CUST_CODE "+
		          "FROM PT_IL_POLICY      WHERE "+filedName+"= ?)";

		
		String addr1 = null;
		String addr2 = null;
		String addr3 = null;
		String code = null;
		String name = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = { polNumber };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					/*
					 * 
					 * Commented by sankara narayanan on 17/03/2017
					 * addr1 = rst.getString("POL_RES_ADDRESS_1");
					addr2 = rst.getString("POL_RES_ADDRESS_2");
					addr3 = rst.getString("POL_RES_ADDRESS_3");*/
					 addr1 = rst.getString("CUST_ADDR1");
					addr2 = rst.getString("CUST_ADDR2");
					addr3 = rst.getString("CUST_ADDR3");
					code=rst.getString("CUST_CODE");
					name=rst.getString("CUST_NAME");
					addr1 = addr1 == null ? "" : addr1;
					addr2 = addr2 == null ? "" : addr2;
					addr3 = addr3 == null ? "" : addr3;
				}
		/*		claimsBean.setPCI_RES_ADDRESS_1(addr1);
				claimsBean.setPCI_RES_ADDRESS_2(addr2);
				claimsBean.setPCI_RES_ADDRESS_3(addr3);*/
				claimsBean.setCLAIM_CUST_CODE(code);
				claimsBean.setCLAIM_CUST_CODE_DESC(name);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_CLAIM_CUST_CODE().setSubmittedValue(code);
				PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_CUST_DESC().setSubmittedValue(name);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	/*END*/
	
	
	/*Added by Janani onb 16.06.2017 for ZBILQC-1723136*/
	
	public void whenValidateCreatedDate(Date CLAIM_CREATION_DT,
			DUMMY DUMMY_BEAN) throws Exception {

		System.out.println("enters into whenValidateCreatedDate");
		
		
		CommonUtils utils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		
		System.out.println("CLAIM_CREATION_DT               "+CLAIM_CREATION_DT);
		System.out.println("getCurrentDate               "+utils.getCurrentDate());
		
		
		if (CLAIM_CREATION_DT != null
				&& CLAIM_CREATION_DT.before(utils.getCurrentDate())
				|| CLAIM_CREATION_DT.after(utils.getCurrentDate())) {
			
			System.out.println("CLAIM_CREATION_DT is before current date");
			
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2312"));
		}
	
	}
	
	
	/*END*/
	
	/*added by raja to discuee with siva sir on 19-06-2017*/
    
    public ArrayList<OracleParameter> P_CALC_PREMIUM_FUNERAL(
            String P_CLAIM_POL_SYS_ID,    
 String P_CLAIM_SYS_ID,
 String P_MEMBER_CODE) throws ProcedureException {
Connection connection = null;
 ArrayList<OracleParameter> parameterList = null;
 ArrayList<OracleParameter> outputList = null;
 try {
 	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
  OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",P_CLAIM_POL_SYS_ID);
  parameterList.add(param1);
  OracleParameter param2 = new OracleParameter("IN2", "LONG", "IN",P_CLAIM_SYS_ID);
  parameterList.add(param2);
  OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_MEMBER_CODE);
  parameterList.add(param3);
 
 OracleProcedureHandler procHandler = new OracleProcedureHandler();
  outputList = procHandler.execute(parameterList, connection,
         "P9ILPK_F_POLICY.P_UPD_FUNERAL_MOP_PREM");
} catch(Exception e) {
  e.printStackTrace();
	ErrorHelpUtil.getErrorForProcedure(connection);
      throw new ProcedureException(e.getMessage());
}
return outputList;
}

    
    /*end*/
    
    /*Added by saritha on 08-07-2017 for ssp call id ZBILQC-1730887*/ 
	public void whenValidateClaimClaimantcode(
			PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN, String inputvalue) throws Exception {
		
			PT_IL_CLAIM claimBean = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN();
		try {
			
			if(inputvalue==null || inputvalue.trim().equalsIgnoreCase("")){
				throw new Exception("Select the - Claim code from LOV, if not available, please attach in Customer Setup and proceed");	
				
			}
			
		}
	    	
    	catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	/*End*/
	
	/*added by raja on 18-07-2017 for ZBILQC-1731514*/
	/*commentted by saritha on 30-10-2017 for Dependent Age is Greater than mentioned in Plan Member. Cannot Proceed as per Ajay sir sugg.*/
	/*public void callP_CLM_AGE_VALIDATION(String pol_sys_id,String Claim_memb_code) throws Exception
	{
		 
		Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
		  OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",pol_sys_id);
		  parameterList.add(param1);
		  OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",Claim_memb_code);
		  parameterList.add(param2);
		 
		 
		 OracleProcedureHandler procHandler = new OracleProcedureHandler();
		  outputList = procHandler.execute(parameterList, connection,
		         "P9ILPK_CLAIM.P_CLM_AGE_VALIDATION");
		} catch(Exception e) {
		  e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
		      throw new ProcedureException(e.getMessage());
		}
	}*/
	/*end*/
	
	/*Newly added by pidugu raj dt: 10-11-2020 as suggested by Abhilash and Ashok*/
	public int P_CLAIM_DATE_DIFF(
            String P_CLAIM_LOSS_DT,String P_POL_START_DT) throws ProcedureException {
Connection connection = null;
 ArrayList<OracleParameter> parameterList = null;
 ArrayList<OracleParameter> outputList = null;
 int numberOfMonths = 0;
 try {
 	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
	ArrayList<String> returnList = null;
  OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_LOSS_DT);
  parameterList.add(param1);
  OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_START_DT);
  parameterList.add(param2);
  OracleParameter param3 = new OracleParameter("OUT3", "INT", "OUT",null);
  parameterList.add(param3);
 
 OracleProcedureHandler procHandler = new OracleProcedureHandler();
  outputList = procHandler.execute(parameterList, connection,
         "P_CLAIM_DATE_DIFF");
  Iterator<OracleParameter> iterator = outputList.iterator();
	while (iterator.hasNext()) {
		OracleParameter oracleParameter = iterator.next();
		numberOfMonths = Integer.valueOf(oracleParameter.getValue());
	}
} catch(Exception e) {
  e.printStackTrace();
	ErrorHelpUtil.getErrorForProcedure(connection);
      throw new ProcedureException(e.getMessage());
}
return numberOfMonths;
}
	/*End Newly added by pidugu raj dt: 10-11-2020 as suggested by Abhilash and Ashok*/
}


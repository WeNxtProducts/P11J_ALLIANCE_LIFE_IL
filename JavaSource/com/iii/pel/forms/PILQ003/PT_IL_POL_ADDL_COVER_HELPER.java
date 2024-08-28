package com.iii.pel.forms.PILQ003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ADDL_COVER_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_POL_ADDL_COVER_DELEGATE().executeSelectStatement(
				compositeAction/*, compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID(),
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID()*/);

		List<PT_IL_POL_ADDL_COVER> dataList = compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = dataList.get(0);
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setPT_IL_POL_ADDL_COVER_BEAN(PT_IL_POL_ADDL_COVER_BEAN);
		}
	}

	public void preRecord(PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {

		Double M_NO_ASSR = null;
		String M_PLAN_TYPE = null;
		String M_COVER_CLASS = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		PT_IL_POL_ADDL_COVER coverBean = coverAction
		.getPT_IL_POL_ADDL_COVER_BEAN();
		String CURSOR_PLAN = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE = ? AND  PLAN_FRZ_FLAG = 'N'";
		String CURSOR_C6 = "SELECT COVER_CLASS FROM PM_IL_COVER WHERE  COVER_CODE= ? ";

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_PLAN, connection,
					new Object[] { policyBean.getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
				dummyBean.setUI_M_POL_PLAN_TYPE(M_PLAN_TYPE);
			}
			CommonUtils.closeCursor(resultSet);
			M_NO_ASSR = localProcedure.IL_GET_ASSR_NOS(M_NO_ASSR, policyBean
					.getPOL_SYS_ID());
			resultSet = handler.executeSelectStatement(CURSOR_C6, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("M".equals(M_COVER_CLASS)) {
				coverAction.getCOMP_POAC_MED_DAYS().setDisabled(false);
				coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(false);
			} else {
				coverAction.getCOMP_POAC_MED_DAYS().setDisabled(true);
				coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public String whenNewBlockInstance(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_THRESHOLD_MESSAGE = null;
		PT_IL_POL_ADDL_COVER_ACTION coverAction = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String Qury ="SELECT P9ILPK_POLICY.F_GET_THR_LIMIT_MSG  FROM DUAL";
		P9ILPK_POLICY pp = new P9ILPK_POLICY();
		ArrayList<OracleParameter> list = null;
		try {
			connection = CommonUtils.getConnection();
			executeQuery(compositeAction);
			resultSet = handler.executeSelectStatement(Qury, connection);
			if (resultSet.next()) {
				M_THRESHOLD_MESSAGE = resultSet.getString(1);
				}
          
			
			if ("A".equals(CommonUtils.nvl(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_APPRV_STATUS(), "N"))) {
				coverAction.setUPDATE_ALLOWED(false);
			} else {
				coverAction.setUPDATE_ALLOWED(true);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return M_THRESHOLD_MESSAGE;
		
	}

	public void preUpdate(PT_IL_POL_ADDL_COVER coverBean, CTRL ctrlBean)
	throws Exception {
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		try {
			coverBean.setPOAC_UPD_DT(new CommonUtils().getCurrentDate());
			coverBean.setPOAC_UPD_UID(ctrlBean.getUSER_ID());
			coverBean.setPOAC_WOP_FLAG(localProcedure.IL_POAC_WOP_CVR_VALIDATE(
													coverBean.getPOAC_COVER_CODE(),
													coverBean.getPOAC_WOP_FLAG(), "R"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_POL_ADDL_COVER coverBean, PT_IL_POL_COVER_GROUP pt_il_pol_cover_group,
			PT_IL_POL_ASSURED_DTLS AssuredBean,
			PT_IL_POLICY policyBean) throws Exception {

		String M_UNQ_ADDL_COVER_YN = null;
		String M_APPL_ALL = null;
		Double M_NO_ASSR = null;
		String CURSOR_C1 = "SELECT PIL_POAC_SYS_ID.NEXTVAL FROM DUAL";
		ArrayList<String> list = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				coverBean.setPOAC_SYS_ID(resultSet.getLong(1));
			}
			coverBean.setPOAC_DEL_FLAG("N");
			coverBean.setPOAC_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			coverBean.setPOAC_POAD_SYS_ID(AssuredBean.getPOAD_SYS_ID());
			coverBean.setPOAC_PCG_SYS_ID(pt_il_pol_cover_group.getPCG_SYS_ID() );
			
			coverBean.setPOAC_CR_DT(new CommonUtils().getCurrentDate());
			coverBean.setPOAC_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			list = localProcedure.IL_UNIQUE_ADDL_COVER_CODE(
					M_UNQ_ADDL_COVER_YN, M_APPL_ALL, "R", 
					coverBean.getPOAC_POAD_SYS_ID(),
					policyBean.getPOL_SYS_ID(),
					coverBean.getPOAC_COVER_CODE(), 
					coverBean.getROWID(),
					coverBean.getPOAC_PAPP_SYS_ID(),
					coverBean.getPOAC_PCG_SYS_ID());
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_UNQ_ADDL_COVER_YN = list.get(0);
				}if (list.get(1) != null) {
					M_APPL_ALL = list.get(1);
				}
			}
					
					
			if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71039"));
			}

			localProcedure.IL_UNIQUE_ADDL_COVER_ASSR_CODE(
					"R", 
					CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()),
					CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
					coverBean.getPOAC_COVER_CODE(),
					coverBean.getROWID(),
					coverBean.getPOAC_ASSR_CODE());
			coverBean.setPOAC_WOP_FLAG(localProcedure.IL_POAC_WOP_CVR_VALIDATE(
					coverBean.getPOAC_COVER_CODE(), 
					coverBean.getPOAC_WOP_FLAG(), "R"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void postQuery(PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POL_ASSURED_DTLS assuredBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {

		String M_COVER_SA_CALC = null;
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		PKG_PILQ003 localProcedures = new PKG_PILQ003();
		PT_IL_POL_ADDL_COVER coverBean = coverAction
		.getPT_IL_POL_ADDL_COVER_BEAN();
		String CURSOR_C1 = "SELECT COVER_SA_CALC FROM PM_IL_COVER WHERE COVER_CODE= ? ";
		/*
		 * P_GET_DEL_RECORD_PROPERTY('PT_IL_POL_ADDL_COVER',
		 * 'PT_IL_POL_ADDL_COVER.POAC_DEL_FLAG', :PT_IL_POLICY.POL_END_NO_IDX);
		 */

		try {
			list = procedures.helperP_VAL_COVER(coverBean.getPOAC_COVER_CODE(),"A", "N", "N");
			if (list != null  && !list.isEmpty()) {
				coverBean.setUI_M_POAC_COVER_DESC(list.get(0));
			}
				
			
			coverBean.setUI_M_POAC_ASSR_NAME(assuredBean.getPOAD_ASSURED_NAME());

			coverBean.setUI_M_POAC_FC_PREM(coverBean.getPOAC_FC_PREM()* policyBean.getPOL_MODE_OF_PYMT_RATE());
			coverBean.setUI_M_POAC_LC_PREM(coverBean.getPOAC_LC_PREM()* policyBean.getPOL_MODE_OF_PYMT_RATE());

			list1 = localProcedures.P_VAL_ROUND_AMT(
					dummyBean.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(coverBean.getUI_M_POAC_FC_PREM()),"R");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					coverBean.setUI_M_POAC_FC_PREM(Double.parseDouble(list1.get(0)));
				}
			}
			list2 = localProcedures.P_VAL_ROUND_AMT(
					dummyBean.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(coverBean.getUI_M_POAC_LC_PREM()), "R");
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0) != null) {
					coverBean.setUI_M_POAC_LC_PREM(Double.parseDouble(list2.get(0)));
				}
			}
					
				

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void keyDelRec(PT_IL_POL_ADDL_COVER_ACTION coverAction,PT_IL_POLICY policyBean,
			PT_IL_POL_ASSURED_DTLS assuredBean) throws Exception{

		String CURSOR_C1 ="SELECT PAC_MANDATORY_YN,PAC_COOL_OF_PD FROM   PM_IL_PROD_APPL_COVER " +
		"WHERE PAC_PROD_CODE  = ? AND PAC_COVER_CODE = ? "; 
		String CURSOR_C2 = "SELECT COVER_CLASS FROM PM_IL_COVER WHERE  COVER_CODE= ? ";
		String CURSOR_C3 = "SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE ='IL_DEL_RIDER' ";
		String  CURSOR_C4 = "SELECT POAC_MASTER_SYS_ID FROM PT_IL_POL_ADDL_COVER " +
		"WHERE POAC_POL_SYS_ID = ? AND POAC_SYS_ID =  ? ";
		String CURSOR_C5 = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE " +
		"POAC_POL_SYS_ID = ? AND POAC_SYS_ID = ? "; 
		String CURSOR_C6 = "SELECT POAC_MASTER_SYS_ID FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?" +
		"AND POAC_SYS_ID = ? AND POAC_COVER_CODE =  ? ";   
		String DELETE_QUERY = "DELETE FROM PT_IL_POL_ADDL_COVER WHERE " +
		"POAC_MASTER_SYS_ID = ? AND POAC_POL_SYS_ID = ? ";  
		String M_PS_CODE  =  null;
		Long M_POAC_MASTER_SYS_ID =  null;
		String M_PAC_MANDATORY_YN =  null;
		String M_COVER_CLASS = null; 
		Double M_PAC_COOL_OF_PD = null;
		String M_POAC_COVER_CODE  = null;
		String M_POL_PROD_CODE = null;
		Long M_POAD_SYS_ID = null;   
		Long M_POL_SYS_ID  = null; 
		String M_FOUND	= null;           
		PT_IL_POL_ADDL_COVER coverBean = coverAction.getPT_IL_POL_ADDL_COVER_BEAN();
		M_POAC_COVER_CODE = coverBean.getPOAC_COVER_CODE();
		M_POL_PROD_CODE   = policyBean.getPOL_PROD_CODE();
		M_POAD_SYS_ID     = assuredBean.getPOAD_SYS_ID();
		M_POL_SYS_ID   = policyBean.getPOL_SYS_ID();

		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new  CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 pilt002Procedures = new PKG_PILQ003();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			if (resultSet.next()) {
				M_PS_CODE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[]{M_POL_PROD_CODE,M_POAC_COVER_CODE});
			if (resultSet.next()) {
				M_PAC_MANDATORY_YN = resultSet.getString(1);
				M_PAC_COOL_OF_PD = resultSet.getDouble(2);
			}
			CommonUtils.closeCursor(resultSet);
			if ("Y".equals(M_PAC_MANDATORY_YN)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91079"));
			}
			if ("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")) && 
					M_PS_CODE.equals(policyBean.getPOL_END_CODE())) {
				if (policyBean.getPOL_END_EFF_FROM_DT().equals(policyBean.getPOL_START_DT())) {
					if (CommonUtils.subtractDate(
							policyBean.getPOL_END_DT(),policyBean.getPOL_END_EFF_FROM_DT()) > M_PAC_COOL_OF_PD) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",
								new Object[]{"Cool of Period for",M_POAC_COVER_CODE,"is",M_PAC_COOL_OF_PD }));
					}
				}
			}

			if ("000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C4, connection,
						new Object[]{M_POL_SYS_ID,coverBean.getPOAC_SYS_ID()});
				if (resultSet.next()) {
					M_POAC_MASTER_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C5, connection,
						new Object[]{M_POL_SYS_ID,coverBean.getPOAC_SYS_ID()});
				if (resultSet.next()) {
					M_POAC_MASTER_SYS_ID = resultSet.getLong(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "92006"));
				}else {
					handler.executeDeleteStatement(DELETE_QUERY, connection,
							new Object[]{coverBean.getPOAC_SYS_ID(),M_POL_SYS_ID});
				}
				CommonUtils.closeCursor(resultSet);
			}
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection, 
					new Object[]{coverBean.getPOAC_COVER_CODE()});
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("W".equals(M_COVER_CLASS) && "002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91410"));
			}
			if ("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
					&& !(M_PS_CODE.equals(policyBean.getPOL_END_CODE()))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91992"));
			}
			if ("1".equals(policyBean.getPOL_DS_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C6, connection, 
						new Object[]{M_POL_SYS_ID,coverBean.getPOAC_SYS_ID(),coverBean.getPOAC_COVER_CODE()});
				if (resultSet.next()) {
					M_POAC_MASTER_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
			}else {
				ArrayList<String> list = pilt002Procedures.P_DEL_MAST_DETL(
						coverBean.getPOAC_COVER_CODE(),
						policyBean.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
						CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), "1");
			}
			if ("000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))) {
				if ("Y".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N")) 
						&& policyBean.getPOL_END_TYPE() != null) {
					coverBean.setPOAC_RATE(0.00);
					coverBean.setPOAC_FC_PREM(0.00);
					coverBean.setPOAC_LC_PREM(0.00);
				}

				if ("Y".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))) {
					coverBean.setPOAC_FC_SA(coverBean.getPOAC_ORG_FC_SA() * -1);
					coverBean.setPOAC_LC_SA(coverBean.getPOAC_ORG_LC_SA() * -1);
					coverBean.setPOAC_FC_PREM(coverBean.getPOAC_ORG_FC_PREM() * -1);
					coverBean.setPOAC_LC_PREM(coverBean.getPOAC_ORG_LC_PREM() * -1);
					ArrayList<String> list1 = pilt002Procedures.P_DEL_MAST_DETL(
							coverBean.getPOAC_COVER_CODE(),
							policyBean.getPOL_PROD_CODE(),
							CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), "3");
				}else {
					coverBean.setPOAC_FC_SA(0.00);
					coverBean.setPOAC_LC_SA(0.00);
					coverBean.setPOAC_FC_PREM(0.00);
					coverBean.setPOAC_LC_PREM(0.00);
					ArrayList<String> list1 = pilt002Procedures.P_DEL_MAST_DETL(
							coverBean.getPOAC_COVER_CODE(),
							policyBean.getPOL_PROD_CODE(),
							CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), "2");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void whenCreateRecord(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POL_COVER_GROUP pt_il_pol_cover_group,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS asssuredBean) {
		coverBean.setPOAC_FM_DT(CommonUtils.nvl(policyBean
				.getPOL_END_EFF_FROM_DT(), policyBean.getPOL_ISSUE_DT()));
		coverBean.setPOAC_RATE_PER(1.00);
		coverBean.setPOAC_WOP_FLAG("N");
		coverBean.setPOAC_ASSR_CODE(asssuredBean.getPOAD_ASSR_CODE());
		coverBean.setUI_M_POAC_ASSR_NAME(asssuredBean.getPOAD_ASSURED_NAME());
		coverBean.setUI_M_PROD_CODE( policyBean.getPOL_PROD_CODE());
		coverBean.setUI_M_PCG_CODE(pt_il_pol_cover_group.getPCG_CODE() );
	}

	public void whenNewRecordInstance(PT_IL_POLICY policyBean,
			PT_IL_POL_ASSR_MED_HIST_ACTION medHistBean,
			PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POL_APPL_PROD pt_il_pol_appl_prod,
			PT_IL_POL_COVER_GROUP pt_il_pol_cover_group) throws Exception {

		String M_DMH_MANDATORY_YN = null;
		int M_COUNT;
		String M_THRESHOLD_MESSAGE = null;
		String M_VALUE = null;
		String M_COVER_SA_CALC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		String paddedString = null;
		String fieldName = null;
		Method method = null;
		UIInput uiInput = null;
		PT_IL_POL_ADDL_COVER pt_il_pol_addl_cover = coverAction.getPT_IL_POL_ADDL_COVER_BEAN();
		String CURSOR_C1 = "SELECT  NVL(DMH_MANDATORY_YN,'N') FROM    PM_IL_DOC_MED_HIST WHERE   "
			+ "DMH_DS_TYPE = ? AND DMH_DS_CODE = ?  AND DMH_APPL_ON IN ('R','B') AND ROWNUM  <=20 ";

		try {
			M_COUNT = 1;
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
					new Object[] {policyBean.getPOL_DS_TYPE(),policyBean.getPOL_DS_CODE() });
			while(resultSet.next()){
				paddedString = M_COUNT < 10 ? "0" + M_COUNT : String.valueOf(M_COUNT);
				M_DMH_MANDATORY_YN = resultSet.getString(1);
				fieldName = "COMP_PAMH_FIELD_" + paddedString;
				method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get" + fieldName);
				uiInput = (UIInput) method.invoke(medHistBean);
				if ("Y".equals(M_DMH_MANDATORY_YN)) {
					uiInput.setRequired(true);
				} else {
					uiInput.setRequired(false);
				}
				M_COUNT++;
			}
			
			pt_il_pol_addl_cover.setUI_M_PROD_CODE(pt_il_pol_appl_prod.getPAPP_PROD_CODE());
			pt_il_pol_addl_cover.setUI_M_PCG_CODE(pt_il_pol_cover_group.getPCG_CODE());
			   
			CommonUtils.closeCursor(resultSet);
			localProcedure.L_CHECK_COVER_CALC(coverAction,policyBean);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void preQuery(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POL_ASSURED_DTLS assuredBean) {
		coverBean.setPOAC_POAD_SYS_ID(assuredBean.getPOAD_SYS_ID());

	}

	public void POAC_COVER_CODE_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,PT_IL_POL_ADDL_COVER_ACTION coverAction) throws Exception {

		Date M_POAC_TO_DT = null;
		String M_COVER_CLASS = null;
		Double M_PAC_MED_AMT = null;
		Double M_PAC_MED_DAYS = null;
		Double M_POAD_AGE = null;
		Double M_PERIOD = 0.00;
		String M_PAC_COVER_START_AGE_VAL_YN = null;
		String M_PAC_AGE_BASIS = null;
		Double M_PAC_COVER_START_AGE = null;
		int M_PAC_MAT_PAYER_AGE = 0;
		int M_PAC_MAT_PAYEE_AGE = 0;
		String M_DUMMY = null;
		String M_UNQ_ADDL_COVER_YN = null;
		String M_APPL_ALL = null;
		String M_PAC_TARIFF_TERM_FLAG = null;
		String M_COVER_RATE_APPLIED_ON = null;
		Double M_POAC_LC_MED_AMT = null;
		Double M_NO_ASSR = null;
		int M_PAC_PERIOD = 0;
		int M_PAC_PREM_PAY_YRS = 0;
		int M_MIN_PAC_PREM_PAY_YRS = 0;
		int M_MIN_PAC_PERIOD = 0;
		Double M_COVER_SA_PERC = null;
		String M_POAC_RATE_APPLIED_ON = null;
		Double M_POAC_FC_SA = null;
		Double M_POAC_LC_SA = null;
		Double M_POAD_AGE_R = null;
		Double M_POAD_AGE_E = null;
		Double M_DIFF = null;
		int M_PAYEE_AGE = 0;
		int M_PAYER_AGE = 0;
		int M_DIFF_PERIOD = 0;
		
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS assuredBean = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 assured1Bean =compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_POL_APPL_PROD productBean = compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN();

		Date M_POL_START_DT = policyBean.getPOL_START_DT();
		
		/*String CURSOR_C1 = "SELECT  NVL(TAR_RATE_PER,1000) FROM PM_IL_TARIFF WHERE  TAR_PLAN_CODE  = ? "
							+ "AND ? BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO  AND ? BETWEEN TAR_AGE_FROM AND TAR_AGE_TO "
							+ " AND TAR_FRZ_FLAG   = 'N' ";
		String CURSOR_C2 = "SELECT PAC_TARIFF_TERM_FLAG, PAC_PERIOD, PAC_PREM_PAY_YRS,PAC_MAX_AGE_ON_MAT ," +
							"PAC_MED_DAYS,PAC_MED_AMT,PAC_COVER_START_AGE_VAL_YN,PAC_AGE_BASIS,PAC_COVER_START_AGE," +
							"PAC_MAT_PAYER_AGE,PAC_MAT_PAYEE_AGE FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE  =  ? " +
							"AND PAC_COVER_CODE = ? ";
		String CURSOR_C3 = "SELECT COVER_RATE_APPLIED_ON,COVER_MIN_SA,COVER_MAX_SA,NVL(COVER_SA_PERC,0) "
						+ "FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		String CURSOR_C4 = "SELECT LEAST(?,?) FROM   DUAL";
		String CURSOR_C5 = "SELECT LEAST(?,?) FROM   DUAL";
		String CURSOR_C6 = "SELECT COVER_CLASS,COVER_RATE_APPLIED_ON FROM PM_IL_COVER WHERE  COVER_CODE= ? ";
		String CURSOR_C7 = "SELECT POAD_AGE FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? AND " +
							"POAD_TYPE ='R'";
		String CURSOR_C8 = "SELECT POAD_AGE FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? AND " +
							"POAD_TYPE ='E' ";
		String CURSOR_C10 = "SELECT 'X' FROM     PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE  = ? AND " +
							"PAC_COVER_CODE = ? AND PAC_COVER_ASSR_TYPE IN ('R','B') ";*/
		
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ArrayList<String> list3 = null;
		ArrayList<String> list4 = null;
		
		DBProcedures procedures = new DBProcedures();
		
		PT_IL_POL_ADDL_COVER coverBean = coverAction.getPT_IL_POL_ADDL_COVER_BEAN();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		CRUDHandler handler = new CRUDHandler();
		/*-----------------------------------------------------------------------------------*/
		try {
			connection = CommonUtils.getConnection();
			/*if ("Y".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
				resultSet = handler.executeSelectStatement(CURSOR_C10, connection,
															new Object[] { 
																			productBean.getPAPP_PROD_CODE(),
																			coverBean.getPOAC_COVER_CODE() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91942"));
				}
				CommonUtils.closeCursor(resultSet);
			}
			-----------------------------------------------------------------------------------
			resultSet = handler.executeSelectStatement(CURSOR_C6, connection,new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
				M_COVER_RATE_APPLIED_ON = resultSet.getString(2);
			}
			CommonUtils.closeCursor(resultSet);
			list = localProcedure.P_VAL_PROD_COVER(
											coverBean.getPOAC_COVER_CODE(),
											coverBean.getUI_M_POAC_COVER_DESC(),
											productBean.getPAPP_PROD_CODE(), "N", "E");
			if (list != null && !list.isEmpty()) {
				coverBean.setUI_M_POAC_COVER_DESC((String)list.get(0).getValueObject());
			}
		
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, new Object[] {
																			coverBean.getPOAC_COVER_CODE(),
																			policyBean.getPOL_PERIOD(),
																			assuredBean.getPOAD_AGE() });
			if (resultSet.next()) {
				dummyBean.setUI_M_TAR_RATE_PER(resultSet.getDouble(1));
			}
			M_NO_ASSR = localProcedure.IL_GET_ASSR_NOS(M_NO_ASSR, policyBean.getPOL_SYS_ID());
			localProcedure.IL_UNIQUE_ADDL_COVER_CODE(
													M_UNQ_ADDL_COVER_YN,
													M_APPL_ALL, "R", 
													CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()),
													CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
													coverBean.getPOAC_COVER_CODE(), coverBean.getROWID());
			if (M_NO_ASSR > 1) {
				if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71039"));
				}
			} else {
				list2 = localProcedure.IL_POAC_GET_TARIFF_RATE(
															coverBean.getPOAC_COVER_CODE(),
															assuredBean.getPOAD_AGE(),
															policyBean.getPOL_END_TYPE(), 
															policyBean.getPOL_START_DT(),
															coverBean.getPOAC_RATE(),
															coverBean.getPOAC_ASSR_CODE(),
															policyBean.getPOL_SYS_ID(),
															policyBean.getPOL_PERIOD(),
															policyBean.getPOL_PLAN_CODE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0) != null) {
						coverBean.setPOAC_RATE(Double.parseDouble(list2.get(0)));
					}
				}
				if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71039"));
				}
			}
				
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] {
																		productBean.getPAPP_PROD_CODE(),
																		coverBean.getPOAC_COVER_CODE() });
			
			if (resultSet.next()) {
				M_PAC_TARIFF_TERM_FLAG = resultSet.getString(1);
				M_PAC_PERIOD = resultSet.getInt(2);
				M_PAC_PREM_PAY_YRS = resultSet.getInt(3);
				dummyBean.setUI_M_PAC_MAX_AGE_ON_MAT(resultSet.getDouble(4));
				M_PAC_MED_DAYS = resultSet.getDouble(5);
				M_PAC_MED_AMT = resultSet.getDouble(6);
				M_PAC_COVER_START_AGE_VAL_YN = resultSet.getString(7);
				M_PAC_AGE_BASIS = resultSet.getString(8);
				M_PAC_COVER_START_AGE = resultSet.getDouble(9);
				M_PAC_MAT_PAYER_AGE = resultSet.getInt(10);
				M_PAC_MAT_PAYEE_AGE = resultSet.getInt(11);
				if ("W".equals(M_COVER_CLASS) || "S".equals(M_COVER_CLASS)) {
					list3 = procedures.callP9ILPK_POLICY_P_CALC_COVER_SA(
													CommonUtils.getProcedureValue(coverBean.getPOAC_POL_SYS_ID()),
													coverBean.getPOAC_COVER_CODE(),
													CommonUtils.getProcedureValue(coverBean.getPOAC_SYS_ID()),
													M_POAC_RATE_APPLIED_ON,
													CommonUtils.getProcedureValue(M_POAC_FC_SA),
													CommonUtils.getProcedureValue(M_POAC_LC_SA),
													CommonUtils.getProcedureValue(M_PAC_MED_DAYS), 
													CommonUtils.getProcedureValue(M_PAC_MED_AMT),
													CommonUtils.getProcedureValue(coverBean.getPOAC_NO_OF_UNIT()), "N");
			
					if (list3 != null  && !list3.isEmpty()) {
						if (list3.get(0) != null ) {
							M_POAC_RATE_APPLIED_ON = list3.get(0);
						}if (list3.get(1) != null ) {
							M_POAC_FC_SA = Double.parseDouble(list3.get(1));
						}if (list3.get(2) != null ) {
							M_POAC_LC_SA = Double.parseDouble(list3.get(2));
						}
					}
				} else {
					if ("002".equals(policyBean.getPOL_END_TYPE())) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91410"));
					}
					M_POAC_RATE_APPLIED_ON = M_COVER_RATE_APPLIED_ON;
					M_POAC_FC_SA = 1.00;
					M_POAC_LC_SA = 1.00;
				}
				CommonUtils.closeCursor(resultSet);
				coverBean.setPOAC_RATE_APPLIED_ON(CommonUtils.nvl(M_POAC_RATE_APPLIED_ON, " "));
				coverBean.setPOAC_FC_SA(CommonUtils.nvl(M_POAC_FC_SA, 0));
				coverBean.setPOAC_LC_SA(CommonUtils.nvl(M_POAC_LC_SA, 0));
				coverBean.setPOAC_PERIOD(CommonUtils.nvl(M_PAC_PERIOD, 0));
				coverBean.setPOAC_TARIFF_TERM_FLAG(CommonUtils.nvl(M_PAC_TARIFF_TERM_FLAG, "P"));
				coverBean.setPOAC_PREM_PAY_YRS(CommonUtils.nvl(M_PAC_PREM_PAY_YRS,0));
				coverAction.getCOMP_POAC_TARIFF_TERM_FLAG().setDisabled(true);
				if ("M".equals(M_COVER_CLASS)) {
					coverAction.getCOMP_POAC_MED_DAYS().setDisabled(false);
					coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(false);
					coverBean.setPOAC_MED_DAYS(M_PAC_MED_DAYS);
					coverBean.setPOAC_LC_MED_AMT(M_POAC_LC_MED_AMT);
				} else {
					coverAction.getCOMP_POAC_MED_DAYS().setDisabled(true);
					coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(true);
				}
			}
			
			
			
				M_MIN_PAC_PREM_PAY_YRS = Math.min(policyBean.getPOL_PREM_PAY_YRS(), coverBean.getPOAC_PREM_PAY_YRS());
				coverBean.setPOAC_PREM_PAY_YRS(M_MIN_PAC_PREM_PAY_YRS);
				M_MIN_PAC_PERIOD = Math.min(policyBean.getPOL_PERIOD(),coverBean.getPOAC_PERIOD());
				coverBean.setPOAC_PERIOD(M_MIN_PAC_PERIOD);
			
			
					  
			
			
			if ("Y".equals(M_PAC_COVER_START_AGE_VAL_YN)) {
				if ("R".equals(M_PAC_AGE_BASIS)) {
					if (assuredBean.getPOAD_AGE() != null) {
						if (assuredBean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
							M_DIFF = (M_PAC_COVER_START_AGE - assuredBean.getPOAD_AGE()) * 12;
							M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(),M_DIFF.intValue());
						}
						if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
							M_PERIOD = 0;
							M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
						} else {
							if (assuredBean.getPOAD_AGE() < CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
								if (assuredBean.getPOAD_AGE()+ coverBean.getPOAC_PERIOD() > CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
									M_DIFF_PERIOD = (assuredBean.getPOAD_AGE() + coverBean
											.getPOAC_PERIOD()) - CommonUtils.nvl(M_PAC_MAT_PAYER_AGE,0);
									M_PERIOD = coverBean.getPOAC_PERIOD() - M_DIFF_PERIOD;
								}
							} else {
								M_PERIOD = 0;
							}
						}
					}
				} else if ("E".equals(M_PAC_AGE_BASIS)) {
					if (assured1Bean.getPOAD_AGE() != null) {
						if (assured1Bean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
							M_DIFF = (M_PAC_COVER_START_AGE - assured1Bean.getPOAD_AGE()) * 12;
							M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(),M_DIFF.intValue());
						}
						if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
							M_PERIOD = 0;
							M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
						} else {
							if (assured1Bean.getPOAD_AGE() < CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
								if (assured1Bean.getPOAD_AGE()+ coverBean.getPOAC_PERIOD() > CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
									M_DIFF_PERIOD = (assured1Bean.getPOAD_AGE() + coverBean.getPOAC_PERIOD()) - CommonUtils.nvl(M_PAC_MAT_PAYER_AGE,0);
									M_PERIOD = coverBean.getPOAC_PERIOD() - M_DIFF_PERIOD;
								}
							} else {
								M_PERIOD = 0;
							}
						}
					}
				} else if ("M".equals(M_PAC_AGE_BASIS)) {
					if (assured1Bean.getPOAD_AGE() != null && assuredBean.getPOAD_AGE() != null) {
						if ((M_PAC_MAT_PAYER_AGE - assuredBean.getPOAD_AGE()) < (M_PAC_MAT_PAYEE_AGE - assured1Bean.getPOAD_AGE())) {
							if (assuredBean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
								M_DIFF = (M_PAC_COVER_START_AGE - assuredBean.getPOAD_AGE()) * 12;
								M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
							}
							if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
								M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
								M_PERIOD = 0;
							} else {
								M_PERIOD = M_PAC_MAT_PAYER_AGE- assuredBean.getPOAD_AGE();
							}
						} else if ((M_PAC_MAT_PAYER_AGE - assuredBean.getPOAD_AGE()) < 
								(M_PAC_MAT_PAYEE_AGE - assured1Bean.getPOAD_AGE())) {
							if (assured1Bean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
								M_DIFF = (M_PAC_COVER_START_AGE - assured1Bean.getPOAD_AGE()) * 12;
								M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
							}
							if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
								M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
								M_PERIOD = 0;
							} else {
								M_PERIOD = M_PAC_MAT_PAYER_AGE- assured1Bean.getPOAD_AGE();
							}
						} else if (assured1Bean.getPOAD_AGE() != null && assuredBean.getPOAD_AGE() == null
								&& (CommonUtils.nvl(assuredBean.getPOAD_REF_ID1(),assuredBean.getPOAD_REF_ID2()) != CommonUtils
										.nvl(assuredBean.getPOAD_REF_ID1(),assuredBean.getPOAD_REF_ID2()))) {
							M_PAYEE_AGE = assuredBean.getPOAD_AGE();
							list4 = procedures
							.P9ILPK_POLICY_F_CALC_PAYER_AGE(CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()));
							if (list4 != null && !list4.isEmpty()) {
								M_PAYER_AGE = Integer.parseInt((list4.get(0)));
							}
							if ((M_PAC_MAT_PAYER_AGE - M_PAYER_AGE) <= (M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE)) {
								if (M_PAYER_AGE < M_PAC_COVER_START_AGE) {
									M_DIFF = (M_PAC_COVER_START_AGE - M_PAYER_AGE) * 12;
									M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
								}
								if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
									M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
									M_PERIOD = 0;
								} else {
									M_PERIOD = M_PAC_MAT_PAYER_AGE - M_PAYER_AGE;
								}
							} else if ((M_PAC_MAT_PAYER_AGE - M_PAYER_AGE) >=(M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE)) {
								if (M_PAYEE_AGE < M_PAC_COVER_START_AGE) {
									M_DIFF = (M_PAC_COVER_START_AGE - M_PAYEE_AGE) * 12;
									M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
								}
								if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
									M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
									M_PERIOD = 0;
								} else {
									M_PERIOD = M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE;
								}
							}
						}
					}
				}
				if (((Date) CommonUtils.addMonthsToDate(M_POL_START_DT, M_PERIOD * 12)).after(
						(Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_PERIOD * 12))) {
					String Query = "SELECT(ROUND(MONTHS_BETWEEN(ADD_MONTHS(?, ? *12), ?)))/12 FROM DUAL";
					resultSet = handler.executeSelectStatement(Query, connection,new Object[] { 
																					policyBean.getPOL_START_DT(),
																					M_PERIOD,M_POL_START_DT });
					if (resultSet.next()) {
						M_PERIOD = resultSet.getInt(1);
					}
					CommonUtils.closeCursor(resultSet);
				}
			} else {
				if ("R".equals(M_PAC_AGE_BASIS)) {
					if (assuredBean.getPOAD_AGE() != null) {
						if (assuredBean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
							M_DIFF = (M_PAC_COVER_START_AGE - assuredBean.getPOAD_AGE()) * 12;
							M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(),M_DIFF.intValue());
						}
						if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
							M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
							M_PERIOD = 0;
						} else {
							if (assuredBean.getPOAD_AGE() < CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
								if (assuredBean.getPOAD_AGE()+ coverBean.getPOAC_PERIOD() > CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
									M_DIFF_PERIOD = (assuredBean.getPOAD_AGE() + coverBean.getPOAC_PERIOD()) - CommonUtils.nvl(M_PAC_MAT_PAYER_AGE,0);
									M_PERIOD = coverBean.getPOAC_PERIOD()- M_DIFF_PERIOD;
								}
							} else {
								M_PERIOD = 0;
							}
						}
					}
				} else if ("E".equals(M_PAC_AGE_BASIS)) {
					if (assured1Bean.getPOAD_AGE() != null) {
						if (assured1Bean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
							M_DIFF = (M_PAC_COVER_START_AGE - assured1Bean.getPOAD_AGE()) * 12;
							M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(),M_DIFF.intValue());
						}
						if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
							M_PERIOD = 0;
							M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
						} else {
							if (assured1Bean.getPOAD_AGE() < CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
								if (assured1Bean.getPOAD_AGE()+ coverBean.getPOAC_PERIOD() > CommonUtils.nvl(M_PAC_MAT_PAYER_AGE, 0)) {
									M_DIFF_PERIOD = (assured1Bean.getPOAD_AGE() + coverBean.getPOAC_PERIOD())- CommonUtils.nvl(M_PAC_MAT_PAYER_AGE,0);
									M_PERIOD = coverBean.getPOAC_PERIOD()- M_DIFF_PERIOD;
								}
							} else {
								M_PERIOD = 0;
							}
						}
					}
				} else if ("M".equals(M_PAC_AGE_BASIS)) {
					if (assured1Bean.getPOAD_AGE() != null&& assuredBean.getPOAD_AGE() != null) {
						if ((M_PAC_MAT_PAYER_AGE - assuredBean.getPOAD_AGE()) < (M_PAC_MAT_PAYEE_AGE - assured1Bean.getPOAD_AGE())) {
							if (assuredBean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
								M_DIFF = (M_PAC_COVER_START_AGE - assuredBean.getPOAD_AGE()) * 12;
								M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
							}
							if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
								M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
								M_PERIOD = 0;
							} else {
								M_PERIOD = M_PAC_MAT_PAYER_AGE - assuredBean.getPOAD_AGE();
							}
			
						} else if ((M_PAC_MAT_PAYER_AGE - assuredBean.getPOAD_AGE()) <(M_PAC_MAT_PAYEE_AGE - assured1Bean.getPOAD_AGE())) {
							if (assured1Bean.getPOAD_AGE() < M_PAC_COVER_START_AGE) {
								M_DIFF = (M_PAC_COVER_START_AGE - assured1Bean.getPOAD_AGE()) * 12;
								M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
							}
							if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
								M_POL_START_DT = (Date) policyBean.getPOL_START_DT();M_PERIOD = 0;
							} else {
								M_PERIOD = M_PAC_MAT_PAYER_AGE - assured1Bean.getPOAD_AGE();
							}
						} else if (assured1Bean.getPOAD_AGE() != null && assuredBean.getPOAD_AGE() == null
								&& (CommonUtils.nvl(assuredBean.getPOAD_REF_ID1(),assuredBean.getPOAD_REF_ID2()) 
										!= CommonUtils.nvl(assuredBean.getPOAD_REF_ID1(),assuredBean.getPOAD_REF_ID2()))) {
							M_PAYEE_AGE = assuredBean.getPOAD_AGE();
							list4 = procedures.P9ILPK_POLICY_F_CALC_PAYER_AGE(CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()));
							if (list4 != null && !list4.isEmpty()) {
								M_PAYER_AGE = Integer.parseInt((list4.get(0)));
							}
							if ((M_PAC_MAT_PAYER_AGE - M_PAYER_AGE) <= (M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE)) {
								if (M_PAYER_AGE < M_PAC_COVER_START_AGE) {
									M_DIFF = (M_PAC_COVER_START_AGE - M_PAYER_AGE) * 12;
									M_POL_START_DT = (Date) CommonUtils
									.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
								}
								if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
									M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
									M_PERIOD = 0;
								} else {
									M_PERIOD = M_PAC_MAT_PAYER_AGE - M_PAYER_AGE;
								}
							} else if ((M_PAC_MAT_PAYER_AGE - M_PAYER_AGE) >= (M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE)) {
								if (M_PAYEE_AGE < M_PAC_COVER_START_AGE) {
									M_DIFF = (M_PAC_COVER_START_AGE - M_PAYEE_AGE) * 12;
									M_POL_START_DT = (Date) CommonUtils.addMonthsToDate(policyBean.getPOL_START_DT(), M_DIFF.intValue());
								}
								if (M_POL_START_DT.after(policyBean.getPOL_EXPIRY_DT())) {
									M_POL_START_DT = (Date) policyBean.getPOL_START_DT();
									M_PERIOD = 0;
								} else {
									M_PERIOD = M_PAC_MAT_PAYEE_AGE - M_PAYEE_AGE;
								}
							}
						}
					}
				}
			}
			
			if (M_PERIOD == 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007"));
			}
			if (M_POL_START_DT != null) {
				coverBean.setPOAC_FM_DT(M_POL_START_DT);
			}
			M_POAC_TO_DT = (Date) CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(), M_PERIOD * 12);
			if (M_POAC_TO_DT.after(policyBean.getPOL_EXPIRY_DT())) {
				M_POAC_TO_DT = (Date) policyBean.getPOL_EXPIRY_DT();
				String Query = "SELECT (ROUND(MONTHS_BETWEEN(?, ?)))/12 FROM DUAL" ;
				resultSet = handler.executeSelectStatement(Query, connection,new Object[] { M_POAC_TO_DT, M_POL_START_DT });
				if (resultSet.next()) {
					M_PERIOD = resultSet.getInt(1);
				}
				CommonUtils.closeCursor(resultSet);
			}
			coverBean.setPOAC_TO_DT(M_POAC_TO_DT);
			if (M_PERIOD != 0) {
				coverBean.setPOAC_PERIOD(M_PERIOD);
			}
			if (coverBean.getPOAC_PREM_PAY_YRS() <= 0) {
				coverBean.setPOAC_PREM_PAY_YRS(1);
			} else if (coverBean.getPOAC_PREM_PAY_YRS() > coverBean.getPOAC_PERIOD()) {
				coverBean.setPOAC_PREM_PAY_YRS(coverBean.getPOAC_PERIOD());
			}
*/
			
			
			String M_COVER_MEDICAL_YN = null;
			String M_COVER_LIMIT_TYPE = null;
			Double M_COVER_PER_DAY_LC_AMT = null;
			Integer M_COVER_LIMIT_DAYS = null;
			Double M_COVER_LC_LIMIT = null;
			
			
			       
			String CURSOR_C1 = "SELECT  NVL(TAR_RATE_PER,1000) FROM   PM_IL_TARIFF WHERE  TAR_PLAN_CODE  = ?" +
			"AND ? BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO AND  ?  BETWEEN TAR_AGE_FROM AND TAR_AGE_TO  AND  TAR_FRZ_FLAG   = 'N'";
			String  CURSOR_C2 = "SELECT PAC_TARIFF_TERM_FLAG, PAC_PERIOD,PAC_PREM_PAY_YRS,PAC_MAX_AGE_ON_MAT,PAC_MED_DAYS,PAC_MED_AMT" +
			"  FROM   PM_IL_PROD_APPL_COVER WHERE  PAC_PROD_CODE  = ?  AND    PAC_COVER_CODE = ? ";
			String CURSOR_C3 = "SELECT COVER_RATE_APPLIED_ON,COVER_MIN_SA,COVER_MAX_SA,NVL(COVER_SA_PERC,0) FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
			String CURSOR_C6 = "SELECT COVER_CLASS,COVER_RATE_APPLIED_ON,COVER_MEDICAL_YN,COVER_LIMIT_TYPE,COVER_PER_DAY_LC_AMT,COVER_LIMIT_DAYS,COVER_LC_LIMIT " +
			" FROM PM_IL_COVER WHERE  COVER_CODE= ? ";
			String CURSOR_C7 = "SELECT NVL(POAD_AGE,0) FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? AND  POAD_TYPE ='R'";
			String CURSOR_C8 = "SELECT NVL(POAD_AGE,0) FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? AND  POAD_TYPE ='E' ";  
			String CURSOR_C9 = "SELECT PAC_MED_DAYS,PAC_MED_DAYS FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND  PAC_COVER_CODE = ? "; 
			String CURSOR_C10 = "SELECT 'X' FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE  = ?  AND  PAC_COVER_CODE = ?	AND PAC_COVER_ASSR_TYPE IN ('R','B') ";
	
			
			
if (coverBean.getPOAC_COVER_CODE() != null) {
	if ("Y".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
		resultSet = handler.executeSelectStatement(CURSOR_C10, connection, new Object[]{productBean.getPAPP_PROD_CODE(),coverBean.getPOAC_COVER_CODE(),});
		if (resultSet.next()) {
			M_DUMMY = resultSet.getString(1);
		}else {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91942"));
		}
	}
	CommonUtils.closeCursor(resultSet);
	resultSet = handler.executeSelectStatement(CURSOR_C6,connection, new Object[]{coverBean.getPOAC_COVER_CODE()});
	if (resultSet.next()) {
		 M_COVER_CLASS = resultSet.getString(1);
		 M_COVER_RATE_APPLIED_ON = resultSet.getString(2);
		 M_COVER_MEDICAL_YN = resultSet.getString(3);
		 M_COVER_LIMIT_TYPE = resultSet.getString(4);
		 M_COVER_PER_DAY_LC_AMT = resultSet.getDouble(5);
		 M_COVER_LIMIT_DAYS = resultSet.getInt(6);
		 M_COVER_LC_LIMIT =resultSet.getDouble(7);
	}
	list = localProcedure.P_VAL_PROD_COVER(coverBean.getPOAC_COVER_CODE(), 
									coverBean.getUI_M_POAC_COVER_DESC(),
									productBean.getPAPP_PROD_CODE(),
									"N","E");
	if (list != null && !list.isEmpty()) {
		coverBean.setUI_M_POAC_COVER_DESC((String)list.get(0).getValueObject());
	}
	
	CommonUtils.closeCursor(resultSet);
	resultSet = handler.executeSelectStatement(CURSOR_C1, connection, 
			new Object[]{coverBean.getPOAC_COVER_CODE(),policyBean.getPOL_PERIOD(),assuredBean.getPOAD_AGE()});
	if (resultSet.next()) {
		dummyBean.setUI_M_TAR_RATE_PER(resultSet.getDouble(1));
	}
	CommonUtils.closeCursor(resultSet);
	M_NO_ASSR = localProcedure. IL_GET_ASSR_NOS(M_NO_ASSR, policyBean.getPOL_SYS_ID());
	list1 = localProcedure.IL_UNIQUE_ADDL_COVER_CODE(M_UNQ_ADDL_COVER_YN, M_APPL_ALL,"R", coverBean.getPOAC_POAD_SYS_ID(),
			coverBean.getPOAC_POL_SYS_ID(),
			coverBean.getPOAC_COVER_CODE(), coverBean.getROWID(),
			coverBean.getPOAC_PAPP_SYS_ID(),coverBean.getPOAC_PCG_SYS_ID());
	if (list1 != null && !list.isEmpty()) {
		if (list1.get(0) != null) {
			M_UNQ_ADDL_COVER_YN = (String) list1.get(0);
		}if (list1.get(1) != null) {
			M_APPL_ALL = (String) list1.get(2);
		}
	}

	
	if (M_NO_ASSR > 1) {
		if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71039"));
		}
	
	}else {
		
		list2 = localProcedure. IL_POAC_GET_TARIFF_RATE(coverBean.getPOAC_COVER_CODE(),
												assuredBean.getPOAD_AGE(),
												dummyBean.getUI_M_POL_PLAN_TYPE(),
												policyBean.getPOL_ISSUE_DT(),
												coverBean.getPOAC_RATE(),
												coverBean.getPOAC_ASSR_CODE(),
												coverBean.getPOAC_POL_SYS_ID(),
												policyBean.getPOL_PERIOD(),
												policyBean.getPOL_PLAN_CODE());
													if (list2 != null && !list2.isEmpty()) {
														if (list2.get(0) != null) {
															M_POAD_AGE = Double.parseDouble(list2.get(0));
														}
													}
													if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
														throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71039"));
													}
													
	}
	CommonUtils.closeCursor(resultSet);
	resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
			new Object[]{productBean.getPAPP_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
if (resultSet.next()) {
	M_PAC_TARIFF_TERM_FLAG = resultSet.getString(1); 
	M_PAC_PERIOD = resultSet.getInt(2);
	M_PAC_PREM_PAY_YRS = resultSet.getInt(3);
	dummyBean.setUI_M_PAC_MAX_AGE_ON_MAT(resultSet.getDouble(4));
    M_PAC_MED_DAYS = resultSet.getDouble(5);
    M_PAC_MED_AMT = resultSet.getDouble(6);
    if ((!"W".equals(M_COVER_CLASS)) ||   (!"S".equals(M_COVER_CLASS))) {
		if ("M".equals(M_COVER_CLASS)) {
				resultSet1 = handler.executeSelectStatement(CURSOR_C9, connection, new Object[]{productBean.getPAPP_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
				if (resultSet1.next()) {
					coverBean.setPOAC_MED_DAYS(resultSet1.getDouble(1));
					coverBean.setPOAC_LC_MED_AMT(resultSet1.getDouble(2));
				}
		}
		list = new ArrayList<OracleParameter>();
		list = new P9ILPK_POLICY().P_CALC_COVER_SA(coverBean.getPOAC_POL_SYS_ID(),
				coverBean.getPOAC_COVER_CODE(), coverBean.getPOAC_SYS_ID(),
				M_POAC_RATE_APPLIED_ON, M_POAC_FC_SA, M_POAC_LC_SA, 
				coverBean.getPOAC_MED_DAYS(),
				coverBean.getPOAC_LC_MED_AMT(), coverBean.getPOAC_NO_OF_UNIT(),
				"N", null, coverBean.getPOAC_PAPP_SYS_ID(),
				coverBean.getPOAC_PCG_SYS_ID());
		if (list != null && !list.isEmpty()) {
			if (list.get(0).getValueObject() != null) {
				M_POAC_RATE_APPLIED_ON =(String)list.get(0).getValueObject();
			}if (list.get(1).getValueObject() != null) {
				M_POAC_FC_SA  =(Double)list.get(1).getValueObject();
			}if (list.get(2).getValueObject() != null) {
				M_POAC_LC_SA =(Double)list.get(2).getValueObject();
			}
		}
    }else {
		if ("002".equals(policyBean.getPOL_END_TYPE())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91410"));
		}
		M_POAC_RATE_APPLIED_ON = M_COVER_RATE_APPLIED_ON;
		M_POAC_FC_SA =1.00;
		M_POAC_LC_SA =1.00;
	}
    coverBean.setPOAC_RATE_APPLIED_ON(CommonUtils.nvl(M_POAC_RATE_APPLIED_ON, ""));
    coverBean.setPOAC_FC_SA(CommonUtils.nvl(M_POAC_FC_SA,0.00));
    coverBean.setPOAC_LC_SA(CommonUtils.nvl(M_POAC_LC_SA,0.00));
    coverBean.setPOAC_PERIOD(CommonUtils.nvl(M_PAC_PERIOD,0));
    coverBean.setPOAC_TARIFF_TERM_FLAG(CommonUtils.nvl(M_PAC_TARIFF_TERM_FLAG,"P"));
    coverBean.setPOAC_PREM_PAY_YRS(CommonUtils.nvl(M_PAC_PREM_PAY_YRS,0));
    
    coverAction.getCOMP_POAC_TARIFF_TERM_FLAG().setDisabled(true);
    if ("M".equals(M_COVER_CLASS)) {
		coverAction.getCOMP_POAC_MED_DAYS().setDisabled(false);
		coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(false);
		coverBean.setPOAC_MED_DAYS(M_PAC_MED_DAYS);
		coverBean.setPOAC_LC_MED_AMT(M_PAC_MED_AMT);
	}else {
		coverAction.getCOMP_POAC_MED_DAYS().setDisabled(true);
		coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(true);
	}
}
CommonUtils.closeCursor(resultSet);
CommonUtils.closeCursor(resultSet1);


if ("R".equals(CommonUtils.nvl(assuredBean.getPOAD_TYPE(),"N"))) {

	resultSet = handler.executeSelectStatement(CURSOR_C7, connection,new Object[]{policyBean.getPOL_SYS_ID()});
	if (resultSet.next()) {
		M_POAD_AGE = resultSet.getDouble(1);
	}
	CommonUtils.closeCursor(resultSet);
	if (dummyBean.getUI_M_PAC_MAX_AGE_ON_MAT() != null) {
		M_PERIOD = dummyBean.getUI_M_PAC_MAX_AGE_ON_MAT() - CommonUtils.nvl(M_POAD_AGE,0);
	}else {
		M_PERIOD = 0.00;
	}
}else if ("E".equals(CommonUtils.nvl(assuredBean.getPOAD_TYPE(),"N"))) {
	resultSet = handler.executeSelectStatement(CURSOR_C8, connection,new Object[]{policyBean.getPOL_SYS_ID()});
	if (resultSet.next()) {
		M_POAD_AGE = resultSet.getDouble(1);
	}
	CommonUtils.closeCursor(resultSet);
	if (dummyBean.getUI_M_PAC_MAX_AGE_ON_MAT() != null) {
		M_PERIOD = dummyBean.getUI_M_PAC_MAX_AGE_ON_MAT() - CommonUtils.nvl(M_POAD_AGE,0);
	}else {
		M_PERIOD = 0.00;
	}
}
		
M_MIN_PAC_PREM_PAY_YRS = Math.min(policyBean.getPOL_PREM_PAY_YRS(),coverBean.getPOAC_PREM_PAY_YRS());
coverBean.setPOAC_PREM_PAY_YRS(M_MIN_PAC_PREM_PAY_YRS);
M_MIN_PAC_PERIOD = Math.min(policyBean.getPOL_PERIOD(),coverBean.getPOAC_PERIOD());
coverBean.setPOAC_PERIOD(M_MIN_PAC_PERIOD);
if ("Y".equals(M_COVER_MEDICAL_YN)) {
	coverAction.getCOMP_POAC_LIMIT_TYPE().setRendered(true);
	coverAction.getCOMP_POAC_PER_DAY_LC_AMT().setRendered(true);
	coverAction.getCOMP_POAC_LIMIT_DAYS().setRendered(true);
	coverAction.getCOMP_POAC_LC_LIMIT().setRendered(true);
	coverAction.getCOMP_UI_M_BTN_BENEFIT_DTLS().setDisabled(false);
	coverBean.setPOAC_LIMIT_TYPE(M_COVER_LIMIT_TYPE);
	coverBean.setPOAC_PER_DAY_LC_AMT(M_COVER_PER_DAY_LC_AMT);
	coverBean.setPOAC_LIMIT_DAYS(M_COVER_LIMIT_DAYS);
	coverBean.setPOAC_LC_LIMIT(M_COVER_LC_LIMIT);
	coverBean.setPOAC_LC_SA(M_COVER_LC_LIMIT);
	coverBean.setPOAC_FC_SA(M_COVER_LC_LIMIT);
}else {
	coverAction.getCOMP_POAC_LIMIT_TYPE().setDisabled(true);
	coverAction.getCOMP_POAC_PER_DAY_LC_AMT().setDisabled(true);
	coverAction.getCOMP_POAC_LIMIT_DAYS().setDisabled(true);
	coverAction.getCOMP_POAC_LC_LIMIT().setDisabled(true);
	coverAction.getCOMP_UI_M_BTN_BENEFIT_DTLS().setDisabled(true);
}
	
	
	
}
			

									
								
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_NO_OF_UNIT_WHEN_VALIDATE_ITEM(
			PT_IL_POL_ADDL_COVER coverBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {

		String M_COVER_CLASS = null;
		String M_POAC_RATE_APPLIED_ON = null;
		Double M_POAC_FC_SA = null;
		Double M_POAC_LC_SA = null;
		Double M_COVER_SA_PERC = null;
		String M_COVER_SA_CALC = null;
		Double M_DUMMY_MIN_UNIT = null;
		Double M_DUMMY_MAX_UNIT = null;
		Double M_DUMMY_MIN_SA = null;
		Double M_DUMMY_MAX_SA = null;
		Double M_POAC_LC_MED_AMT = null;
		String CURSOR_C1 = "SELECT COVER_SA_CALC,COVER_MIN_UNIT,COVER_MAX_UNIT ,COVER_SA_PERC," +
		"COVER_MIN_SA,COVER_MAX_SA FROM PM_IL_COVER WHERE COVER_CODE= ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		DBProcedures procedures = new DBProcedures();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_SA_CALC = resultSet.getString(1);
				M_DUMMY_MIN_UNIT = resultSet.getDouble(2);
				M_DUMMY_MAX_UNIT = resultSet.getDouble(3);
				M_COVER_SA_PERC = resultSet.getDouble(4);
				M_DUMMY_MIN_SA = resultSet.getDouble(5);
				M_DUMMY_MAX_SA = resultSet.getDouble(6);
			}
			if ("U".equals(M_COVER_SA_CALC)) {
				list = procedures.callP9ILPK_POLICY_P_CALC_COVER_SA(
						CommonUtils.getProcedureValue(coverBean.getPOAC_POL_SYS_ID()),
						coverBean.getPOAC_COVER_CODE(), 
						CommonUtils.getProcedureValue(M_POAC_RATE_APPLIED_ON),
						CommonUtils.getProcedureValue(M_POAC_FC_SA),
						CommonUtils.getProcedureValue(M_POAC_LC_SA),
						CommonUtils.getProcedureValue(coverBean.getPOAC_MED_DAYS()),
						CommonUtils.getProcedureValue(coverBean.getPOAC_LC_MED_AMT()),
						CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
						CommonUtils.getProcedureValue(coverBean.getPOAC_NO_OF_UNIT()),
						CommonUtils.getProcedureValue(coverBean.getPOAC_SYS_ID()));
					if (list != null && !list.isEmpty() ) {
						if (list.get(0) != null ) {
							M_POAC_RATE_APPLIED_ON = list.get(0);
						}if (list.get(0) != null ) {
							M_POAC_FC_SA = Double.parseDouble(list.get(1));
						}if (list.get(0) != null ) {
							M_POAC_LC_SA = Double.parseDouble(list.get(2));
						}
					}
					coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);
					if (coverBean.getPOAC_NO_OF_UNIT() != null) {
						if ("U".equals(M_COVER_SA_CALC)) {
							Double temp = CommonUtils.nvl(coverBean.getPOAC_NO_OF_UNIT(), 0)
							+ CommonUtils.nvl(coverBean.getPOAC_ORG_NO_OF_UNIT(), 0);
							
						if (temp != M_DUMMY_MIN_UNIT && temp != M_DUMMY_MAX_UNIT) {
							if ("000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
									|| "000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
											&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "000"))) {
								throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
										new Object[] {"Cover unit Between units",M_DUMMY_MIN_UNIT," and ",M_DUMMY_MAX_UNIT }));
							}
						}
					}
				}
				if (!(dummyBean.getUI_M_PS_CODE().equals(CommonUtils.nvl(policyBean.getPOL_END_CODE(), "000")))){
					if (!("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")))
						&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
								&& coverBean.getPOAC_FC_SA() <= 0) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
								new Object[] { "FC sum assured greater than 0" }));
					}
				}
				Double temp1 = CommonUtils.nvl(coverBean.getPOAC_FC_SA(), 0)
				+ CommonUtils.nvl(coverBean.getPOAC_ORG_FC_SA(), 0);
				if (temp1 != M_DUMMY_MAX_SA && temp1 != M_DUMMY_MIN_SA) {
					if ("000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
							|| "002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
									&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
								"91014", new Object[] {	"Cover SA between FC_SA",M_DUMMY_MIN_SA, " and ",M_DUMMY_MAX_SA }));
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_FM_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {
		if (coverBean.getPOAC_FM_DT().before(policyBean.getPOL_START_DT())
				|| coverBean.getPOAC_FM_DT().after(
						policyBean.getPOL_EXPIRY_DT())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
					new Object[] {"Cover Date between", policyBean.getPOL_START_DT(),
						policyBean.getPOL_EXPIRY_DT()}));
		}
		if (coverBean.getPOAC_TO_DT() != null
				&& coverBean.getPOAC_FM_DT().after(coverBean.getPOAC_TO_DT())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", 
					new Object[] {"Cover From date less tha or equal to",coverBean.getPOAC_TO_DT() }));
		}

		if (coverBean.getPOAC_PERIOD() != 0) {
			if (CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
					coverBean.getPOAC_PERIOD().intValue() * 12).after(
							policyBean.getPOL_EXPIRY_DT())) {
				coverBean.setPOAC_TO_DT(policyBean.getPOL_EXPIRY_DT());
			} else {
				if ("O".equals(dummyBean.getUI_M_PROD_MATU_DT())) {
					coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
							CommonUtils.addMonthsToDate(coverBean
									.getPOAC_FM_DT(), coverBean
									.getPOAC_PERIOD().intValue() * 12), -1));
				} else {
					coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
							coverBean.getPOAC_FM_DT(), coverBean
							.getPOAC_PERIOD().intValue() * 12));
				}
			}
		} else {
			coverBean.setPOAC_TO_DT(coverBean.getPOAC_FM_DT());
		}
	}

	public void POAC_TO_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String Query = "SELECT ROUND(CEIL(MONTHS_BETWEEN( ? , ? ))/12) FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			if (coverBean.getPOAC_TO_DT().after(policyBean.getPOL_EXPIRY_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"91014",new Object[] { "Cover to Date less than or equal to Expiry date" }));
			}

			if (coverBean.getPOAC_FM_DT().after(coverBean.getPOAC_TO_DT())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Cover To Date greater than",
								coverBean.getPOAC_FM_DT() }));
			}

			POAC_FM_DT_WHEN_VALIDATE_ITEM(coverBean, policyBean, dummyBean);
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { coverBean.getPOAC_TO_DT(),
					coverBean.getPOAC_FM_DT() });
			if (resultSet.next()) {
				coverBean.setPOAC_PERIOD(resultSet.getInt(1));
			}
				
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_PERIOD_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS assuredBean,
			PT_IL_POL_ASSURED_DTLS_1 assured1Bean, DUMMY dummyBean)
	throws Exception {
		if (coverBean.getPOAC_PERIOD() > policyBean.getPOL_PERIOD()) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91080"));
		}
		int M_DUMMY = 0;
		Double M_DUMMY_1 = 0.0d;
		Double M_PAC_MAX_AGE_ON_MAT = 0.0d;
		Double M_PAC_MAT_PAYER_AGE = 0.0d;
		int M_PAC_MAT_PAYEE_AGE = 0;
		String M_PAC_AGE_BASIS = null;
		int M_PAC_PREM_PAY_YRS = 0;
		String M_PAC_COVER_CODE = null;
		String M_DUMMY1 = null;
		String M_DUMMY2 = null;
		int M_ADDLCOVER_DIFF = 0;
		int M_ADDLCOVER_DIFF_1 = 0;
		String CURSOR_C0 = "SELECT PAC_COVER_CODE FROM   PM_IL_PROD_APPL_COVER  WHERE  PAC_PROD_CODE = ? "
			+ "AND    PAC_COVER_CODE = ? AND PAC_MASTER_COVER_CODE IS NULL ";
		String CURSOR_C0A = "SELECT 'X' FROM PM_IL_PROD_APPL_COVER WHERE PAC_MASTER_COVER_CODE = ? AND "
			+ "PAC_MASTER_COVER_CODE IS NOT NULL ";
		String CURSOR_C1 = "SELECT PAC_MAX_AGE_ON_MAT,PAC_MAT_PAYER_AGE,PAC_MAT_PAYEE_AGE,PAC_AGE_BASIS," +
		"PAC_PREM_PAY_YRS FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ? ";
		String CURSOR_C2 = "SELECT (PAC_PERIOD - PAC_PREM_PAY_YRS) FROM PM_IL_PROD_APPL_COVER " +
		"WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ?";
		String CURSOR_C3 = " SELECT POAC_ORG_PERIOD - POAC_ORG_PREM_PAY_YRS FROM PT_IL_POL_ASSURED_DTLS," +
		"PT_IL_POL_ADDL_COVER WHERE POAD_SYS_ID = ? AND POAD_POL_SYS_ID = ? AND POAC_COVER_CODE = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_PROD_CODE(),coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_PAC_MAX_AGE_ON_MAT = resultSet.getDouble(1);
				M_PAC_MAT_PAYER_AGE = resultSet.getDouble(2);
				M_PAC_MAT_PAYEE_AGE = resultSet.getInt(3);
				M_PAC_AGE_BASIS = resultSet.getString(4);
				M_PAC_PREM_PAY_YRS = resultSet.getInt(5);
			}
			CommonUtils.closeCursor(resultSet);
			if ("M".equals(M_PAC_AGE_BASIS)) {
				if (assuredBean.getPOAD_AGE() != null
						&& assured1Bean.getPOAD_AGE() == null
						&& CommonUtils.nvl(assuredBean.getPOAD_REF_ID1(),
								assuredBean.getPOAD_REF_ID2()) != CommonUtils
								.nvl(policyBean.getPOL_ASSRD_REF_ID1(),policyBean.getPOL_ASSRD_REF_ID2())) {

				} else {
					M_DUMMY_1 = Math.min(Math.abs(assuredBean.getPOAD_AGE()- M_PAC_MAT_PAYER_AGE), 
							Math.abs(CommonUtils.nvl(assured1Bean.getPOAD_AGE(), 0)- M_PAC_MAT_PAYEE_AGE));

				}
				if (CommonUtils.nvl(coverBean.getPOAC_PERIOD(), 0) > M_DUMMY_1) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
							new Object[] {"Cover Period <= Difference", M_DUMMY_1 }));
				}

			} else {
				M_DUMMY = CommonUtils.nvl(coverBean.getPOAC_PERIOD(), 0)
				+ CommonUtils.nvl(assuredBean.getPOAD_AGE(), 0);
				if (M_DUMMY >  M_PAC_MAX_AGE_ON_MAT ) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
							new Object[] { "Cover Period + Assured Age"," <= Maximum Maturity Age",M_PAC_MAX_AGE_ON_MAT }));
				}
			}
			if (CommonUtils.addDaysToDate(
					((Date) CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
							coverBean.getPOAC_PERIOD().intValue() * 12)), -1).after(
									policyBean.getPOL_EXPIRY_DT())) {
				coverBean.setPOAC_TO_DT(policyBean.getPOL_EXPIRY_DT());
				resultSet = handler.executeSelectStatement(
						"SELECT MONTHS_BETWEEN( ? , ? )/12 FROM DUAL", connection,
						new Object[] {coverBean.getPOAC_TO_DT(),coverBean.getPOAC_FM_DT() });
				if (resultSet.next()) {
					coverBean.setPOAC_PERIOD(resultSet.getInt(1));
				}
					
				CommonUtils.closeCursor(resultSet);
			} else {
				if ("O".equals(dummyBean.getUI_M_PROD_MATU_DT())) {
					coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
							CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
									coverBean.getPOAC_PERIOD().intValue() * 12), -1));
				} else {
					coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
							coverBean.getPOAC_FM_DT(), coverBean.getPOAC_PERIOD().intValue() * 12));
				}
			}

			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { policyBean.getPOL_PROD_CODE(),
					coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_ADDLCOVER_DIFF = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { assuredBean.getPOAD_SYS_ID(),policyBean.getPOL_SYS_ID(),coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_ADDLCOVER_DIFF_1 = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			coverBean.setPOAC_PREM_PAY_YRS(
					Math.min(policyBean.getPOL_PREM_PAY_YRS(), CommonUtils.nvl(coverBean.getPOAC_PERIOD(), 0)
							- CommonUtils.nvl(CommonUtils.nvl(M_ADDLCOVER_DIFF_1,M_ADDLCOVER_DIFF), 0)));
			if (coverBean.getPOAC_PREM_PAY_YRS() <= 0) {
				coverBean.setPOAC_PREM_PAY_YRS(1);
			} else if (coverBean.getPOAC_PREM_PAY_YRS() > M_PAC_PREM_PAY_YRS) {
				coverBean.setPOAC_PREM_PAY_YRS(M_PAC_PREM_PAY_YRS);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}

	}

	public String POAC_FC_SA_WHEN_VALIDATE_ITEM(DUMMY dummyBean,
			PT_IL_POL_ADDL_COVER coverBean, PT_IL_POLICY policyBean)
	throws Exception {

		Double M_COVER_SA_PERC = null;
		Double M_DUMMY = null;
		Double M_DUMMY_MIN = null;
		Double M_DUMMY_MAX = null;
		String M_COVER_TYPE = null;
		String M_THRESHOLD_MESSAGE = null;
		String CURSOR_C1 = "SELECT COVER_MIN_SA,COVER_MAX_SA,COVER_SA_PERC,COVER_TYPE " +
				"FROM PM_IL_COVER WHERE COVER_CODE = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 pilt002Procedures = new PKG_PILQ003();
		P9ILPK_POLICY ILprocedure = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		String selectQuery ="SELECT  P9ILPK_POLICY.F_GET_THR_LIMIT_MSG FROM DUAL";
		ArrayList<OracleParameter> list3 = null;
		try {
			connection = CommonUtils.getConnection();
			dummyBean.setUI_M_CHANGE_SA_YN("Y");
			if (!(dummyBean.getUI_M_PS_CODE().equals(CommonUtils.nvl(policyBean.getPOL_END_CODE(), "000")))) {
				if (!("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")))
					&&( !( "012".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))))
						&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
								&& coverBean.getPOAC_FC_SA() <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "FC Sum Assured","Greater than 0" }));
				}
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				dummyBean.setUI_M_COVER_MIN_SA(resultSet.getDouble(1));
				dummyBean.setUI_M_COVER_MAX_SA(resultSet.getDouble(2));
				M_COVER_SA_PERC = resultSet.getDouble(3);
				M_COVER_TYPE = resultSet.getString(4);
			}
			CommonUtils.closeCursor(resultSet);
			M_DUMMY = (M_COVER_SA_PERC / 100)
			* CommonUtils.nvl(policyBean.getPOL_LC_SUM_ASSURED(), 0);
			M_DUMMY = CommonUtils.ROUND(M_DUMMY, 3);

			if (M_DUMMY < dummyBean.getUI_M_COVER_MIN_SA()) {
				M_DUMMY = dummyBean.getUI_M_COVER_MIN_SA();
			}
			if (M_DUMMY > dummyBean.getUI_M_COVER_MAX_SA()) {
				M_DUMMY = dummyBean.getUI_M_COVER_MAX_SA();
			}
			M_DUMMY_MIN = CommonUtils.ROUND(
					(dummyBean.getUI_M_COVER_MIN_SA() / policyBean
							.getPOL_SA_EXCH_RATE()), 0);
			M_DUMMY_MAX = CommonUtils.ROUND(
					(dummyBean.getUI_M_COVER_MAX_SA() / policyBean
							.getPOL_SA_EXCH_RATE()), 0);
			if (dummyBean.getUI_M_COVER_MIN_SA() != null
					&& dummyBean.getUI_M_COVER_MAX_SA() != null) {
				if ("B".equals(M_COVER_TYPE)) {
					if (CommonUtils.nvl(coverBean.getPOAC_FC_SA(), 0)
							+ CommonUtils.nvl(coverBean.getPOAC_ORG_FC_SA(), 0) < M_DUMMY_MIN
							&& CommonUtils.nvl(coverBean.getPOAC_FC_SA(), 0)
							+ CommonUtils.nvl(coverBean
									.getPOAC_ORG_FC_SA(), 0) < M_DUMMY_MAX) {
						if ("000".equals(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))
								|| "000".equals(CommonUtils.nvl(policyBean
										.getPOL_END_TYPE(), "000"))
										&& "N".equals(CommonUtils.nvl(coverBean
												.getPOAC_DEL_FLAG(), "N"))) {
							throw new Exception(Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91014", new Object[] {
													"Cover SA Between FC SA",
													M_DUMMY_MIN, "and",
													M_DUMMY_MAX }));
						}
					}
				}
			}

			list = pilt002Procedures.P_VAL_ROUND_AMT(
					policyBean.getPOL_SA_CURR_CODE(),
					coverBean.getPOAC_FC_SA()
					.toString(), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					coverBean.setPOAC_FC_SA(Double.parseDouble(list.get(0)));
				}
			}
					
				
			coverBean.setPOAC_LC_SA(coverBean.getPOAC_FC_SA()* policyBean.getPOL_SA_EXCH_RATE());
			list1 = pilt002Procedures.P_VAL_ROUND_AMT(policyBean
					.getPOL_SA_CURR_CODE(), coverBean.getPOAC_LC_SA()
					.toString(), "R");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					coverBean.setPOAC_LC_SA(Double.parseDouble(list1.get(0)));
				}
			}
				
			
			CommonUtils.setGlobalVariable("GLOBAL.M_GRP_THRESHOLD", "Y");
			ILprocedure.P_CHECK_COVER_SA(
					CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
					coverBean.getPOAC_COVER_CODE(),
					CommonUtils.getProcedureValue(CommonUtils.nvl(coverBean.getPOAC_LC_SA(),0)
							+ CommonUtils.nvl(coverBean.getPOAC_ORG_FC_SA(), 0)));
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(selectQuery,connection);
			if (resultSet.next()) {
				M_THRESHOLD_MESSAGE = resultSet.getString(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
		return M_THRESHOLD_MESSAGE;
	}

	public String POAC_LC_SA_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {

		String M_THRESHOLD_MESSAGE = null;
		dummyBean.setUI_M_CHANGE_SA_YN("Y");
		DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 pilt002Procedures = new PKG_PILQ003();
		P9ILPK_POLICY ILProcedure = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String Query = "SELECT  P9ILPK_POLICY.F_GET_THR_LIMIT_MSG  FROM DUAL";
		ArrayList<OracleParameter> list2 = null;
		ArrayList<OracleParameter> list3 = null;

		try {
			connection = CommonUtils.getConnection();
			list = pilt002Procedures.P_VAL_ROUND_AMT(
					dummyBean.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(coverBean.getPOAC_LC_SA()),"V");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					coverBean.setPOAC_LC_SA(Double.parseDouble(list.get(0)));
				}
			}
					
				
			list1 = procedures.callP_VAL_FC_LC_TOLERANCE(
					CommonUtils.getProcedureValue(coverBean.getPOAC_FC_SA()), 
					CommonUtils.getProcedureValue(coverBean.getPOAC_LC_SA()), 
					CommonUtils.getProcedureValue(policyBean.getPOL_EXC_INT_PERC()),"E");

			coverBean.setPOAC_FC_SA(coverBean.getPOAC_LC_SA()
					/ policyBean.getPOL_SA_EXCH_RATE());
			CommonUtils.setGlobalVariable("GLOBAL.M_GRP_THRESHOLD", "Y");
			ILProcedure.P_CHECK_COVER_SA(
					CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
					coverBean.getPOAC_COVER_CODE(), 
					CommonUtils.getProcedureValue(CommonUtils.nvl(coverBean.getPOAC_LC_SA(), 0) 
							+ CommonUtils.nvl(coverBean.getPOAC_FC_SA(), 0)));
		  resultSet = handler.executeSelectStatement(Query, connection);
			if (resultSet.next()) {
				M_THRESHOLD_MESSAGE = resultSet.getString(1);
			}
				
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				
			}
		}
		return M_THRESHOLD_MESSAGE;
	}

	public void POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER coverBean)
	throws Exception {
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		String list = null;
		try {
			list = localProcedure.IL_POAC_WOP_CVR_VALIDATE(
					coverBean.getPOAC_COVER_CODE(), 
					coverBean.getPOAC_WOP_FLAG(), "R");
			if (list != null) {
				coverBean.setPOAC_WOP_FLAG(list);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POAC_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean) throws Exception {

		String M_COVER_PREM_TYPE = null;

		String CURSOR_C1 = "SELECT COVER_PREM_TYPE FROM PM_IL_COVER WHERE COVER_CODE =  ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_PREM_TYPE = resultSet.getString(1);
			}

			if ("T".equals(M_COVER_PREM_TYPE)) {
				if (coverBean.getPOAC_RATE() != null) {
					coverBean.setPOAC_RATE_PER(1.00);
					if ("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))
							|| "000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))) {
						coverBean.setPOAC_FC_PREM((CommonUtils.nvl(coverBean.getPOAC_RATE(), 0) 
								- CommonUtils.nvl(coverBean.getPOAC_ORG_FC_PREM(), 0)));
					}
					localProcedure.P_VAL_ROUND_AMT(
							policyBean.getPOL_SA_CURR_CODE(),
							CommonUtils.getProcedureValue(coverBean.getPOAC_FC_PREM()), "R");
					coverBean.setPOAC_LC_PREM(coverBean.getPOAC_FC_PREM()* policyBean.getPOL_SA_EXCH_RATE());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
	}

	public void POAC_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean)
	throws Exception {

		String M_COVER_PREM_TYPE = null;

		String CURSOR_C1 = "SELECT COVER_PREM_TYPE FROM PM_IL_COVER WHERE COVER_CODE = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (coverBean.getPOAC_RATE_PER() == null) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "60034"));
			}

			if (coverBean.getPOAC_RATE_PER() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { coverBean
						.getPOAC_COVER_CODE() });
				if (resultSet.next()) {
					M_COVER_PREM_TYPE = resultSet.getString(1);
				}
				if ("T".equals(M_COVER_PREM_TYPE)) {
					if (coverBean.getPOAC_RATE_PER() != 1.0d) {
						coverBean.setPOAC_RATE_PER(1.00);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_MED_DAYS_WHEN_VALIADTE_ITEM(PT_IL_POL_ADDL_COVER coverBean)
	throws Exception {

		String M_POAC_RATE_APPLIED_ON = null;
		String M_COVER_CLASS = null;
		Double M_POAC_FC_SA = null;
		Double M_POAC_LC_SA = null;
		Double M_POAC_LC_MED_AMT = null;
		String CURSOR_C1 = "SELECT COVER_CLASS,COVER_RATE_APPLIED_ON FROM   PM_IL_COVER WHERE  COVER_CODE= ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<OracleParameter> list = null;
		P9ILPK_POLICY ILprocedure = new P9ILPK_POLICY();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
				M_POAC_RATE_APPLIED_ON = resultSet.getString(2);
				if ("M".equals(M_COVER_CLASS)) {
					list = ILprocedure.P_CALC_COVER_SA(
							coverBean.getPOAC_POL_SYS_ID(),
							coverBean.getPOAC_COVER_CODE(),
							coverBean.getPOAC_SYS_ID(),
							M_POAC_RATE_APPLIED_ON,
							M_POAC_FC_SA,
							M_POAC_LC_SA,
							coverBean.getPOAC_MED_DAYS(),
							coverBean.getPOAC_LC_MED_AMT(),
							coverBean.getPOAC_NO_OF_UNIT(), "N",
							M_POAC_LC_MED_AMT,
							coverBean.getPOAC_PAPP_SYS_ID(),
							coverBean.getPOAC_PCG_SYS_ID());
					if (list != null && !list.isEmpty()) {
						if (list.get(0).getValue() != null) {
							M_POAC_RATE_APPLIED_ON = list.get(1).getValue();
						}if (list.get(1).getValue() != null) {
							M_POAC_FC_SA = Double.parseDouble(list.get(1).getValue());
						}if (list.get(2).getValue() != null) {
							M_POAC_LC_SA = Double.parseDouble(list.get(2).getValue());
						}
					}
					coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);
				}
							
				CommonUtils.closeCursor(resultSet);
							
							
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_LC_MED_AMT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean,
			DUMMY  dummyBean) throws Exception{

		String    M_COVER_CLASS = null;		
		String M_POAC_RATE_APPLIED_ON = null;
		Double M_POAC_FC_SA = null;  
		Double M_POAC_LC_SA = null;
		Double M_POAC_LC_MED_AMT = null;
		String CURSOR_C1 = "SELECT COVER_CLASS,COVER_RATE_APPLIED_ON FROM PM_IL_COVER WHERE  COVER_CODE= ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = null;
		P9ILPK_POLICY ILProcedure = new P9ILPK_POLICY();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		dummyBean.setUI_M_CHANGE_SA_YN("Y");
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, 
					new Object[]{coverBean.getPOAC_COVER_CODE()});
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
				M_POAC_RATE_APPLIED_ON = resultSet.getString(2);
				if ("M".equals(M_COVER_CLASS)) {
					list = ILProcedure.P_CALC_COVER_SA(
							coverBean.getPOAC_POL_SYS_ID(),
							coverBean.getPOAC_COVER_CODE(),
							coverBean.getPOAC_SYS_ID(),
							M_POAC_RATE_APPLIED_ON,
							M_POAC_FC_SA,
							M_POAC_LC_SA, 
							coverBean.getPOAC_MED_DAYS(),
							coverBean.getPOAC_LC_MED_AMT(),
							coverBean.getPOAC_NO_OF_UNIT(),
							dummyBean.getUI_M_CHANGE_SA_YN(),
							M_POAC_LC_MED_AMT,
							coverBean.getPOAC_PAPP_SYS_ID(),
							coverBean.getPOAC_PCG_SYS_ID());
					if (list != null && !list.isEmpty()) {
						if (list.get(0).getValue() != null) {
							M_POAC_RATE_APPLIED_ON = list.get(0).getValue();
						}if (list.get(1).getValue() != null) {
							M_POAC_FC_SA =Double.parseDouble(list.get(1).getValue());
						}if (list.get(2).getValue() != null) {
							M_POAC_LC_SA =Double.parseDouble(list.get(2).getValue());
						}if (list.get(3).getValue() != null) {
							M_POAC_LC_MED_AMT = Double.parseDouble(list.get(3).getValue()); 
						}
					}
							
					list1 = localProcedure.L_CHECK_MED_AMT(
							coverBean.getPOAC_SYS_ID(),
							policyBean.getPOL_SYS_ID(),
							policyBean.getPOL_PROD_CODE(),
							coverBean.getPOAC_COVER_CODE(),
							M_POAC_LC_MED_AMT,
							coverBean.getPOAC_LC_SA());
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							coverBean.setPOAC_LC_MED_AMT(Double.parseDouble(list1.get(0)));
						}
					}
							
					coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);
				}
			}
			CommonUtils.closeCursor(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_APPL_ALL_WHEN_VALIDATE_ITEM(PT_IL_POLICY policyBean,
			PT_IL_POL_ADDL_COVER_ACTION coverAction,PT_IL_POL_ASSURED_DTLS assuredBean) throws Exception{

		Double   M_NO_ASSR = null;
		String M_APPL_ALL = null;
		String M_UNQ_ADDL_COVER_YN = null;
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		PT_IL_POL_ADDL_COVER coverBean = coverAction.getPT_IL_POL_ADDL_COVER_BEAN();
		try {
			list = localProcedure.IL_UNIQUE_ADDL_COVER_CODE(
					M_UNQ_ADDL_COVER_YN, 
					M_APPL_ALL,"R",
					coverBean.getPOAC_POAD_SYS_ID(),
					policyBean.getPOL_SYS_ID(), 
					CommonUtils.getProcedureValue(coverBean.getPOAC_COVER_CODE()),
					coverBean.getROWID(),
					coverBean.getPOAC_PAPP_SYS_ID(),
					coverBean.getPOAC_PCG_SYS_ID());
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_UNQ_ADDL_COVER_YN = list.get(0);
				}
				if (list.get(1) != null) {
					M_APPL_ALL = list.get(1);
				}
			}
					
					

			M_NO_ASSR = localProcedure.IL_GET_ASSR_NOS(M_NO_ASSR,policyBean.getPOL_SYS_ID());

			list1 = localProcedure.IL_POAC_GET_TARIFF_RATE(coverBean.getPOAC_COVER_CODE(), 
					assuredBean.getPOAD_AGE(),
					policyBean.getPOL_END_TYPE(),
					policyBean.getPOL_START_DT(),
					coverBean.getPOAC_RATE(),
					coverBean.getPOAC_ASSR_CODE(),
					policyBean.getPOL_SYS_ID(),
					policyBean.getPOL_PERIOD(),
					policyBean.getPOL_PLAN_CODE());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					assuredBean.setPOAD_AGE(Integer.parseInt(list1.get(0)));
				}
				if (list1.get(1) != null) {
					coverBean.setPOAC_RATE(Double.parseDouble(list1.get(1)));
				}
			}
					
					
			if (M_NO_ASSR > 1) {
				if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71039"));
				}else if ("Y".equals(M_UNQ_ADDL_COVER_YN) && "Y".equals(coverBean.getPOAC_APPL_ALL())) {
					coverBean.setPOAC_ASSR_CODE(null);
					coverBean.setPOAC_RATE(coverBean.getPOAC_RATE() * 2);
					coverAction.getCOMP_POAC_ASSR_CODE().setDisabled(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POAC_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(
			PT_IL_POL_ADDL_COVER coverbean)throws Exception {
		if (coverbean.getPOAC_PREM_PAY_YRS() > coverbean.getPOAC_PERIOD()) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
					new Object[]{"Premium paying years less than or eqal to policy period"}));
		}
	}
	 

	    public void onPopulateDetail(PILQ003_COMPOSITE_ACTION compositeAction)
		    throws Exception {
		PT_IL_POL_APPL_PROD PT_IL_POL_APPL_PROD = compositeAction
			.getPT_IL_POL_APPL_PROD_ACTION_BEAN()
			.getPT_IL_POL_APPL_PROD_BEAN();
		try {
		    if ((PT_IL_POL_APPL_PROD.getPAPP_POL_SYS_ID() != null)
			    || (PT_IL_POL_APPL_PROD.getPAPP_POAD_SYS_ID() != null)
			    || (PT_IL_POL_APPL_PROD.getPAPP_SYS_ID() != null)) {
			PT_IL_POL_ADDL_COVER_DELEGATE delegate = new PT_IL_POL_ADDL_COVER_DELEGATE();
			delegate.executeSelectStatement(compositeAction);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }
}

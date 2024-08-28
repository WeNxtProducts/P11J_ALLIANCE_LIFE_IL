package com.iii.pel.forms.PILT002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM055_APAC.CompositeAction;
import com.iii.pel.forms.PILP002_APAC.COMPOSITE_ACTION_BEAN;
import com.iii.pel.forms.PILP200.PolicyBean;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ADDL_COVER_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
System.out.println("executeQuery called in coverpage");
		new PT_IL_POL_ADDL_COVER_DELEGATE().executeSelectStatement(
				compositeAction/*, compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID(),
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID()*/);

		List<PT_IL_POL_ADDL_COVER> dataList = compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER();
		System.out.println("dataList IN COVERPAGE       "+dataList);
		if (dataList != null && dataList.size() > 0) {
		    compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setPT_IL_POL_ADDL_COVER_BEAN( dataList.get(0));
			 dataList.get(0).setRowSelected(true);
		}else{
			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN=new PT_IL_POL_ADDL_COVER();
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setPT_IL_POL_ADDL_COVER_BEAN(PT_IL_POL_ADDL_COVER_BEAN);
		}
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().resetAllComponent();
	}

	public void preRecord(PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {

		Double M_NO_ASSR = null;
		String M_PLAN_TYPE = null;
		String M_COVER_CLASS = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		System.out.println("whenNewBlockInstance CALLED IN COVERPAGE");
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
			if("E".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL_POAD_TYPE"))){
				coverAction.getCOMP_POAC_WOP_FLAG().setDisabled(true);
			}else{
				coverAction.getCOMP_POAC_WOP_FLAG().setDisabled(false);
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		
/*Added by Janani on 30.04.2018 for duplicate cover issue from prem dtls screen*/
		
		String CURSOR_C2 = "SELECT POAD_ASSR_CODE FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
		ResultSet resultSet1 = null;
		String assr_code = null;
		
		/*End*/
		
		try {
			connection = CommonUtils.getConnection();
			
			/*Added by Janani on 30.04.2018 for duplicate cover issue from prem dtls screen*/
			resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] {policyBean.getPOL_SYS_ID()});
			if (resultSet1.next()) {
				assr_code = resultSet1.getString("POAD_ASSR_CODE");
			}
						
			/*End*/
			
			
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				coverBean.setPOAC_SYS_ID(resultSet.getLong(1));
			}
			coverBean.setPOAC_DEL_FLAG("N");
			coverBean.setPOAC_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			//coverBean.setPOAC_POAD_SYS_ID(AssuredBean.getPOAD_SYS_ID());
			coverBean.setPOAC_POAD_SYS_ID((Long)CommonUtils.getGlobalObject("POAD_SYS_ID"));

			/*Modified by Janani on 30.04.2018 for duplicate cover issue from prem dtls screen*/
			//coverBean.setPOAC_ASSR_CODE((String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_CODE"));
			coverBean.setPOAC_ASSR_CODE(assr_code);
			
			System.out.println("getPOAC_ASSR_CODE                   "+coverBean.getPOAC_ASSR_CODE());
			/*End*/
			
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
System.out.println("Enter into cover Helper      "+coverAction.compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ASSURED_NAME());
		String M_COVER_SA_CALC = null;
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		PKG_PILT002_APAC localProcedures = new PKG_PILT002_APAC();
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
			
			
			//coverBean.setUI_M_POAC_ASSR_NAME(assuredBean.getPOAD_ASSURED_NAME());
			coverBean.setUI_M_POAC_ASSR_NAME((String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_NAME"));
          if(coverBean.getPOAC_FC_PREM() != null){
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
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();

		try {
			coverBean.setPOAC_DEL_FLAG("Y");
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
								new Object[]{"Cool of Period for",M_POAC_COVER_CODE," is ",M_PAC_COOL_OF_PD }));
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
						new Object[]{M_POL_SYS_ID, M_POAC_MASTER_SYS_ID});
				if (resultSet.next()) {
					//M_POAC_MASTER_SYS_ID = resultSet.getLong(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "92006"));
				}else {
					/*commented by Sivarajan on 11-04-2019 For siva sir sugg.*/
					/*handler.executeDeleteStatement(DELETE_QUERY, connection,
							new Object[]{coverBean.getPOAC_SYS_ID(),M_POL_SYS_ID});*/
					/*Added by Sivarajan 11-04-2019 for KIC siva sir sugg. policy level to delete*/
					ArrayList<String> list = pilt002Procedures.P_DEL_MAST_DETL(
							coverBean.getPOAC_COVER_CODE(),
							policyBean.getPOL_PROD_CODE(),
							CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), "1");
					/*End*/
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
			if (!("1".equals(policyBean.getPOL_DS_TYPE()))) {
				resultSet = handler.executeSelectStatement(CURSOR_C6, connection, 
						new Object[]{M_POL_SYS_ID,coverBean.getPOAC_SYS_ID(),coverBean.getPOAC_COVER_CODE()});
				if (resultSet.next()) {
					M_POAC_MASTER_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
			}
			/*commented by Sivarajan for KIC on 11-04-2019*//*else {
				ArrayList<String> list = pilt002Procedures.P_DEL_MAST_DETL(
						coverBean.getPOAC_COVER_CODE(),
						policyBean.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(coverBean.getPOAC_POAD_SYS_ID()), 
						CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), "1");
			}*//*End*/
			if (!("000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")))){
				if ("Y".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N")) 
						&& policyBean.getPOL_END_TYPE() != null) {
					/*
					 * commented by Dhinesh on  05-28-2018 for deletion Rider Endorsment Issue
					 * 
					 * coverBean.setPOAC_RATE(0.00);
					coverBean.setPOAC_RATE_PER(0.00);
					coverBean.setPOAC_FC_PREM(0.00);
					coverBean.setPOAC_LC_PREM(0.00);*/
			/*	}

				if ("Y".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))) {
				*/	
					if(coverBean.getPOAC_FC_PREM()!=0)
					{
						coverBean.setPOAC_RATE(0.00);
						coverBean.setPOAC_RATE_PER(0.00);
						coverBean.setPOAC_FC_PREM(0.00);
						coverBean.setPOAC_LC_PREM(0.00);
						coverBean.setPOAC_FC_SA(0.00);
						coverBean.setPOAC_LC_SA(0.00);
					}else
					{
						coverBean.setPOAC_RATE(coverBean.getPOAC_ORG_RATE());
						coverBean.setPOAC_RATE_PER(coverBean.getPOAC_ORG_RATE_PER());
						coverBean.setPOAC_FC_PREM(coverBean.getPOAC_ORG_FC_PREM());
						coverBean.setPOAC_LC_PREM(coverBean.getPOAC_ORG_LC_PREM());
						coverBean.setPOAC_FC_SA(coverBean.getPOAC_ORG_FC_SA());
						coverBean.setPOAC_LC_SA(coverBean.getPOAC_ORG_LC_SA());
						coverBean.setPOAC_DEL_FLAG("N");
					}
					
					/*
					 * 
					 * commented by Dhinesh on  05-28-2018 for deletion Rider Endorsment Issue
					 * 
					 * 
					 * coverBean.setPOAC_FC_SA(coverBean.getPOAC_ORG_FC_SA() * -1);
					coverBean.setPOAC_LC_SA(coverBean.getPOAC_ORG_LC_SA() * -1);
					coverBean.setPOAC_FC_PREM(coverBean.getPOAC_ORG_FC_PREM() * -1);
					coverBean.setPOAC_LC_PREM(coverBean.getPOAC_ORG_LC_PREM() * -1);*/
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
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
							"2");
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
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS asssuredBean,PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		
/*Added by Janani on 30.04.2018 for duplicate cover issue from prem dtls screen*/
		
		String CURSOR_C2 = "SELECT POAD_ASSR_CODE FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
		ResultSet resultSet1 = null;
		String assr_code = null;
		Connection connection = null;
		
		/*End*/
		
		
		
		try{
		
			/*Added by Janani on 30.04.2018 for duplicate cover issue from prem dtls screen*/
			
			connection = CommonUtils.getConnection();
			
			resultSet1 = new CRUDHandler().executeSelectStatement(CURSOR_C2, connection,new Object[] {policyBean.getPOL_SYS_ID()});
			if (resultSet1.next()) {
				assr_code = resultSet1.getString("POAD_ASSR_CODE");
			}
						
			/*End*/
		
		/*
		* Commented by Sankara Narayanan for changing cover start date as policy start date  ref :Kulandhai vel
		* on 23/10/2016
		*
		coverBean.setPOAC_FM_DT(CommonUtils.nvl(policyBean
					.getPOL_END_EFF_FROM_DT(), policyBean.getPOL_ISSUE_DT()));*/
			
		coverBean.setPOAC_FM_DT(CommonUtils.nvl(policyBean
				.getPOL_END_EFF_FROM_DT(), policyBean.getPOL_START_DT()));
		/*added by raja on 03-08-2017 for ZBILQC-1733034  & ZBILQC-1730978*/
		coverBean.setPOAC_TO_DT(policyBean.getPOL_EXPIRY_DT());
		/*end*/
		
		/*
		 * commented By Dhinesh on 4-7-2017 for ssp call id : ZBILQC-1723357
		 * 
		 * 
		coverBean.setPOAC_TO_DT(CommonUtils.nvl(policyBean.getPOL_END_EFF_TO_DT(),
				policyBean.getPOL_EXPIRY_DT()));
		
		*	End	
		*/
		coverBean.setPOAC_RATE_PER(1.00);
		coverBean.setPOAC_WOP_FLAG("N");
		/*coverBean.setPOAC_ASSR_CODE(asssuredBean.getPOAD_ASSR_CODE());
		
		coverBean.setUI_M_POAC_ASSR_NAME(asssuredBean.getPOAD_ASSURED_NAME());*/
	//coverBean.setPOAC_ASSR_CODE((String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_CODE"));
		
		
		coverBean.setPOAC_ASSR_CODE(assr_code);
		
		
		coverBean.setUI_M_POAC_ASSR_NAME((String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_NAME"));
		coverBean.setUI_M_PROD_CODE( policyBean.getPOL_PROD_CODE());
		coverBean.setUI_M_PCG_CODE(pt_il_pol_cover_group.getPCG_CODE() );
		System.out.println("coverBean.setUI_M_POAC_ASSR_NAME(   "+coverBean.getUI_M_POAC_ASSR_NAME());
		System.out.println("coverBean.setPOAC_ASSR_CODE(   "+coverBean.getPOAC_ASSR_CODE());
		//newly added to disable WOP if joint life is NO
		
    //added by raja for EMR Rate in Cover detail on 26-10-2016
		coverBean.setPOAC_EMR_RATE(policyBean.getPOL_EMR_RATE());
		/*
		 * commented By Dhinesh on 4-7-2017 for ssp call id : ZBILQC-1723357
		 * 
		 * coverBean.setPOAC_PREM_PAY_YRS(policyBean.getPOL_PREM_PAY_YRS());
		 * 
		 * End
		 * */
		
		/*
		 * commented by Ameen on 10-05-2017 as per Thiag sir sugg. to display 0. while no prem. calculated
		 * coverBean.setPOAC_FC_PREM(policyBean.getPOL_FC_MODAL_PREM());
		coverBean.setPOAC_LC_PREM(policyBean.getPOL_LC_MODAL_PREM());*/
		/*added by Ameen on 10-05-2017 as per Thiag sir sugg. to display 0. while no prem. calculated*/
		coverBean.setPOAC_FC_PREM(0.0);
		coverBean.setPOAC_LC_PREM(0.0);
		/*end*/
		coverBean.setPOAC_NO_OF_UNIT(policyBean.getPOL_NO_OF_UNIT());
		//end
		
		if(policyBean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("N")){
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_WOP_FLAG().setDisabled(true);
		}
		
		/*Added by Ram on 09/11/2016 for FALCONLIFE-1351612*/
		if(coverBean.getPOAC_FM_DT() != null  && coverBean.getPOAC_TO_DT() != null)
		{
		int timeDifference = getTimeDiff(coverBean.getPOAC_FM_DT(), coverBean.getPOAC_TO_DT());
		System.out.println("timeDifference "+timeDifference);
		/*
		 * commented By Dhinesh on 4-7-2017 for ssp call id : ZBILQC-1723357
		 * 
		 * coverBean.setPOAC_PERIOD(timeDifference);
		 * 
		 * End
		 * */
		}
		/*End*/
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*Added by Ram on 09/11/2016 for FALCONLIFE-1351612*/
	public int getTimeDiff(Date dateOne, Date dateTwo) {
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(dateOne);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(dateTwo);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		return diffYear;
	}
	/*End*/
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
			
			//newly added to disable WOP if joint life is NO
			if(policyBean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("N")){
				coverAction.getCOMP_POAC_WOP_FLAG().setDisabled(true);
			}
			
			//Commented for normal policy by Kavitha 19 Nov 2012
		/*	pt_il_pol_addl_cover.setUI_M_PROD_CODE(pt_il_pol_appl_prod.getPAPP_PROD_CODE());
			pt_il_pol_addl_cover.setUI_M_PCG_CODE(pt_il_pol_cover_group.getPCG_CODE());
			   */
			pt_il_pol_addl_cover.setUI_M_PROD_CODE(policyBean.getPOL_PROD_CODE());
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

	public void POAC_COVER_CODE_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ADDL_COVER_ACTION coverAction) throws Exception {

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
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		
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
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		Connection connection = null;
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ArrayList<String> list3 = null;
		ArrayList<String> list4 = null;
		
		DBProcedures procedures = new DBProcedures();
		
		PT_IL_POL_ADDL_COVER coverBean = coverAction.getPT_IL_POL_ADDL_COVER_BEAN();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
			Double M_POAC_RATE = null;
			
			       
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
	
			String  CURSOR_C4  =" SELECT LEAST(?,?) FROM  DUAL";
		      
			String CURSOR_C5  = " SELECT LEAST(?,?)  FROM   DUAL";      
			
			/* commented By Dhinesh on 4-7-2017 for ssp call id : ZBILQC-1723357 */
			String CURSOR_C11  = " SELECT PAC_MAT_PAYER_AGE,pac_max_age_on_mat from PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND  PAC_COVER_CODE = ? ";
			int PAC_MAT_PAYER_AGE=0;
			int pac_max_age_on_mat=0;
			
			
			/* End */
			
			/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
				
			String COVER_VALIDATE_YN = null,M_COVER_SA_CALC = null;
			String CURSOR_C13 = "SELECT COVER_VALIDATE_YN,COVER_SA_CALC FROM  PM_IL_COVER WHERE COVER_CODE = ?";
			
			String CURSOR_C12 = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER WHERE COVER_CODE = POAC_COVER_CODE AND COVER_VALIDATE_YN='Y'"
					+ " AND POAC_POL_SYS_ID = ? ";
			
			ResultSet resultSet6 = null,resultSet7 = null;
			/*End*/
			
		if (coverBean.getPOAC_COVER_CODE() != null) {
			
			/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
			
			resultSet7 = handler.executeSelectStatement(CURSOR_C13, connection,
					new Object[]{coverBean.getPOAC_COVER_CODE()});
			
			if(resultSet7.next())
			{
				COVER_VALIDATE_YN = resultSet7.getString("COVER_VALIDATE_YN");
				M_COVER_SA_CALC = resultSet7.getString("COVER_SA_CALC");
				System.out.println("COVER_VALIDATE_YN     "+COVER_VALIDATE_YN+"     M_COVER_SA_CALC       "+M_COVER_SA_CALC);
				/*Changed condition because of Null pointer exception by Sivarajan on 08/07/2019 for Sarwa GL*/
				if("Y".equalsIgnoreCase(COVER_VALIDATE_YN))
				{
					resultSet6 = handler.executeSelectStatement(CURSOR_C12, connection,
							new Object[]{policyBean.getPOL_SYS_ID()});
					
					if(resultSet6.next())
					{
						throw new Exception("Only one Money tree cover is applicable");
					}
				}
				/*End*/
			}
			
			
			
			/*End*/
			
			if ("Y".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
				resultSet = handler.executeSelectStatement(CURSOR_C10, connection,
						new Object[]{policyBean.getPOL_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91942"));
				}
			}
			CommonUtils.closeCursor(resultSet);
			
			/* commented By Dhinesh on 4-7-2017 for ssp call id : ZBILQC-1723357 */

			resultSet = handler.executeSelectStatement(CURSOR_C11, connection,
					new Object[]{policyBean.getPOL_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
			if (resultSet.next()) {
				pac_max_age_on_mat = resultSet.getInt("pac_max_age_on_mat");
				PAC_MAT_PAYER_AGE = resultSet.getInt("PAC_MAT_PAYER_AGE");
				
			}
			if( assuredBean.getPOAD_AGE() > CommonUtils.nvl(pac_max_age_on_mat,0) || assuredBean.getPOAD_AGE() > CommonUtils.nvl(PAC_MAT_PAYER_AGE,0) )
			{
				/*
				 * modified by Ameen on 13-07-2017 for ZBILQC-1731654 as per vinoth sugg.
				 * throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91942"));*/
				throw new Exception("The Assured Age " + assuredBean.getPOAD_AGE() + " should be less than or equal to " + PAC_MAT_PAYER_AGE + " for this cover " +coverBean.getPOAC_COVER_CODE());
			}
			CommonUtils.closeCursor(resultSet);

			/* End */


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
											coverBean.getUI_M_PROD_CODE(),
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
				
				list2 = localProcedure.IL_POAC_GET_TARIFF_RATE(coverBean.getPOAC_COVER_CODE(),
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
																if(list2.size() > 1 && list2.get(1)!= null){
																	M_POAC_RATE = Double.parseDouble(list2.get(1));
																	coverBean.setPOAC_RATE(M_POAC_RATE);
																}
															}
															if ("N".equals(M_UNQ_ADDL_COVER_YN)) {
																throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71039"));
															}
															
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[]{policyBean.getPOL_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
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
				list = new P9ILPK_POLICY_NR().P_CALC_COVER_SA(
						policyBean.getPOL_SYS_ID(),
						coverBean.getPOAC_COVER_CODE(),
						coverBean.getPOAC_SYS_ID(),
						M_POAC_RATE_APPLIED_ON, 
						M_POAC_FC_SA, 
						M_POAC_LC_SA, 
						coverBean.getPOAC_MED_DAYS(),
						coverBean.getPOAC_LC_MED_AMT(), 
						coverBean.getPOAC_NO_OF_UNIT(),
						"N",
						null);
				/*list = new P9ILPK_POLICY().P_CALC_COVER_SA(
						policyBean.getPOL_SYS_ID(),
						coverBean.getPOAC_COVER_CODE(),
						//coverBean.getPOAC_SYS_ID(),
						M_POAC_RATE_APPLIED_ON, M_POAC_FC_SA, M_POAC_LC_SA, 
						coverBean.getPOAC_MED_DAYS(),
						coverBean.getPOAC_LC_MED_AMT(), 
						//"N", null, 
						coverBean.getPOAC_PAPP_SYS_ID(),
						coverBean.getPOAC_NO_OF_UNIT(),
						coverBean.getPOAC_PCG_SYS_ID());*/
				if (list != null && !list.isEmpty()) {
					if (list.get(0).getValueObject() != null) {
						M_POAC_RATE_APPLIED_ON =(String)list.get(0).getValueObject();
					}if (list.get(1).getValueObject() != null) {
						M_POAC_FC_SA  =(Double)list.get(1).getValueObject();
						coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
						
						System.out.println("getPOAC_FC_SA               "+coverBean.getPOAC_FC_SA());
					}if (list.get(2).getValueObject() != null) {
						M_POAC_LC_SA =(Double)list.get(2).getValueObject();
						coverBean.setPOAC_LC_SA(M_POAC_LC_SA);
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
		   /* coverBean.setPOAC_FC_SA(CommonUtils.nvl(M_POAC_FC_SA,0.00));
		    coverBean.setPOAC_LC_SA(CommonUtils.nvl(M_POAC_LC_SA,0.00));*/
		    if(!("012".equals(policyBean.getPOL_END_TYPE()))){
		    coverBean.setPOAC_PERIOD(CommonUtils.nvl(M_PAC_PERIOD,0));
		    }
		    coverBean.setPOAC_TARIFF_TERM_FLAG(CommonUtils.nvl(M_PAC_TARIFF_TERM_FLAG,"P"));
		   // coverBean.setPOAC_PREM_PAY_YRS(CommonUtils.nvl(M_PAC_PREM_PAY_YRS,0));
		    
		    coverAction.getCOMP_POAC_TARIFF_TERM_FLAG().setDisabled(true);
		    if ("M".equals(M_COVER_CLASS)) {
		    	
		    	/*Commentted &Modified by saritha on 10-10-2017 for ssp call id ZBLIFE-1439993*/
				/*coverAction.getCOMP_POAC_MED_DAYS().setDisabled(false);
				coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(false);*/
		    	coverAction.getCOMP_POAC_MED_DAYS().setRendered(true);
		    	coverAction.getCOMP_POAC_LC_MED_AMT().setRendered(true);
		    	coverAction.getCOMP_POAC_MED_DAYS_LABEL().setRendered(true);
		    	coverAction.getCOMP_POAC_LC_MED_AMT_LABEL().setRendered(true);
				coverBean.setPOAC_MED_DAYS(M_PAC_MED_DAYS);
				coverBean.setPOAC_LC_MED_AMT(M_PAC_MED_AMT);
				
			}else {
				/*coverAction.getCOMP_POAC_MED_DAYS().setDisabled(true);
				coverAction.getCOMP_POAC_LC_MED_AMT().setDisabled(true);*/
				coverAction.getCOMP_POAC_MED_DAYS().setRendered(false);
				coverAction.getCOMP_POAC_LC_MED_AMT().setRendered(false);
				coverAction.getCOMP_POAC_MED_DAYS_LABEL().setRendered(false);
				coverAction.getCOMP_POAC_LC_MED_AMT_LABEL().setRendered(false);
				/*End*/
				
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
		/*		
		M_MIN_PAC_PREM_PAY_YRS = Math.min(policyBean.getPOL_PREM_PAY_YRS(),coverBean.getPOAC_PREM_PAY_YRS());
		coverBean.setPOAC_PREM_PAY_YRS(M_MIN_PAC_PREM_PAY_YRS);
		M_MIN_PAC_PERIOD = Math.min(policyBean.getPOL_PERIOD(),coverBean.getPOAC_PERIOD());
		coverBean.setPOAC_PERIOD(M_MIN_PAC_PERIOD);
		*/
		resultSet4 = handler.executeSelectStatement(CURSOR_C4, connection,
					new Object[]{policyBean.getPOL_PREM_PAY_YRS(),coverBean.getPOAC_PREM_PAY_YRS()});
		if (resultSet4.next()) {
			M_MIN_PAC_PREM_PAY_YRS = resultSet4.getInt(1);
			//coverBean.setPOAC_PREM_PAY_YRS(resultSet4.getInt(1));
		} 
		resultSet4 = handler.executeSelectStatement(CURSOR_C5, connection,
				new Object[]{policyBean.getPOL_PREM_PAY_YRS(),coverBean.getPOAC_PREM_PAY_YRS()});
		if (resultSet4.next()) {
			M_MIN_PAC_PERIOD = resultSet4.getInt(1);
			if(!("012".equals(policyBean.getPOL_END_TYPE()))){
			coverBean.setPOAC_PERIOD(resultSet4.getInt(1));
			}
		} 
	 
		
		
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
			/*Modified by ganesh on 03-07-2017, as suggested by ajoy*/
			/*Added by ganesh on 20-06-2017, suggested by ajoy */
			System.out.println("SA LC-->"+policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
		
			/*if("ADDRIDER".equalsIgnoreCase(policyBean.getPOL_END_CODE())){
				
				coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
				coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
			}else{
				coverBean.setPOAC_LC_SA(M_COVER_LC_LIMIT);
				coverBean.setPOAC_FC_SA(M_COVER_LC_LIMIT);
			}*/
			/*end*/
			
			
			if(fetchEndLogic().equalsIgnoreCase("2")){		
				
				if(!M_COVER_SA_CALC.equalsIgnoreCase("s"))
				{
				
				/*Added by Janani on 03.01.2018 for ZBLIFE-1467492*/
				
				if(!"W".equals(M_COVER_CLASS))
				{				
					/*End of ZBLIFE-1467492*/
					if(policyBean.getPOL_SA_CURR_CODE().equals(policyBean.getPOL_CUST_CURR_CODE())){/*curr. condition added by Ameen on 25-03-2018 for as per Siva sugg.*/
						coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED());
						coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED());
					}else{
						coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED());
						coverBean.setPOAC_FC_SA(policyBean.getPOL_FC_SUM_ASSURED());
					}
				
				}
				}
			}else{
				if(policyBean.getPOL_SA_CURR_CODE().equals(policyBean.getPOL_CUST_CURR_CODE())){/*curr. condition added by Ameen on 25-03-2018 for as per Siva sugg.*/
					coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
					coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
				}else{
					coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
					coverBean.setPOAC_FC_SA(policyBean.getPOL_FC_SUM_ASSURED()+policyBean.getPOL_ORG_FC_SUM_ASSURED());
				}
			}
				
			if(coverBean.getPOAC_LC_SA() <= 0 || coverBean.getPOAC_FC_SA() <= 0 ){
			
				coverBean.setPOAC_LC_SA(M_COVER_LC_LIMIT);
				coverBean.setPOAC_FC_SA(M_COVER_LC_LIMIT);
			}
			
			
			
			
			/*end*/
			
		}else {
			coverAction.getCOMP_POAC_LIMIT_TYPE().setDisabled(true);
			coverAction.getCOMP_POAC_PER_DAY_LC_AMT().setDisabled(true);
			coverAction.getCOMP_POAC_LIMIT_DAYS().setDisabled(true);
			coverAction.getCOMP_POAC_LC_LIMIT().setDisabled(true);
			coverAction.getCOMP_UI_M_BTN_BENEFIT_DTLS().setDisabled(true);
			/*Modified by ganesh on 03-07-2017, as suggested by ajoy*/
			/*Added by ganesh on 20-06-2017, suggested by ajoy 
			if("ADDRIDER".equalsIgnoreCase(policyBean.getPOL_END_CODE())){
				coverAction.getCOMP_POAC_FC_SA().setDisabled(true);
				
				coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
				coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
			}else{
				coverBean.setPOAC_LC_SA(M_COVER_LC_LIMIT);
				coverBean.setPOAC_FC_SA(M_COVER_LC_LIMIT);
			}
			
			System.out.println("ELSE FC VALUE-->"+coverBean.getPOAC_FC_SA());
			end*/
			
			if(fetchEndLogic().equalsIgnoreCase("2")){	
				
				if(!M_COVER_SA_CALC.equalsIgnoreCase("s"))
				{
				
				/*Added by Janani on 03.01.2018 for ZBLIFE-1467492*/

				if(!"W".equals(M_COVER_CLASS))
				{
				/*End of ZBLIFE-1467492*/
					/*Commented by pidugu raj dt: 10-12-2020 as suggested by Sitrarasan for Alliance IL
					 * if(policyBean.getPOL_SA_CURR_CODE().equals(policyBean.getPOL_CUST_CURR_CODE())){curr. condition added by Ameen on 25-03-2018 for as per Siva sugg.
						coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED());
						coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED());
					}else{*/
						coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED());
						coverBean.setPOAC_FC_SA(policyBean.getPOL_FC_SUM_ASSURED());
					/*}*/
				
				}
				}
			}else{
				if(policyBean.getPOL_SA_CURR_CODE().equals(policyBean.getPOL_CUST_CURR_CODE())){/*curr. condition added by Ameen on 25-03-2018 for as per Siva sugg.*/
					coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
					coverBean.setPOAC_FC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
				}else{
					coverBean.setPOAC_LC_SA(policyBean.getPOL_LC_SUM_ASSURED()+policyBean.getPOL_ORG_LC_SUM_ASSURED());
					coverBean.setPOAC_FC_SA(policyBean.getPOL_FC_SUM_ASSURED()+policyBean.getPOL_ORG_FC_SUM_ASSURED());
				}
			}
			/*end*/
		}
			
		/* Newly Added By Dhinesh on 29-06-2017 */
		resultSet = handler.executeSelectStatement(CURSOR_C11, connection,
				new Object[]{policyBean.getPOL_PROD_CODE(),coverBean.getPOAC_COVER_CODE()});
		if (resultSet.next()) {
			
			pac_max_age_on_mat = resultSet.getInt("pac_max_age_on_mat");
			
		}
		
		M_PERIOD = Double.valueOf(CommonUtils.nvl(pac_max_age_on_mat,0) - CommonUtils.nvl(assuredBean.getPOAD_AGE(),0)); 
		M_PERIOD = Math.min(M_PERIOD, policyBean.getPOL_PERIOD());
		
		coverBean.setPOAC_FM_DT(CommonUtils.nvl(policyBean
				.getPOL_END_EFF_FROM_DT(), policyBean.getPOL_START_DT()));
		coverBean.setPOAC_PERIOD(M_PERIOD.intValue());
		/*commented by raja on 03-08-2017 for ZBILQC-1733034  & ZBILQC-1730978*/
		
		/*uncommented by Janani on 05.04.2018 for kic RIder issue*/ 
		
		/*
		 * modified by Ameen on 08-04-2018 for unable to add rider covers in KIC onsite
		 * coverBean.setPOAC_TO_DT(CommonUtils
				.addMonthsToDate(coverBean.getPOAC_FM_DT(), coverBean.getPOAC_PERIOD().intValue() * 12));*/
		
		if ("O".equals(dummy_bean.getUI_M_PROD_MATU_DT())) {
			if ("012".equalsIgnoreCase(CommonUtils.nvl(policyBean
					.getPOL_END_TYPE(), "000"))) {
				coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(CommonUtils
						.addMonthsToDate(coverBean.getPOAC_FM_DT(), (coverBean.getPOAC_PERIOD().intValue() + coverBean.getPOAC_ORG_PERIOD()) * 12),-1));
			} else {
				coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(CommonUtils
						.addMonthsToDate(coverBean.getPOAC_FM_DT(), coverBean.getPOAC_PERIOD().intValue() * 12),-1));
			}
		} else {
			if ("012".equalsIgnoreCase(CommonUtils.nvl(policyBean
					.getPOL_END_TYPE(), "000"))) {
				coverBean.setPOAC_TO_DT(CommonUtils
						.addMonthsToDate(coverBean.getPOAC_FM_DT(), (coverBean.getPOAC_PERIOD().intValue() + coverBean.getPOAC_ORG_PERIOD()) * 12));
			} else {
				coverBean.setPOAC_TO_DT(CommonUtils
						.addMonthsToDate(coverBean.getPOAC_FM_DT(), coverBean.getPOAC_PERIOD().intValue() * 12));
			}
		}
		
		/*End*/
		
		/*end*/
		coverBean.setPOAC_PREM_PAY_YRS(coverBean.getPOAC_PERIOD().intValue());
			
		/* End */
		
		
		/*Added by saritha on 29-Jan-2018 for ssp call id ZBLIFE-1444238 as per siva sir sugg.
		 * The MoreCover Funeral Plan is also available as a rider but functionality is not available. */
		
		setDefaultSumAssured207Rider(compositeAction);	
		
		/*End ZBLIFE-1444238*/
			
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
						CommonUtils.getProcedureValue(coverBean.getPOAC_PAPP_SYS_ID()), 
						CommonUtils.getProcedureValue(coverBean.getPOAC_NO_OF_UNIT()),
						CommonUtils.getProcedureValue(coverBean.getPOAC_PCG_SYS_ID()));
					if (list != null && !list.isEmpty() ) {
						if (list.get(0) != null ) {
							M_POAC_RATE_APPLIED_ON = list.get(0);
						}if (list.get(0) != null ) {
							M_POAC_FC_SA = Double.parseDouble(list.get(1));
						}if (list.get(0) != null ) {
							M_POAC_LC_SA = Double.parseDouble(list.get(2));
						}
					}
					/*coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);*/
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
	
			/*Added by Janani on 28.04.2018 for base product as suggested by Vinoth*/
			
			int pol_period = 0;
			
	try {
			/*End*/
	
		//added by gopi for toi 15/06/18
		Date policy_start_date =policyBean.getPOL_START_DT();
		DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
		String poldate = dateformate.format(policy_start_date);
		Date policy_start_dt = dateformate.parse(poldate);
	
		/*
		 * modified by gopi for toi 15/06/18
		if (coverBean.getPOAC_FM_DT().before(policyBean.getPOL_START_DT())
				|| coverBean.getPOAC_FM_DT().after(
						policyBean.getPOL_EXPIRY_DT())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
					new Object[] {"Cover Date between", policyBean.getPOL_START_DT(),
						policyBean.getPOL_EXPIRY_DT()}));
		}*/
		

		if (coverBean.getPOAC_FM_DT().before(policy_start_dt)
				|| coverBean.getPOAC_FM_DT().after(
						policyBean.getPOL_EXPIRY_DT())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
					new Object[] {"Cover Date between", policy_start_dt,
						policyBean.getPOL_EXPIRY_DT()}));
		}
		//end
		if (coverBean.getPOAC_TO_DT() != null
				&& coverBean.getPOAC_FM_DT().after(coverBean.getPOAC_TO_DT())) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", 
					new Object[] {"Cover From date less tha or equal to",coverBean.getPOAC_TO_DT() }));
		}

		if (coverBean.getPOAC_PERIOD()!=null && coverBean.getPOAC_PERIOD()!=0) {
			if (CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
					coverBean.getPOAC_PERIOD().intValue() * 12).after(
							policyBean.getPOL_EXPIRY_DT())) {
				coverBean.setPOAC_TO_DT(policyBean.getPOL_EXPIRY_DT());
			} else {
				if ("O".equals(dummyBean.getUI_M_PROD_MATU_DT())) {
					if("012".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000"))){
					coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
							CommonUtils.addMonthsToDate(coverBean
									.getPOAC_FM_DT(), (coverBean
									.getPOAC_PERIOD().intValue()+ coverBean.getPOAC_ORG_PERIOD()) * 12), -1));
					}else{
						coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
								CommonUtils.addMonthsToDate(coverBean
										.getPOAC_FM_DT(), coverBean
										.getPOAC_PERIOD().intValue() * 12), -1));
					}
				} else {
					if("012".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000"))){
					coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
							coverBean.getPOAC_FM_DT(), (coverBean
							.getPOAC_PERIOD().intValue()+ coverBean.getPOAC_ORG_PERIOD())* 12));
					}else{
						coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
								coverBean.getPOAC_FM_DT(), coverBean
								.getPOAC_PERIOD().intValue() * 12));
					}
				}
			}
		} else {
			coverBean.setPOAC_TO_DT(coverBean.getPOAC_FM_DT());
		}
		
		
		/*Added by Janani on 28.04.2018 for base product as suggested by Vinoth*/
		pol_period = get_polPeriod(policyBean.getPOL_SYS_ID());
		
		if(coverBean.getPOAC_PERIOD() > pol_period)
		{
			coverBean.setPOAC_PERIOD(pol_period);
		}
		else
		{
		/*End*/
		
		/*Added by Ram on 09/11/2016 for FALCONLIFE-1351612*/
		if(coverBean.getPOAC_FM_DT() != null  && coverBean.getPOAC_TO_DT() != null)
		{
		int timeDifference = getTimeDiff(coverBean.getPOAC_FM_DT(), coverBean.getPOAC_TO_DT());
		System.out.println("timeDifference in Date"+timeDifference);
		coverBean.setPOAC_PERIOD(timeDifference);
		coverBean.setPOAC_PREM_PAY_YRS(timeDifference);
		}
		/*End*/
		}
	} catch (Exception e) {
		e.printStackTrace();
	throw new Exception(e.getMessage());
	} finally {
		try {
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
	

	public void POAC_TO_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String Query = "SELECT ROUND(CEIL(MONTHS_BETWEEN( ? , ? ))/12) FROM DUAL";
		
		/*Added by Janani on 28.04.2018 for base product as suggested by Vinoth*/
		
		int pol_period = 0;
		
		/*End*/
		
		try {
			connection = CommonUtils.getConnection();
			//added by gopi for toi 15/06/18
			Date policy_to_date =policyBean.getPOL_EXPIRY_DT();
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String poltodate = dateformate.format(policy_to_date);
			Date policy_to_dt = dateformate.parse(poltodate);
			/*if (coverBean.getPOAC_TO_DT().after(policyBean.getPOL_EXPIRY_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"91014",new Object[] { "Cover to Date less than or equal to Expiry date" }));
			}*/
			if (coverBean.getPOAC_TO_DT().after(policy_to_dt)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"91014",new Object[] { "Cover to Date less than or equal to Expiry date" }));
			}
			if (coverBean.getPOAC_FM_DT().after(policy_to_dt)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Cover To Date greater than",
								coverBean.getPOAC_FM_DT() }));
			}

			//POAC_FM_DT_WHEN_VALIDATE_ITEM(coverBean, policyBean, dummyBean);
			/*Added by Janani on 28.04.2018 for base product as suggested by Vinoth*/
			pol_period = get_polPeriod(policyBean.getPOL_SYS_ID());
			
			if(coverBean.getPOAC_PERIOD() > pol_period)
			{
				coverBean.setPOAC_PERIOD(pol_period);
			}
			else
			{
			/*End*/
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { coverBean.getPOAC_TO_DT(),
					coverBean.getPOAC_FM_DT() });
			if (resultSet.next()) {
				if(!("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE()))){
				coverBean.setPOAC_PERIOD(resultSet.getInt(1));
				coverBean.setPOAC_PREM_PAY_YRS(resultSet.getInt(1));
				
				}
			}
			
			}
			
			
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POAC_PERIOD_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_ACTION coverAction,PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS assuredBean,
			PT_IL_POL_ASSURED_DTLS_1 assured1Bean, DUMMY dummyBean,String endType)
	throws Exception {
		/*Added by Ameen on 22-05-2018 for KIC INTERM/DECTERM endorsements as per Chandramohan sugg.*/
		String TERM_END_PARAM = "";
		String TERM_END_PARAM_QRY = "SELECT NVL(PARA_VALUE, 0) END_LOGIC FROM PCOM_APP_PARAMETER WHERE PARA_CODE = 'IL_END_LOGIC' AND PARA_SUB_CODE = 'IL_END_LOGIC'";
		ResultSet TERM_END_PARAM_RS = new CRUDHandler().executeSelectStatement(TERM_END_PARAM_QRY, CommonUtils.getConnection());
		int cvrVal = 0;
		int polVal = 0;
		
		if(TERM_END_PARAM_RS.next()){
			TERM_END_PARAM = TERM_END_PARAM_RS.getString("END_LOGIC");
		}
		
		if("1".equals(TERM_END_PARAM)){
			cvrVal = coverBean.getPOAC_PERIOD() + coverBean.getPOAC_ORG_PERIOD();
			polVal = policyBean.getPOL_ORG_PERIOD() + policyBean.getPOL_PERIOD();
		}else if("2".equals(TERM_END_PARAM)){
			cvrVal = coverBean.getPOAC_PERIOD();
			polVal = policyBean.getPOL_PERIOD();
		}
		/*end*/
		
		if(!("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE())) && 
				coverBean.getPOAC_PERIOD() > policyBean.getPOL_PERIOD()) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91080"));
		}
		/*
		 * modified by Ameen on 22-05-2018 for KIC INTERM/DECTERM endorsements as per Chandramohan sugg.
		 * else if(("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE())) && ((coverBean.getPOAC_PERIOD()+coverBean.getPOAC_ORG_PERIOD()) 
				> (policyBean.getPOL_ORG_PERIOD() + policyBean.getPOL_PERIOD()))){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91080"));
		}*/
		else if(("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE())) && (cvrVal  > polVal)){
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
					if(!("012".equals(policyBean.getPOL_END_TYPE()))){
					coverBean.setPOAC_PERIOD(resultSet.getInt(1));
					}
				}
					
				CommonUtils.closeCursor(resultSet);
			} else {
				if ("O".equals(dummyBean.getUI_M_PROD_MATU_DT())) {
					if(!("012".equals(policyBean.getPOL_END_TYPE()))){
					coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
							CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
									coverBean.getPOAC_PERIOD().intValue() * 12), -1));
					}
					else{
						/*
						 * modified by Ameen on 23-05-2018 for KIC INTERM/DECTERM endorsements as per Chandramohan sugg.
						 * coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
								CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
										(coverBean.getPOAC_ORG_PERIOD()+coverBean.getPOAC_PERIOD()) * 12), -1));*/
						
						if("1".equals(TERM_END_PARAM)){
							coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
									CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
											(coverBean.getPOAC_ORG_PERIOD()+coverBean.getPOAC_PERIOD()) * 12), -1));
						}else if("2".equals(TERM_END_PARAM)){
							coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(
									CommonUtils.addMonthsToDate(coverBean.getPOAC_FM_DT(),
											(coverBean.getPOAC_PERIOD()) * 12), -1));
						}
					}
				} else {
					if(!("012".equals(policyBean.getPOL_END_TYPE()))){
					coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
							coverBean.getPOAC_FM_DT(), coverBean.getPOAC_PERIOD().intValue() * 12));
					}
					else{
						coverBean.setPOAC_TO_DT(CommonUtils.addMonthsToDate(
								coverBean.getPOAC_FM_DT(), (coverBean.getPOAC_ORG_PERIOD()+coverBean.getPOAC_PERIOD()) * 12));
					}
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
			if (coverBean.getPOAC_PREM_PAY_YRS() <= 0 && 
					!("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE()))) {
				coverBean.setPOAC_PREM_PAY_YRS(1);
			} else if (coverBean.getPOAC_PREM_PAY_YRS() > M_PAC_PREM_PAY_YRS) {
				coverBean.setPOAC_PREM_PAY_YRS(M_PAC_PREM_PAY_YRS);
			}

			/*Added by saritha on 17-05-2018 for KIC In Incressing/Decreasing in Term Endorsement need to enable for Rider*/ 
			
			if(policyBean.getPOL_END_CODE()!=null){

				if(endType.equalsIgnoreCase("INCTERM") ||endType.equalsIgnoreCase("DECTERM")){

					coverBean.setPOAC_PREM_PAY_YRS(coverBean.getPOAC_PERIOD());

				}
			}
			
			/*End*/
		
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

	/*
	 * cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017 FOR SUMASSURED VALIDATION
	 * public String POAC_FC_SA_WHEN_VALIDATE_ITEM(DUMMY dummyBean,
			PT_IL_POL_ADDL_COVER coverBean, PT_IL_POLICY policyBean)
	throws Exception {*/
	/*cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017 FOR SUMASSURED VALIDATION*/
	public String POAC_FC_SA_WHEN_VALIDATE_ITEM(DUMMY dummyBean,
			PT_IL_POL_ADDL_COVER coverBean, PT_IL_POLICY policyBean,PT_IL_POLICY_ACTION policyaction)
	throws Exception {
		//END

		Double M_COVER_SA_PERC = null;
		Double M_DUMMY = null;
		Double M_DUMMY_MIN = null;
		Double M_DUMMY_MAX = null;
		Double COVER_MIN_SA = null;
		Double COVER_MAX_SA = null;
		String M_COVER_TYPE = null;
		String M_COVER_MAX_TYPE = null;
		String M_THRESHOLD_MESSAGE = null;
		Double POAC_ORG_FC_SA = null;
		Double ChangedCoverSA = null;
		
		/*Modified by Janani for not validating coverSA when Min and Max type in cover master is none,as suggested by Vinoth on 20.04.2018*/
		
		/*String CURSOR_C1 = "SELECT COVER_MIN_SA,COVER_MAX_SA,COVER_SA_PERC,COVER_TYPE,COVER_MAX_TYPE " +
				"FROM PM_IL_COVER WHERE COVER_CODE = ? ";*/
		
		String CURSOR_C1 = "SELECT COVER_MIN_SA,COVER_MAX_SA,COVER_SA_PERC,COVER_TYPE,COVER_MAX_TYPE,COVER_MIN_TYPE " +
				"FROM PM_IL_COVER WHERE COVER_CODE = ? ";
		
		String M_COVER_MIN_TYPE = null;
		
		/*End*/
		
		String CURSOR_C2 = "SELECT POAC_ORG_FC_SA FROM PT_IL_POL_ADDL_COVER WHERE POAC_SYS_ID =?";
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		P9ILPK_POLICY ILprocedure = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		String selectQuery ="SELECT  P9ILPK_POLICY.F_GET_THR_LIMIT_MSG FROM DUAL";
		ArrayList<OracleParameter> list3 = null;
		/*added by Ameen on 03-05-2018 for KIC as per Anbarasi sugg.for KIC-1496269*/
		Double criticIllnesscheck = null;
		Double cricticSA = null;
		/*End*/
		
		String coverClass = null;
		
		try {
			connection = CommonUtils.getConnection();
			dummyBean.setUI_M_CHANGE_SA_YN("Y");
			
			/*Moved here for validation purpose by ganesh on 10-04-2018 */
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				COVER_MIN_SA = resultSet.getDouble(1);
				COVER_MAX_SA = resultSet.getDouble(2);
				dummyBean.setUI_M_COVER_MIN_SA(resultSet.getDouble(1));
				dummyBean.setUI_M_COVER_MAX_SA(resultSet.getDouble(2));
				M_COVER_SA_PERC = resultSet.getDouble(3);
				M_COVER_TYPE = resultSet.getString(4);
				/*Added by ganesh on 06-04-2018*/
				M_COVER_MAX_TYPE = resultSet.getString(5);
				/*end*/
				
				/*Modified by Janani for not validating coverSA when Min and Max type in cover master is none,as suggested by Vinoth on 20.04.2018*/
				
				M_COVER_MIN_TYPE = resultSet.getString(6);
				
				System.out.println("M_COVER_MIN_TYPE                  "+M_COVER_MIN_TYPE);
				
				/*End*/
				System.out.println("cover min SA"+COVER_MIN_SA);
				System.out.println("cover max SA"+COVER_MAX_SA);
				System.out.println("FC SA"+coverBean.getPOAC_FC_SA());
				
			}
			/*end*/
			
			/*Modified by ganesh on 20-06-2017, suggested by ajoy */
			if(!("012".equalsIgnoreCase(policyBean.getPOL_END_TYPE())) && !("ADDRIDER".equalsIgnoreCase(policyBean.getPOL_END_CODE()))  &&
					coverBean.getPOAC_FC_SA() > policyBean.getPOL_FC_SUM_ASSURED()) {
				
				/*Modifed by Shankar on 07/04/2017
				 * 
				 * throw new Exception("Cover Sum Assured Can not be Greater than Policy Sum Assured");*/
				
				/*cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017 FOR SUMASSURED VALIDATION*/
				/*Added system parameter by ganesh on 09-04-2018 as suggested by chandramohan for Rider SA greater than base SA */
				//String sysParamIL_SA_CHECK = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_SA_CHECK"));
				//if(sysParamIL_SA_CHECK!=null && !"0".equals(sysParamIL_SA_CHECK)){
				if(!"A".equals(M_COVER_MAX_TYPE)){
				if("U".equalsIgnoreCase(policyaction.getPLAN_TYPE())){
					if(("Y".equalsIgnoreCase(policyaction.getPROD_RISK_FLG()))){

						throw new Exception("Cover Sum Assured Can not be Greater than Policy Sum Assured");

					}
				}else{

					throw new Exception("Cover Sum Assured Can not be Greater than Policy Sum Assured");
				}
				}
				/*end*/
				/*END*/
				
			}
			/*Commentted & Modified by saritha on 01-09-2017 for ssp call id ZBILQC-1736138*/  
			/*if (!(dummyBean.getUI_M_PS_CODE().equals(CommonUtils.nvl(policyBean.getPOL_END_CODE(), "000")))) {*/
				/*MODIFIED BY GOPI FOR SSP CALL ID ZBILQC-1732074 ON 17/08/17*/
				/*if (!("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")))
					&&( !( "012".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))))
						&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
								&& coverBean.getPOAC_FC_SA() <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "FC Sum Assured","Greater than 0" }));
				}*/
				/*if (!("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")))
						&&( !( "012".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))))
							&& "N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
									&& (!(coverBean.getPOAC_FC_SA()>=COVER_MIN_SA && coverBean.getPOAC_FC_SA()<=COVER_MAX_SA))){
						throw new Exception("Sum Assured is not between range of Min SA "+COVER_MIN_SA + " and Max SA "+COVER_MAX_SA +" in Cover Master");
				}
				//END ZBILQC-1732074 
				*/
			   /*End*/
				
				
				//added by akash ,if you not default any value in product (applicable cover) in Medical amt
				// filed its value insert 0 instead of null
				if(coverBean.getPOAC_LC_MED_AMT() != null){
				if(coverBean.getPOAC_LC_MED_AMT() != 0.0){
				if(coverBean.getPOAC_FC_SA() > coverBean.getPOAC_LC_MED_AMT()){
					throw new Exception("Sum Assured should not exceeds Medical Amount");
				}
				}
				}
		//	}
			
			/*Moved to top for validation purpose by ganesh on 10-04-2018 */
			/*resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				COVER_MIN_SA = resultSet.getDouble(1);
				COVER_MAX_SA = resultSet.getDouble(2);
				dummyBean.setUI_M_COVER_MIN_SA(resultSet.getDouble(1));
				dummyBean.setUI_M_COVER_MAX_SA(resultSet.getDouble(2));
				M_COVER_SA_PERC = resultSet.getDouble(3);
				M_COVER_TYPE = resultSet.getString(4);
				Added by ganesh on 06-04-2018
				M_COVER_MAX_TYPE = resultSet.getString(5);
				end
				System.out.println("cover min SA"+COVER_MIN_SA);
				System.out.println("cover max SA"+COVER_MAX_SA);
				System.out.println("FC SA"+coverBean.getPOAC_FC_SA());
				
			}*/
			
			/*Added by saritha on 01-09-2017 for ssp call id ZBILQC-1736138*/  
			
			/*condition modified by ganesh on 06-04-2018 suggested by chandramohan*/
			/*condition reverted by ganesh on 09-04-2018 suggested by chandramohan*/
				/*Added by saritha on 15-05-2018 to reset the POAC_LC_SA -*/
				coverBean.setPOAC_LC_SA(coverBean.getPOAC_FC_SA()* policyBean.getPOL_SA_EXCH_RATE());
				/*End*/
			if(policyBean.getPOL_SA_CURR_CODE().equalsIgnoreCase(policyBean.getPOL_CUST_CURR_CODE())){
				
				/*Added by Janani for not validating coverSA when Min and Max type in cover master is none,as suggested by Vinoth on 20.04.2018*/
				
				if(!(M_COVER_MIN_TYPE.equalsIgnoreCase("n") && M_COVER_MAX_TYPE.equalsIgnoreCase("n")))
				{
				
				/*End*/
				
				if("N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
						&& (!(coverBean.getPOAC_FC_SA()>=COVER_MIN_SA && coverBean.getPOAC_FC_SA()<=COVER_MAX_SA))){
					throw new Exception("Sum Assured is not between range of Min SA "+CommonUtils.Decimal_Convert(COVER_MIN_SA.toString()) + " and Max SA "+CommonUtils.Decimal_Convert(COVER_MAX_SA.toString()) +" in Cover Master");
				}else { /*else part handled by Ameen on 03-05-2018 for KIC as per Anbarasi sugg.for KIC-1496269*/
					criticIllnesscheck = criticalIllness(coverBean,policyBean);
					
					
					/*Added by saritha on 14-05-2018 for KIC SSP Call id : KICLIFEQC-1751755
					 * Rider LC SA is not changed according to the FC SA entered when the SA currency is selected as KD.*/
					
					coverClass = getcoverClass(coverBean,policyBean);
					/*Added by Ameen to check only 50% of S.A. for critical illness covers*/
					
					if(coverClass != null && "X".equalsIgnoreCase(coverClass)){
						
						cricticSA = criticalSA(coverBean,policyBean);
						if(coverBean.getPOAC_LC_SA() > cricticSA){
							
							throw new Exception("Critical Illness Cover S.A. should be lesser than or equal to 50 % Policy S.A. which is : " + cricticSA);
						}
						
					}
					/*End*/
					if(criticIllnesscheck > COVER_MAX_SA && coverClass!=null && coverClass.equalsIgnoreCase("X") ){
						
						throw new Exception("Critical Illness Sum Assured Should not exceed " + COVER_MAX_SA + " in Cover Master");
					}
					
					/*End*/
				}
				}
			}else{
				/*Added by ganesh on 16-04-2018 riderSA can be greater than BaseSA (to reset the actual calculation value)*/
				coverBean.setPOAC_LC_SA(coverBean.getPOAC_FC_SA()* policyBean.getPOL_SA_EXCH_RATE());
				/*end*/
				
/*Added by Janani for not validating coverSA when Min and Max type in cover master is none,as suggested by Vinoth on 20.04.2018*/
				
				if(!(M_COVER_MIN_TYPE == "N" && M_COVER_MAX_TYPE == "N"))
				{
				
				/*End*/
					
				if("N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
						&& (!(coverBean.getPOAC_LC_SA()>=COVER_MIN_SA && coverBean.getPOAC_LC_SA()<=COVER_MAX_SA))){
					throw new Exception("Sum Assured is not between range of Min SA "+CommonUtils.Decimal_Convert(COVER_MIN_SA.toString()) + " and Max SA "+CommonUtils.Decimal_Convert(COVER_MAX_SA.toString()) +" in Cover Master");
				}else { /*else part handled by Ameen on 03-05-2018 for KIC as per Anbarasi sugg.for KIC-1496269*/
					criticIllnesscheck = criticalIllness(coverBean,policyBean);
					
					/*Added by saritha on 14-05-2018 for KIC SSP Call id : KICLIFEQC-1751755
					 * Rider LC SA is not changed according to the FC SA entered when the SA currency is selected as KD.*/
					
					coverClass = getcoverClass(coverBean,policyBean);
					
					/*Added by Ameen to check only 50% of S.A. for critical illness covers*/
					
					if(coverClass != null && "X".equalsIgnoreCase(coverClass)){
						
						cricticSA = criticalSA(coverBean,policyBean);
						if(coverBean.getPOAC_LC_SA() > cricticSA){
							
							throw new Exception("Critical Illness Cover S.A. should be less than or equal to " + cricticSA);
						}
						
					}
					/*End*/
					
					if(criticIllnesscheck > COVER_MAX_SA && coverClass!=null && coverClass.equalsIgnoreCase("X")){
						
						throw new Exception("Critical Illness Sum Assured Should not exceed " + COVER_MAX_SA + " in Cover Master");
					}
					
					/*End*/
					
				}
				}
			}
			
			
			/*if("N".equals(CommonUtils.nvl(coverBean.getPOAC_DEL_FLAG(), "N"))
					&& (!(coverBean.getPOAC_FC_SA()>=COVER_MIN_SA && (coverBean.getPOAC_FC_SA()<=COVER_MAX_SA || M_COVER_MAX_TYPE.equalsIgnoreCase("A"))))){
				throw new Exception("Sum Assured is not between range of Min SA "+CommonUtils.Decimal_Convert(COVER_MIN_SA.toString()) + " and Max SA "+CommonUtils.Decimal_Convert(COVER_MAX_SA.toString()) +" in Cover Master");
			}*/
			/*End*/
			
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
			
			
			//added for checking the limits of coverSA during endorsements
			if("002".equalsIgnoreCase(policyBean.getPOL_END_TYPE())){
			
				resultSet2 = handler.executeSelectStatement(CURSOR_C2, connection, new Object[]{coverBean.getPOAC_SYS_ID()});
				
					while(resultSet2.next()){
						POAC_ORG_FC_SA = resultSet2.getDouble(1);
					}
					
					if(POAC_ORG_FC_SA!=null){
						/*Modified by ganesh on 28-08-2017, ZBILQC-1736155 as suggested by ajoy*/
						if(fetchEndLogic().equalsIgnoreCase("2")){
							ChangedCoverSA = coverBean.getPOAC_FC_SA();
						}else{
							ChangedCoverSA = POAC_ORG_FC_SA + coverBean.getPOAC_FC_SA();
						}
						/*end*/
						if((ChangedCoverSA<COVER_MIN_SA) || (ChangedCoverSA>COVER_MAX_SA)){
							throw new Exception(Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90010", new Object[] {
													"Cover SA",
													COVER_MIN_SA,
													COVER_MAX_SA }));
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
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
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
					CommonUtils.getProcedureValue(policyBean.getPOL_SA_EXCH_RATE()),"E");

			/*coverBean.setPOAC_FC_SA(coverBean.getPOAC_LC_SA()
					/ policyBean.getPOL_SA_EXCH_RATE());*/
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
							//coverBean.getPOAC_SYS_ID(),
							M_POAC_RATE_APPLIED_ON,
							M_POAC_FC_SA,
							M_POAC_LC_SA,
							coverBean.getPOAC_MED_DAYS(),
							coverBean.getPOAC_LC_MED_AMT(),
							coverBean.getPOAC_PAPP_SYS_ID(),
							coverBean.getPOAC_NO_OF_UNIT(), 
							//"N",
						//	M_POAC_LC_MED_AMT,
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
					/*coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);*/
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		dummyBean.setUI_M_CHANGE_SA_YN("Y");
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, 
					new Object[]{coverBean.getPOAC_COVER_CODE()});
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
				M_POAC_RATE_APPLIED_ON = resultSet.getString(2);
				if ("M".equals(M_COVER_CLASS)) {
				    
				    /// Changed for package policy by Kavitha
					list = ILProcedure.P_CALC_COVER_SA(
							coverBean.getPOAC_POL_SYS_ID(),
							coverBean.getPOAC_COVER_CODE(),
							//coverBean.getPOAC_SYS_ID(),
							M_POAC_RATE_APPLIED_ON,
							M_POAC_FC_SA,
							M_POAC_LC_SA, 
							coverBean.getPOAC_MED_DAYS(),
							coverBean.getPOAC_LC_MED_AMT(),
							//coverBean.getPOAC_NO_OF_UNIT(),
							//dummyBean.getUI_M_CHANGE_SA_YN(),
							//M_POAC_LC_MED_AMT,
							coverBean.getPOAC_PAPP_SYS_ID(),
							coverBean.getPOAC_NO_OF_UNIT(),coverBean.getPOAC_PCG_SYS_ID());
					if (list != null && !list.isEmpty()) {
						if (list.get(0).getValue() != null) {
							M_POAC_RATE_APPLIED_ON = list.get(0).getValue();
						}if (list.get(1).getValue() != null) {
							M_POAC_FC_SA =Double.parseDouble(list.get(1).getValue());
						}if (list.get(2).getValue() != null) {
							M_POAC_LC_SA =Double.parseDouble(list.get(2).getValue());
						}/*if (list.get(3).getValue() != null) {
							M_POAC_LC_MED_AMT = Double.parseDouble(list.get(3).getValue()); 
						}*/
					}
							
					list1 = localProcedure.L_CHECK_MED_AMT(
							coverBean.getPOAC_SYS_ID(),
							policyBean.getPOL_SYS_ID(),
							policyBean.getPOL_PROD_CODE(),
							coverBean.getPOAC_COVER_CODE(),
							coverBean.getPOAC_LC_MED_AMT(),
							coverBean.getPOAC_LC_SA());
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							coverBean.setPOAC_LC_MED_AMT(Double.parseDouble(list1.get(0)));
						}
					}
							
					/*coverBean.setPOAC_FC_SA(M_POAC_FC_SA);
					coverBean.setPOAC_LC_SA(M_POAC_LC_SA);*/
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
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
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
			PT_IL_POL_ADDL_COVER coverbean,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			if ("012".equalsIgnoreCase(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_END_TYPE())) {
				if ((coverbean.getPOAC_PREM_PAY_YRS() + coverbean
						.getPOAC_ORG_PREM_PAY_YRS()) > (coverbean
						.getPOAC_PERIOD() + coverbean.getPOAC_ORG_PERIOD())) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91014",
											new Object[] { "Premium paying years less than or eqal to policy period" }));
				}
			} else {
				if (coverbean.getPOAC_PREM_PAY_YRS() > coverbean
						.getPOAC_PERIOD() ) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Premium paying years less than or eqal to policy period" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	 

	    public void onPopulateDetail(PILT002_APAC_COMPOSITE_ACTION compositeAction)
		    throws Exception {
	    	System.out.println("onPopulateDetail called in cover page");
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
	    
	    public void setDefaultWopYN(String currValue,PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN) throws Exception{
	    	Connection connection = null;
	    	CRUDHandler handler = new CRUDHandler();
	    	ResultSet resultset = null;
	    	String C1 = "SELECT 'X' FROM PM_IL_APPL_WOP_COVER WHERE AWCVR_COVER_CODE = ? ";
	    	try {
				connection = CommonUtils.getConnection();
				resultset = handler.executeSelectStatement(C1, connection,new Object[]{currValue});
				if(resultset.next()){
					PT_IL_POL_ADDL_COVER_BEAN.setPOAC_WOP_FLAG("Y");
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	    	
	    }
	    
	    public void setcoverDate(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POLICY policyBean, PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POL_ADDL_COVER_1_ACTION cover1Action)
			throws Exception {
		String updateQuery = "UPDATE PT_IL_POL_ADDL_COVER SET POAC_TO_DT = ? WHERE POAC_POL_SYS_ID = ? "
				+ "AND POAC_SYS_ID= ?";
		try {
			if (coverAction.getDataList_PT_IL_POL_ADDL_COVER().size() > 0) {
				for (int i = 0; i < coverAction
						.getDataList_PT_IL_POL_ADDL_COVER().size(); i++) {
					coverBean.setPOAC_TO_DT(CommonUtils.addDaysToDate(CommonUtils
							.addMonthsToDate(coverBean.getPOAC_FM_DT(),
									(coverBean.getPOAC_ORG_PERIOD() + coverBean
											.getPOAC_PERIOD()) * 12), -1));
					new CRUDHandler().executeUpdateStatement(updateQuery,
							CommonUtils.getConnection(), new Object[] {
						coverBean.getPOAC_TO_DT(), policyBean.getPOL_SYS_ID(),
									coverBean.getPOAC_SYS_ID() });
				}
			}
				if (cover1Action.getDataList_PT_IL_POL_ADDL_COVER_1().size() > 0) {
					for (int i = 0; i < cover1Action
							.getDataList_PT_IL_POL_ADDL_COVER_1().size(); i++) {
						cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN().setPOAC_TO_DT(CommonUtils.addDaysToDate(CommonUtils
								.addMonthsToDate(cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN().getPOAC_FM_DT(),
										(cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN().getPOAC_ORG_PERIOD() 
												+ cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN()
												.getPOAC_PERIOD()) * 12), -1));
						new CRUDHandler().executeUpdateStatement(updateQuery,
								CommonUtils.getConnection(), new Object[] {
							cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN().getPOAC_TO_DT(), 
							policyBean.getPOL_SYS_ID(),
							cover1Action.getPT_IL_POL_ADDL_COVER_1_BEAN().getPOAC_SYS_ID() });
					}
			}
			CommonUtils.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
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

				    
				    /*Added by ganesh on 03-07-2017, as per suggested by ajoy */
				    public String fetchEndLogic() throws SQLException, DBException
					{
						ResultSet rs = null;
						CRUDHandler crudHandler = new CRUDHandler();
						String endLoginValue = "";						
						
						rs = crudHandler.executeSelectStatement("SELECT NVL(PARA_VALUE, 0) FROM PCOM_APP_PARAMETER WHERE PARA_CODE = 'IL_END_LOGIC' AND PARA_SUB_CODE = 'IL_END_LOGIC'", CommonUtils.getConnection());
						if(rs.next()){
							
							endLoginValue = rs.getString(1);			
						}
						
						rs.close();
						return endLoginValue;
					}
				    /*end*/

				    /*Added by saritha on 14-08-2017 for ssp call id ZBILQC-1734743*/
				    public void POST_UPDATE(PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN,DUMMY DUMMY_BEAN,
				    		PILT002_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
				    	
				    	ResultSet rs1 = null;
				    	Connection connection = null;
				    	Object[] object1 = {};
				    	P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
				    	String query = " SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POL_SYS_ID = ? ";
				    	String M_DUMMY;
				    	try{
				    	connection = CommonUtils.getConnection();
				    	String nvlVal = CommonUtils.nvl(
				    			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE(), "000");
						if ("000".equals(nvlVal) || "002".equals(nvlVal)
								|| "012".equals(nvlVal) || "013".equals(nvlVal)) {
							object1 = new Object[] { PT_IL_POL_ADDL_COVER_BEAN.getPOAC_POL_SYS_ID()};
							rs1 = new CRUDHandler().executeSelectStatement(query,
									connection, object1);
							while (rs1.next()) {
								M_DUMMY = rs1.getString(1);
								
								/*if (("Y".equals(CommonUtils.nvl(CommonUtils
										.getGlobalVariable("GLOBAL.M_LC_CHECK"), "N")) || "N"
										.equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_COVER_SA_CALC()))
										|| ("013".equals(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
												getPOL_END_TYPE(), "000")))) {*/
									if (!"A".equals(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()
											, "N"))
											&& !"A".equals(CommonUtils
													.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
															getPOL_APPRV_STATUS(), "N"))) {
										if (!"012"
												.equalsIgnoreCase(CommonUtils
														.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
																getPOL_END_TYPE(), "000"))) {
											p9ilpk_policy.P_UPD_ADDL_COVER(
													PT_IL_POL_ADDL_COVER_BEAN.getPOAC_POL_SYS_ID()
															.toString(), compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
															getPOL_PROD_CODE(),compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
															.getUI_M_CHANGE_SA_YN());
										}
									}
								//}
								//CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK", "N");
							}
							connection.commit();
							
						}

				    } catch (Exception e) {
						e.printStackTrace();
						throw new Exception(e.getMessage());
					} finally {
						try {
							
							CommonUtils.closeCursor(rs1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
				    }
				    /*End*/
				   /* added by gopi on 08/12/17*/
				    public void brokerSave(PT_IL_POLICY policyBean,
							PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean) throws Exception {
						System.out.println("inside brokerSave");
						String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE FROM   PM_CUSTOMER WHERE  CUST_CODE = ?  ";
						String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_CODE = ? ";
						String CURSOR_C5 = "SELECT POBH_SYS_ID FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? AND POBH_SRNO = '1' ";
						String CURSOR_C6 = "SELECT POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE FROM   PT_IL_POL_BROKER_HEAD "
								+ " WHERE  POBH_POL_SYS_ID =  ? AND    POBH_SYS_ID     = ? ";
						String CURSOR_C10= "SELECT PROD_AGENT_HIRE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE ? ";
						String CURSOR_C11="SELECT POBH_SYS_ID,POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE,POBH_AGENT_LEVEL "
										+ "FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID =?";
						ResultSet resultSet2 = null, resultSet3 = null,resultSet5 =null,resultSet6 = null,resultSet10 = null,resultSet11=null;
						Connection connection = null;
						CRUDHandler handler = new CRUDHandler();
						String heir_yn=null;
						Long M_POBH_SYS_ID = null;
						String M_POBH_BROKER_CODE = null;
						String M_POBH_COMM_CODE = null;
						String M_POBH_COVER_CODE = null;
						Double M_AGENT_LEVEL = null;
						String M_LOWEST_RANK_CODE = null;
						String M_CUST_AGENT_RANK_CODE = null;
						try {
							connection = CommonUtils.getConnection();
							P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
							resultSet5 = handler.executeSelectStatement(CURSOR_C5,connection, new Object[] { policyBean.getPOL_SYS_ID() });
							while (resultSet5.next()) {
								M_POBH_SYS_ID = resultSet5.getLong(1);
								resultSet10=handler.executeSelectStatement(CURSOR_C10, connection,new Object[]{policyBean.getPOL_PROD_CODE()});
								while(resultSet10.next()){
									heir_yn=resultSet10.getString(1);
								}
								resultSet6 = handler.executeSelectStatement(CURSOR_C6,
										connection, new Object[] {
												policyBean.getPOL_SYS_ID(),
												M_POBH_SYS_ID });
								if (resultSet6.next()) {
									M_POBH_BROKER_CODE = resultSet6.getString(1);
									M_POBH_COVER_CODE = resultSet6.getString(2);
									M_POBH_COMM_CODE = resultSet6.getString(3);
								}
								resultSet2 = handler
										.executeSelectStatement(CURSOR_C2, connection,
												new Object[] { M_POBH_BROKER_CODE });
								if (resultSet2.next()) {
									M_CUST_AGENT_RANK_CODE = resultSet2.getString(1);
								}
								resultSet3 = handler.executeSelectStatement(CURSOR_C3,
										connection,
										new Object[] { M_CUST_AGENT_RANK_CODE });
								if (resultSet3.next()) {
									M_AGENT_LEVEL = resultSet3.getDouble(1);
								}
								if("y".equalsIgnoreCase(heir_yn)){
									resultSet11 = handler.executeSelectStatement(CURSOR_C11,
											connection,
											new Object[] { policyBean.getPOL_SYS_ID() });
									while(resultSet11.next()){
										p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
												.getProcedureValue(policyBean
														.getPOL_SYS_ID()), CommonUtils
												.getProcedureValue(resultSet11.getLong("POBH_SYS_ID")),
												resultSet11.getString("POBH_BROKER_CODE"),resultSet11.getString("POBH_COVER_CODE"),
												resultSet11.getString("POBH_COMM_CODE"), CommonUtils
														.getProcedureValue(policyBean
																.getPOL_PERIOD()),
												CommonUtils.getProcedureValue(policyBean
														.getPOL_LC_SUM_ASSURED()),
												CommonUtils
														.getProcedureValue(resultSet11.getDouble("POBH_AGENT_LEVEL")),
												M_LOWEST_RANK_CODE);
										
								
									}
								}else
								{
									
									System.out.println("heir_yn                     :"+heir_yn);
									
									p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
											.getProcedureValue(policyBean
													.getPOL_SYS_ID()), CommonUtils
											.getProcedureValue(M_POBH_SYS_ID),
											M_POBH_BROKER_CODE, M_POBH_COVER_CODE,
											M_POBH_COMM_CODE, CommonUtils
													.getProcedureValue(policyBean
															.getPOL_PERIOD()),
											CommonUtils.getProcedureValue(policyBean
													.getPOL_LC_SUM_ASSURED()),
											CommonUtils
													.getProcedureValue(M_AGENT_LEVEL),
											M_LOWEST_RANK_CODE);
								}		
						}
						}
						catch (SQLException e) {
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
								CommonUtils.closeCursor(resultSet2);
							} catch (Exception e) {
							}
						}

	
				   /* end*/
				    
}
				    /*Added by gopi on 11-12-2017 as suggested by ajoy */ 
				    public void preDelete(PT_IL_POL_ADDL_COVER coverBean) throws Exception {
						Connection connection = null;
						CRUDHandler handler = new CRUDHandler();
						String DELETE_QUERY = "DELETE FROM PT_IL_POL_BROKER_DTL WHERE POBD_COMM_COVER_CODE =?"
								+ "AND POBD_POBH_SYS_ID IN (SELECT POBH_SYS_ID FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID =?) ";
						try {
							connection = CommonUtils.getConnection();
							handler.executeDeleteStatement(DELETE_QUERY, connection,
									new Object[] { coverBean.getPOAC_COVER_CODE(),coverBean.getPOAC_POL_SYS_ID()});
						} catch (DBException e) {
							e.printStackTrace();
							throw new Exception(e.getMessage());
						} catch (SQLException e) {
							e.printStackTrace();
							throw new Exception(e.getMessage());
						}
					}
				    
				    
				    /*Added by saritha on 29-Jan-2018 for ssp call id ZBLIFE-1444238 as per siva sir sugg. 
					 * The MoreCover Funeral Plan is also available as a rider but functionality is not available. */
				    
				    public void setDefaultSumAssured207Rider(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
				    	Connection connection = null;
				    	ResultSet rst = null;
				    	ResultSet rst1 = null;

				    	String coverRider207RQuery = "SELECT 'X' FROM PM_IL_COVER WHERE COVER_FUNERAL_CVR_YN = 'Y' AND COVER_CODE = ? ";
				    	String coverMinSAQuery     = "SELECT COVER_MIN_SA FROM PM_IL_COVER WHERE COVER_CODE = ?";

				    	try {

				    		connection = CommonUtils.getConnection();
				    		rst = new CRUDHandler().executeSelectStatement(coverRider207RQuery, connection,new Object[]
				    				{compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getPT_IL_POL_ADDL_COVER_BEAN().getPOAC_COVER_CODE()});
				    		if(rst.next()){

				    			rst1 = new CRUDHandler().executeSelectStatement(coverMinSAQuery, connection,new Object[]
				    					{compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getPT_IL_POL_ADDL_COVER_BEAN().getPOAC_COVER_CODE()});

				    			if(rst1.next()){	
				    				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_FC_SA(rst1.getDouble("COVER_MIN_SA"));
				    				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_LC_SA(rst1.getDouble("COVER_MIN_SA"));

				    			}


				    		}



				    	} catch (Exception e) {
				    		// TODO: handle exception
				    		e.printStackTrace();
				    		throw e;
				    	}finally {
				    		CommonUtils.closeCursor(rst);
				    		CommonUtils.closeCursor(rst1);
				    	}

				    }

				    /*End ZBLIFE-1444238 */

				    /*Added by Janani on 28.04.2018 for base product as suggested by Vinoth*/
				    public int get_polPeriod(Long pol_sys_id) throws Exception {
				    	Connection connection = null;
				    	String Query1 = "SELECT POL_PERIOD FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
						ResultSet resultSet1 = null;
						int pol_period = 0;
				    	try {

				    		connection = CommonUtils.getConnection();
				    		resultSet1 = new CRUDHandler().executeSelectStatement(Query1, connection,
									new Object[] {pol_sys_id});
							if (resultSet1.next()) {
								
								pol_period = resultSet1.getInt("POL_PERIOD");
							}
							

				    	} catch (Exception e) {
				    		// TODO: handle exception
				    		e.printStackTrace();
				    		throw e;
				    	}
						return pol_period;

				    }
   /*End*/
				    /*added by Ameen on 03-05-2018 for KIC as per Anbarasi sugg.for KIC-1496269*/
					public Double criticalIllness(PT_IL_POL_ADDL_COVER COVER_BEAN,PT_IL_POLICY  POLICY_BEAN) throws Exception{	
						
						String criticIllnessQry = null;
						Double criticIllnessVal = 0.0;
						ResultSet criticIllnessRS=null;
						Object[] params = null;
						
						try{
							if(COVER_BEAN.getROWID() == null){
							    /*criticIllnessQry = "SELECT NVL(SUM(POAC_LC_SA),0) + ? P_LC_SA FROM PT_IL_POLICY , PT_IL_POL_ADDL_COVER, "
										+ "PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' "
										+ "AND POL_CONT_CODE = ? ";*/
							    criticIllnessQry = "SELECT NVL(SUM(POAC_LC_SA),0) + ? P_LC_SA FROM PT_IL_POLICY , PT_IL_POL_ADDL_COVER, "
										+ "PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' "
										+ "AND POL_CONT_CODE = ? AND POL_DS_TYPE = 1 ";
							    
							    params = new Object[]{COVER_BEAN.getPOAC_LC_SA(),POLICY_BEAN.getPOL_CONT_CODE()};
							}else{
							    /*criticIllnessQry = "SELECT NVL(SUM(POAC_LC_SA),0) + ? P_LC_SA FROM PT_IL_POLICY , PT_IL_POL_ADDL_COVER, "
										+ "PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' "
										+ "AND POL_CONT_CODE = ? AND PT_IL_POL_ADDL_COVER.ROWID<>?";*/
							    
							    criticIllnessQry = "SELECT NVL(SUM(POAC_LC_SA),0) + ? P_LC_SA FROM PT_IL_POLICY , PT_IL_POL_ADDL_COVER, "
										+ "PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' "
										+ "AND POL_CONT_CODE = ? AND POL_DS_TYPE = 1 AND PT_IL_POL_ADDL_COVER.ROWID<>?";
							    
							    params = new Object[]{COVER_BEAN.getPOAC_LC_SA(),POLICY_BEAN.getPOL_CONT_CODE(),COVER_BEAN.getROWID()};
							}
						
							criticIllnessRS = new CRUDHandler().executeSelectStatement(criticIllnessQry, CommonUtils.getConnection(),params);
							if(criticIllnessRS.next()){
								criticIllnessVal = criticIllnessRS.getDouble("P_LC_SA");
							}
							
						}catch(Exception e){
							e.printStackTrace();
							throw new Exception(e.getMessage());
						}
						
						return criticIllnessVal;
					}
					
					public Double criticalSA(PT_IL_POL_ADDL_COVER COVER_BEAN,PT_IL_POLICY POLICY_BEAN){
						
						/*String divQry = "SELECT COVER_SA_PERC FROM PM_IL_COVER, PT_IL_POL_ADDL_COVER WHERE COVER_CODE = POAC_COVER_CODE AND COVER_CODE =?"
								+ "AND POAC_POL_SYS_ID = ?";*/
						String divQry = "SELECT COVER_SA_PERC FROM PM_IL_COVER WHERE COVER_CODE = ?";
						ResultSet rs = null;
						Double perc = 0.0;
						Double saVal = 0.0;
						
						try {
							rs = new CRUDHandler().executeSelectStatement(divQry, CommonUtils.getConnection(),
											new Object[]{COVER_BEAN.getPOAC_COVER_CODE()});
							if(rs.next()){
								perc = rs.getDouble("COVER_SA_PERC");
							}
							saVal = POLICY_BEAN.getPOL_LC_SUM_ASSURED()*perc/100;
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						return saVal;
					}
					
					 /*End*/
					
					/*Added by saritha on 14-05-2018 for KIC SSP Call id : KICLIFEQC-1751755
					 * Rider LC SA is not changed according to the FC SA entered when the SA currency is selected as KD.*/
					
					public String getcoverClass(PT_IL_POL_ADDL_COVER COVER_BEAN,PT_IL_POLICY  POLICY_BEAN) throws Exception{	

						String coverClassQuery = null;
						ResultSet coverClassRS=null;
						String coverClass = null;
						Object[] values = null;

						try{

							/*coverClassQuery = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER,PT_IL_POLICY,PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID "
									+ "AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' AND POL_CUST_CODE = ?";*/
							
							/*coverClassQuery = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER,PT_IL_POLICY,PM_IL_COVER WHERE POL_SYS_ID = POAC_POL_SYS_ID "
									+ "AND POAC_COVER_CODE = COVER_CODE AND COVER_CLASS = 'C' AND POL_CUST_CODE = ? AND POAC_COVER_CODE = ?";*/
							coverClassQuery = "SELECT 'X' FROM PM_IL_COVER WHERE COVER_CLASS = 'C' AND COVER_CODE = ?";

							/*values = new Object[]{POLICY_BEAN.getPOL_CUST_CODE(),COVER_BEAN.getPOAC_COVER_CODE()};*/
							values = new Object[]{COVER_BEAN.getPOAC_COVER_CODE()};
							coverClassRS = new CRUDHandler().executeSelectStatement(coverClassQuery, CommonUtils.getConnection(),values);
							if(coverClassRS.next()){

								coverClass = coverClassRS.getString(1);
							}

						}catch(Exception e){
							e.printStackTrace();
							throw new Exception(e.getMessage());
						}

						return coverClass;
					}
					
					/*End*/

				    
}
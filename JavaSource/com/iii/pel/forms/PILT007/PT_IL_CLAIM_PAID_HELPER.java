package com.iii.pel.forms.PILT007;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_PAID_HELPER {

	Map<String, Object> session = null;
	ControlBean ctrlBean = null;
	FacesContext ctx = FacesContext.getCurrentInstance();
	P9ILPK_CLAIM p9ilpk_claim = new P9ILPK_CLAIM();
	PILT007_COMPOSITE_ACTION compositeAction;
	public ControlBean getCtrlBean() {
		session = ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}

	public void whenNewRecordInstance(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		Long claimPolSysId = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_SYS_ID();
		String sql_FLAG = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY12;
		Object[] values = { claimPolSysId };
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		ResultSet rst4 = null;
		ResultSet rst5 = null;
		try {
			fetchDetails(compositeAction);
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_FLAG, connection, values);
			while (rst1.next()) {
				// POL_FAC_YN = rst1.getString("POL_FAC_YN");
			}

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY13;
			Long claimSysId = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			Object[] sql_C3_values = { claimSysId };
			handler = new CRUDHandler();
			String CLAIM_CURR_CODE = null;
			rst2 = handler.executeSelectStatement(sql_C3, connection,
					sql_C3_values);
			while (rst2.next()) {
				CLAIM_CURR_CODE = rst2.getString("CLAIM_CURR_CODE");
			}

			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY14;
			Object[] sql_C1_values = { claimSysId };
			rst3 = handler.executeSelectStatement(sql_C1, connection,
					sql_C1_values);
			while (rst3.next()) {
				// CE_LC_NET_EST_AMT = rst3.getDouble(1);
				// CE_FC_NET_EST_AMT = rst3.getDouble(2);
			}

			String sql_C4 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY15;
			rst4 = handler.executeSelectStatement(sql_C4, connection,
					sql_C1_values);
			while (rst4.next()) {
				// CP_LC_PAID_AMT = rst4.getDouble(1);
				// CP_FC_PAID_AMT = rst4.getDouble(2);
			}

			String sql_C5 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY16;
			Double CLAIM_EXCH_RATE = null;
			rst5 = handler.executeSelectStatement(sql_C5, connection,
					sql_C1_values);
			while (rst5.next()) {
				CLAIM_EXCH_RATE = rst5.getDouble(1);
			}
			claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_EXCH_RATE(
					CLAIM_EXCH_RATE);
			Date CP_PAID_DT = (Date) claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_PAID_DT();
			
			String M_BUY_SELL = claimAction.getPT_IL_CLAIM_BEAN()
					.getUI_M_BUY_SELL();
			
			ArrayList<OracleParameter> outputList = new PILT007_PROCEDURE()
					.P_GET_EXCHANGE_RATE(CLAIM_CURR_CODE,
							M_BUY_SELL + "", CP_PAID_DT, null, "N");
			Double exchRate = (Double) outputList.get(0).getValueObject();
			CLAIM_EXCH_RATE = exchRate;

			String approvalFlag = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_APPR_FLAG();
			String claimPaidStatus = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_CLM_PAID_STATUS();
			approvalFlag = approvalFlag == null ? "N" : approvalFlag;
			claimPaidStatus = claimPaidStatus == null ? "N" : claimPaidStatus;
			if (approvalFlag.equals("R") || approvalFlag.equals("A")) {
				claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);
			} else
				claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);

			if (approvalFlag.equals("Y") || approvalFlag.equals("A")) {
				claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(true);
				// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(true);
				// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(true);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS().setDisabled(true);
				claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);
			} else {
				claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(false);
				// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(false);
				// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(false);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS().setDisabled(false);
				claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);
			}

			if (approvalFlag.equals("Y") && claimPaidStatus.equals("A"))
				claimAction.getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
			else
				claimAction.getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
			
			/*Added by Janani on 14.02.2018 for ZB bank details enabling as per Thiags sugges*/
			
			System.out.println("getCP_PYMT_MTD from onload        "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
					getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD());
			
			if(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
					getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD() == null)
			{
			compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
			getPT_IL_CLAIM_PAID_BEAN().setCP_PYMT_MTD("2");
			}
			
			System.out.println("getCP_PYMT_MTD "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
					getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD());
			
			/*End*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst4 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst5 != null) {
					CommonUtils.closeCursor(rst1);
				}
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void whenNewBlockInstance(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY17;
		
		PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		String CLAIM_POL_NO = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO();
		Object[] values = { CLAIM_POL_NO };
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String PLAN_TYPE = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rstbenfQuery = null;
		try {
			
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C1, connection, values);
			while (rst.next()) {
				PLAN_TYPE = rst.getString("PLAN_TYPE");
			}

			
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
			boolean isNew = new PILT007_PROCEDURE().newSettlement(claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
			if (isNew) {
				P_INS_SETTLEMENT_DTL(CLAIM_SYS_ID);
				
			} else if (((String) CommonUtils.getGlobalVariable("CALLING_FORM")).startsWith("PILT006_APAC")
					&& (PLAN_TYPE == null ? "" : PLAN_TYPE).equals("U") && isNew) {
				P_INS_SETTLEMENT_DTL(CLAIM_SYS_ID);
			}
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
							.getExternalContext().getSessionMap();
								sessionMap.put("GLOBAL.M_BNF_VALUE", "1");
			if(!("B".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO()))){
				compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(true);
			}else{
				compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
				/*Added by Ameen as per Ajay sugg. to diaplay bank dtls fields on 30-11-2017*/
				compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getCOMP_UI_M_CUST_MOBILE().setDisabled(true);
				/*End*/
			}
			
			executeQuery(compositeAction);
			
			System.out.println("CLAIM_SYS_ID in whenNewBlockInstance              "+CLAIM_SYS_ID);
			System.out.println("getCLAIM_POL_SYS_ID in whenNewBlockInstance              "+claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
			
			/*Added by saritha on 09-01-2018 for ssp call id : ZBLIFE-1464092*/
			
				String benfQuery = "SELECT 'X' FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=?";
				Long CP_SYS_ID = compositeAction
						.getPILT007_PT_IL_CLAIM_PAID_ACTION()
						.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();

				rstbenfQuery = new CRUDHandler().executeSelectStatement(
						benfQuery, CommonUtils.getConnection(),
						new Object[] { CP_SYS_ID });
				if (!rstbenfQuery.next()) {

					new PILT007_PROCEDURE().P_BENF_SETTL(CLAIM_SYS_ID,
							claimAction.getPT_IL_CLAIM_BEAN()
									.getCLAIM_POL_SYS_ID(),CP_SYS_ID);
				}
			
			
			/*End*/
			
		} catch (Exception e) {
			try {
				connection.rollback();
				throw e;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {try {CommonUtils.closeCursor(rst);CommonUtils.closeCursor(rst1);CommonUtils.closeCursor(rstbenfQuery);} catch (Exception e) {}
		}
	}
	
	
	 /**
    *
    * @param P_CLAIM_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_INS_SETTLEMENT_DTL(
                    Object P_CLAIM_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
          parameterList.add(param1);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_CLAIM.P_INS_SETTLEMENT_DTL");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

	

	public ArrayList<OracleParameter> executeStoredProcedure(
			Connection connection, String procedureName,
			ArrayList<OracleParameter> parameterList) throws Exception {
		ArrayList<OracleParameter> outputParamList = null;
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			outputParamList = handler.execute(parameterList, connection,
					procedureName);
		} catch (Exception e) {
			throw e;
		}
		return outputParamList;
	}
	
	public void CP_CLAIM_PAID_TOWhenListChanged(PILT007_COMPOSITE_ACTION compositeAction){
		if(!("B".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO()))){
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(true);
		}else{
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
		}
	}

	public void whenCreateRecord(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		CRUDHandler handler = null;
		String sql_FLAG = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY19;
		Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_SYS_ID();
		handler = new CRUDHandler();
		String POL_FAC_YN = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(sql_FLAG,
					connection, new Object[] { CLAIM_POL_SYS_ID });
			while (rst.next()) {
				POL_FAC_YN = rst.getString("POL_FAC_YN");
			}
			CommonUtils.closeCursor(rst);

			String claimPaidStatus = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_CLM_PAID_STATUS();
			String approvalFlag = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_APPR_FLAG();
			String claimFreezeFlag = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_FRZ_FLAG();

			if (((approvalFlag == null ? "N" : approvalFlag).equals("Y")
					|| (approvalFlag == null ? "N" : approvalFlag).equals("R") || (approvalFlag == null ? "N"
					: approvalFlag).equals("A"))
					|| (claimFreezeFlag == null ? "N" : claimFreezeFlag)
							.equals("Y")) {
				claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(true);
				// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(true);
				// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(true);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS().setDisabled(false);
			} else {
				claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(false);
				// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(true);
				// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(false);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS().setDisabled(false);
			}
			HtmlCommandButton cbDisb = new HtmlCommandButton();
			cbDisb.setDisabled(true);
			HtmlCommandButton cbEnab = new HtmlCommandButton();
			cbEnab.setDisabled(false);
			HtmlInputText iTDisb = new HtmlInputText();
			iTDisb.setDisabled(true);
			HtmlInputText iTEnab = new HtmlInputText();
			iTEnab.setDisabled(false);
			HtmlCalendar calDisb = new HtmlCalendar();
			calDisb.setDisabled(true);
			HtmlCalendar calEnab = new HtmlCalendar();
			calEnab.setDisabled(false);
			HtmlSelectOneMenu menuDisb = new HtmlSelectOneMenu();
			menuDisb.setDisabled(true);
			HtmlSelectOneMenu menuEnab = new HtmlSelectOneMenu();
			menuEnab.setDisabled(false);

			if ((POL_FAC_YN == null ? "N" : POL_FAC_YN).equals("Y")
					&& ((POL_FAC_YN == null ? "N" : POL_FAC_YN).equals("A") || (POL_FAC_YN == null ? "N"
							: POL_FAC_YN).equals("R"))) {
				claimAction.setCOMP_UI_M_BUT_FAC_DTL(cbEnab);
			} else {
				//claimAction.setCOMP_UI_M_BUT_FAC_DTL(cbDisb);
			}

			if ((claimFreezeFlag == null ? "N" : claimFreezeFlag).equals("Y"))
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbDisb);
			else if ((claimFreezeFlag == null ? "N" : claimFreezeFlag)
					.equals("Y")
					&& (claimPaidStatus == null ? "P" : claimPaidStatus)
							.equals("A")) {
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbEnab);
				claimAction.setCOMP_UI_M_BUT_RI_CLOSE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_PV(cbDisb);
			} else if ((claimFreezeFlag == null ? "N" : claimFreezeFlag)
					.equals("Y")
					&& !(claimPaidStatus == null ? "P" : claimPaidStatus)
							.equals("A")) {
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_RI_CLOSE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_PV(cbDisb);
			} else if ((claimFreezeFlag == null ? "N" : claimFreezeFlag)
					.equals("A")) {
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_RI_CLOSE(cbEnab);
				claimAction.setCOMP_UI_M_BUT_PV(cbEnab);
			} else if ((claimFreezeFlag == null ? "N" : claimFreezeFlag)
					.equals("R")) {
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbEnab);
				claimAction.setCOMP_UI_M_BUT_RI_CLOSE(cbEnab);
				claimAction.setCOMP_UI_M_BUT_PV(cbDisb);
			} else if ((claimFreezeFlag == null ? "N" : claimFreezeFlag)
					.equals("N")) {
				claimAction.setCOMP_UI_M_BUT_APPROVE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_RI_CLOSE(cbDisb);
				claimAction.setCOMP_UI_M_BUT_PV(cbDisb);
			}

			if ((claimPaidStatus == null ? "P" : claimPaidStatus).equals("R")
					&& (approvalFlag == null ? "N" : approvalFlag).equals("N"))
				claimPaidAction.setCOMP_CP_CLAIM_REJ_REASON(iTEnab);
			else
				claimPaidAction.setCOMP_CP_CLAIM_REJ_REASON(iTDisb);

			if ((claimPaidStatus == null ? "P" : claimPaidStatus).equals("R")) {
				claimPaidAction.setCOMP_CP_PAID_DT(calDisb);
				claimPaidAction.setCOMP_CP_FC_PAID_AMT(iTDisb);
				claimPaidAction.setCOMP_CP_LC_PAID_AMT(iTDisb);
			} else {
				claimPaidAction.setCOMP_CP_PAID_DT(calEnab);
				claimPaidAction.setCOMP_CP_FC_PAID_AMT(iTEnab);
				claimPaidAction.setCOMP_CP_LC_PAID_AMT(iTEnab);
			}

			if ((approvalFlag == null ? "N" : approvalFlag).equals("Y"))
				claimAction.setCOMP_UI_M_BUT_BENF_DTLS(cbEnab);
			else
				claimAction.setCOMP_UI_M_BUT_BENF_DTLS(cbDisb);

			if ((approvalFlag == null ? "N" : approvalFlag).equals("Y")
					|| (approvalFlag == null ? "N" : approvalFlag).equals("A")) {
				claimPaidAction.setCOMP_CP_PAID_DT(calDisb);
				claimPaidAction.setCOMP_CP_FC_PAID_AMT(iTDisb);
				claimPaidAction.setCOMP_CP_LC_PAID_AMT(iTDisb);
				claimPaidAction.setCOMP_CP_CLM_PAID_STATUS(menuDisb);
				claimPaidAction.setCOMP_CP_APPR_FLAG(menuEnab);
			} else {
				claimPaidAction.setCOMP_CP_PAID_DT(calEnab);
				claimPaidAction.setCOMP_CP_FC_PAID_AMT(iTEnab);
				claimPaidAction.setCOMP_CP_LC_PAID_AMT(iTEnab);
				claimPaidAction.setCOMP_CP_CLM_PAID_STATUS(menuEnab);
				claimPaidAction.setCOMP_CP_APPR_FLAG(menuDisb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void preUpdate(PT_IL_CLAIM_PAID claimPaidBean) {
		ControlBean controlBean = CommonUtils.getControlBean();
		String userId = controlBean.getM_USER_ID();
		claimPaidBean.setCP_UPD_UID(userId);
		claimPaidBean.setCP_UPD_DT(new Date(Calendar.getInstance()
				.getTimeInMillis()));
	}

	public void preRecord(PILT007_COMPOSITE_ACTION compositeAction) {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		String approvalFlag = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.getCP_APPR_FLAG();
		approvalFlag = approvalFlag == null ? "N" : approvalFlag;
		if (approvalFlag.equals("R") || approvalFlag.equals("A")) {
			claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(true);
			// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(true);
			// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(true);
		} else {
			claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(false);
			// claimPaidAction.getCOMP_CP_FC_PAID_AMT().setDisabled(false);
			// claimPaidAction.getCOMP_CP_LC_PAID_AMT().setDisabled(false);
		}
		if (approvalFlag.equals("R") || approvalFlag.equals("A")
				&& claimAction.isUpdate())
			claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);
		else
			claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(false);
	}

	

	public void postQuery(PT_IL_CLAIM_PAID claimPaidBean,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Connection connection = null;
		CRUDHandler handler = null;
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY1;
		String C7 = "SELECT COVER_DESC " +
					"FROM   PM_IL_COVER " + 
					"WHERE  COVER_CODE = ?";
		String CP_CE_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.getCP_CE_SYS_ID().toString();
		Long CP_CLAIM_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID();
		Object[] cp_claim_sys_id= {CP_CLAIM_SYS_ID};
		
		/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
		String CLAIM_NO = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_NO();
		Object[] values1 = { CLAIM_NO };
		/*End*/
		Object[] values = { CP_CE_SYS_ID };
		handler = new CRUDHandler();
		Double estimatedLcAmount = null;
		Double estimatedFcAmount = null;
		Double paidLcAmount = null;
		Double paidFcAmount = null;
		Double netLcAmount = null;
		Double netFcAmount = null;
		Double M_CP_FC_TOT_EST = null;
		Double M_CP_LC_TOT_EST = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		ResultSet rst4 = null;
		ResultSet rst5 = null;
		ResultSet rs7 = null;
		ResultSet rs8 = null; 
		/*added by gopi for ssp call id ZBILQC-1728295 on 14/06/17*/
		ResultSet rs9 = null;
		String cust_name=null;
		//end
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Post Query  Method   ");
			System.out.println("sql_C1   : "+sql_C1 +  values);
			rst1 = handler.executeSelectStatement(sql_C1, connection, values);
			while (rst1.next()) {
				estimatedLcAmount = rst1.getDouble(1);
				estimatedFcAmount = rst1.getDouble(2);
				paidLcAmount = rst1.getDouble(3);
				paidFcAmount = rst1.getDouble(4);
				netLcAmount = rst1.getDouble(5);
				netFcAmount = rst1.getDouble(6);
			}
			
			/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
			
			String sql_C8= PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY19;
			
			//rs8 = handler.executeSelectStatement(sql_C8, connection, values1);
			rs8 = handler.executeSelectStatement(sql_C8, connection,cp_claim_sys_id);
			while (rs8.next()) {
				//M_CP_FC_TOT_EST = Double.parseDouble(rs8.getString("CP_FC_PAID_AMT"));
				/*modified by gopi for ppd rider cover issue on 21/03/2019*/
				M_CP_LC_TOT_EST = Double.parseDouble(rs8.getString(1));
				M_CP_FC_TOT_EST = Double.parseDouble(rs8.getString(2));
				//end
			}
			System.out.println("M_CP_FC_TOT_EST   : "+M_CP_FC_TOT_EST);

			/*
			 * 
			 * commented by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims
			 * 
			 * claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_TOT_EST(estimatedLcAmount);
					//estimatedLcAmount);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_TOT_EST(estimatedFcAmount);
					//estimatedFcAmount);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_TOT_PAID(
					paidLcAmount);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_TOT_PAID(
					paidFcAmount);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_BALANCE(
					netLcAmount);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_BALANCE(
					netFcAmount);*/
			
			/*End*/
			
	/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
			
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_TOT_EST(M_CP_LC_TOT_EST);
			//estimatedLcAmount);
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_TOT_EST(M_CP_FC_TOT_EST);
			//estimatedFcAmount);
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_TOT_PAID(
			paidLcAmount);
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_TOT_PAID(
			paidFcAmount);
	
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_LC_BALANCE(
			M_CP_LC_TOT_EST-paidLcAmount);
	claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setUI_M_CP_FC_BALANCE(
			M_CP_FC_TOT_EST-paidFcAmount);
	
	/*End*/
	
	
	/*added by gopi for ssp call id ZBILQC-1728295 on 14/06/17*/
	
	Object[] cust_code = { claimPaidBean.getCP_ACCNT_PAY_CODE() };
	String sql_C9= PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY21;
	rs9 = handler.executeSelectStatement(sql_C9, connection, cust_code);
	while (rs9.next()) {
		cust_name =rs9.getString("CUST_NAME");
	}
	
	//end
			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY2;
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			Object[] values_C3 = { CLAIM_SYS_ID };
			String CLAIM_CURR_CODE = null;
			rst3 = handler
					.executeSelectStatement(sql_C3, connection, values_C3);
			while (rst3.next()) {
				CLAIM_CURR_CODE = rst3.getString("CLAIM_CURR_CODE");
			}

			String M_BUY_SELL = claimAction.getPT_IL_CLAIM_BEAN()
					.getUI_M_BUY_SELL();
			Double M_CLAIM_EXCH_RATE = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_EXCH_RATE();
			Date CP_PAID_DT = claimPaidBean.getCP_PAID_DT();
			
			ArrayList<OracleParameter> exchangeRateList = new PILT007_PROCEDURE()
					.P_GET_EXCHANGE_RATE( CLAIM_CURR_CODE,
							M_BUY_SELL + "",CP_PAID_DT,null,
							"N");
			Double paramOutput = (Double)exchangeRateList.get(0).getValueObject();
			M_CLAIM_EXCH_RATE = paramOutput;
			// claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().set
			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY3;
			Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_SYS_ID();
			String M_DUMMY = null;
			rst2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { CLAIM_POL_SYS_ID });
			while (rst2.next()) {
				M_DUMMY = rst2.getString(1);
			}

			String sql_C4 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY4;
			Double CE_LC_EST_AMT = 0.0;
			Double CE_FC_EST_AMT = 0.0;
			rst4 = handler
					.executeSelectStatement(sql_C4, connection, values_C3);
			while (rst4.next()) {
				CE_LC_EST_AMT = rst4.getDouble(1);
				CE_FC_EST_AMT = rst4.getDouble(2);
			}

			String sql_C5 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY5;
			Double CP_LC_PAID_AMT = 0.0;
			Double CP_FC_PAID_AMT = 0.0;
			rst5 = handler
					.executeSelectStatement(sql_C5, connection, values_C3);
			while (rst5.next()) {
				CP_LC_PAID_AMT = rst5.getDouble(1);
				CP_FC_PAID_AMT = rst5.getDouble(2);
			}

			String CP_APPR_FLAG = claimPaidBean.getCP_APPR_FLAG();
			String CP_CLM_PAID_STATUS = claimPaidBean.getCP_CLM_PAID_STATUS();
			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")) {

			}
			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("R")) {

			}
			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					&& (CP_CLM_PAID_STATUS == null ? "P" : CP_CLM_PAID_STATUS)
							.equals("A")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
			} else if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					&& !(CP_CLM_PAID_STATUS == null ? "P" : CP_CLM_PAID_STATUS)
							.equals("A")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
			} else if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(false);
			} else if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("R")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
			} else if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("N")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
			}
			if ((M_DUMMY == null ? "N" : M_DUMMY).equals("Y")
					&& (CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")
					|| (CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("R")) {
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(false);
			} else {
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(true);
			}
			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					|| (CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")) {
				claimPaidBean.setCP_PAID_DT_DIS(true);
				claimPaidBean.setCP_FC_PAID_AMT_DIS(true);
				claimPaidBean.setCP_LC_PAID_AMT_DIS(true);
				claimPaidBean.setCP_CLM_PAID_STATUS_DIS(true);
				claimPaidBean.setCP_CLAIM_PAID_TO_DIS(true);
			} else {
				claimPaidBean.setCP_PAID_DT_DIS(false);
				claimPaidBean.setCP_FC_PAID_AMT_DIS(false);
				claimPaidBean.setCP_LC_PAID_AMT_DIS(false);
				claimPaidBean.setCP_CLM_PAID_STATUS_DIS(false);
				claimPaidBean.setCP_CLAIM_PAID_TO_DIS(false);
			}

			String CP_ACCNT_PAY_CODE = claimPaidBean.getCP_ACCNT_PAY_CODE();
			String CP_ACCNT_PAY_CODE_DESC = claimPaidBean
					.getUI_M_CP_ACCNT_PAY_CODE_DESC();
			if (CP_ACCNT_PAY_CODE != null) {
				/*commented by gopi for ssp call id ZBILQC-1728295 on 14/06/17*/
				/*CP_ACCNT_PAY_CODE_DESC = new PILT007_PROCEDURE()
						.P_VAL_CLASS_CUST(connection, "CUSTOMER",
								CP_ACCNT_PAY_CODE, CP_ACCNT_PAY_CODE_DESC, "N",
								"E");*/

			}
			/*modified by gopi for ssp call id ZBILQC-1728295 on 14/06/17*/
			/*claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC(CP_ACCNT_PAY_CODE_DESC);*/
			claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC(cust_name);
			//end
			rs7 = handler.executeSelectStatement(C7,connection,new Object[]{claimPaidBean.getUI_M_CCD_COVER_CODE()});
			if(rs7.next()){
				claimPaidBean.setUI_M_CCD_COVER_CODE_DESC(rs7.getString(1));
			}
			claimPaidBean.setCP_APPR_FLAG_DIS(true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst2);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
				if (rst4 != null) {
					CommonUtils.closeCursor(rst4);
				}
				if (rst5 != null) {
					CommonUtils.closeCursor(rst5);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delRecord(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_PAID claimPaidBean = claimPaidAction
				.getPT_IL_CLAIM_PAID_BEAN();
		String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.getCP_APPR_FLAG();
		if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("N")) {
			// delRecord
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				handler.executeDelete(claimPaidBean, connection);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} else {
			throw new Exception("Cannot delete the record");
		}
	}

	public void cpPaidDateWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			new PILT007_PROCEDURE().L_VALID_CLAIM_NO(compositeAction);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void cpFcPaidAmtWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();

		Connection connection = null;
		CRUDHandler handler = null;
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY6;
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		Object[] values = { CLAIM_SYS_ID };
		handler = new CRUDHandler();
		Double CE_FC_NET_EST_AMT = 0.0;
		Double CE_FC_PAID_AMT_TOTAL = 0.0;
		ResultSet rst1 = null;
		ResultSet rst3 = null;
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_C1, connection, values);
			while (rst1.next()) {
				CE_FC_NET_EST_AMT = rst1.getDouble(1);
				CE_FC_PAID_AMT_TOTAL = rst1.getDouble(2);
			}

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY7;
			String CLAIM_CURR_CODE = null;
			rst3 = handler.executeSelectStatement(sql_C3, connection, values);
			while (rst3.next()) {
				CLAIM_CURR_CODE = rst3.getString("CLAIM_CURR_CODE");
			}
			Date CP_PAID_DT = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_PAID_DT();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			if(CP_PAID_DT != null){
			String cpPaidDt = dateFormat.format(CP_PAID_DT);
			String M_BUY_SELL = claimAction.getPT_IL_CLAIM_BEAN()
					.getUI_M_BUY_SELL();
			if (M_BUY_SELL == null)
				M_BUY_SELL = "";
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					CLAIM_CURR_CODE);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					M_BUY_SELL.toString());
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					cpPaidDt);
			OracleParameter param4 = new OracleParameter("inout1", "STRING",
					"IN OUT", "1");
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					"N");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			String M_EXGE_RATE = null;
			ArrayList<OracleParameter> outputParamList = executeStoredProcedure(
					connection, "P_GET_EXCHANGE_RATE", parameterList);
			OracleParameter outputParam1 = outputParamList.get(0);
			M_EXGE_RATE = outputParam1.getValue();

			parameterList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN", CLAIM_CURR_CODE);
			param2 = new OracleParameter("inout1", "DOUBLE", "IN OUT",
					claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
							.getCP_FC_PAID_AMT().toString());
			param3 = new OracleParameter("in2", "STRING", "IN", "V");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			Double CP_FC_PAID_AMT = 0.0;
			ArrayList<OracleParameter> outputParamList1 = executeStoredProcedure(
					connection, "P_VAL_ROUND_AMT", parameterList);
			OracleParameter outputParam2 = outputParamList1.get(0);
			CP_FC_PAID_AMT = new Double(outputParam2.getValue());
			if (CE_FC_PAID_AMT_TOTAL
					+ claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
							.getCP_FC_PAID_AMT() > CE_FC_NET_EST_AMT) {
				// throw exception
			}
			Double CP_LC_PAID_AMT = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_FC_PAID_AMT()
					* new Double(M_EXGE_RATE);
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_LC_PAID_AMT(
					CP_LC_PAID_AMT);

			parameterList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN", claimAction
					.getPT_IL_CLAIM_BEAN().getUI_M_BASE_CURR());
			param2 = new OracleParameter("inout1", "DOUBLE", "IN OUT",
					CP_LC_PAID_AMT.toString());
			param3 = new OracleParameter("in2", "STRING", "IN", "R");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			CP_LC_PAID_AMT = 0.0;
			ArrayList<OracleParameter> paramList = executeStoredProcedure(
					connection, "P_VAL_ROUND_AMT", parameterList);
			OracleParameter paramOutput = paramList.get(0);
			CP_LC_PAID_AMT = new Double(paramOutput.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void cpFcPaidAmtKeyNextItem(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_PAID_ACTION paidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		try {
			String fcPaidAmtStr = (String) paidAction.getCOMP_CP_FC_PAID_AMT()
					.getSubmittedValue();
			Double fcPaidAmt = new Double(fcPaidAmtStr);
			paidAction.getCOMP_CP_LC_PAID_AMT().setSubmittedValue(fcPaidAmt);
			int rowIndex = paidAction.getCOMP_CLAIM_PAID_DATATABLE()
					.getRowIndex();
			List<PT_IL_CLAIM_PAID> dataTableList = paidAction
					.getPT_IL_CLAIM_PAID_BEAN_LIST();
			PT_IL_CLAIM_PAID claimPaidBean = dataTableList.get(rowIndex);
			claimPaidBean.setCP_FC_PAID_AMT(fcPaidAmt);
			claimPaidBean.setCP_LC_PAID_AMT(fcPaidAmt);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void cpClmPaidStatusWhenListChanged(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		/*Added by saritha on 23-06-2017 for ssp call id ZBILQC-1728094*/
		Connection conn = null;
		ResultSet resultset = null;
		CRUDHandler handler= new CRUDHandler();
		try {
			conn= CommonUtils.getConnection();
		/*End*/
			PT_IL_CLAIM_ACTION claimAction = compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION();
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			String CP_CLM_PAID_STATUS = (String) claimPaidAction
					.getCOMP_CP_CLM_PAID_STATUS().getSubmittedValue();
			/*Added by saritha on 23-06-2017 for ssp call id ZBILQC-1728094*/
			PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
			beneficiaryAction
			.setPT_IL_CLAIM_BENEFICIARY_LIST(new ArrayList<PT_IL_CLAIM_BENEFICIARY>());
			/*End*/
			PT_IL_CLAIM_PAID claim_paid_bean = compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN();
			
			System.out.println("CP_CLM_PAID_STATUS::::::::::::::"
					+ CP_CLM_PAID_STATUS);
			List<PT_IL_CLAIM_PAID> paidBeanList = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN_LIST();
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CLM_PAID_STATUS(
					CP_CLM_PAID_STATUS);
			String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_APPR_FLAG();
			CP_CLM_PAID_STATUS = CP_CLM_PAID_STATUS == null ? "P"
					: CP_CLM_PAID_STATUS;
			CP_APPR_FLAG = CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG;
			if (CP_CLM_PAID_STATUS.equals("R") && CP_APPR_FLAG.equals("N"))
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLAIM_REJ_REASON_DIS(false);
			else
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLAIM_REJ_REASON_DIS(true);
			if (CP_CLM_PAID_STATUS.equals("R")) {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_PAID_DT_DIS(
						true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_FC_PAID_AMT_DIS(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_LC_PAID_AMT_DIS(true);
			} else {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_PAID_DT_DIS(
						false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_FC_PAID_AMT_DIS(false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_LC_PAID_AMT_DIS(false);
			}
			if (CP_CLM_PAID_STATUS.equals("A")) {
				CP_APPR_FLAG = "Y";
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG(
						CP_APPR_FLAG);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG_DIS(
						true);
			} else {
				CP_APPR_FLAG = "N";
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG(
						CP_APPR_FLAG);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG_DIS(
						true);
			}
			if (!CP_CLM_PAID_STATUS.equals("A") && CP_APPR_FLAG.equals("Y")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(true);
			} else if (CP_CLM_PAID_STATUS.equals("A")
					&& CP_APPR_FLAG.equals("Y")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(true);
			} else if (CP_APPR_FLAG.equals("A")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(false);
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(false);
			} else if (CP_APPR_FLAG.equals("R")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG_DIS(
						true);
			} else if (CP_APPR_FLAG.equals("N")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG_DIS(
						true);
			}
			claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.setCP_APPR_FLAG_DIS(true);
			
			
			/*Commentted &Modified by saritha on 01-12-2017 for ssp call id ZBILQC-1728094*/
			/*if(CP_CLM_PAID_STATUS.equals("A")){
				System.out.println("Calim Sysid----------"+claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID());
				String C1="SELECT 'X' FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CLAIM_SYS_ID=? ";
				resultset = handler.executeSelectStatement(C1, conn,
						new Object[] {claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID()});
				if(resultset.next()) {
					System.out.println("inside if beneficiary available................");

				}

				else
				{
					throw new Exception("Atleast one beneficiary is required");

				}

			}*/
			
			if(CP_CLM_PAID_STATUS.equals("A") && claim_paid_bean.getCP_CLAIM_PAID_TO()!=null && "B".equalsIgnoreCase(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO())){
				System.out.println("Calim Sysid----------"+claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID());
				String C1="SELECT 'X' FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CLAIM_SYS_ID=? ";
				resultset = handler.executeSelectStatement(C1, conn,
						new Object[] {claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID()});
				if(resultset.next()) {
					System.out.println("inside if beneficiary available................");

				}

				else
				{
					throw new Exception("Atleast one beneficiary is required");

				}	

			}
		
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void cpApprFlagWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_APPR_FLAG();
			if(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID() != null){
			if (CP_APPR_FLAG.equals("R") || CP_APPR_FLAG.equals("A")) {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG("Y");
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG_DIS(
						true);
				throw new Exception(Messages.getString(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"91453"));
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void cpApprFlagWhenListChanged(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		Connection connection = null;
		String CP_APPR_FLAG = (String) claimPaidAction.getCOMP_CP_APPR_FLAG()
				.getSubmittedValue();
		claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.setCP_APPR_FLAG(CP_APPR_FLAG);
		CRUDHandler handler = new CRUDHandler();
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY8;
		String POL_FAC_YN = null;
		ResultSet rst1 = null;
		ResultSet rst3 = null;
		ResultSet rst2 = null;
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_POL_SYS_ID() });
			while (rst1.next()) {
				POL_FAC_YN = rst1.getString(1);
			}

			System.out.println("Policy No: " + POL_FAC_YN);

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY9;
			String CLAIM_DS_CODE = null;
			rst3 = handler.executeSelectStatement(sql_C3, connection,
					new Object[] { claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_SYS_ID() });
			while (rst3.next()) {
				CLAIM_DS_CODE = rst3.getString(1);
			}

			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY10;
			String M_TODO_LIST_STAT = null;
			rst2 = handler
					.executeSelectStatement(sql_C2, connection,
							new Object[] {
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_SYS_ID(), CLAIM_DS_CODE });
			while (rst2.next()) {
				M_TODO_LIST_STAT = rst2.getString(1);
			}

			Date CP_PAID_DT = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN().getCP_PAID_DT();
			System.out.println("CP_PAID_DT:::::::" + CP_PAID_DT);
			/*if (CP_PAID_DT == null) {
				throw new Exception("CP_PAID_DT");
			}*/
			String CP_CLM_PAID_STATUS = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN().getCP_CLM_PAID_STATUS();

			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("N")) {
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_PAID_DT_DIS(
						false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_FC_PAID_AMT_DIS(false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_LC_PAID_AMT_DIS(false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLM_PAID_STATUS_DIS(false);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLAIM_PAID_TO_DIS(false);
			} else {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_PAID_DT_DIS(
						true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_FC_PAID_AMT_DIS(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_LC_PAID_AMT_DIS(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLM_PAID_STATUS_DIS(true);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
						.setCP_CLAIM_PAID_TO_DIS(true);
			}

			if ((POL_FAC_YN == null ? "N" : POL_FAC_YN).equals("Y"))
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(false);
			else
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(true);

			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					&& (CP_CLM_PAID_STATUS == null ? "P" : CP_CLM_PAID_STATUS)
							.equals("A")
					&& !(M_TODO_LIST_STAT == null ? "" : M_TODO_LIST_STAT)
							.equals("1")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS().setDisabled(false);
			} else if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					&& (CP_CLM_PAID_STATUS == null ? "P" : CP_CLM_PAID_STATUS)
							.equals("A") && M_TODO_LIST_STAT == null) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
			} else {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			}

			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y"))
				claimAction.getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
			else
				claimAction.getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(true);
			if(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID() != null){

			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("R")
					|| (CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")) {
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_APPR_FLAG("Y");
				throw new Exception(Messages.getString(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"91453"));
			}
			}

			System.out.println("Approval Flag: " + CP_APPR_FLAG
					+ "  Claim Paid Status: " + CP_CLM_PAID_STATUS);

			System.out.println("Disabling fields!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst2);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<PT_IL_CLAIM_PAID> cpAccntPayCode(String code,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY11;
		if (code != null) {
			if (code.equals("*")) {
				code = "%";
			} else {
				code += "%";
			}
		}
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_PAID> claimPaidList = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection,
					new Object[] { code });
			claimPaidList = new ArrayList<PT_IL_CLAIM_PAID>();
			while (rst.next()) {
				PT_IL_CLAIM_PAID claimPaidBean = new PT_IL_CLAIM_PAID();
				claimPaidBean.setCP_ACCNT_PAY_CODE(rst.getString("CUST_CODE"));
				claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC(rst
						.getString("CUST_NAME"));
				claimPaidList.add(claimPaidBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return claimPaidList;
	}

	public int savePaidBean(Connection connection, PT_IL_CLAIM_PAID claimPaid)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		int updatedData = 0;
		try {
			updatedData = handler.executeInsert(claimPaid, connection);
			System.out.println("Record Saved!!!!!!!");
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (IllegalAccessException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			throw new Exception(e);
		} catch (InvocationTargetException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (NoSuchMethodException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (InstantiationException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		}
		return updatedData;
	}

	public int deleteRecord(Connection connection, PT_IL_CLAIM_PAID claimPaid)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		int deletedRecord = 0;
		try {
			deletedRecord = handler.executeDelete(claimPaid, connection);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (IllegalAccessException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (InvocationTargetException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		} catch (NoSuchMethodException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e1;
			}
			e.printStackTrace();
			throw new Exception(e);
		}
		return deletedRecord;
	}

	public void executeQuery(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY12;
		System.out.println(selectQuery);
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String CLAIM_NO = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_NO();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		System.out.println(CLAIM_NO);
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_PAID> claimPaidBeanList = null;
		PT_IL_CLAIM_PAID claimPaidBean = null;
		Double paidFcAmount = null;
		Double paidLcAmount = null;
		Double estimatedFcAmount = null;
		Double estimatedLcAmount = null;
		Double M_CP_FC_TOT_EST = null;
		Double M_CP_LC_TOT_EST = null;

		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		ResultSet rst4 = null;
		
		/*Added by Janani on 08.02.2018 for ZB Accnt.ppay_code desc*/
		ResultSet rst5 = null;
		ResultSet rst6 = null;
		String cust_name = null;
		
		String C1 = "SELECT COVER_DESC " +
				"FROM   PM_IL_COVER " + 
				"WHERE  COVER_CODE = ?";
		/*End*/
		
		
		try {
			
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_NO });
			claimPaidBeanList = new ArrayList<PT_IL_CLAIM_PAID>();
			while (rst.next()) {
				claimPaidBean = new PT_IL_CLAIM_PAID();
				claimPaidBean.setROWID(rst.getString(1));
				claimPaidBean.setCP_SYS_ID(rst.getLong("CP_SYS_ID"));
				claimPaidBean.setCP_CCD_SYS_ID(rst.getLong("CP_CCD_SYS_ID"));
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CCD_SYS_ID(
						rst.getLong("CP_CCD_SYS_ID"));
				claimPaidBean.setCP_CE_SYS_ID(rst.getLong("CP_CE_SYS_ID"));
				claimPaidBean.setCP_CLAIM_SYS_ID(rst.getLong("CP_CLAIM_SYS_ID"));
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CLAIM_SYS_ID(
						rst.getLong("CP_CLAIM_SYS_ID"));
				claimPaidBean.setCP_REF_SYS_ID(rst.getLong("CP_REF_SYS_ID"));
				String CCD_COVER_CODE = rst.getString("CCD_COVER_CODE");
				claimPaidBean.setUI_M_CCD_COVER_CODE(CCD_COVER_CODE);
				boolean M_COVER_MEDICAL_YN = isMedicalProduct(CCD_COVER_CODE,
						compositeAction);

				claimPaidBean.setCP_PAID_DT(rst.getDate("CP_PAID_DT"));
				claimPaidBean
						.setCP_SCHD_PYMT_DT(rst.getDate("CP_SCHD_PYMT_DT"));
				claimPaidBean.setCP_ACCNT_PAY_CODE(rst
						.getString("CP_ACCNT_PAY_CODE"));
				
				/*Added by Janani on 08.02.2018 for ZB Accnt.ppay_code desc*/
				Object[] cust_code = { claimPaidBean.getCP_ACCNT_PAY_CODE() };
				String sql_C9= PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY21;
				rst5 = handler.executeSelectStatement(sql_C9, connection, cust_code);
				while (rst5.next()) {
					cust_name =rst5.getString("CUST_NAME");
				}
				
				
				
				/*claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC(rst
						.getString("CP_ACCNT_PAY_CODE"));*/
				claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC(cust_name);
				
				/*End*/
				
				claimPaidBean.setUI_M_CP_CURR_CODE(rst
						.getString("CLAIM_CURR_CODE"));
				claimPaidBean
						.setCP_FC_PAID_AMT(rst.getDouble("CP_FC_PAID_AMT"));
				claimPaidBean
						.setCP_LC_PAID_AMT(rst.getDouble("CP_LC_PAID_AMT"));
				claimPaidBean.setCP_CLAIM_REJ_REASON(rst
						.getString("CP_CLAIM_REJ_REASON"));
				claimPaidBean.setCP_ACCNT_PAY_CODE(rst
						.getString("CP_ACCNT_PAY_CODE"));
				if (!M_COVER_MEDICAL_YN)
					claimPaidBean.setCP_CLAIM_PAID_TO(rst
							.getString("CP_CLAIM_PAID_TO"));
				else
					claimPaidBean.setCP_CLAIM_PAID_TO("A");
				claimPaidBean.setCP_SET_FLAG(rst.getString("CP_SET_FLAG"));
				claimPaidBean.setCP_CLM_PAID_STATUS(rst
						.getString("CP_CLM_PAID_STATUS"));
				claimPaidBean.setCP_APPR_FLAG(rst.getString("CP_APPR_FLAG"));
				claimPaidBean.setCP_FLEX_04(rst.getString("CP_FLEX_04"));
				claimPaidBean.setCP_FLEX_05(rst.getString("CP_FLEX_05"));
				claimPaidBean.setCP_FLEX_06(rst.getString("CP_FLEX_06"));
				
				/*added by raja on 10-06-2017 for ZBILQC-1728216 */

				claimPaidBean.setCP_FLEX_08(rst.getString("CP_FLEX_08"));
				/*Commented by Janani on  21.08.2017 for ZBILQC-1732254 */
				
				//claimPaidBean.setCP_FLEX_07(rst.getString("CP_FLEX_07"));
				
				/*End*/
				claimPaidBean.setCP_FLEX_09(rst.getString("CP_FLEX_09"));
				
				/*Added by Ameen as per Ajay sugg. to diaplay bank dtls fields on 30-11-2017*/
				claimPaidBean.setCP_FLEX_10(rst.getString("CP_FLEX_10"));
				claimPaidBean.setCP_FLEX_11(rst.getString("CP_FLEX_11"));
				if(claimPaidBean.getCP_FLEX_11()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement
							(sortCodeQry, CommonUtils.getConnection(),new Object[]{claimPaidBean.getCP_FLEX_08(),claimPaidBean.getCP_FLEX_11()});
					if(sortCodeRS.next()){
						claimPaidBean.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				claimPaidBean.setCP_FLEX_12(rst.getString("CP_FLEX_12"));
				claimPaidBean.setCP_FLEX_13(rst.getString("CP_FLEX_13"));
				/*End*/
				
				
				String query="select BANK_NAME from fm_bank where bank_code=?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{claimPaidBean.getCP_FLEX_08()});
				while(rs.next())
				{
					claimPaidBean.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
				}
				/*end*/
				// postQuery(claimPaidBean, compositeAction);
				
				/*Added by Janani on 08.02.2018 for ZB covercode desc*/
				rst6 = handler.executeSelectStatement(C1,connection,new Object[]{claimPaidBean.getUI_M_CCD_COVER_CODE()});
				if(rst6.next()){
					claimPaidBean.setUI_M_CCD_COVER_CODE_DESC(rst6.getString(1));
				}
				
				/*End*/
				
				
				/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
				claimPaidBean.setCP_PAYEE_NAME(rst.getString("CP_PAYEE_NAME"));
				claimPaidBean.setCP_PYMT_MTD(rst.getString("CP_PYMT_MTD"));
				/*End*/
				
				claimPaidBeanList.add(claimPaidBean);
			}	

			claimPaidAction.setPT_IL_CLAIM_PAID_BEAN_LIST(claimPaidBeanList);
			selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY13;

			rst1 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_NO });
			while (rst1.next()) {
				paidFcAmount = rst1.getDouble(2);
				paidLcAmount = rst1.getDouble(1);
			}

/*Commented by saritha on 10-01-2018 for unwanted code*/
			/*selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY14;
			rst2 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_NO });
			while (rst2.next()) {
				claimPaidBean = new PT_IL_CLAIM_PAID();
				
				claimPaidBean.setCP_SYS_ID(rst2.getLong("CP_SYS_ID"));
				claimPaidBean.setCP_CCD_SYS_ID(rst2.getLong("CP_CCD_SYS_ID"));
				claimPaidBean.setCP_CE_SYS_ID(rst2.getLong("CP_CE_SYS_ID"));
				claimPaidBean.setCP_CLAIM_SYS_ID(rst2
						.getLong("CP_CLAIM_SYS_ID"));
				claimPaidBean.setCP_REF_SYS_ID(rst2.getLong("CP_REF_SYS_ID"));
			}*/

			selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY15;

			rst3 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_NO });
			while (rst3.next()) {
				estimatedFcAmount = rst3.getDouble(2);
				estimatedLcAmount = rst3.getDouble(1);
			}
			
			/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
			selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY19;
			/*rst4 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_NO });*/
			
			rst4 = handler.executeSelectStatement(selectQuery, connection,
			new Object[] { claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID() });
			
			
			System.out.println("selectQuery       : "+selectQuery + CLAIM_NO );
			while (rst4.next()) {
				
				/*Modified by Janani on 08.09.2017 for ZBILQC-1723914*/
				
				//M_CP_FC_TOT_EST = Double.parseDouble(rst4.getString("CP_FC_PAID_AMT"));
				
				//M_CP_FC_TOT_EST = Double.parseDouble(CommonUtils.nvl(rst4.getString("CP_FC_PAID_AMT"), "0"));
				M_CP_LC_TOT_EST=Double.parseDouble(CommonUtils.nvl(rst4.getString(1), "0"));
				M_CP_FC_TOT_EST = Double.parseDouble(CommonUtils.nvl(rst4.getString(2), "0"));
				
				
				/*End*/
				
			}
			System.out.println("M_CP_FC_TOT_EST    :  "+M_CP_FC_TOT_EST);
			System.out.println("estimatedFcAmount  :  "+estimatedFcAmount );
			
			if(claimPaidBean!=null && estimatedFcAmount > 0){
			/*
			 * code commented by saritha on 31.1.2017 
			 * claimPaidBean.setUI_M_CP_FC_TOT_EST(estimatedFcAmount);
			claimPaidBean.setUI_M_CP_LC_TOT_EST(estimatedLcAmount);*/
				
				claimPaidBean.setUI_M_CP_FC_TOT_EST(M_CP_FC_TOT_EST);
				claimPaidBean.setUI_M_CP_LC_TOT_EST(M_CP_LC_TOT_EST);
				
			/*End*/
			System.out.println("claimPaidBean.setUI_M_CP_LC_TOT_EST  :  "+claimPaidBean.getUI_M_CP_LC_TOT_EST());
			claimPaidBean.setUI_M_CP_FC_TOT_PAID(paidFcAmount);
			claimPaidBean.setUI_M_CP_LC_TOT_PAID(paidLcAmount);
			/*
			 * 
			 * claimPaidBean.setUI_M_CP_FC_BALANCE(estimatedFcAmount
					- paidFcAmount);
			claimPaidBean.setUI_M_CP_LC_BALANCE(estimatedLcAmount
					- paidLcAmount);*/
			
			claimPaidBean.setUI_M_CP_FC_BALANCE(M_CP_FC_TOT_EST);
			claimPaidBean.setUI_M_CP_LC_BALANCE(M_CP_LC_TOT_EST);
			
			/*End*/
			}
			
			claimPaidAction.setPT_IL_CLAIM_PAID_BEAN_LIST(claimPaidBeanList);
			if (claimPaidBeanList.size() > 0) {
				PT_IL_CLAIM_PAID pt_il_claim_paid = claimPaidBeanList.get(0);
				// Set the FC & LC Values .
				
				/*pt_il_claim_paid.setCP_SYS_ID(claimPaidBean.getCP_SYS_ID());
				pt_il_claim_paid.setCP_CCD_SYS_ID(claimPaidBean
						.getCP_CCD_SYS_ID());
				pt_il_claim_paid.setCP_CE_SYS_ID(claimPaidBean
						.getCP_CE_SYS_ID());
				pt_il_claim_paid.setCP_CLAIM_SYS_ID(claimPaidBean
						.getCP_CLAIM_SYS_ID());
				pt_il_claim_paid.setCP_REF_SYS_ID(claimPaidBean
						.getCP_REF_SYS_ID());*/
				claimPaidAction.setPT_IL_CLAIM_PAID_BEAN(pt_il_claim_paid);
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setRowSelected(true);
			}
			else{
				claimPaidAction.setPT_IL_CLAIM_PAID_BEAN(new PT_IL_CLAIM_PAID());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean isMedicalProduct(String CCD_COVER_CODE,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		boolean isMedialCover = false;
		String sql_C1 = "SELECT COVER_MEDICAL_YN " + "FROM   PM_IL_COVER "
				+ "WHERE  COVER_CODE  = ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		String M_COVER_MEDICAL_YN = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CCD_COVER_CODE });
			while (rst.next()) {
				M_COVER_MEDICAL_YN = rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ((M_COVER_MEDICAL_YN == null ? "N" : M_COVER_MEDICAL_YN).equals("Y")) {
			isMedialCover = true;
		}
		return isMedialCover;
	}

	public void keyCommit(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		System.out.println("enters into keycommit in claim");
		
		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		CRUDHandler handler = new CRUDHandler();

		String M_DUMMY = null;
		Double M_LC_AMT = null;
		Double M_FC_AMT = null;
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY16;
		String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY17;
		
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rstbenfQuery = null;
		
		try {
			connection = CommonUtils.getConnection();
			new PILT007_PROCEDURE().L_CHECK_ESTAMT_PAIDAMT(compositeAction);
			PT_IL_CLAIM_PAID claimPaidBean = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN();
			Long CP_CE_SYS_ID = claimPaidBean.getCP_CE_SYS_ID();
			Long CP_CLAIM_SYS_ID = claimPaidBean.getCP_CLAIM_SYS_ID();
			rst = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CP_CE_SYS_ID, CP_CLAIM_SYS_ID });
			if (rst.next()) {
				M_DUMMY = rst.getString(1);
			}

			if ((M_DUMMY == null ? "N" : M_DUMMY).equals("X")) {
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				claimAction.getCOMP_UI_M_BUT_BENF_DTLS().setDisabled(false);
			}
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_SYS_ID();
			rst1 = handler.executeSelectStatement(sql_C3, connection,
					new Object[] { CLAIM_SYS_ID });
			if (rst1.next()) {
				M_LC_AMT = rst1.getDouble(1);
				M_FC_AMT = rst1.getDouble(2);
			}


			if ((M_LC_AMT == null ? 0.0 : M_LC_AMT) > 0) {

				/*Added by saritha on 09-01-2018 for ssp call id : ZBLIFE-1464092*/

				if(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO()!=null && "B".equalsIgnoreCase(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO()))
				{

					String benfQuery = "SELECT 'X' FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=?";
					Long CBEN_CP_SYS_ID =compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_CP_SYS_ID();
					Long CP_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();

					rstbenfQuery = new CRUDHandler().executeSelectStatement(benfQuery, CommonUtils.getConnection(),
							new Object[] { CBEN_CP_SYS_ID });
					if (!rstbenfQuery.next()) {

						System.out.println("CLAIM_SYS_ID in  keyCommit            "+CLAIM_SYS_ID);
						System.out.println("CLAIM_POL_SYS_ID in keyCommit             "+CLAIM_POL_SYS_ID);

						new PILT007_PROCEDURE().P_BENF_SETTL(CLAIM_SYS_ID ,CLAIM_POL_SYS_ID,CP_SYS_ID);

					}
				}
			}
		
			/*End*/
			
			/*Added by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
			
			new PILT007_PROCEDURE().P_CLM_BEN_STLMT(claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID(),
					                                claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID());
			
			/*End*/
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rstbenfQuery != null) {
				CommonUtils.closeCursor(rstbenfQuery);
				}
			} catch (Exception e) {
			}
		}
	}

	public String getProdDesc(String P_PROD_CODE) throws Exception {
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY18;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String PROD_DESC = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection,
					new Object[] { P_PROD_CODE });
			while (rst.next()) {
				PROD_DESC = rst.getString("PROD_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PROD_DESC;
	}

	public String claimPaidBeneficiary(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
	
		/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/

		String settlement_sts = null;

		/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
		
        //String query = "SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID,PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID = CP_SYS_ID AND CBEN_CLAIM_SYS_ID = ?";
        
        String query = "SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? AND CP_SYS_ID = ?";
        
        /*End*/
		
		PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		
		String status_flag = null;
		
		System.out.println("enters into claimPaidBeneficiary");

		/*End*/
		
		
		try {
			beneficiaryAction.setOnLoadFlag(false);
			beneficiaryAction
					.setPT_IL_CLAIM_BENEFICIARY_BEAN(new PT_IL_CLAIM_BENEFICIARY());
			beneficiaryAction
					.setPT_IL_CLAIM_BENEFICIARY_LIST(new ArrayList<PT_IL_CLAIM_BENEFICIARY>());
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			claimPaidAction.getErrorMap().remove("current");
			claimPaidAction.getWarningMap().remove("current");
			List<PT_IL_CLAIM_PAID> claimPaidList = claimPaidAction
					.getPT_IL_CLAIM_PAID_BEAN_LIST();
			List<Integer> selectedList = new ArrayList<Integer>();
			for (int i = 0; i < claimPaidList.size(); i++) {
				PT_IL_CLAIM_PAID claimPaidBean = claimPaidList.get(i);
				boolean selected = claimPaidBean.isSelected();
				// if(selected)
				if ("dataTableSelectedRow".equalsIgnoreCase(claimPaidBean
						.getRowSelected()))
					selectedList.add(i);
			}
			System.out.println(selectedList);
			if (selectedList.size() > 1 || selectedList.size() == 0) {
				claimPaidAction
						.getErrorMap()
						.put(
								"current",
								Messages
										.getString(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"pilt007_row_selected"));
				return null;
			} else if (selectedList.size() == 1) {
				PT_IL_CLAIM_PAID claimPaidBean = claimPaidList.get(selectedList
						.get(0));
				String M_CCD_COVER_CODE = claimPaidBean
						.getUI_M_CCD_COVER_CODE();
				boolean isMedical = isMedicalProduct(M_CCD_COVER_CODE,
						compositeAction);
				if (isMedical) {
					claimPaidAction.getWarningMap().put("current",
							"Medical Cover is paid to Assured");
					return null;
				}
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_SYS_ID(
						claimPaidBean.getCP_SYS_ID());
				claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().setCP_CE_SYS_ID(
						claimPaidBean.getCP_CE_SYS_ID());
				// claimPaidAction.setPT_IL_CLAIM_PAID_BEAN(claimPaidBean);
			}
			beneficiaryAction.setBlockFlag(true);
			compositeAction.setReturnString("claimToBePaid");
			
			
			/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/

			settlement_sts = compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getUI_M_CLAIM_ADDL_STATUS();

			System.out.println("settlement_sts       :"+settlement_sts);

			/*if(settlement_sts.equalsIgnoreCase("approved") || settlement_sts.equalsIgnoreCase("closed"))
			{
				System.out.println("settlement approved");

				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(true);
			}*/

            connection = CommonUtils.getConnection();
			
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
			
			/*ResultSet rst = handler.executeSelectStatement(query,
					connection, new Object[] { CLAIM_SYS_ID});*/
			
			ResultSet rst = handler.executeSelectStatement(query,
					connection, new Object[] {compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID(),
					                          compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID()});
			
			while(rst.next())
			{
			
				status_flag = rst.getString("CP_APPR_FLAG");
			
			}
			
			System.out.println("status_flag              "+status_flag);
			
			if(status_flag != null && (status_flag.equalsIgnoreCase("a") || status_flag.equalsIgnoreCase("r")) || settlement_sts.equalsIgnoreCase("closed") )
			{
				System.out.println("settlement approved");
				
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(true);
				
				/*Added by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_ADD().setDisabled(true);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_POST().setDisabled(true);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_DELETE().setDisabled(true);		
				
			}
			else
			{
				System.out.println("in else part ");
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(false);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_ADD().setDisabled(false);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_POST().setDisabled(false);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_DELETE().setDisabled(false);	
			}
			
			/*End*/	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return "benfDetails";
	}

	public void chkMICRCode(String micrCode) throws Exception{
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{micrCode});
			if(resultSet.next()){
				//return x
			}else{
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	public void fetchDetails(PILT007_COMPOSITE_ACTION compositeAction)throws Exception{
		Connection con =null;
		String c1="select POL_CONT_AD_ACC_NO, POL_MICR_CODE from PT_IL_CLAIM ,PT_IL_POLICY"+ 
" WHERE POL_SYS_ID = CLAIM_POL_SYS_ID"+ 
" AND CLAIM_SYS_ID =? ";
		CRUDHandler handler=new CRUDHandler();
		ResultSet rs=null;
		String M_ACC_NO=null;
		String M_MICR_CODE=null;
		try{
			PT_IL_CLAIM_PAID PT_IL_CLAIM_PAID_BEAN=compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN();
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(c1, con, new Object[]{PT_IL_CLAIM_PAID_BEAN.getCP_CLAIM_SYS_ID()});
		while(rs.next()){
			M_ACC_NO=rs.getString(1);
			M_MICR_CODE=rs.getString(2);
		}
		//PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_06(M_ACC_NO);
		PT_IL_CLAIM_PAID_BEAN.setCP_FLEX_05(M_MICR_CODE);
		
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
				
	}finally{
		CommonUtils.closeCursor(rs);
	}
	}
	
	public void partialSettlementValidation(PILT007_COMPOSITE_ACTION compositeAction)
			throws ProcedureException, Exception {
		
		String query="SELECT CLAIM_TYPE FROM PT_IL_CLAIM WHERE CLAIM_POL_NO=?";
		Connection con= null;
		ResultSet rs= null;
		CRUDHandler handler = new CRUDHandler();
		String M_TYPE=null;
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, con, new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
			if(rs.next())
			{
				M_TYPE=rs.getString(1);
			}
			if ("A".equalsIgnoreCase(M_TYPE)
					|| "O".equalsIgnoreCase(M_TYPE))

			{
				p9ilpk_claim.PRO_BEN_UPDATE(compositeAction
						.getPILT007_PT_IL_CLAIM_PAID_ACTION()
						.getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID(),
						compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION()
								.getPT_IL_CLAIM_PAID_BEAN().getCP_FC_PAID_AMT(),
						compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION()
								.getPT_IL_CLAIM_PAID_BEAN().getCP_LC_PAID_AMT());
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}

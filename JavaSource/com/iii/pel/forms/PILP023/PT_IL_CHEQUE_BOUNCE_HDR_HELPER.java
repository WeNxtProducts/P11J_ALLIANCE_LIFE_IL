package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PT_IL_CHEQUE_BOUNCE_HDR_HELPER extends CommonAction{

	public String pilp023_pt_il_cheque_bounce_hdr_post_query(String txnCode) {
		// Connection vembu_conn =
		// SwisSqlConnection.getInstance().getConnection();
		// Map<String, Object> sessionMap =
		// context.getExternalContext().getSessionMap();
		// PILP023_COMPOSITE_ACTION COMPOSITE_ACTION =
		// (PILP023_COMPOSITE_ACTION)sessionMap.get("PILP023_COMPOSITE_ACTION");
		// PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN =
		// COMPOSITE_ACTION.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		// PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = null;
		Connection connection = null;
		String sql_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		String desc = null;
		try {
			// final dbms_output dbms_output1=new dbms_output();
			// BOUNCE_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
			connection = CommonUtils.getConnection();
			// SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM
			// = 'IL_TXN_TYPE' AND LIV_CODE =
			// :PT_IL_CHEQUE_BOUNCE_HDR.CBH_TXN_TYPE
			sql_C1 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES"
					+ " WHERE  LIV_SYS_PARAM  = 'IL_TXN_TYPE'"
					+ " AND LIV_CODE  = ? ";
			ResultSet rs_C1 = null;
			// Statement
			// stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if (rs_C1 != null) {
				rs_C1.close();
			}
			// vembu_C1=stmt_C1.executeQuery(sql_C1);
			rs_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { txnCode });
			if (rs_C1.next()) {

				desc = rs_C1.getString("LIV_CODE_DESC");
			}
			rs_C1.close();
			// P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;

	}

	public void pilp023_pt_il_cheque_bounce_hdr_when_new_form_instance(
			FacesContext context) throws SQLException, Exception {
		// Connection vembu_conn =
		// SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		PILP023_COMPOSITE_ACTION COMPOSITE_ACTION = (PILP023_COMPOSITE_ACTION) sessionMap
				.get("PILP023_COMPOSITE_ACTION");
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = COMPOSITE_ACTION
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = COMPOSITE_ACTION
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION()
				.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		@SuppressWarnings("unused")
		Connection connection = null;
		try {
			// final dbms_output dbms_output1=new dbms_output();
			connection = CommonUtils.getConnection();
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_PREM_DTLS",ENABLED,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_DEP_REFUND_DTLS",ENABLED,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_LOAN_REPAY_DTLS",ENABLED,PROPERTY_FALSE);
			 */

			BOUNCER_ACTION.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
			BOUNCER_ACTION.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
			BOUNCER_ACTION.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pilp023_pt_il_cheque_bounce_hdr_when_new_record_instance(
			FacesContext context) throws SQLException, Exception {
		// Connection vembu_conn =
		// SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		PILP023_COMPOSITE_ACTION COMPOSITE_ACTION = (PILP023_COMPOSITE_ACTION) sessionMap
				.get("PILP023_COMPOSITE_ACTION");
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = COMPOSITE_ACTION
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = COMPOSITE_ACTION
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION()
				.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		@SuppressWarnings("unused")
		Connection connection = null;
		try {
			// final dbms_output dbms_output1=new dbms_output();
			connection = CommonUtils.getConnection();
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_LOAN_REPAY_DTLS",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_LOAN_REPAY_DTLS",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_PREM_DTLS",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_PREM_DTLS",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_DEP_REFUND_DTLS",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_DEP_REFUND_DTLS",NAVIGABLE,PROPERTY_TRUE);
			 */

			BOUNCER_ACTION.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS()
					.setDisabled(false);
			BOUNCER_ACTION.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS()
					.setDisabled(false);
			BOUNCER_ACTION.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(false);
			BOUNCER_ACTION.getCOMP_UI_M_BUT_DEP_REFUND_DTLS()
					.setDisabled(false);

			// :GLOBAL.M_CHECK_FLAG=="FALSE"
			if (BOUNCE_BEAN.isM_CHECK_FLAG()) {
				// :GLOBAL.M_CHECK_FLAG="TRUE";
				BOUNCE_BEAN.setM_CHECK_FLAG(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void pilp023_pt_il_cheque_bounce_hdr_m_but_prem_dtls_when_button_pressed() {/*
																						 * Connection
																						 * vembu_conn =
																						 * SwisSqlConnection.getInstance().getConnection();
																						 * try {
																						 * final
																						 * dbms_output
																						 * dbms_output1=new
																						 * dbms_output();
																						 * String
																						 * M_BOOLEAN=null;
																						 * M_BOOLEAN=GET_VIEW_PROPERTY.GET_VIEW_PROPERTY("PT_IL_PREM_COLL",VISIBLE);
																						 * if(M_BOOLEAN.equals(""+"FALSE")) {
																						 * SHOW_VIEW.SHOW_VIEW("PT_IL_PREM_COLL");
																						 * GO_ITEM.GO_ITEM("PT_IL_PREM_COLL.M_BUT_PREM_DTLS_BACK"); }
																						 * else {
																						 * HIDE_VIEW.HIDE_VIEW("PT_IL_PREM_COLL"); }
																						 * }catch(Exception
																						 * e) {
																						 * e.printStackTrace();
																						 * throw
																						 * e; }
																						 * finally {
																						 * if(vembu_conn !=
																						 * null) {
																						 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } }
																						 */
	}

	public void pilp023_pt_il_cheque_bounce_hdr_m_but_loan_repay_dtls_when_button_pressed() {/*
																								 * Connection
																								 * vembu_conn =
																								 * SwisSqlConnection.getInstance().getConnection();
																								 * try {
																								 * final
																								 * dbms_output
																								 * dbms_output1=new
																								 * dbms_output();
																								 * String
																								 * M_BOOLEAN=null;
																								 * M_BOOLEAN=GET_VIEW_PROPERTY.GET_VIEW_PROPERTY("PT_IL_LOAN_REPAYMENT",VISIBLE);
																								 * if(M_BOOLEAN.equals(""+"FALSE")) {
																								 * SHOW_VIEW.SHOW_VIEW("PT_IL_LOAN_REPAYMENT");
																								 * GO_ITEM.GO_ITEM("PT_IL_LOAN_REPAYMENT.M_BUT_LOAN_REPAY_DTLS_BACK"); }
																								 * else {
																								 * HIDE_VIEW.HIDE_VIEW("PT_IL_LOAN_REPAYMENT");
																								 * GO_ITEM.GO_ITEM("PT_IL_CHEQUE_BOUNCE_HDR.M_BUT_LOAN_REPAY_DTLS"); }
																								 * }catch(Exception
																								 * e) {
																								 * e.printStackTrace();
																								 * throw
																								 * e; }
																								 * finally {
																								 * if(vembu_conn !=
																								 * null) {
																								 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } }
																								 */
	}

	public void pilp023_pt_il_cheque_bounce_hdr_m_but_dep_refund_dtls_when_button_pressed() {/*
																								 * Connection
																								 * vembu_conn =
																								 * SwisSqlConnection.getInstance().getConnection();
																								 * try {
																								 * final
																								 * dbms_output
																								 * dbms_output1=new
																								 * dbms_output();
																								 * String
																								 * M_BOOLEAN=null;
																								 * M_BOOLEAN=GET_VIEW_PROPERTY.GET_VIEW_PROPERTY("PT_IL_DEPOSIT",VISIBLE);
																								 * if(M_BOOLEAN.equals(""+"FALSE")) {
																								 * SHOW_VIEW.SHOW_VIEW("PT_IL_DEPOSIT");
																								 * GO_ITEM.GO_ITEM("PT_IL_DEPOSIT.M_BUT_DEP_REFUND_DTLS_BACK"); }
																								 * else {
																								 * HIDE_VIEW.HIDE_VIEW("PT_IL_DEPOSIT"); }
																								 * }catch(Exception
																								 * e) {
																								 * e.printStackTrace();
																								 * throw
																								 * e; }
																								 * finally {
																								 * if(vembu_conn !=
																								 * null) {
																								 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } }
																								 */
	}

	public List<PT_IL_CHEQUE_BOUNCE_HDR> dep_txn_code_lov(String DEP_TXN_CODE) {
		if (DEP_TXN_CODE != null) {
			if (DEP_TXN_CODE.equals("*")) {
				DEP_TXN_CODE = "%";
			} else {
				DEP_TXN_CODE += "%";
			}
		}
		// SELECT DEP_DOC_NO FROM PT_IL_DEPOSIT WHERE DEP_TXN_CODE =
		// :DUMMY.M_DEP_TXN_CODE
		String query = "SELECT DEP_TXN_CODE FROM PT_IL_DEPOSIT" +
							" WHERE ROWID IN (SELECT MAX(ROWID)" +
								" FROM PT_IL_DEPOSIT GROUP BY DEP_TXN_CODE )" +
									" AND DEP_TXN_CODE LIKE NVL(?,DEP_TXN_CODE) ORDER BY 1 ASC";
		System.out.println("SELECT DEP_TXN_CODE FROM PT_IL_DEPOSIT" +
							" WHERE ROWID IN (SELECT MAX(ROWID)" +
								" FROM PT_IL_DEPOSIT GROUP BY DEP_TXN_CODE )" +
									" AND DEP_TXN_CODE IS NOT NULL AND DEP_TXN_CODE LIKE NVL(?,DEP_TXN_CODE)");
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CHEQUE_BOUNCE_HDR> chequeList = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
		try {
			connection = CommonUtils.getConnection();
			ResultSet resultSet = handler.executeSelectStatement(query,
					connection, new Object[]{DEP_TXN_CODE});
			PT_IL_CHEQUE_BOUNCE_HDR chequeBean = null;
			while (resultSet.next()) {
				chequeBean = new PT_IL_CHEQUE_BOUNCE_HDR();
				chequeBean.setUI_M_DEP_TXN_CODE(resultSet
						.getString("DEP_TXN_CODE"));
				chequeList.add(chequeBean);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chequeList;
	}

	public List<PT_IL_CHEQUE_BOUNCE_HDR> dep_Doc_No_LOV(String DEP_DOC_NO) {
		if (DEP_DOC_NO != null) {
			if (DEP_DOC_NO.equals("*")) {
				DEP_DOC_NO = "%";
			} else {
				DEP_DOC_NO += "%";
			}
		}
		String query = "SELECT DEP_DOC_NO FROM  PT_IL_DEPOSIT" +
						 " WHERE DEP_DOC_NO LIKE NVL(?,DEP_DOC_NO) AND ROWNUM<20 ORDER BY 1 ASC";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CHEQUE_BOUNCE_HDR> docNoList = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();

		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { DEP_DOC_NO });
			PT_IL_CHEQUE_BOUNCE_HDR hdrBean = null;

			while (rst.next()) {
				hdrBean = new PT_IL_CHEQUE_BOUNCE_HDR();
				hdrBean.setUI_M_DEP_DOC_NO(rst.getInt(1));
				docNoList.add(hdrBean);
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return docNoList;
	}
	
	public List<PT_IL_CHEQUE_BOUNCE_HDR> reason_code_LOV(String REASON_CODE)
	{
		System.out.println("--><--"+REASON_CODE);
		if (REASON_CODE != null) {
			if (REASON_CODE.equals("*")) {
				
				REASON_CODE = "%";
			} else {
				REASON_CODE += "%";
			}
		}
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES" +
							" WHERE PC_TYPE = 'REV_REASON'" +
								" AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE NVL(?,PC_CODE) AND ROWNUM<10 ORDER BY 1 ASC";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CHEQUE_BOUNCE_HDR> reasonList = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
		try
		{
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{REASON_CODE});
			PT_IL_CHEQUE_BOUNCE_HDR bounceBean = null;
			
			while(rst.next())
			{
				bounceBean = new PT_IL_CHEQUE_BOUNCE_HDR();
				bounceBean.setUI_M_CBH_REASON_CODE(rst.getString(1));
				bounceBean.setUI_M_REASON_CODE_DESC(rst.getString(2));
				reasonList.add(bounceBean);
				System.out.println("----------------------------------RECORD");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reasonList;
	}

	public void pilp023_dummy_m_cbh_reason_code_when_validate_item(
			PILP023_COMPOSITE_ACTION compositeAction) throws ProcedureException{
		
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = compositeAction
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = compositeAction
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION()
				.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		//String M_REASON_CODE_DESC = (String)BOUNCER_ACTION.getCOMP_UI_M_REASON_CODE_DESC().getSubmittedValue();
		//String M_REASON_CODE = (String)BOUNCER_ACTION.getCOMP_UI_M_CBH_REASON_CODE().getSubmittedValue();
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PILP023_PROCEDURE procedure = null;
		ResultSet rs_C1 = null;
		ResultSet rs_C2 = null;
		ResultSet rs_C3 = null;
		ResultSet rs_C4 = null;
		ResultSet rs_C4A = null;
		String M_DEP_TYPE = null;
		String M_PD_CHQ_NO = null;
		try {
			
			connection = CommonUtils.getConnection();
			String /** METADATA NOT FOUND ******** */
			M_DEP_SYS_ID = null;
			String /** METADATA NOT FOUND ******** */
			M_DPD_PAY_MODE = null;
			int M_PC_VALUE = 0;
			String sql_C1 = "SELECT DEP_SYS_ID FROM  PT_IL_DEPOSIT"
					+ "  WHERE  DEP_TXN_CODE  = ?"
					+ "  AND DEP_DOC_NO  = ?" + "  AND DEP_DOC_DT  = ? ";
			String sql_C2 = "SELECT DPD_PAY_MODE FROM PT_IL_DEPOSIT_PYMT_DTLS"
				+ "  WHERE  DPD_DEP_SYS_ID  = ?  ";
			String sql_C3 = "SELECT PC_VALUE FROM  PM_CODES"
				+ "  WHERE  PC_TYPE  = 'REV_REASON'"
				+ "  AND PC_CODE  = ? ";
			String sql_C4 = "SELECT PD_CHQ_NO "
					+ " FROM PT_IL_PYMT_DTLS "
					+ "WHERE PD_TXN_SYS_ID IN (SELECT DEP_SYS_ID FROM PT_IL_DEPOSIT "
					+ " WHERE DEP_TXN_CODE=?  AND DEP_DOC_NO=? "
					+ "AND DEP_DOC_DT=?)  "
					+ "AND PD_TXN_TYPE IN(	SELECT PD_TXN_TYPE   FROM   PT_IL_PYMT_DTLS "
					+ "WHERE  PD_TXN_SYS_ID IN (SELECT DEP_SYS_ID FROM PT_IL_DEPOSIT "
					+ "WHERE DEP_TXN_CODE=? AND DEP_DOC_NO=?   AND DEP_DOC_DT=? "
					+ "AND DEP_TYPE  = ? ) ) AND   PD_CHQ_NO IS NOT NULL";
			
			String C4B = "SELECT  DEP_TYPE FROM   PT_IL_DEPOSIT "
					+ "WHERE  DEP_TXN_CODE   = ? "
					+ " AND    DEP_DOC_NO     = ? "
					+ "AND		DEP_DOC_DT 		 = ?";
			
			/*
			 * BOUNCE_BEAN.setUI_M_CBH_REASON_CODE(M_REASON_CODE);
			 * BOUNCE_BEAN.setUI_M_REASON_CODE_DESC(M_REASON_CODE_DESC);
			 */
			if (BOUNCE_BEAN.getUI_M_CBH_REASON_CODE() != null) {
				procedure = new PILP023_PROCEDURE();
				ArrayList<String> descString = procedure.P_VAL_CODES_PROC("REV_REASON", BOUNCE_BEAN.getUI_M_CBH_REASON_CODE(), BOUNCE_BEAN.getUI_M_REASON_CODE_DESC(), "N", "E", null);
				if(descString!=null && descString.size()>0)
				{
					System.out.println("DESCRIPTION>>>>>>>>>"+descString.get(0));
					BOUNCE_BEAN.setUI_M_REASON_CODE_DESC(descString.get(0));
					BOUNCER_ACTION.getCOMP_UI_M_REASON_CODE_DESC().setSubmittedValue(descString.get(0));
				}
				
				// vembu_C1=stmt_C1.executeQuery(sql_C1);
				rs_C1 = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_DT() });
				if (rs_C1.next()) {
					M_DEP_SYS_ID = rs_C1.getString("DEP_SYS_ID");
				}
				
				rs_C2 = handler.executeSelectStatement(sql_C2, connection,new Object[]{M_DEP_SYS_ID});
				if (rs_C2.next()) {
					M_DPD_PAY_MODE = rs_C2.getString("DPD_PAY_MODE");
				}
				
				rs_C3 = handler.executeSelectStatement(sql_C3, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_CBH_REASON_CODE() });
				if (rs_C3.next()) {
					M_PC_VALUE = rs_C3.getInt("PC_VALUE");
				}
				
				if (M_DPD_PAY_MODE == ("L") || M_DPD_PAY_MODE == ("BC")
						|| M_DPD_PAY_MODE == ("C") || M_DPD_PAY_MODE == ("D")
						|| M_DPD_PAY_MODE == ("H")
						&& MigratingFunctions.nvl(M_PC_VALUE, 0) == 1) {
				
					BOUNCE_BEAN.setUI_M_CBH_REVERSAL_REF_NO(null);
					BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO()
							.setDisabled(false);
					BOUNCE_BEAN.setUI_M_CBH_REVERSAL_REF_NO(BOUNCE_BEAN
							.getUI_M_CBH_REVERSAL_REF_NO());
				} else {
				
					BOUNCE_BEAN.setUI_M_CBH_REVERSAL_REF_NO(null);
					BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO()
							.setDisabled(true);
				}
			}
			
			rs_C4A = handler.executeSelectStatement(C4B, connection,new Object[]{BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),BOUNCE_BEAN.getUI_M_DEP_DOC_DT()});
			if(rs_C4A.next()){
				M_DEP_TYPE = rs_C4A.getString(1);
			}
			
			rs_C4 = handler.executeSelectStatement(sql_C4, connection,new Object[]{BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
																				   BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
																				   BOUNCE_BEAN.getUI_M_DEP_DOC_DT(),
																				   BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
																				   BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
																				   BOUNCE_BEAN.getUI_M_DEP_DOC_DT(),
																				   M_DEP_TYPE});
			if(rs_C4.next()){
				M_PD_CHQ_NO = rs_C4.getString(1);
				BOUNCE_BEAN.setUI_M_CBH_REVERSAL_REF_NO(M_PD_CHQ_NO);
				BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO().setDisabled(true);
			}else{
				BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO().setDisabled(false);
			}
			
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
	        throw new ProcedureException(e.getMessage());
		}finally{
			try{
				CommonUtils.closeCursor(rs_C1);
				CommonUtils.closeCursor(rs_C2);
				CommonUtils.closeCursor(rs_C3);
				CommonUtils.closeCursor(rs_C4);
				CommonUtils.closeCursor(rs_C4A);
			}catch(Exception exception){}
		}

	}

	public void pilp023_dummy_m_dep_txn_code_when_validate_item(PILP023_COMPOSITE_ACTION compositeAction) throws Exception {
		

		String M_DEP_TXN_CODE = (String) compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getCOMP_UI_M_DEP_TXN_CODE().getSubmittedValue();
		PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN(); 
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_TXN_CODE(M_DEP_TXN_CODE);
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs_C1 = null;
		try {
			connection = CommonUtils.getConnection();
			double M_TEMP = -1;
			String sql_C1 = "SELECT 1 FROM  PT_IL_DEPOSIT  WHERE  DEP_TXN_CODE  = ? ";
			
			if (PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE() != null) {
				
				rs_C1 = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE() });
				if (rs_C1.next()) {
					M_TEMP = rs_C1.getDouble(1);
				}else{
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "91342"));
				}
				
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(rs_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 */
	public void pilp023_dummy_m_dep_doc_no_when_validate_item(PILP023_COMPOSITE_ACTION compositeAction) throws Exception  {
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = compositeAction
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = compositeAction
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION()
				.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		if(BOUNCER_ACTION.getCOMP_UI_M_DEP_DOC_NO()
					.getSubmittedValue() != null){
		Integer DEP_DOC_NO = 
			Integer.parseInt((String)BOUNCER_ACTION.getCOMP_UI_M_DEP_DOC_NO()
					.getSubmittedValue());
		System.out.println("DEP_DOC_NO ==>>" + DEP_DOC_NO);
		BOUNCE_BEAN.setUI_M_DEP_DOC_NO(DEP_DOC_NO);}
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs_C2A = null;
		ResultSet rs_C1 = null;
		ResultSet vembu_C2 = null;
		ResultSet vembu_C3 = null;
		ResultSet rs_C4 = null;
		ResultSet rs_C5 = null;
		ResultSet rs_C6 = null;
		/*Added by Ameen on 13-06-2017 for ZBILQC-1720414*/
		ResultSet rs_recDate = null;
		/*End*/


		try {
			
			connection = CommonUtils.getConnection();
			double M_TEMP = -1;
			String M_DUMMY = null;
			String M_REVERSAL_FLAG = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_REASON_CODE = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_REV_REMARKS = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_PDC_FLAG = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_REF_NO = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_SYS_ID = null;
			String /** METADATA NOT FOUND ******** */
			M_DPD_PAY_MODE = null;
			int M_PC_VALUE = 0;
			
			String sql_C1 = "SELECT 1 FROM  PT_IL_DEPOSIT  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ? ";
			String sql_C2A = "SELECT DISTINCT DEP_SYS_ID FROM  PT_IL_DEPOSIT"
				+ "  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ? ";
			String sql_C2 = "SELECT    NVL(DEP_REC_REV_YN, 'N'),    DEP_REASON_CODE,    DEP_REV_REMARKS FROM  PT_IL_DEPOSIT  WHERE  DEP_SYS_ID  = ? ";
			String sql_C3 = "SELECT DEP_PDC_FLAG FROM  PT_IL_DEPOSIT  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ?  AND DEP_ACNT_YEAR  = ? ";
			String sql_C4 = "SELECT DEP_SYS_ID FROM  PT_IL_DEPOSIT"
				+ "  WHERE  DEP_TXN_CODE  = ? AND DEP_DOC_NO  = ? ";
			String sql_C5 = "SELECT DPD_PAY_MODE FROM  PT_IL_DEPOSIT_PYMT_DTLS"
				+ "  WHERE  DPD_DEP_SYS_ID  = ?  ";
			String sql_C6 = "SELECT PC_VALUE FROM  PM_CODES"
				+ "  WHERE  PC_TYPE  = 'REV_REASON' AND PC_CODE  = ? ";
			
			if (BOUNCE_BEAN.getUI_M_DEP_TXN_CODE() != null
					&& BOUNCE_BEAN.getUI_M_DEP_DOC_NO() != null) {
				
				System.out.println("TXN CODE:::"+BOUNCE_BEAN.getUI_M_DEP_TXN_CODE());
				System.out.println("DOC NUM::"+BOUNCE_BEAN.getUI_M_DEP_DOC_NO());
				
				rs_C1 = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_NO() });
				if (rs_C1.next()) {
					M_TEMP = rs_C1.getDouble(1);
				}else{
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "91343"));
					}
				
				if (BOUNCE_BEAN.getUI_M_CBH_REASON_CODE() != null) {
					if (rs_C4 != null) {
						rs_C4.close();
					}
					
					rs_C4 = handler.executeSelectStatement(sql_C4, connection,
							new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
									BOUNCE_BEAN.getUI_M_DEP_DOC_NO() });
					if (rs_C4.next()) {
						M_DEP_SYS_ID = rs_C4.getString(1);
					}
					rs_C5 = handler.executeSelectStatement(sql_C5, connection,new Object[]{M_DEP_SYS_ID});
					if (rs_C5.next()) {
						M_DPD_PAY_MODE = rs_C5.getString(1);
					}
					rs_C6 = handler.executeSelectStatement(sql_C6, connection,
							new Object[] { BOUNCE_BEAN
									.getUI_M_CBH_REASON_CODE() });
					if (rs_C6.next()) {
						M_PC_VALUE = rs_C6.getInt(1);
					}
					rs_C6.close();
					if (M_DPD_PAY_MODE == ("L") || M_DPD_PAY_MODE == ("BC")
							|| M_DPD_PAY_MODE == ("C")
							|| M_DPD_PAY_MODE == ("D")
							|| M_DPD_PAY_MODE == ("H")
							&& MigratingFunctions.nvl(M_PC_VALUE, 0) == 1) {
						// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REVERSAL_REF_NO",REQUIRED,PROPERTY_TRUE);
						BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO()
								.setDisabled(false);
					} else {
						// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REVERSAL_REF_NO",REQUIRED,PROPERTY_FALSE);
						BOUNCER_ACTION.getCOMP_UI_M_CBH_REVERSAL_REF_NO()
								.setDisabled(true);
					}
				}
			}
			
			/*Added by Ameen on 13-06-2017 for ZBILQC-1720414*/
			/*if(BOUNCE_BEAN.getUI_M_DEP_DOC_DT() == null){
			String recDateQry = "SELECT DEP_DOC_DT FROM PT_IL_DEPOSIT WHERE DEP_TXN_CODE = ? AND DEP_DOC_NO = ? AND NVL(DEP_REC_REV_YN,'N') <> 'Y'";
			rs_recDate = handler.executeSelectStatement(recDateQry, connection, new Object[]{BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),BOUNCE_BEAN.getUI_M_DEP_DOC_NO()});
			if(rs_recDate.next()){
				BOUNCE_BEAN.setUI_M_DEP_DOC_DT(rs_recDate.getDate("DEP_DOC_DT"));
			}
			}*/
			/*End*/
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rs_C2A);
				CommonUtils.closeCursor(rs_C1);
				CommonUtils.closeCursor(vembu_C2);
				CommonUtils.closeCursor(vembu_C3);
				CommonUtils.closeCursor(rs_C4);
				CommonUtils.closeCursor(rs_C5);
				CommonUtils.closeCursor(rs_C6);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

	public void pilp023_dummy_m_dep_doc_dt_when_validate_item(PILP023_COMPOSITE_ACTION compositeAction,Long depsys_id) throws Exception {
		System.out.println("##########################");
		
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = compositeAction
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = BOUNCER_ACTION
				.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		PILP023_PROCEDURE procedure = null;
		ResultSet rs_C1 = null;
		ResultSet rs_C2A = null;
		ResultSet rs_C2 = null;
		ResultSet rs_C3 = null;
		ResultSet rs_C4 = null;
		ResultSet rs_C5 = null;
		ResultSet rs_C6 = null;
		try {
			
			// final dbms_output dbms_output1=new dbms_output();
			connection = CommonUtils.getConnection();
			String stringDt = new SimpleDateFormat("dd-MMM-yyyy").format(commonUtils.getCurrentDate());
			
			double M_TEMP = -1;
			String M_DUMMY_PROP = null;
			String M_DUMMY_POL = null;
			String M_REVERSAL_FLAG = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_REASON_CODE = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_REV_REMARKS = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_PDC_FLAG = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_PROP_NO = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_POL_NO = null;
			String /** METADATA NOT FOUND ******** */
			M_DEP_TYPE = null;
			String M_DEP_REF_NO = null;
			String sql_C1 = "SELECT 1 FROM  PT_IL_DEPOSIT"
					+ "  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ?"
					+ "  AND DEP_DOC_DT  = ?";
			String sql_C2A = "SELECT DISTINCT DEP_SYS_ID FROM  PT_IL_DEPOSIT"
				+ "  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ?"
				+ "  AND DEP_DOC_DT  = ? ";
			String sql_C2 = "SELECT    NVL(DEP_REC_REV_YN, 'N'), DEP_REASON_CODE,"
				+ " DEP_REV_REMARKS FROM  PT_IL_DEPOSIT"
				+ " WHERE  DEP_SYS_ID  = ? ";
			String sql_C3 = "SELECT DEP_PDC_FLAG FROM  PT_IL_DEPOSIT"
				+ "  WHERE  DEP_TXN_CODE  = ? AND DEP_DOC_NO = ?"
				+ "  AND DEP_ACNT_YEAR  = ? ";
			String sql_C4 = "SELECT DEP_REF_NO, DEP_TYPE FROM PT_IL_DEPOSIT"
				+ "  WHERE  DEP_TXN_CODE  = ?  AND DEP_DOC_NO  = ?"
				+ "  AND DEP_DOC_DT  = ? ";
			String sql_C5 = "SELECT 'X' FROM  PT_IL_DEPOSIT A"
				+ "  WHERE  NOT  EXISTS ( SELECT 'X'  FROM  PT_IL_DEPOSIT_PYMT_DTLS B"
				+ "  WHERE  A.DEP_SYS_ID  = B.DPD_DEP_SYS_ID"
				+ "  AND NVL(DPD_CHQ_REVERSED, 'N')  = 'Y'  )"
				+ "  AND DEP_REF_NO  = ? "
				+ "   AND NVL(DEP_REC_REV_YN, 'N')  = 'N'"
				+ "  AND   EXISTS  ( SELECT 'X'  FROM  PT_IL_DEPOSIT_PYMT_DTLS C"
				+ "  WHERE  A.DEP_SYS_ID  = C.DPD_DEP_SYS_ID"
				+ "  AND NVL(DPD_CHQ_REVERSED, 'N')  = 'N'"
				+ "  GROUP BY  C.DPD_DEP_SYS_ID"
				+ "  HAVING NVL(SUM(NVL(DPD_LC_UTIL_AMT, 0)), 0)  = 0 )"
				+ "  UNION ALL  SELECT 'X' FROM  PT_IL_DEPOSIT A"
				+ "  WHERE  NOT   EXISTS  ( SELECT 'X'  FROM  PT_IL_DEPOSIT_PYMT_DTLS B"
				+ "  WHERE  A.DEP_SYS_ID  = B.DPD_DEP_SYS_ID"
				+ "  AND NVL(DPD_CHQ_REVERSED, 'N')  = 'Y'  )"
				+ "  AND DEP_REF_NO  = ? " 
				+ "  AND NVL(DEP_REC_REV_YN, 'N')  = 'N'"
				+ "  AND A.DEP_SYS_ID  IN  ( SELECT MAX(DEP_SYS_ID)"
				+ "  FROM  PT_IL_DEPOSIT C"
				+ "  WHERE  NVL(DEP_REC_REV_YN, 'N')  = 'N'"
				+ "  AND C.DEP_SYS_ID  IN ( SELECT DPD_DEP_SYS_ID"
				+ "  FROM  PT_IL_DEPOSIT_PYMT_DTLS"
				+ "  WHERE  NVL(DPD_CHQ_REVERSED, 'N')  = 'N'"
				+ "  AND DPD_DEP_REF_NO  = ? "
				+ "  GROUP BY  DPD_DEP_SYS_ID"
				+ "  HAVING NVL(SUM(NVL(DPD_LC_UTIL_AMT, 0)), 0)  > 0 )"
				+ "  GROUP BY  DEP_REF_NO ) ";
	
			
			
			System.out.println("SQL_C5"+sql_C5);
			
			String sql_C6 = "SELECT POL_NO FROM PT_IL_POLICY"
					+ "  WHERE  POL_PROP_NO  = " + M_DEP_PROP_NO + " ";
			System.out.println(BOUNCE_BEAN.getUI_M_DEP_TXN_CODE() + "      "
					+ BOUNCE_BEAN.getUI_M_DEP_DOC_NO() + "     "
					+ BOUNCE_BEAN.getUI_M_DEP_DOC_DT());
			if (BOUNCE_BEAN.getUI_M_DEP_TXN_CODE() != null
					&& BOUNCE_BEAN.getUI_M_DEP_DOC_NO() != null
					&& BOUNCE_BEAN.getUI_M_DEP_DOC_DT() != null) {
				System.out.println("I M IN VALIDATE");
				
				rs_C1 = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_DT() });
				if (rs_C1.next()) {
					M_TEMP = rs_C1.getDouble(1);
				}else{
					
				}
				if (rs_C1.isAfterLast() || rs_C1.isBeforeFirst()) {
					System.out.println("<<<<<<INSIDE IF BUDDY>>>>>>");
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "91343"));
					
				} else {
						System.out.println("CURRENT DATE::::"+stringDt);
						ArrayList<String> rsList = F_VAL_OPCL("001", stringDt, "E", BOUNCE_BEAN.getUI_M_ACNT_YEAR());
						System.out.println("??????????????????????????"+rsList);
						if(rsList != null && rsList.size()>0){
							BOUNCE_BEAN.setUI_M_ACNT_YEAR(rsList.get(0));
						}
				}
				
				Double M_DEP_SYS_ID = null;
				

				Date docDate = BOUNCE_BEAN.getUI_M_DEP_DOC_DT();
				SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
				String M_DEP_DOC_DT = df.format(docDate);
				System.out.println(M_DEP_DOC_DT);
				rs_C2A = handler
						.executeSelectStatement(sql_C2A, connection,
								new Object[] {
										BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
										BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
										M_DEP_DOC_DT });
				if (rs_C2A.next()) {
					M_DEP_SYS_ID = rs_C2A.getDouble(1);
				}
				
				BOUNCE_BEAN.setUI_M_DEP_SYS_ID(M_DEP_SYS_ID);
				BOUNCE_BEAN.setUI_M_REVERSAL_FLAG("N");
				
				if( BOUNCE_BEAN.getUI_M_DEP_SYS_ID() != null){
				rs_C2 = handler.executeSelectStatement(sql_C2, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_SYS_ID() });
			
				if (rs_C2.next()) 
				{
					M_REVERSAL_FLAG = rs_C2.getString(1);
					M_DEP_REASON_CODE = rs_C2.getString("DEP_REASON_CODE");
					M_DEP_REV_REMARKS = rs_C2.getString("DEP_REV_REMARKS");
				}
				
				
				if ("Y".equalsIgnoreCase(M_REVERSAL_FLAG)) {

					
					BOUNCE_BEAN.setUI_M_CBH_REASON_CODE(BOUNCE_BEAN
							.getUI_M_DEP_REASON_CODE());
					if (BOUNCE_BEAN.getUI_M_CBH_REASON_CODE() != null) {
						procedure = new PILP023_PROCEDURE();
						ArrayList<String> stringVal = procedure.P_VAL_CODES_PROC("REV_REASON",BOUNCE_BEAN.getUI_M_DEP_REASON_CODE(), BOUNCE_BEAN.getUI_M_REASON_CODE_DESC(), "N", "E", null);
						if(stringVal!=null && stringVal.size()>0)
						{
							BOUNCE_BEAN.setUI_M_DEP_REASON_CODE(stringVal.get(0));
						}
					}
					
					BOUNCE_BEAN.setUI_M_CBH_REMARKS(BOUNCE_BEAN
							.getUI_M_DEP_REV_REMARKS());
					String[] msg = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error3")};
                	throw new Exception(Messages.getString(
    						"com.iii.premia.common.errorUtil.PELErrorMessages", "3206", msg));
					} 
				
				else {
					if(BOUNCE_BEAN.getUI_M_DEP_SYS_ID()!=null)
					{
						procedure = new PILP023_PROCEDURE();
					ArrayList<String> stringTran =	procedure.INS_AFFECTED_TRANS_DTLS(String.valueOf(depsys_id/*BOUNCE_BEAN.getUI_M_DEP_SYS_ID()*/));
					if(stringTran != null && stringTran.size()>0)
					{
						BOUNCE_BEAN.setUI_M_DEP_SYS_ID( Double.parseDouble(stringTran.get(0)));
					}
					}
					}
				}
				
				
				rs_C3 = handler.executeSelectStatement(sql_C3, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
								BOUNCE_BEAN.getUI_M_ACNT_YEAR()});
				if (rs_C3.next()) {
					M_DEP_PDC_FLAG = rs_C3.getString(1);
				}
				if (MigratingFunctions.nvl(M_DEP_PDC_FLAG, "N") == "Y") {
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "91401"));
				}
				
				rs_C4 = handler.executeSelectStatement(sql_C4, connection,
						new Object[] { BOUNCE_BEAN.getUI_M_DEP_TXN_CODE(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_NO(),
								BOUNCE_BEAN.getUI_M_DEP_DOC_DT() });
				if (rs_C4.next()) {
					M_DEP_PROP_NO = rs_C4.getString(1);
					M_DEP_TYPE = rs_C4.getString(2);
				}
				if (M_DEP_PROP_NO != null) {
					M_DEP_REF_NO = M_DEP_PROP_NO;
					rs_C5 = handler.executeSelectStatement(sql_C5, connection,new Object[]{M_DEP_REF_NO,M_DEP_REF_NO,M_DEP_REF_NO});
					if (rs_C5.next()) {
						M_DUMMY_PROP = rs_C5.getString(1);
					}
					if (M_DEP_TYPE == "P") {
						if (MigratingFunctions.nvl(M_DUMMY_PROP, "Y") != "X") {
							throw new Exception(Messages.getString(
									"com.iii.premia.common.errorUtil.PELErrorMessages",
									"3206",new Object[]{"Receipt is not allowed to reverse..."}));
						}
					} else if (M_DEP_TYPE == "Q") {
						
						M_DEP_REF_NO = M_DEP_PROP_NO;
						rs_C5 = handler.executeSelectStatement(sql_C5,
								connection);
						if (rs_C5.next()) {
							M_DUMMY_PROP = rs_C5.getString(1);
						}
						if (MigratingFunctions.nvl(M_DUMMY_PROP, "Y") != "X") {
							throw new Exception(Messages.getString(
									"com.iii.premia.common.errorUtil.PELErrorMessages",
									"3206",new Object[]{"Receipt is not allowed to reverse..."}));
							
						}
						
						rs_C6 = handler.executeSelectStatement(sql_C6,
								connection);
						if (rs_C6.next()) {
							M_DEP_POL_NO = rs_C6.getString(1);
						}
						
						M_DEP_REF_NO = M_DEP_POL_NO;
						rs_C5 = handler.executeSelectStatement(sql_C5,
								connection);
						if (rs_C5.next()) {
							M_DUMMY_POL = rs_C5.getString(1);
						}
						if (MigratingFunctions.nvl(M_DUMMY_POL, "Y") == "X") {
							throw new Exception(Messages.getString(
									"com.iii.premia.common.errorUtil.PELErrorMessages",
									"3206",new Object[]{"Receipt is not allowed to reverse..."}));
						
						}
					}
					
				}
				
			}
		
			HtmlCommandButton cb = new HtmlCommandButton();
			cb.setDisabled(false);
			BOUNCER_ACTION.getCOMP_UI_M_CBH_REASON_CODE().setDisabled(false);
			BOUNCER_ACTION.setCOMP_UI_M_BUT_LOV_REASON_CODE(cb);
			BOUNCER_ACTION.getCOMP_UI_M_CBH_REMARKS().setDisabled(false);
			BOUNCER_ACTION.setCOMP_UI_M_EDIT_REMARKS(cb);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try{
				CommonUtils.closeCursor(rs_C1);
				CommonUtils.closeCursor(rs_C2A);
				CommonUtils.closeCursor(rs_C2);
				CommonUtils.closeCursor(rs_C3);
				CommonUtils.closeCursor(rs_C4);
				CommonUtils.closeCursor(rs_C5);
				CommonUtils.closeCursor(rs_C6);
				
			}catch(Exception exception){}
		}

	}

	// [ BugId:FixPREMIAGDC-266176 MMuthu 02-Jan-2009 populating backend error to gui
	public ArrayList<String> F_VAL_OPCL(String P_COMP_CODE, String P_DT,
			String P_ERR_FLAG, String P_ACNT_YEAR) {
		Connection connection = null;
		ArrayList<String> returnList = new ArrayList<String>();
		try{
		connection = CommonUtils.getConnection();
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_COMP_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING",
				"IN OUT", P_ACNT_YEAR);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,"P9ILPK_ACNT_PROC.F_VAL_OPCL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap();
			PILP023_COMPOSITE_ACTION COMPOSITE_ACTION = (PILP023_COMPOSITE_ACTION)sessionMap 
			.get("PILP023_COMPOSITE_ACTION");
			PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = COMPOSITE_ACTION
			.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), 
					"PT_IL_CHEQUE_BOUNCE_HDR", BOUNCER_ACTION.getWarningMap());
		}
		return returnList;
	}
//	BugId:FixPREMIAGDC-266176 MMuthu 02-Jan-2009 populating backend error to gui ]
	public void pilp023_dummy_m_but_reverse_when_button_pressed(PILP023_COMPOSITE_ACTION compositeAction) throws Exception, ValidatorException
    {
		System.out.println("Reverse Completed Successfully");
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION BOUNCER_ACTION = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = BOUNCER_ACTION.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		
		PT_IL_PYMT_DTLS pymtBean = compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PILP023_PROCEDURE procedure = null;
		ResultSet rs_C1A=null;
		ResultSet rs_C1=null;
		ResultSet rs_C2=null;
		ResultSet rs_C2A=null;
		ResultSet rs_C3=null;
		ResultSet rs_C4=null;
		ResultSet rs_C5=null;
		ResultSet rs_C6=null;
		ResultSet rs_C7=null;
		ResultSet rs_C8=null;
		ResultSet rs_C9=null;
		ResultSet rs_C10=null;
		ResultSet rs_C11=null;
		ResultSet rs_C12=null;
		ResultSet rs_C13=null;
		ResultSet rs_C14=null;
       
//            final dbms_output dbms_output1=new dbms_output();
        	try {
				connection = CommonUtils.getConnection();
				String  /** METADATA NOT FOUND *********/ M_PD_DPD_REF_ID=null;
				Double  /** METADATA NOT FOUND *********/ M_PD_SYS_ID=null;
				Double  /** METADATA NOT FOUND *********/ M_PD_TXN_SYS_ID=null;
				String  /** METADATA NOT FOUND *********/ M_PD_TXN_TYPE=null;
				String  /** METADATA NOT FOUND *********/ M_PD_CHQ_NO=null;
				String  /** METADATA NOT FOUND *********/ M_PD_BANK_CODE=null;
				String  /** METADATA NOT FOUND *********/ M_CONT_CODE=null;
				Double  /** METADATA NOT FOUND *********/ M_POL_SYS_ID=null;
				Double  /** METADATA NOT FOUND *********/ M_LOAN_SYS_ID=null;
				double M_COUNT=-1;
				String M_REVERSAL_FLAG=null;
				String  /** METADATA NOT FOUND *********/ M_POL_STATUS=null;
				String  /** METADATA NOT FOUND *********/ M_POL_APPRV_STATUS=null;
				String  /** METADATA NOT FOUND *********/ M_DEP_REF_NO=null;
				String M_DEP_PROD_CODE = null;
				
				String sql_C1A="SELECT PD_DPD_REF_ID, PD_SYS_ID, PD_TXN_SYS_ID," +
				        		" PD_TXN_TYPE, PD_CHQ_NO, PD_BANK_NAME FROM" +
				        		" PT_IL_PYMT_DTLS, PT_IL_DEPOSIT" +
				        		" WHERE  PD_TXN_TYPE  IN ( 'PD'  , 'QD'  )" +
				        		" AND PD_TXN_SYS_ID  = DEP_SYS_ID" +
				        		" AND PD_TXN_SYS_ID  = ? ";
			
				
				
				double P_TXN_SYS_ID=-1;
				/*Commented and modified by senthilnathan for orient on 04.08.2020
				 *  issue desc: pol_cont_code is getting invalid contractor code*/
				/*String sql_C1="SELECT POL_CONT_CODE, POL_STATUS, POL_APPRV_STATUS" +
								 " FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";*/
				String sql_C1="SELECT POL_CONT_CODE, POL_STATUS, POL_APPRV_STATUS" +
						 " FROM PT_IL_POLICY WHERE POL_NO = ? ";
				/*End*/
				String sql_C2="SELECT DEP_CONT_CODE, DEP_REF_NO" +
								 " FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID  = ? ";
				String sql_C2A="SELECT POL_STATUS, POL_APPRV_STATUS" +
								" FROM PT_IL_POLICY WHERE POL_NO = ? " +
								 " AND POL_DS_TYPE  = '2' UNION" +
								  " SELECT  POL_STATUS, POL_APPRV_STATUS" +
								   " FROM  PT_IL_POLICY" +
								    " WHERE  POL_NO = ? " +
								     " AND POL_DS_TYPE  = '1'   ";
				String sql_C3="SELECT PC_POL_SYS_ID FROM PT_IL_PREM_COLL" +
								 " WHERE PC_SYS_ID = ? ";
				String sql_C4="SELECT LR_LOAN_SYS_ID FROM PT_IL_LOAN_REPAYMENT" +
								 " WHERE LR_SYS_ID = ? ";
				String sql_C5="SELECT LOAN_POL_SYS_ID FROM PT_IL_LOAN" +
						 		 " WHERE LOAN_SYS_ID = ? ";
				String sql_C6="SELECT DISTINCT CBH_REVERSE_YN" +
								 " FROM PT_IL_CHEQUE_BOUNCE_HDR" +
									" WHERE  CBH_DEP_SYS_ID = ? ";
				String  /** METADATA NOT FOUND *********/ M_DEP_REF_NO1=null;
				String sql_C7="SELECT DEP_PDC_FLAG, DEP_TXN_CODE, DEP_DOC_NO," +
								 " DEP_CHRG_TXN_CODE, DEP_CHRG_DOC_NO, DEP_REF_NO" +
									" FROM  PT_IL_DEPOSIT" +
										" WHERE  DEP_SYS_ID = ? ";
				String  /** METADATA NOT FOUND *********/ M_DEP_PDC_FLAG=null;
				String  /** METADATA NOT FOUND *********/ M_DEP_TXN_CODE=null;
				String  /** METADATA NOT FOUND *********/ M_DEP_DOC_NO=null;
				String  /** METADATA NOT FOUND *********/ M_DEP_CHRG_TXN_CODE=null;
				String  /** METADATA NOT FOUND *********/ M_DEP_CHRG_DOC_NO=null;
				String  /** METADATA NOT FOUND *********/ M_POL_DS_TYPE=null;
				String  /** METADATA NOT FOUND *********/ M_POL_STATUS1=null;
				String  /** METADATA NOT FOUND *********/ M_POL_CONVERT_YN=null;
				String  /** METADATA NOT FOUND *********/ M_POL_DS_CODE1=null;
				String  /** METADATA NOT FOUND *********/ M_POL_SYS_ID1=null;
				String  /** METADATA NOT FOUND *********/ M_DS_POST_BO=null;
				String sql_C8="SELECT POL_DS_TYPE, POL_STATUS," +
								" POL_CONVERT_YN, POL_DS_CODE, POL_SYS_ID" +
									" FROM PT_IL_POLICY A" +
										" WHERE  A.POL_NO = ?  " +
				            				" AND (A.POL_DS_TYPE  = '2'  " +
				            				" OR (A.POL_DS_TYPE  = '1' " +
				            				" AND A.POL_END_NO_IDX  IN  (" +
				            				" SELECT MAX(B.POL_END_NO_IDX)" +
				            				" FROM  PT_IL_POLICY B " +
				            				" WHERE  B.POL_NO  = A.POL_NO  ))) ";
				
				String sql_C9="SELECT POL_STATUS FROM PT_IL_POLICY" +
								 " WHERE  POL_PROP_NO = ?  ";
				
				String sql_C10="SELECT DS_POST_BO FROM PM_IL_DOC_SETUP" +
								" WHERE DS_TYPE = ? " +
								 " AND DS_CODE  = ?  ";
				
				String sql_C11 = "SELECT 'X' "
					+ "FROM PT_IL_PYMT_DTLS  "
					+ "WHERE PD_SYS_ID IN (SELECT DPD_PD_SYS_ID "
					+ "  FROM PT_IL_DEPOSIT_PYMT_DTLS "
					+ "  WHERE DPD_DEP_SYS_ID = ? ) "
					+ "AND PD_PAY_MODE ='P'";
				
				String sql_C12 = "SELECT  'X' "
					+ "FROM PM_IL_APPR_DEPT_SETUP "
					+ "WHERE ADS_USER_ID = ? "
					+ " AND ? BETWEEN ADS_FM_PROD_CODE AND ADS_TO_PROD_CODE "
					+ "AND ADS_DIVN_CODE = ? "
					+ "AND ADS_DEPT_CODE = ?";
				
				String sql_C13 = " SELECT ASD_CHAR_VALUE "
					+ "FROM PM_IL_APPR_SETUP_DET "
					+ "WHERE ASD_CODE = 'REV_RCT_YN' "
					+ "AND ASD_USER_ID = ? "
					+ "AND ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE "
					+ "AND ASD_FLAG='2'";
				
				String sql_C14="SELECT DEP_PROD_CODE FROM PT_IL_DEPOSIT  WHERE DEP_SYS_ID = ? ";
				
				String M_FOUND_11 = null;
				String M_FOUND_12 = null;
				String M_ASD_CHAR_VALUE = null;
				
				
				rs_C14 = handler.executeSelectStatement(sql_C14, connection,new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				if(rs_C14.next()){
					M_DEP_PROD_CODE = rs_C14.getString(1);
				}
				
				rs_C11 = handler.executeSelectStatement(sql_C11, connection,new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				if(rs_C11.next()){
					M_FOUND_11 = rs_C11.getString(1);
					rs_C12 = handler.executeSelectStatement(sql_C12, connection,new Object[]{CommonUtils.getControlBean().getM_USER_ID(),
																							 M_DEP_PROD_CODE,CommonUtils.getControlBean().getM_DIVN_CODE(),CommonUtils.getControlBean().getM_DEPT_CODE()});
					if(rs_C12.next()){
						M_FOUND_12 = rs_C12.getString(1);
						rs_C13 = handler.executeSelectStatement(sql_C13, connection,new Object[]{CommonUtils.getControlBean().getM_USER_ID(),M_DEP_PROD_CODE});
						if(rs_C13.next()){
							M_ASD_CHAR_VALUE = rs_C13.getString(1);
							if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE, "X"))){
								throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91498", 
															new Object[]{"Reverse Receipt"}));
							}
						}
					}else{
						throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "92014", 
								new Object[]{CommonUtils.getControlBean().getM_USER_ID()}));
					}
				}
				
				
				rs_C7=handler.executeSelectStatement(sql_C7, connection, new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				if(rs_C7.next())
				{
				    M_DEP_PDC_FLAG=rs_C7.getString(1);
				    M_DEP_TXN_CODE=rs_C7.getString(2);
				    M_DEP_DOC_NO=rs_C7.getString(3);
				    M_DEP_CHRG_TXN_CODE=rs_C7.getString(4);
				    M_DEP_CHRG_DOC_NO=rs_C7.getString(5);
				    M_DEP_REF_NO1=rs_C7.getString(6);
				   
				}
				rs_C8=handler.executeSelectStatement(sql_C8, connection, new Object[]{M_DEP_REF_NO1});
				if(rs_C8.next())
				{
				    M_POL_DS_TYPE=rs_C8.getString(1);
				    M_POL_STATUS1=rs_C8.getString(2);
				    M_POL_CONVERT_YN=rs_C8.getString(3);
				    M_POL_DS_CODE1=rs_C8.getString(4);
				    M_POL_SYS_ID1=rs_C8.getString(5);
				}
				
				if("1".equalsIgnoreCase(M_POL_DS_TYPE) && "Y".equalsIgnoreCase(CommonUtils.nvl(M_POL_CONVERT_YN,"N")))
				{
              
					rs_C9=handler.executeSelectStatement(sql_C9, connection, new Object[]{M_DEP_REF_NO1});
				    if(rs_C9.next())
				    {
				        M_POL_STATUS1=rs_C9.getString(1);
				    }
				    rs_C9.close();
				}
//            
				rs_C10=handler.executeSelectStatement(sql_C10, connection, new Object[]{M_POL_DS_TYPE,M_POL_DS_CODE1});
				if(rs_C10.next())
				{
				    M_DS_POST_BO=rs_C10.getString(1);
				}
				rs_C10.close();
				
				System.out.println("M_POL_STATUS1          "+M_POL_STATUS1);
				
				if(!("C".equalsIgnoreCase(M_POL_STATUS1)))
				{
				    if(MigratingFunctions.nvl(M_DEP_PDC_FLAG,"X")=="Y")
				    {
//                    
				        String sql_vembu1="DELETE FROM PS_IL_DRCR" +
				                    			" WHERE DRCR_TXN_CODE = "+M_DEP_TXN_CODE+"" +
				                    				" AND DRCR_DOC_NO = "+M_DEP_DOC_NO+"  ";
				        handler.executeDeleteStatement(sql_vembu1, connection);
				        
				        String sql_vembu2="DELETE FROM PS_IL_DRCR" +
				                    		 " WHERE  DRCR_TXN_CODE  = "+M_DEP_CHRG_TXN_CODE+"" +
				                    			" AND DRCR_DOC_NO  = "+M_DEP_CHRG_DOC_NO+"  ";
				        handler.executeDeleteStatement(sql_vembu2, connection);
				        String sql_vembu3="UPDATE PT_IL_DEPOSIT SET DEP_DOC_DT = NULL," +
				            				" DEP_TXN_CODE = NULL, DEP_DOC_NO = NULL," +
				            					" DEP_CHRG_TXN_CODE = NULL," +
				            						" DEP_CHRG_DOC_NO = NULL" +
				            							" WHERE  DEP_SYS_ID  = ?  ";
				        handler.executeUpdateStatement(sql_vembu3, connection, new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				        BOUNCER_ACTION.getCOMP_UI_M_CBH_REASON_CODE().setDisabled(true);
				        BOUNCER_ACTION.getCOMP_UI_M_CBH_REMARKS().setDisabled(true);
				        BOUNCER_ACTION.getCOMP_UI_M_EDIT_REMARKS().setDisabled(true);
				        
				        Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error")};
				        compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error"));
						compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().put("CURRENT",Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error"));
				        //throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				    }
				    else
				    {
				       rs_C6=handler.executeSelectStatement(sql_C6, connection, new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				        if(rs_C6.next())
				        {
				            M_REVERSAL_FLAG=rs_C6.getString(1);
				        }
				        
				        System.out.println("M_REVERSAL_FLAG          "+M_REVERSAL_FLAG);
				        
				        if("N".equalsIgnoreCase(CommonUtils.nvl(M_REVERSAL_FLAG,"N")))
				        {
//                        try{
				            	procedure = new PILP023_PROCEDURE();
				            	procedure.UPD_CONT_MAS_IN_PROP_STAGE(BOUNCE_BEAN.getUI_M_DEP_SYS_ID().toString());
				            	
//                            p9ilpk_receipt_reversal.p9ilpk_receipt_reversal.upd_cont_mas_in_prop_stage(:DUMMY.M_DEP_SYS_ID);
//                        }
//                        catch(SQLException se){
//                        	se.getMessage();
//                            /*L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
//                            throw new FORM_TRIGGER_FAILURE();*/
//                        }
				           
				            rs_C1A=handler.executeSelectStatement(sql_C1A, connection, new Object[]{BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
				            while((true))
				            {
				                if(rs_C1A.next())
				                {
				                    M_PD_DPD_REF_ID=rs_C1A.getString("PD_DPD_REF_ID");
				                    M_PD_SYS_ID=rs_C1A.getDouble("PD_SYS_ID");
				                    M_PD_TXN_SYS_ID=rs_C1A.getDouble("PD_TXN_SYS_ID");
				                    M_PD_TXN_TYPE=rs_C1A.getString("PD_TXN_TYPE");
				                    M_PD_CHQ_NO=rs_C1A.getString("PD_CHQ_NO");
				                    M_PD_BANK_CODE=rs_C1A.getString("PD_BANK_NAME");
				                }
				                if(rs_C1A.isAfterLast() || rs_C1A.isBeforeFirst())
				                break;
//                            :PT_IL_PYMT_DTLS.PD_TXN_TYPE == ("QD") || :PT_IL_PYMT_DTLS.PD_TXN_TYPE == ("PD") || :PT_IL_PYMT_DTLS.PD_TXN_TYPE == ("LR")
				              
				                
				                
				                System.out.println("getPD_TXN_TYPE        "+pymtBean.getPD_TXN_TYPE()+
				                		"M_PD_TXN_SYS_ID         "+M_PD_TXN_SYS_ID+
				                		"getPD_SYS_ID      "+pymtBean.getPD_SYS_ID());
				                //Modified by rakesh on 18-07-2020 for orient already separate condition handled for LR
				                /*if("QD".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()) || "PD".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()) || "LR".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()))*/
				                if("QD".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()) || "PD".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()))
				                {
				                    if(rs_C2!=null)
				                    {
				                    	rs_C2.close();
				                    }
				                    P_TXN_SYS_ID = M_PD_TXN_SYS_ID;
//                                vembu_C2=stmt_C2.executeQuery(sql_C2);
				                    rs_C2=handler.executeSelectStatement(sql_C2, connection,new Object[]{P_TXN_SYS_ID});
				                    if(rs_C2.next())
				                    {
				                        M_CONT_CODE=rs_C2.getString(1);
				                        M_DEP_REF_NO=rs_C2.getString(2);
				                    }
				                   
				                    rs_C2A=handler.executeSelectStatement(sql_C2A, connection, 
				                    		new Object[]{M_DEP_REF_NO,M_DEP_REF_NO});
				                    if(rs_C2A.next())
				                    {
				                        M_POL_STATUS=rs_C2A.getString(1);
				                        M_POL_APPRV_STATUS=rs_C2A.getString(2);
				                    }
				                    if("C".equalsIgnoreCase(CommonUtils.nvl(M_POL_STATUS,"X")))
				                    {
				                    	Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error2")};
				                    	throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				                        /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE POLICY FOR THE RECEIPT HAS BEEN ALREADY REVERSED");
				                        throw new FORM_TRIGGER_FAILURE();*/
				                    }
				                   
				                }
//                            :PT_IL_PYMT_DTLS.PD_TXN_TYPE=="PT"
				                else if("PT".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()))
				                {
				                   
				                    P_TXN_SYS_ID = M_PD_TXN_SYS_ID;
				                    /*Commented and modified by senthilnathan for orient on 04.08.2020
				    				 *  issue desc: pol_cont_code is getting invalid contractor code*/
				                   // rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{P_TXN_SYS_ID});
				                    rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{M_DEP_REF_NO1});
				                    if(rs_C1.next())
				                    {
				                        M_CONT_CODE=rs_C1.getString(1);
				                        M_POL_STATUS=rs_C1.getString(2);
				                        M_POL_APPRV_STATUS=rs_C1.getString(3);
				                    }
				                   
				                    if("C".equalsIgnoreCase(CommonUtils.nvl(M_POL_STATUS,"X")))
				                    {
				                    	Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error2")};
				                    	throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				                       /* STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE POLICY FOR THE RECEIPT HAS BEEN ALREADY REVERSED");
				                        throw new FORM_TRIGGER_FAILURE();*/
				                    }
				                }
				                else if("PC".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()))
				                {
				                    if(rs_C3!=null)
				                    {
				                    	rs_C3.close();
				                    }
				                    P_TXN_SYS_ID = M_PD_TXN_SYS_ID;
//                                vembu_C3=stmt_C3.executeQuery(sql_C3);
				                    rs_C3=handler.executeSelectStatement(sql_C3, connection,new Object[]{P_TXN_SYS_ID});
				                    if(rs_C3.next())
				                    {
				                        M_POL_SYS_ID=rs_C3.getDouble(1);
				                    }
				                    rs_C3.close();
				                    if(rs_C1!=null)
				                    {
				                    	rs_C1.close();
				                    }
				                    P_TXN_SYS_ID = M_POL_SYS_ID;
//                                vembu_C1=stmt_C1.executeQuery(sql_C1);
				                    /*Commented and modified by senthilnathan for orient on 04.08.2020
				    				 *  issue desc: pol_cont_code is getting invalid contractor code*/
//				                    rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{P_TXN_SYS_ID});
				                    rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{M_DEP_REF_NO1});
				                    if(rs_C1.next())
				                    {
				                        M_CONT_CODE=rs_C1.getString(1);
				                        M_POL_STATUS=rs_C1.getString(2);
				                        M_POL_APPRV_STATUS=rs_C1.getString(3);
				                    }
				                    rs_C1.close();
				                    if("C".equalsIgnoreCase(CommonUtils.nvl(M_POL_STATUS,"X")))
				                    {
				                    	Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error2")};
				                    	throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				                        /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE POLICY FOR THE RECEIPT HAS BEEN ALREADY REVERSED");
				                        throw new FORM_TRIGGER_FAILURE();*/
				                    }
				                }
				                else if("LR".equalsIgnoreCase(pymtBean.getPD_TXN_TYPE()))
				                {
				                    if(rs_C4!=null)
				                    {
				                    	rs_C4.close();
				                    }
				                    P_TXN_SYS_ID = M_PD_TXN_SYS_ID;
//                                vembu_C4=stmt_C4.executeQuery(sql_C4);
				                    rs_C4=handler.executeSelectStatement(sql_C4, connection);
				                    if(rs_C4.next())
				                    {
				                        M_LOAN_SYS_ID=rs_C4.getDouble(1);
				                    }
				                    rs_C4.close();
				                    if(rs_C4!=null)
				                    {
				                    	rs_C4.close();
				                    }
				                    P_TXN_SYS_ID = M_LOAN_SYS_ID;
//                                vembu_C4=stmt_C4.executeQuery(sql_C4);
				                    rs_C4=handler.executeSelectStatement(sql_C4, connection,new Object[]{P_TXN_SYS_ID});
				                    if(rs_C4.next())
				                    {
				                        M_POL_SYS_ID=rs_C4.getDouble(1);
				                    }
				                    rs_C4.close();
				                    if(rs_C1!=null)
				                    {
				                    	rs_C1.close();
				                    }
				                    P_TXN_SYS_ID = M_POL_SYS_ID;
//                                vembu_C1=stmt_C1.executeQuery(sql_C1);
				                    
//				                    rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{P_TXN_SYS_ID});
				                    rs_C1=handler.executeSelectStatement(sql_C1, connection,new Object[]{M_DEP_REF_NO1});
				                    if(rs_C1.next())
				                    {
				                        M_CONT_CODE=rs_C1.getString(1);
				                        M_POL_STATUS=rs_C1.getString(2);
				                        M_POL_APPRV_STATUS=rs_C1.getString(3);
				                    }
				                    rs_C1.close();
				                    if("C".equalsIgnoreCase(CommonUtils.nvl(M_POL_STATUS,"X")))
				                    {
				                    	Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error2")};
				                    	throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				                        /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE POLICY FOR THE RECEIPT HAS BEEN ALREADY REVERSED");
				                        throw new FORM_TRIGGER_FAILURE();*/
				                    }
				                }
				               
				                System.out.println("M_CONT_CODE           "+M_CONT_CODE);
				                
				                if(M_CONT_CODE != null)
				                {
				                   
				                    	procedure = new PILP023_PROCEDURE();
				                    	procedure.GEN_REVERSE_ALL_TXN(M_PD_SYS_ID.toString(), M_CONT_CODE, M_PD_TXN_SYS_ID.toString(), M_PD_TXN_TYPE, M_PD_DPD_REF_ID, BOUNCE_BEAN.getUI_M_CBH_REASON_CODE(), BOUNCE_BEAN.getUI_M_CBH_REMARKS());
//                                    p9ilpk_receipt_reversal.p9ilpk_receipt_reversal.gen_reverse_all_txn(M_PD_SYS_ID,M_CONT_CODE,M_PD_TXN_SYS_ID,M_PD_TXN_TYPE,M_PD_DPD_REF_ID,:DUMMY.M_CBH_REASON_CODE,:DUMMY.M_CBH_REMARKS);
				                   
				                }
				                else
				                {
				                	throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91088"));
//                            	getErrorMap().put("current","Invalid Contractor Code!");
//                            
				                	/*BOUNCER_ACTION.getErrorMap().put("current", (Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91088")).getDetail());
				                    STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91088,:CTRL.M_LANG_CODE);
				                    throw new FORM_TRIGGER_FAILURE();*/
				                }
				            }
				           
//                        try{
				            	procedure = new PILP023_PROCEDURE();
				            	procedure.INS_REV_ACT_ENTRIES(BOUNCE_BEAN.getUI_M_DEP_SYS_ID().toString());
//                            p9ilpk_receipt_reversal.p9ilpk_receipt_reversal.ins_rev_act_entries(:DUMMY.M_DEP_SYS_ID);
				          /*  }
				            catch(SQLException se){
				            	se.getMessage();
				                L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
				                throw new FORM_TRIGGER_FAILURE();
				            }
				            try{*/
				            	procedure = new PILP023_PROCEDURE();
				            	procedure.UPD_AFF_REC_CONT_DEP_UTIL_AMT(BOUNCE_BEAN.getUI_M_DEP_SYS_ID().toString());
//                            p9ilpk_receipt_reversal.p9ilpk_receipt_reversal.upd_aff_rec_cont_dep_util_amt(:DUMMY.M_DEP_SYS_ID);
//                        }
//                        catch(SQLException se){
//                        	se.getMessage();
//                            /*L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
//                            throw new FORM_TRIGGER_FAILURE();*/
//                        }
//                        Statement stmt_vembu4=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//                        UPDATE   PT_IL_DEPOSIT    SET DEP_REC_REV_YN = 'Y',      DEP_REASON_CODE = :DUMMY.M_CBH_REASON_CODE,      DEP_REV_REMARKS = :DUMMY.M_CBH_REMARKS,      DEP_REV_BANK_IN_SLIP_NO = :DUMMY.M_CBH_REVERSAL_REF_NO  WHERE  DEP_SYS_ID  = :DUMMY.M_DEP_SYS_ID  
				            String sql_vembu4="UPDATE PT_IL_DEPOSIT SET DEP_REC_REV_YN = 'Y'," +
				                        		" DEP_REASON_CODE = ?," +
				                        		" DEP_REV_REMARKS = ?," +
				                        		" DEP_REV_BANK_IN_SLIP_NO = ?" +
				                        		" WHERE  DEP_SYS_ID  = ? ";
				            handler.executeUpdateStatement(sql_vembu4, connection, new Object[]{BOUNCE_BEAN.getUI_M_CBH_REASON_CODE(), BOUNCE_BEAN.getUI_M_CBH_REMARKS(), BOUNCE_BEAN.getUI_M_CBH_REVERSAL_REF_NO(), BOUNCE_BEAN.getUI_M_DEP_SYS_ID()});
//                      
				            
				            
//                        STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"RECEIPT REVERSAL DONE SUCCESSFULLY");
				            
				            if("O".equalsIgnoreCase(M_DS_POST_BO))
				            {
				            //	sessionMap.put("GLOBAL.M_POL_SYS_ID", M_POL_SYS_ID1);
				            	CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", M_POL_SYS_ID1);
				            	CommonUtils.setGlobalVariable("GLOBAL.M_CLM_SYS_ID", "0");
//                            :GLOBAL.M_POL_SYS_ID=M_POL_SYS_ID1;
//                            :GLOBAL.M_CLM_SYS_ID=0;
//                            SYNCHRONIZE.SYNCHRONIZE();
//                            CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
				            }
				            /*GO_ITEM.GO_ITEM("DUMMY.M_DEP_DOC_NO");
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REASON_CODE",ENABLED,PROPERTY_FALSE);
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REASON_CODE",UPDATE_ALLOWED,PROPERTY_FALSE);
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_LOV_REASON_CODE",ENABLED,PROPERTY_FALSE);
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REMARKS",ENABLED,PROPERTY_FALSE);
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CBH_REMARKS",UPDATE_ALLOWED,PROPERTY_FALSE);
				            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_EDIT_REMARKS",ENABLED,PROPERTY_FALSE);*/
				            BOUNCER_ACTION.getCOMP_UI_M_CBH_REASON_CODE().setDisabled(true);
				            BOUNCER_ACTION.getCOMP_UI_M_CBH_REMARKS().setDisabled(true);
				           
				            /*Commented by Janani on 17.08.2020 for Orient LIVE
				            desc : Null pointer exception while reverse process.Unused component*/
				            
				            //BOUNCER_ACTION.getCOMP_UI_M_EDIT_REMARKS().setDisabled(true);
				            
				            /*End*/
				            
				            Object[] value = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error")};
				            //throw new Exception(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", value));
				            compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error"));
							compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().put("CURRENT",Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error"));
				        }
				        else
				        {
				        	String[] msg = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error3")};
				        	throw new Exception(Messages.getString(
									"com.iii.premia.common.errorUtil.PELErrorMessages", "3206", msg));
				           /* STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE GIVEN RECEIPT DETAILS ARE ALREADY REVERSED");
				            throw new FORM_TRIGGER_FAILURE();*/
				        }
				    }
				}
				else
				{
					String[] msg = {Messages.getString("messageProperties_PILP023", "PILP023$PT_IL_CHEQUE_BOUNCE_HDR$UI_M_BUT_REVERSE$error3")};
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "3206", msg));
				    /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"THE GIVEN RECEIPT DETAILS ARE ALREADY REVERSED");
				    throw new FORM_TRIGGER_FAILURE();*/
				}
			}
        	
        	 catch (Exception e) {
				e.printStackTrace();
				compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getErrorMap().put("CURRENT", e.getMessage());
			}finally{
				CommonUtils.getConnection().commit();
				try{
					CommonUtils.closeCursor(rs_C1A);
					CommonUtils.closeCursor(rs_C1);
					CommonUtils.closeCursor(rs_C2);
					CommonUtils.closeCursor(rs_C2A);
					CommonUtils.closeCursor(rs_C3);
					CommonUtils.closeCursor(rs_C4);
					CommonUtils.closeCursor(rs_C5);
					CommonUtils.closeCursor(rs_C6);
					CommonUtils.closeCursor(rs_C7);
					CommonUtils.closeCursor(rs_C8);
					CommonUtils.closeCursor(rs_C9);
					CommonUtils.closeCursor(rs_C11);
					CommonUtils.closeCursor(rs_C12);
					CommonUtils.closeCursor(rs_C13);
					CommonUtils.closeCursor(rs_C14);
					
				}catch(Exception exception){}
			}
    }

	
	public void loadPaymentAndChequeDetails(){
		
	}
	/*Added by Ram on 25/12/2016 for Save Record Function*/
	public void preUpdate(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws Exception{
		System.out.println("*******In PRE-UPDATE trigger************");
		try {
			generateSeqNo(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_DT(new CommonUtils().getCurrentDate());
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-UPDATE trigger ends************");
	}
	
	public void generateSeqNo(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws Exception
	{
		String query = "SELECT PIL_CBH_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		try
		{
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while(rs.next())
			{
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_SYS_ID(rs.getDouble(1));
				System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_SYS_ID      "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_SYS_ID());
			}
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	/*End*/

/*Added by Ram on 25/12/2016 for Search concept*/
	public void executeQuery(PILP023_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			new PILP023_DELEGATE()
					.executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*End*/
	
	/*Added by Ameen on 20-06-2017 for ZBILQC-1720414*/
	public void receptBounceHdrExecuteQry(PILP023_COMPOSITE_ACTION compositeAction){
		try {
			new PILP023_DELEGATE()
			.receptBounceHdrExecuteQuery(compositeAction);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*End*/
}

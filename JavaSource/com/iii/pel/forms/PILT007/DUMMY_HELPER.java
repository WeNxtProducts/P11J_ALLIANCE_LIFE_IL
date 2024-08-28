package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP008.PILP008_DUMMY_ACTION;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_ACTION_INSTANCE;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_COVER_DTLS;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {

	public ControlBean getCtrlBean() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}

	public String approveButtonWhenButtonPressed(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_PAID claimPaidBean = claimPaidAction
				.getPT_IL_CLAIM_PAID_BEAN();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String M_REC_EXIST = "N";
		String M_CP_PAID_DT = null;
		String M_CP_APPR_FLAG = null;
		String M_CP_SYS_ID = null;
		String M_CP_REF_SYS_ID = null;
		String M_CP_CE_SYS_ID = null;
		String M_APPR_FLAG = null;
		String M_CP_FC_PAID_AMT = null;
		String M_CP_LC_PAID_AMT = null;
		String M_CCD_LC_EST_AMT = null;
		String M_CCD_FC_EST_AMT = null;
		String M_SUM_LC_PAID_AMT = null;
		String M_SUM_FC_PAID_AMT = null;
		String M_TODO_LIST_STAT = null;
		String M_DUMMY = null;
		Double M_TOT_PAID_AMT = null;
		Double M_POL_YEAR_NO = null;

		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY1;

		CRUDHandler handler = new CRUDHandler();

		String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY3;
		String CP_APPR_FLAG = null;
		String CP_CE_SYS_ID = null;
		String CP_FC_PAID_AMT = null;
		String CP_LC_PAID_AMT = null;
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		System.out.println(CLAIM_SYS_ID.doubleValue());
		Double CCD_FC_EST_AMT = null;
		Double CCD_LC_EST_AMT = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rst3 = null;
		ResultSet rst4 = null;
		ResultSet rst5 = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { CLAIM_SYS_ID, "Y", "A" });
			while (rst.next()) {
				CP_APPR_FLAG = rst.getString(1);
				CP_CE_SYS_ID = rst.getString(2);
				CP_FC_PAID_AMT = rst.getString(3);
				CP_LC_PAID_AMT = rst.getString(4);
			}

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY4;

			String sql_C4 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY5;

			String sql_C5 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY6;

			
			/*Commented by Janani on 14.02.2018 for ZB as per Thiags sugges*/

			//new PILT007_PROCEDURE().L_CHECK_BENF_PAID(compositeAction);
			
			/*End*/
			
			/*Added by Janani on 22.08.2017 for ZBILQC-1732254 */
			
			System.out.println("getCP_CLAIM_PAID_TO         "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO());
			
			if(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO().equalsIgnoreCase("B"))
			{
				
			/*End*/	
				
			new PILT007_PROCEDURE().L_CHECK_BENEFICIARY(compositeAction);
			
			/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
			new PILT007_PROCEDURE().L_CHECK_BENF_PAID(compositeAction);
			/*End*/
			
			}
			
			
			rst3 = handler
					.executeSelectStatement(sql_C3, connection,
							new Object[] {
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_SYS_ID(),
									"4",
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_DS_CODE(), "CHKLST",
									"NA", "N", "N", "Y" });
			while (rst3.next()) {
				M_TODO_LIST_STAT = rst3.getString(1);
			}

			rst4 = handler
					.executeSelectStatement(sql_C4, connection,
							new Object[] {
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_SYS_ID(), "N", "Y",
									"IL_FEB_LOSTY" });
			while (rst4.next()) {
				CCD_LC_EST_AMT = rst4.getDouble("CCD_LC_EST_AMT");
				CCD_FC_EST_AMT = rst4.getDouble("CCD_FC_EST_AMT");
			}

			if (CCD_FC_EST_AMT != null || CCD_LC_EST_AMT != null) {
				Double SUM_CP_LC_PAID_AMT = 0.0;
				Double SUM_CP_FC_PAID_AMT = 0.0;
				rst5 = handler.executeSelectStatement(sql_C5, connection,
						new Object[] {
								claimAction.getPT_IL_CLAIM_BEAN()
										.getCLAIM_SYS_ID(), "A" });
				while (rst5.next()) {
					SUM_CP_LC_PAID_AMT = rst5.getDouble(1);
					SUM_CP_FC_PAID_AMT = rst5.getDouble(2);
				}

				String M_CALC_METHOD = claimAction.getPT_IL_CLAIM_BEAN()
						.getUI_M_CALC_METHOD();
				
				//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
				
				if ( M_CALC_METHOD != null/* ? "1" : M_CALC_METHOD).equals("1")*/) {
					if ((CCD_LC_EST_AMT == null ? 0.0 : CCD_LC_EST_AMT) > 0.0
							&& (SUM_CP_LC_PAID_AMT == null ? 0.0
									: SUM_CP_LC_PAID_AMT) > (CCD_LC_EST_AMT == null ? 0.0
									: CCD_LC_EST_AMT)
							&& (CCD_FC_EST_AMT == null ? 0.0 : CCD_FC_EST_AMT) > 0.0
							&& (SUM_CP_FC_PAID_AMT == null ? 0.0
									: SUM_CP_FC_PAID_AMT) > (CCD_FC_EST_AMT == null ? 0.0
									: CCD_FC_EST_AMT)) {
						if (M_TODO_LIST_STAT.equals("X")) {
							throw new ValidatorException(
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"3206"));
							/*
							 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Atleast
							 * One Checklist Item Is Incomplete'); RAISE
							 * FORM_TRIGGER_FAILURE;
							 */
						}
					}
				}
			}

			M_REC_EXIST = "N";
			Date CP_PAID_DT = null;
			rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_SYS_ID, "Y", "P", "A" });
			while (rst1.next()) {
				CP_PAID_DT = rst1.getDate(1);
			}

			if (CP_PAID_DT != null)
				M_REC_EXIST = "Y";
			if ((M_REC_EXIST == null ? "N" : M_REC_EXIST).equals("N")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"71092"));
			} else {
				sessionMap.put("GLOBAL.CLAIM_SYS_ID", claimAction
						.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
				sessionMap.put("GLOBAL.CLAIM_NO", claimAction
						.getPT_IL_CLAIM_BEAN().getCLAIM_NO());
				sessionMap.put("GLOBAL.CLAIM_POL_NO", claimAction
						.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO());
				sessionMap.put("GLOBAL.CP_APPR_FLAG", claimPaidBean
						.getCP_APPR_FLAG());
				sessionMap.put("GLOBAL.CP_FC_PAID_AMT", claimPaidBean
						.getCP_FC_PAID_AMT());
				sessionMap.put("GLOBAL.CP_LC_PAID_AMT", claimPaidBean
						.getCP_LC_PAID_AMT());
				/*CommonUtils.setGlobalObject("GLOBAL.CP_CE_SYS_ID", (Long)claimPaidBean
						.getCP_CE_SYS_ID());*/
				sessionMap.put("GLOBAL.CP_CE_SYS_ID", claimPaidBean
						.getCP_CE_SYS_ID());
				sessionMap.put("GLOBAL.M_CALL_SUCCESS", "N");
				sessionMap.put("GLOBAL.M_POL_SYS_ID", claimAction
						.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
				PILP008_DUMMY_ACTION pilp008DummyAction = (PILP008_DUMMY_ACTION) sessionMap
						.get("PILP008_DUMMY_ACTION");
				if (pilp008DummyAction != null) {
					pilp008DummyAction.setOnLoadFlag(false);
				}
				com.iii.pel.forms.PILP006.DUMMY_ACTION pilp006DummyAction = (com.iii.pel.forms.PILP006.DUMMY_ACTION) sessionMap
						.get("PILP006_DUMMY_ACTION");
				if (pilp006DummyAction != null) {
					sessionMap.remove("PILP006_DUMMY_ACTION");
				}
				
				CommonUtils.setGlobalObject("PILT007_COMPOSITE_ACTION", compositeAction);
				
				return "PILP008";
			}
		
		}catch (Exception e) {
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

	public void claimsSettlement(PILT007_COMPOSITE_ACTION compositeAction)
			throws ValidatorException {
		try {
			String sql_C1A = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY2;
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_SYS_ID();
			String M_REC_EXIST = null;
			try {
				ResultSet rst = handler.executeSelectStatement(sql_C1A,
						connection, new Object[] { "A", CLAIM_SYS_ID });
				while (rst.next()) {
					M_REC_EXIST = rst.getString(1);
				}
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (M_REC_EXIST == null)
				return;

			getCtrlBean().setM_COMM_DEL(null);

			String callSuccess = (String) sessionMap
					.get("GLOBAL.M_CALL_SUCCESS");
			if ((callSuccess == null ? "N" : callSuccess).equals("Y")) {
				claimPaidAction.getCOMP_CP_PAID_DT().setDisabled(true);
				claimPaidAction.getCOMP_CP_APPR_FLAG().setDisabled(true);
				claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);

			}

			try {
				connection.commit();
			} catch (SQLException e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

			// new added in java
			claimAction.getCOMP_UI_M_BUT_PV().setDisabled(false);
			// new

			String M_X = null;
			String sql_C13 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY9;
			try {
				ResultSet rst = handler.executeSelectStatement(sql_C13,
						connection, new Object[] { CLAIM_POL_SYS_ID,
								CLAIM_SYS_ID, "L", "N" });
				while (rst.next()) {
					M_X = rst.getString(1);
				}
				CommonUtils.closeCursor(rst);
			} catch (SQLException e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
			if (M_X != null) {
				String M_CLAIM_DS_CODE = null;
				String sql_C11 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY7;
				try {
					ResultSet rst = handler.executeSelectStatement(sql_C11,
							connection, new Object[] { CLAIM_SYS_ID });
					while (rst.next()) {
						M_CLAIM_DS_CODE = rst.getString(1);
					}
					CommonUtils.closeCursor(rst);
				} catch (SQLException e) {
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}

				String M_DS_POST_BO = null;
				String sql_C12 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY8;
				try {
					ResultSet rst = handler.executeSelectStatement(sql_C12,
							connection, new Object[] { M_CLAIM_DS_CODE, "4" });
					while (rst.next()) {
						M_DS_POST_BO = rst.getString("DS_POST_BO");
					}
					CommonUtils.closeCursor(rst);
				} catch (SQLException e) {
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}

				if ((M_DS_POST_BO == null ? "X" : M_DS_POST_BO).equals("O")) {
					sessionMap.put("GLOBAL.M_POL_SYS_ID", claimAction
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
					sessionMap.put("GLOBAL.M_CLM_SYS_ID", claimAction
							.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
					// CALL_FORM('PILP010',NO_HIDE,NO_REPLACE);
				}
			}
			String sql_C14 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY10;

			String sql_C15 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_DUMMY_QUERY11;

			ResultSet rst_C14 = handler.executeSelectStatement(sql_C14,
					connection, new Object[] { CLAIM_SYS_ID });
			ArrayList<PT_IL_CLAIM_COVER_DTLS> C14_rec = new ArrayList<PT_IL_CLAIM_COVER_DTLS>();
			while (rst_C14.next()) {
				PT_IL_CLAIM_COVER_DTLS coverBean = new PT_IL_CLAIM_COVER_DTLS();
				coverBean
						.setCCD_COVER_CODE(rst_C14.getString("CCD_COVER_CODE"));
				coverBean.setCCD_LOSS_TYPE(rst_C14.getString("CCD_LOSS_TYPE"));
				coverBean
						.setCCD_DISAB_TYPE(rst_C14.getString("CCD_DISAB_TYPE"));
				coverBean.setCCD_PROD_CODE(rst_C14.getString("CCD_PROD_CODE"));
				coverBean.setCCD_COVER_GROUP_CODE(rst_C14
						.getString("CCD_COVER_GROUP_CODE"));
				C14_rec.add(coverBean);
			}
			CommonUtils.closeCursor(rst_C14);
			Double M_POL_YEAR_NO = null;
			for (int i = 0; i < C14_rec.size(); i++) {
				M_POL_YEAR_NO = new PILT007_PROCEDURE()
						.P9ILPK_CLAIM_F_GET_CLAIM_YEAR(connection, claimAction
								.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(),
								claimAction.getPT_IL_CLAIM_BEAN()
										.getCLAIM_LOSS_DT());
				PT_IL_CLAIM_COVER_DTLS claimCoverDtlsBean = C14_rec.get(i);
				String CCD_COVER_CODE = claimCoverDtlsBean.getCCD_COVER_CODE();
				String CCD_LOSS_TYPE = claimCoverDtlsBean.getCCD_LOSS_TYPE();
				String CCD_DISAB_TYPE = claimCoverDtlsBean.getCCD_DISAB_TYPE();
				String CCD_PROD_CODE = claimCoverDtlsBean.getCCD_PROD_CODE();
				String CCD_COVER_GROUP_CODE = claimCoverDtlsBean
						.getCCD_COVER_GROUP_CODE();

				ResultSet rst_C15 = handler.executeSelectStatement(sql_C15,
						connection, new Object[] { CCD_COVER_CODE,
								CCD_LOSS_TYPE, CCD_DISAB_TYPE, CCD_PROD_CODE,
								CCD_COVER_GROUP_CODE });
				Double M_TOT_PAID_AMT = null;
				while (rst_C15.next()) {
					M_TOT_PAID_AMT = rst_C15.getDouble(1);
				}
				CommonUtils.closeCursor(rst_C15);
				String updateQuery = "UPDATE  PS_IL_CLAIM_LIMITS "
						+ "SET     CL_LC_PAID_AMT      = NVL(?,0) "
						+ "WHERE   CL_POL_SYS_ID       = ? "
						+ "AND     CL_POAD_SYS_ID      = (SELECT POAD_SYS_ID "
						+ "FROM   PT_IL_POL_ASSURED_DTLS "
						+ "WHERE  POAD_POL_SYS_ID  =  ? "
						+ "AND    POAD_ASSR_CODE   =  ?) "
						+ "AND     CL_PROD_CODE        =  ? "
						+ "AND     CL_COVER_GROUP_CODE =  ? "
						+ "AND     CL_COVER_CODE       =  ? "
						+ "AND     CL_BNF_CODE         =  ? "
						+ "AND     CL_SBNF_CODE        =  ? "
						+ "AND     CL_POL_YEAR         =  ? ";
				int recordsUpdated = handler.executeUpdateStatement(
						updateQuery, connection, new Object[] {
								M_TOT_PAID_AMT,
								claimAction.getPT_IL_CLAIM_BEAN()
										.getCLAIM_POL_SYS_ID(),
								claimAction.getPT_IL_CLAIM_BEAN()
										.getCLAIM_POL_SYS_ID(),
								claimAction.getPT_IL_CLAIM_BEAN()
										.getCLAIM_ASSURED_CODE(),
								CCD_PROD_CODE, CCD_COVER_GROUP_CODE,
								CCD_COVER_CODE, CCD_LOSS_TYPE, CCD_DISAB_TYPE,
								M_POL_YEAR_NO });
			}
			connection.commit();
			sessionMap.put("GLOBAL.CLAIM_SYS_ID", claimAction
					.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
			/*Swiss_Sql_CLAIM helper = new Swiss_Sql_CLAIM();
			helper.executeQuery();*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String backPage() {
		PILT006_APAC_ACTION_INSTANCE.getClaimActionInstance()
				.setFormFlag(false);
		PILT006_APAC_ACTION_INSTANCE.getClaimActionInstance().setBlockFlag(
				false);
		return "claimsEntry";
	}

}

package com.iii.pel.forms.PP039_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
	
	public void whenNewRecordInstance() throws Exception {
		String M_FLAG = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "	SELECT NVL(AS_MOD_ACC_FLAG_YN,'N') FROM  PM_APPR_SETUP WHERE  AS_USER_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID") });
			if (resultSet.next()) {
				M_FLAG = resultSet.getString(1);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	/*Added by Jyoti(55315) as per Ganesh Instruction on 2nd Mar'12*/
	public void WHEN_VALIDATE_ITEM_M_POL_NO(String UI_M_POL_NO) throws Exception{
		String M_FLAG = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String Query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') " +
		"IN ('A','E','R') AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND POL_NO = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection, 
				new Object[] {UI_M_POL_NO });
			if (resultSet.next()) {
				M_FLAG = resultSet.getString(1);
			}
			if(M_FLAG == null){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71081"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_POLICY_TO(String UI_M_POLICY_FM,
			String UI_M_POLICY_TO) throws Exception {

		try {
			UI_M_POLICY_TO = (String) commonUtils.SET_REP_SECOND_FIELD(
					UI_M_POLICY_FM, UI_M_POLICY_TO, "String");
			L_VAL_FROM_TO(UI_M_POLICY_FM, UI_M_POLICY_TO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_POLICY_FM(String UI_M_POLICY_FM,
			String UI_M_POLICY_TO) throws Exception {
		try {
			UI_M_POLICY_FM = (String) commonUtils.SET_REP_FIRST_FIELD(
					UI_M_POLICY_FM, "String");
			WHEN_VALIDATE_ITEM_M_POLICY_TO(UI_M_POLICY_FM, UI_M_POLICY_TO );
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_PROD_FM(String UI_M_PROD_FM,
			String UI_M_PROD_TO ) throws Exception {
		try {
			UI_M_PROD_FM = (String) commonUtils.SET_REP_FIRST_FIELD(
					UI_M_PROD_FM, "String");
			WHEN_VALIDATE_ITEM_M_PROD_TO(UI_M_PROD_FM, UI_M_PROD_TO );
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_PROD_TO(String UI_M_PROD_FM,
			String UI_M_PROD_TO ) throws Exception {
		try {
			UI_M_PROD_TO = (String) commonUtils.SET_REP_SECOND_FIELD(
					UI_M_PROD_FM, UI_M_PROD_TO, "String");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_FM_DT(DUMMY_ACTION dummy_action)
	throws Exception {
		if (dummy_action.getDUMMY_BEAN().getUI_M_FM_DT().after(
				commonUtils.getCurrentDate())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "2181")));
		}
		if (dummy_action.getDUMMY_BEAN().getUI_M_TO_DT() != null) {
			if (dummy_action.getDUMMY_BEAN().getUI_M_TO_DT().before(
					dummy_action.getDUMMY_BEAN().getUI_M_FM_DT())) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "1050")));

			}
		}

	}

	public void WHEN_VALIDATE_ITEM_M_TO_DT(DUMMY_ACTION dummy_action)
	throws Exception {

		if (dummy_action.getDUMMY_BEAN().getUI_M_TO_DT().before(
				dummy_action.getDUMMY_BEAN().getUI_M_FM_DT())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "1050")));
		}
		if (dummy_action.getDUMMY_BEAN().getUI_M_TO_DT().after(
				commonUtils.getCurrentDate())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "2181")));
		}
	}

	public void L_VAL_FROM_TO(String P_FROM_CODE, String P_TO_CODE)
	throws Exception {
		if (P_FROM_CODE == null) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "80033")));
		}
		if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "80034")));
		}

		/*
		 * if(Double.parseDouble(P_TO_CODE)<Double.parseDouble(P_FROM_CODE)){
		 * throw new ValidatorException(new
		 * FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath,
		 * "80034"))); }
		 */

	}

	public void WHEN_BUTTON_PRESS_M_BUT_APPRV(DUMMY_ACTION dummy_action)
	throws Exception {
		Connection connection = null;
		String query="SELECT ps_value FROM PP_SYSTEM WHERE PS_TYPE='IL_CALC_MTHD'";
		int  m_ps_value =0 ;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			p9ilpk_policy.P_UPD_DATE_GLOBAL();
			connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(query, connection);
			if (rs1.next()) {
				 m_ps_value = rs1.getInt(1);
			}
			
			
			/*Modified by Saranya on 07/04/2017
			 * 
			 * if(dummy_action.getDUMMY_BEAN().getGENERAL_INS().equalsIgnoreCase("true"))*/
			if(CommonUtils.nvl(dummy_action.getDUMMY_BEAN().getGENERAL_INS(),"N").equalsIgnoreCase("true"))
			{
				dummy_action.getDUMMY_BEAN().setGENERAL_INS("Y");
			}
			else 
			{
				dummy_action.getDUMMY_BEAN().setGENERAL_INS("N");
			}
			
			
			if(m_ps_value == 1 ) {
				
				if ("Y".equals(dummy_action.getDUMMY_BEAN().getGENERAL_INS())) {
					p9ilpk_policy.IL_DAILY_DRIP(CommonUtils
							.getProcedureValue(dummy_action.getDUMMY_BEAN()
									.getUI_M_DRIPPING_DT()), dummy_action
									.getDUMMY_BEAN().getUI_M_POL_NO());
					p9ilpk_policy.Il_Subseq_Daily_Drip(CommonUtils
							.getProcedureValue(dummy_action.getDUMMY_BEAN()
									.getUI_M_DRIPPING_DT()), dummy_action
									.getDUMMY_BEAN().getUI_M_POL_NO());
					p9ilpk_policy.IL_CANCEL_DRIP(CommonUtils
							.getProcedureValue(dummy_action.getDUMMY_BEAN()
									.getUI_M_DRIPPING_DT()), dummy_action
									.getDUMMY_BEAN().getUI_M_POL_NO());
					p9ilpk_policy.P_SUMMARY_TAB_UPDATE(dummy_action.getDUMMY_BEAN()
							.getUI_M_POL_NO(), CommonUtils
							.getProcedureValue(dummy_action.getDUMMY_BEAN()
									.getUI_M_DRIPPING_DT()));
				}
			}else{
				/* Commented by saranya as per siva sir suggested on 07-04-2017
				 * 
				 * if("Y".equalsIgnoreCase(dummy_action.getDUMMY_BEAN().getGENERAL_INS())){*/
				p9ilpk_policy.P_INS_UPD_MULTI_PREM_COLL(dummy_action.getDUMMY_BEAN().getUI_M_POLICY_FM(),dummy_action.getDUMMY_BEAN().getUI_M_POLICY_TO(),
						dummy_action.getDUMMY_BEAN().getUI_M_FM_DT(),dummy_action.getDUMMY_BEAN().getUI_M_TO_DT(),null,null);
				/*}*/
			}
			

			/*Modified by Saranya on 07/04/2017
			 * 
			 * if(dummy_action.getDUMMY_BEAN().getLIFE_INS().equalsIgnoreCase("true"))*/
			if(commonUtils.nvl(dummy_action.getDUMMY_BEAN().getLIFE_INS(),"N").equalsIgnoreCase("true"))
			{
				dummy_action.getDUMMY_BEAN().setLIFE_INS("Y");
			}
			else 
			{
				dummy_action.getDUMMY_BEAN().setLIFE_INS("N");
			}
			
			if ("Y".equals(dummy_action.getDUMMY_BEAN().getLIFE_INS())) {
				p9ilpk_policy.P_FUND_REG_ALLOCATION(dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_FM(), dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_TO(), dummy_action
						.getDUMMY_BEAN().getUI_M_PROD_FM(), dummy_action
						.getDUMMY_BEAN().getUI_M_PROD_TO(), CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_FM_DT()), CommonUtils
								.getProcedureValue(dummy_action.getDUMMY_BEAN()
										.getUI_M_TO_DT()));
				p9ilpk_policy.p_drip_unit_sel_new(CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_DRIPPING_DT()),dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_FM(), dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_TO());
				p9ilpk_policy.P_GET_TOPUP_FUND_UNITS(dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_FM(), dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_TO(), dummy_action
						.getDUMMY_BEAN().getUI_M_PROD_FM(), dummy_action
						.getDUMMY_BEAN().getUI_M_PROD_TO(), CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_FM_DT()), CommonUtils
								.getProcedureValue(dummy_action.getDUMMY_BEAN()
										.getUI_M_TO_DT()));
			}
			
			/*Modified by Saranya on 07/04/2017
			 * 
			 * if(dummy_action.getDUMMY_BEAN().getUI_M_ACCNT_GEN_YN().equalsIgnoreCase("true"))*/
			if(commonUtils.nvl(dummy_action.getDUMMY_BEAN().getUI_M_ACCNT_GEN_YN(),"N").equalsIgnoreCase("true"))
			{
				dummy_action.getDUMMY_BEAN().setUI_M_ACCNT_GEN_YN("Y");
			}
			else 
			{
				dummy_action.getDUMMY_BEAN().setUI_M_ACCNT_GEN_YN("N");
			}
			
			/*Modified by Saranya on 07/04/2017
			 * 
			 * if ("Y".equals(dummy_action.getDUMMY_BEAN().getUI_M_ACCNT_GEN_YN())) {*/
			if ("Y".equals(commonUtils.nvl(dummy_action.getDUMMY_BEAN().getUI_M_ACCNT_GEN_YN(),"N"))) {
				p9ilpk_policy.l_acc_daily_drip(dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_FM(), dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_TO(), CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_FM_DT()), CommonUtils
								.getProcedureValue(dummy_action.getDUMMY_BEAN()
										.getUI_M_TO_DT()));
				p9ilpk_policy.l_acc_daily_sub_drip(dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_FM(), dummy_action.getDUMMY_BEAN()
						.getUI_M_POLICY_TO(), CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_FM_DT()), CommonUtils
								.getProcedureValue(dummy_action.getDUMMY_BEAN()
										.getUI_M_TO_DT()));
				p9ilpk_policy.gen_accnt_unit_purchase(dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_FM(), dummy_action
						.getDUMMY_BEAN().getUI_M_POLICY_TO(), CommonUtils
						.getProcedureValue(dummy_action.getDUMMY_BEAN()
								.getUI_M_FM_DT()), CommonUtils
								.getProcedureValue(dummy_action.getDUMMY_BEAN()
										.getUI_M_TO_DT()), "N");

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		 catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	 * newly added by lakshman for validate policy number
	 */
	public void checkValidPOlicy(String value) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		String m_status = null;
		CRUDHandler handler =  new CRUDHandler();
		String C1 = "SELECT POL_APPRV_STATUS FROM PT_IL_POLICY WHERE POL_NO = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{value});
			if(resultSet.next()){
				m_status = resultSet.getString(1);
			}
			if(m_status != null && (!(m_status.isEmpty())) && m_status.equalsIgnoreCase("N")){
				throw new Exception("Not a Valid Policy");
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

	public void nameChange(PP039_A_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		String query = "SELECT ps_value FROM PP_SYSTEM WHERE PS_TYPE='IL_CALC_MTHD'";
		int m_ps_value = 0;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();

		try {

			connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(query, connection);
			if (rs1.next()) {
				m_ps_value = rs1.getInt(1);
			}
			if (m_ps_value == 2) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_CAPTION_LABEL()
						.setValue("Daily Dripping Process");
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_CAPTION_LABEL()
						.setValue(
								Messages.getString("messageProperties_PP039_A",
										"PP039_A$DUMMY_HEADER$caption"));
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}
}

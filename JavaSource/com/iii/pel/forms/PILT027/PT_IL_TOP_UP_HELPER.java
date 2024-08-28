package com.iii.pel.forms.PILT027;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_CONTRI_CHARGE;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PM_IL_DOC_TODO_GROUP;
import com.iii.pel.forms.PILT003_APAC.PT_IL_PREM_COLL;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TOP_UP_HELPER {
	P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
	P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
	public void when_validate_tu_cust_code() {

		ResultSet rs = null;
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String C1 = "SELECT CUST_NAME,CUST_REF_ID1,CUST_REF_ID2 FROM PM_CUSTOMER WHERE CUST_CODE ='"
				+ actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN().getTU_CUST_CODE() + "' ";

		String C2 = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_CUST_CODE ='"
				+ actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN().getTU_CUST_CODE()
				+ "' AND POL_APPRV_STATUS IN ('A','E','R')  AND POL_DS_TYPE='2' "
				+ "AND POL_PREM_PAY_YRS >=(SELECT  DISTINCT PROD_TOPUP_MIN_YRS "
				+ "FROM PM_IL_PRODUCT WHERE  POL_PROD_CODE=PROD_CODE AND     PROD_TOPUP_YN ='Y')";

		try {
			if (actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_CUST_CODE() != null) {
				rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils.getConnection());
				if (rs.next()) {
					String CUST_NAME = rs.getString("CUST_NAME");
					// CUST_REF_ID1
					// CUST_REF_ID2
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setUI_M_TU_CUST_NAME(CUST_NAME);
					//UI_M_TU_CUST_NAME
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_UI_M_TU_CUST_NAME().setSubmittedValue(CUST_NAME);
					
				} else {
					String message = Messages.getString(PELConstants.pelErrorMessagePath, "1007");
					throw new ValidatorException(new FacesMessage(message));
				}
				rs.close();
				rs = new CRUDHandler().executeSelectStatement(C2, CommonUtils.getConnection());
				if (rs.next()) {
					String POL_NO = rs.getString("POL_NO");
					// CUST_REF_ID1
					// CUST_REF_ID2
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setTU_POL_NO(POL_NO);
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_TU_POL_NO().setSubmittedValue(POL_NO);
				}
				rs.close();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void when_validate_tu_bank_code() {

		ResultSet rs = null;
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String C1 = "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE ='"
				+ actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN().getTU_BANK_CODE() + "' ";
		try {
			if (actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_BANK_CODE() != null) {
				rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils.getConnection());
				if (rs.next()) {
					String BANK_NAME = rs.getString("BANK_NAME");
					// CUST_REF_ID1
					// CUST_REF_ID2
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setUI_M_TU_BANK_NAME(BANK_NAME);
					//UI_M_TU_CUST_NAME
					actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_UI_M_TU_BANK_NAME().setSubmittedValue(BANK_NAME);
					
				} 
				
				rs.close();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void when_validate_tu_pol_no(PILT027_COMPOSITE_ACTION actionBean) throws Exception {
		ResultSet rs = null;
		CommonUtils utility = new CommonUtils();
 		String temp = null;
		try {
			if (actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
					.getTU_CUST_CODE() != null
					&& !actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
							.getPT_IL_TOP_UP_BEAN().getTU_CUST_CODE().isEmpty()) {
				temp = actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN().getTU_CUST_CODE();
			} else {
				temp = "POL_CUST_CODE";
			}
         /*  Surrender and maturity status 'S','M'added in c1 cursor and status 'P' removed for 
			ssp call id ZBLIFE-1463700 on 18/12/17*/
			String C1 = "SELECT POL_SYS_ID,POL_SA_CURR_CODE,POL_SA_EXCH_RATE,POL_PROD_CODE,"
					+ " POL_START_DT,POL_CUST_CODE,CUST_NAME FROM PT_IL_POLICY,PM_CUSTOMER,PM_IL_PRODUCT "
					+ "WHERE POL_CUST_CODE = CUST_CODE "
					+ "AND POL_PROD_CODE = PROD_CODE "
					+ "AND POL_NO = '"
					+ actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
							.getPT_IL_TOP_UP_BEAN().getTU_POL_NO()
					+ "'"
					+ "AND POL_APPRV_STATUS IN ('A','E','R')  "
					+ "AND POL_STATUS NOT IN ('N','C','L','T','D','S','M') "
					+ "AND POL_DS_TYPE ='2' "
					+ "AND POL_PREM_PAY_YRS >= PROD_TOPUP_MIN_YRS "
					+ "AND PROD_TOPUP_YN = 'Y' "
					+ "AND POL_CUST_CODE = '"
					+ temp + "'";

			System.out.println("C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1..." + C1);

			rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils
					.getConnection());
			if (rs.next()) {
				Integer POL_SYS_ID = rs.getInt("POL_SYS_ID");
				String POL_SA_CURR_CODE = rs.getString("POL_SA_CURR_CODE");
				Double POL_SA_EXCH_RATE = rs.getDouble("POL_SA_EXCH_RATE");
				String POL_PROD_CODE = rs.getString("POL_PROD_CODE");
				Date POL_START_DT = rs.getDate("POL_START_DT");
				String POL_CUST_CODE = rs.getString("POL_CUST_CODE");
				String CUST_NAME= rs.getString("CUST_NAME");
				
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.setTU_POL_SYS_ID(POL_SYS_ID);
				
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
				.setUI_M_POL_SA_CURR_CODE(POL_SA_CURR_CODE);
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
				.setUI_M_POL_SA_EXCH_RATE(POL_SA_EXCH_RATE);
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
				.setUI_M_POL_PROD_CODE(POL_PROD_CODE);
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.setM_POL_START_DATE(POL_START_DT);
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.setTU_CUST_CODE(POL_CUST_CODE);
				actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.setUI_M_TU_CUST_NAME(CUST_NAME);

			} else {
				String message ="Invalid Policy!";
					/*Messages.getString(
						PELConstants.pelErrorMessagePath, "1804")*/
				throw new Exception(message);
			}
			
			/*Added by saritha on 04-09-2017 for ssp call id ZBILQC-1733101*/
			validateTopupCollection(actionBean);
			/*End*/
			rs.close();
		} catch (Exception e) {
			throw new Exception((e.getMessage()));
		}
	}

	public void when_validatetu_lc_topup_dep_amt() throws Exception {

		ResultSet rs = null;
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String temp=null;
		try {
			
			if(actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT()!=null
					&&actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getM_PROD_TOPUP_LC_MIN_AMT()!=null
					&&actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getM_PROD_TOPUP_LC_MAX_AMT()!=null){
                Double TU_LC_TOPUP_DEP_AMT=actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT();
                Double M_PROD_TOPUP_LC_MIN_AMT=actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getM_PROD_TOPUP_LC_MIN_AMT();
             	Double M_PROD_TOPUP_LC_MAX_AMT=actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getM_PROD_TOPUP_LC_MAX_AMT();
			    if(TU_LC_TOPUP_DEP_AMT<M_PROD_TOPUP_LC_MIN_AMT&&TU_LC_TOPUP_DEP_AMT>M_PROD_TOPUP_LC_MAX_AMT){
			    	String message = Messages.getString(PELConstants.pelErrorMessagePath, "91356");
					throw new Exception(message);
			    }
             	
			
			}
				
				rs.close();
		} catch (Exception e) {
			throw new Exception((e.getMessage()));
		}

	}
	
	public void postInsert(PILT027_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query="SELECT DDCHG_CODE,DDCHG_RATE,DDCHG_RATE_PER,DDCHG_APPLIED_ON FROM PM_IL_DOC_DFLT_CHARGE " +
				" WHERE DDCHG_DS_TYPE = ? " +
				" AND DDCHG_DS_CODE = ?  ";
		String insertRecord="INSERT INTO  PT_IL_DEPOSIT_CHARGE(" +
				"	DCHRG_DEP_SYS_ID, DCHRG_CODE,DCHRG_RATE,DCHRG_RATE_PER," +
				"	DCHRG_TYPE,DCHRG_CR_DT,DCHRG_FLEX_01,DCHRG_CR_UID )	" +
				"VALUES(?, ?,?,?,'TP',SYSDATE,?,?)";
		
		
		String M_DDCHG_CODE = null;
		Double M_DDCHG_RATE = null;
		Double M_DDCHG_RATE_PER = null;
		String M_DDCHG_APPLIED_ON = null;
		ArrayList<OracleParameter> pvalList_Topup = new ArrayList<OracleParameter>();
		/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
		String planTypeQuery = "SELECT PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND POL_NO = ?";
		ResultSet planTypeRs = null;
		String plan_type = null;
		/*End*/
		try {
			pvalList_Topup = new ArrayList<OracleParameter>();
			/*
			 * modified by Ameen 16-05-2017 as per Gaurav sugg.
			 * pvalList_Topup = 	p9ilpk_fund_alloc.GET_TOPUP_CHARGE_NEW(compositeAction
					.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
					.getTU_POL_SYS_ID(), compositeAction
					.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
					.getTU_SYS_ID(),compositeAction
					.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT() );*/

			planTypeRs = new CRUDHandler().executeSelectStatement(planTypeQuery, CommonUtils.getConnection(),
					new Object[]{compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_NO()});
			if(planTypeRs.next()){
				plan_type = planTypeRs.getString("PLAN_TYPE");
			}
			System.out.println("plan_type ===========>>>>>" + plan_type);
			if(!"H".equalsIgnoreCase(plan_type)){
				pvalList_Topup = 	p9ilpk_fund_alloc.GET_TOPUP_CHARGE_NEW(compositeAction
						.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.getTU_POL_SYS_ID(), compositeAction
						.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
						.getTU_SYS_ID(),compositeAction
						.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT() );
			}
			/*End*/
			
			/*if (pvalList_Topup != null || !pvalList_Topup.isEmpty()) 
			{
				if (pvalList_Topup.get(0).getValueObject()  != null)
				{
					compositeAction
					.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setTU_LC_TOPUP_NET_AMT((Double)pvalList_Topup.get(0).getValueObject());
				}
			}*/
			/*
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, 
							new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"),
										 CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")
										 });
			while(resultSet.next()){
				M_DDCHG_CODE = resultSet.getString(1);
				M_DDCHG_RATE = resultSet.getDouble(2);
				M_DDCHG_RATE_PER = resultSet.getDouble(3);
				M_DDCHG_APPLIED_ON = resultSet.getString(4);
				compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setUI_M_DCHRG_TOTAL_FC_AMT(CommonUtils.nvl(M_DDCHG_RATE,0));
				// P_VAL_ROUND_AMT (:PT_IL_TOP_UP.M_POL_SA_CURR_CODE,  :M_DCHRG_TOTAL_FC_AMT,'V');
				compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setUI_M_DCHRG_TOTAL_FC_AMT( 
							CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().getUI_M_DCHRG_TOTAL_LC_AMT(),0)   *
							CommonUtils.nvl(compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getUI_M_POL_SA_EXCH_RATE(),0));
				
				handler.executeInsertStatement(insertRecord, connection,new Object[]
			                   {compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_SYS_ID(),
								M_DDCHG_CODE,
								M_DDCHG_RATE,
								M_DDCHG_RATE_PER,
								M_DDCHG_APPLIED_ON,
								CommonUtils.getControlBean().getUSER_ID()});
			}
			*/
		} /*catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}*/catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void whenCreateReacord(PT_IL_TOP_UP topUpBean){
		try {
			String bankCode = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3");
			topUpBean.setTU_BANK_CODE(bankCode);
			topUpBean.setTU_DOC_DT(new CommonUtils().substractDate(new CommonUtils().getCurrentDate(),-1));
			topUpBean.setTU_DATE( new CommonUtils().substractDate(new CommonUtils().getCurrentDate(),-1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	
	public void  isFundAllocationCompleted(PILT027_COMPOSITE_ACTION  compositeAction) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_TOP_UP topUpBean = compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN();
		String query = " SELECT TU_UNIT_YN  FROM PT_IL_TOP_UP WHERE TU_POL_SYS_ID = ? AND TU_SYS_ID = ? ";
		/*String query=" SELECT * FROM PT_IL_TOPUP_FUND_DTL,PT_IL_TOP_UP,PS_IL_UNIT_FUND_REG WHERE " +
				" PS_IL_UNIT_FUND_REG.UFR_POL_SYS_ID = ? " +
				" AND TOFD_POL_SYS_ID=TU_POL_SYS_ID AND TOFD_FUND_DIR_TYPE='T' AND" +
				" UFR_POL_SYS_ID=TOFD_POL_SYS_ID AND TU_POL_SYS_ID=UFR_POL_SYS_ID " +
				" AND TU_SYS_ID=TOFD_TU_SYS_ID AND nvl(UFR_TOP_UP_UNITS,0)>0";
;*/
			String unitYn = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, 
						new Object[]{topUpBean.getTU_POL_SYS_ID(),topUpBean.getTU_SYS_ID()});
			if(resultSet.next()){
				unitYn = resultSet.getString(1);
				if("Y".equals(unitYn)){
				compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().disableAllComponent(true);
				compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().disableAllComponent(true);
				compositeAction.getPT_IL_FUND_DETAIL_ACTION_BEAN().disableAllComponent(true);
				}
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WHEN_BUTTON_PRESS_M_BUT_APPRV(PILT027_COMPOSITE_ACTION pilt027_composite_action) throws Exception {
		
		Double UI_M_PD_LC_AMT = 0.0;
		String M_TEMP = null;
		String FUND_DTL=null;
		String C1 = "SELECT   'X' FROM    PT_IL_PYMT_DTLS WHERE   " +
				"PD_TXN_TYPE = 'TP' AND   PD_TXN_SYS_ID = ?  " +
				"GROUP BY  PD_TXN_SYS_ID";
		
		/*Added by saritha on 29-07-2017 for ssp call id ZBILQC-1733101*/
		/*String C2 ="SELECT 'X' FROM PT_IL_TOPUP_FUND_DTL WHERE TOFD_POL_SYS_ID=? AND TOFD_TU_SYS_ID=?"; */
		String C2 ="SELECT 'X' FROM PT_IL_TOPUP_FUND_DTL WHERE TOFD_TU_SYS_ID=?"; 
		/*End*/

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con, 
					new Object[] { pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_SYS_ID() });
			if (pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().
					getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT() >= 0) {
				if (rs1.next()) {
					M_TEMP = rs1.getString(1);
				} else {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91171"));
					// STD_MESSAGE_ROUTINE(91171,:CTRL.M_LANG_CODE);
					// RAISE FORM_TRIGGER_FAILURE;
				}}
			
			/*Added by saritha on 29-07-2017 for ssp call id ZBILQC-1733101*/
			pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().fetchPlanProdDetails(pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_POL_NO());
			if(!"H".equalsIgnoreCase(pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPlanType()) && !"Y".equalsIgnoreCase(pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getProdIntrSavingYN())){
			
			rs2 = handler.executeSelectStatement(C2, con, 
					new Object[] {pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_SYS_ID()});
			
				if (rs2.next()) {
					FUND_DTL = rs2.getString(1);
				} else {
					throw new Exception(
							Messages
							.getString(
									PELConstants.pelErrorMessagePath,
									"4725"));

				}
			}
			
			/*End*/
			
			p9ilpk_policy.APPROVE_TOP_UP(pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN()
					.getTU_SYS_ID());
			new PT_IL_TOP_UP_DELEGATE()
			.executeSelectStatement(pilt027_composite_action);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private BaseValueBean PT_IL_FUND_DETAIL_BEAN() {
		// TODO Auto-generated method stub
		return null;
	}

	public void WHEN_BUTTON_PRESSED_PYMT_DTLS(PILT027_COMPOSITE_ACTION pilt027_composite_action) throws Exception{
		Connection con = null;
		Double exchngrate = 0.0;
		PT_IL_TOP_UP pt_il_topup_bean = pilt027_composite_action
				.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN();
		String query = "SELECT POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		con = CommonUtils.getConnection();
		rs=handler.executeSelectStatement(query, con,new Object[]{pt_il_topup_bean.getTU_POL_SYS_ID()});
		if(rs.next()){
			exchngrate = rs.getDouble(1);
		}
		CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "TP");
		CommonUtils.setGlobalObject("GLOBAL.G_DEP_REF_NO", pt_il_topup_bean
				.getTU_PD_DPD_REF_ID());
		CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID", pt_il_topup_bean.getTU_SYS_ID());
		CommonUtils.setGlobalObject("GLOBAL.FC_AMT", pt_il_topup_bean.getTU_LC_TOPUP_DEP_AMT());
		CommonUtils.setGlobalObject("GLOBAL.LC_AMT", pt_il_topup_bean.getTU_LC_TOPUP_DEP_AMT());
		CommonUtils.setGlobalObject("CALLING_FORM", "PILT027");
		CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE",exchngrate);
		try {
			if (pilt027_composite_action
					.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN()
					.getPT_IL_DEPOSIT_CHARGE_BEAN()
					.getUI_M_DCHRG_TOTAL_LC_AMT() != null) {
				
				Double topupamt=(Double)CommonUtils.getGlobalObject("TOp_UP_LX");
				pilt027_composite_action
						.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN()
						.setTU_LC_TOPUP_CHRG_AMT(
								CommonUtils
										.nvl(
												topupamt,
												0));
				pilt027_composite_action
						.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN()
						.setTU_LC_TOPUP_NET_AMT(
								(CommonUtils
										.nvl(
												pilt027_composite_action
														.getPT_IL_TOP_UP_ACTION_BEAN()
														.getPT_IL_TOP_UP_BEAN()
														.getTU_LC_TOPUP_DEP_AMT(),
												0))
										- (CommonUtils
												.nvl(
														pilt027_composite_action
																.getPT_IL_TOP_UP_ACTION_BEAN()
																.getPT_IL_TOP_UP_BEAN()
																.getTU_LC_TOPUP_CHRG_AMT(),
														0)));

				if ((CommonUtils.nvl(pilt027_composite_action
						.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN()
						.getPT_IL_DEPOSIT_CHARGE_BEAN()
						.getUI_M_DCHRG_TOTAL_LC_AMT(), 0)) > (CommonUtils
						.nvl(pilt027_composite_action
								.getPT_IL_TOP_UP_ACTION_BEAN()
								.getPT_IL_TOP_UP_BEAN()
								.getTU_LC_TOPUP_DEP_AMT(), 0))) {
					throw new Exception("Charge Amount Cannot be Greater than Deposited amount");

				}
				/*
				 * need to check
				 */
				/*IF :PT_IL_TOP_UP.M_APPRV_STATUS = 'Approved' THEN
			  	SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',UPDATE_ALLOWED,PROPERTY_FALSE);	 
			  	SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);  	 
			  
			  	SET_BLOCK_PROPERTY('PT_IL_TOP_UP',UPDATE_ALLOWED,PROPERTY_FALSE); 
			ELSE	 
				SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',INSERT_ALLOWED,PROPERTY_TRUE);	 
				  SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',UPDATE_ALLOWED,PROPERTY_TRUE);	 
				 
				  SET_BLOCK_PROPERTY('PT_IL_TOP_UP',UPDATE_ALLOWED,PROPERTY_FALSE);
			END IF;	
			if (pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
							.getPT_IL_TOP_UP_BEAN().getTU_APPRV_STATUS()
							.equals("A")) {
						this.setUPDATE_ALLOWED(false);
						this.setINSERT_ALLOWED(false);
					} else {
						this.setUPDATE_ALLOWED(true);
						this.setINSERT_ALLOWED(true);
					}*/
}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	
}
	
	
	public void whenValidateReasonCode(String reasonCode,
			PT_IL_TOP_UP PT_IL_TOP_UP_BEAN)
	throws Exception {
		//ArrayList<String> list = null;
		String query = "  SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_REASON' AND PC_CODE LIKE ? ";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String reasonCodeDesc=null;
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, con,new Object[]{reasonCode});
			if(rs.next())
			{
		
				reasonCodeDesc=rs.getString(1);
			}
			PT_IL_TOP_UP_BEAN.setUI_M_REASON_DESC(reasonCodeDesc);
			/*if (formulaCode != null) {
				list = new DBProcedures().P_VAL_CODES("SRC_BUS_TY",
						PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_FLEX_01(), null,
						"N", "E", null);
				if (list != null && list.size() > 0) {
					PM_IL_PROD_CONTRI_CHARGE_BEAN
							.setUI_M_FORMULA_CODE_DESC((list.get(0)));
				}
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void freeze(PILT027_COMPOSITE_ACTION pilt027_composite_action) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String M_APPRV_STATUS= null;
		String query="SELECT TU_APPRV_STATUS FROM PT_IL_TOP_UP WHERE TU_SYS_ID = ?";
		try{
			connection = CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query, connection, new Object[]{pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_SYS_ID()});
			if(resultSet.next())
			{
				M_APPRV_STATUS=resultSet.getString(1);
				CommonUtils.setGlobalVariable("PILT027_APP_STA", M_APPRV_STATUS);
			}
			if(CommonUtils.nvl(M_APPRV_STATUS,"N").equalsIgnoreCase("Y"))
			{
				
				pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_UI_M_BUT_SAVE().setDisabled(true);
				pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_UI_M_BUT_DELETE().setDisabled(true);
				pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
				pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().disableAllComponent(true);
				pilt027_composite_action.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().disableAllComponent(true);
				pilt027_composite_action.getPT_IL_FUND_DETAIL_ACTION_BEAN().disableAllComponent(true);
				//pilt027_composite_action.getPT_IL_FUND_DETAIL_ACTION_BEAN().getCOMP_UI_M_BUT_SAVE().setDisabled(true);
				pilt027_composite_action.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getCOMP_UI_M_BUT_SAVE().setDisabled(true);
				pilt027_composite_action.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(true);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void whenValidateTopupDepositAmount(PT_IL_TOP_UP PT_IL_TOP_UP_BEAN) throws Exception
	{
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Double M_PROD_TOPUP_MULTIPLE = null;
		String M_PTP_MODE_OF_PYMT = null;
		Double M_PTP_LC_MIN_AMT = null;
		Double M_PTP_LC_MAX_AMT = null;
		String M_POL_MODE_OF_PYMT = null;

		String query = "SELECT PROD_TOPUP_MULTIPLE FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ?)";
		String query1 = "SELECT PTP_MODE_OF_PYMT,PTP_LC_MIN_AMT,PTP_LC_MAX_AMT FROM PM_IL_PROD_TOPUP_PARAM WHERE PTP_MODE_OF_PYMT=? AND PTP_PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ?) ";
		String query2 = "SELECT POL_MODE_OF_PYMT FROM PT_IL_POLICY WHERE POL_SYS_ID= ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { PT_IL_TOP_UP_BEAN.getTU_POL_NO() });
			if (resultSet.next()) {
				M_PROD_TOPUP_MULTIPLE = resultSet.getDouble(1);
			}
			if (((PT_IL_TOP_UP_BEAN.getTU_LC_TOPUP_DEP_AMT()) % (M_PROD_TOPUP_MULTIPLE)) != 0) {
				throw new Exception("Topup DepositAmount should be multiple of"
						+ M_PROD_TOPUP_MULTIPLE);
			}
			resultSet2 = handler.executeSelectStatement(query2, connection,
					new Object[] { PT_IL_TOP_UP_BEAN.getTU_POL_SYS_ID() });
			if (resultSet2.next()) {
				M_POL_MODE_OF_PYMT = resultSet2.getString(1);
			}
			resultSet1 = handler.executeSelectStatement(query1, connection,
					new Object[] { M_POL_MODE_OF_PYMT,PT_IL_TOP_UP_BEAN.getTU_POL_NO() });
			if (resultSet1.next()) {
				M_PTP_MODE_OF_PYMT = resultSet1.getString(1);
				M_PTP_LC_MIN_AMT = resultSet1.getDouble(2);
				M_PTP_LC_MAX_AMT = resultSet1.getDouble(3);
			}
			if (M_POL_MODE_OF_PYMT.equalsIgnoreCase(M_PTP_MODE_OF_PYMT)) {
				if (PT_IL_TOP_UP_BEAN.getTU_LC_TOPUP_DEP_AMT() != null) {
					if ((PT_IL_TOP_UP_BEAN.getTU_LC_TOPUP_DEP_AMT() > M_PTP_LC_MAX_AMT)
							|| (PT_IL_TOP_UP_BEAN.getTU_LC_TOPUP_DEP_AMT() < M_PTP_LC_MIN_AMT)) {
						throw new Exception(
								"Top up Amount should be within the limit");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*Added by saritha on 04-09-2017 for ssp call id ZBILQC-1733101*/
	public void validateTopupCollection(PILT027_COMPOSITE_ACTION pilt027_composite_action) throws Exception{

		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = ? AND CLAIM_TYPE IN ('A','D')";
		try {
			connection = CommonUtils.getConnection();
			System.out.println("PolSysid "+pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID());
			resultSet = handler.executeSelectStatement(C1, connection, 
					new Object[]{pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID()});
			if(resultSet.next()){
				throw new Exception("Death Claim Already Registered Cannot Proceed");
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
	/*End*/
	
}

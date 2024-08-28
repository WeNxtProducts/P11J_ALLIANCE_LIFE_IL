package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_END_OF_DAY_PROC;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.pel.utils.P9ILPK_WITHDRAWAL_PROCESS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
	P9ILPK_WITHDRAWAL_PROCESS p9ilpk_withdrawal_process = new P9ILPK_WITHDRAWAL_PROCESS();
	PILT021_PROCEDURES pilt021_procedures = new PILT021_PROCEDURES();
	PKG_PILT021 pkg_pilt021 = new PKG_PILT021();
	
	public String WHEN_BUTTON_PRESSED_M_BUT_POL_HIST(PT_IL_WITHDRAWAL pt_il_withdrawal){
		CommonUtils.setGlobalVariable("GLOBAL.POL_NO", pt_il_withdrawal.getUI_M_POL_NO());
		return 	"PILQ002";
	}
	public String WHEN_BUTTON_PRESSED_M_BUTTON_APPROVE(PILT021_COMPOSITE_ACTION compositeAction)
	throws Exception{
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		PT_IL_WITHDRAWAL_ACTION pt_il_withdrawal_action = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL pt_il_withdrawal_bean = pt_il_withdrawal_action.getPT_IL_WITHDRAWAL_BEAN();
		HashMap<String, String> outValueMap = new HashMap<String, String>();
		String M_APPRV_STATUS = null;
		int M_WD_SYS_ID = 0;
		String M_FTD_FUND_CODE = null;
		int M_FTD_NO_OF_UNITS = 0;
		int M_FTD_UNIT_SEL_PRICE = 0;
		int M_FTD_NO_ALLOC_LC_AMT = 0;
		int M_FTD_NO_SEL_UNITS = 0;
		int M_LATEST_SEL_PRICE = 0;
		String M_PLAN_TYPE = null;
		int M_PWPH_MAX_NO_WITHDRAW = 0;
		int M_COUNT = 0, UPDATEC7 = 0, UPDATEC8 = 0;
		int M_UFR_NO_OF_UNITS = 0;
		String C1 = null, C2 = null, C3 = null, C4 = null, C5 = null, C6 = null, C7 = null, C8 = null;
		String M_DUMMY = null;
		String M_DUMMY2 = null;
		String pt_il_withdrawal = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		ResultSet resultSetC6 = null;
		Object[] values1 = {};
		Object[] values2 = {};
		Object[] values3 = {};
		Object[] values4 = {};
		Object[] values5 = {};
		Object[] values6 = {};
		Object[] values7 = {};
		Object[] values8 = {};
		CRUDHandler handler = null;

		C1 = " SELECT WD_APPRV_STATUS FROM PT_IL_WITHDRAWAL WHERE  WD_POL_SYS_ID = ?" +
				" AND NVL(WD_APPRV_STATUS,'N') = 'N'";
		
		C2 = " SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE=(SELECT POL_PLAN_CODE" +
				" FROM PT_IL_POLICY WHERE  POL_SYS_ID= ?)";
		
		C3 = " SELECT PWPH_MAX_NO_WITHDRAW FROM PM_IL_PROD_WD_PARAM_HDR WHERE " +
				"PWPH_PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE  POL_SYS_ID= ?)";
		
		C4 = " SELECT COUNT(*) FROM	 PT_IL_WITHDRAWAL WHERE WD_POL_SYS_ID = ? AND " +
				"NVL(WD_APPRV_STATUS,'N') = 'A' ";
		
		C5 = " SELECT 'X' FROM PT_IL_UNIT_FUND_REG_HDR,PT_IL_UNIT_FUND_REG_DTL WHERE " +
				"UFRH_SYS_ID = UFRD_UFRH_SYS_ID AND UFRH_POL_NO = ? AND UFRH_TRANS_SYS_ID = ?";
		
		C6 = " SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_WD_SYS_ID= ? " +
				"AND DTLS_MANDATORY_YN='Y' AND NVL(DTLS_APPR_STS,'N')='N'";
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(dummy_bean.getROWID() != null){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath,"71048",new Object[] {
								CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")}));
			}
			pilt021_procedures.L_WITHDRAW_CHK(pt_il_withdrawal_bean.getWD_FLEX_01(), 
					dummy_bean, pt_il_withdrawal_bean);
			values6 = new Object[]{pt_il_withdrawal_bean.getWD_SYS_ID()};
			resultSetC6 = handler.executeSelectStatement(C1,connection,values6);
			if(resultSetC6.next()){
				M_DUMMY2 = resultSetC6.getString(1);
			}
			if("X".equals(CommonUtils.nvl(M_DUMMY2,"N"))){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath,"91576",
						new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")}));
			}
			values3 = new Object[]{pt_il_withdrawal_bean.getWD_POL_SYS_ID()};
			resultSetC3 = handler.executeSelectStatement(C3,connection,values3);
			if(resultSetC3.next()){
				M_PWPH_MAX_NO_WITHDRAW = resultSetC3.getInt(1);
			}
			values4 = new Object[]{pt_il_withdrawal_bean.getWD_POL_SYS_ID()};
			resultSetC4 = handler.executeSelectStatement(C4, connection,values4);
			if(resultSetC4.next()){
				M_COUNT = resultSetC4.getInt(1);
			}
			if(M_COUNT >= M_PWPH_MAX_NO_WITHDRAW){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath,"91200",
						new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")}));
			}
			values2 = new Object[]{pt_il_withdrawal_bean.getWD_POL_SYS_ID()};
			resultSetC2 = handler.executeSelectStatement(C2,connection,values2);
			if(resultSetC2.next()){
				M_PLAN_TYPE = resultSetC2.getString(1);
			}
			values1 = new Object[]{pt_il_withdrawal_bean.getWD_POL_SYS_ID()};
			resultSetC1 = handler.executeSelectStatement(C1,connection,values1);
			if(resultSetC1.next()){
				M_APPRV_STATUS = resultSetC1.getString(1);
			}
			if("N".equals(CommonUtils.nvl(M_APPRV_STATUS, "N"))){
				//SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY');
				if(M_PLAN_TYPE == "U"){
					values5 = new Object[]{pt_il_withdrawal_bean.getUI_M_POL_NO(),
							pt_il_withdrawal_bean.getWD_SYS_ID()};
					resultSetC5 = handler.executeSelectStatement(C5,connection,values5);
					if(resultSetC5.next()){
						M_DUMMY = resultSetC5.getString(1);
					}else{
					p9ilpk_fund_alloc.P_TRANS_FUND_REG_HDR_DTL(
							CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_SYS_ID()),
							CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_POL_SYS_ID()),"W");		
					}
				}
			
			p9ilpk_withdrawal_process.DOC_GENERATION_WITHDRAWAL(
					CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_POL_SYS_ID()),
					CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_NUMBER()));
			if("U".equals(pt_il_withdrawal_bean.getWD_TYPE())){
				pkg_pilt021.L_WITHDRAW_UNIT_ENDORSE(
						CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_SYS_ID()), 
						CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_POL_SYS_ID()), 
						CommonUtils.getProcedureValue(pt_il_withdrawal_bean.getWD_DATE()), 
						pt_il_withdrawal_bean.getWD_DOC_NO());
				C7 = "UPDATE PT_IL_WITHDRAWAL_UNIT SET WDU_APPRV_STATUS='A' WHERE WDU_POL_SYS_ID= ?" +
						" AND WDU_WD_SYS_ID= ?";	
				values7 = new Object[]{pt_il_withdrawal_bean.getWD_POL_SYS_ID(),
						pt_il_withdrawal_bean.getWD_SYS_ID()};
				UPDATEC7 = handler.executeUpdateStatement(C7, connection, values7);
			}
			C8 = "UPDATE PT_IL_WITHDRAWAL SET WD_APPRV_UID = ?, WD_APPRV_DT = TRUNC(SYSDATE) " +
					"WHERE WD_POL_SYS_ID = ?";
			values8 = new Object[]{CommonUtils.getControlBean().getUSER_ID(),
					pt_il_withdrawal_bean.getWD_POL_SYS_ID()};
			UPDATEC8 = handler.executeUpdateStatement(C8, connection, values8);
			pt_il_withdrawal_action.setDEFAULT_WHERE("WD_SYS_ID="+pt_il_withdrawal_bean.getWD_SYS_ID());
			new PT_IL_WITHDRAWAL_HELPER().executeQuery(compositeAction);
			pt_il_withdrawal_action.setDEFAULT_WHERE(" ");
			pt_il_withdrawal_action.setUPDATE_ALLOWED(true);
			pt_il_withdrawal_bean.setWD_APPRV_STATUS("A");
			
			/* Newly Added By Dhinesh on 04/04/2018 */
			new CRUDHandler().executeUpdate(pt_il_withdrawal_bean,
					CommonUtils.getConnection());
			new CommonUtils().getConnection().commit();
			/* End */
			
			pt_il_withdrawal_action.setUPDATE_ALLOWED(false);
			/*
			 * commented by Dhinesh on 04-04-2018 
			 * new CommonUtils().doComitt();*/
			if(!"A".equals(CommonUtils.nvl(pt_il_withdrawal_bean.getWD_APPRV_STATUS(), "N"))){
				if(dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().isDisabled() == true){
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(false);
				}
			}
			outValueMap.put("M_YN", "Y");
			outValueMap.put("WARNING", Messages.getString(
					PELConstants.pelErrorMessagePath, "60304", 
					new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"), 
							pt_il_withdrawal_bean.getUI_M_POL_NO()}));
			CommonUtils.setGlobalVariable("GLOBAL.M_WD_SYS_ID", 
					String.valueOf(pt_il_withdrawal_bean.getWD_SYS_ID()));
			pt_il_withdrawal_action.setDEFAULT_WHERE(
					"WD_SYS_ID="+CommonUtils.getGlobalVariable("GLOBAL.M_WD_SYS_ID"));
			new PT_IL_WITHDRAWAL_HELPER().executeQuery(compositeAction);
			dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC4);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC5);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC6);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
		}
		return "PT_IL_WITHDRAWAL";
	}
	
	public void WHEN_BUTTON_PRESSED_M_WITHDRAWAL_STATUS(DUMMY dummy)
	throws Exception{
		if(dummy.getUI_M_WD_STATUS_CODE() != null){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71048"));
		}
		dummy.setUI_M_WD_STATUS_DT(new CommonUtils().getCurrentDate());
		dummy.setUI_M_WD_STATUS_CODE(null);
		dummy.setUI_M_WD_REASON_CODE(null);
		dummy.setUI_M_WD_REMARKS(null);
		dummy.setUI_M_WD_STATUS_CODE_DESC(null);
		dummy.setUI_M_WD_REASON_CODE_DESC(null);
	}
	
	public String WHEN_BUTTON_PRESSED_M_BUT_REP_POLICY(DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal)
	throws Exception{
		String C1 = null, M_POAD_REF_ID1 = null, M_POAD_REF_ID2 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT POAD_REF_ID1, POAD_REF_ID2 FROM PT_IL_POL_ASSURED_DTLS" +
					" WHERE POAD_POL_SYS_ID = (SELECT POL_SYS_ID FROM PT_IL_POLICY" +
					" WHERE POL_NO= ?) AND POAD_TYPE ='R'";
			resultSetC1 = handler.executeSelectStatement(C1, connection, 
					new Object[]{pt_il_withdrawal.getUI_M_POL_NO()});
			while (resultSetC1.next()) {
				M_POAD_REF_ID1 = resultSetC1.getString(1);
				M_POAD_REF_ID2 = resultSetC1.getString(2);
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_POAD_REF_ID1", M_POAD_REF_ID1);
			CommonUtils.setGlobalVariable("GLOBAL.M_POAD_REF_ID2", M_POAD_REF_ID2);
		}finally{
			
		}
		return "PILQ108_APAC";
	}
	public String WHEN_BUTTON_PRESSED_M_BUT_FUND_ALLOC(PT_IL_WITHDRAWAL pt_il_withdrawal){
		CommonUtils.setGlobalVariable("GLOBAL.POL_NO", pt_il_withdrawal.getUI_M_POL_NO());
		CommonUtils.setGlobalVariable("CALLING_FORM","PILT021");
		return 	"PILQ106_APAC";
	}
	
	public String WHEN_BUTTON_PRESSED_M_BUT_PROCESS(PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_WITHDRAWAL_ACTION pt_il_withdrawal_action = null;
		DUMMY_ACTION dummy_action = null;
		try{
		pt_il_withdrawal_action = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_WITHDRAWAL pt_il_withdrawal = pt_il_withdrawal_action.getPT_IL_WITHDRAWAL_BEAN();
		DUMMY dummy = dummy_action.getDUMMY_BEAN();
		dummy.setUI_M_PROCESS_YN(null); 
	
		if(CommonUtils.nvl(pt_il_withdrawal.getWD_RATE(), 0) == 0){
			return "";
		}
	 
		 pt_il_withdrawal_action.setUPDATE_ALLOWED(true);
		  
		// L_CHECK_REPLACE_POLICY;
		 try{
			 if(!"U".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
				 p9ilpk_withdrawal_process.DO_WITHDRAWAL_PROCESS(
						 CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_POL_SYS_ID()), 
						 CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NUMBER()));
			 }
		 }catch(Exception e){
				e.printStackTrace();
			 throw new Exception(e.getMessage());
		 }
		 new CommonUtils().doComitt();
		 pt_il_withdrawal_action.setDEFAULT_WHERE("WD_SYS_ID= "+pt_il_withdrawal.getWD_SYS_ID());
		 new PT_IL_WITHDRAWAL_HELPER().executeQuery(compositeAction);
		 pt_il_withdrawal_action.setDEFAULT_WHERE("");
		 dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
		 dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
		 dummy.setUI_M_PROCESS_YN("Y");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return ""; 
	}
	
	    
		/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
	
	public void checkFreeze(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {

			String C1 ="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS,PM_IL_DOC_TODO_GROUP,PT_IL_WITHDRAWAL,PT_IL_POLICY WHERE DTLS_GROUP_CODE = DTG_GROUP_CODE "
					+ "AND DTLS_WD_SYS_ID = WD_SYS_ID AND WD_POL_SYS_ID = POL_SYS_ID AND DTG_DS_CODE = ? AND WD_NUMBER =  ? AND WD_POL_SYS_ID = ? "
					+ "AND DTLS_MANDATORY_YN = 'Y' AND DTLS_APPR_STS = 'N'"; 
			
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_CODE(),
					              compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_NUMBER(),
					              compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID()});
			if (resultSet.next()) {
				throw new Exception(
						Messages
						.getString(
								PELConstants.pelErrorMessagePath,
								"3206",
								new Object[] { "Mandatory Checklist verification is pending." }));
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}
		
	/*End*/
	
	public void PAYOUT_REJECTION(PILT021_COMPOSITE_ACTION compositeAction)  {
		
		
		
		
		try {
			System.out.println("Enter the PAYOUT_REJECTION Method");
			
			pilt021_procedures.callP_PROC_PAYOUT_REJECTION(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID(),
																compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID());
		
			System.out.println("Exit the PAYOUT_REJECTION Method");
		} catch (ProcedureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*Added by ganesh on 10-04-2018 as suggested by ajoy */
	public void WHEN_BUTTON_PRESSED_NEW_M_BUTTON_APPROVE(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception{
		
		P9ILPK_END_OF_DAY_PROC.END_OF_DAY_PROC("W",compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_POL_NO(),
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_POL_NO(),CommonUtils.getProcedureValue(new CommonUtils().getCurrentDate()));
		
		
		
	}
	
	
		
}

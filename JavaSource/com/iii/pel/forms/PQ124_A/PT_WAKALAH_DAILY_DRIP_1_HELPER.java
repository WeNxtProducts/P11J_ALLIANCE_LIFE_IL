package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_WAKALAH_DAILY_DRIP_1_HELPER {
	
	private static final Log log = LogFactory.getLog(PT_WAKALAH_DAILY_DRIP_1_HELPER.class);

	public void executeQuery(PQ124_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_WAKALAH_DAILY_DRIP_1_DELEGATE()
				.executeSelectStatement(compositeAction);
	}
	
	/**
	 * 
	 */
	public void preForm(PQ124_A_COMPOSITE_ACTION compositeAction){
		String M_FILE = null;
		String M_TITLE = null;
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		if(CALLING_FORM==null || "".equalsIgnoreCase(CALLING_FORM)){
			CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
			CommonUtils.setGlobalVariable("GLOBAL.M_PARA_1", "");
			
			CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101    01    ");
		}
		STD_PRE_FORM(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
	/*	IF SUBSTR(:GLOBAL.M_FOR_LANG_CODE,5,1) = '1' THEN
	      NULL ;
	   END IF ;

	   M_TITLE:= :CTRL.M_USER_ID ||'                 '||:CTRL.M_SCR_NAME||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
	   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);*/
	}
	
	/**
	 * 
	 */
	public void STD_PRE_FORM(CTRL CTRL_BEAN){
		String CUR_FORM=null;
		String M_FIRST_BLOCK=null;
		String M_MODULE_NAME=null;
		String RG_ID=null;
		int M_QUERY_OK=0;
		String M_TITLE =null;
		String M_COMP_CODE = null;
		String M_DIVN_CODE =null;
		String M_DEPT_CODE = null;
		
		String M_DFLT_VALUES = CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES");
			
		if(M_DFLT_VALUES==null || "".equalsIgnoreCase(M_DFLT_VALUES)){
			M_COMP_CODE = "001";//M_DFLT_VALUES.substring(1, 3);
			M_DIVN_CODE = "HO";//M_DFLT_VALUES.substring(4, 6);
			M_DEPT_CODE = "001";//M_DFLT_VALUES.substring(10, 6);
		}
		
		CTRL_BEAN.setUI_M_PARA_1(CommonUtils.getGlobalVariable("GLOBAL.M_PARA_1"));
		CTRL_BEAN.setUI_M_USER_ID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		CTRL_BEAN.setUI_M_PROG_NAME(CommonUtils.getGlobalVariable("CURRENT_FORM"));
		CTRL_BEAN.setUI_M_SCR_NAME(CommonUtils.getGlobalVariable("GLOBAL.M_NAME"));
		CTRL_BEAN.setUI_M_GOFLD_NAME("");
		CTRL_BEAN.setUI_M_LANG_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
		CTRL_BEAN.setUI_M_DIVN_CODE(M_DIVN_CODE);
		CTRL_BEAN.setUI_M_DEPT_CODE(M_DEPT_CODE);
		CTRL_BEAN.setUI_M_COMP_CODE(M_COMP_CODE);
		
		
		/* M_MODULE_NAME := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
		   COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
		   M_TITLE:= NAME_IN('CTRL.M_USER_ID') ||'                 '||NAME_IN('CTRL.M_SCR_NAME')||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
		   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
		   HIDE_VIEW('ABOUT');
		   M_FIRST_BLOCK := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
		                         CURRENT_FORM_NAME), FIRSTBLOCK) ;

		   LOOP
		      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
		         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
		         ELSE
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
		         END IF ;
		      END IF;
		      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
		         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
		         ELSE
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
		         END IF ;
		      END IF;
		      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
		         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
		         ELSE
		            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
		         END IF ;
		      END IF;
		      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
		      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
		         EXIT ;
		      END IF ;
		   END LOOP ;

		   RG_ID	:= FIND_GROUP('RG_HINT') ;
		   IF ID_NULL(RG_ID) THEN
		      NULL ;
		   ELSE
		      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
		   END IF ;
		   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
		   IF ID_NULL(RG_ID) THEN
		      NULL ;
		   ELSE
		      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
		   END IF ;
		   LOAD_BP;
		   ENABLE_BUTTONS ;
		   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
		      LOAD_BALOON_LABEL;
		   END IF;
		   IF M_MODULE_NAME NOT LIKE 'GNMN%' THEN
		     P_GET_LOGO;
		   END IF;*/
	}
	
	/**
	 * 
	 */
	public void postFormsCommit(){
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "false");
	}
	/**
	 * 
	 */
	public void onClearDetails(){
		//Clear_All_Master_Details;
	}

	/**
	 * 
	 * @param PT_WAKALAH_DAILY_DRIP_1_BEAN
	 * @param PT_WAKALAH_DAILY_DRIP_BEAN
	 */
	public void KEY_EXEQRY(PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN,PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN){
		String M_VAR = null;
		if(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()!=null 
				&& PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()==null){
			M_VAR = "WAK_DA_POL_NO IN (SELECT POL_NO "+
		              "FROM   PT_POLICY, PT_WAKALAH_DAILY_DRIP "+
		              "WHERE  " +
		              "POL_CUST_CODE    = '"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()+"'"+" AND " +
		              		"PT_POLICY.POL_NO = '"+PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()+"')";
		}else if(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()!=null 
				&& PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()!=null){
			M_VAR = "WAK_DA_POL_NO IN (SELECT POL_NO "+
            "FROM   PT_POLICY, PT_WAKALAH_DAILY_DRIP "+
            "WHERE  " +
            "POL_CUST_CODE    = '"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()+"'"+
            		" AND " +
            		"PT_POLICY.POL_NO = '"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()+"'"+
            		" AND " +
            		"PT_POLICY.POL_NO = '"+PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()+"')";
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void postQuery(PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_BASE_CURR = null;
		Double M_CPI_PROFIT =0.0;
		int M_FOUND = 0;

		int M_PA_BAL_TEMP = 0;
		int M_GFTA_SURP = 0;
		int M_PA_PROFIT = 0;
		Date M_PA_PROFIT_DT = null;
		int M_WD_GROSS_LC_VALUE = 0;
		String M_GFTA_FOUND = null;
		Date M_GFTA_DATE = null;
		Double M_TOT_GFTA_PROFIT = 0.0;
		String M_PLAN_TYPE = null;
		int M_MAX_ANN_AMT = 0;
		
		PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_BEAN();
		PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN();
		
		String C1 = "SELECT WAK_DA_MODULE FROM PT_LIFE_WAKALAH_DAILY_DRIP "+  
		   "WHERE  WAK_DA_POL_NO = ? ";
		
		String C2 = "SELECT WAK_DA_POL_PDS_CODE FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_NO = ? ";
		
		String C3 = "SELECT WAK_DA_POL_ANALYSIS_1 FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_NO = ? ";
		
		String C4 = "SELECT NVL(CONT_LC_POL_DEP_AMT,0)	- NVL(CONT_LC_POL_UTIL_AMT,0) " +
				"FROM PM_IL_CONTRACTOR, PT_IL_POLICY   " +
				"WHERE CONT_CODE = POL_CONT_CODE  AND POL_NO = ? ";
		
		String C5 = "SELECT 1 FROM   PM_IL_PLAN,PT_IL_POLICY WHERE  POL_NO = ? AND PLAN_TYPE ='U'  " +
				"AND  PLAN_CODE = POL_PLAN_CODE";
		
		String C6 = "SELECT NVL(SUM (  NVL (wak_da_pol_net_premium, 0) "
				+ "+ DECODE(PROD_LOAD_CHARGE_YN,'Y',NVL (wak_da_load_amt, 0),0) "
				+ "- NVL (wak_da_pol_tot_comm, 0) "
				+ "- NVL (wak_da_risk_fund, 0)),0) "
				+ "  FROM   " +
				"PT_LIFE_WAKALAH_DAILY_DRIP,pt_il_policy,pm_il_product "
				+ " WHERE  wak_da_pol_no = ? "
				+ "AND    wak_da_module = 'IL' "
				+ " AND    pol_no=wak_da_pol_no "
				+ "AND    pol_prod_code = prod_code";
		
		String C7 = "SELECT   NVL (UFR_NO_OF_UNITS, 0)  * P9ilpk_Fund_Alloc.p_get_unit_price (ufr_fund_code,"+
                                                        "TRUNC(SYSDATE) - 1 ,"+
                                                        "'N',"+
                                                        "'N'"+
                                                         ")"+
           " FROM PS_IL_UNIT_FUND_REG,pt_il_policy"+
          " WHERE ufr_pol_no= ? "+
		     " AND   ufr_pol_no=pol_no";
		
		String C8 = "SELECT SUM(NVL(WAK_DA_PROFIT_INVEST,0)) " +
				"FROM  PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_NO =?";
		
		String C9 = "SELECT SUM(NVL(WAK_DA_PROFIT_INVEST,0)),SUM(NVL(WAK_DA_PRIA_BAL_AFTER_SUR,0))  "
				+ "FROM  PT_LIFE_WAKALAH_DAILY_DRIP  "
				+ "WHERE WAK_DA_POL_NO =? "
				+ "AND WAK_DA_YEAR =? -1";
		
		String C10 = "SELECT SUM(NVL(WAK_DA_PSA_PROFIT,0)) FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_NO =?";
		
		String C11 = " SELECT NVL(WAK_SURPLUS_AMT,0),WAK_PROCESS_DATE  FROM PT_LIFE_WAKALAH_MONTHLY_DRIP "
				+ "WHERE WAK_MO_MON =? "
				+ "AND WAK_MO_YEAR =?";
		
		String C12 = "SELECT WAKI_CR_DT FROM PM_LIFE_WAKALAH_INPUTS "
				+ "WHERE WAKI_MONTH = ? AND WAKI_YEAR = ?";
		
		String C13 = "SELECT SMV_AMT3 FROM " +
				"PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ?";
		
		String C14 = "SELECT SUM(nvl(CPI_PA_PROFIT,0))+SUM(nvl(CPI_PROFIT,0))+NVL(SUM(CPI_TOT_PROFIT),0) "
				+ "FROM ps_il_cont_paid_invest "
				+ "WHERE CPI_POL_NO = ? ";
		
		String C15 = "SELECT NVL(SUM(NVL(WD_GROSS_LC_VALUE,0)),0)  FROM PT_IL_WITHDRAWAL "
				+ "WHERE wd_pol_sys_id = (SELECT  "
				+ "POL_SYS_ID FROM PT_IL_POLICY "
				+ "WHERE  POL_NO = ? ) "
				+ "AND NVL(WD_STATUS_CODE,'N') NOT IN ('D','R') "
				+ " AND NVL(WD_APPRV_STATUS,'N') ='A'";
		
		String C16 = "SELECT SUM(NVL(CPI_GFTA_PROFIT,0)) FROM   PS_IL_CONT_PAID_INVEST " +
				"WHERE  CPI_POL_NO = ? ";
		String C17A = "SELECT 'X' "
				+ "FROM  PM_IL_PROD_PA_BENEFIT  "
				+ "WHERE PPB_PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ? ) "
				+ "AND   PPB_BUSN_TYPE = 'GT' "
				+ "AND   PPB_ACNT_YEAR = (	SELECT CAY_ACNT_YEAR "
				+ "  FROM FM_COMP_ACNT_YEAR "
				+ "WHERE ? BETWEEN CAY_FRM_DT AND CAY_TO_DT )";
		
		String C17B = "SELECT MAX(TRUNC(CPI_TXN_DT)) FROM   PS_IL_CONT_PAID_INVEST WHERE  " +
				"CPI_POL_NO = ? AND CPI_GFTA_PROFIT IS NOT NULL";
		
		String C17 = "SELECT DECODE(?,'X',TO_NUMBER(TO_CHAR(TO_DATE(MAX(CPI_TXN_DT),'DD/MM/RR'),'YYYY')), "
				+ "TO_NUMBER(TO_CHAR(TO_DATE(MAX(CPI_TXN_DT),'DD/MM/RR'),'YYYY')) -1 ) "
				+ "FROM   PS_IL_CONT_PAID_INVEST  "
				+ "WHERE  CPI_POL_NO = ? "
				+ "AND    CPI_GFTA_PROFIT IS NOT NULL";
		
		String C18 = "  SELECT SUM(DEDN_ANNUITY_LC_AMT) "+
				"FROM PT_IL_DEDUCTION  "
				+ "WHERE DEDN_POL_SYS_ID = (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ) "
				+ "AND DEDN_TYPE = 'W' AND DEDN_PYMT_YN = 'Y' "
				+ "AND DEDN_PV_YN = 'Y'";
		
		String C19 = "SELECT PLAN_TYPE  FROM PM_IL_PLAN "
				+ "WHERE PLAN_CODE = (SELECT POL_PLAN_CODE FROM PT_IL_POLICY WHERE POL_NO = ?)";
		
		
		String C20 = "SELECT TO_NUMBER((TO_CHAR(MAX(CPI_PRO_DATE),'YYYY'))) "
				+ "FROM   PS_IL_CONT_PAID_INVEST  "
				+ "WHERE  CPI_POL_NO = ? "
				+ "AND    NVL(CPI_PSA_PROFIT,0) <> 0";
		
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		ResultSet C10_REC = null;
		ResultSet C11_REC = null;
		ResultSet C12_REC = null;
		ResultSet C13_REC = null;
		ResultSet C14_REC = null;
		ResultSet C15_REC = null;
		ResultSet C16_REC = null;
		ResultSet C17_REC = null;
		ResultSet C17A_REC = null;
		ResultSet C17B_REC = null;
		ResultSet C18_REC = null;
		ResultSet C19_REC = null;
		ResultSet C20_REC = null;
		Connection con = null;
		CRUDHandler handler = null;
		DBProcedures procedures = new DBProcedures();
		try{
			log.info("Inside Post Query");
			handler = new CRUDHandler();
			con = CommonUtils.getConnection();
			log.info("Policy Number===============>"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO());
			Object[] polNo = new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()};
			
			C14_REC = handler.executeSelectStatement(C14, con,polNo);
			if(C14_REC.next()){
				M_CPI_PROFIT = C14_REC.getDouble(1);
			}
			
			C16_REC = handler.executeSelectStatement(C16, con,polNo);
			if(C16_REC.next()){
				M_TOT_GFTA_PROFIT = C16_REC.getDouble(1);
			}
			
			C1_REC = handler.executeSelectStatement(C1, con,polNo);
			if(C1_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_MODULE(C1_REC.getString(1));
			}
			
			C2_REC = handler.executeSelectStatement(C2, con,polNo);
			if(C2_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_POL_PDS_CODE(C2_REC.getString(1));
			}
			
			C3_REC = handler.executeSelectStatement(C3, con,polNo);
			if(C3_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_POL_ANALYSIS_1(C3_REC.getString(1));
			}
			
			C4_REC = handler.executeSelectStatement(C4, con,polNo);
			if(C4_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_CONT_LC_BALANCE(C4_REC.getDouble(1));
			}
			
			C5_REC = handler.executeSelectStatement(C5, con,polNo);
			if(C5_REC.next()){
				M_FOUND = C5_REC.getInt(1);
				C7_REC = handler.executeSelectStatement(C7, con,polNo);
				while(C7_REC.next()){
					M_PA_BAL_TEMP = C7_REC.getInt(1);
					procedures.callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(M_BASE_CURR), CommonUtils.getProcedureValue(M_PA_BAL_TEMP), "R");
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_BAL( CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_PA_BAL(), 0) + CommonUtils.nvl(M_PA_BAL_TEMP, 0) );
					log.info("BAL VALUE=====>"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_PA_BAL());
				}
			}else{
				C6_REC = handler.executeSelectStatement(C6, con,polNo);
				if(C6_REC.next()){
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_BAL(C6_REC.getDouble(1));
				}
				
				C15_REC = handler.executeSelectStatement(C15, con,polNo);
				if(C15_REC.next()){
					M_WD_GROSS_LC_VALUE = C15_REC.getInt(1);
				}
				
				C19_REC = handler.executeSelectStatement(C19, con,polNo);
				if(C19_REC.next()){
					M_PLAN_TYPE = C19_REC.getString(1);
				}
				if("D".equalsIgnoreCase(M_PLAN_TYPE)){
					C18_REC = handler.executeSelectStatement(C18, con,polNo);
					if(C18_REC.next()){
						M_MAX_ANN_AMT = C15_REC.getInt(1);
					}
				}
				
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_BAL( PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_PA_BAL() - M_WD_GROSS_LC_VALUE - CommonUtils.nvl(M_MAX_ANN_AMT, 0) );
				log.info("==========MPABAL=====>"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_PA_BAL());
			}
			
			C8_REC = handler.executeSelectStatement(C8, con,polNo);
			if(C8_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_PROFIT(C8_REC.getDouble(1));
			}
			
			PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_PROFIT( CommonUtils.nvl(M_CPI_PROFIT, 0) );
			
			procedures.callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(M_BASE_CURR), CommonUtils.getProcedureValue(M_PA_PROFIT), "R");
			
			C10_REC = handler.executeSelectStatement(C10, con,polNo);
			if(C10_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_ACC_PSA_PROFIT(C10_REC.getDouble(1));
			}
			
			procedures.callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(M_BASE_CURR), CommonUtils.getProcedureValue(M_GFTA_SURP), "R");
			
			Object [] obj_11 = new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_MON(),PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_YEAR()};
			
			C11_REC = handler.executeSelectStatement(C11, con,obj_11);
			if(C11_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_GFTA_SURP_AMT(C11_REC.getDouble(1));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_GFTA_SURP_DT(C11_REC.getDate(2));
			}
			
			C12_REC = handler.executeSelectStatement(C12, con,obj_11);
			if(C12_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_PROFIT_DT(C12_REC.getDate(1));
			}
			
			PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_GFTA_SURP(CommonUtils.nvl(M_TOT_GFTA_PROFIT,0));
			
			M_GFTA_FOUND = null;
			M_GFTA_DATE = null;
			
			C17B_REC = handler.executeSelectStatement(C17B, con,polNo);
			if(C17B_REC.next()){
				M_GFTA_DATE = C17B_REC.getDate(1);
			}
			
			C17A_REC = handler.executeSelectStatement(C17A, con,new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO(),M_GFTA_DATE});
			if(C17A_REC.next()){
				M_GFTA_FOUND = C17A_REC.getString(1);
			}
			
			M_GFTA_FOUND = CommonUtils.nvl(M_GFTA_FOUND, "Y");
			
			C17_REC = handler.executeSelectStatement(C17, con,new Object[]{M_GFTA_FOUND,PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()});
			if(C17_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_GFTA_SURP_TR(C17_REC.getDouble(1));
			}
			
			C20_REC = handler.executeSelectStatement(C20, con,polNo);
			if(C20_REC.next()){
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PSA_YR(C20_REC.getDouble(1));
			}
			PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_PA_BAL( CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_PA_BAL(), 0) + CommonUtils.nvl(M_CPI_PROFIT, 0) 
					+ CommonUtils.nvl(M_TOT_GFTA_PROFIT, 0));
			
		}catch(Exception exception){
			ErrorHelpUtil.getErrorForProcedure(con);
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C9_REC);
			CommonUtils.closeCursor(C10_REC);
			CommonUtils.closeCursor(C11_REC);
			CommonUtils.closeCursor(C12_REC);
			CommonUtils.closeCursor(C13_REC);
			CommonUtils.closeCursor(C14_REC);
			CommonUtils.closeCursor(C15_REC);
			CommonUtils.closeCursor(C16_REC);
			CommonUtils.closeCursor(C17_REC);
			CommonUtils.closeCursor(C17A_REC);
			CommonUtils.closeCursor(C17B_REC);
			CommonUtils.closeCursor(C18_REC);
			CommonUtils.closeCursor(C19_REC);
			CommonUtils.closeCursor(C20_REC);
		}
		
		
	}
	
	/**
	 * 
	 */
	public void onPopulateDetails(PQ124_A_COMPOSITE_ACTION compositeAction){
		if(compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN().getPOL_NO()!=null){
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().onLoad(null);
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().onLoad(null);
		}
	}
	/**
	 * 
	 * @param PT_WAKALAH_DAILY_DRIP_1_BEAN
	 * @throws Exception
	 */
	public void preDelete(PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN) throws Exception{
		Connection connection = null;
		CRUDHandler handler = null;
		String deleteQuery = " DELETE FROM PT_WAKALAH_DAILY_DRIP P  WHERE P.WAK_DA_POL_NO = ? ";
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			int i = handler.executeDeleteStatement(deleteQuery, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()});
			log.info("Delete Recird=======>  "+i);
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * 
	 */
	public void onCheckDeleteMaster(PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN) throws Exception{
		String Dummy_Define = null;
		String PS_IL_CONT_PAID_INVEST_cur = "SELECT 1 FROM PS_IL_CONT_PAID_INVEST P WHERE P.CPI_POL_NO = ? ";
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet PS_IL_CONT_PAID_INVEST_cur_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			PS_IL_CONT_PAID_INVEST_cur_REC = handler.executeSelectStatement(PS_IL_CONT_PAID_INVEST_cur, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()});
			if(PS_IL_CONT_PAID_INVEST_cur_REC.next()){
				Dummy_Define = PS_IL_CONT_PAID_INVEST_cur_REC.getString(1);
				throw new Exception("Cannot delete master record when matching detail records exist.");
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(PS_IL_CONT_PAID_INVEST_cur_REC);
		}
	}
}

package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PRODUCT_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PRODUCT.* FROM PM_IL_PRODUCT WHERE ROWID=?";
		/*Added by saritha on 09-Dec-2016 Plan code Description*/
		String Covercode="SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE=?";
		/*End*/
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_IL_PRODUCT_ACTION_BEAN()
							.getPM_IL_PRODUCT_BEAN().getROWID() });
			PM_IL_PRODUCT PM_IL_PRODUCT_BEAN = new PM_IL_PRODUCT();
			while (resultSet.next()) {
				PM_IL_PRODUCT_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PRODUCT_BEAN.setPROD_CODE(resultSet
						.getString("PROD_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_DESC(resultSet
						.getString("PROD_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_SHORT_DESC(resultSet
						.getString("PROD_SHORT_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_LONG_DESC(resultSet
						.getString("PROD_LONG_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_BL_DESC(resultSet
						.getString("PROD_BL_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_BL_SHORT_DESC(resultSet
						.getString("PROD_BL_SHORT_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_BL_LONG_DESC(resultSet
						.getString("PROD_BL_LONG_DESC"));
				PM_IL_PRODUCT_BEAN.setPROD_PLAN_CODE(resultSet
						.getString("PROD_PLAN_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_PERIOD(resultSet
						.getInt("PROD_PERIOD"));
				PM_IL_PRODUCT_BEAN.setPROD_PREM_PAY_YRS(resultSet
						.getInt("PROD_PREM_PAY_YRS"));
				PM_IL_PRODUCT_BEAN.setPROD_AGE_CALC_FLAG(resultSet
						.getString("PROD_AGE_CALC_FLAG"));
				PM_IL_PRODUCT_BEAN.setPROD_JOINT_LIFE_YN(resultSet
						.getString("PROD_JOINT_LIFE_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_TARIFF_TERM_FLAG(resultSet
						.getString("PROD_TARIFF_TERM_FLAG"));
				PM_IL_PRODUCT_BEAN.setPROD_PERIOD_MULTIPLE(resultSet
						.getInt("PROD_PERIOD_MULTIPLE"));
				PM_IL_PRODUCT_BEAN.setPROD_SA_INST_PYMT_TYPE(resultSet
						.getString("PROD_SA_INST_PYMT_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_EFF_FM_DT(resultSet
						.getDate("PROD_EFF_FM_DT"));
				PM_IL_PRODUCT_BEAN.setPROD_EFF_TO_DT(resultSet
						.getDate("PROD_EFF_TO_DT"));
				PM_IL_PRODUCT_BEAN.setPROD_CR_DT(resultSet
						.getDate("PROD_CR_DT"));
				PM_IL_PRODUCT_BEAN.setPROD_CR_UID(resultSet
						.getString("PROD_CR_UID"));
				PM_IL_PRODUCT_BEAN.setPROD_UPD_DT(resultSet
						.getDate("PROD_UPD_DT"));
				PM_IL_PRODUCT_BEAN.setPROD_UPD_UID(resultSet
						.getString("PROD_UPD_UID"));
				PM_IL_PRODUCT_BEAN.setPROD_ENDT_VAL_DAYS(resultSet
						.getInt("PROD_ENDT_VAL_DAYS"));
				PM_IL_PRODUCT_BEAN.setPROD_MAX_DEFER_MONTHS(resultSet
						.getInt("PROD_MAX_DEFER_MONTHS"));
				PM_IL_PRODUCT_BEAN.setPROD_COOLOFF_DAYS(resultSet
						.getInt("PROD_COOLOFF_DAYS"));
				PM_IL_PRODUCT_BEAN.setPROD_EXP_LOAD_RATE(resultSet
						.getDouble("PROD_EXP_LOAD_RATE"));
				PM_IL_PRODUCT_BEAN.setPROD_EXP_LOAD_RATE_PER(resultSet
						.getInt("PROD_EXP_LOAD_RATE_PER"));
				PM_IL_PRODUCT_BEAN.setPROD_CONT_LOAD_RATE(resultSet
						.getDouble("PROD_CONT_LOAD_RATE"));
				PM_IL_PRODUCT_BEAN.setPROD_CONT_LOAD_RATE_PER(resultSet
						.getInt("PROD_CONT_LOAD_RATE_PER"));
				PM_IL_PRODUCT_BEAN.setPROD_MORT_CODE(resultSet
						.getString("PROD_MORT_CODE"));
				
				//added by agalya on 05/07/2016 for field validation, ref no- FALCONQC-1714490
				
				
				PM_IL_PRODUCT_BEAN.setPROD_MORT_CODE_DESC(GetPROD_MORT_CODEDesc(resultSet
						.getString("PROD_MORT_CODE")));
				//end
				
				PM_IL_PRODUCT_BEAN.setPROD_EMI_TOLERANCE(resultSet
						.getInt("PROD_EMI_TOLERANCE"));
				PM_IL_PRODUCT_BEAN.setPROD_CBC_YN(resultSet
						.getString("PROD_CBC_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_AGE_SET_BACK(resultSet
						.getInt("PROD_AGE_SET_BACK"));
				PM_IL_PRODUCT_BEAN.setPROD_WITHDRAW_YN(resultSet
						.getString("PROD_WITHDRAW_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_YN(resultSet
						.getString("PROD_TOPUP_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_MIN_YRS(resultSet
						.getDouble("PROD_TOPUP_MIN_YRS"));
				PM_IL_PRODUCT_BEAN.setPROD_BCH_CODE(resultSet
						.getString("PROD_BCH_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_COMM_RND_DEC(resultSet
						.getInt("PROD_COMM_RND_DEC"));
				PM_IL_PRODUCT_BEAN.setPROD_COMM_RND_TYPE(resultSet
						.getString("PROD_COMM_RND_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_BROK_CALC_MTHD(resultSet
						.getString("PROD_BROK_CALC_MTHD"));
				PM_IL_PRODUCT_BEAN.setPROD_PRODUCTION_PERC(resultSet
						.getDouble("PROD_PRODUCTION_PERC"));
				PM_IL_PRODUCT_BEAN.setPROD_THRESHOLD_PERC(resultSet
						.getDouble("PROD_THRESHOLD_PERC"));
				PM_IL_PRODUCT_BEAN.setPROD_DS_CODE(resultSet
						.getString("PROD_DS_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_PROD_PERC(resultSet
						.getDouble("PROD_TOPUP_PROD_PERC"));
				PM_IL_PRODUCT_BEAN.setPROD_PREM_CALC_MTHD(resultSet
						.getString("PROD_PREM_CALC_MTHD"));
				PM_IL_PRODUCT_BEAN.setPROD_INST_BASIS(resultSet
						.getString("PROD_INST_BASIS"));
				PM_IL_PRODUCT_BEAN.setPROD_INST_PERC(resultSet
						.getDouble("PROD_INST_PERC"));
				PM_IL_PRODUCT_BEAN.setPROD_AUTO_APPROV(resultSet
						.getString("PROD_AUTO_APPROV"));
				PM_IL_PRODUCT_BEAN.setPROD_INST_RATE_PER(resultSet
						.getDouble("PROD_INST_RATE_PER"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_COMM_CODE(resultSet
						.getString("PROD_TOPUP_COMM_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_ALLOC_TYPE(resultSet
						.getString("PROD_ALLOC_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_BUY_BASIS(resultSet
						.getString("PROD_BUY_BASIS"));
				PM_IL_PRODUCT_BEAN.setPROD_AUTO_UW(resultSet
						.getString("PROD_AUTO_UW"));
				PM_IL_PRODUCT_BEAN.setPROD_PREM_TARIFF(resultSet
						.getString("PROD_PREM_TARIFF"));
				PM_IL_PRODUCT_BEAN.setPROD_SA_TARIFF(resultSet
						.getString("PROD_SA_TARIFF"));
				PM_IL_PRODUCT_BEAN.setPROD_CALC_ALLOC(resultSet
						.getString("PROD_CALC_ALLOC"));
				PM_IL_PRODUCT_BEAN.setPROD_SA_FACTOR(resultSet
						.getString("PROD_SA_FACTOR"));
				PM_IL_PRODUCT_BEAN.setPROD_ROUND_OPTION(resultSet
						.getString("PROD_ROUND_OPTION"));
				PM_IL_PRODUCT_BEAN.setPROD_ROUND_VALUE(resultSet
						.getInt("PROD_ROUND_VALUE"));
				PM_IL_PRODUCT_BEAN.setPROD_MAT_AMT_TYPE(resultSet
						.getString("PROD_MAT_AMT_TYPE"));
				if (resultSet.getObject("PROD_MAT_RATE") != null) {
					PM_IL_PRODUCT_BEAN.setPROD_MAT_RATE(resultSet
							.getDouble("PROD_MAT_RATE"));
				} else {
					PM_IL_PRODUCT_BEAN.setPROD_MAT_RATE(null);
				}
				if (resultSet.getObject("PROD_MAT_RATE_PER") != null) {

					PM_IL_PRODUCT_BEAN.setPROD_MAT_RATE_PER(resultSet
							.getInt("PROD_MAT_RATE_PER"));
				} else {
					PM_IL_PRODUCT_BEAN.setPROD_MAT_RATE_PER(resultSet
							.getInt(null));
				}
				PM_IL_PRODUCT_BEAN.setPROD_FUND_FEE(resultSet
						.getDouble("PROD_FUND_FEE"));
				PM_IL_PRODUCT_BEAN.setPROD_FUND_FEE_RATE_PER(resultSet
						.getDouble("PROD_FUND_FEE_RATE_PER"));
				PM_IL_PRODUCT_BEAN.setPROD_MRTA_RATE_CALC_YN(resultSet
						.getString("PROD_MRTA_RATE_CALC_YN"));
				/*added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan on 06/01/17*/
				PM_IL_PRODUCT_BEAN.setPROD_APL_YN(resultSet.getString("PROD_APL_YN"));
				//end
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_CHARGE_TYPE(resultSet
						.getString("PROD_TOPUP_CHARGE_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_PREM_HOLIDAY_CODE(resultSet
						.getString("PROD_PREM_HOLIDAY_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_LOAD_CHARGE_YN(resultSet
						.getString("PROD_LOAD_CHARGE_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_PRODUCT_TYPE(resultSet
						.getString("PROD_PRODUCT_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_GRP_THRESHOLD_PERC(resultSet
						.getDouble("PROD_GRP_THRESHOLD_PERC"));
				PM_IL_PRODUCT_BEAN.setPROD_MODE_OF_CALC(resultSet
						.getString("PROD_MODE_OF_CALC"));
				PM_IL_PRODUCT_BEAN.setPROD_THR_BASIS(resultSet
						.getString("PROD_THR_BASIS"));
				PM_IL_PRODUCT_BEAN.setPROD_SURR_CALC_TYPE(resultSet
						.getString("PROD_SURR_CALC_TYPE"));
				PM_IL_PRODUCT_BEAN.setPROD_PRS_YN(resultSet
						.getString("PROD_PRS_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_SURR_PLUS_FACTOR(resultSet
						.getString("PROD_SURR_PLUS_FACTOR"));
				PM_IL_PRODUCT_BEAN.setPROD_AGENT_HIRE_YN(resultSet
						.getString("PROD_AGENT_HIRE_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_MATU_DT(resultSet
						.getString("PROD_MATU_DT"));
				PM_IL_PRODUCT_BEAN.setPROD_DEF_PERIOD_FLAG(resultSet
						.getString("PROD_DEF_PERIOD_FLAG"));
				PM_IL_PRODUCT_BEAN.setPROD_RSA_CALC_TYP(resultSet
						.getString("PROD_RSA_CALC_TYP"));
				PM_IL_PRODUCT_BEAN.setPROD_SURRENDER_FACTOR(resultSet
						.getString("PROD_SURRENDER_FACTOR"));
				PM_IL_PRODUCT_BEAN.setPROD_TOLL_LIMIT_YN(resultSet
						.getString("PROD_TOLL_LIMIT_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_INTER_FUND_YN(resultSet
						.getString("PROD_INTER_FUND_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_WITHDRAW_AMT_MULTIPLE(resultSet
						.getDouble("PROD_WITHDRAW_AMT_MULTIPLE"));
				PM_IL_PRODUCT_BEAN.setPROD_RI_RECOV_BASIS(resultSet
						.getString("PROD_RI_RECOV_BASIS"));
				PM_IL_PRODUCT_BEAN.setPROD_DRIP_MTHD(resultSet
						.getString("PROD_DRIP_MTHD"));
				PM_IL_PRODUCT_BEAN.setPROD_SERVICE_TAX_YN(resultSet
						.getString("PROD_SERVICE_TAX_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_SA_BY_PLAN_BASIS_YN(resultSet
						.getString("PROD_SA_BY_PLAN_BASIS_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_MASTER_CERT_YN(resultSet
						.getString("PROD_MASTER_CERT_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_FUND_ALLOWED(resultSet
						.getString("PROD_FUND_ALLOWED"));
				PM_IL_PRODUCT_BEAN.setPROD_WAKFEE_FACTOR(resultSet
						.getString("PROD_WAKFEE_FACTOR"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_WAK_CODE(resultSet
						.getString("PROD_TOPUP_WAK_CODE"));
				PM_IL_PRODUCT_BEAN.setPROD_SAL_MULTIPLE(resultSet
						.getInt("PROD_SAL_MULTIPLE"));
				PM_IL_PRODUCT_BEAN.setPROD_INC_WEIGHT(resultSet
						.getDouble("PROD_INC_WEIGHT"));
				PM_IL_PRODUCT_BEAN.setPROD_AFTWD_LC_MINBAL(resultSet
						.getDouble("PROD_AFTWD_LC_MINBAL"));
				PM_IL_PRODUCT_BEAN.setPROD_TRAN_RATE_YN(resultSet
						.getString("PROD_TRAN_RATE_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_TOPUP_MULTIPLE(resultSet
						.getDouble("PROD_TOPUP_MULTIPLE") == 0 ? null : resultSet
								.getDouble("PROD_TOPUP_MULTIPLE"));
				PM_IL_PRODUCT_BEAN.setPROD_REM_YN(resultSet.getString("PROD_REM_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_REM_1(resultSet.getInt("PROD_REM_1"));
				PM_IL_PRODUCT_BEAN.setPROD_REM_2(resultSet.getInt("PROD_REM_2"));
				PM_IL_PRODUCT_BEAN.setPROD_REM_3(resultSet.getInt("PROD_REM_3"));
				//added by saranya
				PM_IL_PRODUCT_BEAN.setPROD_FORMULA_SURR(resultSet
						.getString("PROD_FORMULA_SURR"));
				PM_IL_PRODUCT_BEAN.setPROD_PAIDUP_FORMULA(resultSet
						.getString("PROD_PAIDUP_FORMULA"));
				//end
				/*Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
				PM_IL_PRODUCT_BEAN.setPROD_CASHBACK_YN(resultSet
						.getString("PROD_CASHBACK_YN"));
				/*End*/
				/*Added by saranya on 13/02/2017 for Unit Link Product as per the Girish Suggessted*/
				PM_IL_PRODUCT_BEAN.setPROD_RISK_FACTOR_YN(resultSet
						.getString("PROD_RISK_FACTOR_YN"));
				/*End*/
				/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
				PM_IL_PRODUCT_BEAN.setPROD_UNIT_LINK_TYPE(resultSet
						.getString("PROD_UNIT_LINK_TYPE"));
				/*End*/
				
				
				/*	Added  by saranya for Hands on point num 23 on 14/02/2017
				PM_IL_PRODUCT_BEAN.setPROD_CLM_PROC_FEE(resultSet
						.getDouble("PROD_CLM_PROC_FEE"));
				End*/
				/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
				PM_IL_PRODUCT_BEAN.setPROD_DEFAULT_CURR_CODE(resultSet.getString("PROD_DEFAULT_CURR_CODE"));
				String currencyDesc = null;
				currencyDesc = getDefaultCurrencyDesc(resultSet.getString("PROD_DEFAULT_CURR_CODE"));
				PM_IL_PRODUCT_BEAN.setUI_M_PROD_DEFAULT_CURR_CODE_DESC(currencyDesc);
				/*End Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
				/*Added by senthilnathan for Alliance_IL ON 05.02.2021 as suggested by sivaram and abhilash*/
				PM_IL_PRODUCT_BEAN.setPROD_RI_FORMULA_CODE(resultSet.getString("PROD_RI_FORMULA_CODE"));
				
				
				
				if(PM_IL_PRODUCT_BEAN.getPROD_RI_FORMULA_CODE()!=null){
					String Q1="SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE=?";
					ResultSet  RS=null;
					RS = new CRUDHandler().executeSelectStatement(Q1, connection, new Object[]
							{ PM_IL_PRODUCT_BEAN.getPROD_RI_FORMULA_CODE() });
					if(RS.next()){
						PM_IL_PRODUCT_BEAN.setUI_M_PROD_RI_FORMULA_CODE_DESC(RS.getString("FRM_DESC"));
					}
				}	
				/*End*/
				
				/*Added by saritha on 09-Dec-2016 Plan code Description*/
				PM_IL_PRODUCT_BEAN.setPROD_PLAN_CODE(resultSet.getString("PROD_PLAN_CODE"));
				System.out.println("**********value of PROD_PLAN_CODE------------>"+PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE());
				ResultSet Desc= new CRUDHandler().executeSelectStatement(Covercode,
						CommonUtils.getConnection(),
						new Object[] {PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE()});
				if(Desc.next()){
				PM_IL_PRODUCT_BEAN.setUI_M_PROD_PLAN_CODE_DESC(Desc.getString("COVER_DESC"));
				System.out.println("********************VALUE OF UI_M_PROD_PLAN_CODE_DESC********"+PM_IL_PRODUCT_BEAN.getUI_M_PROD_PLAN_CODE_DESC());
				}
				
				/*End*/
				/*query changed by kavitha on 08.01.2019 as per siva sir sugg*/
				//String query="select Fm_desc from PM_formula where fm_code=?";
				String query="SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE = ?";
				ResultSet  resultSet1=null;
				System.out.println("value of--->"+PM_IL_PRODUCT_BEAN.getPROD_FORMULA_SURR());
				resultSet1 = new CRUDHandler().executeSelectStatement(query, connection, new Object[]
						{ PM_IL_PRODUCT_BEAN.getPROD_FORMULA_SURR() });
				while(resultSet1.next())
				{
					/*PM_IL_PRODUCT_BEAN.setUI_PROD_FORMULA_SURR_DESC(resultSet1
							.getString("Fm_desc"));*/
					PM_IL_PRODUCT_BEAN.setUI_PROD_FORMULA_SURR_DESC(resultSet1
							.getString("FRM_DESC"));
				}
				/*query changed by kavitha on 08.01.2019 as per siva sir sugg*/
				//String query1="select Fm_desc from PM_formula where fm_code=?";
				String query1="SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE = ?";
				ResultSet  resultSet2=null;
				System.out.println("value of 2--->"+PM_IL_PRODUCT_BEAN.getPROD_PAIDUP_FORMULA());
				resultSet2 = new CRUDHandler().executeSelectStatement(query, connection, new Object[]
						{ PM_IL_PRODUCT_BEAN.getPROD_PAIDUP_FORMULA() });
				while(resultSet2.next())
				{
					/*PM_IL_PRODUCT_BEAN.setUI_PROD_PAIDUP_FORMULA_DESC(resultSet2
							.getString("Fm_desc"));*/
					PM_IL_PRODUCT_BEAN.setUI_PROD_PAIDUP_FORMULA_DESC(resultSet2
							.getString("FRM_DESC"));
				}

                String query2="select BCH_DESC from PM_BROKER_COMM_HDR where BCH_CODE=?";
				ResultSet  resultSet3=null;
				System.out.println("value of commission code--->"+PM_IL_PRODUCT_BEAN.getPROD_BCH_CODE());
				resultSet1 = new CRUDHandler().executeSelectStatement(query2, connection, new Object[]
						{ PM_IL_PRODUCT_BEAN.getPROD_BCH_CODE() });
				while(resultSet1.next())
				{
					PM_IL_PRODUCT_BEAN.setPROD_BCH_CODE_DESC(resultSet1
							.getString("BCH_DESC"));
				}
				/*Added sankaranarayanan for hospitalcashplan  on 21-04-2017*/
				PM_IL_PRODUCT_BEAN.setPROD_INTR_SAVINGS_YN(resultSet.getString("PROD_INTR_SAVINGS_YN"));
				
				/*end*/
				/*added by Ameen on 31-10-2017 to add PROD_RI_SA_CALC_TYP as per Chandramohan sugg.*/
				PM_IL_PRODUCT_BEAN.setPROD_RI_SA_CALC_TYP(resultSet.getString("PROD_RI_SA_CALC_TYP"));
				/*end*/
				
				/*Added by Janani on 04.01.2018 for ZBLIFE-1459615*/
				
				PM_IL_PRODUCT_BEAN.setPROD_PUP_YN(resultSet.getString("PROD_PUP_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_MIN_PUP_AMT(resultSet.getDouble("PROD_MIN_PUP_AMT"));
				PM_IL_PRODUCT_BEAN.setPROD_DRIP_AMT(resultSet.getDouble("PROD_DRIP_AMT"));
				
				/*End of ZBLIFE-1459615*/
				
				/*added by Ameen on 15-02-2018 for KIC*/
				PM_IL_PRODUCT_BEAN.setPROD_RET_PREM_YN(resultSet.getString("PROD_MAT_RET_PREM_YN"));
				/*End*/
				
				/*Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA*/
				PM_IL_PRODUCT_BEAN.setPROD_REG_EXCESS_APP_YN(resultSet.getString("PROD_REG_EXCESS_APP_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_MAT_AMT_LEVEL(resultSet.getString("PROD_MAT_AMT_LEVEL"));
				/*End*/
				
				/*Added by Ameen on 25-03-2018 for KIC part payment*/
				PM_IL_PRODUCT_BEAN.setPROD_CBC_LIMIT(resultSet.getInt("PROD_CBC_LIMIT"));
				/*End*/
				
				/*Added by Janani on 18.04.2018 for Fidelity period calc*/
				PM_IL_PRODUCT_BEAN.setPROD_CALC_TERM_YN(resultSet.getString("PROD_CALC_TERM_YN"));
				/*End*/
				
				/*Added by Janani on 12.05.2018 for Fidelity as suggested by Sivaram for Funeral,hospital cash rider*/
				PM_IL_PRODUCT_BEAN.setPROD_RIDER_APPL_YN(resultSet.getString("PROD_RIDER_APPL_YN"));
				/*End*/
				
				/*added by gopi for toi on 25/05/18*/
				PM_IL_PRODUCT_BEAN.setPROD_BENF_AS_CUST_YN(resultSet.getString("PROD_BENF_AS_CUST_YN"));
				PM_IL_PRODUCT_BEAN.setPROD_POL_APPROVAL_YN(resultSet.getString("PROD_POL_APPROVAL_YN"));
				/*end*/
				
				/*Added by Janani on 15.06.2018 for KIC*/
				
				PM_IL_PRODUCT_BEAN.setPROD_NGTV_SUS_YN(resultSet.getString("PROD_NGTV_SUS_YN"));
				
				/*End*/
				/*Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
				PM_IL_PRODUCT_BEAN.setPROD_SUB_DT_YN(resultSet.getString("PROD_SUB_DT_YN"));
				/*End Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
				
				/*Added by Janani on 25.06.2018 for  FSD_IL_FLA_006_Monetary Endorsement Module*/
				PM_IL_PRODUCT_BEAN.setPROD_AGENT_PREM_TYPE(resultSet.getString("PROD_AGENT_PREM_TYPE"));
				/*End*/
				
				/*Added by Janani on 05.07.2018 for FLALIFEQC-1512859 */
				PM_IL_PRODUCT_BEAN.setPROD_PREM_PAYING_YRS(resultSet.getString("PROD_PREM_PAYING_YRS"));
				/*End*/
				/*Added by kavitha on 08.01.2019 as per siva sir sugg */
				PM_IL_PRODUCT_BEAN.setPROD_FORMULA_MAT(resultSet
						.getString("PROD_FORMULA_MAT"));
				
				String query3="SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE = ?";
				ResultSet  resultSet4=null;
				System.out.println("value of--->"+PM_IL_PRODUCT_BEAN.getPROD_FORMULA_MAT());
				resultSet4 = new CRUDHandler().executeSelectStatement(query3, connection, new Object[]
						{ PM_IL_PRODUCT_BEAN.getPROD_FORMULA_MAT() });
				while(resultSet4.next())
				{
					PM_IL_PRODUCT_BEAN.setUI_PROD_FORMULA_MAT_DESC(resultSet4
							.getString("FRM_DESC"));
				}
				
				/*End*/
				
				}
			
			compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.setPM_IL_PRODUCT_BEAN(PM_IL_PRODUCT_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	
	
	//added by agalya on 05/07/2016 for field validation, ref no- FALCONQC-1714490
	public String GetPROD_MORT_CODEDesc(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Appondesc="";
		
		try {
			
			String query= "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE=?";
			
				resultSet = new CRUDHandler().executeSelectStatement(query,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Appondesc=resultSet.getString("PC_DESC");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return Appondesc;

	}
	
	
	//end
	
	
	
	
	
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL Default currency desc onload*/
	 public String getDefaultCurrencyDesc(String currcode){
		 
			
			
			String query = "SELECT CURR_NAME FROM PM_CURRENCY where CURR_CODE= ?";
			
			String CURR_NAME = null;
			
			ResultSet resultSet = null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { currcode });
				if (resultSet.next()) {
					CURR_NAME = resultSet.getString("CURR_NAME");
				}
				
				
		
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return CURR_NAME;
	 }
}

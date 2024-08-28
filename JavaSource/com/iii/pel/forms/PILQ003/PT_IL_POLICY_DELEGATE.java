package com.iii.pel.forms.PILQ003;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_DELEGATE { 
    
public void executeSelectStatement (PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN) throws Exception { 
		 String selectStatement="SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID =?";        
	
         Connection connection=null;
         ResultSet resultSet=null;
         Object[] queryObject = null;
         try {
        connection=CommonUtils.getConnection();
        
        if(PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()!=null){
        	selectStatement="SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE POL_SYS_ID =?";
        	queryObject = new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()};
        }else{
        	queryObject = new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getROWID()};
        }
        
        resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,queryObject);
         
         if(PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()!=null)
         resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,
            	 new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
         
         PT_IL_POLICY PT_IL_POLICY_BEAN = new PT_IL_POLICY();
         while (resultSet.next()) {
            PT_IL_POLICY_BEAN.setROWID(resultSet.getString("ROWID"));
            PT_IL_POLICY_BEAN.setPOL_PROD_GROUP_CODE(resultSet.getString("POL_PROD_GROUP_CODE"));
            PT_IL_POLICY_BEAN.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
            PT_IL_POLICY_BEAN.setPOL_PROP_SYS_ID(resultSet.getDouble("POL_PROP_SYS_ID"));
            PT_IL_POLICY_BEAN.setPOL_PROP_NO(resultSet.getString("POL_PROP_NO"));
            PT_IL_POLICY_BEAN.setPOL_DIVN_CODE(resultSet.getString("POL_DIVN_CODE"));
            PT_IL_POLICY_BEAN.setPOL_DEPT_CODE(resultSet.getString("POL_DEPT_CODE"));
            PT_IL_POLICY_BEAN.setPOL_DS_CODE(resultSet.getString("POL_DS_CODE"));
            PT_IL_POLICY_BEAN.setPOL_CLASS_CODE(resultSet.getString("POL_CLASS_CODE"));
            PT_IL_POLICY_BEAN.setPOL_UW_YEAR(resultSet.getInt("POL_UW_YEAR"));
            PT_IL_POLICY_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
            PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(resultSet.getDate("POL_ISSUE_DT"));
            PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(resultSet.getString("POL_PLAN_CODE"));
            PT_IL_POLICY_BEAN.setPOL_CUST_CODE(resultSet.getString("POL_CUST_CODE"));
            PT_IL_POLICY_BEAN.setPOL_CONT_CODE(resultSet.getString("POL_CONT_CODE"));
            PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(resultSet.getString("POL_ASSURED_NAME"));
            PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(resultSet.getString("POL_RES_ADDRESS_1"));
            PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(resultSet.getString("POL_RES_ADDRESS_2"));
            PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(resultSet.getString("POL_RES_ADDRESS_3"));
            PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_1(resultSet.getString("POL_OFF_ADDRESS_1"));
            PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_2(resultSet.getString("POL_OFF_ADDRESS_2"));
            PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_3(resultSet.getString("POL_OFF_ADDRESS_3"));
            PT_IL_POLICY_BEAN.setPOL_SA_CURR_CODE(resultSet.getString("POL_SA_CURR_CODE"));
            PT_IL_POLICY_BEAN.setPOL_SA_EXCH_RATE(resultSet.getDouble("POL_SA_EXCH_RATE"));
            PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE(resultSet.getString("POL_CUST_CURR_CODE"));
            PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(resultSet.getDouble("POL_CUST_EXCH_RATE"));
            PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(resultSet.getDouble("POL_FC_SUM_ASSURED"));
            PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(resultSet.getDouble("POL_LC_SUM_ASSURED"));
            PT_IL_POLICY_BEAN.setPOL_FC_CURR_SA(resultSet.getDouble("POL_FC_CURR_SA"));
            PT_IL_POLICY_BEAN.setPOL_LC_CURR_SA(resultSet.getDouble("POL_LC_CURR_SA"));
            PT_IL_POLICY_BEAN.setPOL_PERIOD(resultSet.getInt("POL_PERIOD"));
            PT_IL_POLICY_BEAN.setPOL_START_DT(resultSet.getDate("POL_START_DT"));
            PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(resultSet.getDate("POL_EXPIRY_DT"));
            PT_IL_POLICY_BEAN.setPOL_BASIC_RATE(resultSet.getDouble("POL_BASIC_RATE"));
            PT_IL_POLICY_BEAN.setPOL_NL_FM_DT(resultSet.getDate("POL_NL_FM_DT"));
            PT_IL_POLICY_BEAN.setPOL_NL_TO_DT(resultSet.getDate("POL_NL_TO_DT"));
            PT_IL_POLICY_BEAN.setPOL_OCC_RATE(resultSet.getDouble("POL_OCC_RATE"));
            PT_IL_POLICY_BEAN.setPOL_HEALTH_RATE(resultSet.getDouble("POL_HEALTH_RATE"));
            PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(resultSet.getDouble("POL_FC_BASIC_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM(resultSet.getDouble("POL_LC_BASIC_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_ADDL_PREM(resultSet.getDouble("POL_FC_ADDL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_ADDL_PREM(resultSet.getDouble("POL_LC_ADDL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_OCC_LOAD(resultSet.getDouble("POL_FC_OCC_LOAD"));
            PT_IL_POLICY_BEAN.setPOL_LC_OCC_LOAD(resultSet.getDouble("POL_LC_OCC_LOAD"));
            PT_IL_POLICY_BEAN.setPOL_FC_HEALTH_LOAD(resultSet.getDouble("POL_FC_HEALTH_LOAD"));
            PT_IL_POLICY_BEAN.setPOL_LC_HEALTH_LOAD(resultSet.getDouble("POL_LC_HEALTH_LOAD"));
            PT_IL_POLICY_BEAN.setPOL_FC_DEPOSIT_AMOUNT(resultSet.getDouble("POL_FC_DEPOSIT_AMOUNT"));
            PT_IL_POLICY_BEAN.setPOL_LC_DEPOSIT_AMOUNT(resultSet.getDouble("POL_LC_DEPOSIT_AMOUNT"));
            PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT(resultSet.getString("POL_MODE_OF_PYMT"));
            PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT_RATE(resultSet.getDouble("POL_MODE_OF_PYMT_RATE"));
            PT_IL_POLICY_BEAN.setPOL_BNFCY_DTLS(resultSet.getString("POL_BNFCY_DTLS"));
            PT_IL_POLICY_BEAN.setPOL_BNFCY_DTLS_2(resultSet.getString("POL_BNFCY_DTLS_2"));
            PT_IL_POLICY_BEAN.setPOL_REMARKS(resultSet.getString("POL_REMARKS"));
            PT_IL_POLICY_BEAN.setPOL_FIRST_INST_DT(resultSet.getDate("POL_FIRST_INST_DT"));
            PT_IL_POLICY_BEAN.setPOL_LAST_INST_DT(resultSet.getDate("POL_LAST_INST_DT"));
            PT_IL_POLICY_BEAN.setPOL_NO_YRS_PREM_PAID(resultSet.getInt("POL_NO_YRS_PREM_PAID"));
            PT_IL_POLICY_BEAN.setPOL_FACIN_YN(resultSet.getString("POL_FACIN_YN"));
            PT_IL_POLICY_BEAN.setPOL_FAC_YN(resultSet.getString("POL_FAC_YN"));
            PT_IL_POLICY_BEAN.setPOL_COINS_YN(resultSet.getString("POL_COINS_YN"));
            PT_IL_POLICY_BEAN.setPOL_RI_CLOSE_FLAG(resultSet.getString("POL_RI_CLOSE_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_FAC_CLOSE_FLAG(resultSet.getString("POL_FAC_CLOSE_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_STATUS(resultSet.getString("POL_STATUS"));
            PT_IL_POLICY_BEAN.setPOL_APPRV_STATUS(resultSet.getString("POL_APPRV_STATUS"));
            PT_IL_POLICY_BEAN.setPOL_APPRV_DT(resultSet.getDate("POL_APPRV_DT"));
            PT_IL_POLICY_BEAN.setPOL_END_TYPE(resultSet.getString("POL_END_TYPE"));
            PT_IL_POLICY_BEAN.setPOL_END_CODE(resultSet.getString("POL_END_CODE"));
            PT_IL_POLICY_BEAN.setPOL_END_NO_IDX(resultSet.getInt("POL_END_NO_IDX"));
            PT_IL_POLICY_BEAN.setPOL_END_DT(resultSet.getDate("POL_END_DT"));
            PT_IL_POLICY_BEAN.setPOL_END_NO(resultSet.getString("POL_END_NO"));
            PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(resultSet.getDate("POL_END_EFF_FROM_DT"));
            PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(resultSet.getDate("POL_END_EFF_TO_DT"));
            PT_IL_POLICY_BEAN.setPOL_END_DESC(resultSet.getString("POL_END_DESC"));
            PT_IL_POLICY_BEAN.setPOL_CR_DT(resultSet.getDate("POL_CR_DT"));
            PT_IL_POLICY_BEAN.setPOL_CR_UID(resultSet.getString("POL_CR_UID"));
            PT_IL_POLICY_BEAN.setPOL_UPD_DT(resultSet.getDate("POL_UPD_DT"));
            PT_IL_POLICY_BEAN.setPOL_UPD_UID(resultSet.getString("POL_UPD_UID"));
            PT_IL_POLICY_BEAN.setPOL_PREM_WAIVE_YN(resultSet.getString("POL_PREM_WAIVE_YN"));
            PT_IL_POLICY_BEAN.setPOL_CANCEL_DT(resultSet.getDate("POL_CANCEL_DT"));
            PT_IL_POLICY_BEAN.setPOL_PAIDUP_DT(resultSet.getDate("POL_PAIDUP_DT"));
            PT_IL_POLICY_BEAN.setPOL_CASH_YN(resultSet.getString("POL_CASH_YN"));
            PT_IL_POLICY_BEAN.setPOL_FC_AMAN_PREM(resultSet.getDouble("POL_FC_AMAN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_AMAN_PREM(resultSet.getDouble("POL_LC_AMAN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_SENABEL_PREM(resultSet.getDouble("POL_FC_SENABEL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_SENABEL_PREM(resultSet.getDouble("POL_LC_SENABEL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_CREDIT_YN(resultSet.getString("POL_CREDIT_YN"));
            PT_IL_POLICY_BEAN.setPOL_CREDIT_DISCOUNT_PERC(resultSet.getDouble("POL_CREDIT_DISCOUNT_PERC"));
            PT_IL_POLICY_BEAN.setPOL_LOAD_PERC(resultSet.getDouble("POL_LOAD_PERC"));
            PT_IL_POLICY_BEAN.setPOL_PROD_CODE(resultSet.getString("POL_PROD_CODE"));
            PT_IL_POLICY_BEAN.setPOL_DS_TYPE(resultSet.getString("POL_DS_TYPE"));
            PT_IL_POLICY_BEAN.setPOL_PROFIT_RATE(resultSet.getDouble("POL_PROFIT_RATE"));
            PT_IL_POLICY_BEAN.setPOL_FC_PROFIT(resultSet.getDouble("POL_FC_PROFIT"));
            PT_IL_POLICY_BEAN.setPOL_LC_PROFIT(resultSet.getDouble("POL_LC_PROFIT"));
            PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_YN(resultSet.getString("POL_JOINT_LIFE_YN"));
            PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_AGE(resultSet.getInt("POL_JOINT_LIFE_AGE"));
            PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(resultSet.getInt("POL_PREM_PAY_YRS"));
            PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE(resultSet.getString("POL_EMPLOYER_CODE"));
            PT_IL_POLICY_BEAN.setPOL_TARIFF_TERM_FLAG(resultSet.getString("POL_TARIFF_TERM_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_RATE_APPLIED_ON(resultSet.getString("POL_RATE_APPLIED_ON"));
            PT_IL_POLICY_BEAN.setPOL_EXC_INT_PERC(resultSet.getDouble("POL_EXC_INT_PERC"));
            PT_IL_POLICY_BEAN.setPOL_FC_EXC_INT_AMT(resultSet.getDouble("POL_FC_EXC_INT_AMT"));
            PT_IL_POLICY_BEAN.setPOL_LC_EXC_INT_AMT(resultSet.getDouble("POL_LC_EXC_INT_AMT"));
            PT_IL_POLICY_BEAN.setPOL_HOLD_YN(resultSet.getString("POL_HOLD_YN"));
            PT_IL_POLICY_BEAN.setPOL_STAFF_YN(resultSet.getString("POL_STAFF_YN"));
            PT_IL_POLICY_BEAN.setPOL_STAFF_CCLASS_CODE(resultSet.getString("POL_STAFF_CCLASS_CODE"));
            PT_IL_POLICY_BEAN.setPOL_FC_DISC_AMT(resultSet.getDouble("POL_FC_DISC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_LC_DISC_AMT(resultSet.getDouble("POL_LC_DISC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_STD_RISK_YN(resultSet.getString("POL_STD_RISK_YN"));
            PT_IL_POLICY_BEAN.setPOL_CQS_YN(resultSet.getString("POL_CQS_YN"));
            PT_IL_POLICY_BEAN.setPOL_CQS_PERC(resultSet.getDouble("POL_CQS_PERC"));
            PT_IL_POLICY_BEAN.setPOL_FC_FIRST_PREM(resultSet.getDouble("POL_FC_FIRST_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_FIRST_PREM(resultSet.getDouble("POL_LC_FIRST_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_SUM_ASSURED(resultSet.getDouble("POL_ORG_FC_SUM_ASSURED"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_SUM_ASSURED(resultSet.getDouble("POL_ORG_LC_SUM_ASSURED"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_CURR_SA(resultSet.getDouble("POL_ORG_FC_CURR_SA"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_CURR_SA(resultSet.getDouble("POL_ORG_LC_CURR_SA"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_BASIC_PREM(resultSet.getDouble("POL_ORG_FC_BASIC_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_BASIC_PREM(resultSet.getDouble("POL_ORG_LC_BASIC_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_ADDL_PREM(resultSet.getDouble("POL_ORG_FC_ADDL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_ADDL_PREM(resultSet.getDouble("POL_ORG_LC_ADDL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_FIRST_PREM(resultSet.getDouble("POL_ORG_FC_FIRST_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_FIRST_PREM(resultSet.getDouble("POL_ORG_LC_FIRST_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_DISC_AMT(resultSet.getDouble("POL_ORG_FC_DISC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_DISC_AMT(resultSet.getDouble("POL_ORG_LC_DISC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_PREM_PAY_YRS(resultSet.getDouble("POL_ORG_PREM_PAY_YRS"));
            PT_IL_POLICY_BEAN.setPOL_ORG_PERIOD(resultSet.getDouble("POL_ORG_PERIOD"));
            PT_IL_POLICY_BEAN.setPOL_ORG_BASIC_RATE(resultSet.getDouble("POL_ORG_BASIC_RATE"));
            PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_PER(resultSet.getDouble("POL_BASIC_RATE_PER"));
            PT_IL_POLICY_BEAN.setPOL_RES_PHONE_NO(resultSet.getString("POL_RES_PHONE_NO"));
            PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE(resultSet.getString("POL_RES_AREA_CODE"));
            PT_IL_POLICY_BEAN.setPOL_OFF_PHONE_NO(resultSet.getString("POL_OFF_PHONE_NO"));
            PT_IL_POLICY_BEAN.setPOL_OFF_AREA_CODE(resultSet.getString("POL_OFF_AREA_CODE"));
            PT_IL_POLICY_BEAN.setPOL_FAX_NO(resultSet.getString("POL_FAX_NO"));
            PT_IL_POLICY_BEAN.setPOL_FAX_AREA_CODE(resultSet.getString("POL_FAX_AREA_CODE"));
            PT_IL_POLICY_BEAN.setPOL_MASTER_POL_NO(resultSet.getString("POL_MASTER_POL_NO"));
            PT_IL_POLICY_BEAN.setPOL_ADDL_STATUS(resultSet.getString("POL_ADDL_STATUS"));
            PT_IL_POLICY_BEAN.setPOL_BANK_REF_NO(resultSet.getString("POL_BANK_REF_NO"));
            PT_IL_POLICY_BEAN.setPOL_PROP_REF_NO(resultSet.getString("POL_PROP_REF_NO"));
            PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN(resultSet.getString("POL_INCORPORATED_YN"));
            PT_IL_POLICY_BEAN.setPOL_NET_PREM_YN(resultSet.getString("POL_NET_PREM_YN"));
            PT_IL_POLICY_BEAN.setPOL_CREDIT_INT_RATE(resultSet.getDouble("POL_CREDIT_INT_RATE"));
            PT_IL_POLICY_BEAN.setPOL_DEFER_PRD(resultSet.getDouble("POL_DEFER_PRD"));
            PT_IL_POLICY_BEAN.setPOL_MODE_OF_CALC(resultSet.getString("POL_MODE_OF_CALC"));
            PT_IL_POLICY_BEAN.setPOL_PYMT_TYPE(resultSet.getString("POL_PYMT_TYPE"));
            PT_IL_POLICY_BEAN.setPOL_GRANTEE_TYPE(resultSet.getString("POL_GRANTEE_TYPE"));
            PT_IL_POLICY_BEAN.setPOL_GRANTEE_NAME(resultSet.getString("POL_GRANTEE_NAME"));
            PT_IL_POLICY_BEAN.setPOL_BANK_BRANCH_NAME(resultSet.getString("POL_BANK_BRANCH_NAME"));
            PT_IL_POLICY_BEAN.setPOL_AGENT_REF_CODE(resultSet.getString("POL_AGENT_REF_CODE"));
            PT_IL_POLICY_BEAN.setPOL_FC_BANK_ALLOC_AMT(resultSet.getDouble("POL_FC_BANK_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_LC_BANK_ALLOC_AMT(resultSet.getDouble("POL_LC_BANK_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_FC_CLIENT_ALLOC_AMT(resultSet.getDouble("POL_FC_CLIENT_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_LC_CLIENT_ALLOC_AMT(resultSet.getDouble("POL_LC_CLIENT_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_FC_TOT_SA(resultSet.getDouble("POL_FC_TOT_SA"));
            PT_IL_POLICY_BEAN.setPOL_LC_TOT_SA(resultSet.getDouble("POL_LC_TOT_SA"));
            PT_IL_POLICY_BEAN.setPOL_FC_NET_PREM(resultSet.getDouble("POL_FC_NET_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_NET_PREM(resultSet.getDouble("POL_LC_NET_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_PRE_TPD_BNF(resultSet.getDouble("POL_FC_PRE_TPD_BNF"));
            PT_IL_POLICY_BEAN.setPOL_LC_PRE_TPD_BNF(resultSet.getDouble("POL_LC_PRE_TPD_BNF"));
            PT_IL_POLICY_BEAN.setPOL_FRZ_FLAG(resultSet.getString("POL_FRZ_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_BANK_ALLOC_AMT(resultSet.getDouble("POL_ORG_FC_BANK_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_BANK_ALLOC_AMT(resultSet.getDouble("POL_ORG_LC_BANK_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_CLIENT_ALLOC_AMT(resultSet.getDouble("POL_ORG_FC_CLIENT_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_CLIENT_ALLOC_AMT(resultSet.getDouble("POL_ORG_LC_CLIENT_ALLOC_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_TOT_SA(resultSet.getDouble("POL_ORG_FC_TOT_SA"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_TOT_SA(resultSet.getDouble("POL_ORG_LC_TOT_SA"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_NET_PREM(resultSet.getDouble("POL_ORG_FC_NET_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_NET_PREM(resultSet.getDouble("POL_ORG_LC_NET_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_PRE_TPD_BNF(resultSet.getDouble("POL_ORG_FC_PRE_TPD_BNF"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_PRE_TPD_BNF(resultSet.getDouble("POL_ORG_LC_PRE_TPD_BNF"));
            PT_IL_POLICY_BEAN.setPOL_NO_OF_INST(resultSet.getInt("POL_NO_OF_INST"));
            PT_IL_POLICY_BEAN.setPOL_ORG_NO_OF_INST(resultSet.getInt("POL_ORG_NO_OF_INST"));
            PT_IL_POLICY_BEAN.setPOL_DEVELOPER_CODE(resultSet.getString("POL_DEVELOPER_CODE"));
            PT_IL_POLICY_BEAN.setPOL_PROJECT_CODE(resultSet.getString("POL_PROJECT_CODE"));
            PT_IL_POLICY_BEAN.setPOL_HOME_OWNER_FLAG(resultSet.getString("POL_HOME_OWNER_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_01(resultSet.getString("POL_FLEX_01"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_02(resultSet.getString("POL_FLEX_02"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_03(resultSet.getString("POL_FLEX_03"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_04(resultSet.getString("POL_FLEX_04"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_05(resultSet.getString("POL_FLEX_05"));
            PT_IL_POLICY_BEAN.setPOL_PROP_RECV_DT(resultSet.getDate("POL_PROP_RECV_DT"));
            PT_IL_POLICY_BEAN.setPOL_PROP_STAMP_DT(resultSet.getDate("POL_PROP_STAMP_DT"));
            PT_IL_POLICY_BEAN.setPOL_PROP_DECL_DT(resultSet.getDate("POL_PROP_DECL_DT"));
            PT_IL_POLICY_BEAN.setPOL_FC_TOP_UP_AMT(resultSet.getDouble("POL_FC_TOP_UP_AMT"));
            PT_IL_POLICY_BEAN.setPOL_LC_TOP_UP_AMT(resultSet.getDouble("POL_LC_TOP_UP_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_TOP_UP_AMT(resultSet.getDouble("POL_ORG_FC_TOP_UP_AMT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_TOP_UP_AMT(resultSet.getDouble("POL_ORG_LC_TOP_UP_AMT"));
            PT_IL_POLICY_BEAN.setPOL_INTRODUCER_REF_ID1(resultSet.getString("POL_INTRODUCER_REF_ID1"));
            PT_IL_POLICY_BEAN.setPOL_PROP_QUOT_FLAG(resultSet.getString("POL_PROP_QUOT_FLAG"));
            PT_IL_POLICY_BEAN.setPOL_FC_PAYOR_PREM(resultSet.getDouble("POL_FC_PAYOR_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_PAYOR_PREM(resultSet.getDouble("POL_LC_PAYOR_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_PAYEE_PREM(resultSet.getDouble("POL_FC_PAYEE_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_PAYEE_PREM(resultSet.getDouble("POL_LC_PAYEE_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_PAYOR_PREM(resultSet.getDouble("POL_ORG_FC_PAYOR_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_PAYOR_PREM(resultSet.getDouble("POL_ORG_LC_PAYOR_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_PAYEE_PREM(resultSet.getDouble("POL_ORG_FC_PAYEE_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_PAYEE_PREM(resultSet.getDouble("POL_ORG_LC_PAYEE_PREM"));
            PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS(resultSet.getString("POL_SRC_OF_BUS"));
            PT_IL_POLICY_BEAN.setPOL_POSTPONE_DAYS(resultSet.getDouble("POL_POSTPONE_DAYS"));
            PT_IL_POLICY_BEAN.setPOL_POSTPONE_EXPIRY_DT(resultSet.getDate("POL_POSTPONE_EXPIRY_DT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_PROP_RECV_YN(resultSet.getString("POL_ORG_PROP_RECV_YN"));
            PT_IL_POLICY_BEAN.setPOL_FAC_BASIS(resultSet.getString("POL_FAC_BASIS"));
            PT_IL_POLICY_BEAN.setPOL_RI_POOL_CODE(resultSet.getString("POL_RI_POOL_CODE"));
            PT_IL_POLICY_BEAN.setPOL_TRAN_DT(resultSet.getDate("POL_TRAN_DT"));
            PT_IL_POLICY_BEAN.setPOL_CONVERT_YN(resultSet.getString("POL_CONVERT_YN"));
            PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(resultSet.getString("POL_ASSRD_REF_ID1"));
            PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(resultSet.getString("POL_ASSRD_REF_ID2"));
            PT_IL_POLICY_BEAN.setPOL_APPRV_UID(resultSet.getString("POL_APPRV_UID"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_06(resultSet.getString("POL_FLEX_06"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_07(resultSet.getString("POL_FLEX_07"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_08(resultSet.getString("POL_FLEX_08"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_09(resultSet.getString("POL_FLEX_09"));
            PT_IL_POLICY_BEAN.setPOL_FLEX_10(resultSet.getString("POL_FLEX_10"));
            PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(resultSet.getDouble("POL_LC_MODAL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(resultSet.getDouble("POL_FC_MODAL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_MODAL_PREM(resultSet.getDouble("POL_ORG_FC_MODAL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_MODAL_PREM(resultSet.getDouble("POL_ORG_LC_MODAL_PREM"));
            PT_IL_POLICY_BEAN.setPOL_CITY_CODE(resultSet.getString("POL_CITY_CODE"));
            PT_IL_POLICY_BEAN.setPOL_STATE_CODE(resultSet.getString("POL_STATE_CODE"));
            PT_IL_POLICY_BEAN.setPOL_COUNT_CODE(resultSet.getString("POL_COUNT_CODE"));
            PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(resultSet.getString("POL_MOBILE_NO"));
            PT_IL_POLICY_BEAN.setPOL_FORM_NO(resultSet.getString("POL_FORM_NO"));
            PT_IL_POLICY_BEAN.setPOL_CLM_ADDL_STATUS(resultSet.getString("POL_CLM_ADDL_STATUS"));
            PT_IL_POLICY_BEAN.setPOL_LINK_SYS_ID(resultSet.getDouble("POL_LINK_SYS_ID"));
            PT_IL_POLICY_BEAN.setPOL_PROP_END_TYPE(resultSet.getString("POL_PROP_END_TYPE"));
            PT_IL_POLICY_BEAN.setPOL_PROP_END_CODE(resultSet.getString("POL_PROP_END_CODE"));
            PT_IL_POLICY_BEAN.setPOL_MED_FEE_RECOVER_YN(resultSet.getString("POL_MED_FEE_RECOVER_YN"));
            PT_IL_POLICY_BEAN.setPOL_END_APPRV_DT(resultSet.getDate("POL_END_APPRV_DT"));
            PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT(resultSet.getDouble("POL_NO_OF_UNIT"));
            PT_IL_POLICY_BEAN.setPOL_ORG_NO_OF_UNIT(resultSet.getDouble("POL_ORG_NO_OF_UNIT"));
            PT_IL_POLICY_BEAN.setPOL_FC_NETT_PREM(resultSet.getDouble("POL_FC_NETT_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_NETT_PREM(resultSet.getDouble("POL_LC_NETT_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_NETT_PREM(resultSet.getDouble("POL_ORG_FC_NETT_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_NETT_PREM(resultSet.getDouble("POL_ORG_LC_NETT_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_MIN_PREM(resultSet.getDouble("POL_LC_MIN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_MIN_PREM(resultSet.getDouble("POL_FC_MIN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_FC_EXTRA_PREM(resultSet.getDouble("POL_FC_EXTRA_PREM"));
            PT_IL_POLICY_BEAN.setPOL_LC_EXTRA_PREM(resultSet.getDouble("POL_LC_EXTRA_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_EXTRA_PREM(resultSet.getDouble("POL_ORG_LC_EXTRA_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_MIN_PREM(resultSet.getDouble("POL_ORG_FC_MIN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_LC_MIN_PREM(resultSet.getDouble("POL_ORG_LC_MIN_PREM"));
            PT_IL_POLICY_BEAN.setPOL_ORG_FC_EXTRA_PREM(resultSet.getDouble("POL_ORG_FC_EXTRA_PREM"));
            PT_IL_POLICY_BEAN.setPOL_SUB_PLAN_CODE(resultSet.getString("POL_SUB_PLAN_CODE"));
            PT_IL_POLICY_BEAN.setPOL_ORG_SUB_PLAN_CODE(resultSet.getString("POL_ORG_SUB_PLAN_CODE"));
           // PT_IL_POLICY_BEAN.setPOL_PROD_GROUP_CODE(resultSet.getString("POL_PROD_GROUP_CODE"));
            
        }
        PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().setPT_IL_POLICY_BEAN(PT_IL_POLICY_BEAN);
         } catch(Exception exception){
             exception.printStackTrace();
             throw new Exception(exception.getMessage());
         }
         finally { 
         CommonUtils.closeCursor(resultSet);
        } 
        } 

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
        	}  finally{
        		try {
        			CommonUtils.closeCursor(resultSet);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
        	return suggestionList;
        }


}

package com.iii.pel.forms.PILT002_APAC;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PT_IL_POLICY_DELEGATE{
	
  public void executeSelectStatement(
		  PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
    throws Exception  {
    String selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID =?";

    Connection connection = null;
    ResultSet resultSet = null;
    Object[] queryObject = (Object[])null;
    PT_IL_POLICY PT_IL_POLICY_BEAN = null;
    //Added by saranya 
    ArrayList<String> list3=null;
	ArrayList<String> list4=null;
	DBProcedures procedures = new DBProcedures();
	//End
	/*Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer Master Changes COMMENTS*/
	 LIFELIB lifelib = new LIFELIB();
     ArrayList<String> pvalList = new ArrayList<String>();
     /*end*/
    try {
      connection = CommonUtils.getConnection();

      if (PILT002_APAC_COMPOSITE_ACTION_BEAN
        .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
        .getPOL_SYS_ID() != null) {
        selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE POL_SYS_ID =?";
        queryObject = new Object[] { PILT002_APAC_COMPOSITE_ACTION_BEAN
          .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
          .getPOL_SYS_ID() };
      } else {
        queryObject = new Object[] { PILT002_APAC_COMPOSITE_ACTION_BEAN
          .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
          .getROWID() };
      }

      resultSet = new CRUDHandler().executeSelectStatement(
        selectStatement, connection, queryObject);

      if (PILT002_APAC_COMPOSITE_ACTION_BEAN
        .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
        .getPOL_SYS_ID() != null) {
        resultSet = new CRUDHandler().executeSelectStatement(
          selectStatement, connection, 
          new Object[] { PILT002_APAC_COMPOSITE_ACTION_BEAN
          .getPT_IL_POLICY_ACTION_BEAN()
          .getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
        PT_IL_POLICY_BEAN = PILT002_APAC_COMPOSITE_ACTION_BEAN
          .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
      } else {
        PT_IL_POLICY_BEAN = new PT_IL_POLICY();
      }
      while (resultSet.next()) {
        PT_IL_POLICY_BEAN.setROWID(resultSet.getString("ROWID"));
        PT_IL_POLICY_BEAN.setPOL_PROD_GROUP_CODE(
          resultSet.getString("POL_PROD_GROUP_CODE"));
        PT_IL_POLICY_BEAN
          .setPOL_SYS_ID(Long.valueOf(resultSet.getLong("POL_SYS_ID")));
        PT_IL_POLICY_BEAN.setPOL_PROP_SYS_ID(
          Double.valueOf(resultSet.getDouble("POL_PROP_SYS_ID")));
        PT_IL_POLICY_BEAN.setPOL_PROP_NO(
          resultSet.getString("POL_PROP_NO"));
        PT_IL_POLICY_BEAN.setPOL_DIVN_CODE(
          resultSet.getString("POL_DIVN_CODE"));
        PT_IL_POLICY_BEAN.setPOL_DEPT_CODE(
          resultSet.getString("POL_DEPT_CODE"));
        PT_IL_POLICY_BEAN.setPOL_DS_CODE(
          resultSet.getString("POL_DS_CODE"));
        PT_IL_POLICY_BEAN.setPOL_CLASS_CODE(
          resultSet.getString("POL_CLASS_CODE"));
        PT_IL_POLICY_BEAN.setPOL_UW_YEAR(
          Integer.valueOf(resultSet.getInt("POL_UW_YEAR")));
        PT_IL_POLICY_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
        /*Added by saranya for APL Processs*/
        PT_IL_POLICY_BEAN.setPOL_APL_YN(
                resultSet.getString("POL_APL_YN"));
        /*End*/

        /* Added by saranya for  RM018T - FSD_IL_ZB Life_013_Underwriting changes  on 02-11-2016*/
        PT_IL_POLICY_BEAN.setPOL_FC_AGENT_PREM(resultSet.getDouble("POL_FC_AGENT_PREM"));
        PT_IL_POLICY_BEAN.setPOL_LC_AGENT_PREM(resultSet.getDouble("POL_FC_AGENT_PREM"));
        /*End*/
        /*Added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1.0*/
        PT_IL_POLICY_BEAN.setPOL_CANCEL_YN(resultSet.getString("POL_FLEX_27"));
        /*End*/
        
        PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(
          resultSet.getTimestamp("POL_ISSUE_DT"));//added by dhinesh for FALCONLIFE-1349311 on 17-10-16
        PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(
          resultSet.getString("POL_PLAN_CODE"));
        PT_IL_POLICY_BEAN.setPOL_CUST_CODE(
          resultSet.getString("POL_CUST_CODE"));
        PT_IL_POLICY_BEAN.setPOL_CONT_CODE(
          resultSet.getString("POL_CONT_CODE"));
        PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(
          resultSet.getString("POL_ASSURED_NAME"));
        PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(
          resultSet.getString("POL_RES_ADDRESS_1"));
        PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(
          resultSet.getString("POL_RES_ADDRESS_2"));
        PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(
          resultSet.getString("POL_RES_ADDRESS_3"));
        PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_1(
          resultSet.getString("POL_OFF_ADDRESS_1"));
        PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_2(
          resultSet.getString("POL_OFF_ADDRESS_2"));
        PT_IL_POLICY_BEAN.setPOL_OFF_ADDRESS_3(
          resultSet.getString("POL_OFF_ADDRESS_3"));
        PT_IL_POLICY_BEAN.setPOL_SA_CURR_CODE(
          resultSet.getString("POL_SA_CURR_CODE"));
        PT_IL_POLICY_BEAN.setPOL_SA_EXCH_RATE(
          Double.valueOf(resultSet.getDouble("POL_SA_EXCH_RATE")));
        PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE(
          resultSet.getString("POL_CUST_CURR_CODE"));
        PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(
          Double.valueOf(resultSet.getDouble("POL_CUST_EXCH_RATE")));
        PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(
          Double.valueOf(resultSet.getDouble("POL_FC_SUM_ASSURED")));
        PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(
          Double.valueOf(resultSet.getDouble("POL_LC_SUM_ASSURED")));
        PT_IL_POLICY_BEAN.setPOL_FC_CURR_SA(
          Double.valueOf(resultSet.getDouble("POL_FC_CURR_SA")));
        PT_IL_POLICY_BEAN.setPOL_LC_CURR_SA(
          Double.valueOf(resultSet.getDouble("POL_LC_CURR_SA")));
        PT_IL_POLICY_BEAN.setPOL_PERIOD(Integer.valueOf(resultSet.getInt("POL_PERIOD")));
       //date data type changed by gopi for timestamp on 01/05/18
        
        PT_IL_POLICY_BEAN.setPOL_START_DT(
          resultSet.getTimestamp("POL_START_DT"));
        PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(
          resultSet.getTimestamp("POL_EXPIRY_DT"));
       
        //end
        PT_IL_POLICY_BEAN.setPOL_BASIC_RATE(
          Double.valueOf(resultSet.getDouble("POL_BASIC_RATE")));
        PT_IL_POLICY_BEAN.setPOL_NL_FM_DT(
          resultSet.getDate("POL_NL_FM_DT"));
        PT_IL_POLICY_BEAN.setPOL_NL_TO_DT(
          resultSet.getDate("POL_NL_TO_DT"));
        PT_IL_POLICY_BEAN.setPOL_OCC_RATE(
          Double.valueOf(resultSet.getDouble("POL_OCC_RATE")));
        PT_IL_POLICY_BEAN.setPOL_HEALTH_RATE(
          Double.valueOf(resultSet.getDouble("POL_HEALTH_RATE")));
        PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_BASIC_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_BASIC_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_ADDL_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_ADDL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_ADDL_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_ADDL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_OCC_LOAD(
          Double.valueOf(resultSet.getDouble("POL_FC_OCC_LOAD")));
        PT_IL_POLICY_BEAN.setPOL_LC_OCC_LOAD(
          Double.valueOf(resultSet.getDouble("POL_LC_OCC_LOAD")));
        PT_IL_POLICY_BEAN.setPOL_FC_HEALTH_LOAD(
          Double.valueOf(resultSet.getDouble("POL_FC_HEALTH_LOAD")));
        PT_IL_POLICY_BEAN.setPOL_LC_HEALTH_LOAD(
          Double.valueOf(resultSet.getDouble("POL_LC_HEALTH_LOAD")));
        PT_IL_POLICY_BEAN.setPOL_FC_DEPOSIT_AMOUNT(
          Double.valueOf(resultSet.getDouble("POL_FC_DEPOSIT_AMOUNT")));
        PT_IL_POLICY_BEAN.setPOL_LC_DEPOSIT_AMOUNT(
          Double.valueOf(resultSet.getDouble("POL_LC_DEPOSIT_AMOUNT")));
        PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT(
          resultSet.getString("POL_MODE_OF_PYMT"));
        PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT_RATE(
          Double.valueOf(resultSet.getDouble("POL_MODE_OF_PYMT_RATE")));
        PT_IL_POLICY_BEAN.setPOL_BNFCY_DTLS(
          resultSet.getString("POL_BNFCY_DTLS"));
        PT_IL_POLICY_BEAN.setPOL_BNFCY_DTLS_2(
          resultSet.getString("POL_BNFCY_DTLS_2"));
        PT_IL_POLICY_BEAN.setPOL_REMARKS(
          resultSet.getString("POL_REMARKS"));
        PT_IL_POLICY_BEAN.setPOL_FIRST_INST_DT(
          resultSet.getDate("POL_FIRST_INST_DT"));
        PT_IL_POLICY_BEAN.setPOL_LAST_INST_DT(
          resultSet.getDate("POL_LAST_INST_DT"));
        PT_IL_POLICY_BEAN.setPOL_NO_YRS_PREM_PAID(
          Double.valueOf(resultSet.getDouble("POL_NO_YRS_PREM_PAID")));
        PT_IL_POLICY_BEAN.setPOL_FACIN_YN(
          resultSet.getString("POL_FACIN_YN"));
        PT_IL_POLICY_BEAN.setPOL_FAC_YN(
          resultSet.getString("POL_FAC_YN"));
        PT_IL_POLICY_BEAN.setPOL_COINS_YN(
          resultSet.getString("POL_COINS_YN"));
        PT_IL_POLICY_BEAN.setPOL_RI_CLOSE_FLAG(
          resultSet.getString("POL_RI_CLOSE_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_FAC_CLOSE_FLAG(
          resultSet.getString("POL_FAC_CLOSE_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_STATUS(
          resultSet.getString("POL_STATUS"));
        PT_IL_POLICY_BEAN.setPOL_APPRV_STATUS(
          resultSet.getString("POL_APPRV_STATUS"));
        PT_IL_POLICY_BEAN.setPOL_APPRV_DT(
          resultSet.getDate("POL_APPRV_DT"));
        PT_IL_POLICY_BEAN.setPOL_END_TYPE(
          resultSet.getString("POL_END_TYPE"));
        PT_IL_POLICY_BEAN.setPOL_END_CODE(
          resultSet.getString("POL_END_CODE"));
        PT_IL_POLICY_BEAN.setPOL_END_NO_IDX(
          Integer.valueOf(resultSet.getInt("POL_END_NO_IDX")));
        PT_IL_POLICY_BEAN
          .setPOL_END_DT(resultSet.getDate("POL_END_DT"));
        PT_IL_POLICY_BEAN.setPOL_END_NO(
          resultSet.getString("POL_END_NO"));
        PT_IL_POLICY_BEAN.setPOL_END_EFF_FROM_DT(
          resultSet.getDate("POL_END_EFF_FROM_DT"));
        PT_IL_POLICY_BEAN.setPOL_END_EFF_TO_DT(
          resultSet.getDate("POL_END_EFF_TO_DT"));
        PT_IL_POLICY_BEAN.setPOL_END_DESC(
          resultSet.getString("POL_END_DESC"));
        PT_IL_POLICY_BEAN.setPOL_CR_DT(resultSet.getDate("POL_CR_DT"));
    
        /*Newly Added By Dhinesh on 20.3.2017*/
        PT_IL_POLICY_BEAN.setUI_M_POL_CR_DT(CommonUtils.dateToStringFormat(resultSet.getDate("POL_CR_DT")));
        /*End*/
    
        /*Added by sankara narayanan for uicomponent frz flag on 21-03-2017*/
        PT_IL_POLICY_BEAN.setUI_POL_FRZ_FLAG(
                resultSet.getString("POL_FRZ_FLAG")); //end
        
        
        PT_IL_POLICY_BEAN.setPOL_CR_UID(
          resultSet.getString("POL_CR_UID"));
        PT_IL_POLICY_BEAN
          .setPOL_UPD_DT(resultSet.getDate("POL_UPD_DT"));
        PT_IL_POLICY_BEAN.setOLD_UPD_DT(
          resultSet.getTimestamp("POL_UPD_DT"));
        PT_IL_POLICY_BEAN.setPOL_UPD_UID(
          resultSet.getString("POL_UPD_UID"));
        PT_IL_POLICY_BEAN.setPOL_PREM_WAIVE_YN(
          resultSet.getString("POL_PREM_WAIVE_YN"));
        PT_IL_POLICY_BEAN.setPOL_CANCEL_DT(
          resultSet.getDate("POL_CANCEL_DT"));
        PT_IL_POLICY_BEAN.setPOL_PAIDUP_DT(
          resultSet.getDate("POL_PAIDUP_DT"));
        PT_IL_POLICY_BEAN.setPOL_CASH_YN(
          resultSet.getString("POL_CASH_YN"));
        PT_IL_POLICY_BEAN.setPOL_FC_AMAN_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_AMAN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_AMAN_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_AMAN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_SENABEL_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_SENABEL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_SENABEL_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_SENABEL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_CREDIT_YN(
          resultSet.getString("POL_CREDIT_YN"));
        PT_IL_POLICY_BEAN.setPOL_CREDIT_DISCOUNT_PERC(
          Double.valueOf(resultSet.getDouble("POL_CREDIT_DISCOUNT_PERC")));
        PT_IL_POLICY_BEAN.setPOL_LOAD_PERC(
          Double.valueOf(resultSet.getDouble("POL_LOAD_PERC")));
        PT_IL_POLICY_BEAN.setPOL_PROD_CODE(
          resultSet.getString("POL_PROD_CODE"));
        PT_IL_POLICY_BEAN.setPOL_DS_TYPE(
          resultSet.getString("POL_DS_TYPE"));
        PT_IL_POLICY_BEAN.setUI_M_ACC_NAME(resultSet.getString("POL_CUST_ACNT_NAME"));
       /*added by krithika*/
        FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
			session.setAttribute("POL_DS_TYPE",resultSet.getString("POL_DS_TYPE"));
			//added by krithika for mortage product
			session.setAttribute("POL_PROD_CODE",resultSet.getString("POL_PROD_CODE"));
        System.out.println("session"+session. getAttribute("POL_DS_TYPE"));
        
     /*   end*/
        PT_IL_POLICY_BEAN.setPOL_PROFIT_RATE(
          Double.valueOf(resultSet.getDouble("POL_PROFIT_RATE")));
        PT_IL_POLICY_BEAN.setPOL_FC_PROFIT(
          Double.valueOf(resultSet.getDouble("POL_FC_PROFIT")));
        PT_IL_POLICY_BEAN.setPOL_LC_PROFIT(
          Double.valueOf(resultSet.getDouble("POL_LC_PROFIT")));
        
        
        System.out.println("resultSet.getString(POL_JOINT_LIFE_YN)      "+resultSet.getString("POL_JOINT_LIFE_YN"));
        
        if(resultSet.getString("POL_JOINT_LIFE_YN") == null)
        {
        	PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_YN("N");
        }
        else
        {
        	PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_YN(
        	          resultSet.getString("POL_JOINT_LIFE_YN"));	
        }
        
        PT_IL_POLICY_BEAN.setPOL_JOINT_LIFE_AGE(
          Integer.valueOf(resultSet.getInt("POL_JOINT_LIFE_AGE")));
        PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(
          Integer.valueOf(resultSet.getInt("POL_PREM_PAY_YRS")));
        PT_IL_POLICY_BEAN.setPOL_EMPLOYER_CODE(
          resultSet.getString("POL_EMPLOYER_CODE"));
        PT_IL_POLICY_BEAN.setPOL_TARIFF_TERM_FLAG(
          resultSet.getString("POL_TARIFF_TERM_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_RATE_APPLIED_ON(
          resultSet.getString("POL_RATE_APPLIED_ON"));
        PT_IL_POLICY_BEAN.setPOL_EXC_INT_PERC(
          Double.valueOf(resultSet.getDouble("POL_EXC_INT_PERC")));
        PT_IL_POLICY_BEAN.setPOL_FC_EXC_INT_AMT(
          Double.valueOf(resultSet.getDouble("POL_FC_EXC_INT_AMT")));
        PT_IL_POLICY_BEAN.setPOL_LC_EXC_INT_AMT(
          Double.valueOf(resultSet.getDouble("POL_LC_EXC_INT_AMT")));
        PT_IL_POLICY_BEAN.setPOL_HOLD_YN(
          resultSet.getString("POL_HOLD_YN"));
        PT_IL_POLICY_BEAN.setPOL_STAFF_YN(
          resultSet.getString("POL_STAFF_YN"));
        PT_IL_POLICY_BEAN.setPOL_STAFF_CCLASS_CODE(
          resultSet.getString("POL_STAFF_CCLASS_CODE"));
        PT_IL_POLICY_BEAN.setPOL_FC_DISC_AMT(
          Double.valueOf(resultSet.getDouble("POL_FC_DISC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_LC_DISC_AMT(
          Double.valueOf(resultSet.getDouble("POL_LC_DISC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_STD_RISK_YN(
          resultSet.getString("POL_STD_RISK_YN"));
        PT_IL_POLICY_BEAN.setPOL_CQS_YN(
          resultSet.getString("POL_CQS_YN"));
        PT_IL_POLICY_BEAN.setPOL_CQS_PERC(
          Double.valueOf(resultSet.getDouble("POL_CQS_PERC")));
        PT_IL_POLICY_BEAN.setPOL_FC_FIRST_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_FIRST_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_FIRST_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_FIRST_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_SUM_ASSURED(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_SUM_ASSURED")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_SUM_ASSURED(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_SUM_ASSURED")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_CURR_SA(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_CURR_SA")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_CURR_SA(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_CURR_SA")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_BASIC_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_BASIC_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_BASIC_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_BASIC_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_ADDL_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_ADDL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_ADDL_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_ADDL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_FIRST_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_FIRST_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_FIRST_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_FIRST_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_DISC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_DISC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_DISC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_DISC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_PREM_PAY_YRS(
          Double.valueOf(resultSet.getDouble("POL_ORG_PREM_PAY_YRS")));
        PT_IL_POLICY_BEAN.setPOL_ORG_PERIOD(
          Integer.valueOf(resultSet.getInt("POL_ORG_PERIOD")));
        PT_IL_POLICY_BEAN.setPOL_ORG_BASIC_RATE(
          Double.valueOf(resultSet.getDouble("POL_ORG_BASIC_RATE")));
        PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_PER(
          Double.valueOf(resultSet.getDouble("POL_BASIC_RATE_PER")));
        PT_IL_POLICY_BEAN.setPOL_RES_PHONE_NO(
          resultSet.getString("POL_RES_PHONE_NO"));
        PT_IL_POLICY_BEAN.setPOL_RES_AREA_CODE(
          resultSet.getString("POL_RES_AREA_CODE"));
        PT_IL_POLICY_BEAN.setPOL_OFF_PHONE_NO(
          resultSet.getString("POL_OFF_PHONE_NO"));
        PT_IL_POLICY_BEAN.setPOL_OFF_AREA_CODE(
          resultSet.getString("POL_OFF_AREA_CODE"));
        PT_IL_POLICY_BEAN.setPOL_FAX_NO(
          resultSet.getString("POL_FAX_NO"));
        PT_IL_POLICY_BEAN.setPOL_FAX_AREA_CODE(
          resultSet.getString("POL_FAX_AREA_CODE"));
        PT_IL_POLICY_BEAN.setPOL_MASTER_POL_NO(
          resultSet.getString("POL_MASTER_POL_NO"));
        PT_IL_POLICY_BEAN.setPOL_ADDL_STATUS(
          resultSet.getString("POL_ADDL_STATUS"));
        System.out
          .println("POL_ADDL_STATUS------------------------------------>" + 
          resultSet.getString("POL_ADDL_STATUS"));
        PT_IL_POLICY_BEAN.setPOL_BANK_REF_NO(
          resultSet.getString("POL_BANK_REF_NO"));
        PT_IL_POLICY_BEAN.setPOL_PROP_REF_NO(
          resultSet.getString("POL_PROP_REF_NO"));
        PT_IL_POLICY_BEAN.setPOL_INCORPORATED_YN(
          resultSet.getString("POL_INCORPORATED_YN"));
        PT_IL_POLICY_BEAN.setPOL_NET_PREM_YN(
          resultSet.getString("POL_NET_PREM_YN"));
      /*  PT_IL_POLICY_BEAN.setPOL_CREDIT_INT_RATE(
          resultSet.getDouble("POL_CREDIT_INT_RATE") == 0.0D ? 
          null : 
          Double.valueOf(resultSet.getDouble("POL_CREDIT_INT_RATE")));*/
        
        /*Changed BY SANKAR FOR LOAN INTREST BECOME NULL SAID by MR.SIVARAM 02/07/2016*/
        PT_IL_POLICY_BEAN.setPOL_CREDIT_INT_RATE(
                resultSet.getDouble("POL_CREDIT_INT_RATE"));
        PT_IL_POLICY_BEAN.setPOL_DEFER_PRD(
          Double.valueOf(resultSet.getDouble("POL_DEFER_PRD")));
        PT_IL_POLICY_BEAN.setPOL_MODE_OF_CALC(
          resultSet.getString("POL_MODE_OF_CALC"));
        PT_IL_POLICY_BEAN.setPOL_PYMT_TYPE(
          resultSet.getString("POL_PYMT_TYPE"));
        PT_IL_POLICY_BEAN.setPOL_GRANTEE_TYPE(
          resultSet.getString("POL_GRANTEE_TYPE"));
        PT_IL_POLICY_BEAN.setPOL_GRANTEE_NAME(
          resultSet.getString("POL_GRANTEE_NAME"));
        PT_IL_POLICY_BEAN.setPOL_BANK_BRANCH_NAME(
          resultSet.getString("POL_BANK_BRANCH_NAME"));
        PT_IL_POLICY_BEAN.setPOL_AGENT_REF_CODE(
          resultSet.getString("POL_AGENT_REF_CODE"));
        PT_IL_POLICY_BEAN.setPOL_FC_BANK_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_FC_BANK_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_LC_BANK_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_LC_BANK_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_FC_CLIENT_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_FC_CLIENT_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_LC_CLIENT_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_LC_CLIENT_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_FC_TOT_SA(
          Double.valueOf(resultSet.getDouble("POL_FC_TOT_SA")));
        PT_IL_POLICY_BEAN.setPOL_LC_TOT_SA(
          Double.valueOf(resultSet.getDouble("POL_LC_TOT_SA")));
        PT_IL_POLICY_BEAN.setPOL_FC_NET_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_NET_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_NET_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_NET_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_PRE_TPD_BNF(
          Double.valueOf(resultSet.getDouble("POL_FC_PRE_TPD_BNF")));
        PT_IL_POLICY_BEAN.setPOL_LC_PRE_TPD_BNF(
          Double.valueOf(resultSet.getDouble("POL_LC_PRE_TPD_BNF")));
        PT_IL_POLICY_BEAN.setPOL_FRZ_FLAG(
          resultSet.getString("POL_FRZ_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_BANK_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_BANK_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_BANK_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_BANK_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_CLIENT_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_CLIENT_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_CLIENT_ALLOC_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_CLIENT_ALLOC_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_TOT_SA(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_TOT_SA")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_TOT_SA(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_TOT_SA")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_NET_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_NET_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_NET_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_NET_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_PRE_TPD_BNF(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_PRE_TPD_BNF")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_PRE_TPD_BNF(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_PRE_TPD_BNF")));
        PT_IL_POLICY_BEAN.setPOL_NO_OF_INST(
          Integer.valueOf(resultSet.getInt("POL_NO_OF_INST")));
        PT_IL_POLICY_BEAN.setPOL_ORG_NO_OF_INST(
          Integer.valueOf(resultSet.getInt("POL_ORG_NO_OF_INST")));
        PT_IL_POLICY_BEAN.setPOL_DEVELOPER_CODE(
          resultSet.getString("POL_DEVELOPER_CODE"));
        PT_IL_POLICY_BEAN.setPOL_PROJECT_CODE(
          resultSet.getString("POL_PROJECT_CODE"));
        PT_IL_POLICY_BEAN.setPOL_HOME_OWNER_FLAG(
          resultSet.getString("POL_HOME_OWNER_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_01(
          resultSet.getString("POL_FLEX_01"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_02(
          resultSet.getString("POL_FLEX_02"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_03(
          resultSet.getString("POL_FLEX_03"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_04(
          resultSet.getString("POL_FLEX_04"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_05(
          resultSet.getString("POL_FLEX_05"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_11(
          resultSet.getString("POL_FLEX_11"));
        PT_IL_POLICY_BEAN.setPOL_PROP_RECV_DT(
          resultSet.getDate("POL_PROP_RECV_DT"));
        PT_IL_POLICY_BEAN.setPOL_PROP_STAMP_DT(
          resultSet.getDate("POL_PROP_STAMP_DT"));
        PT_IL_POLICY_BEAN.setPOL_PROP_DECL_DT(
          resultSet.getDate("POL_PROP_DECL_DT"));
        PT_IL_POLICY_BEAN.setPOL_FC_TOP_UP_AMT(
          Double.valueOf(resultSet.getDouble("POL_FC_TOP_UP_AMT")));
        PT_IL_POLICY_BEAN.setPOL_LC_TOP_UP_AMT(
          Double.valueOf(resultSet.getDouble("POL_LC_TOP_UP_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_TOP_UP_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_TOP_UP_AMT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_TOP_UP_AMT(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_TOP_UP_AMT")));
        PT_IL_POLICY_BEAN.setPOL_INTRODUCER_REF_ID1(
          resultSet.getString("POL_INTRODUCER_REF_ID1"));
        PT_IL_POLICY_BEAN.setPOL_PROP_QUOT_FLAG(
          resultSet.getString("POL_PROP_QUOT_FLAG"));
        PT_IL_POLICY_BEAN.setPOL_FC_PAYOR_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_PAYOR_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_PAYOR_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_PAYOR_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_PAYEE_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_PAYEE_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_PAYEE_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_PAYEE_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_PAYOR_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_PAYOR_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_PAYOR_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_PAYOR_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_PAYEE_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_PAYEE_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_PAYEE_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_PAYEE_PREM")));
        PT_IL_POLICY_BEAN.setPOL_SRC_OF_BUS(
          resultSet.getString("POL_SRC_OF_BUS"));
        PT_IL_POLICY_BEAN.setPOL_POSTPONE_DAYS(
          Double.valueOf(resultSet.getDouble("POL_POSTPONE_DAYS")));
        PT_IL_POLICY_BEAN.setPOL_POSTPONE_EXPIRY_DT(
          resultSet.getDate("POL_POSTPONE_EXPIRY_DT"));
        PT_IL_POLICY_BEAN.setPOL_ORG_PROP_RECV_YN(
          resultSet.getString("POL_ORG_PROP_RECV_YN"));
        PT_IL_POLICY_BEAN.setPOL_FAC_BASIS(
          resultSet.getString("POL_FAC_BASIS"));
        PT_IL_POLICY_BEAN.setPOL_RI_POOL_CODE(
          resultSet.getString("POL_RI_POOL_CODE"));
        PT_IL_POLICY_BEAN.setPOL_TRAN_DT(
          resultSet.getDate("POL_TRAN_DT"));
        PT_IL_POLICY_BEAN.setPOL_CONVERT_YN(
          resultSet.getString("POL_CONVERT_YN"));
        PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(
          resultSet.getString("POL_ASSRD_REF_ID1"));
        PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(
          resultSet.getString("POL_ASSRD_REF_ID2"));
        PT_IL_POLICY_BEAN.setPOL_APPRV_UID(
          resultSet.getString("POL_APPRV_UID"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_06(
          resultSet.getString("POL_FLEX_06"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_07(
          resultSet.getString("POL_FLEX_07"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_08(
          resultSet.getString("POL_FLEX_08"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_09(
          resultSet.getString("POL_FLEX_09"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_10(
          resultSet.getString("POL_FLEX_10"));
      //ADDED BY GOPI FOR TOI AS PER AJOY AND SIVA SUGGESTION ON 27/07/18
        
        PT_IL_POLICY_BEAN.setPol_flex_31(
                resultSet.getString("pol_flex_31"));  
        //END
        PT_IL_POLICY_BEAN.setPOL_LC_MODAL_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_MODAL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_MODAL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_MODAL_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_MODAL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_MODAL_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_MODAL_PREM")));
        PT_IL_POLICY_BEAN.setPOL_CITY_CODE(
          resultSet.getString("POL_CITY_CODE"));
        PT_IL_POLICY_BEAN.setPOL_STATE_CODE(
          resultSet.getString("POL_STATE_CODE"));
        PT_IL_POLICY_BEAN.setPOL_COUNT_CODE(
          resultSet.getString("POL_COUNT_CODE"));
        PT_IL_POLICY_BEAN.setPOL_MOBILE_NO(
          resultSet.getString("POL_MOBILE_NO"));
        PT_IL_POLICY_BEAN.setPOL_FORM_NO(
          resultSet.getString("POL_FORM_NO"));
        PT_IL_POLICY_BEAN.setPOL_CLM_ADDL_STATUS(
          resultSet.getString("POL_CLM_ADDL_STATUS"));
        PT_IL_POLICY_BEAN.setPOL_LINK_SYS_ID(
          Double.valueOf(resultSet.getDouble("POL_LINK_SYS_ID")));
        PT_IL_POLICY_BEAN.setPOL_PROP_END_TYPE(
          resultSet.getString("POL_PROP_END_TYPE"));
        PT_IL_POLICY_BEAN.setPOL_PROP_END_CODE(
          resultSet.getString("POL_PROP_END_CODE"));
        PT_IL_POLICY_BEAN.setPOL_MED_FEE_RECOVER_YN(
          resultSet.getString("POL_MED_FEE_RECOVER_YN"));
        PT_IL_POLICY_BEAN.setPOL_END_APPRV_DT(
          resultSet.getDate("POL_END_APPRV_DT"));
        PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT(
          Double.valueOf(resultSet.getDouble("POL_NO_OF_UNIT")));
        PT_IL_POLICY_BEAN.setPOL_ORG_NO_OF_UNIT(
          Double.valueOf(resultSet.getDouble("POL_ORG_NO_OF_UNIT")));
        PT_IL_POLICY_BEAN.setPOL_FC_NETT_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_NETT_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_NETT_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_NETT_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_NETT_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_NETT_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_NETT_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_NETT_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_MIN_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_MIN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_MIN_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_MIN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_FC_EXTRA_PREM(
          Double.valueOf(resultSet.getDouble("POL_FC_EXTRA_PREM")));
        PT_IL_POLICY_BEAN.setPOL_LC_EXTRA_PREM(
          Double.valueOf(resultSet.getDouble("POL_LC_EXTRA_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_EXTRA_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_EXTRA_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_MIN_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_MIN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_LC_MIN_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_LC_MIN_PREM")));
        PT_IL_POLICY_BEAN.setPOL_ORG_FC_EXTRA_PREM(
          Double.valueOf(resultSet.getDouble("POL_ORG_FC_EXTRA_PREM")));
        PT_IL_POLICY_BEAN.setPOL_SUB_PLAN_CODE(
          resultSet.getString("POL_SUB_PLAN_CODE"));
        PT_IL_POLICY_BEAN.setPOL_ORG_SUB_PLAN_CODE(
          resultSet.getString("POL_ORG_SUB_PLAN_CODE"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_14(
          resultSet.getString("POL_FLEX_14"));
        PT_IL_POLICY_BEAN.setPOL_ESC_YN(
          resultSet.getString("POL_FLEX_17"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_09(
          resultSet.getString("POL_FLEX_09"));
        PT_IL_POLICY_BEAN.setPOL_FLEX_18(
          Integer.valueOf(resultSet.getInt("POL_FLEX_18")));
        PT_IL_POLICY_BEAN.setPOL_FLEX_20(
          resultSet.getString("POL_FLEX_20"));
        PT_IL_POLICY_BEAN.setPOL_MICR_CODE(
          resultSet.getLong("POL_MICR_CODE") == 0L ? 
          null : 
          Long.valueOf(resultSet.getLong("POL_MICR_CODE")));
        /*Modified by ganesh on 06-11-2017 as suggested by ajoy */
       /* PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(
          resultSet.getLong("POL_CUST_BANK_CODE") == 0L ? 
          null : 
          Long.valueOf(resultSet.getLong("POL_CUST_BANK_CODE")));*/
        PT_IL_POLICY_BEAN.setPOL_CUST_BANK_CODE(
              resultSet.getString("POL_CUST_BANK_CODE"));

        PT_IL_POLICY_BEAN.setUI_M_PROD_APL_YN("");
        PT_IL_POLICY_BEAN.setPOL_AUTH_LIMIT(
          Double.valueOf(resultSet.getDouble("POL_AUTH_LIMIT")));
        
       /*Commented by pidugu raj dt: 26-09-2018 as per vaitheeswaran suggestion for kic
        *  Added By Saritha on 3.3.2016 for EMail id field Addition(Start)
        System.out.println("POL_FLEX_26 value is        "+resultSet.getString("POL_FLEX_26"));
        PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID(resultSet.getString("POL_FLEX_26"));
        End*/
        
        /*Added by pidugu raj dt: 26-09-2018 as per vaitheeswaran suggestion for kic*/
        Connection connection1 = null;
        ResultSet resultSet1 = null;
        Object[] queryObject1 = (Object[])null;
        connection1 = CommonUtils.getConnection();
        String selectStatement1 = "SELECT CONT_EMAIL_ID FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
        queryObject1 = new Object[] {PT_IL_POLICY_BEAN.getPOL_CONT_CODE() };
        
        resultSet1 = new CRUDHandler().executeSelectStatement(
        		selectStatement1, connection1, queryObject1);
        
        if(resultSet1.next()){
        	PT_IL_POLICY_BEAN.setPOL_RES_EMAIL_ID(resultSet1.getString(1));
        }
        /*End Added by pidugu raj dt: 26-09-2018 as per vaitheeswaran suggestion for kic*/
        
        
        /*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 26-01-2017*/
        PT_IL_POLICY_BEAN.setPOL_BNF_ESC_PERC(
                resultSet.getString("POL_BNF_ESC_PERC"));
        System.out.println("BENIFIT RATE :"+ PT_IL_POLICY_BEAN.getPOL_BNF_ESC_PERC());
        PT_IL_POLICY_BEAN.setPOL_ANN_PAY_PERIOD(
                resultSet.getString("POL_ANN_PAY_PERIOD"));
        System.out.println("Anniuty RATE :"+ PT_IL_POLICY_BEAN.getPOL_BNF_ESC_PERC());
        
       /* Modified by Saranya on 04/04/2017 as per Sivaram suggestion*/
        
        PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(
                resultSet.getDouble("POL_LC_ANN_BNF_AMT"));
       /*PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(
                resultSet.getDouble("POL_LC_ANN_BNF_AMT")); */
       /* PT_IL_POLICY_BEAN.setPOL_ANN_BNF_AMT(
                resultSet.getDouble("POL_ANN_BNF_AMT"));*/
        /*End*/
        
        PT_IL_POLICY_BEAN.setPOL_UL_PREM_CALC(
                resultSet.getString("POL_UL_PREM_CALC"));
        

        
        /*End*/
        
        /*ADDED BY saranya on 13.4.15*/
        PT_IL_POLICY_BEAN.setPOL_BANK_DIVN(resultSet.getString("POL_BANK_DIVN"));
        Map<String, Object> session1 = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		session1.put("GLOBAL_CUST_MAIL_ID", PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID());
		System.out.println("global session customer id"+session1.get("GLOBAL_CUST_MAIL_ID"));
		
     /*   FacesContext context1 = FacesContext.getCurrentInstance();
		HttpServletRequest request1 = (HttpServletRequest) context1
				.getExternalContext().getRequest();
		HttpSession session1 = request1.getSession();
	     session1.setAttribute("POL_RES_EMAIL_ID",resultSet.getString("POL_FLEX_26"));
	     System.out.println(""+session1.getAttribute("POL_RES_EMAIL_ID"));*/
      
        //end
		/*added by R.Raja on 13-07-2016 for EMR Rate field*/
	     
	      PT_IL_POLICY_BEAN.setPOL_EMR_RATE(resultSet.getDouble("POL_EMR_RATE"));
	      
	      PT_IL_POLICY_BEAN.setPOL_ORG_COMM_RATE(resultSet.getDouble("POL_ORG_COMM_RATE"));
	      PT_IL_POLICY_BEAN.setPOL_ORG_COMM_VALUE(resultSet.getDouble("POL_ORG_COMM_VALUE"));
	      PT_IL_POLICY_BEAN.setPOL_COMM_RATE(resultSet.getDouble("POL_COMM_RATE"));
	      PT_IL_POLICY_BEAN.setPOL_COMM_VALUE(resultSet.getDouble("POL_COMM_VALUE"));
	      
	      /*End*/
	      
	      /*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	      PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_YN(resultSet.getString("POL_LAPS_OVR_YN"));
	      /* End*/
	      
	      /*Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/
	      PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_FRM_DT(resultSet.getDate("POL_LAPS_OVR_FRM_DT"));
	      PT_IL_POLICY_BEAN.setPOL_LAPS_OVR_TO_DT(resultSet.getDate("POL_LAPS_OVR_TO_DT"));
	      /* End*/
	      
	     /* Added by saranya for ssp call id FALCONQC-1716577*/
	      PT_IL_POLICY_BEAN.setPOL_BANK_CODE(resultSet.getString("POL_BANK_CODE"));
	      PT_IL_POLICY_BEAN.setPOL_CITY_CODE(resultSet.getString("POL_CITY_CODE"));
	      
	      /*Added by saritha on 20-02-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/
	      PT_IL_POLICY_BEAN.setPOL_REPL_POLICY_YN(resultSet.getString("POL_REPL_POLICY_YN"));
	      /*End*/
	      
	      
	      list3 = procedures.P_VAL_CODES("CITY", PT_IL_POLICY_BEAN.getPOL_CITY_CODE(),
	    		  PT_IL_POLICY_BEAN.getUI_M_CITY_CODE_DESC(),"N", "N", null);

	      if(!list3.isEmpty() && list3.get(0)!=null )
	    	  PT_IL_POLICY_BEAN.setUI_M_CITY_CODE_DESC(list3.get(0));

	      list4 = procedures.L_CHK_BANK(PT_IL_POLICY_BEAN.getPOL_BANK_CODE(), null,null);

	      if(!list4.isEmpty() && list4.get(0)!=null )
	    	  PT_IL_POLICY_BEAN.setUI_POL_BANK_DESC(list4.get(0));
	      /*End*/
	      
	      /*Added by Ram on 25/11/2016 for LoanType field addition*/
	      PT_IL_POLICY_BEAN.setPOL_LOAN_TYPE(resultSet.getString("POL_LOAN_TYPE"));
	      /*End*/
	      
	      /*Added by Ram on 04/12/2016 for capturing Business Rule Remarks field*/
	      PT_IL_POLICY_BEAN.setPOL_BUS_REMARKS(resultSet.getString("POL_BUS_REMARKS"));
	      /*End*/
	      /*Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer Master Changes COMMENTS*/
	      PT_IL_POLICY_BEAN.setPOL_PREM_PAYER_CODE(resultSet.getString("POL_PREM_PAYER_CODE"));
	      
	     if(PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE()!=null)
	     {
	      
	    	 /*changed by raja on 09-06-2017 for ZBILQC-1724894*/
	    	 pvalList = lifelib.P_VAL_CUST_NAME(PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE(),
	    		  PT_IL_POLICY_BEAN.getUI_M_POL_PREM_PAYER_CODE_DESC(), "N", "N",
	    		  PT_IL_POLICY_BEAN.getPOL_DIVN_CODE());
			if (!pvalList.isEmpty()) {
				
				PT_IL_POLICY_BEAN.setUI_M_POL_PREM_PAYER_CODE_DESC(pvalList.get(0).toString());
			
			}
	    	 
	    	/* String Query="select cust_name from pm_customer where cust_code=?";
	    	 ResultSet descRs=new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{PT_IL_POLICY_BEAN.getPOL_PREM_PAYER_CODE()});
	    	 while(descRs.next())
	    	 {
	    		 PT_IL_POLICY_BEAN.setUI_M_POL_PREM_PAYER_CODE_DESC(descRs.getString("cust_name"));
	    	 }*/
	     }
			/*end*/
	     
	     
	     /*Added by Shankar on 27/03/2017*/
	     
	     PT_IL_POLICY_BEAN.setPOL_DISPATCH_MTD(resultSet.getString("POL_DISPATCH_MTD"));
	     PT_IL_POLICY_BEAN.setPOL_DISPATCH_DT(resultSet.getDate("POL_DISPATCH_DT"));
	     PT_IL_POLICY_BEAN.setPOL_DOC_ACK_DT(resultSet.getDate("POL_DOC_ACK_DT"));
	     /*End*/
	     
         /*Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449063*/ 
	     PT_IL_POLICY_BEAN.setPOL_CUST_EMP_NO(resultSet.getString("POL_CUST_EMP_NO"));
	     /*End*/
	     
	     /*Added by saritha on 21-11-2017 for Due date for debit order by each policy is required*/ 
	     PT_IL_POLICY_BEAN.setPOL_DEBIT_DAY((resultSet.getString("POL_DEBIT_DAY")==null)?null:resultSet.getInt("POL_DEBIT_DAY"));
	     /*End*/
	     
	     /*Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA*/
	     //PT_IL_POLICY_BEAN.setPOL_REG_EXCESS_PREM(resultSet.getDouble("POL_REG_EXCESS_PREM"));
	     PT_IL_POLICY_BEAN.setPOL_REG_EXCESS_PREM(resultSet.getDouble("POL_REG_EXS_LC_PREM"));
	     PT_IL_POLICY_BEAN.setPOL_RETURN_VAL(resultSet.getString("POL_RETURN_VAL"));
	     /*End*/
	     
	     /*Added by Ameen on 24-03-2018 for KIC Method of collection cards option*/
	     
		     /*PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT(resultSet.getDate("POL_CARD_EXP_DT"));*/
		     PT_IL_POLICY_BEAN.setPOL_CVV_NO(resultSet.getInt("POL_CVV_NO"));
		     
		     PT_IL_POLICY_BEAN.setPOL_CARD_HOLDER_NAME(resultSet.getString("POL_CARD_HOLDER_NAME"));
		     PT_IL_POLICY_BEAN.setPOL_CONT_AD_BANK_CODE(resultSet.getString("POL_CONT_AD_BANK_CODE"));
		     PT_IL_POLICY_BEAN.setPOL_CONT_AD_ACC_NO(resultSet.getString("POL_CONT_AD_ACC_NO"));
		     
		     if(PT_IL_POLICY_BEAN.getPOL_CONT_AD_ACC_NO() != null){
		    	 PT_IL_POLICY_BEAN.setUI_M_POL_CONT_AD_ACC_NO(Long.parseLong(PT_IL_POLICY_BEAN.getPOL_CONT_AD_ACC_NO()));
		     }
		     //String exp_dt = new String(resultSet.getString("POL_CARD_EXP_DT"));
		     String exp_dt = resultSet.getString("POL_CARD_EXP_DT");
		     if(!"".equals(exp_dt) && exp_dt != null){
		    	
		       String[] parts = exp_dt.split("/");
		       String part1 = parts[0];
		       String part2 = parts[1];
		       
		       System.out.println("exp_dt         "+exp_dt+"    part1      "+part1+"     part2    "+part2);
		       
		       PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT_MM(part1);
		       PT_IL_POLICY_BEAN.setPOL_CARD_EXP_DT_YY(part2);
		     }
		       
		       System.out.println("getPOL_CARD_EXP_DT_MM         "+PT_IL_POLICY_BEAN.getPOL_CARD_EXP_DT_MM()+
		    		   "    getPOL_CARD_EXP_DT_YY      "+PT_IL_POLICY_BEAN.getPOL_CARD_EXP_DT_YY());
		     
		 /*End*/
		 /*Added by Ameen on 14-07-2018 for TOI agent/broker field*/
		  if("075".equals(PT_IL_POLICY_BEAN.getPOL_SRC_OF_BUS())){
			  String brokQry = "SELECT POBH_BROKER_CODE FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ?";
			  ResultSet brokRS = new CRUDHandler().executeSelectStatement(brokQry, CommonUtils.getConnection(),
					  	new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			  if(brokRS.next()){
				  PT_IL_POLICY_BEAN.setUI_M_POBH_BROKER_CODE(brokRS.getString("POBH_BROKER_CODE"));
			  }
			  if(PT_IL_POLICY_BEAN.getUI_M_POBH_BROKER_CODE() != null){
				  String brokCodeQry="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
					ResultSet brokCodeRS=new CRUDHandler().executeSelectStatement(brokCodeQry, CommonUtils.getConnection(), 
							new Object[]{PT_IL_POLICY_BEAN.getUI_M_POBH_BROKER_CODE()});
					if(brokCodeRS.next()){
						PT_IL_POLICY_BEAN.setUI_M_POBH_BROKER_CODE_DESC(brokCodeRS.getString("CUST_NAME"));
					}
			  }
      	  }
		 /*End*/
		  
		  /*added by Ameen on 21-10-2019 for SARWA for Retirement Product*/
		     PT_IL_POLICY_BEAN.setPOL_CASHBACK_YN(resultSet.getString("POL_CASHBACK_YN"));
		     PT_IL_POLICY_BEAN.setPOL_BNF_ESC_YN(resultSet.getString("POL_BNF_ESC_YN"));
		     PT_IL_POLICY_BEAN.setPOL_ADHOC_PREM_YN(resultSet.getString("POL_ADHOC_PREM_YN"));
		     PT_IL_POLICY_BEAN.setPOL_ADHOC_LC_PREM(resultSet.getDouble("POL_ADHOC_LC_PREM"));
		     PT_IL_POLICY_BEAN.setPOL_CASHBACK_PREC(resultSet.getInt("POL_CASHBACK_PREC"));
		     PT_IL_POLICY_BEAN.setPOL_CASHBACK_ST_YR(resultSet.getInt("POL_CASHBACK_ST_YR"));
		     /*end*/

      }
      
      	 
      String selectQuestionQuery = "SELECT * FROM PT_IL_POL_BR_QUESTION WHERE PBQ_POL_SYS_ID = ?";
      ResultSet rs = new CRUDHandler().executeSelectStatement(selectQuestionQuery, connection,new Object[]{PT_IL_POLICY_BEAN
              .getPOL_SYS_ID()});
		while(rs.next())
		{
			/*PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_QUEST_TYPE(rs.getString("PBQ_QUEST_TYPE"));
			PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_POL_SYS_ID(rs.getLong("PBQ_POL_SYS_ID"));
			PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_SYS_ID(rs.getLong("PBQ_SYS_ID"));
			PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POL_BR_QUESTION_BEAN().setPBQ_QUEST_REP_NAME(rs.getString("PBQ_QUEST_REP_NAME"));*/
			
			PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getUI_M_SCHEDULE_TYPE().add(rs.getString("PBQ_QUEST_REP_NAME"));
		}
      System.out.println("PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getUI_M_SCHEDULE_TYPE()    "+PT_IL_POLICY_BEAN
              .getPOL_SYS_ID()+"      "+PILT002_APAC_COMPOSITE_ACTION_BEAN
            .getPT_IL_POLICY_ACTION_BEAN().getUI_M_SCHEDULE_TYPE());
      
      PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN()
        .setPT_IL_POLICY_BEAN(PT_IL_POLICY_BEAN);
    } catch (Exception exception) {
      exception.printStackTrace();
      throw new Exception(exception.getMessage());
    } finally {
      CommonUtils.closeCursor(resultSet);
    }
  }

  public List<LovBean> prepareLovList(String query, Object[] obj)
  {
    List suggestionList = new ArrayList();
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
      try
      {
        CommonUtils.closeCursor(resultSet);
      } catch (Exception e1) {
        e.printStackTrace();
      }
    }
    finally
    {
      try
      {
        CommonUtils.closeCursor(resultSet);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return suggestionList;
  }
}
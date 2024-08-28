package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POLICY")
public class PT_IL_POLICY_1 extends BaseValueBean {

    @Column(name = "POL_SYS_ID")
    private Long POL_SYS_ID;

    @Column(name = "POL_PROP_SYS_ID")
    private Long POL_PROP_SYS_ID;

    @Column(name = "POL_PROP_NO")
    private String POL_PROP_NO;

    @Column(name = "POL_DIVN_CODE")
    private String POL_DIVN_CODE;

    @Column(name = "POL_DEPT_CODE")
    private String POL_DEPT_CODE;

    @Column(name = "POL_DS_CODE")
    private String POL_DS_CODE;

    @Column(name = "POL_CLASS_CODE")
    private String POL_CLASS_CODE;

    @Column(name = "POL_UW_YEAR")
    private Double POL_UW_YEAR;

    @Column(name = "POL_NO")
    private String POL_NO;

    @Column(name = "POL_ISSUE_DT")
    private Date POL_ISSUE_DT;

    @Column(name = "POL_PLAN_CODE")
    private String POL_PLAN_CODE;

    @Column(name = "POL_CUST_CODE")
    private String POL_CUST_CODE;

    @Column(name = "POL_CONT_CODE")
    private String POL_CONT_CODE;

    @Column(name = "POL_ASSURED_NAME")
    private String POL_ASSURED_NAME;

    @Column(name = "POL_RES_ADDRESS_1")
    private String POL_RES_ADDRESS_1;

    @Column(name = "POL_RES_ADDRESS_2")
    private String POL_RES_ADDRESS_2;

    @Column(name = "POL_RES_ADDRESS_3")
    private String POL_RES_ADDRESS_3;

    @Column(name = "POL_OFF_ADDRESS_1")
    private String POL_OFF_ADDRESS_1;

    @Column(name = "POL_OFF_ADDRESS_2")
    private String POL_OFF_ADDRESS_2;

    @Column(name = "POL_OFF_ADDRESS_3")
    private String POL_OFF_ADDRESS_3;

    @Column(name = "POL_SA_CURR_CODE")
    private String POL_SA_CURR_CODE;

    @Column(name = "POL_SA_EXCH_RATE")
    private Double POL_SA_EXCH_RATE;

    @Column(name = "POL_CUST_CURR_CODE")
    private String POL_CUST_CURR_CODE;

    @Column(name = "POL_CUST_EXCH_RATE")
    private Double POL_CUST_EXCH_RATE;

    @Column(name = "POL_FC_SUM_ASSURED")
    private Double POL_FC_SUM_ASSURED;

    @Column(name = "POL_LC_SUM_ASSURED")
    private Double POL_LC_SUM_ASSURED;

    @Column(name = "POL_FC_CURR_SA")
    private Double POL_FC_CURR_SA;

    @Column(name = "POL_LC_CURR_SA")
    private Double POL_LC_CURR_SA;

    @Column(name = "POL_PERIOD")
    private Double POL_PERIOD;

    @Column(name = "POL_START_DT")
    private Date POL_START_DT;

    @Column(name = "POL_EXPIRY_DT")
    private Date POL_EXPIRY_DT;

    @Column(name = "POL_BASIC_RATE")
    private Double POL_BASIC_RATE;

    @Column(name = "POL_NL_FM_DT")
    private Date POL_NL_FM_DT;

    @Column(name = "POL_NL_TO_DT")
    private Date POL_NL_TO_DT;

    @Column(name = "POL_OCC_RATE")
    private Double POL_OCC_RATE;

    @Column(name = "POL_HEALTH_RATE")
    private Double POL_HEALTH_RATE;

    @Column(name = "POL_FC_BASIC_PREM")
    private Double POL_FC_BASIC_PREM;

    @Column(name = "POL_LC_BASIC_PREM")
    private Double POL_LC_BASIC_PREM;

    @Column(name = "POL_FC_ADDL_PREM")
    private Double POL_FC_ADDL_PREM;

    @Column(name = "POL_LC_ADDL_PREM")
    private Double POL_LC_ADDL_PREM;

    @Column(name = "POL_FC_OCC_LOAD")
    private Double POL_FC_OCC_LOAD;

    @Column(name = "POL_LC_OCC_LOAD")
    private Double POL_LC_OCC_LOAD;

    @Column(name = "POL_FC_HEALTH_LOAD")
    private Double POL_FC_HEALTH_LOAD;

    @Column(name = "POL_LC_HEALTH_LOAD")
    private Double POL_LC_HEALTH_LOAD;

    @Column(name = "POL_FC_DEPOSIT_AMOUNT")
    private Double POL_FC_DEPOSIT_AMOUNT;

    @Column(name = "POL_LC_DEPOSIT_AMOUNT")
    private Double POL_LC_DEPOSIT_AMOUNT;

    @Column(name = "POL_MODE_OF_PYMT")
    private String POL_MODE_OF_PYMT;

    @Column(name = "POL_MODE_OF_PYMT_RATE")
    private Double POL_MODE_OF_PYMT_RATE;

    @Column(name = "POL_BNFCY_DTLS")
    private String POL_BNFCY_DTLS;

    @Column(name = "POL_BNFCY_DTLS_2")
    private String POL_BNFCY_DTLS_2;

    @Column(name = "POL_REMARKS")
    private String POL_REMARKS;

    @Column(name = "POL_FIRST_INST_DT")
    private Date POL_FIRST_INST_DT;

    @Column(name = "POL_LAST_INST_DT")
    private Date POL_LAST_INST_DT;

    @Column(name = "POL_NO_YRS_PREM_PAID")
    private Double POL_NO_YRS_PREM_PAID;

    @Column(name = "POL_FACIN_YN")
    private String POL_FACIN_YN;

    @Column(name = "POL_FAC_YN")
    private String POL_FAC_YN;

    @Column(name = "POL_COINS_YN")
    private String POL_COINS_YN;

    @Column(name = "POL_RI_CLOSE_FLAG")
    private String POL_RI_CLOSE_FLAG;

    @Column(name = "POL_FAC_CLOSE_FLAG")
    private String POL_FAC_CLOSE_FLAG;

    @Column(name = "POL_STATUS")
    private String POL_STATUS;

    @Column(name = "POL_APPRV_STATUS")
    private String POL_APPRV_STATUS;

    @Column(name = "POL_APPRV_DT")
    private Date POL_APPRV_DT;

    @Column(name = "POL_END_TYPE")
    private String POL_END_TYPE;

    @Column(name = "POL_END_CODE")
    private String POL_END_CODE;

    @Column(name = "POL_END_NO_IDX")
    private Double POL_END_NO_IDX;

    @Column(name = "POL_END_DT")
    private Date POL_END_DT;

    @Column(name = "POL_END_NO")
    private String POL_END_NO;

    @Column(name = "POL_END_EFF_FROM_DT")
    private Date POL_END_EFF_FROM_DT;

    @Column(name = "POL_END_EFF_TO_DT")
    private Date POL_END_EFF_TO_DT;

    @Column(name = "POL_END_DESC")
    private String POL_END_DESC;

    @Column(name = "POL_CR_DT")
    private Date POL_CR_DT;

    @Column(name = "POL_CR_UID")
    private String POL_CR_UID;

    @Column(name = "POL_UPD_DT")
    private Date POL_UPD_DT;

    @Column(name = "POL_UPD_UID")
    private String POL_UPD_UID;

    @Column(name = "POL_PREM_WAIVE_YN")
    private String POL_PREM_WAIVE_YN;

    @Column(name = "POL_CANCEL_DT")
    private Date POL_CANCEL_DT;

    @Column(name = "POL_PAIDUP_DT")
    private Date POL_PAIDUP_DT;

    @Column(name = "POL_CASH_YN")
    private String POL_CASH_YN;

    @Column(name = "POL_FC_AMAN_PREM")
    private Double POL_FC_AMAN_PREM;

    @Column(name = "POL_LC_AMAN_PREM")
    private Double POL_LC_AMAN_PREM;

    @Column(name = "POL_FC_SENABEL_PREM")
    private Double POL_FC_SENABEL_PREM;

    @Column(name = "POL_LC_SENABEL_PREM")
    private Double POL_LC_SENABEL_PREM;

    @Column(name = "POL_CREDIT_YN")
    private String POL_CREDIT_YN;

    @Column(name = "POL_CREDIT_DISCOUNT_PERC")
    private Double POL_CREDIT_DISCOUNT_PERC;

    @Column(name = "POL_LOAD_PERC")
    private Double POL_LOAD_PERC;

    @Column(name = "POL_PROD_CODE")
    private String POL_PROD_CODE;

    @Column(name = "POL_DS_TYPE")
    private String POL_DS_TYPE;

    @Column(name = "POL_PROFIT_RATE")
    private Double POL_PROFIT_RATE;

    @Column(name = "POL_FC_PROFIT")
    private Double POL_FC_PROFIT;

    @Column(name = "POL_LC_PROFIT")
    private Double POL_LC_PROFIT;

    @Column(name = "POL_JOINT_LIFE_YN")
    private String POL_JOINT_LIFE_YN;

    @Column(name = "POL_JOINT_LIFE_AGE")
    private Double POL_JOINT_LIFE_AGE;

    @Column(name = "POL_PREM_PAY_YRS")
    private Double POL_PREM_PAY_YRS;

    @Column(name = "POL_EMPLOYER_CODE")
    private String POL_EMPLOYER_CODE;

    @Column(name = "POL_TARIFF_TERM_FLAG")
    private String POL_TARIFF_TERM_FLAG;

    @Column(name = "POL_RATE_APPLIED_ON")
    private String POL_RATE_APPLIED_ON;

    @Column(name = "POL_EXC_INT_PERC")
    private Double POL_EXC_INT_PERC;

    @Column(name = "POL_FC_EXC_INT_AMT")
    private Double POL_FC_EXC_INT_AMT;

    @Column(name = "POL_LC_EXC_INT_AMT")
    private Double POL_LC_EXC_INT_AMT;

    @Column(name = "POL_HOLD_YN")
    private String POL_HOLD_YN;

    @Column(name = "POL_STAFF_YN")
    private String POL_STAFF_YN;

    @Column(name = "POL_STAFF_CCLASS_CODE")
    private String POL_STAFF_CCLASS_CODE;

    @Column(name = "POL_FC_DISC_AMT")
    private Double POL_FC_DISC_AMT;

    @Column(name = "POL_LC_DISC_AMT")
    private Double POL_LC_DISC_AMT;

    @Column(name = "POL_STD_RISK_YN")
    private String POL_STD_RISK_YN;

    @Column(name = "POL_CQS_YN")
    private String POL_CQS_YN;

    @Column(name = "POL_CQS_PERC")
    private Double POL_CQS_PERC;

    @Column(name = "POL_FC_FIRST_PREM")
    private Double POL_FC_FIRST_PREM;

    @Column(name = "POL_LC_FIRST_PREM")
    private Double POL_LC_FIRST_PREM;

    @Column(name = "POL_ORG_FC_SUM_ASSURED")
    private Double POL_ORG_FC_SUM_ASSURED;

    @Column(name = "POL_ORG_LC_SUM_ASSURED")
    private Double POL_ORG_LC_SUM_ASSURED;

    @Column(name = "POL_ORG_FC_CURR_SA")
    private Double POL_ORG_FC_CURR_SA;

    @Column(name = "POL_ORG_LC_CURR_SA")
    private Double POL_ORG_LC_CURR_SA;

    @Column(name = "POL_ORG_FC_BASIC_PREM")
    private Double POL_ORG_FC_BASIC_PREM;

    @Column(name = "POL_ORG_LC_BASIC_PREM")
    private Double POL_ORG_LC_BASIC_PREM;

    @Column(name = "POL_ORG_FC_ADDL_PREM")
    private Double POL_ORG_FC_ADDL_PREM;

    @Column(name = "POL_ORG_LC_ADDL_PREM")
    private Double POL_ORG_LC_ADDL_PREM;

    @Column(name = "POL_ORG_FC_FIRST_PREM")
    private Double POL_ORG_FC_FIRST_PREM;

    @Column(name = "POL_ORG_LC_FIRST_PREM")
    private Double POL_ORG_LC_FIRST_PREM;

    @Column(name = "POL_ORG_FC_DISC_AMT")
    private Double POL_ORG_FC_DISC_AMT;

    @Column(name = "POL_ORG_LC_DISC_AMT")
    private Double POL_ORG_LC_DISC_AMT;

    @Column(name = "POL_ORG_PREM_PAY_YRS")
    private Double POL_ORG_PREM_PAY_YRS;

    @Column(name = "POL_ORG_PERIOD")
    private Double POL_ORG_PERIOD;

    @Column(name = "POL_ORG_BASIC_RATE")
    private Double POL_ORG_BASIC_RATE;

    @Column(name = "POL_BASIC_RATE_PER")
    private Double POL_BASIC_RATE_PER;

    @Column(name = "POL_RES_PHONE_NO")
    private String POL_RES_PHONE_NO;

    @Column(name = "POL_RES_AREA_CODE")
    private String POL_RES_AREA_CODE;

    @Column(name = "POL_OFF_PHONE_NO")
    private String POL_OFF_PHONE_NO;

    @Column(name = "POL_OFF_AREA_CODE")
    private String POL_OFF_AREA_CODE;

    @Column(name = "POL_FAX_NO")
    private String POL_FAX_NO;

    @Column(name = "POL_FAX_AREA_CODE")
    private String POL_FAX_AREA_CODE;

    @Column(name = "POL_MASTER_POL_NO")
    private String POL_MASTER_POL_NO;

    @Column(name = "POL_ADDL_STATUS")
    private String POL_ADDL_STATUS;

    @Column(name = "POL_BANK_REF_NO")
    private String POL_BANK_REF_NO;

    @Column(name = "POL_PROP_REF_NO")
    private String POL_PROP_REF_NO;

    @Column(name = "POL_INCORPORATED_YN")
    private String POL_INCORPORATED_YN;

    @Column(name = "POL_NET_PREM_YN")
    private String POL_NET_PREM_YN;

    @Column(name = "POL_CREDIT_INT_RATE")
    private Double POL_CREDIT_INT_RATE;

    @Column(name = "POL_DEFER_PRD")
    private Double POL_DEFER_PRD;

    @Column(name = "POL_MODE_OF_CALC")
    private String POL_MODE_OF_CALC;

    @Column(name = "POL_PYMT_TYPE")
    private String POL_PYMT_TYPE;

    @Column(name = "POL_GRANTEE_TYPE")
    private String POL_GRANTEE_TYPE;

    @Column(name = "POL_GRANTEE_NAME")
    private String POL_GRANTEE_NAME;

    @Column(name = "POL_BANK_BRANCH_NAME")
    private String POL_BANK_BRANCH_NAME;

    @Column(name = "POL_AGENT_REF_CODE")
    private String POL_AGENT_REF_CODE;

    @Column(name = "POL_FC_BANK_ALLOC_AMT")
    private Double POL_FC_BANK_ALLOC_AMT;

    @Column(name = "POL_LC_BANK_ALLOC_AMT")
    private Double POL_LC_BANK_ALLOC_AMT;

    @Column(name = "POL_FC_CLIENT_ALLOC_AMT")
    private Double POL_FC_CLIENT_ALLOC_AMT;

    @Column(name = "POL_LC_CLIENT_ALLOC_AMT")
    private Double POL_LC_CLIENT_ALLOC_AMT;

    @Column(name = "POL_FC_TOT_SA")
    private Double POL_FC_TOT_SA;

    @Column(name = "POL_LC_TOT_SA")
    private Double POL_LC_TOT_SA;

    @Column(name = "POL_FC_NET_PREM")
    private Double POL_FC_NET_PREM;

    @Column(name = "POL_LC_NET_PREM")
    private Double POL_LC_NET_PREM;

    @Column(name = "POL_FC_PRE_TPD_BNF")
    private Double POL_FC_PRE_TPD_BNF;

    @Column(name = "POL_LC_PRE_TPD_BNF")
    private Double POL_LC_PRE_TPD_BNF;

    @Column(name = "POL_FRZ_FLAG")
    private String POL_FRZ_FLAG;

    @Column(name = "POL_ORG_FC_BANK_ALLOC_AMT")
    private Double POL_ORG_FC_BANK_ALLOC_AMT;

    @Column(name = "POL_ORG_LC_BANK_ALLOC_AMT")
    private Double POL_ORG_LC_BANK_ALLOC_AMT;

    @Column(name = "POL_ORG_FC_CLIENT_ALLOC_AMT")
    private Double POL_ORG_FC_CLIENT_ALLOC_AMT;

    @Column(name = "POL_ORG_LC_CLIENT_ALLOC_AMT")
    private Double POL_ORG_LC_CLIENT_ALLOC_AMT;

    @Column(name = "POL_ORG_FC_TOT_SA")
    private Double POL_ORG_FC_TOT_SA;

    @Column(name = "POL_ORG_LC_TOT_SA")
    private Double POL_ORG_LC_TOT_SA;

    @Column(name = "POL_ORG_FC_NET_PREM")
    private Double POL_ORG_FC_NET_PREM;

    @Column(name = "POL_ORG_LC_NET_PREM")
    private Double POL_ORG_LC_NET_PREM;

    @Column(name = "POL_ORG_FC_PRE_TPD_BNF")
    private Double POL_ORG_FC_PRE_TPD_BNF;

    @Column(name = "POL_ORG_LC_PRE_TPD_BNF")
    private Double POL_ORG_LC_PRE_TPD_BNF;

    @Column(name = "POL_NO_OF_INST")
    private Double POL_NO_OF_INST;

    @Column(name = "POL_ORG_NO_OF_INST")
    private Double POL_ORG_NO_OF_INST;

    @Column(name = "POL_DEVELOPER_CODE")
    private String POL_DEVELOPER_CODE;

    @Column(name = "POL_PROJECT_CODE")
    private String POL_PROJECT_CODE;

    @Column(name = "POL_HOME_OWNER_FLAG")
    private String POL_HOME_OWNER_FLAG;

    @Column(name = "POL_FLEX_01")
    private String POL_FLEX_01;

    @Column(name = "POL_FLEX_02")
    private String POL_FLEX_02;

    @Column(name = "POL_FLEX_03")
    private String POL_FLEX_03;

    @Column(name = "POL_FLEX_04")
    private String POL_FLEX_04;

    @Column(name = "POL_FLEX_05")
    private String POL_FLEX_05;

    @Column(name = "POL_PROP_RECV_DT")
    private Date POL_PROP_RECV_DT;

    @Column(name = "POL_PROP_STAMP_DT")
    private Date POL_PROP_STAMP_DT;

    @Column(name = "POL_PROP_DECL_DT")
    private Date POL_PROP_DECL_DT;

    @Column(name = "POL_FC_TOP_UP_AMT")
    private Double POL_FC_TOP_UP_AMT;

    @Column(name = "POL_LC_TOP_UP_AMT")
    private Double POL_LC_TOP_UP_AMT;

    @Column(name = "POL_ORG_FC_TOP_UP_AMT")
    private Double POL_ORG_FC_TOP_UP_AMT;

    @Column(name = "POL_ORG_LC_TOP_UP_AMT")
    private Double POL_ORG_LC_TOP_UP_AMT;

    @Column(name = "POL_INTRODUCER_REF_ID1")
    private String POL_INTRODUCER_REF_ID1;

    @Column(name = "POL_PROP_QUOT_FLAG")
    private String POL_PROP_QUOT_FLAG;

    @Column(name = "POL_FC_PAYOR_PREM")
    private Double POL_FC_PAYOR_PREM;

    @Column(name = "POL_LC_PAYOR_PREM")
    private Double POL_LC_PAYOR_PREM;

    @Column(name = "POL_FC_PAYEE_PREM")
    private Double POL_FC_PAYEE_PREM;

    @Column(name = "POL_LC_PAYEE_PREM")
    private Double POL_LC_PAYEE_PREM;

    @Column(name = "POL_ORG_FC_PAYOR_PREM")
    private Double POL_ORG_FC_PAYOR_PREM;

    @Column(name = "POL_ORG_LC_PAYOR_PREM")
    private Double POL_ORG_LC_PAYOR_PREM;

    @Column(name = "POL_ORG_FC_PAYEE_PREM")
    private Double POL_ORG_FC_PAYEE_PREM;

    @Column(name = "POL_ORG_LC_PAYEE_PREM")
    private Double POL_ORG_LC_PAYEE_PREM;

    @Column(name = "POL_SRC_OF_BUS")
    private String POL_SRC_OF_BUS;

    @Column(name = "POL_POSTPONE_DAYS")
    private Double POL_POSTPONE_DAYS;

    @Column(name = "POL_POSTPONE_EXPIRY_DT")
    private Date POL_POSTPONE_EXPIRY_DT;

    @Column(name = "POL_ORG_PROP_RECV_YN")
    private String POL_ORG_PROP_RECV_YN;

    @Column(name = "POL_FAC_BASIS")
    private String POL_FAC_BASIS;

    @Column(name = "POL_RI_POOL_CODE")
    private String POL_RI_POOL_CODE;

    @Column(name = "POL_TRAN_DT")
    private Date POL_TRAN_DT;

    @Column(name = "POL_CONVERT_YN")
    private String POL_CONVERT_YN;

    @Column(name = "POL_ASSRD_REF_ID1")
    private String POL_ASSRD_REF_ID1;

    @Column(name = "POL_ASSRD_REF_ID2")
    private String POL_ASSRD_REF_ID2;

    @Column(name = "POL_APPRV_UID")
    private String POL_APPRV_UID;

    @Column(name = "POL_FLEX_06")
    private String POL_FLEX_06;

    @Column(name = "POL_FLEX_07")
    private String POL_FLEX_07;

    @Column(name = "POL_FLEX_08")
    private String POL_FLEX_08;

    @Column(name = "POL_FLEX_09")
    private String POL_FLEX_09;

    @Column(name = "POL_FLEX_10")
    private String POL_FLEX_10;

    @Column(name = "POL_LC_MODAL_PREM")
    private Double POL_LC_MODAL_PREM;

    @Column(name = "POL_FC_MODAL_PREM")
    private Double POL_FC_MODAL_PREM;

    @Column(name = "POL_ORG_FC_MODAL_PREM")
    private Double POL_ORG_FC_MODAL_PREM;

    @Column(name = "POL_ORG_LC_MODAL_PREM")
    private Double POL_ORG_LC_MODAL_PREM;

    @Column(name = "POL_CITY_CODE")
    private String POL_CITY_CODE;

    @Column(name = "POL_STATE_CODE")
    private String POL_STATE_CODE;

    @Column(name = "POL_COUNT_CODE")
    private String POL_COUNT_CODE;

    @Column(name = "POL_MOBILE_NO")
    private String POL_MOBILE_NO;

    @Column(name = "POL_FORM_NO")
    private String POL_FORM_NO;

    @Column(name = "POL_CLM_ADDL_STATUS")
    private String POL_CLM_ADDL_STATUS;

    @Column(name = "POL_LINK_SYS_ID")
    private Long POL_LINK_SYS_ID;

    @Column(name = "POL_PROP_END_TYPE")
    private String POL_PROP_END_TYPE;

    @Column(name = "POL_PROP_END_CODE")
    private String POL_PROP_END_CODE;

    @Column(name = "POL_MED_FEE_RECOVER_YN")
    private String POL_MED_FEE_RECOVER_YN;

    @Column(name = "POL_END_APPRV_DT")
    private Date POL_END_APPRV_DT;

    @Column(name = "POL_NO_OF_UNIT")
    private Double POL_NO_OF_UNIT;

    @Column(name = "POL_ORG_NO_OF_UNIT")
    private Double POL_ORG_NO_OF_UNIT;

    @Column(name = "POL_FC_NETT_PREM")
    private Double POL_FC_NETT_PREM;

    @Column(name = "POL_LC_NETT_PREM")
    private Double POL_LC_NETT_PREM;

    @Column(name = "POL_ORG_FC_NETT_PREM")
    private Double POL_ORG_FC_NETT_PREM;

    @Column(name = "POL_ORG_LC_NETT_PREM")
    private Double POL_ORG_LC_NETT_PREM;

    @Column(name = "POL_LC_MIN_PREM")
    private Double POL_LC_MIN_PREM;

    @Column(name = "POL_FC_MIN_PREM")
    private Double POL_FC_MIN_PREM;

    @Column(name = "POL_FC_EXTRA_PREM")
    private Double POL_FC_EXTRA_PREM;

    @Column(name = "POL_LC_EXTRA_PREM")
    private Double POL_LC_EXTRA_PREM;

    @Column(name = "POL_ORG_LC_EXTRA_PREM")
    private Double POL_ORG_LC_EXTRA_PREM;

    @Column(name = "POL_ORG_FC_MIN_PREM")
    private Double POL_ORG_FC_MIN_PREM;

    @Column(name = "POL_ORG_LC_MIN_PREM")
    private Double POL_ORG_LC_MIN_PREM;

    @Column(name = "POL_ORG_FC_EXTRA_PREM")
    private Double POL_ORG_FC_EXTRA_PREM;

    @Column(name = "POL_SUB_PLAN_CODE")
    private String POL_SUB_PLAN_CODE;

    @Column(name = "POL_ORG_SUB_PLAN_CODE")
    private String POL_ORG_SUB_PLAN_CODE;

    @Column(name = "POL_PROD_GROUP_CODE")
    private String POL_PROD_GROUP_CODE;

    public void setPOL_ORG_SUB_PLAN_CODE(String POL_ORG_SUB_PLAN_CODE) {
	this.POL_ORG_SUB_PLAN_CODE = POL_ORG_SUB_PLAN_CODE;
    }

    public String getPOL_ORG_SUB_PLAN_CODE() {
	return POL_ORG_SUB_PLAN_CODE;
    }

    public void setPOL_NL_TO_DT(Date POL_NL_TO_DT) {
	this.POL_NL_TO_DT = POL_NL_TO_DT;
    }

    public Date getPOL_NL_TO_DT() {
	return POL_NL_TO_DT;
    }

    public void setPOL_FC_EXC_INT_AMT(Double POL_FC_EXC_INT_AMT) {
	this.POL_FC_EXC_INT_AMT = POL_FC_EXC_INT_AMT;
    }

    public Double getPOL_FC_EXC_INT_AMT() {
	return POL_FC_EXC_INT_AMT;
    }

    public void setPOL_ORG_FC_NET_PREM(Double POL_ORG_FC_NET_PREM) {
	this.POL_ORG_FC_NET_PREM = POL_ORG_FC_NET_PREM;
    }

    public Double getPOL_ORG_FC_NET_PREM() {
	return POL_ORG_FC_NET_PREM;
    }

    public void setPOL_STAFF_CCLASS_CODE(String POL_STAFF_CCLASS_CODE) {
	this.POL_STAFF_CCLASS_CODE = POL_STAFF_CCLASS_CODE;
    }

    public String getPOL_STAFF_CCLASS_CODE() {
	return POL_STAFF_CCLASS_CODE;
    }

    public void setPOL_LC_SUM_ASSURED(Double POL_LC_SUM_ASSURED) {
	this.POL_LC_SUM_ASSURED = POL_LC_SUM_ASSURED;
    }

    public Double getPOL_LC_SUM_ASSURED() {
	return POL_LC_SUM_ASSURED;
    }

    public void setPOL_PROP_REF_NO(String POL_PROP_REF_NO) {
	this.POL_PROP_REF_NO = POL_PROP_REF_NO;
    }

    public String getPOL_PROP_REF_NO() {
	return POL_PROP_REF_NO;
    }

    public void setPOL_PROJECT_CODE(String POL_PROJECT_CODE) {
	this.POL_PROJECT_CODE = POL_PROJECT_CODE;
    }

    public String getPOL_PROJECT_CODE() {
	return POL_PROJECT_CODE;
    }

    public void setPOL_LC_FIRST_PREM(Double POL_LC_FIRST_PREM) {
	this.POL_LC_FIRST_PREM = POL_LC_FIRST_PREM;
    }

    public Double getPOL_LC_FIRST_PREM() {
	return POL_LC_FIRST_PREM;
    }

    public void setPOL_APPRV_UID(String POL_APPRV_UID) {
	this.POL_APPRV_UID = POL_APPRV_UID;
    }

    public String getPOL_APPRV_UID() {
	return POL_APPRV_UID;
    }

    public void setPOL_CR_UID(String POL_CR_UID) {
	this.POL_CR_UID = POL_CR_UID;
    }

    public String getPOL_CR_UID() {
	return POL_CR_UID;
    }

    public void setPOL_RES_PHONE_NO(String POL_RES_PHONE_NO) {
	this.POL_RES_PHONE_NO = POL_RES_PHONE_NO;
    }

    public String getPOL_RES_PHONE_NO() {
	return POL_RES_PHONE_NO;
    }

    public void setPOL_PREM_WAIVE_YN(String POL_PREM_WAIVE_YN) {
	this.POL_PREM_WAIVE_YN = POL_PREM_WAIVE_YN;
    }

    public String getPOL_PREM_WAIVE_YN() {
	return POL_PREM_WAIVE_YN;
    }

    public void setPOL_LC_ADDL_PREM(Double POL_LC_ADDL_PREM) {
	this.POL_LC_ADDL_PREM = POL_LC_ADDL_PREM;
    }

    public Double getPOL_LC_ADDL_PREM() {
	return POL_LC_ADDL_PREM;
    }

    public void setPOL_ORG_FC_PAYOR_PREM(Double POL_ORG_FC_PAYOR_PREM) {
	this.POL_ORG_FC_PAYOR_PREM = POL_ORG_FC_PAYOR_PREM;
    }

    public Double getPOL_ORG_FC_PAYOR_PREM() {
	return POL_ORG_FC_PAYOR_PREM;
    }

    public void setPOL_FC_TOT_SA(Double POL_FC_TOT_SA) {
	this.POL_FC_TOT_SA = POL_FC_TOT_SA;
    }

    public Double getPOL_FC_TOT_SA() {
	return POL_FC_TOT_SA;
    }

    public void setPOL_DS_CODE(String POL_DS_CODE) {
	this.POL_DS_CODE = POL_DS_CODE;
    }

    public String getPOL_DS_CODE() {
	return POL_DS_CODE;
    }

    public void setPOL_ORG_BASIC_RATE(Double POL_ORG_BASIC_RATE) {
	this.POL_ORG_BASIC_RATE = POL_ORG_BASIC_RATE;
    }

    public Double getPOL_ORG_BASIC_RATE() {
	return POL_ORG_BASIC_RATE;
    }

    public void setPOL_ORG_FC_NETT_PREM(Double POL_ORG_FC_NETT_PREM) {
	this.POL_ORG_FC_NETT_PREM = POL_ORG_FC_NETT_PREM;
    }

    public Double getPOL_ORG_FC_NETT_PREM() {
	return POL_ORG_FC_NETT_PREM;
    }

    public void setPOL_ORG_LC_MIN_PREM(Double POL_ORG_LC_MIN_PREM) {
	this.POL_ORG_LC_MIN_PREM = POL_ORG_LC_MIN_PREM;
    }

    public Double getPOL_ORG_LC_MIN_PREM() {
	return POL_ORG_LC_MIN_PREM;
    }

    public void setPOL_ORG_PROP_RECV_YN(String POL_ORG_PROP_RECV_YN) {
	this.POL_ORG_PROP_RECV_YN = POL_ORG_PROP_RECV_YN;
    }

    public String getPOL_ORG_PROP_RECV_YN() {
	return POL_ORG_PROP_RECV_YN;
    }

    public void setPOL_CONT_CODE(String POL_CONT_CODE) {
	this.POL_CONT_CODE = POL_CONT_CODE;
    }

    public String getPOL_CONT_CODE() {
	return POL_CONT_CODE;
    }

    public void setPOL_ORG_LC_BASIC_PREM(Double POL_ORG_LC_BASIC_PREM) {
	this.POL_ORG_LC_BASIC_PREM = POL_ORG_LC_BASIC_PREM;
    }

    public Double getPOL_ORG_LC_BASIC_PREM() {
	return POL_ORG_LC_BASIC_PREM;
    }

    public void setPOL_ORG_LC_MODAL_PREM(Double POL_ORG_LC_MODAL_PREM) {
	this.POL_ORG_LC_MODAL_PREM = POL_ORG_LC_MODAL_PREM;
    }

    public Double getPOL_ORG_LC_MODAL_PREM() {
	return POL_ORG_LC_MODAL_PREM;
    }

    public void setPOL_COUNT_CODE(String POL_COUNT_CODE) {
	this.POL_COUNT_CODE = POL_COUNT_CODE;
    }

    public String getPOL_COUNT_CODE() {
	return POL_COUNT_CODE;
    }

    public void setPOL_PREM_PAY_YRS(Double POL_PREM_PAY_YRS) {
	this.POL_PREM_PAY_YRS = POL_PREM_PAY_YRS;
    }

    public Double getPOL_PREM_PAY_YRS() {
	return POL_PREM_PAY_YRS;
    }

    public void setPOL_FC_OCC_LOAD(Double POL_FC_OCC_LOAD) {
	this.POL_FC_OCC_LOAD = POL_FC_OCC_LOAD;
    }

    public Double getPOL_FC_OCC_LOAD() {
	return POL_FC_OCC_LOAD;
    }

    public void setPOL_GRANTEE_NAME(String POL_GRANTEE_NAME) {
	this.POL_GRANTEE_NAME = POL_GRANTEE_NAME;
    }

    public String getPOL_GRANTEE_NAME() {
	return POL_GRANTEE_NAME;
    }

    public void setPOL_PROP_DECL_DT(Date POL_PROP_DECL_DT) {
	this.POL_PROP_DECL_DT = POL_PROP_DECL_DT;
    }

    public Date getPOL_PROP_DECL_DT() {
	return POL_PROP_DECL_DT;
    }

    public void setPOL_FC_BANK_ALLOC_AMT(Double POL_FC_BANK_ALLOC_AMT) {
	this.POL_FC_BANK_ALLOC_AMT = POL_FC_BANK_ALLOC_AMT;
    }

    public Double getPOL_FC_BANK_ALLOC_AMT() {
	return POL_FC_BANK_ALLOC_AMT;
    }

    public void setPOL_ORG_FC_DISC_AMT(Double POL_ORG_FC_DISC_AMT) {
	this.POL_ORG_FC_DISC_AMT = POL_ORG_FC_DISC_AMT;
    }

    public Double getPOL_ORG_FC_DISC_AMT() {
	return POL_ORG_FC_DISC_AMT;
    }

    public void setPOL_CREDIT_INT_RATE(Double POL_CREDIT_INT_RATE) {
	this.POL_CREDIT_INT_RATE = POL_CREDIT_INT_RATE;
    }

    public Double getPOL_CREDIT_INT_RATE() {
	return POL_CREDIT_INT_RATE;
    }

    public void setPOL_LC_PAYEE_PREM(Double POL_LC_PAYEE_PREM) {
	this.POL_LC_PAYEE_PREM = POL_LC_PAYEE_PREM;
    }

    public Double getPOL_LC_PAYEE_PREM() {
	return POL_LC_PAYEE_PREM;
    }

    public void setPOL_FORM_NO(String POL_FORM_NO) {
	this.POL_FORM_NO = POL_FORM_NO;
    }

    public String getPOL_FORM_NO() {
	return POL_FORM_NO;
    }

    public void setPOL_END_NO(String POL_END_NO) {
	this.POL_END_NO = POL_END_NO;
    }

    public String getPOL_END_NO() {
	return POL_END_NO;
    }

    public void setPOL_ORG_LC_NET_PREM(Double POL_ORG_LC_NET_PREM) {
	this.POL_ORG_LC_NET_PREM = POL_ORG_LC_NET_PREM;
    }

    public Double getPOL_ORG_LC_NET_PREM() {
	return POL_ORG_LC_NET_PREM;
    }

    public void setPOL_RES_ADDRESS_2(String POL_RES_ADDRESS_2) {
	this.POL_RES_ADDRESS_2 = POL_RES_ADDRESS_2;
    }

    public String getPOL_RES_ADDRESS_2() {
	return POL_RES_ADDRESS_2;
    }

    public void setPOL_RES_ADDRESS_3(String POL_RES_ADDRESS_3) {
	this.POL_RES_ADDRESS_3 = POL_RES_ADDRESS_3;
    }

    public String getPOL_RES_ADDRESS_3() {
	return POL_RES_ADDRESS_3;
    }

    public void setPOL_PROP_END_TYPE(String POL_PROP_END_TYPE) {
	this.POL_PROP_END_TYPE = POL_PROP_END_TYPE;
    }

    public String getPOL_PROP_END_TYPE() {
	return POL_PROP_END_TYPE;
    }

    public void setPOL_FAC_YN(String POL_FAC_YN) {
	this.POL_FAC_YN = POL_FAC_YN;
    }

    public String getPOL_FAC_YN() {
	return POL_FAC_YN;
    }

    public void setPOL_RES_ADDRESS_1(String POL_RES_ADDRESS_1) {
	this.POL_RES_ADDRESS_1 = POL_RES_ADDRESS_1;
    }

    public String getPOL_RES_ADDRESS_1() {
	return POL_RES_ADDRESS_1;
    }

    public void setPOL_CQS_YN(String POL_CQS_YN) {
	this.POL_CQS_YN = POL_CQS_YN;
    }

    public String getPOL_CQS_YN() {
	return POL_CQS_YN;
    }

    public void setPOL_JOINT_LIFE_AGE(Double POL_JOINT_LIFE_AGE) {
	this.POL_JOINT_LIFE_AGE = POL_JOINT_LIFE_AGE;
    }

    public Double getPOL_JOINT_LIFE_AGE() {
	return POL_JOINT_LIFE_AGE;
    }

    public void setPOL_DEVELOPER_CODE(String POL_DEVELOPER_CODE) {
	this.POL_DEVELOPER_CODE = POL_DEVELOPER_CODE;
    }

    public String getPOL_DEVELOPER_CODE() {
	return POL_DEVELOPER_CODE;
    }

    public void setPOL_SRC_OF_BUS(String POL_SRC_OF_BUS) {
	this.POL_SRC_OF_BUS = POL_SRC_OF_BUS;
    }

    public String getPOL_SRC_OF_BUS() {
	return POL_SRC_OF_BUS;
    }

    public void setPOL_INTRODUCER_REF_ID1(String POL_INTRODUCER_REF_ID1) {
	this.POL_INTRODUCER_REF_ID1 = POL_INTRODUCER_REF_ID1;
    }

    public String getPOL_INTRODUCER_REF_ID1() {
	return POL_INTRODUCER_REF_ID1;
    }

    public void setPOL_CREDIT_DISCOUNT_PERC(Double POL_CREDIT_DISCOUNT_PERC) {
	this.POL_CREDIT_DISCOUNT_PERC = POL_CREDIT_DISCOUNT_PERC;
    }

    public Double getPOL_CREDIT_DISCOUNT_PERC() {
	return POL_CREDIT_DISCOUNT_PERC;
    }

    public void setPOL_LC_PROFIT(Double POL_LC_PROFIT) {
	this.POL_LC_PROFIT = POL_LC_PROFIT;
    }

    public Double getPOL_LC_PROFIT() {
	return POL_LC_PROFIT;
    }

    public void setPOL_ORG_LC_DISC_AMT(Double POL_ORG_LC_DISC_AMT) {
	this.POL_ORG_LC_DISC_AMT = POL_ORG_LC_DISC_AMT;
    }

    public Double getPOL_ORG_LC_DISC_AMT() {
	return POL_ORG_LC_DISC_AMT;
    }

    public void setPOL_COINS_YN(String POL_COINS_YN) {
	this.POL_COINS_YN = POL_COINS_YN;
    }

    public String getPOL_COINS_YN() {
	return POL_COINS_YN;
    }

    public void setPOL_ORG_LC_ADDL_PREM(Double POL_ORG_LC_ADDL_PREM) {
	this.POL_ORG_LC_ADDL_PREM = POL_ORG_LC_ADDL_PREM;
    }

    public Double getPOL_ORG_LC_ADDL_PREM() {
	return POL_ORG_LC_ADDL_PREM;
    }

    public void setPOL_PERIOD(Double POL_PERIOD) {
	this.POL_PERIOD = POL_PERIOD;
    }

    public Double getPOL_PERIOD() {
	return POL_PERIOD;
    }

    public void setPOL_FRZ_FLAG(String POL_FRZ_FLAG) {
	this.POL_FRZ_FLAG = POL_FRZ_FLAG;
    }

    public String getPOL_FRZ_FLAG() {
	return POL_FRZ_FLAG;
    }

    public void setPOL_LC_MIN_PREM(Double POL_LC_MIN_PREM) {
	this.POL_LC_MIN_PREM = POL_LC_MIN_PREM;
    }

    public Double getPOL_LC_MIN_PREM() {
	return POL_LC_MIN_PREM;
    }

    public void setPOL_ORG_LC_PRE_TPD_BNF(Double POL_ORG_LC_PRE_TPD_BNF) {
	this.POL_ORG_LC_PRE_TPD_BNF = POL_ORG_LC_PRE_TPD_BNF;
    }

    public Double getPOL_ORG_LC_PRE_TPD_BNF() {
	return POL_ORG_LC_PRE_TPD_BNF;
    }

    public void setPOL_LC_NETT_PREM(Double POL_LC_NETT_PREM) {
	this.POL_LC_NETT_PREM = POL_LC_NETT_PREM;
    }

    public Double getPOL_LC_NETT_PREM() {
	return POL_LC_NETT_PREM;
    }

    public void setPOL_END_EFF_TO_DT(Date POL_END_EFF_TO_DT) {
	this.POL_END_EFF_TO_DT = POL_END_EFF_TO_DT;
    }

    public Date getPOL_END_EFF_TO_DT() {
	return POL_END_EFF_TO_DT;
    }

    public void setPOL_ORG_LC_BANK_ALLOC_AMT(Double POL_ORG_LC_BANK_ALLOC_AMT) {
	this.POL_ORG_LC_BANK_ALLOC_AMT = POL_ORG_LC_BANK_ALLOC_AMT;
    }

    public Double getPOL_ORG_LC_BANK_ALLOC_AMT() {
	return POL_ORG_LC_BANK_ALLOC_AMT;
    }

    public void setPOL_END_DT(Date POL_END_DT) {
	this.POL_END_DT = POL_END_DT;
    }

    public Date getPOL_END_DT() {
	return POL_END_DT;
    }

    public void setPOL_PLAN_CODE(String POL_PLAN_CODE) {
	this.POL_PLAN_CODE = POL_PLAN_CODE;
    }

    public String getPOL_PLAN_CODE() {
	return POL_PLAN_CODE;
    }

    public void setPOL_FC_CLIENT_ALLOC_AMT(Double POL_FC_CLIENT_ALLOC_AMT) {
	this.POL_FC_CLIENT_ALLOC_AMT = POL_FC_CLIENT_ALLOC_AMT;
    }

    public Double getPOL_FC_CLIENT_ALLOC_AMT() {
	return POL_FC_CLIENT_ALLOC_AMT;
    }

    public void setPOL_LC_BANK_ALLOC_AMT(Double POL_LC_BANK_ALLOC_AMT) {
	this.POL_LC_BANK_ALLOC_AMT = POL_LC_BANK_ALLOC_AMT;
    }

    public Double getPOL_LC_BANK_ALLOC_AMT() {
	return POL_LC_BANK_ALLOC_AMT;
    }

    public void setPOL_PAIDUP_DT(Date POL_PAIDUP_DT) {
	this.POL_PAIDUP_DT = POL_PAIDUP_DT;
    }

    public Date getPOL_PAIDUP_DT() {
	return POL_PAIDUP_DT;
    }

    public void setPOL_PROFIT_RATE(Double POL_PROFIT_RATE) {
	this.POL_PROFIT_RATE = POL_PROFIT_RATE;
    }

    public Double getPOL_PROFIT_RATE() {
	return POL_PROFIT_RATE;
    }

    public void setPOL_FC_BASIC_PREM(Double POL_FC_BASIC_PREM) {
	this.POL_FC_BASIC_PREM = POL_FC_BASIC_PREM;
    }

    public Double getPOL_FC_BASIC_PREM() {
	return POL_FC_BASIC_PREM;
    }

    public void setPOL_ORG_FC_CLIENT_ALLOC_AMT(
	    Double POL_ORG_FC_CLIENT_ALLOC_AMT) {
	this.POL_ORG_FC_CLIENT_ALLOC_AMT = POL_ORG_FC_CLIENT_ALLOC_AMT;
    }

    public Double getPOL_ORG_FC_CLIENT_ALLOC_AMT() {
	return POL_ORG_FC_CLIENT_ALLOC_AMT;
    }

    public void setPOL_FC_PAYOR_PREM(Double POL_FC_PAYOR_PREM) {
	this.POL_FC_PAYOR_PREM = POL_FC_PAYOR_PREM;
    }

    public Double getPOL_FC_PAYOR_PREM() {
	return POL_FC_PAYOR_PREM;
    }

    public void setPOL_STATUS(String POL_STATUS) {
	this.POL_STATUS = POL_STATUS;
    }

    public String getPOL_STATUS() {
	return POL_STATUS;
    }

    public void setPOL_FC_PROFIT(Double POL_FC_PROFIT) {
	this.POL_FC_PROFIT = POL_FC_PROFIT;
    }

    public Double getPOL_FC_PROFIT() {
	return POL_FC_PROFIT;
    }

    public void setPOL_LC_NET_PREM(Double POL_LC_NET_PREM) {
	this.POL_LC_NET_PREM = POL_LC_NET_PREM;
    }

    public Double getPOL_LC_NET_PREM() {
	return POL_LC_NET_PREM;
    }

    public void setPOL_SYS_ID(Long POL_SYS_ID) {
	this.POL_SYS_ID = POL_SYS_ID;
    }

    public Long getPOL_SYS_ID() {
	return POL_SYS_ID;
    }

    public void setPOL_BASIC_RATE(Double POL_BASIC_RATE) {
	this.POL_BASIC_RATE = POL_BASIC_RATE;
    }

    public Double getPOL_BASIC_RATE() {
	return POL_BASIC_RATE;
    }

    public void setPOL_BNFCY_DTLS_2(String POL_BNFCY_DTLS_2) {
	this.POL_BNFCY_DTLS_2 = POL_BNFCY_DTLS_2;
    }

    public String getPOL_BNFCY_DTLS_2() {
	return POL_BNFCY_DTLS_2;
    }

    public void setPOL_RI_CLOSE_FLAG(String POL_RI_CLOSE_FLAG) {
	this.POL_RI_CLOSE_FLAG = POL_RI_CLOSE_FLAG;
    }

    public String getPOL_RI_CLOSE_FLAG() {
	return POL_RI_CLOSE_FLAG;
    }

    public void setPOL_FC_ADDL_PREM(Double POL_FC_ADDL_PREM) {
	this.POL_FC_ADDL_PREM = POL_FC_ADDL_PREM;
    }

    public Double getPOL_FC_ADDL_PREM() {
	return POL_FC_ADDL_PREM;
    }

    public void setPOL_GRANTEE_TYPE(String POL_GRANTEE_TYPE) {
	this.POL_GRANTEE_TYPE = POL_GRANTEE_TYPE;
    }

    public String getPOL_GRANTEE_TYPE() {
	return POL_GRANTEE_TYPE;
    }

    public void setPOL_FLEX_10(String POL_FLEX_10) {
	this.POL_FLEX_10 = POL_FLEX_10;
    }

    public String getPOL_FLEX_10() {
	return POL_FLEX_10;
    }

    public void setPOL_NO_YRS_PREM_PAID(Double POL_NO_YRS_PREM_PAID) {
	this.POL_NO_YRS_PREM_PAID = POL_NO_YRS_PREM_PAID;
    }

    public Double getPOL_NO_YRS_PREM_PAID() {
	return POL_NO_YRS_PREM_PAID;
    }

    public void setPOL_CASH_YN(String POL_CASH_YN) {
	this.POL_CASH_YN = POL_CASH_YN;
    }

    public String getPOL_CASH_YN() {
	return POL_CASH_YN;
    }

    public void setPOL_LC_CURR_SA(Double POL_LC_CURR_SA) {
	this.POL_LC_CURR_SA = POL_LC_CURR_SA;
    }

    public Double getPOL_LC_CURR_SA() {
	return POL_LC_CURR_SA;
    }

    public void setPOL_BASIC_RATE_PER(Double POL_BASIC_RATE_PER) {
	this.POL_BASIC_RATE_PER = POL_BASIC_RATE_PER;
    }

    public Double getPOL_BASIC_RATE_PER() {
	return POL_BASIC_RATE_PER;
    }

    public void setPOL_PROP_RECV_DT(Date POL_PROP_RECV_DT) {
	this.POL_PROP_RECV_DT = POL_PROP_RECV_DT;
    }

    public Date getPOL_PROP_RECV_DT() {
	return POL_PROP_RECV_DT;
    }

    public void setPOL_LC_SENABEL_PREM(Double POL_LC_SENABEL_PREM) {
	this.POL_LC_SENABEL_PREM = POL_LC_SENABEL_PREM;
    }

    public Double getPOL_LC_SENABEL_PREM() {
	return POL_LC_SENABEL_PREM;
    }

    public void setPOL_FC_MODAL_PREM(Double POL_FC_MODAL_PREM) {
	this.POL_FC_MODAL_PREM = POL_FC_MODAL_PREM;
    }

    public Double getPOL_FC_MODAL_PREM() {
	return POL_FC_MODAL_PREM;
    }

    public void setPOL_CR_DT(Date POL_CR_DT) {
	this.POL_CR_DT = POL_CR_DT;
    }

    public Date getPOL_CR_DT() {
	return POL_CR_DT;
    }

    public void setPOL_JOINT_LIFE_YN(String POL_JOINT_LIFE_YN) {
	this.POL_JOINT_LIFE_YN = POL_JOINT_LIFE_YN;
    }

    public String getPOL_JOINT_LIFE_YN() {
	return POL_JOINT_LIFE_YN;
    }

    public void setPOL_PROP_SYS_ID(Long POL_PROP_SYS_ID) {
	this.POL_PROP_SYS_ID = POL_PROP_SYS_ID;
    }

    public Long getPOL_PROP_SYS_ID() {
	return POL_PROP_SYS_ID;
    }

    public void setPOL_FC_CURR_SA(Double POL_FC_CURR_SA) {
	this.POL_FC_CURR_SA = POL_FC_CURR_SA;
    }

    public Double getPOL_FC_CURR_SA() {
	return POL_FC_CURR_SA;
    }

    public void setPOL_STAFF_YN(String POL_STAFF_YN) {
	this.POL_STAFF_YN = POL_STAFF_YN;
    }

    public String getPOL_STAFF_YN() {
	return POL_STAFF_YN;
    }

    public void setPOL_ORG_LC_PAYEE_PREM(Double POL_ORG_LC_PAYEE_PREM) {
	this.POL_ORG_LC_PAYEE_PREM = POL_ORG_LC_PAYEE_PREM;
    }

    public Double getPOL_ORG_LC_PAYEE_PREM() {
	return POL_ORG_LC_PAYEE_PREM;
    }

    public void setPOL_END_NO_IDX(Double POL_END_NO_IDX) {
	this.POL_END_NO_IDX = POL_END_NO_IDX;
    }

    public Double getPOL_END_NO_IDX() {
	return POL_END_NO_IDX;
    }

    public void setPOL_NET_PREM_YN(String POL_NET_PREM_YN) {
	this.POL_NET_PREM_YN = POL_NET_PREM_YN;
    }

    public String getPOL_NET_PREM_YN() {
	return POL_NET_PREM_YN;
    }

    public void setPOL_ISSUE_DT(Date POL_ISSUE_DT) {
	this.POL_ISSUE_DT = POL_ISSUE_DT;
    }

    public Date getPOL_ISSUE_DT() {
	return POL_ISSUE_DT;
    }

    public void setPOL_NO_OF_UNIT(Double POL_NO_OF_UNIT) {
	this.POL_NO_OF_UNIT = POL_NO_OF_UNIT;
    }

    public Double getPOL_NO_OF_UNIT() {
	return POL_NO_OF_UNIT;
    }

    public void setPOL_LAST_INST_DT(Date POL_LAST_INST_DT) {
	this.POL_LAST_INST_DT = POL_LAST_INST_DT;
    }

    public Date getPOL_LAST_INST_DT() {
	return POL_LAST_INST_DT;
    }

    public void setPOL_LC_EXC_INT_AMT(Double POL_LC_EXC_INT_AMT) {
	this.POL_LC_EXC_INT_AMT = POL_LC_EXC_INT_AMT;
    }

    public Double getPOL_LC_EXC_INT_AMT() {
	return POL_LC_EXC_INT_AMT;
    }

    public void setPOL_CANCEL_DT(Date POL_CANCEL_DT) {
	this.POL_CANCEL_DT = POL_CANCEL_DT;
    }

    public Date getPOL_CANCEL_DT() {
	return POL_CANCEL_DT;
    }

    public void setPOL_CQS_PERC(Double POL_CQS_PERC) {
	this.POL_CQS_PERC = POL_CQS_PERC;
    }

    public Double getPOL_CQS_PERC() {
	return POL_CQS_PERC;
    }

    public void setPOL_POSTPONE_EXPIRY_DT(Date POL_POSTPONE_EXPIRY_DT) {
	this.POL_POSTPONE_EXPIRY_DT = POL_POSTPONE_EXPIRY_DT;
    }

    public Date getPOL_POSTPONE_EXPIRY_DT() {
	return POL_POSTPONE_EXPIRY_DT;
    }

    public void setPOL_HEALTH_RATE(Double POL_HEALTH_RATE) {
	this.POL_HEALTH_RATE = POL_HEALTH_RATE;
    }

    public Double getPOL_HEALTH_RATE() {
	return POL_HEALTH_RATE;
    }

    public void setPOL_ORG_LC_TOT_SA(Double POL_ORG_LC_TOT_SA) {
	this.POL_ORG_LC_TOT_SA = POL_ORG_LC_TOT_SA;
    }

    public Double getPOL_ORG_LC_TOT_SA() {
	return POL_ORG_LC_TOT_SA;
    }

    public void setPOL_UPD_UID(String POL_UPD_UID) {
	this.POL_UPD_UID = POL_UPD_UID;
    }

    public String getPOL_UPD_UID() {
	return POL_UPD_UID;
    }

    public void setPOL_INCORPORATED_YN(String POL_INCORPORATED_YN) {
	this.POL_INCORPORATED_YN = POL_INCORPORATED_YN;
    }

    public String getPOL_INCORPORATED_YN() {
	return POL_INCORPORATED_YN;
    }

    public void setPOL_POSTPONE_DAYS(Double POL_POSTPONE_DAYS) {
	this.POL_POSTPONE_DAYS = POL_POSTPONE_DAYS;
    }

    public Double getPOL_POSTPONE_DAYS() {
	return POL_POSTPONE_DAYS;
    }

    public void setPOL_ORG_LC_TOP_UP_AMT(Double POL_ORG_LC_TOP_UP_AMT) {
	this.POL_ORG_LC_TOP_UP_AMT = POL_ORG_LC_TOP_UP_AMT;
    }

    public Double getPOL_ORG_LC_TOP_UP_AMT() {
	return POL_ORG_LC_TOP_UP_AMT;
    }

    public void setPOL_NO(String POL_NO) {
	this.POL_NO = POL_NO;
    }

    public String getPOL_NO() {
	return POL_NO;
    }

    public void setPOL_PROD_CODE(String POL_PROD_CODE) {
	this.POL_PROD_CODE = POL_PROD_CODE;
    }

    public String getPOL_PROD_CODE() {
	return POL_PROD_CODE;
    }

    public void setPOL_LC_TOT_SA(Double POL_LC_TOT_SA) {
	this.POL_LC_TOT_SA = POL_LC_TOT_SA;
    }

    public Double getPOL_LC_TOT_SA() {
	return POL_LC_TOT_SA;
    }

    public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
	this.POL_EXPIRY_DT = POL_EXPIRY_DT;
    }

    public Date getPOL_EXPIRY_DT() {
	return POL_EXPIRY_DT;
    }

    public void setPOL_ORG_LC_NETT_PREM(Double POL_ORG_LC_NETT_PREM) {
	this.POL_ORG_LC_NETT_PREM = POL_ORG_LC_NETT_PREM;
    }

    public Double getPOL_ORG_LC_NETT_PREM() {
	return POL_ORG_LC_NETT_PREM;
    }

    public void setPOL_FC_NETT_PREM(Double POL_FC_NETT_PREM) {
	this.POL_FC_NETT_PREM = POL_FC_NETT_PREM;
    }

    public Double getPOL_FC_NETT_PREM() {
	return POL_FC_NETT_PREM;
    }

    public void setPOL_OFF_PHONE_NO(String POL_OFF_PHONE_NO) {
	this.POL_OFF_PHONE_NO = POL_OFF_PHONE_NO;
    }

    public String getPOL_OFF_PHONE_NO() {
	return POL_OFF_PHONE_NO;
    }

    public void setPOL_FC_FIRST_PREM(Double POL_FC_FIRST_PREM) {
	this.POL_FC_FIRST_PREM = POL_FC_FIRST_PREM;
    }

    public Double getPOL_FC_FIRST_PREM() {
	return POL_FC_FIRST_PREM;
    }

    public void setPOL_SA_EXCH_RATE(Double POL_SA_EXCH_RATE) {
	this.POL_SA_EXCH_RATE = POL_SA_EXCH_RATE;
    }

    public Double getPOL_SA_EXCH_RATE() {
	return POL_SA_EXCH_RATE;
    }

    public void setPOL_ORG_LC_EXTRA_PREM(Double POL_ORG_LC_EXTRA_PREM) {
	this.POL_ORG_LC_EXTRA_PREM = POL_ORG_LC_EXTRA_PREM;
    }

    public Double getPOL_ORG_LC_EXTRA_PREM() {
	return POL_ORG_LC_EXTRA_PREM;
    }

    public void setPOL_ORG_FC_PRE_TPD_BNF(Double POL_ORG_FC_PRE_TPD_BNF) {
	this.POL_ORG_FC_PRE_TPD_BNF = POL_ORG_FC_PRE_TPD_BNF;
    }

    public Double getPOL_ORG_FC_PRE_TPD_BNF() {
	return POL_ORG_FC_PRE_TPD_BNF;
    }

    public void setPOL_FC_PAYEE_PREM(Double POL_FC_PAYEE_PREM) {
	this.POL_FC_PAYEE_PREM = POL_FC_PAYEE_PREM;
    }

    public Double getPOL_FC_PAYEE_PREM() {
	return POL_FC_PAYEE_PREM;
    }

    public void setPOL_MODE_OF_PYMT(String POL_MODE_OF_PYMT) {
	this.POL_MODE_OF_PYMT = POL_MODE_OF_PYMT;
    }

    public String getPOL_MODE_OF_PYMT() {
	return POL_MODE_OF_PYMT;
    }

    public void setPOL_ORG_LC_CLIENT_ALLOC_AMT(
	    Double POL_ORG_LC_CLIENT_ALLOC_AMT) {
	this.POL_ORG_LC_CLIENT_ALLOC_AMT = POL_ORG_LC_CLIENT_ALLOC_AMT;
    }

    public Double getPOL_ORG_LC_CLIENT_ALLOC_AMT() {
	return POL_ORG_LC_CLIENT_ALLOC_AMT;
    }

    public void setPOL_APPRV_STATUS(String POL_APPRV_STATUS) {
	this.POL_APPRV_STATUS = POL_APPRV_STATUS;
    }

    public String getPOL_APPRV_STATUS() {
	return POL_APPRV_STATUS;
    }

    public void setPOL_LOAD_PERC(Double POL_LOAD_PERC) {
	this.POL_LOAD_PERC = POL_LOAD_PERC;
    }

    public Double getPOL_LOAD_PERC() {
	return POL_LOAD_PERC;
    }

    public void setPOL_LC_AMAN_PREM(Double POL_LC_AMAN_PREM) {
	this.POL_LC_AMAN_PREM = POL_LC_AMAN_PREM;
    }

    public Double getPOL_LC_AMAN_PREM() {
	return POL_LC_AMAN_PREM;
    }

    public void setPOL_FC_SUM_ASSURED(Double POL_FC_SUM_ASSURED) {
	this.POL_FC_SUM_ASSURED = POL_FC_SUM_ASSURED;
    }

    public Double getPOL_FC_SUM_ASSURED() {
	return POL_FC_SUM_ASSURED;
    }

    public void setPOL_FC_MIN_PREM(Double POL_FC_MIN_PREM) {
	this.POL_FC_MIN_PREM = POL_FC_MIN_PREM;
    }

    public Double getPOL_FC_MIN_PREM() {
	return POL_FC_MIN_PREM;
    }

    public void setPOL_BNFCY_DTLS(String POL_BNFCY_DTLS) {
	this.POL_BNFCY_DTLS = POL_BNFCY_DTLS;
    }

    public String getPOL_BNFCY_DTLS() {
	return POL_BNFCY_DTLS;
    }

    public void setPOL_STD_RISK_YN(String POL_STD_RISK_YN) {
	this.POL_STD_RISK_YN = POL_STD_RISK_YN;
    }

    public String getPOL_STD_RISK_YN() {
	return POL_STD_RISK_YN;
    }

    public void setPOL_PROP_END_CODE(String POL_PROP_END_CODE) {
	this.POL_PROP_END_CODE = POL_PROP_END_CODE;
    }

    public String getPOL_PROP_END_CODE() {
	return POL_PROP_END_CODE;
    }

    public void setPOL_FLEX_09(String POL_FLEX_09) {
	this.POL_FLEX_09 = POL_FLEX_09;
    }

    public String getPOL_FLEX_09() {
	return POL_FLEX_09;
    }

    public void setPOL_NO_OF_INST(Double POL_NO_OF_INST) {
	this.POL_NO_OF_INST = POL_NO_OF_INST;
    }

    public Double getPOL_NO_OF_INST() {
	return POL_NO_OF_INST;
    }

    public void setPOL_ORG_FC_MODAL_PREM(Double POL_ORG_FC_MODAL_PREM) {
	this.POL_ORG_FC_MODAL_PREM = POL_ORG_FC_MODAL_PREM;
    }

    public Double getPOL_ORG_FC_MODAL_PREM() {
	return POL_ORG_FC_MODAL_PREM;
    }

    public void setPOL_FLEX_08(String POL_FLEX_08) {
	this.POL_FLEX_08 = POL_FLEX_08;
    }

    public String getPOL_FLEX_08() {
	return POL_FLEX_08;
    }

    public void setPOL_MED_FEE_RECOVER_YN(String POL_MED_FEE_RECOVER_YN) {
	this.POL_MED_FEE_RECOVER_YN = POL_MED_FEE_RECOVER_YN;
    }

    public String getPOL_MED_FEE_RECOVER_YN() {
	return POL_MED_FEE_RECOVER_YN;
    }

    public void setPOL_FLEX_05(String POL_FLEX_05) {
	this.POL_FLEX_05 = POL_FLEX_05;
    }

    public String getPOL_FLEX_05() {
	return POL_FLEX_05;
    }

    public void setPOL_OFF_ADDRESS_3(String POL_OFF_ADDRESS_3) {
	this.POL_OFF_ADDRESS_3 = POL_OFF_ADDRESS_3;
    }

    public String getPOL_OFF_ADDRESS_3() {
	return POL_OFF_ADDRESS_3;
    }

    public void setPOL_RES_AREA_CODE(String POL_RES_AREA_CODE) {
	this.POL_RES_AREA_CODE = POL_RES_AREA_CODE;
    }

    public String getPOL_RES_AREA_CODE() {
	return POL_RES_AREA_CODE;
    }

    public void setPOL_FLEX_04(String POL_FLEX_04) {
	this.POL_FLEX_04 = POL_FLEX_04;
    }

    public String getPOL_FLEX_04() {
	return POL_FLEX_04;
    }

    public void setPOL_FLEX_07(String POL_FLEX_07) {
	this.POL_FLEX_07 = POL_FLEX_07;
    }

    public String getPOL_FLEX_07() {
	return POL_FLEX_07;
    }

    public void setPOL_OFF_ADDRESS_2(String POL_OFF_ADDRESS_2) {
	this.POL_OFF_ADDRESS_2 = POL_OFF_ADDRESS_2;
    }

    public String getPOL_OFF_ADDRESS_2() {
	return POL_OFF_ADDRESS_2;
    }

    public void setPOL_FLEX_06(String POL_FLEX_06) {
	this.POL_FLEX_06 = POL_FLEX_06;
    }

    public String getPOL_FLEX_06() {
	return POL_FLEX_06;
    }

    public void setPOL_OFF_ADDRESS_1(String POL_OFF_ADDRESS_1) {
	this.POL_OFF_ADDRESS_1 = POL_OFF_ADDRESS_1;
    }

    public String getPOL_OFF_ADDRESS_1() {
	return POL_OFF_ADDRESS_1;
    }

    public void setPOL_FLEX_01(String POL_FLEX_01) {
	this.POL_FLEX_01 = POL_FLEX_01;
    }

    public String getPOL_FLEX_01() {
	return POL_FLEX_01;
    }

    public void setPOL_SA_CURR_CODE(String POL_SA_CURR_CODE) {
	this.POL_SA_CURR_CODE = POL_SA_CURR_CODE;
    }

    public String getPOL_SA_CURR_CODE() {
	return POL_SA_CURR_CODE;
    }

    public void setPOL_ORG_FC_SUM_ASSURED(Double POL_ORG_FC_SUM_ASSURED) {
	this.POL_ORG_FC_SUM_ASSURED = POL_ORG_FC_SUM_ASSURED;
    }

    public Double getPOL_ORG_FC_SUM_ASSURED() {
	return POL_ORG_FC_SUM_ASSURED;
    }

    public void setPOL_FLEX_03(String POL_FLEX_03) {
	this.POL_FLEX_03 = POL_FLEX_03;
    }

    public String getPOL_FLEX_03() {
	return POL_FLEX_03;
    }

    public void setPOL_ORG_LC_FIRST_PREM(Double POL_ORG_LC_FIRST_PREM) {
	this.POL_ORG_LC_FIRST_PREM = POL_ORG_LC_FIRST_PREM;
    }

    public Double getPOL_ORG_LC_FIRST_PREM() {
	return POL_ORG_LC_FIRST_PREM;
    }

    public void setPOL_FLEX_02(String POL_FLEX_02) {
	this.POL_FLEX_02 = POL_FLEX_02;
    }

    public String getPOL_FLEX_02() {
	return POL_FLEX_02;
    }

    public void setPOL_CUST_CODE(String POL_CUST_CODE) {
	this.POL_CUST_CODE = POL_CUST_CODE;
    }

    public String getPOL_CUST_CODE() {
	return POL_CUST_CODE;
    }

    public void setPOL_LC_BASIC_PREM(Double POL_LC_BASIC_PREM) {
	this.POL_LC_BASIC_PREM = POL_LC_BASIC_PREM;
    }

    public Double getPOL_LC_BASIC_PREM() {
	return POL_LC_BASIC_PREM;
    }

    public void setPOL_CLASS_CODE(String POL_CLASS_CODE) {
	this.POL_CLASS_CODE = POL_CLASS_CODE;
    }

    public String getPOL_CLASS_CODE() {
	return POL_CLASS_CODE;
    }

    public void setPOL_FC_DEPOSIT_AMOUNT(Double POL_FC_DEPOSIT_AMOUNT) {
	this.POL_FC_DEPOSIT_AMOUNT = POL_FC_DEPOSIT_AMOUNT;
    }

    public Double getPOL_FC_DEPOSIT_AMOUNT() {
	return POL_FC_DEPOSIT_AMOUNT;
    }

    public void setPOL_MOBILE_NO(String POL_MOBILE_NO) {
	this.POL_MOBILE_NO = POL_MOBILE_NO;
    }

    public String getPOL_MOBILE_NO() {
	return POL_MOBILE_NO;
    }

    public void setPOL_HOLD_YN(String POL_HOLD_YN) {
	this.POL_HOLD_YN = POL_HOLD_YN;
    }

    public String getPOL_HOLD_YN() {
	return POL_HOLD_YN;
    }

    public void setPOL_ORG_FC_BASIC_PREM(Double POL_ORG_FC_BASIC_PREM) {
	this.POL_ORG_FC_BASIC_PREM = POL_ORG_FC_BASIC_PREM;
    }

    public Double getPOL_ORG_FC_BASIC_PREM() {
	return POL_ORG_FC_BASIC_PREM;
    }

    public void setPOL_DEPT_CODE(String POL_DEPT_CODE) {
	this.POL_DEPT_CODE = POL_DEPT_CODE;
    }

    public String getPOL_DEPT_CODE() {
	return POL_DEPT_CODE;
    }

    public void setPOL_ORG_FC_TOP_UP_AMT(Double POL_ORG_FC_TOP_UP_AMT) {
	this.POL_ORG_FC_TOP_UP_AMT = POL_ORG_FC_TOP_UP_AMT;
    }

    public Double getPOL_ORG_FC_TOP_UP_AMT() {
	return POL_ORG_FC_TOP_UP_AMT;
    }

    public void setPOL_ORG_FC_ADDL_PREM(Double POL_ORG_FC_ADDL_PREM) {
	this.POL_ORG_FC_ADDL_PREM = POL_ORG_FC_ADDL_PREM;
    }

    public Double getPOL_ORG_FC_ADDL_PREM() {
	return POL_ORG_FC_ADDL_PREM;
    }

    public void setPOL_ASSURED_NAME(String POL_ASSURED_NAME) {
	this.POL_ASSURED_NAME = POL_ASSURED_NAME;
    }

    public String getPOL_ASSURED_NAME() {
	return POL_ASSURED_NAME;
    }

    public void setPOL_ORG_FC_FIRST_PREM(Double POL_ORG_FC_FIRST_PREM) {
	this.POL_ORG_FC_FIRST_PREM = POL_ORG_FC_FIRST_PREM;
    }

    public Double getPOL_ORG_FC_FIRST_PREM() {
	return POL_ORG_FC_FIRST_PREM;
    }

    public void setPOL_UPD_DT(Date POL_UPD_DT) {
	this.POL_UPD_DT = POL_UPD_DT;
    }

    public Date getPOL_UPD_DT() {
	return POL_UPD_DT;
    }

    public void setPOL_MODE_OF_CALC(String POL_MODE_OF_CALC) {
	this.POL_MODE_OF_CALC = POL_MODE_OF_CALC;
    }

    public String getPOL_MODE_OF_CALC() {
	return POL_MODE_OF_CALC;
    }

    public void setPOL_PROP_NO(String POL_PROP_NO) {
	this.POL_PROP_NO = POL_PROP_NO;
    }

    public String getPOL_PROP_NO() {
	return POL_PROP_NO;
    }

    public void setPOL_ORG_LC_SUM_ASSURED(Double POL_ORG_LC_SUM_ASSURED) {
	this.POL_ORG_LC_SUM_ASSURED = POL_ORG_LC_SUM_ASSURED;
    }

    public Double getPOL_ORG_LC_SUM_ASSURED() {
	return POL_ORG_LC_SUM_ASSURED;
    }

    public void setPOL_EMPLOYER_CODE(String POL_EMPLOYER_CODE) {
	this.POL_EMPLOYER_CODE = POL_EMPLOYER_CODE;
    }

    public String getPOL_EMPLOYER_CODE() {
	return POL_EMPLOYER_CODE;
    }

    public void setPOL_ORG_PREM_PAY_YRS(Double POL_ORG_PREM_PAY_YRS) {
	this.POL_ORG_PREM_PAY_YRS = POL_ORG_PREM_PAY_YRS;
    }

    public Double getPOL_ORG_PREM_PAY_YRS() {
	return POL_ORG_PREM_PAY_YRS;
    }

    public void setPOL_LC_EXTRA_PREM(Double POL_LC_EXTRA_PREM) {
	this.POL_LC_EXTRA_PREM = POL_LC_EXTRA_PREM;
    }

    public Double getPOL_LC_EXTRA_PREM() {
	return POL_LC_EXTRA_PREM;
    }

    public void setPOL_ORG_NO_OF_UNIT(Double POL_ORG_NO_OF_UNIT) {
	this.POL_ORG_NO_OF_UNIT = POL_ORG_NO_OF_UNIT;
    }

    public Double getPOL_ORG_NO_OF_UNIT() {
	return POL_ORG_NO_OF_UNIT;
    }

    public void setPOL_LC_MODAL_PREM(Double POL_LC_MODAL_PREM) {
	this.POL_LC_MODAL_PREM = POL_LC_MODAL_PREM;
    }

    public Double getPOL_LC_MODAL_PREM() {
	return POL_LC_MODAL_PREM;
    }

    public void setPOL_PROD_GROUP_CODE(String POL_PROD_GROUP_CODE) {
	this.POL_PROD_GROUP_CODE = POL_PROD_GROUP_CODE;
    }

    public String getPOL_PROD_GROUP_CODE() {
	return POL_PROD_GROUP_CODE;
    }

    public void setPOL_ORG_NO_OF_INST(Double POL_ORG_NO_OF_INST) {
	this.POL_ORG_NO_OF_INST = POL_ORG_NO_OF_INST;
    }

    public Double getPOL_ORG_NO_OF_INST() {
	return POL_ORG_NO_OF_INST;
    }

    public void setPOL_REMARKS(String POL_REMARKS) {
	this.POL_REMARKS = POL_REMARKS;
    }

    public String getPOL_REMARKS() {
	return POL_REMARKS;
    }

    public void setPOL_TRAN_DT(Date POL_TRAN_DT) {
	this.POL_TRAN_DT = POL_TRAN_DT;
    }

    public Date getPOL_TRAN_DT() {
	return POL_TRAN_DT;
    }

    public void setPOL_RI_POOL_CODE(String POL_RI_POOL_CODE) {
	this.POL_RI_POOL_CODE = POL_RI_POOL_CODE;
    }

    public String getPOL_RI_POOL_CODE() {
	return POL_RI_POOL_CODE;
    }

    public void setPOL_START_DT(Date POL_START_DT) {
	this.POL_START_DT = POL_START_DT;
    }

    public Date getPOL_START_DT() {
	return POL_START_DT;
    }

    public void setPOL_ORG_FC_EXTRA_PREM(Double POL_ORG_FC_EXTRA_PREM) {
	this.POL_ORG_FC_EXTRA_PREM = POL_ORG_FC_EXTRA_PREM;
    }

    public Double getPOL_ORG_FC_EXTRA_PREM() {
	return POL_ORG_FC_EXTRA_PREM;
    }

    public void setPOL_CLM_ADDL_STATUS(String POL_CLM_ADDL_STATUS) {
	this.POL_CLM_ADDL_STATUS = POL_CLM_ADDL_STATUS;
    }

    public String getPOL_CLM_ADDL_STATUS() {
	return POL_CLM_ADDL_STATUS;
    }

    public void setPOL_CUST_EXCH_RATE(Double POL_CUST_EXCH_RATE) {
	this.POL_CUST_EXCH_RATE = POL_CUST_EXCH_RATE;
    }

    public Double getPOL_CUST_EXCH_RATE() {
	return POL_CUST_EXCH_RATE;
    }

    public void setPOL_FAX_AREA_CODE(String POL_FAX_AREA_CODE) {
	this.POL_FAX_AREA_CODE = POL_FAX_AREA_CODE;
    }

    public String getPOL_FAX_AREA_CODE() {
	return POL_FAX_AREA_CODE;
    }

    public void setPOL_FC_PRE_TPD_BNF(Double POL_FC_PRE_TPD_BNF) {
	this.POL_FC_PRE_TPD_BNF = POL_FC_PRE_TPD_BNF;
    }

    public Double getPOL_FC_PRE_TPD_BNF() {
	return POL_FC_PRE_TPD_BNF;
    }

    public void setPOL_BANK_BRANCH_NAME(String POL_BANK_BRANCH_NAME) {
	this.POL_BANK_BRANCH_NAME = POL_BANK_BRANCH_NAME;
    }

    public String getPOL_BANK_BRANCH_NAME() {
	return POL_BANK_BRANCH_NAME;
    }

    public void setPOL_END_APPRV_DT(Date POL_END_APPRV_DT) {
	this.POL_END_APPRV_DT = POL_END_APPRV_DT;
    }

    public Date getPOL_END_APPRV_DT() {
	return POL_END_APPRV_DT;
    }

    public void setPOL_CITY_CODE(String POL_CITY_CODE) {
	this.POL_CITY_CODE = POL_CITY_CODE;
    }

    public String getPOL_CITY_CODE() {
	return POL_CITY_CODE;
    }

    public void setPOL_DS_TYPE(String POL_DS_TYPE) {
	this.POL_DS_TYPE = POL_DS_TYPE;
    }

    public String getPOL_DS_TYPE() {
	return POL_DS_TYPE;
    }

    public void setPOL_CONVERT_YN(String POL_CONVERT_YN) {
	this.POL_CONVERT_YN = POL_CONVERT_YN;
    }

    public String getPOL_CONVERT_YN() {
	return POL_CONVERT_YN;
    }

    public void setPOL_FC_SENABEL_PREM(Double POL_FC_SENABEL_PREM) {
	this.POL_FC_SENABEL_PREM = POL_FC_SENABEL_PREM;
    }

    public Double getPOL_FC_SENABEL_PREM() {
	return POL_FC_SENABEL_PREM;
    }

    public void setPOL_ORG_FC_BANK_ALLOC_AMT(Double POL_ORG_FC_BANK_ALLOC_AMT) {
	this.POL_ORG_FC_BANK_ALLOC_AMT = POL_ORG_FC_BANK_ALLOC_AMT;
    }

    public Double getPOL_ORG_FC_BANK_ALLOC_AMT() {
	return POL_ORG_FC_BANK_ALLOC_AMT;
    }

    public void setPOL_ORG_LC_PAYOR_PREM(Double POL_ORG_LC_PAYOR_PREM) {
	this.POL_ORG_LC_PAYOR_PREM = POL_ORG_LC_PAYOR_PREM;
    }

    public Double getPOL_ORG_LC_PAYOR_PREM() {
	return POL_ORG_LC_PAYOR_PREM;
    }

    public void setPOL_NL_FM_DT(Date POL_NL_FM_DT) {
	this.POL_NL_FM_DT = POL_NL_FM_DT;
    }

    public Date getPOL_NL_FM_DT() {
	return POL_NL_FM_DT;
    }

    public void setPOL_LC_OCC_LOAD(Double POL_LC_OCC_LOAD) {
	this.POL_LC_OCC_LOAD = POL_LC_OCC_LOAD;
    }

    public Double getPOL_LC_OCC_LOAD() {
	return POL_LC_OCC_LOAD;
    }

    public void setPOL_FC_EXTRA_PREM(Double POL_FC_EXTRA_PREM) {
	this.POL_FC_EXTRA_PREM = POL_FC_EXTRA_PREM;
    }

    public Double getPOL_FC_EXTRA_PREM() {
	return POL_FC_EXTRA_PREM;
    }

    public void setPOL_CREDIT_YN(String POL_CREDIT_YN) {
	this.POL_CREDIT_YN = POL_CREDIT_YN;
    }

    public String getPOL_CREDIT_YN() {
	return POL_CREDIT_YN;
    }

    public void setPOL_RATE_APPLIED_ON(String POL_RATE_APPLIED_ON) {
	this.POL_RATE_APPLIED_ON = POL_RATE_APPLIED_ON;
    }

    public String getPOL_RATE_APPLIED_ON() {
	return POL_RATE_APPLIED_ON;
    }

    public void setPOL_FACIN_YN(String POL_FACIN_YN) {
	this.POL_FACIN_YN = POL_FACIN_YN;
    }

    public String getPOL_FACIN_YN() {
	return POL_FACIN_YN;
    }

    public void setPOL_END_TYPE(String POL_END_TYPE) {
	this.POL_END_TYPE = POL_END_TYPE;
    }

    public String getPOL_END_TYPE() {
	return POL_END_TYPE;
    }

    public void setPOL_UW_YEAR(Double POL_UW_YEAR) {
	this.POL_UW_YEAR = POL_UW_YEAR;
    }

    public Double getPOL_UW_YEAR() {
	return POL_UW_YEAR;
    }

    public void setPOL_MODE_OF_PYMT_RATE(Double POL_MODE_OF_PYMT_RATE) {
	this.POL_MODE_OF_PYMT_RATE = POL_MODE_OF_PYMT_RATE;
    }

    public Double getPOL_MODE_OF_PYMT_RATE() {
	return POL_MODE_OF_PYMT_RATE;
    }

    public void setPOL_ASSRD_REF_ID2(String POL_ASSRD_REF_ID2) {
	this.POL_ASSRD_REF_ID2 = POL_ASSRD_REF_ID2;
    }

    public String getPOL_ASSRD_REF_ID2() {
	return POL_ASSRD_REF_ID2;
    }

    public void setPOL_ASSRD_REF_ID1(String POL_ASSRD_REF_ID1) {
	this.POL_ASSRD_REF_ID1 = POL_ASSRD_REF_ID1;
    }

    public String getPOL_ASSRD_REF_ID1() {
	return POL_ASSRD_REF_ID1;
    }

    public void setPOL_STATE_CODE(String POL_STATE_CODE) {
	this.POL_STATE_CODE = POL_STATE_CODE;
    }

    public String getPOL_STATE_CODE() {
	return POL_STATE_CODE;
    }

    public void setPOL_SUB_PLAN_CODE(String POL_SUB_PLAN_CODE) {
	this.POL_SUB_PLAN_CODE = POL_SUB_PLAN_CODE;
    }

    public String getPOL_SUB_PLAN_CODE() {
	return POL_SUB_PLAN_CODE;
    }

    public void setPOL_LINK_SYS_ID(Long POL_LINK_SYS_ID) {
	this.POL_LINK_SYS_ID = POL_LINK_SYS_ID;
    }

    public Long getPOL_LINK_SYS_ID() {
	return POL_LINK_SYS_ID;
    }

    public void setPOL_BANK_REF_NO(String POL_BANK_REF_NO) {
	this.POL_BANK_REF_NO = POL_BANK_REF_NO;
    }

    public String getPOL_BANK_REF_NO() {
	return POL_BANK_REF_NO;
    }

    public void setPOL_FAC_BASIS(String POL_FAC_BASIS) {
	this.POL_FAC_BASIS = POL_FAC_BASIS;
    }

    public String getPOL_FAC_BASIS() {
	return POL_FAC_BASIS;
    }

    public void setPOL_LC_HEALTH_LOAD(Double POL_LC_HEALTH_LOAD) {
	this.POL_LC_HEALTH_LOAD = POL_LC_HEALTH_LOAD;
    }

    public Double getPOL_LC_HEALTH_LOAD() {
	return POL_LC_HEALTH_LOAD;
    }

    public void setPOL_ORG_FC_PAYEE_PREM(Double POL_ORG_FC_PAYEE_PREM) {
	this.POL_ORG_FC_PAYEE_PREM = POL_ORG_FC_PAYEE_PREM;
    }

    public Double getPOL_ORG_FC_PAYEE_PREM() {
	return POL_ORG_FC_PAYEE_PREM;
    }

    public void setPOL_END_EFF_FROM_DT(Date POL_END_EFF_FROM_DT) {
	this.POL_END_EFF_FROM_DT = POL_END_EFF_FROM_DT;
    }

    public Date getPOL_END_EFF_FROM_DT() {
	return POL_END_EFF_FROM_DT;
    }

    public void setPOL_FC_AMAN_PREM(Double POL_FC_AMAN_PREM) {
	this.POL_FC_AMAN_PREM = POL_FC_AMAN_PREM;
    }

    public Double getPOL_FC_AMAN_PREM() {
	return POL_FC_AMAN_PREM;
    }

    public void setPOL_END_DESC(String POL_END_DESC) {
	this.POL_END_DESC = POL_END_DESC;
    }

    public String getPOL_END_DESC() {
	return POL_END_DESC;
    }

    public void setPOL_AGENT_REF_CODE(String POL_AGENT_REF_CODE) {
	this.POL_AGENT_REF_CODE = POL_AGENT_REF_CODE;
    }

    public String getPOL_AGENT_REF_CODE() {
	return POL_AGENT_REF_CODE;
    }

    public void setPOL_FC_DISC_AMT(Double POL_FC_DISC_AMT) {
	this.POL_FC_DISC_AMT = POL_FC_DISC_AMT;
    }

    public Double getPOL_FC_DISC_AMT() {
	return POL_FC_DISC_AMT;
    }

    public void setPOL_APPRV_DT(Date POL_APPRV_DT) {
	this.POL_APPRV_DT = POL_APPRV_DT;
    }

    public Date getPOL_APPRV_DT() {
	return POL_APPRV_DT;
    }

    public void setPOL_OCC_RATE(Double POL_OCC_RATE) {
	this.POL_OCC_RATE = POL_OCC_RATE;
    }

    public Double getPOL_OCC_RATE() {
	return POL_OCC_RATE;
    }

    public void setPOL_END_CODE(String POL_END_CODE) {
	this.POL_END_CODE = POL_END_CODE;
    }

    public String getPOL_END_CODE() {
	return POL_END_CODE;
    }

    public void setPOL_MASTER_POL_NO(String POL_MASTER_POL_NO) {
	this.POL_MASTER_POL_NO = POL_MASTER_POL_NO;
    }

    public String getPOL_MASTER_POL_NO() {
	return POL_MASTER_POL_NO;
    }

    public void setPOL_FAX_NO(String POL_FAX_NO) {
	this.POL_FAX_NO = POL_FAX_NO;
    }

    public String getPOL_FAX_NO() {
	return POL_FAX_NO;
    }

    public void setPOL_DEFER_PRD(Double POL_DEFER_PRD) {
	this.POL_DEFER_PRD = POL_DEFER_PRD;
    }

    public Double getPOL_DEFER_PRD() {
	return POL_DEFER_PRD;
    }

    public void setPOL_LC_PRE_TPD_BNF(Double POL_LC_PRE_TPD_BNF) {
	this.POL_LC_PRE_TPD_BNF = POL_LC_PRE_TPD_BNF;
    }

    public Double getPOL_LC_PRE_TPD_BNF() {
	return POL_LC_PRE_TPD_BNF;
    }

    public void setPOL_ORG_FC_TOT_SA(Double POL_ORG_FC_TOT_SA) {
	this.POL_ORG_FC_TOT_SA = POL_ORG_FC_TOT_SA;
    }

    public Double getPOL_ORG_FC_TOT_SA() {
	return POL_ORG_FC_TOT_SA;
    }

    public void setPOL_ORG_FC_CURR_SA(Double POL_ORG_FC_CURR_SA) {
	this.POL_ORG_FC_CURR_SA = POL_ORG_FC_CURR_SA;
    }

    public Double getPOL_ORG_FC_CURR_SA() {
	return POL_ORG_FC_CURR_SA;
    }

    public void setPOL_FIRST_INST_DT(Date POL_FIRST_INST_DT) {
	this.POL_FIRST_INST_DT = POL_FIRST_INST_DT;
    }

    public Date getPOL_FIRST_INST_DT() {
	return POL_FIRST_INST_DT;
    }

    public void setPOL_ORG_LC_CURR_SA(Double POL_ORG_LC_CURR_SA) {
	this.POL_ORG_LC_CURR_SA = POL_ORG_LC_CURR_SA;
    }

    public Double getPOL_ORG_LC_CURR_SA() {
	return POL_ORG_LC_CURR_SA;
    }

    public void setPOL_ORG_PERIOD(Double POL_ORG_PERIOD) {
	this.POL_ORG_PERIOD = POL_ORG_PERIOD;
    }

    public Double getPOL_ORG_PERIOD() {
	return POL_ORG_PERIOD;
    }

    public void setPOL_FC_HEALTH_LOAD(Double POL_FC_HEALTH_LOAD) {
	this.POL_FC_HEALTH_LOAD = POL_FC_HEALTH_LOAD;
    }

    public Double getPOL_FC_HEALTH_LOAD() {
	return POL_FC_HEALTH_LOAD;
    }

    public void setPOL_LC_TOP_UP_AMT(Double POL_LC_TOP_UP_AMT) {
	this.POL_LC_TOP_UP_AMT = POL_LC_TOP_UP_AMT;
    }

    public Double getPOL_LC_TOP_UP_AMT() {
	return POL_LC_TOP_UP_AMT;
    }

    public void setPOL_PYMT_TYPE(String POL_PYMT_TYPE) {
	this.POL_PYMT_TYPE = POL_PYMT_TYPE;
    }

    public String getPOL_PYMT_TYPE() {
	return POL_PYMT_TYPE;
    }

    public void setPOL_LC_DISC_AMT(Double POL_LC_DISC_AMT) {
	this.POL_LC_DISC_AMT = POL_LC_DISC_AMT;
    }

    public Double getPOL_LC_DISC_AMT() {
	return POL_LC_DISC_AMT;
    }

    public void setPOL_LC_PAYOR_PREM(Double POL_LC_PAYOR_PREM) {
	this.POL_LC_PAYOR_PREM = POL_LC_PAYOR_PREM;
    }

    public Double getPOL_LC_PAYOR_PREM() {
	return POL_LC_PAYOR_PREM;
    }

    public void setPOL_FAC_CLOSE_FLAG(String POL_FAC_CLOSE_FLAG) {
	this.POL_FAC_CLOSE_FLAG = POL_FAC_CLOSE_FLAG;
    }

    public String getPOL_FAC_CLOSE_FLAG() {
	return POL_FAC_CLOSE_FLAG;
    }

    public void setPOL_PROP_STAMP_DT(Date POL_PROP_STAMP_DT) {
	this.POL_PROP_STAMP_DT = POL_PROP_STAMP_DT;
    }

    public Date getPOL_PROP_STAMP_DT() {
	return POL_PROP_STAMP_DT;
    }

    public void setPOL_LC_DEPOSIT_AMOUNT(Double POL_LC_DEPOSIT_AMOUNT) {
	this.POL_LC_DEPOSIT_AMOUNT = POL_LC_DEPOSIT_AMOUNT;
    }

    public Double getPOL_LC_DEPOSIT_AMOUNT() {
	return POL_LC_DEPOSIT_AMOUNT;
    }

    public void setPOL_ORG_FC_MIN_PREM(Double POL_ORG_FC_MIN_PREM) {
	this.POL_ORG_FC_MIN_PREM = POL_ORG_FC_MIN_PREM;
    }

    public Double getPOL_ORG_FC_MIN_PREM() {
	return POL_ORG_FC_MIN_PREM;
    }

    public void setPOL_DIVN_CODE(String POL_DIVN_CODE) {
	this.POL_DIVN_CODE = POL_DIVN_CODE;
    }

    public String getPOL_DIVN_CODE() {
	return POL_DIVN_CODE;
    }

    public void setPOL_FC_NET_PREM(Double POL_FC_NET_PREM) {
	this.POL_FC_NET_PREM = POL_FC_NET_PREM;
    }

    public Double getPOL_FC_NET_PREM() {
	return POL_FC_NET_PREM;
    }

    public void setPOL_CUST_CURR_CODE(String POL_CUST_CURR_CODE) {
	this.POL_CUST_CURR_CODE = POL_CUST_CURR_CODE;
    }

    public String getPOL_CUST_CURR_CODE() {
	return POL_CUST_CURR_CODE;
    }

    public void setPOL_ADDL_STATUS(String POL_ADDL_STATUS) {
	this.POL_ADDL_STATUS = POL_ADDL_STATUS;
    }

    public String getPOL_ADDL_STATUS() {
	return POL_ADDL_STATUS;
    }

    public void setPOL_LC_CLIENT_ALLOC_AMT(Double POL_LC_CLIENT_ALLOC_AMT) {
	this.POL_LC_CLIENT_ALLOC_AMT = POL_LC_CLIENT_ALLOC_AMT;
    }

    public Double getPOL_LC_CLIENT_ALLOC_AMT() {
	return POL_LC_CLIENT_ALLOC_AMT;
    }

    public void setPOL_FC_TOP_UP_AMT(Double POL_FC_TOP_UP_AMT) {
	this.POL_FC_TOP_UP_AMT = POL_FC_TOP_UP_AMT;
    }

    public Double getPOL_FC_TOP_UP_AMT() {
	return POL_FC_TOP_UP_AMT;
    }

    public void setPOL_TARIFF_TERM_FLAG(String POL_TARIFF_TERM_FLAG) {
	this.POL_TARIFF_TERM_FLAG = POL_TARIFF_TERM_FLAG;
    }

    public String getPOL_TARIFF_TERM_FLAG() {
	return POL_TARIFF_TERM_FLAG;
    }

    public void setPOL_PROP_QUOT_FLAG(String POL_PROP_QUOT_FLAG) {
	this.POL_PROP_QUOT_FLAG = POL_PROP_QUOT_FLAG;
    }

    public String getPOL_PROP_QUOT_FLAG() {
	return POL_PROP_QUOT_FLAG;
    }

    public void setPOL_OFF_AREA_CODE(String POL_OFF_AREA_CODE) {
	this.POL_OFF_AREA_CODE = POL_OFF_AREA_CODE;
    }

    public String getPOL_OFF_AREA_CODE() {
	return POL_OFF_AREA_CODE;
    }

    public void setPOL_EXC_INT_PERC(Double POL_EXC_INT_PERC) {
	this.POL_EXC_INT_PERC = POL_EXC_INT_PERC;
    }

    public Double getPOL_EXC_INT_PERC() {
	return POL_EXC_INT_PERC;
    }

    public void setPOL_HOME_OWNER_FLAG(String POL_HOME_OWNER_FLAG) {
	this.POL_HOME_OWNER_FLAG = POL_HOME_OWNER_FLAG;
    }

    public String getPOL_HOME_OWNER_FLAG() {
	return POL_HOME_OWNER_FLAG;
    }

}

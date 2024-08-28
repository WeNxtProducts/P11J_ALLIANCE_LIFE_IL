package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {
    
    @Column(name="POL_CARD_HOLDER_NAME")
	private String POL_CARD_HOLDER_NAME;

	@Column(name="POL_DEF_IMM_FLAG")
	private String POL_DEF_IMM_FLAG ;

	@Column(name="POL_FC_MON_ANNU_AMT")
	private Double POL_FC_MON_ANNU_AMT;

	@Column(name="POL_LC_MON_ANNU_AMT")
	private Double POL_LC_MON_ANNU_AMT;

	@Column(name="POL_AUTH_LIMIT")
	private Double POL_AUTH_LIMIT ;
	
        @Column(name="POL_DEF_PERIOD_FM")
	private Double POL_DEF_PERIOD_FM ;

	@Column(name="POL_DEF_PERIOD_TO")
	private Double POL_DEF_PERIOD_TO ;

	@Column(name="POL_WAQAF_PERIOD_FM")
	private Double POL_WAQAF_PERIOD_FM;

	@Column(name="POL_WAQAF_PERIOD_TO")
	private Double POL_WAQAF_PERIOD_TO;

	@Column(name="POL_SYS_ID")
	private Long POL_SYS_ID;

	@Column(name="POL_PROP_SYS_ID")
	private Double POL_PROP_SYS_ID ;

	@Column(name="POL_PROP_NO")
	private String POL_PROP_NO ;

	@Column(name="POL_DIVN_CODE")
	private String POL_DIVN_CODE;

	@Column(name="POL_DEPT_CODE")
	private String POL_DEPT_CODE;

	@Column(name="POL_DS_CODE")
	private String POL_DS_CODE;

	@Column(name="POL_CLASS_CODE")
	private String POL_CLASS_CODE;

	@Column(name="POL_UW_YEAR")
	private Integer POL_UW_YEAR;

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_ISSUE_DT")
	private Date POL_ISSUE_DT;

	@Column(name="POL_PLAN_CODE")
	private String POL_PLAN_CODE;

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	@Column(name="POL_CONT_CODE")
	private String POL_CONT_CODE;

	@Column(name="POL_ASSURED_NAME")
	private String POL_ASSURED_NAME;

	@Column(name="POL_RES_ADDRESS_1")
	private String POL_RES_ADDRESS_1;

	@Column(name="POL_RES_ADDRESS_2")
	private String POL_RES_ADDRESS_2;

	@Column(name="POL_RES_ADDRESS_3")
	private String POL_RES_ADDRESS_3;

	@Column(name="POL_OFF_ADDRESS_1")
	private String POL_OFF_ADDRESS_1;

	@Column(name="POL_OFF_ADDRESS_2")
	private String POL_OFF_ADDRESS_2;

	@Column(name="POL_OFF_ADDRESS_3")
	private String POL_OFF_ADDRESS_3;

	@Column(name="POL_SA_CURR_CODE")
	private String POL_SA_CURR_CODE;

	@Column(name="POL_SA_EXCH_RATE")
	private Double POL_SA_EXCH_RATE;

	@Column(name="POL_CUST_CURR_CODE")
	private String POL_CUST_CURR_CODE;

	@Column(name="POL_CUST_EXCH_RATE")
	private Double POL_CUST_EXCH_RATE;

	@Column(name="POL_FC_SUM_ASSURED")
	private Double POL_FC_SUM_ASSURED;

	@Column(name="POL_LC_SUM_ASSURED")
	private Double POL_LC_SUM_ASSURED;

	@Column(name="POL_FC_CURR_SA")
	private Double POL_FC_CURR_SA;

	@Column(name="POL_LC_CURR_SA")
	private Double POL_LC_CURR_SA;

	@Column(name="POL_PERIOD")
	private Integer POL_PERIOD;

	@Column(name="POL_START_DT")
	private Date POL_START_DT;

	@Column(name="POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	@Column(name="POL_BASIC_RATE")
	private Double POL_BASIC_RATE;

	@Column(name="POL_NL_FM_DT")
	private Date POL_NL_FM_DT;

	@Column(name="POL_NL_TO_DT")
	private Date POL_NL_TO_DT;

	@Column(name="POL_OCC_RATE")
	private Double POL_OCC_RATE;

	@Column(name="POL_HEALTH_RATE")
	private Double POL_HEALTH_RATE;

	@Column(name="POL_FC_BASIC_PREM")
	private Double POL_FC_BASIC_PREM;

	@Column(name="POL_LC_BASIC_PREM")
	private Double POL_LC_BASIC_PREM;

	@Column(name="POL_FC_ADDL_PREM")
	private Double POL_FC_ADDL_PREM;

	@Column(name="POL_LC_ADDL_PREM")
	private Double POL_LC_ADDL_PREM;

	@Column(name="POL_FC_OCC_LOAD")
	private Double POL_FC_OCC_LOAD;

	@Column(name="POL_LC_OCC_LOAD")
	private Double POL_LC_OCC_LOAD;

	@Column(name="POL_FC_HEALTH_LOAD")
	private Double POL_FC_HEALTH_LOAD;

	@Column(name="POL_LC_HEALTH_LOAD")
	private Double POL_LC_HEALTH_LOAD;

	@Column(name="POL_FC_DEPOSIT_AMOUNT")
	private Double POL_FC_DEPOSIT_AMOUNT;

	@Column(name="POL_LC_DEPOSIT_AMOUNT")
	private Double POL_LC_DEPOSIT_AMOUNT;

	@Column(name="POL_MODE_OF_PYMT")
	private String POL_MODE_OF_PYMT;

	@Column(name="POL_MODE_OF_PYMT_RATE")
	private Double POL_MODE_OF_PYMT_RATE;

	@Column(name="POL_BNFCY_DTLS")
	private String POL_BNFCY_DTLS;

	@Column(name="POL_BNFCY_DTLS_2")
	private String POL_BNFCY_DTLS_2;

	@Column(name="POL_REMARKS")
	private String POL_REMARKS;

	@Column(name="POL_FIRST_INST_DT")
	private Date POL_FIRST_INST_DT;

	@Column(name="POL_LAST_INST_DT")
	private Date POL_LAST_INST_DT;

	@Column(name="POL_NO_YRS_PREM_PAID")
	private Double POL_NO_YRS_PREM_PAID;

	@Column(name="POL_FACIN_YN")
	private String POL_FACIN_YN;

	@Column(name="POL_FAC_YN")
	private String POL_FAC_YN;

	@Column(name="POL_COINS_YN")
	private String POL_COINS_YN;

	@Column(name="POL_RI_CLOSE_FLAG")
	private String POL_RI_CLOSE_FLAG;

	@Column(name="POL_FAC_CLOSE_FLAG")
	private String POL_FAC_CLOSE_FLAG;

	@Column(name="POL_STATUS")
	private String POL_STATUS = "N";

	@Column(name="POL_APPRV_STATUS")
	private String POL_APPRV_STATUS = "N";

	@Column(name="POL_APPRV_DT")
	private Date POL_APPRV_DT;

	@Column(name="POL_END_TYPE")
	private String POL_END_TYPE;

	@Column(name="POL_END_CODE")
	private String POL_END_CODE;

	@Column(name="POL_END_NO_IDX")
	private Integer POL_END_NO_IDX;

	@Column(name="POL_END_DT")
	private Date POL_END_DT;

	@Column(name="POL_END_NO")
	private String POL_END_NO;

	@Column(name="POL_END_EFF_FROM_DT")
	private Date POL_END_EFF_FROM_DT;

	@Column(name="POL_END_EFF_TO_DT")
	private Date POL_END_EFF_TO_DT;

	@Column(name="POL_END_DESC")
	private String POL_END_DESC;

	@Column(name="POL_CR_DT")
	private Date POL_CR_DT;

	@Column(name="POL_CR_UID")
	private String POL_CR_UID;

	@Column(name="POL_UPD_DT")
	private Date POL_UPD_DT;

	@Column(name="POL_UPD_UID")
	private String POL_UPD_UID;

	@Column(name="POL_PREM_WAIVE_YN")
	private String POL_PREM_WAIVE_YN;

	@Column(name="POL_CANCEL_DT")
	private Date POL_CANCEL_DT;

	@Column(name="POL_PAIDUP_DT")
	private Date POL_PAIDUP_DT;

	@Column(name="POL_CASH_YN")
	private String POL_CASH_YN;

	@Column(name="POL_FC_AMAN_PREM")
	private Double POL_FC_AMAN_PREM;

	@Column(name="POL_LC_AMAN_PREM")
	private Double POL_LC_AMAN_PREM;

	@Column(name="POL_FC_SENABEL_PREM")
	private Double POL_FC_SENABEL_PREM;

	@Column(name="POL_LC_SENABEL_PREM")
	private Double POL_LC_SENABEL_PREM;

	@Column(name="POL_CREDIT_YN")
	private String POL_CREDIT_YN;

	@Column(name="POL_CREDIT_DISCOUNT_PERC")
	private Double POL_CREDIT_DISCOUNT_PERC;

	@Column(name="POL_LOAD_PERC")
	private Double POL_LOAD_PERC;

	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;

	@Column(name="POL_DS_TYPE")
	private String POL_DS_TYPE;

	@Column(name="POL_PROFIT_RATE")
	private Double POL_PROFIT_RATE;

	@Column(name="POL_FC_PROFIT")
	private Double POL_FC_PROFIT;

	@Column(name="POL_LC_PROFIT")
	private Double POL_LC_PROFIT;

	@Column(name="POL_JOINT_LIFE_YN")
	private String POL_JOINT_LIFE_YN;

	@Column(name="POL_JOINT_LIFE_AGE")
	private Integer POL_JOINT_LIFE_AGE;

	@Column(name="POL_PREM_PAY_YRS")
	private Integer POL_PREM_PAY_YRS;

	@Column(name="POL_EMPLOYER_CODE")
	private String POL_EMPLOYER_CODE;

	@Column(name="POL_TARIFF_TERM_FLAG")
	private String POL_TARIFF_TERM_FLAG;

	@Column(name="POL_RATE_APPLIED_ON")
	private String POL_RATE_APPLIED_ON;

	@Column(name="POL_EXC_INT_PERC")
	private Double POL_EXC_INT_PERC;

	@Column(name="POL_FC_EXC_INT_AMT")
	private Double POL_FC_EXC_INT_AMT;

	@Column(name="POL_LC_EXC_INT_AMT")
	private Double POL_LC_EXC_INT_AMT;

	@Column(name="POL_HOLD_YN")
	private String POL_HOLD_YN;

	@Column(name="POL_STAFF_YN")
	private String POL_STAFF_YN;

	@Column(name="POL_STAFF_CCLASS_CODE")
	private String POL_STAFF_CCLASS_CODE;

	@Column(name="POL_FC_DISC_AMT")
	private Double POL_FC_DISC_AMT;

	@Column(name="POL_LC_DISC_AMT")
	private Double POL_LC_DISC_AMT;

	@Column(name="POL_STD_RISK_YN")
	private String POL_STD_RISK_YN;

	@Column(name="POL_CQS_YN")
	private String POL_CQS_YN;

	@Column(name="POL_CQS_PERC")
	private Double POL_CQS_PERC;

	@Column(name="POL_FC_FIRST_PREM")
	private Double POL_FC_FIRST_PREM;

	@Column(name="POL_LC_FIRST_PREM")
	private Double POL_LC_FIRST_PREM;

	@Column(name="POL_ORG_FC_SUM_ASSURED")
	private Double POL_ORG_FC_SUM_ASSURED;

	@Column(name="POL_ORG_LC_SUM_ASSURED")
	private Double POL_ORG_LC_SUM_ASSURED;

	@Column(name="POL_ORG_FC_CURR_SA")
	private Double POL_ORG_FC_CURR_SA;

	@Column(name="POL_ORG_LC_CURR_SA")
	private Double POL_ORG_LC_CURR_SA;

	@Column(name="POL_ORG_FC_BASIC_PREM")
	private Double POL_ORG_FC_BASIC_PREM;

	@Column(name="POL_ORG_LC_BASIC_PREM")
	private Double POL_ORG_LC_BASIC_PREM;

	@Column(name="POL_ORG_FC_ADDL_PREM")
	private Double POL_ORG_FC_ADDL_PREM;

	@Column(name="POL_ORG_LC_ADDL_PREM")
	private Double POL_ORG_LC_ADDL_PREM;

	@Column(name="POL_ORG_FC_FIRST_PREM")
	private Double POL_ORG_FC_FIRST_PREM;

	@Column(name="POL_ORG_LC_FIRST_PREM")
	private Double POL_ORG_LC_FIRST_PREM;

	@Column(name="POL_ORG_FC_DISC_AMT")
	private Double POL_ORG_FC_DISC_AMT;

	@Column(name="POL_ORG_LC_DISC_AMT")
	private Double POL_ORG_LC_DISC_AMT;

	@Column(name="POL_ORG_PREM_PAY_YRS")
	private Double POL_ORG_PREM_PAY_YRS;

	@Column(name="POL_ORG_PERIOD")
	private Integer POL_ORG_PERIOD;

	@Column(name="POL_ORG_BASIC_RATE")
	private Double POL_ORG_BASIC_RATE;

	@Column(name="POL_BASIC_RATE_PER")
	private Double POL_BASIC_RATE_PER;

	@Column(name="POL_RES_PHONE_NO")
	private String POL_RES_PHONE_NO;

	@Column(name="POL_RES_AREA_CODE")
	private String POL_RES_AREA_CODE;

	@Column(name="POL_OFF_PHONE_NO")
	private String POL_OFF_PHONE_NO;

	@Column(name="POL_OFF_AREA_CODE")
	private String POL_OFF_AREA_CODE;

	@Column(name="POL_FAX_NO")
	private String POL_FAX_NO;
 
	@Column(name="POL_FAX_AREA_CODE")
	private String POL_FAX_AREA_CODE;

	@Column(name="POL_MASTER_POL_NO")
	private String POL_MASTER_POL_NO;

	@Column(name="POL_ADDL_STATUS")
	private String POL_ADDL_STATUS;

	@Column(name="POL_BANK_REF_NO")
	private String POL_BANK_REF_NO;

	@Column(name="POL_PROP_REF_NO")
	private String POL_PROP_REF_NO;

	@Column(name="POL_INCORPORATED_YN")
	private String POL_INCORPORATED_YN;

	@Column(name="POL_NET_PREM_YN")
	private String POL_NET_PREM_YN;

	@Column(name="POL_CREDIT_INT_RATE")
	private Double POL_CREDIT_INT_RATE=0.00;

	@Column(name="POL_DEFER_PRD")
	private Double POL_DEFER_PRD;

	@Column(name="POL_MODE_OF_CALC")
	private String POL_MODE_OF_CALC;
	

	@Column(name="POL_PYMT_TYPE")
	private String POL_PYMT_TYPE;

	@Column(name="POL_GRANTEE_TYPE")
	private String POL_GRANTEE_TYPE;

	@Column(name="POL_GRANTEE_NAME")
	private String POL_GRANTEE_NAME;

	@Column(name="POL_BANK_BRANCH_NAME")
	private String POL_BANK_BRANCH_NAME;

	@Column(name="POL_AGENT_REF_CODE")
	private String POL_AGENT_REF_CODE;

	@Column(name="POL_FC_BANK_ALLOC_AMT")
	private Double POL_FC_BANK_ALLOC_AMT;

	@Column(name="POL_LC_BANK_ALLOC_AMT")
	private Double POL_LC_BANK_ALLOC_AMT;

	@Column(name="POL_FC_CLIENT_ALLOC_AMT")
	private Double POL_FC_CLIENT_ALLOC_AMT;

	@Column(name="POL_LC_CLIENT_ALLOC_AMT")
	private Double POL_LC_CLIENT_ALLOC_AMT;

	@Column(name="POL_FC_TOT_SA")
	private Double POL_FC_TOT_SA;

	@Column(name="POL_LC_TOT_SA")
	private Double POL_LC_TOT_SA;

	@Column(name="POL_FC_NET_PREM")
	private Double POL_FC_NET_PREM;

	@Column(name="POL_LC_NET_PREM")
	private Double POL_LC_NET_PREM;

	@Column(name="POL_FC_PRE_TPD_BNF")
	private Double POL_FC_PRE_TPD_BNF;

	@Column(name="POL_LC_PRE_TPD_BNF")
	private Double POL_LC_PRE_TPD_BNF;

	@Column(name="POL_FRZ_FLAG")
	private String POL_FRZ_FLAG;

	@Column(name="POL_ORG_FC_BANK_ALLOC_AMT")
	private Double POL_ORG_FC_BANK_ALLOC_AMT;

	@Column(name="POL_ORG_LC_BANK_ALLOC_AMT")
	private Double POL_ORG_LC_BANK_ALLOC_AMT;

	@Column(name="POL_ORG_FC_CLIENT_ALLOC_AMT")
	private Double POL_ORG_FC_CLIENT_ALLOC_AMT;

	@Column(name="POL_ORG_LC_CLIENT_ALLOC_AMT")
	private Double POL_ORG_LC_CLIENT_ALLOC_AMT;

	@Column(name="POL_ORG_FC_TOT_SA")
	private Double POL_ORG_FC_TOT_SA;

	@Column(name="POL_ORG_LC_TOT_SA")
	private Double POL_ORG_LC_TOT_SA;

	@Column(name="POL_ORG_FC_NET_PREM")
	private Double POL_ORG_FC_NET_PREM;

	@Column(name="POL_ORG_LC_NET_PREM")
	private Double POL_ORG_LC_NET_PREM;

	@Column(name="POL_ORG_FC_PRE_TPD_BNF")
	private Double POL_ORG_FC_PRE_TPD_BNF;

	@Column(name="POL_ORG_LC_PRE_TPD_BNF")
	private Double POL_ORG_LC_PRE_TPD_BNF;

	@Column(name="POL_NO_OF_INST")
	private Integer POL_NO_OF_INST;

	@Column(name="POL_ORG_NO_OF_INST")
	private Integer POL_ORG_NO_OF_INST;

	@Column(name="POL_DEVELOPER_CODE")
	private String POL_DEVELOPER_CODE;

	@Column(name="POL_PROJECT_CODE")
	private String POL_PROJECT_CODE;

	@Column(name="POL_HOME_OWNER_FLAG")
	private String POL_HOME_OWNER_FLAG;

	@Column(name="POL_FLEX_01")
	private String POL_FLEX_01;

	@Column(name="POL_FLEX_02")
	private String POL_FLEX_02;

	@Column(name="POL_FLEX_03")
	private String POL_FLEX_03;

	@Column(name="POL_FLEX_04")
	private String POL_FLEX_04;

	@Column(name="POL_FLEX_05")
	private String POL_FLEX_05;
	
	@Column(name="POL_FLEX_20")
	private String POL_FLEX_20;

	@Column(name="POL_PROP_RECV_DT")
	private Date POL_PROP_RECV_DT;

	@Column(name="POL_PROP_STAMP_DT")
	private Date POL_PROP_STAMP_DT;

	@Column(name="POL_PROP_DECL_DT")
	private Date POL_PROP_DECL_DT;

	@Column(name="POL_FC_TOP_UP_AMT")
	private Double POL_FC_TOP_UP_AMT;

	@Column(name="POL_LC_TOP_UP_AMT")
	private Double POL_LC_TOP_UP_AMT;

	@Column(name="POL_ORG_FC_TOP_UP_AMT")
	private Double POL_ORG_FC_TOP_UP_AMT;

	@Column(name="POL_ORG_LC_TOP_UP_AMT")
	private Double POL_ORG_LC_TOP_UP_AMT;

	@Column(name="POL_INTRODUCER_REF_ID1")
	private String POL_INTRODUCER_REF_ID1;

	@Column(name="POL_PROP_QUOT_FLAG")
	private String POL_PROP_QUOT_FLAG;

	@Column(name="POL_FC_PAYOR_PREM")
	private Double POL_FC_PAYOR_PREM;

	@Column(name="POL_LC_PAYOR_PREM")
	private Double POL_LC_PAYOR_PREM;

	@Column(name="POL_FC_PAYEE_PREM")
	private Double POL_FC_PAYEE_PREM;

	@Column(name="POL_LC_PAYEE_PREM")
	private Double POL_LC_PAYEE_PREM;

	@Column(name="POL_ORG_FC_PAYOR_PREM")
	private Double POL_ORG_FC_PAYOR_PREM;

	@Column(name="POL_ORG_LC_PAYOR_PREM")
	private Double POL_ORG_LC_PAYOR_PREM;

	@Column(name="POL_ORG_FC_PAYEE_PREM")
	private Double POL_ORG_FC_PAYEE_PREM;

	@Column(name="POL_ORG_LC_PAYEE_PREM")
	private Double POL_ORG_LC_PAYEE_PREM;

	@Column(name="POL_SRC_OF_BUS")
	private String POL_SRC_OF_BUS;

	@Column(name="POL_POSTPONE_DAYS")
	private Double POL_POSTPONE_DAYS;

	@Column(name="POL_POSTPONE_EXPIRY_DT")
	private Date POL_POSTPONE_EXPIRY_DT;

	@Column(name="POL_ORG_PROP_RECV_YN")
	private String POL_ORG_PROP_RECV_YN;

	@Column(name="POL_FAC_BASIS")
	private String POL_FAC_BASIS;

	@Column(name="POL_RI_POOL_CODE")
	private String POL_RI_POOL_CODE;

	@Column(name="POL_TRAN_DT")
	private Date POL_TRAN_DT;

	@Column(name="POL_CONVERT_YN")
	private String POL_CONVERT_YN;

	@Column(name="POL_ASSRD_REF_ID1")
	private String POL_ASSRD_REF_ID1;

	@Column(name="POL_ASSRD_REF_ID2")
	private String POL_ASSRD_REF_ID2;

	@Column(name="POL_APPRV_UID")
	private String POL_APPRV_UID;

	@Column(name="POL_FLEX_06")
	private String POL_FLEX_06;

	@Column(name="POL_FLEX_07")
	private String POL_FLEX_07;

	@Column(name="POL_FLEX_08")
	private String POL_FLEX_08;

	@Column(name="POL_FLEX_09")
	private String POL_FLEX_09;

	@Column(name="POL_FLEX_10")
	private String POL_FLEX_10;

	@Column(name="POL_LC_MODAL_PREM")
	private Double POL_LC_MODAL_PREM;

	@Column(name="POL_FC_MODAL_PREM")
	private Double POL_FC_MODAL_PREM;

	@Column(name="POL_ORG_FC_MODAL_PREM")
	private Double POL_ORG_FC_MODAL_PREM;

	@Column(name="POL_ORG_LC_MODAL_PREM")
	private Double POL_ORG_LC_MODAL_PREM;

	@Column(name="POL_CITY_CODE")
	private String POL_CITY_CODE;

	@Column(name="POL_STATE_CODE")
	private String POL_STATE_CODE;

	@Column(name="POL_COUNT_CODE")
	private String POL_COUNT_CODE;

	@Column(name="POL_MOBILE_NO")
	private String POL_MOBILE_NO;

	@Column(name="POL_FORM_NO")
	private String POL_FORM_NO;

	@Column(name="POL_CLM_ADDL_STATUS")
	private String POL_CLM_ADDL_STATUS;

	@Column(name="POL_LINK_SYS_ID")
	private Double POL_LINK_SYS_ID;

	@Column(name="POL_PROP_END_TYPE")
	private String POL_PROP_END_TYPE;

	@Column(name="POL_PROP_END_CODE")
	private String POL_PROP_END_CODE;

	@Column(name="POL_MED_FEE_RECOVER_YN")
	private String POL_MED_FEE_RECOVER_YN;

	@Column(name="POL_END_APPRV_DT")
	private Date POL_END_APPRV_DT;

	@Column(name="POL_NO_OF_UNIT")
	private Double POL_NO_OF_UNIT;

	@Column(name="POL_ORG_NO_OF_UNIT")
	private Double POL_ORG_NO_OF_UNIT;

	@Column(name="POL_FC_NETT_PREM")
	private Double POL_FC_NETT_PREM;

	@Column(name="POL_LC_NETT_PREM")
	private Double POL_LC_NETT_PREM;

	@Column(name="POL_ORG_FC_NETT_PREM")
	private Double POL_ORG_FC_NETT_PREM;

	@Column(name="POL_ORG_LC_NETT_PREM")
	private Double POL_ORG_LC_NETT_PREM;

	@Column(name="POL_LC_MIN_PREM")
	private Double POL_LC_MIN_PREM;

	@Column(name="POL_FC_MIN_PREM")
	private Double POL_FC_MIN_PREM;

	@Column(name="POL_FC_EXTRA_PREM")
	private Double POL_FC_EXTRA_PREM;

	@Column(name="POL_LC_EXTRA_PREM")
	private Double POL_LC_EXTRA_PREM;

	@Column(name="POL_ORG_LC_EXTRA_PREM")
	private Double POL_ORG_LC_EXTRA_PREM;

	@Column(name="POL_ORG_FC_MIN_PREM")
	private Double POL_ORG_FC_MIN_PREM;

	@Column(name="POL_ORG_LC_MIN_PREM")
	private Double POL_ORG_LC_MIN_PREM;

	@Column(name="POL_ORG_FC_EXTRA_PREM")
	private Double POL_ORG_FC_EXTRA_PREM;

	@Column(name="POL_SUB_PLAN_CODE")
	private String POL_SUB_PLAN_CODE;

	@Column(name="POL_ORG_SUB_PLAN_CODE")
	private String POL_ORG_SUB_PLAN_CODE;

//	@Column(name="POL_PROD_GROUP_CODE")
//	private String POL_PROD_GROUP_CODE;
	
	@Column(name="POL_NEW_FC_SA")
	private Double POL_NEW_FC_SA;

	@Column(name="POL_NEW_LC_SA")
	private Double POL_NEW_LC_SA;

	@Column(name="POL_ORG_NEW_FC_SA")
	private Double POL_ORG_NEW_FC_SA;

	@Column(name="POL_ORG_NEW_LC_SA")
	private Double POL_ORG_NEW_LC_SA;
	
	@Column(name="POL_PAYOR_SDCODE")
	private String POL_PAYOR_SDCODE;

	@Column(name="POL_ENROL_YN")
	private String POL_ENROL_YN;

	@Column(name="POL_CONT_AD_BANK_CODE")
	private String POL_CONT_AD_BANK_CODE;

	@Column(name="POL_CONT_AD_ACC_NO")
	private String POL_CONT_AD_ACC_NO;
 
	@Column(name="POL_ORG_FC_MON_ANNU_AMT")
	private Double POL_ORG_FC_MON_ANNU_AMT;

	@Column(name="POL_ORG_LC_MON_ANNU_AMT")
	private Double POL_ORG_LC_MON_ANNU_AMT;
	
	@Column(name="POL_PROD_GROUP_CODE")
	private String POL_PROD_GROUP_CODE;
	
	
	/*Added by Gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan on 06/01/17*/
	
	@Column(name="POL_APL_YN")
	private String POL_APL_YN;
	
	/*End*/

	@Column(name="POL_FLEX_14")
	private String POL_FLEX_14;

	@Column(name="POL_FLEX_17")
	private String POL_ESC_YN;
	
	@Column(name="POL_FLEX_18")
	private Integer POL_FLEX_18;
	
	@Column(name="POL_FLEX_19")
	private Integer POL_CVR_ESC_PERC;
	
	@Column(name="POL_PREM_WAIVE_INT_RATE")
	private Integer POL_PREM_WAIVE_INT_RATE;
	//Added by Sivarajan on 12-08-2018 for KICLIFEQC-1761314
	@Column(name="POL_END_EFF_TYPE")
	private String POL_END_EFF_TYPE;
	
	public String getPOL_END_EFF_TYPE() {
		return POL_END_EFF_TYPE;
	}
	public void setPOL_END_EFF_TYPE(String pOL_END_EFF_TYPE) {
		POL_END_EFF_TYPE = pOL_END_EFF_TYPE;
	}
	
	//END
	/*Added by Dhinesh 7.6.2016*/
	
	private String POL_FC_SUM_ASSURED_STR;
	private String POL_BASIC_RATE_STR;
	private String POL_FC_BASIC_PREM_STR;
	
	
	 

	
	/*End*/
	
	
	
	/*Added By Raja 29.6.2016*/
	
	private boolean ASSURED_NAME_FLAG;
	
	public boolean isASSURED_NAME_FLAG() {
		return ASSURED_NAME_FLAG;
	}
	public void setASSURED_NAME_FLAG(boolean aSSURED_NAME_FLAG) {
		ASSURED_NAME_FLAG = aSSURED_NAME_FLAG;
	}
	/*End*/
	public String getPOL_FC_SUM_ASSURED_STR() {
		return POL_FC_SUM_ASSURED_STR;
	}
	public void setPOL_FC_SUM_ASSURED_STR(String pOL_FC_SUM_ASSURED_STR) {
		POL_FC_SUM_ASSURED_STR = pOL_FC_SUM_ASSURED_STR;
	}
	public String getPOL_BASIC_RATE_STR() {
		return POL_BASIC_RATE_STR;
	}
	public void setPOL_BASIC_RATE_STR(String pOL_BASIC_RATE_STR) {
		POL_BASIC_RATE_STR = pOL_BASIC_RATE_STR;
	}
	public String getPOL_FC_BASIC_PREM_STR() {
		return POL_FC_BASIC_PREM_STR;
	}
	public void setPOL_FC_BASIC_PREM_STR(String pOL_FC_BASIC_PREM_STR) {
		POL_FC_BASIC_PREM_STR = pOL_FC_BASIC_PREM_STR;
	}

	private String summaryDate;
	private String UI_M_POL_END_CODE_DESC;
	private Double UI_M_PAY_PERIOD;
	private Double UI_M_PAY_YEARS;
	private Double UI_M_LC_SA;
	private Double UI_M_FC_SA;
	private String UI_M_PROD_DESC;
	private String UI_M_POL_PROD_GROUP_CODE;
	private String UI_M_POL_PLAN_DESC;
	private Integer UI_M_MAT_AGE;
	private Double UI_M_POL_LC_SA1;
	private Double UI_M_POL_LC_TOT_PREM1;
	private Double UI_M_POL_LC_TOT_LOADING1;
	private Double UI_M_POL_LC_TOT_DISCOUNT1;
	private Double UI_M_LC_PCHARGES_BORNE_CUST1;
	private Double UI_M_POL_LC_NET_PREM1;
	private Double UI_M_POL_MODE_OF_PYMT_RATE1;
	private Double UI_M_POL_LC_MOP1;
	private Double UI_M_POL_LC_GR_ANN_PREM1;
	private Double UI_M_POL_INST_LC_PREM1;
	private Double UI_M_LC_SCHARGES_BORNE_CUST1;
	private String UI_M_POL_RES_AREA_CODE_DESC;
	private String UI_M_POL_CITY_NAME;
	private String UI_M_POL_STATE_NAME;
	private String UI_M_POL_COUNT_NAME;
	private String UI_M_POSTAL_NAME;
	private String UI_M_POL_ADDL_STATUS_DESC;
	private Double UI_M_POL_FC_SA;
	private Double UI_M_POL_LC_SA;
	private String UI_M_PROJECT_CODE_DESC;
	private String UI_M_DEVELOPER_CODE_DESC;
	private String UI_M_PAYOR_CONT_NAME;
	private String UI_M_POL_CUST_DESC;
	private String UI_M_POL_SRC_OF_BUS_DESC;
	private Double UI_M_FC_DEATH_LOAD;
	private Double UI_M_LC_DEATH_LOAD;
	private Double UI_M_POL_FC_TOT_PREM;
	private Double UI_M_POL_LC_TOT_PREM;
	private Double UI_M_POL_FC_PREM;
	private Double UI_M_POL_LC_PREM;
	private Double UI_M_FC_TPD_LOAD;
	private Double UI_M_LC_TPD_LOAD;
	private String UI_M_BRANCH_CODE_DESC;
	private String UI_M_POL_SUB_PLAN_CODE_DESC;
	private Double UI_M_POL_FC_TOT_LOADING;
	private Double UI_M_POL_LC_TOT_LOADING;
	private Double UI_M_FC_MED_LOAD;
	private Double UI_M_LC_MED_LOAD;
	private String UI_M_POL_INTRODUCER_REF_ID1_DESC;
	private Double UI_M_POL_FC_TOT_DISCOUNT;
	private Double UI_M_POL_LC_TOT_DISCOUNT;
	private Double UI_M_FC_OCC_LOAD;
	private Double UI_M_LC_OCC_LOAD;
	private String UI_M_CONT_NAME;
	private String UI_M_POL_SA_CURR_DESC;
	private String UI_M_POL_DIVN_DESC;
	private Double UI_M_FC_PCHARGES_BORNE_CUST;
	private Double UI_M_LC_PCHARGES_BORNE_CUST;
	private Double UI_M_FC_GROSS_CONT;
	private Double UI_M_LC_GROSS_CONT;
	private String UI_M_POL_CUST_CURR_DESC;
	private Double UI_M_POL_FC_NET_PREM;
	private Double UI_M_POL_LC_NET_PREM;
	private Double UI_M_FC_BROK_COMM;
	private Double UI_M_LC_BROK_COMM;
	private String UI_M_CCLAS_CLASS_DESC;
	private String UI_M_POL_DEPT_DESC;
	private Double UI_M_POL_MODE_OF_PYMT_RATE;
	private Double UI_M_POL_FC_MOP;
	private Double UI_M_POL_LC_MOP;
	private Double UI_M_FC_CHARGE;
	private Double UI_M_LC_CHARGE;
	private String UI_M_POL_RI_POOL_CODE_DESC;
	private Double UI_M_POL_FC_GR_ANN_PREM;
	private Double UI_M_POL_LC_GR_ANN_PREM;
	private Double UI_M_FC_PCHARGES_BORNE_COMP;
	private Double UI_M_LC_PCHARGES_BORNE_COMP;
	private Double UI_M_FC_INST_PREM;
	private Double UI_M_LC_INST_PREM;
	private String UI_M_POL_CLASS_DESC;
	private Double UI_M_POL_INST_FC_PREM;
	private Double UI_M_POL_INST_LC_PREM;
	/*
	 * modified by Ameen to set 16 digit acc. no.
	 * private Integer UI_M_POL_CONT_AD_ACC_NO;
	 * private Integer UI_M_POL_CONT_AD_ACC_NO_1;*/
	private Long UI_M_POL_CONT_AD_ACC_NO;
	private Long UI_M_POL_CONT_AD_ACC_NO_1;	
	
	private Double POL_BASIC_RATE1;
	private Double POL_LC_BASIC_PREM1;
	private Double POL_LC_ADDL_PREM1;
	private Double POL_LC_DISC_AMT1;
	private Double POL_LC_FIRST_PREM1;
	private Double PAYOR_TAB;
	
	private String UI_M_BANK_CODE_DESC;
	private String UI_M_SURR_MAT;
	private Double UI_M_FC_SCHARGES_BORNE_CUST;
	private Double UI_M_LC_SCHARGES_BORNE_CUST;
	private Double UI_M_FC_SCHARGES_BORNE_COMP;
	private Double UI_M_LC_SCHARGES_BORNE_COMP;
	
	private Double UI_M_POL_FC_TOT_CHARGE;
	private Double UI_M_POL_LC_TOT_CHARGE;
	private Double UI_M_POL_LC_PREM_PAYABLE;
	private Double UI_M_POL_FC_PREM_PAYABLE;
	private String UI_M_PROD_APL_YN;//This flag set the APL flag from product setup.
	
	
	@Column(name="POL_FLEX_11")
	private String POL_FLEX_11;
	
	//ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND DIRECT CREDIT. 

	@Column(name="POL_MICR_CODE")
	private Long POL_MICR_CODE;
	
	@Column(name="POL_CUST_BANK_CODE")
	/*Modified by ganesh o 06-11-2017 as suggested by ajoy */
	/*private Long POL_CUST_BANK_CODE;*/
	private String POL_CUST_BANK_CODE;
	/*end*/
	private String UI_M_CBAD_ACNT_NO;
	
	private String UI_M_CITY_CODE;
	
	private String UI_M_CITY_CODE_DESC;
	
	private String UI_M_BANK_CODE;
	
	private String UI_M_BANK_CODE_DESC_1;
	
	private String UI_M_BRANCH_CODE;
	
	private String UI_M_BRANCH_CODE_DESC_1;
	
	
//ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND DIRECT CREDIT. 
	
	
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
	public void setUI_M_FC_PCHARGES_BORNE_COMP(Double UI_M_FC_PCHARGES_BORNE_COMP) {
		this.UI_M_FC_PCHARGES_BORNE_COMP = UI_M_FC_PCHARGES_BORNE_COMP;
	}
	public Double getUI_M_FC_PCHARGES_BORNE_COMP() {
		 return UI_M_FC_PCHARGES_BORNE_COMP;
	}
	public void setPOL_STAFF_CCLASS_CODE(String POL_STAFF_CCLASS_CODE) {
		this.POL_STAFF_CCLASS_CODE = POL_STAFF_CCLASS_CODE;
	}
	public String getPOL_STAFF_CCLASS_CODE() {
		 return POL_STAFF_CCLASS_CODE;
	}
	public void setUI_M_POL_FC_TOT_LOADING(Double UI_M_POL_FC_TOT_LOADING) {
		this.UI_M_POL_FC_TOT_LOADING = UI_M_POL_FC_TOT_LOADING;
	}
	public Double getUI_M_POL_FC_TOT_LOADING() {
		 return UI_M_POL_FC_TOT_LOADING;
	}
	public void setUI_M_MAT_AGE(Integer UI_M_MAT_AGE) {
		this.UI_M_MAT_AGE = UI_M_MAT_AGE;
	}
	public Integer getUI_M_MAT_AGE() {
		 return UI_M_MAT_AGE;
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
	public void setUI_M_PAY_YEARS(Double UI_M_PAY_YEARS) {
		this.UI_M_PAY_YEARS = UI_M_PAY_YEARS;
	}
	public Double getUI_M_PAY_YEARS() {
		 return UI_M_PAY_YEARS;
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
	public void setUI_M_POL_LC_TOT_DISCOUNT(Double UI_M_POL_LC_TOT_DISCOUNT) {
		this.UI_M_POL_LC_TOT_DISCOUNT = UI_M_POL_LC_TOT_DISCOUNT;
	}
	public Double getUI_M_POL_LC_TOT_DISCOUNT() {
		 return UI_M_POL_LC_TOT_DISCOUNT;
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
	public void setUI_M_LC_PCHARGES_BORNE_CUST(Double UI_M_LC_PCHARGES_BORNE_CUST) {
		this.UI_M_LC_PCHARGES_BORNE_CUST = UI_M_LC_PCHARGES_BORNE_CUST;
	}
	public Double getUI_M_LC_PCHARGES_BORNE_CUST() {
		 return UI_M_LC_PCHARGES_BORNE_CUST;
	}
	public void setUI_M_POL_LC_NET_PREM(Double UI_M_POL_LC_NET_PREM) {
		this.UI_M_POL_LC_NET_PREM = UI_M_POL_LC_NET_PREM;
	}
	public Double getUI_M_POL_LC_NET_PREM() {
		 return UI_M_POL_LC_NET_PREM;
	}
	public void setPOL_ORG_LC_BASIC_PREM(Double POL_ORG_LC_BASIC_PREM) {
		this.POL_ORG_LC_BASIC_PREM = POL_ORG_LC_BASIC_PREM;
	}
	public Double getPOL_ORG_LC_BASIC_PREM() {
		 return POL_ORG_LC_BASIC_PREM;
	}
	public void setUI_M_CONT_NAME(String UI_M_CONT_NAME) {
		this.UI_M_CONT_NAME = UI_M_CONT_NAME;
	}
	public String getUI_M_CONT_NAME() {
		 return UI_M_CONT_NAME;
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
	public void setPOL_PREM_PAY_YRS(Integer POL_PREM_PAY_YRS) {
		this.POL_PREM_PAY_YRS = POL_PREM_PAY_YRS;
	}
	public Integer getPOL_PREM_PAY_YRS() {
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
	public void setUI_M_FC_INST_PREM(Double UI_M_FC_INST_PREM) {
		this.UI_M_FC_INST_PREM = UI_M_FC_INST_PREM;
	}
	public Double getUI_M_FC_INST_PREM() {
		 return UI_M_FC_INST_PREM;
	}
	public void setUI_M_LC_GROSS_CONT(Double UI_M_LC_GROSS_CONT) {
		this.UI_M_LC_GROSS_CONT = UI_M_LC_GROSS_CONT;
	}
	public Double getUI_M_LC_GROSS_CONT() {
		 return UI_M_LC_GROSS_CONT;
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
	public void setUI_M_LC_CHARGE(Double UI_M_LC_CHARGE) {
		this.UI_M_LC_CHARGE = UI_M_LC_CHARGE;
	}
	public Double getUI_M_LC_CHARGE() {
		 return UI_M_LC_CHARGE;
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
	public void setPOL_JOINT_LIFE_AGE(Integer POL_JOINT_LIFE_AGE) {
		this.POL_JOINT_LIFE_AGE = POL_JOINT_LIFE_AGE;
	}
	public Integer getPOL_JOINT_LIFE_AGE() {
		 return POL_JOINT_LIFE_AGE;
	}
	public void setUI_M_FC_PCHARGES_BORNE_CUST(Double UI_M_FC_PCHARGES_BORNE_CUST) {
		this.UI_M_FC_PCHARGES_BORNE_CUST = UI_M_FC_PCHARGES_BORNE_CUST;
	}
	public Double getUI_M_FC_PCHARGES_BORNE_CUST() {
		 return UI_M_FC_PCHARGES_BORNE_CUST;
	}
	public void setPOL_DEVELOPER_CODE(String POL_DEVELOPER_CODE) {
		this.POL_DEVELOPER_CODE = POL_DEVELOPER_CODE;
	}
	public String getPOL_DEVELOPER_CODE() {
		 return POL_DEVELOPER_CODE;
	}
	public void setUI_M_LC_INST_PREM(Double UI_M_LC_INST_PREM) {
		this.UI_M_LC_INST_PREM = UI_M_LC_INST_PREM;
	}
	public Double getUI_M_LC_INST_PREM() {
		 return UI_M_LC_INST_PREM;
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
	public void setUI_M_LC_SCHARGES_BORNE_CUST(Double UI_M_LC_SCHARGES_BORNE_CUST) {
		this.UI_M_LC_SCHARGES_BORNE_CUST = UI_M_LC_SCHARGES_BORNE_CUST;
	}
	public Double getUI_M_LC_SCHARGES_BORNE_CUST() {
		 return UI_M_LC_SCHARGES_BORNE_CUST;
	}
	public void setUI_M_POL_COUNT_NAME(String UI_M_POL_COUNT_NAME) {
		this.UI_M_POL_COUNT_NAME = UI_M_POL_COUNT_NAME;
	}
	public String getUI_M_POL_COUNT_NAME() {
		 return UI_M_POL_COUNT_NAME;
	}
	public void setPOL_ORG_LC_DISC_AMT(Double POL_ORG_LC_DISC_AMT) {
		this.POL_ORG_LC_DISC_AMT = POL_ORG_LC_DISC_AMT;
	}
	public Double getPOL_ORG_LC_DISC_AMT() {
		 return POL_ORG_LC_DISC_AMT;
	}
	public void setUI_M_POL_INST_FC_PREM(Double UI_M_POL_INST_FC_PREM) {	
		this.UI_M_POL_INST_FC_PREM = UI_M_POL_INST_FC_PREM;
	}
	public Double getUI_M_POL_INST_FC_PREM() {
		 return UI_M_POL_INST_FC_PREM;
	}
	public void setUI_M_FC_MED_LOAD(Double UI_M_FC_MED_LOAD) {
		this.UI_M_FC_MED_LOAD = UI_M_FC_MED_LOAD;
	}
	public Double getUI_M_FC_MED_LOAD() {
		 return UI_M_FC_MED_LOAD;
	}
	public void setUI_M_FC_SA(Double UI_M_FC_SA) {
		this.UI_M_FC_SA = UI_M_FC_SA;
	}
	public Double getUI_M_FC_SA() {
		 return UI_M_FC_SA;
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
	public void setPOL_PERIOD(Integer POL_PERIOD) {
		this.POL_PERIOD = POL_PERIOD;
	}
	public Integer getPOL_PERIOD() {
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
	public void setUI_M_POL_LC_MOP(Double UI_M_POL_LC_MOP) {
		this.UI_M_POL_LC_MOP = UI_M_POL_LC_MOP;
	}
	public Double getUI_M_POL_LC_MOP() {
		 return UI_M_POL_LC_MOP;
	}
	public void setUI_M_POL_LC_GR_ANN_PREM1(Double UI_M_POL_LC_GR_ANN_PREM1) {
		this.UI_M_POL_LC_GR_ANN_PREM1 = UI_M_POL_LC_GR_ANN_PREM1;
	}
	public Double getUI_M_POL_LC_GR_ANN_PREM1() {
		 return UI_M_POL_LC_GR_ANN_PREM1;
	}
	public void setPOL_PROFIT_RATE(Double POL_PROFIT_RATE) {
		this.POL_PROFIT_RATE = POL_PROFIT_RATE;
	}
	public Double getPOL_PROFIT_RATE() {
		 return POL_PROFIT_RATE;
	}
	public void setUI_M_LC_DEATH_LOAD(Double UI_M_LC_DEATH_LOAD) {
		this.UI_M_LC_DEATH_LOAD = UI_M_LC_DEATH_LOAD;
	}
	public Double getUI_M_LC_DEATH_LOAD() {
		 return UI_M_LC_DEATH_LOAD;
	}
	public void setUI_M_POL_INST_LC_PREM(Double UI_M_POL_INST_LC_PREM) {
		this.UI_M_POL_INST_LC_PREM = UI_M_POL_INST_LC_PREM;
	}
	public Double getUI_M_POL_INST_LC_PREM() {
		 return UI_M_POL_INST_LC_PREM;
	}
	public void setUI_M_POL_INST_LC_PREM1(Double UI_M_POL_INST_LC_PREM1) {
		this.UI_M_POL_INST_LC_PREM1 = UI_M_POL_INST_LC_PREM1;
	}
	public Double getUI_M_POL_INST_LC_PREM1() {
		 return UI_M_POL_INST_LC_PREM1;
	}
	public void setPOL_FC_BASIC_PREM(Double POL_FC_BASIC_PREM) {
		this.POL_FC_BASIC_PREM = POL_FC_BASIC_PREM;
	}
	public Double getPOL_FC_BASIC_PREM() {
		 return POL_FC_BASIC_PREM;
	}
	public void setPOL_ORG_FC_CLIENT_ALLOC_AMT(Double POL_ORG_FC_CLIENT_ALLOC_AMT) {
		this.POL_ORG_FC_CLIENT_ALLOC_AMT = POL_ORG_FC_CLIENT_ALLOC_AMT;
	}
	public Double getPOL_ORG_FC_CLIENT_ALLOC_AMT() {
		 return POL_ORG_FC_CLIENT_ALLOC_AMT;
	}
	public void setUI_M_POL_FC_PREM(Double UI_M_POL_FC_PREM) {
		this.UI_M_POL_FC_PREM = UI_M_POL_FC_PREM;
	}
	public Double getUI_M_POL_FC_PREM() {
		 return UI_M_POL_FC_PREM;
	}
	public void setUI_M_POL_LC_TOT_PREM1(Double UI_M_POL_LC_TOT_PREM1) {
		this.UI_M_POL_LC_TOT_PREM1 = UI_M_POL_LC_TOT_PREM1;
	}
	public Double getUI_M_POL_LC_TOT_PREM1() {
		 return UI_M_POL_LC_TOT_PREM1;
	}
	public void setUI_M_POL_LC_PREM(Double UI_M_POL_LC_PREM) {
		this.UI_M_POL_LC_PREM = UI_M_POL_LC_PREM;
	}
	public Double getUI_M_POL_LC_PREM() {
		 return UI_M_POL_LC_PREM;
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
	public void setUI_M_PAYOR_CONT_NAME(String UI_M_PAYOR_CONT_NAME) {
		this.UI_M_PAYOR_CONT_NAME = UI_M_PAYOR_CONT_NAME;
	}
	public String getUI_M_PAYOR_CONT_NAME() {
		 return UI_M_PAYOR_CONT_NAME;
	}
	public void setPOL_LC_NET_PREM(Double POL_LC_NET_PREM) {
		this.POL_LC_NET_PREM = POL_LC_NET_PREM;
	}
	public Double getPOL_LC_NET_PREM() {
		 return POL_LC_NET_PREM;
	}
	public void setUI_M_FC_CHARGE(Double UI_M_FC_CHARGE) {
		this.UI_M_FC_CHARGE = UI_M_FC_CHARGE;
	}
	public Double getUI_M_FC_CHARGE() {
		 return UI_M_FC_CHARGE;
	}
	public void setUI_M_POL_PROD_GROUP_CODE(String UI_M_POL_PROD_GROUP_CODE) {
		this.UI_M_POL_PROD_GROUP_CODE = UI_M_POL_PROD_GROUP_CODE;
	}
	public String getUI_M_POL_PROD_GROUP_CODE() {
		 return UI_M_POL_PROD_GROUP_CODE;
	}
	public void setUI_M_LC_PCHARGES_BORNE_COMP(Double UI_M_LC_PCHARGES_BORNE_COMP) {
		this.UI_M_LC_PCHARGES_BORNE_COMP = UI_M_LC_PCHARGES_BORNE_COMP;
	}
	public Double getUI_M_LC_PCHARGES_BORNE_COMP() {
		 return UI_M_LC_PCHARGES_BORNE_COMP;
	}
	public void setUI_M_LC_SA(Double UI_M_LC_SA) {
		this.UI_M_LC_SA = UI_M_LC_SA;
	}
	public Double getUI_M_LC_SA() {
		 return UI_M_LC_SA;
	}
	 
	public Long getPOL_SYS_ID() {
	    return POL_SYS_ID;
	}
	public void setPOL_SYS_ID(Long pol_sys_id) {
	    POL_SYS_ID = pol_sys_id;
	}
	public Double getPOL_PROP_SYS_ID() {
	    return POL_PROP_SYS_ID;
	}
	public void setPOL_PROP_SYS_ID(Double pol_prop_sys_id) {
	    POL_PROP_SYS_ID = pol_prop_sys_id;
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
	public void setUI_M_POL_CUST_DESC(String UI_M_POL_CUST_DESC) {
		this.UI_M_POL_CUST_DESC = UI_M_POL_CUST_DESC;
	}
	public String getUI_M_POL_CUST_DESC() {
		 return UI_M_POL_CUST_DESC;
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
	public void setUI_M_DEVELOPER_CODE_DESC(String UI_M_DEVELOPER_CODE_DESC) {
		this.UI_M_DEVELOPER_CODE_DESC = UI_M_DEVELOPER_CODE_DESC;
	}
	public String getUI_M_DEVELOPER_CODE_DESC() {
		 return UI_M_DEVELOPER_CODE_DESC;
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
	public void setUI_M_PAY_PERIOD(Double UI_M_PAY_PERIOD) {
		this.UI_M_PAY_PERIOD = UI_M_PAY_PERIOD;
	}
	public Double getUI_M_PAY_PERIOD() {
		 return UI_M_PAY_PERIOD;
	}
	 
	public void setUI_M_LC_BROK_COMM(Double UI_M_LC_BROK_COMM) {
		this.UI_M_LC_BROK_COMM = UI_M_LC_BROK_COMM;
	}
	public Double getUI_M_LC_BROK_COMM() {
		 return UI_M_LC_BROK_COMM;
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
	public void setUI_M_POL_LC_MOP1(Double UI_M_POL_LC_MOP1) {
		this.UI_M_POL_LC_MOP1 = UI_M_POL_LC_MOP1;
	}
	public Double getUI_M_POL_LC_MOP1() {
		 return UI_M_POL_LC_MOP1;
	}
	public void setPOL_ORG_LC_PAYEE_PREM(Double POL_ORG_LC_PAYEE_PREM) {
		this.POL_ORG_LC_PAYEE_PREM = POL_ORG_LC_PAYEE_PREM;
	}
	public Double getPOL_ORG_LC_PAYEE_PREM() {
		 return POL_ORG_LC_PAYEE_PREM;
	}
	public void setUI_M_LC_MED_LOAD(Double UI_M_LC_MED_LOAD) {
		this.UI_M_LC_MED_LOAD = UI_M_LC_MED_LOAD;
	}
	public Double getUI_M_LC_MED_LOAD() {
		 return UI_M_LC_MED_LOAD;
	}
	public void setUI_M_POL_INTRODUCER_REF_ID1_DESC(String UI_M_POL_INTRODUCER_REF_ID1_DESC) {
		this.UI_M_POL_INTRODUCER_REF_ID1_DESC = UI_M_POL_INTRODUCER_REF_ID1_DESC;
	}
	public String getUI_M_POL_INTRODUCER_REF_ID1_DESC() {
		 return UI_M_POL_INTRODUCER_REF_ID1_DESC;
	}
	public void setPOL_END_NO_IDX(Integer POL_END_NO_IDX) {
		this.POL_END_NO_IDX = POL_END_NO_IDX;
	}
	public Integer getPOL_END_NO_IDX() {
		 return POL_END_NO_IDX;
	}
	public void setUI_M_LC_OCC_LOAD(Double UI_M_LC_OCC_LOAD) {
		this.UI_M_LC_OCC_LOAD = UI_M_LC_OCC_LOAD;
	}
	public Double getUI_M_LC_OCC_LOAD() {
		 return UI_M_LC_OCC_LOAD;
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
	public void setUI_M_CCLAS_CLASS_DESC(String UI_M_CCLAS_CLASS_DESC) {
		this.UI_M_CCLAS_CLASS_DESC = UI_M_CCLAS_CLASS_DESC;
	}
	public String getUI_M_CCLAS_CLASS_DESC() {
		 return UI_M_CCLAS_CLASS_DESC;
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
	public void setUI_M_POL_LC_SA1(Double UI_M_POL_LC_SA1) {
		this.UI_M_POL_LC_SA1 = UI_M_POL_LC_SA1;
	}
	public Double getUI_M_POL_LC_SA1() {
		 return UI_M_POL_LC_SA1;
	}
	public void setUI_M_POL_FC_TOT_DISCOUNT(Double UI_M_POL_FC_TOT_DISCOUNT) {
		this.UI_M_POL_FC_TOT_DISCOUNT = UI_M_POL_FC_TOT_DISCOUNT;
	}
	public Double getUI_M_POL_FC_TOT_DISCOUNT() {
		 return UI_M_POL_FC_TOT_DISCOUNT;
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
	public void setUI_M_POL_END_CODE_DESC(String UI_M_POL_END_CODE_DESC) {
		this.UI_M_POL_END_CODE_DESC = UI_M_POL_END_CODE_DESC;
	}
	public String getUI_M_POL_END_CODE_DESC() {
		 return UI_M_POL_END_CODE_DESC;
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
	public void setUI_M_POL_LC_GR_ANN_PREM(Double UI_M_POL_LC_GR_ANN_PREM) {
		this.UI_M_POL_LC_GR_ANN_PREM = UI_M_POL_LC_GR_ANN_PREM;
	}
	public Double getUI_M_POL_LC_GR_ANN_PREM() {
		 return UI_M_POL_LC_GR_ANN_PREM;
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
	/*
	 * modified by Ameen to set 16 digit acc. no.
	 * public void setUI_M_POL_CONT_AD_ACC_NO(Integer UI_M_POL_CONT_AD_ACC_NO) {
		this.UI_M_POL_CONT_AD_ACC_NO = UI_M_POL_CONT_AD_ACC_NO;
	}
	public Integer getUI_M_POL_CONT_AD_ACC_NO() {
		 return UI_M_POL_CONT_AD_ACC_NO;
	}*/
	
	public void setPOL_FC_PAYEE_PREM(Double POL_FC_PAYEE_PREM) {
		this.POL_FC_PAYEE_PREM = POL_FC_PAYEE_PREM;
	}
	public Long getUI_M_POL_CONT_AD_ACC_NO() {
		return UI_M_POL_CONT_AD_ACC_NO;
	}
	public void setUI_M_POL_CONT_AD_ACC_NO(Long uI_M_POL_CONT_AD_ACC_NO) {
		UI_M_POL_CONT_AD_ACC_NO = uI_M_POL_CONT_AD_ACC_NO;
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
	public void setPOL_ORG_LC_CLIENT_ALLOC_AMT(Double POL_ORG_LC_CLIENT_ALLOC_AMT) {
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
	public void setUI_M_LC_SCHARGES_BORNE_CUST1(Double UI_M_LC_SCHARGES_BORNE_CUST1) {
		this.UI_M_LC_SCHARGES_BORNE_CUST1 = UI_M_LC_SCHARGES_BORNE_CUST1;
	}
	public Double getUI_M_LC_SCHARGES_BORNE_CUST1() {
		 return UI_M_LC_SCHARGES_BORNE_CUST1;
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
	public void setUI_M_BRANCH_CODE_DESC(String UI_M_BRANCH_CODE_DESC) {
		this.UI_M_BRANCH_CODE_DESC = UI_M_BRANCH_CODE_DESC;
	}
	public String getUI_M_BRANCH_CODE_DESC() {
		 return UI_M_BRANCH_CODE_DESC;
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
	public void setPOL_NO_OF_INST(Integer POL_NO_OF_INST) {
		this.POL_NO_OF_INST = POL_NO_OF_INST;
	}
	public Integer getPOL_NO_OF_INST() {
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
	public void setUI_M_POL_DEPT_DESC(String UI_M_POL_DEPT_DESC) {
		this.UI_M_POL_DEPT_DESC = UI_M_POL_DEPT_DESC;
	}
	public String getUI_M_POL_DEPT_DESC() {
		 return UI_M_POL_DEPT_DESC;
	}
	public void setUI_M_POL_DIVN_DESC(String UI_M_POL_DIVN_DESC) {
		this.UI_M_POL_DIVN_DESC = UI_M_POL_DIVN_DESC;
	}
	public String getUI_M_POL_DIVN_DESC() {
		 return UI_M_POL_DIVN_DESC;
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
	public void setUI_M_FC_GROSS_CONT(Double UI_M_FC_GROSS_CONT) {
		this.UI_M_FC_GROSS_CONT = UI_M_FC_GROSS_CONT;
	}
	public Double getUI_M_FC_GROSS_CONT() {
		 return UI_M_FC_GROSS_CONT;
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
	public void setUI_M_POL_SUB_PLAN_CODE_DESC(String UI_M_POL_SUB_PLAN_CODE_DESC) {
		this.UI_M_POL_SUB_PLAN_CODE_DESC = UI_M_POL_SUB_PLAN_CODE_DESC;
	}
	public String getUI_M_POL_SUB_PLAN_CODE_DESC() {
		 return UI_M_POL_SUB_PLAN_CODE_DESC;
	}
	public void setUI_M_POSTAL_NAME(String UI_M_POSTAL_NAME) {
		this.UI_M_POSTAL_NAME = UI_M_POSTAL_NAME;
	}
	public String getUI_M_POSTAL_NAME() {
		 return UI_M_POSTAL_NAME;
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
	public void setUI_M_POL_SA_CURR_DESC(String UI_M_POL_SA_CURR_DESC) {
		this.UI_M_POL_SA_CURR_DESC = UI_M_POL_SA_CURR_DESC;
	}
	public String getUI_M_POL_SA_CURR_DESC() {
		 return UI_M_POL_SA_CURR_DESC;
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
	public void setUI_M_POL_MODE_OF_PYMT_RATE1(Double UI_M_POL_MODE_OF_PYMT_RATE1) {
		this.UI_M_POL_MODE_OF_PYMT_RATE1 = UI_M_POL_MODE_OF_PYMT_RATE1;
	}
	public Double getUI_M_POL_MODE_OF_PYMT_RATE1() {
		 return UI_M_POL_MODE_OF_PYMT_RATE1;
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
	public void setUI_M_POL_ADDL_STATUS_DESC(String UI_M_POL_ADDL_STATUS_DESC) {
		this.UI_M_POL_ADDL_STATUS_DESC = UI_M_POL_ADDL_STATUS_DESC;
	}
	public String getUI_M_POL_ADDL_STATUS_DESC() {
		 return UI_M_POL_ADDL_STATUS_DESC;
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
	public void setUI_M_POL_FC_GR_ANN_PREM(Double UI_M_POL_FC_GR_ANN_PREM) {
		this.UI_M_POL_FC_GR_ANN_PREM = UI_M_POL_FC_GR_ANN_PREM;
	}
	public Double getUI_M_POL_FC_GR_ANN_PREM() {
		 return UI_M_POL_FC_GR_ANN_PREM;
	}
	public void setPOL_MOBILE_NO(String POL_MOBILE_NO) {
		this.POL_MOBILE_NO = POL_MOBILE_NO;
	}
	public String getPOL_MOBILE_NO() {
		 return POL_MOBILE_NO;
	}
	public void setUI_M_POL_LC_TOT_PREM(Double UI_M_POL_LC_TOT_PREM) {
		this.UI_M_POL_LC_TOT_PREM = UI_M_POL_LC_TOT_PREM;
	}
	public Double getUI_M_POL_LC_TOT_PREM() {
		 return UI_M_POL_LC_TOT_PREM;
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
	public void setUI_M_POL_LC_SA(Double UI_M_POL_LC_SA) {
		this.UI_M_POL_LC_SA = UI_M_POL_LC_SA;
	}
	public Double getUI_M_POL_LC_SA() {
		 return UI_M_POL_LC_SA;
	}
	public void setPOL_ORG_FC_ADDL_PREM(Double POL_ORG_FC_ADDL_PREM) {
		this.POL_ORG_FC_ADDL_PREM = POL_ORG_FC_ADDL_PREM;
	}
	public Double getPOL_ORG_FC_ADDL_PREM() {
		 return POL_ORG_FC_ADDL_PREM;
	}
	public void setUI_M_POL_FC_TOT_PREM(Double UI_M_POL_FC_TOT_PREM) {
		this.UI_M_POL_FC_TOT_PREM = UI_M_POL_FC_TOT_PREM;
	}
	public Double getUI_M_POL_FC_TOT_PREM() {
		 return UI_M_POL_FC_TOT_PREM;
	}
	public void setPOL_ASSURED_NAME(String POL_ASSURED_NAME) {
		this.POL_ASSURED_NAME = POL_ASSURED_NAME;
	}
	public String getPOL_ASSURED_NAME() {
		 return POL_ASSURED_NAME;
	}
	public void setUI_M_POL_LC_TOT_LOADING(Double UI_M_POL_LC_TOT_LOADING) {
		this.UI_M_POL_LC_TOT_LOADING = UI_M_POL_LC_TOT_LOADING;
	}
	public Double getUI_M_POL_LC_TOT_LOADING() {
		 return UI_M_POL_LC_TOT_LOADING;
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
	/*public void setPOL_PROD_GROUP_CODE(String POL_PROD_GROUP_CODE) {
		this.POL_PROD_GROUP_CODE = POL_PROD_GROUP_CODE;
	}
	public String getPOL_PROD_GROUP_CODE() {
		 return POL_PROD_GROUP_CODE;
	}*/
	public void setPOL_ORG_NO_OF_INST(Integer POL_ORG_NO_OF_INST) {
		this.POL_ORG_NO_OF_INST = POL_ORG_NO_OF_INST;
	}
	public Integer getPOL_ORG_NO_OF_INST() {
		 return POL_ORG_NO_OF_INST;
	}
	public void setPOL_REMARKS(String POL_REMARKS) {
		this.POL_REMARKS = POL_REMARKS;
	}
	public String getPOL_REMARKS() {
		 return POL_REMARKS;
	}
	public void setUI_M_FC_DEATH_LOAD(Double UI_M_FC_DEATH_LOAD) {
		this.UI_M_FC_DEATH_LOAD = UI_M_FC_DEATH_LOAD;
	}
	public Double getUI_M_FC_DEATH_LOAD() {
		 return UI_M_FC_DEATH_LOAD;
	}
	public void setPOL_TRAN_DT(Date POL_TRAN_DT) {
		this.POL_TRAN_DT = POL_TRAN_DT;
		 summaryDate = CommonUtils.dateToPELStringFormatter(POL_TRAN_DT);
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
	public void setUI_M_POL_FC_NET_PREM(Double UI_M_POL_FC_NET_PREM) {
		this.UI_M_POL_FC_NET_PREM = UI_M_POL_FC_NET_PREM;
	}
	public Double getUI_M_POL_FC_NET_PREM() {
		 return UI_M_POL_FC_NET_PREM;
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
	public void setUI_M_POL_LC_TOT_LOADING1(Double UI_M_POL_LC_TOT_LOADING1) {
		this.UI_M_POL_LC_TOT_LOADING1 = UI_M_POL_LC_TOT_LOADING1;
	}
	public Double getUI_M_POL_LC_TOT_LOADING1() {
		 return UI_M_POL_LC_TOT_LOADING1;
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
	public void setUI_M_POL_CITY_NAME(String UI_M_POL_CITY_NAME) {
		this.UI_M_POL_CITY_NAME = UI_M_POL_CITY_NAME;
	}
	public String getUI_M_POL_CITY_NAME() {
		 return UI_M_POL_CITY_NAME;
	}
	public void setUI_M_LC_PCHARGES_BORNE_CUST1(Double UI_M_LC_PCHARGES_BORNE_CUST1) {
		this.UI_M_LC_PCHARGES_BORNE_CUST1 = UI_M_LC_PCHARGES_BORNE_CUST1;
	}
	public Double getUI_M_LC_PCHARGES_BORNE_CUST1() {
		 return UI_M_LC_PCHARGES_BORNE_CUST1;
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
	public void setUI_M_POL_RI_POOL_CODE_DESC(String UI_M_POL_RI_POOL_CODE_DESC) {
		this.UI_M_POL_RI_POOL_CODE_DESC = UI_M_POL_RI_POOL_CODE_DESC;
	}
	public String getUI_M_POL_RI_POOL_CODE_DESC() {
		 return UI_M_POL_RI_POOL_CODE_DESC;
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
	public void setUI_M_FC_BROK_COMM(Double UI_M_FC_BROK_COMM) {
		this.UI_M_FC_BROK_COMM = UI_M_FC_BROK_COMM;
	}
	public Double getUI_M_FC_BROK_COMM() {
		 return UI_M_FC_BROK_COMM;
	}
	public void setPOL_UW_YEAR(Integer POL_UW_YEAR) {
		this.POL_UW_YEAR = POL_UW_YEAR;
	}
	public Integer getPOL_UW_YEAR() {
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
	public void setUI_M_BANK_CODE_DESC(String UI_M_BANK_CODE_DESC) {
		this.UI_M_BANK_CODE_DESC = UI_M_BANK_CODE_DESC;
	}
	public String getUI_M_BANK_CODE_DESC() {
		 return UI_M_BANK_CODE_DESC;
	}
	public void setPOL_STATE_CODE(String POL_STATE_CODE) {
		this.POL_STATE_CODE = POL_STATE_CODE;
	}
	public String getPOL_STATE_CODE() {
		 return POL_STATE_CODE;
	}
	public void setUI_M_POL_FC_MOP(Double UI_M_POL_FC_MOP) {
		this.UI_M_POL_FC_MOP = UI_M_POL_FC_MOP;
	}
	public Double getUI_M_POL_FC_MOP() {
		 return UI_M_POL_FC_MOP;
	}
	public void setPOL_SUB_PLAN_CODE(String POL_SUB_PLAN_CODE) {
		this.POL_SUB_PLAN_CODE = POL_SUB_PLAN_CODE;
	}
	public String getPOL_SUB_PLAN_CODE() {
		 return POL_SUB_PLAN_CODE;
	}
	public void setPOL_LINK_SYS_ID(Double POL_LINK_SYS_ID) {
		this.POL_LINK_SYS_ID = POL_LINK_SYS_ID;
	}
	public Double getPOL_LINK_SYS_ID() {
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
	public void setUI_M_POL_LC_NET_PREM1(Double UI_M_POL_LC_NET_PREM1) {
		this.UI_M_POL_LC_NET_PREM1 = UI_M_POL_LC_NET_PREM1;
	}
	public Double getUI_M_POL_LC_NET_PREM1() {
		 return UI_M_POL_LC_NET_PREM1;
	}
	public void setUI_M_LC_TPD_LOAD(Double UI_M_LC_TPD_LOAD) {
		this.UI_M_LC_TPD_LOAD = UI_M_LC_TPD_LOAD;
	}
	public Double getUI_M_LC_TPD_LOAD() {
		 return UI_M_LC_TPD_LOAD;
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
	public void setUI_M_FC_OCC_LOAD(Double UI_M_FC_OCC_LOAD) {
		this.UI_M_FC_OCC_LOAD = UI_M_FC_OCC_LOAD;
	}
	public Double getUI_M_FC_OCC_LOAD() {
		 return UI_M_FC_OCC_LOAD;
	}
	public void setUI_M_POL_FC_SA(Double UI_M_POL_FC_SA) {
		this.UI_M_POL_FC_SA = UI_M_POL_FC_SA;
	}
	public Double getUI_M_POL_FC_SA() {
		 return UI_M_POL_FC_SA;
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
	public void setUI_M_POL_LC_TOT_DISCOUNT1(Double UI_M_POL_LC_TOT_DISCOUNT1) {
		this.UI_M_POL_LC_TOT_DISCOUNT1 = UI_M_POL_LC_TOT_DISCOUNT1;
	}
	public Double getUI_M_POL_LC_TOT_DISCOUNT1() {
		 return UI_M_POL_LC_TOT_DISCOUNT1;
	}
	public void setPOL_ORG_FC_CURR_SA(Double POL_ORG_FC_CURR_SA) {
		this.POL_ORG_FC_CURR_SA = POL_ORG_FC_CURR_SA;
	}
	public Double getPOL_ORG_FC_CURR_SA() {
		 return POL_ORG_FC_CURR_SA;
	}
	public void setUI_M_PROD_DESC(String UI_M_PROD_DESC) {
		this.UI_M_PROD_DESC = UI_M_PROD_DESC;
	}
	public String getUI_M_PROD_DESC() {
		 return UI_M_PROD_DESC;
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
	public void setPOL_ORG_PERIOD(Integer POL_ORG_PERIOD) {
		this.POL_ORG_PERIOD = POL_ORG_PERIOD;
	}
	public Integer getPOL_ORG_PERIOD() {
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
	public void setUI_M_POL_STATE_NAME(String UI_M_POL_STATE_NAME) {
		this.UI_M_POL_STATE_NAME = UI_M_POL_STATE_NAME;
	}
	public String getUI_M_POL_STATE_NAME() {
		 return UI_M_POL_STATE_NAME;
	}
	public void setUI_M_POL_CLASS_DESC(String UI_M_POL_CLASS_DESC) {
		this.UI_M_POL_CLASS_DESC = UI_M_POL_CLASS_DESC;
	}
	public String getUI_M_POL_CLASS_DESC() {
		 return UI_M_POL_CLASS_DESC;
	}
	public void setUI_M_FC_SCHARGES_BORNE_COMP(Double UI_M_FC_SCHARGES_BORNE_COMP) {
		this.UI_M_FC_SCHARGES_BORNE_COMP = UI_M_FC_SCHARGES_BORNE_COMP;
	}
	public Double getUI_M_FC_SCHARGES_BORNE_COMP() {
		 return UI_M_FC_SCHARGES_BORNE_COMP;
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
	public void setUI_M_POL_MODE_OF_PYMT_RATE(Double UI_M_POL_MODE_OF_PYMT_RATE) {
		this.UI_M_POL_MODE_OF_PYMT_RATE = UI_M_POL_MODE_OF_PYMT_RATE;
	}
	public Double getUI_M_POL_MODE_OF_PYMT_RATE() {
		 return UI_M_POL_MODE_OF_PYMT_RATE;
	}
	public void setUI_M_PROJECT_CODE_DESC(String UI_M_PROJECT_CODE_DESC) {
		this.UI_M_PROJECT_CODE_DESC = UI_M_PROJECT_CODE_DESC;
	}
	public String getUI_M_PROJECT_CODE_DESC() {
		 return UI_M_PROJECT_CODE_DESC;
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
	public void setUI_M_POL_PLAN_DESC(String UI_M_POL_PLAN_DESC) {
		this.UI_M_POL_PLAN_DESC = UI_M_POL_PLAN_DESC;
	}
	public String getUI_M_POL_PLAN_DESC() {
		 return UI_M_POL_PLAN_DESC;
	}
	public void setPOL_LC_CLIENT_ALLOC_AMT(Double POL_LC_CLIENT_ALLOC_AMT) {
		this.POL_LC_CLIENT_ALLOC_AMT = POL_LC_CLIENT_ALLOC_AMT;
	}
	public Double getPOL_LC_CLIENT_ALLOC_AMT() {
		 return POL_LC_CLIENT_ALLOC_AMT;
	}
	public void setUI_M_POL_RES_AREA_CODE_DESC(String UI_M_POL_RES_AREA_CODE_DESC) {
		this.UI_M_POL_RES_AREA_CODE_DESC = UI_M_POL_RES_AREA_CODE_DESC;
	}
	public String getUI_M_POL_RES_AREA_CODE_DESC() {
		 return UI_M_POL_RES_AREA_CODE_DESC;
	}
	public void setPOL_FC_TOP_UP_AMT(Double POL_FC_TOP_UP_AMT) {
		this.POL_FC_TOP_UP_AMT = POL_FC_TOP_UP_AMT;
	}
	public Double getPOL_FC_TOP_UP_AMT() {
		 return POL_FC_TOP_UP_AMT;
	}
	public void setUI_M_LC_SCHARGES_BORNE_COMP(Double UI_M_LC_SCHARGES_BORNE_COMP) {
		this.UI_M_LC_SCHARGES_BORNE_COMP = UI_M_LC_SCHARGES_BORNE_COMP;
	}
	public Double getUI_M_LC_SCHARGES_BORNE_COMP() {
		 return UI_M_LC_SCHARGES_BORNE_COMP;
	}
	public void setUI_M_POL_SRC_OF_BUS_DESC(String UI_M_POL_SRC_OF_BUS_DESC) {
		this.UI_M_POL_SRC_OF_BUS_DESC = UI_M_POL_SRC_OF_BUS_DESC;
	}
	public String getUI_M_POL_SRC_OF_BUS_DESC() {
		 return UI_M_POL_SRC_OF_BUS_DESC;
	}
	public void setPOL_TARIFF_TERM_FLAG(String POL_TARIFF_TERM_FLAG) {
		this.POL_TARIFF_TERM_FLAG = POL_TARIFF_TERM_FLAG;
	}
	public String getPOL_TARIFF_TERM_FLAG() {
		 return POL_TARIFF_TERM_FLAG;
	}
	public void setUI_M_POL_CUST_CURR_DESC(String UI_M_POL_CUST_CURR_DESC) {
		this.UI_M_POL_CUST_CURR_DESC = UI_M_POL_CUST_CURR_DESC;
	}
	public String getUI_M_POL_CUST_CURR_DESC() {
		 return UI_M_POL_CUST_CURR_DESC;
	}
	public void setPOL_PROP_QUOT_FLAG(String POL_PROP_QUOT_FLAG) {
		this.POL_PROP_QUOT_FLAG = POL_PROP_QUOT_FLAG;
	}
	public String getPOL_PROP_QUOT_FLAG() {
		 return POL_PROP_QUOT_FLAG;
	}
	public void setUI_M_FC_TPD_LOAD(Double UI_M_FC_TPD_LOAD) {
		this.UI_M_FC_TPD_LOAD = UI_M_FC_TPD_LOAD;
	}
	public Double getUI_M_FC_TPD_LOAD() {
		 return UI_M_FC_TPD_LOAD;
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
	public void setUI_M_FC_SCHARGES_BORNE_CUST(Double UI_M_FC_SCHARGES_BORNE_CUST) {
		this.UI_M_FC_SCHARGES_BORNE_CUST = UI_M_FC_SCHARGES_BORNE_CUST;
	}
	public Double getUI_M_FC_SCHARGES_BORNE_CUST() {
		 return UI_M_FC_SCHARGES_BORNE_CUST;
	}
	public void setPOL_HOME_OWNER_FLAG(String POL_HOME_OWNER_FLAG) {
		this.POL_HOME_OWNER_FLAG = POL_HOME_OWNER_FLAG;
	}
	public String getPOL_HOME_OWNER_FLAG() {
		 return POL_HOME_OWNER_FLAG;
	}
	public Double getPOL_DEF_PERIOD_FM() {
	    return POL_DEF_PERIOD_FM;
	}
	public void setPOL_DEF_PERIOD_FM(Double pol_def_period_fm) {
	    POL_DEF_PERIOD_FM = pol_def_period_fm;
	}
	public Double getPOL_DEF_PERIOD_TO() {
	    return POL_DEF_PERIOD_TO;
	}
	public void setPOL_DEF_PERIOD_TO(Double pol_def_period_to) {
	    POL_DEF_PERIOD_TO = pol_def_period_to;
	}
	public Double getPOL_WAQAF_PERIOD_FM() {
	    return POL_WAQAF_PERIOD_FM;
	}
	public void setPOL_WAQAF_PERIOD_FM(Double pol_waqaf_period_fm) {
	    POL_WAQAF_PERIOD_FM = pol_waqaf_period_fm;
	}
	public Double getPOL_WAQAF_PERIOD_TO() {
	    return POL_WAQAF_PERIOD_TO;
	}
	public void setPOL_WAQAF_PERIOD_TO(Double pol_waqaf_period_to) {
	    POL_WAQAF_PERIOD_TO = pol_waqaf_period_to;
	}
	public String getUI_M_SURR_MAT() {
	    return UI_M_SURR_MAT;
	}
	public void setUI_M_SURR_MAT(String ui_m_surr_mat) {
	    UI_M_SURR_MAT = ui_m_surr_mat;
	}
	public String getPOL_CARD_HOLDER_NAME() {
	    return POL_CARD_HOLDER_NAME;
	}
	public void setPOL_CARD_HOLDER_NAME(String pol_card_holder_name) {
	    POL_CARD_HOLDER_NAME = pol_card_holder_name;
	}
	public String getPOL_DEF_IMM_FLAG() {
	    return POL_DEF_IMM_FLAG;
	}
	public void setPOL_DEF_IMM_FLAG(String pol_def_imm_flag) {
	    POL_DEF_IMM_FLAG = pol_def_imm_flag;
	}
	public Double getPOL_FC_MON_ANNU_AMT() {
	    return POL_FC_MON_ANNU_AMT;
	}
	public void setPOL_FC_MON_ANNU_AMT(Double pol_fc_mon_annu_amt) {
	    POL_FC_MON_ANNU_AMT = pol_fc_mon_annu_amt;
	}
	public Double getPOL_LC_MON_ANNU_AMT() {
	    return POL_LC_MON_ANNU_AMT;
	}
	public void setPOL_LC_MON_ANNU_AMT(Double pol_lc_mon_annu_amt) {
	    POL_LC_MON_ANNU_AMT = pol_lc_mon_annu_amt;
	}
	public Double getPOL_AUTH_LIMIT() {
	    return POL_AUTH_LIMIT;
	}
	public void setPOL_AUTH_LIMIT(Double pol_auth_limit) {
	    POL_AUTH_LIMIT = pol_auth_limit;
	}
	/*
	 * modified by Ameen to set 16 digit acc. no.
	 * public Integer getUI_M_POL_CONT_AD_ACC_NO_1() {
	    return UI_M_POL_CONT_AD_ACC_NO_1;
	}
	public void setUI_M_POL_CONT_AD_ACC_NO_1(Integer ui_m_pol_cont_ad_acc_no_1) {
	    UI_M_POL_CONT_AD_ACC_NO_1 = ui_m_pol_cont_ad_acc_no_1;
	}*/
	
	public Double getPOL_NEW_FC_SA() {
	    return POL_NEW_FC_SA;
	}
	public Long getUI_M_POL_CONT_AD_ACC_NO_1() {
		return UI_M_POL_CONT_AD_ACC_NO_1;
	}
	public void setUI_M_POL_CONT_AD_ACC_NO_1(Long uI_M_POL_CONT_AD_ACC_NO_1) {
		UI_M_POL_CONT_AD_ACC_NO_1 = uI_M_POL_CONT_AD_ACC_NO_1;
	}
	public void setPOL_NEW_FC_SA(Double pol_new_fc_sa) {
	    POL_NEW_FC_SA = pol_new_fc_sa;
	}
	public Double getPOL_NEW_LC_SA() {
	    return POL_NEW_LC_SA;
	}
	public void setPOL_NEW_LC_SA(Double pol_new_lc_sa) {
	    POL_NEW_LC_SA = pol_new_lc_sa;
	}
	public Double getPOL_ORG_NEW_FC_SA() {
	    return POL_ORG_NEW_FC_SA;
	}
	public void setPOL_ORG_NEW_FC_SA(Double pol_org_new_fc_sa) {
	    POL_ORG_NEW_FC_SA = pol_org_new_fc_sa;
	}
	public Double getPOL_ORG_NEW_LC_SA() {
	    return POL_ORG_NEW_LC_SA;
	}
	public void setPOL_ORG_NEW_LC_SA(Double pol_org_new_lc_sa) {
	    POL_ORG_NEW_LC_SA = pol_org_new_lc_sa;
	}
	public String getPOL_PAYOR_SDCODE() {
	    return POL_PAYOR_SDCODE;
	}
	public void setPOL_PAYOR_SDCODE(String pol_payor_sdcode) {
	    POL_PAYOR_SDCODE = pol_payor_sdcode;
	}
	public String getPOL_ENROL_YN() {
	    return POL_ENROL_YN;
	}
	public void setPOL_ENROL_YN(String pol_enrol_yn) {
	    POL_ENROL_YN = pol_enrol_yn;
	}
	public String getPOL_CONT_AD_BANK_CODE() {
	    return POL_CONT_AD_BANK_CODE;
	}
	public void setPOL_CONT_AD_BANK_CODE(String pol_cont_ad_bank_code) {
	    POL_CONT_AD_BANK_CODE = pol_cont_ad_bank_code;
	}
	public String getPOL_CONT_AD_ACC_NO() {
	    return POL_CONT_AD_ACC_NO;
	}
	public void setPOL_CONT_AD_ACC_NO(String pol_cont_ad_acc_no) {
	    POL_CONT_AD_ACC_NO = pol_cont_ad_acc_no;
	}
	public Double getPOL_ORG_FC_MON_ANNU_AMT() {
	    return POL_ORG_FC_MON_ANNU_AMT;
	}
	public void setPOL_ORG_FC_MON_ANNU_AMT(Double pol_org_fc_mon_annu_amt) {
	    POL_ORG_FC_MON_ANNU_AMT = pol_org_fc_mon_annu_amt;
	}
	public Double getPOL_ORG_LC_MON_ANNU_AMT() {
	    return POL_ORG_LC_MON_ANNU_AMT;
	}
	public void setPOL_ORG_LC_MON_ANNU_AMT(Double pol_org_lc_mon_annu_amt) {
	    POL_ORG_LC_MON_ANNU_AMT = pol_org_lc_mon_annu_amt;
	}
	public Double getPOL_LC_BASIC_PREM1() {
	    return POL_LC_BASIC_PREM1;
	}
	public void setPOL_LC_BASIC_PREM1(Double pol_lc_basic_prem1) {
	    POL_LC_BASIC_PREM1 = pol_lc_basic_prem1;
	}
	public Double getPOL_LC_ADDL_PREM1() {
	    return POL_LC_ADDL_PREM1;
	}
	public void setPOL_LC_ADDL_PREM1(Double pol_lc_addl_prem1) {
	    POL_LC_ADDL_PREM1 = pol_lc_addl_prem1;
	}
	public Double getPOL_LC_DISC_AMT1() {
	    return POL_LC_DISC_AMT1;
	}
	public void setPOL_LC_DISC_AMT1(Double pol_lc_disc_amt1) {
	    POL_LC_DISC_AMT1 = pol_lc_disc_amt1;
	}
	public Double getPOL_LC_FIRST_PREM1() {
	    return POL_LC_FIRST_PREM1;
	}
	public void setPOL_LC_FIRST_PREM1(Double pol_lc_first_prem1) {
	    POL_LC_FIRST_PREM1 = pol_lc_first_prem1;
	}
	public Double getPOL_BASIC_RATE1() {
	    return POL_BASIC_RATE1;
	}
	public void setPOL_BASIC_RATE1(Double pol_basic_rate1) {
	    POL_BASIC_RATE1 = pol_basic_rate1;
	}
	public Double getPAYOR_TAB() {
	    return PAYOR_TAB;
	}
	public void setPAYOR_TAB(Double payor_tab) {
	    PAYOR_TAB = payor_tab;
	}
	 
	public Double getUI_M_POL_LC_PREM_PAYABLE() {
	    return UI_M_POL_LC_PREM_PAYABLE;
	}
	public void setUI_M_POL_LC_PREM_PAYABLE(Double ui_m_pol_lc_prem_payable) {
	    UI_M_POL_LC_PREM_PAYABLE = ui_m_pol_lc_prem_payable;
	}
	public Double getUI_M_POL_FC_PREM_PAYABLE() {
	    return UI_M_POL_FC_PREM_PAYABLE;
	}
	public void setUI_M_POL_FC_PREM_PAYABLE(Double ui_m_pol_fc_prem_payable) {
	    UI_M_POL_FC_PREM_PAYABLE = ui_m_pol_fc_prem_payable;
	}
	public Double getUI_M_POL_FC_TOT_CHARGE() {
	    return UI_M_POL_FC_TOT_CHARGE;
	}
	public void setUI_M_POL_FC_TOT_CHARGE(Double ui_m_pol_fc_tot_charge) {
	    UI_M_POL_FC_TOT_CHARGE = ui_m_pol_fc_tot_charge;
	}
	public Double getUI_M_POL_LC_TOT_CHARGE() {
	    return UI_M_POL_LC_TOT_CHARGE;
	}
	public void setUI_M_POL_LC_TOT_CHARGE(Double ui_m_pol_lc_tot_charge) {
	    UI_M_POL_LC_TOT_CHARGE = ui_m_pol_lc_tot_charge;
	}
	public String getPOL_PROD_GROUP_CODE() {
	    return POL_PROD_GROUP_CODE;
	}
	public void setPOL_PROD_GROUP_CODE(String pol_prod_group_code) {
	    POL_PROD_GROUP_CODE = pol_prod_group_code;
	}
	/**
	 * @return the pOL_APL_YN
	 */
	public String getPOL_APL_YN() {
		return POL_APL_YN;
	}
	/**
	 * @param pol_apl_yn the pOL_APL_YN to set
	 */
	public void setPOL_APL_YN(String pol_apl_yn) {
		POL_APL_YN = pol_apl_yn;
	}
	/**
	 * @return the uI_M_PROD_APL_YN
	 */
	public String getUI_M_PROD_APL_YN() {
		return UI_M_PROD_APL_YN;
	}
	/**
	 * @param ui_m_prod_apl_yn the uI_M_PROD_APL_YN to set
	 */
	public void setUI_M_PROD_APL_YN(String ui_m_prod_apl_yn) {
		UI_M_PROD_APL_YN = ui_m_prod_apl_yn;
	}
	public String getSummaryDate() {
		return summaryDate;
	}
	public void setSummaryDate(String summaryDate) {
		this.summaryDate = summaryDate;
	}
	public String getPOL_FLEX_14() {
		return POL_FLEX_14;
	}
	public void setPOL_FLEX_14(String pol_flex_14) {
		POL_FLEX_14 = pol_flex_14;
	}
	public String getPOL_ESC_YN() {
		return POL_ESC_YN;
	}
	public void setPOL_ESC_YN(String pol_esc_yn) {
		POL_ESC_YN = pol_esc_yn;
	}
	 
	public Integer getPOL_CVR_ESC_PERC() {
		return POL_CVR_ESC_PERC;
	}
	public void setPOL_CVR_ESC_PERC(Integer pol_cvr_esc_perc) {
		POL_CVR_ESC_PERC = pol_cvr_esc_perc;
	}
	public String getPOL_FLEX_20() {
		return POL_FLEX_20;
	}
	public void setPOL_FLEX_20(String pol_flex_20) {
		POL_FLEX_20 = pol_flex_20;
	}
	public Integer getPOL_FLEX_18() {
		return POL_FLEX_18;
	}
	public void setPOL_FLEX_18(Integer pol_flex_18) {
		POL_FLEX_18 = pol_flex_18;
	}
	public String getPOL_FLEX_11() {
		return POL_FLEX_11;
	}
	public void setPOL_FLEX_11(String pol_flex_11) {
		POL_FLEX_11 = pol_flex_11;
	} 
	public Integer getPOL_PREM_WAIVE_INT_RATE() {
		return POL_PREM_WAIVE_INT_RATE;
	}
	public void setPOL_PREM_WAIVE_INT_RATE(Integer pol_prem_waive_int_rate) {
		POL_PREM_WAIVE_INT_RATE = pol_prem_waive_int_rate;
	}
	public Long getPOL_MICR_CODE() {
		return POL_MICR_CODE;
	}
	public void setPOL_MICR_CODE(Long pol_micr_code) {
		POL_MICR_CODE = pol_micr_code;
	}
	/*Modified by ganesh on 06-11-2017 as per ajoy suggestion*/
	public String getPOL_CUST_BANK_CODE() {
		return POL_CUST_BANK_CODE;
	}
	public void setPOL_CUST_BANK_CODE(String pol_cust_bank_code) {
		POL_CUST_BANK_CODE = pol_cust_bank_code;
	}
	/*end*/
	public String getUI_M_CBAD_ACNT_NO() {
		return UI_M_CBAD_ACNT_NO;
	}
	public void setUI_M_CBAD_ACNT_NO(String ui_m_cbad_acnt_no) {
		UI_M_CBAD_ACNT_NO = ui_m_cbad_acnt_no;
	}
	public String getUI_M_CITY_CODE() {
		return UI_M_CITY_CODE;
	}
	public void setUI_M_CITY_CODE(String ui_m_city_code) {
		UI_M_CITY_CODE = ui_m_city_code;
	}
	public String getUI_M_CITY_CODE_DESC() {
		return UI_M_CITY_CODE_DESC;
	}
	public void setUI_M_CITY_CODE_DESC(String ui_m_city_code_desc) {
		UI_M_CITY_CODE_DESC = ui_m_city_code_desc;
	}
	public String getUI_M_BANK_CODE() {
		return UI_M_BANK_CODE;
	}
	public void setUI_M_BANK_CODE(String ui_m_bank_code) {
		UI_M_BANK_CODE = ui_m_bank_code;
	}
	public String getUI_M_BANK_CODE_DESC_1() {
		return UI_M_BANK_CODE_DESC_1;
	}
	public void setUI_M_BANK_CODE_DESC_1(String ui_m_bank_code_desc_1) {
		UI_M_BANK_CODE_DESC_1 = ui_m_bank_code_desc_1;
	}
	public String getUI_M_BRANCH_CODE() {
		return UI_M_BRANCH_CODE;
	}
	public void setUI_M_BRANCH_CODE(String ui_m_branch_code) {
		UI_M_BRANCH_CODE = ui_m_branch_code;
	}
	public String getUI_M_BRANCH_CODE_DESC_1() {
		return UI_M_BRANCH_CODE_DESC_1;
	}
	public void setUI_M_BRANCH_CODE_DESC_1(String ui_m_branch_code_desc_1) {
		UI_M_BRANCH_CODE_DESC_1 = ui_m_branch_code_desc_1;
	}
	/*
	added by ram
	 
	@Column(name="POL_PREM_OPT")
private String POL_PREM_OPTION_CODE;
private String POL_PREM_OPTION_DESC;

public String getPOL_PREM_OPTION_CODE() {
	return POL_PREM_OPTION_CODE;
}
public void setPOL_PREM_OPTION_CODE(String pOL_PREM_OPTION_CODE) {
	POL_PREM_OPTION_CODE = pOL_PREM_OPTION_CODE;
}
public String getPOL_PREM_OPTION_DESC() {
	return POL_PREM_OPTION_DESC;
}
public void setPOL_PREM_OPTION_DESC(String pOL_PREM_OPTION_DESC) {
	POL_PREM_OPTION_DESC = pOL_PREM_OPTION_DESC;
}


end*/
	
	/*Added By Saritha on 3.3.2016 for EMail id field Addition(Start)*/
	@Column(name="POL_FLEX_26")	
	private String POL_RES_EMAIL_ID;
	public String getPOL_RES_EMAIL_ID() {
		return POL_RES_EMAIL_ID;
	}
	public void setPOL_RES_EMAIL_ID(String pOL_RES_EMAIL_ID) {
		POL_RES_EMAIL_ID = pOL_RES_EMAIL_ID;
		
	}
	 
	
	/*End*/
	
	/*added by R. Raja on 13-07-2016 for add EMR Rate field*/
	
	@Column(name="POL_EMR_RATE")	
	private Double POL_EMR_RATE;
	
	@Column(name="POL_ORG_COMM_RATE")	
	private Double POL_ORG_COMM_RATE;
    
	@Column(name="POL_ORG_COMM_VALUE")	
	private Double POL_ORG_COMM_VALUE;
	
	@Column(name="POL_COMM_RATE")	
	private Double POL_COMM_RATE ;
	
	@Column(name="POL_COMM_VALUE")	
	private Double POL_COMM_VALUE;

	public Double getPOL_EMR_RATE() {
		return POL_EMR_RATE;
	}
	public void setPOL_EMR_RATE(Double pOL_EMR_RATE) {
		POL_EMR_RATE = pOL_EMR_RATE;
	}

	
	

	public Double getPOL_ORG_COMM_RATE() {
		return POL_ORG_COMM_RATE;
	}
	public void setPOL_ORG_COMM_RATE(Double pOL_ORG_COMM_RATE) {
		POL_ORG_COMM_RATE = pOL_ORG_COMM_RATE;
	}
	public Double getPOL_ORG_COMM_VALUE() {
		return POL_ORG_COMM_VALUE;
	}
	public void setPOL_ORG_COMM_VALUE(Double pOL_ORG_COMM_VALUE) {
		POL_ORG_COMM_VALUE = pOL_ORG_COMM_VALUE;
	}
	public Double getPOL_COMM_RATE() {
		return POL_COMM_RATE;
	}
	public void setPOL_COMM_RATE(Double pOL_COMM_RATE) {
		POL_COMM_RATE = pOL_COMM_RATE;
	}
	public Double getPOL_COMM_VALUE() {
		return POL_COMM_VALUE;
	}
	public void setPOL_COMM_VALUE(Double pOL_COMM_VALUE) {
		POL_COMM_VALUE = pOL_COMM_VALUE;
	}
	
	
		
	
	/*end*/
	@Column(name="POL_BANK_CODE")	
	private String POL_BANK_CODE;

	public String getPOL_BANK_CODE() {
		return POL_BANK_CODE;
	}
	public void setPOL_BANK_CODE(String pOL_BANK_CODE) {
		POL_BANK_CODE = pOL_BANK_CODE;
	}
	
	private String UI_POL_BANK_DESC;

	public String getUI_POL_BANK_DESC() {
		return UI_POL_BANK_DESC;
	}
	public void setUI_POL_BANK_DESC(String uI_POL_BANK_DESC) {
		UI_POL_BANK_DESC = uI_POL_BANK_DESC;
	}
	
	@Column(name="POL_BANK_DIVN")	
	private String POL_BANK_DIVN;

	public String getPOL_BANK_DIVN() {
		return POL_BANK_DIVN;
	}
	public void setPOL_BANK_DIVN(String pOL_BANK_DIVN) {
		POL_BANK_DIVN = pOL_BANK_DIVN;
	}
	
	/*Added by Ram on 25/11/2016 for LoanType field addition*/
	@Column(name = "POL_LOAN_TYPE")
	private String POL_LOAN_TYPE;

	public String getPOL_LOAN_TYPE() {
		return POL_LOAN_TYPE;
	}
	public void setPOL_LOAN_TYPE(String pOL_LOAN_TYPE) {
		POL_LOAN_TYPE = pOL_LOAN_TYPE;
	}
	/*End*/
	
	/*Added by Ram on 03/12/2016 for business Rule Remarks capturing*/
	@Column(name = "POL_BUS_REMARKS")
	private String POL_BUS_REMARKS;

	public String getPOL_BUS_REMARKS() {
		return POL_BUS_REMARKS;
	}
	public void setPOL_BUS_REMARKS(String pOL_BUS_REMARKS) {
		POL_BUS_REMARKS = pOL_BUS_REMARKS;
	}
	/*End*/
	/*Added by saranya on 02-12-2016 FOR RM018T - FSD_IL_ZB Life_013_Underwriting changes*/ 
	@Column(name="POL_FC_AGENT_PREM")	
	private Double POL_FC_AGENT_PREM;

	@Column(name="POL_LC_AGENT_PREM")	
	private Double POL_LC_AGENT_PREM;

	public Double getPOL_FC_AGENT_PREM() {
		return POL_FC_AGENT_PREM;
	}
	public void setPOL_FC_AGENT_PREM(Double pOL_FC_AGENT_PREM) {
		POL_FC_AGENT_PREM = pOL_FC_AGENT_PREM;
	}
	public Double getPOL_LC_AGENT_PREM() {
		return POL_LC_AGENT_PREM;
	}
	public void setPOL_LC_AGENT_PREM(Double pOL_LC_AGENT_PREM) {
		POL_LC_AGENT_PREM = pOL_LC_AGENT_PREM;
	}
	/*End*/

	/*added by saranya on 10-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1.0*/

	@Column(name="POL_FLEX_27")
	private String POL_CANCEL_YN;

	public String getPOL_CANCEL_YN() {
		return POL_CANCEL_YN;
	}
	public void setPOL_CANCEL_YN(String pOL_CANCEL_YN) {
		POL_CANCEL_YN = pOL_CANCEL_YN;
	}
	/*End*/
	
	/*Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer Master Changes COMMENTS*/
	
	@Column(name = "POL_PREM_PAYER_CODE")
private String POL_PREM_PAYER_CODE;

private String UI_M_POL_PREM_PAYER_CODE_DESC;


public String getUI_M_POL_PREM_PAYER_CODE_DESC() {
return UI_M_POL_PREM_PAYER_CODE_DESC;
}
public void setUI_M_POL_PREM_PAYER_CODE_DESC(
String uI_M_POL_PREM_PAYER_CODE_DESC) {
UI_M_POL_PREM_PAYER_CODE_DESC = uI_M_POL_PREM_PAYER_CODE_DESC;
}
public String getPOL_PREM_PAYER_CODE() {
return POL_PREM_PAYER_CODE;
}
public void setPOL_PREM_PAYER_CODE(String pOL_PREM_PAYER_CODE) {
POL_PREM_PAYER_CODE = pOL_PREM_PAYER_CODE;
}
/*end*/


/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
@Column(name = "POL_LAPS_OVR_YN")
private String POL_LAPS_OVR_YN;

public String getPOL_LAPS_OVR_YN() {
	return POL_LAPS_OVR_YN;
}
public void setPOL_LAPS_OVR_YN(String pOL_LAPS_OVR_YN) {
	POL_LAPS_OVR_YN = pOL_LAPS_OVR_YN;
}

/*End*/

/*Added by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/

@Column(name = "POL_LAPS_OVR_FRM_DT")
private Date POL_LAPS_OVR_FRM_DT;

public Date getPOL_LAPS_OVR_FRM_DT() {
	return POL_LAPS_OVR_FRM_DT;
}
public void setPOL_LAPS_OVR_FRM_DT(Date pOL_LAPS_OVR_FRM_DT) {
	POL_LAPS_OVR_FRM_DT = pOL_LAPS_OVR_FRM_DT;
}

@Column(name = "POL_LAPS_OVR_TO_DT")
private Date POL_LAPS_OVR_TO_DT;


public Date getPOL_LAPS_OVR_TO_DT() {
	return POL_LAPS_OVR_TO_DT;
}
public void setPOL_LAPS_OVR_TO_DT(Date pOL_LAPS_OVR_TO_DT) {
	POL_LAPS_OVR_TO_DT = pOL_LAPS_OVR_TO_DT;
}

/*End*/


	/*Added by saritha on 21-Jan-2017 for RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/

	@Column(name="POL_FLEX_26")
	private String POL_FLEX_26;

	public String getPOL_FLEX_26() {
		return POL_FLEX_26;
	}
	public void setPOL_FLEX_26(String pOL_FLEX_26) {
		POL_FLEX_26 = pOL_FLEX_26;
	}
	
	/*End*/

	
	/*Added by saritha on 27-01-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/
	@Column(name="POL_REPL_POLICY_YN")
	private String POL_REPL_POLICY_YN;

	public String getPOL_REPL_POLICY_YN() {
		return POL_REPL_POLICY_YN;
	}
	public void setPOL_REPL_POLICY_YN(String pOL_REPL_POLICY_YN) {
		POL_REPL_POLICY_YN = pOL_REPL_POLICY_YN;
	}

	/*End*/

	/*added by gopi for hands on feed back issue,serial no 18 in ZB on 31/01/17*/
	private String UI_M_POL_QUOT_NO;

	public String getUI_M_POL_QUOT_NO() {
		return UI_M_POL_QUOT_NO;
	}
	public void setUI_M_POL_QUOT_NO(String uI_M_POL_QUOT_NO) {
		UI_M_POL_QUOT_NO = uI_M_POL_QUOT_NO;
	}

	 /*end*/
	/*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 26-01-2017*/

	@Column(name="POL_BNF_ESC_PERC")
	private String POL_BNF_ESC_PERC;

	@Column(name="POL_ANN_PAY_PERIOD")
	private String POL_ANN_PAY_PERIOD;
	
	/*Modified by Saranya on 04/04/2017 as per Sivaram suggestion
	 */
	
 	@Column(name = "POL_LC_ANN_BNF_AMT") 
	/*@Column(name="POL_ANN_BNF_AMT")*/
	/*End*/
	
	private Double POL_ANN_BNF_AMT;

	public Double getPOL_ANN_BNF_AMT() {
		return POL_ANN_BNF_AMT;
	}
	public void setPOL_ANN_BNF_AMT(Double pOL_ANN_BNF_AMT) {
		POL_ANN_BNF_AMT = pOL_ANN_BNF_AMT;
	}
	public String getPOL_BNF_ESC_PERC() {
		return POL_BNF_ESC_PERC;
	}
	public void setPOL_BNF_ESC_PERC(String pOL_BNF_ESC_PERC) {
		POL_BNF_ESC_PERC = pOL_BNF_ESC_PERC;
	}
	public String getPOL_ANN_PAY_PERIOD() {
		return POL_ANN_PAY_PERIOD;
	}
	public void setPOL_ANN_PAY_PERIOD(String pOL_ANN_PAY_PERIOD) {
		POL_ANN_PAY_PERIOD = pOL_ANN_PAY_PERIOD;
	}
	/*End*/
	/*Added by saritha on 14-FEB-2017 for Handson Feedback Point,
	 * In additional status to be changed based on the situation Additional Status date to be changed.
	 *
	 */ 
	private String UI_M_ADDL_STATUS_DT;

	public String getUI_M_ADDL_STATUS_DT() {
		return UI_M_ADDL_STATUS_DT;
	}
	public void setUI_M_ADDL_STATUS_DT(String uI_M_ADDL_STATUS_DT) {
		UI_M_ADDL_STATUS_DT = uI_M_ADDL_STATUS_DT;
	}
	
	/*End*/
	
	/*Newly Added By Dhinesh on 20.3.2017*/
	
	private String UI_M_POL_CR_DT;

	public String getUI_M_POL_CR_DT() {
		return UI_M_POL_CR_DT;
	}
	public void setUI_M_POL_CR_DT(String uI_M_POL_CR_DT) {
		UI_M_POL_CR_DT = uI_M_POL_CR_DT;
	}
	
	/*End*/
	
	
	
	
	/*newly added ny sankara narayanan on 23.03.2017*/
	
	
	private String UI_POL_FRZ_FLAG;

	public String getUI_POL_FRZ_FLAG() {
		return UI_POL_FRZ_FLAG;
	}
	public void setUI_POL_FRZ_FLAG(String uI_POL_FRZ_FLAG) {
		UI_POL_FRZ_FLAG = uI_POL_FRZ_FLAG;
	}
	@Column(name="POL_DISPATCH_MTD")
	private String POL_DISPATCH_MTD;
	@Column(name="POL_DISPATCH_DT")
	private Date POL_DISPATCH_DT;
	@Column(name="POL_DOC_ACK_DT")
	private Date POL_DOC_ACK_DT;

	public String getPOL_DISPATCH_MTD() {
		return POL_DISPATCH_MTD;
	}
	public void setPOL_DISPATCH_MTD(String pOL_DISPATCH_MTD) {
		POL_DISPATCH_MTD = pOL_DISPATCH_MTD;
	}
	public Date getPOL_DISPATCH_DT() {
		return POL_DISPATCH_DT;
	}
	public void setPOL_DISPATCH_DT(Date pOL_DISPATCH_DT) {
		POL_DISPATCH_DT = pOL_DISPATCH_DT;
	}
	public Date getPOL_DOC_ACK_DT() {
		return POL_DOC_ACK_DT;
	}
	public void setPOL_DOC_ACK_DT(Date pOL_DOC_ACK_DT) {
		POL_DOC_ACK_DT = pOL_DOC_ACK_DT;
	}

	
	
	
	
	/*end*/
	
	
	/*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 22-03-2017*/
	
	@Column(name="POL_UL_PREM_CALC")
	private String POL_UL_PREM_CALC;

	public String getPOL_UL_PREM_CALC() {
		return POL_UL_PREM_CALC;
	}
	public void setPOL_UL_PREM_CALC(String pOL_UL_PREM_CALC) {
		POL_UL_PREM_CALC = pOL_UL_PREM_CALC;
	}
	/*End*/
	
	/* Added by R. Raja on 02-12-2016 for ZBILQC-1724387*/
	
	private String UI_M_PREM_PAYR_FLAG;

	public String getUI_M_PREM_PAYR_FLAG() {
		return UI_M_PREM_PAYR_FLAG;
	}
	public void setUI_M_PREM_PAYR_FLAG(String uI_M_PREM_PAYR_FLAG) {
		UI_M_PREM_PAYR_FLAG = uI_M_PREM_PAYR_FLAG;
	}

	
	
	
/*end*/
	
	/*added by raja on 02-06-2017 for hands on points*/
	private String UI_M_CUST_FLAG;

	public String getUI_M_CUST_FLAG() {
		return UI_M_CUST_FLAG;
	}
	public void setUI_M_CUST_FLAG(String uI_M_CUST_FLAG) {
		UI_M_CUST_FLAG = uI_M_CUST_FLAG;
	}
	
	/*end*/
	
	
	private int POL_ENDO_PARAM ;

	public int getPOL_ENDO_PARAM() {
		return POL_ENDO_PARAM;
	}
	public void setPOL_ENDO_PARAM(int pOL_ENDO_PARAM) {
		POL_ENDO_PARAM = pOL_ENDO_PARAM;
	}

	
	/*added by raja on 22-08-2017 for mop endorsement*/
	private String UI_M_MOP_END;

	public String getUI_M_MOP_END() {
		return UI_M_MOP_END;
	}
	public void setUI_M_MOP_END(String uI_M_MOP_END) {
		UI_M_MOP_END = uI_M_MOP_END;
	}
	/*end*/
	

    /*Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449063*/ 
	@Column(name="POL_CUST_EMP_NO")
	private String POL_CUST_EMP_NO ;

	public String getPOL_CUST_EMP_NO() {
		return POL_CUST_EMP_NO;
	}
	public void setPOL_CUST_EMP_NO(String pOL_CUST_EMP_NO) {
		POL_CUST_EMP_NO = pOL_CUST_EMP_NO;
	}
	/*End*/
	
	/* Added by Ameen on 30-10-2017 for Bank details defaulting issue */
	@Column(name="POL_CUST_ACNT_NAME")
	private String UI_M_ACC_NAME;
	
	private String UI_M_POL_BANK_DIVN_DESC;

	public String getUI_M_ACC_NAME() {
		return UI_M_ACC_NAME;
	}
	public void setUI_M_ACC_NAME(String uI_M_ACC_NAME) {
		UI_M_ACC_NAME = uI_M_ACC_NAME;
	}
	public String getUI_M_POL_BANK_DIVN_DESC() {
		return UI_M_POL_BANK_DIVN_DESC;
	}
	public void setUI_M_POL_BANK_DIVN_DESC(String uI_M_POL_BANK_DIVN_DESC) {
		UI_M_POL_BANK_DIVN_DESC = uI_M_POL_BANK_DIVN_DESC;
	}
	/*End*/
	
	 /*Added by saritha on 21-11-2017 for Due date for debit order by each policy is required*/ 
	
	@Column(name="POL_DEBIT_DAY")
	private Integer POL_DEBIT_DAY;

	public Integer getPOL_DEBIT_DAY() {
		return POL_DEBIT_DAY;
	}
	public void setPOL_DEBIT_DAY(Integer pOL_DEBIT_DAY) {
		POL_DEBIT_DAY = pOL_DEBIT_DAY;
	}
	
	/*End*/
	
	/*Added by Ameen on 22-11-2017 for policy term validation*/
	private Integer UI_M_POL_PERIOD;

	public Integer getUI_M_POL_PERIOD() {
		return UI_M_POL_PERIOD;
	}
	public void setUI_M_POL_PERIOD(Integer uI_M_POL_PERIOD) {
		UI_M_POL_PERIOD = uI_M_POL_PERIOD;
	}
	/*End*/

	
	/*Added by Janani on 03.01.2018 for ZBLIFE-1467489*/
	
	private String prod_unit_link_type;

	public String getProd_unit_link_type() {
		return prod_unit_link_type;
	}
	public void setProd_unit_link_type(String prod_unit_link_type) {
		this.prod_unit_link_type = prod_unit_link_type;
	}
	
	/*End*/
	
	/*Added by saritha on 02-Feb-2018 Feneral Plan(207) Dependant save Record inserted &updated null error as per siva sir sugg.*/
	private String POL_OLD_ASSRD_REF_ID;

	public String getPOL_OLD_ASSRD_REF_ID() {
		return POL_OLD_ASSRD_REF_ID;
	}
	public void setPOL_OLD_ASSRD_REF_ID(String pOL_OLD_ASSRD_REF_ID) {
		POL_OLD_ASSRD_REF_ID = pOL_OLD_ASSRD_REF_ID;
	}
	/*End*/
	
	/*Added by Ameen on 09-03-2018 for FSD_IL_04_GOLDA*/
	//@Column(name="POL_REG_EXCESS_PREM")
	@Column(name="POL_REG_EXS_LC_PREM")
	private Double POL_REG_EXCESS_PREM;
	
	@Column(name="POL_RETURN_VAL")
	private String POL_RETURN_VAL;

	public Double getPOL_REG_EXCESS_PREM() {
		return POL_REG_EXCESS_PREM;
	}
	public void setPOL_REG_EXCESS_PREM(Double pOL_REG_EXCESS_PREM) {
		POL_REG_EXCESS_PREM = pOL_REG_EXCESS_PREM;
	}
	public String getPOL_RETURN_VAL() {
		return POL_RETURN_VAL;
	}
	public void setPOL_RETURN_VAL(String pOL_RETURN_VAL) {
		POL_RETURN_VAL = pOL_RETURN_VAL;
	}
	
	private Double UI_M_POL_REG_EXCESS_PREM;

	public Double getUI_M_POL_REG_EXCESS_PREM() {
		return UI_M_POL_REG_EXCESS_PREM;
	}
	public void setUI_M_POL_REG_EXCESS_PREM(Double uI_M_POL_REG_EXCESS_PREM) {
		UI_M_POL_REG_EXCESS_PREM = uI_M_POL_REG_EXCESS_PREM;
	}

	/*End*/
	
	/*Added by saritha on 23-03-2018 for KIC In Terma plus in premium calculation screen show LC SA and FC SA*/
	private String POL_LC_SUM_ASSURED_STR;

	public String getPOL_LC_SUM_ASSURED_STR() {
		return POL_LC_SUM_ASSURED_STR;
	}
	public void setPOL_LC_SUM_ASSURED_STR(String pOL_LC_SUM_ASSURED_STR) {
		POL_LC_SUM_ASSURED_STR = pOL_LC_SUM_ASSURED_STR;
	}
	/*End*/
	
	/*added by Ameen on 24-03-2018 for KIC onsite issue*/
	
	
	@Column(name="POL_CVV_NO")
	private Integer POL_CVV_NO;

	public Integer getPOL_CVV_NO() {
		return POL_CVV_NO;
	}
	public void setPOL_CVV_NO(Integer pOL_CVV_NO) {
		POL_CVV_NO = pOL_CVV_NO;
	}

	/*end*/
	
	/*Added by Janani on 26.03.2018 for KIC Credit card issue*/

	private String POL_CARD_EXP_DT_MM;
	
	private String POL_CARD_EXP_DT_YY;
	
	@Column(name="POL_CARD_EXP_DT")
	private String POL_CARD_EXP_DT;
	
	public String getPOL_CARD_EXP_DT() {
		return POL_CARD_EXP_DT;
	}
	public void setPOL_CARD_EXP_DT(String pOL_CARD_EXP_DT) {
		POL_CARD_EXP_DT = pOL_CARD_EXP_DT;
	}
	public String getPOL_CARD_EXP_DT_MM() {
		return POL_CARD_EXP_DT_MM;
	}
	public void setPOL_CARD_EXP_DT_MM(String pOL_CARD_EXP_DT_MM) {
		POL_CARD_EXP_DT_MM = pOL_CARD_EXP_DT_MM;
	}
	public String getPOL_CARD_EXP_DT_YY() {
		return POL_CARD_EXP_DT_YY;
	}
	public void setPOL_CARD_EXP_DT_YY(String pOL_CARD_EXP_DT_YY) {
		POL_CARD_EXP_DT_YY = pOL_CARD_EXP_DT_YY;
	}
	
	/*end*/
	
	/*Added by Ameen on 13-07-2018 for TOI as per Ajay sugg.*/
	private String UI_M_POBH_BROKER_CODE;
	
	private String UI_M_POBH_BROKER_CODE_DESC;

	public String getUI_M_POBH_BROKER_CODE() {
		return UI_M_POBH_BROKER_CODE;
	}
	public void setUI_M_POBH_BROKER_CODE(String uI_M_POBH_BROKER_CODE) {
		UI_M_POBH_BROKER_CODE = uI_M_POBH_BROKER_CODE;
	}
	public String getUI_M_POBH_BROKER_CODE_DESC() {
		return UI_M_POBH_BROKER_CODE_DESC;
	}
	public void setUI_M_POBH_BROKER_CODE_DESC(String uI_M_POBH_BROKER_CODE_DESC) {
		UI_M_POBH_BROKER_CODE_DESC = uI_M_POBH_BROKER_CODE_DESC;
	}
	
	/*End*/

	//added by gopi for toi on 27/07/2018
	@Column(name="pol_flex_31")
	private String pol_flex_31;
	
	public String getPol_flex_31() {
		return pol_flex_31;
	}
	public void setPol_flex_31(String pol_flex_31) {
		this.pol_flex_31 = pol_flex_31;
	}
	
	//end
	
	/*added by Ameen on 31-07-2018 to hide premimum payabel field*/
	private boolean UI_M_PREM_HIDE;

	public boolean isUI_M_PREM_HIDE() {
		return UI_M_PREM_HIDE;
	}
	public void setUI_M_PREM_HIDE(boolean uI_M_PREM_HIDE) {
		UI_M_PREM_HIDE = uI_M_PREM_HIDE;
	}

	/*end*/

	/*Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018 (FSD_IL_FLA_009)*/
	
	private double PDU_DEP_AMT;
	
	private double PDU_UTIL_AMT;

	public double getPDU_DEP_AMT() {
		return PDU_DEP_AMT;
	}
	public void setPDU_DEP_AMT(double pDU_DEP_AMT) {
		PDU_DEP_AMT = pDU_DEP_AMT;
	}
	public double getPDU_UTIL_AMT() {
		return PDU_UTIL_AMT;
	}
	public void setPDU_UTIL_AMT(double pDU_UTIL_AMT) {
		PDU_UTIL_AMT = pDU_UTIL_AMT;
	}
	
	private double UI_M_PDU_SUS_AMT;
	
	public double getUI_M_PDU_SUS_AMT() {
		return UI_M_PDU_SUS_AMT;
	}
	public void setUI_M_PDU_SUS_AMT(double uI_M_PDU_SUS_AMT) {
		UI_M_PDU_SUS_AMT = uI_M_PDU_SUS_AMT;
	}
		
	
	/*End Fidelity feature taken for kic added by Pidugu Raj on 20-09-2018 (FSD_IL_FLA_009)*/
	
	/*added by Ameen on 21-10-2019 for SARWA Retirement product*/
	@Column(name="POL_CASHBACK_YN")
	private String POL_CASHBACK_YN;
	
	@Column(name="POL_BNF_ESC_YN")
	private String POL_BNF_ESC_YN;
	
	@Column(name="POL_ADHOC_PREM_YN")
	private String POL_ADHOC_PREM_YN;
	
	@Column(name="POL_ADHOC_LC_PREM")
	private Double POL_ADHOC_LC_PREM;
	
	@Column(name="POL_CASHBACK_PREC")
	private Integer POL_CASHBACK_PREC;
	
	@Column(name="POL_CASHBACK_ST_YR")
	private Integer POL_CASHBACK_ST_YR;

	public String getPOL_CASHBACK_YN() {
		return POL_CASHBACK_YN;
	}
	public void setPOL_CASHBACK_YN(String pOL_CASHBACK_YN) {
		POL_CASHBACK_YN = pOL_CASHBACK_YN;
	}
	public String getPOL_BNF_ESC_YN() {
		return POL_BNF_ESC_YN;
	}
	public void setPOL_BNF_ESC_YN(String pOL_BNF_ESC_YN) {
		POL_BNF_ESC_YN = pOL_BNF_ESC_YN;
	}
	public String getPOL_ADHOC_PREM_YN() {
		return POL_ADHOC_PREM_YN;
	}
	public void setPOL_ADHOC_PREM_YN(String pOL_ADHOC_PREM_YN) {
		POL_ADHOC_PREM_YN = pOL_ADHOC_PREM_YN;
	}
	public Double getPOL_ADHOC_LC_PREM() {
		return POL_ADHOC_LC_PREM;
	}
	public void setPOL_ADHOC_LC_PREM(Double pOL_ADHOC_LC_PREM) {
		POL_ADHOC_LC_PREM = pOL_ADHOC_LC_PREM;
	}
	public Integer getPOL_CASHBACK_PREC() {
		return POL_CASHBACK_PREC;
	}
	public void setPOL_CASHBACK_PREC(Integer pOL_CASHBACK_PREC) {
		POL_CASHBACK_PREC = pOL_CASHBACK_PREC;
	}
	public Integer getPOL_CASHBACK_ST_YR() {
		return POL_CASHBACK_ST_YR;
	}
	public void setPOL_CASHBACK_ST_YR(Integer pOL_CASHBACK_ST_YR) {
		POL_CASHBACK_ST_YR = pOL_CASHBACK_ST_YR;
	}
	
	/*End*/
}

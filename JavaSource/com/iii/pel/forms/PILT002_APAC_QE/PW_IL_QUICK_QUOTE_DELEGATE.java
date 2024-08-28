package com.iii.pel.forms.PILT002_APAC_QE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PRODUCT;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_APPL_COVER;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_APPL_LOAD_TARIFF;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_CONSTANTS;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ADDL_COVER;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_CHARGE;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_QUICK_QUOTE_DELEGATE {
	PW_IL_QUICK_QUOTE_HELPER helper = new PW_IL_QUICK_QUOTE_HELPER();
	public Long SYSID;
	public void executeQuery(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception {

		String FETCH_QUERY = "SELECT PW_IL_QUICK_QUOTE.*,PW_IL_QUICK_QUOTE.ROWID FROM PW_IL_QUICK_QUOTE WHERE ROWID = ? ";
		String FETH_DTLS="SELECT PW_IL_QQUOT_ASSURED_DTLS.*,ROWID FROM PW_IL_QQUOT_ASSURED_DTLS WHERE QQAD_QUOT_SYS_ID= ?";
		String FETCH_QUERY1 = "SELECT PW_IL_QUICK_QUOTE.*,PW_IL_QUICK_QUOTE.ROWID FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID  = ?  AND QUOT_IDX_NO = ? ";
		String FETCH_BROCKER ="SELECT QQBD_RATE, QQBD_RATE_PER  FROM PW_IL_QQUOT_BROK_HDR,PW_IL_QQUOT_BROK_DTL  WHERE QQBD_QQBH_SYS_ID = QQBH_SYS_ID   AND QQBH_QUOT_SYS_ID = ?";
		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN  = new PW_IL_QUICK_QUOTE();
		PW_IL_QQUOT_ASSURED_DTLS PW_IL_QUICK_QUOTE_DTLS_BEAN = new PW_IL_QQUOT_ASSURED_DTLS();
		PW_IL_QQUOT_BROK_DTL PW_IL_QQUOT_BROK_DTL_BEAN = new PW_IL_QQUOT_BROK_DTL();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();

		ResultSet resultSet = null;
		ResultSet resultSet_dtls = null;
		ResultSet resultSet_brk = null;


		try {
			 
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getROWID() != null) {
				resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY, CommonUtils.getConnection(),
						new Object[] {compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getROWID()});
			}else {
				resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY1, CommonUtils.getConnection(),
						new Object[] {compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID(),
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_IDX_NO()});
			}
			if (resultSet.next()) {

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_EMR_RATE(resultSet.getDouble("QUOT_EMR_RATE"));

				PW_IL_QUICK_QUOTE_BEAN.setROWID(resultSet.getString("ROWID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SYS_ID(resultSet.getLong("QUOT_SYS_ID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_DT(resultSet.getDate("QUOT_CR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(resultSet.getString("QUOT_CR_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_DT(resultSet.getDate("QUOT_UPD_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MOP(resultSet.getString("QUOT_MOP"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT(resultSet.getTimestamp("QUOT_ISS_DT"));//added by dhinesh for FALCONLIFE-1349311 on 17-10-16
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(resultSet.getDate("QUOT_FM_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(resultSet.getDate("QUOT_TO_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_VALID_DT(resultSet.getDate("QUOT_VALID_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LOAN_TYPE(resultSet.getString("QUOT_LOAN_TYPE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DIVN_CODE(resultSet.getString("QUOT_DIVN_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UW_YEAR(resultSet.getString("QUOT_UW_YEAR"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE(resultSet.getString("QUOT_PROD_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ASSRD_REF_ID1(resultSet.getString("QUOT_ASSRD_REF_ID1"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE(resultSet.getString("QUOT_CUST_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE(resultSet.getString("QUOT_CUST_TITLE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(resultSet.getString("QUOT_CUST_NAME"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_SURNAME(resultSet.getString("QUOT_CUST_SURNAME"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SO_CODE(resultSet.getString("QUOT_SO_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SM_CODE(resultSet.getString("QUOT_SM_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CONV_YN(resultSet.getString("QUOT_CONV_YN"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_CODE(resultSet.getString("QUOT_BANK_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_DIVN(resultSet.getString("QUOT_BANK_DIVN"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_ACNT(resultSet.getString("QUOT_BANK_ACNT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN(resultSet.getString("QUOT_MED_YN"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PLAN_CODE(resultSet.getString("QUOT_PLAN_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ORG_COMM_RATE(resultSet.getDouble("QUOT_ORG_COMM_RATE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ORG_BROK_CODE(resultSet.getString("QUOT_ORG_BROK_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(resultSet.getDouble("QUOT_COMM_VALUE"));

				/*Added by Ram on 20/11/2016 for BankCode value setting*/
				ResultSet C1_REC = null;
				String C1 = "SELECT BANK_CODE,BANK_NAME   FROM   FM_BANK   WHERE  BANK_CODE = ?";
				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_CODE()!=null){
					C1_REC = new CRUDHandler().executeSelectStatement(C1, CommonUtils.getConnection(),new Object[]{PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_CODE()});
					if (C1_REC.next()) {
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_CODE_ORI(C1_REC.getString("BANK_CODE"));
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_CODE(C1_REC.getString("BANK_NAME"));
					}
				}
/*End*/
				/*Added by Ram on 20/11/2016 for Remarks value setting*/
				if(resultSet.getInt("QUOT_MED_REC_YN") == 1)
				{
					PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK(true);
				}
				else
				{
					PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK(false);
				}
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REMARKS(resultSet.getString("QUOT_MED_REMARKS"));
				/*End*/
				
				/*	if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_CODE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(false);
				}*/
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_TITLE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(false);
				}
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_NAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(false);
				}
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_SURNAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(true);
				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(false);
				}

				//gender

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_SA(resultSet.getDouble("QUOT_FC_SA"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PERIOD(resultSet.getInt("QUOT_PERIOD"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS(resultSet.getInt("QUOT_PREM_PAY_YRS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_BUS(resultSet.getString("QUOT_SRC_BUS"));

				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equalsIgnoreCase("075"))
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_SRC_CODE().setRequired(true);
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_SRC_CODE().setDisabled(false);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_SRC_CODE().setRequired(false);
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_SRC_CODE().setDisabled(true);
				}



				pValList = PKG_PILT002_APAC_QE.P_VAL_CODES("SRC_BUS_TY", PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS(),
						PW_IL_QUICK_QUOTE_BEAN.getUI_QUOT_SRC_BUS_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);

				PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_SRC_BUS_DESC(pValList.get(0)
						.getValue());



				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_CODE(resultSet.getString("QUOT_SRC_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NO(resultSet.getString("QUOT_NO"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(resultSet.getInt("QUOT_IDX_NO"));


				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_TYPE(resultSet.getString("QUOT_DS_TYPE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_CODE(resultSet.getString("QUOT_DS_CODE"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR1(resultSet.getString("QUOT_CUST_ADDR1"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR2(resultSet.getString("QUOT_CUST_ADDR2"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR3(resultSet.getString("QUOT_CUST_ADDR3"));


				/*if(resultSet.getString("QUOT_CUST_ADDR")!=null){

					if(resultSet.getString("QUOT_CUST_ADDR").contains(",")){

						String addr[]=resultSet.getString("QUOT_CUST_ADDR").split(",");




						for(int i=0;i<addr.length;i++)
						{
							if(i==0)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR(addr[i]);
							else if(i==1)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_Address2(addr[i]);
							else if(i==2)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_Address3(addr[i]);
						}
					}

				}else{

					PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR(resultSet.getString("QUOT_CUST_ADDR"));
				}*/

				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CITY(resultSet.getString("QUOT_CUST_CITY"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_STATE(resultSet.getString("QUOT_CUST_STATE"));
				//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PO(resultSet.getString("QUOT_CUST_PO"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PHONE(resultSet.getString("QUOT_CUST_PHONE"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CONTACT(resultSet.getString("QUOT_CUST_CONTACT"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_MAIL_ID(resultSet.getString("QUOT_CUST_MAIL_ID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_SA(resultSet.getDouble("QUOT_LC_SA"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FRZ_RATE(resultSet.getString("QUOT_FRZ_RATE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_STATUS(resultSet.getString("QUOT_STATUS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS(resultSet.getString("QUOT_APPR_STS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_DT(resultSet.getDate("QUOT_APPR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_UID(resultSet.getString("QUOT_APPR_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_UID(resultSet.getString("QUOT_UPD_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_PREM(resultSet.getDouble("QUOT_LC_PREM"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_PREM(resultSet.getDouble("QUOT_FC_PREM"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(resultSet.getString("QUOT_CLASS_CODE"));
				
				
				/*Added by Shankar for dynamic report config on 07.10.2016*/
				
				CommonUtils.setGlobalVariable("GLOBAL.QE_QUOT_PROD_CODE",PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());
				CommonUtils.setGlobalVariable("GLOBAL_PILT002_APAC_QE_DS_TYPE", PW_IL_QUICK_QUOTE_BEAN.getQUOT_DS_TYPE());
				CommonUtils.setGlobalVariable("PILT002_APAC_QE_QUOT_STATUS", PW_IL_QUICK_QUOTE_BEAN.getQUOT_STATUS());
				CommonUtils.setGlobalVariable("PILT002_APAC_QE_QUOT_APROVE_STATUS", PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS());
				
				
				/*end*/
				/*Added by Ram on 15/12/2016 for defaulting Medical Remarks field*/
				System.out.println("resultSet.getString(QUOT_MED_YN)     "+resultSet.getString("QUOT_MED_YN"));
				if(resultSet.getString("QUOT_MED_YN") != null && resultSet.getString("QUOT_MED_YN").equals("Y"))
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REC_YN_CHK().setDisabled(false);
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REMARKS().setDisabled(false);
					 
				}
				/*End*/
			}
			
			/*Added by Ram on 04/12/2016 for display Commision value*/
			System.out.println("getQUOT_SYS_ID  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());
			ResultSet commisionResultset = null;
			/*
			 * commented by Ameen on 10-04-2017 as per Chandra Mohan sugg.
			 * String commisionQuery = "SELECT  ROUND((SELECT (QUOT_COMM_VALUE * (PMOP_RATE / PMOP_RATE_PER)) FROM PM_IL_PLAN_MOP WHERE PMOP_PLAN_CODE = QUOT_PLAN_CODE "
					+ "AND PMOP_TYPE = QUOT_MOP),CURR_DECIMAL) QUOT_COMM_VALUE FROM PW_IL_QUICK_QUOTE, PW_IL_QQUOT_ASSURED_DTLS, PM_CURRENCY "
					+ "WHERE QQAD_QUOT_SYS_ID = QUOT_SYS_ID AND QUOT_IDX_NO = ? AND QUOT_SYS_ID = ? AND QUOT_CUST_CURR_CODE = CURR_CODE";*/
			
			/*Added by Ameen on 10-04-2017 as per Chandra Mohan sugg */
			String commisionQuery = "SELECT ROUND(QUOT_COMM_VALUE,CURR_DECIMAL) QUOT_COMM_VALUE FROM PW_IL_QUICK_QUOTE, PW_IL_QQUOT_ASSURED_DTLS, PM_CURRENCY "
					+ "WHERE QQAD_QUOT_SYS_ID = QUOT_SYS_ID AND QUOT_IDX_NO = ? AND QUOT_SYS_ID = ? AND QUOT_CUST_CURR_CODE = CURR_CODE";
			/*End*/
			
			commisionResultset = new CRUDHandler().executeSelectStatement(commisionQuery, CommonUtils.getConnection(),
					new Object[]{
				PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO(),
				PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()
				});
			
			System.out.println("getQUOT_IDX_NO       "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_IDX_NO()
					+"   getQUOT_SYS_ID   "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID());
			
			while(commisionResultset.next())
			{
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(commisionResultset.getDouble("QUOT_COMM_VALUE"));
			}
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_COMM_VALUE      "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_COMM_VALUE());
			/*End*/
			
			System.out.println("sysout for rsdt  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());
			resultSet_dtls = new CRUDHandler().executeSelectStatement(FETH_DTLS, CommonUtils.getConnection(),
					new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});
			if(resultSet_dtls.next()){
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_SYS_ID(resultSet_dtls.getLong("QQAD_SYS_ID"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_QUOT_SYS_ID(resultSet_dtls.getLong("QQAD_QUOT_SYS_ID"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_DOB(resultSet_dtls.getDate("QQAD_ASSR_DOB"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CATG_CODE(resultSet_dtls.getString("QQAD_CATG_CODE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_AGE(resultSet_dtls.getInt("QQAD_AGE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_DT(resultSet_dtls.getDate("QQAD_CR_DT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_UID(resultSet_dtls.getString("QQAD_CR_UID"));

				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_CODE(resultSet_dtls.getString("QQAD_ASSR_CODE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSURED_NAME(resultSet_dtls.getString("QQAD_ASSURED_NAME"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_HEIGHT(resultSet_dtls.getDouble("QQAD_HEIGHT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_WEIGHT(resultSet_dtls.getDouble("QQAD_WEIGHT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_BMI(resultSet_dtls.getDouble("QQAD_BMI"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ADDRESSS(resultSet_dtls.getString("QQAD_ADDRESSS"));

				PW_IL_QUICK_QUOTE_DTLS_BEAN.setROWID(resultSet_dtls.getString("ROWID"));
				/*Added by Ram on 21/01/2017 for Capturing Praganacy field*/
				System.out.println("resultSet_dtls.getString(QUOT_PRAGANENT_YN)     "+resultSet_dtls.getString("QUOT_PRAGANENT_YN"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQUOT_PRAGANENT_YN(resultSet_dtls.getString("QUOT_PRAGANENT_YN"));
				/*End*/

			}
			System.out.println("dtld sys id  "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_QUOT_SYS_ID());
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QUICK_QUOTE_BEAN(PW_IL_QUICK_QUOTE_BEAN);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QUICK_QUOTE_DTLS_BEAN(PW_IL_QUICK_QUOTE_DTLS_BEAN);

			/*Added by Ram on 21/01/2017 for Praganancy field validation*/
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().enablePraganacyField();
			/*End*/

			//add cover data table

			List<PW_IL_QQUOT_APPL_COVER> COVER_LIST = new ArrayList<PW_IL_QQUOT_APPL_COVER>();
			System.out.println("loadeCoverdatatable");
			/*Edited By jagadeesh For the Field EMR Rate*/

			/*String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE"
					+ " FROM (SELECT ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,"
					+ "QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER "
					+ "CVR_RT_TYP,QUOT_FC_PREM CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID = ? UNION ALL SELECT ROWID ROW_ID,"
					+ " 'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, QQAC_EFF_FM_DT "
					+ "CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE,"
					+ "QQAC_RATE_PER CVR_RT_TYP,QQAC_PREM_LC CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE   FROM PW_IL_QQUOT_APPL_COVER  "
					+ "WHERE QQAC_QUOT_SYS_ID = ?) ORDER BY CVR_TYP DESC";*/

			/*String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC "
					+ " FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA, "
					+ " QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER  "
					+ " CVR_RT_TYP,QUOT_FC_PREM CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC "
					+ " FROM PW_IL_QUICK_QUOTE,PM_IL_COVER WHERE QUOT_SYS_ID = ? "
					+ " AND QUOT_PLAN_CODE = COVER_CODE "
					+ " UNION ALL "
					+ " SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID, "
					+ " 'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, QQAC_EFF_FM_DT " 
					+ " CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE, "
					+ " QQAC_RATE_PER CVR_RT_TYP,QQAC_PREM_LC CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC " 
					+ " FROM PW_IL_QQUOT_APPL_COVER,PM_IL_COVER  "
					+ " WHERE QQAC_QUOT_SYS_ID = ? AND QQAC_COVER_CODE = COVER_CODE) ORDER BY CVR_TYP DESC";*/


			/*END*/

			/*Changed by Ram & Kuzhandai on 17/058/2016 for SSP call id FALCONQC-1715774 
			String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_APPLIED_ON,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC"
					+ " FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID,'S' CVR_APPLIED_ON, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,"
					+ " QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER CVR_RT_TYP,"
					+ "( QUOT_FC_PREM * (SELECT PMOP_RATE/PMOP_RATE_PER FROM PM_IL_PLAN_MOP ,PW_IL_QUICK_QUOTE"
					+ " WHERE PMOP_PLAN_CODE =(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) "
					+ "AND PMOP_TYPE =QUOT_MOP AND QUOT_SYS_ID = ?)) CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC FROM PW_IL_QUICK_QUOTE,PM_IL_COVER WHERE QUOT_SYS_ID = ? "
					+ "AND QUOT_PLAN_CODE = COVER_CODE "
					+ "UNION ALL "
					+ "SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_RATE_APPLIED_ON CVR_APPLIED_ON,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA,"
					+ " QQAC_EFF_FM_DT CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE, QQAC_RATE_PER CVR_RT_TYP, "
					+ "(QQAC_PREM_LC *(SELECT PMOP_RATE/PMOP_RATE_PER FROM PM_IL_PLAN_MOP ,PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE ="
					+ "(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE =QUOT_MOP AND QUOT_SYS_ID = ?)) "
					+ " CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC FROM PW_IL_QQUOT_APPL_COVER,PM_IL_COVER"
					+ " WHERE QQAC_QUOT_SYS_ID = ? AND QQAC_COVER_CODE = COVER_CODE) ORDER BY CVR_TYP DESC";

			/*End*/
			
			/*Changed by Ram & Kuzhandai on 21/11/2016 for Cover Sequencing Order */
			/*Modified by Ram on 21/12/2016 for displaying values in roundoff
			 * 
			 * String selectStatement =       
"SELECT ROW_ID,CVR_SYS_ID,CVR_APPLIED_ON,CVR_CODE,CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE, "+
"COVER_DESC,COVER_DISP_SEQ FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id,'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID,'S' CVR_APPLIED_ON, "+
"QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT,QUOT_BASIC_RATE CVR_RATE, "+
"QUOT_BASIC_RATE_PER CVR_RT_TYP,(QUOT_FC_PREM * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE "+
"WHERE PMOP_PLAN_CODE =(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP "+
"AND QUOT_SYS_ID = ?)) CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC , 0 \"COVER_DISP_SEQ\" FROM PW_IL_QUICK_QUOTE, PM_IL_COVER "+
"WHERE QUOT_SYS_ID = ? AND QUOT_PLAN_CODE = COVER_CODE  "+
"UNION ALL "+
"SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_RATE_APPLIED_ON CVR_APPLIED_ON,QQAC_COVER_CODE CVR_CODE, "+
"QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA,QQAC_EFF_FM_DT CVR_START_DT,QQAC_EFF_TO_DT CVR_END_DT,QQAC_RATE CVR_RATE,QQAC_RATE_PER CVR_RT_TYP, "+
"(QQAC_PREM_LC * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE "+
"FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?)) CVR_PREM, "+
"QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC , PAC_CVR_SR_NO \"COVER_DISP_SEQ\" FROM PW_IL_QQUOT_APPL_COVER, PM_IL_COVER , "+
"PW_IL_QUICK_QUOTE, PM_IL_PROD_APPL_COVER WHERE  QUOT_SYS_ID = QQAC_QUOT_SYS_ID AND QUOT_PROD_CODE = PAC_PROD_CODE "+
"AND QQAC_COVER_CODE = PAC_COVER_CODE AND QQAC_QUOT_SYS_ID = ? AND COVER_CODE = QQAC_COVER_CODE) "+
"ORDER BY COVER_DISP_SEQ  ";*/
			
			String selectStatement =       
					"SELECT ROW_ID,CVR_SYS_ID,CVR_APPLIED_ON,CVR_CODE,CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE, "+
					"COVER_DESC,COVER_DISP_SEQ FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id,'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID,'S' CVR_APPLIED_ON, "+
					"QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT,QUOT_BASIC_RATE CVR_RATE, "+
					"QUOT_BASIC_RATE_PER CVR_RT_TYP,ROUND((QUOT_FC_PREM * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE "+
					"WHERE PMOP_PLAN_CODE =(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP "+
					"AND QUOT_SYS_ID = ?)),1) CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC , 0 \"COVER_DISP_SEQ\" FROM PW_IL_QUICK_QUOTE, PM_IL_COVER "+
					"WHERE QUOT_SYS_ID = ? AND QUOT_PLAN_CODE = COVER_CODE  "+
					"UNION ALL "+
					"SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_RATE_APPLIED_ON CVR_APPLIED_ON,QQAC_COVER_CODE CVR_CODE, "+
					"QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA,QQAC_EFF_FM_DT CVR_START_DT,QQAC_EFF_TO_DT CVR_END_DT,QQAC_RATE CVR_RATE,QQAC_RATE_PER CVR_RT_TYP, "+
					"ROUND((QQAC_PREM_LC * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE "+
					"FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?)),1) CVR_PREM, "+
					"QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC , PAC_CVR_SR_NO \"COVER_DISP_SEQ\" FROM PW_IL_QQUOT_APPL_COVER, PM_IL_COVER , "+
					"PW_IL_QUICK_QUOTE, PM_IL_PROD_APPL_COVER WHERE  QUOT_SYS_ID = QQAC_QUOT_SYS_ID AND QUOT_PROD_CODE = PAC_PROD_CODE "+
					"AND QQAC_COVER_CODE = PAC_COVER_CODE AND QQAC_QUOT_SYS_ID = ? AND COVER_CODE = QQAC_COVER_CODE) "+
					"ORDER BY COVER_DISP_SEQ  ";

			/*End*/
			
			//Connection connection = null;
			ResultSet cresultSet = null;
			SYSID =PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID();

			try {
				//connection = CommonUtils.getConnection();
				cresultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, CommonUtils.getConnection(), new Object[] { SYSID,SYSID, SYSID,SYSID });

				while (cresultSet.next()) {
					System.out.println("resultSet");
					PW_IL_QQUOT_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_COVER_CODE(cresultSet
							.getString("CVR_CODE"));

					PM_IL_PROD_APPL_COVER_BEAN.setCOVER_DESC(cresultSet
							.getString("COVER_DESC"));
					
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE_APPLIED_ON(cresultSet
							.getString("CVR_APPLIED_ON"));
					
					System.out.println("COVER_DESC           "+cresultSet
							.getString("COVER_DESC"));
					ResultSet rs1 = null;

					String c2=" SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE= ?";

					Object[] c2values = { PM_IL_PROD_APPL_COVER_BEAN.getQQAC_COVER_CODE() };
					rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
					while (rs1.next()) {
						PM_IL_PROD_APPL_COVER_BEAN.setUI_M_QQAT_COVER_DESC(rs1.getString("COVER_DESC"));
					}

					String mand="SELECT PAC_MANDATORY_YN FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ? ";

					Object[] mandvalues = { compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PROD_CODE(),PM_IL_PROD_APPL_COVER_BEAN.getQQAC_COVER_CODE() };

					ResultSet rs2= new CRUDHandler().executeSelectStatement(mand, CommonUtils.getConnection(), mandvalues);

					while (rs2.next()) {
						PM_IL_PROD_APPL_COVER_BEAN.setUI_M_QQAT_MAND_YN(rs2.getString("PAC_MANDATORY_YN"));
					}

					PM_IL_PROD_APPL_COVER_BEAN.setROWID(cresultSet
							.getString("ROW_ID"));
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_SYS_ID(cresultSet
							.getLong("CVR_SYS_ID"));
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(cresultSet
							.getLong("CVR_SYS_ID"));
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QUOT_SYS_ID(SYSID);
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(SYSID);
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PERIOD(cresultSet
							.getInt("CVR_TERM"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_FC_SA(cresultSet
							.getDouble("CVR_SA"));


					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

					if(cresultSet
							.getDate("CVR_START_DT") != null)
					{
						String FM = simpleDateFormat.format(cresultSet
								.getDate("CVR_START_DT"));
						PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_FM_DT(FM);
					}

					if(cresultSet
							.getDate("CVR_END_DT") != null)
					{
						String TO = simpleDateFormat.format(cresultSet
								.getDate("CVR_END_DT"));




						PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_TO_DT(TO);
					}

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE(cresultSet
							.getDouble("CVR_RATE"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE_PER(cresultSet
							.getInt("CVR_RT_TYP"));

					String aString = Double.toString(cresultSet
							.getDouble("CVR_PREM"));
					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_PREM_LC(CommonUtils.Decimal_Convert(aString));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PREM_LC(cresultSet
							.getDouble("CVR_PREM"));

					/*Added By jagadeesh For the Field EMR Rate*/

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_EMR_RATE(cresultSet
							.getDouble("CVR_EMR_RATE"));

					String emr =Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_EMR_RATE());

					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_EMR_RATE(CommonUtils.Decimal_Convert(emr));


					/*END*/

					String sumass =Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_FC_SA());
					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_FC_SA(CommonUtils.Decimal_Convert(sumass));
					String AMT = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_PREM_LC());
					String RATE = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_RATE());
					//String RATEPER = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_RATE_PER());
					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_PREM_LC(CommonUtils.Decimal_Convert(AMT));

					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_RATE(CommonUtils.Decimal_Convert(RATE));
					PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_FC_SA(CommonUtils.Decimal_Convert(sumass));

					// PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_RATE_PER(Decimal_Convert(RATEPER));

					/*  PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PREM_LC(Double.parseDouble(Decimal_Convert(aString)));*/


					COVER_LIST.add(PM_IL_PROD_APPL_COVER_BEAN);

				}


			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				CommonUtils.closeCursor(cresultSet);

			}
			System.out.println("COVER_LIST");
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PM_IL_PROD_APPL_COVER(COVER_LIST);
			System.out.println("compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER()   "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER());
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER().size() > 1) {
				PW_IL_QQUOT_APPL_COVER cover_BEAN =compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER()
						.get(1);
				cover_BEAN.setRowSelected(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_APPL_COVER_BEAN(cover_BEAN);
				/*compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
					.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
							PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);*/
			}
			//end
			//debit/credit dtata table 
			System.out.println("loding dt");
			List<PW_IL_QQUOT_DISC_LOAD> TARIFF_LIST = new ArrayList<PW_IL_QQUOT_DISC_LOAD>();
			//Long rowid=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

			String dselectStatement = "SELECT PW_IL_QQUOT_DISC_LOAD.ROWID,PW_IL_QQUOT_DISC_LOAD.* FROM PW_IL_QQUOT_DISC_LOAD WHERE QQDL_QUOT_SYS_ID = ?";


			ResultSet dresultSet = null;

			try {
				//	connection = CommonUtils.getConnection();
				dresultSet = new CRUDHandler().executeSelectStatement(
						dselectStatement, CommonUtils.getConnection(), new Object[]{SYSID});
				System.out.println("rst");
				while (dresultSet.next()) {

					PW_IL_QQUOT_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();

					PT_IL_POL_DISC_LOAD_BEAN.setROWID(dresultSet
							.getString("ROWID"));



					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_SYS_ID(dresultSet
							.getLong("QQDL_SYS_ID"));

					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_COVER_CODE(dresultSet
							.getString("QQDL_COVER_CODE"));


					ResultSet rs1 = null;

					String c2=" SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE= ?";

					Object[] c2values = { PT_IL_POL_DISC_LOAD_BEAN.getQQDL_COVER_CODE() };
					rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
					while (rs1.next()) {
						PT_IL_POL_DISC_LOAD_BEAN.setUI_M_QQDL_COVER_DESC(rs1.getString("COVER_DESC"));
					}



					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_QUOT_SYS_ID(dresultSet
							.getLong("QQDL_QUOT_SYS_ID"));

					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE(dresultSet
							.getString("QQDL_DISC_LOAD_TYPE"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_CODE(dresultSet
							.getString("QQDL_DISC_LOAD_CODE"));


					if("D".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){
						ResultSet rs1l = null;
						String discount="IL_DISC";
						String c2l="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE ='"+discount+"' AND PC_CODE= ?";

						Object[] c2lvalues = { PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };

						rs1l= new CRUDHandler().executeSelectStatement(c2l, CommonUtils.getConnection(), c2lvalues);
						while (rs1l.next()) {
							PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1l.getString("PC_DESC"));
						}


					}else if("L".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){

						ResultSet rs1d = null;
						String loading="IL_LOAD";
						String c2d="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE ='"+loading+"' AND PC_CODE= ?";
						System.out.println("c2d         "+c2d);
						Object[] c2dvalues = {PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };
						rs1d= new CRUDHandler().executeSelectStatement(c2d, CommonUtils.getConnection(), c2dvalues);
						while (rs1d.next()) {
							PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1d.getString("PC_DESC"));
						}

					}


					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_APPLIED_ON(dresultSet
							.getString("QQDL_APPLIED_ON"));

					if ("3".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
							|| "6".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
							|| "7".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
							|| "8".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
							|| "9".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
							|| "10".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())) {
						compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setDisabled(false);
						compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setRequired(true);
						/*if (loadBean.getPDL_COVER_CODE() == null) {
							PDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
						}*/
					} else {
						compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setDisabled(true);
					}


					PT_IL_POL_DISC_LOAD_BEAN.setUI_M_APPLIED_ON_DESC(helper.getdisappondesc(dresultSet
							.getString("QQDL_APPLIED_ON")));


					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE(dresultSet
							.getDouble("QQDL_RATE"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE_PER(dresultSet
							.getInt("QQDL_RATE_PER"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_FC_DISC_LOAD_AMT(dresultSet
							.getDouble("QQDL_FC_DISC_LOAD_AMT"));

					String rate_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_RATE());
					//	String rate_per_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_RATE_PER());
					String amt_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_FC_DISC_LOAD_AMT());


					PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_RATE(CommonUtils.Decimal_Convert(rate_debit));
					//	PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_RATE_PER(Decimal_Convert(rate_per_debit));
					PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_FC_DISC_LOAD_AMT(CommonUtils.Decimal_Convert(amt_debit));

					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_SRNO(dresultSet.getInt("QQDL_SRNO"));


					TARIFF_LIST.add(PT_IL_POL_DISC_LOAD_BEAN);

				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				CommonUtils.closeCursor(dresultSet);


			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PT_IL_POL_DISC_LOAD(TARIFF_LIST);
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD() .size() > 0) {
				PW_IL_QQUOT_DISC_LOAD DIS_BEAN = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD()
						.get(0);
				DIS_BEAN.setRowSelected(true);

				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_DISC_LOAD_BEAN(DIS_BEAN);
				/*compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);*/
			}

			//end



			//start charge

			List<PW_IL_QQUOT_APPL_CHARGE> chargeList = new ArrayList<PW_IL_QQUOT_APPL_CHARGE>();
			/*String GselectStatement = "SELECT PW_IL_QQUOT_APPL_CHARGE.ROWID,PW_IL_QQUOT_APPL_CHARGE.* FROM PW_IL_QQUOT_APPL_CHARGE WHERE QQAC_QUOT_SYS_ID = ?";*/
			
			String GselectStatement = "SELECT PW_IL_QQUOT_APPL_CHARGE.ROWID,(QQAC_FC_CHRG_AMT * (SELECT PMOP_RATE/PMOP_RATE_PER FROM PM_IL_PLAN_MOP ,PW_IL_QUICK_QUOTE "
					+ "WHERE PMOP_PLAN_CODE =(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE =QUOT_MOP  "
					+ "AND QUOT_SYS_ID = ?))QQAC_FC_CHRG_AMT,QQAC_SYS_ID,QQAC_QUOT_SYS_ID,QQAC_CHRG_CODE,QQAC_APPLIED_ON,QQAC_APPLY_PERIOD,QQAC_APPLIED_ON,"
					+ "QQAC_APPLY_PERIOD,QQAC_RATE,QQAC_RATE_PER,QQAC_FC_CHRG_AMT FROM PW_IL_QQUOT_APPL_CHARGE WHERE QQAC_QUOT_SYS_ID = ?";
			
			//Long POC_POL_SYS_ID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

			ResultSet gresultSet = null;

			try {
				/*	connection = CommonUtils.getConnection();*/
				gresultSet = new CRUDHandler().executeSelectStatement(
						GselectStatement, CommonUtils.getConnection(), new Object[] {SYSID,SYSID});
				while (gresultSet.next()) {

					PW_IL_QQUOT_APPL_CHARGE PT_IL_POL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();

					PT_IL_POL_CHARGE_BEAN.setROWID(gresultSet
							.getString("ROWID"));



					PT_IL_POL_CHARGE_BEAN.setQQAC_SYS_ID(gresultSet
							.getLong("QQAC_SYS_ID"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_QUOT_SYS_ID(gresultSet
							.getLong("QQAC_QUOT_SYS_ID"));

					PT_IL_POL_CHARGE_BEAN.setQQAC_CHRG_CODE(gresultSet
							.getString("QQAC_CHRG_CODE"));


					ResultSet rs1 = null;

					String c2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE like '%IL_CHARGE%' AND PC_CODE= ?";

					Object[] c2values = { PT_IL_POL_CHARGE_BEAN.getQQAC_CHRG_CODE() };
					rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
					while (rs1.next()) {
						PT_IL_POL_CHARGE_BEAN.setUI_M_CHRG_DESC(rs1.getString("PC_DESC"));
					}


					PT_IL_POL_CHARGE_BEAN.setQQAC_APPLIED_ON(gresultSet
							.getString("QQAC_APPLIED_ON"));

					PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_PERIOD(helper.getchargeappperioddesc(gresultSet
							.getString("QQAC_APPLY_PERIOD")));

					PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_ON(helper.getchargeappondesc(gresultSet
							.getString("QQAC_APPLIED_ON")));


					PT_IL_POL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(gresultSet
							.getString("QQAC_APPLY_PERIOD"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE(gresultSet
							.getDouble("QQAC_RATE"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE_PER(gresultSet
							.getInt("QQAC_RATE_PER"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(gresultSet
							.getDouble("QQAC_FC_CHRG_AMT"));


					/*	PT_IL_POL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(gresultSet
							.getString("QQAC_APPLY_PERIOD"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE(CommonUtils.ROUND(gresultSet
							.getDouble("QQAC_FC_CHRG_AMT"), 3));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE_PER(CommonUtils.ROUND(gresultSet
							.getDouble("QQAC_FC_CHRG_AMT"), 3));
					PT_IL_POL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(CommonUtils.ROUND(gresultSet
							.getDouble("QQAC_FC_CHRG_AMT"), 3));*/


					String rate_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE());
					//String rate_per_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE_PER());
					String amt_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT());



					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE(CommonUtils.Decimal_Convert(rate_charge));
					//PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE_PER(Decimal_Convert(rate_per_charge));
					
					
					/*
					 * COMMENTED BY DHINESH FOR SSP CALL ID ---- ON 28.9.2016 ADDED BY BELOW CODE NO START 1218 TO 1226 
					 * 
					 * PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(Decimal_Convert(amt_charge));
					 * 
					 * 
					 * */
					
					//ADDED BY DHINESH FOR SSP CALL ID FALCONLIFE-1344818 ON 28.9.2016
					
					if("Tariff".equalsIgnoreCase(PT_IL_POL_CHARGE_BEAN.getUI_CHARGE_APPLIED_ON()) && "Per Annum".equalsIgnoreCase(PT_IL_POL_CHARGE_BEAN.getUI_CHARGE_APPLIED_PERIOD()))
					{
						System.out.println("TRUE BLOCK QQAC_FC_CHRG_AMT");
						PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(CommonUtils.Decimal_Convert(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE().toString()));
					}else
					{
						System.out.println("FALSE BLOCK QQAC_FC_CHRG_AMT");
						PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(CommonUtils.Decimal_Convert(amt_charge));
					}			
					
					
					/*   END    */
					
					
					/*
						PT_IL_POL_CHARGE_BEAN.setQQAC_SYS_ID(resultSet
								.getLong("QQAC_SYS_ID"));
						PT_IL_POL_CHARGE_BEAN.setQQAC_QUOT_SYS_ID(resultSet
								.getLong("QQAC_QUOT_SYS_ID"));		*/

					chargeList.add(	PT_IL_POL_CHARGE_BEAN);
				}
			} finally {
				CommonUtils.closeCursor(gresultSet);
			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PT_IL_POL_CHARGE(chargeList);
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE().size() > 0) {
				PW_IL_QQUOT_APPL_CHARGE CHARGE_BEAN = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE()
						.get(0);
				CHARGE_BEAN.setRowSelected(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_APPL_CHARGE_BEAN(CHARGE_BEAN);
				/*compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);*/
			}


			System.out.println("sysout for rsdt  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());
			resultSet_brk = new CRUDHandler().executeSelectStatement(FETCH_BROCKER, CommonUtils.getConnection(),
					new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});

			if(resultSet_brk.next()){


				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE(resultSet_brk.getDouble("QQBD_RATE"));
				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE_PER(resultSet_brk.getDouble("QQBD_RATE_PER"));


			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_BROK_DTL_BEAN(PW_IL_QQUOT_BROK_DTL_BEAN);

			//end

			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
	}



	/*public PW_IL_QUICK_QUOTE  executeQuery1(PW_IL_QUICK_QUOTE policyBean) throws Exception {

		String FETCH_QUERY1 = "SELECT PW_IL_QUICK_QUOTE.* FROM PW_IL_QUICK_QUOTE WHERE POL_SYS_ID  = ?  AND POL_IDX_NO = ? ";
		ResultSet resultSet = null;
		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN  = new PW_IL_QUICK_QUOTE();
		try {

			resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY1, CommonUtils.getConnection(),
					new Object[] {policyBean.getQUOT_SYS_ID(),policyBean.getQUOT_IDX_NO()});

			if (resultSet.next()) {

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SYS_ID(resultSet.getLong("QUOT_SYS_ID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NO(resultSet.getString("QUOT_NO"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(resultSet.getInt("QUOT_IDX_NO"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE(resultSet.getString("QUOT_PROD_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_TYPE(resultSet.getString("QUOT_DS_TYPE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_CODE(resultSet.getString("QUOT_DS_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT(resultSet.getDate("QUOT_ISS_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(resultSet.getDate("QUOT_FM_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(resultSet.getDate("QUOT_TO_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_VALID_DT(resultSet.getDate("QUOT_VALID_DT"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE(resultSet.getString("QUOT_CUST_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE(resultSet.getString("QUOT_CUST_TITLE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(resultSet.getString("QUOT_CUST_NAME"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR(resultSet.getString("QUOT_CUST_ADDR"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CITY(resultSet.getString("QUOT_CUST_CITY"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_STATE(resultSet.getString("QUOT_CUST_STATE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PO(resultSet.getString("QUOT_CUST_PO"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PHONE(resultSet.getString("QUOT_CUST_PHONE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CONTACT(resultSet.getString("QUOT_CUST_CONTACT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_MAIL_ID(resultSet.getString("QUOT_CUST_MAIL_ID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_BUS(resultSet.getString("QUOT_SRC_BUS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_CODE(resultSet.getString("QUOT_SRC_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_SA(resultSet.getDouble("QUOT_LC_SA"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_SA(resultSet.getDouble("QUOT_FC_SA"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FRZ_RATE(resultSet.getString("QUOT_FRZ_RATE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_STATUS(resultSet.getString("QUOT_STATUS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS(resultSet.getString("QUOT_APPR_STS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_DT(resultSet.getDate("QUOT_APPR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_UID(resultSet.getString("QUOT_APPR_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_DT(resultSet.getDate("QUOT_CR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(resultSet.getString("QUOT_CR_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_DT(resultSet.getDate("QUOT_UPD_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_UID(resultSet.getString("QUOT_UPD_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(resultSet.getString("QUOT_CLASS_CODE"));

			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
		return PW_IL_QUICK_QUOTE_BEAN;
	}*/


	/*Added by sound*/

	//sankar



	public List<PW_IL_QQUOT_APPL_COVER> loadeCoverdatatable(PILT002_APAC_QE_COMPOSITE_ACTION action) throws Exception {

		System.out.println("Cover dt");
System.out.println("Welcome to loadeCoverdatatable method");

		List<PW_IL_QQUOT_APPL_COVER> COVER_LIST = new ArrayList<PW_IL_QQUOT_APPL_COVER>();
		System.out.println("loadeCoverdatatable");
		/*Edited By jagadeesh For the Field EMR Rate*/

		/*String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE"
				+ " FROM (SELECT ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,"
				+ "QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER "
				+ "CVR_RT_TYP,QUOT_FC_PREM CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID = ? UNION ALL SELECT ROWID ROW_ID,"
				+ " 'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, QQAC_EFF_FM_DT "
				+ "CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE,"
				+ "QQAC_RATE_PER CVR_RT_TYP,QQAC_PREM_LC CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE   FROM PW_IL_QQUOT_APPL_COVER  "
				+ "WHERE QQAC_QUOT_SYS_ID = ?) ORDER BY CVR_TYP DESC";*/

		//added by Ram sir for cover description in grid
		/*String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC "
				+ " FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA, "
				+ " QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER  "
				+ " CVR_RT_TYP,QUOT_FC_PREM CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC "
				+ " FROM PW_IL_QUICK_QUOTE,PM_IL_COVER WHERE QUOT_SYS_ID = ? "
				+ " AND QUOT_PLAN_CODE = COVER_CODE "
				+ " UNION ALL "
				+ " SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID, "
				+ " 'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, QQAC_EFF_FM_DT " 
				+ " CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE, "
				+ " QQAC_RATE_PER CVR_RT_TYP,QQAC_PREM_LC CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC " 
				+ " FROM PW_IL_QQUOT_APPL_COVER,PM_IL_COVER  "
				+ " WHERE QQAC_QUOT_SYS_ID = ? AND QQAC_COVER_CODE = COVER_CODE) ORDER BY CVR_TYP DESC";*/
		/*END*/
		
		/*Changed by Ram & Kuzhandai on 17/058/2016 for SSP call id FALCONQC-1715774*/
		/*String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC"
				+ " FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id, 'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,"
				+ " QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER CVR_RT_TYP,"
				+ "( QUOT_FC_PREM * (SELECT PMOP_RATE/PMOP_RATE_PER FROM PM_IL_PLAN_MOP ,PW_IL_QUICK_QUOTE"
				+ " WHERE PMOP_PLAN_CODE =(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) "
				+ "AND PMOP_TYPE =QUOT_MOP AND QUOT_SYS_ID = ?)) CVR_PREM,QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC FROM PW_IL_QUICK_QUOTE,PM_IL_COVER WHERE QUOT_SYS_ID = ? "
				+ "AND QUOT_PLAN_CODE = COVER_CODE "
				+ "UNION ALL "
				+ "SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA,"
				+ " QQAC_EFF_FM_DT CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE, QQAC_RATE_PER CVR_RT_TYP, "
				+ "(QQAC_PREM_LC *(SELECT PMOP_RATE/PMOP_RATE_PER FROM PM_IL_PLAN_MOP ,PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE ="
				+ "(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE =QUOT_MOP AND QUOT_SYS_ID = ?)) "
				+ " CVR_PREM,QQAC_EMR_RATE CVR_EMR_RATE,COVER_DESC FROM PW_IL_QQUOT_APPL_COVER,PM_IL_COVER"
				+ " WHERE QQAC_QUOT_SYS_ID = ? AND QQAC_COVER_CODE = COVER_CODE) ORDER BY CVR_TYP DESC";*/
		/*End*/
		
		/*Changed by Sivaram on 29/08/2016 for CoverList issue*/
		/*Modified by Ram on 21/12/2016 for Display the values in RoundOff
		 * 
		 * String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_APPLIED_ON,CVR_CODE,CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC "+
  "FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id,'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID,'S' CVR_APPLIED_ON,QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,QUOT_FM_DT CVR_START_DT, "+
               " QUOT_TO_DT CVR_END_DT,QUOT_BASIC_RATE CVR_RATE,QUOT_BASIC_RATE_PER CVR_RT_TYP,ROUND(QUOT_FC_PREM * (SELECT PMOP_RATE / PMOP_RATE_PER " +
            		   " FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) "+ 
            		   " AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?), CURR_DECIMAL) CVR_PREM,  QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC " +
" FROM PW_IL_QUICK_QUOTE, PM_IL_COVER, PM_CURRENCY WHERE QUOT_SYS_ID = ?  AND QUOT_PLAN_CODE = COVER_CODE AND CURR_CODE = NVL(QUOT_CUST_CURR_CODE, '001') "+
 "       UNION ALL "+
"SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID, QQAC_RATE_APPLIED_ON CVR_APPLIED_ON,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, "+
" QQAC_EFF_FM_DT CVR_START_DT,QQAC_EFF_TO_DT CVR_END_DT,QQAC_RATE CVR_RATE,QQAC_RATE_PER CVR_RT_TYP,ROUND(QQAC_PREM_LC * "+
                     " (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE  WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE "+
" FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?), CURR_DECIMAL) CVR_PREM, QQAC_EMR_RATE CVR_EMR_RATE, "+
 " COVER_DESC FROM PW_IL_QQUOT_APPL_COVER, PM_IL_COVER,PW_IL_QUICK_QUOTE,PM_CURRENCY WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID AND QUOT_SYS_ID = ? "+ 
           "AND QQAC_COVER_CODE = COVER_CODE AND CURR_CODE = NVL(QUOT_CUST_CURR_CODE, '001'))  ORDER BY CVR_TYP DESC";*/
		
		String selectStatement = "SELECT ROW_ID,CVR_SYS_ID,CVR_APPLIED_ON,CVR_CODE,CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM,CVR_EMR_RATE,COVER_DESC "+
				  "FROM (SELECT PW_IL_QUICK_QUOTE.ROWID row_id,'B' CVR_TYP,QUOT_SYS_ID CVR_SYS_ID,'S' CVR_APPLIED_ON,QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,QUOT_FM_DT CVR_START_DT, "+
				               " QUOT_TO_DT CVR_END_DT,QUOT_BASIC_RATE CVR_RATE,QUOT_BASIC_RATE_PER CVR_RT_TYP,ROUND(QUOT_FC_PREM * (SELECT PMOP_RATE / PMOP_RATE_PER " +
				            		   " FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) "+ 
				            		   " AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?), 1) CVR_PREM,  QUOT_EMR_RATE CVR_EMR_RATE,COVER_DESC " +
				" FROM PW_IL_QUICK_QUOTE, PM_IL_COVER, PM_CURRENCY WHERE QUOT_SYS_ID = ?  AND QUOT_PLAN_CODE = COVER_CODE AND CURR_CODE = NVL(QUOT_CUST_CURR_CODE, '001') "+
				 "       UNION ALL "+
				"SELECT PW_IL_QQUOT_APPL_COVER.ROWID ROW_ID,'A' CVR_TYP,QQAC_SYS_ID CVR_SYS_ID, QQAC_RATE_APPLIED_ON CVR_APPLIED_ON,QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, "+
				" QQAC_EFF_FM_DT CVR_START_DT,QQAC_EFF_TO_DT CVR_END_DT,QQAC_RATE CVR_RATE,QQAC_RATE_PER CVR_RT_TYP,ROUND(QQAC_PREM_LC * "+
				                     " (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE  WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE "+
				" FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?), 1) CVR_PREM, QQAC_EMR_RATE CVR_EMR_RATE, "+
				 " COVER_DESC FROM PW_IL_QQUOT_APPL_COVER, PM_IL_COVER,PW_IL_QUICK_QUOTE,PM_CURRENCY WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID AND QUOT_SYS_ID = ? "+ 
				           "AND QQAC_COVER_CODE = COVER_CODE AND CURR_CODE = NVL(QUOT_CUST_CURR_CODE, '001'))  ORDER BY CVR_TYP DESC";

		System.out.println("selectStatement     "+selectStatement);
		/*End*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		SYSID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { SYSID ,SYSID, SYSID, SYSID});

			while (resultSet.next()) {
				System.out.println("resultSet for CVR_PREM     "+resultSet.getString("CVR_PREM"));
				PW_IL_QQUOT_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();

				PM_IL_PROD_APPL_COVER_BEAN.setROWID(resultSet
						.getString("ROW_ID"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_COVER_CODE(resultSet
						.getString("CVR_CODE"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE_APPLIED_ON(resultSet
						.getString("CVR_APPLIED_ON"));
				
				PM_IL_PROD_APPL_COVER_BEAN.setCOVER_DESC(resultSet
						.getString("COVER_DESC"));
				System.out.println("COVER_DESC           "+resultSet
						.getString("COVER_DESC"));



				ResultSet rs1 = null;

				String c2="SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE= ?";



				Object[] c2values = { PM_IL_PROD_APPL_COVER_BEAN.getQQAC_COVER_CODE() };
				rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
				while (rs1.next()) {
					PM_IL_PROD_APPL_COVER_BEAN.setUI_M_QQAT_COVER_DESC(rs1.getString("COVER_DESC"));
				}


				while (rs1.next()) {
					PM_IL_PROD_APPL_COVER_BEAN.setUI_M_QQAT_COVER_DESC(rs1.getString("COVER_DESC"));
				}
				String mand="SELECT PAC_MANDATORY_YN FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ? ";

				Object[] mandvalues = { action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PROD_CODE(),PM_IL_PROD_APPL_COVER_BEAN.getQQAC_COVER_CODE() };

				ResultSet rs2= new CRUDHandler().executeSelectStatement(mand, CommonUtils.getConnection(), mandvalues);

				while (rs2.next()) {
					PM_IL_PROD_APPL_COVER_BEAN.setUI_M_QQAT_MAND_YN(rs2.getString("PAC_MANDATORY_YN"));
				}

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_SYS_ID(resultSet
						.getLong("CVR_SYS_ID"));
				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QUOT_SYS_ID(SYSID);
				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(SYSID);

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PERIOD(resultSet
						.getInt("CVR_TERM"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_FC_SA(resultSet
						.getDouble("CVR_SA"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(resultSet
						.getDate("CVR_START_DT"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(resultSet
						.getDate("CVR_END_DT"));



				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


				if(resultSet
						.getDate("CVR_START_DT") != null)
				{
					String FM = simpleDateFormat.format(resultSet
							.getDate("CVR_START_DT"));

					PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_FM_DT(FM);
				}

				if(resultSet
						.getDate("CVR_END_DT") != null)
				{

					String TO = simpleDateFormat.format(resultSet
							.getDate("CVR_END_DT"));

					PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_TO_DT(TO);
				}

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PREM_LC(resultSet
						.getDouble("CVR_PREM"));


				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE(resultSet
						.getDouble("CVR_RATE"));

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE_PER(resultSet
						.getInt("CVR_RT_TYP"));

				/*Added By jagadeesh For the Field EMR Rate*/

				PM_IL_PROD_APPL_COVER_BEAN.setQQAC_EMR_RATE(resultSet
						.getDouble("CVR_EMR_RATE"));

				String emr =Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_EMR_RATE());

				PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_EMR_RATE(CommonUtils.Decimal_Convert(emr));


				/*END*/
				String sumass =Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_FC_SA());
				PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_FC_SA(CommonUtils.Decimal_Convert(sumass));

				String AMT = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_PREM_LC());
				String RATE = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_RATE());
				//	String RATEPER = Double.toString(PM_IL_PROD_APPL_COVER_BEAN.getQQAC_RATE_PER());
				PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_PREM_LC(CommonUtils.Decimal_Convert(AMT));

				PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_RATE(CommonUtils.Decimal_Convert(RATE));


				// PM_IL_PROD_APPL_COVER_BEAN.setUI_QQAC_RATE_PER(Decimal_Convert(RATEPER));





				COVER_LIST.add(PM_IL_PROD_APPL_COVER_BEAN);


			}


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		System.out.println("COVER_LIST");
		return COVER_LIST;
	}



	public List<PW_IL_QQUOT_DISC_LOAD> loadediscloaddatatable(
			PILT002_APAC_QE_COMPOSITE_ACTION action)
					throws Exception {


		System.out.println("loding dt");
		List<PW_IL_QQUOT_DISC_LOAD> TARIFF_LIST = new ArrayList<PW_IL_QQUOT_DISC_LOAD>();
		Long rowid=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

		String selectStatement = "SELECT PW_IL_QQUOT_DISC_LOAD.ROWID,PW_IL_QQUOT_DISC_LOAD.* FROM PW_IL_QQUOT_DISC_LOAD WHERE QQDL_QUOT_SYS_ID = ?";

		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{rowid});
			System.out.println("rst");
			while (resultSet.next()) {

				PW_IL_QQUOT_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();

				PT_IL_POL_DISC_LOAD_BEAN.setROWID(resultSet
						.getString("ROWID"));


				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_SYS_ID(resultSet
						.getLong("QQDL_SYS_ID"));

				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_QUOT_SYS_ID(resultSet
						.getLong("QQDL_QUOT_SYS_ID"));
				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_COVER_CODE(resultSet
						.getString("QQDL_COVER_CODE"));

				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE(resultSet
						.getString("QQDL_DISC_LOAD_TYPE"));
				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_CODE(resultSet
						.getString("QQDL_DISC_LOAD_CODE"));

				if("D".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){
					ResultSet rs1l = null;
					String discount="IL_DISC";
					String c2l="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE ='"+discount+"' AND PC_CODE= ?";

					Object[] c2lvalues = { PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };

					rs1l= new CRUDHandler().executeSelectStatement(c2l, CommonUtils.getConnection(), c2lvalues);
					while (rs1l.next()) {
						PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1l.getString("PC_DESC"));
					}


				}else if("L".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){

					ResultSet rs1d = null;
					String loading="IL_LOAD";
					String c2d="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE ='"+loading+"' AND PC_CODE= ?";
					System.out.println("c2d         "+c2d);
					Object[] c2dvalues = {PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };
					rs1d= new CRUDHandler().executeSelectStatement(c2d, CommonUtils.getConnection(), c2dvalues);
					while (rs1d.next()) {
						PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1d.getString("PC_DESC"));
					}

				}








				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_APPLIED_ON(resultSet
						.getString("QQDL_APPLIED_ON"));
				PT_IL_POL_DISC_LOAD_BEAN.setUI_M_APPLIED_ON_DESC(helper.getdisappondesc(resultSet
						.getString("QQDL_APPLIED_ON")));



				if ("3".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "6".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "7".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "8".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "9".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "10".equals(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())) {
					action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setDisabled(false);
					action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setRequired(true);
					/*if (loadBean.getPDL_COVER_CODE() == null) {
						PDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
					}*/
				} else {
					action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQDL_COVER_CODE().setDisabled(true);
				}


				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_SRNO(resultSet.getInt("QQDL_SRNO"));
				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE(resultSet
						.getDouble("QQDL_RATE"));
				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE_PER(resultSet
						.getInt("QQDL_RATE_PER"));
				PT_IL_POL_DISC_LOAD_BEAN.setQQDL_FC_DISC_LOAD_AMT(resultSet
						.getDouble("QQDL_FC_DISC_LOAD_AMT"));

				String rate_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_RATE());
				//String rate_per_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_RATE_PER());
				String amt_debit = Double.toString(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_FC_DISC_LOAD_AMT());


				PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_RATE(CommonUtils.Decimal_Convert(rate_debit));
				//	PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_RATE_PER(Decimal_Convert(rate_per_debit));
				PT_IL_POL_DISC_LOAD_BEAN.setUI_QQDL_FC_DISC_LOAD_AMT(CommonUtils.Decimal_Convert(amt_debit));



				TARIFF_LIST.add(PT_IL_POL_DISC_LOAD_BEAN);

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
		return TARIFF_LIST;
	}




	public List<PW_IL_QQUOT_APPL_CHARGE> loadEchargeloaddatatable(
			PILT002_APAC_QE_COMPOSITE_ACTION action) throws Exception {
		System.out.println("Charges dt");

		List<PW_IL_QQUOT_APPL_CHARGE> chargeList = new ArrayList<PW_IL_QQUOT_APPL_CHARGE>();
		String selectStatement = "SELECT PW_IL_QQUOT_APPL_CHARGE.ROWID,PW_IL_QQUOT_APPL_CHARGE.* FROM PW_IL_QQUOT_APPL_CHARGE WHERE QQAC_QUOT_SYS_ID = ?";
		Long POC_POL_SYS_ID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {POC_POL_SYS_ID});
			while (resultSet.next()) {

				PW_IL_QQUOT_APPL_CHARGE PT_IL_POL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();

				PT_IL_POL_CHARGE_BEAN.setROWID(resultSet
						.getString("ROWID"));

				PT_IL_POL_CHARGE_BEAN.setQQAC_SYS_ID(resultSet
						.getLong("QQAC_SYS_ID"));
				PT_IL_POL_CHARGE_BEAN.setQQAC_QUOT_SYS_ID(resultSet
						.getLong("QQAC_QUOT_SYS_ID"));

				PT_IL_POL_CHARGE_BEAN.setQQAC_CHRG_CODE(resultSet
						.getString("QQAC_CHRG_CODE"));


				ResultSet rs1 = null;

				String c2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE like '%IL_CHARGE%' AND PC_CODE= ?";

				Object[] c2values = { PT_IL_POL_CHARGE_BEAN.getQQAC_CHRG_CODE() };
				rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
				while (rs1.next()) {
					PT_IL_POL_CHARGE_BEAN.setUI_M_CHRG_DESC(rs1.getString("PC_DESC"));
				}


				PT_IL_POL_CHARGE_BEAN.setQQAC_APPLIED_ON(resultSet
						.getString("QQAC_APPLIED_ON"));

				PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_ON(helper.getchargeappondesc(resultSet
						.getString("QQAC_APPLIED_ON")));


				PT_IL_POL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(resultSet
						.getString("QQAC_APPLY_PERIOD"));


				PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_PERIOD(helper.getchargeappperioddesc(resultSet
						.getString("QQAC_APPLY_PERIOD")));
				PT_IL_POL_CHARGE_BEAN.setQQAC_RATE(resultSet
						.getDouble("QQAC_RATE"));
				PT_IL_POL_CHARGE_BEAN.setQQAC_RATE_PER(resultSet
						.getInt("QQAC_RATE_PER"));
				PT_IL_POL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(resultSet
						.getDouble("QQAC_FC_CHRG_AMT"));



				String rate_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE());
				//String rate_per_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE_PER());
				System.out.println("PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT()   : "+PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT());
				System.out.println("Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT())  : "+Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT()));
				String amt_charge = Double.toString(PT_IL_POL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT());
				System.out.println("amt_charge    : "+amt_charge);


				PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE(CommonUtils.Decimal_Convert(rate_charge));
				//PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE_PER(Decimal_Convert(rate_per_charge));
				
			
				/*
				 * COMMENTED BY DHINESH FOR SSP CALL ID ---- ON 28.9.2016 ADDED BY BELOW CODE NO START 1218 TO 1226 
				 * 
				 * PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(Decimal_Convert(amt_charge));
				 * 
				 * 
				 * */
				
				//ADDED BY DHINESH FOR SSP CALL ID FALCONLIFE-1344818 ON 28.9.2016
				
				if("Tariff".equalsIgnoreCase(PT_IL_POL_CHARGE_BEAN.getUI_CHARGE_APPLIED_ON()) && "Per Annum".equalsIgnoreCase(PT_IL_POL_CHARGE_BEAN.getUI_CHARGE_APPLIED_PERIOD()))
				{
					System.out.println("TRUE BLOCK QQAC_FC_CHRG_AMT");
					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(CommonUtils.Decimal_Convert(PT_IL_POL_CHARGE_BEAN.getQQAC_RATE().toString()));
				}else
				{
					System.out.println("FALSE BLOCK QQAC_FC_CHRG_AMT");
					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(CommonUtils.Decimal_Convert(amt_charge));
				}			
				
				
				
				System.out.println("loadEchargeloaddatatable");
				System.out.println("Decimal_Convert(amt_charge)   : "+CommonUtils.Decimal_Convert(amt_charge));
				System.out.println("PT_IL_POL_CHARGE_BEAN.getUI_QQAC_FC_CHRG_AMT   : "+PT_IL_POL_CHARGE_BEAN.getUI_QQAC_FC_CHRG_AMT());
				System.out.println("End");
				/*   END    */




				/*
				 * 
				 * 
				 * 
				 * 
					PT_IL_POL_CHARGE_BEAN.setQQAC_SYS_ID(resultSet
							.getLong("QQAC_SYS_ID"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_QUOT_SYS_ID(resultSet
							.getLong("QQAC_QUOT_SYS_ID"));		*/

				chargeList.add(	PT_IL_POL_CHARGE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return chargeList;
	}


	/*End*/



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



	public void commissionDetail()
	{


	}


	// commission detatil





	public void defaultCommissiondetatil(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception {


		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
				.getPW_IL_QUICK_QUOTE_BEAN();

		PW_IL_QQUOT_BROK_DTL PW_IL_QQUOT_BROK_DTL_BEAN=compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
				.getPW_IL_QQUOT_BROK_DTL_BEAN();

		String FETCH_QUERY = "SELECT QUOT_SO_CODE,QUOT_SM_CODE FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID = ? ";
		String FETCH_BROCKER ="SELECT QQBD_RATE, QQBD_RATE_PER  FROM PW_IL_QQUOT_BROK_HDR,PW_IL_QQUOT_BROK_DTL  WHERE QQBD_QQBH_SYS_ID = QQBH_SYS_ID   AND QQBH_QUOT_SYS_ID = ?";

		ResultSet resultSet = null;
		ResultSet resultSet_brk = null;


		try {
			if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equals("075")){
				resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY, CommonUtils.getConnection(),
						new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});

				if (resultSet.next()) {

					PW_IL_QUICK_QUOTE_BEAN.setQUOT_SO_CODE(resultSet.getString("QUOT_SO_CODE"));
					PW_IL_QUICK_QUOTE_BEAN.setQUOT_SM_CODE(resultSet.getString("QUOT_SM_CODE"));
				}



				System.out.println("sysout for rsdt  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()+"       "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SO_CODE()+"     "+
				PW_IL_QUICK_QUOTE_BEAN.getQUOT_SM_CODE());
				
				resultSet_brk = new CRUDHandler().executeSelectStatement(FETCH_BROCKER, CommonUtils.getConnection(),
						new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});

				if(resultSet_brk.next()){

					PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE(resultSet_brk.getDouble("QQBD_RATE"));
					PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE_PER(resultSet_brk.getDouble("QQBD_RATE_PER"));

				}
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_BROK_DTL_BEAN(PW_IL_QQUOT_BROK_DTL_BEAN);
				System.out.println("sysout for rsdt rate "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()+"       "+PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()+"     "+
						PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
	}





	//ammenment


	public void executeammenment(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception {/*

		String FETCH_QUERY = "SELECT PW_IL_QUICK_QUOTE.*,PW_IL_QUICK_QUOTE.ROWID FROM PW_IL_QUICK_QUOTE WHERE ROWID = ? ";
		String FETH_DTLS="SELECT PW_IL_QQUOT_ASSURED_DTLS.* FROM PW_IL_QQUOT_ASSURED_DTLS WHERE QQAD_QUOT_SYS_ID= ?";
		String FETCH_QUERY1 = "SELECT PW_IL_QUICK_QUOTE.*,PW_IL_QUICK_QUOTE.ROWID FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID  = ?  AND QUOT_IDX_NO = ? ";
		String FETCH_BROCKER ="SELECT QQBD_RATE, QQBD_RATE_PER  FROM PW_IL_QQUOT_BROK_HDR,PW_IL_QQUOT_BROK_DTL  WHERE QQBD_QQBH_SYS_ID = QQBH_SYS_ID   AND QQBH_QUOT_SYS_ID = ?";
		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN  = new PW_IL_QUICK_QUOTE();
		PW_IL_QQUOT_ASSURED_DTLS PW_IL_QUICK_QUOTE_DTLS_BEAN = new PW_IL_QQUOT_ASSURED_DTLS();
		PW_IL_QQUOT_BROK_DTL PW_IL_QQUOT_BROK_DTL_BEAN = new PW_IL_QQUOT_BROK_DTL();


		ResultSet resultSet = null;
		ResultSet resultSet_dtls = null;
		ResultSet resultSet_brk = null;


		try {
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getROWID() != null) {
				resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY, CommonUtils.getConnection(),
						new Object[] {compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getROWID()});
			}else {
				resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY1, CommonUtils.getConnection(),
						new Object[] {compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID(),
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_IDX_NO()});
			}
			if (resultSet.next()) {
				PW_IL_QUICK_QUOTE_BEAN.setROWID(resultSet.getString("ROWID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SYS_ID(resultSet.getLong("QUOT_SYS_ID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_DT(resultSet.getDate("QUOT_CR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(resultSet.getString("QUOT_CR_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_DT(resultSet.getDate("QUOT_UPD_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT(resultSet.getDate("QUOT_ISS_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(resultSet.getDate("QUOT_FM_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(resultSet.getDate("QUOT_TO_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_VALID_DT(resultSet.getDate("QUOT_VALID_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LOAN_TYPE(resultSet.getString("QUOT_LOAN_TYPE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DIVN_CODE(resultSet.getString("QUOT_DIVN_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UW_YEAR(resultSet.getString("QUOT_UW_YEAR"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE(resultSet.getString("QUOT_PROD_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ASSRD_REF_ID1(resultSet.getString("QUOT_ASSRD_REF_ID1"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE(resultSet.getString("QUOT_CUST_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE(resultSet.getString("QUOT_CUST_TITLE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(resultSet.getString("QUOT_CUST_NAME"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_SURNAME(resultSet.getString("QUOT_CUST_SURNAME"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SO_CODE(resultSet.getString("QUOT_SO_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SM_CODE(resultSet.getString("QUOT_SM_CODE"));



				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_CODE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(false);
				}
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_TITLE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(false);
				}
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_NAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(false);
				}
				if("".equalsIgnoreCase(resultSet.getString("QUOT_CUST_SURNAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(true);
				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(false);
				}

				//gender

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_SA(resultSet.getDouble("QUOT_FC_SA"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PERIOD(resultSet.getInt("QUOT_PERIOD"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS(resultSet.getInt("QUOT_PREM_PAY_YRS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_BUS(resultSet.getString("QUOT_SRC_BUS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_CODE(resultSet.getString("QUOT_SRC_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NO(resultSet.getString("QUOT_NO"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(resultSet.getInt("QUOT_IDX_NO"));


				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_TYPE(resultSet.getString("QUOT_DS_TYPE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_CODE(resultSet.getString("QUOT_DS_CODE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR1(resultSet.getString("QUOT_CUST_ADDR1"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR2(resultSet.getString("QUOT_CUST_ADDR2"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR3(resultSet.getString("QUOT_CUST_ADDR3"));


				if(resultSet.getString("QUOT_CUST_ADDR")!=null){

					if(resultSet.getString("QUOT_CUST_ADDR").contains(",")){

						String addr[]=resultSet.getString("QUOT_CUST_ADDR").split(",");




						for(int i=0;i<addr.length;i++)
						{
							if(i==0)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR(addr[i]);
							else if(i==1)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_Address2(addr[i]);
							else if(i==2)
								PW_IL_QUICK_QUOTE_BEAN.setQUOT_Address3(addr[i]);



						}


					}

				}else{

					PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR(resultSet.getString("QUOT_CUST_ADDR"));
				}


				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CITY(resultSet.getString("QUOT_CUST_CITY"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_STATE(resultSet.getString("QUOT_CUST_STATE"));
				//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PO(resultSet.getString("QUOT_CUST_PO"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_PHONE(resultSet.getString("QUOT_CUST_PHONE"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CONTACT(resultSet.getString("QUOT_CUST_CONTACT"));
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_MAIL_ID(resultSet.getString("QUOT_CUST_MAIL_ID"));


				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_SA(resultSet.getDouble("QUOT_LC_SA"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FRZ_RATE(resultSet.getString("QUOT_FRZ_RATE"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_STATUS(resultSet.getString("QUOT_STATUS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS(resultSet.getString("QUOT_APPR_STS"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_DT(resultSet.getDate("QUOT_APPR_DT"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_UID(resultSet.getString("QUOT_APPR_UID"));

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_UPD_UID(resultSet.getString("QUOT_UPD_UID"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_PREM(resultSet.getDouble("QUOT_LC_PREM"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_PREM(resultSet.getDouble("QUOT_FC_PREM"));
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(resultSet.getString("QUOT_CLASS_CODE"));

			}


			System.out.println("sysout for rsdt  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());
			resultSet_dtls = new CRUDHandler().executeSelectStatement(FETH_DTLS, CommonUtils.getConnection(),
					new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});

			if(resultSet_dtls.next()){


				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_SYS_ID(resultSet_dtls.getLong("QQAD_SYS_ID"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_QUOT_SYS_ID(resultSet_dtls.getLong("QQAD_QUOT_SYS_ID"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_DOB(resultSet_dtls.getDate("QQAD_ASSR_DOB"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CATG_CODE(resultSet_dtls.getString("QQAD_CATG_CODE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_AGE(resultSet_dtls.getInt("QQAD_AGE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_DT(resultSet_dtls.getDate("QQAD_CR_DT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_UID(resultSet_dtls.getString("QQAD_CR_UID"));

				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_CODE(resultSet_dtls.getString("QQAD_ASSR_CODE"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSURED_NAME(resultSet_dtls.getString("QQAD_ASSURED_NAME"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_HEIGHT(resultSet_dtls.getDouble("QQAD_HEIGHT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_WEIGHT(resultSet_dtls.getDouble("QQAD_WEIGHT"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_BMI(resultSet_dtls.getDouble("QQAD_BMI"));
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ADDRESSS(resultSet_dtls.getString("QQAD_ADDRESSS"));




			}

			System.out.println("dtld sys id  "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_QUOT_SYS_ID());


			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QUICK_QUOTE_BEAN(PW_IL_QUICK_QUOTE_BEAN);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QUICK_QUOTE_DTLS_BEAN(PW_IL_QUICK_QUOTE_DTLS_BEAN);





			//add cover data table


			List<PW_IL_QQUOT_APPL_COVER> COVER_LIST = new ArrayList<PW_IL_QQUOT_APPL_COVER>();
			System.out.println("loadeCoverdatatable");
			String selectStatement = "SELECT CVR_CODE, CVR_TERM,CVR_SA,CVR_START_DT,CVR_END_DT,CVR_RATE,CVR_RT_TYP,CVR_PREM"
					+ " FROM (SELECT 'B' CVR_TYP, QUOT_PLAN_CODE CVR_CODE,QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,"
					+ "QUOT_FM_DT CVR_START_DT,QUOT_TO_DT CVR_END_DT, QUOT_BASIC_RATE CVR_RATE, QUOT_BASIC_RATE_PER "
					+ "CVR_RT_TYP,QUOT_FC_PREM CVR_PREM FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID = ? UNION ALL SELECT"
					+ " 'A' CVR_TYP, QQAC_COVER_CODE CVR_CODE,QQAC_PERIOD CVR_TERM,QQAC_FC_SA CVR_SA, QQAC_EFF_FM_DT "
					+ "CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT, QQAC_RATE CVR_RATE,"
					+ "QQAC_RATE_PER CVR_RT_TYP,QQAC_PREM_LC CVR_PREM	  FROM PW_IL_QQUOT_APPL_COVER  "
					+ "WHERE QQAC_QUOT_SYS_ID = ?) ORDER BY CVR_TYP DESC";
			//Connection connection = null;
			ResultSet cresultSet = null;
			Long SYSID=PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID();

			try {
				//connection = CommonUtils.getConnection();
				cresultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, CommonUtils.getConnection(), new Object[] { SYSID,SYSID });

				while (cresultSet.next()) {
					System.out.println("resultSet");
					PW_IL_QQUOT_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();

					PM_IL_PROD_APPL_COVER_BEAN.setROWID(cresultSet
							.getString("ROWID"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_COVER_CODE(cresultSet
							.getString("CVR_CODE"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PERIOD(cresultSet
							.getInt("CVR_TERM"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_FC_SA(cresultSet
							.getDouble("CVR_SA"));
					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(SYSID);

					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String FM = simpleDateFormat.format(cresultSet
							.getDate("CVR_START_DT"));
					String TO = simpleDateFormat.format(cresultSet
							.getDate("CVR_END_DT"));


					PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_FM_DT(FM);

					PM_IL_PROD_APPL_COVER_BEAN.setUI_EFF_TO_DT(TO);

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE(cresultSet
							.getDouble("CVR_RATE"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_RATE_PER(cresultSet
							.getDouble("CVR_RT_TYP"));

					PM_IL_PROD_APPL_COVER_BEAN.setQQAC_PREM_LC(cresultSet
							.getDouble("CVR_PREM"));

					COVER_LIST.add(PM_IL_PROD_APPL_COVER_BEAN);


				}


			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				CommonUtils.closeCursor(cresultSet);
			}
			System.out.println("COVER_LIST");
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PM_IL_PROD_APPL_COVER(COVER_LIST);
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER().size() > 0) {
				PW_IL_QQUOT_APPL_COVER cover_BEAN =compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER()
						.get(0);
				cover_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
			}

			//end


			//debit/credit dtata table 



			System.out.println("loding dt");
			List<PW_IL_QQUOT_DISC_LOAD> TARIFF_LIST = new ArrayList<PW_IL_QQUOT_DISC_LOAD>();
			//Long rowid=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

			String dselectStatement = "SELECT PW_IL_QQUOT_DISC_LOAD.ROWID,QQDL_DISC_LOAD_TYPE,QQDL_DISC_LOAD_CODE,QQDL_APPLIED_ON,"
					+"QQDL_RATE,QQDL_RATE_PER,QQDL_FC_DISC_LOAD_AMT FROM PW_IL_QQUOT_DISC_LOAD WHERE QQDL_QUOT_SYS_ID = ?";


			ResultSet dresultSet = null;

			try {
				//	connection = CommonUtils.getConnection();
				dresultSet = new CRUDHandler().executeSelectStatement(
						dselectStatement, CommonUtils.getConnection(), new Object[]{SYSID});
				System.out.println("rst");
				while (dresultSet.next()) {

					PW_IL_QQUOT_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();

					PT_IL_POL_DISC_LOAD_BEAN.setROWID(dresultSet
							.getString("ROWID"));

					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE(dresultSet
							.getString("QQDL_DISC_LOAD_TYPE"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_CODE(dresultSet
							.getString("QQDL_DISC_LOAD_CODE"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_APPLIED_ON(dresultSet
							.getString("QQDL_APPLIED_ON"));




					if("D".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){
						ResultSet rs1 = null;

						String c2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DISC' AND PC_CODE= ?";

						Object[] c2values = { PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };
									rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
									while (rs1.next()) {
										PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1.getString("PC_DESC"));
									}


					}else if("L".equalsIgnoreCase(PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())){

						ResultSet rs1 = null;

						String c2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_LOAD'AND PC_CODE= ?";

						Object[] c2values = { PT_IL_POL_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE() };
									rs1= new CRUDHandler().executeSelectStatement(c2, CommonUtils.getConnection(), c2values);
									while (rs1.next()) {
										PT_IL_POL_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(rs1.getString("PC_DESC"));
									}

					}




					PT_IL_POL_DISC_LOAD_BEAN.setUI_M_APPLIED_ON_DESC(helper.getdisappondesc(dresultSet
							.getString("QQDL_APPLIED_ON")));


					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE(dresultSet
							.getDouble("QQDL_RATE"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_RATE_PER(dresultSet
							.getDouble("QQDL_RATE_PER"));
					PT_IL_POL_DISC_LOAD_BEAN.setQQDL_FC_DISC_LOAD_AMT(dresultSet
							.getDouble("QQDL_FC_DISC_LOAD_AMT"));


					TARIFF_LIST.add(PT_IL_POL_DISC_LOAD_BEAN);

				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				CommonUtils.closeCursor(dresultSet);
			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PT_IL_POL_DISC_LOAD(TARIFF_LIST);
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD() .size() > 0) {
				PW_IL_QQUOT_DISC_LOAD DIS_BEAN = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_DISC_LOAD()
						.get(0);
				DIS_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
			}

			//end



			//start charge

			List<PW_IL_QQUOT_APPL_CHARGE> chargeList = new ArrayList<PW_IL_QQUOT_APPL_CHARGE>();
			String GselectStatement = "SELECT PW_IL_QQUOT_APPL_CHARGE.ROWID,QQAC_CHRG_CODE,QQAC_APPLIED_ON,QQAC_APPLY_PERIOD,QQAC_RATE,"
					+"QQAC_RATE_PER,QQAC_FC_CHRG_AMT FROM PW_IL_QQUOT_APPL_CHARGE WHERE QQAC_QUOT_SYS_ID = ?";
			//Long POC_POL_SYS_ID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();

			ResultSet gresultSet = null;

			try {
					connection = CommonUtils.getConnection();
				gresultSet = new CRUDHandler().executeSelectStatement(
						GselectStatement, CommonUtils.getConnection(), new Object[] {SYSID});
				while (gresultSet.next()) {

					PW_IL_QQUOT_APPL_CHARGE PT_IL_POL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();

					PT_IL_POL_CHARGE_BEAN.setROWID(gresultSet
							.getString("ROWID"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_CHRG_CODE(gresultSet
							.getString("QQAC_CHRG_CODE"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_APPLIED_ON(gresultSet
							.getString("QQAC_APPLIED_ON"));

					PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_PERIOD(helper.getchargeappperioddesc(gresultSet
							.getString("QQAC_APPLY_PERIOD")));

					PT_IL_POL_CHARGE_BEAN.setUI_CHARGE_APPLIED_ON(helper.getchargeappondesc(gresultSet
							.getString("QQAC_APPLIED_ON")));

	PT_IL_POL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(gresultSet
							.getString("QQAC_APPLY_PERIOD"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE(gresultSet
							.getDouble("QQAC_RATE"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_RATE_PER(gresultSet
							.getDouble("QQAC_RATE_PER"));
					PT_IL_POL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(gresultSet
							.getDouble("QQAC_FC_CHRG_AMT"));


					PT_IL_POL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(gresultSet
								.getString("QQAC_APPLY_PERIOD"));
						PT_IL_POL_CHARGE_BEAN.setQQAC_RATE(CommonUtils.ROUND(gresultSet
								.getDouble("QQAC_FC_CHRG_AMT"), 3));
						PT_IL_POL_CHARGE_BEAN.setQQAC_RATE_PER(CommonUtils.ROUND(gresultSet
								.getDouble("QQAC_FC_CHRG_AMT"), 3));
						PT_IL_POL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(CommonUtils.ROUND(gresultSet
								.getDouble("QQAC_FC_CHRG_AMT"), 3));



					String rate_charge = Double.toString(resultSet
							.getDouble("QQAC_RATE"));
					String rate_per_charge = Double.toString(resultSet
							.getDouble("QQAC_RATE_PER"));
					String amt_charge = Double.toString(resultSet
							.getDouble("QQAC_FC_CHRG_AMT"));



					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE(Decimal_Convert(rate_charge));
					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_RATE_PER(Decimal_Convert(rate_per_charge));
					PT_IL_POL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(Decimal_Convert(amt_charge));


						PT_IL_POL_CHARGE_BEAN.setQQAC_SYS_ID(resultSet
								.getLong("QQAC_SYS_ID"));
						PT_IL_POL_CHARGE_BEAN.setQQAC_QUOT_SYS_ID(resultSet
								.getLong("QQAC_QUOT_SYS_ID"));		

					chargeList.add(	PT_IL_POL_CHARGE_BEAN);
				}
			} finally {
				CommonUtils.closeCursor(gresultSet);
			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setQuickdataList_PT_IL_POL_CHARGE(chargeList);
			if (compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE() != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE().size() > 0) {
				PW_IL_QQUOT_APPL_CHARGE CHARGE_BEAN = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PT_IL_POL_CHARGE()
						.get(0);
				CHARGE_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
			}


			System.out.println("sysout for rsdt  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());
			resultSet_brk = new CRUDHandler().executeSelectStatement(FETCH_BROCKER, CommonUtils.getConnection(),
					new Object[] {PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});

			if(resultSet_brk.next()){


				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE(resultSet_brk.getDouble("QQBD_RATE"));
				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE_PER(resultSet_brk.getDouble("QQBD_RATE_PER"));


			}
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QQUOT_BROK_DTL_BEAN(PW_IL_QQUOT_BROK_DTL_BEAN);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
	 */}



	/*public Double calculatenetpremium(PILT002_APAC_QE_COMPOSITE_ACTION action){
		Double netpremium = 0.0;
		String netpremium_temp =null;
 
		String selectStatement ="SELECT SUM(QQAC_FC_CHRG_AMT) QQAC_FC_CHRG_AMT FROM (SELECT SUM(ROUND((QQAC_FC_CHRG_AMT) * (SELECT PMOP_RATE / PMOP_RATE_PER"
				+ "  FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE)"
				+ " AND PMOP_TYPE = QUOT_MOP   AND QUOT_SYS_ID = ?), CURR_DECIMAL)) QQAC_FC_CHRG_AMT FROM PW_IL_QQUOT_APPL_CHARGE,PW_IL_QUICK_QUOTE, PM_CURRENCY"
				+ " WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID  AND QQAC_APPLIED_ON <> '5'  AND QQAC_APPLY_PERIOD = 'P'  AND QUOT_SYS_ID = ?"
				+ " AND NVL(QUOT_CUST_CURR_CODE,'001') = CURR_CODE UNION ALL SELECT NVL(SUM(ROUND((QQAC_FC_CHRG_AMT), CURR_DECIMAL)), 0) QQAC_FC_CHRG_AMT"
				+ " FROM PW_IL_QQUOT_APPL_CHARGE,PW_IL_QUICK_QUOTE, PM_CURRENCY WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID AND QQAC_APPLIED_ON = '5'"
				+ " AND QQAC_APPLY_PERIOD = 'P'  AND QUOT_SYS_ID = ? AND NVL(QUOT_CUST_CURR_CODE,'001') = CURR_CODE  UNION ALL "
				+ " SELECT NVL(SUM(ROUND((QQAC_FC_CHRG_AMT), CURR_DECIMAL)), 0) QQAC_FC_CHRG_AMT FROM PW_IL_QQUOT_APPL_CHARGE,PW_IL_QUICK_QUOTE, PM_CURRENCY"
				+ " WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID  AND QQAC_APPLY_PERIOD = 'S'  AND QUOT_SYS_ID = ? AND NVL(QUOT_CUST_CURR_CODE,'001') = CURR_CODE)";
	
		System.out.println("selectStatement       "+selectStatement);
		
		
		
		
 		Long POC_POL_SYS_ID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();
 		
 	
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {POC_POL_SYS_ID,POC_POL_SYS_ID,POC_POL_SYS_ID,POC_POL_SYS_ID});
			while (resultSet.next()) {
 
				System.out.println("Total Charge Amount QQAC_FC_CHRG_AMT    : "+resultSet
						.getString("QQAC_FC_CHRG_AMT"));
				netpremium_temp = CommonUtils.Decimal_Convert(resultSet
						.getString("QQAC_FC_CHRG_AMT"));
			
				
				System.out.println(" netpremium_temp-- Total Charge Amount after Decimal Convert      : "+netpremium_temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 
		
		String dselectStatement ="SELECT sum((QQDL_FC_DISC_LOAD_AMT) * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE"
				+ " WHERE PMOP_PLAN_CODE =   (SELECT PROD_PLAN_CODE    FROM PM_IL_PRODUCT  WHERE PROD_CODE = QUOT_PROD_CODE)  AND PMOP_TYPE = QUOT_MOP"
				+ " AND QUOT_SYS_ID = ?)) QQDL_FC_DISC_LOAD_AMT FROM PW_IL_QQUOT_DISC_LOAD  WHERE QQDL_QUOT_SYS_ID = ?   and QQDL_DISC_LOAD_TYPE = 'D'";
		 
		  
					String lselectStatement =" SELECT SUM(QQDL_FC_DISC_LOAD_AMT)  QQDL_FC_DISC_LOAD_AMT FROM (SELECT SUM((QQDL_FC_DISC_LOAD_AMT) * (SELECT PMOP_RATE / PMOP_RATE_PER "
						+ " FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) "
						+ " AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?)) QQDL_FC_DISC_LOAD_AMT FROM PW_IL_QQUOT_DISC_LOAD  WHERE QQDL_QUOT_SYS_ID = ? "
						+ " AND QQDL_DISC_LOAD_TYPE = 'L'  AND QQDL_APPLIED_ON <> '2'  UNION ALL SELECT NVL(QQDL_FC_DISC_LOAD_AMT, 0)  QQDL_FC_DISC_LOAD_AMT"
						+ " FROM PW_IL_QQUOT_DISC_LOAD WHERE QQDL_QUOT_SYS_ID = ? AND QQDL_DISC_LOAD_TYPE = 'L' AND QQDL_APPLIED_ON = '2') ";
				
					End
					
		String Damount=null;
		String Lamount=null;
		
		ResultSet dresultSet = null;
		ResultSet lresultSet = null;
		try {
			 
			dresultSet = new CRUDHandler().executeSelectStatement(
					dselectStatement, CommonUtils.getConnection(), new Object[]{POC_POL_SYS_ID,POC_POL_SYS_ID});
			lresultSet = new CRUDHandler().executeSelectStatement(
					lselectStatement, CommonUtils.getConnection(), new Object[]{POC_POL_SYS_ID,POC_POL_SYS_ID,POC_POL_SYS_ID});
			System.out.println("rst");
			while (dresultSet.next()) {

				Damount=dresultSet.getString("QQDL_FC_DISC_LOAD_AMT");
				
			} 
			System.out.println("Total Discount amount    : "+Damount);
			while (lresultSet.next()) {

				Lamount=lresultSet.getString("QQDL_FC_DISC_LOAD_AMT");
				
			} 
			System.out.println("Total Loading amount    : "+Lamount);
			
			Double Discountamount=0.0;
			if(Damount==null){
				Damount="0.0";
			}
			System.out.println("Damount   : "+Damount);
			
			if(Lamount==null){
				Lamount="0.0";
			}
			System.out.println("Lamount   : "+Lamount);
			
			
			
			Discountamount=Double.parseDouble(netpremium_temp)-
					Double.parseDouble(Damount);
			System.out.println("Discountamount before  : "+Discountamount);
			
			Discountamount=Double.valueOf(CommonUtils.Decimal_Convert(Double.toString(Discountamount)));
			
			System.out.println("Discountamount after  : "+Discountamount);
			 
			
			System.out.println("netpremium before cover add  : "+netpremium);
			
			
			System.out.println("Charge    : "+netpremium_temp);
			System.out.println("Damount   : "+Damount);
			System.out.println("Lamount   : "+Lamount);
			System.out.println("Double.parseDouble(netpremium_temp)   : "+Double.parseDouble(netpremium_temp));
			System.out.println("          -");
			System.out.println("Double.parseDouble(Damount)           : "+Double.parseDouble(Damount));
			System.out.println("Discountamount   : "+Discountamount);
			System.out.println("          -");
			System.out.println("Double.parseDouble(Decimal_Convert(Lamount)) : "+Double.parseDouble(CommonUtils.Decimal_Convert(Lamount)));
			System.out.println("Before Adde Cover netpremium   : "+netpremium);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

 
		
		String coverselectStatement = "SELECT CVR_CODE, CVR_TERM,  CVR_SA,  CVR_START_DT, CVR_END_DT, CVR_RATE, CVR_RT_TYP, CVR_PREM"
				+ " FROM (SELECT 'B' CVR_TYP,  QUOT_PLAN_CODE CVR_CODE, QUOT_PERIOD CVR_TERM,QUOT_FC_SA CVR_SA,QUOT_FM_DT CVR_START_DT,"
				+ " QUOT_TO_DT CVR_END_DT,QUOT_BASIC_RATE CVR_RATE,QUOT_BASIC_RATE_PER CVR_RT_TYP,ROUND(QUOT_FC_PREM * (SELECT PMOP_RATE / PMOP_RATE_PER"
				+ " FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE = (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE)"
				+ " AND PMOP_TYPE = QUOT_MOP AND QUOT_SYS_ID = ?), CURR_DECIMAL) CVR_PREM FROM PW_IL_QUICK_QUOTE, PM_CURRENCY WHERE QUOT_SYS_ID = ?"
				+ " AND NVL(QUOT_CUST_CURR_CODE,'001') = CURR_CODE  UNION ALL SELECT 'A' CVR_TYP, QQAC_COVER_CODE CVR_CODE, QQAC_PERIOD CVR_TERM,"
				+ " QQAC_FC_SA CVR_SA,QQAC_EFF_FM_DT CVR_START_DT, QQAC_EFF_TO_DT CVR_END_DT,QQAC_RATE CVR_RATE,QQAC_RATE_PER CVR_RT_TYP,"
				+ " ROUND(QQAC_PREM_LC * (SELECT PMOP_RATE / PMOP_RATE_PER FROM PM_IL_PLAN_MOP, PW_IL_QUICK_QUOTE WHERE PMOP_PLAN_CODE ="
				+ " (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = QUOT_PROD_CODE) AND PMOP_TYPE = QUOT_MOP"
				+ " AND QUOT_SYS_ID = ?), CURR_DECIMAL) CVR_PREM FROM PW_IL_QQUOT_APPL_COVER,PW_IL_QUICK_QUOTE, PM_CURRENCY"
				+ " WHERE QQAC_QUOT_SYS_ID = QUOT_SYS_ID AND QUOT_SYS_ID = ? AND NVL(QUOT_CUST_CURR_CODE,'001') = CURR_CODE) ORDER BY CVR_TYP DESC";
		 
		ResultSet cresultSet = null;

		try { 
			cresultSet = new CRUDHandler().executeSelectStatement(
					coverselectStatement, CommonUtils.getConnection(), new Object[] { POC_POL_SYS_ID,POC_POL_SYS_ID,POC_POL_SYS_ID,POC_POL_SYS_ID });

			while (cresultSet.next()) {

				netpremium =netpremium + cresultSet
						.getDouble("CVR_PREM");


			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(cresultSet);
				CommonUtils.closeCursor(dresultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("netpremium  final value   "+netpremium);
		return netpremium;

	}
*/

	public Double calculatenetpremium(PILT002_APAC_QE_COMPOSITE_ACTION action){
		Double netpremium = 0.0;
		 
		 
		Connection connection = null;
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		
		try {
			Long POC_POL_SYS_ID=action.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();
			System.out.println("POC_POL_SYS_ID     "+POC_POL_SYS_ID);
			pValList = PKG_PILT002_APAC_QE.P_SHOW_NET_PREM(POC_POL_SYS_ID);
			System.out.println("netpremium from Procedure       "+pValList.get(0).getValue()+"     "+pValList.get(0).getValueObject());
			
			 if(pValList.get(0).getValueObject() instanceof Double)
			 {
				netpremium = (Double)(pValList.get(0).getValueObject());	
			 } 
			
		}catch (Exception e) {
			e.printStackTrace();
		}

 
		
		  
		System.out.println("netpremium  final value   "+netpremium);
		return netpremium;

	}

	public String Decimal_Convert(String Value)
	{
		
		System.out.println(" Decimal_Convert  value  :  "+Value);
		if(Value != null)
		{
			int decimalPlaces=0;
			System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
			decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
			System.out.println("decimalPlaces   : "+decimalPlaces);


			
			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);

			return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}




	/*public String Decimal_Convert(String Value)
{
	if(Value != null)
	{
	int decimalPlaces=0;
	System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
	 decimalPlaces=3;//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
	System.out.println("decimalPlaces   : "+decimalPlaces);


	BigDecimal bd = new BigDecimal(Value);
    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);

    return bd.toString();
	}
	else
	{
		return "0.000";
	}
}*/





}

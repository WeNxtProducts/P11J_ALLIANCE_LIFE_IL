package com.iii.pel.forms.PILT002_APAC_QE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/*
 * Commented  by Janani on 08.03.2017 
 * 
 * 
 * import org.apache.poi.hssf.record.formula.functions.Setvalue;*/

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT002_APAC.DUMMY;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_CONSTANTS;
import com.iii.pel.forms.PILT002_APAC.PM_IL_DOC_TODO_GROUP;
import com.iii.pel.forms.PILT002_APAC.PT_IL_DOC_TODO_LIST_STATUS_DELEGATE;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ADDL_COVER;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ASSURED_DTLS;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_COVER_GROUP;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD_ACTION;
/*import com.iii.pel.forms.PM006_A_APAC.PM_CUSTOMER;*/
import com.iii.pel.forms.PM006_A_APAC.PM_CUST_CURR;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_ACTION;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PW_IL_QUICK_QUOTE_HELPER 
{

	// Form Level Triggers
	// Block Level Triggers
	/*public void whenCreateRecord(
			PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PW_IL_QUICK_QUOTE policyBean = compositeAction
					.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();

			policyBean.setQUOT_DS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
			policyBean.setQUOT_DS_TYPE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_4"));
			policyBean.setQUOT_ISS_DT(new CommonUtils().getCurrentDate());
			policyBean.setQUOT_FRZ_RATE("N");
			policyBean.setQUOT_STATUS("N");
			policyBean.setQUOT_APPR_STS("N");
			policyBean.setQUOT_CLASS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			policyBean.setQUOT_IDX_NO(0);
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(new CommonUtils().getCurrentDate());
		//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	 */
	public void QQAT_COVER_CODE_WHEN_VALIDATE_ITEM(String currValue) throws Exception {
		System.out.println("TEST");
		try{
			DBProcedures procedures = new DBProcedures();
			procedures.helperP_VAL_COVER(currValue, null, "N", "E");
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());

		}
	}

	public void QUOT_PROD_CODE_WHEN_VALIDATE_ITEM(
			PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN, String currValue) throws Exception {
		try{
			PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
			System.out.println("sankar");
			procedures.PILT002_APAC_P_VAL_PRODUCT(currValue,
					CommonUtils.getProcedureValue(PW_IL_QUICK_QUOTE_BEAN
							.getQUOT_ISS_DT()),
							PILT002_APAC_CONSTANTS.P_ERR_FLAG);
		}
		catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());

		}

	}


	public void whenCreateheaderRecord(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN)
					throws Exception {
		try {
			PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = PW_IL_QUICK_QUOTE_ACTION_BEAN
					.getPW_IL_QUICK_QUOTE_BEAN();


			System.out.println(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			System.out.println(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			System.out.println(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			System.out.println(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			System.out.println(CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"));
			System.out.println(CommonUtils
					.getGlobalVariable("GLOBAL.M_DEPT_CODE"));
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_TYPE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3"));
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_PLAN_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT(new CommonUtils().getCurrentDateAndTimeNew());//added by dhinesh for FALCONLIFE-1349311 on 17-10-16
			System.out.println("class code"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2")+" ds code"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_DS_CODE());
			System.out.println("class code"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5"));
			System.out.println("class code"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3"));

			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FRZ_RATE("N");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CONV_YN("N");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_STATUS("N");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS("N");
			
			/*Commented by Ram on 11/11/2016*/
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE("5");
			/*End*/
			
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(0);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(new CommonUtils().getCurrentDate());
			System.out.println("whenCreateheaderRecord Start ");
		
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CURR_CODE(CommonUtils.getGlobalVariable("GLOBAL.CURRENCY_CODE"));
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CURR_CODE   : "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CURR_CODE());
			System.out.println("whenCreateheaderRecord End ");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_EMR_RATE(0.0);
			//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreatepayerRecord(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN)
					throws Exception {
		try {
			PW_IL_QQUOT_ASSURED_DTLS PW_IL_QQUOT_ASSURED_DTLS_BEAN = PW_IL_QUICK_QUOTE_ACTION_BEAN.getPW_IL_QUICK_QUOTE_DTLS_BEAN();
			PW_IL_QQUOT_ASSURED_DTLS_BEAN.setQQAD_CR_DT(new CommonUtils().getCurrentDate());
			PW_IL_QQUOT_ASSURED_DTLS_BEAN.setQQAD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			/*PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_DS_TYPE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_4"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT(new CommonUtils().getCurrentDate());
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FRZ_RATE("N");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_STATUS("N");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS("N");*/
			/*PW_IL_QUICK_QUOTE_BEAN.setQUOT_CLASS_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(0);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(new CommonUtils().getCurrentDate());
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().getCurrentDate());
			 */
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void executeQuery(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction){
		try {
			new PW_IL_QUICK_QUOTE_DELEGATE().executeQuery(compositeAction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// Field Level Triggers

	public void whenValidatePOL_CUST_CODE(PW_IL_QUICK_QUOTE policyBean)
			throws Exception {
		ResultSet resultSet = null;

		String VALIDATE_QUERY = "SELECT CUST_SALUTATION ,CUST_NAME,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3,CUST_CITY,"
				+ "CUST_STATE,CUST_POST_CODE,CUST_PHONE,CUST_EMAIL_ID_PER,CUST_CITY_CODE  "
				+ " FROM PM_CUSTOMER WHERE CUST_CODE =  ? ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(
					VALIDATE_QUERY, CommonUtils.getConnection(),
					new Object[] { policyBean.getQUOT_CUST_CODE() });
			if (resultSet.next()) {
				policyBean.setQUOT_CUST_TITLE(resultSet.getString(1));
				policyBean.setQUOT_CUST_NAME(resultSet.getString(2));
				policyBean.setQUOT_CUST_ADDR1(resultSet.getString(3));
				policyBean.setQUOT_CUST_ADDR2(resultSet.getString(4));
				policyBean.setQUOT_CUST_ADDR3(resultSet.getString(5));

				policyBean.setUI_QUOT_CUST_CITY_DESC(resultSet.getString(6));
				policyBean.setQUOT_CUST_STATE(resultSet.getString(7));
				policyBean.setQUOT_CUST_PO(resultSet.getString(8));
				policyBean.setQUOT_CUST_PHONE(resultSet.getString(9));
				policyBean.setQUOT_CUST_MAIL_ID(resultSet.getString(10));
				policyBean.setQUOT_CUST_CITY(resultSet.getString(11));
			} else {
				throw new Exception("Customer does not Exists! Please Re-enter");
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

	}

	public void POL_PROD_GROUP_CODE_WHEN_VALIDATE_ITEM(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN,
			PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN, String currValue)
					throws Exception {
		String CURSOR_C1 = " SELECT PGD_PROD_CODE FROM   PM_IL_PROD_GROUP_DTL"
				+ " WHERE  PGD_GROUP_CODE   = ? "
				+ " AND    PGD_MAIN_PROD_YN = 'Y' ";
		ResultSet rs1 = null;
		Connection connection = null;
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE(currValue);
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> pvalList = new PCOPK_GENERAL()
			.P_VAL_GRP_CODE(
					PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE(),
					"E",
					CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),
					CommonUtils.getControlBean().getM_LANG_CODE(),
					PW_IL_QUICK_QUOTE_BEAN.getUI_QUOT_PROD_CODE_DESC());
			PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_PROD_CODE_DESC((String) pvalList
					.get(0).getValueObject());

			rs1 = new CRUDHandler().executeSelectStatement(CURSOR_C1,
					connection, new Object[] { PW_IL_QUICK_QUOTE_BEAN
					.getQUOT_PROD_CODE() });
			while (rs1.next()) {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE(rs1.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public java.util.Date addMonthsToDate(java.util.Date utildate)
			throws Exception {
		String strDate = null;
		Date finalDate = new Date();
		ResultSet resultset = null;
		SimpleDateFormat dateFormat = null;
		;
		String query = "SELECT ADD_MONTHS(TO_DATE(?,'dd/mm/rrrr hh24:mi'),12)+0  - (1 / (12 * 11 * 11)) FROM DUAL";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			dateFormat = new SimpleDateFormat(PELConstants.dbDateAndTimeFormat);
			strDate = dateFormat.format(utildate);

			connection = CommonUtils.getConnection();
			resultset = handler.executeSelectStatement(query, connection,
					new Object[] { strDate });
			if (resultset.next()) {
				finalDate = resultset.getTimestamp(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultset);
			} catch (Exception e) {
			}
		}

		return finalDate;
	}

	public String P_VAL_CODE_CHECK(String query, Object[] object)
			throws Exception {
		ResultSet resultSet = null;
		String Code = null;
		String DESC = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(query,
					CommonUtils.getConnection(), object);
			if (resultSet.next()) {
				Code = resultSet.getString(1);
				DESC = resultSet.getString(2);
			} else {
				throw new Exception(
						"Code does not Exists! Please Re-enter code");
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
		return DESC;
	}






	public void preLoadheader(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		PW_IL_QQUOT_ASSURED_DTLS policydtlsBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();
		try {
			String C1 = "SELECT PIL_QUOT_SYS_ID.NEXTVAL FROM DUAL ";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				policyBean.setQUOT_SYS_ID(resultSet.getLong(1));
			}
			policydtlsBean.setQQAD_QUOT_SYS_ID(policyBean.getQUOT_SYS_ID());

			policyBean.setQUOT_CR_DT(new CommonUtils().getCurrentDate());
			policyBean.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			policyBean.setQUOT_LOAN_TYPE("D");
			policyBean.setQUOT_SRC_BUS("001");
			policyBean.setUI_QUOT_SRC_BUS_DESC("Direct");

			//	L_GEN_POL_ENDT_NO(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}




	public void preloadnewcustomer(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_CUSTOMER PM_CUSTOMER_BEAN= compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPM_CUSTOMER_BEAN();

		String M_PS_CODE_DESC = null;
		String M_PC_CODE = null;
		String M_PC_DESC = null;
		String P_DFLT_VALUE = null;
		ArrayList<String> pValList = new ArrayList<String>();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		String C10 = " SELECT PC_CODE ,PC_DESC" + "  FROM   PM_CODES"
				+ "  WHERE  PC_TYPE ='COUNTRY'" + "  AND    PC_CODE = ?";
		String C1 = " SELECT PP_LIST_ITEM.LI_DFLT_VALUE"
				+ "  FROM PP_LIST_ITEM, PP_LIST_ITEM_VALUES"
				+ "  WHERE  LI_MODULE_NAME = 'PM006_A_APAC'"
				+ " AND    LI_BLOCK_NAME  = 'PM_CUSTOMER'"
				+ " AND    LI_ITEM_NAME   = ? "
				+ " AND    LI_SYS_PARAM   = LIV_SYS_PARAM"
				+ " AND    LI_DFLT_VALUE  = LIV_CODE ";
		try {
			connection = CommonUtils.getConnection();
			PM_CUSTOMER_BEAN.setCUST_CREDIT_CHECK_YN("N");
			PM_CUSTOMER_BEAN.setCUST_BROKER_CASH_BASIS_YN("N");
			PM_CUSTOMER_BEAN.setCUST_CONTRACTED_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_TAX_STATUS("N");
			PM_CUSTOMER_BEAN.setCUST_CR_ASSR_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_PREFERRED_LANG("E");
			PM_CUSTOMER_BEAN.setCUST_TITLE("1");
			PM_CUSTOMER_BEAN.setCUST_LCN_STATUS("ACTIVE");
			PM_CUSTOMER_BEAN.setCUST_CBC_YN("N");
			PM_CUSTOMER_BEAN.setCUST_SUPP_COMM_APBL_YN("N");
			PM_CUSTOMER_BEAN.setCUST_AUTO_DEBIT_AVBL_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_COD_REQD_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_PYMT_TYPE("L");
			PM_CUSTOMER_BEAN.setCUST_FRZ_FLAG("N");
			PM_CUSTOMER_BEAN.setCUST_APPL_ALL_BRAN_YN("Y");

			PM_CUSTOMER_BEAN.setCUST_CONTU_PAYMENT_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_ALL_CURR_APPL_YN("Y");
			PM_CUSTOMER_BEAN.setCUST_TYPE("I");
			PM_CUSTOMER_BEAN.setCUST_CLASS("INDL");
			if ("GRPL".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				PM_CUSTOMER_BEAN.setCUST_TYPE("C");
			} else if ("INDL".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_20"))) {
				PM_CUSTOMER_BEAN.setCUST_TYPE("I");
			}
			values = new Object[] { PM_CUSTOMER_BEAN.getCUST_CREDIT_CHECK_YN() };
			resultSet1 = handler.executeSelectStatement(C1, connection, values);
			if (resultSet1.next()) {
				P_DFLT_VALUE = resultSet1.getString(1);
			}
			values = new Object[] { PM_CUSTOMER_BEAN.getCUST_TRANSFER_TO() };
			resultSet2 = handler.executeSelectStatement(C1, connection, values);
			if (resultSet1.next()) {
				P_DFLT_VALUE = resultSet2.getString(1);
			}
			values = new Object[] { PM_CUSTOMER_BEAN.getCUST_COD_REQD_YN() };
			resultSet3 = handler.executeSelectStatement(C1, connection, values);
			if (resultSet1.next()) {
				P_DFLT_VALUE = resultSet3.getString(1);
			}
			values = new Object[] { CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_15") };
			resultSet = handler.executeSelectStatement(C10, connection, values);
			if (resultSet.next()) {
				M_PC_CODE = resultSet.getString(1);
				M_PC_DESC = resultSet.getString(2);
				PM_CUSTOMER_BEAN.setCUST_COUNT_CODE(M_PC_CODE);
				PM_CUSTOMER_BEAN.setCUST_COUNTRY(M_PC_DESC);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}


	}




	public void preLoadBrocker(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		PW_IL_QQUOT_BROK_HDR brockerBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_BROK_HDR_BEAN();
		try {
			String C1 = "SELECT PIL_QQBD_SYS_ID.NEXTVAL FROM DUAL";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				brockerBean.setQQBH_SYS_ID(resultSet.getLong(1));
			}
			brockerBean.setQQBH_CR_DT(new CommonUtils().getCurrentDate());
			brockerBean.setQQBH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			//L_GEN_POL_ENDT_NO(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}







	public void preLoadcustomer(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		PW_IL_QQUOT_ASSURED_DTLS policydtlsBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();
		try {
			String C1 = "SELECT  PIL_QQAD_SYS_ID.NEXTVAL FROM DUAL";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				policydtlsBean.setQQAD_SYS_ID(resultSet.getLong(1));
			}
			policydtlsBean.setQQAD_CR_DT(new CommonUtils().getCurrentDate());
			policydtlsBean.setQQAD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			policydtlsBean.setQQAD_CATG_CODE("1"); //altered the value from M to 1 by ganesh on 28-08-2016 suggested by Mr.VinothKumar
			//L_GEN_POL_ENDT_NO(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}

	public void preLoadcover(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_ISS_DT");
		ResultSet resultSet = null;
		PW_IL_QQUOT_APPL_COVER coverBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_APPL_COVER_BEAN();
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		PW_IL_QQUOT_ASSURED_DTLS  DTLSBEAN= compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();
		try {
			String C1 = "SELECT PIL_QQAC_SYS_ID.NEXTVAL  FROM DUAL";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				coverBean.setQQAC_SYS_ID(resultSet.getLong(1));
			}
			//	L_GEN_POL_ENDT_NO(compositeAction);
			coverBean.setQQAC_QUOT_SYS_ID(policyBean.getQUOT_SYS_ID());
			coverBean.setQQAC_QQAD_SYS_ID(DTLSBEAN.getQQAD_SYS_ID());
			coverBean.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
			coverBean.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}







	/*	public void whenCreateRecord(PT_IL_POL_ADDL_COVER coverBean,
			PT_IL_POL_COVER_GROUP pt_il_pol_cover_group,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS asssuredBean,PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		coverBean.setPOAC_FM_DT(CommonUtils.nvl(policyBean
				.getPOL_END_EFF_FROM_DT(), policyBean.getPOL_ISSUE_DT()));
		coverBean.setPOAC_TO_DT(CommonUtils.nvl(policyBean.getPOL_END_EFF_TO_DT(),
				policyBean.getPOL_EXPIRY_DT()));
		coverBean.setPOAC_RATE_PER(1.00);
		coverBean.setPOAC_WOP_FLAG("N");
		coverBean.setPOAC_ASSR_CODE(asssuredBean.getPOAD_ASSR_CODE());
		coverBean.setUI_M_POAC_ASSR_NAME(asssuredBean.getPOAD_ASSURED_NAME());
		coverBean.setUI_M_PROD_CODE( policyBean.getPOL_PROD_CODE());
		coverBean.setUI_M_PCG_CODE(pt_il_pol_cover_group.getPCG_CODE() );
		//newly added to disable WOP if joint life is NO
		if(policyBean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("N")){
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_WOP_FLAG().setDisabled(true);
		}
	}*/




	public void preLoadDebit(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		PW_IL_QQUOT_DISC_LOAD DebitBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_DISC_LOAD_BEAN();
		try {
			String C1 = "SELECT PIL_QQDL_SYS_ID.NEXTVAL  FROM DUAL";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				DebitBean.setQQDL_SYS_ID(resultSet.getLong(1));
			}
			DebitBean.setQQDL_QUOT_SYS_ID(policyBean.getQUOT_SYS_ID());


			String C2 = "select MAX(QQDL_SRNO)+1 FROM PW_IL_QQUOT_DISC_LOAD where QQDL_QUOT_SYS_ID = ?";
			resultSet1 = new CRUDHandler().executeSelectStatement(C2,
					CommonUtils.getConnection(),new Object[] { policyBean
				.getQUOT_SYS_ID() });
			if (resultSet1.next()) {
				DebitBean.setQQDL_SRNO(resultSet1.getInt((1)));
			}

			System.out.println(" setQQDL_SRNO       "+DebitBean.getQQDL_SRNO()+"   QQDL_QUOT_SYS_ID      "+DebitBean.getQQDL_QUOT_SYS_ID() );

			/*DebitBean.setqqdl_(new CommonUtils().getCurrentDate());
			DebitBean.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());*/
			//	L_GEN_POL_ENDT_NO(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}








	public void preLoadcharge(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		PW_IL_QQUOT_APPL_CHARGE PW_IL_QQUOT_APPL_CHARGE_bean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_APPL_CHARGE_BEAN();
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();

		try {
			String C1 = "SELECT PIL_QQAC_SYS_ID.NEXTVAL  FROM DUAL";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection());
			if (resultSet.next()) {
				PW_IL_QQUOT_APPL_CHARGE_bean.setQQAC_SYS_ID(resultSet.getLong(1));
			}
			//	L_GEN_POL_ENDT_NO(compositeAction);
			PW_IL_QQUOT_APPL_CHARGE_bean.setQQAC_QUOT_SYS_ID(policyBean.getQUOT_SYS_ID());
			PW_IL_QQUOT_APPL_CHARGE_bean.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
			PW_IL_QQUOT_APPL_CHARGE_bean.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void postUpdate(PW_IL_QUICK_QUOTE policyBean,PW_IL_QUICK_QUOTE_ACTION actionBean) throws Exception {
System.out.println("Welcome to PostUpdate funtionin Quick Quoe screen");

		try {
					
			PKG_PILT002_APAC_QE.INS_AGENT_HIERARCHY(CommonUtils.getProcedureValue(policyBean.getQUOT_SYS_ID()),
					policyBean.getQUOT_SRC_CODE(),policyBean.getQUOT_TO_DT());
			System.out.println("value policyBean.getQUOT_SRC_CODE()        --->"+policyBean.getQUOT_SRC_CODE());
			System.out.println("value"+policyBean.getQUOT_SYS_ID()+"  ...  "+policyBean.getQUOT_PROD_CODE());
			System.out.println("policyBean.getROWID()   : "+policyBean.getROWID());
			System.out.println("policyBean.getQUOT_SYS_ID().toString()   : "+policyBean.getQUOT_SYS_ID().toString());
			
			
			String creaeNew = CommonUtils.getGlobalVariable("GLOBAL.CREATE_NEW");
			System.out.println("creaeNew      "+creaeNew);
			if(creaeNew !=null && creaeNew.equalsIgnoreCase("Y"))
			{
			PKG_PILT002_APAC_QE.P_INS_ADDL_COVER(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_PROD_CODE(),"N");
			
			/*Added by Ram on 14/11/2016 for Condition issue*/
			PKG_PILT002_APAC_QE.P_INS_APPL_COND(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_PROD_CODE());
			/*End*/
			
			/*Modified by Ram on 07/04/2017 as per Vinoth & Gopi Suggestion*/
			PKG_PILT002_APAC_QE.PROP_INS_POL_CHARGES(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_TO_DT());
			/*End*/
			
			}
			else
			{
				System.out.println("policyBean.getQUOT_SYS_ID().toString()   : "+policyBean.getQUOT_SYS_ID().toString());
				
				/*Modified by Ram on 03/11/2016 for term Change issue*/
				System.out.println("actionBean.getChangeTerm  "+actionBean.getChangeTerm());
				PKG_PILT002_APAC_QE.P_QUICK_COV_DT_DFT(policyBean.getQUOT_SYS_ID().toString(),actionBean.getChangeTerm());
				/*End*/
				
			}
			/*PKG_PILT002_APAC_QE.PROP_INS_POL_CHARGES(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_TO_DT());*/
			policyBean.setQUOT_UPD_DT(new CommonUtils().getCurrentDate());
			policyBean.setQUOT_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}



	public void postQuery(PW_IL_QUICK_QUOTE policyBean) throws Exception {
		String Query1 = "SELECT PC_DESC  FROM PM_CODES  WHERE  "
				+ " PC_TYPE = 'SRC_BUS_TY' AND PC_CODE = ? ";
		String Query2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?  ";
		String Query3 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?  ";
		String Query4 = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND PC_CODE = ? ";
		String Query5 = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'STATE' AND PC_CODE = ? ";
		ResultSet resultSet2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		try {
			if (policyBean.getQUOT_SRC_BUS() != null) {
				resultSet = new CRUDHandler().executeSelectStatement(Query1,
						CommonUtils.getConnection(), new Object[] { policyBean
					.getQUOT_SRC_BUS() });
				if (resultSet.next()) {
					policyBean.setUI_QUOT_SRC_BUS_DESC(resultSet.getString(1));
				}
			}

			if (policyBean.getQUOT_SRC_CODE() != null) {
				resultSet1 = new CRUDHandler().executeSelectStatement(Query2,
						CommonUtils.getConnection(), new Object[] { policyBean
					.getQUOT_SRC_CODE() });
				if (resultSet1.next()) {
					policyBean
					.setUI_QUOT_SRC_CODE_DESC(resultSet1.getString(1));
				}
			}
			if (policyBean.getQUOT_PROD_CODE() != null) {
				resultSet2 = new CRUDHandler().executeSelectStatement(Query3,
						CommonUtils.getConnection(), new Object[] { policyBean
					.getQUOT_PROD_CODE() });
				if (resultSet2.next()) {
					policyBean.setUI_QUOT_PROD_CODE_DESC(resultSet2
							.getString(1));
				}
			}

			if (policyBean.getQUOT_CUST_CITY() != null) {
				resultSet3 = new CRUDHandler().executeSelectStatement(Query4,
						CommonUtils.getConnection(), new Object[] { policyBean
					.getQUOT_CUST_CITY() });
				if (resultSet3.next()) {
					policyBean.setUI_QUOT_CUST_CITY_DESC(resultSet3
							.getString(1));
				}
			}

			if (policyBean.getQUOT_CUST_STATE() != null) {
				resultSet4 = new CRUDHandler().executeSelectStatement(Query5,
						CommonUtils.getConnection(), new Object[] { policyBean
					.getQUOT_CUST_STATE() });
				if (resultSet4.next()) {
					policyBean.setUI_QUOT_CUST_STATE_DESC(resultSet4
							.getString(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			CommonUtils.closeCursor(resultSet3);
			CommonUtils.closeCursor(resultSet4);
		}

	}

	public void IL_UNIQUE_END_NO(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN)
					throws Exception {

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = PW_IL_QUICK_QUOTE_ACTION_BEAN
				.getPW_IL_QUICK_QUOTE_BEAN();

		int M_POL_NO = 0;

		String query1 = "  SELECT 1 FROM   PT_IL_POLICY "
				+ " WHERE  POL_NO = ? " + " AND    POL_END_NO =? ";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {
			object1 = new Object[] { PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO(),
					PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO() };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_NO = resultSet.getInt(1);
			}
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71062",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void whenValidateQUOT_CUST_CITY(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN,
			String currValue) throws Exception {

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = PW_IL_QUICK_QUOTE_ACTION_BEAN
				.getPW_IL_QUICK_QUOTE_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		PILT002_APAC_QE_LOCAL_PROCEDURES procedures = new PILT002_APAC_QE_LOCAL_PROCEDURES();
		try {
			if (currValue != null) {

				pValList = procedures.P_VAL_CODES("CITY", currValue,
						PW_IL_QUICK_QUOTE_BEAN.getUI_QUOT_CUST_CITY_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				if (pValList != null && !(pValList.isEmpty())) {
					PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_CUST_CITY_DESC(pValList
							.get(0).getValue());
				}
			} else {
				PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_CUST_CITY_DESC(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void whenValidateQUOT_CUST_STATE(
			PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN,
			String currValue) throws Exception {

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = PW_IL_QUICK_QUOTE_ACTION_BEAN
				.getPW_IL_QUICK_QUOTE_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		PILT002_APAC_QE_LOCAL_PROCEDURES procedures = new PILT002_APAC_QE_LOCAL_PROCEDURES();
		try {
			if (currValue != null) {

				pValList = procedures.P_VAL_CODES("STATE", currValue,
						PW_IL_QUICK_QUOTE_BEAN.getUI_QUOT_CUST_STATE_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				if (pValList != null && !(pValList.isEmpty())) {
					PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_CUST_STATE_DESC(pValList
							.get(0).getValue());
				}
			} else {
				PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_CUST_STATE_DESC(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void L_GEN_POL_ENDT_NO(
			PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception {
		String C1 = "SELECT  PS_VALUE  FROM    PP_SYSTEM   WHERE   PS_TYPE = 'END_NUM_GEN'";
		String M_PS_VALUE1 = null;
		ResultSet C1_REC = null;
		Connection conn = null;
		CRUDHandler handler = null;
		ArrayList<OracleParameter> retList = null;

		try {
			PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = compositeAction
					.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
					.getPW_IL_QUICK_QUOTE_BEAN();
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO() == null
					|| "".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())) {

				retList = new PILT002_APAC_QE_LOCAL_PROCEDURES()
				.P_GEN_DOC_NO_GL(PW_IL_QUICK_QUOTE_BEAN
						.getQUOT_DS_TYPE(), PW_IL_QUICK_QUOTE_BEAN
						.getQUOT_DS_CODE(), CommonUtils
						.getControlBean().getM_DIVN_CODE(), CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_2"),
						PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT(), null,
						"PT_IL_POLICY", "N", PW_IL_QUICK_QUOTE_BEAN
						.getQUOT_PROD_CODE(),
						PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT(), null,
						null);
				if (retList != null && retList.size() > 0) {
					System.out.println("(String) retList.get(0).getValueObject()"+(String) retList.get(0).getValueObject());
					String polNo = (String) retList.get(0).getValueObject();
					new PILT002_APAC_QE_LOCAL_PROCEDURES().L_CHECK_POL_DUPL(
							polNo, PW_IL_QUICK_QUOTE_BEAN.getQUOT_DS_TYPE());
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
					.getPW_IL_QUICK_QUOTE_BEAN().setQUOT_NO(
							(String) retList.get(0).getValueObject());
				}
				if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO() == null
						|| "".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())) {
					throw new Exception("Document Setup is missing,please enter the Policy Number");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
			}
		}
	}

	public void POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,String ic_no) throws Exception{


		String CURSOR_C2 = "SELECT SUBSTR( ? ,1,6) FROM DUAL";
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSetdob = null;
		ResultSet resultSetdob1=  null;
		String M_DATE_CHAR="";
		Date M_TEMP_DATE = null;
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		PW_IL_QQUOT_ASSURED_DTLS policyDTLSBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();
		ResultSet resultSet = null;
		
		/*Added by janani on 17.8.2016 for IC no validation*/
		String M_PS_VALUE = null;
		Integer M_LENGTH_1 = 0;
		String M_CODE_DESC = null;
		Integer M_NEW_IC_NO_LENGTH = ic_no.length();
		Object[] values = null;
		ArrayList<String> list1 = null;
		ArrayList<String> pValDesc = null;
		
		/*end*/

		String VALIDATE_QUERY = "SELECT CUST_CODE, CUST_FIRST_NAME, CUST_SURNAME, CUST_TITLE,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3, CUST_DOB,CUST_CATG_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID1 = ?";
		try {
			
			
			/*Added by janani on 17.8.2016 for IC no validation*/

	
			
			list1 = DBProcedures.P_VAL_SYSTEM(
					"CUSTREFFMT",
					"CUSTREFFMT",
					M_CODE_DESC, "N", 
					M_PS_VALUE);
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(1) != null) {
					M_PS_VALUE = list1.get(1);
				}
			}
			
			Integer M_REF_ID_1_LENGTH = 0;
			
			System.out.println("M_PS_VALUE in quick quote                 :"+M_PS_VALUE);
			
			
			if ("1".equals(M_PS_VALUE)) {
				
				System.out.println("ENTERS INTO M_PS_VALUE = 1 in quick quote");
				
				/*commented by Janani on 18.10.2016 for IC no length issue ssp call id FALCONLIFE-1344818*/
			/*	compositeAction
						.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
						.setMaxlength(12);*/
				System.out.println("getMaxlength            :"+compositeAction
						.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
						.getMaxlength());
				M_REF_ID_1_LENGTH = compositeAction
						.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(null,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}
			else
			{
				
				System.out.println("ENTERS INTO M_PS_VALUE != 1 in quick quote");
				
				/*commented by Janani on 18.10.2016 for IC no length issue ssp call id FALCONLIFE-1344818*/
				/* compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
				.setMaxlength(64);*/
				System.out.println("getMaxlength            :"+compositeAction
						.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
						.getMaxlength());
				M_REF_ID_1_LENGTH = compositeAction
						.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}
			
			
			
			
			System.out.println("M_NEW_IC_NO_LENGTH in quick quote                 :"+M_NEW_IC_NO_LENGTH);
			System.out.println("M_REF_ID_1_LENGTH in quick quote                 :"+M_REF_ID_1_LENGTH);
				
			
			System.out.println("QUOT_ASSRD_REF_ID1().length() in quick quote                 :"+policyBean.getQUOT_ASSRD_REF_ID1().length());
			System.out.println("M_LENGTH_1 in quick quote                 :"+M_LENGTH_1);
			
			if (policyBean.getQUOT_ASSRD_REF_ID1().length() != M_LENGTH_1) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91915",new Object[] {M_LENGTH_1 }));
			}
			
			
			
			/*end*/
			resultSet = new CRUDHandler().executeSelectStatement(
					VALIDATE_QUERY, CommonUtils.getConnection(),
					new Object[] { ic_no});
			if (resultSet.next()) {
				policyBean.setQUOT_CUST_CODE(resultSet.getString("CUST_CODE"));

				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSR_CODE(resultSet.getString("CUST_CODE"));
				policyBean.setQUOT_CUST_TITLE(resultSet.getString("CUST_TITLE"));
				policyBean.setQUOT_CUST_NAME(resultSet.getString("CUST_FIRST_NAME"));
				policyDTLSBean.setQQAD_ASSURED_NAME(resultSet.getString("CUST_FIRST_NAME"));
				policyBean.setQUOT_CUST_SURNAME(resultSet.getString("CUST_SURNAME"));
				policyDTLSBean.setQQAD_ASSR_DOB(resultSet.getDate("CUST_DOB"));
				
				if("1".equalsIgnoreCase(resultSet.getString("CUST_CATG_CODE"))){
				policyDTLSBean.setQQAD_CATG_CODE("1"); //altered the value from M to 1 by ganesh on 28-08-2016 suggested by Mr.VinothKumar
				}else if("2".equalsIgnoreCase(resultSet.getString("CUST_CATG_CODE"))){
					policyDTLSBean.setQQAD_CATG_CODE("2"); //altered the value from F to 2 by ganesh on 28-08-2016 suggested by Mr.VinothKumar
				}else if("3".equalsIgnoreCase(resultSet.getString("CUST_CATG_CODE"))){
					policyDTLSBean.setQQAD_CATG_CODE("3"); //altered the value from C to 3 by ganesh on 28-08-2016 suggested by Mr.VinothKumar
				}
				if(policyBean.getQUOT_CUST_ADDR2()==null){
					policyBean.setQUOT_CUST_ADDR1(resultSet.getString("CUST_ADDR1"));
				}
				if(policyBean.getQUOT_CUST_ADDR2()==null){
					policyBean.setQUOT_CUST_ADDR2(resultSet.getString("CUST_ADDR2"));
				}
				if(policyBean.getQUOT_CUST_ADDR2()==null){
					policyBean.setQUOT_CUST_ADDR3(resultSet.getString("CUST_ADDR3"));
				}

				/*policyDTLSBean.setQQAD_ASSR_DOB(resultSet.getDate("CUST_DOB"));*/
				policyDTLSBean.setQQAD_AGE(calccustomerage(compositeAction,policyDTLSBean.getQQAD_ASSR_DOB()));



				if("".equalsIgnoreCase(resultSet.getString("CUST_CODE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(true);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(true);
				}
				if("".equalsIgnoreCase(resultSet.getString("CUST_TITLE"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(false);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(true);
				}
				if("".equalsIgnoreCase(resultSet.getString("CUST_FIRST_NAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(false);
				}else{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(true);
				}
				if("".equalsIgnoreCase(resultSet.getString("CUST_SURNAME"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(false);
				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(true);
				}
				if("".equalsIgnoreCase(resultSet.getString("CUST_DOB"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_DOB().setDisabled(false);
					//	compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);

				}/* 
				commented by Dhinesh for DOB button enabled issues
				else
				{
					
					 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_DOB().setDisabled(true);
					//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);
				}*/
				/*if("".equalsIgnoreCase(resultSet.getString("CUST_ADDR1"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS().setDisabled(false);
					//	compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);

				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS().setDisabled(true);
					//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);
				}
				 */
				/*if("".equalsIgnoreCase(resultSet.getString("CUST_ADDR2"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS2().setDisabled(false);
					//	compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);

				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS2().setDisabled(true);
					//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);
				}

				if("".equalsIgnoreCase(resultSet.getString("CUST_ADDR3"))){
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS3().setDisabled(false);
					//	compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);

				}else
				{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS3().setDisabled(true);
					//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_AGE().setDisabled(true);
				}*/


			} else {

				/*policyBean.setQUOT_CUST_CODE(" ");
				policyDTLSBean.setQQAD_ASSR_CODE(" ");
				policyBean.setQUOT_CUST_TITLE(" ");
				policyBean.setQUOT_CUST_NAME(" ");
				policyDTLSBean.setQQAD_ASSURED_NAME(" ");
				policyBean.setQUOT_CUST_SURNAME(" ");
				policyDTLSBean.setQQAD_AGE(0);
				policyDTLSBean.setQQAD_ASSR_DOB(null);*/

				//now agalya
				//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ASSR_CODE().setDisabled(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQAD_ASSURED_NAME().setDisabled(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSR_CODE("IND000058");
				//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSURED_NAME("DUMMY");

				//end
				policyBean.setQUOT_CUST_CODE(null);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_CODE().setDisabled(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_TITLE().setDisabled(false);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_NAME().setDisabled(false);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_CUST_LAST_NAME().setDisabled(false);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_DOB().setDisabled(false);
				//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS3().setDisabled(true);
				//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS2().setDisabled(true);
				//compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_ADDRESS().setDisabled(true);
				/*throw new Exception("Customer does not Exists! Please Re-enter");*/
			}


			
			/*Added by janani on 17.8.2016 for IC no validation*/
			if ("1".equals(M_PS_VALUE)) {
				
			
				
				/*END*/
				
			if(ic_no!=null){
				System.out.println("ic_no        :    "+ic_no);
				resultSetdob =  new CRUDHandler().executeSelectStatement(CURSOR_C2,CommonUtils.getConnection(), new Object[] { ic_no });
				if (resultSetdob.next()) {
					M_DATE_CHAR = resultSetdob.getString(1);
					String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
					resultSetdob1 =  new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{M_DATE_CHAR});
					if (resultSetdob1.next()) {
						M_DATE_CHAR = resultSetdob1.getString(1);
					}

					M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
					if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils.getYearFromDate(commonUtils.getCurrentDate())) {
						//String temp1 = CommonUtils.dateToStringFormatter();
						M_TEMP_DATE = CommonUtils.stringToPelUtilDate(CommonUtils.dateToPELStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200)));
						policyDTLSBean.setQQAD_ASSR_DOB(M_TEMP_DATE);
						policyDTLSBean.setQQAD_AGE(calccustomerage(compositeAction,policyDTLSBean.getQQAD_ASSR_DOB()));

					} else {
						policyDTLSBean.setQQAD_ASSR_DOB(M_TEMP_DATE);
						policyDTLSBean.setQQAD_AGE(calccustomerage(compositeAction,policyDTLSBean.getQQAD_ASSR_DOB()));

					}
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
				}


			}
			
			
		}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			/*	compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());*/
			/*try {
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				//throw new Exception(e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSetdob1);
				CommonUtils.closeCursor(resultSetdob);
			} catch (Exception e) {
			}
		}


	}






	public int calccustomerage(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,java.util.Date POAD_DOB) throws Exception
	{
		System.out.println("inside POAD_DOB_WHEN_VALIDATE_ITEM in helper");
		PW_IL_QUICK_QUOTE Quick_Bean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		int age = 0;

		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {

				//added by saritha on 29/06/2016
				ResultSet resultSet = null;

				String VALIDATE_QUERY = "SELECT PROD_AGE_CALC_FLAG FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				String param_age="";

				resultSet = new CRUDHandler().executeSelectStatement(
						VALIDATE_QUERY, CommonUtils.getConnection(),
						new Object[] { Quick_Bean.getQUOT_PROD_CODE() });
				if (resultSet.next()) {

					param_age=resultSet.getString("PROD_AGE_CALC_FLAG");
				} else {
					param_age="2";
				}

				if (Quick_Bean.getQUOT_ISS_DT().before(POAD_DOB)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = PKG_PILT002_APAC_QE.P_CALC_ANB(
						Quick_Bean.getQUOT_ISS_DT(),
						POAD_DOB, 
						param_age,
						0);
				//CommonUtils.getProcedureValue(Quick_Dtls.getQQAD_AGE()));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						age =(Integer)list1.get(0).getValueObject();
					}

				}

			}

		}catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return age;

	}








	public void generateQuotationNo(
			PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception {
		Calendar now = Calendar.getInstance();
		DateFormat date = new SimpleDateFormat("yyyy");
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		// Gets the current date and time.
		String M_PS_VALUE1 = null;
		ResultSet C1_REC = null;
		Connection conn = null;
		CRUDHandler handler = null;
		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
				.getPW_IL_QUICK_QUOTE_BEAN();
		handler = new CRUDHandler();
		conn = CommonUtils.getConnection();
		ArrayList<OracleParameter> retList = null;
		String sysdate =new CommonUtils().dateToStringFormat(new CommonUtils().getCurrentDate());


		//end

		//get uw


		String VALIDATE_QUERY1="SELECT TO_CHAR(to_date(?,'DD/MM/RRRR'), 'RRRR')  FROM DUAL";
		String UW="";
		System.out.println("issue dt    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT()+"div  "+ CommonUtils
				.getGlobalVariable("GLOBAL.M_DIVN_CODE"));
		try{
			resultSet1 = new CRUDHandler().executeSelectStatement(
					VALIDATE_QUERY1, CommonUtils.getConnection(),
					new Object[] {sysdate});
			if (resultSet1.next()) {
				UW=resultSet1.getString(1);


			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
		}


		PW_IL_QUICK_QUOTE_BEAN.setQUOT_DIVN_CODE(CommonUtils
				.getGlobalVariable("GLOBAL.M_DIVN_CODE"));
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_UW_YEAR(UW);
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());


		String P_DOC_NO_FN=" ";
		String M_DISABLE_YN=" ";
		//	String M_UW_YEAR=date.format(now);
		System.out.println("\n cd  "+sysdate+"\n\nyear \n dc type code "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")+"\n dc code"+ CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5")+"\n prod code"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());
		System.out.println("Div code "+CommonUtils
				.getControlBean().getM_DIVN_CODE());
		System.out.println("Ds type "+PW_IL_QUICK_QUOTE_BEAN
				.getQUOT_DS_TYPE()+"\n ds code "+ PW_IL_QUICK_QUOTE_BEAN
				.getQUOT_DS_CODE());
		try {/*
			CommonUtils
			.getGlobalVariable("GLOBAL.M_PARAM_2")*/

			if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO() == null
					|| "".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())) {

				retList = PKG_PILT002_APAC_QE
						.P_GEN_QUOTE_NO(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"),CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5"), CommonUtils
								.getGlobalVariable("GLOBAL.M_DIVN_CODE"),PW_IL_QUICK_QUOTE_BEAN.getQUOT_CLASS_CODE(),PW_IL_QUICK_QUOTE_BEAN.getQUOT_PLAN_CODE(),
								PW_IL_QUICK_QUOTE_BEAN
								.getQUOT_PROD_CODE(),UW,P_DOC_NO_FN,
								"DUMMY","N",sysdate,M_DISABLE_YN);

				//	CommonUtils.objectSysout(retList.get(0));
				if (retList != null && retList.size() > 0) {
					String polNo = (String) retList.get(0).getValue();
					/*new PILT002_APAC_QE_LOCAL_PROCEDURES().L_CHECK_POL_DUPL(
							polNo, PW_IL_QUICK_QUOTE_BEAN.getQUOT_DS_TYPE());
					 */PW_IL_QUICK_QUOTE_BEAN.setQUOT_NO(polNo);


				}
				if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO() == null
						|| "".equals(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
								.getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO())) {
					throw new Exception("Document Setup is missing,please enter the Policy Number");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
			}
		}
	}

	//BMI

	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(Double POAD_WEIGHT,
			PW_IL_QQUOT_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_1_BEAN)
					throws Exception {

		PKG_PILT002_APAC_QE pilt002Procedures = new PKG_PILT002_APAC_QE();
		ArrayList<OracleParameter> list = null; 
		if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_HEIGHT() >0.0 && POAD_WEIGHT >0.0) {


			if ((Math.ceil(CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_HEIGHT(), 0))) != CommonUtils
					.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_HEIGHT(), 0)) {
				throw new Exception(Messages
						.getString(
								PELConstants.pelErrorMessagePath,
								"91567"));
			}
			else{

				list = pilt002Procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_HEIGHT(),
						POAD_WEIGHT,
						"C",
						"K",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {

						double value =(Double)list.get(0).getValueObject();
						double roundOff = Math.round(value * 100.0) / 100.0;

						PT_IL_POL_ASSURED_DTLS_1_BEAN.setQQAD_BMI(roundOff);


						String SysBmi_value =constantbmivalue();
						int getbmi=Integer.parseInt( SysBmi_value);
						System.out.println("GET BMI VALUE"+getbmi);
						//String outcome = null;
						//String message = null;
						if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI() > getbmi) {
							/*	message="BMI should not exceed "+getbmi;
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);*/
							throw new Exception((Messages.getString(
									PELConstants.pelErrorMessagePath, "77777",
									new Object[]{getbmi})));
						}




						//PT_IL_POL_ASSURED_DTLS_1_BEAN.setQQAD_BMI((Double)list.get(0).getValueObject());
						System.out.println("BMI "+PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI());
					}
				}
			} 
		}
	}



	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(Double POAD_HEIGHT,
			PW_IL_QQUOT_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_1_BEAN)
					throws Exception {

		PKG_PILT002_APAC_QE pilt002Procedures = new PKG_PILT002_APAC_QE();
		ArrayList<OracleParameter> list = null; 


		if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_WEIGHT() >0.0 && POAD_HEIGHT >0.0) {

			if ((Math.ceil(CommonUtils.nvl(POAD_HEIGHT, 0))) != CommonUtils
					.nvl(POAD_HEIGHT, 0)) {
				throw new Exception(Messages
						.getString(
								PELConstants.pelErrorMessagePath,
								"91567"));
			}

			else{	
				list = pilt002Procedures.L_BMI_CALC(POAD_HEIGHT,
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_WEIGHT(),
						"C",
						"K",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {

						double value =(Double)list.get(0).getValueObject();
						double roundOff = Math.round(value * 100.0) / 100.0;



						PT_IL_POL_ASSURED_DTLS_1_BEAN.setQQAD_BMI(roundOff);


						String SysBmi_value =constantbmivalue();
						int getbmi=Integer.parseInt( SysBmi_value);
						System.out.println("GET BMI VALUE"+getbmi);
						//String outcome = null;
						//String message = null;
						if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI() > getbmi) {
							/*	message="BMI should not exceed "+getbmi;
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);*/
							throw new Exception((Messages.getString(
									PELConstants.pelErrorMessagePath, "77777",
									new Object[]{getbmi})));
						}


						System.out.println("BMI  "+PT_IL_POL_ASSURED_DTLS_1_BEAN.getQQAD_BMI());

					}
				}
			} 
		}
	}



	public void POAD_DOB_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,PW_IL_QUICK_QUOTE Quick_Bean,java.util.Date POAD_DOB,PW_IL_QQUOT_ASSURED_DTLS Quick_Dtls) throws Exception
	{
		System.out.println("inside POAD_DOB_WHEN_VALIDATE_ITEM in helper");

		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			/*Commented by Ram on 01/11/2016 for Age Calculation Issue*/
			
			/*
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {


				ResultSet resultSet = null;

				String VALIDATE_QUERY = "SELECT PROD_AGE_CALC_FLAG FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				String param_age="";

				resultSet = new CRUDHandler().executeSelectStatement(
						VALIDATE_QUERY, CommonUtils.getConnection(),
						new Object[] { Quick_Bean.getQUOT_PROD_CODE() });
				if (resultSet.next()) {

					param_age=resultSet.getString("PROD_AGE_CALC_FLAG");
				} else {
					param_age="2";
				}



             System.out.println("Quick_Bean.getQUOT_ISS_DT()            "+Quick_Bean.getQUOT_FM_DT());
				if (Quick_Bean.getQUOT_FM_DT().before(POAD_DOB)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = PKG_PILT002_APAC_QE.P_CALC_ANB(
						Quick_Bean.getQUOT_FM_DT(),
						POAD_DOB, 
						param_age,
						0);
				//CommonUtils.getProcedureValue(Quick_Dtls.getQQAD_AGE()));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						if((Integer)list1.get(0).getValueObject()>0){
							Quick_Dtls.setQQAD_AGE((Integer)list1.get(0).getValueObject());
							Quick_Bean.setQUOT_MAX_AGE((Integer)list1.get(0).getValueObject());
						}
						else{
							throw new Exception("Age Must be Greater Than Zero");
						}
					}

				}

			}

		*/
			/*End*/
			calculateAge(compositeAction, Quick_Bean, POAD_DOB, Quick_Dtls);
			
			/*Added by Ram on 07/12/2016 for set Gender defaultvalue*/
System.out.println("Age is      "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE());
setGender(compositeAction);
/*End*/

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	/*Added by Ram on 07/12/2016 for set Gender defaultvalue*/
	public void setGender(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception
	{
		System.out.println("Enter into setGender method");
		
		/*Added by Ram on 01/12/2016 for configure minimum Child Age setup*/
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		int MinimumAge = 0;
		String BeneficieryQuery = "SELECT PS_VALUE FROM PP_SYSTEM where PS_TYPE = ?";
		 
			connection = CommonUtils.getConnection();
			
			/*Modified by Ram on 11/12/2016 for Common Age limitation*/
			/*resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_BNFAGELMT" });*/
			
			resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_CHILD_AGE" });
			/*End*/
			
			while (resultSet.next()) {
				MinimumAge = resultSet.getInt(1);
			}
			System.out.println("MinimumAge      "+MinimumAge);
			if(MinimumAge == 0)
			{
				throw new Exception("Child Minimum age setup is not available.");
			}
			System.out.println("MinimumAge    "+MinimumAge);
			
		/*if(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE() < 17)
		 * 
		 * End*/
			if(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE() < MinimumAge)
		{
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_CATG_CODE("3");
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_GENDER().setDisabled(true);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_GENDER().resetValue();
		}
		else
		{

			/*Commented by Ram on 26/12/2016 for Set values
			 * 
			 * compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_CATG_CODE("1");
			 * 
			 * End*/
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_GENDER().setDisabled(false);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQOT_GENDER().resetValue();
		}
	}
	/*End*/
	
	/*Added by Ram on 01/11/2016 for Age Calculation Issue*/
	public void calculateAge(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,
			PW_IL_QUICK_QUOTE Quick_Bean,
			java.util.Date POAD_DOB,
			PW_IL_QQUOT_ASSURED_DTLS Quick_Dtls) throws Exception
	{
		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			/*Added by Ram on 01/11/2016 for DOB Validation missing issue*/
			if(POAD_DOB == null)
			{
				throw new Exception("Date of Birth Value is Required");
			}
			/*End*/
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {


				ResultSet resultSet = null;

				String VALIDATE_QUERY = "SELECT PROD_AGE_CALC_FLAG FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				String param_age="";

				resultSet = new CRUDHandler().executeSelectStatement(
						VALIDATE_QUERY, CommonUtils.getConnection(),
						new Object[] { Quick_Bean.getQUOT_PROD_CODE() });
				if (resultSet.next()) {

					param_age=resultSet.getString("PROD_AGE_CALC_FLAG");
				} else {
					param_age="2";
				}
	           System.out.println("Quick_Bean.getQUOT_ISS_DT()            "+Quick_Bean.getQUOT_FM_DT());
				if (Quick_Bean.getQUOT_FM_DT().before(POAD_DOB)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = PKG_PILT002_APAC_QE.P_CALC_ANB(
						Quick_Bean.getQUOT_FM_DT(),
						POAD_DOB, 
						param_age,
						0);
				//CommonUtils.getProcedureValue(Quick_Dtls.getQQAD_AGE()));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						if((Integer)list1.get(0).getValueObject()>0){
							Quick_Dtls.setQQAD_AGE((Integer)list1.get(0).getValueObject());
							Quick_Bean.setQUOT_MAX_AGE((Integer)list1.get(0).getValueObject());
						}
						else{
							throw new Exception("Age Must be Greater Than Zero");
						}
					}

				}

			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}


	}
	/*End*/





	/*
	 * commented by sankar for ssp call id FALCONLIFE-1345285 on 13-10-16
	 * 
	 * public void POL_PROD_CODE_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,  String currValue)
			throws Exception {*/
	
	/*Added  one more parameter by sankar for ssp call id FALCONLIFE-1345285 on 13-10-16*/
	public void POL_PROD_CODE_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,  String currValue,String oldvalue)  // added by sankar
			throws Exception {
    
		ResultSet resultSet = null;
		ResultSet PresultSet = null;
		PW_IL_QUICK_QUOTE policyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		String VALIDATE_QUERY="SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		String C1 = " SELECT PROD_PERIOD,PROD_PREM_PAY_YRS FROM PM_IL_PRODUCT  WHERE  PROD_CODE = ? ";
		System.out.println("query executed--------------->"+C1);
		try {
			System.out.println("inside the POL_PROD_CODE_WHEN_VALIDATE_ITEM");
			if(policyBean.getQUOT_PERIOD()==null && policyBean.getQUOT_PREM_PAY_YRS()==null|| (!(currValue.equalsIgnoreCase(oldvalue))))// or condition added by sankara for  ssp call id FALCONLIFE-1345285 on 13-10-16 
			{
				resultSet = new CRUDHandler().executeSelectStatement(C1,
						CommonUtils.getConnection(), new Object[] { currValue });
				if (resultSet.next()) {
					policyBean.setQUOT_PERIOD(resultSet.getInt("PROD_PERIOD"));
					System.out.println("value of bean1"+policyBean.getQUOT_PERIOD());
					//policyBean.setQUOT_PREM_PAY_YRS(resultSet.getInt("PROD_PREM_PAY_YRS"));

					if(policyBean.getQUOT_MOP() != null){
						if ("Y".equals(policyBean.getQUOT_MOP())
								|| "H".equals(policyBean.getQUOT_MOP())
								|| "M".equals(policyBean.getQUOT_MOP())
								|| "Q".equals(policyBean.getQUOT_MOP())) {

							policyBean.setQUOT_PREM_PAY_YRS(policyBean.getQUOT_PREM_PAY_YRS());
						}
						else {

							policyBean.setQUOT_PREM_PAY_YRS(1);
						}
					} else {
						policyBean.setQUOT_PREM_PAY_YRS(resultSet.getInt("PROD_PREM_PAY_YRS"));
					}
				}

			}

			PresultSet = new CRUDHandler().executeSelectStatement(
					VALIDATE_QUERY, CommonUtils.getConnection(),
					new Object[] { currValue });
			if (PresultSet.next()) {
				policyBean.setQUOT_PLAN_CODE(PresultSet.getString("PROD_PLAN_CODE"));
				//	plan_code=resultSet.getString("PROD_PLAN_CODE");

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

	}



	public void ADD_QQAT_PROD_CODE_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,  String currValue)
			throws Exception {

		ResultSet resultSet = null;
		ArrayList<OracleParameter> list = null;
		PW_IL_QQUOT_APPL_COVER CoverBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_APPL_COVER_BEAN();
		PW_IL_QUICK_QUOTE PolicyBean = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();

		try {

			list = PKG_PILT002_APAC_QE.P_VAL_PROD_COVER(currValue, 
					CoverBean.getUI_M_QQAT_COVER_DESC(),
					PolicyBean.getQUOT_PROD_CODE(),
					"N","E");


			if (list != null && !list.isEmpty()) {
				CoverBean.setUI_M_QQAT_COVER_DESC((String)list.get(0).getValueObject());
			}




			System.out.println("inside the POL_PROD_CODE_WHEN_VALIDATE_ITEM");
			String C1 = " SELECT PROD_PERIOD,PROD_PREM_PAY_YRS FROM PM_IL_PRODUCT  WHERE  PROD_CODE = ? ";
			System.out.println("query executed--------------->"+C1);
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(), new Object[] { PolicyBean.getQUOT_PROD_CODE() });
			if (resultSet.next()) {
				/*commented and added by dhinesh for term issue on26-10-2016
				 * 
				 * CoverBean.setQQAC_PERIOD(resultSet.getInt("PROD_PERIOD"));*/
				System.out.println("PolicyBean.getQUOT_PERIOD()    :  "+PolicyBean.getQUOT_PERIOD());
				CoverBean.setQQAC_PERIOD( PolicyBean.getQUOT_PERIOD());
				
				
				System.out.println("value of bean1"+CoverBean.getQQAC_PERIOD());
				//	policyBean.setQUOT_PREM_PAY_YRS(resultSet.getInt("PROD_PREM_PAY_YRS"));
				//System.out.println("value of bean2"+policyBean.getQUOT_PERIOD());
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

	}


	public Double updateGrosspre(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction){

		PW_IL_QUICK_QUOTE policybean=compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();

		Double sa_fc = null;

		String FETCH_QUERY = "SELECT QUOT_LC_PREM FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID = ? ";
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY, CommonUtils.getConnection(),
					new Object[] {policybean.getQUOT_SYS_ID()});
			if (resultSet.next()) {

				//policybean.setQUOT_LC_PREM(resultSet.getDouble("QUOT_LC_PREM"));
				sa_fc=resultSet.getDouble("QUOT_LC_PREM");
			}

		} catch (SQLException | DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sa_fc;



	}



	public String getdisappondesc(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Appondesc="";

		try {
			/*String C1 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND" 
						+"LI_MODULE_NAME  = 'PILM035_APAC' AND LIV_SYS_PARAM  = 'IL_APPLIEDON' AND LI_BLOCK_NAME = 'PM_IL_PROD_APPL_LOAD_TARIFF' "
							+"AND LI_ITEM_NAME='PM_IL_PROD_APPL_LOAD_TARIFF.PALT_APPLIED_ON' AND LIV_CODE= ? ";*/
			String C1 ="SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME  = 'PILM035_APAC' "
					+"AND LIV_SYS_PARAM  = 'IL_APPLIEDON' AND LI_BLOCK_NAME = 'PM_IL_PROD_APPL_LOAD_TARIFF' AND LI_ITEM_NAME='PM_IL_PROD_APPL_LOAD_TARIFF.PALT_APPLIED_ON' AND LIV_CODE= ? ";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Appondesc=resultSet.getString("LIV_CODE_DESC");
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



	public String getchargeappperioddesc(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Appondesc="";

		try {

			String C1 ="SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC'" 
					+"AND LIV_SYS_PARAM  = 'IL_CHG_PRD' AND LI_BLOCK_NAME ='PT_IL_POL_CHARGE' AND LI_ITEM_NAME='PT_IL_POL_CHARGE.POC_APPLY_PERIOD' AND LIV_CODE= ?";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Appondesc=resultSet.getString("LIV_CODE_DESC");
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


	public String getchargeappondesc(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Appondesc="";

		try {

			String C1 ="SELECT  LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC'"
					+"AND LIV_SYS_PARAM  = 'IL_CHGAPPLON' AND LI_BLOCK_NAME ='PT_IL_POL_CHARGE' AND LI_ITEM_NAME='PT_IL_POL_CHARGE.POC_APPLIED_ON' AND LIV_CODE= ?";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Appondesc=resultSet.getString("LIV_CODE_DESC");
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



	public void QQAD_BMI_VALIDATE_ITEM(Double BMI) throws Exception{
		System.out.println(" POAD_BMI_VALIDATE_ITEM   "+BMI);
		String SysBmi_value =constantbmivalue();
		int getbmi=Integer.parseInt( SysBmi_value);
		System.out.println("GET BMI VALUE"+getbmi);
		//String outcome = null;
		//String message = null;
		if (BMI > getbmi) {
			/*	message="BMI should not exceed "+getbmi;
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getErrorMap().put(
		PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);*/
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "77777",
					new Object[]{getbmi})));
		}
		//return message;
	}

	public  String constantbmivalue()throws Exception{


		String query ="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_Code= ?";
		String code= "BMI_VAL";

		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String Psvalue=null;
		CRUDHandler handler = new CRUDHandler();			 

		resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[] {code});
		while (resultSet.next()) {
			Psvalue=resultSet.getString("PS_VALUE");
		}
		return Psvalue;
	}



	public int checkmaxammenment(String Quot_no)
			throws Exception {
		ResultSet resultSet = null;
		int maxammen=0;

		String maxammenment_QUERY = "SELECT MAX(QUOT_IDX_NO) FROM PW_IL_QUICK_QUOTE WHERE QUOT_NO = ? ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(
					maxammenment_QUERY, CommonUtils.getConnection(),
					new Object[] { Quot_no });
			if (resultSet.next()) {
				maxammen=resultSet.getInt(1);
			} else {
				throw new Exception("Customer does not Exists! Please Re-enter");
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
		return maxammen;

	}


	public void pre_insertnewcustomer(PILT002_APAC_QE_COMPOSITE_ACTION compositeaction)
			throws Exception {
		PM_CUSTOMER PM_CUSTOMER_BEAN = compositeaction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPM_CUSTOMER_BEAN();
		PW_IL_QQUOT_ASSURED_DTLS policyDTLSBean =compositeaction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();
		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN =compositeaction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		try {
			if (CommonUtils.isIN(PM_CUSTOMER_BEAN.getCUST_TYPE(), "E", "I")) {
				L_CUST_UNIQUE_VAL(PM_CUSTOMER_BEAN.getCUST_CODE());
			}
			pValList.clear();
			PM_CUSTOMER_BEAN.setUI_M_CUST_CODE_YN("Y");
			if ("Y".equals(CommonUtils.nvl(PM_CUSTOMER_BEAN
					.getUI_M_CUST_CODE_YN(), "N"))) {

				boolean isvalid = checkLastNumberValidity(PM_CUSTOMER_BEAN
						.getCUST_CLASS());
				if (isvalid) {
					ArrayList<String> pValList1 =PKG_PILT002_APAC_QE.helperPKG_PM006_P_GEN_AUTO_NO(
							PM_CUSTOMER_BEAN.getCUST_CLASS(), "N",
							PM_CUSTOMER_BEAN.getCUST_CODE());
					if (!pValList1.isEmpty()) {
						PM_CUSTOMER_BEAN.setCUST_CODE(pValList1.get(0));
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE(pValList1.get(0));
						//added by shankar on 10.06.2016
						/*	policyDTLSBean.setQQAD_ASSR_CODE("");*/
						/*policyDTLSBean.setQQAD_ASSURED_NAME("");*/

						policyDTLSBean.setQQAD_ASSR_CODE(pValList1.get(0));

						updatecustcode(compositeaction);
						if (PM_CUSTOMER_BEAN.getCUST_CODE().length() > 12) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "930012",
									new Object[] { PM_CUSTOMER_BEAN
											.getCUST_CODE().length() }));
						}
					}
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "92271"));
				}
			}
			PM_CUSTOMER_BEAN.setCUST_FRZ_FLAG("N");
			PM_CUSTOMER_BEAN.setCUST_CR_DT(new CommonUtils().getCurrentDate());
			PM_CUSTOMER_BEAN.setCUST_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	public void L_CUST_UNIQUE_VAL(String custCode) throws Exception {
		Connection conn = null;
		try {
			conn = CommonUtils.getConnection();
			String M_TEMP = null;
			String errMessage = null;

			String sql_C1 = "SELECT 1 FROM PM_CUSTOMER WHERE CUST_CODE='"
					+ custCode + "'";
			ResultSet vembu_C1 = null;
			Statement stmt_C1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			vembu_C1 = stmt_C1.executeQuery(sql_C1);

			if (vembu_C1.next()) {
				M_TEMP = vembu_C1.getString(1);
			}
			// if(!vembu_C1.isLast())
			if (M_TEMP != null) {
				errMessage = CommonUtils.getErrorMessageForCode("1601");
				// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1601,:CTRL.M_LANG_CODE);
				throw new ValidatorException(new FacesMessage(errMessage));
			}
			CommonUtils.closeCursor(vembu_C1);
		} catch (RuntimeException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(conn);

		}
	}


	private boolean checkLastNumberValidity(String cust_class) throws Exception {

		Integer currentNum = null;
		Integer lastNum = null;

		String C1 = "SELECT NGS_CURR_NO,NGS_LAST_NO FROM PM_NUMBER_GEN_SETUP "
				+ "WHERE NGS_CODE IN (SELECT DISTINCT CUST_CLASS FROM PM_CUSTOMER WHERE CUST_CLASS = ?)";
		Object[] values = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		boolean flagValue;

		try {
			con = CommonUtils.getConnection();
			values = new Object[] { cust_class };
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (rs1.next()) {
				currentNum = rs1.getInt(1);
				lastNum = rs1.getInt(2);

				if (currentNum == lastNum) {
					flagValue = false;
				} else {
					flagValue = true;
				}
			} else {
				flagValue = true;
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}
		}

		return flagValue;

	}



	public void L_INS_PM_CUST_CURR(PM_CUSTOMER customerBean)
			throws SQLException, Exception {
		Connection conn = null;
		double M_DUMMY = 0;
		String M_CURR_CODE = null;
		int ROWCOUNT = 0;
		CRUDHandler handler = new CRUDHandler();

		conn = CommonUtils.getConnection();
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_CURRENCY to
		 * FM_CURRENCY. Added by : Mallika.S, 01-Apr-2009
		 */
		String sql_C1 = "SELECT CURR_CODE FROM  FM_CURRENCY  ";
		ResultSet vembu_C1 = null;
		Statement stmt_C1 = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql_C2 = "SELECT 1 FROM  PM_CUST_CURR  " + "WHERE  "
				+ "CCUR_CUST_CODE  = '" + customerBean.getCUST_CODE() + "' "
				+ "AND CCUR_CURR_CODE  = " + M_CURR_CODE + " ";
		ResultSet vembu_C2 = null;
		Statement stmt_C2 = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		vembu_C1 = stmt_C1.executeQuery(sql_C1);
		while ((true)) {
			if (vembu_C1.next()) {
				M_CURR_CODE = vembu_C1.getString(1);
				System.out
				.println("PM006_A_APAC_HELPER.L_INS_PM_CUST_CURR()[--M_CURR_CODE--"
						+ vembu_C1.getString(1) + "]");
			}
			if (vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
				break;
			M_DUMMY = 0;
			sql_C2 = "SELECT 1 FROM  PM_CUST_CURR  " + "WHERE  "
					+ "CCUR_CUST_CODE  = '" + customerBean.getCUST_CODE()
					+ "' " + "AND CCUR_CURR_CODE  = '" + M_CURR_CODE + "'";
			System.out.println("PM006_A_APAC_HELPER.L_INS_PM_CUST_CURR()---["
					+ sql_C2 + "]");

			vembu_C2 = stmt_C2.executeQuery(sql_C2);
			if (vembu_C2.next()) {
				M_DUMMY = vembu_C2.getDouble(1);
			}
			if (M_DUMMY == 0) {
				// Statement stmt_vembu1 =
				// conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

				PM_CUST_CURR cutCurr = new PM_CUST_CURR();
				cutCurr.setCCUR_CUST_CODE(customerBean.getCUST_CODE());
				cutCurr.setCCUR_CURR_CODE(M_CURR_CODE);
				cutCurr.setCCUR_FRZ_FLAG("N");
				cutCurr.setCCUR_CR_DT(customerBean.getCUST_CR_DT());
				cutCurr.setCCUR_CR_UID(customerBean.getCUST_CR_UID());
				cutCurr.setCCUR_UPD_DT(customerBean.getCUST_UPD_DT());
				cutCurr.setCCUR_UPD_UID(customerBean.getCUST_UPD_UID());

				handler.executeInsert(cutCurr, CommonUtils.getConnection());

			}
		}
		CommonUtils.closeCursor(vembu_C2);
		CommonUtils.closeCursor(vembu_C1);
	}



	public void post_insert_new_customer(PM_CUSTOMER PM_CUSTOMER_BEAN)
			throws Exception {
		Double M_CS_CODE = 0.0;
		String M_CCUR_CURR_CODE = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet c1_ResultSet = null;
		String C1 = " SELECT PARA_VALUE" + "	  FROM FP_PARAMETER"
				+ "	  WHERE PARA_ID='BASE.CURR'";
		String C2_insert = " INSERT INTO PM_ASSURED"
				+ "                 (ASSR_CODE,"
				+ "                  ASSR_NAME,"
				+ "                  ASSR_SURNAME,"
				+ "                  ASSR_FIRST_NAME,"
				+ "                  ASSR_MIDDLE_NAME,"
				+ "                  ASSR_LONG_NAME,"
				+ "                  ASSR_ADDR1,"
				+ "                  ASSR_ADDR2,"
				+ "                  ASSR_ADDR3,"
				+ "                  ASSR_OCC_CODE,"
				+ "                  ASSR_CONTACT,"
				+ "                  ASSR_TEL_AREA_CODE1,"
				+ "                  ASSR_TEL_AREA_CODE2,"
				+ "                  ASSR_TEL_AREA_CODE3,"
				+ "                  ASSR_FAX_AREA_CODE1,"
				+ "                  ASSR_FAX_AREA_CODE2,"
				+ "                  ASSR_FAX_AREA_CODE3,"
				+ "                  ASSR_PHONE,"
				+ "                  ASSR_PHONE2,"
				+ "                  ASSR_PHONE3,"
				+ "                  ASSR_FAX,"
				+ "                  ASSR_FAX2,"
				+ "                  ASSR_FAX3,"
				+ "                  ASSR_DFLT_YN,"
				+ "                  ASSR_CUST_CODE,"
				+ "                  ASSR_BL_NAME,"
				+ "                  ASSR_BL_ADDR1,"
				+ "                  ASSR_BL_ADDR2,"
				+ "                  ASSR_BL_ADDR3,"
				+ "                  ASSR_BL_CONTACT,"
				+ "                  ASSR_CR_DT,"
				+ "                  ASSR_CR_UID,"
				+ "                  ASSR_FRZ_FLAG,"
				+ "                  ASSR_POST_BOX_NO,"
				+ "                  ASSR_ID_NO,"
				+ "                  ASSR_PIN_NO,"
				+ "                  ASSR_DOB,"
				+ "                  ASSR_TYPE ,"
				+ "                  ASSR_GENDER,"
				+ "                  ASSR_MAR_STATUS,"
				+ "                  ASSR_DRV_EXP,"
				+ "                  ASSR_CLAIM_EXP,"
				+ "                 ASSR_PASS_NO,"
				+ "                  ASSR_CPF_NO,"
				+ "                  ASSR_NATIONALITY,"
				+ "                  ASSR_RELIGION,"
				+ "                  ASSR_RACE,"
				+ "                  ASSR_BIRTH_CERT_NO,"
				+ "                 ASSR_ROC_NO,"
				+ "                  ASSR_EMAIL_ID,"
				+ "                  ASSR_TAX_STATUS,"
				+ "                  ASSR_POST_CODE,"
				+ "                  ASSR_STATE_CODE,"
				+ "                  ASSR_CITY)" + "          VALUES(?,?,"
				+ "                  ?," + "                ?,"
				+ "                  ?," + "                  ?,"
				+ "                ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  'N'," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?,"
				+ "                  ?," + "                  ?)";
		String C3_insert = "  INSERT INTO PM_CUST_DIVN "
				+ "     (CDIV_CUST_CODE, CDIV_DIVN_CODE, CDIV_FRZ_FLAG, CDIV_CR_DT, CDIV_CR_UID)"
				+ "         VALUES" + "            ( ?, " + "          ?,"
				+ "      'N'," + "      ?," + "      ?)";
		String C4_insert = " INSERT INTO PM_CUST_CURR "
				+ "               (CCUR_CUST_CODE, CCUR_CURR_CODE, CCUR_FRZ_FLAG, CCUR_CR_DT, CCUR_CR_UID)"
				+ "    VALUES" + " (?, ?,'N',?, ?)";
		try {
			connection = CommonUtils.getConnection();
			if ("Y".equals(CommonUtils.nvl(PM_CUSTOMER_BEAN
					.getCUST_CR_ASSR_YN(), "N"))) {
				values = new Object[] { PM_CUSTOMER_BEAN.getCUST_CODE(),
						PM_CUSTOMER_BEAN.getCUST_NAME(),
						PM_CUSTOMER_BEAN.getCUST_SURNAME(),
						PM_CUSTOMER_BEAN.getCUST_FIRST_NAME(),
						PM_CUSTOMER_BEAN.getCUST_MIDDLE_NAME(),
						PM_CUSTOMER_BEAN.getCUST_LONG_NAME(),
						PM_CUSTOMER_BEAN.getCUST_ADDR1(),
						PM_CUSTOMER_BEAN.getCUST_ADDR2(),
						PM_CUSTOMER_BEAN.getCUST_ADDR3(),
						PM_CUSTOMER_BEAN.getCUST_OCC_CODE(),
						PM_CUSTOMER_BEAN.getCUST_CONTACT(),
						PM_CUSTOMER_BEAN.getCUST_TEL_AREA_CODE(),
						PM_CUSTOMER_BEAN.getCUST_TEL_AREA_CODE2(),
						PM_CUSTOMER_BEAN.getCUST_TEL_AREA_CODE3(),
						PM_CUSTOMER_BEAN.getCUST_FAX_AREA_CODE(),
						PM_CUSTOMER_BEAN.getCUST_FAX_AREA_CODE2(),
						PM_CUSTOMER_BEAN.getCUST_FAX_AREA_CODE3(),
						PM_CUSTOMER_BEAN.getCUST_PHONE(),
						PM_CUSTOMER_BEAN.getCUST_PHONE2(),
						PM_CUSTOMER_BEAN.getCUST_PHONE3(),
						PM_CUSTOMER_BEAN.getCUST_FAX(),
						PM_CUSTOMER_BEAN.getCUST_FAX2(),
						PM_CUSTOMER_BEAN.getCUST_FAX3(),
						PM_CUSTOMER_BEAN.getCUST_CR_ASSR_YN(),
						PM_CUSTOMER_BEAN.getCUST_CODE(),
						PM_CUSTOMER_BEAN.getCUST_BL_NAME(),
						PM_CUSTOMER_BEAN.getCUST_BL_ADDR1(),
						PM_CUSTOMER_BEAN.getCUST_BL_ADDR2(),
						PM_CUSTOMER_BEAN.getCUST_BL_ADDR3(),
						PM_CUSTOMER_BEAN.getCUST_BL_CONTACT(),
						new CommonUtils().getCurrentDate(),
						CommonUtils.getControlBean().getM_USER_ID(),
						PM_CUSTOMER_BEAN.getCUST_POST_BOX_NO(),
						PM_CUSTOMER_BEAN.getCUST_REF_ID1(),
						PM_CUSTOMER_BEAN.getCUST_REF_ID2(),
						PM_CUSTOMER_BEAN.getCUST_DOB(),
						PM_CUSTOMER_BEAN.getCUST_TYPE(),
						PM_CUSTOMER_BEAN.getCUST_CATG_CODE(),
						PM_CUSTOMER_BEAN.getCUST_MAR_STATUS(),
						PM_CUSTOMER_BEAN.getCUST_DRV_EXP(),
						PM_CUSTOMER_BEAN.getCUST_CLAIM_EXP(),
						PM_CUSTOMER_BEAN.getCUST_PASS_NO(),
						PM_CUSTOMER_BEAN.getCUST_CPF_NO(),
						PM_CUSTOMER_BEAN.getCUST_NATIONALITY_CODE(),
						PM_CUSTOMER_BEAN.getCUST_RELIGION(),
						PM_CUSTOMER_BEAN.getCUST_RACE(),
						PM_CUSTOMER_BEAN.getCUST_BIRTH_CERT_NO(),
						PM_CUSTOMER_BEAN.getCUST_ROC_NO(),
						PM_CUSTOMER_BEAN.getCUST_EMAIL_ID_OFF(),
						PM_CUSTOMER_BEAN.getCUST_TAX_STATUS(),
						PM_CUSTOMER_BEAN.getCUST_POSTAL_CODE(),
						PM_CUSTOMER_BEAN.getCUST_STATE(),
						PM_CUSTOMER_BEAN.getCUST_CITY_CODE() };
				handler.executeInsertStatement(C2_insert, connection, values);
			}
			L_INS_PM_CUS_CHK_LIST(PM_CUSTOMER_BEAN.getCUST_CODE());
			M_CS_CODE = P_VAL_CS_PARA(CommonUtils
					.getGlobalVariable("GLOBAL.M_SITE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"), "CUST_ENTRY",
					"CUST_ENTRY", M_CS_CODE);

			if (M_CS_CODE == 1) {
				values = new Object[] { PM_CUSTOMER_BEAN.getCUST_CODE(),
						CommonUtils.getControlBean().getM_DIVN_CODE(),
						new CommonUtils().getCurrentDate(),
						CommonUtils.getControlBean().getM_USER_ID() };
				handler.executeInsertStatement(C3_insert, connection, values);
				c1_ResultSet = handler.executeSelectStatement(C1, connection);
				if (c1_ResultSet.next()) {
					M_CCUR_CURR_CODE = c1_ResultSet.getString(1);
					if ("N".equals(CommonUtils.nvl(PM_CUSTOMER_BEAN
							.getCUST_ALL_CURR_APPL_YN(), "N"))) {
						values = new Object[] {
								PM_CUSTOMER_BEAN.getCUST_CODE(),
								M_CCUR_CURR_CODE,
								new CommonUtils().getCurrentDate(),
								CommonUtils.getControlBean().getM_USER_ID() };
						handler.executeInsertStatement(C4_insert, connection,
								values);
					}
				}
			}
			if ("LI".equals(CommonUtils.nvl(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_2"), "GI"))) {

			}
			if ("Y".equals(CommonUtils.nvl(PM_CUSTOMER_BEAN
					.getCUST_ALL_CURR_APPL_YN(), "N"))) {
				L_INS_PM_CUST_CURR(PM_CUSTOMER_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(c1_ResultSet);
			} catch (Exception e) {
			}
		}
	}


	public void L_INS_PM_CUS_CHK_LIST(String P_CUST_CODE) {
		Connection conn = null;
		try {
			conn = CommonUtils.getConnection();
			CRUDHandler handler = null;
			String selectQuery = "INSERT INTO  PM_CUST_CHK_LIST ( CCHK_SEQ_NO ,    CCHK_CHK_OPTION ,    CCHK_CUST_CODE ,  CCHK_CHK_LIST_STATUS ,    CCHK_CR_DT ,    CCHK_CR_UID )   "
					+ "SELECT    PC_VALUE,    PC_CODE,    ?,    'N',    SYSDATE,  ? FROM  PM_CODES  WHERE  PC_TYPE  = 'CHK_LIST' ";
			if (conn != null) {
				handler = new CRUDHandler();
				Object[] values = { P_CUST_CODE,
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID") };
				handler.executeInsertStatement(selectQuery, conn, values);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public double P_VAL_CS_PARA(String P_SITE_CODE, String P_COMP_CODE,
			String P_PARA_TYPE, String P_PARA_CODE, double P_PARA_VALUE)
					throws SQLException, Exception {

		Connection conn = null;
		double M_PARA_VALUE = 0.0;

		conn = CommonUtils.getConnection();
		String sql_C1 = "SELECT CSVSD_PARA_VALUE FROM  PP_COMP_SITE_VALUE_SET_HDR,   "
				+ "PP_COMP_SITE_VALUE_SET_DTL  "
				+ "WHERE  CSVSH_SITE_CODE  = '"
				+ P_SITE_CODE
				+ "'  "
				+ "AND CSVSH_SYS_ID  = CSVSD_CSVSH_SYS_ID  "
				+ "AND CSVSD_COMP_CODE  = '"
				+ P_COMP_CODE
				+ "'  "
				+ "AND CSVSD_PARA_TYPE  = '"
				+ P_PARA_TYPE
				+ "'  "
				+ "AND CSVSD_PARA_CODE  = '" + P_PARA_CODE + "' ";

		ResultSet vembu_C1 = null;
		Statement stmt_C1 = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		vembu_C1 = stmt_C1.executeQuery(sql_C1);
		if (vembu_C1.next()) {
			M_PARA_VALUE = vembu_C1.getDouble(1);
		}
		//if (!vembu_C1.isLast()) {
		P_PARA_VALUE = M_PARA_VALUE;
		//}
		CommonUtils.closeCursor(vembu_C1);

		return P_PARA_VALUE;
	}


	public void pm006_a_apac_pm_customer_cust_name_when_validate_item(
			PM_CUSTOMER PM_CUSTOMER_BEAN) throws SQLException, Exception {
		Connection conn = null;
		PM006_QE_CUSTOMER customerBean = null;
		String M_STATUS = null;
		String tableName = "PM_CUSTOMER";
		String fieldName = "CUST_NAME";
		String errorMsg = null;

		try {
			//	customerBean = actionBean.getPM006_QE_CUSTOMER_BEAN();
			conn = CommonUtils.getConnection();
			M_STATUS = PKG_PILT002_APAC_QE.callSTP_DUPLICATE_DESC_CHECK(conn, tableName, fieldName,
					PM_CUSTOMER_BEAN.getCUST_NAME(), PM_CUSTOMER_BEAN.getROWID());
			if ("E".equals(M_STATUS)) {
				errorMsg = CommonUtils.getErrorMessageForCode("1306");
				throw new ValidatorException(new FacesMessage(errorMsg));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public void when_validate_item_CUST_SHORT_NAME(
			PM_CUSTOMER PM_CUSTOMER_BEAN) throws Exception {
		String M_STATUS = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			M_STATUS = PKG_PILT002_APAC_QE.callSTP_DUPLICATE_DESC_CHECK(connection, "PM_CUSTOMER",
					"CUST_SHORT_NAME", PM_CUSTOMER_BEAN.getCUST_SHORT_NAME(),
					PM_CUSTOMER_BEAN.getROWID());
			if ("E".equals(M_STATUS)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1306"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}



	public void pre_text_item_CUST_SHORT_NAME(PM_CUSTOMER PM_CUSTOMER_BEAN) {
		if (PM_CUSTOMER_BEAN.getCUST_SHORT_NAME() == null) {
			PM_CUSTOMER_BEAN.setCUST_SHORT_NAME(CommonUtils.SUBSTR(
					PM_CUSTOMER_BEAN.getCUST_NAME(), 1, 30));
		}
	}

	//END

	public void QUOT_MODE_OF_PYMT_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,
			String currValue) throws Exception{

		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();

		PW_IL_QUICK_QUOTE policyBean = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
				.getPW_IL_QUICK_QUOTE_BEAN();

		Connection connection = null;
		ResultSet  rs_mop = null;
		Object[] values = {};
		policyBean.setQUOT_MOP(currValue);


		String query_mop = " SELECT PROD_PREM_PAY_YRS  FROM    PM_IL_PRODUCT WHERE   PROD_CODE = ? ";

		Integer M_PROD1_PREM_PAY_YRS = null;



		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
		try {
			connection = CommonUtils.getConnection();


			if ("Y".equals(policyBean.getQUOT_MOP())
					|| "H".equals(policyBean.getQUOT_MOP())
					|| "M".equals(policyBean.getQUOT_MOP())
					|| "Q".equals(policyBean.getQUOT_MOP())) {
				rs_mop = new CRUDHandler().executeSelectStatement(query_mop, connection,
						new Object[] { policyBean.getQUOT_PROD_CODE() });

				if (rs_mop.next()) {
					//	policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
					M_PROD1_PREM_PAY_YRS = rs_mop.getInt(1);
					//policyBean.setQUOT_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);
					//policyBean.setQUOT_PREM_PAY_YRS(policyBean.getQUOT_PERIOD());
					policyBean.setQUOT_PREM_PAY_YRS(policyBean.getQUOT_PERIOD());
				/*	commented by dhinesh for term issue on 26-10-2016
				 * 
				 * if(policyBean.getQUOT_PREM_PAY_YRS()!=policyBean.getQUOT_PERIOD()){
						compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
								"current","Term and Premium Paying Term is not same");
					}*/
				}
			} else {
				//policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
				policyBean.setQUOT_PREM_PAY_YRS(1);
			}
			/*
			 * if("U".equalsIgnoreCase(dummyBean.getUI_M_POL_PLAN_TYPE())){
			 * thresholdLimitAddingForUlip(policyBean, compositeAction,
			 * policyBean.getPOL_FC_SUM_ASSURED(),prevFcSA); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {

				CommonUtils.closeCursor(rs_mop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public Double calculatenetpremium(){



		return null;

	}


	public void QUOT_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK(
			PILT002_APAC_QE_COMPOSITE_ACTION compositeAction, Double currValue) throws Exception {

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();


		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		Double M_PLAN_MIN_SA = 0.0;
		Double M_PLAN_MAX_SA = 0.0;
		String query1 = " SELECT PLAN_MIN_SA, PLAN_MAX_SA  FROM   PM_IL_PLAN "
				+ " WHERE  PLAN_CODE = ? ";
		try {
			
			System.out.println("Inside QUOT_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK method ");
			 if(PW_IL_QUICK_QUOTE_BEAN
				.getQUOT_PLAN_CODE()!=null){
			connection = CommonUtils.getConnection();

			values = new Object[] { PW_IL_QUICK_QUOTE_BEAN
					.getQUOT_PLAN_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query1, connection,
					values);

			while (rs.next()) {
				M_PLAN_MIN_SA = rs.getDouble(1);
				M_PLAN_MAX_SA = rs.getDouble(2);
			}

	/*	Commented by pidugu raj since for Fc sum assured no need to show validation	
	 * if ((CommonUtils.nvl(currValue, 0.0) < CommonUtils.nvl(
					M_PLAN_MIN_SA, 0))
					|| CommonUtils.nvl(currValue, 0.0) > CommonUtils
					.nvl(M_PLAN_MAX_SA, 0)) {
				String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
						.toPlainString());


				throw new Exception(
						Messages
						.getString(
								PELConstants.pelErrorMessagePath,
								"3206",
								new Object[] { " Sum Assured Should be between "
										+ M_PLAN_MIN_SA
										+ " and " + plan_max_sa }));



			}*/

			System.out.println("M_PLAN_MIN_SA   : "+M_PLAN_MIN_SA);
			System.out.println("M_PLAN_MAX_SA   : "+M_PLAN_MAX_SA);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
			/**/
		}
	}

	/*public void updatecustcode(){


		String uquery=" =? where QUOT_SYS_ID= ?";

	}*/


	public void updatecustcode(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception{

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN =compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();	
		String new_cust_code=PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE();
		System.out.println("updatemandatoryflag   updatemandatoryflag   updatemandatoryflag   updatemandatoryflag");

		String query = "UPDATE PW_IL_QUICK_QUOTE SET  QUOT_CUST_CODE='"+new_cust_code+"' WHERE QUOT_SYS_ID= ?  "; 
		String query1 = "UPDATE PW_IL_QQUOT_ASSURED_DTLS SET  QQAD_ASSR_CODE='"+new_cust_code+"' WHERE QQAD_QUOT_SYS_ID= ?  "; 


		new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {
				PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});
		connection.commit();
		new CRUDHandler().executeUpdateStatement(query1, connection,new Object[] {
				PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});
		connection.commit();
	}


	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
			int decimalPlaces=0;
			System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
			decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
			System.out.println("decimalPlaces   : "+decimalPlaces);


			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);

			return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}




	public void IL_UNIQUE_ADDL_COVER_ASSR_CODE(	String P_POAD_SYS_ID, String POL_SYS_ID, String P_COVER_CODE) throws Exception {

		String M_ADDL_COVER_CODE = null;
		String CURSOR_C1 =  "SELECT 'X' FROM   PW_IL_QQUOT_APPL_COVER WHERE  QQAC_QQAD_SYS_ID =  ? "
				+ "AND    QQAC_COVER_CODE = ?  AND  QQAC_QUOT_SYS_ID = ? ";

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {



			resultSet = handler.executeSelectStatement(CURSOR_C1,
					CommonUtils.getConnection(), new Object[] { P_POAD_SYS_ID,
				P_COVER_CODE, POL_SYS_ID });
			if (resultSet.next()) {
				M_ADDL_COVER_CODE = resultSet.getString(1);
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath,
								"71039"));
			}
			CommonUtils.closeCursor(resultSet);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}



	public void updateQUOT_MED_YNflag(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) throws Exception{

		PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN();
		PW_IL_QQUOT_ASSURED_DTLS PW_IL_QQUOT_ASSURED_DTLS_BEAN = compositeAction
				.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN();

		System.out.println("PW_IL_QQUOT_ASSURED_DTLS_BEAN.getQQAD_AGE()    " +PW_IL_QQUOT_ASSURED_DTLS_BEAN.getQQAD_AGE() );
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()    " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA() );

		/*Modified by Ram on 17/12/2016 for Medical Remarks capturing
		 * 
		 * if(PW_IL_QQUOT_ASSURED_DTLS_BEAN.getQQAD_AGE()<45&&PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()>200000){
			System.out.println("First Loop executing");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN("Y");

		}	else if(PW_IL_QQUOT_ASSURED_DTLS_BEAN.getQQAD_AGE()>37&&PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()>100000){
			System.out.println("Second Loop executing");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN("Y");

		}	else if(PW_IL_QQUOT_ASSURED_DTLS_BEAN.getQQAD_AGE()>55&&PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()>75000){
			System.out.println("Third Loop executing");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN("Y");
		}else{
			System.out.println("Fourth Loop executing");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN("N");
		}*/
		System.out.println("Values      "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE()+" "+
				 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PROD_CODE()+"     "+
				 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_FC_SA());
		String medicalQuery = "SELECT F_GET_QUOT_MED_YN(?,?,?) FROM DUAL";
		ResultSet rs = new CRUDHandler().executeSelectStatement(medicalQuery, CommonUtils.getConnection(),new Object[]
				{compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE(),
				 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PROD_CODE(),
				 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_FC_SA()
				}
		);
		if(rs.next())
		{
			String value = rs.getString(1);
			System.out.println("Enter into if statement  "+value);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN(value);
		}
		else
		{
			System.out.println("Enter into else statement");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN("N");
		}
		/*End*/

		/*Modifed by Ram on 06/04/2017 as per Vinoth & Gopi suggetsion*/
		/*		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQAT_MEDICAL_YN().setDisabled(false);
*/		
		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQAT_MEDICAL_YN().setDisabled(true);
/*End*/
		
		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QQAT_MEDICAL_YN().resetValue();


		/*Added by Ram on 24/11/2016 for Medical Related Validations*/
		 if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_YN() != null && PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_YN().equals("Y"))
		{
			System.out.println("Enable Medical Received and Remarks");
			 
			
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REC_YN_CHK().setDisabled(false);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REMARKS().setDisabled(false);
			
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REMARKS().resetValue();
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REC_YN_CHK().resetValue();
		}
		else
		{
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().setQUOT_MED_REC_YN_CHK(false);
			
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REMARKS(null);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REC_YN_CHK().setDisabled(true);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REMARKS().setDisabled(true);
			
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REMARKS().resetValue();
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_MED_REC_YN_CHK().resetValue();
		}
		
		
		 
		/*End*/

	}

	public void loadcurrency() throws DBException, Exception{
		String base_currency = null;

		ArrayList<String> pValList = new ArrayList<String>();

		pValList = DBProcedures.P_VAL_FINAL_PARAMETER(CommonUtils.getConnection(),
				"BASE.CURR", "E");
		// ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
		if (pValList != null && pValList.size() > 0) {
			base_currency=pValList.get(0);
		}
		
		CommonUtils.setGlobalVariable("GLOBAL.CURRENCY_CODE",base_currency);
		CommonUtils.setGlobalObject("CURRENCY", makeCurrDecimalglobal(base_currency));	

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********"    +CommonUtils.getGlobalObject("CURRENCY"));
	}


	public int makeCurrDecimalglobal(String currcode){

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
		System.out.println("currcode    : "+currcode);

		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";

		int CURR_DECI = 0;

		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { currcode });
			if (resultSet.next()) {
				CURR_DECI = resultSet.getInt("CURR_DECIMAL");
			}

			System.out.println("CURR_DECI    : "+CURR_DECI);
			CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
			System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CURR_DECI;
	} 

	public void L_CHK_BANK(String P_BANK_CODE,String P_ERR_FLAG,PW_IL_QUICK_QUOTE_ACTION action) throws Exception{
		String C1 = "SELECT BANK_CODE   FROM   FM_BANK   WHERE  BANK_NAME = ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_BANK_NAME = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(P_BANK_CODE!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{P_BANK_CODE});
				if (C1_REC.next()) {
					M_BANK_NAME = C1_REC.getString(1);
					
					/*Added by Ram on 20/11/2016 for BankCode value setting*/
					action.getPW_IL_QUICK_QUOTE_BEAN().setQUOT_BANK_CODE_ORI(M_BANK_NAME);
					/*End*/
					
				}else if("E".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));

				}else if("N".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}
		}catch(Exception exception){
			throw exception;
		}
	}




	public void POC_CHRG_CODE_WHEN_VALIDATE_ITEM(PW_IL_QQUOT_APPL_CHARGE chargeBean,Long ouot_sys_id) throws Exception{
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			IL_UNIQUE_CHARGE_CODE(chargeBean.getQQAC_CHRG_CODE(),
					ouot_sys_id,
					chargeBean.getROWID());
			if (chargeBean.getQQAC_CHRG_CODE() !=  null) {
				list =  procedures.P_VAL_CODES("IL_CHARGE",chargeBean.getQQAC_CHRG_CODE() ,
						chargeBean.getUI_M_CHRG_DESC(),"N","E",null);
				if(list!=null){
					chargeBean.setUI_M_CHRG_DESC(list.get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}








	public void IL_UNIQUE_CHARGE_CODE(String POC_CHRG_CODE,
			Long POC_POL_SYS_ID, String ROW_ID) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM PW_IL_QQUOT_APPL_CHARGE WHERE  QQAC_CHRG_CODE =  ? " +
				"AND  QQAC_QUOT_SYS_ID =  ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PW_IL_QQUOT_APPL_CHARGE WHERE  QQAC_CHRG_CODE = ? " +
				"AND  QQAC_QUOT_SYS_ID =  ? AND  ROWID <> ? ";
		String M_CHARGE_CODE = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (ROW_ID == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { POC_CHRG_CODE,
						POC_POL_SYS_ID });
				if (resultSet.next()) {
					M_CHARGE_CODE = resultSet.getString(1);
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"91002")));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { POC_CHRG_CODE,
						POC_POL_SYS_ID, ROW_ID });
				if (resultSet.next()) {
					M_CHARGE_CODE = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91002"));
				}
				CommonUtils.closeCursor(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	/*	Added by sankaraNarayanan for FALCONLIFE-1345285 on 13-10-16*/
	
	public void DeleteCoverWhenProductChange(PW_IL_QUICK_QUOTE policyBean) throws Exception {
		System.out.println("Welcome to PostUpdate funtionin Quick Quoe screen");
		ResultSet resultSet = null;
		ArrayList<String> retList = null;
				try {
					
					
					String producrChange ="SELECT * FROM PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID= ? AND QUOT_PROD_CODE= ? AND QUOT_IDX_NO= ?";
					Object[] values = new Object[] { policyBean.getQUOT_SYS_ID() ,policyBean.getQUOT_PROD_CODE(), policyBean.getQUOT_IDX_NO()};
					resultSet = new CRUDHandler().executeSelectStatement(producrChange,
					CommonUtils.getConnection(),values);
					if (!(resultSet.next())) {
					
						/*retList = PKG_PILT002_APAC_QE
								.P_PROD_CHNG(String.valueOf(policyBean.getQUOT_SYS_ID()),
										policyBean.getQUOT_PROD_CODE(), 
										new CommonUtils().dateToStringFormat(policyBean.getQUOT_ISS_DT()));		*/	
						retList = PKG_PILT002_APAC_QE
								.P_PROD_CHNG(String.valueOf(policyBean.getQUOT_SYS_ID()));	
						PKG_PILT002_APAC_QE.P_INS_ADDL_COVER(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_PROD_CODE(),"N");
						
						/*Added by Ram on 14/11/2016 for Condition issue*/
						PKG_PILT002_APAC_QE.P_INS_APPL_COND(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_PROD_CODE());
						/*End*/
						
					}
					/*Added by Ram on 19/11/2016 for Condition issue*/
					else
					{
						
						PKG_PILT002_APAC_QE.P_INS_APPL_COND(String.valueOf(policyBean.getQUOT_SYS_ID()),policyBean.getQUOT_PROD_CODE());
						
					}
					/*End*/
				
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}finally {
					try {
						CommonUtils.closeCursor(resultSet);
					} catch (Exception e) {
					}
				}
			}
	
	/*END*/
	
	/*Added by Ram on 20/12/2016 for Age Calculation*/
	public void QUOT_FM_DT_WHEN_VALIDATE_ITEM(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,PW_IL_QUICK_QUOTE Quick_Bean,java.util.Date POAD_DOB,PW_IL_QQUOT_ASSURED_DTLS Quick_Dtls) throws Exception
	{
		System.out.println("inside POAD_DOB_WHEN_VALIDATE_ITEM in helper");

		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			 
			calculateAge(compositeAction, Quick_Bean, POAD_DOB, Quick_Dtls);
			
			/*Added by Ram on 07/12/2016 for set Gender defaultvalue*/
System.out.println("Age is      "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE());
setGender(compositeAction);
/*End*/

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	/*End*/	
	
	
	/*Added by saritha on 25-01-2017 for On entering the Salutation,the respective Gender to be defaulted in Quotation Screen*/
	
	public void when_validate_item_QUOT_CUST_TITLE(PW_IL_QQUOT_ASSURED_DTLS PW_IL_QUICK_QUOTE_DTLS_BEAN,PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN)throws Exception {
		try
		{

			if((PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("1") ||PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("4")))
			{
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CATG_CODE("1");
			}
			else if((PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("5") || PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("6")||PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("7")||
					PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE().equalsIgnoreCase("8")))
			{
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CATG_CODE("2");

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	/*End*/

	/*Added by Ram on 30/12/2016 for Existing customer validation*/
	public void checkExistingUser(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction,
			PW_IL_QUICK_QUOTE Quick_Bean,
			java.util.Date POAD_DOB,
			PW_IL_QQUOT_ASSURED_DTLS Quick_Dtls) throws Exception
	{
		 Connection conn = null;
		 ResultSet rs = null;
		try {
			System.out.println("Enter into checkExistingUser");
			conn = CommonUtils.getConnection();
			
			/*Reverted by Ram on 23/01/2017 for Existing customer validation handle in Save button click*/
			/*String query = "SELECT * FROM PW_IL_QUICK_QUOTE,PW_IL_QQUOT_ASSURED_DTLS "
					+ "WHERE QUOT_CUST_NAME = ? AND QUOT_CUST_SURNAME = ? AND QQAD_ASSR_DOB = TO_DATE(?,'dd/MM/yyyy')"
					+ " AND QUOT_SYS_ID = QQAD_QUOT_SYS_ID";*/
			String query = "SELECT * FROM PW_IL_QUICK_QUOTE,PW_IL_QQUOT_ASSURED_DTLS "
					+ "WHERE UPPER(QUOT_CUST_NAME) = UPPER(?) AND QQAD_ASSR_DOB = TO_DATE(?,'dd/MM/yyyy')"
					+ " AND QUOT_SYS_ID = QQAD_QUOT_SYS_ID";
			/*End*/
			
			System.out.println("Values are      "+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_CUST_NAME()+"      "
					+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_CUST_SURNAME()+"       "
					+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB()+"     "
					+new CommonUtils().dateToStringFormat(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB()));
			
			/*Remove lastname parameter by Ram on 23/01/2017*/
			rs = new CRUDHandler().executeSelectStatement(query, conn,new Object[]{
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_CUST_NAME(),
					new CommonUtils().dateToStringFormat(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB())
			});
			/*End*/
			int existingCount = 0;
			while(rs.next())
			{
				/*Reverted by Ram on 23/01/2017 to control validations in update scenario for same quotation*/
				/*Commented by Ram on 17/01/2017 as per Kuzhandhai discussion*/
				System.out.println("compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO()       "
						+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO()+"   rs.getString(QUOT_NO)   "+rs.getString("QUOT_NO"));
				if(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getROWID() == null)
				{
					existingCount++;
					
					 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().setEXIST_QUOT_NO(rs.getString("QUOT_NO")); 
				}
				else
				{
					 if(rs.getString("QUOT_NO") != null && compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO() != null)
						{
							if(!(rs.getString("QUOT_NO").equals(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO())))
							{ 
								existingCount++;
								
								 compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().setEXIST_QUOT_NO(rs.getString("QUOT_NO")); 
							 }
						}
				}
				   
				/*End*/
			}
			System.out.println("existingCount        "+existingCount);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().setEXISTING_COUNT(existingCount);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}


	}
/*End*/
	
}

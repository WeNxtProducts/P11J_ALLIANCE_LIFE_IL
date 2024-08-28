package com.iii.pel.forms.PILT002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.pel.utils.PremiaLib;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSURED_DTLS_HELPER {

	public PT_IL_POL_ASSURED_DTLS_ACTION actionBean;
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		System.out.println("executeQuery for PT_IL_POL_ASSURED_DTLS_HELPER class");
		new PT_IL_POL_ASSURED_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);
	}

	public ArrayList<String> IL_DISC_AGE(PILT002_APAC_COMPOSITE_ACTION compositeAction ,Integer P_CURR_AGE, String P_CATG_CODE,
			String P_ADDL_RISK_CODE, java.util.Date P_START_DT,
			Integer P_DISC_AGE) throws Exception {

		Integer M_DA_UW_AGE = null;
		String M_APP_ON =null;
		String M_COVER_DISC_AGE_YN = null;
		ArrayList<String> list =new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet3=null;
		String POL_PLAN_CODE = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_PLAN_CODE();
		Object[] values = null;
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();

		String CURSER_C1 = "SELECT DA_UW_AGE FROM   PM_IL_DISC_AGE WHERE  DA_ADDL_RISK_CODE = ?"
				+ " AND    DA_CATG_CODE = ?  AND   ?   BETWEEN NVL(DA_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/YYYY'))"
				+ " AND NVL(DA_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/YYYY'))";
		String CURSER_C2 = "SELECT NVL(COVER_DISC_AGE_YN,'N') FROM   PM_IL_COVER"
				+ " WHERE  COVER_CODE = ? ";

		String CURSOR_C3="SELECT PDL_APPLIED_ON  FROM PT_IL_POL_DISC_LOAD WHERE PDL_POL_SYS_ID = ?";

		try {
			connection = CommonUtils.getConnection();
			resultSet3= handler.executeSelectStatement(CURSOR_C3, connection,new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if(resultSet3.next()){
				M_APP_ON = resultSet3.getString(1);
			}
			if(!"11".equalsIgnoreCase(M_APP_ON)){

				resultSet = handler.executeSelectStatement(CURSER_C2, connection,
						new Object[] { POL_PLAN_CODE });
				if (resultSet.next()) {
					M_COVER_DISC_AGE_YN = resultSet.getString(1);
				}

				if ("Y".equals(M_COVER_DISC_AGE_YN)) {
					resultSet1 = handler.executeSelectStatement(CURSER_C1,
							connection, new Object[] { P_ADDL_RISK_CODE,
							P_CATG_CODE,P_START_DT });
					if (resultSet1.next()) {
						M_DA_UW_AGE = resultSet1.getInt(1);
						P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0)
								- CommonUtils.nvl(M_DA_UW_AGE, 0);
					} else {
						P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0);
					}

				} else {
					P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0);
				}
				list.add(CommonUtils.integerToString(P_DISC_AGE));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return   list;
	}

	public void L_INSERT_PT_IL_POL_ASSUR_DTLS(String M_REF_ID1,
			DUMMY DUMMY_BEAN, String M_REF_ID2,
			PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {
		String M_POAD_OCC_CODE = null;
		String M_VALUE = null;
		Double M_PS_VALUE  = null;
		String M_POAD_ASSR_CODE = null;
		String M_POAD_ASSURED_NAME = null;
		String M_POAD_BIRTH_PLACE = null;
		Date M_POAD_DOB = null;
		Integer M_POAD_AGE  = null;
		String M_POAD_NATIONALITY = null;
		String M_POAD_MAR_STATUS = null;
		String M_POAD_NATURE_OF_WORK = null;
		String M_POAD_HEALTH_CODE = null;
		String M_POAD_REMARKS = null;
		Date M_POAD_CR_DT = null;
		String M_POAD_CR_UID = null;
		Date M_POAD_UPD_DT = null;
		String M_POAD_UPD_UID = null;
		String M_POAD_CATG_CODE = null;
		Double M_POAD_HEALTH_RATE = null;
		Double M_POAD_HEIGHT = null;
		Double M_POAD_WEIGHT = null;
		Integer M_POAD_DISC_AGE = null;
		String M_POAD_ADDL_RISK_CODE = null;

		String M_POAD_AGE_PROOF_FLAG = null;
		String M_POAD_AGE_PROOF_OTHERS = null;

		String M_POAD_REF_ID1 = null;
		String M_POAD_REF_ID2 = null;
		String M_POAD_OCC_CLASS = null;
		Double M_POAD_BMI = null;
		String M_POAD_RACE = null;
		String M_POAD_RELIGION_CODE = null;
		String M_POAD_TYPE = null;
		String M_POAD_HEIGHT_UNIT = null;
		String M_POAD_WEIGHT_UNIT = null;
		Double M_POAD_FC_SALARY = null;
		Double M_POAD_LC_SALARY = null;
		String M_POAD_SMOKE_YN = null;
		Integer M_POAD_NO_OF_CIGAR = null;
		Long M_PIL_POAD_SYS_ID = null;
		Long M_POAD_SERIAL_NO = null;
		String M_INSERT = null;
		String M_DUMMY = null;
		String M_CODE_DESC = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_REF_ID1 = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_REF_ID2 = ? ";
		String CURSOR_C3 = "SELECT 'X' FROM   PM_IL_CONTRACTOR WHERE  CONT_REF_ID1 = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM   PM_IL_CONTRACTOR WHERE  CONT_REF_ID2 = ? ";
		String CURSOR_C7 = "SELECT  POAD_ASSR_CODE,POAD_ASSURED_NAME, POAD_BIRTH_PLACE, POAD_DOB,"
				+ "POAD_AGE,POAD_NATIONALITY,  POAD_MAR_STATUS,  POAD_OCC_CODE,POAD_NATURE_OF_WORK,"
				+ "POAD_HEALTH_CODE,POAD_REMARKS,POAD_CR_DT,POAD_CR_UID,POAD_UPD_DT,POAD_UPD_UID,"
				+ "POAD_CATG_CODE,POAD_HEALTH_RATE,POAD_HEIGHT,POAD_WEIGHT,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
				+ "POAD_AGE_PROOF_FLAG,POAD_AGE_PROOF_OTHERS,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,"
				+ "POAD_BMI,POAD_RACE,POAD_RELIGION_CODE,POAD_TYPE,POAD_HEIGHT_UNIT,POAD_WEIGHT_UNIT,"
				+ "POAD_FC_SALARY,POAD_LC_SALARY,POAD_SMOKE_YN, POAD_NO_OF_CIGAR"
				+ " FROM    PT_IL_POL_ASSURED_DTLS WHERE   POAD_REF_ID1= ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC";
		String CURSOR_C8 = "SELECT  POAD_ASSR_CODE,POAD_ASSURED_NAME, POAD_BIRTH_PLACE, POAD_DOB,"
				+ "POAD_AGE,POAD_NATIONALITY,POAD_MAR_STATUS,POAD_OCC_CODE,POAD_NATURE_OF_WORK,"
				+ "POAD_HEALTH_CODE,POAD_REMARKS,POAD_CR_DT,POAD_CR_UID,POAD_UPD_DT,POAD_UPD_UID,"
				+ "POAD_CATG_CODE,POAD_HEALTH_RATE,POAD_HEIGHT,POAD_WEIGHT,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
				+ "POAD_AGE_PROOF_FLAG,POAD_AGE_PROOF_OTHERS,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,POAD_BMI,"
				+ "POAD_RACE,POAD_RELIGION_CODE,POAD_TYPE,POAD_HEIGHT_UNIT,POAD_WEIGHT_UNIT,POAD_FC_SALARY,"
				+ "POAD_LC_SALARY,POAD_REF_ID1, POAD_REF_ID2,POAD_SMOKE_YN, POAD_NO_OF_CIGAR "
				+ "FROM  PT_IL_POL_ASSURED_DTLS WHERE   POAD_REF_ID2= ?  ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC";
		String CURSOR_C9 = "SELECT  CONT_REF_ID1,NVL(CONT_REF_ID2,CONT_PASS_NO), CONT_CODE,CONT_NAME,CONT_DOB,"
				+ "CONT_CATG_CODE,CONT_MAR_STATUS,CONT_NATIONALITY_CODE,CONT_RACE,   CONT_RELIGION "
				+ "FROM PM_IL_CONTRACTOR WHERE    CONT_REF_ID1 = ? ORDER BY NVL(CONT_UPD_DT,CONT_CR_DT) DESC";
		String CURSOR_C10 = "SELECT CONT_REF_ID1, NVL(CONT_REF_ID2,CONT_PASS_NO),CONT_CODE,CONT_NAME,CONT_DOB,"
				+ "CONT_CATG_CODE,CONT_MAR_STATUS,CONT_NATIONALITY_CODE,CONT_RACE,CONT_RELIGION FROM PM_IL_CONTRACTOR "
				+ "WHERE NVL(CONT_REF_ID2,CONT_PASS_NO) = P_CONT_REF_ID2 ORDER BY NVL(CONT_UPD_DT,CONT_CR_DT) DESC";
		String CURSOR_C9_A = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_REF_ID1 = ? ";
		String CURSOR_C10_A = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE NVL(CUST_REF_ID2,CUST_PASS_NO) = ?";
		String CURSOR_C11 = "SELECT CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID1 = ? ";
		String CURSOR_C12 = "SELECT CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID2 = ? ";
		String CURSOR_C13 = "SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE = 'IL_OCC_CLASS' "
				+ "AND PC_FRZ_FLAG = 'N' AND   PC_VALUE    IN  (SELECT PC_VALUE FROM   PM_CODES "
				+ "WHERE  PC_TYPE  ='IL_OCCU' AND    PC_CODE  =  ? )";
		String CURSOR_C14 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_OCCDEF_YN'";
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ArrayList<String> list = new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();


		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C14, connection);
			if (resultSet.next()) {
				M_PS_VALUE = resultSet.getDouble(1);
			}
			if (M_REF_ID1 != null) {
				resultSet1 = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { M_REF_ID1 });
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getString(1);
					resultSet2 = handler.executeSelectStatement(CURSOR_C7,
							connection, new Object[] { M_REF_ID1 });
					while (resultSet2.next()) {
						M_POAD_ASSR_CODE = resultSet2.getString(1);
						M_POAD_ASSURED_NAME = resultSet2.getString(2);
						M_POAD_BIRTH_PLACE = resultSet2.getString(3);
						M_POAD_DOB = resultSet2.getDate(4);
						M_POAD_AGE = resultSet2.getInt(5);
						M_POAD_NATIONALITY = resultSet2.getString(6);
						M_POAD_MAR_STATUS = resultSet2.getString(7);
						M_POAD_OCC_CODE = resultSet2.getString(8);
						M_POAD_NATURE_OF_WORK = resultSet2.getString(9);
						M_POAD_HEALTH_CODE = resultSet2.getString(10);
						M_POAD_REMARKS = resultSet2.getString(11);
						M_POAD_CR_DT = resultSet2.getDate(12);
						M_POAD_CR_UID = resultSet2.getString(13);
						M_POAD_UPD_DT = resultSet2.getDate(14);
						M_POAD_UPD_UID = resultSet2.getString(15);
						M_POAD_CATG_CODE = resultSet2.getString(16);
						M_POAD_HEALTH_RATE = resultSet2.getDouble(17);
						M_POAD_HEIGHT = resultSet2.getDouble(18);
						M_POAD_WEIGHT = resultSet2.getDouble(19);
						M_POAD_DISC_AGE = resultSet2.getInt(20);
						M_POAD_ADDL_RISK_CODE = resultSet2.getString(21);
						M_POAD_AGE_PROOF_FLAG = resultSet2.getString(22);
						M_POAD_AGE_PROOF_OTHERS = resultSet2.getString(23);
						M_POAD_REF_ID1 = resultSet2.getString(24);
						M_POAD_REF_ID2 = resultSet2.getString(25);
						M_POAD_OCC_CLASS = resultSet2.getString(26);
						M_POAD_BMI = resultSet2.getDouble(27);
						M_POAD_RACE = resultSet2.getString(28);
						M_POAD_RELIGION_CODE = resultSet2.getString(29);
						M_POAD_TYPE = resultSet2.getString(30);
						M_POAD_HEIGHT_UNIT = resultSet2.getString(31);
						M_POAD_WEIGHT_UNIT = resultSet2.getString(32);
						M_POAD_FC_SALARY = resultSet2.getDouble(33);
						M_POAD_LC_SALARY = resultSet2.getDouble(34);
						M_POAD_SMOKE_YN = resultSet2.getString(35);
						M_POAD_NO_OF_CIGAR = resultSet2.getInt(36);
						M_INSERT = "Y";
					}
					CommonUtils.closeCursor(resultSet2);
				} else {
					resultSet2 = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] { M_REF_ID1 });
					if (resultSet2.next()) {
						M_DUMMY = resultSet2.getString(1);
						resultSet3 = handler.executeSelectStatement(CURSOR_C9,
								connection, new Object[] { M_REF_ID1 });
						if (resultSet3.next()) {
							M_POAD_REF_ID1 = resultSet3.getString(1);
							M_POAD_REF_ID2 = resultSet3.getString(2);
							M_POAD_ASSR_CODE = resultSet3.getString(3);
							M_POAD_ASSURED_NAME = resultSet3.getString(4);
							M_POAD_DOB = resultSet3.getDate(5);
							M_POAD_CATG_CODE = resultSet3.getString(6);
							M_POAD_MAR_STATUS = resultSet3.getString(7);
							M_POAD_NATIONALITY = resultSet3.getString(8);
							M_POAD_RACE = resultSet3.getString(9);
							M_POAD_RELIGION_CODE = resultSet3.getString(10);

						}
						CommonUtils.closeCursor(resultSet3);
						resultSet3 = handler.executeSelectStatement(
								CURSOR_C9_A, connection,
								new Object[] { M_REF_ID1 });
						if (resultSet3.next()) {
							M_POAD_ASSR_CODE = resultSet3.getString(1);
							M_POAD_ASSURED_NAME = resultSet3.getString(2);
						}
						CommonUtils.closeCursor(resultSet3);
						if (M_PS_VALUE == 1) {
							resultSet3 = handler.executeSelectStatement(
									CURSOR_C11, connection,
									new Object[] { M_REF_ID1 });
							if (resultSet3.next()) {
								M_POAD_OCC_CODE = resultSet3.getString(1);
							}
							CommonUtils.closeCursor(resultSet3);
						}
						if (M_POAD_OCC_CODE != null) {
							resultSet3 = handler.executeSelectStatement(
									CURSOR_C13, connection,
									new Object[] { M_POAD_OCC_CODE });
							if (resultSet3.next()) {
								M_POAD_OCC_CLASS = resultSet3.getString(1);
							}
						}
						M_INSERT = "Y";
						CommonUtils.closeCursor(resultSet3);
					}
					CommonUtils.closeCursor(resultSet2);
				}
				CommonUtils.closeCursor(resultSet1);
			} else if (M_REF_ID2 != null) {
				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { M_REF_ID2 });
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getString(1);
					resultSet2 = handler.executeSelectStatement(CURSOR_C8,
							connection, new Object[] { M_REF_ID2 });
					while (resultSet2.next()) {
						M_POAD_ASSR_CODE = resultSet2.getString(1);
						M_POAD_ASSURED_NAME = resultSet2.getString(2);
						M_POAD_BIRTH_PLACE = resultSet2.getString(3);
						M_POAD_DOB = resultSet2.getDate(4);
						M_POAD_AGE = resultSet2.getInt(5);
						M_POAD_NATIONALITY = resultSet2.getString(6);
						M_POAD_MAR_STATUS = resultSet2.getString(7);
						M_POAD_OCC_CODE = resultSet2.getString(8);
						M_POAD_NATURE_OF_WORK = resultSet2.getString(9);
						M_POAD_HEALTH_CODE = resultSet2.getString(10);
						M_POAD_REMARKS = resultSet2.getString(11);
						M_POAD_CR_DT = resultSet2.getDate(12);
						M_POAD_CR_UID = resultSet2.getString(13);
						M_POAD_UPD_DT = resultSet2.getDate(14);
						M_POAD_UPD_UID = resultSet2.getString(15);
						M_POAD_CATG_CODE = resultSet2.getString(16);
						M_POAD_HEALTH_RATE = resultSet2.getDouble(17);
						M_POAD_HEIGHT = resultSet2.getDouble(18);
						M_POAD_WEIGHT = resultSet2.getDouble(19);
						M_POAD_DISC_AGE = resultSet2.getInt(20);
						M_POAD_ADDL_RISK_CODE = resultSet2.getString(21);
						M_POAD_AGE_PROOF_FLAG = resultSet2.getString(22);
						M_POAD_AGE_PROOF_OTHERS = resultSet2.getString(23);
						M_POAD_REF_ID1 = resultSet2.getString(24);
						M_POAD_REF_ID2 = resultSet2.getString(25);
						M_POAD_OCC_CLASS = resultSet2.getString(26);
						M_POAD_BMI = resultSet2.getDouble(27);
						M_POAD_RACE = resultSet2.getString(28);
						M_POAD_FC_SALARY = resultSet2.getDouble(29);
						M_POAD_LC_SALARY = resultSet2.getDouble(30);
						M_POAD_SMOKE_YN = resultSet2.getString(31);
						M_POAD_NO_OF_CIGAR = resultSet2.getInt(32);
						M_INSERT = "Y";
					}
					CommonUtils.closeCursor(resultSet2);
				} else {
					resultSet2 = handler.executeSelectStatement(CURSOR_C4,
							connection, new Object[] { M_REF_ID2 });
					if (resultSet2.next()) {
						M_DUMMY = resultSet2.getString(1);
						resultSet3 = handler.executeSelectStatement(CURSOR_C10,
								connection, new Object[] { M_REF_ID2 });
						if (resultSet3.next()) {
							M_POAD_REF_ID1 = resultSet3.getString(1);
							M_POAD_REF_ID2 = resultSet3.getString(2);
							M_POAD_ASSR_CODE = resultSet3.getString(3);
							M_POAD_ASSURED_NAME = resultSet3.getString(4);
							M_POAD_DOB = resultSet3.getDate(5);
							M_POAD_CATG_CODE = resultSet3.getString(6);
							M_POAD_MAR_STATUS = resultSet3.getString(7);
							M_POAD_NATIONALITY = resultSet3.getString(8);
							M_POAD_RACE = resultSet3.getString(9);
							M_POAD_RELIGION_CODE = resultSet3.getString(10);

						}
						CommonUtils.closeCursor(resultSet3);
						resultSet3 = handler.executeSelectStatement(
								CURSOR_C10_A, connection,
								new Object[] { M_REF_ID2 });
						if (resultSet3.next()) {
							M_POAD_ASSR_CODE = resultSet3.getString(1);
							M_POAD_ASSURED_NAME = resultSet3.getString(2);
						}
						CommonUtils.closeCursor(resultSet3);
						if (M_PS_VALUE == 1) {
							resultSet3 = handler.executeSelectStatement(
									CURSOR_C12, connection,
									new Object[] { M_REF_ID2 });
							if (resultSet3.next()) {
								M_POAD_OCC_CODE = resultSet3.getString(1);
							}
							CommonUtils.closeCursor(resultSet3);
						}
						if (M_POAD_OCC_CODE != null) {
							resultSet3 = handler.executeSelectStatement(
									CURSOR_C13, connection,
									new Object[] { M_POAD_OCC_CODE });
							if (resultSet3.next()) {
								M_POAD_OCC_CLASS = resultSet3.getString(1);
							}
						}
						M_INSERT = "Y";
						CommonUtils.closeCursor(resultSet3);
					}
					CommonUtils.closeCursor(resultSet2);
				}
				CommonUtils.closeCursor(resultSet1);

			}

			if ("Y".equals(CommonUtils.nvl(M_INSERT, "N"))) {
				ArrayList<String> list1 = procedures.callP_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(), M_POAD_DOB,
						DUMMY_BEAN.getUI_M_PROD_AGE_CALC_FLAG());
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(M_POAD_REF_ID1);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(M_POAD_REF_ID2);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSR_CODE(M_POAD_ASSR_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_ASSURED_NAME(M_POAD_ASSURED_NAME);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_BIRTH_PLACE(M_POAD_BIRTH_PLACE);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(CommonUtils.nvl(
						M_POAD_AGE, 0));
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_NATIONALITY(M_POAD_NATIONALITY);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_MAR_STATUS(M_POAD_MAR_STATUS);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(M_POAD_OCC_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_NATURE_OF_WORK(M_POAD_NATURE_OF_WORK);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_HEALTH_CODE(M_POAD_HEALTH_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(M_POAD_REMARKS);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CR_DT((Date)commonUtils
						.getCurrentDate());
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CR_UID(CommonUtils
						.getGlobalVariable("GLOBAL USER_ID"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(M_POAD_CATG_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(M_POAD_HEIGHT);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(M_POAD_WEIGHT);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(M_POAD_DISC_AGE);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_ADDL_RISK_CODE(M_POAD_ADDL_RISK_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG("P");
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_AGE_PROOF_OTHERS(M_POAD_AGE_PROOF_OTHERS);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(M_POAD_REF_ID1);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(M_POAD_REF_ID2);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CLASS(M_POAD_OCC_CLASS);

				System.out.println("object ------------------>"+M_POAD_BMI);

				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND(M_POAD_BMI,2));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(M_POAD_RACE);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_RELIGION_CODE(M_POAD_RELIGION_CODE);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE("R");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT_UNIT("C");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT_UNIT("K");
				/*PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SALARY(M_POAD_FC_SALARY);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(M_POAD_LC_SALARY);*/
			}

			list = DBProcedures.P_VAL_SYSTEM("IL_TLMT_MTHD", "IL_TLMT_MTHD",
					M_CODE_DESC, "E", M_VALUE);
			M_CODE_DESC = list.get(0);
			M_VALUE = list.get(1);
			Double L_GET_THRESHOLD_LIMIT_VAL = null; 
			L_GET_THRESHOLD_LIMIT_VAL = L_GET_THRESHOLD_LIMIT(PT_IL_POL_ASSURED_DTLS_BEAN,
					PT_IL_POLICY_BEAN,
					DUMMY_BEAN);
			/*		if ("1".equals(M_VALUE)) {
				if ("P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {
				if(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED() != null){	
					PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
									L_GET_THRESHOLD_LIMIT_VAL, 0)
									+ PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
				}
				} else {
					PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
									L_GET_THRESHOLD_LIMIT_VAL, 0));
				}
			}*/
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(CommonUtils.nvl(
					M_POAD_SMOKE_YN, "N"));
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(M_POAD_NO_OF_CIGAR);
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SUM_ASSURED(PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED());
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SUM_ASSURED(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void preInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POLICY pt_il_policy,DUMMY dummyBean, 
			PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Object[] value = null;
		ResultSet resultSet = null;
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet1 = null;

		Date POL_START_DATE = pt_il_policy.getPOL_START_DT();

		Long PIL_POAD_SYS_ID;
		int POAD_SERIAL_NO;

		String SYS_ID_GENERATE_QUERY = " SELECT PIL_POAD_SYS_ID.NEXTVAL FROM DUAL";
		String SELECT_QUERY = " SELECT NVL(MAX(POAD_SERIAL_NO),0) + 1 FROM PT_IL_POL_ASSURED_DTLS WHERE "
				+ "POAD_POL_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SYS_ID_GENERATE_QUERY,
					connection);
			if (resultSet.next()) {
				pt_il_pol_assured_dtls.setPOAD_SYS_ID(resultSet.getLong(1));
			}
			if (pt_il_policy.getPOL_SYS_ID() != null) {
				pt_il_pol_assured_dtls.setPOAD_POL_SYS_ID(pt_il_policy
						.getPOL_SYS_ID());
				value = new Object[] { pt_il_policy.getPOL_SYS_ID() };
				resultSet1 = handler.executeSelectStatement(SELECT_QUERY,
						connection, value);
				if (resultSet1.next()) {
					pt_il_pol_assured_dtls.setPOAD_SERIAL_NO(resultSet1
							.getDouble(1));
				}
			}
			if ((pt_il_pol_assured_dtls.getPOAD_CATG_CODE() != null)  
					&& (pt_il_pol_assured_dtls.getPOAD_ADDL_RISK_CODE() != null)
					&& (!(pt_il_pol_assured_dtls.getPOAD_ADDL_RISK_CODE().isEmpty()))) {
				list= IL_DISC_AGE(compositeAction,
						pt_il_pol_assured_dtls.getPOAD_AGE(),
						pt_il_pol_assured_dtls.getPOAD_CATG_CODE(),
						pt_il_pol_assured_dtls.getPOAD_ADDL_RISK_CODE(),
						POL_START_DATE, 
						pt_il_pol_assured_dtls.getPOAD_DISC_AGE());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						pt_il_pol_assured_dtls.setPOAD_DISC_AGE(Integer.parseInt(list.get(0)));
					}
				}

			} else {
				pt_il_pol_assured_dtls.setPOAD_DISC_AGE(pt_il_pol_assured_dtls.getPOAD_AGE());
			}

			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			//dummyBean.getUI_M_CALC_METHOD().equals(2)

			if (dummyBean.getUI_M_CALC_METHOD().equals(1) || dummyBean.getUI_M_CALC_METHOD().equals(2)) {
				if (pt_il_pol_assured_dtls.getPOAD_REF_ID1() == null && pt_il_pol_assured_dtls.getPOAD_REF_ID2() == null) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91152"));
				}
			}

			pt_il_pol_assured_dtls.setPOAD_CR_DT((Date) new CommonUtils()
			.getCurrentDate());
			pt_il_pol_assured_dtls.setPOAD_CR_UID("GLOBAL.M_LANG_CODE");
			pt_il_pol_assured_dtls.setPOAD_HIV_TEST_YN("N");
		} catch (Exception e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void preUpdate(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS assuredDetail )
			throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;

		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list = new ArrayList<String>();
		String CURSOR_C1 = "SELECT NVL(DS_AGE_RECALC_YN,'N') FROM  PM_IL_DOC_SETUP WHERE  DS_CODE = ? ";
		String M_DS_AGE_RECALC_YN = null;
		Date POL_START_DATE = (Date) compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_START_DT();
		PT_IL_POLICY PT_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		Object[] values = new Object[] { compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_END_CODE() };

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					values);
			if (resultSet.next()) {
				M_DS_AGE_RECALC_YN = resultSet.getString(1);
			}


			if ((assuredDetail.getPOAD_CATG_CODE() != null)
					&& (assuredDetail.getPOAD_ADDL_RISK_CODE() != null)) {
				list = IL_DISC_AGE(compositeAction,
						assuredDetail.getPOAD_AGE(), 
						assuredDetail.getPOAD_CATG_CODE(), 
						assuredDetail.getPOAD_ADDL_RISK_CODE(),
						POL_START_DATE,
						assuredDetail.getPOAD_DISC_AGE());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						assuredDetail.setPOAD_DISC_AGE(Integer.parseInt(list.get(0)));
					}
				}

			} else {
				if (!("002".equals(PT_POLICY_BEAN.getPOL_END_TYPE()) && !("N".equals(M_DS_AGE_RECALC_YN)))) {
					assuredDetail.setPOAD_DISC_AGE(assuredDetail.getPOAD_AGE());
				}
			}


			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.

			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD().equals(1)||
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CALC_METHOD().equals(2)) {
				if (assuredDetail.getPOAD_REF_ID1() == null && assuredDetail.getPOAD_REF_ID2() == null) {
					throw new Exception((Messages.getString( PELConstants.pelErrorMessagePath, "91152")));
				}
			}

			assuredDetail.setPOAD_UPD_DT((Date) new CommonUtils().getCurrentDate());
			assuredDetail.setPOAD_UPD_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw  new Exception(e.getMessage());
				// TODO: handle exception
			}
		}

	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_TEMP = null;
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_EXISTS = "";
		String M_DRP_CUST_REF_ID1 = null;
		String M_DRP_CUST_REF_ID2 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PT_IL_POLICY  PT_IL_POLICY_BEAN = null;

		CRUDHandler handler = new CRUDHandler();

		PT_IL_POL_ASSURED_DTLS_DELEGATE delegate = new PT_IL_POL_ASSURED_DTLS_DELEGATE();

		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY_BEAN = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();

		PT_IL_POL_ASSURED_DTLS  PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION  medicalHistryAction = compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST medicalHistry= medicalHistryAction.getPT_IL_POL_ASSR_MED_HIST_BEAN();
		BP bpBean = compositeAction.getBP_ACTION_BEAN().getBP_BEAN();
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND POAD_TYPE = 'R'";
		String CURSOR_C2 = "SELECT 'X' FROM PM_IL_DOC_MED_HIST WHERE DMH_DS_TYPE = ? AND DMH_DS_CODE = ? "
				+ "AND DMH_APPL_ON IN ('R','B')";
		String CURSOR_C3 = "SELECT DRP_CONT_REF_ID1,DRP_CONT_REF_ID2 ,DRP_CUST_REF_ID1,"
				+ "DRP_CUST_REF_ID2,DRP_CONT_YN FROM PT_IL_DMSRCPT WHERE DRP_PROP_NO = ? ";
		String CURSUR_C3_A = " SELECT 'X' FROM PT_IL_DMSRCPT WHERE DRP_PROP_NO = ? ";
		String CURSER_C3_B = "SELECT 'X' FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";

		try {
			connection = CommonUtils.getConnection();
			CommonUtils.setGlobalObject("GLOBAL.M_BLOCK", "1");
			if (DUMMY_BEAN.getUI_M_CHANGE_SA_YN() == null) {
				DUMMY_BEAN.setUI_M_CHANGE_SA_YN("N");
			}
			resultSet = handler.executeSelectStatement(CURSER_C3_B, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_TEMP2 = resultSet.getString(1);
			}
			System.out.println("M_TEMP2              "+M_TEMP2);
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
			if (resultSet.next()) {
				DUMMY_BEAN.setUI_M_CONT_REF_ID1(resultSet.getString(1));
				DUMMY_BEAN.setUI_M_CONT_REF_ID2(resultSet.getString(2));
				DUMMY_BEAN.setUI_M_CUST_REF_ID1(resultSet.getString(3));
				DUMMY_BEAN.setUI_M_CUST_REF_ID2(resultSet.getString(4));
				DUMMY_BEAN.setUI_M_DRP_CONT_YN(resultSet.getString(5));
				/*if ((DUMMY_BEAN.getUI_M_CALC_METHOD().equals(1))) {
					if ("Y".equals(DUMMY_BEAN.getUI_M_DRP_CONT_YN())) {
						L_INSERT_PT_IL_POL_ASSUR_DTLS(
								DUMMY_BEAN.getUI_M_CONT_REF_ID1(), 
								DUMMY_BEAN,
								DUMMY_BEAN.getUI_M_CONT_REF_ID2(),
								PT_IL_POLICY_BEAN, PT_IL_POL_ASSURED_DTLS_BEAN);
					} else if ("N".equals(DUMMY_BEAN.getUI_M_DRP_CONT_YN())) {
						L_INSERT_PT_IL_POL_ASSUR_DTLS(
								DUMMY_BEAN.getUI_M_CUST_REF_ID1(),
								DUMMY_BEAN,
								DUMMY_BEAN.getUI_M_CUST_REF_ID2(),
								PT_IL_POLICY_BEAN, PT_IL_POL_ASSURED_DTLS_BEAN);
					}
				}*/
				CommonUtils.closeCursor(resultSet);
			}

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
				executeQuery(compositeAction);
			}
			/*if (DUMMY_BEAN.getUI_M_AGE() == 0) {
				//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(DUMMY_BEAN
					//	.getUI_M_AGE().doubleValue());
				DUMMY_BEAN.setUI_M_AGE(0.00);
			}*/
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
					PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
			if (resultSet.next()) {
				M_EXISTS = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (M_EXISTS == null) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getCOMP_UI_M_BUT_FLEX_FIELDS().setDisabled(false);
			} else {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_FLEX_FIELDS().setDisabled(true);
				L_LOAD_MEDICAL_HISTORY(PT_IL_POLICY_BEAN,medicalHistryAction,bpBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}

	}

	public void L_LOAD_MEDICAL_HISTORY(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSR_MED_HIST_ACTION medicalHistryAction,BP BP_BEAN) throws Exception {
		int M_COUNT;
		String M_DMH_CAPTION = null;
		String M_DMH_BL_CAPTION = null;
		String M_DMH_DATA_TYPE = null;
		String M_DMH_MANDATORY_YN = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String langcode = CommonUtils
				.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
		PT_IL_POL_ASSR_MED_HIST medHistBean= medicalHistryAction.getPT_IL_POL_ASSR_MED_HIST_BEAN();
		String paddedString = null;
		String fieldName = null;
		Method method = null;
		UIInput uiInput = null;
		M_COUNT = 1;
		CRUDHandler handler = new CRUDHandler();

		String CURSOR_C1 = "SELECT  DMH_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N')"
				+ "FROM  PM_IL_DOC_MED_HIST  WHERE  DMH_DS_TYPE = ?  AND DMH_DS_CODE = ? "
				+ "AND  DMH_APPL_ON IN ('R', 'B') AND     ROWNUM  <= 20 ";

		String CURSOR_C2 = "SELECT  DMH_BL_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N') "
				+ "FROM  PM_IL_DOC_MED_HIST  WHERE DMH_DS_TYPE = ?  AND DMH_DS_CODE =  ?  "
				+ "AND DMH_APPL_ON IN ('R','B') AND     ROWNUM  <=20";

		try {
			connection = CommonUtils.getConnection();
			if ("1".equals(CommonUtils.SUBSTR(langcode, 5, 1)) || "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);

					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
							.getMethod("set" + fieldName,String.class);
					method.invoke(BP_BEAN,M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medicalHistryAction);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_BL_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
							.getMethod("set" + fieldName, String.class);
					method.invoke(BP_BEAN, M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistBean);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}

				CommonUtils.closeCursor(resultSet);

				for (int i = (int) M_COUNT; i <= 20; i++) {
					paddedString = i < 10 ? "0" + i : String.valueOf(i);
					M_DMH_BL_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
							.getMethod("set" + fieldName, String.class);
					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistBean);
					uiInput.setRendered(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = PT_IL_POL_ASSURED_DTLS_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		// for Update the record(in FMB POST method)
		try {
			/*	handler.executeUpdate(PT_IL_POL_ASSURED_DTLS_BEAN, CommonUtils
					.getConnection());*/

			if(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null){
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(getRefId(PT_IL_POLICY_BEAN.getPOL_CONT_CODE()));
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(getRefId2(PT_IL_POLICY_BEAN.getPOL_CONT_CODE()));
			}
			if ("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
					"N"))) {
				// set the property of component for insert allowed and update
				// allowed false
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_REF_ID1().setDisabled(true);
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_REF_ID2().setDisabled(true);
			}
			if ("Y".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SMOKE_YN())) {
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setRendered(true);
				String PrevCode = CommonUtils
						.getGlobalVariable("GLOBAL.M_PRIVILEGE");
				/*if ("Y".equals(PrevCode.substring(2, 3))) {
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);
			}
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);*/
			} else {
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
			}

			if (!(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_STATUS(), "N").equalsIgnoreCase("A"))) {
				String endType = CommonUtils.nvl(PT_IL_POLICY_BEAN
						.getPOL_END_TYPE(), "000");
				if (("013".equals(endType))// || "001".equals(endType))
						//|| "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()
						) {
					PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_REF_ID1()
					.setDisabled(false);
				} else {
					/*PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_REF_ID1()
						.setDisabled(true);*/
				}
			}

			//addded by akash to solve the problem for threshold limit on update but every 
			//time is double the record.    

			/*	ArrayList<String> list = null;
		String M_VALUE = null;
		String M_CODE_DESC = null;
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		list = DBProcedures.P_VAL_SYSTEM("IL_TLMT_MTHD", "IL_TLMT_MTHD",
				M_CODE_DESC, "E", M_VALUE);
		M_CODE_DESC = list.get(0);
		M_VALUE = list.get(1);
		Double L_GET_THRESHOLD_LIMIT_VAL = null; 
		L_GET_THRESHOLD_LIMIT_VAL = L_GET_THRESHOLD_LIMIT(PT_IL_POL_ASSURED_DTLS_BEAN,
								PT_IL_POLICY_BEAN,
								DUMMY_BEAN);
		if ("1".equals(M_VALUE)) {
			if ("P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {
				PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
								L_GET_THRESHOLD_LIMIT_VAL, 0)
								+ PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
			} else {
				PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
								L_GET_THRESHOLD_LIMIT_VAL, 0));
			}
		}*/

			if("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ALCHOHALIC_YN(),"N"))){
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_ALCOHOL_QUAN().setDisabled(false);
			}
			else{
				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_ALCOHOL_QUAN().setDisabled(true);
			}

			
			/*added by raja on 13-04-2017 for nationality default*/
			if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY()==null)
			{
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
				System.out.println("Nationality in assured dtls screen  ==> "+CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
				PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(PremiaLib.nationalityDisc(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY().toString()));
				System.out.println("Nationality desc in assured dtls screen  ==> "+PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_NATLITY_DESC());
				
				
			}			
			
			/*end*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	private String getRefId(String assCode){
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String refId = null;
		String C1 = " SELECT CONT_REF_ID1 FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{assCode});
			if(resultSet.next()){
				refId = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return refId;
	}

	private String getRefId2(String assCode){
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String refId = null;
		String C1 = " SELECT CONT_PASS_NO FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{assCode});
			if(resultSet.next()){
				refId = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return refId;
	}

	public void WHEN_CREATE_RECORD(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String M_TYPE = null;// two value define for M_TYPE
		String M_DESC = null;
		String M_DESC_BL = null;
		String M_REL_DESC = null;
		String M_REL_DESC_BL = null;
		String M_PC_CODE = null;
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet resultSet = null,rs2=null;

		CRUDHandler handler = new CRUDHandler();

		PT_IL_POL_ASSURED_DTLS_ACTION assuredAction = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = null; 

		/*String CURSOR_C1 = "SELECT PC_CODE,PC_DESC , PC_BL_DESC FROM   PM_CODES"
		+ " WHERE  PC_TYPE = ?  AND PC_VALUE = 1 AND NVL(PC_FRZ_FLAG,'N') != 'Y'";*/

		/*Modifed by Ram on 20/01/2017 for defaulting Oman as Nationality*/
		String CURSOR_C1 = "SELECT PC_CODE,PC_DESC , PC_BL_DESC FROM   PM_CODES"
		+ " WHERE  PC_TYPE = ?  AND PC_VALUE = 3 AND NVL(PC_FRZ_FLAG,'N') != 'Y'";
		/*End*/
		String CURSOR_C2 = " SELECT CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_CODE =? ";
		String CURSOR_C3 = "SELECT CONT_REF_ID1, CONT_REF_ID2 FROM PM_IL_CONTRACTOR "
				+ "WHERE NVL(CONT_CODE,'X') = NVL( ? ,'X')";
		try {
			if (CommonUtils.getGlobalVariable("GLOBAL.M_SITE") != "KIC") {
				/*if (assuredAction.getList().size() > 0) {
					if ((assuredAction.getList().get(0))
							.equals(PT_IL_POL_ASSURED_DTLS_BEAN)) {*/

				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_ASSR_CODE(PT_IL_POLICY_BEAN
						.getPOL_CONT_CODE());
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_ASSURED_NAME(PT_IL_POLICY_BEAN
						.getPOL_ASSURED_NAME());


				/*	}
				}*/
			}
			
			/*added by raja on 13-04-2017 for nationality default*/
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
			
			System.out.println("Nationality in assured dtls screen  ==> "+CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
			
			PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(PremiaLib.nationalityDisc(
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY().toString()));
			
			
			System.out.println("Nationality desc in assured dtls screen  ==> "+PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_NATLITY_DESC());
			
			/*end*/
			//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG("2");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE("R");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_ADMITTED("Y");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT_UNIT("C");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT_UNIT("K");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN("N");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_POL_OWNER_YN("Y");
			//assuredAction.getCOMP_POAD_AGE_PROOF_OTHERS().setRequired(true);
			if ("N".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SMOKE_YN())) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(0);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
			} else if ("Y".equals(PT_IL_POL_ASSURED_DTLS_BEAN
					.getPOAD_SMOKE_YN())) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(1);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);

			}
			String jointpol = CommonUtils.nvl(PT_IL_POLICY_BEAN
					.getPOL_JOINT_LIFE_YN(), "N");
			if ("Y".equals(jointpol)) {

				assuredAction.getCOMP_POAD_TYPE().setDisabled(false);
				/*
				 * String PrvlVar =
				 * CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEG");
				 * if("Y".equals(PrvlVar.substring(2, 3))){
				 * assuredAction.getCOMP_POAD_TYPE().setDisabled(false); }
				 */
			} else {
				assuredAction.getCOMP_POAD_TYPE().setDisabled(true);
			}

			assuredAction.getCOMP_POAD_DISC_AGE().setDisabled(true);
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { "NATLITY" });
			if (resultSet.next()) {
				if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY() == null){
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(resultSet
							.getString(1));
					M_DESC = resultSet.getString(2);
					M_DESC_BL = resultSet.getString(3);
				}
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { "RELIGION" });
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RELIGION_CODE(resultSet
						.getString(1));
				M_REL_DESC = resultSet.getString(2);
				M_REL_DESC_BL = resultSet.getString(3);
			}
			CommonUtils.closeCursor(resultSet);

			String langcode = CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
			if (("1".equals(CommonUtils.SUBSTR(langcode,5,1)))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(M_DESC);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setUI_M_POAD_REL_CODE_DESC(M_REL_DESC);
			} else {
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setUI_M_POAD_NATLITY_DESC(M_DESC_BL);
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setUI_M_POAD_REL_CODE_DESC(M_REL_DESC_BL);
			}

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { "RACE" });
			M_DESC = "";
			M_DESC_BL = "";
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setPOAD_RACE(resultSet.getString(1));
				M_DESC = resultSet.getString(2);
				M_DESC_BL = resultSet.getString(3);
			}
			CommonUtils.closeCursor(resultSet);
			if (("1".equals(CommonUtils.SUBSTR(langcode,5,1)))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_RACE_CODE_DESC(M_DESC);
			} else {
				PT_IL_POL_ASSURED_DTLS_BEAN
				.setUI_M_POAD_RACE_CODE_DESC(M_DESC_BL);
			}
			rs2 = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE()});
			if (rs2.next()) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(rs2
						.getString(1));
			}
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE() == null) {
				list = localProcedure.P_DISP_OCCU_CODE_AND_CLASS(CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_TYPE(),"X"),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE(),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), compositeAction);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_DESC(list.get(0));
					}
				}
			}
					
			
			
			/*added by raja on 22-05-2017*/
			
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
			PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(PremiaLib.nationalityDisc(
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY().toString()));
			/*end*/
			ResultSet resultSet2 = null;
			String CUST_AGE_ADMITTED=null;
			String CUST_AGE_PROOF_FLAG=null;
			String CUST_AGE_PROOF_OTHERS=null;
			/*Modified by Sivarajan on 10/03/2019 for sarwa IL*/
			String query="select CUST_AGE_ADMITTED,CUST_IC_TYPE,CUST_AGE_PROOF_OTHERS FROM PM_CUSTOMER where CUST_CODE=?";
			/*End*/
			resultSet2 = handler.executeSelectStatement(query, connection,
					new Object[] {PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE()});
			
			while(resultSet2.next()){

				CUST_AGE_ADMITTED=resultSet2.getString("CUST_AGE_ADMITTED");
				/*Modified by Sivarajan on 10/03/2019 for sarwa IL*/
				CUST_AGE_PROOF_FLAG=resultSet2.getString("CUST_IC_TYPE");
				/*End*/
				CUST_AGE_PROOF_OTHERS=resultSet2.getString("CUST_AGE_PROOF_OTHERS");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_ADMITTED(CUST_AGE_ADMITTED);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG(CUST_AGE_PROOF_FLAG);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_OTHERS(CUST_AGE_PROOF_OTHERS);

			}
			
			
			/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FAMILY_YN("N");
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_YN("N");
			
			/*End of FSD_FLA_IL_008*/
			
			
				
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{CommonUtils.closeCursor(rs2);
		CommonUtils.closeCursor(resultSet);
		}
	}

	/*public void P_DISP_OCCU_CODE_AND_CLASS(String POAD_TYPE,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_PC_CODE = null;
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedure = new DBProcedures();
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;

		String CURSOR_C1 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE='IL_OCCU' AND "
				+ "(SUBSTR(PC_REMARKS,INSTR(PC_REMARKS,? ),LENGTH(  ?)) = ?  OR  PC_REMARKS = '1')";
		String CURSOR_C2 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE='IL_OCCU' AND "
				+ "(SUBSTR(PC_BL_LONG_DESC,INSTR(PC_BL_LONG_DESC,? ),LENGTH( ? )) = ?  OR  PC_BL_LONG_DESC ='1')";
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			connection = CommonUtils.getConnection();
			if ("R".equals(CommonUtils.nvl(POAD_TYPE, "N"))) {
				values = new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE() };
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, values);
				if (resultSet.next()) {
					M_PC_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				ArrayList<String> list = null;
				list = procedure.PILT002_P_DISP_OCCU_CLASS("R", M_PC_CODE);
			} else if ("E".equals(CommonUtils.nvl(POAD_TYPE, "N"))) {
				values = new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE() };
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, values);
				if (resultSet.next()) {
					M_PC_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_OCC_CODE(
								M_PC_CODE);
				procedure.P_DISP_OCCU_CLASS("E", M_PC_CODE);
				// PROCEDURE_P_DISP_OCCU_CLASS("E",compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try{
			CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}*/

	//added by saranya on 13-03-16 for BMI
	public void POAD_BMI_VALIDATE_ITEM(Double BMI) throws Exception{
		System.out.println(" POAD_BMI_VALIDATE_ITEM   "+BMI);
		String SysBmi_value =actionBean.getsysparameter();
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
	//end




	public void postQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String M_VALUE = null;
		ArrayList<String> returnList = new  ArrayList<String>();
		ArrayList<String> list = new  ArrayList<String>();
		ArrayList<String> list1 = new  ArrayList<String>();
		ArrayList<String> list2 = new  ArrayList<String>();
		ArrayList<String> list3 = new  ArrayList<String>();
		ArrayList<String> list4 = new  ArrayList<String>();
		ArrayList<String> list5 = new  ArrayList<String>();
		ArrayList<String> list6 = new  ArrayList<String>();
		ArrayList<String> list7 = new  ArrayList<String>();
		ArrayList<String> list8 = new  ArrayList<String>();
		double MS_POAD_LC_THRESHOLD_LIMIT=0.0d;
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DBProcedures proce = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		try {
			
			
			System.out.println("enters into postQuery in assured dtls screen");
			
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_RACE() != null) {

				list = proce.P_VAL_CODES("RACE",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_RACE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_RACE_CODE_DESC(),
						"N", "N", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_RACE_CODE_DESC(list.get(0));
					}
				}


			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CLASS() != null){
				list1 = proce.P_VAL_CODES("IL_OCC_CLASS",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CLASS(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_OCC_CLASS_DESC(),
						"N", "N", null);
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list1.get(0));
					}
				}

			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_MAR_STATUS() != null) {
				returnList = DBProcedures.P_VAL_SYSTEM("MARI_STAT",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_MAR_STATUS(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_MS_DESC(),
						"N",M_VALUE);

				if (returnList != null && !returnList.isEmpty()) {
					if (returnList.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_MS_DESC(returnList.get(0));
					}
					if (returnList.get(1) != null) {
						M_VALUE = returnList.get(1);
					}
				}




			}
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ADDL_RISK_CODE() != null) {
				list2 = proce.P_VAL_CODES("IL_ADDL_RISK",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ADDL_RISK_CODE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_ADDL_RISK_DESC(), 
						"N","N", null);
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_ADDL_RISK_DESC(list2.get(0));
					}
				}


			}
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY() != null) {
				list3 = proce.P_VAL_CODES(
						"NATLITY", 
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_NATLITY_DESC(),
						"N", "N", null);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(list3.get(0));
					}
				}

			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE() != null) {
				list4 = proce.P_VAL_CODES("IL_OCCU", PT_IL_POL_ASSURED_DTLS_BEAN
						.getPOAD_OCC_CODE(), PT_IL_POL_ASSURED_DTLS_BEAN
						.getUI_M_POAD_OCC_DESC(), "N", "N", null);
				if (list4 != null && !list4.isEmpty()) {
					if (list4.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_DESC(list4.get(0));
					}
				}

			}
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEALTH_CODE() != null) {

				list5 = proce.P_VAL_CODES("IL_HLTH_ST", PT_IL_POL_ASSURED_DTLS_BEAN
						.getPOAD_HEALTH_CODE(), PT_IL_POL_ASSURED_DTLS_BEAN
						.getUI_M_POAD_HEALTH_DESC(), "N", "N", null);
				if (list5 != null && !list5.isEmpty()) {
					if (list5.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_HEALTH_DESC(list5.get(0));

					}
				}

			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE() != null) {
				list6 = DBProcedures.P_VAL_SYSTEM("CATG",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_CATG_DESC(), 
						"N",DUMMY_BEAN.getUI_M_PS_VALUE_DUMMY());
				if (list6 != null && !list6.isEmpty()) {
					if (list6.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_CATG_DESC(list6.get(0));
					}
					if (list6.get(0) != null) {
						DUMMY_BEAN.setUI_M_PS_VALUE_DUMMY(list6.get(1));
					} 
				}
			}




			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_RELIGION_CODE() != null) {
				list7 = proce.P_VAL_CODES("RELIGION", 
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_RELIGION_CODE(), 
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_REL_CODE_DESC(),
						"N", "N", null);
				if (list7 != null && !list7.isEmpty()) {
					if (list7.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_REL_CODE_DESC(list7.get(0));
					}
				}

			}
			/*if ("Y".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(),"X")))*/ {
				list = new ArrayList<String>();
				list = proce.callCALC_ASSRD_THRESHOLD_LIMIT(
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SYS_ID()));
				if (list !=  null && !list.isEmpty()) {
					if (list.get(0) != null) {
						MS_POAD_LC_THRESHOLD_LIMIT = Double.parseDouble(list.get(0));
					}

				}
				PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(CommonUtils.nvl(MS_POAD_LC_THRESHOLD_LIMIT, 0));
			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() != null) {
				PT_IL_POLICY_BEAN.setUI_M_MAT_AGE(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()
						+ PT_IL_POLICY_BEAN.getPOL_PERIOD()+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD(),0));
			}
			
			
			if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT() == null || PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT() == null)
			{
			
				System.out.println("getPOAD_HEIGHT_UNIT              "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT());
				System.out.println("getPOAD_WEIGHT_UNIT              "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT());
				
				
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT_UNIT("C");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT_UNIT("K");
				
				System.out.println("getPOAD_HEIGHT_UNIT              "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT());
				System.out.println("getPOAD_WEIGHT_UNIT              "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT());
				
				
				
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		Object[] values = {};
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		//ArrayList<OracleParameter> list1 = new ArrayList<OracleParameter>();
		//CommonUtils commonUtils = new CommonUtils();
		String Query1 = "SELECT  'X' FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ?" +
				" AND PAC_COVER_ASSR_TYPE IN ('R','B')";

		String query11 = "  SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE = ? ";
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN =compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
		try {
			connection = CommonUtils.getConnection();

			values = new Object[] { "IL_DEL_RIDER" };
			rs = handler.executeSelectStatement(query11, connection, values);
			if (rs.next()) {
				M_PS_CODE_1 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			values = new Object[] { "IL_ADD_RIDER" };
			rs = handler.executeSelectStatement(query11, connection, values);
			if (rs.next()) {
				M_PS_CODE_2 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);
			resultSet = handler.executeSelectStatement(Query1, connection,new Object[]{PT_IL_POLICY_BEAN.getPOL_PROD_CODE()});
			// 'NR' for normal policy and 'PG' for package policy using  menu parameter_18
			if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				if(resultSet.next()){
					new P9ILPK_POLICY_NR().P_INS_ADDL_COVER(
							PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
							PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
							DUMMY_BEAN.getUI_M_CHANGE_SA_YN());
				}
			} else if ("PG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				p9ilpk_policy.P_DFLT_APPL_PROD(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SYS_ID(),
						PT_IL_POLICY_BEAN.getPOL_PROD_GROUP_CODE());
			}
			if ((!("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N")))
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),0) == 0)
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q"))) {
				p9ilpk_policy.P_INS_DISC_LOAD(
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_START_DT()));
			}

			if(!"001".equalsIgnoreCase(CommonUtils.nvl(
					PT_IL_POLICY_BEAN.getPOL_END_CODE(), "000"))){
				if(!M_PS_CODE_1.equals(CommonUtils.nvl(
						PT_IL_POLICY_BEAN.getPOL_END_CODE(), "000"))
						&& !M_PS_CODE_2.equals(CommonUtils.nvl(
								PT_IL_POLICY_BEAN.getPOL_END_CODE(), "000"))) {
					new P9ILPK_POLICY().INS_MED_EXAM_DTL(CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED()),
							CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
							CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_PROD_CODE()), 
							CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CONT_CODE()));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void postUpadte(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ArrayList<OracleParameter> list = new  ArrayList<OracleParameter>();
		ArrayList<OracleParameter> list1 = new ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		P9ILPK_POLICY proc = new P9ILPK_POLICY();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();

		try {
			if ((CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) == 0)
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q")) {

				list = new P9ILPK_POLICY_NR().P_INS_ADDL_COVER(
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						DUMMY_BEAN.getUI_M_CHANGE_SA_YN());
			}
			if (("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),0) == 0) 
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q"))) {
				list1 = proc.P_INS_DISC_LOAD(
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_START_DT()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void on_Populate_Detail(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Long POAD_SYS_ID = null;
		Long POAD_POL_SYS_ID = null;

		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		POAD_SYS_ID = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SYS_ID();
		POAD_POL_SYS_ID = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_POL_SYS_ID();
		try {
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_ASSR_MED_HIST_DELEGATE delegate = new PT_IL_POL_ASSR_MED_HIST_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,compositeAction);
			}
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_MED_EXAM_DTL_DELEGATE delegate = new PT_IL_POL_MED_EXAM_DTL_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,compositeAction);
			}
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE delegate = new PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,
						compositeAction);
			}
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_APPL_PROD_DELEGATE delegate = new PT_IL_POL_APPL_PROD_DELEGATE();
				delegate.executeSelectStatement( compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preDelete(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Long POAD_SYS_ID = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID();
		Long POAD_POL_SYS_ID = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID();
		PT_IL_POL_ADDL_COVER_DELEGATE delegate4 = new PT_IL_POL_ADDL_COVER_DELEGATE();
		PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE delegate3 = new PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE();
		PT_IL_POL_MED_EXAM_DTL_DELEGATE delegate2 = new PT_IL_POL_MED_EXAM_DTL_DELEGATE();
		PT_IL_POL_ASSR_MED_HIST_DELEGATE delegate1 = new PT_IL_POL_ASSR_MED_HIST_DELEGATE();
		try {
			delegate1.deleteRecord(POAD_SYS_ID, POAD_POL_SYS_ID);
			delegate2.deleteRecord(POAD_SYS_ID, POAD_POL_SYS_ID);
			delegate3.deleteRecord(POAD_SYS_ID, POAD_POL_SYS_ID);
			delegate4.deleteRecord(POAD_SYS_ID, POAD_POL_SYS_ID);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		Long POL_SYS_ID = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setDEFAULT_WHERE(
				"POAD_TYPE = 'R' AND POAD_POL_SYS_ID  = " + POL_SYS_ID
				+ "");
	}

	public void POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN  ) throws Exception {

		Integer M_DUMMY = 0;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_EXIST1 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = compositeAction
				.getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();

		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		String CURSOR_C1 = "SELECT  COUNT(*) FROM  PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? ";
		String CURSOR_C3 = "SELECT PS_CODE FROM   PP_SYSTEM  WHERE  PS_TYPE = 'IL_HIV_CODE'";
		String CURSOR_C4 = "SELECT 'X' FROM  PT_IL_POL_ASSURED_DTLS,PT_IL_POL_STATUS WHERE  POAD_POL_SYS_ID = ? "
				+ "AND POAD_ASSR_CODE  =  ?  AND PS_STATUS = 'C' AND  PS_REASON_CODE  = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			if (resultSet.next()) {
				M_PS_CODE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			value = new Object[] { PT_IL_POL_STATUS_BEAN.getPS_POL_SYS_ID(),
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE(), M_PS_CODE };
			resultSet = handler.executeSelectStatement(CURSOR_C4, connection,value);
			if (resultSet.next()) {
				M_DUMMY1 = resultSet.getString(1);
			}
			if ("X".equals(M_DUMMY1)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"91111",new Object[] { M_PS_CODE }));
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}

			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71211"));
				}
			} else {
				if (M_DUMMY > 1) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71212"));
				}
			}

			if (PT_IL_POLICY_BEAN.getPOL_CONT_CODE() != null) {
				IL_UNIQUE_POL_ASSR_CODE(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE());
			}

			//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			/*if (DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)) {
				ArrayList<String> list3 = IL_POAD_GET_ASSR_DTLS(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE(), 
						"N",null, null,
						DUMMY_BEAN.getUI_M_DUMMY(), "R",
						compositeAction);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						M_EXIST1 = list3.get(0);
					}
				}

			}*/

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	
	public void POAD_REF_ID1_WHEN_VALIDATE_ITEM(String POAD_REF_ID1,
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS assuredBean) throws Exception {

System.out.println("enters into POAD_REF_ID1_WHEN_VALIDATE_ITEM");
		
		/*Added by Sankar on 13.8.2016 for IC no validation*/
		/*String CURSOR_C6= "SELECT CUST_CATG_CODE,CUST_DOB FROM PM_CUSTOMER WHERE CUST_CODE= ? ";*/
		
		/*Newly Added By Dhinesh on 12-04-2018*/
		String CURSOR_C6= "SELECT CUST_CATG_CODE,CUST_DOB FROM PM_CUSTOMER WHERE CUST_CODE = ? union select cont_catg_code CUST_CATG_CODE ,cont_Dob CUST_DOB from pm_il_contractor where cont_code = ? ";
		/* End*/

		ResultSet resultSet2=  null;

		/*end*/

		Integer M_DUMMY = null;
		Integer M_LENGTH_1 = null;
		Integer M_GENDER = null;
		/*Integer M_REF_ID_1_LENGTH = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
				.getMaxlength();*/
		Integer M_NEW_IC_NO_LENGTH = POAD_REF_ID1.length();
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;
		String M_DATE_CHAR = null;
		String M_VALUE = null;
		String M_EXIST = null;
		String M_CONT_REF_ID1 = null;
		Date M_TEMP_DATE = null;
		String M_CUST_VALID = null;
		String M_CODE_DESC = null;
		String M_CUST_REF_ID1 = null;
		String M_POAD_REF_ID1 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1=  null;
		Object[] value = null;
		ArrayList<String> list = null;
		ArrayList<String> list1 =  null;
		ArrayList<String> list3 =  null;

		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();


		String CURSOR_C1 = "SELECT  COUNT(*) FROM    PT_IL_POL_ASSURED_DTLS WHERE   POAD_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR( ? ,1,6) FROM DUAL";
		String CURSOR_C3 = "SELECT POAD_REF_ID1 FROM PT_IL_POL_ASSURED_DTLS  WHERE POAD_POL_SYS_ID = ?  ";
		String CURSOR_C4 = "SELECT 'X' IL_CONTRACTOR WHERE CONT_CODE = ? AND "
				+ "((CONT_REF_ID1 = ?) OR (CONT_REF_ID2  = ? ) OR (CONT_PASS_NO  = ?0))";
		String CURSOR_C5 = "SELECT CONT_REF_ID1 FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE =  ? ";
		
		/*Added by Janani on 22.01.2018 as per Sivaram's sugges.*/
		String CURSOR_C7 ="SELECT POAD_DOB FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID=?";
		Date poad_dob = null; 
		
		/*ENd*/
		
		try {
			connection = CommonUtils.getConnection();
			/*Commented by Sivarajan on 19-03-2019 For KIC Ajoy Sugg.*/
			/*if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,connection,new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_POAD_REF_ID1 = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if (M_POAD_REF_ID1 != null) {
					if (!(M_POAD_REF_ID1.substring(7)).equals((POAD_REF_ID1.substring(7)))){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91916"));
					}
				}
			}	*/

			list = DBProcedures.P_VAL_SYSTEM(
					"LEN_REF_ID", 
					"REF_ID_1",
					M_CODE_DESC,
					"N",
					CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) !=  null) {
					M_CODE_DESC = list.get(0);
				}
			}
			
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
			
			System.out.println("M_PS_VALUE                 :"+M_PS_VALUE);
			
			
if ("1".equals(M_PS_VALUE)) {
				
				System.out.println("ENTERS INTO M_PS_VALUE = 1 ");
				
				M_REF_ID_1_LENGTH = compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(null,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}
			else
			{
				
				System.out.println("ENTERS INTO M_PS_VALUE != 1 ");
								
				M_REF_ID_1_LENGTH = compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}

			
			
			
			System.out.println("M_NEW_IC_NO_LENGTH in assured                 :"+M_NEW_IC_NO_LENGTH);
			System.out.println("M_REF_ID_1_LENGTH in assured                 :"+M_REF_ID_1_LENGTH);
			
			//System.out.println("KLKL  "+CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH));
			
			
			
			System.out.println("POAD_REF_ID1.length() in assured                 :"+POAD_REF_ID1.length());
			System.out.println("M_LENGTH_1 in assured                 :"+M_LENGTH_1);
			
			if (POAD_REF_ID1.length() != M_LENGTH_1) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91915",new Object[] {M_LENGTH_1 }));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C5, connection,new Object[] { PT_IL_POLICY_BEAN.getPOL_CONT_CODE() });
			if (resultSet.next()) {
				M_CONT_REF_ID1 = resultSet.getString(1);
			}
			if ("M".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POL_PLAN_TYPE(),"X"))) {
				if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null) {

					String assruedref=CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1(), "X").replaceAll("\\s","") ;
					String payorRef1=CommonUtils.nvl(POAD_REF_ID1, "X").replaceAll("\\s","") ;

					if (!assruedref.equalsIgnoreCase(payorRef1)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91918"));
					}
				}
			}

			if ("M".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POL_PLAN_TYPE(),"X"))) {

				String M_CONT_REF_ID11=CommonUtils.nvl(M_CONT_REF_ID1, "X").replaceAll("\\s","") ;
				String POAD_REF_ID11=CommonUtils.nvl(POAD_REF_ID1, "X").replaceAll("\\s","") ;



				if (!M_CONT_REF_ID11.equalsIgnoreCase(POAD_REF_ID11)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91919"));
				}
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1,connection,new Object[] {PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}
			if (("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN()))
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
							|| "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71211"));
				}

			} else {
				if (("N".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN()))
						&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) 
								|| "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
								&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
					if (M_DUMMY > 1) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71212"));
					}
				}
			}
			//ADDED BY AKASH TO MAKE NORMAL FLOW 
			//DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)
			if ((DUMMY_BEAN.getUI_M_CALC_METHOD().equals(1) || DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2))
					&& POAD_REF_ID1 != null
					&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
				M_EXIST = "N";
				if(!(assuredBean.getPOAD_REF_ID1().equalsIgnoreCase(POAD_REF_ID1))){
					IL_POAD_GET_ASSR_DTLS(
							assuredBean.getPOAD_ASSR_CODE(), "N",
							POAD_REF_ID1,
							assuredBean.getPOAD_REF_ID2(),
							M_EXIST, "R", compositeAction);
					assuredBean.setPOAD_TYPE("R");
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1().setRequired(false);
				}
			}

			/*list1 = DBProcedures.P_VAL_SYSTEM(
					"CUSTREFFMT",
					"CUSTREFFMT",
					M_CODE_DESC, "N", 
					M_PS_VALUE);*/
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(1) != null) {
					M_PS_VALUE = list1.get(1);
				}
			}
			M_CUST_REF_ID1 = POAD_REF_ID1;
			CommonUtils.closeCursor(resultSet);
			
			System.out.println("M_PS_VALUE              :"+M_PS_VALUE);
			
			if ("1".equals(M_PS_VALUE)) {
				
				System.out.println("ENTERS IN TO ic NO VALIDATION");
				
				
				if (  (  CommonUtils.nvl(M_EXIST, "N") != "Y"
						&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
						|| ( "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
								/*&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0*/))  ||
								("001".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"000"))) ){


					resultSet = handler.executeSelectStatement(CURSOR_C2,connection, new Object[] { M_CUST_REF_ID1 });
					if (resultSet.next()) {
						M_DATE_CHAR = resultSet.getString(1);
						String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
						resultSet1 = handler.executeSelectStatement(query, connection,new Object[]{M_DATE_CHAR});
						if (resultSet1.next()) {
							M_DATE_CHAR = resultSet1.getString(1);
						}
						CommonUtils.closeCursor(resultSet1);
						M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
						if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils.getYearFromDate(commonUtils.getCurrentDate())) {
							//String temp1 = CommonUtils.dateToStringFormatter();
							M_TEMP_DATE = CommonUtils.stringToPelUtilDate(CommonUtils.dateToPELStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200)));
							assuredBean.setPOAD_DOB(M_TEMP_DATE);

						} else {
							assuredBean.setPOAD_DOB(M_TEMP_DATE);
						}
					} else {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
					}
				}

				
			/*commented by sankar for ic no validation on 13.8.2016
			 * 
			 * 
			 * 
			 * 
			 * }
			*/
			
			
				CommonUtils.closeCursor(resultSet);
				M_GENDER = Integer.parseInt((POAD_REF_ID1.substring(POAD_REF_ID1.length() -1)));
				if (M_GENDER % 2 == 0) {
					assuredBean.setPOAD_CATG_CODE("2");
				} else {
					assuredBean.setPOAD_CATG_CODE("1");
				}


			/*Added by sankar for ic no validation on 13.8.2016*/
			
			}
			
			
			else{
				
				
				System.out.println("ENTERS INTO NO IC NO VALIDATION           "+assuredBean.getPOAD_ASSR_CODE());
				
				
				/*Added by Janani on 22.01.2018 as per Sivaram's sugges.*/
				
				if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE()))
				{
					assuredBean.setPOAD_DOB(assuredBean.getPOAD_DOB());
				}else
				{
				
				/*End*/
				
				resultSet2 = handler.executeSelectStatement(CURSOR_C6,connection,new Object[] { assuredBean.getPOAD_ASSR_CODE(),assuredBean.getPOAD_ASSR_CODE() });
				if (resultSet2.next()) {
					assuredBean.setPOAD_CATG_CODE(resultSet2.getString("CUST_CATG_CODE"));
					assuredBean.setPOAD_DOB(resultSet2.getDate("CUST_DOB"));
				}
				
				}
			}
			/*END*/


			if (assuredBean.getPOAD_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM(
						"CATG",
						assuredBean.getPOAD_CATG_CODE(),
						assuredBean.getUI_M_POAD_CATG_DESC(),
						"E",M_VALUE);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						assuredBean.setUI_M_POAD_CATG_DESC(list3.get(0));
					}if (list3.get(1) != null) {
						M_VALUE = list3.get(1);
					}
				}
			}
			P_CAL_PLAN_PERIOD(assuredBean.getPOAD_DOB(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

			
			/*Added by Janani on 22.01.2018 for ZB,as per Sivaram's sugges. */
			System.out.println("M_PS_VALUE                        "+M_PS_VALUE);
			if(M_PS_VALUE.equalsIgnoreCase("1"))
			{
			
			/*End */
			if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,connection,new Object[] { M_CUST_REF_ID1 });
				int M_TEMP_YEAR=0;
				if (resultSet.next()) {
					M_DATE_CHAR = resultSet.getString(1);

					String datequery=" SELECT  TO_DATE(?,'RRMMDD') FROM DUAL";
					resultSet1 = handler.executeSelectStatement(datequery, connection,new Object[]{M_DATE_CHAR});
					if (resultSet1.next()) {
						M_TEMP_DATE = resultSet1.getDate(1);
					}
					String yearquery=" SELECT TO_NUMBER(TO_CHAR(?,'RRRR')) FROM DUAL";
					resultSet1 = handler.executeSelectStatement(yearquery, connection,new Object[]{M_TEMP_DATE});
					if (resultSet1.next()) {
						M_TEMP_YEAR = resultSet1.getInt(1);
					}

					if ((M_TEMP_YEAR) > (CommonUtils.getYearFromDate(commonUtils.getCurrentDate()))) {
						String temp = CommonUtils.dateToStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200));
						M_TEMP_DATE = CommonUtils.newStringToDate(temp);
						assuredBean.setPOAD_DOB(M_TEMP_DATE);
					} else {
						assuredBean.setPOAD_DOB(M_TEMP_DATE);
					}
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
				}
			}
			
			/*Added by Janani on 22.01.2018 for ZB,as per Sivaram's sugges. */
			}
			else
			{
				System.out.println("No IC validation");
				
				resultSet = handler.executeSelectStatement(CURSOR_C7,connection,new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
				
				if (resultSet.next()) {
					poad_dob = resultSet.getDate(1);
					
				}
				
				assuredBean.setPOAD_DOB(assuredBean.getPOAD_DOB());
			}
			
			/*End */
			
			/*String query_c = "SELECT POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID=?";
			ResultSet rs3 = handler.executeSelectStatement(query_c, connection,
					new Object[] { compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_POL_SYS_ID() });
			if (rs3.next()) {
				int noOfCigar = rs3.getInt(1);
			}
			if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_NO_OF_CIGAR() != null) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getCOMP_POAD_NO_OF_CIGAR().resetValue();
			}*/
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
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
/*	public void POAD_REF_ID1_WHEN_VALIDATE_ITEM(String POAD_REF_ID1,
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS assuredBean) throws Exception {


System.out.println("enters into POAD_REF_ID1_WHEN_VALIDATE_ITEM");
		
		Added by Sankar on 13.8.2016 for IC no validation
		String CURSOR_C6= "SELECT CUST_CATG_CODE,CUST_DOB FROM PM_CUSTOMER WHERE CUST_CODE= ? ";
		ResultSet resultSet2=  null;

		end
		Integer M_DUMMY = null;
		Integer M_LENGTH_1 = null;
		Integer M_GENDER = null;
		Integer M_REF_ID_1_LENGTH = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
				.getMaxlength();
		Integer M_NEW_IC_NO_LENGTH = POAD_REF_ID1.length();
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;
		String M_DATE_CHAR = null;
		String M_VALUE = null;
		String M_EXIST = null;
		String M_CONT_REF_ID1 = null;
		Date M_TEMP_DATE = null;
		String M_CUST_VALID = null;
		String M_CODE_DESC = null;
		String M_CUST_REF_ID1 = null;
		String M_POAD_REF_ID1 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1=  null;
		Object[] value = null;
		ArrayList<String> list = null;
		ArrayList<String> list1 =  null;
		ArrayList<String> list3 =  null;

		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();


		String CURSOR_C1 = "SELECT  COUNT(*) FROM    PT_IL_POL_ASSURED_DTLS WHERE   POAD_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR( ? ,1,6) FROM DUAL";
		String CURSOR_C3 = "SELECT POAD_REF_ID1 FROM PT_IL_POL_ASSURED_DTLS  WHERE POAD_POL_SYS_ID = ?  ";
		String CURSOR_C4 = "SELECT 'X' IL_CONTRACTOR WHERE CONT_CODE = ? AND "
				+ "((CONT_REF_ID1 = ?) OR (CONT_REF_ID2  = ? ) OR (CONT_PASS_NO  = ?0))";
		String CURSOR_C5 = "SELECT CONT_REF_ID1 FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE =  ? ";
		try {
			connection = CommonUtils.getConnection();
			if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,connection,new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_POAD_REF_ID1 = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if (M_POAD_REF_ID1 != null) {
					if (!(M_POAD_REF_ID1.substring(7)).equals((POAD_REF_ID1.substring(7)))){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91916"));
					}
				}
			}	

			list = DBProcedures.P_VAL_SYSTEM(
					"LEN_REF_ID", 
					"REF_ID_1",
					M_CODE_DESC,
					"N",
					CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) !=  null) {
					M_CODE_DESC = list.get(0);
				}
			}

			
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
			
			System.out.println("M_PS_VALUE                 :"+M_PS_VALUE);
			
			
			if ("1".equals(M_PS_VALUE)) {
				
				System.out.println("ENTERS INTO M_PS_VALUE = 1 ");
				compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
						.setMaxlength(12);
				M_REF_ID_1_LENGTH = compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(null,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}
			else
			{
				
				System.out.println("ENTERS INTO M_PS_VALUE != 1 ");
				
				compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
				.setMaxlength(64);
				M_REF_ID_1_LENGTH = compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1()
						.getMaxlength();
				M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			}
			
			
			
			
			System.out.println("M_NEW_IC_NO_LENGTH in assured                 :"+M_NEW_IC_NO_LENGTH);
			System.out.println("M_REF_ID_1_LENGTH in assured                 :"+M_REF_ID_1_LENGTH);
			
			//System.out.println("KLKL  "+CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH));
			
			
			
			System.out.println("POAD_REF_ID1.length() in assured                 :"+POAD_REF_ID1.length());
			System.out.println("M_LENGTH_1 in assured                 :"+M_LENGTH_1);
			
			if (POAD_REF_ID1.length() != M_LENGTH_1) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91915",new Object[] {M_LENGTH_1 }));

			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);

			
			ADDED BY JANANI ON 13.8.2016 FOR NEW IC NO VALIDATION
			
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
			
			System.out.println("M_PS_VALUE  in assrd helper      :"+M_PS_VALUE);
			System.out.println("M_CODE_DESC  in assrd helper      :"+M_CODE_DESC);

			if ("1".equals(M_PS_VALUE)) {
				
				END
				System.out.println("POAD_REF_ID1.length()  in assrd helper      :"+POAD_REF_ID1.length());
				System.out.println("M_LENGTH_1  in assrd helper      :"+M_LENGTH_1);
				if (POAD_REF_ID1.length() != M_LENGTH_1) {
					
					

					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91915",new Object[] {M_LENGTH_1 }));
				}

			}
			resultSet = handler.executeSelectStatement(CURSOR_C5, connection,new Object[] { PT_IL_POLICY_BEAN.getPOL_CONT_CODE() });
			if (resultSet.next()) {
				M_CONT_REF_ID1 = resultSet.getString(1);
			}
			if ("M".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POL_PLAN_TYPE(),"X"))) {
				if (PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1() != null) {

					String assruedref=CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1(), "X").replaceAll("\\s","") ;
					String payorRef1=CommonUtils.nvl(POAD_REF_ID1, "X").replaceAll("\\s","") ;

					if (!assruedref.equalsIgnoreCase(payorRef1)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91918"));
					}
				}
			}

			if ("M".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POL_PLAN_TYPE(),"X"))) {

				String M_CONT_REF_ID11=CommonUtils.nvl(M_CONT_REF_ID1, "X").replaceAll("\\s","") ;
				String POAD_REF_ID11=CommonUtils.nvl(POAD_REF_ID1, "X").replaceAll("\\s","") ;



				if (!M_CONT_REF_ID11.equalsIgnoreCase(POAD_REF_ID11)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91919"));
				}
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1,connection,new Object[] {PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}
			if (("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN()))
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
							|| "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71211"));
				}

			} else {
				if (("N".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN()))
						&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) 
								|| "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
								&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
					if (M_DUMMY > 1) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71212"));
					}
				}
			}
			//ADDED BY AKASH TO MAKE NORMAL FLOW 
			//DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)
			if ((DUMMY_BEAN.getUI_M_CALC_METHOD().equals(1) || DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2))
					&& POAD_REF_ID1 != null
					&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
				M_EXIST = "N";
				if(!(assuredBean.getPOAD_REF_ID1().equalsIgnoreCase(POAD_REF_ID1))){
					IL_POAD_GET_ASSR_DTLS(
							assuredBean.getPOAD_ASSR_CODE(), "N",
							POAD_REF_ID1,
							assuredBean.getPOAD_REF_ID2(),
							M_EXIST, "R", compositeAction);
					assuredBean.setPOAD_TYPE("R");
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_REF_ID1().setRequired(false);
				}

			}

			list1 = DBProcedures.P_VAL_SYSTEM(
					"CUSTREFFMT",
					"CUSTREFFMT",
					M_CODE_DESC, "N", 
					M_PS_VALUE);
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(1) != null) {
					M_PS_VALUE = list1.get(1);

			}

			COMMENTED BY JANANI ON 13.8.2016 FOR NEW IC NO VALIDATION
			
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

			}
			
			END

			M_CUST_REF_ID1 = POAD_REF_ID1;
			CommonUtils.closeCursor(resultSet);
			
			System.out.println("M_PS_VALUE              :"+M_PS_VALUE);
			
			if ("1".equals(M_PS_VALUE)) {
				
				System.out.println("ENTERS IN TO ic NO VALIDATION");
				
				
				if (  (  CommonUtils.nvl(M_EXIST, "N") != "Y"
						&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
						|| ( "2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
								&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0))  ||
								("001".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"000"))) ){


					resultSet = handler.executeSelectStatement(CURSOR_C2,connection, new Object[] { M_CUST_REF_ID1 });
					if (resultSet.next()) {
						M_DATE_CHAR = resultSet.getString(1);
						String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
						resultSet1 = handler.executeSelectStatement(query, connection,new Object[]{M_DATE_CHAR});
						if (resultSet1.next()) {
							M_DATE_CHAR = resultSet1.getString(1);
						}
						CommonUtils.closeCursor(resultSet1);
						M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
						if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils.getYearFromDate(commonUtils.getCurrentDate())) {
							//String temp1 = CommonUtils.dateToStringFormatter();
							M_TEMP_DATE = CommonUtils.stringToPelUtilDate(CommonUtils.dateToPELStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200)));
							assuredBean.setPOAD_DOB(M_TEMP_DATE);

						} else {
							assuredBean.setPOAD_DOB(M_TEMP_DATE);
						}
					} else {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
					}
				}


				
			commented by sankar for ic no validation on 13.8.2016
			 * 
			 * 
			 * 
			 * 
			 * }
			
			
			
				CommonUtils.closeCursor(resultSet);
				M_GENDER = Integer.parseInt((POAD_REF_ID1.substring(POAD_REF_ID1.length() -1)));
				if (M_GENDER % 2 == 0) {
					assuredBean.setPOAD_CATG_CODE("2");
				} else {
					assuredBean.setPOAD_CATG_CODE("1");
				}


			Added by sankar for ic no validation on 13.8.2016
			



				  Commented by Sankar for ic no validation on 13.8.2016
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 

				CommonUtils.closeCursor(resultSet);
				M_GENDER = Integer.parseInt((POAD_REF_ID1.substring(POAD_REF_ID1.length() -1)));
				if (M_GENDER % 2 == 0) {
					assuredBean.setPOAD_CATG_CODE("2");
				} else {
					assuredBean.setPOAD_CATG_CODE("1");
				}

				Added by Sankar for ic no validation on 13.8.2016


			}

			
			
			else{
				
				
				System.out.println("ENTERS INTO NO IC NO VALIDATION           "+assuredBean.getPOAD_ASSR_CODE());
				
				resultSet2 = handler.executeSelectStatement(CURSOR_C6,connection,new Object[] { assuredBean.getPOAD_ASSR_CODE() });
				if (resultSet2.next()) {
					assuredBean.setPOAD_CATG_CODE(resultSet2.getString("CUST_CATG_CODE"));
					assuredBean.setPOAD_DOB(resultSet2.getDate("CUST_DOB"));
				}


			

			END



			if (assuredBean.getPOAD_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM(
						"CATG",
						assuredBean.getPOAD_CATG_CODE(),
						assuredBean.getUI_M_POAD_CATG_DESC(),
						"E",M_VALUE);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						assuredBean.setUI_M_POAD_CATG_DESC(list3.get(0));
					}if (list3.get(1) != null) {
						M_VALUE = list3.get(1);
					}
				}
			}
			P_CAL_PLAN_PERIOD(assuredBean.getPOAD_DOB(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

			if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,connection,new Object[] { M_CUST_REF_ID1 });
				int M_TEMP_YEAR=0;
				if (resultSet.next()) {
					M_DATE_CHAR = resultSet.getString(1);

					String datequery=" SELECT  TO_DATE(?,'RRMMDD') FROM DUAL";
					resultSet1 = handler.executeSelectStatement(datequery, connection,new Object[]{M_DATE_CHAR});
					if (resultSet1.next()) {
						M_TEMP_DATE = resultSet1.getDate(1);
					}
					String yearquery=" SELECT TO_NUMBER(TO_CHAR(?,'RRRR')) FROM DUAL";
					resultSet1 = handler.executeSelectStatement(yearquery, connection,new Object[]{M_TEMP_DATE});
					if (resultSet1.next()) {
						M_TEMP_YEAR = resultSet1.getInt(1);
					}

					if ((M_TEMP_YEAR) > (CommonUtils.getYearFromDate(commonUtils.getCurrentDate()))) {
						String temp = CommonUtils.dateToStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200));
						M_TEMP_DATE = CommonUtils.newStringToDate(temp);
						assuredBean.setPOAD_DOB(M_TEMP_DATE);
					} else {
						assuredBean.setPOAD_DOB(M_TEMP_DATE);
					}
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
				}
			}
			String query_c = "SELECT POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID=?";
			ResultSet rs3 = handler.executeSelectStatement(query_c, connection,
					new Object[] { compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_POL_SYS_ID() });
			if (rs3.next()) {
				int noOfCigar = rs3.getInt(1);
			}
			if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_NO_OF_CIGAR() != null) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getCOMP_POAD_NO_OF_CIGAR().resetValue();
			}
			}
		} 
			}catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}*/

	public void IL_UNIQUE_POL_ASSR_CODE(String P_ASSR_CODE) {

		/*
		 * String M_ASSR_CODE = null;
		 * 
		 * String CURSOR_C1 = "SELECT 'X' FROM PT_IL_POL_ASSURED_DTLS WHERE
		 * POAD_ASSR_CODE = PT_IL_POL_ASSURED_DTLS.POAD_ASSR_CODE AND
		 * POAD_POL_SYS_ID = PT_IL_POLICY.POL_SYS_ID; BEGIN IF C1%ISOPEN THEN
		 * CLOSE C1; END IF; OPEN C1; FETCH C1 INTO M_ASSR_CODE; IF C1%FOUND
		 * THEN STD_MESSAGE_ROUTINE(71216,NAME_IN('GLOBAL.M_LANG_CODE')); CLOSE
		 * C1; RAISE FORM_TRIGGER_FAILURE; END IF; CLOSE C1;
		 */

	}

	public void P_CAL_PLAN_PERIOD(Date date,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN) throws Exception {

		String M_DUM_VALUE = null;
		String M_DUM_DESC = null;
		Integer M_PLAN_MAX_AGE_ON_MAT = null;
		Integer P_POAD_AGE =PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() ;

		Date M_CUST_DOB;
		String M_PLAN_AGE_TERM_FLAG = null;
		Integer M_PLAN_AGE_FROM = null;
		Integer M_PLAN_AGE_TO = null;
		String M_PAS_AGE_BASIS = null;
		Integer M_PAS_MIN_AGE = null;
		Integer M_PAS_MAX_AGE = null;
		Integer M_PAS_MIN_PERIOD = null;
		Integer M_PAS_MAX_PERIOD = null;
		Integer M_PAS_MAX_AGE_ON_MAT = null;
		String M_PAYER_PAYEE = null;
		Integer M_PLAN_PERIOD_FROM = null;
		Integer M_PLAN_PERIOD_TO = null;
		String M_PLAN_TYPE = null;
		String M_PMA_AGE_BASIS = null;
		Integer M_PMA_MAT_PAYER_AGE = null;
		Integer M_PMA_MAT_PAYEE_AGE = null;
		Integer M_PLAN_MIN_AGE_ON_MAT = null;
		Integer M_PMA_MAT_MIN_PAYER_AGE = null;
		Integer M_PMA_MAT_MIN_PAYEE_AGE = null;
		Long M_POAC_SYS_ID = null;
		Long M_POAC_POL_SYS_ID = null;
		String M_POAC_COVER_CODE; 
		Integer M_POAC_PREM_PAY_YRS;
		Integer M_POAC_PERIOD;
		Integer M_ADDLCOVER_DIFF;
		String CURSOR_C1 = "SELECT PLAN_MAX_AGE_ON_MAT,PLAN_MIN_AGE_ON_MAT,PLAN_AGE_TERM_FLAG,"
				+ "PLAN_AGE_FROM,PLAN_AGE_TO,PLAN_PERIOD_FROM, PLAN_PERIOD_TO, PLAN_TYPE "
				+ "FROM PM_IL_PLAN WHERE  PLAN_CODE =  ?  AND PLAN_FRZ_FLAG = 'N'";
		String CURSOR_C2 = "SELECT PAS_MIN_AGE,PAS_MAX_AGE,PAS_MIN_PERIOD,PAS_MAX_PERIOD,"
				+ "PAS_MAX_AGE_ON_MAT FROM   PM_IL_PLAN_AGE_SETUP WHERE  PAS_PLAN_CODE = ?"
				+ "AND  PAS_JOINT_LIFE_YN = ? AND DECODE(M_PAYER_PAYEE,'R',?,?) BETWEEN PAS_CATG_FM_CODE "
				+ "AND PAS_CATG_TO_CODE AND  P_POAD_AGE  BETWEEN  PAS_ASSRD_AGE_FM  AND  PAS_ASSRD_AGE_TO "
				+ "AND  PAS_AGE_BASIS = ? ";
		String CURSOR_C3 = "SELECT PMA_AGE_BASIS,PMA_MAT_PAYER_AGE,PMA_MAT_PAYEE_AGE,PMA_MAT_MIN_PAYER_AGE,"
				+ "PMA_MAT_MIN_PAYEE_AGE FROM PM_IL_PLAN_MAT_AGESETUP WHERE PMA_PLAN_CODE = ? ";
		String CURSOR_C4 = "SELECT POAC_SYS_ID,POAC_POL_SYS_ID,POAC_COVER_CODE,POAC_PREM_PAY_YRS,POAC_PERIOD,(NVL(POAC_ORG_PERIOD,0)-NVL(POAC_ORG_PREM_PAY_YRS,0))"
				+ " FROM  PT_IL_POL_ASSURED_DTLS,PT_IL_POL_ADDL_COVER WHERE  POAD_SYS_ID =  POAC_POAD_SYS_ID AND POAD_POL_SYS_ID = ? ";
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<OracleParameter> list1 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_MAX_AGE_ON_MAT = resultSet.getInt(1);
				M_PLAN_MIN_AGE_ON_MAT = resultSet.getInt(2);
				M_PLAN_AGE_TERM_FLAG = resultSet.getString(3);
				M_PLAN_AGE_FROM = resultSet.getInt(4);
				M_PLAN_AGE_TO = resultSet.getInt(5);
				M_PLAN_PERIOD_FROM = resultSet.getInt(6);
				M_PLAN_PERIOD_TO = resultSet.getInt(7);
				M_PLAN_TYPE = resultSet.getString(8);
			}
			CommonUtils.closeCursor(resultSet);
			list = DBProcedures.P_VAL_SYSTEM("IL_AGE_CAL", "IL_AGE_CAL",
					M_DUM_DESC, "N", M_DUM_VALUE);
			M_DUM_DESC = list.get(0);
			M_DUM_VALUE = list.get(1);
			if ("1".equals(M_DUM_VALUE)) {
				list1 = new  ArrayList<OracleParameter>();
				list1 = localProcedure.P_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_START_DT(), 
						date,  DUMMY_BEAN.getUI_M_PROD_AGE_CALC_FLAG(),P_POAD_AGE);
				P_POAD_AGE = (Integer)list1.get(0).getValueObject();
			} else {
				list1 = new  ArrayList<OracleParameter>();
				
				list1 = localProcedure.P_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(), 
						date, DUMMY_BEAN.getUI_M_PROD_AGE_CALC_FLAG()
						,P_POAD_AGE);
				
				/*by Ram on 04/11/2016 for dynamic Age Calculation
				 * 
				 * list1 = localProcedure.P_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_START_DT(), 
						date, DUMMY_BEAN.getUI_M_PROD_AGE_CALC_FLAG()
						,P_POAD_AGE);*/
				P_POAD_AGE = (Integer)list1.get(0).getValueObject();
			}
			DUMMY_BEAN.setUI_M_AGE(P_POAD_AGE);
			
			/*Added by Ram on 04/11/2016 for FALCONLIFE-1354039*/ 
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(P_POAD_AGE);
			/*End*/
			
			if ("H".equals(M_PLAN_AGE_TERM_FLAG)) {
				if (P_POAD_AGE != null) {
					if ((CommonUtils.nvl(M_PLAN_MAX_AGE_ON_MAT, 0))
							- (CommonUtils.nvl(P_POAD_AGE, 0)) >= 0) {
						if (("D".equals(M_PLAN_TYPE))
								&& ("013".equals(CommonUtils.nvl(
										PT_IL_POLICY_BEAN.getPOL_END_TYPE(),
										"000")))) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD( (CommonUtils.nvl(
									M_PLAN_MAX_AGE_ON_MAT, 0) - CommonUtils
									.nvl(P_POAD_AGE, 0)));
						} else {
							if (CommonUtils.nvl(P_POAD_AGE, 0)
									+ CommonUtils.nvl(PT_IL_POLICY_BEAN
											.getPOL_PERIOD(), 0) > CommonUtils
											.nvl(M_PLAN_MAX_AGE_ON_MAT, 0)
											|| PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() == null) {

								if (PT_IL_POLICY_BEAN.getPOL_PERIOD() == null) {
									PT_IL_POLICY_BEAN
									.setPOL_PERIOD( CommonUtils
											.nvl(M_PLAN_MAX_AGE_ON_MAT, 0)
											- CommonUtils
											.nvl(P_POAD_AGE, 0));
								}

							}

						}
					}
					if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(
							DUMMY_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
						PT_IL_POLICY_BEAN
						.setPOL_PERIOD(PT_IL_POLICY_BEAN
								.getPOL_PERIOD()
								- (PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
										.nvl(
												DUMMY_BEAN
												.getUI_M_PROD_PERIOD_MULTIPLE(),
												1)));
					}
					if (CommonUtils.nvl(P_POAD_AGE, 0)
							+ CommonUtils.nvl(
									PT_IL_POLICY_BEAN.getPOL_PERIOD(),0) < CommonUtils
									.nvl(M_PLAN_MIN_AGE_ON_MAT, 0)) {
						PT_IL_POLICY_BEAN.setPOL_PERIOD( CommonUtils
								.nvl(M_PLAN_MIN_AGE_ON_MAT, 0)
								- CommonUtils.nvl(P_POAD_AGE, 0));
					}
					if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(
							DUMMY_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
						PT_IL_POLICY_BEAN
						.setPOL_PERIOD(PT_IL_POLICY_BEAN
								.getPOL_PERIOD()
								+ (DUMMY_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE() - (PT_IL_POLICY_BEAN
												.getPOL_PERIOD() % CommonUtils
												.nvl(
														DUMMY_BEAN
														.getUI_M_PROD_PERIOD_MULTIPLE(),
														1))));
					}
					if (CommonUtils.nvl(
							PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(), 0) > CommonUtils
							.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)) {
						PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(CommonUtils.nvl(
								PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0));
					}
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath,
							"3206",
							new Object[] {"Customer Age should lie between " +
									CommonUtils.nvl(M_PLAN_AGE_FROM,0) + " and "+
									CommonUtils.nvl(M_PLAN_AGE_TO,0)+ " years" }));
				}
			} else if ("S".equals(M_PLAN_AGE_TERM_FLAG)) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection, new Object[] { PT_IL_POLICY_BEAN
						.getPOL_PLAN_CODE() });
				if (resultSet.next()) {
					M_PMA_AGE_BASIS = resultSet.getString(1);
					M_PMA_MAT_PAYER_AGE = resultSet.getInt(2);
					M_PMA_MAT_PAYEE_AGE = resultSet.getInt(2);
					M_PMA_MAT_MIN_PAYER_AGE = resultSet.getInt(2);
					M_PMA_MAT_MIN_PAYEE_AGE = resultSet.getInt(2);
				}
				CommonUtils.closeCursor(resultSet);
				if ("R".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() != null) {
						P_POAD_AGE = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()
								.intValue();
					}
					if (P_POAD_AGE != null) {
						/*if (P_POAD_AGE + PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYER_AGE) {
							PT_IL_POLICY_BEAN
									.setPOL_PERIOD( M_PMA_MAT_PAYER_AGE
											- P_POAD_AGE);
						}*/
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(
										DUMMY_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									- (PT_IL_POLICY_BEAN
											.getPOL_PERIOD() % CommonUtils
											.nvl(
													DUMMY_BEAN
													.getUI_M_PROD_PERIOD_MULTIPLE(),
													1)));
						}
						if (CommonUtils.nvl(P_POAD_AGE, 0)
								+ CommonUtils.nvl(PT_IL_POLICY_BEAN
										.getPOL_PERIOD(), 0) < CommonUtils.nvl(
												M_PMA_MAT_MIN_PAYER_AGE, 0)) {
							if("A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS())&&"012".equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"000"))){
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD( (CommonUtils.nvl(
										M_PMA_MAT_MIN_PAYER_AGE, 0) - CommonUtils
										.nvl(P_POAD_AGE, 0)));
							}
						}
						if (PT_IL_POLICY_BEAN.getPOL_PERIOD()
								% CommonUtils.nvl(DUMMY_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1) > 0) {

							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									+ (DUMMY_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE() - (PT_IL_POLICY_BEAN
													.getPOL_PERIOD() % CommonUtils
													.nvl(
															DUMMY_BEAN
															.getUI_M_PROD_PERIOD_MULTIPLE(),
															1))));
						}

					}
				} else if ("E".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE() != null) {
						/*if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE()
								+ PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYEE_AGE) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(M_PMA_MAT_PAYEE_AGE
									- PT_IL_POL_ASSURED_DTLS_1_BEAN
											.getPOAD_AGE());
						}*/
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(
										DUMMY_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									- (PT_IL_POLICY_BEAN
											.getPOL_PERIOD() % CommonUtils
											.nvl(
													DUMMY_BEAN
													.getUI_M_PROD_PERIOD_MULTIPLE(),
													1)));
						}
						if (CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN
								.getPOAD_AGE(), 0)
								+ CommonUtils.nvl(PT_IL_POLICY_BEAN
										.getPOL_PERIOD(), 0) < CommonUtils.nvl(
												M_PMA_MAT_MIN_PAYEE_AGE, 0)) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(CommonUtils.nvl(
									M_PMA_MAT_MIN_PAYEE_AGE, 0)
									- CommonUtils.nvl(
											PT_IL_POL_ASSURED_DTLS_1_BEAN
											.getPOAD_AGE(), 0));
						}
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(
										DUMMY_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									+ (DUMMY_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE() - (PT_IL_POLICY_BEAN
													.getPOL_PERIOD() % CommonUtils
													.nvl(
															DUMMY_BEAN
															.getUI_M_PROD_PERIOD_MULTIPLE(),
															1))));
						}
					}
				} else if ("M".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() != null
							&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE() != null) {
						if (M_PMA_MAT_PAYER_AGE
								- PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() < (M_PMA_MAT_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE())) {
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYER_AGE
									- PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_PAYER_AGE
										- PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_AGE());
							}
							if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
									.nvl(DUMMY_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(PT_IL_POLICY_BEAN
										.getPOL_PERIOD()
										- (PT_IL_POLICY_BEAN
												.getPOL_PERIOD() % CommonUtils
												.nvl(
														DUMMY_BEAN
														.getUI_M_PROD_PERIOD_MULTIPLE(),
														1)));
							}
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() < (M_PMA_MAT_MIN_PAYER_AGE - PT_IL_POL_ASSURED_DTLS_BEAN
									.getPOAD_AGE())) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_MIN_PAYER_AGE
										- PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_AGE());
							}
						} else if ((M_PMA_MAT_PAYER_AGE - PT_IL_POL_ASSURED_DTLS_BEAN
								.getPOAD_AGE()) > (M_PMA_MAT_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE())) {
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYEE_AGE
									- PT_IL_POL_ASSURED_DTLS_1_BEAN
									.getPOAD_AGE()) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_PAYEE_AGE
										- PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE());
							}
							if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
									.nvl(DUMMY_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(PT_IL_POLICY_BEAN
										.getPOL_PERIOD()
										- (PT_IL_POLICY_BEAN
												.getPOL_PERIOD() % CommonUtils
												.nvl(
														DUMMY_BEAN
														.getUI_M_PROD_PERIOD_MULTIPLE(),
														1)));
							}
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() < (M_PMA_MAT_MIN_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
									.getPOAD_AGE())) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_MIN_PAYEE_AGE
										- PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE());
							}
						}
					}
				}
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(), 0) > CommonUtils
						.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)) {
					PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(CommonUtils.nvl(
							PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0));
				}
				if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
					resultSet = handler.executeSelectStatement(CURSOR_C4,
							connection, new Object[] {});
					while (resultSet.next()) {
						M_POAC_SYS_ID = resultSet.getLong(1);
						M_POAC_POL_SYS_ID = resultSet.getLong(2);
						M_POAC_COVER_CODE = resultSet.getString(3);
						M_POAC_PREM_PAY_YRS = resultSet.getInt(4);
						M_POAC_PERIOD = resultSet.getInt(5);
						M_ADDLCOVER_DIFF = resultSet.getInt(6);

						if (M_POAC_PERIOD > PT_IL_POLICY_BEAN.getPOL_PERIOD()) {

							String UPDATE_QUERY = "UPDATE PT_IL_POL_ADDL_COVER SET  POAC_PERIOD = ? "
									+ ",POAC_PREM_PAY_YRS =LEAST((?  - M_ADDLCOVER_DIFF ),?) WHERE  POAC_SYS_ID = ?  AND POAC_POL_SYS_ID = ? ";
							int returnValue = handler.executeUpdateStatement(
									UPDATE_QUERY, connection, new Object[] {
											PT_IL_POLICY_BEAN.getPOL_PERIOD(),
											PT_IL_POLICY_BEAN.getPOL_PERIOD(),
											PT_IL_POLICY_BEAN
											.getPOL_PREM_PAY_YRS(),
											M_POAC_SYS_ID, M_POAC_POL_SYS_ID });
						}
					}
					CommonUtils.closeCursor(resultSet);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<String> IL_POAD_GET_ASSR_DTLS(String P_POAD_ASSR_CODE,
			String P_ERR_YN, String P_REF_ID1, String P_REF_ID2,
			String P_EXIST, String P_POAD_TYPE,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_POL_NO = null;
		String M_DESC = null;
		Integer M_PS_VALUE = 0;

		String CURSOR_C1 = "SELECT  POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,"
				+ "POAD_MAR_STATUS,POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,"
				+ "POAD_HEIGHT,POAD_WEIGHT,NVL(POAD_AGE_PROOF_FLAG,'0'),POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
				+ "POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, PT_IL_POLICY WHERE POL_SYS_ID = POAD_POL_SYS_ID "
				+ "AND  POAD_ASSR_CODE = ?  AND   POL_NO <>  ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";

		String CURSOR_C2 = "SELECT   POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,"
				+ " POAD_MAR_STATUS,POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,"
				+ " POAD_HEIGHT,POAD_WEIGHT,NVL(POAD_AGE_PROOF_FLAG,'0'),POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
				+ " POAD_BMI,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,POAD_RACE,POAD_RELIGION_CODE, "
				+ " DECODE( ? ,'Y',POAD_TYPE,'R'),POAD_HEIGHT_UNIT, POAD_WEIGHT_UNIT,POAD_FC_SALARY,"
				+ " POAD_LC_SALARY,POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, PT_IL_POLICY WHERE POL_SYS_ID = POAD_POL_SYS_ID "
				+ " AND POAD_REF_ID1 = ?  AND  POL_NO <>  ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC";

		String CURSOR_C3 = " SELECT   POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,POAD_MAR_STATUS,"
				+ " POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,POAD_HEIGHT,POAD_WEIGHT, NVL(POAD_AGE_PROOF_FLAG,'0'),"
				+ " POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,POAD_BMI,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,"
				+ " POAD_RACE,POAD_RELIGION_CODE, DECODE( PT_IL_POLICY.POL_JOINT_LIFE_YN,'Y',POAD_TYPE,'R'),POAD_HEIGHT_UNIT,"
				+ " POAD_WEIGHT_UNIT,POAD_FC_SALARY, POAD_LC_SALARY,POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, "
				+ " PT_IL_POLICY WHERE    POL_SYS_ID = POAD_POL_SYS_ID  AND  POAD_REF_ID2 = ? AND POL_NO <> ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ArrayList<String> list = new  ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		Connection connection = null;
		DBProcedures procedures = new DBProcedures();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			connection = CommonUtils.getConnection();
			list = DBProcedures.P_VAL_SYSTEM("IL_CALC_MTHD", "IL_CALC_MTHD",
					M_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			M_DESC = list.get(0);
			M_PS_VALUE = Integer.parseInt(list.get(1));
			if (M_PS_VALUE == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { P_POAD_ASSR_CODE,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if ("R".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
								.getDate(3));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
								.getInt(4));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(5));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(resultSet
								.getString(7));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(resultSet
								.getString(10));
						M_POL_NO = resultSet.getString(11);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(resultSet
								.getString(12));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(13));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(15));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_OTHERS());
						/*(resultSet
										.getString(16));*/
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(resultSet
								.getInt(17));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(18));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(resultSet
								.getString(19));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(20));

					}
				} else if ("E".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
								.getDate(3));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
								.getInt(4));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(5));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REMARKS(resultSet
								.getString(10));
						M_POL_NO = resultSet.getString(11);
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(12));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(13));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(15));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_OTHERS());
						/*resultSet
										.getString(16));*/
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_DISC_AGE(resultSet.getInt(17));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(18));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_SMOKE_YN(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(20));

					}
				}
				/*if (resultSet.next()) {
					P_EXIST = "Y";
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71203",
							new Object[] { M_POL_NO }));
				}*/
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN(),
						P_REF_ID1,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if ("R".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {

						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSR_CODE(resultSet
								.getString(1));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(resultSet
								.getString(8));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(10));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(resultSet
								.getString(11));
						M_POL_NO = resultSet.getString(12);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(resultSet
								.getString(13));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(16));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_OTHERS());
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(resultSet
								.getInt(18));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND((resultSet
								.getDouble(20)),2));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(resultSet
								.getString(21));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(resultSet
								.getString(22));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CLASS(resultSet
								.getString(23));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(resultSet
								.getString(24));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_RELIGION_CODE(resultSet.getString(25));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE(resultSet
								.getString(26));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEIGHT_UNIT(resultSet.getString(27));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_WEIGHT_UNIT(resultSet.getString(28));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SALARY(resultSet
								.getDouble(29));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(resultSet
								.getDouble(30));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(resultSet
								.getString(31));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(32));
					}
				} else if ("E".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSR_CODE(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(10));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REMARKS(resultSet
								.getString(11));
						M_POL_NO = (resultSet.getString(12));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(13));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(16));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_OTHERS());
						/*resultSet
										.getString(17));*/
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_DISC_AGE(resultSet.getInt(18));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
								.getDouble(20));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID1(resultSet
								.getString(21));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID2(resultSet
								.getString(22));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CLASS(resultSet.getString(23));

						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RACE(resultSet
								.getString(24));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_RELIGION_CODE(resultSet.getString(25));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE(resultSet
								.getString(26));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEIGHT_UNIT(resultSet.getString(27));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_WEIGHT_UNIT(resultSet.getString(28));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_FC_SALARY(resultSet.getDouble(29));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_LC_SALARY(resultSet.getDouble(30));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_SMOKE_YN(resultSet.getString(31));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(32));
					}
				}
				//commented by Kavitha For poc suspend a/c ( to allow assured more then one policy)
				/* if (resultSet.next()) {
					P_EXIST = "Y";
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71203", new Object[] { M_POL_NO }));
				} else { */
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection, new Object[] { P_REF_ID2,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if ("R".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSR_CODE(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSURED_NAME(resultSet
								.getString(2));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet
								.getString(9));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEALTH_CODE(resultSet
								.getString(10));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_REMARKS(resultSet.getString(11));
						M_POL_NO = resultSet.getString(12);
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(13));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEIGHT(resultSet.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_WEIGHT(resultSet.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet
								.getString(16));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_OTHERS());
						/*resultSet
											.getString(17));*/
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_DISC_AGE(resultSet.getInt(18));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_ADDL_RISK_CODE(resultSet
													.getString(19));
											PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet
													.getDouble(20));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_REF_ID1(resultSet.getString(21));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_REF_ID2(resultSet.getString(22));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_OCC_CLASS(resultSet.getString(23));

											PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(resultSet
													.getString(24));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_RELIGION_CODE(resultSet
													.getString(25));
											PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE(resultSet
													.getString(26));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_HEIGHT_UNIT(resultSet
													.getString(27));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_WEIGHT_UNIT(resultSet
													.getString(28));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_FC_SALARY(resultSet.getDouble(29));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_LC_SALARY(resultSet.getDouble(30));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_SMOKE_YN(resultSet.getString(31));
											PT_IL_POL_ASSURED_DTLS_BEAN
											.setPOAD_NO_OF_CIGAR(resultSet
													.getInt(32));
					}
				} else if ("E".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSR_CODE(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(resultSet
								.getString(2));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet
								.getString(9));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEALTH_CODE(resultSet
								.getString(10));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_REMARKS(resultSet.getString(11));
						M_POL_NO = resultSet.getString(12);
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(13));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEIGHT(resultSet.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_WEIGHT(resultSet.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet
								.getString(16));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_OTHERS(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_OTHERS());
						/*resultSet
											.getString(17));*/
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_DISC_AGE(resultSet.getInt(18));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet
								.getString(19));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
								.getDouble(20));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_REF_ID1(resultSet.getString(21));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_REF_ID2(resultSet.getString(22));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CLASS(resultSet.getString(23));

						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_RACE(resultSet.getString(24));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_RELIGION_CODE(resultSet
								.getString(25));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_TYPE(resultSet.getString(26));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEIGHT_UNIT(resultSet
								.getString(27));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_WEIGHT_UNIT(resultSet
								.getString(28));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_FC_SALARY(resultSet.getDouble(29));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_LC_SALARY(resultSet.getDouble(30));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_SMOKE_YN(resultSet.getString(31));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet
								.getInt(32));
					}
				}
				/*if (resultSet.next()) {
						P_EXIST = "Y";
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"71203", new Object[] { M_POL_NO }));
					}*/
				CommonUtils.closeCursor(resultSet);
				//}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		list1.add(P_EXIST);
		return list1;

	}

	public void POAD_REF_ID2_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, PT_IL_POL_ASSURED_DTLS assruedBean) throws Exception {

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		Integer M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_EXIST = null;
		String CURSOR_C1 = "SELECT  COUNT(*) FROM    PT_IL_POL_ASSURED_DTLS  WHERE   POAD_POL_SYS_ID = ? ";
		Integer M_LENGTH_2 = null;
		Integer M_OLD_IC_NO_LENGTH = assruedBean.getPOAD_REF_ID2().length();
		String LENTH_QUERY = "SELECT DATA_LENGTH  FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PT_IL_POL_ASSURED_DTLS'  AND COLUMN_NAME = 'POAD_REF_ID2'";
		Integer M_REF_ID2_LENGTH = null;
		String M_CODE_DESC = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		ArrayList<String> list = new ArrayList<String>();

		ArrayList<String> list1 = new ArrayList<String>();
		String CURSOR_C3 = "SELECT CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID2 = ? ";
		String CURSOR_C4 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_OCCDEF_YN'";
		Integer M_PS_VALUE = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(LENTH_QUERY,connection);
			if (resultSet.next()) {
				M_REF_ID2_LENGTH = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_2",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_OLD_IC_NO_LENGTH));
			M_CODE_DESC = list.get(0);
			M_OLD_IC_NO_LENGTH = Integer.parseInt(list.get(1));
			M_LENGTH_2 = Math.min(CommonUtils.nvl(M_OLD_IC_NO_LENGTH,
					M_REF_ID2_LENGTH), M_REF_ID2_LENGTH);
			if (assruedBean.getPOAD_REF_ID2().length() > M_LENGTH_2) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91240",
						new Object[] { M_LENGTH_2 }));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()))
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && (PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71211"));
				}
			} else if ("N".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()))
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && (PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71212"));
				}
			}

			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			//|| DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)

			if ((DUMMY_BEAN.getUI_M_CALC_METHOD().equals(1) || DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2))
					&& assruedBean.getPOAD_REF_ID1() == null
					&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0)) {
				list1 = IL_POAD_GET_ASSR_DTLS(assruedBean
						.getPOAD_ASSR_CODE(), "N", assruedBean
						.getPOAD_REF_ID1(), assruedBean
						.getPOAD_REF_ID2(), M_EXIST, "R", compositeAction);
				M_EXIST = list1.get(0);
				assruedBean.setPOAD_TYPE("R");
			}

			//ADDED BY AKASH TO MAKE NORMAL FLOW
			//|| DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)

			if (DUMMY_BEAN.getUI_M_CALC_METHOD().equals(1) || DUMMY_BEAN.getUI_M_CALC_METHOD().equals(2)) {
				if (assruedBean.getPOAD_REF_ID1() == null
						&& assruedBean.getPOAD_REF_ID2() == null) {
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getCOMP_POAD_REF_ID2().setRequired(true);
				}
			}
			P_CAL_PLAN_PERIOD(assruedBean.getPOAD_DOB(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			if (assruedBean.getPOAD_OCC_CODE() == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C4,
						connection);
				if (resultSet.next()) {
					M_PS_VALUE = resultSet.getInt(1);
				}
				CommonUtils.closeCursor(resultSet);
				if (M_PS_VALUE == 1) {
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection,
							new Object[] { assruedBean
							.getPOAD_REF_ID2() });
					if (resultSet.next()) {
						assruedBean.setPOAD_OCC_CODE(resultSet
								.getString(1));
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void POAD_TYPE_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS  PT_IL_POL_ASSURED_DTLS_BEAN) throws Exception {

		PKG_PILT002_APAC  localProcedure = new PKG_PILT002_APAC();
		try{

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE() == null) {

				localProcedure.P_DISP_OCCU_CODE_AND_CLASS(
						CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_TYPE(),"X"),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),compositeAction);
			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_TYPE() != "R") {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String POAD_TYPE_WHEN_VALIDATE_ITEM(String POAD_TYPE) throws Exception{

		try {
			if (!("R".equals(POAD_TYPE))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",
						new Object[]{"Payor should be selected in payor details"}));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_TYPE;
	}

	public void  POAD_CATG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_ASSURED_DTLS assuredBean)
			throws Exception {

		Integer M_VALUE = 0;

		ArrayList<String> list = new ArrayList<String>();
		try {
			if (assuredBean.getPOAD_CATG_CODE() != null) {
				list = DBProcedures.P_VAL_SYSTEM("CATG",assuredBean.getPOAD_CATG_CODE(),
						assuredBean.getUI_M_POAD_CATG_DESC(), "E", 
						CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						assuredBean.setUI_M_POAD_CATG_DESC(list.get(0));
					}
					if (list.get(1) != null) {
						M_VALUE = Integer.parseInt(list.get(1));
					}
				}


			} 
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}


	}

	public void POAD_DOB_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,java.util.Date POAD_DOB,
			PT_IL_POL_ASSURED_DTLS_ACTION assuredAction,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY policyBean, DUMMY DUMMY) throws Exception {

		Integer M_DUM_VALUE = 0;
		String M_DUM_DESC = null;
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = assuredAction
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		/*Added by Ameen on 08-05-2018 for KIC as per Ajoy sugg. for CDOB*/
		String P_M_CUST_AGE = "";
		PKG_PILT002_APAC PKG_PILT002_APAC_BEAN=new PKG_PILT002_APAC();
		List<String> pvalList = new ArrayList<String>();
		/*End*/
		try {
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {
				if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,3))) {
					assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				}
				assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				assuredAction.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE(0);
				list = DBProcedures.P_VAL_SYSTEM(
						"IL_AGE_CAL", "IL_AGE_CAL",
						CommonUtils.getProcedureValue(M_DUM_DESC), "N",
						CommonUtils.getProcedureValue(M_DUM_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						M_DUM_DESC = list.get(0);
					}
					if (list.get(1) != null) {
						M_DUM_VALUE = Integer.parseInt(list.get(1));
					}

				}
				/*Commented by Ram on 06/11/2016 for  	FALCONLIFE-1354039
				 * 
				 * if (M_DUM_VALUE == 1) {
					if (policyBean.getPOL_START_DT().before(POAD_DOB)) {
						throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
					}
					list1 = localProcedure.P_CALC_ANB(
							policyBean.getPOL_START_DT(),
							POAD_DOB, 
							DUMMY.getUI_M_PROD_AGE_CALC_FLAG(),
							CommonUtils.getProcedureValue(assuredAction.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE()));
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							assuredAction.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE((Integer)list1.get(0).getValueObject());
						}

					}

				} else {
					if (policyBean.getPOL_ISSUE_DT().before(POAD_DOB)) {
						throw new Exception(Messages
								.getString("messageProperties_PILT002_APAC",
										"IL_001"));
					}
					list1 = localProcedure.P_CALC_ANB(
							policyBean.getPOL_START_DT(), 
							POAD_DOB, 
							DUMMY.getUI_M_PROD_AGE_CALC_FLAG(),
							assuredAction
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE()
							);
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							assuredAction.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE(
									(Integer)list1.get(0).getValueObject());
						}

					}
				}
				
				End
				*/
				//if(policyBean.getPOL_PERIOD() == null){
				P_CAL_PLAN_PERIOD((Date) POAD_DOB, PT_IL_POL_ASSURED_DTLS_BEAN,
						PT_IL_POL_ASSURED_DTLS_1_BEAN, policyBean, DUMMY);
				/*Added by Ameen on 10-05-2018 for KIC as per Ajoy sugg. for CDOB*/
				
				if("CDOB".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
					
					pvalList = PKG_PILT002_APAC_BEAN.P_CAL_PLAN_PERIOD2(CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB()), policyBean.getPOL_PLAN_CODE(), policyBean.getPOL_JOINT_LIFE_YN(), 
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(), PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(), CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()), DUMMY.getUI_M_PROD_AGE_CALC_FLAG(), CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_ISSUE_DT()),policyBean.getROWID(), CommonUtils.getProcedureValue(DUMMY.getUI_M_PROD_PERIOD_MULTIPLE()), policyBean.getPOL_END_TYPE(),
							P_M_CUST_AGE, CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()), CommonUtils.getProcedureValue(policyBean.getPOL_PREM_PAY_YRS()));
				
					if(pvalList != null && pvalList.size() > 0){
							policyBean.setPOL_PERIOD(Integer.parseInt(pvalList.get(1)));
					}
				}
				
				/*End*/
				list2 = new ArrayList<String>();
				list2 = procedures.PKG_PILT002_IL_POAD_AGE_CHECK("R",
						policyBean.getPOL_PLAN_CODE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						policyBean.getPOL_JOINT_LIFE_YN(),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE()),
						CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()),
						CommonUtils.getProcedureValue(DUMMY.getUI_M_CALC_METHOD()),
						DUMMY.getUI_M_PLAN_AGE_TERM_FLAG());
				if (list2 != null && !list2.isEmpty()) {
					CommonUtils.setGlobalVariable("GLOBAL.M_PAYER_FOUND", list2.get(0));

				}
				//}
				/*
				 * 
				 * commented By Dhinesh on 30-06-2017
				 * 
				 * if (DUMMY.getUI_M_PAC_MAX_AGE_ON_MAT() != null) {


					if ((CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE(),
							0) + CommonUtils.nvl(policyBean.getPOL_PERIOD(), 0)) > (DUMMY
									.getUI_M_PAC_MAX_AGE_ON_MAT())) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91081"));
					}
				}*/
				assuredAction.getCOMP_POAD_AGE().setDisabled(true);
			} else {
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").subSequence(2, 3))) {
					assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				}
			}
			ArrayList<String> list4 = IL_DISC_AGE(compositeAction,
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE(), 
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ADDL_RISK_CODE(),
					policyBean.getPOL_START_DT(),
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DISC_AGE());
			if (list4 != null && !list4.isEmpty()) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(Integer
						.parseInt(list4.get(0)));
			}



		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(Double POAD_HEIGHT,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();

		/*String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID = ? "
				+ "AND M_STD_HEIGHT  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO ";*/
		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE "+
				M_STD_HEIGHT+ "   BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO ";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM  PM_IL_HTWT_DTL"
				+ " WHERE  M_STD_HEIGHT BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM  PM_IL_PROP_TREATY WHERE ? BETWEEN PT_START_DT "
				+ "AND PT_END_DT AND PT_CLASS_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			/*Commentted by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory */
			
			/*if (POAD_HEIGHT != null) {
				if (POAD_HEIGHT <=0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90007",
							new Object[]{"Height"}));
				}
			}*/
			
			/*End*/

			if ("M".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())
					&& POAD_HEIGHT > 2) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91431"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),
					PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			if (POAD_HEIGHT != null) {
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(PT_IL_POL_ASSURED_DTLS_BEAN
							.getPOAD_HEIGHT_UNIT())) {
						M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0);
					} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_BEAN
							.getPOAD_HEIGHT_UNIT())) {
						if ((Math.ceil(CommonUtils.nvl(POAD_HEIGHT, 0))) != CommonUtils
								.nvl(POAD_HEIGHT, 0)) {
							throw new Exception(Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91567"));
						}
						
						
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						
						/*
						 * Commented by Janani on 02.06.2017 for ZBILQC-1721957 
						 * 
						 * M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0) * 0.01;*/
						
						M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0);
						
						/*End*/
						
					} else {
						
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						/*
						 * Commented by Janani on 02.06.2017 for ZBILQC-1721957 
						 * 
						 * M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0) * 0.305;*/
						
						 M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0);
								
					/*End*/
						
					}
					if ("K".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())) {
						M_STD_WEIGHT = CommonUtils
								.nvl(PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_WEIGHT(), 0);
					} else {
						
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						
						/*M_STD_WEIGHT = CommonUtils
								.nvl(PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_WEIGHT(), 0) * 0.454;*/
						
						M_STD_WEIGHT = CommonUtils
								.nvl(PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_WEIGHT(), 0);
						
						/*End*/
						
						
					}
					if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,
								connection/*, new Object[] { DUMMY_BEAN
								.getUI_M_PT_SYS_ID() }*/);
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM
								&& M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90009"));
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			
			if (POAD_HEIGHT != null && POAD_HEIGHT>0
					&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT()>0) {
				
				/*if (POAD_HEIGHT != null && POAD_HEIGHT>0 
						&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT()>0 
						&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT()>=POAD_HEIGHT) {*/
			/*End*/
				list = procedures.L_BMI_CALC(
						POAD_HEIGHT,
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0).getValueObject() != null) {
						//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND(((Double) list.get(0).getValueObject()),2));
						//added by saranya on 31-03-16 for BMI
						System.out.println("******POAD_HEIGHT_WHEN_VALIDATE_ITEM  Start *********");
						//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
						double value=(Double)list.get(0).getValueObject();
						double roundOff = Math.round(value * 100.0) / 100.0;
						System.out.println("reduced value is:"+roundOff);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(roundOff);
						System.out.println("******POAD_HEIGHT_WHEN_VALIDATE_ITEM End *********");
						//end


					}
				}
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
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(String POAD_HEIGHT_UNIT,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_HEIGHT_FM = null;
		Double M_HTWT_HEIGHT_TO = null;
		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID =  ? "
				+ "AND  M_STD_HEIGHT  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL "
				+ "WHERE  M_STD_HEIGHT BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM   PM_IL_PROP_TREATY WHERE  ? BETWEEN PT_START_DT"
				+ " AND  PT_END_DT AND  PT_CLASS_CODE = ? ";
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if ("M".equals(POAD_HEIGHT_UNIT)
					&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() > 2) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91431"));
			}

			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),
					PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(POAD_HEIGHT_UNIT)) {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0);
					} else if ("C".equals(POAD_HEIGHT_UNIT)) {
						if ((Math.ceil(CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0))) 
								!= CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0)) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91567"));
						}
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.01;
					} else {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.305;
					}
					if ("K".equals(POAD_HEIGHT_UNIT)) {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(), 0);
					} else {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(), 0) * 0.454;
					}
					if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
								new Object[] { DUMMY_BEAN.getUI_M_PT_SYS_ID() });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT()>0 &&  PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() >0) {
			/*End	*/
				list = procedures.L_BMI_CALC(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI());
				//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND(((Double)list.get(0).getValueObject()),2));
				//added by saranya on 31-03-16 for BMI
				System.out.println("******POAD_HEIGHT_UNIT_WHEN_VALIDATE_ITEM  Start *********");
				//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
				double value=(Double)list.get(0).getValueObject();
				double roundOff = Math.round(value * 100.0) / 100.0;
				System.out.println("reduced value is:"+roundOff);
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(roundOff);
				System.out.println("******POAD_HEIGHT_UNIT_WHEN_VALIDATE_ITEM End *********");
				//end
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
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


	public void POAD_AGE_WHEN_VALIDATE_ITEM( PILT002_APAC_COMPOSITE_ACTION compositeAction,Integer POAD_AGE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN,
			PT_IL_POL_SA_INST_PYMT_HEAD PT_IL_POL_SA_INST_PYMT_HEAD_BEAN)
					throws Exception {

		String CURSOR_C1 = "SELECT NVL(DS_AGE_RECALC_YN,'N') FROM   PM_IL_DOC_SETUP WHERE  DS_CODE = ? ";

		String M_DS_AGE_RECALC_YN = null;
		Double M_AGE = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<OracleParameter> list1 = new ArrayList<OracleParameter>();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (resultSet.next()) {
				M_DS_AGE_RECALC_YN = resultSet.getString(1);
			}
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB() != null) {
				P_CAL_PLAN_PERIOD(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB(),
						PT_IL_POL_ASSURED_DTLS_BEAN,
						PT_IL_POL_ASSURED_DTLS_1_BEAN, PT_IL_POLICY_BEAN,
						DUMMY_BEAN);
			}

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB() != null) {
				list1 = localProcedure.IL_POAD_AGE_CHECK("R", 
						PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(), 
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE(),
						PT_IL_POLICY_BEAN.getPOL_PERIOD(),
						DUMMY_BEAN.getUI_M_CALC_METHOD(),
						DUMMY_BEAN.getUI_M_PLAN_AGE_TERM_FLAG(),null);
				CommonUtils.setGlobalVariable("PKG_PILT002_IL_POAD_AGE_CHECK",(String)list1.get(0).getValueObject());
			}
			if (!("002".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) && "N".equals(M_DS_AGE_RECALC_YN)) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(POAD_AGE);
			}

			ArrayList<String> returnValue = IL_DISC_AGE(compositeAction,POAD_AGE,
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ADDL_RISK_CODE(),
					PT_IL_POLICY_BEAN.getPOL_START_DT(),
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DISC_AGE());
			if (returnValue != null && !returnValue.isEmpty()) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(Integer.parseInt(returnValue.get(0)));

			}
			if ("D".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POL_PLAN_TYPE(),"X"))) {
				list = procedures.callP_CALC_ANB(PT_IL_POLICY_BEAN.getPOL_START_DT(), 
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB(), "1");
				M_AGE = Double.parseDouble(list.get(0));
				if (M_AGE > PT_IL_POLICY_BEAN.getPOL_DEF_PERIOD_FM() && M_AGE < PT_IL_POLICY_BEAN.getPOL_DEF_PERIOD_TO()) {
					PT_IL_POLICY_BEAN.setPOL_DEF_IMM_FLAG("D");
				} else if (M_AGE > PT_IL_POLICY_BEAN.getPOL_WAQAF_PERIOD_FM() && M_AGE < PT_IL_POLICY_BEAN.getPOL_WAQAF_PERIOD_TO()) {
					PT_IL_POLICY_BEAN.setPOL_DEF_IMM_FLAG("W");
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014"));
				}
				DUMMY_BEAN.setUI_M_EXACT_AGE(M_AGE);
				list3 = procedures.callPKG_PILT002_IL_SUM_ASURED_CAL(
						null, CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()), 
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_END_CODE()),
						null,
						PT_IL_POLICY_BEAN.getPOL_END_TYPE(),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ORG_NO_OF_INST()),
						PT_IL_POLICY_BEAN.getPOL_SA_CURR_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_NO_OF_UNIT()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_NO_OF_INST()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ORG_FC_SUM_ASSURED()),
						PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_ORG_FC_MODAL_PREM()),
						null, null, null, null, null, null, null,
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_FC_MODAL_PREM()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_FC_BASIC_PREM()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_LC_BASIC_PREM()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED()), 
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_FC_CURR_SA()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_LC_CURR_SA()));
				if (list3 != null && !list1.isEmpty()) {
					if (list3.get(0) != null) {
						PT_IL_POLICY_BEAN.setPOL_FC_MODAL_PREM(Double.parseDouble(list3.get(0)));
					}if (list3.get(1) != null) {
						PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(Double.parseDouble(list3.get(1)));
					}if (list3.get(2) != null) {
						PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM(Double.parseDouble(list3.get(2)));
					}if (list3.get(3) != null) {
						PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(Double.parseDouble(list3.get(3)));
					}if (list3.get(4) != null) {
						PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(Double.parseDouble(list3.get(4)));
					}if (list3.get(5) != null) {
						PT_IL_POLICY_BEAN.setPOL_FC_CURR_SA(Double.parseDouble(list3.get(5)));
					}if (list3.get(6) != null) {
						PT_IL_POLICY_BEAN.setPOL_LC_CURR_SA(Double.parseDouble(list3.get(6)));
					}
				}

			}
			if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) == 0
					|| "013".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000"))) {
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_MAT_AGE(CommonUtils.nvl(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE(), 0)
						+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0));
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) > 0) {
					double M_SIPH_MAT_AGE = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE(), 0)
							+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0);
					String UPDATE_QUERY = "UPDATE PT_IL_POL_SA_INST_PYMT_HEAD SET  SIPH_MAT_AGE = ? WHERE SIPH_POL_SYS_ID = ? ";
					int returnvalu = handler.executeInsertStatement(UPDATE_QUERY, connection, 
							new Object[] {M_SIPH_MAT_AGE,PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				}
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
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(Double POAD_WEIGHT,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_WEIGHT_FM = 0.0d;
		Double M_HTWT_WEIGHT_TO = 0.0d;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();

		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID = ? "
				+ "AND ?  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO ";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM  PM_IL_HTWT_DTL"
				+ " WHERE  ?  BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM  PM_IL_PROP_TREATY WHERE ? BETWEEN PT_START_DT "
				+ "AND PT_END_DT AND PT_CLASS_CODE = ? ";

		try {
			connection = CommonUtils.getConnection();
			
			/*Commentted by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			/*if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null) {
				if (POAD_WEIGHT <= 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007",
							new Object[]{"Weight"}));
				}
			}*/
			
			/*End*/

			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null) {
				/*Commentted by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
				if (POAD_WEIGHT !=null && POAD_WEIGHT>0 ) {
				/*End*/
					//throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007"));


					if ("M".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())) {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0);
					} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())) {

					
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						
						/*commented by Janani on 02.06.2017  for ZBILQC-1721957
						 * 
						 * M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.01;*/
						   M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0);
						
						/*End*/
						
						
					} else {
						
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						
						
						/*M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.305;*/
						
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0);
						
						/*End*/
					}
					if ("K".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT())) {
						
						M_STD_WEIGHT = CommonUtils.nvl(POAD_WEIGHT, 0);
						
					} else {
						
						/*Added by Janani on 02.06.2017 for ZBILQC-1721957 */
						
						/*M_STD_WEIGHT = CommonUtils.nvl(POAD_WEIGHT, 0) * 0.454;*/
						
						M_STD_WEIGHT = CommonUtils.nvl(POAD_WEIGHT, 0);
						
						/*End*/
					}
					if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,connection, 
								new Object[] { DUMMY_BEAN.getUI_M_PT_SYS_ID(),M_STD_HEIGHT });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90009"));

						}

					} else if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 1) {
						resultSet = handler.executeSelectStatement(CURSOR_C2,connection,
								new Object[] {M_STD_HEIGHT });
						if (resultSet.next()) {
							M_HTWT_WEIGHT_FM = resultSet.getDouble(1);
							M_HTWT_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT >= M_HTWT_WEIGHT_FM && M_STD_WEIGHT <= M_HTWT_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath, "90009"));
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			/*Commentted by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT()>0 && POAD_WEIGHT != null && POAD_WEIGHT>0) {
			/*End*/
				list = procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),
						POAD_WEIGHT,
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI());
				if (list != null &&  !list.isEmpty()) {
					//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND((Double)list.get(0).getValueObject(),2));
					//added by saranya on 31-03-16 for BMI
					System.out.println("******POAD_WEIGHT_WHEN_VALIDATE_ITEM  Start *********");
					//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
					double value=(Double)list.get(0).getValueObject();
					double roundOff = Math.round(value * 100.0) / 100.0;
					System.out.println("reduced value is:"+roundOff);
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(roundOff);
					System.out.println("******POAD_WEIGHT_WHEN_VALIDATE_ITEM End *********");
					//end
				}

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
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(String POAD_WEIGHT_UNIT,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_WEIGHT_FM = null;
		Double M_HTWT_WEIGHT_TO = null;
		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;

		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID =  ? "
				+ "AND  ?  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL "
				+ "WHERE  ?  BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM   PM_IL_PROP_TREATY WHERE  ? BETWEEN PT_START_DT"
				+ " AND  PT_END_DT AND  PT_CLASS_CODE = ? ";

		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			/*Commentted by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			
			/*if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT()!= null && 
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() <= 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007",
							new Object[]{"Weight"}));
				}
			}*/
			
			/*End*/

			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),
					PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);

			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())) {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0);
					} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT())) {

						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.01;
					} else {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(), 0) * 0.305;
					}

					if ("K".equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT())) {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(), 0);
					} else {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(), 0) * 0.454;
					}
					if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,connection, 
								new Object[] { DUMMY_BEAN.getUI_M_PT_SYS_ID(),M_STD_HEIGHT });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));

						}

					} else if (DUMMY_BEAN.getUI_M_ILUWMEDHT() == 1) {
						resultSet = handler.executeSelectStatement(CURSOR_C2,connection,
								new Object[] {M_STD_HEIGHT });
						if (resultSet.next()) {
							M_HTWT_WEIGHT_FM = resultSet.getDouble(1);
							M_HTWT_WEIGHT_TO = resultSet.getDouble(2);
						}
						if(M_HTWT_WEIGHT_FM != null && M_HTWT_WEIGHT_TO!= null ){
							if (M_STD_WEIGHT > M_HTWT_WEIGHT_FM  && M_STD_WEIGHT < M_HTWT_WEIGHT_TO) {

							} else {
								throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));
							}
						}		

						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			
			/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT() >0 
					&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT()>0) {
			/*End*/	
				list = procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI());
				if (list != null &&  !list.isEmpty()) {
					if (list.get(0) != null) {
						//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(CommonUtils.ROUND(((Double)list.get(0).getValueObject()),2));
						//added by saranya on 31-03-16 for BMI
						System.out.println("******POAD_WEIGHT_UNIT_WHEN_VALIDATE_ITEM  Start *********");
						//PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
						double value=(Double)list.get(0).getValueObject();
						double roundOff = Math.round(value * 100.0) / 100.0;
						System.out.println("reduced value is:"+roundOff);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(roundOff);
						System.out.println("******POAD_WEIGHT_UNIT_WHEN_VALIDATE_ITEM End *********");
						//end		

					}
				}

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
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN) {

		if ("0".equalsIgnoreCase(PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE_PROOF_FLAG())) {
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setDisabled(false);
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setRequired(true);

			System.out.println("Hello ------>"+"---->akash");

		} else {
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setValue("");
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setSubmittedValue("");
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE_PROOF_OTHERS("");
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setDisabled(true);
		
			/*Added by Janani on 16.05.2017 for SSP call ID ZBILQC-1724084*/
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setRequired(false);
			/*End*/
		
		
		}
	}

	public void POAD_SMOKE_YN_WHEN_LIST_CHANGED(String POAD_SMOKE_YN,
			PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN) {
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = PT_IL_POL_ASSURED_DTLS_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		if ("Y".equals(POAD_SMOKE_YN)) {
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(1);

		} else {
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NO_OF_CIGAR(0);
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
		}

	}

	public void POAD_OCC_CODE_WHEN_VALIDATE_ITEM(String POAD_OCC_CODE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		try {
			if (POAD_OCC_CODE != null) {
				list = procedures.P_DISP_OCCU_CLASS("R", POAD_OCC_CODE,
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_OCC_DESC(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CLASS(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_OCC_CLASS_DESC());
				if (list != null && !list.isEmpty()) {
					if (list.get(1).getValueObject() != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_DESC((String)list.get(1).getValueObject());
					}
					int assrd_occ = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_ASSR_OCCL")).intValue();
					if(assrd_occ == 1){
						if (list.get(2).getValueObject() != null) {
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CLASS((String)list.get(2).getValueObject());
						}if (list.get(3).getValueObject() != null) {
							PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_CLASS_DESC((String)list.get(3).getValueObject());
						}
					}
				}


			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(String POAD_OCC_CLASS,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (POAD_OCC_CLASS != null) {
				list = procedures.P_VAL_CODES(
						"IL_OCC_CLASS",
						POAD_OCC_CLASS,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_OCC_CLASS_DESC()),
						"N", "E", null);

				if (list != null &&  !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list.get(0));
					}
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

	public void POAD_OCC_RATE_VALIDATE_ITEM(Double POAD_OCC_RATE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CLASS() != null) {
				list = procedures.P_VAL_CODES(
						"IL_OCC_CLASS",
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CLASS(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_OCC_CLASS_DESC(),
						"N", "E", null);
				if (list != null &&  !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list.get(0));
					}
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

	public void POAD_RELIGION_CODE_VALIDATE_ITEM(String POAD_RELIGION_CODE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (POAD_RELIGION_CODE != null) {
				list = procedures.P_VAL_CODES("RELIGION",
						POAD_RELIGION_CODE,
						PT_IL_POL_ASSURED_DTLS_BEAN
						.getUI_M_POAD_REL_CODE_DESC(), "N", "E", null);
				if (list != null &&  !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_REL_CODE_DESC(list.get(0));
					}
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

	public void POAD_HEALTH_CODE_VALIDATE_ITEM(String POAD_HEALTH_CODE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (POAD_HEALTH_CODE != null) {
				list = procedures.P_VAL_CODES(
						"IL_HLTH_ST",
						POAD_HEALTH_CODE,
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_HEALTH_DESC(),
						"N", "E", null);
				if (list != null &&  !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_HEALTH_DESC(list.get(0));
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public Double POAD_FC_SALARY_VALIDATE_ITEM(Double POAD_FC_SALARY,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			list = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_SA_CURR_CODE(), 
					CommonUtils.getProcedureValue(POAD_FC_SALARY),"V",
					PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list !=  null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_FC_SALARY = Double.parseDouble(list.get(0));
				}
			}
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(POAD_FC_SALARY* PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE());
			list1 = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_LC_SALARY()),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 !=  null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(Double.parseDouble(list1.get(0)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_FC_SALARY;
	}

	public Double POAD_LC_SALARY_VALIDATE_ITEM(Double POAD_LC_SALARY,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();

		ArrayList<String> list1 = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(POAD_LC_SALARY),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_LC_SALARY = Double.parseDouble(list1.get(0));
				}
			}
			lifelib.callP_VAL_FC_LC_TOLERANCE(
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SALARY()),
					CommonUtils.getProcedureValue(POAD_LC_SALARY),
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE()), "E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_SALARY;
	}

	public Double POAD_FC_AMAN_PREM_VALIDATE_ITEM(Double POAD_FC_AMAN_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN
							.getPOL_CUST_CURR_CODE()),
							CommonUtils.getProcedureValue(POAD_FC_AMAN_PREM),
							"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null &&  !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_FC_AMAN_PREM = Double.parseDouble(list1.get(0));
				}
			}

			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_PREM(POAD_FC_AMAN_PREM * PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_LC_AMAN_PREM()),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null &&  !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_PREM(Double.parseDouble(list.get(0)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_FC_AMAN_PREM;
	}

	public Double POAD_LC_AMAN_PREM_VALIDATE_ITEM(Double POAD_LC_AMAN_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_AMAN_PREM()),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null &&  !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_AMAN_PREM(Double.parseDouble(list1.get(0)));
				}
			}

			POAD_LC_AMAN_PREM = POAD_LC_AMAN_PREM * PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(POAD_LC_AMAN_PREM),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null &&  !list.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_LC_AMAN_PREM = Double.parseDouble(list.get(0));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_AMAN_PREM;

	}

	public Double POAD_FC_AMAN_LOAD_PREM_VALIDATE_ITEM(
			Double POAD_FC_AMAN_LOAD_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(POAD_FC_AMAN_LOAD_PREM),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null &&  !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_FC_AMAN_LOAD_PREM = Double.parseDouble(list1.get(0));
				}
			}


			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_PREM(PT_IL_POL_ASSURED_DTLS_BEAN
					.getPOAD_LC_AMAN_PREM()* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_LC_AMAN_PREM()),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null &&  !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_PREM(Double.parseDouble(list.get(0)));
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_FC_AMAN_LOAD_PREM;

	}

	public Double POAD_LC_AMAN_LOAD_PREM_VALIDATE_ITEM(
			Double POAD_LC_AMAN_LOAD_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(POAD_LC_AMAN_LOAD_PREM),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null &&  !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_AMAN_LOAD_PREM(Double.parseDouble(list1.get(0)));
				}
			}
			POAD_LC_AMAN_LOAD_PREM = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_AMAN_LOAD_PREM()* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_AMAN_LOAD_PREM()),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_AMAN_LOAD_PREM = Double.parseDouble(list.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_LC_AMAN_LOAD_PREM;
	}

	public Double POAD_FC_SENABEL_PREM_VALIDATE_ITEM(
			Double POAD_FC_SENABEL_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(POAD_FC_SENABEL_PREM),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_FC_SENABEL_PREM = Double.parseDouble(list1.get(0));
				}
			}

			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_LOAD_PREM(POAD_FC_SENABEL_PREM * PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_LC_AMAN_LOAD_PREM()),
					"R",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_AMAN_LOAD_PREM(Double.parseDouble(list.get(0)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_FC_SENABEL_PREM;

	}

	public Double POAD_LC_SENABEL_PREM_VALIDATE_ITEM(
			Double POAD_LC_SENABEL_PREM,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN)
					throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {
			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SENABEL_PREM()),
					"V",PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SENABEL_PREM(Double.parseDouble(list1.get(0)));
				}
			}
			POAD_LC_SENABEL_PREM = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FC_SENABEL_PREM()* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();
			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(POAD_LC_SENABEL_PREM),"R",
					PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_SENABEL_PREM = Double.parseDouble(list.get(0));
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_SENABEL_PREM;
	}

	public void POAD_RACE_VALIDATE_ITEM(String POAD_RACE,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list1 = null;

		try {
			if (POAD_RACE != null) {
				list1 = procedures.P_VAL_CODES(
						"RACE",POAD_RACE,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_RACE_CODE_DESC()),
						"N", "E", null);
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_RACE_CODE_DESC(list1.get(0));
					}
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

	public void POAD_REMARKS_KEY_NEXT_ITEM(String POAD_REMARKS,
			PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN) throws Exception {

		String M_DUMMY = null;
		String CURSOR_C1 = "SELECT 'X' FROM PM_IL_DOC_MED_HIST WHERE DMH_DS_TYPE = ? AND DMH_DS_CODE = ?"
				+ "  AND  DMH_APPL_ON IN ('R','B') AND ROWNUM  <=20 ";
		CommonUtils.setGlobalVariable("GLOBAL.M_BLOCK", "1");
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
					PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
			PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_UI_M_BUT_FLEX_FIELDS()
			.setRendered(false);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);

				PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_UI_M_BUT_FLEX_FIELDS()
				.setRendered(true);
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000") != "002"
						|| "A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
								.getPOL_APPRV_STATUS(), "N"))) {
					// GO_ITEM('PT_IL_POL_ASSURED_DTLS.M_BUT_FLEX_FIELDS');

				} else if ("002".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
						.getPOL_END_TYPE(), "000"))
						|| "A" != CommonUtils.nvl(PT_IL_POLICY_BEAN
								.getPOL_APPRV_STATUS(), "N")) {
					// GO_ITEM('PT_IL_POL_ADDL_COVER.POAC_COVER_CODE');
				} else {
					PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.getCOMP_UI_M_BUT_FLEX_FIELDS()
					.setRendered(false);
				}
				// GO_ITEM('PT_IL_POL_ADDL_COVER.POAC_COVER_CODE');

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}



	public void POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(String POAD_MAR_STATUS,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
					throws Exception {

		Double M_VALUE = null;
		ArrayList<String> list = null;
		try {
			if (POAD_MAR_STATUS != null) {
				list = DBProcedures.P_VAL_SYSTEM(
						"MARI_STAT",
						POAD_MAR_STATUS,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_MS_DESC()),
						"E", 
						CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty() ) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_MS_DESC(list.get(0));
					}
				}

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public Double L_GET_THRESHOLD_LIMIT(PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN,DUMMY DUMMY_BEAN) throws Exception{




		Double  M_VALUE = null;	
		Double M_PS_VALUE = null;
		String M_CODE_DESC = null;
		ArrayList<String> list = new ArrayList<String>();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;

		String CURSOR_C1 = "SELECT SUM(NVL(POL_LC_SUM_ASSURED,0)+ NVL(POL_ORG_LC_SUM_ASSURED,0)) SUM_ASSURED FROM   PT_IL_POLICY A WHERE  " +
				" EXISTS (SELECT POAD_POL_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE (POAD_REF_ID1 = ?  OR  POAD_REF_ID2 = ?) " +
				" AND  POAD_POL_SYS_ID = A.POL_SYS_ID) AND ((POL_DS_TYPE = '1' AND POL_PROP_QUOT_FLAG = 'P' AND POL_STATUS NOT IN ('C') " +
				" AND NOT EXISTS (SELECT POL_PROP_NO FROM PT_IL_POLICY B WHERE  POL_DS_TYPE = '2' AND B.POL_PROP_SYS_ID = A.POL_SYS_ID " +
				"  AND  B.POL_PROP_NO = A.POL_NO)) OR (POL_DS_TYPE = '2'  AND POL_STATUS NOT IN ('C')))";

		String CURSOR_C2 = "SELECT SUM(NVL(POL_LC_SUM_ASSURED,0)+ NVL(POL_ORG_LC_SUM_ASSURED,0)) SUM_ASSURED FROM   PT_IL_POLICY A WHERE  EXISTS (SELECT POAD_POL_SYS_ID " +
				" FROM  PT_IL_POL_ASSURED_DTLS WHERE  POAD_ASSR_CODE  = ?  AND    POAD_POL_SYS_ID = A.POL_SYS_ID) AND   ((A.POL_DS_TYPE ='1'" +
				"  AND  POL_PROP_QUOT_FLAG = 'P' AND POL_STATUS NOT IN ('C') AND   NOT EXISTS(SELECT B.POL_PROP_NO FROM   PT_IL_POLICY B " +
				" WHERE  B.POL_DS_TYPE = '2' AND    B.POL_PROP_SYS_ID = A.POL_SYS_ID AND B.POL_PROP_NO = A.POL_NO) OR   (A.POL_DS_TYPE = '2'" +
				" AND  EXISTS (SELECT POAD_POL_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE  (POAD_REF_ID1 = ? OR  POAD_REF_ID2    = ? )" +
				" AND  POAD_POL_SYS_ID = A.POL_SYS_ID) AND    A.POL_STATUS NOT IN ('C')))) ";


		try {
			list = DBProcedures.P_VAL_SYSTEM("IL_CUM_SA_YN",
					"IL_CUM_SA_YN",
					M_CODE_DESC,"E",
					CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list != null && !list.isEmpty()) {
				if (list.get(0)!= null) {
					M_CODE_DESC = list.get(0); 
				}if (list.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list.get(1));
				}
			}

			//IL_CALC_MTHD commented by akash to make normal flow to work with takaful way.

			connection = CommonUtils.getConnection();
			if (M_PS_VALUE == 2) {
				if (/* 1==DUMMY_BEAN.getUI_M_CALC_METHOD()*/DUMMY_BEAN.getUI_M_CALC_METHOD()!=null ) {
					resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
							new Object[]{PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_REF_ID1(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_REF_ID2()});
					if (resultSet.next()) {
						M_VALUE = resultSet.getDouble(1);

					}
					CommonUtils.closeCursor(resultSet);
				} /*else {
						resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
								new Object[]{PT_IL_POLICY_BEAN.getPOL_CONT_CODE(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_REF_ID1(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_REF_ID2()} );
						if (resultSet.next()) {
							M_VALUE = resultSet.getDouble(1);

						}
						CommonUtils.closeCursor(resultSet);
					}*/
			} else {
				M_VALUE = PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED();
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

		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return M_VALUE;

	}

	public void POAD_NATIONALITY_WHEN_VALIDATE_ITEM(String POAD_NATIONALITY,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN) throws Exception {

		ArrayList<String> list = new  ArrayList<String>();
		DBProcedures procedures = new DBProcedures();
		try {
			if (POAD_NATIONALITY !=  null) {
				list =  procedures.P_VAL_CODES("NATLITY",POAD_NATIONALITY,
						PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_NATLITY_DESC(),
						"N","E",null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(list.get(0));
					}
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

	public void forCopiedPolicy(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN) {

		String C1 = " UPDATE PT_IL_POL_ASSURED_DTLS SET  POAD_ASSR_CODE=?, POAD_ASSURED_NAME=? WHERE POAD_POL_SYS_ID=? ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();

			int result= handler.executeUpdateStatement(C1, connection,
					new Object[]{PT_IL_POLICY_BEAN.getPOL_CONT_CODE(),
					PT_IL_POLICY_BEAN.getPOL_ASSURED_NAME(),PT_IL_POLICY_BEAN.getPOL_SYS_ID()});

			if(result >0){
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSR_CODE( PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSURED_NAME(PT_IL_POLICY_BEAN.getPOL_ASSURED_NAME());
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	public void POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_OWNER_YN().equalsIgnoreCase(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_OWNER_YN())){
			throw new Exception("Either Payor or Payee should be the Policy Owner");
		}
	}

	public void checktakaful(PILT002_APAC_COMPOSITE_ACTION compositeAction){
		String C1 = " SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE LIKE 'IL_CALC_MTHD'";
		String C2="SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Integer M_VALUE = null;	

		String M_PROD = null;


		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet1=handler.executeSelectStatement(C1, connection);
			if(resultSet1.next()){
				M_VALUE=resultSet1.getInt(1);

			}
			resultSet2=handler.executeSelectStatement(C2, connection, new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()})	;	
			if(resultSet2.next()){
				M_PROD=resultSet2.getString(1);

			}
			if((1==M_VALUE)&& "Y".equalsIgnoreCase(M_PROD)){
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CODE().setRequired(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CLASS().setRequired(true);

			}else {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CODE().setRequired(true);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_OCC_CLASS().setRequired(true);


			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public void discAgeCodeCheck(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		String M_COVER_DISC_AGE = null;
		String C1 = "SELECT COVER_DISC_AGE_YN FROM PM_IL_COVER WHERE COVER_CODE=?";
		try {
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE() });
			if (resultSet1.next()) {
				M_COVER_DISC_AGE = resultSet1.getString(1);
			}
			if ("Y".equalsIgnoreCase(M_COVER_DISC_AGE)) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getCOMP_POAD_ADDL_RISK_CODE().setDisabled(false);
			} else {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getCOMP_POAD_ADDL_RISK_CODE().setDisabled(true);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	public void autoUnderwritingValidate(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		String M_AUTO_UW = null;
		String C1 = "SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT WHERE PROD_CODE= (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?)";
		try {
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			if (resultSet1.next()) {
				M_AUTO_UW = resultSet1.getString(1);
			}
			if ("Y".equalsIgnoreCase(M_AUTO_UW)) {
				/*
				 * COMMENTED BY AMEEN FOR kic AS PER SIVA SUGG
				 * pkg_pilt002_apac.L_UPDATE_JE_STATUS(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_SYS_ID());*/
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} /*catch (ProcedureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}*/
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	public void setassured(PILT002_APAC_COMPOSITE_ACTION compositeAction){

		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_BEAN
		.setPOAD_ASSR_CODE(PT_IL_POLICY_BEAN
				.getPOL_CONT_CODE());
		PT_IL_POL_ASSURED_DTLS_BEAN
		.setPOAD_ASSURED_NAME(PT_IL_POLICY_BEAN
				.getPOL_ASSURED_NAME());
	}

	/*Added by ganesh on 07-06-2017 as suggested by Kuzhandhaivel */
	public void postUpdate(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	
		try {
			
			System.out.println("ASSURED DETAILS CALLING P9ILPK_POLICY.P_INS_DISC_LOAD");
		
			
			/*Modified by Janani on 12.09.2017 for ZBILQC-1736141*/
			
			/*if ((!("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N")))
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),0) == 0)
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q")))*/ 
			
			System.out.println("getPOL_APPRV_STATUS              "+PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS());
			System.out.println("getPOL_END_TYPE              	 "+PT_IL_POLICY_BEAN.getPOL_END_TYPE());
			System.out.println("getPOL_END_CODE             	 "+PT_IL_POLICY_BEAN.getPOL_END_CODE());
			
			if ((!("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N")))
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),0) == 0)
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q")) ||
					
					(("N".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))) 
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"0").equalsIgnoreCase("015")) 
					&& (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_CODE(),"0").equalsIgnoreCase( "COCCP")))
					)
			
			/*End of ZBILQC-1736141*/	
				
			{
				p9ilpk_policy.P_INS_DISC_LOAD(
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_START_DT()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	/*end*/
	
	
	/*Added by Janani on 01.06.2018 for Fidelity Family history and occ hist*/
	public void POAD_FAMILY_YN_FLAG_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
					throws Exception {

		String POAD_FAMILY_YN_FLAG = (String) currValue;
		try {
			if(("Y".equalsIgnoreCase(POAD_FAMILY_YN_FLAG))){
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().
				getCOMP_POAD_FAMILY_YN_BUT().setDisabled(false);

			}else{

				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().
				getCOMP_POAD_FAMILY_YN_BUT().setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	public void POAD_OCC_YN_FLAG_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
					throws Exception {

		String POAD_OCC_YN_FLAG = (String) currValue;
		try {
			if(("Y".equalsIgnoreCase(POAD_OCC_YN_FLAG))){
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().
				getCOMP_POAD_OCC_YN_BUT().setDisabled(false);

			}else{

				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().
				getCOMP_POAD_OCC_YN_BUT().setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	/*end*/
	/*Newly Added by pidugu raj dt: 24-08-2018 for KICLIFEQC-1762429*/
	public PT_IL_POL_CUST_DTLS doInsertAlternateCustomerDetails(Long pol_SYS_ID,
			PT_IL_POL_CUST_DTLS polCustDetails) {
		Connection  connectionNew1= null;
		Connection connectionNew2 = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS  = new PT_IL_POL_CUST_DTLS();
		//String CURSOR_C1 = "INSERT INTO PT_IL_POL_CUST_DTLS where PCD_POL_SYS_ID=? and PCD_CUST_NAME=? and PCD_RELATION_TYPE=? and PCD_DOB=?";
		String SYS_ID_GENERATE_QUERY = " SELECT PIL_POAD_SYS_ID.NEXTVAL FROM DUAL";

		String CURSOR_C1 = "INSERT INTO PT_IL_POL_CUST_DTLS"
				+ "(PCD_POL_SYS_ID, PCD_CUST_NAME,PCD_RELATION_TYPE,PCD_DOB,PCD_CIVIL_ID,PCD_SYS_ID)"
				+ " VALUES(?,?,?,?,?,?)";
		
		try{
			connectionNew1 = CommonUtils.getConnection();
			connectionNew2 = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SYS_ID_GENERATE_QUERY,
					connectionNew1);
			if (resultSet.next()) {
				
			Long seq_id = Long.valueOf(resultSet.getInt(1));
			Object[] values = {};
			values = new Object[] {pol_SYS_ID,polCustDetails.getPCD_CUST_NAME(),polCustDetails.getPCD_RELATION_TYPE(),polCustDetails.getPCD_DOB(),polCustDetails.getPCD_CIVIL_ID(),seq_id};
			handler.executeInsertStatement(CURSOR_C1, connectionNew2, values);
			connectionNew2.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pT_IL_POL_CUST_DTLS;
		
	}

	public PT_IL_POL_CUST_DTLS doGetPolCustDetails(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		Connection connection2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS  = new PT_IL_POL_CUST_DTLS();
		String  CURSOR_C1 = "select PCD_POL_SYS_ID,PCD_CIVIL_ID, PCD_CUST_NAME,PCD_RELATION_TYPE,PCD_DOB,PCD_SYS_ID from PT_IL_POL_CUST_DTLS WHERE PCD_POL_SYS_ID = ?";
		String Cursor_C2 = "SELECT pc_short_desc FROM PM_CODES WHERE PC_TYPE=? and pc_code=?";
		try{
			connection = CommonUtils.getConnection();
			connection2 = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(CURSOR_C1, connection, new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			
			String relationType = null;
			String pc_type = "IL_PAR_MEMB";
			if(resultSet1.next()){
				pT_IL_POL_CUST_DTLS.setPCD_POL_SYS_ID(resultSet1.getInt(1));
				pT_IL_POL_CUST_DTLS.setPCD_CIVIL_ID(resultSet1.getString(2));
				pT_IL_POL_CUST_DTLS.setPCD_CUST_NAME(resultSet1.getString(3));
				pT_IL_POL_CUST_DTLS.setPCD_RELATION_TYPE(resultSet1.getString(4));
				pT_IL_POL_CUST_DTLS.setPCD_DOB(resultSet1.getDate(5));
				pT_IL_POL_CUST_DTLS.setPCD_SYS_ID((resultSet1.getInt(6)));
				relationType = resultSet1.getString(4);
			}
			if(relationType != null){
			resultSet2 = handler.executeSelectStatement(Cursor_C2, connection2, new Object[] {pc_type,relationType});
			if(resultSet2.next()){
				pT_IL_POL_CUST_DTLS.setUI_M_PFMD_RELATION_DESC(resultSet2.getString(1));
			}
			}
			connection.commit();
			CommonUtils.closeCursor(resultSet1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pT_IL_POL_CUST_DTLS;
	}

	public PT_IL_POL_CUST_DTLS doUpdateAlternateCustomerDetails(
			Long pol_SYS_ID, PT_IL_POL_CUST_DTLS polCustDetails) {
		Connection  connectionNew= null;
		
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS  = new PT_IL_POL_CUST_DTLS();
		String Cursor = "UPDATE PT_IL_POL_CUST_DTLS SET PCD_POL_SYS_ID = ?, PCD_CUST_NAME = ?,PCD_RELATION_TYPE = ?, PCD_DOB = ?, PCD_CIVIL_ID = ? where PCD_SYS_ID = ?";
		try{
			connectionNew = CommonUtils.getConnection();
			Object[] values = {};
			values = new Object[] {pol_SYS_ID,polCustDetails.getPCD_CUST_NAME(),polCustDetails.getPCD_RELATION_TYPE(),polCustDetails.getPCD_DOB(),polCustDetails.getPCD_CIVIL_ID(),polCustDetails.getPCD_SYS_ID()};
			handler.executeInsertStatement(Cursor, connectionNew, values);
			connectionNew.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return pT_IL_POL_CUST_DTLS;
		
	}
	/*End added by pidugu raj dt: 24-08-2018 for kic*/
	/*Added by pidgugu raj dt: 27-08-2018 for KICLIFEQC-1762429*/
	public ArrayList<LovBean> doGetLovDetails() {
Connection  connectionNew= null;
	ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<LovBean> lovBeanList  = new ArrayList<LovBean>();
		LovBean lovBean  =new LovBean();
		String Cursor = "SELECT PC_CODE, PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE =? ";
		try{
			connectionNew = CommonUtils.getConnection();
			Object[] values = {};
			String parameter = "IL_ALT_CUST";
			values = new Object[] {parameter};
			resultSet1 = handler.executeSelectStatement(Cursor, connectionNew, values);
			while(resultSet1.next()){
				lovBean.setLovCode(resultSet1.getString(1));
				lovBean.setLovName(resultSet1.getString(2));
				lovBeanList.add(lovBean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return lovBeanList;
	}
	/*End added by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762429*/
}



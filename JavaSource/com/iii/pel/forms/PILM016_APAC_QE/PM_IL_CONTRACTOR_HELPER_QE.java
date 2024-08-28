package com.iii.pel.forms.PILM016_APAC_QE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.org.w3c.tidy.AttrCheckImpl.CheckNumber;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM016_APAC.P_VAL_CODES;
import com.iii.pel.forms.PILM016_APAC.P_VAL_SYSTEM;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class PM_IL_CONTRACTOR_HELPER_QE {

	
	
	public void pre_insert(PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN)
			throws Exception {

		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			connection = CommonUtils.getConnection();
			String M_CODE_DESC = null;
			Integer M_IND_REQ = -1;
			ArrayList indReqList = P_VAL_SYSTEM
					.P_VAL_SYSTEM(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_CST_INDREQ,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_CST_INDREQ,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);

			M_CODE_DESC = indReqList.get(0).toString();
			M_IND_REQ = Integer.parseInt(indReqList.get(1).toString());

			if (M_IND_REQ == 1) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null
						&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91152"));
				}
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_ACC_NO() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91375"));
				}
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_CONTRACTOR_BEAN.setCONT_CR_DT(commonUtils.getCurrentDate());
			PM_IL_CONTRACTOR_BEAN
					.setCONT_DFLT_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);
			PM_IL_CONTRACTOR_BEAN
					.setCONT_FRZ_FLAG(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);
			if (PM_IL_CONTRACTOR_BEAN.getCONT_CODE() != null) {
				uniqueCode(PM_IL_CONTRACTOR_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void uniqueCode(PM_IL_CONTRACTOR_QE contractorBean) throws Exception {
		boolean flag = false;
		ResultSet resultSet = null;
		try {

			Connection connection = CommonUtils.getConnection();
			CRUDHandler dbHandler = new CRUDHandler();
			String selectQuery = "SELECT 'X',ROWID FROM  PM_IL_CONTRACTOR  WHERE  CONT_CODE  =  ? ";
			resultSet = dbHandler.executeSelectStatement(selectQuery,
					connection, new Object[] { contractorBean.getCONT_CODE() });
			if (resultSet.next()) {
				if (contractorBean.getROWID() == null) {
					if (resultSet.getString("ROWID") != null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71026"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void pre_update(PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN)
			throws Exception {
		try {
			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_ACC_NO() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91375"));
				}
			}
			PM_IL_CONTRACTOR_BEAN.setCONT_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_CONTRACTOR_BEAN.setCONT_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_CONTRACTOR_BEAN
					.setCONT_DFLT_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);
			PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG("N");
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String P_CREATE_NUMBER(
			PM_IL_CONTRACTOR_ACTION_QE PM_IL_CONTRACTOR_ACTION_QE_BEAN)
			throws ValidatorException {

		PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_ACTION_QE_BEAN
				.getPM_IL_CONTRACTOR_QE_BEAN();
		ResultSet resultSetPSVALUE = null;
		ResultSet resultSetPSCODE = null;
		ResultSet resultSetNGSYN = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_PS_CODE = null;
		String M_TITLE = null;
		String M_FILE = null;
		String M_CODE_DESC = null;
		int M_PS_VALUE = -1;
		String M_TEMP = null;
		String M_NGS_DISABLE_YN = null;
		String CURSOR_C1 = "SELECT PS_VALUE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'NUM_GEN_YN'  AND PS_CODE  = 'CONTRACTOR' ";
		String cursor_c2 = "SELECT PS_CODE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_CONT_NUM' ";
		String cursor_c3 = "SELECT    'X',NGS_DISABLE_YN FROM  PM_NUMBER_GEN_SETUP  WHERE  NGS_CODE  = ? ";

		try {
			String divnCode = CommonUtils.getControlBean().getM_DIVN_CODE();
			connection = CommonUtils.getConnection();

			resultSetPSVALUE = handler.executeSelectStatement(CURSOR_C1,
					connection);
			if (resultSetPSVALUE.next()) {
				M_PS_VALUE = Integer.parseInt(resultSetPSVALUE.getString(1));
			}
			resultSetPSVALUE.close();

			if (CommonUtils.nvl(M_PS_VALUE, 2) != 1) {
				PM_IL_CONTRACTOR_ACTION_QE_BEAN.getCOMP_CONT_CODE()
						.setDisabled(false);
				PM_IL_CONTRACTOR_ACTION_QE_BEAN.getCOMP_CONT_CODE()
						.setRequired(true);
			} else {
				resultSetPSCODE = handler.executeSelectStatement(cursor_c2,
						connection);
				if (resultSetPSCODE.next()) {
					M_PS_CODE = resultSetPSCODE.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91176"));
				}
				resultSetNGSYN = handler.executeSelectStatement(cursor_c3,
						connection, new Object[] { M_PS_CODE });
				if (resultSetNGSYN.next()) {
					M_TEMP = resultSetNGSYN.getString(1);
					M_NGS_DISABLE_YN = resultSetNGSYN.getString(2);
				}
				resultSetNGSYN.close();

				if (!"X".equalsIgnoreCase(M_TEMP)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91177"));
				} else if (CommonUtils.nvl(M_NGS_DISABLE_YN, "N")
						.equalsIgnoreCase("N")) {
					PM_IL_CONTRACTOR_ACTION_QE_BEAN.getCOMP_CONT_CODE()
							.setDisabled(false);
					PM_IL_CONTRACTOR_BEAN.setCONT_CODE(P_GEN_AUTO_NO(M_PS_CODE,
							"N"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public String P_GEN_AUTO_NO(String P_CCLAS_CODE, String P_DUMMY_YN)
			throws Exception {
		String P_CUST_CODE = null;
		ResultSet resultSetNGSValues = null;
		ResultSet resultSetNGSCURRNO = null;
		int rowCount = -1;
		Connection connection = null;
		String M_NGS_CODE = null;
		String M_NGS_PREFIX_YN = null;
		String M_NGS_PREFIX = null;
		String M_NGS_SUFFIX_YN = null;
		String /** METADATA NOT FOUND ******** */
		M_NGS_SUFFIX = null;
		String /** METADATA NOT FOUND ******** */
		M_NGS_PAD_YN = null;
		Integer M_NGS_PAD_LENGTH = null;
		String /** METADATA NOT FOUND ******** */
		M_NGS_CHK_DIGIT_YN = null;
		
		Long M_NGS_FIRST_NO = null;
		
		Long M_NGS_CURR_NO = null;
		
		Long M_NGS_LAST_NO = null;
		String /** METADATA NOT FOUND ******** */
		M_NGS_DISABLE_YN = null;
		double M_SEQ_CHK = -1;
		String CURSOR_C1 = PM_IL_CONTRACTOR_SQL_CONSTANTS_QE.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_SELECT_NGS_VALUES;
		String CURSOR_C2 = PM_IL_CONTRACTOR_SQL_CONSTANTS_QE.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_SELECT_NGS_CURRNO;

		try {
			connection = CommonUtils.getConnection();

			resultSetNGSValues = new CRUDHandler().executeSelectStatement(
					CURSOR_C1, CommonUtils.getConnection(),
					new Object[] { P_CCLAS_CODE });
			if (resultSetNGSValues.next()) {
				M_NGS_CODE = resultSetNGSValues.getString(1);
				M_NGS_PREFIX_YN = resultSetNGSValues.getString(2);
				M_NGS_PREFIX = resultSetNGSValues.getString(3);
				M_NGS_SUFFIX_YN = resultSetNGSValues.getString(4);
				M_NGS_SUFFIX = resultSetNGSValues.getString(5);
				M_NGS_PAD_YN = resultSetNGSValues.getString(6);
				M_NGS_PAD_LENGTH = resultSetNGSValues.getInt(7);
				M_NGS_CHK_DIGIT_YN = resultSetNGSValues.getString(8);
				M_NGS_FIRST_NO = resultSetNGSValues.getLong(9);
				M_NGS_CURR_NO = resultSetNGSValues.getLong(10);
				M_NGS_LAST_NO = resultSetNGSValues.getLong(11);
				M_NGS_DISABLE_YN = resultSetNGSValues.getString(12);
			}
			if (resultSetNGSValues.isAfterLast()
					|| resultSetNGSValues.isBeforeFirst()) {
				return P_CUST_CODE;
			}
			resultSetNGSValues.close();

			if (MigratingFunctions.nvl(M_NGS_PREFIX_YN, "N").equalsIgnoreCase(
					"Y")) {
				P_CUST_CODE = M_NGS_PREFIX;
			} else {
				P_CUST_CODE = null;
			}

			resultSetNGSCURRNO = new CRUDHandler().executeSelectStatement(
					CURSOR_C2, CommonUtils.getConnection(),
					new Object[] { P_CCLAS_CODE });
			if (resultSetNGSCURRNO.next()) {
				M_NGS_CURR_NO = resultSetNGSCURRNO.getLong(1);
			}
			resultSetNGSCURRNO.close();

			if (MigratingFunctions.nvl(M_NGS_PAD_YN, "N").equalsIgnoreCase("Y")) {
				P_CUST_CODE = P_CUST_CODE
						+ StringFunctions.lPad(M_NGS_CURR_NO.toString(),
								M_NGS_PAD_LENGTH, "0");
			} else {
				P_CUST_CODE = P_CUST_CODE + M_NGS_CURR_NO;
			}

			if (MigratingFunctions.nvl(M_NGS_CHK_DIGIT_YN, "N")
					.equalsIgnoreCase("Y")) {
				ArrayList seqChkList = P9ILPR_GEN_CHECK_DIGIT(
						connection, P_CUST_CODE, M_SEQ_CHK);
				M_SEQ_CHK = Double.parseDouble(seqChkList.get(1).toString());
				P_CUST_CODE = P_CUST_CODE + M_SEQ_CHK;
			}

			if (MigratingFunctions.nvl(M_NGS_SUFFIX_YN, "N").equalsIgnoreCase(
					"Y")) {
				P_CUST_CODE = P_CUST_CODE + M_NGS_SUFFIX;
			}

			if (P_DUMMY_YN.equals("N")) {
				String CURSOR_C3 = PM_IL_CONTRACTOR_SQL_CONSTANTS_QE.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_UPDATE_PM_NOGENSETUP;
				rowCount = new CRUDHandler().executeUpdateStatement(CURSOR_C3,
						CommonUtils.getConnection(), new Object[] {
								M_NGS_CURR_NO + 1, M_NGS_CODE });
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return P_CUST_CODE;
	}
	
	public void pilm_apac_pm_il_contractor_cont_ref_id1_when_validate_item(PM_IL_CONTRACTOR_ACTION_QE PM_IL_CONTRACTOR_ACTION_QE_BEAN)throws Exception {
		
		PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_ACTION_QE_BEAN.getPM_IL_CONTRACTOR_QE_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String refId1= PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1();
		String sqlQuery1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_QUERY_REFID1_DETAIL;
		ResultSet resultset1 = null;
		String M_DUMMY = null;
		String M_DATE_CHAR = null;
		Long M_GENDER = null; 
		String M_VALUE = null;
		String M_CONT_NAME = null;
		String M_CONT_ADDR1 = null;
		String M_CONT_ADDR2 = null;
		String M_CONT_ADDR3 = null;
		String M_CONT_CONTACT = null;
		String M_CONT_REF_NO = null;
		String M_CONT_REF_ID1 = null;
		String M_CONT_REF_ID2 = null;
		String M_CONT_MOBILE_NO = null;
		String M_CONT_EMAIL_ID = null;
		String M_CONT_FRZ_FLAG = null;
		String M_CONT_POSTAL_CODE = null;
		Date M_CONT_DOB = null ;
		String M_CONT_CATG_CODE = null;
		String M_PS_VALUE_1 = null;
		String M_CODE_DESC = null;
		String M_CODE_DESC_1 = null;
		double M_LENGTH_1 = -1;
		double M_NEW_IC_NO_LENGTH = -1;
		double M_REF_ID_1_LENGTH = PM_IL_CONTRACTOR_ACTION_QE_BEAN.getCOMP_CONT_REF_ID1().getMaxlength();
		try{
			connection = CommonUtils.getConnection();	
		if(!refId1.isEmpty()){
			PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(refId1);
			Object[] object1 = { refId1 };
			if (refId1.length() > 1) {
				if (PM_IL_CONTRACTOR_BEAN.getROWID() == null) {
					if (resultset1 != null) {
						resultset1.close();
					}
					resultset1 = handler.executeSelectStatement(sqlQuery1,
							connection, object1);
					if (resultset1.next()) {
						M_DUMMY = resultset1.getString(1);
						M_CONT_NAME = resultset1.getString(2);
						M_CONT_ADDR1 = resultset1.getString(3);
						M_CONT_ADDR2 = resultset1.getString(4);
						M_CONT_ADDR3 = resultset1.getString(5);
						M_CONT_CONTACT = resultset1.getString(6);
						M_CONT_FRZ_FLAG = resultset1.getString(12);
						M_CONT_REF_NO = resultset1.getString(21);
						M_CONT_REF_ID1 = resultset1.getString(22);
						M_CONT_REF_ID2 = resultset1.getString(23);
						M_CONT_EMAIL_ID = resultset1.getString(28);
						M_CONT_POSTAL_CODE = resultset1.getString(29);
						M_CONT_DOB = resultset1.getDate(32);
						M_CONT_CATG_CODE = resultset1.getString(34);
					}
					
					resultset1.close();
					if (CommonUtils.nvl(M_DUMMY, "Y").equalsIgnoreCase("X")) {
						
						/*Added By Raja 29.6.2016*/
						
						if(!(PM_IL_CONTRACTOR_BEAN.isASSURED_NAME_FLAG()))
						{
						PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME);
						}
						
						/*End*/
						
						
						/*PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME); Commnented By Raja 29.6.2016*/
						PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(M_CONT_REF_ID1);
						PM_IL_CONTRACTOR_BEAN.setCONT_REF_NO(M_CONT_REF_NO);
						PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID2(M_CONT_REF_ID2);
						PM_IL_CONTRACTOR_BEAN.setCONT_DOB(M_CONT_DOB);
						PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(M_CONT_CATG_CODE);
						PM_IL_CONTRACTOR_BEAN.setCONT_ADDR1(M_CONT_ADDR1);
						PM_IL_CONTRACTOR_BEAN.setCONT_ADDR2(M_CONT_ADDR2);
						PM_IL_CONTRACTOR_BEAN.setCONT_ADDR3(M_CONT_ADDR3);
						PM_IL_CONTRACTOR_BEAN.setCONT_CONTACT(M_CONT_CONTACT);
						PM_IL_CONTRACTOR_BEAN.setCONT_POSTAL_CODE(M_CONT_POSTAL_CODE);
						PM_IL_CONTRACTOR_BEAN.setCONT_EMAIL_ID(M_CONT_EMAIL_ID);
						PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG(M_CONT_FRZ_FLAG);
						CommonUtils.objectSysout(PM_IL_CONTRACTOR_BEAN);
						ArrayList categoryList = P_VAL_SYSTEM
								.P_VAL_SYSTEM(
										connection,
										PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_TYPE,
										// COMP_CONT_CATG_CODE.getSubmittedValue().toString(),
										PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE(),
										PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_ERRORFLAG);
						if(categoryList.get(0) != null) {
						PM_IL_CONTRACTOR_BEAN
								.setUI_M_CONT_CATG_CODE_DESC(categoryList.get(0)
										.toString());
						}
						if(categoryList.size() >=1 && categoryList.get(1) != null) {
						M_VALUE = categoryList.get(1).toString();
						}
						PM_IL_CONTRACTOR_ACTION_QE_BEAN.resetAllComponent();
						PM_IL_CONTRACTOR_ACTION_QE_BEAN.disableAllComponent(true);
					}
				}

				ArrayList lengthList = P_VAL_SYSTEM
						.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_TYPE2,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_CODE,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_ERRORFLAG);
				if(lengthList.get(0) !=  null){
				M_CODE_DESC = lengthList.get(0).toString();
				}
				if(lengthList.size() >= 1 && lengthList.get(1) !=  null){
				M_NEW_IC_NO_LENGTH = Double.parseDouble(lengthList.get(1)
						.toString());
				}
					M_LENGTH_1 = Double.parseDouble(least(""
							+ (MigratingFunctions.nvl(M_NEW_IC_NO_LENGTH,
									M_REF_ID_1_LENGTH)), "" + M_REF_ID_1_LENGTH));
				if (refId1.length() > M_LENGTH_1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91240",new Object[]{M_LENGTH_1}));
				}
				ArrayList ps_valueList = P_VAL_SYSTEM
						.P_VAL_SYSTEM(connection,"CUSTREFFMT","CUSTREFFMT","N");
				if(ps_valueList.get(0) != null){
				M_CODE_DESC_1 = ps_valueList.get(0).toString();
				}
				if(ps_valueList.size() >= 1 && ps_valueList.get(1) != null){
				M_PS_VALUE_1 = ps_valueList.get(1).toString();
				}
				if (M_PS_VALUE_1.equals("1")) {
					String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
					ResultSet resultSet1 = handler.executeSelectStatement(query, connection,new Object[]{CommonUtils.SUBSTR(refId1,1,6)});
					if (resultSet1.next()) {
						M_DATE_CHAR = resultSet1.getString(1);
					}
					Date date = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
					CommonUtils.closeCursor(resultSet1);
					PM_IL_CONTRACTOR_BEAN.setCONT_DOB(date);
					M_GENDER =  Long.parseLong(refId1);
				}

				/*if ((M_GENDER % 2) == 0) {*/
			/*if (M_GENDER != null && (M_GENDER % 2) == 0) {*/
				if (M_GENDER != null) {
					if(M_GENDER % 2 == 0)
					{
						PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.CATEGORY_CODE_2);
					} else {
						PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.CATEGORY_CODE_1);
					}
				}
				if (PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE() != null) {
					ArrayList categoryList = P_VAL_SYSTEM
							.P_VAL_SYSTEM(
									connection,
									PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_TYPE,
									PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE(),
									PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.E_Flag);
					if(categoryList.get(0) != null){
					PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_CATG_CODE_DESC(categoryList.get(0).toString());
					}
					if(categoryList.size() >=1 && categoryList.get(1) != null){
					M_VALUE = categoryList.get(1).toString();
					}
					System.out.println("M_VALUE :" + M_VALUE);
				}
			}else {
				if (refId1 != null) {
					PM_IL_CONTRACTOR_BEAN.setCONT_DOB(null);
					PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(null);
					PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_CATG_CODE_DESC(null);

				}
			}
		}
	   }catch (Exception e) {
		e.printStackTrace();
		throw e;
	   }
	}
	
	public String least(String vembu0, String M_REF_ID_1_LENGTH)
			throws SQLException, Exception {
		String least_list0[] = new String[2];
		least_list0[0] = vembu0;
		least_list0[1] = M_REF_ID_1_LENGTH;
		return MigratingFunctions.least(least_list0);
	}
	
	public ArrayList P9ILPR_GEN_CHECK_DIGIT(Connection connection,
			String P_CUST_CODE, double m_seq_chk) {
		ArrayList procedureParameterList = new ArrayList();
		ArrayList outputList = new ArrayList();
		ArrayList returnList = new ArrayList();
		OracleParameter param1 = new OracleParameter("inPCustCode", "String",
				"IN", P_CUST_CODE);
		OracleParameter param2 = new OracleParameter("inMSeqChk", "String",
				"OUT", m_seq_chk + "");
		procedureParameterList.add(param1);
		procedureParameterList.add(param2);
		OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
		try {

			outputList = procedureHandler.execute(procedureParameterList,
					connection, "P9ILPR_GEN_CHECK_DIGIT");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
					System.out.println("Parameter M_SEQ_CHK :"
							+ returnList.get(1).toString());
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return returnList;
	}
	
	public void pilm_apac_pm_il_contractor_cont_ref_id2_when_validate_item(PM_IL_CONTRACTOR_ACTION_QE PM_IL_CONTRACTOR_ACTION_QE_BEAN) {
		PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_ACTION_QE_BEAN.getPM_IL_CONTRACTOR_QE_BEAN();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultset1 = null;
		ResultSet resultset2 = null;
		int errorCode=-1;
			String M_DUMMY = null;
			String M_CONT_NAME = null;
			String M_CONT_ADDR1 = null;
			String M_CONT_ADDR2 = null;
			String M_CONT_ADDR3 = null;
			String M_CONT_CONTACT = null;
			String M_CONT_PHONE = null;
			String M_CONT_FRZ_FLAG = null;
			String M_CONT_REF_NO = null;
			String M_CONT_REF_ID1 = null;
			String M_CONT_REF_ID2 = null;
			String M_CONT_EMAIL_ID = null;
			String M_CONT_POSTAL_CODE = null;
			Date M_CONT_DOB = null;
			String M_CONT_CATG_CODE = null;
			String M_CODE_DESC = null;
			String M_IND_REQ = null;
			String M_VALUE = null;
			String M_CODE_DESC_1 = null;
			String M_PC_CODE = null;
			double M_LENGTH_2 = -1;
			double M_OLD_IC_NO_LENGTH = -1;
			ArrayList resultList = null;
			double M_REF_ID2_LENGTH = PM_IL_CONTRACTOR_ACTION_QE_BEAN.getCOMP_CONT_REF_ID2().getMaxlength();
			String sqlQuery1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_QUERY_REFID2_DETAIL;
			try{
				connection = CommonUtils.getConnection();
				if(!PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2().isEmpty()) {
				Object[] object1 = {PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2()};
				/* P_VAL_SYSTEM procedure calling */
				 resultList = P_VAL_SYSTEM.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID2_TYPE,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID2_CODE,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_ERRORFLAG);
				if(resultList.get(0) != null){
				M_CODE_DESC = resultList.get(0).toString();
				}
				if(resultList.size() >= 1 && resultList.get(1) != null){
				M_OLD_IC_NO_LENGTH = Double.parseDouble(resultList.get(1).toString());
				}
					M_LENGTH_2 = Double.parseDouble(least(""
									+ (MigratingFunctions.nvl(M_OLD_IC_NO_LENGTH,
											M_REF_ID2_LENGTH)), "" + M_REF_ID2_LENGTH));
				if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2().length() > M_LENGTH_2) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91240",new Object[]{M_LENGTH_2}));
				}
				resultList.clear();
				resultList = P_VAL_SYSTEM.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID2_TYPE1,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID2_CODE1,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_ERRORFLAG1);
				if(resultList.get(0) != null){
				M_CODE_DESC = resultList.get(0).toString();
				}
				if(resultList.size() >=1 && resultList.get(1) != null){
				M_IND_REQ = resultList.get(1).toString();
				}
				if ("1".equals(M_IND_REQ)){
					if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == "" || PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() != null) {
						if (PM_IL_CONTRACTOR_BEAN.getROWID() == null) {
							resultset1 = handler.executeSelectStatement(sqlQuery1,connection, object1);
							if (resultset1.next()) {
								M_DUMMY = resultset1.getString(1);
								M_CONT_NAME = resultset1.getString(2);
								M_CONT_ADDR1 = resultset1.getString(3);
								M_CONT_ADDR2 = resultset1.getString(4);
								M_CONT_ADDR3 = resultset1.getString(5);
								M_CONT_CONTACT = resultset1.getString(6);
								M_CONT_FRZ_FLAG = resultset1.getString(12);
								M_CONT_REF_NO = resultset1.getString(21);
								M_CONT_REF_ID1 = resultset1.getString(22);
								M_CONT_REF_ID2 = resultset1.getString(23);
								M_CONT_EMAIL_ID = resultset1.getString(28);
								M_CONT_POSTAL_CODE = resultset1.getString(29);
								M_CONT_DOB = resultset1.getDate(32);
								M_CONT_CATG_CODE = resultset1.getString(34);
							}
							resultset1.close();
							if (CommonUtils.nvl(M_DUMMY,"Y").equals("X")) {
								
								/*added by raja*/
								
								if(!(PM_IL_CONTRACTOR_BEAN.isASSURED_NAME_FLAG()))
								{
								PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME);
								}
								/*end*/
								
							/*	PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME); Commented By Raja 29.6.2016*/
								PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(M_CONT_REF_ID1);
								PM_IL_CONTRACTOR_BEAN.setCONT_REF_NO(M_CONT_REF_NO);
								PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID2(M_CONT_REF_ID2);
								PM_IL_CONTRACTOR_BEAN.setCONT_DOB(M_CONT_DOB);
								PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(M_CONT_CATG_CODE);
								PM_IL_CONTRACTOR_BEAN.setCONT_ADDR1(M_CONT_ADDR1);
								PM_IL_CONTRACTOR_BEAN.setCONT_ADDR2(M_CONT_ADDR2);
								PM_IL_CONTRACTOR_BEAN.setCONT_ADDR3(M_CONT_ADDR3);
								PM_IL_CONTRACTOR_BEAN.setCONT_CONTACT(M_CONT_CONTACT);
								PM_IL_CONTRACTOR_BEAN.setCONT_POSTAL_CODE(M_CONT_POSTAL_CODE);
								PM_IL_CONTRACTOR_BEAN.setCONT_EMAIL_ID(M_CONT_EMAIL_ID);
								PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG(M_CONT_FRZ_FLAG);
							}
						}
					}
				}
				if (PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE() != null) {
					 resultList = P_VAL_SYSTEM
							.P_VAL_SYSTEM(
									connection,
									PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_TYPE,
									PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE(),
									PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);
					if(resultList.get(0) != null){
					PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_CATG_CODE_DESC(resultList.get(0).toString());
					}
					if(resultList.size() >= 1 && resultList.get(1) != null){
					M_VALUE = resultList.get(1).toString();
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	public void when_create_record(PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN)
			throws SQLException, Exception {

		PreparedStatement selectRelgionPCCodePreparedStatement = null;
		PreparedStatement selectRacePCCodePreparedStatement = null;
		PreparedStatement selectNationalityPCCodePreparedStatement = null;
		ResultSet resultSetRelgionCode = null;
		ResultSet resultSetRaceCode = null;
		ResultSet resultSetNationalityCode = null;
		String M_PC_CODE = null;
		String relegionDesc = null;
		String raceDesc = null;
		String nationalityDesc = null;
		String bankName = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			selectRelgionPCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_RELIGION);
			selectRacePCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_RACE);
			selectNationalityPCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_NATIONALITY);

			resultSetRelgionCode = selectRelgionPCCodePreparedStatement
					.executeQuery();
			if (resultSetRelgionCode.next()) {
				M_PC_CODE = resultSetRelgionCode.getString(1);
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_RELIGION(M_PC_CODE);

			relegionDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE1,
							PM_IL_CONTRACTOR_BEAN.getCONT_RELIGION(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);

			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RELIGION_DESC(relegionDesc);

			M_PC_CODE = null;

			resultSetNationalityCode = selectNationalityPCCodePreparedStatement
					.executeQuery();
			if (resultSetNationalityCode.next()) {
				M_PC_CODE = resultSetNationalityCode.getString(1);
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(M_PC_CODE);

			nationalityDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE,
							PM_IL_CONTRACTOR_BEAN.getCONT_NATIONALITY_CODE(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);

			PM_IL_CONTRACTOR_BEAN
					.setUI_M_CONT_NATIONALITY_CODE_DESC(nationalityDesc);

			M_PC_CODE = null;

			resultSetRaceCode = selectRacePCCodePreparedStatement
					.executeQuery();
			if (resultSetRaceCode.next()) {
				M_PC_CODE = resultSetRaceCode.getString(1);
			}
			PM_IL_CONTRACTOR_BEAN.setCONT_RACE(M_PC_CODE);
			raceDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE2,
							PM_IL_CONTRACTOR_BEAN.getCONT_RACE(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);

			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RACE_DESC(raceDesc);

			PM_IL_CONTRACTOR_BEAN
					.setCONT_EMPLOYER_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.EMPLOYEER_YN_N);
			PM_IL_CONTRACTOR_BEAN
					.setCONT_PREFERRED_LANG(PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PREFERRED_LANG_E);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSetRelgionCode);
				CommonUtils.closeCursor(resultSetRaceCode);
				CommonUtils.closeCursor(resultSetNationalityCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
    /*Added by saritha on 06-04-2018 for KIC CIVIL ID to be numeric field.validation to be there.*/
	
	public boolean vaildateValues(String current)throws Exception{
		boolean checkNumeric = true;
		try {

			String restricting_pattern = "\\d+";
			Pattern p = Pattern.compile(restricting_pattern);
			Matcher  m = p.matcher(current);
			if (!(m.matches())){

				checkNumeric = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return checkNumeric;
	}
	
	/*End*/


public void executeQuery(PM_IL_CONTRACTOR_ACTION_QE PM_IL_CONTRACTOR_ACTION_QE_BEAN)
			throws Exception {
		try {
			new PM_IL_CONTRACTOR_DELEGATE_QE().executeQuery(PM_IL_CONTRACTOR_ACTION_QE_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
}

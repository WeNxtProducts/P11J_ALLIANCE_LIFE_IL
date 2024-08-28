package com.iii.pel.forms.PILP017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_CHECK_OFF;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class DUMMY_HELPER {

	public void WHEN_CREATE_RECORD(DUMMY DUMMY_BEAN) throws Exception {
		try {
			// :DUMMY.M_DUE_MONTH := TO_CHAR(SYSDATE,'MM');
			/*
			 * 
			 * commented By Dhinesh for process type defalut value should be "CO" suggested by Siva
			 * 
			 * DUMMY_BEAN.setUI_M_PROCESS_TYPE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARA_1"));*/
			DUMMY_BEAN.setUI_M_PROCESS_TYPE("CO");
			DUMMY_BEAN.setUI_M_PROCESSING_DATE(new CommonUtils()
					.getCurrentDate());
			/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
			
			//DUMMY_BEAN.setUI_M_PAY_MODE("S");
			//DUMMY_BEAN.setUI_M_MAP_CODE("SCO-MAP-1");
			/*end*/
			
			// DUMMY_BEAN.setUI_M_DUE_YEAR := TO_CHAR(SYSDATE,'YYYY');
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(DUMMY DUMMY_BEAN) {
		// SET_ITEM_PROPERTY('BUTTON_PALETTE.PRINT',ENABLED,PROPERTY_FALSE);
		/*DUMMY_BEAN.setUI_M_CC_TYPE("O");
		DUMMY_BEAN.setUI_M_PAY_MODE("C");*/
	}

	public void WHEN_VALIDATE_M_POL_EMPLOYER_CODE(DUMMY DUMMY_BEAN)
			throws Exception {
		PKG_PILQ003 pkg_pilt002_apac = new PKG_PILQ003();
		ArrayList<String> pValList = new ArrayList<String>();
		try {
			if (DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE() != null) {
				pValList = pkg_pilt002_apac.P_VAL_CONT_CODE(DUMMY_BEAN
						.getUI_M_POL_EMPLOYER_CODE(), DUMMY_BEAN
						.getUI_M_EMP_CODE_DESC(), "E");
				DUMMY_BEAN.setUI_M_EMP_CODE_DESC(pValList.get(0));
			} else {
				DUMMY_BEAN.setUI_M_EMP_CODE_DESC(null);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_MAP_CODE(DUMMY DUMMY_BEAN)
			throws Exception {
		try {
			if (DUMMY_BEAN.getUI_M_MAP_CODE() != null) {
				P_VAL_MAP_CODE(DUMMY_BEAN.getUI_M_MAP_CODE(), DUMMY_BEAN
						.getUI_M_MAP_CODE_DESC(), "E", DUMMY_BEAN);
				
				
				/*
				 * commented by Dhiensh on 1/11/2017 for Premium due Download/Upload issues 
				 * 
				 * if("SCO-MAP-1".equalsIgnoreCase(DUMMY_BEAN.getUI_M_MAP_CODE()))
				{
						changed by raja on 06-03-2017 for ZBILQC-1719694 
					
					DUMMY_BEAN.setUI_M_PAY_MODE("S");	
				}else if("DEBIT_ORDER".equalsIgnoreCase(DUMMY_BEAN.getUI_M_MAP_CODE())){
					DUMMY_BEAN.setUI_M_PAY_MODE("AD");	
					
					end
				}
				*/
				
				/*Newly Added By Dhinesh on 1/11/2017 for Premium due Download/Upload issue suggested by Gaurav*/
				P_VAL_M_PAY_MODE(DUMMY_BEAN.getUI_M_MAP_CODE(),DUMMY_BEAN);
				/*End*/
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void P_VAL_MAP_CODE(String P_MAP_CODE, String P_MAP_DESC,
			String P_ERR_FLAG, DUMMY dummy) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_MAP_CODE_DESC = null;

		String C1 = "SELECT DUM_MAP_CODE,DUM_MAP_CODE_DESC FROM   PM_IL_DATA_UPLOAD_MAPPING WHERE  DUM_MAP_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { dummy.getUI_M_MAP_CODE() });
			if (resultSet.next()) {
				M_MAP_CODE_DESC = resultSet.getString(1);
			} else {
				P_MAP_DESC = M_MAP_CODE_DESC;
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91259",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				// STD_MESSAGE_ROUTINE(91259, NAME_IN('GLOBAL.M_LANG_CODE'));
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	public void P_VAL_M_PAY_MODE(String P_MAP_CODE,DUMMY dummy) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		String C1 = "SELECT DISTINCT DUM_PAYMENT_MODE FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_MAP_CODE = ? AND DUM_EMPLOYER_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { dummy.getUI_M_MAP_CODE(),dummy.getUI_M_POL_EMPLOYER_CODE()});
			
			if (resultSet.next()) {
				dummy.setUI_M_PAY_MODE(resultSet.getString("DUM_PAYMENT_MODE"));
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void WHEN_VALIDATE_ITEM_M_DUE_MONTH(DUMMY DUMMY_BEAN)
			throws Exception {
		String M_DATE = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT TO_CHAR(TO_DATE(?,?),?)FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			/*if (Integer.parseInt(DUMMY_BEAN.getUI_M_DUE_MONTH()) < 1
					&& (Integer.parseInt(DUMMY_BEAN.getUI_M_DUE_MONTH()) > 12)) {
				throw new Exception("Not a Valid month");
			}*/
			resultSet = handler
					.executeSelectStatement(C1, connection, new Object[] {
							DUMMY_BEAN.getUI_M_DUE_MONTH(), "MM", "MM" });
			if (resultSet.next()) {
				M_DATE = resultSet.getString(1);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
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
	}

	public void WHEN_VALIDATE_ITEM_M_DUE_YEAR(DUMMY DUMMY_BEAN)
			throws Exception {
		int M_NUM = 0;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT LENGTH(TRANSLATE(RTRIM(LTRIM(?)),' +-.0123456789',' ')) FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { DUMMY_BEAN.getUI_M_DUE_YEAR() });
			if (resultSet.next()) {
				M_NUM = resultSet.getInt(1);
			}
			if (CommonUtils.nvl(M_NUM, 0) > 0) {
				throw new Exception("Please Enter a Valid Year");
			} else {
				Integer dueYear = DUMMY_BEAN.getUI_M_DUE_YEAR();
				if (dueYear < 1900 && dueYear > 2999) {
					throw new Exception(
							"Processing year Should be between 1900 and 2999");
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
	}

	public void WHEN_VALIDATE_M_PROCESSING_DATE(DUMMY DUMMY_BEAN) {
		try {
			if (!(DUMMY_BEAN.getUI_M_PROCESSING_DATE().equals(new CommonUtils()
					.getCurrentDate()))) {
				throw new Exception(
						"Processing Date Should be equal to the current date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void WHEN_VALIDATE_M_REFERENCE(DUMMY DUMMY_BEAN) throws Exception {
		String M_DUMMY_REF = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList<Integer>list=new ArrayList<Integer>();
		String C1 = "SELECT  COTH_DU_REF_ID  FROM PT_IL_CHECK_OFF_TRANS_HDR WHERE "
				+ "COTH_DU_REF_ID=?";
		String C2="SELECT DEP_DOC_NO FROM PT_IL_DEPOSIT WHERE DEP_CONT_CODE=? ";
		try {
			connection = CommonUtils.getConnection();
			if (DUMMY_BEAN.getUI_M_REFERENCE() != null) {
				/*
				resultSet1 = handler.executeSelectStatement(C2, connection,
						new Object[] {DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE() });
				while(resultSet1.next()){
					list.add(resultSet1.getInt(1));
					
				}
				if(!list.contains(Integer.parseInt(DUMMY_BEAN.getUI_M_REFERENCE()))){
					throw new Exception("Enter valid Reference No.");
					
				}*/
				
				
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] { DUMMY_BEAN.getUI_M_REFERENCE() });

				if (resultSet.next()) {
					M_DUMMY_REF = "X";
				}
				if ("X".equals(CommonUtils.nvl(M_DUMMY_REF, "N"))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91041",
							new Object[] { DUMMY_BEAN.getUI_M_REFERENCE() }));
					// STD_MESSAGE_ROUTINE(91041,
					// NAME_IN('GLOBAL.M_LANG_CODE'),:DUMMY.M_REFERENCE);
				} 
				// STD_MESSAGE_ROUTINE(3206,
				// NAME_IN('GLOBAL.M_LANG_CODE'),'Enter Refernce no ..');
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_M_PAY_MODE(DUMMY DUMMY_BEAN,
			PILP017_COMPOSITE_ACTION compositeAction) {
		if (DUMMY_BEAN.getUI_M_PAY_MODE() != null
				&& CommonUtils.isIN(DUMMY_BEAN.getUI_M_PAY_MODE(), "C", "D",
						"L", "O")) {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_NO()
					.setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_CODE()
					.setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_DT()
					.setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_BRANCH()
					.setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_NO()
			.setDisabled(false);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_CODE()
			.setDisabled(false);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_DT()
			.setDisabled(false);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_BRANCH()
			.setDisabled(false);
		} else {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_NO()
					.setRequired(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_CODE()
					.setRequired(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_DT()
					.setRequired(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_BRANCH()
					.setRequired(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_NO()
			.setDisabled(true);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_CODE()
			.setDisabled(true);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_DT()
			.setDisabled(true);
	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_BRANCH()
			.setDisabled(true);
		}
		
		if (("SC".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE()))){
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_NAME().setDisabled(false);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_NO().setDisabled(false);

			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_TYPE().setDisabled(false);
		
		}
		else {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_NAME().setDisabled(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_NO().setDisabled(true);

			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CC_TYPE().setDisabled(true);
		
		}
		/*if (DUMMY_BEAN.getUI_M_PAY_MODE() != null
				&& CommonUtils.isIN(DUMMY_BEAN.getUI_M_PAY_MODE(), "C", "D",
						"L")) {
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_NO().setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CHEQUE_DT().setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_CODE().setRequired(true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BANK_BRANCH().setRequired(true);
		}*/
		
		/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
		if (("S".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE()))){
			
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_COMM_YN().setDisabled(false);
		}
		
		else {
			
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_COMM_YN().setDisabled(true);
			DUMMY_BEAN.setUI_M_COMM_YN("N");
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_COMM_YN().resetValue();
			
		}
		
		/*End*/
	}

	public void WHEN_LISTENER_M_PAY_MODE(DUMMY DUMMY_BEAN) throws Exception {
		try {
			if ("I".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE())) {
				DUMMY_BEAN.setUI_M_CC_DATE(new CommonUtils().getCurrentDate());
			} else {
				DUMMY_BEAN.setUI_M_CC_DATE(null);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_M_BANK_CODE(DUMMY DUMMY_BEAN)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT DECODE(?,?,BANK_NAME,BANK_NAME_BL),BANK_BR_CODE FROM "
				+ "  FM_BANK WHERE  BANK_CODE= ?";
		try {
			connection = CommonUtils.getConnection();
			if (DUMMY_BEAN.getUI_M_BANK_CODE() != null) {
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								"ENG", DUMMY_BEAN.getUI_M_BANK_CODE() });
				if (resultSet.next()) {
					DUMMY_BEAN.setUI_M_BANK_NAME_DESC(resultSet.getString(1));
					DUMMY_BEAN.setUI_M_BANK_BRANCH(resultSet.getString(2));
				} else {
					DUMMY_BEAN.setUI_M_BANK_NAME_DESC(null);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] {
									CommonUtils.getControlBean()
											.getM_LANG_CODE(),
									"Invalid Bank . Please re-enter.." }));
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public Integer GET_DEFINITION(String P_RET_PARA, String P_DEF_CODE,
			Integer P_DUDD_SERIAL_NO) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT DUDD_SERIAL_NO FROM   PM_IL_DATA_UPLOAD_DEFN_DTL "
				+ "WHERE  DUDD_DUDH_DEF_CODE = ? AND    "
				+ "DUDD_RET_PARA = ? AND    DUDD_PARA_TYPE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { P_DEF_CODE, P_RET_PARA, "P" });
			if (resultSet.next()) {
				P_DUDD_SERIAL_NO = resultSet.getInt(1);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return P_DUDD_SERIAL_NO;
	}

	public String GET_FLEX_VALUE(int P_SERIAL_NO, Long P_UD_SYS_ID,
			String P_DEFN_CODE, String P_MAP_ID) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_FIELD_ID = null;
		String M_FLEX_VALUE = null;
		Integer M_SERIAL_NO = null;
		String P_FIELD_ID = null;

		String C1 = "SELECT DECODE (DUM_FIELD_01,?, '01',DECODE (DUM_FIELD_02,?, '02',"
				+ "DECODE(DUM_FIELD_03,?, '03', DECODE (DUM_FIELD_04, ?, '04',"
				+ " DECODE (DUM_FIELD_05,?, '05', DECODE (DUM_FIELD_06, ?, '06',DECODE (DUM_FIELD_07, "
				+ "?, '07', DECODE (DUM_FIELD_08, ?, '08', DECODE (DUM_FIELD_09, ?,"
				+ " '09', DECODE (DUM_FIELD_10, ?, '10', DECODE (DUM_FIELD_11, ?, '11',  DECODE "
				+ "(DUM_FIELD_12, ?, '12', DECODE (DUM_FIELD_13, ?, '13', " +
						" DECODE (DUM_FIELD_14, "
				+ "?, '14', DECODE (DUM_FIELD_15,  ?, '15', DECODE (DUM_FIELD_16,"
				+ " ?, '16',  DECODE (DUM_FIELD_17,  ?, '17', DECODE (DUM_FIELD_18, "
				+ " ?, '18',  DECODE (DUM_FIELD_19, ?, '19',"
				+ " DECODE (DUM_FIELD_20, ?, '20') ) ) ) ) ) ) ) )  ) )  ) ) )  )  )  )  )   ) )  "
				+ "FROM   PM_IL_DATA_UPLOAD_MAPPING "
				+ "WHERE  DUM_DEF_CODE = ? AND DUM_MAP_CODE = ? ";

		String C2 = "SELECT DECODE (?, '01', UD_FLEX_01, '02', UD_FLEX_02, "
				+ "'03', UD_FLEX_03,  '04', UD_FLEX_04, '05', UD_FLEX_05, '06', UD_FLEX_06,  "
				+ "'07', UD_FLEX_07, '08', UD_FLEX_08, '09', UD_FLEX_09,  '10', UD_FLEX_10,"
				+ " '11', UD_FLEX_11, '12', UD_FLEX_12, '13', UD_FLEX_13,  '14', UD_FLEX_14,"
				+ " '15', UD_FLEX_15,  '16', UD_FLEX_16,  '17', UD_FLEX_17,  '18', UD_FLEX_18, "
				+ " '19', UD_FLEX_19,  '20', UD_FLEX_20 ) FROM   PW_IL_UPLOAD_DATA "
				+ " WHERE  UD_SYS_ID = ? ";

		try {
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(C1, connection,new Object[]{
					P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,
					P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,
					P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,P_SERIAL_NO,
					P_SERIAL_NO,P_SERIAL_NO,
					P_DEFN_CODE,P_MAP_ID});
			if (resultSet1.next()) {
				M_FIELD_ID = resultSet1.getString(1);
			}

			resultSet2 = handler.executeSelectStatement(C2, connection,new Object[]{M_FIELD_ID,P_UD_SYS_ID});
			if (resultSet2.next()) {
				M_FLEX_VALUE = resultSet2.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
		}
		return M_FLEX_VALUE;
	}

	/*Commented and modified by ganesh on 30-11-2017 as suggested by ajoy and gavrav */
	/*public void WHEN_BUTTON_PRESSED_M_BUT_PROCESS(DUMMY DUMMY_BEAN)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_SUCCESS = null;
		Long M_COTH_SYS_ID = null;
		Integer M_PIL_PROC_SYS_ID = null;
		String M_DUM_DEF_CODE = null;
		Integer M_DD_SR_NO = null;
		String M_EMPLOYEE_CODE = null;
		Long M_POL_SYS_ID = null;
		String M_POL_PYMT_TYPE = null;
		String M_LIV_CODE_DESC = null;
		String M_PROC_TYPE = null;
		String M_VALID_BANK_YN = null;
		String M_CONT_DET = null;
		String M_POL_NO = null;
		String M_CONT_CODE = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();

		String C1 = "SELECT PEL_SYS_ID.NEXTVAL FROM DUAL ";
		String C2 = "SELECT UD_SYS_ID FROM PW_IL_UPLOAD_DATA";
		
		 * Commented by sankara narayanan on 20/04/2017
		 * String C3 = "SELECT DECODE(?,'CO',POL_EMPLOYER_CODE,'AD',POL_EMPLOYER_CODE,POL_CONT_CODE), "
				+ "POL_SYS_ID, DECODE(POL_PYMT_TYPE,'AD','S','P', 'S',POL_PYMT_TYPE) FROM PT_IL_POLICY WHERE POL_NO = ? ";
		Added by sankara narayanan for debit order
		String C3 = "SELECT DECODE(?,'CO',POL_EMPLOYER_CODE,'AD',POL_EMPLOYER_CODE,POL_CONT_CODE), "
				+ "POL_SYS_ID, DECODE(POL_PYMT_TYPE,'AD','S','P', 'S','BS','S',POL_PYMT_TYPE) FROM PT_IL_POLICY WHERE POL_NO = ? ";  
		//end
		
		String C4 = "SELECT DUM_DEF_CODE FROM PM_IL_DATA_UPLOAD_MAPPING WHERE "
				+ "DUM_MAP_CODE = ? ";
		String C5 = "SELECT 'Policy payment method should be '||LIV_CODE_DESC, "
				+ "DECODE(?,'CO','S', 'I')  "
				+ "FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = ? "
				+ "AND LIV_CODE = DECODE(?,'CO','S', 'I')";
		String C6 = "SELECT 1 ,CONT_CODE||'-'||CONT_NAME FROM PM_IL_CONTRACTOR"
				+ " WHERE CONT_CODE = M_CONT_CODE AND CONT_AD_BANK_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet4 = handler.executeSelectStatement(C4, connection,
					new Object[] { DUMMY_BEAN.getUI_M_MAP_CODE() });
			if (resultSet4.next()) {
				M_DUM_DEF_CODE = resultSet4.getString(1);
			}
			if (DUMMY_BEAN.getUI_M_REFERENCE() == null) {
				// GO_ITEM('DUMMY.M_REFERENCE');
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "19050",
						new Object[] { CommonUtils.getControlBean()
								.getM_LANG_CODE() }));
			}
			resultSet1 = handler.executeSelectStatement(C1, connection);
			if (resultSet1.next()) {
				DUMMY_BEAN.setUI_M_PIL_PROC_SYS_ID(resultSet1.getLong(1));
			}
			resultSet5 = handler.executeSelectStatement(C5, connection,
					new Object[] { DUMMY_BEAN.getUI_M_PROCESS_TYPE(),
							"IL_PAY_MODE", DUMMY_BEAN.getUI_M_PROCESS_TYPE() });
			if (resultSet5.next()) {
				M_LIV_CODE_DESC = resultSet5.getString(1);
				M_PROC_TYPE = resultSet5.getString(2);
			}
			resultSet2 = handler.executeSelectStatement(C2, connection);
			while (resultSet2.next()) {
				Long UD_SYS_ID = resultSet2.getLong(1);
				ArrayList<OracleParameter> pvalOrclList = new ArrayList<OracleParameter>();
				pvalOrclList = new P9ILPK_CHECK_OFF().GET_DEFINITION("2", M_DUM_DEF_CODE, M_DD_SR_NO,
						null, null, null,
						null, null, null, 
						null, null, null);
				 if (pvalOrclList != null && !pvalOrclList.isEmpty()) {
					 M_DD_SR_NO = (Integer) pvalOrclList.get(0).getValueObject();
				 }
				int serialNum = GET_DEFINITION("2", M_DUM_DEF_CODE,M_DD_SR_NO);
				M_DD_SR_NO = serialNum;
				String polNum = GET_FLEX_VALUE(M_DD_SR_NO, UD_SYS_ID,M_DUM_DEF_CODE,DUMMY_BEAN.getUI_M_MAP_CODE());
				Newly Added By Dhinesh on 20-06-2017 for ssp call id ZBILQC-1722635
				if(polNum != null)
				{
				resultSet3 = handler.executeSelectStatement(C3, connection,
						new Object[] { DUMMY_BEAN.getUI_M_PROCESS_TYPE(),polNum });
				if (resultSet3.next()) {
					M_EMPLOYEE_CODE = resultSet3.getString(1);
					M_POL_SYS_ID = resultSet3.getLong(2);
					M_POL_PYMT_TYPE = resultSet3.getString(3);
				}
				if (M_PROC_TYPE.equalsIgnoreCase(M_POL_PYMT_TYPE)) {
					if ("BO"
							.equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROCESS_TYPE())) {
						resultSet6 = handler.executeSelectStatement(C6,
								connection, new Object[] { DUMMY_BEAN
										.getUI_M_BANK_CODE() });
						if (resultSet6.next()) {
							M_VALID_BANK_YN = resultSet6.getString(1);
							M_CONT_DET = resultSet6.getString(2);
						}
					}

					if (("BO".equalsIgnoreCase(DUMMY_BEAN
							.getUI_M_PROCESS_TYPE()))
							&& ("1".equalsIgnoreCase(CommonUtils.nvl(
									M_VALID_BANK_YN, "0")))
							|| ("CO".equalsIgnoreCase(DUMMY_BEAN
									.getUI_M_PROCESS_TYPE()))) {
						list=new P9ILPK_CHECK_OFF().VALIDATE_PROCESS(DUMMY_BEAN
								.getUI_M_PROCESS_TYPE(), DUMMY_BEAN
								.getUI_M_POL_EMPLOYER_CODE(), UD_SYS_ID,
								DUMMY_BEAN.getUI_M_MAP_CODE(), DUMMY_BEAN
										.getUI_M_PROCESSING_DATE(), DUMMY_BEAN
										.getUI_M_REFERENCE(), DUMMY_BEAN
										.getUI_M_DUE_MONTH(), DUMMY_BEAN
										.getUI_M_DUE_YEAR(), DUMMY_BEAN
										.getUI_M_PAY_MODE(), DUMMY_BEAN
										.getUI_M_CHEQUE_NO(), DUMMY_BEAN
										.getUI_M_CHEQUE_DT(), DUMMY_BEAN
										.getUI_M_BANK_CODE(), DUMMY_BEAN
										.getUI_M_BANK_BRANCH(), DUMMY_BEAN
										.getUI_M_DEP_BANK_CODE(),
								M_COTH_SYS_ID, M_SUCCESS, DUMMY_BEAN
										.getUI_M_PIL_PROC_SYS_ID(),
								M_POL_SYS_ID);
					} else {
						// not available in backend need to call
						
						 * PCOPK_GENERAL.P_INS_PROC_ERR_LOG
						 * (:DUMMY.M_PIL_PROC_SYS_ID, M_POL_SYS_ID, 'PILP017',
						 * NULL, 'Invalid bank code '||:DUMMY.M_BANK_CODE||' is
						 * mapped to contractor '||M_CONT_DET, 'F', NULL, NULL,
						 * NULL );
						 
					}
				} else {
					// not available in backend need to call
					
					 * PCOPK_GENERAL.P_INS_PROC_ERR_LOG
					 * (:DUMMY.M_PIL_PROC_SYS_ID, M_POL_SYS_ID, 'PILP017', NULL,
					 * M_LIV_CODE_DESC, 'F', NULL, NULL, NULL );
					 
				}
			
			M_COTH_SYS_ID=CommonUtils.nvl((Long) list.get(0).getValueObject(), 0);
		
			CommonUtils.setGlobalObject("M_COTH_SYS_ID", M_COTH_SYS_ID);

			String insertQuery = "INSERT INTO PT_CHECK_OFF_PROCESS (PCOP_SYS_ID, PCOP_PROCESS_TYPE,"
					+ "PCOP_MAP_CODE, PCOP_EMP_CODE, PCOP_PROCESS_DT, PCOP_REF_ID,"
					+ "PCOP_DUE_MONTH, PCOP_DUE_YEAR, PCOP_COTH_SYS_ID,PCOP_CR_DT, PCOP_CR_UID)"
					+ "VALUES(PIL_PCOP_SYS_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?) ";
			int resultSet = handler.executeInsertStatement(insertQuery,
					connection, new Object[] {
							DUMMY_BEAN.getUI_M_PROCESS_TYPE(),
							DUMMY_BEAN.getUI_M_MAP_CODE(),
							DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE(),
							DUMMY_BEAN.getUI_M_PROCESSING_DATE(),
							DUMMY_BEAN.getUI_M_REFERENCE(),
							DUMMY_BEAN.getUI_M_DUE_MONTH(),
							DUMMY_BEAN.getUI_M_DUE_YEAR(), M_COTH_SYS_ID,
							new CommonUtils().getCurrentDate(),
							CommonUtils.getGlobalObject("GLOBAL.M_USER_ID") });
			CommonUtils.setGlobalVariable("GLOBAL.M_COMM_DEL", "C");
			CommonUtils.getConnection().commit();
			// COMMIT;
			CommonUtils.setGlobalVariable("GLOBAL.M_COMM_DEL", null);
			// throw new Exception("Process Completed Successfully");
			if ("Y".equalsIgnoreCase(M_SUCCESS) && M_COTH_SYS_ID != null) {
				CommonUtils.setGlobalObject("GLOBAL.P_COTH_SYS_ID",
						M_COTH_SYS_ID);
				CommonUtils.setGlobalObject("GLOBAL.P_REFERENCE_NO", DUMMY_BEAN
						.getUI_M_REFERENCE());
			}
			}
			}
			End
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
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
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
			}
		}

	}
}*/
/*Modified by ganesh on 30-11-2017 as suggested by ajoy and gavrav */
public void WHEN_BUTTON_PRESSED_M_BUT_PROCESS(DUMMY DUMMY_BEAN)
		throws Exception {
	Connection connection = null;
	String M_SUCCESS = null;
	Long M_COTH_SYS_ID = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	ResultSet resultSet4 = null;
	ResultSet resultSet5 = null;
	ResultSet resultSet6 = null;
	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();

	
	try {
		connection = CommonUtils.getConnection();
		
		list=new P9ILPK_CHECK_OFF().VALIDATE_PROCESS(DUMMY_BEAN
				.getUI_M_PROCESS_TYPE(), DUMMY_BEAN
				.getUI_M_POL_EMPLOYER_CODE(), null,
				DUMMY_BEAN.getUI_M_MAP_CODE(), DUMMY_BEAN
						.getUI_M_PROCESSING_DATE(), DUMMY_BEAN
						.getUI_M_REFERENCE(), DUMMY_BEAN
						.getUI_M_DUE_MONTH(), DUMMY_BEAN
						.getUI_M_DUE_YEAR(), DUMMY_BEAN
						.getUI_M_PAY_MODE(), DUMMY_BEAN
						.getUI_M_CHEQUE_NO(), DUMMY_BEAN
						.getUI_M_CHEQUE_DT(), DUMMY_BEAN
						.getUI_M_BANK_CODE(), DUMMY_BEAN
						.getUI_M_BANK_BRANCH(), DUMMY_BEAN
						.getUI_M_DEP_BANK_CODE(),
				M_COTH_SYS_ID, M_SUCCESS, DUMMY_BEAN
						.getUI_M_PIL_PROC_SYS_ID(),
				null);
		
		M_COTH_SYS_ID=CommonUtils.nvl((Long) list.get(0).getValueObject(), 0);
	
		CommonUtils.setGlobalObject("M_COTH_SYS_ID", M_COTH_SYS_ID);		
		CommonUtils.setGlobalVariable("GLOBAL.M_COMM_DEL", "C");
		CommonUtils.getConnection().commit();
		// COMMIT;
		CommonUtils.setGlobalVariable("GLOBAL.M_COMM_DEL", null);
		// throw new Exception("Process Completed Successfully");
		if ("Y".equalsIgnoreCase(M_SUCCESS) && M_COTH_SYS_ID != null) {
			CommonUtils.setGlobalObject("GLOBAL.P_COTH_SYS_ID",
					M_COTH_SYS_ID);
			CommonUtils.setGlobalObject("GLOBAL.P_REFERENCE_NO", DUMMY_BEAN
					.getUI_M_REFERENCE());
		}
		
		
		/*End*/
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
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
		try {
			CommonUtils.closeCursor(resultSet4);
		} catch (Exception e) {
		}
		try {
			CommonUtils.closeCursor(resultSet5);
		} catch (Exception e) {
		}
		try {
			CommonUtils.closeCursor(resultSet6);
		} catch (Exception e) {
		}
	}

}
}

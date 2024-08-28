package com.iii.pel.forms.PM079_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_WAKALAH_DAILY_ACC_SETUP_HELPER {

	public void WhenNewFormInstance(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		Integer M_TEMP = 0;
		String C1 = "SELECT NVL(PS_VALUE,1) FROM PP_SYSTEM WHERE PS_TYPE = 'SRCBUSYSNO'";
		ResultSet resultset;
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			resultset = handler.executeSelectStatement(C1, connection);
			if (resultset.next()) {
				M_TEMP = resultset.getInt(1);
			}
			if (M_TEMP == 1) {

				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_FM("0");
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_FM().setValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_FM().setDisabled(true);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SRC_BUS_TO("zzzzzzzzzz");
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_FM().setValue("zzzzzzzzzz");
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_FM().setDisabled(true);
			} else if (M_TEMP == 2) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_FM().setDisabled(false);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_SRC_BUS_TO().setDisabled(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			}
	}

	public void Pre_Record(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
	try{
		L_SET_SUB_ACCOUNT(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);

	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		}

	}

	public void L_SET_SUB_ACCOUNT(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		String C1 = " SELECT MAIN_CTL_ACNT_FLAG,MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM   FM_MAIN_ACCOUNT"
				+ " WHERE  MAIN_ACNT_CODE  = ?";
		String M_FLAG = null;
		String M_ACTY_HEAD_1 = null;
		String M_ACTY_HEAD_2 = null;
		ResultSet resultSet;
		Connection connection;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PM_WAKALAH_DAILY_ACC_SETUP_BEAN
							.getWAKD_ACC_MAIN_ACNT_CODE() });
			if (resultSet.next()) {
				M_FLAG = resultSet.getString(1);
				M_ACTY_HEAD_1 = resultSet.getString(2);
				M_ACTY_HEAD_2 = resultSet.getString(3);
			} else {
				M_FLAG = "X";
			}
			if (M_FLAG != "C") {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setRequired(false);

			} else {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setRequired(true);
			}
			if (M_ACTY_HEAD_1 == null) {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setRequired(false);
				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setDisabled(true);

			} else {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setRequired(true);
				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setDisabled(false);
			}

			if (M_ACTY_HEAD_2 == null) {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setRequired(false);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setDisabled(true);

			} else {

				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setRequired(true);
				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setDisabled(false);
			}
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void PRE_INSERT(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		CTRL CTRL_BEAN = null;
		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CR_DT(new CommonUtils()
				.getCurrentDate());
		L_UNIQUE_RANGE(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
	}

	public void L_UNIQUE_RANGE(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		
		ResultSet resultSet;
		Connection connection;
		CRUDHandler handler = new CRUDHandler();
		String  C1 =" SELECT 1 FROM  PM_WAKALAH_DAILY_ACC_SETUP WHERE WAKD_ACC_MODULE =  ?" +
				" AND   WAKD_ACC_SEQ_NO = ? " +
				" AND   WAKD_ACC_SETUP  = ?" +
				" AND   WAKD_ACC_SRC_BUS_TO  >= ?" +
				" AND   WAKD_ACC_SRC_BUS_FM  <= ?" +
				" AND WAKD_ACC_SRC_BUS_TO    >= ?" +
				" AND WAKD_ACC_SRC_BUS_FM    <= ?" +
				" AND WAKD_ACC_DOC_TO_TYPE   >= ?" +
				" AND WAKD_ACC_DOC_FM_TYPE   <= ?" +
				" AND WAKD_ACC_DOC_TO_TYPE   >= ?" +
				" AND WAKD_ACC_DOC_FM_TYPE   <= ?" +
				" AND WAKD_ACC_SC_TO_CODE    >= ?" +
				" AND WAKD_ACC_SC_FM_CODE    <= ?" +
				" AND WAKD_ACC_SC_TO_CODE    >= ?" +
				" AND WAKD_ACC_SC_FM_CODE    <= ?" +
				" AND WAKD_ACC_CLASS_TO_CODE >= ?" +
				" AND WAKD_ACC_CLASS_FM_CODE <= ?" +
				" AND WAKD_ACC_CLASS_TO_CODE >= ?" +
				" AND WAKD_ACC_CLASS_FM_CODE <= ?" +
				" AND WAKD_ACC_DIVN_TO_CODE  >= ?" +
				" AND WAKD_ACC_DIVN_FM_CODE  <= ?" +
				" AND WAKD_ACC_DIVN_TO_CODE  >= ?" +
				" AND WAKD_ACC_DIVN_FM_CODE  <= ?" +
				" AND WAKD_ACC_DEPT_TO_CODE  >= ?" +
				" AND WAKD_ACC_DEPT_FM_CODE  <= ?" +
				" AND WAKD_ACC_DEPT_TO_CODE  >= ?" +
				" AND WAKD_ACC_DEPT_FM_CODE  <= ?" +
				" AND WAKD_ACC_COVER_TO_CODE >= ?" +
				" AND WAKD_ACC_COVER_FM_CODE <= ?" +
				" AND WAKD_ACC_COVER_TO_CODE >= ?" +
				" AND WAKD_ACC_COVER_FM_CODE <= ?" +
				"  AND WAKD_ACC_ALY_TO_2     >= ?" +
				" AND WAKD_ACC_ALY_FM_2      <= ?" +
				" AND WAKD_ACC_ALY_TO_2       >= ?" +
				" AND WAKD_ACC_ALY_FM_2      <= ?" +
				" AND WAKD_ACC_ALY_TO_1      >= ?" +
				" AND WAKD_ACC_ALY_FM_1      <= ?" +
				" AND WAKD_ACC_ALY_TO_1      >= ?" +
				" AND WAKD_ACC_ALY_FM_1      <= ?" +
				" AND WAKD_ACC_DR_CR         = ?" +
				" AND WAKD_ACC_DA_MO_DRIP    = ?";

		
		   try{
			   connection=CommonUtils.getConnection();	
			   resultSet=handler.executeSelectStatement(C1, connection,
				   new Object[]{PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MODULE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SEQ_NO(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SETUP(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_FM(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_FM(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_TO(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_TO(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_FM_TYPE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_FM_TYPE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_TO_TYPE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_TO_TYPE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_FM_CODE(),	
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_FM_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_TO_CODE(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_TO_CODE(),	
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_2(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_2(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_2(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_2(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_1(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_1(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_1(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_1(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DR_CR(),
				   PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DA_MO_DRIP(),});
		   
		   if(resultSet.next()){
			   throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1033"));
			      
		   }
	}catch (Exception e) {
	e.printStackTrace();
	throw e;
	}
	}


	public void WhenCreateRecord(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		ResultSet resultSet;
		Connection connection;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT NVL(PS_VALUE,1) FROM PP_SYSTEM WHERE PS_TYPE = 'SRCBUSYSNO'";

		Integer M_PS_VALUE = null;
		try {
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_FORCE_DIVN_YN("Y");
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_FORCE_DEPT_YN("Y");
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if (CommonUtils.nvl(M_PS_VALUE, 1) == 1) {

				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_FM("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SRC_BUS_TO("ZZZZZZZZZZZZ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}


	
	public void L_VAL_FROM_TO(String P_FROM_CODE, String P_TO_CODE)
			throws Exception {

		try {
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewRecordInstance(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		String C1=" SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
				" FROM   FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE = ?";
		 String C2=" SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ?";
		 String C3 =" SELECT ACTY_NAME  FROM   FM_ACTIVITY WHERE  ACTY_CODE = :DUMMY.M_ACTY_2";
		 String M_TEMP1 =null;
		 String M_TEMP2 =null;   
		 ResultSet resultSet1=null;
		 ResultSet resultSet2=null;
		 ResultSet resultSet3=null;
		 Connection connection;
		 CRUDHandler handler=new CRUDHandler();
		 
	
	try{
		connection=CommonUtils.getConnection();
		resultSet1=handler.executeSelectStatement(C1, connection,
				new Object[]{PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE()});
			
			if(resultSet1!=null && resultSet1.next()){
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_1(resultSet1.getString(1));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_2(resultSet1.getString(2));
			}
			if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1()!=null){
			
				resultSet2=handler.executeSelectStatement(C2, connection,
					new Object[]{PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1()});
			
		    if(resultSet2!=null && resultSet2.next()) {
		    	M_TEMP1=resultSet2.getString(1);
		    	}
		   	
		    PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
		 } else{
			 
			 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL().setValue("Activity code1");
		 }
			if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2()!=null){
				resultSet3=handler.executeSelectStatement(C3, connection,
						new Object[]{PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2()});
				
			    if(resultSet3!=null && resultSet3.next()) {
			    	M_TEMP1=resultSet2.getString(1);
			    	}
			   	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2_LABEL().setValue(M_TEMP1);
			 } else{
				 
				 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2_LABEL().setValue("Activity code2");
			 }
	  /* IF :SYSTEM.CURSOR_ITEM IN ('PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DIVN_CODE','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DEPT_CODE',
		 														'PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC__ACTY_CODE_1','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_ACTY_CODE_2') THEN
		 	  GO_ITEM('PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_MAIN_ACNT_CODE');
		 END IF;*/
			
		if("Y".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DIVN_YN(),"N"))){
			
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(true);
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setRequired(false);
		}  
		if("N".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DIVN_YN(),"N"))){
			
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(false);
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setRequired(true);
		}
		if("Y".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DEPT_YN(),"N"))){
			
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setDisabled(true);
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setRequired(false);
		}  
		if("N".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DEPT_YN(),"N"))){
			
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setDisabled(false);
		      PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setRequired(true);
		}
			   	
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
		}
	}
	
	
	public void whenValidateWAKD_ACC_MODULE(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		try {
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_FM_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_FM_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_FM_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_FM_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_FM_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_FM(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_FM_TYPE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_TO_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_TO_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_TO_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_TO_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_TO_CODE(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_TO(null);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_TO_TYPE(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateWAKD_ACC_SETUP(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		try {

			if ("Y".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DIVN_YN(), "N"))) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(true);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_DIVN_CODE().setRequired(false);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_CODE(null);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DIVN_NAME(null);
			}

			else if ("N".equals(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DIVN_YN())) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
						.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateWAKD_ACC_FORCE_DIVN_YN(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		try {

			if ("Y".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DIVN_YN(), "N"))) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(true);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setRequired(false);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_CODE(null);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DIVN_NAME(null);
			}

			else if ("N".equals(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DIVN_YN())) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setDisabled(false);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE().setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateWAKD_ACC_FORCE_DEPT_YN(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN)
			throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
																		.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		try {

			if ("Y".equals(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DEPT_YN(), "N"))) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setDisabled(true);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setRequired(false);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_CODE(null);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DEPT_NAME(null);
			}

			else if ("N".equals(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_FORCE_DEPT_YN())) {

				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setDisabled(false);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE().setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	

	public void whenValidateWAKD_ACC_SUB_ACNT_CODE(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SUB_ACNT_CODE() != null) {
				list = new DBProcedures().P_VAL_SUB_ACNT(
						PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE(),
						PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SUB_ACNT_CODE(), "N",
						"E");
				if (list != null && !(list.isEmpty())) {
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(list.get(0));
				}
				list.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void whenValidateWAKD_ACC_DIVN_CODE(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		ArrayList<String> list=new ArrayList<String>();
		try {

			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DIVN_NAME(null);
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_CODE() != null) {
				list = new DBProcedures().callP_VAL_DIVN(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.getWAKD_ACC_DIVN_CODE(),"N", "E");
				if (list != null && !(list.isEmpty())) {
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0));
					
				}
			}
			/*if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DIVN_YN(), "N"))) {
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DIVN_CODE()
						.setRequired(true);
			}*/

			L_SET_DEPT_ATTR(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateWAKD_ACC_DEPT_CODE(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		ArrayList<String> list = new ArrayList<String>();
		String list1 = null;
		try {

			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DEPT_NAME(null);
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_CODE() != null) {
				list = new DBProcedures().callP_VAL_DEPT(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.getWAKD_ACC_DIVN_CODE(), PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.getWAKD_ACC_DEPT_CODE(), "N", "E");
					if(list !=null &&!(list.isEmpty())){
						PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
					}
			}
			/*if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_FORCE_DEPT_YN(), "N"))) {
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE()
						.setRequired(true);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void L_SET_DEPT_ATTR(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		try {
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_CODE() == null) {
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE()
						.setRequired(false);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE()
						.setDisabled(true);
				if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_CODE() != null) {
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_CODE(null);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DEPT_NAME(null);
				}
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE()
						.setRequired(true);
				PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_DEPT_CODE()
						.setDisabled(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void whenNewItemInstanceWAKD_ACC_DEPT_CODE(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN){
		try{
			L_SET_DEPT_ATTR(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
		}catch (Exception e) {
			e.printStackTrace();		
			}
	}
	
	public void whenValidateWAKD_ACC_ANLY_CODE_1(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME(null);
	if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ANLY_CODE_1() !=null){
		 list= new DBProcedures().P_VAL_ANLY("1",PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ANLY_CODE_1(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
				list.clear();
			} 
	}
	L_SET_ANALYSIS_ATTR(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void whenValidateWAKD_ACC_ANLY_CODE_2(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME_1(null);
	if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ANLY_CODE_2() !=null){
		 list= new DBProcedures().P_VAL_ANLY("2",PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ANLY_CODE_2(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void L_SET_ANALYSIS_ATTR (PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN){
		PM_WAKALAH_DAILY_ACC_SETUP  PM_WAKALAH_DAILY_ACC_SETUP_BEAN=PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		
	try{
	if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ANLY_CODE_1()==null){
		 PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ANLY_CODE_2().setDisabled(true);
	}  
	else{
		PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ANLY_CODE_2().setDisabled(false);
	}
	}
	catch (Exception e) {
		e.printStackTrace();}
	
	}
	public void whenNewItemInstanceWAKD_ACC_ANLY_CODE_2(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN){
		try{
			L_SET_ANALYSIS_ATTR(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
		}catch (Exception e) {
			e.printStackTrace();		
			}
	}

	public void whenValidateWAKD_ACC_ACTY_CODE_1(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME(null);
	if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_1() !=null){
		 list= DBProcedures.P_VAL_ACTY(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1(),
                 PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_1(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	public void whenValidateWAKD_ACC_ACTY_CODE_2(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
	if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_2() !=null){
		 list=  DBProcedures.P_VAL_ACTY(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2(),
                 PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_2(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME_1(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void whenValidateWAKD_ACC_MAIN_ACNT_CODE(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		String CURSORC1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2"
				+ " FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ?";
		String CURSORC2 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ? ";
		String CURSORC3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ?";
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list = new ArrayList<String>();
		try {
			connection=CommonUtils.getConnection();
			list = new DBProcedures().P_VAL_MAIN_ACNT(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_MAIN_ACNT_CODE(), "N", "E");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list.get(0));
			}
			list.clear();
			
			L_VAL_SUB_ACCOUNT(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);
			resultSet1 = handler.executeSelectStatement(CURSORC1, connection,
					new Object[] { PM_WAKALAH_DAILY_ACC_SETUP_BEAN
							.getWAKD_ACC_MAIN_ACNT_CODE() });
			if (resultSet1.next()) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_1(resultSet1.getString(1));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_2(resultSet1.getString(2));
				System.out.println(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1());
				System.out.println(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2());

				if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1() != null) {

					resultSet2 = handler.executeSelectStatement(CURSORC2,
							connection, new Object[] {PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1() });
					if (resultSet2.next()) {
						M_TEMP1 = resultSet2.getString(1);
						PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
					} else {
						PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
								.getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL().setValue("Activity Code1");
					}
				}
				if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2() != null) {
					resultSet3 = handler.executeSelectStatement(CURSORC3,
							connection, new Object[] { PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2() });
					if (resultSet3.next()) {
						M_TEMP2 = resultSet3.getString(1);
						PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
								.getCOMP_WAKD_ACC_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
					} else {
						PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
								.getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL().setValue("Activity Code2");
					}
				}
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
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}

	public void L_VAL_SUB_ACCOUNT(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) throws Exception {

		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();

		
	String  C1=" SELECT MAIN_CTL_ACNT_FLAG,MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
			" FROM   FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE  = ?"; 
	 ResultSet resultSet=null;
     Connection connection=CommonUtils.getConnection();
     CRUDHandler handler=new CRUDHandler();
     String mainAcntcode=PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE();
     String   M_FLAG=null;
     String   M_ACTY_HEAD_1=null;
     String   M_ACTY_HEAD_2=null;
      try
      {
      	if(mainAcntcode!=null){
	            
	            resultSet=handler.executeSelectStatement(C1, connection,new Object[] {mainAcntcode});
	            if(resultSet!=null){
	       
	            	if(resultSet.next())
	            {
	                M_FLAG=resultSet.getString(1);
	                M_ACTY_HEAD_1=resultSet.getString(2);
	                M_ACTY_HEAD_2=resultSet.getString(3);
	            }
	            	}
	            else{
	                M_FLAG = "X";
	            }
	           
	            if(!M_FLAG.equals("C"))
	            {
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setRequired(false);
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setDisabled(true);
	               	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SUB_ACNT_CODE(null);
              	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
              }
	            else
	            {
	                PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setRequired(true);
	                PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_SUB_ACNT_CODE().setDisabled(false);
	                PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().
	                setWAKD_ACC_SUB_ACNT_CODE(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().
	                		getWAKD_ACC_SUB_ACNT_CODE());
	            }
	            if(M_ACTY_HEAD_1== null)
	            {
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setRequired(false);
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setDisabled(true);
	            	String actyCode1=PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_1();
	                PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ACTY_CODE_1(null);
	                PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME(null);
	            }
	            else
	            {
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setRequired(true);
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_1().setDisabled(false);
	               
	            }
	            if(M_ACTY_HEAD_2== null)
	            {
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setRequired(false);
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setDisabled(true);
	            	String actyCode2=PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_2();
	                PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ACTY_CODE_2(null);
	                PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
	            }
	            else
	            {
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setWAKD_ACC_ACTY_CODE_2(
	                PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().getWAKD_ACC_ACTY_CODE_2());
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setRequired(true);
	            	PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getCOMP_WAKD_ACC_ACTY_CODE_2().setDisabled(false);
	            }
	            	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
	            	PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
	            
	            
      	}
      }catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
      finally
      {
      	try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
      }
  }
	public void postQuery(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = new DBProcedures().P_VAL_MAIN_ACNT(
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().P_VAL_SUB_ACNT(
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE(),
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SUB_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(list.get(0));
			}
			list.clear();
			L_GET_ACTY_DETAILS(PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN);

			list=  new DBProcedures().callP_VAL_DIVN(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_DIVN_CODE(),"N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().callP_VAL_DEPT(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_DIVN_CODE(),PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_DEPT_CODE(),"N", "N");
			if (list!= null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
			}
			
			list = new DBProcedures().P_VAL_ANLY("1", PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_ANLY_CODE_1(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().P_VAL_ANLY("2", PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_ANLY_CODE_2(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
			}
			list.clear();
			list =  DBProcedures.P_VAL_ACTY(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1(),
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ACTY_CODE_1(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME(list.get(0));
			}
			list.clear();
			list =  DBProcedures.P_VAL_ACTY(PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getUI_M_ACTY_2(), PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_ACC_ACTY_CODE_2(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_NAME_1(list.get(0));
			}
			list.clear();
			list.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void L_GET_ACTY_DETAILS(
			PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN) {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN
				.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		String CURSORC1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT"
				+ " WHERE MAIN_ACNT_CODE = ?";
		String M_ACTY_HEAD_1 = null;
		String M_ACTY_HEAD_2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSORC1, connection,
					new Object[] { PM_WAKALAH_DAILY_ACC_SETUP_BEAN
							.getWAKD_ACC_MAIN_ACNT_CODE() });
			if (resultSet.next()) {
				M_ACTY_HEAD_1 = resultSet.getString(1);
				M_ACTY_HEAD_2 = resultSet.getString(2);
			}
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void preUpdate(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN ) throws Exception {
		PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN=PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN();
		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_UPD_DT(new CommonUtils().getCurrentDate());
		
	}
	
}
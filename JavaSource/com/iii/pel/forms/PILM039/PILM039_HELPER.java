package com.iii.pel.forms.PILM039;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PILM039_HELPER {
	public Date currentDate(String dateFormat) {
		String sysdate = null;
		Date showDate=null;
		try {
			Date currentDate = new Date();

			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			sysdate = format.format(currentDate);
			showDate =format.parse(sysdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return showDate;
	}

	public String currentDateTimeStamp() {
		String sysdate = null;
		Date currentDate = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		sysdate = dateFormat.format(currentDate);
		return sysdate;
	}

	public ArrayList P_VAL_USER_ID(String obj,Connection connection) throws Exception {
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();

		ArrayList returnList = new ArrayList();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",obj);
		OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN","E");

		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_USER_ID");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext()){
				OracleParameter oracleParameter = iterator.next();
					returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			//throw new Exception(e.getMessage());
		}
		return returnList;
	}
	
	public String P_VAL_SYSTEM(Connection connection,String P_TYPE,String P_CODE,String FLAG) throws Exception {
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		String assignValue=null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", FLAG);
		OracleParameter param5 = new OracleParameter("inout2","INT","IN OUT","1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null){
					returnList.add(oracleParameter.getValue());
					assignValue =(String)returnList.get(0);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new Exception(e1.getMessage());
		}
		return assignValue;
	}

	public ArrayList<String> L_VAL_PROD(String prodCode, Connection connection, Map<String,String> errMap,Map<String,String> warningMap) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList  = new ArrayList<OracleParameter>();

		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",prodCode);
		OracleParameter param2 = new OracleParameter("inout1","STRING","OUT","");

		parameterList.add(param1);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "L_VAL_PROD");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext()){
				OracleParameter oracleParameter = iterator.next();
					returnList.add(oracleParameter.getValue());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), 
					FacesContext.getCurrentInstance(), 
					Messages.getString(PILM039_CONSTANT.messagePropertiesPILM039Path, "PILM039$PM_IL_APPR_SETUP$AS_FM_PROD_CODE$caption"), 
					errMap, 
					warningMap);
		}
		return returnList;
	}

	public String L_VAL_ENDT(String endomentCode) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList  = new ArrayList<OracleParameter>();
		String descValue = null;
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",endomentCode);
		OracleParameter param2 = new OracleParameter("inout1","STRING","OUT","");

		parameterList.add(param1);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			outputList = procHandler.execute(parameterList, connection, "PKG_PILM039.L_VAL_ENDT");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext()){
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null){
					returnList.add(oracleParameter.getValue());
					descValue =(String)returnList.get(0);
				}
			}
		} catch (SQLException e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
		}
		return descValue;
	}

	public void PRE_INSERT(String P_USER_ID,String P_PROD_FM,String P_PROD_TO) throws Exception{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList returnList = new ArrayList();
		OracleParameter param1 = new OracleParameter("in","STRING","IN",P_USER_ID);
		OracleParameter param2 = new OracleParameter("in1","STRING","IN",P_PROD_FM);
		OracleParameter param3 = new OracleParameter("in2","STRING","IN",P_PROD_TO);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);

		try {
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, CommonUtils.getConnection(), "PKG_PILM039.APPR_SETUP_PRE_INS");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext()){
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null){
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int L_UNIQUE_AS_USER_ID(String userCode, Connection connection) {
		int count = 0;
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList returnList = new ArrayList();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",userCode);

		parameterList.add(param1);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "PKG_PILM039.L_UNIQUE_AS_USER_ID");
			count =Integer.parseInt((String)outputList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void pilm039_pm_il_appr_setup_m_but_copy_when_button_pressed(PM_IL_APPR_SETUP_ACTION action) {
		CTRL_1 ctrlValueBean  = action.getCTRL_1_ACTION_BEAN().getCTRL_1_BEAN();
		PM_IL_APPR_SETUP valueBean = action.getPM_IL_APPR_SETUP_BEAN();

		ctrlValueBean.setUI_M_CP_USER_ID(valueBean.getAS_USER_ID());
		ctrlValueBean.setUI_M_CP_FM_PROD_CODE(valueBean.getAS_FM_PROD_CODE());
		ctrlValueBean.setUI_M_CP_TO_PROD_CODE(valueBean.getAS_TO_PROD_CODE());
		ctrlValueBean.setUI_M_CP_USER_ID_DESC(valueBean.getUI_M_USER_DESC());
		ctrlValueBean.setUI_M_CP_FM_PROD_CODE_DESC(valueBean.getAS_FM_PROD_CODE_DESC());
		ctrlValueBean.setUI_M_CP_TO_PROD_CODE_DESC(valueBean.getAS_TO_PROD_CODE_DESC());
		ctrlValueBean.setUI_M_CP_DEST_USER_ID(null);
		ctrlValueBean.setUI_M_CP_DEST_FM_PROD_CODE(null);
		ctrlValueBean.setUI_M_CP_DEST_TO_PROD_CODE(null);
	}

	public String pilm039_ctrl_1_m_but_ok_when_button_pressed(PM_IL_APPR_SETUP_ACTION headerAction) throws Exception {
		CTRL_1_ACTION action = headerAction.getCTRL_1_ACTION_BEAN();
		CTRL_1 valueBean = action.getCTRL_1_BEAN();
		
		PM_IL_APPR_SETUP APPR_SETUP_BEAN = headerAction.getPM_IL_APPR_SETUP_BEAN();

		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet resultSet = null;

		Connection connection = CommonUtils.getConnection();
		
		ControlBean ctrlBean = CommonUtils.getControlBean();
		//TODO removed
		if(ctrlBean == null) {
			ctrlBean = new ControlBean();
		}

		try {

			String M_CP_USER_ID=null;
			String M_WHERE=null;

			if(valueBean.getUI_M_CP_DEST_USER_ID() == null || valueBean.getUI_M_CP_DEST_FM_PROD_CODE() == null 
					|| valueBean.getUI_M_CP_DEST_TO_PROD_CODE() == null) {

				if(valueBean.getUI_M_CP_DEST_USER_ID() == null) {

					//GO_ITEM.GO_ITEM("CTRL_1.M_CP_DEST_USER_ID");
				} else if(valueBean.getUI_M_CP_DEST_FM_PROD_CODE() == null) {
					//GO_ITEM.GO_ITEM("CTRL_1.M_CP_DEST_FM_PROD_CODE");
				} else if(valueBean.getUI_M_CP_DEST_TO_PROD_CODE() == null) {
					//GO_ITEM.GO_ITEM("CTRL_1.M_CP_DEST_TO_PROD_CODE");
				}

				throw new ValidatorException(new FacesMessage(Messages.getString("com\\iii\\pel\\errorUtil\\PELErrorMessages", "11302")));

			}

			callProcL_COPY_USER_DTLS(action);
			
			ctrlBean.setM_COMM_DEL("C");
			ctrlBean.setM_COMM_DEL("");
			ctrlBean.setM_COMMIT_FLAG("");

			values = new Object[3];
			values[0] = valueBean.getUI_M_CP_DEST_USER_ID();
			values[1] = valueBean.getUI_M_CP_DEST_FM_PROD_CODE();
			values[2] = valueBean.getUI_M_CP_DEST_TO_PROD_CODE();
			
			resultSet = handler.executeSelectStatement(PILM039_QUERY_CONSTANT.FETCH_PM_IL_APPR_SETUP_COPY, connection, values);
			
			if(resultSet != null && resultSet.next()) {
				APPR_SETUP_BEAN.setROWID(resultSet.getString(1));
				APPR_SETUP_BEAN.setAS_USER_ID(resultSet.getString(2));
				APPR_SETUP_BEAN.setAS_APPR_YN(resultSet.getString(3));
				APPR_SETUP_BEAN.setAS_FAC_ENTER_YN(resultSet.getString(4));
				APPR_SETUP_BEAN.setAS_APPR_MAX_DISC_PERC(resultSet.getDouble(5));
				APPR_SETUP_BEAN.setAS_APPR_MAX_LC_DISC_AMT(resultSet.getDouble(6));
				APPR_SETUP_BEAN.setAS_APPR_ONE_DISC_PERC(resultSet.getDouble(7));
				APPR_SETUP_BEAN.setAS_APPR_ONE_LC_DISC_AMT(resultSet.getDouble(8));
				APPR_SETUP_BEAN.setAS_APPR_MAX_LC_SI(resultSet.getDouble(9));
				APPR_SETUP_BEAN.setAS_APPR_MAX_LC_CLAIM(resultSet.getDouble(10));
				APPR_SETUP_BEAN.setAS_APPR_BRK_PERC(resultSet.getDouble(11));
				APPR_SETUP_BEAN.setAS_FRZ_FLAG(resultSet.getString(12));
				APPR_SETUP_BEAN.setAS_CR_DT(resultSet.getDate(13));
				APPR_SETUP_BEAN.setAS_CR_UID(resultSet.getString(14));
				APPR_SETUP_BEAN.setAS_FM_PROD_CODE(resultSet.getString(27));
				APPR_SETUP_BEAN.setAS_TO_PROD_CODE(resultSet.getString(28));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		} catch (DBException e){
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		} finally{
			try{
				CommonUtils.closeCursor(resultSet);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return "PILM039_header";
	}

	private void callProcL_COPY_USER_DTLS(CTRL_1_ACTION action) throws SQLException, DBException {
		CRUDHandler handler = new CRUDHandler();
		CTRL_1 ctrlBean = action.getCTRL_1_BEAN(); 
		Object[] values = null;
		int rowCount = 0;

		Connection connection = CommonUtils.getConnection();

		values = new Object[6];
		values[0] = ctrlBean.getUI_M_CP_DEST_USER_ID();
		values[1] = ctrlBean.getUI_M_CP_DEST_FM_PROD_CODE();
		values[2] = ctrlBean.getUI_M_CP_DEST_TO_PROD_CODE();
		values[3] = ctrlBean.getUI_M_CP_USER_ID();
		values[4] = ctrlBean.getUI_M_CP_FM_PROD_CODE();
		values[5] = ctrlBean.getUI_M_CP_TO_PROD_CODE();
		rowCount = handler.executeInsertStatement(PILM039_QUERY_CONSTANT.INSERT_COPY_PM_IL_APPR_SETUP, connection, values);

		values = new Object[6];
		values[0] = ctrlBean.getUI_M_CP_DEST_USER_ID();
		values[1] = ctrlBean.getUI_M_CP_DEST_FM_PROD_CODE();
		values[2] = ctrlBean.getUI_M_CP_DEST_TO_PROD_CODE();
		values[3] = ctrlBean.getUI_M_CP_USER_ID();
		values[4] = ctrlBean.getUI_M_CP_FM_PROD_CODE();
		values[5] = ctrlBean.getUI_M_CP_TO_PROD_CODE();
		rowCount = handler.executeInsertStatement(PILM039_QUERY_CONSTANT.INSERT_COPY_PM_IL_APPR_DEPT_SETUP, connection, values);

		values = new Object[6];
		values[0] = ctrlBean.getUI_M_CP_DEST_USER_ID();
		values[1] = ctrlBean.getUI_M_CP_DEST_FM_PROD_CODE();
		values[2] = ctrlBean.getUI_M_CP_DEST_TO_PROD_CODE();
		values[3] = ctrlBean.getUI_M_CP_USER_ID();
		values[4] = ctrlBean.getUI_M_CP_FM_PROD_CODE();
		values[5] = ctrlBean.getUI_M_CP_TO_PROD_CODE();
		rowCount = handler.executeInsertStatement(PILM039_QUERY_CONSTANT.INSERT_COPY_PM_IL_APPR_SETUP_DET, connection, values);

		/* comment by Raja .R for do not allowed record insert to PM_IL_END_APPR_SETUP table */
		
		/*values = new Object[6];
		values[0] = ctrlBean.getUI_M_CP_DEST_USER_ID();
		values[1] = ctrlBean.getUI_M_CP_DEST_FM_PROD_CODE();
		values[2] = ctrlBean.getUI_M_CP_DEST_TO_PROD_CODE();
		values[3] = ctrlBean.getUI_M_CP_USER_ID();
		values[4] = ctrlBean.getUI_M_CP_FM_PROD_CODE();
		values[5] = ctrlBean.getUI_M_CP_TO_PROD_CODE();
		rowCount = handler.executeInsertStatement(PILM039_QUERY_CONSTANT.INSERT_COPY_PM_IL_END_APPR_SETUP, connection, values);*/
	}

	public void hePILM039_pre_insert(PM_IL_APPR_SETUP valueBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		String M_USER_ID = null;
		
		   try {
			   M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");;
			   	valueBean.setAS_CR_UID(M_USER_ID);
				valueBean.setAS_CR_DT(commonUtils.getCurrentDate());
				valueBean.setAS_APPR_YN("N");
				valueBean.setAS_FAC_ENTER_YN("N");
				valueBean.setAS_APPR_MAX_DISC_PERC(0);
				valueBean.setAS_APPR_MAX_LC_DISC_AMT(0);
				valueBean.setAS_APPR_ONE_DISC_PERC(0);
				valueBean.setAS_APPR_ONE_LC_DISC_AMT(0);
				valueBean.setAS_APPR_MAX_LC_SI(0);
				valueBean.setAS_APPR_MAX_LC_CLAIM(0);
				valueBean.setAS_APPR_BRK_PERC(0);
				valueBean.setAS_FRZ_FLAG("N");
				String userId=valueBean.getAS_USER_ID();
				String fromprodCode=valueBean.getAS_FM_PROD_CODE();
				String toProdCode=valueBean.getAS_TO_PROD_CODE();
				//calling pre-insert procedure
				PRE_INSERT(userId, fromprodCode, toProdCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void hePILM039_detail_pre_insert(PM_IL_APPR_SETUP_DET detailBean, String userId, String fromprodCode, String toProdCode) {
		
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = null;
		Connection con = null;
		ResultSet rst = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;
		String M_USER_ID = null;
		
		String selectQuery = "SELECT PS_CODE,PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_USER_PARA'";
		
		try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
					
					M_USER_ID = CommonUtils.getGlobalVariable("M_USER_ID");
					
					M_PS_CODE = rst.getString(1);
					M_PS_VALUE = rst.getString(2);
					
					detailBean.setASD_USER_ID(userId); 
					detailBean.setASD_CODE(M_PS_CODE); 
					detailBean.setASD_NUM_VALUE(0); 
					detailBean.setASD_CHAR_VALUE("N"); 
					detailBean.setASD_FLAG(M_PS_VALUE); 
					detailBean.setASD_CR_DT(commonUtils.getCurrentSQLDate()); 
					detailBean.setASD_CR_UID(M_USER_ID); 
					detailBean.setASD_UPD_DT(commonUtils.getCurrentSQLDate()); 
					detailBean.setASD_UPD_UID(M_USER_ID);
					detailBean.setASD_FM_PROD_CODE(fromprodCode);
					detailBean.setASD_TO_PROD_CODE(toProdCode);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkDuplicateRecord(PM_IL_APPR_SETUP listBean){
		boolean isCheck = false;
		String selectQuery=PILM039_QUERY_CONSTANT.PILM039_DUPLICATE_RECORD_CHECK;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		String userId = listBean.getAS_USER_ID();
		String fmCode = listBean.getAS_FM_PROD_CODE();
		String toCode = listBean.getAS_TO_PROD_CODE();
		try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				Object[] values = { userId, fmCode, toCode };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					isCheck = true;
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isCheck;
	}
	
    public void pilm039_pm_il_appr_setup_det_pre_update(PM_IL_APPR_SETUP_DET detailBean){
    	CommonUtils commonUtils = new CommonUtils();
    	String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
    	try {
			detailBean.setASD_UPD_DT(commonUtils.getCurrentDate());
			detailBean.setASD_UPD_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
    
    public void pilm039_pm_il_appr_setup_det1_pre_update(PM_IL_APPR_SETUP_DET1 detailBean){
    	CommonUtils commonUtils = new CommonUtils();
    	String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
    	try {
			detailBean.setASD_UPD_DT(commonUtils.getCurrentDate());
			detailBean.setASD_UPD_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

	public void PILM039_PM_IL_APPR_DEPT_PRE_INSERT(PM_IL_APPR_DEPT_SETUP gridValueBean) {
		CommonUtils commonUtils  = new CommonUtils();
		try {
			String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			gridValueBean.setADS_CR_DT(commonUtils.getCurrentDate());
			gridValueBean.setADS_CR_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void PILM039_PM_IL_APPR_DEPT_PRE_UPDATE(PM_IL_APPR_DEPT_SETUP gridValueBean) {
		CommonUtils commonUtils  = new CommonUtils();
		try {
			String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			gridValueBean.setADS_UPD_DT(commonUtils.getCurrentDate());
			gridValueBean.setADS_UPD_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*checked*/
	public void PM_IL_END_APPR_SETUP_pre_insert(PM_IL_END_APPR_SETUP gridValueBean) throws Exception  {
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = 
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.
			getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		try {
			checkDupliCate(gridValueBean.getEAS_AS_USER_ID(), 
						   gridValueBean.getEAS_AS_FM_PROD_CODE(),
						   gridValueBean.getEAS_AS_TO_PROD_CODE(), 
						   gridValueBean.getEAS_FM_END_CODE(),
						   gridValueBean.getEAS_TO_END_CODE(),
						   compositeAction.getPM_IL_END_APPR_SETUP_ACTION_BEAN());
			
			String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			gridValueBean.setEAS_CR_UID(M_USER_ID);
			gridValueBean.setEAS_CR_DT(commonUtils.getCurrentDate());
			gridValueBean.setEAS_AS_USER_ID(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_USER_ID());
			gridValueBean.setEAS_AS_FM_PROD_CODE(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_FM_PROD_CODE());
			gridValueBean.setEAS_AS_TO_PROD_CODE(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_TO_PROD_CODE());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*checked*/
	public void PM_IL_END_APPR_SETUP_pre_update(PM_IL_END_APPR_SETUP gridValueBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		String selectQuery=PILM039_QUERY_CONSTANT.PM_IL_END_APPR_SETUP_PRE_UPDATE;
		Object values[]=new Object[16];
		values[0]=gridValueBean.getEAS_FM_END_CODE();
		values[1]=gridValueBean.getEAS_TO_END_CODE(); 
		values[2]=gridValueBean.getEAS_FM_END_CODE();
		values[3]=gridValueBean.getEAS_TO_END_CODE();
		values[4]=gridValueBean.getEAS_FM_END_CODE();
		values[5]=gridValueBean.getEAS_TO_END_CODE(); 
		values[6]=gridValueBean.getEAS_AS_FM_PROD_CODE(); 
		values[7]=gridValueBean.getEAS_AS_TO_PROD_CODE();
		values[8]=gridValueBean.getEAS_AS_FM_PROD_CODE(); 
		values[9]=gridValueBean.getEAS_AS_TO_PROD_CODE(); 
		values[10]=gridValueBean.getEAS_AS_FM_PROD_CODE(); 
		values[11]=gridValueBean.getEAS_AS_TO_PROD_CODE(); 
		values[12]=gridValueBean.getEAS_AS_USER_ID(); 
		values[13]=gridValueBean.getROWID(); 
		values[14]=gridValueBean.getEAS_END_PROC_YN(); 
		values[15]=gridValueBean.getEAS_END_APPR_YN(); 
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		
		try {
			resultSet=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection(), values);
			
			if(resultSet.next()){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "80031");
				throw new Exception(message);
			}
			String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			gridValueBean.setEAS_UPD_UID(M_USER_ID);
			gridValueBean.setEAS_UPD_DT(commonUtils.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{
				CommonUtils.closeCursor(resultSet);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void checkDupliCate(String userId, String fromProd,String toProd, String fromEnd, String toEnd,PM_IL_END_APPR_SETUP_ACTION actionBean) throws Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();

		String procName = "PKG_PILM039.P_CHK_DUPL_END_SETUP";

		Connection connection = null;
		OracleParameter param1 = new OracleParameter("inout1", "STRING", "IN",fromEnd);
		OracleParameter param2 = new OracleParameter("inout2", "STRING", "IN",toEnd);
		OracleParameter param3 = new OracleParameter("inout3", "STRING", "IN",fromProd);
		OracleParameter param4 = new OracleParameter("inout4", "STRING", "IN",toProd);
		OracleParameter param5 = new OracleParameter("inout5", "STRING", "IN",userId);

		parameterList.add(param1);		
		parameterList.add(param2);
		parameterList.add(param3);		
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		try {
			connection = CommonUtils.getConnection();;
			outputList = procHandler.execute(parameterList, connection,procName);
/*			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
					if (returnList.size() == 0 && returnList.size() > 0){
						System.out.println("Records are there");
						checkCond = true;
					}else{
						System.out.println("Records are not there");
						checkCond = false;
						
					}
				}
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, 
					FacesContext.getCurrentInstance(),
					PILM039_CONSTANT.PM_IL_END_APPR_SETUP_ACTION,
					actionBean.getErrorMap());
			throw e;
		}
	}

	public void pilm039_pm_il_appr_setup_det_pre_insert(PM_IL_APPR_SETUP_DET detailBean) {
		CommonUtils commonUtils = new CommonUtils();
    	String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
    	try {
			detailBean.setASD_CR_DT(commonUtils.getCurrentDate());
			detailBean.setASD_CR_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void pilm039_pm_il_appr_setup_det1_pre_insert(PM_IL_APPR_SETUP_DET1 detailBean) {
		CommonUtils commonUtils = new CommonUtils();
    	String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
    	try {
			detailBean.setASD_CR_DT(commonUtils.getCurrentDate());
			detailBean.setASD_CR_UID(M_USER_ID);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Procedure Call for Unique Check added by Varun(50663)
	 * @param asUserId
	 * @param adsDivnCode
	 * @param adsDeptcode
	 * @param adsFmProdCode
	 * @param adsToProdCode
	 * @param actionBean
	 * @throws Exception
	 */
	public void L_UNIQUE_ADS_DEPT_CODE(String asUserId,String adsDivnCode,
			String adsDeptcode,String adsFmProdCode,String adsToProdCode) throws Exception{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList = new ArrayList();

		String procName = "PKG_PILM039.L_UNIQUE_ADS_DEPT_CODE";

		Connection connection = null;
		OracleParameter param1 = new OracleParameter("inout1", "STRING", "IN",asUserId);
		OracleParameter param2 = new OracleParameter("inout2", "STRING", "IN",adsDivnCode);
		OracleParameter param3 = new OracleParameter("inout3", "STRING", "IN",adsDeptcode);
		OracleParameter param4 = new OracleParameter("inout4", "STRING", "IN",adsFmProdCode);
		OracleParameter param5 = new OracleParameter("inout5", "STRING", "IN",adsToProdCode);

		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
	
		connection = CommonUtils.getConnection();
		outputList = procHandler.execute(parameterList, connection,procName);
	}

	/*my methods*/
	public void preBlockPM_IL_END_APPR_SETUP() {
		System.out.println("PILM039_HELPER.preBlockPM_IL_END_APPR_SETUP()");
		String mappedBeanName="PM_IL_APPR_SETUP_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeActionBean=
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getControlBean().setM_DELETE_MSG_FLAG("Y");
	}

	public void postQueryPM_IL_END_APPR_SETUP(ArrayList<PM_IL_END_APPR_SETUP> list) throws Exception {
		System.out.println("PILM039_HELPER.postQueryPM_IL_END_APPR_SETUP()");
		String selectQuery=PILM039_QUERY_CONSTANT.POST_QUERY_PM_IL_END_APPR_SETUP_CURSOR_C1;
		Map<String,String> codeDescMap=new HashMap<String, String>();
		CRUDHandler handler =new CRUDHandler();
		int iCount=0;
		ResultSet resultSet=null;
		try{
			
			resultSet=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection());
			while(resultSet.next()){
				codeDescMap.put(resultSet.getString("DS_CODE"), resultSet.getString("DS_DESC"));
			}
			if(list != null && list.size() > 0){
				while(iCount < list.size()){
					String fmDesc=codeDescMap.get(list.get(iCount).getEAS_FM_END_CODE());
					String toDesc=codeDescMap.get(list.get(iCount).getEAS_TO_END_CODE());
					list.get(iCount).setEAS_FM_END_CODE_DESC(fmDesc);
					list.get(iCount).setEAS_TO_END_CODE_DESC(toDesc);
					iCount++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{
				CommonUtils.closeCursor(resultSet);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void whenCreateRecord(PM_IL_END_APPR_SETUP bean) {
		bean.setEAS_END_PROC_YN("N");
		bean.setEAS_END_APPR_YN("N");
	}

	public void validateEAS_FM_END_CODE(PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN) throws Exception{
		try {
			String desc=L_VAL_ENDT(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE());
			if(desc !=null){
				PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE_DESC(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateEAS_TO_END_CODE(PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN) throws Exception{
		try{
			String desc=L_VAL_ENDT(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE());
			if(desc !=null){
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE_DESC(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateEAS_END_PROC_YN(String currentValue){
		
		String mappedBeanName="PM_IL_APPR_SETUP_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeActionBean=
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_END_APPR_SETUP_ACTION actionBean=compositeActionBean.getPM_IL_END_APPR_SETUP_ACTION_BEAN();
		int currIndex=actionBean.getDataTable().getRowIndex();
		if("Y".equals(actionBean.getList().get(currIndex).getEAS_END_APPR_YN())){
			actionBean.getList().get(currIndex).setEAS_END_PROC_YN("Y");
		}
	}
	
	public void whenListChangedEAS_END_PROC_YN(PM_IL_END_APPR_SETUP valueBean,String currentValue) throws Exception{
		valueBean.setEAS_END_PROC_YN(currentValue);
		if("Y".equals(valueBean.getEAS_END_APPR_YN())  &&
				"N".equals(valueBean.getEAS_END_PROC_YN())){
			valueBean.setEAS_END_PROC_YN("Y");
			String message="Endt Process cannot be NO when End Apprv flag is YES";
			throw new Exception(message);
		}
	}
	
	public void whenListChangedEAS_END_APPR_YN(PM_IL_END_APPR_SETUP valueBean,String currentValue){
		valueBean.setEAS_END_APPR_YN(currentValue);
		if("Y".equals(currentValue)){
			valueBean.setEAS_END_PROC_YN("Y");
		}
	}

	public void validateAS_FM_PROD_CODE(String currentValue) throws Exception {
		System.out.println("PILM039_HELPER.validateAS_FM_PROD_CODE()");
		
		String mappedBeanName="PM_IL_APPR_SETUP_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeActionBean=
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPR_SETUP_ACTION actionBean=compositeActionBean.getPM_IL_APPR_SETUP_ACTION_BEAN();
		PM_IL_APPR_SETUP valueBean=actionBean.getPM_IL_APPR_SETUP_BEAN();
		
		try {
			//setting code field to current value so the currnet value is shown when 
			//table is reRendered
			valueBean.setAS_FM_PROD_CODE(currentValue);
			
			if(currentValue == null || currentValue.trim().isEmpty()){
				valueBean.setAS_FM_PROD_CODE("0");
				actionBean.getCOMP_AS_FM_PROD_CODE().resetValue();
				valueBean.setAS_FM_PROD_CODE_DESC(null);
				actionBean.getCOMP_AS_FM_PROD_CODE_DESC().resetValue();
			}
			List<String> descList=L_VAL_PROD(valueBean.getAS_FM_PROD_CODE(), 
					CommonUtils.getConnection(),
					actionBean.getErrorMap(),
					actionBean.getWarningMap());
			if(descList != null && descList.size() >0){
				
				valueBean.setAS_FM_PROD_CODE_DESC(descList.get(0));
				actionBean.getCOMP_AS_FM_PROD_CODE_DESC().resetValue();
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateAS_TO_PROD_CODE(String currentValue) throws Exception{
		System.out.println("PILM039_HELPER.validateAS_TO_PROD_CODE()");
		
		String mappedBeanName="PM_IL_APPR_SETUP_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> valueList = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeActionBean=
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPR_SETUP_ACTION actionBean=compositeActionBean.getPM_IL_APPR_SETUP_ACTION_BEAN();
		PM_IL_APPR_SETUP valueBean=actionBean.getPM_IL_APPR_SETUP_BEAN();
		//setting code field to current value so the current value is shown when 
		//table is reRendered
		valueBean.setAS_TO_PROD_CODE(currentValue);
		String fromCode=valueBean.getAS_FM_PROD_CODE();
		
		if(currentValue == null || currentValue.trim().isEmpty()){
			if("0".equals(fromCode)){
				valueBean.setAS_TO_PROD_CODE("zzzzzzzzzzzz");
				actionBean.getCOMP_AS_TO_PROD_CODE().resetValue();
				valueBean.setAS_TO_PROD_CODE_DESC(null);
				actionBean.getCOMP_AS_TO_PROD_CODE_DESC().resetValue();
			}else{
				valueBean.setAS_TO_PROD_CODE(fromCode);
				actionBean.getCOMP_AS_TO_PROD_CODE().resetValue();
				valueBean.setAS_TO_PROD_CODE_DESC(valueBean.getAS_TO_PROD_CODE_DESC());
				actionBean.getCOMP_AS_TO_PROD_CODE_DESC().resetValue();
			}
		}
		try {
			valueList = procedures.callPR_VALIDATE_FM_TO(fromCode, currentValue, "");

			if(valueList != null && valueList.size() > 0 && valueList.get(0).equals("1")){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "10064"));
			}
			
			List<String> descList=L_VAL_PROD(valueBean.getAS_TO_PROD_CODE(),CommonUtils.getConnection(),actionBean.getErrorMap(),actionBean.getWarningMap());
			if(descList != null && descList.size() >0){
				
				valueBean.setAS_TO_PROD_CODE_DESC(descList.get(0));
				actionBean.getCOMP_AS_TO_PROD_CODE().resetValue();
			}
			CHECK_DUPLICATE(valueBean.getAS_USER_ID(), valueBean.getAS_FM_PROD_CODE(), 
					valueBean.getAS_TO_PROD_CODE(),valueBean.getROWID());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	//Method shifted from delegate to helper
	public void CHECK_DUPLICATE(String userId, String fromCode, String toCode, String rowid)throws Exception {
		String selectQuery = PILM039_QUERY_CONSTANT.CHECK_DUPLICATE_RECORD;
		int count = 0; 
		String tempRowid = null;

		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		Object[] values = { fromCode, toCode, fromCode, toCode, fromCode,toCode, userId };
		try {
			rst = handler.executeSelectStatement(selectQuery,CommonUtils.getConnection(), values);
			while (rst.next()) {
				tempRowid = rst.getString("ROWID");
				if(rowid == null){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80031"));
				}else if(!rowid.equals(tempRowid)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80031"));
				}
			}
			/*if (rst.next()) {
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

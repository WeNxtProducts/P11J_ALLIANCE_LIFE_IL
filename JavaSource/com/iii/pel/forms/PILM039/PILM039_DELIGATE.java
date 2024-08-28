package com.iii.pel.forms.PILM039;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PILM039_DELIGATE {
	/*public String L_VAL_ENDT(String endomentCode) {
		String descValue = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		try {
			descValue = helper.L_VAL_ENDT(endomentCode, CommonUtils.getConnection());
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return descValue;
	}*/

	public String P_VAL_USER_ID_Validation() throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String message = null;
		String errorDisplay = PILM039_QUERY_CONSTANT.ERRORCODE;
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(errorDisplay,
					connection);
			while (resultSet.next()) {
				message = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
				throw new Exception(e.getMessage());
			}
		}
		return message;
	}

	public List P_VAL_USER_ID(String userId) throws Exception {
		PILM039_HELPER helper = new PILM039_HELPER();
		ArrayList list = null;
		try {
			list = helper.P_VAL_USER_ID(userId, CommonUtils.getConnection());
		} catch (DBException e) {
			e.printStackTrace();
			//ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}
		return list;
	}

	/*public List<String> L_VAL_PROD(String prodCode) throws UserApprovalException {
		PILM039_HELPER helper = new PILM039_HELPER();
		ArrayList<String> list = null;
		try {
			list = helper.L_VAL_PROD(prodCode, CommonUtils.getConnection());
		} catch (DBException e) {
			e.printStackTrace();
		}

		return list;
	}*/

	public void L_POPULATE_DIVN_DEPT() {

		String M_DIVN_CODE = null;
		String M_DEPT_CODE = null;
		String M_DUMMY = null;
		String sql_C1 = PILM039_QUERY_CONSTANT.FETCH_DIVISIONCODE;
		String sql_C2 = PILM039_QUERY_CONSTANT.FETCH_DEPTCODE;
		String sql_s3 = PILM039_QUERY_CONSTANT.CHECK_DEPT_VALUE_IS_THERE;

		CRUDHandler handler = new CRUDHandler();
		CRUDHandler handler1 = new CRUDHandler();
		CRUDHandler handler2 = new CRUDHandler();
		CRUDHandler insertHandler = new CRUDHandler();

		CommonUtils commonUtils =new CommonUtils();
		Connection connection = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		String ads_user_id;
		String ads_divn_code;
		String ads_dept_code;
		String ads_fm_prod_code;
		String ads_to_prod_code;
		ResultSet rst =null;
		ResultSet rst1 =null;
		ResultSet rst3 =null;

		try {
			connection = CommonUtils.getConnection();;
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			rst = handler.executeSelectStatement(sql_C1, connection);
			if (rst.next()) {
				M_DIVN_CODE = rst.getString(1);
			}
			if (rst.isAfterLast() || rst.isBeforeFirst())
				return;
			Object[] values = { M_DIVN_CODE };
			rst1 = handler1.executeSelectStatement(sql_C2,
					connection, values);
			if (rst1.next()) {
				M_DEPT_CODE = rst1.getString(1);
			}
			if (rst1.isAfterLast() || rst1.isBeforeFirst())
				return;

			ads_user_id = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_USER_ID();
			ads_divn_code = compositeAction.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN().getPM_IL_APPR_DEPT_SETUP_BEAN().getADS_DIVN_CODE();
			ads_dept_code = compositeAction.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN().getPM_IL_APPR_DEPT_SETUP_BEAN().getADS_DEPT_CODE();
			ads_fm_prod_code = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_FM_PROD_CODE();
			ads_to_prod_code = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_TO_PROD_CODE();
			Object[] values1 = { ads_user_id, ads_divn_code, ads_dept_code,ads_fm_prod_code, ads_to_prod_code };

			rst3 = handler2.executeSelectStatement(sql_s3,connection, values1);
			if (rst.next()) {
				M_DUMMY = rst3.getString(1);
			}
			if (rst3.isAfterLast() || rst3.isBeforeFirst()) {
				int row = insertHandler.executeInsert("", connection);
				if (row == 0){
				}else{
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String P_VAL_ENDT_DESC(String endosmentCode) {
		String fetchDescrption = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = PILM039_QUERY_CONSTANT.FETCH_P_ENDT_DESC;
		Object[] values = { endosmentCode };
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();;
			rst = handler.executeSelectStatement(selectQuery,connection, values);
			while (rst.next()) {
				fetchDescrption = rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fetchDescrption;
	}

	public String P_VAL_SYSTEM(String P_CODE, String FLAG) throws Exception {
		String assignDescValue = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		try {
			assignDescValue = helper.P_VAL_SYSTEM(CommonUtils.getConnection(),"IL_USER_PARA", P_CODE, FLAG);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return assignDescValue;
	}

	public String ON_VALIDATE_DIVN_CODE(String divinCode) {
		String assignDescValue = null;
		String selectQuery = PILM039_QUERY_CONSTANT.FETCH_DIVISION_DESC;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			Object[] values = { divinCode };
			connection = CommonUtils.getConnection();;
			 rst = handler.executeSelectStatement(selectQuery,connection, values);
			if (rst.next()) {
				assignDescValue = rst.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignDescValue;
	}

	public String ON_VALIDATE_DEPT_CODE(String divinName, String deptCode) {
		String assignDescValue = null;
		String selectQuery = PILM039_QUERY_CONSTANT.FETCH_DEPT_NAME;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			Object[] values = { divinName, deptCode };
			connection = CommonUtils.getConnection();;
			rst = handler.executeSelectStatement(selectQuery,connection, values);
			if (rst.next()) {
				assignDescValue = rst.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignDescValue;
	}
	public boolean L_UNIQUE_AS_USER_ID(String userId) {
		boolean isCheck = false;
		PILM039_HELPER helper = new PILM039_HELPER();
		try {
			int count = helper.L_UNIQUE_AS_USER_ID(userId, CommonUtils.getConnection());
			if (count == 1){
				isCheck = true;
			}else{
				isCheck = false;
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isCheck;
	}
	
	//Method shifted to helper class
	/*	public void CHECK_DUPLICATE(String userId, String fromCode, String toCode)throws Exception {
			String selectQuery = PILM039_QUERY_CONSTANT.CHECK_DUPLICATE_RECORD;

			CRUDHandler handler = new CRUDHandler();
			ResultSet rst = null;
			Object[] values = { fromCode, toCode, fromCode, toCode, fromCode,toCode, userId };
			try {
				rst = handler.executeSelectStatement(selectQuery,CommonUtils.getConnection(), values);
				if (rst.next()) {
					String checkValue = rst.getString(1);
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
				}
//				if (rst.next()) {
//					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
//				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}		finally{
				if(rst!=null){
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}*/

		/*public int checkInsert(PM_IL_APPR_SETUP valueBean){
			int rowCount = 0;
			PILM039_HELPER helper =new PILM039_HELPER();
			boolean isDuplicate = false;
			CommonUtils commonUtils = new CommonUtils();
			try {
				String userId = valueBean.getAS_USER_ID();
				String fromprodCode = valueBean.getAS_FM_PROD_CODE();
				String toProdCode = valueBean.getAS_TO_PROD_CODE();
				isDuplicate = helper.checkDuplicateRecord(valueBean);
				if(!isDuplicate){
					helper.PRE_INSERT(userId, fromprodCode, toProdCode);
//					commonUtils.doComitt();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return rowCount;
		}*/

	public List userIdList(String query,Object[] values) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		Connection con;
		ResultSet rs = null;
		try {
			con = CommonUtils.getConnection();
			PILM039_UserCodeLov lov=null;
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(query, con,values);
			
			while(rs.next()){
				lov = new PILM039_UserCodeLov();
				lov.setUSER_CODE(rs.getString(1));
				lov.setUSER_DESC(rs.getString(2));
				list.add(lov);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List fromProductCodeList(String selectQuery,Object[] values) throws UserApprovalException, SQLException{
		List list =new ArrayList();
		Connection connection;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			PILM039_UserCodeLov lov=null;
			CRUDHandler handler =new CRUDHandler();
			rst =handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				lov =new PILM039_UserCodeLov();
				lov.setFROM_PRODUCT_CODE(rst.getString(1));
				lov.setFROM_PRODUCT_DESC(rst.getString(2));
				list.add(lov);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List toProductCodeList(String selectQuery,Object[] values) throws UserApprovalException, SQLException{
		List list =new ArrayList();
		Connection connection;
		ResultSet rs = null;
		try {
			connection = CommonUtils.getConnection();
			PILM039_UserCodeLov lov=null;
			CRUDHandler handler =new CRUDHandler();
			rs =handler.executeSelectStatement(selectQuery, connection, values);
			while(rs.next()){
				lov =new PILM039_UserCodeLov();
				lov.setTO_PRODUCT_CODE(rs.getString(1));
				lov.setTO_PRODUCT_DESC(rs.getString(2));
				list.add(lov);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public List divisionCodeList(String selectQuery,Object[] values) throws UserApprovalException, SQLException
	{
		List list =new ArrayList();
		Connection connection;
		ResultSet rs = null;
		try {
			connection = CommonUtils.getConnection();
			PILM039_UserCodeLov lov=null;
			CRUDHandler handler =new CRUDHandler();
			rs =handler.executeSelectStatement(selectQuery, connection, values);
			while(rs.next()){
				lov =new PILM039_UserCodeLov();
				lov.setDIVI_CODE(rs.getString(1));
				lov.setDIVI_DESC(rs.getString(2));
				list.add(lov);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List deptCodeList(String selectQuery,Object[] values) throws UserApprovalException, SQLException
	{
		List list =new ArrayList();
		Connection connection;
		ResultSet rs = null;
		try {
			connection = CommonUtils.getConnection();
			PILM039_UserCodeLov lov=null;
			CRUDHandler handler =new CRUDHandler();
			rs =handler.executeSelectStatement(selectQuery, connection, values);
			while(rs.next()){
				lov =new PILM039_UserCodeLov();
				lov.setDEPT_CODE(rs.getString(1));
				lov.setDEPT_DESC(rs.getString(2));
				list.add(lov);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int checkUserId(String userId) {
		int rowCount = 0;
		String selectQuery=PILM039_QUERY_CONSTANT.CHECK_USER_ID;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery);
			if (resultSet.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	
	public Object fetchUserGroup(String userId) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_APPR_SETUP userSetupBean = new PM_IL_APPR_SETUP();
		String selectQuery=PILM039_QUERY_CONSTANT.FECTH_USER_GROUP;
		ResultSet resultSet = null;
		Object[] values = {userId};
		
		try {
			connection = CommonUtils.getConnection();
			 resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			while(resultSet.next()){
				userSetupBean.setUSER_GROUP_ID(resultSet.getString(1));
				userSetupBean.setUI_M_USER_DESC(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userSetupBean;
	}
	
	public Object fetchFromProductDesc(String fromProductId) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_SETUP userSetupBean = new PM_IL_APPR_SETUP();
		String selectQuery = PILM039_QUERY_CONSTANT.FETCH_FROM_PRODUCT_CODE_DESC;
		ResultSet rst = null;
		
		Object[] values = {fromProductId};
		try {
			connection =CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			
			if (rst.next()) {
				userSetupBean.setAS_FM_PROD_CODE_DESC(rst.getString(1));
			} else {
				userSetupBean.setAS_FM_PROD_CODE_DESC("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userSetupBean;
	}
	
	public Object fetchToProductDesc(String toProductCode) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_SETUP userSetupBean = new PM_IL_APPR_SETUP();
		String selectQuery=PILM039_QUERY_CONSTANT.FETCH_TO_PRODUCT_CODE_DESC;
		ResultSet rst = null;
		Object[] values = {toProductCode};
		
		try {
			connection =CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			
			if (rst.next()) {
				userSetupBean.setAS_TO_PROD_CODE_DESC(rst.getString(1));
			} else {
				userSetupBean.setAS_TO_PROD_CODE_DESC("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userSetupBean;
	}
	
	public Object fetchDEPTDESC(String divCode, String comCode, String deptCode) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_DEPT_SETUP objBean = new PM_IL_APPR_DEPT_SETUP();
		String selectQuery=PILM039_QUERY_CONSTANT.FETCH_DEPTNAME_FROM_DIVCODE;
		ResultSet rst = null;
		Object[] values = {divCode, deptCode,comCode};
		
		try {
			connection = CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			if (rst.next()) {
				objBean.setUI_M_DEPT_NAME(rst.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return objBean;
	}
	public Object fetchDIVDESC(String divCode, String compCode) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_DEPT_SETUP objBean = new PM_IL_APPR_DEPT_SETUP();
		ResultSet rst = null;
		String selectQuery=PILM039_QUERY_CONSTANT.FETCTH_DIVIDION_DESC;
		
		Object[] values = {divCode};
		try {
			connection =CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			while(rst.next())
			{
				objBean.setUI_M_DIVN_NAME(rst.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return objBean;
	}

	public String loadValues(String userId, String fromCode, String toCode) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		String valueString = null;
		String selectQuery=PILM039_QUERY_CONSTANT.LOAD_DIVISION_VALUES;
		Object[] values = {userId,fromCode,toCode};
		ResultSet rst = null;
		try {
			connection =CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			while(rst.next())
			{
				valueString= rst.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valueString;
	}
	public Object assignAllValues() {
		Connection connection=null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_DEPT_SETUP objBean = new PM_IL_APPR_DEPT_SETUP();
		//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION and PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
		//String sqlQuery = "select DEPT_DIVN_CODE,DIVN_NAME,DIVN_CODE,DEPT_CODE from PM_DIVISION,PM_DEPARTMENT";
		String sqlQuery = "select DEPT_DIVN_CODE,DIVN_NAME,DIVN_CODE,DEPT_CODE from FM_DIVISION,FM_DEPARTMENT";
		Object[] values = {};
		ResultSet resultSet = null;
		
		try {
			connection =CommonUtils.getConnection();;
			resultSet =handler.executeSelectStatement(sqlQuery, connection,values);
			if (resultSet.next()) {
				objBean.setADS_DIVN_CODE(resultSet.getString(1));
				objBean.setUI_M_DIVN_NAME(resultSet.getString(2));
				objBean.setADS_DEPT_CODE(resultSet.getString(3));
				objBean.setUI_M_DEPT_NAME(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return objBean;
	}
	
	public ArrayList<PM_IL_END_APPR_SETUP> loadSuggestionValues(PM_IL_END_APPR_SETUP_ACTION action)
	{
		PM_IL_END_APPR_SETUP details = null;
		ArrayList<PM_IL_END_APPR_SETUP> detailsList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_END_APPR_SETUP detailValueBean=null;
		String fromEndosCode=null;
		String selectQuery=PILM039_QUERY_CONSTANT.PILM039_ENDOWMENT_SUGGESTIONBOX_ALL_VALUES;
		ResultSet rst = null;
		
		if(action != null)
		{
			detailValueBean =action.getPM_IL_END_APPR_SETUP_BEAN();
			fromEndosCode =detailValueBean.getEAS_FM_END_CODE();
		}
		if(!fromEndosCode.equalsIgnoreCase("*")){
			selectQuery = selectQuery + "%"; 
		}else{
			selectQuery = selectQuery;
		}
		Object[] values={};
		
		try {
			connection =CommonUtils.getConnection();
			detailsList =new ArrayList<PM_IL_END_APPR_SETUP>();
			rst =handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next())
			{
				details =new PM_IL_END_APPR_SETUP();
					
				details.setEAS_FM_END_CODE(rst.getString(1));
				details.setEAS_FM_END_CODE_DESC(rst.getString(2));
				
				detailsList.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailsList;
	}
	
	public ArrayList<PM_IL_APPR_DEPT_SETUP> loadDeptAndBranchValues(PM_IL_APPR_SETUP_ACTION action){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_APPR_DEPT_SETUP details = null;
		ArrayList<PM_IL_APPR_DEPT_SETUP> detailsList = null;
		PM_IL_APPR_SETUP objBean =action.getPM_IL_APPR_SETUP_BEAN();
		String userId =objBean.getAS_USER_ID();
		String fromCode=objBean.getAS_FM_PROD_CODE();
		String toCode =objBean.getAS_TO_PROD_CODE();
		ResultSet rst = null;
		String selectQuery = PILM039_QUERY_CONSTANT.LOAD_DIVISION_VALUE_LINK_CLICK_QUERY;
				
		Object[] values = {userId, fromCode,toCode};
		PCOPK_SYS_VARS pcopk_sys_vars = new PCOPK_SYS_VARS();
		try {
			connection = CommonUtils.getConnection();;
			rst = handler.executeSelectStatement(selectQuery, connection,values);
			
			//added by dhinesh on 07-05-2016 for branch and department code doesn't exist issue
			pcopk_sys_vars.P_SET_PARA_VALUES(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"), CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DEPT_CODE"), CommonUtils.getControlBean()
					.getM_BASE_CURR(), "2", CommonUtils.getControlBean()
					.getM_PROG_NAME());
			
			detailsList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
		
			while (rst.next()) {
				details = new PM_IL_APPR_DEPT_SETUP();

				details.setROWID(rst.getString(1));
				details.setADS_USER_ID(rst.getString("ADS_USER_ID"));
				details.setADS_DIVN_CODE(rst.getString("ADS_DIVN_CODE"));
				details.setADS_DEPT_CODE(rst.getString("ADS_DEPT_CODE"));
				details.setADS_FRZ_FLAG(rst.getString("ADS_FRZ_FLAG"));
				details.setADS_CR_DT(rst.getDate("ADS_CR_DT"));
				details.setADS_CR_UID(rst.getString("ADS_CR_UID"));
				details.setADS_UPD_DT(rst.getDate("ADS_UPD_DT"));
				details.setADS_UPD_UID(rst.getString("ADS_UPD_UID"));
				details.setADS_FM_PROD_CODE(rst.getString("ADS_FM_PROD_CODE"));
				details.setADS_TO_PROD_CODE(rst.getString("ADS_TO_PROD_CODE"));
				
				details.setUI_M_DIVN_NAME(new DBProcedures().callP_VAL_DIVN(
						details.getADS_DIVN_CODE(), "N", "N").get(0));

				details.setUI_M_DEPT_NAME(new DBProcedures().callP_VAL_DEPT(
						details.getADS_DIVN_CODE(), details.getADS_DEPT_CODE(),
						"N", "N").get(0));

				detailsList.add(details);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailsList;
	}
		
	public ArrayList<SelectItem> selectValueForComboBox(){
		Connection connection=null;
		CRUDHandler handler =new CRUDHandler();
		ArrayList<SelectItem> drpDwn = null;
		String selectQuery =PILM039_QUERY_CONSTANT.FETCH_COMBO_VALUE;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();;
			Object[] values = {"PILM039"};
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			drpDwn =new ArrayList<SelectItem>();
			while(rst.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(rst.getString(1));
				selectItem.setLabel(rst.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}

	public ArrayList<PM_IL_APPR_SETUP> fetchSearchDetails(PM_IL_APPR_SETUP_SEARCH_ACTION action) {
		PM_IL_APPR_SETUP details = null;
		ArrayList<PM_IL_APPR_SETUP> detailsList = null;
		Connection connection =null;
		CRUDHandler handler =new CRUDHandler();
		
		String userId= action.getInitUserId().toString();
		String fromCode=action.getInitFromCode().toString();
		String toCode=action.getInitToCode().toString();
		ResultSet rst = null;
		userId   = userId==null || userId.trim().isEmpty()?userId:userId+"%";
		fromCode = fromCode==null || fromCode.trim().isEmpty()?fromCode:fromCode+"%";
		toCode   = toCode==null || toCode.trim().isEmpty()?toCode:toCode+"%";
		
		String selectQuery = PILM039_QUERY_CONSTANT.LOAD_SEARCH_VALUE_QUERY;
		Object[] values = {userId,fromCode,toCode};
		if(action != null){
			try {
				connection=CommonUtils.getConnection();;
				if(connection != null){
					detailsList =new ArrayList<PM_IL_APPR_SETUP>();
					rst =handler.executeSelectStatement(selectQuery, connection,values);
					while(rst.next()){
						details =new PM_IL_APPR_SETUP();
						
						details.setROWID(rst.getString(6));
						details.setAS_USER_ID(rst.getString(1));
						details.setAS_FM_PROD_CODE(rst.getString(2));
						details.setAS_TO_PROD_CODE(rst.getString(3));
						details.setUSER_GROUP_ID(rst.getString(4));
						details.setUI_M_USER_DESC(rst.getString(5));
						
						String fromDesc = fetchProductCodeDesc(rst.getString(2));
						String toDesc = fetchProductCodeDesc(rst.getString(3));
						details.setAS_FM_PROD_CODE_DESC(fromDesc);
						details.setAS_TO_PROD_CODE_DESC(toDesc);
						
						detailsList.add(details);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			} finally{
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return detailsList;
	}
	
	public String fromProdDesc(String codeValue) throws UserApprovalException, SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String prodDesc=null;
		String sqlQuery = "SELECT DISTINCT(prod_desc) FROM pm_il_product,  pm_il_appr_setup WHERE prod_code = AS_FM_PROD_CODE AND AS_FM_PROD_CODE = '"
				+ codeValue + "'";
		
		try {
			connection = CommonUtils.getConnection();
			if(connection != null){
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					prodDesc =resultSet.getString(1);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return prodDesc;
	}
	public String toProdDesc(String codeValue) throws UserApprovalException, SQLException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String prodDesc=null;
		String sqlQuery = "SELECT DISTINCT(prod_desc) FROM pm_il_product,  pm_il_appr_setup WHERE prod_code = AS_TO_PROD_CODE AND AS_TO_PROD_CODE = '"
				+ codeValue + "'";
		
		try {
			connection = CommonUtils.getConnection();
			if(connection != null){
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					prodDesc =resultSet.getString(1);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return prodDesc;
	}

	public ArrayList<PM_IL_APPR_SETUP_DET> loadRightsValues(
			PM_IL_APPR_SETUP_ACTION action,String ASD_APPR_GRP) {
		Connection connection = null;
		PM_IL_APPR_SETUP_DET details=null;
		PILM039_HELPER helper = new PILM039_HELPER();

		ResultSet rst = null;
		CRUDHandler handler =new CRUDHandler();
		ArrayList<PM_IL_APPR_SETUP_DET> detailsList=null;
		PM_IL_APPR_SETUP tempBean =null;
		if(action !=null){
			tempBean =action.getPM_IL_APPR_SETUP_BEAN();
		}
		String userId =tempBean.getAS_USER_ID().toString();
		String fromProdCode=tempBean.getAS_FM_PROD_CODE().toString();
		String toProcCode =tempBean.getAS_TO_PROD_CODE().toString();
		
		String selectQuery=PILM039_QUERY_CONSTANT.ASD_APPR_GRP_FETCH_RECORD_BASED_RIGHTS;
		Object[] values = {userId, fromProdCode,toProcCode};
		
		if(userId!=null && !userId.trim().isEmpty() 
				&& fromProdCode!=null && !fromProdCode.trim().isEmpty()
				&& toProcCode!=null && !toProcCode.trim().isEmpty()) {
			try {
				connection = CommonUtils.getConnection();;
				 rst =handler.executeSelectStatement(selectQuery, connection,values);
				detailsList =new ArrayList<PM_IL_APPR_SETUP_DET>();
				boolean recordsFetched = false;
				while (rst.next()) {
					recordsFetched = true;
					details = new PM_IL_APPR_SETUP_DET();
					
					details.setROWID(rst.getString(1));
					details.setASD_USER_ID(rst.getString("ASD_USER_ID"));
					details.setASD_CODE(rst.getString("ASD_CODE"));
					details.setASD_NUM_VALUE(rst.getDouble("ASD_NUM_VALUE"));
					details.setASD_CHAR_VALUE(rst.getString("ASD_CHAR_VALUE"));
					details.setASD_FLAG(rst.getString("ASD_FLAG"));
					details.setASD_CR_DT(rst.getDate("ASD_CR_DT"));
					details.setASD_CR_UID(rst.getString("ASD_CR_UID"));
					details.setASD_UPD_DT(rst.getDate("ASD_UPD_DT"));
					details.setASD_UPD_UID(rst.getString("ASD_UPD_UID"));
					details.setASD_FM_PROD_CODE(rst.getString("ASD_FM_PROD_CODE"));
					details.setASD_TO_PROD_CODE(rst.getString("ASD_TO_PROD_CODE"));
					details.setUI_M_ASD_CODE_DESC(rst.getString("PS_CODE_DESC"));
					// Added by Shankar Bodduluri 
					details.setASD_APPR_GRP(rst.getString("ASD_APPR_GRP"));
					
					detailsList.add(details);
				}
				
				if(!recordsFetched){
					if(rst != null){
						rst.close();
					}
					//helper.PRE_INSERT(userId, fromProdCode, toProcCode);
					rst =handler.executeSelectStatement(selectQuery, connection,values);
					
					while (rst.next()) {
						details = new PM_IL_APPR_SETUP_DET();
						
						details.setROWID(rst.getString(1));
						details.setASD_USER_ID(rst.getString("ASD_USER_ID"));
						details.setASD_CODE(rst.getString("ASD_CODE"));
						details.setASD_NUM_VALUE(rst.getDouble("ASD_NUM_VALUE"));
						details.setASD_CHAR_VALUE(rst.getString("ASD_CHAR_VALUE"));
						details.setASD_FLAG(rst.getString("ASD_FLAG"));
						details.setASD_CR_DT(rst.getDate("ASD_CR_DT"));
						details.setASD_CR_UID(rst.getString("ASD_CR_UID"));
						details.setASD_UPD_DT(rst.getDate("ASD_UPD_DT"));
						details.setASD_UPD_UID(rst.getString("ASD_UPD_UID"));
						details.setASD_FM_PROD_CODE(rst.getString("ASD_FM_PROD_CODE"));
						details.setASD_TO_PROD_CODE(rst.getString("ASD_TO_PROD_CODE"));
						details.setUI_M_ASD_CODE_DESC(rst.getString("PS_CODE_DESC"));
						
						// Added by Shankar Bodduluri 
						details.setASD_APPR_GRP(rst.getString("ASD_APPR_GRP"));
						
						detailsList.add(details);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			} finally{
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
				
		return detailsList;
	}
	
	public ArrayList<PM_IL_APPR_SETUP_DET1> loadLimitsValues(
			PM_IL_APPR_SETUP_ACTION action,String ASD_APPR_GRP) {
		Connection connection = null;
		PM_IL_APPR_SETUP_DET1 details=null;
		CRUDHandler handler =new CRUDHandler();
		ArrayList<PM_IL_APPR_SETUP_DET1> detailsList=null;
		ResultSet rst = null;

		PM_IL_APPR_SETUP tempBean =action.getPM_IL_APPR_SETUP_BEAN();
		String userId =tempBean.getAS_USER_ID().toString();
		String fromProdCode=tempBean.getAS_FM_PROD_CODE().toString();
		String toProcCode =tempBean.getAS_TO_PROD_CODE().toString();
		
		String selectQuery=PILM039_QUERY_CONSTANT.ASD_APPR_GRP_FETCH_RECORD_BASED_LIMITS;
		
		Object[] values = { userId, fromProdCode, toProcCode };
		try {
			connection =CommonUtils.getConnection();
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			detailsList =new ArrayList<PM_IL_APPR_SETUP_DET1>();
			boolean recordsFetched = false;

			while (rst.next()) {
				recordsFetched = true;
				details = new PM_IL_APPR_SETUP_DET1();

				details.setROWID(rst.getString(1));
				details.setASD_USER_ID(rst.getString("ASD_USER_ID"));
				details.setASD_CODE(rst.getString("ASD_CODE"));
				details.setASD_NUM_VALUE(rst.getDouble("ASD_NUM_VALUE"));
				details.setASD_CHAR_VALUE(rst.getString("ASD_CHAR_VALUE"));
				details.setASD_FLAG(rst.getString("ASD_FLAG"));
				details.setASD_CR_DT(rst.getDate("ASD_CR_DT"));
				details.setASD_CR_UID(rst.getString("ASD_CR_UID"));
				details.setASD_UPD_DT(rst.getDate("ASD_UPD_DT"));
				details.setASD_UPD_UID(rst.getString("ASD_UPD_UID"));
				details.setASD_FM_PROD_CODE(rst.getString("ASD_FM_PROD_CODE"));
				details.setASD_TO_PROD_CODE(rst.getString("ASD_TO_PROD_CODE"));
				details.setUI_M_ASD_CODE_DESC(rst.getString("PS_CODE_DESC"));
				
				details.setASD_APPR_GRP(rst.getString("ASD_APPR_GRP"));
				
				
				detailsList.add(details);
			}
			if(!recordsFetched){
				if (rst != null) {
					rst.close();
				}
			//	helper.PRE_INSERT(userId, fromProdCode, toProcCode);
				rst =handler.executeSelectStatement(selectQuery, connection,values);
				while(rst.next()){
					details = new PM_IL_APPR_SETUP_DET1();

					details.setROWID(rst.getString(1));
					details.setASD_USER_ID(rst.getString("ASD_USER_ID"));
					details.setASD_CODE(rst.getString("ASD_CODE"));
					details.setASD_NUM_VALUE(rst.getDouble("ASD_NUM_VALUE"));
					details.setASD_CHAR_VALUE(rst.getString("ASD_CHAR_VALUE"));
					details.setASD_FLAG(rst.getString("ASD_FLAG"));
					details.setASD_CR_DT(rst.getDate("ASD_CR_DT"));
					details.setASD_CR_UID(rst.getString("ASD_CR_UID"));
					details.setASD_UPD_DT(rst.getDate("ASD_UPD_DT"));
					details.setASD_UPD_UID(rst.getString("ASD_UPD_UID"));
					details.setASD_FM_PROD_CODE(rst.getString("ASD_FM_PROD_CODE"));
					details.setASD_TO_PROD_CODE(rst.getString("ASD_TO_PROD_CODE"));
					details.setUI_M_ASD_CODE_DESC(rst.getString("PS_CODE_DESC"));
					
					details.setASD_APPR_GRP(rst.getString("ASD_APPR_GRP"));
					
					detailsList.add(details);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailsList;
	}
	
	public String descriptionProcedure(String codeValue){
		String assignName = null;
		Connection connection = null;
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleProcedureHandler handler =new OracleProcedureHandler();
		OracleParameter param1 =new OracleParameter("in1","String","IN","IL_USER_PARA");
		OracleParameter param2 =new OracleParameter("in2","String","IN",codeValue);
		OracleParameter param3 =new OracleParameter("in3","String","IN OUT","");
		OracleParameter param4 =new OracleParameter("in4","String","IN","N");
		OracleParameter param5 =new OracleParameter("in5","String","IN OUT","");
		
		paramList.add(param1);paramList.add(param2);paramList.add(param3);paramList.add(param4);paramList.add(param5);
		
		try {
			connection =CommonUtils.getConnection();
			ArrayList list =handler.execute(paramList, connection, "PCOPK_SYS_VARS.P_VAL_SYSTEM");
			assignName =(String) list.get(1);
		} catch (UserApprovalException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return assignName;
	}

	//Shifted to helper
/*	public String pilm039_pm_il_end_appr_setup_post_query(String endosmentCode){
		String fetchDescrption = null;
		Connection connection =null;
		CRUDHandler handler =new CRUDHandler();
		String selectQuery = "SELECT DS_DESC FROM  PM_IL_DOC_SETUP  WHERE  DS_CODE  =? AND DS_TYPE  = '3' ";
		Object[] values = {endosmentCode};
		ResultSet rst = null;
		try {
			connection =CommonUtils.getConnection();
			 rst =handler.executeSelectStatement(selectQuery, connection,values);
			if(rst.next()){
				fetchDescrption =rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
		}
		return fetchDescrption;
	}*/
	
	public String pilm039_pm_il_end_appr_setup_pre_update(){
		PM_IL_APPR_SETUP setupBean = null;
		PM_IL_END_APPR_SETUP endSetupBean=null;
		String userid =setupBean.getAS_USER_ID();
		String fromProdId =setupBean.getAS_FM_PROD_CODE();
		String toProdId =setupBean.getAS_TO_PROD_CODE();
		String fromEndos =endSetupBean.getEAS_FM_END_CODE();
		String toEndos =endSetupBean.getEAS_TO_END_CODE();
		String prodYN =endSetupBean.getEAS_END_PROC_YN();
		String apprYN =endSetupBean.getEAS_END_APPR_YN();
		Connection connection=null;
		CRUDHandler handler =new CRUDHandler();
		String conditionCheck=null; 
		ResultSet rst = null;
		
		String selectQuery="SELECT 'X' FROM pm_il_end_appr_setup WHERE('"+fromEndos+"' BETWEEN eas_fm_end_code"+
							" AND eas_to_end_code OR '"+toEndos+"' BETWEEN eas_fm_end_code AND eas_to_end_code OR eas_fm_end_code BETWEEN '"+fromEndos+"'"+
							"AND '"+toEndos+"' OR eas_to_end_code BETWEEN '"+fromEndos+"' AND '"+toEndos+"')"+
							"AND('"+fromProdId+"' BETWEEN eas_as_fm_prod_code AND eas_as_to_prod_code OR '"+toProdId+"' BETWEEN eas_as_fm_prod_code"+
							" AND eas_as_to_prod_code OR eas_as_fm_prod_code BETWEEN '"+fromProdId+"'"+
							" AND '"+toProdId+"' OR eas_as_to_prod_code BETWEEN '"+fromProdId+"'AND '"+toProdId+"')"+
							" AND eas_as_user_id = '"+userid+"' AND eas_end_proc_yn = '"+prodYN+"'"+
							" AND eas_end_appr_yn = '"+apprYN+"'";
		
		Object[] values = {fromEndos, toEndos,fromEndos,toEndos,fromEndos,toEndos,fromProdId,toProdId,fromProdId,toProdId,fromProdId,toProdId,userid,prodYN,apprYN};
		
		try 
		{
			connection =CommonUtils.getConnection();
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			if(rst.next()){
				conditionCheck =rst.getString(1);
			}
			if(rst.isLast()){
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conditionCheck;
		
	}
	
/*	public ArrayList<PM_IL_END_APPR_SETUP> loadProcessEndosmentValues(PM_IL_APPR_SETUP_ACTION action){
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		PM_IL_APPR_SETUP tempBean =action.getPM_IL_APPR_SETUP_BEAN();
		
		PM_IL_END_APPR_SETUP details=null;
		ArrayList<PM_IL_END_APPR_SETUP> detailsList=null;
		
		String userId =tempBean.getAS_USER_ID().toString();
		String fromProdCode=tempBean.getAS_FM_PROD_CODE().toString();
		String toProdCode =tempBean.getAS_TO_PROD_CODE().toString();
		
		String selectQuery=PILM039_QUERY_CONSTANT.ENDOSMENT_FETCH_QUERY;	
		ResultSet rst = null;
			
			Object[] values={userId,fromProdCode,toProdCode,};
		try {
			connection =CommonUtils.getConnection();
			if(connection != null){
				detailsList =new ArrayList<PM_IL_END_APPR_SETUP>();
				rst =handler.executeSelectStatement(selectQuery, connection,values);
				String fromEndDesc =null;
				String toEndDesc =null;
				while(rst.next()){
					details =new PM_IL_END_APPR_SETUP();
					details.setROWID(rst.getString(1));
					
						
						details.setEAS_AS_USER_ID(rst.getString("EAS_AS_USER_ID"));
						details.setEAS_AS_FM_PROD_CODE(rst.getString("EAS_AS_FM_PROD_CODE"));
						details.setEAS_AS_TO_PROD_CODE(rst.getString("EAS_AS_TO_PROD_CODE"));
						details.setEAS_END_PROC_YN(rst.getString("EAS_END_PROC_YN"));
						details.setEAS_END_APPR_YN(rst.getString("EAS_END_APPR_YN"));
						details.setEAS_CR_DT(rst.getDate("EAS_CR_DT"));
						details.setEAS_CR_UID(rst.getString("EAS_CR_UID"));
						details.setEAS_UPD_DT(rst.getDate("EAS_UPD_DT"));
						details.setEAS_UPD_UID(rst.getString("EAS_UPD_UID"));
						details.setEAS_FM_END_CODE(rst.getString("EAS_FM_END_CODE"));
						details.setEAS_TO_END_CODE(rst.getString("EAS_TO_END_CODE"));
						details.setEAS_SYS_ID(rst.getShort("EAS_SYS_ID"));
						
						fromEndDesc=pilm039_pm_il_end_appr_setup_post_query(rst.getString("EAS_FM_END_CODE"));
						toEndDesc=pilm039_pm_il_end_appr_setup_post_query(rst.getString("EAS_TO_END_CODE"));
						
						details.setEAS_FM_END_CODE_DESC(fromEndDesc);
						details.setEAS_TO_END_CODE_DESC(toEndDesc);
					detailsList.add(details);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			if (rst != null) {
				try {
					CommonUtils.closeCursor(rst);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return detailsList;
	}*/
	
	
	public ArrayList<PM_IL_END_APPR_SETUP> loadProcessEndosmentValues() throws Exception{
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		
		String mappedBeanName="PM_IL_APPR_SETUP_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeActionBean=
			(PM_IL_APPR_SETUP_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		PM_IL_APPR_SETUP valueBean =compositeActionBean.getPM_IL_APPR_SETUP_ACTION_BEAN()
				.getPM_IL_APPR_SETUP_BEAN();
		
		PM_IL_END_APPR_SETUP details=null;
		ArrayList<PM_IL_END_APPR_SETUP> detailsList=null;
		
		String userId =valueBean.getAS_USER_ID();
		String fromProdCode=valueBean.getAS_FM_PROD_CODE();
		String toProdCode =valueBean.getAS_TO_PROD_CODE();
		
		String selectQuery=PILM039_QUERY_CONSTANT.ENDOSMENT_FETCH_QUERY;	
		ResultSet rst = null;
			
			Object[] values={userId,fromProdCode,toProdCode,};
		try {
			connection =CommonUtils.getConnection();
			if(connection != null){
				detailsList =new ArrayList<PM_IL_END_APPR_SETUP>();
				rst =handler.executeSelectStatement(selectQuery, connection,values);
//				String fromEndDesc =null;
//				String toEndDesc =null;
				while(rst.next()){
					details =new PM_IL_END_APPR_SETUP();
					details.setROWID(rst.getString(1));
					
						
						details.setEAS_AS_USER_ID(rst.getString("EAS_AS_USER_ID"));
						details.setEAS_AS_FM_PROD_CODE(rst.getString("EAS_AS_FM_PROD_CODE"));
						details.setEAS_AS_TO_PROD_CODE(rst.getString("EAS_AS_TO_PROD_CODE"));
						details.setEAS_END_PROC_YN(rst.getString("EAS_END_PROC_YN"));
						details.setEAS_END_APPR_YN(rst.getString("EAS_END_APPR_YN"));
						details.setEAS_CR_DT(rst.getDate("EAS_CR_DT"));
						details.setEAS_CR_UID(rst.getString("EAS_CR_UID"));
						details.setEAS_UPD_DT(rst.getDate("EAS_UPD_DT"));
						details.setEAS_UPD_UID(rst.getString("EAS_UPD_UID"));
						details.setEAS_FM_END_CODE(rst.getString("EAS_FM_END_CODE"));
						details.setEAS_TO_END_CODE(rst.getString("EAS_TO_END_CODE"));
						details.setEAS_SYS_ID(rst.getDouble("EAS_SYS_ID"));
						
						//Desc will be set after fetching the values in post query
//						fromEndDesc=pilm039_pm_il_end_appr_setup_post_query(rst.getString("EAS_FM_END_CODE"));
//						toEndDesc=pilm039_pm_il_end_appr_setup_post_query(rst.getString("EAS_TO_END_CODE"));
//						
//						details.setEAS_FM_END_CODE_DESC(fromEndDesc);
//						details.setEAS_TO_END_CODE_DESC(toEndDesc);
					detailsList.add(details);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailsList;
	}
	
	public String pilm039_pm_il_end_appr_setup_eas_end_appr_yn_when_list_changed(String EAS_END_APPR_YN)
	{
		String EAS_END_PROC_YN = null;
		if(EAS_END_APPR_YN.equalsIgnoreCase("Y"))
			EAS_END_PROC_YN="Y";
		else
			EAS_END_PROC_YN="N";
			
		return EAS_END_PROC_YN;
	}
	
	 /**
	  * Prepares City Code List
	  * @param connection
	  * @param endosmentCode
	  * @param endosmentList
	  * @return
	  */
	 public List<PM_IL_END_APPR_SETUP> prepareEndowmentList(String endosmentCode, List endosmentList) {
		String selectQuery = null;
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(endosmentCode)) {
				selectQuery = PILM039_QUERY_CONSTANT.PILM039_ENDOWMENT_SUGGESTIONBOX_ALL_VALUES;
				Object[] object = {};
				endosmentList = cityLOV(connection, selectQuery, object);
			} else {
				selectQuery = PILM039_QUERY_CONSTANT.PILM039_ENDOWMENT_SUGGESTIONBOX_LIKE_VALUE;
				endosmentCode = endosmentCode + "%";
				Object[] object = { endosmentCode };
				endosmentList = cityLOV(connection, selectQuery, object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return endosmentList;
	}
	 
	/**
	 * List returning City Lov containing code and its description
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_END_APPR_SETUP> cityLOV(Connection connection,String query,Object[] object) {
		List<PM_IL_END_APPR_SETUP> cityCodeList=new ArrayList<PM_IL_END_APPR_SETUP>();
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_END_APPR_SETUP details=new PM_IL_END_APPR_SETUP();
				
				details.setEAS_FM_END_CODE(resultSet.getString(1));
				details.setEAS_FM_END_CODE_DESC(resultSet.getString(2));
				
				cityCodeList.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cityCodeList;
	}
	 
	 /**
	  * Returns City Description for  Code and codeList
	  * @param cityCode
	  * @param cityCodeList
	  * @return
	  */
	 public String getCityDescforCode(String endowmentCode,List endowmentList)
	 {
	 	Iterator iterator=endowmentList.iterator();
	 	String cityDesc=null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_END_APPR_SETUP details=(PM_IL_END_APPR_SETUP)iterator.next();
	 		if(endowmentCode.equalsIgnoreCase(details.getEAS_FM_END_CODE()))
	 		{
	 			cityDesc=details.getEAS_FM_END_CODE();
	 		}
	 	}
	 	return cityDesc;
	 }
	 
	 public int updateDataDET(PM_IL_APPR_SETUP_DET detailBean) throws Exception{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(detailBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	 
	/*public int deleteData(PM_IL_APPR_SETUP_DET detailsBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}*/

	 
	 /*checked*/
	 public int updateData(PM_IL_END_APPR_SETUP detailBean) throws Exception{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(detailBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	 
	/*checked*/
	public int deleteData(PM_IL_END_APPR_SETUP detailsBean){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	/*checked*/
	public void doCommit() throws Exception{
		System.out.println("PILM039_DELIGATE.doCommit()");
		CommonUtils util=new CommonUtils();
		try {
			util.doComitt();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void insertEndowmentValues() {
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		
		PM_IL_END_APPR_SETUP endowmentBean,valueBean = null;
		PM_IL_APPR_SETUP detailBean =null;
		Connection connection=null;
		CRUDHandler handler =new CRUDHandler();
			
		valueBean =new PM_IL_END_APPR_SETUP();
		endowmentBean =compositeAction.getPM_IL_END_APPR_SETUP_ACTION_BEAN().getPM_IL_END_APPR_SETUP_BEAN();
		
		detailBean = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		Date currDate =new Date();
		
		valueBean.setEAS_AS_USER_ID(detailBean.getAS_USER_ID());
		valueBean.setEAS_AS_FM_PROD_CODE(detailBean.getAS_FM_PROD_CODE());
		valueBean.setEAS_AS_TO_PROD_CODE(detailBean.getAS_TO_PROD_CODE());
		valueBean.setEAS_CR_DT(currDate);
		valueBean.setEAS_UPD_DT(currDate);
		valueBean.setEAS_CR_UID(detailBean.getAS_USER_ID());
		valueBean.setEAS_UPD_UID(detailBean.getAS_USER_ID());
		valueBean.setEAS_END_APPR_YN(endowmentBean.getEAS_END_APPR_YN());
		valueBean.setEAS_END_PROC_YN(endowmentBean.getEAS_END_PROC_YN());
		valueBean.setEAS_TO_END_CODE(endowmentBean.getEAS_TO_END_CODE());
		valueBean.setEAS_FM_END_CODE(endowmentBean.getEAS_FM_END_CODE());
		//valueBean.setEAS_SYS_ID(0);
			
		try {
			connection =CommonUtils.getConnection();
			int row =handler.executeInsert(valueBean, connection);
			if(row == 0){
				System.out.println("Not Inserted");
			} else{
				System.out.println("Inserted");
			}
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
		
	
	public void preInsertEndorsment(PM_IL_END_APPR_SETUP valueBean) throws Exception{
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		PM_IL_APPR_SETUP detailBean =null;
		try{
		detailBean = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		valueBean.setEAS_AS_USER_ID(detailBean.getAS_USER_ID());
		valueBean.setEAS_AS_FM_PROD_CODE(detailBean.getAS_FM_PROD_CODE());
		valueBean.setEAS_AS_TO_PROD_CODE(detailBean.getAS_TO_PROD_CODE());
		valueBean.setEAS_CR_DT(new CommonUtils().getCurrentDate());
		valueBean.setEAS_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}	
	
	
	public void preUpdateEndorsment(PM_IL_END_APPR_SETUP valueBean) throws Exception{
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		PM_IL_APPR_SETUP detailBean =null;
		try{
		detailBean = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		valueBean.setEAS_AS_USER_ID(detailBean.getAS_USER_ID());
		valueBean.setEAS_AS_FM_PROD_CODE(detailBean.getAS_FM_PROD_CODE());
		valueBean.setEAS_AS_TO_PROD_CODE(detailBean.getAS_TO_PROD_CODE());
		valueBean.setEAS_UPD_DT(new CommonUtils().getCurrentDate());
		valueBean.setEAS_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}	
	
	
	
	public int updateDataDEPT(PM_IL_APPR_DEPT_SETUP detailBean) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(detailBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	
	public int deleteDataDEPT(PM_IL_APPR_DEPT_SETUP detailsBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
		 
	public int updateDataDET1(PM_IL_APPR_SETUP_DET1 detailBean) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(detailBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
		 
	public int deleteDataDET1(PM_IL_APPR_SETUP_DET1 detailsBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public ArrayList<PM_IL_APPR_DEPT_SETUP> getDivnLov(String string) throws Exception{
		String query = PILM039_QUERY_CONSTANT.LOV_DIVISION_CODE;
		Connection conn = null;
		ArrayList<PM_IL_APPR_DEPT_SETUP> codeList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_IL_APPR_DEPT_SETUP custBean = null;
		Object[] values = {};
		
		try {
			conn = CommonUtils.getConnection();
			if(string != null){
				string = string.trim();
				if(!string.equals("*")){
					query = PILM039_QUERY_CONSTANT.LOV_DIVISION_CODE_CONDITIONAL;
					values = new Object[2];
					values[0] = string+"%";
					values[1] = string+"%";
				}
			}
			
			resultSet = handler.executeSelectStatement(query, conn, values);
			while(resultSet.next()){
				custBean = new PM_IL_APPR_DEPT_SETUP();
				custBean.setADS_DIVN_CODE(resultSet.getString("DIVN_CODE"));
				custBean.setUI_M_DIVN_NAME(resultSet.getString("DIVN_NAME"));
				codeList.add(custBean);
			}
			if(codeList == null || codeList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public ArrayList<PM_IL_APPR_DEPT_SETUP> getDeptLov(String string, String DIV_CODE) throws Exception{
		String query = PILM039_QUERY_CONSTANT.LOV_DEPARTMENT_CODE;
		Connection conn = null;
		ArrayList<PM_IL_APPR_DEPT_SETUP> codeList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_IL_APPR_DEPT_SETUP deptBean = null;
		
		try {
			conn = CommonUtils.getConnection();
			if(string != null){
				string = string.trim();
				if(!string.equals("*")){
					query = query.replace("{0}", " AND DEPT_CODE LIKE '"+string+"%'");
				}else{
					query = query.replace("{0}", "");
				}
			}
			
			resultSet = handler.executeSelectStatement(query, conn, new Object[]{DIV_CODE});
			while(resultSet.next()){
				deptBean = new PM_IL_APPR_DEPT_SETUP();
				deptBean.setADS_DEPT_CODE(resultSet.getString("DEPT_CODE"));
				deptBean.setUI_M_DEPT_NAME(resultSet.getString("DEPT_NAME"));
				codeList.add(deptBean);
			}
			if(codeList == null){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public int updateDetailBean(PM_IL_APPR_SETUP_DET detailBean) {
		int rowUpdate = 0;
		Connection con = null;
		CRUDHandler handler = null;
		
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				
				rowUpdate = handler.executeUpdate(detailBean, con);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return rowUpdate;
	}

	public String fetchProductCodeDesc(String productCode) {
		String assignValue = "";
		String selectQuery="SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = { productCode };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					assignValue = rst.getString(1);
					if(assignValue== null){
						assignValue = "";
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignValue;
	}
	public void pilm039_pm_il_appr_setup_pre_update(PM_IL_APPR_SETUP valueBean) throws Exception{
        String fmProdId = valueBean.getAS_FM_PROD_CODE();
        String toProdId = valueBean.getAS_TO_PROD_CODE();
        String userId = valueBean.getAS_USER_ID();
        String rowId = valueBean.getROWID();
        String M_DUMMY=null;
        Connection con = null;            
        ResultSet rst = null;
        CRUDHandler handler = null;
        CommonUtils commonUtils = new CommonUtils();
    	String selectQuery="SELECT 'X' FROM  PM_IL_APPR_SETUP  WHERE ('"+fmProdId+"'  BETWEEN AS_FM_PROD_CODE  AND  AS_TO_PROD_CODE  OR '"+toProdId+"'  BETWEEN AS_FM_PROD_CODE  AND  AS_TO_PROD_CODE  OR AS_FM_PROD_CODE  BETWEEN '"+fmProdId+"'  AND  '"+toProdId+"'  OR AS_TO_PROD_CODE  BETWEEN '"+fmProdId+"'  AND  '"+toProdId+"' )  AND AS_USER_ID  = '"+userId+"'  AND ROWID  != '"+rowId+"' ";
    	
    	try {
			con  = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
	                M_DUMMY=rst.getString(1);
	                throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
				}
				/*if(rst.next()){
	                throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
				}*/
				
				// Commented becoz header block is made non updateable now.....
				
				/*PM_IL_APPR_SETUP prevRecord=fetchPrevValues(valueBean.getROWID());
				String prevFromProdCode=prevRecord.getAS_FM_PROD_CODE();
				String prevToProdCode=prevRecord.getAS_FM_PROD_CODE();
				String prevUserID = prevRecord.getAS_USER_ID();
				
				UPDATE_DIVISION(fmProdId, toProdId,userId,prevFromProdCode,prevToProdCode,prevUserID);
				UPDATE_DETAILS_DET(fmProdId, toProdId,userId,prevFromProdCode,prevToProdCode,prevUserID);
				UPDATE_DETAILS_ENDT(fmProdId, toProdId, userId,prevFromProdCode,prevToProdCode,prevUserID);*/
				valueBean.setAS_UPD_DT(commonUtils.getCurrentDate());
				valueBean.setAS_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			try{
				CommonUtils.closeCursor(rst);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
    }
	    
	public PM_IL_APPR_SETUP fetchPrevValues(String rowId) throws Exception{
    	String selectQuery=PILM039_QUERY_CONSTANT.SELECT_PM_IL_APPR_SETUP_BY_ROW_ID;
    	Object [] values=new Object[1];
    	values[0]=rowId;
    	CRUDHandler handler=new CRUDHandler();
    	ResultSet resultSet=null;
    	PM_IL_APPR_SETUP bean=new PM_IL_APPR_SETUP();
    	
    	try {
			resultSet=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection(),values);
			if(resultSet != null && resultSet.next()){
				bean.setAS_FM_PROD_CODE(resultSet.getString("AS_FM_PROD_CODE"));
				bean.setAS_TO_PROD_CODE(resultSet.getString("AS_TO_PROD_CODE"));
				bean.setAS_USER_ID(resultSet.getString("AS_USER_ID"));
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
		
    	return bean;
    }
	
	public void UPDATE_DETAILS_DET(String P_AS_FM_PROD_CODE,String P_AS_TO_PROD_CODE,String userId, String prevFromProdCode, String prevToProdCode, String prevUserID){
    	Connection con = null;
    	CRUDHandler handler = null;
    	ResultSet rst = null;
        String M_DUMMY=null;
        String selectQuery="SELECT 'X' FROM  PM_IL_APPR_SETUP_DET  WHERE  " +
        		" ASD_USER_ID  = '"+userId+"'  " +
        		" AND ASD_FM_PROD_CODE  = NVL('"+P_AS_FM_PROD_CODE+"', '0')  " +
        		" AND ASD_TO_PROD_CODE  = NVL('"+P_AS_TO_PROD_CODE+"', 'ZZZZZZZZZZZZ') ";
        String updateQuery="UPDATE   PM_IL_APPR_SETUP_DET    " +
        		" SET ASD_USER_ID = '"+ userId+ "', ASD_FM_PROD_CODE = '"+P_AS_FM_PROD_CODE+"',      " +
        		" ASD_TO_PROD_CODE = '"+P_AS_TO_PROD_CODE+"'   " +
        		" WHERE  ASD_USER_ID  = '"+prevUserID+"'  " +
        		" AND ASD_FM_PROD_CODE = '"+prevFromProdCode+"'   " +
        		" AND  ASD_TO_PROD_CODE ='"+prevToProdCode+"'";
        try {
        	con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
                    M_DUMMY=rst.getString(1);
                    handler.executeUpdateStatement(updateQuery, con);
                }
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
	
	public void UPDATE_DETAILS_ENDT(String P_AS_FM_PROD_CODE,String P_AS_TO_PROD_CODE,String userId, String prevFromProdCode, String prevToProdCode, String prevUserID){
    	Connection con = null;
    	CRUDHandler handler = null;
    	ResultSet rst = null;
        String M_DUMMY=null;
    	String selectQuery="SELECT 'X' FROM  PM_IL_END_APPR_SETUP  WHERE  EAS_AS_USER_ID  = '"+userId+"'  AND EAS_AS_FM_PROD_CODE  = NVL('"+P_AS_FM_PROD_CODE+"', '0')  AND EAS_AS_TO_PROD_CODE  = NVL('"+P_AS_TO_PROD_CODE+"', 'ZZZZZZZZZZZZ') ";
        String updateQuery="UPDATE   PM_IL_END_APPR_SETUP    " +
        		" SET EAS_AS_USER_ID = '"+ userId +"', EAS_AS_FM_PROD_CODE = '"+P_AS_FM_PROD_CODE+"',  " +
        		" EAS_AS_TO_PROD_CODE = '"+P_AS_TO_PROD_CODE+"'  " +
        		" WHERE  EAS_AS_USER_ID  = '"+prevUserID+"'  " +
        		" AND EAS_AS_FM_PROD_CODE= '"+prevFromProdCode+"'" +
        		" AND EAS_AS_TO_PROD_CODE= '"+prevToProdCode+"'";
    	try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
                    M_DUMMY=rst.getString(1);
                    handler.executeUpdateStatement(updateQuery, con);
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
	
	private void UPDATE_DIVISION(String P_AS_FM_PROD_CODE,String P_AS_TO_PROD_CODE,String userId, String prevFromProdCode, String prevToProdCode, String prevUserID){
    	Connection con = null;
    	CRUDHandler handler = null;
    	ResultSet rst = null;
        String M_DUMMY=null;
    	String selectQuery="SELECT 'X' FROM  PM_IL_APPR_DEPT_SETUP  WHERE  ADS_USER_ID  = '"+userId+"'  AND ADS_FM_PROD_CODE  = NVL('"+P_AS_FM_PROD_CODE+"', '0')  AND ADS_TO_PROD_CODE  = NVL('"+P_AS_TO_PROD_CODE+"', 'ZZZZZZZZZZZZ') ";
        String updateQuery="UPDATE   PM_IL_APPR_DEPT_SETUP    " +
        		" SET ADS_USER_ID = '"+ userId +"', ADS_FM_PROD_CODE = '"+P_AS_FM_PROD_CODE+"',  " +
        		" ADS_TO_PROD_CODE = '"+P_AS_TO_PROD_CODE+"'  " +
        		" WHERE  ADS_USER_ID  = '"+prevUserID+"'  " +
        		" AND ADS_FM_PROD_CODE= '"+prevFromProdCode+"'" +
        		" AND ADS_TO_PROD_CODE= '"+prevToProdCode+"'";
    	try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
                    M_DUMMY=rst.getString(1);
                    handler.executeUpdateStatement(updateQuery, con);
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

	public void updatePILM039Setup(PM_IL_APPR_SETUP valueBean) {
		Connection con = null;
    	CRUDHandler handler = null;
    	try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				handler.executeInsert(valueBean,con);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void fetchUpprovalDetailValues(PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction){
		PM_IL_APPR_SETUP detailBean = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String selectQuery = "select pm_il_appr_setup.ROWID, pm_il_appr_setup.* from pm_il_appr_setup where ROWID = ? "; 
		String userGroup = null;
		String userDesc = null;
		
		try {
			con  = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = {compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getROWID()};
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					
					detailBean = new PM_IL_APPR_SETUP();
					detailBean.setROWID(rst.getString(1));
					
					detailBean.setAS_USER_ID(rst.getString("AS_USER_ID"));
					detailBean.setAS_APPR_YN(rst.getString("AS_APPR_YN"));
					detailBean.setAS_FAC_ENTER_YN(rst.getString("AS_FAC_ENTER_YN"));
					detailBean.setAS_APPR_MAX_DISC_PERC(rst.getDouble("AS_APPR_MAX_DISC_PERC"));
					detailBean.setAS_APPR_MAX_LC_DISC_AMT(rst.getDouble("AS_APPR_MAX_LC_DISC_AMT"));
					detailBean.setAS_APPR_ONE_DISC_PERC(rst.getDouble("AS_APPR_ONE_DISC_PERC"));
					detailBean.setAS_APPR_ONE_LC_DISC_AMT(rst.getDouble("AS_APPR_ONE_LC_DISC_AMT"));
					detailBean.setAS_APPR_MAX_LC_SI(rst.getDouble("AS_APPR_MAX_LC_SI"));
					detailBean.setAS_APPR_MAX_LC_CLAIM(rst.getDouble("AS_APPR_MAX_LC_CLAIM"));
					detailBean.setAS_APPR_BRK_PERC(rst.getDouble("AS_APPR_BRK_PERC"));
					detailBean.setAS_FRZ_FLAG(rst.getString("AS_FRZ_FLAG"));
					detailBean.setAS_CR_DT(rst.getDate("AS_CR_DT"));
					detailBean.setAS_CR_UID(rst.getString("AS_CR_UID"));
					detailBean.setAS_UPD_DT(rst.getDate("AS_UPD_DT"));
					detailBean.setAS_UPD_UID(rst.getString("AS_UPD_UID"));
					detailBean.setAS_CLM_REOPEN_YN(rst.getString("AS_CLM_REOPEN_YN"));
					detailBean.setAS_RENEWAL_YN(rst.getString("AS_RENEWAL_YN"));
					detailBean.setAS_NO_OF_CLAIMS(rst.getDouble("AS_NO_OF_CLAIMS"));
					detailBean.setAS_REINST_POL_YN(rst.getString("AS_REINST_POL_YN"));
					detailBean.setAS_MOD_ACC_FLAG_YN(rst.getString("AS_MOD_ACC_FLAG_YN"));
					detailBean.setAS_ISS_DT_BACK_DATED_YN(rst.getString("AS_ISS_DT_BACK_DATED_YN"));
					detailBean.setAS_BACK_DATED_UPTO_NO_OF_DAYS(rst.getDouble("AS_BACK_DATED_UPTO_NO_OF_DAYS"));
					detailBean.setAS_POL_DEL_YN(rst.getString("AS_POL_DEL_YN"));
					detailBean.setAS_PROP_APPR_YN(rst.getString("AS_PROP_APPR_YN"));
					detailBean.setAS_REPRINT_YN(rst.getString("AS_REPRINT_YN"));
					detailBean.setAS_FM_PROD_CODE(rst.getString("AS_FM_PROD_CODE"));
					detailBean.setAS_TO_PROD_CODE(rst.getString("AS_TO_PROD_CODE"));
					
					
					
					
					userGroup = getUserGroup(rst.getString("AS_USER_ID"));
					detailBean.setUSER_GROUP_ID(userGroup);
					userDesc = getUserGroupDesc(rst.getString("AS_USER_ID"), userGroup);
					detailBean.setUI_M_USER_DESC(userDesc);
					
					
					String fromDesc = fetchProductCodeDesc(rst.getString("AS_FM_PROD_CODE"));
					String toDesc = fetchProductCodeDesc(rst.getString("AS_TO_PROD_CODE"));
					detailBean.setAS_FM_PROD_CODE_DESC(fromDesc);
					detailBean.setAS_TO_PROD_CODE_DESC(toDesc);
					compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().setPM_IL_APPR_SETUP_BEAN(detailBean);
					
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				CommonUtils.closeCursor(rst);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
		
	public String fetchProductDesc(String toProductCode) {
		Connection connection = null;
		CRUDHandler handler =new CRUDHandler();
		String procudtDesc = null;
		String selectQuery = "SELECT DISTINCT(PROD_DESC) FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		ResultSet rst = null;
		Object[] values = {toProductCode};
		try {
			connection =CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection,values);
			if (rst.next()) {
				procudtDesc = rst.getString(1);
				procudtDesc = procudtDesc==null ? "" : procudtDesc;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return procudtDesc;
	}
		
	public String getUserGroup(String userId) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String assignUserGroup = null;
		String selectQuery=PILM039_QUERY_CONSTANT.FECTH_USER_GROUP;
		ResultSet resultSet = null;
		Object[] values = {userId};
		try {
			connection = CommonUtils.getConnection();
			 resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			while(resultSet.next()){
				assignUserGroup = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignUserGroup;
	}
	
	public String getUserGroupDesc(String userId,String groupId) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String assignUserGroup = null;
		String selectQuery= " SELECT DISTINCT(user_desc) FROM menu_user,pm_il_appr_setup WHERE user_id = as_user_id AND as_user_id = ? and user_group_id= ?";
		ResultSet resultSet = null;
		Object[] values = {userId,groupId};
		try {
			connection = CommonUtils.getConnection();
			 resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			while(resultSet.next()){
				assignUserGroup = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignUserGroup;
	}
	
	/**
	 * returns LOV for EAS_FM_END_CODE
	 * @param string
	 * @return
	 */
	/*checked*/
	public List<PM_IL_END_APPR_SETUP> getEndApplLov(Object string) {
		String selectQuery = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND  NVL(DS_FRZ_FLAG ,'N') ='N' {0} ORDER BY 1 ASC";
		ArrayList<PM_IL_END_APPR_SETUP> suggestionList = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		PM_IL_END_APPR_SETUP lovBean = null;
		
		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("{0}", "");
		}else{
			selectQuery = selectQuery.replace("{0}", " AND DS_CODE LIKE '"+string+"%'");
		}
		try {
			con = CommonUtils.getConnection();
			suggestionList = new ArrayList<PM_IL_END_APPR_SETUP>();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					lovBean = new PM_IL_END_APPR_SETUP();
						lovBean.setEAS_FM_END_CODE(rst.getString("DS_CODE"));
						lovBean.setEAS_FM_END_CODE_DESC(rst.getString("DS_DESC"));
						lovBean.setEAS_TO_END_CODE(rst.getString("DS_CODE"));
						lovBean.setEAS_TO_END_CODE_DESC(rst.getString("DS_DESC"));
						suggestionList.add(lovBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
		//similar method to get LOV written above...From and to fields
		/*public List<PM_IL_END_APPR_SETUP> getToApplLov(Object string) {
			String selectQuery = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND  NVL(DS_FRZ_FLAG ,'N') ='N' {0} ORDER BY 1 ASC";
			ArrayList<PM_IL_END_APPR_SETUP> lovConditionList = null;
			Connection con = null;
			CRUDHandler handler = null;
			ResultSet rst = null;
			PM_IL_END_APPR_SETUP lovBean = null;
			if ("*".equals(string)) {
				selectQuery = selectQuery.replace("{0}", "");
			}else{
				selectQuery = selectQuery.replace("{0}", " AND DS_CODE LIKE '"+string+"%'");
			}
			try {
				con = CommonUtils.getConnection();
				lovConditionList = new ArrayList<PM_IL_END_APPR_SETUP>();
				if(con != null){
					handler = new CRUDHandler();
					rst = handler.executeSelectStatement(selectQuery, con);
					while(rst.next()){
						lovBean = new PM_IL_END_APPR_SETUP();
							lovBean.setEAS_TO_END_CODE(rst.getString("DS_CODE"));
							lovBean.setEAS_TO_END_CODE_DESC(rst.getString("DS_DESC"));
						lovConditionList.add(lovBean);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return lovConditionList;
		}*/
		
		
		/*public ArrayList<PM_IL_END_APPR_SETUP> getEndApplLov(String string) throws Exception {
			String query = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND  NVL(DS_FRZ_FLAG ,'N') ='N' {0}";
			Connection conn = null;
			ArrayList<PM_IL_END_APPR_SETUP> codeList = new ArrayList<PM_IL_END_APPR_SETUP>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			PM_IL_END_APPR_SETUP custBean = null;
			
			try {
				conn = CommonUtils.getConnection();
				
					string = string.trim();
					if(!string.equals("*")){
						query = query.replace("", "AND DS_CODE LIKE '"+string+"%'");
					}else{
						query = query.replace("{0}", "");
					}
				
				resultSet = handler.executeSelectStatement(query, conn);
				while(resultSet.next()){
					custBean = new PM_IL_END_APPR_SETUP();
					custBean.setEAS_FM_END_CODE(resultSet.getString("DS_CODE"));
					custBean.setEAS_FM_END_CODE_DESC(resultSet.getString("DS_DESC"));
					codeList.add(custBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
						CommonUtils.closeCursor(resultSet);
			}
			return codeList;
		}
		public ArrayList<PM_IL_END_APPR_SETUP> getToApplLov(String string) throws Exception {
			String query = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND  NVL(DS_FRZ_FLAG ,'N') ='N' {0}";
			Connection conn = null;
			ArrayList<PM_IL_END_APPR_SETUP> codeList = new ArrayList<PM_IL_END_APPR_SETUP>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			PM_IL_END_APPR_SETUP custBean = null;
			
			try {
				conn = CommonUtils.getConnection();
				if(string != null){
					string = string.trim();
					if(!string.equals("*")){
						query = query.replace("", "AND DS_CODE LIKE '"+string+"%'");
					}else{
						query = query.replace("{0}", "");
					}
				}
				resultSet = handler.executeSelectStatement(query, conn);
				while(resultSet.next()){
					custBean = new PM_IL_END_APPR_SETUP();
					custBean.setEAS_TO_END_CODE(resultSet.getString("DS_CODE"));
					custBean.setEAS_TO_END_CODE_DESC(resultSet.getString("DS_DESC"));
					codeList.add(custBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
						CommonUtils.closeCursor(resultSet);
			}
			return codeList;
		}*/
	// PREMIAGDC-0135 – new queries added, Added by: Shankar Bodduluri, Dated: 13-Mar-2009
	public ArrayList<SelectItem> selectValueForIL_APPR_GRP(){
		Connection connection=null;
		CRUDHandler handler =new CRUDHandler();
		ArrayList<SelectItem> drpDwn = null;
		String selectQuery =PILM039_QUERY_CONSTANT.IL_APPR_GRP;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();;
			rst =handler.executeSelectStatement(selectQuery, connection);
			drpDwn =new ArrayList<SelectItem>();
			while(rst.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(rst.getString(1));
				selectItem.setLabel(rst.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
}

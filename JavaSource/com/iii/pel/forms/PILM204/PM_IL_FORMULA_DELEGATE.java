package com.iii.pel.forms.PILM204;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FORMULA_DELEGATE {

	public int updateData(PM_IL_FORMULA_DTL pm_il_formula_dtl) throws Exception {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_formula_dtl, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_FORMULA_DTL gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new java.util.ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}

	public List suggestionActionComponent(String code, List CodeList,
			PM_IL_FORMULA_DTL pm_il_formula_dtl) {
     	String componentType = pm_il_formula_dtl.getFMD_COMP_TYPE();
		if (componentType != null) {
			if ("*".equalsIgnoreCase(code)) {

				if (componentType.equalsIgnoreCase("TP")) {
					String tariffQuery = "SELECT TP_CAPTION,TP_BL_CAPTION FROM  PM_IL_TAR_PARAM";
					CodeList = codeLOV(tariffQuery);
				}
				if (componentType.equalsIgnoreCase("FOR")) {
					String formulaQuery = "SELECT FRM_CODE, FRM_DESC FROM PM_IL_FORMULA";
					CodeList = codeLOV(formulaQuery);
				}
				if (componentType.equalsIgnoreCase("FTR")) {
					String factorQuery = "SELECT TH_CODE, TH_DESC "
							+ "FROM  PM_IL_TAR_HDR "
							+ "WHERE TH_PARAM_TYPE = 'FTR'";
					CodeList = codeLOV(factorQuery);
				}
				if (componentType.equalsIgnoreCase("AO")) {
					String operatorQuery = "SELECT PS_CODE, PS_CODE_DESC "
							+ "FROM PP_SYSTEM " + "WHERE PS_TYPE = 'IL_TAR_OP'";
					CodeList = codeLOV(operatorQuery);
				}
				if (componentType.equalsIgnoreCase("CO")) {
					CodeList = null;
				}

			} else {

				if (componentType.equalsIgnoreCase("TP")) {
					String tariffQuery = "SELECT TP_CAPTION,TP_BL_CAPTION FROM  PM_IL_TAR_PARAM"
							+ " WHERE UPPER(TP_CAPTION) LIKE '"
							+ code.toUpperCase() + "%'";

					CodeList = codeLOV(tariffQuery);
				}
				if (componentType.equalsIgnoreCase("FOR")) {
					String formulaQuery = "SELECT FRM_CODE, FRM_DESC FROM PM_IL_FORMULA"
							+ " WHERE UPPER(FRM_CODE) LIKE '"
							+ code.toUpperCase() + "%'";
					CodeList = codeLOV(formulaQuery);
				}
				if (componentType.equalsIgnoreCase("FTR")) {
					String factorQuery = "SELECT TH_CODE, TH_DESC "
							+ "FROM  PM_IL_TAR_HDR "
							+ "WHERE TH_PARAM_TYPE = 'FTR'"
							+ " AND UPPER(TH_CODE) LIKE '"
							+ code.toUpperCase() + "%'";
					CodeList = codeLOV(factorQuery);
				}
				if (componentType.equalsIgnoreCase("AO")) {
					String operatorQuery = "SELECT PS_CODE, PS_CODE_DESC "
							+ "FROM PP_SYSTEM " + "WHERE PS_TYPE = 'IL_TAR_OP'"
							+ " AND UPPER(PS_CODE) LIKE '"
							+ code.toUpperCase() + "%'";
					CodeList = codeLOV(operatorQuery);
				}
				if (componentType.equalsIgnoreCase("CO")) {
					CodeList = null;
				}
			}
		}

		return CodeList;
	}

	public List<PM_IL_FORMULA_DTL> codeLOV(String query) {
		List<PM_IL_FORMULA_DTL> codeList = new ArrayList<PM_IL_FORMULA_DTL>();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PM_IL_FORMULA_DTL pm_il_formula_dtl = new PM_IL_FORMULA_DTL();
				pm_il_formula_dtl.setFMD_COMPONENT(resultSet.getString(1));
				pm_il_formula_dtl.setUI_M_FORMULA_DESC(resultSet.getString(2));

				codeList.add(pm_il_formula_dtl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_IL_FORMULA_DTL pm_il_formula_dtl = (PM_IL_FORMULA_DTL) iterator
					.next();
			if (Code.equalsIgnoreCase(pm_il_formula_dtl.getFMD_COMPONENT())) {
				codedesc = pm_il_formula_dtl.getUI_M_FORMULA_DESC();
			}
		}
		return codedesc;
	}

	public int executeInsert(Object object) {
		Connection connection = null;
		int recordCount = 0;
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			recordCount = handler.executeInsert(object, connection);
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception ae) {
				ae.printStackTrace();
			}
			e.printStackTrace();
		}
		return recordCount;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.44.0.138:1521:orcl", "PEL_LIFE",
					"PEL_LIFE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * This method prepares list of values for formula details which are fetched
	 * when formula details button is pressed
	 * 
	 * @return
	 */
	public void prepareDetailsList(PM_IL_FORMULA_COMPOSITEBEAN compositeAction) {
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_FORMULA_DTL pm_il_formula_dtl_bean = compositeAction.getPM_IL_FORMULA_DTL_ACTION().getPM_IL_FORMULA_DTL_BEAN();
		PM_IL_FORMULA pm_il_formula = compositeAction.getPM_IL_FORMULA_ACTION()
		.getPM_IL_FORMULA_BEAN();
			String C1 = " select  ROWID,PM_IL_FORMULA_DTL.* from  PM_IL_FORMULA_DTL where " +
					" PM_IL_FORMULA_DTL.FMD_FM_CODE = ?";  
			List<PM_IL_FORMULA_DTL> dataList = compositeAction.getPM_IL_FORMULA_DTL_ACTION().getDataList_PM_IL_FORMULA_DTL();
		try {
			Connection connection = CommonUtils.getConnection();
			values = new Object[]{pm_il_formula.getFRM_CODE()};
			/*String selectQuery = "SELECT P.*,PT.*,P.ROWID AS ROWID1,PT.ROWID AS ROWID2	"
					+ "FROM PM_IL_FORMULA P,PM_IL_FORMULA_DTL PT "
					+ "WHERE PT.FMD_FM_CODE=P.FRM_CODE AND  PT.FMD_FM_CODE='"
					+ code + "' ORDER BY PT.FMD_SR_NO";*/
     		
			resultSet = handler.executeSelectStatement(C1, connection,values);

			while (resultSet.next()) {

				pm_il_formula_dtl_bean = new PM_IL_FORMULA_DTL();

				pm_il_formula_dtl_bean.setFMD_FM_CODE(resultSet
						.getString("FMD_FM_CODE"));
				pm_il_formula_dtl_bean.setFMD_COMP_TYPE(resultSet
						.getString("FMD_COMP_TYPE"));
				pm_il_formula_dtl_bean.setFMD_COMPONENT(resultSet
						.getString("FMD_COMPONENT"));
				pm_il_formula_dtl_bean
						.setFMD_SR_NO(resultSet.getInt("FMD_SR_NO"));
				pm_il_formula_dtl_bean.setFMD_CR_DATE(resultSet
						.getDate("FMD_CR_DATE"));
				pm_il_formula_dtl_bean.setROWID(resultSet.getString("ROWID"));
				
				
				compositeAction.getPM_IL_FORMULA_DTL_ACTION().getDataList_PM_IL_FORMULA_DTL().add(pm_il_formula_dtl_bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public String postQuery()  {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		ResultSet resultSet=null;
		CRUDHandler  handler = new CRUDHandler();
		String description = null;
		PM_IL_FORMULA_COMPOSITEBEAN compositeAction = (PM_IL_FORMULA_COMPOSITEBEAN) (commonUtils
				.getMappedBeanFromSession("PM_IL_FORMULA_COMPOSITEBEAN"));
		List<PM_IL_FORMULA_DTL> list = compositeAction
				.getPM_IL_FORMULA_DTL_ACTION().getDataList_PM_IL_FORMULA_DTL();
		if (list != null) {
			Iterator<PM_IL_FORMULA_DTL> iterator = list.iterator();
			while (iterator.hasNext()) {
				PM_IL_FORMULA_DTL dtlBean = iterator.next();
				DBProcedures procedures = new DBProcedures();
				String code = dtlBean.getFMD_COMPONENT();
			
				String selectQuery = " SELECT TP_BL_CAPTION FROM PM_IL_TAR_PARAM WHERE TP_CAPTION = '"+code+ "'"+
				" UNION SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE = '" + code + "'"+
				" UNION SELECT TH_DESC FROM PM_IL_TAR_HDR WHERE  TH_CODE = '" + code + "'"+ 
				" UNION SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE =  '" + code + "'";
			try{	
				connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(selectQuery, connection);
				while(resultSet.next()){
					description= resultSet.getString(1);
					System.out.println("description :"+description);				
				}
			}
			catch(Exception exception){
				
			}
				/*ArrayList<String> CodeDescList = procedures.helperP_VAL_CODES(
						"IL_FOR_COMP", code, "N", "N", null);
				if (CodeDescList != null && CodeDescList.size() != 0) {
					dtlBean.setUI_M_FORMULA_DESC(CodeDescList.get(0));

				}*/

			}
		}
		return description;
	}
	

	/**
	 * This method prepares beanList which contains all formulaCode and formula
	 * values from dataBase
	 * 
	 * @param searchBean
	 * @return
	 */
	public ArrayList<PM_IL_FORMULA> prepareSearchList(SearchBean searchBean) {

		ArrayList<PM_IL_FORMULA> beanList = new ArrayList<PM_IL_FORMULA>();
		Connection connection = null;
		ResultSet resultSet = null;
		boolean flag = false;
		String searchQuery = "SELECT FRM_CODE,FRM_FORMULA,ROWID FROM PM_IL_FORMULA";

		if (searchBean.getFormulaCode() != null
				&& searchBean.getFormulaCode().trim().length() > 0) {

			searchQuery = searchQuery + " WHERE UPPER(FRM_CODE) LIKE " + "'"
					+ searchBean.getFormulaCode().toUpperCase() + "%'";
			flag = true;
		}

		if (searchBean.getFormula() != null
				&& searchBean.getFormula().trim().length() > 0) {
			if (!flag) {

				searchQuery = searchQuery + " WHERE UPPER(FRM_FORMULA) LIKE "
						+ "'" + searchBean.getFormula().toUpperCase() + "%'";
			} else {

				searchQuery = searchQuery + " AND UPPER(FRM_FORMULA) LIKE "
						+ "'" + searchBean.getFormula().toUpperCase() + "%'";
			}

		}

		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			System.out.println(searchQuery);
			resultSet = handler.executeSelectStatement(searchQuery, connection);
			while (resultSet.next()) {

				PM_IL_FORMULA formulaBean = new PM_IL_FORMULA();

				formulaBean.setFRM_CODE(resultSet.getString(1));
				System.out.println("code" + resultSet.getString(1));
				formulaBean.setFRM_FORMULA(resultSet.getString(2));
				System.out.println("code" + resultSet.getString(2));
				beanList.add(formulaBean);

			}

		} catch (DBException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			/*if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}*/
			if (resultSet != null) {

				try {
					resultSet.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return beanList;

	}

	public int deleteSearchData(PM_IL_FORMULA pm_il_formula) {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;

		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_formula, connection);
			connection.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return deletedRows;
	}

	/**
	 * This Method fetches values in formula master Screen on clicking formula
	 * code in search screen
	 * 
	 * @param formulaBean
	 * @return
	 */
	public Object makeSearchList(PM_IL_FORMULA_COMPOSITEBEAN compositeBean) {

		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_FORMULA formulaBean = compositeBean.getPM_IL_FORMULA_ACTION().getPM_IL_FORMULA_BEAN();
		String query = "SELECT ROWID,FRM_CODE,FRM_DESC,FRM_FORMULA "
				+ "FROM PM_IL_FORMULA " + "WHERE FRM_CODE= '"
				+ formulaBean.getFRM_CODE() + "'";
		try {
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				formulaBean.setROWID(resultSet.getString("ROWID"));
				formulaBean.setFRM_DESC(resultSet.getString("FRM_DESC"));
				formulaBean.setFRM_FORMULA(resultSet.getString("FRM_FORMULA"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formulaBean;
	}

	/**
	 * This Method Checks For Duplication of code in dataBase
	 * 
	 * @param code
	 * @param pm_il_formula_action 
	 * @throws Exception 
	 * @throws ValidatorException
	 */
	/* [BugId:TRACK_PREMIAGDC_GL.10.5-00177: Action Parameter Added.  Added By : Mallika.S 01-Apr-2009*/
	public void codeValidation(String code, PM_IL_FORMULA_ACTION pm_il_formula_action) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		String M_DUMMY = null;
		/* [BugId:TRACK_PREMIAGDC_GL.10.5-00177: Formula code already exist error issue fixed. Added By : Mallika.S 01-Apr-2009*/
		String rowId = pm_il_formula_action.getPM_IL_FORMULA_BEAN().getROWID();
		System.out.println("code is:" + code);
		String query1 = "SELECT 'X' " + "FROM PM_IL_FORMULA "
				+ "WHERE FRM_CODE ='" + code + "'";
		String query2 = "SELECT 'X' " + "FROM PM_IL_FORMULA"
				+ " WHERE FRM_CODE='" + code + "'" + "AND ROWID !='" + rowId
				+ "'";
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (rowId == null) {
					resultSet = handler.executeSelectStatement(query1,
							connection);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);

				}
				if (M_DUMMY != null) {
					if (resultSet.next() || M_DUMMY.equals("" + "X")) {

						throw new Exception("Formula Code Already Exists.!Please Enter Another One");

					}
				}

			} else {

				resultSet2 = handler.executeSelectStatement(query2, connection);
				if (resultSet2.next()) {
					M_DUMMY = resultSet2.getString(1);

				}
					if (M_DUMMY != null) {
						if (resultSet2.next() || M_DUMMY.equals("" + "X")) {

							throw new Exception("Formula Code Already Exists.!Please Enter Another One");

						}
					}

			}
		}  
		catch (Exception e) {
		 e.printStackTrace();
		 throw new Exception(e.getMessage());
		}

	}

	/**
	 * This is when validate item for component in pm_il_formula_dtl
	 * 
	 * @param component
	 * @param pm_il_formula_dtl
	 * @throws Exception 
	 * @throws ValidatorException
	 */
	public void componentWhenValidate(String component,
			PM_IL_FORMULA_DTL pm_il_formula_dtl) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		System.out.println("Component is :" + component);
		
		String query=" SELECT 'X' FROM PM_IL_TAR_PARAM WHERE TP_CAPTION = '"+component+ "'"+
		" UNION SELECT 'X' FROM PM_IL_FORMULA WHERE FRM_CODE = '" + component + "'"+
		" UNION SELECT 'X' FROM PM_IL_TAR_HDR WHERE  TH_CODE = '" + component + "'"+ 
		" UNION SELECT 'X' FROM PP_SYSTEM WHERE PS_CODE =  '" + component + "'";
		
		/*String query = "SELECT 'X' FROM PM_IL_FORMULA_DTL "
				+ "WHERE FMD_COMPONENT = '" + component + "'";*/
		String componentType = pm_il_formula_dtl.getFMD_COMP_TYPE();
		System.out.println("component Type is :" + componentType);
		if ("TP".equalsIgnoreCase(componentType)
				|| "FOR".equalsIgnoreCase(componentType)
				|| "FTR".equalsIgnoreCase(componentType)
				|| "AO".equalsIgnoreCase(componentType)) {

			try {
				connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(query, connection);
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				System.out.println("M_DUMMY is :" + M_DUMMY);
				if (M_DUMMY == null) {

					throw new Exception( 
							"Component Code Does Not Exists.Please ReEnter");

				}

			}
			catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}

	}
	
	/**
	 * This method is used to delete values in formula master screen
	 * 
	 * @param pm_il_formula
	 */
	public void deleteMasterDetails(PM_IL_FORMULA pm_il_formula) {

		Connection connection = null;
		int resultSet = 0;

		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeDelete(pm_il_formula, connection);

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeQuery(PM_IL_FORMULA_COMPOSITEBEAN compositeAction)throws Exception{
		PM_IL_FORMULA PM_IL_FORMULA_BEAN = compositeAction.getPM_IL_FORMULA_ACTION().getPM_IL_FORMULA_BEAN();
		String SEARCH_QUERY = "SELECT ROWID, PM_IL_FORMULA.* FROM PM_IL_FORMULA WHERE ROWID=? ";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PM_IL_FORMULA_BEAN.getROWID()};
			resultSet = handler.executeSelectStatement(SEARCH_QUERY, connection,values);
			while(resultSet.next()){
				PM_IL_FORMULA pm_il_formula_bean = new PM_IL_FORMULA();
				pm_il_formula_bean.setFRM_CODE(resultSet.getString("FRM_CODE"));
				pm_il_formula_bean.setFRM_DESC(resultSet.getString("FRM_DESC"));
				pm_il_formula_bean.setFRM_FORMULA(resultSet.getString("FRM_FORMULA"));
				pm_il_formula_bean.setOLD_UPD_DT(resultSet.getDate("FRM_UPD_DT"));
				pm_il_formula_bean.setROWID(resultSet.getString("ROWID"));
				/*ADDED BY KRITHIKA  for call id FALCONQC-1716554*/
				pm_il_formula_bean.setFRM_HIDE(resultSet.getString("FRM_FORMULA"));
				/*End*/
				compositeAction.getPM_IL_FORMULA_ACTION().setPM_IL_FORMULA_BEAN(pm_il_formula_bean);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		finally {
			try{
				connection.commit();
				CommonUtils.closeCursor(resultSet);
			}catch(Exception exception){
			}
		}
	}

}

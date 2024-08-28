package com.iii.pel.forms.PILM040;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_MASTER_POLICY_HELPER {
	
	/**
	 * Commented by Varun(50663) as pre-form is setting global
	 * Variables this is not handled in  PEL .Thus this will 
	 * not be called.
	 * @param pm_il_master_policy_action
	 * @throws Exception
	 */
	// Base_Curr changes PREMIAGDC-0030 : Added by Shankar Bodduluri : 25/03/09
	/*public void pilm040_pre_form(
			PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action)
			throws Exception {
		Connection connection = null;

		System.out.println("Calling Preform");
		connection = CommonUtils.getConnection();
		String M_FILE = null;
		String M_TITLE = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		String dummyPolNo = null;
		ArrayList<String> arrayList = DBProcedures.P_VAL_FINAL_PARAMETER(
				connection, "BASE.CURR", "E");
		System.out.println("PVALFINAL PARAMETER:" + arrayList);

		Map<String, Object> session = fc.getExternalContext().getSessionMap();

		session.put("GLOBAL.M_FAILURE", "FALSE");
		session.put("GLOBAL.M_MODULE_NAME", "MasterPolicy");

		M_TITLE = CommonUtils.getControlBean().getM_USER_ID() + "    "
				+ CommonUtils.getControlBean().getM_SCR_NAME() + "   "
				+ Calendar.getInstance().getTimeInMillis();

		String formName = session.get("GLOBAL.M_MODULE_NAME").toString();
		System.out.println("PREFORM FORM NAME :" + formName);
		
	}*/
	public void pilm040_pre_form(
			PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action)
			throws Exception {
		Connection connection = null;

		System.out.println("Calling Preform");
		connection = CommonUtils.getConnection();
		String M_FILE = null;
		String M_TITLE = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		String dummyPolNo = null;
		
		// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
		if(list!= null && list.size()>0){
			P_CURR_CODE = list.get(0);
			P_NAME = list.get(1);
			P_DECIMAL = CommonUtils.parseToInt(list.get(2));
		}
		
		ArrayList<String> arrayList = DBProcedures.P_VAL_FINAL_PARAMETER(
				connection, P_CURR_CODE, "E");
		System.out.println("PVALFINAL PARAMETER:" + arrayList);
		
		// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added

		Map<String, Object> session = fc.getExternalContext().getSessionMap();

		session.put("GLOBAL.M_FAILURE", "FALSE");
		session.put("GLOBAL.M_MODULE_NAME", "MasterPolicy");

		M_TITLE = CommonUtils.getControlBean().getM_USER_ID() + "    "
				+ CommonUtils.getControlBean().getM_SCR_NAME() + "   "
				+ Calendar.getInstance().getTimeInMillis();

		String formName = session.get("GLOBAL.M_MODULE_NAME").toString();
		System.out.println("PREFORM FORM NAME :" + formName);
		
	}
	public String  pilm040_pm_il_master_policy_mp_prod_code_when_validate_item(
			String productCode) throws ValidatorException,Exception {
		String pdtDescQuery = PM_IL_MASTER_SQLQUERY_CONSTANTS.PM_IL_MASTER_PRODT_CODE_DESC;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String pdtDesc = null;
		System.out.println("VALIDATE :" + productCode);
		
		try{
			
			if (productCode != null) {
				Object[] object = { productCode };
				System.out.println("######## : " + pdtDescQuery + "   <" + object
						+ ">");
				resultSet = handler.executeSelectStatement(pdtDescQuery,
						connection, object);
				if (resultSet != null) {
					System.out.println("IF PART:");
					if (resultSet.next()) {
						System.out.println("IF Condition :"
								+ resultSet.getString("PROD_DESC"));
						pdtDesc = resultSet.getString("PROD_DESC");
						pdtDesc = pdtDesc == null ? "" : pdtDesc;
					} else {
						System.out.println("********* Not a Valid Product Code ********");
						
						/*FacesMessage meesMessage=new FacesMessage("Not a Valid Product Code");
					throw new ValidatorException(new FacesMessage("Not a Valid Product Code"));*/
						
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath,"91074"));
						
						
					}
					System.out.println("Before Close");
					resultSet.close();
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pdtDesc;
	}
	public void pilm040_pm_il_master_policy_mp_policy_no_when_validate_item(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN)throws ValidatorException,Exception
	{
		String policyNo=PM_IL_MASTER_POLICY_BEAN.getMP_POL_NO();
		System.out.println(" Pol No :"+policyNo);
	  	if(policyNo!=null&&policyNo.length()>1)
	  	{
	  		L_DUP_CHECK_POL_NO(PM_IL_MASTER_POLICY_BEAN);
	  	}
	}
	
	public void pilm040_pm_il_master_policy_post_query(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN)throws ValidatorException,Exception
	{
		L_GET_PROD_CODE_DESC(PM_IL_MASTER_POLICY_BEAN);
		ArrayList<String> pValList = DBProcedures.helperPKG_PILT002$P_VAL_CUST(
								CommonUtils.getGlobalVariable("GLOBAL.M_MP_CUST_CODE"),
								PM_IL_MASTER_POLICY_BEAN.getUI_M_MP_CUST_CODE_DESC(),
								CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								"N",
								null);
		if(!pValList.isEmpty()){
			PM_IL_MASTER_POLICY_BEAN.setUI_M_MP_CUST_CODE_DESC(pValList.get(0));
		}
	}
	
	
	public void pilm040_pm_il_master_policy_when_create_record(PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action) throws SQLException, Exception
	{
		PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN = pm_il_master_policy_action.getPM_IL_MASTER_POLICY_BEAN();
		PM_IL_MASTER_POLICY_BEAN.setMP_CUST_CODE(CommonUtils.getGlobalVariable("M_MP_CUST_CODE"));
		if(PM_IL_MASTER_POLICY_BEAN.getMP_CUST_CODE()!=null)
		{
			ArrayList<String> pValList = DBProcedures.helperPKG_PILT002$P_VAL_CUST(
					PM_IL_MASTER_POLICY_BEAN.getMP_CUST_CODE(),
					PM_IL_MASTER_POLICY_BEAN.getUI_M_MP_CUST_CODE_DESC(),
					CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
					"N",
					null);
			if(!pValList.isEmpty()){
				PM_IL_MASTER_POLICY_BEAN.setUI_M_MP_CUST_CODE_DESC(pValList.get(0));
			}
		}
	}
	
	public String L_GET_PROD_CODE_DESC(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN)throws ValidatorException,Exception
	{
		ResultSet resultSet=null;
		String prdtDesc=null;
		Connection connection=CommonUtils.getConnection();
		String selectDescQuery=PM_IL_MASTER_SQLQUERY_CONSTANTS.L_GET_PROD_CODE_DESC;
		CRUDHandler handler=new CRUDHandler();
		
		try{
				Object[] object={PM_IL_MASTER_POLICY_BEAN.getMP_PROD_CODE()};
				resultSet=handler.executeSelectStatement(selectDescQuery,connection,object);
				
					if(resultSet.next())
					{
						PM_IL_MASTER_POLICY_BEAN.setUI_M_MP_PROD_CODE_DESC(resultSet.getString(1));
					}else{
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91074"));
					}
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prdtDesc;
	}
	
	
	public void L_DUP_CHECK_POL_NO(PM_IL_MASTER_POLICY pm_il_master_policy)
			throws ValidatorException{
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		String rowId = null;
		String no = null;
		String mTemp=null;
		String policyNoCheckQuery=PM_IL_MASTER_SQLQUERY_CONSTANTS.L_DUP_CHECK_POL_NO_QUERY;
		Object[] objects1={pm_il_master_policy.getMP_POL_NO()};
		String selectPolicyNoQuery = PM_IL_MASTER_SQLQUERY_CONSTANTS.L_DUP_CHECK_POLICY_NO;
		Object[] objects2={pm_il_master_policy.getMP_POL_NO(),pm_il_master_policy.getROWID()};
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    System.out.println("---------Enter Duplicate Policy No checking Process-------");
		    
		    if(pm_il_master_policy.getROWID()==null){
		    	resultSet1=handler.executeSelectStatement(policyNoCheckQuery, connection, objects1);
		    	if(resultSet1.next()){
		    		mTemp=resultSet1.getString(1);
		    	}
		    	if(resultSet1.next()){
		    		throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "2118"));
		    	}
		    	
		    }else{
		    	resultSet2=handler.executeSelectStatement(selectPolicyNoQuery, connection, objects2);
		    	if(resultSet2.next()){
		    		mTemp=resultSet2.getString(1);
		    	}
		    	if(resultSet2.next()){
		    		throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "2118"));
		    	}
		    }
		} catch (DBException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
					CommonUtils.closeCursor(resultSet1);
					CommonUtils.closeCursor(resultSet2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		
		
		
		}
	
	public void pm_il_master_policy_when_new_record_instance(String policyNo)
	{
	   CRUDHandler handler=new CRUDHandler();
	   ResultSet resultSet=null;
	   String query=PM_IL_MASTER_SQLQUERY_CONSTANTS.PM_IL_MASTER_POL_NO;
	   Object[] object={policyNo};
	   String record=null;
	   try{
		   
		   Connection connection=CommonUtils.getConnection();
		   resultSet=handler.executeSelectStatement(query,connection,object);
		   if(resultSet!=null)
		   {
			   if(resultSet.next())
			   {
				   record=resultSet.getString(1);
			   }
		   }
	   }catch(Exception exception){
		   exception.printStackTrace();
	   }finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public void pm_il_master_policy_when_new_form_instance( PM_IL_MASTER_POLICY pm_il_master_policy){
	
			 CRUDHandler handler=new CRUDHandler();
			 ResultSet resultSet=null;
			 ResultSet resultSet1=null;
			 ResultSet resultSet2=null;
			 String M_DUMMY = null;
			 String globalCustCode=CommonUtils.getGlobalVariable("GLOBAL.M_MP_CUST_CODE");
			 System.out.println("globalCustCode :"+globalCustCode);
		   try {
				Connection connection=CommonUtils.getConnection();
				String sqlQuery=PM_IL_MASTER_SQLQUERY_CONSTANTS.PM_IL_MASTER_WHEN_NEW_FORM_QUERY;
				Object[] objects={globalCustCode};
				resultSet=handler.executeSelectStatement(sqlQuery, connection, objects);
				if(resultSet.next()){
					M_DUMMY=resultSet.getString(1);
				}
				if(M_DUMMY==null){
					
					pm_il_master_policy.setMP_CUST_CODE(globalCustCode);
					
					ArrayList<String> codeDesc=DBProcedures.helperP_VAL_CUST(pm_il_master_policy.getMP_CUST_CODE(),
												"N", "");
					if(codeDesc!=null && codeDesc.size()!=0){
						System.out.println("Code Desc:"+codeDesc.get(0));
						pm_il_master_policy.setUI_M_MP_CUST_CODE_DESC(codeDesc.get(0));
						
					}
					
				}else{
					String sqlQuery1=PM_IL_MASTER_SQLQUERY_CONSTANTS.SELECT_DETAILS_FOR_CUST_CODE;
					Object[] objects2={globalCustCode};
					resultSet1=handler.executeSelectStatement(sqlQuery1, connection, objects2);
					if(resultSet1.next()){
						pm_il_master_policy.setROWID(resultSet1.getString("ROWID"));
						pm_il_master_policy.setMP_CUST_CODE(resultSet1.getString("MP_CUST_CODE"));
						pm_il_master_policy.setMP_PROD_CODE(resultSet1.getString("MP_PROD_CODE"));
						pm_il_master_policy.setMP_POL_NO(resultSet1.getString("MP_POL_NO"));
						pm_il_master_policy.setMP_ISSUE_DT(resultSet1.getDate("MP_ISSUE_DT"));
						pm_il_master_policy.setMP_POL_FM_DT(resultSet1.getDate("MP_POL_FM_DT"));
						pm_il_master_policy.setMP_LC_MAX_TPD_BNF(resultSet1.getDouble("MP_LC_MAX_TPD_BNF"));
						pm_il_master_policy.setMP_PRE_TPD_BNF_MONTHS(resultSet1.getDouble("MP_PRE_TPD_BNF_MONTHS"));
						pm_il_master_policy.setMP_LC_FUNERAL_EXP_LMT(resultSet1.getDouble("MP_LC_FUNERAL_EXP_LMT"));
						pm_il_master_policy.setMP_LC_FUNERAL_EXP_AMT(resultSet1.getDouble("MP_LC_FUNERAL_EXP_AMT"));
						pm_il_master_policy.setMP_CLM_INTM_DAYS(resultSet1.getDouble("MP_CLM_INTM_DAYS"));
						pm_il_master_policy.setMP_NOTICE_PRD(resultSet1.getDouble("MP_NOTICE_PRD"));
						pm_il_master_policy.setMP_LC_FCL(resultSet1.getDouble("MP_LC_FCL"));
						pm_il_master_policy.setMP_CR_DT(resultSet1.getDate("MP_CR_DT"));
						pm_il_master_policy.setMP_CR_UID(resultSet1.getString("MP_CR_UID"));
						pm_il_master_policy.setMP_UPD_DT(resultSet1.getDate("MP_UPD_DT"));
						pm_il_master_policy.setMP_UPD_UID(resultSet1.getString("MP_UPD_UID"));
						
						if(pm_il_master_policy.getMP_CUST_CODE()!=null){
							
							ArrayList<String> codeDesc=DBProcedures.helperP_VAL_CUST(pm_il_master_policy.getMP_CUST_CODE(),
									"N", "");
								if(codeDesc!=null && codeDesc.size()!=0){
									System.out.println("Code Desc:"+codeDesc.get(0));
									pm_il_master_policy.setUI_M_MP_CUST_CODE_DESC(codeDesc.get(0));
									
								}
						}
						
						if(pm_il_master_policy.getMP_PROD_CODE()!=null){
							
							String sqlQuery2=PM_IL_MASTER_SQLQUERY_CONSTANTS.PRODUCT_DESC_FOR_PRODUCT_CODE;
							Object[] objects3={pm_il_master_policy.getMP_PROD_CODE()};
							resultSet2=handler.executeSelectStatement(sqlQuery2, connection, objects3) ;
							if(resultSet2.next()){
								pm_il_master_policy.setUI_M_MP_PROD_CODE_DESC(resultSet2.getString(1));
									
						}
						}
					}
				}
			
		   } catch (DBException e) {
			e.printStackTrace();
		   } catch (SQLException e) {
			e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
					try {
						CommonUtils.closeCursor(resultSet);
						CommonUtils.closeCursor(resultSet1);
						CommonUtils.closeCursor(resultSet2);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
	}*/
	
	public void when_new_form_instance(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN,PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action){
		String C1= " SELECT 'X'" +
				"   FROM   PM_IL_MASTER_POLICY" +
				"   WHERE  MP_CUST_CODE = ?";
		String M_DUMMY = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet c1_ResultSet = null;
		Object[] values = null;
		ArrayList<String> pValList = new ArrayList<String>();
		PM_IL_MASTER_POLICY_DELEGATE pm_il_master_policy_delegate = new PM_IL_MASTER_POLICY_DELEGATE();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{CommonUtils.getGlobalObject("GLOBAL.M_MP_CUST_CODE")};
			c1_ResultSet = handler.executeSelectStatement(C1, connection,values);
			if(c1_ResultSet.next()){
				M_DUMMY = c1_ResultSet.getString(1);
			}
			if("X".equals(M_DUMMY)){
				pm_il_master_policy_delegate.executeSelectStatement(pm_il_master_policy_action);
			}else{
				PM_IL_MASTER_POLICY_BEAN.setMP_CUST_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_MP_CUST_CODE"));
			}
			pValList = DBProcedures.helperP_VAL_CUST("GLOBAL.M_MP_CUST_CODE",
			           "GLOBAL.M_LANG_CODE",
			           "N");
			if(!pValList.isEmpty()){
				 PM_IL_MASTER_POLICY_BEAN.setUI_M_MP_CUST_CODE_DESC(pValList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pre_update(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN){
		String M_DUMMY = null;
		String C1 = " SELECT 'X'" +
				"		FROM   PT_IL_POLICY" +
				" WHERE  POL_MASTER_POL_NO = ?" +
				"		AND    POL_CUST_CODE     = ? " +
				"		AND    POL_PROD_CODE     = ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PM_IL_MASTER_POLICY_BEAN.getMP_POL_NO(),
					PM_IL_MASTER_POLICY_BEAN.getMP_CUST_CODE(),
					PM_IL_MASTER_POLICY_BEAN.getMP_PROD_CODE()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_DUMMY = resultSet.getString(1);
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91041"));
			}
			PM_IL_MASTER_POLICY_BEAN.setMP_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_MASTER_POLICY_BEAN.setMP_UPD_UID(CommonUtils.getControlBean().getM_LANG_CODE());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pre_insert(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN)throws Exception{
		try {
			if(PM_IL_MASTER_POLICY_BEAN.getMP_POL_NO() != null){
				L_DUP_CHECK_POL_NO(PM_IL_MASTER_POLICY_BEAN);
			}
			 PM_IL_MASTER_POLICY_BEAN.setMP_CR_DT(new CommonUtils().getCurrentDate());
			 PM_IL_MASTER_POLICY_BEAN.setMP_CR_UID(CommonUtils.getControlBean().getM_LANG_CODE());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}

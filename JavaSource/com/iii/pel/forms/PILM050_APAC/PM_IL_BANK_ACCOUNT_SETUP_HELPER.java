package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_IL_BANK_ACCOUNT_SETUP_HELPER {
	
	String FETCH_ACTIVITY_CODE_LOV = "SELECT ACTY_CODE, ACTY_NAME FROM FM_ACTIVITY WHERE ROWNUM < 20  ORDER BY 1 ";

	String FETCH_ACTIVITY_CODE_LOV_CONDITIONAL = "SELECT ACTY_CODE, ACTY_NAME  "
			+ " FROM FM_ACTIVITY WHERE ACTY_CODE LIKE ?  AND ACTY_NAME LIKE ? "
			+ " AND ROWNUM < 20 ORDER BY 1 ASC ";

	public void executeQuery(
			PM_IL_BANK_ACCOUNT_SETUP_ACTION pm_il_bank_account_setup_action) throws Exception {  
		
		new PM_IL_BANK_ACCOUNT_SETUP_DELEGATE().executeSelectStatement(pm_il_bank_account_setup_action);
	}
	
	public void BAS_DIVN_FM_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,PM_IL_BANK_ACCOUNT_SETUP_ACTION action)throws Exception{
		try {
		     
			 //SET_REP_FIRST_FIELD('PM_GL_BANK_ACCOUNT_SETUP.BAS_DIVN_FM_CODE','PM_GL_BANK_ACCOUNT_SETUP.BAS_DIVN_TO_CODE');
		    bean.setBAS_DIVN_FM_CODE((String)
			    new CommonUtils().SET_REP_FIRST_FIELD( bean.getBAS_DIVN_FM_CODE(), "String"));
			if( bean.getBAS_DIVN_FM_CODE() ==null ){
				bean.setBAS_DIVN_FM_CODE("0");
				action.getCOMP_BAS_DIVN_FM_CODE().setSubmittedValue("0");
			}else{
				if(bean.getBAS_DIVN_TO_CODE()!=null && bean.getBAS_DIVN_FM_CODE()!=null){
					if( bean.getBAS_DIVN_TO_CODE().compareTo(bean.getBAS_DIVN_FM_CODE())<0) {
						throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,	"10064"));
					}
				}
				ArrayList<OracleParameter> list = new DBProcedures().P_VAL_DIVN( bean.getBAS_DIVN_FM_CODE(), null,"N", "N" );
				/*if(list.get(0)!=null){
					 //bean.setUI_M_DIVN_FM_DESC(list.get(0));
				}*/
			}
		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
			 
	public void BAS_DIVN_TO_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,PM_IL_BANK_ACCOUNT_SETUP_ACTION action)throws Exception{
	    try {
		
		//SET_REP_FIRST_FIELD('PM_GL_BANK_ACCOUNT_SETUP.BAS_DIVN_FM_CODE','PM_GL_BANK_ACCOUNT_SETUP.BAS_DIVN_TO_CODE');
		bean.setBAS_DIVN_TO_CODE((String)
			new CommonUtils().SET_REP_SECOND_FIELD(bean.getBAS_DIVN_FM_CODE() ,bean.getBAS_DIVN_TO_CODE(), "String"));
		
		if(bean.getBAS_DIVN_TO_CODE()==null){
			bean.setBAS_DIVN_TO_CODE("99999");
			action.getCOMP_BAS_DIVN_TO_CODE().setSubmittedValue("99999");
		}else{
			if(bean.getBAS_DIVN_TO_CODE()!=null && bean.getBAS_DIVN_FM_CODE()!=null){
				if (bean.getBAS_DIVN_TO_CODE().compareTo(bean.getBAS_DIVN_FM_CODE())<0 ){
					throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,	"10064"));
				}
			}
			new DBProcedures().P_VAL_DIVN( bean.getBAS_DIVN_TO_CODE(), null,"N", "N");
		}
	    }  catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	    }
	}
	
	public void BAS_DEPT_FM_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,PM_IL_BANK_ACCOUNT_SETUP_ACTION action)throws Exception{
		try {
			 //SET_REP_FIRST_FIELD('PM_GL_BANK_ACCOUNT_SETUP.BAS_DEPT_FM_CODE','PM_GL_BANK_ACCOUNT_SETUP.BAS_DEPT_TO_CODE');
		    bean.setBAS_DEPT_FM_CODE((String)
			    new CommonUtils().SET_REP_FIRST_FIELD( bean.getBAS_DEPT_FM_CODE(), "String"));
			if( bean.getBAS_DEPT_FM_CODE() ==null ){
				bean.setBAS_DEPT_FM_CODE("0");
				action.getCOMP_BAS_DEPT_FM_CODE().setSubmittedValue("0");
			}else{
				if(bean.getBAS_DEPT_TO_CODE()!=null && bean.getBAS_DEPT_FM_CODE()!=null){
					if( bean.getBAS_DEPT_TO_CODE().compareTo(bean.getBAS_DEPT_FM_CODE())<0) {
						throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,	"10064"));
					}
				}
				/*Modified by Ram on 01/12/2016 for Fetch Division code
				 * 
				 * ArrayList<String> list = new DBProcedures().P_VAL_CODES("IL_PVOU_DTYP", bean.getBAS_DEPT_FM_CODE(), null,"L", "E", null);
				
				if(list.get(0)!=null){
					bean.setUI_M_DEPT_FM_DESC(list.get(0));
				}*/
				ArrayList<OracleParameter> list = new LIFELIB().P_VAL_DEPT(bean.getBAS_DIVN_FM_CODE(), bean.getBAS_DEPT_FM_CODE(),null, "N", "E");
				if(list.size() > 0 && list.get(0).getValue() != null ){
					bean.setUI_M_DEPT_FM_DESC(list.get(0).getValue());
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
			 
		
	
	public void BAS_DEPT_TO_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,PM_IL_BANK_ACCOUNT_SETUP_ACTION action) throws Exception{
		try {
			//SET_REP_SECOND_FIELD('PM_GL_BANK_ACCOUNT_SETUP.BAS_DEPT_FM_CODE','PM_GL_BANK_ACCOUNT_SETUP.BAS_DEPT_TO_CODE');
		    bean.setBAS_DEPT_TO_CODE((String)
			    new CommonUtils().SET_REP_SECOND_FIELD(bean.getBAS_DEPT_FM_CODE() ,bean.getBAS_DEPT_TO_CODE(), "String"));
			
			if(bean.getBAS_DEPT_TO_CODE()==null){
				bean.setBAS_DEPT_TO_CODE("99999");
				action.getCOMP_BAS_DEPT_TO_CODE().setSubmittedValue("99999");
			}else{
				if(bean.getBAS_DEPT_TO_CODE()!=null && bean.getBAS_DEPT_FM_CODE()!=null){
					if (bean.getBAS_DEPT_TO_CODE().compareTo(bean.getBAS_DEPT_FM_CODE())<0 ){
						throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,	"10064"));
					}
				}
			/* Modified by Ram on 01/12/2016 for Fetch Division code
			 * 
			 *  	new DBProcedures().P_VAL_CODES("IL_PVOU_DTYP", bean.getBAS_DEPT_TO_CODE(), null,"L", "E", null);*/
				
 
				ArrayList<OracleParameter> list = new LIFELIB().P_VAL_DEPT(bean.getBAS_DIVN_FM_CODE(), bean.getBAS_DEPT_FM_CODE(),null, "N", "E");
				 
			}
		} catch ( Exception e) {
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		} 
	}
	public void BAS_CUST_BANK_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean ) throws Exception{


	try {
		ArrayList<String> retVariable=	new DBProcedures().L_CHK_BANK(bean.getBAS_CUST_BANK_CODE(),
				"E",
				bean.getUI_M_CUST_BANK_DESC());
		if(retVariable.size()>0){
			bean.setUI_M_CUST_BANK_DESC(retVariable.get(0));
		}

	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}

}

    public void BAS_OUR_BANK_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean ) throws Exception{
    	try {
    		ArrayList<String> retVariable=	new DBProcedures().L_CHK_BANK(bean.getBAS_OUR_BANK_CODE(),"E",bean.getUI_M_OUR_BANK_DESC());
    		if(retVariable.size()>0){
    			bean.setUI_M_OUR_BANK_DESC(retVariable.get(0));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
    	}
    
    }
	public void BAS_SUB_ACNT_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,
		PM_IL_BANK_ACCOUNT_SETUP_ACTION action) throws Exception{

	try {
		bean.setUI_M_SUB_ACNT_DESC(null);
		if( bean.getBAS_SUB_ACNT_CODE()!=null){
			ArrayList<String> retVariables = new DBProcedures().P_VAL_SUB_ACNT (bean.getBAS_MAIN_ACNT_CODE(),
					bean.getBAS_SUB_ACNT_CODE(),
					"N",
			"E");
			if(retVariables.size()>0){
				bean.setUI_M_SUB_ACNT_DESC(retVariables.get(0));
				action.getCOMP_UI_M_SUB_ACNT_DESC().setSubmittedValue(retVariables.get(0));
			}
		}

	}  catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	
	}
	
	public void BAS_SETUP_FOR_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bankAccSetupBean, 
		PM_IL_BANK_ACCOUNT_SETUP_ACTION action) throws Exception{

	ResultSet resultSet=null;
	CRUDHandler handler=null;
	Connection con= null;
	int M_PC_VALUE=0;
	try{
		con = CommonUtils.getConnection();
		handler = new CRUDHandler();
		String sql_C1="SELECT PC_VALUE FROM   PM_CODES  WHERE  PC_CODE = ?  AND    PC_TYPE = 'IL_CPAY_MODE'";
		Object[] obj_C1={bankAccSetupBean.getBAS_SETUP_FOR()};
		resultSet=handler.executeSelectStatement(sql_C1, con, obj_C1);
		if(resultSet.next()){
			M_PC_VALUE = resultSet.getInt(1);
		}

		if(M_PC_VALUE ==1  || M_PC_VALUE==2 || M_PC_VALUE==3 || M_PC_VALUE==4){
			action.getCOMP_BAS_CUST_BANK_CODE().setDisabled(false);
			action.getCOMP_BAS_CUST_BANK_CODE().setReadonly(false);
			action.getCOMP_BAS_OUR_BANK_CODE().setDisabled(false);
			action.getCOMP_BAS_OUR_BANK_CODE().setReadonly(false);
		}else{
			action.getCOMP_BAS_CUST_BANK_CODE().setDisabled(true);
			action.getCOMP_BAS_CUST_BANK_CODE().setReadonly(true);
		}
		if(M_PC_VALUE==0){
			action.getCOMP_BAS_OUR_BANK_CODE().setRequired(false);				
		}else{
			action.getCOMP_BAS_OUR_BANK_CODE().setRequired(true);
		}
	} catch (Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	public void L_VAL_SUB_ACCOUNT(PM_IL_BANK_ACCOUNT_SETUP bean, 
		PM_IL_BANK_ACCOUNT_SETUP_ACTION action) throws Exception{

	ResultSet resultSet=null;
	CRUDHandler handler=null;
	Connection con= null;
	try{

		con = CommonUtils.getConnection();
		if(con!=null){
			String sql_C1= "SELECT MAIN_CTL_ACNT_FLAG " //, MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2   "
				+ " FROM  FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE  = ? ";
			Object[] obj_C1= {bean.getBAS_MAIN_ACNT_CODE()};
			handler= new CRUDHandler();
			String M_FLAG=null,	M_ACTY_HEAD_1=null, M_ACTY_HEAD_2 =null;

			resultSet=handler.executeSelectStatement(sql_C1, con,obj_C1);
			if(resultSet.next()){
				M_FLAG= resultSet.getString(1);
			}else{
				M_FLAG ="X";
			}
			CommonUtils.closeCursor(resultSet);
			if(!M_FLAG.equals("C")){

				action.getCOMP_BAS_SUB_ACNT_CODE().setRequired(false);
				action.getCOMP_BAS_SUB_ACNT_CODE().setDisabled(true);
				if(bean.getBAS_SUB_ACNT_CODE() != null){
					action.getCOMP_BAS_SUB_ACNT_CODE().setSubmittedValue("");
					action.getCOMP_UI_M_SUB_ACNT_DESC().setSubmittedValue("");
					bean.setBAS_SUB_ACNT_CODE(null);
					bean.setUI_M_SUB_ACNT_DESC(null);  
				}
			}
			else{
				action.getCOMP_BAS_SUB_ACNT_CODE().setDisabled(false);
				action.getCOMP_BAS_SUB_ACNT_CODE().setRequired(true);
			}

		}
	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
	public void BAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean,PM_IL_BANK_ACCOUNT_SETUP_ACTION action) throws Exception{
		try {
			ArrayList<String> list = null;
			list = new DBProcedures().P_VAL_MAIN_ACNT(bean.getBAS_MAIN_ACNT_CODE(),"N","E");
			bean.setUI_M_MAIN_ACNT_DESC(list.get(0));
			L_VAL_SUB_ACCOUNT(bean, action); 
		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void BAS_DIVN_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean ) throws Exception{

	try {

		if( bean.getBAS_DIVN_CODE() !=null){
			ArrayList<String> list =  new DBProcedures().callP_VAL_DIVN(bean.getBAS_DIVN_CODE(),
																 "N", "E");
			if(!list.isEmpty() && list.size() != 0){
				bean.setUI_M_DIVN_DESC(list.get(0));
			}else{
				bean.setBAS_DIVN_CODE(null);
			}
		}
	}catch (Exception e) {
		e.printStackTrace();
		throw new  Exception(e.getMessage());
	} 
}

    public void BAS_DEPT_CODE_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean ) throws Exception{
     
    	try{
    		if(bean.getBAS_DEPT_CODE()!=null){
    			ArrayList<String>  list = new DBProcedures().callP_VAL_DEPT(bean.getBAS_DIVN_CODE(), bean.getBAS_DEPT_CODE(), "N", "E");
    			if(list != null){
    				bean.setUI_M_DEPT_DESC((String)list.get(0));
    			}
    		}else{
    			bean.setBAS_DEPT_CODE(null);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    
    		throw new Exception(e.getMessage());
    	}
    }

	public void BAS_ANLY_CODE1_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean )throws Exception{
		try{
			bean.setUI_M_ANLY_1_DESC(null);
			if(bean.getBAS_ANLY_CODE_1()!=null){
				ArrayList<String> retVariable=	new DBProcedures().P_VAL_ANLY ("1",
						bean.getBAS_ANLY_CODE_1(),
						"N", "E");
				if(retVariable.size()>0){
					bean.setUI_M_ANLY_1_DESC(retVariable.get(0));
				}
			}

		}catch (SQLException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void BAS_ANLY_CODE2_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean )
	throws Exception{
		try{
			bean.setUI_M_ANLY_1_DESC(null);
			if(bean.getBAS_ANLY_CODE_2()!=null){
				ArrayList<String> retVariable=	new DBProcedures().P_VAL_ANLY ("2",bean.getBAS_ANLY_CODE_2(),
						"N", "E");
				if(retVariable.size()>0){
					bean.setUI_M_ANLY_1_DESC(retVariable.get(0));
				}
			}

		}catch (SQLException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void BAS_ACTY_CODE1_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean  ) throws Exception{
	Connection connection =null;
	CRUDHandler handler =null;
	ResultSet resultSet =null;
	String C1="SELECT ACTY_CODE, ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE=?";
		
	try{
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		resultSet = handler.executeSelectStatement(C1, connection,new Object[]{bean.getBAS_ACTY_CODE_1()});
		if(!resultSet.next()){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "1016"));
		}
		/*if(bean.getBAS_ACTY_CODE_1()!=null){
			ArrayList<String> retVariable=	new DBProcedures().P_VAL_ACTY(bean.getBAS_MAIN_ACNT_CODE(),
					bean.getBAS_ACTY_CODE_1(),
					"N", "E");

			if(retVariable.size()>0){
				bean.setUI_M_ACTY_1_DESC(retVariable.get(0));
			}
		}*/

	}catch (Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}finally{
		CommonUtils.closeCursor(resultSet);
	}

}

public void BAS_ACTY_CODE2_WHEN_VALIDATE_ITEM(PM_IL_BANK_ACCOUNT_SETUP bean ) throws Exception{
	Connection connection =null;
	CRUDHandler handler =null;
	ResultSet resultSet =null;
	String C1="SELECT ACTY_CODE, ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE=?";
		
	try{
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		resultSet = handler.executeSelectStatement(C1, connection,new Object[]{bean.getBAS_ACTY_CODE_2()});
		if(!resultSet.next()){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "1016"));
		}
/*	try{

		bean.setUI_M_ACTY_1_DESC(null);
		if(bean.getBAS_ACTY_CODE_2()!=null){
			ArrayList<String> retVariable=	new DBProcedures().P_VAL_ACTY (bean.getBAS_MAIN_ACNT_CODE(),
					bean.getBAS_ACTY_CODE_2(),
					"N", "E");

			if(retVariable.size()>0){
				bean.setUI_M_ACTY_2_DESC(retVariable.get(0));
			}
		}*/
	}catch (Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}finally{
		CommonUtils.closeCursor(resultSet);
	}

}


public ArrayList<LovBean> getActivityCodeLov(String code, String value)
			throws DBException {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		ArrayList<LovBean> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] obj = {};
		LovBean lovBean = null;

		try {
			list = new ArrayList<LovBean>();
			if ("*".equalsIgnoreCase(code)) {
				query = FETCH_ACTIVITY_CODE_LOV;
				obj = new Object[1];
				obj[0] = value;
				resultSet = handler.executeSelectStatement(query, connection);
			} else {
				query = FETCH_ACTIVITY_CODE_LOV_CONDITIONAL;
				obj = new Object[4];
				obj[0] = code + "%";
				obj[1] = code + "%";
				resultSet = handler.executeSelectStatement(query, connection, obj);
			}

			System.out.println("Query:::::  " + query);
			
			while (resultSet.next()) {
				lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				list.add(lovBean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}

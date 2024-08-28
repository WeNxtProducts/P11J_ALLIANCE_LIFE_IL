package com.iii.pel.forms.PLM010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM_CUSTOMER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;

	private HtmlInputText COMP_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_CUST_CLASS_LABEL;

	private HtmlInputText COMP_CUST_CLASS;

	private HtmlOutputLabel COMP_UI_M_CUST_CLASS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CUST_CLASS_DESC;

	private PM_CUSTOMER PM_CUSTOMER_BEAN;

	public PM_CUSTOMER_ACTION() {
		PM_CUSTOMER_BEAN = new PM_CUSTOMER();
	}

	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel COMP_CUST_CODE_LABEL) {
		this.COMP_CUST_CODE_LABEL = COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_CUST_CODE(HtmlInputText COMP_CUST_CODE) {
		this.COMP_CUST_CODE = COMP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel COMP_CUST_NAME_LABEL) {
		this.COMP_CUST_NAME_LABEL = COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME(HtmlInputText COMP_CUST_NAME) {
		this.COMP_CUST_NAME = COMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_CUST_CLASS_LABEL() {
		return COMP_CUST_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CLASS() {
		return COMP_CUST_CLASS;
	}

	public void setCOMP_CUST_CLASS_LABEL(HtmlOutputLabel COMP_CUST_CLASS_LABEL) {
		this.COMP_CUST_CLASS_LABEL = COMP_CUST_CLASS_LABEL;
	}

	public void setCOMP_CUST_CLASS(HtmlInputText COMP_CUST_CLASS) {
		this.COMP_CUST_CLASS = COMP_CUST_CLASS;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CLASS_DESC_LABEL() {  
		return COMP_UI_M_CUST_CLASS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CLASS_DESC() {
		return COMP_UI_M_CUST_CLASS_DESC;
	}

	public void setCOMP_UI_M_CUST_CLASS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CUST_CLASS_DESC_LABEL) {
		this.COMP_UI_M_CUST_CLASS_DESC_LABEL = COMP_UI_M_CUST_CLASS_DESC_LABEL;
	}

	public void setCOMP_UI_M_CUST_CLASS_DESC(HtmlInputText COMP_UI_M_CUST_CLASS_DESC) {
		this.COMP_UI_M_CUST_CLASS_DESC = COMP_UI_M_CUST_CLASS_DESC;
	}

	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}

	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER PM_CUSTOMER_BEAN) {
		this.PM_CUSTOMER_BEAN = PM_CUSTOMER_BEAN;
	}
	
	public String goto_PM_CUSTOMER_ACTION(){
		System.out.println("PM_CUSTOMER_ACTION.goto_PM_CUSTOMER_ACTION()");
		String return_string = "PLM010_goParentBlock";
		return return_string;
	}
	
	
	public String goto_PM_ASSURED_ACTION(){
		System.out.println("PM_CUSTOMER_ACTION.goto_PM_ASSURED_ACTION()");
		String return_string = "PLM010_goChildBlock";
		return return_string;
	}
	Connection connection=null;
	ResultSet resultSet;
	CommonUtils util=new CommonUtils();
	CRUDHandler handler=new CRUDHandler();
	
	public List getUnitCode_M_CUST_CODE(Object obj) throws Exception{
		List suggestionList = new ArrayList();
		getCOMP_CUST_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){
			query = "SELECT ROWID,CUST_CODE,CUST_NAME,CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' and rownum < 50 order by CUST_CODE asc";
		}else{
			query = "SELECT ROWID,CUST_CODE,CUST_NAME,CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' and CUST_CODE like '"+obj.toString()+"%' and rownum < 50 order by CUST_CODE asc";
		}
		connection = util.getConnection();
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setCUST_CODE(resultSet.getString("CUST_CODE"));
			cbean.setCUST_NAME(resultSet.getString("CUST_NAME"));
			suggestionList.add(cbean);
		}
		resultSet.close();
		return suggestionList;
	}
	
	public List getUnitCode_M_CCLAS_CODE(Object obj) throws Exception{
		List suggestionList = new ArrayList();
		getCOMP_CUST_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){
			query = "SELECT ROWID,CCLAS_CODE,CCLAS_CLASS_DESC,CCLAS_BL_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N' and rownum < 50 order by CCLAS_CODE asc";
		}else{
			query = "SELECT ROWID,CCLAS_CODE,CCLAS_CLASS_DESC,CCLAS_BL_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N' and CCLAS_CODE like '"+obj.toString()+"%' and rownum < 50 order by CCLAS_CODE asc";
		}
		connection = util.getConnection();
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setCUST_CLASS(resultSet.getString("CCLAS_CODE"));
			cbean.setUI_M_CUST_CLASS_DESC(resultSet.getString("CCLAS_CLASS_DESC"));
			suggestionList.add(cbean);
		}
		resultSet.close();
		return suggestionList;
	}
	
	 public void M_CUST_CLASS_DESC_when_validateListener(ActionEvent ae) throws Exception{
		 Bring_CCLAS_CLASS_DESC();
	      }
	
	
	 public void Bring_CCLAS_CLASS_DESC() throws Exception{
	    	
	    	System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_DEPT_FM_CODE_when_validateListener()");

	    	String CCLAS_CLASS_DESC = getCOMP_CUST_CLASS().getSubmittedValue().toString();
	    	String query = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC,CCLAS_BL_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N'" +
	    	               "AND CCLAS_CODE ='" + CCLAS_CLASS_DESC+"'";
	    	
	    	System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_DEPT_FM_CODE_when_validateListener()-query" + query);
	    	Connection con = CommonUtils.getConnection();
	    	resultSet = handler.executeSelectStatement(query, con);
	    	while(resultSet.next()){
	    		System.out.println("Inside while Loop");
	    		COMP_UI_M_CUST_CLASS_DESC.setSubmittedValue(resultSet.getString("CCLAS_CLASS_DESC"));
	    		
	       	}
	    	resultSet.close();
	    	//con.close();
	      }
	
	
	
	
	public void WHEN_NEW_ITEM_INSTANCE(){
		//LOAD_ITEM_HINT ;
	}

	public void WHEN_NEW_FORM_INSTANCE(){
		//null ;
	}
	
	public void WHEN_NEW_BLOCK_INSTANCE(){
		//CHECK_BLK_NAVG ;
	}
	
	public void WHEN_CREATE_RECORD(){
		//LOAD_DFLT_VALUES ;
	}
	
	public void WHEN_NEW_RECORD_INSTANCE(){
		//null ;
	}
	
	public void PRE_COMMIT(){
		//STD_PRE_COMMIT; ;
	}
	
	public void POST_DATABASE_COMMIT(){
		util.setGlobalObject("GLOBAL.M_FAILURE", false);
	}
	
	
	public void POST_QUERY(){
		try{
		ResultSet rs1;
		String CUST_CLASS_POST=getCOMP_CUST_CLASS().getSubmittedValue().toString();
		String sql_query=" SELECT CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE CCLAS_CODE = :'"+CUST_CLASS_POST+"'";
		rs1 = handler.executeSelectStatement(sql_query, util.getConnection());
		if(rs1.next()){
			String Cust_Class_Desc=rs1.getString("CCLAS_CLASS_DESC");
			PM_CUSTOMER_BEAN.setUI_M_CUST_CLASS_DESC(Cust_Class_Desc);
		}
		rs1.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void PRE_DELETE(){
		System.out.println("PT_GL_POL_COVER_ACTION.PT_GL_POL_COVER_PRE_DELETE()-Inside");
		try{
			String Cust_code=getCOMP_CUST_CODE().getSubmittedValue().toString();
			String sql_query2=" DELETE FROM PM_ASSURED WHERE ASSR_CUST_CODE = '"+Cust_code+"'";
			connection = CommonUtils.getConnection();																//	new Object[]{POL_SYS_ID}									
			handler.executeDeleteStatement(sql_query2, connection);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveRecord(ActionEvent event){
		System.out.println("PM_CUSTOMER_ACTION.SaveRecord()");
		try{ 
			if(PM_CUSTOMER_BEAN.getROWID() == null){
				handler.executeInsert(PM_CUSTOMER_BEAN, util.getConnection());	
			}else{
				handler.executeUpdate(PM_CUSTOMER_BEAN, util.getConnection());
			}
		 
		 connection.commit();
		 connection.close();
		
		}
		catch(Exception e){
		  e.printStackTrace();	
		}
		
	}
	
}

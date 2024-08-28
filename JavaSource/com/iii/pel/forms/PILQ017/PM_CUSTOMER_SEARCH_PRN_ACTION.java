package com.iii.pel.forms.PILQ017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class PM_CUSTOMER_SEARCH_PRN_ACTION{
	private List<PT_IL_POLICY> recordList;
	private HtmlDataTable dataTable;
	private PM_CUSTOMER_SEARCH_PRN PM_CUSTOMER_SEARCH_PRN_BEAN;
	
	private PM_CUSTOMER PM_CUSTOMER_BEAN;
	
	
	public PM_CUSTOMER_SEARCH_PRN_ACTION()
	{
		PM_CUSTOMER_SEARCH_PRN_BEAN = new PM_CUSTOMER_SEARCH_PRN();
		PM_CUSTOMER_BEAN = new PM_CUSTOMER();
	}

	public List<PT_IL_POLICY> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PT_IL_POLICY> recordList) {
		this.recordList = recordList;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public PM_CUSTOMER_SEARCH_PRN getPM_CUSTOMER_SEARCH_PRN_BEAN() {
		return PM_CUSTOMER_SEARCH_PRN_BEAN;
	}

	public void setPM_CUSTOMER_SEARCH_PRN_BEAN(
			PM_CUSTOMER_SEARCH_PRN pm_customer_search_prn_bean) {
		PM_CUSTOMER_SEARCH_PRN_BEAN = pm_customer_search_prn_bean;
	}
	
	public void fetchButtonClick(ActionEvent event){
			listAllRecords();
	}
	
	private String lov_Desc ;
	
	Map<String, String> keyValue = new HashMap<String, String>();
	
	public List listAllRecords(){
		//Object result1 = null;
		List<PT_IL_POLICY> recordList=new ArrayList<PT_IL_POLICY>();
		
		ConnectionAgent agent=new ConnectionAgent();
		CRUDHandler handler=new CRUDHandler();
		String queryString="select POL_NO,POL_PROD_CODE,POL_TRAN_DT,POL_ADDL_STATUS,CUST_CODE,CUST_SHORT_NAME from PT_IL_POLICY,PM_CUSTOMER where CUST_CODE=POL_CUST_CODE";
		ResultSet result=null;
		try {
			result=handler.executeSelectStatement(queryString,agent.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(result!=null){
				while(result.next()){
					PT_IL_POLICY bean=new PT_IL_POLICY();
					
					bean.setPOL_NO(result.getString("POL_NO"));
					bean.setPOL_PROD_CODE(result.getString("POL_PROD_CODE"));
					bean.setPOL_TRAN_DT(result.getDate("POL_TRAN_DT"));
					bean.setPOL_ADDL_STATUS(result.getString("POL_ADDL_STATUS"));
					recordList.add(bean);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordList;
	}
	
//Suggestion Box for Customer data
	PM_CUSTOMER newPM_CUSTOMER = newPM_CUSTOMER =new PM_CUSTOMER() ;
	public List suggestionList(Object object){
		System.out.println("The Value Entered is "+object.toString());
		List suggesionList = new ArrayList();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet LOVResultSet = null;
		String LOVQuery = null;
		
		try{
			connection = CommonUtils.getConnection();
		if(object.equals("*")){
			LOVQuery = "select CUST_CODE,CUST_SHORT_NAME from PM_CUSTOMER WHERE CUST_CODE IS NOT NULL ";
		}else{
			LOVQuery = "select CUST_CODE,CUST_SHORT_NAME from PM_CUSTOMER WHERE CUST_CODE IS NOT NULL LIKE '"+object.toString()+"%' AND ROWNUM  <25";
		}
		LOVResultSet = handler.executeSelectStatement(LOVQuery, connection);
		LOVResultSet.setFetchSize(25);
		
		while(LOVResultSet.next()){
			
			newPM_CUSTOMER.setCUST_CODE(LOVResultSet.getString("CUST_CODE"));
			newPM_CUSTOMER.setCUST_SHORT_NAME(LOVResultSet.getString("CUST_SHORT_NAME"));
			lov_Desc =  newPM_CUSTOMER.getCUST_SHORT_NAME();
			suggesionList.add(newPM_CUSTOMER);
			System.out.println("MAP \t"+ lov_Desc);
			keyValue.put(newPM_CUSTOMER.getCUST_CODE(), newPM_CUSTOMER.getCUST_SHORT_NAME());
			
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_01_DESC(LOVResultSet.getString(1));
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_02_DESC(LOVResultSet.getString(2));
//			suggesionList.add(newPP_LIFE_POL_SCH_PRN1);
		}
		LOVResultSet.close();
		//connection.close();
		
	}catch(Exception er){
		er.printStackTrace();
	}
		return suggesionList;
	}
// FOR DISPLAYING THE DESCRIPTION OF SUGGESTION BOX
	public void description(ActionEvent event) throws Exception
	{
		//PM_CUSTOMER newPM_CUSTOMER1 = new PM_CUSTOMER();
		//suggestionList(PM_CUSTOMER_BEAN);
		//System.out.println("The Value Entered is "+newPM_CUSTOMER.getCUST_CODE());
		String value = "";
	if(!"".equals(newPM_CUSTOMER.getCUST_CODE()))
			{
//			value = keyValue.get(getCOMP_MP_PROD_CODE().getValue());
//			System.out.println("Object value \t" + value);
//			getCOMP_UI_M_MP_PROD_CODE_DESC().setSubmittedValue(value);
		}		
}	
	
//getConnection Method
	/*public Connection getConnection(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context =null;
		SimpleConnectionAgent connectionAgent = null;
		Connection connection = null;
		try{
		context = (ServletContext)fc.getExternalContext().getContext();
		connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		connection =connectionAgent.getConnection("12345"); 
	
		}catch(Exception er){
			er.printStackTrace();
			}
		return connection; 
	}*/
}

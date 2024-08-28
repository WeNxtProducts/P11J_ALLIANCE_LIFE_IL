package com.iii.pel.forms.PILQ017;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.forms.GNMNF002.GNMNF002_A_APAC;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_ACTION {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_POL_TRAN_DT_LABEL;

	private HtmlCalendar COMP_POL_TRAN_DT;
	
	private HtmlOutputLabel COMP_UI_M_POL_PROP_LABEL;

	private HtmlInputText COMP_UI_M_POL_PROP;

	private HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL;

	private HtmlInputText COMP_POL_ADDL_STATUS;

	private HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_DESC;

	private HtmlOutputLabel COMP_UI_M_STATUS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_STATUS_DESC;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	
	private List<PT_IL_POLICY> fetchList = new ArrayList<PT_IL_POLICY>();
	
	private UIData dataTable;
	
	private int rowIndex ;
	
	PM_CUSTOMER action = null;
	
	private String M_NAME;
	
	private String M_BL_NAME;
	
	private int M_VALUE; 
	
	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
		return COMP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
		return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
		this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
		this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_TRAN_DT_LABEL() {
		return COMP_POL_TRAN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_TRAN_DT() {
		return COMP_POL_TRAN_DT;
	}

	public void setCOMP_POL_TRAN_DT_LABEL(HtmlOutputLabel COMP_POL_TRAN_DT_LABEL) {
		this.COMP_POL_TRAN_DT_LABEL = COMP_POL_TRAN_DT_LABEL;
	}

	public void setCOMP_POL_TRAN_DT(HtmlCalendar COMP_POL_TRAN_DT) {
		this.COMP_POL_TRAN_DT = COMP_POL_TRAN_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROP_LABEL() {
		return COMP_UI_M_POL_PROP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROP() {
		return COMP_UI_M_POL_PROP;
	}

	public void setCOMP_UI_M_POL_PROP_LABEL(HtmlOutputLabel COMP_UI_M_POL_PROP_LABEL) {
		this.COMP_UI_M_POL_PROP_LABEL = COMP_UI_M_POL_PROP_LABEL;
	}

	public void setCOMP_UI_M_POL_PROP(HtmlInputText COMP_UI_M_POL_PROP) {
		this.COMP_UI_M_POL_PROP = COMP_UI_M_POL_PROP;
	}

	public HtmlOutputLabel getCOMP_POL_ADDL_STATUS_LABEL() {
		return COMP_POL_ADDL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_ADDL_STATUS() {
		return COMP_POL_ADDL_STATUS;
	}

	public void setCOMP_POL_ADDL_STATUS_LABEL(HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL) {
		this.COMP_POL_ADDL_STATUS_LABEL = COMP_POL_ADDL_STATUS_LABEL;
	}

	public void setCOMP_POL_ADDL_STATUS(HtmlInputText COMP_POL_ADDL_STATUS) {
		this.COMP_POL_ADDL_STATUS = COMP_POL_ADDL_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_DESC_LABEL() {
		return COMP_UI_M_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DESC() {
		return COMP_UI_M_PROD_DESC;
	}

	public void setCOMP_UI_M_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
		this.COMP_UI_M_PROD_DESC_LABEL = COMP_UI_M_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_DESC(HtmlInputText COMP_UI_M_PROD_DESC) {
		this.COMP_UI_M_PROD_DESC = COMP_UI_M_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_DESC_LABEL() {
		return COMP_UI_M_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS_DESC() {
		return COMP_UI_M_STATUS_DESC;
	}

	public void setCOMP_UI_M_STATUS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_STATUS_DESC_LABEL) {
		this.COMP_UI_M_STATUS_DESC_LABEL = COMP_UI_M_STATUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_STATUS_DESC(HtmlInputText COMP_UI_M_STATUS_DESC) {
		this.COMP_UI_M_STATUS_DESC = COMP_UI_M_STATUS_DESC;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}
// Code for the CRUD operations Start.....................................
	
 // for Saving of Grid Data to the Database.
	public String Save(){
		System.out.println("Inside the Save ");
		CRUDHandler handler = new CRUDHandler();
		try {
			System.out.println("The POL_NO IS "+PT_IL_POLICY_BEAN.getPOL_NO());
			handler.executeInsert(PT_IL_POLICY_BEAN, getConnection());
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";	
	}

	// getConnection method to get the Connectivity to the database......................
	
	public Connection getConnection(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context =null;
		SimpleConnectionAgent connectionAgent = null;
		Connection connection = null;
		try{
		/*context = (ServletContext)fc.getExternalContext().getContext();
		connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		connection =connectionAgent.getConnection("12345");*/
			//[BugId:Fix Shankar Bodduluri 19-03-09 getting connection from CommonUtil class getConnection()
			connection = CommonUtils.getConnection();
		}catch(Exception er){
			er.printStackTrace();
			}
		return connection; 
	}

	public List<PT_IL_POLICY> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PT_IL_POLICY> fetchList) {
		this.fetchList = fetchList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

  // for fetching the data into Grid.....
	public void fetchGrid(ActionEvent actionEvent){
		System.out.println("Fetching the Data------------->");
	}
	
	public List Fetch(PM_CUSTOMER customer){
		CRUDHandler handler = new CRUDHandler();
		String selectQuery =  null;
		try{
			if(!"".equals(customer.getCUST_CODE())){
				selectQuery = "SELECT * FROM PT_IL_POLICY  WHERE POL_SYS_ID IN (SELECT POBH_POL_SYS_ID FROM PT_IL_POL_BROKER_HEAD " +
				"WHERE POBH_BROKER_CODE = '" + customer.getCUST_CODE()+
						"'   AND POBH_SRNO =1)  AND (POL_DS_TYPE = '2' OR POL_DS_TYPE = '1' AND POL_CONVERT_YN = 'N')";
				fetchList = handler.fetch(selectQuery, "com.iii.pel.forms.PILQ017.PT_IL_POLICY", getConnection());
				POST_QUERY();
		}
		}catch(Exception er){
			er.printStackTrace();
		}
		
	return fetchList;	
	}
	
	public void POST_QUERY(){
		PT_IL_POLICY policyBean = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = null;
		ResultSet resultSet = null;
		int beanSize = fetchList.size();
		CallableStatement callableStatement = null;
		for(int i = 0; i< beanSize;i++ ){
			policyBean = (PT_IL_POLICY)fetchList.get(i);
			selectQuery = "SELECT PROD_DESC	FROM PM_IL_PRODUCT WHERE PROD_CODE= '"+policyBean.getPOL_PROD_CODE()+"'";
			try{
				resultSet = handler.executeSelectStatement(selectQuery, CommonUtils.getConnection());
				while(resultSet.next()){
					fetchList.get(i).setUI_M_PROD_DESC(resultSet.getString(1));
					if(!"".equals(fetchList.get(i).getPOL_DS_TYPE())){
						if("1".equals(fetchList.get(i).getPOL_DS_TYPE())){
							fetchList.get(i).setUI_M_POL_PROP("Proposal");	
						}else if("2".equals(fetchList.get(i).getPOL_DS_TYPE())){
							fetchList.get(i).setUI_M_POL_PROP("Policy");
						}
					}
					if(!"".equals(fetchList.get(i).getPOL_ADDL_STATUS())){
						P_VAL_SYSTEM("IL_ADDL_STAT", fetchList.get(i).getPOL_ADDL_STATUS(), null , "N" , 0);
						fetchList.get(i).setUI_M_STATUS_DESC(getM_NAME());
					}
				}
			}catch(Exception er){
				er.printStackTrace();
			}
		}
	}
	
	public void P_VAL_SYSTEM(String P_TYPE, String P_CODE, String P_CODE_DESC , String P_ERR_FLAG, int P_VALUE){
		
		GNMNF002_A_APAC globalValues = new GNMNF002_A_APAC();
		String C1 = "";
		int count = 0;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		int size = fetchList.size();
		if(!"".equals(P_CODE)){
			C1= "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE ='"+ P_TYPE +"' AND PS_CODE  = '"+P_CODE+"'";
			System.out.println("The C1 Query is ...................................");
			try{
				resultSet = handler.executeSelectStatement(C1, CommonUtils.getConnection());
				while(resultSet.next()){
					setM_NAME(resultSet.getString(1));
					setM_BL_NAME(resultSet.getString(2));
					setM_VALUE(resultSet.getInt(3));
					
					//System.out.println("The M_FOR_LANG_CODE() is ................."+globalValues.getM_FOR_LANG_CODE());
					System.out.println("The getName is ......................."+getM_NAME());
		//			System.out.println("The Count Value is ........................"+count);
			
					//if("1".equals(globalValues.getM_FOR_LANG_CODE().substring(4, 1))){
						globalValues.setM_LANG_CODE("ENG");
						if(!"".equals(getM_NAME())){
						P_CODE_DESC = getM_NAME();
					}else{
						P_CODE_DESC = getM_BL_NAME();
					}
					P_VALUE = getM_VALUE();
					}
					if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
						STD_MESSAGE_ROUTINE("1000", globalValues.getM_FOR_LANG_CODE());
					}
			}catch(Exception er){
				er.printStackTrace();
			}
		}
	}

	
	
	 public String STD_MESSAGE_ROUTINE(String errorCode,String P_LANG_CODE){
		 CRUDHandler handler = new CRUDHandler();
		 String errmsg="";
		    try{
			String query = "SELECT DECODE('"+P_LANG_CODE+"', 'ENG', EM_ENG_MSG, EM_FOR_MSG),EM_ERR_FLAG FROM PP_ERROR_MESSAGE WHERE EM_ERR_NO = '"+errorCode+"'";
			System.out.println("query88888888888888"+query);
			ResultSet resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next()){
			 errmsg = resultSet.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("PM_IL_FUND_SETUP_ACTION.STD_MESSAGE_ROUTINE()-errmsg"+errmsg);
		return errmsg;
	}
	
	 
/*	 private Map<String, String> errorMap = new HashMap<String, String>();

	 if(Comp_Value < 0 ){
	 			System.out.println("TO CODE IS LESS THAN FROM CODEE");
	 			errmsg = STD_MESSAGE_ROUTINE("10064",getCtrlBean().getM_LANG_CODE());
	 			//STD_MESSAGE_ROUTINE('10064',:CTRL.M_LANG_CODE);
	 			errorMap.put("current", errmsg);
	 		}
*/	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_name) {
		M_NAME = m_name;
	}

	public String getM_BL_NAME() {
		return M_BL_NAME;
	}

	public void setM_BL_NAME(String m_bl_name) {
		M_BL_NAME = m_bl_name;
	}

	public int getM_VALUE() {
		return M_VALUE;
	}

	public void setM_VALUE(int m_value) {
		M_VALUE = m_value;
	}
	
}

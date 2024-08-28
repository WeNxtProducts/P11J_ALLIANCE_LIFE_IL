package com.iii.pel.forms.PLM010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class SearchBeanAction {
	
	private String initCustCode;
	private String initCustName;
	private String initAssrCode;
	private String initAssrName;
	
	private ArrayList<PM_ASSURED> namesList;
	private boolean checkBoxSelected;
	
	List recordList=new ArrayList<PM_ASSURED>();
	
	private UIData datGrid;
	private int searchPage;
	private int lastUpdatedRowIndex;
	
	public String getInitCustCode() {
		return initCustCode;
	}
	public void setInitCustCode(String initCustCode) {
		this.initCustCode = initCustCode;
	}
	public String getInitCustName() {
		return initCustName;
	}
	public void setInitCustName(String initCustName) {
		this.initCustName = initCustName;
	}
	public ArrayList<PM_ASSURED> getNamesList() {
		return namesList;
	}
	public void setNamesList(ArrayList<PM_ASSURED> namesList) {
		this.namesList = namesList;
	}
	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}
	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}
	public UIData getDatGrid() {
		return datGrid;
	}
	public void setDatGrid(UIData datGrid) {
		this.datGrid = datGrid;
	}
	public int getSearchPage() {
		return searchPage;
	}
	public void setSearchPage(int searchPage) {
		this.searchPage = searchPage;
	}
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}
	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	} 
	
	public String fetchCustomerDetails() {

		namesList = fetchSearchDetails(this);

		return null;

	}
	
	
	/*public String clearList()
	{
		namesList = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
		ELResolver resolver = context.getApplication().getELResolver();
		PM_ASSURED_ACTION actionBean = (PM_ASSURED_ACTION)resolver.getValue(context.getELContext(), null, "PLM010_PM_ASSURED_ACTION");;
		String custCode = req.getParameter("CustCode");
		String custName=req.getParameter("CustName");
		String assrCode = req.getParameter("AssrCode");
		String assrName=req.getParameter("AssrName");
		String Rowid = req.getParameter("CURRENT_ROWID");
		System.out.println("Rowid>>>>>"+Rowid);
		try{
		prepareClassMasterDetails(Rowid,custCode,custName,assrCode,assrName,actionBean);
		}catch(Exception e){e.printStackTrace();}
		String returnStr = "cclassmaster";
		return returnStr;
	}*/
	
	public String clearList()
	{
		namesList = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
		String custCode = req.getParameter("CustCode");
		String custName=req.getParameter("CustName");
		String assrCode = req.getParameter("AssrCode");
		String assrName=req.getParameter("AssrName");
		prepareClassMasterDetails(custCode,custName,assrCode,assrName);
		String returnStr = "PLM010_Cclassmaster";
		return returnStr;
	}
	
	
	public String clearSession() 
	{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession)context.getExternalContext().getSession(false);
		//PM020_A_TISB_COMPOSITE_ACTION actionBean=(PM020_A_TISB_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM020_A_TISB_COMPOSITE_ACTION");
		
		
		if (session.getAttribute("PLM010_PM_ASSURED_ACTION") != null) 
		{
			session.removeAttribute("PLM010_PM_ASSURED_ACTION");
			//session.removeAttribute("PLM010_PM_ASSURED_ACTION");
			
		}
		
		return "PLM010_Cclassmaster";
	}
	
	/*public Object prepareClassMasterDetails(String Rowid,String custCode,String custName,String assrCode,String assrName,PM_ASSURED_ACTION cClassHdrBean)
	{
		
		
		Connection connection=null;
		ResultSet resultSet=null;
		try 
		{
			String selectquery = "SELECT PC.CUST_CODE,PC.CUST_NAME,PA.ASSR_CODE,PA.ASSR_NAME,PA.ASSR_OCC_CODE,PA.ASSR_FLOOR," +
			"PA.ASSR_BUILDING,PA.ASSR_STREET,PA.ASSR_ADDR1,PA.ASSR_ADDR2,PA.ASSR_ADDR3,PA.ASSR_CONTACT,PA.ASSR_PHONE," +
			"PA.ASSR_FAX,PA.ASSR_OFFICE_PHONE,PA.ASSR_PIN_NO,PA.ASSR_DOB,PA.ASSR_ID_NO,PA.ASSR_VAT_NO,PA.ASSR_REMARKS," +
			"PA.ASSR_DFLT_YN,PA.ASSR_FRZ_FLAG,PA.ROWID FROM PM_CUSTOMER PC,PM_ASSURED PA " +
			"WHERE PC.CUST_CODE = '"+custCode+"' AND PC.CUST_NAME= '"+custName+"' AND PA.ASSR_CODE= '"+assrCode+"'" +
			"AND PA.ASSR_NAME= '"+assrName+"' AND PA.ROWID LIKE '"+Rowid+"'";
			System.out.println("selectquery"+selectquery);
			System.out.println("custCode>>>>>"+custCode);
			System.out.println("Rowid::::::"+Rowid);
			//connection=ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			//resultSet=handler.executeSelectStatement(PLM010_QUERY_CONSTANT.CASSUREDMASTERDETAILS,connection,new Object[]{cClassHdrBean.getASSR_CUST_CODE(),cClassHdrBean.getCUST_NAME(),cClassHdrBean.getASSR_CODE(),cClassHdrBean.getASSR_NAME()});
			//List list=(List) handler.executeSelectStatement(PLM010_QUERY_CONSTANT.CASSUREDMASTERDETAILS,connection,new Object[]{cClassHdrBean.getASSR_CUST_CODE(),cClassHdrBean.getCUST_NAME(),cClassHdrBean.getASSR_CODE(),cClassHdrBean.getASSR_NAME()});
			PM_ASSURED cClassHdr = cClassHdrBean.getPM_ASSURED_BEAN();
			List list = handler.fetch(selectquery, "com.iii.pel.forms.PLM010.PM_ASSURED",connection);
			cClassHdr = (PM_ASSURED)list.get(0);
			System.out.println("pm_il_bank_account_setup>>>>>>>>>>>>"+cClassHdrBean);
			cClassHdr.setASSR_CUST_CODE(custCode);
			cClassHdr.setCUST_NAME(custName);
			cClassHdrBean.setPM_ASSURED_BEAN(cClassHdr);
			cClassHdr.setCUST_NAME(assrName);
			cClassHdrBean.setPM_ASSURED_BEAN(cClassHdr);
			cClassHdrBean.getCOMP_ASSR_CUST_CODE().setDisabled(true);
			cClassHdrBean.getCOMP_ASSR_CODE().setDisabled(true);
			CommonUtils.objectSysout(cClassHdr);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cClassHdrBean;
	}*/
	
	public Object prepareClassMasterDetails(String custCode,String custName,String assrCode,String assrName)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_ASSURED_ACTION pi_lm_composite_action = new PM_ASSURED_ACTION();
		session.setAttribute("PLM010_PM_ASSURED_ACTION", pi_lm_composite_action);
		PM_ASSURED cust_class=pi_lm_composite_action.getPM_ASSURED_BEAN();
		cust_class.setASSR_CUST_CODE(custCode);
		cust_class.setCUST_NAME(custName);
		cust_class.setASSR_CODE(assrCode);
		cust_class.setASSR_NAME(assrName);
		prepareCustomerClassDetails(cust_class);
		pi_lm_composite_action.getCOMP_ASSR_CUST_CODE().setDisabled(true);
		pi_lm_composite_action.getCOMP_ASSR_CODE().setDisabled(true);
		pi_lm_composite_action.getCOMP_CUST_NAME().setDisabled(true);
		
		
		
		
		return "";
	}
	public Object prepareCustomerClassDetails(PM_ASSURED cClassHdrBean)
	{
		Connection connection=null;
		ResultSet resultSet=null;
		try 
		{
			String selectquery = "SELECT PC.CUST_CODE,PC.CUST_NAME,PA.ASSR_CODE,PA.ASSR_NAME,PA.ASSR_OCC_CODE,PA.ASSR_FLOOR," +
			"PA.ASSR_BUILDING,PA.ASSR_STREET,PA.ASSR_ADDR1,PA.ASSR_ADDR2,PA.ASSR_ADDR3,PA.ASSR_CONTACT,PA.ASSR_PHONE," +
			"PA.ASSR_FAX,PA.ASSR_OFFICE_PHONE,PA.ASSR_PIN_NO,PA.ASSR_DOB,PA.ASSR_ID_NO,PA.ASSR_VAT_NO,PA.ASSR_REMARKS," +
			"PA.ASSR_DFLT_YN,PA.ASSR_FRZ_FLAG,PA.ASSR_BL_NAME,PA.ASSR_BL_ADDR1,PA.ASSR_BL_ADDR2,PA.ASSR_BL_ADDR3,PA.ROWID FROM PM_CUSTOMER PC,PM_ASSURED PA " +
			"WHERE PC.CUST_CODE = '"+cClassHdrBean.getASSR_CUST_CODE()+"' AND PA.ASSR_CODE= '"+cClassHdrBean.getASSR_CODE()+"'";
			System.out.println("selectquery " +selectquery);
			
			//connection=ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			resultSet=handler.executeSelectStatement(selectquery, connection);
			while(resultSet.next())
			{
				cClassHdrBean.setASSR_OCC_CODE(resultSet.getString(5));
				cClassHdrBean.setASSR_FLOOR(resultSet.getString(6));
				cClassHdrBean.setASSR_BUILDING(resultSet.getString(7));
				cClassHdrBean.setASSR_STREET(resultSet.getString(8));
				cClassHdrBean.setASSR_ADDR1(resultSet.getString(9));
				cClassHdrBean.setASSR_ADDR2(resultSet.getString(10));
				cClassHdrBean.setASSR_ADDR3(resultSet.getString(11));
				cClassHdrBean.setASSR_CONTACT(resultSet.getString(12));
				cClassHdrBean.setASSR_PHONE(resultSet.getString(13));
				cClassHdrBean.setASSR_FAX(resultSet.getString(14));
				cClassHdrBean.setASSR_OFFICE_PHONE(resultSet.getString(15));
				cClassHdrBean.setASSR_PIN_NO(resultSet.getString(16));
				cClassHdrBean.setASSR_DOB(resultSet.getDate(17));
				cClassHdrBean.setASSR_ID_NO(resultSet.getString(18));
				cClassHdrBean.setASSR_VAT_NO(resultSet.getString(19));
				cClassHdrBean.setASSR_REMARKS(resultSet.getString(20));
				cClassHdrBean.setASSR_DFLT_YN(resultSet.getString(21));
				cClassHdrBean.setASSR_FRZ_FLAG(resultSet.getString(22));
				cClassHdrBean.setASSR_BL_NAME(resultSet.getString(23));
				cClassHdrBean.setASSR_BL_ADDR1(resultSet.getString(24));
				cClassHdrBean.setASSR_BL_ADDR2(resultSet.getString(25));
				cClassHdrBean.setASSR_BL_ADDR3(resultSet.getString(26));
				cClassHdrBean.setROWID(resultSet.getString(27));
				cClassHdrBean.setInsertMode(false);
			}
		String sql_dec="select PC_DESC from PM_CODES WHERE PC_TYPE like 'OCCUPATION' AND " +
				"PC_CODE IN(SELECT DISTINCT(ASSR_OCC_CODE) FROM PM_ASSURED " +
				"WHERE ASSR_CUST_CODE = '"+cClassHdrBean.getASSR_CUST_CODE()+"' AND ASSR_CODE='"+cClassHdrBean.getASSR_CODE()+"')";	
		System.out.println("sql_dec"+sql_dec);
		ResultSet rs_desc;
		rs_desc=handler.executeSelectStatement(sql_dec, connection);
		if(rs_desc.next()){
			cClassHdrBean.setUI_M_ASSR_OCC_DESC(rs_desc.getString(1));
			CommonUtils.objectSysout(cClassHdrBean);
			cClassHdrBean.setInsertMode(false);
		}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cClassHdrBean;
	}
	
	
	
	public ArrayList fetchSearchDetails(SearchBeanAction searchBeanAction) {

		Connection connection = null;
		ResultSet resultSet = null;
		ArrayList<PM_ASSURED> beanList = new ArrayList<PM_ASSURED>();
		String selectQuery = "SELECT PC.CUST_CODE,PC.CUST_NAME,PA.ASSR_CODE,PA.ASSR_NAME,PA.ROWID " +
								"FROM PM_CUSTOMER PC,PM_ASSURED PA WHERE PC.CUST_CODE = PA.ASSR_CUST_CODE";
		boolean flag = false;

		if (searchBeanAction.getInitCustCode() != null
				&& searchBeanAction.getInitCustCode().trim().length() > 0) {
			selectQuery = selectQuery + " AND UPPER(PC.CUST_CODE) LIKE " + "'"
					+ searchBeanAction.getInitCustCode().toUpperCase() + "%'";
			flag = true;
		}
		if (searchBeanAction.getInitCustName() != null
				&& searchBeanAction.getInitCustName().trim().length() > 0) {
			if (!flag) {
				selectQuery = selectQuery + " AND UPPER(PC.CUST_NAME) LIKE "
						+ "'"
						+ searchBeanAction.getInitCustName().toUpperCase()
						+ "%'";
			} else {
				selectQuery = selectQuery + " AND UPPER(PA.CUST_NAME) LIKE "
						+ "'"
						+ searchBeanAction.getInitCustName().toUpperCase()
						+ "%'";
			}
		}
		if (searchBeanAction.getInitAssrCode() != null
				&& searchBeanAction.getInitAssrCode().trim().length() > 0) {
			selectQuery = selectQuery + " AND UPPER(PA.ASSR_CODE) LIKE " + "'"
					+ searchBeanAction.getInitAssrCode().toUpperCase() + "%'";
			flag = true;
			System.out.println("selectQuery for assured code" +selectQuery);
		}
		if (searchBeanAction.getInitAssrName() != null
				&& searchBeanAction.getInitAssrName().trim().length() > 0) {
			if (!flag) {
				selectQuery = selectQuery + " AND UPPER(PA.ASSR_NAME) LIKE "
						+ "'"
						+ searchBeanAction.getInitAssrName().toUpperCase()
						+ "%'";
			} else {
				selectQuery = selectQuery + " AND UPPER(PC.ASSR_NAME) LIKE "
						+ "'"
						+ searchBeanAction.getInitAssrName().toUpperCase()
						+ "%'";
			}
		}

		try {
			
			//connection =ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			selectQuery = selectQuery + " ORDER BY 1,3" ;
			System.out.println("selectQueryis "+selectQuery);
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				PM_ASSURED pm_cust_class = new PM_ASSURED();
				pm_cust_class.setASSR_CUST_CODE(resultSet.getString(1));
				pm_cust_class.setCUST_NAME(resultSet.getString(2));
				pm_cust_class.setASSR_CODE(resultSet.getString(3));
				pm_cust_class.setASSR_NAME(resultSet.getString(4));
				beanList.add(pm_cust_class);
				pm_cust_class.setROWID(resultSet.getString(5));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				
				//connection.close();

			} catch (Exception exception) {
				exception.printStackTrace();

			}

		}
		return beanList;
	}
	
	public String deleteRow()
	{
		PM_ASSURED bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(namesList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<namesList.size();)
			{
				bean = namesList.get(index);
				if(bean.isCheckBoxSelected()){
					deletedRecordList.add(bean);
					namesList.remove(bean);
					
				}else
				{
					index++;
				}
			}
			if(deletedRecordList.size()>0)
			{
				executeDelete(deletedRecordList);
				deletedRecordList.clear();
			}
			
			lastUpdatedRowIndex = -1;
		}
		deletedRecordList.clear();
		return "";
}
	
	public int executeDelete(List<PM_ASSURED> deleteList)
	{
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		int recordDeleted=0;
		try{
		connection=CommonUtils.getConnection();
		for(int listidx=0;listidx<deleteList.size();listidx++)
		{
			PM_ASSURED pm_cust_class=deleteList.get(listidx);
			recordDeleted=handler.executeDelete(pm_cust_class, connection);
		}
		deleteList=null;
		connection.commit();
		}
		catch(Exception e){e.printStackTrace();try {
			connection.rollback();
		} catch (Exception se) {
			se.printStackTrace();
		}}
		return recordDeleted;
	}
	
	public int executeInsert(Object object)
	{
		Connection connection=null;
		int recordCount=0;
		try 
		{
			//connection=ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			recordCount=handler.executeInsert(object,connection);
			connection.commit();
			
		} catch (Exception e)
		{
			try{
			connection.rollback();}catch(Exception ae){ae.printStackTrace();}
			e.printStackTrace();
		}
		return recordCount;
	}
	
	
	public String getInitAssrCode() {
		return initAssrCode;
	}
	public void setInitAssrCode(String initAssrCode) {
		this.initAssrCode = initAssrCode;
	}
	public String getInitAssrName() {
		return initAssrName;
	}
	public void setInitAssrName(String initAssrName) {
		this.initAssrName = initAssrName;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

}

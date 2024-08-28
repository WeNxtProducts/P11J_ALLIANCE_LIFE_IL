
package com.iii.pel.forms.PM101_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;



public class PM_AGENT_PF_COMP_CONT_SearchAction extends CommonAction{
	private UIInput uiMarketCode;
	private UIInput uiRankCode;
	private UIData dataTable;
	private PM_AGENT_PF_COMP_CONT searchBean;
	private List<PM_AGENT_PF_COMP_CONT> dataTableBean;
	
	
	public PM_AGENT_PF_COMP_CONT_SearchAction(){
		
			searchBean = new PM_AGENT_PF_COMP_CONT();	
		}
		
	
	
	public UIInput getUiMarketCode() {
		return uiMarketCode;
	}
	public void setUiMarketCode(UIInput uiMarketCode) {
		this.uiMarketCode = uiMarketCode;
	}
	public UIInput getUiRankCode() {
		return uiRankCode;
	}
	public void setUiRankCode(UIInput uiRankCode) {
		this.uiRankCode = uiRankCode;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public PM_AGENT_PF_COMP_CONT getSearchBean() {
		return searchBean;
	}



	public void setSearchBean(PM_AGENT_PF_COMP_CONT searchBean) {
		this.searchBean = searchBean;
	}



	public List<PM_AGENT_PF_COMP_CONT> getDataTableBean() {
		return dataTableBean;
	}



	public void setDataTableBean(List<PM_AGENT_PF_COMP_CONT> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}



	public String insert(){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION")!=null)
		{
			session.removeAttribute("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION");
		}
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "INSERT");
		sessionMap.put("CLIENT_CON", getConnection());
		return "insert";
	}
	
	
	public String fetch(){
		PM101_A_TISB_SearchDelegate delegate = new PM101_A_TISB_SearchDelegate();
		this.dataTableBean = delegate.fetchMasterBlock(this);
		if(this.dataTableBean.size()<=0)
		{
			getErrorMap().put("current", "No such criteria available on search");
		}else{
			getErrorMap().clear();
		}
		
		return null;

	}
	
	
	public String fetchMasterRecord(){
		FacesContext context=FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String mktCode=(String)map.get("APCC_MKT_CODE");
		String prodType = (String)map.get("APCC_PROD_TYPE");
		String contrFrom= (String)map.get("APCC_CONT_FM");
		String contrRate=(String)map.get("APCC_RATE");
		String rowId=(String)map.get("ROWID");
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_AGENT_PF_COMP_CONT_ACTION sessionBean=(PM_AGENT_PF_COMP_CONT_ACTION)session.getAttribute("PM_AGENT_PF_COMP_CONT_ACTION");
		try{
		String selectQuery = "select ROWID,PM_AGENT_PF_COMP_CONT.* FROM PM_AGENT_PF_COMP_CONT where ROWID='"+rowId+"'and APCC_MKT_CODE='" +mktCode+"'and APCC_PROD_TYPE='"+prodType+"'and  APCC_CONT_FM='"+contrFrom+"'and APCC_RATE='"+contrRate+"'";
		System.out.println("PM_AGENT_PF_COMP_CONT_SearchAction.fetchMasterRecord()--1-["+selectQuery+"]");
		
		List list = getHandler().fetch(selectQuery, "com.iii.pel.forms.PM101_A_TISB.PM_AGENT_PF_COMP_CONT", getConnection());
		PM_AGENT_PF_COMP_CONT valueBean=(PM_AGENT_PF_COMP_CONT)list.get(0);
		
		ELResolver resolver = context.getApplication().getELResolver();
		PM_AGENT_PF_COMP_CONT_ACTION actionBean= (PM_AGENT_PF_COMP_CONT_ACTION)resolver.getValue(context.getELContext(), null, "PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION");
		if(actionBean == null) {
			System.out.println("bean null");
		}
		valueBean.setUI_M_APCC_MKT_CODE_DESC(getCodeDesc(actionBean,valueBean,"MKTCODE"));
		valueBean.setUI_M_APCC_RANK_CODE_DESC(getCodeDesc(actionBean,valueBean,"AGNRANK"));
		actionBean.setPM_AGENT_PF_COMP_CONT_BEAN(valueBean);
		System.out	.println("PM_AGENT_PF_SETUP_SearchAction.fetchMasterRecord()--------------------["+actionBean.getPM_AGENT_PF_COMP_CONT_BEAN().getAPCC_RANK_CODE()+"]");
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "UPDATE");
		sessionMap.put("CLIENT_CON", getConnection());
		actionBean.setUpdate(true);
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return "fetchMasterRecord";
	}
	
	
	public String getCodeDesc(PM_AGENT_PF_COMP_CONT_ACTION actionBean,PM_AGENT_PF_COMP_CONT valueBean,String code) throws SQLException{
		ResultSet rs =null;
		String condition=code;
		String query =null;
		String desc =null;
		if(condition.equalsIgnoreCase("MKTCODE")){
			
	
		String codeValue= valueBean.getAPCC_MKT_CODE();
		if(!codeValue.equals("")|| codeValue!=null){
		query= "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"+
							codeValue+"'";
		}
		}else if(condition.equalsIgnoreCase("AGNRANK")){
			String codeValue = valueBean.getAPCC_RANK_CODE();
			if(!codeValue.equals("")|| codeValue!=null){
				query = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' and PC_CODE ='"+
				codeValue+"'";
			}
		}
			
			
				
		 rs = getHandler().executeSelectStatement(query, getConnection());
		if(rs.next()){
			desc = rs.getString(1);
					}
		rs.close();
		
		return desc;
		
	}
	
	
	public String deleteRow() {
		PM_AGENT_PF_COMP_CONT deleteBean = null;
		int deletedRecordIndex = 0;
		if(dataTableBean.size()!=0){
			PM101_A_TISB_SearchDelegate gridDelegate = new PM101_A_TISB_SearchDelegate();
			for(int i =0;i<dataTableBean.size();){
				deleteBean = (PM_AGENT_PF_COMP_CONT)dataTableBean.get(i);
				System.out.println("DELETE["+deleteBean.isSelected());
				if(deleteBean.isSelected()){
					dataTableBean.remove(deleteBean);
					deletedRecordIndex = gridDelegate.deleteData(deleteBean);
				}else{
					i++;
				}
			}
		}
		
		
		
		return null;
	}
	
	//****************************************************************************************
	
	public Connection getConnection() {
		Connection con =null;
		
	 try {
		 con =  CommonUtils.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
		
	}
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	

}

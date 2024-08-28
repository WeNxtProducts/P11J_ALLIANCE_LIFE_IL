package com.iii.pel.forms.PM100_A_TISB;

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

public class PM_AGENT_PF_SETUP_SearchAction extends CommonAction {
	
	private UIInput uiAgentMarketingCode;
	private UIInput uiAgentRankCode;
	private UIData dataTable;
	private PM_AGENT_PF_SETUP searchBean;
	private List<PM_AGENT_PF_SETUP> dataTableBean;
	
	
	public PM_AGENT_PF_SETUP_SearchAction(){
		searchBean = new PM_AGENT_PF_SETUP();	
	}
	
	public UIInput getUiAgentMarketingCode() {
		return uiAgentMarketingCode;
	}
	public void setUiAgentMarketingCode(UIInput uiAgentMarketingCode) {
		this.uiAgentMarketingCode = uiAgentMarketingCode;
	}
	public UIInput getUiAgentRankCode() {
		return uiAgentRankCode;
	}
	public void setUiAgentRankCode(UIInput uiAgentRankCode) {
		this.uiAgentRankCode = uiAgentRankCode;
	}
	
	
	public PM_AGENT_PF_SETUP getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PM_AGENT_PF_SETUP searchBean) {
		this.searchBean = searchBean;
	}

	public List<PM_AGENT_PF_SETUP> getDataTableBean() {
		return dataTableBean;
	}

	public void setDataTableBean(List<PM_AGENT_PF_SETUP> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}

	public String fetch(){
		PM100_A_TISB_SearchDelegate delegate = new PM100_A_TISB_SearchDelegate();
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
		String mktCode = (String)map.get("APS_MKT_CODE");
		String expMonth = (String)map.get("APS_EXP_MONTHS");
		String rankCode=(String)map.get("APS_RANK_CODE");
		String commType=null;
		if(((String)map.get("APS_COMM_TYPE")).startsWith("First")){
		commType = "F";
		}else if(((String)map.get("APS_COMM_TYPE")).startsWith("Total")){
			commType="T";
		}
		
		String CommRatePer=(String)map.get("APS_COMM_RATE_PER");
		String CommPer=(String)map.get("APS_COMM_PER");
		String rowId=(String)map.get("ROWID");
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_AGENT_PF_SETUP_ACTION sessionBean=(PM_AGENT_PF_SETUP_ACTION)session.getAttribute("PM_AGENT_PF_SETUP_ACTION");
		try{
		String selectQuery = "select ROWID,PM_AGENT_PF_SETUP.* FROM PM_AGENT_PF_SETUP where ROWID='"+rowId+"'and APS_MKT_CODE='" +mktCode+"'and	APS_EXP_MONTHS='"+expMonth+"'and  APS_COMM_TYPE='"+commType+"'and APS_COMM_RATE_PER='"+CommRatePer+"'and APS_COMM_PER='"+CommPer+"' and APS_RANK_CODE='"+rankCode+"'";
		System.out
				.println("PM_AGENT_PF_SETUP_SearchAction.fetchMasterRecord()-----SELECT QUERY-----******["+selectQuery+"]");
		
		List list = getHandler().fetch(selectQuery, "com.iii.pel.forms.PM100_A_TISB.PM_AGENT_PF_SETUP", getConnection());
		PM_AGENT_PF_SETUP valueBean=(PM_AGENT_PF_SETUP)list.get(0);
		
		ELResolver resolver = context.getApplication().getELResolver();
		PM_AGENT_PF_SETUP_ACTION actionBean= (PM_AGENT_PF_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PM_AGENT_PF_SETUP_ACTION");
		if(actionBean == null) {
			System.out.println("bean null");
		}
		valueBean.setUI_M_APS_MKT_CODE_DESC(getMktCodeDesc(actionBean,valueBean,"MKTCODE"));
		valueBean.setUI_M_APS_RANK_CODE_DESC(getMktCodeDesc(actionBean,valueBean,"AGNRANK"));

		actionBean.setPM_AGENT_PF_SETUP_BEAN(valueBean);
		actionBean.setUpdate(true);
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return "fetchMasterRecord";
	}
	
	public String insert(){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PM_AGENT_PF_SETUP_ACTION")!=null)
		{
			session.removeAttribute("PM_AGENT_PF_SETUP_ACTION");
		}
		return "insert";
	}
	
	public Connection getConnection() {
		Connection con =null;
		
	 try {
		 con = CommonUtils.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
		
	}
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	public String getMktCodeDesc(PM_AGENT_PF_SETUP_ACTION actionBean,PM_AGENT_PF_SETUP valueBean,String code) throws SQLException{
		ResultSet rs =null;
		String condition=code;
		String query =null;
		String desc =null;
		if(condition.equalsIgnoreCase("MKTCODE")){
			
	
		String codeValue= valueBean.getAPS_MKT_CODE();
		if(!codeValue.equals("")|| codeValue!=null){
		query= "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"+
							codeValue+"'";
		}
		}else if(condition.equalsIgnoreCase("AGNRANK")){
			String codeValue = valueBean.getAPS_RANK_CODE();
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
		PM_AGENT_PF_SETUP deleteBean = null;
		int deletedRecordIndex = 0;
		if(dataTableBean.size()!=0){
			PM100_A_TISB_SearchDelegate gridDelegate = new PM100_A_TISB_SearchDelegate();
			for(int i =0;i<dataTableBean.size();){
				deleteBean = (PM_AGENT_PF_SETUP)dataTableBean.get(i);
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
	
	

}

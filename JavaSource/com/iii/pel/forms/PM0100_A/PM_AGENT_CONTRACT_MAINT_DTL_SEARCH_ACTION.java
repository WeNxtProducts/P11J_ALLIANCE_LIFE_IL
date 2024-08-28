package com.iii.pel.forms.PM0100_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;


public class PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION extends CommonAction{
	private HtmlDataTable dataTable;
	private List<PM_AGENT_CONTRACT_MAINT_DTL_SEARCH> classMasterList;

	private String ACMD_RANK_CODE;

	public PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION() {
		classMasterList = new ArrayList<PM_AGENT_CONTRACT_MAINT_DTL_SEARCH>();
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String clearSession()
	{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		System.out
				.println("PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION.clearSession() calledddd");
		if(session.getAttribute("PM0100_A_PM_AGENT_CONTRACT_MAINT_DTL_ACTION")!=null){
			System.out
					.println("PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION.clearSession() in side if looppp");
			session.removeAttribute("PM0100_A_PM_AGENT_CONTRACT_MAINT_DTL_ACTION");
		}
		return "AgentMaster";
	}
	

	public String clearList() throws Exception {

		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		String selectQuery = "Select ROWID, PM_AGENT_CONTRACT_MAINT_DTL.* from PM_AGENT_CONTRACT_MAINT_DTL where ACMD_RANK_CODE='"+request.getParameter("RankCode")+"'AND ACMD_PROD_TYPE='"+request.getParameter("ProdType")+"'";
		System.out
				.println("PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION.clearList() >>>> query "+selectQuery); 
		Connection con = getConnection();
		CRUDHandler handler = new CRUDHandler();
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PM0100_A.PM_AGENT_CONTRACT_MAINT_DTL", con);
		PM_AGENT_CONTRACT_MAINT_DTL dtl = (PM_AGENT_CONTRACT_MAINT_DTL) list.get(0);
		//PM_AGENT_CONTRACT_MAINT_DTL_ACTION actionBean = (PM_AGENT_CONTRACT_MAINT_DTL_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PM_AGENT_CONTRACT_MAINT_DTL_ACTION");
		//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String descQuery = "SELECT PC_CODE, DECODE('N','N',PC_DESC ,'L',NVL(PC_LONG_DESC,PC_DESC),PC_DESC) AS LONGDESC FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE='"+dtl.getACMD_RANK_CODE()+"'";
		ResultSet rs = con.createStatement().executeQuery(descQuery);
		while(rs.next()){
			dtl.setUI_M_ACMD_RANK_CODE_DESC(rs.getString(2));
		}
		 
		HttpSession session = request.getSession();
		PM_AGENT_CONTRACT_MAINT_DTL_ACTION actionBean = (PM_AGENT_CONTRACT_MAINT_DTL_ACTION) session.getAttribute("PM0100_A_PM_AGENT_CONTRACT_MAINT_DTL_ACTION");
		
		actionBean.setPM_AGENT_CONTRACT_MAINT_DTL_BEAN(dtl);		
		actionBean.setUpdate(true);
		return "AgentMaster";
	}
	
	/*public Object prepareClassMasterDetails() throws Exception
	{
		
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		//HttpSession session=request.getSession();
		//PM_IL_CLASS_ACTION pi_lm_action=(PM_IL_CLASS_ACTION)session.getAttribute("PM_IL_CLASS_ACTION");
		PM_IL_CLASS_ACTION pi_lm_action=(PM_IL_CLASS_ACTION)request.getAttribute("PM_IL_CLASS_ACTION");
		System.out.println("Before Going: "+pi_lm_action.getPM_IL_CLASS_BEAN().hashCode());
		new PILM001_CRUD().fetchClassDetails(pi_lm_action.getPM_IL_CLASS_BEAN().getCLASS_CODE(),pi_lm_action.getPM_IL_CLASS_BEAN());
		
		String selectQuery = "Select * from PM_AGENT_CONTRACT_MAINT_DTL where ACMD_RANK_CODE='"+rankCode+"'AND ACMD_PROD_TYPE='"+prodType+"'AND ACMD_FM_DT='"+fromDate+"'AND ACMD_TO_DT='"+toDate+"'";
		Connection con = getConnection();
		CRUDHandler handler = new CRUDHandler();
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PM0100_A.PM_AGENT_CONTRACT_MAINT_DTL", con);
		PM_AGENT_CONTRACT_MAINT_DTL dtl = (PM_AGENT_CONTRACT_MAINT_DTL) list.get(0);
		PM_AGENT_CONTRACT_MAINT_DTL_ACTION actionBean = (PM_AGENT_CONTRACT_MAINT_DTL_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PM_AGENT_CONTRACT_MAINT_DTL_ACTION");
		actionBean.setPM_AGENT_CONTRACT_MAINT_DTL_BEAN(dtl);
		//List list = handler.fetch(selectQuery, className, con)
		return "AgentMaster";
	}*/
	
	private Connection getConnection() throws Exception{		
		Connection con = PM_AGENT_CONTRACT_MAINT_DTL_ACTION.getConnection();
		return con;
	}

	public String fetchClassDetails() {
		ClassMasterDelegate delegate = new ClassMasterDelegate();

		try {
			this.classMasterList = delegate.fetchClassMasterDetails(this);
			if(this.classMasterList.size()==0){
				getWarningMap().put("current", "There is no record for this search criteria");
				}else{
					getWarningMap().clear();
				}
		} catch (Exception e) {
			// TODO do appropriate settings for the message to display to the
			// user
			e.printStackTrace();
		}

		return null;
	}
	/*
	 * public Object prepareClassMasterDetails() { FacesContext
	 * context=FacesContext.getCurrentInstance(); HttpServletRequest
	 * request=(HttpServletRequest)context.getExternalContext().getRequest();
	 * HttpSession session=request.getSession(); PM_IL_CONTRACTOR_SEARCH_ACTION
	 * pi_lm_action=(PM_IL_CONTRACTOR_SEARCH_ACTION)session.getAttribute("PM_IL_CONTRACTOR_SEARCH_ACTION");
	 * ClassMasterDelegate classDelegate=new ClassMasterDelegate();
	 * classDelegate.fetchClassDetails(pi_lm_action.getPM_IL_CLASS_BEAN().getCLASS_CODE(),pi_lm_action.getPM_IL_CLASS_BEAN());
	 * pi_lm_action.getCOMP_CLASS_FACIN_YN().setSubmittedValue("YES");
	 * 
	 * 
	 * 
	 * return "Hello"; }
	 */

	public List getClassMasterList() {
		if(classMasterList.size() != 0){
		System.out.println("\n\n The values are:  "+((PM_AGENT_CONTRACT_MAINT_DTL_SEARCH)classMasterList.get(0)).getACMD_RANK_CODE());
		}
		return classMasterList;
	}

	public void setClassMasterList(List classMasterList) {
		this.classMasterList = classMasterList;
	}

	public String getACMD_RANK_CODE() {
		return ACMD_RANK_CODE;
	}

	public void setACMD_RANK_CODE(String acmd_rank_code) {
		ACMD_RANK_CODE = acmd_rank_code;
	}
	
	public String showForm(){
		return null;
	}
	public void delete(ActionEvent ae) throws Exception{
		System.out.println("agent contract .delete() beginningg");
		PM_AGENT_CONTRACT_MAINT_DTL_SEARCH bean = null;
		if(classMasterList!=null){
			for(int index =0; index<classMasterList.size();){
				bean = (PM_AGENT_CONTRACT_MAINT_DTL_SEARCH) classMasterList.get(index);
				if(bean.isCHECK_BOX()){
					classMasterList.remove(bean);
					CRUDHandler handler=new CRUDHandler();
					String deleteQuery="DELETE FROM PM_AGENT_CONTRACT_MAINT_DTL WHERE ROWID='"+bean.getROWID()+"'";
					System.out.println("agent contract.delete() "+deleteQuery);
					handler.executeDeleteStatement(deleteQuery,getConnection() );
				}else{
					index++;
				}

			}
		}
		getConnection().commit();
	}
	public void checkBoxStatus(ActionEvent ae){
		 
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION.checkBoxStatus() ^^^^******");
	}
	
	
	// Method Added For Common Search by Akash Singh dated 31-jan-2012
	public String updateButtonAction(String rowId) throws Exception{
		PM_AGENT_CONTRACT_MAINT_DTL_ACTION action = new PM_AGENT_CONTRACT_MAINT_DTL_ACTION();
		String outcome = null;
		try {
			CommonUtils.setGlobalObject("PM0100_A_PM_AGENT_CONTRACT_MAINT_DTL_ACTION",action);
			action.getPM_AGENT_CONTRACT_MAINT_DTL_BEAN().setROWID(rowId);
			fetchClassDetails();
			outcome = executeSelectStatement(action);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return outcome; 
	}
	
	

	public String insertButtonAction(){
		PM_AGENT_CONTRACT_MAINT_DTL_ACTION action = new PM_AGENT_CONTRACT_MAINT_DTL_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM0100_A_PM_AGENT_CONTRACT_MAINT_DTL_ACTION",action);
		outcome = clearSession();
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
	public String executeSelectStatement(PM_AGENT_CONTRACT_MAINT_DTL_ACTION detailsActionBean) throws Exception{
		String selectQuery = "Select ROWID, PM_AGENT_CONTRACT_MAINT_DTL.* from PM_AGENT_CONTRACT_MAINT_DTL WHERE ROWID=?";
		String descQuery = "SELECT PC_CODE, DECODE('N','N',PC_DESC ,'L',NVL(PC_LONG_DESC,PC_DESC),PC_DESC) AS LONGDESC FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE=?";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		List list = null;
		String outcome = "AgentMaster";

		try {
			con = getConnection();
			list = handler.fetch(selectQuery,
					"com.iii.pel.forms.PM0100_A.PM_AGENT_CONTRACT_MAINT_DTL", 
					con, 
					new Object[]{detailsActionBean.getPM_AGENT_CONTRACT_MAINT_DTL_BEAN().getROWID()});
			PM_AGENT_CONTRACT_MAINT_DTL dtl = (PM_AGENT_CONTRACT_MAINT_DTL) list.get(0);
			
			resultSet = handler.executeSelectStatement(descQuery, con, new Object[]{dtl.getACMD_RANK_CODE()});
			if(resultSet.next()) {
				dtl.setUI_M_ACMD_RANK_CODE_DESC(resultSet.getString(2));
			}
			
			detailsActionBean.setPM_AGENT_CONTRACT_MAINT_DTL_BEAN(dtl);
			detailsActionBean.setUpdate(true);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return outcome;
	}


	
}

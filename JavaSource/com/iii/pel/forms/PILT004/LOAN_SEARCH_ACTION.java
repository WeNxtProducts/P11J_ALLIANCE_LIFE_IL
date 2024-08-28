package com.iii.pel.forms.PILT004;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class LOAN_SEARCH_ACTION extends CommonAction{

	private HtmlInputText LOAN_POL_NO;
	private HtmlInputText LOAN_REF_NO;
	private HtmlInputText UI_M_APPRV_STATUS;
	
	private UIDataTable searchTable;
	
	private LoanSearchBean searchBean;
	private ArrayList<LoanSearchBean> searchList = new ArrayList<LoanSearchBean>();
	
	public LOAN_SEARCH_ACTION(){
		searchBean = new LoanSearchBean();
	}
	
	public HtmlInputText getLOAN_POL_NO() {
		return LOAN_POL_NO;
	}
	public void setLOAN_POL_NO(HtmlInputText loan_pol_no) {
		LOAN_POL_NO = loan_pol_no;
	}
	public HtmlInputText getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}
	public void setLOAN_REF_NO(HtmlInputText loan_ref_no) {
		LOAN_REF_NO = loan_ref_no;
	}
	public UIDataTable getSearchTable() {
		return searchTable;
	}
	public void setSearchTable(UIDataTable searchTable) {
		this.searchTable = searchTable;
	}
	public LoanSearchBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(LoanSearchBean searchBean) {
		this.searchBean = searchBean;
	}
	public ArrayList<LoanSearchBean> getSearchList() {
		return searchList;
	}
	public void setSearchList(ArrayList<LoanSearchBean> searchList) {
		this.searchList = searchList;
	}
	
	public void searchedData(ActionEvent event){
		try {
			getSearchList().clear();
			String query = "SELECT ROWID, LOAN_POL_NO, LOAN_REF_NO, LOAN_STATUS FROM PT_IL_LOAN " +
			"WHERE LOAN_POL_NO LIKE '"+ getSearchBean().getLOAN_POL_NO()+
			"%' AND LOAN_REF_NO LIKE '"+searchBean.getLOAN_REF_NO()+"%'";

			System.out.println("The Query is............................" + query);
			CRUDHandler handler = new CRUDHandler();
			ResultSet rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while(rs.next()){
				LoanSearchBean bean = new LoanSearchBean();
				bean.setRowId(rs.getString("ROWID"));
				bean.setLOAN_POL_NO(rs.getString("LOAN_POL_NO"));
				bean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				if(rs.getString("LOAN_STATUS")!=null){
					if(rs.getString(4).equals("A") && rs.getString(4)!=null ){
						bean.setLOAN_STATUS("Apporved");
					}
					else if(rs.getString(4).equals("C") && rs.getString(4)!=null ){
						bean.setLOAN_STATUS("Closed");
					}
					else if(rs.getString(4).equals("P") && rs.getString(4)!=null ){
						bean.setLOAN_STATUS("Paid-Up");
					}
					else{
						bean.setLOAN_STATUS("Not Approved");
					}
				}else if(rs.getString("LOAN_STATUS")==null){
					System.out.println("The Loan Status is null");
					bean.setLOAN_STATUS("");
				}
				getSearchList().add(bean);
			}
			CommonUtils.closeCursor(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String executeQuery(){
		CommonUtils.setGlobalVariable("PILT004_MODE","update");
		try{
			FacesContext ctx = FacesContext.getCurrentInstance();
			Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String LOAN_POL_NO = null;
			String query1 = "SELECT ROWID,PT_IL_LOAN.* FROM PT_IL_LOAN " +
			"WHERE ROWID = '"+req.getParameter("rowID")+"'";
			
			
			PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION) sessionMap.get("PILT004_PT_IL_LOAN_ACTION");
			if(actionBean == null) {
				actionBean = new PT_IL_LOAN_ACTION();
			}
			CRUDHandler handler = new CRUDHandler();
//			PRE-QUERY FOR PT_IL_LOAN
			preQuery_Pt_Il_Loan(actionBean);

			List<PT_IL_LOAN> beanList = handler.fetch(query1,"com.iii.pel.forms.PILT004.PT_IL_LOAN",CommonUtils.getConnection());
			PT_IL_LOAN bean = beanList.get(0);
			System.out.println("ROW ID **********"+bean.getROWID());

			/*				//For Getting Loan Desc//              Amit Gupta
				String loanCode = bean.getLOAN_CODE();
				String loanDesc = getLoanDesc(loanCode);
				bean.setUI_M_LOAN_CODE_DESC(loanDesc);
				//
			 */				
			actionBean.setPT_IL_LOAN_BEAN(beanList.get(0));

//			POST-QUERY for PT_IL_LOAN
			actionBean.postQueryPtIlLoan();
			String LOAN_STATUS = actionBean.getPT_IL_LOAN_BEAN().getLOAN_STATUS();
			if("A".equals(LOAN_STATUS) || "C".equals(LOAN_STATUS)){
				actionBean.setLOANSTATUS(true);
			}else{
				actionBean.setLOANSTATUS(false);
			}
				//LOAN_STATUS
			sessionMap.put("PILT004_PT_IL_LOAN_ACTION", actionBean);
			
			String queryPtIlLoanChargeAction = "SELECT ROWID,PT_IL_LOAN_CHARGE.* from PT_IL_LOAN_CHARGE " +
					                           "where LC_LOAN_SYS_ID="+bean.getLOAN_SYS_ID();
			PT_IL_LOAN_CHARGE_ACTION actionBean1 = new PT_IL_LOAN_CHARGE_ACTION();
			List<PT_IL_LOAN_CHARGE> list1 = handler.fetch(queryPtIlLoanChargeAction, "com.iii.pel.forms.PILT004.PT_IL_LOAN_CHARGE", CommonUtils.getConnection());
			/** [ BugId:PREMIAGDC-0157 Mallika 17-Mar-09  Removed MT row */
			if(list1.size() > 0){
				actionBean1.setPT_IL_LOAN_CHARGE_BEAN(list1.get(0));
				actionBean1.setChargeDetailList(list1);
			}
			/**  BugId:PREMIAGDC-0155 Mallika 17-Mar-09 ]*/
			sessionMap.put("PILT004_PT_IL_LOAN_CHARGE_ACTION", actionBean1);
			 //CommonUtils.setGlobalObject("PILT004_PT_IL_LOAN_ACTION",actionBean);
			 System.out.println("INsearchpage------------------>" + actionBean);
			 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		CommonUtils.setGlobalVariable("GLOBAL.PILT004_MODE", "query_update");
		return "fetchMasterRecord";
	}
	
	public void preQuery_Pt_Il_Loan(PT_IL_LOAN_ACTION actionBean){
		if(CommonUtils.getGlobalObject("GLOBAL.M_LOAN_SYS_ID") != null){
			actionBean.getPT_IL_LOAN_BEAN().setLOAN_SYS_ID(Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.M_LOAN_SYS_ID").toString()));
			CommonUtils.setGlobalObject("GLOBAL.M_LOAN_SYS_ID",null);
		}
	}
	
	private String getLoanDesc(String loanCode) {
		String loanDesc = "";
		try {
			Connection conn= CommonUtils.getConnection();
			System.out.println("loanCode=" + loanCode);
			
			
			ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN","IL_LOAN_CODE");
	        pList1.add(p1);
	        OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN OUT",loanCode);
			pList1.add(p2);
			OracleParameter p3 = new OracleParameter("IN3", "STRING", "IN OUT","");
	        pList1.add(p3);
	        OracleParameter p4 = new OracleParameter("IN4", "STRING", "IN","N");
			pList1.add(p4);
			OracleParameter p5 = new OracleParameter("IN5", "STRING", "IN","E");
			pList1.add(p5);
			OracleParameter p6 = new OracleParameter("IN6", "STRING", "IN","");
			pList1.add(p6);
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
		    oList1 = pHandler1.execute(pList1, conn,"P_VAL_CODES");
			for (Iterator iterator2 = oList1.iterator(); iterator2.hasNext();) {
					OracleParameter name = (OracleParameter) iterator2.next();
					if(name.getFieldName().equals("IN3") && name.getValue()!=null){
						loanDesc = name.getValue();
						//PT_IL_LOAN_BEAN.setUI_M_LOAN_CODE_DESC(name.getValue());
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loanDesc;
	}

	public String insertNavigation(){
		System.out.println("LOAN_SEARCH_ACTION.insertNavigation()");
		CommonUtils.setGlobalVariable("PILT004_MODE","insert");
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		/*PT_IL_LOAN_ACTION actionBean = new PT_IL_LOAN_ACTION();
		PT_IL_LOAN bean = actionBean.getPT_IL_LOAN_BEAN();
		sessionMap.put("PILT004_PT_IL_LOAN_ACTION", actionBean);*/
		CommonUtils.setGlobalVariable("GLOBAL.PILT004_MODE", "insert");
		return "insert";
	}

	public HtmlInputText getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(HtmlInputText ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}
}

package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class LoanRepaymentSearchPageAction extends CommonAction{
	private HtmlInputText LOAN_REF_NO;
	private HtmlInputText UI_M_ASSURED_NAME;
	private HtmlCalendar LOAN_DT;
	ArrayList<LoanRepaymentSearchPageBean> searchList = new ArrayList<LoanRepaymentSearchPageBean>();
	private LoanRepaymentSearchPageBean searchBean;
	private UIDataTable searchDataTable;
	
	public UIDataTable getSearchDataTable() {
		return searchDataTable;
	}
	public void setSearchDataTable(UIDataTable searchDataTable) {
		this.searchDataTable = searchDataTable;
	}
	public LoanRepaymentSearchPageAction() {
		searchBean = new LoanRepaymentSearchPageBean();
	}
	public HtmlInputText getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}
	public void setLOAN_REF_NO(HtmlInputText loan_ref_no) {
		LOAN_REF_NO = loan_ref_no;
	}
	public HtmlInputText getUI_M_ASSURED_NAME() {
		return UI_M_ASSURED_NAME;
	}
	public void setUI_M_ASSURED_NAME(HtmlInputText ui_m_assured_name) {
		UI_M_ASSURED_NAME = ui_m_assured_name;
	}
	public HtmlCalendar getLOAN_DT() {
		return LOAN_DT;
	}
	public void setLOAN_DT(HtmlCalendar loan_dt) {
		LOAN_DT = loan_dt;
	}
	public LoanRepaymentSearchPageBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(LoanRepaymentSearchPageBean searchBean) {
		this.searchBean = searchBean;
	}
	public ArrayList<LoanRepaymentSearchPageBean> getSearchList() {
		LoanRepaymentSearchPageBean bean = new LoanRepaymentSearchPageBean();
		searchList.add(bean);
		return searchList;
	}
	public void setSearchList(ArrayList<LoanRepaymentSearchPageBean> searchList) {
		this.searchList = searchList;
	}

	public String executeQuery(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String ROWID = null;
		String outCome = null;
			
		ROWID = req.getParameter("rowID");
		if(ROWID== null){
			ROWID = CommonUtils.getGlobalVariable("rowID");
			System.out.println("ROW_ID from SESSION:::"+ROWID);
		}
		
		System.out.println("Parameter ROWID = "+ROWID);
		CommonUtils.setGlobalVariable("GLOBAL.M_CALLING_FORM", "PILT005");
		outCome = executeQuery(ROWID);
		return outCome;
	}

	public void fetchData(ActionEvent ae){
		/** PREMIA-GDC-1139821 (patch-1) - Clearing the ArrayList of previous entries before querying */
		searchList.clear();
		/** PREMIA-GDC-1139821 (patch-1)- Fixed */
		try {
			
			/** PREMIA-GDC-1139821 (patch-2) - Refined Query as per Requirements */
			String loanRefNo = searchBean.getLOAN_REF_NO();
			Date loanDate = searchBean.getLOAN_DT();
			DateFormat df = new SimpleDateFormat("dd-MMM-yy");
			String newLoanDate ="";
			if(loanDate!=null){
				newLoanDate = df.format(loanDate);
			}
			/*String query = "SELECT ROWID,LOAN_DT,LOAN_REF_NO FROM PT_IL_LOAN WHERE LOAN_REF_NO LIKE '"+loanRefNo+"%' AND LOAN_DT LIKE '"+newLoanDate.toUpperCase()+"%' " +
			"		AND LOAN_STATUS='A'";*/
//			System.out.println("Query = "+query);
			/** PREMIA-GDC-1139821 (patch-2) - Fixed */
			String Query = "SELECT ROWID,LOAN_DT,LOAN_REF_NO FROM PT_IL_LOAN WHERE NVL(LOAN_STATUS,'N') IN ('A', 'C') AND LOAN_REF_NO LIKE '"+loanRefNo+"%' AND LOAN_DT LIKE '"+newLoanDate.toUpperCase()+"%' ";
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			ResultSet rs = handler.executeSelectStatement(Query, con);
			while(rs.next()){
				LoanRepaymentSearchPageBean bean = new LoanRepaymentSearchPageBean();
				bean.setLOAN_DT(rs.getDate("LOAN_DT"));
				bean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				bean.setRowId(rs.getString("ROWID"));
				searchList.add(bean);
			}
			
			if(searchList.size()== 0){
				getWarningMap().put("current", "There is no record for this search criteria");
			}else{
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	Integer NVLInteger(Integer first, Integer second){
		if(first==null){
			first=second;
		}
		return first;
	}

	Double NVLDouble(Double first, Double second){
		if(first==null){
			first=second;
		}
		return first;
	}
	
	String NVLString(String first, String second){
		if((first==null) || first.equals("")){
			first=second;
		}
		return first;
	}
	
	public String executeQuery(String rowId){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		Date LOAN_DT = null;
		String M_CUST_CURR_CODE=null;
		String M_CURR_RATE_BS=null;
		Double LOAN_EXCH_RATE = 0.0;
		String M_POL_DS_CODE = null; 
		
		CommonUtils.setGlobalObject("PILT005_LOAN_REPAYMENT_SEARCH", this);
		CommonUtils.setGlobalVariable("rowID", rowId);
		System.out.println("ROW_ID setting in SESSION:::"+rowId);
//		String query = "SELECT ROWID,PM_BANK_CHARGE_SETUP_HDR.* FROM PM_BANK_CHARGE_SETUP_HDR WHERE ROWID = '"+req.getParameter("rowID")+"'";
		try {
			CRUDHandler handler = null;
			handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			PT_IL_LOAN_ACTION pt_il_loan_action = new PT_IL_LOAN_ACTION();
			PT_IL_LOAN loanbean = pt_il_loan_action.getPT_IL_LOAN_BEAN();
			/*String query = "SELECT ROWID,PT_IL_LOAN.* FROM PT_IL_LOAN WHERE ROWID = '"+req.getParameter("rowID")+"'";
			List<LoanRepaymentSearchPageBean> rs = handler.fetch(query, "com.iii.pel.forms.PILT005.LoanRepaymentSearchPageBean", con);
			LoanRepaymentSearchPageBean beanValue = rs.get(0);
			setSearchBean(beanValue);*/
			
			String LOAN_REF_NO = "";
			System.out.println("Parameter ROWID = "+rowId);
			//String query = "SELECT LOAN_REF_NO FROM PT_IL_LOAN WHERE ROWID = '"+req.getParameter("rowID")+"'";
			String query = "SELECT * FROM PT_IL_LOAN WHERE NVL(LOAN_STATUS,'N') IN ('A', 'C') AND ROWID = ?";
			Object[] values = {rowId};
			ResultSet rs = handler.executeSelectStatement(query, con, values);
			while(rs.next()){
				loanbean.setLOAN_SYS_ID(rs.getDouble("LOAN_SYS_ID"));
				//loanbean.setLOAN_POL_SYS_ID(rs.getString("LOAN_POL_SYS_ID"));
				loanbean.setLOAN_DT(rs.getDate("LOAN_DT"));
				LOAN_EXCH_RATE = rs.getDouble("LOAN_EXCH_RATE");
				loanbean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				loanbean.setLOAN_LC_AMOUNT(rs.getDouble("LOAN_LC_AMOUNT"));
				loanbean.setLOAN_FC_AMOUNT(rs.getDouble("LOAN_FC_AMOUNT"));
				loanbean.setLOAN_LC_REPAID_AMT(rs.getDouble("LOAN_LC_REPAID_AMT"));
				loanbean.setLOAN_FC_REPAID_AMT(rs.getDouble("LOAN_FC_REPAID_AMT"));
				loanbean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
			}
			System.out.println("LOAN_REF_NO = "+loanbean.getLOAN_REF_NO());
			
			
			
			sessionMap.put("LOAN_REF_NO", loanbean.getLOAN_REF_NO());
			sessionMap.put("LOAN_DT", loanbean.getLOAN_DT());
			CommonUtils.setGlobalVariable("LOAN_DT", loanbean.getLOAN_DT()+"");
			CommonUtils.setGlobalVariable("LOAN_REF_NO_REQUERY", loanbean.getLOAN_REF_NO());
			//CommonUtils.setGlobalVariable("LOAN_POL_SYS_ID", loanbean.getLOAN_POL_SYS_ID());
			CommonUtils.setGlobalVariable("LOAN_EXCH_RATE", (LOAN_EXCH_RATE+""));
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String dat="";
			if(loanbean.getLOAN_DT() != null){
				 dat = df.format(loanbean.getLOAN_DT());
			}
			sessionMap.put("LOAN_DT", dat);
			if(loanbean.getLOAN_POL_SYS_ID()!= null){
				String Query = "SELECT POL_ASSURED_NAME,POL_CUST_CURR_CODE,POL_DS_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
				Object[] values2 = {loanbean.getLOAN_POL_SYS_ID()};
				ResultSet rs2 = handler.executeSelectStatement(Query, con, values2);
				if(rs2.next()){
					loanbean.setUI_M_ASSURED_NAME(rs2.getString("POL_ASSURED_NAME"));
					M_CUST_CURR_CODE = rs2.getString("POL_CUST_CURR_CODE");
					M_POL_DS_CODE = rs2.getString("POL_DS_CODE");
					//sessionMap.put("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
					CommonUtils.setGlobalVariable("M_CUST_CURR_CODE", M_CUST_CURR_CODE);
				}
				
				if(M_POL_DS_CODE!= null){
					String Query3 = "SELECT DS_CURR_RATE_BS  FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '2' AND DS_CODE = ?";
					Object[] values3 = {M_POL_DS_CODE};
					ResultSet rs3 = handler.executeSelectStatement(Query3, con, values3);
					if(rs3.next()){
						M_CURR_RATE_BS = rs3.getString("DS_CURR_RATE_BS");
						sessionMap.put("M_CURR_RATE_BS", M_CURR_RATE_BS);
					}
				}
			}
			Date LR_PYMT_DT = null; 
			Double LR_FC_PYMT_AMT = 0.0;
			Double LR_LC_PYMT_AMT = 0.0;
			Double LR_FC_INT_AMT = 0.0;
			Double LR_LC_INT_AMT = 0.0;
			Double LR_FC_LOAN_AMT = 0.0;
			Double LR_LC_LOAN_AMT = 0.0;
			String LR_PYMT_REF_NO = null; 
			String LR_SYS_ID = null;
			String LR_STATUS = null;
			/*Newly Added by Dhinesh on 10.3.2017 */
			
			Date    LR_CR_DT = null;
			String LR_FLAG = null;
			String LR_CR_UID = null;
		
			/*End*/
			
			String query3 = "select A.LR_PYMT_DT,A.LR_FC_PYMT_AMT,A.LR_LC_PYMT_AMT,"+
			"A.LR_FC_INT_AMT,A.LR_LC_INT_AMT,A.LR_FC_LOAN_AMT,"+
			"A.LR_LC_LOAN_AMT,A.LR_PYMT_REF_NO,A.ROWID,A.LR_LOAN_SYS_ID,A.LR_SYS_ID,A.LR_STATUS "+ 
			"FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = ?";
			Object[] values_ref_no = {loanbean.getLOAN_REF_NO()};
			ResultSet rs123 = handler.executeSelectStatement(query3, con,values_ref_no);
			
			PT_IL_LOAN_REPAYMENT_ACTION repayBeanAction = new PT_IL_LOAN_REPAYMENT_ACTION();
			List<PT_IL_LOAN_REPAYMENT> testList = repayBeanAction.getGridDisplay();
			testList.clear();
			while(rs123.next()){
				PT_IL_LOAN_REPAYMENT repayBean = new PT_IL_LOAN_REPAYMENT();
				LR_PYMT_DT = rs123.getDate(1);
				LR_FC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(2)), 0.0);
				LR_LC_PYMT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(3)), 0.0);
				LR_FC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(4)), 0.0);
				LR_LC_INT_AMT = NVLDouble(Double.valueOf(rs123.getDouble(5)), 0.0);
				LR_FC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(6)), 0.0);
				LR_LC_LOAN_AMT = NVLDouble(Double.valueOf(rs123.getDouble(7)), 0.0);
				LR_PYMT_REF_NO = rs123.getString(8);
				LR_SYS_ID = rs123.getString(11);
				LR_STATUS = rs123.getString(12);
				
				/*Newly Added by Dhinesh on 10.3.2017 */
				LR_FLAG   = rs123.getString(13);
				LR_CR_DT  = rs123.getTimestamp(14);
				LR_CR_UID = rs123.getString(15);
				/*End*/

				repayBean.setLR_PYMT_DT(LR_PYMT_DT);
				repayBean.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);
				repayBean.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
				repayBean.setLR_FC_INT_AMT(LR_FC_INT_AMT);
				repayBean.setLR_LC_INT_AMT(LR_LC_INT_AMT);
				repayBean.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);
				repayBean.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
				repayBean.setLR_PYMT_REF_NO(LR_PYMT_REF_NO);
				repayBean.setROWID(rs123.getString(9));
				repayBean.setLR_LOAN_SYS_ID(rs123.getDouble(10));
				repayBean.setLR_SYS_ID(rs123.getLong(11));
				repayBean.setLR_STATUS(LR_STATUS);
				
				/*Newly Added by Dhinesh on 10.3.2017 */
				repayBean.setLR_FLAG(LR_FLAG);
				repayBean.setLR_CR_DT(LR_CR_DT);
				repayBean.setLR_CR_UID(LR_CR_UID);
				/*End*/
				
				testList.add(repayBean);
							
			}
						
			repayBeanAction.setBeanList(testList);
			System.out.println("---------------------->Repay list size: "+testList.size());
			//sessionMap.put("PILT005_PT_IL_LOAN_REPAYMENT_ACTION", repayBeanAction);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION", repayBeanAction);
			

			Double M_FC_OS_AMOUNT = 0.0;
			M_FC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_FC_AMOUNT(), 0.0)-NVLDouble(loanbean.getLOAN_FC_REPAID_AMT(), 0.0));
			sessionMap.put("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT);
			//CommonUtils.setGlobalVariable("M_FC_OS_AMOUNT", M_FC_OS_AMOUNT+"");
			
			Double M_LC_OS_AMOUNT = 0.0;
			M_LC_OS_AMOUNT = (NVLDouble(loanbean.getLOAN_LC_AMOUNT(), 0.0)-NVLDouble(loanbean.getLOAN_LC_REPAID_AMT(), 0.0));
			sessionMap.put("M_LC_OS_AMOUNT", M_LC_OS_AMOUNT);
			
			loanbean.setUI_M_FC_OS_AMOUNT(M_FC_OS_AMOUNT);
			loanbean.setUI_M_LC_OS_AMOUNT(M_LC_OS_AMOUNT);
			sessionMap.put("PILT005_PT_IL_LOAN_ACTION", pt_il_loan_action);
			CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_ACTION", pt_il_loan_action);
			
			//Logic For Default Population
			PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = null;
			Iterator<PT_IL_LOAN_REPAYMENT> it = testList.iterator();
			
			while(it.hasNext()){
				PT_IL_LOAN_REPAYMENT_BEAN = it.next();
				PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(false);
			}
			//actionBean.setDataTableList(outputList);
			if (testList.size()>0){					
				repayBeanAction.setPT_IL_LOAN_REPAYMENT_BEAN(testList.get(0));
				repayBeanAction.getPT_IL_LOAN_REPAYMENT_BEAN().setRowSelected(true);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
		return "loanPage";
	}
	public String insertButtonAction(){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILT005_PT_IL_LOAN_ACTION")!=null)
		{
			session.removeAttribute("PILT005_PT_IL_LOAN_ACTION");
		}
		return "loanPage";
	}
}

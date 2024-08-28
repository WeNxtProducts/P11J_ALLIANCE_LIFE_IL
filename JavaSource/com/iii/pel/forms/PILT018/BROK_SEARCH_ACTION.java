package com.iii.pel.forms.PILT018;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class BROK_SEARCH_ACTION {

	private HtmlInputText LOAN_POL_NO;
	private HtmlInputText LOAN_REF_NO;
	
	private UIDataTable searchTable;
	
	private BrokSearchBean searchBean;
	private ArrayList<BrokSearchBean> searchList = new ArrayList<BrokSearchBean>();
	
	public BROK_SEARCH_ACTION(){
		searchBean = new BrokSearchBean();
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
	public BrokSearchBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(BrokSearchBean searchBean) {
		this.searchBean = searchBean;
	}
	public ArrayList<BrokSearchBean> getSearchList() {
		return searchList;
	}
	public void setSearchList(ArrayList<BrokSearchBean> searchList) {
		this.searchList = searchList;
	}
	
	public void searchedData(ActionEvent event){
		try {
			searchList.clear();
		String query=" SELECT ROWID,BAH_CUST_CODE, BAH_REF_NO from  PT_IL_BROK_ADV_HDR where BAH_CUST_CODE like '%"+ searchBean.getLOAN_POL_NO()+"%' AND BAH_REF_NO LIKE '%"+searchBean.getLOAN_REF_NO()+"%'";
			//String query = "SELECT ROWID,LOAN_POL_NO, LOAN_REF_NO from  PT_IL_LOAN where LOAN_POL_NO like '%"+ searchBean.getLOAN_POL_NO()+"%' AND LOAN_REF_NO LIKE '%"+searchBean.getLOAN_REF_NO()+"%'";
			
			CRUDHandler handler = new CRUDHandler();
			ResultSet rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while(rs.next()){
				BrokSearchBean bean = new BrokSearchBean();
				bean.setRowId(rs.getString(1));
				bean.setLOAN_POL_NO(rs.getString(2));
				bean.setLOAN_REF_NO(rs.getString(3));
				
				searchList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String executeQuery() throws Exception{
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String LOAN_POL_NO = null;
		
		
		System.out.println("Parameter ROWID = "+req.getParameter("rowID"));
		
		String query1 = "SELECT * FROM PT_IL_BROK_ADV_HDR WHERE ROWID = '"+req.getParameter("rowID")+"'";
		System.out.println("Actual Query = "+query1);
		
		PreparedStatement psmt = CommonUtils.getConnection().prepareStatement(query1);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			LOAN_POL_NO = rs.getString("BAH_CUST_CODE");
			System.out.println("LOAN_POL_NO===============" + LOAN_POL_NO);
			
		}
		
		rs.close();
		String query2 = "SELECT * FROM PT_IL_BROK_ADV_HDR WHERE BAH_CUST_CODE ='"+ LOAN_POL_NO + "'";
		System.out.println("query2------" + query2);
		PreparedStatement psmt1 = CommonUtils.getConnection().prepareStatement(query2);
		//psmt1.setString(1, LOAN_POL_NO);
		ResultSet rs1 = psmt1.executeQuery(query2);
		
		PT_IL_BROK_ADV_HDR_ACTION actionBean = new PT_IL_BROK_ADV_HDR_ACTION();
		PT_IL_BROK_ADV_HDR bean = actionBean.getPT_IL_BROK_ADV_HDR_BEAN();
		
		//bean.setLOAN_CODE(rs.getString("LOAN_CODE"));
		//bean.setLOAN_DT(rs.getDate("LOAN_DT"));
		
		
		
		while(rs1.next()){
			bean.setBAH_CUST_CODE(rs1.getString("BAH_CUST_CODE"));
			
			bean.setBAH_SYS_ID(rs1.getLong("BAH_SYS_ID"));
			bean.setBAH_REF_NO(rs1.getString("BAH_REF_NO"));
			bean.setBAH_PYMT_TYPE(rs1.getString("BAH_PYMT_TYPE"));
			bean.setBAH_PYMT_DT(rs1.getDate("BAH_PYMT_DT"));
			bean.setBAH_CURR_CODE(rs1.getString("BAH_CURR_CODE"));
		    bean.setBAH_CURR_RATE_TYPE(rs1.getString("BAH_CURR_RATE_TYPE"));
			bean.setBAH_EXCH_RATE(rs1.getDouble("BAH_EXCH_RATE"));
			bean.setBAH_FC_AMT(rs1.getDouble("BAH_FC_AMT"));
			bean.setBAH_LC_AMT(rs1.getDouble("BAH_LC_AMT"));
			bean.setBAH_REPAY_TYPE(rs1.getString("BAH_REPAY_TYPE"));
			bean.setBAH_STATUS(rs1.getString("BAH_STATUS"));
		    bean.setBAH_CR_DT(rs1.getDate("BAH_CR_DT"));
			bean.setBAH_CR_UID(rs1.getString("BAH_CR_UID"));
			bean.setBAH_NO_OF_INST(rs1.getInt("BAH_NO_OF_INST"));
			bean.setBAH_PAYMENT_YN(rs1.getString("BAH_PAYMENT_YN"));
			bean.setBAH_CONFIRM_FLAG(rs1.getString("BAH_CONFIRM_FLAG"));
			bean.setBAH_REPAYMENT_YN(rs1.getString("BAH_REPAYMENT_YN"));
			bean.setBAH_PAY_PRIORITY(rs1.getDouble("BAH_PAY_PRIORITY"));
			bean.setBAH_INST_FM_DT(rs1.getDate("BAH_INST_FM_DT"));
			bean.setBAH_REMARKS(rs1.getString("BAH_REMARKS"));
			bean.setBAH_TXN_CODE(rs1.getString("BAH_TXN_CODE"));
			bean.setBAH_DOC_NO(rs1.getDouble("BAH_DOC_NO"));
			bean.setBAH_DOC_DT(rs1.getDate("BAH_DOC_DT"));
			}
		
		sessionMap.put("PILT018_PT_IL_BROK_ADV_HDR_ACTION", actionBean);
		return "fetchMasterRecord1";
	}
	
	
	public String insertNavigation(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		PT_IL_BROK_ADV_HDR_ACTION actionBean = new PT_IL_BROK_ADV_HDR_ACTION();
		PT_IL_BROK_ADV_HDR bean = actionBean.getPT_IL_BROK_ADV_HDR_BEAN();
		sessionMap.put("PILT018_PT_IL_BROK_ADV_HDR_ACTION", actionBean);
		return "insert1";
	}
}

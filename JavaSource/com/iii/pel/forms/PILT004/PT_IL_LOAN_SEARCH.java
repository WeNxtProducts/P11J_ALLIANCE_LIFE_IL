package com.iii.pel.forms.PILT004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.component.UIData;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_SEARCH {

	private PT_IL_LOAN searchBean;
	private List<PT_IL_LOAN> dataTableBean;
	private UIData dataTable;

	public PT_IL_LOAN_SEARCH(){
		searchBean = new PT_IL_LOAN();
	}
	

	public List<PT_IL_LOAN> getDataTableBean() {
		return dataTableBean;
	}


	public void setDataTableBean(List<PT_IL_LOAN> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}
	

	public String fetchMasterRecord(){
			return "fetchMasterRecord";
	}
	
	public String getCodeDesc(PT_IL_LOAN_ACTION actionBean,PT_IL_LOAN valueBean,String code){
		ResultSet rs =null;
		String condition=code;
		String query =null;
		String desc =null;
		try{
			query = "SELECT * FROM PT_IL_LOAN"; 
			Connection con = CommonUtils.getConnection();
			rs = getHandler().executeSelectStatement(query, con);
			if(rs.next()){
				//desc = rs.getString("NGS_DESC");
			}
			rs.close();	
		}catch(Exception er){
			er.printStackTrace();
		}
		return desc;
	}
	
	public String fetch(){
		PT_IL_LOAN_DELEGATE delegate = new PT_IL_LOAN_DELEGATE();
		this.dataTableBean = delegate.fetchMasterBlock(this);
		return null;
	}
	public String insert(){
		return "insert";
	}
	
	public PT_IL_LOAN getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PT_IL_LOAN searchBean) {
		this.searchBean = searchBean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	/*public Connection getConnection() {
		Connection con = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		ServletContext sctx = (ServletContext) ctx.getExternalContext().getContext();
		SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) sctx.getAttribute("connectionAgent");
		try {
			con = connectionAgent.getConnection("123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}*/
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
}

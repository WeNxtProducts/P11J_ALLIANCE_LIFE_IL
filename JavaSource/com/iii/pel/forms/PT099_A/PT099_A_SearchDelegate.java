package com.iii.pel.forms.PT099_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT099_A_SearchDelegate {
	public ArrayList<PT_AGENT_TRAN_HDR> fetchMasterBlock(PT_AGENT_TRAN_HDR_SearchAction searchAction) throws SQLException, DBException {
		ArrayList<PT_AGENT_TRAN_HDR> masterList = new ArrayList<PT_AGENT_TRAN_HDR>();
		String uiPolNo = searchAction.getUI_M_ATH_POL_NO();
		PT_AGENT_TRAN_HDR pt_agent_tran_hdr=null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		Connection connection = CommonUtils.getConnection();
		String query = null;
		Object[] values = null;
		
		

		// Modified query and code for getting search result, added by: Manoj Kumar Sahu, Date: 05-Feb-09
		if(uiPolNo==null || "".equals(uiPolNo.trim())){
			query = PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_SEARCH_QUERY_UNCONDITIONAL;
			values = new Object[]{};
		}else{
			query = PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_SEARCH_QUERY_CONDITIONAL;
			values = new Object[]{uiPolNo + "%"};
		}
		rs = handler.executeSelectStatement(query, connection, values);
		while(rs.next()){
			pt_agent_tran_hdr=new PT_AGENT_TRAN_HDR();
			pt_agent_tran_hdr.setUI_M_ATH_POL_NO(rs.getString("POL_NO"));
			pt_agent_tran_hdr.setROWID(rs.getString("ROWID"));
			pt_agent_tran_hdr.setATH_AGENT_CODE(rs.getString("ATH_AGENT_CODE"));
			pt_agent_tran_hdr.setATH_NEW_AGENT_CODE(rs.getString("ATH_NEW_AGENT_CODE"));
			masterList.add(pt_agent_tran_hdr);
		}			
		// Close cursor
		try{CommonUtils.closeCursor(rs);}catch(Exception exc){}
		
		return masterList;
	}

	
	public int deleteData(PT_AGENT_TRAN_HDR gridValueBean)
	{
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			con = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, con);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public Connection getConnection() {
		Connection con = null;

		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}
}

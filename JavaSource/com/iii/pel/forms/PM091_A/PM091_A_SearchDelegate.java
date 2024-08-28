package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM091_A_SearchDelegate {
	
	public ArrayList fetchMasterBlock(PM_AGENT_BENEFIT_HDR_SearchAction searchAction) {
		ArrayList<PM_AGENT_BENEFIT_HDR> masterList = new ArrayList<PM_AGENT_BENEFIT_HDR>();
		PM_AGENT_BENEFIT_HDR searchBean = searchAction.getSearchBean();
		String BenefitCode = searchBean.getABH_BNF_CODE();
		String query = null;
		ResultSet rs = null;
		if ((BenefitCode == null || BenefitCode.equals(""))) {
			query = "SELECT ROWID,ABH_BNF_CODE,ABH_DESC,ABH_BNF_TYPE FROM  PM_AGENT_BENEFIT_HDR";
		} else if ((BenefitCode != null || !BenefitCode.equals(""))) {
			query = "SELECT ROWID,ABH_BNF_CODE,ABH_DESC,ABH_BNF_TYPE FROM  PM_AGENT_BENEFIT_HDR where ABH_BNF_CODE like'"
					+BenefitCode+ "%'";
		}
		try {
			rs = getHandler().executeSelectStatement(query, getConnection());
			while (rs.next()) {
				PM_AGENT_BENEFIT_HDR searchBean1 = new PM_AGENT_BENEFIT_HDR();
				searchBean1.setABH_BNF_CODE(rs.getString("ABH_BNF_CODE"));
				searchBean1.setABH_DESC(rs.getString("ABH_DESC"));
				searchBean1.setABH_BNF_TYPE(rs.getString("ABH_BNF_TYPE"));
				searchBean1.setROWID(rs.getString("ROWID"));
				
				masterList.add(searchBean1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		finally{
			try{
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return masterList;
	}

	
	public int deleteData(PM_AGENT_BENEFIT_HDR gridValueBean)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}


}

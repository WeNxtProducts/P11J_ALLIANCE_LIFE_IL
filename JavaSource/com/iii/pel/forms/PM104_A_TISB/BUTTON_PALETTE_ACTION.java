package com.iii.pel.forms.PM104_A_TISB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class BUTTON_PALETTE_ACTION {

	private BUTTON_PALETTE BUTTON_PALETTE_BEAN;

	public BUTTON_PALETTE_ACTION() {
		BUTTON_PALETTE_BEAN = new BUTTON_PALETTE();
	}

	public BUTTON_PALETTE getBUTTON_PALETTE_BEAN() {
		return BUTTON_PALETTE_BEAN;
	}

	public void setBUTTON_PALETTE_BEAN(BUTTON_PALETTE BUTTON_PALETTE_BEAN) {
		this.BUTTON_PALETTE_BEAN = BUTTON_PALETTE_BEAN;
	}
	
	//Below FOund Statements are added Manually
	
	Connection conn = null;
	public void M_RUN_DATE()throws DBException{
		try{
			conn  = CommonUtils.getConnection();
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/YY') FROM PM_AGENT_WITH_DRAWL_SETUP";
			PreparedStatement datestmt = conn.prepareStatement(query);
			ResultSet rs = datestmt.executeQuery();
			Date date=null;
			while(rs.next()){
				try {
					System.out.println("DUMMY_ACTION.getSystemDate()-----------["+rs.getString(1)+"]");
					date=rs.getDate(1);
				}catch (Exception err) {
					err.printStackTrace();
				}
			}			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
	}
}

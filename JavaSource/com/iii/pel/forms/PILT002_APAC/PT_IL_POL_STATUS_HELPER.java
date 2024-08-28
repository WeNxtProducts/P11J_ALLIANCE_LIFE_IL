package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_POL_STATUS_HELPER {

CRUDHandler handler = new  CRUDHandler();

PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_STATUS_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_POL_STATUS> dataList = compositeAction.
	getPT_IL_POL_STATUS_ACTION_BEAN().getDataList_PT_IL_POL_STATUS();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = dataList.get(0);
		PT_IL_POL_STATUS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN()
		.setPT_IL_POL_STATUS_BEAN(PT_IL_POL_STATUS_BEAN);
	}
	}
	
	 public void whenNewBlockInstance(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		 PT_IL_POLICY pt_il_policy_bean = compositeAction
			.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			PT_IL_POL_STATUS pt_il_pol_status_bean = compositeAction
			.getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
			DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			Connection connection = null;
			ResultSet rs = null;
			Object[] values = {};
			ArrayList<String> pValList = new ArrayList<String>();
			String query1= " SELECT 'X' " +
				   " FROM   PT_IL_POL_STATUS " +
				   " WHERE  PS_POL_SYS_ID = ? " +
				   " AND    PS_STATUS_TYPE = 'S' ";
			String 	M_TEMP = null;  
			try {
			    connection = CommonUtils.getConnection();
			    values = new Object[]{pt_il_policy_bean.getPOL_SYS_ID()};
			    rs = handler.executeSelectStatement( query1, connection,values);
			    if(rs.next()){
			    	M_TEMP =rs.getString(1);
			    }
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			finally{
			    try {
				CommonUtils.closeCursor(rs);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}
		    }
	
	 public void postQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		 
		 PT_IL_POL_STATUS pt_il_pol_status_bean = compositeAction
		 .getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
		 DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		 Connection connection = null;
		 ResultSet rs = null;
		 Object[] values = {};
		 ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		 /*Modified by ganesh on 13-04-2017 to display status screen description suggested by Chandramohan*/
		 //String query1 ="  SELECT PS_CODE_DESC  FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_ADDL_STAT'  AND  PS_CODE = ? ";
		 String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE IN ('IL_ADDL_STAT', 'IL_REC_STA') AND PS_CODE = ? UNION select PC_DESC from PM_CODES where PC_TYPE = 'IL_REASON' AND PC_CODE = ?";
		 /*end*/
		 
		 try {
			 connection = CommonUtils.getConnection();
			 /*Modified by ganesh on 13-04-2017 to display status screen description suggested by Chandramohan
			  * 
			  * values = new Object[]{pt_il_pol_status_bean.getPS_STATUS()};*/
			 values = new Object[]{pt_il_pol_status_bean.getPS_STATUS(),pt_il_pol_status_bean.getPS_STATUS()};
			 /*End*/
			 if(pt_il_pol_status_bean.getPS_STATUS() != null){
				  rs = handler.executeSelectStatement( query1, connection,values);
				  if(rs.next()){
					  pt_il_pol_status_bean.setUI_M_STAT_DESC(rs.getString(1));
				  }
				
			 }
			 
		pValList = pkg_pilt002_apac.P_VAL_CODES(
				"IL_REASON",
				pt_il_pol_status_bean.getPS_REASON_CODE(),
				pt_il_pol_status_bean.getUI_M_PC_DESC(),
		            "N",
		            "N",
		            null);
		if (pValList != null && !pValList.isEmpty()) {
			if (pValList.get(0).getValue() != null ) {
				pt_il_pol_status_bean.setUI_M_PC_DESC(pValList.get(0).getValue());
			}
		}
				
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
		 }
		 finally{
			 try {
				 CommonUtils.closeCursor(rs);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	
	 

	    public void PS_STATUS_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,
		    String currValue) throws Exception{
	    	PT_IL_POLICY pt_il_policy_bean = compositeAction
			.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	    	PT_IL_POL_STATUS pt_il_pol_status_bean = compositeAction
			 .getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = "  SELECT PS_CODE_DESC " +
			    " FROM   PP_SYSTEM " +
			    " WHERE  PS_TYPE = 'IL_ADDL_STAT' " +
			    " AND    PS_CODE = ? " +
			    " AND    PS_VALUE = ? ";
		 
		try {
		    connection = CommonUtils.getConnection();
		    values = new Object[]{ pt_il_pol_status_bean.getPS_STATUS(), pt_il_policy_bean.getPOL_DS_TYPE()}	;
		    
			if(pt_il_pol_status_bean.getPS_STATUS() != null){
				  rs = handler.executeSelectStatement( query1, connection,values);
				if(rs.next()){
					pt_il_pol_status_bean.setUI_M_STAT_DESC(rs.getString(1));
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
		    try {
			CommonUtils.closeCursor(rs);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    }
	
	public boolean status_check(PILT002_APAC_COMPOSITE_ACTION compositeAction)        
			throws Exception {
		String query_stat = "SELECT PS_POL_SYS_ID FROM PT_IL_POL_STATUS WHERE PS_POL_SYS_ID =?";
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		boolean checkFlag = false;
		Double polSysId = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(query_stat, con,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			if (rs1.next()) {
				polSysId = rs1.getDouble(1);
			}
			if (polSysId != null) {
				checkFlag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}
		}
		return checkFlag;
	}
} 

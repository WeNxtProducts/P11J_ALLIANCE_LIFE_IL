package com.iii.pel.forms.PILP017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CHECK_OFF_TRANS_DTL_HELPER {
	
	public void executeQuery(PILP017_COMPOSITE_ACTION compositeAction)throws Exception{
		executeSelectStatement(compositeAction);

 	 List<PT_IL_CHECK_OFF_TRANS_DTL> dataList = compositeAction.
	getPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN().getDataList_PT_IL_CHECK_OFF_TRANS_DTL();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_CHECK_OFF_TRANS_DTL PT_IL_CHECK_OFF_TRANS_DTL_BEAN = dataList.get(0);
		PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN()
		.setPT_IL_CHECK_OFF_TRANS_DTL_BEAN(PT_IL_CHECK_OFF_TRANS_DTL_BEAN);
	}
	}
	
	
	 public void executeSelectStatement(
			 PILP017_COMPOSITE_ACTION compositeAction)
			    throws Exception {
			String selectStatement = " SELECT ROWID,COTD_FIELD2,COTD_POLICY_NO,COTD_DUE_DATE," +
					" COTD_PAID_DATE,COTD_PAID_FC_AMT,COTD_PAID_LC_AMT ," +
					" COTD_MSG_TYPE,COTD_ERROR_CODE FROM PT_IL_CHECK_OFF_TRANS_DTL  WHERE  COTD_ERROR_CODE <>1";
			
			
			Connection connection = null;
			ResultSet resultSet = null;
			//Long sysid = (Long)CommonUtils.getGlobalObject("M_COTH_SYS_ID");
			compositeAction.getPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN().getDataList_PT_IL_CHECK_OFF_TRANS_DTL().clear();
			try {
				connection = CommonUtils.getConnection();
			    resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection);
			    while (resultSet.next()) {
			    PT_IL_CHECK_OFF_TRANS_DTL PT_IL_CHECK_OFF_TRANS_DTL_BEAN = new PT_IL_CHECK_OFF_TRANS_DTL();
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_FIELD2(resultSet.getString("COTD_FIELD2"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_POLICY_NO(resultSet.getString("COTD_POLICY_NO"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_MSG_TYPE(resultSet.getString("COTD_MSG_TYPE"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_ERROR_CODE(resultSet.getInt("COTD_ERROR_CODE"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_DUE_DATE(resultSet.getDate("COTD_DUE_DATE"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_PAID_DATE(resultSet.getDate("COTD_PAID_DATE"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_PAID_FC_AMT(resultSet.getDouble("COTD_PAID_FC_AMT"));
				PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setCOTD_PAID_LC_AMT(resultSet.getDouble("COTD_PAID_LC_AMT"));

				postQuery(PT_IL_CHECK_OFF_TRANS_DTL_BEAN);
				compositeAction.getPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN().getDataList_PT_IL_CHECK_OFF_TRANS_DTL()
																.add(PT_IL_CHECK_OFF_TRANS_DTL_BEAN);
			    }
			} finally {
				try {
					CommonUtils.closeCursor(resultSet);
					CommonUtils.setGlobalObject("M_COTH_SYS_ID", null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		    }
	
	
	
	public void postQuery(PT_IL_CHECK_OFF_TRANS_DTL PT_IL_CHECK_OFF_TRANS_DTL_BEAN){
		
		String C1=" SELECT  PC_DESC FROM   PM_CODES WHERE  PC_TYPE = 'IL_MSG_TYPE' AND PC_VALUE LIKE ?";
		CRUDHandler handler=new CRUDHandler();
		Connection connection = null;
		ResultSet rs1=null;
		
		String M_err_desc=null;
		String M_IL_FUT_DUES = null;
		try {
			connection = CommonUtils.getConnection();
		  
			/*  Newly Added By Dhinesh on 21-06-2018 for error code not null Check */
			System.out.println("getCOTD_ERROR_CODE     "+PT_IL_CHECK_OFF_TRANS_DTL_BEAN.getCOTD_ERROR_CODE());
			
			if (null != PT_IL_CHECK_OFF_TRANS_DTL_BEAN.getCOTD_ERROR_CODE())
			{
				
			/*End*/	
			rs1 = handler.executeSelectStatement(C1, connection, new Object[]{PT_IL_CHECK_OFF_TRANS_DTL_BEAN.getCOTD_ERROR_CODE()});
		    if(rs1.next()){
		    	M_err_desc=rs1.getString(1);
		    }
		    M_IL_FUT_DUES = CommonUtils.getPPSystemParameterValue("IL_FUT_DUES").toString();
		    
		    M_err_desc = M_err_desc.replace("IL_MSG_TYPE", M_IL_FUT_DUES);
		    PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setUI_M_ERR_CODE_DESC(M_err_desc);
		    
			}
			
		    }catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	


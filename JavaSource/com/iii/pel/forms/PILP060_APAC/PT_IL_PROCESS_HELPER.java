package com.iii.pel.forms.PILP060_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PROCESS_HELPER {

	public List<PT_IL_PROCESS> getBlockData() throws Exception {
		
		String selectQuery=PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PT_IL_PROCESS;
		CRUDHandler handler =new CRUDHandler();
		
		ResultSet result=null;
		List <PT_IL_PROCESS> recordList=new ArrayList<PT_IL_PROCESS>();
		try {
			result=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection());
			if(result!= null){
				while(result.next()){
					PT_IL_PROCESS tempBean=new PT_IL_PROCESS();
					tempBean.setPR_ERROR_DESC(result.getString("PR_ERROR_DESC"));
					tempBean.setPR_CR_DT(result.getDate("PR_CR_DT"));
					tempBean.setPR_CR_UID(result.getString("PR_CR_UID"));
					tempBean.setPR_DATE(result.getDate("PR_DATE"));
					tempBean.setPR_POL_SYS_ID(result.getDouble("PR_POL_SYS_ID"));
					tempBean.setPR_PROCESS_TYPE(result.getString("PR_PROCESS_TYPE"));
					
					recordList.add(tempBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
		}
		return recordList;
	}

	public void postQuery(List<PT_IL_PROCESS> dataTableList) throws Exception {
		System.out.println("PT_IL_PROCESS_HELPER.postQuery()");
		
		StringBuffer selectQuery=new StringBuffer
		(PILP060_APAC_SQLQUERY_CONSTANTS.PT_IL_PROCESS_POST_QUERY_CURSOR_C1);
	
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		Connection con=null;
		Map<Double, String> polNoMap=new HashMap<Double, String>();
		try {
			con=CommonUtils.getConnection();
			result=handler.executeSelectStatement(selectQuery.toString(),con);
			if(result != null){
				while(result.next()){
					polNoMap.put(result.getDouble("POL_SYS_ID"), result.getString("POL_NO"));
				}
			}
			int iCount=0;
			while(iCount < dataTableList.size()){
			Double key=((PT_IL_PROCESS)dataTableList.get(iCount)).getPR_POL_SYS_ID();
			String polNo=polNoMap.get(key);
			((PT_IL_PROCESS)dataTableList.get(iCount)).setUI_M_POL_NO(polNo);
			iCount++;
		}
	
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}finally{
		try {
			CommonUtils.closeCursor(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}

	public void deleteRecords() throws Exception {
		System.out.println("PT_IL_PROCESS_HELPER.deleteRecords()");
		
		String deleteQuery=PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PT_IL_PROCESS;
		CRUDHandler handler =new CRUDHandler();
		
		try {
			handler.executeDeleteStatement(deleteQuery, CommonUtils.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e){ 
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}

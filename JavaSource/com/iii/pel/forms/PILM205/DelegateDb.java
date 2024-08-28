package com.iii.pel.forms.PILM205;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN_HELPER;
import com.iii.pel.forms.REPORT_CONFIG.PM_COMMON_RI_CONFIG_DTL;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_PROC_PARAMS;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_TAB_HDR;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class DelegateDb implements Serializable {
	
	private static final long serialVersionUID = -8979017245598320611L;


	public DelegateDb() {
		super();
	}
	

/*	*//**
	 * Method to delete Row
	 * @param detailsBean
	 * @return
	 *//*
	public int deleteData(PM_CUSTOMIZED_REPORT detailsBean)
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	
	*//**
	 * Method to update or insert row 
	 * @param detailsBean
	 * @return
	 * @throws Exception
	 *//*
	public int updateData(PM_CUSTOMIZED_REPORT detailsBean) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		int rowUpdated = 0;
		
		try {
			connection = CommonUtils.getConnection();
			System.out.println("DelegateDb.updateData()IN UPDATE DATA");
			
			rowUpdated = handler.executeInsert(detailsBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}*/


	public void executeSelectStatement(PILM205_COMPOSITE_ACTION compositeAction) throws Exception { 
		  ResultSet rs = null;
		  compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getTableList().clear();
		  try {
			  /*String selectQuery = "select REP_ID,PARAM_NAME,PARAM_TYPE,PARAM_DATA_TYPE,PARAM_ORDER,PARAM_LOV_QUERY,PARAM_LOV_YN,SRNO,PARAM_ID,PARAM_IP_REP_COL,UI_PARAM_IP_REP_COL,PM_REQUIRED,PARM_FROMTO_REL,PARAM_DEPEN_ID from PM_COMMON_RI_CONFIG_DTL";*/
			  String selectQuery = "select * from PM_COMMON_RI_CONFIG_DTL";
				
				rs = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection());
				while(rs.next()){
					
					PM_COMMON_RI_CONFIG_DTL PM_COMMON_RI_CONFIG_DTL_BEAN = new PM_COMMON_RI_CONFIG_DTL();
					
					
					PM_COMMON_RI_CONFIG_DTL_BEAN.setREP_ID(rs.getString("REP_ID"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_NAME(rs.getString("PARAM_NAME"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_TYPE(rs.getString("PARAM_TYPE"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DATA_TYPE(rs.getString("PARAM_DATA_TYPE"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ORDER(rs.getInt("PARAM_ORDER"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_LOV_QUERY(rs.getString("PARAM_LOV_QUERY"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_LOV_YN(rs.getLong("PARAM_LOV_YN"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setSRNO(rs.getInt("SRNO"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ID(rs.getString("PARAM_ID"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_IP_REP_COL(rs.getString("PARAM_IP_REP_COL"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setUI_PARAM_IP_REP_COL(rs.getString("UI_PARAM_IP_REP_COL"));
					if(rs.getString(12) == "" || rs.getString(12) == null){
						PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED("FALSE");
					}else{
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED(rs.getString("PM_REQUIRED"));
					}
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARM_FROMTO_REL(rs.getInt("PARM_FROMTO_REL"));
					PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEN_ID(rs.getString("PARAM_DEPEN_ID"));
					
					
					
					compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getTableList().add(PM_COMMON_RI_CONFIG_DTL_BEAN);
				}
		
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  finally { 
		  CommonUtils.closeCursor(rs);
		 } 
}


	public void executeSelectStatementForRepTabHdr(
			PILM205_COMPOSITE_ACTION compositeAction) throws Exception { 
		  
		  Connection connection=null;
		  ResultSet resultSet=null;
		  compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_LIST().clear();
		  
		  try {
			  connection=CommonUtils.getConnection();
			  String selectQuery = "select PMRTH_SR_NO,PMRTH_MODULE_ID,PMRTH_REP_NAME,PMRTH_REP_CATG,PMRTH_REP_ID,PMRTH_REP_TEMP_NAME_ID,PMRTH_CONN_REQD,PMRTH_PROC_REQD,PMRTH_REPORT_CATG from PM_REP_TAB_HDR";
				ResultSet rs = null;
				rs = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection());
				while(rs.next()){
					PM_REP_TAB_HDR PM_REP_TAB_HDR_BEAN = new PM_REP_TAB_HDR();
					PM_REP_TAB_HDR_BEAN.setPMRTH_SR_NO(rs.getString(1));
					PM_REP_TAB_HDR_BEAN.setPMRTH_MODULE_ID(rs.getString(2));
					PM_REP_TAB_HDR_BEAN.setPMRTH_REP_NAME(rs.getString(3));
					PM_REP_TAB_HDR_BEAN.setPMRTH_REP_CATG(rs.getString(4));
					PM_REP_TAB_HDR_BEAN.setPMRTH_REP_ID(rs.getString(5));
					PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TEMP_NAME_ID(rs.getString(6));
					
					if(rs.getString(7) == "" || rs.getString(7) == null){
						PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD("N");
					}else{
					PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD(rs.getString(7));
					}
					
					
					if(rs.getString(8) == "" || rs.getString(8) == null){
						PM_REP_TAB_HDR_BEAN.setPMRTH_PROC_REQD("N");
					}else{
					PM_REP_TAB_HDR_BEAN.setPMRTH_PROC_REQD(rs.getString(8));
					}
					PM_REP_TAB_HDR_BEAN.setPMRTH_REPORT_CATG(rs.getString(9));
					
					compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_LIST().add(PM_REP_TAB_HDR_BEAN);
				}
		
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  finally { 
		  CommonUtils.closeCursor(resultSet);
		 } 
}


	public void executeSelectStatementForRepProcParams(
			PILM205_COMPOSITE_ACTION compositeAction) throws Exception { 
		  
		  Connection connection=null;
		  ResultSet resultSet=null;
		  compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_LIST().clear();
		  
		  try {
			  connection=CommonUtils.getConnection();
			  String selectQuery = "select * from PM_REP_PROC_PARAMS";
				ResultSet rs = null;
				rs = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection());
				while(rs.next()){
					PM_REP_PROC_PARAMS PM_REP_PROC_PARAMS_BEAN = new PM_REP_PROC_PARAMS();
					PM_REP_PROC_PARAMS_BEAN.setPMRTH_SR_NO(rs.getString(1));
					PM_REP_PROC_PARAMS_BEAN.setPMRTH_REP_ID(rs.getString(2));
					PM_REP_PROC_PARAMS_BEAN.setPMRTH_PROC_NAME(rs.getString(3));
					PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_TYPE(rs.getString(4));
					PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_DATATYPE(rs.getString(5));
					
					
					compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_LIST().add(PM_REP_PROC_PARAMS_BEAN);
				}
		
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  finally { 
		  CommonUtils.closeCursor(resultSet);
		 } 
}
	
 
	
}

package com.iii.pel.forms.PILM205;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.application.FacesMessage;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM021_A.PP_SYSTEM_1;
import com.iii.pel.forms.PM023_A.PM023_A_COMPOSITE_ACTION;
import com.iii.pel.forms.PM023_A.PM_CUSTOMIZED_REPORT;
import com.iii.pel.forms.REPORT_CONFIG.PM_COMMON_RI_CONFIG_DTL;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_PROC_PARAMS;
import com.iii.pel.forms.REPORT_CONFIG.PM_REP_TAB_HDR;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 1001061
 *
 */
public class PILM205_CUSTOMIZED_REPORT_HELPER implements Serializable {

	private static final long serialVersionUID = -5644670086414786445L;

	public List<PM_COMMON_RI_CONFIG_DTL> executeQuery(
			PILM205_COMPOSITE_ACTION compositeAction) {

		List<PM_COMMON_RI_CONFIG_DTL> PM_COMMON_RI_CONFIG_DTL_LIST = new ArrayList<PM_COMMON_RI_CONFIG_DTL>();
		try {
			
			new DelegateDb().executeSelectStatement(compositeAction);
			PM_COMMON_RI_CONFIG_DTL_LIST = compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getTableList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PM_COMMON_RI_CONFIG_DTL_LIST;

	}
	
	public List<PM_REP_TAB_HDR> executeQueryForRepTabHdr(
			PILM205_COMPOSITE_ACTION compositeAction) {

		List<PM_REP_TAB_HDR> PM_REP_TAB_HDR_LIST = new ArrayList<PM_REP_TAB_HDR>();
		try {
			
			new DelegateDb().executeSelectStatementForRepTabHdr(compositeAction);
			PM_REP_TAB_HDR_LIST = compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_LIST();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PM_REP_TAB_HDR_LIST;

	}
	public List<PM_REP_PROC_PARAMS> executeQueryRepProcParams(
			PILM205_COMPOSITE_ACTION compositeAction) {

		List<PM_REP_PROC_PARAMS> PM_REP_PROC_PARAMS_LIST = new ArrayList<PM_REP_PROC_PARAMS>();
		try {
			
			new DelegateDb().executeSelectStatementForRepProcParams(compositeAction);
			PM_REP_PROC_PARAMS_LIST = compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_LIST();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PM_REP_PROC_PARAMS_LIST;

	}
	
	

	
public PM_COMMON_RI_CONFIG_DTL getDetails(PILM205_COMPOSITE_ACTION compositeAction) {
		
		ResultSet resultSet = null;
		PM_COMMON_RI_CONFIG_DTL PM_COMMON_RI_CONFIG_DTL_BEAN = new PM_COMMON_RI_CONFIG_DTL();
		try{
			
			String query = "SELECT ROWID,REP_ID,PARAM_NAME,PARAM_TYPE,PARAM_ORDER,PARAM_LOV_QUERY,SRNO,PARAM_ID,PARAM_IP_REP_COL,UI_PARAM_IP_REP_COL,PM_REQUIRED,PARM_FROMTO_REL,PARAM_DEPEN_ID,PARAM_DEPEND_COL FROM PM_COMMON_RI_CONFIG_DTL where REP_ID = ? and param_name = ? and param_order = ?";
			
			resultSet = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getREP_ID(),
				compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_NAME(), 
				compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_ORDER()} );
			
			if(resultSet.next()){
				PM_COMMON_RI_CONFIG_DTL_BEAN.setROWID(resultSet.getString(1));
				PM_COMMON_RI_CONFIG_DTL_BEAN.setREP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getREP_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_NAME());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_TYPE());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ORDER(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_ORDER());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_LOV_QUERY(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_LOV_QUERY());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setSRNO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getSRNO());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_IP_REP_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_IP_REP_COL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setUI_PARAM_IP_REP_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getUI_PARAM_IP_REP_COL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPM_REQUIRED());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARM_FROMTO_REL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARM_FROMTO_REL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEN_ID (compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_DEPEN_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEND_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_DEPEND_COL());
				
			}else{
				PM_COMMON_RI_CONFIG_DTL_BEAN.setREP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getREP_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_NAME());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_TYPE());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ORDER(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_ORDER());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_LOV_QUERY(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_LOV_QUERY());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setSRNO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getSRNO());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_IP_REP_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_IP_REP_COL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setUI_PARAM_IP_REP_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getUI_PARAM_IP_REP_COL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPM_REQUIRED());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARM_FROMTO_REL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARM_FROMTO_REL());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEN_ID (compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_DEPEN_ID());
				PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEND_COL(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_COMMON_RI_CONFIG_DTL_BEAN().getPARAM_DEPEND_COL());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return PM_COMMON_RI_CONFIG_DTL_BEAN;
		
	}

public PM_REP_TAB_HDR getRepHeaderDetails(PILM205_COMPOSITE_ACTION compositeAction) {
	
	ResultSet resultSet = null;
	PM_REP_TAB_HDR PM_REP_TAB_HDR_BEAN = new PM_REP_TAB_HDR();
	try{
		
		String query = "SELECT ROWID,PMRTH_SR_NO,PMRTH_MODULE_ID,PMRTH_REP_NAME,PMRTH_REP_CATG,PMRTH_REP_ID,PMRTH_REP_STATUS,PMRTH_REP_TYPE,PMRTH_REP_TEMP_NAME_ID,PMRTH_CONN_REQD,PMRTH_PROC_REQD,PMRTH_REPORT_CATG FROM PM_REP_TAB_HDR where PMRTH_REP_ID = ?";
		
		resultSet = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_ID()} );
		
		if(resultSet.next()){
			
			
			
			
			PM_REP_TAB_HDR_BEAN.setROWID(resultSet.getString(1));
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_SR_NO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_SR_NO());
			PM_REP_TAB_HDR_BEAN.setPMRTH_MODULE_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_MODULE_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_NAME());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_CATG(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_CATG());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_STATUS(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_STATUS());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_TYPE());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TEMP_NAME_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_TEMP_NAME_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_CONN_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_CONN_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_PROC_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_PROC_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REPORT_CATG(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REPORT_CATG());
			
			

			
		}else{
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_SR_NO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_SR_NO());
			PM_REP_TAB_HDR_BEAN.setPMRTH_MODULE_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_MODULE_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_NAME());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_CATG(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_CATG());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_STATUS(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_STATUS());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_TYPE());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REP_TEMP_NAME_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REP_TEMP_NAME_ID());
			PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_CONN_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_CONN_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_CONN_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_PROC_REQD(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_PROC_REQD());
			PM_REP_TAB_HDR_BEAN.setPMRTH_REPORT_CATG(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_TAB_HDR_BEAN().getPMRTH_REPORT_CATG());
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return PM_REP_TAB_HDR_BEAN;
	
}




public PM_REP_PROC_PARAMS getProcParamsDetails(PILM205_COMPOSITE_ACTION compositeAction) {
	
	ResultSet resultSet = null;
	PM_REP_PROC_PARAMS PM_REP_PROC_PARAMS_BEAN = new PM_REP_PROC_PARAMS();
	try{
		
		String query = "SELECT ROWID,PMRTH_REP_ID,PMRTH_SR_NO,PMRTH_PROC_NAME,PMRTH_PARAM_TYPE,PMRTH_PARAM_DATATYPE FROM PM_REP_PROC_PARAMS where PMRTH_REP_ID = ?";
		
		resultSet = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_REP_ID()} );
		
		if(resultSet.next()){
			PM_REP_PROC_PARAMS_BEAN.setROWID(resultSet.getString(1));
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_REP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_REP_ID());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_SR_NO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_SR_NO());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PROC_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PROC_NAME());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PARAM_TYPE());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_DATATYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PARAM_DATATYPE());
		
			

			
		}else{
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_REP_ID(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_REP_ID());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_SR_NO(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_SR_NO());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PROC_NAME(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PROC_NAME());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_TYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PARAM_TYPE());
			PM_REP_PROC_PARAMS_BEAN.setPMRTH_PARAM_DATATYPE(compositeAction.getPILM205_CUSTOMIZED_REPORT_ACTION_BEAN().getPM_REP_PROC_PARAMS_BEAN().getPMRTH_PARAM_DATATYPE());
		
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return PM_REP_PROC_PARAMS_BEAN;
	
}


public void postQuery(PM_COMMON_RI_CONFIG_DTL PM_COMMON_RI_CONFIG_DTL_BEAN) throws Exception{
	
	ResultSet resultSet = null;
	
	try{
		
		String query = "SELECT ROWID,REP_ID,PARAM_NAME,PARAM_TYPE,PARAM_ORDER,PARAM_LOV_QUERY,SRNO,PARAM_ID,PARAM_IP_REP_COL,UI_PARAM_IP_REP_COL,PM_REQUIRED,PARM_FROMTO_REL,PARAM_DEPEN_ID,PARAM_DEPEND_COL FROM PM_COMMON_RI_CONFIG_DTL where REP_ID = ?";
		
		resultSet = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{PM_COMMON_RI_CONFIG_DTL_BEAN.getREP_ID()} );
		if(resultSet.next()){
			PM_COMMON_RI_CONFIG_DTL_BEAN.setROWID(resultSet.getString(1));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setREP_ID(resultSet.getString(2));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_NAME(resultSet.getString(3));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_TYPE(resultSet.getString(4));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ORDER(resultSet.getInt(5));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_LOV_QUERY(resultSet.getString(6));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setSRNO(resultSet.getInt(7));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_ID(resultSet.getString(8));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_IP_REP_COL(resultSet.getString(9));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setUI_PARAM_IP_REP_COL(resultSet.getString(10));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPM_REQUIRED(resultSet.getString(11));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARM_FROMTO_REL(resultSet.getInt(12));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEN_ID (resultSet.getString(13));
			PM_COMMON_RI_CONFIG_DTL_BEAN.setPARAM_DEPEND_COL(resultSet.getString(14));
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

	public void executeDelete(
			PM_COMMON_RI_CONFIG_DTL PM_COMMON_RI_CONFIG_DTL_BEAN)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "DELETE FROM PM_COMMON_RI_CONFIG_DTL WHERE REP_ID=?";

		try {
			connection = CommonUtils.getConnection();

			handler.executeDeleteStatement(query, connection,
					new Object[] { PM_COMMON_RI_CONFIG_DTL_BEAN.getREP_ID() });
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void executeDelete(
			PM_REP_TAB_HDR PM_REP_TAB_HDR_BEAN)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "DELETE FROM PM_REP_TAB_HDR WHERE PMRTH_REP_ID=?";

		try {
			connection = CommonUtils.getConnection();

			handler.executeDeleteStatement(query, connection,
					new Object[] { PM_REP_TAB_HDR_BEAN.getPMRTH_REP_ID() });
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	public void executeDelete(
			PM_REP_PROC_PARAMS PM_REP_PROC_PARAMS_BEAN)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "DELETE FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID=? and PMRTH_PROC_NAME = ? and PMRTH_SR_NO = ?";

		try {
			connection = CommonUtils.getConnection();

			handler.executeDeleteStatement(query, connection,
					new Object[] { PM_REP_PROC_PARAMS_BEAN.getPMRTH_REP_ID(), PM_REP_PROC_PARAMS_BEAN.getPMRTH_PROC_NAME(), PM_REP_PROC_PARAMS_BEAN.getPMRTH_SR_NO() });
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<PP_SYSTEM_1> doGetRepCat() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PP_SYSTEM_1> repCatgList = new ArrayList<PP_SYSTEM_1>();
		ResultSet resultSet = null;
		String query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE = ?";
		try {
			connection = CommonUtils.getConnection();
			String object = "IL_CATG";
			resultSet = handler.executeSelectStatement(query, connection, new Object[] {object});
			while(resultSet.next()){
				PP_SYSTEM_1 PP_SYSTEM_BEAN = new PP_SYSTEM_1();
				PP_SYSTEM_BEAN.setPS_CODE(resultSet.getString(1)); 
				PP_SYSTEM_BEAN.setPS_CODE_DESC(resultSet.getString(2));
				repCatgList.add(PP_SYSTEM_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return repCatgList;
		
	}

	public boolean dovalidateSerialNumber(String repId, Integer value) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		boolean srNoExist = false;
		ResultSet resultSet = null;
		String query = "select SRNO from pm_common_ri_config_dtl WHERE REP_ID = ? AND SRNO = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, new Object[] {repId,value});
			while(resultSet.next()){
				srNoExist = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return srNoExist;
	}



}

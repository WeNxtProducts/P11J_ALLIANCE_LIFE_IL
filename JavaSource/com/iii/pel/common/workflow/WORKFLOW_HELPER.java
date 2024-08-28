package com.iii.pel.common.workflow;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class WORKFLOW_HELPER {

	public List<PGIM_WORKFLOW_BUCKET> getWorkFlowBucket() throws Exception {
		ResultSet result = null;
		ResultSet result1 = null;
		List<PGIM_WORKFLOW_BUCKET> headerList = new ArrayList<PGIM_WORKFLOW_BUCKET>();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String queryString = "SELECT HDR.PWTH_DEPT_CODE,HDR.PWTH_FLEX_10 AS DEPT_DESCRIPTION,HDR.PWTH_PROCESS_ID,HDR.PWTH_PWB_CODE, "
					+ "WB.PWB_DESC, WB.PWB_SR_NO, Count(*) As TranCount FROM PGIW_WF_TRAN_HDR HDR,   PGIM_WORKFLOW_BUCKET WB "
					+ "WHERE WB.PWB_ENABLE_YN = '1' AND WB.PWB_MAIN_BUKT = HDR.PWTH_PROCESS_ID AND WB.PWB_CODE = HDR.PWTH_PWB_CODE "
					+ "AND NVL(WB.PWB_MAIL_ONLY_YN,'0') = '0' AND HDR.PWTH_USER_ID LIKE ? GROUP BY HDR.PWTH_DEPT_CODE,HDR.PWTH_FLEX_10 , HDR.PWTH_PROCESS_ID, "
					+ "HDR.PWTH_PWB_CODE, WB.PWB_DESC, WB.PWB_SR_NO ORDER BY HDR.PWTH_DEPT_CODE, HDR.PWTH_PROCESS_ID,WB.PWB_SR_NO";
			
			String query1="SELECT "
					/*+ " HDR.PWTH_DEPT_CODE,HDR.PWTH_FLEX_10 AS DEPT_DESCRIPTION, "*/
					+ "HDR.PWTH_PROCESS_ID,HDR.PWTH_WORKSTEP_ID ,HDR.PWTH_PWB_CODE,WB.PWB_DESC,WB.PWB_SR_NO, "
					+ "Count(*) As TranCount "
					+ "FROM PGIW_WF_TRAN_HDR HDR, PGIM_WORKFLOW_BUCKET WB "
					+ "WHERE WB.PWB_ENABLE_YN = '1' "
					+ "AND WB.PWB_MAIN_BUKT = HDR.PWTH_PROCESS_ID "
					+ "AND WB.PWB_CODE = HDR.PWTH_PWB_CODE "
					+ "AND NVL(WB.PWB_MAIL_ONLY_YN, '0') = '0' "
					+ "AND HDR.PWTH_USER_ID LIKE ? "
					//+ "AND WB.PWB_CODE IN ('POAIL','PAIL','POIL','CIIL','CEIIL','CEL','CEIL') "
					+ "GROUP BY "
					/*+ "HDR.PWTH_DEPT_CODE, "*/
					/*+ "HDR.PWTH_FLEX_10, "*/
					+ "HDR.PWTH_PROCESS_ID, HDR.PWTH_WORKSTEP_ID ,"
					+ "HDR.PWTH_PWB_CODE, "
					+ "WB.PWB_DESC, "
					+ "WB.PWB_SR_NO "
					+ "ORDER BY "
					/*+ "HDR.PWTH_DEPT_CODE, "*/
					+ "HDR.PWTH_PROCESS_ID, WB.PWB_SR_NO";


			ResultSet resultusergroup = handler.executeSelectStatement("SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID=?",
					connection, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			String USER_ID=null;
			while (resultusergroup.next()) {
				USER_ID=resultusergroup.getString(1);
			}
			result = handler.executeSelectStatement(query1.toString(),
					connection,new Object[] {"%"+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")+"%"});
			/*End*/
			
			while (result.next()) {
				PGIM_WORKFLOW_BUCKET tempBean = new PGIM_WORKFLOW_BUCKET();
				tempBean.setPWB_WORKSTEP_ID(result.getString("PWTH_PWB_CODE"));
				tempBean.setPWB_DESC(result.getString("PWB_DESC"));
				tempBean.setTransactionCount(result.getString("TranCount"));
				
				
				headerList.add(tempBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return headerList;
	}
	
	public List<PGIM_WORKFLOW_BUCKET> getWorkFlowUnAssignedBucket() throws Exception {
		ResultSet result = null;
		ResultSet result1 = null;
		List<PGIM_WORKFLOW_BUCKET> headerList = new ArrayList<PGIM_WORKFLOW_BUCKET>();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			
			String query1="SELECT "
					/*+ "HDR.PWTH_DEPT_CODE,HDR.PWTH_FLEX_10 AS DEPT_DESCRIPTION, "*/
					+ "HDR.PWTH_PROCESS_ID,HDR.PWTH_PWB_CODE,WB.PWB_DESC,WB.PWB_SR_NO, "
					+ "Count(*) As TranCount "
					+ "FROM PGIW_WF_TRAN_HDR HDR, PGIM_WORKFLOW_BUCKET WB "
					+ "WHERE WB.PWB_ENABLE_YN = '1' "
					+ "AND WB.PWB_MAIN_BUKT = HDR.PWTH_PROCESS_ID "
					+ "AND WB.PWB_CODE = HDR.PWTH_PWB_CODE "
					+ "AND NVL(WB.PWB_MAIL_ONLY_YN, '0') = '0' "
					+ "AND HDR.PWTH_USER_ID IS NULL "
					+ "AND HDR.PWTH_TARGET_USGRP IN (?,?) "
					+ "AND PWTH_TRAN_PROG_CODE NOT LIKE 'PGL%' "
					+ "GROUP BY "
					/*+ "HDR.PWTH_DEPT_CODE, "*/
					/*+ "HDR.PWTH_FLEX_10, "*/
					+ "HDR.PWTH_PROCESS_ID, "
					+ "HDR.PWTH_PWB_CODE, "
					+ "WB.PWB_DESC, "
					+ "WB.PWB_SR_NO "
					+ "ORDER BY "
					/*+ "HDR.PWTH_DEPT_CODE, "*/
					+ "HDR.PWTH_PROCESS_ID, WB.PWB_SR_NO";
			
			String query2="SELECT USER_GROUP_ID FROM MENU_USER_REPT_HIER, MENU_USER "
						 + "WHERE RH_REPORT_TO = ? "
						 + "AND RH_USER_ID = USER_ID "
						 + "AND (TRUNC(SYSDATE) BETWEEN RH_EFF_DT_FM AND RH_EFF_DT_TO)";
			
			ResultSet rs = handler.executeSelectStatement(query2,
					connection, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			
			String REPORT_USER_GRP=null;
			while (rs.next()) {
				REPORT_USER_GRP=rs.getString(1);
			}
			
			
			ResultSet resultusergroup = handler.executeSelectStatement("SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID=?",
					connection, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			String USER_GRP=null;
			while (resultusergroup.next()) {
				USER_GRP=resultusergroup.getString(1);
			}
			
			result = handler.executeSelectStatement(query1.toString(),connection,new Object[] {USER_GRP,REPORT_USER_GRP});
				
				while (result.next()) {
					PGIM_WORKFLOW_BUCKET tempBean = new PGIM_WORKFLOW_BUCKET();
					tempBean.setPWB_WORKSTEP_ID(result.getString("PWTH_PWB_CODE"));
					tempBean.setPWB_DESC(result.getString("PWB_DESC"));
					tempBean.setTransactionCount(result.getString("TranCount"));
					headerList.add(tempBean);
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return headerList;
	}

	
	
	
	
	public List<Pgiw_wf_tran_dtls> getWorkFlowDetails(String code,
			String userId, String deptCode) throws Exception {
		List<String> s=new ArrayList<String>();
		ResultSet result = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		String Main_bkt_code = null;
		String process_id = null;
		List<Pgiw_wf_tran_dtls> headerList = new ArrayList<Pgiw_wf_tran_dtls>();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			
			String queryString = "SELECT PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT FROM "
					+ "( SELECT HDR.PWTH_SYS_ID, HDR.PWTH_ESC_LVL_DONE, HDR.PWTH_CR_UID, HDR.PWTH_CR_DT, "
					+ "DTLS.PWTD_RULE_ID, "
					+ "NVL(DTLS.PWTD_CHAR_VALUE,NVL(TO_CHAR(DTLS.PWTD_NUM_VALUE),TO_CHAR(DTLS.PWTD_DATE_VALUE,'DD/MM/YYYY'))) AS FLDVALUE "
					+ "FROM PGIW_WF_TRAN_DTLS DTLS, PGIW_WF_TRAN_HDR HDR, "
					+ "MENU_USER_COMP_DIVN MUCD "
					+ "WHERE HDR.PWTH_SYS_ID = DTLS.PWTD_PWTH_SYS_ID "
					+ "AND HDR.PWTH_PWB_CODE = '"
					+ code
					+ "' "
					+ "AND MUCD.MUCD_USER_ID = '"
					+ userId
					+ "' "
					+ "AND HDR.PWTH_USER_ID = MUCD.MUCD_USER_ID "
					+ "ORDER BY HDR.PWTH_SYS_ID ) D "
					+ "group by PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT  "
					+ "ORDER BY PWTH_SYS_ID DESC";
			
			String user_name=null;
			Date user_Date = null;
			result = handler.executeSelectStatement(queryString.toString(),
					connection);
			
			String query_code = "SELECT * FROM PGIM_WORKFLOW_BUCKET WHERE PWB_CODE = '"+code+"'";
			
			result2 = handler.executeSelectStatement(query_code.toString(),
					connection);
			
			
			
			while (result2.next()) {
				 Main_bkt_code = result2.getString("PWB_MAIN_BUKT");
			}
			
			while (result.next()) {
				String sysId=result.getString("PWTH_SYS_ID");
				String query="select * from pgiw_wf_tran_dtls where pwtd_pwth_sys_id='"+sysId+"' ORDER BY PWTD_WF_CHK_YN";	
				result1 = handler.executeSelectStatement(query.toString(),
						connection);
				
				
				while(result1.next()){
					String ss=result1.getString("pwtd_char_value");
					user_name=result1.getString("PWTD_CR_UID");	
					user_Date = result1.getTimestamp("PWTD_CR_DT");	
					s.add(ss);
				}
				
				
				//System.out.println("code        :  "+code);
				Pgiw_wf_tran_dtls Pgiw_wf_tran_dtls=new Pgiw_wf_tran_dtls();
				if("UNDERWRITING".equalsIgnoreCase(Main_bkt_code))
				{
					/*String sDate1=s.get(0);
					Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
					String dates = new SimpleDateFormat("dd/MM/yy").format(date1);	
					
					Pgiw_wf_tran_dtls.setCreateUserDate(dates);*/
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setDivisionName(s.get(3));
					Pgiw_wf_tran_dtls.setFromDate(s.get(4));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(5));
					Pgiw_wf_tran_dtls.setProductName(s.get(6));
					Pgiw_wf_tran_dtls.setQuotationNumber(s.get(7));
					Pgiw_wf_tran_dtls.setToDate(s.get(8));
				}
				
				if("FINANCE".equalsIgnoreCase(Main_bkt_code))
				{
					/*String sDate1=s.get(0);
					if(sDate1!=null){
						Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
						String dates = new SimpleDateFormat("dd/MM/yy").format(date1);
						Pgiw_wf_tran_dtls.setCreateUserDate(dates);
					}
					*/
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setDivisionName(s.get(3));
					Pgiw_wf_tran_dtls.setFromDate(s.get(4));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(5));
					Pgiw_wf_tran_dtls.setProductName(s.get(6));
					Pgiw_wf_tran_dtls.setQuotationNumber(s.get(7));
					Pgiw_wf_tran_dtls.setToDate(s.get(8));
				}
				
				if("CLAIMS".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setClaimNumber(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setEstimateAmount(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setStatus(s.get(5));
					
				}
				if("WITHDRAWAL".equalsIgnoreCase(Main_bkt_code)){
					String sDate1=s.get(4);
					Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
					String dates = new SimpleDateFormat("dd/MM/yy").format(date1);
					
					String sDate2=s.get(1);
					Date date2=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate2);
					String dates2 = new SimpleDateFormat("dd/MM/yy").format(date2);
					
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCreateUserDate(dates2);
					Pgiw_wf_tran_dtls.setFullWithdrawal(s.get(2));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(3));
					Pgiw_wf_tran_dtls.setWithdrawalDate(dates);
					
				}
				
				if("OT_PC".equalsIgnoreCase(Main_bkt_code) || "OCD_PC".equalsIgnoreCase(Main_bkt_code) || "OT_SUR".equalsIgnoreCase(Main_bkt_code) || "OCD_SUR".equalsIgnoreCase(Main_bkt_code)
						|| "OT_WD".equalsIgnoreCase(Main_bkt_code) || "OCD_WD".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(1));
					Pgiw_wf_tran_dtls.setTransactionType(s.get(2));
					//Pgiw_wf_tran_dtls.setTransactionReqNo(s.get(3));
					Pgiw_wf_tran_dtls.setTransactionApprovalDate(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(5));
					Pgiw_wf_tran_dtls.setStatus(s.get(6));
				}
				
				if("OT_CLM".equalsIgnoreCase(Main_bkt_code) || "OCD_CLM".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(1));
					Pgiw_wf_tran_dtls.setTransactionType(s.get(2));
					Pgiw_wf_tran_dtls.setTransactionApprovalDate(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(5));
					Pgiw_wf_tran_dtls.setStatus(s.get(6));
					Pgiw_wf_tran_dtls.setClaimNumber(s.get(7));
				}
				
				
				if("CSM_CAIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CIIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CDIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CTIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CMIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CSURIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CMATIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CCIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_WDIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CCLIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CLIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CBIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CRIIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CRIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CADIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CGIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				/*END*/
				
				Pgiw_wf_tran_dtls.setTaskAssignedDate(user_Date);
				Pgiw_wf_tran_dtls.setTaskDueDate(getDueDate(code,Pgiw_wf_tran_dtls.getTaskAssignedDate(),userId));
				
				headerList.add(Pgiw_wf_tran_dtls);
				s.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return headerList;
	}
	
	
	
	public List<Pgiw_wf_tran_dtls> getWorkFlowUnAssignedDetails(String code,
			String userId, String deptCode) throws Exception {
		List<String> s=new ArrayList<String>();
		ResultSet result = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		String Main_bkt_code = null;
		List<Pgiw_wf_tran_dtls> headerList = new ArrayList<Pgiw_wf_tran_dtls>();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String queryString = "SELECT PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT,PWTH_USER_ID FROM "
					+ "( SELECT HDR.PWTH_SYS_ID, HDR.PWTH_ESC_LVL_DONE, HDR.PWTH_CR_UID, HDR.PWTH_CR_DT, "
					+ "DTLS.PWTD_RULE_ID, "
					+ "NVL(DTLS.PWTD_CHAR_VALUE,NVL(TO_CHAR(DTLS.PWTD_NUM_VALUE),TO_CHAR(DTLS.PWTD_DATE_VALUE,'DD/MM/YYYY'))) AS FLDVALUE,PWTH_USER_ID "
					+ "FROM PGIW_WF_TRAN_DTLS DTLS, PGIW_WF_TRAN_HDR HDR, "
					+ "MENU_USER_COMP_DIVN MUCD "
					+ "WHERE HDR.PWTH_SYS_ID = DTLS.PWTD_PWTH_SYS_ID "
					+ "AND HDR.PWTH_PWB_CODE = '"
					+ code
					+ "' "
					+ "AND HDR.PWTH_USER_ID IS NULL "
					+ "AND HDR.PWTH_TARGET_USGRP IN (?,?) "
					+ "ORDER BY HDR.PWTH_SYS_ID ) D "
					+ "group by PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT,PWTH_USER_ID  "
					+ "ORDER BY PWTH_SYS_ID DESC";
			
			
			String query_code = "SELECT * FROM PGIM_WORKFLOW_BUCKET WHERE PWB_CODE = '"+code+"'";
			
			result2 = handler.executeSelectStatement(query_code.toString(),
					connection);
			
			
			
			while (result2.next()) {
				 Main_bkt_code = result2.getString("PWB_MAIN_BUKT");	
			}
			
			

			String query2="SELECT USER_GROUP_ID FROM MENU_USER_REPT_HIER, MENU_USER "
					 + "WHERE RH_REPORT_TO = ? "
					 + "AND RH_USER_ID = USER_ID "
					 + "AND (TRUNC(SYSDATE) BETWEEN RH_EFF_DT_FM AND RH_EFF_DT_TO)";
			
			ResultSet rs = handler.executeSelectStatement(query2,
					connection, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			
			String REPORT_USER_GRP=null;
			while (rs.next()) {
				REPORT_USER_GRP=rs.getString(1);
			}
			
			
			ResultSet resultusergroup = handler.executeSelectStatement("SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID=?",
					connection, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			String USER_GRP=null;
			while (resultusergroup.next()) {
				USER_GRP=resultusergroup.getString(1);
			}
			
			String user_name=null;
			Date user_Date = null;
			result = handler.executeSelectStatement(queryString.toString(),
					connection,new Object[] {USER_GRP,REPORT_USER_GRP});
			while (result.next()) {
				String sysId=result.getString("PWTH_SYS_ID");
				//System.out.println("sysId    : "+sysId);
				String assigned_to =result.getString("PWTH_USER_ID");
				String query="select * from pgiw_wf_tran_dtls where pwtd_pwth_sys_id='"+sysId+"' ORDER BY PWTD_WF_CHK_YN";	
				result1 = handler.executeSelectStatement(query.toString(),
						connection);
				
				
				while(result1.next()){
					String ss=result1.getString("pwtd_char_value");
					user_name=result1.getString("PWTD_CR_UID");	
					//System.out.println("user_name    : "+user_name);
					user_Date = result1.getTimestamp("PWTD_CR_DT");	
					//System.out.println("user_Date    : "+user_Date);
					s.add(ss);
				}
				
				
				System.out.println("code        :  "+code);
				Pgiw_wf_tran_dtls Pgiw_wf_tran_dtls=new Pgiw_wf_tran_dtls();
				
				Pgiw_wf_tran_dtls.setSys_Id(sysId);
				System.out.println("##execute_getSys_Id##" + Pgiw_wf_tran_dtls.getSys_Id());
				if(assigned_to != null){
					Pgiw_wf_tran_dtls.setAssignTaskTo(assigned_to);
					System.out.println("##execute_setAssignTaskTo##" + Pgiw_wf_tran_dtls.getAssignTaskTo());
				}
				
				
				
				if("UNDERWRITING".equalsIgnoreCase(Main_bkt_code))
				{
					/*String sDate1=s.get(0);
					if(sDate1!=null){
						Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
						String dates = new SimpleDateFormat("dd/MM/yy").format(date1);
						Pgiw_wf_tran_dtls.setCreateUserDate(dates);
					}
					*/
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setDivisionName(s.get(3));
					Pgiw_wf_tran_dtls.setFromDate(s.get(4));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(5));
					Pgiw_wf_tran_dtls.setProductName(s.get(6));
					Pgiw_wf_tran_dtls.setQuotationNumber(s.get(7));
					Pgiw_wf_tran_dtls.setToDate(s.get(8));
				}
				
				if("FINANCE".equalsIgnoreCase(Main_bkt_code))
				{
					/*String sDate1=s.get(0);
					if(sDate1!=null){
						Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
						String dates = new SimpleDateFormat("dd/MM/yy").format(date1);
						Pgiw_wf_tran_dtls.setCreateUserDate(dates);
					}*/
					
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setDivisionName(s.get(3));
					Pgiw_wf_tran_dtls.setFromDate(s.get(4));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(5));
					Pgiw_wf_tran_dtls.setProductName(s.get(6));
					Pgiw_wf_tran_dtls.setQuotationNumber(s.get(7));
					Pgiw_wf_tran_dtls.setToDate(s.get(8));
				}
				
				if("CLAIMS".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setClaimNumber(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setEstimateAmount(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setStatus(s.get(5));
					
				}
				if("WITHDRAWAL".equalsIgnoreCase(Main_bkt_code)){
					String sDate1=s.get(4);
					Date date1=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate1);
					String dates = new SimpleDateFormat("dd/MM/yy").format(date1);
					
					String sDate2=s.get(1);
					Date date2=new SimpleDateFormat("dd-MMM-yyyy").parse(sDate2);
					String dates2 = new SimpleDateFormat("dd/MM/yy").format(date2);
					
					Pgiw_wf_tran_dtls.setCreateUserName(user_name);
					Pgiw_wf_tran_dtls.setCreateUserDate(dates2);
					Pgiw_wf_tran_dtls.setFullWithdrawal(s.get(2));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(3));
					Pgiw_wf_tran_dtls.setWithdrawalDate(dates);
					
				}
				
				if("OT_PC".equalsIgnoreCase(Main_bkt_code) || "OCD_PC".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(1));
					Pgiw_wf_tran_dtls.setTransactionType(s.get(2));
					//Pgiw_wf_tran_dtls.setTransactionReqNo(s.get(3));
					Pgiw_wf_tran_dtls.setTransactionApprovalDate(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(5));
					Pgiw_wf_tran_dtls.setStatus(s.get(6));
				}
				
				if("OT_CLM".equalsIgnoreCase(Main_bkt_code) || "OCD_CLM".equalsIgnoreCase(Main_bkt_code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCreateUserDate(s.get(1));
					Pgiw_wf_tran_dtls.setTransactionType(s.get(2));
					Pgiw_wf_tran_dtls.setTransactionApprovalDate(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(5));
					Pgiw_wf_tran_dtls.setStatus(s.get(6));
					Pgiw_wf_tran_dtls.setClaimNumber(s.get(7));
				}
				
					
				if("CSM_CAIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CIIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CDIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}if("CSM_CTIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CMIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CSURIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CMATIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CCIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_WDIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CCLIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CLIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CBIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CRIIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CRIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CADIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				if("CSM_CGIL".equals(code)){
					Pgiw_wf_tran_dtls.setCreateUserName(s.get(0));
					Pgiw_wf_tran_dtls.setCustomerCode(s.get(1));
					Pgiw_wf_tran_dtls.setCustomerName(s.get(2));
					Pgiw_wf_tran_dtls.setNationalId(s.get(3));
					Pgiw_wf_tran_dtls.setPolicyNumber(s.get(4));
					
				}
				/*END*/
				
				
				Pgiw_wf_tran_dtls.setTaskAssignedDate(user_Date);
				Pgiw_wf_tran_dtls.setTaskDueDate(getDueDate(code,Pgiw_wf_tran_dtls.getTaskAssignedDate(),userId));
				headerList.add(Pgiw_wf_tran_dtls);
				s.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return headerList;
	}
	

	/*added by raja on 15-05-17*/
	
	public String getOutcome(String PWB_WORKSTEP_ID)
	{
		String outCome=null;
		try{
			String query="SELECT PWB_OUTCOME_DET FROM PGIM_WORKFLOW_BUCKET WHERE PWB_CODE=?";
			ResultSet outComeRS= new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{PWB_WORKSTEP_ID});
			while(outComeRS.next())
			{
				outCome=outComeRS.getString("PWB_OUTCOME_DET");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return outCome;
	}
	
	/* Added by kavitha on 01.11.2019 for RoadMap*/
	public String getToBeOutcome(String PWB_WORKSTEP_ID){
		String outCome=null;
		try{
			String query="SELECT PWB_TOBE_OUTCOME FROM PGIM_WORKFLOW_BUCKET WHERE PWB_CODE=?";
			ResultSet outComeRS= new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{PWB_WORKSTEP_ID});
			while(outComeRS.next()){
				outCome=outComeRS.getString("PWB_TOBE_OUTCOME");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return outCome;
	}
	
	
	/* Added by kavitha for RoadMap*/
	public Date getDueDate(String code,Date taskAssignedDate,String userId){
		Date DUE_DATE = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2= null;
		ResultSet rs3= null;
		ResultSet rs4= null;
		int PWMU_ESC_DAYS = 0;
		String PWMU_ESC_LMT_TYP = null;
		String USER_GROUP_ID = null;
		String USER_BRANCH = null;
		Date assigned_date = null;
		int ESC_NEW =0;
		int holiday = 0;
		int COUNT = 0;
		int DIVN_WORK_TIME_TO = 0;
		int DIVN_WORK_TIME_FROM = 0;
		CRUDHandler handler = new CRUDHandler();
		try {
				String C1 = "SELECT PWMU_ESC_LIMIT,PWMU_ESC_LMT_TYP FROM PGIM_WF_MAIL_USGRP  WHERE PWMU_PWB_BUKT_CODE = ?";
				con = CommonUtils.getConnection();
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] {code});
				while (rs1.next()) {
					PWMU_ESC_DAYS = rs1.getInt("PWMU_ESC_LIMIT");
					PWMU_ESC_LMT_TYP = rs1.getString("PWMU_ESC_LMT_TYP");
				}
				if(PWMU_ESC_DAYS==0){
					DUE_DATE = taskAssignedDate;
				}
				
				String C2= "SELECT USER_GROUP_ID, MUCD_DIVN_CODE FROM MENU_USER, MENU_USER_COMP_DIVN WHERE USER_ID = MUCD_USER_ID AND USER_ID = '"+userId+"'";
				
				rs2 = handler.executeSelectStatement(C2, con);
				while(rs2.next()){
					USER_GROUP_ID = rs2.getString("USER_GROUP_ID");
					USER_BRANCH = rs2.getString("MUCD_DIVN_CODE");
				}
				
				if(PWMU_ESC_LMT_TYP!=null && PWMU_ESC_LMT_TYP.equalsIgnoreCase("D")){
								
						      ESC_NEW = PWMU_ESC_DAYS;	
							  assigned_date = taskAssignedDate;
							while(ESC_NEW>0){   
								Date next_day = CommonUtils.addDaysToDate(assigned_date, 1);
							    String next_day1 =  CommonUtils.dateToStringFormatter(next_day);
							    String C3=   " SELECT COUNT(PWHM_DATE) COUNT_NUM"
							    		 + " FROM PGIM_WF_HOLIDAY_MASTER"
							    		 + " WHERE PWHM_DATE = TO_DATE('"+next_day1+"', 'DD/MM/RRRR')"
							             + " AND PWHM_USER_GRP ="
							             + " DECODE(PWHM_USER_GRP,'ALL','ALL',"
							             + " LTRIM(RTRIM(REPLACE('"+USER_GROUP_ID +"', '''', NULL))))"
							             + " AND PWHM_BRANCH_CODE = '"+USER_BRANCH +"'";
									rs3 = handler.executeSelectStatement(C3, con);
									
									while(rs3.next()){
										holiday = rs3.getInt("COUNT_NUM");
										if(holiday==0){
											ESC_NEW = ESC_NEW -1;
										}else{
											COUNT = COUNT+1;
										}
								       }
									assigned_date = next_day;
							}
							
							PWMU_ESC_DAYS = PWMU_ESC_DAYS + COUNT;
							DUE_DATE = CommonUtils.addDaysToDate(taskAssignedDate, PWMU_ESC_DAYS);
				}else if(PWMU_ESC_LMT_TYP!=null && PWMU_ESC_LMT_TYP.equalsIgnoreCase("H")){
					 
					
					 DUE_DATE = addHoursToJavaUtilDate(taskAssignedDate, PWMU_ESC_DAYS);
					 int hours = DUE_DATE.getHours();
					 int minutes = DUE_DATE.getMinutes();
					 String C4 = "SELECT * FROM PM_DIVISION WHERE DIVN_CODE = '"+USER_BRANCH+"'";
					 rs4 = handler.executeSelectStatement(C4, con);
					 while(rs4.next()){
						DIVN_WORK_TIME_TO = rs4.getInt("DIVN_WORK_TIME_TO");
						DIVN_WORK_TIME_FROM  = rs4.getInt("DIVN_WORK_TIME_FROM");
					 }
					 if(hours<=DIVN_WORK_TIME_TO && minutes == 0){
						 DUE_DATE = addHoursToJavaUtilDate(taskAssignedDate, PWMU_ESC_DAYS);
						 
					 }else{
						int time = hours - DIVN_WORK_TIME_TO;
						while(time>=0){
						Date next_day = CommonUtils.addDaysToDate(taskAssignedDate, 1);
					    String next_day1 =  CommonUtils.dateToStringFormatter(next_day);
					    String C3=   " SELECT COUNT(PWHM_DATE) COUNT_NUM"
					    		 + " FROM PGIM_WF_HOLIDAY_MASTER"
					    		 + " WHERE PWHM_DATE = TO_DATE('"+next_day1+"', 'DD/MM/RRRR')"
					             + " AND PWHM_USER_GRP ="
					             + " DECODE(PWHM_USER_GRP,'ALL','ALL',"
					             + " LTRIM(RTRIM(REPLACE('"+USER_GROUP_ID +"', '''', NULL))))"
					             + " AND PWHM_BRANCH_CODE = '"+USER_BRANCH +"'";
							rs3 = handler.executeSelectStatement(C3, con);
							
							while(rs3.next()){
								holiday = rs3.getInt("COUNT_NUM");
								if(holiday==0){
									next_day=removeTime(next_day,DIVN_WORK_TIME_FROM,minutes);
									System.out.println("next_day*****************"+next_day );
									DUE_DATE = addHoursToJavaUtilDate(next_day, time);
									time = -1;
								}else{
									taskAssignedDate = next_day;
								}
								
							}
						 
					   }
				
					 }
				}
						
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DUE_DATE;	
					
	}
	
	public Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	
	public static Date removeTime(Date date,int DIVN_WORK_TIME_FROM,int min) {    
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, DIVN_WORK_TIME_FROM);  
        cal.set(Calendar.MINUTE, min);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime(); 
    }
	
	
	/*end*/

}

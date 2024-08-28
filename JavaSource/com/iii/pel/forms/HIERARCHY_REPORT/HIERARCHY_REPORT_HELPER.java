package com.iii.pel.forms.HIERARCHY_REPORT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.common.workflow.PGIM_WORKFLOW_BUCKET;
import com.iii.premia.common.utils.CommonUtils;
/* Added by kavitha for RoadMap*/
public class HIERARCHY_REPORT_HELPER {

	public List<PGIM_WORKFLOW_BUCKET> getTaskBucket() throws Exception {
		List<PGIM_WORKFLOW_BUCKET> headerList = new ArrayList<PGIM_WORKFLOW_BUCKET>();
		String query = null;
		String query1 = null;
		String query2 = null;
		String userId = null;
		Connection con = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		List<String> userList = new ArrayList<>();
		CRUDHandler handler = new CRUDHandler();
		try{
			con = CommonUtils.getConnection();
			userId = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			query = "SELECT * FROM MENU_USER_REPT_HIER WHERE RH_REPORT_TO=? AND (TRUNC(SYSDATE) BETWEEN RH_EFF_DT_FM AND RH_EFF_DT_TO)";
			query1 = "SELECT HDR.PWTH_USER_ID,WB.PWB_DESC,"
					/*+ "HDR.PWTH_DEPT_CODE,"*/
					+ "HDR.PWTH_PWB_CODE,Count(*) As TranCount, MRH.RH_REPORT_TO FROM PGIW_WF_TRAN_HDR HDR, PGIM_WORKFLOW_BUCKET WB,MENU_USER_REPT_HIER MRH WHERE WB.PWB_ENABLE_YN = '1' "
					+ "AND WB.PWB_MAIN_BUKT = HDR.PWTH_PROCESS_ID AND WB.PWB_CODE = HDR.PWTH_PWB_CODE AND NVL(WB.PWB_MAIL_ONLY_YN, '0') = '0' "
					+ "AND HDR.PWTH_USER_ID = ? AND RH_USER_ID = ? AND (TRUNC(SYSDATE) BETWEEN RH_EFF_DT_FM AND RH_EFF_DT_TO) "
					+ "GROUP BY HDR.PWTH_USER_ID,WB.PWB_DESC,"
					/*+ "HDR.PWTH_DEPT_CODE,"*/
					+ "HDR.PWTH_PWB_CODE,MRH.RH_REPORT_TO";
			rs = handler.executeSelectStatement(query, con,new Object[]{userId});
			while(rs.next()){
				rs1 = handler.executeSelectStatement(query1, con,new Object[]{rs.getString("RH_USER_ID"),rs.getString("RH_USER_ID")});
				
				System.out.println("   RH USER ID  FROM MENU USER REPORTING HIER TABLE     "+rs.getString("RH_USER_ID"));
				
				while(rs1.next()){
					PGIM_WORKFLOW_BUCKET tempBean = new PGIM_WORKFLOW_BUCKET();
					tempBean.setPWB_DESC(rs1.getString("PWB_DESC"));
					tempBean.setUSER_ID(rs1.getString("PWTH_USER_ID"));
					tempBean.setTransactionCount(rs1.getString("TranCount"));
					tempBean.setPWB_WORKSTEP_ID(rs1.getString("PWTH_PWB_CODE"));
					/*tempBean.setPWB_CODE(rs1.getString("PWTH_DEPT_CODE"));*/
					tempBean.setAssignedTo(rs1.getString("RH_REPORT_TO"));
					headerList.add(tempBean);
					//System.out.println("headerList      "+headerList);
					//System.out.println("Reporting to--------------------------->"+rs1.getString("RH_REPORT_TO"));
					
					
			    }
				if(!userList.contains(rs.getString("RH_USER_ID"))){
					userList.add(rs.getString("RH_USER_ID"));
					//System.out.println("Userlist---------------------------------------"+userList);
					rs2= handler.executeSelectStatement(query, con,new Object[]{rs.getString("RH_USER_ID")});
 					while(rs2.next()){
						if(!userId.equals(rs2.getString("RH_USER_ID"))){
							rs3=handler.executeSelectStatement(query1, con,new Object[]{rs2.getString("RH_USER_ID"),rs2.getString("RH_USER_ID")});
							while(rs3.next()){
								PGIM_WORKFLOW_BUCKET tempBean1 = new PGIM_WORKFLOW_BUCKET();
								tempBean1.setPWB_DESC(rs3.getString("PWB_DESC"));
								tempBean1.setUSER_ID(rs3.getString("PWTH_USER_ID"));
								tempBean1.setTransactionCount(rs3.getString("TranCount"));
								tempBean1.setPWB_WORKSTEP_ID(rs3.getString("PWTH_PWB_CODE"));
								/*tempBean1.setPWB_CODE(rs3.getString("PWTH_DEPT_CODE"));*/
								tempBean1.setAssignedTo(rs3.getString("RH_REPORT_TO"));
								headerList.add(tempBean1);	
								//System.out.println("Reporting to1--------------------------->"+rs3.getString("RH_REPORT_TO"));
							}
							
						}
						
						//System.out.println("headerList2      "+headerList);
					}
				}
				
				
			
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("headerList2      "+headerList.size());
		return headerList;
	}
	
	public boolean displayingMenu(){
		boolean display = false;
		Connection con = null;
		ResultSet rs = null;
		String query = null;
		CRUDHandler handler = null;
		try{
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			query = "SELECT * FROM MENU_USER_REPT_HIER WHERE RH_REPORT_TO=?";
			rs = handler.executeSelectStatement(query, con, new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
			if(rs.next()){
				display = true;	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return display;
	}
	
	/*public ArrayList<HIERARCHY_REPORT> pendingList(String PWB_WORKSTEP_ID,String userId,String deptCode,String sysId, HIERARCHY_REPORT HIERARCHY_REPORT_User){
		ArrayList<HIERARCHY_REPORT> pendingList = new ArrayList<HIERARCHY_REPORT>();
		ArrayList<String> userList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null;
		String query1 = null, query2 = null, query3 = null;
		//String sysId = null;
		CRUDHandler handler = null;
		int j = 0;
		List<String> s= null;
		try{
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			query1 = "SELECT PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT FROM "
					+ "( SELECT HDR.PWTH_SYS_ID, HDR.PWTH_ESC_LVL_DONE, HDR.PWTH_CR_UID, "
					+ "HDR.PWTH_CR_DT,DTLS.PWTD_RULE_ID,NVL(DTLS.PWTD_CHAR_VALUE,NVL(TO_CHAR(DTLS.PWTD_NUM_VALUE)"
					+ ",TO_CHAR(DTLS.PWTD_DATE_VALUE,'DD/MM/YYYY'))) AS FLDVALUE FROM PGIW_WF_TRAN_DTLS DTLS, "
					+ "PGIW_WF_TRAN_HDR HDR,MENU_USER_COMP_DIVN MUCD WHERE HDR.PWTH_SYS_ID = DTLS.PWTD_PWTH_SYS_ID AND "
					+ "HDR.PWTH_PWB_CODE = '"+PWB_WORKSTEP_ID+"' "
					+ "AND HDR.PWTH_DEPT_CODE = '"+deptCode+"'"
					+ " AND MUCD.MUCD_USER_ID = '"+userId+"' "
					+ "AND MUCD.MUCD_DEPT_CODE = HDR.PWTH_DEPT_CODE "
					+ "AND HDR.PWTH_USER_ID = MUCD.MUCD_USER_ID "
					+ "ORDER BY HDR.PWTH_SYS_ID ) D group by PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, "
					+ "PWTH_CR_DT ORDER BY PWTH_SYS_ID DESC";
			      System.out.println("Pending List               "+query1);
			rs1 = handler.executeSelectStatement(query1, con);
			query3 = "SELECT * FROM MENU_USER WHERE USER_GROUP_ID IN (SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID ='"+userId+"')";
			rs3 = handler.executeSelectStatement(query3, con);
			while(rs3.next()){
				userList.add(rs3.getString("USER_ID"));
				//System.out.println("USER List               "+userList);
			}
			if(userList != null && userList.size()>0){
				HIERARCHY_REPORT_User.setUsersList(userList);
			}
			Date user_Date = null;
			while(rs1.next()){
				j++;
				s = new ArrayList<>(); 
				HIERARCHY_REPORT HIERARCHY_REPORT_BEAN = new HIERARCHY_REPORT();
				HIERARCHY_REPORT_BEAN.setRowNo(j);
				sysId = rs1.getString("PWTH_SYS_ID");
				query2 = "select * from pgiw_wf_tran_dtls  where pwtd_pwth_sys_id='"+sysId+"'";
				rs2 = handler.executeSelectStatement(query2, con);
				while(rs2.next()){
					s.add(rs2.getString("pwtd_char_value"));
					user_Date = rs2.getTimestamp("PWTD_CR_DT");	
					
				}
				if("POIL".equals(PWB_WORKSTEP_ID) || "POIL1".equals(PWB_WORKSTEP_ID) || "POIL2".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(5));
				}
				if("POAIL".equals(PWB_WORKSTEP_ID)||"PAIL".equals(PWB_WORKSTEP_ID) || "PAIL1".equals(PWB_WORKSTEP_ID) || "PROEL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(0));
				}
				if("WDIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(3));
				}
				if("CSM_CAIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CDIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CTIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CMIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CSURIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CMATIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CCIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_WDIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CCLIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CLIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CBIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CRIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CRIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CADIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CGIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CEIL".equals(PWB_WORKSTEP_ID) || "CL02".equals(PWB_WORKSTEP_ID) || "CL03".equals(PWB_WORKSTEP_ID) || "CL04".equals(PWB_WORKSTEP_ID) || "CL05".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
					HIERARCHY_REPORT_BEAN.setClaimNumber(s.get(0));	
				}else if("PAILM".equals(PWB_WORKSTEP_ID) || "PAILMA".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				HIERARCHY_REPORT_BEAN.setUser(userId);
				HIERARCHY_REPORT_BEAN.setSysId(sysId);
				HIERARCHY_REPORT_BEAN.setTaskAssignedDate(user_Date);
				System.out.println("HIERARCHY_REPORT_BEAN.getTaskAssignedDate()        &&&&&&&&&&&&&&&"+HIERARCHY_REPORT_BEAN.getTaskAssignedDate());
				
				HIERARCHY_REPORT_BEAN.setTaskDueDate(getDueDate(PWB_WORKSTEP_ID,HIERARCHY_REPORT_BEAN.getTaskAssignedDate(),userId));
				
				pendingList.add(HIERARCHY_REPORT_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pendingList;
	}
	*/
	
	public ArrayList<HIERARCHY_REPORT> pendingList(String PWB_WORKSTEP_ID,String userId,String deptCode,String sysId, HIERARCHY_REPORT HIERARCHY_REPORT_User){
		ArrayList<HIERARCHY_REPORT> pendingList = new ArrayList<HIERARCHY_REPORT>();
		ArrayList<String> userList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null;
		String query1 = null, query2 = null, query3 = null;
		//String sysId = null;
		CRUDHandler handler = null;
		ResultSet result2 = null;
		String Main_bkt_code = null;
		int j = 0;
		List<String> s= null;
		try{
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			query1 = "SELECT PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, PWTH_CR_DT FROM "
					+ "( SELECT HDR.PWTH_SYS_ID, HDR.PWTH_ESC_LVL_DONE, HDR.PWTH_CR_UID, "
					+ "HDR.PWTH_CR_DT,DTLS.PWTD_RULE_ID,NVL(DTLS.PWTD_CHAR_VALUE,NVL(TO_CHAR(DTLS.PWTD_NUM_VALUE)"
					+ ",TO_CHAR(DTLS.PWTD_DATE_VALUE,'DD/MM/YYYY'))) AS FLDVALUE FROM PGIW_WF_TRAN_DTLS DTLS, "
					+ "PGIW_WF_TRAN_HDR HDR,MENU_USER_COMP_DIVN MUCD WHERE HDR.PWTH_SYS_ID = DTLS.PWTD_PWTH_SYS_ID AND "
					+ "HDR.PWTH_PWB_CODE = '"+PWB_WORKSTEP_ID+"' "
					/*+ "AND HDR.PWTH_DEPT_CODE = '"+deptCode+"'"*/
					+ " AND MUCD.MUCD_USER_ID = '"+userId+"' "
					/*+ "AND MUCD.MUCD_DEPT_CODE = HDR.PWTH_DEPT_CODE "*/
					+ "AND HDR.PWTH_USER_ID = MUCD.MUCD_USER_ID "
					+ "ORDER BY HDR.PWTH_SYS_ID ) D group by PWTH_SYS_ID, PWTH_ESC_LVL_DONE, PWTH_CR_UID, "
					+ "PWTH_CR_DT ORDER BY PWTH_SYS_ID DESC";
			      System.out.println("Pending List               "+query1);
			rs1 = handler.executeSelectStatement(query1, con);
			query3 = "SELECT * FROM MENU_USER WHERE USER_GROUP_ID IN (SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID ='"+userId+"')";
			rs3 = handler.executeSelectStatement(query3, con);
			while(rs3.next()){
				userList.add(rs3.getString("USER_ID"));
			}
			if(userList != null && userList.size()>0){
				HIERARCHY_REPORT_User.setUsersList(userList);
			}
			Date user_Date = null;
			
			String query_code = "SELECT * FROM PGIM_WORKFLOW_BUCKET WHERE PWB_CODE = '"+PWB_WORKSTEP_ID+"'";
			
			result2 = handler.executeSelectStatement(query_code.toString(),
					con);
			
			while (result2.next()) {
				 Main_bkt_code = result2.getString("PWB_MAIN_BUKT");	
			}
			
			while(rs1.next()){
				j++;
				s = new ArrayList<>(); 
				HIERARCHY_REPORT HIERARCHY_REPORT_BEAN = new HIERARCHY_REPORT();
				HIERARCHY_REPORT_BEAN.setRowNo(j);
				sysId = rs1.getString("PWTH_SYS_ID");
				query2 = "select * from pgiw_wf_tran_dtls  where pwtd_pwth_sys_id='"+sysId+"'";
				rs2 = handler.executeSelectStatement(query2, con);
				while(rs2.next()){
					s.add(rs2.getString("pwtd_char_value"));
					user_Date = rs2.getTimestamp("PWTD_CR_DT");	
					
				}
				
				
				if("UNDERWRITING".equalsIgnoreCase(Main_bkt_code)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(5));
				}
				
				if("FINANCE".equalsIgnoreCase(Main_bkt_code)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(5));
				}
				
				if("CIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(0));
				}
				if("WITHDRAWAL".equalsIgnoreCase(Main_bkt_code)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(3));
				}
				if("CSM_CAIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CDIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CTIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CMIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CSURIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CMATIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CCIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_WDIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CCLIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CLIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CBIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CRIIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CRIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CADIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CSM_CGIL".equals(PWB_WORKSTEP_ID)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
				}
				if("CLAIMS".equalsIgnoreCase(Main_bkt_code)){
					HIERARCHY_REPORT_BEAN.setPolicyNo(s.get(4));
					HIERARCHY_REPORT_BEAN.setClaimNumber(s.get(0));	
				}
				HIERARCHY_REPORT_BEAN.setUser(userId);
				HIERARCHY_REPORT_BEAN.setSysId(sysId);
				HIERARCHY_REPORT_BEAN.setTaskAssignedDate(user_Date);
				System.out.println("HIERARCHY_REPORT_BEAN.getTaskAssignedDate()        &&&&&&&&&&&&&&&"+HIERARCHY_REPORT_BEAN.getTaskAssignedDate());
				
				HIERARCHY_REPORT_BEAN.setTaskDueDate(getDueDate(PWB_WORKSTEP_ID,HIERARCHY_REPORT_BEAN.getTaskAssignedDate(),userId));
				
				pendingList.add(HIERARCHY_REPORT_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pendingList;
	}
	
	
	/*public Date getDueDate(String code,Date taskAssignedDate,String userId){
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
		String UI_M_TASK_DUE_DT= null;
		String UI_M_TASK_ASSIGNED_DT= null;
		int holiday = 0;
		List<Date> dateList = new ArrayList<>();
		int COUNT = 0;
		CRUDHandler handler = new CRUDHandler();
		try {
				String C1 = "SELECT PWMU_ESC_LIMIT,PWMU_ESC_LMT_TYP FROM PGIM_WF_MAIL_USGRP  WHERE PWMU_PWB_BUKT_CODE = ?";
				con = CommonUtils.getConnection();
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] {code});
				while (rs1.next()) {
					PWMU_ESC_DAYS = rs1.getInt("PWMU_ESC_LIMIT");
					PWMU_ESC_LMT_TYP = rs1.getString("PWMU_ESC_LMT_TYP");
					System.out.println("#########################################"+PWMU_ESC_DAYS);
					System.out.println("#########################################"+PWMU_ESC_LMT_TYP);
				}
				if(PWMU_ESC_LMT_TYP!=null && PWMU_ESC_LMT_TYP.equalsIgnoreCase("D")){
					
	
						String C2= "SELECT USER_GROUP_ID, MUCD_DIVN_CODE FROM MENU_USER, MENU_USER_COMP_DIVN WHERE USER_ID = MUCD_USER_ID AND USER_ID = '"+userId+"'";
						
						rs2 = handler.executeSelectStatement(C2, con);
						while(rs2.next()){
							USER_GROUP_ID = rs2.getString("USER_GROUP_ID");
							USER_BRANCH = rs2.getString("MUCD_DIVN_CODE");
							System.out.println("USER_GROUP_ID ********************              "+USER_GROUP_ID);
							System.out.println("USER_BRANCH ********************              "+USER_BRANCH);
						}
						
							UI_M_TASK_ASSIGNED_DT = CommonUtils.dateToStringFormatter(taskAssignedDate);
							DUE_DATE = CommonUtils.addDaysToDate(taskAssignedDate, PWMU_ESC_DAYS);
							UI_M_TASK_DUE_DT = CommonUtils.dateToStringFormatter(DUE_DATE);
							
							String C3=    " SELECT PWHM_DATE "
										+ " FROM PGIM_WF_HOLIDAY_MASTER"
										+ " WHERE PWHM_DATE BETWEEN '"+UI_M_TASK_ASSIGNED_DT+"' AND '"+UI_M_TASK_DUE_DT+"'"
										+ " AND PWHM_USER_GRP = LTRIM(RTRIM(REPLACE('''"+USER_GROUP_ID +"''', '''', NULL)))"
										+ " AND PWHM_BRANCH_CODE = '"+USER_BRANCH +"'";
							
							rs3 = handler.executeSelectStatement(C3, con);
							while(rs3.next()){
								dateList.add(rs3.getDate("PWHM_DATE"));
								System.out.println("Date list ********************              "+dateList);
								COUNT = 	dateList.size();
							}		
								while(COUNT!=0){
									Date date = CommonUtils.addDaysToDate(DUE_DATE, 1);
								    String date1 =  CommonUtils.dateToStringFormatter(date);
								 String C4=    " SELECT COUNT(PWHM_DATE) COUNT_NUM"
										+ " FROM PGIM_WF_HOLIDAY_MASTER"
										+ " WHERE PWHM_DATE = '"+date1+"'"
										+ " AND PWHM_USER_GRP = LTRIM(RTRIM(REPLACE('''"+USER_GROUP_ID +"''', '''', NULL)))"
										+ " AND PWHM_BRANCH_CODE = '"+USER_BRANCH +"'";
									rs4 = handler.executeSelectStatement(C4, con);
									
									while(rs4.next()){
										holiday = rs4.getInt("COUNT_NUM");
									}
									
									if(holiday!=0){
										COUNT = COUNT+0;
									}else{
										COUNT= COUNT-1;
										System.out.println("COUNT"+COUNT);
										DUE_DATE =  CommonUtils.addDaysToDate(DUE_DATE, 1);
									}
							}
							
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DUE_DATE;	
					
	}
	
	*/
	
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

}

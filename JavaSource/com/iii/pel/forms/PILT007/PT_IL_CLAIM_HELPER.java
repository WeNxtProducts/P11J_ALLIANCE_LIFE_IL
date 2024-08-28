package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_PRINT_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_HELPER {

	public void whenNewRecordInstance(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;

		PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction1 = compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();

		CRUDHandler handler = new CRUDHandler();
		Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		Long CP_SYS_ID_1 = claimPaidAction1.getPT_IL_CLAIM_PAID_1_BEAN().getCP_SYS_ID();
		Long CP_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();
		String query1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY1;
		String M_FLAG = null;
		String M_FLAG_1 = null;
		String M_DUMMY = null;
		ResultSet rst = null;
		ResultSet rs_FLAG = null;
		ResultSet rs_C1 = null;
		ResultSet rs_C2 = null;
		try {
			connection = CommonUtils.getConnection();
			if (CP_SYS_ID_1 == null && CLAIM_SYS_ID != null) {
				rst = handler.executeSelectStatement(query1, connection,
						new Object[] { CLAIM_SYS_ID });
				while (rst.next()) {
					CP_SYS_ID_1 = rst.getLong("CP_SYS_ID");
				}
				CP_SYS_ID = CP_SYS_ID_1;
			}
		

			String sql_FLAG = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY2;
			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY3;
			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY4;
			rs_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_SYS_ID, CP_SYS_ID });
			if (rs_C1.next()) {
				M_FLAG = rs_C1.getString(1);
			}

			rs_FLAG = handler.executeSelectStatement(sql_FLAG, connection,
					new Object[] { CLAIM_POL_SYS_ID });
			if (rs_FLAG.next()) {
				M_FLAG_1 = rs_FLAG.getString("POL_FAC_YN");
			}


			rs_C2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { CLAIM_SYS_ID, CP_SYS_ID_1 });
			if (rs_C2.next()) {
				M_DUMMY = rs_C2.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rst);
				 CommonUtils.closeCursor(rs_C1);
				 CommonUtils.closeCursor(rs_C2);
				 CommonUtils.closeCursor(rs_FLAG);
			} catch (Exception e) {}
		}
	}

	public void whenCreateRecord(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			String callingForm = (String) CommonUtils.getGlobalVariable("CALLING_FORM");
			if ("PILT006_APAC".equalsIgnoreCase(callingForm)) {
				PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
			
				 claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_POL_NO(
				(String) CommonUtils.getGlobalVariable("GLOBAL.M_CLAIM_POL_NO"));
				
				 claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_NO(
				 (String) CommonUtils.getGlobalVariable("GLOBAL.M_CLAIM_NO"));
				
				 claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_SYS_ID(
				(Long) CommonUtils.getGlobalObject("GLOBAL.CLAIM_SYS_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preQuery(PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception {
		try {
			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");;
			if (callingForm.equals("PILT006_APAC")) {
				PT_IL_CLAIM_BEAN.setCLAIM_NO((String)CommonUtils.getGlobalVariable("GLOBAL.M_CLAIM_NO"));
				PT_IL_CLAIM_BEAN.setCLAIM_POL_NO((String) CommonUtils.getGlobalVariable("GLOBAL.M_CLAIM_POL_NO"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	

	public void postQuery(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM claimBean = claimAction.getPT_IL_CLAIM_BEAN();
		Long CLAIM_POL_SYS_ID = claimBean.getCLAIM_POL_SYS_ID();
		Long CLAIM_SYS_ID = claimBean.getCLAIM_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs_C1 = null;
		ResultSet rs_C2 = null;
		ResultSet rs_C3 = null;
		String plan_code=null;
		Integer M_TEMP = 0;
		Integer M_EXISTS = -1;
		try {
			connection = CommonUtils.getConnection();
			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY5;
			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY6;
			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY7;
			rs_C1 = handler.executeSelectStatement(sql_C1, connection,new Object[]{CLAIM_POL_SYS_ID});
			if (rs_C1.next()) {
				claimBean.setUI_M_POL_PROD_CODE(rs_C1.getString("POL_PROD_CODE"));
				claimBean.setUI_M_POL_SA_CURR_CODE(rs_C1.getString("POL_SA_CURR_CODE"));
				plan_code=rs_C1.getString("POL_PLAN_CODE");
			}
			/*BELOW CODE IS COMMENDED BY GOPI FOR REPORT CONFIG ON 11/04/17*/
			/*Added by sankaraNarayanan on 16/02/2016 for print Button
			if("207".equals(plan_code)){
				claimAction.getCOMP_PRINT_COMMAND_LINK().setDisabled(false);
				claimAction.getCOMP_PRINT_BUTTON().setDisabled(false);
			}else{
				claimAction.getCOMP_PRINT_COMMAND_LINK().setDisabled(true);
				claimAction.getCOMP_PRINT_BUTTON().setDisabled(true);
			}
			end*/
			rs_C2 = handler.executeSelectStatement(sql_C2, connection,new Object[]{CLAIM_SYS_ID});
			if (rs_C2.next()) {
				M_TEMP = rs_C2.getInt(1);
			}
			if (M_TEMP > 0) {
				rs_C3 = handler.executeSelectStatement(sql_C3,connection,new Object[]{CLAIM_SYS_ID});
				if (rs_C3.next()) {
					M_EXISTS = rs_C3.getInt(1);
				}
			}
			L_FETCH_ASSURED_NAME(claimBean);
			new PILT007_PROCEDURE().P_VAL_SYSTEM(connection, "IL_PAY_TO",
					claimBean.getCLAIM_PAY_TO(), "N", compositeAction
							.getPILT007_DUMMY_ACTION().getDUMMY_BEAN()
							.getM_PS_VALUE());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rs_C1);
				 CommonUtils.closeCursor(rs_C2);
				 CommonUtils.closeCursor(rs_C3);
			} catch (Exception e) {}
		}
	}

	public void L_FETCH_ASSURED_NAME(PT_IL_CLAIM claimBean)throws Exception {
		try {
			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY8;
			ResultSet rs_C1 = null;
			rs_C1 = new CRUDHandler().executeSelectStatement(sql_C1, CommonUtils.getConnection(),
															new Object[]{claimBean.getCLAIM_POL_SYS_ID(), 
																		 claimBean.getCLAIM_ASSURED_CODE()});
			if (rs_C1.next()) {
				claimBean.setUI_M_CLAIM_ASSURED_NAME(rs_C1.getString("POAD_ASSURED_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		

	}

	
	public void onCheckDeleteMaster(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		String sql_PT_IL_CLAIM_PAID_CUR = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY9;
		String sql_PT_IL_CLAIM_PAID_1_CUR = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY10;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String DUMMY_DEFINE = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_PT_IL_CLAIM_PAID_CUR,
					connection, new Object[] { CLAIM_SYS_ID });
			while (rst.next()) {
				DUMMY_DEFINE = rst.getString(1);
			}
			if (DUMMY_DEFINE != null) {
			}

			rst1 = handler.executeSelectStatement(sql_PT_IL_CLAIM_PAID_1_CUR,
					connection, new Object[] { CLAIM_SYS_ID });
			while (rst.next()) {
				DUMMY_DEFINE = rst.getString(1);
			}
			if (DUMMY_DEFINE != null) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rst);
				 CommonUtils.closeCursor(rst1);
			} catch (Exception e) {}
		}
	}

	public List<PT_IL_CLAIM> claimNoList(Object event) throws Exception {
		String claimNumber = (String) event;
		if (claimNumber != null) {
			if (claimNumber.equals("*")) {
				claimNumber = "%";
			} else if (claimNumber.length() > 0) {
				claimNumber += "%";
			}
		}
		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY11;
		Object[] values = { claimNumber };
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM> claimNoList = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			claimNoList = new ArrayList<PT_IL_CLAIM>();
			PT_IL_CLAIM claimBean = null;
			while (rst.next()) {
				claimBean = new PT_IL_CLAIM();
				claimBean.setCLAIM_NO(rst.getString("CLAIM_NO"));
				claimBean.setCLAIM_LOSS_DT(rst.getDate(2));
				claimNoList.add(claimBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return claimNoList;
	}

	public List<PT_IL_CLAIM> claimPolNoList(Object event) throws Exception {
		String policyNumber = (String) event;
		if (policyNumber != null) {
			if (policyNumber.equals("*")) {
				policyNumber = "%";
			} else if (policyNumber.length() > 0) {
				policyNumber += "%";
			}
		}
		String claimNumber = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_QUERY12;
		Object[] values = { policyNumber, "2" };
		handler = new CRUDHandler();
		List<PT_IL_CLAIM> policyNoList = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			policyNoList = new ArrayList<PT_IL_CLAIM>();
			PT_IL_CLAIM claimBean = null;
			while (rst.next()) {
				claimBean = new PT_IL_CLAIM();
				claimBean.setCLAIM_POL_NO(rst.getString("CLAIM_POL_NO"));
				policyNoList.add(claimBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return policyNoList;
	}

	public void executeQuery(PT_IL_CLAIM claimBean) throws Exception {
		String selectQuery = "SELECT ROWID,PT_IL_CLAIM.* FROM PT_IL_CLAIM WHERE ROWID = ?";
		String selectQuery1 = "SELECT ROWID,PT_IL_CLAIM.* FROM PT_IL_CLAIM WHERE CLAIM_NO = ?  ";
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			if (claimBean.getROWID() == null) {
				 rst = handler.executeSelectStatement(selectQuery1,
						connection, new Object[]{claimBean.getCLAIM_NO()});
				
			}else {
				 rst = handler.executeSelectStatement(selectQuery,
						connection, new Object[]{claimBean.getROWID()});
			}
				
			while (rst.next()) {
				claimBean.setROWID(rst.getString("ROWID"));
				claimBean.setCLAIM_POL_NO(rst.getString("CLAIM_POL_NO"));
				claimBean.setCLAIM_NO(rst.getString("CLAIM_NO"));
				claimBean.setCLAIM_ASSURED_CODE(rst.getString("CLAIM_ASSR_CODE"));
				claimBean.setCLAIM_SYS_ID(rst.getLong("CLAIM_SYS_ID"));
				claimBean.setCLAIM_POL_SYS_ID(rst.getLong("CLAIM_POL_SYS_ID"));
				claimBean.setCLAIM_DS_CODE(rst.getString("CLAIM_DS_CODE"));
				claimBean.setCLAIM_POAD_SERIAL_NO(rst.getDouble("CLAIM_POAD_SERIAL_NO"));
				claimBean.setCLAIM_CURR_CODE(rst.getString("CLAIM_CURR_CODE"));
				claimBean.setCLAIM_EXCH_RATE(rst.getDouble("CLAIM_EXCH_RATE"));
				claimBean.setCLAIM_FRZ_FLAG(rst.getString("CLAIM_FRZ_FLAG"));
				claimBean.setCLAIM_CLOSE_FLAG(rst.getString("CLAIM_CLOSE_FLAG"));
				claimBean.setCLAIM_ADDL_STATUS(rst.getString("CLAIM_ADDL_STATUS"));
				
			}
			
			
			
			
			
			
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String claimPaid(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Connection connection = null;
		String queryString = PILT007_SQL_QUERY_CONSTANTS.PT_IL_CLAIM_ACTION_QUERY1;
		Long claimSysId = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		
		CRUDHandler handler = new CRUDHandler();
		int count_C1 = 0;
		ResultSet rst = null;
		ResultSet rst1 = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(queryString, connection,
					new Object[] { claimSysId });
			while (rst.next()) {
				count_C1 = rst.getInt(1);
			}

			queryString = PILT007_SQL_QUERY_CONSTANTS.PT_IL_CLAIM_ACTION_QUERY2;
			int count_C2 = 0;
			rst1 = handler.executeSelectStatement(queryString, connection,
					new Object[] { claimSysId });
			while (rst1.next()) {
				count_C2 = rst1.getInt(1);
			}

			if (count_C1 > 0) {
				if (count_C2 == 0) {
					compositeAction.getWizard().disableWizardItem("claimPaid");
					compositeAction.getWizard().enableWizardItem("claimPaid");
					compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().setBlockFlag(false);
					return "claimPaid";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rst);
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {}
		}
		return "claimToBePaid";
	}
	//Added by gopi for toi
	
		public String WHEN_BUTTON_PRESSED_M_BUT_OK(PILT007_PRINT_ACTION PILT007_PRINT_ACTION_BEAN) throws Exception
		{
			System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
			String url = null;
			String ScheduleReportType = null;
			
			ScheduleReportType = PILT007_PRINT_ACTION_BEAN.getScheduleReportType();
			
			System.out.println("ScheduleReportType in WHEN_BUTTON_PRESSED_M_BUT               :"+ScheduleReportType);
			
			/*added by gopi on 25/07/17*/
			String REPORT_CATG = null;
			String reportQuery1 = "select pmrth_report_catg from pm_rep_tab_hdr where pmrth_rep_id=?";
			ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{PILT007_PRINT_ACTION_BEAN.getUI_M_CLAIM_REPORT()});
			while(reportRSSS.next())
			{
				REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
			}
		
					
						if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
							ScheduleReportType = "1";	
						}else{
							ScheduleReportType = "2";
						}
					
			
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
			if(ScheduleReportType.equalsIgnoreCase("2"))   /*2-- Mdocs*/
			{
				url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
			}
			else
			{
				url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/PREMIASchedule?";
			}
			
			
			
			System.out.println("url   :  "+url);
		return url;	
		}
		
		//end
}

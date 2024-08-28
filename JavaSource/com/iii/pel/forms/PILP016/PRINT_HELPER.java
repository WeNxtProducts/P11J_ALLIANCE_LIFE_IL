package com.iii.pel.forms.PILP016;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_HELPER extends CommonReportAction {

	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	//String ScheduleReportType = resourceBundle.getString("ScheduleReportType");
	/*End*/
	
	public void when_new_from_instance(PRINT_ACTION PRINT_ACTION_BEAN)
			throws Exception {
		PRINT PRINT_BEAN = PRINT_ACTION_BEAN.getPRINT_BEAN();
		String M_POL_NO = null;
		String C1 = " SELECT POL_NO" + "     FROM PT_IL_POLICY"
				+ "     WHERE POL_SYS_ID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			PRINT_BEAN.setUI_M_SCHEDULE("P");
			PRINT_BEAN.setUI_M_OTHERS("N");
			PRINT_BEAN.setUI_M_OTH_TYPE("P");
			/*commented by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
			//PRINT_BEAN.setUI_M_POL_ENDT("P");
			//end
			PRINT_BEAN.setUI_M_PRINTYPE("O");
			PRINT_BEAN.setUI_M_PRINTYPE1("O");

			if ("P".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					PRINT_BEAN.setUI_M_POL_END_NO(resultSet.getString(1));
				}
				PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(true);
			} else if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	//ADDED by krithika on 29-04-2016 for policy schedule validation
	public void WHEN_REPORT_TYPE_VALUE_CHANGE(String firstlist,String secondlist,String POL_APPRV_STATUS,PRINT_ACTION PRINT_ACTION_BEAN) throws Exception
	{
		System.out.println("******************enter WHEN_REPORT_TYPE_VALUE_CHANGE  ********************");
		
		 System.out.println("value inside enter WHEN_REPORT_TYPE_VALUE_CHANGE  "+firstlist);
		
		System.out.println("value of validatorREPORT_TYPE list1"+firstlist);
		System.out.println("value of validatorREPORT_TYPE list2"+secondlist);
		//added by agalya for policy schedule subreport on 03-06-2016
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		String dsa_value=null;
		String pol_sys_is=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
		System.out.println("value of pol_sys_id in the helper"+pol_sys_is);
		connection = CommonUtils.getConnection();
		String query ="SELECT 'X' FROM PM_IL_PLAN WHERE PLAN_RED_SA_BASIS <> 'N'AND EXISTS (SELECT '1' FROM PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID = '"+pol_sys_is+"')";
		
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
	    if (resultSet!=null) {
	    	System.out.println("inside the resultset in print helper");
				dsa_value="X";
		}	
	    //end
			
		if((firstlist.equalsIgnoreCase("P"))&&(secondlist.equalsIgnoreCase("policy documents"))) 
		{
			callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("Endrosement"))&&(secondlist.equalsIgnoreCase("Revival report"))) )
		{
			callReportModalPanel();
		}
		
		else if(((firstlist.equalsIgnoreCase("Endrosement"))&&(secondlist.equalsIgnoreCase("Endorment slip"))) )
		{
          System.out.println("PRINT_ACTION_BEAN.getPRINT_BEAN().getList_vaue()          "+PRINT_ACTION_BEAN.getPRINT_BEAN().getList_vaue());
			
			/*Added By Ram on 01/10/2016 for Endorsement Slip Report issue*/
			if(PRINT_ACTION_BEAN.getPRINT_BEAN().getList_vaue() != null && PRINT_ACTION_BEAN.getPRINT_BEAN().getList_vaue().equals("0"))
			{
				System.out.println("No Endorsement");
				throw new Exception("Endorsement is not Applicable for this Endorsement Index");
			}
			/*End*/
			callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("Quotation"))&&(secondlist.equalsIgnoreCase("PAYMENT SLIP"))) )
		{
			callReportModalPanel();
		}
		
		else if(((firstlist.equalsIgnoreCase("Endrosement"))&&(secondlist.equalsIgnoreCase("PAYMENT SLIP"))&&(POL_APPRV_STATUS.equalsIgnoreCase("N"))))
		{
			callReportModalPanel();
				
		}
		else if(((firstlist.equalsIgnoreCase("P"))&&(secondlist.equalsIgnoreCase("PAYMENT SLIP"))&&(POL_APPRV_STATUS.equalsIgnoreCase("N"))))
		{
			System.out.println("inside the if condition in policy approval");
			callReportModalPanel();
	
		}
		else if(((firstlist.equalsIgnoreCase("Endrosement"))&&(secondlist.equalsIgnoreCase("General Endorment slip"))) )
		{
			callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("Quotation"))&&(secondlist.equalsIgnoreCase("Quotation review sheet"))) )
		{
			callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("P"))&&(secondlist.equalsIgnoreCase("Policy review sheet"))) )
		{
			callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("P"))&&(secondlist.equalsIgnoreCase("General Provision For Arabic"))))
		{
			callReportModalPanel();
		}
		//added by krithika for mortage product 
		else if(((firstlist.equalsIgnoreCase("Quotation"))&&(secondlist.equalsIgnoreCase("DSA Print"))))
		{
				callReportModalPanel();
		}
		//end
		
		else if(((firstlist.equalsIgnoreCase("P"))&&(secondlist.equalsIgnoreCase("DSA Print"))))
		{
				callReportModalPanel();
		}
		//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 
		else if(((firstlist.equalsIgnoreCase("Quotation"))&&(secondlist.equalsIgnoreCase("Quotation Letter"))))
		{
				callReportModalPanel();
		}
		else if(((firstlist.equalsIgnoreCase("Quotation"))&&(secondlist.equalsIgnoreCase("Acceptance Letter"))))
		{
				callReportModalPanel();
		}
		//END QUOTATION LETTER
		else
		{
			System.out.println("inside if condition");
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "77775",
					new Object[]{"Not a valid report"})));
			
		}
	}
	
	
	/*
	 * 	COmmented by Janani on 17.03.2017 for dynamic report config for base product
	 * 
	 * 
	 * 
	 * 
	 * public void WHEN_LIST_CHANGED_M_POL_ENDT(PRINT_ACTION PRINT_ACTION_BEAN)
			throws Exception {
		PRINT PRINT_BEAN = PRINT_ACTION_BEAN.getPRINT_BEAN();
		String C1 = " SELECT POL_NO" + "     FROM PT_IL_POLICY"
				+ "     WHERE POL_SYS_ID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("P".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					PRINT_BEAN.setUI_M_POL_END_NO(resultSet.getString(1));
				}
				PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(true);
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(true);
			} else if ("Endrosement".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				//PRINT_BEAN.setUI_M_POL_END_NO(null);
				//PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(false);
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(false);
				
			}else if("Quotation".equals(PRINT_BEAN.getUI_M_POL_ENDT()))
			{
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(true);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

*
*
*End
*
*
*
*/
	
	
	/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
	
	
/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	public void WHEN_LIST_CHANGED_M_POL_ENDT(PRINT_ACTION PRINT_ACTION_BEAN)
			throws Exception {
		
		System.out.println("ENTERS INTO WHEN_LIST_CHANGED_M_POL_ENDT");
		
		
		System.out.println("getUI_M_POL_END_NO in helper               :"+PRINT_ACTION_BEAN.getPRINT_BEAN().getUI_M_POL_END_NO());
		
		
		
		PRINT PRINT_BEAN = PRINT_ACTION_BEAN.getPRINT_BEAN();
		String C1 = " SELECT POL_NO" + "     FROM PT_IL_POLICY"
				+ "     WHERE POL_SYS_ID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			PRINT_ACTION_BEAN.getUI_M_POL_ENDT();
			
			System.out.println("getUI_M_POL_ENDT  in WHEN_LIST_CHANGED_M_POL_ENDT          "+PRINT_BEAN.getUI_M_POL_ENDT().toString());
			System.out.println("getUI_M_POL_ENDT          "+PRINT_ACTION_BEAN.getUI_M_POL_ENDT());
			
		/*	if(PRINT_ACTION_BEAN.getUI_M_POL_ENDT() != null)
			{*/
			
			if ("P".equals(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().toString())) {
				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					PRINT_BEAN.setUI_M_POL_END_NO(resultSet.getString(1));
				}
				PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(true);
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(true);
			} else if ("E".equals(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().toString())) {
				
				System.out.println("ENTERS INTO getUI_M_POL_ENDT IS E");
				//PRINT_BEAN.setUI_M_POL_END_NO(null);
				//PRINT_ACTION_BEAN.getCOMP_UI_M_POL_END_NO().setDisabled(false);
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(false);
				
			}else if("Q".equals(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().toString()))
			{
				PRINT_ACTION_BEAN.getCOMP_UI_M_ENLIST().setDisabled(true);

			}
			
	/*		}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
	
	/*end*/
	
	/*End*/
	
	
	public void WHEN_VALIDATE_ITEM_M_POL_END_NO(PRINT PRINT_BEAN)
			throws Exception {
		String M_DUMMY_X = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		/*query modified by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
		String C1 = " SELECT 'X'" + "	    FROM   PH_IL_POLICY"
				+ "	    WHERE  POLH_NO = ? ";
		//end
		try {
			connection = CommonUtils.getConnection();
			if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] { PRINT_BEAN.getUI_M_POL_END_NO() };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					M_DUMMY_X = resultSet.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91208"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public String WHEN_BUTTON_PRESSED_M_BUT_OK(PRINT_ACTION PRINT_ACTION_BEAN)
	
			throws Exception {
		Connection connection = null;
		ResultSet resultSet0 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		ResultSet resultSet8 = null;
		ResultSet resultSet9 = null;
		
		/*added by dhinesh*/
		
		ResultSet resultSet10= null;
		
		StringBuffer prod_code_url=null;
		StringBuffer PolSysId=null;
		String M_PROD_DESC=null;
		
		/*end*/
		Object[] values = null;
		PRINT PRINT_BEAN = PRINT_ACTION_BEAN.getPRINT_BEAN();
		CRUDHandler handler = new CRUDHandler();
		String C0 = " SELECT POL_END_CODE,POL_DS_CODE,POL_PROD_CODE,POL_DS_TYPE,POL_END_NO_IDX,POL_ADDL_STATUS "
				+ "     FROM   PT_IL_POLICY"
				+ "     WHERE  POL_SYS_ID= ?";
		String C1 = " SELECT PLSP_REPORT_ID "
				+ "	   FROM   PP_LIFE_POL_SCH_PRN"
				+ "	   WHERE  PLSP_MODULE_ID='IL'"
				+ "	   AND    PLSP_DS_TYPE  = ?"
				+ "	   AND    PLSP_DS_CODE  = ?"
				+ "	   AND    PLSP_PROD_CODE= ?"
				+ "	   AND    PLSP_TYPE     = 'S' AND PLSP_MODULE_NAME IS NULL";
		String C2="SELECT PLSP_REPORT_ID "+
			   "FROM   PP_LIFE_POL_SCH_PRN "+
			   "WHERE  PLSP_MODULE_ID='IL' "+
			   "AND    PLSP_DS_TYPE  = ? "+
			   "AND    PLSP_DS_CODE  = ? "+
			   "AND    PLSP_PROD_CODE= ? "+
			   "AND    PLSP_TYPE     = ? "+
			     "AND	PLSP_MODULE_NAME IS NULL";

		String C3 = " SELECT POLH_N_END_CODE,POLH_DS_CODE,POLH_N_PROD_CODE,POLH_DS_TYPE,NVL(POLH_END_NO_IDX,0)+1"
				+ "	    FROM   PH_IL_POLICY"
				+ "	    WHERE  POLH_SYS_ID    = ?"
				+ "	    AND    POLH_N_END_NO = ?";
		
		String C4 = "  SELECT PLSP_REPORT_ID"
				+ "	   FROM   PP_LIFE_POL_SCH_PRN"
				+ "	   WHERE  PLSP_MODULE_ID='IL'"
				+ "	   AND    PLSP_DS_TYPE  = ?"
				+ "	   AND    PLSP_DS_CODE  = NVL(?,?)"
				+ "	   AND    PLSP_PROD_CODE= ?"
				+ "	   AND    PLSP_TYPE     = 'S' AND PLSP_MODULE_NAME IS NULL";
		
		String C5="SELECT PLSP_REPORT_ID "+
				   "FROM   PP_LIFE_POL_SCH_PRN "+
				   "WHERE  PLSP_MODULE_ID='IL' "+
				   "AND    PLSP_DS_TYPE  = ? "+
				   "AND    PLSP_DS_CODE  = NVL(?,?) "+
				   "AND    PLSP_PROD_CODE= ? "+
				   "AND    PLSP_TYPE     = ? "+
				   "AND		PLSP_MODULE_NAME IS NULL";

		String C6 = " SELECT POL_END_CODE,POL_DS_CODE,POL_PROD_CODE,POL_DS_TYPE,POL_END_NO_IDX "+
				     "FROM   PT_IL_POLICY "+
				     "WHERE  POL_SYS_ID = ? "+
				     "AND    POL_DS_TYPE = 1 "+
				     "AND    POL_PROP_QUOT_FLAG = 'Q'";
		String C7="SELECT PLSP_REPORT_ID "+
				   "FROM   PP_LIFE_POL_SCH_PRN "+
				   "WHERE  PLSP_MODULE_ID='IL' "+
				   "AND    PLSP_DS_TYPE  = ? "+
				   "AND    PLSP_DS_CODE  = NVL(?,?) "+
				   "AND    PLSP_PROD_CODE= ? "+
				   "AND    PLSP_TYPE     = 'S' "+
				   "AND		PLSP_MODULE_NAME IS NULL";
		String C8="SELECT PLSP_REPORT_ID  "+
				   "FROM   PP_LIFE_POL_SCH_PRN "+
				   "WHERE  PLSP_MODULE_ID='IL' "+
				   "AND    PLSP_DS_TYPE  = ? "+
				   "AND    PLSP_DS_CODE  = NVL(?,?) "+
				   "AND    PLSP_PROD_CODE= M_POL_PROD_CODE "+
				   "AND    PLSP_TYPE     = ? "+
				   "AND		PLSP_MODULE_NAME IS NULL";
		String C9="SELECT PLSP_REPORT_ID "+
				   "FROM   PP_LIFE_POL_SCH_PRN "+
				   "WHERE  PLSP_MODULE_ID='IL'  "+
				   "AND    PLSP_DS_TYPE  = ? "+
				   "AND    PLSP_DS_CODE  = ? "+
				   "AND    PLSP_PROD_CODE= ? "+
				   "AND    PLSP_TYPE     = ? "+
				   "AND		PLSP_MODULE_NAME IS NULL";
		
		
		/*Added by Dhinesh 13.11.2015*/
		String C10="SELECT POL_PROD_CODE FROM PT_IL_POLICY "+
				   "WHERE POL_SYS_ID=?";
		/*end*/
		
		String PL_NAME = null;
		String M_VALUE = null;
		Integer M_PARAM_TYPE = null;
		String M_REC_STATUS = null;
		String M_MODULE_NAME = null;
		String M_PLSP_REPORT_ID_1 = null;

		String M_POL_END_CODE = null;
		String M_POL_DS_CODE = null;
		String M_POL_PROD_CODE = null;
		String M_POL_DS_TYPE = null;
		Integer M_POL_END_NO_IDX = null;
		Integer M_DPS_NO_OF_PRINT = null;
		Integer M_DPS_DUP_NO_OF_PRINT = null;
		String M_POL_ADDL_STATUS = null;
		Map<String, String> PL_ID = new HashMap<String, String>();
		int i = 0;
		int j = 0;
		String url = null;
		String moduleCode = CommonUtils
				.getGlobalVariable("GLOBAL.M_MODULE_CODE");
		try {
			connection = CommonUtils.getConnection();
			if ("P".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT()) 
					|| "PR".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
				resultSet0 = handler.executeSelectStatement(C0, connection,
						values);
				if (resultSet0.next()) {
					M_POL_END_CODE = resultSet0.getString(1);
					M_POL_DS_CODE = resultSet0.getString(2);
					M_POL_PROD_CODE = resultSet0.getString(3);
					M_POL_DS_TYPE = resultSet0.getString(4);
					M_POL_END_NO_IDX = resultSet0.getInt(5);
					M_POL_ADDL_STATUS = resultSet0.getString(6);
				}
			} else if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] {
						CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"),
						PRINT_BEAN.getUI_M_POL_END_NO() };
				resultSet3 = handler.executeSelectStatement(C3, connection,
						values);
				if (resultSet3.next()) {
					M_POL_END_CODE = resultSet3.getString(1);
					M_POL_DS_CODE = resultSet3.getString(2);
					M_POL_PROD_CODE = resultSet3.getString(3);
					M_POL_DS_TYPE = resultSet3.getString(4);
					M_POL_END_NO_IDX = resultSet3.getInt(1);
				}
			} else if ("Q".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
				resultSet0 = handler.executeSelectStatement(C0, connection,
						values);
				if (resultSet0.next()) {
					M_POL_END_CODE = resultSet0.getString(1);
					M_POL_DS_CODE = resultSet0.getString(2);
					M_POL_PROD_CODE = resultSet0.getString(3);
					M_POL_DS_TYPE = resultSet0.getString(4);
					M_POL_END_NO_IDX = resultSet0.getInt(5);
				}
			}
			if ("O".equals(PRINT_BEAN.getUI_M_SCHEDULE())) {
				//P9ILPK_POL_PRINT.PRINT_ONLINE(:GLOBAL.M_POL_SYS_ID);
			} else if ("B".equals(PRINT_BEAN.getUI_M_SCHEDULE())) {
				//P9ILPK_POL_PRINT.PRINT_BATCH(:GLOBAL.M_POL_SYS_ID);   	  
			} else if ("D".equals(PRINT_BEAN.getUI_M_SCHEDULE())
					|| "P".equals(PRINT_BEAN.getUI_M_SCHEDULE())) {
				if (!PL_ID.isEmpty()) {
					PL_ID.clear();
				}
				//PL_ID. CREATE_PARAMETER_LIST(PL_NAME);
				if (PL_ID.isEmpty()) {
					//RAISE FORM_TRIGGER_FAILURE;
				}
				PL_ID.put("P_POL_SYS_ID", CommonUtils
						.getGlobalVariable("GLOBAL.M_POL_SYS_ID"));
				PL_ID.put("P_USER_ID", CommonUtils.getControlBean()
						.getM_USER_ID());
				PL_ID.put("PARAMFORM", "NO");
				PL_ID.put("P_DEPT_CODE", CommonUtils.getControlBean()
						.getM_DEPT_CODE());
				PL_ID.put("P_DIVN_CODE", CommonUtils.getControlBean()
						.getM_DIVN_CODE());
				PL_ID.put("P_POL_END_NO_IDX", String
						.valueOf((M_POL_END_NO_IDX)));

				/*if("P".equalsIgnoreCase(PRINT_BEAN.getUI_M_SCHEDULE())){
				 PL_ID.put("DESTYPE","PREVIEW");	       	
				}else {
				   PL_ID.put("DESTYPE","PRINTER");
				}*/

				if ("P".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
					values = new Object[] { M_POL_DS_TYPE, M_POL_DS_CODE,
							M_POL_PROD_CODE };
					resultSet1 = handler.executeSelectStatement(C1, connection,
							values);
					if (resultSet1.next()) {
						M_PLSP_REPORT_ID_1 = resultSet1.getString(1);
					}
				} else if ("E".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
					values = new Object[] { M_POL_DS_TYPE, M_POL_END_CODE,
							M_POL_DS_CODE, M_POL_PROD_CODE };
					resultSet4 = handler.executeSelectStatement(C4, connection,
							values);
					if (resultSet4.next()) {
						M_PLSP_REPORT_ID_1 = resultSet4.getString(1);
					} 
				}else if ("Q".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
						values = new Object[] { M_POL_DS_TYPE, M_POL_END_CODE,
								M_POL_DS_CODE, M_POL_PROD_CODE };
						resultSet7 = handler.executeSelectStatement(C7,
								connection, values);
						if (resultSet7.next()) {
							M_PLSP_REPORT_ID_1 = resultSet7.getString(1);
						}
				}else if ("PR".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
					values = new Object[] { M_POL_DS_TYPE, M_POL_DS_CODE,
											M_POL_PROD_CODE,M_POL_ADDL_STATUS };
					resultSet9 = handler.executeSelectStatement(C9,
							connection, values);
					if (resultSet9.next()) {
						M_PLSP_REPORT_ID_1 = resultSet9.getString(1);
					}
			}
				
			}
			if (M_PLSP_REPORT_ID_1 != null) {
				PRINT_BEAN.setUI_M_PLSP_REPORT_ID(M_PLSP_REPORT_ID_1);
			}
			System.out.println("M_PLSP_REPORT_ID_1===================>"+M_PLSP_REPORT_ID_1);
			//RUN_PRODUCT(REPORTS,M_PLSP_REPORT_ID_1,SYNCHRONOUS,RUNTIME,FILESYSTEM,PL_ID,NULL);
			//
			url = ReportUtils.getReportRedirectString("", M_PLSP_REPORT_ID_1,
					"", REPORT_UTIL_CONSTANTS.reportPDFFormat, PL_ID);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> " + url);
			//
			if ("O".equalsIgnoreCase(PRINT_BEAN.getUI_M_PRINTYPE())) {
				String update_pp_gl_doc_print_setup = "  UPDATE PP_IL_DOC_PRINT_SETUP"
						+ "		       SET    DPS_NO_OF_PRINT =  NVL(DPS_NO_OF_PRINT,0)+1"
						+ "		       WHERE  DPS_POL_SYS_ID  = ? "
						+ "		       AND    DPS_END_NO_IDX  =  ? "
						+ "		       AND    DPS_DS_TYPE     =  ? "
						+ "		       AND    DPS_REPORT_ID   =  ? ";
				values = new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
						M_POL_END_NO_IDX, M_POL_DS_TYPE, M_PLSP_REPORT_ID_1 };
				i = handler.executeUpdateStatement(
						update_pp_gl_doc_print_setup, connection, values);
				System.out.println("Update Query=================i===>"+i);
				if (i == 0) {//SQL Not Found So insert the value in print set up table.
					String insert_pp_gl_doc_print_setup = " INSERT INTO PP_IL_DOC_PRINT_SETUP"
							+ " (DPS_DS_TYPE,"
							+ " DPS_DS_CODE,"
							+ " DPS_POL_SYS_ID,"
							+ " DPS_END_NO_IDX, DPS_REPORT_ID, DPS_NO_OF_PRINT,"
							+ " DPS_CR_DT,DPS_CR_UID,DPS_UPD_DT,DPS_UPD_UID,"
							+ " DPS_DUP_NO_OF_PRINT)"
							+ " VALUES  (?, ?, ?,"
							+ " ?, ?,1,?,?," + " NULL,NULL,NULL)";
					values = new Object[] {
							M_POL_DS_TYPE,
							M_POL_DS_CODE,
							CommonUtils
									.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
							M_POL_END_NO_IDX, M_PLSP_REPORT_ID_1,
							new CommonUtils().getCurrentDate(),
							CommonUtils.getControlBean().getM_USER_ID() };
					int insertDocPrint = handler.executeInsertStatement(
							insert_pp_gl_doc_print_setup, connection, values);
					System.out.println("Doc Print======>"+insertDocPrint);
					
				}
			}
			if ("D".equals(PRINT_BEAN.getUI_M_PRINTYPE())) {
				String update_pp_gl_doc_print_setup = " UPDATE PP_IL_DOC_PRINT_SETUP"
						+ "			       SET    DPS_DUP_NO_OF_PRINT =  NVL(DPS_DUP_NO_OF_PRINT,0)+1"
						+ "			       WHERE  DPS_POL_SYS_ID      = ?"
						+ "			       AND    DPS_END_NO_IDX      =  ?"
						+ "			       AND    DPS_DS_TYPE         =  ?"
						+ "			       AND    DPS_REPORT_ID       =  ?";
				values = new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
						M_POL_END_NO_IDX, M_POL_DS_TYPE, M_PLSP_REPORT_ID_1 };
				j = handler.executeUpdateStatement(
						update_pp_gl_doc_print_setup, connection, values);
				System.out.println("For Duplicate Print type=========>"+j);
				if (j == 0) {
					String insert_pp_gl_doc_print_setup = " INSERT INTO PP_IL_DOC_PRINT_SETUP"
							+ " (DPS_DS_TYPE, DPS_DS_CODE,DPS_POL_SYS_ID,DPS_END_NO_IDX,"
							+ " DPS_REPORT_ID, DPS_NO_OF_PRINT,DPS_CR_DT, DPS_CR_UID, DPS_UPD_DT,"
							+ " DPS_UPD_UID,DPS_DUP_NO_OF_PRINT)"
							+ " VALUES  (?, ?,?,"
							+ " ?,?,1,?,?,"
							+ "  NULL, NULL,NULL)";
					values = new Object[] {
							M_POL_DS_TYPE,
							M_POL_DS_CODE,
							CommonUtils
									.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
							M_POL_END_NO_IDX, M_PLSP_REPORT_ID_1,
							new CommonUtils().getCurrentDate(),
							CommonUtils.getControlBean().getM_USER_ID() };
					handler.executeInsertStatement(
							insert_pp_gl_doc_print_setup, connection, values);
				}
			}
			/*if(!PL_ID.isEmpty()){
			 PL_ID.clear(); 
			}*/
			if (j == 1) {
				connection.commit();
			}
			
			/*Added by dhinesh*/
			
			System.out.println("*******************************");
			System.out.println("M_POL_SYS_ID    : "+CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
			values = new Object[] { CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
			resultSet10 = handler.executeSelectStatement(C10, connection,
					values);
			if (resultSet10.next()) {
				M_POL_PROD_CODE = resultSet10.getString("POL_PROD_CODE");
				M_PROD_DESC = resultSet10.getString("PROD_DESC");
			}
			System.out.println("M_POL_PROD_CODE   : "+M_POL_PROD_CODE);
			System.out.println("M_PROD_DESC   : "+M_PROD_DESC);

			/*end*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet0);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
			}
			CommonUtils.getConnection().commit();
		}
		
	/*Added by dhinesh 13.11.2015*/
		String PolSys_Id=(String) CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID");
		System.out.println("Before append URL VALUE : "+url);
		prod_code_url=new StringBuffer(url);
		/*prod_code_url.append("&PROD_CODE="+M_POL_PROD_CODE);*/
		
		
		/*added by nathiya on 18.3.2016 for quotation letter*/
		
		prod_code_url.append("&PROD_CODE="+M_POL_PROD_CODE+"&Type="+PRINT_ACTION_BEAN.getPRINT_BEAN().getUI_M_POL_ENDT());
		
		
		/*end*/
		
		url=prod_code_url.toString();
		System.out.println("After append URL VALUE : "+url);
		
		/*end*/
		
		/*Added by Ramkumar on 13/04/2016 for TISB POC*/
		ResourceBundle flagBundle = ResourceBundle.getBundle("JasperReport"); 
		String delims=",";
		String REP_Name =null;
		if(M_POL_PROD_CODE!=null){

			System.out.println("call report servlet **********");
			
			Enumeration <String> keys = flagBundle.getKeys();
			while (keys.hasMoreElements()) {
				System.out.println("INSIDE WHILE LOOP");
				String key = keys.nextElement();
				System.out.println("key :"+key);
				String value = flagBundle.getString(key);
				System.out.println("value :"+value);
				StringTokenizer	 tokenizer=new StringTokenizer(value, delims);
				while (tokenizer.hasMoreElements()) {
					System.out.println("WHILE LOOP ");
					value=(String) tokenizer.nextElement()	;
					System.out.println("value :"+value);
					System.out.println("M_POL_PROD_CODE :"+M_POL_PROD_CODE);
					if(M_POL_PROD_CODE.equalsIgnoreCase(value)){
						if(REP_Name == null)
						{
						REP_Name=key;
						System.out.println("Report_name : "+REP_Name);
						break;
						}
					}else
					{
						System.out.println("***************** Product Code Value is not equal ");
					}
				}
			}
	}
		if(REP_Name == null)
		{
			throw new Exception("Report Schedule not Available for the Product "+M_PROD_DESC);
		}
		/*end*/
		
		PolSysId=new StringBuffer(url);
		PolSysId.append("&PolSysId="+PolSys_Id);
		url=PolSysId.toString();
		
		return url;
	}

	public void WHEN_BUTTON_PRESSED_M_BUT_OK_OTHER(
			PRINT_ACTION PRINT_ACTION_BEAN) throws Exception {
		PRINT PRINT_BEAN = PRINT_ACTION_BEAN.getPRINT_BEAN();
		Map<String, String> PL_ID_1 = new HashMap<String, String>();
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet2 = null;
		ResultSet resultSet5 = null;
		String M_PLSP_REPORT_ID_2 = null;
		Integer M_POL_END_NO_IDX = null;
		String M_POL_DS_TYPE = null;
		String M_POL_DS_CODE = null;
		String M_POL_PROD_CODE = null;
		String M_POL_END_CODE = null;
		int k = 0;
		int l = 0;
		String url = null;
		String C2 = " SELECT PLSP_REPORT_ID" + "	   FROM   PP_LIFE_POL_SCH_PRN"
				+ "	   WHERE  PLSP_MODULE_ID='GL'"
				+ "	   AND    PLSP_DS_TYPE  = ?"
				+ "	   AND    PLSP_DS_CODE  = ?"
				+ "	   AND    PLSP_PROD_CODE= ?"
				+ "	   AND    PLSP_TYPE     = ?";
		String C5 = " SELECT PLSP_REPORT_ID" + "	   FROM   PP_LIFE_POL_SCH_PRN"
				+ "	   WHERE  PLSP_MODULE_ID='GL'"
				+ "	   AND    PLSP_DS_TYPE  = ?"
				+ "	   AND    PLSP_DS_CODE  = NVL(?,?)"
				+ "	   AND    PLSP_PROD_CODE= ?"
				+ "	   AND    PLSP_TYPE     = ?";
		try {
			connection = CommonUtils.getConnection();
			if (!"N".equalsIgnoreCase(PRINT_BEAN.getUI_M_OTH_TYPE())) {
				if ("O".equals(PRINT_BEAN.getUI_M_OTH_TYPE())) {

				} else if ("B".equals(PRINT_BEAN.getUI_M_OTH_TYPE())) {
				} else if ("D".equalsIgnoreCase(PRINT_BEAN.getUI_M_OTH_TYPE())
						|| "P".equalsIgnoreCase(PRINT_BEAN.getUI_M_OTH_TYPE())) {
					if (!PL_ID_1.isEmpty()) {
						PL_ID_1.clear();
					}
					//PL_ID_1 := CREATE_PARAMETER_LIST(PL_NAME);
					if (PL_ID_1.isEmpty()) {
						// RAISE FORM_TRIGGER_FAILURE;
					}
					PL_ID_1.put("P_POL_SYS_ID", CommonUtils
							.getGlobalVariable("GLOBAL.M_POL_SYS_ID"));
					PL_ID_1.put("PARAMFORM", "NO");
					PL_ID_1.put("P_POL_END_NO_IDX", String
							.valueOf(M_POL_END_NO_IDX));
					PL_ID_1.put("P_USER_ID", CommonUtils.getControlBean()
							.getM_USER_ID());

					/*if("P".equals(PRINT_BEAN.getUI_M_SCHEDULE())){
					   PL_ID_1.put("DESTYPE","PREVIEW");	       	
					}else {
					   PL_ID_1.put("DESTYPE","PRINTER");
					}*/
					if ("P".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {
						values = new Object[] { M_POL_DS_TYPE, M_POL_DS_CODE,
								M_POL_PROD_CODE, PRINT_BEAN.getUI_M_OTHERS() };
						resultSet2 = handler.executeSelectStatement(C2,
								connection, values);
						if (resultSet2.next()) {
							M_PLSP_REPORT_ID_2 = resultSet2.getString(1);
						}
					} else if ("E".equalsIgnoreCase(PRINT_BEAN
							.getUI_M_POL_ENDT())) {
						values = new Object[] { M_POL_DS_TYPE, M_POL_END_CODE,
								M_POL_DS_CODE, M_POL_PROD_CODE,
								PRINT_BEAN.getUI_M_OTHERS() };
						resultSet5 = handler.executeSelectStatement(C5,
								connection, values);
						if (resultSet5.next()) {
							M_PLSP_REPORT_ID_2 = resultSet5.getString(1);
						}
					}

					url = ReportUtils.getReportRedirectString("",
							M_PLSP_REPORT_ID_2, "",
							REPORT_UTIL_CONSTANTS.reportPDFFormat, PL_ID_1);

					if ("O".equalsIgnoreCase(PRINT_BEAN.getUI_M_PRINTYPE())) {
						String update_pp_gl_doc_print_setup = " UPDATE PP_IL_DOC_PRINT_SETUP"
								+ "					       SET    DPS_NO_OF_PRINT =  NVL(DPS_NO_OF_PRINT,0)+1"
								+ "					       WHERE  DPS_POL_SYS_ID  = ? "
								+ "					       AND    DPS_END_NO_IDX  =  ?"
								+ "					       AND    DPS_DS_TYPE     =  ?"
								+ "					       AND    DPS_REPORT_ID   =  ?";
						values = new Object[] {
								CommonUtils
										.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
								M_POL_END_NO_IDX, M_POL_DS_TYPE,
								PRINT_BEAN.getUI_M_PLSP_REPORT_ID() };
						k = handler.executeUpdateStatement(
								update_pp_gl_doc_print_setup, connection,
								values);
						if (k == 0) {
							String insert_pp_gl_doc_print_setup = " INSERT INTO PP_IL_DOC_PRINT_SETUP"
									+ " (DPS_DS_TYPE, DPS_DS_CODE, DPS_POL_SYS_ID,DPS_END_NO_IDX,"
									+ " DPS_REPORT_ID, DPS_NO_OF_PRINT, DPS_CR_DT, DPS_CR_UID,DPS_UPD_DT,"
									+ " DPS_UPD_UID,DPS_DUP_NO_OF_PRINT)"
									+ " VALUES  (?, ?,?,"
									+ "  ?, ?,1, ?,?,"
									+ "  NULL, NULL, NULL)";
							values = new Object[] {
									M_POL_DS_TYPE,
									M_POL_DS_CODE,
									CommonUtils
											.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
									M_POL_END_NO_IDX,
									PRINT_BEAN.getUI_M_PLSP_REPORT_ID(),
									new CommonUtils().getCurrentDate(),
									CommonUtils.getControlBean().getM_USER_ID() };
							handler.executeInsertStatement(
									insert_pp_gl_doc_print_setup, connection,
									values);
						}
					}
					if ("D".equals(PRINT_BEAN.getUI_M_PRINTYPE())) {
						String update_pp_gl_doc_print_setup = " UPDATE PP_IL_DOC_PRINT_SETUP"
								+ " SET    DPS_DUP_NO_OF_PRINT =  NVL(DPS_DUP_NO_OF_PRINT,0)+1"
								+ " WHERE  DPS_POL_SYS_ID      = ?"
								+ " AND    DPS_END_NO_IDX      =  ?"
								+ " AND    DPS_DS_TYPE         =  ?"
								+ " AND    DPS_REPORT_ID       =  ?";
						values = new Object[] {
								CommonUtils
										.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
								M_POL_END_NO_IDX, M_POL_DS_TYPE,
								M_PLSP_REPORT_ID_2 };
						l = handler.executeUpdateStatement(
								update_pp_gl_doc_print_setup, connection,
								values);
						if (l == 0) {
							String insert_pp_gl_doc_print_setup = " INSERT INTO PP_GL_DOC_PRINT_SETUP"
									+ "(DPS_DS_TYPE,DPS_DS_CODE,DPS_POL_SYS_ID,"
									+ " DPS_END_NO_IDX,DPS_REPORT_ID, DPS_NO_OF_PRINT,"
									+ " DPS_CR_DT, DPS_CR_UID,DPS_UPD_DT,DPS_UPD_UID,DPS_DUP_NO_OF_PRINT)"
									+ " VALUES  (?, ?, ?, "
									+ " ?, ?, 1, ?,?,"
									+ " NULL, NULL, NULL)";
							values = new Object[] {
									M_POL_DS_TYPE,
									M_POL_DS_CODE,
									CommonUtils
											.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
									M_POL_END_NO_IDX, M_PLSP_REPORT_ID_2,
									new CommonUtils().getCurrentDate(),
									CommonUtils.getControlBean().getM_USER_ID() };
							handler.executeInsertStatement(
									insert_pp_gl_doc_print_setup, connection,
									values);
						}
					}
					/*if (!PL_ID_1.isEmpty()) {
						PL_ID_1.clear();
					}*/
				}
			}
			if(l==1 || k == 1){
			connection.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}
		}
	}
	
	
/*
 * 	Commented by Janani on 17.03.2017 for dynamic report config for base product
 * 
 * 
 * 
 * 	//added by krithika on 25-03-2016
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
			
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url = request.getContextPath() + "/ReportServlet?";
		System.out.println("url   :  "+url);
	return url;	
	}
	//end
*/	
	/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
	
	public String WHEN_BUTTON_PRESSED_M_BUT(PRINT_ACTION PRINT_ACTION_BEAN) throws Exception
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
		String ScheduleReportType = null;
		
		ScheduleReportType = PRINT_ACTION_BEAN.getScheduleReportType();
		
		System.out.println("ScheduleReportType in WHEN_BUTTON_PRESSED_M_BUT               :"+ScheduleReportType);
		
		/*added by gopi on 25/07/17*/
		String REPORT_CATG = null;
		String reportQuery1 = "select pmrth_report_catg from pm_rep_tab_hdr where pmrth_rep_id=?";
		ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{PRINT_ACTION_BEAN.getUI_REPORT_TYPE()});
		while(reportRSSS.next())
		{
			REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
		}
		
		if(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("E"))
		{
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("SE")){
				ScheduleReportType = "2";
			}else{
			ScheduleReportType = "1";
			}
		}	
		//added by gopi for mapping quotation letter on 07/02/18
				if(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("P"))
				{
					if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
						ScheduleReportType = "1";	
					}
				}else if(PRINT_ACTION_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("Q")){
					if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
						ScheduleReportType = "1";	
					}else{
						ScheduleReportType = "2";
					}
				}	
				//END
		
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
	
	
	/*End*/
	
	public String WHEN_BUTTON_PRESSED_DOC_REPORT()
	{
			System.out.println("******* Enter the print helper  when button pressed for doc report ******** ");
			String url = null;
				
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			System.out.println("request.getServerName()   : "+request.getServerName());
			System.out.println("request.getServerPort()   : "+request.getServerPort());
		//	url = "http://"+request.getServerName()+request.getServerPort()+"/XDocSchedule?";
			/*url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";*/
			
			url = request.getContextPath() + "/ReportServlet?";
			
			System.out.println("url   :  "+url);
	return url;	
	}
	
	
}

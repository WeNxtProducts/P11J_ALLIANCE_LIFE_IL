package com.iii.pel.forms.PILP075;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_CANC_REFN_HELPER 
{

	
	
	public void ExecuteQuery(PILP075_COMPOSITE_ACTION composite )//Additional Cover
			throws Exception {

System.out.println("Enter  ExecuteQuery");
PT_IL_POL_CANC_REFN_ACTION PT_IL_POL_CANC_REFN_ACTION_BEAN = composite.getPT_IL_POL_CANC_REFN_ACTION_BEAN();
		
		Connection connection = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		
		/*String selectStatement1 = "SELECT PROD_DESC, POL_ISSUE_DT, POL_CONT_CODE, POL_LC_SUM_ASSURED, POL_FC_SUM_ASSURED,POL_LC_FIRST_PREM, POL_PERIOD,POL_START_DT"+
								  " FROM PT_IL_POLICY, PM_IL_PRODUCT WHERE PROD_CODE = POL_PROD_CODE AND POL_NO = ? ";*/
		
		/*Modified by Ram on 27/11/2016 for Commencement Date issue*/
		String selectStatement1 = "SELECT PROD_DESC, POL_ISSUE_DT, POL_CONT_CODE, POL_LC_SUM_ASSURED, POL_FC_SUM_ASSURED,POL_LC_FIRST_PREM, POL_PERIOD,POL_START_DT"+
				  " FROM PT_IL_POLICY, PM_IL_PRODUCT WHERE PROD_CODE = POL_PROD_CODE AND POL_NO = ? ";
				  /*End*/
		
		String selectStatement2 = "SELECT POC_LC_VALUE  POL_FEE FROM PT_IL_POL_CHARGE, PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID"+
								  "	AND POL_NO = ?	AND POC_CHRG_CODE = 'POL-FEE' ";
		String selectStatement3 ="SELECT POC_LC_VALUE GOV_FEE  FROM PT_IL_POL_CHARGE, PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID"+
				  				 " AND POL_NO = ?	AND POC_CHRG_CODE = 'GOV.FEE' ";
		System.out.println("PCF_POL_NO()   : "+PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO());
		
		String selectStatement4 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		
		String selectStatement5="SELECT SUM(ACV_LC_VALUE) ACV_LC_VALUE  FROM PT_AGENT_COMM_VALUES, PT_IL_PREM_COLL  WHERE ACV_POL_SYS_ID = PC_POL_SYS_ID	  AND ACV_PC_SYS_ID = PC_SYS_ID"
							+ "  AND PC_PREM_TYPE = 'N'	  AND PC_POL_SYS_ID = ?	  AND ACV_COMM_TYPE = 'B'";
		  
		String policyCheckQuery = "SELECT COUNT(*) FROM PT_IL_POLICY WHERE POL_MODE_OF_PYMT = 'S' AND POL_DS_TYPE = '2' AND POL_NO = ?";
		int policyCheckCount = 0;
		try {
			connection = CommonUtils.getConnection();
			
			ResultSet policyCheckRS = new CRUDHandler().executeSelectStatement(policyCheckQuery, connection,
					new Object[]{PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO()});
			while(policyCheckRS.next())
			{
				policyCheckCount = policyCheckRS.getInt(1);
			}
			if(policyCheckCount == 0)
			{
				throw new Exception("Invalid Policy");
			}
			
			rs1 = new CRUDHandler().executeSelectStatement(
					selectStatement1, connection, new Object[] {PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO()});
			
			PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN = PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN();
			while (rs1.next())
			{
				//PT_IL_POL_CANC_REFN_BEAN = new PT_IL_POL_CANC_REFN();
				
				PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_07(rs1.getString("PROD_DESC"));
				/*Modified by Ram on 27/11/2016 for Commencement Date issue
				 * 
				 * PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_ISSUE_DT(rs1.getDate("POL_ISSUE_DT"));*/
				System.out.println("POL_START_DT        "+rs1.getDate("POL_START_DT"));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_ISSUE_DT(rs1.getDate("POL_START_DT"));
				
				/*End*/
				
				PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_CONT_CODE(rs1.getString("POL_CONT_CODE"));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_12(rs1.getString("POL_LC_SUM_ASSURED"));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_08(rs1.getString("POL_FC_SUM_ASSURED"));
				
				/*Changed by Ram on 27/11/2016 for Display values in 3 Decimal Parts
				 * 
				 * PT_IL_POL_CANC_REFN_BEAN.setPCF_PAID_PREM_LC(rs1.getDouble("POL_LC_FIRST_PREM"));
				  */
				PT_IL_POL_CANC_REFN_BEAN.setPCF_PAID_PREM_LC(rs1.getString("POL_LC_FIRST_PREM"));
				/*End*/
				
				PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_09(rs1.getString("POL_PERIOD"));

			}
			
			rs2 = new CRUDHandler().executeSelectStatement(
					selectStatement2, connection, new Object[] {PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO()});

			while (rs2.next())
			{
				System.out.println(" PolFee    :  "+rs2.getDouble("POL_FEE"));
				
				/*Changed by Ram on 27/11/2016 for Display values in 3 Decimal Parts
				 * 
				 * PT_IL_POL_CANC_REFN_BEAN.setPCF_DOC_FEE_LC(rs2.getDouble("POL_FEE"));
				 * */
				PT_IL_POL_CANC_REFN_BEAN.setPCF_DOC_FEE_LC(rs2.getString("POL_FEE"));
				/*End*/
				
				System.out.println("PCF_DOC_FEE_LC   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_DOC_FEE_LC());
			}
			
			rs3 = new CRUDHandler().executeSelectStatement(
					selectStatement3, connection, new Object[] {PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO()});
			
			while (rs3.next())
			{
				System.out.println(" PolFee    :  "+rs3.getDouble("GOV_FEE"));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_MED_FEE_LC(rs3.getDouble("GOV_FEE"));
				System.out.println("PCF_DOC_FEE_LC   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_DOC_FEE_LC());
			}
			
			rs4 = new CRUDHandler().executeSelectStatement(
					selectStatement4, connection, new Object[] {PT_IL_POL_CANC_REFN_ACTION_BEAN.getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO()});

			while (rs4.next())
			{
				CommonUtils.setGlobalVariable("GLOBAL:CAN_POL_SYS_ID", rs4.getString("POL_SYS_ID"));
			
				PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_SYS_ID(rs4.getInt("POL_SYS_ID"));
			
			}
			
			rs5 = new CRUDHandler().executeSelectStatement(
					selectStatement5, connection, new Object[] {PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()});

			while (rs5.next())
			{
			
				PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_11(rs5.getDouble("ACV_LC_VALUE"));
			
			}
			
			
			
			
			System.out.println("PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC  :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_MEI_REF_FC());
			
			
			composite.getPT_IL_POL_CANC_REFN_ACTION_BEAN().setPT_IL_POL_CANC_REFN_BEAN(PT_IL_POL_CANC_REFN_BEAN);
			//PT_IL_POL_CANC_REFN_ACTION_BEAN.setPT_IL_POL_CANC_REFN_BEAN(PT_IL_POL_CANC_REFN_BEAN);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			try {
				((CommonUtils) connection).closeCursor(rs1);
				((CommonUtils) connection).closeCursor(rs2);
				((CommonUtils) connection).closeCursor(rs3);
				
			} catch (Exception e) {
			}

	}
	
	}	
	
	
	public void validatepolicyNo(PT_IL_POL_CANC_REFN_ACTION action,PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN) throws Exception
	{

		try
		{
		String query = "SELECT count(*) FROM PT_IL_POL_CANC_REFN where PCF_POL_NO = ?";
		ResultSet rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_NO()});
		int policyCount = 0;
		while(rs.next())
		{
			policyCount = rs.getInt(1);
		}
		
		if(policyCount > 0)
		{
		 

			action.getCOMP_PCF_FLEX_11().resetValue();
			action.getCOMP_PCF_COMM_LC_RFND().resetValue();
			action.getCOMP_PCF_MEI_REF_FC().resetValue();
			 
			throw new Exception("Record already Exists");
		} 
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

	}
	
	/*Added by Dhinesh on 27/11/2016 for repotr Configuration*/
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
			
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		/*url = request.getContextPath() + "/ReportServlet?";*/
		url = request.getContextPath() + "/PREMIASchedule?";
		System.out.println("url   :  "+url);
	return url;	
	}
	/*End*/
}

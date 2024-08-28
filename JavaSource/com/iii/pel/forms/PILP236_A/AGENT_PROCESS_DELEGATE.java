package com.iii.pel.forms.PILP236_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class AGENT_PROCESS_DELEGATE {

	
	public List agentFromAction(String code, List CodeList)throws Exception {
		String query;
		try{
		if ("*".equalsIgnoreCase(code)) {
			query="SELECT CUST_CODE "+
                  " FROM   PM_CUSTOMER"+
                  " WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009'))"+
                  " AND NVL(CUST_FRZ_FLAG,'N') = 'N'"+
                  " AND NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= SYSDATE"+
                  " AND NVL(CUST_STATUS,'A')= 'A'";
			/*query = " SELECT CUST_CODE FROM PM_CUSTOMER "
					+ " WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002')"
					+ " ORDER BY 1ASC";*/

			CodeList = agentFromLOV(query);
		} else {
			query="SELECT CUST_CODE "+
            " FROM   PM_CUSTOMER"+
            " WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009'))"+
            " AND NVL(CUST_FRZ_FLAG,'N') = 'N'"+
            " AND NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= SYSDATE"+
            " AND NVL(CUST_STATUS,'A')= 'A'"+
            " AND UPPER(CUST_CODE) LIKE '" + code.toUpperCase()
			+ "%'" + " ORDER BY 1ASC";
			/*query = " SELECT CUST_CODE FROM PM_CUSTOMER "
					+ " WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002')"
					+ " AND UPPER(CUST_CODE) LIKE '" + code.toUpperCase()
					+ "%'" + " ORDER BY 1ASC";*/
			CodeList = agentFromLOV(query);

		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return CodeList;
	}
	
	public List<AGENT_PROCESS> agentFromLOV(String query) {
		List<AGENT_PROCESS> codeList = new ArrayList<AGENT_PROCESS>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				AGENT_PROCESS AGENT_PROCESS = new AGENT_PROCESS();
				AGENT_PROCESS.setUI_M_AGT_FM(resultSet.getString(1));
				codeList.add(AGENT_PROCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
//				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}
	
	public List agentToAction(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {

			query="SELECT CUST_CODE "+
            " FROM   PM_CUSTOMER"+
            " WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009'))"+
            " AND NVL(CUST_FRZ_FLAG,'N') = 'N'"+
            " AND NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= SYSDATE"+
            " AND NVL(CUST_STATUS,'A')= 'A'";
		

			CodeList = agentToLOV(query);
		} else {

			query="SELECT CUST_CODE "+
            " FROM   PM_CUSTOMER"+
            " WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009'))"+
            " AND NVL(CUST_FRZ_FLAG,'N') = 'N'"+
            " AND NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= SYSDATE"+
            " AND NVL(CUST_STATUS,'A')= 'A'"+
            " AND UPPER(CUST_CODE) LIKE '" + code.toUpperCase()
			+ "%'" + " ORDER BY 1ASC";
		
			CodeList = agentToLOV(query);

		}

		return CodeList;
	}
	
	public List<AGENT_PROCESS> agentToLOV(String query) {
		List<AGENT_PROCESS> codeList = new ArrayList<AGENT_PROCESS>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				AGENT_PROCESS AGENT_PROCESS = new AGENT_PROCESS();
				AGENT_PROCESS.setUI_M_AGT_TO(resultSet.getString(1));
				codeList.add(AGENT_PROCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}
	
	
	
	public List conBenFromAction(String code, List CodeList,AGENT_PROCESS agent_process) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
        if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("F")){
        	
        	query ="SELECT ABH_BNF_CODE FROM PM_AGENT_BENEFIT_HDR";
        	CodeList = conBenFromLOV(query);
        }
        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")){
        	
        	 query="SELECT ABS_CODE FROM PM_AGENT_BONUS_SETUP";
        	CodeList = conBenFromLOV(query);
        }
        
        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("C")){
        	
        	 query="SELECT ACH_CODE FROM PM_AGENT_CONTEST_HDR";
        	CodeList = conBenFromLOV(query);
        }
			
		
			
		} 
		
		else{
			 if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("F")){
				 query = "SELECT ABH_BNF_CODE FROM PM_AGENT_BENEFIT_HDR"
						+ " WHERE UPPER(ABH_BNF_CODE) LIKE '"+ code.toUpperCase()+ "%'" +
						  " ORDER BY 1ASC";
		        	
		        	CodeList = conBenFromLOV(query);
		        }
		        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")){
		        	
		        	 query="SELECT ABS_CODE FROM PM_AGENT_BONUS_SETUP "+
		        	       " WHERE UPPER(ABS_CODE) LIKE '"+code.toUpperCase()+"%'"+
		        	       " ORDER BY 1ASC";
		        	CodeList = conBenFromLOV(query);
		        }
		        
		        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("C")){
		        	
		        	 query="SELECT ACH_CODE FROM PM_AGENT_CONTEST_HDR"+
		        	       " WHERE UPPER(ACH_CODE) LIKE '"+code.toUpperCase()+"%'"+
		        	       " ORDER BY 1ASC";
		        	CodeList = conBenFromLOV(query);
		        }
			
			
		}

		return CodeList;
	}
	
	public List<AGENT_PROCESS> conBenFromLOV(String query) {
		List<AGENT_PROCESS> codeList = new ArrayList<AGENT_PROCESS>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				AGENT_PROCESS AGENT_PROCESS = new AGENT_PROCESS();
				AGENT_PROCESS.setUI_M_BEN_CON_FROM(resultSet.getString(1));
				codeList.add(AGENT_PROCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}
	
	
	public List conBenToAction(String code, List CodeList,AGENT_PROCESS agent_process) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
        if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("F")){
        	
        	query ="SELECT ABH_BNF_CODE FROM PM_AGENT_BENEFIT_HDR";
        	CodeList = conBenToLOV(query);
        }
        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")){
        	
        	 query="SELECT ABS_CODE FROM PM_AGENT_BONUS_SETUP";
        	CodeList = conBenToLOV(query);
        }
        
        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("C")){
        	
        	 query="SELECT ACH_CODE FROM PM_AGENT_CONTEST_HDR";
        	CodeList = conBenToLOV(query);
        }
			
		
			
		} 
		
		else{
			 if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("F")){
				 query = "SELECT ABH_BNF_CODE FROM PM_AGENT_BENEFIT_HDR"
						+ " WHERE UPPER(ABH_BNF_CODE) LIKE '"+ code.toUpperCase()+ "%'" +
						  " ORDER BY 1ASC";
		        	
		        	CodeList = conBenToLOV(query);
		        }
		        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")){
		        	
		        	query="SELECT ABS_CODE FROM PM_AGENT_BONUS_SETUP "+
	        	       " WHERE UPPER(ABS_CODE) LIKE '"+code.toUpperCase()+"%'"+
	        	       " ORDER BY 1ASC";
		        	CodeList = conBenToLOV(query);
		        }
		        
		        else if(agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("C")){
		        	
		        	 query="SELECT ACH_CODE FROM PM_AGENT_CONTEST_HDR"+
		        	       " WHERE UPPER(ACH_CODE) LIKE '"+code.toUpperCase()+"%'"+
		        	       " ORDER BY 1ASC";
		        	CodeList = conBenToLOV(query);
		        }
			
			
		}

		return CodeList;
	}
	
	public List<AGENT_PROCESS> conBenToLOV(String query) {
		List<AGENT_PROCESS> codeList = new ArrayList<AGENT_PROCESS>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				AGENT_PROCESS AGENT_PROCESS = new AGENT_PROCESS();
				AGENT_PROCESS.setUI_M_BEN_CON_TO(resultSet.getString(1));
				codeList.add(AGENT_PROCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}
	
	
	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new java.util.ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}
	public List<SelectItem> getComboBoxValues()
	{
		
		List<SelectItem> listItemList=new ArrayList<SelectItem>();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			String selectQuery="SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'PYMT_MODE' AND LIV_CODE IN ('M','Y')";
			resultSet=handler.executeSelectStatement(selectQuery,connection);
			while(resultSet.next())
			{
				listItemList.add(new SelectItem(resultSet.getString("LIV_CODE"),resultSet.getString("LIV_CODE_DESC")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listItemList;
	}
	public void checkBenefitDetails(AGENT_PROCESS agent_process) throws Exception
	{
		String selectQuery="SELECT 'X' "+
							"FROM   PT_AGENT_FRINGE_BENEFIT "+
							"WHERE  AFB_AGENT_CODE BETWEEN '"+agent_process.getUI_M_AGT_FM()+"' AND '"+agent_process.getUI_M_AGT_TO()+"' "+
							 "AND AFB_BNF_CODE BETWEEN '"+agent_process.getUI_M_BEN_CON_FROM()+"' AND '"+agent_process.getUI_M_BEN_CON_TO()+"' "+
							 "AND AFB_FREQ = '"+agent_process.getUI_M_FREQ()+"' "+
							 "AND TO_DATE('"+CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_FM_DT())+"','DD-MON-YYYY') BETWEEN AFB_PERIOD_FM_DT AND AFB_PERIOD_TO_DT "+
							 "AND TO_DATE('"+CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_TO_DT())+"','DD-MON-YYYY') BETWEEN AFB_PERIOD_FM_DT AND AFB_PERIOD_TO_DT ";
		Connection connection=CommonUtils.getConnection();
		ResultSet resultSet=new CRUDHandler().executeSelectStatement(selectQuery,connection);
		if(resultSet.next())
		{
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"60303"));
		}
		CommonUtils.closeCursor(resultSet);
	}
	public void checkBonusDetails(AGENT_PROCESS agent_process) throws Exception
	{
		
		String selectQuery="SELECT 'X' "+ 
						   "FROM PT_AGENT_BONUS_VALUES "+
						   "WHERE  ABV_AGENT_CODE BETWEEN ? AND ? "+
						   "AND  ABV_BONUS_CODE BETWEEN ? AND ? "+
						   "AND  TO_DATE(?,'DD-MON-YYYY') BETWEEN ABV_PERIOD_FM_DT AND ABV_PERIOD_TO_DT "+
						   "AND  TO_DATE(?,'DD-MON-YYYY') BETWEEN ABV_PERIOD_FM_DT AND ABV_PERIOD_TO_DT";
		Connection connection=CommonUtils.getConnection();
		ResultSet resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection,new Object[]{agent_process.getUI_M_AGT_FM(),agent_process.getUI_M_AGT_TO(),agent_process.getUI_M_BEN_CON_FROM(),agent_process.getUI_M_BEN_CON_TO(),CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_FM_DT()),CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_TO_DT())});
		if(resultSet.next())
		{
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"60303"));
		}
		CommonUtils.closeCursor(resultSet);
	}
	public void sysidCheck(AGENT_PROCESS agent_process){
		Date processDate = agent_process.getUI_M_PROCESS_DT();
		ResultSet resultSet=null;
		Connection connection=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.format(agent_process.getUI_M_PROCESS_DT());
		String query=" SELECT COUNT(DISTINCT ABV_SYS_ID) " +
				" FROM PT_AGENT_BONUS_VALUES"+
				" WHERE ABV_PROCESS_DT LIKE TO_DATE('"+dateFormat.format(agent_process.getUI_M_PROCESS_DT())+"','DD/MM/RRRR')";
		CRUDHandler handler = new CRUDHandler();
		try{
			connection= CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				
				int string = resultSet.getInt(1);
				System.out.println("String is:"+string);
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
			
		}
		
		
	}
	
}

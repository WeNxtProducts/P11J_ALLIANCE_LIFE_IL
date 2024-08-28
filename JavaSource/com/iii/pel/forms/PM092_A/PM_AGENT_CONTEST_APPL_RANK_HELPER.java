package com.iii.pel.forms.PM092_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_AGENT_CONTEST_APPL_RANK_HELPER {
	
	/**
	 * PRE-INSERT TRIGGER FOR 
	 * PM_AGENT_CONTEST_APPL_RANK
	 * @param agentContestApplRankValueBean
	 */
	public void pmAgentContestApplRankPreInsert
			(PM_AGENT_CONTEST_APPL_RANK agentContestApplRankValueBean)throws ValidatorException{
		
		try {
			L_VAL_RANK_CODE(agentContestApplRankValueBean);
			agentContestApplRankValueBean.setACAR_CR_DT(new CommonUtils().getCurrentDate());
			agentContestApplRankValueBean.setACAR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
 	* METHOD MODIFIED FOR DUPLICATE CHECK OF RECORDS*/
	/**
	 * L_VAL_RANK_CODE
	 * @param agentContestApplRankValueBean
	 */
	public void L_VAL_RANK_CODE(PM_AGENT_CONTEST_APPL_RANK agentContestApplRankValueBean)throws ValidatorException{
		ResultSet resultSet=null;
		CRUDHandler  handler=new CRUDHandler();
		Connection connection=null;
		String M_dummy=null;
		String rowId=null;
		try{
			connection=CommonUtils.getConnection();
			String sqlQuery=PM092_A_SQLQUERY_CONSTANTS.
									SELECT_ROWID_FOR_PM_AGENT_CONTEST_APPL_RANK_FOR_ACH_AND_RANK_CODE;
			Object[] objects={agentContestApplRankValueBean.getACAR_ACH_CODE(),agentContestApplRankValueBean.getACAR_RANK_CODE()};
			resultSet=handler.executeSelectStatement(sqlQuery, connection, objects);
			if(resultSet.next()){
				rowId=resultSet.getString(1);
			}
			if(CommonUtils.isDuplicate(agentContestApplRankValueBean.getROWID(), rowId)){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"1801" ));
			}
		
		}catch(SQLException exception){
			exception.printStackTrace();
			
		} catch (DBException e) {
			e.printStackTrace();
		}finally{

			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void whenValidateAcarRankCode(PM_AGENT_CONTEST_APPL_RANK agentContestApplRankValueBean)throws Exception{
		DBProcedures procedures=new DBProcedures();
		ArrayList<String> procedureValueList = new ArrayList<String>();
		try {
			if (agentContestApplRankValueBean.getACAR_RANK_CODE() != null) {
				procedureValueList = procedures.P_VAL_CODES("AGNRANK", agentContestApplRankValueBean.getACAR_RANK_CODE(), agentContestApplRankValueBean.getUI_M_ACAR_RANK_CODE_DESC(), "N", "E", null);
				if (procedureValueList.size() > 0) {
					agentContestApplRankValueBean.setUI_M_ACAR_RANK_CODE_DESC((String) procedureValueList.get(0));
				} else {
					agentContestApplRankValueBean.setUI_M_ACAR_RANK_CODE_DESC(null);
				}
			}
			L_VAL_RANK_CODE(agentContestApplRankValueBean);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
	
	/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
 	* METHOD MODIFIED FOR DUPLICATE CHECK OF RECORDS]*/
	
	/**
	 * PRE-UPDATE TRIGGER FOR 
	 * PM_AGENT_CONTEST_APPL_RANK
	 * @param agentContestApplRankValueBean
	 */
	public void pmAgentContestApplRankPreUpdate
				(PM_AGENT_CONTEST_APPL_RANK agentContestApplRankValueBean){
		try {
			agentContestApplRankValueBean.setACAR_UPD_DT(new CommonUtils().getCurrentDate());
			agentContestApplRankValueBean.setACAR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * POST-QUERY TRIGGER FOR 
	 * PM_AGENT_CONTEST_APPL_RANK
	 * SETS DESCRIPTION OF RANK CODE
	 * @param agentContestApplRankValueBean
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pmAgentContestApplRankPostQuery(PM_AGENT_CONTEST_APPL_RANK agentContestApplRankValueBean) throws SQLException, Exception{
		
		DBProcedures procedures=new DBProcedures();
		String rankCode=agentContestApplRankValueBean.getACAR_RANK_CODE();
		if(rankCode!=null){
			
			ArrayList<String> rankCodeDesclist=procedures.helperP_VAL_CODES
						(PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_APPL_RANK_RANK_CODE_TYPE,
							rankCode, PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_NAME_FLAG_N,
							PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_ERR_FLAG_N,null);
			if(rankCodeDesclist!=null && rankCodeDesclist.size()!=0){
				System.out.println("DEscription :"+rankCodeDesclist.get(0));
				agentContestApplRankValueBean.setUI_M_ACAR_RANK_CODE_DESC(rankCodeDesclist.get(0));
			}
		}
	}
}

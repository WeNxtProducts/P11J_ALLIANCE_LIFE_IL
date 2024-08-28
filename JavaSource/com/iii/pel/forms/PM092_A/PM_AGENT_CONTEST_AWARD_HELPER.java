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

public class PM_AGENT_CONTEST_AWARD_HELPER {
	
	/**
	 * PRE-INSERT TRIGGER FOR 
	 * PM_AGENT_CONTEST_AWARD 
	 * @param agentContestAwardValueBean
	 * @throws ValidatorException
	 */
	public void pmAgentContestAwardPreInsert(PM_AGENT_CONTEST_AWARD agentContestAwardValueBean)throws ValidatorException{
		
		try {
			L_VAL_AWARD_CODE(agentContestAwardValueBean);
			agentContestAwardValueBean.setACA_CR_DT(new CommonUtils().getCurrentDate());
			agentContestAwardValueBean.setACA_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	     CHANGE IN LOGIC FOR DUPLICATE RECORD CHECK */
	/**
	 * L_VAL_AWARD_CODE
	 * @param agentContestAwardValueBean
	 * @throws ValidatorException
	 */
	public void L_VAL_AWARD_CODE(PM_AGENT_CONTEST_AWARD agentContestAwardValueBean)throws ValidatorException{
		
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		String M_DUMMY=null;
		String dbRowId=null;
		try{
			connection=CommonUtils.getConnection(); 
			String sqlQuery=PM092_A_SQLQUERY_CONSTANTS.
			PM092_A$PM_AGENT_CONTEST_AWARD$SELECT_ROWID_FOR_PM_AGENT_CONTEST_AWARD_ACH_AND_AWARD_CODE;
			String achCode=agentContestAwardValueBean.getACA_ACH_CODE();
			String awardCode=agentContestAwardValueBean.getACA_AWARD_CODE();
			Object[] objects={achCode,awardCode};
			if(achCode!=null && awardCode!=null){
				resultSet=handler.executeSelectStatement(sqlQuery, connection, objects);
				if(resultSet.next()){
					dbRowId=resultSet.getString(1);
				}
				
				if(CommonUtils.isDuplicate(agentContestAwardValueBean.getROWID(), dbRowId)){
					
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "1801"));
				}
			}
		}catch(SQLException exception){
			exception.printStackTrace();
		}catch(DBException exception){
			exception.printStackTrace();
		}finally{

			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void whenValidateAwardCode(PM_AGENT_CONTEST_AWARD agentContestAwardValueBean)throws Exception{
		DBProcedures procedures=new DBProcedures();
		ArrayList<String> procedureValueList = new ArrayList<String>();
		try {
			if (agentContestAwardValueBean.getACA_AWARD_CODE() != null) {
				procedureValueList = procedures.P_VAL_CODES("AGT_AWARDS", agentContestAwardValueBean.getACA_AWARD_CODE(), agentContestAwardValueBean.getUI_M_ACA_AWARD_CODE_DESC(), "N", "E", null);
				if (procedureValueList.size() > 0) {
					agentContestAwardValueBean.setUI_M_ACA_AWARD_CODE_DESC((String) procedureValueList.get(0));
				} else {
					agentContestAwardValueBean.setUI_M_ACA_AWARD_CODE_DESC(null);
				}
			}
			L_VAL_AWARD_CODE(agentContestAwardValueBean);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
	
	/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	     CHANGE IN LOGIC FOR DUPLICATE RECORD CHECK] */
	
	/**
	 * PRE-UPDATE TRIGGER FOR 
	 * PM_AGENT_CONTEST_AWARD 
	 * @param agentContestAwardValueBean
	 */
	public void pmAgentContestAwardPreUpdate(PM_AGENT_CONTEST_AWARD agentContestAwardValueBean){
		
		try {
			agentContestAwardValueBean.setACA_UPD_DT(new CommonUtils().getCurrentDate());
			agentContestAwardValueBean.setACA_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * POST-QUERY TRIGGER FOR 
	 * PM_AGENT_CONTEST_AWARD
	 * SETS DESCRIPTION OF AWARD CODE
	 * @param agentContestApplRankValueBean
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pmAgentContestAwardPostQuery(PM_AGENT_CONTEST_AWARD agentContestAwardValueBean) throws SQLException, Exception{
		
		DBProcedures procedures=new DBProcedures();
		String awardCode=agentContestAwardValueBean.getACA_AWARD_CODE();
		if(awardCode!=null){
			
			ArrayList<String> awardCodeDesclist=procedures.helperP_VAL_CODES
						(PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_AWARD_AWARD_CODE_TYPE,
								awardCode, PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_NAME_FLAG_N,
							PM_AGENT_CONTEST_CONSTANTS.PM_AGENT_CONTEST_ERR_FLAG_N,null);
			if(awardCodeDesclist!=null && awardCodeDesclist.size()!=0){
				System.out.println("DEscription :"+awardCodeDesclist.get(0));
				agentContestAwardValueBean.setUI_M_ACA_AWARD_CODE_DESC(awardCodeDesclist.get(0));
			}
		}
	}
}

package com.iii.pel.forms.PM092_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_HDR_HELPER {

	/**
	 * Check for the uniqueness of the Agent Code.
	 * @param ACH_CODE_STRING
	 * @throws DBException 
	 */
	public void ACH_CODE_WHEN_VALIDATE_ITEM(String ACH_CODE_STRING) throws DBException{

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			String query = PM092_A_SQLQUERY_CONSTANTS.PM092_A$PM_AGENT_CONTEST_HDR$ACH_CODE;
			Object[] values = {ACH_CODE_STRING};
			resultSet = handler.executeSelectStatement(query, connection, values);
			if (resultSet != null) {
				while(resultSet.next()){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","1801"));	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	}
	
	/**
	 * Validation of Contest Level
	 */
	public void ACH_LEVEL_WHEN_VALIDATE_ITEM(String ACH_LEVEL_STRING){
		Double ACH_LEVEL_DOUBLE = Double.parseDouble(ACH_LEVEL_STRING);
		if(ACH_LEVEL_DOUBLE <= 0.0){
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71159", new Object[]{"0"}));
		}
		
		if(ACH_LEVEL_DOUBLE > 9999.0){
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71158", new Object[]{"9999"}));	
		}
	}
	
	/**
	 * Validate From Date with To Date
	 * @param fromDate
	 * @param pm_il_ri_pool_setup_action
	 */
	public void ACH_EFF_FM_DT_WHEN_VALIDATE_ITEM(Date fromDate, PM_AGENT_CONTEST_HDR_ACTION pm_agent_contest_hdr_action){
		Date toDate = pm_agent_contest_hdr_action.getPM_AGENT_CONTEST_HDR_BEAN().getACH_EFF_TO_DT();

		if(fromDate != null && toDate != null){
			if(fromDate.after(toDate)){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91010"));	
			}			
		}
		
		/*if(fromDate != null){
			Date sysDate = new java.util.Date(Calendar.getInstance().getTimeInMillis());
			if(sysDate.before(fromDate)){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91010"));	
			}
		}*/
	}
	
	/**
	 * Validate To Date with From Date
	 * @param toDate
	 * @param pm_il_ri_pool_setup_action
	 */
	public void ACH_EFF_TO_DT_WHEN_VALIDATE_ITEM(Date toDate, PM_AGENT_CONTEST_HDR_ACTION pm_agent_contest_hdr_action){
		Date fromDate = pm_agent_contest_hdr_action.getPM_AGENT_CONTEST_HDR_BEAN().getACH_EFF_FM_DT();
		
		if(fromDate != null && toDate != null){
			if(fromDate.after(toDate)){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91001"));	
			}			
		}
	}
	
	/**
	 * PRE-DELETE TRIGGER
	 * FOR PM_AGENT_CONTEST_HDR 
	 * DELETES RELATED RECORDS IN 
	 * PM_AGENT_CONTEST_DTL,PM_AGENT_CONTEST_AWARD
	 * @param compositeAction
	 */
	public void pmAgentContestHdrPreDelete(PM092_A_COMPOSITE_ACTION compositeAction){
		
		CRUDHandler handler=new CRUDHandler();
		
		PM_AGENT_CONTEST_HDR agentContestHdrValueBean=compositeAction.
											getPM_AGENT_CONTEST_HDR_ACTION_BEAN().getPM_AGENT_CONTEST_HDR_BEAN();
		
		String achCode=agentContestHdrValueBean.getACH_CODE();
		
		String deleteQueryforAgentContestDtl=PM092_A_SQLQUERY_CONSTANTS.
												DELETE_PM_AGENT_CONTEST_DTL_BY_ACH_CODE_IN_PRE_DELETE;
		
		String deleteQueryForAgentContestAward=PM092_A_SQLQUERY_CONSTANTS.
												DELETE_PM_AGENT_CONTEST_AWARD_BY_ACH_CODE_IN_PRE_DELETE;
		Object[] objects={achCode};
		if(achCode!=null){
		
			try{
				
				Connection connection=CommonUtils.getConnection();
				handler.executeDeleteStatement(deleteQueryforAgentContestDtl, connection, objects);
				handler.executeDeleteStatement(deleteQueryForAgentContestAward, connection, objects);
				
			}catch(DBException exception){
				exception.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *	PRE-INSERT FOR
	 *	FOR PM_AGENT_CONTEST_HDR
	 * @param agentContestHdrValueBean
	 */
	public void pmAgentContestHdrPreInsert(PM_AGENT_CONTEST_HDR agentContestHdrValueBean){
		
		try {
			agentContestHdrValueBean.setACH_CR_DT(new CommonUtils().getCurrentDate());
			agentContestHdrValueBean.setACH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	PRE-UPDATE FOR
	 *	FOR PM_AGENT_CONTEST_HDR
	 * @param agentContestHdrValueBean
	 */
	public void pmAgentContestHdrPreUpdate(PM_AGENT_CONTEST_HDR agentContestHdrValueBean){
		
		try {
			agentContestHdrValueBean.setACH_UPD_DT(new CommonUtils().getCurrentDate());
			agentContestHdrValueBean.setACH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void achDescWhenValidateItem(PM_AGENT_CONTEST_HDR pm_agent_contest_hdr){
		String achDesc=pm_agent_contest_hdr.getACH_DESC();
		String achShortDesc=pm_agent_contest_hdr.getACH_SHORT_DESC();
		int achDescLength=achDesc.length();
		if(achDesc!=null){
				if((achShortDesc==null)||(achShortDesc.isEmpty())){
					if(achDescLength>30){
						achDescLength=30;
					}
					pm_agent_contest_hdr.setACH_SHORT_DESC(achDesc.substring(0, achDescLength));
					System.out.println("Short Desc :"+pm_agent_contest_hdr.getACH_SHORT_DESC());
				}
		}
	}
	public void achBlDescWhenValidateItem(PM_AGENT_CONTEST_HDR pm_agent_contest_hdr){
		String achBlDesc=pm_agent_contest_hdr.getACH_BL_DESC();
		String achBlShortDesc=pm_agent_contest_hdr.getACH_BL_DESC();
		int achBlDescLength=achBlDesc.length();
		if(achBlDesc!=null){
				if((achBlShortDesc==null)||(achBlShortDesc.isEmpty())){
					if(achBlDescLength>30){
						achBlDescLength=30;
					}
					pm_agent_contest_hdr.setACH_BL_SHORT_DESC(achBlDesc.substring(0, achBlDescLength));
					System.out.println("Bilingual Short Desc :"+pm_agent_contest_hdr.getACH_BL_SHORT_DESC());
				}
		}
	}
}

package com.iii.pel.forms.PM092_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_DTL_HELPER {
	/**
	 * WhenCreateRecord Trigger 
	 * For PM_AGENT_CONTEST_DTL
	 * @param agentContestDtl
	 */
	public void pmAgentContestDtlWhenCreateRecord(PM_AGENT_CONTEST_DTL agentContestDtlValueBean){
		agentContestDtlValueBean.setACD_PROD_TYPE("P");
		agentContestDtlValueBean.setACD_FYC_TYPE("PK");
	}
	
	/**
	 * PRE-INSERT TRIGGER
	 * FOR PM_AGENT_CONTEST_DTL
	 * @param agentContestDtlValueBean
	 */
	public void pmAgentContestDtlPreInsert(PM_AGENT_CONTEST_DTL agentContestDtlValueBean)throws ValidatorException{
		try {
			L_VAL_CONTEST_RANGE(agentContestDtlValueBean);
			agentContestDtlValueBean.setACD_CR_DT(new CommonUtils().getCurrentDate());
			agentContestDtlValueBean.setACD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * L_VAL_CONTEST_RANGE
	 * @param agentContestDtlValueBean
	 */
	public void L_VAL_CONTEST_RANGE(PM_AGENT_CONTEST_DTL agentContestDtlValueBean)throws ValidatorException 
    {
       ResultSet resultSet1=null;
       ResultSet resultSet2=null;
       CRUDHandler handler=new CRUDHandler();
       Connection connection=null;
        try
        {
            connection=CommonUtils.getConnection();
            String sql_C1=PM092_A_SQLQUERY_CONSTANTS.
            					SELECT_X_FOR_PM_AGENT_CONTEST_DTL_DETAILS;
            Object[] objects1={agentContestDtlValueBean.getACD_ACH_CODE(),agentContestDtlValueBean.getACD_PROD_TYPE(),
            					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
            					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
            					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
            					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO(),
            					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO(),
            					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO()};
            
    	/*"SELECT 'X' FROM  PM_AGENT_CONTEST_DTL  WHERE" +
    		"  ACD_ACH_CODE  = :PM_AGENT_CONTEST_DTL.ACD_ACH_CODE " +
    		" AND ACD_PROD_TYPE  = :PM_AGENT_CONTEST_DTL.ACD_PROD_TYPE " +
    		" AND (((:PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  BETWEEN ACD_LC_FYC_FM " +
    		" AND  ACD_LC_FYC_TO)  OR (:PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO  " +
    		" BETWEEN ACD_LC_FYC_FM  AND  ACD_LC_FYC_TO))  OR ((ACD_LC_FYC_FM " +
    		" BETWEEN :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO) " +
    		" OR (ACD_LC_FYC_TO  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  AND " +
    		" :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO)))  AND (((:PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM " +
    		" BETWEEN ACD_NO_OF_POL_FM  AND  ACD_NO_OF_POL_TO)  OR (:PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO " +
    		" BETWEEN ACD_NO_OF_POL_FM  AND  ACD_NO_OF_POL_TO))  OR ((ACD_NO_OF_POL_FM  BETWEEN " +
    		" :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO)  " +
    		" OR (ACD_NO_OF_POL_TO  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO))) ";*/
            
            String sql_C2=PM092_A_SQLQUERY_CONSTANTS.
            				SELECT_X_FOR_PM_AGENT_CONTEST_DTL_DETAILS_AND_ROWID;
            Object[] objects2={agentContestDtlValueBean.getACD_ACH_CODE(),agentContestDtlValueBean.getACD_PROD_TYPE(),
					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
					agentContestDtlValueBean.getACD_LC_FYC_FM(),agentContestDtlValueBean.getACD_LC_FYC_TO(),
					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO(),
					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO(),
					agentContestDtlValueBean.getACD_NO_OF_POL_FM(),agentContestDtlValueBean.getACD_NO_OF_POL_TO(),
					agentContestDtlValueBean.getROWID()};
    	/*"SELECT 'X' FROM  PM_AGENT_CONTEST_DTL  WHERE  ACD_ACH_CODE  " +
    				" = :PM_AGENT_CONTEST_DTL.ACD_ACH_CODE  AND ACD_PROD_TYPE  = :PM_AGENT_CONTEST_DTL.ACD_PROD_TYPE " +
    				" AND (((:PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  BETWEEN ACD_LC_FYC_FM  AND  ACD_LC_FYC_TO)  OR" +
    				" (:PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO  BETWEEN ACD_LC_FYC_FM  AND  ACD_LC_FYC_TO))  OR " +
    				" ((ACD_LC_FYC_FM  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO)  " +
    				" OR (ACD_LC_FYC_TO  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_LC_FYC_TO)))  " +
    				" AND (((:PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM  BETWEEN ACD_NO_OF_POL_FM  AND  ACD_NO_OF_POL_TO)  " +
    				" OR (:PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO  BETWEEN ACD_NO_OF_POL_FM  AND  ACD_NO_OF_POL_TO)) " +
    				" OR ((ACD_NO_OF_POL_FM  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO)" +
    				"  OR (ACD_NO_OF_POL_TO  BETWEEN :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_FM  AND  :PM_AGENT_CONTEST_DTL.ACD_NO_OF_POL_TO))) " +
    				" AND ROWID  != :PM_AGENT_CONTEST_DTL.ROWID ";*/
           
            String M_DUMMY=null;
            if(agentContestDtlValueBean.getROWID()==null)
            {
                resultSet1=handler.executeSelectStatement(sql_C1, connection, objects1);
                if(resultSet1.next())
                {
                    M_DUMMY=resultSet1.getString(1);
                    if(M_DUMMY.equals(""+"X"))
                    {
                    	
                    	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
                    }
                }
                
            }else{
            	 resultSet2=handler.executeSelectStatement(sql_C2, connection, objects2);
                if(resultSet2.next())
                {
                    M_DUMMY=resultSet2.getString(1);
                    if(M_DUMMY.equals(""+"X"))
                    {
                    	
                    	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
                    }
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            
        }
        finally
        {
        	try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	
	/**
	 * PRE-UPDATE TRIGGER
	 * FOR PM_AGENT_CONTEST_DTL
	 * @param agentContestDtlValueBean
	 */
	public void pmAgentContestDtlPreUpdate(PM_AGENT_CONTEST_DTL agentContestDtlValueBean)throws ValidatorException{
		try {
			L_VAL_CONTEST_RANGE(agentContestDtlValueBean);
			agentContestDtlValueBean.setACD_UPD_DT(new CommonUtils().getCurrentDate());
			agentContestDtlValueBean.setACD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}

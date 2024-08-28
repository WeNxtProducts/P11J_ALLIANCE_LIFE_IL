package com.iii.pel.forms.PM104_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_WITH_DRAWL_SETUP_ACTION_HELPER {

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_curr_age_fm_when_validate_item(
			Integer AWDS_CURR_AGE_FM)throws Exception{
		try {
			if (AWDS_CURR_AGE_FM <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_curr_age_to_when_validate_item(
			Integer AWDS_CURR_AGE_FM, Integer AWDS_CURR_AGE_TO)
			throws Exception {
		try {
			if (AWDS_CURR_AGE_TO <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));

			} else if (AWDS_CURR_AGE_TO < AWDS_CURR_AGE_FM) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71224"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_join_age_fm_when_validate_item(
			Integer AWDS_JOIN_AGE_FM) throws Exception {
		try {
			if (AWDS_JOIN_AGE_FM <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_join_age_to_when_validate_item(
			Integer AWDS_JOIN_AGE_FM, Integer AWDS_JOIN_AGE_TO)
			throws Exception {
		try {
			if (AWDS_JOIN_AGE_TO <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));

			} else if (AWDS_JOIN_AGE_TO < AWDS_JOIN_AGE_FM) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71224"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_no_yrs_exp_fm_when_validate_item(
			Integer AWDS_NO_YRS_EXP_FM) throws Exception {
		try {
			if (AWDS_NO_YRS_EXP_FM <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_awds_no_yrs_exp_to_when_validate_item(
			Integer AWDS_NO_YRS_EXP_FM, Integer AWDS_NO_YRS_EXP_TO)
			throws Exception {
		try {
			if (AWDS_NO_YRS_EXP_TO <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));

			} else if (AWDS_NO_YRS_EXP_TO < AWDS_NO_YRS_EXP_FM) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71224"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_PAY_RATE_when_validate_item(
			Double AWDS_PAY_RATE)throws Exception{
		try {
			if (AWDS_PAY_RATE <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public void pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_PAY_RATE_PER_when_validate_item(
			Integer AWDS_PAY_RATE_PER)throws Exception{
		try {
			if (AWDS_PAY_RATE_PER <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public void pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_LC_FUND_BAL_when_validate_item(
			Double AWDS_LC_FUND_BAL)throws Exception{
		try {
			if (AWDS_LC_FUND_BAL <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public void when_create_record(
			PM_AGENT_WITH_DRAWL_SETUP pm_agent_with_drawl_setup) {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String query = PM104_A_TSIB_SQLQUERY_CONSTANTS.WHEN_CREATE_RECORD_GET_PC_CODE_FOR_PC_TYPE;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[]{});
			if (resultSet.next()) {
				pm_agent_with_drawl_setup.setAWDS_TYPE(resultSet.getString(1));
			}
			pm_agent_with_drawl_setup.setAWDS_PAY_SHARE_TYPE("C");
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

package com.iii.pel.forms.WORKFLOW;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WF_MAIL_USGRP_DELEGATE {

	public void executeSelectStatement(
			WORKFLOW_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PGIM_WF_MAIL_USGRP.* FROM PGIM_WF_MAIL_USGRP WHERE PWMU_PWB_BUKT_CODE=?";
		Connection connection = null;
		ResultSet resultSet = null;
		PGIM_WF_MAIL_USGRP PGIM_WF_MAIL_USGRP_BEAN = null;
		compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getDataTableList().clear();
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{compositeAction.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().getPGIM_WORKFLOW_BUCKET_BEAN().getPWB_CODE()});
			while (resultSet.next()) {
				PGIM_WF_MAIL_USGRP_BEAN = new PGIM_WF_MAIL_USGRP();
				PGIM_WF_MAIL_USGRP_BEAN.setROWID(resultSet.getString("ROWID"));
				System.out.println("                            ROWID"+resultSet.getString("ROWID"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_PWB_BUKT_CODE(resultSet.getString("PWMU_PWB_BUKT_CODE"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_APPR_STS(resultSet.getString("PWMU_APPR_STS"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_POL_WF_STS(resultSet.getString("PWMU_POL_WF_STS"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_USGRP(resultSet.getString("PWMU_MAIL_USGRP"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_CR_UID(resultSet.getString("PWMU_CR_UID"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_CR_DT(resultSet.getDate("PWMU_CR_DT"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_USGRP_1(resultSet.getString("PWMU_ESC_USGRP_1"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_USGRP_2(resultSet.getString("PWMU_ESC_USGRP_2"));  
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_USGRP_TO_MODIFY(resultSet.getString("PWMU_USGRP_TO_MODIFY"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_MESSAGE(resultSet.getString("PWMU_MAIL_MESSAGE"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_SUBJECT(resultSet.getString("PWMU_MAIL_SUBJECT"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_LIMIT_FROM(resultSet.getString("PWMU_LIMIT_FROM"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_LIMIT_TO(resultSet.getString("PWMU_LIMIT_TO"));
				/* Added by kavitha for RoadMap on 20.11.2018*/
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_LIMIT(resultSet.getInt("PWMU_ESC_LIMIT"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_LMT_TYP(resultSet.getString("PWMU_ESC_LMT_TYP"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_ESC_MESSAGE(resultSet.getString("PWMU_MAIL_ESC_MESSAGE"));
				PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_ESC_SUBJECT(resultSet.getString("PWMU_MAIL_ESC_SUBJECT"));
				/*End*/
				compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getDataTableList().add(PGIM_WF_MAIL_USGRP_BEAN);
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
}

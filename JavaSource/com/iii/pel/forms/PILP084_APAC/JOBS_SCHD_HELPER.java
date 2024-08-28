package com.iii.pel.forms.PILP084_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.JOptionPane;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class JOBS_SCHD_HELPER {

	public void whenNewRecordCreated(JOBS_SCHD_ACTION JOBS_SCHD_ACTION_BEAN)
			throws Exception {

		JOBS_SCHD JOBS_SCHD_BEAN = JOBS_SCHD_ACTION_BEAN.getJOBS_SCHD_BEAN();
		try {
			JOBS_SCHD_BEAN.setUI_M_SCHD_JOB_YN("N");
			JOBS_SCHD_BEAN.setUI_M_SCHD_INSTANCE(new CommonUtils()
					.getCurrentDate());
			JOBS_SCHD_BEAN.setUI_M_SCHD_INTERVAL(1.0);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void when_ValidatePrcss_Name(JOBS_SCHD_ACTION JOBS_SCHD_ACTION_BEAN) throws Exception {

		JOBS_SCHD JOB_SCHD_BEAN = JOBS_SCHD_ACTION_BEAN.getJOBS_SCHD_BEAN();
		String C1 = "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE=? AND PC_TYPE='JOBS_SCHD'";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try {
			connection=CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { JOB_SCHD_BEAN.getUI_M_PRCSS_NAME() });
			if (resultSet.next()) {
				JOB_SCHD_BEAN.setUI_M_PRCSS_NAME_DESC(resultSet.getString(1));
			} else {
				throw new Exception("Invalid Job");
			}
			JOBS_SCHD_ACTION_BEAN.getCOMP_UI_M_PRCSS_NAME_DESC().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateUI_M_SCHD_INSTANCE(JOBS_SCHD_ACTION JOBS_SCHD_ACTION_BEAN) throws Exception{
		try{
			JOBS_SCHD JOBS_SCHD_BEAN= JOBS_SCHD_ACTION_BEAN.getJOBS_SCHD_BEAN();
			if(JOBS_SCHD_BEAN.getUI_M_SCHD_INSTANCE().before(new CommonUtils().getCurrentDate())){
				JOBS_SCHD_BEAN.setUI_M_SCHD_INSTANCE(new CommonUtils().getCurrentDate());
		}
		}catch (Exception e) {
				e.getMessage();
				throw new Exception(e.getMessage());
			}
	}
}

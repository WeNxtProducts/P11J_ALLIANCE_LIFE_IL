package com.iii.pel.forms.PILM002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_COVER_SEARCH_PAGE_DELEGATE {
	
	public void listAllRecords(PM_IL_COVER_ACTION PM_IL_COVER_ACTION_BEAN){
		Connection connection = null;
		CRUDHandler handler=new CRUDHandler();
		
		String queryString = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_COVER;
		PM_IL_COVER PM_IL_COVER_BEAN = PM_IL_COVER_ACTION_BEAN.getPM_IL_COVER_BEAN(); 
		ResultSet result=null;
		
		try {
			connection = CommonUtils.getConnection();
			result=handler.executeSelectStatement(queryString,connection,new Object[]{PM_IL_COVER_BEAN.getROWID()});
			if(result!=null){
				while(result.next()){
					PM_IL_COVER bean=new PM_IL_COVER();
					bean.setCOVER_APP_ON_BASIC_RATE(result.getString("COVER_APP_ON_BASIC_RATE"));
					bean.setCOVER_BL_DESC(result.getString("COVER_BL_DESC"));
					bean.setCOVER_BL_LONG_DESC(result.getString("COVER_BL_LONG_DESC"));
					bean.setCOVER_CLASS(result.getString("COVER_CLASS"));
					bean.setCOVER_CODE(result.getString("COVER_CODE"));
					bean.setCOVER_DESC(result.getString("COVER_DESC"));
					bean.setCOVER_DISC_AGE_YN(result.getString("COVER_DISC_AGE_YN"));
					bean.setCOVER_EFF_FM_DT(result.getDate("COVER_EFF_FM_DT"));
					bean.setCOVER_EFF_TO_DT(result.getDate("COVER_EFF_TO_DT"));
					bean.setCOVER_FRZ_FLAG(result.getString("COVER_FRZ_FLAG"));
					bean.setCOVER_FUND_MTHD(result.getString("COVER_FUND_MTHD"));
					bean.setCOVER_FUND_RISK(result.getString("COVER_FUND_RISK"));
					bean.setCOVER_FUND_TYPE(result.getString("COVER_FUND_TYPE"));
					bean.setCOVER_LONG_DESC(result.getString("COVER_LONG_DESC"));
					bean.setCOVER_MAX_SA(result.getDouble("COVER_MAX_SA"));
					bean.setCOVER_MAX_UNIT(result.getDouble("COVER_MAX_UNIT"));
					bean.setCOVER_MAX_UNIT(result.getDouble("COVER_MAX_UNIT"));
					bean.setCOVER_MIN_MAX_REQ(result.getString("COVER_MIN_MAX_REQ"));
					bean.setCOVER_MIN_SA(result.getDouble("COVER_MIN_SA"));
					bean.setCOVER_MIN_UNIT(result.getDouble("COVER_MIN_UNIT"));
					bean.setCOVER_PREM_TYPE(result.getString("COVER_PREM_TYPE"));
					bean.setCOVER_RATE_APPLIED_ON(result.getString("COVER_RATE_APPLIED_ON"));
					bean.setCOVER_SA_CALC(result.getString("COVER_SA_CALC"));
					bean.setCOVER_SA_MULTIPLE(result.getDouble("COVER_SA_MULTIPLE"));
					bean.setCOVER_SA_PERC(result.getDouble("COVER_SA_PERC"));
					bean.setCOVER_TYPE(result.getString("COVER_TYPE"));
					bean.setCOVER_VAR_VALUE(result.getDouble("COVER_VAR_VALUE"));
					bean.setROWID(result.getString("ROWID"));
					bean.setCOVER_MEDICAL_YN(result.getString("COVER_MEDICAL_YN"));
					//bean.setCOVER_SURGICAL_YN(result.getString("COVER_SURGICAL_YN"));
					bean.setCOVER_LIMIT_DAYS(result.getDouble("COVER_LIMIT_DAYS"));
					bean.setCOVER_LIMIT_TYPE(result.getString("COVER_LIMIT_TYPE"));
					bean.setCOVER_PER_DAY_LC_AMT(result.getDouble("COVER_PER_DAY_LC_AMT"));
					
					bean.setCOVER_SA_BY_PARTS_TARR(result.getString("COVER_SA_BY_PARTS_TARR"));
					bean.setCOVER_MIN_TYPE(result.getString("COVER_MIN_TYPE"));
					bean.setCOVER_MAX_TYPE(result.getString("COVER_MAX_TYPE"));
					bean.setCOVER_MIN_PERC(result.getDouble("COVER_MIN_PERC"));
					bean.setCOVER_MAX_PERC(result.getDouble("COVER_MAX_PERC"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
//				result.close();
//				result=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

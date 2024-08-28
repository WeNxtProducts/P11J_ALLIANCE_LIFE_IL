package com.iii.pel.forms.PILM002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_BASIC_CONTR_DELEGATE {
	
	public List getBlockDataForPM_IL_CVR_CONTR_PRD() {
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		String queryString=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_CVR_CONTR_PRD_BY_COVER_CODE;
		CRUDHandler handler=new CRUDHandler();
		List <PM_IL_BASIC_CONTRIBUTION> dataList=new ArrayList<PM_IL_BASIC_CONTRIBUTION>();
		ResultSet result=null;
		try {
			PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
				(PILM002_APAC_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession(mappedBeanName);
			String id=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
			Connection connection = CommonUtils.getConnection();
			Object []values={id};
			 result=handler.executeSelectStatement(queryString, connection, values);
			
			if(result!=null){
				while(result.next()){
					PM_IL_BASIC_CONTRIBUTION bean=new PM_IL_BASIC_CONTRIBUTION();
					bean.setBC_COVER_CODE(result.getString("BC_COVER_CODE"));
					bean.setBC_AGE_FROM(result.getInt("BC_AGE_FROM"));
					bean.setBC_AGE_TO(result.getInt("BC_AGE_TO"));
					bean.setBC_LC_BASIC_CONTRIB(result.getInt("BC_LC_BASIC_CONTRIB"));
					bean.setROWID(result.getString("ROWID"));
					dataList.add(bean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dataList;
	}
	

	
}

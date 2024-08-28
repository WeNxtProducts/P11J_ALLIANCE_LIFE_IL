package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PT_IL_POL_CONDITION_HELPER {


	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_CONDITION_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_POL_CONDITION> dataList = compositeAction.
		getPT_IL_POL_CONDITION_ACTION_BEAN().getDataList_PT_IL_POL_CONDITION();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN = dataList.get(0);
			PT_IL_POL_CONDITION_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN()
			.setPT_IL_POL_CONDITION_BEAN(PT_IL_POL_CONDITION_BEAN);
		}
	}
	
	public void preInsert(PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN, 
			Long POL_SYS_ID) throws Exception {
		String cursor1 = " SELECT PIL_PLCOND_SYS_ID.NEXTVAL FROM DUAL ";
		PILQ003_LOCAL_PROCEDURES local_procedures = new PILQ003_LOCAL_PROCEDURES();
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			local_procedures.IL_UNIQUE_CONDITION_CODE(PT_IL_POL_CONDITION_BEAN, POL_SYS_ID);
			resultSet1 = handler.executeSelectStatement(cursor1, connection);
			if(resultSet1.next()){
				PT_IL_POL_CONDITION_BEAN.setPLCOND_SYS_ID(resultSet1.getLong(1));
			}
			PT_IL_POL_CONDITION_BEAN.setPLCOND_CR_DT(new CommonUtils().getCurrentDate());
			PT_IL_POL_CONDITION_BEAN.setPLCOND_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			PT_IL_POL_CONDITION_BEAN.setPLCOND_POL_SYS_ID(POL_SYS_ID);
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor(resultSet1);} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public void preUpdate(PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN, 
			Long POL_SYS_ID) throws Exception {
		PILQ003_LOCAL_PROCEDURES local_procedures = new PILQ003_LOCAL_PROCEDURES();
		try{
		local_procedures.IL_UNIQUE_CONDITION_CODE(PT_IL_POL_CONDITION_BEAN, POL_SYS_ID);	
		PT_IL_POL_CONDITION_BEAN.setPLCOND_UPD_DT(new CommonUtils().getCurrentDate());
		PT_IL_POL_CONDITION_BEAN.setPLCOND_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_PLCOND_CODE(PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN, 
			Long POL_SYS_ID) throws Exception {
		PILQ003_LOCAL_PROCEDURES local_procedures = new PILQ003_LOCAL_PROCEDURES();
		ArrayList<String> list1 = null;
		DBProcedures procedures = new DBProcedures();
		try {
			local_procedures.IL_UNIQUE_CONDITION_CODE(PT_IL_POL_CONDITION_BEAN, POL_SYS_ID);
			list1 = procedures.P_VAL_CODES("IL_COND", PT_IL_POL_CONDITION_BEAN.getPLCOND_CODE(),
		            "L","E", null);
			PT_IL_POL_CONDITION_BEAN.setPLCOND_DESC(list1.get(0));
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}

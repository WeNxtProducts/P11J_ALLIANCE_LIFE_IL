package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_BUS_COVER_HELPER {
	
	public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("inside of executeQuery helper");
		new PM_IL_BUS_COVER_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_IL_BUS_COVER> dataList = compositeAction.getPM_IL_BUS_COVER_ACTION_BEAN().getDataList_BRCS_COVER_CODE();
	
	 if(dataList!=null && dataList.size() > 0){
		 PM_IL_BUS_COVER BEAN = dataList.get(0);
		 BEAN.setRowSelected(true);
				compositeAction.getPM_IL_BUS_COVER_ACTION_BEAN().setPM_IL_BUS_COVER_BEAN(BEAN);
	}
	}
	
	
	
	public void BRCS_COVER_CODE_WHEN_VALIDATE_ITEM(
			PM_IL_BUS_COVER Bean) throws Exception {

		String CURSOR_C1 = "select COVER_CODE,COVER_DESC from PM_IL_COVER";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			while (resultSet.next()) {
				if (Bean.getBRCS_COVER_CODE().equals(
						resultSet.getString(1))) {
					Bean.setBRCS_COVER_CODE_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& Bean.getBRCS_COVER_CODE()!= "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PM_IL_BUS_COVER BEAN)
			throws Exception {
				ArrayList<String> list = null;
				

				DBProcedures procedures = new DBProcedures();
				try {
					list = procedures.callP_VAL_COVER_PROC(BEAN.getBRCS_COVER_CODE(),null, null, "N","N");
					
					if(!list.isEmpty() && list.get(0)!=null )
						BEAN.setBRCS_COVER_CODE_DESC(list.get(0));
					
			
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}

	
	
}

package com.iii.pel.forms.PILM200;

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

public class PM_IL_PROD_GROUP_HDR_HELPER {
	
	public void excuteQuery(PM_IL_PROD_GROUP_HDR headerBean) throws Exception {
		try {
			new PM_IL_PROD_GROUP_HDR_DELEGATE().excuteQuery(headerBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preInsert(PM_IL_PROD_GROUP_HDR headerBean)throws Exception{
		try {
			headerBean.setPGH_FREEZE_FLAG(false);
			headerBean.setPGH_CR_DT(new CommonUtils().getCurrentDate());
			headerBean.setPGH_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenCreateRecord(PM_IL_PROD_GROUP_HDR headerBean){
		headerBean.setPGH_FREEZE_FLAG(false);
	}
	
	public void preUpdate(PM_IL_PROD_GROUP_HDR headerBean) throws Exception{
		try {
			headerBean.setPGH_UPD_DT(new CommonUtils().getCurrentDate());
			headerBean.setPGH_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void postQuery(PM_IL_PROD_GROUP_HDR headerBean) throws Exception{
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null; 
		ArrayList<String> list1 = null;
		try {
			list = procedures.P_VAL_CODES(
									"APPLPLANS",
									headerBean.getPGH_APPL_PLAN_CODE(),
									headerBean.getUI_M_APPL_PLAN_DESC(),
									"N","E", null);
		
		if (list != null && !list.isEmpty()) {
			if (list.get(0) != null) {
				headerBean.setUI_M_APPL_PLAN_DESC(list.get(0));
			}
		}
		list1 = procedures.P_VAL_CODES(
								"APPLPLANS",
								headerBean.getPGH_APPL_PLAN_CODE(),
								headerBean.getUI_M_PLAN_TYPE(),
								"L","N", null);
		if (list1 != null && !list1.isEmpty()) {
			if (list1.get(0) != null) {
				headerBean.setUI_M_PLAN_TYPE(list1.get(0));
			}
		}
		headerBean.setUI_M_PLAN_TYPE("");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preDelete(PM_IL_PROD_GROUP_HDR headerBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String DELETE_QUERY = "DELETE FROM PM_IL_PROD_GROUP_DTL WHERE PGD_GROUP_CODE = ? ";
		
		try {
		
			handler.executeDeleteStatement(DELETE_QUERY,CommonUtils.getConnection(),
					new Object[]{headerBean.getPGH_GROUP_CODE()});
			
			
			CommonUtils.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	public void PGH_GROUP_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP_HDR headerBean) throws Exception {
		String rowId=null;
		String sqlQuery1="SELECT ROWID FROM PM_IL_PROD_GROUP_HDR WHERE  PGH_GROUP_CODE = ? ";
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		try{
			Connection connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(sqlQuery1, connection, new Object[]{headerBean.getPGH_GROUP_CODE()});
			if(resultSet.next()){
				rowId = resultSet.getString("ROWID");
				// Insert check
				if(headerBean.getROWID() == null){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91987"));
				}else if(rowId.equals(headerBean.getROWID())){

				}else{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91987"));
				}
			}
		
		}catch(DBException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch(SQLException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			
			
					
		
	}

	public void PGH_APPL_PLAN_CODE_WHEN_VALIDATE_ITEM(
			PM_IL_PROD_GROUP_HDR headerBean) throws Exception {
			DBProcedures procedures = new DBProcedures();
			ArrayList<String> list= null;
			 ArrayList<String> list1= null;
			try {
				list = procedures.P_VAL_CODES("APPLPLANS", headerBean.getPGH_APPL_PLAN_CODE(),headerBean.getUI_M_APPL_PLAN_DESC() ,"N", "E", null);
				list1 = procedures.P_VAL_CODES("APPLPLANS", headerBean.getPGH_APPL_PLAN_CODE(),headerBean.getUI_M_PLAN_TYPE() ,"L", "E", null);
				if (list != null ) {
					headerBean.setUI_M_APPL_PLAN_DESC(list.get(0));
				}
				if (list1 != null) {
					headerBean.setUI_M_PLAN_TYPE(list1.get(0));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}
	
	
	
	
	
	
}

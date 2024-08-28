package com.iii.pel.forms.PILP043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class PP_IL_DEP_REV_LOG_Action {


	private ArrayList<PP_IL_DEP_REV_LOG> pP_IL_DEP_REV_LOG_list = new ArrayList<PP_IL_DEP_REV_LOG>();

	private UIData dataTable;

	private PP_IL_DEP_REV_LOG pp_il_dep_rev_log_bean;

	public UIData getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public ArrayList<PP_IL_DEP_REV_LOG> getPP_IL_DEP_REV_LOG_list() {
		return pP_IL_DEP_REV_LOG_list;
	}



	public void setPP_IL_DEP_REV_LOG_list(
			ArrayList<PP_IL_DEP_REV_LOG> pp_il_dep_rev_log_list) {
		pP_IL_DEP_REV_LOG_list = pp_il_dep_rev_log_list;
	}

	public void onload(PhaseEvent event) throws Exception
	{
		PP_IL_DEP_REV_LOG_Action action= new PP_IL_DEP_REV_LOG_Action();
		System.out.println("call executeQuery Method");
		action.executeQuery();	
	}


	public   void executeQuery() throws Exception{
		System.out.println("enter  into ExecuteQuery Method");
		Connection con = null;
		ResultSet resultSet = null;
		PP_IL_DEP_REV_LOG pP_IL_DEP_REV_LOG_bean = null;
		pP_IL_DEP_REV_LOG_list.clear();
		String query = "select DEP_REV_CONT_CODE,DEP_REV_DATE,DEP_REV_ERR_DESC from PP_IL_DEP_REV_LOG";
		try {
			con = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, con);
			while(resultSet.next()){
				pP_IL_DEP_REV_LOG_bean = new PP_IL_DEP_REV_LOG();
				pP_IL_DEP_REV_LOG_bean.setDEP_REV_CONT_CODE(resultSet.getString("DEP_REV_CONT_CODE"));
				pP_IL_DEP_REV_LOG_bean.setDEP_REV_DATE(resultSet.getString("DEP_REV_DATE"));
				pP_IL_DEP_REV_LOG_bean.setDEP_REV_ERR_DESC(resultSet.getString("DEP_REV_ERR_DESC"));
				pP_IL_DEP_REV_LOG_list.add(pP_IL_DEP_REV_LOG_bean);
			System.out.println("pP_IL_DEP_REV_LOG_list    : "+pP_IL_DEP_REV_LOG_list.toString());
			}

		} catch (DBException e) {
			System.out.println("*********    DBException   *****");

			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			System.out.println("*********    SQLException   *****");
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}



	public PP_IL_DEP_REV_LOG getPp_il_dep_rev_log_bean() {
		return pp_il_dep_rev_log_bean;
	}



	public void setPp_il_dep_rev_log_bean(PP_IL_DEP_REV_LOG pp_il_dep_rev_log_bean) {
		this.pp_il_dep_rev_log_bean = pp_il_dep_rev_log_bean;
	}

}

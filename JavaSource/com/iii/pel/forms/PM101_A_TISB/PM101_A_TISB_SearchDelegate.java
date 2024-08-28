package com.iii.pel.forms.PM101_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM101_A_TISB_SearchDelegate{
	
	public ArrayList fetchMasterBlock(PM_AGENT_PF_COMP_CONT_SearchAction searchAction) {
		ArrayList<PM_AGENT_PF_COMP_CONT> masterList = new ArrayList<PM_AGENT_PF_COMP_CONT>();
		PM_AGENT_PF_COMP_CONT searchBean = searchAction.getSearchBean();
		String Mcode = searchBean.getAPCC_MKT_CODE();
		String query = null;
		ResultSet rs = null;
		//Pre Form Calling
		/*PM_AGENT_PF_COMP_CONT_ACTION pm_agent_pf_comp_cont_action = (PM_AGENT_PF_COMP_CONT_ACTION)new CommonUtils().getMappedBeanFromSession("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION");
		if(pm_agent_pf_comp_cont_action == null)
		{
			pm_agent_pf_comp_cont_action = new PM_AGENT_PF_COMP_CONT_ACTION();
		}
		pm_agent_pf_comp_cont_action.preForm();*/
		
		if ((Mcode == null || Mcode.equals(""))) {
			query = "SELECT ROWID,APCC_MKT_CODE,APCC_PROD_TYPE,APCC_CONT_FM,APCC_CONT_TO,APCC_RATE FROM PM_AGENT_PF_COMP_CONT";
		} else if ((Mcode != null || !Mcode.equals(""))) {
			query = "SELECT ROWID,PM_AGENT_PF_COMP_CONT.* FROM PM_AGENT_PF_COMP_CONT where APCC_MKT_CODE like'"
					+ Mcode + "%'";
		}
		try {
			rs = getHandler().executeSelectStatement(query, getConnection());
			while (rs.next()) {
				PM_AGENT_PF_COMP_CONT searchBean1 = new PM_AGENT_PF_COMP_CONT();
				searchBean1.setAPCC_MKT_CODE(rs.getString("APCC_MKT_CODE"));
				searchBean1.setAPCC_PROD_TYPE(rs.getString("APCC_PROD_TYPE"));
				searchBean1.setAPCC_CONT_FM(rs.getDouble("APCC_CONT_FM"));
				searchBean1.setAPCC_CONT_TO(rs.getDouble("APCC_CONT_TO"));
				searchBean1.setAPCC_RATE(rs.getDouble("APCC_RATE"));
				searchBean1.setROWID(rs.getString("ROWID"));
				
System.out.println("PM101_A_TISB_SearchDelegate.fetchMasterBlock()--["+searchBean1.getAPCC_PROD_TYPE()+"]");
				masterList.add(searchBean1);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally{
			try{
			rs.close();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		return masterList;
	}

	
	public int deleteData(PM_AGENT_PF_COMP_CONT gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}


	public String duplicateCheck(PM_AGENT_PF_COMP_CONT pm_agent_pf_comp_cont)
	{
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(pm_agent_pf_comp_cont.getROWID() == null)
			{
				query = "SELECT 'X'	FROM PM_AGENT_PF_COMP_CONT	WHERE 	APCC_MKT_CODE=?	AND" +
						"	APCC_RANK_CODE	=?	AND	APCC_PROD_TYPE	=?	AND ((APCC_EFF_FM_DT BETWEEN ? AND ? " +
						"AND APCC_EFF_TO_DT BETWEEN ? AND ?) OR (? BETWEEN APCC_EFF_FM_DT AND APCC_EFF_TO_DT " +
						"AND ? BETWEEN APCC_EFF_FM_DT AND APCC_EFF_TO_DT))	AND  ((APCC_CONT_FM " +
						"  BETWEEN ?  AND ?   AND     APCC_CONT_TO   BETWEEN ?  AND ?)  OR " +
						"	(? BETWEEN APCC_CONT_FM AND APCC_CONT_TO AND ? BETWEEN APCC_CONT_FM AND APCC_CONT_TO))";
				Object[] params = {pm_agent_pf_comp_cont.getAPCC_MKT_CODE(),pm_agent_pf_comp_cont.getAPCC_RANK_CODE(),
						pm_agent_pf_comp_cont.getAPCC_PROD_TYPE(),pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO()};
				resultSet = handler.executeSelectStatement(query, connection, params);
			}else{
				query = "SELECT 'X'	FROM PM_AGENT_PF_COMP_CONT	WHERE 	APCC_MKT_CODE=?	AND" +
				"	APCC_RANK_CODE	=?	AND	APCC_PROD_TYPE	=?	AND ((APCC_EFF_FM_DT BETWEEN ? AND ? " +
				"AND APCC_EFF_TO_DT BETWEEN ? AND ?) OR (? BETWEEN APCC_EFF_FM_DT AND APCC_EFF_TO_DT " +
				"AND ? BETWEEN APCC_EFF_FM_DT AND APCC_EFF_TO_DT))	AND  ((APCC_CONT_FM " +
				"  BETWEEN ?  AND ?   AND     APCC_CONT_TO   BETWEEN ?  AND ?)  OR " +
				"	(? BETWEEN APCC_CONT_FM AND APCC_CONT_TO AND ? BETWEEN APCC_CONT_FM AND APCC_CONT_TO)) " +
				"AND  ROWID!=?";
				Object[] params = {pm_agent_pf_comp_cont.getAPCC_MKT_CODE(),pm_agent_pf_comp_cont.getAPCC_RANK_CODE(),
						pm_agent_pf_comp_cont.getAPCC_PROD_TYPE(),pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_EFF_FM_DT(),pm_agent_pf_comp_cont.getAPCC_EFF_TO_DT(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO(),
						pm_agent_pf_comp_cont.getAPCC_CONT_FM(),pm_agent_pf_comp_cont.getAPCC_CONT_TO()};	
				resultSet = handler.executeSelectStatement(query, connection, params);
			}
			while(resultSet.next())
			{
				TEMP = resultSet.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return TEMP;
	}
	
	
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) {
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			queryString = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME = '{0}' AND LI_BLOCK_NAME = '{1}' AND LI_ITEM_NAME = '{2}'";
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);

			resultSet = handler.executeSelectStatement(queryString, connection);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
}

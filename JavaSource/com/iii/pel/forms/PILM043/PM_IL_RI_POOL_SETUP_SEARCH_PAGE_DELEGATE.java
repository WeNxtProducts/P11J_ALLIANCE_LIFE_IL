package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_SETUP_SEARCH_PAGE_DELEGATE {

	public ArrayList fetchRIPoolSetupDetails(PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION pm_il_ri_pool_setup_search_page_action) throws ValidatorException{
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList RIPoolSetupList = new ArrayList();
		
		try {
			connection = CommonUtils.getConnection();

			String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$SEARCH_PAGE;
			if (pm_il_ri_pool_setup_search_page_action.getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN().getRiPoolCode() != null
					&& pm_il_ri_pool_setup_search_page_action.getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN().getRiPoolCode().trim().length() > 0) {
				if(pm_il_ri_pool_setup_search_page_action.getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN().getRiPoolCode().substring(0, 1).equalsIgnoreCase("%"))
				{
					query = query + " WHERE UPPER(RPS_CODE) LIKE " + "'%"
					+ pm_il_ri_pool_setup_search_page_action.getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN().getRiPoolCode().toUpperCase() + "'";
				}else{
					query = query + " WHERE UPPER(RPS_CODE) LIKE " + "'"
						+ pm_il_ri_pool_setup_search_page_action.getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN().getRiPoolCode().toUpperCase() + "%'";
				}
			}
			
			resultSet = handler.executeSelectStatement(query, connection);
			if (resultSet != null) {
				while (resultSet.next()) {
					PM_IL_RI_POOL_SETUP bean = new PM_IL_RI_POOL_SETUP();
					bean.setRPS_CODE(resultSet.getString("RPS_CODE"));
					bean.setRPS_DESC(resultSet.getString("RPS_DESC"));
					bean.setROWID(resultSet.getString("ROWID"));
					RIPoolSetupList.add(bean);
				}
			}
		} catch (SQLException se) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(se.getMessage()));
		} 
		catch (Exception e) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
		return RIPoolSetupList;
	}
	
	public Object fetchRIPoolSetupDetails(String rowId, Object obj) {

//		PM_IL_DOC_SETUP beanClass = (PM_IL_DOC_SETUP) obj;
		PM_IL_RI_POOL_SETUP beanClass = (PM_IL_RI_POOL_SETUP)obj;
		try {
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
//			commonUtils = new CommonUtils();
			String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$SEARCH_PAGE_TO_MAIN_PAGE;
			Object values[] = {rowId};
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			while (resultSet.next()) {
				
				beanClass.setRPS_CODE(resultSet.getString("RPS_CODE"));
				beanClass.setRPS_DESC(resultSet.getString("RPS_DESC"));
				beanClass.setRPS_SHORT_DESC(resultSet.getString("RPS_SHORT_DESC"));
				beanClass.setRPS_LONG_DESC(resultSet.getString("RPS_LONG_DESC"));
				beanClass.setRPS_BL_DESC(resultSet.getString("RPS_BL_DESC"));
				beanClass.setRPS_BL_SHORT_DESC(resultSet.getString("RPS_BL_SHORT_DESC"));
				beanClass.setRPS_BL_LONG_DESC(resultSet.getString("RPS_BL_LONG_DESC"));
				beanClass.setRPS_EFF_FM_DT(resultSet.getDate("RPS_EFF_FM_DT"));
				beanClass.setRPS_EFF_TO_DT(resultSet.getDate("RPS_EFF_TO_DT"));
				beanClass.setRPS_CR_DT(resultSet.getDate("RPS_CR_DT"));
				beanClass.setRPS_CR_UID(resultSet.getString("RPS_CR_UID"));
				beanClass.setRPS_UPD_DT(resultSet.getDate("RPS_UPD_DT"));
				beanClass.setRPS_UPD_UID(resultSet.getString("RPS_UPD_UID"));
				beanClass.setROWID(resultSet.getString("ROWID"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return beanClass;
	}
}

package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ111_APAC_SEARCH_ACTION extends CommonAction{

	private UIData QUERY_DATA_TABLE;
	private List<PT_IL_RI_ALLOC> QUERY_DATA_LIST;
	private PT_IL_RI_ALLOC PT_IL_RI_ALLOC_BEAN;
	private PILQ111_APAC_SEARCH_BEAN SEARCH_BEAN;
	private HtmlCommandButton COMP_RI_ALLOC_INSERT_BUTTON;
	
	public UIData getQUERY_DATA_TABLE() {
		return QUERY_DATA_TABLE;
	}
	public void setQUERY_DATA_TABLE(UIData query_data_table) {
		QUERY_DATA_TABLE = query_data_table;
	}
	public List<PT_IL_RI_ALLOC> getQUERY_DATA_LIST() {
		return QUERY_DATA_LIST;
	}
	public void setQUERY_DATA_LIST(List<PT_IL_RI_ALLOC> query_data_list) {
		QUERY_DATA_LIST = query_data_list;
	}
	public PT_IL_RI_ALLOC getPT_IL_RI_ALLOC_BEAN() {
		return PT_IL_RI_ALLOC_BEAN;
	}
	public void setPT_IL_RI_ALLOC_BEAN(PT_IL_RI_ALLOC pt_il_ri_alloc_bean) {
		PT_IL_RI_ALLOC_BEAN = pt_il_ri_alloc_bean;
	}
	public PILQ111_APAC_SEARCH_BEAN getSEARCH_BEAN() {
		return SEARCH_BEAN;
	}
	public void setSEARCH_BEAN(PILQ111_APAC_SEARCH_BEAN search_bean) {
		SEARCH_BEAN = search_bean;
	}
	public HtmlCommandButton getCOMP_RI_ALLOC_INSERT_BUTTON() {
		return COMP_RI_ALLOC_INSERT_BUTTON;
	}
	public void setCOMP_RI_ALLOC_INSERT_BUTTON(
			HtmlCommandButton comp_ri_alloc_insert_button) {
		COMP_RI_ALLOC_INSERT_BUTTON = comp_ri_alloc_insert_button;
	}
	
	public PILQ111_APAC_SEARCH_ACTION(){
		QUERY_DATA_LIST = new ArrayList<PT_IL_RI_ALLOC>();
		PT_IL_RI_ALLOC_BEAN = new PT_IL_RI_ALLOC(); 
		SEARCH_BEAN = new PILQ111_APAC_SEARCH_BEAN();
	}

	public void fetchRiAllocList(){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			String query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_SEARCH_QUERY;
			PT_IL_RI_ALLOC bean = null;
			Object[] values = {SEARCH_BEAN.getPROD_CODE(),SEARCH_BEAN.getCOVER_CODE(),SEARCH_BEAN.getTTY_TYPE(),SEARCH_BEAN.getDIVN_CODE(),SEARCH_BEAN.getDEPT_CODE(),SEARCH_BEAN.getFM_DT(),SEARCH_BEAN.getTO_DT()};
			resultSet = handler.executeSelectStatement(query, connection, values);
			QUERY_DATA_LIST = new ArrayList<PT_IL_RI_ALLOC>();
			while(resultSet.next()){
				bean = new PT_IL_RI_ALLOC();
				bean.setROWID(resultSet.getString("ROWID"));
				bean.setRIA_PROD_CODE(resultSet.getString("RIA_PROD_CODE"));
				bean.setRIA_COVER_CODE(resultSet.getString("RIA_COVER_CODE"));
				bean.setRIA_TTY_TYPE(resultSet.getString("RIA_TTY_TYPE"));
				bean.setRIA_DIVN_CODE(resultSet.getString("RIA_DIVN_CODE"));
				bean.setRIA_DEPT_CODE(resultSet.getString("RIA_DEPT_CODE"));
				bean.setRIA_FM_DT(resultSet.getDate("RIA_FM_DT"));
				bean.setRIA_TO_DT(resultSet.getDate("RIA_TO_DT"));
				QUERY_DATA_LIST.add(bean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put("current",e.getMessage());
			getErrorMap().put("details",e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put("current",e.getMessage());
			getErrorMap().put("details",e.getMessage());
		}

	}
	
	public String redirect(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String rowId = request.getParameter("rowId");
		String forward = null;
		PILQ111_APAC_HELPER helper = new PILQ111_APAC_HELPER();
		try {
			helper.loadingBaseValues(rowId);
			forward = "navigateToRiAlloc";
		} catch (Exception e) {
			getErrorMap().put("current",new FacesMessage().getSummary());
			getErrorMap().put("details",new FacesMessage().getSummary());
		}
		
		return forward;
	}
	
	public String updateButtonAction(String rowId) {
		PILQ111_APAC_COMPOSITE_ACTION compositeAction = new PILQ111_APAC_COMPOSITE_ACTION();
		compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN().getWarningMap().clear();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILQ111_APAC_COMPOSITE_ACTION",
			compositeAction);
		compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN().getPT_IL_RI_ALLOC_BEAN()
			.setROWID(rowId);
		try {
			new PILQ111_APAC_HELPER().loadingBaseValues(rowId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		outcome = "navigateToRiAlloc";
		return outcome;
    }
	
	public String insertNewRiAlloc(){
		
		PILQ111_APAC_COMPOSITE_ACTION compositeAction = new PILQ111_APAC_COMPOSITE_ACTION();
		CommonUtils.setGlobalObject("PILQ111_APAC_COMPOSITE_ACTION", compositeAction);
		return "navigateToRiAlloc";
	}
	
	
	
	
	
}

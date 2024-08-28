package com.iii.pel.forms.PILM070_APAC;

import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM070_APAC_SEARCH_ACTION extends CommonAction{
  
	public String getCodeDesc(PP_LIFE_POL_SCH_PRN_ACTION actionBean,PP_LIFE_POL_SCH_PRN valueBean,String code){
		ResultSet rs =null;
		String condition=code;
		String query =null;
		String desc =null;
		try{
			query = "SELECT * FROM PM_NUMBER_GEN_SETUP"; 
			
			rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
			if(rs.next()){
				desc = rs.getString("NGS_DESC");
			}
			rs.close();	
		}catch(Exception er){
			er.printStackTrace();
		}
		return desc;
	}
	   public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	    public String updateButtonAction(String rowId) {
		PP_LIFE_POL_SCH_PRN_ACTION  pp_life_pol_sch_prn_action = new PP_LIFE_POL_SCH_PRN_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILM070_APAC_PP_LIFE_POL_SCH_PRN_ACTION",
			 pp_life_pol_sch_prn_action);
		 pp_life_pol_sch_prn_action.getPP_LIFE_POL_SCH_PRN_BEAN().setROWID(rowId);
	
		outcome = "PILM070_APAC_PP_LIFE_POL_SCH_PRN";
		return outcome;
    }
	
	/*public String fetch(){
		 delegate = new PP_LIFE_POL_SCH_PRN_DELEGATE();
		this.dataTableBean = delegate.fetchMasterBlock(this);
		return null;
	}*/
	 
	public String insertButtonAction(){
		 
	    PP_LIFE_POL_SCH_PRN_ACTION  pp_life_pol_sch_prn_action = new PP_LIFE_POL_SCH_PRN_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM070_APAC_PP_LIFE_POL_SCH_PRN_ACTION",
			 pp_life_pol_sch_prn_action);
		outcome = "PILM070_APAC_PP_LIFE_POL_SCH_PRN";
		CommonUtils.clearMaps( pp_life_pol_sch_prn_action);
		return  outcome;
	}
	 
}

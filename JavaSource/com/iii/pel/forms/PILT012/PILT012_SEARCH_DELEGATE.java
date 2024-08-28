package com.iii.pel.forms.PILT012;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILT012_SEARCH_DELEGATE {
	
	public ArrayList fetchMasterBlock(PILT012_SEARCH_ACTION searchAction){
		ArrayList<PILT012_SEARCH_BEAN> masterList = new ArrayList<PILT012_SEARCH_BEAN>();
		PILT012_SEARCH_BEAN searchBean = searchAction.getSearchBean();
		String RCR_POL_NO = searchBean.getRCR_POL_NO();
		String RCR_CLM_NO = searchBean.getRCR_CLM_NO();
		String query = null;
		ResultSet rs = null;
		System.out.println("The pol code: "+RCR_POL_NO);
		if((RCR_POL_NO == null || "".equals(RCR_POL_NO)) && (RCR_CLM_NO==null || "".equals(RCR_CLM_NO))){
			query = "SELECT ROWID, RCR_POL_NO, RCR_CLM_NO, RCR_CLM_COVER_CODE FROM PS_IL_RI_CLAIM_REG";
		}else if((RCR_POL_NO != null || !"".equals(RCR_POL_NO)) && (RCR_CLM_NO==null || "".equals(RCR_CLM_NO))){
			query = "SELECT ROWID, RCR_POL_NO, RCR_CLM_NO, RCR_CLM_COVER_CODE FROM PS_IL_RI_CLAIM_REG WHERE RCR_POL_NO LIKE '"+RCR_POL_NO+"'";
		}else if((RCR_POL_NO == null || "".equals(RCR_POL_NO)) && (RCR_CLM_NO !=null || !"".equals(RCR_CLM_NO))){
			query = "SELECT ROWID, RCR_POL_NO, RCR_CLM_NO, RCR_CLM_COVER_CODE FROM PS_IL_RI_CLAIM_REG WHERE RCR_CLM_NO LIKE '"+RCR_CLM_NO+"'";
		}else if((RCR_POL_NO != null || !"".equals(RCR_POL_NO)) && (RCR_CLM_NO !=null || !"".equals(RCR_CLM_NO))){
			query = "SELECT ROWID, RCR_POL_NO, RCR_CLM_NO, RCR_CLM_COVER_CODE FROM PS_IL_RI_CLAIM_REG WHERE RCR_POL_NO LIKE '"+RCR_POL_NO+"'"+
					" AND RCR_CLM_NO LIKE '"+RCR_CLM_NO+"'";
		}
		try{
			System.out.println("The query is: "+query);
			rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while(rs.next()){
				PILT012_SEARCH_BEAN secondSearchBean = new PILT012_SEARCH_BEAN();
				secondSearchBean.setRCR_POL_NO(rs.getString("RCR_POL_NO"));
				secondSearchBean.setRCR_CLM_NO(rs.getString("RCR_CLM_NO"));
				secondSearchBean.setRCR_CLM_COVER_CODE(rs.getString("RCR_CLM_COVER_CODE"));
				secondSearchBean.setROWID(rs.getString("ROWID"));
				masterList.add(secondSearchBean);
			}
			rs.close();
		}catch(Exception er){
			er.printStackTrace();
		}
		return masterList;

	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
}




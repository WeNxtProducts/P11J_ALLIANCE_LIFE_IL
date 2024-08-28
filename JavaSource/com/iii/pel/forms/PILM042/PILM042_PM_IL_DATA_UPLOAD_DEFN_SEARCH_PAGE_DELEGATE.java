package com.iii.pel.forms.PILM042;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_DELEGATE {

	public List listAllRecords() {
		List recordList = null;
		CommonUtils util = new CommonUtils();
		CRUDHandler	handler = null;
		Connection con = null;
		ResultSet rst = null;
		PM_IL_DATA_UPLOAD_DEFN_HDR listBean = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				recordList=new ArrayList<PM_IL_DATA_UPLOAD_DEFN_HDR>();
				String selectQuery = PILM042_QUERY_CONSTANTS.SELECT_ALL_PM_IL_DATA_UPLOAD_DEFN_HDR_SETUP;
				String mappedBeanName="PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION";
				PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION actionbean = (PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION)util.getMappedBeanFromSession(mappedBeanName);
				String definitionCode= actionbean.getPILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE1();
				if(!(definitionCode==null) && !(definitionCode.trim().length()== 0)){
					selectQuery = selectQuery.replace("{0}", "WHERE DUDH_DEF_CODE LIKE '"+definitionCode+"%'");
				}else{
					selectQuery = selectQuery.replace("{0}", "");
				}
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					listBean = new PM_IL_DATA_UPLOAD_DEFN_HDR();
					
					listBean.setROWID(rst.getString(1));
					listBean.setDUDH_DEF_CODE(rst.getString("DUDH_DEF_CODE"));                                   
					listBean.setDUDH_DESC(rst.getString("DUDH_DESC"));                                           
					listBean.setDUDH_SHORT_DESC(rst.getString("DUDH_SHORT_DESC"));                               
					listBean.setDUDH_LONG_DESC(rst.getString("DUDH_LONG_DESC"));                                 
					listBean.setDUDH_BL_DESC(rst.getString("DUDH_BL_DESC"));                                     
					listBean.setDUDH_BL_SHORT_DESC(rst.getString("DUDH_BL_SHORT_DESC"));                         
					listBean.setDUDH_BL_LONG_DESC(rst.getString("DUDH_BL_LONG_DESC"));                           
					listBean.setDUDH_EFF_FM_DT(rst.getDate("DUDH_EFF_FM_DT"));                                   
					listBean.setDUDH_EFF_TO_DT(rst.getDate("DUDH_EFF_TO_DT"));                                   
					listBean.setDUDH_CR_DT(rst.getDate("DUDH_CR_DT"));                                           
					listBean.setDUDH_CR_UID(rst.getString("DUDH_CR_UID"));                                       
					listBean.setDUDH_UPD_DT(rst.getDate("DUDH_UPD_DT"));                                         
					listBean.setDUDH_UPD_UID(rst.getString("DUDH_UPD_UID"));
					
					recordList.add(listBean);
				}
				System.out.println("Bean Size \t" + recordList.size());
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(rst!= null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recordList;
	}
	
	public PM_IL_DATA_UPLOAD_DEFN_HDR nameList(String rowid) {
		CommonUtils util = new CommonUtils();
		CRUDHandler	handler = null;
		Connection con = null;
		ResultSet rst = null;
		PM_IL_DATA_UPLOAD_DEFN_HDR listBean = null;
		System.out.println("rowidrowidrowidrowid --"+rowid);
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				String selectQuery = PILM042_QUERY_CONSTANTS.SELECT_ALL_PM_IL_DATA_UPLOAD_DEFN_HDR_SETUP1;
				String mappedBeanName="PILM042_PM_IL_DATA_UPLOAD_DEFN_SEARCH_PAGE_ACTION";
				System.out.println(selectQuery);
				Object[] values = { rowid };
				rst = handler.executeSelectStatement(selectQuery, con,values);
				while(rst.next()){
					listBean = new PM_IL_DATA_UPLOAD_DEFN_HDR();
					
					listBean.setROWID(rst.getString(1));
					listBean.setDUDH_DEF_CODE(rst.getString("DUDH_DEF_CODE"));                                   
					listBean.setDUDH_DESC(rst.getString("DUDH_DESC"));                                           
					listBean.setDUDH_SHORT_DESC(rst.getString("DUDH_SHORT_DESC"));                               
					listBean.setDUDH_LONG_DESC(rst.getString("DUDH_LONG_DESC"));                                 
					listBean.setDUDH_BL_DESC(rst.getString("DUDH_BL_DESC"));                                     
					listBean.setDUDH_BL_SHORT_DESC(rst.getString("DUDH_BL_SHORT_DESC"));                         
					listBean.setDUDH_BL_LONG_DESC(rst.getString("DUDH_BL_LONG_DESC"));                           
					listBean.setDUDH_EFF_FM_DT(rst.getDate("DUDH_EFF_FM_DT"));                                   
					listBean.setDUDH_EFF_TO_DT(rst.getDate("DUDH_EFF_TO_DT"));                                   
					listBean.setDUDH_CR_DT(rst.getDate("DUDH_CR_DT"));                                           
					listBean.setDUDH_CR_UID(rst.getString("DUDH_CR_UID"));                                       
					listBean.setDUDH_UPD_DT(rst.getDate("DUDH_UPD_DT"));                                         
					listBean.setDUDH_UPD_UID(rst.getString("DUDH_UPD_UID"));
					
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(rst!= null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listBean;
	}
}

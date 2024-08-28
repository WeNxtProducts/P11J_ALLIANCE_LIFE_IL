package com.iii.pel.forms.PM078_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_LIFE_WAKALAH_HDR_HELPER {
	public void WHEN_VALIDATE_ITEM_WAKS_PCODE(PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr) throws Exception{
		DBProcedures dbProcedures = null;
		String P_PROD_DESC = null;
		ArrayList<String> prodDesc = null;
		PM078_A_Procedures procedures = null;
		try{
			dbProcedures = new DBProcedures();
			procedures = new PM078_A_Procedures();
			if("GI".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				prodDesc = new ArrayList<String>();
				prodDesc = dbProcedures.P_VAL_SC(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE(), P_PROD_DESC, "N", "E");
				pm_life_wakalah_hdr.setUI_M_WAKS_PRODUCT_CODE(prodDesc.get(0));
			}else if("IL".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				P_PROD_DESC = procedures.L_VAL_PRODUCT(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE(), "E");
				pm_life_wakalah_hdr.setUI_M_WAKS_PRODUCT_CODE(P_PROD_DESC);
			}
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	public ArrayList<SelectItem> WAKS_MODULELIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.ModuleCode_Values;
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				list.add(selectItem);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<LovBean> prepareLOVPCODE(String productCode, String module) throws Exception{
		ArrayList<LovBean> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		Object[] objects = null;
		String queryValue = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<LovBean>();
			if("GI".equals(module)){
				if("*".equalsIgnoreCase(productCode)){
					objects = new Object[] { 20 };
					query = PM078_A_QUERYCONSTANTS.SubClassCode;
				}else{
					objects = new Object[] { productCode + "%", productCode + "%", 20 };
					query = PM078_A_QUERYCONSTANTS.SubClassCodeLike;
				}
			}else if("IL".equals(module)){
				if("*".equalsIgnoreCase(productCode)){
					objects = new Object[] { 20 };
					query = PM078_A_QUERYCONSTANTS.ProductCode;
				}else{
					objects = new Object[] { productCode + "%", productCode + "%", 20 };
					query = PM078_A_QUERYCONSTANTS.ProductCodeLike;
				}
			}
			resultSet = handler.executeSelectStatement(query, connection, objects);
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				list.add(lovBean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
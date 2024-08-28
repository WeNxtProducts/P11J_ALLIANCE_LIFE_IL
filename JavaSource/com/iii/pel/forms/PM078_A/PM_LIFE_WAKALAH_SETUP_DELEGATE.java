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
public class PM_LIFE_WAKALAH_SETUP_DELEGATE { 
	public void executeSelectStatement (PM078_A_COMPOSITE_ACTION compositeAction)
	throws Exception { 
		PM_LIFE_WAKALAH_HDR headerBean = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
			getPM_LIFE_WAKALAH_HDR_BEAN();
		String hdrQuery= "SELECT WAKS_MODULE, WAKS_PRODUCT_CODE, WAKS_FRZ_FLAG FROM " +
				"PM_LIFE_WAKALAH_SETUP WHERE ROWID = '"+headerBean.getROWID()+"'";
		
		Connection connection=null;
		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		String selectStatement = null;
		String P_PROD_DESC = null;
		ArrayList<String> prodDesc = new ArrayList<String>();
		DBProcedures dbProcedures = new DBProcedures();
		PM078_A_Procedures procedures = new PM078_A_Procedures();
		String WAKS_MODULE = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN().getWAKS_MODULE();
		String WAKS_PRODUCT_CODE = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN().getWAKS_PRODUCT_CODE();
		compositeAction.getPM_LIFE_WAKALAH_SETUP_ACTION_BEAN().getDataList_PM_LIFE_WAKALAH_SETUP().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(hdrQuery,connection);
			if(resultSet.next()){
				PM_LIFE_WAKALAH_HDR PM_LIFE_WAKALAH_HDR_BEAN = new PM_LIFE_WAKALAH_HDR();
				WAKS_MODULE = resultSet.getString(1);
				PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_MODULE(WAKS_MODULE);
				WAKS_PRODUCT_CODE = resultSet.getString(2);
				PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_PRODUCT_CODE(WAKS_PRODUCT_CODE);
				PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_FRZ_FLAG(resultSet.getString(3));
				if("GI".equals(PM_LIFE_WAKALAH_HDR_BEAN.getWAKS_MODULE())){
					prodDesc = dbProcedures.P_VAL_SC(PM_LIFE_WAKALAH_HDR_BEAN.getWAKS_PRODUCT_CODE(),
							PM_LIFE_WAKALAH_HDR_BEAN.getUI_M_WAKS_PRODUCT_CODE(), "N", "N");
					PM_LIFE_WAKALAH_HDR_BEAN.setUI_M_WAKS_PRODUCT_CODE(prodDesc.get(0));
					if(prodDesc != null){
						
					}
				}else if("IL".equals(PM_LIFE_WAKALAH_HDR_BEAN.getWAKS_MODULE())){
					P_PROD_DESC = procedures.L_VAL_PRODUCT(PM_LIFE_WAKALAH_HDR_BEAN.getWAKS_PRODUCT_CODE(), "N");
					PM_LIFE_WAKALAH_HDR_BEAN.setUI_M_WAKS_PRODUCT_CODE(P_PROD_DESC);
				}
				compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
					setPM_LIFE_WAKALAH_HDR_BEAN(PM_LIFE_WAKALAH_HDR_BEAN);
			}
			selectStatement="SELECT ROWID, PM_LIFE_WAKALAH_SETUP.* FROM PM_LIFE_WAKALAH_SETUP " +
				"WHERE WAKS_MODULE = ? AND WAKS_PRODUCT_CODE = ? ";
			resultSet1=new CRUDHandler().executeSelectStatement(selectStatement,
					connection,
					new Object[]{WAKS_MODULE, WAKS_PRODUCT_CODE});
			while (resultSet1.next()) {
				PM_LIFE_WAKALAH_SETUP PM_LIFE_WAKALAH_SETUP_BEAN = new PM_LIFE_WAKALAH_SETUP();
				PM_LIFE_WAKALAH_SETUP_BEAN.setROWID(resultSet1.getString("ROWID"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_MODULE(resultSet1.getString("WAKS_MODULE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_PRODUCT_CODE(resultSet1.getString("WAKS_PRODUCT_CODE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_COVER_CODE(resultSet1.getString("WAKS_COVER_CODE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXPENSE_PERC(resultSet1.getDouble("WAKS_EXPENSE_PERC"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_SPL_FUND(resultSet1.getDouble("WAKS_SPL_FUND"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_PRO_ON_INVEST(resultSet1.getDouble("WAKS_PRO_ON_INVEST"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_PAR_SHARE_OF_SUR(resultSet1.
						getDouble("WAKS_PAR_SHARE_OF_SUR"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_ADMIN_CHARGES(resultSet1.getDouble("WAKS_ADMIN_CHARGES"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_INV_PROFIT_SHARE(resultSet1.
						getDouble("WAKS_INV_PROFIT_SHARE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_CHARGE_MODE(resultSet1.getString("WAKS_CHARGE_MODE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_FRZ_FLAG(resultSet1.getString("WAKS_FRZ_FLAG"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_CR_DT(resultSet1.getDate("WAKS_CR_DT"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_CR_UID(resultSet1.getString("WAKS_CR_UID"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_UPD_DT(resultSet1.getDate("WAKS_UPD_DT"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_UPD_UID(resultSet1.getString("WAKS_UPD_UID"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EFF_FM_DT(resultSet1.getDate("WAKS_EFF_FM_DT"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EFF_TO_DT(resultSet1.getDate("WAKS_EFF_TO_DT"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_SPLFUND_MODE(resultSet1.getString("WAKS_SPLFUND_MODE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXPNS_MODE(resultSet1.getString("WAKS_EXPNS_MODE"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_ADMIN_RATE_PER(resultSet1.
						getDouble("WAKS_ADMIN_RATE_PER"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_ALLOC_TARIFF(resultSet1.getString("WAKS_ALLOC_TARIFF"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_ADMIN_TARIFF(resultSet1.getString("WAKS_ADMIN_TARIFF"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_ZERO_PREM_YN(resultSet1.getString("WAKS_ZERO_PREM_YN"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_FIXED_EXPNS(resultSet1.getDouble("WAKS_FIXED_EXPNS"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_RISK_CALC_MTHD(resultSet1.
						getString("WAKS_RISK_CALC_MTHD"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXP_CALC_MTHD(resultSet1.getString("WAKS_EXP_CALC_MTHD"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_RISK_LOAD_YN(resultSet1.getString("WAKS_RISK_LOAD_YN"));
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_FIXED_AMT(resultSet1.getDouble("WAKS_FIXED_AMT"));

				compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN()
					.setWAKS_FRZ_FLAG(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_FRZ_FLAG());
				compositeAction.getPM_LIFE_WAKALAH_SETUP_ACTION_BEAN().
					getDataList_PM_LIFE_WAKALAH_SETUP().add(PM_LIFE_WAKALAH_SETUP_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
		} 
	} 
	public ArrayList<SelectItem> WAKS_CHARGE_MODELIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.ChargeMode_Values;
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
	
	public ArrayList<SelectItem> WAKS_RISK_LOAD_YNLIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.RiskLoad_YN_Values;
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
	
	public ArrayList<SelectItem> WAKS_RISK_CALC_MTHDLIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.RiskCalcMTHD_Values;
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
	
	public ArrayList<SelectItem> WAKS_ZERO_PREM_YNLIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.ZeroPrem_YN_Values;
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
	
	public ArrayList<SelectItem> WAKS_EXP_CALC_MTHDLIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PM078_A_QUERYCONSTANTS.WaksExpCalc_MTHD_Values;
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
	public ArrayList<LovBean> prepareLOV(String CoverCode) throws Exception{
		ArrayList<LovBean> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		Object[] objects = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<LovBean>();
			
			if("*".equalsIgnoreCase(CoverCode)){
				objects = new Object[] { 20 };
				query = PM078_A_QUERYCONSTANTS.CoverCode;

			}else{
				objects = new Object[] { CoverCode + "%", CoverCode + "%", 20 };
				query = PM078_A_QUERYCONSTANTS.CoverCodeLike;
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
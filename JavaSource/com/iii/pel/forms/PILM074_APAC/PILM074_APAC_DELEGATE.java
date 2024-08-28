package com.iii.pel.forms.PILM074_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM074_APAC_DELEGATE {
	
	/**
	 * 
	 * @param formName
	 * @param blackName
	 * @param filedName
	 * @return
	 * @throws DBException
	 */
	public ArrayList<SelectItem> selectValueForComboBox(String formName, String blackName, String filedName) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet=null;
		ArrayList<SelectItem> drpDwn = null;

		try {
			connection = CommonUtils.getConnection();
			Object[] inputValueList = {formName,blackName,filedName};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_COMBOBOXVALUE, connection, inputValueList);
			drpDwn = new ArrayList<SelectItem>();
			while(resultSet.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}

	public ArrayList<PM_LIFE_TAX_HEADER> prepareTaxTypeList(String taxType,
			ArrayList<PM_LIFE_TAX_HEADER> taxTypeList) {
		Connection connection = null;
		String selectQuery = null;

		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(taxType)) {
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_TAX_TYPE_LOV;
				Object[] object={PILM074_APAC_CONSTANTS.ROW_NUM};
				taxTypeList = taxTypeLOV(connection, selectQuery, object);
			} else {
				taxType = taxType.toUpperCase() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={taxType,PILM074_APAC_CONSTANTS.ROW_NUM};
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_TAX_TYPE_LOV_LIKE;
				taxTypeList = taxTypeLOV(connection, selectQuery,object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return taxTypeList;
	}

	/**
	 * List returning TaxType Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	public ArrayList<PM_LIFE_TAX_HEADER> taxTypeLOV(Connection connection,String query,Object[] object)
	{
		ArrayList<PM_LIFE_TAX_HEADER> taxTypeList = new ArrayList<PM_LIFE_TAX_HEADER>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
		{
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_LIFE_TAX_HEADER taxType = new PM_LIFE_TAX_HEADER();
				taxType.setTH_TAX_TYPE(resultSet.getString(1));
				taxType.setTH_TAX_DESC(resultSet.getString(2));
				taxTypeList.add(taxType);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return taxTypeList;
	}
	/**
	 * Returns TaxType Description for Code and codeList
	 * 
	 * @param TaxType
	 * @param TaxTypeList
	 * @return
	 */
	public String getTaxTypeDesc(String taxType,
			ArrayList<PM_LIFE_TAX_HEADER> taxTypeList) {
		Iterator<PM_LIFE_TAX_HEADER> iterator = taxTypeList.iterator();
		String taxTypeDesc = null;
		while(iterator.hasNext())
		{
			PM_LIFE_TAX_HEADER bean =(PM_LIFE_TAX_HEADER)iterator.next();
			if(taxType.equalsIgnoreCase(bean.getTH_TAX_TYPE()))
			{
				taxTypeDesc = bean.getTH_TAX_DESC();
			}
		}
		return taxTypeDesc;
	}

	public ArrayList<PM_LIFE_TAX_HEADER> fetchLifeTaxSearchDetails(
			LifeTaxSetUpSearchPageActionBean lifeTaxSetUpSearchPageActionBean) {
		ArrayList<PM_LIFE_TAX_HEADER> lifeTaxList = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler=new CRUDHandler();
		PM_LIFE_TAX_HEADER lifeTaxBean =  null;
		String query = null;

		String taxType =  lifeTaxSetUpSearchPageActionBean.getTaxType() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
		String taxTypeDesc =  lifeTaxSetUpSearchPageActionBean.getTaxTypeDesc() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;

		try {
			connection = CommonUtils.getConnection();
			query = PILM074_APAC_QUERY_CONSTANTS.SELECT_SEARCH_DETAILS;
			Object[] objects = {taxType, taxTypeDesc};
			resultSet = handler.executeSelectStatement(query, connection,objects);
			if(resultSet != null){

				lifeTaxList = new ArrayList<PM_LIFE_TAX_HEADER>();
				while(resultSet.next()){
					lifeTaxBean = new PM_LIFE_TAX_HEADER();
					lifeTaxBean.setROWID(resultSet.getString(1));
					lifeTaxBean.setTH_TAX_TYPE(resultSet.getString(2));
					lifeTaxBean.setTH_TAX_DESC(resultSet.getString(3));
					lifeTaxList.add(lifeTaxBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lifeTaxList;
}

	public PM_LIFE_TAX_HEADER fetchLifeTaxHeadDetails(String rowId) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_LIFE_TAX_HEADER lifeTaxBean = null;
		
		try{
			connection = CommonUtils.getConnection();
			Object[] values = {rowId};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_LIFE_TAX_SETUP, connection, values);
			if (resultSet != null) {
				lifeTaxBean = new PM_LIFE_TAX_HEADER();
				if (resultSet.next()) {
					lifeTaxBean.setROWID(resultSet.getString("ROWID"));
					lifeTaxBean.setTH_TAX_TYPE(resultSet.getString("TH_TAX_TYPE"));
					lifeTaxBean.setTH_TAX_DESC(resultSet.getString("TH_TAX_DESC"));
					lifeTaxBean.setTH_TAX_LONG_DESC(resultSet.getString("TH_TAX_LONG_DESC"));
					lifeTaxBean.setTH_TAX_SHORT_DESC(resultSet.getString("TH_TAX_SHORT_DESC"));
					lifeTaxBean.setTH_TAX_CALC_TYPE(resultSet.getString("TH_TAX_CALC_TYPE"));
					lifeTaxBean.setTH_EFF_FM_DT(resultSet.getDate("TH_EFF_FM_DT"));
					lifeTaxBean.setTH_EFF_TO_DT(resultSet.getDate("TH_EFF_TO_DT"));
					//Added by kavitha on 07.10.2019
					lifeTaxBean.setTH_LOCATION(resultSet.getString("TH_LOCATION"));
					lifeTaxBean.setTH_VAT_YN(resultSet.getString("TH_VAT_YN"));
					lifeTaxBean.setTH_VAT_PERC(resultSet.getInt("TH_VAT_PERC"));
					lifeTaxBean.setTH_VAT_TRTMT(resultSet.getString("TH_VAT_TRTMT"));
					lifeTaxBean.setTH_SELF_INVOICE_YN(resultSet.getString("TH_SELF_INVOICE_YN"));
					//Added by senthilnathan on 17.10.19
					lifeTaxBean.setTH_VAT_RECOVER_YN(resultSet.getString("TH_VAT_RECOVER_YN"));
					
				}
			}
		}catch (Exception e) {
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return lifeTaxBean;
	}

	public ArrayList<PM_LIFE_TAX_APPL_PROD> fetchLifeTaxProduct(String taxType) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_LIFE_TAX_APPL_PROD lifeTaxBean = null;
		ArrayList<PM_LIFE_TAX_APPL_PROD> productList = null ;
		
		try{
			connection = CommonUtils.getConnection();
			Object[] values = {taxType};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_LIFE_TAX_PRODUCT, connection, values);
			if (resultSet != null) {
				productList = new ArrayList<PM_LIFE_TAX_APPL_PROD>();
				while (resultSet.next()) {
					lifeTaxBean = new PM_LIFE_TAX_APPL_PROD();
					lifeTaxBean.setROWID(resultSet.getString("ROWID"));
					lifeTaxBean.setTAP_TH_TAX_TYPE(resultSet.getString("TAP_TH_TAX_TYPE"));
					lifeTaxBean.setTAP_PROD_CODE(resultSet.getString("TAP_PROD_CODE"));
					lifeTaxBean.setTAP_EFF_FM_DT(resultSet.getDate("TAP_EFF_FM_DT"));
					lifeTaxBean.setTAP_EFF_TO_DT(resultSet.getDate("TAP_EFF_TO_DT"));
					//Added by kavitha on 04.10.2019
					lifeTaxBean.setTAP_PROD_CODE_TO(resultSet.getString("TAP_PROD_CODE_TO"));
					lifeTaxBean.setTAP_RIDER_FM(resultSet.getString("TAP_RIDER_FM"));
					lifeTaxBean.setTAP_RIDER_TO(resultSet.getString("TAP_RIDER_TO"));
					/*added by senthilnathan for orient*/
					lifeTaxBean.setTAP_CHANNEL_FM(resultSet.getString("TAP_CHANNEL_FM"));
					lifeTaxBean.setTAP_CHANNEL_TO(resultSet.getString("TAP_CHANNEL_TO"));
					
					 if(lifeTaxBean.getTAP_PROD_CODE_TO()!=null)	{
						 String query = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE= ? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query, connection, new Object[] {lifeTaxBean.getTAP_PROD_CODE_TO()});
						 if(rs1.next()){
							 lifeTaxBean.setTAP_PROD_CODE_TO_DESC(rs1.getString("PROD_DESC"));
						 }
					 }
					
					 if(lifeTaxBean.getTAP_RIDER_FM()!=null)	{
						 String query_emirates = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE = 'A' AND COVER_CODE= ? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query_emirates, connection, new Object[] {lifeTaxBean.getTAP_RIDER_FM()});
						 if(rs1.next()){
							 lifeTaxBean.setTAP_RIDER_FM_DESC(rs1.getString("COVER_DESC"));
						 }
					 }
					 if(lifeTaxBean.getTAP_RIDER_TO()!=null)	{
						 String query_emirates = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE = 'A' AND COVER_CODE= ? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query_emirates, connection, new Object[] {lifeTaxBean.getTAP_RIDER_TO()});
						 if(rs1.next()){
							 lifeTaxBean.setTAP_RIDER_TO_DESC(rs1.getString("COVER_DESC"));
						 }
					 }
					 if(lifeTaxBean.getTAP_CHANNEL_FM()!=null)	{
						 String query = " SELECT CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE CCLAS_CODE =? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query, connection, new Object[] {lifeTaxBean.getTAP_CHANNEL_FM()});
						 if(rs1.next()){
							 lifeTaxBean.setTAP_CHANNEL_FM_DESC(rs1.getString("CCLAS_CLASS_DESC"));
						 }
					 }
					 if(lifeTaxBean.getTAP_CHANNEL_TO()!=null)	{
						 String query = " SELECT CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE CCLAS_CODE =? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query, connection, new Object[] {lifeTaxBean.getTAP_CHANNEL_TO()});
						 if(rs1.next()){
							 lifeTaxBean.setTAP_CHANNEL_TO_DESC(rs1.getString("CCLAS_CLASS_DESC"));
						 }
					 }
					lifeTaxBean.setRowSelected(false);
					productList.add(lifeTaxBean);
				}
			}
		}catch (Exception e) {
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return productList;
	}

	public ArrayList<PM_LIFE_TAX_APPL_CUST> fetchLifeTaxClass(String taxType) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_LIFE_TAX_APPL_CUST lifeTaxBean = null;
		ArrayList<PM_LIFE_TAX_APPL_CUST> classList = null ;
		
		try{
			connection = CommonUtils.getConnection();
			Object[] values = {taxType};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_LIFE_TAX_CLASS, connection, values);
			if (resultSet != null) {
				classList = new ArrayList<PM_LIFE_TAX_APPL_CUST>();
				while (resultSet.next()) {
					lifeTaxBean = new PM_LIFE_TAX_APPL_CUST();
					lifeTaxBean.setROWID(resultSet.getString("ROWID"));
					lifeTaxBean.setTAC_TH_TAX_TYPE(resultSet.getString("TAC_TH_TAX_TYPE"));
					lifeTaxBean.setTAC_CUST_CLASS(resultSet.getString("TAC_CUST_CLASS"));
					lifeTaxBean.setTAC_EFF_FM_DT(resultSet.getDate("TAC_EFF_FM_DT"));
					lifeTaxBean.setTAC_EFF_TO_DT(resultSet.getDate("TAC_EFF_TO_DT"));
					//Added by kavitha on 07.10.2019
					lifeTaxBean.setTAC_CUST_CLASS_TO(resultSet.getString("TAC_CUST_CLASS_TO"));
					if(lifeTaxBean.getTAC_CUST_CLASS_TO()!=null)	{
						 String query_emirates = "SELECT CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE CCLAS_CODE= ? ";
						 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
								 query_emirates, connection, new Object[] {lifeTaxBean.getTAC_CUST_CLASS_TO()});
						 if(rs1.next()){
							 lifeTaxBean.setTAC_CUST_CLASS_TO_DESC(rs1.getString("CCLAS_CLASS_DESC"));
						 }
					 }
					
					lifeTaxBean.setRowSelected(false);
					classList.add(lifeTaxBean);
				}
			}
		}catch (Exception e) {
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return classList;
	}

	public ArrayList<PM_LIFE_TAX_APPL_PROD> prepareProductCodeLov(
			String productCode, ArrayList<PM_LIFE_TAX_APPL_PROD> productCodeLov) {
		Connection connection = null;
		String selectQuery = null;

		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(productCode)) {
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_PRODUCT_CODE_LOV;
				Object[] object={PILM074_APAC_CONSTANTS.ROW_NUM};
				productCodeLov = productCodeLOV(connection, selectQuery, object);
			} else {
				productCode = productCode.toUpperCase() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={productCode,PILM074_APAC_CONSTANTS.ROW_NUM};
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_PRODUCT_CODE_LOV_LIKE;
				productCodeLov = productCodeLOV(connection, selectQuery,object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return productCodeLov;
	}
	
	/**
	 * List returning Product Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	public ArrayList<PM_LIFE_TAX_APPL_PROD> productCodeLOV(Connection connection,String query,Object[] object)
	{
		ArrayList<PM_LIFE_TAX_APPL_PROD> productCodeList = new ArrayList<PM_LIFE_TAX_APPL_PROD>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
		{
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_LIFE_TAX_APPL_PROD productCode = new PM_LIFE_TAX_APPL_PROD();
				productCode.setTAP_PROD_CODE(resultSet.getString(1));
				productCode.setTAP_PROD_CODE_DESC(resultSet.getString(2));
				productCodeList.add(productCode);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productCodeList;
	}

	public ArrayList<PM_LIFE_TAX_APPL_CUST> prepareCustCodeLov(String custCode,
			ArrayList<PM_LIFE_TAX_APPL_CUST> custCodeLov) {
		Connection connection = null;
		String selectQuery = null;

		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(custCode)) {
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CODE_LOV;
				Object[] object={PILM074_APAC_CONSTANTS.ROW_NUM};
				custCodeLov = custCodeLov(connection, selectQuery, object);
			} else {
				custCode = custCode.toUpperCase() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={custCode,PILM074_APAC_CONSTANTS.ROW_NUM};
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CODE_LOV_LIKE;
				custCodeLov = custCodeLov(connection, selectQuery,object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return custCodeLov;
	}

	private ArrayList<PM_LIFE_TAX_APPL_CUST> custCodeLov(Connection connection,
			String selectQuery, Object[] object) {
		ArrayList<PM_LIFE_TAX_APPL_CUST> custCodeList = new ArrayList<PM_LIFE_TAX_APPL_CUST>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
		{
			resultSet=handler.executeSelectStatement(selectQuery,connection,object);
			while(resultSet.next())
			{
				PM_LIFE_TAX_APPL_CUST custCode = new PM_LIFE_TAX_APPL_CUST();
				custCode.setTAC_CUST_CLASS(resultSet.getString(1));
				custCode.setTAC_CUST_CLASS_DESC(resultSet.getString(2));
				custCodeList.add(custCode);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custCodeList;
	}

	public int updateLifeTaxProductDetails(PM_LIFE_TAX_APPL_PROD gridValueBean) {

		int rowUpdated = 0;
		Connection con = null;
		CRUDHandler handler = null;
		try {
			con =CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(gridValueBean, con);;
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public int deleteLifeTaxProduct(PM_LIFE_TAX_APPL_PROD gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public int deleteLifeTaxClass(PM_LIFE_TAX_APPL_CUST gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public int updateLifeTaxClassDetails(PM_LIFE_TAX_APPL_CUST gridValueBean) {
		int rowUpdated = 0;
		Connection con = null;
		CRUDHandler handler = null;
		try {
			con =CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(gridValueBean, con);;
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public void deleteLifeTaxHeader(PM_LIFE_TAX_HEADER_ACTION action) {
		PM_LIFE_TAX_HEADER bean = action.getPM_LIFE_TAX_HEADER_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String custResult = null;
		String productResult = null;
		
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {bean.getTH_TAX_TYPE()};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.CHECK_CUST_DELETE, connection,values);
			if (resultSet.next()) {
				custResult = resultSet.getString(1);
			}

			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.CHECK_PRODUCT_DELETE, connection, values);
			if (resultSet.next()) {
				productResult = resultSet.getString(1);
			}
			
			if ("1".equals(productResult) || "1".equals(custResult)) {
				action.getErrorMap().put("current", PILM074_APAC_CONSTANTS.DELETE_CUST);
			}else{
				action.getErrorMap().clear();
				int delete = handler.executeDelete(bean, connection);
				if (delete == 1) {
					CommonUtils.getConnection().commit();
					action.getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
					action.getWarningMap().put("detail", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
					action.setPM_LIFE_TAX_HEADER_BEAN(new PM_LIFE_TAX_HEADER());
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PM_LIFE_TAX_APPL_PROD> prepareChanCodeLov(String custCode,
			ArrayList<PM_LIFE_TAX_APPL_PROD> chanCodeLov) {
		Connection connection = null;
		String selectQuery = null;

		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(custCode)) {
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CODE_LOV;
				Object[] object={PILM074_APAC_CONSTANTS.ROW_NUM};
				chanCodeLov = chanCodeLov(connection, selectQuery, object);
			} else {
				custCode = custCode.toUpperCase() + PILM074_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={custCode,PILM074_APAC_CONSTANTS.ROW_NUM};
				selectQuery = PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CODE_LOV_LIKE;
				chanCodeLov = chanCodeLov(connection, selectQuery,object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		return chanCodeLov;
	}
	
	
	private ArrayList<PM_LIFE_TAX_APPL_PROD> chanCodeLov(Connection connection,
			String selectQuery, Object[] object) {
		ArrayList<PM_LIFE_TAX_APPL_PROD> custCodeList = new ArrayList<PM_LIFE_TAX_APPL_PROD>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
		{
			resultSet=handler.executeSelectStatement(selectQuery,connection,object);
			while(resultSet.next())
			{
				PM_LIFE_TAX_APPL_PROD custCode = new PM_LIFE_TAX_APPL_PROD();
				custCode.setTAP_CHANNEL_FM(resultSet.getString(1));
				custCode.setTAP_CHANNEL_FM_DESC(resultSet.getString(2));
				custCodeList.add(custCode);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custCodeList;
	}
}

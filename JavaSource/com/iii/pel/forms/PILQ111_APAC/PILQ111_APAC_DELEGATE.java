package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ111_APAC_DELEGATE {
	
	public void fetchRiAllocDetails(String rowId, PILQ111_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		PT_IL_RI_ALLOC bean = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN().getPT_IL_RI_ALLOC_BEAN();
		CRUDHandler handler = new CRUDHandler();
		Object[] values = {rowId}; 
		String query = PILQ111_APAC_SQL_QUERY_CONSTANTS.FETCH_RI_ALLOC_RECORDS_QUERY;
		ResultSet resultSet = null;
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next()){
				System.out.println("ROW_ID ::::"+ rowId);
				bean.setROWID(rowId);
				bean.setRIA_SYS_ID(resultSet.getDouble("RIA_SYS_ID"));
				System.out.println("RIA_SYS_ID>>>>" +bean.getRIA_SYS_ID());
				bean.setRIA_TTY_CODE(resultSet.getString("RIA_TTY_CODE"));
				bean.setRIA_SRNO(resultSet.getDouble("RIA_SRNO"));
				bean.setRIA_TTY_TYPE(resultSet.getString("RIA_TTY_TYPE"));
				bean.setRIA_UW_YEAR(resultSet.getInt("RIA_UW_YEAR"));
				bean.setRIA_FM_DT(resultSet.getDate("RIA_FM_DT"));
				bean.setRIA_TO_DT(resultSet.getDate("RIA_TO_DT"));
				bean.setRIA_APPRV_DT(resultSet.getDate("RIA_APPRV_DT"));
				bean.setRIA_APPRV_STATUS(resultSet.getString("RIA_APPRV_STATUS"));
				bean.setRIA_DIVN_CODE(resultSet.getString("RIA_DIVN_CODE"));
				bean.setRIA_DEPT_CODE(resultSet.getString("RIA_DEPT_CODE"));
				bean.setRIA_PROD_CODE(resultSet.getString("RIA_PROD_CODE"));
				bean.setRIA_COVER_CODE(resultSet.getString("RIA_COVER_CODE"));
				bean.setRIA_NB_REN_FLAG(resultSet.getString("RIA_NB_REN_FLAG"));
				bean.setRIA_LC_PREMIUM(resultSet.getDouble("RIA_LC_PREMIUM"));
				bean.setRIA_FC_PREMIUM(resultSet.getDouble("RIA_FC_PREMIUM"));
				bean.setRIA_LC_COMMISSION(resultSet.getDouble("RIA_LC_COMMISSION"));
				bean.setRIA_FC_COMMISSION(resultSet.getDouble("RIA_FC_COMMISSION"));
				bean.setRIA_CLM_PAID(resultSet.getDouble("RIA_CLM_PAID"));
				bean.setRIA_CLAIMS_OS(resultSet.getDouble("RIA_CLAIMS_OS"));
				bean.setRIA_CLASS_CODE(resultSet.getString("RIA_CLASS_CODE"));
				bean.setRIA_SRC_OF_BUS(resultSet.getString("RIA_SRC_OF_BUS"));
			}
		}catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	
	
	public void fetchRiAllocCustDtls(PILQ111_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		PT_IL_RI_ALLOC_ACTION actionBean = compositeAction.getPT_IL_RI_ALLOC_ACTION_BEAN();
		PT_IL_RI_ALLOC valueBean = actionBean.getPT_IL_RI_ALLOC_BEAN();
		PT_IL_RI_PART_CUST_ALLOC custBean = compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getPT_IL_RI_PART_CUST_ALLOC_BEAN();
		custBean = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<PT_IL_RI_PART_CUST_ALLOC> list = (ArrayList<PT_IL_RI_PART_CUST_ALLOC>) compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getDataListPT_IL_RI_PART_CUST_ALLOC();
		try{
			connection = CommonUtils.getConnection();
			String query = PILQ111_APAC_SQL_QUERY_CONSTANTS.FETCH_RI_CUST_ALLOC_RECORDS_QUERY;
			Object[] values = {valueBean.getRIA_SYS_ID()};
			if(valueBean.getRIA_SYS_ID()!= null){
				System.out.println("SIS_ID >>>>>> " + valueBean.getRIA_SYS_ID());
				resultSet = handler.executeSelectStatement(query, connection, values);
			}
			list = new ArrayList<PT_IL_RI_PART_CUST_ALLOC>();
			PT_IL_RI_PART_CUST_ALLOC_HELPER helper_Alloc = new PT_IL_RI_PART_CUST_ALLOC_HELPER();
			while(resultSet.next()){
				
				custBean = new PT_IL_RI_PART_CUST_ALLOC();
				//custBean.setROWID(resultSet.getString("ROWID"));
				custBean.setRIPCA_SYS_ID(resultSet.getDouble("RIPCA_SYS_ID"));
				custBean.setRIPCA_RIA_SYS_ID(resultSet.getDouble("RIPCA_RIA_SYS_ID"));
				custBean.setRIPCA_CUST_CODE(resultSet.getString("RIPCA_CUST_CODE"));
				custBean.setRIPCA_SHARE_PERC(resultSet.getDouble("RIPCA_SHARE_PERC"));
				custBean.setRIPCA_TTY_TYPE(resultSet.getString("RIPCA_TTY_TYPE"));
				custBean.setRIPCA_SRNO(resultSet.getDouble("RIPCA_SRNO"));
				custBean.setRIPCA_FC_PREMIUM(resultSet.getDouble("RIPCA_FC_PREMIUM"));
				custBean.setRIPCA_LC_PREMIUM(resultSet.getDouble("RIPCA_LC_PREMIUM"));
				custBean.setRIPCA_FC_COMMISSION(resultSet.getDouble("RIPCA_FC_COMMISSION"));
				custBean.setRIPCA_LC_COMMISSION(resultSet.getDouble("RIPCA_LC_COMMISSION"));
				custBean.setRIPCA_CLM_PAID(resultSet.getDouble("RIPCA_CLM_PAID"));
				custBean.setRIPCA_CLAIMS_OS(resultSet.getDouble("RIPCA_CLAIMS_OS"));
				helper_Alloc.postQuery(custBean);
				list.add(custBean);
			}
			compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().setDataListPT_IL_RI_PART_CUST_ALLOC(list);
			PT_IL_RI_PART_CUST_ALLOC bean=null;
			
			Iterator<PT_IL_RI_PART_CUST_ALLOC> listIterator= list.iterator();
			while(listIterator.hasNext()){
				bean  = listIterator.next();
				custBean.setRowSelected(false);
			}
		//	compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().setDataListPT_IL_RI_PART_CUST_ALLOC(list);
			if(list.size()>0){
			    compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().setPT_IL_RI_PART_CUST_ALLOC_BEAN(list.get(0));
			    compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getPT_IL_RI_PART_CUST_ALLOC_BEAN().setRowSelected(true);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	
	
	public List<PT_IL_RI_ALLOC> getDivnCodeLov(String divnCode) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_RI_ALLOC> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] values = {};
		
		try{
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_IL_RI_ALLOC>();
			String comp_code = CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE");
			if("*".equalsIgnoreCase(divnCode)){
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_DIVN_CODE_LOV;
				values = new Object[2];
				values[0] = comp_code;
				values[1] = PELConstants.suggetionRecordSize;
			}else{
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_DIVN_CODE_LIKE_LOV;
				values = new Object[3];
				values[0] = comp_code;
				values[1] = divnCode;
				values[2] = PELConstants.suggetionRecordSize;
			}
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				PT_IL_RI_ALLOC valueBean = new PT_IL_RI_ALLOC();
				valueBean.setRIA_DIVN_CODE(resultSet.getString(1));
				valueBean.setUI_M_DIVN_DESC(resultSet.getString(2));
				list.add(valueBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<PT_IL_RI_ALLOC> getDeptCodeLov(String deptCode) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_RI_ALLOC> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] values = {};
		
		try{
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_IL_RI_ALLOC>();
			if("*".equalsIgnoreCase(deptCode)){
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_DEPT_CODE_LOV;
				values = new Object[1];
				values[0] = PELConstants.suggetionRecordSize;
			}else{
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_DEPT_CODE_LIKE_LOV;
				values = new Object[2];
				values[0] = deptCode;
				values[1] = PELConstants.suggetionRecordSize;
			}
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				PT_IL_RI_ALLOC valueBean = new PT_IL_RI_ALLOC();
				valueBean.setRIA_DEPT_CODE(resultSet.getString(1));
				valueBean.setUI_M_DEPT_DESC(resultSet.getString(2));
				list.add(valueBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<PT_IL_RI_ALLOC> getProdCodeLov(String prodCode) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_RI_ALLOC> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] values = {};
		
		try{
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_IL_RI_ALLOC>();
			if("*".equalsIgnoreCase(prodCode)){
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_CODE_LOV;
				values = new Object[1];
				values[0] = PELConstants.suggetionRecordSize;
			}else{
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_CODE_LIKE_LOV;
				values = new Object[2];
				values[0] = prodCode;
				values[1] = PELConstants.suggetionRecordSize;
			}
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				PT_IL_RI_ALLOC valueBean = new PT_IL_RI_ALLOC();
				valueBean.setRIA_PROD_CODE(resultSet.getString(1));
				valueBean.setUI_M_PROD_DESC(resultSet.getString(2));
				list.add(valueBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<PT_IL_RI_ALLOC> getCoverCodeLov(String coverCode) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_RI_ALLOC> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] values = {};
		
		try{
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_IL_RI_ALLOC>();
			if("*".equalsIgnoreCase(coverCode)){
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_COVER_CODE_LOV;
				values = new Object[1];
				values[0] = PELConstants.suggetionRecordSize;
			}else{
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_COVER_CODE_LIKE_LOV;
				values = new Object[2];
				values[0] = coverCode;
				values[1] = PELConstants.suggetionRecordSize;
			}
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				PT_IL_RI_ALLOC valueBean = new PT_IL_RI_ALLOC();
				valueBean.setRIA_COVER_CODE(resultSet.getString(1));
				valueBean.setUI_M_COVER_DESC(resultSet.getString(2));
				list.add(valueBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<PT_IL_RI_ALLOC> getTreatyTypeLov(String treatyType) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_RI_ALLOC> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] values = {};
		
		try{
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_IL_RI_ALLOC>();
			if("*".equalsIgnoreCase(treatyType)){
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_TREATY_TYPE_LOV;
				values = new Object[1];
				values[0] = PELConstants.suggetionRecordSize;
			}else{
				query = PILQ111_APAC_SQL_QUERY_CONSTANTS.SELECT_TREATY_TYPE_LIKE_LOV;
				values = new Object[2];
				values[0] = treatyType;
				values[1] = PELConstants.suggetionRecordSize;
			}
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				PT_IL_RI_ALLOC valueBean = new PT_IL_RI_ALLOC();
				valueBean.setRIA_TTY_TYPE(resultSet.getString(1));
				list.add(valueBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	
	
}

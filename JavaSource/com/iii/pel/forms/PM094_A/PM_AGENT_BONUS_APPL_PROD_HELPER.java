package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_APPL_PROD_HELPER {

	public void execute_query(PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction)throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PM_AGENT_BONUS_APPL_PROD PM_AGENT_BONUS_APPL_PROD_BEAN= compositeAction.getPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN().getPM_AGENT_BONUS_APPL_PROD_BEAN();
		ArrayList<PM_AGENT_BONUS_APPL_PROD> agentBonusApplProdList = null;
		
		try {
			connection = CommonUtils.getConnection();
			String absCode=compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN().getABS_CODE();
			System.out.println("absCode :"+absCode);
			agentBonusApplProdList=new ArrayList<PM_AGENT_BONUS_APPL_PROD>();
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_PROD_FETCH_RECORDS_FOR_ABS_CODE, connection, new Object[]{absCode});
			PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod = null;
			while(resultSet.next()){
				pm_agent_bonus_appl_prod=new PM_AGENT_BONUS_APPL_PROD();
				pm_agent_bonus_appl_prod.setROWID(resultSet.getString("ROWID"));
				pm_agent_bonus_appl_prod.setABAP_ABS_CODE(resultSet.getString("ABAP_ABS_CODE"));
				pm_agent_bonus_appl_prod.setABAP_MODULE_ID(resultSet.getString("ABAP_MODULE_ID"));
				pm_agent_bonus_appl_prod.setABAP_PROD_CODE(resultSet.getString("ABAP_PROD_CODE"));
				pm_agent_bonus_appl_prod.setABAP_CR_DT(resultSet.getDate("ABAP_CR_DT"));
				pm_agent_bonus_appl_prod.setABAP_CR_UID(resultSet.getString("ABAP_CR_UID"));
				pm_agent_bonus_appl_prod.setABAP_UPD_DT(resultSet.getDate("ABAP_UPD_DT"));
				pm_agent_bonus_appl_prod.setABAP_UPD_UID(resultSet.getString("ABAP_UPD_UID"));
				postQuery(pm_agent_bonus_appl_prod);
				agentBonusApplProdList.add(pm_agent_bonus_appl_prod);
			}
			compositeAction.getPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN().setDataListPM_AGENT_BONUS_APPL_PROD(agentBonusApplProdList);
			if(agentBonusApplProdList.size() > 0){
				compositeAction.getPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN().setPM_AGENT_BONUS_APPL_PROD_BEAN(agentBonusApplProdList.get(0));
				compositeAction.getPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN().getPM_AGENT_BONUS_APPL_PROD_BEAN().setRowSelected(true);
			}
		}catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void whenListChanged(PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod)throws ValidatorException {
		String query=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_PROD_MODULE_ID_QUERY;
		CRUDHandler handler=new  CRUDHandler();
		ResultSet resultSet=null;
		String moduleId=pm_agent_bonus_appl_prod.getABAP_MODULE_ID();
		String prodCode=pm_agent_bonus_appl_prod.getABAP_PROD_CODE();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			if(prodCode!=null){
				System.out.println("moduleId :"+moduleId +" :::: prodCode :"+prodCode);
				resultSet=handler.executeSelectStatement(query, connection, new Object[]{moduleId,prodCode});
				if(resultSet.next()){
					System.out.println("Prod COde :"+resultSet.getString(1));
					pm_agent_bonus_appl_prod.setUI_M_ABAP_PROD_CODE_DESC(resultSet.getString(2));
					System.out.println("Desc :"+pm_agent_bonus_appl_prod.getUI_M_ABAP_PROD_CODE_DESC());
				}else {
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91074"));
				}
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public List prepareProdCodeList(String prodcode, String moduleId,List prodcodeList) {
		String query = null;
		PM_AGENT_BONUS_APPL_PROD_DELEGATE delegate=new PM_AGENT_BONUS_APPL_PROD_DELEGATE();
		if ("*".equalsIgnoreCase(prodcode)) {
				query = PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.LOV$PM094_A$PM_AGNET_BONUS_APPL_PROD$ABAP_PROD_CODE;
				Object[] object={moduleId,PELConstants.suggetionRecordSize};
				prodcodeList = delegate.prodCodeLOV(query,object);

		} else {
				prodcode=prodcode+PM094_A_PM_AGENT_BONUS_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={prodcode,moduleId,PELConstants.suggetionRecordSize};
				System.out.println("prodcode :"+prodcode);
				System.out.println("moduleId :"+moduleId);
				query = PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.LOV$PM094_A$PM_AGNET_BONUS_APPL_PROD$ABAP_PROD_CODE$LIKE;
				prodcodeList = delegate.prodCodeLOV(query,object);
		}
		return prodcodeList;
	}

	public String getDescforProdCode(String prodcode, List prodcodeList) {
		Iterator iterator = prodcodeList.iterator();
		String prodCodeDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod=(PM_AGENT_BONUS_APPL_PROD)iterator.next();
			
	 		if(prodcode.equalsIgnoreCase(pm_agent_bonus_appl_prod.getABAP_PROD_CODE()))
	 		{
	 			prodCodeDesc = pm_agent_bonus_appl_prod.getUI_M_ABAP_PROD_CODE_DESC();
	 			System.out.println("prodCodeDesc :"+prodCodeDesc);
			}
		}
		return prodCodeDesc;
	}
	
	public void postQuery(PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod)throws Exception {
		String query=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_PROD_MODULE_ID_QUERY;
		CRUDHandler handler=new  CRUDHandler();
		ResultSet resultSet=null;
		String moduleId=pm_agent_bonus_appl_prod.getABAP_MODULE_ID();
		String prodCode=pm_agent_bonus_appl_prod.getABAP_PROD_CODE();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			if(prodCode!=null){
				System.out.println("moduleId :"+moduleId +" :::: prodCode :"+prodCode);
				resultSet=handler.executeSelectStatement(query, connection, new Object[]{moduleId,prodCode});
				if(resultSet.next()){
					System.out.println("Prod COde :"+resultSet.getString(1));
					pm_agent_bonus_appl_prod.setUI_M_ABAP_PROD_CODE_DESC(resultSet.getString(2));
					System.out.println("Desc :"+pm_agent_bonus_appl_prod.getUI_M_ABAP_PROD_CODE_DESC());
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void pre_insert(PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod,PM_AGENT_BONUS_SETUP PM_AGENT_BONUS_SETUP_BEAN)throws Exception {
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		String C1 = " SELECT 1 " +
				"			FROM  PM_AGENT_BONUS_APPL_PROD" +
				"			WHERE ABAP_ABS_CODE = ?" +
				"			AND   ABAP_MODULE_ID = ?" +
				"			AND   ABAP_PROD_CODE = ?";
		String C2 = " SELECT 1 " +
				"			FROM  PM_AGENT_BONUS_APPL_PROD" +
				"			WHERE ABAP_ABS_CODE = ?" +
				"			AND   ABAP_MODULE_ID = ?" +
				"			AND   ABAP_PROD_CODE = ?" +
				"			AND   ROWID != ?";
		
		try {
			Connection connection=CommonUtils.getConnection();
			if(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE() != null){
				pm_agent_bonus_appl_prod.setABAP_ABS_CODE(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE());
			}
			if(pm_agent_bonus_appl_prod.getABAP_ABS_CODE() == null){ 
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "19050"));
			}
			pm_agent_bonus_appl_prod.setABAP_CR_DT(new CommonUtils().getCurrentDate());
			pm_agent_bonus_appl_prod.setABAP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			
			values = new Object[]{pm_agent_bonus_appl_prod.getABAP_ABS_CODE(),pm_agent_bonus_appl_prod.getABAP_MODULE_ID(),
					pm_agent_bonus_appl_prod.getABAP_PROD_CODE()};
			resultSet=handler.executeSelectStatement(C1,connection,values);
			if(resultSet.next()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91049"));
			}
			values = new Object[]{pm_agent_bonus_appl_prod.getABAP_ABS_CODE(),pm_agent_bonus_appl_prod.getABAP_MODULE_ID(),
					pm_agent_bonus_appl_prod.getABAP_PROD_CODE(),pm_agent_bonus_appl_prod.getROWID()};
			resultSet2 = handler.executeSelectStatement(C2, connection,values);
			if(resultSet2.next()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91049"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
		}
	}
	
	public void pre_update(PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod)throws Exception{
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_PROD_PRE_INSERT_QUERY2,
														connection,
														new Object[]{pm_agent_bonus_appl_prod.getABAP_ABS_CODE(),
																		pm_agent_bonus_appl_prod.getABAP_MODULE_ID(),
																		pm_agent_bonus_appl_prod.getABAP_PROD_CODE(),
																		pm_agent_bonus_appl_prod.getROWID()});
			if(resultSet.next()){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void when_create_record(PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod){
		
		pm_agent_bonus_appl_prod.setABAP_MODULE_ID("IL");
	}

}

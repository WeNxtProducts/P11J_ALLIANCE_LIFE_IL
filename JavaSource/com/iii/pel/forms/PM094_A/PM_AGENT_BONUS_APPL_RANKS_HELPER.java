package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_AGENT_BONUS_APPL_RANKS_HELPER {

	public void execute_query() {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = null;
		PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks=null;
		ArrayList<PM_AGENT_BONUS_APPL_RANKS> agentBonusApplRanksList = null;
		
		try {
			compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
			connection = CommonUtils.getConnection();
			String absCode=compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN().getABS_CODE();
			System.out.println("absCode :"+absCode);
			agentBonusApplRanksList=new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_RANKS_FETCH_RECORDS_FOR_ABS_CODE, connection, new Object[]{absCode});
			
			while(resultSet.next()){
				pm_agent_bonus_appl_ranks=new PM_AGENT_BONUS_APPL_RANKS();
				pm_agent_bonus_appl_ranks.setROWID(resultSet.getString("ROWID"));
				pm_agent_bonus_appl_ranks.setABAR_ABS_CODE(resultSet.getString("ABAR_ABS_CODE"));
				pm_agent_bonus_appl_ranks.setABAR_RANK_CODE(resultSet.getString("ABAR_RANK_CODE"));
				pm_agent_bonus_appl_ranks.setABAR_CR_DT(resultSet.getDate("ABAR_CR_DT"));
				pm_agent_bonus_appl_ranks.setABAR_CR_UID(resultSet.getString("ABAR_CR_UID"));
				pm_agent_bonus_appl_ranks.setABAR_UPD_DT(resultSet.getDate("ABAR_UPD_DT"));
				pm_agent_bonus_appl_ranks.setABAR_UPD_UID(resultSet.getString("ABAR_UPD_UID"));
				/*Added by Ameen on 02-08-2018 for KICLIFEQC-1760174 as per Ajay*/
				pm_agent_bonus_appl_ranks.setABAR_AGENT_NEW(resultSet.getString("ABAR_AGENT_NEW"));
				if(pm_agent_bonus_appl_ranks.getABAR_AGENT_NEW()!=null && "Y".equalsIgnoreCase(pm_agent_bonus_appl_ranks.getABAR_AGENT_NEW())){
					pm_agent_bonus_appl_ranks.setUI_M_ABAR_AGENT_NEW(true);
				}else{
					pm_agent_bonus_appl_ranks.setUI_M_ABAR_AGENT_NEW(false);
				}
				/*end*/
				
				/*Newly added by pidugu raj dt: 08-11-2018 as suggested by ajoy for kic bonus setup*/
				pm_agent_bonus_appl_ranks.setABAR_CLASS_FM(resultSet.getString("ABAR_CLASS_FM"));
				pm_agent_bonus_appl_ranks.setABAR_CLASS_TO(resultSet.getString("ABAR_CLASS_TO"));
				/*End Newly added by pidugu raj dt: 08-11-2018 as suggested by ajoy for kic bonus setup*/
				post_query(pm_agent_bonus_appl_ranks);
				agentBonusApplRanksList.add(pm_agent_bonus_appl_ranks);
			}
			compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().setDataList_PM_AGENT_BONUS_APPL_RANKS(agentBonusApplRanksList);
			if(agentBonusApplRanksList.size() > 0){
			compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().setPM_AGENT_BONUS_APPL_RANKS_BEAN(agentBonusApplRanksList.get(0));
			compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().getPM_AGENT_BONUS_APPL_RANKS_BEAN().setRowSelected(true);
			}
		}catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void post_query(PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks) throws SQLException, Exception{
		
		DBProcedures procedures=new DBProcedures();
		ArrayList<String> rankCodeDescList=null;
		rankCodeDescList=procedures.helperP_VAL_CODES("AGNRANK", pm_agent_bonus_appl_ranks.getABAR_RANK_CODE(), "N", "N", null);
		if(rankCodeDescList!=null && rankCodeDescList.size()>0){
			pm_agent_bonus_appl_ranks.setUI_M_ABS_AGENT_RANK_DESC(rankCodeDescList.get(0));
		}
		
		
		
		if(pm_agent_bonus_appl_ranks.getABAR_CLASS_FM() != null){
		Connection connection = null;
		ResultSet rs = null;
		String  CURSOR_C1 = "SELECT DISTINCT CCLAS_CLASS_DESC FROM PM_CUSTOMER,PM_CUST_CLASS WHERE CUST_CLASS =? AND CCLAS_CODE = CUST_CLASS";
		try{
			connection = CommonUtils.getConnection();
			String CUST_CLASS = "CUST_CLASS";
			rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, connection, new Object[] {pm_agent_bonus_appl_ranks.getABAR_CLASS_FM()});
			 if(rs.next()) {
				 pm_agent_bonus_appl_ranks.setUI_M_ABAR_CLASS_FM_DESC(rs.getString(1));
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
		
		
		if(pm_agent_bonus_appl_ranks.getABAR_CLASS_TO() != null){
			Connection connection = null;
			ResultSet rs = null;
			String  CURSOR_C1 = "SELECT DISTINCT CCLAS_CLASS_DESC FROM PM_CUSTOMER,PM_CUST_CLASS WHERE CUST_CLASS =? AND CCLAS_CODE = CUST_CLASS";
			try{
				connection = CommonUtils.getConnection();
				String CUST_CLASS = "CUST_CLASS";
				rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, connection, new Object[] {pm_agent_bonus_appl_ranks.getABAR_CLASS_TO()});
				 if(rs.next()) {
					 pm_agent_bonus_appl_ranks.setUI_M_ABAR_CLASS_TO_DESC(rs.getString(1));
				 }
			}catch(Exception e){
				e.printStackTrace();
			}
			}
	}
	
	public void pre_insert(PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks,PM_AGENT_BONUS_SETUP pm_agent_bonus_setup)throws ValidatorException{
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			if(pm_agent_bonus_setup.getABS_CODE() != null){
			pm_agent_bonus_appl_ranks.setABAR_ABS_CODE(pm_agent_bonus_setup.getABS_CODE());
			}
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_RANKS_PRE_INSERT_QUERY1,
														connection,
														new Object[]{pm_agent_bonus_appl_ranks.getABAR_ABS_CODE(),pm_agent_bonus_appl_ranks.getABAR_RANK_CODE()});
			
			if(resultSet.next()){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
			
	}
	
	public void pre_update(PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks)throws ValidatorException{
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_RANKS_PRE_INSERT_QUERY2,
														connection,
														new Object[]{pm_agent_bonus_appl_ranks.getABAR_ABS_CODE(),
																		pm_agent_bonus_appl_ranks.getABAR_RANK_CODE(),
																		pm_agent_bonus_appl_ranks.getROWID()});
			
			if(resultSet.next()){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
			
	}

	public void pre_delete(PM_AGENT_BONUS_APPL_RANKS bean) {
		CRUDHandler handler=new CRUDHandler();
		int i=0;
		try {
			Connection connection=CommonUtils.getConnection();
			i=handler.executeDeleteStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_APPL_RANKS_PRE_DELETE_QUERY,
														connection,
														new Object[]{bean.getABAR_RANK_CODE(),
																	bean.getABAR_ABS_CODE()});
			
			System.out.println("Records Deleted :"+i);
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}

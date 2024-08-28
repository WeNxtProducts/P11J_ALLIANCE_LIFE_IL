package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_REPAY_DELEGATE {
	public void executeSelectStatement(
			PILM007_COMPOSITE_ACTION PILM007_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = PILM007_COMPOSITE_ACTION_BEAN
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_CLM_REPAY.* FROM PM_IL_CLM_REPAY WHERE ROWID='"
				+ pm_il_clm_repay_bean.getROWID() + "'";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PM_IL_CLM_REPAY PM_IL_CLM_REPAY_BEAN = new PM_IL_CLM_REPAY();
			while (resultSet.next()) {
				PM_IL_CLM_REPAY_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CLM_REPAY_BEAN.setCR_COVER_CODE(resultSet.getString("CR_COVER_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_BEAN.setCR_LOSS_TYPE(resultSet.getString("CR_LOSS_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_BEAN.setCR_DISABLE_TYPE(resultSet.getString("CR_DISABLE_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_BEAN.setCR_PERIOD_UNIT(resultSet.getString("CR_PERIOD_UNIT"));
				PM_IL_CLM_REPAY_BEAN.setCR_PERIOD_FROM(resultSet.getInt("CR_PERIOD_FROM"));
				PM_IL_CLM_REPAY_BEAN.setCR_PERIOD_TO(resultSet.getInt("CR_PERIOD_TO"));                                                                                                                                                                                     
				PM_IL_CLM_REPAY_BEAN.setCR_PAY_MODE(resultSet.getString("CR_PAY_MODE"));                                                                                                                                                                                   
				PM_IL_CLM_REPAY_BEAN.setCR_POLICY_VALID_YN(resultSet.getString("CR_POLICY_VALID_YN"));                                                                                                                                                                                   
				PM_IL_CLM_REPAY_BEAN.setCR_PREM_PAYABLE_YN(resultSet.getString("CR_PREM_PAYABLE_YN"));                                                                                                                                                                                   
				PM_IL_CLM_REPAY_BEAN.setCR_CR_DT(resultSet.getDate("CR_CR_DT"));                                                                                                                                                                                          
				PM_IL_CLM_REPAY_BEAN.setCR_CR_UID(resultSet.getString("CR_CR_UID"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_BEAN.setCR_UPD_DT(resultSet.getDate("CR_UPD_DT"));          
				PM_IL_CLM_REPAY_BEAN.setCR_UPD_UID(resultSet.getString("CR_UPD_UID"));         
				PM_IL_CLM_REPAY_BEAN.setCR_MIN_TYPE(resultSet.getString("CR_MIN_TYPE"));        
				PM_IL_CLM_REPAY_BEAN.setCR_MIN_VALUE(resultSet.getDouble("CR_MIN_VALUE"));       
				PM_IL_CLM_REPAY_BEAN.setCR_MAX_TYPE(resultSet.getString("CR_MAX_TYPE"));        
				PM_IL_CLM_REPAY_BEAN.setCR_MAX_VALUE(resultSet.getDouble("CR_MAX_VALUE"));       
				PM_IL_CLM_REPAY_BEAN.setCR_RATE(resultSet.getDouble("CR_RATE"));            
				PM_IL_CLM_REPAY_BEAN.setCR_RATE_PER(resultSet.getDouble("CR_RATE_PER"));        
				PM_IL_CLM_REPAY_BEAN.setCR_EFF_FM_DT(resultSet.getDate("CR_EFF_FM_DT"));       
				PM_IL_CLM_REPAY_BEAN.setCR_EFF_TO_DT(resultSet.getDate("CR_EFF_TO_DT"));       
				PM_IL_CLM_REPAY_BEAN.setCR_APPLIED_ON(resultSet.getString("CR_APPLIED_ON"));      
				PM_IL_CLM_REPAY_BEAN.setCR_LATE_FEE_YN(resultSet.getString("CR_LATE_FEE_YN"));     
				PM_IL_CLM_REPAY_BEAN.setCR_LATE_FEE_TYPE(resultSet.getString("CR_LATE_FEE_TYPE"));   
				PM_IL_CLM_REPAY_BEAN.setCR_RESERVE_TYPE(resultSet.getString("CR_RESERVE_TYPE"));    
				PM_IL_CLM_REPAY_BEAN.setCR_RESERVE_OPTIONS(resultSet.getString("CR_RESERVE_OPTIONS")); 
				PM_IL_CLM_REPAY_BEAN.setCR_NO_OF_YEARS(resultSet.getInt("CR_NO_OF_YEARS"));     
				PM_IL_CLM_REPAY_BEAN.setCR_RESERVE_CR_BASIS(resultSet.getString("CR_RESERVE_CR_BASIS"));
				PM_IL_CLM_REPAY_BEAN.setCR_PAY_TO(resultSet.getString("CR_PAY_TO"));    
				PM_IL_CLM_REPAY_BEAN.setCR_WAITING_YN(resultSet.getString("CR_WAITING_YN"));
				PM_IL_CLM_REPAY_BEAN.setCR_LIEN_YN(resultSet.getString("CR_LIEN_YN"));
				PM_IL_CLM_REPAY_BEAN.setCR_HIBAH_YN(resultSet.getString("CR_HIBAH_YN"));
				PM_IL_CLM_REPAY_BEAN.setCR_HIBAH_FEE_AMT(resultSet.getDouble("CR_HIBAH_FEE_AMT"));
				PM_IL_CLM_REPAY_BEAN.setCR_ALLOWANCE(resultSet.getString("CR_FLEX_01"));
				PM_IL_CLM_REPAY_BEAN.setCR_ALLOWANCE_PER_DAY(resultSet.getInt("CR_FLEX_02"));
				PM_IL_CLM_REPAY_BEAN.setCR_PREM_DED(resultSet.getString("CR_PREM_DED"));	
				PM_IL_CLM_REPAY_BEAN.setCR_FM_CODE(resultSet.getString("CR_FM_CODE"));
				/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
				PM_IL_CLM_REPAY_BEAN.setCR_PRE_CLM_YN(resultSet.getString("CR_PRE_CLM_YN"));
				if("Y".equalsIgnoreCase(PM_IL_CLM_REPAY_BEAN.getCR_PRE_CLM_YN())){
					PILM007_COMPOSITE_ACTION_BEAN
					.getPM_IL_CLM_REPAY_ACTION_BEAN().getCOMP_CR_PRE_WAIT_MNTHS().setDisabled(false);
					
				}else{
					PILM007_COMPOSITE_ACTION_BEAN
					.getPM_IL_CLM_REPAY_ACTION_BEAN().getCOMP_CR_PRE_WAIT_MNTHS().setDisabled(true);
				}
				PM_IL_CLM_REPAY_BEAN.setCR_PRE_WAIT_MNTHS(resultSet.getInt("CR_PRE_WAIT_MNTHS"));
				/*end*/
				
				/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
				PM_IL_CLM_REPAY_BEAN.setCR_MAX_VISITS(resultSet.getInt("CR_MAX_VISITS"));
				/*end*/
				
				/*Added by raja for Hospital cash plan on 05/05/2017*/
				PM_IL_CLM_REPAY_BEAN.setCR_WAIT_HRS(resultSet.getInt("CR_WAIT_HRS"));
				/*end*/
			}
			PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.setPM_IL_CLM_REPAY_BEAN(PM_IL_CLM_REPAY_BEAN);
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
}

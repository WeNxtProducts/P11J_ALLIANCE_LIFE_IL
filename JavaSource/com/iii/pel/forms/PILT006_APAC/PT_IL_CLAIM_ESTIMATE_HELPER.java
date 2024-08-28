package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_ESTIMATE_HELPER {

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_CLAIM_ESTIMATE_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void preInsert(PT_IL_CLAIM_ESTIMATE estimateBean, PT_IL_CLAIM claimBean, 
			CTRL ctrlBean) throws Exception{
		String CURSOR_C1 = "SELECT PIL_CE_SYS_ID.NEXTVAL FROM DUAL";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if(resultSet.next()){
				estimateBean.setCE_SYS_ID(resultSet.getLong(1));
			}
			// Added by own, since relationship is not set anywhere in any trigger
			estimateBean.setCE_CLAIM_SYS_ID(claimBean.getCLAIM_SYS_ID());
			
			estimateBean.setCE_CR_DT(new CommonUtils().getCurrentDate());
			estimateBean.setCE_CR_UID(ctrlBean.getUI_M_USER_ID());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void whenNewBlockInstance(PT_IL_CLAIM claimBean, 
			PT_IL_CLAIM_ESTIMATE_ACTION estimateAction, DUMMY dummyBean) throws Exception{
		PT_IL_CLAIM_ESTIMATE estimateBean = estimateAction.getPT_IL_CLAIM_ESTIMATE_BEAN();
		
		if(claimBean.getCLAIM_POL_NO() != null){
			/*Modified by saranya for Hands on Point no 23 on 14/02/2017*/
			estimateBean.setUI_M_CE_FC_EST_TOT_DED(
					CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS(), 0d) +
					CommonUtils.nvl(estimateBean.getCE_FC_LOAN_OS(), 0d) +
					CommonUtils.nvl(estimateBean.getCE_FC_LOAN_INT(), 0d) +
					CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS_INT(), 0d));
				/*	CommonUtils.nvl(estimateBean.getCE_FC_CLM_PROC_FEE(), 0d)+
			Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017
					CommonUtils.nvl(estimateBean.getCE_FC_FEE_PAID_HOSP(), 0d));
			end
			
			End*/
			estimateBean.setUI_M_CE_FC_EST_TOT_DED(
					LIFELIB.P_VAL_ROUND_AMT(claimBean.getCLAIM_CURR_CODE(), 
					estimateBean.getUI_M_CE_FC_EST_TOT_DED(), "R"));
			estimateBean.setUI_M_CE_LC_EST_TOT_DED(
					estimateBean.getUI_M_CE_FC_EST_TOT_DED() * claimBean.getCLAIM_EXCH_RATE());
			estimateBean.setUI_M_CE_LC_EST_TOT_DED(
					LIFELIB.P_VAL_ROUND_AMT(dummyBean.getM_BASE_CURR(), 
					estimateBean.getUI_M_CE_LC_EST_TOT_DED(), "R"));
			
			if("Y".equals(CommonUtils.nvl(claimBean.getCLAIM_FRZ_FLAG(), "N"))){
				estimateAction.setUPDATE_ALLOWED(false);
				estimateAction.setINSERT_ALLOWED(false);
			}
		}
	}
	
	public void preUpdate(PT_IL_CLAIM_ESTIMATE estimateBean, CTRL ctrlBean) throws Exception{
		try {
			estimateBean.setCE_UPD_DT(new CommonUtils().getCurrentDate());
			estimateBean.setCE_UPD_UID(ctrlBean.getUI_M_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	/* Modified by Janani on 07.08.2017 for ZBILQC-1734156*/
	
	/*public void postQuery(PT_IL_CLAIM_ESTIMATE estimateBean)*/
	public void postQuery(PT_IL_CLAIM_ESTIMATE estimateBean,PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception
	
	/*End*/
	
	{
		Double calculatedValue = 0.0d;
		/*Modified by saranya for Hands on Point no 23 on 14/02/2017*/
		calculatedValue = CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS(), 0d) +
				CommonUtils.nvl(estimateBean.getCE_FC_LOAN_OS(), 0d) +
				CommonUtils.nvl(estimateBean.getCE_FC_LOAN_INT(), 0d) +
				CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS_INT(), 0d);
				/*CommonUtils.nvl(estimateBean.getCE_FC_CLM_PROC_FEE(), 0d)+
				Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017
				CommonUtils.nvl(estimateBean.getCE_FC_FEE_PAID_HOSP(), 0d);
			end
		End*/
		
		/* Added by Janani on 07.08.2017 for ZBILQC-1734156*/	

		estimateBean.setUI_M_CE_FC_EST_TOT_DED(
				LIFELIB.P_VAL_ROUND_AMT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_CURR_CODE(), 
						calculatedValue, "R"));

		System.out.println("getUI_M_CE_FC_EST_TOT_DED                  "+estimateBean.getUI_M_CE_FC_EST_TOT_DED());

		estimateBean.setUI_M_CE_LC_EST_TOT_DED(
				estimateBean.getUI_M_CE_FC_EST_TOT_DED() * compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_EXCH_RATE());
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(
				LIFELIB.P_VAL_ROUND_AMT(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_BASE_CURR(), 
				estimateBean.getUI_M_CE_LC_EST_TOT_DED(), "R"));
		
		
		estimateBean.setUI_M_CE_FC_EST_TOT_DED(estimateBean.getUI_M_CE_FC_EST_TOT_DED());
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(estimateBean.getUI_M_CE_LC_EST_TOT_DED());

		/*End*/
	}
	
	public void preBlock(CTRL ctrlBean){
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE");
		ctrlBean.setUI_M_DELETE_MSG_FLAG("N");
	}
	
	public void onPopulateDetails(PT_IL_CLAIM_ESTIMATE estimateBean, 
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_BONUS_DELEGATE bonusDelegate = null;
		
		if(estimateBean.getCE_CLAIM_SYS_ID() != null){
			bonusDelegate = new PT_IL_BONUS_DELEGATE();
				bonusDelegate.executeSelectStatement(compositeAction);
		}
	}
	
	public void preDelete(PT_IL_CLAIM_ESTIMATE estimateBean) throws Exception{
		String DELETE_BONUS = "DELETE FROM PT_IL_BONUS P " +
			" WHERE P.BON_REF_SYS_ID = ?";
		Object[] values = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{estimateBean.getCE_CLAIM_SYS_ID()};
			handler.executeDeleteStatement(DELETE_BONUS, connection, values);
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	// Validators
	public void validateCE_SETL_START_DT(PT_IL_CLAIM claimBean, PT_IL_CLAIM_ESTIMATE estimateBean) throws Exception{
		if(estimateBean.getCE_SETL_START_DT().before(claimBean.getCLAIM_LOSS_DT())){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71192", 
					new Object[]{claimBean.getCLAIM_LOSS_DT()}));
		}
	}
	
	public void validateCE_FC_EST_AMT(PT_IL_CLAIM claimBean, 
			PT_IL_CLAIM_ESTIMATE estimateBean, DUMMY dummyBean) throws Exception{
		PILT006_APAC_PROCEDURE.L_INS_EST_RECORDS(claimBean, estimateBean, dummyBean);
		estimateBean.setCE_FC_EST_AMT(
				LIFELIB.P_VAL_ROUND_AMT(claimBean.getCLAIM_CURR_CODE(), 
						estimateBean.getCE_FC_EST_AMT(), "R"));
		estimateBean.setCE_LC_EST_AMT(estimateBean.getCE_FC_EST_AMT() * claimBean.getCLAIM_EXCH_RATE());
		estimateBean.setCE_LC_EST_AMT(
				LIFELIB.P_VAL_ROUND_AMT(dummyBean.getM_BASE_CURR(), 
						estimateBean.getCE_LC_EST_AMT(), "R"));
	}
	
	public void validateCE_LC_EST_AMT(PT_IL_CLAIM claimBean,
			PT_IL_CLAIM_ESTIMATE estimateBean, DUMMY dummyBean) throws Exception{
		estimateBean.setCE_LC_EST_AMT(
				LIFELIB.P_VAL_ROUND_AMT(dummyBean.getM_BASE_CURR(), 
						estimateBean.getCE_LC_EST_AMT(), "R"));
		PILT006_APAC_PROCEDURE.P_VAL_FC_LC_TOLERANCE(estimateBean.getCE_FC_EST_AMT(), 
				estimateBean.getCE_LC_EST_AMT(), 
				claimBean.getCLAIM_EXCH_RATE(), 
				"E");
	}
	
	/**
	 * Rerender Single record view
	 * @param estimateAction
	 */
	public void whenCheckBoxChangedCE_FRZ_FLAG(PT_IL_CLAIM_ESTIMATE_ACTION estimateAction,PILT006_APAC_COMPOSITE_ACTION compositeAction){
		if("A".equals(estimateAction.getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FRZ_FLAG()) &&
				"N".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
						getPT_IL_CLAIM_BEAN().getCLAIM_FRZ_FLAG())){
			estimateAction.setUPDATE_ALLOWED(false);
			estimateAction.disableAllComponent(true);
		}
	}
}

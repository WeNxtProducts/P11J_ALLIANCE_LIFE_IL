package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILM003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_SURR_PAID_FACTOR_HELPER {


	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_SURR_PAID_FACTOR_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_IL_SURR_PAID_FACTOR> dataList = compositeAction.
	getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN().getDataList_PM_IL_SURR_PAID_FACTOR();
	 if(dataList!=null && dataList.size() > 0){
		PM_IL_SURR_PAID_FACTOR PM_IL_SURR_PAID_FACTOR_BEAN = dataList.get(0);
		PM_IL_SURR_PAID_FACTOR_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN()
		.setPM_IL_SURR_PAID_FACTOR_BEAN(PM_IL_SURR_PAID_FACTOR_BEAN);
	}
	}
	
	public void preInsert(PM_IL_SURR_PAID_FACTOR surrBean, PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
		if(surrBean.getSPF_NO_YRS_PREM_PAID() > surrBean.getSPF_PERIOD()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71094"));
		}
		surrBean.setSPF_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
		surrBean.setSPF_FRZ_FLAG("N");
		surrBean.setSPF_CR_DT(new CommonUtils().getCurrentDate());
		surrBean.setSPF_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
		
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	public void postBlock(PM_IL_SURR_PAID_FACTOR surrBean, PILM003_APAC_COMPOSITE_ACTION compositeAction){
		if(surrBean.getSPF_PERIOD() == null){
			compositeAction.getPM_IL_PLAN_ACTION_BEAN().getCOMP_PLAN_SURR_YRS().setDisabled(false);
			compositeAction.getPM_IL_PLAN_ACTION_BEAN().getCOMP_PLAN_SURR_YN().setDisabled(false);
		}
	}
	
	public void preQuery(PM_IL_SURR_PAID_FACTOR surrBean ,PILM003_APAC_COMPOSITE_ACTION compositeAction){
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		surrBean.setSPF_PLAN_CODE(planBean.getPLAN_CODE());
	}
	
	public void preUpdate(PM_IL_SURR_PAID_FACTOR surrBean ,PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			surrBean.setSPF_UPD_DT(new CommonUtils().getCurrentDate());
			surrBean.setSPF_UPD_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void L_SPF_INSERT(PM_IL_SURR_PAID_FACTOR surrBean ,PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		int M_FROM ,M_TEMP , M_TEMP1 , M_TO = 0;
		int M_1 , M_2 = 0 ;
		PM_IL_PLAN planBean = null;
		Connection connection = null;
		int insert = 0 ;
		CRUDHandler handler = null;
		String C1 = "INSERT INTO PM_IL_SURR_PAID_FACTOR (SPF_PLAN_CODE,SPF_PERIOD ,	SPF_NO_YRS_PREM_PAID," +
				" SPF_UPTO_DAYS, SPF_POL_SURR_FACTOR , SPF_POL_PAIDUP_FACTOR ,  SPF_PRO_SURR_FACTOR, " +
				" SPF_PRO_PAIDUP_FACTOR,  SPF_RATE_PER, SPF_FRZ_FLAG,  SPF_CR_UID, SPF_CR_DT ) " +
				" VALUES ( ? ,  ?, ?, 0,0,0,0,0,100,'N',? ,? )";
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		M_FROM = planBean.getPLAN_PERIOD_FROM();
		M_TEMP = planBean.getPLAN_SURR_YRS();
		M_TEMP1 = planBean.getPLAN_SURR_YRS();
		M_TO = planBean.getPLAN_PERIOD_TO();
		
		
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			while(M_FROM < M_TO){
				M_TEMP = M_TEMP1;
				while(M_TEMP < M_FROM){
					insert = handler.executeInsertStatement(C1, connection , new Object[]{planBean.getPLAN_CODE(),
							M_FROM,M_TEMP,compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID(),
							new CommonUtils().getCurrentDate()});
					M_TEMP = M_TEMP + 1;
				}
				M_FROM = M_FROM + 1;
			}
		}catch (DBException e1) {
			e1.printStackTrace();
			throw new Exception(e1.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenNewBlockInstance(PM_IL_SURR_PAID_FACTOR surrBean , PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PLAN planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		
		try {
			if(surrBean.getROWID() == null){
			new PKG_PILM003().L_SPF_INSERT(planBean.getPLAN_CODE(), 
					planBean.getPLAN_PERIOD_FROM(), 
					planBean.getPLAN_PERIOD_TO(),planBean.getPLAN_SURR_YRS());
			executeQuery(compositeAction);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateRecord(PM_IL_SURR_PAID_FACTOR surrBean) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 = "	SELECT 	SPF_PERIOD,SPF_NO_YRS_PREM_PAID FROM PM_IL_SURR_PAID_FACTOR  WHERE 	" +
					" SPF_PLAN_CODE = ?  AND   SPF_PERIOD  = ?  AND  " +
					" SPF_NO_YRS_PREM_PAID = ? AND SPF_UPTO_DAYS      = ? ";
		String C2 = " 	SELECT 	SPF_PERIOD,SPF_NO_YRS_PREM_PAID FROM  PM_IL_SURR_PAID_FACTOR " +
					"  	WHERE  	SPF_PLAN_CODE = ? AND   SPF_PERIOD  = ?  AND  SPF_NO_YRS_PREM_PAID = ? " +
					"     AND     SPF_UPTO_DAYS = ?   AND ROWID  != ? ";
	 try {
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		if(surrBean.getROWID() == null){
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{
						surrBean.getSPF_PLAN_CODE(),surrBean.getSPF_PERIOD(),
						surrBean.getSPF_NO_YRS_PREM_PAID(),surrBean.getSPF_UPTO_DAYS()
					});
			if(resultSet.next()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71015"));
			}
		}else{
			resultSet = handler.executeSelectStatement(C2 , connection, new Object[]{
								surrBean.getSPF_PLAN_CODE(),surrBean.getSPF_PERIOD(),
								surrBean.getSPF_NO_YRS_PREM_PAID(),surrBean.getSPF_UPTO_DAYS(),
								surrBean.getROWID()});
			if(resultSet.next()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71015"));
			}
		}
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	public void whenValidate_SPF_PERIOD(Integer SPF_PERIOD ,
							PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		int M_DIFF = 0;
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		try{
		if(SPF_PERIOD < planBean.getPLAN_PERIOD_FROM()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71130"));
		}
		if(SPF_PERIOD > planBean.getPLAN_PERIOD_TO()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71214"));
		}
	 //  :PM_IL_SURR_PAID_FACTOR.SPF_NO_YRS_PREM_PAID := :PM_IL_SURR_PAID_FACTOR.SPF_NO_YRS_PREM_PAID;
		
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_SPF_NO_YRS_PREM_PAID(PILM003_APAC_COMPOSITE_ACTION compositeAction ,
				Integer SPF_NO_YRS_PREM_PAID) throws Exception{
		PM_IL_SURR_PAID_FACTOR surrBean = null;
		PM_IL_PLAN planBean = null;
		surrBean = compositeAction.getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN().getPM_IL_SURR_PAID_FACTOR_BEAN();
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		try{
			if(SPF_NO_YRS_PREM_PAID > surrBean.getSPF_PERIOD()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71094"));
			}
			if(SPF_NO_YRS_PREM_PAID < planBean.getPLAN_SURR_YRS()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71131"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_SPF_UPTO_DAYS(Integer SPF_UPTO_DAYS) throws Exception{
		try{
			if(SPF_UPTO_DAYS != null){
				if(SPF_UPTO_DAYS < 0 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
				}
				if(SPF_UPTO_DAYS >= 365 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91036"));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_SPF_RATE_PER( Double SPF_RATE_PER) throws Exception{
		try{
			if(CommonUtils.nvl(SPF_RATE_PER, 0) <= 0){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
}

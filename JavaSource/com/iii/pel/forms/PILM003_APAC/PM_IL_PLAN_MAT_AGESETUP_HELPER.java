package com.iii.pel.forms.PILM003_APAC;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PM_IL_PLAN_MAT_AGESETUP_HELPER {

	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PLAN_MAT_AGESETUP_DELEGATE()
				.executeSelectStatement(compositeAction);
	}

	public void whenNewRecordInstance(PM_IL_PLAN_MAT_AGESETUP_ACTION maturityAction){
		PM_IL_PLAN_MAT_AGESETUP maturityBean = null;
		maturityBean = maturityAction.getPM_IL_PLAN_MAT_AGESETUP_BEAN();
		if(maturityBean.getPMA_AGE_BASIS().equals("E")){
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(true);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setDisabled(true);
		}else if(maturityBean.getPMA_AGE_BASIS().equals("R")){
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(true);
		}else if(maturityBean.getPMA_AGE_BASIS().equals("M")){
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setDisabled(false);
		}
		
	}

	public void whenCreateRecord(PM_IL_PLAN_MAT_AGESETUP maturityBean){
		maturityBean.setPMA_AGE_BASIS("R");
	}
	
	
	public void whenValidate_PMA_AGE_BASIS(PM_IL_PLAN_MAT_AGESETUP_ACTION maturityAction){
		PM_IL_PLAN_MAT_AGESETUP maturityBean = null;
		maturityBean = maturityAction.getPM_IL_PLAN_MAT_AGESETUP_BEAN();
		if(maturityBean.getPMA_AGE_BASIS().equals("E")){
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(false);
			maturityBean.setPMA_MAT_PAYER_AGE(null);
			maturityBean.setPMA_MAT_MIN_PAYER_AGE(null);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(true);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setDisabled(true);
		}else if(maturityBean.getPMA_AGE_BASIS().equals("R")){
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYER_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(false);
			maturityBean.setPMA_MAT_PAYEE_AGE(null);
			maturityBean.setPMA_MAT_MIN_PAYEE_AGE(null);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(false);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(true);
		}else if(maturityBean.getPMA_AGE_BASIS().equals("M")){
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYEE_AGE().setDisabled(false);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setRequired(true);
			maturityAction.getCOMP_PMA_MAT_MIN_PAYER_AGE().setDisabled(false);
		}
	}
	
	public void whenValidate_PMA_MAT_MIN_PAYER_AGE(PM_IL_PLAN_MAT_AGESETUP maturityBean ,
							Integer PMA_MAT_MIN_PAYER_AGE) throws Exception{
		if(PMA_MAT_MIN_PAYER_AGE < 0){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91341"));
		}
		if(maturityBean.getPMA_MAT_PAYER_AGE() != null){
		if(PMA_MAT_MIN_PAYER_AGE > maturityBean.getPMA_MAT_PAYER_AGE()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71158"));
		}
		}
	}
	
	public void whenValidate_PMA_MAT_PAYER_AGE(PM_IL_PLAN_MAT_AGESETUP maturityBean ,
			Integer PMA_MAT_PAYER_AGE) throws Exception{
		if(PMA_MAT_PAYER_AGE < 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91341"));
		}
		if(maturityBean.getPMA_MAT_MIN_PAYER_AGE() != null){
		if(PMA_MAT_PAYER_AGE < maturityBean.getPMA_MAT_MIN_PAYER_AGE()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71159"));
		}
		}
	}
	
	public void whenValidate_PMA_MAT_MIN_PAYEE_AGE(PM_IL_PLAN_MAT_AGESETUP maturityBean ,
			Integer PMA_MAT_MIN_PAYEE_AGE) throws Exception{
		if(PMA_MAT_MIN_PAYEE_AGE < 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91341"));
		}
		if(maturityBean.getPMA_MAT_PAYEE_AGE() != null){
		if(PMA_MAT_MIN_PAYEE_AGE > maturityBean.getPMA_MAT_PAYEE_AGE()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71158"));
		}
	}
	}
	
	public void whenValidate_PMA_MAT_PAYEE_AGE(PM_IL_PLAN_MAT_AGESETUP maturityBean ,
			Integer PMA_MAT_PAYEE_AGE) throws Exception{
		if(PMA_MAT_PAYEE_AGE < 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91341"));
		}
		if(maturityBean.getPMA_MAT_MIN_PAYEE_AGE() != null){
		if(PMA_MAT_PAYEE_AGE < maturityBean.getPMA_MAT_MIN_PAYEE_AGE()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71158",new Object[]{maturityBean.getPMA_MAT_MIN_PAYEE_AGE()}));
		}
		}
	}
}

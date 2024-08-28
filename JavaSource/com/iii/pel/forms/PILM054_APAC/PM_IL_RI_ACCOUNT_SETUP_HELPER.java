package com.iii.pel.forms.PILM054_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_RI_ACCOUNT_SETUP_HELPER {
	
	/*
	 * Connection
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	/*
	 * RAS_DIVN_FM_CODE-WHEN-VALIDATE-ITEM
	 */
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_divn_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION action)throws ValidatorException
    {
        try {
        	String DIVN_FM_CODE = (String) action.getCOMP_RAS_DIVN_FM_CODE().getSubmittedValue();
        	if(DIVN_FM_CODE!=null && !DIVN_FM_CODE.trim().equals("")){
        		action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_FM_CODE(DIVN_FM_CODE);
            	action.getCOMP_RAS_DIVN_FM_CODE().setSubmittedValue(DIVN_FM_CODE);
            	action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_TO_CODE(DIVN_FM_CODE);
            	action.getCOMP_RAS_DIVN_TO_CODE().setSubmittedValue(DIVN_FM_CODE);
        	}else{
        		DIVN_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(DIVN_FM_CODE);
        		action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_FM_CODE(DIVN_FM_CODE);
        		action.getCOMP_RAS_DIVN_FM_CODE().setSubmittedValue(DIVN_FM_CODE);
        	}
//        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_divn_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION action)throws ValidatorException
    {
        try {
        	String RAS_DIVN_FM_CODE = action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_FM_CODE();
        	String RAS_DIVN_TO_CODE = action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_TO_CODE();
        	if(RAS_DIVN_TO_CODE!=null && !RAS_DIVN_TO_CODE.equals("0")){
        		action.getCOMP_RAS_DIVN_TO_CODE().setSubmittedValue(RAS_DIVN_TO_CODE);
        	}else{
	        	RAS_DIVN_TO_CODE = (String) action.getCOMP_RAS_DIVN_TO_CODE().getSubmittedValue();
	        	int length = action.getCOMP_RAS_DIVN_TO_CODE().getMaxlength();
	        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_DIVN_FM_CODE, RAS_DIVN_TO_CODE);
	        	RAS_DIVN_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_DIVN_FM_CODE, RAS_DIVN_TO_CODE, length);
	        	action.getCOMP_RAS_DIVN_TO_CODE().setSubmittedValue(RAS_DIVN_TO_CODE);
	        	action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_TO_CODE(RAS_DIVN_TO_CODE);
        	}
//			DB_PROCEDURES.L_VAL_FROM_TO(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());
//			DB_PROCEDURES.P_SET_SECOND_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());//:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE=:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE;
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	/*
	 * RAS_DEPT_FM_CODE_WHEN_VALIDATE_ITEM
	 */
	public void pilm054_apac_pm_il_ri_account_setup_ras_dept_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	{
		try {
        	String RAS_DEPT_FM_CODE = (String) setup_action.getCOMP_RAS_DEPT_FM_CODE().getSubmittedValue();
        	if(RAS_DEPT_FM_CODE!=null && !RAS_DEPT_FM_CODE.trim().equals("")){
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_FM_CODE(RAS_DEPT_FM_CODE);
        		setup_action.getCOMP_RAS_DEPT_FM_CODE().setSubmittedValue(RAS_DEPT_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_TO_CODE(RAS_DEPT_FM_CODE);
        		setup_action.getCOMP_RAS_DEPT_TO_CODE().setSubmittedValue(RAS_DEPT_FM_CODE);
        	}else{
        		RAS_DEPT_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_DEPT_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_FM_CODE(RAS_DEPT_FM_CODE);
        		setup_action.getCOMP_RAS_DEPT_FM_CODE().setSubmittedValue(RAS_DEPT_FM_CODE);
        	}
//        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*
	 * RAS_DEPT_TO_CODE_WHEN_VALIDATE
	 */
	public void pilm054_apac_pm_il_ri_account_setup_ras_dept_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
    {
		try {
        	String RAS_DEPT_FM_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_FM_CODE();
        	String RAS_DEPT_TO_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_TO_CODE();
        	if(RAS_DEPT_TO_CODE!=null && !RAS_DEPT_TO_CODE.equals("0")){
        		setup_action.getCOMP_RAS_DEPT_TO_CODE().setSubmittedValue(RAS_DEPT_TO_CODE);
        	}else{
        		RAS_DEPT_TO_CODE = (String) setup_action.getCOMP_RAS_DEPT_TO_CODE().getSubmittedValue();
	        	int length = setup_action.getCOMP_RAS_DEPT_TO_CODE().getMaxlength();
	        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_DEPT_FM_CODE, RAS_DEPT_TO_CODE);
	        	RAS_DEPT_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_DEPT_FM_CODE, RAS_DEPT_TO_CODE, length);
	        	setup_action.getCOMP_RAS_DEPT_TO_CODE().setSubmittedValue(RAS_DEPT_TO_CODE);
	        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_TO_CODE(RAS_DEPT_TO_CODE);
        	}
//			DB_PROCEDURES.L_VAL_FROM_TO(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());
//			DB_PROCEDURES.P_SET_SECOND_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());//:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE=:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE;
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	/*
	 * RAS_CLASS_FM_CODE_WHEN_VALIDATE
	 */
	public void pilm054_apac_pm_il_ri_account_setup_ras_class_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
    {
		try {
        	String RAS_CLASS_FM_CODE = (String) setup_action.getCOMP_RAS_CLASS_FM_CODE().getSubmittedValue();
        	if(RAS_CLASS_FM_CODE!=null && !RAS_CLASS_FM_CODE.trim().equals("")){
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CLASS_FM_CODE(RAS_CLASS_FM_CODE);
        		setup_action.getCOMP_RAS_CLASS_FM_CODE().setSubmittedValue(RAS_CLASS_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CLASS_TO_CODE(RAS_CLASS_FM_CODE);
        		setup_action.getCOMP_RAS_CLASS_TO_CODE().setSubmittedValue(RAS_CLASS_FM_CODE);
        	}else{
        		RAS_CLASS_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_CLASS_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CLASS_FM_CODE(RAS_CLASS_FM_CODE);
        		setup_action.getCOMP_RAS_CLASS_FM_CODE().setSubmittedValue(RAS_CLASS_FM_CODE);
        	}
//        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	/*
	 * RAS_CLASS_TO_CODE_WHEN_VALIDATE
	 */
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_class_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
    {
		try {
        	String RAS_CLASS_FM_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CLASS_FM_CODE();
        	String RAS_CLASS_TO_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CLASS_TO_CODE();
        	if(RAS_CLASS_TO_CODE!=null && !RAS_CLASS_TO_CODE.equals("0")){
        		setup_action.getCOMP_RAS_CLASS_TO_CODE().setSubmittedValue(RAS_CLASS_TO_CODE);
        	}else{
        		RAS_CLASS_TO_CODE = (String) setup_action.getCOMP_RAS_CLASS_TO_CODE().getSubmittedValue();
	        	int length = setup_action.getCOMP_RAS_CLASS_TO_CODE().getMaxlength();
	        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_CLASS_FM_CODE, RAS_CLASS_TO_CODE);
	        	RAS_CLASS_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_CLASS_FM_CODE, RAS_CLASS_TO_CODE, length);
	        	setup_action.getCOMP_RAS_CLASS_TO_CODE().setSubmittedValue(RAS_CLASS_TO_CODE);
	        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CLASS_TO_CODE(RAS_CLASS_TO_CODE);
        	}
//			DB_PROCEDURES.L_VAL_FROM_TO(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());
//			DB_PROCEDURES.P_SET_SECOND_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(),action.getCOMP_RAS_DIVN_TO_CODE());//:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE=:PM_IL_RI_ACCOUNT_SETUP.RAS_DIVN_TO_CODE;
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	/*
	 * RAS_SRC_BUS_FM_WHEN_VALIDATE
	 */
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_src_bus_fm_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
    {
		try {
        	String RAS_SRC_BUS_FM = (String) setup_action.getCOMP_RAS_SRC_BUS_FM().getSubmittedValue();
        	if(RAS_SRC_BUS_FM!=null && !RAS_SRC_BUS_FM.trim().equals("")){
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SRC_BUS_FM(RAS_SRC_BUS_FM);
        		setup_action.getCOMP_RAS_SRC_BUS_FM().setSubmittedValue(RAS_SRC_BUS_FM);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SRC_BUS_TO(RAS_SRC_BUS_FM);
        		setup_action.getCOMP_RAS_SRC_BUS_TO().setSubmittedValue(RAS_SRC_BUS_FM);
        	}else{
        		RAS_SRC_BUS_FM = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_SRC_BUS_FM);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SRC_BUS_FM(RAS_SRC_BUS_FM);
        		setup_action.getCOMP_RAS_SRC_BUS_FM().setSubmittedValue(RAS_SRC_BUS_FM);
        	}
//        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
//		pilm054_apac_pm_il_ri_account_setup_ras_src_bus_to_when_validate_item(setup_action);
    }
	
	/*
	 * RAS_SRC_BUS_TO_WHEN_VALIDATE
	 */
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_src_bus_to_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
    {
		try {
        	String RAS_SRC_BUS_FM = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_FM();
        	String RAS_SRC_BUS_TO = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_TO();
        	if(RAS_SRC_BUS_TO!=null && !RAS_SRC_BUS_TO.equals("0")){
        		setup_action.getCOMP_RAS_SRC_BUS_TO().setSubmittedValue(RAS_SRC_BUS_TO);
        	}else{
        		RAS_SRC_BUS_TO = (String) setup_action.getCOMP_RAS_SRC_BUS_TO().getSubmittedValue();
	        	int length = setup_action.getCOMP_RAS_SRC_BUS_TO().getMaxlength();
	        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_SRC_BUS_FM, RAS_SRC_BUS_TO);
	        	RAS_SRC_BUS_TO = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_SRC_BUS_FM, RAS_SRC_BUS_TO, length);
	        	setup_action.getCOMP_RAS_SRC_BUS_TO().setSubmittedValue(RAS_SRC_BUS_TO);
	        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SRC_BUS_TO(RAS_SRC_BUS_TO);
        	}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
	
	/*
	 * RAS_PROD_FM_CODE_WHEN_VALIDATE
	 */
	
	public void pilm054_apac_pm_il_ri_account_setup_ras_prod_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	{
		try {
        	String RAS_PROD_FM_CODE = (String) setup_action.getCOMP_RAS_PROD_FM_CODE().getSubmittedValue();
        	if(RAS_PROD_FM_CODE!=null && !RAS_PROD_FM_CODE.trim().equals("")){
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_PROD_FM_CODE(RAS_PROD_FM_CODE);
        		setup_action.getCOMP_RAS_PROD_FM_CODE().setSubmittedValue(RAS_PROD_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_PROD_TO_CODE(RAS_PROD_FM_CODE);
        		setup_action.getCOMP_RAS_PROD_TO_CODE().setSubmittedValue(RAS_PROD_FM_CODE);
        	}else{
        		RAS_PROD_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_PROD_FM_CODE);
        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_PROD_FM_CODE(RAS_PROD_FM_CODE);
        		setup_action.getCOMP_RAS_PROD_FM_CODE().setSubmittedValue(RAS_PROD_FM_CODE);
        	}
//        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
//		pilm054_apac_pm_il_ri_account_setup_ras_prod_to_code_when_validate_item(setup_action);
	}
	 
	 /*
	  * RAS_PROD_TO_CODE_WHEN_VALIDATE
	  */
	
	 public void pilm054_apac_pm_il_ri_account_setup_ras_prod_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
	        	String RAS_PROD_FM_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_FM_CODE();
	        	String RAS_PROD_TO_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_TO_CODE();
	        	if(RAS_PROD_TO_CODE!=null && !RAS_PROD_TO_CODE.equals("0")){
	        		setup_action.getCOMP_RAS_PROD_TO_CODE().setSubmittedValue(RAS_PROD_TO_CODE);
	        	}else{
	        		RAS_PROD_TO_CODE = (String) setup_action.getCOMP_RAS_PROD_TO_CODE().getSubmittedValue();
		        	int length = setup_action.getCOMP_RAS_PROD_TO_CODE().getMaxlength();
		        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_PROD_FM_CODE, RAS_PROD_TO_CODE);
		        	RAS_PROD_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_PROD_FM_CODE, RAS_PROD_TO_CODE, length);
		        	setup_action.getCOMP_RAS_PROD_TO_CODE().setSubmittedValue(RAS_PROD_TO_CODE);
		        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_PROD_TO_CODE(RAS_PROD_TO_CODE);
	        	}
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	 }
	/*
	 * RAS_COVER_FM_CODE_WHEN_VALIDATE
	 */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_cover_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
	        	String RAS_COVER_FM_CODE = (String) setup_action.getCOMP_RAS_COVER_FM_CODE().getSubmittedValue();
	        	if(RAS_COVER_FM_CODE!=null && !RAS_COVER_FM_CODE.trim().equals("")){
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_COVER_FM_CODE(RAS_COVER_FM_CODE);
	        		setup_action.getCOMP_RAS_COVER_FM_CODE().setSubmittedValue(RAS_COVER_FM_CODE);
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_COVER_TO_CODE(RAS_COVER_FM_CODE);
	        		setup_action.getCOMP_RAS_COVER_TO_CODE().setSubmittedValue(RAS_COVER_FM_CODE);
	        	}else{
	        		RAS_COVER_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_COVER_FM_CODE);
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_COVER_FM_CODE(RAS_COVER_FM_CODE);
	        		setup_action.getCOMP_RAS_COVER_FM_CODE().setSubmittedValue(RAS_COVER_FM_CODE);
	        	}
//	        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
//		 pilm054_apac_pm_il_ri_account_setup_ras_cover_to_code_when_validate_item(setup_action);
	 }
	
	 /*
	  * RAS_COVER_TO_CODE_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_cover_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action)  throws ValidatorException
	 {
		 try {
	        	String RAS_COVER_FM_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_COVER_FM_CODE();
	        	String RAS_COVER_TO_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_COVER_TO_CODE();
	        	if(RAS_COVER_TO_CODE!=null && !RAS_COVER_TO_CODE.equals("0")){
	        		setup_action.getCOMP_RAS_COVER_TO_CODE().setSubmittedValue(RAS_COVER_TO_CODE);
	        	}else{
	        		RAS_COVER_TO_CODE = (String) setup_action.getCOMP_RAS_COVER_TO_CODE().getSubmittedValue();
		        	int length = setup_action.getCOMP_RAS_COVER_TO_CODE().getMaxlength();
		        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_COVER_FM_CODE, RAS_COVER_TO_CODE);
		        	RAS_COVER_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_COVER_FM_CODE, RAS_COVER_TO_CODE, length);
		        	setup_action.getCOMP_RAS_COVER_TO_CODE().setSubmittedValue(RAS_COVER_TO_CODE);
		        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_COVER_TO_CODE(RAS_COVER_TO_CODE);
	        	}
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	 }
	 
	 /*
	  * RAS_CUST_CLS_FM_CODE_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_cust_cls_fm_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
	        	String RAS_CUST_CLS_FM_CODE = (String) setup_action.getCOMP_RAS_CUST_CLS_FM_CODE().getSubmittedValue();
	        	if(RAS_CUST_CLS_FM_CODE!=null && !RAS_CUST_CLS_FM_CODE.trim().equals("")){
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CUST_CLS_FM_CODE(RAS_CUST_CLS_FM_CODE);
	        		setup_action.getCOMP_RAS_CUST_CLS_FM_CODE().setSubmittedValue(RAS_CUST_CLS_FM_CODE);
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CUST_CLS_TO_CODE(RAS_CUST_CLS_FM_CODE);
	        		setup_action.getCOMP_RAS_CUST_CLS_TO_CODE().setSubmittedValue(RAS_CUST_CLS_FM_CODE);
	        	}else{
	        		RAS_CUST_CLS_FM_CODE = (String) DB_PROCEDURES.P_SET_FIRST_FIELD(RAS_CUST_CLS_FM_CODE);
	        		setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CUST_CLS_FM_CODE(RAS_CUST_CLS_FM_CODE);
	        		setup_action.getCOMP_RAS_CUST_CLS_FM_CODE().setSubmittedValue(RAS_CUST_CLS_FM_CODE);
	        	}
//	        	DB_PROCEDURES.P_SET_FIRST_FIELD(action.getCOMP_RAS_DIVN_FM_CODE(), action.getCOMP_RAS_DIVN_TO_CODE());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	 }
	 
	 /*
	  * RAS_CUST_CLS_TO_CODE_WHEN_VALIDATE
	  */ 
	 public void pilm054_apac_pm_il_ri_account_setup_ras_cust_cls_to_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
	        	String RAS_CUST_CLS_FM_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_FM_CODE();
	        	String RAS_CUST_CLS_TO_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_TO_CODE();
	        	if(RAS_CUST_CLS_TO_CODE!=null && !RAS_CUST_CLS_TO_CODE.equals("0")){
	        		setup_action.getCOMP_RAS_CUST_CLS_TO_CODE().setSubmittedValue(RAS_CUST_CLS_TO_CODE);
	        	}else{
	        		RAS_CUST_CLS_TO_CODE = (String) setup_action.getCOMP_RAS_CUST_CLS_TO_CODE().getSubmittedValue();
		        	int length = setup_action.getCOMP_RAS_CUST_CLS_TO_CODE().getMaxlength();
		        	DB_PROCEDURES.L_VAL_FROM_TO(RAS_CUST_CLS_FM_CODE, RAS_CUST_CLS_TO_CODE);
		        	RAS_CUST_CLS_TO_CODE = (String) DB_PROCEDURES.P_SET_SECOND_FIELD(RAS_CUST_CLS_FM_CODE, RAS_CUST_CLS_TO_CODE, length);
		        	setup_action.getCOMP_RAS_CUST_CLS_TO_CODE().setSubmittedValue(RAS_CUST_CLS_TO_CODE);
		        	setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CUST_CLS_TO_CODE(RAS_CUST_CLS_TO_CODE);
	        	}
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	 }
	
	/*
	 * RAS_NB_REN_TYPE_WHEN_VALIDATE
	 */ 
	 public void pilm054_apac_pm_il_ri_account_setup_ras_nb_ren_type_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 if(setup_action.getCOMP_RAS_NB_REN_TYPE().getSubmittedValue()== null)
		 {
			 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206")); 
		 }
	 }
	 
	 /*
	  * RAS_FORCE_DIVN_YN_WHEN_VALIDATE_ITEM
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_force_divn_yn_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException {
		 String RAS_FORCE_DIVN_YN = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DIVN_YN();
		 if(RAS_FORCE_DIVN_YN== null) {
			 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206"));
		 }
		 if((RAS_FORCE_DIVN_YN==null?"N":RAS_FORCE_DIVN_YN).equals("Y")){
			 setup_action.getCOMP_RAS_DIVN_CODE().setDisabled(true);
			 setup_action.getCOMP_RAS_DIVN_CODE().setRequired(false);
		 }
		 if((RAS_FORCE_DIVN_YN==null?"N":RAS_FORCE_DIVN_YN).equals("N")){
			 setup_action.getCOMP_RAS_DIVN_CODE().setDisabled(false);
			 setup_action.getCOMP_RAS_DIVN_CODE().setRequired(true);
		 }
		 setup_action.getCOMP_RAS_FORCE_DEPT_YN().setSubmittedValue(RAS_FORCE_DIVN_YN);
		 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DEPT_YN(RAS_FORCE_DIVN_YN);
	 }
	 
	 /*
	  * RAS_FORCE_DIVN_YN_WHEN_LIST_CHANGED
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_force_divn_yn_when_list_changed(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException{
		 String RAS_FORCE_DIVN_YN = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DIVN_YN();
		 if((RAS_FORCE_DIVN_YN==null?"N":RAS_FORCE_DIVN_YN).equals("Y")) {
			 setup_action.getCOMP_RAS_DIVN_CODE().setDisabled(true);
			 setup_action.getCOMP_RAS_DIVN_CODE().setRequired(false);
		 }
		 if((RAS_FORCE_DIVN_YN==null?"N":RAS_FORCE_DIVN_YN).equals("N")) {
			 setup_action.getCOMP_RAS_DIVN_CODE().setDisabled(false);
			 setup_action.getCOMP_RAS_DIVN_CODE().setRequired(true);
		 }
		 setup_action.getCOMP_RAS_FORCE_DEPT_YN().setSubmittedValue(null);
		 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DEPT_YN(RAS_FORCE_DIVN_YN);
		 pilm054_apac_pm_il_ri_account_setup_ras_force_dept_yn_when_validate_item(setup_action);
	 }
	
	 /*
	  * RAS_FORCE_DEPT_YN_WHEN_VALIDATE_ITEM
	  */
	 
	 public void pilm054_apac_pm_il_ri_account_setup_ras_force_dept_yn_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException {
		 String RAS_FORCE_DEPT_YN = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DEPT_YN();
		 String RAS_FORCE_DIVN_YN = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DIVN_YN();
		 if(RAS_FORCE_DEPT_YN== null) {
			 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206"));
		 }
		 if((RAS_FORCE_DEPT_YN==null?"N":RAS_FORCE_DEPT_YN).equals("Y")) {
			 setup_action.getCOMP_RAS_DEPT_CODE().setDisabled(true);
			 setup_action.getCOMP_RAS_DEPT_CODE().setRequired(false);
		 }
		 if((RAS_FORCE_DEPT_YN==null?"N":RAS_FORCE_DEPT_YN).equals("N")) {
			 setup_action.getCOMP_RAS_DEPT_CODE().setDisabled(false);
			 setup_action.getCOMP_RAS_DEPT_CODE().setRequired(true);
		 }
		 setup_action.getCOMP_RAS_FORCE_DEPT_YN().setSubmittedValue(RAS_FORCE_DIVN_YN);
		 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_FORCE_DEPT_YN(RAS_FORCE_DIVN_YN);
	 }
	 
	 public void RAS_FORCE_DIVN_YNWhenListChanged() throws ValidatorException {
		 PILM054_APAC_COMPOSITE_ACTION compositeAction = getManagedBeanActionInstance();
		 PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		 String RAS_FORCE_DIVN_YN = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DIVN_YN();
		 if((RAS_FORCE_DIVN_YN==null?"N":RAS_FORCE_DIVN_YN).equals("Y")){
			 riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setDisabled(true);
			 riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setRequired(false);
		 }else{
			 riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setDisabled(false);
			 riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setRequired(true);
		 }
		 pilm054_apac_pm_il_ri_account_setup_ras_divn_code_when_validate_item(riAccountSetupAction);
	 }
	 
	 public void RAS_FORCE_DEPT_YNWhenListChanged() throws ValidatorException {
		 PILM054_APAC_COMPOSITE_ACTION compositeAction = getManagedBeanActionInstance();
		 PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		 String RAS_FORCE_DEPT_YN = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DEPT_YN();
		 if((RAS_FORCE_DEPT_YN==null?"N":RAS_FORCE_DEPT_YN).equals("Y")){
			 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setDisabled(true);
			 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setRequired(false);
		 }else{
			 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setDisabled(false);
			 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setRequired(true);
		 }
	 }
	 
	 /*
	  * MAIN_ACNT_CODE_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_main_acnt_code_when_validate_item(PILM054_APAC_COMPOSITE_ACTION compositeAction) throws ValidatorException
	 {
		 Connection connection = null;
		 CRUDHandler handler = new CRUDHandler();
		 String M_TEMP1=null;
		 String M_TEMP2=null;
		 ResultSet resultSetsql_C1 = null;
		 ResultSet resultSetsql_C2 = null;
		 ResultSet resultSetsql_C3 = null;
			connection = getConnection();
			PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action = compositeAction.getActionBean();
		

		 String sql_C1=PM_IL_RI_ACCOUNT_SETUP_SQL_CONSTANTS.MAIN_ACNT_CODE_SQL_QUERY1;
		 String M_ACTY_1 = null;
		 String M_ACTY_2 = null;
		 try {
			String mainAccountName = DB_PROCEDURES.L_VAL_MAIN_ACNT(setup_action
					.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE(),
					null, "N", "E");
			setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN()
					.setRAS_MAIN_ACNT_CODE_DESC(mainAccountName);
			setup_action.getCOMP_RAS_MAIN_ACNT_CODE_DESC().setSubmittedValue(
					mainAccountName);
			DB_PROCEDURES.L_VAL_MAIN_ACTIVITY(compositeAction);

			Object[] objectsql_C1 = { setup_action
					.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE() };

			resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
					connection, objectsql_C1);
			if (resultSetsql_C1.next()) {
				M_ACTY_1 = resultSetsql_C1.getString(1);
				M_ACTY_2 = resultSetsql_C1.getString(2);
			}
			setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_1(
					M_ACTY_1);
			setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_2(
					M_ACTY_2);
			
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ACTY_1(M_ACTY_1);
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ACTY_2(M_ACTY_2);
			if(M_ACTY_1 != null) {
				String sql_C2=PM_IL_RI_ACCOUNT_SETUP_SQL_CONSTANTS.MAIN_ACNT_CODE_SQL_QUERY2;
				Object[] objectsql_C2 = {M_ACTY_1};
				resultSetsql_C2 = handler.executeSelectStatement(sql_C2, connection, objectsql_C2);
				
				if(resultSetsql_C2.next()){
					M_TEMP1=resultSetsql_C2.getString(1);
					setup_action.getCOMP_RAS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
					
				}
				
				// :BP.B_RAS_ACTY_CODE_1=StringFunctions.initcap(M_TEMP1);
				CommonUtils.closeCursor(resultSetsql_C2);
			} else {
				// :BP.B_RAS_ACTY_CODE_1="ACTIVITY CODE1";
			}
			if(M_ACTY_2 != null) {
				String sql_C3=PM_IL_RI_ACCOUNT_SETUP_SQL_CONSTANTS.MAIN_ACNT_CODE_SQL_QUERY3;
				Object[] objectsql_C3 = {M_ACTY_2};
				resultSetsql_C3 = handler.executeSelectStatement(sql_C3, connection, objectsql_C3);
				
				if(resultSetsql_C3.next()) {
					M_TEMP2=resultSetsql_C3.getString(1);
					setup_action.getCOMP_RAS_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
					
				}
				//:BP.B_RAS_ACTY_CODE_2=StringFunctions.initcap(M_TEMP2);
				CommonUtils.closeCursor(resultSetsql_C3);
			} else {
				//:BP.B_RAS_ACTY_CODE_2="ACTIVITY CODE2";
			}
			CommonUtils.closeCursor(resultSetsql_C1);
		 } catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try{
					CommonUtils.closeCursor(resultSetsql_C1);
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
		 }
	
	 /*
	  * RAS_SUB_ACNT_CODE_WHEN_VALIDATE 
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_sub_acnt_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws Exception {
		 //setup_action.getCOMP_RAS_SUB_ACNT_CODE_DESC()=null;
		 if(setup_action.getCOMP_RAS_SUB_ACNT_CODE_DESC() != null) {
			 ArrayList<String> list;
			try {
				list = DB_PROCEDURES.P_VAL_SUB_ACNT(setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE(),
						setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SUB_ACNT_CODE(),"N","E");
				if(list!= null && list.size()>0){
					setup_action.getCOMP_RAS_SUB_ACNT_CODE_DESC().setSubmittedValue(list.get(0));
					setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SUB_ACNT_CODE_DESC(list.get(0));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		 }
	 }
	 
	 /*
	  * RAS_DIVN_CODE_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_divn_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
			 String RAS_DIVN_CODE = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_CODE();
			 setup_action.getCOMP_RAS_DIVN_CODE_DESC().setSubmittedValue(null);
			 if(RAS_DIVN_CODE != null)
			 {
				 ArrayList<String> list;
					list = DB_PROCEDURES.F_VAL_DIVN(RAS_DIVN_CODE,"N","E");
					if(list!= null && list.size()>0){
						setup_action.getCOMP_RAS_DIVN_CODE_DESC().setSubmittedValue((list.get(0)));
						setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DIVN_CODE_DESC(list.get(0));
					}
			 }
			 DB_PROCEDURES.L_SET_DEPT_ATTR();
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
		 //:PM_IL_RI_ACCOUNT_SETUP.RAS_DEPT_CODE=:PM_IL_RI_ACCOUNT_SETUP.RAS_DEPT_CODE;
	 }
	 
	 /*
	  * RAS_DEPT_CODE_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_dept_code_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
			 if(setup_action.getCOMP_RAS_DEPT_CODE() != null){
				 ArrayList<String> list;
				 /**
				  * [BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc
				  *  instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Mallika.S 30-Mar-2009
				  */
					//list = DB_PROCEDURES.F_VAL_DEPT(setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_CODE(),setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_CODE(),"N","E");
				   list = new DBProcedures().callP_VAL_DEPT(setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_CODE(),
						   setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_CODE(),"N","E");
					if(list!= null && list.size()>0){
						setup_action.getCOMP_RAS_DEPT_CODE_DESC().setSubmittedValue((list.get(0)));
						setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_CODE_DESC(list.get(0));
					}
			 }
			 String RAS_FORCE_DEPT_YN = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DEPT_YN();
			 if((RAS_FORCE_DEPT_YN==null?"N":RAS_FORCE_DEPT_YN).equals("N")){
				 setup_action.getCOMP_RAS_DEPT_CODE().setRequired(true);
	//			 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_RI_ACCOUNT_SETUP.RAS_DEPT_CODE",REQUIRED,PROPERTY_TRUE);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 
	 /*
	  * RAS_DEPT_CODE_WHEN_NEW_ITEM_INSTANCE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_dept_code_when_new_item_instance() throws ValidatorException
	 {
		 try {
			DB_PROCEDURES.L_SET_DEPT_ATTR();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	 }
	 
	 /*
	  * RAS_ACTY_CODE_1_WHEN_VALIDATE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_acty_code_1_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action,String M_TEMP_1) throws ValidatorException {
		 try {
			 setup_action.getCOMP_RAS_ACTY_CODE_1_DESC().setSubmittedValue(null);
			 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_1_DESC(null);
			 String RAS_ACTY_CODE_1	= setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_ACTY_CODE_1();
			 if(RAS_ACTY_CODE_1 != null)
			 {
				 ArrayList<String> list;
					//list = DB_PROCEDURES.P_VAL_ACTY(setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_1(),RAS_ACTY_CODE_1,"N","E");
				 list = DB_PROCEDURES.P_VAL_ACTY(M_TEMP_1,RAS_ACTY_CODE_1,"N","E");
				 if(list != null && list.size()>0){
					 setup_action.getCOMP_RAS_ACTY_CODE_1_DESC().setSubmittedValue(list.get(0));
					 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_1_DESC(list.get(0));
				 }
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 
	 /*
	  * RAS_ACTY_CODE_2_WHEN_VALIDATE_ITEM
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_acty_code_2_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action,String M_ACTY_2) throws ValidatorException {
		 try {
			 setup_action.getCOMP_RAS_ACTY_CODE_2_DESC().setSubmittedValue(null);
			 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_2_DESC(null);
			 String RAS_ACTY_CODE_2 = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_ACTY_CODE_2();
			 if(RAS_ACTY_CODE_2 != null) {
				 ArrayList<String> list;
					//list = DB_PROCEDURES.P_VAL_ACTY(setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getUI_M_ACTY_2(),RAS_ACTY_CODE_2,"N","E");
				 list = DB_PROCEDURES.P_VAL_ACTY(M_ACTY_2,RAS_ACTY_CODE_2,"N","E");
				 if(list != null && list.size()>0){
					 setup_action.getCOMP_RAS_ACTY_CODE_2_DESC().setSubmittedValue(list.get(0));
					 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_2_DESC(list.get(0));
				 }
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 /*
	  * RAS_ANLY_CODE_2_WHEN_VALIDATE_ITEM
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_anly_code_2_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
			 setup_action.getCOMP_RAS_ANLY_CODE_2_DESC().setSubmittedValue(null);
			 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_2_DESC(null);
			 String RAS_ANLY_CODE_2 = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_ANLY_CODE_2();
			 if(RAS_ANLY_CODE_2 != null) {
				 ArrayList<String> list;
					list = DB_PROCEDURES.P_VAL_ANLY("2",setup_action.getCOMP_RAS_ANLY_CODE_2().getSubmittedValue().toString(),"N","E");
				 if(list!= null && list.size()>0){
					 setup_action.getCOMP_RAS_ANLY_CODE_2_DESC().setSubmittedValue(list.get(0));
					 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_2_DESC(list.get(0));
				 }
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 
	 /*
	  * RAS_ANLY_CODE_2_WHEN_NEW_ITEM_INSTANCE
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_anly_code_2_when_new_item_instance(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
			DB_PROCEDURES.L_SET_ANALYSIS_ATTR();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	 }
	 
	 /*
	  * RAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM
	  */
	 public void pilm054_apac_pm_il_ri_account_setup_ras_anly_code_1_when_validate_item(PM_IL_RI_ACCOUNT_SETUP_ACTION setup_action) throws ValidatorException
	 {
		 try {
			 setup_action.getCOMP_RAS_ANLY_CODE_1_DESC().setSubmittedValue(null);
			 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_1_DESC(null);
			 String RAS_ANLY_CODE_1 = setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_ANLY_CODE_1();
			 if(RAS_ANLY_CODE_1 != null) {
				 ArrayList<String> list;
					list = DB_PROCEDURES.P_VAL_ANLY("1",RAS_ANLY_CODE_1,"N","E");
				 if(list != null && list.size()>0){
					 setup_action.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ANLY_CODE_1_DESC(list.get(0));
					 setup_action.getCOMP_RAS_ANLY_CODE_1_DESC().setSubmittedValue(list.get(0));
				 }
			 }
			 DB_PROCEDURES.L_SET_ANALYSIS_ATTR();
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }
	 
	 public PILM054_APAC_COMPOSITE_ACTION getManagedBeanActionInstance(){
		 return (PILM054_APAC_COMPOSITE_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM054_APAC_COMPOSITE_ACTION");
	 }
	 
	 
}

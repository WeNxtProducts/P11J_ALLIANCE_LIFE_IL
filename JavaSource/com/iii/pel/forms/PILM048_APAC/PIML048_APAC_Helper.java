/**
 * 
 */
package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

/**
 * @author 55368
 *
 */
public class PIML048_APAC_Helper {
	
	/**
	 * 
	 * @param action
	 * @throws Exception 
	 */
	public void listChangePayMode(PM_BANK_CHARGE_SETUP_HDR_ACTION action) throws Exception{
		String payMode = action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_MODE();
		String C1 = "SELECT 'X'	FROM PP_SYSTEM	WHERE PS_TYPE = 'IL_AUTO_DEBT' AND PS_CODE	= ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_DUMMY = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{payMode});
			if(C1_REC.next()){
				M_DUMMY = C1_REC.getString(1);
			}
			if(M_DUMMY!=null){
				action.getCOMP_BCSH_TRAN_TYPE().setDisabled(false);
			}else{
				action.getCOMP_BCSH_TRAN_TYPE().setDisabled(true);
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * 
	 * @param PM_BANK_CHARGE_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void validateProdFm(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN ) throws Exception{
		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String TEMP = null;
		
		try {
			PILM048_APAC_PROCEDURES procedures = new PILM048_APAC_PROCEDURES();
			procedures.L_VAL_FROM_TO(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM(), PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO());
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()});
				if (C1_REC.next()) {
					TEMP = C1_REC.getString(1);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateSubAcctCode(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) throws Exception{
			try{
				DBProcedures procedures = new DBProcedures();
				List<String> list = procedures.P_VAL_SUB_ACNT(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_MAIN_ACNT_CODE(),
						PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_SUB_ACNT_CODE(), "N", "E");
				if(list!=null){
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setSUB_ACNT_DESC(list.get(0));
				}
				
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateDivnCode(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) throws Exception{
		if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE()!=null){
			try{
				DBProcedures procedures = new DBProcedures();
				//procedures.F_VAL_DIVN(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE(), "N", "E");
				LIFELIB lifelib = new LIFELIB();
				lifelib.P_VAL_DIVN(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE(), null, "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDIVN_CODE_DESC("");
		}
	}
	
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateDeptCode(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) throws Exception{
		if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DEPT_CODE()!=null){
			try{
				DBProcedures.F_VAL_DEPT(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE(), PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DEPT_CODE(), "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDEPT_CODE_DESC("");
		}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateAnly_1Code(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) throws Exception{
		if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_1()!=null){
			try{
				DBProcedures procedures = new DBProcedures();
				procedures.P_VAL_ANLY1("1", PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_1(), "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_1_DESC("");
		}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateAnly_2Code(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) throws Exception{
		if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_2()!=null){
			try{
				DBProcedures procedures = new DBProcedures();
				procedures.P_VAL_ANLY1("2", PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_2(), "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_2_DESC("");
		}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateACTY_1Code(PM_BANK_CHARGE_SETUP_HDR_ACTION action) throws Exception{
		if(action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_ACTY_CODE_1()!=null){
			try{
				DBProcedures.P_VAL_ACTY(action.getDUMMY_BEAN().getUI_M_ACTY_1(), action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_ACTY_CODE_1(), "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().setANLY_CODE_1_DESC("");
		}
	}
	
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateACTY_2Code(PM_BANK_CHARGE_SETUP_HDR_ACTION action) throws Exception{
		if(action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_ACTY_CODE_2()!=null){
			try{
				DBProcedures.P_VAL_ACTY(action.getDUMMY_BEAN().getUI_M_ACTY_2(), action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_ACTY_CODE_2(), "N", "E");
				//procedures.P_VAL_ACTY1(action.getDUMMY_BEAN().getUI_M_ACTY_2(), action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_ACTY_CODE_2(), "N", "E");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		}else{
			action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().setANLY_CODE_2_DESC("");
		}
	}
	/**
	 * 
	 * @param action
	 * @throws Exception
	 */
	public void validateMainAcctCode(PM_BANK_CHARGE_SETUP_HDR_ACTION action) throws Exception{
			DBProcedures procedures = new DBProcedures();
			PILM048_APAC_PROCEDURES pilm048_apac_procedures = new PILM048_APAC_PROCEDURES();
			String mainAcctCode = action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_MAIN_ACNT_CODE();
			
			ResultSet C1_REC = null;
			ResultSet C2_REC = null;
			ResultSet C3_REC = null;
			
			Connection connection = null;
			CRUDHandler handler = null;
			String M_TEMP1 = null;
			String M_TEMP2 = null;
			try{
				connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
				String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2  FROM   FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE = ? ";
				String C2 = "SELECT ACTY_NAME FROM   FM_ACTIVITY  WHERE  ACTY_CODE = ?";
				String C3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY  WHERE  ACTY_CODE = ?";
				if(mainAcctCode == null){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80025"));
				}
				if(mainAcctCode!=null){
					action.getCOMP_BCSH_ACTY_CODE_1().setDisabled(false);
					action.getCOMP_BCSH_ACTY_CODE_2().setDisabled(false);
					procedures.P_VAL_MAIN_ACNT(action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_MAIN_ACNT_CODE(), "N", "E");
					pilm048_apac_procedures.L_VAL_SUB_ACCOUNT(action);
					
					C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_MAIN_ACNT_CODE()});
					if (C1_REC.next()) {
						action.getDUMMY_BEAN().setUI_M_ACTY_1(C1_REC.getString(1));
						action.getDUMMY_BEAN().setUI_M_ACTY_2(C1_REC.getString(2));
					}
					
					if(action.getDUMMY_BEAN().getUI_M_ACTY_1()!=null){
						C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{action.getDUMMY_BEAN().getUI_M_ACTY_1()});
						if(C2_REC.next()){
							M_TEMP1 = C2_REC.getString(1);
							action.getCOMP_BCSH_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
							action.getCOMP_BCSH_ACTY_CODE_1().setDisabled(false);
						}else{
							action.getCOMP_BCSH_ACTY_CODE_1_LABEL().setValue("Activity code1");
							action.getCOMP_BCSH_ACTY_CODE_1().setDisabled(true);
						}
					}
					
					
					if(action.getDUMMY_BEAN().getUI_M_ACTY_2()!=null){
						C3_REC = handler.executeSelectStatement(C3, connection,new Object[]{action.getDUMMY_BEAN().getUI_M_ACTY_2()});
						if(C3_REC.next()){
							M_TEMP2 = C3_REC.getString(1);
							action.getCOMP_BCSH_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
							action.getCOMP_BCSH_ACTY_CODE_2().setDisabled(false);
						}else{
							action.getCOMP_BCSH_ACTY_CODE_2_LABEL().setValue("Activity code1");
							action.getCOMP_BCSH_ACTY_CODE_2().setDisabled(true);
						}
					}
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80025",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			
			
			
			 } catch(Exception e) {
				   	ErrorHelpUtil.getErrorForProcedure(connection);
				          throw new ProcedureException(e.getMessage());
			}
	}
	
	/**
	 * 
	 * @param PM_BANK_CHARGE_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void validateProdTo(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN ) throws Exception{
		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_DUMMY = null;
		
		try {
			PILM048_APAC_PROCEDURES procedures = new PILM048_APAC_PROCEDURES();
			procedures.L_VAL_FROM_TO(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM(), PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO());
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()!=null &&
					!"zzzzzzzzzzzzzzzzzzzzzz".equalsIgnoreCase(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO())){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()});
				if (C1_REC.next()) {
					M_DUMMY = C1_REC.getString(1);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}
		}catch(Exception exception){
			throw exception;
		}
	}
}

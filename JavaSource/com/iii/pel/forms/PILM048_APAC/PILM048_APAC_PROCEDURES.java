/**
 * 
 */
package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PILM048_APAC_PROCEDURES {

	/**
	 * 
	 * @param P_BANK_CODE
	 * @param P_ERR_FLAG
	 * @throws Exception
	 */
	public void L_CHK_BANK(String P_BANK_CODE,String P_ERR_FLAG) throws Exception{
		String C1 = "SELECT BANK_NAME   FROM   FM_BANK   WHERE  BANK_CODE = ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_BANK_NAME = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(P_BANK_CODE!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{P_BANK_CODE});
				if (C1_REC.next()) {
					M_BANK_NAME = C1_REC.getString(1);
				}else if("E".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));

				}else if("N".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param P_FROM_CODE
	 * @param P_TO_CODE
	 * @throws Exception
	 */
	public void L_VAL_FROM_TO(String P_FROM_CODE,String P_TO_CODE) throws Exception{
		String C1 = "SELECT BANK_NAME   FROM   FM_BANK   WHERE  BANK_CODE = ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_BANK_NAME = null;
		try {
			if(P_FROM_CODE==null || "".equalsIgnoreCase(P_FROM_CODE)){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033",
						new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
			}
			/*handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(P_BANK_CODE!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{P_BANK_CODE});
				if (C1_REC.next()) {
					M_BANK_NAME = C1_REC.getString(1);
				}else if("E".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));

				}else if("N".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}*/
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param action
	 */
	public void L_VAL_SUB_ACCOUNT(PM_BANK_CHARGE_SETUP_HDR_ACTION action){
		Connection connection = null;
		CRUDHandler handler = null;
		String M_FLAG = null;
		String M_TEMP2 = null;
		ResultSet C1_REC = null;
		try{
		String C1 = " SELECT MAIN_CTL_ACNT_FLAG FROM   FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE = ?";
		handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_MAIN_ACNT_CODE()});
		if(C1_REC.next()){
			M_FLAG = C1_REC.getString(1);
		}else{
			M_FLAG = "X";
		}
		/*if("C".equalsIgnoreCase(M_FLAG)){
			action.getCOMP_BCSH_SUB_ACNT_CODE().setDisabled(true);
			if(action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SUB_ACNT_CODE()!=null){
				action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().setBCSH_SUB_ACNT_CODE(null);
				action.getCOMP_BCSH_SUB_ACNT_CODE().setSubmittedValue(null);
				action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().setSUB_ACNT_DESC(null);
				action.getCOMP_SUB_ACNT_DESC().setSubmittedValue(null);
			}else{
				action.getCOMP_BCSH_SUB_ACNT_CODE().setDisabled(false);	
			}*/
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	/*Added by ganesh on 20-06-2017 */
	/*Validating both Bank code and employeer code */
	public void L_CHK_BANK_EMPLOYER(String P_BANK_CODE,String P_ERR_FLAG) throws Exception{
		String C1 = "SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN = 'Y' AND CONT_CODE = ? UNION SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE = ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String M_BANK_NAME = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(P_BANK_CODE!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{P_BANK_CODE,P_BANK_CODE});
				if (C1_REC.next()) {
					M_BANK_NAME = C1_REC.getString(1);
				}else if("E".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));

				}else if("N".equalsIgnoreCase(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	/*end*/
}

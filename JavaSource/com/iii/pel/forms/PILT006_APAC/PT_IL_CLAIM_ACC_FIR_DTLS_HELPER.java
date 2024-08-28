package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_ACC_FIR_DTLS_HELPER {
	
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_ACC_FIR_DTLS_HELPER.class);
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_DTLS_BEAN
	 * @param PT_IL_CLAIM_BEAN
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void preInsert(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			CTRL CTRL_BEAN) throws Exception {
		String C1 = "SELECT P9IL_CAFD_SYS_ID.NEXTVAL FROM   DUAL";
		ResultSet C1_REC = null;
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1,connection);
			if(C1_REC.next()){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_SYS_ID(C1_REC.getDouble(1));
				log.info("==========>ACC FIR DTLS=====>"+PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_SYS_ID());
			}
			CommonUtils utils = new CommonUtils();
			
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CLAIM_SYS_ID(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID());
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CR_DT(utils.getCurrentDate());
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CR_UID(CTRL_BEAN.getUI_M_USER_ID());
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
		
	}

	/**
	 * 
	 */
	public void postInsert(){
		
	}
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_DTLS_BEAN
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void preUpdate(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
			CTRL CTRL_BEAN) throws Exception {
		CommonUtils utils = new CommonUtils();
		PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_UPD_DT(utils.getCurrentDate());
		PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_UPD_UID(CTRL_BEAN.getUI_M_USER_ID());
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_DTLS_BEAN
	 */
	public void postQuery(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN) throws Exception {
		try{
			DBProcedures dbProcedure = new DBProcedures();
			log.info("========>Before INJ TYPE=======>"+PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_INJ_TYPE());
			ArrayList<String> injTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_INJ_TYPE",
												PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_INJ_TYPE(), 
												"N", 
												"N");
			/*if(injTypeList.size()>0){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_INJ_TYPE_DESC(injTypeList.get(1));
				log.info("========>Before INJ TYPE Desc=======>"+injTypeList.get(1));
			}*/
			
			log.info("========>getCAFD_STA_CODE=======>"+PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_STA_CODE());
			ArrayList<String> staCodeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_STA_CODE",
												PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_STA_CODE(), 
												"N", 
												"N");
			/*if(staCodeList.size()>0){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_STA_CODE_DESC(staCodeList.get(1));
				log.info("========>Before STA Desc=======>"+staCodeList.get(1));
			}*/
			
			log.info("========>getCAFD_ACC_TYPE=======>"+PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_TYPE());
			ArrayList<String> acctTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_ACC_TYPE",
												PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_TYPE(), 
												"N", 
												"N");
			/*if(acctTypeList.size()>0){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_ACC_TYPE_DESC(acctTypeList.get(1));
				log.info("========>Before Acct Type Desc=======>"+acctTypeList.get(1));
			}*/
			
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
		
	}

	public void preDelete() {
	}

	public void whenNewBlockInstance() {
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_CLAIM_ACC_FIR_DTLS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_CLAIM_ACC_FIR_DTLS> dataList = compositeAction
				.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_ACC_FIR_DTLS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = dataList
					.get(0);
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
					.setPT_IL_CLAIM_ACC_FIR_DTLS_BEAN(
							PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
		}
	}

	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_CTLS_BEAN TODO
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void whenValidateAcctType(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN) throws Exception {
		try{
				DBProcedures dbProcedure = new DBProcedures();
				ArrayList<String> acctTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_ACC_TYPE",
						PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_TYPE(), 
						"N", 
						"E");
		}catch(Exception exception){
			throw new Exception(exception.getMessage()); 
		}
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_CTLS_BEAN TODO
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void whenValidateInjType(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN) throws Exception {
		try{
				DBProcedures dbProcedure = new DBProcedures();
				ArrayList<String> acctTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_INJ_TYPE",
						PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_INJ_TYPE(), 
						"N", 
						"E");
		}catch(Exception exception){
			throw new Exception(exception.getMessage()); 
		}
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_CTLS_BEAN TODO
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void whenValidateCAFDRegDate(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,CTRL CTRL_BEAN) throws Exception {
			if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE()!=null){
				CommonUtils utils = new CommonUtils();
				if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE().after(new CommonUtils().getCurrentDate())){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Reg Date should not be greater than current date" }));
				}
			}
			
			if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE()!=null &&
					PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_REG_DT()!=null){
				if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_REG_DT().before(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE())){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Reg Date should not be less than Acc Date" }));
				}
			}
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_CTLS_BEAN TODO
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void whenValidateCAFDAcctDate(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,CTRL CTRL_BEAN)
										throws Exception {
			if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE()!=null &&
					PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_REG_DT()!=null){
				if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_REG_DT().before(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_ACC_DATE())){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Reg Date should not be less than Acc Date" }));
					
					
				}
			}
	
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_ACC_FIR_CTLS_BEAN TODO
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void whenValidateSTACode(PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN) throws Exception {
		try{
				DBProcedures dbProcedure = new DBProcedures();
				ArrayList<String> acctTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_STA_CODE",
						PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getCAFD_STA_CODE(), 
						"N", 
						"E");
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage("","")); 
		}
	}
}

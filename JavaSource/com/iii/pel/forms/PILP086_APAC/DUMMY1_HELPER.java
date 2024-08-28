package com.iii.pel.forms.PILP086_APAC;

import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class DUMMY1_HELPER {


	public void executeQuery(PILP086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new DUMMY1_DELEGATE().executeSelectStatement(compositeAction);
	}
	/**
	 * 
	 * @param CTRL_BEAN
	 */
	public void preBlock(CTRL CTRL_BEAN){
		CTRL_BEAN.setUI_M_COMM_DEL("Y");
	}
	/**
	 * 
	 * @param DUMMY1_BEAN
	 */
	public void whenCreateRecord(DUMMY1 DUMMY1_BEAN) throws Exception{
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String C1 = "SELECT P9IL_HFH_SYS_ID.NEXTVAL FROM DUAL";
		try{
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, CommonUtils.getConnection());
			if(C1_REC.next()){
				DUMMY1_BEAN.setHFH_SYS_ID(C1_REC.getLong(1));
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void whenValidatePolNoFrom(DUMMY1 DUMMY1_BEAN) throws Exception{
		String M_POL_ADDL_STATUS = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String C1 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try{
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, CommonUtils.getConnection(),new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM()});
			if(C1_REC.next()){
				M_POL_ADDL_STATUS = C1_REC.getString("POL_ADDL_STATUS");
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new ValidatorException(new FacesMessage("Policy Already Settled For Hibah"));
				}
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
		
	/**
	 * 
	 * @throws Exception
	 */
	public void whenValidatePolNoTo(DUMMY1 DUMMY1_BEAN) throws Exception{
		String M_POL_ADDL_STATUS = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String C1 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try{
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, CommonUtils.getConnection(),new Object[]{DUMMY1_BEAN.getHFH_POL_NO_TO()});
			if(C1_REC.next()){
				M_POL_ADDL_STATUS = C1_REC.getString("POL_ADDL_STATUS");
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new ValidatorException(new FacesMessage("Policy Already Settled For Hibah"));
				}
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
}

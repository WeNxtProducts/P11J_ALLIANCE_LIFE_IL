package com.iii.pel.forms.PILM074_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM074_APAC_HELPER {
	
	 public String POST_QUERY_TRIGGER_HDR(String taxType){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String TH_TAX_DESC = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {taxType};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_HEADER_POST_DESC, connection,values);
			
			while(resultSet.next()){
					TH_TAX_DESC = resultSet.getString(1);
				}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return TH_TAX_DESC;
	}
	 
	 public void whenValidate_TH_EFF_FM_DT(
				PM_LIFE_TAX_HEADER_ACTION action,
				Date effFromDate, Date effToDate)throws ValidatorException {
			if(effFromDate != null && effToDate != null){
				if(effFromDate.after(effToDate)){
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91010")));
				}
			}
		}

		public void whenValidate_TH_EFF_TO_DT(
				PM_LIFE_TAX_HEADER_ACTION action,
				Date effFromDate, Date effToDate)throws Exception {
			if(effFromDate != null && effToDate != null){
				if(effFromDate.after(effToDate)){
					throw  new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		}

	/** Header Triggers End*/
	 
	 /** Product Triggers Start*/
	 
	public void POST_QUERY_TRIGGER_PRODUCT(PM_LIFE_TAX_APPL_PROD tempBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {tempBean.getTAP_PROD_CODE()};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_PRODUCT_POST_DESC, connection,values);
			
			while(resultSet.next()){
				tempBean.setTAP_PROD_CODE_DESC(resultSet.getString(1));
				}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pre_insert_product(PM_LIFE_TAX_APPL_PROD detailsBean) {
		CommonUtils commonUtils = new CommonUtils();
			try {
				PILM074_APAC_COMPOSITE_ACTION compositeAction = 
					(PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
				PM_LIFE_TAX_HEADER dBean = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN();
				detailsBean.setTAP_TH_TAX_TYPE(dBean.getTH_TAX_TYPE());
				call_L_DUP_CHECK_APPL_PROD_Procedure(detailsBean);
				detailsBean.setTAP_CR_DT(commonUtils.getCurrentDate());
				detailsBean.setTAP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	
	public void pre_update_product(PM_LIFE_TAX_APPL_PROD detailsBean) {
		call_L_DUP_CHECK_APPL_PROD_Procedure(detailsBean);
		CommonUtils commonUtils = new CommonUtils();
			try {
				detailsBean.setTAP_UPD_DT(commonUtils.getCurrentDate());
				detailsBean.setTAP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	private void call_L_DUP_CHECK_APPL_PROD_Procedure(
			PM_LIFE_TAX_APPL_PROD detailsBean) throws ValidatorException {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String M_TEMP = null;
		
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {detailsBean.getTAP_EFF_FM_DT(),
					detailsBean.getTAP_EFF_TO_DT(),
					detailsBean.getTAP_EFF_FM_DT(),
					detailsBean.getTAP_EFF_TO_DT(),
					detailsBean.getTAP_EFF_FM_DT(),
					detailsBean.getTAP_EFF_TO_DT(),
					detailsBean.getTAP_TH_TAX_TYPE(),
					detailsBean.getTAP_PROD_CODE()};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_X_FOR_PRE_INSERT_PROD, connection,values);
			
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
				if(CommonUtils.isDuplicate(detailsBean.getROWID(), M_TEMP)){
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91011")));
				}
			}
//			if ("X".equals(M_TEMP)) {
//				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91011")));
//			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String whenValidate_TAP_PROD_CODE(PM_LIFE_TAX_APPL_PROD_ACTION action,Object value) throws ValidatorException{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String TAP_PROD_CODE_DESC = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {value};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_PRODUCT_POST_DESC, connection,values);
			
				if (resultSet.next()) {
					TAP_PROD_CODE_DESC = resultSet.getString(1);
			}
				if (TAP_PROD_CODE_DESC == null) {
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91074")));
			}
		} catch (DBException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return TAP_PROD_CODE_DESC;
	}

	public void whenValidate_TAP_EFF_FM_DT(
			PM_LIFE_TAX_APPL_PROD_ACTION action,
			Date effFromDate, Date effToDate)throws ValidatorException {
		if(effFromDate != null && effToDate != null){
			if(effFromDate.after(effToDate)){
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91010")));
			}
		}
	}

	public void whenValidate_TAP_EFF_TO_DT(
			PM_LIFE_TAX_APPL_PROD_ACTION action,
			Date effFromDate, Date effToDate) throws ValidatorException{
		if(effFromDate != null && effToDate != null){
			if(effFromDate.after(effToDate)){
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91001")));
			}
		}
	}

	 /** Product Triggers End*/
	
	 /** Cust Class Triggers Start*/
	
	public void POST_QUERY_TRIGGER_CUST(PM_LIFE_TAX_APPL_CUST tempBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {tempBean.getTAC_CUST_CLASS()};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CLASS_POST_DESC, connection,values);
			
			while(resultSet.next()){
				tempBean.setTAC_CUST_CLASS_DESC(resultSet.getString(1));
				}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pre_insert_class(PM_LIFE_TAX_APPL_CUST detailsBean) {
		call_L_DUP_CHECK_APPL_CUST_Procedure(detailsBean);
		CommonUtils commonUtils = new CommonUtils();
			try {
				PILM074_APAC_COMPOSITE_ACTION compositeAction = (PILM074_APAC_COMPOSITE_ACTION) CommonUtils.getGlobalObject("PILM074_APAC_COMPOSITE_ACTION");
				PM_LIFE_TAX_HEADER headerDetail = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN();
				detailsBean.setTAC_TH_TAX_TYPE(headerDetail.getTH_TAX_TYPE());
				detailsBean.setTAC_CR_DT(commonUtils.getCurrentDate());
				detailsBean.setTAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	private void call_L_DUP_CHECK_APPL_CUST_Procedure(
			PM_LIFE_TAX_APPL_CUST detailsBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String M_TEMP = null;
		
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {detailsBean.getTAC_EFF_FM_DT(),
					detailsBean.getTAC_EFF_TO_DT(),
					detailsBean.getTAC_EFF_FM_DT(),
					detailsBean.getTAC_EFF_TO_DT(),
					detailsBean.getTAC_EFF_FM_DT(),
					detailsBean.getTAC_EFF_TO_DT(),
					detailsBean.getTAC_TH_TAX_TYPE(),
					detailsBean.getTAC_CUST_CLASS()};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_X_FOR_PRE_INSERT_CUST, connection,values);
			
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
				if(CommonUtils.isDuplicate(detailsBean.getROWID(), M_TEMP)){
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91011")));
				}
			}
//			if ("X".equals(M_TEMP)) {
//				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91011")));
//			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pre_update_class(PM_LIFE_TAX_APPL_CUST detailsBean) {
		call_L_DUP_CHECK_APPL_CUST_Procedure(detailsBean);
		CommonUtils commonUtils = new CommonUtils();
			try {
				detailsBean.setTAC_UPD_DT(commonUtils.getCurrentDate());
				detailsBean.setTAC_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	public String whenValidate_TAC_CUST_CLASS(
			PM_LIFE_TAX_APPL_CUST_ACTION action,
			Object value) throws ValidatorException {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String TAC_CUST_CLASS_DESC = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {value};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CLASS_POST_DESC, connection,values);
			
				if (resultSet.next()) {
					TAC_CUST_CLASS_DESC = resultSet.getString(1);
			}
				if (TAC_CUST_CLASS_DESC == null) {
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91932")));
			}
		} catch (DBException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return TAC_CUST_CLASS_DESC;
	}

	public void whenValidate_TAC_EFF_FM_DT(
			PM_LIFE_TAX_APPL_CUST_ACTION action,
			Date effFromDate, Date effToDate) throws ValidatorException{
		if(effFromDate != null && effToDate != null){
			if(effFromDate.after(effToDate)){
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91010")));
			}
		}
	}

	public void whenValidate_TAC_EFF_TO_DT(
			PM_LIFE_TAX_APPL_CUST_ACTION action,
			Date effFromDate, Date effToDate) throws ValidatorException{
		if(effFromDate != null && effToDate != null){
			if(effFromDate.after(effToDate)){
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91001")));
			}
		}
	}
	/** Cust Class Triggers End*/
	
	/*ADDED BY SENTHILNATHAN FOR ORIENT SUGGESTED BY GIRISH*/
	
	public String whenValidate_TAP_CUST_CLASS(
			PM_LIFE_TAX_APPL_PROD_ACTION action,
			Object value) throws ValidatorException {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String TAP_CUST_CLASS_DESC = null;
	
		try {
			connection = CommonUtils.getConnection();
			Object[] values = {value};
			resultSet = handler.executeSelectStatement(PILM074_APAC_QUERY_CONSTANTS.SELECT_CUST_CLASS_POST_DESC, connection,values);
			
				if (resultSet.next()) {
					TAP_CUST_CLASS_DESC = resultSet.getString(1);
			}
				if (TAP_CUST_CLASS_DESC == null) {
					throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91932")));
			}
		} catch (DBException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return TAP_CUST_CLASS_DESC;
	}
/*END*/
	 
}

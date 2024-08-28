package com.iii.pel.forms.PILM062_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILM062_APAC_HELPER {

	public void PM_IL_PROD_GROUP_PRE_INSERT(PM_IL_PROD_GROUP prodGroupBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = prodGroupBean.getPG_PROD_CODE();
			
			resultSet = handler.executeSelectStatement(PILM062_APAC_SQL_QUERY_CONSTANTS.CHECK_PM_IL_PROD_GROUP1, connection, values);
			
			if(resultSet.next()) {
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelMessagePropertiesPath,"61005")));
			}
			
			prodGroupBean.setPG_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			prodGroupBean.setPG_CR_DT(commonUtils.getCurrentDate());
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void PM_IL_PROD_GROUP_PRE_UPDATE(PM_IL_PROD_GROUP prodGroupBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[2];
			values[0] = prodGroupBean.getPG_PROD_CODE();
			values[1] = prodGroupBean.getROWID();
			
			resultSet = handler.executeSelectStatement(PILM062_APAC_SQL_QUERY_CONSTANTS.CHECK_PM_IL_PROD_GROUP2, connection, values);
			
			if(resultSet.next()) {
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelMessagePropertiesPath,"61005")));
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public PM_IL_PROD_GROUP PM_IL_PROD_GROUP_POST_QUERY(PM_IL_PROD_GROUP prodGroupBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		ArrayList<String> valueList = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILM062_APAC_COMPOSITE_ACTION compositeAction = (PILM062_APAC_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILM062_APAC_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = prodGroupBean.getPG_PROD_CODE();
			
			resultSet = handler.executeSelectStatement(PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_DESC, connection, values);
			
			if(resultSet.next()) {
				prodGroupBean.setPG_PROD_CODE_DESC(resultSet.getString(1));
			}
			
			if(prodGroupBean.getPG_PROD_CODE() != null) {
				valueList = procedures.helperPKG_PILT002$P_VAL_CODES(
						"IL_PRD_GRP",
						prodGroupBean.getPG_CODE(),
						prodGroupBean.getPG_CODE_DESC(),
						"N", "N", null);
				
				if(valueList != null && valueList.size() > 0) {
					prodGroupBean.setPG_CODE_DESC(valueList.get(0));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), "FORM", compositeAction.getPILM062_APAC_PM_IL_PROD_GROUP_ACTION().getErrorMap());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return prodGroupBean;
	}
	
	public void PM_IL_PROD_GROUP_PG_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP prodGroupBean) throws Exception {
		
		Connection connection = null;
		ArrayList<String> valueList = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILM062_APAC_COMPOSITE_ACTION compositeAction = (PILM062_APAC_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILM062_APAC_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			if(prodGroupBean.getPG_PROD_CODE() != null) {
				valueList = procedures.helperPKG_PILT002$P_VAL_CODES(
						"IL_PRD_GRP",
						prodGroupBean.getPG_CODE(),
						prodGroupBean.getPG_CODE_DESC(),
						"N", "N", null);

				if(valueList != null && valueList.size() > 0) {
					prodGroupBean.setPG_CODE_DESC(valueList.get(0));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), 
					compositeAction.getPILM062_APAC_PM_IL_PROD_GROUP_ACTION().getCOMP_PG_CODE().getId(), compositeAction.getPILM062_APAC_PM_IL_PROD_GROUP_ACTION().getErrorMap());
		}
	}
	
	public void PM_IL_PROD_GROUP_PG_PROD_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP prodGroupBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = prodGroupBean.getPG_PROD_CODE();
			
			resultSet = handler.executeSelectStatement(PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_DESC, connection, values);
			
			if(resultSet.next()) {
				prodGroupBean.setPG_PROD_CODE_DESC(resultSet.getString(1));
			} else {
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelMessagePropertiesPath,"91074")));
			}
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}

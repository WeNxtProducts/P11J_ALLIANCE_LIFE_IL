package com.iii.pel.forms.PILM002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.component.UIComponent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_BASIC_CONTR_HELPER {

	/**
	 * This trigger is fired just before inserting a record. It is used to set
	 * some values in the bean to be inserted before inserting the record.
	 * Method will get the current row index of the data table component which
	 * will give the index of the record to be inserted. Using the index the
	 * record to be inserted is retrieved from the record List. The method will
	 * then set the CWP_CR_DT and CWP_CR_UID fields
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void preInsert(PM_IL_BASIC_CONTRIBUTION pm_il_basic_contribution_bean) {
		System.out.println("*******In PRE-INSERT trigger************");
		String mappedBeanName = "PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean = (PILM002_APAC_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean = compositeActionBean
				.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();

		PM_IL_BASIC_CONTRIBUTION recordListValueBean = pm_il_basic_contribution_bean;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-INSERT trigger ends************");
	}

	/**
	 * This trigger is fired just before updating a record. It is used to set
	 * some values in the bean to be inserted before inserting the record.
	 * Method will get the current row index of the data table component which
	 * will give the index of the record to be inserted. Using the index the
	 * record to be inserted is retrieved from the record List. The method will
	 * then set the AWCVR_CR_DT and AWCVR_CR_UID fields
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void preUpdate(PM_IL_BASIC_CONTRIBUTION PM_IL_BASIC_CONTRIBUTION_bean) {
		System.out.println("*******In PRE-UPDATE trigger************");
		String mappedBeanName = "PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean = (PILM002_APAC_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean = compositeActionBean
				.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();

		// get current index of the table and fetching the record to be inserted
		// int
		// currentIndex=actionBean.getCOMP_PM_IL_CVR_WAITING_PRD_TABLE().getRowIndex();
		List recordList = actionBean.getRecordList();
		PM_IL_BASIC_CONTRIBUTION recordListValueBean = PM_IL_BASIC_CONTRIBUTION_bean;
		try {
			// recordListValueBean.setCWP_UPD_DT(utility.getCurrentDate());
			// recordListValueBean.setCWP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-UPDATE trigger ends************");
	}

	public void whenValidateItemBC_AGE_FROM(UIComponent component, Integer value)
			throws Exception {

		String mappedBeanName = "PILM002_APAC_COMPOSITE_ACTION";
		String queryString = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_FROM;
		String queryStringWithoutRowID = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_FROM_WITHOUTROWID;
		Integer M_BC_AGE_FROM = null;
		Integer M_BC_AGE_TO = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet result = null;
		try {
			PILM002_APAC_COMPOSITE_ACTION compositeActionBean = (PILM002_APAC_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession(mappedBeanName);
			PM_IL_BASIC_CONTRIBUTION recorcList = (PM_IL_BASIC_CONTRIBUTION) compositeActionBean
					.getPM_IL_CVR_BASIC_CONTR_ACTION_BEAN()
					.getPM_IL_BASIC_CONTRIBUTION_BEAN();
			String id = compositeActionBean.getPM_IL_COVER_ACTION_BEAN()
					.getPM_IL_COVER_BEAN().getCOVER_CODE();
			Connection connection = CommonUtils.getConnection();
			if (null != recorcList.getROWID()) {
				Object[] values = new Object[2];
				values[0] = id;
				values[1] = recorcList.getROWID();
				result = handler.executeSelectStatement(queryString,
						connection, values);
			} else {
				Object[] values = new Object[1];
				values[0] = id;
				result = handler.executeSelectStatement(
						queryStringWithoutRowID, connection, values);
			}

			if (result != null) {
				while (result.next()) {
					M_BC_AGE_FROM = result.getInt("BC_AGE_FROM");
					M_BC_AGE_TO = result.getInt("BC_AGE_TO");
					if (value >= M_BC_AGE_FROM && value <= M_BC_AGE_TO) {
						String message = Messages.getString(
								PELConstants.pelErrorMessagePath, "91981");
						throw new Exception(message);
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void whenValidateItemBC_AGE_TO(UIComponent component,
			Integer bc_age_from, Integer bc_age_to) throws Exception {
		String mappedBeanName = "PILM002_APAC_COMPOSITE_ACTION";
		String queryStringForTo = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_TO;
		String queryStringWithoutRowIDForTo = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_TO_WIT_OUT_ROWID;

		String queryString = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_FROM;
		String queryStringWithoutRowID = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_Validate_Item_BC_AGE_FROM_WITHOUTROWID;

		Integer M_BC_AGE_FROM = null;
		Integer M_BC_AGE_TO = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet result = null;
		ResultSet c2result = null;
		try {

			L_VAL_FROM_TO(bc_age_from, bc_age_to);

			PILM002_APAC_COMPOSITE_ACTION compositeActionBean = (PILM002_APAC_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession(mappedBeanName);
			PM_IL_BASIC_CONTRIBUTION recorcList = (PM_IL_BASIC_CONTRIBUTION) compositeActionBean
					.getPM_IL_CVR_BASIC_CONTR_ACTION_BEAN()
					.getPM_IL_BASIC_CONTRIBUTION_BEAN();
			String id = compositeActionBean.getPM_IL_COVER_ACTION_BEAN()
					.getPM_IL_COVER_BEAN().getCOVER_CODE();
			Connection connection = CommonUtils.getConnection();
			if (null != recorcList.getROWID()) {
				Object[] values = new Object[3];
				values[0] = id;
				values[1] = recorcList.getROWID();
				values[2] = bc_age_to;
				result = handler.executeSelectStatement(queryStringForTo,
						connection, values);
			} else {
				Object[] values = new Object[2];
				values[0] = id;
				values[1] = bc_age_to;
				result = handler.executeSelectStatement(
						queryStringWithoutRowIDForTo, connection, values);
			}

			if (result != null) {
				while (result.next()) {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "85521");
					throw new Exception(message);
				}
			}

			if (null != recorcList.getROWID()) {
				Object[] values = new Object[2];
				values[0] = id;
				values[1] = recorcList.getROWID();

				c2result = handler.executeSelectStatement(queryString,
						connection, values);
			} else {
				Object[] values = new Object[1];
				values[0] = id;
				c2result = handler.executeSelectStatement(
						queryStringWithoutRowID, connection, values);
			}

			if (c2result != null) {
				while (c2result.next()) {
					M_BC_AGE_FROM = c2result.getInt("BC_AGE_FROM");
					M_BC_AGE_TO = c2result.getInt("BC_AGE_TO");
					if (bc_age_from <= M_BC_AGE_FROM) {
						if (bc_age_to >= M_BC_AGE_TO
								|| bc_age_to >= M_BC_AGE_FROM) {
							String message = Messages.getString(
									PELConstants.pelErrorMessagePath, "91981");
							throw new Exception(message);
						} else if (bc_age_to >= M_BC_AGE_FROM) {
							if (bc_age_from <= M_BC_AGE_TO) {
								String message = Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91981");
								throw new Exception(message);
							}

						}
					}

				}
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(result);
				CommonUtils.closeCursor(c2result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void L_VAL_FROM_TO(Integer bc_age_from, Integer bc_age_to)
			throws Exception {

		try {

			if (null == bc_age_from) {
				//STD_MESSAGE_ROUTINE('80033',:CTRL.M_LANG_CODE);
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "80033");
				throw new Exception(message);
			}

			if (bc_age_to < bc_age_from) {
				//STD_MESSAGE_ROUTINE('71013',:CTRL.M_LANG_CODE);
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "71013");
				throw new Exception(message);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}

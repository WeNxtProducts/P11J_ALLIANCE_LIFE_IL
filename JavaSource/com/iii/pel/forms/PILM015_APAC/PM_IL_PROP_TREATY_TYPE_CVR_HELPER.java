package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROP_TREATY_TYPE_CVR_HELPER {

	/**
	 * WHEN-VALIDATE-ITEM FOR PTTC_COVER_CODE
	 * 
	 * @param compositeAction
	 * @throws SQLException
	 * @throws Exception
	 */
	public void typewiseCoverWhenValidate(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, String code)
			throws ValidatorException, SQLException, Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		DBProcedures procedures = new DBProcedures();
		String M_DUMMY = null;
		String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_SELECT_X_FOR_SYSID_COVER_CODE;

		Double sysId = compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
				.getTempTreaty_TypeBean().getPTT_SYS_ID();
		String beanRowId = compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
										.getTempTreaty_TypeBean().getROWID();
		Object[] objects1 = { sysId, code };
		String sql_C2 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_SELECT_X_FOR_COVER_TYPE_AND_COVER_CODE;
		Object[] objects2 = { code };

		String riRiderBasis = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_RIDER_RI_BASIS();

		try {

			if (riRiderBasis.equals("B")) {
				if (sysId != null) {
					resultSet2 = handler.executeSelectStatement(sql_C2,
							connection, objects2);
					if (resultSet2.next()) {
						M_DUMMY = resultSet2.getString(1);
					}
					/*if (M_DUMMY != null) {
						if (M_DUMMY.equals("" + "X")) {
							  throw new ValidatorException(Messages.getMessage(
								  "com.iii.premia.common.errorUtil.PELErrorMessages",
								  "91185"));
						}
					}*/
					if(CommonUtils.isDuplicate(beanRowId, M_DUMMY)){
						throw new Exception("Duplicate code exist");
					}
				}
			}

			ArrayList<String> coverDescList = procedures
					.helperP_VAL_COVER(
							code,
							null,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_E_FLAG);
			if(coverDescList.size() > 0 && coverDescList.get(0) != null){
			compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
					.getPM_IL_PROP_TREATY_TYPE_CVR_BEAN().setUI_M_COVER_DESC(
							coverDescList.get(0));
			}
			resultSet1 = handler.executeSelectStatement(sql_C1, connection,
					objects1);
			if (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}
			if (resultSet1.next()) {				
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "71039"));
			}

		} finally{
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * PRE-INSERT
	 * 
	 * @param compositeAction
	 * @throws SQLException
	 * @throws Exception
	 */
	public double preInsertValidation() throws Exception {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		double sysId = 1D;
		ResultSet resultSet = null;
		try {
			String query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PIL_PTTC_SYS_ID;
			// String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM DUAL ";
			Object[] objects = {};

			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getInt(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;
	}

	public Double pilm015_apac_pm_il_prop_treaty_type_cvr__pre_insert(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		CommonUtils commonUtils=new CommonUtils();
		PM_IL_PROP_TREATY_TYPE_CVR treatyTypeCvrValueBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
				.getPM_IL_PROP_TREATY_TYPE_CVR_BEAN();
		Double pttcSysId = null;
		try {

			String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PIL_PTTC_SYS_ID;
			Object[] objects1 = {};
			String M_DUMMY = null;
			String sql_C2 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_SELECT_X_FOR_SYSID_AND_COVER_CODE;

			/*
			 * "SELECT 'X' FROM PM_IL_PROP_TREATY_TYPE_COVER WHERE
			 * PTTC_PTT_SYS_ID = " +
			 * ":PM_IL_PROP_TREATY_TYPE_CVR.PTTC_PTT_SYS_ID AND PTTC_COVER_CODE = " +
			 * ":PM_IL_PROP_TREATY_TYPE_CVR.PTTC_COVER_CODE ";
			 */
			Double ptcPttSysId = treatyTypeCvrValueBean.getPTTC_PTT_SYS_ID();
			String pttcCoverCode = treatyTypeCvrValueBean.getPTTC_COVER_CODE();
			Object[] objects2 = { ptcPttSysId, pttcCoverCode };
			resultSet2 = handler.executeSelectStatement(sql_C2, connection,
					objects2);
			if (resultSet2.next()) {
				M_DUMMY = resultSet2.getString(1);
			}
			if (resultSet2.next()) {
				/*
				 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71039,:CTRL.M_LANG_CODE);
				 * throw new FORM_TRIGGER_FAILURE();
				 */
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "71039"));
			}
			resultSet1 = handler.executeSelectStatement(sql_C1, connection,
					objects1);

			if (resultSet1.next()) {
				// treatyTypeCvrValueBean.setPTTC_SYS_ID(resultSet1.getDouble(0));//sys
				// Id Being set
				pttcSysId = resultSet1.getDouble(0);
			}

			/*
			 * :PM_IL_PROP_TREATY_TYPE_CVR.PTTC_CR_UID=:CTRL.M_USER_ID;
			 * :PM_IL_PROP_TREATY_TYPE_CVR.PTTC_CR_DT=new
			 * java.sql.Date(Calendar.getInstance().getTimeInMillis());
			 */
			treatyTypeCvrValueBean.setPTTC_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			treatyTypeCvrValueBean.setPTTC_CR_DT(commonUtils.getCurrentDate());

		} finally{
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pttcSysId;
	}

	/**
	 * PRE-UPDATE
	 * 
	 * @param compositeAction
	 * @throws ParseException
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_cvr_pre_update(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws ParseException {
		PM_IL_PROP_TREATY_TYPE_CVR treatyTypeCvrValueBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
				.getPM_IL_PROP_TREATY_TYPE_CVR_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		/*
		 * :PM_IL_PROP_TREATY_TYPE_CVR.PTTC_UPD_UID=:CTRL.M_USER_ID;
		 * :PM_IL_PROP_TREATY_TYPE_CVR.PTTC_UPD_DT=new
		 * java.sql.Date(Calendar.getInstance().getTimeInMillis());
		 */
		treatyTypeCvrValueBean.setPTTC_UPD_DT(commonUtils.getCurrentDate());
		treatyTypeCvrValueBean.setPTTC_UPD_UID(CommonUtils.getControlBean()
				.getM_USER_ID());

	}

	/**
	 * POST-QUERY SETS COVER CODE DESC
	 * 
	 * @param compositeAction
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_cvr_post_query(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {

		List<PM_IL_PROP_TREATY_TYPE_CVR> list = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().getDataTableList();
		if (list != null) {
			Iterator<PM_IL_PROP_TREATY_TYPE_CVR> iterator = list.iterator();
			while (iterator.hasNext()) {
				PM_IL_PROP_TREATY_TYPE_CVR treatyTypeValueBean = iterator
						.next();

				System.out.println("Post Query");
				DBProcedures procedures = new DBProcedures();
				String coverCode = treatyTypeValueBean.getPTTC_COVER_CODE();
				ArrayList<String> coverCodeDescList = procedures
						.helperP_VAL_COVER(
								coverCode,
								null,
								PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
								PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG);
				if (coverCodeDescList != null && coverCodeDescList.size() != 0) {
					treatyTypeValueBean.setUI_M_COVER_DESC(coverCodeDescList
							.get(0));
				}
				// P_VAL_COVER(:PM_IL_PROP_TREATY_TYPE_CVR.PTTC_COVER_CODE,:PM_IL_PROP_TREATY_TYPE_CVR.M_COVER_DESC,null,"N","N");
				System.out.println("Done");
			}
		}
	}

	/*
	 * public void
	 * pilm015_apac_pm_il_prop_treaty_type_cvr_when_new_block_instance() {
	 * 
	 * 
	 * 
	 * if(:SYSTEM.FORM_STATUS=="CHANGED") { :CTRL.M_COMM_DEL="P"; POST.POST();
	 * :CTRL.M_COMM_DEL=null;
	 * :PM_IL_PROP_TREATY.PT_TREATY_DESC=:PM_IL_PROP_TREATY.PT_TREATY_DESC; } }
	 */

	/**
	 * PRE_BLOCK COMMENTED AS FORM FAILURE IS NOT HANDLED
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	/*
	 * public static void pilm015_apac-pm_il_prop_treaty_type_cvr--pre-block()
	 * throws SQLException,Exception { Connection vembu_conn =
	 * SwisSqlConnection.getInstance().getConnection(); try { final dbms_output
	 * dbms_output1=new dbms_output(); if(FORM_FAILURE) {
	 * :GLOBAL.M_FAILURE="TRUE"; } :CTRL.M_DELETE_MSG_FLAG="N"; }catch(Exception
	 * e) { e.printStackTrace(); throw e; } finally { if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 */
	public List coverCodeSuggestionBox(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			String code, List codeList) {
		String ptRiderRIBasis = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_RIDER_RI_BASIS();
		String query;
		
		if (ptRiderRIBasis != null) {
			if (ptRiderRIBasis.trim().equals("B")) {

				if ("*".equalsIgnoreCase(code)) {

					/*
					 * query = "SELECT COVER_CODE,COVER_DESC " + "FROM
					 * PM_IL_COVER " + "WHERE " + "COVER_FRZ_FLAG = 'N' " + "AND
					 * COVER_TYPE = NVL('B',COVER_TYPE)";
					 */
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PTTC_COVER_CODE_RIDER_BASIS_B_LOV;
					Object[] object = { PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN };
					codeList = coverCodeLOV(query, object);
				} else {
					code = code
							+ PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] objects1 = {
							code,
							PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN };
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PTTC_COVER_CODE_RIDER_BASIS_B_LOV_LIKE;
					codeList = coverCodeLOV(query, objects1);
				}
			} else {

				if ("*".equalsIgnoreCase(code)) {

					/*
					 * query = "SELECT COVER_CODE,COVER_DESC " + "FROM
					 * PM_IL_COVER " + "WHERE " + "COVER_FRZ_FLAG = 'N' " + "AND
					 * COVER_TYPE = NVL('B',COVER_TYPE)";
					 */
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PTTC_COVER_CODE_LOV;
					Object[] object = { PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN };
					codeList = coverCodeLOV(query, object);
				} else {
					code = code
							+ PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] objects1 = {
							code,
							PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN };
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_CVR_PTTC_COVER_CODE_LOV_LIKE;
					codeList = coverCodeLOV(query, objects1);
				}
			}
		}
		return codeList;
	}

	public String getCoverCodeDesc(String coverCode, List coverCodeList) {
		Iterator iterator = coverCodeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_TYPE_CVR typeCvr = (PM_IL_PROP_TREATY_TYPE_CVR) iterator
					.next();
			if (coverCode.equalsIgnoreCase(typeCvr.getPTTC_COVER_CODE())) {
				codedesc = typeCvr.getUI_M_COVER_DESC();
			}
		}
		return codedesc;
	}

	public List<PM_IL_PROP_TREATY_TYPE_CVR> coverCodeLOV(String query,
			Object[] object) {
		List<PM_IL_PROP_TREATY_TYPE_CVR> codeList = new ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			 resultSet = handler.executeSelectStatement(query,
					connection, object);
			while (resultSet.next()) {

				PM_IL_PROP_TREATY_TYPE_CVR typewise_cover = new PM_IL_PROP_TREATY_TYPE_CVR();
				typewise_cover.setPTTC_COVER_CODE(resultSet.getString(1));
				typewise_cover.setUI_M_COVER_DESC(resultSet.getString(2));

				codeList.add(typewise_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
							
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

}

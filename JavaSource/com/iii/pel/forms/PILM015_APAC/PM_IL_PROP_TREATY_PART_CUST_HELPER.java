package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_PROP_TREATY_PART_CUST_HELPER {

	/**
	 * POST-QUERY
	 * 
	 * @param compositeAction
	 * @throws Exception
	 * @throws SQLException
	 */
	public void pilm015_apac_pm_il_prop_treaty_part_cust__post_query(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {

		List<PM_IL_PROP_TREATY_PART_CUST> list = compositeAction
				.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList();
		if (list != null) {
			Iterator<PM_IL_PROP_TREATY_PART_CUST> iterator = list.iterator();
			while (iterator.hasNext()) {
				PM_IL_PROP_TREATY_PART_CUST treatyCustValueBean = iterator
						.next();

				/*
				 * PM_IL_PROP_TREATY_PART_CUST
				 * partCustValueBean=compositeAction.
				 * getPM_IL_PROP_TREATY_PART_CUST_ACTION().
				 * getPM_IL_PROP_TREATY_PART_CUST_BEAN();
				 */
				System.out.println("In Post Query");
				String ptpcCustCode = treatyCustValueBean.getPTPC_CUST_CODE();
				System.out.println("customer code is:" + ptpcCustCode);
				DBProcedures procedures = new DBProcedures();
				ArrayList<String> ptpcCustCodeList = procedures
						.helperP_VAL_CUST(
								ptpcCustCode,
								PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
								PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG);

				if (ptpcCustCodeList != null && ptpcCustCodeList.size() != 0) {
					System.out.println("Description is "
							+ ptpcCustCodeList.get(0));
					treatyCustValueBean.setUI_M_COMP_DESC(ptpcCustCodeList
							.get(0));

				}

				/*
				 * P_VAL_CUST.P_VAL_CUST(:PM_IL_PROP_TREATY_PART_CUST.PTPC_CUST_CODE,
				 * :PM_IL_PROP_TREATY_PART_CUST.M_COMP_DESC,"N","N");
				 */
				System.out.println("Done");
			}
		}
	}

	/**
	 * PRE-UPDATE
	 * 
	 * @param compositeAction
	 * @throws ParseException
	 * @throws DBException
	 * @throws SQLException
	 */
	public void pilm015_apac_pm_il_prop_treaty_part_cust__pre_update(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws ParseException, SQLException, DBException {
		PM_IL_PROP_TREATY_PART_CUST partCustValueBean = compositeAction
				.getPM_IL_PROP_TREATY_PART_CUST_ACTION()
				.getPM_IL_PROP_TREATY_PART_CUST_BEAN();
		CommonUtils commonUtils = new CommonUtils();

		partCustValueBean.setPTPC_UPD_DT(commonUtils.getCurrentDate());
		partCustValueBean.setPTPC_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());

	}

	public void L_VAL_CUST_LEADER(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			String leader, String rowId)
			throws ValidatorException, SQLException, Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		double sysId = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().
				getPM_IL_PROP_TREATY_COVER_BEAN().getPTC_SYS_ID();
				
			System.out.println("valuse ofL_VAL_CUST_LEADER-->"+sysId);	
				/*compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
				.getPM_IL_PROP_TREATY_TYPE_BEAN().getPTT_SYS_ID();
*/
		try {

			String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PART_CUST_SELECT_LEADER_YN;
			Object[] objects1 = { sysId };

			String sql_C2 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PART_CUST_SELECT_LEADER_YN_FOR_SYSID_AND_ROWID;

			Object[] objects2 = { sysId, rowId };

			String M_FLAG = null;
			if (leader.equalsIgnoreCase("Y")) {

				if (rowId == null) {

					resultSet1 = handler.executeSelectStatement(sql_C1,
							connection, objects1);
					if (resultSet1.next()) {
						M_FLAG = resultSet1.getString(1);
					}
					if (resultSet1.next()) {
						throw new ValidatorException(Messages.getMessage(
								"com.iii.premia.common.errorUtil.PELErrorMessages",
								"71136"));
					}

				} else {
					resultSet2 = handler.executeSelectStatement(sql_C2,
							connection, objects2);
					if (resultSet2.next()) {
						M_FLAG = resultSet2.getString(1);
					}
					if (resultSet2.next()) {

						throw new ValidatorException(Messages.getMessage(
								"com.iii.premia.common.errorUtil.PELErrorMessages",
								"71136"));
					}
				}
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
	 * pre-Insert
	 * 
	 * @param compositeAction
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Double pilm015_apac_pm_il_prop_treaty_part_cust__pre_insert(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {
		ResultSet resultSet = null;
		Double pilPtpcSysId = null;
		CommonUtils commonUtils=new CommonUtils();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		PM_IL_PROP_TREATY_PART_CUST partCustValueBean = compositeAction
				.getPM_IL_PROP_TREATY_PART_CUST_ACTION()
				.getPM_IL_PROP_TREATY_PART_CUST_BEAN();
		try {

			String sql_vembu1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PART_CUST_PIL_PTPC_SYS_ID;
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(sql_vembu1, connection,
					objects);
			if (resultSet.next()) {
				pilPtpcSysId = resultSet.getDouble(0);
			}
			/*
			 * :PM_IL_PROP_TREATY_PART_CUST.PTPC_CR_UID=:CTRL.M_USER_ID;
			 * :PM_IL_PROP_TREATY_PART_CUST.PTPC_CR_DT=new
			 * java.sql.Date(Calendar.getInstance().getTimeInMillis());
			 */
			partCustValueBean.setPTPC_CR_DT(commonUtils.getCurrentDate());
			partCustValueBean.setPTPC_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			// L_VAL_CUST_UNIQUE(compositeAction);
			// L_VAL_CUST_LEADER(compositeAction);
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pilPtpcSysId;
	}

	public void L_VAL_CUST_UNIQUE(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			String code, 
			PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust) throws ValidatorException,
			SQLException, Exception {

		ResultSet resultSet = null;
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		try {
			String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PART_CUST_SELECT_1_FOR_CUST_CODE_SYS_ID;
			/*
			 * "SELECT 1 FROM PM_IL_PROP_TREATY_PART_CUST WHERE PTPC_CUST_CODE =" + "
			 * :PM_IL_PROP_TREATY_PART_CUST.PTPC_CUST_CODE AND PTPC_PTT_SYS_ID =" + "
			 * :PM_IL_PROP_TREATY_PART_CUST.PTPC_PTT_SYS_ID ";
			 */
			double sysId = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().
					getPM_IL_PROP_TREATY_COVER_BEAN().getPTC_SYS_ID();
					

			System.out.println("value os sys id in company master"+sysId);
			String rowId = pm_il_prop_treaty_part_cust.getROWID();

			// String ptpcCustcode = partCustValueBean.getPTPC_CUST_CODE();
			Object[] objects1 = {code, sysId};
//			double M_TEMP = -1;
			String M_TEMP=null;
			// vembu_C1=stmt_C1.executeQuery(sql_C1);
			resultSet = handler.executeSelectStatement(sql_C1, connection,
					objects1);
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			}
			if (M_TEMP != null && !M_TEMP.equals(rowId)) {
				/*
				 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(11105,:CTRL.M_LANG_CODE);
				 * throw new FORM_TRIGGER_FAILURE();
				 */
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "11105"));
			}

		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
							
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * WHEN-CREATE-RECORD
	 * 
	 * @param compositeAction
	 */
	public void pilm015_apac_pm_il_prop_treaty_part_cust__when_create_record(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) {
		System.out.println("in when-create-Record ");
		PM_IL_PROP_TREATY_PART_CUST partCustValueBean = compositeAction
				.getPM_IL_PROP_TREATY_PART_CUST_ACTION()
				.getPM_IL_PROP_TREATY_PART_CUST_BEAN();
		// :PM_IL_PROP_TREATY_PART_CUST.PTPC_LEADER_YN="N";
		partCustValueBean.setPTPC_LEADER_YN("N");
		System.out.println("done");
	}

	public void cusCodeWhenValidate(String code,
			PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust) throws ValidatorException,
			SQLException, Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> codeDesc = procedures.helperP_VAL_CLASS_CUST("REINS",
				code, "N", "E");

		if (codeDesc != null && codeDesc.size() != 0) {
			pm_il_prop_treaty_part_cust.setUI_M_COMP_DESC(codeDesc.get(0));
		}
	}

	/*
	 * PM_IL_MED_EXAM_DTL dtlBean =
	 * compositeAction.getPM_IL_MED_EXAM_DTL_ACTION()
	 * .getPM_IL_MED_EXAM_DTL_BEAN(); String code = dtlBean.getMED_EXAM_CODE();
	 * System.out.println("Code is:"+dtlBean.getMED_EXAM_CODE()); ArrayList<String>
	 * CodeDescList = procedures.helperP_VAL_CODES( "IL_MED_EXM", code, "N",
	 * "N", null); if (CodeDescList != null && CodeDescList.size() != 0) {
	 * dtlBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));
	 * System.out.println("Code Desc"+dtlBean.getUI_M_MED_EXAM_CODE_DESC()); }
	 * System.out.println("Done-------");
	 */

	public void percentageShareWhenValidate(Double PTPC_SHARE_PERC, ArrayList<PM_IL_PROP_TREATY_PART_CUST> dataTableList) {
		
		int sum = 0;
		//PM_IL_PROP_TREATY_PART_CUST currentBean = dataTableList.get(rowIndex);
		//Double Share = MigratingFunctions.nvl(PTPC_SHARE_PERC, 0);
		if(PTPC_SHARE_PERC < 0 ){
			throw new ValidatorException(new FacesMessage("Percentage share cannnot be less than 0 "));
		}
		
		if(PTPC_SHARE_PERC > 100 || PTPC_SHARE_PERC < 0) {
			throw new ValidatorException(new FacesMessage("Percentage share cannnot be greater than 100"));
		}
		
		for(PM_IL_PROP_TREATY_PART_CUST tempBean : dataTableList) {
			sum += MigratingFunctions.nvl(tempBean.getPTPC_SHARE_PERC(), 0);
		}
		
		if(sum > 100) {
			throw new ValidatorException(new FacesMessage("Total Percentage share cannnot be greater than 100"));
		}
	}
}

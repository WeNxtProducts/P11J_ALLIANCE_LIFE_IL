package com.iii.pel.forms.PILM029;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_MED_EXAM_HELPER extends CommonAction {

	public void SA_ASSURED_TO_WHEN_VALIDATE(Double saFrom, Double saTo,
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action)
			throws ValidatorException, SQLException, Exception {

		if (saTo < saFrom) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "71223"));
		}
	}

	public void AGE_TO_WHEN_VALIDATE_ITEM(int ageFrom, int ageTo,
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action)
			throws ValidatorException, SQLException, Exception {

		if (ageTo < ageFrom) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "71224"));
		} 
	}

	public void SA_ASSURED_FROM(Double saFrom,
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action)
			throws ValidatorException, SQLException, Exception {
			pm_il_med_exam_hdr_action.getPM_IL_MED_EXAM_HDR_BEAN().setMEH_SUM_ASSURED_FM(saFrom);
		
	}

	public void AGE_FROM(int ageFrom,
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action)
			throws ValidatorException, SQLException, Exception {

		int rowIndex = pm_il_med_exam_hdr_action.getDataTable().getRowIndex();
		PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = pm_il_med_exam_hdr_action
				.getMedicalExamList().get(rowIndex);
		pm_il_med_exam_hdr.setMEH_AGE_FM(ageFrom);
		//pm_il_med_exam_hdr_action.gridtabListener();

	}

	/**
	 * Validation For Medical Header Range
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void L_VALIDATE_RANGE(PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr)
			throws ValidatorException, SQLException, Exception {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Double saFrom = pm_il_med_exam_hdr.getMEH_SUM_ASSURED_FM();
		Double saTo = pm_il_med_exam_hdr.getMEH_SUM_ASSURED_TO();
		Integer ageFrom = pm_il_med_exam_hdr.getMEH_AGE_FM();
		Integer ageTo = pm_il_med_exam_hdr.getMEH_AGE_TO();
		String rowId = pm_il_med_exam_hdr.getROWID();
//		System.out.println(saFrom);

		Object value1[] = { saFrom, saTo, saFrom, saTo, saTo, ageFrom, ageTo,
				ageFrom, ageTo, ageTo };
		Object value2[] = { saFrom, saTo, saFrom, saTo, saTo, ageFrom, ageTo,
				ageFrom, ageTo, ageTo, rowId };
		String M_DUMMY = null;
		String sql_C1 = "SELECT ROWID FROM  PM_IL_MED_EXAM_HDR  "
				+ "WHERE  (MEH_SUM_ASSURED_FM  BETWEEN ? " + "AND  ? "
				+ "OR MEH_SUM_ASSURED_TO  BETWEEN ?  " + "AND  ? " + "OR ? "
				+ "BETWEEN MEH_SUM_ASSURED_FM  AND  MEH_SUM_ASSURED_TO)  "
				+ "AND (MEH_AGE_FM  BETWEEN ?  " + "AND  ?  OR MEH_AGE_TO  "
				+ "BETWEEN ?  " + "AND  ?  "
				+ "OR ?  BETWEEN MEH_AGE_FM  AND  MEH_AGE_TO)";

		String sql_C2 = "SELECT ROWID " + "FROM  PM_IL_MED_EXAM_HDR  "
				+ "WHERE  (MEH_SUM_ASSURED_FM  " + "BETWEEN ?  "
				+ "AND  ?  OR MEH_SUM_ASSURED_TO  " + "BETWEEN ? " + "AND  ? "
				+ "OR ?  "
				+ "BETWEEN MEH_SUM_ASSURED_FM  AND  MEH_SUM_ASSURED_TO)  "
				+ "AND (MEH_AGE_FM  BETWEEN :?  " + "AND  :?  OR MEH_AGE_TO  "
				+ "BETWEEN ?  " + "AND  ?  " + "OR ?  "
				+ "BETWEEN MEH_AGE_FM  AND  MEH_AGE_TO)  " + "AND ROWID  != ? ";

		try {

			if (rowId == null) {

				resultSet1 = handler.executeSelectStatement(sql_C1, connection,
						value1);
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getString(1);
					if(CommonUtils.isDuplicate(pm_il_med_exam_hdr.getROWID(), M_DUMMY))
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71015"));
				}
			} else {
				resultSet2 = handler.executeSelectStatement(sql_C2, connection,
						value2);

				if (resultSet2.next()) {
					M_DUMMY = resultSet2.getString(1);
					if(CommonUtils.isDuplicate(pm_il_med_exam_hdr.getROWID(), M_DUMMY))
						throw new ValidatorException(Messages.getMessage(
								"PELErrorMessages", "71015"));
					}

				}
				
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}

		finally {

			if (resultSet1 != null) {
				new CommonUtils().closeCursor(resultSet1);
//				resultSet1.close();
			}
			if (resultSet2 != null) {
				new CommonUtils().closeCursor(resultSet2);
//				resultSet2.close();
			}
		}

	}

	public void L_VALIDATE_DTL_RANGE(String code) throws Exception{
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction = (PM_IL_MED_EXAM_COMPOSITE_ACTION) (commonUtils
				.getMappedBeanFromSession("PM_IL_MED_EXAM_COMPOSITE_ACTION"));
		Long sysid = compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN().getMEH_SYS_ID();
		String rowId = compositeAction.getPM_IL_MED_EXAM_DTL_ACTION()
				.getPM_IL_MED_EXAM_DTL_BEAN().getROWID();

		ResultSet vembu_C2 = null;
		ResultSet vembu_C1 = null;
		try {
			connection = CommonUtils.getConnection();
			String M_DUMMY = null;
			String sql_C1 = "SELECT ROWID FROM  PM_IL_MED_EXAM_DTL  "
					+ "WHERE  MED_MEH_SYS_ID  = ?  "
					+ "AND MED_EXAM_CODE  = ? ";

			Object object[] = { sysid, code };

			String sql_C2 = "SELECT ROWID " + "FROM  PM_IL_MED_EXAM_DTL  "
					+ "WHERE  MED_MEH_SYS_ID  = ?  "
					+ "AND MED_EXAM_CODE  = ?  " + "AND ROWID  != ? ";

			if (rowId == null) {

				vembu_C1 = handler.executeSelectStatement(sql_C1, connection,
						object);
				if (vembu_C1.next()) {
					M_DUMMY = vembu_C1.getString(1);
					if(CommonUtils.isDuplicate(compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getPM_IL_MED_EXAM_DTL_BEAN().getROWID(), M_DUMMY))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71015"));
				}
			}else if (rowId != null) {
				Object object1[] = { sysid, code, rowId };
				vembu_C2 = handler.executeSelectStatement(sql_C2, connection,
						object1);
				if (vembu_C2.next()) {
					M_DUMMY = vembu_C2.getString(1);
					if(CommonUtils.isDuplicate(compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getPM_IL_MED_EXAM_DTL_BEAN().getROWID(), M_DUMMY))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71015"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  finally {
			try{CommonUtils.closeCursor(vembu_C1);}catch(Exception exc){}
			try{CommonUtils.closeCursor(vembu_C2);}catch(Exception exc){}
		}

	}

	public void postQuery(PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {
		List<PM_IL_MED_EXAM_DTL> list = compositeAction
				.getPM_IL_MED_EXAM_DTL_ACTION().getMedicalExamList();
		if (list != null) {
			Iterator<PM_IL_MED_EXAM_DTL> iterator = list.iterator();
			while (iterator.hasNext()) {
				PM_IL_MED_EXAM_DTL dtlBean = iterator.next();
				DBProcedures procedures = new DBProcedures();
				String code = dtlBean.getMED_EXAM_CODE();
				ArrayList<String> CodeDescList = procedures.helperP_VAL_CODES(
						"IL_MED_EXM", code, "N", "N", null);
				if (CodeDescList != null && CodeDescList.size() != 0) {
					dtlBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));

				}

			}
		}
	}

	public void codeWhenValidate(String code) throws Exception {
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction = (PM_IL_MED_EXAM_COMPOSITE_ACTION) (commonUtils
				.getMappedBeanFromSession("PM_IL_MED_EXAM_COMPOSITE_ACTION"));

		PM_IL_MED_EXAM_DTL dtlBean = compositeAction
				.getPM_IL_MED_EXAM_DTL_ACTION().getPM_IL_MED_EXAM_DTL_BEAN();
		System.out.println("code is" + code);
		ArrayList<String> CodeDescList = procedures.helperP_VAL_CODES(
				"IL_MED_EXM", code, "N", "E", null);
		if (CodeDescList != null && CodeDescList.size() != 0) {
			dtlBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));
			System.out.println("Code Desc"
					+ dtlBean.getUI_M_MED_EXAM_CODE_DESC());
		}
	}
	
	public void executeHdrQuery(PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_MED_EXAM_DELEGATE().getValuesForHeader(compositeAction);
		List<PM_IL_MED_EXAM_HDR> dataList = compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getMedicalExamList();
		if(dataList!=null && dataList.size() > 0){
			compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().setPM_IL_MED_EXAM_HDR_BEAN(dataList.get(0));
		}
	}

	public void executeQuery(PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction) throws Exception {
			executeDtlQuery(compositeAction);
			List<PM_IL_MED_EXAM_DTL> dataList = compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getMedicalExamList();
			if(dataList!=null && dataList.size() > 0){
				compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().setPM_IL_MED_EXAM_DTL_BEAN(dataList.get(0));
		}
	}

	
	public void executeDtlQuery(PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction) throws Exception {
		// TODO Auto-generated method stub
			Long meh_sys_id = compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN().getMEH_SYS_ID();
			/*added ,MED_SA_CONS_MONTHS,MED_NO_OF_VALID_DAYS by R. Raja on 15-12-2016 for RM018T - FSD_IL_ZB Life_017-Medical Report Validity Period*/ 
			/*Added MED_SA_FM,MED_SA_TO Columns by ganesh on 02-06-2017 ZBILQC-1719236 */
			String selectStatement = "SELECT ROWID,MED_MEH_SYS_ID,MED_EXAM_CODE,MED_CR_DT,MED_CR_UID,MED_UPD_DT,MED_UPD_UID,MED_SA_CONS_MONTHS,MED_NO_OF_VALID_DAYS,MED_SA_FM,MED_SA_TO FROM PM_IL_MED_EXAM_DTL where MED_MEH_SYS_ID ='"+ meh_sys_id+ "'";
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection);
				compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getMedicalExamList().clear();
				while (resultSet.next()) {
					PM_IL_MED_EXAM_DTL PM_IL_MED_EXAM_DTL_BEAN = new PM_IL_MED_EXAM_DTL();
					PM_IL_MED_EXAM_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
					PM_IL_MED_EXAM_DTL_BEAN.setMED_MEH_SYS_ID(resultSet.getLong("MED_MEH_SYS_ID"));                                                                                                                                                                                    
					PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE(resultSet.getString("MED_EXAM_CODE"));                                                                                                                                                                                  
					PM_IL_MED_EXAM_DTL_BEAN.setMED_CR_DT(resultSet.getDate("MED_CR_DT"));                                                                                                                                                                                          
					PM_IL_MED_EXAM_DTL_BEAN.setMED_CR_UID(resultSet.getString("MED_CR_UID"));                                                                                                                                                                                  
					PM_IL_MED_EXAM_DTL_BEAN.setMED_UPD_DT(resultSet.getDate("MED_UPD_DT"));                                                                                                                                                                                          
					PM_IL_MED_EXAM_DTL_BEAN.setMED_UPD_UID(resultSet.getString("MED_UPD_UID"));
					
					/*added by R. Raja on 15-12-2016 for RM018T - FSD_IL_ZB Life_017-Medical Report Validity Period*/ 
					
					PM_IL_MED_EXAM_DTL_BEAN.setMED_NO_OF_VALID_DAYS(resultSet
							.getInt("MED_NO_OF_VALID_DAYS"));
					PM_IL_MED_EXAM_DTL_BEAN.setMED_SA_CONS_MONTHS(resultSet
							.getInt("MED_SA_CONS_MONTHS"));
					
					/*end*/
					
					/* Added by ganesh on 02-06-2017, ZBILQC-1719236 suggested by Arunkumar G */
					PM_IL_MED_EXAM_DTL_BEAN.setMEDL_SUM_ASSURED_FM(resultSet.getDouble("MED_SA_FM"));
					PM_IL_MED_EXAM_DTL_BEAN.setMEDL_SUM_ASSURED_TO(resultSet.getDouble("MED_SA_TO"));
					
					/*end*/
					
					compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getMedicalExamList().add(PM_IL_MED_EXAM_DTL_BEAN);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally {
				CommonUtils.closeCursor(resultSet);
			}
		}
}

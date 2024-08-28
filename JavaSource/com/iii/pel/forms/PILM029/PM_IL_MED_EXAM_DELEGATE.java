package com.iii.pel.forms.PILM029;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_MED_EXAM_DELEGATE {

	public int updateData(PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr)
			throws ValidatorException,Exception {
		ControlBean controlBean = new ControlBean();
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		PM_IL_MED_EXAM_HELPER helper = new PM_IL_MED_EXAM_HELPER();
//		helper.L_VALIDATE_RANGE(pm_il_med_exam_hdr);
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_hdr, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_HDR gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new ArrayList<SelectItem>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}

	/**
	 * Insertion for medical examination header details
	 * 
	 * @param pm_il_med_exam_hdr_action
	 * @return
	 */
	public String insertValuesForMedHeader(
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action) {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;

		try {
			connection = CommonUtils.getConnection();
			valueBeanList = pm_il_med_exam_hdr_action.getMedicalExamList();
			for (int i = 0; i < valueBeanList.size(); i++) {

				PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = (PM_IL_MED_EXAM_HDR) valueBeanList
						.get(i);

				Date date = new Date();
				DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
				String s = df.format(date);
				Date today = df.parse(s);
				System.out.println("Today = " + df.format(today));
				// int sysId = preInsertValidation();
				pm_il_med_exam_hdr.setMEH_CR_DT(today);
				// pm_il_med_exam_hdr.setMEH_CR_UID("LIFEALL");
				// pm_il_med_exam_hdr.setMEH_SYS_ID(sysId);
				if (pm_il_med_exam_hdr.isCheck()) {
					pm_il_med_exam_hdr.setMEH_FRZ_FLAG("Y");
				} else {
					pm_il_med_exam_hdr.setMEH_FRZ_FLAG("N");
				}

				int row = handler.executeInsert(pm_il_med_exam_hdr, connection);

				if (row > 0) {
					System.out
							.println("<-------------Insertion Successful---------->");
				}
			}

			connection.commit();

		} catch (Exception exception) {

			exception.printStackTrace();

		} finally {

			try {

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return "inserted";
	}

	public Long preInsertValidation() throws Exception {

		CommonUtils commonUtils = new CommonUtils();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Long sysId = null;
		ResultSet resultSet = null;
		try {

			String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};
			// L_VALIDATE_RANGE.L_VALIDATE_RANGE();
			resultSet = handler.executeSelectStatement(query, connection);
			if (resultSet.next()) {
				sysId = resultSet.getLong(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			 CommonUtils.closeCursor(resultSet);
//			resultSet.close();
		}
		return sysId;
	}

	
	public Long preInsertValidationHdr(PM_IL_MED_EXAM_HDR PM_IL_MED_EXAM_HDR_BEAN) throws Exception {

		CommonUtils commonUtils = new CommonUtils();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Long sysId = null;
		ResultSet resultSet = null;
		try {

			String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};
			// L_VALIDATE_RANGE.L_VALIDATE_RANGE();
			new PM_IL_MED_EXAM_HELPER().L_VALIDATE_RANGE(PM_IL_MED_EXAM_HDR_BEAN);
			resultSet = handler.executeSelectStatement(query, connection);
			if (resultSet.next()) {
				sysId = resultSet.getLong(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			 CommonUtils.closeCursor(resultSet);
//			resultSet.close();
		}
		return sysId;
	}

	/* for medical detail block */

	public List suggestionActionForMedDet(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {

			query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
					+ "WHERE PC_TYPE = 'IL_MED_EXM' "
					+ "AND NVL(PC_FRZ_FLAG,'N') = 'N'" +
							"ORDER BY 1ASC";

			CodeList = codeLOV(query);
		} else {

			query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
					+ "WHERE PC_TYPE = 'IL_MED_EXM' "
					+ "AND NVL(PC_FRZ_FLAG,'N') = 'N'"
					+ "AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" +
							"ORDER BY 1ASC";

					

			CodeList = codeLOV(query);

		}

		return CodeList;
	}

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = (PM_IL_MED_EXAM_DTL) iterator
					.next();
			if (Code.equalsIgnoreCase(pm_il_med_exam_dtl.getMED_EXAM_CODE())) {
				codedesc = pm_il_med_exam_dtl.getUI_M_MED_EXAM_CODE_DESC();
			}
		}
		return codedesc;
	}

	public List<PM_IL_MED_EXAM_DTL> codeLOV(String query) {
		List<PM_IL_MED_EXAM_DTL> codeList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = new PM_IL_MED_EXAM_DTL();
				pm_il_med_exam_dtl.setMED_EXAM_CODE(resultSet.getString(1));
				pm_il_med_exam_dtl.setUI_M_MED_EXAM_CODE_DESC(resultSet
						.getString(2));

				codeList.add(pm_il_med_exam_dtl);
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

	public String insertValuesForMedDetail(
			PM_IL_MED_EXAM_DTL_ACTION pm_il_med_exam_dtl_action) {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;

		try {
			connection = CommonUtils.getConnection();
			valueBeanList = pm_il_med_exam_dtl_action.getMedicalExamList();
			for (int i = 0; i < valueBeanList.size(); i++) {

				PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = (PM_IL_MED_EXAM_DTL) valueBeanList
						.get(i);
				double sysId = preInsertValidation();
				int row = handler.executeInsert(pm_il_med_exam_dtl, connection);

				if (row > 0) {
					System.out
							.println("<-------------Insertion Successful---------->");
				}
			}

			connection.commit();

		} catch (Exception exception) {

			exception.printStackTrace();

		} finally {

			try {

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return "inserted";
	}

	public int updateData(PM_IL_MED_EXAM_DTL pm_il_med_exam_DTL)
			throws Exception {
		// ControlBean controlBean = new ControlBean();
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_DTL, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_DTL gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public void getValuesForHeader(PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		try {
			
			connection = CommonUtils.getConnection();
			compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getMedicalExamList().clear();
			String query = "select MEH_FRZ_FLAG,MEH_SUM_ASSURED_FM,MEH_SUM_ASSURED_TO,MEH_AGE_FM,MEH_AGE_TO,MEH_PROD_CODE_FM,MEH_PROD_CODE_TO,"
					+ "ROWID AS COLUMNROWID,MEH_SYS_ID from PM_IL_MED_EXAM_HDR ";
			resultSet = dbHandler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = new PM_IL_MED_EXAM_HDR();
				pm_il_med_exam_hdr.setMEH_SUM_ASSURED_FM(resultSet
						.getDouble("MEH_SUM_ASSURED_FM"));
				pm_il_med_exam_hdr.setMEH_SUM_ASSURED_TO(resultSet
						.getDouble("MEH_SUM_ASSURED_TO"));
				pm_il_med_exam_hdr.setMEH_AGE_FM(resultSet
						.getInt("MEH_AGE_FM"));
				pm_il_med_exam_hdr.setMEH_AGE_TO(resultSet
						.getInt("MEH_AGE_TO"));
				pm_il_med_exam_hdr.setMEH_PROD_CODE_FM(resultSet
						.getString("MEH_PROD_CODE_FM"));
				pm_il_med_exam_hdr.setMEH_PROD_CODE_TO(resultSet
						.getString("MEH_PROD_CODE_TO"));
				pm_il_med_exam_hdr.setMEH_FRZ_FLAG(resultSet
						.getString("MEH_FRZ_FLAG"));
				pm_il_med_exam_hdr.setMEH_SYS_ID(resultSet
						.getLong("MEH_SYS_ID"));
				pm_il_med_exam_hdr.setROWID(resultSet.getString("COLUMNROWID"));
				compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getMedicalExamList().add(pm_il_med_exam_hdr);

			}

			/*
			 * list = dbHandler.fetch(query,
			 * "com.iii.pel.forms.PILM029.PM_IL_MED_EXAM_HDR", connection);
			 */
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

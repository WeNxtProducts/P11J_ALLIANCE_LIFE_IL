package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_MED_EXAM_DELEGATE {

	public int updateData(PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr)
			throws Exception {
		ControlBean controlBean = new ControlBean();
		Connection connection = null;

		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_hdr, connection);
//			connection.commit();

		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_HDR gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
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
				pm_il_med_exam_hdr.setMEH_CR_DT(today);
				int row = handler.executeInsert(pm_il_med_exam_hdr, connection);
				if (row > 0) {
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

	public double preInsertValidation() throws Exception {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		double sysId = 1D;
		ResultSet resultSet = null;
		try {

			String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};
			// L_VALIDATE_RANGE.L_VALIDATE_RANGE();
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getDouble(1);
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
		}finally{
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
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;

		try {
			connection = CommonUtils.getConnection();
			valueBeanList = pm_il_med_exam_dtl_action.getMedicalExamDtlsList();
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
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_DTL, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_DTL gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
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

	public ArrayList<PM_IL_MED_EXAM_HDR> fetchMedExamHdrList(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_MED_EXAM_HDR headBean = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		ArrayList<PM_IL_MED_EXAM_HDR> medicalExamList = new ArrayList<PM_IL_MED_EXAM_HDR>();
		String query = "SELECT PM_IL_MED_EXAM_HDR.ROWID, PM_IL_MED_EXAM_HDR.* FROM PM_IL_MED_EXAM_HDR WHERE MEH_PT_SYS_ID = ?";
		
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID()});
			
			while(resultSet.next()) {
				headBean = new PM_IL_MED_EXAM_HDR();
				
				headBean.setROWID(resultSet.getString(1));
				headBean.setMEH_SYS_ID(resultSet.getDouble(2));
				headBean.setMEH_PT_SYS_ID(resultSet.getDouble(3));
				headBean.setMEH_SUM_ASSURED_FM(resultSet.getDouble(4));
				headBean.setMEH_SUM_ASSURED_TO(resultSet.getDouble(5));
				headBean.setMEH_AGE_FM(resultSet.getInt(6));
				headBean.setMEH_AGE_TO(resultSet.getInt(7));
				headBean.setMEH_FRZ_FLAG(resultSet.getString(8));
				headBean.setMEH_CR_DT(resultSet.getDate(9));
				headBean.setMEH_CR_UID(resultSet.getString(10));
				headBean.setMEH_UPD_DT(resultSet.getDate(11));
				headBean.setMEH_UPD_UID(resultSet.getString(12));
				headBean.setMEH_PROD_CODE_FM(resultSet.getString(13));
				headBean.setMEH_PROD_CODE_TO(resultSet.getString(14));
				
				medicalExamList.add(headBean);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicalExamList;
	}
	
	public ArrayList<PM_IL_MED_EXAM_DTL> fetchMedExamDtlsList(PM_IL_MED_EXAM_HDR headerBean) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_MED_EXAM_DTL dtlsBean = null;
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PM_IL_MED_EXAM_DTL> medicalDtlsList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		String query = "SELECT PM_IL_MED_EXAM_DTL.ROWID, PM_IL_MED_EXAM_DTL.* FROM PM_IL_MED_EXAM_DTL WHERE MED_MEH_SYS_ID = ?";
		
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{headerBean.getMEH_SYS_ID()});
			
			while(resultSet.next()) {
				dtlsBean = new PM_IL_MED_EXAM_DTL();
				
				dtlsBean.setROWID(resultSet.getString(1));
				dtlsBean.setMED_MEH_SYS_ID(resultSet.getDouble(2));
				dtlsBean.setMED_EXAM_CODE(resultSet.getString(3));
				dtlsBean.setMED_CR_DT(resultSet.getDate(4));
				dtlsBean.setMED_CR_UID(resultSet.getString(5));
				dtlsBean.setMED_UPD_DT(resultSet.getDate(6));
				dtlsBean.setMED_UPD_UID(resultSet.getString(7));
				
				medicalDtlsList.add(dtlsBean);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicalDtlsList;
	}
	
}

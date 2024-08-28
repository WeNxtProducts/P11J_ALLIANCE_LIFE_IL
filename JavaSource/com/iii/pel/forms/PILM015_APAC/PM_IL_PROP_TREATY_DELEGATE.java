package com.iii.pel.forms.PILM015_APAC;

import java.lang.reflect.InvocationTargetException;
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
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROP_TREATY_DELEGATE {

	/*
	 * public Connection getConnection() throws Exception { ServletContext
	 * context = (ServletContext) FacesContext
	 * .getCurrentInstance().getExternalContext().getContext(); Connection
	 * connection = ((SimpleConnectionAgent) context
	 * .getAttribute("connectionAgent")).getConnection(""); return connection; }
	 */

	public int updateData(PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr)
			throws Exception {
		ControlBean controlBean = new ControlBean();
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			String s = df.format(date);
			Date today = df.parse(s);
			pm_il_med_exam_hdr.setMEH_CR_DT(today);
			pm_il_med_exam_hdr.setMEH_CR_UID(controlBean.getM_USER_ID());
			int sysId = preInsertValidation();
			pm_il_med_exam_hdr.setMEH_SYS_ID(sysId);
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_hdr, connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_HDR gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) throws Exception {
		Connection connection = null;
		List<SelectItem> listItem = new ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return listItem;
	}

	/** ************************LOV for Treaty Code*********************** 
	 * @throws Exception */
	public List suggestionAction(String treatycode, List treatyCodeList) throws Exception {
		String query = null; 
		try {
		if ("*".equalsIgnoreCase(treatycode)) {
			query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
					+ "where PC_TYPE = 'IL_TTY_TYP' "
					+ "AND NVL(PC_FRZ_FLAG,'N') = 'N'";
			treatyCodeList = treatycodeLOV(query);
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return treatyCodeList;
	}

	public String getTreatyDesc(String treatyCode, List treatyList) {
		Iterator iterator = treatyList.iterator();
		String treatydesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = (PM_IL_PROP_TREATY_TYPE) iterator
					.next();
			if (treatyCode.equalsIgnoreCase(pm_il_prop_treaty_type
					.getPTT_TREATY_TYPE())) {
				treatydesc = pm_il_prop_treaty_type.getUI_M_TREATY_DESC();
			}
		}
		return treatydesc;
	}

	public List<PM_IL_PROP_TREATY_TYPE> treatycodeLOV(String query) throws Exception {
		List<PM_IL_PROP_TREATY_TYPE> treatyList = new ArrayList<PM_IL_PROP_TREATY_TYPE>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = new PM_IL_PROP_TREATY_TYPE();
				pm_il_prop_treaty_type.setPTT_TREATY_TYPE(resultSet
						.getString(1));
				pm_il_prop_treaty_type.setUI_M_TREATY_DESC(resultSet
						.getString(2));

				treatyList.add(pm_il_prop_treaty_type);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + treatyList.size());
		return treatyList;
	}

	/** *************** LOV for Treaty Link Code******************** 
	 * @throws Exception */

	public List treatyLinkCodeAction(String treatyLinkcode,
			List treatyLinkCodeList) throws Exception {
		String query;
		try {
			if ("*".equalsIgnoreCase(treatyLinkcode)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
						+ "where PC_TYPE = 'IL_TTY_TYP' "
						+ "AND NVL(PC_FRZ_FLAG,'N') = 'N'";
					treatyLinkCodeList = treatyLinkCodeLOV(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return treatyLinkCodeList;
	}

	public String getTreatyLinkDesc(String treatyLinkCode, List treatyList) {
		Iterator iterator = treatyList.iterator();
		String treatyLinkDesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = (PM_IL_PROP_TREATY_TYPE) iterator
					.next();
			if (treatyLinkCode.equalsIgnoreCase(pm_il_prop_treaty_type
					.getPTT_LINK_TREATY_CODE())) {
				treatyLinkDesc = pm_il_prop_treaty_type
						.getUI_M_LINK_TREATY_DESC();
			}
		}
		return treatyLinkDesc;
	}

	public List<PM_IL_PROP_TREATY_TYPE> treatyLinkCodeLOV(String query) throws Exception {
		List<PM_IL_PROP_TREATY_TYPE> treatyList = new ArrayList<PM_IL_PROP_TREATY_TYPE>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = new PM_IL_PROP_TREATY_TYPE();
				pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE(resultSet
						.getString(1));
				pm_il_prop_treaty_type.setUI_M_LINK_TREATY_DESC(resultSet
						.getString(2));
				treatyList.add(pm_il_prop_treaty_type);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return treatyList;
	}

	/**
	 * Insertion for medical examination header details
	 * 
	 * @param pm_il_med_exam_hdr_action
	 * @return
	 * @throws Exception 
	 */
	public String insertValuesForMedHeader(
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;
		Date date = new Date();
		try {
			connection = CommonUtils.getConnection();
			valueBeanList = pm_il_med_exam_hdr_action.getMedicalExamList();
			for (int i = 0; i < valueBeanList.size(); i++) {
				PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = (PM_IL_MED_EXAM_HDR) valueBeanList
						.get(i);
				DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
				String s = df.format(date);
				Date today = df.parse(s);
				pm_il_med_exam_hdr.setMEH_CR_DT(today);
				int row = handler.executeInsert(pm_il_med_exam_hdr, connection);
				if (row > 0) {
				}
			}
			connection.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
		return "inserted";
	}

	public int preInsertValidation() throws Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		int sysId = -1;
		ResultSet resultSet = null;
		try {
			String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getInt(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;
	}

	/* for medical detail block */

	public List<PM_IL_MED_EXAM_DTL> suggestionActionForMedDet(String code) throws Exception {
		List<PM_IL_MED_EXAM_DTL> CodeList = null;
		String query = null;
		try {
			if ("*".equalsIgnoreCase(code)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
						+ "WHERE PC_TYPE = 'IL_MED_EXM' "
						+ "AND NVL(PC_FRZ_FLAG,'N') = 'N'";
			} else {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
				+ "WHERE PC_TYPE = 'IL_MED_EXM' "
				+ "AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE '" + code + "%'";
			}
			CodeList = codeLOV(query);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return CodeList;
	}

	public String getCodeDesc(String Code, List<PM_IL_MED_EXAM_DTL> codeList) {
		Iterator<PM_IL_MED_EXAM_DTL> iterator = codeList.iterator();
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

	public List<PM_IL_MED_EXAM_DTL> codeLOV(String query) throws Exception {
		List<PM_IL_MED_EXAM_DTL> codeList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		ResultSet resultSet=null;
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
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public int updateData(PM_IL_MED_EXAM_DTL pm_il_med_exam_DTL)
			throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler
					.executeInsert(pm_il_med_exam_DTL, connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_MED_EXAM_DTL gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	/* LOV for treaty cover */

	public List coverCodeSuggestionBox(String code, List CodeList) throws Exception {
		String query;
		try {
			if ("*".equalsIgnoreCase(code)) {
				query = "SELECT COVER_CODE,COVER_DESC " + "FROM PM_IL_COVER "
						+ "WHERE " + "COVER_FRZ_FLAG = 'N' "
						+ "AND COVER_TYPE = NVL('B',COVER_TYPE)";
				CodeList = coverCodeLOV(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return CodeList;
	}

	public String getCoverCodeDesc(String coverCode, List coverCodeList) {
		Iterator iterator = coverCodeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = (PM_IL_PROP_TREATY_COVER) iterator
					.next();
			if (coverCode.equalsIgnoreCase(pm_il_prop_treaty_cover
					.getPTC_COVER_CODE())) {
				codedesc = pm_il_prop_treaty_cover.getUI_M_COVER_DESC();
			}
		}
		return codedesc;
	}

	public List<PM_IL_PROP_TREATY_COVER> coverCodeLOV(String query) throws Exception {
		List<PM_IL_PROP_TREATY_COVER> codeList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		ResultSet resultSet=null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_COVER_CODE(resultSet
						.getString(1));
				pm_il_prop_treaty_cover.setUI_M_COVER_DESC(resultSet
						.getString(2));
				codeList.add(pm_il_prop_treaty_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	/** *************LOV for Tarriff Code*************** 
	 * @throws Exception */
	public List TarrifCodeSuggestionBox(String tarrifCode, List tarrifList) throws Exception {
		String query = null ;
		try {
			if ("*".equalsIgnoreCase(tarrifCode)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE "
						+ " PC_TYPE = 'IL_VAL_TAR' " + " AND "
						+ " NVL(PC_FRZ_FLAG,'N') = 'N'";
				tarrifList = tarrifCodeLOV(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return tarrifList;
	}

	public String gettarrifCodeDesc(String tarifCode, List tariffCodeList) {
		Iterator iterator = tariffCodeList.iterator();
		String tarrifcodedesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = (PM_IL_PROP_TREATY_COVER) iterator
					.next();
			if (tarifCode.equalsIgnoreCase(pm_il_prop_treaty_cover
					.getPTC_SUB_STD_TARIFF())) {
				tarrifcodedesc = pm_il_prop_treaty_cover
						.getUI_M_PTC_SUB_STD_TARIFF_DESC();
			}
		}
		return tarrifcodedesc;
	}

	public List<PM_IL_PROP_TREATY_COVER> tarrifCodeLOV(String query) throws Exception {
		List<PM_IL_PROP_TREATY_COVER> codeList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		ResultSet resultSet=null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TARIFF(resultSet
						.getString(1));
				pm_il_prop_treaty_cover
						.setUI_M_PTC_SUB_STD_TARIFF_DESC(resultSet.getString(2));
				codeList.add(pm_il_prop_treaty_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return codeList;
	}

	/** *******************LOV***************************** 
	 * @throws Exception */
	public List groupCodeSuggestionBox(String groupCode, List groupList) throws Exception {
		String query = null ;
		try {
			if ("*".equalsIgnoreCase(groupCode)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE "
						+ " PC_TYPE = 'IL_RI_GR_CVR' " + " AND "
						+ " NVL(PC_FRZ_FLAG,'N') = 'N'";
					groupList = groupCodeLOV(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return groupList;
	}

	public String getGroupCodeDesc(String groupCode, List groupCodeList) {
		Iterator iterator = groupCodeList.iterator();
		String groupcodedesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = (PM_IL_PROP_TREATY_COVER) iterator
					.next();
			if (groupCode.equalsIgnoreCase(pm_il_prop_treaty_cover
					.getPTC_CVR_GRP_CODE())) {
				groupcodedesc = pm_il_prop_treaty_cover
						.getUI_M_PTC_CVR_GRP_CODE_DESC();
			}
		}
		return groupcodedesc;
	}

	public List<PM_IL_PROP_TREATY_COVER> groupCodeLOV(String query) throws Exception {
		List<PM_IL_PROP_TREATY_COVER> codeList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		ResultSet resultSet=null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_CVR_GRP_CODE(resultSet
						.getString(1));
				pm_il_prop_treaty_cover.setUI_M_PTC_CVR_GRP_CODE_DESC(resultSet
						.getString(2));
				codeList.add(pm_il_prop_treaty_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public int executeInsertForTreatyType(Object insertObject) throws Exception {
		Connection connection = null;
		int effectedRows = 0;
		try {
			CRUDHandler crudHandler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			effectedRows = crudHandler.executeInsert(insertObject, connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return effectedRows;
	}

	public Double getSysIdForTreatyType() throws SQLException, Exception {
		CRUDHandler handler = new CRUDHandler();
		Double sysId = null;
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			String query = "SELECT PIL_PTT_SYS_ID.NEXTVAL FROM  DUAL ";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getDouble(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;

	}

	public int getSysIdForTreaty() throws SQLException, Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		int sysId = -1;
		ResultSet resultSet = null;
		try {
			String query = "SELECT PIL_PT_SYS_ID.NEXTVAL FROM  DUAL";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getInt(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;

	}

	/** ***************Treaty Cover************************* */
	public int updateForTreatyCover(
			PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover) throws Exception {
		ControlBean controlBean = new ControlBean();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			String s = df.format(date);
			Date today = df.parse(s);
			rowUpdated = dbHandler.executeInsert(pm_il_prop_treaty_cover,
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public Double getSysIdForCover() throws SQLException, Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Double sysId = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			String query = "SELECT PIL_PTC_SYS_ID.NEXTVAL FROM  DUAL";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getDouble(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;
	}

	public int deleteData(PM_IL_PROP_TREATY_COVER gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	public List getValuesForHeader() throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			String query = "select MEH_FRZ_FLAG,MEH_SUM_ASSURED_FM,MEH_SUM_ASSURED_TO,MEH_AGE_FM,MEH_AGE_TO,"
					+ "ROWID AS COLUMNROWID,MEH_SYS_ID from PM_IL_MED_EXAM_HDR ";
			list = dbHandler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_MED_EXAM_HDR",
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return list;
	}

	// ***************************Methods from
	// Varun********************************************

	/**
	 * Gets List of SelectItem for TreatyMaster Select Items
	 * 
	 * @param itemName
	 *            ItemName String
	 * @param sysParam
	 *            SysParam String
	 * @return List of SelectItem
	 * @throws Exception 
	 */
	public List<SelectItem> getListTreatyMaster(String itemName, String sysParam) throws Exception {
		Connection connection;
		List<SelectItem> itemList = null;
		try {
			connection = CommonUtils.getConnection();
			itemList = ListItemUtil
					.getDropDownListValue(
							connection,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_MODULE_NAME_PILM015_APAC,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_BLOCK_NAME_PM_IL_PROP_TREATY,
							itemName, sysParam);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return itemList;
	}

	/**
	 * Executes Insert and Update for PM_IL_PROP_TREATY Bean
	 * 
	 * @param PM_IL_PROP_TREATY
	 * @throws Exception 
	 */
	public void executeInsertAction(PM_IL_PROP_TREATY PM_IL_PROP_TREATY) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		try {
			connection = CommonUtils.getConnection();
			String rowId = PM_IL_PROP_TREATY.getROWID();
			if (rowId == null) {
				PM_IL_PROP_TREATY.setPT_CR_UID(CommonUtils.getControlBean()
						.getM_USER_ID());
				PM_IL_PROP_TREATY.setPT_CR_DT(helper.getTodaysDate());
				commonUtils.objectSysout(PM_IL_PROP_TREATY);
			} else {
				PM_IL_PROP_TREATY.setPT_UPD_DT(helper.getTodaysDate());
				PM_IL_PROP_TREATY.setPT_UPD_UID(CommonUtils.getControlBean()
						.getM_USER_ID());
			}
			handler.executeInsert(PM_IL_PROP_TREATY, connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Executes update for PM_IL_PROP_TREATY_TYPE_CVR Bean
	 * 
	 * @param dataGridBean
	 * @return
	 * @throws Exception
	 */
	public int updateData(PM_IL_PROP_TREATY_TYPE_CVR dataGridBean)
			throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	/**
	 * Executes Insert for PM_IL_PROP_TREATY_TYPE_CVR_ACTION bean
	 * 
	 * @param dataGridAction
	 *            PM_IL_PROP_TREATY_TYPE_CVR_ACTION bean
	 * @return
	 * @throws Exception 
	 */
	public String saveData(PM_IL_PROP_TREATY_TYPE_CVR_ACTION dataGridAction) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_IL_PROP_TREATY_TYPE_CVR> valueBeanList = null;
		try {
			connection = CommonUtils.getConnection();
			valueBeanList = dataGridAction.getDataTableList();
			for (int index = 0; index < valueBeanList.size(); index++) {
				PM_IL_PROP_TREATY_TYPE_CVR gridValueBean = (PM_IL_PROP_TREATY_TYPE_CVR) valueBeanList
						.get(index);
				handler.executeInsert(gridValueBean, connection);
			}
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return "";
	}

	/**
	 * Executes Delete for the bean
	 * 
	 * @param gridValueBean
	 *            Object for GridValueBean
	 * @return
	 * @throws Exception 
	 */
	public int deleteData(Object gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	/**
	 * Used for Fetching values for datatable List of PM_IL_PROP_TREATY_TYPE_CVR
	 * 
	 * @return provides List of Fetched values
	 * @throws Exception 
	 */
	public List getValues() throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			String query = "select PM_IL_PROP_TREATY_TYPE_COVER.ROWID,PTTC_PTT_SYS_ID,"
					+ "PTTC_SYS_ID,PTTC_COVER_CODE,PTTC_PERC,PTTC_CR_DT"
					+ "PTTC_CR_UID,PTTC_UPD_DT,PTTC_UPD_UID"
					+ "FROM PM_IL_PROP_TREATY_TYPE_COVER"
					+ "WHERE PTTC_PTT_SYS_ID='396'";
			list = dbHandler
					.fetch(
							query,
							"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_TYPE_CVR",
							connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return list;
	}

	/**
	 * Executes Update Data for PM_IL_PROP_TREATY_PART_CUST bean
	 * 
	 * @param dataGridBean
	 *            PM_IL_PROP_TREATY_PART_CUST bean
	 * @return return no. of rows updated
	 * @throws Exception
	 */
	public int updateDataForCustomer(PM_IL_PROP_TREATY_PART_CUST dataGridBean)
			throws ValidatorException, SQLException, Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public List<PM_IL_PROP_TREATY_TYPE> prepareTreatyList(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			double sysId) throws Exception {
		List<PM_IL_PROP_TREATY_TYPE> treatyList = new ArrayList<PM_IL_PROP_TREATY_TYPE>();
		ResultSet resultSet = null;
		PM_IL_PROP_TREATY_TYPE_HELPER treatyTypeHelper = new PM_IL_PROP_TREATY_TYPE_HELPER();
		try {
			Connection connection = CommonUtils.getConnection();
			String selectQuery = "SELECT P.*,PT.*,P.ROWID AS ROWID1,PT.ROWID AS ROWID2	"
					+ "FROM PM_IL_PROP_TREATY P,PM_IL_PROP_TREATY_TYPE PT "
					+ "WHERE PT.PTT_PT_SYS_ID=P.PT_SYS_ID AND  PT.PTT_PT_SYS_ID='"
					+ sysId + "'";
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = new PM_IL_PROP_TREATY_TYPE();
				pm_il_prop_treaty_type.setPTT_SYS_ID(resultSet
						.getDouble("PTT_SYS_ID"));
				pm_il_prop_treaty_type.setPTT_PT_SYS_ID(resultSet
						.getDouble("PTT_PT_SYS_ID"));
				pm_il_prop_treaty_type.setPTT_SRNO(resultSet
						.getDouble("PTT_SRNO"));
				pm_il_prop_treaty_type.setROWID(resultSet.getString("ROWID2"));
				pm_il_prop_treaty_type.setPTT_TREATY_TYPE(resultSet
						.getString("PTT_TREATY_TYPE"));
				pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE(resultSet
						.getString("PTT_LINK_TREATY_CODE"));
				pm_il_prop_treaty_type.setPTT_MGT_EXP_RATIO(resultSet
						.getDouble("PTT_MGT_EXP_RATIO"));
				pm_il_prop_treaty_type.setPTT_PROFIT_COMM(resultSet
						.getDouble("PTT_PROFIT_COMM"));
				pm_il_prop_treaty_type.setPTT_REINS_TAX_PERC(resultSet
						.getDouble("PTT_REINS_TAX_PERC"));
				pm_il_prop_treaty_type.setPTT_PREM_PF_ENT_PERC(resultSet
						.getDouble("PTT_PREM_PF_ENT_PERC"));
				pm_il_prop_treaty_type.setPTT_PREM_PF_WD_PERC(resultSet
						.getDouble("PTT_PREM_PF_WD_PERC"));
				pm_il_prop_treaty_type.setPTT_LOSS_PF_ENT_PERC(resultSet
						.getDouble("PTT_LOSS_PF_ENT_PERC"));
				pm_il_prop_treaty_type.setPTT_LOSS_PF_WD_PERC(resultSet
						.getDouble("PTT_LOSS_PF_WD_PERC"));
				pm_il_prop_treaty_type.setPTT_LOSS_CF_YEARS(resultSet
						.getDouble("PTT_LOSS_CF_YEARS"));
				pm_il_prop_treaty_type.setPTT_DEPOSIT_PREM(resultSet
						.getDouble("PTT_DEPOSIT_PREM"));
				pm_il_prop_treaty_type.setPTT_PREM_RES_RATIO(resultSet
						.getDouble("PTT_PREM_RES_RATIO"));
				pm_il_prop_treaty_type.setPTT_INT_ON_RES_REL(resultSet
						.getDouble("PTT_INT_ON_RES_REL"));
				pm_il_prop_treaty_type.setPTT_OS_CLM_RES_RATIO(resultSet
						.getDouble("PTT_OS_CLM_RES_RATIO"));
				pm_il_prop_treaty_type.setPTT_EXCLUSION(resultSet
						.getString("PTT_EXCLUSION"));
				pm_il_prop_treaty_type.setPTT_NOTICE_CANCEL_DAYS(resultSet
						.getDouble("PTT_NOTICE_CANCEL_DAYS"));
				pm_il_prop_treaty_type.setPTT_ACCOUNTS_SUBMIT_PERIOD(resultSet
						.getString("PTT_ACCOUNTS_SUBMIT_PERIOD"));
				pm_il_prop_treaty_type.setPTT_FRZ_FLAG(resultSet
						.getString("PTT_FRZ_FLAG"));
				pm_il_prop_treaty_type.setPTT_NET_SURPLUS_AMT(resultSet
						.getDouble("PTT_NET_SURPLUS_AMT"));
				pm_il_prop_treaty_type.setPTT_ACCOUNTS_CLOSE_PERIOD(resultSet
						.getString("PTT_ACCOUNTS_CLOSE_PERIOD"));
				PM_IL_PROP_TREATY treatyValueBean = compositeAction
						.getPM_IL_PROP_TREATY_ACTION()
						.getPM_IL_PROP_TREATY_BEAN();
				try {
					treatyTypeHelper
							.pilm015_apac_pm_il_prop_treaty_type_post_query(
									pm_il_prop_treaty_type, treatyValueBean);// Post-Query
					treatyTypeHelper
							.pilm015_apac_pm_il_prop_treaty_type_pre_record(
									pm_il_prop_treaty_type, compositeAction);// PRE-RECORD
					treatyTypeHelper
							.pilm015_apac_pm_il_prop_treaty_type__when_new_record_instance(compositeAction);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
				treatyList.add(pm_il_prop_treaty_type);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return treatyList;
	}

	public List<PM_IL_PROP_TREATY_COVER> prepareCoverList() throws Exception {
		List<PM_IL_PROP_TREATY_COVER> coverList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection connection = CommonUtils.getConnection();
			String selectQuery = "SELECT P.*,PC.*	"
					+ "FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_COVER PC "
					+ "WHERE PC.PTC_PTT_SYS_ID=P.PTT_SYS_ID ";
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_COVER_CODE(resultSet
						.getString("PTC_COVER_CODE"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_SUB_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_RETN_PERC(resultSet
						.getDouble("PTC_RETN_PERC"));
				pm_il_prop_treaty_cover.setPTC_STD_MAX_RETN(resultSet
						.getDouble("PTC_STD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_MAX_RETN(resultSet
						.getDouble("PTC_SSTD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TARIFF(resultSet
						.getString("PTC_SUB_STD_TARIFF"));
				pm_il_prop_treaty_cover.setPTC_GROUP_COVER_YN(resultSet
						.getString("PTC_GROUP_COVER_YN"));
				pm_il_prop_treaty_cover.setPTC_CVR_GRP_CODE(resultSet
						.getString("PTC_CVR_GRP_CODE"));
				coverList.add(pm_il_prop_treaty_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return coverList;

	}

	/**
	 * Provides List of SelectItems for TreatyCust dropdown
	 * 
	 * @param itemName
	 *            string ItemName
	 * @param sysParam
	 *            string sysparam
	 * @return List<SelectItem>
	 * @throws Exception 
	 */
	public List<SelectItem> getListTreatyCust(String itemName, String sysParam) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection;
		List<SelectItem> itemList = null;
		try {
			connection = CommonUtils.getConnection();
			itemList = ListItemUtil
					.getDropDownListValue(
							connection,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_MODULE_NAME_PILM015_APAC,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_TREATY_PART_CUST,
							itemName, sysParam);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return itemList;
	}

	/**
	 * Used for Fetching values for datatable List of
	 * PM_IL_PROP_TREATY_PART_CUST
	 * 
	 * @return provides List of Fetched values
	 * @throws Exception 
	 */
	public List getValuesForCustomer() throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			String query = "select PTPC_SYS_ID,PTPC_CUST_CODE,PTPC_PTT_SYS_ID,PTPC_SHARE_PERC,"
					+ "PTPC_LEADER_YN,PTPC_CR_DT PTPC_CR_UID,PTPC_UPD_DT,PTPC_UPD_UID from PM_IL_PROP_TREATY_PART_CUST"
					+ " WHERE PTPC_PTT_SYS_ID='396'";
			list = dbHandler
					.fetch(
							query,
							"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_PART_CUST",
							connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return list;
	}

	public void preDelete(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			PM_IL_PROP_TREATY pm_il_prop_treaty) throws Exception {
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			double syId = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String treatyTypeDelete = "DELETE FROM PM_IL_PROP_TREATY_TYPE WHERE PTT_PT_SYS_ID ='"
					+ syId + "'";
			String medicalDelete = "DELETE FROM PM_IL_MED_EXAM_HDR WHERE MEH_PT_SYS_ID ='"
					+ syId + "'";
			String heightWeightDelete = "DELETE FROM PM_IL_HTWT_DTL WHERE HTWT_PT_SYS_ID='"
					+ syId + "'";
			handler.executeDeleteStatement(treatyTypeDelete, connection);
			handler.executeDeleteStatement(medicalDelete, connection);
			handler.executeDeleteStatement(heightWeightDelete, connection);
			handler.executeDelete(pm_il_prop_treaty, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Executes Delete for PM_IL_PROP_TREATY bean
	 * 
	 * @param PM_IL_PROP_TREATY
	 *            PM_IL_PROP_TREATY value bean
	 * @throws Exception 
	 */
	public void executeDeleteAction(PM_IL_PROP_TREATY PM_IL_PROP_TREATY) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String rowId = PM_IL_PROP_TREATY.getROWID();
		Connection connection = null;
		if (rowId != null) {
			try {
				connection = CommonUtils.getConnection();
				int i = handler.executeDelete(PM_IL_PROP_TREATY, connection);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				try {
					connection.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void executeSelectStatement(PM_IL_PROP_TREATY_PART_CUST_ACTION action) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			action.getDataList_PM_IL_PROP_TREATY_CUST_COMM().clear();
			String query = "select ROWID,PM_IL_PROP_TREATY_CUST_COMM.* from PM_IL_PROP_TREATY_CUST_COMM where PTCC_PTPC_SYS_ID=?";
			ResultSet rsPTCT=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{
					action.getPM_IL_PROP_TREATY_PART_CUST_BEAN().getPTPC_SYS_ID()});
			while(rsPTCT.next())
			{
				PM_IL_PROP_TREATY_CUST_COMM bean=new PM_IL_PROP_TREATY_CUST_COMM();
				bean.setROWID(rsPTCT.getString("ROWID"));
				/*added by raja on 18-07-2017 for ZBILQC-1730094*/
				bean.setPTCC_PTPC_SYS_ID(rsPTCT.getDouble("PTCC_PTPC_SYS_ID"));
				/*end*/
				bean.setPTCC_SYS_ID(rsPTCT.getLong("PTCC_SYS_ID"));
				bean.setPTCC_YEAR_FM(rsPTCT.getInt("PTCC_YEAR_FM"));
				bean.setPTCC_YEAR_TO(rsPTCT.getInt("PTCC_YEAR_TO"));
				bean.setPTCC_STD_PERC(rsPTCT.getDouble("PTCC_STD_PERC"));
				bean.setPTCC_SSTD_PERC(rsPTCT.getDouble("PTCC_SSTD_PERC"));
				action.getDataList_PM_IL_PROP_TREATY_CUST_COMM().add(bean);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
	}

}

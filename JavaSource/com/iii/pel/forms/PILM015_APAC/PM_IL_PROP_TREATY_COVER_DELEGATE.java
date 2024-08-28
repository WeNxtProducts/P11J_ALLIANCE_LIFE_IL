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
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROP_TREATY_COVER_DELEGATE {

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

	/* LOV for treaty cover */

	public List coverCodeSuggestionBox(PM_IL_PROP_TREATY treatyBean, String code, List CodeList) throws Exception  {
		String query;
		String RIDER_BASIS = treatyBean.getPT_RIDER_RI_BASIS();
		String coverType = null;
		try{
			if ("*".equalsIgnoreCase(code)) {
				if("B".equalsIgnoreCase(RIDER_BASIS)){
					coverType = "B";
					query = "SELECT COVER_CODE,COVER_DESC " + "FROM PM_IL_COVER "
					+ "WHERE " + "COVER_FRZ_FLAG = 'N' "
					+ "AND COVER_TYPE = NVL('"+coverType+"',COVER_TYPE)" + "ORDER BY 1 ASC";
				}else{
					query = "SELECT COVER_CODE,COVER_DESC " + "FROM PM_IL_COVER "
					+ "WHERE " + "COVER_FRZ_FLAG = 'N' "
					+ "AND COVER_TYPE = NVL(null,COVER_TYPE)" + "ORDER BY 1 ASC";
				}
				CodeList = coverCodeLOV(query);
			}
			else {
				if("B".equalsIgnoreCase(RIDER_BASIS)){
					coverType = "B";
					query = "SELECT COVER_CODE,COVER_DESC" + " FROM PM_IL_COVER"
						+ " WHERE COVER_FRZ_FLAG='N'"
						+ "AND COVER_TYPE= NVL('"+coverType+"',COVER_TYPE)"
						+ "AND UPPER(COVER_CODE) LIKE '" + code.toUpperCase()
						+ "%'" + "ORDER BY 1 ASC";
				}else{
					query = "SELECT COVER_CODE,COVER_DESC" + " FROM PM_IL_COVER"
					+ " WHERE COVER_FRZ_FLAG='N'"
					+ "AND COVER_TYPE= NVL(null,COVER_TYPE)"
					+ "AND UPPER(COVER_CODE) LIKE '" + code.toUpperCase()
					+ "%'" + "ORDER BY 1 ASC";
				}
			}
		}catch (Exception e) {
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
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public List TarrifCodeSuggestionBox(String tarrifCode, List tarrifList) throws Exception {
		String query = null;
		try{
			if ("*".equalsIgnoreCase(tarrifCode)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE "
						+ " PC_TYPE = 'IL_VAL_TAR' " + " AND "
						+ " NVL(PC_FRZ_FLAG,'N') = 'N'";
				tarrifList = tarrifCodeLOV(query);
			} else {
				/* CHANGED BY RAJA ON 19-08-2017 FRO ZBILQC-1735236 */
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE "
						+ " PC_TYPE = 'IL_VAL_TAR' " + " AND "
						+ " NVL(PC_FRZ_FLAG,'N') = 'N'"
						+ "AND UPPER(PC_CODE) LIKE '" + tarrifCode.toUpperCase()
						+ "%'" + "ORDER BY 1ASC";
				/*END*/
				tarrifList = tarrifCodeLOV(query);
			}
		}catch (Exception e) {
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
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public List groupCodeSuggestionBox(String groupCode, List groupList) throws Exception {
		String query;
		try{
			/* CHANGED BY RAJA ON 19-08-2017 FRO ZBILQC-1735236 */
			if ("*".equalsIgnoreCase(groupCode)) {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE "
						+ " PC_TYPE = 'IL_RI_GR_CVR' " + " AND "
						+ " NVL(PC_FRZ_FLAG,'N') = 'N'" + " ORDER BY 1ASC";
				groupList = groupCodeLOV(query);
			} else {
				query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES "
						+ "WHERE PC_TYPE='IL_RI_GR_CVR'"
						+ "AND NVL(PC_FRZ_FLAG,'N')='N'" + " AND UPPER(PC_CODE) LIKE '"+ groupCode.toUpperCase() +"%' " + "ORDER BY 1ASC";
				/*END*/
				groupList = groupCodeLOV(query);
			}
		}catch (Exception e) {
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
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeList;
	}

	public int deleteData(PM_IL_PROP_TREATY_COVER gridValueBean) {
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
			exc.getMessage();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public Double getSysIdForCover() throws Exception  {
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;

	}

	public String insertValues(PM_IL_PROP_TREATY_COVER_ACTION coverAction) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;
		try {
			connection = CommonUtils.getConnection();
			valueBeanList = coverAction.getDataTableList();
			for (int i = 0; i < valueBeanList.size(); i++) {
				PM_IL_PROP_TREATY_COVER coverValueBean = (PM_IL_PROP_TREATY_COVER) valueBeanList
						.get(i);
				int row = handler.executeInsert(coverValueBean, connection);
				if (row > 0) {
				}
			}
			connection.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "inserted";
	}

	/*Added by Janani on 07.02.2018 for ZBLIFE-1468859*/
	public void executeSelectStatement(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION PM_IL_PROP_TREATY_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PROP_TTYCOV_GRP.* FROM PM_IL_PROP_TTYCOV_GRP "
				+ "WHERE PTG_PTC_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
			
		
		ArrayList<PM_IL_PROP_TTYCOV_GRP> list = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		Double PTC_SYS_ID=PM_IL_PROP_TREATY_COMPOSITE_ACTION_BEAN.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().getPTC_SYS_ID();
		System.out.println("PTC_SYS_ID                          : "+PTC_SYS_ID);
		try {
			connection = com.iii.premia.common.utils.CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PTC_SYS_ID});
			while (resultSet.next()) {
				PM_IL_PROP_TTYCOV_GRP PM_IL_PROP_TTYCOV_GRP_BEAN = new PM_IL_PROP_TTYCOV_GRP();
				
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_SYS_ID(resultSet
						.getDouble("PTG_SYS_ID"));
			
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTC_SYS_ID(resultSet
						.getDouble("PTG_PTC_SYS_ID"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTT_SYS_ID(resultSet
						.getDouble("PTG_PTT_SYS_ID"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTC_CVR_GRP_CODE(resultSet
						.getString("PTG_PTC_CVR_GRP_CODE"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_COVER_CODE(resultSet
						.getString("PTG_COVER_CODE"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_SR_NO(resultSet
						.getDouble("PTG_SR_NO"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_CR_UID(resultSet
						.getString("PTG_CR_UID"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_CR_DT(resultSet
						.getDate("PTG_CR_DT"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_UPD_UID(resultSet
						.getString("PTG_UPD_UID"));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_UPD_DT(resultSet
						.getDate("PTG_UPD_DT"));
				

			String cover_desc = PM_IL_PROP_TREATY_COMPOSITE_ACTION_BEAN.getPM_IL_PROP_TREATY_COVER_ACTION().getCoverDesc(PM_IL_PROP_TTYCOV_GRP_BEAN.getPTG_COVER_CODE());

				
				PM_IL_PROP_TTYCOV_GRP_BEAN.setUI_M_PTG_COVER_CODE_DESC(cover_desc);

				System.out.println("getUI_M_PTG_COVER_CODE_DESC                 "+PM_IL_PROP_TTYCOV_GRP_BEAN.
						getUI_M_PTG_COVER_CODE_DESC());
				
				
				list.add(PM_IL_PROP_TTYCOV_GRP_BEAN);
			}
			
			//PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = new PM_IL_PROP_TREATY_COMPOSITE_ACTION();
			PM_IL_PROP_TREATY_COMPOSITE_ACTION_BEAN.getPM_IL_PROP_TTYCOV_GRP_ACTION()
			.setDataTableList(list);
			
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/*End of ZBLIFE-1468859*/
}

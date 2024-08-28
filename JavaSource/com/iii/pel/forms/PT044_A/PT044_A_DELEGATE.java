package com.iii.pel.forms.PT044_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT044_A_DELEGATE {

	public ArrayList<PT_AGENT_TRAN_HDR> fetchSearchDetails(
			PT044_A_SEARCH_ACTION action) {
		ArrayList<PT_AGENT_TRAN_HDR> detailList = null;
		PT_AGENT_TRAN_HDR detailBean = null;
		Object tempObject[] = new Object[3];
		Object object[] = null;
		int index = 0;
		boolean whereAdded = false;
		String custCode = action.getInitAgent_Code();
		String custName = action.getInitpParent_Code();
		String athType = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String selectQuery = "SELECT TBL.ROWID,TBL.* FROM PT_AGENT_TRAN_HDR TBL WHERE ATH_TYPE='"
				+ athType + "' ";

		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;

		if (custCode != null && !custCode.trim().isEmpty()) {
			selectQuery = selectQuery + " AND ATH_AGENT_CODE LIKE ?";
			tempObject[index++] = custCode + "%";
			whereAdded = true;
		}
		if (custName != null && !custName.trim().isEmpty()) {
			if (whereAdded) {
				selectQuery = selectQuery + "AND ATH_PARENT_CODE LIKE ?";
			} else {
				selectQuery = selectQuery + "AND ATH_PARENT_CODE LIKE ? ";
				whereAdded = true;
			}
			tempObject[index++] = custName + "%";
		}
		object = new Object[index];
		for (int idx = 0; idx < index; idx++) {
			object[idx] = tempObject[idx];
		}
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				detailList = new ArrayList<PT_AGENT_TRAN_HDR>();
				rst = handler.executeSelectStatement(selectQuery, con, object);
				while (rst.next()) {
					detailBean = new PT_AGENT_TRAN_HDR();

					pt_agent_tran_hdr_pre_query(detailBean);

					detailBean.setROWID(rst.getString("ROWID"));
					detailBean.setATH_AGENT_CODE(rst
							.getString("ATH_AGENT_CODE"));
					detailBean.setATH_PARENT_CODE(rst
							.getString("ATH_PARENT_CODE"));
					detailBean.setATH_TERMINATION_TYPE(rst
							.getString("ATH_TERMINATION_TYPE"));
					detailBean.setATH_AGENT_NEW_RANK_CODE(rst
							.getString("ATH_AGENT_NEW_RANK_CODE"));
					detailBean.setATH_NEW_AGENT_CODE(rst
							.getString("ATH_NEW_AGENT_CODE"));
					detailBean.setATH_PRODN_TRANSFER_YN(rst
							.getString("ATH_PRODN_TRANSFER_YN"));
					detailBean.setATH_AGENT_RANK_CODE(rst
							.getString("ATH_AGENT_RANK_CODE"));
					detailBean.setATH_TYPE(rst.getString("ATH_TYPE"));

					detailList.add(detailBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailList;
	}

	// SHANKAR --------------------------- OVER
	public void pt_agent_tran_hdr_pre_query(PT_AGENT_TRAN_HDR headerBean) {
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String sysId = CommonUtils.getGlobalVariable("GLOBAL.M_ATH_SYS_ID");
		headerBean.setATH_TYPE(menuParam);
		if (sysId != null) {
			Integer value = Integer.parseInt(sysId);
			headerBean.setATH_SYS_ID(value);
		}
		CommonUtils.setGlobalObject("GLOBAL.M_ATH_SYS_ID", null);
	}

	public PT_AGENT_TRAN_HDR fetchHeaderBeanValues(String searchAgentRowId) {
		PT_AGENT_TRAN_HDR headerBean = null;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT TBL.ROWID,TBL.* FROM PT_AGENT_TRAN_HDR TBL  WHERE ROWID = ?";
		System.out.println("ROWID:::::::" + searchAgentRowId);
		Object[] values = { searchAgentRowId };
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con, values);
				while (rst.next()) {
					headerBean = new PT_AGENT_TRAN_HDR();

					headerBean.setROWID(rst.getString("ROWID"));
					headerBean.setATH_AGENT_CODE(rst
							.getString("ATH_AGENT_CODE"));
					headerBean.setATH_PARENT_CODE(rst
							.getString("ATH_PARENT_CODE"));
					headerBean.setATH_DATE(rst.getDate("ATH_DATE"));
					headerBean.setATH_EFF_FM_DT(rst.getDate("ATH_EFF_FM_DT"));
					headerBean.setATH_TERMINATION_TYPE(rst
							.getString("ATH_TERMINATION_TYPE"));
					headerBean.setATH_AGENT_NEW_RANK_CODE(rst
							.getString("ATH_AGENT_NEW_RANK_CODE"));
					headerBean.setATH_REVIEW1_DT(rst.getDate("ATH_REVIEW1_DT"));
					headerBean.setATH_REVIEW2_DT(rst.getDate("ATH_REVIEW2_DT"));
					headerBean.setATH_REVIEW3_DT(rst.getDate("ATH_REVIEW3_DT"));
					headerBean.setATH_REVIEW4_DT(rst.getDate("ATH_REVIEW4_DT"));
					headerBean.setATH_NEW_AGENT_CODE(rst
							.getString("ATH_NEW_AGENT_CODE"));
					headerBean.setATH_PRODN_TRANSFER_YN(rst
							.getString("ATH_PRODN_TRANSFER_YN"));
					headerBean.setATH_SYS_ID(rst.getInt("ATH_SYS_ID"));
					headerBean.setATH_AGENT_RANK_CODE(rst
							.getString("ATH_AGENT_RANK_CODE"));
					headerBean.setATH_APPRV_FLAG(rst
							.getString("ATH_APPRV_FLAG"));
					headerBean.setATH_TYPE(rst.getString("ATH_TYPE"));
					headerBean.setATH_CR_DT(rst.getDate("ATH_CR_DT"));
					headerBean.setATH_CR_UID(rst.getString("ATH_CR_UID"));
					headerBean.setATH_UPD_DT(rst.getDate("ATH_UPD_DT"));
					headerBean.setATH_UPD_UID(rst.getString("ATH_UPD_UID"));
					headerBean.setATH_POL_SYS_ID(rst.getInt("ATH_POL_SYS_ID"));
					headerBean.setATH_FLEX_01(rst.getString("ATH_FLEX_01"));
					headerBean.setATH_FLEX_02(rst.getString("ATH_FLEX_02"));
					headerBean.setATH_FLEX_03(rst.getString("ATH_FLEX_03"));
					headerBean.setATH_FLEX_04(rst.getString("ATH_FLEX_04"));
					headerBean.setATH_FLEX_05(rst.getString("ATH_FLEX_05"));

					pt_agent_tran_hdr_post_query(headerBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return headerBean;
	}

	public void pt_agent_tran_hdr_post_query(PT_AGENT_TRAN_HDR headerBean) {
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ArrayList<String> listValue = null;
		String selectQuery = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ? ";
		
		/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676*/
		String query="SELECT CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE CCLAS_CODE=?";
		
		/*end*/
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				String menuParam = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_1");
				handler = new CRUDHandler();
				Object[] values = { headerBean.getATH_AGENT_CODE() };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if (rst.next()) {
					headerBean.setUI_M_ATH_AGENT_NAME(rst
							.getString("CUST_NAME"));
				}
				Object[] values1 = { headerBean.getATH_PARENT_CODE() };
				rst = handler.executeSelectStatement(selectQuery, con, values1);
				if (rst.next()) {
					headerBean.setUI_M_ATH_PARENT_NAME(rst
							.getString("CUST_NAME"));
				}
				DBProcedures proceduresCall = new DBProcedures();
				if (("T".equals(menuParam) || "R".equals(menuParam))
						&& (headerBean.getATH_TERMINATION_TYPE() != null)) {
					listValue = proceduresCall.P_VAL_CODES_PROC_CALL(
							"AGTERMIN_TYP", headerBean
									.getATH_TERMINATION_TYPE(), "N", "N");
					headerBean.setUI_M_ATH_TERMINATION_DESC(listValue.get(0));
				}
				if (("M".equals(menuParam))
						&& headerBean.getATH_AGENT_NEW_RANK_CODE() != null) {
					listValue = proceduresCall.P_VAL_CODES_PROC_CALL("AGNRANK",
							headerBean.getATH_AGENT_NEW_RANK_CODE(), "N", "N");
					headerBean.setUI_M_AGENT_NEW_RANK_DESC(listValue.get(0));
				}
				if ("R".equals(menuParam)) {
					Object[] values2 = { headerBean.getATH_NEW_AGENT_CODE() };
					rst = handler.executeSelectStatement(selectQuery, con,
							values2);
					if (rst.next()) {
						headerBean.setUI_M_ATH_NEW_AGENT_NAME(rst
								.getString("CUST_NAME"));
					}
				}
				/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676*/
				
				if (headerBean.getATH_AGENT_NEW_CLASS_CODE()!=null) {
					Object[] values3 = { headerBean.getATH_AGENT_NEW_CLASS_CODE()};
					rst = handler.executeSelectStatement(query, con,
							values3);
					if (rst.next()) {
						headerBean.setATH_AGENT_NEW_CLASS_CODE_DESC(rst.
								getString("CCLAS_CLASS_DESC"));
					}
				}
				/*end*/
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), formName, blockName, blockFieldName,
					filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return listValues;
	}

	public int updateData(PT_AGENT_TRAN_DTLS detailBean) {
		Connection connection = null;
		CRUDHandler handler = null;
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				/*rowUpdated = handler.executeInsert(detailBean, connection);*/
				rowUpdated = handler.executeUpdate(detailBean, connection);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} /*catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		return rowUpdated;
	}

	public int deleteData(PT_AGENT_TRAN_DTLS detailsBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public int updatePolicyDetails(PT_AGENT_POL_DTLS detailBean) {
		Connection connection = null;
		CRUDHandler handler = null;
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(detailBean, connection);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public int deletePolicyDetails(PT_AGENT_POL_DTLS bean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(bean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public int updateChecklistDetails(PT_AGENT_CHKLST_STATUS detailBean) {
		Connection connection = null;
		CRUDHandler handler = null;
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(detailBean, connection);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public int deleteChecklistDetails(PT_AGENT_CHKLST_STATUS bean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(bean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public void pt_agent_tran_hdr_pre_update(PT_AGENT_TRAN_HDR headerBean) {
		ControlBean controlBean = CommonUtils.getControlBean();
		CommonUtils commonUtils = new CommonUtils();
		try {
			headerBean.setATH_UPD_DT(commonUtils.getCurrentDate());
			/*headerBean.setATH_UPD_UID(controlBean.getM_USER_ID());*/
			headerBean.setATH_UPD_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void pt_agent_tran_hdr_pre_insert(PT_AGENT_TRAN_HDR headerBean) {
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		String selectQuery = "SELECT PAG_ATH_SYS_ID.NEXTVAL FROM DUAL ";

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				String menuParam = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_1");
				if (rst.next()) {
					headerBean.setATH_SYS_ID(rst.getInt(1));
				}
				if ("U".equals(menuParam)) {
					if (headerBean.getATH_EFF_FM_DT() == null) {
						headerBean.setATH_EFF_FM_DT(headerBean.getATH_DATE());
					}
				}
				if (headerBean.getATH_APPRV_FLAG() == null) {
					headerBean.setATH_APPRV_FLAG("N");
				}
				headerBean.setATH_TYPE(menuParam);
				headerBean.setATH_CR_DT(commonUtils.getCurrentDate());
				//headerBean.setATH_CR_UID(controlBean.getM_USER_ID());
				System.out.println("GLOBAL.M_USER_ID          "+commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				headerBean.setATH_CR_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void pt_agent_tran_hdr_post_insert(PT_AGENT_TRAN_HDR headerBean)
			throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");
		SimpleDateFormat sdf = new SimpleDateFormat(PELConstants.dbDateFormat);

		if (headerBean.getATH_EFF_FM_DT() != null) {
			String date = sdf.format(headerBean.getATH_EFF_FM_DT());
			helper.helperP9ILPK_AGENCY_MGMT$INS_AGENT_CHKLST(headerBean
					.getATH_SYS_ID()
					+ "", menuParam, date);
		}
	}

	public void pt_agent_tran_hdr_when_create_record(
			PT_AGENT_TRAN_HDR headerBean) {
		CommonUtils commonUtils = new CommonUtils();
		try {
			headerBean.setATH_DATE(commonUtils.getCurrentDate());
			headerBean.setATH_EFF_FM_DT(commonUtils.getCurrentDate());
			headerBean.setATH_PRODN_TRANSFER_YN("N");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// SHANKAR -------------------- OVER
	public void pt_agent_tran_hdr_when_new_record_instance(PT044_A_COMPOSITE_ACTION compositeAction) {
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		PT_AGENT_TRAN_HDR_ACTION headerAction = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN();
		PT_AGENT_TRAN_HDR headerBean = headerAction.getPT_AGENT_TRAN_HDR_BEAN();
		String selectQuery = "SELECT DISTINCT 'X' FROM   PT_AGENT_CHKLST_STATUS  WHERE  ACS_ATH_SYS_ID = ? AND    ACS_APPR_STS IN ('NA','N') AND    NVL(ACS_MANDATORY_YN,'N') = 'Y'  ";
		Object[] values = { headerBean.getATH_SYS_ID() };
		String M_DUMMY = null;
		try {
			con = CommonUtils.getConnection();
			HtmlInputText TEMP_PARENT_CODE = new HtmlInputText();
			headerAction.setCOMP_ATH_PARENT_CODE(TEMP_PARENT_CODE);
			if (CommonUtils.nvl(
					CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), "A")
					.equals("A")) {
				// --[ BugId:PREMIAGDC-000051 Shankar Bodduluri 25-Feb-09
				// Commented for disable COMP_ATH_PARENT_CODE field, if record
				// is Approved

				// headerAction.getCOMP_ATH_PARENT_CODE().setDisabled(false);
			} else {
				headerAction.getCOMP_ATH_PARENT_CODE().setDisabled(true);
			}
			if (con != null) {
				/*if (headerAction.getCOMP_UI_M_BUT_APPROVE() == null) {
					headerAction
							.setCOMP_UI_M_BUT_APPROVE(new HtmlCommandButton());
				}
				if (headerAction.getCOMP_UI_M_BUT_PROCESS() == null) {
					headerAction
							.setCOMP_UI_M_BUT_PROCESS(new HtmlCommandButton());
				}*/
				if ("A".equals(CommonUtils.nvl(headerBean
						.getATH_APPRV_FLAG(), "N"))) {
					if (headerBean.getATH_AGENT_CODE() != null) {
						headerBean.setUI_M_APPRV_STATUS("Approved");
						headerAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);

						headerAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
						compositeAction.setDisableOnApprovalFlag(true);
					}
				} else {
					compositeAction.setDisableOnApprovalFlag(false);
					handler = new CRUDHandler();
					rst = handler.executeSelectStatement(selectQuery, con,
							values);
					if (rst.next()) {
						M_DUMMY = rst.getString(1);
					}
					if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
						headerAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(
								true);
					} else {
						headerAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(
								false);
					}
					headerAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					if ("N".equals(headerBean.getATH_APPRV_FLAG())) {
						// NOT NEEDED AS THEIR IS NO SUCH LOGIC IN
						// P9--VARUN[50663]
						/*
						 * HtmlCommandButton BUT_APPROVE = new
						 * HtmlCommandButton(); BUT_APPROVE.setDisabled(false);
						 * headerAction.setCOMP_UI_M_BUT_APPROVE(BUT_APPROVE);
						 * 
						 * HtmlCommandButton BUT_PROCESS = new
						 * HtmlCommandButton(); BUT_PROCESS.setDisabled(false);
						 * headerAction.setCOMP_UI_M_BUT_PROCESS(BUT_PROCESS);
						 */

						if (headerBean.getATH_AGENT_CODE() != null) {
							headerBean.setUI_M_APPRV_STATUS("Not Approved");
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
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// SHANKAR -- XXXXXX
	public void pt_agent_tran_hdr_when_new_block_instance(
			PT_AGENT_TRAN_HDR headerBean) {
		String fromStatus = null;
		if (headerBean.getROWID() != null) {
			fromStatus = "CHANGED";
		}
		if ("CHANGED".equals(fromStatus)) {
			headerBean.setATH_DATE(headerBean.getATH_DATE());
		}
	}

	public void insertAgentHeader(PT_AGENT_TRAN_HDR localHeaderBean) {
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			
			System.out.println(localHeaderBean.toString());
			
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				handler.executeInsert(localHeaderBean, connection);
				connection.commit();
			System.out.println("insertAgentHeader  Successfully ");
			
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PT_AGENT_TRAN_DTLS> loadAgentDetailRecord(String rowId){
		// Object[] values = { rowId };
				ArrayList<PT_AGENT_TRAN_DTLS> detailList = null;
				PT_AGENT_TRAN_DTLS detailBean = null;
				String selectQuery = "SELECT TBL.ROWID, TBL.* FROM PT_AGENT_TRAN_DTLS TBL WHERE EXISTS (SELECT 1 FROM PT_AGENT_TRAN_HDR TBL2 WHERE TBL2.ROWID = ? AND TBL.ATD_ATH_SYS_ID = TBL2.ATH_SYS_ID)";
		        //Bug id;85 Rajesh Kundala 27th Feb 2009 Added the below query 		
				
				
				/*commentted by nadhiya on 30.3.2016
				
				String query =" SELECT TBL.ROWID, TBL.*  FROM PT_AGENT_TRAN_DTLS TBL  WHERE TBL.ATD_ATH_SYS_ID= ? ";
				
				end*/
				
				//Bug id;85 Rajesh Kundala 27th Feb 2009 Added the below query  ends	
				
				/*added by nadhiya on 30.3.2016*/
				
				String query = "SELECT TBL.ROWID, TBL.*, CUST_NAME AGENT_NAME,(SELECT CUST_NAME FROM PM_CUSTOMER "+
						"WHERE CUST_CODE = ATD_OLD_PARENT_CODE) OLD_PARENT_NAME"+
						 " FROM PM_CUSTOMER, PT_AGENT_TRAN_DTLS TBL"+
						 " WHERE CUST_CODE = ATD_AGENT_CODE"+
						   " AND ATD_ATH_SYS_ID = ?";
				
				/*end*/
				
				CommonUtils commonUtils = new CommonUtils();
				PT044_A_COMPOSITE_ACTION compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
				//Bug id;85 Rajesh Kundala 27th Feb 2009 Added the sys Id Related Code
				int sysID = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
				System.out.println("Sys id is :"+sysID);
				Object[] value = { sysID };
				//Bug id;85 Rajesh Kundala 27th Feb 2009 Added the sys Id Related Code ends
				Connection con = null;
				CRUDHandler handler = null;
				ResultSet rst = null;
				try {
					con = CommonUtils.getConnection();
					if (con != null) {
						handler = new CRUDHandler();
						detailList = new ArrayList<PT_AGENT_TRAN_DTLS>();
						//Bug id;85 Rajesh Kundala 27th Feb 2009 parameters passed as 'query','value'
						rst  = handler.executeSelectStatement(query, con, value);
						while(rst.next()){
							detailBean = new PT_AGENT_TRAN_DTLS();
								detailBean.setROWID(rst.getString("ROWID"));
								detailBean.setATD_AGENT_CODE(rst.getString("ATD_AGENT_CODE"));
								detailBean.setATD_OLD_PARENT_CODE(rst.getString("ATD_OLD_PARENT_CODE"));
								detailBean.setATD_OLD_AGENCY_CODE(rst.getString("ATD_OLD_AGENCY_CODE"));
								detailBean.setATD_NEW_PARENT_CODE(rst.getString("ATD_NEW_PARENT_CODE"));
								detailBean.setATD_NEW_AGENCY_CODE(rst.getString("ATD_NEW_AGENCY_CODE"));
								detailBean.setATD_NEW_UNIT_CODE(rst.getString("ATD_NEW_UNIT_CODE"));
								detailBean.setATD_SYS_ID(rst.getInt("ATD_SYS_ID"));
								detailBean.setATD_ATH_SYS_ID(rst.getInt("ATD_ATH_SYS_ID"));
								detailBean.setATD_CR_UID(rst.getString("ATD_CR_UID"));
								detailBean.setATD_CR_DT(rst.getDate("ATD_CR_DT"));
								detailBean.setATD_UPD_UID(rst.getString("ATD_UPD_UID"));
								detailBean.setATD_UPD_DT(rst.getDate("ATD_UPD_DT"));
								detailBean.setATD_OLD_UNIT_CODE(rst.getString("ATD_OLD_UNIT_CODE"));

								/*added by nadhiya on 30.3.2016*/
								detailBean.setATD_AGENT_NAME(rst.getString("AGENT_NAME"));
								detailBean.setATD_OLD_PARENT_NAME(rst.getString("OLD_PARENT_NAME"));
								
								/*end*/
								
								pt_agent_tran_detail_post_query(detailBean);
								
							detailList.add(detailBean);
						}
						
		// Added By Amit Gupta for disabling the approved record in details block
						/*
						 * PT044_A_COMPOSITE_ACTION compositeAction =
						 * (PT044_A_COMPOSITE_ACTION)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PT044_A_COMPOSITE_ACTION");
						 * if("A".equalsIgnoreCase(compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_APPRV_FLAG())){
						 * if(!"".equalsIgnoreCase(compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_AGENT_CODE())){
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompAtdAgentCodeDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompUiMAgentNameDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompAtdOldParentCodeDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompUiMOldParentNameDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompAtdOldAgencyCodeDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompAtdNewParentCodeDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompUiMAtdNewAgencyNameDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompAtdNewAgencyCodeDisabled(true);
						 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setCompUiMOldAgencyNameDisabled(true); } }
						 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT044_A_COMPOSITE_ACTION",
						 * compositeAction);
						 */
					}
				} catch (DBException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Detail List is :"+detailList.size());
				return detailList;
				
			}

	public void pt_agent_tran_detail_pre_insert(PT_AGENT_TRAN_DTLS detailBean) {
		String selectQuery = "SELECT PAG_ATD_SYS_ID.NEXTVAL FROM DUAL ";
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if (rst.next()) {
					detailBean.setATD_SYS_ID(rst.getInt(1));
				}
				detailBean.setATD_CR_DT(commonUtils.getCurrentDate());
				/*detailBean.setATD_CR_UID(controlBean.getM_USER_ID());*/
				System.out.println("GLOBAL.M_USER_ID           "+commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				detailBean.setATD_CR_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pt_agent_tran_detail_pre_update(PT_AGENT_TRAN_DTLS detailBean) {
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		try {
			detailBean.setATD_UPD_DT(commonUtils.getCurrentDate());
			/*detailBean.setATD_UPD_UID(controlBean.getM_USER_ID());*/
			detailBean.setATD_UPD_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void pt_agent_tran_detail_post_query(PT_AGENT_TRAN_DTLS detailBean) {
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ArrayList<String> listValue = null;
		DBProcedures proceduresCall = new DBProcedures();
		String selectQuery = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ? AND    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002') AND    CUST_FRZ_FLAG = 'N'";

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				String menuParam = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_1");
				handler = new CRUDHandler();
				Object[] values = { detailBean.getATD_AGENT_CODE() };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if (rst.next()) {
					detailBean.setUI_M_AGENT_NAME(rst.getString("CUST_NAME"));
				}
				Object[] values1 = { detailBean.getATD_OLD_PARENT_CODE() };
				rst = handler.executeSelectStatement(selectQuery, con, values1);
				if (rst.next()) {
					detailBean.setUI_M_OLD_PARENT_NAME(rst
							.getString("CUST_NAME"));
				}
				String P_LANG_CODE = CommonUtils.getControlBean()
						.getM_LANG_CODE();

				String ATD_OLD_AGENCY_CODE = detailBean
						.getATD_OLD_AGENCY_CODE();
				if (ATD_OLD_AGENCY_CODE != null
						&& !ATD_OLD_AGENCY_CODE.trim().isEmpty()) {
					listValue = proceduresCall.callL_VAL_CUST(detailBean
							.getATD_OLD_AGENCY_CODE(), "N", "N", P_LANG_CODE,
							null);
					if (listValue != null && listValue.size() != 0) {
						detailBean.setUI_M_OLD_AGENCY_NAME(listValue.get(0));
					}
				}

				if (detailBean.getATD_NEW_PARENT_CODE() != null) {
					Object[] values2 = { detailBean.getATD_NEW_PARENT_CODE() };
					rst = handler.executeSelectStatement(selectQuery, con,
							values2);
					if (rst.next()) {
						detailBean.setUI_M_ATD_NEW_PARENT_NAME(rst
								.getString("CUST_NAME"));
					}
				}
				listValue = proceduresCall.callL_VAL_CUST(detailBean
						.getATD_NEW_AGENCY_CODE(), "N", "N", P_LANG_CODE, null);
				if (listValue != null && listValue.size() != 0) {
					detailBean.setUI_M_ATD_NEW_AGENCY_NAME(listValue.get(0));
				}
				if (("M".equals(menuParam))
						&& detailBean.getATD_NEW_UNIT_CODE() != null) {
					listValue = proceduresCall.P_VAL_CODES_PROC_CALL(
							"UNITCODE", detailBean.getATD_NEW_UNIT_CODE(), "N",
							"N");
					detailBean.setUI_M_NEW_UNIT_DESC(listValue.get(0));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void loaddefalutDetailValues(PT_AGENT_TRAN_DTLS localBean) {
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		CommonUtils commonUtils = new CommonUtils();
		compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		int headerSysiD = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
		localBean.setATD_ATH_SYS_ID(headerSysiD);
	}

	public void loaddefalutDetailValues(PT_AGENT_POL_DTLS localBean) {
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		CommonUtils commonUtils = new CommonUtils();
		compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		int headerSysiD = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
		localBean.setAPD_ATH_SYS_ID(headerSysiD);
		localBean.setAPD_FLAG("Y");
	}

	public void loaddefalutDetailValues(PT_AGENT_CHKLST_STATUS localBean) {
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		CommonUtils commonUtils = new CommonUtils();
		compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		int headerSysiD = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
		localBean.setACS_ATH_SYS_ID(headerSysiD);
	}

	public ArrayList<PT_AGENT_POL_DTLS> loadPolicyDetail(String rowId) {
		
		ArrayList<PT_AGENT_POL_DTLS> detailList = null;
		PT_AGENT_POL_DTLS detailBean = null;
		//String selectQuery = "SELECT TBL.ROWID, TBL.* FROM PT_AGENT_POL_DTLS TBL WHERE EXISTS (SELECT 1 FROM PT_AGENT_TRAN_HDR TBL2 WHERE TBL.APD_ATH_SYS_ID = ?)";
		String selectQuery = " SELECT * FROM (SELECT TBL.ROWID, TBL.* FROM PT_AGENT_POL_DTLS TBL WHERE EXISTS "
		+ "	(SELECT 1 FROM PT_AGENT_TRAN_HDR TBL2 WHERE ATH_SYS_ID = ? )) WHERE ROWID IN "
		+ " (SELECT MAX(ROWID) FROM PT_AGENT_POL_DTLS  GROUP BY APD_POL_SYS_ID)  AND  APD_ATH_SYS_ID = ? " ;
		
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		CommonUtils commonUtils = new CommonUtils();
		PT044_A_COMPOSITE_ACTION compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		int sysID = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
		System.out.println("Sys id is :"+sysID);
		Object[] values = { sysID,sysID };

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				detailList = new ArrayList<PT_AGENT_POL_DTLS>();
				rst = handler.executeSelectStatement(selectQuery, con, values);
				while (rst.next()) {
					detailBean = new PT_AGENT_POL_DTLS();
					detailBean.setROWID(rst.getString("ROWID"));
					System.out.println("row id in policy detail         :"+rst.getString("ROWID"));
					
					detailBean.setAPD_POL_DS_TYPE(rst
							.getString("APD_POL_DS_TYPE"));
					detailBean.setAPD_POBH_COMM_CODE(rst
							.getString("APD_POBH_COMM_CODE"));
					detailBean.setAPD_POL_END_NO(rst
							.getString("APD_POL_END_NO"));
					detailBean.setAPD_FLAG(rst.getString("APD_FLAG"));
					detailBean.setAPD_SYS_ID(rst.getInt("APD_SYS_ID"));
					detailBean.setAPD_ATH_SYS_ID(rst.getInt("APD_ATH_SYS_ID"));
					detailBean.setAPD_POL_SYS_ID(rst.getInt("APD_POL_SYS_ID"));
					detailBean.setAPD_NUM_GEN_FLAG(rst
							.getString("APD_NUM_GEN_FLAG"));
					detailBean
							.setAPD_POBH_SYS_ID(rst.getInt("APD_POBH_SYS_ID"));
					detailBean.setAPD_POL_END_NO_IDX(rst
							.getInt("APD_POL_END_NO_IDX"));
					detailBean.setAPD_POL_END_CODE(rst
							.getString("APD_POL_END_CODE"));
					detailBean.setAPD_CR_UID(rst.getString("APD_CR_UID"));
					detailBean.setAPD_CR_DT(rst.getDate("APD_CR_DT"));
					detailBean.setAPD_UPD_UID(rst.getString("APD_UPD_UID"));
					detailBean.setAPD_UPD_DT(rst.getDate("APD_UPD_DT"));

					
					/*added by nadhiya on 30.3.2016*/
					detailBean.setAPD_PRINT_YN("N");
					System.out.println("detailBean.getM_PRINT_YN     "+detailBean.getAPD_PRINT_YN());
					/*end*/
					
					pt_agent_pol_dtls_post_query(detailBean);

					detailList.add(detailBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailList;
	}

	public ArrayList<PT_AGENT_CHKLST_STATUS> loadCheckListDetail(String rowId) {
		Object[] values = { rowId };
		ArrayList<PT_AGENT_CHKLST_STATUS> detailList = null;
		PT_AGENT_CHKLST_STATUS detailBean = null;
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		String selectQuery = "SELECT TBL.ROWID, TBL.* FROM PT_AGENT_CHKLST_STATUS TBL WHERE EXISTS (SELECT 1 FROM PT_AGENT_TRAN_HDR TBL2 WHERE TBL2.ROWID = ? AND TBL.ACS_ATH_SYS_ID = TBL2.ATH_SYS_ID)";
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				detailList  = new ArrayList<PT_AGENT_CHKLST_STATUS>();
				rst = handler.executeSelectStatement(selectQuery, con, values);
				while (rst.next()) {
					detailBean = new PT_AGENT_CHKLST_STATUS();

					detailBean.setROWID(rst.getString("ROWID"));
					detailBean.setACS_SR_NO(rst.getDouble("ACS_SR_NO"));
					detailBean.setACS_TODO_LIST_ITEM(rst
							.getString("ACS_TODO_LIST_ITEM"));
					detailBean.setACS_MANDATORY_YN(rst
							.getString("ACS_MANDATORY_YN"));
					detailBean.setACS_APPR_STS(rst.getString("ACS_APPR_STS"));
					detailBean.setACS_REMARKS(rst.getString("ACS_REMARKS"));
					detailBean.setACS_SYS_ID(rst.getInt("ACS_SYS_ID"));
					detailBean.setACS_ATH_SYS_ID(rst.getInt("ACS_ATH_SYS_ID"));
					detailBean.setACS_CR_DT(rst.getDate("ACS_CR_DT"));
					detailBean.setACS_CR_UID(rst.getString("ACS_CR_UID"));
					detailBean.setACS_UPD_DT(rst.getDate("ACS_UPD_DT"));
					detailBean.setACS_UPD_UID(rst.getString("ACS_UPD_UID"));

					detailList.add(detailBean);
					
				PT_AGENT_CHKLST_STATUS PT_AGENT_CHKLST_STATUS_BEAN = null;
				/*Iterator<PT_AGENT_CHKLST_STATUS> it = detailList.iterator();
				while(it.hasNext()){
					detailBean = it.next();
					detailBean.setRowSelected(false);
				}
				
				if (detailList.size()>0){					
					compositeAction.getPT_AGENT_CHKLST_STATUS().setPT_AGENT_CHKLST_STATUS(detailList.get(0));
					compositeAction.getPT_AGENT_CHKLST_STATUS().getPT_AGENT_CHKLST_STATUS().setRowSelected(true);
				}*/
			}
			}
		}
		 catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailList;
	}

	public void pt_agent_pol_dtls_pre_insert(PT_AGENT_POL_DTLS policyDetail) {
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		String selectQuery = "SELECT PAG_APD_SYS_ID.NEXTVAL FROM DUAL ";
		ResultSet rst = null;
		Connection con = null;
		CRUDHandler handler = null;

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if (rst.next()) {
					policyDetail.setAPD_SYS_ID(rst.getInt(1));
				}
				policyDetail.setAPD_CR_DT(commonUtils.getCurrentDate());
				/*policyDetail.setAPD_CR_UID(controlBean.getM_USER_ID());*/
				policyDetail.setAPD_CR_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pt_agent_pol_dtls_pre_update(PT_AGENT_POL_DTLS policyDetail) {
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		try {
			policyDetail.setAPD_UPD_DT(commonUtils.getCurrentDate());
			/*policyDetail.setAPD_UPD_UID(controlBean.getM_USER_ID());*/
			policyDetail.setAPD_UPD_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void pt_agent_pol_dtls_post_query(PT_AGENT_POL_DTLS policyDetail) {
		String selectQuery = " SELECT POL_NO,POL_START_DT, POL_CONT_CODE,POL_ASSURED_NAME FROM PT_IL_POLICY WHERE  POL_SYS_ID = ?";
		ResultSet rst = null;
		CRUDHandler handler = null;
		Connection con = null;
		String selectQuery1 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				Object[] values = { policyDetail.getAPD_POL_SYS_ID() };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if (rst.next()) {
					policyDetail.setUI_M_POL_NO(rst.getString("POL_NO"));
					policyDetail.setUI_M_POL_START_DT(rst
							.getDate("POL_START_DT"));
					policyDetail.setUI_M_POL_CONT_CODE(rst
							.getString("POL_CONT_CODE"));
					policyDetail.setUI_M_POL_ASSURED_NAME(rst
							.getString("POL_ASSURED_NAME"));
				}
				Object[] values1 = { policyDetail.getAPD_POBH_COMM_CODE() };
				rst = handler
						.executeSelectStatement(selectQuery1, con, values1);
				if (rst.next()) {
					policyDetail.setUI_M_APD_CODE_DESC(rst
							.getString("BCH_DESC"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pt_agent_chklst_pre_insert(PT_AGENT_CHKLST_STATUS chkBean) {
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		String selectQuery = "SELECT PAG_ACS_SYS_ID.NEXTVAL FROM DUAL ";
		ResultSet rst = null;
		Connection con = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if (rst.next()) {
					chkBean.setACS_SYS_ID(rst.getInt(1));
				}
				chkBean.setACS_CR_DT(commonUtils.getCurrentDate());
				/*chkBean.setACS_CR_UID(controlBean.getM_USER_ID());*/
				chkBean.setACS_CR_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pt_agent_chklst_pre_update(PT_AGENT_CHKLST_STATUS chekBean) {
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		try {
			chekBean.setACS_UPD_DT(commonUtils.getCurrentDate());
			/*chekBean.setACS_UPD_UID(controlBean.getM_USER_ID());*/
			chekBean.setACS_UPD_UID(commonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getAgentCodeLov(Object string) {
		ArrayList<PT_AGENT_TRAN_HDR> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		String selectQuery = null;
		String Query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' AND PS_CODE= 'BROKER'";
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String value = null;

		ResultSet resultSet = null;

		if ("R".equals(menuParam)) {
			selectQuery = "SELECT CUST_CODE,CUST_NAME  FROM   PM_CUSTOMER  WHERE CUST_STATUS = 'T'";
			if ("*".equals(string)) {
				values = new Object[0];
			} else {
				/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
				 * 
				 * selectQuery = selectQuery + " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?)";*/
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
				selectQuery = selectQuery + " AND (UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?))";
				/*end*/
				values = new Object[] { string + "%", string + "%" };
			}

		} else {
			selectQuery = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ({0}))AND CUST_FRZ_FLAG ='N' ";
			if ("*".equals(string)) {
				selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
				values = new Object[0];
			} else {
				/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
				 * 
				 * 
				 * selectQuery = selectQuery
						+ " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?) ORDER BY 1 ASC";*/
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
				selectQuery = selectQuery
						+ " AND (UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?)) ORDER BY 1 ASC";
				/*end*/
				values = new Object[] { string + "%", string + "%" };
			}
		}
System.out.println("selectQuery        "+selectQuery);
		PT_AGENT_TRAN_HDR classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection);
			while (resultSet.next()) {
				value = resultSet.getString(1);
			}
			selectQuery = selectQuery.replace("{0}", value);
			resultSet = handler.executeSelectStatement(selectQuery, connection, values);
			custClassList = new ArrayList<PT_AGENT_TRAN_HDR>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_HDR();
				classBean.setATH_AGENT_CODE(resultSet.getString("CUST_CODE"));
				classBean.setUI_M_ATH_AGENT_NAME(resultSet
						.getString("CUST_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getParentCodeLov(Object string) {
		String selectQuery = " SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME FROM " +
			"PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS " +
			"WHERE CCLAS_TYPE IN ({0}))AND CUST_FRZ_FLAG = ? AND CUST_AGENT_RANK_CODE " +
			"IN (SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' AND " +
			"PC_VALUE < 4) AND ROWNUM<="+ PELConstants.suggetionRecordSize + " ";
		String Query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' AND PS_CODE= 'BROKER'";
		ArrayList<PT_AGENT_TRAN_HDR> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String CUST_FRZ_FLAG = "N";
		String value = null;
		if ("*".equals(string)) {
			selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
			values = new Object[]{CUST_FRZ_FLAG};
		} else {
			values = new Object[4];
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * selectQuery = selectQuery + " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ? OR CUST_BL_NAME LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = CUST_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
			values[3] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_HDR classBean = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection);
			while (resultSet.next()) {
				value = resultSet.getString(1);
			}
			selectQuery = selectQuery.replace("{0}", value);
			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_HDR>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_HDR();
				classBean.setATH_PARENT_CODE(resultSet.getString("CUST_CODE"));
				classBean.setUI_M_ATH_PARENT_NAME(resultSet
						.getString("CUST_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getTeriminationLov(Object string) {
		String selectQuery = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'AGTERMIN_TYP' AND PC_FRZ_FLAG = ? AND PC_CLASS_CODE IS NULL";
		ArrayList<PT_AGENT_TRAN_HDR> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String PC_FRZ_FLAG = "N";
		if ("*".equals(string)) {
			selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = PC_FRZ_FLAG;
		} else {
			values = new Object[4];
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * 
			 * selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ? OR PC_BL_DESC LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?) OR UPPER(PC_BL_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = PC_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
			values[3] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_HDR classBean = null;

		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_HDR>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_HDR();
				classBean.setATH_TERMINATION_TYPE(resultSet
						.getString("PC_CODE"));
				classBean.setUI_M_ATH_TERMINATION_DESC(resultSet
						.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getRankCodeLov(Object string) {
		String selectQuery = "SELECT PC_CODE, PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' AND PC_CLASS_CODE IS NULL AND PC_FRZ_FLAG = ? ";
		ArrayList<PT_AGENT_TRAN_HDR> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String PC_FRZ_FLAG = "N";
		if ("*".equals(string)) {
			selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = PC_FRZ_FLAG;
		} else {
			values = new Object[3];
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = PC_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_HDR classBean = null;

		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_HDR>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_HDR();
				classBean.setATH_AGENT_NEW_RANK_CODE(resultSet
						.getString("PC_CODE"));
				classBean.setUI_M_AGENT_NEW_RANK_DESC(resultSet
						.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getNewAgentCodeLov(Object string) {
		String selectQuery = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER WHERE ROWNUM < ?";
		ArrayList<PT_AGENT_TRAN_HDR> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		int size = PELConstants.suggetionRecordSize;
		if ("*".equals(string)) {
			selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = size;
		} else {
			values = new Object[3];
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * 
			 * selectQuery = selectQuery + " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = size;
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_HDR classBean = null;

		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_HDR>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_HDR();
				classBean.setATH_NEW_AGENT_CODE(resultSet
						.getString("CUST_CODE"));
				classBean.setUI_M_ATH_NEW_AGENT_NAME(resultSet
						.getString("CUST_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	// SHANKAR ----------------
	public ArrayList<PT_AGENT_TRAN_DTLS> getNewParentLov(Object string) {
		String selectQuery = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE " +
			"CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ({0})) " +
			"AND CUST_FRZ_FLAG =? AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE FROM " +
			"PM_CODES WHERE PC_TYPE = 'AGNRANK' AND PC_VALUE < 4)";
		String Query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' AND PS_CODE= 'BROKER'";
		ArrayList<PT_AGENT_TRAN_DTLS> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String CUST_FRZ_FLAG = "N";
		String value = null;
		if ("*".equals(string)) {
			selectQuery = selectQuery + " " + "ORDER BY 1 ASC";
			values = new Object[]{ CUST_FRZ_FLAG};

		} else {
			values = new Object[3];
			selectQuery = selectQuery + " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?) ORDER BY 1 ASC";
			values[0] = CUST_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_DTLS classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection);
			while (resultSet.next()) {
				value = resultSet.getString(1);
			}
			selectQuery = selectQuery.replace("{0}", value);
			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_DTLS>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_DTLS();
				classBean.setATD_NEW_PARENT_CODE(resultSet
						.getString("CUST_CODE"));
				classBean.setUI_M_ATD_NEW_PARENT_NAME(resultSet
						.getString("CUST_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}

	public ArrayList<PT_AGENT_TRAN_DTLS> getNewAgencyLov(Object string) {
		String selectQuery = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE " +
			"PM_CUSTOMER.CUST_FRZ_FLAG = ? AND ROWNUM < 25";
		ArrayList<PT_AGENT_TRAN_DTLS> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String CUST_FRZ_FLAG = "N";
		// Removed ORDER BY 1 - Amit Gupta
		if ("*".equals(string)) {
			selectQuery = selectQuery;
			values = new Object[1];
			values[0] = CUST_FRZ_FLAG;

		} else {
			values = new Object[4];
			selectQuery = selectQuery + " AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?)";
			values[0] = CUST_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_DTLS classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_DTLS>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_DTLS();
				classBean.setATD_NEW_AGENCY_CODE(resultSet
						.getString("CUST_CODE"));
				classBean.setUI_M_ATD_NEW_AGENCY_NAME(resultSet
						.getString("CUST_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}
	
	public ArrayList<PT_AGENT_TRAN_DTLS> getNewUnitLov(Object string) {
		String selectQuery = "SELECT PC_CODE,PC_DESC FROM PM_CODES " +
			"WHERE PC_TYPE = 'UNITCODE' AND PC_FRZ_FLAG = ? AND PC_CLASS_CODE IS NULL and ROWNUM < 25";
		ArrayList<PT_AGENT_TRAN_DTLS> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String CUST_FRZ_FLAG = "N";
		// Removed ORDER BY 1 - Amit Gupta
		if ("*".equals(string)) {
			selectQuery = selectQuery;
			values = new Object[1];
			values[0] = CUST_FRZ_FLAG;

		} else {
			values = new Object[3];
			selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?)";
			values[0] = CUST_FRZ_FLAG;
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_AGENT_TRAN_DTLS classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,
					values);
			custClassList = new ArrayList<PT_AGENT_TRAN_DTLS>();
			while (resultSet.next()) {
				classBean = new PT_AGENT_TRAN_DTLS();
				classBean.setATD_NEW_UNIT_CODE(resultSet
						.getString("PC_CODE"));
				classBean.setUI_M_NEW_UNIT_DESC(resultSet
						.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custClassList;
	}


	public DUMMY dummyValues() {
		DUMMY dummy = new DUMMY();
		dummy.setPT_AGENT_TRAN_HDR_CF("N");
		dummy.setPT_AGENT_TRAN_DTLS_CF("P");
		dummy.setPT_AGENT_POL_DTLS_CF("P");
		dummy.setPT_AGENT_CHKLST_STATUS_CF("P");
		return dummy;
	}

	public PT044_A_COMPOSITE_ACTION getCompositeAction() {
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		CommonUtils commonUtils = new CommonUtils();
		compositeAction = (PT044_A_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		if (compositeAction == null) {
			compositeAction = new PT044_A_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION",
					compositeAction);
		}
		return compositeAction;
	}
	
	public void executeSelectStatement (PT044_A_COMPOSITE_ACTION compositeAction) throws Exception { 

		PT_AGENT_TRAN_HDR headerBean = null;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT TBL.ROWID,TBL.* FROM PT_AGENT_TRAN_HDR TBL  WHERE ROWID = ?";
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con, 
						new Object[]{compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getROWID()});
				headerBean = new PT_AGENT_TRAN_HDR();
				while (rst.next()) {
					headerBean.setROWID(rst.getString("ROWID"));
					headerBean.setATH_AGENT_CODE(rst
							.getString("ATH_AGENT_CODE"));
					headerBean.setATH_PARENT_CODE(rst
							.getString("ATH_PARENT_CODE"));
					headerBean.setATH_DATE(rst.getDate("ATH_DATE"));
					headerBean.setATH_EFF_FM_DT(rst.getDate("ATH_EFF_FM_DT"));
					headerBean.setATH_TERMINATION_TYPE(rst
							.getString("ATH_TERMINATION_TYPE"));
					headerBean.setATH_AGENT_NEW_RANK_CODE(rst
							.getString("ATH_AGENT_NEW_RANK_CODE"));
					headerBean.setATH_REVIEW1_DT(rst.getDate("ATH_REVIEW1_DT"));
					headerBean.setATH_REVIEW2_DT(rst.getDate("ATH_REVIEW2_DT"));
					headerBean.setATH_REVIEW3_DT(rst.getDate("ATH_REVIEW3_DT"));
					headerBean.setATH_REVIEW4_DT(rst.getDate("ATH_REVIEW4_DT"));
					headerBean.setATH_NEW_AGENT_CODE(rst
							.getString("ATH_NEW_AGENT_CODE"));
					headerBean.setATH_PRODN_TRANSFER_YN(rst
							.getString("ATH_PRODN_TRANSFER_YN"));
					headerBean.setATH_SYS_ID(rst.getInt("ATH_SYS_ID"));
					headerBean.setATH_AGENT_RANK_CODE(rst
							.getString("ATH_AGENT_RANK_CODE"));
					headerBean.setATH_APPRV_FLAG(rst
							.getString("ATH_APPRV_FLAG"));
					headerBean.setATH_TYPE(rst.getString("ATH_TYPE"));
					headerBean.setATH_CR_DT(rst.getDate("ATH_CR_DT"));
					headerBean.setATH_CR_UID(rst.getString("ATH_CR_UID"));
					headerBean.setATH_UPD_DT(rst.getDate("ATH_UPD_DT"));
					headerBean.setATH_UPD_UID(rst.getString("ATH_UPD_UID"));
					headerBean.setATH_POL_SYS_ID(rst.getInt("ATH_POL_SYS_ID"));
					headerBean.setATH_FLEX_01(rst.getString("ATH_FLEX_01"));
					headerBean.setATH_FLEX_02(rst.getString("ATH_FLEX_02"));
					headerBean.setATH_FLEX_03(rst.getString("ATH_FLEX_03"));
					headerBean.setATH_FLEX_04(rst.getString("ATH_FLEX_04"));
					headerBean.setATH_FLEX_05(rst.getString("ATH_FLEX_05"));
					
					/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676*/
					headerBean.setATH_AGENT_NEW_CLASS_CODE(rst.getString("ATH_AGENT_NEW_CLASS_CODE"));
					/*end*/
				}
				compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().setPT_AGENT_TRAN_HDR_BEAN(headerBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

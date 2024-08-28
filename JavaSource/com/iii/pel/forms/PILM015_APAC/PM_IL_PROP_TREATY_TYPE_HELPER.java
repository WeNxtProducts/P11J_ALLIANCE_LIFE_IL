package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_PROP_TREATY_TYPE_HELPER {

	/**
	 * WHEN-VALIDATE-ITEM
	 * 
	 * @param compositeAction
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_ptt_treaty_type_when_validate_item(
			PM_IL_PROP_TREATY treatyMasterValueBean,
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean) throws SQLException,
			Exception {
		try{
			DBProcedures procedures = new DBProcedures();
			String pttTreatyType = treatyTypeValueBean.getPTT_TREATY_TYPE();
			String ptClassCode = treatyMasterValueBean.getPT_CLASS_CODE();
			ArrayList<String> treatyDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							pttTreatyType, "N", "E", ptClassCode);
			if (treatyDescList != null && treatyDescList.size() != 0) {
				treatyTypeValueBean.setUI_M_TREATY_DESC(treatyDescList.get(0));
			}
			String pttLinkTreatyCode = treatyTypeValueBean
					.getPTT_LINK_TREATY_CODE();
			if (pttLinkTreatyCode == null) {
				treatyTypeValueBean.setPTT_LINK_TREATY_CODE(pttTreatyType);
			}
			treatyTypeValueBean.setPTT_LINK_TREATY_CODE(pttLinkTreatyCode);
			ArrayList<String> linkTreatyDeacList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							pttLinkTreatyCode, "N", "E", ptClassCode);
			if (linkTreatyDeacList != null && linkTreatyDeacList.size() != 0) {
				treatyTypeValueBean.setUI_M_LINK_TREATY_DESC(linkTreatyDeacList
						.get(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * WHEN-ITEM-INSTANCE TO BE CALLED ON ONFOCUSGAIN
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_ptt_accounts_submit_period_when_new_item_instance(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		try{
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean = compositeAction
					.getPM_IL_PROP_TREATY_TYPE_ACTION()
					.getPM_IL_PROP_TREATY_TYPE_BEAN();
			Double srNo = treatyTypeValueBean.getPTT_SRNO();
			if (srNo != 1) {
				treatyTypeValueBean.setPTT_ACCOUNTS_SUBMIT_PERIOD(CommonUtils
						.getGlobalVariable("GLOBAL.ACCNT_PERIOD"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * When-Validate-Item
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_ptt_accounts_submit_period_when_validate_item(
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean) throws Exception {
		try{
			Double pttSrNo = treatyTypeValueBean.getPTT_SRNO();
			String pttAccountsSubmitPeriod = treatyTypeValueBean
					.getPTT_ACCOUNTS_SUBMIT_PERIOD();
			if (treatyTypeValueBean.getPTT_SRNO() != null && pttSrNo == 1) {
				CommonUtils.setGlobalVariable("GLOBAL.ACCNT_PERIOD",
						pttAccountsSubmitPeriod);
			} else {
				treatyTypeValueBean.setPTT_ACCOUNTS_SUBMIT_PERIOD(CommonUtils
						.getGlobalVariable("GLOBAL.ACCNT_PERIOD"));
			}
			treatyTypeValueBean
					.setPTT_ACCOUNTS_SUBMIT_PERIOD(pttAccountsSubmitPeriod);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * WHEN-VALIDATE-ITEM FOR PTT_LINK_TREATY_CODE SETS DESCRIPTION FOR lINK
	 * CODE AND ENBLES/DISABLES PART_CUST BUTTON
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_ptt_link_treaty_code_when_validate_item(
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean,
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		try{
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		String linkTreatyCode = treatyTypeValueBean.getPTT_LINK_TREATY_CODE();
		String treatytype = treatyTypeValueBean.getPTT_TREATY_TYPE();
		try {
			ArrayList<String> linkTreatyCodeDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							linkTreatyCode,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_E_FLAG,
							treatytype);
			if (linkTreatyCodeDescList != null
					&& linkTreatyCodeDescList.size() != 0) {
				treatyTypeValueBean
						.setUI_M_LINK_TREATY_DESC(linkTreatyCodeDescList.get(0));
			}
			HtmlCommandButton cbDish = new HtmlCommandButton();
			cbDish.setDisabled(true);
			HtmlCommandButton cbEnab = new HtmlCommandButton();
			cbEnab.setDisabled(true);
			if (!linkTreatyCode.equals(treatytype)) {
				treatyTypeActionBean.setCOMP_BUTTON_PART_CUST(cbDish);
			} else {
				treatyTypeActionBean.setCOMP_BUTTON_PART_CUST(cbEnab);
			}
		int rowIndex = treatyTypeActionBean.getDataTable().getRowIndex();
		PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = treatyTypeActionBean
				.getDataTableList().get(rowIndex);
		pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE(linkTreatyCode);
		} catch (SQLException e) {
			throw new Exception(new CommonUtils()
					.getErrorMessageForException(e));
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * WHEN-VALIDATE-ITEM RERENDERS COMP_PTC_SUB_STD_TARIFF
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_ptt_srno_when_validate_item(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		try{
			PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
					.getPM_IL_PROP_TREATY_TYPE_ACTION();
			PM_IL_PROP_TREATY_COVER_ACTION treatyCoverActionBean = compositeAction
					.getPM_IL_PROP_TREATY_COVER_ACTION();
			Double srNo = treatyTypeActionBean.getPM_IL_PROP_TREATY_TYPE_BEAN()
					.getPTT_SRNO();
			if (srNo.doubleValue() != 1) {
				treatyCoverActionBean.getCOMP_PTC_SUB_STD_TARIFF()
						.setDisabled(true);
			} else if (srNo == 1) {
				treatyCoverActionBean.getCOMP_PTC_SUB_STD_TARIFF().setDisabled(
						false);
			}
			int rowIndex = treatyTypeActionBean.getDataTable().getRowIndex();
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = treatyTypeActionBean
					.getDataTableList().get(rowIndex);
			pm_il_prop_treaty_type.setPTT_SRNO(srNo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * PRE-RECORD RERENDER COMP_BUTTON_PART_CUST
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_pre_record(
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean,
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		try{
			PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
					.getPM_IL_PROP_TREATY_TYPE_ACTION();
			String pttLinkTreatyCode = treatyTypeValueBean
					.getPTT_LINK_TREATY_CODE();
			String pttTreatyType = treatyTypeValueBean.getPTT_TREATY_TYPE();
			if (pttLinkTreatyCode != null && pttTreatyType != null) {
				HtmlCommandButton COMP_BUTTON_PART_CUST = new HtmlCommandButton();
				if (!pttLinkTreatyCode.equals(pttTreatyType)) {
					COMP_BUTTON_PART_CUST.setDisabled(true);
					treatyTypeActionBean.setCOMP_BUTTON_PART_CUST(COMP_BUTTON_PART_CUST);
				} else {
					COMP_BUTTON_PART_CUST.setDisabled(false);
					treatyTypeActionBean.setCOMP_BUTTON_PART_CUST(COMP_BUTTON_PART_CUST);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * PRE-INSERT GENERATES SYS ID AND SETS CR_UID,CR_UDT
	 * 
	 * @param compositeAction
	 * @return
	 * @throws Exception 
	 * @throws SQLException
	 * @throws Exception
	 */
	public Double pilm015_apac_pm_il_prop_treaty_type_pre_insert(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION();
		PM_IL_PROP_TREATY_TYPE treatyTypeValueBean = treatyTypeActionBean
				.getPM_IL_PROP_TREATY_TYPE_BEAN();
		ResultSet resultSet = null;
		Double pilPttSysId = null;
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection connection = CommonUtils.getConnection();
			String sql_vembu1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_PIL_PTT_SYS_ID;
			Object[] object = {};
			resultSet = handler.executeSelectStatement(sql_vembu1, connection,
					object);
			if (resultSet.next()) {
				pilPttSysId = resultSet.getDouble(0);
			}
			treatyTypeValueBean.setPTT_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			treatyTypeValueBean.setPTT_CR_DT(commonUtils.getCurrentDate());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pilPttSysId;
	}

	/**
	 * PRE-BLOCK FORM FAILURE NOT HANDLED THTS WHY COMMENTED
	 */
	/*
	 * public static void pilm015_apac-pm_il_prop_treaty_type--pre-block()
	 * throws SQLException,Exception { Connection vembu_conn =
	 * SwisSqlConnection.getInstance().getConnection(); try { final dbms_output
	 * dbms_output1=new dbms_output(); if(FORM_FAILURE) {
	 * :GLOBAL.M_FAILURE="TRUE"; } :CTRL.M_DELETE_MSG_FLAG="Y"; }catch(Exception
	 * e) { e.printStackTrace(); throw e; } finally { if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 */
	/**
	 * POST-QUERY RERENDERS UI_M_TREATY_DESC,UI_M_LINK_TREATY_DESC SETS
	 * GLOBAL.ACCNT_PERIOD
	 * @throws Exception 
	 */
	public void pilm015_apac_pm_il_prop_treaty_type_post_query(
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean,
			PM_IL_PROP_TREATY treatyValueBean) throws Exception  {
		try{
			DBProcedures procedures = new DBProcedures();
			ArrayList<String> treatyDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							treatyTypeValueBean.getPTT_TREATY_TYPE(),
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							treatyValueBean.getPT_CLASS_CODE());
			if (treatyDescList != null && treatyDescList.size() != 0) {
				treatyTypeValueBean.setUI_M_TREATY_DESC(treatyDescList.get(0));
			}
			ArrayList<String> linkTreatyDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							treatyTypeValueBean.getPTT_LINK_TREATY_CODE(),
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							treatyValueBean.getPT_CLASS_CODE());
			if (linkTreatyDescList != null && linkTreatyDescList.size() != 0) {
				treatyTypeValueBean.setUI_M_LINK_TREATY_DESC(linkTreatyDescList
						.get(0));
			}
			if (treatyTypeValueBean.getPTT_SRNO() != null) {
	
				if (treatyTypeValueBean.getPTT_SRNO() == 1) {
					CommonUtils.setGlobalVariable("GLOBAL.ACCNT_PERIOD",
							treatyTypeValueBean.getPTT_ACCOUNTS_SUBMIT_PERIOD());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * WHEN-NEW-RECORD-INSTANCE SETS GLOBAL.ACCNT_PERIOD
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_type__when_new_record_instance(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
			PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
					.getPM_IL_PROP_TREATY_TYPE_ACTION();
			PM_IL_PROP_TREATY_TYPE treatyTypeValueBean = treatyTypeActionBean
					.getPM_IL_PROP_TREATY_TYPE_BEAN();
			if (treatyTypeValueBean.getPTT_SRNO() != null) {
				if (treatyTypeValueBean.getPTT_SRNO() == 1) {
					CommonUtils.setGlobalVariable("GLOBAL.ACCNT_PERIOD",
							treatyTypeValueBean.getPTT_ACCOUNTS_SUBMIT_PERIOD());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * when-create-record sets PTT_ACCOUNTS_SUBMIT_PERIOD
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws DBException
	 */
	public void pilm015_apac_pm_il_prop_treaty_type__when_create_record(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Double ptSysId = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION();
		PM_IL_PROP_TREATY_TYPE treatyTypeValueBean = treatyTypeActionBean
				.getPM_IL_PROP_TREATY_TYPE_BEAN();
		try {
			Connection connection = CommonUtils.getConnection();
			String sql_vembu1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_SELECT_PTT_SR_NO_FOR_SYS_ID;
			Object[] objects = { ptSysId };
			if (ptSysId != null) {
				resultSet = handler.executeSelectStatement(sql_vembu1,
						connection, objects);
			}
			if (treatyTypeValueBean.getPTT_SRNO() != null) {
				Double pttSrNO = treatyTypeValueBean.getPTT_SRNO();
				if (pttSrNO != 1) {
					L_GET_QS_DETAILS(compositeAction);
				}
			}
			treatyTypeValueBean.setPTT_ACCOUNTS_SUBMIT_PERIOD("M");
			treatyTypeValueBean.setPTT_ACCOUNTS_CLOSE_PERIOD("M");
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws DBException
	 */
	public void L_GET_QS_DETAILS(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection connection = CommonUtils.getConnection();
			String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_SELECT_DETAILS_FOR_PT_SYS_ID;
			Double ptSysId = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(sql_C1, connection,
					objects);
			if (resultSet.next()) {
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * PRE-UPDATE
	 * 
	 * @param compositeAction
	 * @throws ParseException 
	 * @throws ParseException
	 */
	public void pilm015_apac_pm_il_prop_treaty_type__pre_update(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws ParseException{
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION();
		PM_IL_PROP_TREATY_TYPE treatyTypeValueBean = treatyTypeActionBean
				.getPM_IL_PROP_TREATY_TYPE_BEAN();
		treatyTypeValueBean.setPTT_UPD_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		treatyTypeValueBean.setPTT_UPD_DT(commonUtils.getCurrentDate());
	}

	/*
	 * public void P_SET_LC_NUM_FMT_MASK_1(String P_ITEM_NAME,String
	 * P_FORM_OPEN_YN) { ResultSet resultSet1=null; ResultSet resultSet2=null;
	 * ResultSet resultSet3=null; CommonUtils commonUtils=new CommonUtils();
	 * Connection connection=commonUtils.getConnection(); CRUDHandler
	 * handler=new CRUDHandler(); try {
	 * 
	 * String M_PS_VALUE=null; String M_FORMAT_MASK=null; String M_MASK=null;
	 * String M_ITEM_NAME=null; String
	 * M_ORG_FMT_MASK="999,999,999,999,999,999,999,999,999,999"; double
	 * M_FIELD_LENGTH=-1; double M_BASE_DEC=-1; String M_MODULE_NAME=null; //
	 * ITEM M_ITEM_ID; String M_ITEM_TYPE=null; String M_BLOCK_NAME=null; String
	 * M_BASE_CURR=null; String M_LIST_PARAM=null; String
	 * M_LI_EXTERNAL_TABLE_YN=null; String M_LI_WHERE_CLAUSE=null; String
	 * M_LANG_CODE=null; String M_FONT_NAME=null; String M_FONT_SIZE=null;
	 * String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	 * PILM015_APAC_PM_IL_PROP_TREATY_TYPE_SELECT_PS_VALUE; // "SELECT PS_VALUE
	 * FROM PP_SYSTEM WHERE PS_TYPE = 'NUMFMTMASK' AND PS_CODE = 'NUMFMTMASK' "
	 * Object[] objects1={}; resultSet1=handler.executeSelectStatement(sql_C1,
	 * connection,objects1); String
	 * sql_C2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TYPE_SELECT_DESTAILS_FOR_ITEM_BLOCK_AND_MODULE;
	 * Object[] objects2={M_ITEM_NAME,M_BLOCK_NAME,M_MODULE_NAME}; "SELECT
	 * LI_SYS_PARAM, LI_EXTERNAL_TABLE_YN, LI_WHERE_CLAUSE FROM " + "
	 * PP_LIST_ITEM WHERE LI_ITEM_NAME = '"+M_ITEM_NAME+"'" + " AND
	 * LI_BLOCK_NAME = '"+M_BLOCK_NAME+"' AND LI_MODULE_NAME =
	 * '"+M_MODULE_NAME+"' "
	 * 
	 * String sql_C3=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	 * PILM015_APAC_PM_IL_PROP_TREATY_TYPE_SELECT_FONT; "SELECT
	 * NVL(PS_CODE_DESC, 'MICROSOFT SANS SERIF')," + " NVL(PS_VALUE, 1000) FROM
	 * PP_SYSTEM WHERE PS_TYPE = 'BL_FONT' AND PS_CODE = 'BL_FONT' ";
	 * 
	 * P_VAL_FINAL_PARAMETER.P_VAL_FINAL_PARAMETER("BASE.CURR",M_BASE_CURR,"E");
	 * P_GET_NO_OF_DEC.P_GET_NO_OF_DEC(M_BASE_CURR,M_BASE_DEC,"E");
	 * P_GET_FORMAT_MASK.P_GET_FORMAT_MASK(M_BASE_CURR,M_ORG_FMT_MASK);
	 * M_LANG_CODE=NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE");
	 * vembu_C3=stmt_C3.executeQuery(sql_C3); if(vembu_C3.next()) {
	 * M_FONT_NAME=vembu_C3.getString(1); M_FONT_SIZE=vembu_C3.getString(2); }
	 * 
	 * M_MASK=M_ORG_FMT_MASK; L_REVERSE.L_REVERSE(P_ITEM_NAME,M_MASK);
	 * M_MASK=StringFunctions.lTrim(StringFunctions.rTrim(M_MASK));
	 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY(P_ITEM_NAME,FORMAT_MASK,M_MASK); }
	 * finally { if(resultSet1!= null) { resultSet1.close(); } if(resultSet2!=
	 * null) { resultSet2.close(); } if(resultSet3!= null) { resultSet3.close(); } } }
	 * public void P_SET_LC_NUM_FMT_MASK_1(String P_ITEM_NAME) { String
	 * P_FORM_OPEN_YN="Y"; P_SET_LC_NUM_FMT_MASK_1 (P_ITEM_NAME,P_FORM_OPEN_YN); }
	 * public void P_SET_LC_NUM_FMT_MASK_1() { String P_FORM_OPEN_YN="Y"; String
	 * P_ITEM_NAME=null; P_SET_LC_NUM_FMT_MASK_1 (P_ITEM_NAME,P_FORM_OPEN_YN); }
	 */
	// TODO ONPOPULATE DETAILS NOT BE DONE
	/**
	 * WHEN-NEW-BLOCK-INSTANCE COMMENTED AS IT HANDLES NUMBER FORMATTING AS TOLD
	 * BY PRADEEP WE GAVENT GET ITS PEL WAY
	 * @throws Exception 
	 */
	/*
	 * public static void
	 * pilm015_apac-pm_il_prop_treaty_type--when-new-block-instance() throws
	 * SQLException,Exception { Connection vembu_conn =
	 * SwisSqlConnection.getInstance().getConnection(); try { final dbms_output
	 * dbms_output1=new dbms_output();
	 * P_SET_LC_NUM_FMT_MASK_1.P_SET_LC_NUM_FMT_MASK_1("PM_IL_PROP_TREATY_TYPE.PTT_DEPOSIT_PREM");
	 * P_SET_LC_NUM_FMT_MASK_1.P_SET_LC_NUM_FMT_MASK_1("PM_IL_PROP_TREATY_TYPE.PTT_NET_SURPLUS_AMT");
	 * }catch(Exception e) { e.printStackTrace(); throw e; } finally {
	 * if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 */

 public void chechForNegative(double d) throws Exception {
	 try{
		 if(d<0){
			  throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "NEGETIVECHECK"));
		 }
	 }catch (Exception e) {
		 e.printStackTrace();
		 throw new Exception(e.getMessage());
	}
	 }

	public void setstdMaxRetnForRetPerc(PM_IL_PROP_TREATY_COVER treatyCoverBean) {
		treatyCoverBean.setPTC_STD_MAX_RETN((MigratingFunctions.nvl(treatyCoverBean.getPTC_STD_TREATY_LIMIT(), 0) * treatyCoverBean.getPTC_RETN_PERC()) / 100);
		treatyCoverBean.setPTC_SSTD_MAX_RETN((MigratingFunctions.nvl(treatyCoverBean.getPTC_SUB_STD_TREATY_LIMIT(), 0) * treatyCoverBean.getPTC_RETN_PERC()) / 100);
	}
	
	public void companyDetailsCheck(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		String sql_C1 = "SELECT 'X' FROM PM_IL_PROP_TREATY_PART_CUST WHERE PTPC_PTT_SYS_ID=?";
		String sql_C2 = "SELECT PTPC_SHARE_PERC FROM PM_IL_PROP_TREATY_PART_CUST WHERE PTPC_PTT_SYS_ID = ?";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeAction = compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION();
		ArrayList<PM_IL_PROP_TREATY_TYPE> propTreatyTypeList = treatyTypeAction.getDataTableList();
		ResultSet rst_C1=null;
		ResultSet rst_C2 = null;
		String treatyType = null;
		Double PTPC_SHARE_PERC = null;
		try {
			connection = CommonUtils.getConnection();
			if(propTreatyTypeList!=null)
				for(PM_IL_PROP_TREATY_TYPE treatyTypeBean: propTreatyTypeList){
					String PTT_TREATY_TYPE = treatyTypeBean.getPTT_TREATY_TYPE();
					Double PTT_SYS_ID = treatyTypeBean.getPTT_SYS_ID();
					rst_C1 = null;
					rst_C2 = null;
					if(!(PTT_TREATY_TYPE==null?"":PTT_TREATY_TYPE).contains("RETN")){
						rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{PTT_SYS_ID});
						String M_TEMP = null;
						while(rst_C1.next()){
							M_TEMP = rst_C1.getString(1);
						}
						if(M_TEMP==null){
							if(treatyType!=null){
								treatyType += ", "+PTT_TREATY_TYPE;
							}else{
								treatyType = " "+PTT_TREATY_TYPE;
							}
						}
					}else{
						if(PTT_TREATY_TYPE!=null){
							rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{PTT_SYS_ID});
							while(rst_C2.next()){
								PTPC_SHARE_PERC = rst_C2.getDouble(1);
							}
							if(PTPC_SHARE_PERC!=null){
								if(PTPC_SHARE_PERC<100){
									treatyType = PTT_TREATY_TYPE;
								}
							}
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
				CommonUtils.closeCursor(rst_C2);
			}catch(Exception e){
			}
		}
	}
}
	

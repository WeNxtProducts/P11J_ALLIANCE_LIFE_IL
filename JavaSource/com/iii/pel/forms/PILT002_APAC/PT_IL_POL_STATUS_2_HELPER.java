package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_2_HELPER {

    CRUDHandler handler = new CRUDHandler();

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_STATUS_2_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_STATUS_2> dataList = compositeAction
		.getPT_IL_POL_STATUS_2_ACTION_BEAN()
		.getDataList_PT_IL_POL_STATUS_2();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_STATUS_2 PT_IL_POL_STATUS_2_BEAN = dataList.get(0);
	    PT_IL_POL_STATUS_2_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN()
		    .setPT_IL_POL_STATUS_2_BEAN(PT_IL_POL_STATUS_2_BEAN);
	}
    }

    public void whenCreateRecord(PILT002_APAC_COMPOSITE_ACTION compositeAction  ) throws Exception {

	PT_IL_POL_STATUS_2 pt_il_pol_status_2 = compositeAction
		.getPT_IL_POL_STATUS_2_ACTION_BEAN()
		.getPT_IL_POL_STATUS_2_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	String query1 = "  SELECT USER_DESC " + " FROM   MENU_USER WHERE  USER_ID = ? ";
	try {
	    connection = CommonUtils.getConnection();
	    pt_il_pol_status_2.setPS_STATUS_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
	    pt_il_pol_status_2.setPS_STATUS_DT(new CommonUtils().getCurrentDate());
	    values = new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID") };
	    rs = handler.executeSelectStatement(query1, connection, values);
	    if (rs.next()) {
		dummy_bean.setUI_M_USER_NAME(rs.getString(1));
	    }

	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void whenNewBlockInstance(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
													.getPT_IL_POLICY_BEAN();
	PT_IL_POL_STATUS_2 pt_il_pol_status_2 = compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN()
													.getPT_IL_POL_STATUS_2_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	String query1 = " SELECT 'X'  FROM  PT_IL_POL_STATUS WHERE  PS_POL_SYS_ID = ? AND  PS_STATUS_TYPE = 'C' ";
	String M_TEMP = null;
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
	    if (pt_il_pol_status_2.getROWID() != null) {
		
	    }
	    rs = handler.executeSelectStatement(query1, connection, values);
	    if (rs.next()) {
		M_TEMP = rs.getString(1);
		executeQuery(compositeAction);
	    }
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void preInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

	PT_IL_POL_STATUS_2 pt_il_pol_status_2 = compositeAction.getPT_IL_POL_STATUS_2_ACTION_BEAN()
		.getPT_IL_POL_STATUS_2_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();

	try {
	    connection = CommonUtils.getConnection();
	    pt_il_pol_status_2.setPS_STATUS_TYPE("C");
	    // added by dileshwar :- bacuse its fetching record on base on pol_sysy_id
	    pt_il_pol_status_2.setPS_POL_SYS_ID(compositeAction
	    		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
	    pt_il_pol_status_2.setPS_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.PS_CR_UID"));
	    pt_il_pol_status_2.setPS_CR_DT(new CommonUtils().getCurrentDate());
	 

	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

}

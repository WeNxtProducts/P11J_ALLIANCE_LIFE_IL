package com.iii.pel.forms.PILM070_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_A_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PP_LIFE_POL_SCH_PRN_ACTION extends CommonAction {

    // private static final PhaseEvent PhaseEvent = null;
    private HtmlAjaxCommandButton UI_M_BUT_ADD;
    private HtmlAjaxCommandButton UI_M_BUT_DELETE;
    private HtmlAjaxCommandButton UI_M_BUT_POST;

    private String filterByPLSP_DS_TYPE;
    private String filterByPLSP_DS_CODE;
    private String filterByPLSP_PROD_CODE;

    private HtmlOutputLabel COMP_PLSP_DS_TYPE_LABEL;

    private HtmlInputText COMP_PLSP_DS_TYPE;
    private HtmlInputText COMP_PLSP_MODULE_NAME;
    private HtmlInputText COMP_PLSP_SRNO;

    private HtmlOutputLabel COMP_PLSP_SRNO_LABEL;
    private HtmlOutputLabel COMP_PLSP_MODULE_NAME_LABEL;
    private HtmlOutputLabel COMP_PLSP_DS_CODE_LABEL;

    private HtmlInputText COMP_PLSP_DS_CODE;

    private HtmlOutputLabel COMP_UI_M_PLSP_DS_TYPE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PLSP_DS_TYPE_DESC;

    private HtmlOutputLabel COMP_UI_M_PLSP_PROD_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PLSP_PROD_CODE_DESC;

    private HtmlOutputLabel COMP_PLSP_PROD_CODE_LABEL;

    private HtmlInputText COMP_PLSP_PROD_CODE;

    private HtmlOutputLabel COMP_UI_M_PLSP_MODULE_ID_LABEL;

    private HtmlInputText COMP_UI_M_PLSP_MODULE_ID;

    private HtmlOutputLabel COMP_PLSP_REPORT_ID_LABEL;

    private HtmlInputText COMP_PLSP_REPORT_ID;

    private HtmlOutputLabel COMP_UI_M_PLSP_MODULE_ID_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PLSP_MODULE_ID_DESC;

    private HtmlOutputLabel COMP_UI_M_PLSP_DS_CODE_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PLSP_DS_CODE_DESC;

    private HtmlOutputLabel COMP_PLSP_REPORT_NAME_LABEL;

    private HtmlInputText COMP_PLSP_REPORT_NAME;

    private HtmlOutputLabel COMP_PLSP_TYPE_LABEL;

    private HtmlInputText COMP_PLSP_TYPE;

    private HtmlCommandButton COMP_BUT_LOV_PLSP_DS_TYPE;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PLSP_PROD_CODE;

    private HtmlCommandButton COMP_UI_M_LOV_BUT_PLSP_DS_CODE;

    private PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN;
    private DUMMY DUMMY_BEAN;

    private HtmlCommandButton preFormButton;

    private UIData dataTable;

    Map<String, Object> session = null;

    List<PP_LIFE_POL_SCH_PRN> preQueryResultList = new ArrayList<PP_LIFE_POL_SCH_PRN>();

    private ListDataModel listModel;

    GNMNF002_A_APAC gnmfoo2_a_apac = null;

    FacesContext facesContext = FacesContext.getCurrentInstance();

    PP_LIFE_POL_SCH_PRN newPP_LIFE_POL_SCH_PRN;

    ArrayList<PP_LIFE_POL_SCH_PRN> selectedList = null;

    PP_LIFE_POL_SCH_PRN_HELPER helper = new PP_LIFE_POL_SCH_PRN_HELPER();

    public PP_LIFE_POL_SCH_PRN_ACTION() {
	PP_LIFE_POL_SCH_PRN_BEAN = new PP_LIFE_POL_SCH_PRN();
	DUMMY_BEAN = new DUMMY();
    }

    public HtmlOutputLabel getCOMP_PLSP_DS_TYPE_LABEL() {
	return COMP_PLSP_DS_TYPE_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_DS_TYPE() {
	return COMP_PLSP_DS_TYPE;
    }

    public String getFilterByPLSP_DS_TYPE() {
	return filterByPLSP_DS_TYPE;
    }

    public void setFilterByPLSP_DS_TYPE(String filterByPLSP_DS_TYPE) {
	this.filterByPLSP_DS_TYPE = filterByPLSP_DS_TYPE;
    }

    public String getFilterByPLSP_DS_CODE() {
	return filterByPLSP_DS_CODE;
    }

    public void setFilterByPLSP_DS_CODE(String filterByPLSP_DS_CODE) {
	this.filterByPLSP_DS_CODE = filterByPLSP_DS_CODE;
    }

    public String getFilterByPLSP_PROD_CODE() {
	return filterByPLSP_PROD_CODE;
    }

    public void setFilterByPLSP_PROD_CODE(String filterByPLSP_PROD_CODE) {
	this.filterByPLSP_PROD_CODE = filterByPLSP_PROD_CODE;
    }

    public void setCOMP_PLSP_DS_TYPE_LABEL(
	    HtmlOutputLabel COMP_PLSP_DS_TYPE_LABEL) {
	this.COMP_PLSP_DS_TYPE_LABEL = COMP_PLSP_DS_TYPE_LABEL;
    }

    public void setCOMP_PLSP_DS_TYPE(HtmlInputText COMP_PLSP_DS_TYPE) {
	this.COMP_PLSP_DS_TYPE = COMP_PLSP_DS_TYPE;
    }

    public HtmlOutputLabel getCOMP_PLSP_DS_CODE_LABEL() {
	return COMP_PLSP_DS_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_DS_CODE() {
	return COMP_PLSP_DS_CODE;
    }

    public void setCOMP_PLSP_DS_CODE_LABEL(
	    HtmlOutputLabel COMP_PLSP_DS_CODE_LABEL) {
	this.COMP_PLSP_DS_CODE_LABEL = COMP_PLSP_DS_CODE_LABEL;
    }

    public void setCOMP_PLSP_DS_CODE(HtmlInputText COMP_PLSP_DS_CODE) {
	this.COMP_PLSP_DS_CODE = COMP_PLSP_DS_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PLSP_DS_TYPE_DESC_LABEL() {
	return COMP_UI_M_PLSP_DS_TYPE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PLSP_DS_TYPE_DESC() {
	return COMP_UI_M_PLSP_DS_TYPE_DESC;
    }

    public void setCOMP_UI_M_PLSP_DS_TYPE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PLSP_DS_TYPE_DESC_LABEL) {
	this.COMP_UI_M_PLSP_DS_TYPE_DESC_LABEL = COMP_UI_M_PLSP_DS_TYPE_DESC_LABEL;
    }

    public void setCOMP_UI_M_PLSP_DS_TYPE_DESC(
	    HtmlInputText COMP_UI_M_PLSP_DS_TYPE_DESC) {
	this.COMP_UI_M_PLSP_DS_TYPE_DESC = COMP_UI_M_PLSP_DS_TYPE_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_PLSP_PROD_CODE_DESC_LABEL() {
	return COMP_UI_M_PLSP_PROD_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PLSP_PROD_CODE_DESC() {
	return COMP_UI_M_PLSP_PROD_CODE_DESC;
    }

    public void setCOMP_UI_M_PLSP_PROD_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PLSP_PROD_CODE_DESC_LABEL) {
	this.COMP_UI_M_PLSP_PROD_CODE_DESC_LABEL = COMP_UI_M_PLSP_PROD_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_PLSP_PROD_CODE_DESC(
	    HtmlInputText COMP_UI_M_PLSP_PROD_CODE_DESC) {
	this.COMP_UI_M_PLSP_PROD_CODE_DESC = COMP_UI_M_PLSP_PROD_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_PLSP_PROD_CODE_LABEL() {
	return COMP_PLSP_PROD_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_PROD_CODE() {
	return COMP_PLSP_PROD_CODE;
    }

    public void setCOMP_PLSP_PROD_CODE_LABEL(
	    HtmlOutputLabel COMP_PLSP_PROD_CODE_LABEL) {
	this.COMP_PLSP_PROD_CODE_LABEL = COMP_PLSP_PROD_CODE_LABEL;
    }

    public void setCOMP_PLSP_PROD_CODE(HtmlInputText COMP_PLSP_PROD_CODE) {
	this.COMP_PLSP_PROD_CODE = COMP_PLSP_PROD_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PLSP_MODULE_ID_LABEL() {
	return COMP_UI_M_PLSP_MODULE_ID_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PLSP_MODULE_ID() {
	return COMP_UI_M_PLSP_MODULE_ID;
    }

    public void setCOMP_UI_M_PLSP_MODULE_ID_LABEL(
	    HtmlOutputLabel COMP_UI_M_PLSP_MODULE_ID_LABEL) {
	this.COMP_UI_M_PLSP_MODULE_ID_LABEL = COMP_UI_M_PLSP_MODULE_ID_LABEL;
    }

    public void setCOMP_UI_M_PLSP_MODULE_ID(
	    HtmlInputText COMP_UI_M_PLSP_MODULE_ID) {
	this.COMP_UI_M_PLSP_MODULE_ID = COMP_UI_M_PLSP_MODULE_ID;
    }

    public HtmlOutputLabel getCOMP_PLSP_REPORT_ID_LABEL() {
	return COMP_PLSP_REPORT_ID_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_REPORT_ID() {
	return COMP_PLSP_REPORT_ID;
    }

    public void setCOMP_PLSP_REPORT_ID_LABEL(
	    HtmlOutputLabel COMP_PLSP_REPORT_ID_LABEL) {
	this.COMP_PLSP_REPORT_ID_LABEL = COMP_PLSP_REPORT_ID_LABEL;
    }

    public void setCOMP_PLSP_REPORT_ID(HtmlInputText COMP_PLSP_REPORT_ID) {
	this.COMP_PLSP_REPORT_ID = COMP_PLSP_REPORT_ID;
    }

    public HtmlOutputLabel getCOMP_UI_M_PLSP_MODULE_ID_DESC_LABEL() {
	return COMP_UI_M_PLSP_MODULE_ID_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PLSP_MODULE_ID_DESC() {
	return COMP_UI_M_PLSP_MODULE_ID_DESC;
    }

    public void setCOMP_UI_M_PLSP_MODULE_ID_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PLSP_MODULE_ID_DESC_LABEL) {
	this.COMP_UI_M_PLSP_MODULE_ID_DESC_LABEL = COMP_UI_M_PLSP_MODULE_ID_DESC_LABEL;
    }

    public void setCOMP_UI_M_PLSP_MODULE_ID_DESC(
	    HtmlInputText COMP_UI_M_PLSP_MODULE_ID_DESC) {
	this.COMP_UI_M_PLSP_MODULE_ID_DESC = COMP_UI_M_PLSP_MODULE_ID_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_PLSP_DS_CODE_DESC_LABEL() {
	return COMP_UI_M_PLSP_DS_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PLSP_DS_CODE_DESC() {
	return COMP_UI_M_PLSP_DS_CODE_DESC;
    }

    public void setCOMP_UI_M_PLSP_DS_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PLSP_DS_CODE_DESC_LABEL) {
	this.COMP_UI_M_PLSP_DS_CODE_DESC_LABEL = COMP_UI_M_PLSP_DS_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_PLSP_DS_CODE_DESC(
	    HtmlInputText COMP_UI_M_PLSP_DS_CODE_DESC) {
	this.COMP_UI_M_PLSP_DS_CODE_DESC = COMP_UI_M_PLSP_DS_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_PLSP_REPORT_NAME_LABEL() {
	return COMP_PLSP_REPORT_NAME_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_REPORT_NAME() {
	return COMP_PLSP_REPORT_NAME;
    }

    public void setCOMP_PLSP_REPORT_NAME_LABEL(
	    HtmlOutputLabel COMP_PLSP_REPORT_NAME_LABEL) {
	this.COMP_PLSP_REPORT_NAME_LABEL = COMP_PLSP_REPORT_NAME_LABEL;
    }

    public void setCOMP_PLSP_REPORT_NAME(HtmlInputText COMP_PLSP_REPORT_NAME) {
	this.COMP_PLSP_REPORT_NAME = COMP_PLSP_REPORT_NAME;
    }

    public HtmlOutputLabel getCOMP_PLSP_TYPE_LABEL() {
	return COMP_PLSP_TYPE_LABEL;
    }

    public HtmlInputText getCOMP_PLSP_TYPE() {
	return COMP_PLSP_TYPE;
    }

    public void setCOMP_PLSP_TYPE_LABEL(HtmlOutputLabel COMP_PLSP_TYPE_LABEL) {
	this.COMP_PLSP_TYPE_LABEL = COMP_PLSP_TYPE_LABEL;
    }

    public void setCOMP_PLSP_TYPE(HtmlInputText COMP_PLSP_TYPE) {
	this.COMP_PLSP_TYPE = COMP_PLSP_TYPE;
    }

    public HtmlCommandButton getCOMP_BUT_LOV_PLSP_DS_TYPE() {
	return COMP_BUT_LOV_PLSP_DS_TYPE;
    }

    public void setCOMP_BUT_LOV_PLSP_DS_TYPE(
	    HtmlCommandButton COMP_BUT_LOV_PLSP_DS_TYPE) {
	this.COMP_BUT_LOV_PLSP_DS_TYPE = COMP_BUT_LOV_PLSP_DS_TYPE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PLSP_PROD_CODE() {
	return COMP_UI_M_BUT_LOV_PLSP_PROD_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_PLSP_PROD_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_PLSP_PROD_CODE) {
	this.COMP_UI_M_BUT_LOV_PLSP_PROD_CODE = COMP_UI_M_BUT_LOV_PLSP_PROD_CODE;
    }

    public HtmlCommandButton getCOMP_UI_M_LOV_BUT_PLSP_DS_CODE() {
	return COMP_UI_M_LOV_BUT_PLSP_DS_CODE;
    }

    public void setCOMP_UI_M_LOV_BUT_PLSP_DS_CODE(
	    HtmlCommandButton COMP_UI_M_LOV_BUT_PLSP_DS_CODE) {
	this.COMP_UI_M_LOV_BUT_PLSP_DS_CODE = COMP_UI_M_LOV_BUT_PLSP_DS_CODE;
    }

    public PP_LIFE_POL_SCH_PRN getPP_LIFE_POL_SCH_PRN_BEAN() {
	return PP_LIFE_POL_SCH_PRN_BEAN;
    }

    public void setPP_LIFE_POL_SCH_PRN_BEAN(
	    PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) {
	this.PP_LIFE_POL_SCH_PRN_BEAN = PP_LIFE_POL_SCH_PRN_BEAN;
    }

    // public void createCtrlBean(){
    // CTRL bean = new CTRL();
    // session = facesContext.getExternalContext().getSessionMap();
    // session.put("ctrlbean", bean);
    // }
    //
    // public CTRL getControlBean() {
    // session = facesContext.getExternalContext().getSessionMap();
    // return (CTRL) session.get("ctrlbean");
    // }
    //
    // public void putControlBean(CTRL controlBean) {
    // session = facesContext.getExternalContext().getSessionMap();
    // session.put("ctrlbean", controlBean);
    // }

    public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
	return UI_M_BUT_ADD;
    }

    public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
	UI_M_BUT_ADD = ui_m_but_add;
    }

    public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
	return UI_M_BUT_DELETE;
    }

    public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
	UI_M_BUT_DELETE = ui_m_but_delete;
    }

    public HtmlAjaxCommandButton getUI_M_BUT_POST() {
	return UI_M_BUT_POST;
    }

    public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
	UI_M_BUT_POST = ui_m_but_post;
    }

    public ListDataModel getListModel() {
	return listModel;
    }

    public void setListModel(ListDataModel listModel) {
	this.listModel = listModel;
    }

    public List getPreQueryResultList() {
	return preQueryResultList;
    }

    public void setPreQueryResultList(List preQueryResultList) {
	this.preQueryResultList = preQueryResultList;
    }

    public HtmlCommandButton getPreFormButton() {
	return preFormButton;
    }

    public void setPreFormButton(HtmlCommandButton preFormButton) {
	this.preFormButton = preFormButton;
    }

    /*
     * public void PRE_QUERY(String selectQuery) { System.out .println("The
     * Select Query in the PRE_QUERY is................" + selectQuery); List
     * testList = new ArrayList(); PreparedStatement preparedStatement;
     * PreparedStatement postQueryStatement; ResultSet postResultSet = null;
     * ResultSet postQueryResultSet = null; List postQueryList = new
     * ArrayList(); String postQuery; Connection connection = null; try {
     * connection = CommonUtils.getConnection(); CRUDHandler handler = new
     * CRUDHandler();
     * 
     * preQueryResultList = handler.fetch(selectQuery,
     * "com.iii.pel.forms.PILM070_APAC.PP_LIFE_POL_SCH_PRN", connection);
     *  // Logic For Default Population PP_LIFE_POL_SCH_PRN bean = null;
     * Iterator<PP_LIFE_POL_SCH_PRN> it = preQueryResultList.iterator();
     * 
     * while (it.hasNext()) { bean = it.next(); bean.setRowSelected(false); }
     * this.setPreQueryResultList(preQueryResultList); if
     * (preQueryResultList.size() > 0) {
     * this.setPP_LIFE_POL_SCH_PRN_BEAN(preQueryResultList.get(0));
     * this.getPP_LIFE_POL_SCH_PRN_BEAN().setRowSelected(true); }
     *  // POST QUERY FUNCTIONALITY STARTS for (Iterator iterator =
     * preQueryResultList.iterator(); iterator .hasNext();) {
     * newPP_LIFE_POL_SCH_PRN = (PP_LIFE_POL_SCH_PRN) iterator.next(); postQuery =
     * "SELECT DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '" +
     * newPP_LIFE_POL_SCH_PRN.getPLSP_DS_TYPE() + "' AND DS_CODE = '" +
     * newPP_LIFE_POL_SCH_PRN.getPLSP_DS_CODE() + "'"; postQueryResultSet =
     * handler.executeSelectStatement(postQuery, connection); if
     * (postQueryResultSet.next()) { postResultSet =
     * handler.executeSelectStatement(postQuery, connection); while
     * (postResultSet.next()) { newPP_LIFE_POL_SCH_PRN
     * .setUI_M_PLSP_DS_CODE_DESC(postResultSet .getString("DS_DESC")); } } else {
     * newPP_LIFE_POL_SCH_PRN.setUI_M_PLSP_MODULE_ID_DESC(""); } while
     * (postQueryResultSet.next()) {
     *  } P_VAL_SYSTEM1("LIMODCODES", newPP_LIFE_POL_SCH_PRN
     * .getPLSP_MODULE_ID(), null, "N", null); P_VAL_SYSTEM2("IL_DOC_TYP",
     * newPP_LIFE_POL_SCH_PRN .getPLSP_DS_TYPE(), null, "N", null);
     * P_VAL_PRODUCT(newPP_LIFE_POL_SCH_PRN.getPLSP_PROD_CODE(), null, "N"); }
     * prevRowIndex = 0; currPage = 1; listModel = new
     * ListDataModel(preQueryResultList);
     *  } catch (Exception er) { try { postQueryResultSet.close(); //
     * con.close(); } catch (Exception err) {
     *  } er.printStackTrace(); } }
     * 
     * public void P_VAL_SYSTEM1(String P_TYPE, String P_CODE, String
     * P_CODE_DESC, String P_ERR_FLAG, String P_VALUE) { this.P_CODE_DESC1 =
     * P_CODE_DESC; this.P_VALUE1 = P_VALUE; ResultSet pvsrs; PreparedStatement
     * pvstmt; String pvsQuery; CRUDHandler handler = new CRUDHandler(); try {
     * 
     * pvsQuery = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM
     * WHERE PS_TYPE='" + P_TYPE + "' AND PS_CODE='" + P_CODE + "'"; pvsrs =
     * handler.executeSelectStatement(pvsQuery, CommonUtils .getConnection());
     * while (pvsrs.next()) { setM_NAME(pvsrs.getString("PS_CODE_DESC"));
     * setM_BL_NAME(pvsrs.getString("PS_BL_CODE_DESC")); setM_VALUE("" +
     * pvsrs.getInt("PS_VALUE")); } if (pvsrs.isAfterLast() ||
     * pvsrs.isBeforeFirst()) { if (P_ERR_FLAG.equals("W") ||
     * P_ERR_FLAG.equals("E")) { if (P_ERR_FLAG.equals("" + "E")) { System.out
     * .println("The Err in ERR_FLAG........................"); } } }
     * pvsrs.close();
     * 
     * if (gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_FOR_LANG_CODE")
     * .toString().substring(1, 4).equals("1") ||
     * gnmfoo2_a_apac.globalParameters().get(
     * "GLOBAL.M_LANG_CODE").equals("ENG")) { setP_CODE_DESC1(getM_NAME()); }
     * else { setP_CODE_DESC1(getM_NAME()); } setP_VALUE1(M_VALUE);
     * 
     * newPP_LIFE_POL_SCH_PRN .setUI_M_PLSP_MODULE_ID_DESC(getP_CODE_DESC1());
     *  } catch (Exception er) { er.printStackTrace(); } }
     * 
     * public void P_VAL_SYSTEM2(String P_TYPE, String P_CODE, String
     * P_CODE_DESC, String P_ERR_FLAG, String P_VALUE) { this.P_CODE_DESC2 =
     * P_CODE_DESC; this.P_VALUE2 = P_VALUE; ResultSet pvsrs; String pvsQuery;
     * Connection con = null; CRUDHandler handler = null; try { con =
     * CommonUtils.getConnection(); handler = new CRUDHandler(); pvsQuery =
     * "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE
     * PS_TYPE='" + P_TYPE + "' AND PS_CODE='" + P_CODE + "'"; pvsrs =
     * handler.executeSelectStatement(pvsQuery, con); while (pvsrs.next()) {
     * setM_NAME(pvsrs.getString("PS_CODE_DESC"));
     * setM_BL_NAME(pvsrs.getString("PS_BL_CODE_DESC")); setM_VALUE("" +
     * pvsrs.getInt("PS_VALUE")); } if (pvsrs.isAfterLast() ||
     * pvsrs.isBeforeFirst()) { if (P_ERR_FLAG.equals("W") ||
     * P_ERR_FLAG.equals("E")) { System.out
     * .println("STD_MESSAGE_ROUTINE(1000,NAME_IN.NAME_IN(" +
     * gnmfoo2_a_apac.globalParameters().get( "GLOBAL.M_LANG_CODE") + "))"); if
     * (P_ERR_FLAG.equals("" + "E")) { System.out .println("The Err in
     * ERR_FLAG........................"); } } } pvsrs.close(); if
     * (gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_FOR_LANG_CODE")
     * .toString().substring(1, 4).equals("1") ||
     * gnmfoo2_a_apac.globalParameters().get(
     * "GLOBAL.M_LANG_CODE").equals("ENG")) { setP_CODE_DESC2(getM_NAME()); }
     * else { setP_CODE_DESC2(getM_NAME()); } setP_VALUE2(M_VALUE);
     * newPP_LIFE_POL_SCH_PRN.setUI_M_PLSP_DS_TYPE_DESC(getP_CODE_DESC2());
     *  } catch (Exception er) { er.printStackTrace(); } }
     *  // newPP_LIFE_POL_SCH_PRN.getPLSP_PROD_CODE(),null,"N" public void
     * P_VAL_PRODUCT(String P_PROD_CODE, String P_PROD_DESC, String P_ERR_FLAG) { //
     * this.P_PROD_DESC = P_PROD_DESC; String Query = null; ResultSet
     * p_Val_Prd_Rs = null; CRUDHandler handler = new CRUDHandler(); try { Query =
     * "SELECT PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = '" +
     * P_PROD_CODE + "'";
     * 
     * p_Val_Prd_Rs = handler.executeSelectStatement(Query, CommonUtils
     * .getConnection()); while (p_Val_Prd_Rs.next()) {
     * setM_PROD_DESC(p_Val_Prd_Rs.getString("PROD_DESC"));
     * setM_PROD_BL_DESC(p_Val_Prd_Rs.getString("PROD_BL_DESC")); }
     * 
     * if (p_Val_Prd_Rs.isAfterLast() || p_Val_Prd_Rs.isBeforeFirst()) { if
     * (P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")) { System.out
     * .println("STD_MESSAGE_ROUTINE(1000,NAME_IN.NAME_IN(" +
     * gnmfoo2_a_apac.globalParameters().get( "GLOBAL.M_LANG_CODE") + "))"); if
     * (P_ERR_FLAG.equals("" + "E")) { System.out .println("The Err in
     * ERR_FLAG........................"); } } }
     * 
     * if (gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_FOR_LANG_CODE")
     * .toString().substring(1, 4).equals("1") ||
     * gnmfoo2_a_apac.globalParameters().get(
     * "GLOBAL.M_LANG_CODE").equals("ENG")) { setP_PROD_DESC(getM_PROD_DESC()); }
     * else { setP_PROD_DESC(getM_PROD_BL_DESC()); } newPP_LIFE_POL_SCH_PRN
     * .setUI_M_PLSP_PROD_CODE_DESC(getP_PROD_DESC()); p_Val_Prd_Rs.close();
     * System.out.println("getP_PROD_DESC()-----" + getP_PROD_DESC());
     *  } catch (Exception er) { er.printStackTrace(); } }
     * 
     */
    
    public ArrayList<com.iii.premia.common.bean.LovBean> lovPLSP_PROD_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	   
	    suggestionList = listitemutil.P_CALL_LOV("PILM070_APAC",
		    "PP_LIFE_POL_SCH_PRN", "PLSP_PROD_CODE",null, null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    
    public ArrayList<com.iii.premia.common.bean.LovBean> lovPLSP_DS_TYPE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    suggestionList = listitemutil.P_CALL_LOV("PILM070_APAC",
		    "PP_LIFE_POL_SCH_PRN", "PLSP_DS_TYPE", "IL_DOC_TYP", null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    
    public ArrayList<com.iii.premia.common.bean.LovBean> lovPLSP_DS_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    if(PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE()!=null){
        	 if("1".equals(PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE()) ){
        	     suggestionList = listitemutil.P_CALL_LOV("PILM070_APAC",  "PP_LIFE_POL_SCH_PRN", "PLSP_DS_CODE", 
 			    PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE() , null, null, null,
 			    null, (String) currValue);
        	 }
        	 if("2".equals(PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE()) ){
        	     suggestionList = listitemutil.P_CALL_LOV("PILM070_APAC",  "PP_LIFE_POL_SCH_PRN", "PLSP_DS_CODE", 
 			    "2" , "3", null, null,
 			    null, (String) currValue);
        		 
        	 }else{
        	     suggestionList = listitemutil.P_CALL_LOV("PILM070_APAC",  "PP_LIFE_POL_SCH_PRN", "PLSP_DS_CODE", 
 			    PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE() , null, null, null,
 			    null, (String) currValue);
        	 }
	    }
	
	 
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
 

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PP_LIFE_POL_SCH_PRN_BEAN = new PP_LIFE_POL_SCH_PRN();
		resetAllComponent();
		resetSelectedRow();
	    } else {

		getErrorMap().put(
			"addRow",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insertnotallowed"));
		getErrorMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insertnotallowed"));
	    }

	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("addRow", exc.getMessage());
	}

    }

    /*public void saveRecord() {
	try {
	 
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }*/

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    // CALL THE Validator

    public void validateUI_M_PLSP_MODULE_ID(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	  //  PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_MODULE_ID((String) value);
	    DUMMY_BEAN.setUI_M_PLSP_MODULE_ID((String) value);
	    helper.UI_M_PLSP_MODULE_ID_WHEN_VALIDATE_ITEM((String) value,
		    DUMMY_BEAN);
	    COMP_UI_M_PLSP_MODULE_ID_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_PLSP_MODULE_ID", getWarningMap());

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validatePLSP_DS_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_CODE((String) value);
	    helper.PLSP_DS_CODE_WHEN_VALIDATE_ITEM((String) value,
		    PP_LIFE_POL_SCH_PRN_BEAN);
	    COMP_UI_M_PLSP_DS_CODE_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PLSP_DS_CODE", getWarningMap());
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePLSP_DS_TYPE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException, ProcedureException, DBException {
	CommonUtils.clearMaps(this);
	try {
	    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_TYPE((String) value);
	    helper.PLSP_DS_TYPE_WHEN_VALIDATE_ITEM((String) value,
		    PP_LIFE_POL_SCH_PRN_BEAN);
	    COMP_UI_M_PLSP_DS_TYPE_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	 //   ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PLSP_DS_TYPE", getWarningMap());

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validatePLSP_SRNO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
	    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_SRNO((Integer) value);
	    helper.PLSP_SRNO_WHEN_VALIDATE_ITEM((Integer) value,
		    PP_LIFE_POL_SCH_PRN_BEAN);
	    COMP_PLSP_SRNO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PLSP_SRNO", getWarningMap());
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void validatePLSP_PROD_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
 
	try {
	    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_PROD_CODE((String) value);
	    helper.PLSP_PROD_CODE_WHEN_VALIDATE_ITEM((String) value,
		    PP_LIFE_POL_SCH_PRN_BEAN);
	    COMP_UI_M_PLSP_PROD_CODE_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PLSP_PROD_CODE", getWarningMap());

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    /*
     * public void dataColoumListener() {
     * System.out.println("PT_IL_FAC_OUT_ACTION.dataColoumListener()"); // int
     * curRowIdx = getDatatable().getRowIndex(); int updatedRow = 0; //
     * PP_LIFE_POL_SCH_PRN dtlBean = null; try {
     * 
     * newPP_LIFE_POL_SCH_PRN = this.getPP_LIFE_POL_SCH_PRN_BEAN(); if
     * (newPP_LIFE_POL_SCH_PRN.getROWID() != null) { PRE_UPDATE(); updatedRow =
     * helper.updateData(newPP_LIFE_POL_SCH_PRN); errorMap.put("somekey",
     * updatedRow + " record updated."); errorMap.put("current", updatedRow + "
     * record updated."); } else { PRE_INSERT(); updatedRow =
     * helper.updateData(newPP_LIFE_POL_SCH_PRN); errorMap.put("somekey",
     * updatedRow + " record updated."); errorMap.put("current", updatedRow + "
     * record updated."); }
     *  } catch (Exception e) { e.printStackTrace(); } }
     */

    /*
     * public void onFocusing(ActionEvent onFocusEvent){ String indxAndID =
     * null;
     * 
     * UIComponent uiComponent = onFocusEvent.getComponent().getParent();
     * if(uiComponent instanceof UIInput){ UIInput uiInput = (UIInput)
     * uiComponent;
     * keyValue.put(""+getDatatable().getRowIndex()+onFocusEvent.getComponent().getParent().getId(),(String)
     * uiInput.getValue() );
     * //System.out.println("--------------------------------"+uiInput.getValue());
     * }else{ //System.out.println("+++++++++++++++++++++++++++++++++++++"); }
     * //System.out.println("The Component Id is
     * :::::::::::::::::::::::::::::::::"+onFocusEvent.getComponent().getParent().getId());
     * int rowIndex = getDatatable().getRowIndex(); //System.out.println("The
     * Row index is :::::::::::::::::"+rowIndex); }
     */
    /*
     * public void onFocusLost(ActionEvent onFocusLostEvent){ Set keySet =
     * keyValue.entrySet(); Iterator iterator = keySet.iterator();
     * while(iterator.hasNext()){
     * 
     * System.out.println("The Results are
     * ----------------------"+iterator.next()); } }
     */

    /*
     * boolean notify = false; public void gridListener(ValueChangeEvent
     * valueChangeEvent){ if(notify == true){
     * setOldValue((String)valueChangeEvent.getOldValue());
     * setNewValue((String)valueChangeEvent.getNewValue());
     * if(!getOldValue().equalsIgnoreCase(getNewValue())){ } }else{ } }
     */

    /*
     * public void onFocusListener(ActionEvent focusEvent){ UIInput uiInput =
     * (UIInput) focusEvent.getComponent().getParent();
     * 
     * System.out.println("Child Count::"+getDatatable().getChildCount());
     * System.out.println("SIMPLE
     * NAME::::"+getDatatable().getRowData().getClass().getSimpleName());
     * System.out.println("ROW INDEX::"+getDatatable().getRowIndex());
     * System.out.println("SUBMITTED VALUE:::::"+uiInput.getValue());
     * 
     * UIInput uiInput = (UIInput) focusEvent.getComponent().getParent();
     * System.out.println("The Values on Focus is
     * "+uiInput.getSubmittedValue());
     * if(!"".equalsIgnoreCase((String)uiInput.getSubmittedValue())){ notify =
     * true; } }
     */

    public void resetAllComponent() {
	// Reseting HtmlInputText
	//COMP_UI_M_PLSP_MODULE_ID.resetValue();
	COMP_PLSP_DS_TYPE.resetValue();
	COMP_PLSP_DS_CODE.resetValue();
	COMP_PLSP_PROD_CODE.resetValue();
	COMP_PLSP_REPORT_ID.resetValue();
	COMP_PLSP_TYPE.resetValue();
	COMP_UI_M_PLSP_MODULE_ID_DESC.resetValue();
	COMP_UI_M_PLSP_DS_TYPE_DESC.resetValue();
	COMP_UI_M_PLSP_PROD_CODE_DESC.resetValue();
	COMP_UI_M_PLSP_DS_CODE_DESC.resetValue();
	COMP_PLSP_REPORT_NAME.resetValue();
    }

    public void deleteRow(ActionEvent ae) {

	try {
	    getErrorMap().clear();
	    getWarningMap().clear();

	    if (isDELETE_ALLOWED()) {
		if (PP_LIFE_POL_SCH_PRN_BEAN.getROWID() != null) {
		    // executeDelete(PM_CUST_DIVN_BEAN);
		    new CRUDHandler().executeDelete(PP_LIFE_POL_SCH_PRN_BEAN,
			    CommonUtils.getConnection());
		    CommonUtils.getConnection().commit();
		    preQueryResultList.remove(PP_LIFE_POL_SCH_PRN_BEAN);
		}

		if (preQueryResultList.size() > 0) {
		    setPP_LIFE_POL_SCH_PRN_BEAN(preQueryResultList.get(0));
		    PP_LIFE_POL_SCH_PRN_BEAN.setRowSelected(true);
		} else {
		    addRow(ae);
		}

		getWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete"));
		getWarningMap().put(
			"deleteRow",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete"));
		resetAllComponent();

	    } else {
		getErrorMap().clear();
		getErrorMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$deletenotallowed"));
		getErrorMap().put(
			"deleteRow",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$deletenotallowed"));
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("deleteRow", e.getMessage());
	}
    }

    public HtmlInputText getCOMP_PLSP_MODULE_NAME() {
	return COMP_PLSP_MODULE_NAME;
    }

    public void setCOMP_PLSP_MODULE_NAME(HtmlInputText comp_plsp_module_name) {
	COMP_PLSP_MODULE_NAME = comp_plsp_module_name;
    }

    public HtmlOutputLabel getCOMP_PLSP_MODULE_NAME_LABEL() {
	return COMP_PLSP_MODULE_NAME_LABEL;
    }

    public void setCOMP_PLSP_MODULE_NAME_LABEL(
	    HtmlOutputLabel comp_plsp_module_name_label) {
	COMP_PLSP_MODULE_NAME_LABEL = comp_plsp_module_name_label;
    }

    public void saveRecord() throws SQLException {
	try {
	    if (PP_LIFE_POL_SCH_PRN_BEAN.getROWID() == null
		    && isINSERT_ALLOWED()) {
		helper.PRE_INSERT(DUMMY_BEAN,PP_LIFE_POL_SCH_PRN_BEAN);
		new CRUDHandler().executeInsert(PP_LIFE_POL_SCH_PRN_BEAN,
			CommonUtils.getConnection());
		getWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save"));
		getWarningMap().put(
			"postRecord",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save"));
		preQueryResultList.add(PP_LIFE_POL_SCH_PRN_BEAN);
		 CommonUtils.getConnection().commit();
	    } else if (PP_LIFE_POL_SCH_PRN_BEAN.getROWID() != null
		    && isUPDATE_ALLOWED()) {
		helper.PRE_UPDATE(PP_LIFE_POL_SCH_PRN_BEAN,DUMMY_BEAN);
		new CRUDHandler().executeUpdate(PP_LIFE_POL_SCH_PRN_BEAN,
			CommonUtils.getConnection());
		getWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update"));
		getWarningMap().put(
			"postRecord",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update"));
	    }
	    CommonUtils.getConnection().commit();
	    PP_LIFE_POL_SCH_PRN_BEAN.setRowSelected(true);
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    "Record not Inserted/Updated :: " + exc.getMessage());
	    getErrorMap().put("postRecord",
		    "Record not Inserted/Updated :: " + exc.getMessage());
	}

    }

    public void displayRecords() {
	CommonUtils.clearMaps(this);
	try {
	    resetSelectedRow();
	    PP_LIFE_POL_SCH_PRN_BEAN = (PP_LIFE_POL_SCH_PRN) dataTable
		    .getRowData();
	    PP_LIFE_POL_SCH_PRN_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PP_LIFE_POL_SCH_PRN> PP_LIFE_POL_SCH_PRN_ITR = preQueryResultList
		.iterator();
	while (PP_LIFE_POL_SCH_PRN_ITR.hasNext()) {
	    PP_LIFE_POL_SCH_PRN_ITR.next().setRowSelected(false);
	}
    }

    public UIData getDataTable() {
	return dataTable;
    }

    public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
    }

    public void onLoad(PhaseEvent event) {
	try {
	    if(isFormFlag()){
        	   // PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_MODULE_ID( CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
        	    DUMMY_BEAN.setUI_M_PLSP_MODULE_ID( CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
        	    helper.WHEN_NEW_FORM_INSTANCE(DUMMY_BEAN,this);
        	    setFormFlag(false);
	    }
	    if (isBlockFlag()) {
		if (PP_LIFE_POL_SCH_PRN_BEAN.getROWID() != null) {
		    helper.PRE_QUERY(PP_LIFE_POL_SCH_PRN_BEAN,DUMMY_BEAN);
		    helper.executeQuery(this);
		    helper.POST_QUERY(PP_LIFE_POL_SCH_PRN_BEAN,DUMMY_BEAN);
		} 
		    //COMP_UI_M_PLSP_MODULE_ID.resetValue();
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public HtmlInputText getCOMP_PLSP_SRNO() {
        return COMP_PLSP_SRNO;
    }

    public void setCOMP_PLSP_SRNO(HtmlInputText comp_plsp_srno) {
        COMP_PLSP_SRNO = comp_plsp_srno;
    }

    public HtmlOutputLabel getCOMP_PLSP_SRNO_LABEL() {
        return COMP_PLSP_SRNO_LABEL;
    }

    public void setCOMP_PLSP_SRNO_LABEL(HtmlOutputLabel comp_plsp_srno_label) {
        COMP_PLSP_SRNO_LABEL = comp_plsp_srno_label;
    }
    
    public String backToSearch() {
	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

    public DUMMY getDUMMY_BEAN() {
        return DUMMY_BEAN;
    }

    public void setDUMMY_BEAN(DUMMY dummy_bean) {
        DUMMY_BEAN = dummy_bean;
    }
}

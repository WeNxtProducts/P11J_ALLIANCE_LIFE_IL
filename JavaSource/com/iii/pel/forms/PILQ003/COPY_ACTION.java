package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class COPY_ACTION extends CommonAction {

    private HtmlSelectOneMenu COMP_UI_M_POL_NEW_YN;

    private HtmlOutputLabel COMP_UI_M_POL_NEW_YN_LABEL;

    private HtmlOutputLabel COMP_UI_M_COPY_POL_ISSUE_DT_LABEL;

    private HtmlCalendar COMP_UI_M_COPY_POL_ISSUE_DT;

    private HtmlOutputLabel COMP_UI_M_COPY_POL_NO_LABEL;

    private HtmlInputText COMP_UI_M_COPY_POL_NO;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_ASS_DTL;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_CHARGE;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_BROKER;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_CHECK_LIST;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_POL_COND_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_POL_COND;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_MED_HIST_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_MED_HIST;

    private HtmlOutputLabel COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_APPL_PROD;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PROP_POL_NO;

    private HtmlCommandButton COMP_UI_M_COPY_CANCEL;

    private HtmlCommandButton COMP_UI_M_COPY_OK;

    private HtmlCommandButton COMP_UI_M_BUT_COPY;

    private COPY COPY_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private COPY_HELPER helper;

    private List<SelectItem> listUI_M_POL_NEW_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_ASS_DTL = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_BENEF_DTL = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_ADDL_COVER = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_DISC_LOAD = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_CHARGE = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_BROKER = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_CHECK_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_POL_COND = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_MED_HIST = new ArrayList<SelectItem>();

    private List<SelectItem> listUI_M_COPY_PT_IL_APPL_PROD = new ArrayList<SelectItem>();

    public COPY_ACTION() {
	COPY_BEAN = new COPY();
	helper = new COPY_HELPER();
	instantiateAllComponent();
	COMP_UI_M_COPY_POL_NO_LABEL = new HtmlOutputLabel();
	setListItemValues();
    }
    
    public void setListItemValues() {
	Connection connection = null;
	
	try {
	    connection = CommonUtils.getConnection();
	    
	    setListUI_M_POL_NEW_YN( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_POL_NEW_YN", "EXISTNEW"));
	    setListUI_M_COPY_PT_IL_POL_ASS_DTL( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_ASS_DTL", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_BENEF_DTL( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_BENEF_DTL", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_ADDL_COVER( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_ADDL_COVER", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_DISC_LOAD( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_DISC_LOAD", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_CHARGE( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_CHARGE", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_BROKER( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_BROKER", "YESNO"));
	    setListUI_M_COPY_PT_IL_CHECK_LIST( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_CHECK_LIST", "YESNO"));
	    setListUI_M_COPY_PT_IL_POL_COND( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_POL_COND", "YESNO"));
	    setListUI_M_COPY_PT_IL_MED_HIST( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_MED_HIST", "YESNO"));
	    setListUI_M_COPY_PT_IL_APPL_PROD( ListItemUtil.getDropDownListValue(
		    connection, "PILT002_APAC", "COPY",
		    "COPY.M_COPY_PT_IL_APPL_PROD", "YESNO"));
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL() {
	return COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_APPL_PROD() {
	return COMP_UI_M_COPY_PT_IL_APPL_PROD;
    }

    public void setCOMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL(
	    HtmlOutputLabel COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL) {
	this.COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL = COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_APPL_PROD(
	    HtmlSelectOneMenu COMP_UI_M_COPY_PT_IL_APPL_PROD) {
	this.COMP_UI_M_COPY_PT_IL_APPL_PROD = COMP_UI_M_COPY_PT_IL_APPL_PROD;
    }

    public COPY getCOPY_BEAN() {
	return COPY_BEAN;
    }

    public void setCOPY_BEAN(COPY COPY_BEAN) {
	this.COPY_BEAN = COPY_BEAN;
    }

    public void saveRecord() {
	try {
	    if (getCOPY_BEAN().getROWID() != null) {
		new CRUDHandler().executeInsert(getCOPY_BEAN(), CommonUtils
			.getConnection());
	    } else {
		new CRUDHandler().executeInsert(getCOPY_BEAN(), CommonUtils
			.getConnection());
	    }
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<SelectItem> getListUI_M_POL_NEW_YN() {
	if (listUI_M_POL_NEW_YN.size() == 0) {
	    listUI_M_POL_NEW_YN.clear();
	    try {
		listUI_M_POL_NEW_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_POL_NEW_YN;
    }

    public void setListUI_M_POL_NEW_YN(List<SelectItem> listUI_M_POL_NEW_YN) {
	this.listUI_M_POL_NEW_YN = listUI_M_POL_NEW_YN;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_ASS_DTL() {
	if (listUI_M_COPY_PT_IL_POL_ASS_DTL.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_ASS_DTL.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_ASS_DTL = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_ASS_DTL;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_BENEF_DTL() {
	if (listUI_M_COPY_PT_IL_POL_BENEF_DTL.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_BENEF_DTL.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_BENEF_DTL = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_BENEF_DTL;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_ADDL_COVER() {
	if (listUI_M_COPY_PT_IL_POL_ADDL_COVER.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_ADDL_COVER.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_ADDL_COVER = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_ADDL_COVER;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_DISC_LOAD() {
	if (listUI_M_COPY_PT_IL_POL_DISC_LOAD.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_DISC_LOAD.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_DISC_LOAD = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_DISC_LOAD;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_CHARGE() {
	if (listUI_M_COPY_PT_IL_POL_CHARGE.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_CHARGE.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_CHARGE = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_CHARGE;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_BROKER() {
	if (listUI_M_COPY_PT_IL_POL_BROKER.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_BROKER.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_BROKER = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_BROKER;
    }

    public void setListUI_M_COPY_PT_IL_POL_BROKER(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_BROKER) {
	this.listUI_M_COPY_PT_IL_POL_BROKER = listUI_M_COPY_PT_IL_POL_BROKER;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_CHECK_LIST() {
	if (listUI_M_COPY_PT_IL_CHECK_LIST.size() == 0) {
	    listUI_M_COPY_PT_IL_CHECK_LIST.clear();
	    try {
		listUI_M_COPY_PT_IL_CHECK_LIST = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_CHECK_LIST;
    }

    public void setListUI_M_COPY_PT_IL_CHECK_LIST(
	    List<SelectItem> listUI_M_COPY_PT_IL_CHECK_LIST) {
	this.listUI_M_COPY_PT_IL_CHECK_LIST = listUI_M_COPY_PT_IL_CHECK_LIST;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_POL_COND() {
	if (listUI_M_COPY_PT_IL_POL_COND.size() == 0) {
	    listUI_M_COPY_PT_IL_POL_COND.clear();
	    try {
		listUI_M_COPY_PT_IL_POL_COND = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_POL_COND;
    }

    public void setListUI_M_COPY_PT_IL_POL_COND(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_COND) {
	this.listUI_M_COPY_PT_IL_POL_COND = listUI_M_COPY_PT_IL_POL_COND;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_MED_HIST() {
	if (listUI_M_COPY_PT_IL_MED_HIST.size() == 0) {
	    listUI_M_COPY_PT_IL_MED_HIST.clear();
	    try {
		listUI_M_COPY_PT_IL_MED_HIST = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_MED_HIST;
    }

    public void setListUI_M_COPY_PT_IL_MED_HIST(
	    List<SelectItem> listUI_M_COPY_PT_IL_MED_HIST) {
	this.listUI_M_COPY_PT_IL_MED_HIST = listUI_M_COPY_PT_IL_MED_HIST;
    }

    public List<SelectItem> getListUI_M_COPY_PT_IL_APPL_PROD() {
	if (listUI_M_COPY_PT_IL_APPL_PROD.size() == 0) {
	    listUI_M_COPY_PT_IL_APPL_PROD.clear();
	    try {
		listUI_M_COPY_PT_IL_APPL_PROD = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_COPY_PT_IL_APPL_PROD;
    }

    public void setListUI_M_COPY_PT_IL_APPL_PROD(
	    List<SelectItem> listUI_M_COPY_PT_IL_APPL_PROD) {
	this.listUI_M_COPY_PT_IL_APPL_PROD = listUI_M_COPY_PT_IL_APPL_PROD;
    }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }


    public List<com.iii.premia.common.bean.LovBean> lovUI_M_COPY_POL_NO(Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('COPY.M_COPY_POL_NO',:PT_IL_POLICY.POL_DS_TYPE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "COPY",
		    "M_COPY_POL_NO", compositeAction
			    .getPT_IL_POLICY_ACTION_BEAN()
			    .getPT_IL_POLICY_BEAN().getPOL_DS_TYPE(), null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    
    public void onLoad(PhaseEvent event) {
	try {
	    COPY_HELPER copy_helper = new COPY_HELPER();
	    if (isBlockFlag()) {
	    }
	    if(isFormFlag()){
		copy_helper.WHEN_CREATE_RECORD(COPY_BEAN,this);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public HtmlSelectOneMenu getCOMP_UI_M_POL_NEW_YN() {
	return COMP_UI_M_POL_NEW_YN;
    }

    public void setCOMP_UI_M_POL_NEW_YN(HtmlSelectOneMenu comp_ui_m_pol_new_yn) {
	COMP_UI_M_POL_NEW_YN = comp_ui_m_pol_new_yn;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_NEW_YN_LABEL() {
	return COMP_UI_M_POL_NEW_YN_LABEL;
    }

    public void setCOMP_UI_M_POL_NEW_YN_LABEL(
	    HtmlOutputLabel comp_ui_m_pol_new_yn_label) {
	COMP_UI_M_POL_NEW_YN_LABEL = comp_ui_m_pol_new_yn_label;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_POL_ISSUE_DT_LABEL() {
	return COMP_UI_M_COPY_POL_ISSUE_DT_LABEL;
    }

    public void setCOMP_UI_M_COPY_POL_ISSUE_DT_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pol_issue_dt_label) {
	COMP_UI_M_COPY_POL_ISSUE_DT_LABEL = comp_ui_m_copy_pol_issue_dt_label;
    }

    public HtmlCalendar getCOMP_UI_M_COPY_POL_ISSUE_DT() {
	return COMP_UI_M_COPY_POL_ISSUE_DT;
    }

    public void setCOMP_UI_M_COPY_POL_ISSUE_DT(
	    HtmlCalendar comp_ui_m_copy_pol_issue_dt) {
	COMP_UI_M_COPY_POL_ISSUE_DT = comp_ui_m_copy_pol_issue_dt;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_POL_NO_LABEL() {
	return COMP_UI_M_COPY_POL_NO_LABEL;
    }

    public void setCOMP_UI_M_COPY_POL_NO_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pol_no_label) {
	COMP_UI_M_COPY_POL_NO_LABEL = comp_ui_m_copy_pol_no_label;
    }

    public HtmlInputText getCOMP_UI_M_COPY_POL_NO() {
	return COMP_UI_M_COPY_POL_NO;
    }

    public void setCOMP_UI_M_COPY_POL_NO(HtmlInputText comp_ui_m_copy_pol_no) {
	COMP_UI_M_COPY_POL_NO = comp_ui_m_copy_pol_no;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_ass_dtl_label) {
	COMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL = comp_ui_m_copy_pt_il_pol_ass_dtl_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_ASS_DTL() {
	return COMP_UI_M_COPY_PT_IL_POL_ASS_DTL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_ASS_DTL(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_ass_dtl) {
	COMP_UI_M_COPY_PT_IL_POL_ASS_DTL = comp_ui_m_copy_pt_il_pol_ass_dtl;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_benef_dtl_label) {
	COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL = comp_ui_m_copy_pt_il_pol_benef_dtl_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_BENEF_DTL() {
	return COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_BENEF_DTL(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_benef_dtl) {
	COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL = comp_ui_m_copy_pt_il_pol_benef_dtl;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_addl_cover_label) {
	COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL = comp_ui_m_copy_pt_il_pol_addl_cover_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER() {
	return COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_addl_cover) {
	COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER = comp_ui_m_copy_pt_il_pol_addl_cover;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_disc_load_label) {
	COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL = comp_ui_m_copy_pt_il_pol_disc_load_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_DISC_LOAD() {
	return COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_DISC_LOAD(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_disc_load) {
	COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD = comp_ui_m_copy_pt_il_pol_disc_load;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_charge_label) {
	COMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL = comp_ui_m_copy_pt_il_pol_charge_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_CHARGE() {
	return COMP_UI_M_COPY_PT_IL_POL_CHARGE;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_CHARGE(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_charge) {
	COMP_UI_M_COPY_PT_IL_POL_CHARGE = comp_ui_m_copy_pt_il_pol_charge;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_broker_label) {
	COMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL = comp_ui_m_copy_pt_il_pol_broker_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_BROKER() {
	return COMP_UI_M_COPY_PT_IL_POL_BROKER;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_BROKER(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_broker) {
	COMP_UI_M_COPY_PT_IL_POL_BROKER = comp_ui_m_copy_pt_il_pol_broker;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL() {
	return COMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_check_list_label) {
	COMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL = comp_ui_m_copy_pt_il_check_list_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_CHECK_LIST() {
	return COMP_UI_M_COPY_PT_IL_CHECK_LIST;
    }

    public void setCOMP_UI_M_COPY_PT_IL_CHECK_LIST(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_check_list) {
	COMP_UI_M_COPY_PT_IL_CHECK_LIST = comp_ui_m_copy_pt_il_check_list;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_POL_COND_LABEL() {
	return COMP_UI_M_COPY_PT_IL_POL_COND_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_COND_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_pol_cond_label) {
	COMP_UI_M_COPY_PT_IL_POL_COND_LABEL = comp_ui_m_copy_pt_il_pol_cond_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_POL_COND() {
	return COMP_UI_M_COPY_PT_IL_POL_COND;
    }

    public void setCOMP_UI_M_COPY_PT_IL_POL_COND(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_pol_cond) {
	COMP_UI_M_COPY_PT_IL_POL_COND = comp_ui_m_copy_pt_il_pol_cond;
    }

    public HtmlOutputLabel getCOMP_UI_M_COPY_PT_IL_MED_HIST_LABEL() {
	return COMP_UI_M_COPY_PT_IL_MED_HIST_LABEL;
    }

    public void setCOMP_UI_M_COPY_PT_IL_MED_HIST_LABEL(
	    HtmlOutputLabel comp_ui_m_copy_pt_il_med_hist_label) {
	COMP_UI_M_COPY_PT_IL_MED_HIST_LABEL = comp_ui_m_copy_pt_il_med_hist_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_COPY_PT_IL_MED_HIST() {
	return COMP_UI_M_COPY_PT_IL_MED_HIST;
    }

    public void setCOMP_UI_M_COPY_PT_IL_MED_HIST(
	    HtmlSelectOneMenu comp_ui_m_copy_pt_il_med_hist) {
	COMP_UI_M_COPY_PT_IL_MED_HIST = comp_ui_m_copy_pt_il_med_hist;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROP_POL_NO() {
	return COMP_UI_M_BUT_LOV_PROP_POL_NO;
    }

    public void setCOMP_UI_M_BUT_LOV_PROP_POL_NO(
	    HtmlCommandButton comp_ui_m_but_lov_prop_pol_no) {
	COMP_UI_M_BUT_LOV_PROP_POL_NO = comp_ui_m_but_lov_prop_pol_no;
    }

    public HtmlCommandButton getCOMP_UI_M_COPY_CANCEL() {
	return COMP_UI_M_COPY_CANCEL;
    }

    public void setCOMP_UI_M_COPY_CANCEL(HtmlCommandButton comp_ui_m_copy_cancel) {
	COMP_UI_M_COPY_CANCEL = comp_ui_m_copy_cancel;
    }

    public HtmlCommandButton getCOMP_UI_M_COPY_OK() {
	return COMP_UI_M_COPY_OK;
    }

    public void setCOMP_UI_M_COPY_OK(HtmlCommandButton comp_ui_m_copy_ok) {
	COMP_UI_M_COPY_OK = comp_ui_m_copy_ok;
    }

    public PILQ003_COMPOSITE_ACTION getCompositeAction() {
	return compositeAction;
    }

    public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
	this.compositeAction = compositeAction;
    }

    public COPY_HELPER getHelper() {
	return helper;
    }

    public void setHelper(COPY_HELPER helper) {
	this.helper = helper;
    }

    public void setListUI_M_COPY_PT_IL_POL_ASS_DTL(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_ASS_DTL) {
	this.listUI_M_COPY_PT_IL_POL_ASS_DTL = listUI_M_COPY_PT_IL_POL_ASS_DTL;
    }

    public void setListUI_M_COPY_PT_IL_POL_BENEF_DTL(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_BENEF_DTL) {
	this.listUI_M_COPY_PT_IL_POL_BENEF_DTL = listUI_M_COPY_PT_IL_POL_BENEF_DTL;
    }

    public void setListUI_M_COPY_PT_IL_POL_ADDL_COVER(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_ADDL_COVER) {
	this.listUI_M_COPY_PT_IL_POL_ADDL_COVER = listUI_M_COPY_PT_IL_POL_ADDL_COVER;
    }

    public void setListUI_M_COPY_PT_IL_POL_DISC_LOAD(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_DISC_LOAD) {
	this.listUI_M_COPY_PT_IL_POL_DISC_LOAD = listUI_M_COPY_PT_IL_POL_DISC_LOAD;
    }

    public void setListUI_M_COPY_PT_IL_POL_CHARGE(
	    List<SelectItem> listUI_M_COPY_PT_IL_POL_CHARGE) {
	this.listUI_M_COPY_PT_IL_POL_CHARGE = listUI_M_COPY_PT_IL_POL_CHARGE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
	return COMP_UI_M_BUT_COPY;
    }

    public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton comp_ui_m_but_copy) {
	COMP_UI_M_BUT_COPY = comp_ui_m_but_copy;
    }
   
    public  String  copyOkButtonAction(){
	COPY_HELPER copy_helper = new COPY_HELPER();
	 
	String  outCome = null;
	Connection con = null;
	ResultSet rs1 = null;
	CRUDHandler handler = new CRUDHandler();
	Object[] c1values = null;
	String ROW_ID = null;
	try {
	    con = CommonUtils.getConnection();
	    if(COPY_BEAN.getUI_M_COPY_POL_NO()!=null){
		outCome = copy_helper.UI_M_COPY_OK_WHEN_BUTTON_PRESSED(compositeAction);
		CommonUtils.getConnection().commit();
	    	String rowid_query = "SELECT ROWID FROM PT_IL_POLICY WHERE POL_NO = ?";
	    	c1values = new Object[]{COPY_BEAN.getUI_M_COPY_POL_NO()};
	    	rs1 = handler.executeSelectStatement(rowid_query, con, c1values);
	    	while(rs1.next()){
	    		ROW_ID = rs1.getString(1);
	    	}
	    	// setting the new copied policy to the bean
	    	compositeAction = new PILQ003_COMPOSITE_ACTION();
	    	compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setROWID(ROW_ID);
	    	CommonUtils.setGlobalObject("PILQ003_COMPOSITE_ACTION", compositeAction);
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return outCome;
    }
    public  String  copyCancelButtonAction(){
	String  outCome = null;
	try {
	    outCome =  "PILT002_APAC_PT_IL_POLICY";
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return outCome;
    }
    
    // CALL THE Validator
    
    public void validateUI_M_COPY_POL_ISSUE_DT(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	Date curDate = (Date) value;
	try {
	    helper.UI_M_COPY_POL_ISSUE_DT_WHEN_VALIDATE_ITEM( curDate, this, 
		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
		    
	    COMP_UI_M_COPY_POL_ISSUE_DT.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_COPY_POL_ISSUE_DT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
   
    public void validateUI_M_COPY_POL_NO(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	 
	try {
	    COPY_BEAN.setUI_M_COPY_POL_NO(value.toString());
	    helper.UI_M_COPY_POL_NO_WHEN_VALIDATE_ITEM(COPY_BEAN,value.toString()) ;
	    
	    COMP_UI_M_COPY_POL_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_COPY_POL_NO",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void validateUI_M_COPY_PT_IL_POL_ASS_DTL(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	 
	try {
	    helper.UI_M_COPY_PT_IL_POL_ASS_DTL_WHEN_VALIDATE_ITEM(this, value.toString()) ;
	    
	    COMP_UI_M_COPY_PT_IL_POL_ASS_DTL.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_COPY_PT_IL_POL_ASS_DTL",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    

    public void validateListChangedUI_M_COPY_PT_IL_POL_ASS_DTL(ActionEvent actionEvent)
    throws ValidatorException {

        UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
        Object value = uiInput.getSubmittedValue();
        try {
            helper.UI_M_COPY_PT_IL_POL_ASS_DTL_WHEN_VALIDATE_ITEM(this, value.toString()) ;
	    COMP_UI_M_COPY_PT_IL_POL_ASS_DTL.resetValue();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ValidatorException(new FacesMessage(exception
        	    .getMessage()));
        } finally {
            try {
        	ErrorHelpUtil.getWarningForProcedure(CommonUtils
        		.getConnection(), "UI_M_COPY_PT_IL_POL_ASS_DTL", getWarningMap());
            } catch (Exception e) {
        	e.printStackTrace();
            }
        }
    }
    
    public void validateUI_M_POL_NEW_YN(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	
	try {
	    helper.UI_M_POL_NEW_YN_WHEN_VALIDATE_ITEM( this, value.toString()) ;
	    
	    COMP_UI_M_POL_NEW_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_POL_NEW_YN",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
   
    
    public void validateListChangedUI_M_POL_NEW_YN(ActionEvent actionEvent)
    throws ValidatorException {

        UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
        Object value = uiInput.getSubmittedValue();
        try {
            helper.UI_M_POL_NEW_YN_WHEN_VALIDATE_ITEM( this, value.toString()) ;
	    COMP_UI_M_POL_NEW_YN.resetValue();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ValidatorException(new FacesMessage(exception
        	    .getMessage()));
        } finally {
            try {
        	ErrorHelpUtil.getWarningForProcedure(CommonUtils
        		.getConnection(), "UI_M_POL_NEW_YN", getWarningMap());
            } catch (Exception e) {
        	e.printStackTrace();
            }
        }
    }

	/**
	 * Instantiates all components in COPY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_COPY_POL_NO				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UI_M_POL_NEW_YN_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_COPY_POL_ISSUE_DT_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_POL_NO_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_ASS_DTL_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_CHARGE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_BROKER_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_CHECK_LIST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_POL_COND_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_MED_HIST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_COPY_PT_IL_APPL_PROD_LABEL		 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_POL_NEW_YN				 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_ASS_DTL		 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_BENEF_DTL		 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_ADDL_COVER		 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_DISC_LOAD		 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_CHARGE			 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_BROKER			 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_CHECK_LIST			 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_POL_COND			 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_MED_HIST			 = new HtmlSelectOneMenu();
		COMP_UI_M_COPY_PT_IL_APPL_PROD			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_COPY_POL_ISSUE_DT			 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_PROP_POL_NO			 = new HtmlCommandButton();
		COMP_UI_M_COPY_CANCEL				 = new HtmlCommandButton();
		COMP_UI_M_COPY_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_COPY				 = new HtmlCommandButton();

	}


}

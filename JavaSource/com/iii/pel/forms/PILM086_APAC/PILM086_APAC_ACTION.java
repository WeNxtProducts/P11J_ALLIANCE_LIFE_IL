package com.iii.pel.forms.PILM086_APAC;

import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILM086_APAC_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_GROUP_ID_LABEL;
	
	private HtmlInputText COMP_GROUP_ID;
	
	private HtmlInputText COMP_GROUP_ID_DESC;
	
	private HtmlOutputLabel COMP_PDS_CODE_FM_LABEL;
	
	private HtmlInputText COMP_PDS_CODE_FM;
	
	private HtmlInputText COMP_PDS_CODE_FM_DESC;
	
	private HtmlOutputLabel COMP_PDS_CODE_TO_LABEL;
	
	private HtmlInputText COMP_PDS_CODE_TO;
	
	private HtmlInputText COMP_PDS_CODE_TO_DESC;
	
	private HtmlOutputLabel COMP_SRC_BUS_CODE_FM_LABEL;
	
	private HtmlInputText COMP_SRC_BUS_CODE_FM;
	
	private HtmlInputText COMP_SRC_BUS_CODE_FM_DESC;
	
	private HtmlOutputLabel COMP_SRC_BUS_CODE_TO_LABEL;
	
	private HtmlInputText COMP_SRC_BUS_CODE_TO;
	
	private HtmlInputText COMP_SRC_BUS_CODE_TO_DESC;
	
	private HtmlOutputLabel COMP_COVER_CODE_FM_LABEL;
	
	private HtmlInputText COMP_COVER_CODE_FM;
	
	private HtmlInputText COMP_COVER_CODE_FM_DESC;
	
	private HtmlOutputLabel COMP_COVER_CODE_TO_LABEL;
	
	private HtmlInputText COMP_COVER_CODE_TO;
	
	private HtmlInputText COMP_COVER_CODE_TO_DESC;
	
	/*Commentted by saritha on 08-07-2017 for Business Rule Master*/
	
	/*private HtmlOutputLabel COMP_PROD_CODE_LABEL;

	private HtmlInputText COMP_PROD_CODE;
	
	private HtmlInputText COMP_PROD_CODE_DESC;*/
	
	/*End*/
	
	private HtmlOutputLabel COMP_DATE_FM_LABEL;
	
	private HtmlCalendar COMP_DATE_FM;
	
	private HtmlOutputLabel COMP_DATE_TO_LABEL;
	
	private HtmlCalendar COMP_DATE_TO;
	
	private HtmlOutputLabel COMP_TXN_DISP_TEXT_LABEL;
	
	private HtmlInputText COMP_TXN_DISP_TEXT;
	
	private HtmlOutputLabel COMP_HINT_LABEL;
	
	private HtmlInputText COMP_HINT;
	
	public PILM086_APAC_COMPOSITE_ACTION compositeAction;
	
	private PILM086_APAC_BEAN PILM086_BEAN;
	
	private PILM086_APAC_HELPER helper;
	
	private PILM086_APAC_DELEGATE delegate;
	
	private HtmlSelectOneMenu COMP_ERR_FLAG;
	
	private HtmlOutputLabel COMP_ERR_FLAG_LABEL;
	
	private HtmlSelectOneMenu COMP_APPL_LEVEL;
	
	private HtmlOutputLabel COMP_APPL_LEVEL_LABEL;
	
	private HtmlSelectOneMenu COMP_ASSR_TYP;
	
	private HtmlOutputLabel COMP_ASSR_TYP_LABEL;
	
	private HtmlSelectOneMenu COMP_TXN_DISP_TYPE;
	
	private HtmlOutputLabel COMP_TXN_DISP_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_MOD_VALUE_YN;
	
	private HtmlOutputLabel COMP_MOD_VALUE_YN_LABEL;
	
	private List<LovBean> lovList = new ArrayList<LovBean>();
	
	private List<SelectItem> listASSR_TYP = new ArrayList<SelectItem>();
	
	private List<SelectItem> listERR_FLAG = new ArrayList<SelectItem>();
	
	private List<SelectItem> listAPPL_LEVEL = new ArrayList<SelectItem>();
	
	private List<SelectItem> listMOD_VALUE_YN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listTXN_DISP_TYPE = new ArrayList<SelectItem>();
	
	
	
	public PILM086_APAC_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PILM086_APAC_HELPER helper) {
		this.helper = helper;
	}
	public PILM086_APAC_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PILM086_APAC_DELEGATE delegate) {
		this.delegate = delegate;
	}
	public HtmlOutputLabel getCOMP_TXN_DISP_TEXT_LABEL() {
		return COMP_TXN_DISP_TEXT_LABEL;
	}
	public void setCOMP_TXN_DISP_TEXT_LABEL(HtmlOutputLabel cOMP_TXN_DISP_TEXT_LABEL) {
		COMP_TXN_DISP_TEXT_LABEL = cOMP_TXN_DISP_TEXT_LABEL;
	}
	public HtmlInputText getCOMP_TXN_DISP_TEXT() {
		return COMP_TXN_DISP_TEXT;
	}
	public void setCOMP_TXN_DISP_TEXT(HtmlInputText cOMP_TXN_DISP_TEXT) {
		COMP_TXN_DISP_TEXT = cOMP_TXN_DISP_TEXT;
	}
	public HtmlOutputLabel getCOMP_HINT_LABEL() {
		return COMP_HINT_LABEL;
	}
	public void setCOMP_HINT_LABEL(HtmlOutputLabel cOMP_HINT_LABEL) {
		COMP_HINT_LABEL = cOMP_HINT_LABEL;
	}
	public HtmlInputText getCOMP_HINT() {
		return COMP_HINT;
	}
	public void setCOMP_HINT(HtmlInputText cOMP_HINT) {
		COMP_HINT = cOMP_HINT;
	}
	public HtmlSelectOneMenu getCOMP_TXN_DISP_TYPE() {
		return COMP_TXN_DISP_TYPE;
	}
	public void setCOMP_TXN_DISP_TYPE(HtmlSelectOneMenu cOMP_TXN_DISP_TYPE) {
		COMP_TXN_DISP_TYPE = cOMP_TXN_DISP_TYPE;
	}
	public HtmlOutputLabel getCOMP_TXN_DISP_TYPE_LABEL() {
		return COMP_TXN_DISP_TYPE_LABEL;
	}
	public void setCOMP_TXN_DISP_TYPE_LABEL(HtmlOutputLabel cOMP_TXN_DISP_TYPE_LABEL) {
		COMP_TXN_DISP_TYPE_LABEL = cOMP_TXN_DISP_TYPE_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_MOD_VALUE_YN() {
		return COMP_MOD_VALUE_YN;
	}
	public void setCOMP_MOD_VALUE_YN(HtmlSelectOneMenu cOMP_MOD_VALUE_YN) {
		COMP_MOD_VALUE_YN = cOMP_MOD_VALUE_YN;
	}
	public HtmlOutputLabel getCOMP_MOD_VALUE_YN_LABEL() {
		return COMP_MOD_VALUE_YN_LABEL;
	}
	public void setCOMP_MOD_VALUE_YN_LABEL(HtmlOutputLabel cOMP_MOD_VALUE_YN_LABEL) {
		COMP_MOD_VALUE_YN_LABEL = cOMP_MOD_VALUE_YN_LABEL;
	}
	public List<SelectItem> getListMOD_VALUE_YN() {
		if (listMOD_VALUE_YN.size() == 0) {
			listMOD_VALUE_YN.clear();
			try {
				listMOD_VALUE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMOD_VALUE_YN;
	}
	public void setListMOD_VALUE_YN(List<SelectItem> listMOD_VALUE_YN) {
		this.listMOD_VALUE_YN = listMOD_VALUE_YN;
	}
	public List<SelectItem> getListTXN_DISP_TYPE() {
		if (listTXN_DISP_TYPE.size() == 0) {
			listTXN_DISP_TYPE.clear();
			try {
				listTXN_DISP_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTXN_DISP_TYPE;
	}
	public void setListTXN_DISP_TYPE(List<SelectItem> listTXN_DISP_TYPE) {
		this.listTXN_DISP_TYPE = listTXN_DISP_TYPE;
	}
	public List<SelectItem> getListERR_FLAG() {
		if (listERR_FLAG.size() == 0) {
			listERR_FLAG.clear();
			try {
				listERR_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listERR_FLAG;
	}
	public void setListERR_FLAG(List<SelectItem> listERR_FLAG) {
		this.listERR_FLAG = listERR_FLAG;
	}
	public List<SelectItem> getListAPPL_LEVEL() {
		if (listAPPL_LEVEL.size() == 0) {
			listAPPL_LEVEL.clear();
			try {
				listAPPL_LEVEL = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listAPPL_LEVEL;
	}
	public void setListAPPL_LEVEL(List<SelectItem> listAPPL_LEVEL) {
		this.listAPPL_LEVEL = listAPPL_LEVEL;
	}
	public HtmlSelectOneMenu getCOMP_ERR_FLAG() {
		return COMP_ERR_FLAG;
	}
	public void setCOMP_ERR_FLAG(HtmlSelectOneMenu cOMP_ERR_FLAG) {
		COMP_ERR_FLAG = cOMP_ERR_FLAG;
	}
	public HtmlOutputLabel getCOMP_ERR_FLAG_LABEL() {
		return COMP_ERR_FLAG_LABEL;
	}
	public void setCOMP_ERR_FLAG_LABEL(HtmlOutputLabel cOMP_ERR_FLAG_LABEL) {
		COMP_ERR_FLAG_LABEL = cOMP_ERR_FLAG_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_APPL_LEVEL() {
		return COMP_APPL_LEVEL;
	}
	public void setCOMP_APPL_LEVEL(HtmlSelectOneMenu cOMP_APPL_LEVEL) {
		COMP_APPL_LEVEL = cOMP_APPL_LEVEL;
	}
	public HtmlOutputLabel getCOMP_APPL_LEVEL_LABEL() {
		return COMP_APPL_LEVEL_LABEL;
	}
	public void setCOMP_APPL_LEVEL_LABEL(HtmlOutputLabel cOMP_APPL_LEVEL_LABEL) {
		COMP_APPL_LEVEL_LABEL = cOMP_APPL_LEVEL_LABEL;
	}
	public HtmlOutputLabel getCOMP_DATE_TO_LABEL() {
		return COMP_DATE_TO_LABEL;
	}
	public void setCOMP_DATE_TO_LABEL(HtmlOutputLabel cOMP_DATE_TO_LABEL) {
		COMP_DATE_TO_LABEL = cOMP_DATE_TO_LABEL;
	}
	public HtmlCalendar getCOMP_DATE_TO() {
		return COMP_DATE_TO;
	}
	public void setCOMP_DATE_TO(HtmlCalendar cOMP_DATE_TO) {
		COMP_DATE_TO = cOMP_DATE_TO;
	}
	public HtmlOutputLabel getCOMP_DATE_FM_LABEL() {
		return COMP_DATE_FM_LABEL;
	}
	public void setCOMP_DATE_FM_LABEL(HtmlOutputLabel cOMP_DATE_FM_LABEL) {
		COMP_DATE_FM_LABEL = cOMP_DATE_FM_LABEL;
	}
	public HtmlCalendar getCOMP_DATE_FM() {
		return COMP_DATE_FM;
	}
	public void setCOMP_DATE_FM(HtmlCalendar cOMP_DATE_FM) {
		COMP_DATE_FM = cOMP_DATE_FM;
	}
	public HtmlOutputLabel getCOMP_SRC_BUS_CODE_FM_LABEL() {
		return COMP_SRC_BUS_CODE_FM_LABEL;
	}
	public void setCOMP_SRC_BUS_CODE_FM_LABEL(
			HtmlOutputLabel cOMP_SRC_BUS_CODE_FM_LABEL) {
		COMP_SRC_BUS_CODE_FM_LABEL = cOMP_SRC_BUS_CODE_FM_LABEL;
	}
	public HtmlInputText getCOMP_SRC_BUS_CODE_FM() {
		return COMP_SRC_BUS_CODE_FM;
	}
	public void setCOMP_SRC_BUS_CODE_FM(HtmlInputText cOMP_SRC_BUS_CODE_FM) {
		COMP_SRC_BUS_CODE_FM = cOMP_SRC_BUS_CODE_FM;
	}
	public HtmlInputText getCOMP_SRC_BUS_CODE_FM_DESC() {
		return COMP_SRC_BUS_CODE_FM_DESC;
	}
	public void setCOMP_SRC_BUS_CODE_FM_DESC(HtmlInputText cOMP_SRC_BUS_CODE_FM_DESC) {
		COMP_SRC_BUS_CODE_FM_DESC = cOMP_SRC_BUS_CODE_FM_DESC;
	}
	public HtmlOutputLabel getCOMP_SRC_BUS_CODE_TO_LABEL() {
		return COMP_SRC_BUS_CODE_TO_LABEL;
	}
	public void setCOMP_SRC_BUS_CODE_TO_LABEL(
			HtmlOutputLabel cOMP_SRC_BUS_CODE_TO_LABEL) {
		COMP_SRC_BUS_CODE_TO_LABEL = cOMP_SRC_BUS_CODE_TO_LABEL;
	}
	public HtmlInputText getCOMP_SRC_BUS_CODE_TO() {
		return COMP_SRC_BUS_CODE_TO;
	}
	public void setCOMP_SRC_BUS_CODE_TO(HtmlInputText cOMP_SRC_BUS_CODE_TO) {
		COMP_SRC_BUS_CODE_TO = cOMP_SRC_BUS_CODE_TO;
	}
	public HtmlInputText getCOMP_SRC_BUS_CODE_TO_DESC() {
		return COMP_SRC_BUS_CODE_TO_DESC;
	}
	public void setCOMP_SRC_BUS_CODE_TO_DESC(HtmlInputText cOMP_SRC_BUS_CODE_TO_DESC) {
		COMP_SRC_BUS_CODE_TO_DESC = cOMP_SRC_BUS_CODE_TO_DESC;
	}
	public HtmlOutputLabel getCOMP_COVER_CODE_FM_LABEL() {
		return COMP_COVER_CODE_FM_LABEL;
	}
	public void setCOMP_COVER_CODE_FM_LABEL(HtmlOutputLabel cOMP_COVER_CODE_FM_LABEL) {
		COMP_COVER_CODE_FM_LABEL = cOMP_COVER_CODE_FM_LABEL;
	}
	public HtmlInputText getCOMP_COVER_CODE_FM() {
		return COMP_COVER_CODE_FM;
	}
	public void setCOMP_COVER_CODE_FM(HtmlInputText cOMP_COVER_CODE_FM) {
		COMP_COVER_CODE_FM = cOMP_COVER_CODE_FM;
	}
	public HtmlInputText getCOMP_COVER_CODE_FM_DESC() {
		return COMP_COVER_CODE_FM_DESC;
	}
	public void setCOMP_COVER_CODE_FM_DESC(HtmlInputText cOMP_COVER_CODE_FM_DESC) {
		COMP_COVER_CODE_FM_DESC = cOMP_COVER_CODE_FM_DESC;
	}
	public HtmlOutputLabel getCOMP_COVER_CODE_TO_LABEL() {
		return COMP_COVER_CODE_TO_LABEL;
	}
	public void setCOMP_COVER_CODE_TO_LABEL(HtmlOutputLabel cOMP_COVER_CODE_TO_LABEL) {
		COMP_COVER_CODE_TO_LABEL = cOMP_COVER_CODE_TO_LABEL;
	}
	public HtmlInputText getCOMP_COVER_CODE_TO() {
		return COMP_COVER_CODE_TO;
	}
	public void setCOMP_COVER_CODE_TO(HtmlInputText cOMP_COVER_CODE_TO) {
		COMP_COVER_CODE_TO = cOMP_COVER_CODE_TO;
	}
	public HtmlInputText getCOMP_COVER_CODE_TO_DESC() {
		return COMP_COVER_CODE_TO_DESC;
	}
	public void setCOMP_COVER_CODE_TO_DESC(HtmlInputText cOMP_COVER_CODE_TO_DESC) {
		COMP_COVER_CODE_TO_DESC = cOMP_COVER_CODE_TO_DESC;
	}
	public HtmlOutputLabel getCOMP_PDS_CODE_FM_LABEL() {
		return COMP_PDS_CODE_FM_LABEL;
	}
	public void setCOMP_PDS_CODE_FM_LABEL(HtmlOutputLabel cOMP_PDS_CODE_FM_LABEL) {
		COMP_PDS_CODE_FM_LABEL = cOMP_PDS_CODE_FM_LABEL;
	}
	public HtmlInputText getCOMP_PDS_CODE_FM() {
		return COMP_PDS_CODE_FM;
	}
	public void setCOMP_PDS_CODE_FM(HtmlInputText cOMP_PDS_CODE_FM) {
		COMP_PDS_CODE_FM = cOMP_PDS_CODE_FM;
	}
	public HtmlInputText getCOMP_PDS_CODE_FM_DESC() {
		return COMP_PDS_CODE_FM_DESC;
	}
	public void setCOMP_PDS_CODE_FM_DESC(HtmlInputText cOMP_PDS_CODE_FM_DESC) {
		COMP_PDS_CODE_FM_DESC = cOMP_PDS_CODE_FM_DESC;
	}
	public HtmlOutputLabel getCOMP_PDS_CODE_TO_LABEL() {
		return COMP_PDS_CODE_TO_LABEL;
	}
	public void setCOMP_PDS_CODE_TO_LABEL(HtmlOutputLabel cOMP_PDS_CODE_TO_LABEL) {
		COMP_PDS_CODE_TO_LABEL = cOMP_PDS_CODE_TO_LABEL;
	}
	public HtmlInputText getCOMP_PDS_CODE_TO() {
		return COMP_PDS_CODE_TO;
	}
	public void setCOMP_PDS_CODE_TO(HtmlInputText cOMP_PDS_CODE_TO) {
		COMP_PDS_CODE_TO = cOMP_PDS_CODE_TO;
	}
	public HtmlInputText getCOMP_PDS_CODE_TO_DESC() {
		return COMP_PDS_CODE_TO_DESC;
	}
	public void setCOMP_PDS_CODE_TO_DESC(HtmlInputText cOMP_PDS_CODE_TO_DESC) {
		COMP_PDS_CODE_TO_DESC = cOMP_PDS_CODE_TO_DESC;
	}
	public HtmlSelectOneMenu getCOMP_ASSR_TYP() {
		return COMP_ASSR_TYP;
	}
	public void setCOMP_ASSR_TYP(HtmlSelectOneMenu cOMP_ASSR_TYP) {
		COMP_ASSR_TYP = cOMP_ASSR_TYP;
	}
	public HtmlOutputLabel getCOMP_ASSR_TYP_LABEL() {
		return COMP_ASSR_TYP_LABEL;
	}
	public void setCOMP_ASSR_TYP_LABEL(HtmlOutputLabel cOMP_ASSR_TYP_LABEL) {
		COMP_ASSR_TYP_LABEL = cOMP_ASSR_TYP_LABEL;
	}
	public List<SelectItem> getListASSR_TYP() {
		if (listASSR_TYP.size() == 0) {
			listASSR_TYP.clear();
			try {
				listASSR_TYP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listASSR_TYP;
	}
	public void setListASSR_TYP(List<SelectItem> listASSR_TYP) {
		this.listASSR_TYP = listASSR_TYP;
	}
	
	/*Commentted by saritha on 08-07-2017 for Business Rule Master*/
	
	/*public HtmlOutputLabel getCOMP_PROD_CODE_LABEL() {
		return COMP_PROD_CODE_LABEL;
	}
	public void setCOMP_PROD_CODE_LABEL(HtmlOutputLabel cOMP_PROD_CODE_LABEL) {
		COMP_PROD_CODE_LABEL = cOMP_PROD_CODE_LABEL;
	}
	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}
	public void setCOMP_PROD_CODE(HtmlInputText cOMP_PROD_CODE) {
		COMP_PROD_CODE = cOMP_PROD_CODE;
	}
	public HtmlInputText getCOMP_PROD_CODE_DESC() {
		return COMP_PROD_CODE_DESC;
	}
	public void setCOMP_PROD_CODE_DESC(HtmlInputText cOMP_PROD_CODE_DESC) {
		COMP_PROD_CODE_DESC = cOMP_PROD_CODE_DESC;
	}*/
	
	/*End*/
	public HtmlInputText getCOMP_GROUP_ID_DESC() {
		return COMP_GROUP_ID_DESC;
	}
	public void setCOMP_GROUP_ID_DESC(HtmlInputText cOMP_GROUP_ID_DESC) {
		COMP_GROUP_ID_DESC = cOMP_GROUP_ID_DESC;
	}	
	public List<LovBean> getLovList() {
		return lovList;
	}
	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}	
	public HtmlInputText getCOMP_GROUP_ID() {
		return COMP_GROUP_ID;
	}
	public void setCOMP_GROUP_ID(HtmlInputText cOMP_GROUP_ID) {
		COMP_GROUP_ID = cOMP_GROUP_ID;
	}
	public HtmlOutputLabel getCOMP_GROUP_ID_LABEL() {
		return COMP_GROUP_ID_LABEL;
	}
	public void setCOMP_GROUP_ID_LABEL(HtmlOutputLabel cOMP_GROUP_ID_LABEL) {
		COMP_GROUP_ID_LABEL = cOMP_GROUP_ID_LABEL;
	}	
	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PILM086_APAC_BEAN getPILM086_BEAN() {
		return PILM086_BEAN;
	}
	public void setPILM086_BEAN(PILM086_APAC_BEAN pILM086_BEAN) {
		PILM086_BEAN = pILM086_BEAN;
	}

	public PILM086_APAC_ACTION()
	{		
		PILM086_BEAN = new PILM086_APAC_BEAN();
		helper =new PILM086_APAC_HELPER();
		delegate =new PILM086_APAC_DELEGATE();
		/*Added by saritha on 08-07-2017 for Business Rule Master*/
		instantiateAllComponent();
		/*End*/
		prepareDropDownList();
		COMP_ASSR_TYP= new HtmlSelectOneMenu();
		COMP_ERR_FLAG= new HtmlSelectOneMenu();
		COMP_MOD_VALUE_YN=new HtmlSelectOneMenu();
		COMP_APPL_LEVEL=new HtmlSelectOneMenu();
		COMP_TXN_DISP_TYPE=new HtmlSelectOneMenu();	
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listASSR_TYP = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_ASSR_TYPE", "IL_ASSR_TYP");
			listERR_FLAG = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_ERR_FLAG", "UWERROR");
			listAPPL_LEVEL = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_APPL_LEVEL", "AUTO_LEVEL");
			listMOD_VALUE_YN = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_MOD_VALUE_YN", "YESNO");
			listTXN_DISP_TYPE = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_TXN_DISP_TYPE", "TXNDISPTYP");
			
			/*Added by saritha on 24-07-2017 for ssp call id ZBILQC-1732436*/ 
			listBRH_APL_SCREEN = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_HDR",
					"PM_BUS_RULE_HDR.BRH_APL_SCREEN", "SCREEN_APPL");
			/*End*/
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	 public void onLoad(PhaseEvent event) {
		 	
			try {
				
				/*Added by saritha on 10-07-2017 for ssp call id ZBILQC-1729014 Business Rule Master*/
				Connection connection = null;
				ResultSet resultset = null;
				ResultSet resultset1= null;
				connection = CommonUtils.getConnection();
				String PROD_DESC_FM=null;
				String PROD_DESC_TO=null;
				CRUDHandler handler = new CRUDHandler();
				/*End*/
				System.out.println("ONLOAD CALLED");
				if (isBlockFlag()) {
					System.out.println("ONLOAD CALLED");
					new PILM086_APAC_DELEGATE().executeSelectStatement(compositeAction);
					helper.postQuery(PILM086_BEAN);
					setBlockFlag(false);
				}
				
				/*Added by saritha on 10-07-2017 for ssp call id ZBILQC-1729014 Business Rule Master*/
				String C1="SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";
				resultset = handler.executeSelectStatement(C1, connection,
						new Object[] {PILM086_BEAN.getBRH_PROD_CODE_FM()});
				while(resultset.next()) {
					PROD_DESC_FM =resultset.getString(1);
					System.out.println("Value Of Product code Desc ***********"+PROD_DESC_FM);
				}
				
				String C2="SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";
				resultset1 = handler.executeSelectStatement(C2, connection,
						new Object[] {PILM086_BEAN.getBRH_PROD_CODE_TO()});
				while(resultset1.next()) {
					PROD_DESC_TO =resultset1.getString(1);
					System.out.println("Value Of Product code Desc ***********"+PROD_DESC_TO);
				}
				
				PILM086_BEAN.setBRH_PROD_CODE_FM_DESC(PROD_DESC_FM);
				PILM086_BEAN.setBRH_PROD_CODE_TO_DESC(PROD_DESC_TO);
				System.out.println("Product code from :"+PILM086_BEAN.getBRH_PROD_CODE_FM_DESC());
				System.out.println("Product code To   :"+PILM086_BEAN.getBRH_PROD_CODE_TO_DESC());
				COMP_BRH_PROD_CODE_FM_DESC.resetValue();
				COMP_BRH_PROD_CODE_TO_DESC.resetValue();
								
				/*End*/
				
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
		}
	 
	public void validateGROUP_ID(FacesContext context,
				UIComponent component, Object value){
			try{
				String GROUPID = (String)value;
				PILM086_BEAN.setBRH_GRP_ID(GROUPID);
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}
	
	/*Modified method by saritha on 08-07-2017 for Business Rule Master*/
	
	/*public void validatePROD_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String PRODCODE = (String)value;
			PILM086_BEAN.setBRH_PROD_CODE(PRODCODE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
		
	public void validateBRH_PROD_CODE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			String PRODCODEFROM = (String)value;
			PILM086_BEAN.setBRH_PROD_CODE_FM(PRODCODEFROM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	public void validateASSR_TYP(FacesContext context,
			UIComponent component, Object value){
		try{
			String ASSR_TYP = (String)value;
			PILM086_BEAN.setBRH_ASSR_TYPE(ASSR_TYP);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateERR_FLAG(FacesContext context,
			UIComponent component, Object value){
		try{
			String ERR_FLAG = (String)value;
			PILM086_BEAN.setBRH_ERR_FLAG(ERR_FLAG);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateAPPL_LEVEL(FacesContext context,
			UIComponent component, Object value){
		try{
			String APPL_LEVEL = (String)value;
			PILM086_BEAN.setBRH_APPL_LEVEL(APPL_LEVEL);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMOD_VALUE_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String MOD_VALUE_YN = (String)value;
			PILM086_BEAN.setBRH_MOD_VALUE_YN(MOD_VALUE_YN);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateTXN_DISP_TYPE(FacesContext context,
			UIComponent component, Object value){
		try{
			String TXN_DISP_TYPE = (String)value;
			PILM086_BEAN.setBRH_TXN_DISP_TYPE(TXN_DISP_TYPE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatePDS_CODE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			String PDS_CODE_FM = (String)value;
			PILM086_BEAN.setBRH_PDS_CODE_FM(PDS_CODE_FM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatePDS_CODE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			String PDS_CODE_TO = (String)value;
			PILM086_BEAN.setBRH_PDS_CODE_TO(PDS_CODE_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateCOVER_CODE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			String COVER_CODE_FM = (String)value;
			PILM086_BEAN.setBRH_COVER_CODE_FM(COVER_CODE_FM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateCOVER_CODE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			String COVER_CODE_TO = (String)value;
			PILM086_BEAN.setBRH_COVER_CODE_TO(COVER_CODE_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateSRC_BUS_CODE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			String SRC_BUS_CODE_FM = (String)value;
			PILM086_BEAN.setBRH_SRC_BUS_CODE_FM(SRC_BUS_CODE_FM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateSRC_BUS_CODE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			String SRC_BUS_CODE_TO = (String)value;
			PILM086_BEAN.setBRH_SRC_BUS_CODE_TO(SRC_BUS_CODE_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateDATE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			Date DATE_FM = (Date)value;
			System.out.println(DATE_FM);
			PILM086_BEAN.setBRH_DATE_FM(DATE_FM);;
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateDATE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			Date DATE_TO = (Date)value;
			
			
			
		
			if (DATE_TO != null) {

				if (PILM086_BEAN.getBRH_DATE_FM() != null
						&& DATE_TO.before(PILM086_BEAN.getBRH_DATE_FM())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71195",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					
				}
			}
			
			
			
			PILM086_BEAN.setBRH_DATE_TO(DATE_TO);;
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateTXN_DISP_TEXT(FacesContext context,
			UIComponent component, Object value){
		try{
			String TXN_DISP_TEXT = (String)value;
			
			PILM086_BEAN.setBRH_TXN_DISP_TEXT(TXN_DISP_TEXT);;
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateHINT(FacesContext context,
			UIComponent component, Object value){
		try{
			String HINT = (String)value;
			
			PILM086_BEAN.setBRH_HINT(HINT);;
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List<LovBean> prepareGROUP_ID(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_GRP_ID", "LIMODCODES", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("GROUP_ID_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	/*Added by saritha on 08-07-2017 for Business Rule Master */
	public List<LovBean> prepareBRH_PROD_CODE_FM(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_PROD_CODE",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public List<LovBean> prepareBRH_PROD_CODE_TO(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_PROD_CODE",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	/*End*/
	public List<LovBean> preparePDS_CODE_FM(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_PDS_CODE_FM",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PDS_CODE_FM_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public List<LovBean> preparePDS_CODE_TO(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_PDS_CODE_TO",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PDS_CODE_TO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public List<LovBean> prepareCOVER_CODE_FM(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_COVER_CODE_FM",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COVER_CODE_FM_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public List<LovBean> prepareCOVER_CODE_TO(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_COVER_CODE_TO",null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COVER_CODE_TO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public List<LovBean> prepareSRC_BUS_CODE_FM(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_SRC_BUS_CODE_FM","SRC_BUS_TY", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_CODE_FM_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public List<LovBean> prepareSRC_BUS_CODE_TO(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_HDR",
					"BRH_SRC_BUS_CODE_TO","SRC_BUS_TY", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_CODE_TO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	
	 public void saveRecord() {
		 String message = null;
			try {
				if (getPILM086_BEAN().getROWID() != null) {
					if(isUPDATE_ALLOWED()){
						
						
						PILM086_BEAN.setBRH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
						PILM086_BEAN.setBRH_UPD_DT(new CommonUtils().getCurrentDate());
					new CRUDHandler().executeUpdate(getPILM086_BEAN(),
							CommonUtils.getConnection());
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
					}
				} else {
					if(isINSERT_ALLOWED()){
						//PILM086_BEAN.setBRH_SYS_ID(PM_RBH_SYS_ID.NEXTVAL);
						String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
						ResultSet rs = null;
						if (getErrorMap().size() == 0) {
							rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
							if (rs.next()) {
								PILM086_BEAN.setBRH_SYS_ID(Long.parseLong(rs.getString(1)));
							}
						}
						
						PILM086_BEAN.setBRH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
						PILM086_BEAN.setBRH_CR_DT(new CommonUtils().getCurrentDate());
					
						
					new CRUDHandler().executeInsert(getPILM086_BEAN(),
							CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					getWarningMap().put("togle",Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					message = Messages.getString("messageProperties","errorPanel$message$save");

					}
				}
				CommonUtils.getConnection().commit();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}
	 }
	 
	 
	 
	 
	 public void validatedefaultPDS_CODE_FM(ActionEvent event) throws ValidatorException{
		
			if("".equals(((String)getCOMP_PDS_CODE_FM().getSubmittedValue()).trim()) || getCOMP_PDS_CODE_FM().getSubmittedValue() == null){
				getCOMP_PDS_CODE_FM().setSubmittedValue("0");
				getCOMP_PDS_CODE_FM().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	 
	 public void validatedefaultPDS_CODE_TO(ActionEvent event) throws ValidatorException{
		

			if("".equals(((String)getCOMP_PDS_CODE_TO().getSubmittedValue()).trim()) || getCOMP_PDS_CODE_TO().getSubmittedValue() == null){
				
				/*Modified by Ram on 12/12/2016 for proper value
				 * 
				 * getCOMP_PDS_CODE_TO().setSubmittedValue("ZZZZZ");*/
				getCOMP_PDS_CODE_TO().setSubmittedValue("zzzzzzzzzzzz");
				
				/*End*/
				
				getCOMP_PDS_CODE_TO().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	 
	 public void validatedefaultCOVER_CODE_FM(ActionEvent event) throws ValidatorException{
			

			if("".equals(((String)getCOMP_COVER_CODE_FM().getSubmittedValue()).trim()) || getCOMP_COVER_CODE_FM().getSubmittedValue() == null){
				getCOMP_COVER_CODE_FM().setSubmittedValue("0");
				getCOMP_COVER_CODE_FM().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	 
	 public void validatedefaultCOVER_CODE_TO(ActionEvent event) throws ValidatorException{
			

			if("".equals(((String)getCOMP_COVER_CODE_TO().getSubmittedValue()).trim()) || getCOMP_COVER_CODE_TO().getSubmittedValue() == null){
				
				/*Modified by Ram on 12/12/2016 for proper values
				 * 
				 * getCOMP_COVER_CODE_TO().setSubmittedValue("ZZZZZ");*/
				getCOMP_COVER_CODE_TO().setSubmittedValue("zzzzzzzzzzzz");
				/*End*/
				
				getCOMP_COVER_CODE_TO().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	 
	 public void validatedefaultSRC_BUS_CODE_FM(ActionEvent event) throws ValidatorException{
			
			if("".equals(((String)getCOMP_SRC_BUS_CODE_FM().getSubmittedValue()).trim()) || getCOMP_SRC_BUS_CODE_FM().getSubmittedValue() == null){
				getCOMP_SRC_BUS_CODE_FM().setSubmittedValue("0");
				getCOMP_SRC_BUS_CODE_FM().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	 
	 public void validatedefaultSRC_BUS_CODE_TO(ActionEvent event) throws ValidatorException{
			

			if("".equals(((String)getCOMP_SRC_BUS_CODE_TO().getSubmittedValue()).trim()) || getCOMP_SRC_BUS_CODE_TO().getSubmittedValue() == null){
				/*Modified by Ram on 12/12/2016 for proper values
				 * 
				 * getCOMP_SRC_BUS_CODE_TO().setSubmittedValue("ZZZZZ");*/
				getCOMP_SRC_BUS_CODE_TO().setSubmittedValue("zzzzzzzzzzzz");
				/*End*/
				getCOMP_SRC_BUS_CODE_TO().updateModel(FacesContext.getCurrentInstance());
				
			}
			UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
			ErrorHelpUtil.validate(input, getErrorMap());
			
				//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
			
		}
	 
	/*Added by saritha on 08-07-2017 for ssp call id ZBILQC-1729014 Business Rule Master*/
	 
	private HtmlOutputLabel COMP_BRH_PROD_CODE_FM_LABEL;
	private HtmlInputText COMP_BRH_PROD_CODE_FM;
    private HtmlInputText COMP_BRH_PROD_CODE_FM_DESC;

	public HtmlOutputLabel getCOMP_BRH_PROD_CODE_FM_LABEL() {
		return COMP_BRH_PROD_CODE_FM_LABEL;
	}
	public void setCOMP_BRH_PROD_CODE_FM_LABEL(
			HtmlOutputLabel cOMP_BRH_PROD_CODE_FM_LABEL) {
		COMP_BRH_PROD_CODE_FM_LABEL = cOMP_BRH_PROD_CODE_FM_LABEL;
	}
	
	public HtmlInputText getCOMP_BRH_PROD_CODE_FM() {
		return COMP_BRH_PROD_CODE_FM;
	}
	public void setCOMP_BRH_PROD_CODE_FM(HtmlInputText cOMP_BRH_PROD_CODE_FM) {
		COMP_BRH_PROD_CODE_FM = cOMP_BRH_PROD_CODE_FM;
	}
	
	public HtmlInputText getCOMP_BRH_PROD_CODE_FM_DESC() {
		return COMP_BRH_PROD_CODE_FM_DESC;
	}
	public void setCOMP_BRH_PROD_CODE_FM_DESC(
			HtmlInputText cOMP_BRH_PROD_CODE_FM_DESC) {
		COMP_BRH_PROD_CODE_FM_DESC = cOMP_BRH_PROD_CODE_FM_DESC;
	}
	
	private HtmlOutputLabel COMP_BRH_PROD_CODE_TO_LABEL;
	private HtmlInputText COMP_BRH_PROD_CODE_TO;
	private HtmlInputText COMP_BRH_PROD_CODE_TO_DESC;
	
	public HtmlOutputLabel getCOMP_BRH_PROD_CODE_TO_LABEL() {
		return COMP_BRH_PROD_CODE_TO_LABEL;
	}
	public void setCOMP_BRH_PROD_CODE_TO_LABEL(
			HtmlOutputLabel cOMP_BRH_PROD_CODE_TO_LABEL) {
		COMP_BRH_PROD_CODE_TO_LABEL = cOMP_BRH_PROD_CODE_TO_LABEL;
	}
	public HtmlInputText getCOMP_BRH_PROD_CODE_TO() {
		return COMP_BRH_PROD_CODE_TO;
	}
	public void setCOMP_BRH_PROD_CODE_TO(HtmlInputText cOMP_BRH_PROD_CODE_TO) {
		COMP_BRH_PROD_CODE_TO = cOMP_BRH_PROD_CODE_TO;
	}
	
	public HtmlInputText getCOMP_BRH_PROD_CODE_TO_DESC() {
		return COMP_BRH_PROD_CODE_TO_DESC;
	}
	public void setCOMP_BRH_PROD_CODE_TO_DESC(
			HtmlInputText cOMP_BRH_PROD_CODE_TO_DESC) {
		COMP_BRH_PROD_CODE_TO_DESC = cOMP_BRH_PROD_CODE_TO_DESC;
	}
	
	public void instantiateAllComponent() {
		COMP_BRH_PROD_CODE_FM_LABEL=new HtmlOutputLabel();
		COMP_BRH_PROD_CODE_TO_LABEL=new HtmlOutputLabel();
		COMP_BRH_PROD_CODE_FM=new HtmlInputText();
		COMP_BRH_PROD_CODE_FM_DESC=new HtmlInputText();
		COMP_BRH_PROD_CODE_TO=new HtmlInputText();
		COMP_BRH_PROD_CODE_TO_DESC=new HtmlInputText();
	}
	
	public void disableAllComponent(boolean disabled) {
		COMP_BRH_PROD_CODE_FM.setDisabled(disabled);
		COMP_BRH_PROD_CODE_FM_DESC.setDisabled(disabled);
		COMP_BRH_PROD_CODE_TO.setDisabled(disabled);
		COMP_BRH_PROD_CODE_TO_DESC.setDisabled(disabled);
	}
	public void validatePROD_CODE_TO(FacesContext context,
				UIComponent component, Object value){
			try{
				String PRODCODETO = (String)value;
				PILM086_BEAN.setBRH_PROD_CODE_TO(PRODCODETO);
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 /*End*/
	
	/*Added by saritha on 10-07-2017 for ssp call id ZBILQC-1729014 Business Rule Master*/
	public void validatedefaultBRH_PROD_CODE_FM(ActionEvent event) throws ValidatorException{
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputvalue= (String)input.getSubmittedValue();

		if(inputvalue==null || inputvalue.trim().equalsIgnoreCase("")){

			getCOMP_BRH_PROD_CODE_FM().setSubmittedValue("0");
			getCOMP_BRH_PROD_CODE_FM().updateModel(FacesContext.getCurrentInstance());

		}

		ErrorHelpUtil.validate(input, getErrorMap());

	}
 
 
 public void validatedefaultBRH_PROD_CODE_TO(ActionEvent event) throws ValidatorException{

	 UIInput input = (UIInput) event.getComponent().getParent();
	 String inputvalue= (String)input.getSubmittedValue();

	 if(inputvalue==null || inputvalue.trim().equalsIgnoreCase("")){

		 getCOMP_BRH_PROD_CODE_TO().setSubmittedValue("zzzzzzzzzzzz");
		 getCOMP_BRH_PROD_CODE_TO().updateModel(FacesContext.getCurrentInstance());

	 }

	 ErrorHelpUtil.validate(input, getErrorMap());

 }
	
	/*End*/
 
 /*Added by saritha on 24-07-2017 for ssp call id ZBILQC-1732436*/ 
 private HtmlOutputLabel COMP_BRH_APL_SCREEN_LABEL;
 private HtmlSelectOneMenu COMP_BRH_APL_SCREEN;


 public HtmlOutputLabel getCOMP_BRH_APL_SCREEN_LABEL() {
	return COMP_BRH_APL_SCREEN_LABEL;
}
public void setCOMP_BRH_APL_SCREEN_LABEL(
		HtmlOutputLabel cOMP_BRH_APL_SCREEN_LABEL) {
	COMP_BRH_APL_SCREEN_LABEL = cOMP_BRH_APL_SCREEN_LABEL;
}

public HtmlSelectOneMenu getCOMP_BRH_APL_SCREEN() {
	return COMP_BRH_APL_SCREEN;
}
public void setCOMP_BRH_APL_SCREEN(HtmlSelectOneMenu cOMP_BRH_APL_SCREEN) {
	COMP_BRH_APL_SCREEN = cOMP_BRH_APL_SCREEN;
}

private List<SelectItem> listBRH_APL_SCREEN= new ArrayList<SelectItem>();
public List<SelectItem> getBRH_APL_SCREEN() {
	if (listBRH_APL_SCREEN.size() == 0) {
		listBRH_APL_SCREEN.clear();
		try {
			listBRH_APL_SCREEN = new ArrayList<SelectItem>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return listERR_FLAG;
}

public List<SelectItem> getListBRH_APL_SCREEN() {
	return listBRH_APL_SCREEN;
}
public void setListBRH_APL_SCREEN(List<SelectItem> listBRH_APL_SCREEN) {
	this.listBRH_APL_SCREEN = listBRH_APL_SCREEN;
}

public void validateBRH_APL_SCREEN(FacesContext context,
		 UIComponent component, Object value){
	 try{
		 String BRH_APL_SCREEN = (String)value;
		 PILM086_BEAN.setBRH_APL_SCREEN(BRH_APL_SCREEN);
	 }catch (Exception e) {
		 throw new ValidatorException(new FacesMessage(e.getMessage()));
	 }
 }
/*End*/


}

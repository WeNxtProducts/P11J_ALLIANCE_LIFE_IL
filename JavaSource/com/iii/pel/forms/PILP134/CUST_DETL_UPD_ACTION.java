package com.iii.pel.forms.PILP134;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_DELEGATE;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_DELEGATE;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_HELPER;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class CUST_DETL_UPD_ACTION extends CommonAction{
	public PILP134_COMPOSITE_ACTION compositeAction;
	private CUST_DTL_UPD_BEAN CUST_DTL_UPD_BEAN;
	private CUST_DETL_UPD_DELEGATE delegate;
	private CUST_DETL_UPD_HELPER helper;
	
	
	private HtmlInputText COMP_CDU_CUST_CODE;
	private HtmlOutputLabel COMP_UI_M_POL_NO_FROM_LABEL;
	private HtmlInputText COMP_CDU_CUST_CODE_DESC;
	
	
	private HtmlAjaxCommandButton  COMP_FETCH_BTN;
	private HtmlCommandButton COMP_BUT_UPLOAD;
	private HtmlCommandButton COMP_BUT_PRINT;
	
	public HtmlCommandButton getCOMP_BUT_PRINT() {
		return COMP_BUT_PRINT;
	}
	public void setCOMP_BUT_PRINT(HtmlCommandButton cOMP_BUT_PRINT) {
		COMP_BUT_PRINT = cOMP_BUT_PRINT;
	}

	private HtmlInputText COMP_CDU_CORRES_ADDR1;
	private HtmlInputText CDU_BUS_ADDR1;
	private HtmlInputText COMP_CDU_CORRES_ADDR2;
	private HtmlInputText COMP_CDU_CORRES_ADDR3;
	private HtmlInputText COMP_CDU_CORRES_CITY_CODE;
	private HtmlInputText COMP_CDU_CORRES_CITY_DESC;
	private HtmlInputText COMP_CDU_CORRES_COUNTRY;
	private HtmlInputText COMP_CDU_CORRES_COUNTRY_DESC;
	private HtmlInputText COMP_CDU_CORRES_PHONE;
	private HtmlInputText COMP_CUST_TEL_AREA_CODE2;
	private HtmlInputText COMP_CDU_MOBILE_NO;
	private HtmlInputText COMP_CUST_FAX_AREA_CODE;
	private HtmlInputText COMP_CDU_CORRES_FAX;
	private HtmlInputText COMP_CUST_EMAIL_ID_PER;
	private HtmlInputText COMP_CDU_CUST_MAR_STATUS;
	private HtmlInputText COMP_CDU_BUS_ADDR1;
	private HtmlInputText COMP_CDU_BUS_ADDR2;
	private HtmlInputText COMP_CDU_BUS_ADDR3;
	private HtmlInputText COMP_CDU_BUS_COUNTRY;
	private HtmlInputText COMP_CDU_BUS_COUNTRY_DESC;
	private HtmlInputText COMP_CUST_BUS_TEL_AREA_CODE;
	private HtmlInputText COMP_CDU_BUS_PHONE;
	private HtmlInputText COMP_CUST_BUS_TEL_AREA_CODE2;
	private HtmlInputText COMP_CDU_BUS_MOBILE_NO;
	private HtmlInputText COMP_BUS_CUST_FAX_AREA_CODE;
	private HtmlInputText COMP_CDU_BUS_FAX;
	private HtmlInputText COMP_CUST_EMAIL_ID_OFF;
	private HtmlInputText COMP_CDU_MAR_STATUS_DESC;
	
	private HtmlOutputLabel COMP_CDU_CORRES_POST_NO_LABEL;
	private HtmlInputText COMP_CDU_CORRES_POST_NO;
	private HtmlOutputLabel COMP_CDU_PHY_POST_NO_LABEL;
	private HtmlInputText COMP_CDU_PHY_POST_NO;
	private HtmlOutputLabel COMP_CDU_BUS_CITY_CODE_LABEL;
	private HtmlInputText COMP_CDU_BUS_CITY_CODE;
	private HtmlInputText COMP_CDU_BUS_CITY_CODE_DESC;
	private HtmlInputText COMP_CDU_TEL_AREA_CODE;
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	/*Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
	private HtmlOutputLabel COMP_CUST_CATG_CODE_LABEL;
	private HtmlInputText COMP_UI_M_CDU_CATG_CODE_DESC;
	private HtmlInputText COMP_CDU_CATG_CODE;
	
	private HtmlOutputLabel COMP_CDU_NAME_LABEL;
	private HtmlSelectOneMenu COMP_CDU_TITLE;
	
	List<SelectItem> itemListName = null;
	/*end*/
     
	/*added by raja on 31-05-2017 for ZBILQC-1724387*/
	private HtmlInputText COMP_CDU_CUST_NAME;
	public HtmlInputText getCOMP_CDU_CUST_NAME() {
		return COMP_CDU_CUST_NAME;
	}
	public void setCOMP_CDU_CUST_NAME(HtmlInputText cOMP_CDU_CUST_NAME) {
		COMP_CDU_CUST_NAME = cOMP_CDU_CUST_NAME;
	}
	/*end*/
	
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}
	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}
	public HtmlInputText getCOMP_CDU_TEL_AREA_CODE() {
		return COMP_CDU_TEL_AREA_CODE;
	}
	public void setCOMP_CDU_TEL_AREA_CODE(HtmlInputText cOMP_CDU_TEL_AREA_CODE) {
		COMP_CDU_TEL_AREA_CODE = cOMP_CDU_TEL_AREA_CODE;
	}
	public HtmlOutputLabel getCOMP_CDU_CORRES_POST_NO_LABEL() {
		return COMP_CDU_CORRES_POST_NO_LABEL;
	}
	public void setCOMP_CDU_CORRES_POST_NO_LABEL(
			HtmlOutputLabel cOMP_CDU_CORRES_POST_NO_LABEL) {
		COMP_CDU_CORRES_POST_NO_LABEL = cOMP_CDU_CORRES_POST_NO_LABEL;
	}
	public HtmlInputText getCOMP_CDU_CORRES_POST_NO() {
		return COMP_CDU_CORRES_POST_NO;
	}
	public void setCOMP_CDU_CORRES_POST_NO(HtmlInputText cOMP_CDU_CORRES_POST_NO) {
		COMP_CDU_CORRES_POST_NO = cOMP_CDU_CORRES_POST_NO;
	}
	public HtmlOutputLabel getCOMP_CDU_PHY_POST_NO_LABEL() {
		return COMP_CDU_PHY_POST_NO_LABEL;
	}
	public void setCOMP_CDU_PHY_POST_NO_LABEL(
			HtmlOutputLabel cOMP_CDU_PHY_POST_NO_LABEL) {
		COMP_CDU_PHY_POST_NO_LABEL = cOMP_CDU_PHY_POST_NO_LABEL;
	}
	public HtmlInputText getCOMP_CDU_PHY_POST_NO() {
		return COMP_CDU_PHY_POST_NO;
	}
	public void setCOMP_CDU_PHY_POST_NO(HtmlInputText cOMP_CDU_PHY_POST_NO) {
		COMP_CDU_PHY_POST_NO = cOMP_CDU_PHY_POST_NO;
	}
	public HtmlOutputLabel getCOMP_CDU_BUS_CITY_CODE_LABEL() {
		return COMP_CDU_BUS_CITY_CODE_LABEL;
	}
	public void setCOMP_CDU_BUS_CITY_CODE_LABEL(
			HtmlOutputLabel cOMP_CDU_BUS_CITY_CODE_LABEL) {
		COMP_CDU_BUS_CITY_CODE_LABEL = cOMP_CDU_BUS_CITY_CODE_LABEL;
	}
	public HtmlInputText getCOMP_CDU_BUS_CITY_CODE() {
		return COMP_CDU_BUS_CITY_CODE;
	}
	public void setCOMP_CDU_BUS_CITY_CODE(HtmlInputText cOMP_CDU_BUS_CITY_CODE) {
		COMP_CDU_BUS_CITY_CODE = cOMP_CDU_BUS_CITY_CODE;
	}
	public HtmlInputText getCOMP_CDU_BUS_CITY_CODE_DESC() {
		return COMP_CDU_BUS_CITY_CODE_DESC;
	}
	public void setCOMP_CDU_BUS_CITY_CODE_DESC(
			HtmlInputText cOMP_CDU_BUS_CITY_CODE_DESC) {
		COMP_CDU_BUS_CITY_CODE_DESC = cOMP_CDU_BUS_CITY_CODE_DESC;
	}
	public HtmlInputText getCOMP_CDU_MAR_STATUS_DESC() {
		return COMP_CDU_MAR_STATUS_DESC;
	}
	public void setCOMP_CDU_MAR_STATUS_DESC(HtmlInputText cOMP_CDU_MAR_STATUS_DESC) {
		COMP_CDU_MAR_STATUS_DESC = cOMP_CDU_MAR_STATUS_DESC;
	}

	/*added by gopi for ssp call id  ZBILQC-1733435 on 03/08/17*/
	private HtmlOutputLabel COMP_CDU_AGE_ADMITTED_LABEL;
		
	public HtmlOutputLabel getCOMP_CDU_AGE_ADMITTED_LABEL() {
		return COMP_CDU_AGE_ADMITTED_LABEL;
	}
	public void setCOMP_CDU_AGE_ADMITTED_LABEL(
			HtmlOutputLabel cOMP_CDU_AGE_ADMITTED_LABEL) {
		COMP_CDU_AGE_ADMITTED_LABEL = cOMP_CDU_AGE_ADMITTED_LABEL;
	}
	
	private HtmlSelectOneMenu COMP_CDU_AGE_ADMITTED;
	
   public HtmlSelectOneMenu getCOMP_CDU_AGE_ADMITTED() {
		return COMP_CDU_AGE_ADMITTED;
	}
	public void setCOMP_CDU_AGE_ADMITTED(HtmlSelectOneMenu cOMP_CDU_AGE_ADMITTED) {
		COMP_CDU_AGE_ADMITTED = cOMP_CDU_AGE_ADMITTED;
	}

	private List<SelectItem> listCDU_AGE_ADMITTED = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListCDU_AGE_ADMITTED() {
		return listCDU_AGE_ADMITTED;
	}
	public void setListCDU_AGE_ADMITTED(List<SelectItem> listCDU_AGE_ADMITTED) {
		this.listCDU_AGE_ADMITTED = listCDU_AGE_ADMITTED;
	}

	/*private HtmlOutputLabel COMP_CDU_BUS_AGE_ADMITTED_LABEL;
	
	public HtmlOutputLabel getCOMP_CDU_BUS_AGE_ADMITTED_LABEL() {
		return COMP_CDU_BUS_AGE_ADMITTED_LABEL;
	}
	public void setCOMP_CDU_BUS_AGE_ADMITTED_LABEL(
			HtmlOutputLabel cOMP_CDU_BUS_AGE_ADMITTED_LABEL) {
		COMP_CDU_BUS_AGE_ADMITTED_LABEL = cOMP_CDU_BUS_AGE_ADMITTED_LABEL;
	}*/

	/*private HtmlSelectOneMenu COMP_CDU_BUS_AGE_ADMITTED;
	
	public HtmlSelectOneMenu getCOMP_CDU_BUS_AGE_ADMITTED() {
		return COMP_CDU_BUS_AGE_ADMITTED;
	}
	public void setCOMP_CDU_BUS_AGE_ADMITTED(
			HtmlSelectOneMenu cOMP_CDU_BUS_AGE_ADMITTED) {
		COMP_CDU_BUS_AGE_ADMITTED = cOMP_CDU_BUS_AGE_ADMITTED;
	}
*/
	/*private List<SelectItem> listCDU_BUS_AGE_ADMITTED = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListCDU_BUS_AGE_ADMITTED() {
		return listCDU_BUS_AGE_ADMITTED;
	}
	public void setListCDU_BUS_AGE_ADMITTED(
			List<SelectItem> listCDU_BUS_AGE_ADMITTED) {
		this.listCDU_BUS_AGE_ADMITTED = listCDU_BUS_AGE_ADMITTED;
	}*/

	private HtmlOutputLabel COMP_CDU_AGE_PROOF_FLAG_LABEL;
	
	

	public HtmlOutputLabel getCOMP_CDU_AGE_PROOF_FLAG_LABEL() {
		return COMP_CDU_AGE_PROOF_FLAG_LABEL;
	}
	public void setCOMP_CDU_AGE_PROOF_FLAG_LABEL(
			HtmlOutputLabel cOMP_CDU_AGE_PROOF_FLAG_LABEL) {
		COMP_CDU_AGE_PROOF_FLAG_LABEL = cOMP_CDU_AGE_PROOF_FLAG_LABEL;
	}

	private HtmlSelectOneMenu COMP_CDU_AGE_PROOF_FLAG;
	

	public HtmlSelectOneMenu getCOMP_CDU_AGE_PROOF_FLAG() {
		return COMP_CDU_AGE_PROOF_FLAG;
	}
	public void setCOMP_CDU_AGE_PROOF_FLAG(HtmlSelectOneMenu cOMP_CDU_AGE_PROOF_FLAG) {
		COMP_CDU_AGE_PROOF_FLAG = cOMP_CDU_AGE_PROOF_FLAG;
	}
	
	private List<SelectItem> listCDU_AGE_PROOF_FLAG = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListCDU_AGE_PROOF_FLAG() {
		return listCDU_AGE_PROOF_FLAG;
	}
	public void setListCDU_AGE_PROOF_FLAG(List<SelectItem> listCDU_AGE_PROOF_FLAG) {
		this.listCDU_AGE_PROOF_FLAG = listCDU_AGE_PROOF_FLAG;
	}
	/*private HtmlOutputLabel COMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL;
	
	public HtmlOutputLabel getCOMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL() {
		return COMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL;
	}
	public void setCOMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL(
			HtmlOutputLabel cOMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL) {
		COMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL = cOMP_CDU_BUS_AGE_PROOF_OTHERS_LABEL;
	}
*/
	/*private HtmlInputText COMP_CDU_BUS_AGE_PROOF_OTHERS;
	
	


	public HtmlInputText getCOMP_CDU_BUS_AGE_PROOF_OTHERS() {
		return COMP_CDU_BUS_AGE_PROOF_OTHERS;
	}
	public void setCOMP_CDU_BUS_AGE_PROOF_OTHERS(
			HtmlInputText cOMP_CDU_BUS_AGE_PROOF_OTHERS) {
		COMP_CDU_BUS_AGE_PROOF_OTHERS = cOMP_CDU_BUS_AGE_PROOF_OTHERS;
	}*/

	/*private List<SelectItem> listCDU_BUS_AGE_PROOF_FLAG = new ArrayList<SelectItem>();

	
	public List<SelectItem> getListCDU_BUS_AGE_PROOF_FLAG() {
		return listCDU_BUS_AGE_PROOF_FLAG;
	}
	public void setListCDU_BUS_AGE_PROOF_FLAG(
			List<SelectItem> listCDU_BUS_AGE_PROOF_FLAG) {
		this.listCDU_BUS_AGE_PROOF_FLAG = listCDU_BUS_AGE_PROOF_FLAG;
	}*/

	private HtmlOutputLabel COMP_CDU_AGE_PROOF_OTHERS_LABEL;
	
	
	public HtmlOutputLabel getCOMP_CDU_AGE_PROOF_OTHERS_LABEL() {
		return COMP_CDU_AGE_PROOF_OTHERS_LABEL;
	}
	public void setCOMP_CDU_AGE_PROOF_OTHERS_LABEL(
			HtmlOutputLabel cOMP_CDU_AGE_PROOF_OTHERS_LABEL) {
		COMP_CDU_AGE_PROOF_OTHERS_LABEL = cOMP_CDU_AGE_PROOF_OTHERS_LABEL;
	}

	/*private HtmlOutputLabel COMP_CDU_BUS_AGE_PROOF_FLAG_LABEL;
	
	public HtmlOutputLabel getCOMP_CDU_BUS_AGE_PROOF_FLAG_LABEL() {
		return COMP_CDU_BUS_AGE_PROOF_FLAG_LABEL;
	}
	public void setCOMP_CDU_BUS_AGE_PROOF_FLAG_LABEL(
			HtmlOutputLabel cOMP_CDU_BUS_AGE_PROOF_FLAG_LABEL) {
		COMP_CDU_BUS_AGE_PROOF_FLAG_LABEL = cOMP_CDU_BUS_AGE_PROOF_FLAG_LABEL;
	}*/
	/*private HtmlSelectOneMenu COMP_CDU_BUS_AGE_PROOF_FLAG;
	
	public HtmlSelectOneMenu getCOMP_CDU_BUS_AGE_PROOF_FLAG() {
		return COMP_CDU_BUS_AGE_PROOF_FLAG;
	}
	public void setCOMP_CDU_BUS_AGE_PROOF_FLAG(
			HtmlSelectOneMenu cOMP_CDU_BUS_AGE_PROOF_FLAG) {
		COMP_CDU_BUS_AGE_PROOF_FLAG = cOMP_CDU_BUS_AGE_PROOF_FLAG;
	}

	*/
	private HtmlInputText COMP_CDU_AGE_PROOF_OTHERS;
	
	public HtmlInputText getCOMP_CDU_AGE_PROOF_OTHERS() {
		return COMP_CDU_AGE_PROOF_OTHERS;
	}
	public void setCOMP_CDU_AGE_PROOF_OTHERS(HtmlInputText cOMP_CDU_AGE_PROOF_OTHERS) {
		COMP_CDU_AGE_PROOF_OTHERS = cOMP_CDU_AGE_PROOF_OTHERS;
	}

	//END
	private List<CUST_DTL_UPD_BEAN> dataList_CUST_DTL_UPD = new ArrayList<CUST_DTL_UPD_BEAN>();

	private UIData dataTable;
	
	

	public List<CUST_DTL_UPD_BEAN> getDataList_CUST_DTL_UPD() {
		return dataList_CUST_DTL_UPD;
	}
	public void setDataList_CUST_DTL_UPD(
			List<CUST_DTL_UPD_BEAN> dataList_CUST_DTL_UPD) {
		this.dataList_CUST_DTL_UPD = dataList_CUST_DTL_UPD;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public HtmlInputText getCOMP_CDU_CORRES_ADDR1() {
		return COMP_CDU_CORRES_ADDR1;
	}
	public void setCOMP_CDU_CORRES_ADDR1(HtmlInputText cOMP_CDU_CORRES_ADDR1) {
		COMP_CDU_CORRES_ADDR1 = cOMP_CDU_CORRES_ADDR1;
	}
	public PILP134_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILP134_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public CUST_DETL_UPD_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(CUST_DETL_UPD_DELEGATE delegate) {
		this.delegate = delegate;
	}
	public CUST_DETL_UPD_HELPER getHelper() {
		return helper;
	}
	public void setHelper(CUST_DETL_UPD_HELPER helper) {
		this.helper = helper;
	}
	public HtmlInputText getCDU_BUS_ADDR1() {
		return CDU_BUS_ADDR1;
	}
	public void setCDU_BUS_ADDR1(HtmlInputText cDU_BUS_ADDR1) {
		CDU_BUS_ADDR1 = cDU_BUS_ADDR1;
	}
	public HtmlInputText getCOMP_CDU_CORRES_ADDR2() {
		return COMP_CDU_CORRES_ADDR2;
	}
	public void setCOMP_CDU_CORRES_ADDR2(HtmlInputText cOMP_CDU_CORRES_ADDR2) {
		COMP_CDU_CORRES_ADDR2 = cOMP_CDU_CORRES_ADDR2;
	}
	public HtmlInputText getCOMP_CDU_CORRES_ADDR3() {
		return COMP_CDU_CORRES_ADDR3;
	}
	public void setCOMP_CDU_CORRES_ADDR3(HtmlInputText cOMP_CDU_CORRES_ADDR3) {
		COMP_CDU_CORRES_ADDR3 = cOMP_CDU_CORRES_ADDR3;
	}
	public HtmlInputText getCOMP_CDU_CORRES_CITY_CODE() {
		return COMP_CDU_CORRES_CITY_CODE;
	}
	public void setCOMP_CDU_CORRES_CITY_CODE(HtmlInputText cOMP_CDU_CORRES_CITY_CODE) {
		COMP_CDU_CORRES_CITY_CODE = cOMP_CDU_CORRES_CITY_CODE;
	}
	public HtmlInputText getCOMP_CDU_CORRES_CITY_DESC() {
		return COMP_CDU_CORRES_CITY_DESC;
	}
	public void setCOMP_CDU_CORRES_CITY_DESC(HtmlInputText cOMP_CDU_CORRES_CITY_DESC) {
		COMP_CDU_CORRES_CITY_DESC = cOMP_CDU_CORRES_CITY_DESC;
	}
	public HtmlInputText getCOMP_CDU_CORRES_COUNTRY() {
		return COMP_CDU_CORRES_COUNTRY;
	}
	public void setCOMP_CDU_CORRES_COUNTRY(HtmlInputText cOMP_CDU_CORRES_COUNTRY) {
		COMP_CDU_CORRES_COUNTRY = cOMP_CDU_CORRES_COUNTRY;
	}
	public HtmlInputText getCOMP_CDU_CORRES_COUNTRY_DESC() {
		return COMP_CDU_CORRES_COUNTRY_DESC;
	}
	public void setCOMP_CDU_CORRES_COUNTRY_DESC(
			HtmlInputText cOMP_CDU_CORRES_COUNTRY_DESC) {
		COMP_CDU_CORRES_COUNTRY_DESC = cOMP_CDU_CORRES_COUNTRY_DESC;
	}
	public HtmlInputText getCOMP_CDU_CORRES_PHONE() {
		return COMP_CDU_CORRES_PHONE;
	}
	public void setCOMP_CDU_CORRES_PHONE(HtmlInputText cOMP_CDU_CORRES_PHONE) {
		COMP_CDU_CORRES_PHONE = cOMP_CDU_CORRES_PHONE;
	}
	public HtmlInputText getCOMP_CUST_TEL_AREA_CODE2() {
		return COMP_CUST_TEL_AREA_CODE2;
	}
	public void setCOMP_CUST_TEL_AREA_CODE2(HtmlInputText cOMP_CUST_TEL_AREA_CODE2) {
		COMP_CUST_TEL_AREA_CODE2 = cOMP_CUST_TEL_AREA_CODE2;
	}
	public HtmlInputText getCOMP_CDU_MOBILE_NO() {
		return COMP_CDU_MOBILE_NO;
	}
	public void setCOMP_CDU_MOBILE_NO(HtmlInputText cOMP_CDU_MOBILE_NO) {
		COMP_CDU_MOBILE_NO = cOMP_CDU_MOBILE_NO;
	}
	public HtmlInputText getCOMP_CUST_FAX_AREA_CODE() {
		return COMP_CUST_FAX_AREA_CODE;
	}
	public void setCOMP_CUST_FAX_AREA_CODE(HtmlInputText cOMP_CUST_FAX_AREA_CODE) {
		COMP_CUST_FAX_AREA_CODE = cOMP_CUST_FAX_AREA_CODE;
	}
	public HtmlInputText getCOMP_CDU_CORRES_FAX() {
		return COMP_CDU_CORRES_FAX;
	}
	public void setCOMP_CDU_CORRES_FAX(HtmlInputText cOMP_CDU_CORRES_FAX) {
		COMP_CDU_CORRES_FAX = cOMP_CDU_CORRES_FAX;
	}
	public HtmlInputText getCOMP_CUST_EMAIL_ID_PER() {
		return COMP_CUST_EMAIL_ID_PER;
	}
	public void setCOMP_CUST_EMAIL_ID_PER(HtmlInputText cOMP_CUST_EMAIL_ID_PER) {
		COMP_CUST_EMAIL_ID_PER = cOMP_CUST_EMAIL_ID_PER;
	}
	public HtmlInputText getCOMP_CDU_CUST_MAR_STATUS() {
		return COMP_CDU_CUST_MAR_STATUS;
	}
	public void setCOMP_CDU_CUST_MAR_STATUS(HtmlInputText cOMP_CDU_CUST_MAR_STATUS) {
		COMP_CDU_CUST_MAR_STATUS = cOMP_CDU_CUST_MAR_STATUS;
	}
	public HtmlInputText getCOMP_CDU_BUS_ADDR1() {
		return COMP_CDU_BUS_ADDR1;
	}
	public void setCOMP_CDU_BUS_ADDR1(HtmlInputText cOMP_CDU_BUS_ADDR1) {
		COMP_CDU_BUS_ADDR1 = cOMP_CDU_BUS_ADDR1;
	}
	public HtmlInputText getCOMP_CDU_BUS_ADDR2() {
		return COMP_CDU_BUS_ADDR2;
	}
	public void setCOMP_CDU_BUS_ADDR2(HtmlInputText cOMP_CDU_BUS_ADDR2) {
		COMP_CDU_BUS_ADDR2 = cOMP_CDU_BUS_ADDR2;
	}
	public HtmlInputText getCOMP_CDU_BUS_ADDR3() {
		return COMP_CDU_BUS_ADDR3;
	}
	public void setCOMP_CDU_BUS_ADDR3(HtmlInputText cOMP_CDU_BUS_ADDR3) {
		COMP_CDU_BUS_ADDR3 = cOMP_CDU_BUS_ADDR3;
	}
	public HtmlInputText getCOMP_CDU_BUS_COUNTRY() {
		return COMP_CDU_BUS_COUNTRY;
	}
	public void setCOMP_CDU_BUS_COUNTRY(HtmlInputText cOMP_CDU_BUS_COUNTRY) {
		COMP_CDU_BUS_COUNTRY = cOMP_CDU_BUS_COUNTRY;
	}
	public HtmlInputText getCOMP_CDU_BUS_COUNTRY_DESC() {
		return COMP_CDU_BUS_COUNTRY_DESC;
	}
	public void setCOMP_CDU_BUS_COUNTRY_DESC(HtmlInputText cOMP_CDU_BUS_COUNTRY_DESC) {
		COMP_CDU_BUS_COUNTRY_DESC = cOMP_CDU_BUS_COUNTRY_DESC;
	}
	public HtmlInputText getCOMP_CUST_BUS_TEL_AREA_CODE() {
		return COMP_CUST_BUS_TEL_AREA_CODE;
	}
	public void setCOMP_CUST_BUS_TEL_AREA_CODE(
			HtmlInputText cOMP_CUST_BUS_TEL_AREA_CODE) {
		COMP_CUST_BUS_TEL_AREA_CODE = cOMP_CUST_BUS_TEL_AREA_CODE;
	}
	public HtmlInputText getCOMP_CDU_BUS_PHONE() {
		return COMP_CDU_BUS_PHONE;
	}
	public void setCOMP_CDU_BUS_PHONE(HtmlInputText cOMP_CDU_BUS_PHONE) {
		COMP_CDU_BUS_PHONE = cOMP_CDU_BUS_PHONE;
	}
	public HtmlInputText getCOMP_CUST_BUS_TEL_AREA_CODE2() {
		return COMP_CUST_BUS_TEL_AREA_CODE2;
	}
	public void setCOMP_CUST_BUS_TEL_AREA_CODE2(
			HtmlInputText cOMP_CUST_BUS_TEL_AREA_CODE2) {
		COMP_CUST_BUS_TEL_AREA_CODE2 = cOMP_CUST_BUS_TEL_AREA_CODE2;
	}
	public HtmlInputText getCOMP_CDU_BUS_MOBILE_NO() {
		return COMP_CDU_BUS_MOBILE_NO;
	}
	public void setCOMP_CDU_BUS_MOBILE_NO(HtmlInputText cOMP_CDU_BUS_MOBILE_NO) {
		COMP_CDU_BUS_MOBILE_NO = cOMP_CDU_BUS_MOBILE_NO;
	}
	public HtmlInputText getCOMP_BUS_CUST_FAX_AREA_CODE() {
		return COMP_BUS_CUST_FAX_AREA_CODE;
	}
	public void setCOMP_BUS_CUST_FAX_AREA_CODE(
			HtmlInputText cOMP_BUS_CUST_FAX_AREA_CODE) {
		COMP_BUS_CUST_FAX_AREA_CODE = cOMP_BUS_CUST_FAX_AREA_CODE;
	}
	public HtmlInputText getCOMP_CDU_BUS_FAX() {
		return COMP_CDU_BUS_FAX;
	}
	public void setCOMP_CDU_BUS_FAX(HtmlInputText cOMP_CDU_BUS_FAX) {
		COMP_CDU_BUS_FAX = cOMP_CDU_BUS_FAX;
	}
	public HtmlInputText getCOMP_CUST_EMAIL_ID_OFF() {
		return COMP_CUST_EMAIL_ID_OFF;
	}
	public void setCOMP_CUST_EMAIL_ID_OFF(HtmlInputText cOMP_CUST_EMAIL_ID_OFF) {
		COMP_CUST_EMAIL_ID_OFF = cOMP_CUST_EMAIL_ID_OFF;
	}
	public HtmlAjaxCommandButton getCOMP_FETCH_BTN() {
		return COMP_FETCH_BTN;
	}
	public void setCOMP_FETCH_BTN(HtmlAjaxCommandButton cOMP_FETCH_BTN) {
		COMP_FETCH_BTN = cOMP_FETCH_BTN;
	}
	
	public HtmlCommandButton getCOMP_BUT_UPLOAD() {
		return COMP_BUT_UPLOAD;
	}
	public void setCOMP_BUT_UPLOAD(HtmlCommandButton cOMP_BUT_UPLOAD) {
		COMP_BUT_UPLOAD = cOMP_BUT_UPLOAD;
	}
	
	public HtmlInputText getCOMP_CDU_CUST_CODE_DESC() {
		return COMP_CDU_CUST_CODE_DESC;
	}
	public void setCOMP_CDU_CUST_CODE_DESC(HtmlInputText cOMP_CDU_CUST_CODE_DESC) {
		COMP_CDU_CUST_CODE_DESC = cOMP_CDU_CUST_CODE_DESC;
	}
	public HtmlInputText getCOMP_CDU_CUST_CODE() {
		return COMP_CDU_CUST_CODE;
	}
	public void setCOMP_CDU_CUST_CODE(HtmlInputText cOMP_CDU_CUST_CODE) {
		COMP_CDU_CUST_CODE = cOMP_CDU_CUST_CODE;
	}
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FROM_LABEL() {
		return COMP_UI_M_POL_NO_FROM_LABEL;
	}
	public void setCOMP_UI_M_POL_NO_FROM_LABEL(
			HtmlOutputLabel cOMP_UI_M_POL_NO_FROM_LABEL) {
		COMP_UI_M_POL_NO_FROM_LABEL = cOMP_UI_M_POL_NO_FROM_LABEL;
	}
	public CUST_DTL_UPD_BEAN getCUST_DTL_UPD_BEAN() {
		return CUST_DTL_UPD_BEAN;
	}
	public void setCUST_DTL_UPD_BEAN(CUST_DTL_UPD_BEAN cUST_DTL_UPD_BEAN) {
		CUST_DTL_UPD_BEAN = cUST_DTL_UPD_BEAN;
	}
	public CUST_DETL_UPD_ACTION()
	{
		
		CUST_DTL_UPD_BEAN=new CUST_DTL_UPD_BEAN();
		delegate=new CUST_DETL_UPD_DELEGATE();
		helper=new CUST_DETL_UPD_HELPER();
		//ADDED BY GOPI FOR ZBILQC-1733435
		setlistValues();
		//END
		/*Added by kavitha on 30.07.2018*/
		itemListName = CUST_DETL_UPD_DELEGATE.getDropDownListValue(
				"PM006_A_APAC", "PM_CUSTOMER", "PM_CUSTOMER.CUST_TITLE",
				"TITLE");
	}
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			System.out.println("Onload is called");
			/*Added by Ameen on 09-05-2018 for KIC 3rd address enabling*/
			if(CUST_DTL_UPD_BEAN.getROWID() == null){
				CUST_DTL_UPD_BEAN.setCDU_AGE_PROOF_FLAG("5");
			}
			/*End*/
			setBlockFlag(false);
		}
	}
	
	/*ADDED BY GOPI FOR ZBILQC-1733435*/
	
	public void setlistValues() {

		try {
			setListCDU_AGE_PROOF_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP134",
					"PW_IL_CUST_DTL_UPD",
					"PW_IL_CUST_DTL_UPD.CDU_AGE_PROOF_FLAG",
					"IL_AGE_PROOF"));
			
			/*setListCDU_BUS_AGE_PROOF_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP134",
					"PW_IL_CUST_DTL_UPD",
					"PW_IL_CUST_DTL_UPD.CDU_BUS_AGE_PROOF_FLAG",
					"IL_AGE_PROOF"));
			*/
			
			setListCDU_AGE_ADMITTED(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP134",
					"PW_IL_CUST_DTL_UPD",
					"PW_IL_CUST_DTL_UPD.CDU_AGE_ADMITTED", "YESNO_AD"));
			
		/*	setListCDU_BUS_AGE_ADMITTED(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP134",
					"PW_IL_CUST_DTL_UPD",
					"PW_IL_CUST_DTL_UPD.CDU_BUS_AGE_ADMITTED", "YESNO_AD"));
			*/

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//END
	
	
	
	
	
	
	public void whenButtonPressedUpload(ActionEvent event)
	{
		try {
			getWarningMap().clear();
			System.out.println("upload is called");
			helper.callP_CUST_UPD_PROCESSING(this);
			COMP_BUT_PRINT.setDisabled(false);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record Updated Sucessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void whenButtonPressedPrint(ActionEvent event)
	{
		try {
			System.out.println("COMP_REPORT_MODAL_PANEL");
			COMP_REPORT_MODAL_PANEL.setShowWhenRendered(true);
			runAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void whenButtonPressedFetch(ActionEvent event)
	{
		try {
			delegate.executeSelectStatement(compositeAction);
			System.out.println("cust code=="+getCUST_DTL_UPD_BEAN().getCDU_CUST_CODE());
			delegate.executeQuery(compositeAction);
			
			resetAllComponents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveRecord() {
		try {
			/*CommonUtils.clearMaps(this);*/
			System.out.println("CUST_DTL_UPD_BEAN.getROWID()       "+CUST_DTL_UPD_BEAN.getROWID());
			if(CUST_DTL_UPD_BEAN.getROWID()==null 
					&& isINSERT_ALLOWED())
			{
				
				String query1 = " SELECT PIL_CDU_SYS_ID.NEXTVAL  FROM DUAL";
				Connection connection = null;
				ResultSet rs = null;
				CRUDHandler handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
					rs = handler.executeSelectStatement(query1, connection);

					if (rs.next()) {
						CUST_DTL_UPD_BEAN.setCDU_SYS_ID(rs.getLong(1));
					}
					CUST_DTL_UPD_BEAN.setCDU_CR_DT(new CommonUtils().getCurrentDate());
					new CRUDHandler().executeInsert(CUST_DTL_UPD_BEAN,
							CommonUtils.getConnection());
					COMP_BUT_UPLOAD.setDisabled(false);
				
			}
			else
			{
				new CRUDHandler().executeUpdate(CUST_DTL_UPD_BEAN,
						CommonUtils.getConnection());
				COMP_BUT_UPLOAD.setDisabled(false);
			}
			
			CommonUtils.getConnection().commit();
			
			helper.callP_CUST_UPD_PROCESSING(this);
			COMP_BUT_PRINT.setDisabled(false);
			
			
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public ArrayList<LovBean> lovCDU_CUST_CODE(Object object) {
    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
    	
    	/*added by raja on 31-05-2017 for ZBILQC-1724387*/
		/*String query = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER WHERE (CUST_CODE LIKE ? OR UPPER(CUST_NAME) LIKE UPPER(?)) AND ROWNUM < ? ORDER BY 1";*/
    	String query = "SELECT CUST_REF_ID1, CUST_NAME FROM PM_CUSTOMER WHERE (CUST_REF_ID1 LIKE ? OR UPPER(CUST_NAME) LIKE UPPER(?)) AND ROWNUM < ? ORDER BY 1";
    	/*end*/
		
    	Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
    }

	
	
	public void valiadteCDU_CUST_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		
		try {
			
			System.out.println("validator is called");
			/*changed by raja on  31-05-2017 for ZBILQC-1724387*/
			/*CUST_DTL_UPD_BEAN.setCDU_CUST_CODE(value.toString());*/
			CUST_DTL_UPD_BEAN.setCDU_CUST_REF_ID1(value.toString());
			/*end*/
			
			System.out.println("cust code  ===>"+CUST_DTL_UPD_BEAN.getCDU_CUST_REF_ID1());
			/*String Query="select cust_name from pm_customer where cust_code=?";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), 
			new Object[]{CUST_DTL_UPD_BEAN.getCDU_CUST_CODE()});
			while(resultset.next())
			{
				CUST_DTL_UPD_BEAN.setCDU_CUST_CODE_DESC(resultset.getString("cust_name"));
			}*/

			/*COMP_CDU_CUST_CODE_DESC.resetValue();*/
			} catch (Exception exception) {
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			} 
	}


	public void resetAllComponents()
	{
		COMP_BUS_CUST_FAX_AREA_CODE.resetValue();
		COMP_CDU_BUS_ADDR1.resetValue();
		COMP_CDU_BUS_ADDR2.resetValue();
		COMP_CDU_BUS_ADDR3.resetValue();
		COMP_CDU_BUS_COUNTRY.resetValue();
		COMP_CDU_BUS_COUNTRY_DESC.resetValue();
		COMP_CDU_BUS_FAX.resetValue();
		COMP_CDU_CORRES_ADDR1.resetValue();
		COMP_CDU_CORRES_ADDR2.resetValue();
		COMP_CDU_CORRES_ADDR3.resetValue();
		COMP_CDU_CORRES_CITY_CODE.resetValue();
		COMP_CDU_CORRES_CITY_DESC.resetValue();
		COMP_CDU_CORRES_COUNTRY.resetValue();
		COMP_CDU_CORRES_COUNTRY_DESC.resetValue();
		COMP_CDU_CORRES_FAX.resetValue();
		COMP_CDU_CORRES_PHONE.resetValue();
		COMP_CDU_CUST_CODE.resetValue();
		
		/*Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
//		COMP_CDU_CUST_CODE_DESC.resetValue();
//		COMP_CDU_TITLE.resetValue();
//		COMP_CDU_CATG_CODE.resetValue();
		/*end*/
		COMP_CDU_CUST_MAR_STATUS.resetValue();
		COMP_CDU_MOBILE_NO.resetValue();
		COMP_CUST_BUS_TEL_AREA_CODE.resetValue();
		COMP_CUST_EMAIL_ID_OFF.resetValue();
		COMP_CUST_EMAIL_ID_PER.resetValue();
		COMP_CDU_PHY_POST_NO.resetValue();
		COMP_CDU_BUS_CITY_CODE.resetValue();
		COMP_CDU_CORRES_POST_NO.resetValue();
		COMP_CUST_BUS_TEL_AREA_CODE2.resetValue();
		COMP_CDU_BUS_PHONE.resetValue();
		COMP_CDU_BUS_MOBILE_NO.resetValue();
		COMP_CUST_FAX_AREA_CODE.resetValue();
		COMP_CUST_TEL_AREA_CODE2.resetValue();
		COMP_CDU_TEL_AREA_CODE.resetValue();
		
		/*added by raja on 31-05-2017 for ZBILQC-1724387*/
		//COMP_CDU_CUST_NAME.resetValue();
		/*end*/
		
		/*Added by saritha on 27-06-2017 for ssp call id ZBILQC-1730055*/
		COMP_CDU_FIRST_NAME.resetValue();
		COMP_CDU_MIDDLE_NAME.resetValue();
		COMP_CDU_SURNAME.resetValue();
		/*End*/	
		
		/*added by gopi  ZBILQC-1733435*/ 
		COMP_CDU_AGE_ADMITTED.resetValue();
		COMP_CDU_AGE_PROOF_FLAG.resetValue();
		COMP_CDU_AGE_PROOF_OTHERS.resetValue();
		/*COMP_CDU_BUS_AGE_ADMITTED.resetValue();
		COMP_CDU_BUS_AGE_PROOF_FLAG.resetValue();
		COMP_CDU_BUS_AGE_PROOF_OTHERS.resetValue();*/
		//end
		
		/*Added by Ameen on 11-05-2018 for KIC third address enabling*/
		COMP_CDU_OTH_ADDR1.resetValue();
		COMP_CDU_OTH_ADDR2.resetValue();
		COMP_CDU_OTH_ADDR3.resetValue();
		COMP_CDU_OTH_CITY_CODE.resetValue();
		COMP_CDU_OTH_CITY_DESC.resetValue();
		COMP_CDU_OTH_COUNTRY.resetValue();
		COMP_UI_M_CDU_OTH_COUNTRY_DESC.resetValue();
		COMP_CDU_OTH_TEL_AREA_CODE.resetValue();
		COMP_CDU_OTH_MOBILE_NO.resetValue();
		COMP_CDU_OTH_POST_NO.resetValue();
		COMP_CDU_OTH_TEL_AREA_CODE2.resetValue();
		COMP_CDU_OTH_PHONE.resetValue();
		COMP_CDU_OTH_FAX_AREA_CODE.resetValue();
		COMP_CDU_OTH_FAX.resetValue();
		COMP_CDU_EMAIL_ID_OTH.resetValue();
		COMP_CDU_CUST_REMARKS.resetValue();
		COMP_CDU_CUST_OCC_CODE.resetValue();
		COMP_UI_M_CDU_CUST_OCC_CODE_DESC.resetValue();
		COMP_CDU_CUST_NATIONALITY_CODE.resetValue();
		COMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC.resetValue();
		COMP_CDU_RESIDENCE.resetValue();
		COMP_CDU_OFFICE.resetValue();
		COMP_CDU_CORRES.resetValue();
		//end
	}
	
	public ArrayList<LovBean> lovCDU_CORRES_CITY_CODE(Object object) {

		ArrayList<LovBean> suggestionList = null;
		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
		/*end*/
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}

	public ArrayList<LovBean> lovCDU_CORRES_COUNTRY(Object object) {

		ArrayList<LovBean> suggestionList = null;

		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
		/*end*/
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}

	public ArrayList<LovBean> lovCUST_MAR_STATUS(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'MARI_STAT'  "
				+ " AND (PS_CODE LIKE ? OR PS_CODE_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	public void cancelModalPanel()
	{
		COMP_REPORT_MODAL_PANEL.setShowWhenRendered(false);
	}
	
	StringBuffer url=null;
	
	private String redirectUrl;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
			System.out.println("");
			System.out.println("");
			
			
			String url = null;		
			
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			url = request.getContextPath() + "/PREMIASchedule?";
			
			System.out.println("url   :  "+url);
		
			setRedirectUrl(url);
			//runActionAfterValidate();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	
	
	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			
			 Long CDU_SYS_ID= CUST_DTL_UPD_BEAN.getCDU_SYS_ID();
			System.out.println("Pol_Sys_id---------->"+CDU_SYS_ID);
			
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			
			System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			repInfo.setREP_VALUE_1("2");
			repInfo.setREP_VALUE_2("CDU_SYS_ID"+"&&&"+CDU_SYS_ID);
			
			
			Connection conn = CommonUtils.getConnection();
			int ins = new CRUDHandler().executeInsert(repInfo, conn);
			conn.commit();
			
			
			url=new StringBuffer(getRedirectUrl());
			url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID=PREMIREP211");
			
			setRedirectUrl(url.toString());
				if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
				response.sendRedirect(getRedirectUrl());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}

	/* Added by saritha on 27-06-2017 for ssp call id ZBILQC-1730055*/
	private HtmlInputText COMP_CDU_FIRST_NAME;
	private HtmlInputText COMP_CDU_MIDDLE_NAME;
	private HtmlInputText COMP_CDU_SURNAME;
	public HtmlInputText getCOMP_CDU_FIRST_NAME() {
		return COMP_CDU_FIRST_NAME;
	}
	public void setCOMP_CDU_FIRST_NAME(HtmlInputText cOMP_CDU_FIRST_NAME) {
		COMP_CDU_FIRST_NAME = cOMP_CDU_FIRST_NAME;
	}
	public HtmlInputText getCOMP_CDU_MIDDLE_NAME() {
		return COMP_CDU_MIDDLE_NAME;
	}
	public void setCOMP_CDU_MIDDLE_NAME(HtmlInputText cOMP_CDU_MIDDLE_NAME) {
		COMP_CDU_MIDDLE_NAME = cOMP_CDU_MIDDLE_NAME;
	}
	public HtmlInputText getCOMP_CDU_SURNAME() {
		return COMP_CDU_SURNAME;
	}
	public void setCOMP_CDU_SURNAME(HtmlInputText cOMP_CDU_SURNAME) {
		COMP_CDU_SURNAME = cOMP_CDU_SURNAME;
	}

	/*End*/
	
	/*added by gopi ZBILQC-1733435*/
	public void CDU_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		try {
			CUST_DTL_UPD_BEAN.setCDU_AGE_PROOF_FLAG((String) value);
			helper.CDU_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(this);
			COMP_CDU_AGE_PROOF_OTHERS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*public void CDU_BUS_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		try {
			CUST_DTL_UPD_BEAN.setCDU_BUS_AGE_PROOF_FLAG((String) value);
			helper.CDU_BUS_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(this);
			COMP_CDU_BUS_AGE_PROOF_OTHERS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	//end
	
	
	public void CDU_AGE_PROOF_OTHERS_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception {

		String val = (String) value;
		COMP_CDU_AGE_PROOF_OTHERS.setValue((String) val);
		CUST_DTL_UPD_BEAN.setCDU_AGE_PROOF_OTHERS(val);
		// COMP_POAD_AGE_PROOF_OTHERS.resetValue();
	}

	
	/*public void CDU_BUS_AGE_PROOF_OTHERS_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception {

		String val = (String) value;
		COMP_CDU_BUS_AGE_PROOF_OTHERS.setValue((String) val);
		CUST_DTL_UPD_BEAN.setCDU_BUS_AGE_PROOF_OTHERS(val);
		// COMP_POAD_AGE_PROOF_OTHERS.resetValue();
	}
*/
	public String callPrint(){
		String outcome="";
		outcome = "PILP134_CUSTOMER_DETL_PRINT";
		
		return outcome;
	}
	
/*Added by Ameen 02-05-2018 fro KIC enabling 3rd address fields*/
	
	private HtmlOutputLabel COMP_CDU_OTH_ADDR1_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_ADDR1;

	private HtmlOutputLabel COMP_CDU_OTH_ADDR2_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_ADDR2;

	private HtmlOutputLabel COMP_CDU_OTH_ADDR3_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_ADDR3;
	
	private HtmlOutputLabel COMP_CDU_OTH_CITY_CODE_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_CITY_CODE;

	private HtmlInputText COMP_CDU_OTH_CITY_DESC;
	
	private HtmlOutputLabel COMP_CDU_OTH_COUNTRY_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_COUNTRY;
	
	private HtmlInputText COMP_UI_M_CDU_OTH_COUNTRY_DESC;
	
	private HtmlInputText COMP_CDU_OTH_TEL_AREA_CODE;
	
	private HtmlOutputLabel COMP_CDU_OTH_MOBILE_NO_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_MOBILE_NO;
	
	private HtmlOutputLabel COMP_CDU_OTH_POST_NO_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_POST_NO;
	
	private HtmlInputText COMP_CDU_OTH_TEL_AREA_CODE2;
	
	private HtmlOutputLabel COMP_CDU_OTH_PHONE_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_PHONE;
	
	private HtmlInputText COMP_CDU_OTH_FAX_AREA_CODE;
	
	private HtmlOutputLabel COMP_CDU_OTH_FAX_LABEL;
	
	private HtmlInputText COMP_CDU_OTH_FAX;
	
	private HtmlOutputLabel COMP_CDU_EMAIL_ID_OTH_LABEL;
	
	private HtmlInputText COMP_CDU_EMAIL_ID_OTH;
	
	private HtmlSimpleTogglePanel CDU_OTH_ADDR_TOGGLE;
	
	private HtmlInputTextarea COMP_CDU_CUST_REMARKS;
	
	private HtmlInputText COMP_CDU_CUST_OCC_CODE;
	
	private HtmlInputText COMP_UI_M_CDU_CUST_OCC_CODE_DESC;
	
	private HtmlInputText COMP_CDU_CUST_NATIONALITY_CODE;
	
	private HtmlInputText COMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	
	public HtmlInputText getCOMP_UI_M_CDU_CUST_OCC_CODE_DESC() {
		return COMP_UI_M_CDU_CUST_OCC_CODE_DESC;
	}
	public void setCOMP_UI_M_CDU_CUST_OCC_CODE_DESC(
			HtmlInputText cOMP_UI_M_CDU_CUST_OCC_CODE_DESC) {
		COMP_UI_M_CDU_CUST_OCC_CODE_DESC = cOMP_UI_M_CDU_CUST_OCC_CODE_DESC;
	}
	public HtmlInputText getCOMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC() {
		return COMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	}
	public void setCOMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC(
			HtmlInputText cOMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC) {
		COMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC = cOMP_UI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	}
	
	public HtmlOutputLabel getCOMP_CDU_OTH_ADDR1_LABEL() {
		return COMP_CDU_OTH_ADDR1_LABEL;
	}
	public void setCOMP_CDU_OTH_ADDR1_LABEL(HtmlOutputLabel cOMP_CDU_OTH_ADDR1_LABEL) {
		COMP_CDU_OTH_ADDR1_LABEL = cOMP_CDU_OTH_ADDR1_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_ADDR1() {
		return COMP_CDU_OTH_ADDR1;
	}
	public void setCOMP_CDU_OTH_ADDR1(HtmlInputText cOMP_CDU_OTH_ADDR1) {
		COMP_CDU_OTH_ADDR1 = cOMP_CDU_OTH_ADDR1;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_ADDR2_LABEL() {
		return COMP_CDU_OTH_ADDR2_LABEL;
	}
	public void setCOMP_CDU_OTH_ADDR2_LABEL(HtmlOutputLabel cOMP_CDU_OTH_ADDR2_LABEL) {
		COMP_CDU_OTH_ADDR2_LABEL = cOMP_CDU_OTH_ADDR2_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_ADDR2() {
		return COMP_CDU_OTH_ADDR2;
	}
	public void setCOMP_CDU_OTH_ADDR2(HtmlInputText cOMP_CDU_OTH_ADDR2) {
		COMP_CDU_OTH_ADDR2 = cOMP_CDU_OTH_ADDR2;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_ADDR3_LABEL() {
		return COMP_CDU_OTH_ADDR3_LABEL;
	}
	public void setCOMP_CDU_OTH_ADDR3_LABEL(HtmlOutputLabel cOMP_CDU_OTH_ADDR3_LABEL) {
		COMP_CDU_OTH_ADDR3_LABEL = cOMP_CDU_OTH_ADDR3_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_ADDR3() {
		return COMP_CDU_OTH_ADDR3;
	}
	public void setCOMP_CDU_OTH_ADDR3(HtmlInputText cOMP_CDU_OTH_ADDR3) {
		COMP_CDU_OTH_ADDR3 = cOMP_CDU_OTH_ADDR3;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_CITY_CODE_LABEL() {
		return COMP_CDU_OTH_CITY_CODE_LABEL;
	}
	public void setCOMP_CDU_OTH_CITY_CODE_LABEL(
			HtmlOutputLabel cOMP_CDU_OTH_CITY_CODE_LABEL) {
		COMP_CDU_OTH_CITY_CODE_LABEL = cOMP_CDU_OTH_CITY_CODE_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_CITY_CODE() {
		return COMP_CDU_OTH_CITY_CODE;
	}
	public void setCOMP_CDU_OTH_CITY_CODE(HtmlInputText cOMP_CDU_OTH_CITY_CODE) {
		COMP_CDU_OTH_CITY_CODE = cOMP_CDU_OTH_CITY_CODE;
	}
	public HtmlInputText getCOMP_CDU_OTH_CITY_DESC() {
		return COMP_CDU_OTH_CITY_DESC;
	}
	public void setCOMP_CDU_OTH_CITY_DESC(HtmlInputText cOMP_CDU_OTH_CITY_DESC) {
		COMP_CDU_OTH_CITY_DESC = cOMP_CDU_OTH_CITY_DESC;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_COUNTRY_LABEL() {
		return COMP_CDU_OTH_COUNTRY_LABEL;
	}
	public void setCOMP_CDU_OTH_COUNTRY_LABEL(
			HtmlOutputLabel cOMP_CDU_OTH_COUNTRY_LABEL) {
		COMP_CDU_OTH_COUNTRY_LABEL = cOMP_CDU_OTH_COUNTRY_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_COUNTRY() {
		return COMP_CDU_OTH_COUNTRY;
	}
	public void setCOMP_CDU_OTH_COUNTRY(HtmlInputText cOMP_CDU_OTH_COUNTRY) {
		COMP_CDU_OTH_COUNTRY = cOMP_CDU_OTH_COUNTRY;
	}
	public HtmlInputText getCOMP_UI_M_CDU_OTH_COUNTRY_DESC() {
		return COMP_UI_M_CDU_OTH_COUNTRY_DESC;
	}
	public void setCOMP_UI_M_CDU_OTH_COUNTRY_DESC(
			HtmlInputText cOMP_UI_M_CDU_OTH_COUNTRY_DESC) {
		COMP_UI_M_CDU_OTH_COUNTRY_DESC = cOMP_UI_M_CDU_OTH_COUNTRY_DESC;
	}
	public HtmlInputText getCOMP_CDU_OTH_TEL_AREA_CODE() {
		return COMP_CDU_OTH_TEL_AREA_CODE;
	}
	public void setCOMP_CDU_OTH_TEL_AREA_CODE(
			HtmlInputText cOMP_CDU_OTH_TEL_AREA_CODE) {
		COMP_CDU_OTH_TEL_AREA_CODE = cOMP_CDU_OTH_TEL_AREA_CODE;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_MOBILE_NO_LABEL() {
		return COMP_CDU_OTH_MOBILE_NO_LABEL;
	}
	public void setCOMP_CDU_OTH_MOBILE_NO_LABEL(
			HtmlOutputLabel cOMP_CDU_OTH_MOBILE_NO_LABEL) {
		COMP_CDU_OTH_MOBILE_NO_LABEL = cOMP_CDU_OTH_MOBILE_NO_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_MOBILE_NO() {
		return COMP_CDU_OTH_MOBILE_NO;
	}
	public void setCOMP_CDU_OTH_MOBILE_NO(HtmlInputText cOMP_CDU_OTH_MOBILE_NO) {
		COMP_CDU_OTH_MOBILE_NO = cOMP_CDU_OTH_MOBILE_NO;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_POST_NO_LABEL() {
		return COMP_CDU_OTH_POST_NO_LABEL;
	}
	public void setCOMP_CDU_OTH_POST_NO_LABEL(
			HtmlOutputLabel cOMP_CDU_OTH_POST_NO_LABEL) {
		COMP_CDU_OTH_POST_NO_LABEL = cOMP_CDU_OTH_POST_NO_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_POST_NO() {
		return COMP_CDU_OTH_POST_NO;
	}
	public void setCOMP_CDU_OTH_POST_NO(HtmlInputText cOMP_CDU_OTH_POST_NO) {
		COMP_CDU_OTH_POST_NO = cOMP_CDU_OTH_POST_NO;
	}
	public HtmlInputText getCOMP_CDU_OTH_TEL_AREA_CODE2() {
		return COMP_CDU_OTH_TEL_AREA_CODE2;
	}
	public void setCOMP_CDU_OTH_TEL_AREA_CODE2(
			HtmlInputText cOMP_CDU_OTH_TEL_AREA_CODE2) {
		COMP_CDU_OTH_TEL_AREA_CODE2 = cOMP_CDU_OTH_TEL_AREA_CODE2;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_PHONE_LABEL() {
		return COMP_CDU_OTH_PHONE_LABEL;
	}
	public void setCOMP_CDU_OTH_PHONE_LABEL(HtmlOutputLabel cOMP_CDU_OTH_PHONE_LABEL) {
		COMP_CDU_OTH_PHONE_LABEL = cOMP_CDU_OTH_PHONE_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_PHONE() {
		return COMP_CDU_OTH_PHONE;
	}
	public void setCOMP_CDU_OTH_PHONE(HtmlInputText cOMP_CDU_OTH_PHONE) {
		COMP_CDU_OTH_PHONE = cOMP_CDU_OTH_PHONE;
	}
	public HtmlInputText getCOMP_CDU_OTH_FAX_AREA_CODE() {
		return COMP_CDU_OTH_FAX_AREA_CODE;
	}
	public void setCOMP_CDU_OTH_FAX_AREA_CODE(
			HtmlInputText cOMP_CDU_OTH_FAX_AREA_CODE) {
		COMP_CDU_OTH_FAX_AREA_CODE = cOMP_CDU_OTH_FAX_AREA_CODE;
	}
	public HtmlOutputLabel getCOMP_CDU_OTH_FAX_LABEL() {
		return COMP_CDU_OTH_FAX_LABEL;
	}
	public void setCOMP_CDU_OTH_FAX_LABEL(HtmlOutputLabel cOMP_CDU_OTH_FAX_LABEL) {
		COMP_CDU_OTH_FAX_LABEL = cOMP_CDU_OTH_FAX_LABEL;
	}
	public HtmlInputText getCOMP_CDU_OTH_FAX() {
		return COMP_CDU_OTH_FAX;
	}
	public void setCOMP_CDU_OTH_FAX(HtmlInputText cOMP_CDU_OTH_FAX) {
		COMP_CDU_OTH_FAX = cOMP_CDU_OTH_FAX;
	}
	public HtmlOutputLabel getCOMP_CDU_EMAIL_ID_OTH_LABEL() {
		return COMP_CDU_EMAIL_ID_OTH_LABEL;
	}
	public void setCOMP_CDU_EMAIL_ID_OTH_LABEL(
			HtmlOutputLabel cOMP_CDU_EMAIL_ID_OTH_LABEL) {
		COMP_CDU_EMAIL_ID_OTH_LABEL = cOMP_CDU_EMAIL_ID_OTH_LABEL;
	}
	public HtmlInputText getCOMP_CDU_EMAIL_ID_OTH() {
		return COMP_CDU_EMAIL_ID_OTH;
	}
	public void setCOMP_CDU_EMAIL_ID_OTH(HtmlInputText cOMP_CDU_EMAIL_ID_OTH) {
		COMP_CDU_EMAIL_ID_OTH = cOMP_CDU_EMAIL_ID_OTH;
	}
	public HtmlSimpleTogglePanel getCDU_OTH_ADDR_TOGGLE() {
		return CDU_OTH_ADDR_TOGGLE;
	}
	public void setCDU_OTH_ADDR_TOGGLE(HtmlSimpleTogglePanel cDU_OTH_ADDR_TOGGLE) {
		CDU_OTH_ADDR_TOGGLE = cDU_OTH_ADDR_TOGGLE;
	}
	
	public HtmlInputTextarea getCOMP_CDU_CUST_REMARKS() {
		return COMP_CDU_CUST_REMARKS;
	}
	public void setCOMP_CDU_CUST_REMARKS(HtmlInputTextarea cOMP_CDU_CUST_REMARKS) {
		COMP_CDU_CUST_REMARKS = cOMP_CDU_CUST_REMARKS;
	}
	public HtmlInputText getCOMP_CDU_CUST_OCC_CODE() {
		return COMP_CDU_CUST_OCC_CODE;
	}
	public void setCOMP_CDU_CUST_OCC_CODE(HtmlInputText cOMP_CDU_CUST_OCC_CODE) {
		COMP_CDU_CUST_OCC_CODE = cOMP_CDU_CUST_OCC_CODE;
	}
	
	public HtmlInputText getCOMP_CDU_CUST_NATIONALITY_CODE() {
		return COMP_CDU_CUST_NATIONALITY_CODE;
	}
	public void setCOMP_CDU_CUST_NATIONALITY_CODE(
			HtmlInputText cOMP_CDU_CUST_NATIONALITY_CODE) {
		COMP_CDU_CUST_NATIONALITY_CODE = cOMP_CDU_CUST_NATIONALITY_CODE;
	}
	
	public List<LovBean> lovCDU_OTH_CITY_CODE(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PM006_A_APAC", "PM_CUSTOMER",
					"CUST_PHY_CITY_CODE","CITY", null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CUST_PHY_CITY_CODE", e.getMessage());
		}
		return suggestionList;
	}
	
	public ArrayList<LovBean> lovCDU_OTH_COUNTRY(Object object) {

		ArrayList<LovBean> suggestionList = null;

		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	

	public ArrayList<LovBean> lovCUST_OCC_CODE(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_OCCU' "
				+ " AND (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	public ArrayList<LovBean> lovCUST_NATIONALITY_CODE(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'NATLITY' AND	NVL(PC_FRZ_FLAG,'N') = 'N'  "
				+ " AND (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	private HtmlSelectBooleanCheckbox COMP_CDU_RESIDENCE;
	
	private HtmlSelectBooleanCheckbox COMP_CDU_OFFICE;
	
	private HtmlSelectBooleanCheckbox COMP_CDU_CORRES;
	
	
	public HtmlSelectBooleanCheckbox getCOMP_CDU_RESIDENCE() {
		return COMP_CDU_RESIDENCE;
	}
	public void setCOMP_CDU_RESIDENCE(HtmlSelectBooleanCheckbox cOMP_CDU_RESIDENCE) {
		COMP_CDU_RESIDENCE = cOMP_CDU_RESIDENCE;
	}
	public HtmlSelectBooleanCheckbox getCOMP_CDU_OFFICE() {
		return COMP_CDU_OFFICE;
	}
	public void setCOMP_CDU_OFFICE(HtmlSelectBooleanCheckbox cOMP_CDU_OFFICE) {
		COMP_CDU_OFFICE = cOMP_CDU_OFFICE;
	}
	public HtmlSelectBooleanCheckbox getCOMP_CDU_CORRES() {
		return COMP_CDU_CORRES;
	}
	public void setCOMP_CDU_CORRES(HtmlSelectBooleanCheckbox cOMP_CDU_CORRES) {
		COMP_CDU_CORRES = cOMP_CDU_CORRES;
	}
	
	public void communicationAddrRes(ActionEvent actionEvent){
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		try{
			boolean check = (boolean) input.getSubmittedValue();
			COMP_CDU_RESIDENCE.setSelected(check);
			
			if(COMP_CDU_RESIDENCE.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(false);
				COMP_CDU_OFFICE.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_COR_ADDR_FLG(false);
				COMP_CDU_CORRES.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("H");
			}else if(COMP_CDU_CORRES.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
				COMP_CDU_RESIDENCE.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(false);
				COMP_CDU_OFFICE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("C");
			}else{
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(true);
				COMP_CDU_OFFICE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("O");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void communicationAddrOff(ActionEvent actionEvent){
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		try{
			boolean check = (boolean) input.getSubmittedValue();
			COMP_CDU_OFFICE.setSelected(check);
			
			if(COMP_CDU_OFFICE.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
				COMP_CDU_RESIDENCE.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_COR_ADDR_FLG(false);
				COMP_CDU_CORRES.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("O");
			}else if(COMP_CDU_CORRES.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
				COMP_CDU_RESIDENCE.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(false);
				COMP_CDU_OFFICE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("C");
			}else{
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(true);
				COMP_CDU_RESIDENCE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("H");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void communicationAddrOther(ActionEvent actionEvent){
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		try{
			boolean check = (boolean) input.getSubmittedValue();
			COMP_CDU_CORRES.setSelected(check);
			
			if(COMP_CDU_CORRES.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
				COMP_CDU_RESIDENCE.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(false);
				COMP_CDU_OFFICE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("C");
			}else if(COMP_CDU_OFFICE.isSelected()){
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_COR_ADDR_FLG(false);
				COMP_CDU_CORRES.resetValue();
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
				COMP_CDU_RESIDENCE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("O");
			}else{
				CUST_DTL_UPD_BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(true);
				COMP_CDU_RESIDENCE.resetValue();
				
				CUST_DTL_UPD_BEAN.setCDU_CUST_COMM_ADDR_FLG("H");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public HtmlOutputLabel getCOMP_CUST_CATG_CODE_LABEL() {
		return COMP_CUST_CATG_CODE_LABEL;
	}
	public void setCOMP_CUST_CATG_CODE_LABEL(HtmlOutputLabel cOMP_CUST_CATG_CODE_LABEL) {
		COMP_CUST_CATG_CODE_LABEL = cOMP_CUST_CATG_CODE_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_CDU_CATG_CODE_DESC() {
		return COMP_UI_M_CDU_CATG_CODE_DESC;
	}
	public void setCOMP_UI_M_CDU_CATG_CODE_DESC(
			HtmlInputText cOMP_UI_M_CDU_CATG_CODE_DESC) {
		COMP_UI_M_CDU_CATG_CODE_DESC = cOMP_UI_M_CDU_CATG_CODE_DESC;
	}
	
	/*End*/
	
	/*Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
	
	
	public void validatorCDU_CATG_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			CUST_DTL_UPD_BEAN.setCDU_CATG_CODE((String) value);
			helper.when_validate_item_cust_catg_code(CUST_DTL_UPD_BEAN);
			COMP_UI_M_CDU_CATG_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> lovCDU_CATG_CODE(
		    Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'CATG' AND  " +
				" (PS_CODE LIKE ? OR PS_CODE_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

		    String currentValue = (String) object;
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		  
		    	 suggestionList = ListItemUtil.prepareSuggestionList(query1,new Object[]{currentValue,currentValue,PELConstants.suggetionRecordSize});

		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return suggestionList;
	  }
	
	public void validatorCDU_TITLE(FacesContext context,
			UIComponent component, Object value) {
		try {
			
			CUST_DTL_UPD_BEAN.setCDU_TITLE((String) COMP_CDU_TITLE.getSubmittedValue());
			System.out.println(" cust title   ===  >"+CUST_DTL_UPD_BEAN.getCDU_TITLE());
			helper.when_validate_item_CDU_TITLE(CUST_DTL_UPD_BEAN);
			
			helper
			.when_validate_item_cust_catg_code(CUST_DTL_UPD_BEAN);
			COMP_UI_M_CDU_CATG_CODE_DESC.resetValue();
			COMP_CDU_CATG_CODE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public HtmlInputText getCOMP_CDU_CATG_CODE() {
		return COMP_CDU_CATG_CODE;
	}
	public void setCOMP_CDU_CATG_CODE(HtmlInputText cOMP_CDU_CATG_CODE) {
		COMP_CDU_CATG_CODE = cOMP_CDU_CATG_CODE;
	}
	public HtmlOutputLabel getCOMP_CDU_NAME_LABEL() {
		return COMP_CDU_NAME_LABEL;
	}
	public void setCOMP_CDU_NAME_LABEL(HtmlOutputLabel cOMP_CDU_NAME_LABEL) {
		COMP_CDU_NAME_LABEL = cOMP_CDU_NAME_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_CDU_TITLE() {
		return COMP_CDU_TITLE;
	}
	public void setCOMP_CDU_TITLE(HtmlSelectOneMenu cOMP_CDU_TITLE) {
		COMP_CDU_TITLE = cOMP_CDU_TITLE;
	}
	public List<SelectItem> getItemListName() {
		return itemListName;
	}
	public void setItemListName(List<SelectItem> itemListName) {
		this.itemListName = itemListName;
	}
	
}

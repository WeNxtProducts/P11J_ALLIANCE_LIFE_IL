package com.iii.pel.forms.PILM074_APAC;

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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_DELEGATE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_LIFE_TAX_HEADER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TH_TAX_TYPE_LABEL;

	private HtmlInputText COMP_TH_TAX_TYPE;

	private HtmlOutputLabel COMP_TH_TAX_DESC_LABEL;

	private HtmlInputText COMP_TH_TAX_DESC;

	private HtmlOutputLabel COMP_TH_TAX_LONG_DESC_LABEL;

	private HtmlInputText COMP_TH_TAX_LONG_DESC;

	private HtmlOutputLabel COMP_TH_TAX_SHORT_DESC_LABEL;

	private HtmlInputText COMP_TH_TAX_SHORT_DESC;

	private HtmlOutputLabel COMP_TH_TAX_CALC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_TH_TAX_CALC_TYPE;

	private HtmlOutputLabel COMP_TH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TH_EFF_FM_DT;

	private HtmlOutputLabel COMP_TH_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TH_EFF_TO_DT;

	private HtmlCommandButton COMP_TH_TAX_TYPE_BUT;

	private PM_LIFE_TAX_HEADER PM_LIFE_TAX_HEADER_BEAN;

	private ArrayList<SelectItem> taxCalcType;
	
	private ArrayList<PM_LIFE_TAX_HEADER> taxTypeList;

	public PM_LIFE_TAX_HEADER_ACTION() {
		
		PM_LIFE_TAX_HEADER_BEAN = new PM_LIFE_TAX_HEADER();
		
		PILM074_APAC_DELEGATE delegate = new PILM074_APAC_DELEGATE();
		taxCalcType = delegate.selectValueForComboBox("PILM074_APAC", "PM_LIFE_TAX_HEADER", "PM_LIFE_TAX_HEADER.TH_TAX_CALC_TYPE");
		listTH_LOCATION= getDropDownListValue ("PILM074_APAC",
					"PM_LIFE_TAX_HEADER",
					"PM_LIFE_TAX_HEADER.TH_LOCATION", "IL_LOCATION");
		
		listTH_VAT_YN= getDropDownListValue ("PILM074_APAC",
				"PM_LIFE_TAX_HEADER",
				"PM_LIFE_TAX_HEADER.TH_VAT_YN", "YESNO");
		
		 /*Modified by Janani on 25.04.2020 for Orient UAT
		desc : As suggested by Girish for VAT*/
		
		/*listTH_VAT_TRTMT= getDropDownListValue ("PILM074_APAC",
				"PM_LIFE_TAX_HEADER",
				"PM_LIFE_TAX_HEADER.TH_VAT_TRTMT", "IL_VAT_CAT");*/
		
		listTH_VAT_TRTMT= getDropDownListValue ("PILM074_APAC",
				"PM_LIFE_TAX_HEADER",
				"PM_LIFE_TAX_HEADER.TH_VAT_CATG", "IL_VAT_CATG");
		
		/*End*/
		
		setListTH_SELF_INVOICE_YN(getDropDownListValue ("PILM074_APAC",
				"PM_LIFE_TAX_HEADER",
				"PM_LIFE_TAX_HEADER.TH_SELF_INVOICE_YN", "YESNO"));
		listTH_VAT_RECOVER_YN = getDropDownListValue("PILM074_APAC","PM_LIFE_TAX_HEADER", "PM_LIFE_TAX_HEADER.TH_VAT_RECOVER_YN", "YESNO");
	}

	public HtmlOutputLabel getCOMP_TH_TAX_TYPE_LABEL() {
		return COMP_TH_TAX_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_TH_TAX_TYPE() {
		return COMP_TH_TAX_TYPE;
	}

	public void setCOMP_TH_TAX_TYPE_LABEL(HtmlOutputLabel COMP_TH_TAX_TYPE_LABEL) {
		this.COMP_TH_TAX_TYPE_LABEL = COMP_TH_TAX_TYPE_LABEL;
	}

	public void setCOMP_TH_TAX_TYPE(HtmlInputText COMP_TH_TAX_TYPE) {
		this.COMP_TH_TAX_TYPE = COMP_TH_TAX_TYPE;
	}

	public HtmlOutputLabel getCOMP_TH_TAX_DESC_LABEL() {
		return COMP_TH_TAX_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TH_TAX_DESC() {
		return COMP_TH_TAX_DESC;
	}

	public void setCOMP_TH_TAX_DESC_LABEL(HtmlOutputLabel COMP_TH_TAX_DESC_LABEL) {
		this.COMP_TH_TAX_DESC_LABEL = COMP_TH_TAX_DESC_LABEL;
	}

	public void setCOMP_TH_TAX_DESC(HtmlInputText COMP_TH_TAX_DESC) {
		this.COMP_TH_TAX_DESC = COMP_TH_TAX_DESC;
	}

	public HtmlOutputLabel getCOMP_TH_TAX_LONG_DESC_LABEL() {
		return COMP_TH_TAX_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TH_TAX_LONG_DESC() {
		return COMP_TH_TAX_LONG_DESC;
	}

	public void setCOMP_TH_TAX_LONG_DESC_LABEL(HtmlOutputLabel COMP_TH_TAX_LONG_DESC_LABEL) {
		this.COMP_TH_TAX_LONG_DESC_LABEL = COMP_TH_TAX_LONG_DESC_LABEL;
	}

	public void setCOMP_TH_TAX_LONG_DESC(HtmlInputText COMP_TH_TAX_LONG_DESC) {
		this.COMP_TH_TAX_LONG_DESC = COMP_TH_TAX_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_TH_TAX_SHORT_DESC_LABEL() {
		return COMP_TH_TAX_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TH_TAX_SHORT_DESC() {
		return COMP_TH_TAX_SHORT_DESC;
	}

	public void setCOMP_TH_TAX_SHORT_DESC_LABEL(HtmlOutputLabel COMP_TH_TAX_SHORT_DESC_LABEL) {
		this.COMP_TH_TAX_SHORT_DESC_LABEL = COMP_TH_TAX_SHORT_DESC_LABEL;
	}

	public void setCOMP_TH_TAX_SHORT_DESC(HtmlInputText COMP_TH_TAX_SHORT_DESC) {
		this.COMP_TH_TAX_SHORT_DESC = COMP_TH_TAX_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_TH_TAX_CALC_TYPE_LABEL() {
		return COMP_TH_TAX_CALC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_TAX_CALC_TYPE() {
		return COMP_TH_TAX_CALC_TYPE;
	}

	public void setCOMP_TH_TAX_CALC_TYPE_LABEL(HtmlOutputLabel COMP_TH_TAX_CALC_TYPE_LABEL) {
		this.COMP_TH_TAX_CALC_TYPE_LABEL = COMP_TH_TAX_CALC_TYPE_LABEL;
	}

	public void setCOMP_TH_TAX_CALC_TYPE(HtmlSelectOneMenu COMP_TH_TAX_CALC_TYPE) {
		this.COMP_TH_TAX_CALC_TYPE = COMP_TH_TAX_CALC_TYPE;
	}

	public HtmlOutputLabel getCOMP_TH_EFF_FM_DT_LABEL() {
		return COMP_TH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TH_EFF_FM_DT() {
		return COMP_TH_EFF_FM_DT;
	}

	public void setCOMP_TH_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_TH_EFF_FM_DT_LABEL) {
		this.COMP_TH_EFF_FM_DT_LABEL = COMP_TH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_TH_EFF_FM_DT(HtmlCalendar COMP_TH_EFF_FM_DT) {
		this.COMP_TH_EFF_FM_DT = COMP_TH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_TH_EFF_TO_DT_LABEL() {
		return COMP_TH_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TH_EFF_TO_DT() {
		return COMP_TH_EFF_TO_DT;
	}

	public void setCOMP_TH_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_TH_EFF_TO_DT_LABEL) {
		this.COMP_TH_EFF_TO_DT_LABEL = COMP_TH_EFF_TO_DT_LABEL;
	}

	public void setCOMP_TH_EFF_TO_DT(HtmlCalendar COMP_TH_EFF_TO_DT) {
		this.COMP_TH_EFF_TO_DT = COMP_TH_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_TH_TAX_TYPE_BUT() {
		return COMP_TH_TAX_TYPE_BUT;
	}

	public void setCOMP_TH_TAX_TYPE_BUT(HtmlCommandButton COMP_TH_TAX_TYPE_BUT) {
		this.COMP_TH_TAX_TYPE_BUT = COMP_TH_TAX_TYPE_BUT;
	}

	public PM_LIFE_TAX_HEADER getPM_LIFE_TAX_HEADER_BEAN() {
		return PM_LIFE_TAX_HEADER_BEAN;
	}

	public void setPM_LIFE_TAX_HEADER_BEAN(PM_LIFE_TAX_HEADER PM_LIFE_TAX_HEADER_BEAN) {
		this.PM_LIFE_TAX_HEADER_BEAN = PM_LIFE_TAX_HEADER_BEAN;
	}
	
	public ArrayList<PM_LIFE_TAX_HEADER> getTaxTypeList() {
		return taxTypeList;
	}

	public void setTaxTypeList(ArrayList<PM_LIFE_TAX_HEADER> taxTypeList) {
		this.taxTypeList = taxTypeList;
	}
	
	/** Previous Page Navigation is Handled Here. */
	public String navigateToSearchPage(){
		//Modified by kavitha on 04.10.2019 for orient
		//return "PILM074_APAC_LifeTaxSearchPage";
		return "NAVIGATE_TO_COMMON_SEARCH";
	}
	/** Previous Page Navigation is Handled Here. */
	
	/** CRUD Operations for this block are handled here
	 * @throws Exception */
	public void insertHeaderData(ActionEvent event) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		int insert = 0;
		String message = null;
		if(getPM_LIFE_TAX_HEADER_BEAN().getROWID()!= null){
			message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
			System.out.println("ROWID = "+getPM_LIFE_TAX_HEADER_BEAN().getROWID());
			Connection con = getConnection();
			String M_TEMP = PRE_UPDATE_TRIGGER_HDR();
			if(!"".equals(M_TEMP)){
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "91011"));
			}else{
				getErrorMap().clear();
				insert = handler.executeUpdate(PM_LIFE_TAX_HEADER_BEAN, con);
				con.commit();
			}
		}else{
			message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
			System.out.println("ROWID = "+getPM_LIFE_TAX_HEADER_BEAN().getROWID());
			Connection con = getConnection();
			String M_TEMP = PRE_INSERT_TRIGGER_HDR();
			if(!"".equals(M_TEMP)){
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "91011"));
			}else{
				getErrorMap().clear();
				insert = handler.executeInsert(PM_LIFE_TAX_HEADER_BEAN, con);
				con.commit();
			}
		}
		if (insert == 1) {
			getWarningMap().put("current", message);
			getWarningMap().put("detail", message);
		}
	}
	
	private String PRE_UPDATE_TRIGGER_HDR() throws Exception {
		/* L_DUP_CHECK_TAX_HEADER; */
		String M_TEMP = L_DUP_CHECK_TAX_HEADER();
		return M_TEMP;
	}

	public String PRE_INSERT_TRIGGER_HDR() throws Exception{
		/* L_DUP_CHECK_TAX_HEADER; */
		String M_TEMP = L_DUP_CHECK_TAX_HEADER();
		return M_TEMP;
	}
	/** CRUD Operations for this block are handled here
	 * @throws Exception */
	
	private String L_DUP_CHECK_TAX_HEADER() throws Exception {
		String M_TEMP = "";
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00188: While updating, its giving combination already exist error. Fixed by : Mallika.S, 02-Apr-2009*/
		String rowId = getPM_LIFE_TAX_HEADER_BEAN().getROWID();
		String query1 = "SELECT 'X' FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = '"+getPM_LIFE_TAX_HEADER_BEAN().getTH_TAX_TYPE()+"'";
//		System.out.println("Query1 = "+query1);
		String query2 = "SELECT 'X' FROM PM_LIFE_TAX_HEADER " +
				"WHERE TH_TAX_TYPE = '"+getPM_LIFE_TAX_HEADER_BEAN().getTH_TAX_TYPE()+"' AND ROWID != '"+rowId+"'";
//		System.out.println("Query2 = "+query2);
		if (rowId == null) {
			M_TEMP = L_DUP_CHECK_TAX_HEADER_DELEGATE(query1);
		}else{
			M_TEMP = L_DUP_CHECK_TAX_HEADER_DELEGATE(query2);
		}
		
		
		return M_TEMP;
	}

	public String L_DUP_CHECK_TAX_HEADER_DELEGATE(String query) throws Exception{
		String M_TEMP = "";
		Connection con = getConnection();
		CRUDHandler crudHandler = new CRUDHandler();
		ResultSet rs = crudHandler.executeSelectStatement(query, con);
		while(rs.next()){
			M_TEMP = rs.getString(1);
		}
		CommonUtils.closeCursor(rs);
		return M_TEMP;
	}
	
	/** Database Connection*/
	private Connection getConnection() throws Exception{
		Connection con = CommonUtils.getConnection();
		return con;
	}
	/** Database Connection*/
	
	
	public ArrayList<SelectItem> getTaxCalcType() {
		return taxCalcType;
	}

	public void setTaxCalcType(ArrayList<SelectItem> taxCalcType) {
		this.taxCalcType = taxCalcType;
	}
	
	public void redirectToLifeTaxHead(String rowId) {
		PILM074_APAC_DELEGATE delegate = new PILM074_APAC_DELEGATE();
		PM_LIFE_TAX_HEADER_BEAN = delegate.fetchLifeTaxHeadDetails(rowId);
		PILM074_APAC_HELPER helper = new PILM074_APAC_HELPER();
		String taxType = PM_LIFE_TAX_HEADER_BEAN.getTH_TAX_TYPE();
		String taxDesc = helper.POST_QUERY_TRIGGER_HDR(taxType);
		PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_DESC(taxDesc);
	}
	
	public ArrayList<PM_LIFE_TAX_HEADER> lovForTaxType(Object event) {
		String taxType = (String) event;
		taxTypeList = new PILM074_APAC_DELEGATE().prepareTaxTypeList(taxType, taxTypeList);
		return taxTypeList;
	}

	public void getTaxTypeDesc(ActionEvent event) {
		if (COMP_TH_TAX_TYPE.getSubmittedValue() != null) {
			String taxType = (String) COMP_TH_TAX_TYPE.getSubmittedValue();
			String taxTypeDesc = new PILM074_APAC_DELEGATE()
			.getTaxTypeDesc(taxType, taxTypeList);
			COMP_TH_TAX_DESC.setSubmittedValue(taxTypeDesc);
			PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_DESC(taxTypeDesc);
		}
	}

	public void validateTH_TAX_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException{
		if (COMP_TH_TAX_TYPE.getSubmittedValue() != null) {
			String taxType = (String) COMP_TH_TAX_TYPE.getSubmittedValue();
			String taxTypeDesc = new PILM074_APAC_HELPER().POST_QUERY_TRIGGER_HDR(taxType);
			if (taxTypeDesc == null) {
				throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "91927")));
			}else{
			COMP_TH_TAX_DESC.setSubmittedValue(taxTypeDesc);
			PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_DESC(taxTypeDesc);
			}
		}
	}
	
	public void TH_TAX_TYPE_ACTION(ActionEvent event){
		getWarningMap().clear();
		UIInput inputText = (UIInput) event.getComponent().getParent();
		if (inputText.getSubmittedValue() != null) {
			String taxType = inputText.getSubmittedValue().toString();
			PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_TYPE(taxType);
			String taxTypeDesc = new PILM074_APAC_DELEGATE()
			.getTaxTypeDesc(taxType, taxTypeList);
			COMP_TH_TAX_DESC.setSubmittedValue(taxTypeDesc);
			PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_DESC(taxTypeDesc);
		}else{
			COMP_TH_TAX_DESC.setSubmittedValue(null);
			PM_LIFE_TAX_HEADER_BEAN.setTH_TAX_DESC(null);
		}
		ErrorHelpUtil.validate(inputText, getErrorMap());
	}
	
	public void validateTH_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput inputText = (UIInput) component;
		Date effFromDate = this.getCOMP_TH_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		PM_LIFE_TAX_HEADER_BEAN.setTH_EFF_FM_DT(effFromDate);
		Date effToDate = PM_LIFE_TAX_HEADER_BEAN.getTH_EFF_FM_DT();
		new PILM074_APAC_HELPER().whenValidate_TH_EFF_FM_DT(this,effFromDate, effToDate);
	}
	
	public void TH_EFF_FM_DT_ACTION(ActionEvent event){
		getWarningMap().clear();
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effFromDate = this.getCOMP_TH_EFF_FM_DT().getAsDate(inputText.getSubmittedValue());
		PM_LIFE_TAX_HEADER_BEAN.setTH_EFF_FM_DT(effFromDate);
		Date effToDate = PM_LIFE_TAX_HEADER_BEAN.getTH_EFF_TO_DT();
		new PILM074_APAC_HELPER().whenValidate_TH_EFF_FM_DT(this,effFromDate, effToDate);
		ErrorHelpUtil.validate(inputText, getErrorMap());
	}
	
	public void validateTH_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		UIInput inputText = (UIInput) component;
		Date effToDate = this.getCOMP_TH_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		PM_LIFE_TAX_HEADER_BEAN.setTH_EFF_TO_DT(effToDate);
		Date effFromDate = PM_LIFE_TAX_HEADER_BEAN.getTH_EFF_FM_DT();
		try {
			new PILM074_APAC_HELPER().whenValidate_TH_EFF_TO_DT(this,
					effFromDate, effToDate);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void TH_EFF_TO_DT_ACTION(ActionEvent event){
		getWarningMap().clear();
		UIInput inputText = (UIInput) event.getComponent().getParent();
		Date effToDate = this.getCOMP_TH_EFF_TO_DT().getAsDate(inputText.getSubmittedValue());
		PM_LIFE_TAX_HEADER_BEAN.setTH_EFF_TO_DT(effToDate);
		Date effFromDate = PM_LIFE_TAX_HEADER_BEAN.getTH_EFF_FM_DT();
		try {
			new PILM074_APAC_HELPER().whenValidate_TH_EFF_TO_DT(this,
					effFromDate, effToDate);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	public String deleteLifeTaxSetup() {
		new PILM074_APAC_DELEGATE().deleteLifeTaxHeader(this);
		return null;
	}
	
	public void resetAllComponent() {
		COMP_TH_EFF_FM_DT.resetValue();
		COMP_TH_EFF_TO_DT.resetValue();
		COMP_TH_TAX_CALC_TYPE.resetValue();
		COMP_TH_TAX_DESC.resetValue();
		COMP_TH_TAX_LONG_DESC.resetValue();
		COMP_TH_TAX_SHORT_DESC.resetValue();
		COMP_TH_TAX_TYPE.resetValue();
	}
	
	
    //Added by kavitha on 07.10.2019 for orient
	private HtmlOutputLabel COMP_TH_LOCATION_LABEL;
	private HtmlSelectOneMenu COMP_TH_LOCATION;
	private HtmlOutputLabel COMP_TH_VAT_YN_LABEL;
	private HtmlSelectOneMenu COMP_TH_VAT_YN;
	private HtmlOutputLabel COMP_TH_VAT_PERC_LABEL;
	private HtmlInputText COMP_TH_VAT_PERC;
	private HtmlOutputLabel COMP_TH_VAT_TRTMT_LABEL;
	private HtmlSelectOneMenu COMP_TH_VAT_TRTMT;
	private HtmlOutputLabel COMP_TH_SELF_INVOICE_YN_LABEL;
	private HtmlSelectOneMenu COMP_TH_SELF_INVOICE_YN;
	private List<SelectItem> listTH_LOCATION = new ArrayList<SelectItem>();
	private List<SelectItem> listTH_VAT_YN = new ArrayList<SelectItem>();
	private List<SelectItem> listTH_VAT_TRTMT = new ArrayList<SelectItem>();
	private List<SelectItem> listTH_SELF_INVOICE_YN = new ArrayList<SelectItem>();
	
	
	public void validateTH_LOCATION(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_LOCATION(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTH_VAT_YN(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_VAT_YN(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTH_VAT_PERC(FacesContext context,UIComponent component,Object object){
		Integer value = (Integer) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_VAT_PERC(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTH_VAT_TRTMT(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_VAT_TRTMT(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTH_SELF_INVOICE_YN(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_SELF_INVOICE_YN(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void fireFieldValidation(ActionEvent actionEvent) {

		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public HtmlOutputLabel getCOMP_TH_LOCATION_LABEL() {
		return COMP_TH_LOCATION_LABEL;
	}

	public void setCOMP_TH_LOCATION_LABEL(HtmlOutputLabel cOMP_TH_LOCATION_LABEL) {
		COMP_TH_LOCATION_LABEL = cOMP_TH_LOCATION_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_LOCATION() {
		return COMP_TH_LOCATION;
	}

	public void setCOMP_TH_LOCATION(HtmlSelectOneMenu cOMP_TH_LOCATION) {
		COMP_TH_LOCATION = cOMP_TH_LOCATION;
	}

	public List<SelectItem> getListTH_LOCATION() {
		if (listTH_LOCATION.size() == 0) {
			listTH_LOCATION.clear();
			try {
				listTH_LOCATION = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTH_LOCATION;
	}
	
	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), formName, blockName, blockFieldName,filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return listValues;
	}

	public void setListTH_LOCATION(List<SelectItem> listTH_LOCATION) {
		this.listTH_LOCATION = listTH_LOCATION;
	}

	public HtmlOutputLabel getCOMP_TH_VAT_YN_LABEL() {
		return COMP_TH_VAT_YN_LABEL;
	}

	public void setCOMP_TH_VAT_YN_LABEL(HtmlOutputLabel cOMP_TH_VAT_YN_LABEL) {
		COMP_TH_VAT_YN_LABEL = cOMP_TH_VAT_YN_LABEL;
	}

	

	public HtmlSelectOneMenu getCOMP_TH_VAT_YN() {
		return COMP_TH_VAT_YN;
	}

	public void setCOMP_TH_VAT_YN(HtmlSelectOneMenu cOMP_TH_VAT_YN) {
		COMP_TH_VAT_YN = cOMP_TH_VAT_YN;
	}

	public List<SelectItem> getListTH_VAT_YN() {
		if (listTH_VAT_YN.size() == 0) {
			listTH_VAT_YN.clear();
			try {
				listTH_VAT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTH_VAT_YN;
	}

	public void setListTH_VAT_YN(List<SelectItem> listTH_VAT_YN) {
		this.listTH_VAT_YN = listTH_VAT_YN;
	}

	public HtmlOutputLabel getCOMP_TH_VAT_PERC_LABEL() {
		return COMP_TH_VAT_PERC_LABEL;
	}

	public void setCOMP_TH_VAT_PERC_LABEL(HtmlOutputLabel cOMP_TH_VAT_PERC_LABEL) {
		COMP_TH_VAT_PERC_LABEL = cOMP_TH_VAT_PERC_LABEL;
	}

	public HtmlInputText getCOMP_TH_VAT_PERC() {
		return COMP_TH_VAT_PERC;
	}

	public void setCOMP_TH_VAT_PERC(HtmlInputText cOMP_TH_VAT_PERC) {
		COMP_TH_VAT_PERC = cOMP_TH_VAT_PERC;
	}

	public HtmlOutputLabel getCOMP_TH_VAT_TRTMT_LABEL() {
		return COMP_TH_VAT_TRTMT_LABEL;
	}

	public void setCOMP_TH_VAT_TRTMT_LABEL(HtmlOutputLabel cOMP_TH_VAT_TRTMT_LABEL) {
		COMP_TH_VAT_TRTMT_LABEL = cOMP_TH_VAT_TRTMT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_VAT_TRTMT() {
		return COMP_TH_VAT_TRTMT;
	}

	public void setCOMP_TH_VAT_TRTMT(HtmlSelectOneMenu cOMP_TH_VAT_TRTMT) {
		COMP_TH_VAT_TRTMT = cOMP_TH_VAT_TRTMT;
	}

	public List<SelectItem> getListTH_VAT_TRTMT() {
		if (listTH_VAT_TRTMT.size() == 0) {
			listTH_VAT_TRTMT.clear();
			try {
				listTH_VAT_TRTMT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTH_VAT_TRTMT;
	}

	public void setListTH_VAT_TRTMT(List<SelectItem> listTH_VAT_TRTMT) {
		this.listTH_VAT_TRTMT = listTH_VAT_TRTMT;
	}

	public HtmlOutputLabel getCOMP_TH_SELF_INVOICE_YN_LABEL() {
		return COMP_TH_SELF_INVOICE_YN_LABEL;
	}

	public void setCOMP_TH_SELF_INVOICE_YN_LABEL(
			HtmlOutputLabel cOMP_TH_SELF_INVOICE_YN_LABEL) {
		COMP_TH_SELF_INVOICE_YN_LABEL = cOMP_TH_SELF_INVOICE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_SELF_INVOICE_YN() {
		return COMP_TH_SELF_INVOICE_YN;
	}

	public void setCOMP_TH_SELF_INVOICE_YN(HtmlSelectOneMenu cOMP_TH_SELF_INVOICE_YN) {
		COMP_TH_SELF_INVOICE_YN = cOMP_TH_SELF_INVOICE_YN;
	}

	public List<SelectItem> getListTH_SELF_INVOICE_YN() {
		if (listTH_SELF_INVOICE_YN.size() == 0) {
			listTH_SELF_INVOICE_YN.clear();
			try {
				listTH_SELF_INVOICE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTH_SELF_INVOICE_YN;
	}

	public void setListTH_SELF_INVOICE_YN(List<SelectItem> listTH_SELF_INVOICE_YN) {
		this.listTH_SELF_INVOICE_YN = listTH_SELF_INVOICE_YN;
	}
	/*Added by senthilnathan for orient*/
	public HtmlOutputLabel COMP_TH_VAT_RECOVER_YN_LABEL;
	public HtmlSelectOneMenu COMP_TH_VAT_RECOVER_YN;
	private List<SelectItem> listTH_VAT_RECOVER_YN = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListTH_VAT_RECOVER_YN() {
		if (listTH_VAT_RECOVER_YN.size() == 0) {
			listTH_VAT_RECOVER_YN.clear();
			try {
				listTH_VAT_RECOVER_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listTH_VAT_RECOVER_YN;
	}

	public HtmlOutputLabel getCOMP_TH_VAT_RECOVER_YN_LABEL() {
		return COMP_TH_VAT_RECOVER_YN_LABEL;
	}

	public void setCOMP_TH_VAT_RECOVER_YN_LABEL(
			HtmlOutputLabel cOMP_TH_VAT_RECOVER_YN_LABEL) {
		COMP_TH_VAT_RECOVER_YN_LABEL = cOMP_TH_VAT_RECOVER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_VAT_RECOVER_YN() {
		return COMP_TH_VAT_RECOVER_YN;
	}

	public void setCOMP_TH_VAT_RECOVER_YN(HtmlSelectOneMenu cOMP_TH_VAT_RECOVER_YN) {
		COMP_TH_VAT_RECOVER_YN = cOMP_TH_VAT_RECOVER_YN;
	}

	public void setListTH_VAT_RECOVER_YN(List<SelectItem> listTH_VAT_RECOVER_YN) {
		this.listTH_VAT_RECOVER_YN = listTH_VAT_RECOVER_YN;
	}
	
	public void validateTH_VAT_RECOVER_YN(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		try {
			PM_LIFE_TAX_HEADER_BEAN.setTH_VAT_RECOVER_YN(value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*END*/
	

	
}

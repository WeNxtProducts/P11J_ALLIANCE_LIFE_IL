package com.iii.pel.forms.PILP060_APAC;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;


public class DUMMY_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_PROD_FM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_PROD_TO_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_TO_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_BON_CODE_FM_LABEL;

	private HtmlInputText COMP_UI_M_BON_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_BON_FM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BON_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_BON_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_BON_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_BON_TO_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BON_TO_DESC;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DATE;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_SEL_ALL;

	private HtmlCommandButton COMP_UI_M_BUT_GEN_PV;

	private HtmlCommandButton COMP_UI_M_BUT_POST;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO;

	private HtmlCommandButton COMP_UI_M_LOV_BON_FM;

	private HtmlCommandButton COMP_UI_M_LOV_BON_TO;

	private HtmlCommandButton COMP_UI_M_LOV_PROD_FM;

	private HtmlCommandButton COMP_UI_M_LOV_PROD_TO;

	private DUMMY DUMMY_BEAN;
	
	private List <DUMMY>suggestionList;
	
	ControlBean controlBean;
	
	public List<DUMMY> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<DUMMY> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		
		controlBean=(ControlBean)CommonUtils.getControlBean().clone();
		preform();
	}


	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_FM_LABEL() {
		return COMP_UI_M_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE_FM() {
		return COMP_UI_M_PROD_CODE_FM;
	}

	public void setCOMP_UI_M_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_UI_M_PROD_CODE_FM_LABEL) {
		this.COMP_UI_M_PROD_CODE_FM_LABEL = COMP_UI_M_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE_FM(HtmlInputText COMP_UI_M_PROD_CODE_FM) {
		this.COMP_UI_M_PROD_CODE_FM = COMP_UI_M_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_FM_DESC_LABEL() {
		return COMP_UI_M_PROD_FM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_FM_DESC() {
		return COMP_UI_M_PROD_FM_DESC;
	}

	public void setCOMP_UI_M_PROD_FM_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_FM_DESC_LABEL) {
		this.COMP_UI_M_PROD_FM_DESC_LABEL = COMP_UI_M_PROD_FM_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_FM_DESC(HtmlInputText COMP_UI_M_PROD_FM_DESC) {
		this.COMP_UI_M_PROD_FM_DESC = COMP_UI_M_PROD_FM_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_TO_LABEL() {
		return COMP_UI_M_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE_TO() {
		return COMP_UI_M_PROD_CODE_TO;
	}

	public void setCOMP_UI_M_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_UI_M_PROD_CODE_TO_LABEL) {
		this.COMP_UI_M_PROD_CODE_TO_LABEL = COMP_UI_M_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE_TO(HtmlInputText COMP_UI_M_PROD_CODE_TO) {
		this.COMP_UI_M_PROD_CODE_TO = COMP_UI_M_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_TO_DESC_LABEL() {
		return COMP_UI_M_PROD_TO_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TO_DESC() {
		return COMP_UI_M_PROD_TO_DESC;
	}

	public void setCOMP_UI_M_PROD_TO_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_TO_DESC_LABEL) {
		this.COMP_UI_M_PROD_TO_DESC_LABEL = COMP_UI_M_PROD_TO_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_TO_DESC(HtmlInputText COMP_UI_M_PROD_TO_DESC) {
		this.COMP_UI_M_PROD_TO_DESC = COMP_UI_M_PROD_TO_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL) {
		this.COMP_UI_M_POL_NO_FM_LABEL = COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText COMP_UI_M_POL_NO_FM) {
		this.COMP_UI_M_POL_NO_FM = COMP_UI_M_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL) {
		this.COMP_UI_M_POL_NO_TO_LABEL = COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText COMP_UI_M_POL_NO_TO) {
		this.COMP_UI_M_POL_NO_TO = COMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_BON_CODE_FM_LABEL() {
		return COMP_UI_M_BON_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_CODE_FM() {
		return COMP_UI_M_BON_CODE_FM;
	}

	public void setCOMP_UI_M_BON_CODE_FM_LABEL(HtmlOutputLabel COMP_UI_M_BON_CODE_FM_LABEL) {
		this.COMP_UI_M_BON_CODE_FM_LABEL = COMP_UI_M_BON_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_BON_CODE_FM(HtmlInputText COMP_UI_M_BON_CODE_FM) {
		this.COMP_UI_M_BON_CODE_FM = COMP_UI_M_BON_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_BON_FM_DESC_LABEL() {
		return COMP_UI_M_BON_FM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_FM_DESC() {
		return COMP_UI_M_BON_FM_DESC;
	}

	public void setCOMP_UI_M_BON_FM_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BON_FM_DESC_LABEL) {
		this.COMP_UI_M_BON_FM_DESC_LABEL = COMP_UI_M_BON_FM_DESC_LABEL;
	}

	public void setCOMP_UI_M_BON_FM_DESC(HtmlInputText COMP_UI_M_BON_FM_DESC) {
		this.COMP_UI_M_BON_FM_DESC = COMP_UI_M_BON_FM_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_BON_CODE_TO_LABEL() {
		return COMP_UI_M_BON_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_CODE_TO() {
		return COMP_UI_M_BON_CODE_TO;
	}

	public void setCOMP_UI_M_BON_CODE_TO_LABEL(HtmlOutputLabel COMP_UI_M_BON_CODE_TO_LABEL) {
		this.COMP_UI_M_BON_CODE_TO_LABEL = COMP_UI_M_BON_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_BON_CODE_TO(HtmlInputText COMP_UI_M_BON_CODE_TO) {
		this.COMP_UI_M_BON_CODE_TO = COMP_UI_M_BON_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_BON_TO_DESC_LABEL() {
		return COMP_UI_M_BON_TO_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BON_TO_DESC() {
		return COMP_UI_M_BON_TO_DESC;
	}

	public void setCOMP_UI_M_BON_TO_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BON_TO_DESC_LABEL) {
		this.COMP_UI_M_BON_TO_DESC_LABEL = COMP_UI_M_BON_TO_DESC_LABEL;
	}

	public void setCOMP_UI_M_BON_TO_DESC(HtmlInputText COMP_UI_M_BON_TO_DESC) {
		this.COMP_UI_M_BON_TO_DESC = COMP_UI_M_BON_TO_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DATE_LABEL() {
		return COMP_UI_M_PROCESS_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DATE() {
		return COMP_UI_M_PROCESS_DATE;
	}

	public void setCOMP_UI_M_PROCESS_DATE_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_DATE_LABEL) {
		this.COMP_UI_M_PROCESS_DATE_LABEL = COMP_UI_M_PROCESS_DATE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DATE(HtmlCalendar COMP_UI_M_PROCESS_DATE) {
		this.COMP_UI_M_PROCESS_DATE = COMP_UI_M_PROCESS_DATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SEL_ALL() {
		return COMP_UI_M_BUT_SEL_ALL;
	}

	public void setCOMP_UI_M_BUT_SEL_ALL(HtmlCommandButton COMP_UI_M_BUT_SEL_ALL) {
		this.COMP_UI_M_BUT_SEL_ALL = COMP_UI_M_BUT_SEL_ALL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_GEN_PV() {
		return COMP_UI_M_BUT_GEN_PV;
	}

	public void setCOMP_UI_M_BUT_GEN_PV(HtmlCommandButton COMP_UI_M_BUT_GEN_PV) {
		this.COMP_UI_M_BUT_GEN_PV = COMP_UI_M_BUT_GEN_PV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POST() {
		return COMP_UI_M_BUT_POST;
	}

	public void setCOMP_UI_M_BUT_POST(HtmlCommandButton COMP_UI_M_BUT_POST) {
		this.COMP_UI_M_BUT_POST = COMP_UI_M_BUT_POST;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FM(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FM = COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_TO() {
		return COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_TO(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO) {
		this.COMP_UI_M_BUT_LOV_POL_NO_TO = COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BON_FM() {
		return COMP_UI_M_LOV_BON_FM;
	}

	public void setCOMP_UI_M_LOV_BON_FM(HtmlCommandButton COMP_UI_M_LOV_BON_FM) {
		this.COMP_UI_M_LOV_BON_FM = COMP_UI_M_LOV_BON_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BON_TO() {
		return COMP_UI_M_LOV_BON_TO;
	}

	public void setCOMP_UI_M_LOV_BON_TO(HtmlCommandButton COMP_UI_M_LOV_BON_TO) {
		this.COMP_UI_M_LOV_BON_TO = COMP_UI_M_LOV_BON_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_PROD_FM() {
		return COMP_UI_M_LOV_PROD_FM;
	}

	public void setCOMP_UI_M_LOV_PROD_FM(HtmlCommandButton COMP_UI_M_LOV_PROD_FM) {
		this.COMP_UI_M_LOV_PROD_FM = COMP_UI_M_LOV_PROD_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_PROD_TO() {
		return COMP_UI_M_LOV_PROD_TO;
	}

	public void setCOMP_UI_M_LOV_PROD_TO(HtmlCommandButton COMP_UI_M_LOV_PROD_TO) {
		this.COMP_UI_M_LOV_PROD_TO = COMP_UI_M_LOV_PROD_TO;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}
	
	public List <DUMMY> getLovForFM_TO_PROD_CODE(Object obj){
		System.out.println("DUMMY_ACTION.getLovForFM_TO_PROD_CODE()");
		String filterString=(String)obj;
		DUMMY_DELEGATE delegate=new DUMMY_DELEGATE();
		System.out.println("Fetching List");
		suggestionList=delegate.getListForFM_TO_PROD_CODE(filterString);
		return suggestionList;
	}
	
	public void setFieldCOMP_UI_M_FM_PROD_DESC(ActionEvent event){
		System.out.println("DUMMY_ACTION.setFieldCOMP_UI_M_FM_PROD_DESC()");
	//	String selectedProductCode=(String)((UIInput)(event.getComponent().getParent().findComponent("UI_M_FM_PROD_CODE"))).getSubmittedValue();
		String selectedProductCode=(String)this.COMP_UI_M_PROD_CODE_FM.getSubmittedValue();
		boolean keepLooking=true;
		Iterator <DUMMY> iterator=suggestionList.iterator();
		System.out.println(iterator.hasNext()+"---------"+selectedProductCode);
		while(iterator.hasNext()&& keepLooking){
			DUMMY suggestionListValueBean=(DUMMY)iterator.next();
			String productCode=(String)suggestionListValueBean.getUI_M_PROD_CODE_FM();
			if(selectedProductCode.equals(productCode)){
				System.out.println(selectedProductCode+">>>>>>>>>"+productCode);
				this.DUMMY_BEAN.setUI_M_PROD_CODE_FM(selectedProductCode);
				this.DUMMY_BEAN.setUI_M_PROD_FM_DESC(suggestionListValueBean.getUI_M_PROD_FM_DESC());
				this.COMP_UI_M_PROD_FM_DESC.setSubmittedValue(null);
			}
		}
	}
	
	public void setFieldCOMP_UI_M_TO_PROD_DESC(ActionEvent event){
		System.out.println("DUMMY_ACTION.setFieldCOMP_UI_M_TO_PROD_DESC()");
		//String selectedProductCode=(String)((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue();
		String selectedProductCode=(String)this.COMP_UI_M_PROD_CODE_TO.getSubmittedValue();
		boolean keepLooking=true;
		Iterator <DUMMY> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			DUMMY suggestionListValueBean=(DUMMY)iterator.next();
			String productCode=(String)suggestionListValueBean.getUI_M_PROD_CODE_TO();
			if(selectedProductCode.equals(productCode)){
				System.out.println(selectedProductCode+">>>>>>>>>"+productCode);
				this.DUMMY_BEAN.setUI_M_PROD_CODE_TO(selectedProductCode);
				this.DUMMY_BEAN.setUI_M_PROD_TO_DESC(suggestionListValueBean.getUI_M_PROD_FM_DESC());
				this.COMP_UI_M_PROD_TO_DESC.setSubmittedValue(null);
			}
		}
	}
	
	public List <DUMMY> getLovForFM_TO_POL_NO(Object obj){
		System.out.println("DUMMY_ACTION.getLovForFM_TO_POL_NO()");
		String filterString=obj.toString().trim();
		DUMMY_DELEGATE delegate=new DUMMY_DELEGATE();
		System.out.println("Fetching List");
		suggestionList=delegate.getListForFM_TO_POL_NO(filterString);
		return suggestionList;
	}
	
	public List <DUMMY> getLovForFM_TO_BON_CODE(Object obj){
		System.out.println("DUMMY_ACTION.getLovForFM_TO_BON_CODE()");
		String filterString=obj.toString().trim();
		DUMMY_DELEGATE delegate=new DUMMY_DELEGATE();
		System.out.println("Fetching List");
		suggestionList=delegate.getListForFM_TO_BON_CODE(filterString);
		return suggestionList;
	}
	
	public void setFieldCOMP_UI_M_FM_BON_DESC(ActionEvent event){
		System.out.println("DUMMY_ACTION.setFieldCOMP_UI_M_FM_BON_DESC()");
	//	String selectedProductCode=(String)((UIInput)(event.getComponent().getParent().findComponent("UI_M_FM_PROD_CODE"))).getSubmittedValue();
		String selectedBonusCode=(String)this.COMP_UI_M_BON_CODE_FM.getSubmittedValue();
		boolean keepLooking=true;
		Iterator <DUMMY> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			DUMMY suggestionListValueBean=(DUMMY)iterator.next();
			String bonusCode=(String)suggestionListValueBean.getUI_M_BON_CODE_FM();
			if(selectedBonusCode.equals(bonusCode)){
				System.out.println(selectedBonusCode+">>>>>>>>>"+bonusCode);
				this.DUMMY_BEAN.setUI_M_BON_CODE_FM(selectedBonusCode);
				this.DUMMY_BEAN.setUI_M_BON_FM_DESC(suggestionListValueBean.getUI_M_BON_FM_DESC());
				this.COMP_UI_M_BON_FM_DESC.setSubmittedValue(null);
			}
		}
	}
	
	public void setFieldCOMP_UI_M_TO_BON_DESC(ActionEvent event){
		System.out.println("DUMMY_ACTION.setFieldCOMP_UI_M_TO_BON_DESC()");
		//String selectedProductCode=(String)((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue();
		String selectedBonusCode=(String)this.COMP_UI_M_BON_CODE_TO.getSubmittedValue();
		boolean keepLooking=true;
		Iterator <DUMMY> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			DUMMY suggestionListValueBean=(DUMMY)iterator.next();
			String bonusCode=(String)suggestionListValueBean.getUI_M_BON_CODE_TO();
			if(selectedBonusCode.equals(bonusCode)){
				System.out.println(selectedBonusCode+">>>>>>>>>"+bonusCode);
				this.DUMMY_BEAN.setUI_M_BON_CODE_TO(selectedBonusCode);
				this.DUMMY_BEAN.setUI_M_BON_TO_DESC(suggestionListValueBean.getUI_M_BON_TO_DESC());
				this.COMP_UI_M_BON_TO_DESC.setSubmittedValue(null);
			}
		}
	}
	
	
	/* Trigger  Start*/
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_PROD_CODE_FM_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out
				.println("DUMMY_ACTION.UI_M_PROD_CODE_FM_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String fromProdCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_prod_code_fm_when_validate_item(fromProdCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**UI_M_PROD_CODE_TO_WHEN_VALIDATE_ITEM
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_PROD_CODE_FM(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_PROD_CODE_FM---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_prod_code_fm_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_PROD_CODE_FM((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_PROD_CODE_TO_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out
				.println("DUMMY_ACTION.UI_M_PROD_CODE_TO_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String toProductCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_prod_code_to_when_validate_item(toProductCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_PROD_CODE_TO(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_PROD_CODE_TO---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_prod_code_to_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_PROD_CODE_TO((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_POL_NO_FM_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println
		("DUMMY_ACTION.UI_M_POL_NO_FM_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String fromPolNo=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_pol_no_fm_when_validate_item(fromPolNo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_POL_NO_FM(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_POL_NO_FM---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_pol_no_fm_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_POL_NO_FM((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_POL_NO_TO_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println
		("DUMMY_ACTION.UI_M_POL_NO_TO_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String toPolNo=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_pol_no_to_when_validate_item(toPolNo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_POL_NO_TO(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_POL_NO_TO---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			
			helper.pilp060_apac_dummy_ui_m_pol_no_to_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_POL_NO_TO((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_BON_CODE_FM_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out
				.println("DUMMY_ACTION.UI_M_BON_CODE_FM_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String fromBonusCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_bon_code_fm_when_validate_item(fromBonusCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**UI_M_PROD_CODE_TO_WHEN_VALIDATE_ITEM
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_BON_CODE_FM(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_BON_CODE_FM---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_bon_code_fm_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_BON_CODE_FM((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_BON_CODE_TO_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out
				.println("DUMMY_ACTION.UI_M_BON_CODE_TO_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			String toBonusCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			helper.pilp060_apac_dummy_ui_m_bon_code_to_when_validate_item(toBonusCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_BON_CODE_TO(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_BON_CODE_TO---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_bon_code_to_when_validate_item((String)value);
			this.getDUMMY_BEAN().setUI_M_BON_CODE_TO((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Called on blur
	 * @param event
	 * @return
	 * @throws 
	 */
	public void UI_M_PROCESS_DATE_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("DUMMY_ACTION.UI_M_PROCESS_DT_WHEN_VALIDATE_ITEM---[onblur]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_process_dt_when_validate_item();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	/**
	 * Called for validating field when form is submitted 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateUI_M_PROCESS_DATE(FacesContext context, UIComponent component,
			Object value){
		System.out.println("DUMMY_ACTION.validateUI_M_PROCESS_DT---[onsubmit/validator]");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		try {
			helper.pilp060_apac_dummy_ui_m_process_dt_when_validate_item();
			this.getDUMMY_BEAN().setUI_M_PROCESS_DATE((Date)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private void preform() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("GLOBAL.M_PRIVILEGE", "YYY");
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		session.setAttribute("GLOBAL.M_USER_ID", "LIFEALL");
		session.setAttribute("GLOBAL.M_NAME",
				"COMPANY NAME..................PROGRAM NAME");
		session.setAttribute("GLOBAL.M_LANG_CODE", "ENG");
		session.setAttribute("GLOBAL.M_DFLT_VALUES", "00101    01");
		session.setAttribute("GLOBAL.M_PARA_1", " ");
		session.setAttribute("GLOBAL.M_FOR_LANG_CODE", "ARBR2");
		session.setAttribute("GLOBAL.M_MODULE_NAME", "PILM060_APAC");
	}
	/* Trigger end*/
	
/*-----------Button Action methods begin---------------------*/
	
	public String processButtonAction(){
		System.out.println("DUMMY_ACTION.processButtonAction()");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		try {
			validateForm();
			CommonUtils.objectSysout(DUMMY_BEAN);
			helper.processBonus();
			compositeActionBean.getPT_IL_BONUS_ACTION_BEAN().whenNewBlockInstancePT_IL_BONUS(this.DUMMY_BEAN);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "";
	}
	
	public void validateForm() throws Exception{
		System.out.println("DUMMY_ACTION.validateForm()");
		DUMMY_HELPER helper=new DUMMY_HELPER();
		helper.pilp060_apac_dummy_ui_m_bon_code_fm_when_validate_item(DUMMY_BEAN.getUI_M_BON_CODE_FM());
		helper.pilp060_apac_dummy_ui_m_bon_code_to_when_validate_item(DUMMY_BEAN.getUI_M_BON_CODE_TO());
		helper.pilp060_apac_dummy_ui_m_pol_no_fm_when_validate_item(DUMMY_BEAN.getUI_M_POL_NO_FM());
		helper.pilp060_apac_dummy_ui_m_pol_no_to_when_validate_item(DUMMY_BEAN.getUI_M_POL_NO_TO());
		//helper.pilp060_apac_dummy_ui_m_process_dt_when_validate_item(DUMMY_BEAN.);
		helper.pilp060_apac_dummy_ui_m_prod_code_fm_when_validate_item(DUMMY_BEAN.getUI_M_PROD_CODE_FM());
		helper.pilp060_apac_dummy_ui_m_prod_code_to_when_validate_item(DUMMY_BEAN.getUI_M_PROD_CODE_TO());
	}
	
	public String genPVButtonAction(){
		System.out.println("DUMMY_ACTION.genPVButtonAction()");
		
		String returnString=null;
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		DUMMY_HELPER helper=new DUMMY_HELPER();
		CommonUtils utility=new CommonUtils();
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		try {
			validateForm();
			
			compositeActionBean.getPT_IL_BONUS_ACTION_BEAN().updateRecordsPT_IL_BONUS();
			
			helper.generatePaymentVoucher();
			controlBean.setM_COMM_DEL("C");
			utility.doComitt();
			getWarningMap().clear();
			getWarningMap().put("current", "Procedure Completed Successfully");
			compositeActionBean.getPT_IL_BONUS_ACTION_BEAN().whenNewBlockInstancePT_IL_BONUS(this.DUMMY_BEAN);
		} catch (Exception e) {
			getErrorMap().clear();
			getErrorMap().put("current", "Procedure Completion Failed");
			getErrorMap().put("key", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			boolean isError=helper.isErrorGenerated();
			System.out.println("DUMMY_ACTION.genPVButtonAction()----------[isError Value]"+isError);
			if(isError){
				compositeActionBean.getPT_IL_PROCESS_ACTION_BEAN().whenNewBlockInstancePT_IL_PROCESS();
				returnString="GO_TO_PILP060_APAC_PT_IL_PROCESS";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().clear();
		}
		return returnString;
	}
	
	public String selectAllButtonAction(){
		System.out.println("DUMMY_ACTION.selectAllAction()");
		
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPT_IL_BONUS_ACTION_BEAN().setAllBON_PAID_YN();
		return "";
	}
	
	public String postButtonAction(){
		String returnString="";
		returnString="GO_TO_PILP010_FINAL";
		return returnString;
	}
	/*-----------Button Action methods end---------------------*/

}

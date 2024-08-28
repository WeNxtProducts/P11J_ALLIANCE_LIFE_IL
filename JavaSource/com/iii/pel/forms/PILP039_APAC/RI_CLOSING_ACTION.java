package com.iii.pel.forms.PILP039_APAC;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class RI_CLOSING_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PROD_FM_LABEL;

	private HtmlInputText COMP_UI_M_PROD_FM;

	private HtmlOutputLabel COMP_UI_M_PROD_FM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_PROD_TO_LABEL;

	private HtmlInputText COMP_UI_M_PROD_TO;

	private HtmlOutputLabel COMP_UI_M_PROD_TO_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_TO_DESC;

	private HtmlOutputLabel COMP_UI_M_FIN_QTR_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_FIN_QTR;

	private HtmlOutputLabel COMP_UI_M_RD_YEAR_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_RD_YEAR;

	private HtmlOutputLabel COMP_UI_M_RI_PREM_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_RI_PREM;

	private HtmlOutputLabel COMP_UI_M_RI_CLAIM_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_RI_CLAIM;

	private HtmlOutputLabel COMP_UI_M_CLAIM_OS_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_CLAIM_OS_YN;

	private HtmlOutputLabel COMP_UI_M_POST_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_POST_YN;
	
	private HtmlOutputLabel COMP_UI_M_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_STATUS;
	
	

	private HtmlCommandButton COMP_UI_M_RI_CLOSING_OK;

	private HtmlCommandButton COMP_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_PROD_FM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_PROD_TO_LOV;

	private RI_CLOSING RI_CLOSING_BEAN;
	
	private List<RI_CLOSING_LOV> riCloseLovList;
	
	private List<SelectItem> itemM_FIN_QTR;
	private List<SelectItem> itemM_RD_YEAR;
	private List<SelectItem> itemM_RI_PREM;
	private List<SelectItem> itemM_RI_CLAIM;
	private List<SelectItem> itemM_CLAIM_OS_YN;
	private List<SelectItem> itemM_POST_YN;
	
	

	public RI_CLOSING_ACTION() {
		RI_CLOSING_BEAN = new RI_CLOSING();
		itemM_FIN_QTR = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_FIN_QTR", "FIN_YEAR");
		itemM_RD_YEAR = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_RD_YEAR", "MUDH_YEAR");
		itemM_RI_PREM = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_RI_PREM", "YESNO");
		itemM_RI_CLAIM = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_RI_CLAIM", "YESNO");
		itemM_CLAIM_OS_YN = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_CLAIM_OS_YN", "YESNO");
		itemM_POST_YN = PILP039_APAC_RI_CLOSING_DELEGATE.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_POST_YN", "YESNO");
		
		
		/*itemM_RD_YEAR =delegate.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_FIN_QTR", "TITLE");
		itemM_RI_PREM=delegate.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_FIN_QTR", "TITLE");
		itemM_RI_CLAIM =delegate.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_FIN_QTR", "TITLE");
		itemM_CLAIM_OS_YN=delegate.getDropDownListValue("PILP039_APAC", "RI_CLOSING", "RI_CLOSING.M_FIN_QTR", "TITLE");*/
		
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_FM_LABEL() {
		return COMP_UI_M_PROD_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_FM() {
		return COMP_UI_M_PROD_FM;
	}

	public void setCOMP_UI_M_PROD_FM_LABEL(HtmlOutputLabel COMP_UI_M_PROD_FM_LABEL) {
		this.COMP_UI_M_PROD_FM_LABEL = COMP_UI_M_PROD_FM_LABEL;
	}

	public void setCOMP_UI_M_PROD_FM(HtmlInputText COMP_UI_M_PROD_FM) {
		this.COMP_UI_M_PROD_FM = COMP_UI_M_PROD_FM;
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

	public HtmlOutputLabel getCOMP_UI_M_PROD_TO_LABEL() {
		return COMP_UI_M_PROD_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TO() {
		return COMP_UI_M_PROD_TO;
	}

	public void setCOMP_UI_M_PROD_TO_LABEL(HtmlOutputLabel COMP_UI_M_PROD_TO_LABEL) {
		this.COMP_UI_M_PROD_TO_LABEL = COMP_UI_M_PROD_TO_LABEL;
	}

	public void setCOMP_UI_M_PROD_TO(HtmlInputText COMP_UI_M_PROD_TO) {
		this.COMP_UI_M_PROD_TO = COMP_UI_M_PROD_TO;
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

	public HtmlOutputLabel getCOMP_UI_M_FIN_QTR_LABEL() {
		return COMP_UI_M_FIN_QTR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_FIN_QTR() {
		return COMP_UI_M_FIN_QTR;
	}

	public void setCOMP_UI_M_FIN_QTR_LABEL(HtmlOutputLabel COMP_UI_M_FIN_QTR_LABEL) {
		this.COMP_UI_M_FIN_QTR_LABEL = COMP_UI_M_FIN_QTR_LABEL;
	}

	public void setCOMP_UI_M_FIN_QTR(HtmlSelectOneMenu COMP_UI_M_FIN_QTR) {
		this.COMP_UI_M_FIN_QTR = COMP_UI_M_FIN_QTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_RD_YEAR_LABEL() {
		return COMP_UI_M_RD_YEAR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_RD_YEAR() {
		return COMP_UI_M_RD_YEAR;
	}

	public void setCOMP_UI_M_RD_YEAR_LABEL(HtmlOutputLabel COMP_UI_M_RD_YEAR_LABEL) {
		this.COMP_UI_M_RD_YEAR_LABEL = COMP_UI_M_RD_YEAR_LABEL;
	}

	public void setCOMP_UI_M_RD_YEAR(HtmlSelectOneMenu COMP_UI_M_RD_YEAR) {
		this.COMP_UI_M_RD_YEAR = COMP_UI_M_RD_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_RI_PREM_LABEL() {
		return COMP_UI_M_RI_PREM_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_RI_PREM() {
		return COMP_UI_M_RI_PREM;
	}

	public void setCOMP_UI_M_RI_PREM_LABEL(HtmlOutputLabel COMP_UI_M_RI_PREM_LABEL) {
		this.COMP_UI_M_RI_PREM_LABEL = COMP_UI_M_RI_PREM_LABEL;
	}

	public void setCOMP_UI_M_RI_PREM(HtmlSelectOneMenu COMP_UI_M_RI_PREM) {
		this.COMP_UI_M_RI_PREM = COMP_UI_M_RI_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_RI_CLAIM_LABEL() {
		return COMP_UI_M_RI_CLAIM_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_RI_CLAIM() {
		return COMP_UI_M_RI_CLAIM;
	}

	public void setCOMP_UI_M_RI_CLAIM_LABEL(HtmlOutputLabel COMP_UI_M_RI_CLAIM_LABEL) {
		this.COMP_UI_M_RI_CLAIM_LABEL = COMP_UI_M_RI_CLAIM_LABEL;
	}

	public void setCOMP_UI_M_RI_CLAIM(HtmlSelectOneMenu COMP_UI_M_RI_CLAIM) {
		this.COMP_UI_M_RI_CLAIM = COMP_UI_M_RI_CLAIM;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_OS_YN_LABEL() {
		return COMP_UI_M_CLAIM_OS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_CLAIM_OS_YN() {
		return COMP_UI_M_CLAIM_OS_YN;
	}

	public void setCOMP_UI_M_CLAIM_OS_YN_LABEL(HtmlOutputLabel COMP_UI_M_CLAIM_OS_YN_LABEL) {
		this.COMP_UI_M_CLAIM_OS_YN_LABEL = COMP_UI_M_CLAIM_OS_YN_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_OS_YN(HtmlSelectOneMenu COMP_UI_M_CLAIM_OS_YN) {
		this.COMP_UI_M_CLAIM_OS_YN = COMP_UI_M_CLAIM_OS_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_LABEL() {
		return COMP_UI_M_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS_LABEL(HtmlOutputLabel COMP_UI_M_STATUS_LABEL) {
		this.COMP_UI_M_STATUS_LABEL = COMP_UI_M_STATUS_LABEL;
	}

	public void setCOMP_UI_M_STATUS(HtmlInputText COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public HtmlCommandButton getCOMP_UI_M_RI_CLOSING_OK() {
		return COMP_UI_M_RI_CLOSING_OK;
	}

	public void setCOMP_UI_M_RI_CLOSING_OK(HtmlCommandButton COMP_UI_M_RI_CLOSING_OK) {
		this.COMP_UI_M_RI_CLOSING_OK = COMP_UI_M_RI_CLOSING_OK;
	}

	public HtmlCommandButton getCOMP_CANCEL() {
		return COMP_CANCEL;
	}

	public void setCOMP_CANCEL(HtmlCommandButton COMP_CANCEL) {
		this.COMP_CANCEL = COMP_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROD_FM_LOV() {
		return COMP_UI_M_BUT_PROD_FM_LOV;
	}

	public void setCOMP_UI_M_BUT_PROD_FM_LOV(HtmlCommandButton COMP_UI_M_BUT_PROD_FM_LOV) {
		this.COMP_UI_M_BUT_PROD_FM_LOV = COMP_UI_M_BUT_PROD_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROD_TO_LOV() {
		return COMP_UI_M_BUT_PROD_TO_LOV;
	}

	public void setCOMP_UI_M_BUT_PROD_TO_LOV(HtmlCommandButton COMP_UI_M_BUT_PROD_TO_LOV) {
		this.COMP_UI_M_BUT_PROD_TO_LOV = COMP_UI_M_BUT_PROD_TO_LOV;
	}

	public RI_CLOSING getRI_CLOSING_BEAN() {
		return RI_CLOSING_BEAN;
	}
	public void setRI_CLOSING_BEAN(RI_CLOSING RI_CLOSING_BEAN) {
		this.RI_CLOSING_BEAN = RI_CLOSING_BEAN;
	}
	
	public List<RI_CLOSING_LOV> getCustClassLov(Object string){
		PILP039_APAC_RI_CLOSING_DELEGATE delegate = new PILP039_APAC_RI_CLOSING_DELEGATE();
		riCloseLovList = (List)delegate.getLovForProdCode(string);
		return riCloseLovList;
	}
	
	public void renderPROD_FM(ActionEvent event){
		Iterator<RI_CLOSING_LOV> iterator = null;
		RI_CLOSING_LOV bean = null;
		boolean keepLooking = true;
		String classCode = null;
		classCode = (String) COMP_UI_M_PROD_FM.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(riCloseLovList != null){
				iterator = riCloseLovList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getPROD_FM().equalsIgnoreCase(classCode)){
						COMP_UI_M_PROD_FM.setSubmittedValue(bean.getPROD_FM());
						COMP_UI_M_PROD_FM_DESC.setSubmittedValue(bean.getPROD_FM_DESC());
						keepLooking = false;
					}
				}
			}
		}
	}
	public void renderPROD_TO(ActionEvent event){
		Iterator<RI_CLOSING_LOV> iterator = null;
		RI_CLOSING_LOV bean = null;
		boolean keepLooking = true;
		String classCode = null;
		classCode = (String) COMP_UI_M_PROD_TO.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(riCloseLovList != null){
				iterator = riCloseLovList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getPROD_FM().equalsIgnoreCase(classCode)){
						COMP_UI_M_PROD_TO.setSubmittedValue(bean.getPROD_FM());
						COMP_UI_M_PROD_TO_DESC.setSubmittedValue(bean.getPROD_FM_DESC());
						keepLooking = false;
					}
				}
			}
		}
	}

	public List<SelectItem> getItemM_FIN_QTR() {
		return itemM_FIN_QTR;
	}

	public void setItemM_FIN_QTR(List<SelectItem> itemM_FIN_QTR) {
		this.itemM_FIN_QTR = itemM_FIN_QTR;
	}

	public List<SelectItem> getItemM_RD_YEAR() {
		return itemM_RD_YEAR;
	}

	public void setItemM_RD_YEAR(List<SelectItem> itemM_RD_YEAR) {
		this.itemM_RD_YEAR = itemM_RD_YEAR;
	}

	public List<SelectItem> getItemM_RI_PREM() {
		return itemM_RI_PREM;
	}

	public void setItemM_RI_PREM(List<SelectItem> itemM_RI_PREM) {
		this.itemM_RI_PREM = itemM_RI_PREM;
	}

	public List<SelectItem> getItemM_RI_CLAIM() {
		return itemM_RI_CLAIM;
	}

	public void setItemM_RI_CLAIM(List<SelectItem> itemM_RI_CLAIM) {
		this.itemM_RI_CLAIM = itemM_RI_CLAIM;
	}

	public List<SelectItem> getItemM_CLAIM_OS_YN() {
		return itemM_CLAIM_OS_YN;
	}

	public void setItemM_CLAIM_OS_YN(List<SelectItem> itemM_CLAIM_OS_YN) {
		this.itemM_CLAIM_OS_YN = itemM_CLAIM_OS_YN;
	}
	public String getCurrentSelectedValue(ActionEvent event) {
		String value = null;
		UISelectOne input = null;
		if (event != null) {
			input = (UISelectOne) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	public void getM_RI_CLAIM(ActionEvent event){
		String M_RI_CLAIM = getCurrentSelectedValue(event);
		String M_CLAIM_OS_YN = getRI_CLOSING_BEAN().getUI_M_CLAIM_OS_YN();
		getRI_CLOSING_BEAN().setUI_M_RI_CLAIM(M_RI_CLAIM);
		if("N".equals(M_RI_CLAIM) && "Y".equals(M_CLAIM_OS_YN)){
			getErrorMap().put("somekey", "CLAIM ACCOUNTING ENTRY SHOULD BE SELECTED");
			getErrorMap().put("current", "CLAIM ACCOUNTING ENTRY SHOULD BE SELECTED");
		}
	}
	public void getM_CLAIM_OS_YN(ActionEvent event){
		String M_CLAIM_OS_YN = getCurrentSelectedValue(event);
		String M_RI_CLAIM = getRI_CLOSING_BEAN().getUI_M_RI_CLAIM();
		getRI_CLOSING_BEAN().setUI_M_CLAIM_OS_YN(M_CLAIM_OS_YN);
		if("Y".equals(M_RI_CLAIM) && "N".equals(M_CLAIM_OS_YN)){
			getErrorMap().put("somekey", "Outstanding Claim should be selected");
			getErrorMap().put("current", "Outstanding Claim should be selected");
		}
	}
	public String getCallOkButton(){
		RI_CLOSING_ACTION_HELPER helper = new RI_CLOSING_ACTION_HELPER();
		
		try {
			helper.pilp039_apac_ri_closing_m_ri_closing_ok_when_button_pressed(this);
			
		} catch (ValidatorException e) {
			getErrorMap().put("somekey", e.getFacesMessage().getDetail());
			getErrorMap().put("current", e.getMessage());
		} catch (Exception e) {
			getErrorMap().put("somekey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
		return "";
	}
	
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	public void PROD_FM_CODE_WHEN_VALIDATE(ActionEvent event){
		RI_CLOSING_ACTION_HELPER helper = new RI_CLOSING_ACTION_HELPER();
		try{
			helper.prod_fm_when_validate_item(this);
		}catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public void PROD_TO_CODE_WHEN_VALIDATE(ActionEvent event){
		RI_CLOSING_ACTION_HELPER helper = new RI_CLOSING_ACTION_HELPER();
		try{
			helper.prod_to_when_validate_item(this);
		}catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POST_YN_LABEL() {
		return COMP_UI_M_POST_YN_LABEL;
	}

	public void setCOMP_UI_M_POST_YN_LABEL(HtmlOutputLabel comp_ui_m_post_yn_label) {
		COMP_UI_M_POST_YN_LABEL = comp_ui_m_post_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_POST_YN() {
		return COMP_UI_M_POST_YN;
	}

	public void setCOMP_UI_M_POST_YN(HtmlSelectOneMenu comp_ui_m_post_yn) {
		COMP_UI_M_POST_YN = comp_ui_m_post_yn;
	}

	public List<SelectItem> getItemM_POST_YN() {
		return itemM_POST_YN;
	}

	public void setItemM_POST_YN(List<SelectItem> itemM_POST_YN) {
		this.itemM_POST_YN = itemM_POST_YN;
	}
	
}

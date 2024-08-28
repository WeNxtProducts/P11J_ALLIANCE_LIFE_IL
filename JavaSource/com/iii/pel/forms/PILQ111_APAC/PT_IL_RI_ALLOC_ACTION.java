package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
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
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ103_APAC.PILQ103_APAC_ACTION_INSTANCE;
import com.iii.pel.forms.PILQ103_APAC.PS_IL_DRCR_TREATY_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.notes.NotesDelegate;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_RI_ALLOC_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RIA_DIVN_CODE_LABEL;

	private HtmlInputText COMP_RIA_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_DESC;

	private HtmlOutputLabel COMP_RIA_DEPT_CODE_LABEL;

	private HtmlInputText COMP_RIA_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_DESC;

	private HtmlOutputLabel COMP_RIA_PROD_CODE_LABEL;

	private HtmlInputText COMP_RIA_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_DESC;

	private HtmlOutputLabel COMP_RIA_COVER_CODE_LABEL;

	private HtmlInputText COMP_RIA_COVER_CODE;
	
	private UIData dataTable;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_RIA_TTY_TYPE_LABEL;

	private HtmlInputText COMP_RIA_TTY_TYPE;

	private HtmlOutputLabel COMP_RIA_LC_PREMIUM_LABEL;

	private HtmlInputText COMP_RIA_LC_PREMIUM;

	private HtmlOutputLabel COMP_RIA_FC_PREMIUM_LABEL;

	private HtmlInputText COMP_RIA_FC_PREMIUM;

	private HtmlOutputLabel COMP_RIA_LC_COMMISSION_LABEL;

	private HtmlInputText COMP_RIA_LC_COMMISSION;

	private HtmlOutputLabel COMP_RIA_FC_COMMISSION_LABEL;

	private HtmlInputText COMP_RIA_FC_COMMISSION;

	private HtmlOutputLabel COMP_RIA_CLM_PAID_LABEL;

	private HtmlInputText COMP_RIA_CLM_PAID;

	private HtmlOutputLabel COMP_RIA_CLAIMS_OS_LABEL;

	private HtmlInputText COMP_RIA_CLAIMS_OS;

	private HtmlOutputLabel COMP_RIA_FM_DT_LABEL;
	
	private List<PT_IL_RI_ALLOC> dataList_PT_IL_RI_ALLOC = new ArrayList<PT_IL_RI_ALLOC>();;

	private HtmlCalendar COMP_RIA_FM_DT;

	private HtmlOutputLabel COMP_RIA_TO_DT_LABEL;

	private HtmlCalendar COMP_RIA_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_TREATY;

	private HtmlCommandButton COMP_UI_M_BUT_FETCH;

	private HtmlCommandButton COMP_BUT_CUST_CODE;

	private HtmlCommandButton COMP_PUSH_BUTTON98;

	private HtmlCommandButton COMP_PUSH_BUTTON136;

	private HtmlCommandButton COMP_PUSH_BUTTON138;

	private HtmlCommandButton COMP_PUSH_BUTTON99;
	
	private List<PT_IL_RI_ALLOC> divnCodeList;
	
	private List<PT_IL_RI_ALLOC> deptCodeList;
	
	private List<PT_IL_RI_ALLOC> productCodeList;
	
	private List<PT_IL_RI_ALLOC> coverCodeList;
	
	private List<PT_IL_RI_ALLOC> treatyTypeList;

	private PT_IL_RI_ALLOC PT_IL_RI_ALLOC_BEAN;
	
	public PILQ111_APAC_COMPOSITE_ACTION compositeAction;

	public PT_IL_RI_ALLOC_ACTION() {
		PT_IL_RI_ALLOC_BEAN = new PT_IL_RI_ALLOC();
	}

	public HtmlOutputLabel getCOMP_RIA_DIVN_CODE_LABEL() {
		return COMP_RIA_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RIA_DIVN_CODE() {
		return COMP_RIA_DIVN_CODE;
	}

	public void setCOMP_RIA_DIVN_CODE_LABEL(HtmlOutputLabel COMP_RIA_DIVN_CODE_LABEL) {
		this.COMP_RIA_DIVN_CODE_LABEL = COMP_RIA_DIVN_CODE_LABEL;
	}

	public void setCOMP_RIA_DIVN_CODE(HtmlInputText COMP_RIA_DIVN_CODE) {
		this.COMP_RIA_DIVN_CODE = COMP_RIA_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_DESC_LABEL() {
		return COMP_UI_M_DIVN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_DESC() {
		return COMP_UI_M_DIVN_DESC;
	}

	public void setCOMP_UI_M_DIVN_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_DESC_LABEL) {
		this.COMP_UI_M_DIVN_DESC_LABEL = COMP_UI_M_DIVN_DESC_LABEL;
	}

	public void setCOMP_UI_M_DIVN_DESC(HtmlInputText COMP_UI_M_DIVN_DESC) {
		this.COMP_UI_M_DIVN_DESC = COMP_UI_M_DIVN_DESC;
	}

	public HtmlOutputLabel getCOMP_RIA_DEPT_CODE_LABEL() {
		return COMP_RIA_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RIA_DEPT_CODE() {
		return COMP_RIA_DEPT_CODE;
	}

	public void setCOMP_RIA_DEPT_CODE_LABEL(HtmlOutputLabel COMP_RIA_DEPT_CODE_LABEL) {
		this.COMP_RIA_DEPT_CODE_LABEL = COMP_RIA_DEPT_CODE_LABEL;
	}

	public void setCOMP_RIA_DEPT_CODE(HtmlInputText COMP_RIA_DEPT_CODE) {
		this.COMP_RIA_DEPT_CODE = COMP_RIA_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_DESC_LABEL() {
		return COMP_UI_M_DEPT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_DESC() {
		return COMP_UI_M_DEPT_DESC;
	}

	public void setCOMP_UI_M_DEPT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_DESC_LABEL) {
		this.COMP_UI_M_DEPT_DESC_LABEL = COMP_UI_M_DEPT_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEPT_DESC(HtmlInputText COMP_UI_M_DEPT_DESC) {
		this.COMP_UI_M_DEPT_DESC = COMP_UI_M_DEPT_DESC;
	}

	public HtmlOutputLabel getCOMP_RIA_PROD_CODE_LABEL() {
		return COMP_RIA_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RIA_PROD_CODE() {
		return COMP_RIA_PROD_CODE;
	}

	public void setCOMP_RIA_PROD_CODE_LABEL(HtmlOutputLabel COMP_RIA_PROD_CODE_LABEL) {
		this.COMP_RIA_PROD_CODE_LABEL = COMP_RIA_PROD_CODE_LABEL;
	}

	public void setCOMP_RIA_PROD_CODE(HtmlInputText COMP_RIA_PROD_CODE) {
		this.COMP_RIA_PROD_CODE = COMP_RIA_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_DESC_LABEL() {
		return COMP_UI_M_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DESC() {
		return COMP_UI_M_PROD_DESC;
	}

	public void setCOMP_UI_M_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
		this.COMP_UI_M_PROD_DESC_LABEL = COMP_UI_M_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_DESC(HtmlInputText COMP_UI_M_PROD_DESC) {
		this.COMP_UI_M_PROD_DESC = COMP_UI_M_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_RIA_COVER_CODE_LABEL() {
		return COMP_RIA_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RIA_COVER_CODE() {
		return COMP_RIA_COVER_CODE;
	}

	public void setCOMP_RIA_COVER_CODE_LABEL(HtmlOutputLabel COMP_RIA_COVER_CODE_LABEL) {
		this.COMP_RIA_COVER_CODE_LABEL = COMP_RIA_COVER_CODE_LABEL;
	}

	public void setCOMP_RIA_COVER_CODE(HtmlInputText COMP_RIA_COVER_CODE) {
		this.COMP_RIA_COVER_CODE = COMP_RIA_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_RIA_TTY_TYPE_LABEL() {
		return COMP_RIA_TTY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RIA_TTY_TYPE() {
		return COMP_RIA_TTY_TYPE;
	}

	public void setCOMP_RIA_TTY_TYPE_LABEL(HtmlOutputLabel COMP_RIA_TTY_TYPE_LABEL) {
		this.COMP_RIA_TTY_TYPE_LABEL = COMP_RIA_TTY_TYPE_LABEL;
	}

	public void setCOMP_RIA_TTY_TYPE(HtmlInputText COMP_RIA_TTY_TYPE) {
		this.COMP_RIA_TTY_TYPE = COMP_RIA_TTY_TYPE;
	}

	public HtmlOutputLabel getCOMP_RIA_LC_PREMIUM_LABEL() {
		return COMP_RIA_LC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_RIA_LC_PREMIUM() {
		return COMP_RIA_LC_PREMIUM;
	}

	public void setCOMP_RIA_LC_PREMIUM_LABEL(HtmlOutputLabel COMP_RIA_LC_PREMIUM_LABEL) {
		this.COMP_RIA_LC_PREMIUM_LABEL = COMP_RIA_LC_PREMIUM_LABEL;
	}

	public void setCOMP_RIA_LC_PREMIUM(HtmlInputText COMP_RIA_LC_PREMIUM) {
		this.COMP_RIA_LC_PREMIUM = COMP_RIA_LC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_RIA_FC_PREMIUM_LABEL() {
		return COMP_RIA_FC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_RIA_FC_PREMIUM() {
		return COMP_RIA_FC_PREMIUM;
	}

	public void setCOMP_RIA_FC_PREMIUM_LABEL(HtmlOutputLabel COMP_RIA_FC_PREMIUM_LABEL) {
		this.COMP_RIA_FC_PREMIUM_LABEL = COMP_RIA_FC_PREMIUM_LABEL;
	}

	public void setCOMP_RIA_FC_PREMIUM(HtmlInputText COMP_RIA_FC_PREMIUM) {
		this.COMP_RIA_FC_PREMIUM = COMP_RIA_FC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_RIA_LC_COMMISSION_LABEL() {
		return COMP_RIA_LC_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_RIA_LC_COMMISSION() {
		return COMP_RIA_LC_COMMISSION;
	}

	public void setCOMP_RIA_LC_COMMISSION_LABEL(HtmlOutputLabel COMP_RIA_LC_COMMISSION_LABEL) {
		this.COMP_RIA_LC_COMMISSION_LABEL = COMP_RIA_LC_COMMISSION_LABEL;
	}

	public void setCOMP_RIA_LC_COMMISSION(HtmlInputText COMP_RIA_LC_COMMISSION) {
		this.COMP_RIA_LC_COMMISSION = COMP_RIA_LC_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_RIA_FC_COMMISSION_LABEL() {
		return COMP_RIA_FC_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_RIA_FC_COMMISSION() {
		return COMP_RIA_FC_COMMISSION;
	}

	public void setCOMP_RIA_FC_COMMISSION_LABEL(HtmlOutputLabel COMP_RIA_FC_COMMISSION_LABEL) {
		this.COMP_RIA_FC_COMMISSION_LABEL = COMP_RIA_FC_COMMISSION_LABEL;
	}

	public void setCOMP_RIA_FC_COMMISSION(HtmlInputText COMP_RIA_FC_COMMISSION) {
		this.COMP_RIA_FC_COMMISSION = COMP_RIA_FC_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_RIA_CLM_PAID_LABEL() {
		return COMP_RIA_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RIA_CLM_PAID() {
		return COMP_RIA_CLM_PAID;
	}

	public void setCOMP_RIA_CLM_PAID_LABEL(HtmlOutputLabel COMP_RIA_CLM_PAID_LABEL) {
		this.COMP_RIA_CLM_PAID_LABEL = COMP_RIA_CLM_PAID_LABEL;
	}

	public void setCOMP_RIA_CLM_PAID(HtmlInputText COMP_RIA_CLM_PAID) {
		this.COMP_RIA_CLM_PAID = COMP_RIA_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RIA_CLAIMS_OS_LABEL() {
		return COMP_RIA_CLAIMS_OS_LABEL;
	}

	public HtmlInputText getCOMP_RIA_CLAIMS_OS() {
		return COMP_RIA_CLAIMS_OS;
	}

	public void setCOMP_RIA_CLAIMS_OS_LABEL(HtmlOutputLabel COMP_RIA_CLAIMS_OS_LABEL) {
		this.COMP_RIA_CLAIMS_OS_LABEL = COMP_RIA_CLAIMS_OS_LABEL;
	}

	public void setCOMP_RIA_CLAIMS_OS(HtmlInputText COMP_RIA_CLAIMS_OS) {
		this.COMP_RIA_CLAIMS_OS = COMP_RIA_CLAIMS_OS;
	}

	public HtmlOutputLabel getCOMP_RIA_FM_DT_LABEL() {
		return COMP_RIA_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RIA_FM_DT() {
		return COMP_RIA_FM_DT;
	}

	public void setCOMP_RIA_FM_DT_LABEL(HtmlOutputLabel COMP_RIA_FM_DT_LABEL) {
		this.COMP_RIA_FM_DT_LABEL = COMP_RIA_FM_DT_LABEL;
	}

	public void setCOMP_RIA_FM_DT(HtmlCalendar COMP_RIA_FM_DT) {
		this.COMP_RIA_FM_DT = COMP_RIA_FM_DT;
	}

	public HtmlOutputLabel getCOMP_RIA_TO_DT_LABEL() {
		return COMP_RIA_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RIA_TO_DT() {
		return COMP_RIA_TO_DT;
	}

	public void setCOMP_RIA_TO_DT_LABEL(HtmlOutputLabel COMP_RIA_TO_DT_LABEL) {
		this.COMP_RIA_TO_DT_LABEL = COMP_RIA_TO_DT_LABEL;
	}

	public void setCOMP_RIA_TO_DT(HtmlCalendar COMP_RIA_TO_DT) {
		this.COMP_RIA_TO_DT = COMP_RIA_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TREATY() {
		return COMP_UI_M_BUT_TREATY;
	}

	public void setCOMP_UI_M_BUT_TREATY(HtmlCommandButton COMP_UI_M_BUT_TREATY) {
		this.COMP_UI_M_BUT_TREATY = COMP_UI_M_BUT_TREATY;
	}
 
	public HtmlCommandButton getCOMP_BUT_CUST_CODE() {
		return COMP_BUT_CUST_CODE;
	}

	public void setCOMP_BUT_CUST_CODE(HtmlCommandButton COMP_BUT_CUST_CODE) {
		this.COMP_BUT_CUST_CODE = COMP_BUT_CUST_CODE;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON98() {
		return COMP_PUSH_BUTTON98;
	}

	public void setCOMP_PUSH_BUTTON98(HtmlCommandButton COMP_PUSH_BUTTON98) {
		this.COMP_PUSH_BUTTON98 = COMP_PUSH_BUTTON98;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON136() {
		return COMP_PUSH_BUTTON136;
	}

	public void setCOMP_PUSH_BUTTON136(HtmlCommandButton COMP_PUSH_BUTTON136) {
		this.COMP_PUSH_BUTTON136 = COMP_PUSH_BUTTON136;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON138() {
		return COMP_PUSH_BUTTON138;
	}

	public void setCOMP_PUSH_BUTTON138(HtmlCommandButton COMP_PUSH_BUTTON138) {
		this.COMP_PUSH_BUTTON138 = COMP_PUSH_BUTTON138;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON99() {
		return COMP_PUSH_BUTTON99;
	}

	public void setCOMP_PUSH_BUTTON99(HtmlCommandButton COMP_PUSH_BUTTON99) {
		this.COMP_PUSH_BUTTON99 = COMP_PUSH_BUTTON99;
	}

	public PT_IL_RI_ALLOC getPT_IL_RI_ALLOC_BEAN() {
		return PT_IL_RI_ALLOC_BEAN;
	}

	public void setPT_IL_RI_ALLOC_BEAN(PT_IL_RI_ALLOC PT_IL_RI_ALLOC_BEAN) {
		this.PT_IL_RI_ALLOC_BEAN = PT_IL_RI_ALLOC_BEAN;
	}

	public List<PT_IL_RI_ALLOC> getDivnCodeList() {
		return divnCodeList;
	}

	public void setDivnCodeList(List<PT_IL_RI_ALLOC> divnCodeList) {
		this.divnCodeList = divnCodeList;
	}
	
	public List<PT_IL_RI_ALLOC> getDeptCodeList() {
		return deptCodeList;
	}

	public void setDeptCodeList(List<PT_IL_RI_ALLOC> deptCodeList) {
		this.deptCodeList = deptCodeList;
	}

	public List<PT_IL_RI_ALLOC> getProductCodeList() {
		return productCodeList;
	}

	public void setProductCodeList(List<PT_IL_RI_ALLOC> productCodeList) {
		this.productCodeList = productCodeList;
	}

	public List<PT_IL_RI_ALLOC> getCoverCodeList() {
		return coverCodeList;
	}

	public void setCoverCodeList(List<PT_IL_RI_ALLOC> coverCodeList) {
		this.coverCodeList = coverCodeList;
	}
	
	public List<PT_IL_RI_ALLOC> getTreatyTypeList() {
		return treatyTypeList;
	}

	public void setTreatyTypeList(List<PT_IL_RI_ALLOC> treatyTypeList) {
		this.treatyTypeList = treatyTypeList;
	}
	
	public List<PT_IL_RI_ALLOC> fetchDivnCodeList(Object obj){
		String divnCode = (String)obj;
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try{
			divnCodeList = delegate.getDivnCodeLov(divnCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return divnCodeList ;
	}
	
	public void divnCodeDetails(ActionEvent event){

		boolean keepLooking = true;
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		String inputValue= (String) input.getSubmittedValue();

		if (inputValue != null) {
			Iterator<PT_IL_RI_ALLOC> iterator = divnCodeList.iterator();
			while(iterator.hasNext() && keepLooking){
				PT_IL_RI_ALLOC tempBean = iterator.next();
				if(tempBean.getRIA_DIVN_CODE().equals(inputValue)){
					PT_IL_RI_ALLOC_BEAN.setRIA_DIVN_CODE(tempBean.getRIA_DIVN_CODE());
					PT_IL_RI_ALLOC_BEAN.setUI_M_DIVN_DESC(tempBean.getUI_M_DIVN_DESC());
					keepLooking = false;
					
				}
			}
		}
	}
	
	public List<PT_IL_RI_ALLOC> fetchDeptCodeList(Object obj){
		String deptCode = (String)obj;
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try{
			deptCodeList = delegate.getDeptCodeLov(deptCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deptCodeList ;
	}
	
	public void deptCodeDetails(ActionEvent event){
		boolean keepLooking = true;
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		String inputValue= (String) input.getSubmittedValue();

		if (inputValue != null) {
			Iterator<PT_IL_RI_ALLOC> iterator = deptCodeList.iterator();
			while(iterator.hasNext() && keepLooking){
				PT_IL_RI_ALLOC tempBean = iterator.next();
				if(tempBean.getRIA_DEPT_CODE().equals(inputValue)){
					PT_IL_RI_ALLOC_BEAN.setRIA_DEPT_CODE(tempBean.getRIA_DEPT_CODE());
					PT_IL_RI_ALLOC_BEAN.setUI_M_DEPT_DESC(tempBean.getUI_M_DEPT_DESC());
					keepLooking = false;
					
				}
			}
		}
	}
	
	public List<PT_IL_RI_ALLOC> fetchProdCodeList(Object obj){
		String prodCode = (String)obj;
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try{
			productCodeList = delegate.getProdCodeLov(prodCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return productCodeList ;
	}
	
	public void prodCodeDetails(ActionEvent event){
		boolean keepLooking = true;
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		String inputValue= (String) input.getSubmittedValue();

		if (inputValue != null) {
			Iterator<PT_IL_RI_ALLOC> iterator = productCodeList.iterator();
			while(iterator.hasNext() && keepLooking){
				PT_IL_RI_ALLOC tempBean = iterator.next();
				if(tempBean.getRIA_PROD_CODE().equals(inputValue)){
					PT_IL_RI_ALLOC_BEAN.setRIA_PROD_CODE(tempBean.getRIA_PROD_CODE());
					PT_IL_RI_ALLOC_BEAN.setUI_M_PROD_DESC(tempBean.getUI_M_PROD_DESC());
					keepLooking = false;
					
				}
			}
		}
	}
	
	public List<PT_IL_RI_ALLOC> fetchCoverCodeList(Object obj){
		String coverCode = (String)obj;
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try{
			coverCodeList = delegate.getCoverCodeLov(coverCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return coverCodeList ;
	}
	
	public void coverCodeDetails(ActionEvent event){
		boolean keepLooking = true;
		UIInput input= (UIInput)event.getComponent().getParent().getParent();
		String inputValue= (String) input.getSubmittedValue();

		if (inputValue != null) {
			Iterator<PT_IL_RI_ALLOC> iterator = coverCodeList.iterator();
			while(iterator.hasNext() && keepLooking){
				PT_IL_RI_ALLOC tempBean = iterator.next();
				if(tempBean.getRIA_COVER_CODE().equals(inputValue)){
					PT_IL_RI_ALLOC_BEAN.setRIA_COVER_CODE(tempBean.getRIA_COVER_CODE());
					PT_IL_RI_ALLOC_BEAN.setUI_M_COVER_DESC(tempBean.getUI_M_COVER_DESC());
					keepLooking = false;
					
				}
			}
		}
	}
	
	public List<PT_IL_RI_ALLOC> fetchTreatyTypeList(Object obj){
		String treatyType = (String)obj;
		PILQ111_APAC_DELEGATE delegate = new PILQ111_APAC_DELEGATE();
		try{
			treatyTypeList = delegate.getTreatyTypeLov(treatyType);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return treatyTypeList ;
	}
	
	/*
	 *  a4j calls method
	 */
	
	public void validateRIA_DIVN_CODE(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		PILQ111_APAC_HELPER helper = new PILQ111_APAC_HELPER();
		helper.ria_divn_code_when_validate_item(compositeAction);
	}
	
	public void  fireFieldValidation(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateRIA_DEPT_CODE(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		PILQ111_APAC_HELPER helper = new PILQ111_APAC_HELPER();
		helper.ria_dept_code_when_validate_item(compositeAction);
	}
	
	public void RIA_DEPT_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateRIA_PROD_CODE(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		PILQ111_APAC_HELPER helper = new PILQ111_APAC_HELPER();
		helper.ria_prod_code_when_validate_item(compositeAction);
	}
	
	public void RIA_PROD_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateRIA_COVER_CODE(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		PILQ111_APAC_HELPER helper = new PILQ111_APAC_HELPER();
		helper.ria_cover_code_when_validate_item(compositeAction);
	}
	
	public void RIA_COVER_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	 
	public String saveRecord() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		if(PT_IL_RI_ALLOC_BEAN.getROWID() == null){
			
			
		}
		
		
		return "";
	}
	
	public String navigateToSearch(){
		CommonUtils utils = new CommonUtils();
		//utils.clearMappedBeanFromSession("PILQ111_APAC_COMPOSITE_ACTION");
		PILQ111_APAC_SEARCH_ACTION searchAction = new PILQ111_APAC_SEARCH_ACTION();
		searchAction.fetchRiAllocList();
		return "PILQ111_APAC";
	}
	
	public String navigateToTreatyAccountQueryScreen(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_RI_PART_CUST_ALLOC_ACTION riPartCustAllocAction = compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN();
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			List<PT_IL_RI_PART_CUST_ALLOC> partCustAllocList = riPartCustAllocAction.getDataListPT_IL_RI_PART_CUST_ALLOC();
			 
			if(partCustAllocList!=null && partCustAllocList.size()>0) {
	 
					PT_IL_RI_PART_CUST_ALLOC partCustAllocBean =   riPartCustAllocAction.getPT_IL_RI_PART_CUST_ALLOC_BEAN();
					String RIPCA_CUST_CODE = partCustAllocBean.getRIPCA_CUST_CODE();
					CommonUtils.setGlobalVariable("GLOBAL.M_CUST_CODE", RIPCA_CUST_CODE);
					CommonUtils.setGlobalVariable("CALLING_FORM", "PILQ111_APAC");
					CommonUtils.setGlobalVariable("PILQ111_APAC_CALLING_FORM", "PILQ111_APAC");
					sessionMap.put("GLOBAL.M_CUST_CODE", RIPCA_CUST_CODE);
					sessionMap.put("CALLING_FORM", "PILQ111_APAC");
					sessionMap.put("PILQ111_APAC_CALLING_FORM", "PILQ111_APAC");
					PS_IL_DRCR_TREATY_ACTION treatyAction = PILQ103_APAC_ACTION_INSTANCE.getPS_IL_DRCR_TREATY_ACTION_INSTANCE();
					if(treatyAction!=null){
						treatyAction.setPreFormFlag(false);
						treatyAction.setOnLoadFlag(false);
						treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_DR(0.0);
						treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_CR(0.0);
					}
				 
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
			return null;
		}
		return "PILQ103_APAC";
	}
	
	public ArrayList<LovBean> lovRIA_DEPT_CODE(Object value){
		ArrayList<LovBean> suggestions = null;
		try {
			suggestions = new ListItemUtil().P_CALL_LOV("PILQ111_APAC", 
					"PT_IL_RI_ALLOC",  "RIA_DEPT_CODE", 
					null,null,null,	null, 
					null, (String)value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION_M_POL_NO", e.getMessage());
		}
		return suggestions;
	}
	
	public ArrayList<LovBean> lovRIA_PROD_CODE(Object value){
	    ArrayList<LovBean> suggestions = null;
	    
	    try {
		suggestions = new ListItemUtil().P_CALL_LOV("PILQ111_APAC", 
			"PT_IL_RI_ALLOC",  "RIA_PROD_CODE",  null,null,null,	null, 
			null, (String)value);
	    } catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("SUGGESTION_M_POL_NO", e.getMessage());
	    }
	    
	    return suggestions;
	}
	
	public ArrayList<LovBean> lovRIA_COVER_CODE(Object value){
	    ArrayList<LovBean> suggestions = null;
	    
	    try {
		suggestions = new ListItemUtil().P_CALL_LOV("PILQ111_APAC", 
			"PT_IL_RI_ALLOC",  "RIA_COVER_CODE", 
			null,null,null,	null, 
			null, (String)value);
	    } catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("SUGGESTION_M_POL_NO", e.getMessage());
	    }
	    
	    return suggestions;
	}
	public ArrayList<LovBean> lovRIA_TTY_TYPE(Object value){
	    ArrayList<LovBean> suggestions = null;
	    
	    try {
		suggestions = new ListItemUtil().P_CALL_LOV("PILQ111_APAC", 
			"PT_IL_RI_ALLOC",  "RIA_TTY_TYPE", "IL_TTY_TYP" ,
			null,null,null,	null, (String)value);
	    } catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("SUGGESTION_M_POL_NO", e.getMessage());
	    }
	    
	    return suggestions;
	}

	public List<LovBean> lovRIA_DIVN_CODE(Object obj) throws Exception{
			String code = (String) obj;
			List<LovBean> suggestionList = null;
			Object[] object={};
			String query=null;
			if("*".equals(code)){
				object=new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(), PELConstants.suggetionRecordSize};
				 query="SELECT DIVN_CODE,DIVN_NAME,DIVN_BL_NAME ,ROWID FROM PM_DIVISION WHERE DIVN_COMP_CODE = ?" +
				 		" AND DIVN_FRZ_FLAG = 'N' AND ROWNUM < ? ORDER BY 1 ASC ";
			}else{
				object=new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),
					code+"%",code+"%",PELConstants.suggetionRecordSize};
				query=" SELECT DIVN_CODE,DIVN_NAME,DIVN_BL_NAME ,ROWID FROM PM_DIVISION WHERE DIVN_COMP_CODE = ? " +
		 		" AND DIVN_FRZ_FLAG = 'N' AND ( DIVN_CODE LIKE ?  OR DIVN_NAME LIKE ? ) AND ROWNUM < ? ORDER BY 1 ASC  ";
			}
			suggestionList = new ListItemUtil().prepareSuggestionList(query, object);
			return suggestionList;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FETCH() {
	    return COMP_UI_M_BUT_FETCH;
	}

	public void setCOMP_UI_M_BUT_FETCH(HtmlCommandButton comp_ui_m_but_fetch) {
	    COMP_UI_M_BUT_FETCH = comp_ui_m_but_fetch;
	}
	
	public String  fetchButtonAction() {
	    
	    try {
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().onLoad();
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	    return null;
	}
	
	

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PT_IL_RI_ALLOC> getDataList_PT_IL_RI_ALLOC() {
		return dataList_PT_IL_RI_ALLOC;
	}

	public void setDataList_PT_IL_RI_ALLOC(
			List<PT_IL_RI_ALLOC> dataList_PT_IL_RI_ALLOC) {
		this.dataList_PT_IL_RI_ALLOC = dataList_PT_IL_RI_ALLOC;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_RI_ALLOC_BEAN = (PT_IL_RI_ALLOC) dataTable
					.getRowData();
			PT_IL_RI_ALLOC_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
		private void resetSelectedRow() {
			Iterator<PT_IL_RI_ALLOC>  iterator = dataList_PT_IL_RI_ALLOC.iterator();
			
			while(iterator.hasNext()){
				iterator.next().setRowSelected(false);
			}
		}

	public void resetAllComponent(){
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_CUST_CODE().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_SHARE_PERC().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_TTY_TYPE().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_FC_PREMIUM().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_LC_PREMIUM().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_FC_COMMISSION().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_LC_COMMISSION().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_CLM_PAID().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_RIPCA_CLAIMS_OS().resetValue();
		compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().getCOMP_UI_M_CUST_NAME().resetValue();
	}

}

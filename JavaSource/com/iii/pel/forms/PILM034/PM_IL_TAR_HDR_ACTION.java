package com.iii.pel.forms.PILM034;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TAR_HDR_ACTION extends CommonAction {

	private String TH_Code;

	private String Param_Type;

	private HtmlOutputLabel COMP_TH_CODE_LABEL;

	private HtmlInputText COMP_TH_CODE;

	private HtmlOutputLabel COMP_TH_DESC_LABEL;

	private HtmlInputText COMP_TH_DESC;

	private HtmlOutputLabel COMP_TH_BL_DESC_LABEL;

	private HtmlInputText COMP_TH_BL_DESC;

	private HtmlOutputLabel COMP_TH_RATE_PER_LABEL;

	private HtmlInputText COMP_TH_RATE_PER;

	private HtmlOutputLabel COMP_TH_PARA_01_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_01;

	private HtmlOutputLabel COMP_TH_PARA_02_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_02;

	private HtmlOutputLabel COMP_TH_PARA_03_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_03;

	private HtmlOutputLabel COMP_TH_PARA_04_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_04;

	private HtmlOutputLabel COMP_TH_PARA_05_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_05;

	private HtmlOutputLabel COMP_TH_PARA_06_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_06;

	private HtmlOutputLabel COMP_TH_PARA_07_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_07;

	private HtmlOutputLabel COMP_TH_PARA_08_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_08;

	private HtmlOutputLabel COMP_TH_PARA_10_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_10;

	private HtmlOutputLabel COMP_TH_PARA_09_LABEL;

	private HtmlSelectOneMenu COMP_TH_PARA_09;

	private HtmlOutputLabel COMP_TH_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TH_EFF_TO_DT;

	private HtmlOutputLabel COMP_TH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TH_EFF_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TH_CODE_LABEL;

	private HtmlInputText COMP_UI_M_TH_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private HtmlCommandButton COMP_UI_M_BUT_TARIFF_DTL;

	private PM_IL_TAR_HDR PM_IL_TAR_HDR_BEAN;

	public PILM034_COMPOSITE_ACTION compositeAction;

	private PM_IL_TAR_HDR_HELPER helper;

	private PM_IL_TAR_HDR_DELEGATE delegate;

	private List<SelectItem> listTH_PARA = new ArrayList<SelectItem>();

	ArrayList<LovBean> lovList = new ArrayList<LovBean>();

	String parameterCode= null;

	private UIData dataTable;

	private List<PM_IL_TAR_HDR> dataList = new ArrayList<PM_IL_TAR_HDR>();

	public PM_IL_TAR_HDR_ACTION(){

		PM_IL_TAR_HDR_BEAN = new PM_IL_TAR_HDR();
		helper = new PM_IL_TAR_HDR_HELPER();
		delegate = new PM_IL_TAR_HDR_DELEGATE();
		paramValues();
	}

	public HtmlOutputLabel getCOMP_TH_CODE_LABEL() {
		return COMP_TH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TH_CODE() {
		return COMP_TH_CODE;
	}

	public void setCOMP_TH_CODE_LABEL(HtmlOutputLabel COMP_TH_CODE_LABEL) {
		this.COMP_TH_CODE_LABEL = COMP_TH_CODE_LABEL;
	}

	public void setCOMP_TH_CODE(HtmlInputText COMP_TH_CODE) {
		this.COMP_TH_CODE = COMP_TH_CODE;
	}

	public HtmlOutputLabel getCOMP_TH_DESC_LABEL() {
		return COMP_TH_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TH_DESC() {
		return COMP_TH_DESC;
	}

	public void setCOMP_TH_DESC_LABEL(HtmlOutputLabel COMP_TH_DESC_LABEL) {
		this.COMP_TH_DESC_LABEL = COMP_TH_DESC_LABEL;
	}

	public void setCOMP_TH_DESC(HtmlInputText COMP_TH_DESC) {
		this.COMP_TH_DESC = COMP_TH_DESC;
	}

	public HtmlOutputLabel getCOMP_TH_BL_DESC_LABEL() {
		return COMP_TH_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TH_BL_DESC() {
		return COMP_TH_BL_DESC;
	}

	public void setCOMP_TH_BL_DESC_LABEL(HtmlOutputLabel COMP_TH_BL_DESC_LABEL) {
		this.COMP_TH_BL_DESC_LABEL = COMP_TH_BL_DESC_LABEL;
	}

	public void setCOMP_TH_BL_DESC(HtmlInputText COMP_TH_BL_DESC) {
		this.COMP_TH_BL_DESC = COMP_TH_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_TH_RATE_PER_LABEL() {
		return COMP_TH_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_TH_RATE_PER() {
		return COMP_TH_RATE_PER;
	}

	public void setCOMP_TH_RATE_PER_LABEL(HtmlOutputLabel COMP_TH_RATE_PER_LABEL) {
		this.COMP_TH_RATE_PER_LABEL = COMP_TH_RATE_PER_LABEL;
	}

	public void setCOMP_TH_RATE_PER(HtmlInputText COMP_TH_RATE_PER) {
		this.COMP_TH_RATE_PER = COMP_TH_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_01_LABEL() {
		return COMP_TH_PARA_01_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_01() {
		return COMP_TH_PARA_01;
	}

	public void setCOMP_TH_PARA_01_LABEL(HtmlOutputLabel COMP_TH_PARA_01_LABEL) {
		this.COMP_TH_PARA_01_LABEL = COMP_TH_PARA_01_LABEL;
	}

	public void setCOMP_TH_PARA_01(HtmlSelectOneMenu COMP_TH_PARA_01) {
		this.COMP_TH_PARA_01 = COMP_TH_PARA_01;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_02_LABEL() {
		return COMP_TH_PARA_02_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_02() {
		return COMP_TH_PARA_02;
	}

	public void setCOMP_TH_PARA_02_LABEL(HtmlOutputLabel COMP_TH_PARA_02_LABEL) {
		this.COMP_TH_PARA_02_LABEL = COMP_TH_PARA_02_LABEL;
	}

	public void setCOMP_TH_PARA_02(HtmlSelectOneMenu COMP_TH_PARA_02) {
		this.COMP_TH_PARA_02 = COMP_TH_PARA_02;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_03_LABEL() {
		return COMP_TH_PARA_03_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_03() {
		return COMP_TH_PARA_03;
	}

	public void setCOMP_TH_PARA_03_LABEL(HtmlOutputLabel COMP_TH_PARA_03_LABEL) {
		this.COMP_TH_PARA_03_LABEL = COMP_TH_PARA_03_LABEL;
	}

	public void setCOMP_TH_PARA_03(HtmlSelectOneMenu COMP_TH_PARA_03) {
		this.COMP_TH_PARA_03 = COMP_TH_PARA_03;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_04_LABEL() {
		return COMP_TH_PARA_04_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_04() {
		return COMP_TH_PARA_04;
	}

	public void setCOMP_TH_PARA_04_LABEL(HtmlOutputLabel COMP_TH_PARA_04_LABEL) {
		this.COMP_TH_PARA_04_LABEL = COMP_TH_PARA_04_LABEL;
	}

	public void setCOMP_TH_PARA_04(HtmlSelectOneMenu COMP_TH_PARA_04) {
		this.COMP_TH_PARA_04 = COMP_TH_PARA_04;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_05_LABEL() {
		return COMP_TH_PARA_05_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_05() {
		return COMP_TH_PARA_05;
	}

	public void setCOMP_TH_PARA_05_LABEL(HtmlOutputLabel COMP_TH_PARA_05_LABEL) {
		this.COMP_TH_PARA_05_LABEL = COMP_TH_PARA_05_LABEL;
	}

	public void setCOMP_TH_PARA_05(HtmlSelectOneMenu COMP_TH_PARA_05) {
		this.COMP_TH_PARA_05 = COMP_TH_PARA_05;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_06_LABEL() {
		return COMP_TH_PARA_06_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_06() {
		return COMP_TH_PARA_06;
	}

	public void setCOMP_TH_PARA_06_LABEL(HtmlOutputLabel COMP_TH_PARA_06_LABEL) {
		this.COMP_TH_PARA_06_LABEL = COMP_TH_PARA_06_LABEL;
	}

	public void setCOMP_TH_PARA_06(HtmlSelectOneMenu COMP_TH_PARA_06) {
		this.COMP_TH_PARA_06 = COMP_TH_PARA_06;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_07_LABEL() {
		return COMP_TH_PARA_07_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_07() {
		return COMP_TH_PARA_07;
	}

	public void setCOMP_TH_PARA_07_LABEL(HtmlOutputLabel COMP_TH_PARA_07_LABEL) {
		this.COMP_TH_PARA_07_LABEL = COMP_TH_PARA_07_LABEL;
	}

	public void setCOMP_TH_PARA_07(HtmlSelectOneMenu COMP_TH_PARA_07) {
		this.COMP_TH_PARA_07 = COMP_TH_PARA_07;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_08_LABEL() {
		return COMP_TH_PARA_08_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_08() {
		return COMP_TH_PARA_08;
	}

	public void setCOMP_TH_PARA_08_LABEL(HtmlOutputLabel COMP_TH_PARA_08_LABEL) {
		this.COMP_TH_PARA_08_LABEL = COMP_TH_PARA_08_LABEL;
	}

	public void setCOMP_TH_PARA_08(HtmlSelectOneMenu COMP_TH_PARA_08) {
		this.COMP_TH_PARA_08 = COMP_TH_PARA_08;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_10_LABEL() {
		return COMP_TH_PARA_10_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_10() {
		return COMP_TH_PARA_10;
	}

	public void setCOMP_TH_PARA_10_LABEL(HtmlOutputLabel COMP_TH_PARA_10_LABEL) {
		this.COMP_TH_PARA_10_LABEL = COMP_TH_PARA_10_LABEL;
	}

	public void setCOMP_TH_PARA_10(HtmlSelectOneMenu COMP_TH_PARA_10) {
		this.COMP_TH_PARA_10 = COMP_TH_PARA_10;
	}

	public HtmlOutputLabel getCOMP_TH_PARA_09_LABEL() {
		return COMP_TH_PARA_09_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_TH_PARA_09() {
		return COMP_TH_PARA_09;
	}

	public void setCOMP_TH_PARA_09_LABEL(HtmlOutputLabel COMP_TH_PARA_09_LABEL) {
		this.COMP_TH_PARA_09_LABEL = COMP_TH_PARA_09_LABEL;
	}

	public void setCOMP_TH_PARA_09(HtmlSelectOneMenu COMP_TH_PARA_09) {
		this.COMP_TH_PARA_09 = COMP_TH_PARA_09;
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

	public HtmlOutputLabel getCOMP_UI_M_TH_CODE_LABEL() {
		return COMP_UI_M_TH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TH_CODE() {
		return COMP_UI_M_TH_CODE;
	}

	public void setCOMP_UI_M_TH_CODE_LABEL(HtmlOutputLabel COMP_UI_M_TH_CODE_LABEL) {
		this.COMP_UI_M_TH_CODE_LABEL = COMP_UI_M_TH_CODE_LABEL;
	}

	public void setCOMP_UI_M_TH_CODE(HtmlInputText COMP_UI_M_TH_CODE) {
		this.COMP_UI_M_TH_CODE = COMP_UI_M_TH_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TARIFF_DTL() {
		return COMP_UI_M_BUT_TARIFF_DTL;
	}

	public void setCOMP_UI_M_BUT_TARIFF_DTL(HtmlCommandButton COMP_UI_M_BUT_TARIFF_DTL) {
		this.COMP_UI_M_BUT_TARIFF_DTL = COMP_UI_M_BUT_TARIFF_DTL;
	}

	public PM_IL_TAR_HDR getPM_IL_TAR_HDR_BEAN() {
		return PM_IL_TAR_HDR_BEAN;
	}

	public void setPM_IL_TAR_HDR_BEAN(PM_IL_TAR_HDR PM_IL_TAR_HDR_BEAN) {
		this.PM_IL_TAR_HDR_BEAN = PM_IL_TAR_HDR_BEAN;
	}
	public String saveRecord() {
		getWarningMap().clear();
		String livCode = null;
		try{
			if(PM_IL_TAR_HDR_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				helper.preInsert(PM_IL_TAR_HDR_BEAN);
				livCode = (String) compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN()
						.getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();
				PM_IL_TAR_HDR_BEAN.setTH_PARAM_TYPE(livCode);
				new CRUDHandler().executeInsert(PM_IL_TAR_HDR_BEAN,CommonUtils.getConnection());
				getWarningMap().put("SAVE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList.add(PM_IL_TAR_HDR_BEAN);
			}else if(PM_IL_TAR_HDR_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
				helper.preUpdate(PM_IL_TAR_HDR_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_TAR_HDR_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.
						pelMessagePropertiesPath,"errorPanel$message$update"));
			}
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return "";
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		String livCode = null;
		try {
			if (isBlockFlag()) {
				if (PM_IL_TAR_HDR_BEAN.getROWID() != null) {
					helper.executeQuery(compositeAction);
					TH_Code=PM_IL_TAR_HDR_BEAN.getTH_CODE();
					Param_Type=PM_IL_TAR_HDR_BEAN.getTH_PARAM_TYPE();
					new PP_LIST_ITEM_VALUES_DELEGATE().executeSelectStatement(
							compositeAction, PM_IL_TAR_HDR_BEAN
							.getTH_PARAM_TYPE());
					livCode = (String) compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN()
							.getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();
					helper.postQuery(PM_IL_TAR_HDR_BEAN, livCode);
					helper.WHEN_NEW_BLOCK_INSTANCE(this);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

	public void actionOnListChange1(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_01(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange2(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_02(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange3(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_03(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange4(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_04(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange5(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_05(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange6(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_06(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange7(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_07(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange8(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_08(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange9(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_09(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void actionOnListChange10(ActionEvent event){
		
		UIInput input=(UIInput)event.getComponent().getParent();
		int value=Integer.parseInt((String)input.getSubmittedValue());
		PM_IL_TAR_HDR_BEAN.setTH_PARA_10(value);
		paramvalidate((String)input.getSubmittedValue());

	}
	public void paramvalidate(String value){
		Method method = null;
		String beanval =null;
		int count = 0;	
		int val =0;
		try{
			if(!value.equals("0")){
				for(int i =1;i<=10;i++){
					if(i==10){
						method = PM_IL_TAR_HDR.class.getDeclaredMethod(
								"getTH_PARA_"+i);							
					}else{
						method = PM_IL_TAR_HDR.class.getDeclaredMethod(
								"getTH_PARA_0"+i);						
					}
					if(method.invoke(PM_IL_TAR_HDR_BEAN)!=null){						
						beanval=Integer.toString((Integer)method.invoke(PM_IL_TAR_HDR_BEAN));
					}else{
						beanval="0";	
					}

					if(value.equals(beanval)){
						count++;
					}
				}
				if(count>1){
					throw new Exception("Parameter is already selected!");
				}else{
					getWarningMap().clear();
				}
			}else{
				getWarningMap().clear();
			}
		}catch (Exception e) {
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getWarningMap().put("onLoad",e.getMessage());
		}		
	}
	// Validator
	public void onListChangeTH_PARA(FacesContext context, UIComponent component, Object  value){
		String M_YN = null;
		String M_YN2 = null;
		int paramType = 0;
		String compId = component.getId();
		PM_IL_TAR_HDR_HELPER headerHelper = new PM_IL_TAR_HDR_HELPER();
		HashMap<String, String> outValueMap = null;

		outValueMap = headerHelper.L_NULL_INBETWEEN((UIInput) component);
		if(outValueMap != null){
			if("Y".equals(outValueMap.get("M_YN"))){
				if(compId.equalsIgnoreCase(getCOMP_TH_PARA_02().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_02().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_02(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_03().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_03().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_03(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_04().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_04().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_04(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_05().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_05().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_05(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_06().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_06().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_06(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_07().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_07().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_07(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_08().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_08().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_08(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_09().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_09().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_09(paramType);
				}else if(compId.equalsIgnoreCase(getCOMP_TH_PARA_10().getId())){
					paramType = Integer.parseInt(getCOMP_TH_PARA_10().getSubmittedValue().toString());
					PM_IL_TAR_HDR_BEAN.setTH_PARA_10(paramType);
				}
			}
			// Show the warning message if raised from trigger
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, outValueMap.get("WARNING"));
			getWarningMap().put("ON_LIST_CHANGE", outValueMap.get("WARNING"));
		}
	}

	public void paramValues(){
		SelectItem selectItem = null;
		String caption = null;
		int sno;
		ArrayList<PM_IL_TAR_PARAM> valueBeanList =null;
		try {
			valueBeanList = helper.getCaptionValues();

			// Clearing the list
			listTH_PARA.clear();

			// Adding default Select to the list
			selectItem = new SelectItem(0, "Select");
			listTH_PARA.add(selectItem);

			for(int index = 0,size=valueBeanList.size(); index<size; index++){
				PM_IL_TAR_PARAM valueBean = valueBeanList.get(index);
				sno = valueBean.getTP_SRNO();
				caption = valueBean.getTP_CAPTION();
				selectItem = new SelectItem(sno, caption);
				listTH_PARA.add(selectItem);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("paramValues",e.getMessage());
		}
	} 

	public void validateFromDate(FacesContext context, UIComponent component, Object value){
		try {
			getCOMP_TH_EFF_FM_DT().getAsDate((Date)value);
			PM_IL_TAR_HDR_BEAN.setTH_EFF_FM_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_TH_EFF_FM_DT(this.PM_IL_TAR_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateToDate(FacesContext context, UIComponent component, Object value){
		try {
			getCOMP_TH_EFF_TO_DT().getAsDate((Date)value);
			PM_IL_TAR_HDR_BEAN.setTH_EFF_TO_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_TH_EFF_TO_DT(this.PM_IL_TAR_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void whenvalidateThCode(FacesContext context, UIComponent component, 
			Object value){
		String liv_code = compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
				getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();
		try {
			helper.WHEN_VALIDATE_ITEM_TH_CODE(this.PM_IL_TAR_HDR_BEAN, (String) value, liv_code,TH_Code,Param_Type);
			PM_IL_TAR_HDR_BEAN.setTH_CODE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateThCode(ActionEvent event){
		String submittedValue = (String) COMP_TH_CODE.getSubmittedValue();
		String liv_code = compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
				getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();
		try {
			if(submittedValue == null || submittedValue.trim().isEmpty()){
				//PM_IL_TAR_HDR_BEAN.setUI_M_TH_CODE(null);
				COMP_UI_M_TH_CODE.resetValue();
			}else{
				if(PM_IL_TAR_HDR_BEAN.getROWID()==null||!TH_Code.equalsIgnoreCase(submittedValue)||!Param_Type.equalsIgnoreCase(liv_code)){

					String Cursor="SELECT 'X' FROM PM_IL_TAR_HDR WHERE TH_CODE = ? AND TH_PARAM_TYPE = ?";
					Connection con = CommonUtils.getConnection();
					ResultSet rs=new CRUDHandler().executeSelectStatement(Cursor, con, new Object[]{submittedValue,liv_code});
					if(rs.next()){
						throw new Exception("Setup for this combination already exist !"); 
					}else{
						getErrorMap().clear();
					}
				}
			}		
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("paramValues",e.getMessage());
		}
	}
	public void validateThRate(FacesContext context, UIComponent component, Object value){
		try {
			PM_IL_TAR_HDR_BEAN.setTH_RATE_PER((Integer)value);
			helper.WHEN_VALIDATE_ITEM_TH_RATE_PER(this.PM_IL_TAR_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateTH_DESC(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		if(value == null || value.trim().isEmpty()){
			PM_IL_TAR_HDR_BEAN.setTH_DESC(PM_IL_TAR_HDR_BEAN.getUI_M_TH_CODE());
			COMP_TH_DESC.resetValue();
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public ArrayList<LovBean> prepareThCodeLov(Object obj){
		String codeTypeCode = null;
		String query = null;
		try {
			codeTypeCode = obj.toString();
			parameterCode = compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
					getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();

			if("*".equalsIgnoreCase(codeTypeCode)){
				query = PILM034_QUERYCONSTANTS.PM_IL_TAR_HDR_TH_CODE_LOV_QUERY1;
				Object values[] ={parameterCode,parameterCode,parameterCode,parameterCode,
						parameterCode,parameterCode,parameterCode,parameterCode,parameterCode,parameterCode};
				System.out.println("parameterCode========>"+parameterCode);
				lovList = delegate.populateLovs(query, values);

			}else{
				codeTypeCode = codeTypeCode+"%";
				query = PILM034_QUERYCONSTANTS.PM_IL_TAR_HDR_TH_CODE_LOV_QUERY2;
				Object values[] ={parameterCode,codeTypeCode,parameterCode,codeTypeCode,
						parameterCode,codeTypeCode,parameterCode,codeTypeCode,parameterCode,
						codeTypeCode,parameterCode,codeTypeCode,parameterCode,codeTypeCode,
						parameterCode,codeTypeCode,parameterCode,codeTypeCode,parameterCode,codeTypeCode};
				System.out.println("parameterCode========>"+parameterCode);
				System.out.println("codeTypeCode========>"+codeTypeCode);
				lovList = delegate.populateLovs(query, values);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareThCodeLov",e.getMessage());
		}
		return lovList;
	}

	public String deleteRow(){
		try{
			String livCode = null;
			if (isDELETE_ALLOWED()){
				livCode = (String) compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN()
						.getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();
				helper.key_delrec(PM_IL_TAR_HDR_BEAN, livCode);
				new CRUDHandler().executeDelete(PM_IL_TAR_HDR_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				// Resetting the screen after delete
				compositeAction = new PILM034_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILM034_COMPOSITE_ACTION", compositeAction);

				// Assigning message to new action class
				compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getWarningMap().put(
						"deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return "";
	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);
		String livCode = null;
		try{
			livCode = (String) compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN()
					.getCOMP_LIV_CODE().getSubmittedValue();
			resetSelectedRow();
			PM_IL_TAR_HDR_BEAN = (PM_IL_TAR_HDR)dataTable.getRowData();
			helper.postQuery(PM_IL_TAR_HDR_BEAN, livCode);
			helper.WHEN_NEW_BLOCK_INSTANCE(this);
			PM_IL_TAR_HDR_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}
	}

	private void resetSelectedRow(){
		Iterator<PM_IL_TAR_HDR> PM_IL_TAR_HDR_ITR = dataList.iterator();
		while (PM_IL_TAR_HDR_ITR.hasNext()) {
			PM_IL_TAR_HDR_ITR.next().setRowSelected(false);}
	}

	private void resetAllComponent(){
		COMP_TH_BL_DESC.resetValue();
		COMP_TH_CODE.resetValue();
		//COMP_TH_DESC.resetValue();
		COMP_TH_EFF_FM_DT.resetValue();
		COMP_TH_EFF_TO_DT.resetValue();
		COMP_TH_PARA_01.resetValue();
		COMP_TH_PARA_02.resetValue();
		COMP_TH_PARA_03.resetValue();
		COMP_TH_PARA_04.resetValue();
		COMP_TH_PARA_05.resetValue();
		COMP_TH_PARA_06.resetValue();
		COMP_TH_PARA_07.resetValue();
		COMP_TH_PARA_08.resetValue();
		COMP_TH_PARA_09.resetValue();
		COMP_TH_PARA_10.resetValue();
		COMP_TH_RATE_PER.resetValue();
		COMP_UI_M_TH_CODE.resetValue();
	}

	public String tariffDetail(){
		String tariffDtl = null;
		PM_IL_TAR_DTL_ACTION tarDetailAction = null;
		BP_ACTION bpAction = null;

		if(PM_IL_TAR_HDR_BEAN.getROWID() != null){
			tarDetailAction = new PM_IL_TAR_DTL_ACTION();
			tarDetailAction.compositeAction = compositeAction;
			compositeAction.setPM_IL_TAR_DTL_ACTION_BEAN(tarDetailAction);
			bpAction = new BP_ACTION();
			bpAction.compositeAction = compositeAction;
			compositeAction.setBP_ACTION_BEAN(bpAction);

			tariffDtl = "PILM034_PM_IL_TAR_DTL";
		}else{
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Fields are Empty");
			getWarningMap().put("GO_TO_TARIFF", "Fields are Empty");
		}
		return tariffDtl;
	}

	public List<SelectItem> getListTH_PARA() {
		return listTH_PARA;
	}

	public void setListTH_PARA(List<SelectItem> listTH_PARA) {
		this.listTH_PARA = listTH_PARA;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PM_IL_TAR_HDR> getDataList() {
		return dataList;
	}

	public void setDataList(List<PM_IL_TAR_HDR> dataList) {
		this.dataList = dataList;
	}
}

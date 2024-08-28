package com.iii.pel.forms.PM010_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM001_A.PM_DIVISION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM010_A_COMPANY_MASTER_ACTION extends CommonAction {

	
	private PM010_A_COMPANY PM010_A_COMPANY_BEAN;
	private PM_DIVISION PM_DIVISION_BEAN;
	
	private HtmlOutputLabel COMP_COMP_CODE_LABEL;
	private HtmlInputText COMP_CODE_INPUT;
	private HtmlOutputLabel COMP_COMP_NAME_LABEL;
	private HtmlInputText COMP_NAME_INPUT;
	private HtmlOutputLabel COMP_COMP_DESC_LABEL;
	private HtmlInputText COMP_DESC_INPUT;
	private HtmlOutputLabel COMP_COMP_ADDR1_LABEL;
	private HtmlInputText COMP_ADDR1_INPUT;
	//private HtmlOutputLabel COMP_COMP_;
	private HtmlInputText COMP_ADDR2_INPUT;
	//private HtmlOutputLabel COMP_COMP_;
	private HtmlInputText COMP_ADDR3_INPUT;
	private HtmlOutputLabel COMP_COMP_DEFAULT_BRANCH_LABEL;
	private HtmlInputText COMP_DEFAULT_BRANCH_CODE_INPUT;
	//private HtmlOutputLabel ;
	private HtmlInputText COMP_DEFAULT_BRANCH_NAME_INPUT;
	private HtmlOutputLabel COMP_COMP_DEFAULT_DEPT_LABEL;
	private HtmlInputText COMP_DEFAULT_DEPT_CODE_INPUT;
	//private HtmlOutputLabel ;
	private HtmlInputText COMP_DEFAULT_DEPT_NAME;
	private HtmlOutputLabel COMP_COMP_CEO_NAME_LABEL;
	private HtmlInputText COMP_CEO_NAME_INPUT;
	private HtmlOutputLabel COMP_COMP_PHONE_LABEL;
	private HtmlInputText COMP_PHONE_INPUT;
	private HtmlOutputLabel COMP_COMP_FAX_LABEL;
	private HtmlInputText COMP_FAX_INPUT;
	private HtmlOutputLabel COMP_COMP_EMAIL_LABEL;
	private HtmlInputText COMP_EMAIL_INPUT;
	private HtmlOutputLabel COMP_COMP_WEBSITE_LABEL;
	private HtmlInputText COMP_WEBSITE_INPUT;
	private HtmlOutputLabel COMP_FRZ_FLAG_LABEL;
	private HtmlSelectBooleanCheckbox COMP_FRZ_YN;
	//private PM_IL_DOC_TODO_GROUP_HELPER helper;
	//public PILQ003_COMPOSITE_ACTION compositeAction;
	//private PM010_A_COMPANY_MASTER_HELPER helper;
	private PM010_A_COMPANY_MASTER_HELPER helper;
	public PM010_A_COMPOSITE_ACTION compositeAction;
	
	private PM010_A_COMPANY_MASTER_DELEGATE PM010_A_COMPANY_MASTER_DELEGATE_BEAN;
	private List divisionList;
	private List departmentList;
	
	public PM010_A_COMPANY_MASTER_ACTION() {
		// TODO Auto-generated constructor stub
		helper=new PM010_A_COMPANY_MASTER_HELPER();
		PM010_A_COMPANY_BEAN = new PM010_A_COMPANY();
		PM_DIVISION_BEAN=new PM_DIVISION();
		instantiateAllFormComponent();
		PM010_A_COMPANY_MASTER_DELEGATE_BEAN = new PM010_A_COMPANY_MASTER_DELEGATE();
	}
	public void instantiateAllFormComponent(){
		COMP_DEFAULT_BRANCH_CODE_INPUT = new HtmlInputText();
		COMP_DEFAULT_BRANCH_NAME_INPUT = new HtmlInputText();
		COMP_DEFAULT_DEPT_CODE_INPUT = new HtmlInputText();
		COMP_DEFAULT_DEPT_NAME = new HtmlInputText();
		
		
		/*Added by Janani for factory testing feedback changes on 12.04.2017*/
		
		COMP_DEF_NATION_LABEL = new HtmlOutputLabel();
		COMP_DEF_NATION = new HtmlInputText();
		COMP_UI_M_COMP_DEF_NATION_DESC = new HtmlInputText();
		
		/*End*/

	}
	//DIVN SET-SUBMIT
	public void setSubmitValue(List divnCode){
		if(!divnCode.isEmpty()){
			System.out.println("divnCodeList.size() ==================>>>>>"+divnCode.size());
			PM010_A_COMPANY pm010_a_company_bean =(PM010_A_COMPANY)divnCode.get(0);
			System.out.println("pm010_a_company_bean.getCOMP_DFLT_DIVN()"+pm010_a_company_bean.getCOMP_DFLT_DIVN());
			COMP_DEFAULT_BRANCH_CODE_INPUT.setSubmittedValue(pm010_a_company_bean.getCOMP_DFLT_DIVN());
			System.out.println("COMP_DEFAULT_BRANCH_CODE_INPUT"+COMP_DEFAULT_BRANCH_CODE_INPUT.getSubmittedValue());
		}
	}
	//DEPARTMENT SET-SUBMIT
	public void setDeptSubmitValue(List departmentList){
		if(!departmentList.isEmpty()){
			System.out.println("divnCodeList.size() ==================>>>>>"+departmentList.size());
			PM010_A_COMPANY pm010_a_company_bean =(PM010_A_COMPANY)departmentList.get(0);
			System.out.println("pm010_a_company_bean.getCOMP_DEFAULT_DEPT_CODE_INPUT()"+pm010_a_company_bean.getCOMP_DFLT_DEPT());
			COMP_DEFAULT_DEPT_CODE_INPUT.setSubmittedValue(pm010_a_company_bean.getCOMP_DFLT_DEPT());
			System.out.println("COMP_DEFAULT_BRANCH_CODE_INPUT"+COMP_DEFAULT_DEPT_CODE_INPUT.getSubmittedValue());
		}
	}
	
	
	public PM010_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM010_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/*public PM010_A_COMPANY_MASTER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM010_A_COMPANY_MASTER_HELPER helper) {
		this.helper = helper;
	}*/

	public HtmlOutputLabel getCOMP_COMP_CODE_LABEL() {
		return COMP_COMP_CODE_LABEL;
	}

	public void setCOMP_COMP_CODE_LABEL(HtmlOutputLabel cOMP_COMP_CODE_LABEL) {
		COMP_COMP_CODE_LABEL = cOMP_COMP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CODE_INPUT() {
		return COMP_CODE_INPUT;
	}

	public void setCOMP_CODE_INPUT(HtmlInputText cOMP_CODE_INPUT) {
		COMP_CODE_INPUT = cOMP_CODE_INPUT;
	}

	public PM010_A_COMPANY getPM010_A_COMPANY_BEAN() {
		return PM010_A_COMPANY_BEAN;
	}

	public void setPM010_A_COMPANY_BEAN(PM010_A_COMPANY pM010_A_COMPANY_BEAN) {
		PM010_A_COMPANY_BEAN = pM010_A_COMPANY_BEAN;
	}

	public HtmlOutputLabel getCOMP_COMP_NAME_LABEL() {
		return COMP_COMP_NAME_LABEL;
	}

	public void setCOMP_COMP_NAME_LABEL(HtmlOutputLabel cOMP_COMP_NAME_LABEL) {
		COMP_COMP_NAME_LABEL = cOMP_COMP_NAME_LABEL;
	}

	public HtmlInputText getCOMP_NAME_INPUT() {
		return COMP_NAME_INPUT;
	}

	public void setCOMP_NAME_INPUT(HtmlInputText cOMP_NAME_INPUT) {
		COMP_NAME_INPUT = cOMP_NAME_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_DESC_LABEL() {
		return COMP_COMP_DESC_LABEL;
	}

	public void setCOMP_COMP_DESC_LABEL(HtmlOutputLabel cOMP_COMP_DESC_LABEL) {
		COMP_COMP_DESC_LABEL = cOMP_COMP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DESC_INPUT() {
		return COMP_DESC_INPUT;
	}

	public void setCOMP_DESC_INPUT(HtmlInputText cOMP_DESC_INPUT) {
		COMP_DESC_INPUT = cOMP_DESC_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_ADDR1_LABEL() {
		return COMP_COMP_ADDR1_LABEL;
	}

	public void setCOMP_COMP_ADDR1_LABEL(HtmlOutputLabel cOMP_COMP_ADDR1_LABEL) {
		COMP_COMP_ADDR1_LABEL = cOMP_COMP_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_ADDR1_INPUT() {
		return COMP_ADDR1_INPUT;
	}

	public void setCOMP_ADDR1_INPUT(HtmlInputText cOMP_ADDR1_INPUT) {
		COMP_ADDR1_INPUT = cOMP_ADDR1_INPUT;
	}

	public HtmlInputText getCOMP_ADDR2_INPUT() {
		return COMP_ADDR2_INPUT;
	}

	public void setCOMP_ADDR2_INPUT(HtmlInputText cOMP_ADDR2_INPUT) {
		COMP_ADDR2_INPUT = cOMP_ADDR2_INPUT;
	}

	public HtmlInputText getCOMP_ADDR3_INPUT() {
		return COMP_ADDR3_INPUT;
	}

	public void setCOMP_ADDR3_INPUT(HtmlInputText cOMP_ADDR3_INPUT) {
		COMP_ADDR3_INPUT = cOMP_ADDR3_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_DEFAULT_BRANCH_LABEL() {
		return COMP_COMP_DEFAULT_BRANCH_LABEL;
	}

	public void setCOMP_COMP_DEFAULT_BRANCH_LABEL(
			HtmlOutputLabel cOMP_COMP_DEFAULT_BRANCH_LABEL) {
		COMP_COMP_DEFAULT_BRANCH_LABEL = cOMP_COMP_DEFAULT_BRANCH_LABEL;
	}

	public HtmlInputText getCOMP_DEFAULT_BRANCH_CODE_INPUT() {
		return COMP_DEFAULT_BRANCH_CODE_INPUT;
	}

	public void setCOMP_DEFAULT_BRANCH_CODE_INPUT(
			HtmlInputText cOMP_DEFAULT_BRANCH_CODE_INPUT) {
		COMP_DEFAULT_BRANCH_CODE_INPUT = cOMP_DEFAULT_BRANCH_CODE_INPUT;
	}

	public HtmlInputText getCOMP_DEFAULT_BRANCH_NAME_INPUT() {
		return COMP_DEFAULT_BRANCH_NAME_INPUT;
	}

	public void setCOMP_DEFAULT_BRANCH_NAME_INPUT(
			HtmlInputText cOMP_DEFAULT_BRANCH_NAME_INPUT) {
		COMP_DEFAULT_BRANCH_NAME_INPUT = cOMP_DEFAULT_BRANCH_NAME_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_DEFAULT_DEPT_LABEL() {
		return COMP_COMP_DEFAULT_DEPT_LABEL;
	}

	public void setCOMP_COMP_DEFAULT_DEPT_LABEL(
			HtmlOutputLabel cOMP_COMP_DEFAULT_DEPT_LABEL) {
		COMP_COMP_DEFAULT_DEPT_LABEL = cOMP_COMP_DEFAULT_DEPT_LABEL;
	}

	public HtmlInputText getCOMP_DEFAULT_DEPT_CODE_INPUT() {
		return COMP_DEFAULT_DEPT_CODE_INPUT;
	}

	public void setCOMP_DEFAULT_DEPT_CODE_INPUT(
			HtmlInputText cOMP_DEFAULT_DEPT_CODE_INPUT) {
		COMP_DEFAULT_DEPT_CODE_INPUT = cOMP_DEFAULT_DEPT_CODE_INPUT;
	}

	public HtmlInputText getCOMP_DEFAULT_DEPT_NAME() {
		return COMP_DEFAULT_DEPT_NAME;
	}

	public void setCOMP_DEFAULT_DEPT_NAME(HtmlInputText cOMP_DEFAULT_DEPT_NAME) {
		COMP_DEFAULT_DEPT_NAME = cOMP_DEFAULT_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_COMP_CEO_NAME_LABEL() {
		return COMP_COMP_CEO_NAME_LABEL;
	}

	public void setCOMP_COMP_CEO_NAME_LABEL(HtmlOutputLabel cOMP_COMP_CEO_NAME_LABEL) {
		COMP_COMP_CEO_NAME_LABEL = cOMP_COMP_CEO_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CEO_NAME_INPUT() {
		return COMP_CEO_NAME_INPUT;
	}

	public void setCOMP_CEO_NAME_INPUT(HtmlInputText cOMP_CEO_NAME_INPUT) {
		COMP_CEO_NAME_INPUT = cOMP_CEO_NAME_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_PHONE_LABEL() {
		return COMP_COMP_PHONE_LABEL;
	}

	public void setCOMP_COMP_PHONE_LABEL(HtmlOutputLabel cOMP_COMP_PHONE_LABEL) {
		COMP_COMP_PHONE_LABEL = cOMP_COMP_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_PHONE_INPUT() {
		return COMP_PHONE_INPUT;
	}

	public void setCOMP_PHONE_INPUT(HtmlInputText cOMP_PHONE_INPUT) {
		COMP_PHONE_INPUT = cOMP_PHONE_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_FAX_LABEL() {
		return COMP_COMP_FAX_LABEL;
	}

	public void setCOMP_COMP_FAX_LABEL(HtmlOutputLabel cOMP_COMP_FAX_LABEL) {
		COMP_COMP_FAX_LABEL = cOMP_COMP_FAX_LABEL;
	}

	public HtmlInputText getCOMP_FAX_INPUT() {
		return COMP_FAX_INPUT;
	}

	public void setCOMP_FAX_INPUT(HtmlInputText cOMP_FAX_INPUT) {
		COMP_FAX_INPUT = cOMP_FAX_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_EMAIL_LABEL() {
		return COMP_COMP_EMAIL_LABEL;
	}

	public void setCOMP_COMP_EMAIL_LABEL(HtmlOutputLabel cOMP_COMP_EMAIL_LABEL) {
		COMP_COMP_EMAIL_LABEL = cOMP_COMP_EMAIL_LABEL;
	}

	public HtmlInputText getCOMP_EMAIL_INPUT() {
		return COMP_EMAIL_INPUT;
	}

	public void setCOMP_EMAIL_INPUT(HtmlInputText cOMP_EMAIL_INPUT) {
		COMP_EMAIL_INPUT = cOMP_EMAIL_INPUT;
	}

	public HtmlOutputLabel getCOMP_COMP_WEBSITE_LABEL() {
		return COMP_COMP_WEBSITE_LABEL;
	}

	public void setCOMP_COMP_WEBSITE_LABEL(HtmlOutputLabel cOMP_COMP_WEBSITE_LABEL) {
		COMP_COMP_WEBSITE_LABEL = cOMP_COMP_WEBSITE_LABEL;
	}

	public HtmlInputText getCOMP_WEBSITE_INPUT() {
		return COMP_WEBSITE_INPUT;
	}

	public void setCOMP_WEBSITE_INPUT(HtmlInputText cOMP_WEBSITE_INPUT) {
		COMP_WEBSITE_INPUT = cOMP_WEBSITE_INPUT;
	}
	
	public HtmlSelectBooleanCheckbox getCOMP_FRZ_YN() {
		return COMP_FRZ_YN;
	}

	public void setCOMP_FRZ_YN(HtmlSelectBooleanCheckbox cOMP_FRZ_YN) {
		COMP_FRZ_YN = cOMP_FRZ_YN;
	}
	
	public PM_DIVISION getPM_DIVISION_BEAN() {
		return PM_DIVISION_BEAN;
	}

	public void setPM_DIVISION_BEAN(PM_DIVISION pM_DIVISION_BEAN) {
		PM_DIVISION_BEAN = pM_DIVISION_BEAN;
	}
	
	public HtmlOutputLabel getCOMP_FRZ_FLAG_LABEL() {
		return COMP_FRZ_FLAG_LABEL;
	}
	public void setCOMP_FRZ_FLAG_LABEL(HtmlOutputLabel cOMP_FRZ_FLAG_LABEL) {
		COMP_FRZ_FLAG_LABEL = cOMP_FRZ_FLAG_LABEL;
	}
	public void onLoad(PhaseEvent event) {
		System.out.println("onload");
		try {
			System.out.println("isBlockFlag() =========>> ========>>>"+isBlockFlag());
			if (isBlockFlag()) {
				System.out.println("inside if flag");
				helper.executeQuery(compositeAction);
				if(compositeAction.getPM010_A_COMPANY_MASTER_ACTION_BEAN().getPM010_A_COMPANY_BEAN().isFRZ_FLAG())
					COMP_FRZ_YN.setSelected(true);
				else
					COMP_FRZ_YN.setSelected(false);
				
				
				
				/*Added by Janani for factory testing feedback changes on 12.04.2017*/
				
				getNationalityDesc();
				
								
				CommonUtils.setGlobalVariable("GLOBAL.M_DEF_NATION_ID",PM010_A_COMPANY_BEAN.getCOMP_DEF_NATION());
				System.out.println("GLOBAL.M_DEF_NATION_ID         :"+CommonUtils.getGlobalVariable("GLOBAL.M_DEF_NATION_ID"));
				
				
				/*ENd*/
				

				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public String saveAction() {
	String message = null;
		CRUDHandler handler = new CRUDHandler();
		System.out.println("demooo 123");
		try {
			System.out.println("ROW --------====ID"+this.PM010_A_COMPANY_BEAN.getROWID());
			if (this.PM010_A_COMPANY_BEAN.getROWID() == null && this.isINSERT_ALLOWED() == true) {
				System.out.println("save if");
				System.out.println(getPM010_A_COMPANY_BEAN().getCOMP_CODE());
				compositeAction.getPM010_A_COMPANY_MASTER_ACTION_BEAN().getPM010_A_COMPANY_BEAN().getROWID();
				/*if(getPM010_A_COMPANY_BEAN().isFRZ_FLAG()){
					System.out.println("1 IF FLAG"+getPM010_A_COMPANY_BEAN().isFRZ_FLAG());
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("Y");
				}
				else{
					System.out.println("1 ELSE FLAG"+getPM010_A_COMPANY_BEAN().isFRZ_FLAG());
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("N");
				}*/
				System.out.println(getPM010_A_COMPANY_BEAN().isFRZ_FLAG());
				if(getPM010_A_COMPANY_BEAN().isFRZ_FLAG())
				{
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("Y");
				}
				else
				{
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("N");
				}
				getPM010_A_COMPANY_BEAN().setCOMP_CR_DT(new CommonUtils().getCurrentDate());
				handler.executeInsert(getPM010_A_COMPANY_BEAN(), CommonUtils.getConnection());
				//handler.executeUpdate(getPM010_A_COMPANY_BEAN(), CommonUtils.getConnection());
				CommonUtils.doComitt();
			} else {
				System.out.println("save else");
				System.out.println(getPM010_A_COMPANY_BEAN().getCOMP_CODE());
				/*if(getPM010_A_COMPANY_BEAN().isFRZ_FLAG()){
					System.out.println("IF FLAG"+getPM010_A_COMPANY_BEAN().isFRZ_FLAG());
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("Y");
				}
				else{
					System.out.println("ELSE FLAG"+getPM010_A_COMPANY_BEAN().isFRZ_FLAG());
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("N");
				}*/
				if(getPM010_A_COMPANY_BEAN().isFRZ_FLAG())
				{
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("Y");
				}
				else
				{
					getPM010_A_COMPANY_BEAN().setCOMP_FRZ_FLAG("N");
				}
				handler.executeUpdate(getPM010_A_COMPANY_BEAN(), CommonUtils.getConnection());
				CommonUtils.doComitt();
			}
			
			CommonUtils.setGlobalVariable("GLOBAL.M_NATIONLITY_CODE",getPM010_A_COMPANY_BEAN().getCOMP_DEF_NATION());
			
			message = Messages.getString("messageProperties",
					"errorPanel$message$save");	
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		}catch (Exception e) {
			e.printStackTrace();
			/*Added by ganesh on 06-09-2017 to display error msg */
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE_RECORD", e.getMessage());
			/*end*/
		}

		return "";
	}

public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
}

PM010_A_COMPOSITE_ACTION PM010_A_COMPOSITE_ACTION_BEAN;
//PM_DIVISION PM_DIVISION_BEAN = new PM_DIVISION();

public List suggestionActionCityCode(Object event) {
	System.out.println("inside sugg 1111");
	String divCode = (String) event;
	System.out.println("ffffffffffffffffff"+divCode);
	Connection connection = null;
	
	try {
		connection = CommonUtils.getConnection();
		//PM010_A_COMPOSITE_ACTION_BEAN=new PM010_A_COMPOSITE_ACTION();
		divisionList =new PM010_A_COMPOSITE_ACTION()
				.prepareDivisionList(connection, divCode, divisionList);
				setSubmitValue(divisionList);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return divisionList;
}

public void getDivnName(ActionEvent event) {
	// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(null);
	// COMP_CONT_CITY_CODE.setSubmittedValue(null);
	System.out.println("divn_name");
	
	//COMP_DEFAULT_BRANCH_CODE_INPUT.setSubmittedValue(PM010_A_COMPANY_BEAN.getCOMP_DFLT_DIVN());
	
	/*UIInput input = (UIInput) event.getComponent().getParent();
	System.out.println(input);
	System.out.println( (String)input.getSubmittedValue());*/
	
	
	
	/*UISuggestionBox input = (UISuggestionBox) event.getComponent().getParent();
	System.out.println(input.getSubmitedValue());
	String divnName=(String) input.getSubmitedValue();
	System.out.println("divnName  ---     "+divnName);*/
			
	System.out.println("COMP_DEFAULT_BRANCH_CODE_INPUT.getSubmittedValue() ------------------>>>>>>>>"+COMP_DEFAULT_BRANCH_CODE_INPUT.getSubmittedValue());
	if (COMP_DEFAULT_BRANCH_CODE_INPUT.getSubmittedValue()!=null) {
		String divnCode = (String) COMP_DEFAULT_BRANCH_CODE_INPUT.getSubmittedValue();
		System.out.println("city Code ::" + divnCode);
		String divnDesc = new PM010_A_COMPOSITE_ACTION().getCityDescforCode(divnCode, divisionList);
		System.out.println("divnDesc ------------------>>>>> DESC :" + divnDesc);
		// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(stateDesc);
		// COMP_UI_M_BUT_CITY_CODE
		COMP_DEFAULT_BRANCH_NAME_INPUT.setSubmittedValue(divnDesc);
		System.out.println(COMP_DEFAULT_BRANCH_NAME_INPUT.getSubmittedValue());
		COMP_DEFAULT_BRANCH_NAME_INPUT.setDisabled(false);
		//PM010_A_COMPANY_BEAN.setCOMP_DFLT_DIVN_NAME(divnDesc);
		PM010_A_COMPANY_BEAN.setCOMP_DFLT_DIVN_NAME(divnDesc);
		System.out.println(PM010_A_COMPANY_BEAN.getCOMP_DFLT_DIVN_NAME());
		System.out.println("divn name end");
	}
}

// DEFAULT DEPARTMENT PART -- PM_DEPARTMENT

public List suggestionDeptCode(Object event) {
	System.out.println("inside DeptCode");
	String DeptCode = (String) event;
	System.out.println("DeptCode eeeeeeeeeeeeeeeeee :"+DeptCode);
	Connection connection = null;
	try {
		connection = CommonUtils.getConnection();
		departmentList =new PM010_A_COMPOSITE_ACTION()
				.prepareDepartmentList(connection, DeptCode, departmentList);
				setDeptSubmitValue(departmentList);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return departmentList;
}

public void getDeptName(ActionEvent event) {
	System.out.println("DeptName");
	System.out.println("COMP_DEFAULT_DEPT_CODE_INPUT.getSubmittedValue() ------------------>>>>>>>>"+COMP_DEFAULT_DEPT_CODE_INPUT.getSubmittedValue());
	if (COMP_DEFAULT_DEPT_CODE_INPUT.getSubmittedValue()!=null) {
		String DeptCode = (String) COMP_DEFAULT_DEPT_CODE_INPUT.getSubmittedValue();
		System.out.println("DEPT Code ::" + DeptCode);
		String deptDesc = new PM010_A_COMPOSITE_ACTION().getDeptName(DeptCode, departmentList);
		System.out.println("deptDesc ------------------>>>>> DESC :" + deptDesc);
		COMP_DEFAULT_DEPT_NAME.setSubmittedValue(deptDesc);
		System.out.println(COMP_DEFAULT_DEPT_NAME.getSubmittedValue());
		PM010_A_COMPANY_BEAN.setCOMP_DFLT_DEPT_NAME(deptDesc);
		System.out.println(PM010_A_COMPANY_BEAN.getCOMP_DFLT_DEPT_NAME());
		System.out.println("divn name end");
	}
}

public String delAction() {
	String message = null;
		CRUDHandler handler = new CRUDHandler();
		System.out.println("delete 123");
		try {
			System.out.println("inside try");
			PM010_A_COMPANY_MASTER_DELEGATE_BEAN.preDelete(compositeAction, PM010_A_COMPANY_BEAN);
			message = Messages.getString("messageProperties",
					"errorPanel$message$delete");	
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}



/*Added by Janani for factory testing feedback changes on 12.04.2017*/

private HtmlOutputLabel COMP_DEF_NATION_LABEL;
private HtmlInputText COMP_DEF_NATION;
private HtmlInputText COMP_UI_M_COMP_DEF_NATION_DESC;


public HtmlOutputLabel getCOMP_DEF_NATION_LABEL() {
	return COMP_DEF_NATION_LABEL;
}
public void setCOMP_DEF_NATION_LABEL(HtmlOutputLabel cOMP_DEF_NATION_LABEL) {
	COMP_DEF_NATION_LABEL = cOMP_DEF_NATION_LABEL;
}
public HtmlInputText getCOMP_DEF_NATION() {
	return COMP_DEF_NATION;
}
public void setCOMP_DEF_NATION(HtmlInputText cOMP_DEF_NATION) {
	COMP_DEF_NATION = cOMP_DEF_NATION;
}

public HtmlInputText getCOMP_UI_M_COMP_DEF_NATION_DESC() {
	return COMP_UI_M_COMP_DEF_NATION_DESC;
}
public void setCOMP_UI_M_COMP_DEF_NATION_DESC(
		HtmlInputText cOMP_UI_M_COMP_DEF_NATION_DESC) {
	COMP_UI_M_COMP_DEF_NATION_DESC = cOMP_UI_M_COMP_DEF_NATION_DESC;
}


public void validatorCOMP_DEF_NATION(FacesContext context,
		UIComponent component, Object value) {
	try {
		PM010_A_COMPANY_BEAN.setCOMP_DEF_NATION((String) value);
		 	
		
		
		
		COMP_DEF_NATION.resetValue();
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}


public ArrayList<LovBean> lovCOMP_DEF_NATION(Object object) {
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



private void getNationalityDesc() throws Exception {
	
	System.out.println("enters into getNationalityDesc");
	
	
	
	String query = null;

	
	query = "select PC_CODE,PC_DESC from PM_CODES WHERE PC_TYPE = 'NATLITY' and PC_CODE=?";
	
	
	Connection con = null;
	CRUDHandler handler = new CRUDHandler();
	ResultSet rs = null;
	String idCode = null;
	String idDesc = null;

	try {
		con = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, con,
				new Object[] {PM010_A_COMPANY_BEAN.getCOMP_DEF_NATION()});
		if (rs.next()) {
			
					
			idDesc = rs.getString("PC_DESC");
			PM010_A_COMPANY_BEAN.setUI_M_COMP_DEF_NATION_DESC(idDesc);
			
			CommonUtils.setGlobalVariable("GLOBAL.M_DEF_NATION_ID_DESC",PM010_A_COMPANY_BEAN.getUI_M_COMP_DEF_NATION_DESC());
			
			System.out.println("GLOBAL.M_DEF_NATION_ID_DESC         :"+CommonUtils.getGlobalVariable("GLOBAL.M_DEF_NATION_ID_DESC"));
			
			
			System.out.println("idDesc             :"+idDesc+"    getUI_M_COMP_DEF_NATION_DESC           "+PM010_A_COMPANY_BEAN.getUI_M_COMP_DEF_NATION_DESC());
			
			
		} 

	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}

	
}

/*End*/

/*Added by ganesh on 06-09-2017 for short desc max lenght validation */
public void validatorSHORT_DESC_IP(FacesContext facesContext,
		UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		String currentValue =  (String) value;
		int maxFieldValue = fieldMaxLength("PM_COMPANY","COMP_SHORT_NAME");
		if(currentValue != null && (currentValue.length() > maxFieldValue)){
			throw new Exception("Value should not exceeds "+maxFieldValue+" characters");
		}
		PM010_A_COMPANY_BEAN.setCOMP_SHORT_NAME((String) value);
		
		
	} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
				.getMessage()));
	} finally {
		try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), "SHORT_DESC_IP",
					getWarningMap());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


	public int fieldMaxLength(String tableName, String columnName){
		Connection connection = null;
		int columnLength = 0;
		ResultSet rs = null;
		try {
			connection  = CommonUtils.getConnection();
			String query = "SELECT WIDTH FROM COL WHERE TNAME = ? AND CNAME = ?";
			rs = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{tableName, columnName});
			if(rs.next()){
				columnLength = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return columnLength;
	}
	
/*end*/
}

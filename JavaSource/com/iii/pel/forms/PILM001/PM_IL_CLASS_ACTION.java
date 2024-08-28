package com.iii.pel.forms.PILM001;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLASS_ACTION extends CommonAction 
{

	private HtmlOutputLabel COMP_CLASS_BL_NAME_LABEL;

	private HtmlInputText COMP_CLASS_BL_NAME;

	private HtmlOutputLabel COMP_CLASS_BL_SHORT_NAME_LABEL;

	private HtmlInputText COMP_CLASS_BL_SHORT_NAME;

	private HtmlOutputLabel COMP_CLASS_CODE_LABEL;

	private HtmlInputText COMP_CLASS_CODE;

	private HtmlOutputLabel COMP_CLASS_NAME_LABEL;

	private HtmlInputText COMP_CLASS_NAME;

	private HtmlOutputLabel COMP_CLASS_SHORT_NAME_LABEL;

	private HtmlInputText COMP_CLASS_SHORT_NAME;

	private HtmlOutputLabel COMP_CLASS_FACIN_YN_LABEL;

	//private HtmlComboBox COMP_CLASS_FACIN_YN;

	private HtmlOutputLabel COMP_CLASS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CLASS_FRZ_FLAG;

	private HtmlCommandButton COMP_UI_M_BUT_BL;
	
	private HtmlSelectOneMenu COMP_CLASS_FACIN_YN;

	private PM_IL_CLASS PM_IL_CLASS_BEAN;
	
	private HtmlOutputText COMP_ERROR_MESSAGE;
	
	private List<SelectItem> CLASS_FACIN_YN_LIST;
	
	private boolean update = false;
	

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public PM_IL_CLASS_ACTION() {
		
		PM_IL_CLASS_BEAN = new PM_IL_CLASS();
		CLASS_FACIN_YN_LIST=new PILM001_CRUD().comboValues("PILM001","PM_IL_CLASS","PM_IL_CLASS.CLASS_FACIN_YN","YESNO");
	}

	public HtmlOutputLabel getCOMP_CLASS_BL_NAME_LABEL() {
		return COMP_CLASS_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_BL_NAME() {
		return COMP_CLASS_BL_NAME;
	}

	public void setCOMP_CLASS_BL_NAME_LABEL(HtmlOutputLabel COMP_CLASS_BL_NAME_LABEL) {
		this.COMP_CLASS_BL_NAME_LABEL = COMP_CLASS_BL_NAME_LABEL;
	}

	public void setCOMP_CLASS_BL_NAME(HtmlInputText COMP_CLASS_BL_NAME) {
		this.COMP_CLASS_BL_NAME = COMP_CLASS_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_CLASS_BL_SHORT_NAME_LABEL() {
		return COMP_CLASS_BL_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_BL_SHORT_NAME() {
		return COMP_CLASS_BL_SHORT_NAME;
	}

	public void setCOMP_CLASS_BL_SHORT_NAME_LABEL(HtmlOutputLabel COMP_CLASS_BL_SHORT_NAME_LABEL) {
		this.COMP_CLASS_BL_SHORT_NAME_LABEL = COMP_CLASS_BL_SHORT_NAME_LABEL;
	}

	public void setCOMP_CLASS_BL_SHORT_NAME(HtmlInputText COMP_CLASS_BL_SHORT_NAME) {
		this.COMP_CLASS_BL_SHORT_NAME = COMP_CLASS_BL_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_CLASS_CODE_LABEL() {
		return COMP_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_CODE() {
		return COMP_CLASS_CODE;
	}

	public void setCOMP_CLASS_CODE_LABEL(HtmlOutputLabel COMP_CLASS_CODE_LABEL) {
		this.COMP_CLASS_CODE_LABEL = COMP_CLASS_CODE_LABEL;
	}

	public void setCOMP_CLASS_CODE(HtmlInputText COMP_CLASS_CODE) {
		this.COMP_CLASS_CODE = COMP_CLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_CLASS_NAME_LABEL() {
		return COMP_CLASS_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_NAME() {
		return COMP_CLASS_NAME;
	}

	public void setCOMP_CLASS_NAME_LABEL(HtmlOutputLabel COMP_CLASS_NAME_LABEL) {
		this.COMP_CLASS_NAME_LABEL = COMP_CLASS_NAME_LABEL;
	}

	public void setCOMP_CLASS_NAME(HtmlInputText COMP_CLASS_NAME) {
		this.COMP_CLASS_NAME = COMP_CLASS_NAME;
	}

	public HtmlOutputLabel getCOMP_CLASS_SHORT_NAME_LABEL() {
		return COMP_CLASS_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_SHORT_NAME() {
		return COMP_CLASS_SHORT_NAME;
	}

	public void setCOMP_CLASS_SHORT_NAME_LABEL(HtmlOutputLabel COMP_CLASS_SHORT_NAME_LABEL) {
		this.COMP_CLASS_SHORT_NAME_LABEL = COMP_CLASS_SHORT_NAME_LABEL;
	}

	public void setCOMP_CLASS_SHORT_NAME(HtmlInputText COMP_CLASS_SHORT_NAME) {
		this.COMP_CLASS_SHORT_NAME = COMP_CLASS_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_CLASS_FACIN_YN_LABEL() {
		return COMP_CLASS_FACIN_YN_LABEL;
	}

	public void setCOMP_CLASS_FACIN_YN_LABEL(HtmlOutputLabel COMP_CLASS_FACIN_YN_LABEL) {
		this.COMP_CLASS_FACIN_YN_LABEL = COMP_CLASS_FACIN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_CLASS_FRZ_FLAG_LABEL() {
		return COMP_CLASS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CLASS_FRZ_FLAG() {
		return COMP_CLASS_FRZ_FLAG;
	}

	public void setCOMP_CLASS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_CLASS_FRZ_FLAG_LABEL) {
		this.COMP_CLASS_FRZ_FLAG_LABEL = COMP_CLASS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CLASS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CLASS_FRZ_FLAG) {
		this.COMP_CLASS_FRZ_FLAG = COMP_CLASS_FRZ_FLAG;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BL() {
		return COMP_UI_M_BUT_BL;
	}

	public void setCOMP_UI_M_BUT_BL(HtmlCommandButton COMP_UI_M_BUT_BL) {
		this.COMP_UI_M_BUT_BL = COMP_UI_M_BUT_BL;
	}

	public PM_IL_CLASS getPM_IL_CLASS_BEAN() {
		return PM_IL_CLASS_BEAN;
	}

	public void setPM_IL_CLASS_BEAN(PM_IL_CLASS PM_IL_CLASS_BEAN) {
		this.PM_IL_CLASS_BEAN = PM_IL_CLASS_BEAN;
	}
	public void insertObject(ActionEvent ae)
	{
		if(PM_IL_CLASS_BEAN.isInsertMode())
		{
		System.out.println("In The Insert Mode");
		
		if(PM_IL_CLASS_BEAN.isRendered())
		{
			PM_IL_CLASS_BEAN.setCLASS_FRZ_FLAG("Y");
		}
		else
		{
			PM_IL_CLASS_BEAN.setCLASS_FRZ_FLAG("N");
		}
		if("YES".equalsIgnoreCase(PM_IL_CLASS_BEAN.getCLASS_FACIN_YN()))
		{
			PM_IL_CLASS_BEAN.setCLASS_FACIN_YN("Y");
		}
		else
		{
			PM_IL_CLASS_BEAN.setCLASS_FACIN_YN("N");
		}
		//PM_IL_CLASS_BEAN.setCLASS_CR_DT("02-Nov-08");
		PM_IL_CLASS_BEAN.setCLASS_CR_UID("LIFE");
		int result=new PILM001_CRUD().executeInsert(PM_IL_CLASS_BEAN);
		if(result>0)
		{
			getWarningMap().put("current","Record Inserted");
		}
		}
		else if(!PM_IL_CLASS_BEAN.isInsertMode())
		{
			int result=new PILM001_CRUD().executeUpdate(PM_IL_CLASS_BEAN);
			if(result>0)
			{
				getWarningMap().put("current","Record Updated");
			}
		}
	
	}
	
	public void saveRecord() {
		String message = "";
		try {
			if (PM_IL_CLASS_BEAN.getROWID() != null) {
				PM_IL_CLASS_BEAN.setCLASS_CR_UID(CommonUtils.getControlBean().getUSER_ID());
				PM_IL_CLASS_BEAN.setCLASS_CR_DT(new CommonUtils().getCurrentDate());
				new CRUDHandler().executeUpdate(PM_IL_CLASS_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"update",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				
			} else {
				PM_IL_CLASS_BEAN.setCLASS_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
				PM_IL_CLASS_BEAN.setCLASS_UPD_DT(new CommonUtils().getCurrentDate());
				new CRUDHandler().executeInsert(PM_IL_CLASS_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	
	public void shortName(ActionEvent e)
	{
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent(); 
		ErrorHelp.validate(input, input.getId(), getErrorMap());
	}
	
	public void validateCLASS_NAME(FacesContext fc, UIComponent component, Object value)
	throws ValidatorException 
	{
		String comboValue=(String)COMP_CLASS_FACIN_YN.getSubmittedValue();
		getPM_IL_CLASS_BEAN().setCLASS_FACIN_YN(comboValue);
		COMP_CLASS_FACIN_YN.setSubmittedValue(comboValue);
		
			String shortName = (String)value;
			
			if(shortName.trim().length()>15)
			{
				shortName=shortName.substring(0,15);
			}
			getPM_IL_CLASS_BEAN().setCLASS_SHORT_NAME(shortName);
			COMP_CLASS_SHORT_NAME.setSubmittedValue(null);
			
	}
	public void prepareClassName(ActionEvent event)
	{
		System.out.println("PM_IL_CLASS_ACTION.prepareClassName()");
		//UIInput input=(UIInput)event.getComponent().getParent();
		
		String className=(String)COMP_CLASS_BL_NAME.getSubmittedValue();
		
		getPM_IL_CLASS_BEAN().setCLASS_BL_NAME(className);	
		if(className!=null&&className.trim().length()>0)
		{
		if(className.trim().length()>15)
		{
			className=className.substring(0,15);
		}
		}
		getPM_IL_CLASS_BEAN().setCLASS_BL_SHORT_NAME(className);
		COMP_CLASS_BL_SHORT_NAME.setSubmittedValue(null);
	}
	public void validateNullValues(ActionEvent ae)
	{
		UIInput input = (UIInput) ae.getComponent() // Ajax4jsf comp
				.getParent(); 
		ErrorHelp.validate(input, input.getId(), getErrorMap());
	}

	public HtmlOutputText getCOMP_ERROR_MESSAGE() {
		return COMP_ERROR_MESSAGE;
	}
	public void setCOMP_ERROR_MESSAGE(HtmlOutputText comp_error_message) {
		COMP_ERROR_MESSAGE = comp_error_message;
	}

	
	public void setBeanValue()
	{
		PM_IL_CLASS_BEAN.setCLASS_CODE("");
		PM_IL_CLASS_BEAN.setCLASS_NAME("");
		PM_IL_CLASS_BEAN.setCLASS_SHORT_NAME("");
		PM_IL_CLASS_BEAN.setCLASS_FACIN_YN("");
		PM_IL_CLASS_BEAN.setCLASS_CR_UID("");
		//PM_IL_CLASS_BEAN.setCLASS_CR_DT("");
	}
	public void setComponentValue()
	{
		COMP_CLASS_CODE.setSubmittedValue(null);
		COMP_CLASS_NAME.setSubmittedValue(null);
		COMP_CLASS_SHORT_NAME.setSubmittedValue(null);
		COMP_CLASS_FACIN_YN.setSubmittedValue(null);
	}
	public void classCodeValidator(FacesContext context,UIComponent component,Object obj)
	{
		String value =(String)obj;
		if(!(value.equals(PM_IL_CLASS_BEAN.getCLASS_CODE()))){
			if(new PILM001_CRUD().validateClassCode((String)obj))
			{
				FacesMessage message=new FacesMessage("Class Code Already Exists!");
				throw new ValidatorException(message);
			}else{
				PM_IL_CLASS_BEAN.setCLASS_CODE(value);
			}	
		}else{
			PM_IL_CLASS_BEAN.setCLASS_CODE(value);
		}
	}
	
	public void beforePhase(PhaseEvent event){
		PM_IL_CLASS_ACTION actionBean = (PM_IL_CLASS_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CLASS_ACTION");		
		try {
			if(isBlockFlag()){
				if(actionBean.getPM_IL_CLASS_BEAN().getROWID() != null){
					executeSelectStatement(actionBean);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	public void executeSelectStatement(PM_IL_CLASS_ACTION actionBean) throws Exception{
		String selectQuery = "Select ROWID, PM_IL_CLASS.* from PM_IL_CLASS where ROWID='"+actionBean.getPM_IL_CLASS_BEAN().getROWID()+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_CLASS> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM001.PM_IL_CLASS", 
					con);
			actionBean.setPM_IL_CLASS_BEAN(list.get(0));
			actionBean.setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateFRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_IL_CLASS_BEAN.setCLASS_FRZ_FLAG("Y");
			} else {
				PM_IL_CLASS_BEAN.setCLASS_FRZ_FLAG("N");	
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public String backAction(){
		return "PILM001";
	}

	public HtmlSelectOneMenu getCOMP_CLASS_FACIN_YN() {
		return COMP_CLASS_FACIN_YN;
	}

	public void setCOMP_CLASS_FACIN_YN(HtmlSelectOneMenu comp_class_facin_yn) {
		COMP_CLASS_FACIN_YN = comp_class_facin_yn;
	}

	public List<SelectItem> getCLASS_FACIN_YN_LIST() {
		return CLASS_FACIN_YN_LIST;
	}

	public void setCLASS_FACIN_YN_LIST(List<SelectItem> class_facin_yn_list) {
		CLASS_FACIN_YN_LIST = class_facin_yn_list;
	}
	
	

	
}

package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
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

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class CTRL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_CP_TREATY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CP_TREATY_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_TREATY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CP_TREATY_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_UW_YEAR_LABEL;

	private HtmlInputText COMP_UI_M_CP_UW_YEAR;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_TREATY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_TREATY_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_UW_YEAR_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_UW_YEAR;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CP_TREATY;

	private CTRL_1 CTRL_1_BEAN;
	
	private List treatyCodeList;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	public CTRL_1_ACTION() {
		CTRL_1_BEAN = new CTRL_1();
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_TREATY_CODE_LABEL() {
		return COMP_UI_M_CP_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_TREATY_CODE() {
		return COMP_UI_M_CP_TREATY_CODE;
	}

	public void setCOMP_UI_M_CP_TREATY_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CP_TREATY_CODE_LABEL) {
		this.COMP_UI_M_CP_TREATY_CODE_LABEL = COMP_UI_M_CP_TREATY_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_TREATY_CODE(HtmlInputText COMP_UI_M_CP_TREATY_CODE) {
		this.COMP_UI_M_CP_TREATY_CODE = COMP_UI_M_CP_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_TREATY_DESC_LABEL() {
		return COMP_UI_M_CP_TREATY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_TREATY_DESC() {
		return COMP_UI_M_CP_TREATY_DESC;
	}

	public void setCOMP_UI_M_CP_TREATY_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CP_TREATY_DESC_LABEL) {
		this.COMP_UI_M_CP_TREATY_DESC_LABEL = COMP_UI_M_CP_TREATY_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_TREATY_DESC(HtmlInputText COMP_UI_M_CP_TREATY_DESC) {
		this.COMP_UI_M_CP_TREATY_DESC = COMP_UI_M_CP_TREATY_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_UW_YEAR_LABEL() {
		return COMP_UI_M_CP_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_UW_YEAR() {
		return COMP_UI_M_CP_UW_YEAR;
	}

	public void setCOMP_UI_M_CP_UW_YEAR_LABEL(HtmlOutputLabel COMP_UI_M_CP_UW_YEAR_LABEL) {
		this.COMP_UI_M_CP_UW_YEAR_LABEL = COMP_UI_M_CP_UW_YEAR_LABEL;
	}

	public void setCOMP_UI_M_CP_UW_YEAR(HtmlInputText COMP_UI_M_CP_UW_YEAR) {
		this.COMP_UI_M_CP_UW_YEAR = COMP_UI_M_CP_UW_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_TREATY_CODE_LABEL() {
		return COMP_UI_M_CP_DEST_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_TREATY_CODE() {
		return COMP_UI_M_CP_DEST_TREATY_CODE;
	}

	public void setCOMP_UI_M_CP_DEST_TREATY_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_TREATY_CODE_LABEL) {
		this.COMP_UI_M_CP_DEST_TREATY_CODE_LABEL = COMP_UI_M_CP_DEST_TREATY_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_TREATY_CODE(HtmlInputText COMP_UI_M_CP_DEST_TREATY_CODE) {
		this.COMP_UI_M_CP_DEST_TREATY_CODE = COMP_UI_M_CP_DEST_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_UW_YEAR_LABEL() {
		return COMP_UI_M_CP_DEST_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_UW_YEAR() {
		return COMP_UI_M_CP_DEST_UW_YEAR;
	}

	public void setCOMP_UI_M_CP_DEST_UW_YEAR_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_UW_YEAR_LABEL) {
		this.COMP_UI_M_CP_DEST_UW_YEAR_LABEL = COMP_UI_M_CP_DEST_UW_YEAR_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_UW_YEAR(HtmlInputText COMP_UI_M_CP_DEST_UW_YEAR) {
		this.COMP_UI_M_CP_DEST_UW_YEAR = COMP_UI_M_CP_DEST_UW_YEAR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CP_TREATY() {
		return COMP_UI_M_BUT_LOV_CP_TREATY;
	}

	public void setCOMP_UI_M_BUT_LOV_CP_TREATY(HtmlCommandButton COMP_UI_M_BUT_LOV_CP_TREATY) {
		this.COMP_UI_M_BUT_LOV_CP_TREATY = COMP_UI_M_BUT_LOV_CP_TREATY;
	}

	public CTRL_1 getCTRL_1_BEAN() {
		return CTRL_1_BEAN;
	}

	public void setCTRL_1_BEAN(CTRL_1 CTRL_1_BEAN) {
		this.CTRL_1_BEAN = CTRL_1_BEAN;
	}
	
	public String cancelButtonAction()
	{
		
		COMP_UI_M_CP_TREATY_CODE.setSubmittedValue(null);
		COMP_UI_M_CP_TREATY_DESC.setSubmittedValue(null);
		COMP_UI_M_CP_DEST_TREATY_CODE.setSubmittedValue(null);
		COMP_UI_M_CP_UW_YEAR.setSubmittedValue(null);
		COMP_UI_M_CP_DEST_UW_YEAR.setSubmittedValue(null);
		
		CTRL_1_BEAN.setUI_M_CP_TREATY_CODE(null);
		CTRL_1_BEAN.setUI_M_CP_TREATY_DESC(null);
		CTRL_1_BEAN.setUI_M_CP_DEST_TREATY_CODE(null);
		/*CTRL_1_BEAN.setUI_M_CP_UW_YEAR(null);
		CTRL_1_BEAN.setUI_M_CP_UW_YEAR(null);*/
		
		return "TreatyMaster";
	}
	
	/**
	 * Suggestion Action method called for List preparation
	 * 
	 * @param event
	 * @return List
	 */
	public List suggestionActionTreatyCode(Object event) {
		String treatyCode = (String) event;
		PM_IL_PROP_TREATY_CTRL_1_HELPER helper = new PM_IL_PROP_TREATY_CTRL_1_HELPER();
		treatyCodeList = helper.prepareTreatyCodeList(treatyCode,
				treatyCodeList);
		return treatyCodeList;
	}
	
	
	/**
	 * Method Called for Setting Description Field
	 * 
	 * @param event
	 */
	public void getTreatyCodeDesc(ActionEvent event) {
		COMP_UI_M_CP_TREATY_DESC.setSubmittedValue(null);
		System.out.println("In copy Treaty Description");
		if (COMP_UI_M_CP_TREATY_CODE.getSubmittedValue() != null) {
			System.out.println("COmponent Treaty :"
					+ COMP_UI_M_CP_TREATY_CODE.getSubmittedValue());
			String treatyCode = COMP_UI_M_CP_TREATY_CODE.getSubmittedValue().toString();
			System.out.println("String valuee of Treaty Code :" + treatyCode);
			PM_IL_PROP_TREATY_CTRL_1_HELPER helper = new PM_IL_PROP_TREATY_CTRL_1_HELPER();
			String treatyCodeDesc = helper.getTreatyDescforCode(treatyCode,
					treatyCodeList);
			CTRL_1_BEAN.setUI_M_CP_TREATY_DESC(treatyCodeDesc);
			COMP_UI_M_CP_TREATY_DESC.setSubmittedValue(treatyCodeDesc);
			System.out.println("Description :"
					+ CTRL_1_BEAN.getUI_M_CP_TREATY_DESC());
			
		}
	}
	
	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_TREATY_CODE
	 * 
	 * @param e
	 */
	public void COMP_UI_M_CP_TREATY_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue=(String)input.getSubmittedValue();
		if(!inputValue.isEmpty()){
			CTRL_1_BEAN.setUI_M_CP_TREATY_CODE(inputValue);
			System.out.println(" Treaty Code on blur :"+CTRL_1_BEAN.getUI_M_CP_TREATY_CODE());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out
				.println("COMP_UI_M_CP_TREATY_CODE_WHEN_VALIDATE_ITEM >>>>>>>>> in action");
	}
	
	public void validateTreatyCode(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		
		PM_IL_PROP_TREATY_CTRL_1_HELPER helper=new PM_IL_PROP_TREATY_CTRL_1_HELPER();
		helper.whenValidateTreatyCode(CTRL_1_BEAN);
		if(CTRL_1_BEAN.getUI_M_CP_UW_YEAR()!=0){
			COMP_UI_M_CP_UW_YEAR.setSubmittedValue(CTRL_1_BEAN.getUI_M_CP_UW_YEAR()+"");
		}
		
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR UW_YEAR
	 * 
	 * @param e
	 */
	public void COMP_UI_M_CP_UW_YEAR_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue=(String)input.getSubmittedValue();
		
		if(!inputValue.isEmpty()){
			CTRL_1_BEAN.setUI_M_CP_UW_YEAR(Integer.parseInt(inputValue));
			System.out.println(" UW Year on blur :"+CTRL_1_BEAN.getUI_M_CP_UW_YEAR());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out
				.println(" COMP_UI_M_CP_UW_YEAR_WHEN_VALIDATE_ITEM >>>>>>>>> in action");
	}
	
	public void validateUWYear(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		PM_IL_PROP_TREATY_CTRL_1_HELPER helper=new PM_IL_PROP_TREATY_CTRL_1_HELPER();
		helper.whenValidateUWYear(CTRL_1_BEAN);
		
	}
	
	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR Target Treaty Code
	 * 
	 * @param e
	 */
	public void COMP_UI_M_CP_DEST_TREATY_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue=(String)input.getSubmittedValue();
		
		if(!inputValue.isEmpty()){
			CTRL_1_BEAN.setUI_M_CP_DEST_TREATY_CODE(inputValue);
			System.out.println(" Dest Treaty code :"+CTRL_1_BEAN.getUI_M_CP_DEST_TREATY_CODE());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out
				.println(" COMP_UI_M_CP_DEST_TREATY_CODE_WHEN_VALIDATE_ITEM >>>>>>>>> in action");
	}
	
	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR Target uw year
	 * 
	 * @param e
	 */
	public void COMP_UI_M_CP_DEST_UW_YEAR_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue=(String)input.getSubmittedValue();
		
		if(!inputValue.isEmpty()){
			CTRL_1_BEAN.setUI_M_CP_DEST_UW_YEAR(Integer.parseInt(inputValue));
			System.out.println(" Dest Treaty code :"+CTRL_1_BEAN.getUI_M_CP_DEST_UW_YEAR());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out
				.println(" COMP_UI_M_CP_DEST_UW_YEAR_WHEN_VALIDATE_ITEM >>>>>>>>> in action");
	}
	
	public void validateDestUWYear(FacesContext context,
			UIComponent component, Object value)throws ValidatorException{
		PM_IL_PROP_TREATY_CTRL_1_HELPER helper=new PM_IL_PROP_TREATY_CTRL_1_HELPER();
		int errorCode=0;
		CommonUtils commonUtils=new CommonUtils();
		
		int uwYear=CTRL_1_BEAN.getUI_M_CP_DEST_UW_YEAR();
		if (uwYear >= Integer
				.parseInt(PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MAX_UPTO)
				|| uwYear <= Integer
						.parseInt(PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MIN_UPTO)) {

			throw new ValidatorException(
					Messages
							.getMessage(
									"com.iii.premia.common.errorUtil.PELErrorMessages",
									"1035",
									new Object[] {
											PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MIN_UPTO,
											PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MAX_UPTO }));
		}else{
			
			try {
				PM_IL_PROP_TREATY treatyValueBean=compositeAction.
					getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
				helper.whenValidateDestUWYear(CTRL_1_BEAN,treatyValueBean);
			} catch (SQLException e) {
				errorCode=e.getErrorCode();
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally{
				if (errorCode == 20100) {
					try {
						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context, component
								.getClientId(context), getWarningMap());
					} catch (DBException e) {
						e.printStackTrace();
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
		}
	}
	public String okButtonAction() throws Exception
	{
		boolean flag=false;
		String returnLink=null;
		CommonUtils commonUtils=new CommonUtils();
		PM_IL_PROP_TREATY_CTRL_1_HELPER helper=new PM_IL_PROP_TREATY_CTRL_1_HELPER();
		String treatyCode=null;
		try{
			
			
				treatyCode=helper.pilm015_apac_ctrl_1_m_but_ok_when_button_pressed(CTRL_1_BEAN,compositeAction);
				System.out.println(" Treaty Code :"+treatyCode);	
				if(treatyCode!=null){
					
					new SearchValueBean().prepareTreatyMasterDetails(treatyCode);
				}
		}catch(ValidatorException validatorException){
			
			String validationError = validatorException.getMessage();
			System.out.println("Validation exception thrown is"
					+ validationError);
			this.getErrorMap().put("current", validationError);
			flag=true;
		}
		if(!flag){
			returnLink="TreatyMaster";
		}else{
			returnLink="";
		}
		return returnLink ;
	}
	
	
	
	
	public void resetAll(){
		COMP_UI_M_CP_DEST_TREATY_CODE.resetValue();
		COMP_UI_M_CP_DEST_UW_YEAR.resetValue();
		
	}
}

package com.iii.pel.forms.PILP234;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FM_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_FM_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FM_PROD_DESC;

	private HtmlOutputLabel COMP_UI_M_TO_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_TO_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_TO_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TO_PROD_DESC;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlOutputLabel COMP_UI_M_FM_PROP_NO_LABEL;

	private HtmlInputText COMP_UI_M_FM_PROP_NO;

	private HtmlOutputLabel COMP_UI_M_TO_PROP_NO_LABEL;

	private HtmlInputText COMP_UI_M_TO_PROP_NO;

	private HtmlCommandButton COMP_UI_M_FM_PROD_LOV;

	private HtmlCommandButton COMP_UI_M_TO_PROD_LOV;

	private HtmlCommandButton COMP_UI_M_FM_PROP_LOV;

	private HtmlCommandButton COMP_UI_M_TO_PROP_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private DUMMY DUMMY_BEAN;

	// manually added fields
	private List<DUMMY> suggestionList;

	PILP234_DUMMY_HELPER helper;
	public DUMMY_ACTION() {
		try {
			DUMMY_BEAN = new DUMMY();
			helper = new PILP234_DUMMY_HELPER();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Constructor", e.getMessage());
		}
	}

	public List<DUMMY> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<DUMMY> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_PROD_CODE_LABEL() {
		return COMP_UI_M_FM_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_PROD_CODE() {
		return COMP_UI_M_FM_PROD_CODE;
	}

	public void setCOMP_UI_M_FM_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_FM_PROD_CODE_LABEL) {
		this.COMP_UI_M_FM_PROD_CODE_LABEL = COMP_UI_M_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_FM_PROD_CODE(HtmlInputText COMP_UI_M_FM_PROD_CODE) {
		this.COMP_UI_M_FM_PROD_CODE = COMP_UI_M_FM_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_PROD_DESC_LABEL() {
		return COMP_UI_M_FM_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_PROD_DESC() {
		return COMP_UI_M_FM_PROD_DESC;
	}

	public void setCOMP_UI_M_FM_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FM_PROD_DESC_LABEL) {
		this.COMP_UI_M_FM_PROD_DESC_LABEL = COMP_UI_M_FM_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_FM_PROD_DESC(HtmlInputText COMP_UI_M_FM_PROD_DESC) {
		this.COMP_UI_M_FM_PROD_DESC = COMP_UI_M_FM_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_PROD_CODE_LABEL() {
		return COMP_UI_M_TO_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_PROD_CODE() {
		return COMP_UI_M_TO_PROD_CODE;
	}

	public void setCOMP_UI_M_TO_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_TO_PROD_CODE_LABEL) {
		this.COMP_UI_M_TO_PROD_CODE_LABEL = COMP_UI_M_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_TO_PROD_CODE(HtmlInputText COMP_UI_M_TO_PROD_CODE) {
		this.COMP_UI_M_TO_PROD_CODE = COMP_UI_M_TO_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_PROD_DESC_LABEL() {
		return COMP_UI_M_TO_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_PROD_DESC() {
		return COMP_UI_M_TO_PROD_DESC;
	}

	public void setCOMP_UI_M_TO_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_TO_PROD_DESC_LABEL) {
		this.COMP_UI_M_TO_PROD_DESC_LABEL = COMP_UI_M_TO_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_TO_PROD_DESC(HtmlInputText COMP_UI_M_TO_PROD_DESC) {
		this.COMP_UI_M_TO_PROD_DESC = COMP_UI_M_TO_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DT_LABEL() {
		return COMP_UI_M_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT_LABEL(HtmlOutputLabel COMP_UI_M_FM_DT_LABEL) {
		this.COMP_UI_M_FM_DT_LABEL = COMP_UI_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar COMP_UI_M_FM_DT) {
		this.COMP_UI_M_FM_DT = COMP_UI_M_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DT_LABEL() {
		return COMP_UI_M_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT_LABEL(HtmlOutputLabel COMP_UI_M_TO_DT_LABEL) {
		this.COMP_UI_M_TO_DT_LABEL = COMP_UI_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar COMP_UI_M_TO_DT) {
		this.COMP_UI_M_TO_DT = COMP_UI_M_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_PROP_NO_LABEL() {
		return COMP_UI_M_FM_PROP_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_PROP_NO() {
		return COMP_UI_M_FM_PROP_NO;
	}

	public void setCOMP_UI_M_FM_PROP_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_FM_PROP_NO_LABEL) {
		this.COMP_UI_M_FM_PROP_NO_LABEL = COMP_UI_M_FM_PROP_NO_LABEL;
	}

	public void setCOMP_UI_M_FM_PROP_NO(HtmlInputText COMP_UI_M_FM_PROP_NO) {
		this.COMP_UI_M_FM_PROP_NO = COMP_UI_M_FM_PROP_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_PROP_NO_LABEL() {
		return COMP_UI_M_TO_PROP_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_PROP_NO() {
		return COMP_UI_M_TO_PROP_NO;
	}

	public void setCOMP_UI_M_TO_PROP_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_TO_PROP_NO_LABEL) {
		this.COMP_UI_M_TO_PROP_NO_LABEL = COMP_UI_M_TO_PROP_NO_LABEL;
	}

	public void setCOMP_UI_M_TO_PROP_NO(HtmlInputText COMP_UI_M_TO_PROP_NO) {
		this.COMP_UI_M_TO_PROP_NO = COMP_UI_M_TO_PROP_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_FM_PROD_LOV() {
		return COMP_UI_M_FM_PROD_LOV;
	}

	public void setCOMP_UI_M_FM_PROD_LOV(HtmlCommandButton COMP_UI_M_FM_PROD_LOV) {
		this.COMP_UI_M_FM_PROD_LOV = COMP_UI_M_FM_PROD_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_TO_PROD_LOV() {
		return COMP_UI_M_TO_PROD_LOV;
	}

	public void setCOMP_UI_M_TO_PROD_LOV(HtmlCommandButton COMP_UI_M_TO_PROD_LOV) {
		this.COMP_UI_M_TO_PROD_LOV = COMP_UI_M_TO_PROD_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FM_PROP_LOV() {
		return COMP_UI_M_FM_PROP_LOV;
	}

	public void setCOMP_UI_M_FM_PROP_LOV(HtmlCommandButton COMP_UI_M_FM_PROP_LOV) {
		this.COMP_UI_M_FM_PROP_LOV = COMP_UI_M_FM_PROP_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_TO_PROP_LOV() {
		return COMP_UI_M_TO_PROP_LOV;
	}

	public void setCOMP_UI_M_TO_PROP_LOV(HtmlCommandButton COMP_UI_M_TO_PROP_LOV) {
		this.COMP_UI_M_TO_PROP_LOV = COMP_UI_M_TO_PROP_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public List<DUMMY> getLovForFM_TO_PROD_CODE(Object obj) {
		String filterString = obj.toString().trim();
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		System.out.println("Fetching List");
		suggestionList = delegate.getListForFM_TO_PROD_CODE(filterString);
		return suggestionList;
	}


	public List<DUMMY> getLovForFM_TO_PROP_NO(Object obj) {
		String filterString = obj.toString().trim();
		DUMMY_DELEGATE delegate = new DUMMY_DELEGATE();
		System.out.println("Fetching List");
		/*suggestionList = delegate.getListForFM_TO_PROP_NO(filterString);*/
		suggestionList = delegate.getListForFM_TO_PROP_NO(filterString,this);
		return suggestionList;
	}

	public void UI_M_FM_PROD_CODE_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput)event.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_FM_PROD_CODE.setSubmittedValue("0");
		}else {
			COMP_UI_M_FM_PROD_CODE.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}

	
	public void validateUI_M_FM_PROD_CODE(FacesContext context,UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_FM_PROD_CODE((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_FM_PROD_CODE().equals("0"))) {
				DUMMY_BEAN.setUI_M_FM_PROD_DESC(helper.ValidateUI_M_PROD(DUMMY_BEAN.getUI_M_FM_PROD_CODE()));
			}
			COMP_UI_M_FM_PROD_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void UI_M_TO_PROD_CODE_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput)event.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_TO_PROD_CODE.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
		}else {
			COMP_UI_M_TO_PROD_CODE.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validateUI_M_TO_PROD_CODE(FacesContext context,UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_TO_PROD_CODE((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_TO_PROD_CODE().equals("zzzzzzzzzzzzzzzzzzzzzz"))) {
				DUMMY_BEAN.setUI_M_TO_PROD_DESC(helper.ValidateUI_M_PROD(DUMMY_BEAN.getUI_M_TO_PROD_CODE()));
			}
			COMP_UI_M_TO_PROD_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	
	
	public void validateUI_M_TO_PROP_NO(FacesContext contect,UIComponent component,Object value) {
		DUMMY_BEAN.setUI_M_TO_PROP_NO((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_TO_PROP_NO().equals("zzzzzzzzzzzzzzzzzzzzzz"))) {
			helper.validateUI_M_PROP_NO(DUMMY_BEAN.getUI_M_TO_PROP_NO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateUI_M_FM_PROP_NO(FacesContext context,UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_FM_PROP_NO((String) value);
		try {
			if (!(DUMMY_BEAN.getUI_M_FM_PROP_NO().equals("0"))) {
			helper.validateUI_M_PROP_NO(DUMMY_BEAN.getUI_M_FM_PROP_NO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void UI_M_TO_PROP_NO_WHEN_VALIDATE_ITEM(ActionEvent event) {
		try {
			UIInput input = (UIInput)event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			if (value.isEmpty()) {
				COMP_UI_M_TO_PROP_NO.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
			}else {
				COMP_UI_M_TO_PROP_NO.setSubmittedValue(value);
			}
			ErrorHelpUtil.validate(input, getErrorMap());
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("UI_M_TO_PROP_NO", e.getMessage());
		}
	}
	
	public void UI_M_FM_PROP_NO_WHEN_VALIDATE_ITEM(ActionEvent event) {
		try {
			UIInput input = (UIInput)event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			if (value.isEmpty()) {
				COMP_UI_M_FM_PROP_NO.setSubmittedValue("0");
			}else {
				COMP_UI_M_FM_PROP_NO.setSubmittedValue(value);
			}
			ErrorHelpUtil.validate(input, getErrorMap());
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("UI_M_FM_PROP_NO", e.getMessage());
		}
	}
	

	
	public void validateUI_M_FM_DT(FacesContext context, UIComponent component,Object value) {
		try {
			DUMMY_BEAN.setUI_M_FM_DT((Date) value);
			helper.validateUI_M_FM_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
		public void validateUI_M_TO_DT(FacesContext context, UIComponent component,Object value) {
			try {
				DUMMY_BEAN.setUI_M_TO_DT((Date) value);
				helper.validateUI_M_TO_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public String processButtonAction() {
		String message = null;
		PILP234_DUMMY_HELPER helper = new PILP234_DUMMY_HELPER();
		try {
			helper.BATCH_POL_APPROVAL(DUMMY_BEAN.getUI_M_FM_PROD_CODE(), DUMMY_BEAN.getUI_M_TO_PROD_CODE(),
								  DUMMY_BEAN.getUI_M_FM_PROP_NO(), DUMMY_BEAN.getUI_M_TO_PROP_NO(),
								  DUMMY_BEAN.getUI_M_FM_DT(), DUMMY_BEAN.getUI_M_TO_DT(),new CommonUtils().getCurrentDate());
			message = Messages.getString("messageProperties","errorPanel$message$process$complete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("processButtonAction", message);
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}

		return null;
	}

	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				helper.whenCreateRecord(DUMMY_BEAN);
				setBlockFlag(false);
			}
		}catch (Exception e) {
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					    e.getMessage());
				    getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
}

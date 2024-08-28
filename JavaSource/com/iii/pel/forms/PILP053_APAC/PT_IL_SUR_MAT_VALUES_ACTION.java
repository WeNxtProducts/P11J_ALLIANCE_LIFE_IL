package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_SUR_MAT_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DOC_NO;

	private HtmlGraphicImage COMP_MANDATORY_IMG;

	private PT_IL_SUR_MAT_VALUES PT_IL_SUR_MAT_VALUES_BEAN;

	public PILP053_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_SUR_MAT_VALUES_HELPER helper;

	public PT_IL_SUR_MAT_VALUES_ACTION() {

		PT_IL_SUR_MAT_VALUES_BEAN = new PT_IL_SUR_MAT_VALUES();
		helper = new PT_IL_SUR_MAT_VALUES_HELPER();
		// COMP_MANDATORY_IMG = new HtmlGraphicImage();
	}

	public void resetAllComponents() {
		COMP_POL_NO.resetValue();
		COMP_UI_M_DOC_NO.resetValue();
	}

	public HtmlGraphicImage getCOMP_MANDATORY_IMG() {
		return COMP_MANDATORY_IMG;
	}

	public void setCOMP_MANDATORY_IMG(HtmlGraphicImage comp_mandatory_img) {
		COMP_MANDATORY_IMG = comp_mandatory_img;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DOC_NO_LABEL() {
		return COMP_UI_M_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DOC_NO() {
		return COMP_UI_M_DOC_NO;
	}

	public void setCOMP_UI_M_DOC_NO_LABEL(HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL) {
		this.COMP_UI_M_DOC_NO_LABEL = COMP_UI_M_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DOC_NO(HtmlInputText COMP_UI_M_DOC_NO) {
		this.COMP_UI_M_DOC_NO = COMP_UI_M_DOC_NO;
	}

	public PT_IL_SUR_MAT_VALUES getPT_IL_SUR_MAT_VALUES_BEAN() {
		return PT_IL_SUR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SUR_MAT_VALUES_BEAN(
			PT_IL_SUR_MAT_VALUES PT_IL_SUR_MAT_VALUES_BEAN) {
		this.PT_IL_SUR_MAT_VALUES_BEAN = PT_IL_SUR_MAT_VALUES_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_SUR_MAT_VALUES_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPT_IL_SUR_MAT_VALUES_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPT_IL_SUR_MAT_VALUES_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.PRE_FORM(compositeAction);
				helper.WHEN_NEW_FORM_INSTANCE();
				setFormFlag(false);
				
				/*added by ram*/
				
				setListItemValues();
			
			/*end*/
			}
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.executeQuery(compositeAction);
				if (compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
						.getPT_IL_SUR_MAT_VALUES_BEAN().getROWID() != null) {
					helper.POST_QUERY(compositeAction);
				}
				compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
						.getPT_IL_SUR_MAT_VALUES_BEAN().setUI_PROCESS_YN("N");
				setBlockFlag(false);
			}

			if ("Y".equalsIgnoreCase(compositeAction
					.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
					.getPT_IL_SUR_MAT_VALUES_BEAN().getUI_PROCESS_YN())) {

				// helper.executeQuery(compositeAction);
				helper.POST_QUERY(compositeAction);
				System.out.println("ADABOINA REDYYYYYYYYYYYYYYYYYY");
				compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
						.getPT_IL_SUR_MAT_VALUES_BEAN().setUI_PROCESS_YN("N");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void POL_NO_Validator(ActionEvent event) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			String value = (String) COMP_POL_NO.getSubmittedValue();
			getPT_IL_SUR_MAT_VALUES_BEAN().setPOL_NO(value);
			helper.WHEN_VALIDATE_ITEM_POL_NO(compositeAction);
			resetAllComponents();
			compositeAction.getSURRENDER_ACTION_BEAN().resetAllComponents();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO", e.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), COMP_POL_NO.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void M_DOC_NO_Validator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {

			helper.WHEN_VALIDATE_ITEM_M_DOC_NO(compositeAction);
			getPT_IL_SUR_MAT_VALUES_BEAN().setUI_M_DOC_NO((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public List<LovBean> lovPOL_NO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP053_APAC",
					"PT_IL_SUR_MAT_VALUES", "POL_NO", null, null, null, null,
					null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String backButton() {
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion("PILT006_APAC_PT_IL_CLAIM_SEARCH_ACTION",
				"fetchRecords");
		return "PILP053_APAC";
	}
/*	added by ram*/


	public void setListItemValues()
	 {
		 System.out.println("Welcome to setListItemValues  ");
		 Connection connection = null;
		 try
		 {
			 connection = CommonUtils.getConnection();
			 setListSURRENDER_CHRG(ListItemUtil.getDropDownListValue(
					 			connection, "PILP053_APAC", "SURRENDER",
					 				"SURRENDER.M_SURR_CHG_YN", "YESNO"));

			 
			 System.out.println("getListSURRENDER_CHRG       "+getListSURRENDER_CHRG());
		 
			
		 }
		 catch(Exception e)
		 {
			 
		 }
	 }
	
private List<SelectItem> listSURRENDER_CHRG = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListSURRENDER_CHRG() {
		return listSURRENDER_CHRG;
	}

	public void setListSURRENDER_CHRG(List<SelectItem> listSURRENDER_CHRG) {
		this.listSURRENDER_CHRG = listSURRENDER_CHRG;
	}
	
	

/*end*/

}

package com.iii.pel.forms.PILM034;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PP_LIST_ITEM_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_LIV_CODE_LABEL;

	private HtmlInputText COMP_LIV_CODE;

	private HtmlOutputLabel COMP_LIV_CODE_DESC_LABEL;

	private HtmlInputText COMP_LIV_CODE_DESC;

	private PP_LIST_ITEM_VALUES PP_LIST_ITEM_VALUES_BEAN;

	public PILM034_COMPOSITE_ACTION compositeAction;

	private PP_LIST_ITEM_VALUES_HELPER helper;

	ArrayList<LovBean> lovList = new ArrayList<LovBean>();


	public PP_LIST_ITEM_VALUES_ACTION(){
		PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
		helper = new PP_LIST_ITEM_VALUES_HELPER();
	}

	public HtmlOutputLabel getCOMP_LIV_CODE_LABEL() {
		return COMP_LIV_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LIV_CODE() {
		return COMP_LIV_CODE;
	}

	public void setCOMP_LIV_CODE_LABEL(HtmlOutputLabel COMP_LIV_CODE_LABEL) {
		this.COMP_LIV_CODE_LABEL = COMP_LIV_CODE_LABEL;
	}

	public void setCOMP_LIV_CODE(HtmlInputText COMP_LIV_CODE) {
		this.COMP_LIV_CODE = COMP_LIV_CODE;
	}

	public HtmlOutputLabel getCOMP_LIV_CODE_DESC_LABEL() {
		return COMP_LIV_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_LIV_CODE_DESC() {
		return COMP_LIV_CODE_DESC;
	}

	public void setCOMP_LIV_CODE_DESC_LABEL(HtmlOutputLabel COMP_LIV_CODE_DESC_LABEL) {
		this.COMP_LIV_CODE_DESC_LABEL = COMP_LIV_CODE_DESC_LABEL;
	}

	public void setCOMP_LIV_CODE_DESC(HtmlInputText COMP_LIV_CODE_DESC) {
		this.COMP_LIV_CODE_DESC = COMP_LIV_CODE_DESC;
	}

	public PP_LIST_ITEM_VALUES getPP_LIST_ITEM_VALUES_BEAN() {
		return PP_LIST_ITEM_VALUES_BEAN;
	}

	public void setPP_LIST_ITEM_VALUES_BEAN(PP_LIST_ITEM_VALUES PP_LIST_ITEM_VALUES_BEAN) {
		this.PP_LIST_ITEM_VALUES_BEAN = PP_LIST_ITEM_VALUES_BEAN;
	}
	public void saveRecord() {
		try {
			if (getPP_LIST_ITEM_VALUES_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPP_LIST_ITEM_VALUES_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPP_LIST_ITEM_VALUES_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if(PP_LIST_ITEM_VALUES_BEAN.getROWID() != null){
					helper.executeQuery(compositeAction);
					helper.ON_POPULATE_DETAILS(compositeAction, compositeAction.
							getPM_IL_TAR_HDR_ACTION_BEAN().getPM_IL_TAR_HDR_BEAN().getTH_PARAM_TYPE());
					helper.postQuery(PP_LIST_ITEM_VALUES_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}
	public void validateLIV_CODE(FacesContext context, UIComponent component,Object value){
		try {
			helper.WHEN_VALIDATE_ITEM_LIV_CODE(this.PP_LIST_ITEM_VALUES_BEAN, (String) value);
			PP_LIST_ITEM_VALUES_BEAN.setLIV_CODE((String) value);
			COMP_LIV_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}		
	}
	public List<LovBean> prepareLOV(Object value){
		try{
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM034", "PP_LIST_ITEM_VALUES", "LIV_CODE", 
					null, null, null, null, null, (String) value);
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
}

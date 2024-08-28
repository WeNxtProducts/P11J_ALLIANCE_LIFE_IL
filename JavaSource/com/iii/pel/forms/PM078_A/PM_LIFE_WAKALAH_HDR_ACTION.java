package com.iii.pel.forms.PM078_A;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
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

public class PM_LIFE_WAKALAH_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_WAKS_MODULE_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_MODULE;

	private HtmlOutputLabel COMP_WAKS_PRODUCT_CODE_LABEL;

	private HtmlInputText COMP_WAKS_PRODUCT_CODE;

	private HtmlOutputLabel COMP_UI_M_WAKS_PRODUCT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WAKS_PRODUCT_CODE;

	private HtmlOutputLabel COMP_WAKS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_WAKS_FRZ_FLAG;

	private PM_LIFE_WAKALAH_HDR PM_LIFE_WAKALAH_HDR_BEAN;

	public PM078_A_COMPOSITE_ACTION compositeAction;

	private PM_LIFE_WAKALAH_HDR_HELPER helper;

	private List<SelectItem> listWAKS_MODULE = new ArrayList<SelectItem>();

	ArrayList<LovBean> pCodelovList = new ArrayList<LovBean>();

	public PM_LIFE_WAKALAH_HDR_ACTION(){
		PM_LIFE_WAKALAH_HDR_BEAN = new PM_LIFE_WAKALAH_HDR();
		helper = new PM_LIFE_WAKALAH_HDR_HELPER();
		getListWAKS_MODULE();
	}

	public HtmlOutputLabel getCOMP_WAKS_MODULE_LABEL() {
		return COMP_WAKS_MODULE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WAKS_MODULE() {
		return COMP_WAKS_MODULE;
	}

	public void setCOMP_WAKS_MODULE_LABEL(HtmlOutputLabel COMP_WAKS_MODULE_LABEL) {
		this.COMP_WAKS_MODULE_LABEL = COMP_WAKS_MODULE_LABEL;
	}

	public void setCOMP_WAKS_MODULE(HtmlSelectOneMenu COMP_WAKS_MODULE) {
		this.COMP_WAKS_MODULE = COMP_WAKS_MODULE;
	}

	public HtmlOutputLabel getCOMP_WAKS_PRODUCT_CODE_LABEL() {
		return COMP_WAKS_PRODUCT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WAKS_PRODUCT_CODE() {
		return COMP_WAKS_PRODUCT_CODE;
	}

	public void setCOMP_WAKS_PRODUCT_CODE_LABEL(HtmlOutputLabel COMP_WAKS_PRODUCT_CODE_LABEL) {
		this.COMP_WAKS_PRODUCT_CODE_LABEL = COMP_WAKS_PRODUCT_CODE_LABEL;
	}

	public void setCOMP_WAKS_PRODUCT_CODE(HtmlInputText COMP_WAKS_PRODUCT_CODE) {
		this.COMP_WAKS_PRODUCT_CODE = COMP_WAKS_PRODUCT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAKS_PRODUCT_CODE_LABEL() {
		return COMP_UI_M_WAKS_PRODUCT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAKS_PRODUCT_CODE() {
		return COMP_UI_M_WAKS_PRODUCT_CODE;
	}

	public void setCOMP_UI_M_WAKS_PRODUCT_CODE_LABEL(HtmlOutputLabel COMP_UI_M_WAKS_PRODUCT_CODE_LABEL) {
		this.COMP_UI_M_WAKS_PRODUCT_CODE_LABEL = COMP_UI_M_WAKS_PRODUCT_CODE_LABEL;
	}

	public void setCOMP_UI_M_WAKS_PRODUCT_CODE(HtmlInputText COMP_UI_M_WAKS_PRODUCT_CODE) {
		this.COMP_UI_M_WAKS_PRODUCT_CODE = COMP_UI_M_WAKS_PRODUCT_CODE;
	}

	public HtmlOutputLabel getCOMP_WAKS_FRZ_FLAG_LABEL() {
		return COMP_WAKS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_WAKS_FRZ_FLAG() {
		return COMP_WAKS_FRZ_FLAG;
	}

	public void setCOMP_WAKS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_WAKS_FRZ_FLAG_LABEL) {
		this.COMP_WAKS_FRZ_FLAG_LABEL = COMP_WAKS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_WAKS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_WAKS_FRZ_FLAG) {
		this.COMP_WAKS_FRZ_FLAG = COMP_WAKS_FRZ_FLAG;
	}

	public PM_LIFE_WAKALAH_HDR getPM_LIFE_WAKALAH_HDR_BEAN() {
		return PM_LIFE_WAKALAH_HDR_BEAN;
	}

	public void setPM_LIFE_WAKALAH_HDR_BEAN(PM_LIFE_WAKALAH_HDR PM_LIFE_WAKALAH_HDR_BEAN) {
		this.PM_LIFE_WAKALAH_HDR_BEAN = PM_LIFE_WAKALAH_HDR_BEAN;
	}
	public void actionOnListChange(ActionEvent event){
		UIInput input=(UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input,getErrorMap());
	}
	
	public void validateWAKS_MODULE(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_MODULE((String) value);
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWAKS_PRODUCT_CODE(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_PRODUCT_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_WAKS_PCODE(PM_LIFE_WAKALAH_HDR_BEAN);
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateWAKS_FRZ_FLAG(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			if((Boolean)value) {
				PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_FRZ_FLAG("Y");
			} else {
				PM_LIFE_WAKALAH_HDR_BEAN.setWAKS_FRZ_FLAG("N");
			}
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void saveRecord() {
		try {
			if (getPM_LIFE_WAKALAH_HDR_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_LIFE_WAKALAH_HDR_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPM_LIFE_WAKALAH_HDR_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	public List<SelectItem> getListWAKS_MODULE() {
		if (listWAKS_MODULE.size() == 0) {
			listWAKS_MODULE.clear();
			try {
				listWAKS_MODULE = helper.WAKS_MODULELIST();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("ListWAKS_MODULE", e.getMessage());
			}
		}
		return listWAKS_MODULE;
	}

	public void setListWAKS_MODULE(List<SelectItem> listWAKS_MODULE) {
		this.listWAKS_MODULE = listWAKS_MODULE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}
	public List<LovBean> prepareLOVPCODE(Object value){
		try{
			pCodelovList = helper.prepareLOVPCODE((String)value, 
					PM_LIFE_WAKALAH_HDR_BEAN.getWAKS_MODULE());
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return pCodelovList;
	}
}
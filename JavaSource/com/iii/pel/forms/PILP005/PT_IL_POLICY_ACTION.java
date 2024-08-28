package com.iii.pel.forms.PILP005;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.pel.forms.PILT009.PT_IL_FAC_OUT_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_UI_M_FAC_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_FAC_YN;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	
	private boolean onLoadFlag = false;
	
	private boolean preFormFlag = false;
	
	private List<SelectItem> facYNList = null;

	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			facYNList = ListItemUtil.getDropDownListValue(connection, "PILP005", "PT_IL_POLICY", "PT_IL_POLICY.M_FAC_YN", "YESNO");
		} catch (DBException e) {
		}
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

	public HtmlOutputLabel getCOMP_UI_M_FAC_YN_LABEL() {
		return COMP_UI_M_FAC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_FAC_YN() {
		return COMP_UI_M_FAC_YN;
	}

	public void setCOMP_UI_M_FAC_YN_LABEL(HtmlOutputLabel COMP_UI_M_FAC_YN_LABEL) {
		this.COMP_UI_M_FAC_YN_LABEL = COMP_UI_M_FAC_YN_LABEL;
	}

	public void setCOMP_UI_M_FAC_YN(HtmlSelectOneMenu COMP_UI_M_FAC_YN) {
		this.COMP_UI_M_FAC_YN = COMP_UI_M_FAC_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LOV() {
		return COMP_UI_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_BUT_POL_LOV) {
		this.COMP_UI_M_BUT_POL_LOV = COMP_UI_M_BUT_POL_LOV;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public boolean isPreFormFlag() {
		return preFormFlag;
	}

	public void setPreFormFlag(boolean preFormFlag) {
		this.preFormFlag = preFormFlag;
	}

	public List<SelectItem> getFacYNList() {
		return facYNList;
	}

	public void setFacYNList(List<SelectItem> facYNList) {
		this.facYNList = facYNList;
	}

	public void onLoad(PhaseEvent event){
		try {
			PILP005_HELPER helper = new PILP005_HELPER();
			if(!isOnLoadFlag()){
				if(!isPreFormFlag())
					helper.whenNewFormInstance();
				helper.whenNewBlockInstance();
				setPreFormFlag(true);
				setOnLoadFlag(true);
			}
			helper.POL_NO_WhenNewItemInstance();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public List<PT_IL_POLICY> getPolicySuggestionBox(Object value){
		List<PT_IL_POLICY> policyList = null;
		try {
			policyList = new PILP005_HELPER().getPolicyList((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return policyList;
	}
	
	public void POL_NOValidator(FacesContext context, UIComponent component, Object value) {
		try {
			PILP005_HELPER helper = new PILP005_HELPER();
			helper.getPILP005Instance().getPT_IL_POLICY_BEAN().setPOL_NO((String) value);
			helper.POL_NO_WhenValidateItem();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void POL_NOValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void FAC_YNValidator(FacesContext context, UIComponent component, Object value){
		new PILP005_HELPER().getPILP005Instance().getPT_IL_POLICY_BEAN().setPOL_FAC_YN((String) value);
	}
	
	public String okButtonPressed() {
		String returnString = null;
		try {
			returnString = new PILP005_HELPER().whenOKButtonPressed();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			/*String callingForm = (String) sessionMap.get("CALLING_FORM");
			if((callingForm==null?"":callingForm).equals("PILT009")){*/
				new PT_IL_FAC_OUT_HELPER().afterApproveButton();
				getCOMP_UI_M_BUT_OK().setDisabled(true);
			///}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return returnString;
	}
	
	public String cancelButtonPressed() {
		CommonUtils.clearMaps(this);
		return "PILT009_PAGE";
	}
}

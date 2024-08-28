package com.iii.pel.forms.PILP014B;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PT_REM_DTLS_ACTION extends CommonAction {

	PT_REM_DTLS_HELPER helper;
	PT_REM_DTLS PT_REM_DTLS_BEAN;
	PILP014B_COMPOSITE_ACTION compositeAction;

	private UIData dataTable;
	private List<PT_REM_DTLS> dataList_PT_REM_DTLS = new ArrayList<PT_REM_DTLS>();

	private HtmlSelectBooleanCheckbox COMP_UI_M_SELECT;

	public PT_REM_DTLS getPT_REM_DTLS_BEAN() {
		return PT_REM_DTLS_BEAN;
	}

	public void setPT_REM_DTLS_BEAN(PT_REM_DTLS pt_rem_dtls_bean) {
		PT_REM_DTLS_BEAN = pt_rem_dtls_bean;
	}

	public List<PT_REM_DTLS> getDataList_PT_REM_DTLS() {
		return dataList_PT_REM_DTLS;
	}

	public void setDataList_PT_REM_DTLS(List<PT_REM_DTLS> dataList_PT_REM_DTLS) {
		this.dataList_PT_REM_DTLS = dataList_PT_REM_DTLS;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_REM_DTLS_ACTION() {
		helper = new PT_REM_DTLS_HELPER();
		PT_REM_DTLS_BEAN = new PT_REM_DTLS();
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String okButAction() {
		String outcome ="";
		try {
			helper.whenPressedOkBut(compositeAction);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_OK()
					.setDisabled(true);
			outcome="PILP014B";
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURR", e.getMessage());
		}
		return outcome;
	}
	
	public void validate_UI_M_SELECT(FacesContext context,UIComponent component ,Object value) {
		try{
		Boolean value1 = (Boolean) value;
			if("true".equals(value1.toString())){
				PT_REM_DTLS_BEAN.setRLD_REM_YN("Y");
			}else{
				PT_REM_DTLS_BEAN.setRLD_REM_YN("N");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String cancelButAction(){
		return "PILP014B";
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_SELECT() {
		return COMP_UI_M_SELECT;
	}

	public void setCOMP_UI_M_SELECT(HtmlSelectBooleanCheckbox comp_ui_m_select) {
		COMP_UI_M_SELECT = comp_ui_m_select;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

}

package com.iii.pel.forms.PILP014B;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
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
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	public PILP014B_COMPOSITE_ACTION compositeAction;
	private DUMMY DUMMY_BEAN;
	private DUMMY_HELPER helper;

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;
	private HtmlInputText COMP_UI_M_POL_NO_FM;
	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;
	private HtmlInputText COMP_UI_M_POL_NO_TO;
	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;
	private HtmlCalendar COMP_UI_M_PROCESS_DT;
	private HtmlOutputLabel COMP_UI_M_PROC_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_PROC_TYPE;
	private HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_PROCESS_TYPE;
	private HtmlOutputLabel COMP_UI_M_REF_NO_LABEL;
	private HtmlInputText COMP_UI_M_REF_NO;
	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private List<SelectItem> UI_M_PROC_TYPE_LIST = new ArrayList<SelectItem>();
	private List<SelectItem> UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>();

	public List<SelectItem> getUI_M_PROCESS_TYPE_LIST() {
		return UI_M_PROCESS_TYPE_LIST;
	}

	public void setUI_M_PROCESS_TYPE_LIST(
			List<SelectItem> ui_m_process_type_list) {
		UI_M_PROCESS_TYPE_LIST = ui_m_process_type_list;
	}

	public List<SelectItem> getUI_M_PROC_TYPE_LIST() {
		return UI_M_PROC_TYPE_LIST;
	}

	public void setUI_M_PROC_TYPE_LIST(List<SelectItem> ui_m_proc_type_list) {
		UI_M_PROC_TYPE_LIST = ui_m_proc_type_list;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlOutputLabel getCOMP_UI_M_REF_NO_LABEL() {
		return COMP_UI_M_REF_NO_LABEL;
	}

	public void setCOMP_UI_M_REF_NO_LABEL(HtmlOutputLabel comp_ui_m_ref_no_label) {
		COMP_UI_M_REF_NO_LABEL = comp_ui_m_ref_no_label;
	}

	public HtmlInputText getCOMP_UI_M_REF_NO() {
		return COMP_UI_M_REF_NO;
	}

	public void setCOMP_UI_M_REF_NO(HtmlInputText comp_ui_m_ref_no) {
		COMP_UI_M_REF_NO = comp_ui_m_ref_no;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		prepareDropDowns();
	}

	private void prepareDropDowns() {
		List<SelectItem> itemsList1 = new ArrayList<SelectItem>();
		itemsList1.add(new SelectItem("ML", "Mortgage Loan"));
		itemsList1.add(new SelectItem("P", "Premium"));
		itemsList1.add(new SelectItem("L", "Policy Loan"));
		setUI_M_PROC_TYPE_LIST(itemsList1);

		List<SelectItem> itemsList2 = new ArrayList<SelectItem>();
		itemsList2.add(new SelectItem("1", "Remainder 1"));
		itemsList2.add(new SelectItem("2", "Remainder 2"));
		itemsList2.add(new SelectItem("3", "Remainder 3"));
		itemsList2.add(new SelectItem("4", "Special Remainder"));
		setUI_M_PROCESS_TYPE_LIST(itemsList2);

	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(DUMMY_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_fm_label) {
		COMP_UI_M_POL_NO_FM_LABEL = comp_ui_m_pol_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText comp_ui_m_pol_no_fm) {
		COMP_UI_M_POL_NO_FM = comp_ui_m_pol_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_to_label) {
		COMP_UI_M_POL_NO_TO_LABEL = comp_ui_m_pol_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText comp_ui_m_pol_no_to) {
		COMP_UI_M_POL_NO_TO = comp_ui_m_pol_no_to;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROC_TYPE_LABEL() {
		return COMP_UI_M_PROC_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PROC_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_proc_type_label) {
		COMP_UI_M_PROC_TYPE_LABEL = comp_ui_m_proc_type_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PROC_TYPE() {
		return COMP_UI_M_PROC_TYPE;
	}

	public void setCOMP_UI_M_PROC_TYPE(HtmlSelectOneMenu comp_ui_m_proc_type) {
		COMP_UI_M_PROC_TYPE = comp_ui_m_proc_type;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TYPE_LABEL() {
		return COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_process_type_label) {
		COMP_UI_M_PROCESS_TYPE_LABEL = comp_ui_m_process_type_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PROCESS_TYPE() {
		return COMP_UI_M_PROCESS_TYPE;
	}

	public void setCOMP_UI_M_PROCESS_TYPE(
			HtmlSelectOneMenu comp_ui_m_process_type) {
		COMP_UI_M_PROCESS_TYPE = comp_ui_m_process_type;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validate_UI_M_POL_NO_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) value);
			helper.whenValidateM_POL_NO_TO(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validate_UI_M_POL_NO_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
			helper.whenValidateM_POL_NO_TO(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	
	public List<LovBean> lovPolicy(Object value){
		String code = (String) value;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String POLICY_QUERY="SELECT POL_NO FROM PT_IL_POLICY WHERE POL_APPRV_STATUS ='A' AND ROWNUM < ?";
		
		String POLICY_QUERY_LIKE =" SELECT POL_NO FROM PT_IL_POLICY WHERE POL_APPRV_STATUS ='A' AND POL_NO LIKE ? " +
									"  AND ROWNUM < ? "; 
		String query=null;
		if("*".equals(code)){
			object=new Object[]{PELConstants.suggetionRecordSize};
			query=POLICY_QUERY;
		}else{
			object=new Object[]{code+"%",PELConstants.suggetionRecordSize};
			query=POLICY_QUERY_LIKE;
		}
		suggestionList = prepareLovListPolicy(query, object);
		return suggestionList;
	}
	
	
	public List<LovBean> prepareLovListPolicy(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	

	public String processButAction() {
		try {
			helper.WHEN_BUT_PRESSED_UI_M_OK_BUT(this);
			compositeAction.getPT_REM_DTLS_ACTION_BEAN().setBlockFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PT_REM_DTLS";
	}

}

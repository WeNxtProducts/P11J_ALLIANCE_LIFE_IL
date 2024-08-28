package com.iii.pel.forms.PILP_WHA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_LABEL;
	private HtmlInputText COMP_UI_M_AGENT_FM;
	private HtmlInputText COMP_UI_M_AGENT_FM_DESC;
	private HtmlOutputLabel COMP_UI_M_AGENT_TO_LABEL;
	private HtmlInputText COMP_UI_M_AGENT_TO;
	private HtmlInputText COMP_UI_M_AGENT_TO_DESC;
	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;
	private HtmlCalendar COMP_UI_M_FM_DT;
	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;
	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlOutputLabel COMP_UI_M_WH_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_WH_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	private HtmlCommandButton COMP_UI_M_BUT_VIEWLOG;
	private HtmlCommandButton COMP_UI_M_BUT_VIE_PROCESS;

	private DUMMY DUMMY_BEAN;
	DUMMY_DELEGATE delegate = null;
	DUMMY_HELPER helper = null;

	public PILP_WHA_COMPOSITE_ACTION compositeAction;

	private List<SelectItem> listUI_M_WH_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListUI_M_WH_TYPE() {
		return listUI_M_WH_TYPE;
	}

	public void setListUI_M_WH_TYPE(List<SelectItem> listUI_M_WH_TYPE) {
		this.listUI_M_WH_TYPE = listUI_M_WH_TYPE;
	}

	public DUMMY_ACTION() {
		try {
			DUMMY_BEAN = new DUMMY();
			delegate = new DUMMY_DELEGATE();
			helper = new DUMMY_HELPER();
			prepareDropDown();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Constructor", e.getMessage());
		}
	}

	private void prepareDropDown() {
		List<SelectItem> list1 = new ArrayList<SelectItem>();
		SelectItem item1 = new SelectItem("H", "Hold");
		SelectItem item2 = new SelectItem("R", "Release");
		list1.add(item1);
		list1.add(item2);

		setListUI_M_WH_TYPE(list1);

	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public void UI_M_AGENT_FM_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_AGENT_FM.setSubmittedValue("0");
		} else {
			COMP_UI_M_AGENT_FM.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateUI_M_AGENT_FM(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_AGENT_FM((String) value);
		//newly added to restrict only one agent to hold/release process
		DUMMY_BEAN.setUI_M_AGENT_TO((String) value);
		try {
			DUMMY_BEAN.setUI_M_AGENT_FM_DESC(helper.L_VAL_AGENT(DUMMY_BEAN
					.getUI_M_AGENT_FM()));
			COMP_UI_M_AGENT_FM_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validate_UI_M_WH_TYPE(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_WH_TYPE((String) value);
		try {
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void UI_M_AGENT_TO_WHEN_VALIDATE_ITEM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_AGENT_TO.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
		} else {
			COMP_UI_M_AGENT_TO.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_AGENT_TO(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_AGENT_TO((String) value);
		try {
			DUMMY_BEAN.setUI_M_AGENT_TO_DESC(helper.L_VAL_AGENT(DUMMY_BEAN
					.getUI_M_AGENT_TO()));
			COMP_UI_M_AGENT_TO_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_FM_DT((Date) value);
			helper.validateUI_M_FM_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateUI_M_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_TO_DT((Date) value);
			helper.validateUI_M_TO_DT(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public String processButAction() {
		String message = null;
		try {
			if ("H".equalsIgnoreCase(DUMMY_BEAN.getUI_M_WH_TYPE())) {
				new P9ILPK_WHA().L_AGENT_WITHHOLD(
						DUMMY_BEAN.getUI_M_AGENT_FM(), DUMMY_BEAN
								.getUI_M_AGENT_TO(),
						DUMMY_BEAN.getUI_M_FM_DT(), DUMMY_BEAN.getUI_M_TO_DT(),
						new CommonUtils().getCurrentDate());
				message = "Agents WithHold Process done successfully";
			} else if ("R".equalsIgnoreCase(DUMMY_BEAN.getUI_M_WH_TYPE())) {
				new P9ILPK_WHA().L_AGENT_RELEASE(DUMMY_BEAN.getUI_M_AGENT_FM(),
						DUMMY_BEAN.getUI_M_AGENT_TO(), DUMMY_BEAN
								.getUI_M_FM_DT(), DUMMY_BEAN.getUI_M_TO_DT(),
						new CommonUtils().getCurrentDate());
				message = "Agents Release Process done successfully";
			}

			getWarningMap().put("processButAction",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);

			

		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put("processButAction", e1.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 e1.getMessage());
		}

		return null;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenCreateRecord(DUMMY_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public ArrayList<LovBean> lovUI_M_AGENT_FM(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' "
				+ "AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection);
			if (resultSet.next()) {
				query1value = resultSet.getString(1);
			}
			/*
			 * 
			 *commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 
			 * 
			 * query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";*/
			
			
			 /*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105*/
			query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR  UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?)) AND ROWNUM < 25 ORDER BY 1";
			/*END*/
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					CommonUtils.getControlBean().getM_DIVN_CODE(),
					currentValue, currentValue, currentValue });
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> lovUI_M_AGENT_TO(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' "
				+ "AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection);
			if (resultSet.next()) {
				query1value = resultSet.getString(1);
			}
			query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					CommonUtils.getControlBean().getM_DIVN_CODE(),
					currentValue, currentValue, currentValue });
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void UI_M_AGENT_FMListener(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_AGENT_FM.setSubmittedValue("0");
		} else {
			COMP_UI_M_AGENT_FM.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void UI_M_AGENT_TOListener(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value.isEmpty()) {
			COMP_UI_M_AGENT_TO.setSubmittedValue("zzzzzzzzzzzzzzzzzzzzzz");
		} else {
			COMP_UI_M_AGENT_TO.setSubmittedValue(value);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_LABEL() {
		return COMP_UI_M_AGENT_FM_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_LABEL(
			HtmlOutputLabel comp_ui_m_AGENT_FM_label) {
		COMP_UI_M_AGENT_FM_LABEL = comp_ui_m_AGENT_FM_label;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM() {
		return COMP_UI_M_AGENT_FM;
	}

	public void setCOMP_UI_M_AGENT_FM(HtmlInputText comp_ui_m_AGENT_FM) {
		COMP_UI_M_AGENT_FM = comp_ui_m_AGENT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_LABEL() {
		return COMP_UI_M_AGENT_TO_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_LABEL(
			HtmlOutputLabel comp_ui_m_AGENT_TO_label) {
		COMP_UI_M_AGENT_TO_LABEL = comp_ui_m_AGENT_TO_label;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO() {
		return COMP_UI_M_AGENT_TO;
	}

	public void setCOMP_UI_M_AGENT_TO(HtmlInputText comp_ui_m_AGENT_TO) {
		COMP_UI_M_AGENT_TO = comp_ui_m_AGENT_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DT_LABEL() {
		return COMP_UI_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_FM_DT_LABEL(HtmlOutputLabel comp_ui_m_fm_dt_label) {
		COMP_UI_M_FM_DT_LABEL = comp_ui_m_fm_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar comp_ui_m_fm_dt) {
		COMP_UI_M_FM_DT = comp_ui_m_fm_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DT_LABEL() {
		return COMP_UI_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TO_DT_LABEL(HtmlOutputLabel comp_ui_m_to_dt_label) {
		COMP_UI_M_TO_DT_LABEL = comp_ui_m_to_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar comp_ui_m_to_dt) {
		COMP_UI_M_TO_DT = comp_ui_m_to_dt;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_DESC() {
		return COMP_UI_M_AGENT_FM_DESC;
	}

	public void setCOMP_UI_M_AGENT_FM_DESC(HtmlInputText comp_ui_m_AGENT_FM_desc) {
		COMP_UI_M_AGENT_FM_DESC = comp_ui_m_AGENT_FM_desc;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_DESC() {
		return COMP_UI_M_AGENT_TO_DESC;
	}

	public void setCOMP_UI_M_AGENT_TO_DESC(HtmlInputText comp_ui_m_AGENT_TO_desc) {
		COMP_UI_M_AGENT_TO_DESC = comp_ui_m_AGENT_TO_desc;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_VIEWLOG() {
		return COMP_UI_M_BUT_VIEWLOG;
	}

	public void setCOMP_UI_M_BUT_VIEWLOG(HtmlCommandButton comp_ui_m_but_viewlog) {
		COMP_UI_M_BUT_VIEWLOG = comp_ui_m_but_viewlog;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_VIE_PROCESS() {
		return COMP_UI_M_BUT_VIE_PROCESS;
	}

	public void setCOMP_UI_M_BUT_VIE_PROCESS(
			HtmlCommandButton comp_ui_m_but_vie_process) {
		COMP_UI_M_BUT_VIE_PROCESS = comp_ui_m_but_vie_process;
	}

	public HtmlOutputLabel getCOMP_UI_M_WH_TYPE_LABEL() {
		return COMP_UI_M_WH_TYPE_LABEL;
	}

	public void setCOMP_UI_M_WH_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_wh_type_label) {
		COMP_UI_M_WH_TYPE_LABEL = comp_ui_m_wh_type_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_WH_TYPE() {
		return COMP_UI_M_WH_TYPE;
	}

	public void setCOMP_UI_M_WH_TYPE(HtmlSelectOneMenu comp_ui_m_wh_type) {
		COMP_UI_M_WH_TYPE = comp_ui_m_wh_type;
	}

}

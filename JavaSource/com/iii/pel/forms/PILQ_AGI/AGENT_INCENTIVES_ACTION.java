package com.iii.pel.forms.PILQ_AGI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class AGENT_INCENTIVES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_AGENT_CODE_LABEL;
	private HtmlInputText COMP_AGENT_CODE;

	private HtmlAjaxCommandButton COMP_BUT_QUERY;

	private HtmlOutputLabel COMP_UI_M_EFF_FM_DT_LABEL;
	private HtmlOutputLabel COMP_UI_M_EFF_TO_DT_LABEL;
	private HtmlOutputLabel COMP_AGENT_TRGT_LABEL;

	private HtmlCalendar COMP_UI_M_EFF_FM_DT;
	private HtmlCalendar COMP_UI_M_EFF_TO_DT;

	private HtmlOutputLabel COMP_AGENT_PERIOD_LABEL;
	private HtmlSelectOneMenu COMP_AGENT_PERIOD;

	private HtmlOutputText COMP_AGENT_TRGT;

	private AGENT_INCENTIVES AGENT_INCENTIVES_BEAN;
	AGENT_INCENTIVES_DELEGATE delegate = null;
	AGENT_INCENTIVES_HELPER helper = null;

	public PILQ_AGI_COMPOSITE_ACTION compositeAction;

	private List<SelectItem> listAGENT_PERIOD = new ArrayList<SelectItem>();

	public List<SelectItem> getListAGENT_PERIOD() {
		return listAGENT_PERIOD;
	}

	public void setListAGENT_PERIOD(List<SelectItem> listAGENT_PERIOD) {
		this.listAGENT_PERIOD = listAGENT_PERIOD;
	}

	public AGENT_INCENTIVES_ACTION() {
		try {
			AGENT_INCENTIVES_BEAN = new AGENT_INCENTIVES();
			delegate = new AGENT_INCENTIVES_DELEGATE();
			helper = new AGENT_INCENTIVES_HELPER();
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
		SelectItem item1 = new SelectItem("N", "--None--");
		SelectItem item2 = new SelectItem("M", "Monthly");
		SelectItem item3 = new SelectItem("Q", "Quaterly");
		SelectItem item4 = new SelectItem("H", "HalfYearly");
		SelectItem item5 = new SelectItem("Y", "Yearly");

		list1.add(item1);
		list1.add(item2);
		list1.add(item3);
		list1.add(item4);
		list1.add(item5);

		setListAGENT_PERIOD(list1);

	}

	public AGENT_INCENTIVES getAGENT_INCENTIVES_BEAN() {
		return AGENT_INCENTIVES_BEAN;
	}

	public void setAGENT_INCENTIVES_BEAN(AGENT_INCENTIVES AGENT_INCENTIVES_BEAN) {
		this.AGENT_INCENTIVES_BEAN = AGENT_INCENTIVES_BEAN;
	}

	public String queryButAction() {
		String message = null;
		List<OracleParameter> retList = new ArrayList<OracleParameter>();
		Double incTarget = AGENT_INCENTIVES_BEAN.getAGENT_TRGT();

		try {
			if (!(retList.isEmpty()) && retList.size() > 0) {
				retList.clear();
			}
			retList = new PKG_AGENT_INCENVIVES().P_CALC_AGNT_INCENTIVES(
					AGENT_INCENTIVES_BEAN.getAGENT_CODE(),
					AGENT_INCENTIVES_BEAN.getUI_M_EFF_FM_DT(),
					AGENT_INCENTIVES_BEAN.getUI_M_EFF_TO_DT(), null, null,
					null, null, null, null, null, null, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null,
					null);

			if (!retList.isEmpty() && (retList.size() > 0)) {
				Double acqIncVal = (Double) retList.get(22).getValueObject();
				if (("N".equalsIgnoreCase(AGENT_INCENTIVES_BEAN
						.getAGENT_PERIOD()))
						|| (acqIncVal >= incTarget)) {
					if (retList.get(0) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_NOP_UNITS((Integer) retList.get(0)
										.getValueObject());
					}
					if (retList.get(1) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_AAD_UNITS((Integer) retList.get(1)
										.getValueObject());
					}
					if (retList.get(2) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_RCG_UNITS((Integer) retList.get(2)
										.getValueObject());
					}
					if (retList.get(3) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TAINB_UNITS((Integer) retList.get(3)
										.getValueObject());
					}
					if (retList.get(4) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_NOP_WEIGHTAGE((Double) retList.get(4)
										.getValueObject());
					}
					if (retList.get(5) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_AAD_WEIGHTAGE((Double) retList.get(5)
										.getValueObject());
					}
					if (retList.get(6) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_RCG_WEIGHTAGE((Double) retList.get(6)
										.getValueObject());
					}
					if (retList.get(7) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TAINB_WEIGHTAGE((Double) retList
										.get(7).getValueObject());
					}
					if (retList.get(8) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_NO_OF_POLICIES((Integer) retList
										.get(8).getValueObject());
					}
					if (retList.get(9) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_NO_OF_ACTIVE_AGENTS((Integer) retList
										.get(9).getValueObject());
					}
					if (retList.get(10) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_REN_COLLECTION((Double) retList
										.get(10).getValueObject());
					}
					if (retList.get(11) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_NO_OF_AGENTS_BOOK((Integer) retList
										.get(11).getValueObject());
					}
					if (retList.get(12) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_NOP_SCORE((Double) retList.get(12)
										.getValueObject());
					}
					if (retList.get(13) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_AAG_SCORE((Double) retList.get(13)
										.getValueObject());
					}
					if (retList.get(14) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_RCF_SCORE((Double) retList.get(14)
										.getValueObject());
					}
					if (retList.get(15) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TAIB_SCORE((Double) retList.get(15)
										.getValueObject());
					}
					if (retList.get(16) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_BSC_PERC((Double) retList.get(16)
										.getValueObject());
					}
					if (retList.get(17) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_TEAM_COMM_UNITS((Double) retList
										.get(17).getValueObject());
					}
					if (retList.get(18) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_DIRECT_REN_PREM_UNITS((Double) retList
										.get(18).getValueObject());
					}
					if (retList.get(19) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_TEAM_COMM((Double) retList.get(19)
										.getValueObject());
					}
					if (retList.get(20) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_PERSISTANCY((Double) retList.get(20)
										.getValueObject());
					}
					if (retList.get(21) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_DIRECT_REN_PREM((Double) retList.get(
										21).getValueObject());
					}
					if (retList.get(22) != null) {
						AGENT_INCENTIVES_BEAN
								.setUI_M_TOT_INCENTIV((Double) retList.get(22)
										.getValueObject());
					}
					getCOMP_AGENT_TRGT_LABEL().setStyle(
							"font-weight: bold;color: green;");
				} else {
					getCOMP_AGENT_TRGT_LABEL().setStyle(
							"font-weight: bold;color: red;");
					throw new Exception("Agent Not Eligible For Incentives.");
				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e1.getMessage());
			getErrorMap().put("queryButAction", e1.getMessage());

		}

		return null;
	}

	public String resetButAction() {
		getCOMP_AGENT_TRGT_LABEL().setStyleClass("boldbluelabel");
		AGENT_INCENTIVES_BEAN = new AGENT_INCENTIVES();
		compositeAction.getAGENT_INCENTIVES_ACTION_BEAN()
				.setAGENT_INCENTIVES_BEAN(AGENT_INCENTIVES_BEAN);

		return null;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.preForm(this);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public ArrayList<LovBean> lovAGENT_CODE(Object object) {
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

	public void validator_AGENT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			AGENT_INCENTIVES_BEAN.setAGENT_CODE((String) value);
			if (!(helper.validateAgent(AGENT_INCENTIVES_BEAN.getAGENT_CODE()))) {
				throw new Exception(
						"Incentive is not applicable for this agent level.");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validator_UI_M_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			AGENT_INCENTIVES_BEAN.setUI_M_EFF_FM_DT((Date) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validator_UI_M_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			AGENT_INCENTIVES_BEAN.setUI_M_EFF_TO_DT((Date) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validator_AGENT_PERIOD(FacesContext context,
			UIComponent component, Object value) {
		Date effFmDt = null;
		Date effToDt = null;
		CommonUtils commonutils = new CommonUtils();
		try {
			AGENT_INCENTIVES_BEAN.setAGENT_PERIOD((String) value);

			if ("M".equalsIgnoreCase(AGENT_INCENTIVES_BEAN.getAGENT_PERIOD())) {
				effToDt = commonutils.getCurrentDate();
				effFmDt = CommonUtils.addMonthsToDate(effToDt, -1);
			}
			if ("Q".equalsIgnoreCase(AGENT_INCENTIVES_BEAN.getAGENT_PERIOD())) {
				effToDt = commonutils.getCurrentDate();
				effFmDt = CommonUtils.addMonthsToDate(effToDt, -3);
			}
			if ("H".equalsIgnoreCase(AGENT_INCENTIVES_BEAN.getAGENT_PERIOD())) {
				effToDt = commonutils.getCurrentDate();
				effFmDt = CommonUtils.addMonthsToDate(effToDt, -6);
			}
			if ("Y".equalsIgnoreCase(AGENT_INCENTIVES_BEAN.getAGENT_PERIOD())) {
				effToDt = commonutils.getCurrentDate();
				effFmDt = CommonUtils.addMonthsToDate(effToDt, -12);
			}

			if (!("N".equalsIgnoreCase(AGENT_INCENTIVES_BEAN.getAGENT_PERIOD()))) {
				Double tagrgetVal = helper.getTargetOfAgent(
						AGENT_INCENTIVES_BEAN.getAGENT_PERIOD(),
						AGENT_INCENTIVES_BEAN.getAGENT_CODE());
				AGENT_INCENTIVES_BEAN.setAGENT_TRGT(tagrgetVal);
				AGENT_INCENTIVES_BEAN.setUI_M_EFF_FM_DT(effFmDt);
				AGENT_INCENTIVES_BEAN.setUI_M_EFF_TO_DT(effToDt);

				this.getCOMP_UI_M_EFF_FM_DT().setDisabled(true);
				this.getCOMP_UI_M_EFF_TO_DT().setDisabled(true);

			} else {
				AGENT_INCENTIVES_BEAN.setAGENT_TRGT(null);
				AGENT_INCENTIVES_BEAN.setUI_M_EFF_FM_DT(null);
				AGENT_INCENTIVES_BEAN.setUI_M_EFF_TO_DT(null);

				this.getCOMP_UI_M_EFF_FM_DT().setDisabled(false);
				this.getCOMP_UI_M_EFF_TO_DT().setDisabled(false);
			}

			COMP_AGENT_TRGT.setValue(AGENT_INCENTIVES_BEAN.getAGENT_TRGT());
			COMP_UI_M_EFF_FM_DT.resetValue();
			COMP_UI_M_EFF_TO_DT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_AGENT_CODE_LABEL() {
		return COMP_AGENT_CODE_LABEL;
	}

	public void setCOMP_AGENT_CODE_LABEL(HtmlOutputLabel comp_agent_code_label) {
		COMP_AGENT_CODE_LABEL = comp_agent_code_label;
	}

	public HtmlInputText getCOMP_AGENT_CODE() {
		return COMP_AGENT_CODE;
	}

	public void setCOMP_AGENT_CODE(HtmlInputText comp_agent_code) {
		COMP_AGENT_CODE = comp_agent_code;
	}

	public HtmlAjaxCommandButton getCOMP_BUT_QUERY() {
		return COMP_BUT_QUERY;
	}

	public void setCOMP_BUT_QUERY(HtmlAjaxCommandButton comp_but_query) {
		COMP_BUT_QUERY = comp_but_query;
	}

	public HtmlOutputLabel getCOMP_UI_M_EFF_FM_DT_LABEL() {
		return COMP_UI_M_EFF_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_EFF_FM_DT_LABEL(
			HtmlOutputLabel comp_ui_m_eff_fm_dt_label) {
		COMP_UI_M_EFF_FM_DT_LABEL = comp_ui_m_eff_fm_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_EFF_TO_DT_LABEL() {
		return COMP_UI_M_EFF_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_EFF_TO_DT_LABEL(
			HtmlOutputLabel comp_ui_m_eff_to_dt_label) {
		COMP_UI_M_EFF_TO_DT_LABEL = comp_ui_m_eff_to_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_EFF_FM_DT() {
		return COMP_UI_M_EFF_FM_DT;
	}

	public void setCOMP_UI_M_EFF_FM_DT(HtmlCalendar comp_ui_m_eff_fm_dt) {
		COMP_UI_M_EFF_FM_DT = comp_ui_m_eff_fm_dt;
	}

	public HtmlCalendar getCOMP_UI_M_EFF_TO_DT() {
		return COMP_UI_M_EFF_TO_DT;
	}

	public void setCOMP_UI_M_EFF_TO_DT(HtmlCalendar comp_ui_m_eff_to_dt) {
		COMP_UI_M_EFF_TO_DT = comp_ui_m_eff_to_dt;
	}

	public HtmlOutputLabel getCOMP_AGENT_PERIOD_LABEL() {
		return COMP_AGENT_PERIOD_LABEL;
	}

	public void setCOMP_AGENT_PERIOD_LABEL(
			HtmlOutputLabel comp_agent_period_label) {
		COMP_AGENT_PERIOD_LABEL = comp_agent_period_label;
	}

	public HtmlSelectOneMenu getCOMP_AGENT_PERIOD() {
		return COMP_AGENT_PERIOD;
	}

	public void setCOMP_AGENT_PERIOD(HtmlSelectOneMenu comp_agent_period) {
		COMP_AGENT_PERIOD = comp_agent_period;
	}

	public HtmlOutputText getCOMP_AGENT_TRGT() {
		return COMP_AGENT_TRGT;
	}

	public void setCOMP_AGENT_TRGT(HtmlOutputText comp_agent_trgt) {
		COMP_AGENT_TRGT = comp_agent_trgt;
	}

	public HtmlOutputLabel getCOMP_AGENT_TRGT_LABEL() {
		return COMP_AGENT_TRGT_LABEL;
	}

	public void setCOMP_AGENT_TRGT_LABEL(HtmlOutputLabel comp_agent_trgt_label) {
		COMP_AGENT_TRGT_LABEL = comp_agent_trgt_label;
	}

}

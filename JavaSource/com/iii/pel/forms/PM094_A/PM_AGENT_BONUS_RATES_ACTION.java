package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BONUS_RATES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABR_YTD_FYC_FM_LABEL;

	private HtmlInputText COMP_ABR_YTD_FYC_FM;

	private HtmlOutputLabel COMP_ABR_YTD_FYC_TO_LABEL;

	private HtmlInputText COMP_ABR_YTD_FYC_TO;

	private HtmlOutputLabel COMP_ABR_NO_OF_POL_FM_LABEL;

	private HtmlInputText COMP_ABR_NO_OF_POL_FM;

	private HtmlOutputLabel COMP_ABR_NO_OF_POL_TO_LABEL;

	private HtmlInputText COMP_ABR_NO_OF_POL_TO;

	private HtmlOutputLabel COMP_ABR_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_ABR_PERIOD;

	private HtmlOutputLabel COMP_ABR_RATE_LABEL;

	private HtmlInputText COMP_ABR_RATE;

	private HtmlOutputLabel COMP_ABR_RATE_PER_LABEL;

	private HtmlInputText COMP_ABR_RATE_PER;

	private HtmlOutputLabel COMP_ABR_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_ABR_EFF_FM_DT;

	private HtmlOutputLabel COMP_ABR_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_ABR_EFF_TO_DT;

	private HtmlOutputLabel COMP_UI_M_ABR_RANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ABR_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ABR_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABR_RANK_CODE_DESC;

	private PM_AGENT_BONUS_RATES PM_AGENT_BONUS_RATES_BEAN;

	private List<PM_AGENT_BONUS_RATES> dataList_PM_AGENT_BONUS_RATES = new ArrayList<PM_AGENT_BONUS_RATES>();

	private UIData dataTable;

	private List codeList = new ArrayList();

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private List<SelectItem> periodList = new ArrayList<SelectItem>();

	PM_AGENT_BONUS_RATES_DELEGATE delegate = new PM_AGENT_BONUS_RATES_DELEGATE();

	PM_AGENT_BONUS_RATES_HELPER helper = new PM_AGENT_BONUS_RATES_HELPER();
	
	private PM_AGENT_BONUS_APPL_RANKS parentApplRanksValueBean;
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction;


	public PM_AGENT_BONUS_RATES_ACTION() {
		PM_AGENT_BONUS_RATES_BEAN = new PM_AGENT_BONUS_RATES();
		prevRowIndex = 0;
		currentpage = 1;
		periodList = delegate.comboBoxValues("PM094_A", "PM_AGENT_BONUS_RATES",
				"PM_AGENT_BONUS_RATES.ABR_PERIOD", "QUARTER_DEFN");
		/*Modified by ganesh on 02-06-2018 as suggested by sivaram*/
		instantiateAllComponent();
		ABR_APPLIED_ON_ITEMS = delegate.comboBoxValues("PM094_A", "PM_AGENT_BONUS_RATES",
				"PM_AGENT_BONUS_RATES.ABR_APPLIED_ON", "IL_BON_CAL");
		
		/*end*/
	}

	/*public void gridtabListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_AGENT_BONUS_RATES gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_AGENT_BONUS_RATES) dataList_PM_AGENT_BONUS_RATES
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Updated");
						} else {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;
	}*/

	public void lastColumnListener() throws Exception {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_AGENT_BONUS_RATES gridValueBean = null;
		try {

			// Get the bean based on row index
			gridValueBean = (PM_AGENT_BONUS_RATES) dataList_PM_AGENT_BONUS_RATES
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				//helper.pre_update(gridValueBean);
				gridValueBean.setABR_UPD_DT(new Date());
				gridValueBean.setABR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {
				Map sessionmap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				//helper.pre_insert(gridValueBean);
				gridValueBean.setABR_CR_DT(new Date());
				gridValueBean.setABR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			//e1.printStackTrace();
			//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
			//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e1.getMessage());
			throw e1;
		}
		return;
	}

	public String addNew() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;
		if (dataList_PM_AGENT_BONUS_RATES == null) {
			dataList_PM_AGENT_BONUS_RATES = new ArrayList<PM_AGENT_BONUS_RATES>();
		}
		PM_AGENT_BONUS_RATES pm_agent_bonus_rates=new PM_AGENT_BONUS_RATES();
		System.out.println("Abs Code :"+getParentApplRanksValueBean().getABAR_ABS_CODE());
		System.out.println("Rank Code :"+getParentApplRanksValueBean().getABAR_RANK_CODE());
		pm_agent_bonus_rates.setABR_ABS_CODE(getParentApplRanksValueBean().getABAR_ABS_CODE());
		pm_agent_bonus_rates.setABR_RANK_CODE(getParentApplRanksValueBean().getABAR_RANK_CODE());
		helper.whenCreateRecord(pm_agent_bonus_rates);
		dataList_PM_AGENT_BONUS_RATES.add(pm_agent_bonus_rates);
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "newadded";
	}

	public String deleteRow() {
		System.out.println("IN THE DELETE" + dataList_PM_AGENT_BONUS_RATES);
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_AGENT_BONUS_RATES bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataList_PM_AGENT_BONUS_RATES != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataList_PM_AGENT_BONUS_RATES.size();) {
				bean = dataList_PM_AGENT_BONUS_RATES.get(index);
				System.out.println("bean selected:::");

				if (bean.isSelected()) {
					System.out.println("Inside Loop");
					dataList_PM_AGENT_BONUS_RATES.remove(bean);
					deletedRecordIndex = delegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current", "Record Deleted");
			}
			lastUpdateRowIndex = -1;

		}

		return "";
	}

	public void saveData() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public List suggestionAction(Object obj) {
		String code = (String) obj;
		codeList = delegate.getCodeList(code, codeList);
		return codeList;
	}

	public void getCodeDesc(ActionEvent event) {
		COMP_UI_M_ABR_RANK_CODE_DESC.setSubmittedValue(null);
		if (COMP_UI_M_ABR_RANK_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_UI_M_ABR_RANK_CODE.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, codeList);
			int rowIndex = getDataTable().getRowIndex();
			PM_AGENT_BONUS_RATES pm_agent_bonus_rates = dataList_PM_AGENT_BONUS_RATES
					.get(rowIndex);
			pm_agent_bonus_rates.setUI_M_ABR_RANK_CODE_DESC(codeDesc);

		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateABR_YTD_FYC_FM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		if (COMP_ABR_YTD_FYC_FM.getSubmittedValue() != null) {
			double ABR_YTD_FYC_FM = Double
					.parseDouble((String) COMP_ABR_YTD_FYC_FM
							.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_YTD_FYC_FM(ABR_YTD_FYC_FM);
			helper.validateABR_YTD_FYC_FM(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateABR_YTD_FYC_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		if (COMP_ABR_YTD_FYC_TO.getSubmittedValue() != null) {
			double ABR_YTD_FYC_TO = Double
					.parseDouble((String) COMP_ABR_YTD_FYC_TO
							.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_YTD_FYC_TO(ABR_YTD_FYC_TO);
			helper.validateABR_YTD_FYC_TO(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateABR_NO_OF_POL_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try{
		if (COMP_ABR_NO_OF_POL_FM.getSubmittedValue() != null) {
			Integer ABR_NO_OF_POL_FM = Integer
					.parseInt((String) COMP_ABR_NO_OF_POL_FM
							.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_NO_OF_POL_FM(ABR_NO_OF_POL_FM);
			helper.validateABR_NO_OF_POL_FM(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateABR_NO_OF_POL_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try{
		if (COMP_ABR_NO_OF_POL_TO.getSubmittedValue() != null) {
			Integer ABR_NO_OF_POL_TO = Integer
					.parseInt((String) COMP_ABR_NO_OF_POL_TO
							.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_NO_OF_POL_TO(ABR_NO_OF_POL_TO);
			helper.validateABR_NO_OF_POL_TO(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateABR_PERIOD(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
			try{
			String ABR_PERIOD = (String) value;
			PM_AGENT_BONUS_RATES_BEAN.setABR_PERIOD(ABR_PERIOD);
			helper.validateABR_PERIOD(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
			}catch (Exception e) {
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

	public void validateABR_RATE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		if (COMP_ABR_RATE.getSubmittedValue() != null) {
			double ABR_RATE = Double.parseDouble((String) COMP_ABR_RATE
					.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_RATE(ABR_RATE);
			helper.validateABR_RATE(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateABR_RATE_PER(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		if (COMP_ABR_RATE_PER.getSubmittedValue() != null) {
			double ABR_RATE_PER = Double.parseDouble((String) COMP_ABR_RATE_PER
					.getSubmittedValue());
			PM_AGENT_BONUS_RATES_BEAN.setABR_RATE_PER(ABR_RATE_PER);
			helper.validateABR_RATE_PER(PM_AGENT_BONUS_RATES_BEAN);
//			gridtabListener();Commented During Grid Implementation
		}
		}catch (Exception e) {
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

	public void validateEFF_FM_DT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date fromDate = htmlCalendar
				.getAsDate(htmlCalendar.getSubmittedValue());
		PM_AGENT_BONUS_RATES_BEAN.setABR_EFF_FM_DT(fromDate);
		helper.validateABR_EFF_FM_DT(PM_AGENT_BONUS_RATES_BEAN);
//		gridtabListener();Commented During Grid Implementation
		}catch (Exception e) {
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

	public void validateEFF_TO_DT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date toDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
		PM_AGENT_BONUS_RATES_BEAN.setABR_EFF_TO_DT(toDate);
		helper.validateABR_EFF_TO_DT(PM_AGENT_BONUS_RATES_BEAN);
//		lastColumnListener();
		}catch (Exception e) {
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

	public void selectedCheckbox(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}

		PM_AGENT_BONUS_RATES pm_agent_bonus_rates = dataList_PM_AGENT_BONUS_RATES
				.get(row);

		if (selected.equals("true"))
			pm_agent_bonus_rates.setSelected(true);
		else
			pm_agent_bonus_rates.setSelected(false);

	}

	public String backToHeader() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "agentbonusapplranks";
	}

	public HtmlOutputLabel getCOMP_ABR_YTD_FYC_FM_LABEL() {
		return COMP_ABR_YTD_FYC_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABR_YTD_FYC_FM() {
		return COMP_ABR_YTD_FYC_FM;
	}

	public void setCOMP_ABR_YTD_FYC_FM_LABEL(
			HtmlOutputLabel COMP_ABR_YTD_FYC_FM_LABEL) {
		this.COMP_ABR_YTD_FYC_FM_LABEL = COMP_ABR_YTD_FYC_FM_LABEL;
	}

	public void setCOMP_ABR_YTD_FYC_FM(HtmlInputText COMP_ABR_YTD_FYC_FM) {
		this.COMP_ABR_YTD_FYC_FM = COMP_ABR_YTD_FYC_FM;
	}

	public HtmlOutputLabel getCOMP_ABR_YTD_FYC_TO_LABEL() {
		return COMP_ABR_YTD_FYC_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABR_YTD_FYC_TO() {
		return COMP_ABR_YTD_FYC_TO;
	}

	public void setCOMP_ABR_YTD_FYC_TO_LABEL(
			HtmlOutputLabel COMP_ABR_YTD_FYC_TO_LABEL) {
		this.COMP_ABR_YTD_FYC_TO_LABEL = COMP_ABR_YTD_FYC_TO_LABEL;
	}

	public void setCOMP_ABR_YTD_FYC_TO(HtmlInputText COMP_ABR_YTD_FYC_TO) {
		this.COMP_ABR_YTD_FYC_TO = COMP_ABR_YTD_FYC_TO;
	}

	public HtmlOutputLabel getCOMP_ABR_NO_OF_POL_FM_LABEL() {
		return COMP_ABR_NO_OF_POL_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABR_NO_OF_POL_FM() {
		return COMP_ABR_NO_OF_POL_FM;
	}

	public void setCOMP_ABR_NO_OF_POL_FM_LABEL(
			HtmlOutputLabel COMP_ABR_NO_OF_POL_FM_LABEL) {
		this.COMP_ABR_NO_OF_POL_FM_LABEL = COMP_ABR_NO_OF_POL_FM_LABEL;
	}

	public void setCOMP_ABR_NO_OF_POL_FM(HtmlInputText COMP_ABR_NO_OF_POL_FM) {
		this.COMP_ABR_NO_OF_POL_FM = COMP_ABR_NO_OF_POL_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABR_RANK_CODE_LABEL() {
		return COMP_UI_M_ABR_RANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_ABR_RANK_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_abr_rank_code_label) {
		COMP_UI_M_ABR_RANK_CODE_LABEL = comp_ui_m_abr_rank_code_label;
	}

	public HtmlInputText getCOMP_UI_M_ABR_RANK_CODE() {
		return COMP_UI_M_ABR_RANK_CODE;
	}

	public void setCOMP_UI_M_ABR_RANK_CODE(HtmlInputText comp_ui_m_abr_rank_code) {
		COMP_UI_M_ABR_RANK_CODE = comp_ui_m_abr_rank_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABR_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_ABR_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABR_RANK_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_abr_rank_code_desc_label) {
		COMP_UI_M_ABR_RANK_CODE_DESC_LABEL = comp_ui_m_abr_rank_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_ABR_RANK_CODE_DESC() {
		return COMP_UI_M_ABR_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_ABR_RANK_CODE_DESC(
			HtmlInputText comp_ui_m_abr_rank_code_desc) {
		COMP_UI_M_ABR_RANK_CODE_DESC = comp_ui_m_abr_rank_code_desc;
	}

	public HtmlOutputLabel getCOMP_ABR_NO_OF_POL_TO_LABEL() {
		return COMP_ABR_NO_OF_POL_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABR_NO_OF_POL_TO() {
		return COMP_ABR_NO_OF_POL_TO;
	}

	public void setCOMP_ABR_NO_OF_POL_TO_LABEL(
			HtmlOutputLabel COMP_ABR_NO_OF_POL_TO_LABEL) {
		this.COMP_ABR_NO_OF_POL_TO_LABEL = COMP_ABR_NO_OF_POL_TO_LABEL;
	}

	public void setCOMP_ABR_NO_OF_POL_TO(HtmlInputText COMP_ABR_NO_OF_POL_TO) {
		this.COMP_ABR_NO_OF_POL_TO = COMP_ABR_NO_OF_POL_TO;
	}

	public HtmlOutputLabel getCOMP_ABR_PERIOD_LABEL() {
		return COMP_ABR_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABR_PERIOD() {
		return COMP_ABR_PERIOD;
	}

	public void setCOMP_ABR_PERIOD_LABEL(HtmlOutputLabel COMP_ABR_PERIOD_LABEL) {
		this.COMP_ABR_PERIOD_LABEL = COMP_ABR_PERIOD_LABEL;
	}

	public void setCOMP_ABR_PERIOD(HtmlSelectOneMenu COMP_ABR_PERIOD) {
		this.COMP_ABR_PERIOD = COMP_ABR_PERIOD;
	}

	public HtmlOutputLabel getCOMP_ABR_RATE_LABEL() {
		return COMP_ABR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_ABR_RATE() {
		return COMP_ABR_RATE;
	}

	public void setCOMP_ABR_RATE_LABEL(HtmlOutputLabel COMP_ABR_RATE_LABEL) {
		this.COMP_ABR_RATE_LABEL = COMP_ABR_RATE_LABEL;
	}

	public void setCOMP_ABR_RATE(HtmlInputText COMP_ABR_RATE) {
		this.COMP_ABR_RATE = COMP_ABR_RATE;
	}

	public HtmlOutputLabel getCOMP_ABR_RATE_PER_LABEL() {
		return COMP_ABR_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_ABR_RATE_PER() {
		return COMP_ABR_RATE_PER;
	}

	public void setCOMP_ABR_RATE_PER_LABEL(
			HtmlOutputLabel COMP_ABR_RATE_PER_LABEL) {
		this.COMP_ABR_RATE_PER_LABEL = COMP_ABR_RATE_PER_LABEL;
	}

	public void setCOMP_ABR_RATE_PER(HtmlInputText COMP_ABR_RATE_PER) {
		this.COMP_ABR_RATE_PER = COMP_ABR_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_ABR_EFF_FM_DT_LABEL() {
		return COMP_ABR_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABR_EFF_FM_DT() {
		return COMP_ABR_EFF_FM_DT;
	}

	public void setCOMP_ABR_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_ABR_EFF_FM_DT_LABEL) {
		this.COMP_ABR_EFF_FM_DT_LABEL = COMP_ABR_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ABR_EFF_FM_DT(HtmlCalendar COMP_ABR_EFF_FM_DT) {
		this.COMP_ABR_EFF_FM_DT = COMP_ABR_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ABR_EFF_TO_DT_LABEL() {
		return COMP_ABR_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABR_EFF_TO_DT() {
		return COMP_ABR_EFF_TO_DT;
	}

	public void setCOMP_ABR_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_ABR_EFF_TO_DT_LABEL) {
		this.COMP_ABR_EFF_TO_DT_LABEL = COMP_ABR_EFF_TO_DT_LABEL;
	}

	public void setCOMP_ABR_EFF_TO_DT(HtmlCalendar COMP_ABR_EFF_TO_DT) {
		this.COMP_ABR_EFF_TO_DT = COMP_ABR_EFF_TO_DT;
	}

	public PM_AGENT_BONUS_RATES getPM_AGENT_BONUS_RATES_BEAN() {
		return PM_AGENT_BONUS_RATES_BEAN;
	}

	public void setPM_AGENT_BONUS_RATES_BEAN(
			PM_AGENT_BONUS_RATES PM_AGENT_BONUS_RATES_BEAN) {
		this.PM_AGENT_BONUS_RATES_BEAN = PM_AGENT_BONUS_RATES_BEAN;
	}

	public List<PM_AGENT_BONUS_RATES> getDataList_PM_AGENT_BONUS_RATES() {
		return dataList_PM_AGENT_BONUS_RATES;
	}

	public void setDataListPM_AGENT_BONUS_RATES(
			List<PM_AGENT_BONUS_RATES> dataList_PM_AGENT_BONUS_RATES) {
		this.dataList_PM_AGENT_BONUS_RATES = dataList_PM_AGENT_BONUS_RATES;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getRecordsperPage() {
		return recordsperPage;
	}

	public void setRecordsperPage(int recordsperPage) {
		this.recordsperPage = recordsperPage;
	}

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}

	public void setDataList_PM_AGENT_BONUS_RATES(
			List<PM_AGENT_BONUS_RATES> dataList_PM_AGENT_BONUS_RATES) {
		this.dataList_PM_AGENT_BONUS_RATES = dataList_PM_AGENT_BONUS_RATES;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}

	public List<SelectItem> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<SelectItem> periodList) {
		this.periodList = periodList;
	}

	public void loadBonusRates(HashMap<String, String> errorMap,PM_AGENT_BONUS_APPL_RANKS applRanksValueBean) {
		PM_AGENT_BONUS_RATES_HELPER helper = new PM_AGENT_BONUS_RATES_HELPER();
		String message = null;
		
		try {
			dataList_PM_AGENT_BONUS_RATES = new ArrayList<PM_AGENT_BONUS_RATES>();
			prevRowIndex = 0;
			//currPage = 1;
			setParentApplRanksValueBean(applRanksValueBean);
			helper.execute_query(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			errorMap.put("current", message);
			errorMap.put("details", message);
		}
		
	}

	public PM_AGENT_BONUS_APPL_RANKS getParentApplRanksValueBean() {
		return parentApplRanksValueBean;
	}

	public void setParentApplRanksValueBean(
			PM_AGENT_BONUS_APPL_RANKS parentApplRanksValueBean) {
		this.parentApplRanksValueBean = parentApplRanksValueBean;
	}
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated:
	// 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated:
	// 17-Feb-2009 ]
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_AGENT_BONUS_RATES_BEAN = (PM_AGENT_BONUS_RATES) dataTable
					.getRowData();
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_BONUS_RATES_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BONUS_RATES> iterator = dataList_PM_AGENT_BONUS_RATES.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent(){
		COMP_ABR_YTD_FYC_FM.resetValue();
		COMP_ABR_YTD_FYC_TO.resetValue();
		COMP_ABR_NO_OF_POL_FM.resetValue();
		COMP_ABR_NO_OF_POL_TO.resetValue();
		COMP_ABR_PERIOD.resetValue();
		COMP_ABR_RATE.resetValue();
		COMP_ABR_RATE_PER.resetValue();
		COMP_ABR_EFF_FM_DT.resetValue();
		COMP_ABR_EFF_TO_DT.resetValue();
		/*Added by ganesh on 02-06-2018 as suggested by sivaram*/
		COMP_ABR_APPLIED_ON.resetValue();
		COMP_ABR_MAX_LIMIT.resetValue();
		COMP_UI_M_ABR_FORMULA_CODE_DESC.resetValue();
		COMP_ABR_FORMULA_CODE.resetValue();
		/*end*/
		/*added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
		COMP_ABR_NO_OF_MON_FM.resetValue();
		COMP_ABR_NO_OF_MON_TO.resetValue();
		/*end*/
	}
	
	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_AGENT_BONUS_RATES_BEAN = new PM_AGENT_BONUS_RATES();
				helper.whenCreateRecord(PM_AGENT_BONUS_RATES_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_AGENT_BONUS_RATES_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_AGENT_BONUS_RATES.remove(PM_AGENT_BONUS_RATES_BEAN);
				if (dataList_PM_AGENT_BONUS_RATES.size() > 0) {

					PM_AGENT_BONUS_RATES_BEAN = dataList_PM_AGENT_BONUS_RATES
							.get(0);
				} else if (dataList_PM_AGENT_BONUS_RATES.size() == 0) {
					addRow(null);
				}

				resetAllComponent();
				PM_AGENT_BONUS_RATES_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
			

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_AGENT_BONUS_RATES_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
					helper.pre_insert(PM_AGENT_BONUS_RATES_BEAN,compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN(),
							compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().getPM_AGENT_BONUS_APPL_RANKS_BEAN());
				new CRUDHandler().executeInsert(PM_AGENT_BONUS_RATES_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_AGENT_BONUS_RATES.add(PM_AGENT_BONUS_RATES_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_AGENT_BONUS_RATES_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				helper.pre_update(PM_AGENT_BONUS_RATES_BEAN,compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN(),
						compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().getPM_AGENT_BONUS_APPL_RANKS_BEAN());
				new CRUDHandler().executeUpdate(PM_AGENT_BONUS_RATES_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			}
			PM_AGENT_BONUS_RATES_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag()){
				helper.execute_query(compositeAction);
				if(PM_AGENT_BONUS_RATES_BEAN.getROWID() != null){
				}else{
					helper.whenCreateRecord(PM_AGENT_BONUS_RATES_BEAN);
				}
				setBlockFlag(false);
			}
			/*Added by ganesh on 02-06-2018 as suggested by sivaram*/
			enableDisableAppliedON(PM_AGENT_BONUS_RATES_BEAN.getABR_APPLIED_ON());
			/*end*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/*Added by ganesh on 02-06-2018 as suggested by sivaram*/
	private List<SelectItem> ABR_APPLIED_ON_ITEMS = new ArrayList<SelectItem>();
	private HtmlInputText COMP_ABR_MAX_LIMIT;
	private HtmlSelectOneMenu COMP_ABR_APPLIED_ON;
	private HtmlInputText COMP_UI_M_ABR_FORMULA_CODE_DESC;
	private HtmlInputText COMP_ABR_FORMULA_CODE;
	
	

	public HtmlInputText getCOMP_ABR_MAX_LIMIT() {
		return COMP_ABR_MAX_LIMIT;
	}

	public void setCOMP_ABR_MAX_LIMIT(HtmlInputText cOMP_ABR_MAX_LIMIT) {
		COMP_ABR_MAX_LIMIT = cOMP_ABR_MAX_LIMIT;
	}

	public HtmlSelectOneMenu getCOMP_ABR_APPLIED_ON() {
		return COMP_ABR_APPLIED_ON;
	}

	public void setCOMP_ABR_APPLIED_ON(HtmlSelectOneMenu cOMP_ABR_APPLIED_ON) {
		COMP_ABR_APPLIED_ON = cOMP_ABR_APPLIED_ON;
	}

	

	

	public HtmlInputText getCOMP_UI_M_ABR_FORMULA_CODE_DESC() {
		return COMP_UI_M_ABR_FORMULA_CODE_DESC;
	}

	public void setCOMP_UI_M_ABR_FORMULA_CODE_DESC(
			HtmlInputText cOMP_UI_M_ABR_FORMULA_CODE_DESC) {
		COMP_UI_M_ABR_FORMULA_CODE_DESC = cOMP_UI_M_ABR_FORMULA_CODE_DESC;
	}

	public HtmlInputText getCOMP_ABR_FORMULA_CODE() {
		return COMP_ABR_FORMULA_CODE;
	}

	public void setCOMP_ABR_FORMULA_CODE(HtmlInputText cOMP_ABR_FORMULA_CODE) {
		COMP_ABR_FORMULA_CODE = cOMP_ABR_FORMULA_CODE;
	}

	public List<SelectItem> getABR_APPLIED_ON_ITEMS() {
		return ABR_APPLIED_ON_ITEMS;
	}

	public void setABR_APPLIED_ON_ITEMS(List<SelectItem> aBR_APPLIED_ON_ITEMS) {
		ABR_APPLIED_ON_ITEMS = aBR_APPLIED_ON_ITEMS;
	}
	
	

	public void instantiateAllComponent(){
		
		COMP_ABR_APPLIED_ON = new HtmlSelectOneMenu();
		COMP_ABR_RATE = new HtmlInputText();
		COMP_ABR_RATE_PER = new HtmlInputText();
		COMP_ABR_MAX_LIMIT = new HtmlInputText();
		COMP_UI_M_ABR_FORMULA_CODE_DESC = new HtmlInputText();
		COMP_ABR_FORMULA_CODE = new HtmlInputText();
		
		/*added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
		COMP_ABR_NO_OF_MON_FM = new HtmlInputText();
		COMP_ABR_NO_OF_MON_TO = new HtmlInputText();
		/*end*/
		
	}
	
	public void validateABR_MAX_LIMIT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try{
			PM_AGENT_BONUS_RATES_BEAN.setABR_MAX_LIMIT((Long)value);
			}catch (Exception e) {
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
	public void validateABR_FORMULA_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try{
			PM_AGENT_BONUS_RATES_BEAN.setABR_FORMULA_CODE((String)value);
			
			}catch (Exception e) {
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
	public void validateABR_APPLIED_ON(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try{
			PM_AGENT_BONUS_RATES_BEAN.setABR_APPLIED_ON((String)value);
			
			}catch (Exception e) {
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
	
	private List<LovBean> lovList = new ArrayList<LovBean>();
	public List<LovBean> prepareABR_FORMULA_CODE(Object value) {
		String code = (String) value;
		//List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE  " +
					"(FRM_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			lovList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("FORMULA_CODE", e.getMessage());
		}
		return lovList;
	}
	
	public List<LovBean> getLovList() {
		return lovList;
	}

	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
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
	
	public void enableDisableAppliedON(String appliedOnValue){
		
		if("F".equalsIgnoreCase(appliedOnValue)){
			
			COMP_ABR_RATE.setDisabled(true);
			COMP_ABR_RATE_PER.setDisabled(true);
			COMP_ABR_FORMULA_CODE.setDisabled(false);
			COMP_ABR_RATE.setRequired(false);
			COMP_ABR_RATE_PER.setRequired(false);
			COMP_ABR_FORMULA_CODE.setRequired(true);
			
			
		}else{
			
			COMP_ABR_RATE.setDisabled(false);
			COMP_ABR_RATE_PER.setDisabled(false);
			COMP_ABR_FORMULA_CODE.setDisabled(true);
			COMP_ABR_RATE.setRequired(true);
			COMP_ABR_RATE_PER.setRequired(true);
			COMP_ABR_FORMULA_CODE.setRequired(false);
		}
			
		
	}
	
	/*end*/
	
	public void fireFieldValidationAppliedOn(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		if("F".equalsIgnoreCase(value)){
			PM_AGENT_BONUS_RATES_BEAN.setABR_RATE(null);
			PM_AGENT_BONUS_RATES_BEAN.setABR_RATE_PER(null);
			COMP_ABR_RATE.resetValue();
			COMP_ABR_RATE_PER.resetValue();
			
		}else{
			PM_AGENT_BONUS_RATES_BEAN.setABR_FORMULA_CODE(null);
			PM_AGENT_BONUS_RATES_BEAN.setUI_M_ABR_FORMULA_CODE_DESC(null);
			COMP_ABR_FORMULA_CODE.resetValue();
			COMP_UI_M_ABR_FORMULA_CODE_DESC.resetValue();
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	private HtmlOutputLabel COMP_ABR_NO_OF_MON_FM_LABEL;
	
	private HtmlInputText COMP_ABR_NO_OF_MON_FM;
	
	private HtmlOutputLabel COMP_ABR_NO_OF_MON_TO_LABEL;
	
	private HtmlInputText COMP_ABR_NO_OF_MON_TO;


	public HtmlOutputLabel getCOMP_ABR_NO_OF_MON_FM_LABEL() {
		return COMP_ABR_NO_OF_MON_FM_LABEL;
	}

	public void setCOMP_ABR_NO_OF_MON_FM_LABEL(
			HtmlOutputLabel cOMP_ABR_NO_OF_MON_FM_LABEL) {
		COMP_ABR_NO_OF_MON_FM_LABEL = cOMP_ABR_NO_OF_MON_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABR_NO_OF_MON_FM() {
		return COMP_ABR_NO_OF_MON_FM;
	}

	public void setCOMP_ABR_NO_OF_MON_FM(HtmlInputText cOMP_ABR_NO_OF_MON_FM) {
		COMP_ABR_NO_OF_MON_FM = cOMP_ABR_NO_OF_MON_FM;
	}

	public HtmlOutputLabel getCOMP_ABR_NO_OF_MON_TO_LABEL() {
		return COMP_ABR_NO_OF_MON_TO_LABEL;
	}

	public void setCOMP_ABR_NO_OF_MON_TO_LABEL(
			HtmlOutputLabel cOMP_ABR_NO_OF_MON_TO_LABEL) {
		COMP_ABR_NO_OF_MON_TO_LABEL = cOMP_ABR_NO_OF_MON_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABR_NO_OF_MON_TO() {
		return COMP_ABR_NO_OF_MON_TO;
	}

	public void setCOMP_ABR_NO_OF_MON_TO(HtmlInputText cOMP_ABR_NO_OF_MON_TO) {
		COMP_ABR_NO_OF_MON_TO = cOMP_ABR_NO_OF_MON_TO;
	}

	public void validateABR_NO_OF_MON_FM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try{
			PM_AGENT_BONUS_RATES_BEAN.setABR_NO_OF_MON_FM((Integer)value);
			
			}catch (Exception e) {
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
	
	public void validateABR_NO_OF_MON_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		try{
			PM_AGENT_BONUS_RATES_BEAN.setABR_NO_OF_MON_TO((Integer)value);
			
			}catch (Exception e) {
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
	
	/*End*/
}

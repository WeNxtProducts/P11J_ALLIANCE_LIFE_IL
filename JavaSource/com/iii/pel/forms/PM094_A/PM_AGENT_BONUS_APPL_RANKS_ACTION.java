package com.iii.pel.forms.PM094_A;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_APPL_RANKS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABAR_RANK_CODE_LABEL;

	private HtmlInputText COMP_ABAR_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ABS_AGENT_RANK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABS_AGENT_RANK_DESC;

	private PM_AGENT_BONUS_APPL_RANKS PM_AGENT_BONUS_APPL_RANKS_BEAN;

	private List<PM_AGENT_BONUS_APPL_RANKS> dataList_PM_AGENT_BONUS_APPL_RANKS = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();

	private UIData dataTable;

	private List codeList = new ArrayList();

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;
	
	private HtmlCommandButton UI_M_BUT_ADD;
	private HtmlCommandButton UI_M_BUT_DELETE;
	private HtmlCommandButton UI_M_BUT_POST;
	
	/*Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	private HtmlOutputLabel COMP_ABAR_CLASS_FM_LABEL;
	private HtmlOutputLabel COMP_ABAR_CLASS_TO_LABEL;
	private HtmlInputText COMP_ABAR_CLASS_FM;
	private HtmlInputText COMP_ABAR_CLASS_TO;
	private HtmlInputText COMP_UI_M_ABAR_CLASS_FM_DESC;
	private HtmlInputText COMP_UI_M_ABAR_CLASS_TO_DESC;
	private List codeListForClassFm = new ArrayList();
	private List codeListForClassTo = new ArrayList();
	
	
	public List getCodeListForClassFm() {
		return codeListForClassFm;
	}

	public void setCodeListForClassFm(List codeListForClassFm) {
		this.codeListForClassFm = codeListForClassFm;
	}

	public List getCodeListForClassTo() {
		return codeListForClassTo;
	}

	public void setCodeListForClassTo(List codeListForClassTo) {
		this.codeListForClassTo = codeListForClassTo;
	}

	public HtmlInputText getCOMP_UI_M_ABAR_CLASS_TO_DESC() {
		return COMP_UI_M_ABAR_CLASS_TO_DESC;
	}

	public void setCOMP_UI_M_ABAR_CLASS_TO_DESC(
			HtmlInputText cOMP_UI_M_ABAR_CLASS_TO_DESC) {
		COMP_UI_M_ABAR_CLASS_TO_DESC = cOMP_UI_M_ABAR_CLASS_TO_DESC;
	}

	public HtmlInputText getCOMP_UI_M_ABAR_CLASS_FM_DESC() {
		return COMP_UI_M_ABAR_CLASS_FM_DESC;
	}

	public void setCOMP_UI_M_ABAR_CLASS_FM_DESC(
			HtmlInputText cOMP_UI_M_ABAR_CLASS_FM_DESC) {
		COMP_UI_M_ABAR_CLASS_FM_DESC = cOMP_UI_M_ABAR_CLASS_FM_DESC;
	}

	public HtmlInputText getCOMP_ABAR_CLASS_FM() {
		return COMP_ABAR_CLASS_FM;
	}

	public void setCOMP_ABAR_CLASS_FM(HtmlInputText cOMP_ABAR_CLASS_FM) {
		COMP_ABAR_CLASS_FM = cOMP_ABAR_CLASS_FM;
	}

	public HtmlInputText getCOMP_ABAR_CLASS_TO() {
		return COMP_ABAR_CLASS_TO;
	}

	public void setCOMP_ABAR_CLASS_TO(HtmlInputText cOMP_ABAR_CLASS_TO) {
		COMP_ABAR_CLASS_TO = cOMP_ABAR_CLASS_TO;
	}

	public HtmlOutputLabel getCOMP_ABAR_CLASS_FM_LABEL() {
		return COMP_ABAR_CLASS_FM_LABEL;
	}

	public void setCOMP_ABAR_CLASS_FM_LABEL(HtmlOutputLabel cOMP_ABAR_CLASS_FM_LABEL) {
		COMP_ABAR_CLASS_FM_LABEL = cOMP_ABAR_CLASS_FM_LABEL;
	}

	public HtmlOutputLabel getCOMP_ABAR_CLASS_TO_LABEL() {
		return COMP_ABAR_CLASS_TO_LABEL;
	}

	public void setCOMP_ABAR_CLASS_TO_LABEL(HtmlOutputLabel cOMP_ABAR_CLASS_TO_LABEL) {
		COMP_ABAR_CLASS_TO_LABEL = cOMP_ABAR_CLASS_TO_LABEL;
	}
	
	/*End Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	PM_AGENT_BONUS_APPL_RANKS_DELEGATE delegate = new PM_AGENT_BONUS_APPL_RANKS_DELEGATE();
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction;
	
	public PM_AGENT_BONUS_APPL_RANKS_HELPER helper = new PM_AGENT_BONUS_APPL_RANKS_HELPER();;

	private HtmlCommandButton COMP_M_BUT_BONUS_RATE;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}

	public PM_AGENT_BONUS_APPL_RANKS_ACTION() {
		PM_AGENT_BONUS_APPL_RANKS_BEAN = new PM_AGENT_BONUS_APPL_RANKS();
		prevRowIndex = 0;
		currentpage = 1;
	}

	/*public void gridtabListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_AGENT_BONUS_APPL_RANKS gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_AGENT_BONUS_APPL_RANKS) dataList_PM_AGENT_BONUS_APPL_RANKS
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
		PM_AGENT_BONUS_APPL_RANKS gridValueBean = null;
		ControlBean controlBean = new ControlBean();
		//PM_AGENT_BONUS_APPL_RANKS_HELPER helper = new PM_AGENT_BONUS_APPL_RANKS_HELPER();
		try {

			// Get the bean based on row index
			gridValueBean = (PM_AGENT_BONUS_APPL_RANKS) dataList_PM_AGENT_BONUS_APPL_RANKS
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {

				gridValueBean.setABAR_UPD_DT(new Date());
				gridValueBean.setABAR_UPD_UID(controlBean.getM_USER_ID());
				helper.pre_update(gridValueBean);
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {
				Map sessionmap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				gridValueBean.setABAR_CR_DT(new CommonUtils().getCurrentDate());
				gridValueBean.setABAR_CR_UID(CommonUtils.getControlBean()
						.getM_USER_ID());
				//helper.pre_insert(gridValueBean);
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
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
		if (dataList_PM_AGENT_BONUS_APPL_RANKS == null) {
			dataList_PM_AGENT_BONUS_APPL_RANKS = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
		}
		PM_AGENT_BONUS_APPL_RANKS bean = new PM_AGENT_BONUS_APPL_RANKS();
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
		String absCode = compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_CODE();
		bean.setABAR_ABS_CODE(absCode);
		dataList_PM_AGENT_BONUS_APPL_RANKS.add(bean);
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "newadded";
	}

	public String deleteRow() {
		System.out
				.println("IN THE DELETE" + dataList_PM_AGENT_BONUS_APPL_RANKS);
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_AGENT_BONUS_APPL_RANKS bean = null;
		//PM_AGENT_BONUS_APPL_RANKS_HELPER helper = new PM_AGENT_BONUS_APPL_RANKS_HELPER();
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataList_PM_AGENT_BONUS_APPL_RANKS != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataList_PM_AGENT_BONUS_APPL_RANKS
					.size();) {
				bean = dataList_PM_AGENT_BONUS_APPL_RANKS.get(index);
				System.out.println("bean selected:::");

				if (bean.isSelected()) {
					System.out.println("Inside Loop");
					dataList_PM_AGENT_BONUS_APPL_RANKS.remove(bean);
					helper.pre_delete(bean);
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

	public List suggestionAction(Object obj) {
		String code = (String) obj;
		codeList = delegate.getCodeList(code, codeList);
		return codeList;
	}
	
	/*Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	public List suggestionActionForClassFm(Object obj) {
		String code = (String) obj;
		codeListForClassFm = delegate.getCodeListForClassFM(code, codeList);
		return codeListForClassFm;
	}
	
	public List suggestionActionForClassTo(Object obj) {
		String code = (String) obj;
		codeListForClassTo = delegate.getCodeListForClassTo(code, codeList);
		return codeListForClassTo;
	}
	
	
	public void doValidateClassFm(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if (value != null) {
			String code = (String) value;
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setABAR_CLASS_FM(code);
		}
	}
	
	public void doValidateClassTo(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if (value != null) {
			String code = (String) value;
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setABAR_CLASS_TO(code);
		}
	}
	
	/*public void getCodeDescForClassFm(ActionEvent event) {
		COMP_UI_M_ABAR_CLASS_FM_DESC.setSubmittedValue(null);
		if (COMP_ABAR_CLASS_FM.getSubmittedValue() != null) {
			String code = (String) COMP_ABAR_CLASS_FM.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, codeList);
			PM_AGENT_BONUS_APPL_RANKS_BEAN
					.setUI_M_ABAR_CLASS_FM_DESC(codeDesc);
			int rowIndex = getDataTable().getRowIndex();
			PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = dataList_PM_AGENT_BONUS_APPL_RANKS
					.get(rowIndex);
			pm_agent_bonus_appl_ranks.setUI_M_ABAR_CLASS_FM_DESC(codeDesc);

		}
	}
	public void getCodeDescForClassTo(ActionEvent event) {
		COMP_UI_M_ABS_AGENT_RANK_DESC.setSubmittedValue(null);
		if (COMP_ABAR_RANK_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_ABAR_RANK_CODE.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, codeList);
			PM_AGENT_BONUS_APPL_RANKS_BEAN
					.setUI_M_ABS_AGENT_RANK_DESC(codeDesc);
			int rowIndex = getDataTable().getRowIndex();
			PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = dataList_PM_AGENT_BONUS_APPL_RANKS
					.get(rowIndex);
			pm_agent_bonus_appl_ranks.setUI_M_ABS_AGENT_RANK_DESC(codeDesc);

		}
	}*/
	/*End Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	public void getCodeDesc(ActionEvent event) {
		COMP_UI_M_ABS_AGENT_RANK_DESC.setSubmittedValue(null);
		if (COMP_ABAR_RANK_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_ABAR_RANK_CODE.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, codeList);
			PM_AGENT_BONUS_APPL_RANKS_BEAN
					.setUI_M_ABS_AGENT_RANK_DESC(codeDesc);
			int rowIndex = getDataTable().getRowIndex();
			PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = dataList_PM_AGENT_BONUS_APPL_RANKS
					.get(rowIndex);
			pm_agent_bonus_appl_ranks.setUI_M_ABS_AGENT_RANK_DESC(codeDesc);

		}
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
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void codeValidations(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if (value != null) {
			String code = (String) value;
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setABAR_RANK_CODE(code);
//			lastColumnListener();
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

		PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = dataList_PM_AGENT_BONUS_APPL_RANKS
				.get(row);

		if (selected.equals("true"))
			pm_agent_bonus_appl_ranks.setSelected(true);
		else
			pm_agent_bonus_appl_ranks.setSelected(false);

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
		return "BonusSetUpHeader";
	}

	public HtmlOutputLabel getCOMP_ABAR_RANK_CODE_LABEL() {
		return COMP_ABAR_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABAR_RANK_CODE() {
		return COMP_ABAR_RANK_CODE;
	}

	public void setCOMP_ABAR_RANK_CODE_LABEL(
			HtmlOutputLabel COMP_ABAR_RANK_CODE_LABEL) {
		this.COMP_ABAR_RANK_CODE_LABEL = COMP_ABAR_RANK_CODE_LABEL;
	}

	public void setCOMP_ABAR_RANK_CODE(HtmlInputText COMP_ABAR_RANK_CODE) {
		this.COMP_ABAR_RANK_CODE = COMP_ABAR_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABS_AGENT_RANK_DESC_LABEL() {
		return COMP_UI_M_ABS_AGENT_RANK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABS_AGENT_RANK_DESC() {
		return COMP_UI_M_ABS_AGENT_RANK_DESC;
	}

	public void setCOMP_UI_M_ABS_AGENT_RANK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ABS_AGENT_RANK_DESC_LABEL) {
		this.COMP_UI_M_ABS_AGENT_RANK_DESC_LABEL = COMP_UI_M_ABS_AGENT_RANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABS_AGENT_RANK_DESC(
			HtmlInputText COMP_UI_M_ABS_AGENT_RANK_DESC) {
		this.COMP_UI_M_ABS_AGENT_RANK_DESC = COMP_UI_M_ABS_AGENT_RANK_DESC;
	}

	public PM_AGENT_BONUS_APPL_RANKS getPM_AGENT_BONUS_APPL_RANKS_BEAN() {
		return PM_AGENT_BONUS_APPL_RANKS_BEAN;
	}

	public void setPM_AGENT_BONUS_APPL_RANKS_BEAN(
			PM_AGENT_BONUS_APPL_RANKS PM_AGENT_BONUS_APPL_RANKS_BEAN) {
		this.PM_AGENT_BONUS_APPL_RANKS_BEAN = PM_AGENT_BONUS_APPL_RANKS_BEAN;
	}

	public List<PM_AGENT_BONUS_APPL_RANKS> getDataList_PM_AGENT_BONUS_APPL_RANKS() {
		return dataList_PM_AGENT_BONUS_APPL_RANKS;
	}

	public void setDataListPM_AGENT_BONUS_APPL_RANKS(
			List<PM_AGENT_BONUS_APPL_RANKS> dataList_PM_AGENT_BONUS_APPL_RANKS) {
		this.dataList_PM_AGENT_BONUS_APPL_RANKS = dataList_PM_AGENT_BONUS_APPL_RANKS;
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

	public void setDataList_PM_AGENT_BONUS_APPL_RANKS(
			List<PM_AGENT_BONUS_APPL_RANKS> dataList_PM_AGENT_BONUS_APPL_RANKS) {
		this.dataList_PM_AGENT_BONUS_APPL_RANKS = dataList_PM_AGENT_BONUS_APPL_RANKS;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}

	public void loadBonusApplRanks(HashMap<String, String> errorMap) {
		//PM_AGENT_BONUS_APPL_RANKS_HELPER helper = new PM_AGENT_BONUS_APPL_RANKS_HELPER();
		String message = null;

		try {
			dataList_PM_AGENT_BONUS_APPL_RANKS = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
			/*
			 * prevRowIndex = 0; currPage = 1;
			 */
			helper.execute_query();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			errorMap.put("current", message);
			errorMap.put("details", message);
		}

	}

	public HtmlCommandButton getCOMP_M_BUT_BONUS_RATE() {
		return COMP_M_BUT_BONUS_RATE;
	}

	public void setCOMP_M_BUT_BONUS_RATE(HtmlCommandButton comp_m_but_bonus_rate) {
		COMP_M_BUT_BONUS_RATE = comp_m_but_bonus_rate;
	}

	public String bonusRateButtonAction() {
		HashMap<String, String> errorMap = new HashMap<String, String>();
		String absCode = null;
		String rankCode = null;
		String message = null;
		boolean applRankSelected = false;
		int selectedItems = 0;
		String outcome = "agentbonusrates";
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");

		Iterator<PM_AGENT_BONUS_APPL_RANKS> applRanksItr = compositeAction
				.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN()
				.getDataList_PM_AGENT_BONUS_APPL_RANKS().iterator();
		while (applRanksItr.hasNext()) {
			PM_AGENT_BONUS_APPL_RANKS applRanksBean = applRanksItr.next();
			if (applRanksBean.isSelected()) {
				absCode = applRanksBean.getABAR_ABS_CODE();
				rankCode = applRanksBean.getABAR_RANK_CODE();
				System.out.println("ABS CODE IN COMPOSITE aCTION :" + absCode);
				System.out
						.println("Rank code in composite Action :" + rankCode);
				compositeAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN()
						.loadBonusRates(errorMap, applRanksBean);
				applRankSelected = true;
				selectedItems++;
			}
		}
		if (!applRankSelected && selectedItems < 1 || selectedItems > 1) {
			outcome = "";
			message = Messages.getString("messageProperties_PM094_A",
					"PM09_A$PM_AGENT_BONUS_RATES$SELECT_A_RECORD");
			compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN()
					.getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Please select a record ");
		}
		return outcome;
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

	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_AGENT_BONUS_APPL_RANKS_BEAN = new PM_AGENT_BONUS_APPL_RANKS();
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
				helper.pre_delete(PM_AGENT_BONUS_APPL_RANKS_BEAN);
				new CRUDHandler().executeDelete(PM_AGENT_BONUS_APPL_RANKS_BEAN,
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
				dataList_PM_AGENT_BONUS_APPL_RANKS.remove(PM_AGENT_BONUS_APPL_RANKS_BEAN);
				if (dataList_PM_AGENT_BONUS_APPL_RANKS.size() > 0) {

					PM_AGENT_BONUS_APPL_RANKS_BEAN = dataList_PM_AGENT_BONUS_APPL_RANKS
							.get(0);
				} else if (dataList_PM_AGENT_BONUS_APPL_RANKS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_AGENT_BONUS_APPL_RANKS_BEAN.setRowSelected(true);
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
			if (PM_AGENT_BONUS_APPL_RANKS_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
					helper.pre_insert(PM_AGENT_BONUS_APPL_RANKS_BEAN,compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN());
				new CRUDHandler().executeInsert(PM_AGENT_BONUS_APPL_RANKS_BEAN,
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
				dataList_PM_AGENT_BONUS_APPL_RANKS.add(PM_AGENT_BONUS_APPL_RANKS_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_AGENT_BONUS_APPL_RANKS_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				helper.pre_update(PM_AGENT_BONUS_APPL_RANKS_BEAN);
				new CRUDHandler().executeUpdate(PM_AGENT_BONUS_APPL_RANKS_BEAN,
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
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_AGENT_BONUS_APPL_RANKS_BEAN = (PM_AGENT_BONUS_APPL_RANKS) dataTable
					.getRowData();
			helper.post_query(PM_AGENT_BONUS_APPL_RANKS_BEAN);
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setRowSelected(true);
			/*Added by Ameen on 02-08-2018 for KICLIFEQC-1760174 as per Ajay*/
			if(PM_AGENT_BONUS_APPL_RANKS_BEAN.getABAR_AGENT_NEW()!=null && "Y".equalsIgnoreCase(PM_AGENT_BONUS_APPL_RANKS_BEAN.getABAR_AGENT_NEW())){
				PM_AGENT_BONUS_APPL_RANKS_BEAN.setUI_M_ABAR_AGENT_NEW(true);
			}else{
				PM_AGENT_BONUS_APPL_RANKS_BEAN.setUI_M_ABAR_AGENT_NEW(false);
			}
			/*end*/
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag()){
				helper.execute_query();
				helper.post_query(PM_AGENT_BONUS_APPL_RANKS_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BONUS_APPL_RANKS> PM_AGENT_BONUS_APPL_RANKS_ITR = dataList_PM_AGENT_BONUS_APPL_RANKS
				.iterator();
		while (PM_AGENT_BONUS_APPL_RANKS_ITR.hasNext()) {
			PM_AGENT_BONUS_APPL_RANKS_ITR.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent(){
		COMP_ABAR_RANK_CODE.resetValue();
		COMP_UI_M_ABS_AGENT_RANK_DESC.resetValue();
		/*Added by Ameen on 02-08-2018 for KICLIFEQC-1760174 as per Ajay*/
		COMP_UI_M_ABAR_AGENT_NEW.resetValue();
		/*end*/
	}

	public HtmlCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	/*Added by Ameen on 02-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	
	private HtmlOutputLabel COMP_UI_M_ABAR_AGENT_NEW_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_UI_M_ABAR_AGENT_NEW;
	

	public HtmlOutputLabel getCOMP_UI_M_ABAR_AGENT_NEW_LABEL() {
		return COMP_UI_M_ABAR_AGENT_NEW_LABEL;
	}

	public void setCOMP_UI_M_ABAR_AGENT_NEW_LABEL(
			HtmlOutputLabel cOMP_UI_M_ABAR_AGENT_NEW_LABEL) {
		COMP_UI_M_ABAR_AGENT_NEW_LABEL = cOMP_UI_M_ABAR_AGENT_NEW_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_ABAR_AGENT_NEW() {
		return COMP_UI_M_ABAR_AGENT_NEW;
	}

	public void setCOMP_UI_M_ABAR_AGENT_NEW(
			HtmlSelectBooleanCheckbox cOMP_UI_M_ABAR_AGENT_NEW) {
		COMP_UI_M_ABAR_AGENT_NEW = cOMP_UI_M_ABAR_AGENT_NEW;
	}

	public void newAgentCheck(ActionEvent actionEvent){
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		try{
			
		boolean check = (boolean) input.getSubmittedValue();
		COMP_UI_M_ABAR_AGENT_NEW.setSelected(check);
		
		if(COMP_UI_M_ABAR_AGENT_NEW.isSelected()){
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setABAR_AGENT_NEW("Y");
		}else{
			PM_AGENT_BONUS_APPL_RANKS_BEAN.setABAR_AGENT_NEW("N");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	/*end*/
}

package com.iii.pel.forms.PM102;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class AG_INCENTIVES_TRGT_STP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TSD_LEVEL_LABEL;

	private HtmlInputText COMP_TSD_LEVEL;

	private HtmlOutputLabel COMP_TSD_MODE_LABEL;

	private HtmlInputText COMP_TSD_MODE;
	
	private HtmlInputText COMP_TSD_TARGET_DESC;
	
	private HtmlInputText COMP_TSD_MODE_DESC;
	
	private HtmlInputText COMP_TSD_LEVEL_DESC;
	
	
	private HtmlOutputLabel COMP_TSD_TARGET_LABEL;

	private HtmlInputText COMP_TSD_TARGET;

	private AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN;

	public PM102_COMPOSITE_ACTION compositeAction;

	private AG_INCENTIVES_TRGT_STP_HELPER helper;

	private List<AG_INCENTIVES_TRGT_STP> dataList_AG_INCENTIVES_TRGT_STP = new ArrayList<AG_INCENTIVES_TRGT_STP>();

	private UIData dataTable;

	public AG_INCENTIVES_TRGT_STP_ACTION() {

		AG_INCENTIVES_TRGT_STP_BEAN = new AG_INCENTIVES_TRGT_STP();
		helper = new AG_INCENTIVES_TRGT_STP_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_TSD_LEVEL_LABEL() {
		return COMP_TSD_LEVEL_LABEL;
	}

	public HtmlInputText getCOMP_TSD_LEVEL() {
		return COMP_TSD_LEVEL;
	}

	public void setCOMP_TSD_LEVEL_LABEL(HtmlOutputLabel COMP_TSD_LEVEL_LABEL) {
		this.COMP_TSD_LEVEL_LABEL = COMP_TSD_LEVEL_LABEL;
	}

	public void setCOMP_TSD_LEVEL(HtmlInputText COMP_TSD_LEVEL) {
		this.COMP_TSD_LEVEL = COMP_TSD_LEVEL;
	}

	public HtmlOutputLabel getCOMP_TSD_MODE_LABEL() {
		return COMP_TSD_MODE_LABEL;
	}

	public HtmlInputText getCOMP_TSD_MODE() {
		return COMP_TSD_MODE;
	}

	public void setCOMP_TSD_MODE_LABEL(HtmlOutputLabel COMP_TSD_MODE_LABEL) {
		this.COMP_TSD_MODE_LABEL = COMP_TSD_MODE_LABEL;
	}

	public void setCOMP_TSD_MODE(HtmlInputText COMP_TSD_MODE) {
		this.COMP_TSD_MODE = COMP_TSD_MODE;
	}

	public HtmlOutputLabel getCOMP_TSD_TARGET_LABEL() {
		return COMP_TSD_TARGET_LABEL;
	}

	public void setCOMP_TSD_TARGET_LABEL(HtmlOutputLabel COMP_TSD_TARGET_LABEL) {
		this.COMP_TSD_TARGET_LABEL = COMP_TSD_TARGET_LABEL;
	}

	public AG_INCENTIVES_TRGT_STP getAG_INCENTIVES_TRGT_STP_BEAN() {
		return AG_INCENTIVES_TRGT_STP_BEAN;
	}

	public void setAG_INCENTIVES_TRGT_STP_BEAN(
			AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN) {
		this.AG_INCENTIVES_TRGT_STP_BEAN = AG_INCENTIVES_TRGT_STP_BEAN;
	}

	public List<AG_INCENTIVES_TRGT_STP> getDataList_AG_INCENTIVES_TRGT_STP() {
		return dataList_AG_INCENTIVES_TRGT_STP;
	}

	public void setDataListAG_INCENTIVES_TRGT_STP(
			List<AG_INCENTIVES_TRGT_STP> dataList_AG_INCENTIVES_TRGT_STP) {
		this.dataList_AG_INCENTIVES_TRGT_STP = dataList_AG_INCENTIVES_TRGT_STP;
	}

	public HtmlInputText getCOMP_TSD_TARGET() {
		return COMP_TSD_TARGET;
	}

	public void setCOMP_TSD_TARGET(HtmlInputText cOMP_TSD_TARGET) {
		COMP_TSD_TARGET = cOMP_TSD_TARGET;
	}

	public void postRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		try {

			if (AG_INCENTIVES_TRGT_STP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(AG_INCENTIVES_TRGT_STP_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
				//loadAgentHirarchy();
				dataList_AG_INCENTIVES_TRGT_STP.add(AG_INCENTIVES_TRGT_STP_BEAN);

			} else if (AG_INCENTIVES_TRGT_STP_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
					new CRUDHandler().executeUpdate(
							AG_INCENTIVES_TRGT_STP_BEAN, CommonUtils
									.getConnection());
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
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			resetSelectedRow();
			AG_INCENTIVES_TRGT_STP_BEAN.setRowSelected(true);

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
			AG_INCENTIVES_TRGT_STP_BEAN = (AG_INCENTIVES_TRGT_STP) dataTable
					.getRowData();
			helper.postQuery(AG_INCENTIVES_TRGT_STP_BEAN);
			AG_INCENTIVES_TRGT_STP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<AG_INCENTIVES_TRGT_STP> AG_INCENTIVES_TRGT_STP_ITR = dataList_AG_INCENTIVES_TRGT_STP
				.iterator();
		while (AG_INCENTIVES_TRGT_STP_ITR.hasNext()) {
			AG_INCENTIVES_TRGT_STP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_TSD_LEVEL.resetValue();
		COMP_TSD_MODE.resetValue();
		COMP_TSD_TARGET.resetValue();
		COMP_TSD_LEVEL_DESC.resetValue();
		COMP_TSD_MODE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);

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
			if (isBlockFlag()) {
				if (AG_INCENTIVES_TRGT_STP_BEAN != null) {
					helper.executeQuery(compositeAction);
					//helper.postQuery(AG_INCENTIVES_TRGT_STP_BEAN);
				} else {
				}
				COMP_TSD_MODE.resetValue();
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * Instantiates all components in AG_INCENTIVES_TRGT_STP_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_TSD_LEVEL = new HtmlInputText();
		COMP_TSD_MODE = new HtmlInputText();
		// Instantiating HtmlSelectOneMenu
		COMP_TSD_TARGET = new HtmlInputText();

	}

	/**
	 * Disables all components in AG_INCENTIVES_TRGT_STP_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_TSD_LEVEL.setDisabled(disabled);
		COMP_TSD_MODE.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_TSD_TARGET.setDisabled(disabled);

	}

	public String bscRatesAction() {
		return "BSC_RATES";
	}

	public ArrayList<LovBean> prepareSuggestionList_TSD_LEVEL(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String currentValue = (String) object;
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES "
				+ "WHERE PC_TYPE = 'AG_INC_LEVEL' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY PC_CODE";
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query, new Object[] {
					currentValue, currentValue });
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public ArrayList<LovBean> prepareSuggestionList_TSD_MODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String currentValue = (String) object;
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES "
				+ "WHERE PC_TYPE = 'AG_INC_PER' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY PC_CODE";
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query, new Object[] {
					currentValue, currentValue });
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				AG_INCENTIVES_TRGT_STP_BEAN= new AG_INCENTIVES_TRGT_STP();
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
		String message = null;

		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(AG_INCENTIVES_TRGT_STP_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				dataList_AG_INCENTIVES_TRGT_STP
						.remove(AG_INCENTIVES_TRGT_STP_BEAN);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						message);
				if (dataList_AG_INCENTIVES_TRGT_STP.size() > 0) {
					AG_INCENTIVES_TRGT_STP_BEAN = dataList_AG_INCENTIVES_TRGT_STP
							.get(0);
					resetSelectedRow();
					AG_INCENTIVES_TRGT_STP_BEAN.setRowSelected(true);
				} else if (dataList_AG_INCENTIVES_TRGT_STP.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				AG_INCENTIVES_TRGT_STP_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public HtmlInputText getCOMP_TSD_TARGET_DESC() {
		return COMP_TSD_TARGET_DESC;
	}

	public void setCOMP_TSD_TARGET_DESC(HtmlInputText comp_tsd_target_desc) {
		COMP_TSD_TARGET_DESC = comp_tsd_target_desc;
	}

	public HtmlInputText getCOMP_TSD_MODE_DESC() {
		return COMP_TSD_MODE_DESC;
	}

	public void setCOMP_TSD_MODE_DESC(HtmlInputText comp_tsd_mode_desc) {
		COMP_TSD_MODE_DESC = comp_tsd_mode_desc;
	}

	public HtmlInputText getCOMP_TSD_LEVEL_DESC() {
		return COMP_TSD_LEVEL_DESC;
	}

	public void setCOMP_TSD_LEVEL_DESC(HtmlInputText comp_tsd_level_desc) {
		COMP_TSD_LEVEL_DESC = comp_tsd_level_desc;
	}

}

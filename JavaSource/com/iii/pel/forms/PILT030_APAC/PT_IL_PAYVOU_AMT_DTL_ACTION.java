package com.iii.pel.forms.PILT030_APAC;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_AMT_DTL_ACTION extends CommonAction {

	private String filterByPAD_CUST_CODE;
	private String filterByUI_M_PAD_CUST_DESC;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlOutputLabel COMP_PAD_CUST_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PAD_CUST_DESC_LABEL;
	private HtmlOutputLabel COMP_PAD_FC_DR_TOT_AMT_LABEL;
	private HtmlOutputLabel COMP_PAD_LC_DR_TOT_AMT_LABEL;
	private HtmlOutputLabel COMP_PAD_FC_CR_TOT_AMT_LABEL;
	private HtmlOutputLabel COMP_PAD_LC_CR_TOT_AMT_LABEL;
	private HtmlOutputLabel COMP_PAD_CURR_CODE_LABEL;
	private HtmlOutputLabel COMP_PAD_FC_BAL_AMT_LABEL;
	private HtmlOutputLabel COMP_PAD_LC_BAL_AMT_LABEL;

	private HtmlInputText COMP_PAD_CUST_CODE;
	private HtmlInputText COMP_UI_M_PAD_CUST_DESC;
	private HtmlInputText COMP_PAD_FC_DR_TOT_AMT;
	private HtmlInputText COMP_PAD_LC_DR_TOT_AMT;
	private HtmlInputText COMP_PAD_FC_CR_TOT_AMT;
	private HtmlInputText COMP_PAD_LC_CR_TOT_AMT;
	private HtmlInputText COMP_PAD_CURR_CODE;
	private HtmlInputText COMP_PAD_FC_BAL_AMT;
	private HtmlInputText COMP_PAD_LC_BAL_AMT;

	private PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN;

	private UIData PT_IL_PAYVOU_AMT_DTL_DT;

	private List<PT_IL_PAYVOU_AMT_DTL> PT_IL_PAYVOU_AMT_DTL_LIST;

	private boolean onLoadFlag = false;

	public String getFilterByPAD_CUST_CODE() {
		return filterByPAD_CUST_CODE;
	}

	public void setFilterByPAD_CUST_CODE(String filterByPAD_CUST_CODE) {
		this.filterByPAD_CUST_CODE = filterByPAD_CUST_CODE;
	}

	public String getFilterByUI_M_PAD_CUST_DESC() {
		return filterByUI_M_PAD_CUST_DESC;
	}

	public void setFilterByUI_M_PAD_CUST_DESC(String filterByUI_M_PAD_CUST_DESC) {
		this.filterByUI_M_PAD_CUST_DESC = filterByUI_M_PAD_CUST_DESC;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public PT_IL_PAYVOU_AMT_DTL_ACTION() {
		PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
	}

	public UIData getPT_IL_PAYVOU_AMT_DTL_DT() {
		return PT_IL_PAYVOU_AMT_DTL_DT;
	}
	
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	public void setPT_IL_PAYVOU_AMT_DTL_DT(UIData pt_il_payvou_amt_dtl_dt) {
		PT_IL_PAYVOU_AMT_DTL_DT = pt_il_payvou_amt_dtl_dt;
	}

	public List<PT_IL_PAYVOU_AMT_DTL> getPT_IL_PAYVOU_AMT_DTL_LIST() {
		return PT_IL_PAYVOU_AMT_DTL_LIST;
	}

	public void setPT_IL_PAYVOU_AMT_DTL_LIST(
			List<PT_IL_PAYVOU_AMT_DTL> pt_il_payvou_amt_dtl_list) {
		PT_IL_PAYVOU_AMT_DTL_LIST = pt_il_payvou_amt_dtl_list;
	}

	public HtmlOutputLabel getCOMP_PAD_CUST_CODE_LABEL() {
		return COMP_PAD_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAD_CUST_CODE() {
		return COMP_PAD_CUST_CODE;
	}

	public void setCOMP_PAD_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_PAD_CUST_CODE_LABEL) {
		this.COMP_PAD_CUST_CODE_LABEL = COMP_PAD_CUST_CODE_LABEL;
	}

	public void setCOMP_PAD_CUST_CODE(HtmlInputText COMP_PAD_CUST_CODE) {
		this.COMP_PAD_CUST_CODE = COMP_PAD_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAD_CUST_DESC_LABEL() {
		return COMP_UI_M_PAD_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAD_CUST_DESC() {
		return COMP_UI_M_PAD_CUST_DESC;
	}

	public void setCOMP_UI_M_PAD_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAD_CUST_DESC_LABEL) {
		this.COMP_UI_M_PAD_CUST_DESC_LABEL = COMP_UI_M_PAD_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAD_CUST_DESC(HtmlInputText COMP_UI_M_PAD_CUST_DESC) {
		this.COMP_UI_M_PAD_CUST_DESC = COMP_UI_M_PAD_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_PAD_FC_DR_TOT_AMT_LABEL() {
		return COMP_PAD_FC_DR_TOT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_FC_DR_TOT_AMT() {
		return COMP_PAD_FC_DR_TOT_AMT;
	}

	public void setCOMP_PAD_FC_DR_TOT_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_FC_DR_TOT_AMT_LABEL) {
		this.COMP_PAD_FC_DR_TOT_AMT_LABEL = COMP_PAD_FC_DR_TOT_AMT_LABEL;
	}

	public void setCOMP_PAD_FC_DR_TOT_AMT(HtmlInputText COMP_PAD_FC_DR_TOT_AMT) {
		this.COMP_PAD_FC_DR_TOT_AMT = COMP_PAD_FC_DR_TOT_AMT;
	}

	public HtmlOutputLabel getCOMP_PAD_LC_DR_TOT_AMT_LABEL() {
		return COMP_PAD_LC_DR_TOT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_LC_DR_TOT_AMT() {
		return COMP_PAD_LC_DR_TOT_AMT;
	}

	public void setCOMP_PAD_LC_DR_TOT_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_LC_DR_TOT_AMT_LABEL) {
		this.COMP_PAD_LC_DR_TOT_AMT_LABEL = COMP_PAD_LC_DR_TOT_AMT_LABEL;
	}

	public void setCOMP_PAD_LC_DR_TOT_AMT(HtmlInputText COMP_PAD_LC_DR_TOT_AMT) {
		this.COMP_PAD_LC_DR_TOT_AMT = COMP_PAD_LC_DR_TOT_AMT;
	}

	public HtmlOutputLabel getCOMP_PAD_FC_CR_TOT_AMT_LABEL() {
		return COMP_PAD_FC_CR_TOT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_FC_CR_TOT_AMT() {
		return COMP_PAD_FC_CR_TOT_AMT;
	}

	public void setCOMP_PAD_FC_CR_TOT_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_FC_CR_TOT_AMT_LABEL) {
		this.COMP_PAD_FC_CR_TOT_AMT_LABEL = COMP_PAD_FC_CR_TOT_AMT_LABEL;
	}

	public void setCOMP_PAD_FC_CR_TOT_AMT(HtmlInputText COMP_PAD_FC_CR_TOT_AMT) {
		this.COMP_PAD_FC_CR_TOT_AMT = COMP_PAD_FC_CR_TOT_AMT;
	}

	public HtmlOutputLabel getCOMP_PAD_LC_CR_TOT_AMT_LABEL() {
		return COMP_PAD_LC_CR_TOT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_LC_CR_TOT_AMT() {
		return COMP_PAD_LC_CR_TOT_AMT;
	}

	public void setCOMP_PAD_LC_CR_TOT_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_LC_CR_TOT_AMT_LABEL) {
		this.COMP_PAD_LC_CR_TOT_AMT_LABEL = COMP_PAD_LC_CR_TOT_AMT_LABEL;
	}

	public void setCOMP_PAD_LC_CR_TOT_AMT(HtmlInputText COMP_PAD_LC_CR_TOT_AMT) {
		this.COMP_PAD_LC_CR_TOT_AMT = COMP_PAD_LC_CR_TOT_AMT;
	}

	public HtmlOutputLabel getCOMP_PAD_CURR_CODE_LABEL() {
		return COMP_PAD_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAD_CURR_CODE() {
		return COMP_PAD_CURR_CODE;
	}

	public void setCOMP_PAD_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PAD_CURR_CODE_LABEL) {
		this.COMP_PAD_CURR_CODE_LABEL = COMP_PAD_CURR_CODE_LABEL;
	}

	public void setCOMP_PAD_CURR_CODE(HtmlInputText COMP_PAD_CURR_CODE) {
		this.COMP_PAD_CURR_CODE = COMP_PAD_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_PAD_FC_BAL_AMT_LABEL() {
		return COMP_PAD_FC_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_FC_BAL_AMT() {
		return COMP_PAD_FC_BAL_AMT;
	}

	public void setCOMP_PAD_FC_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_FC_BAL_AMT_LABEL) {
		this.COMP_PAD_FC_BAL_AMT_LABEL = COMP_PAD_FC_BAL_AMT_LABEL;
	}

	public void setCOMP_PAD_FC_BAL_AMT(HtmlInputText COMP_PAD_FC_BAL_AMT) {
		this.COMP_PAD_FC_BAL_AMT = COMP_PAD_FC_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PAD_LC_BAL_AMT_LABEL() {
		return COMP_PAD_LC_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAD_LC_BAL_AMT() {
		return COMP_PAD_LC_BAL_AMT;
	}

	public void setCOMP_PAD_LC_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PAD_LC_BAL_AMT_LABEL) {
		this.COMP_PAD_LC_BAL_AMT_LABEL = COMP_PAD_LC_BAL_AMT_LABEL;
	}

	public void setCOMP_PAD_LC_BAL_AMT(HtmlInputText COMP_PAD_LC_BAL_AMT) {
		this.COMP_PAD_LC_BAL_AMT = COMP_PAD_LC_BAL_AMT;
	}

	public PT_IL_PAYVOU_AMT_DTL getPT_IL_PAYVOU_AMT_DTL_BEAN() {
		return PT_IL_PAYVOU_AMT_DTL_BEAN;
	}

	public void setPT_IL_PAYVOU_AMT_DTL_BEAN(
			PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN) {
		this.PT_IL_PAYVOU_AMT_DTL_BEAN = PT_IL_PAYVOU_AMT_DTL_BEAN;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event) {
		getErrorMap().clear();
		getWarningMap().clear();
		if (isBlockFlag()) {
			PT_IL_PAYVOU_AMT_DTL_HELPER helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
			helper.whenNewBlockInstance();
			setBlockFlag(false);
		}
	}

	/*public void saveRecord(ActionEvent actionEvent) {
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
	}*/

	public void saveRecord() {
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.keyCommit();
			PILT030_APAC_ACTION_INSTANCE.getConnection().commit();
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

	public void gridtabListener() {
		getErrorMap().clear();
		getWarningMap().clear();
		int currRowIndex = getPT_IL_PAYVOU_AMT_DTL_DT().getRowIndex();
		int rowUpdated = 0;
		PT_IL_PAYVOU_AMT_DTL gridValueBean = null;
		PT_IL_PAYVOU_AMT_DTL_HELPER helper = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						gridValueBean = (PT_IL_PAYVOU_AMT_DTL) PT_IL_PAYVOU_AMT_DTL_LIST
								.get(prevRowIndex);
						helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
						if (gridValueBean.getROWID() != null) {
							helper.preUpdate(gridValueBean);
							rowUpdated = helper.saveRecord(gridValueBean);
							getWarningMap().put("somekey",
									rowUpdated + " record updated.");
							getWarningMap().put("current",
									rowUpdated + " record updated.");
						} else {
							helper.preInsert(gridValueBean);
							rowUpdated = helper.saveRecord(gridValueBean);
							getWarningMap().put("somekey",
									rowUpdated + " record inserted.");
							getWarningMap().put("current",
									rowUpdated + " record inserted.");
						}
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			getErrorMap().put("current", e1.getMessage());
		}
	}

	public void lastColumnListener() {
		getErrorMap().clear();
		getWarningMap().clear();
		PILT030_APAC_COMPOSITE_ACTION pilt030_apac_composite_action = (PILT030_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILT030_APAC_COMPOSITE_ACTION");
		PT_IL_PAYVOU_AMT_DTL_ACTION actionBean = pilt030_apac_composite_action
				.getPILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION();
		PT_IL_PAYVOU_AMT_DTL gridValueBean = null;
		// int currRowIndex = getPT_IL_PAYVOU_AMT_DTL_DT().getRowIndex();
		int rowUpdated = 0;
		PT_IL_PAYVOU_AMT_DTL_HELPER helper = null;
		try {
			gridValueBean = (PT_IL_PAYVOU_AMT_DTL) actionBean
					.getPT_IL_PAYVOU_AMT_DTL_BEAN();
			if (gridValueBean.getROWID() != null) {
				helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
				helper.preUpdate(gridValueBean);
				rowUpdated = helper.saveRecord(gridValueBean);
				getWarningMap().put("somekey", rowUpdated + " record updated.");
				getWarningMap().put("current", rowUpdated + " record updated.");
			} else {
				helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
				helper.preInsert(gridValueBean);
				rowUpdated = helper.saveRecord(gridValueBean);
				getWarningMap()
						.put("somekey", rowUpdated + " record inserted.");
				getWarningMap()
						.put("current", rowUpdated + " record inserted.");
			}

			// lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			getErrorMap().put("current", e1.getMessage());
		}
	}

	int lastUpdatedRowIndex = 0;
	int prevRowIndex = 0;

	
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
				this.setPT_IL_PAYVOU_AMT_DTL_BEAN(PT_IL_PAYVOU_AMT_DTL_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}
	
	
	/*public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
				this.setPT_IL_PAYVOU_AMT_DTL_BEAN(PT_IL_PAYVOU_AMT_DTL_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}*/

	// ----------
	public void getDetails() {
		try {
			if (PT_IL_PAYVOU_AMT_DTL_LIST.size() != 0) {
				PT_IL_PAYVOU_AMT_DTL_BEAN = (PT_IL_PAYVOU_AMT_DTL) PT_IL_PAYVOU_AMT_DTL_DT
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {

		COMP_PAD_CUST_CODE.resetValue();
		COMP_UI_M_PAD_CUST_DESC.resetValue();
		COMP_PAD_FC_DR_TOT_AMT.resetValue();
		COMP_PAD_LC_DR_TOT_AMT.resetValue();
		COMP_PAD_FC_CR_TOT_AMT.resetValue();
		COMP_PAD_LC_CR_TOT_AMT.resetValue();
		COMP_PAD_CURR_CODE.resetValue();
		COMP_PAD_FC_BAL_AMT.resetValue();
		COMP_PAD_LC_BAL_AMT.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PAYVOU_AMT_DTL> iterator = PT_IL_PAYVOU_AMT_DTL_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/*public void post(ActionEvent ae) {
		PT_IL_PAYVOU_AMT_DTL_BEAN = this.getPT_IL_PAYVOU_AMT_DTL_BEAN();
		PT_IL_PAYVOU_AMT_DTL_HELPER helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
		CommonUtils commonUtils = new CommonUtils();

		try {
			if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					helper.preUpdate(PT_IL_PAYVOU_AMT_DTL_BEAN);
					new CRUDHandler().executeInsert(PT_IL_PAYVOU_AMT_DTL_BEAN,
							new CommonUtils().getConnection());
					new CommonUtils().getConnection().commit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					helper.preInsert(PT_IL_PAYVOU_AMT_DTL_BEAN);
					new CRUDHandler().executeInsert(PT_IL_PAYVOU_AMT_DTL_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					PT_IL_PAYVOU_AMT_DTL_LIST.add(PT_IL_PAYVOU_AMT_DTL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/
	
	
	/*public void post(ActionEvent event) {
		PT_IL_PAYVOU_AMT_DTL_HELPER helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
		try {
			if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PT_IL_PAYVOU_AMT_DTL_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PAYVOU_AMT_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				PT_IL_PAYVOU_AMT_DTL_LIST.add(PT_IL_PAYVOU_AMT_DTL_BEAN);
			} else if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PT_IL_PAYVOU_AMT_DTL_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PAYVOU_AMT_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			}

			PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}*/
	
	
public void post(ActionEvent event) {
	PT_IL_PAYVOU_AMT_DTL_HELPER helper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
		try {
			if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PT_IL_PAYVOU_AMT_DTL_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PAYVOU_AMT_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				PT_IL_PAYVOU_AMT_DTL_LIST.add(PT_IL_PAYVOU_AMT_DTL_BEAN);
			} else if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PT_IL_PAYVOU_AMT_DTL_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PAYVOU_AMT_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			}

			PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	

public void deleteRow(ActionEvent ae) {

	try {
		getErrorMap().clear();
		getWarningMap().clear();

		if (isDELETE_ALLOWED()) {
			if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() != null) {
				// executeDelete(PM_CUST_DIVN_BEAN);
				new CRUDHandler().executeDelete(PT_IL_PAYVOU_AMT_DTL_BEAN,
						CommonUtils.getConnection());
				PT_IL_PAYVOU_AMT_DTL_LIST.remove(PT_IL_PAYVOU_AMT_DTL_BEAN);
			}

			if (PT_IL_PAYVOU_AMT_DTL_LIST.size() > 0) {
				setPT_IL_PAYVOU_AMT_DTL_BEAN(PT_IL_PAYVOU_AMT_DTL_LIST
						.get(0));
				
			} else {
				AddRow(null);
			}

			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put(
					"deleteRow",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			resetAllComponent();
			PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(true);

		} else {
			getErrorMap().clear();
			getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
			getErrorMap().put(
					"deleteRow",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
		}

	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("deleteRow", e.getMessage());
	}
}
    

	/*public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PAYVOU_AMT_DTL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PAYVOU_AMT_DTL_BEAN,
							CommonUtils.getConnection());
					PT_IL_PAYVOU_AMT_DTL_LIST.remove(PT_IL_PAYVOU_AMT_DTL_BEAN);
				}

				if (PT_IL_PAYVOU_AMT_DTL_LIST.size() > 0) {
					setPT_IL_PAYVOU_AMT_DTL_BEAN(PT_IL_PAYVOU_AMT_DTL_LIST
							.get(0));
					
				} else {
					AddRow(null);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(true);

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}*/

}

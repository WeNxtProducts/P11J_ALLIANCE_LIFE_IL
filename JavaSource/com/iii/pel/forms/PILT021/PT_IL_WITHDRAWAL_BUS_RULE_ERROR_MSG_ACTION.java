package com.iii.pel.forms.PILT021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
public class PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION extends CommonAction{
	
	 	private HtmlOutputLabel COMP_BREM_MSG_LABEL;
	 	private HtmlInputText COMP_BREM_MSG;
	    private HtmlOutputLabel COMP_BREM_ERR_FLAG_LABEL;
	    private HtmlInputText COMP_BREM_ERR_FLAG;
	    private HtmlOutputLabel COMP_BREM_APPLY_LEVEL_LABEL;
	    private HtmlInputText COMP_BREM_APPLY_LEVEL;
	    private HtmlCommandButton COMP_UI_M_BUS_RULE_MAIN;
	    private PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG  PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN;
		private PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_HELPER helper;
	    private List<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG> dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG = new ArrayList<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG>();
	    private UIData dataTable;
	    public PILT021_COMPOSITE_ACTION compositeAction;
	    
	    public PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN() {
			return PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN;
		}
		public void setPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN(
				PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG pT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN) {
			PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = pT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN;
		}
	   
		public PILT021_COMPOSITE_ACTION getCompositeAction() {
			return compositeAction;
		}
		public void setCompositeAction(PILT021_COMPOSITE_ACTION compositeAction) {
			this.compositeAction = compositeAction;
		}
		public HtmlOutputLabel getCOMP_BREM_MSG_LABEL() {
			return COMP_BREM_MSG_LABEL;
		}
		public void setCOMP_BREM_MSG_LABEL(HtmlOutputLabel cOMP_BREM_MSG_LABEL) {
			COMP_BREM_MSG_LABEL = cOMP_BREM_MSG_LABEL;
		}
		public HtmlInputText getCOMP_BREM_MSG() {
			return COMP_BREM_MSG;
		}
		public void setCOMP_BREM_MSG(HtmlInputText cOMP_BREM_MSG) {
			COMP_BREM_MSG = cOMP_BREM_MSG;
		}
		public HtmlOutputLabel getCOMP_BREM_ERR_FLAG_LABEL() {
			return COMP_BREM_ERR_FLAG_LABEL;
		}
		public void setCOMP_BREM_ERR_FLAG_LABEL(HtmlOutputLabel cOMP_BREM_ERR_FLAG_LABEL) {
			COMP_BREM_ERR_FLAG_LABEL = cOMP_BREM_ERR_FLAG_LABEL;
		}
		public HtmlInputText getCOMP_BREM_ERR_FLAG() {
			return COMP_BREM_ERR_FLAG;
		}
		public void setCOMP_BREM_ERR_FLAG(HtmlInputText cOMP_BREM_ERR_FLAG) {
			COMP_BREM_ERR_FLAG = cOMP_BREM_ERR_FLAG;
		}
		public HtmlOutputLabel getCOMP_BREM_APPLY_LEVEL_LABEL() {
			return COMP_BREM_APPLY_LEVEL_LABEL;
		}
		public void setCOMP_BREM_APPLY_LEVEL_LABEL(
				HtmlOutputLabel cOMP_BREM_APPLY_LEVEL_LABEL) {
			COMP_BREM_APPLY_LEVEL_LABEL = cOMP_BREM_APPLY_LEVEL_LABEL;
		}
		public HtmlInputText getCOMP_BREM_APPLY_LEVEL() {
			return COMP_BREM_APPLY_LEVEL;
		}
		public void setCOMP_BREM_APPLY_LEVEL(HtmlInputText cOMP_BREM_APPLY_LEVEL) {
			COMP_BREM_APPLY_LEVEL = cOMP_BREM_APPLY_LEVEL;
		}
		public HtmlCommandButton getCOMP_UI_M_BUS_RULE_MAIN() {
			return COMP_UI_M_BUS_RULE_MAIN;
		}
		public void setCOMP_UI_M_BUS_RULE_MAIN(HtmlCommandButton cOMP_UI_M_BUS_RULE_MAIN) {
			COMP_UI_M_BUS_RULE_MAIN = cOMP_UI_M_BUS_RULE_MAIN;
		}
		public PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_HELPER getHelper() {
			return helper;
		}
		public void setHelper(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_HELPER helper) {
			this.helper = helper;
		}
		public List<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG> getDataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG() {
			return dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG;
		}
		public void setDataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG(
				List<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG> dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG) {
			this.dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG = dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG;
		}
		public UIData getDataTable() {
			return dataTable;
		}
		public void setDataTable(UIData dataTable) {
			this.dataTable = dataTable;
		}
		
		public PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION() {

			PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG();
	    	helper = new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_HELPER();
	    }

		 public void addRow(ActionEvent event) {
				try {
				    if (isINSERT_ALLOWED()) {

				    	PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG();
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

					new CRUDHandler().executeDelete(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN,
						CommonUtils.getConnection());
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
					dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG
						.remove(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN);
					if (dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG.size() > 0) {

						PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG
						    .get(0);
					} else if (dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG.size() == 0) {

					    addRow(null);
					}

					resetAllComponent();
					PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
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
				    if (PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.getROWID() == null
					    && isINSERT_ALLOWED()) {

					new CRUDHandler().executeInsert(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN,
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
					dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG.add(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN);
				    } else if (PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.getROWID() != null
					    && isUPDATE_ALLOWED()) {

					new CRUDHandler().executeUpdate(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN,
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

				    PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
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
				    PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = (PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG) dataTable
					    .getRowData();
				    PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
				    resetAllComponent();
				} catch (Exception exc) {
				    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					    exc.getMessage());
				    getErrorMap().put("displayRecords", exc.getMessage());
				}

			    }

			    private void resetSelectedRow() {
				Iterator<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG> PT_BUS_RULE_ERROR_MSG_ITR = dataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG.iterator();
				while (PT_BUS_RULE_ERROR_MSG_ITR.hasNext()) {
				    PT_BUS_RULE_ERROR_MSG_ITR.next().setRowSelected(false);
				}
			    }

			    private void resetAllComponent() {
				COMP_BREM_MSG.resetValue();
				COMP_BREM_ERR_FLAG.resetValue();
				COMP_BREM_APPLY_LEVEL.resetValue();
			    }

			    public void saveRecord() {
				try {
				    CommonUtils.getConnection().commit();
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
					helper.executeQuery(compositeAction);
					setBlockFlag(false);
				    }
				} catch (Exception e) {
				    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					    e.getMessage());
				    getErrorMap().put("onLoad", e.getMessage());
				}
			    }

			    public String navigatePolicyScreen()
			    {
			    	return "PILT006_APAC_PT_IL_CLAIM";
			    }
			   
			    
}

/*End*/
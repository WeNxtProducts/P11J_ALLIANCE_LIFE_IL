package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_DOC_SETUP_COMPOSITE_ACTION {

	private PM_IL_DOC_SETUP_ACTION PM_IL_DOC_SETUP_ACTION_BEAN;

	private PM_IL_DOC_DFLT_CHARGE_ACTION PM_IL_DOC_DFLT_CHARGE_ACTION_BEAN;

	private PM_IL_DOC_NO_RANGE_ACTION PM_IL_DOC_NO_RANGE_ACTION_BEAN;

	private PM_IL_DOC_NO_SETUP_ACTION PM_IL_DOC_NO_SETUP_ACTION_BEAN;

	private PM_IL_DOC_REMINDERS_ACTION PM_IL_DOC_REMINDERS_ACTION = null;

	private PM_IL_DOC_MED_HIST_ACTION PM_IL_DOC_MED_HIST_ACTION_BEAN = null;

	private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN = null;

	private PM_IL_DOC_TODO_LIST_ACTION PM_IL_DOC_TODO_LIST_ACTION_BEAN = null;

	// private TabbedBar tabbedBar;
	UIWizard wizard;

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION() {
		wizard = new UIWizard();
		PM_IL_DOC_SETUP_ACTION_BEAN = new PM_IL_DOC_SETUP_ACTION();
		PM_IL_DOC_DFLT_CHARGE_ACTION_BEAN = new PM_IL_DOC_DFLT_CHARGE_ACTION();
		PM_IL_DOC_NO_RANGE_ACTION_BEAN = new PM_IL_DOC_NO_RANGE_ACTION();
		PM_IL_DOC_NO_SETUP_ACTION_BEAN = new PM_IL_DOC_NO_SETUP_ACTION();
		PM_IL_DOC_REMINDERS_ACTION = new PM_IL_DOC_REMINDERS_ACTION();
		PM_IL_DOC_MED_HIST_ACTION_BEAN = new PM_IL_DOC_MED_HIST_ACTION();
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
		PM_IL_DOC_TODO_LIST_ACTION_BEAN = new PM_IL_DOC_TODO_LIST_ACTION();
		PM_IL_DOC_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_NO_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_NO_RANGE_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_DFLT_CHARGE_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_TODO_LIST_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_MED_HIST_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_REMINDERS_ACTION.compositeAction = this;

		// tab Creation
		/*
		 * tabbedBar = new TabbedBar(); try { // Adding tabs // id action value
		 * disabled tabbedBar.addTab(1,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDocumentSetup}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_SETUP$TAB"), false);
		 * tabbedBar.addTab(2,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDocumentNumber}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_NO$TAB"), false);
		 * tabbedBar.addTab(3,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDocumentNumberRange}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_NO_RANGE$TAB"), true);
		 * tabbedBar.addTab(4,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDefaultCharges}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_DFLT_CHRG$TAB"), false);
		 * tabbedBar.addTab(5,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDocumentTodoList}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_TODO_LIST$TAB"), false);
		 * tabbedBar.addTab(6,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callMedicalHistory}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_MED_HISTORY$TAB"), false);
		 * tabbedBar.addTab(7,
		 * "#{PM_IL_DOC_SETUP_COMPOSITE_ACTION.callDocumentReminder}",
		 * Messages.getString("messageProperties_PILM013_APAC",
		 * "PILM013_APAC$PM_IL_DOC_SETUP$DOC_REMINDER$TAB"), false);
		 *  } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public String callDocumentSetup() {
		getPM_IL_DOC_SETUP_ACTION_BEAN().PRE_BLOCK();
		if (getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getROWID() == null) {
			getPM_IL_DOC_SETUP_ACTION_BEAN().WHEN_CREATE_RECORD();
		}
		if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN()
				.getROWID() == null
				&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
						.equalsIgnoreCase("000")) {
			getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
		}

		return "DocumentSetup";
	}

	public String callDocumentNumber() {
		/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719438*/
		wizard.enableWizardItem("DocumentNumberRange");
		/*end*/

		getPM_IL_DOC_NO_SETUP_ACTION_BEAN().PRE_BLOCK();
		// getPM_IL_DOC_NO_SETUP_ACTION_BEAN().WHEN_CREATE_RECORD(getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN());
		if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN() == null) {
			getPM_IL_DOC_NO_SETUP_ACTION_BEAN().WHEN_NEW_RECORD_INSTANCE(
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_NO_SETUP_BEAN());
		}

		getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPm_il_doc_no_setup_delegate()
				.getDocumentNoSetupValues(getPM_IL_DOC_NO_SETUP_ACTION_BEAN());
		if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN()
				.getROWID() != null) {
			getPM_IL_DOC_NO_SETUP_ACTION_BEAN().setFieldProperty();
			// getTabbedBar().setTabEnabled(3);
		} else {
			// getTabbedBar().setTabDisabled(3);
		}
		return "DocumentNumber";
	}

	public String callDefaultCharges() {
		try {
			List outputList = getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN()
					.getPm_il_doc_dflt_charge_delegate()
					.getDocumentDefaultChargeValues();
			/* PRE BLOCK */
			getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().PRE_BLOCK();
			getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().WHEN_NEW_BLOCK_INSTANCE();
			if (outputList.size() > 0) {
				getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getDataTableList()
						.clear();
				for (int index = 0; index < outputList.size(); index++) {
					PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE) outputList
							.get(index);
					/* POST-QUERY */
					String CODE_DESC = new PILM013_APAC_DBProcedures()
							.P_VAL_CODES("IL_CHARGE", pm_il_doc_dflt_charge
									.getDDCHG_CODE(), "N");
					pm_il_doc_dflt_charge.setUI_M_DDCHG_CODE_DESC(CODE_DESC);
					getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getDataTableList()
							.add(pm_il_doc_dflt_charge);

					PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN = null;
					Iterator<PM_IL_DOC_DFLT_CHARGE> iterator = getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN()
							.getDataTableList().iterator();

					while (iterator.hasNext()) {
						PM_IL_DOC_DFLT_CHARGE_BEAN = iterator.next();
						PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(false);
					}
					if (getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN()
							.getDataTableList().size() != 0) {
						PM_IL_DOC_DFLT_CHARGE_BEAN = (PM_IL_DOC_DFLT_CHARGE) getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN()
								.getDataTableList().get(0);
						getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN()
								.setPM_IL_DOC_DFLT_CHARGE_BEAN(
										PM_IL_DOC_DFLT_CHARGE_BEAN);
						PM_IL_DOC_DFLT_CHARGE_BEAN.setRowSelected(true);
					}
				}

			} else {
				
				/*added by raja on 14-08-2017 for ZBILQC-1726834*/
				getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().setDDCHG_CUST_SHARE_PERC(100.0);				
				/*end*/
				
				if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
						&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
								.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
								.equalsIgnoreCase("000")) {
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
				}
			}
			
			getData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DefaultCharges";
	}

	public String callDocumentTodoList() {
		DBProcedures procedures = new DBProcedures();
		try {
			getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getDataTableList().clear();
			List outputList = getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().delegate
					.getDocumentTODOGroupValues();
			/* PRE BLOCK */
			getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().PRE_BLOCK();
			if (outputList.size() > 0) {
				for (int index = 0; index < outputList.size(); index++) {
					PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = (PM_IL_DOC_TODO_GROUP) outputList
							.get(index);
					/* POST QUERY */
					ArrayList list = procedures.P_VAL_SYSTEM("IL_TODO_GRP",
							pm_il_doc_todo_group.getDTG_GROUP_TYPE(), "E");
					getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
							.getPM_IL_DOC_TODO_GROUP_BEAN()
							.setUI_M_DTG_GROUP_TYPE_DESC((String) list.get(0));
					pm_il_doc_todo_group
							.setUI_M_DTG_GROUP_TYPE_DESC((String) list.get(0));
					getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getDataTableList()
							.add(pm_il_doc_todo_group);

					PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = null;
					Iterator<PM_IL_DOC_TODO_GROUP> iterator = getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
							.getDataTableList().iterator();

					while (iterator.hasNext()) {
						PM_IL_DOC_TODO_GROUP_BEAN = iterator.next();
						PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(false);
					}
					if (getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
							.getDataTableList().size() != 0) {
						PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
								.getDataTableList().get(0);
						getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
								.setPM_IL_DOC_TODO_GROUP_BEAN(
										PM_IL_DOC_TODO_GROUP_BEAN);
						PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
					}
				}
			} else {
				if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
						&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
								.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
								.equalsIgnoreCase("000")) {
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "TODOList";		
	}

	public String callMedicalHistory() {

		try {
			List outputList = getPM_IL_DOC_MED_HIST_ACTION_BEAN().pm_il_doc_med_hist_action_delegate
					.getDocumentMedicalHistoryValues();
			getPM_IL_DOC_MED_HIST_ACTION_BEAN().PRE_BLOCK();
			getPM_IL_DOC_MED_HIST_ACTION_BEAN().WHEN_NEW_BLOCK_INSTANCE();
			if (outputList.size() > 0) {
				getPM_IL_DOC_MED_HIST_ACTION_BEAN().getDataTableList().clear();
				for (int index = 0; index < outputList.size(); index++) {
					PM_IL_DOC_MED_HIST pm_il_doc_med_hist = (PM_IL_DOC_MED_HIST) outputList
							.get(index);
					getPM_IL_DOC_MED_HIST_ACTION_BEAN().getDataTableList().add(
							pm_il_doc_med_hist);

					PM_IL_DOC_MED_HIST PM_IL_DOC_MED_HIST_BEAN = null;
					Iterator<PM_IL_DOC_MED_HIST> iterator = getPM_IL_DOC_MED_HIST_ACTION_BEAN()
							.getDataTableList().iterator();

					while (iterator.hasNext()) {
						PM_IL_DOC_MED_HIST_BEAN = iterator.next();
						PM_IL_DOC_MED_HIST_BEAN.setRowSelected(false);
					}
					if (getPM_IL_DOC_MED_HIST_ACTION_BEAN().getDataTableList()
							.size() != 0) {
						PM_IL_DOC_MED_HIST_BEAN = (PM_IL_DOC_MED_HIST) getPM_IL_DOC_MED_HIST_ACTION_BEAN()
								.getDataTableList().get(0);
						getPM_IL_DOC_MED_HIST_ACTION_BEAN()
								.setPM_IL_DOC_MED_HIST_BEAN(
										PM_IL_DOC_MED_HIST_BEAN);
						PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);
					}
				}
			} else {
				if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
						&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
								.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
								.equalsIgnoreCase("000")) {
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "MedicalHistory";
	}

	public String callDocumentReminder() {

		try {
			List outputList = getPM_IL_DOC_REMINDERS_ACTION()
					.getPm_il_doc_reminders_action_delegate()
					.getDocumentRemainderValues();
			if (outputList.size() > 0) {
				getPM_IL_DOC_REMINDERS_ACTION().getDataTableList().clear();
				for (int index = 0; index < outputList.size(); index++) {
					PM_IL_DOC_REMINDERS pm_il_doc_reminders = (PM_IL_DOC_REMINDERS) outputList
							.get(index);
					/* POST QUERY */
					getPM_IL_DOC_REMINDERS_ACTION().POST_QUERY(
							pm_il_doc_reminders);
					getPM_IL_DOC_REMINDERS_ACTION().getDataTableList().add(
							pm_il_doc_reminders);

					PM_IL_DOC_REMINDERS pm_il_doc_reminders_bean = null;
					Iterator<PM_IL_DOC_REMINDERS> iterator = getPM_IL_DOC_REMINDERS_ACTION()
							.getDataTableList().iterator();
					while (iterator.hasNext()) {
						pm_il_doc_reminders_bean = iterator.next();
						pm_il_doc_reminders_bean.setRowSelected(false);
					}
					if (getPM_IL_DOC_REMINDERS_ACTION().getDataTableList()
							.size() != 0) {
						pm_il_doc_reminders_bean = (PM_IL_DOC_REMINDERS) getPM_IL_DOC_REMINDERS_ACTION()
								.getDataTableList().get(0);
						getPM_IL_DOC_REMINDERS_ACTION()
								.setPM_IL_DOC_REMINDERS_BEAN(
										pm_il_doc_reminders_bean);
						pm_il_doc_reminders_bean.setRowSelected(true);
					}
				}

			} else {

				if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
						&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
								.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
								.equalsIgnoreCase("000")) {
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DocumentReminder";
	}

	public String callDocumentNumberRange() {
		System.out.println("STATUS::"
				+ getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().isDeletedStatus());
		if (!getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN()
				.isDeletedStatus()) {

			List outputList = getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
					.getPm_il_doc_no_range_delegate()
					.getDocumentNoRangeValues();
			if (outputList.size() > 0) {
				getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList().clear();
				for (int index = 0; index < outputList.size(); index++) {
					PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) outputList
							.get(index);
					// getPM_IL_DOC_NO_SETUP_ACTION_BEAN().POST_BLOCK(getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN(),
					// getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getPM_IL_DOC_NO_RANGE_BEAN());
					getPM_IL_DOC_NO_RANGE_ACTION_BEAN().POST_QUERY(
							getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
									.getPM_IL_DOC_NO_SETUP_BEAN(),
							pm_il_doc_no_range);
					getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList().add(
							pm_il_doc_no_range);

					PM_IL_DOC_NO_RANGE PM_IL_DOC_NO_RANGE_BEAN = null;
					Iterator<PM_IL_DOC_NO_RANGE> iterator = getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
							.getDataTableList().iterator();
					while (iterator.hasNext()) {
						PM_IL_DOC_NO_RANGE_BEAN = iterator.next();
						PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(false);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setLevel1_Caption(
								getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
										.getPM_IL_DOC_NO_SETUP_BEAN(),
								PM_IL_DOC_NO_RANGE_BEAN);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setLevel2_Caption(
								getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
										.getPM_IL_DOC_NO_SETUP_BEAN(),
								PM_IL_DOC_NO_RANGE_BEAN);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setLevel3_Caption(
								getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
										.getPM_IL_DOC_NO_SETUP_BEAN(),
								PM_IL_DOC_NO_RANGE_BEAN);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setLevel4_Caption(
								getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
										.getPM_IL_DOC_NO_SETUP_BEAN(),
								PM_IL_DOC_NO_RANGE_BEAN);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN().setLevel5_Caption(
								getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
										.getPM_IL_DOC_NO_SETUP_BEAN(),
								PM_IL_DOC_NO_RANGE_BEAN);
					}

					// this.setInterestDetailList(interestList);
					if (getPM_IL_DOC_NO_RANGE_ACTION_BEAN().getDataTableList()
							.size() != 0) {
						PM_IL_DOC_NO_RANGE_BEAN = (PM_IL_DOC_NO_RANGE) getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
								.getDataTableList().get(0);
						getPM_IL_DOC_NO_RANGE_ACTION_BEAN()
								.setPM_IL_DOC_NO_RANGE_BEAN(
										PM_IL_DOC_NO_RANGE_BEAN);
						PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
					}
				}
			} else {
				if (getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
						&& !getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
								.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
								.equalsIgnoreCase("000")) {
					getPM_IL_DOC_NO_SETUP_ACTION_BEAN().insertData();
				}

			}
		}
		return "DocumentNumberRange";
	}

	/*
	 * public String disableTab(int tabId){ TabbedBar tabbedBar = null;
	 * tabbedBar = getTabbedBar(); if(tabbedBar != null){
	 * tabbedBar.setTabDisabled(tabId);
	 *  } return null; } public String enableTab(int tabId){ TabbedBar tabbedBar =
	 * null; tabbedBar = getTabbedBar(); if(tabbedBar != null){
	 * tabbedBar.setTabEnabled(tabId); } return null; }
	 */
	public PM_IL_DOC_SETUP_ACTION getPM_IL_DOC_SETUP_ACTION_BEAN() {
		return PM_IL_DOC_SETUP_ACTION_BEAN;
	}

	public void setPM_IL_DOC_SETUP_ACTION_BEAN(
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action_bean) {
		PM_IL_DOC_SETUP_ACTION_BEAN = pm_il_doc_setup_action_bean;
	}

	/*
	 * public TabbedBar getTabbedBar() { return tabbedBar; }
	 * 
	 * 
	 * public void setTabbedBar(TabbedBar tabbedBar) { this.tabbedBar =
	 * tabbedBar; }
	 */
	public PM_IL_DOC_DFLT_CHARGE_ACTION getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN() {
		return PM_IL_DOC_DFLT_CHARGE_ACTION_BEAN;
	}

	public void setPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN(
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action_bean) {
		PM_IL_DOC_DFLT_CHARGE_ACTION_BEAN = pm_il_doc_dflt_charge_action_bean;
	}

	public PM_IL_DOC_NO_RANGE_ACTION getPM_IL_DOC_NO_RANGE_ACTION_BEAN() {
		return PM_IL_DOC_NO_RANGE_ACTION_BEAN;
	}

	public void setPM_IL_DOC_NO_RANGE_ACTION_BEAN(
			PM_IL_DOC_NO_RANGE_ACTION pm_il_doc_no_range_action_bean) {
		PM_IL_DOC_NO_RANGE_ACTION_BEAN = pm_il_doc_no_range_action_bean;
	}

	public PM_IL_DOC_NO_SETUP_ACTION getPM_IL_DOC_NO_SETUP_ACTION_BEAN() {
		return PM_IL_DOC_NO_SETUP_ACTION_BEAN;
	}

	public void setPM_IL_DOC_NO_SETUP_ACTION_BEAN(
			PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action_bean) {
		PM_IL_DOC_NO_SETUP_ACTION_BEAN = pm_il_doc_no_setup_action_bean;
	}

	public PM_IL_DOC_REMINDERS_ACTION getPM_IL_DOC_REMINDERS_ACTION() {
		return PM_IL_DOC_REMINDERS_ACTION;
	}

	public void setPM_IL_DOC_REMINDERS_ACTION(
			PM_IL_DOC_REMINDERS_ACTION pm_il_doc_reminders_action) {
		PM_IL_DOC_REMINDERS_ACTION = pm_il_doc_reminders_action;
	}

	public PM_IL_DOC_MED_HIST_ACTION getPM_IL_DOC_MED_HIST_ACTION_BEAN() {
		return PM_IL_DOC_MED_HIST_ACTION_BEAN;
	}

	public void setPM_IL_DOC_MED_HIST_ACTION_BEAN(
			PM_IL_DOC_MED_HIST_ACTION pm_il_doc_med_hist_action_bean) {
		PM_IL_DOC_MED_HIST_ACTION_BEAN = pm_il_doc_med_hist_action_bean;
	}

	public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN() {
		return PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	}

	public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(
			PM_IL_DOC_TODO_GROUP_ACTION pm_il_doc_todo_group_action_bean) {
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = pm_il_doc_todo_group_action_bean;
	}

	public PM_IL_DOC_TODO_LIST_ACTION getPM_IL_DOC_TODO_LIST_ACTION_BEAN() {
		return PM_IL_DOC_TODO_LIST_ACTION_BEAN;
	}

	public void setPM_IL_DOC_TODO_LIST_ACTION_BEAN(
			PM_IL_DOC_TODO_LIST_ACTION pm_il_doc_todo_list_action_bean) {
		PM_IL_DOC_TODO_LIST_ACTION_BEAN = pm_il_doc_todo_list_action_bean;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}
	public String navigationEnabled() {
		setImmediate(true);
		//getWizard().setImmediate("true");
		return "";

	}
	
	/*Added by Janani on 03.05.2018 for undo button issue*/
	
	  private void setImmediate(boolean flag) {
	    	this.PM_IL_DOC_NO_SETUP_ACTION_BEAN.getErrorMap().clear();
	    	this.PM_IL_DOC_NO_SETUP_ACTION_BEAN.getWarningMap().clear();
	    	
	     }
	  
	  /*End*/
	
	//ADDED by saranya for suggestion product_from and to description issue on 11-05-2016
	public void getData() throws DBException, SQLException
	{
		
		
		// added by saranya 
		
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		System.out.println("inside of suggession");

			queryString = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE=?";
			
			System.out.println("prod cod:::::::::::"+getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().getDDCHG_PROD_CODE_FM());
			resultSet = handler.executeSelectStatement(queryString, connection, new Object[]{getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().getDDCHG_PROD_CODE_FM()});
			while (resultSet.next()) {
				getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().setDDCHG_PROD_CODE_FM_DESC(resultSet.getString("PROD_DESC"));
			}
			
			ResultSet resultSet1 = null;
			CRUDHandler handler1 = new CRUDHandler();
			Connection connection1 = CommonUtils.getConnection();
			String queryString1 = null;
			System.out.println("inside of suggession");

				queryString1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE=?";
				
				System.out.println("prod cod:::::::::::"+getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().getDDCHG_PROD_CODE_FM());
				resultSet1 = handler.executeSelectStatement(queryString1, connection1, new Object[]{getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().getDDCHG_PROD_CODE_TO()});
				while (resultSet1.next()) {
					getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getPM_IL_DOC_DFLT_CHARGE_BEAN().setDDCHG_PROD_CODE_TO_DESC(resultSet1.getString("PROD_DESC"));
				}
			
		
		//end
		
		
	}

	
}

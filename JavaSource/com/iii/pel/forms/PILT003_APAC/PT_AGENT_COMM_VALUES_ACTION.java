package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_STATUS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_AGENT_COMM_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACV_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ACV_AGENT_CODE;

	private HtmlOutputLabel COMP_ACV_COMM_CODE_LABEL;

	private HtmlInputText COMP_ACV_COMM_CODE;

	private HtmlOutputLabel COMP_ACV_LEVEL_LABEL;

	private HtmlInputText COMP_ACV_LEVEL;

	private HtmlOutputLabel COMP_ACV_YEAR_LABEL;

	private HtmlInputText COMP_ACV_YEAR;

	private HtmlOutputLabel COMP_ACV_RATE_LABEL;

	private HtmlInputText COMP_ACV_RATE;

	private HtmlOutputLabel COMP_ACV_RATE_PER_LABEL;

	private HtmlInputText COMP_ACV_RATE_PER;

	private HtmlOutputLabel COMP_ACV_FC_VALUE_LABEL;

	private HtmlInputText COMP_ACV_FC_VALUE;

	private HtmlOutputLabel COMP_ACV_LC_VALUE_LABEL;

	private HtmlInputText COMP_ACV_LC_VALUE;

	private HtmlOutputLabel COMP_UI_M_ACV_AGENT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_AGENT_DESC;

	private HtmlOutputLabel COMP_UI_M_ACV_COMM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_COMM_DESC;

	private HtmlOutputLabel COMP_ACV_COVER_CODE_LABEL;

	private HtmlInputText COMP_ACV_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_ACV_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_COVER_DESC;

	private HtmlOutputLabel COMP_ACV_AGENT_RANK_CODE_LABEL;

	private HtmlInputText COMP_ACV_AGENT_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ACV_AGENT_RANK_CODE;

	private HtmlOutputLabel COMP_ACV_COMM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACV_COMM_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_ACV_MAIN;

	private PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN;
	//newly added for broker deductions
	private HtmlInputText COMP_ACV_TOT_FC_DED;
	private HtmlInputText COMP_ACV_TOT_LC_DED;
	private HtmlInputText COMP_ACV_NET_FC_VALUE;
	private HtmlInputText COMP_ACV_NET_LC_VALUE;
	private HtmlOutputLabel COMP_ACV_TOT_FC_DED_LABEL;
	private HtmlOutputLabel COMP_ACV_TOT_LC_DED_LABEL;
	private HtmlOutputLabel COMP_ACV_NET_FC_VALUE_LABEL;
	private HtmlOutputLabel COMP_ACV_NET_LC_VALUE_LABEL;
	
	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_AGENT_COMM_VALUES_HELPER helper;

	private List<PT_AGENT_COMM_VALUES> dataList_PT_AGENT_COMM_VALUES = new ArrayList<PT_AGENT_COMM_VALUES>();

	 private UIData dataTable;

	private List<SelectItem> listACV_COMM_TYPE = new ArrayList<SelectItem>();


	
	/*ADDED BY DHINESH NEW 3 FIELDS ADDED ON 17.3.2016*/
	
	
	private HtmlOutputLabel COMP_ACV_FLEX_04_LABEL;
	private HtmlOutputLabel COMP_ACV_FLEX_05_LABEL;
	private HtmlOutputLabel COMP_ACV_FLEX_06_LABEL;
	
	private HtmlInputText COMP_ACV_FLEX_04;
	private HtmlInputText COMP_ACV_FLEX_05;
	private HtmlCalendar COMP_ACV_FLEX_06;
	
	
	private HtmlInputText COMP_UI_M_ACV_FLEX_04_DESC;
	
	
	public HtmlInputText getCOMP_UI_M_ACV_FLEX_04_DESC() {
		return COMP_UI_M_ACV_FLEX_04_DESC;
	}

	public void setCOMP_UI_M_ACV_FLEX_04_DESC(
			HtmlInputText cOMP_UI_M_ACV_FLEX_04_DESC) {
		COMP_UI_M_ACV_FLEX_04_DESC = cOMP_UI_M_ACV_FLEX_04_DESC;
	}

	public HtmlOutputLabel getCOMP_ACV_FLEX_04_LABEL() {
		return COMP_ACV_FLEX_04_LABEL;
	}

	public void setCOMP_ACV_FLEX_04_LABEL(HtmlOutputLabel cOMP_ACV_FLEX_04_LABEL) {
		COMP_ACV_FLEX_04_LABEL = cOMP_ACV_FLEX_04_LABEL;
	}

	public HtmlOutputLabel getCOMP_ACV_FLEX_05_LABEL() {
		return COMP_ACV_FLEX_05_LABEL;
	}

	public void setCOMP_ACV_FLEX_05_LABEL(HtmlOutputLabel cOMP_ACV_FLEX_05_LABEL) {
		COMP_ACV_FLEX_05_LABEL = cOMP_ACV_FLEX_05_LABEL;
	}

	public HtmlOutputLabel getCOMP_ACV_FLEX_06_LABEL() {
		return COMP_ACV_FLEX_06_LABEL;
	}

	public void setCOMP_ACV_FLEX_06_LABEL(HtmlOutputLabel cOMP_ACV_FLEX_06_LABEL) {
		COMP_ACV_FLEX_06_LABEL = cOMP_ACV_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_ACV_FLEX_04() {
		return COMP_ACV_FLEX_04;
	}

	public void setCOMP_ACV_FLEX_04(HtmlInputText cOMP_ACV_FLEX_04) {
		COMP_ACV_FLEX_04 = cOMP_ACV_FLEX_04;
	}

	public HtmlInputText getCOMP_ACV_FLEX_05() {
		return COMP_ACV_FLEX_05;
	}

	public void setCOMP_ACV_FLEX_05(HtmlInputText cOMP_ACV_FLEX_05) {
		COMP_ACV_FLEX_05 = cOMP_ACV_FLEX_05;
	}

	public HtmlCalendar getCOMP_ACV_FLEX_06() {
		return COMP_ACV_FLEX_06;
	}

	public void setCOMP_ACV_FLEX_06(HtmlCalendar cOMP_ACV_FLEX_06) {
		COMP_ACV_FLEX_06 = cOMP_ACV_FLEX_06;
	}
	
	
	/*END*/

	public PT_AGENT_COMM_VALUES_ACTION(){
	
	
	PT_AGENT_COMM_VALUES_BEAN = new PT_AGENT_COMM_VALUES();
	helper = new PT_AGENT_COMM_VALUES_HELPER();
	}

	public HtmlOutputLabel getCOMP_ACV_AGENT_CODE_LABEL() {
		return COMP_ACV_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_AGENT_CODE() {
		return COMP_ACV_AGENT_CODE;
	}

	public void setCOMP_ACV_AGENT_CODE_LABEL(HtmlOutputLabel COMP_ACV_AGENT_CODE_LABEL) {
		this.COMP_ACV_AGENT_CODE_LABEL = COMP_ACV_AGENT_CODE_LABEL;
	}

	public void setCOMP_ACV_AGENT_CODE(HtmlInputText COMP_ACV_AGENT_CODE) {
		this.COMP_ACV_AGENT_CODE = COMP_ACV_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_COMM_CODE_LABEL() {
		return COMP_ACV_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_COMM_CODE() {
		return COMP_ACV_COMM_CODE;
	}

	public void setCOMP_ACV_COMM_CODE_LABEL(HtmlOutputLabel COMP_ACV_COMM_CODE_LABEL) {
		this.COMP_ACV_COMM_CODE_LABEL = COMP_ACV_COMM_CODE_LABEL;
	}

	public void setCOMP_ACV_COMM_CODE(HtmlInputText COMP_ACV_COMM_CODE) {
		this.COMP_ACV_COMM_CODE = COMP_ACV_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_LEVEL_LABEL() {
		return COMP_ACV_LEVEL_LABEL;
	}

	public HtmlInputText getCOMP_ACV_LEVEL() {
		return COMP_ACV_LEVEL;
	}

	public void setCOMP_ACV_LEVEL_LABEL(HtmlOutputLabel COMP_ACV_LEVEL_LABEL) {
		this.COMP_ACV_LEVEL_LABEL = COMP_ACV_LEVEL_LABEL;
	}

	public void setCOMP_ACV_LEVEL(HtmlInputText COMP_ACV_LEVEL) {
		this.COMP_ACV_LEVEL = COMP_ACV_LEVEL;
	}

	public HtmlOutputLabel getCOMP_ACV_YEAR_LABEL() {
		return COMP_ACV_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_ACV_YEAR() {
		return COMP_ACV_YEAR;
	}

	public void setCOMP_ACV_YEAR_LABEL(HtmlOutputLabel COMP_ACV_YEAR_LABEL) {
		this.COMP_ACV_YEAR_LABEL = COMP_ACV_YEAR_LABEL;
	}

	public void setCOMP_ACV_YEAR(HtmlInputText COMP_ACV_YEAR) {
		this.COMP_ACV_YEAR = COMP_ACV_YEAR;
	}

	public HtmlOutputLabel getCOMP_ACV_RATE_LABEL() {
		return COMP_ACV_RATE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_RATE() {
		return COMP_ACV_RATE;
	}

	public void setCOMP_ACV_RATE_LABEL(HtmlOutputLabel COMP_ACV_RATE_LABEL) {
		this.COMP_ACV_RATE_LABEL = COMP_ACV_RATE_LABEL;
	}

	public void setCOMP_ACV_RATE(HtmlInputText COMP_ACV_RATE) {
		this.COMP_ACV_RATE = COMP_ACV_RATE;
	}

	public HtmlOutputLabel getCOMP_ACV_RATE_PER_LABEL() {
		return COMP_ACV_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_ACV_RATE_PER() {
		return COMP_ACV_RATE_PER;
	}

	public void setCOMP_ACV_RATE_PER_LABEL(HtmlOutputLabel COMP_ACV_RATE_PER_LABEL) {
		this.COMP_ACV_RATE_PER_LABEL = COMP_ACV_RATE_PER_LABEL;
	}

	public void setCOMP_ACV_RATE_PER(HtmlInputText COMP_ACV_RATE_PER) {
		this.COMP_ACV_RATE_PER = COMP_ACV_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_ACV_FC_VALUE_LABEL() {
		return COMP_ACV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_FC_VALUE() {
		return COMP_ACV_FC_VALUE;
	}

	public void setCOMP_ACV_FC_VALUE_LABEL(HtmlOutputLabel COMP_ACV_FC_VALUE_LABEL) {
		this.COMP_ACV_FC_VALUE_LABEL = COMP_ACV_FC_VALUE_LABEL;
	}

	public void setCOMP_ACV_FC_VALUE(HtmlInputText COMP_ACV_FC_VALUE) {
		this.COMP_ACV_FC_VALUE = COMP_ACV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_ACV_LC_VALUE_LABEL() {
		return COMP_ACV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_LC_VALUE() {
		return COMP_ACV_LC_VALUE;
	}

	public void setCOMP_ACV_LC_VALUE_LABEL(HtmlOutputLabel COMP_ACV_LC_VALUE_LABEL) {
		this.COMP_ACV_LC_VALUE_LABEL = COMP_ACV_LC_VALUE_LABEL;
	}

	public void setCOMP_ACV_LC_VALUE(HtmlInputText COMP_ACV_LC_VALUE) {
		this.COMP_ACV_LC_VALUE = COMP_ACV_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_AGENT_DESC_LABEL() {
		return COMP_UI_M_ACV_AGENT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_AGENT_DESC() {
		return COMP_UI_M_ACV_AGENT_DESC;
	}

	public void setCOMP_UI_M_ACV_AGENT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_AGENT_DESC_LABEL) {
		this.COMP_UI_M_ACV_AGENT_DESC_LABEL = COMP_UI_M_ACV_AGENT_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_AGENT_DESC(HtmlInputText COMP_UI_M_ACV_AGENT_DESC) {
		this.COMP_UI_M_ACV_AGENT_DESC = COMP_UI_M_ACV_AGENT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_COMM_DESC_LABEL() {
		return COMP_UI_M_ACV_COMM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_COMM_DESC() {
		return COMP_UI_M_ACV_COMM_DESC;
	}

	public void setCOMP_UI_M_ACV_COMM_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_COMM_DESC_LABEL) {
		this.COMP_UI_M_ACV_COMM_DESC_LABEL = COMP_UI_M_ACV_COMM_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_COMM_DESC(HtmlInputText COMP_UI_M_ACV_COMM_DESC) {
		this.COMP_UI_M_ACV_COMM_DESC = COMP_UI_M_ACV_COMM_DESC;
	}

	public HtmlOutputLabel getCOMP_ACV_COVER_CODE_LABEL() {
		return COMP_ACV_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_COVER_CODE() {
		return COMP_ACV_COVER_CODE;
	}

	public void setCOMP_ACV_COVER_CODE_LABEL(HtmlOutputLabel COMP_ACV_COVER_CODE_LABEL) {
		this.COMP_ACV_COVER_CODE_LABEL = COMP_ACV_COVER_CODE_LABEL;
	}

	public void setCOMP_ACV_COVER_CODE(HtmlInputText COMP_ACV_COVER_CODE) {
		this.COMP_ACV_COVER_CODE = COMP_ACV_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_COVER_DESC_LABEL() {
		return COMP_UI_M_ACV_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_COVER_DESC() {
		return COMP_UI_M_ACV_COVER_DESC;
	}

	public void setCOMP_UI_M_ACV_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_COVER_DESC_LABEL) {
		this.COMP_UI_M_ACV_COVER_DESC_LABEL = COMP_UI_M_ACV_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_COVER_DESC(HtmlInputText COMP_UI_M_ACV_COVER_DESC) {
		this.COMP_UI_M_ACV_COVER_DESC = COMP_UI_M_ACV_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_ACV_AGENT_RANK_CODE_LABEL() {
		return COMP_ACV_AGENT_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_AGENT_RANK_CODE() {
		return COMP_ACV_AGENT_RANK_CODE;
	}

	public void setCOMP_ACV_AGENT_RANK_CODE_LABEL(HtmlOutputLabel COMP_ACV_AGENT_RANK_CODE_LABEL) {
		this.COMP_ACV_AGENT_RANK_CODE_LABEL = COMP_ACV_AGENT_RANK_CODE_LABEL;
	}

	public void setCOMP_ACV_AGENT_RANK_CODE(HtmlInputText COMP_ACV_AGENT_RANK_CODE) {
		this.COMP_ACV_AGENT_RANK_CODE = COMP_ACV_AGENT_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_AGENT_RANK_CODE_LABEL() {
		return COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_AGENT_RANK_CODE() {
		return COMP_UI_M_ACV_AGENT_RANK_CODE;
	}

	public void setCOMP_UI_M_ACV_AGENT_RANK_CODE_LABEL(HtmlOutputLabel COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL) {
		this.COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL = COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_ACV_AGENT_RANK_CODE(HtmlInputText COMP_UI_M_ACV_AGENT_RANK_CODE) {
		this.COMP_UI_M_ACV_AGENT_RANK_CODE = COMP_UI_M_ACV_AGENT_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_COMM_TYPE_LABEL() {
		return COMP_ACV_COMM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACV_COMM_TYPE() {
		return COMP_ACV_COMM_TYPE;
	}

	public void setCOMP_ACV_COMM_TYPE_LABEL(HtmlOutputLabel COMP_ACV_COMM_TYPE_LABEL) {
		this.COMP_ACV_COMM_TYPE_LABEL = COMP_ACV_COMM_TYPE_LABEL;
	}

	public void setCOMP_ACV_COMM_TYPE(HtmlSelectOneMenu COMP_ACV_COMM_TYPE) {
		this.COMP_ACV_COMM_TYPE = COMP_ACV_COMM_TYPE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACV_MAIN() {
		return COMP_UI_M_BUT_ACV_MAIN;
	}

	public void setCOMP_UI_M_BUT_ACV_MAIN(HtmlCommandButton COMP_UI_M_BUT_ACV_MAIN) {
		this.COMP_UI_M_BUT_ACV_MAIN = COMP_UI_M_BUT_ACV_MAIN;
	}

	public PT_AGENT_COMM_VALUES getPT_AGENT_COMM_VALUES_BEAN() {
		return PT_AGENT_COMM_VALUES_BEAN;
	}

	public void setPT_AGENT_COMM_VALUES_BEAN(PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN) {
		this.PT_AGENT_COMM_VALUES_BEAN = PT_AGENT_COMM_VALUES_BEAN;
	}

	public List<PT_AGENT_COMM_VALUES> getDataList_PT_AGENT_COMM_VALUES() {
		return dataList_PT_AGENT_COMM_VALUES;
	}

	public void setDataListPT_AGENT_COMM_VALUES(List<PT_AGENT_COMM_VALUES> dataList_PT_AGENT_COMM_VALUES) {
		this.dataList_PT_AGENT_COMM_VALUES = dataList_PT_AGENT_COMM_VALUES;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_AGENT_COMM_VALUES_BEAN = new PT_AGENT_COMM_VALUES();
				resetAllComponent();
				resetSelectedRow();
				PT_AGENT_COMM_VALUES_BEAN.setRowSelected(true);
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

				new CRUDHandler().executeDelete(PT_AGENT_COMM_VALUES_BEAN,
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
				dataList_PT_AGENT_COMM_VALUES.remove(PT_AGENT_COMM_VALUES_BEAN);
				if (dataList_PT_AGENT_COMM_VALUES.size() > 0) {

					PT_AGENT_COMM_VALUES_BEAN = dataList_PT_AGENT_COMM_VALUES
							.get(0);
				} else if (dataList_PT_AGENT_COMM_VALUES.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_AGENT_COMM_VALUES_BEAN.setRowSelected(true);
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
	
	

	

	/**
	 * Resets all components in PT_AGENT_COMM_VALUES_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_ACV_AGENT_CODE.resetValue();
		COMP_ACV_COMM_CODE.resetValue();
		COMP_ACV_LEVEL.resetValue();
		COMP_ACV_YEAR.resetValue();
		COMP_ACV_RATE.resetValue();
		COMP_ACV_RATE_PER.resetValue();
		COMP_ACV_FC_VALUE.resetValue();
		COMP_ACV_LC_VALUE.resetValue();
		COMP_UI_M_ACV_AGENT_DESC.resetValue();
		COMP_UI_M_ACV_COMM_DESC.resetValue();
		COMP_ACV_COVER_CODE.resetValue();
		COMP_UI_M_ACV_COVER_DESC.resetValue();
		COMP_ACV_AGENT_RANK_CODE.resetValue();
		COMP_UI_M_ACV_AGENT_RANK_CODE.resetValue();
		COMP_ACV_TOT_FC_DED.resetValue();
		COMP_ACV_TOT_LC_DED.resetValue();
		COMP_ACV_NET_FC_VALUE.resetValue();
		COMP_ACV_NET_LC_VALUE.resetValue();
		 

		// Reseting HtmlSelectOneMenu
		COMP_ACV_COMM_TYPE.resetValue();


	}




	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	public List<SelectItem> getListACV_COMM_TYPE() {
		if (listACV_COMM_TYPE.size() == 0) {
			listACV_COMM_TYPE.clear();
			try {
				Connection connection = CommonUtils.getConnection();
				listACV_COMM_TYPE = new ArrayList<SelectItem>();
				listACV_COMM_TYPE = ListItemUtil.getDropDownListValue(connection,
						"PILT003_APAC", "PT_IL_PREM_COLL_CHARGE",
						"PT_IL_PREM_COLL_CHARGE.PCC_APPLY_PERIOD", "IL_CHG_PRD");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listACV_COMM_TYPE;
	}
	
	public String mainAction(){
		setBlockFlag(true);
		return "PILT003_APAC_PT_IL_PREM_COLL";
	}
	
	 public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
			    resetSelectedRow();
			    PT_AGENT_COMM_VALUES_BEAN = (PT_AGENT_COMM_VALUES) dataTable.getRowData();
			    helper.POST_QUERY(PT_AGENT_COMM_VALUES_BEAN);
			    PT_AGENT_COMM_VALUES_BEAN.setRowSelected(true);
			    resetAllComponent();
			} catch (Exception exc) {
			    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			    getErrorMap().put("displayRecords", exc.getMessage());
			}

		    }
	
	 private void resetSelectedRow(){
			Iterator<PT_AGENT_COMM_VALUES> PT_AGENT_COMM_VALUES_ITR = 
				dataList_PT_AGENT_COMM_VALUES.iterator();
			while (PT_AGENT_COMM_VALUES_ITR.hasNext()) {
				PT_AGENT_COMM_VALUES_ITR.next().setRowSelected(false);
			}
		}
	/*private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL> PT_IL_PREM_COLL_ITR = dataList_PT_IL_PREM_COLL
				.iterator();
		while (PT_IL_PREM_COLL_ITR.hasNext()) {
			PT_IL_PREM_COLL_ITR.next().setRowSelected(false);
		}
	}*/
	
	
	public void onLoad(PhaseEvent event){
		 try {
				if (isBlockFlag()) {
					if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getROWID() != null){
						helper.executeQuery(compositeAction);
						helper.POST_QUERY(PT_AGENT_COMM_VALUES_BEAN);
					}
					}
					setBlockFlag(false);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			} 
	 }
	
	public void postRecord(ActionEvent event) {
		try {
			if (PT_AGENT_COMM_VALUES_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_AGENT_COMM_VALUES_BEAN,
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
				dataList_PT_AGENT_COMM_VALUES
						.add(PT_AGENT_COMM_VALUES_BEAN);
			} else if (PT_AGENT_COMM_VALUES_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PT_AGENT_COMM_VALUES_BEAN,
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

			PT_AGENT_COMM_VALUES_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void setListACV_COMM_TYPE(List<SelectItem> listACV_COMM_TYPE) {
		this.listACV_COMM_TYPE = listACV_COMM_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_ACV_TOT_FC_DED() {
		return COMP_ACV_TOT_FC_DED;
	}

	public void setCOMP_ACV_TOT_FC_DED(HtmlInputText comp_acv_tot_fc_ded) {
		COMP_ACV_TOT_FC_DED = comp_acv_tot_fc_ded;
	}

	public HtmlInputText getCOMP_ACV_TOT_LC_DED() {
		return COMP_ACV_TOT_LC_DED;
	}

	public void setCOMP_ACV_TOT_LC_DED(HtmlInputText comp_acv_tot_lc_ded) {
		COMP_ACV_TOT_LC_DED = comp_acv_tot_lc_ded;
	}

	public HtmlInputText getCOMP_ACV_NET_FC_VALUE() {
		return COMP_ACV_NET_FC_VALUE;
	}

	public void setCOMP_ACV_NET_FC_VALUE(HtmlInputText comp_acv_net_fc_value) {
		COMP_ACV_NET_FC_VALUE = comp_acv_net_fc_value;
	}

	public HtmlInputText getCOMP_ACV_NET_LC_VALUE() {
		return COMP_ACV_NET_LC_VALUE;
	}

	public void setCOMP_ACV_NET_LC_VALUE(HtmlInputText comp_acv_net_lc_value) {
		COMP_ACV_NET_LC_VALUE = comp_acv_net_lc_value;
	}

	public HtmlOutputLabel getCOMP_ACV_TOT_FC_DED_LABEL() {
		return COMP_ACV_TOT_FC_DED_LABEL;
	}

	public void setCOMP_ACV_TOT_FC_DED_LABEL(
			HtmlOutputLabel comp_acv_tot_fc_ded_label) {
		COMP_ACV_TOT_FC_DED_LABEL = comp_acv_tot_fc_ded_label;
	}

	public HtmlOutputLabel getCOMP_ACV_TOT_LC_DED_LABEL() {
		return COMP_ACV_TOT_LC_DED_LABEL;
	}

	public void setCOMP_ACV_TOT_LC_DED_LABEL(
			HtmlOutputLabel comp_acv_tot_lc_ded_label) {
		COMP_ACV_TOT_LC_DED_LABEL = comp_acv_tot_lc_ded_label;
	}

	public HtmlOutputLabel getCOMP_ACV_NET_FC_VALUE_LABEL() {
		return COMP_ACV_NET_FC_VALUE_LABEL;
	}

	public void setCOMP_ACV_NET_FC_VALUE_LABEL(
			HtmlOutputLabel comp_acv_net_fc_value_label) {
		COMP_ACV_NET_FC_VALUE_LABEL = comp_acv_net_fc_value_label;
	}

	public HtmlOutputLabel getCOMP_ACV_NET_LC_VALUE_LABEL() {
		return COMP_ACV_NET_LC_VALUE_LABEL;
	}

	public void setCOMP_ACV_NET_LC_VALUE_LABEL(
			HtmlOutputLabel comp_acv_net_lc_value_label) {
		COMP_ACV_NET_LC_VALUE_LABEL = comp_acv_net_lc_value_label;
	}
	
	
	/*ADDED BY DHINESH 3 NEW FIELDS ON 17.3.2016*/
	
	public ArrayList<LovBean> lovACV_FLEX_04(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PILT003_APAC_QUERYCONSTANTS.ACV_FLEX_04_Values;
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				query = PILT003_APAC_QUERYCONSTANTS.ACV_FLEX_04_Values_LIKE;
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void validateACV_FLEX_04(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("************** Enter The validatorACV_FLEX_06 Method ****************");
			System.out.println("value     : "+value.toString());
			System.out.println("PT_AGENT_COMM_VALUES_BEAN.getACV_FLEX_06_VALUE() : "+PT_AGENT_COMM_VALUES_BEAN.getACV_FLEX_06_VALUE());
			System.out.println("**************                      End ******************************");
				PT_AGENT_COMM_VALUES_BEAN.setACV_FLEX_04_VALUE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	
	
	 public void validatorACV_FLEX_06(FacesContext context,
				UIComponent component, Object value) {
			try {
				System.out.println("************** Enter The validatorACV_FLEX_06 Method ****************");
				System.out.println("value     : "+value.toString());
				System.out.println("PT_AGENT_COMM_VALUES_BEAN.getACV_FLEX_06_VALUE() : "+PT_AGENT_COMM_VALUES_BEAN.getACV_FLEX_06_VALUE());
				System.out.println("**************                      End ******************************");
					PT_AGENT_COMM_VALUES_BEAN.setACV_FLEX_06_VALUE((Date) value);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}	
	 
	 
	 
	 /*END*/
	
	
	
	
	
}
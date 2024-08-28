package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FAC_DISC_LOAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_COVER_CODE;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_FDL_SRNO_LABEL;

	private HtmlInputText COMP_FDL_SRNO;

	private HtmlOutputLabel COMP_FDL_DISC_LOAD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FDL_DISC_LOAD_TYPE;

	private HtmlOutputLabel COMP_FDL_DISC_LOAD_CODE_LABEL;

	private HtmlInputText COMP_FDL_DISC_LOAD_CODE;

	private HtmlOutputLabel COMP_FDL_APPL_PERC_LABEL;

	private HtmlInputText COMP_FDL_APPL_PERC;

	private HtmlOutputLabel COMP_FDL_RATE_LABEL;

	private HtmlInputText COMP_FDL_RATE;

	private HtmlOutputLabel COMP_FDL_RATE_PER_LABEL;

	private HtmlInputText COMP_FDL_RATE_PER;

	private HtmlOutputLabel COMP_FDL_FC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_FDL_FC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_FDL_LC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_FDL_LC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISCLOAD_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOAD_DISC_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_BACK;

	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;

	private PT_IL_FAC_DETL PT_IL_FAC_DETL_BEAN;

	private PT_IL_FAC_DISC_LOAD PT_IL_FAC_DISC_LOAD_BEAN;

	private UIData dataTable;

	private List<PT_IL_FAC_DISC_LOAD> dataListPT_IL_FAC_DISC_LOAD;

	private boolean onLoadFlag;
	
	PILT009_COMPOSITE_ACTION compositeAction;
	
	private List<SelectItem> disLoadDwn;

	public PT_IL_FAC_DISC_LOAD_ACTION() {
		dataListPT_IL_FAC_DISC_LOAD = new ArrayList<PT_IL_FAC_DISC_LOAD>();
		PT_IL_FAC_DISC_LOAD_BEAN = new PT_IL_FAC_DISC_LOAD();
		try {
			disLoadDwn = ListItemUtil.getDropDownListValue_1(CommonUtils.getConnection(), "PILT009", "PT_IL_FAC_DISC_LOAD", "PT_IL_FAC_DISC_LOAD.FDL_DISC_LOAD_TYPE", null);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_FDL_SRNO_LABEL() {
		return COMP_FDL_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_FDL_SRNO() {
		return COMP_FDL_SRNO;
	}

	public void setCOMP_FDL_SRNO_LABEL(HtmlOutputLabel COMP_FDL_SRNO_LABEL) {
		this.COMP_FDL_SRNO_LABEL = COMP_FDL_SRNO_LABEL;
	}

	public void setCOMP_FDL_SRNO(HtmlInputText COMP_FDL_SRNO) {
		this.COMP_FDL_SRNO = COMP_FDL_SRNO;
	}

	public HtmlOutputLabel getCOMP_FDL_DISC_LOAD_TYPE_LABEL() {
		return COMP_FDL_DISC_LOAD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FDL_DISC_LOAD_TYPE() {
		return COMP_FDL_DISC_LOAD_TYPE;
	}

	public void setCOMP_FDL_DISC_LOAD_TYPE_LABEL(
			HtmlOutputLabel COMP_FDL_DISC_LOAD_TYPE_LABEL) {
		this.COMP_FDL_DISC_LOAD_TYPE_LABEL = COMP_FDL_DISC_LOAD_TYPE_LABEL;
	}

	public void setCOMP_FDL_DISC_LOAD_TYPE(
			HtmlSelectOneMenu COMP_FDL_DISC_LOAD_TYPE) {
		this.COMP_FDL_DISC_LOAD_TYPE = COMP_FDL_DISC_LOAD_TYPE;
	}

	public HtmlOutputLabel getCOMP_FDL_DISC_LOAD_CODE_LABEL() {
		return COMP_FDL_DISC_LOAD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FDL_DISC_LOAD_CODE() {
		return COMP_FDL_DISC_LOAD_CODE;
	}

	public void setCOMP_FDL_DISC_LOAD_CODE_LABEL(
			HtmlOutputLabel COMP_FDL_DISC_LOAD_CODE_LABEL) {
		this.COMP_FDL_DISC_LOAD_CODE_LABEL = COMP_FDL_DISC_LOAD_CODE_LABEL;
	}

	public void setCOMP_FDL_DISC_LOAD_CODE(HtmlInputText COMP_FDL_DISC_LOAD_CODE) {
		this.COMP_FDL_DISC_LOAD_CODE = COMP_FDL_DISC_LOAD_CODE;
	}

	public HtmlOutputLabel getCOMP_FDL_APPL_PERC_LABEL() {
		return COMP_FDL_APPL_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FDL_APPL_PERC() {
		return COMP_FDL_APPL_PERC;
	}

	public void setCOMP_FDL_APPL_PERC_LABEL(
			HtmlOutputLabel COMP_FDL_APPL_PERC_LABEL) {
		this.COMP_FDL_APPL_PERC_LABEL = COMP_FDL_APPL_PERC_LABEL;
	}

	public void setCOMP_FDL_APPL_PERC(HtmlInputText COMP_FDL_APPL_PERC) {
		this.COMP_FDL_APPL_PERC = COMP_FDL_APPL_PERC;
	}

	public HtmlOutputLabel getCOMP_FDL_RATE_LABEL() {
		return COMP_FDL_RATE_LABEL;
	}

	public HtmlInputText getCOMP_FDL_RATE() {
		return COMP_FDL_RATE;
	}

	public void setCOMP_FDL_RATE_LABEL(HtmlOutputLabel COMP_FDL_RATE_LABEL) {
		this.COMP_FDL_RATE_LABEL = COMP_FDL_RATE_LABEL;
	}

	public void setCOMP_FDL_RATE(HtmlInputText COMP_FDL_RATE) {
		this.COMP_FDL_RATE = COMP_FDL_RATE;
	}

	public HtmlOutputLabel getCOMP_FDL_RATE_PER_LABEL() {
		return COMP_FDL_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_FDL_RATE_PER() {
		return COMP_FDL_RATE_PER;
	}

	public void setCOMP_FDL_RATE_PER_LABEL(
			HtmlOutputLabel COMP_FDL_RATE_PER_LABEL) {
		this.COMP_FDL_RATE_PER_LABEL = COMP_FDL_RATE_PER_LABEL;
	}

	public void setCOMP_FDL_RATE_PER(HtmlInputText COMP_FDL_RATE_PER) {
		this.COMP_FDL_RATE_PER = COMP_FDL_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_FDL_FC_DISC_LOAD_VALUE_LABEL() {
		return COMP_FDL_FC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_FDL_FC_DISC_LOAD_VALUE() {
		return COMP_FDL_FC_DISC_LOAD_VALUE;
	}

	public void setCOMP_FDL_FC_DISC_LOAD_VALUE_LABEL(
			HtmlOutputLabel COMP_FDL_FC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_FDL_FC_DISC_LOAD_VALUE_LABEL = COMP_FDL_FC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_FDL_FC_DISC_LOAD_VALUE(
			HtmlInputText COMP_FDL_FC_DISC_LOAD_VALUE) {
		this.COMP_FDL_FC_DISC_LOAD_VALUE = COMP_FDL_FC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_FDL_LC_DISC_LOAD_VALUE_LABEL() {
		return COMP_FDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_FDL_LC_DISC_LOAD_VALUE() {
		return COMP_FDL_LC_DISC_LOAD_VALUE;
	}

	public void setCOMP_FDL_LC_DISC_LOAD_VALUE_LABEL(
			HtmlOutputLabel COMP_FDL_LC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_FDL_LC_DISC_LOAD_VALUE_LABEL = COMP_FDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_FDL_LC_DISC_LOAD_VALUE(
			HtmlInputText COMP_FDL_LC_DISC_LOAD_VALUE) {
		this.COMP_FDL_LC_DISC_LOAD_VALUE = COMP_FDL_LC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISCLOAD_DESC_LABEL() {
		return COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISCLOAD_DESC() {
		return COMP_UI_M_DISCLOAD_DESC;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL) {
		this.COMP_UI_M_DISCLOAD_DESC_LABEL = COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC(HtmlInputText COMP_UI_M_DISCLOAD_DESC) {
		this.COMP_UI_M_DISCLOAD_DESC = COMP_UI_M_DISCLOAD_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAD_DISC_LOV() {
		return COMP_UI_M_BUT_LOAD_DISC_LOV;
	}

	public void setCOMP_UI_M_BUT_LOAD_DISC_LOV(
			HtmlCommandButton COMP_UI_M_BUT_LOAD_DISC_LOV) {
		this.COMP_UI_M_BUT_LOAD_DISC_LOV = COMP_UI_M_BUT_LOAD_DISC_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BACK() {
		return COMP_UI_M_BUT_BACK;
	}

	public void setCOMP_UI_M_BUT_BACK(HtmlCommandButton comp_ui_m_but_back) {
		COMP_UI_M_BUT_BACK = comp_ui_m_but_back;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public PT_IL_FAC_DETL getPT_IL_FAC_DETL_BEAN() {
		return PT_IL_FAC_DETL_BEAN;
	}

	public void setPT_IL_FAC_DETL_BEAN(PT_IL_FAC_DETL pt_il_fac_detl_bean) {
		PT_IL_FAC_DETL_BEAN = pt_il_fac_detl_bean;
	}

	public List<PT_IL_FAC_DISC_LOAD> getDataListPT_IL_FAC_DISC_LOAD() {
		return dataListPT_IL_FAC_DISC_LOAD;
	}

	public void setDataListPT_IL_FAC_DISC_LOAD(
			List<PT_IL_FAC_DISC_LOAD> dataListPT_IL_FAC_DISC_LOAD) {
		this.dataListPT_IL_FAC_DISC_LOAD = dataListPT_IL_FAC_DISC_LOAD;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_CODE_LABEL() {
		return COMP_UI_M_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_cover_code_label) {
		COMP_UI_M_COVER_CODE_LABEL = comp_ui_m_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_COVER_CODE() {
		return COMP_UI_M_COVER_CODE;
	}

	public void setCOMP_UI_M_COVER_CODE(HtmlInputText comp_ui_m_cover_code) {
		COMP_UI_M_COVER_CODE = comp_ui_m_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText comp_ui_m_cover_desc) {
		COMP_UI_M_COVER_DESC = comp_ui_m_cover_desc;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public String backToFacDtls() {
		
		return "gotoFacDtls";
	}

	public void onPageLoad(PhaseEvent event) {

		if (!isOnLoadFlag()) {
			PT_IL_FAC_DISC_LOAD_HELPER helper = new PT_IL_FAC_DISC_LOAD_HELPER();
			try {
				helper.fetchRecord(this);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current",
						"Error occured while loading the page");
				getErrorMap().put("detail",
						"Error occured while loading the page");
			}
			//setOnLoadFlag(true);
		}
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_IL_FAC_DISC_LOAD getPT_IL_FAC_DISC_LOAD_BEAN() {
		return PT_IL_FAC_DISC_LOAD_BEAN;
	}

	public void setPT_IL_FAC_DISC_LOAD_BEAN(
			PT_IL_FAC_DISC_LOAD pt_il_fac_disc_load_bean) {
		PT_IL_FAC_DISC_LOAD_BEAN = pt_il_fac_disc_load_bean;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_DISC_LOAD_BEAN = (PT_IL_FAC_DISC_LOAD) dataTable
					.getRowData();
			resetSelectedRow();
			resetAllComponent();
			PT_IL_FAC_DISC_LOAD_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_DISC_LOAD> iterator = dataListPT_IL_FAC_DISC_LOAD
				.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_COVER_CODE.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_FDL_SRNO.resetValue();
		COMP_FDL_DISC_LOAD_TYPE.resetValue();
		COMP_FDL_DISC_LOAD_CODE.resetValue();
		COMP_FDL_APPL_PERC.resetValue();
		COMP_FDL_RATE.resetValue();
		COMP_FDL_RATE_PER.resetValue();
		COMP_FDL_FC_DISC_LOAD_VALUE.resetValue();
		COMP_FDL_LC_DISC_LOAD_VALUE.resetValue();
		COMP_UI_M_DISCLOAD_DESC.resetValue();
	}

	public List<SelectItem> getDisLoadDwn() {
		return disLoadDwn;
	}

	public void setDisLoadDwn(List<SelectItem> disLoadDwn) {
		this.disLoadDwn = disLoadDwn;
	}

}

package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CUST_RETRO_DETL_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_UI_M_FCRD_COVER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FCRD_COVER_CODE;
	
	private HtmlInputText COMP_UI_M_FCRD_COVER_DESC;
	
	private HtmlOutputLabel COMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_FCRD_FC_RETRO_SUM_ASSURED;

	private HtmlOutputLabel COMP_FCRD_FC_RETRO_PREM_LABEL;

	private HtmlInputText COMP_FCRD_FC_RETRO_PREM;

	private HtmlOutputLabel COMP_FCRD_FC_RETRO_COMM_LABEL;

	private HtmlInputText COMP_FCRD_FC_RETRO_COMM;

	private HtmlOutputLabel COMP_FCRD_FC_RETRO_TAX_LABEL;

	private HtmlInputText COMP_FCRD_FC_RETRO_TAX;

	private HtmlOutputLabel COMP_FCRD_SCHD_DT_LABEL;

	private HtmlCalendar COMP_FCRD_SCHD_DT;

	private HtmlOutputLabel COMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_FCRD_LC_RETRO_SUM_ASSURED;

	private HtmlOutputLabel COMP_FCRD_LC_RETRO_COMM_LABEL;

	private HtmlInputText COMP_FCRD_LC_RETRO_COMM;

	private HtmlOutputLabel COMP_FCRD_LC_RETRO_PREM_LABEL;

	private HtmlInputText COMP_FCRD_LC_RETRO_PREM;

	private HtmlOutputLabel COMP_FCRD_LC_RETRO_TAX_LABEL;

	private HtmlInputText COMP_FCRD_LC_RETRO_TAX;

	private PT_IL_FAC_CUST_RETRO PT_IL_FAC_CUST_RETRO_BEAN;
	
	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;
	
	private PT_IL_FAC_CUST_RETRO_DETL PT_IL_FAC_CUST_RETRO_DETL_BEAN;
	
	private UIData dataTable;

	private List<PT_IL_FAC_CUST_RETRO_DETL> dataListPT_IL_FAC_CUST_RETRO_DETL = null;
	
	PILT009_COMPOSITE_ACTION compositeAction;
	
	private boolean onLoadFlag;

	public PT_IL_FAC_CUST_RETRO_DETL_ACTION() {
		dataListPT_IL_FAC_CUST_RETRO_DETL = new ArrayList<PT_IL_FAC_CUST_RETRO_DETL>();
		PT_IL_FAC_CUST_RETRO_DETL_BEAN= new PT_IL_FAC_CUST_RETRO_DETL();
	}

	public HtmlOutputLabel getCOMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL() {
		return COMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_FC_RETRO_SUM_ASSURED() {
		return COMP_FCRD_FC_RETRO_SUM_ASSURED;
	}

	public void setCOMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL) {
		this.COMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL = COMP_FCRD_FC_RETRO_SUM_ASSURED_LABEL;
	}

	public void setCOMP_FCRD_FC_RETRO_SUM_ASSURED(HtmlInputText COMP_FCRD_FC_RETRO_SUM_ASSURED) {
		this.COMP_FCRD_FC_RETRO_SUM_ASSURED = COMP_FCRD_FC_RETRO_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_FCRD_FC_RETRO_PREM_LABEL() {
		return COMP_FCRD_FC_RETRO_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_FC_RETRO_PREM() {
		return COMP_FCRD_FC_RETRO_PREM;
	}

	public void setCOMP_FCRD_FC_RETRO_PREM_LABEL(HtmlOutputLabel COMP_FCRD_FC_RETRO_PREM_LABEL) {
		this.COMP_FCRD_FC_RETRO_PREM_LABEL = COMP_FCRD_FC_RETRO_PREM_LABEL;
	}

	public void setCOMP_FCRD_FC_RETRO_PREM(HtmlInputText COMP_FCRD_FC_RETRO_PREM) {
		this.COMP_FCRD_FC_RETRO_PREM = COMP_FCRD_FC_RETRO_PREM;
	}

	public HtmlOutputLabel getCOMP_FCRD_FC_RETRO_COMM_LABEL() {
		return COMP_FCRD_FC_RETRO_COMM_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_FC_RETRO_COMM() {
		return COMP_FCRD_FC_RETRO_COMM;
	}

	public void setCOMP_FCRD_FC_RETRO_COMM_LABEL(HtmlOutputLabel COMP_FCRD_FC_RETRO_COMM_LABEL) {
		this.COMP_FCRD_FC_RETRO_COMM_LABEL = COMP_FCRD_FC_RETRO_COMM_LABEL;
	}

	public void setCOMP_FCRD_FC_RETRO_COMM(HtmlInputText COMP_FCRD_FC_RETRO_COMM) {
		this.COMP_FCRD_FC_RETRO_COMM = COMP_FCRD_FC_RETRO_COMM;
	}

	public HtmlOutputLabel getCOMP_FCRD_FC_RETRO_TAX_LABEL() {
		return COMP_FCRD_FC_RETRO_TAX_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_FC_RETRO_TAX() {
		return COMP_FCRD_FC_RETRO_TAX;
	}

	public void setCOMP_FCRD_FC_RETRO_TAX_LABEL(HtmlOutputLabel COMP_FCRD_FC_RETRO_TAX_LABEL) {
		this.COMP_FCRD_FC_RETRO_TAX_LABEL = COMP_FCRD_FC_RETRO_TAX_LABEL;
	}

	public void setCOMP_FCRD_FC_RETRO_TAX(HtmlInputText COMP_FCRD_FC_RETRO_TAX) {
		this.COMP_FCRD_FC_RETRO_TAX = COMP_FCRD_FC_RETRO_TAX;
	}

	public HtmlOutputLabel getCOMP_FCRD_SCHD_DT_LABEL() {
		return COMP_FCRD_SCHD_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FCRD_SCHD_DT() {
		return COMP_FCRD_SCHD_DT;
	}

	public void setCOMP_FCRD_SCHD_DT_LABEL(HtmlOutputLabel COMP_FCRD_SCHD_DT_LABEL) {
		this.COMP_FCRD_SCHD_DT_LABEL = COMP_FCRD_SCHD_DT_LABEL;
	}

	public void setCOMP_FCRD_SCHD_DT(HtmlCalendar COMP_FCRD_SCHD_DT) {
		this.COMP_FCRD_SCHD_DT = COMP_FCRD_SCHD_DT;
	}

	public HtmlOutputLabel getCOMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL() {
		return COMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_LC_RETRO_SUM_ASSURED() {
		return COMP_FCRD_LC_RETRO_SUM_ASSURED;
	}

	public void setCOMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL(HtmlOutputLabel COMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL) {
		this.COMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL = COMP_FCRD_LC_RETRO_SUM_ASSURED_LABEL;
	}

	public void setCOMP_FCRD_LC_RETRO_SUM_ASSURED(HtmlInputText COMP_FCRD_LC_RETRO_SUM_ASSURED) {
		this.COMP_FCRD_LC_RETRO_SUM_ASSURED = COMP_FCRD_LC_RETRO_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_FCRD_LC_RETRO_COMM_LABEL() {
		return COMP_FCRD_LC_RETRO_COMM_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_LC_RETRO_COMM() {
		return COMP_FCRD_LC_RETRO_COMM;
	}

	public void setCOMP_FCRD_LC_RETRO_COMM_LABEL(HtmlOutputLabel COMP_FCRD_LC_RETRO_COMM_LABEL) {
		this.COMP_FCRD_LC_RETRO_COMM_LABEL = COMP_FCRD_LC_RETRO_COMM_LABEL;
	}

	public void setCOMP_FCRD_LC_RETRO_COMM(HtmlInputText COMP_FCRD_LC_RETRO_COMM) {
		this.COMP_FCRD_LC_RETRO_COMM = COMP_FCRD_LC_RETRO_COMM;
	}

	public HtmlOutputLabel getCOMP_FCRD_LC_RETRO_PREM_LABEL() {
		return COMP_FCRD_LC_RETRO_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_LC_RETRO_PREM() {
		return COMP_FCRD_LC_RETRO_PREM;
	}

	public void setCOMP_FCRD_LC_RETRO_PREM_LABEL(HtmlOutputLabel COMP_FCRD_LC_RETRO_PREM_LABEL) {
		this.COMP_FCRD_LC_RETRO_PREM_LABEL = COMP_FCRD_LC_RETRO_PREM_LABEL;
	}

	public void setCOMP_FCRD_LC_RETRO_PREM(HtmlInputText COMP_FCRD_LC_RETRO_PREM) {
		this.COMP_FCRD_LC_RETRO_PREM = COMP_FCRD_LC_RETRO_PREM;
	}

	public HtmlOutputLabel getCOMP_FCRD_LC_RETRO_TAX_LABEL() {
		return COMP_FCRD_LC_RETRO_TAX_LABEL;
	}

	public HtmlInputText getCOMP_FCRD_LC_RETRO_TAX() {
		return COMP_FCRD_LC_RETRO_TAX;
	}

	public void setCOMP_FCRD_LC_RETRO_TAX_LABEL(HtmlOutputLabel COMP_FCRD_LC_RETRO_TAX_LABEL) {
		this.COMP_FCRD_LC_RETRO_TAX_LABEL = COMP_FCRD_LC_RETRO_TAX_LABEL;
	}

	public void setCOMP_FCRD_LC_RETRO_TAX(HtmlInputText COMP_FCRD_LC_RETRO_TAX) {
		this.COMP_FCRD_LC_RETRO_TAX = COMP_FCRD_LC_RETRO_TAX;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_COVER_CODE_LABEL() {
		return COMP_UI_M_FCRD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FCRD_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fcrd_cover_code_label) {
		COMP_UI_M_FCRD_COVER_CODE_LABEL = comp_ui_m_fcrd_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_COVER_CODE() {
		return COMP_UI_M_FCRD_COVER_CODE;
	}

	public void setCOMP_UI_M_FCRD_COVER_CODE(HtmlInputText comp_ui_m_fcrd_cover_code) {
		COMP_UI_M_FCRD_COVER_CODE = comp_ui_m_fcrd_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_COVER_DESC() {
		return COMP_UI_M_FCRD_COVER_DESC;
	}

	public void setCOMP_UI_M_FCRD_COVER_DESC(HtmlInputText comp_ui_m_fcrd_cover_desc) {
		COMP_UI_M_FCRD_COVER_DESC = comp_ui_m_fcrd_cover_desc;
	}

	public PT_IL_FAC_CUST_RETRO getPT_IL_FAC_CUST_RETRO_BEAN() {
		return PT_IL_FAC_CUST_RETRO_BEAN;
	}

	public void setPT_IL_FAC_CUST_RETRO_BEAN(
			PT_IL_FAC_CUST_RETRO pt_il_fac_cust_retro_bean) {
		PT_IL_FAC_CUST_RETRO_BEAN = pt_il_fac_cust_retro_bean;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public List<PT_IL_FAC_CUST_RETRO_DETL> getDataListPT_IL_FAC_CUST_RETRO_DETL() {
		return dataListPT_IL_FAC_CUST_RETRO_DETL;
	}

	public void setDataListPT_IL_FAC_CUST_RETRO_DETL(
			List<PT_IL_FAC_CUST_RETRO_DETL> dataListPT_IL_FAC_CUST_RETRO_DETL) {
		this.dataListPT_IL_FAC_CUST_RETRO_DETL = dataListPT_IL_FAC_CUST_RETRO_DETL;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public String backToFAC_CUST_RETRO() {
		
		return "gotoCustRetro";
	}
	
	public void onPageLoad(PhaseEvent event) {
		
		if (!isOnLoadFlag()) {
			PT_IL_FAC_CUST_RETRO_DETL_HELPER helper = new PT_IL_FAC_CUST_RETRO_DETL_HELPER();
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

	public PT_IL_FAC_CUST_RETRO_DETL getPT_IL_FAC_CUST_RETRO_DETL_BEAN() {
		return PT_IL_FAC_CUST_RETRO_DETL_BEAN;
	}

	public void setPT_IL_FAC_CUST_RETRO_DETL_BEAN(
			PT_IL_FAC_CUST_RETRO_DETL pt_il_fac_cust_retro_detl_bean) {
		PT_IL_FAC_CUST_RETRO_DETL_BEAN = pt_il_fac_cust_retro_detl_bean;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_CUST_RETRO_DETL_BEAN = (PT_IL_FAC_CUST_RETRO_DETL) dataTable
					.getRowData();
			resetSelectedRow();
			resetAllComponent();
			PT_IL_FAC_CUST_RETRO_DETL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_CUST_RETRO_DETL> iterator = dataListPT_IL_FAC_CUST_RETRO_DETL
				.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_FCRD_COVER_CODE.resetValue();
		COMP_UI_M_FCRD_COVER_DESC.resetValue();
		COMP_FCRD_FC_RETRO_SUM_ASSURED.resetValue();
		COMP_FCRD_FC_RETRO_PREM.resetValue();
		COMP_FCRD_FC_RETRO_COMM.resetValue();
		COMP_FCRD_FC_RETRO_TAX.resetValue();
		COMP_FCRD_SCHD_DT.resetValue();
		 COMP_FCRD_LC_RETRO_SUM_ASSURED.resetValue();
		COMP_FCRD_LC_RETRO_COMM.resetValue();
		COMP_FCRD_LC_RETRO_PREM.resetValue();
		COMP_FCRD_LC_RETRO_TAX.resetValue();


	}
}

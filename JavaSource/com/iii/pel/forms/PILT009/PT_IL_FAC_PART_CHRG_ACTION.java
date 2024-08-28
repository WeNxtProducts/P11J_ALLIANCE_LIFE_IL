package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FAC_PART_CHRG_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_UI_M_FPC_COVER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FPC_COVER_CODE;
	
	private HtmlInputText COMP_UI_M_FPC_COVER_CODE_DESC;
	
	private HtmlOutputLabel COMP_UI_M_FPC_CUST_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_FPC_CUST_CODE;
	
	private HtmlInputText COMP_UI_M_FPC_CUST_CODE_DESC;
	
	private HtmlOutputLabel COMP_FPC_SRNO_LABEL;

	private HtmlInputText COMP_FPC_SRNO;

	private HtmlOutputLabel COMP_FPC_CHRG_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FPC_CHRG_TYPE;

	private HtmlOutputLabel COMP_FPC_CHRG_CODE_LABEL;

	private HtmlInputText COMP_FPC_CHRG_CODE;

	private HtmlOutputLabel COMP_FPC_RATE_LABEL;

	private HtmlInputText COMP_FPC_RATE;

	private HtmlOutputLabel COMP_FPC_RATE_PER_LABEL;

	private HtmlInputText COMP_FPC_RATE_PER;

	private HtmlOutputLabel COMP_FPC_APPLY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_FPC_APPLY_PERIOD;

	private HtmlOutputLabel COMP_FPC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_FPC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_FPC_FC_VALUE_LABEL;

	private HtmlInputText COMP_FPC_FC_VALUE;

	private HtmlOutputLabel COMP_FPC_LC_VALUE_LABEL;

	private HtmlInputText COMP_FPC_LC_VALUE;

	private HtmlOutputLabel COMP_UI_M_FPC_CHRG_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FPC_CHRG_CODE_DESC;
	
	private PT_IL_FAC_PART_CUST_DETL PT_IL_FAC_PART_CUST_DETL_BEAN;
	
	private PT_IL_FAC_PART_CUST PT_IL_FAC_PART_CUST_BEAN;
	
	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;
	
	private PT_IL_FAC_PART_CHRG  PT_IL_FAC_PART_CHRG_BEAN;
	
	private UIData dataTable;

	private List<PT_IL_FAC_PART_CHRG> dataListPT_IL_FAC_PART_CHRG = null;
	
	private List<SelectItem> chargeTypeDrpDwn;
	
	private List<SelectItem> applyPeriodDrpDwn;
	
	private boolean onLoadFlag;
	
	PILT009_COMPOSITE_ACTION compositeAction;

	public PT_IL_FAC_PART_CHRG_ACTION() {
		dataListPT_IL_FAC_PART_CHRG = new ArrayList<PT_IL_FAC_PART_CHRG>();
		  PT_IL_FAC_PART_CHRG_BEAN = new PT_IL_FAC_PART_CHRG(); 
		
		try {
			applyPeriodDrpDwn = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT009", "PT_IL_FAC_PART_CHRG", "PT_IL_FAC_PART_CHRG.FPC_APPLY_PERIOD", "IL_CHG_PRD");
		chargeTypeDrpDwn = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT009", "PT_IL_FAC_PART_CHRG", "PT_IL_FAC_PART_CHRG.FPC_CHRG_TYPE", "IL_CHRG_TYP");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_FPC_SRNO_LABEL() {
		return COMP_FPC_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_FPC_SRNO() {
		return COMP_FPC_SRNO;
	}

	public void setCOMP_FPC_SRNO_LABEL(HtmlOutputLabel COMP_FPC_SRNO_LABEL) {
		this.COMP_FPC_SRNO_LABEL = COMP_FPC_SRNO_LABEL;
	}

	public void setCOMP_FPC_SRNO(HtmlInputText COMP_FPC_SRNO) {
		this.COMP_FPC_SRNO = COMP_FPC_SRNO;
	}

	public HtmlOutputLabel getCOMP_FPC_CHRG_TYPE_LABEL() {
		return COMP_FPC_CHRG_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FPC_CHRG_TYPE() {
		return COMP_FPC_CHRG_TYPE;
	}

	public void setCOMP_FPC_CHRG_TYPE_LABEL(HtmlOutputLabel COMP_FPC_CHRG_TYPE_LABEL) {
		this.COMP_FPC_CHRG_TYPE_LABEL = COMP_FPC_CHRG_TYPE_LABEL;
	}

	public void setCOMP_FPC_CHRG_TYPE(HtmlSelectOneMenu COMP_FPC_CHRG_TYPE) {
		this.COMP_FPC_CHRG_TYPE = COMP_FPC_CHRG_TYPE;
	}

	public HtmlOutputLabel getCOMP_FPC_CHRG_CODE_LABEL() {
		return COMP_FPC_CHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FPC_CHRG_CODE() {
		return COMP_FPC_CHRG_CODE;
	}

	public void setCOMP_FPC_CHRG_CODE_LABEL(HtmlOutputLabel COMP_FPC_CHRG_CODE_LABEL) {
		this.COMP_FPC_CHRG_CODE_LABEL = COMP_FPC_CHRG_CODE_LABEL;
	}

	public void setCOMP_FPC_CHRG_CODE(HtmlInputText COMP_FPC_CHRG_CODE) {
		this.COMP_FPC_CHRG_CODE = COMP_FPC_CHRG_CODE;
	}

	public HtmlOutputLabel getCOMP_FPC_RATE_LABEL() {
		return COMP_FPC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_FPC_RATE() {
		return COMP_FPC_RATE;
	}

	public void setCOMP_FPC_RATE_LABEL(HtmlOutputLabel COMP_FPC_RATE_LABEL) {
		this.COMP_FPC_RATE_LABEL = COMP_FPC_RATE_LABEL;
	}

	public void setCOMP_FPC_RATE(HtmlInputText COMP_FPC_RATE) {
		this.COMP_FPC_RATE = COMP_FPC_RATE;
	}

	public HtmlOutputLabel getCOMP_FPC_RATE_PER_LABEL() {
		return COMP_FPC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_FPC_RATE_PER() {
		return COMP_FPC_RATE_PER;
	}

	public void setCOMP_FPC_RATE_PER_LABEL(HtmlOutputLabel COMP_FPC_RATE_PER_LABEL) {
		this.COMP_FPC_RATE_PER_LABEL = COMP_FPC_RATE_PER_LABEL;
	}

	public void setCOMP_FPC_RATE_PER(HtmlInputText COMP_FPC_RATE_PER) {
		this.COMP_FPC_RATE_PER = COMP_FPC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_FPC_APPLY_PERIOD_LABEL() {
		return COMP_FPC_APPLY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FPC_APPLY_PERIOD() {
		return COMP_FPC_APPLY_PERIOD;
	}

	public void setCOMP_FPC_APPLY_PERIOD_LABEL(HtmlOutputLabel COMP_FPC_APPLY_PERIOD_LABEL) {
		this.COMP_FPC_APPLY_PERIOD_LABEL = COMP_FPC_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_FPC_APPLY_PERIOD(HtmlSelectOneMenu COMP_FPC_APPLY_PERIOD) {
		this.COMP_FPC_APPLY_PERIOD = COMP_FPC_APPLY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_FPC_CUST_SHARE_PERC_LABEL() {
		return COMP_FPC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FPC_CUST_SHARE_PERC() {
		return COMP_FPC_CUST_SHARE_PERC;
	}

	public void setCOMP_FPC_CUST_SHARE_PERC_LABEL(HtmlOutputLabel COMP_FPC_CUST_SHARE_PERC_LABEL) {
		this.COMP_FPC_CUST_SHARE_PERC_LABEL = COMP_FPC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_FPC_CUST_SHARE_PERC(HtmlInputText COMP_FPC_CUST_SHARE_PERC) {
		this.COMP_FPC_CUST_SHARE_PERC = COMP_FPC_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_FPC_FC_VALUE_LABEL() {
		return COMP_FPC_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_FPC_FC_VALUE() {
		return COMP_FPC_FC_VALUE;
	}

	public void setCOMP_FPC_FC_VALUE_LABEL(HtmlOutputLabel COMP_FPC_FC_VALUE_LABEL) {
		this.COMP_FPC_FC_VALUE_LABEL = COMP_FPC_FC_VALUE_LABEL;
	}

	public void setCOMP_FPC_FC_VALUE(HtmlInputText COMP_FPC_FC_VALUE) {
		this.COMP_FPC_FC_VALUE = COMP_FPC_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_FPC_LC_VALUE_LABEL() {
		return COMP_FPC_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_FPC_LC_VALUE() {
		return COMP_FPC_LC_VALUE;
	}

	public void setCOMP_FPC_LC_VALUE_LABEL(HtmlOutputLabel COMP_FPC_LC_VALUE_LABEL) {
		this.COMP_FPC_LC_VALUE_LABEL = COMP_FPC_LC_VALUE_LABEL;
	}

	public void setCOMP_FPC_LC_VALUE(HtmlInputText COMP_FPC_LC_VALUE) {
		this.COMP_FPC_LC_VALUE = COMP_FPC_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPC_CHRG_CODE_DESC_LABEL() {
		return COMP_UI_M_FPC_CHRG_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPC_CHRG_CODE_DESC() {
		return COMP_UI_M_FPC_CHRG_CODE_DESC;
	}

	public void setCOMP_UI_M_FPC_CHRG_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FPC_CHRG_CODE_DESC_LABEL) {
		this.COMP_UI_M_FPC_CHRG_CODE_DESC_LABEL = COMP_UI_M_FPC_CHRG_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_FPC_CHRG_CODE_DESC(HtmlInputText COMP_UI_M_FPC_CHRG_CODE_DESC) {
		this.COMP_UI_M_FPC_CHRG_CODE_DESC = COMP_UI_M_FPC_CHRG_CODE_DESC;
	}

	public PT_IL_FAC_PART_CUST_DETL getPT_IL_FAC_PART_CUST_DETL_BEAN() {
		return PT_IL_FAC_PART_CUST_DETL_BEAN;
	}

	public void setPT_IL_FAC_PART_CUST_DETL_BEAN(
			PT_IL_FAC_PART_CUST_DETL pt_il_fac_part_cust_detl_bean) {
		PT_IL_FAC_PART_CUST_DETL_BEAN = pt_il_fac_part_cust_detl_bean;
	}

	public PT_IL_FAC_PART_CUST getPT_IL_FAC_PART_CUST_BEAN() {
		return PT_IL_FAC_PART_CUST_BEAN;
	}

	public void setPT_IL_FAC_PART_CUST_BEAN(
			PT_IL_FAC_PART_CUST pt_il_fac_part_cust_bean) {
		PT_IL_FAC_PART_CUST_BEAN = pt_il_fac_part_cust_bean;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}

	public List<PT_IL_FAC_PART_CHRG> getDataListPT_IL_FAC_PART_CHRG() {
		return dataListPT_IL_FAC_PART_CHRG;
	}

	public void setDataListPT_IL_FAC_PART_CHRG(
			List<PT_IL_FAC_PART_CHRG> dataListPT_IL_FAC_PART_CHRG) {
		this.dataListPT_IL_FAC_PART_CHRG = dataListPT_IL_FAC_PART_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPC_COVER_CODE_LABEL() {
		return COMP_UI_M_FPC_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fpc_cover_code_label) {
		COMP_UI_M_FPC_COVER_CODE_LABEL = comp_ui_m_fpc_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FPC_COVER_CODE() {
		return COMP_UI_M_FPC_COVER_CODE;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE(HtmlInputText comp_ui_m_fpc_cover_code) {
		COMP_UI_M_FPC_COVER_CODE = comp_ui_m_fpc_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FPC_COVER_CODE_DESC() {
		return COMP_UI_M_FPC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE_DESC(
			HtmlInputText comp_ui_m_fpc_cover_code_desc) {
		COMP_UI_M_FPC_COVER_CODE_DESC = comp_ui_m_fpc_cover_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPC_CUST_CODE_LABEL() {
		return COMP_UI_M_FPC_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPC_CUST_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fpc_cust_code_label) {
		COMP_UI_M_FPC_CUST_CODE_LABEL = comp_ui_m_fpc_cust_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FPC_CUST_CODE() {
		return COMP_UI_M_FPC_CUST_CODE;
	}

	public void setCOMP_UI_M_FPC_CUST_CODE(HtmlInputText comp_ui_m_fpc_cust_code) {
		COMP_UI_M_FPC_CUST_CODE = comp_ui_m_fpc_cust_code;
	}

	public HtmlInputText getCOMP_UI_M_FPC_CUST_CODE_DESC() {
		return COMP_UI_M_FPC_CUST_CODE_DESC;
	}

	public void setCOMP_UI_M_FPC_CUST_CODE_DESC(
			HtmlInputText comp_ui_m_fpc_cust_code_desc) {
		COMP_UI_M_FPC_CUST_CODE_DESC = comp_ui_m_fpc_cust_code_desc;
	}

	public List<SelectItem> getChargeTypeDrpDwn() {
		return chargeTypeDrpDwn;
	}

	public void setChargeTypeDrpDwn(List<SelectItem> chargeTypeDrpDwn) {
		this.chargeTypeDrpDwn = chargeTypeDrpDwn;
	}

	public List<SelectItem> getApplyPeriodDrpDwn() {
		return applyPeriodDrpDwn;
	}

	public void setApplyPeriodDrpDwn(List<SelectItem> applyPeriodDrpDwn) {
		this.applyPeriodDrpDwn = applyPeriodDrpDwn;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public String backToFAC_CUST_DETL() {
		
		return "gotoFacPartCustDtls";
	}
	
	public void onPageLoad(PhaseEvent event) {
		
		if (!isOnLoadFlag()) {
			PT_IL_FAC_PART_CHRG_HELPER helper = new PT_IL_FAC_PART_CHRG_HELPER();
			try {
				helper.fetchRecord(this);
				COMP_UI_M_FPC_COVER_CODE.resetValue();
				COMP_UI_M_FPC_CUST_CODE.resetValue();
				COMP_FPC_CHRG_TYPE.resetValue();
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

	public PT_IL_FAC_PART_CHRG getPT_IL_FAC_PART_CHRG_BEAN() {
		return PT_IL_FAC_PART_CHRG_BEAN;
	}

	public void setPT_IL_FAC_PART_CHRG_BEAN(
			PT_IL_FAC_PART_CHRG pt_il_fac_part_chrg_bean) {
		PT_IL_FAC_PART_CHRG_BEAN = pt_il_fac_part_chrg_bean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_PART_CHRG_BEAN = (PT_IL_FAC_PART_CHRG) dataTable.getRowData();
			resetAllComponent();
			resetSelectedRow();
			PT_IL_FAC_PART_CHRG_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_PART_CHRG> iterator = dataListPT_IL_FAC_PART_CHRG.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_FPC_SRNO.resetValue();
		COMP_FPC_CHRG_TYPE.resetValue();
		COMP_FPC_CHRG_CODE.resetValue();
		COMP_FPC_RATE.resetValue();
		COMP_FPC_RATE_PER.resetValue();
		COMP_FPC_APPLY_PERIOD.resetValue();
		COMP_FPC_CUST_SHARE_PERC.resetValue();
		COMP_FPC_FC_VALUE.resetValue();
		COMP_FPC_LC_VALUE.resetValue();
		COMP_UI_M_FPC_CHRG_CODE_DESC.resetValue();

	}
	
}

package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_RI_DETL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RD_COVER_CODE_LABEL;

	private HtmlInputText COMP_RD_COVER_CODE;

	private HtmlOutputLabel COMP_RD_ASSR_CODE_LABEL;

	private HtmlInputText COMP_RD_ASSR_CODE;

	private HtmlOutputLabel COMP_RD_SCHD_DT_LABEL;

	private HtmlCalendar COMP_RD_SCHD_DT;

	private HtmlOutputLabel COMP_RD_TAR_RATE_LABEL;

	private HtmlInputText COMP_RD_TAR_RATE;

	private HtmlOutputLabel COMP_RD_TAR_RATE_PER_LABEL;

	private HtmlInputText COMP_RD_TAR_RATE_PER;

	private HtmlOutputLabel COMP_RD_FC_SA_LABEL;

	private HtmlInputText COMP_RD_FC_SA;

	private HtmlOutputLabel COMP_RD_FC_PREM_LABEL;

	private HtmlInputText COMP_RD_FC_PREM;

	private HtmlOutputLabel COMP_RD_LC_PRD_PREM_LABEL;

	private HtmlInputText COMP_RD_LC_PRD_PREM;

	private HtmlOutputLabel COMP_RD_PRD_FM_DT_LABEL;

	private HtmlCalendar COMP_RD_PRD_FM_DT;

	private HtmlOutputLabel COMP_RD_PRD_TO_DT_LABEL;

	private HtmlCalendar COMP_RD_PRD_TO_DT;

	private HtmlOutputLabel COMP_RD_FRZ_FLAG_LABEL;

	private HtmlInputText COMP_RD_FRZ_FLAG;

	private HtmlOutputLabel COMP_RD_TREATY_CODE_LABEL;

	private HtmlInputText COMP_RD_TREATY_CODE;

	private HtmlOutputLabel COMP_UI_M_TREATY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TREATY_CODE_DESC;

	private HtmlOutputLabel COMP_RD_REMARKS_LABEL;

	private HtmlInputText COMP_RD_REMARKS;
	
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_RI_DETL_1 PT_IL_RI_DETL_1_BEAN;

	private List<PT_IL_RI_DETL_1> dataList_PT_IL_RI_DETL_1 = new ArrayList<PT_IL_RI_DETL_1>();
	
	private UIData COMP_PT_IL_RI_DETL_1_DATATABLE;
	
	public PILT010_COMPOSITE_ACTION compositeAction;
	
	private boolean onLoadFlag = false;
	
	private UIData dataTable;
	
	private List<SelectItem> rdFrzFlagList;
	
	private String filterByRD_COVER_CODE;
	
	private String filterByRD_ASSR_CODE;
	
	private String filterByRD_TAR_RATE_PER;
	private String filterByRD_TAR_RATE;

	public PT_IL_RI_DETL_1_ACTION() {
		PT_IL_RI_DETL_1_BEAN = new PT_IL_RI_DETL_1();
		try {
			instantiateAllComponent();
			Connection connection = CommonUtils.getConnection();
			rdFrzFlagList = ListItemUtil.getDropDownListValue(connection, "PILT010", "PT_IL_RI_DETL_1", "PT_IL_RI_DETL_1.RD_FRZ_FLAG", "RI_ALLC_TP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_RD_COVER_CODE_LABEL() {
		return COMP_RD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RD_COVER_CODE() {
		return COMP_RD_COVER_CODE;
	}

	public void setCOMP_RD_COVER_CODE_LABEL(HtmlOutputLabel COMP_RD_COVER_CODE_LABEL) {
		this.COMP_RD_COVER_CODE_LABEL = COMP_RD_COVER_CODE_LABEL;
	}

	public void setCOMP_RD_COVER_CODE(HtmlInputText COMP_RD_COVER_CODE) {
		this.COMP_RD_COVER_CODE = COMP_RD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_RD_ASSR_CODE_LABEL() {
		return COMP_RD_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RD_ASSR_CODE() {
		return COMP_RD_ASSR_CODE;
	}

	public void setCOMP_RD_ASSR_CODE_LABEL(HtmlOutputLabel COMP_RD_ASSR_CODE_LABEL) {
		this.COMP_RD_ASSR_CODE_LABEL = COMP_RD_ASSR_CODE_LABEL;
	}

	public void setCOMP_RD_ASSR_CODE(HtmlInputText COMP_RD_ASSR_CODE) {
		this.COMP_RD_ASSR_CODE = COMP_RD_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_RD_SCHD_DT_LABEL() {
		return COMP_RD_SCHD_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RD_SCHD_DT() {
		return COMP_RD_SCHD_DT;
	}

	public void setCOMP_RD_SCHD_DT_LABEL(HtmlOutputLabel COMP_RD_SCHD_DT_LABEL) {
		this.COMP_RD_SCHD_DT_LABEL = COMP_RD_SCHD_DT_LABEL;
	}

	public void setCOMP_RD_SCHD_DT(HtmlCalendar COMP_RD_SCHD_DT) {
		this.COMP_RD_SCHD_DT = COMP_RD_SCHD_DT;
	}

	public HtmlOutputLabel getCOMP_RD_TAR_RATE_LABEL() {
		return COMP_RD_TAR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RD_TAR_RATE() {
		return COMP_RD_TAR_RATE;
	}

	public void setCOMP_RD_TAR_RATE_LABEL(HtmlOutputLabel COMP_RD_TAR_RATE_LABEL) {
		this.COMP_RD_TAR_RATE_LABEL = COMP_RD_TAR_RATE_LABEL;
	}

	public void setCOMP_RD_TAR_RATE(HtmlInputText COMP_RD_TAR_RATE) {
		this.COMP_RD_TAR_RATE = COMP_RD_TAR_RATE;
	}

	public HtmlOutputLabel getCOMP_RD_TAR_RATE_PER_LABEL() {
		return COMP_RD_TAR_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_RD_TAR_RATE_PER() {
		return COMP_RD_TAR_RATE_PER;
	}

	public void setCOMP_RD_TAR_RATE_PER_LABEL(HtmlOutputLabel COMP_RD_TAR_RATE_PER_LABEL) {
		this.COMP_RD_TAR_RATE_PER_LABEL = COMP_RD_TAR_RATE_PER_LABEL;
	}

	public void setCOMP_RD_TAR_RATE_PER(HtmlInputText COMP_RD_TAR_RATE_PER) {
		this.COMP_RD_TAR_RATE_PER = COMP_RD_TAR_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_RD_FC_SA_LABEL() {
		return COMP_RD_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_RD_FC_SA() {
		return COMP_RD_FC_SA;
	}

	public void setCOMP_RD_FC_SA_LABEL(HtmlOutputLabel COMP_RD_FC_SA_LABEL) {
		this.COMP_RD_FC_SA_LABEL = COMP_RD_FC_SA_LABEL;
	}

	public void setCOMP_RD_FC_SA(HtmlInputText COMP_RD_FC_SA) {
		this.COMP_RD_FC_SA = COMP_RD_FC_SA;
	}

	public HtmlOutputLabel getCOMP_RD_FC_PREM_LABEL() {
		return COMP_RD_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RD_FC_PREM() {
		return COMP_RD_FC_PREM;
	}

	public void setCOMP_RD_FC_PREM_LABEL(HtmlOutputLabel COMP_RD_FC_PREM_LABEL) {
		this.COMP_RD_FC_PREM_LABEL = COMP_RD_FC_PREM_LABEL;
	}

	public void setCOMP_RD_FC_PREM(HtmlInputText COMP_RD_FC_PREM) {
		this.COMP_RD_FC_PREM = COMP_RD_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_RD_LC_PRD_PREM_LABEL() {
		return COMP_RD_LC_PRD_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RD_LC_PRD_PREM() {
		return COMP_RD_LC_PRD_PREM;
	}

	public void setCOMP_RD_LC_PRD_PREM_LABEL(HtmlOutputLabel COMP_RD_LC_PRD_PREM_LABEL) {
		this.COMP_RD_LC_PRD_PREM_LABEL = COMP_RD_LC_PRD_PREM_LABEL;
	}

	public void setCOMP_RD_LC_PRD_PREM(HtmlInputText COMP_RD_LC_PRD_PREM) {
		this.COMP_RD_LC_PRD_PREM = COMP_RD_LC_PRD_PREM;
	}

	public HtmlOutputLabel getCOMP_RD_PRD_FM_DT_LABEL() {
		return COMP_RD_PRD_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RD_PRD_FM_DT() {
		return COMP_RD_PRD_FM_DT;
	}

	public void setCOMP_RD_PRD_FM_DT_LABEL(HtmlOutputLabel COMP_RD_PRD_FM_DT_LABEL) {
		this.COMP_RD_PRD_FM_DT_LABEL = COMP_RD_PRD_FM_DT_LABEL;
	}

	public void setCOMP_RD_PRD_FM_DT(HtmlCalendar COMP_RD_PRD_FM_DT) {
		this.COMP_RD_PRD_FM_DT = COMP_RD_PRD_FM_DT;
	}

	public HtmlOutputLabel getCOMP_RD_PRD_TO_DT_LABEL() {
		return COMP_RD_PRD_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RD_PRD_TO_DT() {
		return COMP_RD_PRD_TO_DT;
	}

	public void setCOMP_RD_PRD_TO_DT_LABEL(HtmlOutputLabel COMP_RD_PRD_TO_DT_LABEL) {
		this.COMP_RD_PRD_TO_DT_LABEL = COMP_RD_PRD_TO_DT_LABEL;
	}

	public void setCOMP_RD_PRD_TO_DT(HtmlCalendar COMP_RD_PRD_TO_DT) {
		this.COMP_RD_PRD_TO_DT = COMP_RD_PRD_TO_DT;
	}

	public HtmlOutputLabel getCOMP_RD_FRZ_FLAG_LABEL() {
		return COMP_RD_FRZ_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_RD_FRZ_FLAG() {
		return COMP_RD_FRZ_FLAG;
	}

	public void setCOMP_RD_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_RD_FRZ_FLAG_LABEL) {
		this.COMP_RD_FRZ_FLAG_LABEL = COMP_RD_FRZ_FLAG_LABEL;
	}

	public void setCOMP_RD_FRZ_FLAG(HtmlInputText COMP_RD_FRZ_FLAG) {
		this.COMP_RD_FRZ_FLAG = COMP_RD_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_RD_TREATY_CODE_LABEL() {
		return COMP_RD_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RD_TREATY_CODE() {
		return COMP_RD_TREATY_CODE;
	}

	public void setCOMP_RD_TREATY_CODE_LABEL(HtmlOutputLabel COMP_RD_TREATY_CODE_LABEL) {
		this.COMP_RD_TREATY_CODE_LABEL = COMP_RD_TREATY_CODE_LABEL;
	}

	public void setCOMP_RD_TREATY_CODE(HtmlInputText COMP_RD_TREATY_CODE) {
		this.COMP_RD_TREATY_CODE = COMP_RD_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TREATY_CODE_DESC_LABEL() {
		return COMP_UI_M_TREATY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TREATY_CODE_DESC() {
		return COMP_UI_M_TREATY_CODE_DESC;
	}

	public void setCOMP_UI_M_TREATY_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TREATY_CODE_DESC_LABEL) {
		this.COMP_UI_M_TREATY_CODE_DESC_LABEL = COMP_UI_M_TREATY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TREATY_CODE_DESC(HtmlInputText COMP_UI_M_TREATY_CODE_DESC) {
		this.COMP_UI_M_TREATY_CODE_DESC = COMP_UI_M_TREATY_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RD_REMARKS_LABEL() {
		return COMP_RD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_RD_REMARKS() {
		return COMP_RD_REMARKS;
	}

	public void setCOMP_RD_REMARKS_LABEL(HtmlOutputLabel COMP_RD_REMARKS_LABEL) {
		this.COMP_RD_REMARKS_LABEL = COMP_RD_REMARKS_LABEL;
	}

	public void setCOMP_RD_REMARKS(HtmlInputText COMP_RD_REMARKS) {
		this.COMP_RD_REMARKS = COMP_RD_REMARKS;
	}

	public PT_IL_RI_DETL_1 getPT_IL_RI_DETL_1_BEAN() {
		return PT_IL_RI_DETL_1_BEAN;
	}

	public void setPT_IL_RI_DETL_1_BEAN(PT_IL_RI_DETL_1 PT_IL_RI_DETL_1_BEAN) {
		this.PT_IL_RI_DETL_1_BEAN = PT_IL_RI_DETL_1_BEAN;
	}

	public List<PT_IL_RI_DETL_1> getDataList_PT_IL_RI_DETL_1() {
		return dataList_PT_IL_RI_DETL_1;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void setDataList_PT_IL_RI_DETL_1(
			List<PT_IL_RI_DETL_1> dataList_PT_IL_RI_DETL_1) {
		this.dataList_PT_IL_RI_DETL_1 = dataList_PT_IL_RI_DETL_1;
	}
	
	public UIData getCOMP_PT_IL_RI_DETL_1_DATATABLE() {
		return COMP_PT_IL_RI_DETL_1_DATATABLE;
	}

	public void setCOMP_PT_IL_RI_DETL_1_DATATABLE(
			UIData comp_pt_il_ri_detl_1_datatable) {
		COMP_PT_IL_RI_DETL_1_DATATABLE = comp_pt_il_ri_detl_1_datatable;
	}

	public List<SelectItem> getRdFrzFlagList() {
		return rdFrzFlagList;
	}

	public void setRdFrzFlagList(List<SelectItem> rdFrzFlagList) {
		this.rdFrzFlagList = rdFrzFlagList;
	}

	public void onLoad(PhaseEvent event){
		if(!isOnLoadFlag()){
			PT_IL_RI_DETL_1_HELPER helper = new PT_IL_RI_DETL_1_HELPER();
			helper.executeHistoryDetails();
			try {
				helper.postQuery(compositeAction);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}
			setOnLoadFlag(true);
		}
	}
	
	public void populatePremAllocDetails(ActionEvent event){
		PV_IL_POL_RI_DETL_ACTION polRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			PT_IL_RI_DETL_1_HELPER helper = new PT_IL_RI_DETL_1_HELPER();
			helper.populatePremiumAllocationDetails();
			} catch (Exception e) {
			polRiDetlAction.getErrorMap().put("current", e.getMessage());
			polRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (dataList_PT_IL_RI_DETL_1!=null && dataList_PT_IL_RI_DETL_1.size() != 0) {				
				PT_IL_RI_DETL_1_BEAN = (PT_IL_RI_DETL_1) dataTable.getRowData();
			}	
			
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_RI_DETL_1_BEAN.setRowSelected(true);
			PT_IL_RI_DETL_1_HELPER helper = new PT_IL_RI_DETL_1_HELPER();
			helper.executeHistoryDetails_1();
			PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_1_ACTION_INSTANCE().resetAllComponent();
			new PT_IL_RI_DETL_1_HELPER().postQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_RD_COVER_CODE.resetValue();
	//	COMP_RD_TREATY_CODE.resetValue();
		//COMP_UI_M_TTY_CODE_DESC.resetValue();
		COMP_RD_SCHD_DT.resetValue();
		//COMP_RD_FC_SA.resetValue();
		COMP_RD_FC_PREM.resetValue();
		COMP_RD_LC_PRD_PREM.resetValue();
		COMP_RD_PRD_FM_DT.resetValue();
		COMP_RD_PRD_TO_DT.resetValue();
		COMP_RD_REMARKS.resetValue();
	}
	public void instantiateAllComponent(){
		COMP_RD_COVER_CODE=new HtmlInputText();
	//	COMP_RD_TREATY_CODE.resetValue();
		//COMP_UI_M_TTY_CODE_DESC.resetValue();
		COMP_RD_SCHD_DT=new HtmlCalendar();
		//COMP_RD_FC_SA.resetValue();
		COMP_RD_FC_PREM=new HtmlInputText();
		COMP_RD_LC_PRD_PREM=new HtmlInputText();
		COMP_RD_PRD_FM_DT=new HtmlCalendar();
		COMP_RD_PRD_TO_DT=new HtmlCalendar();
		COMP_RD_REMARKS=new HtmlInputText();
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_RI_DETL_1> iterator = dataList_PT_IL_RI_DETL_1.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public String mainButtonAction(){
		return "PILT010";
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the filterByRD_COVER_CODE
	 */
	public String getFilterByRD_COVER_CODE() {
		return filterByRD_COVER_CODE;
	}

	/**
	 * @param filterByRD_COVER_CODE the filterByRD_COVER_CODE to set
	 */
	public void setFilterByRD_COVER_CODE(String filterByRD_COVER_CODE) {
		this.filterByRD_COVER_CODE = filterByRD_COVER_CODE;
	}

	/**
	 * @return the filterByRD_ASSR_CODE
	 */
	public String getFilterByRD_ASSR_CODE() {
		return filterByRD_ASSR_CODE;
	}

	/**
	 * @param filterByRD_ASSR_CODE the filterByRD_ASSR_CODE to set
	 */
	public void setFilterByRD_ASSR_CODE(String filterByRD_ASSR_CODE) {
		this.filterByRD_ASSR_CODE = filterByRD_ASSR_CODE;
	}

	/**
	 * @return the filterByRD_TAR_RATE_PER
	 */
	public String getFilterByRD_TAR_RATE_PER() {
		return filterByRD_TAR_RATE_PER;
	}

	/**
	 * @param filterByRD_TAR_RATE_PER the filterByRD_TAR_RATE_PER to set
	 */
	public void setFilterByRD_TAR_RATE_PER(String filterByRD_TAR_RATE_PER) {
		this.filterByRD_TAR_RATE_PER = filterByRD_TAR_RATE_PER;
	}

	/**
	 * @return the filterByRD_TAR_RATE
	 */
	public String getFilterByRD_TAR_RATE() {
		return filterByRD_TAR_RATE;
	}

	/**
	 * @param filterByRD_TAR_RATE the filterByRD_TAR_RATE to set
	 */
	public void setFilterByRD_TAR_RATE(String filterByRD_TAR_RATE) {
		this.filterByRD_TAR_RATE = filterByRD_TAR_RATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}
}

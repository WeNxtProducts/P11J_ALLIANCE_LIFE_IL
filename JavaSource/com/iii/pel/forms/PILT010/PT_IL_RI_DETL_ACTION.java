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

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_RI_DETL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_B_RI_CLOSE;

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

	private HtmlOutputLabel COMP_UI_M_TTY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TTY_CODE_DESC;

	private HtmlOutputLabel COMP_RD_REMARKS_LABEL;
	
	private HtmlInputText COMP_RD_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_RI_DETL;

	private HtmlCommandButton COMP_UI_M_BUT_FAC;

	private HtmlCommandButton COMP_UI_M_BUT_POLICY;

	private HtmlCommandButton COMP_UI_M_BUT_USER_CALC;

	private HtmlCommandButton COMP_UI_M_BUT_SYS_CALC;

	private PT_IL_RI_DETL PT_IL_RI_DETL_BEAN;
	private PT_IL_RI_DETL PT_IL_RI_DETL_BEAN1;

	private List<PT_IL_RI_DETL> dataList_PT_IL_RI_DETL = new ArrayList<PT_IL_RI_DETL>();
	private List<PT_IL_RI_DETL> dataList_PT_IL_RI_DETL1 = new ArrayList<PT_IL_RI_DETL>();
	
	private UIDataTable COMP_PT_IL_RI_DETL_DATATABLE;
	
	private UIData dataTable;
	private UIData dataTable1;
	
	private List<SelectItem> rdFrzFlagList;
	
	private String filterByRD_COVER_CODE;
	
	private String filterByRD_ASSR_CODE;
	
	private String filterByRD_TAR_RATE_PER;
	private String filterByRD_TAR_RATE;
	
	public PILT010_COMPOSITE_ACTION compositeAction;

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

	public PT_IL_RI_DETL_ACTION() {
		PT_IL_RI_DETL_BEAN = new PT_IL_RI_DETL();
		PT_IL_RI_DETL_BEAN1 = new PT_IL_RI_DETL();
		try {
			Connection connection = CommonUtils.getConnection();
			rdFrzFlagList = ListItemUtil.getDropDownListValue(connection, "PILT010", "PT_IL_RI_DETL", "PT_IL_RI_DETL.RD_FRZ_FLAG", "RI_ALLC_TP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_B_RI_CLOSE() {
		return COMP_B_RI_CLOSE;
	}

	public void setCOMP_B_RI_CLOSE(HtmlOutputLabel COMP_B_RI_CLOSE) {
		this.COMP_B_RI_CLOSE = COMP_B_RI_CLOSE;
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

	public HtmlOutputLabel getCOMP_UI_M_TTY_CODE_DESC_LABEL() {
		return COMP_UI_M_TTY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TTY_CODE_DESC() {
		return COMP_UI_M_TTY_CODE_DESC;
	}

	public void setCOMP_UI_M_TTY_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TTY_CODE_DESC_LABEL) {
		this.COMP_UI_M_TTY_CODE_DESC_LABEL = COMP_UI_M_TTY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TTY_CODE_DESC(HtmlInputText COMP_UI_M_TTY_CODE_DESC) {
		this.COMP_UI_M_TTY_CODE_DESC = COMP_UI_M_TTY_CODE_DESC;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_RI_DETL() {
		return COMP_UI_M_BUT_RI_DETL;
	}

	public void setCOMP_UI_M_BUT_RI_DETL(HtmlCommandButton COMP_UI_M_BUT_RI_DETL) {
		this.COMP_UI_M_BUT_RI_DETL = COMP_UI_M_BUT_RI_DETL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton COMP_UI_M_BUT_FAC) {
		this.COMP_UI_M_BUT_FAC = COMP_UI_M_BUT_FAC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POLICY() {
		return COMP_UI_M_BUT_POLICY;
	}

	public void setCOMP_UI_M_BUT_POLICY(HtmlCommandButton COMP_UI_M_BUT_POLICY) {
		this.COMP_UI_M_BUT_POLICY = COMP_UI_M_BUT_POLICY;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_USER_CALC() {
		return COMP_UI_M_BUT_USER_CALC;
	}

	public void setCOMP_UI_M_BUT_USER_CALC(HtmlCommandButton COMP_UI_M_BUT_USER_CALC) {
		this.COMP_UI_M_BUT_USER_CALC = COMP_UI_M_BUT_USER_CALC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SYS_CALC() {
		return COMP_UI_M_BUT_SYS_CALC;
	}

	public void setCOMP_UI_M_BUT_SYS_CALC(HtmlCommandButton COMP_UI_M_BUT_SYS_CALC) {
		this.COMP_UI_M_BUT_SYS_CALC = COMP_UI_M_BUT_SYS_CALC;
	}

	public PT_IL_RI_DETL getPT_IL_RI_DETL_BEAN() {
		return PT_IL_RI_DETL_BEAN;
	}

	public void setPT_IL_RI_DETL_BEAN(PT_IL_RI_DETL PT_IL_RI_DETL_BEAN) {
		this.PT_IL_RI_DETL_BEAN = PT_IL_RI_DETL_BEAN;
	}

	public List<PT_IL_RI_DETL> getDataList_PT_IL_RI_DETL() {
		return dataList_PT_IL_RI_DETL;
	}

	public void setDataListPT_IL_RI_DETL(List<PT_IL_RI_DETL> dataList_PT_IL_RI_DETL) {
		this.dataList_PT_IL_RI_DETL = dataList_PT_IL_RI_DETL;
	}

	public UIDataTable getCOMP_PT_IL_RI_DETL_DATATABLE() {
		return COMP_PT_IL_RI_DETL_DATATABLE;
	}

	public void setCOMP_PT_IL_RI_DETL_DATATABLE(
			UIDataTable comp_pt_il_ri_detl_datatable) {
		COMP_PT_IL_RI_DETL_DATATABLE = comp_pt_il_ri_detl_datatable;
	}

	public void setDataList_PT_IL_RI_DETL(List<PT_IL_RI_DETL> dataList_PT_IL_RI_DETL) {
		this.dataList_PT_IL_RI_DETL = dataList_PT_IL_RI_DETL;
	}
	
	public List<SelectItem> getRdFrzFlagList() {
		return rdFrzFlagList;
	}

	public void setRdFrzFlagList(List<SelectItem> rdFrzFlagList) {
		this.rdFrzFlagList = rdFrzFlagList;
	}

	public void populatePremAllocDetails(ActionEvent event){
		PV_IL_POL_RI_DETL_ACTION polRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			PT_IL_RI_DETL_HELPER helper = new PT_IL_RI_DETL_HELPER();
			helper.populatePremiumAllocationDetails();
		} catch (Exception e) {
			polRiDetlAction.getErrorMap().put("current", e.getMessage());
			polRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	public void onLoad(PhaseEvent event){
		try{
		if (isBlockFlag()) {
			CommonUtils.clearMaps(this);
			PT_IL_RI_DETL_HELPER ptRiDetlHelper = new PT_IL_RI_DETL_HELPER();
				ptRiDetlHelper.execute(compositeAction);
			}
			
		setBlockFlag(false);
		compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().getPT_IL_RI_DETL_BEAN1().setRowSelected(true);

		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
		
	
	public void postTab(){
		new PT_IL_RI_PREM_ALLOC_HELPER().executeQuery(); 
	}
	
	/**
	 * 
	 */
	public void getDetails() {
		try {
			if(dataList_PT_IL_RI_DETL!=null && dataList_PT_IL_RI_DETL.size() != 0) {				
				PT_IL_RI_DETL_BEAN = (PT_IL_RI_DETL) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_RI_DETL_BEAN.setRowSelected(true);
			postTab();
			compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_ACTION().setBlockFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getDetails_P() {
		try {
			if(dataList_PT_IL_RI_DETL1!=null && dataList_PT_IL_RI_DETL1.size() != 0) {				
				PT_IL_RI_DETL_BEAN1 = (PT_IL_RI_DETL) dataTable1.getRowData();
			}	
			//resetAllComponent();			
			resetSelectedRow1();
			PT_IL_RI_DETL_BEAN1.setRowSelected(true);
			//postTab();
			compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().setBlockFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_RD_COVER_CODE.resetValue();
		COMP_RD_TREATY_CODE.resetValue();
		COMP_UI_M_TTY_CODE_DESC.resetValue();
		COMP_RD_SCHD_DT.resetValue();
		COMP_RD_FC_SA.resetValue();
		COMP_RD_FC_PREM.resetValue();
		COMP_RD_LC_PRD_PREM.resetValue();
		COMP_RD_PRD_FM_DT.resetValue();
		COMP_RD_PRD_TO_DT.resetValue();
		COMP_RD_REMARKS.resetValue();
	}
	
	public void resetSelectedRow() {
		Iterator<PT_IL_RI_DETL> iterator = dataList_PT_IL_RI_DETL.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void resetSelectedRow1() {
		Iterator<PT_IL_RI_DETL> iterator1 = dataList_PT_IL_RI_DETL1.iterator();
		while (iterator1.hasNext()) {
			iterator1.next().setRowSelected(false);
		}
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

	public List<PT_IL_RI_DETL> getDataList_PT_IL_RI_DETL1() {
		return dataList_PT_IL_RI_DETL1;
	}

	public void setDataList_PT_IL_RI_DETL1(
			List<PT_IL_RI_DETL> dataList_PT_IL_RI_DETL1) {
		this.dataList_PT_IL_RI_DETL1 = dataList_PT_IL_RI_DETL1;
	}

	public UIData getDataTable1() {
		return dataTable1;
	}

	public void setDataTable1(UIData dataTable1) {
		this.dataTable1 = dataTable1;
	}

	public PT_IL_RI_DETL getPT_IL_RI_DETL_BEAN1() {
		return PT_IL_RI_DETL_BEAN1;
	}

	public void setPT_IL_RI_DETL_BEAN1(PT_IL_RI_DETL pt_il_ri_detl_bean1) {
		PT_IL_RI_DETL_BEAN1 = pt_il_ri_detl_bean1;
	}
	
	
}

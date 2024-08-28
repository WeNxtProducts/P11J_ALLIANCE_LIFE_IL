package com.iii.pel.forms.PILQ111_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RI_PART_CUST_ALLOC_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RIPCA_CUST_CODE_LABEL;

	private HtmlInputText COMP_RIPCA_CUST_CODE;

	private HtmlOutputLabel COMP_RIPCA_SHARE_PERC_LABEL;

	private HtmlInputText COMP_RIPCA_SHARE_PERC;

	private HtmlOutputLabel COMP_RIPCA_TTY_TYPE_LABEL;

	private HtmlInputText COMP_RIPCA_TTY_TYPE;

	private HtmlOutputLabel COMP_RIPCA_FC_PREMIUM_LABEL;

	private HtmlInputText COMP_RIPCA_FC_PREMIUM;

	private HtmlOutputLabel COMP_RIPCA_LC_PREMIUM_LABEL;

	private HtmlInputText COMP_RIPCA_LC_PREMIUM;

	private HtmlOutputLabel COMP_RIPCA_FC_COMMISSION_LABEL;

	private HtmlInputText COMP_RIPCA_FC_COMMISSION;

	private HtmlOutputLabel COMP_RIPCA_LC_COMMISSION_LABEL;

	private HtmlInputText COMP_RIPCA_LC_COMMISSION;

	private HtmlOutputLabel COMP_RIPCA_CLM_PAID_LABEL;

	private HtmlInputText COMP_RIPCA_CLM_PAID;

	private HtmlOutputLabel COMP_RIPCA_CLAIMS_OS_LABEL;

	private HtmlInputText COMP_RIPCA_CLAIMS_OS;

	private HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CUST_NAME;
	
	private UIDataTable dataTable;

	private PT_IL_RI_PART_CUST_ALLOC PT_IL_RI_PART_CUST_ALLOC_BEAN;
	
	private String filterByRIPCA_CUST_CODE;
	
	private String filterByRIPCA_SHARE_PERC;
	
	public PT_IL_RI_PART_CUST_ALLOC_HELPER helper;
	
	
	private List<PT_IL_RI_PART_CUST_ALLOC> dataListPT_IL_RI_PART_CUST_ALLOC = new ArrayList<PT_IL_RI_PART_CUST_ALLOC>();

	public PILQ111_APAC_COMPOSITE_ACTION compositeAction;

	
	public void getDetails() {
	    try {
		if ( dataListPT_IL_RI_PART_CUST_ALLOC.size() != 0) {				
		 this.PT_IL_RI_PART_CUST_ALLOC_BEAN = (PT_IL_RI_PART_CUST_ALLOC) dataTable.getRowData();
		}
		resetAllComponent();			
		resetSelectedRow();
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRowSelected(true);	
	    } catch (Exception e) {
        	e.printStackTrace();
	    }
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
	    COMP_RIPCA_CUST_CODE.resetValue();
	    COMP_RIPCA_SHARE_PERC.resetValue();
	    COMP_RIPCA_TTY_TYPE.resetValue();
	    COMP_RIPCA_FC_PREMIUM.resetValue();
	    COMP_RIPCA_LC_PREMIUM.resetValue();
	    COMP_RIPCA_FC_COMMISSION.resetValue();
	    COMP_RIPCA_LC_COMMISSION.resetValue();
	    COMP_RIPCA_CLAIMS_OS.resetValue();
	    COMP_RIPCA_CLM_PAID.resetValue();
	    COMP_UI_M_CUST_NAME.resetValue();
	}
	
	public void onLoad() {
		try {
			//if (isBlockFlag()) {
			    	helper.executeQuery(compositeAction);
				setBlockFlag(false);
		//	}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PT_IL_RI_PART_CUST_ALLOC>  iterator = dataListPT_IL_RI_PART_CUST_ALLOC.iterator();
		
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_RI_PART_CUST_ALLOC_BEAN = (PT_IL_RI_PART_CUST_ALLOC) dataTable
					.getRowData();
			PT_IL_RI_PART_CUST_ALLOC_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public PT_IL_RI_PART_CUST_ALLOC_ACTION() {
		PT_IL_RI_PART_CUST_ALLOC_BEAN = new PT_IL_RI_PART_CUST_ALLOC();
		helper = new PT_IL_RI_PART_CUST_ALLOC_HELPER();
	}

	public HtmlOutputLabel getCOMP_RIPCA_CUST_CODE_LABEL() {
		return COMP_RIPCA_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_CUST_CODE() {
		return COMP_RIPCA_CUST_CODE;
	}

	public void setCOMP_RIPCA_CUST_CODE_LABEL(HtmlOutputLabel COMP_RIPCA_CUST_CODE_LABEL) {
		this.COMP_RIPCA_CUST_CODE_LABEL = COMP_RIPCA_CUST_CODE_LABEL;
	}

	public void setCOMP_RIPCA_CUST_CODE(HtmlInputText COMP_RIPCA_CUST_CODE) {
		this.COMP_RIPCA_CUST_CODE = COMP_RIPCA_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_RIPCA_SHARE_PERC_LABEL() {
		return COMP_RIPCA_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_SHARE_PERC() {
		return COMP_RIPCA_SHARE_PERC;
	}

	public void setCOMP_RIPCA_SHARE_PERC_LABEL(HtmlOutputLabel COMP_RIPCA_SHARE_PERC_LABEL) {
		this.COMP_RIPCA_SHARE_PERC_LABEL = COMP_RIPCA_SHARE_PERC_LABEL;
	}

	public void setCOMP_RIPCA_SHARE_PERC(HtmlInputText COMP_RIPCA_SHARE_PERC) {
		this.COMP_RIPCA_SHARE_PERC = COMP_RIPCA_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_RIPCA_TTY_TYPE_LABEL() {
		return COMP_RIPCA_TTY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_TTY_TYPE() {
		return COMP_RIPCA_TTY_TYPE;
	}

	public void setCOMP_RIPCA_TTY_TYPE_LABEL(HtmlOutputLabel COMP_RIPCA_TTY_TYPE_LABEL) {
		this.COMP_RIPCA_TTY_TYPE_LABEL = COMP_RIPCA_TTY_TYPE_LABEL;
	}

	public void setCOMP_RIPCA_TTY_TYPE(HtmlInputText COMP_RIPCA_TTY_TYPE) {
		this.COMP_RIPCA_TTY_TYPE = COMP_RIPCA_TTY_TYPE;
	}

	public HtmlOutputLabel getCOMP_RIPCA_FC_PREMIUM_LABEL() {
		return COMP_RIPCA_FC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_FC_PREMIUM() {
		return COMP_RIPCA_FC_PREMIUM;
	}

	public void setCOMP_RIPCA_FC_PREMIUM_LABEL(HtmlOutputLabel COMP_RIPCA_FC_PREMIUM_LABEL) {
		this.COMP_RIPCA_FC_PREMIUM_LABEL = COMP_RIPCA_FC_PREMIUM_LABEL;
	}

	public void setCOMP_RIPCA_FC_PREMIUM(HtmlInputText COMP_RIPCA_FC_PREMIUM) {
		this.COMP_RIPCA_FC_PREMIUM = COMP_RIPCA_FC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_RIPCA_LC_PREMIUM_LABEL() {
		return COMP_RIPCA_LC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_LC_PREMIUM() {
		return COMP_RIPCA_LC_PREMIUM;
	}

	public void setCOMP_RIPCA_LC_PREMIUM_LABEL(HtmlOutputLabel COMP_RIPCA_LC_PREMIUM_LABEL) {
		this.COMP_RIPCA_LC_PREMIUM_LABEL = COMP_RIPCA_LC_PREMIUM_LABEL;
	}

	public void setCOMP_RIPCA_LC_PREMIUM(HtmlInputText COMP_RIPCA_LC_PREMIUM) {
		this.COMP_RIPCA_LC_PREMIUM = COMP_RIPCA_LC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_RIPCA_FC_COMMISSION_LABEL() {
		return COMP_RIPCA_FC_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_FC_COMMISSION() {
		return COMP_RIPCA_FC_COMMISSION;
	}

	public void setCOMP_RIPCA_FC_COMMISSION_LABEL(HtmlOutputLabel COMP_RIPCA_FC_COMMISSION_LABEL) {
		this.COMP_RIPCA_FC_COMMISSION_LABEL = COMP_RIPCA_FC_COMMISSION_LABEL;
	}

	public void setCOMP_RIPCA_FC_COMMISSION(HtmlInputText COMP_RIPCA_FC_COMMISSION) {
		this.COMP_RIPCA_FC_COMMISSION = COMP_RIPCA_FC_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_RIPCA_LC_COMMISSION_LABEL() {
		return COMP_RIPCA_LC_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_LC_COMMISSION() {
		return COMP_RIPCA_LC_COMMISSION;
	}

	public void setCOMP_RIPCA_LC_COMMISSION_LABEL(HtmlOutputLabel COMP_RIPCA_LC_COMMISSION_LABEL) {
		this.COMP_RIPCA_LC_COMMISSION_LABEL = COMP_RIPCA_LC_COMMISSION_LABEL;
	}

	public void setCOMP_RIPCA_LC_COMMISSION(HtmlInputText COMP_RIPCA_LC_COMMISSION) {
		this.COMP_RIPCA_LC_COMMISSION = COMP_RIPCA_LC_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_RIPCA_CLM_PAID_LABEL() {
		return COMP_RIPCA_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_CLM_PAID() {
		return COMP_RIPCA_CLM_PAID;
	}

	public void setCOMP_RIPCA_CLM_PAID_LABEL(HtmlOutputLabel COMP_RIPCA_CLM_PAID_LABEL) {
		this.COMP_RIPCA_CLM_PAID_LABEL = COMP_RIPCA_CLM_PAID_LABEL;
	}

	public void setCOMP_RIPCA_CLM_PAID(HtmlInputText COMP_RIPCA_CLM_PAID) {
		this.COMP_RIPCA_CLM_PAID = COMP_RIPCA_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_RIPCA_CLAIMS_OS_LABEL() {
		return COMP_RIPCA_CLAIMS_OS_LABEL;
	}

	public HtmlInputText getCOMP_RIPCA_CLAIMS_OS() {
		return COMP_RIPCA_CLAIMS_OS;
	}

	public void setCOMP_RIPCA_CLAIMS_OS_LABEL(HtmlOutputLabel COMP_RIPCA_CLAIMS_OS_LABEL) {
		this.COMP_RIPCA_CLAIMS_OS_LABEL = COMP_RIPCA_CLAIMS_OS_LABEL;
	}

	public void setCOMP_RIPCA_CLAIMS_OS(HtmlInputText COMP_RIPCA_CLAIMS_OS) {
		this.COMP_RIPCA_CLAIMS_OS = COMP_RIPCA_CLAIMS_OS;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_LABEL() {
		return COMP_UI_M_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME() {
		return COMP_UI_M_CUST_NAME;
	}

	public void setCOMP_UI_M_CUST_NAME_LABEL(HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL) {
		this.COMP_UI_M_CUST_NAME_LABEL = COMP_UI_M_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME(HtmlInputText COMP_UI_M_CUST_NAME) {
		this.COMP_UI_M_CUST_NAME = COMP_UI_M_CUST_NAME;
	}

	public PT_IL_RI_PART_CUST_ALLOC getPT_IL_RI_PART_CUST_ALLOC_BEAN() {
		return PT_IL_RI_PART_CUST_ALLOC_BEAN;
	}

	public void setPT_IL_RI_PART_CUST_ALLOC_BEAN(PT_IL_RI_PART_CUST_ALLOC PT_IL_RI_PART_CUST_ALLOC_BEAN) {
		this.PT_IL_RI_PART_CUST_ALLOC_BEAN = PT_IL_RI_PART_CUST_ALLOC_BEAN;
	}

	public List<PT_IL_RI_PART_CUST_ALLOC> getDataListPT_IL_RI_PART_CUST_ALLOC() {
		return dataListPT_IL_RI_PART_CUST_ALLOC;
	}

	public void setDataListPT_IL_RI_PART_CUST_ALLOC(List<PT_IL_RI_PART_CUST_ALLOC> dataListPT_IL_RI_PART_CUST_ALLOC) {
		this.dataListPT_IL_RI_PART_CUST_ALLOC = dataListPT_IL_RI_PART_CUST_ALLOC;
	}

	public String getFilterByRIPCA_CUST_CODE() {
	    return filterByRIPCA_CUST_CODE;
	}

	public void setFilterByRIPCA_CUST_CODE(String filterByRIPCA_CUST_CODE) {
	    this.filterByRIPCA_CUST_CODE = filterByRIPCA_CUST_CODE;
	}

	public String getFilterByRIPCA_SHARE_PERC() {
	    return filterByRIPCA_SHARE_PERC;
	}

	 public void setFilterByRIPCA_SHARE_PERC(String filterByRIPCA_SHARE_PERC) {
	    this.filterByRIPCA_SHARE_PERC = filterByRIPCA_SHARE_PERC;
	}

	 
	public UIDataTable getDataTable() {
	    return dataTable;
	}
	public void setDataTable(UIDataTable dataTable) {
	    this.dataTable = dataTable;
	}
	public PT_IL_RI_PART_CUST_ALLOC_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PT_IL_RI_PART_CUST_ALLOC_HELPER helper) {
		this.helper = helper;
	}
	public PILQ111_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILQ111_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

}

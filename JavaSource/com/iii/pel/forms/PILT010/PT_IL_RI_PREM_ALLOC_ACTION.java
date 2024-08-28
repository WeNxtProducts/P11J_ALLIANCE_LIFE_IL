package com.iii.pel.forms.PILT010;

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
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_RI_PREM_ALLOC_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_LAYER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_LAYER_CODE;

	private HtmlOutputLabel COMP_UI_M_LAYER_CODE_DESC_LABEL;
	
	private HtmlOutputLabel COMP_RPA_CQS_YN_LABEL;

	public HtmlOutputLabel getCOMP_RPA_CQS_YN_LABEL() {
		return COMP_RPA_CQS_YN_LABEL;
	}

	public void setCOMP_RPA_CQS_YN_LABEL(HtmlOutputLabel cOMP_RPA_CQS_YN_LABEL) {
		COMP_RPA_CQS_YN_LABEL = cOMP_RPA_CQS_YN_LABEL;
	}

	private HtmlInputText COMP_UI_M_LAYER_CODE_DESC;
	
	
	private HtmlInputText COMP_RPA_CQS_YN;

	

	public HtmlInputText getCOMP_RPA_CQS_YN() {
		return COMP_RPA_CQS_YN;
	}

	public void setCOMP_RPA_CQS_YN(HtmlInputText cOMP_RPA_CQS_YN) {
		COMP_RPA_CQS_YN = cOMP_RPA_CQS_YN;
	}

	private HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL;
	//added by gopi for alliance  on 06/07/22
	private HtmlOutputLabel COMP_RPA_RI_CUST_CODE_LABEL;
	private HtmlOutputLabel COMP_RPA_RI_CUST_PERC_LABEL;
	private HtmlInputText COMP_RPA_RI_CUST_PERC;
	public HtmlOutputLabel getCOMP_RPA_RI_CUST_PERC_LABEL() {
		return COMP_RPA_RI_CUST_PERC_LABEL;
	}

	public void setCOMP_RPA_RI_CUST_PERC_LABEL(
			HtmlOutputLabel cOMP_RPA_RI_CUST_PERC_LABEL) {
		COMP_RPA_RI_CUST_PERC_LABEL = cOMP_RPA_RI_CUST_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_CUST_PERC() {
		return COMP_RPA_RI_CUST_PERC;
	}

	public void setCOMP_RPA_RI_CUST_PERC(HtmlInputText cOMP_RPA_RI_CUST_PERC) {
		COMP_RPA_RI_CUST_PERC = cOMP_RPA_RI_CUST_PERC;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_CUST_CODE_LABEL() {
		return COMP_RPA_RI_CUST_CODE_LABEL;
	}

	public void setCOMP_RPA_RI_CUST_CODE_LABEL(
			HtmlOutputLabel cOMP_RPA_RI_CUST_CODE_LABEL) {
		COMP_RPA_RI_CUST_CODE_LABEL = cOMP_RPA_RI_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_CUST_CODE() {
		return COMP_RPA_RI_CUST_CODE;
	}

	public void setCOMP_RPA_RI_CUST_CODE(HtmlInputText cOMP_RPA_RI_CUST_CODE) {
		COMP_RPA_RI_CUST_CODE = cOMP_RPA_RI_CUST_CODE;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CODE_DESC() {
		return COMP_UI_M_CUST_CODE_DESC;
	}

	public void setCOMP_UI_M_CUST_CODE_DESC(HtmlInputText cOMP_UI_M_CUST_CODE_DESC) {
		COMP_UI_M_CUST_CODE_DESC = cOMP_UI_M_CUST_CODE_DESC;
	}

	private HtmlInputText COMP_RPA_RI_CUST_CODE;
	private HtmlInputText COMP_UI_M_CUST_CODE_DESC;
	

	private HtmlInputText COMP_UI_M_COVER_CODE;

	private HtmlOutputLabel COMP_RPA_TREATY_TYPE_LABEL;

	private HtmlInputText COMP_RPA_TREATY_TYPE;

	private HtmlOutputLabel COMP_RPA_RI_FC_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_SA;

	private HtmlOutputLabel COMP_RPA_RI_FC_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_PREM;

	private HtmlOutputLabel COMP_RPA_RI_LC_PRD_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_PRD_PREM;

	private HtmlOutputLabel COMP_RPA_RET_FC_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_SA;

	private HtmlOutputLabel COMP_RPA_RET_FC_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_PREM;

	private HtmlOutputLabel COMP_RPA_RET_LC_PRD_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_PRD_PREM;

	private HtmlOutputLabel COMP_RPA_REINS_COMM_PERC_LABEL;

	private HtmlInputText COMP_RPA_REINS_COMM_PERC;

	private HtmlOutputLabel COMP_RPA_REINS_FC_COMM_LABEL;

	private HtmlInputText COMP_RPA_REINS_FC_COMM;

	private HtmlOutputLabel COMP_RPA_REINS_PRD_FC_COMM_LABEL;

	private HtmlInputText COMP_RPA_REINS_PRD_FC_COMM;

	private HtmlOutputLabel COMP_RPA_RI_FC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RI_FC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_RET_FC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RET_FC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_RI_LC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RI_LC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_RET_LC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RET_LC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_POL_PREM;

	private HtmlOutputLabel COMP_UI_M_TTY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TTY_DESC;
	
	private HtmlInputText COMP_RPA_FC_EXTRA_PREM;
	
	private HtmlInputText COMP_RPA_RI_GROSS_FC_PREM;

	private PT_IL_RI_PREM_ALLOC PT_IL_RI_PREM_ALLOC_BEAN;
	
	private String filterByRPA_RET_FC_PREM;
	
	private String filterByRPA_REINS_FC_COMM;
	
	private String filterByRPA_RI_LC_PRD_PREM;
	
	private String filterByRPA_RET_LC_PRD_PREM;
	
	private String filterByRPA_TREATY_TYPE;
	
	private UIData dataTable;
	
	public PILT010_COMPOSITE_ACTION compositeAction;
	
	public PT_IL_RI_PREM_ALLOC_HELPER helper;

	private List<PT_IL_RI_PREM_ALLOC> dataList_PT_IL_RI_PREM_ALLOC = new ArrayList<PT_IL_RI_PREM_ALLOC>();
	
	private List<SelectItem> listPROD_AGE_CALC_FLAG = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListPROD_AGE_CALC_FLAG() {
		if (listPROD_AGE_CALC_FLAG.size() == 0) {
			listPROD_AGE_CALC_FLAG.clear();
			try {
				listPROD_AGE_CALC_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_AGE_CALC_FLAG;
	}

	public void setListPROD_AGE_CALC_FLAG(
			List<SelectItem> listPROD_AGE_CALC_FLAG) {
		this.listPROD_AGE_CALC_FLAG = listPROD_AGE_CALC_FLAG;
	}
	
	public PT_IL_RI_PREM_ALLOC_ACTION() {
		PT_IL_RI_PREM_ALLOC_BEAN = new PT_IL_RI_PREM_ALLOC();
		 helper = new PT_IL_RI_PREM_ALLOC_HELPER();
		 prepareDropDowns();
	}
	
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			/*added by raja on 18-07-2017 for ZBILQC-1730094*/
			helper.executeQuery();
			/*end*/
		if(dataList_PT_IL_RI_PREM_ALLOC != null && dataList_PT_IL_RI_PREM_ALLOC.size() > 0 ){
			compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_ACTION().
			setPT_IL_RI_PREM_ALLOC_BEAN(dataList_PT_IL_RI_PREM_ALLOC.get(0));
			PT_IL_RI_PREM_ALLOC_BEAN.setRowSelected(true);
		}
			
		}
		setBlockFlag(false);
	}

	public HtmlOutputLabel getCOMP_UI_M_LAYER_CODE_LABEL() {
		return COMP_UI_M_LAYER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LAYER_CODE() {
		return COMP_UI_M_LAYER_CODE;
	}

	public void setCOMP_UI_M_LAYER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_LAYER_CODE_LABEL) {
		this.COMP_UI_M_LAYER_CODE_LABEL = COMP_UI_M_LAYER_CODE_LABEL;
	}

	public void setCOMP_UI_M_LAYER_CODE(HtmlInputText COMP_UI_M_LAYER_CODE) {
		this.COMP_UI_M_LAYER_CODE = COMP_UI_M_LAYER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LAYER_CODE_DESC_LABEL() {
		return COMP_UI_M_LAYER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LAYER_CODE_DESC() {
		return COMP_UI_M_LAYER_CODE_DESC;
	}

	public void setCOMP_UI_M_LAYER_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_LAYER_CODE_DESC_LABEL) {
		this.COMP_UI_M_LAYER_CODE_DESC_LABEL = COMP_UI_M_LAYER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_LAYER_CODE_DESC(HtmlInputText COMP_UI_M_LAYER_CODE_DESC) {
		this.COMP_UI_M_LAYER_CODE_DESC = COMP_UI_M_LAYER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_CODE_LABEL() {
		return COMP_UI_M_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_CODE() {
		return COMP_UI_M_COVER_CODE;
	}

	public void setCOMP_UI_M_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL) {
		this.COMP_UI_M_COVER_CODE_LABEL = COMP_UI_M_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_COVER_CODE(HtmlInputText COMP_UI_M_COVER_CODE) {
		this.COMP_UI_M_COVER_CODE = COMP_UI_M_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_RPA_TREATY_TYPE_LABEL() {
		return COMP_RPA_TREATY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RPA_TREATY_TYPE() {
		return COMP_RPA_TREATY_TYPE;
	}

	public void setCOMP_RPA_TREATY_TYPE_LABEL(HtmlOutputLabel COMP_RPA_TREATY_TYPE_LABEL) {
		this.COMP_RPA_TREATY_TYPE_LABEL = COMP_RPA_TREATY_TYPE_LABEL;
	}

	public void setCOMP_RPA_TREATY_TYPE(HtmlInputText COMP_RPA_TREATY_TYPE) {
		this.COMP_RPA_TREATY_TYPE = COMP_RPA_TREATY_TYPE;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_SA_LABEL() {
		return COMP_RPA_RI_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_SA() {
		return COMP_RPA_RI_FC_SA;
	}

	public void setCOMP_RPA_RI_FC_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_SA_LABEL) {
		this.COMP_RPA_RI_FC_SA_LABEL = COMP_RPA_RI_FC_SA_LABEL;
	}

	public void setCOMP_RPA_RI_FC_SA(HtmlInputText COMP_RPA_RI_FC_SA) {
		this.COMP_RPA_RI_FC_SA = COMP_RPA_RI_FC_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_PREM_LABEL() {
		return COMP_RPA_RI_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_PREM() {
		return COMP_RPA_RI_FC_PREM;
	}

	public void setCOMP_RPA_RI_FC_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_PREM_LABEL) {
		this.COMP_RPA_RI_FC_PREM_LABEL = COMP_RPA_RI_FC_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_FC_PREM(HtmlInputText COMP_RPA_RI_FC_PREM) {
		this.COMP_RPA_RI_FC_PREM = COMP_RPA_RI_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_PRD_PREM_LABEL() {
		return COMP_RPA_RI_LC_PRD_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_PRD_PREM() {
		return COMP_RPA_RI_LC_PRD_PREM;
	}

	public void setCOMP_RPA_RI_LC_PRD_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_PRD_PREM_LABEL) {
		this.COMP_RPA_RI_LC_PRD_PREM_LABEL = COMP_RPA_RI_LC_PRD_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_LC_PRD_PREM(HtmlInputText COMP_RPA_RI_LC_PRD_PREM) {
		this.COMP_RPA_RI_LC_PRD_PREM = COMP_RPA_RI_LC_PRD_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_SA_LABEL() {
		return COMP_RPA_RET_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_SA() {
		return COMP_RPA_RET_FC_SA;
	}

	public void setCOMP_RPA_RET_FC_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_SA_LABEL) {
		this.COMP_RPA_RET_FC_SA_LABEL = COMP_RPA_RET_FC_SA_LABEL;
	}

	public void setCOMP_RPA_RET_FC_SA(HtmlInputText COMP_RPA_RET_FC_SA) {
		this.COMP_RPA_RET_FC_SA = COMP_RPA_RET_FC_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_PREM_LABEL() {
		return COMP_RPA_RET_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_PREM() {
		return COMP_RPA_RET_FC_PREM;
	}

	public void setCOMP_RPA_RET_FC_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_PREM_LABEL) {
		this.COMP_RPA_RET_FC_PREM_LABEL = COMP_RPA_RET_FC_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_FC_PREM(HtmlInputText COMP_RPA_RET_FC_PREM) {
		this.COMP_RPA_RET_FC_PREM = COMP_RPA_RET_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_PRD_PREM_LABEL() {
		return COMP_RPA_RET_LC_PRD_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_PRD_PREM() {
		return COMP_RPA_RET_LC_PRD_PREM;
	}

	public void setCOMP_RPA_RET_LC_PRD_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_PRD_PREM_LABEL) {
		this.COMP_RPA_RET_LC_PRD_PREM_LABEL = COMP_RPA_RET_LC_PRD_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_LC_PRD_PREM(HtmlInputText COMP_RPA_RET_LC_PRD_PREM) {
		this.COMP_RPA_RET_LC_PRD_PREM = COMP_RPA_RET_LC_PRD_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_COMM_PERC_LABEL() {
		return COMP_RPA_REINS_COMM_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_COMM_PERC() {
		return COMP_RPA_REINS_COMM_PERC;
	}

	public void setCOMP_RPA_REINS_COMM_PERC_LABEL(HtmlOutputLabel COMP_RPA_REINS_COMM_PERC_LABEL) {
		this.COMP_RPA_REINS_COMM_PERC_LABEL = COMP_RPA_REINS_COMM_PERC_LABEL;
	}

	public void setCOMP_RPA_REINS_COMM_PERC(HtmlInputText COMP_RPA_REINS_COMM_PERC) {
		this.COMP_RPA_REINS_COMM_PERC = COMP_RPA_REINS_COMM_PERC;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_FC_COMM_LABEL() {
		return COMP_RPA_REINS_FC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_FC_COMM() {
		return COMP_RPA_REINS_FC_COMM;
	}

	public void setCOMP_RPA_REINS_FC_COMM_LABEL(HtmlOutputLabel COMP_RPA_REINS_FC_COMM_LABEL) {
		this.COMP_RPA_REINS_FC_COMM_LABEL = COMP_RPA_REINS_FC_COMM_LABEL;
	}

	public void setCOMP_RPA_REINS_FC_COMM(HtmlInputText COMP_RPA_REINS_FC_COMM) {
		this.COMP_RPA_REINS_FC_COMM = COMP_RPA_REINS_FC_COMM;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_PRD_FC_COMM_LABEL() {
		return COMP_RPA_REINS_PRD_FC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_PRD_FC_COMM() {
		return COMP_RPA_REINS_PRD_FC_COMM;
	}

	public void setCOMP_RPA_REINS_PRD_FC_COMM_LABEL(HtmlOutputLabel COMP_RPA_REINS_PRD_FC_COMM_LABEL) {
		this.COMP_RPA_REINS_PRD_FC_COMM_LABEL = COMP_RPA_REINS_PRD_FC_COMM_LABEL;
	}

	public void setCOMP_RPA_REINS_PRD_FC_COMM(HtmlInputText COMP_RPA_REINS_PRD_FC_COMM) {
		this.COMP_RPA_REINS_PRD_FC_COMM = COMP_RPA_REINS_PRD_FC_COMM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_POL_SA_LABEL() {
		return COMP_RPA_RI_FC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_POL_SA() {
		return COMP_RPA_RI_FC_POL_SA;
	}

	public void setCOMP_RPA_RI_FC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_POL_SA_LABEL) {
		this.COMP_RPA_RI_FC_POL_SA_LABEL = COMP_RPA_RI_FC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RI_FC_POL_SA(HtmlInputText COMP_RPA_RI_FC_POL_SA) {
		this.COMP_RPA_RI_FC_POL_SA = COMP_RPA_RI_FC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_POL_PREM_LABEL() {
		return COMP_RPA_RI_FC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_POL_PREM() {
		return COMP_RPA_RI_FC_POL_PREM;
	}

	public void setCOMP_RPA_RI_FC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_POL_PREM_LABEL) {
		this.COMP_RPA_RI_FC_POL_PREM_LABEL = COMP_RPA_RI_FC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_FC_POL_PREM(HtmlInputText COMP_RPA_RI_FC_POL_PREM) {
		this.COMP_RPA_RI_FC_POL_PREM = COMP_RPA_RI_FC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_POL_SA_LABEL() {
		return COMP_RPA_RET_FC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_POL_SA() {
		return COMP_RPA_RET_FC_POL_SA;
	}

	public void setCOMP_RPA_RET_FC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_POL_SA_LABEL) {
		this.COMP_RPA_RET_FC_POL_SA_LABEL = COMP_RPA_RET_FC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RET_FC_POL_SA(HtmlInputText COMP_RPA_RET_FC_POL_SA) {
		this.COMP_RPA_RET_FC_POL_SA = COMP_RPA_RET_FC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_POL_PREM_LABEL() {
		return COMP_RPA_RET_FC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_POL_PREM() {
		return COMP_RPA_RET_FC_POL_PREM;
	}

	public void setCOMP_RPA_RET_FC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_POL_PREM_LABEL) {
		this.COMP_RPA_RET_FC_POL_PREM_LABEL = COMP_RPA_RET_FC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_FC_POL_PREM(HtmlInputText COMP_RPA_RET_FC_POL_PREM) {
		this.COMP_RPA_RET_FC_POL_PREM = COMP_RPA_RET_FC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_POL_SA_LABEL() {
		return COMP_RPA_RI_LC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_POL_SA() {
		return COMP_RPA_RI_LC_POL_SA;
	}

	public void setCOMP_RPA_RI_LC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_POL_SA_LABEL) {
		this.COMP_RPA_RI_LC_POL_SA_LABEL = COMP_RPA_RI_LC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RI_LC_POL_SA(HtmlInputText COMP_RPA_RI_LC_POL_SA) {
		this.COMP_RPA_RI_LC_POL_SA = COMP_RPA_RI_LC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_POL_PREM_LABEL() {
		return COMP_RPA_RI_LC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_POL_PREM() {
		return COMP_RPA_RI_LC_POL_PREM;
	}

	public void setCOMP_RPA_RI_LC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_POL_PREM_LABEL) {
		this.COMP_RPA_RI_LC_POL_PREM_LABEL = COMP_RPA_RI_LC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_LC_POL_PREM(HtmlInputText COMP_RPA_RI_LC_POL_PREM) {
		this.COMP_RPA_RI_LC_POL_PREM = COMP_RPA_RI_LC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_POL_SA_LABEL() {
		return COMP_RPA_RET_LC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_POL_SA() {
		return COMP_RPA_RET_LC_POL_SA;
	}

	public void setCOMP_RPA_RET_LC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_POL_SA_LABEL) {
		this.COMP_RPA_RET_LC_POL_SA_LABEL = COMP_RPA_RET_LC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RET_LC_POL_SA(HtmlInputText COMP_RPA_RET_LC_POL_SA) {
		this.COMP_RPA_RET_LC_POL_SA = COMP_RPA_RET_LC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_POL_PREM_LABEL() {
		return COMP_RPA_RET_LC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_POL_PREM() {
		return COMP_RPA_RET_LC_POL_PREM;
	}

	public void setCOMP_RPA_RET_LC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_POL_PREM_LABEL) {
		this.COMP_RPA_RET_LC_POL_PREM_LABEL = COMP_RPA_RET_LC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_LC_POL_PREM(HtmlInputText COMP_RPA_RET_LC_POL_PREM) {
		this.COMP_RPA_RET_LC_POL_PREM = COMP_RPA_RET_LC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_TTY_DESC_LABEL() {
		return COMP_UI_M_TTY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TTY_DESC() {
		return COMP_UI_M_TTY_DESC;
	}

	public void setCOMP_UI_M_TTY_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TTY_DESC_LABEL) {
		this.COMP_UI_M_TTY_DESC_LABEL = COMP_UI_M_TTY_DESC_LABEL;
	}

	public void setCOMP_UI_M_TTY_DESC(HtmlInputText COMP_UI_M_TTY_DESC) {
		this.COMP_UI_M_TTY_DESC = COMP_UI_M_TTY_DESC;
	}

	public PT_IL_RI_PREM_ALLOC getPT_IL_RI_PREM_ALLOC_BEAN() {
		return PT_IL_RI_PREM_ALLOC_BEAN;
	}

	public void setPT_IL_RI_PREM_ALLOC_BEAN(PT_IL_RI_PREM_ALLOC PT_IL_RI_PREM_ALLOC_BEAN) {
		this.PT_IL_RI_PREM_ALLOC_BEAN = PT_IL_RI_PREM_ALLOC_BEAN;
	}

	public List<PT_IL_RI_PREM_ALLOC> getDataList_PT_IL_RI_PREM_ALLOC() {
		return dataList_PT_IL_RI_PREM_ALLOC;
	}

	public void setDataList_PT_IL_RI_PREM_ALLOC(
			List<PT_IL_RI_PREM_ALLOC> dataList_PT_IL_RI_PREM_ALLOC) {
		this.dataList_PT_IL_RI_PREM_ALLOC = dataList_PT_IL_RI_PREM_ALLOC;
	}
	
	public HtmlInputText getCOMP_RPA_FC_EXTRA_PREM() {
		return COMP_RPA_FC_EXTRA_PREM;
	}

	public void setCOMP_RPA_FC_EXTRA_PREM(HtmlInputText comp_rpa_fc_extra_prem) {
		COMP_RPA_FC_EXTRA_PREM = comp_rpa_fc_extra_prem;
	}

	public HtmlInputText getCOMP_RPA_RI_GROSS_FC_PREM() {
		return COMP_RPA_RI_GROSS_FC_PREM;
	}

	public void setCOMP_RPA_RI_GROSS_FC_PREM(HtmlInputText comp_rpa_ri_gross_fc_prem) {
		COMP_RPA_RI_GROSS_FC_PREM = comp_rpa_ri_gross_fc_prem;
	}

	/**
	 * @author 53058
	 * Feb 4, 2009 5:21:41 PM
	 *
	 *
	 * @return
	 */
	public String riDiscLoadWhenButtonPressed(){
		try {
			PV_IL_POL_RI_DETL_HELPER pvHelper = new PV_IL_POL_RI_DETL_HELPER();
			pvHelper.clearErrorMap();
			PT_IL_RI_PREM_ALLOC_HELPER helper = new PT_IL_RI_PREM_ALLOC_HELPER();
			helper.riDiscLoadWhenButtonPressed();
			PT_IL_RI_DISC_LOAD_HELPER discLoadHelper = new PT_IL_RI_DISC_LOAD_HELPER();
			discLoadHelper.executeQuery();
			
			
		} catch (Exception e) {
			PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().getErrorMap().put("current", e.getMessage());
			PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().setErrorMessages(e.getMessage());
			return null;
		}
		return "PILT010_riDiscLoad";
	}
	
	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (dataList_PT_IL_RI_PREM_ALLOC!=null && dataList_PT_IL_RI_PREM_ALLOC.size() != 0) {				
				PT_IL_RI_PREM_ALLOC_BEAN = (PT_IL_RI_PREM_ALLOC) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_RI_PREM_ALLOC_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_UI_M_COVER_CODE.resetValue();
		COMP_RPA_TREATY_TYPE.resetValue();
		COMP_UI_M_TTY_DESC.resetValue();
		COMP_RPA_RI_FC_SA.resetValue();
		COMP_RPA_RET_FC_SA.resetValue();
		COMP_RPA_RI_FC_PREM.resetValue();
		COMP_RPA_RET_FC_PREM.resetValue();
		COMP_RPA_REINS_FC_COMM.resetValue();
		COMP_RPA_REINS_PRD_FC_COMM.resetValue();
		COMP_RPA_REINS_COMM_PERC.resetValue();
		COMP_RPA_RI_FC_POL_SA.resetValue();
		COMP_RPA_RI_FC_POL_PREM.resetValue();
		COMP_RPA_RET_FC_POL_SA.resetValue();
		COMP_RPA_RET_FC_POL_PREM.resetValue();
		COMP_RPA_RI_LC_POL_PREM.resetValue();
		COMP_RPA_RI_LC_POL_SA.resetValue();
		COMP_RPA_RET_LC_POL_SA.resetValue();
		COMP_RPA_RET_LC_POL_PREM.resetValue();
		COMP_RPA_FC_EXTRA_PREM.resetValue();
	//	COMP_RPA_RI_GROSS_FC_PREM.resetValue();
		COMP_RPA_RI_CUST_CODE.resetValue();
		COMP_UI_M_CUST_CODE_DESC.resetValue();
		COMP_RPA_RI_CUST_PERC.resetValue();
		COMP_UI_M_CUST_CODE_DESC.resetValue();

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_RI_PREM_ALLOC> iterator = dataList_PT_IL_RI_PREM_ALLOC.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
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
	 * @return the filterByRPA_RET_FC_PREM
	 */
	public String getFilterByRPA_RET_FC_PREM() {
		return filterByRPA_RET_FC_PREM;
	}

	/**
	 * @param filterByRPA_RET_FC_PREM the filterByRPA_RET_FC_PREM to set
	 */
	public void setFilterByRPA_RET_FC_PREM(String filterByRPA_RET_FC_PREM) {
		this.filterByRPA_RET_FC_PREM = filterByRPA_RET_FC_PREM;
	}

	/**
	 * @return the filterByRPA_REINS_FC_COMM
	 */
	public String getFilterByRPA_REINS_FC_COMM() {
		return filterByRPA_REINS_FC_COMM;
	}

	/**
	 * @param filterByRPA_REINS_FC_COMM the filterByRPA_REINS_FC_COMM to set
	 */
	public void setFilterByRPA_REINS_FC_COMM(String filterByRPA_REINS_FC_COMM) {
		this.filterByRPA_REINS_FC_COMM = filterByRPA_REINS_FC_COMM;
	}

	/**
	 * @return the filterByRPA_RI_LC_PRD_PREM
	 */
	public String getFilterByRPA_RI_LC_PRD_PREM() {
		return filterByRPA_RI_LC_PRD_PREM;
	}

	/**
	 * @param filterByRPA_RI_LC_PRD_PREM the filterByRPA_RI_LC_PRD_PREM to set
	 */
	public void setFilterByRPA_RI_LC_PRD_PREM(String filterByRPA_RI_LC_PRD_PREM) {
		this.filterByRPA_RI_LC_PRD_PREM = filterByRPA_RI_LC_PRD_PREM;
	}

	/**
	 * @return the filterByRPA_RET_LC_PRD_PREM
	 */
	public String getFilterByRPA_RET_LC_PRD_PREM() {
		return filterByRPA_RET_LC_PRD_PREM;
	}

	/**
	 * @param filterByRPA_RET_LC_PRD_PREM the filterByRPA_RET_LC_PRD_PREM to set
	 */
	public void setFilterByRPA_RET_LC_PRD_PREM(String filterByRPA_RET_LC_PRD_PREM) {
		this.filterByRPA_RET_LC_PRD_PREM = filterByRPA_RET_LC_PRD_PREM;
	}

	public String getFilterByRPA_TREATY_TYPE() {
		return filterByRPA_TREATY_TYPE;
	}

	public void setFilterByRPA_TREATY_TYPE(String filterByRPA_TREATY_TYPE) {
		this.filterByRPA_TREATY_TYPE = filterByRPA_TREATY_TYPE;
	}

	public PILT010_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT010_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_RI_PREM_ALLOC_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_RI_PREM_ALLOC_HELPER helper) {
		this.helper = helper;
	}
	
	private void prepareDropDowns() {
		try{
			
			
			setListPROD_AGE_CALC_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PRODUCT", "PM_IL_PRODUCT.PROD_AGE_CALC_FLAG",
					"CALFLAG"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}

package com.iii.pel.forms.PILT020;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCC_CHARGE_CODE_LABEL;

	private HtmlInputText COMP_PCC_CHARGE_CODE;

	private HtmlOutputLabel COMP_PCC_FC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_FC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PCC_FC_INS_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_FC_INS_CHARGE_AMT;

	private HtmlOutputLabel COMP_UI_M_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_DESC;

	private HtmlOutputLabel COMP_PCC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_PCC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_PCC_APPLY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_PCC_APPLY_PERIOD;

	private HtmlOutputLabel COMP_PCC_LC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_LC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PCC_LC_INS_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PCC_LC_INS_CHARGE_AMT;

	private HtmlOutputLabel COMP_B_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_B_CHARGE_DESC;
	
	private List<SelectItem>  CHARGE_APPLY_PRD = new ArrayList<SelectItem>();
	
	private List fetchList = new ArrayList();
	
	private UIData dataTable;

	private PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN;

	public PT_IL_PREM_COLL_CHARGE_ACTION() {
		PT_IL_PREM_COLL_CHARGE_BEAN = new PT_IL_PREM_COLL_CHARGE();
	}

	public HtmlOutputLabel getCOMP_PCC_CHARGE_CODE_LABEL() {
		return COMP_PCC_CHARGE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCC_CHARGE_CODE() {
		return COMP_PCC_CHARGE_CODE;
	}

	public void setCOMP_PCC_CHARGE_CODE_LABEL(HtmlOutputLabel COMP_PCC_CHARGE_CODE_LABEL) {
		this.COMP_PCC_CHARGE_CODE_LABEL = COMP_PCC_CHARGE_CODE_LABEL;
	}

	public void setCOMP_PCC_CHARGE_CODE(HtmlInputText COMP_PCC_CHARGE_CODE) {
		this.COMP_PCC_CHARGE_CODE = COMP_PCC_CHARGE_CODE;
	}

	public HtmlOutputLabel getCOMP_PCC_FC_CHARGE_AMT_LABEL() {
		return COMP_PCC_FC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_FC_CHARGE_AMT() {
		return COMP_PCC_FC_CHARGE_AMT;
	}

	public void setCOMP_PCC_FC_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_FC_CHARGE_AMT_LABEL) {
		this.COMP_PCC_FC_CHARGE_AMT_LABEL = COMP_PCC_FC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_FC_CHARGE_AMT(HtmlInputText COMP_PCC_FC_CHARGE_AMT) {
		this.COMP_PCC_FC_CHARGE_AMT = COMP_PCC_FC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCC_FC_INS_CHARGE_AMT_LABEL() {
		return COMP_PCC_FC_INS_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_FC_INS_CHARGE_AMT() {
		return COMP_PCC_FC_INS_CHARGE_AMT;
	}

	public void setCOMP_PCC_FC_INS_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_FC_INS_CHARGE_AMT_LABEL) {
		this.COMP_PCC_FC_INS_CHARGE_AMT_LABEL = COMP_PCC_FC_INS_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_FC_INS_CHARGE_AMT(HtmlInputText COMP_PCC_FC_INS_CHARGE_AMT) {
		this.COMP_PCC_FC_INS_CHARGE_AMT = COMP_PCC_FC_INS_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHARGE_DESC_LABEL() {
		return COMP_UI_M_CHARGE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CHARGE_DESC() {
		return COMP_UI_M_CHARGE_DESC;
	}

	public void setCOMP_UI_M_CHARGE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CHARGE_DESC_LABEL) {
		this.COMP_UI_M_CHARGE_DESC_LABEL = COMP_UI_M_CHARGE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CHARGE_DESC(HtmlInputText COMP_UI_M_CHARGE_DESC) {
		this.COMP_UI_M_CHARGE_DESC = COMP_UI_M_CHARGE_DESC;
	}

	public HtmlOutputLabel getCOMP_PCC_CUST_SHARE_PERC_LABEL() {
		return COMP_PCC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PCC_CUST_SHARE_PERC() {
		return COMP_PCC_CUST_SHARE_PERC;
	}

	public void setCOMP_PCC_CUST_SHARE_PERC_LABEL(HtmlOutputLabel COMP_PCC_CUST_SHARE_PERC_LABEL) {
		this.COMP_PCC_CUST_SHARE_PERC_LABEL = COMP_PCC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_PCC_CUST_SHARE_PERC(HtmlInputText COMP_PCC_CUST_SHARE_PERC) {
		this.COMP_PCC_CUST_SHARE_PERC = COMP_PCC_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_PCC_APPLY_PERIOD_LABEL() {
		return COMP_PCC_APPLY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PCC_APPLY_PERIOD() {
		return COMP_PCC_APPLY_PERIOD;
	}

	public void setCOMP_PCC_APPLY_PERIOD_LABEL(HtmlOutputLabel COMP_PCC_APPLY_PERIOD_LABEL) {
		this.COMP_PCC_APPLY_PERIOD_LABEL = COMP_PCC_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_PCC_APPLY_PERIOD(HtmlSelectOneMenu COMP_PCC_APPLY_PERIOD) {
		this.COMP_PCC_APPLY_PERIOD = COMP_PCC_APPLY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PCC_LC_CHARGE_AMT_LABEL() {
		return COMP_PCC_LC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_LC_CHARGE_AMT() {
		return COMP_PCC_LC_CHARGE_AMT;
	}

	public void setCOMP_PCC_LC_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_LC_CHARGE_AMT_LABEL) {
		this.COMP_PCC_LC_CHARGE_AMT_LABEL = COMP_PCC_LC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_LC_CHARGE_AMT(HtmlInputText COMP_PCC_LC_CHARGE_AMT) {
		this.COMP_PCC_LC_CHARGE_AMT = COMP_PCC_LC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCC_LC_INS_CHARGE_AMT_LABEL() {
		return COMP_PCC_LC_INS_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCC_LC_INS_CHARGE_AMT() {
		return COMP_PCC_LC_INS_CHARGE_AMT;
	}

	public void setCOMP_PCC_LC_INS_CHARGE_AMT_LABEL(HtmlOutputLabel COMP_PCC_LC_INS_CHARGE_AMT_LABEL) {
		this.COMP_PCC_LC_INS_CHARGE_AMT_LABEL = COMP_PCC_LC_INS_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PCC_LC_INS_CHARGE_AMT(HtmlInputText COMP_PCC_LC_INS_CHARGE_AMT) {
		this.COMP_PCC_LC_INS_CHARGE_AMT = COMP_PCC_LC_INS_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_B_CHARGE_DESC_LABEL() {
		return COMP_B_CHARGE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_B_CHARGE_DESC() {
		return COMP_B_CHARGE_DESC;
	}

	public void setCOMP_B_CHARGE_DESC_LABEL(HtmlOutputLabel COMP_B_CHARGE_DESC_LABEL) {
		this.COMP_B_CHARGE_DESC_LABEL = COMP_B_CHARGE_DESC_LABEL;
	}

	public void setCOMP_B_CHARGE_DESC(HtmlInputText COMP_B_CHARGE_DESC) {
		this.COMP_B_CHARGE_DESC = COMP_B_CHARGE_DESC;
	}

	public PT_IL_PREM_COLL_CHARGE getPT_IL_PREM_COLL_CHARGE_BEAN() {
		return PT_IL_PREM_COLL_CHARGE_BEAN;
	}

	public void setPT_IL_PREM_COLL_CHARGE_BEAN(PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN) {
		this.PT_IL_PREM_COLL_CHARGE_BEAN = PT_IL_PREM_COLL_CHARGE_BEAN;
	}

	public void POST_QUERY_PT_IL_PREM_COLL_CHARGE(ActionEvent event)throws Exception{
		System.out.println("trigger called pt_il_prem_coll_charge.................");
		PT_IL_PREM_COLL_CHARGE_HELPER helper = new PT_IL_PREM_COLL_CHARGE_HELPER();
		//helper.trig_post_query_pt_il_prem_coll_charge();
	}

	public List<SelectItem> getCHARGE_APPLY_PRD()throws Exception {
		if(CHARGE_APPLY_PRD.size()==0){
			CHARGE_APPLY_PRD.clear();
			CHARGE_APPLY_PRD = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT020", "PT_IL_PREM_COLL_CHARGE", "PT_IL_PREM_COLL_CHARGE.PCC_APPLY_PERIOD", "IL_CHG_PRD");
			
		}return CHARGE_APPLY_PRD;
	}

	public void setCHARGE_APPLY_PRD(List<SelectItem> charge_apply_prd) {
		CHARGE_APPLY_PRD = charge_apply_prd;
	}

	public List getFetchList() {
		return fetchList;
	}

	public void setFetchList(List fetchList) {
		this.fetchList = fetchList;
	}
	
	//trigger for POST Query
	//pm_il_med_exam_helper.postQuery(compAction);----calling
	public void postQuery(PILT020_COMPOSITE_ACTION compositeAction)
	throws SQLException, Exception {
      //List<PT_IL_PREM_COLL_CHARGE> list = getDataList();
		List<PT_IL_PREM_COLL_CHARGE> list=null;
        if (list != null) {
	    Iterator<PT_IL_PREM_COLL_CHARGE>iterator = list.iterator();
    	while (iterator.hasNext()) {
		PT_IL_PREM_COLL_CHARGE dtlBean = iterator.next();
		DBProcedures procedures = new DBProcedures();
		//String code = dtlBean.getMED_EXAM_CODE();
		String code=null;
		ArrayList<String> CodeDescList = procedures.helperP_VAL_CODES(
				"IL_MED_EXM", code, "N", "N", null);
//		if (CodeDescList != null && CodeDescList.size() != 0) {
//			dtlBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));

		}

	}
}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}

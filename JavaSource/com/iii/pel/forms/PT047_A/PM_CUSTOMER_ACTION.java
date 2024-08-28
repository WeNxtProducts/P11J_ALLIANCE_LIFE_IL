package com.iii.pel.forms.PT047_A;

import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;

public class PM_CUSTOMER_ACTION extends CommonAction 
{
	private HtmlOutputLabel COMP_CUST_CODE_LABEL;
	private HtmlInputText COMP_CUST_CODE;
	
	private HtmlOutputLabel COMP_CUST_NAME_LABEL;
	private HtmlInputText COMP_CUST_NAME;
	
	private HtmlOutputLabel COMP_AGENCY_CODE_LABEL;
	private HtmlInputText COMP_AGENCY_CODE;
	
	private HtmlOutputLabel COMP_RANK_CODE_LABEL;
	private HtmlInputText COMP_RANK_CODE;
	
	private HtmlInputText COMP_UI_M_AGENCY_CODE_DESC;
	
	private HtmlInputText COMP_UI_M_RANK_CODE_DESC;
	
	private PM_CUSTOMER PM_CUSTOMER_BEAN;
	
	public PM_CUSTOMER_ACTION()
	{
		PM_CUSTOMER_BEAN=new PM_CUSTOMER();
	}

	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel comp_cust_code_label) {
		COMP_CUST_CODE_LABEL = comp_cust_code_label;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE(HtmlInputText comp_cust_code) {
		COMP_CUST_CODE = comp_cust_code;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel comp_cust_name_label) {
		COMP_CUST_NAME_LABEL = comp_cust_name_label;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME(HtmlInputText comp_cust_name) {
		COMP_CUST_NAME = comp_cust_name;
	}

	public HtmlOutputLabel getCOMP_AGENCY_CODE_LABEL() {
		return COMP_AGENCY_CODE_LABEL;
	}

	public void setCOMP_AGENCY_CODE_LABEL(HtmlOutputLabel comp_agency_code_label) {
		COMP_AGENCY_CODE_LABEL = comp_agency_code_label;
	}

	public HtmlInputText getCOMP_AGENCY_CODE() {
		return COMP_AGENCY_CODE;
	}

	public void setCOMP_AGENCY_CODE(HtmlInputText comp_agency_code) {
		COMP_AGENCY_CODE = comp_agency_code;
	}

	public HtmlOutputLabel getCOMP_RANK_CODE_LABEL() {
		return COMP_RANK_CODE_LABEL;
	}

	public void setCOMP_RANK_CODE_LABEL(HtmlOutputLabel comp_rank_code_label) {
		COMP_RANK_CODE_LABEL = comp_rank_code_label;
	}

	public HtmlInputText getCOMP_RANK_CODE() {
		return COMP_RANK_CODE;
	}

	public void setCOMP_RANK_CODE(HtmlInputText comp_rank_code) {
		COMP_RANK_CODE = comp_rank_code;
	}

	public HtmlInputText getCOMP_UI_M_AGENCY_CODE_DESC() {
		return COMP_UI_M_AGENCY_CODE_DESC;
	}

	public void setCOMP_UI_M_AGENCY_CODE_DESC(
			HtmlInputText comp_ui_m_agency_code_desc) {
		COMP_UI_M_AGENCY_CODE_DESC = comp_ui_m_agency_code_desc;
	}

	public HtmlInputText getCOMP_UI_M_RANK_CODE_DESC() {
		return COMP_UI_M_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_RANK_CODE_DESC(HtmlInputText comp_ui_m_rank_code_desc) {
		COMP_UI_M_RANK_CODE_DESC = comp_ui_m_rank_code_desc;
	}

	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}

	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER pm_customer_bean) {
		PM_CUSTOMER_BEAN = pm_customer_bean;
	}
	public String gotoSearchScreen(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public void onLoad(PhaseEvent event) {
		if(isBlockFlag()){
			PT047_A_DELEGATE delegate = new PT047_A_DELEGATE();
			PT_AGENT_AWARDS_ACTION pt_agent_awards_action=new PT_AGENT_AWARDS_ACTION();
			delegate.getAgentAwardHeaderDetails(PM_CUSTOMER_BEAN.getROWID(), PM_CUSTOMER_BEAN);
			List<PT_AGENT_AWARDS> list=delegate.getAgentAwardDtlBlockDetails(PM_CUSTOMER_BEAN);
			pt_agent_awards_action.setDataList(list);
			if(pt_agent_awards_action.getDataList()!=null){
				for(int i = 0;i<pt_agent_awards_action.getDataList().size();i++){
					PT_AGENT_AWARDS pt_agent_awards = pt_agent_awards_action.getDataList().get(i);
					if(i==0){
						pt_agent_awards.setRowSelected(true);
						pt_agent_awards_action.setPT_AGENT_AWARDS_BEAN(pt_agent_awards);
					}else{
						pt_agent_awards.setRowSelected(false);
					}
				}
			}
			setBlockFlag(false);
		}
	}
}

package com.iii.pel.forms.PT047_A;

import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.pel.forms.PT044_A.PT044_A_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_AWARD_SEARCH_ACTION extends CommonAction
{
	private String agentCode;
	private String agencyCode;
	private HtmlInputText agentCodeText;
	private HtmlInputText agencyCodeText;
	private UIData dataTable;
	private List<PM_CUSTOMER> dataList;
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public HtmlInputText getAgentCodeText() {
		return agentCodeText;
	}
	public void setAgentCodeText(HtmlInputText agentCodeText) {
		this.agentCodeText = agentCodeText;
	}
	public HtmlInputText getAgencyCodeText() {
		return agencyCodeText;
	}
	public void setAgencyCodeText(HtmlInputText agencyCodeText) {
		this.agencyCodeText = agencyCodeText;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public List<PM_CUSTOMER> getDataList() {
		return dataList;
	}
	public void setDataList(List<PM_CUSTOMER> dataList) {
		this.dataList = dataList;
	}
	public String fetchAgentDetails()
	{
		SearchActionDelegate searchDelegate=new SearchActionDelegate();
		PM_CUSTOMER pm_customer=new PM_CUSTOMER();
		pm_customer.setCUST_CODE(agentCode);
		pm_customer.setCUST_AGENCY_CODE(agencyCode);
		dataList=searchDelegate.fetchAgentCodeDetails(pm_customer);
		return "";
	}
	public String displayAgentAwardHeaderDetails()
	{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		String rowid=(String)request.getParameter("CURRENT_ROWID");
		PM_CUSTOMER_ACTION pm_customer_action=new PM_CUSTOMER_ACTION();
		HttpSession session=(HttpSession)context.getExternalContext().getSession(true);
		session.setAttribute("PT047_PT_AGENT_AWARD_HDR_ACTION",pm_customer_action);
		PM_CUSTOMER pm_customer=pm_customer_action.getPM_CUSTOMER_BEAN();
		new PT047_A_DELEGATE().getAgentAwardHeaderDetails(rowid, pm_customer);
		getAgentAwardDetailList(pm_customer);


		return "AgentAward_Header";
	}
	public void getAgentAwardDetailList(PM_CUSTOMER pm_customer)
	{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		PT_AGENT_AWARDS_ACTION pt_agent_awards_action=new PT_AGENT_AWARDS_ACTION();
		HttpSession session=(HttpSession)context.getExternalContext().getSession(true);
		session.setAttribute("PT047_PT_AGENT_AWARD_DTL_ACTION",pt_agent_awards_action);
		List<PT_AGENT_AWARDS> list=new PT047_A_DELEGATE().getAgentAwardDtlBlockDetails(pm_customer);
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
	}
	public String updateButtonAction(String rowId){
		PM_CUSTOMER_ACTION pm_customer_action = new PM_CUSTOMER_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PT047_PT_AGENT_AWARD_HDR_ACTION",pm_customer_action);
		pm_customer_action.getPM_CUSTOMER_BEAN().setROWID(rowId);
		outcome = "AgentAward_Header";
		return outcome;
	}
}

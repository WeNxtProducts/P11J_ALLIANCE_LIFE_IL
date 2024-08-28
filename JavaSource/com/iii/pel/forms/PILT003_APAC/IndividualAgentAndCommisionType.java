package com.iii.pel.forms.PILT003_APAC;

import java.util.ArrayList;

public class IndividualAgentAndCommisionType {

	private ArrayList<PT_AGENT_COMM_VALUES> agentList;
	
	private Double subTotalFC;
	
	private Double subTotalLC;
	
	private String commissionType;
	
	private String agentCode;
	
	private String totalLabel;

	public String getTotalLabel() {
		return totalLabel;
	}

	public void setTotalLabel(String totalLabel) {
		this.totalLabel = totalLabel;
	}

	public IndividualAgentAndCommisionType() {
		agentList = new ArrayList<PT_AGENT_COMM_VALUES>();
	}
	
	public ArrayList<PT_AGENT_COMM_VALUES> getAgentList() {
		return agentList;
	}

	public void setAgentList(ArrayList<PT_AGENT_COMM_VALUES> agentList) {
		this.agentList = agentList;
	}

	public Double getSubTotalFC() {
		return subTotalFC;
	}

	public void setSubTotalFC(Double subTotalFC) {
		this.subTotalFC = subTotalFC;
	}

	public Double getSubTotalLC() {
		return subTotalLC;
	}

	public void setSubTotalLC(Double subTotalLC) {
		this.subTotalLC = subTotalLC;
	}

	public String getCommissionType() {
		return commissionType;
	}

	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
}

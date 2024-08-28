package com.iii.pel.forms.PT044_A;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;




public class PT044_A_COMPOSITE_ACTION {

	public static final int TAB_AGENT_TRAN_HEADER = 1;
	public static final int TAB_AGENT_TRAN_DETAIL = 2;
	public static final int TAB_AGENT_POLICY_DETAIL = 3;
	public static final int TAB_AGENT_CHECK_LIST = 4;

	private PT_AGENT_TRAN_HDR_ACTION PT_AGENT_TRAN_HDR_ACTION_BEAN = null;
	private PT_AGENT_TRAN_DTLS_ACTION PT_AGENT_TRAN_DTLS_ACTION_BEAN = null;
	private PT_AGENT_POL_DTLS_ACTION PT_AGENT_POL_DTLS_ACTION_BEAN = null;
	private PT_AGENT_CHKLST_STATUS_ACTION PT_AGENT_CHKLST_STATUS_ACTION_BEAN = null;
	//private TabbedBar tabbedBar = null;
	private DUMMY DUMMY_BEAN = null;

	String agentHeader = null;
	String agentDetail = null;
	String agentPolicyDetail = null;
	String agentCheckList = null;

	boolean agentHeaderCheck;
	boolean agentDetailCheck;
	boolean agentPolicyDetailCheck;
	boolean agentCheckListCheck;

	private boolean disableOnApprovalFlag;
	private boolean renderPolDtlsFlag;
	private boolean renderChkListFlag;
	
	private UIWizard wizard=null;
	private UISummary comp=null;

	public PT044_A_COMPOSITE_ACTION() {
		PT_AGENT_TRAN_HDR_ACTION_BEAN = new PT_AGENT_TRAN_HDR_ACTION();
		PT_AGENT_TRAN_DTLS_ACTION_BEAN = new PT_AGENT_TRAN_DTLS_ACTION();
		PT_AGENT_POL_DTLS_ACTION_BEAN = new PT_AGENT_POL_DTLS_ACTION();
		PT_AGENT_CHKLST_STATUS_ACTION_BEAN = new PT_AGENT_CHKLST_STATUS_ACTION();
		PT_AGENT_TRAN_HDR_ACTION_BEAN.compositeAction = this;
		PT_AGENT_TRAN_DTLS_ACTION_BEAN.compositeAction = this;
		PT_AGENT_POL_DTLS_ACTION_BEAN.compositeAction = this;
		PT_AGENT_CHKLST_STATUS_ACTION_BEAN.compositeAction = this;
		DUMMY_BEAN = new DUMMY();
		//tabbedBar = new TabbedBar();
		//String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
	

		try {
			
			/*if ("A".equals(menuParam)) {
				tabbedBar.addTab(TAB_AGENT_TRAN_HEADER,
						"#{PT044_A_COMPOSITE_ACTION.goToMaster}",
						"Transfer of Agent", false);
				tabbedBar.addTab(TAB_AGENT_TRAN_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToAgentDetail}",
						"Agent Detail", false);
				tabbedBar.addTab(TAB_AGENT_POLICY_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToPolicyDetails}",
						"Policy Detail", false);
				tabbedBar.addTab(TAB_AGENT_CHECK_LIST,
						"#{PT044_A_COMPOSITE_ACTION.goToCheckListStatus}",
						"Checklist Status", false);
			} else if ("U".equals(menuParam)) {
				tabbedBar.addTab(TAB_AGENT_TRAN_HEADER,
						"#{PT044_A_COMPOSITE_ACTION.goToMaster}",
						"Unlicensed Agent", false);
				tabbedBar.addTab(TAB_AGENT_POLICY_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToPolicyDetails}",
						"Policy Detail", false);
				tabbedBar.addTab(TAB_AGENT_CHECK_LIST,
						"#{PT044_A_COMPOSITE_ACTION.goToCheckListStatus}",
						"Checklist Status", false);

			} else if ("T".equals(menuParam)) {
				tabbedBar
						.addTab(
								TAB_AGENT_TRAN_HEADER,
								"#{PT044_A_COMPOSITE_ACTION.goToMaster}",
								Messages
										.getString("messageProperties_PT044_A",
												"PT044_A$PT_AGENT_TRAN_HDR$MENU_PAARM_T$BLOCK_NAME"),
								false);
				tabbedBar
						.addTab(
								TAB_AGENT_TRAN_DETAIL,
								"#{PT044_A_COMPOSITE_ACTION.goToAgentDetail}",
								Messages
										.getString("messageProperties_PT044_A",
												"PT044_A$PT_AGENT_TRAN_DTL$MENU_PAARM_T$BLOCK_NAME"),
								false);
				tabbedBar.addTab(TAB_AGENT_POLICY_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToPolicyDetails}",
						Messages.getString("messageProperties_PT044_A",
								"PT044_A$PT_AGENT_POL_DTLS$BLOCK_NAME"), false);
				tabbedBar.addTab(TAB_AGENT_CHECK_LIST,
						"#{PT044_A_COMPOSITE_ACTION.goToCheckListStatus}",
						Messages.getString("messageProperties_PT044_A",
								"PT044_A$PT_AGENT_CHKLST_STATUS$BLOCK_NAME"),
						false);
			} else if ("M".equals(menuParam)) {
				tabbedBar.addTab(TAB_AGENT_TRAN_HEADER,
						"#{PT044_A_COMPOSITE_ACTION.goToMaster}",
						"Movement of Agent", false);
				tabbedBar.addTab(TAB_AGENT_TRAN_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToAgentDetail}",
						"Agent Detail", false);
				tabbedBar.addTab(TAB_AGENT_POLICY_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToPolicyDetails}",
						"Policy Detail", false);
				tabbedBar.addTab(TAB_AGENT_CHECK_LIST,
						"#{PT044_A_COMPOSITE_ACTION.goToCheckListStatus}",
						"Checklist Status", false);
			} else if ("R".equals(menuParam)) {
				tabbedBar.addTab(TAB_AGENT_TRAN_HEADER,
						"#{PT044_A_COMPOSITE_ACTION.goToMaster}",
						"Teriminated Agent Policies", false);
				tabbedBar.addTab(TAB_AGENT_POLICY_DETAIL,
						"#{PT044_A_COMPOSITE_ACTION.goToPolicyDetails}",
						"Policy Detail", false);
				tabbedBar.addTab(TAB_AGENT_CHECK_LIST,
						"#{PT044_A_COMPOSITE_ACTION.goToCheckListStatus}",
						"Checklist Status", false);
			}*/
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public PT_AGENT_TRAN_DTLS_ACTION getPT_AGENT_TRAN_DTLS_ACTION_BEAN() {
		return PT_AGENT_TRAN_DTLS_ACTION_BEAN;
	}

	public void setPT_AGENT_TRAN_DTLS_ACTION_BEAN(
			PT_AGENT_TRAN_DTLS_ACTION pt_agent_tran_dtls_action_bean) {
		PT_AGENT_TRAN_DTLS_ACTION_BEAN = pt_agent_tran_dtls_action_bean;
	}

	public PT_AGENT_TRAN_HDR_ACTION getPT_AGENT_TRAN_HDR_ACTION_BEAN() {
		return this.PT_AGENT_TRAN_HDR_ACTION_BEAN;
	}

	public void setPT_AGENT_TRAN_HDR_ACTION_BEAN(
			PT_AGENT_TRAN_HDR_ACTION pt_agent_tran_hdr_action_bean) {
		this.PT_AGENT_TRAN_HDR_ACTION_BEAN = pt_agent_tran_hdr_action_bean;
	}

	public PT_AGENT_POL_DTLS_ACTION getPT_AGENT_POL_DTLS_ACTION_BEAN() {
		return PT_AGENT_POL_DTLS_ACTION_BEAN;
	}

	public void setPT_AGENT_POL_DTLS_ACTION_BEAN(
			PT_AGENT_POL_DTLS_ACTION pt_agent_pol_dtls_action_bean) {
		PT_AGENT_POL_DTLS_ACTION_BEAN = pt_agent_pol_dtls_action_bean;
	}

	public PT_AGENT_CHKLST_STATUS_ACTION getPT_AGENT_CHKLST_STATUS_ACTION_BEAN() {
		return PT_AGENT_CHKLST_STATUS_ACTION_BEAN;
	}

	public void setPT_AGENT_CHKLST_STATUS_ACTION_BEAN(
			PT_AGENT_CHKLST_STATUS_ACTION pt_agent_chklst_status_action_bean) {
		PT_AGENT_CHKLST_STATUS_ACTION_BEAN = pt_agent_chklst_status_action_bean;
	}

	public String goToMaster() {
		String masterPage = "gotoMainPage";
		System.out.println("disableOnApprovalFlagdisableOnApprovalFlag--"
				+ this.isDisableOnApprovalFlag() + "----");
		return masterPage;
	}

	public String goToAgentDetail() {

		String agentDetail = "gotoDetailPage";
		ArrayList<PT_AGENT_TRAN_DTLS> detailList = null;
		String rowId = null;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		rowId = this.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getROWID();
		detailList = delegate.loadAgentDetailRecord(rowId);
		this.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setList(detailList);
		PT_AGENT_TRAN_DTLS PT_AGENT_TRAN_DTLS_BEAN = null;
		Iterator<PT_AGENT_TRAN_DTLS> listIterator = detailList.iterator();
		while (listIterator.hasNext()) {
			PT_AGENT_TRAN_DTLS_BEAN = listIterator.next();
			PT_AGENT_TRAN_DTLS_BEAN.setRowSelected(false);
		}
		if (detailList.size() > 0) {
			this.getPT_AGENT_TRAN_DTLS_ACTION_BEAN()
					.setPT_AGENT_TRAN_DTLS_BEAN(detailList.get(0));
			this.getPT_AGENT_TRAN_DTLS_ACTION_BEAN()
					.getPT_AGENT_TRAN_DTLS_BEAN().setRowSelected(true);
		}
		return agentDetail;
	}

	public String goToPolicyDetails() {
		String policyDetails = "gotoPolicyPage";
		
		/*setDisableOnApprovalFlag(true);*/
		ArrayList<PT_AGENT_POL_DTLS> detailList = null;
		String rowId = null;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		rowId = this.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getROWID();
		detailList = delegate.loadPolicyDetail(rowId);
		this.getPT_AGENT_POL_DTLS_ACTION_BEAN().setList(detailList);

		PT_AGENT_POL_DTLS PT_AGENT_POL_DTLS_BEAN = null;
		Iterator<PT_AGENT_POL_DTLS> listIteratorpol = detailList.iterator();
		while (listIteratorpol.hasNext()) {
			PT_AGENT_POL_DTLS_BEAN = listIteratorpol.next();
			PT_AGENT_POL_DTLS_BEAN.setRowSelected(false);
		}
		if (detailList.size() > 0) {
			setRenderPolDtlsFlag(true);
			this.getPT_AGENT_POL_DTLS_ACTION_BEAN().setPT_AGENT_POL_DTLS_BEAN(
					detailList.get(0));
			this.getPT_AGENT_POL_DTLS_ACTION_BEAN().getPT_AGENT_POL_DTLS_BEAN()
					.setRowSelected(true);
		} else
			setRenderPolDtlsFlag(false);

		return policyDetails;
	}

	public String goToCheckListStatus() {

		String checkListDetail = "gotoCheckListPage";
		ArrayList<PT_AGENT_CHKLST_STATUS> detailList = null;
		String rowId = null;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		rowId = this.getPT_AGENT_TRAN_HDR_ACTION_BEAN()
				.getPT_AGENT_TRAN_HDR_BEAN().getROWID();
		detailList = delegate.loadCheckListDetail(rowId);
		this.getPT_AGENT_CHKLST_STATUS_ACTION_BEAN().setList(detailList);
		PT_AGENT_CHKLST_STATUS PT_AGENT_CHKLST_STATUS_BEAN = null;
		Iterator<PT_AGENT_CHKLST_STATUS> listIteratorchk = detailList
				.iterator();
		while (listIteratorchk.hasNext()) {
			PT_AGENT_CHKLST_STATUS_BEAN = listIteratorchk.next();
			PT_AGENT_CHKLST_STATUS_BEAN.setRowSelected(false);
		}
		if (detailList.size() > 0) {
			setRenderChkListFlag(true);
			this.getPT_AGENT_CHKLST_STATUS_ACTION_BEAN()
					.setPT_AGENT_CHKLST_STATUS_BEAN(detailList.get(0));
			this.getPT_AGENT_CHKLST_STATUS_ACTION_BEAN()
					.getPT_AGENT_CHKLST_STATUS_BEAN().setRowSelected(true);
		} else
			setRenderChkListFlag(false);
		return checkListDetail;
	}

	/*public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}*/

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public boolean isDisableOnApprovalFlag() {
		return disableOnApprovalFlag;
	}

	public void setDisableOnApprovalFlag(boolean disableOnApprovalFlag) {
		this.disableOnApprovalFlag = disableOnApprovalFlag;
	}

	public boolean isRenderPolDtlsFlag() {
		return renderPolDtlsFlag;
	}

	public void setRenderPolDtlsFlag(boolean renderPolDtlsFlag) {
		this.renderPolDtlsFlag = renderPolDtlsFlag;
	}

	public boolean isRenderChkListFlag() {
		return renderChkListFlag;
	}

	public void setRenderChkListFlag(boolean renderChkListFlag) {
		this.renderChkListFlag = renderChkListFlag;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public UISummary getComp() {
		return comp;
	}

	public void setComp(UISummary comp) {
		this.comp = comp;
	}

}

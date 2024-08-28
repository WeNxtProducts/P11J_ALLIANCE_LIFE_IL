package com.iii.pel.forms.PILP023;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_TXN_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

	private HtmlInputText COMP_PD_FC_AMT;

	private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;

	private HtmlInputText COMP_PD_LC_AMT;

	private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

	private HtmlInputText COMP_PD_BRANCH_NAME;

	private HtmlOutputLabel COMP_PD_CHQ_NO_LABEL;

	private HtmlInputText COMP_PD_CHQ_NO;

	private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlOutputLabel COMP_PD_ADDR_01_LABEL;

	private HtmlInputText COMP_PD_ADDR_01;

	private HtmlOutputLabel COMP_PD_ADDR_02_LABEL;

	private HtmlInputText COMP_PD_ADDR_02;

	private HtmlOutputLabel COMP_PD_ADDR_03_LABEL;

	private HtmlInputText COMP_PD_ADDR_03;

	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;
	
	private List<PT_IL_PYMT_DTLS> pymtList;
	
	private UIData dataGrid;
	
	private HtmlCommandButton COMP_UI_M_FETCH_DATA_BUTTON;
	
	private HtmlCommandButton COMP_UI_M_ADDROW_BUTTON;
	
	public PILP023_COMPOSITE_ACTION compositeAction;
	
	private PT_IL_PYMT_DTLS_HELPER helper;

	public HtmlCommandButton getCOMP_UI_M_ADDROW_BUTTON() {
		return COMP_UI_M_ADDROW_BUTTON;
	}

	public void setCOMP_UI_M_ADDROW_BUTTON(HtmlCommandButton comp_ui_m_addrow_button) {
		COMP_UI_M_ADDROW_BUTTON = comp_ui_m_addrow_button;
	}

	public HtmlCommandButton getCOMP_UI_M_FETCH_DATA_BUTTON() {
		return COMP_UI_M_FETCH_DATA_BUTTON;
	}

	public void setCOMP_UI_M_FETCH_DATA_BUTTON(
			HtmlCommandButton comp_ui_m_fetch_data_button) {
		COMP_UI_M_FETCH_DATA_BUTTON = comp_ui_m_fetch_data_button;
	}

	public UIData getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIData dataGrid) {
		this.dataGrid = dataGrid;
	}

	public PT_IL_PYMT_DTLS_ACTION() {
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
		pymtList = new ArrayList<PT_IL_PYMT_DTLS>();
		helper = new PT_IL_PYMT_DTLS_HELPER();
		instantiateAllComponent();
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_PYMT_DTLS> PT_GL_POL_EMP_COVER_ITR = pymtList
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN());
				helper.executeQuery(compositeAction);
				if(pymtList!=null && !pymtList.isEmpty()){
					PT_IL_PYMT_DTLS pt_il_pymt_dtls = pymtList.get(0);
					pt_il_pymt_dtls.setRowSelected(true);
					setPT_IL_PYMT_DTLS_BEAN(pt_il_pymt_dtls);
				}
			}	
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_TXN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_TXN_TYPE_DESC() {
		return COMP_UI_M_PD_TXN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PD_TXN_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_TXN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_PD_TXN_TYPE_DESC_LABEL = COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_TXN_TYPE_DESC(HtmlInputText COMP_UI_M_PD_TXN_TYPE_DESC) {
		this.COMP_UI_M_PD_TXN_TYPE_DESC = COMP_UI_M_PD_TXN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
		return COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC(HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC) {
		this.COMP_UI_M_PD_CURR_CODE_DESC = COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
		return COMP_PD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_AMT() {
		return COMP_PD_FC_AMT;
	}

	public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
		this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
	}

	public void setCOMP_PD_FC_AMT(HtmlInputText COMP_PD_FC_AMT) {
		this.COMP_PD_FC_AMT = COMP_PD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
		return COMP_PD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_AMT() {
		return COMP_PD_LC_AMT;
	}

	public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
		this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
	}

	public void setCOMP_PD_LC_AMT(HtmlInputText COMP_PD_LC_AMT) {
		this.COMP_PD_LC_AMT = COMP_PD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
		return COMP_PD_BRANCH_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BRANCH_NAME() {
		return COMP_PD_BRANCH_NAME;
	}

	public void setCOMP_PD_BRANCH_NAME_LABEL(HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
		this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
	}

	public void setCOMP_PD_BRANCH_NAME(HtmlInputText COMP_PD_BRANCH_NAME) {
		this.COMP_PD_BRANCH_NAME = COMP_PD_BRANCH_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_NO_LABEL() {
		return COMP_PD_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CHQ_NO() {
		return COMP_PD_CHQ_NO;
	}

	public void setCOMP_PD_CHQ_NO_LABEL(HtmlOutputLabel COMP_PD_CHQ_NO_LABEL) {
		this.COMP_PD_CHQ_NO_LABEL = COMP_PD_CHQ_NO_LABEL;
	}

	public void setCOMP_PD_CHQ_NO(HtmlInputText COMP_PD_CHQ_NO) {
		this.COMP_PD_CHQ_NO = COMP_PD_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
		return COMP_PD_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_CUST_NAME() {
		return COMP_PD_CUST_NAME;
	}

	public void setCOMP_PD_CUST_NAME_LABEL(HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
		this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
	}

	public void setCOMP_PD_CUST_NAME(HtmlInputText COMP_PD_CUST_NAME) {
		this.COMP_PD_CUST_NAME = COMP_PD_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
		return COMP_PD_ADDR_01_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_01() {
		return COMP_PD_ADDR_01;
	}

	public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
		this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
	}

	public void setCOMP_PD_ADDR_01(HtmlInputText COMP_PD_ADDR_01) {
		this.COMP_PD_ADDR_01 = COMP_PD_ADDR_01;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
		return COMP_PD_ADDR_02_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_02() {
		return COMP_PD_ADDR_02;
	}

	public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
		this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
	}

	public void setCOMP_PD_ADDR_02(HtmlInputText COMP_PD_ADDR_02) {
		this.COMP_PD_ADDR_02 = COMP_PD_ADDR_02;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
		return COMP_PD_ADDR_03_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_03() {
		return COMP_PD_ADDR_03;
	}

	public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
		this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
	}

	public void setCOMP_PD_ADDR_03(HtmlInputText COMP_PD_ADDR_03) {
		this.COMP_PD_ADDR_03 = COMP_PD_ADDR_03;
	}

	public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
		return PT_IL_PYMT_DTLS_BEAN;
	}

	public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
	}

	public List<PT_IL_PYMT_DTLS> getPymtList() {
		return pymtList;
	}

	public void setPymtList(List<PT_IL_PYMT_DTLS> pymtList) {
		this.pymtList = pymtList;
	}
	
	public void addRow(ActionEvent event)
	{
		if(pymtList != null){
		System.out.println("ADD ROW EXECUTED");
		pymtList.add(new PT_IL_PYMT_DTLS());
		}
		else
		{
			pymtList = new ArrayList<PT_IL_PYMT_DTLS>();
			pymtList.add(new PT_IL_PYMT_DTLS());
		}
	}
	public String pymtQueryAction()
	{
		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		helper.chequeBounceHeader();
		//helper.pymtSelectQuery();
		return "pymtDetails";
	}
	public String fetchList(){
		if(pymtList!=null){
			List<Integer> rowIndex = new ArrayList<Integer>();
			for(int i=0;i<pymtList.size();i++){
				PT_IL_PYMT_DTLS pymtBean = pymtList.get(i);
				if(pymtBean.isSelected()){
					rowIndex.add(i);
				}
			}
			System.out.println("Row Index: "+rowIndex);
			if(rowIndex.size()!=1){
				getErrorMap().put("current", "Only one record can be fetched");
				getErrorMap().put(getDataGrid().getId(), "Only one record can be fetched");
			}else{
				getErrorMap().remove("current");
				getErrorMap().remove(getDataGrid().getId());
				int rowNum = rowIndex.get(0);
				PT_IL_PYMT_DTLS pymtBean = pymtList.get(rowNum);
				//String sysID = pymtBean.getPD_SYS_ID();
				//System.out.println("PT_IL_PYMT_DTLS_HELPER_SYSID:: "+sysID);
				//new PT_IL_PYMT_DTLS_HELPER().executeQuery(sysID);
				return "payList";
			}
		}
		return null;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_PYMT_DTLS_BEAN = (PT_IL_PYMT_DTLS) dataGrid
					.getRowData();
			PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	public void clearDetails()
	{
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION 
				hdrAction = ((PILP023_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession
							("PILP023_COMPOSITE_ACTION")).getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
//		PT_IL_CHEQUE_BOUNCE_HDR hdrBean = hdrAction.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		
		PT_IL_PYMT_DTLS_ACTION 
				pymtAction = ((PILP023_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession
							("PILP023_COMPOSITE_ACTION")).getPILP023_PT_IL_PYMT_DTLS_ACTION();
		hdrAction.getCOMP_UI_M_DEP_TXN_CODE().setSubmittedValue("");
		hdrAction.getCOMP_UI_M_DEP_DOC_NO().setSubmittedValue("");
		hdrAction.getCOMP_UI_M_DEP_DOC_DT().setValue("");
		hdrAction.getCOMP_UI_M_CBH_REASON_CODE().setSubmittedValue("");
		hdrAction.getCOMP_UI_M_REASON_CODE_DESC().setSubmittedValue("");
		hdrAction.getCOMP_UI_M_CBH_REVERSAL_REF_NO().setSubmittedValue("");
		hdrAction.getCOMP_UI_M_CBH_REMARKS().setSubmittedValue("");
		pymtAction.getPymtList().clear();
	}
	

	/**
	 * Resets all components in PT_IL_PYMT_DTLS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_PD_TXN_TYPE_DESC.resetValue();
		COMP_UI_M_PD_CURR_CODE_DESC.resetValue();
		COMP_PD_FC_AMT.resetValue();
		COMP_PD_LC_AMT.resetValue();
		COMP_PD_BRANCH_NAME.resetValue();
		COMP_PD_CHQ_NO.resetValue();
		COMP_PD_CUST_NAME.resetValue();
		COMP_PD_ADDR_01.resetValue();
		COMP_PD_ADDR_02.resetValue();
		COMP_PD_ADDR_03.resetValue();

		// Reseting HtmlCommandButton
		/*COMP_UI_M_FETCH_DATA_BUTTON.resetValue();
		COMP_UI_M_ADDROW_BUTTON.resetValue();*/

	}


	
	/**
	 * Instantiates all components in PT_IL_PYMT_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_PD_TXN_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_PD_CURR_CODE_DESC			 = new HtmlInputText();
		COMP_PD_FC_AMT					 = new HtmlInputText();
		COMP_PD_LC_AMT					 = new HtmlInputText();
		COMP_PD_BRANCH_NAME				 = new HtmlInputText();
		COMP_PD_CHQ_NO					 = new HtmlInputText();
		COMP_PD_CUST_NAME				 = new HtmlInputText();
		COMP_PD_ADDR_01					 = new HtmlInputText();
		COMP_PD_ADDR_02					 = new HtmlInputText();
		COMP_PD_ADDR_03					 = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_FETCH_DATA_BUTTON			 = new HtmlCommandButton();
		COMP_UI_M_ADDROW_BUTTON				 = new HtmlCommandButton();

	}


}

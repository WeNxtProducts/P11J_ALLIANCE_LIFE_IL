package com.iii.pel.forms.PILP023;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DEPOSIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_DPD_REF_ID_LABEL;

	private HtmlInputText COMP_UI_M_DPD_REF_ID;

	private HtmlOutputLabel COMP_UI_M_DEP_FC_DEP_AMT_LABEL;

	private HtmlInputText COMP_UI_M_DEP_FC_DEP_AMT;

	private HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_DEP_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;

	private PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN;
	
	private ArrayList<PT_IL_DEPOSIT> tableList;
	
	public PILP023_COMPOSITE_ACTION compositeAction;
	
	private UIData dataTable;

	public ArrayList<PT_IL_DEPOSIT> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<PT_IL_DEPOSIT> tableList) {
		this.tableList = tableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_IL_DEPOSIT_ACTION() {
		PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_DPD_REF_ID_LABEL() {
		return COMP_UI_M_DPD_REF_ID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DPD_REF_ID() {
		return COMP_UI_M_DPD_REF_ID;
	}

	public void setCOMP_UI_M_DPD_REF_ID_LABEL(HtmlOutputLabel COMP_UI_M_DPD_REF_ID_LABEL) {
		this.COMP_UI_M_DPD_REF_ID_LABEL = COMP_UI_M_DPD_REF_ID_LABEL;
	}

	public void setCOMP_UI_M_DPD_REF_ID(HtmlInputText COMP_UI_M_DPD_REF_ID) {
		this.COMP_UI_M_DPD_REF_ID = COMP_UI_M_DPD_REF_ID;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FC_DEP_AMT_LABEL() {
		return COMP_UI_M_DEP_FC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_FC_DEP_AMT() {
		return COMP_UI_M_DEP_FC_DEP_AMT;
	}

	public void setCOMP_UI_M_DEP_FC_DEP_AMT_LABEL(HtmlOutputLabel COMP_UI_M_DEP_FC_DEP_AMT_LABEL) {
		this.COMP_UI_M_DEP_FC_DEP_AMT_LABEL = COMP_UI_M_DEP_FC_DEP_AMT_LABEL;
	}

	public void setCOMP_UI_M_DEP_FC_DEP_AMT(HtmlInputText COMP_UI_M_DEP_FC_DEP_AMT) {
		this.COMP_UI_M_DEP_FC_DEP_AMT = COMP_UI_M_DEP_FC_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_DEP_AMT_LABEL() {
		return COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_DEP_AMT() {
		return COMP_DEP_LC_DEP_AMT;
	}

	public void setCOMP_DEP_LC_DEP_AMT_LABEL(HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL) {
		this.COMP_DEP_LC_DEP_AMT_LABEL = COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_DEP_AMT(HtmlInputText COMP_DEP_LC_DEP_AMT) {
		this.COMP_DEP_LC_DEP_AMT = COMP_DEP_LC_DEP_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEP_REFUND_DTLS_BACK() {
		return COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_DEP_REFUND_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK) {
		this.COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK = COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;
	}

	public PT_IL_DEPOSIT getPT_IL_DEPOSIT_BEAN() {
		return PT_IL_DEPOSIT_BEAN;
	}

	public void setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		this.PT_IL_DEPOSIT_BEAN = PT_IL_DEPOSIT_BEAN;
	}
	/**
	 * 
	 */
	public void depositDtls()
	{
		try{
			//PT_IL_CHEQUE_BOUNCE_HDR chequeHdr = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
			tableList = new PT_IL_DEPOSIT_HELPER().deposit_query(compositeAction);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	public String depositToHdr()
	{
		setTableList(null);
		return "receiptBounce";
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_DEPOSIT_BEAN = (PT_IL_DEPOSIT) dataTable
					.getRowData();
			PT_IL_DEPOSIT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_DEPOSIT> PT_GL_POL_EMP_COVER_ITR = tableList
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
	}
	

	/**
	 * Instantiates all components in PT_IL_DEPOSIT_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_DPD_REF_ID				 = new HtmlInputText();
		COMP_UI_M_DEP_FC_DEP_AMT			 = new HtmlInputText();
		COMP_DEP_LC_DEP_AMT				 = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK		 = new HtmlCommandButton();

	}


	/**
	 * Resets all components in PT_IL_DEPOSIT_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_DPD_REF_ID.resetValue();
		COMP_UI_M_DEP_FC_DEP_AMT.resetValue();
		COMP_DEP_LC_DEP_AMT.resetValue();

		// Reseting HtmlCommandButton
//		COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK.resetValue();

	}


}


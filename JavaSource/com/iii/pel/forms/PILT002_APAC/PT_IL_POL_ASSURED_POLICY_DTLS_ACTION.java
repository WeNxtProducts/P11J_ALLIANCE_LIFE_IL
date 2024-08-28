package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSURED_POLICY_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_NO_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_NO;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_PEROID_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_PEROID;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_ST_DATE_LABEL;
	private HtmlCalendar COMP_ASSR_DTLS_POL_ST_DATE;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_EX_DATE_LABEL;
	private HtmlCalendar COMP_ASSR_DTLS_POL_EX_DATE;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_FC_SA_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_FC_SA;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_LC_SA_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_LC_SA;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_FC_PREM_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_FC_PREM;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_LC_PREM_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_LC_PREM;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_STATUS_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_STATUS;

	private HtmlOutputLabel COMP_ASSR_DTLS_POL_MOP_LABEL;
	private HtmlInputText COMP_ASSR_DTLS_POL_MOP;
	/*added by gopi for for ZBILQC_12-JAN-2017_Issue_Flow on 17/01/17*/
	
	private HtmlInputText COMP_ASSR_DTLS_POL_MOP_DESC;
	
	public HtmlInputText getCOMP_ASSR_DTLS_POL_MOP_DESC() {
		return COMP_ASSR_DTLS_POL_MOP_DESC;
	}

	public void setCOMP_ASSR_DTLS_POL_MOP_DESC(
			HtmlInputText cOMP_ASSR_DTLS_POL_MOP_DESC) {
		COMP_ASSR_DTLS_POL_MOP_DESC = cOMP_ASSR_DTLS_POL_MOP_DESC;
	}
	
	private HtmlInputText COMP_ASSR_DTLS_POL_STATUS_DESC;
	
	
	public HtmlInputText getCOMP_ASSR_DTLS_POL_STATUS_DESC() {
		return COMP_ASSR_DTLS_POL_STATUS_DESC;
	}

	public void setCOMP_ASSR_DTLS_POL_STATUS_DESC(
			HtmlInputText cOMP_ASSR_DTLS_POL_STATUS_DESC) {
		COMP_ASSR_DTLS_POL_STATUS_DESC = cOMP_ASSR_DTLS_POL_STATUS_DESC;
	}

	/*end*/
	private HtmlAjaxCommandButton COMP_UI_M_BTN_MAIN;
	
	private UIData dataTable;
	
	PT_IL_POL_ASSURED_POLICY_DTLS_HELPER helper;
	
	PILT002_APAC_COMPOSITE_ACTION compositeAction;
	
	private List<PT_IL_POL_ASSURED_POLICY_DTLS> dataList_PT_IL_POL_ASSURED_POLICY_DTLS = new ArrayList<PT_IL_POL_ASSURED_POLICY_DTLS>();

	private PT_IL_POL_ASSURED_POLICY_DTLS PT_IL_POL_ASSURED_POLICY_DTLS_BEAN;

	public UIData getDataTable() {
		return dataTable;
	}

	public PT_IL_POL_ASSURED_POLICY_DTLS_ACTION() {

		PT_IL_POL_ASSURED_POLICY_DTLS_BEAN = new PT_IL_POL_ASSURED_POLICY_DTLS();
		helper = new PT_IL_POL_ASSURED_POLICY_DTLS_HELPER();
		instantiateAllComponent();
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				disableAllComponent(true);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_ASSURED_POLICY_DTLS_BEAN = (PT_IL_POL_ASSURED_POLICY_DTLS) dataTable.getRowData();
			PT_IL_POL_ASSURED_POLICY_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	public String back(){
		String outcome = null;
		
		outcome = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS";
		return outcome;
	}
	
	public void resetSelectedRow() {
		Iterator<PT_IL_POL_ASSURED_POLICY_DTLS> PT_IL_POL_ASSURED_POLICY_DTLS_ITR = dataList_PT_IL_POL_ASSURED_POLICY_DTLS
				.iterator();
		while (PT_IL_POL_ASSURED_POLICY_DTLS_ITR.hasNext()) {
			PT_IL_POL_ASSURED_POLICY_DTLS_ITR.next().setRowSelected(false);
		}
	}
	
	public void instantiateAllComponent(){
			COMP_ASSR_DTLS_POL_NO = new HtmlInputText();
			COMP_ASSR_DTLS_POL_PEROID=new HtmlInputText();
			COMP_ASSR_DTLS_POL_FC_SA= new HtmlInputText();
			COMP_ASSR_DTLS_POL_LC_SA= new HtmlInputText();
			COMP_ASSR_DTLS_POL_FC_PREM= new HtmlInputText();
			COMP_ASSR_DTLS_POL_LC_PREM= new HtmlInputText();
			COMP_ASSR_DTLS_POL_STATUS= new HtmlInputText();
			COMP_ASSR_DTLS_POL_MOP= new HtmlInputText();
			COMP_ASSR_DTLS_POL_ST_DATE=new 	HtmlCalendar();
			COMP_ASSR_DTLS_POL_EX_DATE=new 	HtmlCalendar();
			COMP_UI_M_BTN_MAIN =new HtmlAjaxCommandButton();
			/*added by gopi for for ZBILQC_12-JAN-2017_Issue_Flow on 17/01/17*/
			COMP_ASSR_DTLS_POL_MOP_DESC =new HtmlInputText();
			COMP_ASSR_DTLS_POL_STATUS_DESC = new HtmlInputText();
			//end
		
	}
 
	public void resetAllComponent(){
		COMP_ASSR_DTLS_POL_STATUS.resetValue();
		COMP_ASSR_DTLS_POL_FC_PREM.resetValue();
		COMP_ASSR_DTLS_POL_LC_SA.resetValue();
		COMP_ASSR_DTLS_POL_FC_SA.resetValue();
		COMP_ASSR_DTLS_POL_EX_DATE.resetValue();
		COMP_ASSR_DTLS_POL_NO.resetValue();
		COMP_ASSR_DTLS_POL_PEROID.resetValue();
		COMP_ASSR_DTLS_POL_LC_PREM.resetValue();
		COMP_ASSR_DTLS_POL_ST_DATE.resetValue();
		COMP_ASSR_DTLS_POL_MOP.resetValue();
		/*added by gopi for for ZBILQC_12-JAN-2017_Issue_Flow on 17/01/17*/
		COMP_ASSR_DTLS_POL_MOP_DESC.resetValue();
		COMP_ASSR_DTLS_POL_STATUS_DESC.resetValue();
		//end
	}
	
	public void disableAllComponent(boolean disabled){
		COMP_ASSR_DTLS_POL_NO.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_EX_DATE.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_PEROID.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_FC_SA.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_LC_SA.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_FC_PREM.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_ST_DATE.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_LC_PREM.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_STATUS.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_ST_DATE.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_MOP.setDisabled(disabled);
		/*added by gopi for for ZBILQC_12-JAN-2017_Issue_Flow on 17/01/17*/
		COMP_ASSR_DTLS_POL_MOP_DESC.setDisabled(disabled);
		COMP_ASSR_DTLS_POL_STATUS_DESC.setDisabled(disabled);
		//end
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_NO() {
		return COMP_ASSR_DTLS_POL_NO;
	}

	public void setCOMP_ASSR_DTLS_POL_NO(HtmlInputText comp_assr_dtls_pol_no) {
		COMP_ASSR_DTLS_POL_NO = comp_assr_dtls_pol_no;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_PEROID() {
		return COMP_ASSR_DTLS_POL_PEROID;
	}

	public void setCOMP_ASSR_DTLS_POL_PEROID(
			HtmlInputText comp_assr_dtls_pol_peroid) {
		COMP_ASSR_DTLS_POL_PEROID = comp_assr_dtls_pol_peroid;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_FC_SA() {
		return COMP_ASSR_DTLS_POL_FC_SA;
	}

	public void setCOMP_ASSR_DTLS_POL_FC_SA(
			HtmlInputText comp_assr_dtls_pol_fc_sa) {
		COMP_ASSR_DTLS_POL_FC_SA = comp_assr_dtls_pol_fc_sa;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_LC_SA() {
		return COMP_ASSR_DTLS_POL_LC_SA;
	}

	public void setCOMP_ASSR_DTLS_POL_LC_SA(
			HtmlInputText comp_assr_dtls_pol_lc_sa) {
		COMP_ASSR_DTLS_POL_LC_SA = comp_assr_dtls_pol_lc_sa;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_FC_PREM() {
		return COMP_ASSR_DTLS_POL_FC_PREM;
	}

	public void setCOMP_ASSR_DTLS_POL_FC_PREM(
			HtmlInputText comp_assr_dtls_pol_fc_prem) {
		COMP_ASSR_DTLS_POL_FC_PREM = comp_assr_dtls_pol_fc_prem;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_LC_PREM() {
		return COMP_ASSR_DTLS_POL_LC_PREM;
	}

	public void setCOMP_ASSR_DTLS_POL_LC_PREM(
			HtmlInputText comp_assr_dtls_pol_lc_prem) {
		COMP_ASSR_DTLS_POL_LC_PREM = comp_assr_dtls_pol_lc_prem;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_STATUS() {
		return COMP_ASSR_DTLS_POL_STATUS;
	}

	public void setCOMP_ASSR_DTLS_POL_STATUS(
			HtmlInputText comp_assr_dtls_pol_status) {
		COMP_ASSR_DTLS_POL_STATUS = comp_assr_dtls_pol_status;
	}

	public HtmlInputText getCOMP_ASSR_DTLS_POL_MOP() {
		return COMP_ASSR_DTLS_POL_MOP;
	}

	public void setCOMP_ASSR_DTLS_POL_MOP(HtmlInputText comp_assr_dtls_pol_mop) {
		COMP_ASSR_DTLS_POL_MOP = comp_assr_dtls_pol_mop;
	}

	public HtmlCalendar getCOMP_ASSR_DTLS_POL_ST_DATE() {
		return COMP_ASSR_DTLS_POL_ST_DATE;
	}

	public void setCOMP_ASSR_DTLS_POL_ST_DATE(
			HtmlCalendar comp_assr_dtls_pol_st_date) {
		COMP_ASSR_DTLS_POL_ST_DATE = comp_assr_dtls_pol_st_date;
	}

	public HtmlCalendar getCOMP_ASSR_DTLS_POL_EX_DATE() {
		return COMP_ASSR_DTLS_POL_EX_DATE;
	}

	public void setCOMP_ASSR_DTLS_POL_EX_DATE(
			HtmlCalendar comp_assr_dtls_pol_ex_date) {
		COMP_ASSR_DTLS_POL_EX_DATE = comp_assr_dtls_pol_ex_date;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_NO_LABEL() {
		return COMP_ASSR_DTLS_POL_NO_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_NO_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_no_label) {
		COMP_ASSR_DTLS_POL_NO_LABEL = comp_assr_dtls_pol_no_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_PEROID_LABEL() {
		return COMP_ASSR_DTLS_POL_PEROID_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_PEROID_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_peroid_label) {
		COMP_ASSR_DTLS_POL_PEROID_LABEL = comp_assr_dtls_pol_peroid_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_ST_DATE_LABEL() {
		return COMP_ASSR_DTLS_POL_ST_DATE_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_ST_DATE_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_st_date_label) {
		COMP_ASSR_DTLS_POL_ST_DATE_LABEL = comp_assr_dtls_pol_st_date_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_EX_DATE_LABEL() {
		return COMP_ASSR_DTLS_POL_EX_DATE_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_EX_DATE_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_ex_date_label) {
		COMP_ASSR_DTLS_POL_EX_DATE_LABEL = comp_assr_dtls_pol_ex_date_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_FC_SA_LABEL() {
		return COMP_ASSR_DTLS_POL_FC_SA_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_FC_SA_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_fc_sa_label) {
		COMP_ASSR_DTLS_POL_FC_SA_LABEL = comp_assr_dtls_pol_fc_sa_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_LC_SA_LABEL() {
		return COMP_ASSR_DTLS_POL_LC_SA_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_LC_SA_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_lc_sa_label) {
		COMP_ASSR_DTLS_POL_LC_SA_LABEL = comp_assr_dtls_pol_lc_sa_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_FC_PREM_LABEL() {
		return COMP_ASSR_DTLS_POL_FC_PREM_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_FC_PREM_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_fc_prem_label) {
		COMP_ASSR_DTLS_POL_FC_PREM_LABEL = comp_assr_dtls_pol_fc_prem_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_LC_PREM_LABEL() {
		return COMP_ASSR_DTLS_POL_LC_PREM_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_LC_PREM_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_lc_prem_label) {
		COMP_ASSR_DTLS_POL_LC_PREM_LABEL = comp_assr_dtls_pol_lc_prem_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_STATUS_LABEL() {
		return COMP_ASSR_DTLS_POL_STATUS_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_STATUS_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_status_label) {
		COMP_ASSR_DTLS_POL_STATUS_LABEL = comp_assr_dtls_pol_status_label;
	}

	public HtmlOutputLabel getCOMP_ASSR_DTLS_POL_MOP_LABEL() {
		return COMP_ASSR_DTLS_POL_MOP_LABEL;
	}

	public void setCOMP_ASSR_DTLS_POL_MOP_LABEL(
			HtmlOutputLabel comp_assr_dtls_pol_mop_label) {
		COMP_ASSR_DTLS_POL_MOP_LABEL = comp_assr_dtls_pol_mop_label;
	}

	public PT_IL_POL_ASSURED_POLICY_DTLS getPT_IL_POL_ASSURED_POLICY_DTLS_BEAN() {
		return PT_IL_POL_ASSURED_POLICY_DTLS_BEAN;
	}

	public void setPT_IL_POL_ASSURED_POLICY_DTLS_BEAN(
			PT_IL_POL_ASSURED_POLICY_DTLS pt_il_pol_assured_policy_dtls_bean) {
		PT_IL_POL_ASSURED_POLICY_DTLS_BEAN = pt_il_pol_assured_policy_dtls_bean;
	}

	public PT_IL_POL_ASSURED_POLICY_DTLS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ASSURED_POLICY_DTLS_HELPER helper) {
		this.helper = helper;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public List<PT_IL_POL_ASSURED_POLICY_DTLS> getDataList_PT_IL_POL_ASSURED_POLICY_DTLS() {
		return dataList_PT_IL_POL_ASSURED_POLICY_DTLS;
	}

	public void setDataList_PT_IL_POL_ASSURED_POLICY_DTLS(
			List<PT_IL_POL_ASSURED_POLICY_DTLS> dataList_PT_IL_POL_ASSURED_POLICY_DTLS) {
		this.dataList_PT_IL_POL_ASSURED_POLICY_DTLS = dataList_PT_IL_POL_ASSURED_POLICY_DTLS;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BTN_MAIN() {
		return COMP_UI_M_BTN_MAIN;
	}

	public void setCOMP_UI_M_BTN_MAIN(HtmlAjaxCommandButton comp_ui_m_btn_main) {
		COMP_UI_M_BTN_MAIN = comp_ui_m_btn_main;
	}
}

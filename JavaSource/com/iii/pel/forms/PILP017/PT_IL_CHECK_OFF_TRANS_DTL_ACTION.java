package com.iii.pel.forms.PILP017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class  PT_IL_CHECK_OFF_TRANS_DTL_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_COTD_EMPLOYER_CODE_LABEL;

	private HtmlInputText COMP_COTD_EMPLOYER_CODE;

	private HtmlOutputLabel COMP_COTD_POLICY_NO_LABEL;

	private HtmlInputText COMP_COTD_POLICY_NO;

	private HtmlOutputLabel COMP_COTD_MSG_TYPE_LABEL;

	private HtmlInputText COMP_COTD_MSG_TYPE;
	
	private HtmlOutputLabel COMP_COTD_PAID_DATE_LABEL;

	private HtmlCalendar COMP_COTD_PAID_DATE;
	
	private HtmlOutputLabel COMP_COTD_DUE_DATE_LABEL;

	private HtmlCalendar COMP_COTD_DUE_DATE;
	

	private HtmlOutputLabel COMP_COTD_ERROR_CODE_LABEL;

	private HtmlInputText COMP_COTD_ERROR_CODE;
	
	private HtmlInputText COMP_UI_M_ERR_CODE_DESC;

	private HtmlOutputLabel COMP_COTD_PAID_FC_AMT_LABEL;

	private HtmlInputText COMP_COTD_PAID_FC_AMT;

	private HtmlOutputLabel COMP_COTD_PAID_LC_AMT_LABEL;

	private HtmlInputText COMP_COTD_PAID_LC_AMT;
	
	private HtmlCommandButton	COMP_UI_M_BACK;
	
	private PT_IL_CHECK_OFF_TRANS_DTL_HELPER helper;
	
	public PILP017_COMPOSITE_ACTION compositeAction;
	
	   private List<PT_IL_CHECK_OFF_TRANS_DTL> dataList_PT_IL_CHECK_OFF_TRANS_DTL = new ArrayList<PT_IL_CHECK_OFF_TRANS_DTL>();
	   private UIData dataTable;
	
	PT_IL_CHECK_OFF_TRANS_DTL PT_IL_CHECK_OFF_TRANS_DTL_BEAN;
	
	
	
	public PT_IL_CHECK_OFF_TRANS_DTL getPT_IL_CHECK_OFF_TRANS_DTL_BEAN() {
		return PT_IL_CHECK_OFF_TRANS_DTL_BEAN;
	}

	public void setPT_IL_CHECK_OFF_TRANS_DTL_BEAN(
			PT_IL_CHECK_OFF_TRANS_DTL pt_il_check_off_trans_dtl_bean) {
		PT_IL_CHECK_OFF_TRANS_DTL_BEAN = pt_il_check_off_trans_dtl_bean;
	}

	public PT_IL_CHECK_OFF_TRANS_DTL_ACTION() {
		
		 PT_IL_CHECK_OFF_TRANS_DTL_BEAN= new PT_IL_CHECK_OFF_TRANS_DTL();
		 helper=new PT_IL_CHECK_OFF_TRANS_DTL_HELPER();
		
		
	}
	
	
	 public void onLoad(PhaseEvent event) {
		 try {
				if (isBlockFlag()) {
					
					helper.executeQuery(compositeAction);
					 helper.postQuery(PT_IL_CHECK_OFF_TRANS_DTL_BEAN);
					
				}
				setBlockFlag(false);
				 
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
		
		 
	 }

	 
	 
	 public String back(){
		 return "PILP017_DUMMY";
	 }
	 
	
	 public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
			    resetSelectedRow();
			    PT_IL_CHECK_OFF_TRANS_DTL_BEAN = (PT_IL_CHECK_OFF_TRANS_DTL) dataTable.getRowData();
			    helper.postQuery(PT_IL_CHECK_OFF_TRANS_DTL_BEAN);
			    PT_IL_CHECK_OFF_TRANS_DTL_BEAN.setRowSelected(true);
			    resetAllComponent();
			} catch (Exception exc) {
			    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			    getErrorMap().put("displayRecords", exc.getMessage());
			}

		    }

		    private void resetSelectedRow() {
			Iterator<PT_IL_CHECK_OFF_TRANS_DTL> PT_IL_CHECK_OFF_TRANS_DTL_ITR = dataList_PT_IL_CHECK_OFF_TRANS_DTL
				.iterator();
			while (PT_IL_CHECK_OFF_TRANS_DTL_ITR.hasNext()) {
				PT_IL_CHECK_OFF_TRANS_DTL_ITR.next().setRowSelected(false);
			}
		    }

		    private void resetAllComponent() {
		    	COMP_COTD_EMPLOYER_CODE.resetValue();
		    	COMP_COTD_POLICY_NO.resetValue();
		    	COMP_COTD_MSG_TYPE.resetValue();
		    	COMP_COTD_PAID_DATE.resetValue();
		    	COMP_COTD_DUE_DATE.resetValue();
		    	COMP_COTD_ERROR_CODE.resetValue();
		    	COMP_COTD_PAID_FC_AMT.resetValue();
		    	COMP_COTD_PAID_LC_AMT.resetValue();
			
		    }
		    
		    public void instantiateAllComponent(){
				// Instantiating HtmlInputText
		    	COMP_COTD_EMPLOYER_CODE				 = new HtmlInputText();
		    	COMP_COTD_POLICY_NO			 = new HtmlInputText();
		    	COMP_COTD_MSG_TYPE				 = new HtmlInputText();
		    	COMP_COTD_ERROR_CODE				 = new HtmlInputText();
		    	COMP_COTD_PAID_FC_AMT			 = new HtmlInputText();
		    	COMP_COTD_PAID_LC_AMT					 = new HtmlInputText();
					

				// Instantiating HtmlCalendar
				COMP_COTD_PAID_DATE				 = new HtmlCalendar();
				COMP_COTD_DUE_DATE				 = new HtmlCalendar();
				
			}
	
	
	
	
	public HtmlOutputLabel getCOMP_COTD_EMPLOYER_CODE_LABEL() {
		return COMP_COTD_EMPLOYER_CODE_LABEL;
	}

	public void setCOMP_COTD_EMPLOYER_CODE_LABEL(
			HtmlOutputLabel comp_cotd_employer_code_label) {
		COMP_COTD_EMPLOYER_CODE_LABEL = comp_cotd_employer_code_label;
	}

	public HtmlInputText getCOMP_COTD_EMPLOYER_CODE() {
		return COMP_COTD_EMPLOYER_CODE;
	}

	public void setCOMP_COTD_EMPLOYER_CODE(HtmlInputText comp_cotd_employer_code) {
		COMP_COTD_EMPLOYER_CODE = comp_cotd_employer_code;
	}

	public HtmlOutputLabel getCOMP_COTD_POLICY_NO_LABEL() {
		return COMP_COTD_POLICY_NO_LABEL;
	}

	public void setCOMP_COTD_POLICY_NO_LABEL(
			HtmlOutputLabel comp_cotd_policy_no_label) {
		COMP_COTD_POLICY_NO_LABEL = comp_cotd_policy_no_label;
	}

	public HtmlInputText getCOMP_COTD_POLICY_NO() {
		return COMP_COTD_POLICY_NO;
	}

	public void setCOMP_COTD_POLICY_NO(HtmlInputText comp_cotd_policy_no) {
		COMP_COTD_POLICY_NO = comp_cotd_policy_no;
	}

	public HtmlOutputLabel getCOMP_COTD_MSG_TYPE_LABEL() {
		return COMP_COTD_MSG_TYPE_LABEL;
	}

	public void setCOMP_COTD_MSG_TYPE_LABEL(HtmlOutputLabel comp_cotd_msg_type_label) {
		COMP_COTD_MSG_TYPE_LABEL = comp_cotd_msg_type_label;
	}

	public HtmlInputText getCOMP_COTD_MSG_TYPE() {
		return COMP_COTD_MSG_TYPE;
	}

	public void setCOMP_COTD_MSG_TYPE(HtmlInputText comp_cotd_msg_type) {
		COMP_COTD_MSG_TYPE = comp_cotd_msg_type;
	}

	public HtmlOutputLabel getCOMP_COTD_PAID_DATE_LABEL() {
		return COMP_COTD_PAID_DATE_LABEL;
	}

	public void setCOMP_COTD_PAID_DATE_LABEL(
			HtmlOutputLabel comp_cotd_paid_date_label) {
		COMP_COTD_PAID_DATE_LABEL = comp_cotd_paid_date_label;
	}

	public HtmlCalendar getCOMP_COTD_PAID_DATE() {
		return COMP_COTD_PAID_DATE;
	}

	public void setCOMP_COTD_PAID_DATE(HtmlCalendar comp_cotd_paid_date) {
		COMP_COTD_PAID_DATE = comp_cotd_paid_date;
	}

	public HtmlOutputLabel getCOMP_COTD_DUE_DATE_LABEL() {
		return COMP_COTD_DUE_DATE_LABEL;
	}

	public void setCOMP_COTD_DUE_DATE_LABEL(HtmlOutputLabel comp_cotd_due_date_label) {
		COMP_COTD_DUE_DATE_LABEL = comp_cotd_due_date_label;
	}

	public HtmlCalendar getCOMP_COTD_DUE_DATE() {
		return COMP_COTD_DUE_DATE;
	}

	public void setCOMP_COTD_DUE_DATE(HtmlCalendar comp_cotd_due_date) {
		COMP_COTD_DUE_DATE = comp_cotd_due_date;
	}

	public HtmlOutputLabel getCOMP_COTD_ERROR_CODE_LABEL() {
		return COMP_COTD_ERROR_CODE_LABEL;
	}

	public void setCOMP_COTD_ERROR_CODE_LABEL(
			HtmlOutputLabel comp_cotd_error_code_label) {
		COMP_COTD_ERROR_CODE_LABEL = comp_cotd_error_code_label;
	}

	public HtmlInputText getCOMP_COTD_ERROR_CODE() {
		return COMP_COTD_ERROR_CODE;
	}

	public void setCOMP_COTD_ERROR_CODE(HtmlInputText comp_cotd_error_code) {
		COMP_COTD_ERROR_CODE = comp_cotd_error_code;
	}

	public HtmlOutputLabel getCOMP_COTD_PAID_FC_AMT_LABEL() {
		return COMP_COTD_PAID_FC_AMT_LABEL;
	}

	public void setCOMP_COTD_PAID_FC_AMT_LABEL(
			HtmlOutputLabel comp_cotd_paid_fc_amt_label) {
		COMP_COTD_PAID_FC_AMT_LABEL = comp_cotd_paid_fc_amt_label;
	}

	public HtmlInputText getCOMP_COTD_PAID_FC_AMT() {
		return COMP_COTD_PAID_FC_AMT;
	}

	public void setCOMP_COTD_PAID_FC_AMT(HtmlInputText comp_cotd_paid_fc_amt) {
		COMP_COTD_PAID_FC_AMT = comp_cotd_paid_fc_amt;
	}

	public HtmlOutputLabel getCOMP_COTD_PAID_LC_AMT_LABEL() {
		return COMP_COTD_PAID_LC_AMT_LABEL;
	}

	public void setCOMP_COTD_PAID_LC_AMT_LABEL(
			HtmlOutputLabel comp_cotd_paid_lc_amt_label) {
		COMP_COTD_PAID_LC_AMT_LABEL = comp_cotd_paid_lc_amt_label;
	}

	public HtmlInputText getCOMP_COTD_PAID_LC_AMT() {
		return COMP_COTD_PAID_LC_AMT;
	}

	public void setCOMP_COTD_PAID_LC_AMT(HtmlInputText comp_cotd_paid_lc_amt) {
		COMP_COTD_PAID_LC_AMT = comp_cotd_paid_lc_amt;
	}

	public List<PT_IL_CHECK_OFF_TRANS_DTL> getDataList_PT_IL_CHECK_OFF_TRANS_DTL() {
		return dataList_PT_IL_CHECK_OFF_TRANS_DTL;
	}

	public void setDataList_PT_IL_CHECK_OFF_TRANS_DTL(
			List<PT_IL_CHECK_OFF_TRANS_DTL> dataList_PT_IL_CHECK_OFF_TRANS_DTL) {
		this.dataList_PT_IL_CHECK_OFF_TRANS_DTL = dataList_PT_IL_CHECK_OFF_TRANS_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BACK() {
		return COMP_UI_M_BACK;
	}

	public void setCOMP_UI_M_BACK(HtmlCommandButton comp_ui_m_back) {
		COMP_UI_M_BACK = comp_ui_m_back;
	}

	public HtmlInputText getCOMP_UI_M_ERR_CODE_DESC() {
		return COMP_UI_M_ERR_CODE_DESC;
	}

	public void setCOMP_UI_M_ERR_CODE_DESC(HtmlInputText comp_ui_m_err_code_desc) {
		COMP_UI_M_ERR_CODE_DESC = comp_ui_m_err_code_desc;
	}

	

	

	
}
	
	
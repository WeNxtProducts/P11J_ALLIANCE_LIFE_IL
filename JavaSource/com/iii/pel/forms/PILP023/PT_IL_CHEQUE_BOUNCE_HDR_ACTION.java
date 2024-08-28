package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;







import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CHEQUE_BOUNCE_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_DEP_TXN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_DEP_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DEP_DOC_NO;

	private HtmlOutputLabel COMP_UI_M_DEP_DOC_DT_LABEL;

	private HtmlCalendar COMP_UI_M_DEP_DOC_DT;

	private HtmlOutputLabel COMP_UI_M_CBH_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CBH_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CBH_REVERSAL_REF_NO_LABEL;

	private HtmlInputText COMP_UI_M_CBH_REVERSAL_REF_NO;

	private HtmlOutputLabel COMP_UI_M_CBH_REMARKS_LABEL;

	/*Added by sankara narayanan for deposit Derail on 05/03/201 ref : ZBILQC-1720414 */
	private HtmlInputTextarea COMP_UI_M_CBH_REMARKS;
	
	private HtmlInputText COMP_UI_M_REC_AMT;

	public HtmlInputText getCOMP_UI_M_REC_AMT() {
		return COMP_UI_M_REC_AMT;
	}

	public void setCOMP_UI_M_REC_AMT(HtmlInputText cOMP_UI_M_REC_AMT) {
		COMP_UI_M_REC_AMT = cOMP_UI_M_REC_AMT;
	}

	public List<LovBean> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public PILP023_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP023_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlInputTextarea getCOMP_UI_M_CBH_REMARKS() {
		return COMP_UI_M_CBH_REMARKS;
	}

	public void setCOMP_UI_M_CBH_REMARKS(HtmlInputTextarea cOMP_UI_M_CBH_REMARKS) {
		COMP_UI_M_CBH_REMARKS = cOMP_UI_M_CBH_REMARKS;
	}
//end

	private HtmlOutputLabel COMP_CBH_POL_NO_LABEL;

	private HtmlInputText COMP_CBH_POL_NO;

	private HtmlOutputLabel COMP_CBH_POL_CONT_NAME_LABEL;

	private HtmlInputText COMP_CBH_POL_CONT_NAME;

	private HtmlOutputLabel COMP_UI_M_TXN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TXN_TYPE_DESC;

	private HtmlOutputLabel COMP_CBH_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_CBH_POL_START_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_START_DT;

	private HtmlOutputLabel COMP_CBH_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_CBH_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_CBH_POL_PROD_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_TXN_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DOC_NO;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_REASON_CODE;

	private HtmlCommandButton COMP_UI_M_EDIT_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_REVERSE;

	private HtmlCommandButton COMP_UI_M_BUT_MORE;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS;
	
	private HtmlCommandButton COMP_UI_M_BUT_CLEAR;

	private PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
	
	private boolean searchMode;
	
	private List<PT_IL_CHEQUE_BOUNCE_HDR> dataList;
	
	private UIData dataGrid;

	private List<LovBean> suggestionList;
	
	public PILP023_COMPOSITE_ACTION compositeAction ; 
	
	public boolean isSearchMode() {
		return searchMode;
	}

	public void setSearchMode(boolean searchMode) {
		this.searchMode = searchMode;
	}

	public PT_IL_CHEQUE_BOUNCE_HDR_ACTION() 
	{
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
		dataList=new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_TXN_CODE_LABEL() {
		return COMP_UI_M_DEP_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_TXN_CODE() {
		return COMP_UI_M_DEP_TXN_CODE;
	}

	public void setCOMP_UI_M_DEP_TXN_CODE_LABEL(HtmlOutputLabel COMP_UI_M_DEP_TXN_CODE_LABEL) {
		this.COMP_UI_M_DEP_TXN_CODE_LABEL = COMP_UI_M_DEP_TXN_CODE_LABEL;
	}

	public void setCOMP_UI_M_DEP_TXN_CODE(HtmlInputText COMP_UI_M_DEP_TXN_CODE) {
		this.COMP_UI_M_DEP_TXN_CODE = COMP_UI_M_DEP_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_DOC_NO_LABEL() {
		return COMP_UI_M_DEP_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_DOC_NO() {
		return COMP_UI_M_DEP_DOC_NO;
	}

	public void setCOMP_UI_M_DEP_DOC_NO_LABEL(HtmlOutputLabel COMP_UI_M_DEP_DOC_NO_LABEL) {
		this.COMP_UI_M_DEP_DOC_NO_LABEL = COMP_UI_M_DEP_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DEP_DOC_NO(HtmlInputText COMP_UI_M_DEP_DOC_NO) {
		this.COMP_UI_M_DEP_DOC_NO = COMP_UI_M_DEP_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_DOC_DT_LABEL() {
		return COMP_UI_M_DEP_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_DEP_DOC_DT() {
		return COMP_UI_M_DEP_DOC_DT;
	}

	public void setCOMP_UI_M_DEP_DOC_DT_LABEL(HtmlOutputLabel COMP_UI_M_DEP_DOC_DT_LABEL) {
		this.COMP_UI_M_DEP_DOC_DT_LABEL = COMP_UI_M_DEP_DOC_DT_LABEL;
	}

	public void setCOMP_UI_M_DEP_DOC_DT(HtmlCalendar COMP_UI_M_DEP_DOC_DT) {
		this.COMP_UI_M_DEP_DOC_DT = COMP_UI_M_DEP_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBH_REASON_CODE_LABEL() {
		return COMP_UI_M_CBH_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBH_REASON_CODE() {
		return COMP_UI_M_CBH_REASON_CODE;
	}

	public void setCOMP_UI_M_CBH_REASON_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CBH_REASON_CODE_LABEL) {
		this.COMP_UI_M_CBH_REASON_CODE_LABEL = COMP_UI_M_CBH_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_CBH_REASON_CODE(HtmlInputText COMP_UI_M_CBH_REASON_CODE) {
		this.COMP_UI_M_CBH_REASON_CODE = COMP_UI_M_CBH_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
		return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_REASON_CODE_DESC_LABEL = COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(HtmlInputText COMP_UI_M_REASON_CODE_DESC) {
		this.COMP_UI_M_REASON_CODE_DESC = COMP_UI_M_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBH_REVERSAL_REF_NO_LABEL() {
		return COMP_UI_M_CBH_REVERSAL_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBH_REVERSAL_REF_NO() {
		return COMP_UI_M_CBH_REVERSAL_REF_NO;
	}

	public void setCOMP_UI_M_CBH_REVERSAL_REF_NO_LABEL(HtmlOutputLabel COMP_UI_M_CBH_REVERSAL_REF_NO_LABEL) {
		this.COMP_UI_M_CBH_REVERSAL_REF_NO_LABEL = COMP_UI_M_CBH_REVERSAL_REF_NO_LABEL;
	}

	public void setCOMP_UI_M_CBH_REVERSAL_REF_NO(HtmlInputText COMP_UI_M_CBH_REVERSAL_REF_NO) {
		this.COMP_UI_M_CBH_REVERSAL_REF_NO = COMP_UI_M_CBH_REVERSAL_REF_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBH_REMARKS_LABEL() {
		return COMP_UI_M_CBH_REMARKS_LABEL;
	}




	public void setCOMP_UI_M_CBH_REMARKS_LABEL(HtmlOutputLabel COMP_UI_M_CBH_REMARKS_LABEL) {
		this.COMP_UI_M_CBH_REMARKS_LABEL = COMP_UI_M_CBH_REMARKS_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_CBH_POL_NO_LABEL() {
		return COMP_CBH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_NO() {
		return COMP_CBH_POL_NO;
	}

	public void setCOMP_CBH_POL_NO_LABEL(HtmlOutputLabel COMP_CBH_POL_NO_LABEL) {
		this.COMP_CBH_POL_NO_LABEL = COMP_CBH_POL_NO_LABEL;
	}

	public void setCOMP_CBH_POL_NO(HtmlInputText COMP_CBH_POL_NO) {
		this.COMP_CBH_POL_NO = COMP_CBH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_CONT_NAME_LABEL() {
		return COMP_CBH_POL_CONT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_CONT_NAME() {
		return COMP_CBH_POL_CONT_NAME;
	}

	public void setCOMP_CBH_POL_CONT_NAME_LABEL(HtmlOutputLabel COMP_CBH_POL_CONT_NAME_LABEL) {
		this.COMP_CBH_POL_CONT_NAME_LABEL = COMP_CBH_POL_CONT_NAME_LABEL;
	}

	public void setCOMP_CBH_POL_CONT_NAME(HtmlInputText COMP_CBH_POL_CONT_NAME) {
		this.COMP_CBH_POL_CONT_NAME = COMP_CBH_POL_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_TYPE_DESC_LABEL() {
		return COMP_UI_M_TXN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_TYPE_DESC() {
		return COMP_UI_M_TXN_TYPE_DESC;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TXN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_TXN_TYPE_DESC_LABEL = COMP_UI_M_TXN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC(HtmlInputText COMP_UI_M_TXN_TYPE_DESC) {
		this.COMP_UI_M_TXN_TYPE_DESC = COMP_UI_M_TXN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_ISSUE_DT_LABEL() {
		return COMP_CBH_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_ISSUE_DT() {
		return COMP_CBH_POL_ISSUE_DT;
	}

	public void setCOMP_CBH_POL_ISSUE_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_ISSUE_DT_LABEL) {
		this.COMP_CBH_POL_ISSUE_DT_LABEL = COMP_CBH_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_CBH_POL_ISSUE_DT(HtmlCalendar COMP_CBH_POL_ISSUE_DT) {
		this.COMP_CBH_POL_ISSUE_DT = COMP_CBH_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_START_DT_LABEL() {
		return COMP_CBH_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_START_DT() {
		return COMP_CBH_POL_START_DT;
	}

	public void setCOMP_CBH_POL_START_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_START_DT_LABEL) {
		this.COMP_CBH_POL_START_DT_LABEL = COMP_CBH_POL_START_DT_LABEL;
	}

	public void setCOMP_CBH_POL_START_DT(HtmlCalendar COMP_CBH_POL_START_DT) {
		this.COMP_CBH_POL_START_DT = COMP_CBH_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_EXPIRY_DT_LABEL() {
		return COMP_CBH_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_EXPIRY_DT() {
		return COMP_CBH_POL_EXPIRY_DT;
	}

	public void setCOMP_CBH_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_EXPIRY_DT_LABEL) {
		this.COMP_CBH_POL_EXPIRY_DT_LABEL = COMP_CBH_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_CBH_POL_EXPIRY_DT(HtmlCalendar COMP_CBH_POL_EXPIRY_DT) {
		this.COMP_CBH_POL_EXPIRY_DT = COMP_CBH_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_PROD_CODE_LABEL() {
		return COMP_CBH_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_PROD_CODE() {
		return COMP_CBH_POL_PROD_CODE;
	}

	public void setCOMP_CBH_POL_PROD_CODE_LABEL(HtmlOutputLabel COMP_CBH_POL_PROD_CODE_LABEL) {
		this.COMP_CBH_POL_PROD_CODE_LABEL = COMP_CBH_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_CBH_POL_PROD_CODE(HtmlInputText COMP_CBH_POL_PROD_CODE) {
		this.COMP_CBH_POL_PROD_CODE = COMP_CBH_POL_PROD_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_TXN_CODE() {
		return COMP_UI_M_BUT_LOV_TXN_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_TXN_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_TXN_CODE) {
		this.COMP_UI_M_BUT_LOV_TXN_CODE = COMP_UI_M_BUT_LOV_TXN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DOC_NO() {
		return COMP_UI_M_BUT_LOV_DOC_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_DOC_NO(HtmlCommandButton COMP_UI_M_BUT_LOV_DOC_NO) {
		this.COMP_UI_M_BUT_LOV_DOC_NO = COMP_UI_M_BUT_LOV_DOC_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_REASON_CODE() {
		return COMP_UI_M_BUT_LOV_REASON_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_REASON_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_REASON_CODE) {
		this.COMP_UI_M_BUT_LOV_REASON_CODE = COMP_UI_M_BUT_LOV_REASON_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_REMARKS() {
		return COMP_UI_M_EDIT_REMARKS;
	}

	public void setCOMP_UI_M_EDIT_REMARKS(HtmlCommandButton COMP_UI_M_EDIT_REMARKS) {
		this.COMP_UI_M_EDIT_REMARKS = COMP_UI_M_EDIT_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REVERSE() {
		return COMP_UI_M_BUT_REVERSE;
	}

	public void setCOMP_UI_M_BUT_REVERSE(HtmlCommandButton COMP_UI_M_BUT_REVERSE) {
		this.COMP_UI_M_BUT_REVERSE = COMP_UI_M_BUT_REVERSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE() {
		return COMP_UI_M_BUT_MORE;
	}

	public void setCOMP_UI_M_BUT_MORE(HtmlCommandButton COMP_UI_M_BUT_MORE) {
		this.COMP_UI_M_BUT_MORE = COMP_UI_M_BUT_MORE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_REPAY_DTLS() {
		return COMP_UI_M_BUT_LOAN_REPAY_DTLS;
	}

	public void setCOMP_UI_M_BUT_LOAN_REPAY_DTLS(HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS) {
		this.COMP_UI_M_BUT_LOAN_REPAY_DTLS = COMP_UI_M_BUT_LOAN_REPAY_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_DTLS() {
		return COMP_UI_M_BUT_PREM_DTLS;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS(HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS) {
		this.COMP_UI_M_BUT_PREM_DTLS = COMP_UI_M_BUT_PREM_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEP_REFUND_DTLS() {
		return COMP_UI_M_BUT_DEP_REFUND_DTLS;
	}

	public void setCOMP_UI_M_BUT_DEP_REFUND_DTLS(HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS) {
		this.COMP_UI_M_BUT_DEP_REFUND_DTLS = COMP_UI_M_BUT_DEP_REFUND_DTLS;
	}

	public PT_IL_CHEQUE_BOUNCE_HDR getPT_IL_CHEQUE_BOUNCE_HDR_BEAN() {
		return PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
	}

	public void setPT_IL_CHEQUE_BOUNCE_HDR_BEAN(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) {
		this.PT_IL_CHEQUE_BOUNCE_HDR_BEAN = PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
	}

	public List<PT_IL_CHEQUE_BOUNCE_HDR> getDataList() {
		return dataList;
	}

	public void setDataList(List<PT_IL_CHEQUE_BOUNCE_HDR> dataList) {
		this.dataList = dataList;
	}

	public UIData getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIData dataGrid) {
		this.dataGrid = dataGrid;
	}

	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				postBlock();
				//helper.executeQuery(compositeAction);
				if(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getROWID() != null){
					/*helper.postQuery(PT_GL_POL_EMP_COVER_BEAN);
					}else{
					helper.whenCreateRecord(compositeAction);*/
					/*Added by Ram on 25/12/2016 for Search concept*/
					helper.executeQuery(compositeAction);
					/*Added by Ameen on 03-07-2017 as a part of ZBILQC-1729834 i.e while search and loading screen data not coming*/
					helper.receptBounceHdrExecuteQry(compositeAction);
					/*End*/
					compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().onLoad(null);					
					/*End*/
					
				}
					
			}	
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	
	public void loadPaymentAndChequeDetails(){
		
	}
	
	
	/**
	 * 
	 */
	public void postBlock(){
		Connection connection = null;
		CRUDHandler handler = null;
		String C1 = "select 'X' from pt_il_deposit,pm_il_plan "
				+ "where DEP_TXN_CODE = ? "
				+ " and DEP_DOC_NO = ? "
				+ " and DEP_DOC_DT = ? "
				+ "and DEP_PLAN_CODE=PLAN_CODE and plan_type ='U'";
		ResultSet C1_REC = null;
		String mDummy=null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE(),
																				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_NO(),
																				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT()
																				});
			if(C1_REC.next()){
				mDummy = C1_REC.getString(1);
			}	
			
			if("X".equalsIgnoreCase(CommonUtils.nvl(mDummy, "N"))){
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "3206",new Object[]{"Cant reverse unit link receipts"}));
			}
			
		}catch(Exception exception){
			exception.getMessage();
		}finally{
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public List<LovBean> dep_Txn_Code_suggestion_list(Object value)
	{
		suggestionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggestionList = itemUtil.P_CALL_LOV("PILP023",
					"DUMMY", "M_DEP_TXN_CODE", null, null, null,
					null, null, (String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
		/*PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
		return helper.dep_txn_code_lov((String)value);*/
	}
	
	public List<PT_IL_CHEQUE_BOUNCE_HDR> dep_code_suggestion(Object	value){
		List<PT_IL_CHEQUE_BOUNCE_HDR> list = null;
		PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
		list = helper.dep_Doc_No_LOV((String)value);
		return list; 		
	}
	public List<LovBean> reason_code(Object value)
	{
		/*System.out.println("REASON CODE.......");
		PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
		suggestionList=helper.reason_code_LOV((String)value);*/
		suggestionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggestionList = itemUtil.P_CALL_LOV("PILP023",
					"DUMMY", "M_CBH_REASON_CODE", "REV_REASON", null, null,
					null, null, (String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
		 
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws javax.faces.validator.ValidatorException
	 */
	public void validatorDepTxnCode(FacesContext context, UIComponent component, Object value)
	{
		System.out.println("validating DepTxnCode");
		try{
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_TXN_TYPE((String)value);
			PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
			helper.pilp023_dummy_m_dep_txn_code_when_validate_item(compositeAction);
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	public void validateDepTxnCode(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	/*public void validatorDepDocNo(FacesContext context, UIComponent component, Object value)
		{
			UIInput input = (UIInput)event.getComponent().getParent();
			try{
				//PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_NO((Integer)value);
				PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
				helper.pilp023_dummy_m_dep_doc_no_when_validate_item(compositeAction);
				Added by Ameen on 13-06-2017 for ZBILQC-1720414
				helper.pilp023_dummy_m_dep_doc_dt_when_validate_item(compositeAction);
				
				compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().onLoad(null);
				COMP_UI_M_DEP_DOC_DT.resetValue();
				System.out.println("COMP_UI_M_DEP_DOC_DT ==>>>>>" + PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT());
				//helper.receptBounceHdrExecuteQry(compositeAction);
				COMP_CBH_POL_START_DT.resetValue();
				COMP_CBH_POL_EXPIRY_DT.resetValue();
				COMP_CBH_POL_PROD_CODE.resetValue();
				End
			}catch(Exception exception){
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception.getMessage()));
			}
			
		}*/
	
	
	public void validatorDepDocNo(FacesContext context, UIComponent component, Object value)
	{
		
		try{
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_NO((Integer) value);
			PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
			/*
			helper.pilp023_dummy_m_dep_doc_no_when_validate_item(compositeAction);
			Added by Ameen on 13-06-2017 for ZBILQC-1720414
			helper.pilp023_dummy_m_dep_doc_dt_when_validate_item(compositeAction);
			
			compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().onLoad(null);
			COMP_UI_M_DEP_DOC_DT.resetValue();
			System.out.println("COMP_UI_M_DEP_DOC_DT ==>>>>>" + PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT());
			//helper.receptBounceHdrExecuteQry(compositeAction);
			COMP_CBH_POL_START_DT.resetValue();
			COMP_CBH_POL_EXPIRY_DT.resetValue();
			COMP_CBH_POL_PROD_CODE.resetValue();
			End
		}*/
			
			Long depsys_id=getdep_sys_id(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE(),PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_NO(),
					PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_REC_AMT());
			Date receipt_date=Receipt_date(depsys_id);
			
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_DT(receipt_date);
				COMP_UI_M_DEP_DOC_DT.resetValue();
				System.out.println("COMP_UI_M_DEP_DOC_DT ==>>>>>" + PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT());	
			
			/*PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_DT(receipt_date);
			COMP_UI_M_DEP_DOC_DT.resetValue();
			System.out.println("COMP_UI_M_DEP_DOC_DT ==>>>>>" + PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT());*/
			helper.pilp023_dummy_m_dep_doc_no_when_validate_item(compositeAction);
			/*Added by Ameen on 13-06-2017 for ZBILQC-1720414*/
			helper.pilp023_dummy_m_dep_doc_dt_when_validate_item(compositeAction,depsys_id);
			
			compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().onLoad(null);
			
			
			//helper.receptBounceHdrExecuteQry(compositeAction);
			COMP_CBH_POL_START_DT.resetValue();
			COMP_CBH_POL_EXPIRY_DT.resetValue();
			COMP_CBH_POL_PROD_CODE.resetValue();
			/*End*/
			
			//COMP_UI_M_DEP_DOC_DT.resetValue();
		
		}
	
			
			catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
		
	}
	public void validateDepDocNo(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN = (PT_IL_CHEQUE_BOUNCE_HDR) dataGrid
					.getRowData();
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_CHEQUE_BOUNCE_HDR> PT_GL_POL_EMP_COVER_ITR = dataList
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorDepDocDt(FacesContext context, UIComponent component,
			Object value)  {
			/*Added by Ameen on 13-06-2017 for ZBILQC-1720414*/
			ResultSet rs_recDate = null;
			Date docDate = null;
			/*End*/
		try {
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_DT((Date)value);
			PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
			/*
			 * commented by Ameen on 20-06-2017 for ZBILQC-1720414 as this has been changed to call in validatorDepDocNo method
			 * helper.pilp023_dummy_m_dep_doc_dt_when_validate_item(compositeAction);
			
			compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().onLoad(null);*/
			
			/*Added by Ameen on 13-06-2017 for ZBILQC-1720414*/
			String recDateQry = "SELECT DEP_DOC_DT FROM PT_IL_DEPOSIT WHERE DEP_TXN_CODE = ? AND DEP_DOC_NO = ? AND NVL(DEP_REC_REV_YN,'N') <> 'Y'";
			rs_recDate = new CRUDHandler().executeSelectStatement(recDateQry, CommonUtils.getConnection(), 
					new Object[]{PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE(),PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_NO()});
			if(rs_recDate.next()){
				docDate = rs_recDate.getDate("DEP_DOC_DT");
			}
			if(docDate != null){
				if(!docDate.equals(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_DT())){
					throw new Exception("Not a Valid Date");
				}
			}
			/*End*/
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	/*public void validateDepDocDt(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}*/
	
	public void validatorReasonCode(FacesContext context, UIComponent component, Object value)
	{
		try{
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REASON_CODE((String)value);
			PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
			System.out.println("INPUT TO THE DB "+value);
			helper.pilp023_dummy_m_cbh_reason_code_when_validate_item(compositeAction);
		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
		
	}
	public void validateReasonCode(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		validatorReasonCode(FacesContext.getCurrentInstance(), event.getComponent().getParent(), null);
	}
	public void validatorPymtDetails(FacesContext context, UIComponent component, Object value)
	{
		System.out.println("INSIDE PAYMENT METHOD");
		PT_IL_PYMT_DTLS_HELPER helper= new PT_IL_PYMT_DTLS_HELPER();
		PILP023_COMPOSITE_ACTION compositeAction=(PILP023_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PILP023_COMPOSITE_ACTION");
		//List<PT_IL_PYMT_DTLS> list=helper.pymtSelectQuery();
		//compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().setPymtList(list);
	}
	
	
	/*public void setREASON_CODE_SUGGESTION_VALUE(ActionEvent event){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION bounceAction = ((PILP023_COMPOSITE_ACTION)sessionMap.get("PILP023_COMPOSITE_ACTION")).getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		String Reason_CODE = (String) bounceAction.getCOMP_UI_M_CBH_REASON_CODE().getSubmittedValue();
		System.out.println("REASON CODE:::"+Reason_CODE);
		
		bounceAction.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().setUI_M_DEP_REASON_CODE(Reason_CODE);
		
		if(suggestionList!=null){
			Iterator<PT_IL_CHEQUE_BOUNCE_HDR> bounceIterator = suggestionList.iterator();
			while(bounceIterator.hasNext()){
				PT_IL_CHEQUE_BOUNCE_HDR bounceBean = bounceIterator.next();
				if(Reason_CODE.equalsIgnoreCase(bounceBean.getUI_M_DEP_REASON_CODE()))
				{
					//bounceAction.getCOMP_UI_M_REASON_CODE_DESC().setSubmittedValue(bounceBean.getUI_M_REASON_CODE_DESC());
					bounceAction.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().setUI_M_REASON_CODE_DESC(bounceBean.getUI_M_REASON_CODE_DESC());
					System.out.println("bounceBean.getUI_M_REASON_CODE_DESC()"+bounceBean.getUI_M_REASON_CODE_DESC());
					COMP_UI_M_REASON_CODE_DESC.setSubmittedValue(null);
				}
			}
		}
	}*/
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}
	
	
	
	public String checkBoxStatus(ActionEvent actionEvent){
		boolean checkBoxValue = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataGrid().getRowIndex();
		System.out.println("ROW INDEX"+rowIndex);
//		getDataList().get(rowIndex).setCheckBoxValue(checkBoxValue);
//		System.out.println("Comming to check box status :"+ checkBoxValue);
		return "";
	}
	public String backToHdr()
	{
		return "receiptBounce";
	}
	public String reverse() 
	{
			try {
				new PT_IL_CHEQUE_BOUNCE_HDR_HELPER().pilp023_dummy_m_but_reverse_when_button_pressed(compositeAction);
				/*Added by Ameen on 20-06-2017 forZBILQC-1720414*/
				helper.receptBounceHdrExecuteQry(compositeAction);
				/*End*/
			} catch (ValidatorException ve) {				
				getErrorMap().put("current", ve.getMessage());
				getErrorMap().put("button", ve.getMessage());
				
				//ve.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}
		
		return null;
	}
	
	/*Enabled SaveRecord function by Ram on 25/12/2016*/
	public void saveRecord() { 
		String message = null;
		CommonUtils.clearMaps(this);
		DUMMY_ACTION dummy_action = new DUMMY_ACTION();
		try {
			/*Added by Ram on 26/12/2016 for Validating Receipt Date*/
			if(compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().getPymtList() != null && 
					compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().getPymtList().size() == 0)
			{
				throw new Exception("No Transactions are available in this transaction Date");
			}
			/*End*/
			if (getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					new CRUDHandler().executeUpdate(PT_IL_CHEQUE_BOUNCE_HDR_BEAN,
							CommonUtils.getConnection());
					// dummy_action.keycommitButtonAction();
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}
			} else {
				if (isINSERT_ALLOWED()) {
					
					/*Added by Ram on 25/12/2016 for Save Record Function*/
					helper.preUpdate(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
					/*End*/
					
					new CRUDHandler().executeInsert(PT_IL_CHEQUE_BOUNCE_HDR_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	 }
	
	/*End*/
	
	
	
	
	/*public void renderClassCode(ActionEvent event){
		Iterator<PT_IL_CHEQUE_BOUNCE_HDR> iterator = null;
		PT_IL_CHEQUE_BOUNCE_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		
		classCode = (String) COMP_UI_M_DEP_DOC_NO.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(suggestionList != null){
				iterator = suggestionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getUI_M_DEP_DOC_NO().equalsIgnoreCase(classCode)){
						getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().setUI_M_DEP_DOC_NO(bean.getUI_M_DEP_DOC_NO());
						keepLooking = false;
					}
				}
			}
		}
	}*/

	public HtmlCommandButton getCOMP_UI_M_BUT_CLEAR() {
		return COMP_UI_M_BUT_CLEAR;
	}

	public void setCOMP_UI_M_BUT_CLEAR(HtmlCommandButton comp_ui_m_but_clear) {
		COMP_UI_M_BUT_CLEAR = comp_ui_m_but_clear;
	}
	

	/**
	 * Resets all components in PT_IL_CHEQUE_BOUNCE_HDR_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_DEP_TXN_CODE.resetValue();
		COMP_UI_M_DEP_DOC_NO.resetValue();
		COMP_UI_M_CBH_REASON_CODE.resetValue();
		COMP_UI_M_REASON_CODE_DESC.resetValue();
		COMP_UI_M_CBH_REVERSAL_REF_NO.resetValue();
		COMP_UI_M_CBH_REMARKS.resetValue();
		COMP_CBH_POL_NO.resetValue();
		COMP_CBH_POL_CONT_NAME.resetValue();
		COMP_UI_M_TXN_TYPE_DESC.resetValue();
		COMP_CBH_POL_PROD_CODE.resetValue();

		// Reseting HtmlCalendar
		COMP_UI_M_DEP_DOC_DT.resetValue();
		COMP_CBH_POL_ISSUE_DT.resetValue();
		COMP_CBH_POL_START_DT.resetValue();
		COMP_CBH_POL_EXPIRY_DT.resetValue();

		// Reseting HtmlCommandButton
		/*COMP_UI_M_BUT_LOV_TXN_CODE.resetValue();
		COMP_UI_M_BUT_LOV_DOC_NO.resetValue();
		COMP_UI_M_BUT_LOV_REASON_CODE.resetValue();
		COMP_UI_M_EDIT_REMARKS.resetValue();
		COMP_UI_M_BUT_REVERSE.resetValue();
		COMP_UI_M_BUT_MORE.resetValue();
		COMP_UI_M_BUT_LOAN_REPAY_DTLS.resetValue();
		COMP_UI_M_BUT_PREM_DTLS.resetValue();
		COMP_UI_M_BUT_DEP_REFUND_DTLS.resetValue();
		COMP_UI_M_BUT_CLEAR.resetValue();*/

	}


	/**
	 * Instantiates all components in PT_IL_CHEQUE_BOUNCE_HDR_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_DEP_TXN_CODE				 = new HtmlInputText();
		COMP_UI_M_DEP_DOC_NO				 = new HtmlInputText();
		COMP_UI_M_CBH_REASON_CODE			 = new HtmlInputText();
		COMP_UI_M_REASON_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_CBH_REVERSAL_REF_NO			 = new HtmlInputText();
		COMP_UI_M_CBH_REMARKS				 = new HtmlInputTextarea();
		COMP_CBH_POL_NO					 = new HtmlInputText();
		COMP_CBH_POL_CONT_NAME				 = new HtmlInputText();
		COMP_UI_M_TXN_TYPE_DESC				 = new HtmlInputText();
		COMP_CBH_POL_PROD_CODE				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_UI_M_DEP_DOC_DT				 = new HtmlCalendar();
		COMP_CBH_POL_ISSUE_DT				 = new HtmlCalendar();
		COMP_CBH_POL_START_DT				 = new HtmlCalendar();
		COMP_CBH_POL_EXPIRY_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_TXN_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_DOC_NO			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_REASON_CODE			 = new HtmlCommandButton();
		COMP_UI_M_EDIT_REMARKS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_REVERSE				 = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOAN_REPAY_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_PREM_DTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_DEP_REFUND_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_CLEAR				 = new HtmlCommandButton();

	}

/*Added by Ram on 25/12/2016 for Save Record Function*/
	PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
	public PT_IL_CHEQUE_BOUNCE_HDR_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper) {
		this.helper = helper;
	}
/*End*/
	
	/*Added by Ameen on 20-06-2017 for ZBILQC-1720414*/
	
	public void validatorUI_M_CBH_REVERSAL_REF_NO(FacesContext context, 
			UIComponent component, Object value)
	{
		try{
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REVERSAL_REF_NO((String)value);
		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
		
	}
	
	public static ArrayList<LovBean> prepareSuggestionList(final String query, 
			final Object[] values) throws Exception{
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		LovBean lovBean = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		int columnCount = -1;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			columnCount = resultSet.getMetaData().getColumnCount();
			while(resultSet.next()){
				lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				if(columnCount > 2){
					lovBean.setName1(resultSet.getString(3));
				}
				suggestionList.add(lovBean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> 	LOV_Receipt_No(
			Object object) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String query1 = "";
		
				
		try {
			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			if("*".equals(currentValue)){
				//	query1 = "SELECT DEP_DOC_NO,DEP_LC_DEP_AMT FROM  PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?,DEP_DOC_NO) AND ROWNUM < ? ORDER BY 1 ASC";
					/*query1 = "SELECT DEP_DOC_NO, DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?, DEP_DOC_NO)"
							+ " AND NVL(DEP_REC_REV_YN, 'N') = 'N' AND ROWNUM < ? ORDER BY 1 ASC ";*/
		query1="SELECT * FROM (SELECT DEP_DOC_NO, DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?, DEP_DOC_NO) "
				+ "AND NVL(DEP_REC_REV_YN, 'N') = 'N' ORDER BY 1 ASC) WHERE ROWNUM < ? ";
				suggestionList =prepareSuggestionList(query1, new Object[] 
						{currentValue,PELConstants.suggetionRecordSize});
			}else{
				//query1 = "SELECT DEP_DOC_NO,DEP_LC_DEP_AMT FROM  PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?,DEP_DOC_NO) AND ROWNUM < ? ORDER BY 1 ASC";
				/*query1 = "SELECT DEP_DOC_NO, DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?, DEP_DOC_NO)"
						+ " AND NVL(DEP_REC_REV_YN, 'N') = 'N' AND ROWNUM < ? ORDER BY 1 ASC ";*/
				
				query1="SELECT * FROM (SELECT DEP_DOC_NO, DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO LIKE NVL(?, DEP_DOC_NO) "
						+ "AND NVL(DEP_REC_REV_YN, 'N') = 'N' ORDER BY 1 ASC) WHERE ROWNUM < ? ";
				suggestionList =prepareSuggestionList(query1, new Object[] 
						{currentValue,PELConstants.suggetionRecordSize});	
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}

		return suggestionList;
	}
	
	public Date Receipt_date(/*String trans_code,Integer doc_no*/Long dep_sys_id ) {

		ResultSet rs_recDate = null;
		Date docDate = null;

		try {
		/*String recDateQry ="SELECT MAX(DEP_DOC_DT)DEP_DOC_DT FROM PT_IL_DEPOSIT WHERE DEP_TXN_CODE =? AND DEP_DOC_NO =?"
		+ "AND NVL(DEP_REC_REV_YN, 'N') <> 'Y' ";*/
		String recDateQry ="SELECT DEP_DOC_DT FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID = ? " ;
		rs_recDate = new CRUDHandler().executeSelectStatement(recDateQry, CommonUtils.getConnection(),
		new Object[]{/*trans_code,doc_no*/dep_sys_id});
		if(rs_recDate.next()){
		docDate = rs_recDate.getDate("DEP_DOC_DT");
		}

		} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
		.getMessage()));
		}
		return docDate;
		}
	public Long getdep_sys_id(String trans_code,Integer doc_no,String amount)  {
		ResultSet rs_recDate = null;
		Long dep_sys_id = null;
	try {
		System.out.println("<<<<***receipt_amount**>> " +amount);
		String recDateQry ="SELECT DEP_SYS_ID FROM PT_IL_DEPOSIT WHERE DEP_TXN_CODE =? AND DEP_DOC_NO =? "
				+ " AND NVL(DEP_REC_REV_YN, 'N') <> 'Y' AND NVL(DEP_LC_DEP_AMT,0) =? ";
		rs_recDate = new CRUDHandler().executeSelectStatement(recDateQry, CommonUtils.getConnection(), 
				new Object[]{trans_code,doc_no,amount});
		if(rs_recDate.next()){
			dep_sys_id = rs_recDate.getLong("DEP_SYS_ID");
		}
		
	} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
				.getMessage()));
	}
	System.out.println("######dep_sys_id######"+ dep_sys_id);
	return dep_sys_id;
}
	/*End*/
}
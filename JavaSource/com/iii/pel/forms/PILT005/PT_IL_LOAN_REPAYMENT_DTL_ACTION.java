package com.iii.pel.forms.PILT005;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_LRD_PROD_CODE_LABEL;

	private HtmlInputText COMP_LRD_PROD_CODE;

	private HtmlOutputLabel COMP_LRD_FC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LRD_FC_PYMT_AMT;

	private HtmlOutputLabel COMP_LRD_LC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LRD_LC_PYMT_AMT;

	private HtmlOutputLabel COMP_UI_M_REPAY_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REPAY_PROD_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_DTL;

	private PT_IL_LOAN_REPAYMENT_DTL PT_IL_LOAN_REPAYMENT_DTL_BEAN;
	
	/** The Below Variables are added for functionality */
	
	private ArrayList<PT_IL_LOAN_REPAYMENT_DTL> repaymentDetail = new ArrayList<PT_IL_LOAN_REPAYMENT_DTL>();
	private UIDataTable repaymentDetailDT;
	
	/** The Below Variables are added for functionality */
	
	public UIDataTable getRepaymentDetailDT() {
		return repaymentDetailDT;
	}

	public void setRepaymentDetailDT(UIDataTable repaymentDetailDT) {
		this.repaymentDetailDT = repaymentDetailDT;
	}

	public ArrayList<PT_IL_LOAN_REPAYMENT_DTL> getRepaymentDetail() {
		return repaymentDetail;
	}

	public void setRepaymentDetail(
			ArrayList<PT_IL_LOAN_REPAYMENT_DTL> repaymentDetail) {
		this.repaymentDetail = repaymentDetail;
	}

	public PT_IL_LOAN_REPAYMENT_DTL_ACTION() {
		PT_IL_LOAN_REPAYMENT_DTL_BEAN = new PT_IL_LOAN_REPAYMENT_DTL();
	}

	public HtmlOutputLabel getCOMP_LRD_PROD_CODE_LABEL() {
		return COMP_LRD_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LRD_PROD_CODE() {
		return COMP_LRD_PROD_CODE;
	}

	public void setCOMP_LRD_PROD_CODE_LABEL(HtmlOutputLabel COMP_LRD_PROD_CODE_LABEL) {
		this.COMP_LRD_PROD_CODE_LABEL = COMP_LRD_PROD_CODE_LABEL;
	}

	public void setCOMP_LRD_PROD_CODE(HtmlInputText COMP_LRD_PROD_CODE) {
		this.COMP_LRD_PROD_CODE = COMP_LRD_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_LRD_FC_PYMT_AMT_LABEL() {
		return COMP_LRD_FC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LRD_FC_PYMT_AMT() {
		return COMP_LRD_FC_PYMT_AMT;
	}

	public void setCOMP_LRD_FC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LRD_FC_PYMT_AMT_LABEL) {
		this.COMP_LRD_FC_PYMT_AMT_LABEL = COMP_LRD_FC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LRD_FC_PYMT_AMT(HtmlInputText COMP_LRD_FC_PYMT_AMT) {
		this.COMP_LRD_FC_PYMT_AMT = COMP_LRD_FC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LRD_LC_PYMT_AMT_LABEL() {
		return COMP_LRD_LC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LRD_LC_PYMT_AMT() {
		return COMP_LRD_LC_PYMT_AMT;
	}

	public void setCOMP_LRD_LC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LRD_LC_PYMT_AMT_LABEL) {
		this.COMP_LRD_LC_PYMT_AMT_LABEL = COMP_LRD_LC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LRD_LC_PYMT_AMT(HtmlInputText COMP_LRD_LC_PYMT_AMT) {
		this.COMP_LRD_LC_PYMT_AMT = COMP_LRD_LC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_REPAY_PROD_DESC_LABEL() {
		return COMP_UI_M_REPAY_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REPAY_PROD_DESC() {
		return COMP_UI_M_REPAY_PROD_DESC;
	}

	public void setCOMP_UI_M_REPAY_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_REPAY_PROD_DESC_LABEL) {
		this.COMP_UI_M_REPAY_PROD_DESC_LABEL = COMP_UI_M_REPAY_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_REPAY_PROD_DESC(HtmlInputText COMP_UI_M_REPAY_PROD_DESC) {
		this.COMP_UI_M_REPAY_PROD_DESC = COMP_UI_M_REPAY_PROD_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_DTL() {
		return COMP_UI_M_BUT_MAIN_DTL;
	}

	public void setCOMP_UI_M_BUT_MAIN_DTL(HtmlCommandButton COMP_UI_M_BUT_MAIN_DTL) {
		this.COMP_UI_M_BUT_MAIN_DTL = COMP_UI_M_BUT_MAIN_DTL;
	}

	public PT_IL_LOAN_REPAYMENT_DTL getPT_IL_LOAN_REPAYMENT_DTL_BEAN() {
		return PT_IL_LOAN_REPAYMENT_DTL_BEAN;
	}

	public void setPT_IL_LOAN_REPAYMENT_DTL_BEAN(PT_IL_LOAN_REPAYMENT_DTL PT_IL_LOAN_REPAYMENT_DTL_BEAN) {
		this.PT_IL_LOAN_REPAYMENT_DTL_BEAN = PT_IL_LOAN_REPAYMENT_DTL_BEAN;
	}
	
	public void bodyOnLoad(ActionEvent ae) throws DBException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		String LOAN_REF_NO = (String) sessionMap.get("LOAN_REF_NO");
//		System.out.println("LOAN_REF_NO = "+LOAN_REF_NO);
		CommonUtils.clearMaps(this);
		getRepaymentDetail().clear();
		
		String query = "SELECT A.LRD_PROD_CODE,A.LRD_FC_PYMT_AMT,A.LRD_LC_PYMT_AMT " +
				"FROM PT_IL_LOAN_REPAYMENT_DTL A,PT_IL_LOAN_REPAYMENT B,PT_IL_LOAN C " +
				"WHERE B.LR_LOAN_SYS_ID = A.LRD_LOAN_SYS_ID AND B.LR_SYS_ID = A.LRD_LR_SYS_ID" +
				" AND B.LR_LOAN_SYS_ID = C.LOAN_SYS_ID AND C.LOAN_REF_NO = '"+LOAN_REF_NO+"'";
		
//		System.out.println("Actual Query = "+query);
		
		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		
		List<PT_IL_LOAN_REPAYMENT_DTL> result = handler.fetch(query, "com.iii.pel.forms.PILT005.PT_IL_LOAN_REPAYMENT_DTL", con);
//		repaymentDetail = (ArrayList<PT_IL_LOAN_REPAYMENT_DTL>) result;
		
	}
	
	public String repaymentNavigation(){
		return "PILT005_REPAYMENT_DTLS";
	}
}

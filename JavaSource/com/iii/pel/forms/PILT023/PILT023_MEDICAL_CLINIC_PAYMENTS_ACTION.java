package com.iii.pel.forms.PILT023;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
/*import com.iii.pel.forms.PILP205.PILP205_ACTION;
import com.iii.pel.forms.PILP205.PILP205_DELEGATE;
import com.iii.pel.forms.PILP205.PILP205_PT_IL_WAK_PAYMENTS_DTL;
import com.iii.pel.forms.PILP205.PT_IL_WAK_PAYMENTS_CHARGE;
import com.iii.pel.forms.PILP205.PT_IL_WAK_STATUS;*/
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILT023_MEDICAL_CLINIC_PAYMENTS_ACTION extends CommonAction {

	public PILT023_COMPOSITE_ACTION compositeAction;
	
	
	private PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN;
	private PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER PILT023_HELPER;
	
	private PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE PILT023_DELEGATE;
	
	private HtmlOutputLabel COMP_MFD_PROP_NO_LABEL;
	
	private HtmlInputText COMP_MFD_PROP_NO;
	
	private HtmlOutputLabel COMP_NEW_ICNO_LABEL;
	
	private HtmlInputText COMP_NEW_ICNO;
	
	private HtmlOutputLabel COMP_OLD_ICNO_LABEL;
	
	private HtmlInputText COMP_OLD_ICNO;
	
	private HtmlOutputLabel COMP_MFD_EXAM_CODE_LABEL;
	
	private HtmlInputText COMP_MFD_EXAM_CODE;
	
	private HtmlOutputLabel COMP_MFD_EXAM_DT_LABEL;
	
	private HtmlCalendar COMP_MFD_EXAM_DT;
	
	private HtmlOutputLabel COMP_MFD_CURR_CODE_LABEL;
	
	private HtmlInputText COMP_MFD_CURR_CODE;
	
	private HtmlOutputLabel COMP_MFD_FC_VALUE_LABEL;
	
	private HtmlInputText COMP_MFD_FC_VALUE;
	
	private HtmlOutputLabel COMP_MFD_INV_REF_NO_LABEL;
	
	private HtmlInputTextarea COMP_MFD_INV_REF_NO;
	
	private HtmlOutputLabel COMP_MFD_PYMT_TO_LABEL;
	
	private HtmlSelectOneMenu COMP_MFD_PYMT_TO;
	
	private HtmlOutputLabel COMP_MFD_FRZ_FLAG_LABEL;
	
	private HtmlSelectOneMenu COMP_MFD_FRZ_FLAG;
	
	private HtmlOutputLabel COMP_MFD_LC_VALUE_LABEL;
	
	private HtmlInputText COMP_MFD_LC_VALUE;
	
	private HtmlOutputLabel COMP_MFD_POL_NO_LABEL;
	
	private HtmlInputText COMP_MFD_POL_NO;
	
	private HtmlOutputLabel COMP_MFD_POL_CONT_CODE_LABEL;
	
	private HtmlInputText COMP_MFD_POL_CONT_CODE;
	
	private HtmlInputText COMP_M_MFD_POL_CONT_NAME;
	
	private HtmlOutputLabel COMP_M_MFD_EXAM_CODE_DESC_LABEL;
	
	private HtmlInputText COMP_M_MFD_EXAM_CODE_DESC;
	
	private HtmlOutputLabel COMP_M_MFD_CURR_CODE_DESC_LABEL;
	
	private HtmlInputText COMP_M_MFD_CURR_CODE_DESC;
	
	private HtmlOutputLabel COMP_MFD_REMARKS_LABEL;
	
	private HtmlInputTextarea COMP_MFD_REMARKS;
	
	private HtmlCommandButton COMP_UI_Pymt_Query;
	
	private HtmlCommandButton COMP_UI_Approve;
	
	private UIData medDatatable;
	
	private HtmlTab MED_TAB_1;
	
	private HtmlTabPanel COMP_TAB_PANEL;
	
	private List<PT_IL_MEDEX_FEE_DTL> medicalDataList = new ArrayList<PT_IL_MEDEX_FEE_DTL>();
	
	private List<SelectItem> listRT_Paid_To = new ArrayList<SelectItem>();
	
	private List<SelectItem> listFrz_YN = new ArrayList<SelectItem>();
	
	private List<LovBean> lovList = new ArrayList<LovBean>();
	
	//Dummy Field
	
	private DUMMY DUMMY_BEAN;
	
	private HtmlOutputLabel COMP_MFD_CLINIC_CODE_LABEL;
	
	private HtmlInputText COMP_MFD_CLINIC_CODE;
	
	private HtmlInputText COMP_M_CLINIC_CODE_DESC;
	
	private HtmlOutputText COMP_APPROVE_STATUS_LABEL;
	
	private HtmlOutputText COMP_APPROVE_DATE_LABEL;
	
		
	public PT_IL_MEDEX_FEE_DTL getPT_IL_MEDEX_FEE_DTL_BEAN() {
		return PT_IL_MEDEX_FEE_DTL_BEAN;
	}

	public void setPT_IL_MEDEX_FEE_DTL_BEAN(
			PT_IL_MEDEX_FEE_DTL pT_IL_MEDEX_FEE_DTL_BEAN) {
		PT_IL_MEDEX_FEE_DTL_BEAN = pT_IL_MEDEX_FEE_DTL_BEAN;
	}

	public PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER getPILT023_HELPER() {
		return PILT023_HELPER;
	}

	public void setPILT023_HELPER(
			PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER pILT023_HELPER) {
		PILT023_HELPER = pILT023_HELPER;
	}

	public PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE getPILT023_DELEGATE() {
		return PILT023_DELEGATE;
	}

	public void setPILT023_DELEGATE(
			PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE pILT023_DELEGATE) {
		PILT023_DELEGATE = pILT023_DELEGATE;
	}

	public HtmlOutputLabel getCOMP_MFD_PROP_NO_LABEL() {
		return COMP_MFD_PROP_NO_LABEL;
	}

	public void setCOMP_MFD_PROP_NO_LABEL(HtmlOutputLabel cOMP_MFD_PROP_NO_LABEL) {
		COMP_MFD_PROP_NO_LABEL = cOMP_MFD_PROP_NO_LABEL;
	}

	public HtmlInputText getCOMP_MFD_PROP_NO() {
		return COMP_MFD_PROP_NO;
	}

	public void setCOMP_MFD_PROP_NO(HtmlInputText cOMP_MFD_PROP_NO) {
		COMP_MFD_PROP_NO = cOMP_MFD_PROP_NO;
	}

	public HtmlOutputLabel getCOMP_NEW_ICNO_LABEL() {
		return COMP_NEW_ICNO_LABEL;
	}

	public void setCOMP_NEW_ICNO_LABEL(HtmlOutputLabel cOMP_NEW_ICNO_LABEL) {
		COMP_NEW_ICNO_LABEL = cOMP_NEW_ICNO_LABEL;
	}

	public HtmlInputText getCOMP_NEW_ICNO() {
		return COMP_NEW_ICNO;
	}

	public void setCOMP_NEW_ICNO(HtmlInputText cOMP_NEW_ICNO) {
		COMP_NEW_ICNO = cOMP_NEW_ICNO;
	}

	public HtmlOutputLabel getCOMP_OLD_ICNO_LABEL() {
		return COMP_OLD_ICNO_LABEL;
	}

	public void setCOMP_OLD_ICNO_LABEL(HtmlOutputLabel cOMP_OLD_ICNO_LABEL) {
		COMP_OLD_ICNO_LABEL = cOMP_OLD_ICNO_LABEL;
	}

	public HtmlInputText getCOMP_OLD_ICNO() {
		return COMP_OLD_ICNO;
	}

	public void setCOMP_OLD_ICNO(HtmlInputText cOMP_OLD_ICNO) {
		COMP_OLD_ICNO = cOMP_OLD_ICNO;
	}

	public HtmlOutputLabel getCOMP_MFD_EXAM_CODE_LABEL() {
		return COMP_MFD_EXAM_CODE_LABEL;
	}

	public void setCOMP_MFD_EXAM_CODE_LABEL(HtmlOutputLabel cOMP_MFD_EXAM_CODE_LABEL) {
		COMP_MFD_EXAM_CODE_LABEL = cOMP_MFD_EXAM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_EXAM_CODE() {
		return COMP_MFD_EXAM_CODE;
	}

	public void setCOMP_MFD_EXAM_CODE(HtmlInputText cOMP_MFD_EXAM_CODE) {
		COMP_MFD_EXAM_CODE = cOMP_MFD_EXAM_CODE;
	}

	public HtmlOutputLabel getCOMP_MFD_EXAM_DT_LABEL() {
		return COMP_MFD_EXAM_DT_LABEL;
	}

	public void setCOMP_MFD_EXAM_DT_LABEL(HtmlOutputLabel cOMP_MFD_EXAM_DT_LABEL) {
		COMP_MFD_EXAM_DT_LABEL = cOMP_MFD_EXAM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_MFD_EXAM_DT() {
		return COMP_MFD_EXAM_DT;
	}

	public void setCOMP_MFD_EXAM_DT(HtmlCalendar cOMP_MFD_EXAM_DT) {
		COMP_MFD_EXAM_DT = cOMP_MFD_EXAM_DT;
	}

	public HtmlOutputLabel getCOMP_MFD_CURR_CODE_LABEL() {
		return COMP_MFD_CURR_CODE_LABEL;
	}

	public void setCOMP_MFD_CURR_CODE_LABEL(HtmlOutputLabel cOMP_MFD_CURR_CODE_LABEL) {
		COMP_MFD_CURR_CODE_LABEL = cOMP_MFD_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_CURR_CODE() {
		return COMP_MFD_CURR_CODE;
	}

	public void setCOMP_MFD_CURR_CODE(HtmlInputText cOMP_MFD_CURR_CODE) {
		COMP_MFD_CURR_CODE = cOMP_MFD_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_MFD_FC_VALUE_LABEL() {
		return COMP_MFD_FC_VALUE_LABEL;
	}

	public void setCOMP_MFD_FC_VALUE_LABEL(HtmlOutputLabel cOMP_MFD_FC_VALUE_LABEL) {
		COMP_MFD_FC_VALUE_LABEL = cOMP_MFD_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FC_VALUE() {
		return COMP_MFD_FC_VALUE;
	}

	public void setCOMP_MFD_FC_VALUE(HtmlInputText cOMP_MFD_FC_VALUE) {
		COMP_MFD_FC_VALUE = cOMP_MFD_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_MFD_INV_REF_NO_LABEL() {
		return COMP_MFD_INV_REF_NO_LABEL;
	}

	public void setCOMP_MFD_INV_REF_NO_LABEL(
			HtmlOutputLabel cOMP_MFD_INV_REF_NO_LABEL) {
		COMP_MFD_INV_REF_NO_LABEL = cOMP_MFD_INV_REF_NO_LABEL;
	}

	public HtmlInputTextarea getCOMP_MFD_INV_REF_NO() {
		return COMP_MFD_INV_REF_NO;
	}

	public void setCOMP_MFD_INV_REF_NO(HtmlInputTextarea cOMP_MFD_INV_REF_NO) {
		COMP_MFD_INV_REF_NO = cOMP_MFD_INV_REF_NO;
	}

	public HtmlOutputLabel getCOMP_MFD_PYMT_TO_LABEL() {
		return COMP_MFD_PYMT_TO_LABEL;
	}

	public void setCOMP_MFD_PYMT_TO_LABEL(HtmlOutputLabel cOMP_MFD_PYMT_TO_LABEL) {
		COMP_MFD_PYMT_TO_LABEL = cOMP_MFD_PYMT_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MFD_PYMT_TO() {
		return COMP_MFD_PYMT_TO;
	}

	public void setCOMP_MFD_PYMT_TO(HtmlSelectOneMenu cOMP_MFD_PYMT_TO) {
		COMP_MFD_PYMT_TO = cOMP_MFD_PYMT_TO;
	}

	public HtmlOutputLabel getCOMP_MFD_FRZ_FLAG_LABEL() {
		return COMP_MFD_FRZ_FLAG_LABEL;
	}

	public void setCOMP_MFD_FRZ_FLAG_LABEL(HtmlOutputLabel cOMP_MFD_FRZ_FLAG_LABEL) {
		COMP_MFD_FRZ_FLAG_LABEL = cOMP_MFD_FRZ_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MFD_FRZ_FLAG() {
		return COMP_MFD_FRZ_FLAG;
	}

	public void setCOMP_MFD_FRZ_FLAG(HtmlSelectOneMenu cOMP_MFD_FRZ_FLAG) {
		COMP_MFD_FRZ_FLAG = cOMP_MFD_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_MFD_LC_VALUE_LABEL() {
		return COMP_MFD_LC_VALUE_LABEL;
	}

	public void setCOMP_MFD_LC_VALUE_LABEL(HtmlOutputLabel cOMP_MFD_LC_VALUE_LABEL) {
		COMP_MFD_LC_VALUE_LABEL = cOMP_MFD_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_LC_VALUE() {
		return COMP_MFD_LC_VALUE;
	}

	public void setCOMP_MFD_LC_VALUE(HtmlInputText cOMP_MFD_LC_VALUE) {
		COMP_MFD_LC_VALUE = cOMP_MFD_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_MFD_POL_NO_LABEL() {
		return COMP_MFD_POL_NO_LABEL;
	}

	public void setCOMP_MFD_POL_NO_LABEL(HtmlOutputLabel cOMP_MFD_POL_NO_LABEL) {
		COMP_MFD_POL_NO_LABEL = cOMP_MFD_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_MFD_POL_NO() {
		return COMP_MFD_POL_NO;
	}

	public void setCOMP_MFD_POL_NO(HtmlInputText cOMP_MFD_POL_NO) {
		COMP_MFD_POL_NO = cOMP_MFD_POL_NO;
	}

	public HtmlOutputLabel getCOMP_MFD_POL_CONT_CODE_LABEL() {
		return COMP_MFD_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_MFD_POL_CONT_CODE_LABEL(
			HtmlOutputLabel cOMP_MFD_POL_CONT_CODE_LABEL) {
		COMP_MFD_POL_CONT_CODE_LABEL = cOMP_MFD_POL_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_POL_CONT_CODE() {
		return COMP_MFD_POL_CONT_CODE;
	}

	public void setCOMP_MFD_POL_CONT_CODE(HtmlInputText cOMP_MFD_POL_CONT_CODE) {
		COMP_MFD_POL_CONT_CODE = cOMP_MFD_POL_CONT_CODE;
	}

	public HtmlInputText getCOMP_M_MFD_POL_CONT_NAME() {
		return COMP_M_MFD_POL_CONT_NAME;
	}

	public void setCOMP_M_MFD_POL_CONT_NAME(HtmlInputText cOMP_M_MFD_POL_CONT_NAME) {
		COMP_M_MFD_POL_CONT_NAME = cOMP_M_MFD_POL_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_M_MFD_EXAM_CODE_DESC_LABEL() {
		return COMP_M_MFD_EXAM_CODE_DESC_LABEL;
	}

	public void setCOMP_M_MFD_EXAM_CODE_DESC_LABEL(
			HtmlOutputLabel cOMP_M_MFD_EXAM_CODE_DESC_LABEL) {
		COMP_M_MFD_EXAM_CODE_DESC_LABEL = cOMP_M_MFD_EXAM_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_M_MFD_EXAM_CODE_DESC() {
		return COMP_M_MFD_EXAM_CODE_DESC;
	}

	public void setCOMP_M_MFD_EXAM_CODE_DESC(HtmlInputText cOMP_M_MFD_EXAM_CODE_DESC) {
		COMP_M_MFD_EXAM_CODE_DESC = cOMP_M_MFD_EXAM_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_M_MFD_CURR_CODE_DESC_LABEL() {
		return COMP_M_MFD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_M_MFD_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel cOMP_M_MFD_CURR_CODE_DESC_LABEL) {
		COMP_M_MFD_CURR_CODE_DESC_LABEL = cOMP_M_MFD_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_M_MFD_CURR_CODE_DESC() {
		return COMP_M_MFD_CURR_CODE_DESC;
	}

	public void setCOMP_M_MFD_CURR_CODE_DESC(HtmlInputText cOMP_M_MFD_CURR_CODE_DESC) {
		COMP_M_MFD_CURR_CODE_DESC = cOMP_M_MFD_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_MFD_REMARKS_LABEL() {
		return COMP_MFD_REMARKS_LABEL;
	}

	public void setCOMP_MFD_REMARKS_LABEL(HtmlOutputLabel cOMP_MFD_REMARKS_LABEL) {
		COMP_MFD_REMARKS_LABEL = cOMP_MFD_REMARKS_LABEL;
	}

	public HtmlInputTextarea getCOMP_MFD_REMARKS() {
		return COMP_MFD_REMARKS;
	}

	public void setCOMP_MFD_REMARKS(HtmlInputTextarea cOMP_MFD_REMARKS) {
		COMP_MFD_REMARKS = cOMP_MFD_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_Pymt_Query() {
		return COMP_UI_Pymt_Query;
	}

	public void setCOMP_UI_Pymt_Query(HtmlCommandButton cOMP_UI_Pymt_Query) {
		COMP_UI_Pymt_Query = cOMP_UI_Pymt_Query;
	}

	public HtmlCommandButton getCOMP_UI_Approve() {
		return COMP_UI_Approve;
	}

	public void setCOMP_UI_Approve(HtmlCommandButton cOMP_UI_Approve) {
		COMP_UI_Approve = cOMP_UI_Approve;
	}

	public UIData getMedDatatable() {
		return medDatatable;
	}

	public void setMedDatatable(UIData medDatatable) {
		this.medDatatable = medDatatable;
	}

	public List<PT_IL_MEDEX_FEE_DTL> getMedicalDataList() {
		return medicalDataList;
	}

	public void setMedicalDataList(List<PT_IL_MEDEX_FEE_DTL> medicalDataList) {
		this.medicalDataList = medicalDataList;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dUMMY_BEAN) {
		DUMMY_BEAN = dUMMY_BEAN;
	}

	public HtmlOutputLabel getCOMP_MFD_CLINIC_CODE_LABEL() {
		return COMP_MFD_CLINIC_CODE_LABEL;
	}

	public void setCOMP_MFD_CLINIC_CODE_LABEL(
			HtmlOutputLabel cOMP_MFD_CLINIC_CODE_LABEL) {
		COMP_MFD_CLINIC_CODE_LABEL = cOMP_MFD_CLINIC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_CLINIC_CODE() {
		return COMP_MFD_CLINIC_CODE;
	}

	public void setCOMP_MFD_CLINIC_CODE(HtmlInputText cOMP_MFD_CLINIC_CODE) {
		COMP_MFD_CLINIC_CODE = cOMP_MFD_CLINIC_CODE;
	}

	public HtmlInputText getCOMP_M_CLINIC_CODE_DESC() {
		return COMP_M_CLINIC_CODE_DESC;
	}

	public void setCOMP_M_CLINIC_CODE_DESC(HtmlInputText cOMP_M_CLINIC_CODE_DESC) {
		COMP_M_CLINIC_CODE_DESC = cOMP_M_CLINIC_CODE_DESC;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List<SelectItem> getListRT_Paid_To() {
		return listRT_Paid_To;
	}

	public void setListRT_Paid_To(List<SelectItem> listRT_Paid_To) {
		this.listRT_Paid_To = listRT_Paid_To;
	}

	public List<SelectItem> getListFrz_YN() {
		return listFrz_YN;
	}

	public void setListFrz_YN(List<SelectItem> listFrz_YN) {
		this.listFrz_YN = listFrz_YN;
	}
	
	public List<LovBean> getLovList() {
		return lovList;
	}

	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}
	
	public HtmlTab getMED_TAB_1() {
		return MED_TAB_1;
	}

	public void setMED_TAB_1(HtmlTab mED_TAB_1) {
		MED_TAB_1 = mED_TAB_1;
	}
	
	public HtmlTabPanel getCOMP_TAB_PANEL() {
		return COMP_TAB_PANEL;
	}

	public void setCOMP_TAB_PANEL(HtmlTabPanel cOMP_TAB_PANEL) {
		COMP_TAB_PANEL = cOMP_TAB_PANEL;
	}
	
	public HtmlOutputText getCOMP_APPROVE_STATUS_LABEL() {
		return COMP_APPROVE_STATUS_LABEL;
	}

	public void setCOMP_APPROVE_STATUS_LABEL(
			HtmlOutputText cOMP_APPROVE_STATUS_LABEL) {
		COMP_APPROVE_STATUS_LABEL = cOMP_APPROVE_STATUS_LABEL;
	}

	public HtmlOutputText getCOMP_APPROVE_DATE_LABEL() {
		return COMP_APPROVE_DATE_LABEL;
	}

	public void setCOMP_APPROVE_DATE_LABEL(HtmlOutputText cOMP_APPROVE_DATE_LABEL) {
		COMP_APPROVE_DATE_LABEL = cOMP_APPROVE_DATE_LABEL;
	}

	public PILT023_MEDICAL_CLINIC_PAYMENTS_ACTION() {
		// TODO Auto-generated constructor stub
		PT_IL_MEDEX_FEE_DTL_BEAN = new PT_IL_MEDEX_FEE_DTL();
		PILT023_HELPER = new PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER();
		PILT023_DELEGATE = new PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE();
		DUMMY_BEAN = new DUMMY();
		prepareMedDropDownList();
		initializeAllComponent();
		//resetAllComponent();
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			System.out.println("PILT023 onload");
			
			if (isBlockFlag()) {
				System.out.println("isBlockFlag() =====================>> ==========>>"+isBlockFlag());
				new PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER().executeQuery(compositeAction);
				//PILT023_HELPER.executeQueryData(compositeAction);
				
				System.out.println("WM_MFD_CURR_CODE_DESC    : "+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getWM_MFD_POL_CONT_NAME());
						
				System.out.println("122233 ================"+PT_IL_MEDEX_FEE_DTL_BEAN.getWM_MFD_POL_CONT_NAME());
				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_STATUS("Y");
				resetAllComponent();
				
				/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
				if("APPROVED".equalsIgnoreCase(compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getWM_APPRV_STATUS()))
				{
					//Added by saritha on 09-05-2018
					getTotalClinicPaid_Amt();
					disableAllComponent(true);
					
				}
				/* End */
				
				/*Added by Ameen on 04-12-2017 for ZBLIFE-1458892*/

				/*Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				if(PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() == null){
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO("C");
					compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getCOMP_MFD_PYMT_TO().setDisabled(true);
				}else{
					getCOMP_MFD_CLINIC_CODE().setDisabled(true);
					getCOMP_MFD_PYMT_TO().setDisabled(false);

				}
				/* End */

				setBlockFlag(false);

				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/

				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PAID_FLAG()!=null && PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PAID_FLAG().equalsIgnoreCase("Y")){

					COMP_CREATE_BUTTON.setDisabled(true);
					COMP_DELETE_BUTTON.setDisabled(true);
					COMP_SAVE_BUTTON.setDisabled(true);

				}else{
					COMP_CREATE_BUTTON.setDisabled(false);
					COMP_DELETE_BUTTON.setDisabled(false);
					COMP_SAVE_BUTTON.setDisabled(false);

				}

				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG()!=null && "Y".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG()))
				{
					COMP_MFD_PYMT_TO.setDisabled(true);
					COMP_MFD_REMARKS.setDisabled(true);
					COMP_MFD_LC_VALUE.setDisabled(true);
					COMP_MFD_FC_VALUE.setDisabled(true);
					COMP_MFD_INV_REF_NO.setDisabled(true);
					COMP_MFD_FLEX_01.setDisabled(true);
					COMP_MFD_FLEX_02.setDisabled(true);
					COMP_MFD_FLEX_03.setDisabled(true);
					COMP_MFD_FLEX_04.setDisabled(true);
					COMP_MFD_FLEX_05.setDisabled(true);
					COMP_MFD_FLEX_06.setDisabled(true);

				}else
				{

					COMP_MFD_REMARKS.setDisabled(false);
					COMP_MFD_LC_VALUE.setDisabled(false);
					COMP_MFD_FC_VALUE.setDisabled(false);
					COMP_MFD_INV_REF_NO.setDisabled(false);
					COMP_MFD_FLEX_01.setDisabled(false);
					COMP_MFD_FLEX_02.setDisabled(false);
					COMP_MFD_FLEX_03.setDisabled(false);
					COMP_MFD_FLEX_04.setDisabled(false);
					COMP_MFD_FLEX_05.setDisabled(false);
					COMP_MFD_FLEX_06.setDisabled(false);

				}

				/*Added by saritha on 21-04-2018 for KIC Medical Clinic Payment Issues*/
				
				String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));
				System.out.println("clinicDetailsParam ----->" +clinicDetailsParam );

				if(clinicDetailsParam.equalsIgnoreCase("1")){

					COMP_UI_PROCESS.setRendered(true);
					COMP_MFD_FROM_DT_LABEL.setRendered(true);
					COMP_MFD_TO_DT_LABEL.setRendered(true);
					COMP_MFD_FROM_DT.setRendered(true);
					COMP_MFD_TO_DT.setRendered(true);
					COMP_MFD_FROM_DT.setRequired(true);
					COMP_MFD_TO_DT.setRequired(true);
					COMP_MFD_FLEX_01.setDisabled(true);
					COMP_MFD_FLEX_02.setDisabled(true);
					COMP_MFD_FLEX_03.setDisabled(true);
					COMP_MFD_FLEX_04.setDisabled(true);
					COMP_UI_M_TOTAL_PAID_AMT_LABEL.setRendered(true);
					COMP_UI_M_TOTAL_PAID_AMT.setRendered(true);
					
				}else{
					COMP_UI_PROCESS.setRendered(false);
					COMP_MFD_FROM_DT_LABEL.setRendered(false);
					COMP_MFD_TO_DT_LABEL.setRendered(false);
					COMP_MFD_FROM_DT.setRendered(false);
					COMP_MFD_TO_DT.setRendered(false);
					COMP_MFD_FROM_DT.setRequired(false);
					COMP_MFD_TO_DT.setRequired(false);
					COMP_UI_M_TOTAL_PAID_AMT_LABEL.setRendered(false);
					COMP_UI_M_TOTAL_PAID_AMT.setRendered(false);
				}
				
				/*End*/
				
			}

			if("APPROVED".equalsIgnoreCase(compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getWM_APPRV_STATUS())){
				COMP_UI_Approve.setDisabled(true);

			}else{
				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG()!=null && PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG().equalsIgnoreCase("N")){
					COMP_UI_Approve.setDisabled(true);

				}else{
					COMP_UI_Approve.setDisabled(false);
				}

			}

			/*End*/

			System.out.println("SysId "+ PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_SYS_ID());
			System.out.println("polSysId "+ PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID());

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	
	/*public void medPost(ActionEvent ae) {
		try {
			System.out.println("inside medPost");
			CRUDHandler handler = new CRUDHandler();
			
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CLINIC_CODE(DUMMY_BEAN.getMFD_CLINIC_CODE());
			
			if (PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_DT(new CommonUtils().getCurrentDate());
					//PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
						System.out.println("rowid not null"+PT_IL_MEDEX_FEE_DTL_BEAN.getROWID());
						System.out.println("rowid not null"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FC_VALUE());
					
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getErrorMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_DT(new CommonUtils().getCurrentDate());
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
					System.out.println("****DT***"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CR_DT());
					System.out.println("****UID***"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CR_UID());
					System.out.println("INSIDE POST INSERT row id null *************");
					
					String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
					ResultSet rs = null;
					if (getErrorMap().size() == 0) {
						rs = handler.executeSelectStatement(qry, CommonUtils.getConnection());
						if (rs.next()) {
							PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_SYS_ID(Long.parseLong(rs.getString(1)));
						}
					}
					String qry2 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
					ResultSet rs2 = null;
					if (getErrorMap().size() == 0) {
						rs2 = handler.executeSelectStatement(qry2, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_NO()});
						if (rs2.next()) {
							PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_SYS_ID(rs2.getLong("POL_SYS_ID"));
						}
					}
					String qry3 = "SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
					ResultSet rs3= null;
					if(getErrorMap().size() == 0){
						rs3 = handler.executeSelectStatement(qry3, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID()});
						if (rs3.next()) {
							PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POAD_SYS_ID(rs3.getLong("POAD_SYS_ID"));
							System.out.println();
						}
					}
					//PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CLINIC_CODE(DUMMY_BEAN.getMFD_CLINIC_CODE());
					System.out.println("duuuuuuuuuuuum"+DUMMY_BEAN.getMFD_CLINIC_CODE());
					System.out.println("duuuuuuuuuuuum222*****::"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CLINIC_CODE());
					System.out.println(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FC_VALUE());
					System.out.println(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_INV_REF_NO());
					new CRUDHandler().executeInsert(PT_IL_MEDEX_FEE_DTL_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					System.out.println("inside insert ading list::"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_NO());
					medicalDataList.add(PT_IL_MEDEX_FEE_DTL_BEAN);
					System.out.println("afrter inside insert adding list ::"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_NO());
				} else {
					getErrorMap().clear();
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getErrorMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/
	
	public void medPost(ActionEvent event) {
    	getErrorMap().clear();
		getWarningMap().clear();
	try {
		PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CLINIC_CODE(DUMMY_BEAN.getMFD_CLINIC_CODE());
		PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_DT(new CommonUtils().getCurrentDate());
		PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		if (PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			/*PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_DT(new CommonUtils().getCurrentDate());
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			System.out.println("****DT***"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CR_DT());
			System.out.println("****UID***"+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CR_UID());
			System.out.println("INSIDE POST INSERT row id null *************");*/
			
			String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
			ResultSet rs = null;
			if (getErrorMap().size() == 0) {
				rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
				if (rs.next()) {
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_SYS_ID(Long.parseLong(rs.getString(1)));
				}
			}
			String qry2 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
			ResultSet rs2 = null;
			if (getErrorMap().size() == 0) {
				rs2 = new CRUDHandler().executeSelectStatement(qry2, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_NO()});
				if (rs2.next()) {
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_SYS_ID(rs2.getLong("POL_SYS_ID"));
				}
			}
			String qry3 = "SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
			ResultSet rs3= null;
			if(getErrorMap().size() == 0){
				rs3 = new CRUDHandler().executeSelectStatement(qry3, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID()});
				if (rs3.next()) {
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POAD_SYS_ID(rs3.getLong("POAD_SYS_ID"));
					System.out.println();
				}
			}
			new CRUDHandler().executeInsert(PT_IL_MEDEX_FEE_DTL_BEAN,
					CommonUtils.getConnection());
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			medicalDataList.add(PT_IL_MEDEX_FEE_DTL_BEAN);
		} else if (PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() != null
				&& isUPDATE_ALLOWED()) {
			System.out.println("PT_IL_MEDEX_FEE_DTL_BEAN         "+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG());
			 /*new CRUDHandler().executeUpdate(PT_IL_MEDEX_FEE_DTL_BEAN,
					CommonUtils.getConnection()); */
			if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG() != null)
			{
				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG().equals("Y"))
				{
					 postUpdate(); 	
					/*getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));*/
				}
				else
				{
					new CRUDHandler().executeUpdate(PT_IL_MEDEX_FEE_DTL_BEAN,
							CommonUtils.getConnection());
				}
			}
			
			 System.out.println("PT_IL_MEDEX_FEE_DTL_BEAN.MFD_CUST_CODE          "+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CUST_CODE());
			/**/
			
			System.out.println("Update Successfully");
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
		}

		PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
		/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
		saveRecord();
		/* End */
	} catch (Exception exc) {
		exc.printStackTrace();
		String temp=extractDBErrorMessage(exc.getMessage());
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + temp);
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + temp);
	}
}
	
	public void postUpdate() throws Exception
	{
		Connection conn = CommonUtils.getConnection();
		
		/*Commentted &Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
		
		/*PreparedStatement ps = conn.prepareStatement("update PT_IL_MEDEX_FEE_DTL set MFD_EXAM_CODE=?, MFD_POL_NO=?, MFD_REMARKS=?, MFD_POL_SYS_ID=?, MFD_INV_REF_NO=?,"
				+ " MFD_FC_VALUE=?, MFD_POAD_SYS_ID=?, MFD_CR_UID=?, MFD_CURR_CODE=?,  MFD_CLINIC_CODE=?, MFD_CUST_CODE=?, MFD_LC_VALUE=?, MFD_PYMT_TO=?,"
				+ "  MFD_SYS_ID=?, MFD_POL_CONT_CODE=?, MFD_FRZ_FLAG=?, MFD_PROP_NO=? where MFD_SYS_ID=?");*/
		
		PreparedStatement ps = conn.prepareStatement("update PT_IL_MEDEX_FEE_DTL set MFD_EXAM_CODE=?, MFD_POL_NO=?, MFD_REMARKS=?, MFD_POL_SYS_ID=?, MFD_INV_REF_NO=?,"
				+ " MFD_FC_VALUE=?, MFD_POAD_SYS_ID=?, MFD_CR_UID=?, MFD_CURR_CODE=?,  MFD_CLINIC_CODE=?, MFD_CUST_CODE=?, MFD_LC_VALUE=?, MFD_PYMT_TO=?,"
				+ "  MFD_SYS_ID=?, MFD_POL_CONT_CODE=?, MFD_FRZ_FLAG=?, MFD_PROP_NO=?, MFD_FLEX_01=?, MFD_FLEX_02=?, MFD_FLEX_03=?, MFD_FLEX_04=?, MFD_FLEX_05=?, MFD_FLEX_06=?,MFD_FROM_DT=?,MFD_TO_DT=? where MFD_SYS_ID=?");
	
		/*End*/
		
		ps.setString(1, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_EXAM_CODE());
		ps.setString(2, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_NO());
		ps.setString(3, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_REMARKS());
		ps.setLong(4, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID());
		ps.setString(5, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_INV_REF_NO());
		
		ps.setDouble(6, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FC_VALUE());
		ps.setLong(7, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POAD_SYS_ID());
		ps.setString(8, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CR_UID());
		ps.setString(9, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CURR_CODE());
		ps.setString(10, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CLINIC_CODE());
		
		ps.setString(11, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CUST_CODE());
		ps.setDouble(12, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_LC_VALUE());
		ps.setString(13, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO());
		ps.setLong(14, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_SYS_ID());
		ps.setString(15, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_CONT_CODE());
		
		ps.setString(16, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG());
		ps.setString(17, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO());
		
		/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	
		ps.setString(18, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01());
		ps.setString(19, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02());
		ps.setString(20, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_03());
		ps.setString(21, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_04());
		ps.setString(22, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_05());
		ps.setString(23, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_06());
		ps.setDate(24, CommonUtils.DBStringToDate(CommonUtils.dateToStringFormatter(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FROM_DT())));
		ps.setDate(25, CommonUtils.DBStringToDate(CommonUtils.dateToStringFormatter(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_TO_DT())));
		ps.setLong(26,   PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_SYS_ID());				
			
		
		/*End*/
		
		ps.executeUpdate();
	}
	
	public static String extractDBErrorMessage(String dbErrorMessage){
		if ((dbErrorMessage != null) ){
			if ((dbErrorMessage.indexOf(":")!=-1) && (dbErrorMessage.indexOf("ORA")!=-1)){
				int index = dbErrorMessage.indexOf(":");
				dbErrorMessage = dbErrorMessage.substring(index+1);
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}else{
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}
		}
		return dbErrorMessage;
	}

	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);

		/*Added by Janani on 13.09.2017 for ZBILQC-1736304*/
		ResultSet resultSet=null;
		ResultSet rs=null;
		Date MFD_UPD_DT = null;
		String MFD_PAID_FLAG = null;
		CRUDHandler handler=new CRUDHandler();

		String updDate = "SELECT MFD_UPD_DT,MFD_PAID_FLAG FROM PT_IL_MEDEX_FEE_DTL WHERE NVL(MFD_FRZ_FLAG,'N') = 'Y' AND NVL(MFD_PAID_FLAG,'N') = 'Y' AND MFD_CLINIC_CODE = ? AND MFD_EXAM_CODE = ? AND MFD_PROP_NO=?";
		/*End*/

		try {
			System.out.println("indide of displayRecords++++++++++++++");
			resetSelectedRow();
			PT_IL_MEDEX_FEE_DTL_BEAN = (PT_IL_MEDEX_FEE_DTL) medDatatable.getRowData();
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
			System.out.println("deeemo*******   ::::::   "+PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO());


			PILT023_HELPER.callMFD_PYMT_TO_PROC(compositeAction,	PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO());


			/*Added by Janani on 13.09.2017 for ZBILQC-1736304*/

			String query = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
			String cust_name = null;
			Connection connection = CommonUtils.getConnection();

			System.out.println("getMFD_CUST_CODE           "+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().
					getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_CUST_CODE());

			resultSet=handler.executeSelectStatement(query, connection,new Object[] {compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().
					getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_CUST_CODE()});

			if(resultSet.next()) {
				cust_name = resultSet.getString("CUST_NAME"); 
			}

			System.out.println("cust_name            "+cust_name);

			PT_IL_MEDEX_FEE_DTL_BEAN.setWM_MFD_POL_CONT_NAME(cust_name);

			System.out.println("getWM_MFD_POL_CONT_NAME              "+PT_IL_MEDEX_FEE_DTL_BEAN.getWM_MFD_POL_CONT_NAME());

			/*End*/

			/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);

			resetAllComponent();

			String clinicCode=compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE();
			String examType=compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_EXAM_CODE();
			String proposalNo  =compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_PROP_NO();

			rs = new CRUDHandler().executeSelectStatement(
					updDate, connection,new Object[]{clinicCode,examType,proposalNo});

			if(rs.next()){
				MFD_UPD_DT = rs.getDate("MFD_UPD_DT");
				MFD_PAID_FLAG = rs.getString("MFD_PAID_FLAG");

				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_APPRV_STATUS("APPROVED");
				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_APPRV_DT(CommonUtils.dateToStringFormat(MFD_UPD_DT));
				disableAllComponent(true);

			}	
			
			/*End*/
			
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	
	public void prepareMedDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			System.out.println("med dropdown");
			listFrz_YN= ListItemUtil.getDropDownListValue(
					connection, "PILT023", "PT_IL_MEDEX_FEE_DTL",
					"PT_IL_MEDEX_FEE_DTL.MFD_FRZ_FLAG", "YESNO");
			
			
			listRT_Paid_To=ListItemUtil.getDropDownListValue(
					connection,  "PILT023", "PT_IL_MEDEX_FEE_DTL", "PT_IL_MEDEX_FEE_DTL.MFD_PYMT_TO", "MED_PAYTO");
					
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}
	
	
	public List<LovBean> prepareSuggestionList_MFD_CLINIC_CODE(Object value) { 
		try {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			ListItemUtil itemUtil = new ListItemUtil();
			String divCD = (String) sessionMap.get("GLOBAL.M_DIVN_CODE");
			System.out.println("divCD **********************"+divCD);
			/*lovList = itemUtil.P_CALL_LOV("PILT023", "DUMMY",
					"MFD_CLINIC_CODE","HOSPITALS", divCD, "HOSPITALS", null, null,
					(String) value);*/
			
			lovList = itemUtil.P_CALL_LOV("PILT023", "DUMMY",
					"MFD_CLINIC_CODE","CLNC", divCD, "HOSPITALS", null, null,
					(String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PDS_CODE_FM_SUGGESTION", e.getMessage());
		} 
		
		/*Added by Ramkumar on 26-4-2016 for TISB POC
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
    	ListItemUtil listitemutil = new ListItemUtil();
    	Object[] values = null;
		String currentValue = (String) value;
		
    	//String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
        String mainQry=
      
                " SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER " +
                " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, " +
                " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) " +
                " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' " +
                " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE " +
                " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) " +
                " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (CUST_CODE LIKE ?  OR CUST_NAME LIKE ? OR CUST_BL_NAME LIKE ? ) " +
                " AND ROWNUM < 20 ORDER BY 1 "; 

				System.out.println(mainQry);
		    try{
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
    
    	    mainQry=prepareCustomerQuery(mainQry,new Object[]{"HOSPITALS"});
    	    	  values =new Object[]{"HOSPITALS",CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE"),
    	    			  currentValue,currentValue,currentValue};
    	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
		    } catch (Exception e) {
    	    e.printStackTrace();
    	}
		    End*/
		return lovList;
	}
	
	/*Added by Ramkumar on 26-4-2016 for TISB POC*/
	 public String prepareCustomerQuery(String CustCodeQuery,Object[] values) {
			ResultSet resultSet=null;
			CRUDHandler handler=new CRUDHandler();
			String query_input="";
			String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
			try {
				Connection connection = CommonUtils.getConnection();
				resultSet=handler.executeSelectStatement(subQry, connection,values);
				if(resultSet.next()) {
					query_input = resultSet.getString("PS_CODE_DESC"); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}  finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			CustCodeQuery=CustCodeQuery.replaceFirst("#",query_input);
			return CustCodeQuery;
		}
	 /*End*/
	 
	private void resetSelectedRow() {
		System.out.println("indide of resetSelectedRow ******************22");
		
		Iterator<PT_IL_MEDEX_FEE_DTL> PT_IL_MEDEX = medicalDataList.iterator();
		while (PT_IL_MEDEX.hasNext()) {
			PT_IL_MEDEX.next().setRowSelected(false);
		}
	}
	
public void resetAllComponent(){
	System.out.println("reset start");
	COMP_MFD_PROP_NO.resetValue();
	COMP_NEW_ICNO.resetValue();
	COMP_OLD_ICNO.resetValue();
	COMP_MFD_EXAM_CODE.resetValue();
	COMP_MFD_EXAM_DT.resetValue();
	COMP_MFD_CURR_CODE.resetValue();
	COMP_MFD_FC_VALUE.resetValue();
	COMP_MFD_INV_REF_NO.resetValue();
	COMP_MFD_PYMT_TO.resetValue();
	COMP_MFD_FRZ_FLAG.resetValue();
	
	COMP_MFD_LC_VALUE.resetValue();
	COMP_MFD_POL_NO.resetValue();
	COMP_MFD_POL_CONT_CODE.resetValue();
	COMP_M_MFD_POL_CONT_NAME.resetValue();
	COMP_M_MFD_EXAM_CODE_DESC.resetValue();
	COMP_M_MFD_CURR_CODE_DESC.resetValue();
	COMP_MFD_REMARKS.resetValue();
	//COMP_MFD_CLINIC_CODE.resetValue();
	//COMP_M_CLINIC_CODE_DESC.resetValue();
	/*Added by Ameen on 04-12-2017 for ZBLIFE-1458892*/
	COMP_MFD_FLEX_01.resetValue();
	COMP_UI_M_MFD_BANK_DESC.resetValue();
	COMP_MFD_FLEX_02.resetValue();
	COMP_UI_M_DIVN_CODE.resetValue();
	COMP_MFD_FLEX_03.resetValue();
	COMP_MFD_FLEX_04.resetValue();
	COMP_MFD_FLEX_05.resetValue();
	/*end*/
	
	/*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
	COMP_MFD_FROM_DT.resetValue();
	COMP_MFD_TO_DT.resetValue();
	/*End*/
	
/*Added by saritha on 04-05-2018 for KIC*/
	
	COMP_UI_M_TOTAL_PAID_AMT.resetValue();
	
	/*End*/
	System.out.println("reset end");
	}

public void initializeAllComponent(){
	System.out.println("instaniate start");
	COMP_MFD_PROP_NO=new HtmlInputText();
	COMP_NEW_ICNO=new HtmlInputText();
	COMP_OLD_ICNO=new HtmlInputText();
	COMP_MFD_EXAM_CODE=new HtmlInputText();
	COMP_MFD_EXAM_DT=new HtmlCalendar();
	COMP_MFD_CURR_CODE=new HtmlInputText();
	COMP_MFD_FC_VALUE=new HtmlInputText();
	COMP_MFD_INV_REF_NO=new HtmlInputTextarea();
	COMP_MFD_PYMT_TO=new HtmlSelectOneMenu();
	COMP_MFD_FRZ_FLAG=new HtmlSelectOneMenu();
	
	COMP_MFD_LC_VALUE=new HtmlInputText();
	COMP_MFD_POL_NO=new HtmlInputText();
	COMP_MFD_POL_CONT_CODE=new HtmlInputText();
	COMP_M_MFD_POL_CONT_NAME=new HtmlInputText();
	COMP_M_MFD_EXAM_CODE_DESC=new HtmlInputText();
	COMP_M_MFD_CURR_CODE_DESC=new HtmlInputText();
	COMP_MFD_REMARKS=new HtmlInputTextarea();
	COMP_MFD_FLEX_01=new HtmlInputText();
	COMP_MFD_FLEX_02=new HtmlInputText();
	COMP_MFD_FLEX_03=new HtmlInputText();
	COMP_MFD_FLEX_04=new HtmlInputText();
	COMP_MFD_FLEX_05=new HtmlInputText();
	COMP_MFD_FLEX_06=new HtmlInputText();
	
	/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	COMP_MFD_CLINIC_CODE_LABEL = new HtmlOutputLabel();
	COMP_MFD_CLINIC_CODE      = new HtmlInputText();
	COMP_CREATE_BUTTON = new HtmlAjaxCommandButton();
	COMP_DELETE_BUTTON = new HtmlAjaxCommandButton();
	COMP_SAVE_BUTTON   = new HtmlAjaxCommandButton();
	COMP_UI_Approve    = new HtmlCommandButton();
	/*End*/
	
	/*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
	
	COMP_MFD_FROM_DT  = new HtmlCalendar();
	COMP_MFD_TO_DT    = new HtmlCalendar();
	COMP_UI_PROCESS   = new HtmlCommandButton();
	
	/*End*/
	
	COMP_MFD_PROP_NO_LABEL = new HtmlOutputLabel();
	COMP_MFD_POL_NO_LABEL = new HtmlOutputLabel();
	
	/*Added by saritha on 09-05-2018*/
	COMP_UI_M_TOTAL_PAID_AMT = new HtmlInputText();
	COMP_UI_M_TOTAL_PAID_AMT_LABEL = new HtmlOutputLabel();
	/*end*/
	
	System.out.println("instaniate end");
	}
	
	public void medAdd(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {

				PT_IL_MEDEX_FEE_DTL_BEAN = new PT_IL_MEDEX_FEE_DTL();
				resetAllComponent();
				resetSelectedRow();
				System.out.println(" inside medAdd===========");	
			
			}else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}
	
	public void medDelete(ActionEvent event){
		System.out.println("deleteRecord");
		try {
			System.out.println("insert delete roooooow");

			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_MEDEX_FEE_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				medicalDataList.remove(PT_IL_MEDEX_FEE_DTL_BEAN);
				if (medicalDataList.size() > 0) {

					PT_IL_MEDEX_FEE_DTL_BEAN = medicalDataList.get(0);
				} else if (medicalDataList.size() == 0) {

					medAdd(null);
				}

				resetAllComponent();
				PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}
	
	
	
	public void validateMFD_CLINIC_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String CLINIC_CODE = (String)value;
			/*System.out.println("valid ::"+CLINIC_CODE);
			DUMMY_BEAN.setMFD_CLINIC_CODE(CLINIC_CODE);*/
			/*HELPER.valiWP_STATE_CODE(WP_STATE_CODE,PILP205_BEAN);*/
			/*PILT023_HELPER.getClinicDetails(compositeAction);*/
			COMP_MFD_CLINIC_CODE.setDisabled(true);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*Commentted &Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/ 
	
	/*public void MFD_CLINIC_CODEfireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		//ErrorHelpUtil.validate(input, getErrorMap());
		String bankCodeQry="";
		ResultSet rs = null;
		try {
			System.out.println("valid ::"+input.getSubmittedValue());
			DUMMY_BEAN.setMFD_CLINIC_CODE((String)input.getSubmittedValue());
			PILT023_HELPER.getClinicDetails(compositeAction);
			
			 Added by Ameen on 06-12-2017 for ZBLIFE-1458892 
			bankCodeQry="SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
					+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME FROM PM_CUSTOMER,"
					+ "FM_BANK,PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE = CUST_CODE AND BANK_CODE = "
					+ "CBAD_CUST_BANK_CODE AND CUST_CODE = ?";
			rs = new CRUDHandler().executeSelectStatement(bankCodeQry, CommonUtils.getConnection(),
							new Object[]{DUMMY_BEAN.getMFD_CLINIC_CODE()});
			if(rs.next()){
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));
				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement
							(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
					if(sortCodeRS.next()){
						PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));
			}
			COMP_MFD_FLEX_01.resetValue();
			COMP_UI_M_MFD_BANK_DESC.resetValue();
			COMP_MFD_FLEX_02.resetValue();
			COMP_UI_M_DIVN_CODE.resetValue();
			COMP_MFD_FLEX_03.resetValue();
			COMP_MFD_FLEX_04.resetValue();
			COMP_MFD_FLEX_05.resetValue();
			End
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	public void MFD_CLINIC_CODEfireFieldValidation(ActionEvent actionEvent) {
		getErrorMap().clear();
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();

		Connection con=null;
		/*String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
		ResultSet sortCodeRS = null;*/
		ResultSet rs = null;
		try{
			
			DUMMY_BEAN.setMFD_CLINIC_CODE((String)input.getSubmittedValue());
			System.out.println("valid ::"+input.getSubmittedValue());
			if(DUMMY_BEAN.getMFD_CLINIC_CODE()!=null){
				PILT023_HELPER.getClinicDetails(compositeAction);
				
			}
			
			/*con = CommonUtils.getConnection();

			rs = validateBankDetails();

			if(rs!=null && rs.next()){					
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));

				if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
					sortCodeRS = new CRUDHandler().executeSelectStatement(sortCodeQry, con,new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
					if(sortCodeRS.next()){
						PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}

				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));

			}

			COMP_MFD_FLEX_01.resetValue();
			COMP_UI_M_MFD_BANK_DESC.resetValue();
			COMP_MFD_FLEX_02.resetValue();
			COMP_UI_M_DIVN_CODE.resetValue();
			COMP_MFD_FLEX_03.resetValue();
			COMP_MFD_FLEX_04.resetValue();
			COMP_MFD_FLEX_05.resetValue();*/
			COMP_MFD_CLINIC_CODE.setDisabled(true);
			
			//ErrorHelpUtil.validate(input, getErrorMap());

		} catch (Exception exception) {
			exception.printStackTrace();

			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rs);
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "MFD_CLINIC_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	 
	 /*End*/
	
	
	public void validateMFD_PROP_NO(FacesContext context,
			UIComponent component, Object value){
		try{
			String PROP_NO = (String)value;
			System.out.println("valid ::"+PROP_NO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PROP_NO(PROP_NO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateNEW_ICNO(FacesContext context,
			UIComponent component, Object value){
		try{
			String NEW_ICNO = (String)value;
			System.out.println("valid ::"+NEW_ICNO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setNEW_ICNO(NEW_ICNO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateOLD_ICNO(FacesContext context,
			UIComponent component, Object value){
		try{
			String OLD_ICNO = (String)value;
			System.out.println("valid ::"+OLD_ICNO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setOLD_ICNO(OLD_ICNO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_EXAM_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String EXAM_CODE = (String)value;
			System.out.println("valid ::"+EXAM_CODE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_EXAM_CODE(EXAM_CODE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_EXAM_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date EXAM_DT = (Date)value;
			System.out.println("valid ::"+EXAM_DT);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_EXAM_DT(EXAM_DT);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_CURR_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String CURR_CODE = (String)value;
			System.out.println("valid ::"+CURR_CODE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CURR_CODE(CURR_CODE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_FC_VALUE(FacesContext context,
			UIComponent component, Object value){
		try{
			Double FC_VALUE = (Double)value;
			System.out.println("valid ::"+FC_VALUE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FC_VALUE(FC_VALUE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_INV_REF_NO(FacesContext context,
			UIComponent component, Object value){
		try{
			String INV_REF_NO = (String)value;
			System.out.println("valid ::"+INV_REF_NO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_INV_REF_NO(INV_REF_NO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*public void validateMFD_PYMT_TO(FacesContext context,
			UIComponent component, Object value){
		
		try{
			String PYMT_TO = (String)value;
			System.out.println("valid ::"+PYMT_TO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO(PYMT_TO);
			PILT023_HELPER.callMFD_PYMT_TO_PROC(compositeAction,PYMT_TO);
			
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	
	
	public void validateMFD_FRZ_FLAG(FacesContext context,
			UIComponent component, Object value){
		try{
			String FRZ_FLAG = (String)value;
			System.out.println("valid ::      "+FRZ_FLAG);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(FRZ_FLAG);
			/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
			/*if("Y".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG()))
			{
				COMP_MFD_PYMT_TO.setDisabled(true);
				COMP_MFD_REMARKS.setDisabled(true);
				COMP_MFD_LC_VALUE.setDisabled(true);
				COMP_MFD_FC_VALUE.setDisabled(true);
				COMP_MFD_INV_REF_NO.setDisabled(true);

				//Added by saritha on 13-03-2018
				COMP_UI_Approve.setDisabled(false);
				//End

			}
			else
			{
				COMP_MFD_PYMT_TO.setDisabled(false);
				COMP_MFD_REMARKS.setDisabled(false);
				COMP_MFD_LC_VALUE.setDisabled(false);
				COMP_MFD_FC_VALUE.setDisabled(false);
				COMP_MFD_INV_REF_NO.setDisabled(false);
				//Added by saritha on 13-03-2018
				COMP_UI_Approve.setDisabled(true);
				//end

			}*/
			/* End*/

			/*Commentted &Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
			if("Y".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG()))
			{
				COMP_MFD_PYMT_TO.setDisabled(true);
				COMP_MFD_REMARKS.setDisabled(true);
				COMP_MFD_LC_VALUE.setDisabled(true);
				COMP_MFD_FC_VALUE.setDisabled(true);
				COMP_MFD_INV_REF_NO.setDisabled(true);
				COMP_MFD_FLEX_01.setDisabled(true);
				COMP_MFD_FLEX_02.setDisabled(true);
				COMP_MFD_FLEX_03.setDisabled(true);
				COMP_MFD_FLEX_04.setDisabled(true);
				COMP_MFD_FLEX_05.setDisabled(true);
				COMP_MFD_FLEX_06.setDisabled(true);
				COMP_UI_Approve.setDisabled(false);

			}else
			{
				COMP_MFD_PYMT_TO.setDisabled(false);
				COMP_MFD_REMARKS.setDisabled(false);
				COMP_MFD_LC_VALUE.setDisabled(false);
				COMP_MFD_FC_VALUE.setDisabled(false);
				COMP_MFD_INV_REF_NO.setDisabled(false);
				COMP_MFD_FLEX_01.setDisabled(false);
				COMP_MFD_FLEX_02.setDisabled(false);
				COMP_MFD_FLEX_03.setDisabled(false);
				COMP_MFD_FLEX_04.setDisabled(false);
				COMP_MFD_FLEX_05.setDisabled(false);
				COMP_MFD_FLEX_06.setDisabled(false);
				COMP_UI_Approve.setDisabled(true);

			}

			/*End*/
			
			/*Added by saritha on 25-04-2018 for KIC Medical Clinic Payments*/
			
			String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));

			if(clinicDetailsParam.equalsIgnoreCase("1")){
				COMP_MFD_FLEX_01.setDisabled(true);
				COMP_MFD_FLEX_02.setDisabled(true);
				COMP_MFD_FLEX_03.setDisabled(true);
				COMP_MFD_FLEX_04.setDisabled(true);

			}
			
			/*End*/
			COMP_MFD_FRZ_FLAG.resetValue();
			COMP_UI_MFD_FRZ_FLAG.resetValue();

		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_POL_NO(FacesContext context,
			UIComponent component, Object value){
		try{
			String POL_NO = (String)value;
			System.out.println("valid ::"+POL_NO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_NO(POL_NO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_LC_VALUE(FacesContext context,
			UIComponent component, Object value){
		try{
			Double LC_VALUE = (Double)value;
			System.out.println("valid ::"+LC_VALUE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_LC_VALUE(LC_VALUE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_POL_CONT_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String POL_CONT_CODE = (String)value;
			System.out.println("valid ::"+POL_CONT_CODE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_CONT_CODE(POL_CONT_CODE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateWM_MFD_POL_CONT_NAME(FacesContext context,
			UIComponent component, Object value){
		try{
			String POL_CONT_NAME = (String)value;
			System.out.println("valid ::"+POL_CONT_NAME);
			PT_IL_MEDEX_FEE_DTL_BEAN.setWM_MFD_POL_CONT_NAME(POL_CONT_NAME);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateWM_MFD_EXAM_CODE_DESC(FacesContext context,
			UIComponent component, Object value){
		try{
			String EXAM_CODE_DESC = (String)value;
			System.out.println("valid ::"+EXAM_CODE_DESC);
			PT_IL_MEDEX_FEE_DTL_BEAN.setWM_MFD_EXAM_CODE_DESC(EXAM_CODE_DESC);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateWM_MFD_CURR_CODE_DESC(FacesContext context,
			UIComponent component, Object value){
		try{
			String CURR_CODE_DESC = (String)value;
			System.out.println("valid ::"+CURR_CODE_DESC);
			PT_IL_MEDEX_FEE_DTL_BEAN.setWM_MFD_CURR_CODE_DESC(CURR_CODE_DESC);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_REMARKS(FacesContext context,
			UIComponent component, Object value){
		try{
			String REMARKS = (String)value;
			System.out.println("valid ::"+REMARKS);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_REMARKS(REMARKS);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*public void validateMFD_CURR_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String CURR_CODE = (String)value;
			System.out.println("valid ::"+CURR_CODE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CURR_CODE(CURR_CODE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_FC_VALUE(FacesContext context,
			UIComponent component, Object value){
		try{
			String FC_VALUE = (String)value;
			System.out.println("valid ::"+FC_VALUE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FC_VALUE(FC_VALUE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_INV_REF_NO(FacesContext context,
			UIComponent component, Object value){
		try{
			String INV_REF_NO = (String)value;
			System.out.println("valid ::"+INV_REF_NO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_INV_REF_NO(INV_REF_NO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_PYMT_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			String PYMT_TO = (String)value;
			System.out.println("valid ::"+PYMT_TO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO(PYMT_TO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_FRZ_FLAG(FacesContext context,
			UIComponent component, Object value){
		try{
			String FRZ_FLAG = (String)value;
			System.out.println("valid ::"+FRZ_FLAG);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(FRZ_FLAG);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateMFD_POL_NO(FacesContext context,
			UIComponent component, Object value){
		try{
			String POL_NO = (String)value;
			System.out.println("valid ::"+POL_NO);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_NO(POL_NO);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateMFD_LC_VALUE(FacesContext context,
			UIComponent component, Object value){
		try{
			String LC_VALUE = (String)value;
			System.out.println("valid ::"+LC_VALUE);
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_LC_VALUE(LC_VALUE);
			
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	
	public String payQry(){
		System.out.println("payquery");
		return "payQry";
	}
	
	public void approve()throws Exception{
		System.out.println("approveee changed");

		/*Commentted &Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
		/*String appQry = "SELECT 'X' FROM PT_IL_MEDEX_FEE_DTL WHERE NVL(MFD_FRZ_FLAG,'N') = 'Y' AND NVL(MFD_PAID_FLAG,'N') = 'Y' AND MFD_CLINIC_CODE = ? AND MFD_EXAM_CODE = ?";*/

		String appQry = "SELECT 'X' FROM PT_IL_MEDEX_FEE_DTL WHERE NVL(MFD_FRZ_FLAG,'N') = 'Y' AND NVL(MFD_PAID_FLAG,'N') = 'Y' AND MFD_CLINIC_CODE = ? AND MFD_EXAM_CODE = ? AND MFD_PROP_NO=?";
		ResultSet rs=null;
		Connection connection=null;
		CommonUtils commonUtils = new CommonUtils();

		try {
			String clinicCode=compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE();
			Date fromDate = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_FROM_DT();
			Date toDate   = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_TO_DT();
			String examType=compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_EXAM_CODE();
			String proposalNo  =compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_PROP_NO();
			connection = CommonUtils.getConnection();

			System.out.println("clinicCode        "+clinicCode);

			System.out.println("Freeze Flag"+ PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG());
			callAppProc(clinicCode,CommonUtils.getProcedureValue(fromDate),CommonUtils.getProcedureValue(toDate));
			System.out.println("Paid Flag" + PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PAID_FLAG());

			rs = new CRUDHandler().executeSelectStatement(
					appQry, connection,new Object[]{clinicCode,examType,proposalNo});
			
			if(rs.next()){
				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_APPRV_STATUS("APPROVED");
				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_APPRV_DT(commonUtils.dateToStringFormatter(commonUtils.getCurrentDate()));
				System.out.println("Current Date" + PT_IL_MEDEX_FEE_DTL_BEAN.getWM_APPRV_DT());
				disableAllComponent(true);
			}
			else{
				PT_IL_MEDEX_FEE_DTL_BEAN.setWM_STATUS("N");

			}

			/*Added by saritha on 15-05-2018 for KIC The invoice Number can be Auto generated and should be Unique.*/
			
			getTotalClinicPaid_Amt();
			displayInvoiceRefNo(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_INV_REF_NO());
			
			/*End*/
			
			
			//PILT023_HELPER.getClinicDetails(compositeAction);
			//PILT023_HELPER.executeQuery(compositeAction);
			//PILT023_HELPER.executeQueryData(compositeAction);
			
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Process Approved Successfully");
			getWarningMap().put("togle",Messages.getString(
					"Process Approved Successfully","errorPanel$message$save"));

			/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
			/*Commentted by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
			//setBlockFlag(true);
			/*End*/
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getErrorMap()
			.put("approve", e.getMessage());

		}
		finally {
			CommonUtils.closeCursor(rs);
		}

		/*End*/

	}
	
	public void callAppProc(String clinicCode,String fromDate,String toDate) throws Exception {    
		Connection con=CommonUtils.getConnection();
		ArrayList<String> returnList = new ArrayList<String>();
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);*/
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",clinicCode);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",fromDate);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",toDate);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("OUT1", "INT", "OUT","");
		parameterList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_MEDICAL_FEES.MED_FEE_APPROVAL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}

		compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setMFD_INV_REF_NO(returnList.get(0));

	}

	public void saveRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			if (getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID() != null) {
				if(isUPDATE_ALLOWED()){
				/* new CRUDHandler().executeUpdate(PT_IL_MEDEX_FEE_DTL_BEAN,
						CommonUtils.getConnection()); */
					
					/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
					if(getPT_IL_MEDEX_FEE_DTL_BEAN().isUPDATE_ALL())
					{
						CommonUtils.updateAllRecords(medicalDataList, PT_IL_MEDEX_FEE_DTL_BEAN.getStartIndex(), medicalDataList.size());
					}
					else
					{
					if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG() != null)
					{
						if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG().equals("Y"))
						{
							 postUpdate();	 
							/*getWarningMap().put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									Messages.getString(
											PELConstants.pelMessagePropertiesPath,
											"errorPanel$message$update"));
							getWarningMap().put(
									"postRecord",
									Messages.getString(
											PELConstants.pelMessagePropertiesPath,
											"errorPanel$message$update"));*/
						}
						else
						{
							new CRUDHandler().executeUpdate(PT_IL_MEDEX_FEE_DTL_BEAN,
									CommonUtils.getConnection());
						}
					}
					
					/*PreparedStatement ps = CommonUtils.getConnection().prepareStatement("update PT_IL_MEDEX_FEE_DTL set MFD_FRZ_FLAG=? where MFD_POL_SYS_ID=?");
					ps.setString(1, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FRZ_FLAG());
					ps.setLong(2, PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID());
					ps.executeUpdate();*/
				
					
				/*getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");*/
				}
					
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			} 
			}	else {
				if(isINSERT_ALLOWED()){
					
				new CRUDHandler().executeInsert(PT_IL_MEDEX_FEE_DTL_BEAN,
						CommonUtils.getConnection());
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put("togle",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				message = Messages.getString("messageProperties","errorPanel$message$save");

				}
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
	public void disableAllComponent(boolean disabled)
	{
		COMP_UI_Approve.setDisabled(disabled);
		COMP_MFD_PYMT_TO.setDisabled(disabled);
		COMP_MFD_REMARKS.setDisabled(disabled);
		COMP_MFD_LC_VALUE.setDisabled(disabled);
		COMP_MFD_FC_VALUE.setDisabled(disabled);
		COMP_MFD_INV_REF_NO.setDisabled(disabled);
		COMP_MFD_FRZ_FLAG.setDisabled(disabled);
		COMP_MFD_CLINIC_CODE.setDisabled(disabled);
		setINSERT_ALLOWED(disabled);
		setUPDATE_ALLOWED(disabled);
		setDELETE_ALLOWED(disabled);
		
		/*Added by Janani on 13.09.2017 for ZBILQC-1736304*/
		COMP_DEFLT_YN_CHK_ALL.setDisabled(disabled);
		/*End*/
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
		COMP_MFD_FLEX_01.setDisabled(disabled);
		COMP_MFD_FLEX_02.setDisabled(disabled);
		COMP_MFD_FLEX_03.setDisabled(disabled);
		COMP_MFD_FLEX_04.setDisabled(disabled);
		COMP_MFD_FLEX_05.setDisabled(disabled);
		COMP_MFD_FLEX_06.setDisabled(disabled);
		/*End*/
		
		/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
		
		COMP_CREATE_BUTTON.setDisabled(disabled);
		COMP_DELETE_BUTTON.setDisabled(disabled);
		COMP_SAVE_BUTTON.setDisabled(disabled);
		
		/*End*/
		
		/*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
		
		COMP_MFD_FROM_DT.setDisabled(disabled);
		COMP_MFD_TO_DT.setDisabled(disabled);
		COMP_UI_PROCESS.setDisabled(disabled);
		
		/*End*/
		
	}

	public void fireFieldValidationFreezeCheck(ActionEvent actionEvent) {
		try 
		{
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			boolean chkFlag = false;
			chkFlag = (boolean)input.getSubmittedValue();

			String defChk = "N";
			if(chkFlag)
			{
				defChk = "Y";
			}
			CommonUtils.setPageIndexing(PT_IL_MEDEX_FEE_DTL_BEAN,PT_IL_MEDEX_FEE_DTL_BEAN.getCOMP_DT_SCROLLER(),medDatatable);


			setMedicalDataList(CommonUtils.returnCheckedList(getMedicalDataList(), "MFD_FRZ_FLAG", defChk,
					PT_IL_MEDEX_FEE_DTL_BEAN.getStartIndex(),getMedicalDataList().size()));
			setMedicalDataList(CommonUtils.returnCheckedList(getMedicalDataList(), "MFD_CR_UID", new CommonUtils().getControlBean().getUSER_ID(),
					PT_IL_MEDEX_FEE_DTL_BEAN.getStartIndex(),getMedicalDataList().size()));

			if("Y".equalsIgnoreCase(defChk))
			{

				COMP_MFD_PYMT_TO.setDisabled(true);
				COMP_MFD_REMARKS.setDisabled(true);
				COMP_MFD_LC_VALUE.setDisabled(true);
				COMP_MFD_FC_VALUE.setDisabled(true);
				COMP_MFD_INV_REF_NO.setDisabled(true);
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(defChk);
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(new CommonUtils().getControlBean().getUSER_ID());
				/*COMP_MFD_FRZ_FLAG.resetValue();*/

				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				COMP_MFD_FLEX_01.setDisabled(true);
				COMP_MFD_FLEX_02.setDisabled(true);
				COMP_MFD_FLEX_03.setDisabled(true);
				COMP_MFD_FLEX_04.setDisabled(true);
				COMP_MFD_FLEX_05.setDisabled(true);
				COMP_MFD_FLEX_06.setDisabled(true);

				/*End*/

			}
			else
			{
				COMP_MFD_PYMT_TO.setDisabled(false);
				COMP_MFD_REMARKS.setDisabled(false);
				COMP_MFD_LC_VALUE.setDisabled(false);
				COMP_MFD_FC_VALUE.setDisabled(false);
				COMP_MFD_INV_REF_NO.setDisabled(false);
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(defChk);
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(new CommonUtils().getControlBean().getUSER_ID());
				/*COMP_MFD_FRZ_FLAG.resetValue();*/

				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				COMP_MFD_FLEX_01.setDisabled(false);
				COMP_MFD_FLEX_02.setDisabled(false);
				COMP_MFD_FLEX_03.setDisabled(false);
				COMP_MFD_FLEX_04.setDisabled(false);
				COMP_MFD_FLEX_05.setDisabled(false);
				COMP_MFD_FLEX_06.setDisabled(false);
				
				/*End*/

			}

	        /*Added by saritha on 25-04-2018 for KIC Medical Clinic Payments*/
			
			String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));

			if(clinicDetailsParam.equalsIgnoreCase("1")){
				COMP_MFD_FLEX_01.setDisabled(true);
				COMP_MFD_FLEX_02.setDisabled(true);
				COMP_MFD_FLEX_03.setDisabled(true);
				COMP_MFD_FLEX_04.setDisabled(true);

			}
			
			/*End*/
			
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(defChk);
			COMP_MFD_FRZ_FLAG.resetValue();
			//PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(new CommonUtils().getControlBean().getUSER_ID());

			getPT_IL_MEDEX_FEE_DTL_BEAN().setUPDATE_ALL(true);
			displayRecords();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
/* End*/
	
	
	/*Added by Janani on 13.09.2017 for ZBILQC-1736304*/
	
	private HtmlSelectBooleanCheckbox COMP_DEFLT_YN_CHK_ALL;


	public PILT023_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT023_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DEFLT_YN_CHK_ALL() {
		return COMP_DEFLT_YN_CHK_ALL;
	}

	public void setCOMP_DEFLT_YN_CHK_ALL(
			HtmlSelectBooleanCheckbox cOMP_DEFLT_YN_CHK_ALL) {
		COMP_DEFLT_YN_CHK_ALL = cOMP_DEFLT_YN_CHK_ALL;
	}
	
	
	/*End*/
	
	/*Added by Ameen on 04-12-2017 for ZBLIFE-1458892*/
	private HtmlOutputLabel COMP_MFD_FLEX_01_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_01;
	
	private HtmlInputText COMP_UI_M_MFD_BANK_DESC;
	
	private HtmlOutputLabel COMP_MFD_FLEX_02_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_02;
	
	private HtmlInputText COMP_UI_M_DIVN_CODE;
	
	private HtmlOutputLabel COMP_MFD_FLEX_03_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_03;
	
	private HtmlOutputLabel COMP_MFD_FLEX_04_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_04;
	
	private HtmlOutputLabel COMP_MFD_FLEX_05_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_05;
	
	private HtmlOutputLabel COMP_MFD_FLEX_06_LABEL;
	
	private HtmlInputText COMP_MFD_FLEX_06;


	public HtmlOutputLabel getCOMP_MFD_FLEX_01_LABEL() {
		return COMP_MFD_FLEX_01_LABEL;
	}

	public void setCOMP_MFD_FLEX_01_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_01_LABEL) {
		COMP_MFD_FLEX_01_LABEL = cOMP_MFD_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_01() {
		return COMP_MFD_FLEX_01;
	}

	public void setCOMP_MFD_FLEX_01(HtmlInputText cOMP_MFD_FLEX_01) {
		COMP_MFD_FLEX_01 = cOMP_MFD_FLEX_01;
	}
	
	public HtmlInputText getCOMP_UI_M_MFD_BANK_DESC() {
		return COMP_UI_M_MFD_BANK_DESC;
	}

	public void setCOMP_UI_M_MFD_BANK_DESC(HtmlInputText cOMP_UI_M_MFD_BANK_DESC) {
		COMP_UI_M_MFD_BANK_DESC = cOMP_UI_M_MFD_BANK_DESC;
	}

	public HtmlOutputLabel getCOMP_MFD_FLEX_02_LABEL() {
		return COMP_MFD_FLEX_02_LABEL;
	}

	public void setCOMP_MFD_FLEX_02_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_02_LABEL) {
		COMP_MFD_FLEX_02_LABEL = cOMP_MFD_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_02() {
		return COMP_MFD_FLEX_02;
	}

	public void setCOMP_MFD_FLEX_02(HtmlInputText cOMP_MFD_FLEX_02) {
		COMP_MFD_FLEX_02 = cOMP_MFD_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_MFD_FLEX_03_LABEL() {
		return COMP_MFD_FLEX_03_LABEL;
	}

	public void setCOMP_MFD_FLEX_03_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_03_LABEL) {
		COMP_MFD_FLEX_03_LABEL = cOMP_MFD_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_03() {
		return COMP_MFD_FLEX_03;
	}

	public void setCOMP_MFD_FLEX_03(HtmlInputText cOMP_MFD_FLEX_03) {
		COMP_MFD_FLEX_03 = cOMP_MFD_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_MFD_FLEX_04_LABEL() {
		return COMP_MFD_FLEX_04_LABEL;
	}

	public void setCOMP_MFD_FLEX_04_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_04_LABEL) {
		COMP_MFD_FLEX_04_LABEL = cOMP_MFD_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_04() {
		return COMP_MFD_FLEX_04;
	}

	public void setCOMP_MFD_FLEX_04(HtmlInputText cOMP_MFD_FLEX_04) {
		COMP_MFD_FLEX_04 = cOMP_MFD_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_MFD_FLEX_05_LABEL() {
		return COMP_MFD_FLEX_05_LABEL;
	}

	public void setCOMP_MFD_FLEX_05_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_05_LABEL) {
		COMP_MFD_FLEX_05_LABEL = cOMP_MFD_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_05() {
		return COMP_MFD_FLEX_05;
	}

	public void setCOMP_MFD_FLEX_05(HtmlInputText cOMP_MFD_FLEX_05) {
		COMP_MFD_FLEX_05 = cOMP_MFD_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_MFD_FLEX_06_LABEL() {
		return COMP_MFD_FLEX_06_LABEL;
	}

	public void setCOMP_MFD_FLEX_06_LABEL(HtmlOutputLabel cOMP_MFD_FLEX_06_LABEL) {
		COMP_MFD_FLEX_06_LABEL = cOMP_MFD_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_MFD_FLEX_06() {
		return COMP_MFD_FLEX_06;
	}

	public void setCOMP_MFD_FLEX_06(HtmlInputText cOMP_MFD_FLEX_06) {
		COMP_MFD_FLEX_06 = cOMP_MFD_FLEX_06;
	}
	
	public HtmlInputText getCOMP_UI_M_DIVN_CODE() {
		return COMP_UI_M_DIVN_CODE;
	}

	public void setCOMP_UI_M_DIVN_CODE(HtmlInputText cOMP_UI_M_DIVN_CODE) {
		COMP_UI_M_DIVN_CODE = cOMP_UI_M_DIVN_CODE;
	}

	public ArrayList<LovBean> prepareSuggestionList_UI_M_BANK_CODE(Object object){
			
			ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			ListItemUtil itemUtil = new ListItemUtil();
			String currentValue = (String) object;
			String moduleName = "PM006_A_APAC";
			String blockName = "PM_CUST_BANK_ACNT_DTLS";
			String fieldName = "CBAD_CUST_BANK_CODE";
			

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null, 

						null,
						null, null, null, currentValue);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
		}
	 
	 public void validateMFD_FLEX_01(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 public void validateMFD_FLEX_02(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 public void validateMFD_FLEX_03(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 public void validateMFD_FLEX_04(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 public void validateMFD_FLEX_05(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 public void validateMFD_FLEX_06(FacesContext context,
				UIComponent component, Object value){
			try{
				String currVal = (String)value;
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_06(currVal);
				
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	
	 /*Modified by Saritha on 05.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	 public void fireFieldValidationMFD_PYMT_TO(ActionEvent actionEvent) {
		 getErrorMap().clear();
		 getWarningMap().clear();
		 UIInput input = (UIInput) actionEvent.getComponent().getParent();

		 Connection con=null;
		 String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
		 ResultSet sortCodeRS = null;
		 ResultSet rs = null;
		 try{
			 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO((String)input.getSubmittedValue());
			 con = CommonUtils.getConnection();
			/*if (CommonUtils.isIN(
					 CommonUtils.nvl(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO(), ""),
					 "A", "C", "P")) {*/
				 rs = validateBankDetails(PT_IL_MEDEX_FEE_DTL_BEAN);
				 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04("");
				 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05("");
				 
				 if(rs!=null && rs.next()){					
					 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
					 PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
					 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));
					 
					 if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
						 sortCodeRS = new CRUDHandler().executeSelectStatement(sortCodeQry, con,new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
						 if(sortCodeRS.next()){
							 PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						 }
					 }
					 
					 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
					 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
					 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));

				 }
				 COMP_MFD_FLEX_01.resetValue();
				 COMP_UI_M_MFD_BANK_DESC.resetValue();
				 COMP_MFD_FLEX_02.resetValue();
				 COMP_UI_M_DIVN_CODE.resetValue();
				 COMP_MFD_FLEX_03.resetValue();
				 COMP_MFD_FLEX_04.resetValue();
				 COMP_MFD_FLEX_05.resetValue();
				 ErrorHelpUtil.validate(input, getErrorMap());
			// }
		 } catch (Exception exception) {
			 exception.printStackTrace();

			 throw new ValidatorException(new FacesMessage(exception
					 .getMessage()));
		 } finally {
			 try {
				 CommonUtils.closeCursor(rs);
				 ErrorHelpUtil.getWarningForProcedure(CommonUtils
						 .getConnection(), "MFD_PYMT_TO", getWarningMap());
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	 /*End*/
	 
	 /*public void fireFieldValidationMFD_PYMT_TO(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String bankCodeQry=null;
			ResultSet rs = null;
			try{
				PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO((String)input.getSubmittedValue());
			if("A".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05("");
				bankCodeQry="SELECT CBAD_CUST_BANK_CODE,POBH_BROKER_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, "
						+ "CBAD_DIVISION, (CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,POL_SYS_ID "
						+ "FROM PM_CUST_BANK_ACNT_DTLS, PM_CUSTOMER, FM_BANK, PT_IL_POLICY, PT_IL_POL_BROKER_HEAD  WHERE "
						+ "NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND POL_NO = ? AND POBH_POL_SYS_ID = "
						+ "POL_SYS_ID AND CUST_CODE = POBH_BROKER_CODE AND BANK_CODE = CBAD_CUST_BANK_CODE";
				rs = new CRUDHandler().executeSelectStatement(bankCodeQry, CommonUtils.getConnection(),
								new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO()});
				if(rs.next()){
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));
					if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
						String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
						ResultSet sortCodeRS = null;
						sortCodeRS = new CRUDHandler().executeSelectStatement
								(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
						if(sortCodeRS.next()){
							PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						}
					}
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));
				}
			}else if("C".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05("");
				bankCodeQry="SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
						+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS, "
						+ "PM_CUSTOMER, FM_BANK WHERE CBAD_CUST_CODE = CUST_CODE AND CUST_CODE = ? AND "
						+ "NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE";
				rs = new CRUDHandler().executeSelectStatement(bankCodeQry, CommonUtils.getConnection(),
								new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CLINIC_CODE()});
				if(rs.next()){
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));
					if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
						String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
						ResultSet sortCodeRS = null;
						sortCodeRS = new CRUDHandler().executeSelectStatement
								(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
						if(sortCodeRS.next()){
							PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						}
					}
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));
				}
			}else if("P".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04("");
						PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05("");
				bankCodeQry="SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,"
						+ "CBAD_DIVISION,(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME "
						+ "FROM PM_CUST_BANK_ACNT_DTLS, PM_CUSTOMER, FM_BANK, PT_IL_POLICY WHERE CBAD_CUST_CODE = "
						+ "CUST_CODE AND POL_NO = ? AND CUST_CODE = POL_CUST_CODE  AND NVL(CBAD_PREF_ACNT_YN, 'N') = "
						+ "'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE";
				rs = new CRUDHandler().executeSelectStatement(bankCodeQry, CommonUtils.getConnection(),
								new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO()});
				if(rs.next()){
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_01(rs.getString("CBAD_CUST_BANK_CODE"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_MFD_BANK_DESC(rs.getString("BANK_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_02(rs.getString("CBAD_DIVISION"));
					if(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()!=null){
						String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
						ResultSet sortCodeRS = null;
						sortCodeRS = new CRUDHandler().executeSelectStatement
								(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_02()});
						if(sortCodeRS.next()){
							PT_IL_MEDEX_FEE_DTL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						}
					}
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_03(rs.getString("CBAD_ACNT_NO"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_04(rs.getString("CBAD_ACNT_NAME"));
					PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FLEX_05(rs.getString("CUST_MOBILE"));
				}
			}
			COMP_MFD_FLEX_01.resetValue();
			COMP_UI_M_MFD_BANK_DESC.resetValue();
			COMP_MFD_FLEX_02.resetValue();
			COMP_UI_M_DIVN_CODE.resetValue();
			COMP_MFD_FLEX_03.resetValue();
			COMP_MFD_FLEX_04.resetValue();
			COMP_MFD_FLEX_05.resetValue();
			End
			}catch(Exception e){
				e.printStackTrace();
			}
			
			ErrorHelpUtil.validate(input, getErrorMap());
	}*/
	 
	 public ArrayList<LovBean> prepareSuggestionList_UI_M_DIVISION_CODE(Object currValue) {
			String code = (String) currValue;
			ArrayList<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			try {
				if ("*".equals(code)) {
					object = new Object[] { PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(), PELConstants.suggetionRecordSize };
					
					
					query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
				} else {
					object = new Object[] { PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_FLEX_01(), code + "%", code + "%",
							PELConstants.suggetionRecordSize };
					
					query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND"
							+ "(UPPER(BR_BANK_SORT_CODE) LIKE UPPER(?) OR UPPER(BR_BANK_BRANCH_CODE) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
					/*End*/
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
	 
	/*End*/
	 
	 
	 /*Added by Saritha on 05.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	 public void validateMFD_PYMT_TO(FacesContext context,
			 UIComponent component, Object value) throws ValidatorException {

		 ResultSet rs = null;
		 try{
			 String PYMT_TO = (String)value;
			 System.out.println("valid ::"+PYMT_TO);
			 PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO(PYMT_TO);
			 
			 if(PYMT_TO!=null){
			 PILT023_HELPER.callMFD_PYMT_TO_PROC(compositeAction,PYMT_TO);


			 
			     getDirectOrAgent();
			 
				 rs = validateBankDetails(PT_IL_MEDEX_FEE_DTL_BEAN);
				 
				 /*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
				 String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));
				 System.out.println("clinicDetailsParam ----->" +clinicDetailsParam );
				
				if(!clinicDetailsParam.equalsIgnoreCase("1")){
				
				 if (rs != null && rs.next()) {
					 if (rs.getString("CBAD_CUST_BANK_CODE") == null
							 || rs.getString("CBAD_ACNT_NAME") == null
							 || rs.getString("CBAD_ACNT_NO") == null
							 || rs.getString("CBAD_DIVISION") == null) {
						 throw new Exception(
								 "Enter the Bank Details in Customer Master");
					 }
				 } else {
					 throw new Exception(
							 "Enter the Bank Details in Customer Master");
				 }
					}
				
				/*End*/
			 }

		

		 } catch (Exception e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			 throw new ValidatorException(new FacesMessage(e.getMessage()));

		 }finally{
			 try {
				 CommonUtils.closeCursor(rs);
			 } catch (Exception e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }

		 }
	 }

	 public void getDirectOrAgent() throws Exception {
		 Connection connection = null;
		 ResultSet resultset = null;
		 String POL_SRC_OF_BUS = null;
		 String sourceOfBusquery = "SELECT POL_SRC_OF_BUS FROM PT_IL_POLICY WHERE POL_SYS_ID=?";

		 try {

			 connection = CommonUtils.getConnection();
			 resultset = new CRUDHandler().executeSelectStatement(sourceOfBusquery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_POL_SYS_ID()});
			 if(resultset.next()){
				 POL_SRC_OF_BUS = resultset.getString(1);

			 }

			 if("A".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){

				 if("001".equalsIgnoreCase(POL_SRC_OF_BUS)){

					 throw new Exception("Not a Valid Option");

				 }

			 }

		 } catch (Exception e) {
			 // TODO: handle exception
			 e.printStackTrace();
			 throw e;
		 }finally {
			 CommonUtils.closeCursor(resultset);
		 }

	 }
	 
	 public ResultSet validateBankDetails(PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN){
		 ResultSet rsBankDetails = null;
		 String bankDtlQuery = null;
		 Object[] bankDtlParams = null;
		 Connection con = null;
		 try{
			 con = CommonUtils.getConnection();

			 if("A".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){
				 
				 bankDtlQuery = "SELECT CBAD_CUST_BANK_CODE,POBH_BROKER_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, "
							+ "CBAD_DIVISION, (CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,POL_SYS_ID "
							+ "FROM PM_CUST_BANK_ACNT_DTLS, PM_CUSTOMER, FM_BANK, PT_IL_POLICY, PT_IL_POL_BROKER_HEAD  WHERE "
							+ "NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND POL_NO = ? AND POBH_POL_SYS_ID = "
							+ "POL_SYS_ID AND CUST_CODE = POBH_BROKER_CODE AND CBAD_CUST_CODE = CUST_CODE "
							+ "AND BANK_CODE = CBAD_CUST_BANK_CODE";
				 
				 bankDtlParams = new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO()};
				 rsBankDetails = new CRUDHandler().executeSelectStatement(bankDtlQuery, con,bankDtlParams);

			 }else if("C".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){

				 bankDtlQuery = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
						    + "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS, PM_CUSTOMER, FM_BANK "
						    + "WHERE CBAD_CUST_CODE = CUST_CODE AND CUST_CODE = ? AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND CBAD_CUST_BANK_CODE = BANK_CODE";
				 
				 bankDtlParams = new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CLINIC_CODE()};
				 rsBankDetails = new CRUDHandler().executeSelectStatement(bankDtlQuery, con,bankDtlParams);
				 
			 } else if("P".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PYMT_TO())){

				 bankDtlQuery = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
				 		+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS, "
				 		+ "PM_CUSTOMER, FM_BANK, PT_IL_POLICY WHERE CBAD_CUST_CODE = CUST_CODE AND POL_NO = ? AND CUST_CODE = POL_CUST_CODE "
				 		+ "AND NVL(CBAD_PREF_ACNT_YN, 'N') ='Y' AND BANK_CODE = CBAD_CUST_BANK_CODE";
				 
				 bankDtlParams = new Object[]{PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_PROP_NO()};
				 rsBankDetails = new CRUDHandler().executeSelectStatement(bankDtlQuery, con,bankDtlParams);
			 } 

		 }catch(Exception e){
			 e.printStackTrace();
		 }

		 return rsBankDetails;

	 }
	 
	 /*End*/
	 
	 
	 /*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	 
	 private HtmlAjaxCommandButton COMP_CREATE_BUTTON;
	 private HtmlAjaxCommandButton COMP_DELETE_BUTTON;
	 private HtmlAjaxCommandButton COMP_SAVE_BUTTON;

	 public HtmlAjaxCommandButton getCOMP_CREATE_BUTTON() {
		 return COMP_CREATE_BUTTON;
	 }

	 public void setCOMP_CREATE_BUTTON(HtmlAjaxCommandButton cOMP_CREATE_BUTTON) {
		 COMP_CREATE_BUTTON = cOMP_CREATE_BUTTON;
	 }

	 public HtmlAjaxCommandButton getCOMP_DELETE_BUTTON() {
		 return COMP_DELETE_BUTTON;
	 }

	 public void setCOMP_DELETE_BUTTON(HtmlAjaxCommandButton cOMP_DELETE_BUTTON) {
		 COMP_DELETE_BUTTON = cOMP_DELETE_BUTTON;
	 }

	 public HtmlAjaxCommandButton getCOMP_SAVE_BUTTON() {
		 return COMP_SAVE_BUTTON;
	 }

	 public void setCOMP_SAVE_BUTTON(HtmlAjaxCommandButton cOMP_SAVE_BUTTON) {
		 COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	 }
	
	public void enableDisableComponents(boolean enbDisFlag){

		COMP_MFD_INV_REF_NO.setDisabled(enbDisFlag);
		COMP_MFD_LC_VALUE.setDisabled(enbDisFlag);
		COMP_MFD_FC_VALUE.setDisabled(enbDisFlag);
		COMP_MFD_PYMT_TO.setDisabled(enbDisFlag);
		COMP_MFD_FRZ_FLAG.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_01.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_02.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_03.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_04.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_05.setDisabled(enbDisFlag);
		COMP_MFD_FLEX_06.setDisabled(enbDisFlag);
		COMP_DELETE_BUTTON.setDisabled(enbDisFlag);
		COMP_SAVE_BUTTON.setDisabled(enbDisFlag);

	}
	
	/*End*/
	
	/*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
	
	private HtmlOutputLabel COMP_MFD_FROM_DT_LABEL;
	private HtmlCalendar COMP_MFD_FROM_DT;
	private HtmlOutputLabel COMP_MFD_TO_DT_LABEL;
	private HtmlCalendar COMP_MFD_TO_DT;

	public HtmlOutputLabel getCOMP_MFD_FROM_DT_LABEL() {
		return COMP_MFD_FROM_DT_LABEL;
	}

	public void setCOMP_MFD_FROM_DT_LABEL(HtmlOutputLabel cOMP_MFD_FROM_DT_LABEL) {
		COMP_MFD_FROM_DT_LABEL = cOMP_MFD_FROM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_MFD_FROM_DT() {
		return COMP_MFD_FROM_DT;
	}

	public void setCOMP_MFD_FROM_DT(HtmlCalendar cOMP_MFD_FROM_DT) {
		COMP_MFD_FROM_DT = cOMP_MFD_FROM_DT;
	}
	
	public HtmlOutputLabel getCOMP_MFD_TO_DT_LABEL() {
		return COMP_MFD_TO_DT_LABEL;
	}

	public void setCOMP_MFD_TO_DT_LABEL(HtmlOutputLabel cOMP_MFD_TO_DT_LABEL) {
		COMP_MFD_TO_DT_LABEL = cOMP_MFD_TO_DT_LABEL;
	}
	
	public HtmlCalendar getCOMP_MFD_TO_DT() {
		return COMP_MFD_TO_DT;
	}

	public void setCOMP_MFD_TO_DT(HtmlCalendar cOMP_MFD_TO_DT) {
		COMP_MFD_TO_DT = cOMP_MFD_TO_DT;
	}
	
	public void validateMFD_FROM_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date MFD_FROM_DT = (Date)value;
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FROM_DT(MFD_FROM_DT);

		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateMFD_TO_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date MFD_TO_DT = (Date)value;
			PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_TO_DT(MFD_TO_DT);

		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private HtmlCommandButton COMP_UI_PROCESS;

	public HtmlCommandButton getCOMP_UI_PROCESS() {
		return COMP_UI_PROCESS;
	}

	public void setCOMP_UI_PROCESS(HtmlCommandButton cOMP_UI_PROCESS) {
		COMP_UI_PROCESS = cOMP_UI_PROCESS;
	}
	
	
	public void processButton()throws Exception{

		try {

			if(DUMMY_BEAN.getMFD_CLINIC_CODE()!=null){
				PILT023_HELPER.getClinicDetails(compositeAction);

			}

			if (medicalDataList.size() > 0) {

				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Process Completed Successfully");
				getWarningMap().put("togle",Messages.getString(
						"Process Completed Successfully","errorPanel$message$save"));
				COMP_UI_PROCESS.setDisabled(true);

			}else{

				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"No Record Found");
				COMP_UI_PROCESS.setDisabled(false);
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getErrorMap()
			.put("process", e.getMessage());

		}

	}
	
	private HtmlInputText COMP_UI_M_TOTAL_PAID_AMT;

	public HtmlInputText getCOMP_UI_M_TOTAL_PAID_AMT() {
		return COMP_UI_M_TOTAL_PAID_AMT;
	}

	public void setCOMP_UI_M_TOTAL_PAID_AMT(HtmlInputText cOMP_UI_M_TOTAL_PAID_AMT) {
		COMP_UI_M_TOTAL_PAID_AMT = cOMP_UI_M_TOTAL_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOTAL_PAID_AMT_LABEL() {
		return COMP_UI_M_TOTAL_PAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOTAL_PAID_AMT_LABEL(
			HtmlOutputLabel cOMP_UI_M_TOTAL_PAID_AMT_LABEL) {
		COMP_UI_M_TOTAL_PAID_AMT_LABEL = cOMP_UI_M_TOTAL_PAID_AMT_LABEL;
	}


	private HtmlOutputLabel COMP_UI_M_TOTAL_PAID_AMT_LABEL;
	/*End*/
	/*public void getTotalClinicPaid_Amt() {
		Connection connection = null;
		ResultSet rstClinicPaidAmt = null;

		try {

			connection = CommonUtils.getConnection();

			String medicalPaidAmtQuery = "SELECT SUM(NVL(MFD_LC_VALUE, 0)) TOTAL_AMT FROM PT_IL_MEDEX_FEE_DTL WHERE MFD_SYS_ID IN "
					+ "(SELECT DISTINCT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL, PT_IL_POL_MED_EXAM_DTL "
					+ "WHERE MFD_CLINIC_CODE = ? AND MFD_PAID_FLAG = 'Y' AND MFD_PROP_NO IS NOT NULL AND MFD_POL_NO IS NULL AND "
					+ "TO_DATE(PMED_EXM_DN_DT, 'DD/MM/RRRR') BETWEEN TO_DATE(?, 'DD/MM/RRRR') AND TO_DATE(?, 'DD/MM/RRRR') "
					+ "AND PMED_POL_SYS_ID = MFD_POL_SYS_ID AND PMED_CLINIC_CODE = MFD_CLINIC_CODE AND MFD_PROP_NO IN "
					+ "(SELECT POL_NO FROM PT_IL_POLICY A WHERE NVL(POL_CONVERT_YN, 'N') = 'N' AND POL_END_NO_IDX =(SELECT MAX(POL_END_NO_IDX) "
					+ "FROM PT_IL_POLICY B WHERE B.POL_NO = A.POL_NO)) UNION SELECT DISTINCT MFD_SYS_ID "
					+ "FROM PT_IL_MEDEX_FEE_DTL A, PT_IL_POL_MED_EXAM_DTL WHERE MFD_CLINIC_CODE = ? AND PMED_POL_SYS_ID = MFD_POL_SYS_ID AND "
					+ "PMED_CLINIC_CODE = MFD_CLINIC_CODE AND MFD_PAID_FLAG = 'Y' AND MFD_PROP_NO IS NOT NULL AND MFD_POL_NO IS NOT NULL AND "
					+ "TO_DATE(PMED_EXM_DN_DT, 'DD/MM/RRRR') BETWEEN TO_DATE(?, 'DD/MM/RRRR') AND TO_DATE(?, 'DD/MM/RRRR') AND "
					+ "MFD_PROP_NO IN(SELECT POL_NO FROM PT_IL_POLICY WHERE POL_CONVERT_YN = 'Y') AND NOT EXISTS (SELECT 'X' FROM PT_IL_MEDEX_FEE_DTL B "
					+ "WHERE A.MFD_PROP_NO = B.MFd_PROP_NO AND B.MFD_PAID_FLAG = 'Y' AND B.MFD_EXAM_CODE = A.MFD_EXAM_CODE AND "
					+ "B.MFD_CLINIC_CODE = A.MFD_CLINIC_CODE AND B.MFD_POL_NO IS NULL))";


			String clinic_code = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_CLINIC_CODE();
			Date medicalFm_date =compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_FROM_DT();
			Date medicalTo_date =compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_TO_DT();

			rstClinicPaidAmt =  new CRUDHandler().executeSelectStatement(medicalPaidAmtQuery, connection, new Object[]{clinic_code,medicalFm_date,medicalTo_date,
					clinic_code,medicalFm_date,medicalTo_date});

			if (rstClinicPaidAmt.next()) {
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setUI_M_TOTAL_PAID_AMT(rstClinicPaidAmt.getDouble(1));
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getCOMP_UI_M_TOTAL_PAID_AMT().resetValue();
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rstClinicPaidAmt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}*/
	
	/*Added by saritha on 09-05-2018*/ 
	public void getTotalClinicPaid_Amt() {
		

		try {

			Double totalPaidAmount = 0.0;
			
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_TEMP = null;
			if (compositeAction
					.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
					.getMedicalDataList() != null) {
				for (int i = 0; i < compositeAction
						.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
						.getMedicalDataList().size(); i++) {
					PT_IL_MEDEX_FEE_DTL_TEMP = compositeAction
							.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
							.getMedicalDataList().get(i);

					if ("Y".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_TEMP
							.getMFD_FRZ_FLAG()))
						totalPaidAmount += PT_IL_MEDEX_FEE_DTL_TEMP
								.getMFD_FC_VALUE();

				}
			}

				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setUI_M_TOTAL_PAID_AMT(totalPaidAmount);
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getCOMP_UI_M_TOTAL_PAID_AMT().resetValue();
			

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
	
	private HtmlSelectOneMenu COMP_UI_MFD_FRZ_FLAG;


	public HtmlSelectOneMenu getCOMP_UI_MFD_FRZ_FLAG() {
		return COMP_UI_MFD_FRZ_FLAG;
	}

	public void setCOMP_UI_MFD_FRZ_FLAG(HtmlSelectOneMenu cOMP_UI_MFD_FRZ_FLAG) {
		COMP_UI_MFD_FRZ_FLAG = cOMP_UI_MFD_FRZ_FLAG;
	}
	
	
	/*Added by saritha on 15-05-2018 for KIC The invoice Number can be Auto generated and should be Unique.*/
	
	public void displayInvoiceRefNo(String invoiceRefNo) {

		try {

			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_TEMP = null;
			if (compositeAction
					.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
					.getMedicalDataList() != null) {
				for (int i = 0; i < compositeAction
						.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
						.getMedicalDataList().size(); i++) {
					PT_IL_MEDEX_FEE_DTL_TEMP = compositeAction
							.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
							.getMedicalDataList().get(i);

					if ("Y".equalsIgnoreCase(PT_IL_MEDEX_FEE_DTL_TEMP
							.getMFD_FRZ_FLAG())){
						PT_IL_MEDEX_FEE_DTL_TEMP.setMFD_INV_REF_NO(invoiceRefNo);
						compositeAction
						.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN()
						.getMedicalDataList().set(i, PT_IL_MEDEX_FEE_DTL_TEMP);

					}


				}
			}


		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
	
	private Double UI_M_TOTAL_PAID_AMT;

	public Double getUI_M_TOTAL_PAID_AMT() {
		return UI_M_TOTAL_PAID_AMT;
	}

	public void setUI_M_TOTAL_PAID_AMT(Double uI_M_TOTAL_PAID_AMT) {
		UI_M_TOTAL_PAID_AMT = uI_M_TOTAL_PAID_AMT;
	}
	
	/*End*/
	

}

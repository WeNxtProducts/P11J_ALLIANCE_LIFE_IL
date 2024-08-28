package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_BENEFICIARY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PBEN_SR_NO_LABEL;

	private HtmlInputText COMP_PBEN_SR_NO;

	private HtmlOutputLabel COMP_PBEN_BNF_TYPE_LABEL;

	private HtmlInputText COMP_PBEN_BNF_TYPE;

	private HtmlOutputLabel COMP_PBEN_REF_ID1_LABEL;

	private HtmlInputText COMP_PBEN_REF_ID1;

	private HtmlOutputLabel COMP_PBEN_REF_ID2_LABEL;

	private HtmlInputText COMP_PBEN_REF_ID2;

	private String DEFAULT_WHERE;

	private HtmlOutputLabel COMP_PBEN_CATG_CODE_LABEL;

	private HtmlInputText COMP_PBEN_CATG_CODE;

	private HtmlOutputLabel COMP_PBEN_AGE_LABEL;

	private HtmlInputText COMP_PBEN_AGE;

	private HtmlOutputLabel COMP_PBEN_RELATION_CODE_LABEL;

	private HtmlInputText COMP_PBEN_RELATION_CODE;

	private HtmlOutputLabel COMP_PBEN_PERC_LABEL;

	private HtmlInputText COMP_PBEN_PERC;

	private HtmlOutputLabel COMP_PBEN_GUARDIAN_NAME_LABEL;

	private HtmlInputText COMP_PBEN_GUARDIAN_NAME;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_1_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_1;

	private HtmlOutputLabel COMP_PBEN_BNF_NAME_LABEL;

	private HtmlInputText COMP_PBEN_BNF_NAME;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_3_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_3;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_2_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_2;

	private HtmlOutputLabel COMP_PBEN_REMARKS_LABEL;

	private HtmlInputText COMP_PBEN_REMARKS;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_4_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_4;

	private HtmlOutputLabel COMP_UI_M_CATG_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CATG_DESC;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_5_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_5;

	private HtmlOutputLabel COMP_UI_M_PBEN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PBEN_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_PBEN_RELATION_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PBEN_RELATION_DESC;

	private PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BENEFICIARY_HELPER helper;

	private List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY = new ArrayList<PT_IL_POL_BENEFICIARY>();

	private UIData dataTable;
	
	private Double PBEN_SUM_PERC;

	public Double getPBEN_SUM_PERC() {
		return PBEN_SUM_PERC;
	}



	public void setPBEN_SUM_PERC(Double pben_sum_perc) {
		PBEN_SUM_PERC = pben_sum_perc;
	}



	public PT_IL_POL_BENEFICIARY_ACTION() {

		PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
		helper = new PT_IL_POL_BENEFICIARY_HELPER();
		instantiateAllComponent();
	}

	
	
	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_3_LABEL() {
		return COMP_PBEN_ADDRESS_3_LABEL;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_3() {
		return COMP_PBEN_ADDRESS_3;
	}

	public void setCOMP_PBEN_ADDRESS_3_LABEL(
			HtmlOutputLabel COMP_PBEN_ADDRESS_3_LABEL) {
		this.COMP_PBEN_ADDRESS_3_LABEL = COMP_PBEN_ADDRESS_3_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_3(HtmlInputText COMP_PBEN_ADDRESS_3) {
		this.COMP_PBEN_ADDRESS_3 = COMP_PBEN_ADDRESS_3;
	}

	public void setCOMP_UI_M_PBEN_RELATION_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PBEN_RELATION_DESC_LABEL) {
		this.COMP_UI_M_PBEN_RELATION_DESC_LABEL = COMP_UI_M_PBEN_RELATION_DESC_LABEL;
	}

	public void setCOMP_UI_M_PBEN_RELATION_DESC(
			HtmlInputText COMP_UI_M_PBEN_RELATION_DESC) {
		this.COMP_UI_M_PBEN_RELATION_DESC = COMP_UI_M_PBEN_RELATION_DESC;
	}

	public PT_IL_POL_BENEFICIARY getPT_IL_POL_BENEFICIARY_BEAN() {
		return PT_IL_POL_BENEFICIARY_BEAN;
	}

	public void setPT_IL_POL_BENEFICIARY_BEAN(
			PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN) {
		this.PT_IL_POL_BENEFICIARY_BEAN = PT_IL_POL_BENEFICIARY_BEAN;
	}

	public List<PT_IL_POL_BENEFICIARY> getDataList_PT_IL_POL_BENEFICIARY() {
		return dataList_PT_IL_POL_BENEFICIARY;
	}

	public void setDataListPT_IL_POL_BENEFICIARY(
			List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY) {
		this.dataList_PT_IL_POL_BENEFICIARY = dataList_PT_IL_POL_BENEFICIARY;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
				helper.whenCreateRecord(this);
				resetAllComponent();
				resetSelectedRow();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
												"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(getPT_IL_POL_BENEFICIARY_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataList_PT_IL_POL_BENEFICIARY.remove(PT_IL_POL_BENEFICIARY_BEAN);
				if (dataList_PT_IL_POL_BENEFICIARY.size() > 0) {
					PT_IL_POL_BENEFICIARY_BEAN = dataList_PT_IL_POL_BENEFICIARY.get(0);
				} else if (dataList_PT_IL_POL_BENEFICIARY.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PT_IL_POL_BENEFICIARY_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),getPT_IL_POL_BENEFICIARY_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataList_PT_IL_POL_BENEFICIARY.add(PT_IL_POL_BENEFICIARY_BEAN);
				
			} else if (PT_IL_POL_BENEFICIARY_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.preUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),getPT_IL_POL_BENEFICIARY_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_BENEFICIARY_BEAN = (PT_IL_POL_BENEFICIARY) dataTable.getRowData();
			helper.postQuery(getPT_IL_POL_BENEFICIARY_BEAN(),compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BENEFICIARY> PT_IL_POL_BENEFICIARY_ITR = dataList_PT_IL_POL_BENEFICIARY.iterator();
		while (PT_IL_POL_BENEFICIARY_ITR.hasNext()) {
			PT_IL_POL_BENEFICIARY_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PBEN_SR_NO.resetValue();
		COMP_PBEN_SR_NO.resetValue();
		COMP_PBEN_BNF_TYPE.resetValue();
		COMP_PBEN_BNF_TYPE.resetValue();
		COMP_PBEN_REF_ID1.resetValue();
		COMP_PBEN_REF_ID1.resetValue();
		COMP_PBEN_REF_ID2.resetValue();
		COMP_PBEN_REF_ID2.resetValue();
		COMP_PBEN_CATG_CODE.resetValue();
		COMP_PBEN_CATG_CODE.resetValue();
		COMP_PBEN_AGE.resetValue();
		COMP_PBEN_AGE.resetValue();
		COMP_PBEN_RELATION_CODE.resetValue();
		COMP_PBEN_RELATION_CODE.resetValue();
		COMP_PBEN_PERC.resetValue();
		COMP_PBEN_PERC.resetValue();
		COMP_PBEN_GUARDIAN_NAME.resetValue();
		COMP_PBEN_GUARDIAN_NAME.resetValue();
		COMP_PBEN_ADDRESS_1.resetValue();
		COMP_PBEN_ADDRESS_1.resetValue();
		COMP_PBEN_BNF_NAME.resetValue();
		COMP_PBEN_BNF_NAME.resetValue();
		COMP_PBEN_ADDRESS_3.resetValue();
		COMP_PBEN_ADDRESS_3.resetValue();
		COMP_PBEN_ADDRESS_2.resetValue();
		COMP_PBEN_ADDRESS_2.resetValue();
		COMP_PBEN_REMARKS.resetValue();
		COMP_PBEN_REMARKS.resetValue();
		COMP_PBEN_ADDRESS_4.resetValue();
		COMP_PBEN_ADDRESS_4.resetValue();
		COMP_UI_M_CATG_DESC.resetValue();
		COMP_UI_M_CATG_DESC.resetValue();
		COMP_PBEN_ADDRESS_5.resetValue();
		COMP_PBEN_ADDRESS_5.resetValue();
		COMP_UI_M_PBEN_TYPE_DESC.resetValue();
		COMP_UI_M_PBEN_TYPE_DESC.resetValue();
		COMP_UI_M_PBEN_RELATION_DESC.resetValue();
		COMP_UI_M_PBEN_RELATION_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.whenNewBlockInstance(compositeAction);
				helper.preQuery(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_BENEFICIARY_BEAN.getROWID() != null){
					helper.postQuery(getPT_IL_POL_BENEFICIARY_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}else{
					helper.whenCreateRecord(this);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PBEN_SR_NO_LABEL() {
		return COMP_PBEN_SR_NO_LABEL;
	}

	public void setCOMP_PBEN_SR_NO_LABEL(HtmlOutputLabel comp_pben_sr_no_label) {
		COMP_PBEN_SR_NO_LABEL = comp_pben_sr_no_label;
	}

	public HtmlInputText getCOMP_PBEN_SR_NO() {
		return COMP_PBEN_SR_NO;
	}

	public void setCOMP_PBEN_SR_NO(HtmlInputText comp_pben_sr_no) {
		COMP_PBEN_SR_NO = comp_pben_sr_no;
	}

	public HtmlOutputLabel getCOMP_PBEN_RELATION_CODE_LABEL() {
		return COMP_PBEN_RELATION_CODE_LABEL;
	}

	public void setCOMP_PBEN_RELATION_CODE_LABEL(
			HtmlOutputLabel comp_pben_relation_code_label) {
		COMP_PBEN_RELATION_CODE_LABEL = comp_pben_relation_code_label;
	}

	public HtmlOutputLabel getCOMP_PBEN_REMARKS_LABEL() {
		return COMP_PBEN_REMARKS_LABEL;
	}

	public void setCOMP_PBEN_REMARKS_LABEL(
			HtmlOutputLabel comp_pben_remarks_label) {
		COMP_PBEN_REMARKS_LABEL = comp_pben_remarks_label;
	}

	public HtmlInputText getCOMP_PBEN_REMARKS() {
		return COMP_PBEN_REMARKS;
	}

	public void setCOMP_PBEN_REMARKS(HtmlInputText comp_pben_remarks) {
		COMP_PBEN_REMARKS = comp_pben_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_M_CATG_DESC_LABEL() {
		return COMP_UI_M_CATG_DESC_LABEL;
	}

	public void setCOMP_UI_M_CATG_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_catg_desc_label) {
		COMP_UI_M_CATG_DESC_LABEL = comp_ui_m_catg_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CATG_DESC() {
		return COMP_UI_M_CATG_DESC;
	}

	public void setCOMP_UI_M_CATG_DESC(HtmlInputText comp_ui_m_catg_desc) {
		COMP_UI_M_CATG_DESC = comp_ui_m_catg_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PBEN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PBEN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PBEN_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pben_type_desc_label) {
		COMP_UI_M_PBEN_TYPE_DESC_LABEL = comp_ui_m_pben_type_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PBEN_TYPE_DESC() {
		return COMP_UI_M_PBEN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PBEN_TYPE_DESC(
			HtmlInputText comp_ui_m_pben_type_desc) {
		COMP_UI_M_PBEN_TYPE_DESC = comp_ui_m_pben_type_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PBEN_RELATION_DESC_LABEL() {
		return COMP_UI_M_PBEN_RELATION_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PBEN_RELATION_DESC() {
		return COMP_UI_M_PBEN_RELATION_DESC;
	}

	public void setDataList_PT_IL_POL_BENEFICIARY(
			List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY) {
		this.dataList_PT_IL_POL_BENEFICIARY = dataList_PT_IL_POL_BENEFICIARY;
	}

	public HtmlOutputLabel getCOMP_PBEN_BNF_TYPE_LABEL() {
		return COMP_PBEN_BNF_TYPE_LABEL;
	}

	public void setCOMP_PBEN_BNF_TYPE_LABEL(
			HtmlOutputLabel comp_pben_bnf_type_label) {
		COMP_PBEN_BNF_TYPE_LABEL = comp_pben_bnf_type_label;
	}

	public HtmlInputText getCOMP_PBEN_BNF_TYPE() {
		return COMP_PBEN_BNF_TYPE;
	}

	public void setCOMP_PBEN_BNF_TYPE(HtmlInputText comp_pben_bnf_type) {
		COMP_PBEN_BNF_TYPE = comp_pben_bnf_type;
	}

	public HtmlOutputLabel getCOMP_PBEN_REF_ID1_LABEL() {
		return COMP_PBEN_REF_ID1_LABEL;
	}

	public void setCOMP_PBEN_REF_ID1_LABEL(
			HtmlOutputLabel comp_pben_ref_id1_label) {
		COMP_PBEN_REF_ID1_LABEL = comp_pben_ref_id1_label;
	}

	public HtmlInputText getCOMP_PBEN_REF_ID1() {
		return COMP_PBEN_REF_ID1;
	}

	public void setCOMP_PBEN_REF_ID1(HtmlInputText comp_pben_ref_id1) {
		COMP_PBEN_REF_ID1 = comp_pben_ref_id1;
	}

	public HtmlOutputLabel getCOMP_PBEN_REF_ID2_LABEL() {
		return COMP_PBEN_REF_ID2_LABEL;
	}

	public void setCOMP_PBEN_REF_ID2_LABEL(
			HtmlOutputLabel comp_pben_ref_id2_label) {
		COMP_PBEN_REF_ID2_LABEL = comp_pben_ref_id2_label;
	}

	public HtmlInputText getCOMP_PBEN_REF_ID2() {
		return COMP_PBEN_REF_ID2;
	}

	public void setCOMP_PBEN_REF_ID2(HtmlInputText comp_pben_ref_id2) {
		COMP_PBEN_REF_ID2 = comp_pben_ref_id2;
	}

	public HtmlOutputLabel getCOMP_PBEN_CATG_CODE_LABEL() {
		return COMP_PBEN_CATG_CODE_LABEL;
	}

	public void setCOMP_PBEN_CATG_CODE_LABEL(
			HtmlOutputLabel comp_pben_catg_code_label) {
		COMP_PBEN_CATG_CODE_LABEL = comp_pben_catg_code_label;
	}

	public HtmlInputText getCOMP_PBEN_CATG_CODE() {
		return COMP_PBEN_CATG_CODE;
	}

	public void setCOMP_PBEN_CATG_CODE(HtmlInputText comp_pben_catg_code) {
		COMP_PBEN_CATG_CODE = comp_pben_catg_code;
	}

	public HtmlOutputLabel getCOMP_PBEN_AGE_LABEL() {
		return COMP_PBEN_AGE_LABEL;
	}

	public void setCOMP_PBEN_AGE_LABEL(HtmlOutputLabel comp_pben_age_label) {
		COMP_PBEN_AGE_LABEL = comp_pben_age_label;
	}

	public HtmlInputText getCOMP_PBEN_AGE() {
		return COMP_PBEN_AGE;
	}

	public void setCOMP_PBEN_AGE(HtmlInputText comp_pben_age) {
		COMP_PBEN_AGE = comp_pben_age;
	}

	public HtmlInputText getCOMP_PBEN_RELATION_CODE() {
		return COMP_PBEN_RELATION_CODE;
	}

	public void setCOMP_PBEN_RELATION_CODE(HtmlInputText comp_pben_relation_code) {
		COMP_PBEN_RELATION_CODE = comp_pben_relation_code;
	}

	public HtmlOutputLabel getCOMP_PBEN_PERC_LABEL() {
		return COMP_PBEN_PERC_LABEL;
	}

	public void setCOMP_PBEN_PERC_LABEL(HtmlOutputLabel comp_pben_perc_label) {
		COMP_PBEN_PERC_LABEL = comp_pben_perc_label;
	}

	public HtmlInputText getCOMP_PBEN_PERC() {
		return COMP_PBEN_PERC;
	}

	public void setCOMP_PBEN_PERC(HtmlInputText comp_pben_perc) {
		COMP_PBEN_PERC = comp_pben_perc;
	}

	public HtmlOutputLabel getCOMP_PBEN_GUARDIAN_NAME_LABEL() {
		return COMP_PBEN_GUARDIAN_NAME_LABEL;
	}

	public void setCOMP_PBEN_GUARDIAN_NAME_LABEL(
			HtmlOutputLabel comp_pben_guardian_name_label) {
		COMP_PBEN_GUARDIAN_NAME_LABEL = comp_pben_guardian_name_label;
	}

	public HtmlInputText getCOMP_PBEN_GUARDIAN_NAME() {
		return COMP_PBEN_GUARDIAN_NAME;
	}

	public void setCOMP_PBEN_GUARDIAN_NAME(HtmlInputText comp_pben_guardian_name) {
		COMP_PBEN_GUARDIAN_NAME = comp_pben_guardian_name;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_1_LABEL() {
		return COMP_PBEN_ADDRESS_1_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_1_LABEL(
			HtmlOutputLabel comp_pben_address_1_label) {
		COMP_PBEN_ADDRESS_1_LABEL = comp_pben_address_1_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_1() {
		return COMP_PBEN_ADDRESS_1;
	}

	public void setCOMP_PBEN_ADDRESS_1(HtmlInputText comp_pben_address_1) {
		COMP_PBEN_ADDRESS_1 = comp_pben_address_1;
	}

	public HtmlOutputLabel getCOMP_PBEN_BNF_NAME_LABEL() {
		return COMP_PBEN_BNF_NAME_LABEL;
	}

	public void setCOMP_PBEN_BNF_NAME_LABEL(
			HtmlOutputLabel comp_pben_bnf_name_label) {
		COMP_PBEN_BNF_NAME_LABEL = comp_pben_bnf_name_label;
	}

	public HtmlInputText getCOMP_PBEN_BNF_NAME() {
		return COMP_PBEN_BNF_NAME;
	}

	public void setCOMP_PBEN_BNF_NAME(HtmlInputText comp_pben_bnf_name) {
		COMP_PBEN_BNF_NAME = comp_pben_bnf_name;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_2_LABEL() {
		return COMP_PBEN_ADDRESS_2_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_2_LABEL(
			HtmlOutputLabel comp_pben_address_2_label) {
		COMP_PBEN_ADDRESS_2_LABEL = comp_pben_address_2_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_2() {
		return COMP_PBEN_ADDRESS_2;
	}

	public void setCOMP_PBEN_ADDRESS_2(HtmlInputText comp_pben_address_2) {
		COMP_PBEN_ADDRESS_2 = comp_pben_address_2;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_4_LABEL() {
		return COMP_PBEN_ADDRESS_4_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_4_LABEL(
			HtmlOutputLabel comp_pben_address_4_label) {
		COMP_PBEN_ADDRESS_4_LABEL = comp_pben_address_4_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_4() {
		return COMP_PBEN_ADDRESS_4;
	}

	public void setCOMP_PBEN_ADDRESS_4(HtmlInputText comp_pben_address_4) {
		COMP_PBEN_ADDRESS_4 = comp_pben_address_4;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_5_LABEL() {
		return COMP_PBEN_ADDRESS_5_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_5_LABEL(
			HtmlOutputLabel comp_pben_address_5_label) {
		COMP_PBEN_ADDRESS_5_LABEL = comp_pben_address_5_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_5() {
		return COMP_PBEN_ADDRESS_5;
	}

	public void setCOMP_PBEN_ADDRESS_5(HtmlInputText comp_pben_address_5) {
		COMP_PBEN_ADDRESS_5 = comp_pben_address_5;
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}
	
	public void PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try { 
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_BNF_TYPE((String) value);
			helper.PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_REF_ID1((String) value);
			helper.PBEN_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,PT_IL_POL_BENEFICIARY_BEAN);

			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PBEN_REF_ID2_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_REF_ID2((String) value);

			helper.PBEN_REF_ID2_WHEN_VALIDATE_ITEM(getPT_IL_POL_BENEFICIARY_BEAN());
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_CATG_CODE((String) value);

			helper.PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_BENEFICIARY_BEAN());
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PBEN_AGE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_AGE((Integer) value);

			helper.PBEN_AGE_WHEN_VALIDATE_ITEM(this);
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_RELATION_CODE((String) value);

			helper.PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_BENEFICIARY_BEAN());
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PBEN_PERC_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component, Object value){
		try {
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_PERC((Double) value);
			helper.PBEN_PERC_WHEN_VALIDATE_ITEM(this,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_PBEN_BNF_TYPE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_BNF_TYPE";
		Object param1 = "ILBENFTYPE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =	itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public ArrayList<LovBean> prepareSuggestionList_PBEN_CATG_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_CATG_CODE";
		Object param1 = "CATG";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_RELATION_CODE";
		Object param1 = "ILBENFREL";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/**
	 * Disables all components in PT_IL_POL_BENEFICIARY_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PBEN_SR_NO.setDisabled(disabled);
		COMP_PBEN_BNF_TYPE.setDisabled(disabled);
		COMP_PBEN_REF_ID1.setDisabled(disabled);
		COMP_PBEN_REF_ID2.setDisabled(disabled);
		COMP_PBEN_CATG_CODE.setDisabled(disabled);
		COMP_PBEN_AGE.setDisabled(disabled);
		COMP_PBEN_RELATION_CODE.setDisabled(disabled);
		COMP_PBEN_PERC.setDisabled(disabled);
		COMP_PBEN_GUARDIAN_NAME.setDisabled(disabled);
		COMP_PBEN_ADDRESS_1.setDisabled(disabled);
		COMP_PBEN_BNF_NAME.setDisabled(disabled);
		COMP_PBEN_ADDRESS_3.setDisabled(disabled);
		COMP_PBEN_ADDRESS_2.setDisabled(disabled);
		COMP_PBEN_REMARKS.setDisabled(disabled);
		COMP_PBEN_ADDRESS_4.setDisabled(disabled);
		COMP_UI_M_CATG_DESC.setDisabled(disabled);
		COMP_PBEN_ADDRESS_5.setDisabled(disabled);
		COMP_UI_M_PBEN_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_PBEN_RELATION_DESC.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_BENEFICIARY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PBEN_SR_NO					 = new HtmlInputText();
		COMP_PBEN_BNF_TYPE				 = new HtmlInputText();
		COMP_PBEN_REF_ID1				 = new HtmlInputText();
		COMP_PBEN_REF_ID2				 = new HtmlInputText();
		COMP_PBEN_CATG_CODE				 = new HtmlInputText();
		COMP_PBEN_AGE					 = new HtmlInputText();
		COMP_PBEN_RELATION_CODE				 = new HtmlInputText();
		COMP_PBEN_PERC					 = new HtmlInputText();
		COMP_PBEN_GUARDIAN_NAME				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_1				 = new HtmlInputText();
		COMP_PBEN_BNF_NAME				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_3				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_2				 = new HtmlInputText();
		COMP_PBEN_REMARKS				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_4				 = new HtmlInputText();
		COMP_UI_M_CATG_DESC				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_5				 = new HtmlInputText();
		COMP_UI_M_PBEN_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_PBEN_RELATION_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PBEN_SR_NO_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_BNF_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_REF_ID1_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_REF_ID2_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_CATG_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_AGE_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_RELATION_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_GUARDIAN_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_1_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_BNF_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_3_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_2_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_REMARKS_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_4_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_CATG_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_5_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PBEN_TYPE_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PBEN_RELATION_DESC_LABEL		 = new HtmlOutputLabel();

	}


}

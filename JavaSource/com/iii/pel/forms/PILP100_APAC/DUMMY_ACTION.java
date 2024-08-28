package com.iii.pel.forms.PILP100_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_B_TEXT_01;
	private HtmlOutputLabel COMP_B_TEXT_02;
	private HtmlOutputLabel COMP_B_TEXT_03;
	private HtmlOutputLabel COMP_B_TEXT_04;
	private HtmlOutputLabel COMP_B_TEXT_05;
	private HtmlOutputLabel COMP_B_TEXT_06;
	private HtmlOutputLabel COMP_B_TEXT_07;
	private HtmlOutputLabel COMP_B_TEXT_08;
	private HtmlOutputLabel COMP_B_TEXT_09;
	private HtmlOutputLabel COMP_B_TEXT_10;
	private HtmlOutputLabel COMP_B_TEXT_11;
	private HtmlOutputLabel COMP_B_TEXT_12;
	private HtmlOutputLabel COMP_B_TEXT_13;
	private HtmlOutputLabel COMP_B_TEXT_14;
	private HtmlOutputLabel COMP_B_TEXT_15;
	
	private HtmlOutputLabel COMP_UI_M_PRINT_YN_LABEL;
	private HtmlOutputLabel COMP_UI_M_PREVIEW_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_01;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_02;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_03;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_04;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_05;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_06;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_07;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_08;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_09;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_10;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_11;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_12;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_13;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_14;
	private HtmlSelectOneMenu COMP_UI_M_PRINT_YN_15;
	
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_01;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_02;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_03;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_04;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_05;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_06;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_07;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_08;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_09;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_10;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_11;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_12;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_13;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_14;
	private HtmlSelectOneMenu COMP_UI_M_PREVIEW_YN_15;
	
	private HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL;
	
	private HtmlInputText COMP_UI_M_DOC_NO;
	
	private HtmlCommandButton COMP_UI_M_BUT_OK;
	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;
	private DUMMY DUMMY_BEAN;
	public PILP100_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY_HELPER helper;

	private List<SelectItem> listUI_M_PRINT_YN_01 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_02 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_03 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_04 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_05 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_06 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_07 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_08 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_09 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_10 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_11 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_12 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_13 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_14 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PRINT_YN_15 = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_PREVIEW_YN_01 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_02 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_03 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_04 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_05 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_06 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_07 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_08 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_09 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_10 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_11 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_12 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_13 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_14 = new ArrayList<SelectItem>();
	private List<SelectItem> listUI_M_PREVIEW_YN_15 = new ArrayList<SelectItem>();

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		prepareDropDowns();
		instantiateAllComponent();
	}

	public void prepareDropDowns(){
		try{
			Connection connection = CommonUtils.getConnection();
			setListUI_M_PRINT_YN_01(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_01", null));
			setListUI_M_PRINT_YN_02(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_02", null));
			setListUI_M_PRINT_YN_03(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_03", null));
			setListUI_M_PRINT_YN_04(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_04", null));
			setListUI_M_PRINT_YN_05(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_05", null));
			setListUI_M_PRINT_YN_06(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_06", null));
			setListUI_M_PRINT_YN_07(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_07", null));
			setListUI_M_PRINT_YN_08(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_08", null));
			setListUI_M_PRINT_YN_09(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_09", null));
			setListUI_M_PRINT_YN_10(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_10", null));
			setListUI_M_PRINT_YN_11(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_11", null));
			setListUI_M_PRINT_YN_12(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_12", null));
			setListUI_M_PRINT_YN_13(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_13", null));
			setListUI_M_PRINT_YN_14(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_14", null));
			setListUI_M_PRINT_YN_15(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PRINT_YN_15", null));
			
			setListUI_M_PREVIEW_YN_01(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_01", null));
			setListUI_M_PREVIEW_YN_02(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_02", null));
			setListUI_M_PREVIEW_YN_03(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_03", null));
			setListUI_M_PREVIEW_YN_04(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_04", null));
			setListUI_M_PREVIEW_YN_05(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_05", null));
			setListUI_M_PREVIEW_YN_06(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_06", null));
			setListUI_M_PREVIEW_YN_07(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_07", null));
			setListUI_M_PREVIEW_YN_08(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_08", null));
			setListUI_M_PREVIEW_YN_09(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_09", null));
			setListUI_M_PREVIEW_YN_10(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_10", null));
			setListUI_M_PREVIEW_YN_11(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_11", null));
			setListUI_M_PREVIEW_YN_12(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_12", null));
			setListUI_M_PREVIEW_YN_13(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_13", null));
			setListUI_M_PREVIEW_YN_14(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_14", null));
			setListUI_M_PREVIEW_YN_15(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP100_APAC", "DUMMY",
					"DUMMY.M_PREVIEW_YN_15", null));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	public void saveRecord() {
		try {
			if (getDUMMY_BEAN().getROWID() != null) {
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onLoad(PhaseEvent event) {
		 try {
			if(isFormFlag()){
				helper.when_new_form_instance(this);
				setFormFlag(false);
			}
			 if (isBlockFlag()) {
				helper.when_create_record(DUMMY_BEAN);
			} 
		 }catch (Exception e) {
		 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		 getErrorMap().put("onLoad",e.getMessage());
		 }
	}

	public String main(){
		return "PILT002_APAC_PT_IL_POLICY";
	}
	
	public PILP100_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP100_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_01() {
		return listUI_M_PRINT_YN_01;
	}

	public void setListUI_M_PRINT_YN_01(List<SelectItem> listUI_M_PRINT_YN_01) {
		this.listUI_M_PRINT_YN_01 = listUI_M_PRINT_YN_01;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_02() {
		return listUI_M_PRINT_YN_02;
	}

	public void setListUI_M_PRINT_YN_02(List<SelectItem> listUI_M_PRINT_YN_02) {
		this.listUI_M_PRINT_YN_02 = listUI_M_PRINT_YN_02;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_03() {
		return listUI_M_PRINT_YN_03;
	}

	public void setListUI_M_PRINT_YN_03(List<SelectItem> listUI_M_PRINT_YN_03) {
		this.listUI_M_PRINT_YN_03 = listUI_M_PRINT_YN_03;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_04() {
		return listUI_M_PRINT_YN_04;
	}

	public void setListUI_M_PRINT_YN_04(List<SelectItem> listUI_M_PRINT_YN_04) {
		this.listUI_M_PRINT_YN_04 = listUI_M_PRINT_YN_04;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_05() {
		return listUI_M_PRINT_YN_05;
	}

	public void setListUI_M_PRINT_YN_05(List<SelectItem> listUI_M_PRINT_YN_05) {
		this.listUI_M_PRINT_YN_05 = listUI_M_PRINT_YN_05;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_06() {
		return listUI_M_PRINT_YN_06;
	}

	public void setListUI_M_PRINT_YN_06(List<SelectItem> listUI_M_PRINT_YN_06) {
		this.listUI_M_PRINT_YN_06 = listUI_M_PRINT_YN_06;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_07() {
		return listUI_M_PRINT_YN_07;
	}

	public void setListUI_M_PRINT_YN_07(List<SelectItem> listUI_M_PRINT_YN_07) {
		this.listUI_M_PRINT_YN_07 = listUI_M_PRINT_YN_07;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_08() {
		return listUI_M_PRINT_YN_08;
	}

	public void setListUI_M_PRINT_YN_08(List<SelectItem> listUI_M_PRINT_YN_08) {
		this.listUI_M_PRINT_YN_08 = listUI_M_PRINT_YN_08;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_09() {
		return listUI_M_PRINT_YN_09;
	}

	public void setListUI_M_PRINT_YN_09(List<SelectItem> listUI_M_PRINT_YN_09) {
		this.listUI_M_PRINT_YN_09 = listUI_M_PRINT_YN_09;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_10() {
		return listUI_M_PRINT_YN_10;
	}

	public void setListUI_M_PRINT_YN_10(List<SelectItem> listUI_M_PRINT_YN_10) {
		this.listUI_M_PRINT_YN_10 = listUI_M_PRINT_YN_10;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_11() {
		return listUI_M_PRINT_YN_11;
	}

	public void setListUI_M_PRINT_YN_11(List<SelectItem> listUI_M_PRINT_YN_11) {
		this.listUI_M_PRINT_YN_11 = listUI_M_PRINT_YN_11;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_12() {
		return listUI_M_PRINT_YN_12;
	}

	public void setListUI_M_PRINT_YN_12(List<SelectItem> listUI_M_PRINT_YN_12) {
		this.listUI_M_PRINT_YN_12 = listUI_M_PRINT_YN_12;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_13() {
		return listUI_M_PRINT_YN_13;
	}

	public void setListUI_M_PRINT_YN_13(List<SelectItem> listUI_M_PRINT_YN_13) {
		this.listUI_M_PRINT_YN_13 = listUI_M_PRINT_YN_13;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_14() {
		return listUI_M_PRINT_YN_14;
	}

	public void setListUI_M_PRINT_YN_14(List<SelectItem> listUI_M_PRINT_YN_14) {
		this.listUI_M_PRINT_YN_14 = listUI_M_PRINT_YN_14;
	}

	public List<SelectItem> getListUI_M_PRINT_YN_15() {
		return listUI_M_PRINT_YN_15;
	}

	public void setListUI_M_PRINT_YN_15(List<SelectItem> listUI_M_PRINT_YN_15) {
		this.listUI_M_PRINT_YN_15 = listUI_M_PRINT_YN_15;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_01() {
		return listUI_M_PREVIEW_YN_01;
	}

	public void setListUI_M_PREVIEW_YN_01(List<SelectItem> listUI_M_PREVIEW_YN_01) {
		this.listUI_M_PREVIEW_YN_01 = listUI_M_PREVIEW_YN_01;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_02() {
		return listUI_M_PREVIEW_YN_02;
	}

	public void setListUI_M_PREVIEW_YN_02(List<SelectItem> listUI_M_PREVIEW_YN_02) {
		this.listUI_M_PREVIEW_YN_02 = listUI_M_PREVIEW_YN_02;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_03() {
		return listUI_M_PREVIEW_YN_03;
	}

	public void setListUI_M_PREVIEW_YN_03(List<SelectItem> listUI_M_PREVIEW_YN_03) {
		this.listUI_M_PREVIEW_YN_03 = listUI_M_PREVIEW_YN_03;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_04() {
		return listUI_M_PREVIEW_YN_04;
	}

	public void setListUI_M_PREVIEW_YN_04(List<SelectItem> listUI_M_PREVIEW_YN_04) {
		this.listUI_M_PREVIEW_YN_04 = listUI_M_PREVIEW_YN_04;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_05() {
		return listUI_M_PREVIEW_YN_05;
	}

	public void setListUI_M_PREVIEW_YN_05(List<SelectItem> listUI_M_PREVIEW_YN_05) {
		this.listUI_M_PREVIEW_YN_05 = listUI_M_PREVIEW_YN_05;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_06() {
		return listUI_M_PREVIEW_YN_06;
	}

	public void setListUI_M_PREVIEW_YN_06(List<SelectItem> listUI_M_PREVIEW_YN_06) {
		this.listUI_M_PREVIEW_YN_06 = listUI_M_PREVIEW_YN_06;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_07() {
		return listUI_M_PREVIEW_YN_07;
	}

	public void setListUI_M_PREVIEW_YN_07(List<SelectItem> listUI_M_PREVIEW_YN_07) {
		this.listUI_M_PREVIEW_YN_07 = listUI_M_PREVIEW_YN_07;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_08() {
		return listUI_M_PREVIEW_YN_08;
	}

	public void setListUI_M_PREVIEW_YN_08(List<SelectItem> listUI_M_PREVIEW_YN_08) {
		this.listUI_M_PREVIEW_YN_08 = listUI_M_PREVIEW_YN_08;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_09() {
		return listUI_M_PREVIEW_YN_09;
	}

	public void setListUI_M_PREVIEW_YN_09(List<SelectItem> listUI_M_PREVIEW_YN_09) {
		this.listUI_M_PREVIEW_YN_09 = listUI_M_PREVIEW_YN_09;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_10() {
		return listUI_M_PREVIEW_YN_10;
	}

	public void setListUI_M_PREVIEW_YN_10(List<SelectItem> listUI_M_PREVIEW_YN_10) {
		this.listUI_M_PREVIEW_YN_10 = listUI_M_PREVIEW_YN_10;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_11() {
		return listUI_M_PREVIEW_YN_11;
	}

	public void setListUI_M_PREVIEW_YN_11(List<SelectItem> listUI_M_PREVIEW_YN_11) {
		this.listUI_M_PREVIEW_YN_11 = listUI_M_PREVIEW_YN_11;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_12() {
		return listUI_M_PREVIEW_YN_12;
	}

	public void setListUI_M_PREVIEW_YN_12(List<SelectItem> listUI_M_PREVIEW_YN_12) {
		this.listUI_M_PREVIEW_YN_12 = listUI_M_PREVIEW_YN_12;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_13() {
		return listUI_M_PREVIEW_YN_13;
	}

	public void setListUI_M_PREVIEW_YN_13(List<SelectItem> listUI_M_PREVIEW_YN_13) {
		this.listUI_M_PREVIEW_YN_13 = listUI_M_PREVIEW_YN_13;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_14() {
		return listUI_M_PREVIEW_YN_14;
	}

	public void setListUI_M_PREVIEW_YN_14(List<SelectItem> listUI_M_PREVIEW_YN_14) {
		this.listUI_M_PREVIEW_YN_14 = listUI_M_PREVIEW_YN_14;
	}

	public List<SelectItem> getListUI_M_PREVIEW_YN_15() {
		return listUI_M_PREVIEW_YN_15;
	}

	public void setListUI_M_PREVIEW_YN_15(List<SelectItem> listUI_M_PREVIEW_YN_15) {
		this.listUI_M_PREVIEW_YN_15 = listUI_M_PREVIEW_YN_15;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_01() {
		return COMP_B_TEXT_01;
	}

	public void setCOMP_B_TEXT_01(HtmlOutputLabel comp_b_text_01) {
		COMP_B_TEXT_01 = comp_b_text_01;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_02() {
		return COMP_B_TEXT_02;
	}

	public void setCOMP_B_TEXT_02(HtmlOutputLabel comp_b_text_02) {
		COMP_B_TEXT_02 = comp_b_text_02;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_03() {
		return COMP_B_TEXT_03;
	}

	public void setCOMP_B_TEXT_03(HtmlOutputLabel comp_b_text_03) {
		COMP_B_TEXT_03 = comp_b_text_03;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_04() {
		return COMP_B_TEXT_04;
	}

	public void setCOMP_B_TEXT_04(HtmlOutputLabel comp_b_text_04) {
		COMP_B_TEXT_04 = comp_b_text_04;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_05() {
		return COMP_B_TEXT_05;
	}

	public void setCOMP_B_TEXT_05(HtmlOutputLabel comp_b_text_05) {
		COMP_B_TEXT_05 = comp_b_text_05;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_06() {
		return COMP_B_TEXT_06;
	}

	public void setCOMP_B_TEXT_06(HtmlOutputLabel comp_b_text_06) {
		COMP_B_TEXT_06 = comp_b_text_06;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_07() {
		return COMP_B_TEXT_07;
	}

	public void setCOMP_B_TEXT_07(HtmlOutputLabel comp_b_text_07) {
		COMP_B_TEXT_07 = comp_b_text_07;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_08() {
		return COMP_B_TEXT_08;
	}

	public void setCOMP_B_TEXT_08(HtmlOutputLabel comp_b_text_08) {
		COMP_B_TEXT_08 = comp_b_text_08;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_09() {
		return COMP_B_TEXT_09;
	}

	public void setCOMP_B_TEXT_09(HtmlOutputLabel comp_b_text_09) {
		COMP_B_TEXT_09 = comp_b_text_09;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_10() {
		return COMP_B_TEXT_10;
	}

	public void setCOMP_B_TEXT_10(HtmlOutputLabel comp_b_text_10) {
		COMP_B_TEXT_10 = comp_b_text_10;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_11() {
		return COMP_B_TEXT_11;
	}

	public void setCOMP_B_TEXT_11(HtmlOutputLabel comp_b_text_11) {
		COMP_B_TEXT_11 = comp_b_text_11;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_12() {
		return COMP_B_TEXT_12;
	}

	public void setCOMP_B_TEXT_12(HtmlOutputLabel comp_b_text_12) {
		COMP_B_TEXT_12 = comp_b_text_12;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_13() {
		return COMP_B_TEXT_13;
	}

	public void setCOMP_B_TEXT_13(HtmlOutputLabel comp_b_text_13) {
		COMP_B_TEXT_13 = comp_b_text_13;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_14() {
		return COMP_B_TEXT_14;
	}

	public void setCOMP_B_TEXT_14(HtmlOutputLabel comp_b_text_14) {
		COMP_B_TEXT_14 = comp_b_text_14;
	}

	public HtmlOutputLabel getCOMP_B_TEXT_15() {
		return COMP_B_TEXT_15;
	}

	public void setCOMP_B_TEXT_15(HtmlOutputLabel comp_b_text_15) {
		COMP_B_TEXT_15 = comp_b_text_15;
	}

	public HtmlOutputLabel getCOMP_UI_M_DOC_NO_LABEL() {
		return COMP_UI_M_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DOC_NO_LABEL(HtmlOutputLabel comp_ui_m_doc_no_label) {
		COMP_UI_M_DOC_NO_LABEL = comp_ui_m_doc_no_label;
	}

	public HtmlInputText getCOMP_UI_M_DOC_NO() {
		return COMP_UI_M_DOC_NO;
	}

	public void setCOMP_UI_M_DOC_NO(HtmlInputText comp_ui_m_doc_no) {
		COMP_UI_M_DOC_NO = comp_ui_m_doc_no;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_01() {
		return COMP_UI_M_PRINT_YN_01;
	}

	public void setCOMP_UI_M_PRINT_YN_01(HtmlSelectOneMenu comp_ui_m_print_yn_01) {
		COMP_UI_M_PRINT_YN_01 = comp_ui_m_print_yn_01;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_02() {
		return COMP_UI_M_PRINT_YN_02;
	}

	public void setCOMP_UI_M_PRINT_YN_02(HtmlSelectOneMenu comp_ui_m_print_yn_02) {
		COMP_UI_M_PRINT_YN_02 = comp_ui_m_print_yn_02;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_03() {
		return COMP_UI_M_PRINT_YN_03;
	}

	public void setCOMP_UI_M_PRINT_YN_03(HtmlSelectOneMenu comp_ui_m_print_yn_03) {
		COMP_UI_M_PRINT_YN_03 = comp_ui_m_print_yn_03;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_04() {
		return COMP_UI_M_PRINT_YN_04;
	}

	public void setCOMP_UI_M_PRINT_YN_04(HtmlSelectOneMenu comp_ui_m_print_yn_04) {
		COMP_UI_M_PRINT_YN_04 = comp_ui_m_print_yn_04;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_05() {
		return COMP_UI_M_PRINT_YN_05;
	}

	public void setCOMP_UI_M_PRINT_YN_05(HtmlSelectOneMenu comp_ui_m_print_yn_05) {
		COMP_UI_M_PRINT_YN_05 = comp_ui_m_print_yn_05;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_06() {
		return COMP_UI_M_PRINT_YN_06;
	}

	public void setCOMP_UI_M_PRINT_YN_06(HtmlSelectOneMenu comp_ui_m_print_yn_06) {
		COMP_UI_M_PRINT_YN_06 = comp_ui_m_print_yn_06;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_07() {
		return COMP_UI_M_PRINT_YN_07;
	}

	public void setCOMP_UI_M_PRINT_YN_07(HtmlSelectOneMenu comp_ui_m_print_yn_07) {
		COMP_UI_M_PRINT_YN_07 = comp_ui_m_print_yn_07;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_08() {
		return COMP_UI_M_PRINT_YN_08;
	}

	public void setCOMP_UI_M_PRINT_YN_08(HtmlSelectOneMenu comp_ui_m_print_yn_08) {
		COMP_UI_M_PRINT_YN_08 = comp_ui_m_print_yn_08;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_09() {
		return COMP_UI_M_PRINT_YN_09;
	}

	public void setCOMP_UI_M_PRINT_YN_09(HtmlSelectOneMenu comp_ui_m_print_yn_09) {
		COMP_UI_M_PRINT_YN_09 = comp_ui_m_print_yn_09;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_10() {
		return COMP_UI_M_PRINT_YN_10;
	}

	public void setCOMP_UI_M_PRINT_YN_10(HtmlSelectOneMenu comp_ui_m_print_yn_10) {
		COMP_UI_M_PRINT_YN_10 = comp_ui_m_print_yn_10;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_11() {
		return COMP_UI_M_PRINT_YN_11;
	}

	public void setCOMP_UI_M_PRINT_YN_11(HtmlSelectOneMenu comp_ui_m_print_yn_11) {
		COMP_UI_M_PRINT_YN_11 = comp_ui_m_print_yn_11;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_12() {
		return COMP_UI_M_PRINT_YN_12;
	}

	public void setCOMP_UI_M_PRINT_YN_12(HtmlSelectOneMenu comp_ui_m_print_yn_12) {
		COMP_UI_M_PRINT_YN_12 = comp_ui_m_print_yn_12;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_13() {
		return COMP_UI_M_PRINT_YN_13;
	}

	public void setCOMP_UI_M_PRINT_YN_13(HtmlSelectOneMenu comp_ui_m_print_yn_13) {
		COMP_UI_M_PRINT_YN_13 = comp_ui_m_print_yn_13;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_14() {
		return COMP_UI_M_PRINT_YN_14;
	}

	public void setCOMP_UI_M_PRINT_YN_14(HtmlSelectOneMenu comp_ui_m_print_yn_14) {
		COMP_UI_M_PRINT_YN_14 = comp_ui_m_print_yn_14;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINT_YN_15() {
		return COMP_UI_M_PRINT_YN_15;
	}

	public void setCOMP_UI_M_PRINT_YN_15(HtmlSelectOneMenu comp_ui_m_print_yn_15) {
		COMP_UI_M_PRINT_YN_15 = comp_ui_m_print_yn_15;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_01() {
		return COMP_UI_M_PREVIEW_YN_01;
	}

	public void setCOMP_UI_M_PREVIEW_YN_01(HtmlSelectOneMenu comp_ui_m_preview_yn_01) {
		COMP_UI_M_PREVIEW_YN_01 = comp_ui_m_preview_yn_01;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_02() {
		return COMP_UI_M_PREVIEW_YN_02;
	}

	public void setCOMP_UI_M_PREVIEW_YN_02(HtmlSelectOneMenu comp_ui_m_preview_yn_02) {
		COMP_UI_M_PREVIEW_YN_02 = comp_ui_m_preview_yn_02;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_03() {
		return COMP_UI_M_PREVIEW_YN_03;
	}

	public void setCOMP_UI_M_PREVIEW_YN_03(HtmlSelectOneMenu comp_ui_m_preview_yn_03) {
		COMP_UI_M_PREVIEW_YN_03 = comp_ui_m_preview_yn_03;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_04() {
		return COMP_UI_M_PREVIEW_YN_04;
	}

	public void setCOMP_UI_M_PREVIEW_YN_04(HtmlSelectOneMenu comp_ui_m_preview_yn_04) {
		COMP_UI_M_PREVIEW_YN_04 = comp_ui_m_preview_yn_04;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_05() {
		return COMP_UI_M_PREVIEW_YN_05;
	}

	public void setCOMP_UI_M_PREVIEW_YN_05(HtmlSelectOneMenu comp_ui_m_preview_yn_05) {
		COMP_UI_M_PREVIEW_YN_05 = comp_ui_m_preview_yn_05;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_06() {
		return COMP_UI_M_PREVIEW_YN_06;
	}

	public void setCOMP_UI_M_PREVIEW_YN_06(HtmlSelectOneMenu comp_ui_m_preview_yn_06) {
		COMP_UI_M_PREVIEW_YN_06 = comp_ui_m_preview_yn_06;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_07() {
		return COMP_UI_M_PREVIEW_YN_07;
	}

	public void setCOMP_UI_M_PREVIEW_YN_07(HtmlSelectOneMenu comp_ui_m_preview_yn_07) {
		COMP_UI_M_PREVIEW_YN_07 = comp_ui_m_preview_yn_07;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_08() {
		return COMP_UI_M_PREVIEW_YN_08;
	}

	public void setCOMP_UI_M_PREVIEW_YN_08(HtmlSelectOneMenu comp_ui_m_preview_yn_08) {
		COMP_UI_M_PREVIEW_YN_08 = comp_ui_m_preview_yn_08;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_09() {
		return COMP_UI_M_PREVIEW_YN_09;
	}

	public void setCOMP_UI_M_PREVIEW_YN_09(HtmlSelectOneMenu comp_ui_m_preview_yn_09) {
		COMP_UI_M_PREVIEW_YN_09 = comp_ui_m_preview_yn_09;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_10() {
		return COMP_UI_M_PREVIEW_YN_10;
	}

	public void setCOMP_UI_M_PREVIEW_YN_10(HtmlSelectOneMenu comp_ui_m_preview_yn_10) {
		COMP_UI_M_PREVIEW_YN_10 = comp_ui_m_preview_yn_10;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_11() {
		return COMP_UI_M_PREVIEW_YN_11;
	}

	public void setCOMP_UI_M_PREVIEW_YN_11(HtmlSelectOneMenu comp_ui_m_preview_yn_11) {
		COMP_UI_M_PREVIEW_YN_11 = comp_ui_m_preview_yn_11;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_12() {
		return COMP_UI_M_PREVIEW_YN_12;
	}

	public void setCOMP_UI_M_PREVIEW_YN_12(HtmlSelectOneMenu comp_ui_m_preview_yn_12) {
		COMP_UI_M_PREVIEW_YN_12 = comp_ui_m_preview_yn_12;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_13() {
		return COMP_UI_M_PREVIEW_YN_13;
	}

	public void setCOMP_UI_M_PREVIEW_YN_13(HtmlSelectOneMenu comp_ui_m_preview_yn_13) {
		COMP_UI_M_PREVIEW_YN_13 = comp_ui_m_preview_yn_13;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_14() {
		return COMP_UI_M_PREVIEW_YN_14;
	}

	public void setCOMP_UI_M_PREVIEW_YN_14(HtmlSelectOneMenu comp_ui_m_preview_yn_14) {
		COMP_UI_M_PREVIEW_YN_14 = comp_ui_m_preview_yn_14;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREVIEW_YN_15() {
		return COMP_UI_M_PREVIEW_YN_15;
	}

	public void setCOMP_UI_M_PREVIEW_YN_15(HtmlSelectOneMenu comp_ui_m_preview_yn_15) {
		COMP_UI_M_PREVIEW_YN_15 = comp_ui_m_preview_yn_15;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton comp_ui_m_but_cancel) {
		COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRINT_YN_LABEL() {
		return COMP_UI_M_PRINT_YN_LABEL;
	}

	public void setCOMP_UI_M_PRINT_YN_LABEL(HtmlOutputLabel comp_ui_m_print_yn_label) {
		COMP_UI_M_PRINT_YN_LABEL = comp_ui_m_print_yn_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREVIEW_YN_LABEL() {
		return COMP_UI_M_PREVIEW_YN_LABEL;
	}

	public void setCOMP_UI_M_PREVIEW_YN_LABEL(
			HtmlOutputLabel comp_ui_m_preview_yn_label) {
		COMP_UI_M_PREVIEW_YN_LABEL = comp_ui_m_preview_yn_label;
	}
	

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_DOC_NO				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_PRINT_YN_01				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_02				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_03				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_04				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_05				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_06				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_07				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_08				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_09				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_10				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_11				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_12				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_13				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_14				 = new HtmlSelectOneMenu();
		COMP_UI_M_PRINT_YN_15				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_01				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_02				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_03				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_04				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_05				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_06				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_07				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_08				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_09				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_10				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_11				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_12				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_13				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_14				 = new HtmlSelectOneMenu();
		COMP_UI_M_PREVIEW_YN_15				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CANCEL				 = new HtmlCommandButton();

	}

	/**
	 * Resets all components in DUMMY_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_DOC_NO.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_UI_M_PRINT_YN_01.resetValue();
		COMP_UI_M_PRINT_YN_02.resetValue();
		COMP_UI_M_PRINT_YN_03.resetValue();
		COMP_UI_M_PRINT_YN_04.resetValue();
		COMP_UI_M_PRINT_YN_05.resetValue();
		COMP_UI_M_PRINT_YN_06.resetValue();
		COMP_UI_M_PRINT_YN_07.resetValue();
		COMP_UI_M_PRINT_YN_08.resetValue();
		COMP_UI_M_PRINT_YN_09.resetValue();
		COMP_UI_M_PRINT_YN_10.resetValue();
		COMP_UI_M_PRINT_YN_11.resetValue();
		COMP_UI_M_PRINT_YN_12.resetValue();
		COMP_UI_M_PRINT_YN_13.resetValue();
		COMP_UI_M_PRINT_YN_14.resetValue();
		COMP_UI_M_PRINT_YN_15.resetValue();
		COMP_UI_M_PREVIEW_YN_01.resetValue();
		COMP_UI_M_PREVIEW_YN_02.resetValue();
		COMP_UI_M_PREVIEW_YN_03.resetValue();
		COMP_UI_M_PREVIEW_YN_04.resetValue();
		COMP_UI_M_PREVIEW_YN_05.resetValue();
		COMP_UI_M_PREVIEW_YN_06.resetValue();
		COMP_UI_M_PREVIEW_YN_07.resetValue();
		COMP_UI_M_PREVIEW_YN_08.resetValue();
		COMP_UI_M_PREVIEW_YN_09.resetValue();
		COMP_UI_M_PREVIEW_YN_10.resetValue();
		COMP_UI_M_PREVIEW_YN_11.resetValue();
		COMP_UI_M_PREVIEW_YN_12.resetValue();
		COMP_UI_M_PREVIEW_YN_13.resetValue();
		COMP_UI_M_PREVIEW_YN_14.resetValue();
		COMP_UI_M_PREVIEW_YN_15.resetValue();

		// Reseting HtmlCommandButton
		//COMP_UI_M_BUT_OK.resetValue();
		//COMP_UI_M_BUT_CANCEL.resetValue();

	}

	/**
	 * Disables all components in DUMMY_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_UI_M_DOC_NO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_UI_M_PRINT_YN_01.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_02.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_03.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_04.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_05.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_06.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_07.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_08.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_09.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_10.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_11.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_12.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_13.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_14.setDisabled(disabled);
		COMP_UI_M_PRINT_YN_15.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_01.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_02.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_03.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_04.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_05.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_06.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_07.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_08.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_09.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_10.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_11.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_12.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_13.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_14.setDisabled(disabled);
		COMP_UI_M_PREVIEW_YN_15.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_OK.setDisabled(disabled);
		COMP_UI_M_BUT_CANCEL.setDisabled(disabled);

	}

	public String backButton(){
		return "PILT002_APAC_PT_IL_POLICY";
	}

 }

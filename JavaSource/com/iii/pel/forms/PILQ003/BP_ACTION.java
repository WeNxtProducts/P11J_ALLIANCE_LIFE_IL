package com.iii.pel.forms.PILQ003;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class BP_ACTION extends CommonAction {

	private BP BP_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;
	
	private HtmlInputText COMP_B_POL_PROP_NO;
	private HtmlInputText COMP_B_ASS_FC_VALUES;
	private HtmlInputText COMP_B_ASS_LC_VALUES;
	private HtmlInputText COMP_B_ASS_SUM_ASSURED;
	private HtmlInputText COMP_B_ASS_AMAN_PREM;   
	private HtmlInputText COMP_B_ASS_AMAN_LOAD_PREM; 
	private HtmlInputText COMP_B_ASS_SENABEL_PREM;
	
	private HtmlInputText COMP_B_ASS_SUM_ASSURED_1;
	private HtmlInputText COMP_B_ASS_AMAN_PREM_1;
	private HtmlInputText COMP_B_ASS_AMAN_LOAD_PREM_1; 
	private HtmlInputText COMP_B_ASS_SENABEL_PREM_1;
	private HtmlInputText COMP_B_POL_CARD_HOLDER_NAME;
	private HtmlInputText COMP_B_POL_AUTH_LIMIT;
	private BP_HELPER helper;



public BP_ACTION(){


BP_BEAN = new BP();
helper = new BP_HELPER();
}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP BP_BEAN) {
		this.BP_BEAN = BP_BEAN;
	}
	public void saveRecord() {
		try {
			if (getBP_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getBP_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getBP_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
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
		}
	} catch (Exception e) {
 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
 getErrorMap().put("onLoad",e.getMessage());
 }
 }

	public HtmlInputText getCOMP_B_POL_PROP_NO() {
		return COMP_B_POL_PROP_NO;
	}

	public void setCOMP_B_POL_PROP_NO(HtmlInputText comp_b_pol_prop_no) {
		COMP_B_POL_PROP_NO = comp_b_pol_prop_no;
	}

	public HtmlInputText getCOMP_B_ASS_FC_VALUES() {
		return COMP_B_ASS_FC_VALUES;
	}

	public void setCOMP_B_ASS_FC_VALUES(HtmlInputText comp_b_ass_fc_values) {
		COMP_B_ASS_FC_VALUES = comp_b_ass_fc_values;
	}

	public HtmlInputText getCOMP_B_ASS_LC_VALUES() {
		return COMP_B_ASS_LC_VALUES;
	}

	public void setCOMP_B_ASS_LC_VALUES(HtmlInputText comp_b_ass_lc_values) {
		COMP_B_ASS_LC_VALUES = comp_b_ass_lc_values;
	}

	public HtmlInputText getCOMP_B_ASS_SUM_ASSURED() {
		return COMP_B_ASS_SUM_ASSURED;
	}

	public void setCOMP_B_ASS_SUM_ASSURED(HtmlInputText comp_b_ass_sum_assured) {
		COMP_B_ASS_SUM_ASSURED = comp_b_ass_sum_assured;
	}

	public HtmlInputText getCOMP_B_ASS_AMAN_PREM() {
		return COMP_B_ASS_AMAN_PREM;
	}

	public void setCOMP_B_ASS_AMAN_PREM(HtmlInputText comp_b_ass_aman_prem) {
		COMP_B_ASS_AMAN_PREM = comp_b_ass_aman_prem;
	}

	public HtmlInputText getCOMP_B_ASS_AMAN_LOAD_PREM() {
		return COMP_B_ASS_AMAN_LOAD_PREM;
	}

	public void setCOMP_B_ASS_AMAN_LOAD_PREM(HtmlInputText comp_b_ass_aman_load_prem) {
		COMP_B_ASS_AMAN_LOAD_PREM = comp_b_ass_aman_load_prem;
	}

	public HtmlInputText getCOMP_B_ASS_SENABEL_PREM() {
		return COMP_B_ASS_SENABEL_PREM;
	}

	public void setCOMP_B_ASS_SENABEL_PREM(HtmlInputText comp_b_ass_senabel_prem) {
		COMP_B_ASS_SENABEL_PREM = comp_b_ass_senabel_prem;
	}

	public HtmlInputText getCOMP_B_ASS_SUM_ASSURED_1() {
		return COMP_B_ASS_SUM_ASSURED_1;
	}

	public void setCOMP_B_ASS_SUM_ASSURED_1(HtmlInputText comp_b_ass_sum_assured_1) {
		COMP_B_ASS_SUM_ASSURED_1 = comp_b_ass_sum_assured_1;
	}

	public HtmlInputText getCOMP_B_ASS_AMAN_PREM_1() {
		return COMP_B_ASS_AMAN_PREM_1;
	}

	public void setCOMP_B_ASS_AMAN_PREM_1(HtmlInputText comp_b_ass_aman_prem_1) {
		COMP_B_ASS_AMAN_PREM_1 = comp_b_ass_aman_prem_1;
	}

	public HtmlInputText getCOMP_B_ASS_AMAN_LOAD_PREM_1() {
		return COMP_B_ASS_AMAN_LOAD_PREM_1;
	}

	public void setCOMP_B_ASS_AMAN_LOAD_PREM_1(
			HtmlInputText comp_b_ass_aman_load_prem_1) {
		COMP_B_ASS_AMAN_LOAD_PREM_1 = comp_b_ass_aman_load_prem_1;
	}

	public HtmlInputText getCOMP_B_ASS_SENABEL_PREM_1() {
		return COMP_B_ASS_SENABEL_PREM_1;
	}

	public void setCOMP_B_ASS_SENABEL_PREM_1(HtmlInputText comp_b_ass_senabel_prem_1) {
		COMP_B_ASS_SENABEL_PREM_1 = comp_b_ass_senabel_prem_1;
	}

	public HtmlInputText getCOMP_B_POL_CARD_HOLDER_NAME() {
		return COMP_B_POL_CARD_HOLDER_NAME;
	}

	public void setCOMP_B_POL_CARD_HOLDER_NAME(
			HtmlInputText comp_b_pol_card_holder_name) {
		COMP_B_POL_CARD_HOLDER_NAME = comp_b_pol_card_holder_name;
	}

	public HtmlInputText getCOMP_B_POL_AUTH_LIMIT() {
		return COMP_B_POL_AUTH_LIMIT;
	}

	public void setCOMP_B_POL_AUTH_LIMIT(HtmlInputText comp_b_pol_auth_limit) {
		COMP_B_POL_AUTH_LIMIT = comp_b_pol_auth_limit;
	}

}

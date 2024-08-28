package com.iii.pel.forms.PILQ020;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP_ACTION;
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP_DELEGATE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID2;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_PROP_NO1_LABEL;

	private HtmlInputText COMP_POL_PROP_NO1;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public PILQ020_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	public PT_IL_POLICY_ACTION() {

		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID1_LABEL() {
		return COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID1() {
		return COMP_POL_ASSRD_REF_ID1;
	}

	public void setCOMP_POL_ASSRD_REF_ID1_LABEL(
			HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL) {
		this.COMP_POL_ASSRD_REF_ID1_LABEL = COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID1(HtmlInputText COMP_POL_ASSRD_REF_ID1) {
		this.COMP_POL_ASSRD_REF_ID1 = COMP_POL_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID2_LABEL() {
		return COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID2() {
		return COMP_POL_ASSRD_REF_ID2;
	}

	public void setCOMP_POL_ASSRD_REF_ID2_LABEL(
			HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL) {
		this.COMP_POL_ASSRD_REF_ID2_LABEL = COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID2(HtmlInputText COMP_POL_ASSRD_REF_ID2) {
		this.COMP_POL_ASSRD_REF_ID2 = COMP_POL_ASSRD_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PROP_NO1_LABEL() {
		return COMP_POL_PROP_NO1_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROP_NO1() {
		return COMP_POL_PROP_NO1;
	}

	public void setCOMP_POL_PROP_NO1_LABEL(
			HtmlOutputLabel COMP_POL_PROP_NO1_LABEL) {
		this.COMP_POL_PROP_NO1_LABEL = COMP_POL_PROP_NO1_LABEL;
	}

	public void setCOMP_POL_PROP_NO1(HtmlInputText COMP_POL_PROP_NO1) {
		this.COMP_POL_PROP_NO1 = COMP_POL_PROP_NO1;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_POLICY_BEAN().getROWID() != null) {
			}
		}catch (Exception e) {
				
			}
				// TODO: handle exception
			}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeSelectStatement(compositeAction);
				compositeAction.getPT_IL_POLICY1_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_DEPOSIT1_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_PYMT_DTLS1_ACTION_BEAN().onLoad();
				compositeAction.getPT_IL_PYMT_DTLS2_ACTION_BEAN().onLoad();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public List<LovBean> lovPOL_ASSRD_REF_ID1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_ASSRD_REF_ID1",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}


	public List<LovBean> lovPOL_ASSRD_REF_ID2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_ASSRD_REF_ID2",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	
	public List<LovBean> lovPOL_NO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_NO",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPOL_PROP_NO1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_PROP_NO",
					"1",null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}


	public List<LovBean> lovPOL_PROP_NO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_PROP_NO",
					"1",null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_BUT_POL_NO_LOV(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_PROP_NO",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_BUT_NEW_IC_NO_LOV(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_ASSRD_REF_ID1",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_BUT_OLD_IC_NO_LOV(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_ASSRD_REF_ID2",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovM_BUT_PROP_NO_LOV(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ020",
					"PT_IL_POLICY", "POL_NO",
					null,null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

		
	
}
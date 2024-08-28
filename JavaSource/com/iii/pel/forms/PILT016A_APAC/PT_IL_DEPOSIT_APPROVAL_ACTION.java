package com.iii.pel.forms.PILT016A_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_DEPOSIT_APPROVAL_ACTION extends CommonAction {

	private HtmlSelectOneMenu PREM_GEN;
	private HtmlCommandButton okButton;
	private HtmlCommandButton cancelButton;
	private boolean ACGENDisabled;
	private List<SelectItem> genYNList = new ArrayList<SelectItem>();
	private PT_IL_DEPOSIT_APPROVAL PT_IL_DEPOSIT_APPROVAL_BEAN;
	
	PILT016A_APAC_COMPOSITE_ACTION compositeAction;
	public PT_IL_DEPOSIT_APPROVAL_ACTION()
	{
		PT_IL_DEPOSIT_APPROVAL_BEAN = new PT_IL_DEPOSIT_APPROVAL();
		List list2 = new ArrayList();
		try {
			list2 = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT016A_APAC", "PT_IL_DEPOSIT", "PT_IL_DEPOSIT.DEP_REPL_RCPT_YN", "YESNO");
		} catch (DBException e) {
			e.printStackTrace();
		}
		setGenYNList(list2);
	}
	
	public HtmlSelectOneMenu getPREM_GEN() {
		return PREM_GEN;
	}
	public void setPREM_GEN(HtmlSelectOneMenu prem_gen) {
		PREM_GEN = prem_gen;
	}
	public HtmlCommandButton getOkButton() {
		return okButton;
	}
	public void setOkButton(HtmlCommandButton okButton) {
		this.okButton = okButton;
	}
	public HtmlCommandButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(HtmlCommandButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public List<SelectItem> getGenYNList() {
		return genYNList;
	}

	public void setGenYNList(List<SelectItem> genYNList) {
		this.genYNList = genYNList;
	}

	public PT_IL_DEPOSIT_APPROVAL getPT_IL_DEPOSIT_APPROVAL_BEAN() {
		return PT_IL_DEPOSIT_APPROVAL_BEAN;
	}

	public void setPT_IL_DEPOSIT_APPROVAL_BEAN(
			PT_IL_DEPOSIT_APPROVAL pt_il_deposit_approval_bean) {
		PT_IL_DEPOSIT_APPROVAL_BEAN = pt_il_deposit_approval_bean;
	}
	
	
	public String cancelButtonAction()
	{
		return "mainAcreen";
	}

	public boolean isACGENDisabled() {
		return ACGENDisabled;
	}

	public void setACGENDisabled(boolean disabled) {
		ACGENDisabled = disabled;
	}
}

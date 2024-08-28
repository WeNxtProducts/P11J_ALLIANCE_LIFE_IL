package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_ORIGINAL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/*Added by saritha on 20-02-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/
public class PT_IL_POL_ORI_BROKER_ACTION extends CommonAction {

	private PT_IL_POL_BROKER_HEAD_ORIGINAL PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ORI_BROKER_HELPER helper;

	private UIData dataTable;
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	private List<PT_IL_POL_BROKER_HEAD_ORIGINAL> dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL = new ArrayList<PT_IL_POL_BROKER_HEAD_ORIGINAL>();

	public List<PT_IL_POL_BROKER_HEAD_ORIGINAL> getDataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL() {
		return dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL;
	}

	public void setDataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL(
			List<PT_IL_POL_BROKER_HEAD_ORIGINAL> dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL) {
		this.dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL = dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL;
	}
	
	public PT_IL_POL_BROKER_HEAD_ORIGINAL getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN() {
		return PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	}

	public void setPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN(
			PT_IL_POL_BROKER_HEAD_ORIGINAL pT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN) {
		PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = pT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ORI_BROKER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ORI_BROKER_HELPER helper) {
		this.helper = helper;
	}

	
	private HtmlCommandButton COMP_UI_M_ORI_BTN_MAIN;
	
	public HtmlCommandButton getCOMP_UI_M_ORI_BTN_MAIN() {
		return COMP_UI_M_ORI_BTN_MAIN;
	}

	public void setCOMP_UI_M_ORI_BTN_MAIN(HtmlCommandButton cOMP_UI_M_ORI_BTN_MAIN) {
		COMP_UI_M_ORI_BTN_MAIN = cOMP_UI_M_ORI_BTN_MAIN;
	}

	public PT_IL_POL_ORI_BROKER_ACTION() {

		PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = new PT_IL_POL_BROKER_HEAD_ORIGINAL();
		helper = new PT_IL_POL_ORI_BROKER_HELPER();
		
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = (PT_IL_POL_BROKER_HEAD_ORIGINAL) dataTable.getRowData();
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setRowSelected(true);
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_HEAD_ORIGINAL> PT_IL_POL_BROKER_HEAD_ORIGINAL = dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL.iterator();
		while (PT_IL_POL_BROKER_HEAD_ORIGINAL.hasNext()) {
			PT_IL_POL_BROKER_HEAD_ORIGINAL.next().setRowSelected(false);
		}
	}
	
	
	public void saveRecord() {
		String message ="";
		try {
			
			if (dataList_PT_IL_POL_ORI_BROKER_HEAD_ORIGINAL.size() == 0) {
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN=new PT_IL_POL_BROKER_HEAD_ORIGINAL();	
			}
			CommonUtils.getConnection().commit();
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String mainAction(){
		setBlockFlag(true);
		return "PILT002_APAC_PT_IL_POL_BROKER_HEAD";
	}
	

}

/*End*/

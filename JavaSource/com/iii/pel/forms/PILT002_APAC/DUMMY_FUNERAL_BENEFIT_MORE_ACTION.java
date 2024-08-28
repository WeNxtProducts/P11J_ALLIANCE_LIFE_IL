package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;

public class DUMMY_FUNERAL_BENEFIT_MORE_ACTION extends CommonAction{
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	private DUMMY_FUNERAL_BENEFIT_MORE_BEAN DUMMY_FUNERAL_BENEFIT_BEAN;
	private DUMMY_FUNERAL_BENEFIT_MORE_DELEGATE delegate;
	
	private List<DUMMY_FUNERAL_BENEFIT_MORE_BEAN> dataList_PT_IL_POL_FUNERAL_MORE_DTLS = new ArrayList<DUMMY_FUNERAL_BENEFIT_MORE_BEAN>();

	private UIData dataTable;
	
	private HtmlCommandButton COMP_POAC_BACK;
	
	
	public HtmlCommandButton getCOMP_POAC_BACK() {
		return COMP_POAC_BACK;
	}



	public void setCOMP_POAC_BACK(HtmlCommandButton cOMP_POAC_BACK) {
		COMP_POAC_BACK = cOMP_POAC_BACK;
	}



	public List<DUMMY_FUNERAL_BENEFIT_MORE_BEAN> getDataList_PT_IL_POL_FUNERAL_MORE_DTLS() {
		return dataList_PT_IL_POL_FUNERAL_MORE_DTLS;
	}



	public void setDataList_PT_IL_POL_FUNERAL_MORE_DTLS(
			List<DUMMY_FUNERAL_BENEFIT_MORE_BEAN> dataList_PT_IL_POL_FUNERAL_MORE_DTLS) {
		this.dataList_PT_IL_POL_FUNERAL_MORE_DTLS = dataList_PT_IL_POL_FUNERAL_MORE_DTLS;
	}



	public UIData getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public DUMMY_FUNERAL_BENEFIT_MORE_BEAN getDUMMY_FUNERAL_BENEFIT_BEAN() {
		return DUMMY_FUNERAL_BENEFIT_BEAN;
	}



	public void setDUMMY_FUNERAL_BENEFIT_BEAN(
			DUMMY_FUNERAL_BENEFIT_MORE_BEAN dUMMY_FUNERAL_BENEFIT_BEAN) {
		DUMMY_FUNERAL_BENEFIT_BEAN = dUMMY_FUNERAL_BENEFIT_BEAN;
	}



	public DUMMY_FUNERAL_BENEFIT_MORE_ACTION()
	{
		DUMMY_FUNERAL_BENEFIT_BEAN=new DUMMY_FUNERAL_BENEFIT_MORE_BEAN();
		delegate=new DUMMY_FUNERAL_BENEFIT_MORE_DELEGATE();
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				delegate.executeQuery(compositeAction);
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String back(){
		String outcome = null;
		this.setBlockFlag(true);
		compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}
}

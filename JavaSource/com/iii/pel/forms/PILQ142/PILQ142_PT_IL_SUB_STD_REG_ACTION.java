package com.iii.pel.forms.PILQ142;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;

public class PILQ142_PT_IL_SUB_STD_REG_ACTION extends CommonAction{

	private PT_IL_SUB_STD_REG PT_IL_SUB_STD_REG_BEAN;
	
	public PILQ142_COMPOSITE_ACTION compositeAction;
	
	private PT_IL_SUB_STD_REG_HELPER PT_IL_SUB_STD_REG_HELPER_BEAN;
	
	private UIData dataTable;
	
	List<PT_IL_SUB_STD_REG> dataListPT_IL_SUB_STD_REG = new ArrayList<PT_IL_SUB_STD_REG>();
	
	public PILQ142_PT_IL_SUB_STD_REG_ACTION() {
		// TODO Auto-generated constructor stub
		PT_IL_SUB_STD_REG_BEAN = new PT_IL_SUB_STD_REG();
		PT_IL_SUB_STD_REG_HELPER_BEAN = new PT_IL_SUB_STD_REG_HELPER();
	}
	
	public PT_IL_SUB_STD_REG getPT_IL_SUB_STD_REG_BEAN() {
		return PT_IL_SUB_STD_REG_BEAN;
	}

	public void setPT_IL_SUB_STD_REG_BEAN(PT_IL_SUB_STD_REG pT_IL_SUB_STD_REG_BEAN) {
		PT_IL_SUB_STD_REG_BEAN = pT_IL_SUB_STD_REG_BEAN;
	}

	public List<PT_IL_SUB_STD_REG> getDataListPT_IL_SUB_STD_REG() {
		return dataListPT_IL_SUB_STD_REG;
	}

	public void setDataListPT_IL_SUB_STD_REG(
			List<PT_IL_SUB_STD_REG> dataListPT_IL_SUB_STD_REG) {
		this.dataListPT_IL_SUB_STD_REG = dataListPT_IL_SUB_STD_REG;
	}
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void onLoad(PhaseEvent event){
		try {
			if (isBlockFlag()) {
				PT_IL_SUB_STD_REG_HELPER_BEAN.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}

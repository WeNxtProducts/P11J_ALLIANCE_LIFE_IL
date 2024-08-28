package com.iii.pel.forms.PILP_STP;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;

public class VIEW_PROCESSED_ACTION extends CommonAction {
	private UIData dataTable;
	private List<VIEW_PROCESSED> dataList_VIEW_PROCESSED = new ArrayList<VIEW_PROCESSED>();
	VIEW_PROCESSED_HELPER helper;
	PILP_STP_COMPOSITE_ACTION compositeAction;

	public VIEW_PROCESSED_ACTION() {
		helper = new VIEW_PROCESSED_HELPER();
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<VIEW_PROCESSED> getDataList_VIEW_PROCESSED() {
		return dataList_VIEW_PROCESSED;
	}

	public void setDataList_VIEW_PROCESSED(List<VIEW_PROCESSED> dataList_VIEW_PROCESSED) {
		this.dataList_VIEW_PROCESSED = dataList_VIEW_PROCESSED;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeSelectStatement(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String backButAction(){
		return "PILP_STP";
	}
}

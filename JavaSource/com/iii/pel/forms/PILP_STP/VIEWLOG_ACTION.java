package com.iii.pel.forms.PILP_STP;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;

public class VIEWLOG_ACTION extends CommonAction {
	private UIData dataTable;
	private List<VIEWLOG> dataList_VIEWLOG = new ArrayList<VIEWLOG>();
	VIEWLOG_HELPER helper;
	PILP_STP_COMPOSITE_ACTION compositeAction;

	public VIEWLOG_ACTION() {
		helper = new VIEWLOG_HELPER();
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<VIEWLOG> getDataList_VIEWLOG() {
		return dataList_VIEWLOG;
	}

	public void setDataList_VIEWLOG(List<VIEWLOG> dataList_VIEWLOG) {
		this.dataList_VIEWLOG = dataList_VIEWLOG;
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

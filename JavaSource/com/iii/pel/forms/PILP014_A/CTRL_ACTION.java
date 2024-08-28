package com.iii.pel.forms.PILP014_A;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class CTRL_ACTION {

	private HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL;
	

	private HtmlInputText COMP_UI_M_USER_DISP;

	private CTRL CTRL_BEAN;
	
	private UIData dataTable;
	
	private ArrayList<CTRL> dataList = new ArrayList<CTRL>();
	
	
	public String back(){
		return "PILP014_A";
	}


	public void onLoad(PhaseEvent event){
		try {
			fetch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void fetch() throws Exception{
		String query = "SELECT * FROM PT_IL_BATCH_PROC_ERROR ";
		ResultSet resultSet = null;
		CRUDHandler handler = new  CRUDHandler();
		dataList.clear();
		try{
		resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
		while (resultSet.next()) {
			CTRL ctrl = new CTRL();
			ctrl.setEM_ERR_NO(resultSet.getInt("BPE_ERR_CODE"));
			ctrl.setEM_ENG_MSG(resultSet.getString("BPE_ERR_DESC"));
			ctrl.setEM_POL_NO(resultSet.getString("BPE_POL_NO"));
			/*ctrl.setEM_FOR_MSG(resultSet.getString("EM_FOR_MSG"));
			ctrl.setEM_ENG_ACTION(resultSet.getString("EM_ENG_ACTION"));
			ctrl.setEM_FOR_ACTION(resultSet.getString("EM_FOR_ACTION"));
			ctrl.setEM_ERR_SEVERITY(resultSet.getString("EM_ERR_SEVERITY"));*/
			dataList.add(ctrl);
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public CTRL_ACTION() {
		CTRL_BEAN = new CTRL();
		
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DISP_LABEL() {
		return COMP_UI_M_USER_DISP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_USER_DISP() {
		return COMP_UI_M_USER_DISP;
	}

	public void setCOMP_UI_M_USER_DISP_LABEL(HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL) {
		this.COMP_UI_M_USER_DISP_LABEL = COMP_UI_M_USER_DISP_LABEL;
	}

	public void setCOMP_UI_M_USER_DISP(HtmlInputText COMP_UI_M_USER_DISP) {
		this.COMP_UI_M_USER_DISP = COMP_UI_M_USER_DISP;
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}



	public UIData getDataTable() {
		return  dataTable;
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable =  dataTable;
	}



	public ArrayList<CTRL> getDataList() {
		return dataList;
	}



	public void setDataList(ArrayList<CTRL> dataList) {
		this.dataList = dataList;
	}
}

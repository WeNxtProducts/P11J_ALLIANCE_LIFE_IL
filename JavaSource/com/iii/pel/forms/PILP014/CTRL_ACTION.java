package com.iii.pel.forms.PILP014;

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
	
	private int currentPage;
	
	private int recordsPerPage = 10;

	private int prevRowInd;

	private int lastUpdateRowIndex;
	
	
	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getRecordsPerPage() {
		return recordsPerPage;
	}


	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}


	public int getPrevRowInd() {
		return prevRowInd;
	}


	public void setPrevRowInd(int prevRowInd) {
		this.prevRowInd = prevRowInd;
	}


	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}


	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}


	public String back(){
		return "PILP014_CTRL1";
	}


	public void onLoad(PhaseEvent event){
		try {
			fetch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void fetch() throws Exception{
		String query = "SELECT BE_POL_NO,BE_ERR_CODE,BE_ERR_DESC FROM PP_BATCH_STATUS WHERE BE_BD_SYS_ID = ? ";
		ResultSet resultSet = null;
		CRUDHandler handler = new  CRUDHandler();
		dataList.clear();
		try{
		resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{(Integer)CommonUtils.getGlobalObject("BD_SYS_ID")});
		while (resultSet.next()) {
			CTRL ctrl = new CTRL();
			ctrl.setBE_POL_NO(resultSet.getString(1));
			ctrl.setBE_ERR_CODE(resultSet.getString(2));
			ctrl.setBE_ERR_DESC(resultSet.getString(3));
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

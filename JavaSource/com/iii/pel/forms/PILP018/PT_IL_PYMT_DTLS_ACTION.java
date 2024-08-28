package com.iii.pel.forms.PILP018;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_ACTION  extends CommonAction{

	public PILP018_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_TXN_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

	private HtmlInputText COMP_PD_FC_AMT;

	private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;

	private HtmlInputText COMP_PD_LC_AMT;

	private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

	private HtmlInputText COMP_PD_BRANCH_NAME;

	private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlOutputLabel COMP_PD_ADDR_01_LABEL;

	private HtmlInputText COMP_PD_ADDR_01;

	private HtmlOutputLabel COMP_PD_ADDR_02_LABEL;

	private HtmlInputText COMP_PD_ADDR_02;

	private HtmlOutputLabel COMP_PD_ADDR_03_LABEL;

	private HtmlInputText COMP_PD_ADDR_03;

	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;
	
	List<PT_IL_PYMT_DTLS> BeanList = new ArrayList<PT_IL_PYMT_DTLS>(); 
	
	private UIDataTable datatable;
	
	Connection con = null;
	
	CRUDHandler handler = new CRUDHandler();

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public PT_IL_PYMT_DTLS_ACTION() {
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_TXN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_TXN_TYPE_DESC() {
		return COMP_UI_M_PD_TXN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PD_TXN_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_TXN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_PD_TXN_TYPE_DESC_LABEL = COMP_UI_M_PD_TXN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_TXN_TYPE_DESC(HtmlInputText COMP_UI_M_PD_TXN_TYPE_DESC) {
		this.COMP_UI_M_PD_TXN_TYPE_DESC = COMP_UI_M_PD_TXN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
		return COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC(HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC) {
		this.COMP_UI_M_PD_CURR_CODE_DESC = COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
		return COMP_PD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_AMT() {
		return COMP_PD_FC_AMT;
	}

	public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
		this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
	}

	public void setCOMP_PD_FC_AMT(HtmlInputText COMP_PD_FC_AMT) {
		this.COMP_PD_FC_AMT = COMP_PD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
		return COMP_PD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_AMT() {
		return COMP_PD_LC_AMT;
	}

	public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
		this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
	}

	public void setCOMP_PD_LC_AMT(HtmlInputText COMP_PD_LC_AMT) {
		this.COMP_PD_LC_AMT = COMP_PD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
		return COMP_PD_BRANCH_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BRANCH_NAME() {
		return COMP_PD_BRANCH_NAME;
	}

	public void setCOMP_PD_BRANCH_NAME_LABEL(HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
		this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
	}

	public void setCOMP_PD_BRANCH_NAME(HtmlInputText COMP_PD_BRANCH_NAME) {
		this.COMP_PD_BRANCH_NAME = COMP_PD_BRANCH_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
		return COMP_PD_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_CUST_NAME() {
		return COMP_PD_CUST_NAME;
	}

	public void setCOMP_PD_CUST_NAME_LABEL(HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
		this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
	}

	public void setCOMP_PD_CUST_NAME(HtmlInputText COMP_PD_CUST_NAME) {
		this.COMP_PD_CUST_NAME = COMP_PD_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
		return COMP_PD_ADDR_01_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_01() {
		return COMP_PD_ADDR_01;
	}

	public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
		this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
	}

	public void setCOMP_PD_ADDR_01(HtmlInputText COMP_PD_ADDR_01) {
		this.COMP_PD_ADDR_01 = COMP_PD_ADDR_01;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
		return COMP_PD_ADDR_02_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_02() {
		return COMP_PD_ADDR_02;
	}

	public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
		this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
	}

	public void setCOMP_PD_ADDR_02(HtmlInputText COMP_PD_ADDR_02) {
		this.COMP_PD_ADDR_02 = COMP_PD_ADDR_02;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
		return COMP_PD_ADDR_03_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_03() {
		return COMP_PD_ADDR_03;
	}

	public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
		this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
	}

	public void setCOMP_PD_ADDR_03(HtmlInputText COMP_PD_ADDR_03) {
		this.COMP_PD_ADDR_03 = COMP_PD_ADDR_03;
	}

	public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
		return PT_IL_PYMT_DTLS_BEAN;
	}

	public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
	}

	public List<PT_IL_PYMT_DTLS> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_PYMT_DTLS> beanList) {
		BeanList = beanList;
	}
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		return "";
	}
	
	public void AddRow(ActionEvent event){
		BeanList.add(new PT_IL_PYMT_DTLS());	
	}
	

	public void DeleteRow(ActionEvent event) throws DBException, SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{

		PT_IL_PYMT_DTLS valuebean = null;
		int DeletedRecordIndex = 0;
		con = CommonUtils.getConnection();
		if(BeanList != null){
			for(int index =0 ;index<BeanList.size();){
				valuebean = BeanList.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					BeanList.remove(valuebean);
					int n = handler.executeDelete(valuebean, con);
					System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.deleteRow()-n"+n);
					con.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}



	}

}

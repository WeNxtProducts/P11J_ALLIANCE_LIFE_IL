package com.iii.pel.forms.PILP018;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_ACTION extends CommonAction{

	public PILP018_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS_BACK;

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;
	
	private String filterByPC_FC_GROSS_PREM;
	
	private String filterByPC_LC_GROSS_PREM;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private UIDataTable datatable;
	
	CRUDHandler handler = new CRUDHandler();
	
	Connection con = null;	
	
	List<PT_IL_PREM_COLL> BeanList = new ArrayList<PT_IL_PREM_COLL>();

	public PT_IL_PREM_COLL_ACTION(){
		//PT_IL_PREM_COLL_WHEN_NEW_BLOCK_INSTANCE();
		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_PAID_AMT_LABEL() {
		return COMP_PC_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_PAID_AMT() {
		return COMP_PC_FC_PAID_AMT;
	}

	public void setCOMP_PC_FC_PAID_AMT_LABEL(HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL) {
		this.COMP_PC_FC_PAID_AMT_LABEL = COMP_PC_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_FC_PAID_AMT(HtmlInputText COMP_PC_FC_PAID_AMT) {
		this.COMP_PC_FC_PAID_AMT = COMP_PC_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMT_LABEL() {
		return COMP_PC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMT() {
		return COMP_PC_LC_PAID_AMT;
	}

	public void setCOMP_PC_LC_PAID_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL) {
		this.COMP_PC_LC_PAID_AMT_LABEL = COMP_PC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMT(HtmlInputText COMP_PC_LC_PAID_AMT) {
		this.COMP_PC_LC_PAID_AMT = COMP_PC_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_AVLB_BAL_AMT() {
		return COMP_PC_FC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT_LABEL(HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_FC_AVLB_BAL_AMT_LABEL = COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT(HtmlInputText COMP_PC_FC_AVLB_BAL_AMT) {
		this.COMP_PC_FC_AVLB_BAL_AMT = COMP_PC_FC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_DTLS_BACK() {
		return COMP_UI_M_BUT_PREM_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS_BACK) {
		this.COMP_UI_M_BUT_PREM_DTLS_BACK = COMP_UI_M_BUT_PREM_DTLS_BACK;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}
	 public String gotoParentBlock(){
	    	System.out.println("PT_IL_DEPOSIT_ACTION.gotoParentBlock()");
	     return "PILP018_goto_Parent";
	    }

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public List<PT_IL_PREM_COLL> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_PREM_COLL> beanList) {
		BeanList = beanList;
	}
	
	/*public void AddRow(ActionEvent event){
		System.out.println("PT_IL_PREM_COLL_ACTION.AddRow()");
		BeanList.add(new PT_IL_PREM_COLL());
	}*/
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		return "";
	}
	
	public void DeleteRow(ActionEvent event) throws DBException, SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{

		System.out.println("PT_IL_PREM_COLL_ACTION.DeleteRow()");
		PT_IL_PREM_COLL valuebean = null;
		int DeletedRecordIndex = 0;
		con = CommonUtils.getConnection();
		System.out.println("************************");
		System.out.println(BeanList.size()); 
		System.out.println("************************");
		if(BeanList != null){
			for(int index =0 ;index<BeanList.size();){
				valuebean = BeanList.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					BeanList.remove(valuebean);
					int n = handler.executeDelete(valuebean, con);
					System.out.println("PT_IL_PREM_COLL.deleteRow()-n"+n);
					con.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}
		}
	}
	
	public void populateValues() throws DBException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		con = CommonUtils.getConnection();
		String selectQuery = "SELECT ROWID,PT_IL_PREM_COLL.* FROM PT_IL_PREM_COLL ";
		if(PT_IL_PREM_COLL_BEAN.getM_WHERE()!=null ){
		    selectQuery = selectQuery =" WHERE "+ PT_IL_PREM_COLL_BEAN.getM_WHERE();
		}
		BeanList = handler.fetch(selectQuery, "com.iii.pel.forms.PILP018.PT_IL_PREM_COLL",con);
		
  		Iterator<PT_IL_PREM_COLL> it = BeanList.iterator();
  		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN=null;
  		while(it.hasNext()){
  		    PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
  			PT_IL_PREM_COLL_BEAN = it.next();
  			PT_IL_PREM_COLL_BEAN.setRowSelected(false);
  		}
  		if (BeanList.size()>0){					
  			this.setPT_IL_PREM_COLL_BEAN(BeanList.get(0));
  			this.getPT_IL_PREM_COLL_BEAN().setRowSelected(true);
  		}
	}
	public void onLoad(PhaseEvent pe) {
	    PILP018_HELPER helper = new PILP018_HELPER();
	    try {
		  if (isBlockFlag()) {
		      helper.PT_IL_PREM_COLL_WHEN_NEW_BLOCK_INSTANCE(PT_IL_PREM_COLL_BEAN,
			      compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()) ;
		      populateValues();
		      setBlockFlag(false); 
		  }
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	}
	public void getDetails() {
		try {
			if (BeanList.size() != 0) {				
				PT_IL_PREM_COLL_BEAN = (PT_IL_PREM_COLL)datatable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_PREM_COLL_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	  }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL> iterator = BeanList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent()
	{
		COMP_PC_SCHD_PYMT_DT.resetValue();
		COMP_PC_FC_GROSS_PREM.resetValue();
		COMP_PC_LC_GROSS_PREM.resetValue();
		COMP_PC_PAID_DT.resetValue();
		COMP_PC_FC_PAID_AMT.resetValue();
		COMP_PC_LC_PAID_AMT.resetValue();
		COMP_PC_FC_AVLB_BAL_AMT.resetValue();
		COMP_PC_LC_AVLB_BAL_AMT.resetValue();
	}
	
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PREM_COLL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PREM_COLL_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					BeanList.remove(PT_IL_PREM_COLL_BEAN);
				}
				if (BeanList.size() > 0) {
					setPT_IL_PREM_COLL_BEAN(BeanList.get(0));
					this
							.setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL_BEAN);
					PT_IL_PREM_COLL_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
	public void post(ActionEvent ae) {

		int rowUpdated = 0;
		
		try {
			if (PT_IL_PREM_COLL_BEAN.getROWID() != null) {

				if (isUPDATE_ALLOWED()) {

					///this.PRE_UPDATE(PM_IL_PLAN_AGE_SETUP_BEAN);
					new CRUDHandler().executeInsert(PT_IL_PREM_COLL_BEAN,
							new CommonUtils().getConnection());
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {

					new CRUDHandler().executeInsert(PT_IL_PREM_COLL_BEAN,
							new CommonUtils().getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					BeanList.add(0, PT_IL_PREM_COLL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_PREM_COLL_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	/**
	 * @return the filterByPC_FC_GROSS_PREM
	 */
	public String getFilterByPC_FC_GROSS_PREM() {
		return filterByPC_FC_GROSS_PREM;
	}

	/**
	 * @param filterByPC_FC_GROSS_PREM the filterByPC_FC_GROSS_PREM to set
	 */
	public void setFilterByPC_FC_GROSS_PREM(String filterByPC_FC_GROSS_PREM) {
		this.filterByPC_FC_GROSS_PREM = filterByPC_FC_GROSS_PREM;
	}

	/**
	 * @return the filterByPC_LC_GROSS_PREM
	 */
	public String getFilterByPC_LC_GROSS_PREM() {
		return filterByPC_LC_GROSS_PREM;
	}

	/**
	 * @param filterByPC_LC_GROSS_PREM the filterByPC_LC_GROSS_PREM to set
	 */
	public void setFilterByPC_LC_GROSS_PREM(String filterByPC_LC_GROSS_PREM) {
		this.filterByPC_LC_GROSS_PREM = filterByPC_LC_GROSS_PREM;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

}

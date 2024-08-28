package com.iii.pel.forms.PILP018;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
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

public class PT_IL_LOAN_REPAYMENT_ACTION extends CommonAction{

	public PILP018_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_UI_M_LOAN_NO_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_NO;

	private HtmlOutputLabel COMP_UI_M_LOAN_DT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_DT;

	private HtmlOutputLabel COMP_LR_PYMT_DT_LABEL;

	private HtmlCalendar COMP_LR_PYMT_DT;

	private HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_INT_AMT;

	private HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_INT_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;

	private PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private String filterByLR_FC_PYMT_AMT;
	
	private String filterByLR_LC_PYMT_AMT;
	
	private String filterByLR_LC_LOAN_AMT;
	
	private String filterByLR_FC_LOAN_AMT;
	
	private UIDataTable datatable;
	
	CRUDHandler handler = new CRUDHandler();
	
	Connection con = null;	
	
	Map SessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	private List<PT_IL_LOAN_REPAYMENT> BeanList = new ArrayList<PT_IL_LOAN_REPAYMENT>();

	public PT_IL_LOAN_REPAYMENT_ACTION(){
		PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
		//PT_IL_LOAN_REPAYMENT_WHEN_NEW_RECORD_INSTANCE();
		//PT_IL_LOAN_REPAYMENT_POST_QUERY();
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_NO_LABEL() {
		return COMP_UI_M_LOAN_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_NO() {
		return COMP_UI_M_LOAN_NO;
	}

	public void setCOMP_UI_M_LOAN_NO_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_NO_LABEL) {
		this.COMP_UI_M_LOAN_NO_LABEL = COMP_UI_M_LOAN_NO_LABEL;
	}

	public void setCOMP_UI_M_LOAN_NO(HtmlInputText COMP_UI_M_LOAN_NO) {
		this.COMP_UI_M_LOAN_NO = COMP_UI_M_LOAN_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_DT_LABEL() {
		return COMP_UI_M_LOAN_DT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_DT() {
		return COMP_UI_M_LOAN_DT;
	}

	public void setCOMP_UI_M_LOAN_DT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_DT_LABEL) {
		this.COMP_UI_M_LOAN_DT_LABEL = COMP_UI_M_LOAN_DT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_DT(HtmlInputText COMP_UI_M_LOAN_DT) {
		this.COMP_UI_M_LOAN_DT = COMP_UI_M_LOAN_DT;
	}

	public HtmlOutputLabel getCOMP_LR_PYMT_DT_LABEL() {
		return COMP_LR_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LR_PYMT_DT() {
		return COMP_LR_PYMT_DT;
	}

	public void setCOMP_LR_PYMT_DT_LABEL(HtmlOutputLabel COMP_LR_PYMT_DT_LABEL) {
		this.COMP_LR_PYMT_DT_LABEL = COMP_LR_PYMT_DT_LABEL;
	}

	public void setCOMP_LR_PYMT_DT(HtmlCalendar COMP_LR_PYMT_DT) {
		this.COMP_LR_PYMT_DT = COMP_LR_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_PYMT_AMT_LABEL() {
		return COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_PYMT_AMT() {
		return COMP_LR_FC_PYMT_AMT;
	}

	public void setCOMP_LR_FC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL) {
		this.COMP_LR_FC_PYMT_AMT_LABEL = COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_PYMT_AMT(HtmlInputText COMP_LR_FC_PYMT_AMT) {
		this.COMP_LR_FC_PYMT_AMT = COMP_LR_FC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_PYMT_AMT_LABEL() {
		return COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_PYMT_AMT() {
		return COMP_LR_LC_PYMT_AMT;
	}

	public void setCOMP_LR_LC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL) {
		this.COMP_LR_LC_PYMT_AMT_LABEL = COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_PYMT_AMT(HtmlInputText COMP_LR_LC_PYMT_AMT) {
		this.COMP_LR_LC_PYMT_AMT = COMP_LR_LC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_LOAN_AMT_LABEL() {
		return COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_LOAN_AMT() {
		return COMP_LR_LC_LOAN_AMT;
	}

	public void setCOMP_LR_LC_LOAN_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL) {
		this.COMP_LR_LC_LOAN_AMT_LABEL = COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_LC_LOAN_AMT(HtmlInputText COMP_LR_LC_LOAN_AMT) {
		this.COMP_LR_LC_LOAN_AMT = COMP_LR_LC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_LOAN_AMT_LABEL() {
		return COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_LOAN_AMT() {
		return COMP_LR_FC_LOAN_AMT;
	}

	public void setCOMP_LR_FC_LOAN_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL) {
		this.COMP_LR_FC_LOAN_AMT_LABEL = COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_FC_LOAN_AMT(HtmlInputText COMP_LR_FC_LOAN_AMT) {
		this.COMP_LR_FC_LOAN_AMT = COMP_LR_FC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_INT_AMT_LABEL() {
		return COMP_LR_FC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_INT_AMT() {
		return COMP_LR_FC_INT_AMT;
	}

	public void setCOMP_LR_FC_INT_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL) {
		this.COMP_LR_FC_INT_AMT_LABEL = COMP_LR_FC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_INT_AMT(HtmlInputText COMP_LR_FC_INT_AMT) {
		this.COMP_LR_FC_INT_AMT = COMP_LR_FC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_INT_AMT_LABEL() {
		return COMP_LR_LC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_INT_AMT() {
		return COMP_LR_LC_INT_AMT;
	}

	public void setCOMP_LR_LC_INT_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL) {
		this.COMP_LR_LC_INT_AMT_LABEL = COMP_LR_LC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_INT_AMT(HtmlInputText COMP_LR_LC_INT_AMT) {
		this.COMP_LR_LC_INT_AMT = COMP_LR_LC_INT_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK() {
		return COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK) {
		this.COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK = COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;
	}

	public PT_IL_LOAN_REPAYMENT getPT_IL_LOAN_REPAYMENT_BEAN() {
		return PT_IL_LOAN_REPAYMENT_BEAN;
	}

	public void setPT_IL_LOAN_REPAYMENT_BEAN(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) {
		this.PT_IL_LOAN_REPAYMENT_BEAN = PT_IL_LOAN_REPAYMENT_BEAN;
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public List<PT_IL_LOAN_REPAYMENT> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_LOAN_REPAYMENT> beanList) {
		BeanList = beanList;
	}
	
	/*public void AddRow(ActionEvent event){
		System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.AddRow()-Inside");
		BeanList.add(new PT_IL_LOAN_REPAYMENT());
	}*/

    public String gotoParentBlock(){
    	System.out.println("PT_IL_DEPOSIT_ACTION.gotoParentBlock()");
     return "PILP018_goto_Parent";
    }
	
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		return "";
	}
	
	public void DeleteRow(ActionEvent event) throws DBException, SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{

		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.DeleteRow()");
		PT_IL_LOAN_REPAYMENT valuebean = null;
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
					System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.deleteRow()-n"+n);
					con.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}
	
	public void PT_IL_LOAN_REPAYMENT_WHEN_NEW_RECORD_INSTANCE() throws DBException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		//SET_BLOCK_PROPERTY('PT_IL_LOAN_REPAYMENT',DEFAULT_WHERE,' LR_SYS_ID = '|| :PT_IL_CHEQUE_BOUNCE_HDR.CBH_LR_SYS_ID ) ;
		//EXECUTE_QUERY; 
		//SET_BLOCK_PROPERTY('PT_IL_LOAN_REPAYMENT',DEFAULT_WHERE,'') ;
		populateValues();
  }
	
	public void populateValues() throws DBException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		System.out.println("PT_IL_LOAN_REPAYMENT_ACTION.populateValues()-Inside");
		con = CommonUtils.getConnection();
		String selectQuery = "SELECT ROWID, PT_IL_LOAN_REPAYMENT.* FROM PT_IL_LOAN_REPAYMENT ";
		if(PT_IL_LOAN_REPAYMENT_BEAN.getM_WHERE()!=null)
		{
		    selectQuery = selectQuery + " WHERE "+ PT_IL_LOAN_REPAYMENT_BEAN.getM_WHERE();
		}
		BeanList = handler.fetch(selectQuery, "com.iii.pel.forms.PILP018.PT_IL_LOAN_REPAYMENT",con);
 		Iterator<PT_IL_LOAN_REPAYMENT> it = BeanList.iterator();
 		while(it.hasNext()){
 		   PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
 			PT_IL_LOAN_REPAYMENT_BEAN = it.next();
 			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(false);
 		}
 		if (BeanList.size()>0){					
 			this.setPT_IL_LOAN_REPAYMENT_BEAN(BeanList.get(0));
 			this.getPT_IL_LOAN_REPAYMENT_BEAN().setRowSelected(true);
 		}
 	 
	}
	
	public void onLoad(PhaseEvent pe) {
	    PILP018_HELPER helper = new PILP018_HELPER();
	    try {
		  if (isBlockFlag()) {
		      helper.PT_IL_LOAN_REPAYMENT_WHEN_NEW_BLOCK_INSTANCE(compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN(),
			      PT_IL_LOAN_REPAYMENT_BEAN) ;
		      populateValues();
		      helper.PT_IL_LOAN_REPAYMENT_POST_QUERY(PT_IL_LOAN_REPAYMENT_BEAN);
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
				PT_IL_LOAN_REPAYMENT_BEAN = (PT_IL_LOAN_REPAYMENT)datatable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	  }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_LOAN_REPAYMENT> iterator = BeanList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent()
	{
		COMP_UI_M_LOAN_NO.resetValue();
		COMP_UI_M_LOAN_DT.resetValue();
		COMP_LR_PYMT_DT.resetValue();
		COMP_LR_FC_PYMT_AMT.resetValue();
		COMP_LR_LC_PYMT_AMT.resetValue();
		COMP_LR_LC_LOAN_AMT.resetValue();
		COMP_LR_FC_LOAN_AMT.resetValue();
		COMP_LR_FC_INT_AMT.resetValue();
		COMP_LR_LC_INT_AMT.resetValue();
	}
	
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
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
				if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_LOAN_REPAYMENT_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					BeanList.remove(PT_IL_LOAN_REPAYMENT_BEAN);
				}
				if (BeanList.size() > 0) {
					setPT_IL_LOAN_REPAYMENT_BEAN(BeanList.get(0));
					this
							.setPT_IL_LOAN_REPAYMENT_BEAN(PT_IL_LOAN_REPAYMENT_BEAN);
					PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
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
			if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null) {

				if (isUPDATE_ALLOWED()) {

					///this.PRE_UPDATE(PM_IL_PLAN_AGE_SETUP_BEAN);
					new CRUDHandler().executeInsert(PT_IL_LOAN_REPAYMENT_BEAN,
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

					new CRUDHandler().executeInsert(PT_IL_LOAN_REPAYMENT_BEAN,
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
					BeanList.add(0, PT_IL_LOAN_REPAYMENT_BEAN);
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
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
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

	/**
	 * @return the filterByLR_FC_PYMT_AMT
	 */
	public String getFilterByLR_FC_PYMT_AMT() {
		return filterByLR_FC_PYMT_AMT;
	}

	/**
	 * @param filterByLR_FC_PYMT_AMT the filterByLR_FC_PYMT_AMT to set
	 */
	public void setFilterByLR_FC_PYMT_AMT(String filterByLR_FC_PYMT_AMT) {
		this.filterByLR_FC_PYMT_AMT = filterByLR_FC_PYMT_AMT;
	}

	/**
	 * @return the filterByLR_LC_PYMT_AMT
	 */
	public String getFilterByLR_LC_PYMT_AMT() {
		return filterByLR_LC_PYMT_AMT;
	}

	/**
	 * @param filterByLR_LC_PYMT_AMT the filterByLR_LC_PYMT_AMT to set
	 */
	public void setFilterByLR_LC_PYMT_AMT(String filterByLR_LC_PYMT_AMT) {
		this.filterByLR_LC_PYMT_AMT = filterByLR_LC_PYMT_AMT;
	}

	/**
	 * @return the filterByLR_LC_LOAN_AMT
	 */
	public String getFilterByLR_LC_LOAN_AMT() {
		return filterByLR_LC_LOAN_AMT;
	}

	/**
	 * @param filterByLR_LC_LOAN_AMT the filterByLR_LC_LOAN_AMT to set
	 */
	public void setFilterByLR_LC_LOAN_AMT(String filterByLR_LC_LOAN_AMT) {
		this.filterByLR_LC_LOAN_AMT = filterByLR_LC_LOAN_AMT;
	}

	/**
	 * @return the filterByLR_FC_LOAN_AMT
	 */
	public String getFilterByLR_FC_LOAN_AMT() {
		return filterByLR_FC_LOAN_AMT;
	}

	/**
	 * @param filterByLR_FC_LOAN_AMT the filterByLR_FC_LOAN_AMT to set
	 */
	public void setFilterByLR_FC_LOAN_AMT(String filterByLR_FC_LOAN_AMT) {
		this.filterByLR_FC_LOAN_AMT = filterByLR_FC_LOAN_AMT;
	}
 }

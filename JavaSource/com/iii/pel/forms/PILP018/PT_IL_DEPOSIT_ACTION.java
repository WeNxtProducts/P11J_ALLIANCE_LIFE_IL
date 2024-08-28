package com.iii.pel.forms.PILP018;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DEPOSIT_ACTION  extends CommonAction {

	public PILP018_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_UI_M_DPD_REF_ID_LABEL;

	private HtmlInputText COMP_UI_M_DPD_REF_ID;

	private HtmlOutputLabel COMP_UI_M_DEP_FC_DEP_AMT_LABEL;

	private HtmlInputText COMP_UI_M_DEP_FC_DEP_AMT;

	private HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_DEP_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;

	private PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN;
	
	private UIDataTable datatable;
	
	private String filterByUI_M_DEP_FC_DEP_AMT;
	
	private String filterByDEP_LC_DEP_AMT;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	CRUDHandler handler = new CRUDHandler();
	 
	List<PT_IL_DEPOSIT> BeanList = new ArrayList<PT_IL_DEPOSIT>();

	public List<PT_IL_DEPOSIT> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_DEPOSIT> beanList) {
		BeanList = beanList;
	}

	public PT_IL_DEPOSIT_ACTION() {
		PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
	}

	public HtmlOutputLabel getCOMP_UI_M_DPD_REF_ID_LABEL() {
		return COMP_UI_M_DPD_REF_ID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DPD_REF_ID() {
		return COMP_UI_M_DPD_REF_ID;
	}

	public void setCOMP_UI_M_DPD_REF_ID_LABEL(HtmlOutputLabel COMP_UI_M_DPD_REF_ID_LABEL) {
		this.COMP_UI_M_DPD_REF_ID_LABEL = COMP_UI_M_DPD_REF_ID_LABEL;
	}

	public void setCOMP_UI_M_DPD_REF_ID(HtmlInputText COMP_UI_M_DPD_REF_ID) {
		this.COMP_UI_M_DPD_REF_ID = COMP_UI_M_DPD_REF_ID;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FC_DEP_AMT_LABEL() {
		return COMP_UI_M_DEP_FC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_FC_DEP_AMT() {
		return COMP_UI_M_DEP_FC_DEP_AMT;
	}

	public void setCOMP_UI_M_DEP_FC_DEP_AMT_LABEL(HtmlOutputLabel COMP_UI_M_DEP_FC_DEP_AMT_LABEL) {
		this.COMP_UI_M_DEP_FC_DEP_AMT_LABEL = COMP_UI_M_DEP_FC_DEP_AMT_LABEL;
	}

	public void setCOMP_UI_M_DEP_FC_DEP_AMT(HtmlInputText COMP_UI_M_DEP_FC_DEP_AMT) {
		this.COMP_UI_M_DEP_FC_DEP_AMT = COMP_UI_M_DEP_FC_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_DEP_AMT_LABEL() {
		return COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_DEP_AMT() {
		return COMP_DEP_LC_DEP_AMT;
	}

	public void setCOMP_DEP_LC_DEP_AMT_LABEL(HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL) {
		this.COMP_DEP_LC_DEP_AMT_LABEL = COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_DEP_AMT(HtmlInputText COMP_DEP_LC_DEP_AMT) {
		this.COMP_DEP_LC_DEP_AMT = COMP_DEP_LC_DEP_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEP_REFUND_DTLS_BACK() {
		return COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_DEP_REFUND_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK) {
		this.COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK = COMP_UI_M_BUT_DEP_REFUND_DTLS_BACK;
	}

	public PT_IL_DEPOSIT getPT_IL_DEPOSIT_BEAN() {
		return PT_IL_DEPOSIT_BEAN;
	}

	public void setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		this.PT_IL_DEPOSIT_BEAN = PT_IL_DEPOSIT_BEAN;
	}
	 
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
		PT_IL_DEPOSIT valuebean = null;
		int DeletedRecordIndex = 0;
		Connection con = CommonUtils.getConnection();
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
	
	public void populateValues() throws  Exception{
	    Connection con = CommonUtils.getConnection();
		PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		String selectQuery = " SELECT * FROM PT_IL_DEPOSIT ";
		if(PT_IL_DEPOSIT_BEAN.getM_WHERE()!=null){
		    selectQuery = selectQuery + " WHERE "+PT_IL_DEPOSIT_BEAN.getM_WHERE(); 
		}
		 BeanList = handler.fetch(selectQuery, "com.iii.pel.forms.PILP018.PT_IL_DEPOSIT",con,
			 new Object[]{ PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_DEP_SYS_ID()});
		 PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = null;
  		Iterator<PT_IL_DEPOSIT> it = BeanList.iterator();
  		while(it.hasNext()){
  			PT_IL_DEPOSIT_BEAN = it.next();
  			PT_IL_DEPOSIT_BEAN.setRowSelected(false);
  		}
  		
  		if (BeanList.size()>0){					
  			this.setPT_IL_DEPOSIT_BEAN(BeanList.get(0));
  			this.getPT_IL_DEPOSIT_BEAN().setRowSelected(true);
  		}
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}
	
	public void PT_IL_DEPOSIT_POST_QUERY() throws Exception{
		PT_IL_CHEQUE_BOUNCE_HDR pt_il_cheque_bounce_hdr = compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		Long CBH_DEP_SYS_ID = pt_il_cheque_bounce_hdr.getCBH_DEP_SYS_ID();
		String CBH_TXN_TYPE = pt_il_cheque_bounce_hdr.getCBH_TXN_TYPE();
		Double DEP_LC_DEP_AMT = (Double)getCOMP_DEP_LC_DEP_AMT().getSubmittedValue();
	        Connection con = CommonUtils.getConnection();
	        try
	        {
	            String selectQuery1= "SELECT PD_DPD_REF_ID FROM  PT_IL_PYMT_DTLS  WHERE  PD_TXN_SYS_ID  = '" +
	            CBH_DEP_SYS_ID + "'" + " AND PD_TXN_TYPE  = '" + CBH_TXN_TYPE  + "'" ;
	            ResultSet rs1= handler.executeSelectStatement(selectQuery1, con);
	            
	            int  GLOBAL_EXCH_RATE = 1;
	             if(nvl(GLOBAL_EXCH_RATE,0)>0)
	            {
	                Double M_DEP_FC_DEP_AMT = (DEP_LC_DEP_AMT * GLOBAL_EXCH_RATE );
	                getCOMP_UI_M_DEP_FC_DEP_AMT().setSubmittedValue(M_DEP_FC_DEP_AMT);
	            }
	            else
	            {
	            	Double M_DEP_FC_DEP_AMT = DEP_LC_DEP_AMT*1;
	            	 getCOMP_UI_M_DEP_FC_DEP_AMT().setSubmittedValue(M_DEP_FC_DEP_AMT);
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	
		
	public int  nvl(int value1,int value2){
		if("".equals(value1)){
			value1 = value2;
		}		
		return  value1; 
	}
	
	public String nvl(String  value1 ,int  value2){
		if("".equals(value1)){
		  value1 = ""+value2;
		}
		return value1;
		
	}
	
	public String nvl(String value1,String value2){
		if("".equals(value1)){
			value1= ""+value2;
		}
		return value1;
	}
		
	public void getDetails() {
		try {
			if (BeanList.size() != 0) {				
				PT_IL_DEPOSIT_BEAN = (PT_IL_DEPOSIT)datatable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_DEPOSIT_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	  }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_DEPOSIT> iterator = BeanList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}

	public void onLoad(PhaseEvent pe) {
	    PILP018_HELPER helper = new PILP018_HELPER();
	    try {
		  if (isBlockFlag()) {
		      helper.PT_IL_DEPOSIT_WHEN_NEW_BLOCK_INSTANCE(compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN(),
			      PT_IL_DEPOSIT_BEAN);
		      populateValues();
		      helper.PT_IL_DEPOSIT_POST_QUERY(PT_IL_DEPOSIT_BEAN, compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN());
		      setBlockFlag(false); 
		  }
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	}
	public void resetAllComponent()
	{
		COMP_UI_M_DPD_REF_ID.resetValue();
		COMP_UI_M_DEP_FC_DEP_AMT.resetValue();
		COMP_DEP_LC_DEP_AMT.resetValue();
	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
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
				if (PT_IL_DEPOSIT_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_DEPOSIT_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					BeanList.remove(PT_IL_DEPOSIT_BEAN);
				}
				if (BeanList.size() > 0) {
					setPT_IL_DEPOSIT_BEAN(BeanList.get(0));
					this
							.setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT_BEAN);
					PT_IL_DEPOSIT_BEAN.setRowSelected(true);
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
			if (PT_IL_DEPOSIT_BEAN.getROWID() != null) {

				if (isUPDATE_ALLOWED()) {

					///this.PRE_UPDATE(PM_IL_PLAN_AGE_SETUP_BEAN);
					new CRUDHandler().executeInsert(PT_IL_DEPOSIT_BEAN,
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

					new CRUDHandler().executeInsert(PT_IL_DEPOSIT_BEAN,
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
					BeanList.add(0, PT_IL_DEPOSIT_BEAN);
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
			PT_IL_DEPOSIT_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	/**
	 * @return the filterByUI_M_DEP_FC_DEP_AMT
	 */
	public String getFilterByUI_M_DEP_FC_DEP_AMT() {
		return filterByUI_M_DEP_FC_DEP_AMT;
	}

	/**
	 * @param filterByUI_M_DEP_FC_DEP_AMT the filterByUI_M_DEP_FC_DEP_AMT to set
	 */
	public void setFilterByUI_M_DEP_FC_DEP_AMT(String filterByUI_M_DEP_FC_DEP_AMT) {
		this.filterByUI_M_DEP_FC_DEP_AMT = filterByUI_M_DEP_FC_DEP_AMT;
	}

	/**
	 * @return the filterByDEP_LC_DEP_AMT
	 */
	public String getFilterByDEP_LC_DEP_AMT() {
		return filterByDEP_LC_DEP_AMT;
	}

	/**
	 * @param filterByDEP_LC_DEP_AMT the filterByDEP_LC_DEP_AMT to set
	 */
	public void setFilterByDEP_LC_DEP_AMT(String filterByDEP_LC_DEP_AMT) {
		this.filterByDEP_LC_DEP_AMT = filterByDEP_LC_DEP_AMT;
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

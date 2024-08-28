package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROP_TREATY_TYPE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTT_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PTT_FRZ_FLAG;

	private HtmlOutputLabel COMP_PTT_SRNO_LABEL;

	private HtmlInputText COMP_PTT_SRNO;

	private HtmlOutputLabel COMP_PTT_TREATY_TYPE_LABEL;

	private HtmlInputText COMP_PTT_TREATY_TYPE;

	private HtmlOutputLabel COMP_UI_M_TREATY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TREATY_DESC;

	private HtmlOutputLabel COMP_PTT_PROFIT_COMM_LABEL;

	private HtmlInputText COMP_PTT_PROFIT_COMM;

	private HtmlOutputLabel COMP_PTT_MGT_EXP_RATIO_LABEL;

	private HtmlInputText COMP_PTT_MGT_EXP_RATIO;

	private HtmlOutputLabel COMP_PTT_REINS_TAX_PERC_LABEL;

	private HtmlInputText COMP_PTT_REINS_TAX_PERC;

	private HtmlOutputLabel COMP_PTT_INT_ON_RES_REL_LABEL;

	private HtmlInputText COMP_PTT_INT_ON_RES_REL;

	private HtmlOutputLabel COMP_PTT_PREM_RES_RATIO_LABEL;

	private HtmlInputText COMP_PTT_PREM_RES_RATIO;

	private HtmlOutputLabel COMP_PTT_LOSS_CF_YEARS_LABEL;

	private HtmlInputText COMP_PTT_LOSS_CF_YEARS;

	private HtmlOutputLabel COMP_PTT_OS_CLM_RES_RATIO_LABEL;

	private HtmlInputText COMP_PTT_OS_CLM_RES_RATIO;

	private HtmlOutputLabel COMP_PTT_EXCLUSION_LABEL;

	private HtmlInputText COMP_PTT_EXCLUSION;

	private HtmlOutputLabel COMP_PTT_DEPOSIT_PREM_LABEL;

	private HtmlInputText COMP_PTT_DEPOSIT_PREM;

	private HtmlOutputLabel COMP_PTT_NOTICE_CANCEL_DAYS_LABEL;

	private HtmlInputText COMP_PTT_NOTICE_CANCEL_DAYS;

	private HtmlOutputLabel COMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_PTT_ACCOUNTS_SUBMIT_PERIOD;

	private HtmlOutputLabel COMP_PTT_LINK_TREATY_CODE_LABEL;

	private HtmlInputText COMP_PTT_LINK_TREATY_CODE;

	private HtmlOutputLabel COMP_UI_M_LINK_TREATY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_LINK_TREATY_DESC;

	private HtmlOutputLabel COMP_PTT_NET_SURPLUS_AMT_LABEL;

	private HtmlInputText COMP_PTT_NET_SURPLUS_AMT;

	private HtmlOutputLabel COMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_PTT_ACCOUNTS_CLOSE_PERIOD;

	private HtmlOutputLabel COMP_PTT_PREM_PF_ENT_PERC_LABEL;

	private HtmlInputText COMP_PTT_PREM_PF_ENT_PERC;

	private HtmlOutputLabel COMP_PTT_PREM_PF_WD_PERC_LABEL;

	private HtmlInputText COMP_PTT_PREM_PF_WD_PERC;

	private HtmlOutputLabel COMP_PTT_LOSS_PF_ENT_PERC_LABEL;

	private HtmlInputText COMP_PTT_LOSS_PF_ENT_PERC;

	private HtmlOutputLabel COMP_PTT_LOSS_PF_WD_PERC_LABEL;

	private HtmlInputText COMP_PTT_LOSS_PF_WD_PERC;

	private List<SelectItem> accSubList = new ArrayList<SelectItem>();

	private List<SelectItem> accCloseList = new ArrayList<SelectItem>();

	private PM_IL_PROP_TREATY_TYPE PM_IL_PROP_TREATY_TYPE_BEAN;

	PM_IL_PROP_TREATY_TYPE_DELEGATE pm_il_prop_treaty_delegate;

	PM_IL_PROP_TREATY_HELPER pm_il_prop_treaty_helper;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private List treatyCodeList = new ArrayList();

	private List treatyLinkCodeList = new ArrayList();

	private int currentPage;

	private int recordsPerPage = 5;

	private int prevRowInd;

	private int lastUpdateRowIndex;

	private ArrayList<PM_IL_PROP_TREATY_TYPE> dataTableList;

	private UIData dataTable;

	private HtmlCommandButton COMP_BUTTON_TYPE_TTY_COVER_DETIALS;

	private HtmlCommandButton COMP_BUTTON_TYPE_COVER;

	private HtmlCommandButton COMP_BUTTON_PART_CUST;

	private HtmlCommandButton COMP_BUTTON_PERIOD_DETAILS;
	
	//filters
	private String filterByPTT_TREATY_TYPE;
	
	private String filterByPTT_PROFIT_COMM;

	/*private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;*/
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	private int lastUpdatedRowIndex;

	PM_IL_PROP_TREATY_TYPE_HELPER helper = new  PM_IL_PROP_TREATY_TYPE_HELPER();
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;
	
	public PM_IL_PROP_TREATY_TYPE_ACTION() {
		dataTableList = new ArrayList<PM_IL_PROP_TREATY_TYPE>();
		pm_il_prop_treaty_helper = new PM_IL_PROP_TREATY_HELPER();
		prevRowInd = 0;
		currentPage = 1;
		PM_IL_PROP_TREATY_TYPE_BEAN = new PM_IL_PROP_TREATY_TYPE();
		pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_TYPE_DELEGATE();
		try{
			
			/*Modified by Janani on 20.07.2017 for ZBILQC-1719875*/
			
			/*accSubList = pm_il_prop_treaty_delegate.comboBoxValues("PILM015_APAC",
					"PM_IL_PROP_TREATY_TYPE",
					"PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD", "PAYMODE");*/
			
			
			accSubList = pm_il_prop_treaty_delegate.comboBoxValues("PILM015_APAC",
					"PM_IL_PROP_TREATY_TYPE",
					"PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD", "PAYMODE_1");
			
			/*End*/
			
			accCloseList = pm_il_prop_treaty_delegate.comboBoxValues(
					"PILM015_APAC", "PM_IL_PROP_TREATY_TYPE",
					"PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_CLOSE_PERIOD", "PAYMODE");
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public String deleteRow(ActionEvent ae) {
		try{
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_PROP_TREATY_TYPE bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;
			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = pm_il_prop_treaty_delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);
					} else {
						index++;
					}
				}
				double var = 0;
				if(dataTableList.size() > 0) {
					setPM_IL_PROP_TREATY_TYPE_BEAN(dataTableList.get(0));
					PM_IL_PROP_TREATY_TYPE_BEAN.setRowSelected(true);
					Iterator iterator = dataTableList.iterator();
					while (iterator.hasNext()) {
						bean = (PM_IL_PROP_TREATY_TYPE) iterator.next();
						var++;
						bean.setPTT_SRNO(var);
					}
				} else {
					addNew(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							+deletedRecordList.size() + "Record Deleted Successfully,Please save it. ");
					getWarningMap().put("CURRENT",
							+deletedRecordList.size() + "Record Deleted Successfully,Please save it. ");
				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TREATY_TYPE_BEAN.setRowSelected(true);	
			}catch(Exception exception){
				exception.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exception.getMessage());
				getErrorMap().put("CURRENT", exception.getMessage());
			}
			return "";
	}
	
	public void lastColumnListener() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_TYPE gridValueBean = null;
		try {
			gridValueBean = (PM_IL_PROP_TREATY_TYPE) dataTableList
					.get(currRowIndex);
			if (gridValueBean.getROWID() != null) {
				rowUpdated = pm_il_prop_treaty_delegate
						.updateForTreatyType(gridValueBean);
				getWarningMap().put("current", "Records Updated");
			} else {
				PM_IL_PROP_TREATY_ACTION typeAction = compositeAction.getPM_IL_PROP_TREATY_ACTION();
				PM_IL_PROP_TREATY typeValue = typeAction.getPM_IL_PROP_TREATY_BEAN();
				Double PT_SYS_ID = typeValue.getPT_SYS_ID();
				gridValueBean.setPTT_PT_SYS_ID(PT_SYS_ID);
				Double PTT_SYS_ID = pm_il_prop_treaty_helper.getSysIdForTreatyType();
				gridValueBean.setPTT_SYS_ID(PTT_SYS_ID);
				PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_SYS_ID(PTT_SYS_ID);
				if (PM_IL_PROP_TREATY_TYPE_BEAN.isFreeze()) {
					gridValueBean.setPTT_FRZ_FLAG("Y");
				} else {
					gridValueBean.setPTT_FRZ_FLAG("N");
				}
				rowUpdated = pm_il_prop_treaty_delegate
						.updateForTreatyType(gridValueBean);
				getWarningMap().put("current", "Records Inserted");
			}
			lastUpdateRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
		}
		return;
	}

	/* Validation For Cover */

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void lastColumnListenerEvent(ActionEvent event)
	{
		UIInput input = (UIInput) event.getComponent().getParent();
		if(input.getSubmittedValue()!=null)
		{
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		else
		{
//			lastColumnListener();
		}
	}

	public List suggestionAction(Object obj) {
		String treatyCode = (String) obj;
		try {
			treatyCodeList = new PM_IL_PROP_TREATY_DELEGATE().suggestionAction(
					treatyCode, treatyCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return treatyCodeList;
	}

	public void gettreatyCodeDesc(ActionEvent event) {
		COMP_UI_M_TREATY_DESC.setSubmittedValue(null);
		PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_DELEGATE();
		if (COMP_PTT_TREATY_TYPE.getSubmittedValue() != null) {
			String treatyCode = (String) COMP_PTT_TREATY_TYPE
					.getSubmittedValue();
			String treatyDesc = pm_il_prop_treaty_delegate.getTreatyDesc(
					treatyCode, treatyCodeList);
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
			pm_il_prop_treaty_type.setUI_M_TREATY_DESC(treatyDesc);
		}
	}

	public List suggestionActionForLinkTreaty(Object obj) {
		try {
			String treatyLinkCode = (String) obj;
			treatyLinkCodeList = new PM_IL_PROP_TREATY_DELEGATE()
					.treatyLinkCodeAction(treatyLinkCode, treatyLinkCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return treatyLinkCodeList;
	}

	public void gettreatyCodeLinkDesc(ActionEvent event) {
		COMP_UI_M_LINK_TREATY_DESC.setSubmittedValue(null);
		PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_DELEGATE();
		if (COMP_PTT_LINK_TREATY_CODE.getSubmittedValue() != null) {
			String treatyLinkCode = (String) COMP_PTT_LINK_TREATY_CODE
					.getSubmittedValue();
			String treatyLinkDesc = pm_il_prop_treaty_delegate
					.getTreatyLinkDesc(treatyLinkCode, treatyLinkCodeList);
			COMP_UI_M_LINK_TREATY_DESC.setSubmittedValue(treatyLinkDesc);

		}
	}

	public String goToPeriod() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_PROP_TREATY_PERIOD_HELPER treatyPeriodHelper = new PM_IL_PROP_TREATY_PERIOD_HELPER();
		PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
		try {
			treatyPeriodHelper.pilm015_apac_pm_il_prop_treaty_period_when_new_block_instance(
							compositeAction,
							pm_il_prop_treaty_type);
		Iterator<PM_IL_PROP_TREATY_PERIOD> iterator = compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION().getDataTableList().iterator();
		while(iterator.hasNext()){
			PM_IL_PROP_TREATY_PERIOD pm_il_prop_treaty_period = iterator.next();
			pm_il_prop_treaty_period.setRowSelected(false);
		}
		if (compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION().getDataTableList().size() !=0){					
			compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION().setPM_IL_PROP_TREATY_PERIOD_BEAN(compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION().getDataTableList().get(0));
			compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION().getPM_IL_PROP_TREATY_PERIOD_BEAN().setRowSelected(true);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		
		return "PeriodDetails";

	}
	
	
/*	public String companyDetails() {
		ArrayList<PM_IL_PROP_TREATY_PART_CUST> detailsTableList = null;
		PM_IL_PROP_TREATY_TYPE checkedBean = null;
		int totalCheckBoxSelected = 0;
		String returnValue = null;
		try {
			if(dataTableList != null && dataTableList.size() > 0) {
				for(PM_IL_PROP_TREATY_TYPE tempBean : dataTableList) {
					if(tempBean!= null) {
						checkedBean = tempBean;
						if ("dataTableSelectedRow".equalsIgnoreCase(checkedBean.getRowSelected())) {
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().setTempTreaty_TypeBean(checkedBean);
							double sysId = checkedBean.getPTT_SYS_ID();
							System.out.println("value of sys id in treaty data"+sysId);
							String selectQuery = "SELECT P.*,PTPC.*,P.ROWID AS P_ROWID,PTPC.ROWID AS PTPC_ROWID " +
									" FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_PART_CUST PTPC "
								+ " WHERE PTPC.PTPC_PTT_SYS_ID=P.PTT_SYS_ID AND PTPC.PTPC_PTT_SYS_ID= '"+ sysId + "' ";
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().setDataTableList
							((ArrayList<PM_IL_PROP_TREATY_PART_CUST>) getCustomerDetailsList(selectQuery));
							new PM_IL_PROP_TREATY_PART_CUST_HELPER().
							pilm015_apac_pm_il_prop_treaty_part_cust__post_query(compositeAction);
							Iterator<PM_IL_PROP_TREATY_PART_CUST> iterator = compositeAction.
								getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().iterator();
							while(iterator.hasNext()){
								PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = iterator.next();
								pm_il_prop_treaty_part_cust.setRowSelected(false);
							}
							if (compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().size() !=0){					
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
									setPM_IL_PROP_TREATY_PART_CUST_BEAN(compositeAction.
										getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().get(0));
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
									getPM_IL_PROP_TREATY_PART_CUST_BEAN().setRowSelected(true);
							}
							returnValue = "CompanyDetails";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return returnValue;
	}*/
	public String companyDetails1() {
		if (getErrorMap().containsKey("current")|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		String name = "";
		if (selectedList.size() == 0 || selectedList.size() > 0) {
		}
		if (selectedList.size() == 1) {
			int selectedRow = selectedList.get(0);
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = dataTableList.get(selectedRow);
			getPM_IL_PROP_TREATY_TYPE_BEAN().setPTT_SYS_ID(pm_il_prop_treaty_type.getPTT_SYS_ID());
			compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().setTempTreaty_TypeBean(pm_il_prop_treaty_type);
			if (pm_il_prop_treaty_type.getROWID() != null) {
				double sysId = compositeAction.
									PM_IL_PROP_TREATY_TYPE_ACTION.getPM_IL_PROP_TREATY_TYPE_BEAN().
										getPTT_SYS_ID();
				String selectQuery = "SELECT P.*,PTPC.*,P.ROWID AS P_ROWID,PTPC.ROWID AS PTPC_ROWID"
						+ " FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_PART_CUST PTPC "
						+ "WHERE PTPC.PTPC_PTT_SYS_ID=P.PTT_SYS_ID AND PTPC.PTPC_PTT_SYS_ID= '"
						+ sysId + "' ";
				try {
					compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
										setDataTableList((ArrayList<PM_IL_PROP_TREATY_PART_CUST>) 
												getCustomerDetailsList(selectQuery));
					new PM_IL_PROP_TREATY_PART_CUST_HELPER().
						pilm015_apac_pm_il_prop_treaty_part_cust__post_query(compositeAction);
					name = "CompanyDetails";
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
					getErrorMap().put("CURRENT", e.getMessage());
				}
			}
			else {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
										"Invalid Record Cannot Fetch Without Insert");
				getErrorMap().put("CURRENT","Invalid Record Cannot Fetch Without Insert");
			}
			// return null;
		}
		selectedList.clear();
		return name;

	}
	public List<PM_IL_PROP_TREATY_PART_CUST> getCustomerDetailsList(String query) throws Exception {
		List<PM_IL_PROP_TREATY_PART_CUST> arrayList = new ArrayList<PM_IL_PROP_TREATY_PART_CUST>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = new PM_IL_PROP_TREATY_PART_CUST();
				pm_il_prop_treaty_part_cust.setPTPC_SYS_ID(resultSet
						.getDouble("PTPC_SYS_ID"));
				pm_il_prop_treaty_part_cust.setPTPC_PTT_SYS_ID(resultSet
						.getDouble("PTPC_PTT_SYS_ID"));
				pm_il_prop_treaty_part_cust.setPTPC_CUST_CODE(resultSet
						.getString("PTPC_CUST_CODE"));
				pm_il_prop_treaty_part_cust.setPTPC_SHARE_PERC(resultSet
						.getDouble("PTPC_SHARE_PERC"));
				pm_il_prop_treaty_part_cust.setPTPC_LEADER_YN(resultSet
						.getString("PTPC_LEADER_YN"));
				pm_il_prop_treaty_part_cust.setPTPC_CR_DT(resultSet
						.getDate("PTPC_CR_DT"));
				pm_il_prop_treaty_part_cust.setPTPC_CR_UID(resultSet
						.getString("PTPC_CR_UID"));
				pm_il_prop_treaty_part_cust.setPTPC_UPD_DT(resultSet
						.getDate("PTPC_UPD_DT"));
				pm_il_prop_treaty_part_cust.setPTPC_UPD_UID(resultSet
						.getString("PTPC_UPD_UID"));
				pm_il_prop_treaty_part_cust.setROWID(resultSet
						.getString("PTPC_ROWID"));
				arrayList.add(pm_il_prop_treaty_part_cust);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return arrayList;
	}

	public String typeWiseCoverdetails() {
		String outcome = null;
		String selectQuery = null;
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION()
					.setTempTreaty_TypeBean(PM_IL_PROP_TREATY_TYPE_BEAN);
			if (PM_IL_PROP_TREATY_TYPE_BEAN.getROWID() != null) {
				selectQuery = "SELECT P.*,PTTC.*,P.ROWID AS P_ROWID,PTTC.ROWID AS PTTC_ROWID	"
						+ "FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_TYPE_COVER PTTC "
						+ "WHERE PTTC.PTTC_PTT_SYS_ID=P.PTT_SYS_ID AND PTTC.PTTC_PTT_SYS_ID='"
						+ PM_IL_PROP_TREATY_TYPE_BEAN.getPTT_SYS_ID() + "' ";
				compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().setDataTableList(
						(ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>) getTypeDetailsList(selectQuery));
				if(compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().getDataTableList().size()> 0 &&
						compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().getDataTableList().get(0) != null){
					compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().setPM_IL_PROP_TREATY_TYPE_CVR_BEAN(
							compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().getDataTableList().get(0)); 
					compositeAction.getPM_IL_PROP_TREATY_TYPE_CVR_ACTION().getPM_IL_PROP_TREATY_TYPE_CVR_BEAN().setRowSelected(true);	
				}
				new PM_IL_PROP_TREATY_TYPE_CVR_HELPER()
						.pilm015_apac_pm_il_prop_treaty_type_cvr_post_query(compositeAction);
				outcome = "TypeWiseDetails";
			} else {
				message = "Invalid Record! Please save the the page and try again."; 
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						message);
				getErrorMap().put("details", message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

		return outcome;

	}

	public List<PM_IL_PROP_TREATY_TYPE_CVR> getTypeDetailsList(String query) throws Exception {
		List<PM_IL_PROP_TREATY_TYPE_CVR> arrayList = new ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query,
					connection);

			while (resultSet.next()) {

				PM_IL_PROP_TREATY_TYPE_CVR pm_il_prop_treaty_type_cover = new PM_IL_PROP_TREATY_TYPE_CVR();
				pm_il_prop_treaty_type_cover.setPTTC_SYS_ID(resultSet
						.getDouble("PTTC_SYS_ID"));
				pm_il_prop_treaty_type_cover.setPTTC_PTT_SYS_ID(resultSet
						.getDouble("PTTC_PTT_SYS_ID"));
				pm_il_prop_treaty_type_cover.setPTTC_COVER_CODE(resultSet
						.getString("PTTC_COVER_CODE"));
				pm_il_prop_treaty_type_cover.setPTTC_PERC(resultSet
						.getDouble("PTTC_PERC"));
				pm_il_prop_treaty_type_cover.setPTTC_CR_DT(resultSet
						.getDate("PTTC_CR_DT"));
				pm_il_prop_treaty_type_cover.setPTTC_CR_UID(resultSet
						.getString("PTTC_CR_UID"));
				pm_il_prop_treaty_type_cover.setPTTC_UPD_DT(resultSet
						.getDate("PTTC_UPD_DT"));
				pm_il_prop_treaty_type_cover.setPTTC_UPD_UID(resultSet
						.getString("PTTC_UPD_UID"));
				pm_il_prop_treaty_type_cover.setROWID(resultSet
						.getString("PTTC_ROWID"));
				arrayList.add(pm_il_prop_treaty_type_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public void saveData() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved");
			getWarningMap().put("CURRENT", "Records Saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_PROP_TREATY_TYPE> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_PROP_TREATY_TYPE> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public PM_IL_PROP_TREATY_TYPE_DELEGATE getPm_il_prop_treaty_delegate() {
		return pm_il_prop_treaty_delegate;
	}

	public void setPm_il_prop_treaty_delegate(
			PM_IL_PROP_TREATY_TYPE_DELEGATE pm_il_prop_treaty_delegate) {
		this.pm_il_prop_treaty_delegate = pm_il_prop_treaty_delegate;
	}

	public PM_IL_PROP_TREATY_HELPER getPm_il_prop_treaty_helper() {
		return pm_il_prop_treaty_helper;
	}

	public void setPm_il_prop_treaty_helper(
			PM_IL_PROP_TREATY_HELPER pm_il_prop_treaty_helper) {
		this.pm_il_prop_treaty_helper = pm_il_prop_treaty_helper;
	}

	public void validatePTT_TREATY_TYPE(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
		String inputValue = (String) value;
		DBProcedures procedures = new DBProcedures();
		try{
			if (inputValue != null) {
				pm_il_prop_treaty_type.setPTT_TREATY_TYPE(inputValue);
			}
			PM_IL_PROP_TREATY_TYPE_HELPER helper = new PM_IL_PROP_TREATY_TYPE_HELPER();
			PM_IL_PROP_TREATY treatyValueBean = compositeAction
					.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
			String pttTreatyType = pm_il_prop_treaty_type.getPTT_TREATY_TYPE();
			String ptClassCode = treatyValueBean.getPT_CLASS_CODE();
			ArrayList<String> treatyDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							pttTreatyType, "N", "E", ptClassCode);
			if (treatyDescList != null && treatyDescList.size() != 0) {
				pm_il_prop_treaty_type.setUI_M_TREATY_DESC(treatyDescList.get(0));
			}
			String pttLinkTreatyCode = pm_il_prop_treaty_type
					.getPTT_LINK_TREATY_CODE();
			if (pttLinkTreatyCode == null) {
				pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE(pttTreatyType);
				compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
						.getCOMP_PTT_LINK_TREATY_CODE().setSubmittedValue(
								pttTreatyType);
			}
			pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE(pttTreatyType);
			ArrayList<String> linkTreatyDeacList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							pm_il_prop_treaty_type.getPTT_LINK_TREATY_CODE(), "N",
							"E", ptClassCode);
			if (linkTreatyDeacList != null && linkTreatyDeacList.size() != 0) {
				pm_il_prop_treaty_type.setUI_M_LINK_TREATY_DESC(linkTreatyDeacList
						.get(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlCommandButton getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS() {
		return COMP_BUTTON_TYPE_TTY_COVER_DETIALS;
	}

	public void setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(
			HtmlCommandButton comp_button_type_tty_cover_detials) {
		COMP_BUTTON_TYPE_TTY_COVER_DETIALS = comp_button_type_tty_cover_detials;
	}

	public HtmlCommandButton getCOMP_BUTTON_TYPE_COVER() {
		return COMP_BUTTON_TYPE_COVER;
	}

	public void setCOMP_BUTTON_TYPE_COVER(
			HtmlCommandButton comp_button_type_cover) {
		COMP_BUTTON_TYPE_COVER = comp_button_type_cover;
	}

	public HtmlCommandButton getCOMP_BUTTON_PART_CUST() {
		return COMP_BUTTON_PART_CUST;
	}

	public void setCOMP_BUTTON_PART_CUST(HtmlCommandButton comp_button_part_cust) {
		COMP_BUTTON_PART_CUST = comp_button_part_cust;
	}

	public HtmlCommandButton getCOMP_BUTTON_PERIOD_DETAILS() {
		return COMP_BUTTON_PERIOD_DETAILS;
	}

	public void setCOMP_BUTTON_PERIOD_DETAILS(
			HtmlCommandButton comp_button_period_details) {
		COMP_BUTTON_PERIOD_DETAILS = comp_button_period_details;
	}

	/*
	 * public void commSubYearPercWhenValidate(FacesContext context, UIComponent
	 * component, Object value) throws ValidatorException, SQLException,
	 * Exception { if ((COMP_PTC_COMM_PERC_SUB_YRS.getSubmittedValue() != null)) {
	 * double commSubYear = Double .parseDouble((String)
	 * COMP_PTC_COMM_PERC_SUB_YRS .getSubmittedValue());
	 * System.out.println("comm Sub Years--------->" + commSubYear);
	 * HelperForCover.subStandardTreatyLimitWhenValidateItem(this, commSubYear); } }
	 */

	/**
	 * PTT_ACCOUNTS_SUBMIT_PERIOD VALIDATE METHOD
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void validatePTT_ACCOUNTS_SUBMIT_PERIOD(FacesContext context,
			UIComponent component, Object value) throws Exception{
		try{
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
			if (value != null) {
				pm_il_prop_treaty_type
						.setPTT_ACCOUNTS_SUBMIT_PERIOD((String) value);
			}
			PM_IL_PROP_TREATY_TYPE_HELPER helper = new PM_IL_PROP_TREATY_TYPE_HELPER();
			helper.pilm015_apac_pm_il_prop_treaty_type_ptt_accounts_submit_period_when_validate_item(
						pm_il_prop_treaty_type);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * WHEN-vALIDATE-iTEM PTT_LINK_TREATY_CODE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws SQLException
	 * @throws Exception
	 */
	public void validatePTT_LINK_TREATY_CODE(FacesContext context,
			UIComponent component, Object value)  {
		DBProcedures procedures = new DBProcedures();
		PM_IL_PROP_TREATY_TYPE_HELPER helper = new PM_IL_PROP_TREATY_TYPE_HELPER();
		PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
		try{
			if (value != null) {
				pm_il_prop_treaty_type.setPTT_LINK_TREATY_CODE((String) value);
				PM_IL_PROP_TREATY treatyValueBean = compositeAction
				.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
					ArrayList<String> treatyDescList = procedures
					.helperP_VAL_CODES(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_TREATY_TYPE,
							value.toString(), "N", "E", treatyValueBean.getPT_CLASS_CODE());
					if (treatyDescList != null && treatyDescList.size() != 0) {
						pm_il_prop_treaty_type.setUI_M_LINK_TREATY_DESC(treatyDescList.get(0));
					}
			}
			String linkTreatyCode = pm_il_prop_treaty_type
					.getPTT_LINK_TREATY_CODE();
			String treatyType = pm_il_prop_treaty_type.getPTT_TREATY_TYPE();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void COMP_PT_SRNO_WHEN_VALIDATE(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * PTT_SRNO VALIDATE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 * @throws Exception
	 */
	public void validatePTT_SRNO(FacesContext context, UIComponent component,
			Object value)  {
		try{
			if (COMP_PTT_SRNO.getSubmittedValue() != null) {
				double sNo = Double.parseDouble((String) COMP_PTT_SRNO
						.getSubmittedValue());
				HtmlInputText COMP_PTC_SUB_STD_TARIFF = new HtmlInputText();
				if (sNo != 1) {
					COMP_PTC_SUB_STD_TARIFF.setDisabled(true);
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
							.setCOMP_PTC_SUB_STD_TARIFF(COMP_PTC_SUB_STD_TARIFF);
				} else if (sNo == 1) {
					COMP_PTC_SUB_STD_TARIFF.setDisabled(false);
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
							.setCOMP_PTC_SUB_STD_TARIFF(COMP_PTC_SUB_STD_TARIFF);
				}
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_SRNO(sNo);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void profitPercValidate(FacesContext context, UIComponent component,
			Object value)  {
		try{
			if (COMP_PTT_PROFIT_COMM.getSubmittedValue() != null) {
	
				double profitPercentage = Double
						.parseDouble((String) COMP_PTT_PROFIT_COMM
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_PROFIT_COMM(profitPercentage);
				//helper.chechForNegative(profitPercentage);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void mangExpRatioValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (COMP_PTT_MGT_EXP_RATIO.getSubmittedValue() != null) {
				double mgtExpRatio = Double
						.parseDouble((String) COMP_PTT_MGT_EXP_RATIO
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_MGT_EXP_RATIO(mgtExpRatio);
				//helper.chechForNegative(mgtExpRatio);
				//gridtabListener();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void reinsTaxPercValidate(FacesContext context,
			UIComponent component, Object value){
		try{
			if (COMP_PTT_REINS_TAX_PERC.getSubmittedValue() != null) {
				double reinTaxPerc = Double
						.parseDouble((String) COMP_PTT_REINS_TAX_PERC
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_REINS_TAX_PERC(reinTaxPerc);
				//helper.chechForNegative(reinTaxPerc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void insOnResRel(FacesContext facesContext, UIComponent component,
			Object value) {
		try{
			if (COMP_PTT_INT_ON_RES_REL.getSubmittedValue() != null) {
				double reinTaxPerc = Double
						.parseDouble((String) COMP_PTT_INT_ON_RES_REL
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_INT_ON_RES_REL(reinTaxPerc);
				//helper.chechForNegative(reinTaxPerc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void premResRatioValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (COMP_PTT_PREM_RES_RATIO.getSubmittedValue() != null) {
				double preResRatio = Double
						.parseDouble((String) COMP_PTT_PREM_RES_RATIO
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_PREM_RES_RATIO(preResRatio);
				//helper.chechForNegative(preResRatio);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void lossCFYearsValidate(FacesContext context,
			UIComponent component, Object value)  {
		try{
			if (COMP_PTT_LOSS_CF_YEARS.getSubmittedValue() != null) {
				double lossCfYears = Double
						.parseDouble((String) COMP_PTT_LOSS_CF_YEARS
								.getSubmittedValue());
				if(((String)COMP_PTT_LOSS_CF_YEARS.getSubmittedValue().toString()).startsWith("-"))
				{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "333000"));
				}
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_LOSS_CF_YEARS(lossCfYears);
				//helper.chechForNegative(lossCfYears);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void osClaimsResvRatioValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_OS_CLM_RES_RATIO((Double) value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void exclusionValidate(FacesContext context, UIComponent component,
			Object value) {
		try{
		if (COMP_PTT_EXCLUSION.getSubmittedValue() != null) {
			String exclusion = (String) COMP_PTT_EXCLUSION.getSubmittedValue();
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
			pm_il_prop_treaty_type.setPTT_EXCLUSION(exclusion);
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void depPremValidate(FacesContext context, UIComponent component,
			Object value){
		try{
			if (COMP_PTT_DEPOSIT_PREM.getSubmittedValue() != null) {
				double depositPremium = Double
						.parseDouble((String) COMP_PTT_DEPOSIT_PREM
								.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_DEPOSIT_PREM(depositPremium);
				//helper.chechForNegative(depositPremium);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	

	}

	public void noticeCancelDayValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (COMP_PTT_NOTICE_CANCEL_DAYS.getSubmittedValue() != null) {
				double noticeCancellation = Double
						.parseDouble((String) COMP_PTT_NOTICE_CANCEL_DAYS
								.getSubmittedValue());
				if (((String)COMP_PTT_NOTICE_CANCEL_DAYS.getSubmittedValue().toString()).startsWith("-")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "333000"));
				}
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type
						.setPTT_NOTICE_CANCEL_DAYS(noticeCancellation);
				//helper.chechForNegative(noticeCancellation);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	

	}

	public void netSurValidate(FacesContext context, UIComponent component,
			Object value) {
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_NET_SURPLUS_AMT((Double) value);
				//helper.chechForNegative((Double) value);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	

	}

	public void acClosePercValidate(FacesContext context,
			UIComponent component, Object value){
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_ACCOUNTS_CLOSE_PERIOD((String) value);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	
	}

	public void premPFEntryValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_PREM_PF_ENT_PERC((Double) value);
				//helper.chechForNegative((Double) value);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void premPFWithDValidate(FacesContext context,
			UIComponent component, Object value)  {
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_PREM_PF_WD_PERC((Double) value);
			//	helper.chechForNegative((Double) value);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void lossPFEntryValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_LOSS_PF_ENT_PERC((Double) value);
				//helper.chechForNegative((Double) value);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void lossPFWidthValidate(FacesContext context,
			UIComponent component, Object value) {
		try{
			if (value != null) {
				PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
				pm_il_prop_treaty_type.setPTT_LOSS_PF_WD_PERC((Double) value);
				//helper.chechForNegative((Double) value);
	
			}
		}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}
		PM_IL_PROP_TREATY_TYPE treatyTypeBean = dataTableList.get(row);
		if (selected.equals("true")) {
			treatyTypeBean.setSelected(true);
		}else {
			treatyTypeBean.setSelected(false);
		}
	}

	public String fetchTreatyTypeList() throws Exception {
		try {
			double sysId = sysIdTreatyMaster();
			dataTableList = (ArrayList<PM_IL_PROP_TREATY_TYPE>) new PM_IL_PROP_TREATY_DELEGATE()
					.prepareTreatyList(compositeAction, sysId);
			Iterator<PM_IL_PROP_TREATY_TYPE> iterator = dataTableList.iterator();
			while(iterator.hasNext()){
				PM_IL_PROP_TREATY_TYPE_BEAN = iterator.next();
				PM_IL_PROP_TREATY_TYPE_BEAN.setRowSelected(false);
			}
			if (dataTableList.size() !=0){					
				setPM_IL_PROP_TREATY_TYPE_BEAN(dataTableList.get(0));
				getPM_IL_PROP_TREATY_TYPE_BEAN().setRowSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return "TreatyType";
	}

	public String coverDetails() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		String name = "";
		if ("dataTableSelectedRow".equalsIgnoreCase(PM_IL_PROP_TREATY_TYPE_BEAN.getRowSelected())) {
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type = this.PM_IL_PROP_TREATY_TYPE_BEAN;
			getPM_IL_PROP_TREATY_TYPE_BEAN().setPTT_SYS_ID(
					pm_il_prop_treaty_type.getPTT_SYS_ID());
			compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
					.setTempTreaty_TypeBean(pm_il_prop_treaty_type);
			//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix		
			setPM_IL_PROP_TREATY_TYPE_BEAN(pm_il_prop_treaty_type);
			//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
			if (pm_il_prop_treaty_type.getROWID() != null) {
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().setOnLoadFlag(false);
				name = "CoverDetails";
			} else {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Invalid Record! Cannot Fetch Without Inserting");
				getErrorMap().put("CURRENT",
				"Invalid Record! Cannot Fetch Without Inserting");

			}
		}
		selectedList.clear();
		return name;

	}

	/*public List<PM_IL_PROP_TREATY_COVER> getCoverDetailsList(String query) {
		List<PM_IL_PROP_TREATY_COVER> arrayList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_SYS_ID(resultSet
						.getDouble("PTC_SYS_ID"));
				pm_il_prop_treaty_cover.setPTC_PTT_SYS_ID(resultSet
						.getDouble("PTC_PTT_SYS_ID"));
				pm_il_prop_treaty_cover.setPTC_COVER_CODE(resultSet
						.getString("PTC_COVER_CODE"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_UPD_DT(resultSet
						.getDate("PTC_UPD_DT"));
				pm_il_prop_treaty_cover.setPTC_UPD_UID(resultSet
						.getString("PTC_UPD_UID"));
				pm_il_prop_treaty_cover.setPTC_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_SUB_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_RETN_PERC(resultSet
						.getDouble("PTC_RETN_PERC"));
				pm_il_prop_treaty_cover.setPTC_STD_MAX_RETN(resultSet
						.getDouble("PTC_STD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_MAX_RETN(resultSet
						.getDouble("PTC_SSTD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TARIFF(resultSet
						.getString("PTC_SUB_STD_TARIFF"));
				pm_il_prop_treaty_cover.setPTC_GROUP_COVER_YN(resultSet
						.getString("PTC_GROUP_COVER_YN"));
				pm_il_prop_treaty_cover.setPTC_CVR_GRP_CODE(resultSet
						.getString("PTC_CVR_GRP_CODE"));
				pm_il_prop_treaty_cover.setROWID(resultSet
						.getString("PC_ROWID"));

				new PM_IL_PROP_TREATY_COVER_HELPER()
						.postQuery(pm_il_prop_treaty_cover);
				arrayList.add(pm_il_prop_treaty_cover);
			}
			System.out.println(arrayList.size());
			
			 * arrayList = handler.fetch(query,
			 * "com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_COVER",
			 * connection);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}*/

	public Double sysIdTreatyMaster() {
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		PM_IL_PROP_TREATY_ACTION pm_il_prop_treaty_action = compositeAction
				.getPM_IL_PROP_TREATY_ACTION();

		Double sysid = pm_il_prop_treaty_action.getPM_IL_PROP_TREATY_BEAN()
				.getPT_SYS_ID();
		System.out.println();
		String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
		return sysid;
	}

	public String backtoTreaty() {
		getErrorMap().clear();
		getWarningMap().clear();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "TreatyMaster";

	}

	public HtmlOutputLabel getCOMP_PTT_FRZ_FLAG_LABEL() {
		return COMP_PTT_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PTT_FRZ_FLAG() {
		return COMP_PTT_FRZ_FLAG;
	}

	public void setCOMP_PTT_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_PTT_FRZ_FLAG_LABEL) {
		this.COMP_PTT_FRZ_FLAG_LABEL = COMP_PTT_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PTT_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_PTT_FRZ_FLAG) {
		this.COMP_PTT_FRZ_FLAG = COMP_PTT_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PTT_SRNO_LABEL() {
		return COMP_PTT_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_PTT_SRNO() {
		return COMP_PTT_SRNO;
	}

	public void setCOMP_PTT_SRNO_LABEL(HtmlOutputLabel COMP_PTT_SRNO_LABEL) {
		this.COMP_PTT_SRNO_LABEL = COMP_PTT_SRNO_LABEL;
	}

	public void setCOMP_PTT_SRNO(HtmlInputText COMP_PTT_SRNO) {
		this.COMP_PTT_SRNO = COMP_PTT_SRNO;
	}

	public HtmlOutputLabel getCOMP_PTT_TREATY_TYPE_LABEL() {
		return COMP_PTT_TREATY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PTT_TREATY_TYPE() {
		return COMP_PTT_TREATY_TYPE;
	}

	public void setCOMP_PTT_TREATY_TYPE_LABEL(
			HtmlOutputLabel COMP_PTT_TREATY_TYPE_LABEL) {
		this.COMP_PTT_TREATY_TYPE_LABEL = COMP_PTT_TREATY_TYPE_LABEL;
	}

	public void setCOMP_PTT_TREATY_TYPE(HtmlInputText COMP_PTT_TREATY_TYPE) {
		this.COMP_PTT_TREATY_TYPE = COMP_PTT_TREATY_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TREATY_DESC_LABEL() {
		return COMP_UI_M_TREATY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TREATY_DESC() {
		return COMP_UI_M_TREATY_DESC;
	}

	public void setCOMP_UI_M_TREATY_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_TREATY_DESC_LABEL) {
		this.COMP_UI_M_TREATY_DESC_LABEL = COMP_UI_M_TREATY_DESC_LABEL;
	}

	public void setCOMP_UI_M_TREATY_DESC(HtmlInputText COMP_UI_M_TREATY_DESC) {
		this.COMP_UI_M_TREATY_DESC = COMP_UI_M_TREATY_DESC;
	}

	public HtmlOutputLabel getCOMP_PTT_PROFIT_COMM_LABEL() {
		return COMP_PTT_PROFIT_COMM_LABEL;
	}

	public HtmlInputText getCOMP_PTT_PROFIT_COMM() {
		return COMP_PTT_PROFIT_COMM;
	}

	public void setCOMP_PTT_PROFIT_COMM_LABEL(
			HtmlOutputLabel COMP_PTT_PROFIT_COMM_LABEL) {
		this.COMP_PTT_PROFIT_COMM_LABEL = COMP_PTT_PROFIT_COMM_LABEL;
	}

	public void setCOMP_PTT_PROFIT_COMM(HtmlInputText COMP_PTT_PROFIT_COMM) {
		this.COMP_PTT_PROFIT_COMM = COMP_PTT_PROFIT_COMM;
	}

	public HtmlOutputLabel getCOMP_PTT_MGT_EXP_RATIO_LABEL() {
		return COMP_PTT_MGT_EXP_RATIO_LABEL;
	}

	public HtmlInputText getCOMP_PTT_MGT_EXP_RATIO() {
		return COMP_PTT_MGT_EXP_RATIO;
	}

	public void setCOMP_PTT_MGT_EXP_RATIO_LABEL(
			HtmlOutputLabel COMP_PTT_MGT_EXP_RATIO_LABEL) {
		this.COMP_PTT_MGT_EXP_RATIO_LABEL = COMP_PTT_MGT_EXP_RATIO_LABEL;
	}

	public void setCOMP_PTT_MGT_EXP_RATIO(HtmlInputText COMP_PTT_MGT_EXP_RATIO) {
		this.COMP_PTT_MGT_EXP_RATIO = COMP_PTT_MGT_EXP_RATIO;
	}

	public HtmlOutputLabel getCOMP_PTT_REINS_TAX_PERC_LABEL() {
		return COMP_PTT_REINS_TAX_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTT_REINS_TAX_PERC() {
		return COMP_PTT_REINS_TAX_PERC;
	}

	public void setCOMP_PTT_REINS_TAX_PERC_LABEL(
			HtmlOutputLabel COMP_PTT_REINS_TAX_PERC_LABEL) {
		this.COMP_PTT_REINS_TAX_PERC_LABEL = COMP_PTT_REINS_TAX_PERC_LABEL;
	}

	public void setCOMP_PTT_REINS_TAX_PERC(HtmlInputText COMP_PTT_REINS_TAX_PERC) {
		this.COMP_PTT_REINS_TAX_PERC = COMP_PTT_REINS_TAX_PERC;
	}

	public HtmlOutputLabel getCOMP_PTT_INT_ON_RES_REL_LABEL() {
		return COMP_PTT_INT_ON_RES_REL_LABEL;
	}

	public HtmlInputText getCOMP_PTT_INT_ON_RES_REL() {
		return COMP_PTT_INT_ON_RES_REL;
	}

	public void setCOMP_PTT_INT_ON_RES_REL_LABEL(
			HtmlOutputLabel COMP_PTT_INT_ON_RES_REL_LABEL) {
		this.COMP_PTT_INT_ON_RES_REL_LABEL = COMP_PTT_INT_ON_RES_REL_LABEL;
	}

	public void setCOMP_PTT_INT_ON_RES_REL(HtmlInputText COMP_PTT_INT_ON_RES_REL) {
		this.COMP_PTT_INT_ON_RES_REL = COMP_PTT_INT_ON_RES_REL;
	}

	public HtmlOutputLabel getCOMP_PTT_PREM_RES_RATIO_LABEL() {
		return COMP_PTT_PREM_RES_RATIO_LABEL;
	}

	public HtmlInputText getCOMP_PTT_PREM_RES_RATIO() {
		return COMP_PTT_PREM_RES_RATIO;
	}

	public void setCOMP_PTT_PREM_RES_RATIO_LABEL(
			HtmlOutputLabel COMP_PTT_PREM_RES_RATIO_LABEL) {
		this.COMP_PTT_PREM_RES_RATIO_LABEL = COMP_PTT_PREM_RES_RATIO_LABEL;
	}

	public void setCOMP_PTT_PREM_RES_RATIO(HtmlInputText COMP_PTT_PREM_RES_RATIO) {
		this.COMP_PTT_PREM_RES_RATIO = COMP_PTT_PREM_RES_RATIO;
	}

	public HtmlOutputLabel getCOMP_PTT_LOSS_CF_YEARS_LABEL() {
		return COMP_PTT_LOSS_CF_YEARS_LABEL;
	}

	public HtmlInputText getCOMP_PTT_LOSS_CF_YEARS() {
		return COMP_PTT_LOSS_CF_YEARS;
	}

	public void setCOMP_PTT_LOSS_CF_YEARS_LABEL(
			HtmlOutputLabel COMP_PTT_LOSS_CF_YEARS_LABEL) {
		this.COMP_PTT_LOSS_CF_YEARS_LABEL = COMP_PTT_LOSS_CF_YEARS_LABEL;
	}

	public void setCOMP_PTT_LOSS_CF_YEARS(HtmlInputText COMP_PTT_LOSS_CF_YEARS) {
		this.COMP_PTT_LOSS_CF_YEARS = COMP_PTT_LOSS_CF_YEARS;
	}

	public HtmlOutputLabel getCOMP_PTT_OS_CLM_RES_RATIO_LABEL() {
		return COMP_PTT_OS_CLM_RES_RATIO_LABEL;
	}

	public HtmlInputText getCOMP_PTT_OS_CLM_RES_RATIO() {
		return COMP_PTT_OS_CLM_RES_RATIO;
	}

	public void setCOMP_PTT_OS_CLM_RES_RATIO_LABEL(
			HtmlOutputLabel COMP_PTT_OS_CLM_RES_RATIO_LABEL) {
		this.COMP_PTT_OS_CLM_RES_RATIO_LABEL = COMP_PTT_OS_CLM_RES_RATIO_LABEL;
	}

	public void setCOMP_PTT_OS_CLM_RES_RATIO(
			HtmlInputText COMP_PTT_OS_CLM_RES_RATIO) {
		this.COMP_PTT_OS_CLM_RES_RATIO = COMP_PTT_OS_CLM_RES_RATIO;
	}

	public HtmlOutputLabel getCOMP_PTT_EXCLUSION_LABEL() {
		return COMP_PTT_EXCLUSION_LABEL;
	}

	public HtmlInputText getCOMP_PTT_EXCLUSION() {
		return COMP_PTT_EXCLUSION;
	}

	public void setCOMP_PTT_EXCLUSION_LABEL(
			HtmlOutputLabel COMP_PTT_EXCLUSION_LABEL) {
		this.COMP_PTT_EXCLUSION_LABEL = COMP_PTT_EXCLUSION_LABEL;
	}

	public void setCOMP_PTT_EXCLUSION(HtmlInputText COMP_PTT_EXCLUSION) {
		this.COMP_PTT_EXCLUSION = COMP_PTT_EXCLUSION;
	}

	public HtmlOutputLabel getCOMP_PTT_DEPOSIT_PREM_LABEL() {
		return COMP_PTT_DEPOSIT_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PTT_DEPOSIT_PREM() {
		return COMP_PTT_DEPOSIT_PREM;
	}

	public void setCOMP_PTT_DEPOSIT_PREM_LABEL(
			HtmlOutputLabel COMP_PTT_DEPOSIT_PREM_LABEL) {
		this.COMP_PTT_DEPOSIT_PREM_LABEL = COMP_PTT_DEPOSIT_PREM_LABEL;
	}

	public void setCOMP_PTT_DEPOSIT_PREM(HtmlInputText COMP_PTT_DEPOSIT_PREM) {
		this.COMP_PTT_DEPOSIT_PREM = COMP_PTT_DEPOSIT_PREM;
	}

	public HtmlOutputLabel getCOMP_PTT_NOTICE_CANCEL_DAYS_LABEL() {
		return COMP_PTT_NOTICE_CANCEL_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PTT_NOTICE_CANCEL_DAYS() {
		return COMP_PTT_NOTICE_CANCEL_DAYS;
	}

	public void setCOMP_PTT_NOTICE_CANCEL_DAYS_LABEL(
			HtmlOutputLabel COMP_PTT_NOTICE_CANCEL_DAYS_LABEL) {
		this.COMP_PTT_NOTICE_CANCEL_DAYS_LABEL = COMP_PTT_NOTICE_CANCEL_DAYS_LABEL;
	}

	public void setCOMP_PTT_NOTICE_CANCEL_DAYS(
			HtmlInputText COMP_PTT_NOTICE_CANCEL_DAYS) {
		this.COMP_PTT_NOTICE_CANCEL_DAYS = COMP_PTT_NOTICE_CANCEL_DAYS;
	}

	public HtmlOutputLabel getCOMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL() {
		return COMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PTT_ACCOUNTS_SUBMIT_PERIOD() {
		return COMP_PTT_ACCOUNTS_SUBMIT_PERIOD;
	}

	public void setCOMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL(
			HtmlOutputLabel COMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL) {
		this.COMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL = COMP_PTT_ACCOUNTS_SUBMIT_PERIOD_LABEL;
	}

	public void setCOMP_PTT_ACCOUNTS_SUBMIT_PERIOD(
			HtmlSelectOneMenu COMP_PTT_ACCOUNTS_SUBMIT_PERIOD) {
		this.COMP_PTT_ACCOUNTS_SUBMIT_PERIOD = COMP_PTT_ACCOUNTS_SUBMIT_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PTT_LINK_TREATY_CODE_LABEL() {
		return COMP_PTT_LINK_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTT_LINK_TREATY_CODE() {
		return COMP_PTT_LINK_TREATY_CODE;
	}

	public void setCOMP_PTT_LINK_TREATY_CODE_LABEL(
			HtmlOutputLabel COMP_PTT_LINK_TREATY_CODE_LABEL) {
		this.COMP_PTT_LINK_TREATY_CODE_LABEL = COMP_PTT_LINK_TREATY_CODE_LABEL;
	}

	public void setCOMP_PTT_LINK_TREATY_CODE(
			HtmlInputText COMP_PTT_LINK_TREATY_CODE) {
		this.COMP_PTT_LINK_TREATY_CODE = COMP_PTT_LINK_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LINK_TREATY_DESC_LABEL() {
		return COMP_UI_M_LINK_TREATY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LINK_TREATY_DESC() {
		return COMP_UI_M_LINK_TREATY_DESC;
	}

	public void setCOMP_UI_M_LINK_TREATY_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_LINK_TREATY_DESC_LABEL) {
		this.COMP_UI_M_LINK_TREATY_DESC_LABEL = COMP_UI_M_LINK_TREATY_DESC_LABEL;
	}

	public void setCOMP_UI_M_LINK_TREATY_DESC(
			HtmlInputText COMP_UI_M_LINK_TREATY_DESC) {
		this.COMP_UI_M_LINK_TREATY_DESC = COMP_UI_M_LINK_TREATY_DESC;
	}

	public HtmlOutputLabel getCOMP_PTT_NET_SURPLUS_AMT_LABEL() {
		return COMP_PTT_NET_SURPLUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PTT_NET_SURPLUS_AMT() {
		return COMP_PTT_NET_SURPLUS_AMT;
	}

	public void setCOMP_PTT_NET_SURPLUS_AMT_LABEL(
			HtmlOutputLabel COMP_PTT_NET_SURPLUS_AMT_LABEL) {
		this.COMP_PTT_NET_SURPLUS_AMT_LABEL = COMP_PTT_NET_SURPLUS_AMT_LABEL;
	}

	public void setCOMP_PTT_NET_SURPLUS_AMT(
			HtmlInputText COMP_PTT_NET_SURPLUS_AMT) {
		this.COMP_PTT_NET_SURPLUS_AMT = COMP_PTT_NET_SURPLUS_AMT;
	}

	public HtmlOutputLabel getCOMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL() {
		return COMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PTT_ACCOUNTS_CLOSE_PERIOD() {
		return COMP_PTT_ACCOUNTS_CLOSE_PERIOD;
	}

	public void setCOMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL(
			HtmlOutputLabel COMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL) {
		this.COMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL = COMP_PTT_ACCOUNTS_CLOSE_PERIOD_LABEL;
	}

	public void setCOMP_PTT_ACCOUNTS_CLOSE_PERIOD(
			HtmlSelectOneMenu COMP_PTT_ACCOUNTS_CLOSE_PERIOD) {
		this.COMP_PTT_ACCOUNTS_CLOSE_PERIOD = COMP_PTT_ACCOUNTS_CLOSE_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PTT_PREM_PF_ENT_PERC_LABEL() {
		return COMP_PTT_PREM_PF_ENT_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTT_PREM_PF_ENT_PERC() {
		return COMP_PTT_PREM_PF_ENT_PERC;
	}

	public void setCOMP_PTT_PREM_PF_ENT_PERC_LABEL(
			HtmlOutputLabel COMP_PTT_PREM_PF_ENT_PERC_LABEL) {
		this.COMP_PTT_PREM_PF_ENT_PERC_LABEL = COMP_PTT_PREM_PF_ENT_PERC_LABEL;
	}

	public void setCOMP_PTT_PREM_PF_ENT_PERC(
			HtmlInputText COMP_PTT_PREM_PF_ENT_PERC) {
		this.COMP_PTT_PREM_PF_ENT_PERC = COMP_PTT_PREM_PF_ENT_PERC;
	}

	public HtmlOutputLabel getCOMP_PTT_PREM_PF_WD_PERC_LABEL() {
		return COMP_PTT_PREM_PF_WD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTT_PREM_PF_WD_PERC() {
		return COMP_PTT_PREM_PF_WD_PERC;
	}

	public void setCOMP_PTT_PREM_PF_WD_PERC_LABEL(
			HtmlOutputLabel COMP_PTT_PREM_PF_WD_PERC_LABEL) {
		this.COMP_PTT_PREM_PF_WD_PERC_LABEL = COMP_PTT_PREM_PF_WD_PERC_LABEL;
	}

	public void setCOMP_PTT_PREM_PF_WD_PERC(
			HtmlInputText COMP_PTT_PREM_PF_WD_PERC) {
		this.COMP_PTT_PREM_PF_WD_PERC = COMP_PTT_PREM_PF_WD_PERC;
	}

	public HtmlOutputLabel getCOMP_PTT_LOSS_PF_ENT_PERC_LABEL() {
		return COMP_PTT_LOSS_PF_ENT_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTT_LOSS_PF_ENT_PERC() {
		return COMP_PTT_LOSS_PF_ENT_PERC;
	}

	public void setCOMP_PTT_LOSS_PF_ENT_PERC_LABEL(
			HtmlOutputLabel COMP_PTT_LOSS_PF_ENT_PERC_LABEL) {
		this.COMP_PTT_LOSS_PF_ENT_PERC_LABEL = COMP_PTT_LOSS_PF_ENT_PERC_LABEL;
	}

	public void setCOMP_PTT_LOSS_PF_ENT_PERC(
			HtmlInputText COMP_PTT_LOSS_PF_ENT_PERC) {
		this.COMP_PTT_LOSS_PF_ENT_PERC = COMP_PTT_LOSS_PF_ENT_PERC;
	}

	public HtmlOutputLabel getCOMP_PTT_LOSS_PF_WD_PERC_LABEL() {
		return COMP_PTT_LOSS_PF_WD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTT_LOSS_PF_WD_PERC() {
		return COMP_PTT_LOSS_PF_WD_PERC;
	}

	public void setCOMP_PTT_LOSS_PF_WD_PERC_LABEL(
			HtmlOutputLabel COMP_PTT_LOSS_PF_WD_PERC_LABEL) {
		this.COMP_PTT_LOSS_PF_WD_PERC_LABEL = COMP_PTT_LOSS_PF_WD_PERC_LABEL;
	}

	public void setCOMP_PTT_LOSS_PF_WD_PERC(
			HtmlInputText COMP_PTT_LOSS_PF_WD_PERC) {
		this.COMP_PTT_LOSS_PF_WD_PERC = COMP_PTT_LOSS_PF_WD_PERC;
	}

	public PM_IL_PROP_TREATY_TYPE getPM_IL_PROP_TREATY_TYPE_BEAN() {
		return PM_IL_PROP_TREATY_TYPE_BEAN;
	}

	public void setPM_IL_PROP_TREATY_TYPE_BEAN(
			PM_IL_PROP_TREATY_TYPE PM_IL_PROP_TREATY_TYPE_BEAN) {
		this.PM_IL_PROP_TREATY_TYPE_BEAN = PM_IL_PROP_TREATY_TYPE_BEAN;
	}

	public List<SelectItem> getAccSubList() {
		return accSubList;
	}

	public void setAccSubList(List<SelectItem> accSubList) {
		this.accSubList = accSubList;
	}

	public List<SelectItem> getAccCloseList() {
		return accCloseList;
	}

	public void setAccCloseList(List<SelectItem> accCloseList) {
		this.accCloseList = accCloseList;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}

	public List getTreatyCodeList() {
		return treatyCodeList;
	}

	public void setTreatyCodeList(List treatyCodeList) {
		this.treatyCodeList = treatyCodeList;
	}

	public List getTreatyLinkCodeList() {
		return treatyLinkCodeList;
	}

	public void setTreatyLinkCodeList(List treatyLinkCodeList) {
		this.treatyLinkCodeList = treatyLinkCodeList;
	}

	// [ Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	private boolean onLoadFlag = false;
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event){
		try {
			if(!isOnLoadFlag()){
				new PM_IL_PROP_TREATY_TYPE_HELPER().companyDetailsCheck(compositeAction);
				setOnLoadFlag(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){	
				double listSize = dataTableList.size();
				this.PM_IL_PROP_TREATY_TYPE_BEAN = new PM_IL_PROP_TREATY_TYPE();
				PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_SRNO(++listSize);
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
	public void post(ActionEvent ae) {
		try{
			if(PM_IL_PROP_TREATY_TYPE_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					pm_il_prop_treaty_delegate.updateForTreatyType(this.PM_IL_PROP_TREATY_TYPE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_TYPE_BEAN, commonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					Double PTT_SYS_ID = pm_il_prop_treaty_helper.getSysIdForTreatyType();
					this.PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_SYS_ID(PTT_SYS_ID);
					//PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_SYS_ID(PTT_SYS_ID);
					PM_IL_PROP_TREATY_ACTION typeAction = compositeAction.getPM_IL_PROP_TREATY_ACTION();
					PM_IL_PROP_TREATY typeValue = typeAction.getPM_IL_PROP_TREATY_BEAN();
					Double PT_SYS_ID = typeValue.getPT_SYS_ID();
					this.PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_PT_SYS_ID(PT_SYS_ID);
					if (PM_IL_PROP_TREATY_TYPE_BEAN.isFreeze()) {
						this.PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_FRZ_FLAG("Y");
					} else {
						this.PM_IL_PROP_TREATY_TYPE_BEAN.setPTT_FRZ_FLAG("N");
					}
					
					pm_il_prop_treaty_delegate.insertValues(this);
					new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_TYPE_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataTableList.add(PM_IL_PROP_TREATY_TYPE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TREATY_TYPE_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_PROP_TREATY_TYPE_BEAN = (PM_IL_PROP_TREATY_TYPE) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROP_TREATY_TYPE_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PTT_SRNO.resetValue();
		COMP_PTT_TREATY_TYPE.resetValue();
		COMP_UI_M_TREATY_DESC.resetValue();
		COMP_PTT_PROFIT_COMM.resetValue();
		COMP_PTT_MGT_EXP_RATIO.resetValue();
		COMP_PTT_REINS_TAX_PERC.resetValue();
		COMP_PTT_INT_ON_RES_REL.resetValue();
		COMP_PTT_PREM_RES_RATIO.resetValue();
		COMP_PTT_LOSS_CF_YEARS.resetValue();
		COMP_PTT_OS_CLM_RES_RATIO.resetValue();
		COMP_PTT_EXCLUSION.resetValue();
		COMP_PTT_DEPOSIT_PREM.resetValue();
		COMP_PTT_NOTICE_CANCEL_DAYS.resetValue();
		COMP_PTT_ACCOUNTS_SUBMIT_PERIOD.resetValue();
		COMP_PTT_LINK_TREATY_CODE.resetValue();
		COMP_UI_M_LINK_TREATY_DESC.resetValue();
		COMP_PTT_NET_SURPLUS_AMT.resetValue();
		COMP_PTT_ACCOUNTS_CLOSE_PERIOD.resetValue();
		COMP_PTT_PREM_PF_ENT_PERC.resetValue();
		COMP_PTT_PREM_PF_WD_PERC.resetValue();
		COMP_PTT_LOSS_PF_ENT_PERC.resetValue();
		COMP_PTT_LOSS_PF_WD_PERC.resetValue();
		COMP_PTT_FRZ_FLAG.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TREATY_TYPE> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public String getFilterByPTT_TREATY_TYPE() {
		return filterByPTT_TREATY_TYPE;
	}

	public void setFilterByPTT_TREATY_TYPE(String filterByPTT_TREATY_TYPE) {
		this.filterByPTT_TREATY_TYPE = filterByPTT_TREATY_TYPE;
	}

	public String getFilterByPTT_PROFIT_COMM() {
		return filterByPTT_PROFIT_COMM;
	}

	public void setFilterByPTT_PROFIT_COMM(String filterByPTT_PROFIT_COMM) {
		this.filterByPTT_PROFIT_COMM = filterByPTT_PROFIT_COMM;
	}

	/*public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}*/
}

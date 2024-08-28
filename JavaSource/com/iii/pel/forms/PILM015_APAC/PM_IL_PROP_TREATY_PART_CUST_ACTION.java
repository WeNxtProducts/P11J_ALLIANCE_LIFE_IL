package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_FUNERAL_MEMB_DTLS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_PART_CUST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTPC_CUST_CODE_LABEL;

	private HtmlInputText COMP_PTPC_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_COMP_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COMP_DESC;

	private HtmlOutputLabel COMP_PTPC_SHARE_PERC_LABEL;

	private HtmlInputText COMP_PTPC_SHARE_PERC;

	private HtmlOutputLabel COMP_PTPC_LEADER_YN_LABEL;

	private HtmlSelectOneMenu COMP_PTPC_LEADER_YN;

	private PM_IL_PROP_TREATY_PART_CUST PM_IL_PROP_TREATY_PART_CUST_BEAN;

	private UIData dataTable;

	private ArrayList<PM_IL_PROP_TREATY_PART_CUST> dataTableList;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private int currPage;

	private int recordsPerPage = 5;

	ArrayList deletedIndexList;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	List resultList;

	private List<SelectItem> leaderYN;

	PM_IL_PROP_TREATY_DELEGATE delegate;

	private List customerCodeList;

	private boolean ENABLED = true;

	private PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean;
	
	///filters
	private String filterByPTPC_CUST_CODE;
	private String filterByPTPC_SHARE_PERC;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private CommonUtils commonUtils;
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;
	
	private PM_IL_PROP_TREATY_HELPER helper;
	

	public PM_IL_PROP_TREATY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_PROP_TREATY_HELPER helper) {
		this.helper = helper;
	}

	public PM_IL_PROP_TREATY_TYPE getTempTreaty_TypeBean() {
		return tempTreaty_TypeBean;
	}

	public void setTempTreaty_TypeBean(
			PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean) {
		this.tempTreaty_TypeBean = tempTreaty_TypeBean;
	}
	public 
	//added by krithika
	PM_IL_PROP_TREATY_COVER_ACTION PM_IL_PROP_TREATY_COVER_ACTION_BEAN;
	
	public PM_IL_PROP_TREATY_COVER_ACTION getPM_IL_PROP_TREATY_COVER_ACTION_BEAN() {
		return PM_IL_PROP_TREATY_COVER_ACTION_BEAN;
	}

	public void setPM_IL_PROP_TREATY_COVER_ACTION_BEAN(
			PM_IL_PROP_TREATY_COVER_ACTION pM_IL_PROP_TREATY_COVER_ACTION_BEAN) {
		PM_IL_PROP_TREATY_COVER_ACTION_BEAN = pM_IL_PROP_TREATY_COVER_ACTION_BEAN;
	}
	private PM_IL_PROP_TREATY_COVER PM_IL_PROP_TREATY_COVER_BEAN;
public PM_IL_PROP_TREATY_COVER getPM_IL_PROP_TREATY_COVER_BEAN() {
		return PM_IL_PROP_TREATY_COVER_BEAN;
	}

	public void setPM_IL_PROP_TREATY_COVER_BEAN(
			PM_IL_PROP_TREATY_COVER pM_IL_PROP_TREATY_COVER_BEAN) {
		PM_IL_PROP_TREATY_COVER_BEAN = pM_IL_PROP_TREATY_COVER_BEAN;
	}

	//end
	public PM_IL_PROP_TREATY_PART_CUST_ACTION() {
		
		commonUtils = new CommonUtils();
		helper = new PM_IL_PROP_TREATY_HELPER();
		PM_IL_PROP_TREATY_PART_CUST_BEAN = new PM_IL_PROP_TREATY_PART_CUST();
		PM_IL_PROP_TREATY_COVER_ACTION_BEAN=new PM_IL_PROP_TREATY_COVER_ACTION();
		delegate = new PM_IL_PROP_TREATY_DELEGATE();
		COMP_PTPC_CUST_CODE=new HtmlInputText();
		COMP_PTPC_LEADER_YN=new HtmlSelectOneMenu();
		COMP_PTPC_SHARE_PERC=new HtmlInputText();
		COMP_UI_M_COMP_DESC=new HtmlInputText();
		List<SelectItem> itemListleadYN;
		deletedIndexList = new ArrayList();
		dataTableList = new ArrayList<PM_IL_PROP_TREATY_PART_CUST>();
		delegate = new PM_IL_PROP_TREATY_DELEGATE();
		prevRowIndex = 0;
		currPage = 1;
		
		dataList_PM_IL_PROP_TREATY_CUST_COMM=new ArrayList<PM_IL_PROP_TREATY_CUST_COMM>();
		
		PM_IL_PROP_TREATY_CUST_COMM_BEAN=new PM_IL_PROP_TREATY_CUST_COMM();
		try {
			itemListleadYN = delegate
					.getListTreatyCust(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_TREATY_PART_CUST_PTPC_LEADER_YN,
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_TREATY_PART_CUST_PTPC_LEADER_YN_SYS_PARAM);
			setLeaderYN(itemListleadYN);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PTPC_CUST_CODE_LABEL() {
		return COMP_PTPC_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTPC_CUST_CODE() {
		return COMP_PTPC_CUST_CODE;
	}

	public void setCOMP_PTPC_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_PTPC_CUST_CODE_LABEL) {
		this.COMP_PTPC_CUST_CODE_LABEL = COMP_PTPC_CUST_CODE_LABEL;
	}

	public void setCOMP_PTPC_CUST_CODE(HtmlInputText COMP_PTPC_CUST_CODE) {
		this.COMP_PTPC_CUST_CODE = COMP_PTPC_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COMP_DESC_LABEL() {
		return COMP_UI_M_COMP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COMP_DESC() {
		return COMP_UI_M_COMP_DESC;
	}

	public void setCOMP_UI_M_COMP_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COMP_DESC_LABEL) {
		this.COMP_UI_M_COMP_DESC_LABEL = COMP_UI_M_COMP_DESC_LABEL;
	}

	public void setCOMP_UI_M_COMP_DESC(HtmlInputText COMP_UI_M_COMP_DESC) {
		this.COMP_UI_M_COMP_DESC = COMP_UI_M_COMP_DESC;
	}

	public HtmlOutputLabel getCOMP_PTPC_SHARE_PERC_LABEL() {
		return COMP_PTPC_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTPC_SHARE_PERC() {
		return COMP_PTPC_SHARE_PERC;
	}

	public void setCOMP_PTPC_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_PTPC_SHARE_PERC_LABEL) {
		this.COMP_PTPC_SHARE_PERC_LABEL = COMP_PTPC_SHARE_PERC_LABEL;
	}

	public void setCOMP_PTPC_SHARE_PERC(HtmlInputText COMP_PTPC_SHARE_PERC) {
		this.COMP_PTPC_SHARE_PERC = COMP_PTPC_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_PTPC_LEADER_YN_LABEL() {
		return COMP_PTPC_LEADER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PTPC_LEADER_YN() {
		return COMP_PTPC_LEADER_YN;
	}

	public void setCOMP_PTPC_LEADER_YN_LABEL(
			HtmlOutputLabel COMP_PTPC_LEADER_YN_LABEL) {
		this.COMP_PTPC_LEADER_YN_LABEL = COMP_PTPC_LEADER_YN_LABEL;
	}

	public void setCOMP_PTPC_LEADER_YN(HtmlSelectOneMenu COMP_PTPC_LEADER_YN) {
		this.COMP_PTPC_LEADER_YN = COMP_PTPC_LEADER_YN;
	}

	public PM_IL_PROP_TREATY_PART_CUST getPM_IL_PROP_TREATY_PART_CUST_BEAN() {
		return PM_IL_PROP_TREATY_PART_CUST_BEAN;
	}

	public void setPM_IL_PROP_TREATY_PART_CUST_BEAN(
			PM_IL_PROP_TREATY_PART_CUST PM_IL_PROP_TREATY_PART_CUST_BEAN) {
		this.PM_IL_PROP_TREATY_PART_CUST_BEAN = PM_IL_PROP_TREATY_PART_CUST_BEAN;
	}

	/**
	 * Back To Treaty Type Jsp
	 * 
	 * @return
	 */
	public String backtoTreatyType() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();

		return "TreatyType";
	}

	/*public void addRow(ActionEvent event) {
		dataTableList.add(new PM_IL_PROP_TREATY_PART_CUST());
	}

	public String addNew() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_PROP_TREATY_PART_CUST>();
		}
		dataTableList.add(new PM_IL_PROP_TREATY_PART_CUST());
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) (commonUtils
				.getMappedBeanFromSession("PM_IL_PROP_TREATY_COMPOSITE_ACTION"));
		PM_IL_PROP_TREATY_PART_CUST_HELPER partCustHelper = new PM_IL_PROP_TREATY_PART_CUST_HELPER();
		partCustHelper
				.pilm015_apac_pm_il_prop_treaty_part_cust__when_create_record(compositeAction);// WHEN-CREATE-RECORD
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return "newadded";
	}*/
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){	
				PM_IL_PROP_TREATY_PART_CUST_BEAN = new PM_IL_PROP_TREATY_PART_CUST();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_PROP_TREATY_PART_CUST_BEAN.setRowSelected(true);
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
			if(PM_IL_PROP_TREATY_PART_CUST_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					//delegate.updateDataForCustomer(this.PM_IL_PROP_TREATY_PART_CUST_BEAN);
					PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_UPD_DT(new CommonUtils().getCurrentDate());
					L_VAL_CUST_LEADER(PM_IL_PROP_TREATY_PART_CUST_BEAN);
					//ADDED BY SARANYA ON  17-01-2016
					new CRUDHandler().executeUpdate(PM_IL_PROP_TREATY_PART_CUST_BEAN, commonUtils.getConnection());
					//END
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					CommonUtils.getConnection().commit();
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {
				if(isINSERT_ALLOWED()) {
					Connection connection = null;
					connection = CommonUtils.getConnection();
					System.out.println("inside the insert post");
					/*PM_IL_PROP_TREATY_TYPE_ACTION typeAction1 = compositeAction
							.getPM_IL_PROP_TREATY_TYPE_ACTION();
					PM_IL_PROP_TREATY_TYPE typeValueBean1 = typeAction1
							.getPM_IL_PROP_TREATY_TYPE_BEAN();*/
					
					
					PM_IL_PROP_TREATY_COVER_ACTION typeAction = compositeAction
							.getPM_IL_PROP_TREATY_COVER_ACTION();
					PM_IL_PROP_TREATY_COVER typeValueBean = typeAction
							.getPM_IL_PROP_TREATY_COVER_BEAN();
					Double sysid = typeValueBean.getPTC_SYS_ID();
					Double ptt_sysid =  typeValueBean.getPTC_PTT_SYS_ID();
					System.out.println("value of sysid in post method "+sysid);
				
					this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_PTT_SYS_ID(ptt_sysid);
					this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_PTC_SYS_ID(sysid);
					this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_CR_DT(commonUtils.getCurrentDate());
					this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_SYS_ID(helper
							.pilm015_apac_pm_il_prop_treaty_part_cust_pre_insert());
					//delegate.updateDataForCustomer(this.PM_IL_PROP_TREATY_PART_CUST_BEAN);
					L_VAL_CUST_LEADER(PM_IL_PROP_TREATY_PART_CUST_BEAN);
					int testcount=new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_PART_CUST_BEAN, connection);
					connection.commit();
					System.out.println("query exeuted in post"+testcount);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataTableList.add(PM_IL_PROP_TREATY_PART_CUST_BEAN);
					
				
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TREATY_PART_CUST_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/*public String deleteRow() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_PROP_TREATY_PART_CUST bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if (bean.isCHECK_BOX()) {
					dataTableList.remove(bean);
					deletedRecordIndex = delegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Records Deleted");
			}
			lastUpdatedRowIndex = -1;

		}
		return "";
	}*/

	public String deleteRow(ActionEvent ae) {
		try{
			if(getErrorMap().containsKey("current") || getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_PROP_TREATY_PART_CUST bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;
			
			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_PROP_TREATY_PART_CUST)dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);
	
					} else {
						index++;
					}
				}
				if(dataTableList.size() > 0) {
						setPM_IL_PROP_TREATY_PART_CUST_BEAN(dataTableList.get(0));
						PM_IL_PROP_TREATY_PART_CUST_BEAN.setRowSelected(true);
				} else {
					addNew(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");
	
				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TREATY_PART_CUST_BEAN.setRowSelected(true);
		}catch(Exception exception){
		}
		return "";
	}
	
	
	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_PART_CUST gridValueBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						// Get the bean based on row index
						gridValueBean = (PM_IL_PROP_TREATY_PART_CUST) dataTableList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							Map sessionMap = FacesContext.getCurrentInstance()
									.getExternalContext().getSessionMap();
							PM_IL_PROP_TREATY_COMPOSITE_ACTION compAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) sessionMap
									.get("PM_IL_PROP_TREATY_COMPOSITE_ACTION");

							PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compAction
									.getPM_IL_PROP_TREATY_TYPE_ACTION();
							PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
									.getPM_IL_PROP_TREATY_TYPE_BEAN();
							Double sysid = typeValueBean.getPTT_SYS_ID();
							String rowId = gridValueBean.getROWID();
							String leader = gridValueBean.getPTPC_LEADER_YN();
							rowUpdated = delegate
									.updateDataForCustomer(gridValueBean);
							getWarningMap().put("current", "Records Updated");
						} else {
							Map sessionMap = FacesContext.getCurrentInstance()
									.getExternalContext().getSessionMap();
							PM_IL_PROP_TREATY_COMPOSITE_ACTION compAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) sessionMap
									.get("PM_IL_PROP_TREATY_COMPOSITE_ACTION");

							PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compAction
									.getPM_IL_PROP_TREATY_TYPE_ACTION();
							PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
									.getPM_IL_PROP_TREATY_TYPE_BEAN();
							Double sysid = typeValueBean.getPTT_SYS_ID();
							String rowId = gridValueBean.getROWID();
							String leader = gridValueBean.getPTPC_LEADER_YN();
							rowUpdated = delegate
									.updateDataForCustomer(gridValueBean);
							getWarningMap().put("current", "Records Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

	public void lastColumnListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_PART_CUST gridValueBean = null;
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		try {
			gridValueBean = (PM_IL_PROP_TREATY_PART_CUST) dataTableList
					.get(currRowIndex);
			CommonUtils commonUtils = new CommonUtils();
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setPTPC_UPD_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTPC_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				/*PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_TYPE_ACTION();
				PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_TYPE_BEAN();*/
				PM_IL_PROP_TREATY_COVER_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_COVER_ACTION();
				PM_IL_PROP_TREATY_COVER typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_COVER_BEAN();
				Double sysid = typeValueBean.getPTC_SYS_ID();
				
				String rowId = gridValueBean.getROWID();
				String leader = gridValueBean.getPTPC_LEADER_YN();
				rowUpdated = delegate.updateDataForCustomer(gridValueBean);
				getWarningMap().put("current", "Records Updated");
			} else {
				/*PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_TYPE_ACTION();
				PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_TYPE_BEAN();*/
				PM_IL_PROP_TREATY_COVER_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_COVER_ACTION();
				PM_IL_PROP_TREATY_COVER typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_COVER_BEAN();
				Double sysid = typeValueBean.getPTC_SYS_ID();
				gridValueBean.setPTPC_PTT_SYS_ID(sysid);
				gridValueBean.setPTPC_CR_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTPC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				gridValueBean.setPTPC_SYS_ID(helper
						.pilm015_apac_pm_il_prop_treaty_part_cust_pre_insert());
				String rowId = gridValueBean.getROWID();
				String leader = gridValueBean.getPTPC_LEADER_YN();
				rowUpdated = delegate.updateDataForCustomer(gridValueBean);
				getWarningMap().put("current", "Records Inserted");
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void custCodeWhenValidate(FacesContext facesContext,
			UIComponent component, Object value)  {
		int errorCode = 0;
		try {
			if (COMP_PTPC_CUST_CODE.getSubmittedValue() != null) {
				String code = (String) COMP_PTPC_CUST_CODE.getSubmittedValue();
				System.out.println("value of custcode in company master "+code);
				System.out.println("value of user "+value);
				PM_IL_PROP_TREATY_PART_CUST_HELPER custmerHelper = new PM_IL_PROP_TREATY_PART_CUST_HELPER();
				PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = this.PM_IL_PROP_TREATY_PART_CUST_BEAN;
				pm_il_prop_treaty_part_cust.setPTPC_CUST_CODE((String) value);
				
				custmerHelper.L_VAL_CUST_UNIQUE(compositeAction, code, pm_il_prop_treaty_part_cust);
					custmerHelper.cusCodeWhenValidate(code,pm_il_prop_treaty_part_cust);
			}
		}catch (SQLException sql) {
				errorCode = sql.getErrorCode();
				throw new ValidatorException(new FacesMessage(sql.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
				if (errorCode == 20100) {
					try {
						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), facesContext, component
								.getClientId(facesContext), getWarningMap());
					} catch (DBException e) {
						e.printStackTrace();
					}
				}

			}

		}

	
	public void customerCodeDescValidation(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_UI_M_COMP_DESC.getSubmittedValue() != null) {
			String codeDesc = (String) COMP_UI_M_COMP_DESC.getSubmittedValue();
			this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setUI_M_COMP_DESC(codeDesc);
		}

	}
	
	public void validationPercentShare(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
		PM_IL_PROP_TREATY_PART_CUST_HELPER partCustHelper = new PM_IL_PROP_TREATY_PART_CUST_HELPER();
		partCustHelper.percentageShareWhenValidate(PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_SHARE_PERC(), 
						dataTableList);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void percentShareValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		String coverCodeValue = getCurrentValue(actionEvent);
		if (!coverCodeValue.trim().isEmpty() && coverCodeValue != null) {
			this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_SHARE_PERC(
					Double.parseDouble(coverCodeValue));
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void leadYNValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		//lastColumnListener();
	}
	
	public void leadYNValidation(FacesContext facesContext,
			UIComponent component, Object value){
		try {
			if (COMP_PTPC_LEADER_YN.getSubmittedValue() != null) {
				String leader = (String) COMP_PTPC_LEADER_YN.getSubmittedValue();
				String rowId = PM_IL_PROP_TREATY_PART_CUST_BEAN.getROWID();
				PM_IL_PROP_TREATY_PART_CUST_HELPER partCustHelper = new PM_IL_PROP_TREATY_PART_CUST_HELPER();
				partCustHelper.L_VAL_CUST_LEADER(compositeAction, leader, rowId);
				this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_LEADER_YN(leader);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	public void saveData() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		
		try {
			Connection connection = null;
			connection = CommonUtils.getConnection();
			connection.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Saved");
			getWarningMap().put("CURRENT", "Record Saved");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
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
		PM_IL_PROP_TREATY_PART_CUST custBean = dataTableList.get(row);
		if (selected.equals("true"))
			custBean.setCHECK_BOX(true);
		else
			custBean.setCHECK_BOX(false);
	}

	public ArrayList<PM_IL_PROP_TREATY_PART_CUST> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(
			ArrayList<PM_IL_PROP_TREATY_PART_CUST> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public List<SelectItem> getLeaderYN() {
		return leaderYN;
	}

	public void setLeaderYN(List<SelectItem> leaderYN) {
		this.leaderYN = leaderYN;
	}

	public List suggestionActionCustCode(Object object) {
		String customerCode = (String) object;
		try {
			customerCodeList = new PM_IL_PROP_TREATY_HELPER().prepareCustCodeList(
					customerCode, customerCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return customerCodeList;
	}

	/**
	 * 
	 * @param event
	 */
	public void getCustCodeDesc(ActionEvent actionEvent) {
		COMP_UI_M_COMP_DESC.setSubmittedValue(null);
		if (COMP_PTPC_CUST_CODE.getSubmittedValue() != null) {
			String custCode = (String) COMP_PTPC_CUST_CODE.getSubmittedValue();
			String custCodeDesc = new PM_IL_PROP_TREATY_HELPER().getCustDescforCode(custCode, customerCodeList);
			this.PM_IL_PROP_TREATY_PART_CUST_BEAN.setUI_M_COMP_DESC(custCodeDesc);
		}
	}

	public List getCustomerCodeList() {
		return customerCodeList;
	}

	public void setCustomerCodeList(List customerCodeList) {
		this.customerCodeList = customerCodeList;
	}

	public boolean isENABLED() {
		return ENABLED;
	}

	public void setENABLED(boolean enabled) {
		ENABLED = enabled;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
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
			getErrorMap().put("CURRENT", exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	public void getDetails() {
		try {
			resetSelectedRow();
			if (dataTableList.size() != 0) {				
				PM_IL_PROP_TREATY_PART_CUST_BEAN = (PM_IL_PROP_TREATY_PART_CUST) dataTable.getRowData();
			}	
			
			resetAllComponent();			
			
			PM_IL_PROP_TREATY_PART_CUST_BEAN.setRowSelected(true);	
			helper.getRateDetails(this);
			resetAllComponent_rate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PTPC_CUST_CODE.resetValue();
		COMP_PTPC_LEADER_YN.resetValue();
		COMP_PTPC_SHARE_PERC.resetValue();
		COMP_UI_M_COMP_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TREATY_PART_CUST> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}


	public String getFilterByPTPC_CUST_CODE() {
		return filterByPTPC_CUST_CODE;
	}

	public void setFilterByPTPC_CUST_CODE(String filterByPTPC_CUST_CODE) {
		this.filterByPTPC_CUST_CODE = filterByPTPC_CUST_CODE;
	}

	public String getFilterByPTPC_SHARE_PERC() {
		return filterByPTPC_SHARE_PERC;
	}

	public void setFilterByPTPC_SHARE_PERC(String filterByPTPC_SHARE_PERC) {
		this.filterByPTPC_SHARE_PERC = filterByPTPC_SHARE_PERC;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
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
	}
	
	
	public void  L_VAL_CUST_LEADER(PM_IL_PROP_TREATY_PART_CUST PM_IL_PROP_TREATY_PART_CUST_BEAN) 
		throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = null;
		String M_FLAG = null;
		Double pol_sys_id=PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_PTT_SYS_ID();
		System.out.println("valus of pol_sys_id in L_VAL_CUST_LEADER"+pol_sys_id);
		String C1 = " SELECT PTPC_LEADER_YN FROM PM_IL_PROP_TREATY_PART_CUST " +
				" WHERE  PTPC_LEADER_YN  = 'Y'  AND  PTPC_PTT_SYS_ID = ? " ; 
		
		String C2 = "SELECT PTPC_LEADER_YN FROM PM_IL_PROP_TREATY_PART_CUST WHERE  PTPC_LEADER_YN  = 'Y' " +
				" AND    PTPC_PTT_SYS_ID = ?  AND    ROWID != ? ";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_LEADER_YN().equals("Y")){
				if(PM_IL_PROP_TREATY_PART_CUST_BEAN.getROWID()!= null){
					resultSet1 = handler.executeSelectStatement(C2, connection, 
							new Object[]{PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_PTT_SYS_ID(),
											PM_IL_PROP_TREATY_PART_CUST_BEAN.getROWID()});
					if(resultSet1.next()){
						M_FLAG = resultSet1.getString(1);
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71136"));
					}
				}else{
					resultSet = handler.executeSelectStatement(C1, connection, 
							new Object[]{
										PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_PTT_SYS_ID()});
			if(resultSet.next()){
				M_FLAG = resultSet.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71136"));
			}
					
				}
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch (Exception e) {}
			try{CommonUtils.closeCursor(resultSet1);}catch (Exception e) {}
		}
	}
	
	
	public void preInsert() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 = "SELECT PIL_PTPC_SYS_ID.NEXTVAL FROM DUAL ";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection);
			if(resultSet.next()){
				PM_IL_PROP_TREATY_PART_CUST_BEAN.setPTPC_SYS_ID(resultSet.getDouble(1));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/*added by raja on 04-07-2017*/
	
	private PM_IL_PROP_TREATY_CUST_COMM PM_IL_PROP_TREATY_CUST_COMM_BEAN;
	
	private UIData dataTable_rate;

	private ArrayList<PM_IL_PROP_TREATY_CUST_COMM> dataList_PM_IL_PROP_TREATY_CUST_COMM;
	
	
	
	public UIData getDataTable_rate() {
		return dataTable_rate;
	}

	public void setDataTable_rate(UIData dataTable_rate) {
		this.dataTable_rate = dataTable_rate;
	}

	public ArrayList<PM_IL_PROP_TREATY_CUST_COMM> getDataList_PM_IL_PROP_TREATY_CUST_COMM() {
		return dataList_PM_IL_PROP_TREATY_CUST_COMM;
	}

	public void setDataList_PM_IL_PROP_TREATY_CUST_COMM(
			ArrayList<PM_IL_PROP_TREATY_CUST_COMM> dataList_PM_IL_PROP_TREATY_CUST_COMM) {
		this.dataList_PM_IL_PROP_TREATY_CUST_COMM = dataList_PM_IL_PROP_TREATY_CUST_COMM;
	}

	public PM_IL_PROP_TREATY_CUST_COMM getPM_IL_PROP_TREATY_CUST_COMM_BEAN() {
		return PM_IL_PROP_TREATY_CUST_COMM_BEAN;
	}

	public void setPM_IL_PROP_TREATY_CUST_COMM_BEAN(
			PM_IL_PROP_TREATY_CUST_COMM pM_IL_PROP_TREATY_CUST_COMM_BEAN) {
		PM_IL_PROP_TREATY_CUST_COMM_BEAN = pM_IL_PROP_TREATY_CUST_COMM_BEAN;
	}
	
	private HtmlOutputLabel COMP_PTCC_YEAR_FM_LABEL;
	private HtmlInputText COMP_PTCC_YEAR_FM;
	
	private HtmlOutputLabel COMP_PTCC_YEAR_TO_LABEL;
	private HtmlInputText COMP_PTCC_YEAR_TO;
	
	private HtmlOutputLabel COMP_PTCC_STD_PERC_LABEL;
	private HtmlInputText COMP_PTCC_STD_PERC;
	private HtmlOutputLabel COMP_PTCC_SSTD_PERC_LABEL;
	private HtmlInputText COMP_PTCC_SSTD_PERC;



	public HtmlOutputLabel getCOMP_PTCC_YEAR_FM_LABEL() {
		return COMP_PTCC_YEAR_FM_LABEL;
	}

	public void setCOMP_PTCC_YEAR_FM_LABEL(HtmlOutputLabel cOMP_PTCC_YEAR_FM_LABEL) {
		COMP_PTCC_YEAR_FM_LABEL = cOMP_PTCC_YEAR_FM_LABEL;
	}

	public HtmlInputText getCOMP_PTCC_YEAR_FM() {
		return COMP_PTCC_YEAR_FM;
	}

	public void setCOMP_PTCC_YEAR_FM(HtmlInputText cOMP_PTCC_YEAR_FM) {
		COMP_PTCC_YEAR_FM = cOMP_PTCC_YEAR_FM;
	}

	public HtmlOutputLabel getCOMP_PTCC_YEAR_TO_LABEL() {
		return COMP_PTCC_YEAR_TO_LABEL;
	}

	public void setCOMP_PTCC_YEAR_TO_LABEL(HtmlOutputLabel cOMP_PTCC_YEAR_TO_LABEL) {
		COMP_PTCC_YEAR_TO_LABEL = cOMP_PTCC_YEAR_TO_LABEL;
	}

	public HtmlInputText getCOMP_PTCC_YEAR_TO() {
		return COMP_PTCC_YEAR_TO;
	}

	public void setCOMP_PTCC_YEAR_TO(HtmlInputText cOMP_PTCC_YEAR_TO) {
		COMP_PTCC_YEAR_TO = cOMP_PTCC_YEAR_TO;
	}

	public HtmlOutputLabel getCOMP_PTCC_STD_PERC_LABEL() {
		return COMP_PTCC_STD_PERC_LABEL;
	}

	public void setCOMP_PTCC_STD_PERC_LABEL(HtmlOutputLabel cOMP_PTCC_STD_PERC_LABEL) {
		COMP_PTCC_STD_PERC_LABEL = cOMP_PTCC_STD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTCC_STD_PERC() {
		return COMP_PTCC_STD_PERC;
	}

	public void setCOMP_PTCC_STD_PERC(HtmlInputText cOMP_PTCC_STD_PERC) {
		COMP_PTCC_STD_PERC = cOMP_PTCC_STD_PERC;
	}

	public HtmlOutputLabel getCOMP_PTCC_SSTD_PERC_LABEL() {
		return COMP_PTCC_SSTD_PERC_LABEL;
	}

	public void setCOMP_PTCC_SSTD_PERC_LABEL(
			HtmlOutputLabel cOMP_PTCC_SSTD_PERC_LABEL) {
		COMP_PTCC_SSTD_PERC_LABEL = cOMP_PTCC_SSTD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTCC_SSTD_PERC() {
		return COMP_PTCC_SSTD_PERC;
	}

	public void setCOMP_PTCC_SSTD_PERC(HtmlInputText cOMP_PTCC_SSTD_PERC) {
		COMP_PTCC_SSTD_PERC = cOMP_PTCC_SSTD_PERC;
	}
	
	public void validatePTCC_YEAR_FM(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
			if(PM_IL_PROP_TREATY_CUST_COMM_BEAN.getPTCC_YEAR_TO()>0 &&
					PM_IL_PROP_TREATY_CUST_COMM_BEAN.getPTCC_YEAR_TO()<(Integer)value)
			{
				throw new Exception("From Year should be lesser then Year To");
			}
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_YEAR_FM((Integer.valueOf(value.toString())));
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePTCC_YEAR_TO(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
			
			if(PM_IL_PROP_TREATY_CUST_COMM_BEAN.getPTCC_YEAR_FM()>0 &&
					PM_IL_PROP_TREATY_CUST_COMM_BEAN.getPTCC_YEAR_FM()>(Integer)value)
			{
				throw new Exception("Year To should be greater then Year From");
			}
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_YEAR_FM((Integer.valueOf(value.toString())));
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePTCC_STD_PERC(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
			/*added by raja on 18-07-2017 for ZBILQC-1730094*/
			double percentage= Double.valueOf(value.toString());
			if(percentage>100)
			{
				throw new Exception("Percentage value shiuld be greater than 100");
			}
			/*end*/
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_STD_PERC((Double.valueOf(value.toString())));
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatePTCC_SSTD_PERC(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
			/*added by raja on 18-07-2017 for ZBILQC-1730094*/
			double percentage= Double.valueOf(value.toString());
			if(percentage>100)
			{
				throw new Exception("Percentage value shiuld be greater than 100");
			}
			/*end*/
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_SSTD_PERC((Double.valueOf(value.toString())));
			
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void getDetails_rate() {
		try {
			resetSelectedRow_rate();
			if (dataList_PM_IL_PROP_TREATY_CUST_COMM.size() != 0) {				
				PM_IL_PROP_TREATY_CUST_COMM_BEAN = (PM_IL_PROP_TREATY_CUST_COMM) dataTable_rate.getRowData();
			}	
			resetAllComponent_rate();			
			
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent_rate(){
		
		COMP_PTCC_YEAR_FM.resetValue();
		COMP_PTCC_YEAR_TO.resetValue();
		COMP_PTCC_STD_PERC.resetValue();
		COMP_PTCC_SSTD_PERC.resetValue();
	
	}
	
	// Added to apply row selection
	private void resetSelectedRow_rate() {
		Iterator<PM_IL_PROP_TREATY_CUST_COMM> iterator = dataList_PM_IL_PROP_TREATY_CUST_COMM.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	
	public void addRow_rate(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				
				PM_IL_PROP_TREATY_CUST_COMM_BEAN = new PM_IL_PROP_TREATY_CUST_COMM();
			
				resetAllComponent_rate();
				resetSelectedRow_rate();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			
			exc.printStackTrace();
		}

	}

	
	public void deleteRow_rate(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				
				new CRUDHandler().executeDelete(PM_IL_PROP_TREATY_CUST_COMM_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_IL_PROP_TREATY_CUST_COMM
						.remove(PM_IL_PROP_TREATY_CUST_COMM_BEAN);
				if (dataList_PM_IL_PROP_TREATY_CUST_COMM.size() > 0) {

					PM_IL_PROP_TREATY_CUST_COMM_BEAN = dataList_PM_IL_PROP_TREATY_CUST_COMM
							.get(0);
				} else if (dataList_PM_IL_PROP_TREATY_CUST_COMM.size() == 0) {

					addRow_rate(null);
				}

				resetAllComponent();
				PM_IL_PROP_TREATY_CUST_COMM_BEAN.setRowSelected(true);
				/*Added by saritha on 25-May-2017 for ssp call id ZBILQC-1725269*/
				CommonUtils.getConnection().commit();
				/*End*/
				
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	
	public void postRecord_rate(ActionEvent event) {
		String message = null;
		
		try {
			
			
			
			if (PM_IL_PROP_TREATY_CUST_COMM_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				String CURSOR_C1 = "SELECT PT_IL_PBEN_SYS_ID.NEXTVAL FROM DUAL ";
				ResultSet resultSet = null;
				Connection connection = null;
				CRUDHandler handler = new CRUDHandler();
				
					connection = CommonUtils.getConnection();
					resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
					if (resultSet.next()) {
						PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_SYS_ID(resultSet.getLong(1));
					}
					
					PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_PTPC_SYS_ID(PM_IL_PROP_TREATY_PART_CUST_BEAN.getPTPC_SYS_ID());
					PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_CR_DT(new CommonUtils().getCurrentDate());
					
					PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_CR_UID(commonUtils.getControlBean().getUSER_ID());
					
					
				new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_CUST_COMM_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				getWarningMap().put("postRecord", message);

				dataList_PM_IL_PROP_TREATY_CUST_COMM
						.add(PM_IL_PROP_TREATY_CUST_COMM_BEAN);
			} else if (PM_IL_PROP_TREATY_CUST_COMM_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				
				PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_UPD_UID(commonUtils.getControlBean().getUSER_ID());
				PM_IL_PROP_TREATY_CUST_COMM_BEAN.setPTCC_UPD_DT(new CommonUtils().getCurrentDate());
				new CRUDHandler().executeUpdate(PM_IL_PROP_TREATY_CUST_COMM_BEAN,
						CommonUtils.getConnection());
				
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
				/*getWarningMap().put("postRecord", message);*/
				/*End*/

			}
			
			PM_IL_PROP_TREATY_CUST_COMM_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
		
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	
	/*end*/
}

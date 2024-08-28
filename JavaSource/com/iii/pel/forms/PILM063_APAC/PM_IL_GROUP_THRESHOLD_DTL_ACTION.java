package com.iii.pel.forms.PILM063_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_GROUP_THRESHOLD_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_GTD_COVER_CODE_LABEL;

	private HtmlInputText COMP_GTD_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_GTD_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_GTD_COVER_CODE_DESC;

	private PM_IL_GROUP_THRESHOLD_DTL PM_IL_GROUP_THRESHOLD_DTL_BEAN;

	/** Variables are added for functionality. */
	
	private HtmlSelectBooleanCheckbox checkBox;
	
	/** LOV is Handled Here. */
	PILM063_APAC_ActionDelegate actionDelegate = new PILM063_APAC_ActionDelegate();
	/** LOV is Handled Here. */
	
	private ArrayList<PM_IL_GROUP_THRESHOLD_DTL> detailsList = new ArrayList<PM_IL_GROUP_THRESHOLD_DTL>();
	private UIDataTable detailsTable;
	private TabbedBar tabbedBar =null;
	
	private int prevRowIndex;
	private int currPage;
	private int lastUpdatedRowIndex;
	private int recordsPerPage = 5;
	private List<PM_IL_GROUP_THRESHOLD_DTL> dataTableList;
	
	private String filterByGTD_COVER_CODE;
	private String filterByUI_M_GTD_COVER_CODE_DESC;	
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	
	/** Variables are added for functionality. */
	
	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<PM_IL_GROUP_THRESHOLD_DTL> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PM_IL_GROUP_THRESHOLD_DTL> dataTableList) {
		this.dataTableList = dataTableList;
	}

	
	public ArrayList<PM_IL_GROUP_THRESHOLD_DTL> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(ArrayList<PM_IL_GROUP_THRESHOLD_DTL> detailsList) {
		this.detailsList = detailsList;
	}

	public UIDataTable getDetailsTable() {
		return detailsTable;
	}

	public void setDetailsTable(UIDataTable detailsTable) {
		this.detailsTable = detailsTable;
	}

	public PM_IL_GROUP_THRESHOLD_DTL_ACTION() {
		PM_IL_GROUP_THRESHOLD_DTL_BEAN = new PM_IL_GROUP_THRESHOLD_DTL();
		dataTableList = detailsList;
		prevRowIndex = 0;
		currPage = 1;
		tabbedBar = new TabbedBar();
		
		try {
			tabbedBar.addTab(1, "#{PILM063_APAC_PM_IL_GROUP_THRESHOLD_DTL_ACTION.previousPageNavigation}", "Group Threshold Limit Header", false);
			tabbedBar.addTab(2, "", "Group Threshold Limit Detail", false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String navigationEnabled(){
		setImmediate(true);
		 return "";
		
	}
	private void setImmediate(boolean flag){
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);
			
		}
		
	}

	public HtmlOutputLabel getCOMP_GTD_COVER_CODE_LABEL() {
		return COMP_GTD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_GTD_COVER_CODE() {
		return COMP_GTD_COVER_CODE;
	}

	public void setCOMP_GTD_COVER_CODE_LABEL(HtmlOutputLabel COMP_GTD_COVER_CODE_LABEL) {
		this.COMP_GTD_COVER_CODE_LABEL = COMP_GTD_COVER_CODE_LABEL;
	}

	public void setCOMP_GTD_COVER_CODE(HtmlInputText COMP_GTD_COVER_CODE) {
		this.COMP_GTD_COVER_CODE = COMP_GTD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_GTD_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_GTD_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_GTD_COVER_CODE_DESC() {
		return COMP_UI_M_GTD_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_GTD_COVER_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_GTD_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_GTD_COVER_CODE_DESC_LABEL = COMP_UI_M_GTD_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_GTD_COVER_CODE_DESC(HtmlInputText COMP_UI_M_GTD_COVER_CODE_DESC) {
		this.COMP_UI_M_GTD_COVER_CODE_DESC = COMP_UI_M_GTD_COVER_CODE_DESC;
	}

	public PM_IL_GROUP_THRESHOLD_DTL getPM_IL_GROUP_THRESHOLD_DTL_BEAN() {
		return PM_IL_GROUP_THRESHOLD_DTL_BEAN;
	}

	public void setPM_IL_GROUP_THRESHOLD_DTL_BEAN(PM_IL_GROUP_THRESHOLD_DTL PM_IL_GROUP_THRESHOLD_DTL_BEAN) {
		this.PM_IL_GROUP_THRESHOLD_DTL_BEAN = PM_IL_GROUP_THRESHOLD_DTL_BEAN;
	}
	
	/** Navigation To The Previous Page is Handled Here.*/
	public String previousPageNavigation(){
		return "PILM063_APAC_GTLHDR";
	}
	
	
	public void whenValidate(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void GTD_COVER_CODE_WhenValidateItem(FacesContext context, UIComponent component,
			Object value) throws ValidatorException,Exception {
		ResultSet rs = null;
		try {
			String M_GTD_COVER_CODE_DESC = null;
			String GTD_COVER_CODE = (String)value;
			String query1 = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE = '"+GTD_COVER_CODE+"'AND NVL(COVER_FRZ_FLAG,'N') = 'N'";
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(query1, getConnection());
			if(rs.next()){
				M_GTD_COVER_CODE_DESC = rs.getString(1);
				this.getPM_IL_GROUP_THRESHOLD_DTL_BEAN().setUI_M_GTD_COVER_CODE_DESC(M_GTD_COVER_CODE_DESC);
			}else
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71006"));
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
		finally{
			CommonUtils.closeCursor(rs);
		}
	}
	/*
	public void GTD_COVER_CODE_WhenValidateItem(FacesContext facesContext, UIComponent component, Object currValue) throws Exception{

//		UIInput uiInput = (UIInput)ae.getComponent();

//		PM_IL_GROUP_THRESHOLD_DTL detail = (PM_IL_GROUP_THRESHOLD_DTL) detailsTable.getRowData();
		String M_GTD_COVER_CODE_DESC = null;
//		String GTD_COVER_CODE = detail.getGTD_COVER_CODE();
		String GTD_COVER_CODE = (String)currValue;
		String query1 = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE = '"+GTD_COVER_CODE+"'AND NVL(COVER_FRZ_FLAG,'N') = 'N'";
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query1, getConnection());
		while(rs.next()){
			M_GTD_COVER_CODE_DESC = rs.getString(1);
//			System.out.println("^^^^^^^&&&&&&&&&&&&&&&&&&&&&$$$$$$$$$$$$$$$$$$$$"+M_GTD_COVER_CODE_DESC);
//			detail.setUI_M_GTD_COVER_CODE_DESC(M_GTD_COVER_CODE_DESC);
			this.getPM_IL_GROUP_THRESHOLD_DTL_BEAN().setUI_M_GTD_COVER_CODE_DESC(M_GTD_COVER_CODE_DESC);
		}
		CommonUtils.closeCursor(rs);
		if(M_GTD_COVER_CODE_DESC == null){
			System.out.println("Error Occured - Error Code: 71006");
		}
//		return "";
	}*/
	/** Navigation To The Previous Page is Handled Here.*/
	
	/** Field Level Trigges are Handled Here. 
	 * @throws Exception 
	 * @throws SQLException */
	
	public String GTD_COVER_CODE_WhenValidateItem(ActionEvent ae) throws Exception{
		UIInput uiInput = (UIInput)ae.getComponent();

		PM_IL_GROUP_THRESHOLD_DTL detail = (PM_IL_GROUP_THRESHOLD_DTL) detailsTable.getRowData();
		String M_GTD_COVER_CODE_DESC = null;
//		String GTD_COVER_CODE = detail.getGTD_COVER_CODE();
		String GTD_COVER_CODE = (String)uiInput.getSubmittedValue();
		String query1 = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE = '"+GTD_COVER_CODE+"'AND NVL(COVER_FRZ_FLAG,'N') = 'N'";
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query1, getConnection());
		while(rs.next()){
			M_GTD_COVER_CODE_DESC = rs.getString(1);
//			System.out.println("^^^^^^^&&&&&&&&&&&&&&&&&&&&&$$$$$$$$$$$$$$$$$$$$"+M_GTD_COVER_CODE_DESC);
			detail.setUI_M_GTD_COVER_CODE_DESC(M_GTD_COVER_CODE_DESC);
		}
		CommonUtils.closeCursor(rs);
		if(M_GTD_COVER_CODE_DESC == null){
			System.out.println("Error Occured - Error Code: 71006");
		}
		return "";
	}
	
	/** Field Level Trigges are Handled Here. */
	
	
	/** BLOCK-LEVEL Triggers are Handled Here. */
		public void PRE_INSERT_DTL(){
			return;
		} 
		
		public void PRE_UPDATE_DTL(){
			return;
		}
		
		public void POST_QUERY_DTL(){
			return;
		}
	/** BLOCK-LEVEL Triggers are Handled Here. */
	
		/** Database Connection*/
		private Connection getConnection() throws Exception{
			Connection con = CommonUtils.getConnection();
			return con;
		}
		/** Database Connection*/
	
	/** Saving Data in DataList. */
	public String saveDetailsData(){
//		lastColumnListener();
		return "";
	}
	/** Saving Data in DataList. */
	
	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 
	/**The Following Methods are For Grid Data Manipulations. */
	
	/*public String gridtabListener(){
		int currRowIndex = getDetailsTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_GROUP_THRESHOLD_DTL gridValueBean = null;
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1){
				if(lastUpdatedRowIndex!=prevRowIndex){
					if(currRowIndex != prevRowIndex){
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_GROUP_THRESHOLD_DTL)dataTableList.get(prevRowIndex);
						
						// Update the record to database
						if(gridValueBean.getROWID()!=null){
							rowUpdated = updateData(gridValueBean);
							errorMap.put("somekey", rowUpdated+" record updated.");
							errorMap.put("current", rowUpdated+" record updated.");
						}else{
							rowUpdated =updateData(gridValueBean);
							errorMap.put("somekey", rowUpdated+" record inserted.");
							errorMap.put("current", rowUpdated+" record inserted.");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}

		return "";
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	public int updateData(PM_IL_GROUP_THRESHOLD_DTL dataGridBean) throws Exception{
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dataGridBean, getConnection());
			//getConnection().commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	
	public String  lastColumnListener(){
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDetailsTable().getRowIndex();
		System.out.println("Current Row Index = "+currRowIndex);
		int rowUpdated = 0;
		PM_IL_GROUP_THRESHOLD_DTL gridValueBean = null;
		System.out.println("$$$$$$$$$$$$$$$$$ DataTableList Size = "+dataTableList.size());
		try {
			// Get the bean based on row index
			gridValueBean = (PM_IL_GROUP_THRESHOLD_DTL)dataTableList.get(currRowIndex);
			/*System.out.println("The ROWID = "+gridValueBean.getROWID());
			System.out.println("Cover Code = "+gridValueBean.getGTD_COVER_CODE());
			System.out.println("Code Description = "+gridValueBean.getUI_M_GTD_COVER_CODE_DESC());*/
			// Update the record to database
			if(gridValueBean.getROWID()!=null){
				rowUpdated =updateData(gridValueBean);
				getWarningMap().put("current", rowUpdated+" Records Updated.");
			}else{
				rowUpdated =updateData(gridValueBean);
				getWarningMap().put("current",rowUpdated+" Records Inserted.");
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
			getErrorMap().put("current", "Error Occured while Inserting or Updating the record.");
		}

		return "" ;
	}
	
	public String saveData(PM_IL_GROUP_THRESHOLD_DTL_ACTION dataGridAction)	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_GROUP_THRESHOLD_DTL> valueBeanList = null;
		try {
			connection = getConnection();
			valueBeanList = dataGridAction.getDataTableList();
			for(int index = 0;index<valueBeanList.size(); index++)	{
				PM_IL_GROUP_THRESHOLD_DTL gridValueBean = (PM_IL_GROUP_THRESHOLD_DTL)valueBeanList.get(index);
				handler.executeInsert(gridValueBean, connection);
			}

			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	public void newRow(ActionEvent ae){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
		int rowCount = 0;
		if(dataTableList == null){
			dataTableList = new ArrayList<PM_IL_GROUP_THRESHOLD_DTL>();
		}
		PM_IL_GROUP_THRESHOLD_HDR_ACTION action = (PM_IL_GROUP_THRESHOLD_HDR_ACTION) sessionMap.get("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION");
		PM_IL_GROUP_THRESHOLD_HDR dBean = action.getPM_IL_GROUP_THRESHOLD_HDR_BEAN();

		PM_IL_GROUP_THRESHOLD_DTL dtl = new PM_IL_GROUP_THRESHOLD_DTL();
		dtl.setGTD_GROUP_CODE(dBean.getGTH_GROUP_CODE());

		dataTableList.add(dtl);
		rowCount = getDetailsTable().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
	}
	
	
	public String deleteRow()
	{
		PM_IL_GROUP_THRESHOLD_DTL bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(dataTableList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<dataTableList.size();)
			{
				bean = dataTableList.get(index);
				if(bean.isCheckBoxValue()){
					dataTableList.remove(bean);
					deletedRecordIndex = deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
					String deleteMessage= Messages.getString("messageProperties.properties", "errorPanel$message$delete");
					getErrorMap().put("current", deletedRecordIndex+" "+deleteMessage);
					
				}else
				{
					index++;
				}
			}
			
			if(deletedRecordList.size()>0)
			{
				/*errorMap.put("somekey", deletedRecordList.size()+" records deleted.");
				errorMap.put("current", deletedRecordList.size()+" records deleted.");*/
			}
			lastUpdatedRowIndex = -1;
			
		}
		
		return "";
	}
	
	public int deleteData(PM_IL_GROUP_THRESHOLD_DTL gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			//connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}
	
	public void checkBoxValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
//		gridtabListener();
	}
	
	public String checkBoxStatus(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		boolean checkBoxValue = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDetailsTable().getRowIndex();
		getDataTableList().get(rowIndex).setCheckBoxValue(checkBoxValue);
		return "";
	}
	/**The Following Methods are For Grid Data Manipulations. */

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	public List DTLLov(Object obj){
		ArrayList<GTD_COVER_CODE_LOVBean> list = new ArrayList<GTD_COVER_CODE_LOVBean>();
		ResultSet rs = null;
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			if(obj.toString().equalsIgnoreCase("*")){
				query="select COVER_CODE,COVER_DESC,COVER_BL_DESC from PM_IL_COVER where COVER_FRZ_FLAG = 'N' AND ROWNUM<51 ORDER BY 1 ASC";
			}else{
				query="select COVER_CODE,COVER_DESC,COVER_BL_DESC from PM_IL_COVER where COVER_FRZ_FLAG = 'N' AND ROWNUM<51 AND COVER_CODE LIKE '"+obj.toString()+"%' ORDER BY 1 ASC";
			}
			rs = handler.executeSelectStatement(query, getConnection());
				while(rs.next()){
					GTD_COVER_CODE_LOVBean bean = new GTD_COVER_CODE_LOVBean();
					bean.setCOVER_CODE(rs.getString(1));
					bean.setCOVER_DESC(rs.getString(2));
					list.add(bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
				CommonUtils.closeCursor(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<LovBean> lovGTD_COVER_CODE(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
		    suggestionList = listitemutil.P_CALL_LOV("PILM063_APAC",
		    "PM_IL_GROUP_THRESHOLD_DTL", "GTD_COVER_CODE", null, null, null, null,
			    null, (String) currValue);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return suggestionList;
	    }
	//P_CALL_LOV('PM_IL_GROUP_THRESHOLD_DTL.GTD_COVER_CODE');
	
	/** LOV is Handled Here */

	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	// [ Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = detailsTable.getRowIndex();

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
	
	// Modified By Shankar Bodduluri (19-02-2009)
	public String saveAndCommit(){
		CommonUtils.clearMaps(this);
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
			getWarningMap().put("Save",
					Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}
	
	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (detailsList.size() != 0) {				
				PM_IL_GROUP_THRESHOLD_DTL_BEAN = (PM_IL_GROUP_THRESHOLD_DTL) detailsTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_GROUP_THRESHOLD_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetAllComponent() {
		// TODO Auto-generated method stub
		COMP_GTD_COVER_CODE.resetValue();
		COMP_UI_M_GTD_COVER_CODE_DESC.resetValue();
		
	}
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_GROUP_THRESHOLD_DTL> iterator = detailsList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByUI_M_GTD_COVER_CODE_DESC() {
		return filterByUI_M_GTD_COVER_CODE_DESC;
	}

	public void setFilterByUI_M_GTD_COVER_CODE_DESC(
			String filterByUI_M_GTD_COVER_CODE_DESC) {
		this.filterByUI_M_GTD_COVER_CODE_DESC = filterByUI_M_GTD_COVER_CODE_DESC;
	}

	public String getFilterByGTD_COVER_CODE() {
		return filterByGTD_COVER_CODE;
	}

	public void setFilterByGTD_COVER_CODE(String filterByGTD_COVER_CODE) {
		this.filterByGTD_COVER_CODE = filterByGTD_COVER_CODE;
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
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_GROUP_THRESHOLD_DTL_BEAN = new PM_IL_GROUP_THRESHOLD_DTL();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_GROUP_THRESHOLD_DTL_BEAN.setRowSelected(true);
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
	
	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_IL_GROUP_THRESHOLD_DTL_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_GROUP_THRESHOLD_DTL_BEAN, CommonUtils.getConnection());
					detailsList.remove(PM_IL_GROUP_THRESHOLD_DTL_BEAN);
				}
				
				if(detailsList.size() > 0) {
					setPM_IL_GROUP_THRESHOLD_DTL_BEAN(detailsList.get(0));
					PM_IL_GROUP_THRESHOLD_DTL_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
				
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
				resetAllComponent();
				

			} else {
				getErrorMap().clear();
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

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	

	public void post(ActionEvent ae) {
		PILM063_APAC_ActionDelegate delegate = new PILM063_APAC_ActionDelegate();
	    CommonUtils.clearMaps(this);
		try{
			if(PM_IL_GROUP_THRESHOLD_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PRE_UPDATE(PM_IL_GROUP_THRESHOLD_DTL_BEAN);
					new CRUDHandler().executeInsert(PM_IL_GROUP_THRESHOLD_DTL_BEAN, CommonUtils.getConnection());
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
					PRE_INSERT(PM_IL_GROUP_THRESHOLD_DTL_BEAN);
					new CRUDHandler().executeInsert(PM_IL_GROUP_THRESHOLD_DTL_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					detailsList.add(PM_IL_GROUP_THRESHOLD_DTL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			//Added For Selecting Row
			resetSelectedRow();
			PM_IL_GROUP_THRESHOLD_DTL_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	private void PRE_INSERT(
			PM_IL_GROUP_THRESHOLD_DTL pm_il_group_threshold_dtl_bean)throws Exception {
		// TODO Auto-generated method stub
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
		PM_IL_GROUP_THRESHOLD_HDR_ACTION action = (PM_IL_GROUP_THRESHOLD_HDR_ACTION) sessionMap.get("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION");
		String M_GTD_GROUP_CODE = null;
		String C1 ="SELECT  GTD_GROUP_CODE FROM    PM_IL_GROUP_THRESHOLD_DTL,PM_IL_GROUP_THRESHOLD_HDR " +
				   "WHERE   GTD_GROUP_CODE = GTH_GROUP_CODE AND " +
				   "GTD_COVER_CODE = ? " +
				   "AND GTH_TYPE=?";
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(C1, con, new Object[]{pm_il_group_threshold_dtl_bean.getGTD_COVER_CODE(),CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2")});
			while(rs.next()){
				M_GTD_GROUP_CODE = rs.getString(1);
				if(M_GTD_GROUP_CODE.equals(action.getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getGTH_GROUP_CODE()))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91476")); 
				else 
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91477"));
			}
		
		PM_IL_GROUP_THRESHOLD_HDR dBean = action.getPM_IL_GROUP_THRESHOLD_HDR_BEAN();
		pm_il_group_threshold_dtl_bean.setGTD_GROUP_CODE(dBean.getGTH_GROUP_CODE()); 
		pm_il_group_threshold_dtl_bean.setGTD_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		pm_il_group_threshold_dtl_bean.setGTD_CR_DT(new CommonUtils().getCurrentDate());
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}
	
	private void PRE_UPDATE(
			PM_IL_GROUP_THRESHOLD_DTL pm_il_group_threshold_dtl_bean)throws Exception {
		// TODO Auto-generated method stub
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
		PM_IL_GROUP_THRESHOLD_HDR_ACTION action = (PM_IL_GROUP_THRESHOLD_HDR_ACTION) sessionMap.get("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION");
		String M_GTD_GROUP_CODE = null;
		String C1 ="SELECT  GTD_GROUP_CODE  FROM    PM_IL_GROUP_THRESHOLD_DTL,PM_IL_GROUP_THRESHOLD_HDR" +
				"  WHERE   GTD_GROUP_CODE = GTH_GROUP_CODE AND" +
				"  GTD_COVER_CODE = ? AND PM_IL_GROUP_THRESHOLD_DTL.ROWID <> ?" +
				"  AND GTH_TYPE= ?";
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(C1, con, new Object[]{pm_il_group_threshold_dtl_bean.getGTD_COVER_CODE(),
																				pm_il_group_threshold_dtl_bean.getROWID(),
																				CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2")});
			while(rs.next()){
				M_GTD_GROUP_CODE = rs.getString(1);
				if(M_GTD_GROUP_CODE.equals(action.getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getGTH_GROUP_CODE()))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91476")); 
				else 
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91477"));
			}
		
		pm_il_group_threshold_dtl_bean.setGTD_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		pm_il_group_threshold_dtl_bean.setGTD_UPD_DT(new CommonUtils().getCurrentDate());
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}
	
}

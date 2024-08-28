package com.iii.pel.forms.CHART;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.chartimpl.helper.ServletUtility;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class ChartAction extends CommonAction{
	private ArrayList<ChartBean> chartList;
	private ChartBean chartBean;
	private ArrayList<SelectItem> chartTypes;
	private ArrayList<SelectItem> userList;
	// Components
	private UIData dataTable;
	private UIData queryResultDataTable;
	private HtmlOutputLabel COMP_CHART_ID_LABEL;
	private HtmlOutputLabel COMP_CHART_DESC_LABEL;
	private HtmlOutputLabel COMP_CHART_TYPE_LABEL;
	private HtmlOutputLabel COMP_CHART_QUERY_LABEL;
	private HtmlInputText COMP_CHART_ID;
	private HtmlInputText COMP_CHART_DESC;
	private HtmlSelectOneMenu COMP_CHART_TYPE;
	private HtmlInputTextarea COMP_CHART_QUERY;
	private HtmlTab COMP_QUERY_RESULT_TAB;
    private HtmlTab COMP_QUERY_CHART_PREVIEW;
    private HtmlTab COMP_QUERY_USER_ASSOCIATION_TAB;
    private HtmlTabPanel COMP_CHART_TAB_PANEL;

	public ChartAction(){
		chartBean = new ChartBean();
		chartTypes = new ArrayList<SelectItem>();
		userList = new ArrayList<SelectItem>();
	}
	
	public ChartBean getChartBean() {
		return chartBean;
	}

	public void setChartBean(ChartBean chartBean) {
		this.chartBean = chartBean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<ChartBean> getChartList() {
		return chartList;
	}

	public void setChartList(ArrayList<ChartBean> chartList) {
		this.chartList = chartList;
	}

	public ArrayList<SelectItem> getChartTypes() {
		return chartTypes;
	}

	public void setChartTypes(ArrayList<SelectItem> chartTypes) {
		this.chartTypes = chartTypes;
	}
	
	// Grid related method implementation
	public String displayRecords(){
		try {
			// Clearing the map
			getErrorMap().clear();
			getWarningMap().clear();
			
			this.chartBean = (ChartBean) dataTable.getRowData();
		
			this.chartBean.setQueryResults(ChartQueryResultSet.executeAndPrepareQueryResultSet(
					chartBean.getCHART_ID(), chartBean.getCHART_QUERY()));
			
			resetComponents();
			resetSelectedRow();
			this.chartBean.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
		return null;
	}
	public void addRow(ActionEvent actionEvent){
		this.chartBean = new ChartBean();
		resetSelectedRow();
		resetComponents();
	}
	public void deleteRow(ActionEvent actionEvent){
		ChartHelper chartHelper = new ChartHelper();
		String message = null;
		
		try {
			if(chartList.contains(this.chartBean)){
				chartHelper.deleteChart(this.chartBean);
				chartList.remove(chartBean);
			}
			
			if(chartList.size() > 0){
				this.chartBean = chartList.get(0);
			} else{
				addRow(actionEvent);
			}
			resetComponents();
			this.chartBean.setRowSelected(true);
			
			message = Messages.getString("messageProperties", "errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
		
	}
	public void postRecord(ActionEvent actionEvent){
		ChartHelper chartHelper = new ChartHelper();
		String message = null;

		try {
			chartHelper.postChart(chartBean);
			if(!chartList.contains(chartBean)){
				chartBean.setRowSelected(true);
				chartList.add(chartBean);
			}
			
			message = Messages.getString("messageProperties", "errorPanel$message$postupdate");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}

	// Validators
	public void ChartIDValidator(FacesContext context, UIComponent input, Object value){
		ChartHelper chartHelper = new ChartHelper();
		try {
			chartHelper.duplicateChartIdValidator(this.chartBean, (String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	// Action Listeners
	public void fierFieldValidation(ActionEvent actionEvent){
		ErrorHelpUtil.validate((UIInput) actionEvent.getComponent().getParent(), getErrorMap());
	}
	
	// On load
	public void onLoad(PhaseEvent event){
		ChartHelper chartHelper = new ChartHelper();
		
		try {
			if(isBlockFlag()){
				this.chartTypes = chartHelper.prepareChartTypesList();
				this.userList = chartHelper.prepareUserList();
				this.chartList = chartHelper.executeQuery();
				if(this.chartList.size() > 0){
					this.chartBean = this.chartList.get(0);
					this.chartBean.setRowSelected(true);
				}else{
					addRow(null);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	// Reset selection
	public void resetSelectedRow(){
		Iterator<ChartBean> iterator = this.getChartList().iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void generateChart(ActionEvent actionEvent){
		CommonUtils commonUtils = new CommonUtils();
		try {
			chartBean.setUI_CHART_URL(new ServletUtility().generateImageURLForChartCode(this.chartBean.getCHART_ID(), 
					0, 0, commonUtils.getHttpServletRequest(), 
					(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse()));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	public void executeQuery(){
		try {
			// Clearing the map
			getErrorMap().clear();
			getWarningMap().clear();
			
			chartBean.setQueryResults(ChartQueryResultSet.executeAndPrepareQueryResultSet(chartBean.getCHART_ID(), 
					chartBean.getCHART_QUERY()));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	public String saveRecord(){
		String message = null;
		try {
			new CommonUtils().doComitt();
			message = Messages.getString("messageProperties", "errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		
		return null;
	}
	
	public String generatePreview(){
		ServletUtility servletUtility = new ServletUtility();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		try {
			this.chartBean.setUI_CHART_URL(servletUtility.generateImageURLForChartCode(
					this.chartBean.getCHART_ID(), 0, 0, request, response));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}

		return null;
	}

	public HtmlOutputLabel getCOMP_CHART_ID_LABEL() {
		return COMP_CHART_ID_LABEL;
	}

	public void setCOMP_CHART_ID_LABEL(HtmlOutputLabel comp_chart_id_label) {
		COMP_CHART_ID_LABEL = comp_chart_id_label;
	}

	public HtmlOutputLabel getCOMP_CHART_DESC_LABEL() {
		return COMP_CHART_DESC_LABEL;
	}

	public void setCOMP_CHART_DESC_LABEL(HtmlOutputLabel comp_chart_desc_label) {
		COMP_CHART_DESC_LABEL = comp_chart_desc_label;
	}

	public HtmlOutputLabel getCOMP_CHART_TYPE_LABEL() {
		return COMP_CHART_TYPE_LABEL;
	}

	public void setCOMP_CHART_TYPE_LABEL(HtmlOutputLabel comp_chart_type_label) {
		COMP_CHART_TYPE_LABEL = comp_chart_type_label;
	}

	public HtmlOutputLabel getCOMP_CHART_QUERY_LABEL() {
		return COMP_CHART_QUERY_LABEL;
	}

	public void setCOMP_CHART_QUERY_LABEL(HtmlOutputLabel comp_chart_query_label) {
		COMP_CHART_QUERY_LABEL = comp_chart_query_label;
	}

	public HtmlInputText getCOMP_CHART_ID() {
		return COMP_CHART_ID;
	}

	public void setCOMP_CHART_ID(HtmlInputText comp_chart_id) {
		COMP_CHART_ID = comp_chart_id;
	}

	public HtmlInputText getCOMP_CHART_DESC() {
		return COMP_CHART_DESC;
	}

	public void setCOMP_CHART_DESC(HtmlInputText comp_chart_desc) {
		COMP_CHART_DESC = comp_chart_desc;
	}

	public HtmlSelectOneMenu getCOMP_CHART_TYPE() {
		return COMP_CHART_TYPE;
	}

	public void setCOMP_CHART_TYPE(HtmlSelectOneMenu comp_chart_type) {
		COMP_CHART_TYPE = comp_chart_type;
	}

	public HtmlInputTextarea getCOMP_CHART_QUERY() {
		return COMP_CHART_QUERY;
	}

	public void setCOMP_CHART_QUERY(HtmlInputTextarea comp_chart_query) {
		COMP_CHART_QUERY = comp_chart_query;
	}
	
	// Reset components
	public void resetComponents(){
		COMP_CHART_ID.resetValue();
		COMP_CHART_DESC.resetValue();
		COMP_CHART_TYPE.resetValue();
		COMP_CHART_QUERY.resetValue();
	}

	public UIData getQueryResultDataTable() {
		return queryResultDataTable;
	}

	public void setQueryResultDataTable(UIData queryResultDataTable) {
		this.queryResultDataTable = queryResultDataTable;
	}

	public ArrayList<SelectItem> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<SelectItem> userList) {
		this.userList = userList;
	}
	
	public void settingsForChartType(ActionEvent changeEvent){
	    String val=(String)COMP_CHART_TYPE.getSubmittedValue();
		if(val.equals("3")) {
				//COMP_CHART_TYPE_LABEL.setValue("Report Type");
				COMP_CHART_ID_LABEL.setValue("Report ID");
				COMP_CHART_DESC_LABEL.setValue("Report Label");
				COMP_CHART_QUERY_LABEL.setValue("Report Name");
				COMP_QUERY_RESULT_TAB.setRendered(false);
				COMP_QUERY_CHART_PREVIEW.setRendered(false);
				//COMP_QUERY_USER_ASSOCIATION_TAB.setRendered(true);
				
		}
		else {
				//COMP_CHART_TYPE_LABEL.setValue("Chart Type");
				COMP_CHART_ID_LABEL.setValue("Chart ID");
				COMP_CHART_DESC_LABEL.setValue("Chart Desc");
				COMP_CHART_QUERY_LABEL.setValue("Chart Query");
				COMP_QUERY_RESULT_TAB.setRendered(true);
				COMP_QUERY_CHART_PREVIEW.setRendered(true);
				//COMP_QUERY_USER_ASSOCIATION_TAB.setRendered(true);
		}
}

	public HtmlTab getCOMP_QUERY_RESULT_TAB() {
		return COMP_QUERY_RESULT_TAB;
	}

	public void setCOMP_QUERY_RESULT_TAB(HtmlTab comp_query_result_tab) {
		COMP_QUERY_RESULT_TAB = comp_query_result_tab;
	}

	public HtmlTab getCOMP_QUERY_CHART_PREVIEW() {
		return COMP_QUERY_CHART_PREVIEW;
	}

	public void setCOMP_QUERY_CHART_PREVIEW(HtmlTab comp_query_chart_preview) {
		COMP_QUERY_CHART_PREVIEW = comp_query_chart_preview;
	}

	public HtmlTab getCOMP_QUERY_USER_ASSOCIATION_TAB() {
		return COMP_QUERY_USER_ASSOCIATION_TAB;
	}

	public void setCOMP_QUERY_USER_ASSOCIATION_TAB(
			HtmlTab comp_query_user_association_tab) {
		COMP_QUERY_USER_ASSOCIATION_TAB = comp_query_user_association_tab;
	}

	public HtmlTabPanel getCOMP_CHART_TAB_PANEL() {
		return COMP_CHART_TAB_PANEL;
	}

	public void setCOMP_CHART_TAB_PANEL(HtmlTabPanel comp_chart_tab_panel) {
		COMP_CHART_TAB_PANEL = comp_chart_tab_panel;
	}
}

package com.iii.pel.forms.PM105_A_TISB;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE_ACTION {
	
	private List<PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE> recordList= new ArrayList<PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE>();
	private UIDataTable dataTable;
	private PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE searchBean;
	private HtmlInputText CACS_MAIN_ACNT_CODE;
	private HtmlInputText CACS_SUB_ACNT_CODE;
	private HtmlInputText CACS_DIVN_CODE;
	private HtmlInputText CACS_SETUP_TYPE;
	CRUDHandler handler=new CRUDHandler();
	
	
	public PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE_ACTION() {
		searchBean = new PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE();
	}



	public List<PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE> getRecordList() {
		return recordList;
	}



	public void setRecordList(List<PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE> recordList) {
		this.recordList = recordList;
	}

	
	public UIDataTable getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String updateOrInsertRecordLinkClicked(){
		return null;
	}
	public PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE searchBean) {
		this.searchBean = searchBean;
	}



	public HtmlInputText getCACS_MAIN_ACNT_CODE() {
		return CACS_MAIN_ACNT_CODE;
	}



	public void setCACS_MAIN_ACNT_CODE(HtmlInputText cacs_main_acnt_code) {
		CACS_MAIN_ACNT_CODE = cacs_main_acnt_code;
	}



	public HtmlInputText getCACS_SUB_ACNT_CODE() {
		return CACS_SUB_ACNT_CODE;
	}



	public void setCACS_SUB_ACNT_CODE(HtmlInputText cacs_sub_acnt_code) {
		CACS_SUB_ACNT_CODE = cacs_sub_acnt_code;
	}



	public HtmlInputText getCACS_DIVN_CODE() {
		return CACS_DIVN_CODE;
	}



	public void setCACS_DIVN_CODE(HtmlInputText cacs_divn_code) {
		CACS_DIVN_CODE = cacs_divn_code;
	}
	

	
	
	
	//HANDLING DELETE BUTTON IN SEARCH PAGE  STARTS HERE
	public void searchPageDelete(ActionEvent event) throws Exception{
		System.out.println("PT051_A_SEARCH_PAGE_ACTION.searchPageDelete()");
			int header = 0;
			String row=null;
				for(int index = 0; index < recordList.size();){
					PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE pageBean = (PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE)recordList.get(index);
					if(pageBean.isCheckbox())
					{
						row=pageBean.getRowId();
						deleteFromSearch(row);
						recordList.remove(pageBean);
					}
				}
		}
	public void deleteFromSearch(String str) throws Exception{
		
		String deleteQuery="DELETE FROM PM_IL_CODES_ACCOUNT_SETUP WHERE " +
				"  CACS_SETUP_TYPE='A' AND ROWID='"+str+"'";
		Connection conn=CommonUtils.getConnection();
		handler.executeDeleteStatement(deleteQuery, conn);
		conn.commit();
		//conn.close();
	}



	/*public String getAccesskey() {
		return CACS_SETUP_TYPE.getAccesskey();
	}



	public String getAlt() {
		return CACS_SETUP_TYPE.getAlt();
	}



	public String getAutocomplete() {
		return CACS_SETUP_TYPE.getAutocomplete();
	}



	public String getDir() {
		return CACS_SETUP_TYPE.getDir();
	}



	public String getLabel() {
		return CACS_SETUP_TYPE.getLabel();
	}



	public String getLang() {
		return CACS_SETUP_TYPE.getLang();
	}



	public int getMaxlength() {
		return CACS_SETUP_TYPE.getMaxlength();
	}



	public String getOnblur() {
		return CACS_SETUP_TYPE.getOnblur();
	}



	public String getOnchange() {
		return CACS_SETUP_TYPE.getOnchange();
	}



	public String getOnclick() {
		return CACS_SETUP_TYPE.getOnclick();
	}



	public String getOndblclick() {
		return CACS_SETUP_TYPE.getOndblclick();
	}



	public String getOnfocus() {
		return CACS_SETUP_TYPE.getOnfocus();
	}



	public String getOnkeydown() {
		return CACS_SETUP_TYPE.getOnkeydown();
	}



	public String getOnkeypress() {
		return CACS_SETUP_TYPE.getOnkeypress();
	}



	public String getOnkeyup() {
		return CACS_SETUP_TYPE.getOnkeyup();
	}



	public String getOnmousedown() {
		return CACS_SETUP_TYPE.getOnmousedown();
	}



	public String getOnmousemove() {
		return CACS_SETUP_TYPE.getOnmousemove();
	}



	public String getOnmouseout() {
		return CACS_SETUP_TYPE.getOnmouseout();
	}



	public String getOnmouseover() {
		return CACS_SETUP_TYPE.getOnmouseover();
	}



	public String getOnmouseup() {
		return CACS_SETUP_TYPE.getOnmouseup();
	}



	public String getOnselect() {
		return CACS_SETUP_TYPE.getOnselect();
	}



	public int getSize() {
		return CACS_SETUP_TYPE.getSize();
	}



	public String getStyle() {
		return CACS_SETUP_TYPE.getStyle();
	}



	public String getStyleClass() {
		return CACS_SETUP_TYPE.getStyleClass();
	}



	public String getTabindex() {
		return CACS_SETUP_TYPE.getTabindex();
	}



	public String getTitle() {
		return CACS_SETUP_TYPE.getTitle();
	}



	public boolean isDisabled() {
		return CACS_SETUP_TYPE.isDisabled();
	}



	public boolean isReadonly() {
		return CACS_SETUP_TYPE.isReadonly();
	}



	public void restoreState(FacesContext _context, Object _state) {
		CACS_SETUP_TYPE.restoreState(_context, _state);
	}



	public Object saveState(FacesContext _context) {
		return CACS_SETUP_TYPE.saveState(_context);
	}



	public void setAccesskey(String accesskey) {
		CACS_SETUP_TYPE.setAccesskey(accesskey);
	}



	public void setAlt(String alt) {
		CACS_SETUP_TYPE.setAlt(alt);
	}



	public void setAutocomplete(String autocomplete) {
		CACS_SETUP_TYPE.setAutocomplete(autocomplete);
	}



	public void setDir(String dir) {
		CACS_SETUP_TYPE.setDir(dir);
	}



	public void setDisabled(boolean disabled) {
		CACS_SETUP_TYPE.setDisabled(disabled);
	}



	public void setLabel(String label) {
		CACS_SETUP_TYPE.setLabel(label);
	}



	public void setLang(String lang) {
		CACS_SETUP_TYPE.setLang(lang);
	}



	public void setMaxlength(int maxlength) {
		CACS_SETUP_TYPE.setMaxlength(maxlength);
	}



	public void setOnblur(String onblur) {
		CACS_SETUP_TYPE.setOnblur(onblur);
	}



	public void setOnchange(String onchange) {
		CACS_SETUP_TYPE.setOnchange(onchange);
	}



	public void setOnclick(String onclick) {
		CACS_SETUP_TYPE.setOnclick(onclick);
	}



	public void setOndblclick(String ondblclick) {
		CACS_SETUP_TYPE.setOndblclick(ondblclick);
	}



	public void setOnfocus(String onfocus) {
		CACS_SETUP_TYPE.setOnfocus(onfocus);
	}



	public void setOnkeydown(String onkeydown) {
		CACS_SETUP_TYPE.setOnkeydown(onkeydown);
	}



	public void setOnkeypress(String onkeypress) {
		CACS_SETUP_TYPE.setOnkeypress(onkeypress);
	}



	public void setOnkeyup(String onkeyup) {
		CACS_SETUP_TYPE.setOnkeyup(onkeyup);
	}



	public void setOnmousedown(String onmousedown) {
		CACS_SETUP_TYPE.setOnmousedown(onmousedown);
	}



	public void setOnmousemove(String onmousemove) {
		CACS_SETUP_TYPE.setOnmousemove(onmousemove);
	}



	public void setOnmouseout(String onmouseout) {
		CACS_SETUP_TYPE.setOnmouseout(onmouseout);
	}



	public void setOnmouseover(String onmouseover) {
		CACS_SETUP_TYPE.setOnmouseover(onmouseover);
	}



	public void setOnmouseup(String onmouseup) {
		CACS_SETUP_TYPE.setOnmouseup(onmouseup);
	}



	public void setOnselect(String onselect) {
		CACS_SETUP_TYPE.setOnselect(onselect);
	}



	public void setReadonly(boolean readonly) {
		CACS_SETUP_TYPE.setReadonly(readonly);
	}



	public void setSize(int size) {
		CACS_SETUP_TYPE.setSize(size);
	}



	public void setStyle(String style) {
		CACS_SETUP_TYPE.setStyle(style);
	}



	public void setStyleClass(String styleClass) {
		CACS_SETUP_TYPE.setStyleClass(styleClass);
	}



	public void setTabindex(String tabindex) {
		CACS_SETUP_TYPE.setTabindex(tabindex);
	}



	public void setTitle(String title) {
		CACS_SETUP_TYPE.setTitle(title);
	}



	public void addValidator(Validator validator) {
		CACS_SETUP_TYPE.addValidator(validator);
	}



	public void addValueChangeListener(ValueChangeListener listener) {
		CACS_SETUP_TYPE.addValueChangeListener(listener);
	}



	public void decode(FacesContext context) {
		CACS_SETUP_TYPE.decode(context);
	}



	public String getConverterMessage() {
		return CACS_SETUP_TYPE.getConverterMessage();
	}



	public String getFamily() {
		return CACS_SETUP_TYPE.getFamily();
	}



	public String getRequiredMessage() {
		return CACS_SETUP_TYPE.getRequiredMessage();
	}



	public Object getSubmittedValue() {
		return CACS_SETUP_TYPE.getSubmittedValue();
	}



	public MethodBinding getValidator() {
		return CACS_SETUP_TYPE.getValidator();
	}



	public String getValidatorMessage() {
		return CACS_SETUP_TYPE.getValidatorMessage();
	}



	public Validator[] getValidators() {
		return CACS_SETUP_TYPE.getValidators();
	}



	public MethodBinding getValueChangeListener() {
		return CACS_SETUP_TYPE.getValueChangeListener();
	}



	public ValueChangeListener[] getValueChangeListeners() {
		return CACS_SETUP_TYPE.getValueChangeListeners();
	}



	public boolean isImmediate() {
		return CACS_SETUP_TYPE.isImmediate();
	}



	public boolean isLocalValueSet() {
		return CACS_SETUP_TYPE.isLocalValueSet();
	}



	public boolean isRequired() {
		return CACS_SETUP_TYPE.isRequired();
	}



	public boolean isValid() {
		return CACS_SETUP_TYPE.isValid();
	}



	public void processDecodes(FacesContext context) {
		CACS_SETUP_TYPE.processDecodes(context);
	}



	public void processUpdates(FacesContext arg0) {
		CACS_SETUP_TYPE.processUpdates(arg0);
	}



	public void processValidators(FacesContext context) {
		CACS_SETUP_TYPE.processValidators(context);
	}



	public void removeValidator(Validator validator) {
		CACS_SETUP_TYPE.removeValidator(validator);
	}



	public void removeValueChangeListener(ValueChangeListener listener) {
		CACS_SETUP_TYPE.removeValueChangeListener(listener);
	}



	public void resetValue() {
		CACS_SETUP_TYPE.resetValue();
	}



	public void setConverterMessage(String message) {
		CACS_SETUP_TYPE.setConverterMessage(message);
	}



	public void setImmediate(boolean immediate) {
		CACS_SETUP_TYPE.setImmediate(immediate);
	}



	public void setLocalValueSet(boolean localValueSet) {
		CACS_SETUP_TYPE.setLocalValueSet(localValueSet);
	}



	public void setRequired(boolean required) {
		CACS_SETUP_TYPE.setRequired(required);
	}



	public void setRequiredMessage(String message) {
		CACS_SETUP_TYPE.setRequiredMessage(message);
	}



	public void setSubmittedValue(Object submittedValue) {
		CACS_SETUP_TYPE.setSubmittedValue(submittedValue);
	}



	public void setValid(boolean valid) {
		CACS_SETUP_TYPE.setValid(valid);
	}



	public void setValidator(MethodBinding arg0) {
		CACS_SETUP_TYPE.setValidator(arg0);
	}



	public void setValidatorMessage(String message) {
		CACS_SETUP_TYPE.setValidatorMessage(message);
	}



	public void setValue(Object value) {
		CACS_SETUP_TYPE.setValue(value);
	}



	public void setValueChangeListener(MethodBinding arg0) {
		CACS_SETUP_TYPE.setValueChangeListener(arg0);
	}



	public void updateModel(FacesContext arg0) {
		CACS_SETUP_TYPE.updateModel(arg0);
	}



	public void validate(FacesContext arg0) {
		CACS_SETUP_TYPE.validate(arg0);
	}



	public Converter getConverter() {
		return CACS_SETUP_TYPE.getConverter();
	}



	public Object getLocalValue() {
		return CACS_SETUP_TYPE.getLocalValue();
	}



	public Object getValue() {
		return CACS_SETUP_TYPE.getValue();
	}



	public void setConverter(Converter converter) {
		CACS_SETUP_TYPE.setConverter(converter);
	}



	public void broadcast(FacesEvent arg0) throws AbortProcessingException {
		CACS_SETUP_TYPE.broadcast(arg0);
	}



	public void encodeBegin(FacesContext arg0) throws IOException {
		CACS_SETUP_TYPE.encodeBegin(arg0);
	}



	public void encodeChildren(FacesContext arg0) throws IOException {
		CACS_SETUP_TYPE.encodeChildren(arg0);
	}



	public void encodeEnd(FacesContext arg0) throws IOException {
		CACS_SETUP_TYPE.encodeEnd(arg0);
	}



	public UIComponent findComponent(String arg0) {
		return CACS_SETUP_TYPE.findComponent(arg0);
	}



	public Map<String, Object> getAttributes() {
		return CACS_SETUP_TYPE.getAttributes();
	}



	public int getChildCount() {
		return CACS_SETUP_TYPE.getChildCount();
	}



	public List<UIComponent> getChildren() {
		return CACS_SETUP_TYPE.getChildren();
	}



	public String getClientId(FacesContext arg0) {
		return CACS_SETUP_TYPE.getClientId(arg0);
	}



	public UIComponent getFacet(String name) {
		return CACS_SETUP_TYPE.getFacet(name);
	}



	public int getFacetCount() {
		return CACS_SETUP_TYPE.getFacetCount();
	}



	public Map<String, UIComponent> getFacets() {
		return CACS_SETUP_TYPE.getFacets();
	}



	public Iterator<UIComponent> getFacetsAndChildren() {
		return CACS_SETUP_TYPE.getFacetsAndChildren();
	}



	public String getId() {
		return CACS_SETUP_TYPE.getId();
	}



	public UIComponent getParent() {
		return CACS_SETUP_TYPE.getParent();
	}



	public String getRendererType() {
		return CACS_SETUP_TYPE.getRendererType();
	}



	public boolean getRendersChildren() {
		return CACS_SETUP_TYPE.getRendersChildren();
	}



	public ValueBinding getValueBinding(String name) {
		return CACS_SETUP_TYPE.getValueBinding(name);
	}



	public boolean invokeOnComponent(FacesContext context, String clientId,
			ContextCallback callback) throws FacesException {
		return CACS_SETUP_TYPE.invokeOnComponent(context, clientId, callback);
	}



	public boolean isRendered() {
		return CACS_SETUP_TYPE.isRendered();
	}



	public boolean isTransient() {
		return CACS_SETUP_TYPE.isTransient();
	}



	public void processRestoreState(FacesContext arg0, Object arg1) {
		CACS_SETUP_TYPE.processRestoreState(arg0, arg1);
	}



	public Object processSaveState(FacesContext arg0) {
		return CACS_SETUP_TYPE.processSaveState(arg0);
	}



	public void queueEvent(FacesEvent event) {
		CACS_SETUP_TYPE.queueEvent(event);
	}



	public void setId(String id) {
		CACS_SETUP_TYPE.setId(id);
	}



	public void setParent(UIComponent parent) {
		CACS_SETUP_TYPE.setParent(parent);
	}



	public void setRendered(boolean rendered) {
		CACS_SETUP_TYPE.setRendered(rendered);
	}



	public void setRendererType(String rendererType) {
		CACS_SETUP_TYPE.setRendererType(rendererType);
	}



	public void setTransient(boolean transientFlag) {
		CACS_SETUP_TYPE.setTransient(transientFlag);
	}



	public void setValueBinding(String arg0, ValueBinding arg1) {
		CACS_SETUP_TYPE.setValueBinding(arg0, arg1);
	}



	public void encodeAll(FacesContext arg0) throws IOException {
		CACS_SETUP_TYPE.encodeAll(arg0);
	}



	public String getContainerClientId(FacesContext context) {
		return CACS_SETUP_TYPE.getContainerClientId(context);
	}



	public ValueExpression getValueExpression(String arg0) {
		return CACS_SETUP_TYPE.getValueExpression(arg0);
	}



	public void setValueExpression(String arg0, ValueExpression arg1) {
		CACS_SETUP_TYPE.setValueExpression(arg0, arg1);
	}



	public boolean equals(Object arg0) {
		return CACS_SETUP_TYPE.equals(arg0);
	}



	public int hashCode() {
		return CACS_SETUP_TYPE.hashCode();
	}



	public String toString() {
		return CACS_SETUP_TYPE.toString();
	}*/
	
	public String updateButtonAction(String rowId) {
		PM_IL_CODES_ACCOUNT_SETUP_ACTION action;
		String outcome = null;
		try {
			action = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
			CommonUtils.setGlobalObject("PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP_ACTION",
					action);
			action.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setROWID(rowId);
			outcome = "GO_TO_PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
    }

    public String insertButtonAction() {
    	PM_IL_CODES_ACCOUNT_SETUP_ACTION action;
    	String outcome = null;
		try {
			action = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
			CommonUtils.setGlobalObject("PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP_ACTION",
					action);
			outcome = "GO_TO_PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outcome;
    }
	

	
}

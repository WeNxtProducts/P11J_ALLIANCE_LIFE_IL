package com.iii.pel.forms.PP_LIST_ITEM;

import java.util.ArrayList;

import com.iii.pel.forms.PILM072_APAC.PILM072_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LIST_ITEM_SEARCH_ACTION extends CommonAction{
	
	private String UI_DATA;
	private ArrayList<PP_LIST_ITEM> DATA;
	
	// Filter backing
	private String LI_MODULE_NAME;
	private String LI_BLOCK_NAME;
	private String LI_ITEM_NAME;
	private String LI_SYS_PARAM;
	private String LI_REMARKS;
	
	// Search Criteria
	private String LI_MODULE_NAME_SEARCH;
	private String LI_BLOCK_NAME_SEARCH;
	private String LI_ITEM_NAME_SEARCH;
	
	public PP_LIST_ITEM_SEARCH_ACTION(){
		
	}
	public String getUI_DATA() {
		return UI_DATA;
	}
	public void setUI_DATA(String ui_data) {
		UI_DATA = ui_data;
	}
	public ArrayList<PP_LIST_ITEM> getDATA() {
		return DATA;
	}
	public void setDATA(ArrayList<PP_LIST_ITEM> data) {
		DATA = data;
	}
	public String getLI_MODULE_NAME() {
		return LI_MODULE_NAME;
	}
	public void setLI_MODULE_NAME(String li_module_name) {
		LI_MODULE_NAME = li_module_name;
	}
	public String getLI_BLOCK_NAME() {
		return LI_BLOCK_NAME;
	}
	public void setLI_BLOCK_NAME(String li_block_name) {
		LI_BLOCK_NAME = li_block_name;
	}
	public String getLI_ITEM_NAME() {
		return LI_ITEM_NAME;
	}
	public void setLI_ITEM_NAME(String li_item_name) {
		LI_ITEM_NAME = li_item_name;
	}
	public String getLI_SYS_PARAM() {
		return LI_SYS_PARAM;
	}
	public void setLI_SYS_PARAM(String li_sys_param) {
		LI_SYS_PARAM = li_sys_param;
	}
	public String getLI_REMARKS() {
		return LI_REMARKS;
	}
	public void setLI_REMARKS(String li_remarks) {
		LI_REMARKS = li_remarks;
	}
	public String getLI_MODULE_NAME_SEARCH() {
		return LI_MODULE_NAME_SEARCH;
	}
	public void setLI_MODULE_NAME_SEARCH(String li_module_name_search) {
		LI_MODULE_NAME_SEARCH = li_module_name_search;
	}
	public String getLI_BLOCK_NAME_SEARCH() {
		return LI_BLOCK_NAME_SEARCH;
	}
	public void setLI_BLOCK_NAME_SEARCH(String li_block_name_search) {
		LI_BLOCK_NAME_SEARCH = li_block_name_search;
	}
	public String getLI_ITEM_NAME_SEARCH() {
		return LI_ITEM_NAME_SEARCH;
	}
	public void setLI_ITEM_NAME_SEARCH(String li_item_name_search) {
		LI_ITEM_NAME_SEARCH = li_item_name_search;
	}

	public String fetchListItem(){
		PP_LIST_ITEM_DELEGATE delegate = new PP_LIST_ITEM_DELEGATE();
		DATA = delegate.fetchSearchListItem(this);
		if(DATA.size() == 0){
			getWarningMap().put("current", Messages.getString("messageProperties_PP_LIST_ITEM", "PP_LIST_ITEM_ACTION$SEARCH$NORECORD$MESSAGE"));
		}else{
			getWarningMap().clear();
		}
		return null;
	}
	
	public String redirectToListItem() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		PP_LIST_ITEM_ACTION listItemAction = (PP_LIST_ITEM_ACTION) commonUtils
			.getMappedBeanFromSession("PP_LIST_ITEM_ACTION");
		
		// Clearing maps for previous messages
		listItemAction.getErrorMap().clear();
		listItemAction.getWarningMap().clear();
		
		return "ListItem";
	}
	
	public String createNewListItem() {
		/*CommonUtils commonUtils = new CommonUtils();
		PP_LIST_ITEM_ACTION listItemAction = (PP_LIST_ITEM_ACTION) commonUtils
			.getMappedBeanFromSession("PP_LIST_ITEM_ACTION");
		listItemAction.resetAllValues();*/
		
		// Resting session object
		PP_LIST_ITEM_ACTION listItemAction = new PP_LIST_ITEM_ACTION();
		CommonUtils.setGlobalObject("PP_LIST_ITEM_ACTION", listItemAction);
		
		return "CreateNewListItem";
	}
	
	
	public String updateButtonAction(String rowId) {
		CommonUtils commonUtils = new CommonUtils();
		String outcome = null;
		PP_LIST_ITEM_ACTION listItemAction = new PP_LIST_ITEM_ACTION();
		CommonUtils.setGlobalObject("PP_LIST_ITEM_ACTION",listItemAction);
		listItemAction.getPP_LIST_ITEM_BEAN().setROWID(rowId);
		outcome = "PP_LIST_ITEM_PP_LIST_ITEM_VALUES";
		return outcome;
	}

	public String insertButtonAction() {
		PP_LIST_ITEM_ACTION compositeAction = new PP_LIST_ITEM_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PP_LIST_ITEM_ACTION",
				compositeAction);
		outcome = "PP_LIST_ITEM_PP_LIST_ITEM_VALUES";
		return outcome;

	}

}

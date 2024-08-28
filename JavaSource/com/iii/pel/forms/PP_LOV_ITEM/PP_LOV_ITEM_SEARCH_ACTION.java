package com.iii.pel.forms.PP_LOV_ITEM;

import java.util.ArrayList;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LOV_ITEM_SEARCH_ACTION extends CommonAction{
	
	private String UI_DATA;
	private ArrayList<PP_LOV_ITEM> DATA;
	
	// Filter backing
	private String PLD_PROG_CODE;
	private String PLD_BLOCK_NAME;
	private String PLD_FIELD_NAME;
	private String PLD_LOV_TITLE;
	
	// Search Criteria
	private String PLD_PROG_CODE_SEARCH;
	private String PLD_BLOCK_NAME_SEARCH;
	private String PLD_FIELD_NAME_SEARCH;
	
	public PP_LOV_ITEM_SEARCH_ACTION(){
		
	}

	public String getUI_DATA() {
		return UI_DATA;
	}

	public void setUI_DATA(String ui_data) {
		UI_DATA = ui_data;
	}

	public ArrayList<PP_LOV_ITEM> getDATA() {
		return DATA;
	}

	public void setDATA(ArrayList<PP_LOV_ITEM> data) {
		DATA = data;
	}

	public String getPLD_PROG_CODE() {
		return PLD_PROG_CODE;
	}

	public void setPLD_PROG_CODE(String pld_prog_code) {
		PLD_PROG_CODE = pld_prog_code;
	}

	public String getPLD_BLOCK_NAME() {
		return PLD_BLOCK_NAME;
	}

	public void setPLD_BLOCK_NAME(String pld_block_name) {
		PLD_BLOCK_NAME = pld_block_name;
	}

	public String getPLD_FIELD_NAME() {
		return PLD_FIELD_NAME;
	}

	public void setPLD_FIELD_NAME(String pld_field_name) {
		PLD_FIELD_NAME = pld_field_name;
	}

	public String getPLD_LOV_TITLE() {
		return PLD_LOV_TITLE;
	}

	public void setPLD_LOV_TITLE(String pld_lov_title) {
		PLD_LOV_TITLE = pld_lov_title;
	}

	public String getPLD_PROG_CODE_SEARCH() {
		return PLD_PROG_CODE_SEARCH;
	}

	public void setPLD_PROG_CODE_SEARCH(String pld_prog_code_search) {
		PLD_PROG_CODE_SEARCH = pld_prog_code_search;
	}

	public String getPLD_BLOCK_NAME_SEARCH() {
		return PLD_BLOCK_NAME_SEARCH;
	}

	public void setPLD_BLOCK_NAME_SEARCH(String pld_block_name_search) {
		PLD_BLOCK_NAME_SEARCH = pld_block_name_search;
	}

	public String getPLD_FIELD_NAME_SEARCH() {
		return PLD_FIELD_NAME_SEARCH;
	}

	public void setPLD_FIELD_NAME_SEARCH(String pld_field_name_search) {
		PLD_FIELD_NAME_SEARCH = pld_field_name_search;
	}
	
	public String fetchSearchList(){
		PP_LOV_ITEM_DELEGATE delegate = new PP_LOV_ITEM_DELEGATE();
		DATA = delegate.fetchlovList(this);
		if (DATA.size() == 0) {
			getWarningMap().put("current",
					Messages.getString("messageProperties_PP_LOV_ITEM",

					"PGIM_LOV_DEFN$SEARCH$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
		return null;
	}
	
	public String redirectTolovDtls() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		PP_LOV_ITEM_ACTION PP_LOV_ITEM_ACTION = (PP_LOV_ITEM_ACTION) commonUtils
			.getMappedBeanFromSession("PP_LOV_ITEM_ACTION");
		PP_LOV_ITEM_ACTION.getErrorMap().clear();
		PP_LOV_ITEM_ACTION.getWarningMap().clear();
		PP_LOV_ITEM_ACTION.onLoading();
			return "lovDetails";
		}
	
	public String createNewlov() {
		/*CommonUtils commonUtils = new CommonUtils();
		getErrorMap().clear();
		getWarningMap().clear();
		PP_LOV_ITEM_ACTION PP_LOV_ITEM_ACTION = (PP_LOV_ITEM_ACTION) commonUtils
			.getMappedBeanFromSession("PP_LOV_ITEM_ACTION");
		PP_LOV_ITEM_ACTION.resetValues();*/
		
		// Restting action in session
		CommonUtils.setGlobalObject("PP_LOV_ITEM_ACTION", new PP_LOV_ITEM_ACTION());
		
		return "NewRecord";
		
	}
}

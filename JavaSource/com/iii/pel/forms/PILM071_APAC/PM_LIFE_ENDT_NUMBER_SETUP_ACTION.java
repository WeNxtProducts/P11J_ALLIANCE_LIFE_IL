package com.iii.pel.forms.PILM071_APAC;

import java.sql.Connection;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM024.PM_IL_CLM_ACCOUNT_SETUP_SEARCH;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LIFE_ENDT_NUMBER_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ENS_PREFIX_LABEL;

	private HtmlInputText COMP_ENS_PREFIX;

	private HtmlOutputLabel COMP_ENS_SUFFIX_LABEL;

	private HtmlInputText COMP_ENS_SUFFIX;

	private HtmlOutputLabel COMP_ENS_SEPARATOR_LABEL;

	private HtmlInputText COMP_ENS_SEPARATOR;

	private HtmlOutputLabel COMP_ENS_ZERO_PAD_LABEL;

	private HtmlInputText COMP_ENS_ZERO_PAD;

	private PM_LIFE_ENDT_NUMBER_SETUP PM_LIFE_ENDT_NUMBER_SETUP_BEAN;

	public PM_LIFE_ENDT_NUMBER_SETUP_ACTION() {
		PM_LIFE_ENDT_NUMBER_SETUP_BEAN = new PM_LIFE_ENDT_NUMBER_SETUP();
	}

	public HtmlOutputLabel getCOMP_ENS_PREFIX_LABEL() {
		return COMP_ENS_PREFIX_LABEL;
	}

	public HtmlInputText getCOMP_ENS_PREFIX() {
		return COMP_ENS_PREFIX;
	}

	public void setCOMP_ENS_PREFIX_LABEL(HtmlOutputLabel COMP_ENS_PREFIX_LABEL) {
		this.COMP_ENS_PREFIX_LABEL = COMP_ENS_PREFIX_LABEL;
	}

	public void setCOMP_ENS_PREFIX(HtmlInputText COMP_ENS_PREFIX) {
		this.COMP_ENS_PREFIX = COMP_ENS_PREFIX;
	}

	public HtmlOutputLabel getCOMP_ENS_SUFFIX_LABEL() {
		return COMP_ENS_SUFFIX_LABEL;
	}

	public HtmlInputText getCOMP_ENS_SUFFIX() {
		return COMP_ENS_SUFFIX;
	}

	public void setCOMP_ENS_SUFFIX_LABEL(HtmlOutputLabel COMP_ENS_SUFFIX_LABEL) {
		this.COMP_ENS_SUFFIX_LABEL = COMP_ENS_SUFFIX_LABEL;
	}

	public void setCOMP_ENS_SUFFIX(HtmlInputText COMP_ENS_SUFFIX) {
		this.COMP_ENS_SUFFIX = COMP_ENS_SUFFIX;
	}

	public HtmlOutputLabel getCOMP_ENS_SEPARATOR_LABEL() {
		return COMP_ENS_SEPARATOR_LABEL;
	}

	public HtmlInputText getCOMP_ENS_SEPARATOR() {
		return COMP_ENS_SEPARATOR;
	}

	public void setCOMP_ENS_SEPARATOR_LABEL(HtmlOutputLabel COMP_ENS_SEPARATOR_LABEL) {
		this.COMP_ENS_SEPARATOR_LABEL = COMP_ENS_SEPARATOR_LABEL;
	}

	public void setCOMP_ENS_SEPARATOR(HtmlInputText COMP_ENS_SEPARATOR) {
		this.COMP_ENS_SEPARATOR = COMP_ENS_SEPARATOR;
	}

	public HtmlOutputLabel getCOMP_ENS_ZERO_PAD_LABEL() {
		return COMP_ENS_ZERO_PAD_LABEL;
	}

	public HtmlInputText getCOMP_ENS_ZERO_PAD() {
		return COMP_ENS_ZERO_PAD;
	}

	public void setCOMP_ENS_ZERO_PAD_LABEL(HtmlOutputLabel COMP_ENS_ZERO_PAD_LABEL) {
		this.COMP_ENS_ZERO_PAD_LABEL = COMP_ENS_ZERO_PAD_LABEL;
	}

	public void setCOMP_ENS_ZERO_PAD(HtmlInputText COMP_ENS_ZERO_PAD) {
		this.COMP_ENS_ZERO_PAD = COMP_ENS_ZERO_PAD;
	}

	public PM_LIFE_ENDT_NUMBER_SETUP getPM_LIFE_ENDT_NUMBER_SETUP_BEAN() {
		return PM_LIFE_ENDT_NUMBER_SETUP_BEAN;
	}

	public void setPM_LIFE_ENDT_NUMBER_SETUP_BEAN(
			PM_LIFE_ENDT_NUMBER_SETUP pm_life_endt_number_setup_bean) {
		PM_LIFE_ENDT_NUMBER_SETUP_BEAN = pm_life_endt_number_setup_bean;
	}

	public String gotoPaymentDetails() {
		return "goToPymtDtls";
	}

	/*public void fetchEndNoDetails() {
		CommonUtils commonUtils = new CommonUtils();
		PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = (PM_LIFE_ENDT_NUMBER_SETUP_ACTION) commonUtils.getMappedBeanFromSession("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION");
		PILM071_APAC_DELEGATE delegate = new PILM071_APAC_DELEGATE();
		String rowId = action.getPM_LIFE_ENDT_NUMBER_SETUP_BEAN().getROWID();
		this.setPM_LIFE_ENDT_NUMBER_SETUP_BEAN(delegate.fetchEndNoDetails(rowId));
		
	}*/
	
	public String saveEndDetails() {
		CRUDHandler handler = new CRUDHandler();
		PILM071_APAC_DELEGATE delegate = new PILM071_APAC_DELEGATE();
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = getPM_LIFE_ENDT_NUMBER_SETUP_BEAN();
		PILM071_APAC_HELPER helper = new PILM071_APAC_HELPER();
		String rowId = null;
		String message = null;
		Connection con = null;
		int insert = 0;
		try {
			con = CommonUtils.getConnection();
			rowId = getPM_LIFE_ENDT_NUMBER_SETUP_BEAN().getROWID() ;
			if (rowId == null || rowId.trim().isEmpty()) {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
				//helper.when_create_record(valueBean);
				helper.pre_insert(valueBean);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				helper.pre_update(valueBean);
			}
			getErrorMap().clear();
			insert = delegate.updateLifeEndt(valueBean);
			
			if (insert == 1) {
				getWarningMap().put("current", message);
				getWarningMap().put("detail", message);
			}else{
				getWarningMap().put("current", "Could not insert / update record");
				getWarningMap().put("detail", "Could not insert / update record");
			}
			new CommonUtils().doComitt();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
		}
		return "";
		
	}
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
	public String gotoPrevious() {
		return "gotoPrevious";
	}
	
	public String deleteRecords() {
		CRUDHandler handler = new CRUDHandler();
		
		Connection connection = null;
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = getPM_LIFE_ENDT_NUMBER_SETUP_BEAN();
		try {
			connection = CommonUtils.getConnection();
			int delete = handler.executeDelete(valueBean, connection);
			if (delete == 1) {
				String message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete");
				getWarningMap().put("current", message);
				getWarningMap().put("detail", message);
				setPM_LIFE_ENDT_NUMBER_SETUP_BEAN(new PM_LIFE_ENDT_NUMBER_SETUP());
			}
		} catch (Exception e) {
		}
		return "";
		
	}
	public void onLoad(PhaseEvent event) {
		try {
				if (isBlockFlag()) {
				PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = new PM_LIFE_ENDT_NUMBER_SETUP_ACTION();
				if(PM_LIFE_ENDT_NUMBER_SETUP_BEAN.getROWID()!=null){
					fetchList();
					} else {
						newRecordAction();
					}
				setBlockFlag(false);
				}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void fetchList(){
		String value = "gotoMainScreen";
		CommonUtils commonUtils = new CommonUtils();
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = null;
		PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = (PM_LIFE_ENDT_NUMBER_SETUP_ACTION) commonUtils.getMappedBeanFromSession("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION");
		action.getWarningMap().clear();
		action.getErrorMap().clear();
		PILM071_APAC_DELEGATE delegate = new PILM071_APAC_DELEGATE();
		String rowId = action.getPM_LIFE_ENDT_NUMBER_SETUP_BEAN().getROWID();
		valueBean = delegate.fetchEndNoDetails(rowId);
		action.setPM_LIFE_ENDT_NUMBER_SETUP_BEAN(valueBean);
	}
	public void newRecordAction(){
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.clearMappedBeanFromSession("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION");
			
	}
}
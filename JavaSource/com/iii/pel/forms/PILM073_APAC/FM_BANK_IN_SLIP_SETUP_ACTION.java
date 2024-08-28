package com.iii.pel.forms.PILM073_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM065_APAC.PM_IL_ACCRUAL_SETUP;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class FM_BANK_IN_SLIP_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BISS_BANK_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BISS_BANK_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACNT_DESC;

	private HtmlOutputLabel COMP_BISS_PYMT_MODE_LABEL;

	private HtmlSelectOneMenu COMP_BISS_PYMT_MODE;

	private HtmlOutputLabel COMP_BISS_REF_NO_YN_LABEL;

	private HtmlSelectOneMenu COMP_BISS_REF_NO_YN;

	private HtmlOutputLabel COMP_BISS_AUTO_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_BISS_AUTO_GEN_YN;

	private HtmlOutputLabel COMP_BISS_BY_RECEIPT_LABEL;

	private HtmlSelectOneMenu COMP_BISS_BY_RECEIPT;

	private HtmlOutputLabel COMP_BISS_BY_PAY_MODE_LABEL;

	private HtmlSelectOneMenu COMP_BISS_BY_PAY_MODE;

	private HtmlOutputLabel COMP_BISS_FIN_YR_LABEL;

	private HtmlInputText COMP_BISS_FIN_YR;

	private HtmlOutputLabel COMP_BISS_PREFIX_LABEL;

	private HtmlInputText COMP_BISS_PREFIX;

	private HtmlOutputLabel COMP_BISS_SUFFIX_LABEL;

	private HtmlInputText COMP_BISS_SUFFIX;

	private HtmlOutputLabel COMP_BISS_PAD_YN_LABEL;

	private HtmlSelectOneMenu COMP_BISS_PAD_YN;

	private HtmlOutputLabel COMP_BISS_NO_DIG_PADDED_LABEL;

	private HtmlInputText COMP_BISS_NO_DIG_PADDED;

	private HtmlOutputLabel COMP_BISS_SEQ_START_NO_LABEL;

	private HtmlInputText COMP_BISS_SEQ_START_NO;

	private HtmlOutputLabel COMP_BISS_SEQ_END_NO_LABEL;

	private HtmlInputText COMP_BISS_SEQ_END_NO;

	private HtmlOutputLabel COMP_BISS_CURR_NO_LABEL;

	private HtmlInputText COMP_BISS_CURR_NO;

	private HtmlCommandButton COMP_UI_M_LOV_BAN_ACC_CODE;

	private FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN;

	public PILM073_APAC_COMPOSITE_ACTION compositeAction;

	private FM_BANK_IN_SLIP_SETUP_HELPER helper;

	private List<SelectItem> listBISS_PYMT_MODE = new ArrayList<SelectItem>();

	private List<SelectItem> listBISS_REF_NO_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listBISS_AUTO_GEN_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listBISS_BY_RECEIPT = new ArrayList<SelectItem>();

	private List<SelectItem> listBISS_BY_PAY_MODE = new ArrayList<SelectItem>();

	private List<SelectItem> listBISS_PAD_YN = new ArrayList<SelectItem>();

	public FM_BANK_IN_SLIP_SETUP_ACTION()  {
		FM_BANK_IN_SLIP_SETUP_BEAN = new FM_BANK_IN_SLIP_SETUP();
		helper = new FM_BANK_IN_SLIP_SETUP_HELPER();
		prepareDropDowns();
	}
	
	public void prepareDropDowns(){
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			setListBISS_PYMT_MODE(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_PYMT_MODE",
					null));
			
			setListBISS_BY_PAY_MODE(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_BY_PAY_MODE",
					null));
			
			setListBISS_BY_RECEIPT(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_BY_RECEIPT",
					null));
			
			setListBISS_PAD_YN(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_PAD_YN",
					null));

			setListBISS_REF_NO_YN(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_REF_NO_YN",
					null));

			setListBISS_AUTO_GEN_YN(ListItemUtil.getDropDownListValue_1(connection,
					"PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"FM_BANK_IN_SLIP_SETUP.BISS_AUTO_GEN_YN",
					null));

		}catch (Exception e) {
		}
	}
	
	CRUDHandler handler = new CRUDHandler();
	

	public HtmlOutputLabel getCOMP_BISS_BANK_ACNT_CODE_LABEL() {
		return COMP_BISS_BANK_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BISS_BANK_ACNT_CODE() {
		return COMP_BISS_BANK_ACNT_CODE;
	}

	public void setCOMP_BISS_BANK_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_BISS_BANK_ACNT_CODE_LABEL) {
		this.COMP_BISS_BANK_ACNT_CODE_LABEL = COMP_BISS_BANK_ACNT_CODE_LABEL;
	}

	public void setCOMP_BISS_BANK_ACNT_CODE(
			HtmlInputText COMP_BISS_BANK_ACNT_CODE) {
		this.COMP_BISS_BANK_ACNT_CODE = COMP_BISS_BANK_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACNT_DESC_LABEL() {
		return COMP_UI_M_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACNT_DESC() {
		return COMP_UI_M_ACNT_DESC;
	}

	public void setCOMP_UI_M_ACNT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ACNT_DESC_LABEL) {
		this.COMP_UI_M_ACNT_DESC_LABEL = COMP_UI_M_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACNT_DESC(HtmlInputText COMP_UI_M_ACNT_DESC) {
		this.COMP_UI_M_ACNT_DESC = COMP_UI_M_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_BISS_PYMT_MODE_LABEL() {
		return COMP_BISS_PYMT_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_PYMT_MODE() {
		return COMP_BISS_PYMT_MODE;
	}

	public void setCOMP_BISS_PYMT_MODE_LABEL(
			HtmlOutputLabel COMP_BISS_PYMT_MODE_LABEL) {
		this.COMP_BISS_PYMT_MODE_LABEL = COMP_BISS_PYMT_MODE_LABEL;
	}

	public void setCOMP_BISS_PYMT_MODE(HtmlSelectOneMenu COMP_BISS_PYMT_MODE) {
		this.COMP_BISS_PYMT_MODE = COMP_BISS_PYMT_MODE;
	}

	public HtmlOutputLabel getCOMP_BISS_REF_NO_YN_LABEL() {
		return COMP_BISS_REF_NO_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_REF_NO_YN() {
		return COMP_BISS_REF_NO_YN;
	}

	public void setCOMP_BISS_REF_NO_YN_LABEL(
			HtmlOutputLabel COMP_BISS_REF_NO_YN_LABEL) {
		this.COMP_BISS_REF_NO_YN_LABEL = COMP_BISS_REF_NO_YN_LABEL;
	}

	public void setCOMP_BISS_REF_NO_YN(HtmlSelectOneMenu COMP_BISS_REF_NO_YN) {
		this.COMP_BISS_REF_NO_YN = COMP_BISS_REF_NO_YN;
	}

	public HtmlOutputLabel getCOMP_BISS_AUTO_GEN_YN_LABEL() {
		return COMP_BISS_AUTO_GEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_AUTO_GEN_YN() {
		return COMP_BISS_AUTO_GEN_YN;
	}

	public void setCOMP_BISS_AUTO_GEN_YN_LABEL(
			HtmlOutputLabel COMP_BISS_AUTO_GEN_YN_LABEL) {
		this.COMP_BISS_AUTO_GEN_YN_LABEL = COMP_BISS_AUTO_GEN_YN_LABEL;
	}

	public void setCOMP_BISS_AUTO_GEN_YN(HtmlSelectOneMenu COMP_BISS_AUTO_GEN_YN) {
		this.COMP_BISS_AUTO_GEN_YN = COMP_BISS_AUTO_GEN_YN;
	}

	public HtmlOutputLabel getCOMP_BISS_BY_RECEIPT_LABEL() {
		return COMP_BISS_BY_RECEIPT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_BY_RECEIPT() {
		return COMP_BISS_BY_RECEIPT;
	}

	public void setCOMP_BISS_BY_RECEIPT_LABEL(
			HtmlOutputLabel COMP_BISS_BY_RECEIPT_LABEL) {
		this.COMP_BISS_BY_RECEIPT_LABEL = COMP_BISS_BY_RECEIPT_LABEL;
	}

	public void setCOMP_BISS_BY_RECEIPT(HtmlSelectOneMenu COMP_BISS_BY_RECEIPT) {
		this.COMP_BISS_BY_RECEIPT = COMP_BISS_BY_RECEIPT;
	}

	public HtmlOutputLabel getCOMP_BISS_BY_PAY_MODE_LABEL() {
		return COMP_BISS_BY_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_BY_PAY_MODE() {
		return COMP_BISS_BY_PAY_MODE;
	}

	public void setCOMP_BISS_BY_PAY_MODE_LABEL(
			HtmlOutputLabel COMP_BISS_BY_PAY_MODE_LABEL) {
		this.COMP_BISS_BY_PAY_MODE_LABEL = COMP_BISS_BY_PAY_MODE_LABEL;
	}

	public void setCOMP_BISS_BY_PAY_MODE(HtmlSelectOneMenu COMP_BISS_BY_PAY_MODE) {
		this.COMP_BISS_BY_PAY_MODE = COMP_BISS_BY_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_BISS_FIN_YR_LABEL() {
		return COMP_BISS_FIN_YR_LABEL;
	}

	public HtmlInputText getCOMP_BISS_FIN_YR() {
		return COMP_BISS_FIN_YR;
	}

	public void setCOMP_BISS_FIN_YR_LABEL(HtmlOutputLabel COMP_BISS_FIN_YR_LABEL) {
		this.COMP_BISS_FIN_YR_LABEL = COMP_BISS_FIN_YR_LABEL;
	}

	public void setCOMP_BISS_FIN_YR(HtmlInputText COMP_BISS_FIN_YR) {
		this.COMP_BISS_FIN_YR = COMP_BISS_FIN_YR;
	}

	public HtmlOutputLabel getCOMP_BISS_PREFIX_LABEL() {
		return COMP_BISS_PREFIX_LABEL;
	}

	public HtmlInputText getCOMP_BISS_PREFIX() {
		return COMP_BISS_PREFIX;
	}

	public void setCOMP_BISS_PREFIX_LABEL(HtmlOutputLabel COMP_BISS_PREFIX_LABEL) {
		this.COMP_BISS_PREFIX_LABEL = COMP_BISS_PREFIX_LABEL;
	}

	public void setCOMP_BISS_PREFIX(HtmlInputText COMP_BISS_PREFIX) {
		this.COMP_BISS_PREFIX = COMP_BISS_PREFIX;
	}

	public HtmlOutputLabel getCOMP_BISS_SUFFIX_LABEL() {
		return COMP_BISS_SUFFIX_LABEL;
	}

	public HtmlInputText getCOMP_BISS_SUFFIX() {
		return COMP_BISS_SUFFIX;
	}

	public void setCOMP_BISS_SUFFIX_LABEL(HtmlOutputLabel COMP_BISS_SUFFIX_LABEL) {
		this.COMP_BISS_SUFFIX_LABEL = COMP_BISS_SUFFIX_LABEL;
	}

	public void setCOMP_BISS_SUFFIX(HtmlInputText COMP_BISS_SUFFIX) {
		this.COMP_BISS_SUFFIX = COMP_BISS_SUFFIX;
	}

	public HtmlOutputLabel getCOMP_BISS_PAD_YN_LABEL() {
		return COMP_BISS_PAD_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BISS_PAD_YN() {
		return COMP_BISS_PAD_YN;
	}

	public void setCOMP_BISS_PAD_YN_LABEL(HtmlOutputLabel COMP_BISS_PAD_YN_LABEL) {
		this.COMP_BISS_PAD_YN_LABEL = COMP_BISS_PAD_YN_LABEL;
	}

	public void setCOMP_BISS_PAD_YN(HtmlSelectOneMenu COMP_BISS_PAD_YN) {
		this.COMP_BISS_PAD_YN = COMP_BISS_PAD_YN;
	}

	public HtmlOutputLabel getCOMP_BISS_NO_DIG_PADDED_LABEL() {
		return COMP_BISS_NO_DIG_PADDED_LABEL;
	}

	public HtmlInputText getCOMP_BISS_NO_DIG_PADDED() {
		return COMP_BISS_NO_DIG_PADDED;
	}

	public void setCOMP_BISS_NO_DIG_PADDED_LABEL(
			HtmlOutputLabel COMP_BISS_NO_DIG_PADDED_LABEL) {
		this.COMP_BISS_NO_DIG_PADDED_LABEL = COMP_BISS_NO_DIG_PADDED_LABEL;
	}

	public void setCOMP_BISS_NO_DIG_PADDED(HtmlInputText COMP_BISS_NO_DIG_PADDED) {
		this.COMP_BISS_NO_DIG_PADDED = COMP_BISS_NO_DIG_PADDED;
	}

	public HtmlOutputLabel getCOMP_BISS_SEQ_START_NO_LABEL() {
		return COMP_BISS_SEQ_START_NO_LABEL;
	}

	public HtmlInputText getCOMP_BISS_SEQ_START_NO() {
		return COMP_BISS_SEQ_START_NO;
	}

	public void setCOMP_BISS_SEQ_START_NO_LABEL(
			HtmlOutputLabel COMP_BISS_SEQ_START_NO_LABEL) {
		this.COMP_BISS_SEQ_START_NO_LABEL = COMP_BISS_SEQ_START_NO_LABEL;
	}

	public void setCOMP_BISS_SEQ_START_NO(HtmlInputText COMP_BISS_SEQ_START_NO) {
		this.COMP_BISS_SEQ_START_NO = COMP_BISS_SEQ_START_NO;
	}

	public HtmlOutputLabel getCOMP_BISS_SEQ_END_NO_LABEL() {
		return COMP_BISS_SEQ_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_BISS_SEQ_END_NO() {
		return COMP_BISS_SEQ_END_NO;
	}

	public void setCOMP_BISS_SEQ_END_NO_LABEL(
			HtmlOutputLabel COMP_BISS_SEQ_END_NO_LABEL) {
		this.COMP_BISS_SEQ_END_NO_LABEL = COMP_BISS_SEQ_END_NO_LABEL;
	}

	public void setCOMP_BISS_SEQ_END_NO(HtmlInputText COMP_BISS_SEQ_END_NO) {
		this.COMP_BISS_SEQ_END_NO = COMP_BISS_SEQ_END_NO;
	}

	public HtmlOutputLabel getCOMP_BISS_CURR_NO_LABEL() {
		return COMP_BISS_CURR_NO_LABEL;
	}

	public HtmlInputText getCOMP_BISS_CURR_NO() {
		return COMP_BISS_CURR_NO;
	}

	public void setCOMP_BISS_CURR_NO_LABEL(
			HtmlOutputLabel COMP_BISS_CURR_NO_LABEL) {
		this.COMP_BISS_CURR_NO_LABEL = COMP_BISS_CURR_NO_LABEL;
	}

	public void setCOMP_BISS_CURR_NO(HtmlInputText COMP_BISS_CURR_NO) {
		this.COMP_BISS_CURR_NO = COMP_BISS_CURR_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BAN_ACC_CODE() {
		return COMP_UI_M_LOV_BAN_ACC_CODE;
	}

	public void setCOMP_UI_M_LOV_BAN_ACC_CODE(
			HtmlCommandButton COMP_UI_M_LOV_BAN_ACC_CODE) {
		this.COMP_UI_M_LOV_BAN_ACC_CODE = COMP_UI_M_LOV_BAN_ACC_CODE;
	}

	public FM_BANK_IN_SLIP_SETUP getFM_BANK_IN_SLIP_SETUP_BEAN() {
		return FM_BANK_IN_SLIP_SETUP_BEAN;
	}

	public void setFM_BANK_IN_SLIP_SETUP_BEAN(
			FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN) {
		this.FM_BANK_IN_SLIP_SETUP_BEAN = FM_BANK_IN_SLIP_SETUP_BEAN;
	}


	public List<SelectItem> getListBISS_PYMT_MODE() {
		if (listBISS_PYMT_MODE.size() == 0) {
			listBISS_PYMT_MODE.clear();
			try {
				listBISS_PYMT_MODE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_PYMT_MODE;
	}

	public void setListBISS_PYMT_MODE(List<SelectItem> listBISS_PYMT_MODE) {
		this.listBISS_PYMT_MODE = listBISS_PYMT_MODE;
	}

	public List<SelectItem> getListBISS_REF_NO_YN() {
		if (listBISS_REF_NO_YN.size() == 0) {
			listBISS_REF_NO_YN.clear();
			try {
				listBISS_REF_NO_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_REF_NO_YN;
	}

	public void setListBISS_REF_NO_YN(List<SelectItem> listBISS_REF_NO_YN) {
		this.listBISS_REF_NO_YN = listBISS_REF_NO_YN;
	}

	public List<SelectItem> getListBISS_AUTO_GEN_YN() {
		if (listBISS_AUTO_GEN_YN.size() == 0) {
			listBISS_AUTO_GEN_YN.clear();
			try {
				listBISS_AUTO_GEN_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_AUTO_GEN_YN;
	}

	public void setListBISS_AUTO_GEN_YN(List<SelectItem> listBISS_AUTO_GEN_YN) {
		this.listBISS_AUTO_GEN_YN = listBISS_AUTO_GEN_YN;
	}

	public List<SelectItem> getListBISS_BY_RECEIPT() {
		if (listBISS_BY_RECEIPT.size() == 0) {
			listBISS_BY_RECEIPT.clear();
			try {
				listBISS_BY_RECEIPT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_BY_RECEIPT;
	}

	public void setListBISS_BY_RECEIPT(List<SelectItem> listBISS_BY_RECEIPT) {
		this.listBISS_BY_RECEIPT = listBISS_BY_RECEIPT;
	}

	public List<SelectItem> getListBISS_BY_PAY_MODE() {
		if (listBISS_BY_PAY_MODE.size() == 0) {
			listBISS_BY_PAY_MODE.clear();
			try {
				listBISS_BY_PAY_MODE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_BY_PAY_MODE;
	}

	public void setListBISS_BY_PAY_MODE(List<SelectItem> listBISS_BY_PAY_MODE) {
		this.listBISS_BY_PAY_MODE = listBISS_BY_PAY_MODE;
	}

	public List<SelectItem> getListBISS_PAD_YN() {
		if (listBISS_PAD_YN.size() == 0) {
			listBISS_PAD_YN.clear();
			try {
				listBISS_PAD_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBISS_PAD_YN;
	}

	public void setListBISS_PAD_YN(List<SelectItem> listBISS_PAD_YN) {
		this.listBISS_PAD_YN = listBISS_PAD_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event)throws Exception {
		FM_BANK_IN_SLIP_SETUP_DELEGATE delegate = new FM_BANK_IN_SLIP_SETUP_DELEGATE();
		try {
			if (isBlockFlag()) {
				delegate.executeSelectStatement(compositeAction);
				if (FM_BANK_IN_SLIP_SETUP_BEAN.getROWID() != null) {
					helper.postQuery(FM_BANK_IN_SLIP_SETUP_BEAN);
				}else{
					helper.whenCreateRecord(FM_BANK_IN_SLIP_SETUP_BEAN);
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

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	
	public ArrayList<LovBean> BISS_BANK_ACNT_CODE_KEY_LISTVAL(Object currValue) {
		
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM073_APAC", 
					"FM_BANK_IN_SLIP_SETUP", 
					"BISS_BANK_ACNT_CODE",
					null, null,	null, null,	null, 
					(String) currValue);
			System.out.println(" LIST " + suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public String deleteRecord() {
		Connection connection = null;
		try {
			new CRUDHandler().executeDelete(getFM_BANK_IN_SLIP_SETUP_BEAN(),
					CommonUtils.getConnection());
			FM_BANK_IN_SLIP_SETUP_BEAN = new FM_BANK_IN_SLIP_SETUP();
			helper.whenCreateRecord(FM_BANK_IN_SLIP_SETUP_BEAN);
			getWarningMap().put("deleteRow",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
		return "";
	}
	
	
	public void saveRecord() {
		String message = "";
		try {
			CommonUtils.clearMaps(this);
			if (getFM_BANK_IN_SLIP_SETUP_BEAN().getROWID() != null) {
				helper.preInsert(FM_BANK_IN_SLIP_SETUP_BEAN);
				new CRUDHandler().executeUpdate(getFM_BANK_IN_SLIP_SETUP_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			} else {
				helper.preInsert(FM_BANK_IN_SLIP_SETUP_BEAN);
				new CRUDHandler().executeInsert(getFM_BANK_IN_SLIP_SETUP_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save");
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void validateBankAccCode(FacesContext context, UIComponent component,
	Object value){
		try {
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BANK_ACNT_CODE((String) value);
			helper.whenValidateBISS_BANK_ACNT_CODE(FM_BANK_IN_SLIP_SETUP_BEAN);
			COMP_UI_M_ACNT_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateBISS_PAD_YN(FacesContext context, UIComponent component,
			Object value){
				try {
					FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PAD_YN((String) value);
					if("Y".equals(FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_PAD_YN())){
						COMP_BISS_NO_DIG_PADDED.setDisabled(false);
						COMP_BISS_NO_DIG_PADDED.setRequired(true);
					}else{
						COMP_BISS_NO_DIG_PADDED.setDisabled(true);
						COMP_BISS_NO_DIG_PADDED.setRequired(false);
					}
					COMP_BISS_NO_DIG_PADDED.resetValue();
				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}
			}


}

package com.iii.pel.forms.PM078_A;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LIFE_WAKALAH_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_WAKS_COVER_CODE_LABEL;

	private HtmlInputText COMP_WAKS_COVER_CODE;

	private HtmlOutputLabel COMP_WAKS_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_WAKS_EFF_FM_DT;

	private HtmlOutputLabel COMP_WAKS_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_WAKS_EFF_TO_DT;

	private HtmlOutputLabel COMP_WAKS_EXP_CALC_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_EXP_CALC_MTHD;

	private HtmlOutputLabel COMP_WAKS_EXPENSE_PERC_LABEL;

	private HtmlInputText COMP_WAKS_EXPENSE_PERC;

	private HtmlOutputLabel COMP_WAKS_RISK_CALC_MTHD_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_RISK_CALC_MTHD;

	private HtmlOutputLabel COMP_WAKS_CHARGE_MODE_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_CHARGE_MODE;

	private HtmlOutputLabel COMP_WAKS_PRO_ON_INVEST_LABEL;

	private HtmlInputText COMP_WAKS_PRO_ON_INVEST;

	private HtmlOutputLabel COMP_WAKS_ZERO_PREM_YN_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_ZERO_PREM_YN;

	private HtmlOutputLabel COMP_WAKS_RISK_LOAD_YN_LABEL;

	private HtmlSelectOneMenu COMP_WAKS_RISK_LOAD_YN;

	private HtmlOutputLabel COMP_UI_M_WAKS_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WAKS_COVER_CODE;

	private HtmlOutputLabel COMP_WAKS_SPL_FUND_LABEL;

	private HtmlInputText COMP_WAKS_SPL_FUND;

	private HtmlOutputLabel COMP_WAKS_ADMIN_CHARGES_LABEL;

	private HtmlInputText COMP_WAKS_ADMIN_CHARGES;

	private HtmlOutputLabel COMP_WAKS_PAR_SHARE_OF_SUR_LABEL;

	private HtmlInputText COMP_WAKS_PAR_SHARE_OF_SUR;

	private HtmlOutputLabel COMP_WAKS_INV_PROFIT_SHARE_LABEL;

	private HtmlInputText COMP_WAKS_INV_PROFIT_SHARE;

	private HtmlCommandButton COMP_UI_M_LOV_SUBCLASS;

	private HtmlCommandButton COMP_UI_M_LOV_WAKS_COVER_CODE;

	private PM_LIFE_WAKALAH_SETUP PM_LIFE_WAKALAH_SETUP_BEAN;

	private PM_LIFE_WAKALAH_HDR PM_LIFE_WAKALAH_HDR_BEAN;

	public PM078_A_COMPOSITE_ACTION compositeAction;

	private PM_LIFE_WAKALAH_SETUP_HELPER helper;

	private PM_LIFE_WAKALAH_SETUP_DELEGATE delegate = null;

	private List<PM_LIFE_WAKALAH_SETUP> dataList_PM_LIFE_WAKALAH_SETUP = 
		new ArrayList<PM_LIFE_WAKALAH_SETUP>();

		private UIData dataTable;

		private List<SelectItem> listWAKS_EXP_CALC_MTHD = new ArrayList<SelectItem>();

		private List<SelectItem> listWAKS_RISK_CALC_MTHD = new ArrayList<SelectItem>();

		private List<SelectItem> listWAKS_CHARGE_MODE = new ArrayList<SelectItem>();

		private List<SelectItem> listWAKS_ZERO_PREM_YN = new ArrayList<SelectItem>();

		private List<SelectItem> listWAKS_RISK_LOAD_YN = new ArrayList<SelectItem>();

		ArrayList<LovBean> lovList = new ArrayList<LovBean>();

		
		/*added by janani on 10.2.2016*/
		
		private HtmlOutputLabel COMP_WAKS_FIXED_AMT_LABEL;

		private HtmlInputText COMP_WAKS_FIXED_AMT; 
		
		
		public HtmlOutputLabel getCOMP_WAKS_FIXED_AMT_LABEL() {
			return COMP_WAKS_FIXED_AMT_LABEL;
		}

		public void setCOMP_WAKS_FIXED_AMT_LABEL(
				HtmlOutputLabel cOMP_WAKS_FIXED_AMT_LABEL) {
			COMP_WAKS_FIXED_AMT_LABEL = cOMP_WAKS_FIXED_AMT_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_FIXED_AMT() {
			return COMP_WAKS_FIXED_AMT;
		}

		public void setCOMP_WAKS_FIXED_AMT(HtmlInputText cOMP_WAKS_FIXED_AMT) {
			COMP_WAKS_FIXED_AMT = cOMP_WAKS_FIXED_AMT;
		}
		
		/*end*/
		
		public PM_LIFE_WAKALAH_SETUP_ACTION(){

			PM_LIFE_WAKALAH_SETUP_BEAN = new PM_LIFE_WAKALAH_SETUP();
			helper = new PM_LIFE_WAKALAH_SETUP_HELPER();
			delegate = new PM_LIFE_WAKALAH_SETUP_DELEGATE();
			getListWAKS_CHARGE_MODE();
			getListWAKS_EXP_CALC_MTHD();
			getListWAKS_RISK_CALC_MTHD();
			getListWAKS_RISK_LOAD_YN();
			getListWAKS_ZERO_PREM_YN();
			
		}

		public HtmlOutputLabel getCOMP_WAKS_COVER_CODE_LABEL() {
			return COMP_WAKS_COVER_CODE_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_COVER_CODE() {
			return COMP_WAKS_COVER_CODE;
		}

		public void setCOMP_WAKS_COVER_CODE_LABEL(HtmlOutputLabel COMP_WAKS_COVER_CODE_LABEL) {
			this.COMP_WAKS_COVER_CODE_LABEL = COMP_WAKS_COVER_CODE_LABEL;
		}

		public void setCOMP_WAKS_COVER_CODE(HtmlInputText COMP_WAKS_COVER_CODE) {
			this.COMP_WAKS_COVER_CODE = COMP_WAKS_COVER_CODE;
		}

		public HtmlOutputLabel getCOMP_WAKS_EFF_FM_DT_LABEL() {
			return COMP_WAKS_EFF_FM_DT_LABEL;
		}

		public HtmlCalendar getCOMP_WAKS_EFF_FM_DT() {
			return COMP_WAKS_EFF_FM_DT;
		}

		public void setCOMP_WAKS_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_WAKS_EFF_FM_DT_LABEL) {
			this.COMP_WAKS_EFF_FM_DT_LABEL = COMP_WAKS_EFF_FM_DT_LABEL;
		}

		public void setCOMP_WAKS_EFF_FM_DT(HtmlCalendar COMP_WAKS_EFF_FM_DT) {
			this.COMP_WAKS_EFF_FM_DT = COMP_WAKS_EFF_FM_DT;
		}

		public HtmlOutputLabel getCOMP_WAKS_EFF_TO_DT_LABEL() {
			return COMP_WAKS_EFF_TO_DT_LABEL;
		}

		public HtmlCalendar getCOMP_WAKS_EFF_TO_DT() {
			return COMP_WAKS_EFF_TO_DT;
		}

		public void setCOMP_WAKS_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_WAKS_EFF_TO_DT_LABEL) {
			this.COMP_WAKS_EFF_TO_DT_LABEL = COMP_WAKS_EFF_TO_DT_LABEL;
		}

		public void setCOMP_WAKS_EFF_TO_DT(HtmlCalendar COMP_WAKS_EFF_TO_DT) {
			this.COMP_WAKS_EFF_TO_DT = COMP_WAKS_EFF_TO_DT;
		}

		public HtmlOutputLabel getCOMP_WAKS_EXP_CALC_MTHD_LABEL() {
			return COMP_WAKS_EXP_CALC_MTHD_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_WAKS_EXP_CALC_MTHD() {
			return COMP_WAKS_EXP_CALC_MTHD;
		}

		public void setCOMP_WAKS_EXP_CALC_MTHD_LABEL(HtmlOutputLabel COMP_WAKS_EXP_CALC_MTHD_LABEL) {
			this.COMP_WAKS_EXP_CALC_MTHD_LABEL = COMP_WAKS_EXP_CALC_MTHD_LABEL;
		}

		public void setCOMP_WAKS_EXP_CALC_MTHD(HtmlSelectOneMenu COMP_WAKS_EXP_CALC_MTHD) {
			this.COMP_WAKS_EXP_CALC_MTHD = COMP_WAKS_EXP_CALC_MTHD;
		}

		public HtmlOutputLabel getCOMP_WAKS_EXPENSE_PERC_LABEL() {
			return COMP_WAKS_EXPENSE_PERC_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_EXPENSE_PERC() {
			return COMP_WAKS_EXPENSE_PERC;
		}

		public void setCOMP_WAKS_EXPENSE_PERC_LABEL(HtmlOutputLabel COMP_WAKS_EXPENSE_PERC_LABEL) {
			this.COMP_WAKS_EXPENSE_PERC_LABEL = COMP_WAKS_EXPENSE_PERC_LABEL;
		}

		public void setCOMP_WAKS_EXPENSE_PERC(HtmlInputText COMP_WAKS_EXPENSE_PERC) {
			this.COMP_WAKS_EXPENSE_PERC = COMP_WAKS_EXPENSE_PERC;
		}

		public HtmlOutputLabel getCOMP_WAKS_RISK_CALC_MTHD_LABEL() {
			return COMP_WAKS_RISK_CALC_MTHD_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_WAKS_RISK_CALC_MTHD() {
			return COMP_WAKS_RISK_CALC_MTHD;
		}

		public void setCOMP_WAKS_RISK_CALC_MTHD_LABEL(HtmlOutputLabel COMP_WAKS_RISK_CALC_MTHD_LABEL) {
			this.COMP_WAKS_RISK_CALC_MTHD_LABEL = COMP_WAKS_RISK_CALC_MTHD_LABEL;
		}

		public void setCOMP_WAKS_RISK_CALC_MTHD(HtmlSelectOneMenu COMP_WAKS_RISK_CALC_MTHD) {
			this.COMP_WAKS_RISK_CALC_MTHD = COMP_WAKS_RISK_CALC_MTHD;
		}

		public HtmlOutputLabel getCOMP_WAKS_CHARGE_MODE_LABEL() {
			return COMP_WAKS_CHARGE_MODE_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_WAKS_CHARGE_MODE() {
			return COMP_WAKS_CHARGE_MODE;
		}

		public void setCOMP_WAKS_CHARGE_MODE_LABEL(HtmlOutputLabel COMP_WAKS_CHARGE_MODE_LABEL) {
			this.COMP_WAKS_CHARGE_MODE_LABEL = COMP_WAKS_CHARGE_MODE_LABEL;
		}

		public void setCOMP_WAKS_CHARGE_MODE(HtmlSelectOneMenu COMP_WAKS_CHARGE_MODE) {
			this.COMP_WAKS_CHARGE_MODE = COMP_WAKS_CHARGE_MODE;
		}

		public HtmlOutputLabel getCOMP_WAKS_PRO_ON_INVEST_LABEL() {
			return COMP_WAKS_PRO_ON_INVEST_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_PRO_ON_INVEST() {
			return COMP_WAKS_PRO_ON_INVEST;
		}

		public void setCOMP_WAKS_PRO_ON_INVEST_LABEL(HtmlOutputLabel COMP_WAKS_PRO_ON_INVEST_LABEL) {
			this.COMP_WAKS_PRO_ON_INVEST_LABEL = COMP_WAKS_PRO_ON_INVEST_LABEL;
		}

		public void setCOMP_WAKS_PRO_ON_INVEST(HtmlInputText COMP_WAKS_PRO_ON_INVEST) {
			this.COMP_WAKS_PRO_ON_INVEST = COMP_WAKS_PRO_ON_INVEST;
		}

		public HtmlOutputLabel getCOMP_WAKS_ZERO_PREM_YN_LABEL() {
			return COMP_WAKS_ZERO_PREM_YN_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_WAKS_ZERO_PREM_YN() {
			return COMP_WAKS_ZERO_PREM_YN;
		}

		public void setCOMP_WAKS_ZERO_PREM_YN_LABEL(HtmlOutputLabel COMP_WAKS_ZERO_PREM_YN_LABEL) {
			this.COMP_WAKS_ZERO_PREM_YN_LABEL = COMP_WAKS_ZERO_PREM_YN_LABEL;
		}

		public void setCOMP_WAKS_ZERO_PREM_YN(HtmlSelectOneMenu COMP_WAKS_ZERO_PREM_YN) {
			this.COMP_WAKS_ZERO_PREM_YN = COMP_WAKS_ZERO_PREM_YN;
		}

		public HtmlOutputLabel getCOMP_WAKS_RISK_LOAD_YN_LABEL() {
			return COMP_WAKS_RISK_LOAD_YN_LABEL;
		}

		public HtmlSelectOneMenu getCOMP_WAKS_RISK_LOAD_YN() {
			return COMP_WAKS_RISK_LOAD_YN;
		}

		public void setCOMP_WAKS_RISK_LOAD_YN_LABEL(HtmlOutputLabel COMP_WAKS_RISK_LOAD_YN_LABEL) {
			this.COMP_WAKS_RISK_LOAD_YN_LABEL = COMP_WAKS_RISK_LOAD_YN_LABEL;
		}

		public void setCOMP_WAKS_RISK_LOAD_YN(HtmlSelectOneMenu COMP_WAKS_RISK_LOAD_YN) {
			this.COMP_WAKS_RISK_LOAD_YN = COMP_WAKS_RISK_LOAD_YN;
		}

		public HtmlOutputLabel getCOMP_UI_M_WAKS_COVER_CODE_LABEL() {
			return COMP_UI_M_WAKS_COVER_CODE_LABEL;
		}

		public HtmlInputText getCOMP_UI_M_WAKS_COVER_CODE() {
			return COMP_UI_M_WAKS_COVER_CODE;
		}

		public void setCOMP_UI_M_WAKS_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_WAKS_COVER_CODE_LABEL) {
			this.COMP_UI_M_WAKS_COVER_CODE_LABEL = COMP_UI_M_WAKS_COVER_CODE_LABEL;
		}

		public void setCOMP_UI_M_WAKS_COVER_CODE(HtmlInputText COMP_UI_M_WAKS_COVER_CODE) {
			this.COMP_UI_M_WAKS_COVER_CODE = COMP_UI_M_WAKS_COVER_CODE;
		}

		public HtmlOutputLabel getCOMP_WAKS_SPL_FUND_LABEL() {
			return COMP_WAKS_SPL_FUND_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_SPL_FUND() {
			return COMP_WAKS_SPL_FUND;
		}

		public void setCOMP_WAKS_SPL_FUND_LABEL(HtmlOutputLabel COMP_WAKS_SPL_FUND_LABEL) {
			this.COMP_WAKS_SPL_FUND_LABEL = COMP_WAKS_SPL_FUND_LABEL;
		}

		public void setCOMP_WAKS_SPL_FUND(HtmlInputText COMP_WAKS_SPL_FUND) {
			this.COMP_WAKS_SPL_FUND = COMP_WAKS_SPL_FUND;
		}

		public HtmlOutputLabel getCOMP_WAKS_ADMIN_CHARGES_LABEL() {
			return COMP_WAKS_ADMIN_CHARGES_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_ADMIN_CHARGES() {
			return COMP_WAKS_ADMIN_CHARGES;
		}

		public void setCOMP_WAKS_ADMIN_CHARGES_LABEL(HtmlOutputLabel COMP_WAKS_ADMIN_CHARGES_LABEL) {
			this.COMP_WAKS_ADMIN_CHARGES_LABEL = COMP_WAKS_ADMIN_CHARGES_LABEL;
		}

		public void setCOMP_WAKS_ADMIN_CHARGES(HtmlInputText COMP_WAKS_ADMIN_CHARGES) {
			this.COMP_WAKS_ADMIN_CHARGES = COMP_WAKS_ADMIN_CHARGES;
		}

		public HtmlOutputLabel getCOMP_WAKS_PAR_SHARE_OF_SUR_LABEL() {
			return COMP_WAKS_PAR_SHARE_OF_SUR_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_PAR_SHARE_OF_SUR() {
			return COMP_WAKS_PAR_SHARE_OF_SUR;
		}

		public void setCOMP_WAKS_PAR_SHARE_OF_SUR_LABEL(HtmlOutputLabel COMP_WAKS_PAR_SHARE_OF_SUR_LABEL) {
			this.COMP_WAKS_PAR_SHARE_OF_SUR_LABEL = COMP_WAKS_PAR_SHARE_OF_SUR_LABEL;
		}

		public void setCOMP_WAKS_PAR_SHARE_OF_SUR(HtmlInputText COMP_WAKS_PAR_SHARE_OF_SUR) {
			this.COMP_WAKS_PAR_SHARE_OF_SUR = COMP_WAKS_PAR_SHARE_OF_SUR;
		}

		public HtmlOutputLabel getCOMP_WAKS_INV_PROFIT_SHARE_LABEL() {
			return COMP_WAKS_INV_PROFIT_SHARE_LABEL;
		}

		public HtmlInputText getCOMP_WAKS_INV_PROFIT_SHARE() {
			return COMP_WAKS_INV_PROFIT_SHARE;
		}

		public void setCOMP_WAKS_INV_PROFIT_SHARE_LABEL(HtmlOutputLabel COMP_WAKS_INV_PROFIT_SHARE_LABEL) {
			this.COMP_WAKS_INV_PROFIT_SHARE_LABEL = COMP_WAKS_INV_PROFIT_SHARE_LABEL;
		}

		public void setCOMP_WAKS_INV_PROFIT_SHARE(HtmlInputText COMP_WAKS_INV_PROFIT_SHARE) {
			this.COMP_WAKS_INV_PROFIT_SHARE = COMP_WAKS_INV_PROFIT_SHARE;
		}

		public HtmlCommandButton getCOMP_UI_M_LOV_SUBCLASS() {
			return COMP_UI_M_LOV_SUBCLASS;
		}

		public void setCOMP_UI_M_LOV_SUBCLASS(HtmlCommandButton COMP_UI_M_LOV_SUBCLASS) {
			this.COMP_UI_M_LOV_SUBCLASS = COMP_UI_M_LOV_SUBCLASS;
		}

		public HtmlCommandButton getCOMP_UI_M_LOV_WAKS_COVER_CODE() {
			return COMP_UI_M_LOV_WAKS_COVER_CODE;
		}

		public void setCOMP_UI_M_LOV_WAKS_COVER_CODE(HtmlCommandButton COMP_UI_M_LOV_WAKS_COVER_CODE) {
			this.COMP_UI_M_LOV_WAKS_COVER_CODE = COMP_UI_M_LOV_WAKS_COVER_CODE;
		}

		public PM_LIFE_WAKALAH_SETUP getPM_LIFE_WAKALAH_SETUP_BEAN() {
			return PM_LIFE_WAKALAH_SETUP_BEAN;
		}

		public void setPM_LIFE_WAKALAH_SETUP_BEAN(PM_LIFE_WAKALAH_SETUP PM_LIFE_WAKALAH_SETUP_BEAN) {
			this.PM_LIFE_WAKALAH_SETUP_BEAN = PM_LIFE_WAKALAH_SETUP_BEAN;
		}

		public List<PM_LIFE_WAKALAH_SETUP> getDataList_PM_LIFE_WAKALAH_SETUP() {
			return dataList_PM_LIFE_WAKALAH_SETUP;
		}

		public void setDataListPM_LIFE_WAKALAH_SETUP(List<PM_LIFE_WAKALAH_SETUP> 
		dataList_PM_LIFE_WAKALAH_SETUP) {
			this.dataList_PM_LIFE_WAKALAH_SETUP = dataList_PM_LIFE_WAKALAH_SETUP;
		}

		
		
		
		

		public void addRow(ActionEvent event){
			try{
				CommonUtils.clearMaps(this);
				PM_LIFE_WAKALAH_HDR_BEAN = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
				getPM_LIFE_WAKALAH_HDR_BEAN();
				if (isINSERT_ALLOWED()){
					PM_LIFE_WAKALAH_SETUP_BEAN = new PM_LIFE_WAKALAH_SETUP();
					helper.WHEN_CREATE_RECORD(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
					helper.WHEN_NEW_RECORD_INSTANCE(this);
					resetAllComponent();
					resetSelectedRow();
				}else{

					getErrorMap().put("addRow",Messages.getString(
							PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
				}

			}catch(Exception exc){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("addRow",exc.getMessage());
			}

		}

		public void deleteRow(ActionEvent event){
			try{
				if (isDELETE_ALLOWED()){

					new CRUDHandler().executeDelete(PM_LIFE_WAKALAH_SETUP_BEAN,CommonUtils.getConnection());
					getWarningMap().put("deleteRow",Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.
							getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
					dataList_PM_LIFE_WAKALAH_SETUP.remove(PM_LIFE_WAKALAH_SETUP_BEAN);
					if(dataList_PM_LIFE_WAKALAH_SETUP.size()>0){

						PM_LIFE_WAKALAH_SETUP_BEAN=dataList_PM_LIFE_WAKALAH_SETUP.get(0);
					}else if(dataList_PM_LIFE_WAKALAH_SETUP.size()==0){

						addRow(null);
					}

					resetAllComponent();
					PM_LIFE_WAKALAH_SETUP_BEAN.setRowSelected(true);
				}else{

					getErrorMap().put("deleteRow",Messages.getString(
							PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
							PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"));
				}

			}catch(Exception exc){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("deleteRow",exc.getMessage());
			}

		}

		public void postRecord(ActionEvent event){
			try{
				PM_LIFE_WAKALAH_HDR_BEAN = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
					getPM_LIFE_WAKALAH_HDR_BEAN();
				if(PM_LIFE_WAKALAH_SETUP_BEAN.getROWID()==null ){
					if(isINSERT_ALLOWED()) {
					helper.preInsert(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
					new CRUDHandler().executeInsert(PM_LIFE_WAKALAH_SETUP_BEAN,CommonUtils.getConnection());

					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					
					
					
					dataList_PM_LIFE_WAKALAH_SETUP.add(PM_LIFE_WAKALAH_SETUP_BEAN);
					}else{
						throw new Exception(Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
					}
				}else if(PM_LIFE_WAKALAH_SETUP_BEAN.getROWID()!=null){
					if(isUPDATE_ALLOWED()){
					helper.preUpdate(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
					new CRUDHandler().executeUpdate(PM_LIFE_WAKALAH_SETUP_BEAN,CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
				}
				PM_LIFE_WAKALAH_SETUP_BEAN.setRowSelected(true);
			}catch(Exception exc){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Record not Inserted/Updated :: "+exc.getMessage());
				getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
			}

		}

		public void displayRecords(){
			CommonUtils.clearMaps(this);
			try{
				PM_LIFE_WAKALAH_HDR_BEAN = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
					getPM_LIFE_WAKALAH_HDR_BEAN();
				resetSelectedRow();
				PM_LIFE_WAKALAH_SETUP_BEAN = (PM_LIFE_WAKALAH_SETUP)dataTable.getRowData();
				System.out.println(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_FIXED_AMT());
				helper.postQuery(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
				helper.WHEN_NEW_RECORD_INSTANCE(this);
				PM_LIFE_WAKALAH_SETUP_BEAN.setRowSelected(true);
				resetAllComponent();
			}catch(Exception exc){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("displayRecords",exc.getMessage());
			}

		}

		private void resetSelectedRow(){
			Iterator<PM_LIFE_WAKALAH_SETUP> PM_LIFE_WAKALAH_SETUP_ITR = 
				dataList_PM_LIFE_WAKALAH_SETUP.iterator();while (PM_LIFE_WAKALAH_SETUP_ITR.hasNext()) {

					PM_LIFE_WAKALAH_SETUP_ITR.next().setRowSelected(false);}
		}

		private void resetAllComponent(){
			COMP_WAKS_COVER_CODE.resetValue();
			COMP_WAKS_EFF_FM_DT.resetValue();
			COMP_WAKS_EFF_TO_DT.resetValue();
			COMP_WAKS_EXP_CALC_MTHD.resetValue();
			COMP_WAKS_EXPENSE_PERC.resetValue();
			COMP_WAKS_RISK_CALC_MTHD.resetValue();
			COMP_WAKS_CHARGE_MODE.resetValue();
			COMP_WAKS_ZERO_PREM_YN.resetValue();
			COMP_WAKS_RISK_LOAD_YN.resetValue();
			COMP_UI_M_WAKS_COVER_CODE.resetValue();
			COMP_WAKS_FIXED_AMT.resetValue();
		}

		public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
		}

		public UIData getDataTable() {
			return dataTable;
		}
		public void saveRecord() {
			try {
				CommonUtils.clearMaps(this);
				CommonUtils.getConnection().commit();
				
				System.out.println("wak fee value :"+getCOMP_WAKS_FIXED_AMT());
				getWarningMap().put("SAVE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}
		}


		public List<SelectItem> getListWAKS_EXP_CALC_MTHD() {
			if (listWAKS_EXP_CALC_MTHD.size() == 0) {
				listWAKS_EXP_CALC_MTHD.clear();
				try {
					listWAKS_EXP_CALC_MTHD = delegate.WAKS_EXP_CALC_MTHDLIST();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listWAKS_EXP_CALC_MTHD;
		}

		public void setListWAKS_EXP_CALC_MTHD(List<SelectItem> listWAKS_EXP_CALC_MTHD) {
			this.listWAKS_EXP_CALC_MTHD = listWAKS_EXP_CALC_MTHD;
		}

		public List<SelectItem> getListWAKS_RISK_CALC_MTHD() {
			if (listWAKS_RISK_CALC_MTHD.size() == 0) {
				listWAKS_RISK_CALC_MTHD.clear();
				try {
					listWAKS_RISK_CALC_MTHD = delegate.WAKS_RISK_CALC_MTHDLIST();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listWAKS_RISK_CALC_MTHD;
		}

		public void setListWAKS_RISK_CALC_MTHD(List<SelectItem> listWAKS_RISK_CALC_MTHD) {
			this.listWAKS_RISK_CALC_MTHD = listWAKS_RISK_CALC_MTHD;
		}

		public List<SelectItem> getListWAKS_CHARGE_MODE() {
			if (listWAKS_CHARGE_MODE.size() == 0) {
				listWAKS_CHARGE_MODE.clear();
				try {
					listWAKS_CHARGE_MODE = delegate.WAKS_CHARGE_MODELIST();
				} catch (Exception e) {
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
					getErrorMap().put("WAKS_CHARGE_MODE",e.getMessage());
				}
			}
			return listWAKS_CHARGE_MODE;
		}

		public void setListWAKS_CHARGE_MODE(List<SelectItem> listWAKS_CHARGE_MODE) {
			this.listWAKS_CHARGE_MODE = listWAKS_CHARGE_MODE;
		}

		public List<SelectItem> getListWAKS_ZERO_PREM_YN() {
			if (listWAKS_ZERO_PREM_YN.size() == 0) {
				listWAKS_ZERO_PREM_YN.clear();
				try {
					listWAKS_ZERO_PREM_YN = delegate.WAKS_ZERO_PREM_YNLIST();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listWAKS_ZERO_PREM_YN;
		}

		public void setListWAKS_ZERO_PREM_YN(List<SelectItem> listWAKS_ZERO_PREM_YN) {
			this.listWAKS_ZERO_PREM_YN = listWAKS_ZERO_PREM_YN;
		}

		public List<SelectItem> getListWAKS_RISK_LOAD_YN() {
			if (listWAKS_RISK_LOAD_YN.size() == 0) {
				listWAKS_RISK_LOAD_YN.clear();
				try {
					listWAKS_RISK_LOAD_YN = delegate.WAKS_RISK_LOAD_YNLIST();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return listWAKS_RISK_LOAD_YN;
		}

		public void setListWAKS_RISK_LOAD_YN(List<SelectItem> listWAKS_RISK_LOAD_YN) {
			this.listWAKS_RISK_LOAD_YN = listWAKS_RISK_LOAD_YN;
		}

		public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		
		
		}
		
		public void dateFormate(){
			String tempDate;
			if(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_EFF_FM_DT() != null){
				tempDate=CommonUtils.dateToStringFormat(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_EFF_FM_DT());
				PM_LIFE_WAKALAH_SETUP_BEAN.setUI_WAKS_EFF_FM_DT(tempDate);
				}
				if(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_EFF_TO_DT() != null){
				tempDate=CommonUtils.dateToStringFormat(PM_LIFE_WAKALAH_SETUP_BEAN.getWAKS_EFF_TO_DT());
				PM_LIFE_WAKALAH_SETUP_BEAN.setUI_WAKS_EFF_TO_DT(tempDate);
				}
		}
		public void onLoad(PhaseEvent event) {
			try {
				System.out.println("isFormFlag()          "+isFormFlag());
			if (isFormFlag()) {
				helper.preForm();
				setFormFlag(false);
			}
				if (isBlockFlag()) {
					PM_LIFE_WAKALAH_HDR_BEAN = compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
					getPM_LIFE_WAKALAH_HDR_BEAN();
					if(compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
							getPM_LIFE_WAKALAH_HDR_BEAN().getROWID() != null){
						compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
						getCOMP_WAKS_MODULE().setDisabled(true);
						compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().
						getCOMP_WAKS_PRODUCT_CODE().setDisabled(true);
						getCOMP_WAKS_FIXED_AMT().setDisabled(false);
						helper.executeQuery(compositeAction);
						helper.postQuery(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
					}else{
						helper.WHEN_CREATE_RECORD(PM_LIFE_WAKALAH_SETUP_BEAN, PM_LIFE_WAKALAH_HDR_BEAN);
					}
					helper.WHEN_NEW_RECORD_INSTANCE(this);
					setBlockFlag(false);
				}
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("onLoad",e.getMessage());
			}
		}
		public List<LovBean> prepareLOV(Object value){
			try{
				lovList = delegate.prepareLOV((String)value);
			}catch(Exception e){
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
			}
			return lovList;
		}

		public void validateWAKS_COVER_CODE(FacesContext context, UIComponent component,Object value){
			try {
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_COVER_CODE((String) value);
				helper.WHEN_VALIDATE_ITEM_WAKS_COVER_CODE((String) value, PM_LIFE_WAKALAH_SETUP_BEAN);
				COMP_UI_M_WAKS_COVER_CODE.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

		public void OnListChange(ActionEvent event){
			UIInput input=(UIInput)event.getComponent().getParent();
			helper.WHEN_LIST_CHANGED(this);
			ErrorHelpUtil.validate(input,getErrorMap());
		}

		public void validateWAKS_EXP_CALC_MTHD(FacesContext fc, UIComponent component, Object value) 
		throws ValidatorException, Exception {
			try {
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXP_CALC_MTHD((String) value);
				helper.WHEN_VALIDATE_ITEM_WAKS_EXP_CALC_MTHD(this);
				COMP_WAKS_EXPENSE_PERC.resetValue();
			} catch (Exception e) { 
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validateWAKS_EXPENSE_PERC(FacesContext fc, UIComponent component, Object value) 
		throws ValidatorException, Exception {
			try {
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXPENSE_PERC((Double) value);
			} catch (Exception e) { 
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		/*added by janani on 10.2.2016*/
		
		
		public void validateWAKS_FIXED_AMT(FacesContext fc, UIComponent component, Object value) 
				throws ValidatorException, Exception {
					try {
						PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_FIXED_AMT((Double) value);
					} catch (Exception e) { 
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
		
		/*end*/
		
		public void whenListChangedEXP_CALC_MTHD(ActionEvent event){
			getErrorMap().clear();
			getWarningMap().clear();
			String value=(String)COMP_WAKS_EXP_CALC_MTHD.getSubmittedValue();
			
			System.out.println("waka fee calc list value :"+value);
			
			
			try {
				helper.WHEN_LIST_CHANGED(this);
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EXP_CALC_MTHD(value);
				if(value.equals("3")){
					
					System.out.println("waka fee calc list value is fixed amt");
				
					getCOMP_WAKS_FIXED_AMT().setDisabled(false);
					getPM_LIFE_WAKALAH_SETUP_BEAN().setWAKS_FIXED_AMT(null);
				getCOMP_WAKS_FIXED_AMT().resetValue();
				
				}
				else
				{
					getCOMP_WAKS_FIXED_AMT().setDisabled(true);
					getPM_LIFE_WAKALAH_SETUP_BEAN().setWAKS_FIXED_AMT(0.0);
					getCOMP_WAKS_FIXED_AMT().resetValue();
				}
				COMP_WAKS_EXPENSE_PERC.resetValue();
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
			}
		}
		
		public void validateWAKS_EFF_FM_DT(FacesContext fc, UIComponent component, Object value) 
		throws ValidatorException, Exception {
			try {
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EFF_FM_DT((Date) value);
				helper.WHEN_VALIDATE_ITEM_WAKS_EFF_FM_DT(this, compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN());
			} catch (Exception e) { 
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validateWAKS_EFF_TO_DT(FacesContext fc, UIComponent component, Object value) 
		throws ValidatorException, Exception {
			try {
				PM_LIFE_WAKALAH_SETUP_BEAN.setWAKS_EFF_TO_DT((Date) value);
				helper.WHEN_VALIDATE_ITEM_WAKS_EFF_TO_DT(this, compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN());
			} catch (Exception e) { 
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
		}
		

}
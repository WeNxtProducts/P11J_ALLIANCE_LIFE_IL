package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BONUS_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABS_CODE_LABEL;

	private HtmlInputText COMP_ABS_CODE;

	private HtmlOutputLabel COMP_ABS_DESC_LABEL;

	private HtmlInputText COMP_ABS_DESC;

	private HtmlOutputLabel COMP_ABS_SHORT_DESC_LABEL;

	private HtmlInputText COMP_ABS_SHORT_DESC;

	private HtmlOutputLabel COMP_ABS_LONG_DESC_LABEL;

	private HtmlInputText COMP_ABS_LONG_DESC;

	private HtmlOutputLabel COMP_ABS_BONUS_TYPE_LABEL;

	private HtmlInputText COMP_ABS_BONUS_TYPE;

	private HtmlOutputLabel COMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABS_BONUS_TYPE_DESC;

	private HtmlOutputLabel COMP_ABS_YRS_FM_LABEL;

	private HtmlInputText COMP_ABS_YRS_FM;

	private HtmlOutputLabel COMP_ABS_YRS_TO_LABEL;

	private HtmlInputText COMP_ABS_YRS_TO;

	private HtmlOutputLabel COMP_ABS_BONUS_FREQ_LABEL;

	private HtmlSelectOneMenu COMP_ABS_BONUS_FREQ;

	private HtmlOutputLabel COMP_ABS_PRORATA_YN_LABEL;

	private HtmlSelectOneMenu COMP_ABS_PRORATA_YN;

	private HtmlOutputLabel COMP_ABS_POL_RENEWAL_YR_LABEL;

	private HtmlInputText COMP_ABS_POL_RENEWAL_YR;

	private HtmlOutputLabel COMP_ABS_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_ABS_EFF_FM_DT;

	private HtmlOutputLabel COMP_ABS_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_ABS_EFF_TO_DT;

	private HtmlOutputLabel COMP_ABS_TAXABLE_YN_LABEL;

	private HtmlSelectOneMenu COMP_ABS_TAXABLE_YN;

	private HtmlOutputLabel COMP_ABS_BL_DESC_LABEL;

	private HtmlInputText COMP_ABS_BL_DESC;

	private HtmlOutputLabel COMP_ABS_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_ABS_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_ABS_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_ABS_BL_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_ABS_DESC_EDITOR;

	private HtmlCommandButton COMP_UI_M_BUT_ABS_LONG_DESC_EDITOR;

	private HtmlCommandButton COMP_UI_M_BUT_BONUS_TYPE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;

	private PM_AGENT_BONUS_SETUP PM_AGENT_BONUS_SETUP_BEAN;
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction;
	
	private List bonusTypeList;
	
	private List<SelectItem> bonusFreqList;
	
	private List<SelectItem> prorataYnList;
	
	private List<SelectItem> taxableYnList;

	public PM_AGENT_BONUS_SETUP_ACTION() {
		PM_AGENT_BONUS_SETUP_BEAN = new PM_AGENT_BONUS_SETUP();
		getDropDown();
	}

	private void getDropDown() {
		try {
			Connection connection=CommonUtils.getConnection();
			List<SelectItem>bonusFreqItemList=ListItemUtil.getDropDownListValue(connection, PM094_A_PM_AGENT_BONUS_CONSTANTS.FORM_NAME, PM094_A_PM_AGENT_BONUS_CONSTANTS.BLOCK_NAME,
												PM094_A_PM_AGENT_BONUS_CONSTANTS.ITEM_NAME_BONUS_FREQ, PM094_A_PM_AGENT_BONUS_CONSTANTS.SYS_PARAM_BONUS_FREQ);
			setBonusFreqList(bonusFreqItemList);
			
			List<SelectItem>proRataItemList=ListItemUtil.getDropDownListValue(connection, PM094_A_PM_AGENT_BONUS_CONSTANTS.FORM_NAME, PM094_A_PM_AGENT_BONUS_CONSTANTS.BLOCK_NAME,
					PM094_A_PM_AGENT_BONUS_CONSTANTS.ITEM_NAME_PRORATA_YN, PM094_A_PM_AGENT_BONUS_CONSTANTS.SYS_PARAM_PRORATA_YN);
			setProrataYnList(proRataItemList);
			
			List<SelectItem>taxableYnItemList=ListItemUtil.getDropDownListValue(connection, PM094_A_PM_AGENT_BONUS_CONSTANTS.FORM_NAME, PM094_A_PM_AGENT_BONUS_CONSTANTS.BLOCK_NAME,
					PM094_A_PM_AGENT_BONUS_CONSTANTS.ITEM_NAME_TAXABLE_YN, PM094_A_PM_AGENT_BONUS_CONSTANTS.SYS_PARAM_TAXABLE_YN);
			setTaxableYnList(taxableYnItemList);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_ABS_CODE_LABEL() {
		return COMP_ABS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABS_CODE() {
		return COMP_ABS_CODE;
	}

	public void setCOMP_ABS_CODE_LABEL(HtmlOutputLabel COMP_ABS_CODE_LABEL) {
		this.COMP_ABS_CODE_LABEL = COMP_ABS_CODE_LABEL;
	}

	public void setCOMP_ABS_CODE(HtmlInputText COMP_ABS_CODE) {
		this.COMP_ABS_CODE = COMP_ABS_CODE;
	}

	public HtmlOutputLabel getCOMP_ABS_DESC_LABEL() {
		return COMP_ABS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_DESC() {
		return COMP_ABS_DESC;
	}

	public void setCOMP_ABS_DESC_LABEL(HtmlOutputLabel COMP_ABS_DESC_LABEL) {
		this.COMP_ABS_DESC_LABEL = COMP_ABS_DESC_LABEL;
	}

	public void setCOMP_ABS_DESC(HtmlInputText COMP_ABS_DESC) {
		this.COMP_ABS_DESC = COMP_ABS_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_SHORT_DESC_LABEL() {
		return COMP_ABS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_SHORT_DESC() {
		return COMP_ABS_SHORT_DESC;
	}

	public void setCOMP_ABS_SHORT_DESC_LABEL(HtmlOutputLabel COMP_ABS_SHORT_DESC_LABEL) {
		this.COMP_ABS_SHORT_DESC_LABEL = COMP_ABS_SHORT_DESC_LABEL;
	}

	public void setCOMP_ABS_SHORT_DESC(HtmlInputText COMP_ABS_SHORT_DESC) {
		this.COMP_ABS_SHORT_DESC = COMP_ABS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_LONG_DESC_LABEL() {
		return COMP_ABS_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_LONG_DESC() {
		return COMP_ABS_LONG_DESC;
	}

	public void setCOMP_ABS_LONG_DESC_LABEL(HtmlOutputLabel COMP_ABS_LONG_DESC_LABEL) {
		this.COMP_ABS_LONG_DESC_LABEL = COMP_ABS_LONG_DESC_LABEL;
	}

	public void setCOMP_ABS_LONG_DESC(HtmlInputText COMP_ABS_LONG_DESC) {
		this.COMP_ABS_LONG_DESC = COMP_ABS_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_BONUS_TYPE_LABEL() {
		return COMP_ABS_BONUS_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_ABS_BONUS_TYPE() {
		return COMP_ABS_BONUS_TYPE;
	}

	public void setCOMP_ABS_BONUS_TYPE_LABEL(HtmlOutputLabel COMP_ABS_BONUS_TYPE_LABEL) {
		this.COMP_ABS_BONUS_TYPE_LABEL = COMP_ABS_BONUS_TYPE_LABEL;
	}

	public void setCOMP_ABS_BONUS_TYPE(HtmlInputText COMP_ABS_BONUS_TYPE) {
		this.COMP_ABS_BONUS_TYPE = COMP_ABS_BONUS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL() {
		return COMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABS_BONUS_TYPE_DESC() {
		return COMP_UI_M_ABS_BONUS_TYPE_DESC;
	}

	public void setCOMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL) {
		this.COMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL = COMP_UI_M_ABS_BONUS_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABS_BONUS_TYPE_DESC(HtmlInputText COMP_UI_M_ABS_BONUS_TYPE_DESC) {
		this.COMP_UI_M_ABS_BONUS_TYPE_DESC = COMP_UI_M_ABS_BONUS_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_YRS_FM_LABEL() {
		return COMP_ABS_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABS_YRS_FM() {
		return COMP_ABS_YRS_FM;
	}

	public void setCOMP_ABS_YRS_FM_LABEL(HtmlOutputLabel COMP_ABS_YRS_FM_LABEL) {
		this.COMP_ABS_YRS_FM_LABEL = COMP_ABS_YRS_FM_LABEL;
	}

	public void setCOMP_ABS_YRS_FM(HtmlInputText COMP_ABS_YRS_FM) {
		this.COMP_ABS_YRS_FM = COMP_ABS_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_ABS_YRS_TO_LABEL() {
		return COMP_ABS_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABS_YRS_TO() {
		return COMP_ABS_YRS_TO;
	}

	public void setCOMP_ABS_YRS_TO_LABEL(HtmlOutputLabel COMP_ABS_YRS_TO_LABEL) {
		this.COMP_ABS_YRS_TO_LABEL = COMP_ABS_YRS_TO_LABEL;
	}

	public void setCOMP_ABS_YRS_TO(HtmlInputText COMP_ABS_YRS_TO) {
		this.COMP_ABS_YRS_TO = COMP_ABS_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_ABS_BONUS_FREQ_LABEL() {
		return COMP_ABS_BONUS_FREQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABS_BONUS_FREQ() {
		return COMP_ABS_BONUS_FREQ;
	}

	public void setCOMP_ABS_BONUS_FREQ_LABEL(HtmlOutputLabel COMP_ABS_BONUS_FREQ_LABEL) {
		this.COMP_ABS_BONUS_FREQ_LABEL = COMP_ABS_BONUS_FREQ_LABEL;
	}

	public void setCOMP_ABS_BONUS_FREQ(HtmlSelectOneMenu COMP_ABS_BONUS_FREQ) {
		this.COMP_ABS_BONUS_FREQ = COMP_ABS_BONUS_FREQ;
	}

	public HtmlOutputLabel getCOMP_ABS_PRORATA_YN_LABEL() {
		return COMP_ABS_PRORATA_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABS_PRORATA_YN() {
		return COMP_ABS_PRORATA_YN;
	}

	public void setCOMP_ABS_PRORATA_YN_LABEL(HtmlOutputLabel COMP_ABS_PRORATA_YN_LABEL) {
		this.COMP_ABS_PRORATA_YN_LABEL = COMP_ABS_PRORATA_YN_LABEL;
	}

	public void setCOMP_ABS_PRORATA_YN(HtmlSelectOneMenu COMP_ABS_PRORATA_YN) {
		this.COMP_ABS_PRORATA_YN = COMP_ABS_PRORATA_YN;
	}

	public HtmlOutputLabel getCOMP_ABS_POL_RENEWAL_YR_LABEL() {
		return COMP_ABS_POL_RENEWAL_YR_LABEL;
	}

	public HtmlInputText getCOMP_ABS_POL_RENEWAL_YR() {
		return COMP_ABS_POL_RENEWAL_YR;
	}

	public void setCOMP_ABS_POL_RENEWAL_YR_LABEL(HtmlOutputLabel COMP_ABS_POL_RENEWAL_YR_LABEL) {
		this.COMP_ABS_POL_RENEWAL_YR_LABEL = COMP_ABS_POL_RENEWAL_YR_LABEL;
	}

	public void setCOMP_ABS_POL_RENEWAL_YR(HtmlInputText COMP_ABS_POL_RENEWAL_YR) {
		this.COMP_ABS_POL_RENEWAL_YR = COMP_ABS_POL_RENEWAL_YR;
	}

	public HtmlOutputLabel getCOMP_ABS_EFF_FM_DT_LABEL() {
		return COMP_ABS_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABS_EFF_FM_DT() {
		return COMP_ABS_EFF_FM_DT;
	}

	public void setCOMP_ABS_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_ABS_EFF_FM_DT_LABEL) {
		this.COMP_ABS_EFF_FM_DT_LABEL = COMP_ABS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ABS_EFF_FM_DT(HtmlCalendar COMP_ABS_EFF_FM_DT) {
		this.COMP_ABS_EFF_FM_DT = COMP_ABS_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ABS_EFF_TO_DT_LABEL() {
		return COMP_ABS_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABS_EFF_TO_DT() {
		return COMP_ABS_EFF_TO_DT;
	}

	public void setCOMP_ABS_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_ABS_EFF_TO_DT_LABEL) {
		this.COMP_ABS_EFF_TO_DT_LABEL = COMP_ABS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_ABS_EFF_TO_DT(HtmlCalendar COMP_ABS_EFF_TO_DT) {
		this.COMP_ABS_EFF_TO_DT = COMP_ABS_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_ABS_TAXABLE_YN_LABEL() {
		return COMP_ABS_TAXABLE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABS_TAXABLE_YN() {
		return COMP_ABS_TAXABLE_YN;
	}

	public void setCOMP_ABS_TAXABLE_YN_LABEL(HtmlOutputLabel COMP_ABS_TAXABLE_YN_LABEL) {
		this.COMP_ABS_TAXABLE_YN_LABEL = COMP_ABS_TAXABLE_YN_LABEL;
	}

	public void setCOMP_ABS_TAXABLE_YN(HtmlSelectOneMenu COMP_ABS_TAXABLE_YN) {
		this.COMP_ABS_TAXABLE_YN = COMP_ABS_TAXABLE_YN;
	}

	public HtmlOutputLabel getCOMP_ABS_BL_DESC_LABEL() {
		return COMP_ABS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_BL_DESC() {
		return COMP_ABS_BL_DESC;
	}

	public void setCOMP_ABS_BL_DESC_LABEL(HtmlOutputLabel COMP_ABS_BL_DESC_LABEL) {
		this.COMP_ABS_BL_DESC_LABEL = COMP_ABS_BL_DESC_LABEL;
	}

	public void setCOMP_ABS_BL_DESC(HtmlInputText COMP_ABS_BL_DESC) {
		this.COMP_ABS_BL_DESC = COMP_ABS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_BL_SHORT_DESC_LABEL() {
		return COMP_ABS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_BL_SHORT_DESC() {
		return COMP_ABS_BL_SHORT_DESC;
	}

	public void setCOMP_ABS_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_ABS_BL_SHORT_DESC_LABEL) {
		this.COMP_ABS_BL_SHORT_DESC_LABEL = COMP_ABS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_ABS_BL_SHORT_DESC(HtmlInputText COMP_ABS_BL_SHORT_DESC) {
		this.COMP_ABS_BL_SHORT_DESC = COMP_ABS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ABS_BL_LONG_DESC_LABEL() {
		return COMP_ABS_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABS_BL_LONG_DESC() {
		return COMP_ABS_BL_LONG_DESC;
	}

	public void setCOMP_ABS_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_ABS_BL_LONG_DESC_LABEL) {
		this.COMP_ABS_BL_LONG_DESC_LABEL = COMP_ABS_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_ABS_BL_LONG_DESC(HtmlInputText COMP_ABS_BL_LONG_DESC) {
		this.COMP_ABS_BL_LONG_DESC = COMP_ABS_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ABS_DESC_EDITOR() {
		return COMP_UI_M_BUT_ABS_DESC_EDITOR;
	}

	public void setCOMP_UI_M_BUT_ABS_DESC_EDITOR(HtmlCommandButton COMP_UI_M_BUT_ABS_DESC_EDITOR) {
		this.COMP_UI_M_BUT_ABS_DESC_EDITOR = COMP_UI_M_BUT_ABS_DESC_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ABS_LONG_DESC_EDITOR() {
		return COMP_UI_M_BUT_ABS_LONG_DESC_EDITOR;
	}

	public void setCOMP_UI_M_BUT_ABS_LONG_DESC_EDITOR(HtmlCommandButton COMP_UI_M_BUT_ABS_LONG_DESC_EDITOR) {
		this.COMP_UI_M_BUT_ABS_LONG_DESC_EDITOR = COMP_UI_M_BUT_ABS_LONG_DESC_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BONUS_TYPE_LOV() {
		return COMP_UI_M_BUT_BONUS_TYPE_LOV;
	}

	public void setCOMP_UI_M_BUT_BONUS_TYPE_LOV(HtmlCommandButton COMP_UI_M_BUT_BONUS_TYPE_LOV) {
		this.COMP_UI_M_BUT_BONUS_TYPE_LOV = COMP_UI_M_BUT_BONUS_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public PM_AGENT_BONUS_SETUP getPM_AGENT_BONUS_SETUP_BEAN() {
		return PM_AGENT_BONUS_SETUP_BEAN;
	}

	public void setPM_AGENT_BONUS_SETUP_BEAN(PM_AGENT_BONUS_SETUP PM_AGENT_BONUS_SETUP_BEAN) {
		this.PM_AGENT_BONUS_SETUP_BEAN = PM_AGENT_BONUS_SETUP_BEAN;
	}
	
	public void validateAbsCode(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		
		String absCode=(String)value;
		PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
		PM_AGENT_BONUS_SETUP_BEAN.setABS_CODE(absCode);
		try {
			if(PM_AGENT_BONUS_SETUP_BEAN.getROWID() == null){
			helper.when_validate_abs_code(this);
			duplicateValidationCheck();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
	}
	
	public void validateAbsDesc(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		
		try {
			String absDesc=(String)value;
			PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
			PM_AGENT_BONUS_SETUP_BEAN.setABS_DESC(absDesc);
			helper.when_validate_abs_desc(this);
			COMP_ABS_SHORT_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsBonusType(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		String absBonusType=(String)value;
		PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
		PM_AGENT_BONUS_SETUP_BEAN.setABS_BONUS_TYPE(absBonusType);
		try {
			helper.when_validate_abs_bonus_type(this);
			COMP_UI_M_ABS_BONUS_TYPE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsYrsFm(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		try {
			Integer absYrsFm=(Integer)value;
			PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
			PM_AGENT_BONUS_SETUP_BEAN.setABS_YRS_FM(absYrsFm);
			helper.when_validate_abs_yrs_fm(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsYrsTo(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		try {
			Integer absYrsTo=(Integer)value;
			PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
			PM_AGENT_BONUS_SETUP_BEAN.setABS_YRS_TO(absYrsTo);
			helper.when_validate_abs_yrs_to(this);
		}  catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsBonusFreq(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		String absbonusFreq=(String)value;
		try {
			if(absbonusFreq==null){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"60027" ));
			}else{
				
				PM_AGENT_BONUS_SETUP_BEAN.setABS_BONUS_FREQ(absbonusFreq);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsProRataYN(FacesContext context, UIComponent component,
			Object value){
		String absProRataYN=(String)value;
		if(absProRataYN==null){
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"60027" ));
		}else{
			
			PM_AGENT_BONUS_SETUP_BEAN.setABS_PRORATA_YN(absProRataYN);
		}
	}
	
	public void validateAbsPolRenewalYr(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		Double absPolRenewalYr=(Double)value;
		PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
		PM_AGENT_BONUS_SETUP_BEAN.setABS_POL_RENEWAL_YR(absPolRenewalYr);
		try {
			helper.when_validate_abs_pol_renewal_yr(this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsEffFrmDt(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		try {
			Date absEffFrmDt=(Date)value;
			PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
			PM_AGENT_BONUS_SETUP_BEAN.setABS_EFF_FM_DT(absEffFrmDt);
				helper.when_validate_abs_eff_frm_dt(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAbsEffToDt(FacesContext context, UIComponent component,
			Object value)throws ValidatorException{
		try {
			Date absEffToDt=(Date)value;
			PM_AGENT_BONUS_SETUP_HELPER helper=new PM_AGENT_BONUS_SETUP_HELPER();
			PM_AGENT_BONUS_SETUP_BEAN.setABS_EFF_TO_DT(absEffToDt);
				helper.when_validate_abs_eff_to_dt(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}	
		
	}
	
	public void validateErrorPanel(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void execute_insert(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup){
		PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
		try {
			if(pm_agent_bonus_setup.getROWID()==null){
				helper.pre_insert(pm_agent_bonus_setup);
			}else{
				helper.pre_update(pm_agent_bonus_setup);
			}
			PM_AGENT_BONUS_SETUP_DELEGATE delegate=new PM_AGENT_BONUS_SETUP_DELEGATE();
			delegate.executeInsertForAgentBonusSetup(pm_agent_bonus_setup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String saveAndCommit(){
		
		CommonUtils utils=new CommonUtils();
		String message=null;
		try {
			//duplicateValidationCheck();
			if(PM_AGENT_BONUS_SETUP_BEAN.getROWID()==null){
				message=Messages.getString("messageProperties", "errorPanel$message$save");
				
			}else{
				message=Messages.getString("messageProperties", "errorPanel$message$update");
			}
			
			execute_insert(PM_AGENT_BONUS_SETUP_BEAN);
			utils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public void whenValidateAbsCode(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String absCode=(String)input.getSubmittedValue();		
		PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
		PM_AGENT_BONUS_SETUP_BEAN.setABS_CODE(absCode);
		try {
			helper.when_validate_abs_code(this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}	
	}
	
	public void whenValidateAbsCodeDesc(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String absDesc=(String)	input.getSubmittedValue();
		PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
		PM_AGENT_BONUS_SETUP_BEAN.setABS_DESC(absDesc);
		helper.when_validate_abs_desc(this);
	}*/

	public List getBonusTypeList() {
		return bonusTypeList;
	}

	public void setBonusTypeList(List bonusTypeList) {
		this.bonusTypeList = bonusTypeList;
	}
	
	/*public List suggestionActionBonusType(Object event){
		String bonusType=(String)event;
		try {
			PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
			bonusTypeList=helper.prepareBonusTypeList(bonusType,bonusTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bonusTypeList;
	}*/
	
	public List suggestionActionBonusType(Object event){
		String bonusType=(String)event;
		String query = "";
		ArrayList<LovBean> suggestionList = null;
		Object[] values = null;
		try {
			if("*".equalsIgnoreCase(bonusType)){
			query = "SELECT PS_CODE,PS_CODE_DESC,PS_BL_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'AGT_BONUS'";
			values = new Object[]{};
			}else{
				query = "SELECT PS_CODE,PS_CODE_DESC,PS_BL_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'AGT_BONUS' " +
						" AND (PS_CODE LIKE ? OR PS_CODE_DESC LIKE ?) AND ROWNUM <= 25 ORDER BY 1";
				values = new Object[]{bonusType + "%",bonusType + "%"};
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	

	public void getBonusTypeDesc(ActionEvent event) {
		COMP_UI_M_ABS_BONUS_TYPE_DESC.setSubmittedValue(null);
		System.out.println("bonus type :" + COMP_ABS_BONUS_TYPE.getSubmittedValue());
		if (COMP_ABS_BONUS_TYPE.getSubmittedValue() != null) {
			String bonustype = (String) COMP_ABS_CODE.getSubmittedValue();
			System.out.println("bonustype :" + bonustype);
			PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
			String bonusTypeDesc = helper.getDescforBonusType(bonustype, bonusTypeList);
			PM_AGENT_BONUS_SETUP_BEAN.setUI_M_ABS_BONUS_TYPE_DESC(bonusTypeDesc);
		
	}
}

	public List<SelectItem> getBonusFreqList() {
		return bonusFreqList;
	}

	public void setBonusFreqList(List<SelectItem> bonusFreqList) {
		this.bonusFreqList = bonusFreqList;
	}

	public List<SelectItem> getProrataYnList() {
		return prorataYnList;
	}

	public void setProrataYnList(List<SelectItem> prorataYnList) {
		this.prorataYnList = prorataYnList;
	}

	public List<SelectItem> getTaxableYnList() {
		return taxableYnList;
	}

	public void setTaxableYnList(List<SelectItem> taxableYnList) {
		this.taxableYnList = taxableYnList;
	}
	
	public String deleteAndCommit(){
		
		CommonUtils utils=new CommonUtils();
		PM_AGENT_BONUS_SETUP_DELEGATE delegate=new PM_AGENT_BONUS_SETUP_DELEGATE();
		PM_AGENT_BONUS_SETUP_HELPER  helper=new PM_AGENT_BONUS_SETUP_HELPER();
		try {
			helper.pre_delete(PM_AGENT_BONUS_SETUP_BEAN);
			delegate.executeDeleteForAgentBonusSetup(PM_AGENT_BONUS_SETUP_BEAN);
			utils.doComitt();
			String message=Messages.getString("messageProperties", "errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void duplicateValidationCheck() throws ValidatorException{
		
		clearMaps();
		PM_AGENT_BONUS_SETUP valueBean=this.getPM_AGENT_BONUS_SETUP_BEAN();
		String rowId=null;
		String absCode=null;
		absCode=valueBean.getABS_CODE();
		String sqlQuery1=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_SETUP_DUPLICATE_RECORD_CHECK;
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		boolean canGoAhead = false;
		try{
			
			Connection connection=CommonUtils.getConnection();
			System.out.println("-----------------> ROWID in duplicateValidationCheck: "+valueBean.getROWID());
			resultSet=handler.executeSelectStatement(sqlQuery1, connection, new Object[]{absCode});

			if(resultSet.next()){
				rowId = resultSet.getString("ROWID");
				// Insert check
				if(valueBean.getROWID() == null){
					canGoAhead = false;
				}else if(rowId.equals(valueBean.getROWID())){
					canGoAhead = true;
				}else{
					canGoAhead = false;
				}
			}else{
				canGoAhead = true;
			}
			if(!canGoAhead){
				String bonusCodeString=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_SETUP$ABS_CODE$VALIDATIION_STRING");
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "90015",new Object[]{bonusCodeString}));
			}
			
		}catch(DBException exception){
			exception.printStackTrace();
		}catch(SQLException exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void clearMaps(){
		getWarningMap().clear();
		getErrorMap().clear();
	}
	
	public String preBack()
	{
		String actionClass = "PM094_A_SEARCH_ACTION";
		String actionMethod = "fetchAgentBonusDetails";
		String returnString= "goToAgentBonusSearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
	
	public void onLoad(PhaseEvent event){
		PM_AGENT_BONUS_SETUP_DELEGATE delegate = new PM_AGENT_BONUS_SETUP_DELEGATE();
		PM_AGENT_BONUS_SETUP_HELPER pm_agent_bonus_setup_helper = new PM_AGENT_BONUS_SETUP_HELPER();
		try {
			if(isBlockFlag()){
				delegate.fetchAgentBonusSetupDetails(compositeAction);
				if(PM_AGENT_BONUS_SETUP_BEAN.getROWID() != null){
					pm_agent_bonus_setup_helper.post_query(PM_AGENT_BONUS_SETUP_BEAN);
				}else{
					pm_agent_bonus_setup_helper.when_create_record(PM_AGENT_BONUS_SETUP_BEAN);
				}
				pm_agent_bonus_setup_helper.when_new_record_instance(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}

	

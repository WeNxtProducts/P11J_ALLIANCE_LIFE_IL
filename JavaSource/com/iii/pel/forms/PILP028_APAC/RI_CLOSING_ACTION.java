package com.iii.pel.forms.PILP028_APAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class RI_CLOSING_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_TREATY_CODE_LABEL;
	
	private HtmlOutputText CAPTIONTEXT;

	private HtmlInputText COMP_UI_M_TREATY_CODE;

	private HtmlOutputLabel COMP_UI_M_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PERIOD;

	private HtmlOutputLabel COMP_UI_M_SRNO_LABEL;

	private HtmlInputText COMP_UI_M_SRNO;

	private HtmlOutputLabel COMP_UI_M_ASSR_CODE_FM_LABEL;

	private HtmlInputText COMP_UI_M_ASSR_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_ASSR_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_ASSR_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_RI_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_RI_FM_DT;

	private HtmlOutputLabel COMP_UI_M_RI_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_RI_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_ASSR_TO;

	private HtmlCommandButton COMP_UI_M_RI_CLOSING_OK;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_TREATY_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_SLNO;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_ASSR_FM;

	private List<SelectItem> periodList = new ArrayList<SelectItem>();

	private RI_CLOSING_HELPER RI_CLOSING_HELPER = null;

	private List treatyCodeList = new ArrayList();

	private List assrCodeFmList = new ArrayList();

	private List assrCodeToList = new ArrayList();

	private List serialNoList = new ArrayList();

	private RI_CLOSING RI_CLOSING_BEAN;

	private RI_CLOSING_DELEGATE ri_closing_delegate = null;

	public RI_CLOSING_ACTION() {
		RI_CLOSING_BEAN = new RI_CLOSING();
		CAPTIONTEXT = new HtmlOutputText();
		ri_closing_delegate = new RI_CLOSING_DELEGATE();
	    RI_CLOSING_HELPER = new RI_CLOSING_HELPER();
		periodList = ri_closing_delegate.comboBoxValues("PILP028_APAC","RI_CLOSING", "RI_CLOSING.M_PERIOD", "MUDH_YEAR");
		if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1").equals("C")) {
			CAPTIONTEXT.setValue("RI Batch Closing");
		}else if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1").equals("O")) {
			CAPTIONTEXT.setValue("RI Batch Opening");
		}
		
	}
	
	public HtmlOutputLabel getCOMP_UI_M_TREATY_CODE_LABEL() {
		return COMP_UI_M_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TREATY_CODE() {
		return COMP_UI_M_TREATY_CODE;
	}

	public void setCOMP_UI_M_TREATY_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_TREATY_CODE_LABEL) {
		this.COMP_UI_M_TREATY_CODE_LABEL = COMP_UI_M_TREATY_CODE_LABEL;
	}

	public void setCOMP_UI_M_TREATY_CODE(HtmlInputText COMP_UI_M_TREATY_CODE) {
		this.COMP_UI_M_TREATY_CODE = COMP_UI_M_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PERIOD_LABEL() {
		return COMP_UI_M_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PERIOD() {
		return COMP_UI_M_PERIOD;
	}

	public void setCOMP_UI_M_PERIOD_LABEL(HtmlOutputLabel COMP_UI_M_PERIOD_LABEL) {
		this.COMP_UI_M_PERIOD_LABEL = COMP_UI_M_PERIOD_LABEL;
	}

	public void setCOMP_UI_M_PERIOD(HtmlSelectOneMenu COMP_UI_M_PERIOD) {
		this.COMP_UI_M_PERIOD = COMP_UI_M_PERIOD;
	}

	public HtmlOutputLabel getCOMP_UI_M_SRNO_LABEL() {
		return COMP_UI_M_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SRNO() {
		return COMP_UI_M_SRNO;
	}

	public void setCOMP_UI_M_SRNO_LABEL(HtmlOutputLabel COMP_UI_M_SRNO_LABEL) {
		this.COMP_UI_M_SRNO_LABEL = COMP_UI_M_SRNO_LABEL;
	}

	public void setCOMP_UI_M_SRNO(HtmlInputText COMP_UI_M_SRNO) {
		this.COMP_UI_M_SRNO = COMP_UI_M_SRNO;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSR_CODE_FM_LABEL() {
		return COMP_UI_M_ASSR_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSR_CODE_FM() {
		return COMP_UI_M_ASSR_CODE_FM;
	}

	public void setCOMP_UI_M_ASSR_CODE_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_ASSR_CODE_FM_LABEL) {
		this.COMP_UI_M_ASSR_CODE_FM_LABEL = COMP_UI_M_ASSR_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_ASSR_CODE_FM(HtmlInputText COMP_UI_M_ASSR_CODE_FM) {
		this.COMP_UI_M_ASSR_CODE_FM = COMP_UI_M_ASSR_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSR_CODE_TO_LABEL() {
		return COMP_UI_M_ASSR_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSR_CODE_TO() {
		return COMP_UI_M_ASSR_CODE_TO;
	}

	public void setCOMP_UI_M_ASSR_CODE_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_ASSR_CODE_TO_LABEL) {
		this.COMP_UI_M_ASSR_CODE_TO_LABEL = COMP_UI_M_ASSR_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_ASSR_CODE_TO(HtmlInputText COMP_UI_M_ASSR_CODE_TO) {
		this.COMP_UI_M_ASSR_CODE_TO = COMP_UI_M_ASSR_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_RI_FM_DT_LABEL() {
		return COMP_UI_M_RI_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_RI_FM_DT() {
		return COMP_UI_M_RI_FM_DT;
	}

	public void setCOMP_UI_M_RI_FM_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_RI_FM_DT_LABEL) {
		this.COMP_UI_M_RI_FM_DT_LABEL = COMP_UI_M_RI_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_RI_FM_DT(HtmlCalendar COMP_UI_M_RI_FM_DT) {
		this.COMP_UI_M_RI_FM_DT = COMP_UI_M_RI_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_RI_TO_DT_LABEL() {
		return COMP_UI_M_RI_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_RI_TO_DT() {
		return COMP_UI_M_RI_TO_DT;
	}

	public void setCOMP_UI_M_RI_TO_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_RI_TO_DT_LABEL) {
		this.COMP_UI_M_RI_TO_DT_LABEL = COMP_UI_M_RI_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_RI_TO_DT(HtmlCalendar COMP_UI_M_RI_TO_DT) {
		this.COMP_UI_M_RI_TO_DT = COMP_UI_M_RI_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_ASSR_TO() {
		return COMP_UI_M_BUT_LOV_ASSR_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_ASSR_TO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_ASSR_TO) {
		this.COMP_UI_M_BUT_LOV_ASSR_TO = COMP_UI_M_BUT_LOV_ASSR_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_RI_CLOSING_OK() {
		return COMP_UI_M_RI_CLOSING_OK;
	}

	public void setCOMP_UI_M_RI_CLOSING_OK(
			HtmlCommandButton COMP_UI_M_RI_CLOSING_OK) {
		this.COMP_UI_M_RI_CLOSING_OK = COMP_UI_M_RI_CLOSING_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_TREATY_CODE() {
		return COMP_UI_M_BUTT_LOV_TREATY_CODE;
	}

	public void setCOMP_UI_M_BUTT_LOV_TREATY_CODE(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_TREATY_CODE) {
		this.COMP_UI_M_BUTT_LOV_TREATY_CODE = COMP_UI_M_BUTT_LOV_TREATY_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_SLNO() {
		return COMP_UI_M_BUT_LOV_SLNO;
	}

	public void setCOMP_UI_M_BUT_LOV_SLNO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_SLNO) {
		this.COMP_UI_M_BUT_LOV_SLNO = COMP_UI_M_BUT_LOV_SLNO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_ASSR_FM() {
		return COMP_UI_M_BUT_LOV_ASSR_FM;
	}

	public void setCOMP_UI_M_BUT_LOV_ASSR_FM(
			HtmlCommandButton COMP_UI_M_BUT_LOV_ASSR_FM) {
		this.COMP_UI_M_BUT_LOV_ASSR_FM = COMP_UI_M_BUT_LOV_ASSR_FM;
	}

	public RI_CLOSING getRI_CLOSING_BEAN() {
		return RI_CLOSING_BEAN;
	}

	public void setRI_CLOSING_BEAN(RI_CLOSING RI_CLOSING_BEAN) {
		this.RI_CLOSING_BEAN = RI_CLOSING_BEAN;
	}

	public List<SelectItem> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<SelectItem> periodList) {
		this.periodList = periodList;
	}

	public List getTreatyCodeList() {
		return treatyCodeList;
	}

	public void setTreatyCodeList(List treatyCodeList) {
		this.treatyCodeList = treatyCodeList;
	}

	public List getAssrCodeFmList() {
		return assrCodeFmList;
	}

	public void setAssrCodeFmList(List assrCodeFmList) {
		this.assrCodeFmList = assrCodeFmList;
	}

	public List getAssrCodeToList() {
		return assrCodeToList;
	}

	public void setAssrCodeToList(List assrCodeToList) {
		this.assrCodeToList = assrCodeToList;
	}

	public List getSerialNoList() {
		return serialNoList;
	}

	public void setSerialNoList(List serialNoList) {
		this.serialNoList = serialNoList;
	}

	public List suggestionAction(Object obj) {

		String treatyCode = (String) obj;
		treatyCodeList = new RI_CLOSING_DELEGATE().treatyCodeLov(treatyCode,treatyCodeList);
		return treatyCodeList;
	}

	/*public List suggForAssFm(Object obj) {
		String assrFmCode = (String) obj;
		assrCodeFmList = new RI_CLOSING_DELEGATE().assrCodeFmLov(assrFmCode,assrCodeFmList);
		return assrCodeFmList;
	}*/
	 public ArrayList<LovBean> suggForAssFm(Object currValue) {
			String code = (String) currValue;
			ArrayList<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			try {
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
						+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<=?"
	                    +"ORDER BY 1ASC";
				} else {
					object = new Object[] { //code + "%",
							PELConstants.suggetionRecordSize };
					query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
						+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<=?"
						+ "AND CONT_CODE LIKE '" + code.toUpperCase() + "%'"
						+"ORDER BY 1ASC";
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}	 
	/*public List suggForAssTo(Object object) {
		String assrToCode = (String) object;
		assrCodeToList = new RI_CLOSING_DELEGATE().assrCodeToLov(assrToCode,assrCodeToList);
		return assrCodeToList;
	}
*/
	 
	 public ArrayList<LovBean> suggForAssTo(Object currValue) {
			String code = (String) currValue;
			ArrayList<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			try {
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
						+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<=?"
	                    +"ORDER BY 1ASC";
				} else {
					object = new Object[] { //code + "%",
							PELConstants.suggetionRecordSize };
					query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
						+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<=?"
						+ "AND CONT_CODE LIKE '" + code.toUpperCase() + "%'"
						+"ORDER BY 1ASC";
				}
				suggestionList = ListItemUtil.prepareSuggestionList(query, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
	 
	public List suggActionForSno(Object obj) {
		String sNo = (String) obj;
		String ttyCode = (String) CommonUtils.getCurrentValue(getCOMP_UI_M_TREATY_CODE());
		serialNoList = new RI_CLOSING_DELEGATE().sNoLov(sNo, serialNoList,ttyCode);
		return serialNoList;
	}

	/* validation for RI CLOSING */

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void assuredCodeFmValueSetting(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String assuredCodeFm = (String) input.getSubmittedValue();
		if(assuredCodeFm!=null && !assuredCodeFm.trim().equals("")){
			getCOMP_UI_M_ASSR_CODE_FM().setSubmittedValue(assuredCodeFm);
			getRI_CLOSING_BEAN().setUI_M_ASSR_CODE_FM(assuredCodeFm);
			getRI_CLOSING_BEAN().setUI_M_ASSR_CODE_TO(assuredCodeFm);
			getCOMP_UI_M_ASSR_CODE_TO().setSubmittedValue(assuredCodeFm);
		}else{
			RI_CLOSING_HELPER helper = new RI_CLOSING_HELPER();
			assuredCodeFm = (String) helper.P_SET_FIRST_FIELD(assuredCodeFm);
			getCOMP_UI_M_ASSR_CODE_FM().setSubmittedValue(assuredCodeFm);
			getRI_CLOSING_BEAN().setUI_M_ASSR_CODE_FM(assuredCodeFm);
		}
		fireFieldValidation(event);
	}

	public void assuredCodeToValueSetting(ActionEvent actionEvent){
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String assrCodeFrom = getRI_CLOSING_BEAN().getUI_M_ASSR_CODE_FM();
		
		String assrCodeTo = (String)input.getSubmittedValue();
		try {
			if(assrCodeTo!=null && !assrCodeTo.trim().equals("") && !assrCodeFrom.equals("0")){
				getCOMP_UI_M_ASSR_CODE_TO().setSubmittedValue(assrCodeTo);
			}else{
				RI_CLOSING_HELPER helper = new RI_CLOSING_HELPER();
				assrCodeTo = (String) helper.P_SET_SECOND_FIELD(assrCodeFrom, assrCodeTo);
				getCOMP_UI_M_ASSR_CODE_TO().setSubmittedValue(assrCodeTo);
			}
			fireFieldValidation(actionEvent);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}

	}

	public void treatyCodeValidation(FacesContext facesContext,UIComponent component, Object object) throws ValidatorException{
		try {
			if (COMP_UI_M_TREATY_CODE.getSubmittedValue() != null) {
				String treatyCode = (String) object ;
				RI_CLOSING_HELPER.treatyCodeWhenValidate(treatyCode);
				RI_CLOSING_BEAN.setUI_M_TREATY_CODE(treatyCode);
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




	public void riPeriodValidation(FacesContext facesContext,UIComponent component, Object object) throws ValidatorException{
		try {
			Integer period = (Integer) object;
			RI_CLOSING_HELPER.closingPeriodWhenValidate(period);
			RI_CLOSING_BEAN.setUI_M_PERIOD(period);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void sNoValidation(FacesContext context, UIComponent component,Object object) throws ValidatorException{
		try {
			if (object != null  &&  RI_CLOSING_BEAN.getUI_M_TREATY_CODE() != null) {
				String code = (String) RI_CLOSING_BEAN.getUI_M_TREATY_CODE();
				Integer sNo = (Integer) object; 
				RI_CLOSING_HELPER.sNoWhenValidate(code, sNo);
				RI_CLOSING_BEAN.setUI_M_SRNO(sNo);
				RI_CLOSING_HELPER.defaultDates(RI_CLOSING_BEAN);
				COMP_UI_M_RI_FM_DT.resetValue();
				COMP_UI_M_RI_TO_DT.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void assrFmCodeValidation(FacesContext facesContext,UIComponent component, Object object) throws ValidatorException {
		try {
			String assrCodeFrm = (String) object;
			if (assrCodeFrm != null) {
				RI_CLOSING_HELPER.assrCodeWhenValidate(assrCodeFrm);
				RI_CLOSING_BEAN.setUI_M_ASSR_CODE_FM(assrCodeFrm);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void assrToCodeValidation(FacesContext facesContext,UIComponent component, Object object) throws ValidatorException {
		try {
			if (COMP_UI_M_ASSR_CODE_TO.getSubmittedValue() != null) {
				String assrCodeTo = (String)object;
				RI_CLOSING_HELPER.assrCodeToWhenValidate(assrCodeTo);
				RI_CLOSING_BEAN.setUI_M_ASSR_CODE_TO(assrCodeTo);
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}


	}

	public void fromDateValidation(FacesContext facesContext,UIComponent component, Object object) throws ValidatorException{

		try {
			Date fromDate = (Date) object;
			RI_CLOSING_BEAN.setUI_M_RI_FM_DT(fromDate);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void toDateValidation(FacesContext facesContext,UIComponent component, Object object) {
		try {
			Date toDate = (Date) object;
			RI_CLOSING_BEAN.setUI_M_RI_TO_DT(toDate);
			Date M_RI_FM_DT = RI_CLOSING_BEAN.getUI_M_RI_FM_DT();
			if(toDate.compareTo(M_RI_FM_DT)<0){
				throw new Exception("To date should be greater than From Date");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void okButtonCall(ActionEvent event) {
		try {
			RI_CLOSING_HELPER.RI_CLOSING_M_RI_CLOCING_OK_BUTTON_PRESSED(this, event);
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "60305"));
			getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "60305"));
			getCOMP_UI_M_RI_CLOSING_OK().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}

	public HtmlOutputText getCAPTIONTEXT() {
		return CAPTIONTEXT;
	}

	public void setCAPTIONTEXT(HtmlOutputText captiontext) {
		CAPTIONTEXT = captiontext;
	}

	

}

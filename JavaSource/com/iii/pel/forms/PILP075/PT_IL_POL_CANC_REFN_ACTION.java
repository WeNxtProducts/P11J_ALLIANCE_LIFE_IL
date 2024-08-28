package com.iii.pel.forms.PILP075;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_POL_CANC_REFN_ACTION extends CommonReportAction {

	private PT_IL_POL_CANC_REFN  PT_IL_POL_CANC_REFN_BEAN;
	private PT_IL_POL_CANC_REFN_HELPER HELPER;
	public PILP075_COMPOSITE_ACTION compositeAction;
	private PT_IL_POL_CANC_REFN_DELEGATE delegate;

	private List<LovBean> suggesionList = null;

	public PILP075_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILP075_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PT_IL_POL_CANC_REFN_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PT_IL_POL_CANC_REFN_DELEGATE delegate) {
		this.delegate = delegate;
	}

	private HtmlOutputLabel COMP_PCF_POL_NO_LABEL;
	private HtmlInputText COMP_PCF_POL_NO;

	private HtmlOutputLabel COMP_PCF_REFUND_DT_LABEL;
	private HtmlCalendar COMP_PCF_REFUND_DT;

	private HtmlOutputLabel COMP_PCF_MONT_ELAP_LABEL;
	private HtmlInputText COMP_PCF_MONT_ELAP;

	private HtmlOutputLabel COMP_PCF_POL_CONT_CODE_LABEL;
	private HtmlInputText COMP_PCF_POL_CONT_CODE;

	private HtmlOutputLabel COMP_PCF_POL_ISSUE_DT_LABEL;
	private HtmlCalendar COMP_PCF_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_PCF_COMM_LC_RFND_LABEL;
	private HtmlInputText COMP_PCF_COMM_LC_RFND;

	private HtmlOutputLabel COMP_PCF_FLEX_07_LABEL;
	private HtmlInputText COMP_PCF_FLEX_07;

	private HtmlOutputLabel COMP_PCF_FLEX_08_LABEL;
	private HtmlInputText COMP_PCF_FLEX_08;

	private HtmlOutputLabel COMP_PCF_FLEX_09_LABEL;
	private HtmlInputText COMP_PCF_FLEX_09;


	private HtmlOutputLabel COMP_PCF_MEI_REF_FC_LABEL;
	private HtmlInputText COMP_PCF_MEI_REF_FC;

	private HtmlOutputLabel COMP_PCF_FLEX_11_LABEL;
	private HtmlInputText COMP_PCF_FLEX_11;

	private HtmlOutputLabel COMP_PCF_FLEX_12_LABEL;
	private HtmlInputText COMP_PCF_FLEX_12;

	private HtmlOutputLabel COMP_PCF_PAID_PREM_LC_LABEL;
	private HtmlInputText COMP_PCF_PAID_PREM_LC;

	private HtmlOutputLabel COMP_PCF_MED_FEE_LC_LABEL;
	private HtmlInputText COMP_PCF_MED_FEE_LC;

	private HtmlOutputLabel COMP_PCF_DOC_FEE_LC_LABEL;
	private HtmlInputText COMP_PCF_DOC_FEE_LC;

	private HtmlCommandButton COMP_CANCL_BTN;
	private HtmlCommandLink COMP_SAVE_BTN;


	public List<LovBean> getSuggesionList() {
		return suggesionList;
	}
	public void setSuggesionList(List<LovBean> suggesionList) {
		this.suggesionList = suggesionList;
	}
	public void onLoad(PhaseEvent event) throws Exception {

		/*		if (isFormFlag()) 
		{
			CommonUtils.clearMaps(this);

			//setFormFlag(false);
		}
		 */
		if (isBlockFlag()) 
		{
			getErrorMap().clear();
			getWarningMap().clear();
			
			System.out.println("Row ID   : " +	compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID());
			//	PT_IL_POL_CANC_REFN_BEAN.setROWID(CommonUtils.getGlobalVariable("GLOBAL:ROWID"));
			if(compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID()!=null)
			{
				delegate.executeQuery(compositeAction);
				System.out.println("AFTER DELEGATE METHOD *********");

				/*Modified by Ram on 05/02/2017 for Disable functionalities
				 * 
				 * if("CRN".equalsIgnoreCase(PT_IL_POL_CANC_REFN_BEAN.getPCF_FLEX_01()))*/
				if(PT_IL_POL_CANC_REFN_BEAN.getPCF_FLEX_01() != null)
				{
					COMP_PCF_POL_NO.setDisabled(true);
					COMP_PCF_REFUND_DT.setDisabled(true);
					COMP_CANCL_BTN.setDisabled(true);
					COMP_SAVE_BTN.setDisabled(true);
					
/*Added By Dhinesh on 4.2.2017 for Add CreditNote Report*/ 
					COMP_CREDIT_PRINT_BTN.setDisabled(false);
/*End*/
				}
/*End*/

			}

			//preInsert();
			setBlockFlag(false);
			resetAllcomponent();
		}


	}

	public HtmlCommandButton getCOMP_CANCL_BTN() {
		return COMP_CANCL_BTN;
	}
	public void setCOMP_CANCL_BTN(HtmlCommandButton cOMP_CANCL_BTN) {
		COMP_CANCL_BTN = cOMP_CANCL_BTN;
	}
	public HtmlCommandLink getCOMP_SAVE_BTN() {
		return COMP_SAVE_BTN;
	}
	public void setCOMP_SAVE_BTN(HtmlCommandLink cOMP_SAVE_BTN) {
		COMP_SAVE_BTN = cOMP_SAVE_BTN;
	}
	public PT_IL_POL_CANC_REFN_ACTION() 
	{
		PT_IL_POL_CANC_REFN_BEAN = new PT_IL_POL_CANC_REFN();
		HELPER   = new PT_IL_POL_CANC_REFN_HELPER();
		delegate = new PT_IL_POL_CANC_REFN_DELEGATE();
		instantiateAllComponent();

	}
	public void instantiateAllComponent() 
	{
		COMP_PCF_POL_NO_LABEL = new HtmlOutputLabel();
		COMP_PCF_REFUND_DT_LABEL = new HtmlOutputLabel();
		COMP_PCF_MONT_ELAP_LABEL = new HtmlOutputLabel();
		COMP_PCF_POL_CONT_CODE_LABEL = new HtmlOutputLabel();
		COMP_PCF_COMM_LC_RFND_LABEL = new HtmlOutputLabel();
		COMP_PCF_FLEX_07_LABEL = new HtmlOutputLabel();
		COMP_PCF_FLEX_08_LABEL = new HtmlOutputLabel();
		COMP_PCF_FLEX_09_LABEL = new HtmlOutputLabel();
		COMP_PCF_MEI_REF_FC_LABEL = new HtmlOutputLabel();
		COMP_PCF_FLEX_11_LABEL = new HtmlOutputLabel();
		COMP_PCF_FLEX_12_LABEL = new HtmlOutputLabel();
		COMP_PCF_PAID_PREM_LC_LABEL = new HtmlOutputLabel();
		COMP_PCF_MED_FEE_LC_LABEL = new HtmlOutputLabel();
		COMP_PCF_DOC_FEE_LC_LABEL = new HtmlOutputLabel();
		COMP_PCF_COMM_LC_RFND_LABEL = new HtmlOutputLabel();
		COMP_PCF_POL_ISSUE_DT_LABEL = new HtmlOutputLabel();
		COMP_CANCL_BTN = new  HtmlCommandButton();
		COMP_SAVE_BTN = new HtmlCommandLink();

		COMP_PCF_POL_NO = new HtmlInputText();
		COMP_PCF_REFUND_DT = new HtmlCalendar();
		COMP_PCF_MONT_ELAP = new HtmlInputText();
		COMP_PCF_POL_CONT_CODE = new HtmlInputText();
		COMP_PCF_COMM_LC_RFND = new HtmlInputText();
		COMP_PCF_FLEX_07 = new HtmlInputText();
		COMP_PCF_FLEX_08 = new HtmlInputText();
		COMP_PCF_FLEX_09 = new HtmlInputText();
		COMP_PCF_MEI_REF_FC = new HtmlInputText();
		COMP_PCF_FLEX_11 = new HtmlInputText();
		COMP_PCF_FLEX_12 = new HtmlInputText();
		COMP_PCF_PAID_PREM_LC = new HtmlInputText();
		COMP_PCF_MED_FEE_LC = new HtmlInputText();
		COMP_PCF_DOC_FEE_LC = new HtmlInputText();
		COMP_PCF_COMM_LC_RFND = new HtmlInputText();
		COMP_PCF_POL_ISSUE_DT = new HtmlCalendar();

	}

	public void resetAllcomponent()
	{
		//COMP_PCF_POL_NO.resetValue();
		//COMP_PCF_REFUND_DT.resetValue();
		COMP_PCF_MONT_ELAP.resetValue();
		COMP_PCF_POL_CONT_CODE.resetValue();
		COMP_PCF_COMM_LC_RFND.resetValue();
		COMP_PCF_FLEX_07.resetValue();
		COMP_PCF_FLEX_08.resetValue();
		COMP_PCF_FLEX_09.resetValue();
		COMP_PCF_MEI_REF_FC.resetValue();
		COMP_PCF_FLEX_11.resetValue();
		COMP_PCF_FLEX_12.resetValue();
		COMP_PCF_PAID_PREM_LC.resetValue();
		COMP_PCF_MED_FEE_LC.resetValue();
		COMP_PCF_DOC_FEE_LC.resetValue();
		COMP_PCF_COMM_LC_RFND.resetValue();
		COMP_PCF_POL_ISSUE_DT.resetValue();
	}

	public HtmlOutputLabel getCOMP_PCF_POL_NO_LABEL() {
		return COMP_PCF_POL_NO_LABEL;
	}




	public void setCOMP_PCF_POL_NO_LABEL(HtmlOutputLabel cOMP_PCF_POL_NO_LABEL) {
		COMP_PCF_POL_NO_LABEL = cOMP_PCF_POL_NO_LABEL;
	}




	public HtmlInputText getCOMP_PCF_POL_NO() {
		return COMP_PCF_POL_NO;
	}




	public void setCOMP_PCF_POL_NO(HtmlInputText cOMP_PCF_POL_NO) {
		COMP_PCF_POL_NO = cOMP_PCF_POL_NO;
	}




	public HtmlOutputLabel getCOMP_PCF_FLEX_12_LABEL() {
		return COMP_PCF_FLEX_12_LABEL;
	}




	public void setCOMP_PCF_FLEX_12_LABEL(HtmlOutputLabel cOMP_PCF_FLEX_12_LABEL) {
		COMP_PCF_FLEX_12_LABEL = cOMP_PCF_FLEX_12_LABEL;
	}




	public HtmlInputText getCOMP_PCF_FLEX_12() {
		return COMP_PCF_FLEX_12;
	}




	public void setCOMP_PCF_FLEX_12(HtmlInputText cOMP_PCF_FLEX_12) {
		COMP_PCF_FLEX_12 = cOMP_PCF_FLEX_12;
	}




	public PT_IL_POL_CANC_REFN getPT_IL_POL_CANC_REFN_BEAN() {
		return PT_IL_POL_CANC_REFN_BEAN;
	}




	public void setPT_IL_POL_CANC_REFN_BEAN(
			PT_IL_POL_CANC_REFN pT_IL_POL_CANC_REFN_BEAN) {
		PT_IL_POL_CANC_REFN_BEAN = pT_IL_POL_CANC_REFN_BEAN;
	}




	public PT_IL_POL_CANC_REFN_HELPER getHELPER() {
		return HELPER;
	}




	public void setHELPER(PT_IL_POL_CANC_REFN_HELPER hELPER) {
		HELPER = hELPER;
	}




	public HtmlOutputLabel getCOMP_PCF_REFUND_DT_LABEL() {
		return COMP_PCF_REFUND_DT_LABEL;
	}




	public void setCOMP_PCF_REFUND_DT_LABEL(HtmlOutputLabel cOMP_PCF_REFUND_DT_LABEL) {
		COMP_PCF_REFUND_DT_LABEL = cOMP_PCF_REFUND_DT_LABEL;
	}




	public HtmlCalendar getCOMP_PCF_REFUND_DT() {
		return COMP_PCF_REFUND_DT;
	}




	public void setCOMP_PCF_REFUND_DT(HtmlCalendar cOMP_PCF_REFUND_DT) {
		COMP_PCF_REFUND_DT = cOMP_PCF_REFUND_DT;
	}




	public HtmlOutputLabel getCOMP_PCF_MONT_ELAP_LABEL() {
		return COMP_PCF_MONT_ELAP_LABEL;
	}




	public void setCOMP_PCF_MONT_ELAP_LABEL(HtmlOutputLabel cOMP_PCF_MONT_ELAP_LABEL) {
		COMP_PCF_MONT_ELAP_LABEL = cOMP_PCF_MONT_ELAP_LABEL;
	}




	public HtmlInputText getCOMP_PCF_MONT_ELAP() {
		return COMP_PCF_MONT_ELAP;
	}




	public void setCOMP_PCF_MONT_ELAP(HtmlInputText cOMP_PCF_MONT_ELAP) {
		COMP_PCF_MONT_ELAP = cOMP_PCF_MONT_ELAP;
	}




	public HtmlOutputLabel getCOMP_PCF_POL_CONT_CODE_LABEL() {
		return COMP_PCF_POL_CONT_CODE_LABEL;
	}




	public void setCOMP_PCF_POL_CONT_CODE_LABEL(
			HtmlOutputLabel cOMP_PCF_POL_CONT_CODE_LABEL) {
		COMP_PCF_POL_CONT_CODE_LABEL = cOMP_PCF_POL_CONT_CODE_LABEL;
	}




	public HtmlInputText getCOMP_PCF_POL_CONT_CODE() {
		return COMP_PCF_POL_CONT_CODE;
	}




	public void setCOMP_PCF_POL_CONT_CODE(HtmlInputText cOMP_PCF_POL_CONT_CODE) {
		COMP_PCF_POL_CONT_CODE = cOMP_PCF_POL_CONT_CODE;
	}




	public HtmlOutputLabel getCOMP_PCF_POL_ISSUE_DT_LABEL() {
		return COMP_PCF_POL_ISSUE_DT_LABEL;
	}




	public void setCOMP_PCF_POL_ISSUE_DT_LABEL(
			HtmlOutputLabel cOMP_PCF_POL_ISSUE_DT_LABEL) {
		COMP_PCF_POL_ISSUE_DT_LABEL = cOMP_PCF_POL_ISSUE_DT_LABEL;
	}




	public HtmlCalendar getCOMP_PCF_POL_ISSUE_DT() {
		return COMP_PCF_POL_ISSUE_DT;
	}




	public void setCOMP_PCF_POL_ISSUE_DT(HtmlCalendar cOMP_PCF_POL_ISSUE_DT) {
		COMP_PCF_POL_ISSUE_DT = cOMP_PCF_POL_ISSUE_DT;
	}




	public HtmlOutputLabel getCOMP_PCF_COMM_LC_RFND_LABEL() {
		return COMP_PCF_COMM_LC_RFND_LABEL;
	}




	public void setCOMP_PCF_COMM_LC_RFND_LABEL(
			HtmlOutputLabel cOMP_PCF_COMM_LC_RFND_LABEL) {
		COMP_PCF_COMM_LC_RFND_LABEL = cOMP_PCF_COMM_LC_RFND_LABEL;
	}




	public HtmlInputText getCOMP_PCF_COMM_LC_RFND() {
		return COMP_PCF_COMM_LC_RFND;
	}




	public void setCOMP_PCF_COMM_LC_RFND(HtmlInputText cOMP_PCF_COMM_LC_RFND) {
		COMP_PCF_COMM_LC_RFND = cOMP_PCF_COMM_LC_RFND;
	}




	public HtmlOutputLabel getCOMP_PCF_FLEX_07_LABEL() {
		return COMP_PCF_FLEX_07_LABEL;
	}




	public void setCOMP_PCF_FLEX_07_LABEL(HtmlOutputLabel cOMP_PCF_FLEX_07_LABEL) {
		COMP_PCF_FLEX_07_LABEL = cOMP_PCF_FLEX_07_LABEL;
	}




	public HtmlInputText getCOMP_PCF_FLEX_07() {
		return COMP_PCF_FLEX_07;
	}




	public void setCOMP_PCF_FLEX_07(HtmlInputText cOMP_PCF_FLEX_07) {
		COMP_PCF_FLEX_07 = cOMP_PCF_FLEX_07;
	}




	public HtmlOutputLabel getCOMP_PCF_FLEX_08_LABEL() {
		return COMP_PCF_FLEX_08_LABEL;
	}




	public void setCOMP_PCF_FLEX_08_LABEL(HtmlOutputLabel cOMP_PCF_FLEX_08_LABEL) {
		COMP_PCF_FLEX_08_LABEL = cOMP_PCF_FLEX_08_LABEL;
	}




	public HtmlInputText getCOMP_PCF_FLEX_08() {
		return COMP_PCF_FLEX_08;
	}




	public void setCOMP_PCF_FLEX_08(HtmlInputText cOMP_PCF_FLEX_08) {
		COMP_PCF_FLEX_08 = cOMP_PCF_FLEX_08;
	}




	public HtmlOutputLabel getCOMP_PCF_FLEX_09_LABEL() {
		return COMP_PCF_FLEX_09_LABEL;
	}




	public void setCOMP_PCF_FLEX_09_LABEL(HtmlOutputLabel cOMP_PCF_FLEX_09_LABEL) {
		COMP_PCF_FLEX_09_LABEL = cOMP_PCF_FLEX_09_LABEL;
	}




	public HtmlInputText getCOMP_PCF_FLEX_09() {
		return COMP_PCF_FLEX_09;
	}




	public void setCOMP_PCF_FLEX_09(HtmlInputText cOMP_PCF_FLEX_09) {
		COMP_PCF_FLEX_09 = cOMP_PCF_FLEX_09;
	}









	public HtmlOutputLabel getCOMP_PCF_MEI_REF_FC_LABEL() {
		return COMP_PCF_MEI_REF_FC_LABEL;
	}
	public void setCOMP_PCF_MEI_REF_FC_LABEL(
			HtmlOutputLabel cOMP_PCF_MEI_REF_FC_LABEL) {
		COMP_PCF_MEI_REF_FC_LABEL = cOMP_PCF_MEI_REF_FC_LABEL;
	}
	public HtmlInputText getCOMP_PCF_MEI_REF_FC() {
		return COMP_PCF_MEI_REF_FC;
	}
	public void setCOMP_PCF_MEI_REF_FC(HtmlInputText cOMP_PCF_MEI_REF_FC) {
		COMP_PCF_MEI_REF_FC = cOMP_PCF_MEI_REF_FC;
	}
	public HtmlOutputLabel getCOMP_PCF_FLEX_11_LABEL() {
		return COMP_PCF_FLEX_11_LABEL;
	}




	public void setCOMP_PCF_FLEX_11_LABEL(HtmlOutputLabel cOMP_PCF_FLEX_11_LABEL) {
		COMP_PCF_FLEX_11_LABEL = cOMP_PCF_FLEX_11_LABEL;
	}




	public HtmlInputText getCOMP_PCF_FLEX_11() {
		return COMP_PCF_FLEX_11;
	}




	public void setCOMP_PCF_FLEX_11(HtmlInputText cOMP_PCF_FLEX_11) {
		COMP_PCF_FLEX_11 = cOMP_PCF_FLEX_11;
	}




	public HtmlOutputLabel getCOMP_PCF_PAID_PREM_LC_LABEL() {
		return COMP_PCF_PAID_PREM_LC_LABEL;
	}




	public void setCOMP_PCF_PAID_PREM_LC_LABEL(
			HtmlOutputLabel cOMP_PCF_PAID_PREM_LC_LABEL) {
		COMP_PCF_PAID_PREM_LC_LABEL = cOMP_PCF_PAID_PREM_LC_LABEL;
	}




	public HtmlInputText getCOMP_PCF_PAID_PREM_LC() {
		return COMP_PCF_PAID_PREM_LC;
	}




	public void setCOMP_PCF_PAID_PREM_LC(HtmlInputText cOMP_PCF_PAID_PREM_LC) {
		COMP_PCF_PAID_PREM_LC = cOMP_PCF_PAID_PREM_LC;
	}




	public HtmlOutputLabel getCOMP_PCF_MED_FEE_LC_LABEL() {
		return COMP_PCF_MED_FEE_LC_LABEL;
	}




	public void setCOMP_PCF_MED_FEE_LC_LABEL(
			HtmlOutputLabel cOMP_PCF_MED_FEE_LC_LABEL) {
		COMP_PCF_MED_FEE_LC_LABEL = cOMP_PCF_MED_FEE_LC_LABEL;
	}




	public HtmlInputText getCOMP_PCF_MED_FEE_LC() {
		return COMP_PCF_MED_FEE_LC;
	}




	public void setCOMP_PCF_MED_FEE_LC(HtmlInputText cOMP_PCF_MED_FEE_LC) {
		COMP_PCF_MED_FEE_LC = cOMP_PCF_MED_FEE_LC;
	}




	public HtmlOutputLabel getCOMP_PCF_DOC_FEE_LC_LABEL() {
		return COMP_PCF_DOC_FEE_LC_LABEL;
	}




	public void setCOMP_PCF_DOC_FEE_LC_LABEL(
			HtmlOutputLabel cOMP_PCF_DOC_FEE_LC_LABEL) {
		COMP_PCF_DOC_FEE_LC_LABEL = cOMP_PCF_DOC_FEE_LC_LABEL;
	}




	public HtmlInputText getCOMP_PCF_DOC_FEE_LC() {
		return COMP_PCF_DOC_FEE_LC;
	}




	public void setCOMP_PCF_DOC_FEE_LC(HtmlInputText cOMP_PCF_DOC_FEE_LC) {
		COMP_PCF_DOC_FEE_LC = cOMP_PCF_DOC_FEE_LC;
	}



	public List<LovBean> LovPCF_POLICY_NO(Object value) {
		suggesionList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		try {
			System.out.println("Enter the LovPCF_POLICY_NO Method   : ");
			System.out.println("value      : "+(String) value);

			suggesionList = itemUtil.P_CALL_LOV("PILP075", "PT_IL_POL_CANC_REFN",
					"PCF_POL_NO", null, null,null, null, null,
					(String) value);

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());

		}

		System.out.println("suggesionList   :  "+suggesionList.size());

		return suggesionList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) 
	{
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}
	public void validatePCF_POL_NO(FacesContext context,
			UIComponent component, Object object)  {
		try
		{
		System.out.println("Enter the validatePCF_POL_NO");
		System.out.println("(String) object   : "+(String) object);

		PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_NO((String) object);
		
		if(PT_IL_POL_CANC_REFN_BEAN.getROWID() == null)
		{
			HELPER.validatepolicyNo(this, PT_IL_POL_CANC_REFN_BEAN);	
		}
		
		HELPER.ExecuteQuery(compositeAction);


		resetAllcomponent();

		System.out.println("PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_NO   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_NO());
		}
		catch(Exception e)
		{

			e.printStackTrace();
			getErrorMap().put("current",
					e.getMessage());
			getErrorMap().put("date",
					e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
				

			
		}
	}



	public void validatePCF_REFUND_DATE(FacesContext context,
			UIComponent component, Object object)  {
		
		try{
		 
if(PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_NO() == null)
{
	throw new Exception("Policy No Required");
}
		System.out.println("Enter the validatePCF_DOC_FEE_LC");
		System.out.println("(String) object   : "+(Date) object);
		PT_IL_POL_CANC_REFN_BEAN.setPCF_REFUND_DATE((Date) object);

		/*Added by Ram on 13/11/2016 for FALCONLIFE-1353995*/

		Date date1 = PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_ISSUE_DT();
		System.out.println("date1     : "+date1);
		Date date2= PT_IL_POL_CANC_REFN_BEAN.getPCF_REFUND_DATE();
		System.out.println("datee2    : "+date2);

 
		if(date1 != null && date2 != null)
		{
			long diff = date2.getTime() - date1.getTime();
		
			long diffDays = diff / (24 * 60 * 60 * 1000);
		
			System.out.print(diffDays + " days, "); 
			boolean flag=true;
			
			if(diffDays < 0)
			{
				flag = false;
			}
			System.out.println("flag       "+flag);
			if(!flag)
			{
				throw new Exception("Refund Date must be greater than Commencement Date");
			}
		
		/*End*/

		PKG_PILP075_CANC_REFN canc_REFN = new PKG_PILP075_CANC_REFN();
		String pol_sys_id =CommonUtils.getGlobalVariable("GLOBAL:CAN_POL_SYS_ID");

		//ArrayList<OracleParameter> pvalList  = null;
		int Tot_Mon_Elpsd =0;
		Tot_Mon_Elpsd = canc_REFN.P_ELAP_MNTH(PT_IL_POL_CANC_REFN_BEAN.getPCF_REFUND_DATE(), pol_sys_id,Tot_Mon_Elpsd );
		System.out.println("Integer.parseInt(pvalList.get(0).getValue())   : "+Tot_Mon_Elpsd);

		/*Changed by Ram on 27/11/2016 for display Policy fee in 3 decimal parts
		 * 
		 * Double PCF_MEI_REF_FC_TEMP =(CommonUtils.nvl(PT_IL_POL_CANC_REFN_BEAN.getPCF_PAID_PREM_LC(),0.0)-
				CommonUtils.nvl(PT_IL_POL_CANC_REFN_BEAN.getPCF_MED_FEE_LC(),0.0))-
				CommonUtils.nvl(PT_IL_POL_CANC_REFN_BEAN.getPCF_DOC_FEE_LC(),0.0);*/
		
		/*Double PCF_PAID_PREM_LC = PT_IL_POL_CANC_REFN_BEAN.getPCF_PAID_PREM_LC() == null ? 0.0 : Double.parseDouble(PT_IL_POL_CANC_REFN_BEAN.getPCF_PAID_PREM_LC());
		Double CF_DOC_FEE_LC = PT_IL_POL_CANC_REFN_BEAN.getPCF_DOC_FEE_LC() == null ? 0.0 : Double.parseDouble(PT_IL_POL_CANC_REFN_BEAN.getPCF_DOC_FEE_LC());
		System.out.println("PCF_PAID_PREM_LC    "+PCF_PAID_PREM_LC+"   CF_DOC_FEE_LC  "+CF_DOC_FEE_LC);
		Double PCF_MEI_REF_FC_TEMP =(PCF_PAID_PREM_LC)-
				(CommonUtils.nvl(PT_IL_POL_CANC_REFN_BEAN.getPCF_MED_FEE_LC(),0.0))-
				(CF_DOC_FEE_LC); 

		PT_IL_POL_CANC_REFN_BEAN.setPCF_MONT_ELAP(Tot_Mon_Elpsd);
		
		 PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(PCF_MEI_REF_FC_TEMP); 
		/*End*/
		
		/*Added by Ram on 27/11/2016 for Refund Value calculations*/
		int P_YEAR = 0;
		String P_REFUN_PREM = null;
		Double P_RECOVER_COMM = 0.0;
		
		ArrayList<OracleParameter> pValOrclList = null;
		pValOrclList=canc_REFN.P_CALC_REFUND(PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),Integer.parseInt(pol_sys_id), PT_IL_POL_CANC_REFN_BEAN.getPCF_REFUND_DATE(),
				P_YEAR,P_REFUN_PREM,P_RECOVER_COMM);

		System.out.println("PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_MEI_REF_FC());

		if (!pValOrclList.isEmpty()) {
			System.out.println("pValOrclList.get(0).getValueObject()--->"+pValOrclList.get(0)+" "+pValOrclList);
			if (pValOrclList.get(0).getValueObject() != null) {
				PT_IL_POL_CANC_REFN_BEAN.setPCF_MONT_ELAP((int)pValOrclList.get(0).getValueObject());
			}
			if (pValOrclList.get(1).getValueObject() != null) {
				PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC((String)pValOrclList.get(1).getValueObject());
			}
			if (pValOrclList.get(2).getValueObject() != null) {
				
				/*Modifed by Dhinesh on 27/03/2017
				 * 
				 * PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND((Double)pValOrclList.get(2).getValueObject());*/
				PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(Double.parseDouble(CommonUtils.Decimal_Convert(pValOrclList.get(2).getValueObject().toString().trim())));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_FC_RFND(Double.parseDouble(CommonUtils.Decimal_Convert(pValOrclList.get(2).getValueObject().toString().trim())));
				
				/*End*/
			}
		}
		
		/*End*/

		}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current",
					e.getMessage());
			getErrorMap().put("date",
					e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
				

			}

		
		}
	private void preInsert() throws DBException, SQLException, ParseException {

		try{
			Connection connection = null;
			ResultSet rs1 = null,rs = null;
			connection = CommonUtils.getConnection();
			String selectStatement2 = "SELECT P10ILPK_PILP075_LLB.P_COMM_CALC(?,?) FROM DUAL ";
			String selectStatement1 ="SELECT PCF_IL_SEQ_SYS_ID.NEXTVAL  FROM DUAL"; 
			rs1 = new CRUDHandler().executeSelectStatement(
					selectStatement1, connection, new Object[] {});
			if (rs1.next())
			{
				System.out.println("rs1.getInt(1)   : "+rs1.getInt(1));
				PT_IL_POL_CANC_REFN_BEAN.setPCF_SYS_ID(rs1.getInt(1));
				System.out.println("this.getPT_IL_POL_CANC_REFN_BEAN().setPCF_SYS_ID  : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID());
				PT_IL_POL_CANC_REFN_BEAN.setPCF_CR_DT(new CommonUtils().getCurrentDate());
				PT_IL_POL_CANC_REFN_BEAN.setPCF_CR_UID(CommonUtils.getGlobalVariable("GLOBAL:USER_NAME"));
				//PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(8);


			}

			if(CommonUtils.nvl(PT_IL_POL_CANC_REFN_BEAN.getPCF_STATUS(), "N")!="A")
			{

				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(selectStatement2, connection,new Object[]{PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()});

				PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN = new PT_IL_POL_CANC_REFN();
				while (rs.next())
				{
					/*Modified by Ram on 27/11/2016 for displaying values in 3 decimal points
					 * 
					 * PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(rs.getDouble(1));*/
					
					PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(rs.getString(1));

				}




				System.out.println("PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID()      :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID());
				System.out.println("PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()  :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID());

				System.out.println("PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_COMM_LC_RFND());

				System.out.println("PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_11  : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_FLEX_11());

				COMP_PCF_FLEX_11.resetValue();
				COMP_PCF_COMM_LC_RFND.resetValue();
				COMP_PCF_MEI_REF_FC.resetValue();
			}
		}catch(Exception e){
			e.printStackTrace();



		}

	}










	private void preUpdate(PILP075_COMPOSITE_ACTION composite) throws DBException, SQLException, ParseException {

		try{
			Connection connection = null;
			ResultSet rs1 = null,rs = null;
			connection = CommonUtils.getConnection();
			String selectStatement2 = "SELECT P10ILPK_PILP075_LLB.P_COMM_CALC(?,?) FROM DUAL ";


			if(!("A".equalsIgnoreCase(PT_IL_POL_CANC_REFN_BEAN.getPCF_STATUS())))
			{

				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(selectStatement2, connection,new Object[]{PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()});

				PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN = composite.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN();
				while (rs.next())
				{
					/*Modified by Ram on 27/11/2016 for displaying values in 3 decimal points
					 * 
					 * PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(rs.getDouble(1));*/

					PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(rs.getString(1));
				}

				composite.getPT_IL_POL_CANC_REFN_ACTION_BEAN().setPT_IL_POL_CANC_REFN_BEAN(PT_IL_POL_CANC_REFN_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();



		}

	}




	public String saveformsAction() {
		String message = null;
		CommonUtils.clearMaps(this);

		try {




			System.out.println("PCF_CR_UID   :  "+compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getPCF_CR_UID());
			System.out.println("ROWID    :  "+compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID());
			if ((compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID() == null) && isINSERT_ALLOWED()) {
				preInsert();
				
				/* Below code commented by dhinesh on 27-03-2017 for PCF_COMM_LC_RFND value reset 
				PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(validatePCF_COMM_LC_RFND(PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()));
		*/
				
				 
				System.out.println("PCF_CR_UID   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_CR_UID());
				System.out.println("INSERT ALL this.getPT_IL_POL_CANC_REFN_BEAN().setPCF_SYS_ID  : "+this.getPT_IL_POL_CANC_REFN_BEAN().getPCF_SYS_ID());
				new CRUDHandler().executeInsert(PT_IL_POL_CANC_REFN_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();

				COMP_PCF_FLEX_11.resetValue();
				COMP_PCF_COMM_LC_RFND.resetValue();
				COMP_PCF_MEI_REF_FC.resetValue();
				setINSERT_ALLOWED(false);
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("SAVE", message);

			} else {

				System.out.println("PCF_CR_UID   :  "+compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getPCF_CR_UID());
				
				/*Below code commented by dhinesh on 27-03-2017 for PCF_COMM_LC_RFND value reset 
				 * 
				 * preUpdate(compositeAction);



				PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(validatePCF_COMM_LC_RFND(PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_SYS_ID()));

*/

				System.out.println("RowID           :  "+PT_IL_POL_CANC_REFN_BEAN.getROWID());
				System.out.println("Policy Number   :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_POL_NO());
				System.out.println("PCF_SYS_ID      :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID());
				System.out.println("getPCF_CR_UID() :  "+PT_IL_POL_CANC_REFN_BEAN.getPCF_CR_UID());

				new CRUDHandler().executeUpdate(PT_IL_POL_CANC_REFN_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				COMP_PCF_FLEX_11.resetValue();
				COMP_PCF_COMM_LC_RFND.resetValue();
				COMP_PCF_MEI_REF_FC.resetValue();

				message = Messages.getString("messageProperties","errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("UPDATE", message);


			}
		} catch (Exception e) {

			e.printStackTrace();
			message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getErrorMap().put("SAVE", message);


		}

		return null;
	}


	public Double validatePCF_COMM_LC_RFND(int PCF_SYS_ID , int PCF_POL_SYS_ID)
	{
		System.out.println("Enter the validatePCF_COMM_LC_RFND ");
		Connection connection = null;
		ResultSet rs = null;
		String selectStatement1 = "SELECT P10ILPK_PILP075_LLB.P_COMM_CALC(?,?) FROM DUAL ";
		Double PCF_COMM_LC_RFND=0.0;
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(selectStatement1, connection,new Object[]{PCF_SYS_ID,PCF_POL_SYS_ID});

			//	PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN = new PT_IL_POL_CANC_REFN();
			while (rs.next())
			{
				PCF_COMM_LC_RFND=rs.getDouble(1);

			}
			//	System.out.println("PT_IL_POL_CANC_REFN_BEAN.getPCF_FLEX_11   : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_FLEX_11());

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				((CommonUtils) connection).closeCursor(rs);
			} catch (Exception e) {
			}

		}
		return PCF_COMM_LC_RFND;	
	}

	public void PolicyCancelBtn()
	{
		String message = null;
		CommonUtils.clearMaps(this);
		String Flag=null;
		try {
			System.out.println("Enter PolicyCancelBtn");
			getErrorMap().clear();
			getWarningMap().clear();
			ArrayList<OracleParameter> pValOrclList = null;
			String pol_sys_id =CommonUtils.getGlobalVariable("GLOBAL:CAN_POL_SYS_ID");
			System.out.println("pol_sys_id   : "+pol_sys_id);
			PKG_PILP075_CANC_REFN canc_REFN = new PKG_PILP075_CANC_REFN();
			System.out.println("this.getPT_IL_POL_CANC_REFN_BEAN().getPCF_SYS_ID()  : "+PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID());
			pValOrclList=canc_REFN.P_CANCEL_APPRV(PT_IL_POL_CANC_REFN_BEAN.getPCF_SYS_ID(),Integer.parseInt(pol_sys_id), new CommonUtils().getCurrentDate());

			System.out.println("(String)pValOrclList.get(0).getValue()   "+(String)pValOrclList.get(0).getValueObject());
			if (!pValOrclList.isEmpty()) {
				System.out.println("pValOrclList.get(0).getValueObject()--->"+pValOrclList.get(0)+" "+pValOrclList);
				if (pValOrclList.get(0).getValueObject() != null) {
					Flag =  (String)pValOrclList.get(0).getValueObject();
				}
			}

			if (CommonUtils.nvl(Flag, "X").equals("Y")) {

				COMP_PCF_POL_NO.setDisabled(true);
				COMP_PCF_REFUND_DT.setDisabled(true);

				System.out.println("Enter the true block");
				message = Messages.getString("messageProperties","errorPanel$message$process$complete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

			}else
			{
				message = "Process Not Completed";
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}




		} catch (Exception e) {
			// TODO: handle exception
			 
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		}

	}

	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}
	
	/*Added by janani on 28/11/2016 for Report Configuration*/
	@Override
	public String runAction(){
		try {
			setRedirectUrl(HELPER.WHEN_BUTTON_PRESSED_M_BUT_OK());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}

	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	 
	StringBuffer url=null;
	
	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;

	
	try {
		/*Added by Janani on 30.8.2016 for dynamic report config*/
		IP_REP_INFO repInfo = new IP_REP_INFO();
		
		/*Added by Ram on 28/11/2016 for Dynamic Report Configuration*/
		
		/*
		 * 
		 * String menuAction = (String)CommonUtils.getGlobalObject("MENU_ACTION");*/
		
		/* Newly added by dhinesh on 27.3.2017 */
		String menuAction = null;
		if(CommonUtils.getGlobalVariable("GLOBAL.SINGLE_CRNOTE") != null)
					{
					menuAction = CommonUtils.getGlobalVariable("GLOBAL.SINGLE_CRNOTE");
					}else 
					{
						 menuAction = (String)CommonUtils.getGlobalObject("MENU_ACTION");
					}
			/* End */
		System.out.println("menuAction      "+menuAction);
		String Report_Id = getReportIdwithoutInterface(CommonUtils.getConnection(), menuAction);
	/*End*/
		
		String User_Id = (String) session.getAttribute("GLOBAL.M_USER_ID");
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		String DEP_REF_NO=null;
		System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		repInfo.setREP_VALUE_1("2");
		repInfo.setREP_VALUE_2("POL_NO"+"&&&"+getPT_IL_POL_CANC_REFN_BEAN().getPCF_POL_NO());
		repInfo.setREP_VALUE_3("USER_ID"+"&&&"+User_Id);
		repInfo.setREP_VALUE_4("REP_KEY_NO"+"&&&"+REP_KEY_NO);	
		Connection conn = CommonUtils.getConnection();
		int ins = new CRUDHandler().executeInsert(repInfo, conn);
		conn.commit();
					
		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+Report_Id);	
		setRedirectUrl(url.toString());	
		
		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
			
			/* Newly added by dhinesh on 27.3.2017 */
			CommonUtils.setGlobalVariable("GLOBAL.SINGLE_CRNOTE", null);
/* End */
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	/*Added By Dhinesh on 4.2.2017 for Add CreditNote Report*/ 
	private HtmlCommandButton COMP_CREDIT_PRINT_BTN;

	public HtmlCommandButton getCOMP_CREDIT_PRINT_BTN() {
		return COMP_CREDIT_PRINT_BTN;
	}
	public void setCOMP_CREDIT_PRINT_BTN(HtmlCommandButton cOMP_CREDIT_PRINT_BTN) {
		COMP_CREDIT_PRINT_BTN = cOMP_CREDIT_PRINT_BTN;
	}	
	
	/*Added by Ram on 05/02/2017 for Creditnote Report*/
	public String callCreditPrint()
		{
			
			try {
				callReportModalPanel();
				setRedirectUrl(HELPER.WHEN_BUTTON_PRESSED_M_BUT_OK());
				String MENU_ACTION = (String) CommonUtils.getGlobalObject("MENU_ACTION");
				System.out.println("MENU_ACTION  "+MENU_ACTION);
				MENU_ACTION= MENU_ACTION +"_1";
				System.out.println("After MENU_ACTION  "+MENU_ACTION);
				CommonUtils.setGlobalVariable("GLOBAL.SINGLE_CRNOTE",MENU_ACTION);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("Print_Action", e.getMessage());
			}
			return getRedirectUrl();
		}
		/*End*/
	
	public String callPrint()
	{
		
		try {
			callReportModalPanel();
			setRedirectUrl(HELPER.WHEN_BUTTON_PRESSED_M_BUT_OK());
			String MENU_ACTION = (String) CommonUtils.getGlobalObject("MENU_ACTION");
			System.out.println("MENU_ACTION  "+MENU_ACTION);
			
			System.out.println("After MENU_ACTION  "+MENU_ACTION);
			CommonUtils.setGlobalVariable("GLOBAL.SINGLE_CRNOTE",MENU_ACTION);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	/*End*/
}





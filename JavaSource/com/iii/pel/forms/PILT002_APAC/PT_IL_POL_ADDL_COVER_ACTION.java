package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxSupport;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.fileupload.PM_IL_IMAGES;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ADDL_COVER_ACTION extends CommonAction {
	
	//Added by saritha on 08.06.2016
	private HtmlOutputLabel COMP_RATE_PERCENT_LABEL;
	
	public HtmlOutputLabel getCOMP_RATE_PERCENT_LABEL() {
		return COMP_RATE_PERCENT_LABEL;
	}

	public void setCOMP_RATE_PERCENT_LABEL(HtmlOutputLabel cOMP_RATE_PERCENT_LABEL) {
		COMP_RATE_PERCENT_LABEL = cOMP_RATE_PERCENT_LABEL;
	}
	
	//End
	
	private HtmlOutputLabel COMP_POAC_ASSR_CODE_LABEL;

	private HtmlInputText COMP_POAC_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_POAC_ASSR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POAC_ASSR_NAME;

	private HtmlOutputLabel COMP_POAC_PERIOD_LABEL;

	private HtmlInputText COMP_POAC_PERIOD;

	private HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_POAC_FC_SA_LABEL;

	private HtmlInputText COMP_POAC_FC_SA;

	private HtmlOutputLabel COMP_POAC_LC_SA_LABEL;

	private HtmlInputText COMP_POAC_LC_SA;

	private HtmlOutputLabel COMP_POAC_WOP_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAC_WOP_FLAG;

	private HtmlOutputLabel COMP_POAC_APPL_ALL_LABEL;

	private HtmlSelectOneMenu COMP_POAC_APPL_ALL;

	private HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_POAC_COVER_CODE;

	private HtmlOutputLabel COMP_POAC_NO_OF_UNIT_LABEL;

	private HtmlInputText COMP_POAC_NO_OF_UNIT;

	private HtmlOutputLabel COMP_POAC_FM_DT_LABEL;

	private HtmlCalendar COMP_POAC_FM_DT;

	private HtmlOutputLabel COMP_POAC_TO_DT_LABEL;

	private HtmlCalendar COMP_POAC_TO_DT;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC;

	private HtmlInputText COMP_POAC_ORG_FC_SA;

	private HtmlOutputLabel COMP_POAC_ORG_FC_SA_LABEL;

	private HtmlInputText COMP_POAC_ORG_LC_SA;

	private HtmlOutputLabel COMP_POAC_ORG_LC_SA_LABEL;

	private HtmlInputText COMP_POAC_ORG_FC_PREM;

	private HtmlOutputLabel COMP_POAC_ORG_FC_PREM_LABEL;

	private HtmlInputText COMP_POAC_ORG_LC_PREM;

	private HtmlOutputLabel COMP_POAC_ORG_LC_PREM_LABEL;

	private HtmlInputText COMP_POAC_ORG_RATE;

	private HtmlOutputLabel COMP_POAC_ORG_RATE_LABEL;

	private HtmlInputText COMP_POAC_ORG_RATE_PER;

	private HtmlOutputLabel COMP_POAC_ORG_RATE_PER_LABEL;

	private HtmlInputText COMP_POAC_ORG_PERIOD;

	private HtmlOutputLabel COMP_POAC_ORG_PERIOD_LABEL;

	private HtmlInputText COMP_POAC_ORG_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_POAC_ORG_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POAC_ORG_NO_OF_UNIT;

	private HtmlOutputLabel COMP_POAC_ORG_NO_OF_UNIT_LABEL;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PCG_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PCG_CODE;

	private HtmlOutputLabel COMP_POAC_LIMIT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POAC_LIMIT_TYPE;

	private HtmlOutputLabel COMP_POAC_PER_DAY_LC_AMT_LABEL;

	private HtmlInputText COMP_POAC_PER_DAY_LC_AMT;

	private HtmlOutputLabel COMP_POAC_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_POAC_LIMIT_DAYS;

	private HtmlOutputLabel COMP_POAC_LC_LIMIT_LABEL;

	private HtmlInputText COMP_POAC_LC_LIMIT;

	private HtmlOutputLabel COMP_UI_M_POAC_ASSR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POAC_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_PROD_CODE_1;

	private HtmlOutputLabel COMP_UI_M_PCG_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_PCG_CODE_1;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_CODE_1_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_CODE_1;

	private HtmlOutputLabel COMP_POAC_RATE_LABEL;

	private HtmlInputText COMP_POAC_RATE;

	private HtmlOutputLabel COMP_POAC_RATE_PER_LABEL;

	private HtmlInputText COMP_POAC_RATE_PER;

	private HtmlOutputLabel COMP_POAC_FC_PREM_LABEL;

	private HtmlInputText COMP_POAC_FC_PREM;

	private HtmlOutputLabel COMP_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_POAC_LC_PREM;

	private HtmlOutputLabel COMP_POAC_TARIFF_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAC_TARIFF_TERM_FLAG;

	private HtmlOutputLabel COMP_POAC_RATE_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_POAC_RATE_APPLIED_ON;

	private HtmlOutputLabel COMP_UI_M_POAC_FC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_FC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_LC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_CODE_2_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_CODE_2;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC_1;

	private HtmlOutputLabel COMP_POAC_MED_DAYS_LABEL;

	private HtmlInputText COMP_POAC_MED_DAYS;

	private HtmlOutputLabel COMP_POAC_LC_MED_AMT_LABEL;

	private HtmlInputText COMP_POAC_LC_MED_AMT;
	
	/*added by saranya for ssp call id  FALCONQC-1714608
	
	private HtmlOutputText COMP_UI_M_POL_lOCAL_CURR_LABEL;
	
	private HtmlOutputText COMP_UI_M_POL_FOREIGN_CURR_LABEL;
	
    private HtmlOutputText COMP_UI_M_POL_lOCAL1_CURR_LABEL;
	
	private HtmlOutputText COMP_UI_M_POL_FOREIGN1_CURR_LABEL;
	
	public HtmlOutputText getCOMP_UI_M_POL_lOCAL1_CURR_LABEL() {
		return COMP_UI_M_POL_lOCAL1_CURR_LABEL;
	}

	public void setCOMP_UI_M_POL_lOCAL1_CURR_LABEL(
			HtmlOutputText cOMP_UI_M_POL_lOCAL1_CURR_LABEL) {
		COMP_UI_M_POL_lOCAL1_CURR_LABEL = cOMP_UI_M_POL_lOCAL1_CURR_LABEL;
	}

	public HtmlOutputText getCOMP_UI_M_POL_FOREIGN1_CURR_LABEL() {
		return COMP_UI_M_POL_FOREIGN1_CURR_LABEL;
	}

	public void setCOMP_UI_M_POL_FOREIGN1_CURR_LABEL(
			HtmlOutputText cOMP_UI_M_POL_FOREIGN1_CURR_LABEL) {
		COMP_UI_M_POL_FOREIGN1_CURR_LABEL = cOMP_UI_M_POL_FOREIGN1_CURR_LABEL;
	}

	public HtmlOutputText getCOMP_UI_M_POL_FOREIGN_CURR_LABEL() {
		return COMP_UI_M_POL_FOREIGN_CURR_LABEL;
	}

	public void setCOMP_UI_M_POL_FOREIGN_CURR_LABEL(
			HtmlOutputText cOMP_UI_M_POL_FOREIGN_CURR_LABEL) {
		COMP_UI_M_POL_FOREIGN_CURR_LABEL = cOMP_UI_M_POL_FOREIGN_CURR_LABEL;
	}

	public HtmlOutputText getCOMP_UI_M_POL_lOCAL_CURR_LABEL() {
		return COMP_UI_M_POL_lOCAL_CURR_LABEL;
	}

	public void setCOMP_UI_M_POL_lOCAL_CURR_LABEL(
			HtmlOutputText cOMP_UI_M_POL_lOCAL_CURR_LABEL) {
		COMP_UI_M_POL_lOCAL_CURR_LABEL = cOMP_UI_M_POL_lOCAL_CURR_LABEL;
	}
	end*/

	//ADDED BY RAJA
	private HtmlOutputLabel COMP_POAC_EMR_RATE_LABEL;
	private HtmlInputText COMP_POAC_EMR_RATE;

	
	public HtmlOutputLabel getCOMP_POAC_EMR_RATE_LABEL() {
		return COMP_POAC_EMR_RATE_LABEL;
	}

	public void setCOMP_POAC_EMR_RATE_LABEL(HtmlOutputLabel cOMP_POAC_EMR_RATE_LABEL) {
		COMP_POAC_EMR_RATE_LABEL = cOMP_POAC_EMR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_EMR_RATE() {
		return COMP_POAC_EMR_RATE;
	}

	public void setCOMP_POAC_EMR_RATE(HtmlInputText cOMP_POAC_EMR_RATE) {
		COMP_POAC_EMR_RATE = cOMP_POAC_EMR_RATE;
	}
	//END

	private HtmlCommandButton COMP_UI_M_BTN_BENEFIT_DTLS;

	private HtmlCommandButton COMP_UI_M_BTN_MAIN;

	private HtmlCommandButton COMP_UI_m_post;

	private HtmlCommandButton COMP_UI_M_BUT_MORE_COVER;
	
	private HtmlCommandButton COMP_PREM_CALC_BUTN;

	private PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ADDL_COVER_HELPER helper;

	private List<PT_IL_POL_ADDL_COVER> dataList_PT_IL_POL_ADDL_COVER = new ArrayList<PT_IL_POL_ADDL_COVER>();

	private UIData dataTable;

	private List<SelectItem> listPOAC_WOP_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_APPL_ALL = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_LIMIT_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAC_RATE_APPLIED_ON = new ArrayList<SelectItem>();

	/* Added By Dhinesh 22.4.2016 */
	private HtmlModalPanel COMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL;

	public boolean premcalc = false;

	
	
	
	public HtmlCommandButton getCOMP_PREM_CALC_BUTN() {
		return COMP_PREM_CALC_BUTN;
	}

	public void setCOMP_PREM_CALC_BUTN(HtmlCommandButton cOMP_PREM_CALC_BUTN) {
		COMP_PREM_CALC_BUTN = cOMP_PREM_CALC_BUTN;
	}

	public boolean isPremcalc() {
		return premcalc;
	}

	public void setPremcalc(boolean premcalc) {
		this.premcalc = premcalc;
	}

	public HtmlModalPanel getCOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL() {
		return COMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL;
	}

	public void setCOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL(
			HtmlModalPanel cOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL) {
		COMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL = cOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL;
	}

	private HtmlCommandButton COMP_POAC_BACK;
	
	public HtmlCommandButton getCOMP_POAC_BACK() {
		return COMP_POAC_BACK;
	}

	public void setCOMP_POAC_BACK(HtmlCommandButton cOMP_POAC_BACK) {
		COMP_POAC_BACK = cOMP_POAC_BACK;
	}


	public void Update_Add_Cover() {
		CommonUtils.clearMaps(this);
		try {

			System.out.println("************* Enter the UPDATE_ADD_COVER Method *************");
			resetSelectedRow();
			getCOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL().setRendered(true);

			PT_IL_POL_ADDL_COVER_BEAN = (PT_IL_POL_ADDL_COVER) PT_IL_ADDL_PREMIUMdataTable.getRowData();
			/*helper.postQuery(this, 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(), 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(), 
					this, compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN());*/
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
			//resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	public String AddtnlCoversaveRecord(){
		CommonUtils.clearMaps(this); 
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String message = null;
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Enter the AddtnlCoversaveRecord ");

			System.out.println("POL_SYS_ID    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return message;
	}


	public String onclickCancel(){
		CommonUtils.clearMaps(this); 
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String message = null;
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Exit onclickCancel Method ");
			getCOMP_PRMBRKUP_ADDITNL_COVER_MODAL_PANEL().setRendered(false);

		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return message;
	}
	private HtmlCommandButton COMP_POAC_PREMIUM_BRK;
	public HtmlCommandButton getCOMP_POAC_PREMIUM_BRK() {
		return COMP_POAC_PREMIUM_BRK;
	}

	public void setCOMP_POAC_PREMIUM_BRK(HtmlCommandButton cOMP_POAC_PREMIUM_BRK) {
		COMP_POAC_PREMIUM_BRK = cOMP_POAC_PREMIUM_BRK;
	}

	/*end*/




	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ADDL_COVER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ADDL_COVER_HELPER helper) {
		this.helper = helper;
	}
	/* 12.5.2016 Added by Sankar */

	private PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_ACTION_BEAN;

	public PT_IL_POL_DISC_LOAD getPT_IL_POL_DISC_LOAD_ACTION_BEAN() {
		return PT_IL_POL_DISC_LOAD_ACTION_BEAN;
	}

	public void setPT_IL_POL_DISC_LOAD_ACTION_BEAN(
			PT_IL_POL_DISC_LOAD pT_IL_POL_DISC_LOAD_ACTION_BEAN) {
		PT_IL_POL_DISC_LOAD_ACTION_BEAN = pT_IL_POL_DISC_LOAD_ACTION_BEAN;
	}

	private HtmlInputText COMP_UI_M_POL_Rate;
	private HtmlOutputLabel COMP_UI_M_POL_Rate_DIS_LABEL;
	private HtmlOutputLabel COMP_UI_M_POL_Rate_LOD_LABEL;
	private HtmlAjaxSupport COMP_UI_M_POL_ajax;
	
	


	/*End*/	

	

	public HtmlOutputLabel getCOMP_UI_M_POL_Rate_DIS_LABEL() {
		return COMP_UI_M_POL_Rate_DIS_LABEL;
	}

	public void setCOMP_UI_M_POL_Rate_DIS_LABEL(
			HtmlOutputLabel cOMP_UI_M_POL_Rate_DIS_LABEL) {
		COMP_UI_M_POL_Rate_DIS_LABEL = cOMP_UI_M_POL_Rate_DIS_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_Rate_LOD_LABEL() {
		return COMP_UI_M_POL_Rate_LOD_LABEL;
	}

	public void setCOMP_UI_M_POL_Rate_LOD_LABEL(
			HtmlOutputLabel cOMP_UI_M_POL_Rate_LOD_LABEL) {
		COMP_UI_M_POL_Rate_LOD_LABEL = cOMP_UI_M_POL_Rate_LOD_LABEL;
	}

	public HtmlAjaxSupport getCOMP_UI_M_POL_ajax() {
		return COMP_UI_M_POL_ajax;
	}

	public void setCOMP_UI_M_POL_ajax(HtmlAjaxSupport cOMP_UI_M_POL_ajax) {
		COMP_UI_M_POL_ajax = cOMP_UI_M_POL_ajax;
	}

	public HtmlInputText getCOMP_UI_M_POL_Rate() {
		return COMP_UI_M_POL_Rate;
	}

	public void setCOMP_UI_M_POL_Rate(HtmlInputText cOMP_UI_M_POL_Rate) {
		COMP_UI_M_POL_Rate = cOMP_UI_M_POL_Rate;
	}

	public PT_IL_POL_ADDL_COVER_ACTION() {

		PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
		instantiateAllComponent();
		helper = new PT_IL_POL_ADDL_COVER_HELPER();
		prepareDropDownList();
		PT_IL_POL_DISC_LOAD_ACTION_BEAN = new PT_IL_POL_DISC_LOAD();
	}

	public void instantiateAllComponent() {
		COMP_UI_M_POAC_FC_PREM_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAC_LC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAC_PREM_PAY_YRS_LABEL = new HtmlOutputLabel();
		COMP_POAC_ORG_LC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAC_ORG_FC_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAC_ORG_PREM_PAY_YRS_LABEL = new HtmlOutputLabel();

		// Instantiating HtmlInputText
		COMP_UI_M_POL_Rate                   = new HtmlInputText();
		COMP_POAC_ASSR_CODE					 = new HtmlInputText();
		COMP_UI_M_POAC_ASSR_NAME			 = new HtmlInputText();
		COMP_POAC_PERIOD					 = new HtmlInputText();
		COMP_POAC_PREM_PAY_YRS				 = new HtmlInputText();
		COMP_POAC_FC_SA						 = new HtmlInputText();
		COMP_POAC_LC_SA						 = new HtmlInputText();
		COMP_POAC_COVER_CODE				 = new HtmlInputText();
		COMP_POAC_NO_OF_UNIT				 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_DESC			 = new HtmlInputText();
		COMP_POAC_ORG_FC_SA					 = new HtmlInputText();
		COMP_POAC_ORG_LC_SA					 = new HtmlInputText();
		COMP_POAC_ORG_FC_PREM				 = new HtmlInputText();
		COMP_POAC_ORG_LC_PREM				 = new HtmlInputText();
		COMP_POAC_ORG_RATE					 = new HtmlInputText();
		COMP_POAC_ORG_RATE_PER				 = new HtmlInputText();
		COMP_POAC_ORG_PERIOD				 = new HtmlInputText();
		COMP_POAC_ORG_PREM_PAY_YRS			 = new HtmlInputText();
		COMP_POAC_ORG_NO_OF_UNIT			 = new HtmlInputText();
		COMP_UI_M_PROD_CODE					 = new HtmlInputText();
		COMP_UI_M_PCG_CODE					 = new HtmlInputText();
		COMP_POAC_PER_DAY_LC_AMT			 = new HtmlInputText();
		COMP_POAC_LIMIT_DAYS				 = new HtmlInputText();
		COMP_POAC_LC_LIMIT					 = new HtmlInputText();
		COMP_UI_M_POAC_ASSR_CODE			 = new HtmlInputText();
		COMP_UI_M_PROD_CODE_1				 = new HtmlInputText();
		COMP_UI_M_PCG_CODE_1				 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_CODE_1			 = new HtmlInputText();
		COMP_POAC_RATE						 = new HtmlInputText();
		COMP_POAC_RATE_PER					 = new HtmlInputText();
		COMP_POAC_FC_PREM					 = new HtmlInputText();
		COMP_POAC_LC_PREM					 = new HtmlInputText();
		COMP_UI_M_POAC_FC_PREM				 = new HtmlInputText();
		COMP_UI_M_POAC_LC_PREM				 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_CODE_2			 = new HtmlInputText();
		COMP_UI_M_POAC_COVER_DESC_1			 = new HtmlInputText();
		COMP_POAC_MED_DAYS					 = new HtmlInputText();
		COMP_POAC_LC_MED_AMT				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_POAC_WOP_FLAG					 = new HtmlSelectOneMenu();
		COMP_POAC_APPL_ALL				 	 = new HtmlSelectOneMenu();
		COMP_POAC_LIMIT_TYPE				 = new HtmlSelectOneMenu();
		COMP_POAC_TARIFF_TERM_FLAG			 = new HtmlSelectOneMenu();
		COMP_POAC_RATE_APPLIED_ON			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_POAC_FM_DT					 	= new HtmlCalendar();
		COMP_POAC_TO_DT						= new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BTN_BENEFIT_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BTN_MAIN				 	 = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE_COVER			 = new HtmlCommandButton();

		COMP_POAC_PREMIUM_BRK = new HtmlCommandButton();
		COMP_UI_M_PCG_CODE_LABEL = new HtmlOutputLabel();
		COMP_POAC_BACK = new HtmlCommandButton();
		COMP_RATE_PERCENT_LABEL = new HtmlOutputLabel();
		COMP_PDL_RATE = new HtmlInputText();
		COMP_UI_M_POL_Rate_LOD_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_Rate_DIS_LABEL = new HtmlOutputLabel();
		
		COMP_POAC_EMR_RATE = new HtmlInputText();
		
		/*Added by Ram on 15/12/2016*/
		COMP_PREM_CALC_BUTN = new HtmlCommandButton();
		/*End*/
		/*Added by ganesh on 15-11-2017 to avoid null issue */
		ORIGINAL_VALUE_TOGGLE = new HtmlSimpleTogglePanel();
		/*end*/

		COMP_POAC_MED_DAYS_LABEL = new HtmlOutputLabel();
		COMP_POAC_LC_MED_AMT_LABEL = new HtmlOutputLabel();
	}

	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPOAC_WOP_FLAG = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_ADDL_COVER", "PT_IL_POL_ADDL_COVER.POAC_WOP_FLAG", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_ASSR_NAME_LABEL() {
		return COMP_UI_M_POAC_ASSR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_ASSR_NAME() {
		return COMP_UI_M_POAC_ASSR_NAME;
	}

	public void setCOMP_UI_M_POAC_ASSR_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_POAC_ASSR_NAME_LABEL) {
		this.COMP_UI_M_POAC_ASSR_NAME_LABEL = COMP_UI_M_POAC_ASSR_NAME_LABEL;
	}

	public void setCOMP_UI_M_POAC_ASSR_NAME(
			HtmlInputText COMP_UI_M_POAC_ASSR_NAME) {
		this.COMP_UI_M_POAC_ASSR_NAME = COMP_UI_M_POAC_ASSR_NAME;
	}

	public HtmlOutputLabel getCOMP_POAC_ASSR_CODE_LABEL() {
		return COMP_POAC_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_ASSR_CODE() {
		return COMP_POAC_ASSR_CODE;
	}

	public void setCOMP_POAC_ASSR_CODE_LABEL(
			HtmlOutputLabel COMP_POAC_ASSR_CODE_LABEL) {
		this.COMP_POAC_ASSR_CODE_LABEL = COMP_POAC_ASSR_CODE_LABEL;
	}

	public void setCOMP_POAC_ASSR_CODE(HtmlInputText COMP_POAC_ASSR_CODE) {
		this.COMP_POAC_ASSR_CODE = COMP_POAC_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_LABEL() {
		return COMP_UI_M_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE() {
		return COMP_UI_M_PROD_CODE;
	}

	public void setCOMP_UI_M_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL) {
		this.COMP_UI_M_PROD_CODE_LABEL = COMP_UI_M_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE(HtmlInputText COMP_UI_M_PROD_CODE) {
		this.COMP_UI_M_PROD_CODE = COMP_UI_M_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCG_CODE_LABEL() {
		return COMP_UI_M_PCG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCG_CODE() {
		return COMP_UI_M_PCG_CODE;
	}

	public void setCOMP_UI_M_PCG_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PCG_CODE_LABEL) {
		this.COMP_UI_M_PCG_CODE_LABEL = COMP_UI_M_PCG_CODE_LABEL;
	}

	public void setCOMP_UI_M_PCG_CODE(HtmlInputText COMP_UI_M_PCG_CODE) {
		this.COMP_UI_M_PCG_CODE = COMP_UI_M_PCG_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_PERIOD_LABEL() {
		return COMP_POAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PERIOD() {
		return COMP_POAC_PERIOD;
	}

	public void setCOMP_POAC_PERIOD_LABEL(HtmlOutputLabel COMP_POAC_PERIOD_LABEL) {
		this.COMP_POAC_PERIOD_LABEL = COMP_POAC_PERIOD_LABEL;
	}

	public void setCOMP_POAC_PERIOD(HtmlInputText COMP_POAC_PERIOD) {
		this.COMP_POAC_PERIOD = COMP_POAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POAC_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PREM_PAY_YRS() {
		return COMP_POAC_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL) {
		this.COMP_POAC_PREM_PAY_YRS_LABEL = COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_PREM_PAY_YRS(HtmlInputText COMP_POAC_PREM_PAY_YRS) {
		this.COMP_POAC_PREM_PAY_YRS = COMP_POAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_POAC_FC_SA_LABEL() {
		return COMP_POAC_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_FC_SA() {
		return COMP_POAC_FC_SA;
	}

	public void setCOMP_POAC_FC_SA_LABEL(HtmlOutputLabel COMP_POAC_FC_SA_LABEL) {
		this.COMP_POAC_FC_SA_LABEL = COMP_POAC_FC_SA_LABEL;
	}

	public void setCOMP_POAC_FC_SA(HtmlInputText COMP_POAC_FC_SA) {
		this.COMP_POAC_FC_SA = COMP_POAC_FC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_SA_LABEL() {
		return COMP_POAC_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_SA() {
		return COMP_POAC_LC_SA;
	}

	public void setCOMP_POAC_LC_SA_LABEL(HtmlOutputLabel COMP_POAC_LC_SA_LABEL) {
		this.COMP_POAC_LC_SA_LABEL = COMP_POAC_LC_SA_LABEL;
	}

	public void setCOMP_POAC_LC_SA(HtmlInputText COMP_POAC_LC_SA) {
		this.COMP_POAC_LC_SA = COMP_POAC_LC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_WOP_FLAG_LABEL() {
		return COMP_POAC_WOP_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAC_WOP_FLAG() {
		return COMP_POAC_WOP_FLAG;
	}

	public void setCOMP_POAC_WOP_FLAG_LABEL(
			HtmlOutputLabel COMP_POAC_WOP_FLAG_LABEL) {
		this.COMP_POAC_WOP_FLAG_LABEL = COMP_POAC_WOP_FLAG_LABEL;
	}

	public void setCOMP_POAC_WOP_FLAG(HtmlSelectOneMenu COMP_POAC_WOP_FLAG) {
		this.COMP_POAC_WOP_FLAG = COMP_POAC_WOP_FLAG;
	}

	public HtmlOutputLabel getCOMP_POAC_COVER_CODE_LABEL() {
		return COMP_POAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_COVER_CODE() {
		return COMP_POAC_COVER_CODE;
	}

	public void setCOMP_POAC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL) {
		this.COMP_POAC_COVER_CODE_LABEL = COMP_POAC_COVER_CODE_LABEL;
	}

	public void setCOMP_POAC_COVER_CODE(HtmlInputText COMP_POAC_COVER_CODE) {
		this.COMP_POAC_COVER_CODE = COMP_POAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_NO_OF_UNIT_LABEL() {
		return COMP_POAC_NO_OF_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_NO_OF_UNIT() {
		return COMP_POAC_NO_OF_UNIT;
	}

	public void setCOMP_POAC_NO_OF_UNIT_LABEL(
			HtmlOutputLabel COMP_POAC_NO_OF_UNIT_LABEL) {
		this.COMP_POAC_NO_OF_UNIT_LABEL = COMP_POAC_NO_OF_UNIT_LABEL;
	}

	public void setCOMP_POAC_NO_OF_UNIT(HtmlInputText COMP_POAC_NO_OF_UNIT) {
		this.COMP_POAC_NO_OF_UNIT = COMP_POAC_NO_OF_UNIT;
	}

	public HtmlOutputLabel getCOMP_POAC_FM_DT_LABEL() {
		return COMP_POAC_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_FM_DT() {
		return COMP_POAC_FM_DT;
	}

	public void setCOMP_POAC_FM_DT_LABEL(HtmlOutputLabel COMP_POAC_FM_DT_LABEL) {
		this.COMP_POAC_FM_DT_LABEL = COMP_POAC_FM_DT_LABEL;
	}

	public void setCOMP_POAC_FM_DT(HtmlCalendar COMP_POAC_FM_DT) {
		this.COMP_POAC_FM_DT = COMP_POAC_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_TO_DT_LABEL() {
		return COMP_POAC_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_TO_DT() {
		return COMP_POAC_TO_DT;
	}

	public void setCOMP_POAC_TO_DT_LABEL(HtmlOutputLabel COMP_POAC_TO_DT_LABEL) {
		this.COMP_POAC_TO_DT_LABEL = COMP_POAC_TO_DT_LABEL;
	}

	public void setCOMP_POAC_TO_DT(HtmlCalendar COMP_POAC_TO_DT) {
		this.COMP_POAC_TO_DT = COMP_POAC_TO_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_LIMIT_TYPE_LABEL() {
		return COMP_POAC_LIMIT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAC_LIMIT_TYPE() {
		return COMP_POAC_LIMIT_TYPE;
	}

	public void setCOMP_POAC_LIMIT_TYPE_LABEL(
			HtmlOutputLabel COMP_POAC_LIMIT_TYPE_LABEL) {
		this.COMP_POAC_LIMIT_TYPE_LABEL = COMP_POAC_LIMIT_TYPE_LABEL;
	}

	public void setCOMP_POAC_LIMIT_TYPE(HtmlSelectOneMenu COMP_POAC_LIMIT_TYPE) {
		this.COMP_POAC_LIMIT_TYPE = COMP_POAC_LIMIT_TYPE;
	}

	public HtmlOutputLabel getCOMP_POAC_PER_DAY_LC_AMT_LABEL() {
		return COMP_POAC_PER_DAY_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PER_DAY_LC_AMT() {
		return COMP_POAC_PER_DAY_LC_AMT;
	}

	public void setCOMP_POAC_PER_DAY_LC_AMT_LABEL(
			HtmlOutputLabel COMP_POAC_PER_DAY_LC_AMT_LABEL) {
		this.COMP_POAC_PER_DAY_LC_AMT_LABEL = COMP_POAC_PER_DAY_LC_AMT_LABEL;
	}

	public void setCOMP_POAC_PER_DAY_LC_AMT(
			HtmlInputText COMP_POAC_PER_DAY_LC_AMT) {
		this.COMP_POAC_PER_DAY_LC_AMT = COMP_POAC_PER_DAY_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_POAC_LIMIT_DAYS_LABEL() {
		return COMP_POAC_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LIMIT_DAYS() {
		return COMP_POAC_LIMIT_DAYS;
	}

	public void setCOMP_POAC_LIMIT_DAYS_LABEL(
			HtmlOutputLabel COMP_POAC_LIMIT_DAYS_LABEL) {
		this.COMP_POAC_LIMIT_DAYS_LABEL = COMP_POAC_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_POAC_LIMIT_DAYS(HtmlInputText COMP_POAC_LIMIT_DAYS) {
		this.COMP_POAC_LIMIT_DAYS = COMP_POAC_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_LIMIT_LABEL() {
		return COMP_POAC_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_LIMIT() {
		return COMP_POAC_LC_LIMIT;
	}

	public void setCOMP_POAC_LC_LIMIT_LABEL(
			HtmlOutputLabel COMP_POAC_LC_LIMIT_LABEL) {
		this.COMP_POAC_LC_LIMIT_LABEL = COMP_POAC_LC_LIMIT_LABEL;
	}

	public void setCOMP_POAC_LC_LIMIT(HtmlInputText COMP_POAC_LC_LIMIT) {
		this.COMP_POAC_LC_LIMIT = COMP_POAC_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC() {
		return COMP_UI_M_POAC_COVER_DESC;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL) {
		this.COMP_UI_M_POAC_COVER_DESC_LABEL = COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC(
			HtmlInputText COMP_UI_M_POAC_COVER_DESC) {
		this.COMP_UI_M_POAC_COVER_DESC = COMP_UI_M_POAC_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_ASSR_CODE_LABEL() {
		return COMP_UI_M_POAC_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_ASSR_CODE() {
		return COMP_UI_M_POAC_ASSR_CODE;
	}

	public void setCOMP_UI_M_POAC_ASSR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POAC_ASSR_CODE_LABEL) {
		this.COMP_UI_M_POAC_ASSR_CODE_LABEL = COMP_UI_M_POAC_ASSR_CODE_LABEL;
	}

	public void setCOMP_UI_M_POAC_ASSR_CODE(
			HtmlInputText COMP_UI_M_POAC_ASSR_CODE) {
		this.COMP_UI_M_POAC_ASSR_CODE = COMP_UI_M_POAC_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_1_LABEL() {
		return COMP_UI_M_PROD_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_CODE_1() {
		return COMP_UI_M_PROD_CODE_1;
	}

	public void setCOMP_UI_M_PROD_CODE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_CODE_1_LABEL) {
		this.COMP_UI_M_PROD_CODE_1_LABEL = COMP_UI_M_PROD_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_PROD_CODE_1(HtmlInputText COMP_UI_M_PROD_CODE_1) {
		this.COMP_UI_M_PROD_CODE_1 = COMP_UI_M_PROD_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCG_CODE_1_LABEL() {
		return COMP_UI_M_PCG_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCG_CODE_1() {
		return COMP_UI_M_PCG_CODE_1;
	}

	public void setCOMP_UI_M_PCG_CODE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_PCG_CODE_1_LABEL) {
		this.COMP_UI_M_PCG_CODE_1_LABEL = COMP_UI_M_PCG_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_PCG_CODE_1(HtmlInputText COMP_UI_M_PCG_CODE_1) {
		this.COMP_UI_M_PCG_CODE_1 = COMP_UI_M_PCG_CODE_1;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_MED_AMT_LABEL() {
		return COMP_POAC_LC_MED_AMT_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_MED_AMT() {
		return COMP_POAC_LC_MED_AMT;
	}

	public void setCOMP_POAC_LC_MED_AMT_LABEL(
			HtmlOutputLabel COMP_POAC_LC_MED_AMT_LABEL) {
		this.COMP_POAC_LC_MED_AMT_LABEL = COMP_POAC_LC_MED_AMT_LABEL;
	}

	public void setCOMP_POAC_LC_MED_AMT(HtmlInputText COMP_POAC_LC_MED_AMT) {
		this.COMP_POAC_LC_MED_AMT = COMP_POAC_LC_MED_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_BENEFIT_DTLS() {
		return COMP_UI_M_BTN_BENEFIT_DTLS;
	}

	public void setCOMP_UI_M_BTN_BENEFIT_DTLS(
			HtmlCommandButton COMP_UI_M_BTN_BENEFIT_DTLS) {
		this.COMP_UI_M_BTN_BENEFIT_DTLS = COMP_UI_M_BTN_BENEFIT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_MAIN() {
		return COMP_UI_M_BTN_MAIN;
	}

	public void setCOMP_UI_M_BTN_MAIN(HtmlCommandButton COMP_UI_M_BTN_MAIN) {
		this.COMP_UI_M_BTN_MAIN = COMP_UI_M_BTN_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE_COVER() {
		return COMP_UI_M_BUT_MORE_COVER;
	}

	public void setCOMP_UI_M_BUT_MORE_COVER(
			HtmlCommandButton COMP_UI_M_BUT_MORE_COVER) {
		this.COMP_UI_M_BUT_MORE_COVER = COMP_UI_M_BUT_MORE_COVER;
	}

	public PT_IL_POL_ADDL_COVER getPT_IL_POL_ADDL_COVER_BEAN() {
		return PT_IL_POL_ADDL_COVER_BEAN;
	}

	public void setPT_IL_POL_ADDL_COVER_BEAN(
			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN) {
		this.PT_IL_POL_ADDL_COVER_BEAN = PT_IL_POL_ADDL_COVER_BEAN;
	}

	public List<PT_IL_POL_ADDL_COVER> getDataList_PT_IL_POL_ADDL_COVER() {
		return dataList_PT_IL_POL_ADDL_COVER;
	}

	public void setDataListPT_IL_POL_ADDL_COVER(
			List<PT_IL_POL_ADDL_COVER> dataList_PT_IL_POL_ADDL_COVER) {
		this.dataList_PT_IL_POL_ADDL_COVER = dataList_PT_IL_POL_ADDL_COVER;
	}

	/*public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			getCOMP_UI_m_post().setRendered(true);
			setPostClick(true);
			
			if (isINSERT_ALLOWED()) {
				

			System.out.println("CommonUtils.setGlobalObject(  "+(String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_CODE"));
			System.out.println("CommonUtils.setGlobalObject(  "+(String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_NAME"));
				PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
				helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN, 
						compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);
				COMP_UI_M_POAC_ASSR_NAME.resetValue();
				COMP_POAC_ASSR_CODE.resetValue();
				resetAllComponent();
				resetSelectedRow();
				//Added by saritha on 8.6.16
				COMP_RATE_PERCENT_LABEL.setValue("");
				//End
			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}*/
	
	/*Added by Ram on 04/03/2017 for ssp call id ZBILQC-1719437*/
	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			getCOMP_UI_m_post().setRendered(true);
			setPostClick(true);
			
			if (isINSERT_ALLOWED()) {
				

			System.out.println("CommonUtils.setGlobalObject(  "+(String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_CODE"));
			System.out.println("CommonUtils.setGlobalObject(  "+(String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_NAME"));
				PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
				helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN, 
						compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);
				COMP_UI_M_POAC_ASSR_NAME.resetValue();
				COMP_POAC_ASSR_CODE.resetValue();
				resetAllComponent();
				/*Modiifed by Ram on 01/01/2017 for Clear component values
				 * 
				 * resetSelectedRow();
				 * */
				
				resetRowAtCreate();
				
				PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableSelectedRow");
				/*End*/
				
				/*End*/
				//Added by saritha on 8.6.16
				COMP_RATE_PERCENT_LABEL.setValue("");
				//End
			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	/*Added by Ram on 04/03/2017 for Clear component values*/
	private void resetRowAtCreate() {
		Iterator<PT_IL_POL_ADDL_COVER> PT_IL_POL_ADDL_COVER_ITR = dataList_PT_IL_POL_ADDL_COVER
				.iterator();
		while (PT_IL_POL_ADDL_COVER_ITR.hasNext()) {
			PT_IL_POL_ADDL_COVER_ITR.next().setRowSelected(false);;
			
		}
	}
	/*End*/
	
	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				Integer endIndex = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX();
				if ("A".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_APPRV_STATUS())
						|| "Y".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())) {

				} else {
					if (isDELETE_ALLOWED()) {
						/*
						 * 
						 * commented by Dhinesh on 25-05-2018
						 * 
						 * checkRiderDeletedOrNotInEndorsement();
						 * 
						 * 
						 * */
						/*Added by gopi on 11-12-17 as per ajoy suggestion*/
						helper.preDelete(getPT_IL_POL_ADDL_COVER_BEAN());
						/*end*/
						helper.keyDelRec(this, compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN());
						/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
						 if(endIndex > 0 && !"001".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE())){
								 if("DELRIDER".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
									 String updFrzFlagQry = "UPDATE PT_IL_POLICY SET POL_FLEX_20 = 'N' WHERE POL_SYS_ID = ?";
									 int updFrzFlag = new CRUDHandler().executeUpdateStatement(
											 updFrzFlagQry, CommonUtils.getConnection(),
											   new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
									 System.out.println("POL_FLEX_20 HAS UPDATED IN COVERS SCREEN ::::::" + updFrzFlag);
									 CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG",null);
								 }
							}
							/*End*/
						if (endIndex == 0) {
							dataList_PT_IL_POL_ADDL_COVER
							.remove(PT_IL_POL_ADDL_COVER_BEAN);
							if (dataList_PT_IL_POL_ADDL_COVER.size() > 0) {
								PT_IL_POL_ADDL_COVER_BEAN = dataList_PT_IL_POL_ADDL_COVER
										.get(0);
							} else if (dataList_PT_IL_POL_ADDL_COVER.size() == 0) {
								addRow(null);
							}
							resetAllComponent();
							PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
							getWarningMap()
							.put(
									"deleteRow",
									Messages
									.getString(
											PELConstants.pelMessagePropertiesPath,
											"errorPanel$message$delete"));
							getWarningMap()
							.put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									Messages
									.getString(
											PELConstants.pelMessagePropertiesPath,
											"errorPanel$message$delete"));
						}
						CommonUtils.getConnection().commit();

						if (dataList_PT_IL_POL_ADDL_COVER.size() > 0) {
							PT_IL_POL_ADDL_COVER_BEAN = dataList_PT_IL_POL_ADDL_COVER
									.get(0);
						} else if (dataList_PT_IL_POL_ADDL_COVER.size() == 0) {
							addRow(null);
						}
						resetAllComponent();
						PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
					} else {

						getErrorMap().put(
								"deleteRow",
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$deletenotallowed"));
						getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$deletenotallowed"));
					}

				}
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

			}
			PT_IL_POL_ADDL_COVER_BEAN.setUI_M_POAC_ASSR_NAME((String)CommonUtils.getGlobalObject("GLOBAL_ASSURED_NAME"));

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	private void checkRiderDeletedOrNotInEndorsement() throws Exception {
		try {
			if ("Y"
					.equalsIgnoreCase(PT_IL_POL_ADDL_COVER_BEAN
							.getPOAC_DEL_FLAG())) {
				String errorMessage = "Rider Already Deleted in Endorsement";
				throw new Exception(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String postRecord() {
		String message = null;
		try {
			  
				 System.out.println("Welcome to PostRecord");
				 
				/*Added by Sivarajan on 01/05/2019 for KIC Ajoy Sugg.*/
				 if(PT_IL_POL_ADDL_COVER_BEAN.getPOAC_PREM_PAY_YRS() >  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS()){
					 PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS());
				 }
				 /*End*/
			if (PT_IL_POL_ADDL_COVER_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				/*ADDED BY SANKARA NARAYANAN ON FOR sUM ASSURED VALIDATION 07/04/2017*/
				helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction.getPT_IL_POLICY_ACTION_BEAN());
			/*	END*/
				
				helper.preInsert(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getPT_IL_POL_COVER_GROUP_ACTION_BEAN()
						.getPT_IL_POL_COVER_GROUP_BEAN(), compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());

				new CRUDHandler().executeInsert(PT_IL_POL_ADDL_COVER_BEAN,
						CommonUtils.getConnection());
				/*
				 * 
				 * COMMENTED BY DHINESH ON 7-7-2017   
				 * 
				 * message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");*/
				/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
				 if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX() > 0 && 
						 !"001".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE())){
						 if("ADDRIDER".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
							 String updFrzFlagQry = "UPDATE PT_IL_POLICY SET POL_FLEX_20 = 'N' WHERE POL_SYS_ID = ?";
							 int updFrzFlag = new CRUDHandler().executeUpdateStatement(
									 updFrzFlagQry, CommonUtils.getConnection(),
									   new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
							 System.out.println("POL_FLEX_20 HAS UPDATED IN COVERS SCREEN ::::::" + updFrzFlag);
							 CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG",null);
						 }
					}
					/*End*/
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				
				dataList_PT_IL_POL_ADDL_COVER.add(PT_IL_POL_ADDL_COVER_BEAN);
			} else if (PT_IL_POL_ADDL_COVER_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				/*ADDED BY SANKARA NARAYANAN ON FOR sUM ASSURED VALIDATION 07/04/2017*/
				/*helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction.getPT_IL_POLICY_ACTION_BEAN());*/
				/*	END*/
				
				helper.POAC_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN,compositeAction);
				
				helper.preUpdate(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_ADDL_COVER_BEAN,
						CommonUtils.getConnection());
				/*Added by saritha on 14-08-2017 for ssp call id ZBILQC-1734743*/
				helper.POST_UPDATE(PT_IL_POL_ADDL_COVER_BEAN,
						compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN(),compositeAction);
				/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
				 if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX() > 0 && 
						 !"001".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE())){
						 if("ADDRIDER".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
							 String updFrzFlagQry = "UPDATE PT_IL_POLICY SET POL_FLEX_20 = 'N' WHERE POL_SYS_ID = ?";
							 int updFrzFlag = new CRUDHandler().executeUpdateStatement(
									 updFrzFlagQry, CommonUtils.getConnection(),
									   new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
							 System.out.println("POL_FLEX_20 HAS UPDATED IN COVERS SCREEN ::::::" + updFrzFlag);
							 CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG",null);
						 }
					}
					/*End*/
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			
			}
			/*End*/
			/*added by gopi on 08/12/17*/
			helper.brokerSave(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			//end
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);

			
			 CommonUtils.getConnection().commit();
			 /*Added by Janani on 06.04.2018 for KIC*/			 
			 checkPolperiod();
			 /*ENd*/
			 
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";

	}





	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			
			 
			
			resetSelectedRow();
			
			
			
			PT_IL_POL_ADDL_COVER_BEAN = (PT_IL_POL_ADDL_COVER) dataTable.getRowData();
			helper.postQuery(this, 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(), 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(), 
					this, compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN());
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
			
			/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
			enablingFields();
			
			
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPERIOD_FIELD_ENABLE() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getPERIOD_FIELD_ENABLE());
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPREMIUM_FIELD_ENABLE() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getPREMIUM_FIELD_ENABLE());
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getSA_FIELD_ENABLE() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getSA_FIELD_ENABLE());
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getEMR_FIELD_ENABLE() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getEMR_FIELD_ENABLE());
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getRowSelected());
			/*End*/
			
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_ADDL_COVER> PT_IL_POL_ADDL_COVER_ITR = dataList_PT_IL_POL_ADDL_COVER
				.iterator();
		while (PT_IL_POL_ADDL_COVER_ITR.hasNext()) {
			PT_IL_POL_ADDL_COVER_BEAN = PT_IL_POL_ADDL_COVER_ITR.next();
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(false);
			
			/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
			PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
			/*End*/
		}
	}
	/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
	private void enablingFields()
	{
System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected() in displayRecords      "+PT_IL_POL_ADDL_COVER_BEAN.getRowSelected());
		if(PT_IL_POL_ADDL_COVER_BEAN.getRowSelected() != null && PT_IL_POL_ADDL_COVER_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()+" "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
			{
				PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
				
			}
			 
			else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equals("E"))
		{
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("DECSA") || 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("INCSA"))
				{
					PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableSelectedRow");
				}
				
				/*Commentted &Modified by saritha on 27-11-2017 for Adding INCTERM & DECTERM suggested by Ajoy sir*/ 
				
				/*else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("ALTERM"))
				{*/
				
				else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
						CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
								.getPOL_END_CODE(), "ALTERM","INCTERM","DECTERM"))
					
				{
					
				/*End*/
					
					PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableSelectedRow");
				}
			
		}
			else if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("N")))
			{
				PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableSelectedRow");
				PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableSelectedRow");
			}
		}
		else
		{
			PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
		}
		
	}
	/*End*/
	
	public void resetAllComponent() {
		//COMP_POAC_ASSR_CODE.resetValue();
		//COMP_UI_M_POAC_ASSR_NAME.resetValue();
		COMP_POAC_EMR_RATE.resetValue();
		COMP_POAC_PERIOD.resetValue();
		COMP_POAC_PREM_PAY_YRS.resetValue();
		COMP_POAC_FC_SA.resetValue();
		COMP_POAC_LC_SA.resetValue();
		COMP_POAC_WOP_FLAG.resetValue();
		COMP_POAC_COVER_CODE.resetValue();
		COMP_POAC_NO_OF_UNIT.resetValue();
		COMP_POAC_FM_DT.resetValue();
		//COMP_POAC_TO_DT.resetValue();
		COMP_UI_M_POAC_COVER_DESC.resetValue();
		COMP_POAC_ASSR_CODE.resetValue();
		COMP_UI_M_PROD_CODE.resetValue();
		COMP_UI_M_PCG_CODE.resetValue();
		COMP_POAC_PERIOD.resetValue();
		COMP_POAC_PREM_PAY_YRS.resetValue();
		COMP_POAC_FC_SA.resetValue();
		COMP_POAC_LC_SA.resetValue();
		COMP_POAC_WOP_FLAG.resetValue();
		COMP_POAC_COVER_CODE.resetValue();
		COMP_POAC_NO_OF_UNIT.resetValue();
		COMP_POAC_FM_DT.resetValue();
		COMP_POAC_TO_DT.resetValue();
		COMP_POAC_LIMIT_TYPE.resetValue();
		COMP_POAC_PER_DAY_LC_AMT.resetValue();
		COMP_POAC_LIMIT_DAYS.resetValue();
		COMP_POAC_LC_LIMIT.resetValue();
		COMP_UI_M_POAC_COVER_DESC.resetValue();
		COMP_UI_M_POAC_ASSR_CODE.resetValue();
		COMP_UI_M_PROD_CODE_1.resetValue();
		COMP_UI_M_PCG_CODE_1.resetValue();
		COMP_POAC_TARIFF_TERM_FLAG.resetValue();
		COMP_UI_M_POAC_COVER_CODE_1.resetValue();
		COMP_POAC_RATE_APPLIED_ON.resetValue();
		COMP_POAC_RATE.resetValue();
		COMP_POAC_RATE_PER.resetValue();
		COMP_POAC_FC_PREM.resetValue();
		COMP_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_COVER_CODE_1.resetValue();
		COMP_POAC_TARIFF_TERM_FLAG.resetValue();
		COMP_POAC_RATE_APPLIED_ON.resetValue();
		COMP_POAC_RATE.resetValue();
		COMP_POAC_RATE_PER.resetValue();
		COMP_POAC_FC_PREM.resetValue();
		COMP_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_FC_PREM.resetValue();
		COMP_UI_M_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_FC_PREM.resetValue();
		COMP_UI_M_POAC_LC_PREM.resetValue();
		COMP_UI_M_POAC_COVER_CODE_2.resetValue();
		COMP_UI_M_POAC_COVER_CODE_2.resetValue();
		COMP_UI_M_POAC_COVER_DESC_1.resetValue();
		COMP_UI_M_POAC_COVER_DESC_1.resetValue();
		COMP_POAC_MED_DAYS.resetValue();
		COMP_POAC_MED_DAYS.resetValue();
		COMP_POAC_LC_MED_AMT.resetValue();
		COMP_POAC_LC_MED_AMT.resetValue();
		COMP_UI_M_POL_Rate.resetValue();
		COMP_PDL_RATE.resetValue();
		
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		String message = null;
		try {
			
			resetSelectedRow();
			
			int currentIndex=0;
			System.out.println("currentIndex in saveRecord         "+currentIndex);
			PT_IL_POL_ADDL_COVER_BEAN=(PT_IL_POL_ADDL_COVER)dataList_PT_IL_POL_ADDL_COVER.get(currentIndex);
			PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
			
			
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			setPremcalc(true);
			message =Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPOAC_WOP_FLAG() {
		if (listPOAC_WOP_FLAG.size() == 0) {
			listPOAC_WOP_FLAG.clear();
			try {
				listPOAC_WOP_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_WOP_FLAG;
	}

	public void setListPOAC_WOP_FLAG(List<SelectItem> listPOAC_WOP_FLAG) {
		this.listPOAC_WOP_FLAG = listPOAC_WOP_FLAG;
	}

	public List<SelectItem> getListPOAC_LIMIT_TYPE() {
		if (listPOAC_LIMIT_TYPE.size() == 0) {
			listPOAC_LIMIT_TYPE.clear();
			try {
				listPOAC_LIMIT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_LIMIT_TYPE;
	}

	public void setListPOAC_LIMIT_TYPE(List<SelectItem> listPOAC_LIMIT_TYPE) {
		this.listPOAC_LIMIT_TYPE = listPOAC_LIMIT_TYPE;
	}

	public List<SelectItem> getListPOAC_TARIFF_TERM_FLAG() {
		if (listPOAC_TARIFF_TERM_FLAG.size() == 0) {
			listPOAC_TARIFF_TERM_FLAG.clear();
			try {
				listPOAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_TARIFF_TERM_FLAG;
	}

	public void setListPOAC_TARIFF_TERM_FLAG(
			List<SelectItem> listPOAC_TARIFF_TERM_FLAG) {
		this.listPOAC_TARIFF_TERM_FLAG = listPOAC_TARIFF_TERM_FLAG;
	}

	public List<SelectItem> getListPOAC_RATE_APPLIED_ON() {
		if (listPOAC_RATE_APPLIED_ON.size() == 0) {
			listPOAC_RATE_APPLIED_ON.clear();
			try {
				listPOAC_RATE_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAC_RATE_APPLIED_ON;
	}

	public void setListPOAC_RATE_APPLIED_ON(
			List<SelectItem> listPOAC_RATE_APPLIED_ON) {
		this.listPOAC_RATE_APPLIED_ON = listPOAC_RATE_APPLIED_ON;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlCommandButton getCOMP_UI_back_PremiumDtls() {
		return COMP_UI_back_PremiumDtls;
	}

	public void setCOMP_UI_back_PremiumDtls(
			HtmlCommandButton cOMP_UI_back_PremiumDtls) {
		COMP_UI_back_PremiumDtls = cOMP_UI_back_PremiumDtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_CAL() {
		return COMP_UI_M_BUT_PREM_CAL;
	}

	public void setCOMP_UI_M_BUT_PREM_CAL(HtmlCommandButton cOMP_UI_M_BUT_PREM_CAL) {
		COMP_UI_M_BUT_PREM_CAL = cOMP_UI_M_BUT_PREM_CAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EXPAND() {
		return COMP_UI_M_BUT_EXPAND;
	}

	public void setCOMP_UI_M_BUT_EXPAND(HtmlCommandButton cOMP_UI_M_BUT_EXPAND) {
		COMP_UI_M_BUT_EXPAND = cOMP_UI_M_BUT_EXPAND;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SHRINK() {
		return COMP_UI_M_BUT_SHRINK;
	}

	public void setCOMP_UI_M_BUT_SHRINK(HtmlCommandButton cOMP_UI_M_BUT_SHRINK) {
		COMP_UI_M_BUT_SHRINK = cOMP_UI_M_BUT_SHRINK;
	}

	/*public void onLoad(PhaseEvent event) {
		try {


getDataList_BASIC_PREMIUM();
getDataList_PT_IL_DISCOUNT();
getDataList_PT_IL_LOADING();
getDataList_PT_IL_ADDL_PREMIUM();
getDataLIST_PT_IL_CUST_SINGLE_CHARGE();
getDataList_PT_IL_CUST_ANNUM_CHARGE();
//compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_back_PremiumDtls().setRendered(false);
//getCOMP_UI_M_BUT_SHRINK().setRendered(false);
System.out.println("********  compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_back_PremiumDtls().setRendered(false) *************");
			if (isBlockFlag()) {
			    if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
			    		  || CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18")==null ) {
				COMP_UI_M_PCG_CODE.setRendered(false);
				COMP_UI_M_PCG_CODE_LABEL.setRendered(false);
			    } else if ("PG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				COMP_UI_M_PCG_CODE.setRendered(true);
				COMP_UI_M_PCG_CODE_LABEL.setRendered(true);
			    }
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				helper.onPopulateDetail(compositeAction);
				if(PT_IL_POL_ADDL_COVER_BEAN.getROWID() != null){
					helper.postQuery(this, 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					helper.preRecord(this,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(),
						this,compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN(),
						compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN());
				}else{
					helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN,
						compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);
				}
				setBlockFlag(false);
			}
			checkRiderSoftDeletion();
			if("012".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_END_TYPE()) && 
					"N".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS())
					){
				helper.setcoverDate(PT_IL_POL_ADDL_COVER_BEAN,
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						this,compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN());
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}*/
	
	public void onLoad(PhaseEvent event) {
		try {
			

			if (isBlockFlag()) {
				/*Added by Ram on 10/11/2016 for Editable datagrid*/
				setPostClick(true);
				/*End*/
			System.out.println("Body onload in coverscreen");
			System.out.println(" onload  sankar "+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_ASSR_CODE());
			
			helper.loadcurrency();
			
			/* Added by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created system param */
			Object rateDecimal = CommonUtils.getPPSystemParameterValue("IL_RATE_DEC");
			if(rateDecimal!=null){
			setCustomRateDecimalSystemParam(((BigDecimal)rateDecimal).intValue());
			}			
			/*end*/
			
				 
				System.out.println("Enter into body onload in CoverPages");
				
				if(isPremcalc()){
					compositeAction.getDUMMY_ACTION_BEAN().keycommitButtonAction();
					setPremcalc(false);
				}
				
				if(compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().isDiscLoadPremCal){
					compositeAction.getDUMMY_ACTION_BEAN().keycommitButtonAction();
					setPremcalc(false);
				}
				
				
				
				
				/*setDataList_BASIC_PREMIUM(basic_premiumdatatable());    //Dhinesh 18.6.2016 commented by dhinesh 
				setDataList_PT_IL_ADDL_PREMIUM(totadditionalpremiumdatatable());
				setDataList_PT_IL_LOADING(totalLoadingdatatable());
				setDataList_PT_IL_DISCOUNT(discountdatatable());
				setDataList_PT_IL_CUST_ANNUM_CHARGE(Customer_Annum_Chargedatatable());
				setDataLIST_PT_IL_CUST_SINGLE_CHARGE(Customer_Single_Chargedatatable());*/
				System.out.println("cLASS cHANGED");
				if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
						|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18")==null ) {
					COMP_UI_M_PCG_CODE.setRendered(false);
					COMP_UI_M_PCG_CODE_LABEL.setRendered(false);
				} else if ("PG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
					COMP_UI_M_PCG_CODE.setRendered(true);
					COMP_UI_M_PCG_CODE_LABEL.setRendered(true);
				}
				
				helper.whenNewBlockInstance(compositeAction);
				
				helper.executeQuery(compositeAction);
				
				helper.onPopulateDetail(compositeAction);
				
				
				if(PT_IL_POL_ADDL_COVER_BEAN.getROWID() != null){
					helper.postQuery(this, 
							compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(), 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					helper.preRecord(this,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					helper.whenNewRecordInstance(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
							compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(),
							this,compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN(),
							compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN());
				}else{
					helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN,
							compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
							compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);
				}
				
			 
				
				
			 /*System.out.println("dataList_PT_IL_CUST_ANNUM_CHARGE    "+dataList_PT_IL_CUST_ANNUM_CHARGE);
				Iterator dataList_PT_IL_CUST_ANNUM_CHARGE_itr = dataList_PT_IL_CUST_ANNUM_CHARGE.iterator();
				while(dataList_PT_IL_CUST_ANNUM_CHARGE_itr.hasNext())
				{
				 
					PT_IL_POL_CHARGE PT_IL_POL_CHARGE_bean = (PT_IL_POL_CHARGE)dataList_PT_IL_CUST_ANNUM_CHARGE_itr.next();
					System.out.println("POC_LC_VALUE_STR         "+PT_IL_POL_CHARGE_bean.getPOC_LC_VALUE_STR());
					
				}
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_FC_PCHARGES_BORNE_CUST(855.00);*/
				//currency_value();
				
			
			//Added by saritha on 8.6.16
			rateperlabel();
			//End
			//setDataList_BASIC_PREMIUM(basic_premiumdatatable());
			checkRiderSoftDeletion();
			/*Commented by ganesh on 27-06-2017 as suggested by ajoy */
			/*if("012".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_END_TYPE()) && 
					"N".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
							getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS())
					){
				helper.setcoverDate(PT_IL_POL_ADDL_COVER_BEAN,
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						this,compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN());
			}*/
			/*end*/
			System.out.println("SHOW     "+show);
			COMP_POAC_PREMIUM_BRK.setRendered(show);
			COMP_POAC_BACK.setRendered(!show);
			/*if(show)
			{
				COMP_POAC_PREMIUM_BRK.setRendered(true);
				//COMP_UI_M_POL_Rate.setRendered(true);
				COMP_UI_M_POL_ajax.setRendered(true);
				COMP_POAC_BACK.setRendered(false);
				show=false;
			}
			else
			{
				COMP_POAC_PREMIUM_BRK.setRendered(false);
				COMP_UI_M_POL_Rate.setRendered(false);
				COMP_UI_M_POL_ajax.setRendered(false);
				COMP_POAC_BACK.setRendered(true);
			}*/
			/*Modified by saranya on 18-03-2017*/
			/*if(("A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS()))||
					("Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())))
			{
				COMP_PREM_CALC_BUTN.setDisabled(true);
				
			}*/
			/*End*/
		
			setBlockFlag(false);
			
			/*Added by Ram on 16/11/2016 for Premium Parameters*/
			setpaymentTerm();
			/*End*/
			
			/*Added by saritha on 10-10-2017 for ssp call id ZBLIFE-1439993*/ 
			ResultSet resultSet = null;
			Connection connection = null;
			String M_COVER_CLASS = null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			
			String CURSOR_C1 ="SELECT COVER_CLASS FROM PM_IL_COVER WHERE COVER_CODE= ?";
			resultSet = handler.executeSelectStatement(CURSOR_C1,connection, new Object[]{PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE()});
			if (resultSet.next()) {
				 M_COVER_CLASS = resultSet.getString(1);
				 
			}
			if ("M".equals(M_COVER_CLASS)) {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_MED_DAYS().setRendered(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_LC_MED_AMT().setRendered(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_MED_DAYS_LABEL().setRendered(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_LC_MED_AMT_LABEL().setRendered(true);


			}else {

				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_MED_DAYS().setRendered(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_LC_MED_AMT().setRendered(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_MED_DAYS_LABEL().setRendered(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_LC_MED_AMT_LABEL().setRendered(false);

			}
			
			/*End*/

			}
			
			/*Modified by saranya on 18-03-2017*/
			if(("A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS()))||
					("Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())))
			{
				COMP_PREM_CALC_BUTN.setDisabled(true);
				disableAllComponent(true);
			}
			/*End*/
			
			
			/*Added by ganesh on 03-07-2017, as suggessted by ajoy*/
			/*Commentted by saritha on 18-05-2018 for KIC IncTerm &DecTerm Endorsement passing 
			 * Rider Screen Period field disable*/
			
			/*if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()>0){
				COMP_POAC_PERIOD.setDisabled(true);
				COMP_POAC_PREM_PAY_YRS.setDisabled(true);
			}*/
			
			/*end*/
			
			/*Added by saritha on 12-07-2017 for Endowment &Education Product Issues*/ 
			enableDSAAnnutity();
			/*End*/
			
			/*Added by Ameen on 15-03-2018 to hide DTA details btn. as per Siva sugg.*/
			ResultSet dtaRS = new CRUDHandler().executeSelectStatement("SELECT PROD_RI_SA_CALC_TYP FROM PM_IL_PRODUCT WHERE PROD_CODE = ?", 
									CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			String dtsDisable="";
			if(dtaRS.next()){
				dtsDisable = dtaRS.getString("PROD_RI_SA_CALC_TYP");
			}
			if("S".equalsIgnoreCase(dtsDisable)){
				compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN().getCOMP_UI_M_BUT_RD_SA1().setDisabled(true);
			}
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	//Added by saritha 08/06/2016
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	private void rateperlabel()
	{
		System.out.println("inside the rateperlabel function");
		Double rateper=getPT_IL_POL_ADDL_COVER_BEAN().getPOAC_RATE_PER();
		System.out.println("value of rateper value ---------->"+rateper);
		if(rateper==100.00)
			/*rateper.equals("100.00")*/
		{
			System.out.println("inside 1st if");
			COMP_RATE_PERCENT_LABEL.setRendered(true);

			COMP_RATE_PERCENT_LABEL.setValue("Percentage");
		}
		else if(rateper==1000.00)
		{
			System.out.println("inside 2st if");
			COMP_RATE_PERCENT_LABEL.setRendered(true);

			COMP_RATE_PERCENT_LABEL.setValue("Per mile");
		}
		else
		{
			System.out.println("inside else");
			COMP_RATE_PERCENT_LABEL.setValue("");

		}	

	}
		//End
	private void checkRiderSoftDeletion() {
		List<PT_IL_POL_ADDL_COVER> dataList = compositeAction
				.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getDataList_PT_IL_POL_ADDL_COVER();
		for (int i = 0; i < dataList.size(); i++) {
			if ("Y".equalsIgnoreCase(dataList.get(i).getPOAC_DEL_FLAG())) {
				dataList.get(i).setDeleted("deletedyes");
			} else {
				dataList.get(i).setDeleted("deletedno");
			}
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_CODE_1_LABEL() {
		return COMP_UI_M_POAC_COVER_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_1_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_code_1_label) {
		COMP_UI_M_POAC_COVER_CODE_1_LABEL = comp_ui_m_poac_cover_code_1_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_CODE_1() {
		return COMP_UI_M_POAC_COVER_CODE_1;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_1(
			HtmlInputText comp_ui_m_poac_cover_code_1) {
		COMP_UI_M_POAC_COVER_CODE_1 = comp_ui_m_poac_cover_code_1;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_LABEL() {
		return COMP_POAC_RATE_LABEL;
	}

	public void setCOMP_POAC_RATE_LABEL(HtmlOutputLabel comp_poac_rate_label) {
		COMP_POAC_RATE_LABEL = comp_poac_rate_label;
	}

	public HtmlInputText getCOMP_POAC_RATE() {
		return COMP_POAC_RATE;
	}

	public void setCOMP_POAC_RATE(HtmlInputText comp_poac_rate) {
		COMP_POAC_RATE = comp_poac_rate;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_PER_LABEL() {
		return COMP_POAC_RATE_PER_LABEL;
	}

	public void setCOMP_POAC_RATE_PER_LABEL(
			HtmlOutputLabel comp_poac_rate_per_label) {
		COMP_POAC_RATE_PER_LABEL = comp_poac_rate_per_label;
	}

	public HtmlInputText getCOMP_POAC_RATE_PER() {
		return COMP_POAC_RATE_PER;
	}

	public void setCOMP_POAC_RATE_PER(HtmlInputText comp_poac_rate_per) {
		COMP_POAC_RATE_PER = comp_poac_rate_per;
	}

	public HtmlOutputLabel getCOMP_POAC_FC_PREM_LABEL() {
		return COMP_POAC_FC_PREM_LABEL;
	}

	public void setCOMP_POAC_FC_PREM_LABEL(
			HtmlOutputLabel comp_poac_fc_prem_label) {
		COMP_POAC_FC_PREM_LABEL = comp_poac_fc_prem_label;
	}

	public HtmlInputText getCOMP_POAC_FC_PREM() {
		return COMP_POAC_FC_PREM;
	}

	public void setCOMP_POAC_FC_PREM(HtmlInputText comp_poac_fc_prem) {
		COMP_POAC_FC_PREM = comp_poac_fc_prem;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_PREM_LABEL() {
		return COMP_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_LC_PREM_LABEL(
			HtmlOutputLabel comp_poac_lc_prem_label) {
		COMP_POAC_LC_PREM_LABEL = comp_poac_lc_prem_label;
	}

	public HtmlInputText getCOMP_POAC_LC_PREM() {
		return COMP_POAC_LC_PREM;
	}

	public void setCOMP_POAC_LC_PREM(HtmlInputText comp_poac_lc_prem) {
		COMP_POAC_LC_PREM = comp_poac_lc_prem;
	}

	public HtmlOutputLabel getCOMP_POAC_TARIFF_TERM_FLAG_LABEL() {
		return COMP_POAC_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_POAC_TARIFF_TERM_FLAG_LABEL(
			HtmlOutputLabel comp_poac_tariff_term_flag_label) {
		COMP_POAC_TARIFF_TERM_FLAG_LABEL = comp_poac_tariff_term_flag_label;
	}

	public HtmlSelectOneMenu getCOMP_POAC_TARIFF_TERM_FLAG() {
		return COMP_POAC_TARIFF_TERM_FLAG;
	}

	public void setCOMP_POAC_TARIFF_TERM_FLAG(
			HtmlSelectOneMenu comp_poac_tariff_term_flag) {
		COMP_POAC_TARIFF_TERM_FLAG = comp_poac_tariff_term_flag;
	}

	public HtmlOutputLabel getCOMP_POAC_RATE_APPLIED_ON_LABEL() {
		return COMP_POAC_RATE_APPLIED_ON_LABEL;
	}

	public void setCOMP_POAC_RATE_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_poac_rate_applied_on_label) {
		COMP_POAC_RATE_APPLIED_ON_LABEL = comp_poac_rate_applied_on_label;
	}

	public HtmlSelectOneMenu getCOMP_POAC_RATE_APPLIED_ON() {
		return COMP_POAC_RATE_APPLIED_ON;
	}

	public void setCOMP_POAC_RATE_APPLIED_ON(
			HtmlSelectOneMenu comp_poac_rate_applied_on) {
		COMP_POAC_RATE_APPLIED_ON = comp_poac_rate_applied_on;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_FC_PREM_LABEL() {
		return COMP_UI_M_POAC_FC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POAC_FC_PREM_LABEL(
			HtmlOutputLabel comp_ui_m_poac_fc_prem_label) {
		COMP_UI_M_POAC_FC_PREM_LABEL = comp_ui_m_poac_fc_prem_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_FC_PREM() {
		return COMP_UI_M_POAC_FC_PREM;
	}

	public void setCOMP_UI_M_POAC_FC_PREM(HtmlInputText comp_ui_m_poac_fc_prem) {
		COMP_UI_M_POAC_FC_PREM = comp_ui_m_poac_fc_prem;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_LC_PREM_LABEL() {
		return COMP_UI_M_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_UI_M_POAC_LC_PREM_LABEL(
			HtmlOutputLabel comp_ui_m_poac_lc_prem_label) {
		COMP_UI_M_POAC_LC_PREM_LABEL = comp_ui_m_poac_lc_prem_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_LC_PREM() {
		return COMP_UI_M_POAC_LC_PREM;
	}

	public void setCOMP_UI_M_POAC_LC_PREM(HtmlInputText comp_ui_m_poac_lc_prem) {
		COMP_UI_M_POAC_LC_PREM = comp_ui_m_poac_lc_prem;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_CODE_2_LABEL() {
		return COMP_UI_M_POAC_COVER_CODE_2_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_2_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_code_2_label) {
		COMP_UI_M_POAC_COVER_CODE_2_LABEL = comp_ui_m_poac_cover_code_2_label;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_CODE_2() {
		return COMP_UI_M_POAC_COVER_CODE_2;
	}

	public void setCOMP_UI_M_POAC_COVER_CODE_2(
			HtmlInputText comp_ui_m_poac_cover_code_2) {
		COMP_UI_M_POAC_COVER_CODE_2 = comp_ui_m_poac_cover_code_2;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC_1() {
		return COMP_UI_M_POAC_COVER_DESC_1;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_1(
			HtmlInputText comp_ui_m_poac_cover_desc_1) {
		COMP_UI_M_POAC_COVER_DESC_1 = comp_ui_m_poac_cover_desc_1;
	}

	public HtmlOutputLabel getCOMP_POAC_MED_DAYS_LABEL() {
		return COMP_POAC_MED_DAYS_LABEL;
	}

	public void setCOMP_POAC_MED_DAYS_LABEL(
			HtmlOutputLabel comp_poac_med_days_label) {
		COMP_POAC_MED_DAYS_LABEL = comp_poac_med_days_label;
	}

	public HtmlInputText getCOMP_POAC_MED_DAYS() {
		return COMP_POAC_MED_DAYS;
	}

	public void setCOMP_POAC_MED_DAYS(HtmlInputText comp_poac_med_days) {
		COMP_POAC_MED_DAYS = comp_poac_med_days;
	}

	public void setDataList_PT_IL_POL_ADDL_COVER(
			List<PT_IL_POL_ADDL_COVER> dataList_PT_IL_POL_ADDL_COVER) {
		this.dataList_PT_IL_POL_ADDL_COVER = dataList_PT_IL_POL_ADDL_COVER;
	}
	
	public void POAC_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			String currentValue = (String) value;
			String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if(!(currentValue.equalsIgnoreCase(beanValue))){
				getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_COVER_CODE((String) value);
				helper.POAC_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction,this);
				COMP_UI_M_POAC_COVER_DESC.resetValue();
				COMP_POAC_RATE.resetValue(); 	
				COMP_POAC_FC_SA.resetValue();
				COMP_POAC_LC_SA.resetValue();
				//TESTING BY HANEEF
				COMP_POAC_PERIOD.resetValue();
				COMP_POAC_TARIFF_TERM_FLAG.resetValue();
				COMP_POAC_PREM_PAY_YRS.resetValue();
				COMP_POAC_FM_DT.resetValue();
				COMP_POAC_TO_DT.resetValue();
			}
			helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_NO_OF_UNIT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_NO_OF_UNIT((Double) value);

			helper.POAC_NO_OF_UNIT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_FM_DT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_FM_DT((Date) value);

			helper.POAC_FM_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
			//COMP_POAC_TO_DT.resetValue();
			
			/*Added by Ram on 09/11/2016 for FALCONLIFE-1351612*/
			COMP_POAC_PERIOD.resetValue();
			COMP_POAC_PREM_PAY_YRS.resetValue();
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_TO_DT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_TO_DT((Date) value);

			 
			
			helper.POAC_TO_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN());
			//TESTING BY HANEEF
			//COMP_POAC_PERIOD.resetValue();
			COMP_POAC_PERIOD.resetValue();
			COMP_POAC_PREM_PAY_YRS.resetValue();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*added by saranya for ssp call id  FALCONQC-1714608
	public void currency_value() throws Exception
	{
		System.out.println("inside validate function");
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		Connection connection2 = null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		connection2 = CommonUtils.getConnection();
		String CURSOR_LC="SELECT CURR_ISO_CODE FROM PM_CURRENCY, PT_IL_POLICY WHERE CURR_CODE = ? AND POL_SYS_ID = ?";
		resultSet = handler.executeSelectStatement(CURSOR_LC,
				connection,new Object[] {compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CURR_CODE(),
				compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		if (resultSet.next()) {
			COMP_UI_M_POL_lOCAL_CURR_LABEL.setValue(resultSet.getString(1));
			COMP_UI_M_POL_lOCAL1_CURR_LABEL.setValue(resultSet.getString(1));
			System.out.println("value of lc--->"+COMP_UI_M_POL_lOCAL_CURR_LABEL.getValue());
			System.out.println("value of lc1--->"+COMP_UI_M_POL_lOCAL1_CURR_LABEL.getValue());
		}
		String CURSOR_FC="SELECT CURR_ISO_CODE FROM PM_CURRENCY, PT_IL_POLICY WHERE CURR_CODE = ? AND POL_SYS_ID = ?";
		
		System.out.println("PT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SA_CURR_CODE()"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SA_CURR_CODE());
		System.out.println("PT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SA_CURR_CODE()"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		resultSet2 = handler.executeSelectStatement(CURSOR_FC,
				connection2,new Object[] {compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SA_CURR_CODE(),
				compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		if (resultSet2.next()) {
			COMP_UI_M_POL_FOREIGN_CURR_LABEL.setValue(resultSet2.getString(1));
			COMP_UI_M_POL_FOREIGN1_CURR_LABEL.setValue(resultSet2.getString(1));
			System.out.println("value of fc--->"+COMP_UI_M_POL_FOREIGN_CURR_LABEL.getValue());
			System.out.println("value of fc1--->"+COMP_UI_M_POL_FOREIGN1_CURR_LABEL.getValue());
		}
	}
	End*/

	public void POAC_PERIOD_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			if(!PT_IL_POL_ADDL_COVER_BEAN.getPOAC_PERIOD().equals((Integer) value)){
				getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_PERIOD((Integer) value);

				/*
				 * handled outside the condition to call in save by Ameen on 22-05-2018 for KIC INTERM/DECTERM 
				 * helper.POAC_PERIOD_WHEN_VALIDATE_ITEM(this,getPT_IL_POL_ADDL_COVER_BEAN(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				COMP_POAC_TO_DT.resetValue();
				COMP_POAC_PREM_PAY_YRS.resetValue();*/
			}
			
			helper.POAC_PERIOD_WHEN_VALIDATE_ITEM(this,getPT_IL_POL_ADDL_COVER_BEAN(), 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
			COMP_POAC_TO_DT.resetValue();
			COMP_POAC_PREM_PAY_YRS.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_FC_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			/*Newly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
			//commanted by gopi as suggested by sivaraman on 23/01/2019
			/*if((Double) value > compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED()){
				throw new Exception("     Rider Sum Assured should not be greater than Basic Sum Assured");
			}*/
			//end
			/*End Newly added by pidugu raj dt: 15-10-2018 as suggested by sivaraman*/
			Double currValue=(Double) value;
			Double beanValue=PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FC_SA();
			if(!(currValue.equals(beanValue))){
				getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_FC_SA((Double) value);

				/*
				 * cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017
				 * 	helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
							PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());*/
					/*ADDED BY SANKARA NARAYANAN ON FOR sUM ASSURED VALIDATION 07/04/2017*/
					/*
					 * method have been handled outside the if condition
					 * helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
							PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction.getPT_IL_POLICY_ACTION_BEAN());*/
					/*END*/
				//COMP_POAC_LC_SA.resetValue();
			}
			helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction.getPT_IL_POLICY_ACTION_BEAN());	
			COMP_POAC_LC_SA.resetValue();
		}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}

	public void POAC_LC_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			Double currValue=(Double) value;
			Double beanValue=PT_IL_POL_ADDL_COVER_BEAN.getPOAC_LC_SA();
			if(!(currValue.equals(beanValue))){
				getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_LC_SA((Double) value);

				helper.POAC_LC_SA_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN());
			}} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}

	public void POAC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_RATE((Double) value);

			helper.POAC_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			COMP_POAC_RATE_PER.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_RATE_PER((Double) value);

			helper.POAC_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_MED_DAYS_WHEN_VALIADTE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_MED_DAYS((Double) value);

			helper.POAC_MED_DAYS_WHEN_VALIADTE_ITEM(PT_IL_POL_ADDL_COVER_BEAN);
			COMP_POAC_FC_SA.resetValue();
			COMP_POAC_LC_SA.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_WOP_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_WOP_FLAG((String) value);

			helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_LC_MED_AMT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_LC_MED_AMT((Double) value);

			helper.POAC_LC_MED_AMT_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAC_LC_MED_AMT.resetValue();
			COMP_POAC_FC_SA.resetValue();
			COMP_POAC_LC_SA.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_APPL_ALL_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_APPL_ALL((String) value);

			helper.POAC_APPL_ALL_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					this,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAC_PREM__PAY_YRS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_PREM_PAY_YRS((Integer) value);

			helper.POAC_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN,compositeAction);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_COVER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ADDL_COVER";
		String fieldName = "POAC_COVER_CODE";
		Object param1 = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
		Object param2 = "R";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1,
					param2, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_1_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_1_LABEL(
			HtmlOutputLabel comp_ui_m_poac_cover_desc_1_label) {
		COMP_UI_M_POAC_COVER_DESC_1_LABEL = comp_ui_m_poac_cover_desc_1_label;
	}

	public HtmlOutputLabel getCOMP_POAC_APPL_ALL_LABEL() {
		return COMP_POAC_APPL_ALL_LABEL;
	}

	public void setCOMP_POAC_APPL_ALL_LABEL(
			HtmlOutputLabel comp_poac_appl_all_label) {
		COMP_POAC_APPL_ALL_LABEL = comp_poac_appl_all_label;
	}

	public HtmlSelectOneMenu getCOMP_POAC_APPL_ALL() {
		return COMP_POAC_APPL_ALL;
	}

	public void setCOMP_POAC_APPL_ALL(HtmlSelectOneMenu comp_poac_appl_all) {
		COMP_POAC_APPL_ALL = comp_poac_appl_all;
	}

	public List<SelectItem> getListPOAC_APPL_ALL() {
		return listPOAC_APPL_ALL;
	}

	public void setListPOAC_APPL_ALL(List<SelectItem> listPOAC_APPL_ALL) {
		this.listPOAC_APPL_ALL = listPOAC_APPL_ALL;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_ORG_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_ORG_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel comp_poac_org_prem_pay_yrs_label) {
		COMP_POAC_ORG_PREM_PAY_YRS_LABEL = comp_poac_org_prem_pay_yrs_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_FC_SA_LABEL() {
		return COMP_POAC_ORG_FC_SA_LABEL;
	}

	public void setCOMP_POAC_ORG_FC_SA_LABEL(
			HtmlOutputLabel comp_poac_org_fc_sa_label) {
		COMP_POAC_ORG_FC_SA_LABEL = comp_poac_org_fc_sa_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_LC_SA_LABEL() {
		return COMP_POAC_ORG_LC_SA_LABEL;
	}

	public void setCOMP_POAC_ORG_LC_SA_LABEL(
			HtmlOutputLabel comp_poac_org_lc_sa_label) {
		COMP_POAC_ORG_LC_SA_LABEL = comp_poac_org_lc_sa_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_FC_PREM_LABEL() {
		return COMP_POAC_ORG_FC_PREM_LABEL;
	}

	public void setCOMP_POAC_ORG_FC_PREM_LABEL(
			HtmlOutputLabel comp_poac_org_fc_prem_label) {
		COMP_POAC_ORG_FC_PREM_LABEL = comp_poac_org_fc_prem_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_LC_PREM_LABEL() {
		return COMP_POAC_ORG_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_ORG_LC_PREM_LABEL(
			HtmlOutputLabel comp_poac_org_lc_prem_label) {
		COMP_POAC_ORG_LC_PREM_LABEL = comp_poac_org_lc_prem_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_RATE_LABEL() {
		return COMP_POAC_ORG_RATE_LABEL;
	}

	public void setCOMP_POAC_ORG_RATE_LABEL(HtmlOutputLabel comp_poac_org_rate_label) {
		COMP_POAC_ORG_RATE_LABEL = comp_poac_org_rate_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_RATE_PER_LABEL() {
		return COMP_POAC_ORG_RATE_PER_LABEL;
	}

	public void setCOMP_POAC_ORG_RATE_PER_LABEL(
			HtmlOutputLabel comp_poac_org_rate_per_label) {
		COMP_POAC_ORG_RATE_PER_LABEL = comp_poac_org_rate_per_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_PERIOD_LABEL() {
		return COMP_POAC_ORG_PERIOD_LABEL;
	}

	public void setCOMP_POAC_ORG_PERIOD_LABEL(
			HtmlOutputLabel comp_poac_org_period_label) {
		COMP_POAC_ORG_PERIOD_LABEL = comp_poac_org_period_label;
	}

	public HtmlOutputLabel getCOMP_POAC_ORG_NO_OF_UNIT_LABEL() {
		return COMP_POAC_ORG_NO_OF_UNIT_LABEL;
	}

	public void setCOMP_POAC_ORG_NO_OF_UNIT_LABEL(
			HtmlOutputLabel comp_poac_org_no_of_unit_label) {
		COMP_POAC_ORG_NO_OF_UNIT_LABEL = comp_poac_org_no_of_unit_label;
	}

	public HtmlInputText getCOMP_POAC_ORG_PERIOD() {
		return COMP_POAC_ORG_PERIOD;
	}

	public void setCOMP_POAC_ORG_PERIOD(HtmlInputText comp_poac_org_period) {
		COMP_POAC_ORG_PERIOD = comp_poac_org_period;
	}

	public HtmlInputText getCOMP_POAC_ORG_PREM_PAY_YRS() {
		return COMP_POAC_ORG_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_ORG_PREM_PAY_YRS(
			HtmlInputText comp_poac_org_prem_pay_yrs) {
		COMP_POAC_ORG_PREM_PAY_YRS = comp_poac_org_prem_pay_yrs;
	}

	public HtmlInputText getCOMP_POAC_ORG_FC_SA() {
		return COMP_POAC_ORG_FC_SA;
	}

	public void setCOMP_POAC_ORG_FC_SA(HtmlInputText comp_poac_org_fc_sa) {
		COMP_POAC_ORG_FC_SA = comp_poac_org_fc_sa;
	}

	public HtmlInputText getCOMP_POAC_ORG_LC_SA() {
		return COMP_POAC_ORG_LC_SA;
	}

	public void setCOMP_POAC_ORG_LC_SA(HtmlInputText comp_poac_org_lc_sa) {
		COMP_POAC_ORG_LC_SA = comp_poac_org_lc_sa;
	}

	public HtmlInputText getCOMP_POAC_ORG_FC_PREM() {
		return COMP_POAC_ORG_FC_PREM;
	}

	public void setCOMP_POAC_ORG_FC_PREM(HtmlInputText comp_poac_org_fc_prem) {
		COMP_POAC_ORG_FC_PREM = comp_poac_org_fc_prem;
	}

	public HtmlInputText getCOMP_POAC_ORG_LC_PREM() {
		return COMP_POAC_ORG_LC_PREM;
	}

	public void setCOMP_POAC_ORG_LC_PREM(HtmlInputText comp_poac_org_lc_prem) {
		COMP_POAC_ORG_LC_PREM = comp_poac_org_lc_prem;
	}

	public HtmlInputText getCOMP_POAC_ORG_RATE() {
		return COMP_POAC_ORG_RATE;
	}

	public void setCOMP_POAC_ORG_RATE(HtmlInputText comp_poac_org_rate) {
		COMP_POAC_ORG_RATE = comp_poac_org_rate;
	}

	public HtmlInputText getCOMP_POAC_ORG_RATE_PER() {
		return COMP_POAC_ORG_RATE_PER;
	}

	public void setCOMP_POAC_ORG_RATE_PER(HtmlInputText comp_poac_org_rate_per) {
		COMP_POAC_ORG_RATE_PER = comp_poac_org_rate_per;
	}

	public HtmlInputText getCOMP_POAC_ORG_NO_OF_UNIT() {
		return COMP_POAC_ORG_NO_OF_UNIT;
	}

	public void setCOMP_POAC_ORG_NO_OF_UNIT(HtmlInputText comp_poac_org_no_of_unit) {
		COMP_POAC_ORG_NO_OF_UNIT = comp_poac_org_no_of_unit;
	}

	/**
	 * Disables all components in PT_IL_POL_ADDL_COVER_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
	
		COMP_POAC_ASSR_CODE.setDisabled(disabled);
		COMP_UI_M_POAC_ASSR_NAME.setDisabled(disabled);
		COMP_POAC_PERIOD.setDisabled(disabled);
		COMP_POAC_PREM_PAY_YRS.setDisabled(disabled);
		COMP_POAC_FC_SA.setDisabled(disabled);
		COMP_POAC_LC_SA.setDisabled(disabled);
		COMP_POAC_COVER_CODE.setDisabled(disabled);
		COMP_POAC_NO_OF_UNIT.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_DESC.setDisabled(disabled);
		COMP_POAC_ORG_FC_SA.setDisabled(disabled);
		COMP_POAC_ORG_LC_SA.setDisabled(disabled);
		COMP_POAC_ORG_FC_PREM.setDisabled(disabled);
		COMP_POAC_ORG_LC_PREM.setDisabled(disabled);
		COMP_POAC_ORG_RATE.setDisabled(disabled);
		COMP_POAC_ORG_RATE_PER.setDisabled(disabled);
		COMP_POAC_ORG_PERIOD.setDisabled(disabled);
		COMP_POAC_ORG_PREM_PAY_YRS.setDisabled(disabled);
		COMP_POAC_ORG_NO_OF_UNIT.setDisabled(disabled);
		COMP_UI_M_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_PCG_CODE.setDisabled(disabled);
		COMP_POAC_PER_DAY_LC_AMT.setDisabled(disabled);
		COMP_POAC_LIMIT_DAYS.setDisabled(disabled);
		COMP_POAC_LC_LIMIT.setDisabled(disabled);
		COMP_UI_M_POAC_ASSR_CODE.setDisabled(disabled);
		COMP_UI_M_PROD_CODE_1.setDisabled(disabled);
		COMP_UI_M_PCG_CODE_1.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_CODE_1.setDisabled(disabled);
		COMP_POAC_RATE.setDisabled(disabled);
		COMP_POAC_RATE_PER.setDisabled(disabled);
		COMP_POAC_FC_PREM.setDisabled(disabled);
		COMP_POAC_LC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_FC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_LC_PREM.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_CODE_2.setDisabled(disabled);
		COMP_UI_M_POAC_COVER_DESC_1.setDisabled(disabled);
		COMP_POAC_MED_DAYS.setDisabled(disabled);
		COMP_POAC_LC_MED_AMT.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POAC_WOP_FLAG.setDisabled(disabled);
		COMP_POAC_APPL_ALL.setDisabled(disabled);
		COMP_POAC_LIMIT_TYPE.setDisabled(disabled);
		COMP_POAC_TARIFF_TERM_FLAG.setDisabled(disabled);
		COMP_POAC_RATE_APPLIED_ON.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POAC_FM_DT.setDisabled(disabled);
		COMP_POAC_TO_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BTN_BENEFIT_DTLS.setDisabled(disabled);
		COMP_UI_M_BTN_MAIN.setDisabled(disabled);
		COMP_UI_M_BUT_MORE_COVER.setDisabled(disabled);
		
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_POAC_EMR_RATE.setDisabled(disabled);
		/*end*/
	}
	public String beneDetail(){
		String outcome = null;
		outcome = "PILT002_APAC_PT_IL_POL_BENEFICIARY";
		return outcome;
	}
	public String back(){
		String outcome = null;
		this.setBlockFlag(true);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}



	public String navigationEnabled(){
		getErrorMap().clear();
		//	compositeAction.getWizard().setImmediate("true");
		COMP_UI_M_BTN_BENEFIT_DTLS.setImmediate(true);
		return "";
	}

	public HtmlCommandButton getCOMP_UI_m_post() {
		return COMP_UI_m_post;
	}

	public void setCOMP_UI_m_post(HtmlCommandButton comp_ui_m_post) {
		COMP_UI_m_post = comp_ui_m_post;
	}




	/*Added by dhinesh 13.4.2016*/



	private HtmlCommandButton COMP_UI_back_PremiumDtls;
	private HtmlCommandButton COMP_UI_M_BUT_PREM_CAL;
	private HtmlCommandButton COMP_UI_M_BUT_EXPAND;
	private HtmlCommandButton COMP_UI_M_BUT_SHRINK;

	private List<PT_IL_POLICY> dataList_BASIC_PREMIUM = new ArrayList<PT_IL_POLICY>();
	private List<PT_IL_POL_ADDL_COVER> dataList_PT_IL_ADDL_PREMIUM = new ArrayList<PT_IL_POL_ADDL_COVER>();
	private List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_LOADING = new ArrayList<PT_IL_POL_DISC_LOAD>();
	private List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_DISCOUNT = new ArrayList<PT_IL_POL_DISC_LOAD>();
	private List<PT_IL_POL_CHARGE> dataList_PT_IL_CUST_ANNUM_CHARGE = new ArrayList<PT_IL_POL_CHARGE>();
	private List<PT_IL_POL_CHARGE> dataLIST_PT_IL_CUST_SINGLE_CHARGE = new ArrayList<PT_IL_POL_CHARGE>();


/*	setDataList_BASIC_PREMIUM(basic_premiumdatatable());
	setDataList_PT_IL_ADDL_PREMIUM(totadditionalpremiumdatatable());
	setDataList_PT_IL_LOADING(totalLoadingdatatable());
	setDataList_PT_IL_DISCOUNT(discountdatatable());
	setDataList_PT_IL_CUST_ANNUM_CHARGE(Customer_Annum_Chargedatatable());
	setDataLIST_PT_IL_CUST_SINGLE_CHARGE(Customer_Single_Chargedatatable());
*/



	public List<PT_IL_POLICY> getDataList_BASIC_PREMIUM() throws Exception {

		dataList_BASIC_PREMIUM =basic_premiumdatatable();//Dhinesh 18.6.2016

		return dataList_BASIC_PREMIUM;
	}

	public void setDataList_BASIC_PREMIUM(
			List<PT_IL_POLICY> dataList_BASIC_PREMIUM) {
		this.dataList_BASIC_PREMIUM = dataList_BASIC_PREMIUM;
	}

	public List<PT_IL_POL_ADDL_COVER> getDataList_PT_IL_ADDL_PREMIUM() throws Exception {

		dataList_PT_IL_ADDL_PREMIUM = totadditionalpremiumdatatable();//Dhinesh 18.6.2016
		return dataList_PT_IL_ADDL_PREMIUM;
	}

	public void setDataList_PT_IL_ADDL_PREMIUM(
			List<PT_IL_POL_ADDL_COVER> dataList_PT_IL_ADDL_PREMIUM) {
		this.dataList_PT_IL_ADDL_PREMIUM = dataList_PT_IL_ADDL_PREMIUM;
	}

	public List<PT_IL_POL_DISC_LOAD> getDataList_PT_IL_LOADING() throws Exception {
		dataList_PT_IL_LOADING=totalLoadingdatatable();//Dhinesh 18.6.2016
		return dataList_PT_IL_LOADING;
	}

	public void setDataList_PT_IL_LOADING(
			List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_LOADING) {
		this.dataList_PT_IL_LOADING = dataList_PT_IL_LOADING;
	}

	public List<PT_IL_POL_DISC_LOAD> getDataList_PT_IL_DISCOUNT() throws Exception {
		
		dataList_PT_IL_DISCOUNT=discountdatatable();//Dhinesh 18.6.2016
		List<PT_IL_POL_DISC_LOAD> dataList = dataList_PT_IL_DISCOUNT;
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = dataList.get(0);
			PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
			.setPT_IL_POL_DISC_LOAD_BEAN(PT_IL_POL_DISC_LOAD_BEAN);
		}
		return dataList_PT_IL_DISCOUNT;
	}

	public void setDataList_PT_IL_DISCOUNT(
			List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_DISCOUNT) {
		this.dataList_PT_IL_DISCOUNT = dataList_PT_IL_DISCOUNT;
	}


	public List<PT_IL_POL_CHARGE> getDataList_PT_IL_CUST_ANNUM_CHARGE() throws Exception {
		
		dataList_PT_IL_CUST_ANNUM_CHARGE=Customer_Annum_Chargedatatable();//Dhinesh 18.6.2016
		return dataList_PT_IL_CUST_ANNUM_CHARGE;
	}

	public void setDataList_PT_IL_CUST_ANNUM_CHARGE(
			List<PT_IL_POL_CHARGE> dataList_PT_IL_CUST_ANNUM_CHARGE) {
		this.dataList_PT_IL_CUST_ANNUM_CHARGE = dataList_PT_IL_CUST_ANNUM_CHARGE;
	}

	public List<PT_IL_POL_CHARGE> getDataLIST_PT_IL_CUST_SINGLE_CHARGE() throws Exception {
		dataLIST_PT_IL_CUST_SINGLE_CHARGE=Customer_Single_Chargedatatable();//Dhinesh 18.6.2016
		return dataLIST_PT_IL_CUST_SINGLE_CHARGE;
	}

	public void setDataLIST_PT_IL_CUST_SINGLE_CHARGE(
			List<PT_IL_POL_CHARGE> dataLIST_PT_IL_CUST_SINGLE_CHARGE) {
		this.dataLIST_PT_IL_CUST_SINGLE_CHARGE = dataLIST_PT_IL_CUST_SINGLE_CHARGE;
	}




	private UIData PT_IL_BASIC_PREMIUMdataTable;
	private UIData PT_IL_ADDL_PREMIUMdataTable;
	private UIData PT_IL_TOTALlOADINGdataTable;
	private UIData PT_IL_TOTALDISCOUNTdataTable;
	private UIData PT_IL_CUST_ANNUM_CHARGEdataTable;
	private UIData PT_IL_CUST_SINGLE_CHARGEdataTable;







	public UIData getPT_IL_CUST_SINGLE_CHARGEdataTable() {
		return PT_IL_CUST_SINGLE_CHARGEdataTable;
	}

	public void setPT_IL_CUST_SINGLE_CHARGEdataTable(
			UIData pT_IL_CUST_SINGLE_CHARGEdataTable) {
		PT_IL_CUST_SINGLE_CHARGEdataTable = pT_IL_CUST_SINGLE_CHARGEdataTable;
	}

	public UIData getPT_IL_BASIC_PREMIUMdataTable() {
		return PT_IL_BASIC_PREMIUMdataTable;
	}

	public void setPT_IL_BASIC_PREMIUMdataTable(UIData pT_IL_BASIC_PREMIUMdataTable) {
		PT_IL_BASIC_PREMIUMdataTable = pT_IL_BASIC_PREMIUMdataTable;
	}

	public UIData getPT_IL_ADDL_PREMIUMdataTable() {
		return PT_IL_ADDL_PREMIUMdataTable;
	}

	public void setPT_IL_ADDL_PREMIUMdataTable(UIData pT_IL_ADDL_PREMIUMdataTable) {
		PT_IL_ADDL_PREMIUMdataTable = pT_IL_ADDL_PREMIUMdataTable;
	}

	public UIData getPT_IL_TOTALlOADINGdataTable() {
		return PT_IL_TOTALlOADINGdataTable;
	}

	public void setPT_IL_TOTALlOADINGdataTable(UIData pT_IL_TOTALlOADINGdataTable) {
		PT_IL_TOTALlOADINGdataTable = pT_IL_TOTALlOADINGdataTable;
	}

	public UIData getPT_IL_TOTALDISCOUNTdataTable() {
		return PT_IL_TOTALDISCOUNTdataTable;
	}

	public void setPT_IL_TOTALDISCOUNTdataTable(UIData pT_IL_TOTALDISCOUNTdataTable) {
		PT_IL_TOTALDISCOUNTdataTable = pT_IL_TOTALDISCOUNTdataTable;
	}

	public UIData getPT_IL_CUST_ANNUM_CHARGEdataTable() {
		return PT_IL_CUST_ANNUM_CHARGEdataTable;
	}

	public void setPT_IL_CUST_ANNUM_CHARGEdataTable(
			UIData pT_IL_CUST_ANNUM_CHARGEdataTable) {
		PT_IL_CUST_ANNUM_CHARGEdataTable = pT_IL_CUST_ANNUM_CHARGEdataTable;
	}





	public String BACK_DISCOUNT(){
		String outcome = null;
		this.setBlockFlag(true);
		//added code to hide the rate field when click edit option in premium breakup details screen.
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_PDL_RATE().setRendered(false);
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(false);
			
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate().setRendered(false);
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(false);
			
		outcome = "PILT002_APAC_PT_IL_POL_DISC_LOAD";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}

	public String BACK_LOADING(){
		String outcome = null;
		this.setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_DISC_LOAD";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}
	/*public String BACK_CHARGE(){
		String outcome = null;
		this.setBlockFlag(true);
		//added code to hide the rate field when click edit option in premium breakup details screen.
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_PDL_RATE().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(false);
		
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(false);
		
		
		outcome = "PILT002_APAC_PT_IL_POL_CHARGE";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}*/



	public String back_PremiumDtls(){
		String outcome = null;
		this.setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_PREM_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}					




	public List<PT_IL_POL_ADDL_COVER> totadditionalpremiumdatatable()//Additional Cover
			throws Exception {


		System.out.println("*************  Enter the totadditionalpremiumdatatable ************** ");
		List<PT_IL_POL_ADDL_COVER> POL_ADDL_COVER_List = new ArrayList<PT_IL_POL_ADDL_COVER>();

		/*Added by saritha on 23-03-2018 for In Terma plus in premium calculation screen show LC SA and FC SA*/
		/*String selectStatement = "SELECT POAC_COVER_CODE,POAC_FC_SA,POAC_RATE,POAC_LC_PREM FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? ";*/
		/*Commented and modified by pidugu raj for non-db field as per sitrarasan suggestion on 09-12-2020
		String selectStatement = "SELECT POAC_COVER_CODE,POAC_FC_SA,POAC_LC_SA,POAC_RATE,POAC_LC_PREM FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? ";*/
		String selectStatement = "SELECT POAC_COVER_CODE,POAC_FC_SA,POAC_LC_SA,POAC_RATE,POAC_LC_PREM,POAC_FC_PREM FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? ";
		/*End*/
		
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN =null;
			while (rs.next())
			{

			 PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();

				PT_IL_POL_ADDL_COVER_BEAN.setUI_M_POAC_COVER_DESC(GetAdditionalCoverCodeDesc(rs.getString("POAC_COVER_CODE")));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_FC_SA")));
				
				/*Added by saritha on 23-03-2018 for KIC In Terma plus in premium calculation screen show LC SA and FC SA*/
				
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_LC_SA")));
				
				/*End*/
				
				/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */
				if(getCustomRateDecimalSystemParam()==1){
					PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_RATE"),3));
				}else{
					PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_RATE")));
				}
				/*end*/
				/*Commented and modified by pidugu raj for non-db field as per sitrarasan suggestion on 09-12-2020
				 * PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_LC_PREM")));*/
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM_STR(CommonUtils.Decimal_Convert(rs.getString("POAC_FC_PREM")));
				/*End*/

				POL_ADDL_COVER_List.add(
						PT_IL_POL_ADDL_COVER_BEAN);

			}

			System.out.println("POL_ADDL_COVER_List    : "+POL_ADDL_COVER_List.size());
			if(POL_ADDL_COVER_List.size()==0)
			{
				 PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
				PT_IL_POL_ADDL_COVER_BEAN.setUI_M_POAC_COVER_DESC("");
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA_STR(CommonUtils.Decimal_Convert("0"));
				/*Added by saritha on 23-03-2018 for KIC In Terma plus in premium calculation screen show LC SA and FC SA*/
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA_STR(CommonUtils.Decimal_Convert("0"));
				/*End*/
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_STR(CommonUtils.Decimal_Convert("0"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM_STR(CommonUtils.Decimal_Convert("0"));

				POL_ADDL_COVER_List.add(
						PT_IL_POL_ADDL_COVER_BEAN);

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return POL_ADDL_COVER_List;

	}

	public List<PT_IL_POLICY> basic_premiumdatatable()
			throws Exception {


		System.out.println("*************  Enter the basic_premiumdatatable ************** ");
		List<PT_IL_POLICY> PT_IL_POLICY_List = new ArrayList<PT_IL_POLICY>();

		/*Commentted &Modified by saritha on 23-03-2018 for In Terma plus in premium calculation screen show LC SA and FC SA*/
		
		/*String selectStatement = "SELECT COVER_DESC, POL_FC_SUM_ASSURED, POL_BASIC_RATE, POL_FC_BASIC_PREM FROM PT_IL_POLICY, PM_IL_COVER WHERE POL_PLAN_CODE = COVER_CODE  AND POL_SYS_ID=? ";*/
		String selectStatement = "SELECT COVER_DESC, POL_FC_SUM_ASSURED,POL_LC_SUM_ASSURED, POL_BASIC_RATE, POL_FC_BASIC_PREM FROM PT_IL_POLICY, PM_IL_COVER WHERE POL_PLAN_CODE = COVER_CODE  AND POL_SYS_ID=? ";
		
		/*End*/
		
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			PT_IL_POLICY PT_IL_POLICY_BEAN = new PT_IL_POLICY();
			while (rs.next())
			{

				PT_IL_POLICY_BEAN = new PT_IL_POLICY();
				PT_IL_POLICY_BEAN.setPOL_PROD_CODE(rs.getString("COVER_DESC"));
				
				String str = rs.getString("POL_FC_SUM_ASSURED");
				System.out.println("vel == " + str);
				
				/*  PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
			   		PT_IL_POLICY_BEAN.setPOL_BASIC_RATE(Double.valueOf(rs.getString("POL_BASIC_RATE")));
				    PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(Double.valueOf(rs.getString("POL_FC_BASIC_PREM")));
				 */
				
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED_STR(CommonUtils.Decimal_Convert(rs.getString("POL_FC_SUM_ASSURED")));
				
				/*Added by saritha on 23-03-2018 for KIC In Terma plus in premium calculation screen show LC SA and FC SA*/
				PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED_STR(CommonUtils.Decimal_Convert(rs.getString("POL_LC_SUM_ASSURED")));
				/*End*/
				
				/*
				 * COMMENTED BY AMEEN ON 06.02.2017 FOR ZBILQC-1719294 
				PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POL_BASIC_RATE")));*/
				/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */

				//ADDED BY AMEEN ON 06.02.2017 FOR ZBILQC-1719294
				//PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_STR(CommonUtils.nvl(rs.getString("POL_BASIC_RATE").equals("0")?"0.000":rs.getString("POL_BASIC_RATE"), "0.000"));
				//END 
				if(getCustomRateDecimalSystemParam()==1){
					PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_STR(CommonUtils.Decimal_Convert(CommonUtils.nvl(rs.getString("POL_BASIC_RATE").equals("0")?"0.000":rs.getString("POL_BASIC_RATE"), "0.000"),3));
				}else{
					PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_STR(CommonUtils.nvl(rs.getString("POL_BASIC_RATE").equals("0")?"0.000":rs.getString("POL_BASIC_RATE"), "0.000"));
				}
				//end- ganesh
				PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM_STR(CommonUtils.Decimal_Convert(rs.getString("POL_FC_BASIC_PREM")));
				
				System.out.println("data table ::1::"+rs.getString("POL_BASIC_RATE")+"::POL_BASIC_RATE_STR::"+PT_IL_POLICY_BEAN.getPOL_BASIC_RATE_STR());
				
				PT_IL_POLICY_List.add(
						PT_IL_POLICY_BEAN);

			}

			System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POLICY_List.size());

			if(PT_IL_POLICY_List.size()==0)
			{
				PT_IL_POLICY_BEAN = new PT_IL_POLICY();
				PT_IL_POLICY_BEAN.setPOL_PROD_CODE("");
				PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED_STR(CommonUtils.Decimal_Convert("0"));
				/*Added by saritha on 23-03-2018 for KIC In Terma plus in premium calculation screen show LC SA and FC SA*/
				PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED_STR(CommonUtils.Decimal_Convert("0"));
				/*End*/
				
			//	PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
				PT_IL_POLICY_BEAN.setPOL_BASIC_RATE_STR(CommonUtils.Decimal_Convert("0"));
				PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM_STR(CommonUtils.Decimal_Convert("0"));
				
				PT_IL_POLICY_List.add(
						PT_IL_POLICY_BEAN); 
			}
			System.out.println("U_POL_FC_SUM_ASSURED       "+PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED_STR());

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return PT_IL_POLICY_List;

	}
	
	
	
public String Decimal_Convert(String Value)
{
	if(Value != null)
	{
	int decimalPlaces=0;
	System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
	 decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
	System.out.println("decimalPlaces   : "+decimalPlaces);
	
	
	BigDecimal bd = new BigDecimal(Value);
    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
    
    return bd.toString();
	}
	else
	{
		return "0.000";
	}
}


	public List<PT_IL_POL_DISC_LOAD> totalLoadingdatatable()
			throws Exception {


		System.out.println("*************  Enter the totalLoadingdatatable ************** ");
		List<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_List = new ArrayList<PT_IL_POL_DISC_LOAD>();

		//String selectStatement = " SELECT PDL_DISC_LOAD_CODE,POL_FC_SUM_ASSURED,PDL_RATE,PDL_FC_DISC_LOAD_VALUE FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? AND PDL_DISC_LOAD_TYPE = 'L'";
		String selectStatement = "SELECT PT_IL_POL_DISC_LOAD.ROWID,PT_IL_POL_DISC_LOAD.*,POL_FC_SUM_ASSURED FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID =? AND PDL_DISC_LOAD_TYPE = 'L'";
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

			while (rs.next())
			{

				PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(rs.getString("PDL_DISC_LOAD_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(rs.getDouble("PDL_RATE"));
				//PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf(rs.getString("PDL_FC_DISC_LOAD_VALUE")));
				
				//added by ameen for loading panel
				
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPL_PERC(rs.getDouble("PDL_APPL_PERC"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_UID(rs.getString("PDL_CR_UID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_TYPE(rs.getString("PDL_DISC_LOAD_TYPE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_DT(rs.getDate("PDL_CR_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_EMR_RATE(rs.getDouble("PDL_EMR_RATE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SRNO(rs.getInt("PDL_SRNO"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_UPD_DT(rs.getDate("PDL_UPD_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_COVER_CODE(rs.getString("PDL_COVER_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_PER(rs.getDouble("PDL_RATE_PER"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_ORG_APPL_PERC(rs.getDouble("PDL_ORG_APPL_PERC"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(rs.getDouble("PDL_FC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_LC_DISC_LOAD_VALUE(rs.getDouble("PDL_LC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON(rs.getString("PDL_APPLIED_ON"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON_DESC(GetDIS_LODAppliedOnDesc(rs.getString("PDL_APPLIED_ON")));
				
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DEL_FLAG(rs.getString("PDL_DEL_FLAG"));

				PT_IL_POL_DISC_LOAD_BEAN.setROWID(rs.getString("ROWID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SYS_ID(rs.getLong("PDL_SYS_ID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_POL_SYS_ID(rs.getLong("PDL_POL_SYS_ID"));

				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(rs.getString("PDL_DISC_LOAD_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(rs.getDouble("POL_FC_SUM_ASSURED"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(rs.getDouble("PDL_RATE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(rs.getDouble("PDL_FC_DISC_LOAD_VALUE"));
				
				/*ADDED BY SANKAR FOR RATE in 3 DECIMAL on 08/07/2016*/
				/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */
				if(getCustomRateDecimalSystemParam()==1){
					PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_RATE"),3));
				}else{
					PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_RATE")));
				}
				/*END*/				
				/*end*/
				
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_FC_DISC_LOAD_VALUE")));
				//end

				PT_IL_POL_DISC_LOAD_List.add(
						PT_IL_POL_DISC_LOAD_BEAN);

			}
			if(PT_IL_POL_DISC_LOAD_List.size()==0)
			{
				PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE("");
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON("");
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf("0"));
				/*ADDED BY SANKAR FOR RATE in 3 DECIMAL on 08/07/2016*/
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf("0"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert("0"));
/*END*/
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE_STR(CommonUtils.Decimal_Convert("0"));

				PT_IL_POL_DISC_LOAD_List.add(
						PT_IL_POL_DISC_LOAD_BEAN);
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_DISC_LOAD_List.size());
		return PT_IL_POL_DISC_LOAD_List;

	}

	public List<PT_IL_POL_DISC_LOAD> discountdatatable()
			throws Exception {


		System.out.println("*************  Enter the loadediscloaddatatable ************** ");
		List<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_List = new ArrayList<PT_IL_POL_DISC_LOAD>();

		//String selectStatement = " SELECT PT_IL_POL_DISC_LOAD.ROWID,PDL_POL_SYS_ID,PDL_SYS_ID,PDL_DISC_LOAD_CODE,POL_FC_SUM_ASSURED,PDL_RATE,PDL_FC_DISC_LOAD_VALUE FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? AND PDL_DISC_LOAD_TYPE = 'D'";
		String selectStatement  = "SELECT PT_IL_POL_DISC_LOAD.ROWID,PT_IL_POL_DISC_LOAD.*,POL_FC_SUM_ASSURED FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID =? AND PDL_DISC_LOAD_TYPE = 'D'";
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			String DISC_LOAD_VALUE=null;
			while (rs.next())
			{

				PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPL_PERC(rs.getDouble("PDL_APPL_PERC"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_UID(rs.getString("PDL_CR_UID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_TYPE(rs.getString("PDL_DISC_LOAD_TYPE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_DT(rs.getDate("PDL_CR_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_EMR_RATE(rs.getDouble("PDL_EMR_RATE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SRNO(rs.getInt("PDL_SRNO"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_UPD_DT(rs.getDate("PDL_UPD_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_COVER_CODE(rs.getString("PDL_COVER_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_PER(rs.getDouble("PDL_RATE_PER"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_ORG_APPL_PERC(rs.getDouble("PDL_ORG_APPL_PERC"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(rs.getDouble("PDL_FC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_LC_DISC_LOAD_VALUE(rs.getDouble("PDL_LC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON(rs.getString("PDL_APPLIED_ON"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON_DESC(GetDIS_LODAppliedOnDesc(rs.getString("PDL_APPLIED_ON")));
				
				
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DEL_FLAG(rs.getString("PDL_DEL_FLAG"));

				PT_IL_POL_DISC_LOAD_BEAN.setROWID(rs.getString("ROWID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SYS_ID(rs.getLong("PDL_SYS_ID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_POL_SYS_ID(rs.getLong("PDL_POL_SYS_ID"));

				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(rs.getString("PDL_DISC_LOAD_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(rs.getDouble("POL_FC_SUM_ASSURED"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(rs.getDouble("PDL_RATE"));
				// PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf(rs.getString("PDL_FC_DISC_LOAD_VALUE")));

				System.out.println("PDL_FC_DISC_LOAD_VALUE   : "+rs.getString("PDL_FC_DISC_LOAD_VALUE"));
				
				
PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(rs.getDouble("PDL_FC_DISC_LOAD_VALUE"));
				
				/*ADDED BY SANKAR FOR RATE in 3 DECIMAL on 08/07/2016*/
				/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */
				if(getCustomRateDecimalSystemParam()==1){
					PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_RATE"),3));
				}else{
					PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_RATE")));
				}
				/*end*/
				/*end*/
				/*if(rs.getString("PDL_FC_DISC_LOAD_VALUE")==null)
				{
					DISC_LOAD_VALUE="0";
				}
				else
				{
					DISC_LOAD_VALUE=rs.getString("PDL_FC_DISC_LOAD_VALUE");
				}*/
				//PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf(DISC_LOAD_VALUE));

				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE_STR(CommonUtils.Decimal_Convert(rs.getString("PDL_FC_DISC_LOAD_VALUE")));
				
				PT_IL_POL_DISC_LOAD_List.add(
						PT_IL_POL_DISC_LOAD_BEAN);

			}

			if(PT_IL_POL_DISC_LOAD_List.size()==0)
			{
				PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE("");
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON("");
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf("0"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE_STR(CommonUtils.Decimal_Convert("0"));
				/*ADDED BY SANKAR FOR RATE in 3 DECIMAL on 08/07/2016*/
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf("0"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert("0"));
/*END*/

				PT_IL_POL_DISC_LOAD_List.add(
						PT_IL_POL_DISC_LOAD_BEAN);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_DISC_LOAD_List.size());
		return PT_IL_POL_DISC_LOAD_List;

	}



	public List<PT_IL_POL_CHARGE> Customer_Annum_Chargedatatable()
			throws Exception {


		System.out.println("*************  Enter the loadediscloaddatatable ************** ");
		List<PT_IL_POL_CHARGE> PT_IL_POL_CHARGE_List = new ArrayList<PT_IL_POL_CHARGE>();

		/*Query changed  by sankara narayanan for ZBILQC-1721555 on 30/03/2017
		 * 
		 * String selectStatement = "SELECT DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge') POC_APPLY_PERIOD,POC_APPLIED_ON,POC_CHRG_CODE, POC_RATE,POC_LC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";*/
		
		/*Commented and modified by pidugu raj for non-db field as per sitrarasan suggestion on 09-12-2020
		 * String selectStatement = "SELECT POC_APPLY_PERIOD APP_PRD, DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge','M','Pre MOP') POC_APPLY_PERIOD,POC_APPLIED_ON,POC_CHRG_CODE, POC_RATE,POC_LC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";*/
		String selectStatement = "SELECT POC_APPLY_PERIOD APP_PRD, DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge','M','Pre MOP') POC_APPLY_PERIOD,POC_APPLIED_ON,POC_CHRG_CODE, POC_RATE,POC_LC_VALUE,POC_FC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";
		/*end*/
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			String POC_LC_VALUE=null;
			//Double totalValue = 0.0;

			while (rs.next())
			{
				System.out.println("rs.getString(POC_APPLY_PERIOD) "+rs.getString("POC_APPLY_PERIOD"));
				PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
				/*Added by sankara narayanan on 30-03-2017
				 * if(rs.getString("POC_APPLY_PERIOD")!=null && rs.getString("POC_APPLY_PERIOD").equalsIgnoreCase("Per Annum"))
				{*/
				/*Added by sankara narayanan for ZBILQC-1721555 on 30/03/2017*/
				if("M".equals(rs.getString("APP_PRD"))||"P".equals(rs.getString("APP_PRD"))){
					/*end*/
					//PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD(rs.getString("POC_APPLY_PERIOD"));
					PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON(GetChargeAppliedOnDesc(rs.getString("POC_APPLIED_ON")));
					PT_IL_POL_CHARGE_BEAN.setUI_M_POC_CHARGE_DESC(GetChargeCodeDesc(rs.getString("POC_CHRG_CODE")));
					/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */
					if(getCustomRateDecimalSystemParam()==1){
						PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_RATE"),3));
					}else{
						PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_RATE")));
					}
					/*end*/
					
					/*Commented and modified by pidugu raj for non-db field as per sitrarasan suggestion on 09-12-2020
					PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_LC_VALUE")));
					*/
					PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_FC_VALUE")));
					/*End*/
					PT_IL_POL_CHARGE_List.add(
							PT_IL_POL_CHARGE_BEAN);
					//totalValue += rs.getDouble("POC_LC_VALUE");
				}

			} if(PT_IL_POL_CHARGE_List.size()==0){
				PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
				PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON("");
				PT_IL_POL_CHARGE_BEAN.setUI_M_POC_CHARGE_DESC("");
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert("0"));
				PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE_STR(CommonUtils.Decimal_Convert("0"));

				PT_IL_POL_CHARGE_List.add(PT_IL_POL_CHARGE_BEAN);
				
				/*Added by Ameen on 02-05-2018 for KIC as per Anbarasi sugg. Need to introduce policy fee for GOLDA. 
						0.2% of initial face amount with max cap of KD 200*/
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_FC_PCHARGES_BORNE_CUST(0.0);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_LC_PCHARGES_BORNE_CUST(0.0);
				/*End*/
			}


			/*System.out.println("totalValue      "+totalValue);
			String totalValueStr = Decimal_Convert(totalValue.toString());
			System.out.println("totalValue      "+totalValue);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_FC_PCHARGES_BORNE_CUST(Double.valueOf(totalValueStr));
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_LC_PCHARGES_BORNE_CUST(Double.valueOf(totalValueStr));*/


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_CHARGE_List.size());
		return PT_IL_POL_CHARGE_List;

	}

	public List<PT_IL_POL_CHARGE> Customer_Single_Chargedatatable()
			throws Exception {


		System.out.println("*************  Enter the loadediscloaddatatable ************** ");
		List<PT_IL_POL_CHARGE> PT_IL_POL_CHARGE_List = new ArrayList<PT_IL_POL_CHARGE>();

		String selectStatement = "SELECT DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge') POC_APPLY_PERIOD,POC_APPLIED_ON,POL_FC_SUM_ASSURED,poc_chrg_code,POC_RATE,POC_LC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			String POC_LC_VALUE_TEMP=null;
			//Double totalValue = 0.0;
			while (rs.next())
			{
				System.out.println("Chargedatatable--(rs.getString(POC_APPLY_PERIOD)             "+rs.getString("POC_APPLY_PERIOD"));
				PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();

				if(rs.getString("POC_APPLY_PERIOD")!=null && rs.getString("POC_APPLY_PERIOD").equalsIgnoreCase("Single Charge"))
				{
					//PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD(rs.getString("POC_APPLY_PERIOD"));
					PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON(GetChargeAppliedOnDesc(rs.getString("POC_APPLIED_ON")));
					PT_IL_POL_CHARGE_BEAN.setUI_M_POC_CHARGE_DESC(GetChargeCodeDesc(rs.getString("poc_chrg_code")));
					
					/* Modified by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created based on system param */
					if(getCustomRateDecimalSystemParam()==1){
						PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_RATE"),3));
					}else{
						PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_RATE")));
					}
					/*end*/
					
					PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE_STR(CommonUtils.Decimal_Convert(rs.getString("POC_LC_VALUE")));

					PT_IL_POL_CHARGE_List.add(
							PT_IL_POL_CHARGE_BEAN);
					//totalValue += rs.getDouble("POC_LC_VALUE");
				}

			} if(PT_IL_POL_CHARGE_List.size()==0){
				PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
				PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON("");
				PT_IL_POL_CHARGE_BEAN.setUI_M_POC_CHARGE_DESC("");
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE_STR(CommonUtils.Decimal_Convert("0"));
				PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE_STR(CommonUtils.Decimal_Convert("0"));

				PT_IL_POL_CHARGE_List.add(PT_IL_POL_CHARGE_BEAN);


			}
/*System.out.println("totalValue    "+totalValue);
String totalValueStr = Decimal_Convert(totalValue.toString());
compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_FC_SCHARGES_BORNE_CUST(Double.valueOf(totalValueStr));
compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_LC_SCHARGES_BORNE_CUST(Double.valueOf(totalValueStr));*/

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_CHARGE_List.size());
		return PT_IL_POL_CHARGE_List;

	}


	/*public List<PT_IL_POL_ADDL_COVER> totadditionalpremiumdatatable()
		throws Exception {


System.out.println("*************  Enter the totadditionalpremiumdatatable ************** ");
 List<PT_IL_POL_ADDL_COVER> POL_ADDL_COVER_List = new ArrayList<PT_IL_POL_ADDL_COVER>();

 String selectStatement = "SELECT POAC_COVER_CODE,POAC_FC_SA,POAC_RATE,POAC_LC_PREM FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? ";
	Connection connection = null;
	ResultSet rs = null;

	try {
		connection = CommonUtils.getConnection();
		rs = new CRUDHandler().executeSelectStatement(
				selectStatement, connection, new Object[] {compositeAction
						.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		System.out.println("POL_SYS_ID   : "+compositeAction
						.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

		while (rs.next())
		{

			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(rs.getString("POAC_COVER_CODE"));
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(Double.valueOf(rs.getString("POAC_FC_SA")));
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(Double.valueOf(rs.getString("POAC_RATE")));
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(Double.valueOf(rs.getString("POAC_LC_PREM")));

			POL_ADDL_COVER_List.add(
					PT_IL_POL_ADDL_COVER_BEAN);

		}

		System.out.println("POL_ADDL_COVER_List    : "+POL_ADDL_COVER_List.size());
		if(POL_ADDL_COVER_List.size()==0)
		{
			PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE("");
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(Double.valueOf("0"));
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(Double.valueOf("0"));
			PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(Double.valueOf("0"));

			POL_ADDL_COVER_List.add(
					PT_IL_POL_ADDL_COVER_BEAN);

		}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	return POL_ADDL_COVER_List;

}

public List<PT_IL_POLICY> basic_premiumdatatable()
	 throws Exception {


 System.out.println("*************  Enter the basic_premiumdatatable ************** ");
 List<PT_IL_POLICY> PT_IL_POLICY_List = new ArrayList<PT_IL_POLICY>();

 String selectStatement = "SELECT POL_PROD_CODE,POL_FC_SUM_ASSURED, POL_BASIC_RATE, POL_FC_BASIC_PREM FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
 Connection connection = null;
 ResultSet rs = null;

 try {
	 connection = CommonUtils.getConnection();
	 rs = new CRUDHandler().executeSelectStatement(
			 selectStatement, connection, new Object[] {compositeAction
					 .getPT_IL_POLICY_ACTION_BEAN()
					 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	 System.out.println("POL_SYS_ID   : "+compositeAction
			 .getPT_IL_POLICY_ACTION_BEAN()
			 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

	 while (rs.next())
	 {

		 PT_IL_POLICY PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		 PT_IL_POLICY_BEAN.setPOL_PROD_CODE(rs.getString("POL_PROD_CODE"));
		 PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
		 PT_IL_POLICY_BEAN.setPOL_BASIC_RATE(Double.valueOf(rs.getString("POL_BASIC_RATE")));
		 PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(Double.valueOf(rs.getString("POL_FC_BASIC_PREM")));

		 PT_IL_POLICY_List.add(
				 PT_IL_POLICY_BEAN);

	 }

	 System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POLICY_List.size());

 if(PT_IL_POLICY_List.size()==0)
 {
	 PT_IL_POLICY PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	 PT_IL_POLICY_BEAN.setPOL_PROD_CODE("");
	 PT_IL_POLICY_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
	 PT_IL_POLICY_BEAN.setPOL_BASIC_RATE(Double.valueOf("0"));
	 PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(Double.valueOf("0"));

	 PT_IL_POLICY_List.add(
			 PT_IL_POLICY_BEAN); 
 }

 }catch(Exception e)
 {
		 e.printStackTrace();
 }

 return PT_IL_POLICY_List;

}


public List<PT_IL_POL_DISC_LOAD> totalLoadingdatatable()
	 throws Exception {


 System.out.println("*************  Enter the totalLoadingdatatable ************** ");
 List<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_List = new ArrayList<PT_IL_POL_DISC_LOAD>();

 String selectStatement = " SELECT PDL_DISC_LOAD_CODE,POL_FC_SUM_ASSURED,PDL_RATE,PDL_FC_DISC_LOAD_VALUE FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? AND PDL_DISC_LOAD_TYPE = 'L'";
 Connection connection = null;
 ResultSet rs = null;

 try {
	 connection = CommonUtils.getConnection();
	 rs = new CRUDHandler().executeSelectStatement(
			 selectStatement, connection, new Object[] {compositeAction
					 .getPT_IL_POLICY_ACTION_BEAN()
					 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	 System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

	 while (rs.next())
	 {

		 PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(rs.getString("PDL_DISC_LOAD_CODE"));
		 PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf(rs.getString("PDL_RATE")));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf(rs.getString("PDL_FC_DISC_LOAD_VALUE")));

		 PT_IL_POL_DISC_LOAD_List.add(
				 PT_IL_POL_DISC_LOAD_BEAN);

	 }
	 if(PT_IL_POL_DISC_LOAD_List.size()==0)
	 {
		 PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE("");
		 PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf("0"));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf("0"));

		 PT_IL_POL_DISC_LOAD_List.add(
				 PT_IL_POL_DISC_LOAD_BEAN);
	 }


 }catch(Exception e)
 {
		 e.printStackTrace();
 }
 System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_DISC_LOAD_List.size());
 return PT_IL_POL_DISC_LOAD_List;

}

public List<PT_IL_POL_DISC_LOAD> discountdatatable()
	 throws Exception {


 System.out.println("*************  Enter the loadediscloaddatatable ************** ");
 List<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_List = new ArrayList<PT_IL_POL_DISC_LOAD>();

 String selectStatement = " SELECT PDL_DISC_LOAD_CODE,POL_FC_SUM_ASSURED,PDL_RATE,PDL_FC_DISC_LOAD_VALUE FROM PT_IL_POL_DISC_LOAD,PT_IL_POLICY WHERE PDL_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? AND PDL_DISC_LOAD_TYPE = 'D'";
 Connection connection = null;
 ResultSet rs = null;

 try {
	 connection = CommonUtils.getConnection();
	 rs = new CRUDHandler().executeSelectStatement(
			 selectStatement, connection, new Object[] {compositeAction
					 .getPT_IL_POLICY_ACTION_BEAN()
					 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	 System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

	 while (rs.next())
	 {

		 PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(rs.getString("PDL_DISC_LOAD_CODE"));
		 PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf(rs.getString("PDL_RATE")));
		 PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf(rs.getString("PDL_FC_DISC_LOAD_VALUE")));

		 PT_IL_POL_DISC_LOAD_List.add(
				 PT_IL_POL_DISC_LOAD_BEAN);

	 }

 if(PT_IL_POL_DISC_LOAD_List.size()==0)
 {
	 PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
	 PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE("");
	 PT_IL_POL_DISC_LOAD_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
	 PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(Double.valueOf("0"));
	 PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(Double.valueOf("0"));

	 PT_IL_POL_DISC_LOAD_List.add(
			 PT_IL_POL_DISC_LOAD_BEAN);
 }

 }catch(Exception e)
 {
		 e.printStackTrace();
 }
 System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_DISC_LOAD_List.size());
 return PT_IL_POL_DISC_LOAD_List;

}


public List<PT_IL_POL_CHARGE> Customer_Annum_Chargedatatable()
	 throws Exception {


 System.out.println("*************  Enter the loadediscloaddatatable ************** ");
 List<PT_IL_POL_CHARGE> PT_IL_POL_CHARGE_List = new ArrayList<PT_IL_POL_CHARGE>();

 String selectStatement = "SELECT DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge') POC_APPLY_PERIOD,POL_FC_SUM_ASSURED, POC_RATE,POC_LC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";
 Connection connection = null;
 ResultSet rs = null;

 try {
	 connection = CommonUtils.getConnection();
	 rs = new CRUDHandler().executeSelectStatement(
			 selectStatement, connection, new Object[] {compositeAction
					 .getPT_IL_POLICY_ACTION_BEAN()
					 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	 System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());


	 while (rs.next())
	 {
		 PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();

		 if(rs.getString("POC_APPLY_PERIOD").equalsIgnoreCase("Per Annum"))
		 {
			 PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD(rs.getString("POC_APPLY_PERIOD"));
			 PT_IL_POL_CHARGE_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
			 PT_IL_POL_CHARGE_BEAN.setPOC_RATE(Double.valueOf(rs.getString("POC_RATE")));
			 PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE(Double.valueOf(rs.getString("POC_LC_VALUE")));

			 PT_IL_POL_CHARGE_List.add(
					 PT_IL_POL_CHARGE_BEAN);

		 }

	 } if(PT_IL_POL_CHARGE_List.size()==0){
		 PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
		 PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD("");
		 PT_IL_POL_CHARGE_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
		 PT_IL_POL_CHARGE_BEAN.setPOC_RATE(Double.valueOf("0"));
		 PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE(Double.valueOf("0"));

		 PT_IL_POL_CHARGE_List.add(PT_IL_POL_CHARGE_BEAN);
	 }




 }catch(Exception e)
 {
		 e.printStackTrace();
 }
 System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_CHARGE_List.size());
 return PT_IL_POL_CHARGE_List;

}

public List<PT_IL_POL_CHARGE> Customer_Single_Chargedatatable()
	 throws Exception {


 System.out.println("*************  Enter the loadediscloaddatatable ************** ");
 List<PT_IL_POL_CHARGE> PT_IL_POL_CHARGE_List = new ArrayList<PT_IL_POL_CHARGE>();

 String selectStatement = "SELECT DECODE(POC_APPLY_PERIOD, 'P', 'Per Annum', 'S', 'Single Charge') POC_APPLY_PERIOD,POL_FC_SUM_ASSURED, POC_RATE,POC_LC_VALUE FROM PT_IL_POL_CHARGE,PT_IL_POLICY WHERE POC_POL_SYS_ID = POL_SYS_ID AND POL_SYS_ID = ? ";
 Connection connection = null;
 ResultSet rs = null;

 try {
	 connection = CommonUtils.getConnection();
	 rs = new CRUDHandler().executeSelectStatement(
			 selectStatement, connection, new Object[] {compositeAction
					 .getPT_IL_POLICY_ACTION_BEAN()
					 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	 System.out.println("POL_SYS_ID   : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

	 while (rs.next())
	 {
		 PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();

		 if(rs.getString("POC_APPLY_PERIOD").equalsIgnoreCase("Single Charge"))
		 {
			 PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD(rs.getString("POC_APPLY_PERIOD"));
			 PT_IL_POL_CHARGE_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf(rs.getString("POL_FC_SUM_ASSURED")));
			 PT_IL_POL_CHARGE_BEAN.setPOC_RATE(Double.valueOf(rs.getString("POC_RATE")));
			 PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE(Double.valueOf(rs.getString("POC_LC_VALUE")));

			 PT_IL_POL_CHARGE_List.add(
					 PT_IL_POL_CHARGE_BEAN);

		 }

	 } if(PT_IL_POL_CHARGE_List.size()==0){
		 PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
		 PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD("");
		 PT_IL_POL_CHARGE_BEAN.setPOL_FC_SUM_ASSURED(Double.valueOf("0"));
		 PT_IL_POL_CHARGE_BEAN.setPOC_RATE(Double.valueOf("0"));
		 PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE(Double.valueOf("0"));

		 PT_IL_POL_CHARGE_List.add(PT_IL_POL_CHARGE_BEAN);


	 }


 }catch(Exception e)
 {
		 e.printStackTrace();
 }
 System.out.println("POL_ADDL_COVER_List  Size  : "+PT_IL_POL_CHARGE_List.size());
 return PT_IL_POL_CHARGE_List;

}*/

	private org.richfaces.component.html.HtmlSimpleTogglePanel BASICPREMIUM_TOGGLE;
	private org.richfaces.component.html.HtmlSimpleTogglePanel ADDITIONALPREMIUM_TOGGLE;
	private org.richfaces.component.html.HtmlSimpleTogglePanel DISCOUNT_TOGGLE;
	private org.richfaces.component.html.HtmlSimpleTogglePanel LOADING_TOGGLE;
	private org.richfaces.component.html.HtmlSimpleTogglePanel CUST_ANNUAL_CHARGE_TOGGLE;
	private org.richfaces.component.html.HtmlSimpleTogglePanel CUST_SINGLE_CHARGE_TOGGLE;




	public org.richfaces.component.html.HtmlSimpleTogglePanel getADDITIONALPREMIUM_TOGGLE() {
		return ADDITIONALPREMIUM_TOGGLE;
	}

	public void setADDITIONALPREMIUM_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel aDDITIONALPREMIUM_TOGGLE) {
		ADDITIONALPREMIUM_TOGGLE = aDDITIONALPREMIUM_TOGGLE;
	}

	public org.richfaces.component.html.HtmlSimpleTogglePanel getDISCOUNT_TOGGLE() {
		return DISCOUNT_TOGGLE;
	}

	public void setDISCOUNT_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel dISCOUNT_TOGGLE) {
		DISCOUNT_TOGGLE = dISCOUNT_TOGGLE;
	}

	public org.richfaces.component.html.HtmlSimpleTogglePanel getLOADING_TOGGLE() {
		return LOADING_TOGGLE;
	}

	public void setLOADING_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel lOADING_TOGGLE) {
		LOADING_TOGGLE = lOADING_TOGGLE;
	}

	public org.richfaces.component.html.HtmlSimpleTogglePanel getCUST_ANNUAL_CHARGE_TOGGLE() {
		return CUST_ANNUAL_CHARGE_TOGGLE;
	}

	public void setCUST_ANNUAL_CHARGE_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel cUST_ANNUAL_CHARGE_TOGGLE) {
		CUST_ANNUAL_CHARGE_TOGGLE = cUST_ANNUAL_CHARGE_TOGGLE;
	}

	public org.richfaces.component.html.HtmlSimpleTogglePanel getCUST_SINGLE_CHARGE_TOGGLE() {
		return CUST_SINGLE_CHARGE_TOGGLE;
	}

	public void setCUST_SINGLE_CHARGE_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel cUST_SINGLE_CHARGE_TOGGLE) {
		CUST_SINGLE_CHARGE_TOGGLE = cUST_SINGLE_CHARGE_TOGGLE;
	}

	public void ExpandAllButtonAction()
	{
		System.out.println("Enter the ExpandAllButtonAction");

		getBASICPREMIUM_TOGGLE().setOpened(true);
		getADDITIONALPREMIUM_TOGGLE().setOpened(true);
		getDISCOUNT_TOGGLE().setOpened(true);
		getLOADING_TOGGLE().setOpened(true);
		getCUST_ANNUAL_CHARGE_TOGGLE().setOpened(true);
		getCUST_SINGLE_CHARGE_TOGGLE().setOpened(true);
		getCOMP_UI_M_BUT_EXPAND().setRendered(false);
		getCOMP_UI_M_BUT_SHRINK().setRendered(true);
		/*Added by saritha on 10-10-2017 for ssp call id ZBLIFE-1439993*/
		getORIGINAL_VALUE_TOGGLE().setOpened(true);
		/*End*/
		
	}

	public void SHRINKAllButtonAction()
	{
		System.out.println("Enter the ExpandAllButtonAction");

		getBASICPREMIUM_TOGGLE().setOpened(false);
		getADDITIONALPREMIUM_TOGGLE().setOpened(false);
		getDISCOUNT_TOGGLE().setOpened(false);
		getLOADING_TOGGLE().setOpened(false);
		getCUST_ANNUAL_CHARGE_TOGGLE().setOpened(false);
		getCUST_SINGLE_CHARGE_TOGGLE().setOpened(false);
		getCOMP_UI_M_BUT_SHRINK().setRendered(false);
		getCOMP_UI_M_BUT_EXPAND().setRendered(true);
		/*Added by saritha on 10-10-2017 for ssp call id ZBLIFE-1439993*/
		getORIGINAL_VALUE_TOGGLE().setOpened(false);
		/*End*/

	}



	public org.richfaces.component.html.HtmlSimpleTogglePanel getBASICPREMIUM_TOGGLE() {
		return BASICPREMIUM_TOGGLE;
	}

	public void setBASICPREMIUM_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel bASICPREMIUM_TOGGLE) {
		BASICPREMIUM_TOGGLE = bASICPREMIUM_TOGGLE;
	}




	/*public String BACK_ADDTNL_COVER(){
String outcome = null;
this.setBlockFlag(true);		
outcome = "PILT002_APAC_PT_IL_POL_ADDL_COVER";
//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
return outcome;
}*/


	public String BACK_ADDTNL_COVER(){
		String outcome = null;
		this.setBlockFlag(true);		
		//COMP_POAC_PREMIUM_BRK.setRendered(true);
		//added code to hide the rate field when click edit option in premium breakup details screen.
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_PDL_RATE().setRendered(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(false);
				
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate().setRendered(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(false);
		
		
		
		outcome = "PILT002_APAC_PT_IL_POL_ADDL_COVER";
		setShow(true);
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		CommonUtils.setGlobalObject("POAD_SYS_ID", compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID());
		return outcome;
	}

	private void resetSelectedRowloading() {
		Iterator<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_ITR = dataList_PT_IL_DISCOUNT
				.iterator();
		while (PT_IL_POL_DISC_LOAD_ITR.hasNext()) {
			PT_IL_POL_DISC_LOAD_ITR.next().setRowSelected(false);
		}
	}

	public boolean show= false;
	public void displayRecordsLoding() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRowloading();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = new PT_IL_POL_DISC_LOAD();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = (PT_IL_POL_DISC_LOAD) PT_IL_TOTALDISCOUNTdataTable.getRowData();
			//getCOMP_UI_M_POL_Rate().setRendered(true);
			
			System.out.println(PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE());
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setRowSelected(true);
			resetAllComponent();
			DISCOUNT_TOGGLE.setOpened(true);
			setShow(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	//AMEEN FOR DESC. 21-5-16
	
	public void displayRecordsLodingDesc() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRowloading();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = new PT_IL_POL_DISC_LOAD();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = (PT_IL_POL_DISC_LOAD) PT_IL_TOTALDISCOUNTdataTable.getRowData();
			getCOMP_UI_M_POL_Rate().setRendered(true);
			getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(true);
			System.out.println(PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE());
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setRowSelected(true);
			resetAllComponent();
			DISCOUNT_TOGGLE.setOpened(true);
			setShow(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	//END
	
	
	

	/*public void PDL_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
			try {
				if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE() < 0) {
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath, "71043")));
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
			if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}

			System.out.println("(Double) value    : "+(Double) value);
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
			postRecordDT();
			DISCOUNT_TOGGLE.setOpened(true);
			//ADDED BY SARANYA FOR COMMISSION DEDUCTION
			System.out.println("get value of rate: "+getPT_IL_POL_DISC_LOAD_ACTION_BEAN().getPDL_RATE());

			//END
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/



	public void postRecordDT() {
		String message = null;
		try {
			/*	if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getROWID() == null
				&& isINSERT_ALLOWED()) {
//			helper.preInsert(getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
//					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			new CRUDHandler().executeInsert(PT_IL_POL_DISC_LOAD_ACTION_BEAN,
					CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insert");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
		//	dataList_PT_IL_POL_DISC_LOAD.add(PT_IL_POL_DISC_LOAD_BEAN);
		} else if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getROWID() != null
				 && isUPDATE_ALLOWED()) {
			helper.preUpdate(getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_UID("PREMIADMIN");
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_DT(new CommonUtils().getCurrentDate());

			new CRUDHandler().executeUpdate(PT_IL_POL_DISC_LOAD_ACTION_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			COMP_UI_M_POL_Rate.setRendered(false);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			/*}
		PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);*/
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	//loading
	
	private HtmlInputText COMP_PDL_RATE;


	public HtmlInputText getCOMP_PDL_RATE() {
		return COMP_PDL_RATE;
	}

	public void setCOMP_PDL_RATE(HtmlInputText cOMP_PDL_RATE) {
		COMP_PDL_RATE = cOMP_PDL_RATE;
	}


public void validateCOMP_PDL_RATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}else{

				PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
				PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE_STR(CommonUtils.Decimal_Convert(String.valueOf(PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE())));
			}

			System.out.println("(Double) value    : "+(Double) value+" :::::::: PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE()    : "+PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE());
			//PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
			postRecordLoading();
			LOADING_TOGGLE.setOpened(true);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	
	

	public void postRecordLoading() {
		String message = null;
		try {
			System.out.println("$$$$$$$$$$$$ inside postRecordDTLoading $$$$$$$$$$$$$$$");
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_UID("PREMIADMIN");
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_DT(new CommonUtils().getCurrentDate());

			new CRUDHandler().executeUpdate(PT_IL_POL_DISC_LOAD_ACTION_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			COMP_PDL_RATE.setRendered(false);
			COMP_UI_M_POL_Rate_LOD_LABEL.setRendered(false);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			/*}
		PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void postRecordDISCOUNT() {
		String message = null;
		try {
			System.out.println("$$$$$$$$$$$$ inside postRecordDTLoading $$$$$$$$$$$$$$$");
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_UID("PREMIADMIN");
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_CR_DT(new CommonUtils().getCurrentDate());

			new CRUDHandler().executeUpdate(PT_IL_POL_DISC_LOAD_ACTION_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			COMP_UI_M_POL_Rate.setRendered(false);
			COMP_UI_M_POL_Rate_DIS_LABEL.setRendered(false);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			/*}
		PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}





public void displayRecordsLodingEdit() {
		CommonUtils.clearMaps(this);
		try {
			System.out.println("*************** displayRecordsLodingexact Edit *************");
			resetSelectedRowloading();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = new PT_IL_POL_DISC_LOAD();
			PT_IL_POL_DISC_LOAD_ACTION_BEAN = (PT_IL_POL_DISC_LOAD) PT_IL_TOTALlOADINGdataTable.getRowData();
			getCOMP_PDL_RATE().setRendered(true);
			getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(true);
			System.out.println("22 &&&&&&"+PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE());
			PT_IL_POL_DISC_LOAD_ACTION_BEAN.setRowSelected(true);
			resetAllComponent();
			LOADING_TOGGLE.setOpened(true);
			setShow(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

public void validatingPDL_RATE(FacesContext context,
		UIComponent component, Object value) throws ValidatorException {
	System.out.println("disc valid 1234.....");
	try {
		PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
		
		if (PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE() < 0) {
			throw new ValidatorException(new FacesMessage(Messages
					.getString(PELConstants.pelErrorMessagePath, "71043")));
		}

		System.out.println("discount validate (Double) value    : "+(Double) value+" :::::::: PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE()    : "+PT_IL_POL_DISC_LOAD_ACTION_BEAN.getPDL_RATE());
		//PT_IL_POL_DISC_LOAD_ACTION_BEAN.setPDL_RATE((Double) value);
		postRecordDISCOUNT();
		LOADING_TOGGLE.setOpened(true);
		
	} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public void working(){
	System.out.println("************************************************** composite testing working**********");
}
	



public String GetDIS_LODAppliedOnDesc(String CODE)
		throws Exception {
	ResultSet resultSet = null;
	String Appondesc="";
	
	try {
		/*String C1 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND" 
						+"LI_MODULE_NAME  = 'PILM035_APAC' AND LIV_SYS_PARAM  = 'IL_APPLIEDON' AND LI_BLOCK_NAME = 'PM_IL_PROD_APPL_LOAD_TARIFF' "
							+"AND LI_ITEM_NAME='PM_IL_PROD_APPL_LOAD_TARIFF.PALT_APPLIED_ON' AND LIV_CODE= ? ";*/
		String C1 ="SELECT LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME  = 'PILM035_APAC' "
				+"AND LIV_SYS_PARAM  = 'IL_APPLIEDON' AND LI_BLOCK_NAME = 'PM_IL_PROD_APPL_LOAD_TARIFF' AND LI_ITEM_NAME='PM_IL_PROD_APPL_LOAD_TARIFF.PALT_APPLIED_ON' AND LIV_CODE= ? ";
		resultSet = new CRUDHandler().executeSelectStatement(C1,
				CommonUtils.getConnection(),new Object[] { CODE });
		if (resultSet.next()) {
			Appondesc=resultSet.getString("LIV_CODE_DESC");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		}
	}
	return Appondesc;

}
public String GetChargeAppliedOnDesc(String CODE)
		throws Exception {
	ResultSet resultSet = null;
	String Appondesc="";
	
	try {
		
		String C1 ="SELECT  LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC'"
					+"AND LIV_SYS_PARAM  = 'IL_CHGAPPLON' AND LI_BLOCK_NAME ='PT_IL_POL_CHARGE' AND LI_ITEM_NAME='PT_IL_POL_CHARGE.POC_APPLIED_ON' AND LIV_CODE= ?";
		resultSet = new CRUDHandler().executeSelectStatement(C1,
				CommonUtils.getConnection(),new Object[] { CODE });
		if (resultSet.next()) {
			Appondesc=resultSet.getString("LIV_CODE_DESC");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		}
	}
	return Appondesc;

}


public String GetChargeCodeDesc(String CODE)
		throws Exception {
	ResultSet resultSet = null;
	String Codedesc="";
	
	try {
		
		String C1 ="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE'and PC_CODE=?";
		resultSet = new CRUDHandler().executeSelectStatement(C1,
				CommonUtils.getConnection(),new Object[] { CODE });
		if (resultSet.next()) {
			Codedesc=resultSet.getString("PC_DESC");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		}
	}
	return Codedesc;

}
public String GetAdditionalCoverCodeDesc(String CODE)
		throws Exception {
	ResultSet resultSet = null;
	String Codedesc="";
	
	try {
		
		String C1 =" select cover_desc from pm_il_cover where cover_code =?";
		resultSet = new CRUDHandler().executeSelectStatement(C1,
				CommonUtils.getConnection(),new Object[] { CODE });
		if (resultSet.next()) {
			Codedesc=resultSet.getString("cover_desc");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		}
	}
	return Codedesc;

}

/*added by Raja .R for add EMR Rate field*/

public void validatePOAC_EMR_RATE(FacesContext facesContext,
		UIComponent component, Object value) throws ValidatorException {
	CommonUtils.clearMaps(this);
	try {
		
		PT_IL_POL_ADDL_COVER_BEAN.setPOAC_EMR_RATE((Double) value);
		String emr=Double.toString(PT_IL_POL_ADDL_COVER_BEAN.getPOAC_EMR_RATE());
		PT_IL_POL_ADDL_COVER_BEAN.setUI_POAC_EMR_RATE(CommonUtils.Decimal_Convert(emr));
		
		// COMP_POL_WAQAF_PERIOD_FM.resetValue();
	} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
				.getMessage()));
	} 
}

/*End*/

/*public String Decimal_Convert(String Value)
{
	if(Value != null)
	{
	int decimalPlaces=0;
	System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
	 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
	System.out.println("decimalPlaces   : "+decimalPlaces);
	
	
	BigDecimal bd = new BigDecimal(Value);
    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
    
    return bd.toString();
	}
	else
	{
		return "0.000";
	}
}*/

/*Added by Ram on 10/11/2016 for Editable datagrid*/
private boolean postClick;

public boolean isPostClick() {
	return postClick;
}

public void setPostClick(boolean postClick) {
	this.postClick = postClick;
}

public void setEMR_Editable(ActionEvent event) {
	try
	{
	setPostClick(false);
	System.out.println("Welcome to setEMR_Editable");
	 
	
	CommonUtils.clearMaps(this);
	String UI_POAC_EMR_RATE=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
	int currentIndex=this.dataTable.getRowIndex();
	System.out.println("currentIndex in EMR         "+currentIndex);
	PT_IL_POL_ADDL_COVER_BEAN=(PT_IL_POL_ADDL_COVER)dataList_PT_IL_POL_ADDL_COVER.get(currentIndex);
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_EMR_RATE(Double.parseDouble(UI_POAC_EMR_RATE));
	
	COMP_POAC_EMR_RATE.resetValue();
	}
	catch(Exception e)
	{

		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("postRecord", e.getMessage());	
	
	}
}

public void setPOAC_PERIOD_Editable(ActionEvent event) {
	try
	{
	setPostClick(false);
	System.out.println("Welcome to setPOAC_PERIOD_Editable");
	 
	
	CommonUtils.clearMaps(this);
	
	
	String POAC_PERIOD=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
	int currentIndex=this.dataTable.getRowIndex();
	System.out.println("currentIndex in POAC_PERIOD         "+currentIndex);
	PT_IL_POL_ADDL_COVER_BEAN=(PT_IL_POL_ADDL_COVER)dataList_PT_IL_POL_ADDL_COVER.get(currentIndex);
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PERIOD(Integer.parseInt(POAC_PERIOD));
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(Integer.parseInt(POAC_PERIOD));
	
	
	Calendar c = Calendar.getInstance();
	c.setTime(PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FM_DT());
	c.add(Calendar.YEAR, PT_IL_POL_ADDL_COVER_BEAN.getPOAC_PERIOD());
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TO_DT(c.getTime());
	
	System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FM_DT()     "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FM_DT());
	System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPOAC_TO_DT()     "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_TO_DT());
	
	helper.POAC_PERIOD_WHEN_VALIDATE_ITEM(this,getPT_IL_POL_ADDL_COVER_BEAN(), 
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
	
	COMP_POAC_FM_DT.resetValue();
	COMP_POAC_TO_DT.resetValue();
	COMP_POAC_PERIOD.resetValue();
	COMP_POAC_PREM_PAY_YRS.resetValue();
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("postRecord", e.getMessage());	
	}

}

/*Added by Ram on 15/12/2016 for Adding Premium Paying Years field in Datatable*/
public void setPOAC_PREM_PAY_YRS_Editable(ActionEvent event) {
	try
	{
	setPostClick(false);
	System.out.println("Welcome to setPOAC_PERIOD_Editable");
	 
	
	CommonUtils.clearMaps(this);
	String POAC_PREM_PAY_YRS=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
	int currentIndex=this.dataTable.getRowIndex();
	System.out.println("currentIndex in POAC_PREM_PAY_YRS         "+currentIndex);
	
	PT_IL_POL_ADDL_COVER_BEAN=(PT_IL_POL_ADDL_COVER)dataList_PT_IL_POL_ADDL_COVER.get(currentIndex);
	
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(Integer.parseInt(POAC_PREM_PAY_YRS));
	helper.POAC_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(PT_IL_POL_ADDL_COVER_BEAN,compositeAction);
	
	System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FM_DT()     "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FM_DT());
	System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getPOAC_TO_DT()     "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_TO_DT());
	  
	COMP_POAC_PREM_PAY_YRS.resetValue();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("postRecord", e.getMessage());	
	}

}
/*End*/

public void setPOAC_FC_SA_Editable(ActionEvent event) {
	try
	{
		 
	setPostClick(false);
	System.out.println("Welcome to setPOAC_FC_SA_Editable");
	 
	
	CommonUtils.clearMaps(this);
	String POAC_RATE=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
	int currentIndex=this.dataTable.getRowIndex();
	System.out.println("currentIndex in POAC_FC_SA         "+currentIndex);
	PT_IL_POL_ADDL_COVER_BEAN=(PT_IL_POL_ADDL_COVER)dataList_PT_IL_POL_ADDL_COVER.get(currentIndex);
	
	/*Added by Ram on 22/12/2016 for SumAssured validation*/
	PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
	System.out.println("compositeAction        "+compositeAction);
	if(Double.parseDouble(POAC_RATE) > compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED())
	{
		throw new Exception("Rider SumAssured is not greater than Basic SumAssured");
	}
	/*End*/
	
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(Double.parseDouble(POAC_RATE));
	
	/*Added by Ram on 13/12/2016 for Sumassured replace old value*/
	PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA(Double.parseDouble(POAC_RATE));
	 /*End*/
	
	String emr=Double.toString(PT_IL_POL_ADDL_COVER_BEAN.getPOAC_EMR_RATE());
	PT_IL_POL_ADDL_COVER_BEAN.setUI_POAC_EMR_RATE(CommonUtils.Decimal_Convert(emr));
	
	COMP_POAC_FC_SA.resetValue();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("postRecord", e.getMessage());	
	
		
	}
}


public String saveCurrentRecord(){
	String outcome = null;
	System.out.println("saveCurrentRecord");
	String message = null;
try
{
	System.out.println("PT_IL_POL_ADDL_COVER_BEAN.setPOAC_EMR_RATE(     "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_EMR_RATE()+"       "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_FC_SA()+
			"  "+PT_IL_POL_ADDL_COVER_BEAN.getPOAC_PERIOD());
	

	
	
	helper.POAC_PERIOD_WHEN_VALIDATE_ITEM(this,getPT_IL_POL_ADDL_COVER_BEAN(), 
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
	COMP_POAC_TO_DT.resetValue();
	COMP_POAC_PREM_PAY_YRS.resetValue();
	
	/*
	 * 
	 * cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017
	 * 	helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
				PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());*/
		/*ADDED BY SANKARA NARAYANAN ON FOR sUM ASSURED VALIDATION 07/04/2017*/
		helper.POAC_FC_SA_WHEN_VALIDATE_ITEM(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
				PT_IL_POL_ADDL_COVER_BEAN, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		/*END*/
	
	
	helper.preUpdate(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
			.getCTRL_ACTION_BEAN().getCTRL_BEAN());
	new CRUDHandler().executeUpdate(PT_IL_POL_ADDL_COVER_BEAN,
			CommonUtils.getConnection());
	message = Messages.getString(
			PELConstants.pelMessagePropertiesPath,
			"errorPanel$message$update");
	
	CommonUtils.getConnection().commit();
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			message);
	getWarningMap().put("postRecord", message);
	PT_IL_POL_ADDL_COVER_BEAN.setRowSelected(true);
	setPostClick(true);
}
catch(Exception e)
{
	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			e.getMessage());
	getErrorMap().put("postRecord", e.getMessage());	
}
	
	
	return outcome;
}
 
/*End*/

/*Added by Ram on 16/11/2016 for Premium Parameters*/
private HtmlOutputLabel COMP_AGE_LABEL;
private HtmlOutputLabel COMP_AGE_LABEL_OP;
private HtmlOutputLabel COMP_POLICY_TERM;
private HtmlOutputLabel COMP_POLICY_TERM_OP;
private HtmlOutputLabel COMP_MOP;
private HtmlOutputLabel COMP_MOP_OP;
private HtmlOutputLabel COMP_CATEGORY;
private HtmlOutputLabel COMP_CATEGOR_OP;

public HtmlOutputLabel getCOMP_AGE_LABEL() {
	return COMP_AGE_LABEL;
}

public void setCOMP_AGE_LABEL(HtmlOutputLabel cOMP_AGE_LABEL) {
	COMP_AGE_LABEL = cOMP_AGE_LABEL;
}

public HtmlOutputLabel getCOMP_AGE_LABEL_OP() {
	return COMP_AGE_LABEL_OP;
}

public void setCOMP_AGE_LABEL_OP(HtmlOutputLabel cOMP_AGE_LABEL_OP) {
	COMP_AGE_LABEL_OP = cOMP_AGE_LABEL_OP;
}

public HtmlOutputLabel getCOMP_POLICY_TERM() {
	return COMP_POLICY_TERM;
}

public void setCOMP_POLICY_TERM(HtmlOutputLabel cOMP_POLICY_TERM) {
	COMP_POLICY_TERM = cOMP_POLICY_TERM;
}

public HtmlOutputLabel getCOMP_POLICY_TERM_OP() {
	return COMP_POLICY_TERM_OP;
}

public void setCOMP_POLICY_TERM_OP(HtmlOutputLabel cOMP_POLICY_TERM_OP) {
	COMP_POLICY_TERM_OP = cOMP_POLICY_TERM_OP;
}

public HtmlOutputLabel getCOMP_MOP() {
	return COMP_MOP;
}

public void setCOMP_MOP(HtmlOutputLabel cOMP_MOP) {
	COMP_MOP = cOMP_MOP;
}

public HtmlOutputLabel getCOMP_MOP_OP() {
	return COMP_MOP_OP;
}

public void setCOMP_MOP_OP(HtmlOutputLabel cOMP_MOP_OP) {
	COMP_MOP_OP = cOMP_MOP_OP;
}

public HtmlOutputLabel getCOMP_CATEGORY() {
	return COMP_CATEGORY;
}

public void setCOMP_CATEGORY(HtmlOutputLabel cOMP_CATEGORY) {
	COMP_CATEGORY = cOMP_CATEGORY;
}

public HtmlOutputLabel getCOMP_CATEGOR_OP() {
	return COMP_CATEGOR_OP;
}

public void setCOMP_CATEGOR_OP(HtmlOutputLabel cOMP_CATEGOR_OP) {
	COMP_CATEGOR_OP = cOMP_CATEGOR_OP;
}

private String PAYMENT_TERM;

public String getPAYMENT_TERM() {
	return PAYMENT_TERM;
}

public void setPAYMENT_TERM(String pAYMENT_TERM) {
	PAYMENT_TERM = pAYMENT_TERM;
}

public void setpaymentTerm()
{
	System.out.println("PILT002_APAC_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_MODE_OF_PYMT       "
+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT());
	if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT() != null)
	{
		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT().equals("M"))
		{
			setPAYMENT_TERM("Monthly");
		}
		else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT().equals("H"))
		{
			setPAYMENT_TERM("Half Yearly");
		}
		else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT().equals("Y"))
		{
			setPAYMENT_TERM("Yearly");
		}
		else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT().equals("S"))
		{
			setPAYMENT_TERM("Single");
		}
		/*Added by ganesh on 10-11-2017 to avoid MOP null in Premium detail screen for quartely*/
		else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT().equals("Q"))
		{
			setPAYMENT_TERM("Quarterly");
		}
		/*end*/
	}
	
}

private HtmlSimpleTogglePanel PREMIUM_PARAM_TOGGLE;

public HtmlSimpleTogglePanel getPREMIUM_PARAM_TOGGLE() {
	return PREMIUM_PARAM_TOGGLE;
}

public void setPREMIUM_PARAM_TOGGLE(HtmlSimpleTogglePanel pREMIUM_PARAM_TOGGLE) {
	PREMIUM_PARAM_TOGGLE = pREMIUM_PARAM_TOGGLE;
}

/*End*/

/* Added by ganesh on 03-07-2017, as per ajoy suggested rate should only display with 3 decimals for that we created system param */
	private int customRateDecimalSystemParam;

	public int getCustomRateDecimalSystemParam() {
		return customRateDecimalSystemParam;
	}

	public void setCustomRateDecimalSystemParam(int customRateDecimalSystemParam) {
		this.customRateDecimalSystemParam = customRateDecimalSystemParam;
	}
	
	
/*end*/
	
	
	/*Added by saritha on 12-07-2017 for Endowment &Education Product*/  
	public void enableDSAAnnutity() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		String C1 = "SELECT PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		String C2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ? ";
		String prod_unit_link_type = null;
		String planType = null;
		try {
			connection = CommonUtils.getConnection();
			String Plan_Code=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE();
			System.out.println("Plan_Code----------"+Plan_Code);

			resultSet = new CRUDHandler().executeSelectStatement(C1,
					connection, new Object[] {Plan_Code});
			if (resultSet.next()) {
				prod_unit_link_type = resultSet.getString(1);
				System.out.println("Product_Unit_Link_Type----->" +prod_unit_link_type);
			}

			resultSet1 = new CRUDHandler().executeSelectStatement(C2,
					connection, new Object[] {Plan_Code });
			if (resultSet1.next()) {
				planType = resultSet1.getString(1);
				System.out.println("Product_planType----->" +planType);
			}

			if (("U".equals(planType))&&("END".equals(prod_unit_link_type))) {

				compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN().getCOMP_UI_M_BUT_RD_SA1().setRendered(true);
				compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN().getCOMP_UI_M_BUT_RD_SA1().setDisabled(false);

			} 

			else if(("U".equals(planType))&&("EDU".equals(prod_unit_link_type))) {

				compositeAction.getPT_IL_POL_ESC_SA_ACTION_BEAN().getCOMP_UI_M_BUT_ANNU_ESC().setRendered(true);
				compositeAction.getPT_IL_POL_ESC_SA_ACTION_BEAN().getCOMP_UI_M_BUT_ANNU_ESC().setDisabled(false);

			}

		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	 /*End*/
	
	/*Added by saritha on 10-10-2017 for ssp call id ZBLIFE-1439993*/
	private org.richfaces.component.html.HtmlSimpleTogglePanel ORIGINAL_VALUE_TOGGLE;

	public org.richfaces.component.html.HtmlSimpleTogglePanel getORIGINAL_VALUE_TOGGLE() {
		return ORIGINAL_VALUE_TOGGLE;
	}

	public void setORIGINAL_VALUE_TOGGLE(
			org.richfaces.component.html.HtmlSimpleTogglePanel oRIGINAL_VALUE_TOGGLE) {
		ORIGINAL_VALUE_TOGGLE = oRIGINAL_VALUE_TOGGLE;
	}
	
	/*End*/
	
	
	
	 /*Added by Janani on 06.04.2018 for KIC*/
	 
	public void checkPolperiod() throws Exception {
	
		 ResultSet resultSet = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
		 Double M_PAC_MAX_AGE_ON_MAT = null;
		try {
		
	 String CURSOR_C1 = "SELECT PAC_MAX_AGE_ON_MAT,PAC_MAT_PAYER_AGE,PAC_MAT_PAYEE_AGE,PAC_AGE_BASIS," +
				"PAC_PREM_PAY_YRS FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ? ";
	 
	
	 connection = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
				new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),
				getPT_IL_POL_ADDL_COVER_BEAN().getPOAC_COVER_CODE() });
		
		if (resultSet.next()) {
			M_PAC_MAX_AGE_ON_MAT = resultSet.getDouble(1);
			
		}
	 
	int M_DUMMY = CommonUtils.nvl(getPT_IL_POL_ADDL_COVER_BEAN().getPOAC_PERIOD(), 0)
				+ CommonUtils.nvl(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE(), 0);
				if (M_DUMMY >  M_PAC_MAX_AGE_ON_MAT ) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
							new Object[] { "Cover Period + Assured Age"," <= Maximum Maturity Age",M_PAC_MAX_AGE_ON_MAT }));
				}
	 /*End*/
	
	} catch (DBException e) {
		e.printStackTrace();
		throw e;
	} catch (SQLException e) {
		e.printStackTrace();
		throw e;
	}
	 
}

}
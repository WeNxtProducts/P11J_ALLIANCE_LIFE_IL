package com.iii.pel.forms.PILT006_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.component.html.HtmlAjaxSupport;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.fileupload.FileUploadAction;


import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.forms.PILT042_APAC.PILT042_APAC_SEATCH_ACTION;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_BUS_RULE;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PILPK_PILT006;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;
import com.iii.premia.runtime.functions.ConvertFunctions;

public class PT_IL_CLAIM_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_UI_M_CLOSE_FLAG_LABEL;

	private HtmlInputText COMP_UI_M_CLOSE_FLAG;

	private HtmlOutputLabel COMP_UI_M_CLAIM_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_STATUS;

	private HtmlOutputLabel COMP_UI_M_CLAIM_ADDL_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_ADDL_STATUS;

	private HtmlOutputLabel COMP_CLAIM_PCI_REF_NO_LABEL;

	private HtmlInputText COMP_CLAIM_PCI_REF_NO;

	private HtmlOutputLabel COMP_CLAIM_POL_NO_LABEL;

	private HtmlInputText COMP_CLAIM_POL_NO;

	private HtmlOutputLabel COMP_CLAIM_ASSR_CODE_LABEL;

	private HtmlInputText COMP_CLAIM_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_CLAIM_ASS_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_ASS_NAME;

	private HtmlOutputLabel COMP_CLAIM_CUST_CODE_LABEL;

	private HtmlInputText COMP_CLAIM_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CUST_DESC;

	private HtmlOutputLabel COMP_CLAIM_ACCNT_PAY_CODE_LABEL;

	private HtmlInputText COMP_CLAIM_ACCNT_PAY_CODE;

	private HtmlOutputLabel COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC;

	private HtmlOutputLabel COMP_CLAIM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CLAIM_TYPE;

	private HtmlOutputLabel COMP_CLAIM_MED_CODE_LABEL;

	private HtmlInputText COMP_CLAIM_MED_CODE;

	private HtmlOutputLabel COMP_UI_M_CLAIM_MED_CODE_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_MED_CODE_NAME;

	private HtmlOutputLabel COMP_CLAIM_LOSS_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_LOSS_DT;

	private HtmlOutputLabel COMP_CLAIM_INTM_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_INTM_DT;

	private HtmlOutputLabel COMP_CLAIM_LC_RLA_AMOUNT_LABEL;

	private HtmlInputText COMP_CLAIM_LC_RLA_AMOUNT;

	private HtmlOutputLabel COMP_CLAIM_NO_LABEL;

	private HtmlInputText COMP_CLAIM_NO;

	private HtmlOutputLabel COMP_CLAIM_CURR_CODE_LABEL;

	private HtmlInputText COMP_CLAIM_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_CLAIM_REF_NO_LABEL;

	private HtmlInputText COMP_CLAIM_REF_NO;

	private HtmlOutputLabel COMP_CLAIM_CR_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_CR_DT;

	private HtmlOutputLabel COMP_CLAIM_POL_VALID_YN_LABEL;

	private HtmlSelectOneMenu COMP_CLAIM_POL_VALID_YN;

	private HtmlOutputLabel COMP_CLAIM_REMARKS_LABEL;

	private HtmlInputText COMP_CLAIM_REMARKS;

	private HtmlOutputLabel COMP_CLAIM_RESV_AMT_LABEL;

	private HtmlInputText COMP_CLAIM_RESV_AMT;

	private HtmlOutputLabel COMP_CLAIM_UTIL_AMT_LABEL;

	private HtmlInputText COMP_CLAIM_UTIL_AMT;

	private HtmlOutputLabel COMP_CLAIM_REOPEN_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_REOPEN_DT;

	private HtmlOutputLabel COMP_CLAIM_REOPEN_REASON_LABEL;

	private HtmlInputText COMP_CLAIM_REOPEN_REASON;

	private HtmlOutputLabel COMP_CLAIM_LC_RISK_PREM_LABEL;

	private HtmlInputText COMP_CLAIM_LC_RISK_PREM;

	private HtmlOutputLabel COMP_CLAIM_LC_WAK_AMT_LABEL;

	private HtmlInputText COMP_CLAIM_LC_WAK_AMT;
	
	 /*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
		private HtmlOutputLabel COMP_CLAIMANT_CODE_LABEL;
		

		public HtmlOutputLabel getCOMP_CLAIMANT_CODE_LABEL() {
			return COMP_CLAIMANT_CODE_LABEL;
		}

		public void setCOMP_CLAIMANT_CODE_LABEL(HtmlOutputLabel cOMP_CLAIMANT_CODE_LABEL) {
			COMP_CLAIMANT_CODE_LABEL = cOMP_CLAIMANT_CODE_LABEL;
		}

		private HtmlInputText COMP_CLAIMANT_CODE;

		public HtmlInputText getCOMP_CLAIMANT_CODE() {
			return COMP_CLAIMANT_CODE;
		}

		public void setCOMP_CLAIMANT_CODE(HtmlInputText cOMP_CLAIMANT_CODE) {
			COMP_CLAIMANT_CODE = cOMP_CLAIMANT_CODE;
		}

		
		
		private HtmlInputText COMP_UI_M_CLAIM_CLAIMANT_CODE_DESC;
		
		public HtmlInputText getCOMP_UI_M_CLAIM_CLAIMANT_CODE_DESC() {
			return COMP_UI_M_CLAIM_CLAIMANT_CODE_DESC;
		}

		public void setCOMP_UI_M_CLAIM_CLAIMANT_CODE_DESC(
				HtmlInputText cOMP_UI_M_CLAIM_CLAIMANT_CODE_DESC) {
			COMP_UI_M_CLAIM_CLAIMANT_CODE_DESC = cOMP_UI_M_CLAIM_CLAIMANT_CODE_DESC;
		}
		
		/*END*/
	
	
	/*Added by sankara narayanan for adding the binding cor save button on 08/03/2017*/
	
	private HtmlCommandLink COMP_SAVE_COMMAND_LINK;

	private HtmlCommandButton COMP_SAVE_BUTTON;
	
	
	
	public HtmlCommandLink getCOMP_SAVE_COMMAND_LINK() {
		return COMP_SAVE_COMMAND_LINK;
	}

	public void setCOMP_SAVE_COMMAND_LINK(HtmlCommandLink cOMP_SAVE_COMMAND_LINK) {
		COMP_SAVE_COMMAND_LINK = cOMP_SAVE_COMMAND_LINK;
	}

	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}

	public void setCOMP_SAVE_BUTTON(HtmlCommandButton cOMP_SAVE_BUTTON) {
		COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	}

	
	/*end*/
	
	/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017*/
	/*private HtmlOutputLabel COMP_CLAIM_FEE_HOSPITALS_LABEL;
	
	public HtmlOutputLabel getCOMP_CLAIM_FEE_HOSPITALS_LABEL() {
		return COMP_CLAIM_FEE_HOSPITALS_LABEL;
	}

	public void setCOMP_CLAIM_FEE_HOSPITALS_LABEL(
			HtmlOutputLabel cOMP_CLAIM_FEE_HOSPITALS_LABEL) {
		COMP_CLAIM_FEE_HOSPITALS_LABEL = cOMP_CLAIM_FEE_HOSPITALS_LABEL;
	}
	private HtmlInputText COMP_CLAIM_FEE_HOSPITALS;
	
	public HtmlInputText getCOMP_CLAIM_FEE_HOSPITALS() {
		return COMP_CLAIM_FEE_HOSPITALS;
	}

	public void setCOMP_CLAIM_FEE_HOSPITALS(HtmlInputText cOMP_CLAIM_FEE_HOSPITALS) {
		COMP_CLAIM_FEE_HOSPITALS = cOMP_CLAIM_FEE_HOSPITALS;
	}*/
	/*end*/
	/*added by gopi for hand on feed back point,serial no 15 in zb on 01/02/17*/
	private HtmlOutputLabel COMP_CLAIM_DISEASES_CODE_LABEL;
	
	public HtmlOutputLabel getCOMP_CLAIM_DISEASES_CODE_LABEL() {
		return COMP_CLAIM_DISEASES_CODE_LABEL;
	}

	public void setCOMP_CLAIM_DISEASES_CODE_LABEL(
			HtmlOutputLabel cOMP_CLAIM_DISEASES_CODE_LABEL) {
		COMP_CLAIM_DISEASES_CODE_LABEL = cOMP_CLAIM_DISEASES_CODE_LABEL;
	}
	private HtmlInputText COMP_CLAIM_DISEASES_CODE;
	
	public HtmlInputText getCOMP_CLAIM_DISEASES_CODE() {
		return COMP_CLAIM_DISEASES_CODE;
	}

	public void setCOMP_CLAIM_DISEASES_CODE(HtmlInputText cOMP_CLAIM_DISEASES_CODE) {
		COMP_CLAIM_DISEASES_CODE = cOMP_CLAIM_DISEASES_CODE;
	}
	private HtmlInputText COMP_UI_M_CLAIM_DISEASES_CODE;
	
	public HtmlInputText getCOMP_UI_M_CLAIM_DISEASES_CODE() {
		return COMP_UI_M_CLAIM_DISEASES_CODE;
	}

	public void setCOMP_UI_M_CLAIM_DISEASES_CODE(
			HtmlInputText cOMP_UI_M_CLAIM_DISEASES_CODE) {
		COMP_UI_M_CLAIM_DISEASES_CODE = cOMP_UI_M_CLAIM_DISEASES_CODE;
	}
	private HtmlOutputLabel COMP_CLAIM_DISEASES_REMARKS_LABEL;
	
	public HtmlOutputLabel getCOMP_CLAIM_DISEASES_REMARKS_LABEL() {
		return COMP_CLAIM_DISEASES_REMARKS_LABEL;
	}

	public void setCOMP_CLAIM_DISEASES_REMARKS_LABEL(
			HtmlOutputLabel cOMP_CLAIM_DISEASES_REMARKS_LABEL) {
		COMP_CLAIM_DISEASES_REMARKS_LABEL = cOMP_CLAIM_DISEASES_REMARKS_LABEL;
	}
	private HtmlInputText COMP_CLAIM_DISEASES_REMARKS;
	

	public HtmlInputText getCOMP_CLAIM_DISEASES_REMARKS() {
		return COMP_CLAIM_DISEASES_REMARKS;
	}

	public void setCOMP_CLAIM_DISEASES_REMARKS(
			HtmlInputText cOMP_CLAIM_DISEASES_REMARKS) {
		COMP_CLAIM_DISEASES_REMARKS = cOMP_CLAIM_DISEASES_REMARKS;
	}
	//end
	private HtmlOutputLabel COMP_CLAIM_LC_SERV_FEE_LABEL;

	private HtmlInputText COMP_CLAIM_LC_SERV_FEE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_CLAIM_MED_CODE;

	private HtmlCommandLink COMP_BUT_BACK;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PRE_CLM_NO;

	private HtmlCommandButton COMP_UI_M_BUT_PRE_CLAIM_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_FRZ;

	private HtmlCommandButton COMP_UI_M_BUTT_ACC_FIR_DTLS;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_EST_CURR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_EDI_CLIAM_REMARK;

	private HtmlCommandButton COMP_UI_M_BUT_CLOSE;

	private HtmlCommandButton COMP_UI_M_BUT_STAUS_CHANGE;

	private HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_SR_NO;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_REOPEN;

	private HtmlCommandButton COMP_UI_M_BUT_POLICY_DTLS;

	private HtmlOutputLabel COMP_CLAIM_DISABILTY_LABEL;

	private HtmlInputText COMP_CLAIM_DISABLITY;

	private List<PT_IL_CLAIM> suggestionList = null;

	private boolean searchMode = false;

	private PT_IL_CLAIM PT_IL_CLAIM_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private IP_REP_INFO IP_REP_INFO_BEAN;

	private List<SelectItem> POLICY_VALID_LIST;

	private List<SelectItem> CLAIM_TYPE_LIST;

	private List<LovBean> suggestionLOV = null;
	private PT_IL_CLAIM_HELPER helper;

	private String freezCaption;
	
	private HtmlAjaxSupport CLAIM_ASSR_CODE_AJAX_SUPPORT_level;
	
	//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
	
		private HtmlOutputLabel COMP_CLAIM_DIS_CERT_DT_LABEL;
		
		private HtmlCalendar COMP_CLAIM_DIS_CERT_DT;
		
		private HtmlOutputLabel COMP_CLAIM_MED_EXP_DT_LABEL;
		
		private HtmlCalendar COMP_CLAIM_MED_EXP_DT;
		
		private HtmlOutputLabel COMP_CLAIM_SICKNESS_DT_LABEL;
		
		private HtmlCalendar COMP_CLAIM_SICKNESS_DT;

		public HtmlOutputLabel getCOMP_CLAIM_DIS_CERT_DT_LABEL() {
			return COMP_CLAIM_DIS_CERT_DT_LABEL;
		}

		public void setCOMP_CLAIM_DIS_CERT_DT_LABEL(
				HtmlOutputLabel cOMP_CLAIM_DIS_CERT_DT_LABEL) {
			COMP_CLAIM_DIS_CERT_DT_LABEL = cOMP_CLAIM_DIS_CERT_DT_LABEL;
		}

		public HtmlCalendar getCOMP_CLAIM_DIS_CERT_DT() {
			return COMP_CLAIM_DIS_CERT_DT;
		}

		public void setCOMP_CLAIM_DIS_CERT_DT(HtmlCalendar cOMP_CLAIM_DIS_CERT_DT) {
			COMP_CLAIM_DIS_CERT_DT = cOMP_CLAIM_DIS_CERT_DT;
		}

		public HtmlOutputLabel getCOMP_CLAIM_MED_EXP_DT_LABEL() {
			return COMP_CLAIM_MED_EXP_DT_LABEL;
		}

		public void setCOMP_CLAIM_MED_EXP_DT_LABEL(
				HtmlOutputLabel cOMP_CLAIM_MED_EXP_DT_LABEL) {
			COMP_CLAIM_MED_EXP_DT_LABEL = cOMP_CLAIM_MED_EXP_DT_LABEL;
		}

		public HtmlCalendar getCOMP_CLAIM_MED_EXP_DT() {
			return COMP_CLAIM_MED_EXP_DT;
		}

		public void setCOMP_CLAIM_MED_EXP_DT(HtmlCalendar cOMP_CLAIM_MED_EXP_DT) {
			COMP_CLAIM_MED_EXP_DT = cOMP_CLAIM_MED_EXP_DT;
		}

		public HtmlOutputLabel getCOMP_CLAIM_SICKNESS_DT_LABEL() {
			return COMP_CLAIM_SICKNESS_DT_LABEL;
		}

		public void setCOMP_CLAIM_SICKNESS_DT_LABEL(
				HtmlOutputLabel cOMP_CLAIM_SICKNESS_DT_LABEL) {
			COMP_CLAIM_SICKNESS_DT_LABEL = cOMP_CLAIM_SICKNESS_DT_LABEL;
		}

		public HtmlCalendar getCOMP_CLAIM_SICKNESS_DT() {
			return COMP_CLAIM_SICKNESS_DT;
		}

		public void setCOMP_CLAIM_SICKNESS_DT(HtmlCalendar cOMP_CLAIM_SICKNESS_DT) {
			COMP_CLAIM_SICKNESS_DT = cOMP_CLAIM_SICKNESS_DT;
		}
		
		//END CLAIM TYPE = OTHERS

	public HtmlAjaxSupport getCLAIM_ASSR_CODE_AJAX_SUPPORT_level() {
		return CLAIM_ASSR_CODE_AJAX_SUPPORT_level;
	}

	public void setCLAIM_ASSR_CODE_AJAX_SUPPORT_level(
			HtmlAjaxSupport cLAIM_ASSR_CODE_AJAX_SUPPORT_level) {
		CLAIM_ASSR_CODE_AJAX_SUPPORT_level = cLAIM_ASSR_CODE_AJAX_SUPPORT_level;
	}

	public String getFreezCaption() {
		return freezCaption;
	}

	public void setFreezCaption(String freezCaption) {
		this.freezCaption = freezCaption;
	}

/*Added by Janani on 13.9.2016 for File_upload*/
	
	private HtmlCommandButton COMP_UI_M_BUT_DOCUMENTS;

	public HtmlCommandButton getCOMP_UI_M_BUT_DOCUMENTS() {
		return COMP_UI_M_BUT_DOCUMENTS;
	}

	public void setCOMP_UI_M_BUT_DOCUMENTS(HtmlCommandButton cOMP_UI_M_BUT_DOCUMENTS) {
		COMP_UI_M_BUT_DOCUMENTS = cOMP_UI_M_BUT_DOCUMENTS;
	}
	
	
	 public String gotoFileUpload() {
		 
		 System.out.println("enters into gotoFileUpload");
		 
		 String outcome = null;
		 
		// PT_IL_CLAIM_BEAN
		 if (PT_IL_CLAIM_BEAN != null && PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() != null
				 && !(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO().trim().isEmpty())) {

			 System.out.println("getCLAIM_POL_NO  :"+PT_IL_CLAIM_BEAN.getCLAIM_POL_NO());
			 
			 
			 FileUploadAction uploadAction = new FileUploadAction(
					 PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(), PELConstants.pelClaimsTrans,
					 "PILT006_APAC_PT_IL_CLAIM", this.getErrorMap());
			 outcome = uploadAction.gotoFileUpload();
			 
			 System.out.println("outcome             :"+outcome);
			 
		 } else {
			 
			 System.out.println("enters into gotoFileUpload else part");
			 
			 getErrorMap().clear();
			 String fileUploadErrorMessage = Messages.getString(
					 "messageProperties_fileUpload",
					 "fileupload$polreference$error$message");
			 getErrorMap().put("key", fileUploadErrorMessage);
			 getErrorMap().put("current", fileUploadErrorMessage);
		 }
		 return outcome;
	 }
	
	
	
	/*end*/
	
	public PT_IL_CLAIM_ACTION() {
		try {
			PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
			helper = new PT_IL_CLAIM_HELPER();
			IP_REP_INFO_BEAN = new IP_REP_INFO();
			instantiateAllComponent();
			POLICY_VALID_LIST = new ArrayList<SelectItem>();
			CLAIM_TYPE_LIST = new ArrayList<SelectItem>();
			setPOLICY_VALID_LIST(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT006_APAC", "PT_IL_CLAIM",
					"PT_IL_CLAIM.CLAIM_POL_VALID_YN", "YESNO"));
			setCLAIM_TYPE_LIST(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT006_APAC", "PT_IL_CLAIM",
					"PT_IL_CLAIM.CLAIM_TYPE", "CLMTYPE"));
			/*added  by raja 13-05-2017*/
			CLM_EXCL_YN_LIST=new ArrayList<SelectItem>();
			
			setCLM_EXCL_YN_LIST(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT006_APAC", "PT_IL_CLAIM",
					"PT_IL_CLAIM.CLAIM_POL_VALID_YN", "YESNO"));
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_CLOSE_FLAG_LABEL() {
		return COMP_UI_M_CLOSE_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLOSE_FLAG() {
		return COMP_UI_M_CLOSE_FLAG;
	}

	public void setCOMP_UI_M_CLOSE_FLAG_LABEL(
			HtmlOutputLabel COMP_UI_M_CLOSE_FLAG_LABEL) {
		this.COMP_UI_M_CLOSE_FLAG_LABEL = COMP_UI_M_CLOSE_FLAG_LABEL;
	}

	public void setCOMP_UI_M_CLOSE_FLAG(HtmlInputText COMP_UI_M_CLOSE_FLAG) {
		this.COMP_UI_M_CLOSE_FLAG = COMP_UI_M_CLOSE_FLAG;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_STATUS_LABEL() {
		return COMP_UI_M_CLAIM_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_STATUS() {
		return COMP_UI_M_CLAIM_STATUS;
	}

	public void setCOMP_UI_M_CLAIM_STATUS_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_STATUS_LABEL) {
		this.COMP_UI_M_CLAIM_STATUS_LABEL = COMP_UI_M_CLAIM_STATUS_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_STATUS(HtmlInputText COMP_UI_M_CLAIM_STATUS) {
		this.COMP_UI_M_CLAIM_STATUS = COMP_UI_M_CLAIM_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_ADDL_STATUS_LABEL() {
		return COMP_UI_M_CLAIM_ADDL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_ADDL_STATUS() {
		return COMP_UI_M_CLAIM_ADDL_STATUS;
	}

	public void setCOMP_UI_M_CLAIM_ADDL_STATUS_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_ADDL_STATUS_LABEL) {
		this.COMP_UI_M_CLAIM_ADDL_STATUS_LABEL = COMP_UI_M_CLAIM_ADDL_STATUS_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_ADDL_STATUS(
			HtmlInputText COMP_UI_M_CLAIM_ADDL_STATUS) {
		this.COMP_UI_M_CLAIM_ADDL_STATUS = COMP_UI_M_CLAIM_ADDL_STATUS;
	}

	public HtmlOutputLabel getCOMP_CLAIM_PCI_REF_NO_LABEL() {
		return COMP_CLAIM_PCI_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_PCI_REF_NO() {
		return COMP_CLAIM_PCI_REF_NO;
	}

	public void setCOMP_CLAIM_PCI_REF_NO_LABEL(
			HtmlOutputLabel COMP_CLAIM_PCI_REF_NO_LABEL) {
		this.COMP_CLAIM_PCI_REF_NO_LABEL = COMP_CLAIM_PCI_REF_NO_LABEL;
	}

	public void setCOMP_CLAIM_PCI_REF_NO(HtmlInputText COMP_CLAIM_PCI_REF_NO) {
		this.COMP_CLAIM_PCI_REF_NO = COMP_CLAIM_PCI_REF_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_POL_NO_LABEL() {
		return COMP_CLAIM_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_POL_NO() {
		return COMP_CLAIM_POL_NO;
	}

	public void setCOMP_CLAIM_POL_NO_LABEL(
			HtmlOutputLabel COMP_CLAIM_POL_NO_LABEL) {
		this.COMP_CLAIM_POL_NO_LABEL = COMP_CLAIM_POL_NO_LABEL;
	}

	public void setCOMP_CLAIM_POL_NO(HtmlInputText COMP_CLAIM_POL_NO) {
		this.COMP_CLAIM_POL_NO = COMP_CLAIM_POL_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_ASSR_CODE_LABEL() {
		return COMP_CLAIM_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_ASSR_CODE() {
		return COMP_CLAIM_ASSR_CODE;
	}

	public void setCOMP_CLAIM_ASSR_CODE_LABEL(
			HtmlOutputLabel COMP_CLAIM_ASSR_CODE_LABEL) {
		this.COMP_CLAIM_ASSR_CODE_LABEL = COMP_CLAIM_ASSR_CODE_LABEL;
	}

	public void setCOMP_CLAIM_ASSR_CODE(HtmlInputText COMP_CLAIM_ASSR_CODE) {
		this.COMP_CLAIM_ASSR_CODE = COMP_CLAIM_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_ASS_NAME_LABEL() {
		return COMP_UI_M_CLAIM_ASS_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_ASS_NAME() {
		return COMP_UI_M_CLAIM_ASS_NAME;
	}

	public void setCOMP_UI_M_CLAIM_ASS_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_ASS_NAME_LABEL) {
		this.COMP_UI_M_CLAIM_ASS_NAME_LABEL = COMP_UI_M_CLAIM_ASS_NAME_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_ASS_NAME(
			HtmlInputText COMP_UI_M_CLAIM_ASS_NAME) {
		this.COMP_UI_M_CLAIM_ASS_NAME = COMP_UI_M_CLAIM_ASS_NAME;
	}

	public HtmlOutputLabel getCOMP_CLAIM_CUST_CODE_LABEL() {
		return COMP_CLAIM_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_CUST_CODE() {
		return COMP_CLAIM_CUST_CODE;
	}

	public void setCOMP_CLAIM_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_CLAIM_CUST_CODE_LABEL) {
		this.COMP_CLAIM_CUST_CODE_LABEL = COMP_CLAIM_CUST_CODE_LABEL;
	}

	public void setCOMP_CLAIM_CUST_CODE(HtmlInputText COMP_CLAIM_CUST_CODE) {
		this.COMP_CLAIM_CUST_CODE = COMP_CLAIM_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_DESC_LABEL() {
		return COMP_UI_M_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_DESC() {
		return COMP_UI_M_CUST_DESC;
	}

	public void setCOMP_UI_M_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_DESC_LABEL) {
		this.COMP_UI_M_CUST_DESC_LABEL = COMP_UI_M_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_CUST_DESC(HtmlInputText COMP_UI_M_CUST_DESC) {
		this.COMP_UI_M_CUST_DESC = COMP_UI_M_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_CLAIM_ACCNT_PAY_CODE_LABEL() {
		return COMP_CLAIM_ACCNT_PAY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_ACCNT_PAY_CODE() {
		return COMP_CLAIM_ACCNT_PAY_CODE;
	}

	public void setCOMP_CLAIM_ACCNT_PAY_CODE_LABEL(
			HtmlOutputLabel COMP_CLAIM_ACCNT_PAY_CODE_LABEL) {
		this.COMP_CLAIM_ACCNT_PAY_CODE_LABEL = COMP_CLAIM_ACCNT_PAY_CODE_LABEL;
	}

	public void setCOMP_CLAIM_ACCNT_PAY_CODE(
			HtmlInputText COMP_CLAIM_ACCNT_PAY_CODE) {
		this.COMP_CLAIM_ACCNT_PAY_CODE = COMP_CLAIM_ACCNT_PAY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL() {
		return COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC() {
		return COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC;
	}

	public void setCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL) {
		this.COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL = COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC(
			HtmlInputText COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC) {
		this.COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC = COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CLAIM_TYPE_LABEL() {
		return COMP_CLAIM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLAIM_TYPE() {
		return COMP_CLAIM_TYPE;
	}

	public void setCOMP_CLAIM_TYPE_LABEL(HtmlOutputLabel COMP_CLAIM_TYPE_LABEL) {
		this.COMP_CLAIM_TYPE_LABEL = COMP_CLAIM_TYPE_LABEL;
	}

	public void setCOMP_CLAIM_TYPE(HtmlSelectOneMenu COMP_CLAIM_TYPE) {
		this.COMP_CLAIM_TYPE = COMP_CLAIM_TYPE;
	}

	public HtmlOutputLabel getCOMP_CLAIM_MED_CODE_LABEL() {
		return COMP_CLAIM_MED_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_MED_CODE() {
		return COMP_CLAIM_MED_CODE;
	}

	public void setCOMP_CLAIM_MED_CODE_LABEL(
			HtmlOutputLabel COMP_CLAIM_MED_CODE_LABEL) {
		this.COMP_CLAIM_MED_CODE_LABEL = COMP_CLAIM_MED_CODE_LABEL;
	}

	public void setCOMP_CLAIM_MED_CODE(HtmlInputText COMP_CLAIM_MED_CODE) {
		this.COMP_CLAIM_MED_CODE = COMP_CLAIM_MED_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_MED_CODE_NAME_LABEL() {
		return COMP_UI_M_CLAIM_MED_CODE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_MED_CODE_NAME() {
		return COMP_UI_M_CLAIM_MED_CODE_NAME;
	}

	public void setCOMP_UI_M_CLAIM_MED_CODE_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_MED_CODE_NAME_LABEL) {
		this.COMP_UI_M_CLAIM_MED_CODE_NAME_LABEL = COMP_UI_M_CLAIM_MED_CODE_NAME_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_MED_CODE_NAME(
			HtmlInputText COMP_UI_M_CLAIM_MED_CODE_NAME) {
		this.COMP_UI_M_CLAIM_MED_CODE_NAME = COMP_UI_M_CLAIM_MED_CODE_NAME;
	}

	public HtmlOutputLabel getCOMP_CLAIM_LOSS_DT_LABEL() {
		return COMP_CLAIM_LOSS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_LOSS_DT() {
		return COMP_CLAIM_LOSS_DT;
	}

	public void setCOMP_CLAIM_LOSS_DT_LABEL(
			HtmlOutputLabel COMP_CLAIM_LOSS_DT_LABEL) {
		this.COMP_CLAIM_LOSS_DT_LABEL = COMP_CLAIM_LOSS_DT_LABEL;
	}

	public void setCOMP_CLAIM_LOSS_DT(HtmlCalendar COMP_CLAIM_LOSS_DT) {
		this.COMP_CLAIM_LOSS_DT = COMP_CLAIM_LOSS_DT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_INTM_DT_LABEL() {
		return COMP_CLAIM_INTM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_INTM_DT() {
		return COMP_CLAIM_INTM_DT;
	}

	public void setCOMP_CLAIM_INTM_DT_LABEL(
			HtmlOutputLabel COMP_CLAIM_INTM_DT_LABEL) {
		this.COMP_CLAIM_INTM_DT_LABEL = COMP_CLAIM_INTM_DT_LABEL;
	}

	public void setCOMP_CLAIM_INTM_DT(HtmlCalendar COMP_CLAIM_INTM_DT) {
		this.COMP_CLAIM_INTM_DT = COMP_CLAIM_INTM_DT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_LC_RLA_AMOUNT_LABEL() {
		return COMP_CLAIM_LC_RLA_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_LC_RLA_AMOUNT() {
		return COMP_CLAIM_LC_RLA_AMOUNT;
	}

	public void setCOMP_CLAIM_LC_RLA_AMOUNT_LABEL(
			HtmlOutputLabel COMP_CLAIM_LC_RLA_AMOUNT_LABEL) {
		this.COMP_CLAIM_LC_RLA_AMOUNT_LABEL = COMP_CLAIM_LC_RLA_AMOUNT_LABEL;
	}

	public void setCOMP_CLAIM_LC_RLA_AMOUNT(
			HtmlInputText COMP_CLAIM_LC_RLA_AMOUNT) {
		this.COMP_CLAIM_LC_RLA_AMOUNT = COMP_CLAIM_LC_RLA_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_NO_LABEL() {
		return COMP_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_NO() {
		return COMP_CLAIM_NO;
	}

	public void setCOMP_CLAIM_NO_LABEL(HtmlOutputLabel COMP_CLAIM_NO_LABEL) {
		this.COMP_CLAIM_NO_LABEL = COMP_CLAIM_NO_LABEL;
	}

	public void setCOMP_CLAIM_NO(HtmlInputText COMP_CLAIM_NO) {
		this.COMP_CLAIM_NO = COMP_CLAIM_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_CURR_CODE_LABEL() {
		return COMP_CLAIM_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_CURR_CODE() {
		return COMP_CLAIM_CURR_CODE;
	}

	public void setCOMP_CLAIM_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_CLAIM_CURR_CODE_LABEL) {
		this.COMP_CLAIM_CURR_CODE_LABEL = COMP_CLAIM_CURR_CODE_LABEL;
	}

	public void setCOMP_CLAIM_CURR_CODE(HtmlInputText COMP_CLAIM_CURR_CODE) {
		this.COMP_CLAIM_CURR_CODE = COMP_CLAIM_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_CURR_CODE_DESC() {
		return COMP_UI_M_CLAIM_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL = COMP_UI_M_CLAIM_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_CURR_CODE_DESC(
			HtmlInputText COMP_UI_M_CLAIM_CURR_CODE_DESC) {
		this.COMP_UI_M_CLAIM_CURR_CODE_DESC = COMP_UI_M_CLAIM_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CLAIM_REF_NO_LABEL() {
		return COMP_CLAIM_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_REF_NO() {
		return COMP_CLAIM_REF_NO;
	}

	public void setCOMP_CLAIM_REF_NO_LABEL(
			HtmlOutputLabel COMP_CLAIM_REF_NO_LABEL) {
		this.COMP_CLAIM_REF_NO_LABEL = COMP_CLAIM_REF_NO_LABEL;
	}

	public void setCOMP_CLAIM_REF_NO(HtmlInputText COMP_CLAIM_REF_NO) {
		this.COMP_CLAIM_REF_NO = COMP_CLAIM_REF_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_CR_DT_LABEL() {
		return COMP_CLAIM_CR_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_CR_DT() {
		return COMP_CLAIM_CR_DT;
	}

	public void setCOMP_CLAIM_CR_DT_LABEL(HtmlOutputLabel COMP_CLAIM_CR_DT_LABEL) {
		this.COMP_CLAIM_CR_DT_LABEL = COMP_CLAIM_CR_DT_LABEL;
	}

	public void setCOMP_CLAIM_CR_DT(HtmlCalendar COMP_CLAIM_CR_DT) {
		this.COMP_CLAIM_CR_DT = COMP_CLAIM_CR_DT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_POL_VALID_YN_LABEL() {
		return COMP_CLAIM_POL_VALID_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLAIM_POL_VALID_YN() {
		return COMP_CLAIM_POL_VALID_YN;
	}

	public void setCOMP_CLAIM_POL_VALID_YN_LABEL(
			HtmlOutputLabel COMP_CLAIM_POL_VALID_YN_LABEL) {
		this.COMP_CLAIM_POL_VALID_YN_LABEL = COMP_CLAIM_POL_VALID_YN_LABEL;
	}

	public void setCOMP_CLAIM_POL_VALID_YN(
			HtmlSelectOneMenu COMP_CLAIM_POL_VALID_YN) {
		this.COMP_CLAIM_POL_VALID_YN = COMP_CLAIM_POL_VALID_YN;
	}

	public HtmlOutputLabel getCOMP_CLAIM_REMARKS_LABEL() {
		return COMP_CLAIM_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_REMARKS() {
		return COMP_CLAIM_REMARKS;
	}

	public void setCOMP_CLAIM_REMARKS_LABEL(
			HtmlOutputLabel COMP_CLAIM_REMARKS_LABEL) {
		this.COMP_CLAIM_REMARKS_LABEL = COMP_CLAIM_REMARKS_LABEL;
	}

	public void setCOMP_CLAIM_REMARKS(HtmlInputText COMP_CLAIM_REMARKS) {
		this.COMP_CLAIM_REMARKS = COMP_CLAIM_REMARKS;
	}

	public HtmlOutputLabel getCOMP_CLAIM_RESV_AMT_LABEL() {
		return COMP_CLAIM_RESV_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_RESV_AMT() {
		return COMP_CLAIM_RESV_AMT;
	}

	public void setCOMP_CLAIM_RESV_AMT_LABEL(
			HtmlOutputLabel COMP_CLAIM_RESV_AMT_LABEL) {
		this.COMP_CLAIM_RESV_AMT_LABEL = COMP_CLAIM_RESV_AMT_LABEL;
	}

	public void setCOMP_CLAIM_RESV_AMT(HtmlInputText COMP_CLAIM_RESV_AMT) {
		this.COMP_CLAIM_RESV_AMT = COMP_CLAIM_RESV_AMT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_UTIL_AMT_LABEL() {
		return COMP_CLAIM_UTIL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_UTIL_AMT() {
		return COMP_CLAIM_UTIL_AMT;
	}

	public void setCOMP_CLAIM_UTIL_AMT_LABEL(
			HtmlOutputLabel COMP_CLAIM_UTIL_AMT_LABEL) {
		this.COMP_CLAIM_UTIL_AMT_LABEL = COMP_CLAIM_UTIL_AMT_LABEL;
	}

	public void setCOMP_CLAIM_UTIL_AMT(HtmlInputText COMP_CLAIM_UTIL_AMT) {
		this.COMP_CLAIM_UTIL_AMT = COMP_CLAIM_UTIL_AMT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_REOPEN_DT_LABEL() {
		return COMP_CLAIM_REOPEN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_REOPEN_DT() {
		return COMP_CLAIM_REOPEN_DT;
	}

	public void setCOMP_CLAIM_REOPEN_DT_LABEL(
			HtmlOutputLabel COMP_CLAIM_REOPEN_DT_LABEL) {
		this.COMP_CLAIM_REOPEN_DT_LABEL = COMP_CLAIM_REOPEN_DT_LABEL;
	}

	public void setCOMP_CLAIM_REOPEN_DT(HtmlCalendar COMP_CLAIM_REOPEN_DT) {
		this.COMP_CLAIM_REOPEN_DT = COMP_CLAIM_REOPEN_DT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_REOPEN_REASON_LABEL() {
		return COMP_CLAIM_REOPEN_REASON_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_REOPEN_REASON() {
		return COMP_CLAIM_REOPEN_REASON;
	}

	public void setCOMP_CLAIM_REOPEN_REASON_LABEL(
			HtmlOutputLabel COMP_CLAIM_REOPEN_REASON_LABEL) {
		this.COMP_CLAIM_REOPEN_REASON_LABEL = COMP_CLAIM_REOPEN_REASON_LABEL;
	}

	public void setCOMP_CLAIM_REOPEN_REASON(
			HtmlInputText COMP_CLAIM_REOPEN_REASON) {
		this.COMP_CLAIM_REOPEN_REASON = COMP_CLAIM_REOPEN_REASON;
	}

	public HtmlOutputLabel getCOMP_CLAIM_LC_RISK_PREM_LABEL() {
		return COMP_CLAIM_LC_RISK_PREM_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_LC_RISK_PREM() {
		return COMP_CLAIM_LC_RISK_PREM;
	}

	public void setCOMP_CLAIM_LC_RISK_PREM_LABEL(
			HtmlOutputLabel COMP_CLAIM_LC_RISK_PREM_LABEL) {
		this.COMP_CLAIM_LC_RISK_PREM_LABEL = COMP_CLAIM_LC_RISK_PREM_LABEL;
	}

	public void setCOMP_CLAIM_LC_RISK_PREM(HtmlInputText COMP_CLAIM_LC_RISK_PREM) {
		this.COMP_CLAIM_LC_RISK_PREM = COMP_CLAIM_LC_RISK_PREM;
	}

	public HtmlOutputLabel getCOMP_CLAIM_LC_WAK_AMT_LABEL() {
		return COMP_CLAIM_LC_WAK_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_LC_WAK_AMT() {
		return COMP_CLAIM_LC_WAK_AMT;
	}

	public void setCOMP_CLAIM_LC_WAK_AMT_LABEL(
			HtmlOutputLabel COMP_CLAIM_LC_WAK_AMT_LABEL) {
		this.COMP_CLAIM_LC_WAK_AMT_LABEL = COMP_CLAIM_LC_WAK_AMT_LABEL;
	}

	public void setCOMP_CLAIM_LC_WAK_AMT(HtmlInputText COMP_CLAIM_LC_WAK_AMT) {
		this.COMP_CLAIM_LC_WAK_AMT = COMP_CLAIM_LC_WAK_AMT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_LC_SERV_FEE_LABEL() {
		return COMP_CLAIM_LC_SERV_FEE_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_LC_SERV_FEE() {
		return COMP_CLAIM_LC_SERV_FEE;
	}

	public void setCOMP_CLAIM_LC_SERV_FEE_LABEL(
			HtmlOutputLabel COMP_CLAIM_LC_SERV_FEE_LABEL) {
		this.COMP_CLAIM_LC_SERV_FEE_LABEL = COMP_CLAIM_LC_SERV_FEE_LABEL;
	}

	public void setCOMP_CLAIM_LC_SERV_FEE(HtmlInputText COMP_CLAIM_LC_SERV_FEE) {
		this.COMP_CLAIM_LC_SERV_FEE = COMP_CLAIM_LC_SERV_FEE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_ACCNT_PAY_CODE() {
		return COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_ACCNT_PAY_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE) {
		this.COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE = COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_CLAIM_MED_CODE() {
		return COMP_UI_M_LOV_BUT_CLAIM_MED_CODE;
	}

	public void setCOMP_UI_M_LOV_BUT_CLAIM_MED_CODE(
			HtmlCommandButton COMP_UI_M_LOV_BUT_CLAIM_MED_CODE) {
		this.COMP_UI_M_LOV_BUT_CLAIM_MED_CODE = COMP_UI_M_LOV_BUT_CLAIM_MED_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PRE_CLM_NO() {
		return COMP_UI_M_BUT_LOV_PRE_CLM_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_PRE_CLM_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PRE_CLM_NO) {
		this.COMP_UI_M_BUT_LOV_PRE_CLM_NO = COMP_UI_M_BUT_LOV_PRE_CLM_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PRE_CLAIM_DTLS() {
		return COMP_UI_M_BUT_PRE_CLAIM_DTLS;
	}

	public void setCOMP_UI_M_BUT_PRE_CLAIM_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PRE_CLAIM_DTLS) {
		this.COMP_UI_M_BUT_PRE_CLAIM_DTLS = COMP_UI_M_BUT_PRE_CLAIM_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FRZ() {
		return COMP_UI_M_BUT_FRZ;
	}

	public void setCOMP_UI_M_BUT_FRZ(HtmlCommandButton COMP_UI_M_BUT_FRZ) {
		this.COMP_UI_M_BUT_FRZ = COMP_UI_M_BUT_FRZ;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_ACC_FIR_DTLS() {
		return COMP_UI_M_BUTT_ACC_FIR_DTLS;
	}

	public void setCOMP_UI_M_BUTT_ACC_FIR_DTLS(
			HtmlCommandButton COMP_UI_M_BUTT_ACC_FIR_DTLS) {
		this.COMP_UI_M_BUTT_ACC_FIR_DTLS = COMP_UI_M_BUTT_ACC_FIR_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_EST_CURR_CODE() {
		return COMP_UI_M_LOV_BUT_EST_CURR_CODE;
	}

	public void setCOMP_UI_M_LOV_BUT_EST_CURR_CODE(
			HtmlCommandButton COMP_UI_M_LOV_BUT_EST_CURR_CODE) {
		this.COMP_UI_M_LOV_BUT_EST_CURR_CODE = COMP_UI_M_LOV_BUT_EST_CURR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDI_CLIAM_REMARK() {
		return COMP_UI_M_BUT_EDI_CLIAM_REMARK;
	}

	public void setCOMP_UI_M_BUT_EDI_CLIAM_REMARK(
			HtmlCommandButton COMP_UI_M_BUT_EDI_CLIAM_REMARK) {
		this.COMP_UI_M_BUT_EDI_CLIAM_REMARK = COMP_UI_M_BUT_EDI_CLIAM_REMARK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLOSE() {
		return COMP_UI_M_BUT_CLOSE;
	}

	public void setCOMP_UI_M_BUT_CLOSE(HtmlCommandButton COMP_UI_M_BUT_CLOSE) {
		this.COMP_UI_M_BUT_CLOSE = COMP_UI_M_BUT_CLOSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_STAUS_CHANGE() {
		return COMP_UI_M_BUT_STAUS_CHANGE;
	}

	public void setCOMP_UI_M_BUT_STAUS_CHANGE(
			HtmlCommandButton COMP_UI_M_BUT_STAUS_CHANGE) {
		this.COMP_UI_M_BUT_STAUS_CHANGE = COMP_UI_M_BUT_STAUS_CHANGE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SETTLEMENT() {
		return COMP_UI_M_BUT_SETTLEMENT;
	}

	public void setCOMP_UI_M_BUT_SETTLEMENT(
			HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT) {
		this.COMP_UI_M_BUT_SETTLEMENT = COMP_UI_M_BUT_SETTLEMENT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_SR_NO() {
		return COMP_UI_M_BUT_LOV_SR_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_SR_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_SR_NO) {
		this.COMP_UI_M_BUT_LOV_SR_NO = COMP_UI_M_BUT_LOV_SR_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO() {
		return COMP_UI_M_BUT_LOV_POL_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO) {
		this.COMP_UI_M_BUT_LOV_POL_NO = COMP_UI_M_BUT_LOV_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REOPEN() {
		return COMP_UI_M_BUT_REOPEN;
	}

	public void setCOMP_UI_M_BUT_REOPEN(HtmlCommandButton COMP_UI_M_BUT_REOPEN) {
		this.COMP_UI_M_BUT_REOPEN = COMP_UI_M_BUT_REOPEN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POLICY_DTLS() {
		return COMP_UI_M_BUT_POLICY_DTLS;
	}

	public void setCOMP_UI_M_BUT_POLICY_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_POLICY_DTLS) {
		this.COMP_UI_M_BUT_POLICY_DTLS = COMP_UI_M_BUT_POLICY_DTLS;
	}

	public PT_IL_CLAIM getPT_IL_CLAIM_BEAN() {
		return PT_IL_CLAIM_BEAN;
	}

	public void setPT_IL_CLAIM_BEAN(PT_IL_CLAIM PT_IL_CLAIM_BEAN) {
		this.PT_IL_CLAIM_BEAN = PT_IL_CLAIM_BEAN;
	}

	public PT_IL_CLAIM_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_CLAIM_HELPER helper) {
		this.helper = helper;
	}

	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_UI_M_CLOSE_FLAG.setDisabled(disabled);
		COMP_UI_M_CLAIM_STATUS.setDisabled(disabled);
		COMP_UI_M_CLAIM_ADDL_STATUS.setDisabled(disabled);
		COMP_CLAIM_PCI_REF_NO.setDisabled(disabled);
		COMP_CLAIM_POL_NO.setDisabled(disabled);
		
		// COMP_UI_M_CLAIM_ASS_NAME.setDisabled(disabled);
		
		/* 
		 * COMMENTED BY DHINESH ON 21-9-2017
		 * COMP_CLAIM_ASSR_CODE.setDisabled(disabled);
		 * COMP_CLAIM_CUST_CODE.setDisabled(disabled);
		 * 
		 * 
		 * */
		
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		COMP_CLAIM_ASSRD_REF_ID1.setDisabled(disabled);
		/*COMP_CLAIM_MEMB_CODE.setDisabled(disabled);*/
		/*END*/
		// COMP_CLAIM_ACCNT_PAY_CODE.setDisabled(disabled);
		 COMP_CLAIM_MED_CODE.setDisabled(disabled);

		// COMP_UI_M_CLAIM_MED_CODE_NAME.setDisabled(disabled);
		// COMP_CLAIM_LC_RLA_AMOUNT.setDisabled(disabled);
		COMP_CLAIM_NO.setDisabled(disabled);
		COMP_CLAIM_CURR_CODE.setDisabled(disabled);
		// COMP_UI_M_CLAIM_CURR_CODE_DESC.setDisabled(disabled);
		COMP_CLAIM_REF_NO.setDisabled(disabled);
		COMP_CLAIM_REMARKS.setDisabled(disabled);
		COMP_CLAIM_RESV_AMT.setDisabled(disabled);
		COMP_CLAIM_UTIL_AMT.setDisabled(disabled);
		// COMP_CLAIM_REOPEN_REASON.setDisabled(disabled);
		COMP_CLAIM_LC_RISK_PREM.setDisabled(disabled);
		COMP_CLAIM_LC_WAK_AMT.setDisabled(disabled);
		COMP_CLAIM_LC_SERV_FEE.setDisabled(disabled);

		
		
		/*added by raja on 07-06-2017 for hands on points*/
		COMP_CLAIM_DIS_CERT_DT.setDisabled(disabled);
		COMP_CLAIM_MED_EXP_DT.setDisabled(disabled);
		COMP_CLAIM_SICKNESS_DT.setDisabled(disabled);
		/*end*/
		
		
		// Disabling HtmlSelectOneMenu
		COMP_CLAIM_TYPE.setDisabled(disabled);
		COMP_CLAIM_POL_VALID_YN.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CLAIM_LOSS_DT.setDisabled(disabled);
		COMP_CLAIM_INTM_DT.setDisabled(disabled);
		COMP_CLAIM_CR_DT.setDisabled(disabled);
		// COMP_CLAIM_REOPEN_DT.setDisabled(disabled);
		COMP_CLAIM_DISABLITY.setDisabled(disabled);
		/*added by gopi for hand on feed back point,serial no 15 in zb on 01/02/17*/
		COMP_CLAIM_DISEASES_CODE.setDisabled(disabled);
		/*end*/
		
		/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017
		COMP_CLAIM_FEE_HOSPITALS.setDisabled(disabled);
		end*/
		
		/*aDDED BY SANARA NARAYANAN FOR DISABLING THE SAVE BUTTON IF THE CLAIME STATUS WAS CLO5 ON 08/03/2017*/
		if("CL05".equalsIgnoreCase(compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_ADDL_STATUS())) {
			COMP_SAVE_COMMAND_LINK.setDisabled(true);
			COMP_SAVE_BUTTON.setDisabled(true);
		}else{
			COMP_SAVE_COMMAND_LINK.setDisabled(false);
			COMP_SAVE_BUTTON.setDisabled(false);
		} //END 
		
/*Added by Janani on 07.04.2017 as per Girish suggestion for hands-on-feedback point Claims Entry- Setup */
		
		 COMP_CLAIM_ICD_DISEASES_DTL.setDisabled(disabled);

	 
		
		/*End*/
		 
		 
		 /*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
		 COMP_CLAIMANT_CODE.setDisabled(disabled);
		 //end
		 
		 /* Newly Added By Dhinesh on 11.8.2017 for ssp call id   ZBILQC-1730139 */
		 
		 /*Modified by saritha on 10-11-2017 for ssp call id ZBLIFE-1445721*/
		 if(disabled){
			 COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(disabled);
			 COMP_CLAIM_HOSP_ADDM_DT.setDisabled(disabled);
			 COMP_CLAIM_MEMB_CODE.setDisabled(disabled);
		 }else{
			 if("H".equalsIgnoreCase(getPlanType())&&("HB".equalsIgnoreCase(getClaimType()))){
				 if((compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG()==null)||
							(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG().equalsIgnoreCase("N"))){
						COMP_CLAIM_HOSP_ADDM_DT.setDisabled(false);
						COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(false);
					
					}else{
						COMP_CLAIM_HOSP_ADDM_DT.setDisabled(true);
						COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(true);
					}
			 }else{
				 COMP_CLAIM_HOSP_ADDM_DT.setDisabled(true);
				 COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(true);
			 }
			 
			 if("L".equalsIgnoreCase(getPlanType()) || "H".equalsIgnoreCase(getPlanType())){
				 COMP_CLAIM_MEMB_CODE.setDisabled(false);
			 }else{
				 COMP_CLAIM_MEMB_CODE.setDisabled(true);
			 }
		 }
		 /* END */
		 
		 COMP_CLAIM_INT_MOBILE.setDisabled(disabled);
		 COMP_CLAIM_INT_EMAIL.setDisabled(disabled);
		 /*End*/
		 /*Added by Sivarajan on 30/04/2021 for Allaince IL*/
		 COMP_CLAIM_BURIAL_PERMIT_NO.setDisabled(disabled);
		 COMP_CLAIM_DTH_CERTI_NO.setDisabled(disabled);
		 /*End*/
		 
	}

	
	
	/*Added by Janani for SSP call ZBILQC-1721205 on 06.03.2017*/
	
	String CLAIM_LOSS_DT_LABEL = null;
	
	
	public String getCLAIM_LOSS_DT_LABEL() {
		return CLAIM_LOSS_DT_LABEL;
	}

	public void setCLAIM_LOSS_DT_LABEL(String cLAIM_LOSS_DT_LABEL) {
		CLAIM_LOSS_DT_LABEL = cLAIM_LOSS_DT_LABEL;
	}

	
	/*end*/
	
	
	public void onLoad(PhaseEvent event) {
		
		try {
			if (isFormFlag()) {
				helper.preForm(compositeAction.getDUMMY_ACTION_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN(), compositeAction);
				helper.whenNewFormInstanceForm(this.PT_IL_CLAIM_BEAN);
				setFormFlag(false);
			}
					
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			String clearing_error=CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
			if(clearing_error!=null && clearing_error.equalsIgnoreCase("PILT002_APAC")){
				getErrorMap().clear();
				getWarningMap().clear();
				CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM"," ");
			}
			String Disability_type =PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP();
			//END
			
		
			
			if (isBlockFlag()) {
				/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
				getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
				/*End*/
				helper.preBlock();
				helper.whenNewBlockInstance(compositeAction);
				helper.preQuery(PT_IL_CLAIM_BEAN);

				if (PT_IL_CLAIM_BEAN.getROWID() != null) {
					helper.executeQuery(compositeAction
							.getPT_IL_CLAIM_ACTION_BEAN());
					helper.postQuery(compositeAction);
					helper.onPopulateDetails(compositeAction);
					//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
					System.out.println("CLAIM_TYPE =="+PT_IL_CLAIM_BEAN.getCLAIM_TYPE()+"::CLAIM_STATUS =="+PT_IL_CLAIM_BEAN.getCLAIM_STATUS());
					
					
					
					if(PT_IL_CLAIM_BEAN.getCLAIM_TYPE().equalsIgnoreCase("O") && PT_IL_CLAIM_BEAN.getCLAIM_STATUS().equalsIgnoreCase("N")){
						COMP_CLAIM_DIS_CERT_DT.setDisabled(false);
						COMP_CLAIM_MED_EXP_DT.setDisabled(false);
						COMP_CLAIM_SICKNESS_DT.setDisabled(false);
					}else{
						COMP_CLAIM_DIS_CERT_DT.setDisabled(true);
						COMP_CLAIM_MED_EXP_DT.setDisabled(true);
						COMP_CLAIM_SICKNESS_DT.setDisabled(true);
					}
					//END CLAIM TYPE = OTHERS		
					
					
					System.out.println("Disability_type ==============>>>>>"+Disability_type);
					
					if(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()!=null && PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS().equalsIgnoreCase("D05"))
					{
					  //compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS("D05:- Claim Declined due to exclusions");
					  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().disableWizardItem("toDoGroup");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().disableWizardItem("reminders");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
					  compositeAction.getWizard().disableWizardItem("claimCharge");
					 /* end*/
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(false);
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
					}
					
					/*Added by sankara narayanan for  Hands on feed back point num 16 in ZB on 04/03/2017*/
					else if("O".equalsIgnoreCase(Disability_type) && "D05".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS())){
						// compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS("D05:- Claim Declined due to exclusions");
						  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
						  compositeAction.getWizard().disableWizardItem("toDoGroup");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
						  compositeAction.getWizard().disableWizardItem("reminders");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
						  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
						  compositeAction.getWizard().disableWizardItem("claimCharge");
						 /* end*/
					}
					//end
					/*added by raja on 07-06-2017 for hands on points*/
					else if(!"O".equalsIgnoreCase(Disability_type)){
						 //compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS("D05:- Claim Declined due to exclusions");
						  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
						  compositeAction.getWizard().disableWizardItem("toDoGroup");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
						  compositeAction.getWizard().disableWizardItem("reminders");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
						  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
						  compositeAction.getWizard().disableWizardItem("claimCharge");
						 /* end*/
						  compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.disableAllComponent(true);
					}
					/*END*/
				
					else{
						
						/*uncommand by rja on 16-05-2017*/
						 compositeAction.getWizard().enableWizardItem("claimCoverDetails");
						  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
						  compositeAction.getWizard().enableWizardItem("toDoGroup");
						  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
						  compositeAction.getWizard().enableWizardItem("reminders");
						  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
						  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
						  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(true);
						  compositeAction.getWizard().enableWizardItem("claimCharge");
						  compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.disableAllComponent(false);
						  /*end*/
					}
				
				} else {
					helper.whenCreateRecord(PT_IL_CLAIM_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}
				//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions 
				
				/*changed the if condition by raja on 13-05-2017*/
				/*if(Disability_type!=null && !Disability_type.equalsIgnoreCase("O"))*/
				
				
				
				//END
				/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
				 Double pc_value = DISEASES_REMARK_PC_VALUE();
				 if(pc_value!=null && pc_value==1){
					 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISEASES_REMARKS().setDisabled(false);
				 }else{
					 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISEASES_REMARKS().setDisabled(true);
					 /*PT_IL_CLAIM_BEAN.setCLAIM_DISEASES_REMARKS(null);
					 COMP_CLAIM_DISEASES_REMARKS.resetValue();*/
				 }
				/*end*/
				helper.whenNewRecordInstance(compositeAction);
				setDisableFields();
				
				/*Added by saritha on 10-11-2017 for ssp call id ZBLIFE-1445721*/
				setPlanType(getPLAN_TYPE());
				setClaimType(PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
				
				if(("H".equalsIgnoreCase(getPlanType()))&&("HB".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())))
				{
					/*if((compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG()==null)||
							(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG().equalsIgnoreCase("N"))){
						COMP_CLAIM_HOSP_ADDM_DT.setDisabled(false);
						COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(false);
					
					}else{
						COMP_CLAIM_HOSP_ADDM_DT.setDisabled(true);
						COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(true);
					}			*/
					COMP_CLAIM_HOSP_DSCHG_DT.setRequired(true);
					COMP_CLAIM_HOSP_ADDM_DT.setRequired(true);	

				}
				else {

					/*COMP_CLAIM_HOSP_ADDM_DT.setDisabled(true);
					COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(true);*/
					COMP_CLAIM_HOSP_DSCHG_DT.setRequired(false);
					COMP_CLAIM_HOSP_ADDM_DT.setRequired(false);	
				}
				 /*End*/
				
				/*Added by saritha on 31-01-2017 for CLAIM_DISABILTY TYPE default O(Others)*/
				Connection connection = null;
				ResultSet resultset = null;
				connection = CommonUtils.getConnection();
				String PC_DESC=null;
				CRUDHandler handler1 = new CRUDHandler();
				
 				if(PT_IL_CLAIM_BEAN.getROWID()==null){
					PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP("O");
					String C1="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CLM_EXCL' AND PC_CODE=? ";
					resultset = handler1.executeSelectStatement(C1, connection,
							new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()});
					while(resultset.next()) {
						PC_DESC =resultset.getString("PC_DESC");
						System.out.println("Value Of PC_DESC ***********"+PC_DESC);
					}
					
					PT_IL_CLAIM_BEAN.setUI_M_CLAIM_EXCL_TYP_DESC(PC_DESC);
					PT_IL_CLAIM_BEAN.setCLAIM_TYPE_CPY("D");
					COMP_CLAIM_DISABLITY.resetValue();
					COMP_UI_M_CLAIM_EXCL_TYP.resetValue();
					COMP_CLAIM_TYPE.resetValue();

				}
				
				/*End*/
				/*Added by saranya for Handson session points Usability 17 on 02-02-17*/
				if("A".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())||"D".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())){
				
					 /*Commented & Added by Janani for SSP call ZBILQC-1721205 on 06.03.2017*/
					//COMP_CLAIM_LOSS_DT_LABEL.setValue("Date of Death");
					
					setCLAIM_LOSS_DT_LABEL("Date of Death");
					System.out.println("getCLAIM_LOSS_DT_LABEL           :"+getCLAIM_LOSS_DT_LABEL());
					
					
					/*End*/
				}
				else{
					
					 /*Commented & Added by Janani for SSP call ZBILQC-1721205 on 06.03.2017*/
					//COMP_CLAIM_LOSS_DT_LABEL.setValue("Date of Disability");
					
					setCLAIM_LOSS_DT_LABEL("Date of Disability");
					
					System.out.println("getCLAIM_LOSS_DT_LABEL           :"+getCLAIM_LOSS_DT_LABEL());
					
					/*End*/
					
					
					
				}
				/*End*/
				setBlockFlag(false);
				
				/*added by raja on 07-06-2017 for hands on points*/
				boolean flag= false;
				flag= accessValidation();
				if(flag==true)
				{
					
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.disableAllComponent(false);
					
					 compositeAction.getWizard().enableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().enableWizardItem("toDoGroup");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().enableWizardItem("reminders");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(true);
					  compositeAction.getWizard().enableWizardItem("claimCharge");
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(false);
				}
				
				if("D05".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()))
						{
					 compositeAction.getWizard().disableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().disableWizardItem("toDoGroup");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().disableWizardItem("reminders");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
					  compositeAction.getWizard().disableWizardItem("claimCharge");
					 /* end*/
						}
				/*end*/
				
				/*added by raja on 07-06-2017 for hands on points*/
				if (("Y".equalsIgnoreCase(compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getCLAIM_FRZ_FLAG()))
						|| ("Y".equalsIgnoreCase(compositeAction
								.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
								.getCLAIM_CLOSE_FLAG()))
						|| ("CL05".equalsIgnoreCase(compositeAction
								.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
								.getCLAIM_ADDL_STATUS()))	) {
					
					
					System.out.println("getCLAIM_FRZ_FLAG      :"+ compositeAction
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_FRZ_FLAG() );
					
					
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().disableall(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE()
							.setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_REOPEN().setDisabled(false);
					/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(true,"Y");
					//END
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_BONUS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(true);
					/*
					 * compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
					 * .disableAllComponent(true);
					 */
					compositeAction.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
							.disableAllComponent(true);
					compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
							.disableAllComponent(true);
				} else {
					
					/*added by raja on 07-06-2017 for hands on points*/
					if("O".equalsIgnoreCase(Disability_type))
					{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.disableAllComponent(false);
					}
					/*end*/
					
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_BONUS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_BONUS_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
							.disableAllComponent(false);
					/*
					 * compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
					 * .disableAllComponent(false);
					 */
					compositeAction.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
							.disableAllComponent(false);
					compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
							.disableAllComponent(false);		
					/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
					/*compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE()
							.setDisabled(false);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);*/
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
					
					
					String Disability_type1 =PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP();
					if(Disability_type1!=null){
					if(!Disability_type1.equalsIgnoreCase("O"))
					{
					 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_FRZ().setDisabled(true);
					 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
					 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
					/* commented by gopi for ssp call ZBILQC-1721875 on 04/03/17*/
					 //compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_POL_PRINT().setDisabled(true);
					/* end*/
					 }
					else{
						 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
						 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
						 
						
						 /*Added by Janani on 17.06.2017 for ZBILQC-1723136*/
						 						 
						/* COMP_CLAIM_CR_DT.setDisabled(true);
						 COMP_CLAIM_UTIL_AMT.setDisabled(true);
						 COMP_CLAIM_RESV_AMT.setDisabled(true);*/
						 /*End*/
						 
						 
					}
					}
					/*end*/
				//END
				}
				
			
				 /*Modified by Janani on 17.06.2017 for ZBILQC-1723136*/
				
				/*if(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS().equalsIgnoreCase("CL01"))
				{
					COMP_CLAIM_DISABLITY.setDisabled(false);
				}*/
				
				
				
				if(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS() != null && PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS().equalsIgnoreCase("CL01"))
				{
					COMP_CLAIM_DISABLITY.setDisabled(false);
				}
				
				/*End*/
				
				/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
				String busRuleQuery  = "SELECT BREM_ERR_FLAG FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? AND BREM_APPLY_LEVEL = ? AND "
						               + "BREM_GRP_ID = 'IL' AND BREM_APL_SCREEN ='C'";
				Object[] values  = new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(), "T" };
				ResultSet rs1 = new CRUDHandler().executeSelectStatement(busRuleQuery, CommonUtils.getConnection(), values);
				if (rs1.next()) {
					
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(false); 	 
					
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(true);
						
				}
				/*End*/
								
			}
			/*Added by saritha on 13-10-2017 for ssp call id ZBLIFE-1445721*/
			setPlanType(getPLAN_TYPE());
			setClaimType(PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
			/*End*/
			
			/* Newly Added By Dhinesh on 25-9-2017 for ssp call id : */
			if("S".equalsIgnoreCase(Disability_type))
			{
			double suicideValue = getSuicideValue();
			if(monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_START_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())<=suicideValue)
					{
				 compositeAction.getWizard().disableWizardItem("claimCoverDetails");
				  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
				  compositeAction.getWizard().disableWizardItem("toDoGroup");
				  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
				  compositeAction.getWizard().disableWizardItem("reminders");
				  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
				  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
				  compositeAction.getWizard().disableWizardItem("claimCharge");
					}
			}
			
			/*  End  */
			
			System.out.println("compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()"+compositeAction
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
							.getCLAIM_ADDL_STATUS());
			
			
			helper.fundDeatilsEnableOrDisable(compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), compositeAction,
					PT_IL_CLAIM_BEAN);
			compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
					.disableAllComponent(true);
			
		
			if ("Y".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_FRZ_FLAG())) {
				setFreezCaption("UnFreeze");
				
				System.out.println("getFreezCaption         :"+getFreezCaption());
				
			} else {
				setFreezCaption("Freeze");
				
				System.out.println("getFreezCaption if freeze flag is NO        :"+getFreezCaption());
			}
			if (PT_IL_CLAIM_BEAN.getCLAIM_NO() != null) {
				COMP_CLAIM_TYPE.setDisabled(true);
				COMP_CLAIM_NO.setDisabled(true);
			} else {
				COMP_CLAIM_TYPE.setDisabled(false);
				COMP_CLAIM_NO.setDisabled(false);
			}

			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
			if (callingForm != null
					&& callingForm.equalsIgnoreCase("PILT002_APAC")) {
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getUI_M_BUT_ADD().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getUI_M_BUT_DEL().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getUI_M_BUT_POST().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_BONUS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
						.disableAllComponent(true);
				compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
						.disableAllComponent(true);

				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE()
						.setDisabled(true);
				// compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_REOPEN().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getCOMP_UI_M_BUT_FRZ().setDisabled(true);
			}
			backButtonDisable();
			if ("N".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_STATUS())) {
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_CLAIM_STATUS(
								PT_IL_CLAIM_BEAN.getCLAIM_STATUS()
										+ " :- Not Approved ");
				/* modified by gopi for ssp call ZBILQC-1721875 on 04/03/17*/
				/*ADDED BY JANANI ON 24.5.2016*/
				/*getCOMP_POL_PRINT().setRendered(false);*/
				String dis_comp=compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CLAIM_ADDL_STATUS();
					if(dis_comp != null){
						String array[]=dis_comp.split(":");
						if(array[0]!=null){
							/*trim added by gopi for removing space on 23/06/17*/
							/*D06 added by gopi for ssp call ZBILQC-1721875 on 01/08/17*/
							if(array[0].trim().equalsIgnoreCase("D05")||array[0].trim().equalsIgnoreCase("D06")){
							getCOMP_POL_PRINT().setRendered(true);
						}
						else{
							getCOMP_POL_PRINT().setRendered(false);
						}
						}
					}
			/*end*/
					
			/*added by gopi for toi on 26/06/2018	*/	
			String Benef_cust_flag =getBeneficiary_as_customer();
			String  claim_addl_status=PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS();
			if(Benef_cust_flag!=null && "Y".equalsIgnoreCase(Benef_cust_flag)){
				if(claim_addl_status==null ||claim_addl_status.equalsIgnoreCase("")){
					getCOMP_POL_PRINT().setRendered(true);
				}else{
				getCOMP_POL_PRINT().setRendered(false);
				}
			}
			//added by gopi on 24/11/2022
			else{
				getCOMP_POL_PRINT().setRendered(true);
			}
			/*end*/
			
					
			} else if ("A".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_STATUS())) {
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_CLAIM_STATUS(
								PT_IL_CLAIM_BEAN.getCLAIM_STATUS()
										+ " :- Approved ");
				/*ADDED BY JANANI ON 24.5.2016*/
				//getCOMP_POL_PRINT().setRendered(true);
				//end
				/*added by gopi for toi on 26/06/2018	*/	
				String Benef_cust_flag =getBeneficiary_as_customer();
				String  claim_addl_status=PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS();
				if(Benef_cust_flag!=null && "Y".equalsIgnoreCase(Benef_cust_flag)){
					if(claim_addl_status!=null&&"C".equalsIgnoreCase(claim_addl_status)){
						getCOMP_POL_PRINT().setRendered(false);	
					}else{
						getCOMP_POL_PRINT().setRendered(true);	
					}
					
				}else{
					getCOMP_POL_PRINT().setRendered(true);
				}
				/*end*/
				
				
				
				
				
				
				
				
			}
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			String Status_code=compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().getCS_STATUS_CODE();
			if(Status_code!=null && Status_code.equalsIgnoreCase("CL05")){
				System.out.println("******************ENTER INTO M_CS_STATUS_CODE******");
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(true);
			
			
		if ("A".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_STATUS())) {
			
			 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			}
			
			
			}else{
					 //compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(false); 
					 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
					
				 }
			/*end*/
			
			/*Added by saritha on 31-01-2017 for Claim Number field disable*/
			COMP_CLAIM_NO.setDisabled(true);
			/*End*/		

			/*added by raja on 07-06-2017 for hands on points*/
			if(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()!=null)
			{
				
			System.out.println("getCLAIM_ADDL_STATUS                        "+PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS());
				
				
			 compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()+" :- "+addilStatusDesc());
			
			System.out.println("getUI_M_CLAIM_ADDL_STATUS in onload                 "+compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CLAIM_ADDL_STATUS());
			
			
			}
			 /*end*/
			
			
			
/*Added by Janani on 16.06.2017 for ZBILQC-1723136 */
			
			System.out.println("getCLAIM_TYPE in onload       "+PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
			
			COMP_CLAIM_MED_CODE = new HtmlInputText();
			
			
			/*if(PT_IL_CLAIM_BEAN.getCLAIM_TYPE().equalsIgnoreCase("A") || PT_IL_CLAIM_BEAN.getCLAIM_TYPE().equalsIgnoreCase("O"))
			{
			this.getCOMP_CLAIM_MED_CODE().setRequired(true);
			}
			else
			{
				System.out.println("getCLAIM_TYPE in else      "+PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
				
				this.getCOMP_CLAIM_MED_CODE().setRequired(false);
			}*/
			
			COMP_CLAIM_MED_CODE.resetValue();
			
			/*End*/
			
			 /*Added by Janani on 17.06.2017 for ZBILQC-1723136*/
			 
			 COMP_CLAIM_CR_DT.setDisabled(true);
			 COMP_CLAIM_UTIL_AMT.setDisabled(true);
			 COMP_CLAIM_RESV_AMT.setDisabled(true);
			 /*End*/
			
			 if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_COVER_DTLS().size()>0)
				{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().funeralCustValidation();
				}

			 /*added by gopi for toi on 09/07/18*/
				
				String MANT_AND_NONMANT=fetchInstanceData("PT_IL_CLAIM","PILT006_APAC","CLAIM_REMARKS",5);
				System.out.println("Tested Value-->"+fetchInstanceData("PT_IL_CLAIM","PILT006_APAC","CLAIM_REMARKS",5));
				if(MANT_AND_NONMANT!=null && "1".equalsIgnoreCase(MANT_AND_NONMANT)){
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REMARKS().setRequired(false);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REMARKS().resetValue();
				}else{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REMARKS().setRequired(true);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REMARKS().resetValue();
				}
				
				//end
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		}
	}

	/**
	 * 
	 */
	private void setDisableFields() {
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getCOMP_UI_M_CLAIM_ASS_NAME().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_CUST_DESC()
				.setDisabled(true);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getCOMP_UI_M_CLAIM_MED_CODE_NAME().setDisabled(true);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getCOMP_UI_M_CLAIM_CURR_CODE_DESC().setDisabled(true);
	}

	/**
	 * Validates the Ref No.
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorPCI_REF_NO(FacesContext context,
			UIComponent component, Object value) {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_PCI_REF_NO((String) value);
			System.out.println("Reference no"+value);
			helper.whenValidateClaimRefNo(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN(), value,compositeAction);
			
			// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			COMP_CLAIM_ASSRD_REF_ID1.resetValue();
			//COMP_CLAIM_POL_NO.resetValue();
			COMP_CLAIM_TYPE.resetValue();
			COMP_CLAIM_LOSS_DT.resetValue();
			COMP_CLAIM_INTM_DT.resetValue();
			//COMP_CLAIM_ASSR_CODE.resetValue();
			COMP_UI_M_CLAIM_ASS_NAME.resetValue();
			//COMP_CLAIM_CUST_CODE.resetValue();
			COMP_UI_M_CUST_DESC.resetValue();
			//end
			
			/*Added by saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
			COMP_CLAIMANT_CODE.resetValue();
			COMP_CLAIM_INT_MOBILE.resetValue();
			COMP_CLAIM_INT_EMAIL.resetValue();
			COMP_CLAIM_ASSR_CODE.resetValue();
			/*End*/
		
			System.out.println("Tempo Check["+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()+"]");
		} catch (Exception e) {
			e.printStackTrace();
			/*Added by Janani on 28.06.2017 for ZBILQC-1728704*/
			getErrorMap().put("current", e.getMessage());
			System.out.println("inside validatorPCI_REF_NO"+e.getMessage());
			/*End*/
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorCLAIM_ASSR_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			helper.whenValidateCLAIM_ASSR_VALID(this, getPT_IL_CLAIM_BEAN(),
					(String) value);
			PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE((String) value);
			System.out.println("Assured code::::::::::::::::::::"+PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017*/
	/*public void ValidateCLAIM_FEE_HOSPITALS(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_FEE_HOSPITALS((Double) value);
			COMP_CLAIM_FEE_HOSPITALS.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	/*end*/
	/*added by gopi for hand on feed back point,serial no 15 in zb on 01/02/17*/
	public void validatorCLAIM_DISEASES_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_DISEASES_CODE((String) value);
			 Double pc_value = DISEASES_REMARK_PC_VALUE();
			 if(pc_value!=null && pc_value==1){
				 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISEASES_REMARKS().setDisabled(false);
			 }else{
				 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISEASES_REMARKS().setDisabled(true);
				 PT_IL_CLAIM_BEAN.setCLAIM_DISEASES_REMARKS(null);
				 COMP_CLAIM_DISEASES_REMARKS.resetValue();
			 }
			COMP_CLAIM_DISEASES_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*end*/
	/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
	public ArrayList<LovBean> lovCLAIM_DISEASES_CODE(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DISEASES' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) AND ROWNUM < ?";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	/*end*/
	public void validateCLAIM_CUST_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			helper.whenValidateClaimCustCode(value, this.PT_IL_CLAIM_BEAN);
			PT_IL_CLAIM_BEAN.setCLAIM_CUST_CODE((String) value);
			COMP_UI_M_CUST_DESC.resetValue();
			COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*added by gopi for ssp call id ZBLIFE-1458500 on 12/12/17*/
	public void validatorGETTING_CLAIM_MEMB_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE((String) value);
		/*	String plantype=getPLAN_TYPE();
			if(plantype!=null && !plantype.equalsIgnoreCase("H"))
			{
			helper.whenValidateCLAIM_MEMB_CODE(this, getPT_IL_CLAIM_BEAN(),
					value);
			}*/
			COMP_CLAIM_MEMB_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	
	/*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
	public void validateCLAIMANT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			//helper.whenValidateClaimCustCode(value, this.PT_IL_CLAIM_BEAN);
			PT_IL_CLAIM_BEAN.setCLAIM_CLAIMANT_CODE((String) value);
			//COMP_UI_M_CUST_DESC.resetValue();
			//COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	
		
	}
	
	/*Added by saritha on 08-07-2017 for ssp call id ZBILQC-1730887*/
	/*Commentted by saritha on 06-10-2017 for ssp call id ZBLIFE-1445721*/
	/*public void actionListenerCLAIMANT_CODE(ActionEvent event) {
		getErrorMap().clear();
		getWarningMap().clear();
		try {	
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputvalue= (String)input.getSubmittedValue();
			helper.whenValidateClaimClaimantcode(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN(), inputvalue);
			PT_IL_CLAIM_BEAN.setCLAIM_CLAIMANT_CODE((String) inputvalue);

		} catch (Exception e) {
			e.printStackTrace();
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
			getErrorMap().put("current", e.getMessage());	
		
		}
		
	}*/
	
	/*End*/
	
	public ArrayList<LovBean> lovCLAIMANT_COD(Object object) {
		ArrayList<LovBean> suggestionList = null;
		
		String query1 ="SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER  WHERE CUST_CODE IN (SELECT CUST_CODE1 FROM (SELECT * FROM PM_CUSTOMER UNPIVOT INCLUDE NULLS(CUST_CODE1 FOR CONTACT IN (CUST_CONTACT, "
				+ "CUST_CONTACT2, CUST_CONTACT3, CUST_CLM_CONTACT, CUST_ACNT_CONTACT)) WHERE CUST_CLASS = 'INDL' AND CUST_CODE =? )) "
				+ "AND  (UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_CUST_CODE(),currentValue, currentValue,
							PELConstants.suggetionRecordSize });
			System.out.println("susggestionlist------->"+suggestionList.size());
			/*if(suggestionList.size()<=0){
			throw new Exception("Select the - Claim code from LOV, if not available, please attach in Customer Setup and proceed");	
			}*/
				
		} catch (Exception e) {
			e.printStackTrace();
			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CLAIMANT_CODE", e.getMessage());*/

		}

		return suggestionList;
	}
	
	//end
	
	
	
	
	
	public void validatorCLAIM_ACCNT_PAY_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			helper.whenValidateACCNT_PAY_CODE(value, this.PT_IL_CLAIM_BEAN);
			PT_IL_CLAIM_BEAN.setCLAIM_ACCNT_PAY_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCLAIM_ACCNT_PAY_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorPCI_POL_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			String polQuery="SELECT * FROM PT_IL_CLAIM";
			ResultSet rs1=null;
			rs1=new CRUDHandler().executeSelectStatement(polQuery, CommonUtils.getConnection());
			if(rs1.next()){
				System.out.println("inside RS1");
				CLAIM_ASSR_CODE_AJAX_SUPPORT_level.setDisabled(true);
			}
			String prev = CommonUtils.nvl(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(),
					"n");
			String currValue = (String) value;

			// if((!(prev.equalsIgnoreCase(currValue))) ||
			// (PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO()!=null
			// &&(!(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO().isEmpty())))){
			if ((!(prev.equalsIgnoreCase(currValue)))
					|| (PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO() != null && !(PT_IL_CLAIM_BEAN
							.getCLAIM_PCI_REF_NO().isEmpty()))) {
				// if(dbRowId == null && beanRowId == null){
				System.out.println("Member code["+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()+"]");
				helper.whenValidateClaimPolicyNo(this.PT_IL_CLAIM_BEAN,
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
							currValue, compositeAction);
				System.out.println("Member code8["+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()+"]");
				PT_IL_CLAIM_BEAN.setCLAIM_POL_NO((String) value);
				
				//Added by Dhinesh on 26/11/2016 for Claim No fetch with customer based
				CommonUtils.setGlobalVariable("GLOBAL.CLAIM_POL_NO", PT_IL_CLAIM_BEAN.getCLAIM_POL_NO());
				System.out.println("A");
				COMP_CLAIM_CUST_CODE.resetValue();
				COMP_CLAIM_CURR_CODE.resetValue();
				COMP_CLAIM_ACCNT_PAY_CODE.resetValue();
				System.out.println("ASSR_CODE === >"+PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE());
				System.out.println("Member code9["+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()+"]");
				COMP_CLAIM_ASSR_CODE.resetValue();
			}
			System.out.println("Member code10["+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE()+"]");
			//CLAIM_ASSR_CODE_AJAX_SUPPORT ============>>>>>ameen
			
			/*Added by R Raja on 24.01.2017 for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/
			String plan_type=null;
			getPOL_SYS_ID(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(), PT_IL_CLAIM_BEAN, compositeAction
				.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			plan_type=getPLAN_TYPE();
			
			
			/*added by raja on 04-05-2017 for Hospital cash plan*/
			if(plan_type!=null && plan_type.equalsIgnoreCase("H"))
			{
				PT_IL_CLAIM_BEAN.setCLAIM_TYPE("HB");
			}
			/*added by raja on 07-06-2017 for hands on points*/
			/*
			 * commented by Ameen on 18-12-2017 for ZBLIFE-1463542
			 * else
			{
				PT_IL_CLAIM_BEAN.setCLAIM_TYPE("D");
			}*/
			/*end*/
			/*end*/
			
			/*changed by raja on 07-03-2017 for funeral benefit fsd*/
			/*Commented by sankara narayanan for Hospital cash plan on 26/04/2017
			 * if("L".equalsIgnoreCase(plan_type)  && !(PT_IL_CLAIM_BEAN.getCLAIM_STATUS().equalsIgnoreCase("A")))*/
			/*Changed by sankara narayanan for Hospital cash plan on 26/04/2017*/
			if("L".equalsIgnoreCase(plan_type) || "H".equalsIgnoreCase(plan_type) && !(PT_IL_CLAIM_BEAN.getCLAIM_STATUS().equalsIgnoreCase("A")))
				//end
			{
				getCOMP_CLAIM_MEMB_CODE().setDisabled(false);
				 /*Commentted by saritha on 07-11-2017 for ssp call id ZBLIFE-1445721*/
				//getCOMP_CLAIM_MEMB_CODE().setRequired(true);
				/*End*/
				/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
				
				/*Modified by saritha on 13-10-2017 for ssp call id ZBLIFE-1445721*/
				if("H".equalsIgnoreCase(plan_type)&&("HB".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())))
				{
				COMP_CLAIM_HOSP_ADDM_DT.setDisabled(false);
				COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(false);
				COMP_CLAIM_HOSP_ADDM_DT.setRequired(true);
				COMP_CLAIM_HOSP_DSCHG_DT.setRequired(true);
				
				}
				if("H".equalsIgnoreCase(plan_type)){
				/*added by raja on 04-05-2017 for Hospital cash plan*/
				COMP_CLAIM_DISEASES_CODE.setRequired(true);
				COMP_CLAIM_ICD_DISEASES_DTL.setRequired(true);
				/*end*/
				}
				
			/*End*/
				
				
			}
			else
			{
				getCOMP_CLAIM_MEMB_CODE().setDisabled(true);
				/*Commentted by saritha on 07-11-2017 for ssp call id ZBLIFE-1445721*/
				//getCOMP_CLAIM_MEMB_CODE().setRequired(false);
				/*End*/
				
				/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
				
				COMP_CLAIM_HOSP_ADDM_DT.setDisabled(true);
				COMP_CLAIM_HOSP_DSCHG_DT.setDisabled(true);
				COMP_CLAIM_HOSP_ADDM_DT.setRequired(false);
				COMP_CLAIM_HOSP_DSCHG_DT.setRequired(false);
				/*end*/
				
				/*added by raja on 04-05-2017 for Hospital cash plan*/
				COMP_CLAIM_DISEASES_CODE.setRequired(false);
				COMP_CLAIM_ICD_DISEASES_DTL.setRequired(false);
				/*end*/
			}
			
			/*end*/
			//COMP_CLAIM_MED_CODE.resetValue();
		/*end*/
	   
			
			/*added by raja on 04-05-2017 for Hospital cash plan*/
			COMP_CLAIM_TYPE.resetValue();
		   /*end*/
			System.out.println("vvallllllll222222222222");
			
			/*COMP_CLAIM_MEMB_CODE.resetValue();
			COMP_CLAIM_MEMB_CODE_DESC.resetValue();	*/
			String pol_flag=ValidatePolNo();

			if ("P".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Paidup Policy!");
			}else if ("S".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Surrender Policy!");
			}else if ("M".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Matured Policy!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			getErrorMap().put("current", e.getMessage());
			System.out.println("inside cliam catch"+e.getMessage());
			/*End*/
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}
	}

	public void validateCLAIM_ASSR_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCLAIM_CUST_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorCLAIM_MED_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			helper.whenValidateMED_CODE(value);
			PT_IL_CLAIM_BEAN.setCLAIM_MED_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean> PCI_POL_NO_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_POL_NO", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}

		return suggestionList;
	}

	/*Modified by Saranya for Hands on points  no 11 claims on 04-02-2017*/		
	/* Added by lakshman to restrict unwanted policy Nos in LOV */
	public ArrayList<PT_IL_CLAIM> lovClaim_Pol_No(Object event) {
		String code = (String) event;
		ArrayList<PT_IL_CLAIM> polList = null;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		
		System.out.println("enters into lovClaim_Pol_No");
		
		
		if ("*".equals(code)) {
			
			
			/*Modified by Janani on 16.06.2017 for ZBILQC-1725271 as per Kuzhandaivel suggestion*/
			
			object = new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),
					PELConstants.suggetionRecordSize };
			
			/*End*/
			
			/*query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) FROM PT_IL_POLICY WHERE POL_APPRV_STATUS = 'A' "
	+ " AND POL_STATUS = 'A'  AND POL_DS_TYPE = '2' AND ROWNUM < ? ORDER BY 1";*/
			/*query = "select POL_NO from PT_IL_POLICY where POL_DS_TYPE ='2' AND (POL_ASSRD_REF_ID1=NVL(?,'X') "
					+ "OR POL_ASSRD_REF_ID2=NVL(?,'X'))  AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R','S01','D01','S02','D03')"
					+ "AND ROWNUM < ? ";*/
			/*query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
					+ "OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D') "
					+ "AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
					+ "AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))"
					+ "AND ROWNUM < ? ";*/
			/*End*/
			
			
			
			/*Modified by Janani on 16.06.2017 for ZBILQC-1725271 as per Kuzhandaivel suggestion*/
			
			
			/*query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
			+ "OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D') "
			+ "AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
			+ "AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))"
			+ "AND ROWNUM < ? ";*/
			
			/*Modified by Janani on 01.09.2017 for ZBILQC-1733746*/
			
			/*query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
					+ "	AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L')) UNION "
					+ " select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X')"
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND (( EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D')"
					+ " AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))	AND ROWNUM < ? ";*/
			
			
			
			query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND NVL(POL_APPRV_STATUS, 'X') = 'A' AND POL_STATUS IN ('A', 'E','P')"
					+ " AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
					+ "	AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L')) UNION "
					+ " select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X')"
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND NVL(POL_APPRV_STATUS, 'X') <> 'A' AND NVL(POL_STATUS, 'X') = 'E'"
					+ " AND NVL(POL_APPRV_STATUS, 'X') = 'N' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND (( EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D')"
					+ " AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))	AND ROWNUM < ? ";
			
			/*End of ZBILQC-1733746*/

/*End*/
			
			
			
			
		} else {
		
			
			/*Modified by Janani on 16.06.2017 for ZBILQC-1725271 as per Kuzhandaivel suggestion*/
			
			/*object = new Object[] { code+ "%",PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),
					PELConstants.suggetionRecordSize };*/
			object = new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),
					PELConstants.suggetionRecordSize };
			
			/*End*/
			
			/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
			 * 
			 * query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) FROM PT_IL_POLICY WHERE POL_APPRV_STATUS = 'A' "
	+ " AND POL_STATUS = 'A' AND (POL_NO LIKE ?) AND POL_DS_TYPE = '2' AND ROWNUM < ? ORDER BY 1";*/
			/*query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) FROM PT_IL_POLICY WHERE POL_APPRV_STATUS = 'A' "
	+ " AND POL_STATUS = 'A' AND (UPPER(POL_NO) LIKE UPPER(?)) AND POL_DS_TYPE = '2' AND ROWNUM < ? ORDER BY 1";*/
			/*query = "select POL_NO from PT_IL_POLICY where POL_DS_TYPE ='2'AND (UPPER(POL_NO) LIKE UPPER(?)) AND (POL_ASSRD_REF_ID1=NVL(?,'X') "
					+ "OR POL_ASSRD_REF_ID2=NVL(?,'X'))  AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R','S01','D01','S02','D03')"
					+ "AND ROWNUM < ? ";*/

			/*
			 * Modified by Janani on 16.06.2017 for ZBILQC-1725271 as per Kuzhandaivel suggestion
			 * 
			 * 
			 * 
			 * query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE ='2' AND POL_PLAN_CODE = PLAN_CODE AND  (UPPER(POL_NO) LIKE UPPER(?)) AND (POL_ASSRD_REF_ID1=NVL(?,'X') "
							+ "OR POL_ASSRD_REF_ID2=NVL(?,'X'))  AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R','S01','D01','S02','D03','D')"
							+ "AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
							+ "AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))"
							+ "AND ROWNUM < ? ";*/
			
			/*Modified by Janani on 01.09.2017 for ZBILQC-1733746*/
			
			
			/*query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
					+ "	AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L')) UNION "
					+ " select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X')"
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND (( EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D')"
					+ " AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))	AND ROWNUM < ? ";*/
			
			
			query = "select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X') "
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND NVL(POL_APPRV_STATUS, 'X') = 'A' AND POL_STATUS IN ('A', 'E','P')"
					+ " AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND ((NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D') "
					+ "	AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L')) UNION "
					+ " select POL_NO from PT_IL_POLICY,PM_IL_PLAN where POL_DS_TYPE = '2' AND POL_PLAN_CODE = PLAN_CODE AND (POL_ASSRD_REF_ID1 = NVL(?, 'X')"
					+ " OR POL_ASSRD_REF_ID2 = NVL(?, 'X')) AND NVL(POL_APPRV_STATUS, 'X') <> 'A' AND NVL(POL_STATUS, 'X') = 'E'"
					+ " AND NVL(POL_APPRV_STATUS, 'X') = 'N' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03', 'D')"
					+ " AND (( EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = POL_SYS_ID AND CLAIM_TYPE = 'D')"
					+ " AND PLAN_TYPE <> 'L') OR (PLAN_TYPE = 'L'))	AND ROWNUM < ? ";
			
			
			/*End of ZBILQC-1733746*/
			
			/*End*/
			
			
			/*End*/
		}
		
		PT_IL_CLAIM classBean = null;
		try {
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			ResultSet resultSet = null;
			resultSet = handler.executeSelectStatement(query, connection,object);
			polList = new ArrayList<PT_IL_CLAIM>();
			while (resultSet.next()) {
				classBean = new PT_IL_CLAIM();
				classBean.setCLAIM_POL_NO(resultSet.getString("POL_NO"));
				
				System.out.println("CLAIM_POL_NO            "+classBean.getCLAIM_POL_NO());
				
				polList.add(classBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO", e.getMessage());
		}
		return polList;
	}
	/*End*/

	
	/* Added by lakshman to restrict unwanted policy Nos in LOV */

	public void setPCI_POL_NO_SUGGESTION_VALUE() {
		try {
			String CLAIM_POL_NO = (String) this.getCOMP_CLAIM_POL_NO()
					.getSubmittedValue();
			this.PT_IL_CLAIM_BEAN.setCLAIM_POL_NO(CLAIM_POL_NO);
			getPOL_SYS_ID(CLAIM_POL_NO, PT_IL_CLAIM_BEAN, compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}

	/**
	 * 
	 * @param number
	 * @param claimAction
	 * @throws DBException
	 */
	public void getPOL_SYS_ID(String number, PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			DUMMY DUMMY_BEAN) throws Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		Long POL_SYS_ID = null;
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { number });
			while (rst.next()) {
				POL_SYS_ID = rst.getLong(1);
			}
			PT_IL_CLAIM_BEAN.setCLAIM_POL_SYS_ID(POL_SYS_ID);
			DUMMY_BEAN.setM_POL_SYS_ID(POL_SYS_ID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<LovBean> lovCLAIM_ASSR_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		Long pol_sys_id = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		if (null != pol_sys_id) {

			if ("*".equals(code)) {
				object = new Object[] { pol_sys_id,
						PELConstants.suggetionRecordSize };
				query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS "
						+ "WHERE  POAD_POL_SYS_ID = ?  AND "
						+ "ROWNUM < ? ORDER BY 1";
			} else {
				object = new Object[] { pol_sys_id, code + "%",
						PELConstants.suggetionRecordSize };
				/*
				 * 
				 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
				 * 
				 * query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS  "
						+ "WHERE  POAD_POL_SYS_ID = ?  AND "
						+ "(POAD_ASSR_CODE  LIKE ? ) "
						+ "AND ROWNUM < ? ORDER BY 1";*/
				
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
				query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS  "
						+ "WHERE  POAD_POL_SYS_ID = ?  AND "
						+ "(UPPER(POAD_ASSR_CODE)  LIKE UPPER(?) ) "
						+ "AND ROWNUM < ? ORDER BY 1";
				/*end*/
			}
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POAD_ASSR_CODE", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	/*
	 * public List<LovBean> CLAIM_ASSR_CODE_SUGGESTION_LIST(Object event){
	 * ListItemUtil itemUtil = new ListItemUtil(); ArrayList<LovBean>
	 * suggestionList = new ArrayList<LovBean>(); try { suggestionList =
	 * itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM", "CLAIM_ASSR_CODE",
	 * compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_SYS_ID(),
	 * null, null, null, null, (String) event); } catch (Exception e) {
	 * e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("POL_NO_SUGGESTION", e.getMessage()); }
	 * return suggestionList; }
	 */
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> ACCNT_PAY_CODE_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_ACCNT_PAY_CODE", "CUSTOMER", compositeAction
							.getCTRL_ACTION_BEAN().getCTRL_BEAN()
							.getUI_M_DIVN_CODE(), "CUSTOMER", null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> CLAIM_MED_CODE_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_MED_CODE", "005", null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorCLAIM_CURR_CODE(FacesContext context,
			UIComponent component, Object value) {

		try {
			PT_IL_CLAIM_BEAN.setCLAIM_CURR_CODE((String) value);
			helper.claimCurrCodeWhenValidateItem(value, this.compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			helper.whenValidateClaimCurrCode(value, compositeAction);
			COMP_UI_M_CLAIM_CURR_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void validateCLAIM_TYPE(ActionEvent event) {
		PT_IL_CLAIM_HELPER helper = new PT_IL_CLAIM_HELPER();
		try {
			
			helper.validateCLAIM_TYPE_WHEN_CHANGED(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN());
			UIInput input = (UIInput) event.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> CLAIM_CURR_CODE_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_CURR_CODE", PT_IL_CLAIM_BEAN.getCLAIM_CUST_CODE(),
					null, null, null, null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	public void validateCLAIM_CURR_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		input.validate(FacesContext.getCurrentInstance());
	}

	/**
	 * 
	 */
	public void setCLAIM_CURR_CODE_SUGGESTION_VALUE() {
		String CLAIM_CURR_CODE = (String) this.getCOMP_CLAIM_CURR_CODE()
				.getSubmittedValue();
		this.PT_IL_CLAIM_BEAN.setCLAIM_CURR_CODE(CLAIM_CURR_CODE);
		if (suggestionLOV != null) {
			Iterator<LovBean> claimIterator = suggestionLOV.iterator();
			while (claimIterator.hasNext()) {
				LovBean claimBean = claimIterator.next();
				if (CLAIM_CURR_CODE != null
						&& CLAIM_CURR_CODE.equals(claimBean.getCode())) {
					this.getCOMP_UI_M_CLAIM_CURR_CODE_DESC().setSubmittedValue(
							claimBean.getName());
					this.getPT_IL_CLAIM_BEAN().setUI_M_CLAIM_CURR_CODE_DESC(
							claimBean.getName());
					return;
				}
			}
		}
	}

	/**
	 * 
	 */
	public void setCLAIM_MED_CODE_SUGGESTION_VALUE() {
		String CLAIM_MED_CODE = (String) this.getCOMP_CLAIM_MED_CODE()
				.getSubmittedValue();
		this.getPT_IL_CLAIM_BEAN().setCLAIM_MED_CODE(CLAIM_MED_CODE);
		if (suggestionLOV != null) {
			Iterator<LovBean> claimIterator = suggestionLOV.iterator();
			while (claimIterator.hasNext()) {
				LovBean lovBean = claimIterator.next();
				if (CLAIM_MED_CODE != null
						&& CLAIM_MED_CODE.equals(lovBean.getCode())) {
					this.getCOMP_UI_M_CLAIM_MED_CODE_NAME().setSubmittedValue(
							lovBean.getName());
					this.getPT_IL_CLAIM_BEAN().setUI_M_CLAIM_MED_CODE_NAME(
							lovBean.getName());
					return;
				}
			}
		}
	}

	/**
	 * 
	 */
	public void setACCNT_PAY_CODE_SUGGESTION_VALUE() {
		String ACCNT_PAY_CODE = (String) this.getCOMP_CLAIM_ACCNT_PAY_CODE()
				.getSubmittedValue();
		this.getPT_IL_CLAIM_BEAN().setCLAIM_ACCNT_PAY_CODE(ACCNT_PAY_CODE);
		if (suggestionLOV != null) {
			Iterator<LovBean> claimIterator = suggestionLOV.iterator();
			while (claimIterator.hasNext()) {
				LovBean lovBean = claimIterator.next();
				if (ACCNT_PAY_CODE != null
						&& ACCNT_PAY_CODE.equals(lovBean.getCode())) {
					this.getCOMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC()
							.setSubmittedValue(lovBean.getName());
					this.getPT_IL_CLAIM_BEAN()
							.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(
									lovBean.getName());
					return;
				}
			}
		}
	}

	/**
	 * 
	 */
	public void setCLAIM_ASSR_CODE_SUGGESTION_VALUE() {
		String CLAIM_ASSR_CODE = (String) this.getCOMP_CLAIM_ASSR_CODE()
				.getSubmittedValue();
		this.PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE(CLAIM_ASSR_CODE);
		if (suggestionList != null) {
			Iterator<PT_IL_CLAIM> claimIterator = suggestionList.iterator();
			while (claimIterator.hasNext()) {
				PT_IL_CLAIM claimBean = claimIterator.next();
				if (CLAIM_ASSR_CODE != null
						&& CLAIM_ASSR_CODE.equals(claimBean
								.getCLAIM_ASSR_CODE())) {
					this.getCOMP_UI_M_CLAIM_ASS_NAME().setSubmittedValue(
							claimBean.getUI_M_CLAIM_ASS_NAME());
					this.PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ASS_NAME(claimBean
							.getUI_M_CLAIM_ASS_NAME());
					return;
				}
			}
		}
	}

	/**
	 * 
	 */
	public void setCUST_CODE_SUGGESTION_VALUE() {
		String CUST_CODE = (String) this.getCOMP_CLAIM_CUST_CODE()
				.getSubmittedValue();
		this.getPT_IL_CLAIM_BEAN().setCLAIM_CUST_CODE(CUST_CODE);
		if (suggestionList != null) {
			Iterator<PT_IL_CLAIM> claimIterator = suggestionList.iterator();
			while (claimIterator.hasNext()) {
				PT_IL_CLAIM claimBean = claimIterator.next();
				if (claimBean.getCLAIM_CUST_CODE().equals(CUST_CODE)) {
					this.getCOMP_UI_M_CUST_DESC().setSubmittedValue(
							claimBean.getUI_M_CUST_DESC());
					this.getPT_IL_CLAIM_BEAN().setUI_M_CUST_DESC(
							claimBean.getUI_M_CUST_DESC());
					return;
				}
			}
		}
	}

	/**
	 * 
	 */
	public void setPCI_REF_NO_SUGGESTION_VALUE() {
		String PCI_REF_NO = (String) this.getCOMP_CLAIM_PCI_REF_NO()
				.getSubmittedValue();
		this.PT_IL_CLAIM_BEAN.setCLAIM_PCI_REF_NO(PCI_REF_NO);
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<PT_IL_CLAIM> CUST_CODE_SUGGESTION_LIST(Object event) {
		PT_IL_CLAIM_HELPER helper = new PT_IL_CLAIM_HELPER();
		suggestionList = helper.lovCustCode(FacesContext.getCurrentInstance(),
				(String) event);
		return suggestionList;
	}

	/**
	 * @return the searchMode
	 */
	public boolean isSearchMode() {
		return searchMode;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	
	/*Modified by saritha on 11-08-2017 for ssp call id ZBILQC-1733746*/
	public List<LovBean> PCI_REF_NO_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		try {
			/*suggestionList = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_PCI_REF_NO", null, null, null, null, null,
					(String) event);*/
			
			suggestionList = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_PCI_REF_NO",PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1(),null, null, null, null,
					(String) event);
			System.out.println(suggestionList.size());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionList;
	}
	/*End*/
	
	public void validatorCLAIM_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {
			
			/*Modified by Ram on 26/11/2016 for Others Claim Type
			 * 
			 * PT_IL_CLAIM_BEAN.setCLAIM_TYPE((String) value);*/
			
			PT_IL_CLAIM_BEAN.setCLAIM_TYPE_CPY((String) value);
			System.out.println("CLAIM_TYPE_CPY  :"+PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY());
			/*Added by saranya for Handson session points Usability 17 on 02-02-17*/
			if("A".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY())||"D".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY())){
				COMP_CLAIM_LOSS_DT_LABEL.setValue("Date of Death");
				
			}
			else{
				COMP_CLAIM_LOSS_DT_LABEL.setValue("Date of Disability");
				
			}
			/*End*/
			
			/*End*/
				
			/*Added by Janani on 16.06.2017 for ZBILQC-1723136 */
			
			System.out.println("getCLAIM_TYPE_CPY       "+PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY());
			
			/*if(PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY().equalsIgnoreCase("A") || PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY().equalsIgnoreCase("O"))
			{
				getCOMP_CLAIM_MED_CODE().setRequired(true);
			}
			else
			{
				System.out.println("getCLAIM_TYPE_CPY in else      "+PT_IL_CLAIM_BEAN.getCLAIM_TYPE_CPY());
				
				getCOMP_CLAIM_MED_CODE().setRequired(false);
			}*/
			
			COMP_CLAIM_MED_CODE.resetValue();
			/*End*/
			
			helper.whenValidateClaimType(value, compositeAction
					.getDUMMY_ACTION_BEAN(), compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN());
			PT_IL_CLAIM_BEAN.setCLAIM_TYPE((String) value);
			
			//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
			System.out.println("validator claimtype =="+PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
			if("O".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())){
				COMP_CLAIM_DIS_CERT_DT.setDisabled(false);
				COMP_CLAIM_MED_EXP_DT.setDisabled(false);
				COMP_CLAIM_SICKNESS_DT.setDisabled(false);
				

			}else{
				COMP_CLAIM_DIS_CERT_DT.setDisabled(true);
				COMP_CLAIM_MED_EXP_DT.setDisabled(true);
				COMP_CLAIM_SICKNESS_DT.setDisabled(true);
				
			}
			//END CLAIM TYPE = OTHERS
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * @param searchMode
	 *            the searchMode to set
	 */
	public void setSearchMode(boolean searchMode) {
		this.searchMode = searchMode;
	}


	
	public void validatorClaimLossDate(FacesContext context,
			UIComponent component, Object value) {
		try {
			
			System.out.println("enters into validatorClaimLossDate ");
			
						helper.whenValidateClaimLossDate((Date) value, compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
						helper.chkRiFacClose((Date) value, PT_IL_CLAIM_BEAN
					.getCLAIM_POL_SYS_ID());
			PT_IL_CLAIM_BEAN.setCLAIM_LOSS_DT((Date) value);
			System.out.println("getCLAIM_LOSS_DT  in  validatorClaimLossDate         "+PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	public void validateCLAIM_LOSS_DATE(ActionEvent event) {
		/*CommonUtils.clearMaps(this);*/
		getErrorMap().clear();
		getWarningMap().clear();
				
		try {	
			
			/*Added by Janani for SSP call ZBILQC-1721205 on 01.08.2017*/
			
			UIInput input = (UIInput) event.getComponent().getParent();
			//ErrorHelpUtil.validate(input, getErrorMap());
			String inputdate= (String)input.getSubmittedValue();
			String inputName = input.getId();
			if (inputdate != null) {
				FacesContext fc = FacesContext.getCurrentInstance();
				String fieldName = ErrorHelpUtil.findFieldName(fc, input);
				input.validate(fc); // iterates over input's validators
				if (!input.isValid()) {
					Iterator it = fc.getMessages(input.getClientId(fc));
					if (it.hasNext()) {
						FacesMessage facesMessage = (FacesMessage) it.next();
						String message = " " + fieldName + ":" + facesMessage.getSummary();
						throw new Exception(message);

					}
				} else {
					getErrorMap().clear();

				}

			}
			/*End*/
			
			 /*Added by Janani for SSP call ZBILQC-1721205 on 06.03.2017*/
			
			
			System.out.println("getCLAIM_LOSS_DT_LABEL()               "+getCLAIM_LOSS_DT_LABEL());
			
			System.out.println("inputdate         "+inputdate);
			if(inputdate != null && inputdate.length() == 0)
			{
				System.out.println("Value is Required");
				System.out.println("CLAIM_TYPE       "+PT_IL_CLAIM_BEAN.getCLAIM_TYPE());
				if(PT_IL_CLAIM_BEAN.getCLAIM_TYPE() != null)
				{
					
					if("A".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())||"D".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE()))
					
					//if(PT_IL_CLAIM_BEAN.getCLAIM_TYPE().equals("D"))
					{
						throw new ValidatorException(new FacesMessage("Date of Death : Validation Error : Value is required  "));
					}
					else
					{
						throw new ValidatorException(new FacesMessage("Date of Disablity :  Validation Error : Value is required  "));
					}
				}
			}
			/*end*/	
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate); 
				System.out.println("date                 "+date);
				
			
				System.out.println("input value::::::::::::::::::::"+ inputdate);
				helper.whenValidateClaimLossDate(date, compositeAction
						.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),this,compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_NO());
				
				/*Commented by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
				
				/*helper.chkRiFacClose((Date) input.getSubmittedValue(), PT_IL_CLAIM_BEAN
						.getCLAIM_POL_SYS_ID());*/
				/*PT_IL_CLAIM_BEAN.setCLAIM_LOSS_DT((Date) value);*/
				
				/*End*/
				
				/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
				helper.chkRiFacClose(date,PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID());
				PT_IL_CLAIM_BEAN.setCLAIM_LOSS_DT(date);
				
				System.out.println("getCLAIM_LOSS_DT  in  ajaxvalidatorClaimLossDate         "+PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT());
				/*End*/
		   
			
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * Commented by Janani for SSP call ZBILQC-1721205 on 06.03.2017
			 * 
			 * 
			 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + e.getMessage());
			getErrorMap().put("lossdate",
					"Record not Inserted/Updated :: " + e.getMessage());
					
					*end
					*/
			
			
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
		}
	}
	
	
	/*Commented by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	/*public void validateCLAIM_LOSS_DATE(ActionEvent event) { 
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}*/
	/*End*/

	public void validatorIntimationDate(FacesContext context,
			UIComponent component, Object value) {
		try {
			
			
			/*Modified by Janani on 16.06.2017 for  ZBILQC-1723136 */
			
			/*helper.whenValidateIntimationDate((Date) value, compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), (Date) value);*/
			
		
			System.out.println("getCLAIM_LOSS_DT            "+this.getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT());
			
			helper.whenValidateIntimationDate((Date) value, compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),this.getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT());
			
			/*End*/
			
			PT_IL_CLAIM_BEAN.setCLAIM_INTM_DT((Date) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void validateIntimationDate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorClaimRLAAmount(FacesContext context,
			UIComponent component, Object value) {
		try {
			Date CLAIM_LOSS_DT = (Date) this.getCOMP_CLAIM_LOSS_DT().getValue();
			Date CLAIM_INT_DT = (Date) this.getCOMP_CLAIM_INTM_DT().getValue();
			helper.whenValidateClaimRLAAmount(value, compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					CLAIM_LOSS_DT, CLAIM_INT_DT);
			PT_IL_CLAIM_BEAN.setCLAIM_LC_RLA_AMOUNT((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateClaimRLAAmount(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorClaimNumber(FacesContext context,
			UIComponent component, Object value) {

		try {
			PT_IL_CLAIM_BEAN.setCLAIM_NO((String) value);
			helper.whenValidateClaimNo(PT_IL_CLAIM_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateClaimNo(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validatorClaimRefNumber(FacesContext context,
			UIComponent component, Object value) {
		try {
			helper.whenValidateClaimRefNumber(value, this.PT_IL_CLAIM_BEAN);
			PT_IL_CLAIM_BEAN.setCLAIM_REF_NO((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void validateClaimRefNo(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * @return the suggestionList
	 */
	public List<PT_IL_CLAIM> getSuggestionList() {
		return suggestionList;
	}

	/**
	 * @param suggestionList
	 *            the suggestionList to set
	 */
	public void setSuggestionList(List<PT_IL_CLAIM> suggestionList) {
		this.suggestionList = suggestionList;
	}

	/**
	 * @return the pOLICY_VALID_LIST
	 */
	public List<SelectItem> getPOLICY_VALID_LIST() {
		return POLICY_VALID_LIST;
	}

	/**
	 * @param policy_valid_list
	 *            the pOLICY_VALID_LIST to set
	 */
	public void setPOLICY_VALID_LIST(List<SelectItem> policy_valid_list) {
		POLICY_VALID_LIST = policy_valid_list;
	}

	/**
	 * @return the cLAIM_TYPE_LIST
	 */
	public List<SelectItem> getCLAIM_TYPE_LIST() {
		return CLAIM_TYPE_LIST;
	}

	/**
	 * @param claim_type_list
	 *            the cLAIM_TYPE_LIST to set
	 */
	public void setCLAIM_TYPE_LIST(List<SelectItem> claim_type_list) {
		CLAIM_TYPE_LIST = claim_type_list;
	}

	/**
	 * Save the current instance record.
	 */
	public void saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		
		/*Added by saritha on 19-06-2017 ssp call id ZBILQC-1718796*/
		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		Integer PLAN_CONT_PERIOD=null;
		String POL_END_TYPE=null;
		CRUDHandler handler = new CRUDHandler();
		/*Added by Ameen on 20-07-2017 for ZBILQC-1732374*/
		String HOSP_ERR_MSG = null;
		Integer HOSP_ERR_NO = null;
		/*End ZBILQC-1732374*/
		/*End*/
		try {
			/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			/*End*/
			Connection connection = CommonUtils.getConnection();
			DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN();
			CommonUtils utils = new CommonUtils();
			/*added by gopi for ssp call ZBILQC-1719136 and FSD_IL_ZB Life_012a on 20/01/17 */
			PT_IL_CLAIM_STATUS pt_il_claim_status = compositeAction
					.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
					.getPT_IL_CLAIM_STATUS_BEAN();
			String cs_status_code = null;
			/*end*/
			String pol_flag=ValidatePolNo();

			if ("P".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Paidup Policy!");
			}else if ("S".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Surrender Policy!");
			}else if ("M".equalsIgnoreCase(CommonUtils.nvl(pol_flag, "Y")))
			{
				throw new Exception(
						"Policy Number is not valid and it is Matured Policy!");
			}
			/*added by gopi for ssp call id ZBLIFE-1458500 on 12/12/17*/
			String plan_type_two=getPLAN_TYPE();
			if(plan_type_two!=null && !plan_type_two.equalsIgnoreCase("H"))
			{
			helper.whenValidateCLAIM_MEMB_CODE(this, getPT_IL_CLAIM_BEAN(),
					PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
			}
			//end
			if (PT_IL_CLAIM_BEAN.getROWID() == null) {
				PT_IL_CLAIM_BEAN.setCLAIM_CR_DT(utils.getCurrentDate());
				if ((PT_IL_CLAIM_BEAN.getCLAIM_NO() == null || ""
						.equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_NO()))
						&& PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() != null) {
					List<OracleParameter> listParameter = new LIFELIB()
							.P_GEN_DOC_NO("4", CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_1"),
									dummyBean.getM_POL_DIVN_CODE(), dummyBean
											.getM_POL_CLASS_CODE(), dummyBean
											.getM_POL_PLAN_CODE(), dummyBean
											.getM_POL_PROD_CODE(), String
											.valueOf(dummyBean
													.getM_POL_UW_YEAR()), null,
									"PT_IL_CLAIM", "N", CommonUtils
											.getProcedureValue(PT_IL_CLAIM_BEAN
													.getCLAIM_INTM_DT()),
									PT_IL_CLAIM_BEAN.getCLAIM_TYPE(),
									CommonUtils
											.getProcedureValue(PT_IL_CLAIM_BEAN
													.getCLAIM_INTM_DT()),
													
													/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
													CommonUtils.nvl(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(), null)
													/*End*/			
									
									);
					if (listParameter != null) {
						PT_IL_CLAIM_BEAN.setCLAIM_NO((String) listParameter
								.get(0).getValue());
						COMP_CLAIM_NO.setSubmittedValue((String) listParameter
								.get(0).getValue());
					}
				}
				helper.preInsert(compositeAction);
				
				/*ADDED BY RAJA ON 05-05-2017*/
				/*out parameter handled by Ameen on 20-07-2017 for ZBILQC-1732374*/
				String plan_type=getPLAN_TYPE();
				if("H".equalsIgnoreCase(plan_type)){
				List<OracleParameter> hospList = PILT006_APAC_PROCEDURE.P_HOSPITAL_VALIDATION(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(), dummyBean.getM_POL_PLAN_CODE(),
						PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE(),PT_IL_CLAIM_BEAN.getCLAIM_ICD_DISEASES_DTL(), 
						PT_IL_CLAIM_BEAN.getCLAIM_HOSP_ADDM_DT(), PT_IL_CLAIM_BEAN.getCLAIM_HOSP_DSCHG_DT(),HOSP_ERR_MSG,HOSP_ERR_NO);
					if(hospList != null){
						HOSP_ERR_MSG = (String) hospList.get(0).getValueObject();
						System.out.println("ERR_MSG ::" + HOSP_ERR_MSG);
					}
				}
				/*END*/
				new CRUDHandler().executeInsert(PT_IL_CLAIM_BEAN, CommonUtils
						.getConnection());
				helper.postInsert(PT_IL_CLAIM_BEAN);
				if (dummyBean.getUI_M_CLAIM_ADDL_STATUS() == null) {
					dummyBean.setUI_M_CLAIM_ADDL_STATUS("Registered");
				}
				if ((PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO().isEmpty())
						|| "Y".equalsIgnoreCase(PT_IL_CLAIM_BEAN
								.getCLAIM_FRZ_FLAG())) {
					COMP_UI_M_BUT_PRE_CLAIM_DTLS.setDisabled(true);
				} else {
					COMP_UI_M_BUT_PRE_CLAIM_DTLS.setDisabled(false);
				}
				if (PT_IL_CLAIM_BEAN.getCLAIM_NO() != null
						&& (!("O".equalsIgnoreCase(PT_IL_CLAIM_BEAN
								.getCLAIM_TYPE())))) {
					/*added by raja on 07-03-2017 for funeral benefit fsd*/
					/*
					 * COMMNETED BY AMEEN ON 20-07-2017 TO GET THE PLAN TYPE TOP
					 * String plan_type=getPLAN_TYPE();*/
					/*changed the if condition  on 04-05-2017 for Hospital cash plan*/
					//if(!plan_type.equalsIgnoreCase("L"))
					if(!plan_type.equalsIgnoreCase("L") && !plan_type.equalsIgnoreCase("H"))
					{
					helper.updatePolStatus(PT_IL_CLAIM_BEAN);
					}
					/*end*/
				}
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");
			} else {
				PT_IL_CLAIM_BEAN.setCLAIM_UPD_DT(utils.getCurrentDate());
				PT_IL_CLAIM_BEAN.setCLAIM_UPD_UID(CommonUtils.getControlBean()
						.getM_USER_ID());
				if ((PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO() != null && PT_IL_CLAIM_BEAN
						.getCLAIM_PCI_REF_NO().isEmpty())
						|| "Y".equalsIgnoreCase(PT_IL_CLAIM_BEAN
								.getCLAIM_FRZ_FLAG())) {
					COMP_UI_M_BUT_PRE_CLAIM_DTLS.setDisabled(true);
				} else {
					COMP_UI_M_BUT_PRE_CLAIM_DTLS.setDisabled(false);
				}
				
				if(PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()!=null && !PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP().equalsIgnoreCase("O"))
				{

					/*commneted by raja on 16-05-2017*/
					PT_IL_CLAIM_BEAN.setCLAIM_ADDL_STATUS("CL02");
					/*end*/
				
				}
				
				new CRUDHandler().executeUpdate(PT_IL_CLAIM_BEAN, CommonUtils
						.getConnection());
				/*condition handled by Ameen on 18-12-2017 for ZBLIFE-1463542 to change message for others type*/
				if("O".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE()) && "Y".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_FRZ_FLAG())){
					message = "Disability Process Completed Successfully";
				}else{
					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
				}
				/*end*/
			}
			if(null != HOSP_ERR_MSG){
				message = message + " ," + HOSP_ERR_MSG;
			}
			System.out.println("message WITH APPENDING PROC. OUT PARAM::" + message);
			getWarningMap().put("current", message);
			getWarningMap().put("save", message);
			getCOMP_CLAIM_NO().resetValue();
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			//String Disability_type =(String)this.getCOMP_CLAIM_DISABLITY().getSubmittedValue();
			
			
			/*Added by saranya for ssp call id ZBILQC-1723014 on 31-03-2017 */
			Long claimSysId=PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID();
			System.out.println("claimSysId  :"+claimSysId);
			P9ILPK_CLAIM.P_UPD_CUSTOMER_STS(claimSysId);
			/*End*/
			
			
			String Disability_type =PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP();
			
			/*commented by raja on 13-05-2017*/
			
			/*if(Disability_type!=null && !Disability_type.equalsIgnoreCase("O"))
			{
				 added by gopi for ssp call ZBILQC-1721875 on 04/03/17
			  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setCS_STATUS_CODE("D05");
			  end
			  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS("D05:- Claim Declined due to exclusions");
			  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
			  compositeAction.getWizard().disableWizardItem("toDoGroup");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
			  compositeAction.getWizard().disableWizardItem("reminders");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
			  Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017
			  compositeAction.getWizard().disableWizardItem("claimCharge");
			  end
			  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_FRZ().setDisabled(true);
			}*/
			/*end*/
					 
			String dis_comp=compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_CLAIM_ADDL_STATUS();
			System.out.println("---------------------->"+dis_comp);
			
			/*commented by raja on 13-05-2017*/
			
			/*if(dis_comp!=null && dis_comp.equalsIgnoreCase("D05:- Claim Declined due to exclusions")){
			 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_UI_M_BUT_FRZ().setDisabled(true);
			 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
			 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			  commented by gopi for ssp call ZBILQC-1721875 on 04/03/17
			 //compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_POL_PRINT().setDisabled(true);
			 //end
		} else{
				 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
				 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
				}*/
			
			/*end*/
			validate_Disability();
			//end
			/*added by gopi for ssp call ZBILQC-1719136 and FSD_IL_ZB Life_012a on 20/01/17 */
			/*cs_status_code=claim_history();
			System.out.println("addl status A1b ::"+PT_IL_CLAIM_BEAN.getUI_M_CLAIM_ADDL_STATUS());
			if(dis_comp != null){
				String array[]=dis_comp.split(":");
				if(array[0]!=null){
				if(!array[0].equalsIgnoreCase(cs_status_code)){
					new P9ILPK_CLAIM().P_INSERT_CLAIM_STATUS(CommonUtils.getProcedureValue(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()),"D05", 
							CommonUtils.getProcedureValue(pt_il_claim_status.getCS_STATUS_DT()),null,null);
				}
				}
			}*/
			/*end*/
			cs_status_code=claim_history();
			
			/*commented by raja on 13-05-2017*/
			
			/*if (PT_IL_CLAIM_BEAN.getROWID() != null) {
				if(Disability_type!=null && !Disability_type.equalsIgnoreCase("O"))
				{
					if(dis_comp != null){
						String array[]=dis_comp.split(":");
						if(array[0]!=null){
						if(!array[0].equalsIgnoreCase(cs_status_code)){
							new P9ILPK_CLAIM().P_INSERT_CLAIM_STATUS(CommonUtils.getProcedureValue(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()),"D05", 
									CommonUtils.getProcedureValue(pt_il_claim_status.getCS_STATUS_DT()),null,null);
						}
						}
					}
			}
			}*/
			
			/*end*/
			
			/*Added by saritha on 19-06-2017 for ssp call id ZBILQC-1718796*/
			System.out.println("pol_sys_id****************"+PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID());
			String cont_period_query ="SELECT PLAN_CONT_PERIOD FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE=POL_PLAN_CODE AND POL_SYS_ID=?";
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(cont_period_query, connection,
					new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			if (resultSet.next()) {
				PLAN_CONT_PERIOD=resultSet.getInt(1);
				System.out.println("Contestability Period::::::::::::::::::::::::"+PLAN_CONT_PERIOD);
			}
			
			Date M_POL_START_DT = dummyBean.getM_POL_START_DT();
			Date M_POL_END_DT =dummyBean.getM_POL_END_DT();
			Date CLAIM_LOSS_DT=PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT();
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(CLAIM_LOSS_DT);
			int claimYear = cal.get(Calendar.YEAR);
			Calendar cal1 = Calendar.getInstance();
			cal.setTime(M_POL_START_DT);
			
			int polYear = cal.get(Calendar.YEAR);
			int M_DIFF_DATE_POL=claimYear-polYear;
			System.out.println("M_DIFF_DATE_POL  ====  "+M_DIFF_DATE_POL);
			
			System.out.println("pol_sys_id****************"+PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID());
			String query1 = "SELECT POL_END_TYPE FROM PT_IL_POLICY WHERE POL_SYS_ID=? ";
			
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(query1, connection,
					new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
			if (resultSet1.next()) {
				POL_END_TYPE = resultSet1.getString(1);
				System.out.println("Endorsement Type::::::::::::::::::::::::"+POL_END_TYPE);
			}
				
			cal = Calendar.getInstance();
			cal.setTime(CLAIM_LOSS_DT);
			int claimYears = cal.get(Calendar.YEAR);
			cal1 = Calendar.getInstance();
			cal.setTime(M_POL_END_DT);
			int endYear = cal1.get(Calendar.YEAR);
				
			int M_DIFF_DATE_END=claimYears-endYear;
			System.out.println("M_DIFF_DATE_END  ====  "+M_DIFF_DATE_END);
			
			if((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006"))||(M_DIFF_DATE_END<PLAN_CONT_PERIOD)||(M_DIFF_DATE_POL<PLAN_CONT_PERIOD))
			{
				
				new P9ILPK_BUS_RULE().L_VAL_IL_BUS_RULE("IL", "T", CommonUtils
						.getProcedureValue(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()));
						
			}
				
			/*End*/
			
			/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17*/
			String check_value_insert=check_table_insert();
		
			if(!("X".equalsIgnoreCase(check_value_insert))){
			getP_INS_CLM_CHARGES(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID());
			
			}
			/*end*/
			
			/*Added by saranya for ssp call id ZBILQC-1723014 on 31-03-2017 */
			/*Long claimSysId=PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID();
			System.out.println("claimSysId  :"+claimSysId);
			P9ILPK_CLAIM.P_UPD_CUSTOMER_STS(claimSysId);*/
			/*End*/

			/*added by raja on 07-06-2017 for hands on points*/
			
		
			if(Disability_type!=null && !Disability_type.equalsIgnoreCase("O"))
			{
				disableAllComponent(true);
			}
			else
			{
				disableAllComponent(false);
			}
			/*end*/
			
			/*added by raja on 18-07-2017 for ZBILQC-1731514*/
			/*commentted by saritha on 30-10-2017 for Dependent Age is Greater than mentioned in Plan Member. Cannot Proceed as per Ajay sir sugg.*/
			/*if(getPLAN_TYPE().equalsIgnoreCase("L") || getPLAN_TYPE().equalsIgnoreCase("H"))
			{
		helper.callP_CLM_AGE_VALIDATION(getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID().toString(),getPT_IL_CLAIM_BEAN().getCLAIM_MEMB_CODE());
			}*/
			/*end*/
			
			/* Newly Added By Dhinesh on 11.8.2017 for ssp call id   ZBILQC-1730139 */
			String plantype=getPLAN_TYPE();
			int DependentCodeAvailable = 0 ;
			if(plantype!=null && plantype.equalsIgnoreCase("H"))
			{  
				if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_BEAN.getCLAIM_TYPE(), "X"), "D","A"))
				{
					DependentCodeAvailable = getMemberDependentCode(PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
				
				     if(DependentCodeAvailable == 1)
				     {
				    	 getWarningMap().put("current"," Please settle all pending Hospital Benefits before proceeding to Death (WOP) Claim ");
				     }else
				     { 
				    	 throw new Exception("Death (WOP) Claim is applicable only for the Main Member"); 
				    	 
				     }
					
					
				}
				
			}
			
			/* End */
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}

	}

	public void keyCommitt() throws Exception {
		PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN = compositeAction
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();

		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			ArrayList<OracleParameter> list1 = new ArrayList<OracleParameter>();
			list1 = new ArrayList<OracleParameter>();
			list1 = new PILPK_PILT006().KEY_COMMIT_1(PT_IL_CLAIM_BEAN
					.getCLAIM_SYS_ID(), PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
					PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT(), dummyBean
							.getUI_M_WAQAF_DT(), null, PT_IL_CLAIM_BEAN
							.getCLAIM_POL_NO(), dummyBean.getM_POL_PLAN_CODE(),
					dummyBean.getM_POL_PROD_CODE(), PT_IL_CLAIM_BEAN
							.getCLAIM_NO(), PT_IL_CLAIM_BEAN
							.getCLAIM_LC_WAK_AMT(), PT_IL_CLAIM_BEAN
							.getCLAIM_LC_SERV_FEE(), PT_IL_CLAIM_BEAN
							.getCLAIM_LC_RISK_PREM());

			if (list1 != null && !list1.isEmpty()) {
				PT_IL_CLAIM_BEAN.setCLAIM_LC_WAK_AMT((Double) list1.get(0)
						.getValueObject());
				PT_IL_CLAIM_BEAN.setCLAIM_LC_SERV_FEE((Double) list1.get(1)
						.getValueObject());
				PT_IL_CLAIM_BEAN.setCLAIM_LC_RISK_PREM((Double) list1.get(2)
						.getValueObject());
			}
			// postAllRecords();
		
			/*
			 *  As per suggested by chandramohan below Keycommit_2 procedure commented for ssp call id : ZBILQC-1719138 
			 * 
			 * 
			 * list1 = new ArrayList<OracleParameter>();
			list1 = new PILPK_PILT006()
					.KEY_COMMIT_2(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID(),
							PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
							PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(),
							PT_IL_CLAIM_BEAN.getCLAIM_CURR_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(), dummyBean
									.getM_BASE_CURR(),
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_TYPE(), PT_IL_CLAIM_BEAN
									.getCLAIM_INTM_DT(), PT_IL_CLAIM_BEAN
									.getCLAIM_LOSS_DT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_PREM_OS(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_LOAN_OS(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_LOAN_INT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_ACC_PROFIT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_EST_AMT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_LC_EST_AMT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_FC_NET_EST_AMT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_LC_NET_EST_AMT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_UNIT_FC_AMT(), compositeAction
									.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
									.getPT_IL_CLAIM_ESTIMATE_BEAN()
									.getCE_UNIT_LC_AMT());
			
			if (list1 != null && !list1.isEmpty()) {
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_EST_AMT(
								(Double) list1.get(0).getValueObject());
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_LC_EST_AMT(
								(Double) list1.get(1).getValueObject());
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_NET_EST_AMT(
								(Double) list1.get(2).getValueObject());
				System.out.println("Total_net_amt  :"+compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_NET_EST_AMT());
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_LC_NET_EST_AMT(
								(Double) list1.get(3).getValueObject());
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_UNIT_FC_AMT(
								(Double) list1.get(4).getValueObject());
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
						.getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_UNIT_LC_AMT(
								(Double) list1.get(5).getValueObject());
			}*/
			postAllRecords();
			list1 = new ArrayList<OracleParameter>();
			list1 = new PILPK_PILT006().KEY_COMMIT_3(PT_IL_CLAIM_BEAN
					.getCLAIM_SYS_ID(), PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
					PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(), PT_IL_CLAIM_BEAN
							.getCLAIM_LOSS_DT(), dummyBean.getUI_M_WAQAF_DT(),
					PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(), dummyBean
							.getM_POL_STATUS(), PT_IL_CLAIM_BEAN
							.getCLAIM_TYPE(), PT_IL_CLAIM_BEAN
							.getCLAIM_CURR_CODE(), dummyBean
							.getM_POL_PLAN_CODE(), dummyBean
							.getM_POL_SA_CURR_CODE_1(), dummyBean
							.getM_POL_CUST_CURR_CODE_1(), dummyBean
							.getM_BASE_CURR(), PT_IL_CLAIM_BEAN
							.getCLAIM_ASSR_CODE(),
					dummyBean.getM_CALC_METHOD(), dummyBean.getM_RSRV_CLM(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG(),
					PT_IL_CLAIM_BEAN.getCLAIM_APPRV_STATUS(), PT_IL_CLAIM_BEAN
							.getCLAIM_REV_RES_FLAG());

			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0).getValueObject() != null) {
					PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FRZ_FLAG((String) list1
							.get(0).getValueObject());
				}
				if (list1.get(1).getValueObject() != null) {
					PT_IL_CLAIM_COVER_DTLS_BEAN
							.setCCD_CONFIRM_FLAG((String) list1.get(1)
									.getValueObject());
				}
			}
			//postAllRecords();
			System.out.println("Total_net_amt1  :"+compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
					.getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_NET_EST_AMT());
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(false);
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public int insertRecord(PT_IL_CLAIM claimBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		int result = 0;
		try {
			result = handler.executeInsert(claimBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return result;
	}

	/**
	 * Instantiates all components in PT_IL_CLAIM_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_CLOSE_FLAG = new HtmlInputText();
		COMP_UI_M_CLAIM_STATUS = new HtmlInputText();
		COMP_UI_M_CLAIM_ADDL_STATUS = new HtmlInputText();
		COMP_CLAIM_PCI_REF_NO = new HtmlInputText();
		COMP_CLAIM_POL_NO = new HtmlInputText();
		COMP_CLAIM_ASSR_CODE = new HtmlInputText();
		COMP_UI_M_CLAIM_ASS_NAME = new HtmlInputText();
		COMP_CLAIM_CUST_CODE = new HtmlInputText();
		COMP_UI_M_CUST_DESC = new HtmlInputText();
		COMP_CLAIM_ACCNT_PAY_CODE = new HtmlInputText();
		COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC = new HtmlInputText();
		COMP_CLAIM_MED_CODE = new HtmlInputText();
		COMP_UI_M_CLAIM_MED_CODE_NAME = new HtmlInputText();
		COMP_CLAIM_LC_RLA_AMOUNT = new HtmlInputText();
		COMP_CLAIM_NO = new HtmlInputText();
		COMP_CLAIM_CURR_CODE = new HtmlInputText();
		COMP_UI_M_CLAIM_CURR_CODE_DESC = new HtmlInputText();
		COMP_CLAIM_REF_NO = new HtmlInputText();
		COMP_CLAIM_REMARKS = new HtmlInputText();
		COMP_CLAIM_RESV_AMT = new HtmlInputText();
		COMP_CLAIM_UTIL_AMT = new HtmlInputText();
		COMP_CLAIM_REOPEN_REASON = new HtmlInputText();
		COMP_CLAIM_LC_RISK_PREM = new HtmlInputText();
		COMP_CLAIM_LC_WAK_AMT = new HtmlInputText();
		COMP_CLAIM_LC_SERV_FEE = new HtmlInputText();
		/*added by gopi for hand on feed back point,serial no 15 in zb on 01/02/17*/
		COMP_CLAIM_DISEASES_CODE = new HtmlInputText();
		/*end*/
	
		// Instantiating HtmlSelectOneMenu
		COMP_CLAIM_TYPE = new HtmlSelectOneMenu();
		COMP_CLAIM_POL_VALID_YN = new HtmlSelectOneMenu();

		
		/*added by sankara narayanan on 08/03/2017*/
		COMP_SAVE_COMMAND_LINK= new HtmlCommandLink();
		COMP_SAVE_BUTTON= new HtmlCommandButton();
		//end
		
		// Instantiating HtmlCalendar
		COMP_CLAIM_LOSS_DT = new HtmlCalendar();
		COMP_CLAIM_INTM_DT = new HtmlCalendar();
		COMP_CLAIM_CR_DT = new HtmlCalendar();
		COMP_CLAIM_REOPEN_DT = new HtmlCalendar();

		COMP_CLAIM_DISABLITY = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_ACCNT_PAY_CODE = new HtmlCommandButton();
		COMP_UI_M_LOV_BUT_CLAIM_MED_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PRE_CLM_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_PRE_CLAIM_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_FRZ = new HtmlCommandButton();
		COMP_UI_M_BUTT_ACC_FIR_DTLS = new HtmlCommandButton();
		COMP_UI_M_LOV_BUT_EST_CURR_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_EDI_CLIAM_REMARK = new HtmlCommandButton();
		COMP_UI_M_BUT_CLOSE = new HtmlCommandButton();
		COMP_UI_M_BUT_STAUS_CHANGE = new HtmlCommandButton();
		COMP_UI_M_BUT_SETTLEMENT = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_SR_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_POL_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_REOPEN = new HtmlCommandButton();
		COMP_UI_M_BUT_POLICY_DTLS = new HtmlCommandButton();
		//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
		COMP_CLAIM_DIS_CERT_DT_LABEL = new HtmlOutputLabel();
		COMP_CLAIM_DIS_CERT_DT = new HtmlCalendar();
		COMP_CLAIM_MED_EXP_DT_LABEL = new HtmlOutputLabel();
		COMP_CLAIM_MED_EXP_DT = new HtmlCalendar();
		COMP_CLAIM_SICKNESS_DT_LABEL = new HtmlOutputLabel();
		COMP_CLAIM_SICKNESS_DT = new HtmlCalendar();
		//END CLAIM TYPE = OTHERS
		/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017
		COMP_CLAIM_FEE_HOSPITALS = new HtmlInputText();
		end*/
		
		/*Added by R Raja on 24.01.2017 for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/
		COMP_CLAIM_MEMB_CODE=new HtmlInputText();
		COMP_CLAIM_MEMB_CODE_DESC=new HtmlInputText();
/*end*/
		
/*Added by Janani on 07.04.2017*/
		
		COMP_CLAIM_ICD_DISEASES_DTL_LABEL = new HtmlOutputLabel();
		COMP_CLAIM_ICD_DISEASES_DTL = new HtmlInputText();
		COMP_UI_M_CLAIM_ICD_DISEASES_DTL = new HtmlInputText();
		
		
		/*eND*/
		
		
		/*added by sankara narayanan for Hospital cash plan on 26/04/2017*/
		 COMP_CLAIM_HOSP_ADDM_DT_LABEL= new HtmlOutputLabel();
		 COMP_CLAIM_HOSP_ADDM_DT= new HtmlCalendar();
		 COMP_CLAIM_HOSP_DSCHG_DT_LABEL= new HtmlOutputLabel();
		 COMP_CLAIM_HOSP_DSCHG_DT= new HtmlCalendar();
		 //end
		
		 /* added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
		 COMP_CLAIMANT_CODE_LABEL= new HtmlOutputLabel(); 
		 COMP_CLAIMANT_CODE = new HtmlInputText();
		 
		//end
		 
		 /*Added by saritha on 19-07-2017 for ssp call id ZBILQC-1732118*/
		 COMP_DISABILITY_DEATH_SUICIDE = new HtmlOutputText();
		 /*End*/
		 
		 /*Added by saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
		 COMP_CLAIM_INT_MOBILE_LABEL = new HtmlOutputLabel();
		 COMP_CLAIM_INT_EMAIL_LABEL  = new HtmlOutputLabel();
		 COMP_CLAIM_INT_MOBILE       = new HtmlInputText();
		 COMP_CLAIM_INT_EMAIL        = new HtmlInputText();
		 /*End*/
		
		}

	private void postAllRecords() {
		try {
			new CRUDHandler().executeInsert(PT_IL_CLAIM_BEAN, CommonUtils
					.getConnection());
			new CRUDHandler().executeInsert(compositeAction
					.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getPT_IL_CLAIM_COVER_DTLS_BEAN(), CommonUtils
					.getConnection());
			
		/*
		 * Below code commented by Dhinesh  on 26-06-2017
		 * 
		 * 	new PT_IL_CLAIM_ESTIMATE_HELPER().preInsert(compositeAction
					.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
					.getPT_IL_CLAIM_ESTIMATE_BEAN(), PT_IL_CLAIM_BEAN,
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			new CRUDHandler().executeInsert(compositeAction
					.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
					.getPT_IL_CLAIM_ESTIMATE_BEAN(), CommonUtils
					.getConnection());
					
		
		*
		*end
		*/
			
			// new
			// CRUDHandler().executeInsert(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
			// CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void executeAllSelectQueries() throws Exception {
		try {
			new PT_IL_CLAIM_COVER_DTLS_HELPER().executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void whenListChangedClaimType(ActionEvent event) throws Exception {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getValue();
		PT_IL_CLAIM_HELPER pt_il_claim_helper = new PT_IL_CLAIM_HELPER();
		try {
			pt_il_claim_helper.whenListChangedClaimType(value, compositeAction
					.getDUMMY_ACTION_BEAN(), compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}

	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}

	/**
	 * 
	 * @return
	 */
	public String settleButtonPressed() {
		String outcome = "GO_TO_PT_IL_CLAIM";
		try {
			helper.whenSettlementButPress(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return outcome;
	}

	/**
	 * 
	 * @return
	 */
	public void closeButtonPressed() {
		try {
			helper.whenCloseButPress(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}

	}

	public String reopenButPressed() {
		String outCome = null;
		try {
			helper.whenreopenButPressed(compositeAction);
			
		} catch (Exception e) {
			outCome = "claimsEntry";
			e.printStackTrace();
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put("reOpen",
					e.getMessage());
		}
		return outCome;

	}

	/**
	 * 
	 * @return
	 */
	public String reopenButtonPressed() {
		try {
			helper.whenReopenButtonPress(PT_IL_CLAIM_BEAN, compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}

		return "claimsEntry";

	}

	/**
	 * 
	 */
	public String statusChangeButPressed() throws Exception {
		PT_IL_CLAIM_STATUS pt_il_claim_status = compositeAction
				.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
				.getPT_IL_CLAIM_STATUS_BEAN();
		pt_il_claim_status.setCS_STATUS_DT(new CommonUtils().getCurrentDate());
		compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
				.getCOMP_CS_STATUS_DT().setDisabled(true);
		String query = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_CLM_SYS_ID=? AND DTLS_MANDATORY_YN='Y'  AND DTLS_APPR_STS = 'N'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String M_CHAR = null;
		String Disability_type=null;
		try {
			con = CommonUtils.getConnection();
			
			/*added by raja on 07-06-2017 for hands on points*/
			if(!PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP().equalsIgnoreCase("O"))
			{
			boolean flag=false;
			 flag=statusAccessValidation();
			if(flag==false)
			{
				throw new Exception("User not authorized");
			}
			}
			/*end*/
			
			/*Added by ganesh on 15-12-2017 */
			checkWOPAloneOrNot();
			
			/*end*/
			
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			 Disability_type =PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP();
			 /*commented by raja on 15-05-2017*/
				/*if(!Disability_type.equalsIgnoreCase("O"))
				{
					throw new Exception("Kindly change Exclusion type and proceed to change status");
				}*/
				/*END*/
			/*END*/
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().setBlockFlag(true);
			//end
			/*added by SANKAR 05/03/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			if(!("O".equalsIgnoreCase(Disability_type))){
			//END
				rs = handler.executeSelectStatement(query, con,
					new Object[] { compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID() });
			if (rs.next()) {
				M_CHAR = rs.getString(1);
			}
			
			boolean suicide_Flag = false;
			if("S".equalsIgnoreCase(Disability_type))
			{
			double suicideValue = getSuicideValue();
			 suicide_Flag = monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_START_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())<=suicideValue ;
			
			
			}
		
			if ("X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "Y")) && "S".equalsIgnoreCase(Disability_type))
			{
				if(!suicide_Flag)
				{
					
				}
				else
				{
					throw new Exception(
							"Mandatory Checklist Verification is Pending!");
				}
				
			} 
			else
			{
					return "PILT006_APAC_PT_IL_CLAIM_STATUS_CHANGE";
			}
			}else{
				return "PILT006_APAC_PT_IL_CLAIM_STATUS_CHANGE";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return "";
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String freezeButtonPressed() throws Exception {
		String freeze = null;

		try {
			String wop = checkwop(compositeAction);
			
			if ("W".equalsIgnoreCase(wop)) {
				if ("Freeze".equalsIgnoreCase((String) COMP_UI_M_BUT_FRZ
						.getValue())) {
					PT_IL_CLAIM_BEAN.setCLAIM_FRZ_FLAG("Y");
					setFreezCaption("UnFreeze");
				} else {
					PT_IL_CLAIM_BEAN.setCLAIM_FRZ_FLAG("N");
					setFreezCaption("Freeze");
				}
				/*added by raja to discuee with siva sir on 19-06-2017*/
				String Query="SELECT PLAN_TYPE FROM PM_IL_PLAN,PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID =?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
										.getCLAIM_POL_SYS_ID()});
				String plan_type=null;
				while(rs.next())
				{
					plan_type=rs.getString("PLAN_TYPE");
				}
				
				if(plan_type!=null && (plan_type.equalsIgnoreCase("L") || plan_type.equalsIgnoreCase("H")))
						{
				helper.P_CALC_PREMIUM_FUNERAL(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID().toString(), PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID().toString(), PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
						}
				/*end*/
				
				helper.whenFreezeButton(compositeAction);
				
				/*Added by Saranya on 13/04/2017*/
				throw new Exception("Kindly save the Freeze");
				/*End*/

			} else {
				throw new Exception("This claim cannot be freezed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return freeze;
	}

	public String freezeButtonPressed_WOP() throws Exception {
		String freeze = null;

		try {
			/*String wop = checkwop(compositeAction);*/
			
			String wop = "W";
			if ("W".equalsIgnoreCase(wop)) {
				if ("Freeze".equalsIgnoreCase((String) COMP_UI_M_BUT_FRZ
						.getValue())) {
					PT_IL_CLAIM_BEAN.setCLAIM_FRZ_FLAG("Y");
					setFreezCaption("UnFreeze");
				} else {
					PT_IL_CLAIM_BEAN.setCLAIM_FRZ_FLAG("N");
					setFreezCaption("Freeze");
				}
				/*added by raja to discuee with siva sir on 19-06-2017*/
				String Query="SELECT PLAN_TYPE FROM PM_IL_PLAN,PT_IL_POLICY WHERE POL_PLAN_CODE = PLAN_CODE AND POL_SYS_ID =?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
										.getCLAIM_POL_SYS_ID()});
				String plan_type=null;
				while(rs.next())
				{
					plan_type=rs.getString("PLAN_TYPE");
				}
				
				if(plan_type!=null && (plan_type.equalsIgnoreCase("L") || plan_type.equalsIgnoreCase("H")))
						{
				helper.P_CALC_PREMIUM_FUNERAL(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID().toString(), PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID().toString(), PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
						}
				/*end*/
				
				helper.whenFreezeButton(compositeAction);
				
				/*Added by Saranya on 13/04/2017*/
				/*throw new Exception("Kindly save the Freeze");*/
				/*End*/

			} else {
				throw new Exception("This claim cannot be freezed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return freeze;
	}
	public String preClaimDtlButPressed() {
		PILT042_APAC_SEATCH_ACTION pilt042ApacSeatchAction = new PILT042_APAC_SEATCH_ACTION();
		String outcome = null;
		CommonUtils.setGlobalVariable("GLOBAL.PRE_CLAIM_NO", compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_PCI_REF_NO());
		CommonUtils.setGlobalVariable("GLOBAL.PCI_POL_NO", compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO());
		// Call form
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		if (callingForm.equalsIgnoreCase("PILT002_APAC")) {
			CommonUtils.setGlobalVariable("CALLING_FORM_POL", "PILT002_APAC");
		} else {
			CommonUtils.setGlobalVariable("CALLING_FORM_POL", "PILT006_APAC");
		}

		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
		CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME", "claimsEntry");
		try {
			outcome = pilt042ApacSeatchAction.clearList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String policyDtsButPressed() {
		String policy = "";
		String CLAIM_CALLING_FORM = CommonUtils
				.getGlobalVariable("CLAIM_CALLING_FORM");
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		try {
			helper.policyButPressed(compositeAction);
			if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO() != null) {
				if (CLAIM_CALLING_FORM != null && !CLAIM_CALLING_FORM.isEmpty()
						&& CLAIM_CALLING_FORM.equalsIgnoreCase("PILT002_APAC")) {
					CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM",
							"PILT002_APAC");
				} else {
					/*
					 * if(!("".equalsIgnoreCase(callingForm)) &&
					 * (CLAIM_CALLING_FORM ==null ||
					 * CLAIM_CALLING_FORM.isEmpty())){
					 * CommonUtils.setGlobalVariable("CALLING_FORM",null); }
					 */
					if (!"PILT002_APAC".equalsIgnoreCase(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM",
								"PILT006_APAC");
					}
				}
				System.out.println(CommonUtils
						.getGlobalVariable("CALLING_FORM"));
				System.out.println(CommonUtils
						.getGlobalVariable("CLAIM_CALLING_FORM"));
				CommonUtils.setGlobalVariable("CLAIM_ROW_ID", compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getROWID());
				CommonUtils.setGlobalObject("GLOBAL.M_CLM_SYS_ID",
						compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
								.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
				policy = "PILT002_APAC_PT_IL_POLICY";
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return policy;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String acctFIRDtlsPressed() throws Exception {
		return "accFirDtls";
	}

	/**
	 * 
	 * @return
	 */
	public String backButton() {
		CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM", null);
		CommonUtils.setGlobalVariable("CALLING_FORM", null);
		return "PILT006_APAC";
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
public void firePreClmFieldValidation(ActionEvent actionEvent){
	UIInput input = (UIInput) actionEvent.getComponent().getParent(); ErrorHelpUtil.validate(input, getErrorMap());
}//end
	
	public String deleteAction() {
		CommonUtils.clearMaps(this);
		String message = null;
		try {
			if (PT_IL_CLAIM_BEAN == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			} else {
				helper.preDelete(PT_IL_CLAIM_BEAN);
				new CRUDHandler().executeDelete(PT_IL_CLAIM_BEAN, CommonUtils
						.getConnection());
				setPT_IL_CLAIM_BEAN(new PT_IL_CLAIM());
				String deleteMeaage = Messages.getString("messageProperties",
						"errorPanel$message$delete");
				CommonUtils.doComitt();
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Delete", e.getMessage());
		}
		return null;
	}

	/**
	 * @return the cOMP_CLAIM_DISABILTY_LABEL
	 */
	public HtmlOutputLabel getCOMP_CLAIM_DISABILTY_LABEL() {
		return COMP_CLAIM_DISABILTY_LABEL;
	}

	/**
	 * @param comp_claim_disabilty_label
	 *            the cOMP_CLAIM_DISABILTY_LABEL to set
	 */
	public void setCOMP_CLAIM_DISABILTY_LABEL(
			HtmlOutputLabel comp_claim_disabilty_label) {
		COMP_CLAIM_DISABILTY_LABEL = comp_claim_disabilty_label;
	}

	/**
	 * @return the cOMP_CLAIM_DISABLITY
	 */
	public HtmlInputText getCOMP_CLAIM_DISABLITY() {
		return COMP_CLAIM_DISABLITY;
	}

	/**
	 * @param comp_claim_disablity
	 *            the cOMP_CLAIM_DISABLITY to set
	 */
	public void setCOMP_CLAIM_DISABLITY(HtmlInputText comp_claim_disablity) {
		COMP_CLAIM_DISABLITY = comp_claim_disablity;
	}

	// added by Akash for claim credit note report

//	@Override
	public String runActiondms() {   // changed by sankara narayanan for print 16-02-2017
		String redirectdmsUrl = null;  // changed by sankara narayanan for print 16-02-2017
		CommonUtils.clearMaps(this);
		setRedirectUrl(null);
		HttpServletResponse response = null;
		Connection connection = null;
		String repid = null;
		IP_REP_INFO_BEAN.setREP_ID("PILR_MEI_24");
		Map<String, String> map = new HashMap<String, String>();
		try {
			/* if () { */
			IP_REP_INFO_BEAN.setREP_VALUE_1(String.valueOf(this
					.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()));
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				PRE_INSERT(IP_REP_INFO_BEAN);
			} else {
				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}
			IP_REP_INFO_BEAN.setREP_ID("PILR_MEI_24");
			executeSaveAction(this.IP_REP_INFO_BEAN);
			connection = CommonUtils.getConnection();
			response = (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();
			map.put("P_LANG_CODE", CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			map.put("P_CLM_SYS_ID", String.valueOf(this.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID()));
			map.put("P_REP_NAME", "PILR_MEI_24");
			redirectdmsUrl = ReportUtils.getReportRedirectString(IP_REP_INFO_BEAN
					.getREP_KEY_NO(), "PILR_MEI_24", repid, IP_REP_INFO_BEAN
					.getSelectedFileType(), map);
			// response.sendRedirect(redirectUrl);
			/*Added By janani 24.5.2016*/
			StringBuffer url=new StringBuffer();
			
			Long CLAIM_SYS_ID=PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID();
			System.out.println("PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()   : "+PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID());
			
			String JasperReportName="ClaimDischargeForm";
			System.out.println("JasperReportName for claims  : "+JasperReportName);
		
			url=new StringBuffer(redirectdmsUrl);    // changed by sankara narayanan for print 16-02-2017
			url.append("&JasperReportName="+JasperReportName+"&JasperPolSysId="+CLAIM_SYS_ID);
			
			setRedirectUrl(url.toString());
			/*End*/
			/*commented By janani 24.5.2016*/
			//setRedirectUrl(redirectUrl);  
			/*
			 * }else { throw new Exception("UnApproved Record"); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("RunAction", e.getMessage());
		}
		return redirectdmsUrl;     // changed by sankara narayanan for print 16-02-2017
	}

	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID")); // changed by sankara narayanan for print 16-02-2017
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID")); // changed by sankara narayanan for print 16-02-2017
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void executeSaveAction(IP_REP_INFO iP_REP_INFO_BEAN) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int i = 0;
		try {
			connection = CommonUtils.getConnection();
			if (iP_REP_INFO_BEAN.getROWID() == null) {
				i = handler.executeInsert(iP_REP_INFO_BEAN, connection);
			} else {
				i = handler.executeUpdate(iP_REP_INFO_BEAN, connection);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void backButtonDisable() {
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		String CLAIM_CALLING_FORM = CommonUtils
				.getGlobalVariable("CLAIM_CALLING_FORM");
		
		/*Modified by Janani on 28.06.2017 for ZBILQC-1728704*/
		
		/*if (CALLING_FORM.equalsIgnoreCase("PILT002_APAC"))*/ 
		
		if (CALLING_FORM != null && CALLING_FORM.equalsIgnoreCase("PILT002_APAC"))
		
		/*End*/	
			
		{
			COMP_BUT_BACK.setDisabled(true);
		} else {
			COMP_BUT_BACK.setDisabled(false);
		}
	}

	public HtmlCommandLink getCOMP_BUT_BACK() {
		return COMP_BUT_BACK;
	}

	public void setCOMP_BUT_BACK(HtmlCommandLink comp_but_back) {
		COMP_BUT_BACK = comp_but_back;
	}

	public String checkwop(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String c1 = "select cover_class from pm_il_cover where cover_code=?";
		String m_cover_class = null;
		ResultSet rs = null;
		try {
			
			/*changed by raja on 16-08-2017 for discussd with gourav*/
			String covercode=null;
			String Query_covercode="SELECT CCD_COVER_CODE FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID IN (?) AND NVL(CCD_FC_EST_AMT, 0) <> 0";
			ResultSet RScovercode=new CRUDHandler().executeSelectStatement(Query_covercode, CommonUtils.getConnection(), new Object[]{compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while(RScovercode.next())
			{
				covercode=RScovercode.getString("CCD_COVER_CODE");
			}
			
			/*end*/
			Connection con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(c1, con,
					new Object[] { covercode});
			while (rs.next()) {
				m_cover_class = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return m_cover_class;
	}
	/*Added By janani 24.5.2016*/
	public int checkwopCount(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet rs = null;
		int count=0;
		try {
			
			
			String Query_covercode="SELECT Count(*) count_REC FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID IN (?) AND NVL(CCD_FC_EST_AMT, 0) <> 0";
			ResultSet RScovercode=new CRUDHandler().executeSelectStatement(Query_covercode, CommonUtils.getConnection(), new Object[]{compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while(RScovercode.next())
			{
				count=RScovercode.getInt("count_REC");
			}
			
			Connection con = CommonUtils.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return count;
	}
private HtmlCommandButton COMP_POL_PRINT;
	
	
	public HtmlCommandButton getCOMP_POL_PRINT() {
		return COMP_POL_PRINT;
	}

	public void setCOMP_POL_PRINT(HtmlCommandButton cOMP_POL_PRINT) {
		COMP_POL_PRINT = cOMP_POL_PRINT;
	}
	
	public void validateCLAIM_DIS_CERT_DT(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateCLAIM_MED_EXP_DT(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateCLAIM_SICKNESS_DT(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DISABILITY;
	
	
	  public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DISABILITY() {
		return COMP_REPORT_MODAL_PANEL_DISABILITY;
	}

	public void setCOMP_REPORT_MODAL_PANEL_DISABILITY(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DISABILITY) {
		COMP_REPORT_MODAL_PANEL_DISABILITY = cOMP_REPORT_MODAL_PANEL_DISABILITY;
	}
	private HtmlInputText COMP_UI_M_CLAIM_EXCL_TYP;
	
	public HtmlInputText getCOMP_UI_M_CLAIM_EXCL_TYP() {
		return COMP_UI_M_CLAIM_EXCL_TYP;
	}

	public void setCOMP_UI_M_CLAIM_EXCL_TYP(HtmlInputText cOMP_UI_M_CLAIM_EXCL_TYP) {
		COMP_UI_M_CLAIM_EXCL_TYP = cOMP_UI_M_CLAIM_EXCL_TYP;
	}
	
	
	private HtmlOutputLabel COMP_CLAIM_REASON_LABEL;
	
	public HtmlOutputLabel getCOMP_CLAIM_REASON_LABEL() {
		return COMP_CLAIM_REASON_LABEL;
	}

	public void setCOMP_CLAIM_REASON_LABEL(HtmlOutputLabel cOMP_CLAIM_REASON_LABEL) {
		COMP_CLAIM_REASON_LABEL = cOMP_CLAIM_REASON_LABEL;
	}
	private HtmlInputTextarea COMP_CLAIM_REASON;
	
	public HtmlInputTextarea getCOMP_CLAIM_REASON() {
		return COMP_CLAIM_REASON;
	}

	public void setCOMP_CLAIM_REASON(HtmlInputTextarea cOMP_CLAIM_REASON) {
		COMP_CLAIM_REASON = cOMP_CLAIM_REASON;
	}
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON_DELETE;
	
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON_DELETE() {
		return COMP_CANCEL_BUTTON_DELETE;
	}

	public void setCOMP_CANCEL_BUTTON_DELETE(
			HtmlAjaxCommandButton cOMP_CANCEL_BUTTON_DELETE) {
		COMP_CANCEL_BUTTON_DELETE = cOMP_CANCEL_BUTTON_DELETE;
	}

	public void validatorDisability_type(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
			try {
				System.out.println("*************ENTER INTO validatorDisability_type************");
				UIInput input = (UIInput) actionEvent.getComponent().getParent();
				Boolean flag=false;
			String Disability_type =(String)input.getSubmittedValue();
			
			/*Added by saritha on 19-07-2017 for ssp call id ZBILQC-1732118*/
			Connection connection = null;
			ResultSet resultset = null;
			String POL_END_TYPE = null;
			connection = CommonUtils.getConnection();
			/*End*/
			
			/*added by raja on 16-05-2017*/
//			if(PT_IL_CLAIM_BEAN.getCLM_EXCL_YN()!=null && PT_IL_CLAIM_BEAN.getCLM_EXCL_YN().equalsIgnoreCase("N"))
//			{
//				PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP(Disability_type);	
//			}
//			else if(PT_IL_CLAIM_BEAN.getCLM_EXCL_YN()!=null && PT_IL_CLAIM_BEAN.getCLM_EXCL_YN().equalsIgnoreCase("Y"))
//			{
//				/*added by raja on 07-06-2017 for hands on points*/
//				boolean accessFlag =false;
//				accessFlag=accessValidation();
//				if(accessFlag==false)
//				{
//					throw new Exception("User not authorized");
//				}
//				/*end*/
//				PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP(Disability_type);
//			}
//			else
//			{
//				/*added by raja on 07-06-2017 for hands on points*/
//				/*boolean accessFlag =false;
//				accessFlag=accessValidation();
//				if(accessFlag==false)
//				{
//					throw new Exception("User not authorized");
//				}*/
//				/*end*/
//				PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP(Disability_type);
//			}
			
			
			PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP(Disability_type);
			/*end*/
			
			System.out.println("Disability Type"+PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP());
			String query1="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CLM_EXCL' AND PC_CODE=? ";
			String query2="SELECT 'X' FROM PM_CODES WHERE PC_TYPE = 'IL_CLM_EXCL' and NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE=?";
			CRUDHandler handler = new CRUDHandler();
			//if(!Disability_type.equalsIgnoreCase("O"))
			if(Disability_type.equalsIgnoreCase("S")||Disability_type.equalsIgnoreCase("W")
	||Disability_type.equalsIgnoreCase("T")||Disability_type.equalsIgnoreCase("N")||
					Disability_type.equalsIgnoreCase("B"))
			
			{
				System.out.println("disablity type !equals of O");
				
				/*Added by saritha on 19-07-2017 for ssp call id ZBILQC-1732118*/
				String End_Type = "SELECT POL_END_TYPE FROM PT_IL_POLICY WHERE POL_SYS_ID=? ";
				resultset = new CRUDHandler().executeSelectStatement(End_Type, connection,
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
				if (resultset.next()) {
					POL_END_TYPE = resultset.getString(1);
				}
				
				if(Disability_type.equalsIgnoreCase("S")){
					double suicideValue = getSuicideValue();

System.out.println("Disability_type is S");

					/*Modified by Janani on 30.08.2017 for ZBILQC-1732118*/

					/*if((monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_START_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())>=suicideValue)||
								(((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006")))&&
								(monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_END_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())>=suicideValue))){
					 */

					if((monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_START_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())<=suicideValue)||
							(((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006")))&&
									(monthsBetween(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_END_DT(),getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT())<=suicideValue))){


						//COMP_DISABILITY_DEATH_SUICIDE.setValue("Suicide exclusion within "+ suicideValue +" months from the policy start date to loss date");

						COMP_DISABILITY_DEATH_SUICIDE.setValue("Suicide exclusion is within "+ suicideValue +" months from the policy start date to loss date");
					}
                   
					/*else{
					COMP_DISABILITY_DEATH_SUICIDE.setValue("Suicide exclusion is within "+ suicideValue +" months from the policy start date to loss date");
				}*/

					/*End of ZBILQC-1732118*/		
				}else{
					System.out.println("Disability_type is not S");
					COMP_DISABILITY_DEATH_SUICIDE.setValue("Selected reason fall under excluded  reasons list.Do you want to proceed further?");
				}
				/*End*/
				
				getCOMP_REPORT_MODAL_PANEL_DISABILITY().setShowWhenRendered(true);
				/*compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON_LABEL().setRendered(true);
				 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setRendered(true);*/
				 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(false);
				 
				 /*added by raja on 13-05-2017*/
				 if(PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()!=null &&!PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP().equalsIgnoreCase("O"))
				 {
					 PT_IL_CLAIM_BEAN.setCLM_EXCL_YN("Y");
					 COMP_CLM_EXCL_YN.resetValue();
				 }
				 
				 /*end*/
				 
				 
				 }else{
					
					System.out.println("disablity type !equals of O");
					/*Added by saritha on 01-02-2017 for Disability Type (O)Others */
					getCOMP_REPORT_MODAL_PANEL_DISABILITY().setShowWhenRendered(false);
					/*End*/
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(true);
					/*compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON_LABEL().setRendered(false);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setRendered(false);*/
					PT_IL_CLAIM_BEAN.setCLAIM_EXCL_REASON("N");
					 COMP_CLAIM_REASON.resetValue();
					 
					 /*added by raja on 07-06-2017 for hands on points*/
					 PT_IL_CLAIM_BEAN.setCLM_EXCL_YN("N");
					 COMP_CLM_EXCL_YN.resetValue();
					 
					 compositeAction.getWizard().enableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().enableWizardItem("toDoGroup");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().enableWizardItem("reminders");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_REASON().setDisabled(true);
					  compositeAction.getWizard().enableWizardItem("claimCharge");
					
					/*end*/
				}
			
			
		 
			//PT_IL_CLAIM_BEAN.setCLAIM_EXCL_TYP((String)value);
					ResultSet resultSetClaimDisable = handler.executeSelectStatement(query1,
					CommonUtils.getConnection(),
					new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()});
					if(resultSetClaimDisable.next()){
					PT_IL_CLAIM_BEAN.setUI_M_CLAIM_EXCL_TYP_DESC(resultSetClaimDisable.getString("PC_DESC"));
					System.out.println("********************VALUE OF UI_M_CLAIM_EXCL_TYP_DESC********"+PT_IL_CLAIM_BEAN.getUI_M_CLAIM_EXCL_TYP_DESC());
					}
					
					ResultSet CHECK_CODE = handler.executeSelectStatement(query2,
							CommonUtils.getConnection(),
							new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()});
					if(CHECK_CODE.next()){
						flag=true;
					}

					if(!flag)
					{
						throw new Exception("Invalid Disability type");
					}
					
					
			COMP_CLAIM_DISABLITY.resetValue();
			COMP_UI_M_CLAIM_EXCL_TYP.resetValue();
			
			
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current",
						e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
				
			}
		}
	public List<LovBean> DISABILITY_TYPE_SUGGESTION_LIST(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
					"CLAIM_EXCL_TYP","IL_CLM_EXCL", null, null, null, null,
					(String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionList;
	}
	
	
	public void validRejection(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("*************enter into validRejection***");
			PT_IL_CLAIM_BEAN.setCLAIM_EXCL_REASON((String) value);
			System.out.println("*************value of CLAIM_EXCL_REASON***"+PT_IL_CLAIM_BEAN.getCLAIM_EXCL_REASON());
			COMP_CLAIM_REASON.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*added by gopi for hand on feed back point,serial no 15 in zb on 01/02/17*/
	public void validateDISEASES_REMARKS(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_DISEASES_REMARKS((String) value);
			COMP_CLAIM_DISEASES_REMARKS.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*end*/
	public String cancelModalPanelDelete(){
		  getCOMP_REPORT_MODAL_PANEL_DISABILITY().setShowWhenRendered(false);
			return "";
		}
	 
	  public void cancelModalPanelOK()
	  {
		  System.out.println("inside cancelModalPanelOK");
		  getCOMP_REPORT_MODAL_PANEL_DISABILITY().setShowWhenRendered(false);
		PT_IL_CLAIM_BEAN.setCLAIM_EXCL_REASON(null);
			 COMP_CLAIM_REASON.resetValue();
			 
/*added by raja on 13-05-2017*/
			 
			 PT_IL_CLAIM_BEAN.setCLM_EXCL_YN("Y");
			 COMP_CLM_EXCL_YN.resetValue();
			
			
			 if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()!=null)
			 {
			 compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.disableAllComponent(true);
			 /*end*/
			 
			 
	/*added by raja on 07-06-2017 for hands on points*/
			 
			// compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS("D05:- Claim Declined due to exclusions");
			  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
			  compositeAction.getWizard().disableWizardItem("toDoGroup");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
			  compositeAction.getWizard().disableWizardItem("reminders");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
			  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
			  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
			  compositeAction.getWizard().disableWizardItem("claimCharge");
			 
			  /*end*/
			  PT_IL_CLAIM_BEAN.setCLAIM_ADDL_STATUS("CL02");
			  compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()+" :- "+addilStatusDesc());
			  compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
				.disableAllComponent(true);
			 }
		   }
	 
	  public Boolean validate_Disability()
				throws Exception {
		  System.out.println("*******enter into validate_Disability***");
		
			String C1 ="SELECT 'X' FROM PM_CODES WHERE PC_TYPE = 'IL_CLM_EXCL' and NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE=?";
			ResultSet C1_REC = null;
			Boolean CHECK_CODE=false;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {PT_IL_CLAIM_BEAN.getCLAIM_EXCL_TYP()});
				if (C1_REC.next()) {
					CHECK_CODE =true;
				}
				

				if(!CHECK_CODE)
				{
					throw new Exception("Invalid Disability type");
				}
				
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of CHECK_CODE***"+CHECK_CODE);
			return CHECK_CODE;
			
		}
	  
	  	//end
		
		/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/

		private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DELETE;

		public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DELETE() {
			return COMP_REPORT_MODAL_PANEL_DELETE;
		}

		public void setCOMP_REPORT_MODAL_PANEL_DELETE(
				HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DELETE) {
			COMP_REPORT_MODAL_PANEL_DELETE = cOMP_REPORT_MODAL_PANEL_DELETE;
		}
		
		/*Added by saritha on 10-01-2017 method name changed*/
		public void OkModalPanelDelete() throws Exception{
			System.out.println("enter into the ok model panal");
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			
				
		}
		
		/*End*/
		/*Added by saritha on 10-01-2017 method name changed*/
		/*Commentted by saritha on 19-06-2017 for ssp call id ZBILQC-1718796*/
		/*public void CancelPanelDelete(){ 
			System.out.println("enter into the cancel model panal");
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			
			}*/
			/*End*/
		
		public void callChargeReportModalPanel_delete() throws Exception{
		
			//getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
			
		}
		
		/*End*/
	
		
		 /*Added By Janani on 3.01.2017 for DMS Integration*/
		
		public void callReportDmsModalPanel(ActionEvent event) {    
			 String input = event.getComponent().getId();
			 runAction_DMS();
			 try {
			
					 String dmsUrl = new DMSUtil().getDmsUrl();
					 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()" + dmsUrl);
					 setRedirectUrl(dmsUrl);
									

				 if (getRedirectUrl() != null) {
					 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
				 } else {
					 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
				 }

			 } catch (Exception e) {
				 e.printStackTrace();
			 }

		 }

		
		 public String runAction_DMS() {
			 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()");
			 try {

			 } catch (Exception e) {
				
			 }
			 return "";

		 }
		 
		 
			public String dms_runActionAfterValidate() {
				CommonUtils.clearMaps(this);
				HttpServletResponse response = null;
				
				try {
					if (getRedirectUrl() != null) {
						response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
						System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
						response.sendRedirect(getRedirectUrl());
					}
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
					getErrorMap().put("runAction", e.getMessage());
				}
				return null;
			}
		 
		 
		 
		 /*End*/
		 
		 /*Added by sankar on 16-02-2017 method name changed*/
			public void calldmsReportModalPanel(ActionEvent event) {     /*Added by sankar on 16-02-2017 method name changed*/
				 String input = event.getComponent().getId();
				 runAction_DMS();
				 try {
				
						 String dmsUrl = new DMSUtil().getDmsUrl();
						 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()" + dmsUrl);
						 setRedirectUrl(dmsUrl);
										

					 if (getRedirectUrl() != null) {
						 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
					 } else {
						 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
					 }

				 } catch (Exception e) {
					 e.printStackTrace();
				 }

			 }
		 
		 /*End*/
		 
		 
		 /*added by gopi for ssp call ZBILQC-1719136 and FSD_IL_ZB Life_012a on 20/01/17 */
	public String claim_history() throws Exception{
				
		String cs_status_code = null;
		Object[] values = null;
		Connection connection = null;
		ResultSet resultSet5 = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_CLAIM_STATUS statusBean = compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN(); 
		String CURSOR_C1="SELECT CS_STATUS_CODE FROM PT_IL_CLAIM_STATUS WHERE  CS_SYS_ID = (SELECT MAX(CS_SYS_ID) FROM PT_IL_CLAIM_STATUS WHERE  CS_CLM_SYS_ID = ?)";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()};
			resultSet5 = handler.executeSelectStatement(CURSOR_C1, connection, values);
			if(resultSet5.next()){
			cs_status_code = resultSet5.getString("CS_STATUS_CODE");
			}
			} catch (Exception e) {
					throw new Exception(e.getMessage());
				} 
				return cs_status_code;
			}
			//end
	
	/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
	public Double DISEASES_REMARK_PC_VALUE() throws Exception{
		
		Double PC_VALUE = null;
		Object[] values = null;
		Connection connection = null;
		ResultSet resultSet5 = null;
		CRUDHandler handler = new CRUDHandler();
		String CURSOR_C1="SELECT PC_VALUE FROM PM_CODES WHERE PC_TYPE = 'IL_DISEASES' AND PC_CODE= ? ";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_DISEASES_CODE()};
			resultSet5 = handler.executeSelectStatement(CURSOR_C1, connection, values);
			if(resultSet5.next()){
				PC_VALUE = resultSet5.getDouble("PC_VALUE");
			}
			} catch (Exception e) {
					throw new Exception(e.getMessage());
				} 
				return PC_VALUE;
			}
	/*END*/
	/*Added by saranya for Hands on Point no 11 on 04-02-2017*/
	private HtmlOutputLabel COMP_CLAIM_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_CLAIM_ASSRD_REF_ID1;
	
	public HtmlOutputLabel getCOMP_CLAIM_ASSRD_REF_ID1_LABEL() {
		return COMP_CLAIM_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_CLAIM_ASSRD_REF_ID1_LABEL(
			HtmlOutputLabel cOMP_CLAIM_ASSRD_REF_ID1_LABEL) {
		COMP_CLAIM_ASSRD_REF_ID1_LABEL = cOMP_CLAIM_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_ASSRD_REF_ID1() {
		return COMP_CLAIM_ASSRD_REF_ID1;
	}

	public void setCOMP_CLAIM_ASSRD_REF_ID1(HtmlInputText cOMP_CLAIM_ASSRD_REF_ID1) {
		COMP_CLAIM_ASSRD_REF_ID1 = cOMP_CLAIM_ASSRD_REF_ID1;
	}

	public ArrayList<LovBean> lovCLAIM_ASSRD_REF_ID1(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				
				/*modified by saranya for Hands on point num 11 on 10-02-2017*/
				/*query = "SELECT DISTINCT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER, PT_IL_POLICY " 
						+ "WHERE CUST_REF_ID1 IS NOT NULL AND POL_STATUS = 'A' "
			    		+ " AND CUST_CODE = POL_CUST_CODE AND  POL_DS_TYPE = '2' AND POL_ADDL_STATUS "
			    		+ " NOT IN ('R', 'S01', 'D01', 'S02', 'D03') AND ROWNUM <= ? ORDER BY 1";*/
				query = "SELECT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER WHERE EXISTS (SELECT 1 FROM PT_IL_POLICY WHERE POL_STATUS = 'A'"
						+ "AND CUST_CODE = POL_CUST_CODE AND POL_DS_TYPE = '2' AND "
						+ "POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03','D'))"
						+ "AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				/*query =  "SELECT DISTINCT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER, PT_IL_POLICY " 
						+ "WHERE (UPPER(CUST_REF_ID1) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?))"
			    		+ "AND CUST_REF_ID1 IS NOT NULL AND POL_STATUS = 'A' "
			    		+ " AND CUST_CODE = POL_CUST_CODE AND  POL_DS_TYPE = '2' AND POL_ADDL_STATUS "
			    		+ "NOT IN ('R', 'S01', 'D01', 'S02', 'D03') AND ROWNUM <= ? ORDER BY 1";*/
				query =  "SELECT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER WHERE EXISTS (SELECT 1 FROM PT_IL_POLICY WHERE  "
						+ "(UPPER(CUST_REF_ID1) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?))"
						+ "AND POL_STATUS = 'A'AND CUST_CODE = POL_CUST_CODE AND POL_DS_TYPE = '2' AND "
						+ "POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03','D'))"
						+ "AND ROWNUM <= ? ORDER BY 1";
				/*End*/
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void validatorCLAIM_ASSRD_REF_ID1(FacesContext context,
			UIComponent component, Object value) {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			String NewValue=(String) value;
			System.out.println("PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1()  :"+PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1());
			if(!NewValue.equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_ASSRD_REF_ID1()))
					{
						PT_IL_CLAIM_BEAN.setCLAIM_POL_NO(null);
						/*PT_IL_CLAIM_BEAN.setCLAIM_CUST_CODE(null);
						PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE(null);
						PT_IL_CLAIM_BEAN.setCLAIM_ACCNT_PAY_CODE(null);
						PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ASS_NAME(null);
						PT_IL_CLAIM_BEAN.setUI_M_CUST_DESC(null);
						PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(null);*/
						
					}
			COMP_CLAIM_POL_NO.resetValue();
			/*COMP_CLAIM_CUST_CODE.resetValue();
			COMP_CLAIM_ASSR_CODE.resetValue();
			COMP_CLAIM_ACCNT_PAY_CODE.resetValue();
			COMP_UI_M_CLAIM_ASS_NAME.resetValue();
			COMP_UI_M_CLAIM_ACCNT_PAY_CODE_DESC.resetValue();
			COMP_UI_M_CUST_DESC.resetValue();*/
			PT_IL_CLAIM_BEAN.setCLAIM_ASSRD_REF_ID1((String) value);
			COMP_CLAIM_ASSRD_REF_ID1.resetValue();
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	
	/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
public String runAction(){

Connection runActionConnection = null;


String url = null;
String POL_SYS_ID=null;
HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
System.out.println("url   :  "+url);
setRedirectUrl(url);

try{
runActionConnection = CommonUtils.getConnection();
if (IP_REP_INFO_BEAN.getROWID() == null) {
System.out.println("ENTER IP_REP_INFO_BEAN");

Connection connection = null;
ResultSet resultSet = null;
Object[] values = null;
POL_SYS_ID =String.valueOf(PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID());
PRE_INSERT(this.IP_REP_INFO_BEAN);
IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
		runActionConnection);
runActionConnection.commit();
}else {

PRE_UPDATE(this.IP_REP_INFO_BEAN);
//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
}



}catch(Exception e){
e.printStackTrace();
}
return "";



}

private String redirectUrl;

public String getRedirectUrl() {
return redirectUrl;
}

public void setRedirectUrl(String redirectUrl) {
this.redirectUrl = redirectUrl;
}

FacesContext context = FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest) context
.getExternalContext().getRequest();
HttpSession session = request.getSession();
public String runActionAfterValidate() {

CommonUtils.clearMaps(this);
HttpServletResponse response = null;
try {
String rep_template_name=null;
Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
	.getExternalContext().getSessionMap();
String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
//rep_template_name = new CommonReport().template_name(moduleId,"A","PREMIREP127");
//setRedirectUrl(new CommonReport().genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));

//		rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
//System.out.println("request.getServerName()  :"+request.getServerName());
setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP127&REPORT_TYPE=PREMIREP127&STATUS=A&MODULE_ID="+moduleId);
System.out.println("End");


if (getRedirectUrl() != null) {
response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
response.sendRedirect(getRedirectUrl());
}


} catch (Exception e) {
e.printStackTrace();
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
getErrorMap().put("runAction", e.getMessage());
}
return null;
}


public String callReportModalPanel(){
runAction();
if(redirectUrl!=null)
getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
else 
getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
return null;
}


/*End*/
	
	/*End*/
/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17*/
public static ArrayList<OracleParameter>getP_INS_CLM_CHARGES(Long claimSysId) throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, claimSysId);
	parameterList.add(param1);
	OracleProcedureHandler procHandler = new OracleProcedureHandler();
	outputList = procHandler.executeProc(parameterList, connection,
			"P9ILPK_CLAIM.P_INS_CLM_CHARGES");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
	throw new ProcedureException(e.getMessage());
}
return outputList;
}

public String check_table_insert() throws Exception{
	
	String check_value = null;
	Object[] values = null;
	Connection connection = null;
	ResultSet resultSet5 = null;
	CRUDHandler handler = new CRUDHandler();
	String CURSOR_C1="SELECT 'X' FROM PT_IL_CLAIM_CHARGES WHERE CC_CLM_SYS_ID =? ";
	try {
		connection = CommonUtils.getConnection();
		values = new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()};
		resultSet5 = handler.executeSelectStatement(CURSOR_C1, connection, values);
		if(resultSet5.next()){
			check_value = resultSet5.getString(1);
		}
		} catch (Exception e) {
				throw new Exception(e.getMessage());
			} 
	System.out.println("******************check_value-------------->"+check_value);
			return check_value;
		}
/*End*/
	
/*Added by R Raja on 24.01.2017 for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/
private HtmlOutputLabel COMP_CLAIM_MEMB_CODE_LABEL;

private HtmlInputText COMP_CLAIM_MEMB_CODE;
private HtmlInputText COMP_CLAIM_MEMB_CODE_DESC;


public HtmlInputText getCOMP_CLAIM_MEMB_CODE_DESC() {
	return COMP_CLAIM_MEMB_CODE_DESC;
}

public void setCOMP_CLAIM_MEMB_CODE_DESC(HtmlInputText cOMP_CLAIM_MEMB_CODE_DESC) {
	COMP_CLAIM_MEMB_CODE_DESC = cOMP_CLAIM_MEMB_CODE_DESC;
}

public HtmlOutputLabel getCOMP_CLAIM_MEMB_CODE_LABEL() {
	return COMP_CLAIM_MEMB_CODE_LABEL;
}

public void setCOMP_CLAIM_MEMB_CODE_LABEL(
		HtmlOutputLabel cOMP_CLAIM_MEMB_CODE_LABEL) {
	COMP_CLAIM_MEMB_CODE_LABEL = cOMP_CLAIM_MEMB_CODE_LABEL;
}

public HtmlInputText getCOMP_CLAIM_MEMB_CODE() {
	return COMP_CLAIM_MEMB_CODE;
}

public void setCOMP_CLAIM_MEMB_CODE(HtmlInputText cOMP_CLAIM_MEMB_CODE) {
	COMP_CLAIM_MEMB_CODE = cOMP_CLAIM_MEMB_CODE;
}



public List<LovBean> CLAIM_MEMB_CODE_SUGGESTION_LIST(Object event) {
	ListItemUtil itemUtil = new ListItemUtil();
	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	try {
		getPOL_SYS_ID(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(), PT_IL_CLAIM_BEAN, compositeAction
				.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		suggestionList = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
				"CLAIM_MEMB_CODE",PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(), null, null, null, null,
				(String) event);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
	}

	return suggestionList;
}

/*
 * 
 * MAEHOD CHANGED BY RAJA ON 31-07-2017 FOR WRONG VALIDATION
public void validatorCLAIM_MEMB_CODE(FacesContext context,
		UIComponent component, Object value) {*/
public void validatorCLAIM_MEMB_CODE(ActionEvent event){
	try {
		System.out.println("*************enter into CLAIM_MEMB_CODE***");
		/*added by raja on 07-03-2017 for funeral benefit fsd*/
		UIInput input = (UIInput) event.getComponent().getParent();
		String value=(String)COMP_CLAIM_MEMB_CODE.getSubmittedValue();
		String plantype=getPLAN_TYPE();
		int DependentCodeAvailable = 0 ;
		
		
		if(plantype!=null && !plantype.equalsIgnoreCase("H"))
		{
		helper.whenValidateCLAIM_MEMB_CODE(this, getPT_IL_CLAIM_BEAN(),
				value);
		}
		/*end*/
		PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE(value);
		System.out.println("*************value of CLAIM_MEMB_CODE***"+PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
		
		/* Newly Added By Dhinesh on 11.8.2017 for ssp call id   ZBILQC-1730139 */
		if(plantype!=null && plantype.equalsIgnoreCase("H"))
		{  
			if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_CLAIM_BEAN.getCLAIM_TYPE(), "X"), "D","A"))
			{
				DependentCodeAvailable = getMemberDependentCode(PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE());
			
			     if(DependentCodeAvailable == 1)
			     {
			    	 getWarningMap().put("current"," Please settle all pending Hospital Benefits before proceeding to Death (WOP) Claim ");
			     }else
			     { 
			    	 throw new Exception("Death (WOP) Claim is applicable only for the Main Member"); 
			    	 
			     }
				
				
			}
			
		}
		/* End */
		
		ErrorHelpUtil.validate(input, getErrorMap());
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put("current", e.getMessage());
		//throw new ValidatorException(new FacesMessage(e.getMessage()));
		
	}
}
/* Newly Added By Dhinesh on 11.8.2017 for ssp call id   ZBILQC-1730139 */
public int getMemberDependentCode(String code )
{
	int DependentCode=0;
	try{
		
	String query="SELECT Count(*) PFMD_MEMB_TYPE FROM PT_IL_POL_FUNERAL_MEMB_DTLS WHERE  PFMD_POL_SYS_ID  = ?   and  PFMD_MEMB_TYPE = 'MM' AND  PFMD_CUST_CODE = ?  ORDER BY PFMD_SYS_ID ";
	ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID() , code});
	while(resultset.next())
	{
		DependentCode=resultset.getInt("PFMD_MEMB_TYPE");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return DependentCode;
	
}

/*end*/



public String getPLAN_TYPE()
{
	String plantype=null;
	try{
		
		/*Modified by saritha on 03-11-2017 for ssp call id ZBLIFE-1445721*/
		//String query="select plan_type from pm_il_plan,pt_il_policy where pol_plan_code=plan_code and pol_sys_id="+PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()+"";
		String query="select plan_type from pm_il_plan,pt_il_policy where pol_plan_code=plan_code and pol_no='"+PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()+"'";
		/*End*/
	ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
	while(resultset.next())
	{
		plantype=resultset.getString("plan_type");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return plantype;
	
}
//Added by Ameen 

	public String callPrint(){
		String outcome="";
		outcome = "PILT006_APAC_PT_IL_CLAIM_PRINT";
		
		return outcome;
	}
	
	//End
	
	 
	
	/*Added by Janani on 07.04.2017 as per Girish suggestion for hands-on-feedback point Claims Entry- Setup*/
	
	private HtmlOutputLabel COMP_CLAIM_ICD_DISEASES_DTL_LABEL;
	
	private HtmlInputText COMP_CLAIM_ICD_DISEASES_DTL;
	
	private HtmlInputText COMP_UI_M_CLAIM_ICD_DISEASES_DTL;
		
	
	public HtmlOutputLabel getCOMP_CLAIM_ICD_DISEASES_DTL_LABEL() {
		return COMP_CLAIM_ICD_DISEASES_DTL_LABEL;
	}

	public void setCOMP_CLAIM_ICD_DISEASES_DTL_LABEL(
			HtmlOutputLabel cOMP_CLAIM_ICD_DISEASES_DTL_LABEL) {
		COMP_CLAIM_ICD_DISEASES_DTL_LABEL = cOMP_CLAIM_ICD_DISEASES_DTL_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_ICD_DISEASES_DTL() {
		return COMP_CLAIM_ICD_DISEASES_DTL;
	}

	public void setCOMP_CLAIM_ICD_DISEASES_DTL(
			HtmlInputText cOMP_CLAIM_ICD_DISEASES_DTL) {
		COMP_CLAIM_ICD_DISEASES_DTL = cOMP_CLAIM_ICD_DISEASES_DTL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_ICD_DISEASES_DTL() {
		return COMP_UI_M_CLAIM_ICD_DISEASES_DTL;
	}

	public void setCOMP_UI_M_CLAIM_ICD_DISEASES_DTL(
			HtmlInputText cOMP_UI_M_CLAIM_ICD_DISEASES_DTL) {
		COMP_UI_M_CLAIM_ICD_DISEASES_DTL = cOMP_UI_M_CLAIM_ICD_DISEASES_DTL;
	}

	public void validatorCLAIM_ICD_DISEASES_DTL(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_ICD_DISEASES_DTL((String) value);
			 			
			COMP_CLAIM_ICD_DISEASES_DTL.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public ArrayList<LovBean> lovCLAIM_ICD_DISEASES_DTL(Object object) {
		ArrayList<LovBean> suggestionList = null;
		
	  System.out.println("enters into lovCLAIM_ICD_DISEASES_DTL");
		
		
	  /*CHANGED BY RAJA ON 09-05-2017*/
		/*String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_ICD_CODE' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) AND ROWNUM < ?";*/
	  	String query1="SELECT MV.PC_CODE, MV.PC_DESC FROM (SELECT ROWNUM, PC_CODE, PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_ICD_CODE' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY PC_CODE ASC) MV WHERE ROWNUM <= ?";
		try {

			String currentValue = (String) object;
						
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	
	
	/*End*/
	/*added by sankara narayanan for Hospital cash plan on 26/04/2017*/
	private HtmlOutputLabel COMP_CLAIM_HOSP_ADDM_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_HOSP_ADDM_DT;
	
	private HtmlOutputLabel COMP_CLAIM_HOSP_DSCHG_DT_LABEL;

	private HtmlCalendar COMP_CLAIM_HOSP_DSCHG_DT;



	public HtmlOutputLabel getCOMP_CLAIM_HOSP_ADDM_DT_LABEL() {
		return COMP_CLAIM_HOSP_ADDM_DT_LABEL;
	}

	public void setCOMP_CLAIM_HOSP_ADDM_DT_LABEL(
			HtmlOutputLabel cOMP_CLAIM_HOSP_ADDM_DT_LABEL) {
		COMP_CLAIM_HOSP_ADDM_DT_LABEL = cOMP_CLAIM_HOSP_ADDM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_HOSP_ADDM_DT() {
		return COMP_CLAIM_HOSP_ADDM_DT;
	}

	public void setCOMP_CLAIM_HOSP_ADDM_DT(HtmlCalendar cOMP_CLAIM_HOSP_ADDM_DT) {
		COMP_CLAIM_HOSP_ADDM_DT = cOMP_CLAIM_HOSP_ADDM_DT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_HOSP_DSCHG_DT_LABEL() {
		return COMP_CLAIM_HOSP_DSCHG_DT_LABEL;
	}

	public void setCOMP_CLAIM_HOSP_DSCHG_DT_LABEL(
			HtmlOutputLabel cOMP_CLAIM_HOSP_DSCHG_DT_LABEL) {
		COMP_CLAIM_HOSP_DSCHG_DT_LABEL = cOMP_CLAIM_HOSP_DSCHG_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLAIM_HOSP_DSCHG_DT() {
		return COMP_CLAIM_HOSP_DSCHG_DT;
	}

	public void setCOMP_CLAIM_HOSP_DSCHG_DT(HtmlCalendar cOMP_CLAIM_HOSP_DSCHG_DT) {
		COMP_CLAIM_HOSP_DSCHG_DT = cOMP_CLAIM_HOSP_DSCHG_DT;
	}
	
	
	
	public void validateCLAIM_HOSP_DSCHG_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			Date Value = (Date)value;
			Date EFF_FM_DT = PT_IL_CLAIM_BEAN.getCLAIM_HOSP_ADDM_DT();
    		if(EFF_FM_DT !=null){
    			
    		if(Value!=null && Value.before(EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(Value!=null && Value.after(ConvertFunctions.to_date("31/12/2999", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    		}
			
			PT_IL_CLAIM_BEAN.setCLAIM_HOSP_DSCHG_DT(Value);
			COMP_CLAIM_HOSP_DSCHG_DT.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCLAIM_HOSP_ADDM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			Date Value = (Date)value;
	    	Date EFF_TO_DT = PT_IL_CLAIM_BEAN.getCLAIM_HOSP_DSCHG_DT();
	    	
	    		if(EFF_TO_DT!=null && EFF_TO_DT.before(Value)){
	    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
	    		}
	    		if(Value!=null && Value.before(ConvertFunctions.to_date("01/01/1900", PELConstants.dbDateFormat))){
	    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
	    		}
			
			
			PT_IL_CLAIM_BEAN.setCLAIM_HOSP_ADDM_DT(Value);
			COMP_CLAIM_HOSP_ADDM_DT.resetValue();
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	/*end*/
	
/*added by raja on 13-05-2017*/
	
	private HtmlOutputLabel COMP_CLM_EXCL_YN_LABEL;

	private HtmlSelectOneMenu COMP_CLM_EXCL_YN;

	private List<SelectItem> CLM_EXCL_YN_LIST;
	
	public List<SelectItem> getCLM_EXCL_YN_LIST() {
		return CLM_EXCL_YN_LIST;
	}

	public void setCLM_EXCL_YN_LIST(List<SelectItem> cLM_EXCL_YN_LIST) {
		CLM_EXCL_YN_LIST = cLM_EXCL_YN_LIST;
	}

	public HtmlOutputLabel getCOMP_CLM_EXCL_YN_LABEL() {
		return COMP_CLM_EXCL_YN_LABEL;
	}

	public void setCOMP_CLM_EXCL_YN_LABEL(HtmlOutputLabel cOMP_CLM_EXCL_YN_LABEL) {
		COMP_CLM_EXCL_YN_LABEL = cOMP_CLM_EXCL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLM_EXCL_YN() {
		return COMP_CLM_EXCL_YN;
	}

	public void setCOMP_CLM_EXCL_YN(HtmlSelectOneMenu cOMP_CLM_EXCL_YN) {
		COMP_CLM_EXCL_YN = cOMP_CLM_EXCL_YN;
	}

	/*end*/
	
	/*added by raja on 25-04-2017*/
	public boolean accessValidation() throws Exception
	{
		try
		{
			boolean accessFlag=false;
			int shareRatioSystemParam =0;	
			String flag=null;
		/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
		if(shareRatioSystemParam == 2){*/
		String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='MOD_EXCL_CLM'";
		ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(rs.next())
		{
			shareRatioSystemParam=rs.getInt("PS_VALUE");
		}
		if(shareRatioSystemParam == 2){
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();

			String userID=session.get("GLOBAL.M_USER_ID").toString();
			String queryUserApprSetup="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
					+ "ASD_FLAG = '2' AND ASD_CODE='MOD_EXCL_CLM' AND "
					+ "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
					+ "ASD_TO_PROD_CODE = ?";
			
			ResultSet UserApprSetup=new CRUDHandler().executeSelectStatement(queryUserApprSetup, CommonUtils.getConnection(), new Object[]{userID,
				getPROD_CODE(),
				getPROD_CODE()});
			
			while(UserApprSetup.next())
			{
				flag=UserApprSetup.getString("ASD_CHAR_VALUE");
			}
			
			if(flag!=null && flag.equalsIgnoreCase("N"))
			{
				accessFlag=false;
			}
			else
			{
				accessFlag=true;
			}
			
		}
		return accessFlag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public boolean statusAccessValidation() throws Exception
	{
		try
		{
			boolean accessFlag=false;
			int shareRatioSystemParam =0;	
			String flag=null;
		/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
		if(shareRatioSystemParam == 2){*/
		String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='MOD_EXCL_CLM'";
		ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(rs.next())
		{
			shareRatioSystemParam=rs.getInt("PS_VALUE");
		}
		if(shareRatioSystemParam == 2){
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();

			String userID=session.get("GLOBAL.M_USER_ID").toString();
			String queryUserApprSetup="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
					+ "ASD_FLAG = '2' AND ASD_CODE='MOD_EXCL_CLM' AND "
					+ "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
					+ "ASD_TO_PROD_CODE = ?";
			
			ResultSet UserApprSetup=new CRUDHandler().executeSelectStatement(queryUserApprSetup, CommonUtils.getConnection(), new Object[]{userID,
				getPROD_CODE(),
				getPROD_CODE()});
			
			while(UserApprSetup.next())
			{
				flag=UserApprSetup.getString("ASD_CHAR_VALUE");
			}
			
			if(flag!=null && flag.equalsIgnoreCase("N"))
			{
				accessFlag=false;
			}
			else
			{
				accessFlag=true;
			}
			
		}
		return accessFlag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	
	public String getPROD_CODE()
	{
		String plantype=null;
		try{
			
		String query="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID="+PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()+"";
		ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(resultset.next())
		{
			plantype=resultset.getString("POL_PROD_CODE");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return plantype;
		
	}
	
	
	
	public String addilStatusDesc() 
	{
		String desc=null;
		try
		{
		
		String Query="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ADDL_STAT' AND PS_CODE=?";
		ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_ADDL_STATUS()});
		while(rs.next())
		{
			desc=rs.getString("PS_CODE_DESC");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  desc;
		
	}
	
	/*end*/
	
	
	/*Added by Janani onb 16.06.2017 for ZBILQC-1723136*/
	
	public void validatorCreationDate(FacesContext context,
			UIComponent component, Object value) {
		try {
			
			System.out.println("enters into validatorCreationDate");
			
			helper.whenValidateCreatedDate((Date) value, compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			PT_IL_CLAIM_BEAN.setCLAIM_CR_DT((Date) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	
	/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
	Connection connection = null;
	ResultSet rs1Contest = null;
	ResultSet rs2Contest = null;
	public void checkContestabilityPeriod(HtmlModalPanel MODAL_PANEL_BINDING) throws Exception{
		int PLAN_CONT_PERIOD = 0;
		String POL_END_TYPE = null;
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN = compositeAction.getPT_IL_CLAIM_ACTION_BEAN();
		try{
		/*Commented by pidugu raj for Alliance IL since contestiblity period should limit to 3 months as per Abhilash and Customer
		 * String cont_period_query ="SELECT PLAN_CONT_PERIOD FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE=POL_PLAN_CODE AND POL_SYS_ID=?";
		connection = CommonUtils.getConnection();
		rs1Contest = new CRUDHandler().executeSelectStatement(cont_period_query, connection,
				new Object[] {PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
		if (rs1Contest.next()) {
			PLAN_CONT_PERIOD=rs1Contest.getInt(1);
			System.out.println("Contestability Period::::::::::::::::::::::::"+PLAN_CONT_PERIOD);
		}*/
		connection = CommonUtils.getConnection();
		Date M_POL_START_DT = dummyBean.getM_POL_START_DT();
		Date M_POL_END_DT =dummyBean.getM_POL_END_DT();
		Date CLAIM_LOSS_DT=PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT();
		
		/*Newly added by pidugu raj dt: 10-11-2020 for Claim Contestiblity period check*/
		Calendar calClaimLoss = Calendar.getInstance();
		calClaimLoss.setTime(CLAIM_LOSS_DT);
		String claimLossDate = calClaimLoss.get(Calendar.DATE) + "-" + (calClaimLoss.get(Calendar.MONTH) + 1) + "-" +calClaimLoss.get(Calendar.YEAR);
		int numberOfMonths = 0;
		String policyStartDate = new SimpleDateFormat("MM-dd-yyyy").format(M_POL_START_DT);
		
		
		numberOfMonths = helper.P_CLAIM_DATE_DIFF(claimLossDate, policyStartDate);
		/*End Newly added by pidugu raj dt: 10-11-2020 for Claim Contestiblity period check*/
		
			Calendar cal = Calendar.getInstance();
			cal.setTime(CLAIM_LOSS_DT);
			int claimYear = cal.get(Calendar.YEAR);
			Calendar cal1 = Calendar.getInstance();
			cal.setTime(M_POL_START_DT);
			int polYear = cal.get(Calendar.YEAR);
			int M_DIFF_DATE_POL=claimYear-polYear;
			System.out.println("M_DIFF_DATE_POL  ====  "+M_DIFF_DATE_POL);		

			String query1 = "SELECT POL_END_TYPE FROM PT_IL_POLICY WHERE POL_SYS_ID=? ";
			System.out.println("pol_sys_id****************"+PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
			
			rs2Contest = new CRUDHandler().executeSelectStatement(query1, connection,
					new Object[] {PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
			if (rs2Contest.next()) {
				POL_END_TYPE = rs2Contest.getString(1);
				System.out.println("Endorsement Type::::::::::::::::::::::::"+POL_END_TYPE);
			}
			
			String queryValidation = "SELECT CWP_TO_DAYS FROM PM_IL_CLM_WAIT_PERIOD WHERE CWP_COVER_CODE = ? AND CWP_LOSS_CODE = ?";
			ResultSet rs =new CRUDHandler().executeSelectStatement(queryValidation, connection,new Object[]{compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_COVER_CODE(),
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_LOSS_TYPE()}) ;
			int numberSetup = 0;
			if(rs.next()){
				numberSetup = rs.getInt(1);
			}
			
			if((POL_END_TYPE!=null)&&(POL_END_TYPE.equalsIgnoreCase("006")))
			{
				System.out.println(" end type equals of 006");

				cal = Calendar.getInstance();
				cal.setTime(CLAIM_LOSS_DT);
				int claimYears = cal.get(Calendar.YEAR);

				cal1 = Calendar.getInstance();
				cal.setTime(M_POL_END_DT);
				int endYear = cal1.get(Calendar.YEAR);

				int M_DIFF_DATE_END=claimYears-endYear;
				System.out.println("M_DIFF_DATE_END  ====  "+M_DIFF_DATE_END);
				
				/*if(M_DIFF_DATE_END<PLAN_CONT_PERIOD)
				{
					System.out.println("inside DIFF_DATE_END<PLAN_CONT_PERIOD ");*/	
				/*if(numberSetup > 0){
					if((numberOfMonths*30) > numberSetup){
						throw new Exception("The Claim is within the contestability period");
						MODAL_PANEL_BINDING.setShowWhenRendered(true);
						MODAL_PANEL_BINDING.resetValue();
						
					}
				}*/
			}
			else
			{
				System.out.println(" end type !equals of 006");
				/*if(numberSetup > 0){
					if((numberOfMonths*30) > numberSetup){
						throw new Exception("The Claim is within the contestability period");	
					}
				}*/
				

			}

		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}
		
	}
	
	/*End*/
	
	/*Added by saritha on 19-07-2017 for ssp call id ZBILQC-1732118*/
	private HtmlOutputText COMP_DISABILITY_DEATH_SUICIDE;

	public HtmlOutputText getCOMP_DISABILITY_DEATH_SUICIDE() {
		return COMP_DISABILITY_DEATH_SUICIDE;
	}

	public void setCOMP_DISABILITY_DEATH_SUICIDE(
			HtmlOutputText cOMP_DISABILITY_DEATH_SUICIDE) {
		COMP_DISABILITY_DEATH_SUICIDE = cOMP_DISABILITY_DEATH_SUICIDE;
	}
	
	 
		
		
	/*Modified by Janani on 30.08.2017 for ZBILQC-1732118*/

	/*public static double monthsBetween(Date d1, Date d2) */

	public static double monthsBetween(Date M_POL_START_DT, Date CLAIM_LOSS_DT)

	{  
		
		/* double AVERAGE_MILLIS_PER_MONTH = 365.24 * 24 * 60 * 60 * 1000 / 12;   
	    return (d2.getTime() - d1.getTime()) / AVERAGE_MILLIS_PER_MONTH;*/


		double M_PC_VALUE=0.0;
		ResultSet resultSet=  null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		
		System.out.println("M_POL_START_DT              "+M_POL_START_DT+"       CLAIM_LOSS_DT       "+CLAIM_LOSS_DT);
		
		try{
			connection = CommonUtils.getConnection();
			
			String query= " SELECT MONTHS_BETWEEN(TO_DATE(?,'DD/MM/RRRR'),TO_DATE(?,'DD/MM/RRRR')) FROM DUAL";

			resultSet = handler.executeSelectStatement(query,connection, new Object[]{CLAIM_LOSS_DT,M_POL_START_DT});

			while(resultSet.next())
			{
				M_PC_VALUE=resultSet.getDouble(1);
			}

			
			System.out.println("M_PC_VALUE              "+M_PC_VALUE);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return M_PC_VALUE;

	}

	/*End of ZBILQC-1732118*/
	
	public double getSuicideValue()
	{
		double M_PC_VALUE=0.0;
		ResultSet resultSet=  null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			String query= "SELECT PC_VALUE FROM PM_CODES WHERE PC_TYPE='IL_CLM_EXCL' AND PC_CODE='S'";
			
			resultSet = handler.executeSelectStatement(query,connection);

			while(resultSet.next())
			{
				M_PC_VALUE=resultSet.getDouble(1);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return M_PC_VALUE;
	}

	
	/*End*/
	
	/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
	private HtmlModalPanel COMP_BUS_REPORT_MODAL_PANEL;

	public HtmlModalPanel getCOMP_BUS_REPORT_MODAL_PANEL() {
		return COMP_BUS_REPORT_MODAL_PANEL;
	}

	public void setCOMP_BUS_REPORT_MODAL_PANEL(
			HtmlModalPanel cOMP_BUS_REPORT_MODAL_PANEL) {
		COMP_BUS_REPORT_MODAL_PANEL = cOMP_BUS_REPORT_MODAL_PANEL;
	}
	
	public String busRulButtonAction() {

		CommonUtils.clearMaps(this);

		String returnValue = null;
		try
		{
			
			new PT_IL_CLAIM_BUS_RULE_ERROR_MSG_DELEGATE()
			.executeSelectStatement(compositeAction);
			returnValue = businessModalPanel();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public String businessModalPanel() {
		 try {
			
			 System.out.println("inside businessModalPanel call------------------------");
			 setBlockFlag(true);				 
			 if(compositeAction.getPT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_IL_CLAIM_BUS_RULE_ERROR_MSG().size()>0)
			 {
			 compositeAction.getPT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN().onLoad(null);
			 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		 }
		 }catch (Exception e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 e.getMessage());
			 getErrorMap().put("ClaimModalPanel", e.getMessage());
		 }
		 return "";
	 }
	
	public String closeBusinessModalPanel() {
		 try {
			 
			 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		 } catch (Exception e) {
			
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 e.getMessage());
			 getErrorMap().put("ModalPanel", e.getMessage());
		 }
		 return "";
	 }
	
	/*End*/
	
	
	/*Added by saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
	private HtmlOutputLabel COMP_CLAIM_INT_MOBILE_LABEL;
	private HtmlInputText COMP_CLAIM_INT_MOBILE;
	private HtmlOutputLabel COMP_CLAIM_INT_EMAIL_LABEL;
	private HtmlInputText COMP_CLAIM_INT_EMAIL;

	public HtmlOutputLabel getCOMP_CLAIM_INT_MOBILE_LABEL() {
		return COMP_CLAIM_INT_MOBILE_LABEL;
	}

	public void setCOMP_CLAIM_INT_MOBILE_LABEL(
			HtmlOutputLabel cOMP_CLAIM_INT_MOBILE_LABEL) {
		COMP_CLAIM_INT_MOBILE_LABEL = cOMP_CLAIM_INT_MOBILE_LABEL;
	}
	

	public HtmlInputText getCOMP_CLAIM_INT_MOBILE() {
		return COMP_CLAIM_INT_MOBILE;
	}

	public void setCOMP_CLAIM_INT_MOBILE(HtmlInputText cOMP_CLAIM_INT_MOBILE) {
		COMP_CLAIM_INT_MOBILE = cOMP_CLAIM_INT_MOBILE;
	}
	
	public HtmlOutputLabel getCOMP_CLAIM_INT_EMAIL_LABEL() {
		return COMP_CLAIM_INT_EMAIL_LABEL;
	}

	public void setCOMP_CLAIM_INT_EMAIL_LABEL(
			HtmlOutputLabel cOMP_CLAIM_INT_EMAIL_LABEL) {
		COMP_CLAIM_INT_EMAIL_LABEL = cOMP_CLAIM_INT_EMAIL_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_INT_EMAIL() {
		return COMP_CLAIM_INT_EMAIL;
	}

	public void setCOMP_CLAIM_INT_EMAIL(HtmlInputText cOMP_CLAIM_INT_EMAIL) {
		COMP_CLAIM_INT_EMAIL = cOMP_CLAIM_INT_EMAIL;
	}
	

	public void validateCLAIM_INT_MOBILE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_INT_MOBILE((String) value);
			//COMP_CLAIM_INT_MOBILE.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateCLAIM_INT_EMAIL(FacesContext context,
			UIComponent component, Object value) {
		try {

			PT_IL_CLAIM_BEAN.setCLAIM_INT_EMAIL((String) value);
			//COMP_CLAIM_INT_EMAIL.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateCLAIM_REMARKS(FacesContext context,
			UIComponent component, Object value) {
		try {

			PT_IL_CLAIM_BEAN.setCLAIM_REMARKS((String) value);
			//COMP_CLAIM_INT_EMAIL.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	private String planType;

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	private String claimType;

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	
	/*End*/
	
	/*Added by saritha on 06-11-2017 for ssp call id ZBLIFE-1445282*/ 
	public void validatorAjaxCLAIM_MEMB_CODE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();
		memberCodeDefaulting(value);
		getCOMP_CLAIM_MEMB_CODE().resetValue();
		getCOMP_CLAIM_MEMB_CODE_DESC().resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}
	public void memberCodeDefaulting(String value) {
		Connection connection = null;
		ResultSet resultSet = null;
		String M_CUST_CODE= null;
		String M_CUST_NAME = null;
		String plan_type=null;

		try {

			connection = CommonUtils.getConnection();
			String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER,PT_IL_PRE_CLAIMS_INFO WHERE CUST_CODE = PCI_ASSRD_CODE AND PCI_REF_NO = ?";
			System.out.println("Ref No   :  "+PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO());
			Object[] Ref_No  = {PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO()};
			resultSet  =  new CRUDHandler().executeSelectStatement(query, connection,Ref_No);
			if (resultSet .next()) {
				M_CUST_CODE  = resultSet.getString(1);
				M_CUST_NAME  = resultSet.getString(2);

			}
			
			plan_type=getPlan_Type(value);
			
			if("L".equalsIgnoreCase(plan_type) || "H".equalsIgnoreCase(plan_type)){
				if(PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO()!=null){
					PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE(M_CUST_CODE);
					PT_IL_CLAIM_BEAN.setCLAIM_MEMB_CODE_DESC(M_CUST_NAME);

				}
				getCOMP_CLAIM_MEMB_CODE().setRequired(true);
			}
			else{
			getCOMP_CLAIM_MEMB_CODE().setDisabled(true);
			getCOMP_CLAIM_MEMB_CODE().setRequired(false);
			
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	public String getPlan_Type(String value)
	{
		String plantype=null;
		try{

			String query="select plan_type from pm_il_plan,pt_il_policy where pol_plan_code=plan_code and pol_no='"+value+"'";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while(resultset.next())
			{
				plantype=resultset.getString("plan_type");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return plantype;

	}
	
	/*End*/
	/*Added by ganesh on 16-12-2017 as suggested by anbarasi*/
	public void checkWOPAloneOrNot() throws Exception
	{
		String coverClass = null;
		ResultSet rstWOP = null;
		int count = 0;
		try{			
			String query="SELECT COVER_CLASS FROM PM_IL_COVER,PT_IL_CLAIM_COVER_DTLS WHERE COVER_CODE = CCD_COVER_CODE AND CCD_CLAIM_SYS_ID = ?";
			rstWOP=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CLAIM_SYS_ID()});
			while(rstWOP.next())
			{
				coverClass = rstWOP.getString(1);
				count = count +1;
			}
			if(count==1){
				if(coverClass.equalsIgnoreCase("W")){
					/*Modified by ganesh on 19-12-2017 as suggested by thiags in mail */
					//throw new Exception("Approval is not applicable for this claim");
					throw new Exception("Status change not applicable for this claim");
					/*end*/
				}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(rstWOP);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		

	}	
	
	/*added by gopinfor toi on 26/05/2018*/
	public String getBeneficiary_as_customer() {

		 String Benef_cust_flag = null;
		 Connection connection = null;
		 ResultSet rs = null;
		String query="SELECT PROD_BENF_AS_CUST_YN FROM PM_IL_PRODUCT, PT_IL_POLICY WHERE "
				+ "PROD_CODE = POL_PROD_CODE AND POL_NO=? ";	
			try {
		
			 connection = CommonUtils.getConnection();
			 rs = new CRUDHandler().executeSelectStatement(query, connection,
					 new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()});
			 if(rs.next()) {
				 Benef_cust_flag = rs.getString(1);
			 }
			
			} catch (Exception e) {
			 e.printStackTrace();
		 } 
		 return Benef_cust_flag;
	 }
	
	//end
	/*Added by Sivarajan on 30/04/2021 for Allaince IL*/
	private HtmlOutputLabel COMP_CLAIM_DTH_CERTI_NO_LABEL;

	private HtmlInputText COMP_CLAIM_DTH_CERTI_NO;
	
	private HtmlOutputLabel COMP_CLAIM_BURIAL_PERMIT_NO_LABEL;

	private HtmlInputText COMP_CLAIM_BURIAL_PERMIT_NO;


	public HtmlOutputLabel getCOMP_CLAIM_DTH_CERTI_NO_LABEL() {
		return COMP_CLAIM_DTH_CERTI_NO_LABEL;
	}

	public void setCOMP_CLAIM_DTH_CERTI_NO_LABEL(
			HtmlOutputLabel cOMP_CLAIM_DTH_CERTI_NO_LABEL) {
		COMP_CLAIM_DTH_CERTI_NO_LABEL = cOMP_CLAIM_DTH_CERTI_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_DTH_CERTI_NO() {
		return COMP_CLAIM_DTH_CERTI_NO;
	}

	public void setCOMP_CLAIM_DTH_CERTI_NO(HtmlInputText cOMP_CLAIM_DTH_CERTI_NO) {
		COMP_CLAIM_DTH_CERTI_NO = cOMP_CLAIM_DTH_CERTI_NO;
	}

	public HtmlOutputLabel getCOMP_CLAIM_BURIAL_PERMIT_NO_LABEL() {
		return COMP_CLAIM_BURIAL_PERMIT_NO_LABEL;
	}

	public void setCOMP_CLAIM_BURIAL_PERMIT_NO_LABEL(
			HtmlOutputLabel cOMP_CLAIM_BURIAL_PERMIT_NO_LABEL) {
		COMP_CLAIM_BURIAL_PERMIT_NO_LABEL = cOMP_CLAIM_BURIAL_PERMIT_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_BURIAL_PERMIT_NO() {
		return COMP_CLAIM_BURIAL_PERMIT_NO;
	}

	public void setCOMP_CLAIM_BURIAL_PERMIT_NO(
			HtmlInputText cOMP_CLAIM_BURIAL_PERMIT_NO) {
		COMP_CLAIM_BURIAL_PERMIT_NO = cOMP_CLAIM_BURIAL_PERMIT_NO;
	}
	
	
	public void validateCLAIM_BURIAL_PERMIT_NO(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_BURIAL_PERMIT_NO((String) value);
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			System.out.println("inside validatorPCI_REF_NO"+e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCLAIM_DTH_CERTI_NO(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_CLAIM_BEAN.setCLAIM_DTH_CERTI_NO((String) value);
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			System.out.println("inside validatorPCI_REF_NO"+e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*End*/
	/*added by gopinfor Alliance on 31/10/2022*/
	public String ValidatePolNo() {

		 String POLFLAG = null;
		 Connection connection = null;
		 ResultSet rs = null;
		String query="SELECT SMV_TYPE FROM PT_IL_SURR_MAT_VALUES WHERE SMV_TYPE IN ('P','S','M') AND SMV_POL_SYS_ID= "
				+ "(SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO= ? )";	
			try {
		
			 connection = CommonUtils.getConnection();
			 rs = new CRUDHandler().executeSelectStatement(query, connection,new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()});
			 if(rs.next()) {
				 POLFLAG = rs.getString(1);
			 }

			} 
				catch (Exception e) {
			 e.printStackTrace();
		 }
			return POLFLAG; 
		 
	 }
}
package com.iii.pel.forms.PILT004;

import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonReportAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction
{
	
	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlSelectOneMenu  COMP_UI_M_SCHEDULE_TYPE;


	private HtmlOutputLabel COMP_UI_LOAN_REF_NO_LABEL;
	private HtmlInputText  COMP_UI_LOAN_REF_NO;
	
	/*private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	
	
	
	
	
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}*/

	private PRINT_HELPER helper;
	public PT_IL_LOAN_ACTION compositeAction;
	
	private String UI_SCHEDULE_TYPE;

	public String getUI_SCHEDULE_TYPE() {
		return UI_SCHEDULE_TYPE;
	}

	public void setUI_SCHEDULE_TYPE(String uI_SCHEDULE_TYPE) {
		UI_SCHEDULE_TYPE = uI_SCHEDULE_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_LOAN_REF_NO_LABEL() {
		return COMP_UI_LOAN_REF_NO_LABEL;
	}

	/*public void setCOMP_UI_LOAN_REF_NO_LABEL(
			HtmlOutputLabel cOMP_UI_LOAN_REF_NO_LABEL) {
		COMP_UI_LOAN_REF_NO_LABEL = cOMP_UI_LOAN_REF_NO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return getCOMP_UI_M_SCHEDULE_TYPE();
	}*/

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
	
		
		COMP_UI_M_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}

	public PRINT_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PRINT_HELPER helper) {
		this.helper = helper;
	}

	public PT_IL_LOAN_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PT_IL_LOAN_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	StringBuffer url=null;

	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	
	public PRINT_ACTION() throws Exception {
		
		System.out.println(" PILT004 Enter the PRINT_ACTION Constructor");
		helper=new PRINT_HELPER();
		getListUI_M_SCHEDULE_TYPE();
	
	
	
	}
	


	

	
	

	public HtmlOutputLabel getCOMP_UI_SCHEDULE_TYPE_LABEL() {
		return COMP_UI_SCHEDULE_TYPE_LABEL;
	}

	public void setCOMP_UI_SCHEDULE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_SCHEDULE_TYPE_LABEL) {
		COMP_UI_SCHEDULE_TYPE_LABEL = cOMP_UI_SCHEDULE_TYPE_LABEL;
	}

	
	public HtmlInputText getCOMP_UI_LOAN_REF_NO() {
		return COMP_UI_LOAN_REF_NO;
	}

	public void setCOMP_UI_LOAN_REF_NO(HtmlInputText cOMP_UI_LOAN_REF_NO) {
		COMP_UI_LOAN_REF_NO = cOMP_UI_LOAN_REF_NO;
	}

	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() {
		
		listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPE_LIST();
		
		return listUI_M_SCHEDULE_TYPE;
	}

	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_SCHEDULE_TYPE((String)value);


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPE_LIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_QUESTIONNAIRE_TYPELIST   *****************");
			
			selectItem = new SelectItem();
			selectItem.setLabel("LOAN REVIEW SHEET");
			selectItem.setValue("LOAN_REVIEW_SHEET");
			list.add(selectItem);
						
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
		}
	
	

	
	
	public void onLoad(PhaseEvent event)
	{
		try{
			
			System.out.println("*********** PILT002_APAC   Print Action onLoad *************");
			System.out.println("compositeAction.getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID()   : "+compositeAction.getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID());
		
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public String backButton(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String pathContext = request.getContextPath();
		String requestUrl = request.getRequestURL().toString();
		System.out.println("Context path----/"+pathContext);
		System.out.println("Request Url---/"+requestUrl);
		return "PILT004_PT_IL_LOAN";
	}
	
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
		
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	


	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			
			String LOAN_POL_SYS_ID =compositeAction.getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID().toString();
			
			url=new StringBuffer(getRedirectUrl());
			url.append("LOANREVIEWSHEET="+getUI_SCHEDULE_TYPE());
			url.append("&LOAN_POL_SYS_ID="+LOAN_POL_SYS_ID);
			
			setRedirectUrl(url.toString());
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
	
	
	

	public String printButtonAction() {
		String outcome = null;
		try {
			outcome = "PILT004_PRINT";
		} catch (Exception exception) {
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SCHEDULE_TYPE() {
		return COMP_UI_M_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_M_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_M_SCHEDULE_TYPE) {
		COMP_UI_M_SCHEDULE_TYPE = cOMP_UI_M_SCHEDULE_TYPE;
	}
	

	
	 /*Added By Janani on 3.01.2017 for DMS Integration*/
	
	
	
	 public void callReportModalPanel(ActionEvent event) {
		 String input = event.getComponent().getId();
		 runAction_DMS();
		 try {
		
				 String dmsUrl = new DMSUtil().getDmsUrl();
				 System.out.println("PRINT_ACTION_LOAN.invokeDMS()" + dmsUrl);
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
		 System.out.println("PRINT_ACTION_LOAN.invokeDMS()");
		 try {

		 } catch (Exception e) {
			
		 }
		 return "";

	 }
	 
	 /*End*/
	
	
}

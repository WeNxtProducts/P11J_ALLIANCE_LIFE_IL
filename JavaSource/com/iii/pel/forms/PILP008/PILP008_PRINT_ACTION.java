package com.iii.pel.forms.PILP008;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT007.PT_IL_CLAIM_ACTION;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILP008_PRINT_ACTION extends CommonReportAction{
	
	private PILT007_COMPOSITE_ACTION pilt007CompositeAction;
	public PILP008_DUMMY_ACTION compositeDummyAction;
	public PILT007_COMPOSITE_ACTION getPilt007CompositeAction() {
		return pilt007CompositeAction;
	}

	public void setPilt007CompositeAction(
			PILT007_COMPOSITE_ACTION pilt007CompositeAction) {
		this.pilt007CompositeAction = pilt007CompositeAction;
	}


	private HtmlOutputLabel COMP_UI_M_CLAIM_REPORT_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_CLAIM_REPORT;	
	String CLAIM_STATUS="";
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("FalconReports");
	
	private List<SelectItem> listUI_M_CLAIM_REPORT_TYPE = new ArrayList<SelectItem>();
	
	
	public HtmlOutputLabel getCOMP_UI_M_CLAIM_REPORT_LABEL() {
		return COMP_UI_M_CLAIM_REPORT_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_REPORT_LABEL(
			HtmlOutputLabel cOMP_UI_M_CLAIM_REPORT_LABEL) {
		COMP_UI_M_CLAIM_REPORT_LABEL = cOMP_UI_M_CLAIM_REPORT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_CLAIM_REPORT() {
		return COMP_UI_M_CLAIM_REPORT;
	}

	public void setCOMP_UI_M_CLAIM_REPORT(HtmlSelectOneMenu cOMP_UI_M_CLAIM_REPORT) {
		COMP_UI_M_CLAIM_REPORT = cOMP_UI_M_CLAIM_REPORT;
	}

	public List<SelectItem> getListUI_M_CLAIM_REPORT_TYPE() {
		return listUI_M_CLAIM_REPORT_TYPE;
	}

	public void setListUI_M_CLAIM_REPORT_TYPE(
			List<SelectItem> listUI_M_CLAIM_REPORT_TYPE) {
		this.listUI_M_CLAIM_REPORT_TYPE = listUI_M_CLAIM_REPORT_TYPE;
	}
		
	private String UI_M_CLAIM_REPORT;

	public String getUI_M_CLAIM_REPORT() {
		return UI_M_CLAIM_REPORT;
	}

	public void setUI_M_CLAIM_REPORT(String uI_M_CLAIM_REPORT) {
		UI_M_CLAIM_REPORT = uI_M_CLAIM_REPORT;
	}

	

	public PILP008_PRINT_ACTION() {
		// TODO Auto-generated constructor stub
		pilt007CompositeAction = (PILT007_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT007_COMPOSITE_ACTION");
	}
	
	private void prepareDropDowns(){
		try{

			listUI_M_CLAIM_REPORT_TYPE=(CommonReportAction.getDropDownListValue( CommonUtils.getConnection(),CLAIM_STATUS, 
					"CLM","C"));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	
	public void onLoad(PhaseEvent event){
		CommonUtils.clearMaps(this);
		
	
}
	
	public void validatorUI_M_CLAIM_REPORT(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_CLAIM_REPORT((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_CLAIM_REPORT());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String backButton() {
		
		return "PILT006_APAC_PT_IL_CLAIM";
	}
	
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
		
			setRedirectUrl(WHEN_BUTTON_PRESSED_M_BUT_OK());
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	StringBuffer url=null;
	
public String runActionAfterValidate() {
	PT_IL_CLAIM_ACTION ptil007ClaimAction = pilt007CompositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		try{
			HttpServletResponse response = null;
		Long CLAIM_SYS_ID = ptil007ClaimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		Long CLAIM_POL_SYS_ID = ptil007ClaimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		System.out.println("PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()   : "+CLAIM_SYS_ID);
		String report_id = resourceBundle.getString("ClaimCreditNote");
				
		IP_REP_INFO repInfo = new IP_REP_INFO();
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		repInfo.setREP_VALUE_1("3");
		repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+CLAIM_SYS_ID);
		repInfo.setREP_VALUE_3("CLAIM_POL_SYS_ID"+"&&&"+CLAIM_POL_SYS_ID);//added for claim_credit_note
		
		Connection conn = CommonUtils.getConnection();
		int ins = new CRUDHandler().executeInsert(repInfo, conn);
		conn.commit();
		System.out.println("Claim report_id ::" + report_id);
		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+report_id);	
		setRedirectUrl(url.toString());	
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	/*END*/
	//Added by Ameen
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
			
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		/*url = request.getContextPath() + "/ReportServlet?";*/
		url = "http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath() + "/PREMIASchedule?";
		System.out.println("url   :  "+url);
	return url;	
	}
		

}

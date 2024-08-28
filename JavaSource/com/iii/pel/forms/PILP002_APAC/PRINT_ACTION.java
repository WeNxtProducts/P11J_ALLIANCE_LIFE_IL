package com.iii.pel.forms.PILP002_APAC;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction {

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("FalconReports");

	PILT002_APAC_COMPOSITE_ACTION PILT002_compositeAction;
	COMPOSITE_ACTION_BEAN compositeAction;
	private IP_REP_INFO IP_REP_INFO_BEAN;
	private String UI_REPORT_TYPE;
	private String POL_APPRV_STATUS;
	private String POL_SYS_ID;
	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public String getUI_REPORT_TYPE() {
		return UI_REPORT_TYPE;
	}

	public void setUI_REPORT_TYPE(String uI_REPORT_TYPE) {
		UI_REPORT_TYPE = uI_REPORT_TYPE;
	}

	public PRINT_ACTION() {
		PILT002_compositeAction = (PILT002_APAC_COMPOSITE_ACTION) CommonUtils
				.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
		PT_IL_POLICY_BEAN = PILT002_compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		IP_REP_INFO_BEAN = new IP_REP_INFO();

	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
		}
		return connection;
	}

	

	public void onLoad(PhaseEvent event) {

	}

	public String WHEN_BUTTON_PRESSED_DOC_REPORT() {
		System.out.println("*******Get the XDOCSchedule URL******** ");
		String url = null;

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		System.out.println("request.getServerName() : "+ request.getServerName());
		System.out.println("request.getServerPort() : "+ request.getServerPort());
		url = "http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath()
				+ "/XDocSchedule?";
		System.out.println("XDocSchedule URL:  " + url);
		return url;
	}

	public String runAction() {
		
		Connection runActionConnection = null;
		try {
			
			System.out.println("Inside Runaction");
			runActionConnection = getConnection();
			POL_SYS_ID = PT_IL_POLICY_BEAN.getPOL_SYS_ID().toString();
			System.out.println("inside runaction validation " + POL_SYS_ID);

			setRedirectUrl(WHEN_BUTTON_PRESSED_DOC_REPORT());

			if (IP_REP_INFO_BEAN.getROWID() == null) {
				
				System.out.println("ENTER IP_REP_INFO_BEAN");
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				IP_REP_INFO_BEAN.setREP_VALUE_2(PT_IL_POLICY_BEAN
						.getPOL_DS_TYPE());

				int recordCount = new CRUDHandler().executeInsert(
						IP_REP_INFO_BEAN, runActionConnection);
				System.out.println("IP_REP_TABLE insert count -- ["
						+ recordCount + "]");
				runActionConnection.commit();
			} else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				// IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}

	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;

		try {

			Connection con = null;
			ResultSet resultSet = null;
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleID = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			/*String scheduleReportType = resourceBundle
					.getString("EMAIL_SCHEDULED_"
							+ PT_IL_POLICY_BEAN.getPOL_PROD_CODE());*/
			String scheduleReportType = fetchReportKey(moduleID,PT_IL_POLICY_BEAN.getPOL_PROD_CODE());
			System.out.println("Report with product type-->["
					+ scheduleReportType + "]");
			setUI_REPORT_TYPE(scheduleReportType);

			System.out
					.println("******************ENTERING INTO runActionAfterValidate *******************");

			

			String rep_template_name = null;
			POL_APPRV_STATUS = PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS();

			String polDStype = PT_IL_POLICY_BEAN.getPOL_DS_TYPE();

			System.out.println("POL_APPRV_STATUS        " + POL_APPRV_STATUS
					+ "         polDStype         " + polDStype
					+ "      typevalue       " + getUI_REPORT_TYPE());

			rep_template_name = "&REP_ID=" + getUI_REPORT_TYPE()
					+ "&REP_KEY_NO=" + IP_REP_INFO_BEAN.getREP_KEY_NO()
					+ "&MODULE_ID=" + moduleID + "&STATUS=A&REPORT_TYPE="
					+ getUI_REPORT_TYPE();
			
			setRedirectUrl(getRedirectUrl() + rep_template_name);
			

			System.out.println("getRedirectUrl()   : " + getRedirectUrl());
			System.out.println("rep_template_name "+ rep_template_name);

			/*
			 * if(rep_template_name == null) { throw new
			 * Exception((Messages.getString( PELConstants.pelErrorMessagePath,
			 * "77775", new Object[]{"Not a valid report"}))); } else
			 * if(CommonUtils.getGlobalVariable("reporttype")!=null &&
			 * CommonUtils.getGlobalVariable("reporttype").equals("view")) {
			 * 
			 * if (getRedirectUrl() != null) { response = (HttpServletResponse)
			 * FacesContext
			 * .getCurrentInstance().getExternalContext().getResponse();
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * System.out.println("getRedirectUrl FOR mdocs "+getRedirectUrl());
			 * 
			 * response.sendRedirect(getRedirectUrl());
			 * 
			 * 
			 * } }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}

	

	public void PRE_INSERT(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {

			IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_MODULE_ID")); // GL-010013
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Added by Ganesh on 02/03/2017 for Mail attachment */
	public String sendGet(String redirectURL, String productCode,
			String mailSendTo,String emailTemplateType) throws DBException, Exception {

		System.out.println("Redirect URL--->" + redirectURL);
		URL obj = new URL(redirectURL);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		StringBuffer response = new StringBuffer();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {

			String outPutFileName = System.getProperty("java.io.tmpdir")
					+ IP_REP_INFO_BEAN.getREP_KEY_NO() + ".pdf";
			System.out.println("Attachment file path---->" + outPutFileName);			
			response.append(Email_Procedure_Call.emailStatusMsg(productCode,
					emailTemplateType, CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
							.toString(), mailSendTo, outPutFileName));
		} else {
			System.out.println("GET request not worked");
			response.append("Unable to send the email");
		}

		return response != null ? response.toString() : "";
	}
	/* End */

	public String fetchReportKey(String moduleId, String productCode)throws Exception
	{

		System.out.println("Fetch REP ID value");
		Connection connection = null;
		ResultSet resultSet = null;
		String PMRTH_REP_ID = null;
		CRUDHandler handler = null;

		try {
			connection = getConnection();
			handler = new CRUDHandler();
			System.out.println("moduleId          		:" + moduleId);
			System.out.println("productCode        :" + productCode);
			String query = "SELECT PMRTH_REP_ID FROM PM_REP_TAB_HDR,pm_rep_tab_DTL WHERE PMRTH_MODULE_ID = ? AND PMRTH_REP_STATUS = 'A' AND PMRTH_MAIL_ATTACH_REQD = 'Y' AND PMRTH_REP_CATG = 'S' AND PMLIT_PROD_CODE = ? AND PMRTH_REP_ID = PMLIT_KEY";

			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { moduleId,productCode });
			while (resultSet.next()) {
				PMRTH_REP_ID = resultSet.getString("PMRTH_REP_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		

		return PMRTH_REP_ID;
	}
	
	
}

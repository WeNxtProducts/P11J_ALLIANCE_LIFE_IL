package com.iii.pel.forms.PILQ138;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PREMIUM_ENQU_ACTION extends CommonAction {
	
	public PILQ138_COMPOSITE_ACTION compositeAction;
	
	private PREMIUM_ENQU_HELPER helper;
	
	private PREMIUM_ENQU PREMIUM_ENQU_BEAN;
	
	
	
	private List<PREMIUM_ENQU> dataList_PREMIUM_ENQU = new ArrayList<PREMIUM_ENQU>();

	private UIData dataTable;
	
	/*private HtmlCommandButton COMP_QUERY;*/
	
	private HtmlAjaxCommandButton COMP_QUERY;
	
	
	
	
//	public HtmlCommandButton getCOMP_QUERY() {
//		return COMP_QUERY;
//	}
//
//	public void setCOMP_QUERY(HtmlCommandButton cOMP_QUERY) {
//		COMP_QUERY = cOMP_QUERY;
//	}

	private HtmlCommandButton COMP_UI_PRINT_BUTTON;
	public HtmlCommandButton getCOMP_UI_PRINT_BUTTON() {
		return COMP_UI_PRINT_BUTTON;
	}

	public void setCOMP_UI_PRINT_BUTTON(HtmlCommandButton cOMP_UI_PRINT_BUTTON) {
		COMP_UI_PRINT_BUTTON = cOMP_UI_PRINT_BUTTON;
	}

	private HtmlOutputLabel COMP_POL_NO_LABEL;
	public HtmlAjaxCommandButton getCOMP_QUERY() {
		return COMP_QUERY;
	}

	public void setCOMP_QUERY(HtmlAjaxCommandButton cOMP_QUERY) {
		COMP_QUERY = cOMP_QUERY;
	}


	private HtmlInputText COMP_POL_NO;
	
	public PREMIUM_ENQU_ACTION()
	{
		helper=new PREMIUM_ENQU_HELPER();
		PREMIUM_ENQU_BEAN=new PREMIUM_ENQU();
		IP_REP_INFO_BEAN=new IP_REP_INFO();
	}

	public PREMIUM_ENQU_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PREMIUM_ENQU_HELPER helper) {
		this.helper = helper;
	}

	public PREMIUM_ENQU getPREMIUM_ENQU_BEAN() {
		return PREMIUM_ENQU_BEAN;
	}

	public void setPREMIUM_ENQU_BEAN(PREMIUM_ENQU pREMIUM_ENQU_BEAN) {
		PREMIUM_ENQU_BEAN = pREMIUM_ENQU_BEAN;
	}

	public List<PREMIUM_ENQU> getDataList_PREMIUM_ENQU() {
		return dataList_PREMIUM_ENQU;
	}

	public void setDataList_PREMIUM_ENQU(List<PREMIUM_ENQU> dataList_PREMIUM_ENQU) {
		this.dataList_PREMIUM_ENQU = dataList_PREMIUM_ENQU;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel cOMP_POL_NO_LABEL) {
		COMP_POL_NO_LABEL = cOMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO(HtmlInputText cOMP_POL_NO) {
		COMP_POL_NO = cOMP_POL_NO;
	}
	
	
	public void instantiateAllComponent() 
	{ 
		COMP_POL_NO=new HtmlInputText();
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				System.out.println("onload is called");
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void validatorPOLNO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PREMIUM_ENQU_BEAN.setUI_M_POL_NO(value.toString());
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List<LovBean> lovAction(Object value) {
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();

		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILT003_APAC", "PT_IL_POLICY",
					"POL_NO", "A", null, null, null, null, (String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareLovCommCode", e.getMessage());
		}
		return list;
	}
	
	public void fetchBtnAction() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			
			double total=0.0;
				helper.executeQuery(compositeAction);
				if(this.getDataList_PREMIUM_ENQU().size()>0)
				{
				for(PREMIUM_ENQU bean : this.getDataList_PREMIUM_ENQU())
				{
					total=total+bean.getUI_M_NET_PRE();	
				}
				}
				PREMIUM_ENQU_BEAN.setUI_M_TOT_AMT(total);
		} catch (Exception e) {
			
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}
	
private String redirectUrl;
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
private IP_REP_INFO IP_REP_INFO_BEAN;
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO iP_REP_INFO_BEAN) {
		IP_REP_INFO_BEAN = iP_REP_INFO_BEAN;
	}
	
	public String callReportModalPanel(){
		runAction();
		if(redirectUrl!=null)
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		else 
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return null;
	}

	public String runAction(){

		Connection runActionConnection = null;
		String Query="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		ResultSet resultSetsys_id = null;
		
		String url = null;
		String POL_SYS_ID=null;
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		System.out.println("url   :  "+url);
		setRedirectUrl(url);

		try{
			runActionConnection = CommonUtils.getConnection();
			resultSetsys_id=new CRUDHandler().executeSelectStatement(Query, runActionConnection, new 
					Object[]{PREMIUM_ENQU_BEAN.getUI_M_POL_NO()});
			while(resultSetsys_id.next())
			{
				POL_SYS_ID =resultSetsys_id.getString("POL_SYS_ID");
			}
			
			
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN,POL_SYS_ID);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				


/*added  by raja on 23-05-2017*/ 
				int recordCount = new CRUDHandler().executeUpdate(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
				
				/*end*/
			}



		}catch(Exception e){
			e.printStackTrace();
		}
		return "";



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
			setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP507&REPORT_TYPE=PREMIREP507&STATUS=A&MODULE_ID="+moduleId);
			
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

	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN,String POL_SYS_ID) {

		try {
			

IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
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
	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}
	
}

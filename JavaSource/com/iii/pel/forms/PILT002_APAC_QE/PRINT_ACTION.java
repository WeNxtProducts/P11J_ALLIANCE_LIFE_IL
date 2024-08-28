package com.iii.pel.forms.PILT002_APAC_QE;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PRINT_ACTION extends CommonReportAction
{
  private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("FalconReports");
 // String ScheduleReportType = resourceBundle.getString("ScheduleReportType");
  private PRINT_HELPER helper;
  private HtmlCommandLink COMP_QQAT_PRINT;
  private HtmlCommandButton COMP_POL_PRINT1;
  private HtmlOutputLabel COMP_QUOT_REPORT_TYPE_LABEL;
  private HtmlSelectOneMenu COMP_QUOT_REPORT_TYPE;
  private HtmlOutputLabel COMP_QUOT_ITERATION_LABEL;
  private HtmlInputText COMP_QUOT_ITERATION;
  private PW_IL_PRINT PW_IL_PRINT_BEAN;
  public PILT002_APAC_QE_COMPOSITE_ACTION compositeAction;
  StringBuffer url = null;
  private String UI_M_SCHEDULE_TYPE;
  public String POL_SYS_ID = null;
  public String report_type = null;

  private List<SelectItem> listREPORT_TYPE = new ArrayList();

  private List<SelectItem> listITERATION = new ArrayList();

  public HtmlCommandButton getCOMP_POL_PRINT1()
  {
    return this.COMP_POL_PRINT1;
  }

  public HtmlOutputLabel getCOMP_QUOT_REPORT_TYPE_LABEL()
  {
    return this.COMP_QUOT_REPORT_TYPE_LABEL;
  }

  public void setCOMP_QUOT_REPORT_TYPE_LABEL(HtmlOutputLabel cOMP_QUOT_REPORT_TYPE_LABEL)
  {
    this.COMP_QUOT_REPORT_TYPE_LABEL = cOMP_QUOT_REPORT_TYPE_LABEL;
  }

  public HtmlSelectOneMenu getCOMP_QUOT_REPORT_TYPE()
  {
    return this.COMP_QUOT_REPORT_TYPE;
  }

  public void setCOMP_QUOT_REPORT_TYPE(HtmlSelectOneMenu cOMP_QUOT_REPORT_TYPE)
  {
    this.COMP_QUOT_REPORT_TYPE = cOMP_QUOT_REPORT_TYPE;
  }

  public HtmlOutputLabel getCOMP_QUOT_ITERATION_LABEL()
  {
    return this.COMP_QUOT_ITERATION_LABEL;
  }

  public void setCOMP_QUOT_ITERATION_LABEL(HtmlOutputLabel cOMP_QUOT_ITERATION_LABEL)
  {
    this.COMP_QUOT_ITERATION_LABEL = cOMP_QUOT_ITERATION_LABEL;
  }

  public HtmlInputText getCOMP_QUOT_ITERATION()
  {
    return this.COMP_QUOT_ITERATION;
  }

  public void setCOMP_QUOT_ITERATION(HtmlInputText cOMP_QUOT_ITERATION)
  {
    this.COMP_QUOT_ITERATION = cOMP_QUOT_ITERATION;
  }

  public void setCOMP_POL_PRINT1(HtmlCommandButton cOMP_POL_PRINT1)
  {
    this.COMP_POL_PRINT1 = cOMP_POL_PRINT1;
  }

  public HtmlCommandLink getCOMP_QQAT_PRINT() {
    return this.COMP_QQAT_PRINT;
  }

  public void setCOMP_QQAT_PRINT(HtmlCommandLink cOMP_QQAT_PRINT)
  {
    this.COMP_QQAT_PRINT = cOMP_QQAT_PRINT;
  }

  public PILT002_APAC_QE_COMPOSITE_ACTION getCompositeAction()
  {
    return this.compositeAction;
  }

  public void setCompositeAction(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
  {
    this.compositeAction = compositeAction;
  }

  public String getUI_M_SCHEDULE_TYPE()
  {
    return this.UI_M_SCHEDULE_TYPE;
  }

  public void setUI_M_SCHEDULE_TYPE(String uI_M_SCHEDULE_TYPE)
  {
    this.UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
  }

  public PRINT_ACTION()
    throws Exception
  {
    this.PW_IL_PRINT_BEAN = new PW_IL_PRINT();

    System.out.println(" PILT002_APAC Enter the PRINT_ACTION Constructor");
    this.helper = new PRINT_HELPER();
  }

  /*Added by Janani on 20.03.2017 for Dynamic report config for Base product*/
  
  String ScheduleReportType = null;
	
	public  String getScheduleReportType()throws Exception{

		System.out.println("inside selectpolstatus method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();	
		
		String query = "select ps_value from pp_system1 where ps_type like 'SCHDREPTYPE%'";
		System.out.println("schedule type query "+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			ScheduleReportType=resultSet.getString("ps_value");

		}
		
		
		System.out.println("ScheduleReportType                    :"+ScheduleReportType);
		
		return ScheduleReportType;
	}
  
  
  
  /*End*/
  
  
  public void onLoad(PhaseEvent event)
  {
    try
    {
      if (isBlockFlag()) {
        CommonUtils.clearMaps(this);

        int currQuotNo = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_IDX_NO();
        this.compositeAction.getPRINT_ACTION_BEAN().getPW_IL_PRINT_BEAN().setWM_ITERATION_COUNT(Integer.toString(currQuotNo));

        System.out.println("status               :" + this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS());

        String prod_value = null;
        if (CommonUtils.getGlobalVariable("GLOBAL.QE_QUOT_PROD_CODE") != null)
        {
          prod_value = CommonUtils.getGlobalVariable("GLOBAL.QE_QUOT_PROD_CODE").toString().trim();
        }

        System.out.println("prod_value              :" + prod_value);

        
        /*Added by Janani on 20.03.2017 for Dynamic report config for Base product*/
        
        getScheduleReportType();
        
        /*End*/
        
        System.out.println("ScheduleReportType              :" + this.ScheduleReportType);
        if (this.ScheduleReportType.equalsIgnoreCase("1")) /*1-Mdocs*/
        {
        	/*modified(null added for cover code) by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
          setListREPORT_TYPE(CommonReportAction.getDropDownListValue_1(
            CommonUtils.getConnection(), 
            "A", 
            "QE", this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS(), prod_value,null,null,null));
        }//end
        else
        {
          setListREPORT_TYPE(CommonReportAction.getDropDownListValue(
            CommonUtils.getConnection(), 
            "A", 
            "QE", this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS()));
        }
        /*added by ram on 2-11-2016*/
        getCOMP_QUOT_ITERATION().setDisabled(true);
        /*end*/
        setBlockFlag(false);
      }
    } catch (Exception e) {
      getErrorMap().put("current", 
        e.getMessage());
      getErrorMap().put("onLoad", e.getMessage());
    }
  }

  public String backButton()
  {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

    String pathContext = request.getContextPath();
    String requestUrl = request.getRequestURL().toString();
    System.out.println("Context path----/" + pathContext);
    System.out.println("Request Url---/" + requestUrl);
    
    /*Added by Ram on 12/11/2016 for ExpandAll button not enabling issue*/
    compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setBlockFlag(true);
    /*End*/
    
    CommonUtils.setGlobalObject("BACKFROM", Boolean.valueOf(true));
    return "PW_IL_QUICK_QUOTE";
  }

  public String runAction() {
    try {
      System.out.println("******** Enter the RunAction Method ********");

      String message = "This Quotation is Not Approved";
      this.report_type = this.compositeAction.getPRINT_ACTION_BEAN().getPW_IL_PRINT_BEAN().getWM_QUOT_REPORT();
      String apprStatus = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS();
      System.out.println("runbtn::report_type==" + this.report_type + "::apprStatus==" + apprStatus);
      if ((this.report_type.equals("2")) || (this.report_type.equals("4")))
      {
        if (apprStatus.equalsIgnoreCase("A")) {
          setRedirectUrl(this.helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
        }
        else {
          setRedirectUrl(null);
          System.out.println("demoooo" + getRedirectUrl());
          getErrorMap().put("current", 
            message);
          getErrorMap().put("SAVE_RECORD", message);
        }
      }
      else {
        getErrorMap().clear();
        getWarningMap().clear();

        setRedirectUrl(this.helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      getErrorMap().put("current", e.getMessage());
      getErrorMap().put("Print_Action", e.getMessage());
    }
    return getRedirectUrl();
  }

  public String questionnaireButtonAction()
  {
    String outcome = null;
    try {
      outcome = "PILT002_PRINT";
    } catch (Exception exception) {
      exception.getMessage();
      getErrorMap().put("current", exception.getMessage());
    }
    return outcome;
  }

  public String runActionAfterValidate()
  {
    CommonUtils.clearMaps(this);
    HttpServletResponse response = null;
    try
    {
      System.out.println("Inside runActionAfterValidate()");

      this.report_type = this.compositeAction.getPRINT_ACTION_BEAN().getPW_IL_PRINT_BEAN().getWM_QUOT_REPORT();
      String quotNo = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO();
      String QUOT_IDX_NO = this.compositeAction.getPRINT_ACTION_BEAN().getPW_IL_PRINT_BEAN().getWM_ITERATION_COUNT();
      String QUOT_PROD_CODE = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PROD_CODE();
      Long QUOT_SYS_ID = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_SYS_ID();
      String QUOT_MOP = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MOP();
      String apprStatus = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS();
      List COVERS = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getQuickdataList_PM_IL_PROD_APPL_COVER();
      System.out.println("COVERS size" + COVERS.size());
      String ptdaCover = null;
      String ptdsCover = null;
      String ppdCover = null;
      String pwrcover = null;
      String message = null;
      for (int i = 0; i < COVERS.size(); i++) {
        PW_IL_QQUOT_APPL_COVER cov = (PW_IL_QQUOT_APPL_COVER)COVERS.get(i);
        String cov_cod = cov.getQQAC_COVER_CODE();
        System.out.println("cov.getQQAC_COVER_CODE(); =========>>>>>" + cov_cod);
        if ((cov_cod.equalsIgnoreCase("PTDA")) || (cov_cod.equalsIgnoreCase("PTDA_122"))) {
          ptdaCover = "PTDA";
        }
        if ((cov_cod.equalsIgnoreCase("PTDS")) || (cov_cod.equalsIgnoreCase("PTDS_122"))) {
          ptdsCover = "PTDS";
        }
        if ((cov_cod.equalsIgnoreCase("PPDA")) || (cov_cod.equalsIgnoreCase("PPDS")) || (cov_cod.equalsIgnoreCase("PPDA-122")) || (cov_cod.equalsIgnoreCase("PPDS-122"))) {
          ppdCover = "PPD";
        }
        if (cov_cod.equalsIgnoreCase("PWR")) {
          pwrcover = "PWR";
        }
      }
      System.out.println("ptdaCover ==" + ptdaCover + "ptdsCover ==" + ptdsCover + "::ppdCover ==" + ppdCover);
      System.out.println("report_type==" + this.report_type + "::quotNo==" + quotNo + "::QUOT_IDX_NO==" + QUOT_IDX_NO + "::QUOT_SYS_ID =" + QUOT_SYS_ID + "::QUOT_PROD_CODE==" + 
        QUOT_PROD_CODE + "::QUOT_MOP==" + QUOT_MOP + "::apprStatus==" + apprStatus);
      System.out.println("quot_no ************" + quotNo);
      this.url = new StringBuffer(getRedirectUrl());
      System.out.println("this is url" + this.url.toString());
      message = "This Quotation is Not Approved";

      Double COMMVALUE = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_COMM_VALUE();

      String QUOT_VALUE = this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MOP();
      System.out.println("quot value in print--->" + QUOT_VALUE);

      System.out.println("after append" + this.url.toString());

      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletRequest request = (HttpServletRequest)context
        .getExternalContext().getRequest();
      HttpSession session = request.getSession();

      String userName = session.getAttribute("GLOBAL.M_USER_ID").toString();

      IP_REP_INFO repInfo = new IP_REP_INFO();
      String REP_KEY_NO = new ReportUtils().getRepKeyNo();
      repInfo.setREP_KEY_NO(REP_KEY_NO);
      repInfo.setREP_VALUE_1("13");
      repInfo.setREP_VALUE_2("QUOT_IDX_NO&&&" + QUOT_IDX_NO);
      repInfo.setREP_VALUE_3("QUOT_SYS_ID&&&" + QUOT_SYS_ID);
      repInfo.setREP_VALUE_4("PROD_CODE&&&" + QUOT_PROD_CODE);

      if ((COMMVALUE != null) && (!COMMVALUE.equals("null")))
      {
        repInfo.setREP_VALUE_5("COMMVALUE&&&" + COMMVALUE);
      }
      else
      {
        repInfo.setREP_VALUE_5("COMMVALUE&&&0.0");
      }

      repInfo.setREP_VALUE_6("QUOT_MOP&&&" + QUOT_VALUE);
      repInfo.setREP_VALUE_7("QUOT_NO&&&" + quotNo);
      repInfo.setREP_VALUE_8("MOP_FREQ&&&" + QUOT_MOP);
      repInfo.setREP_VALUE_9("PTDA_COVER&&&" + ptdaCover);
      repInfo.setREP_VALUE_10("PPD_COVER&&&" + ppdCover);
      repInfo.setREP_VALUE_11("PTDS_COVER&&&" + ptdsCover);
      repInfo.setREP_VALUE_12("PWR_COVER&&&" + pwrcover);
      repInfo.setREP_VALUE_13("USERNAME&&&" + userName);

      Connection conn = CommonUtils.getConnection();
      int ins = new CRUDHandler().executeInsert(repInfo, conn);
      conn.commit();

      System.out.println("quick quote report_type                 :" + this.report_type);

      this.url.append("REP_KEY_NO=" + REP_KEY_NO + "&REP_ID=" + this.report_type);

      setRedirectUrl(this.url.toString());

      if (getRedirectUrl() != null) {
        response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        System.out.println("CommonReportAction.runActionAfterValidate: " + getRedirectUrl());
        response.sendRedirect(getRedirectUrl());
      }
    } catch (Exception e) {
      e.printStackTrace();
      getErrorMap().put("current", e.getMessage());
      getErrorMap().put("runAction", e.getMessage());
    }
    return null;
  }

  public List<LovBean> iterNo(Object event)
    throws DBException
  {
    ListItemUtil itemUtil = new ListItemUtil();
    List suggestionList = new ArrayList();
    try {
      System.out.println("quot no ...." + this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO());
      suggestionList = itemUtil.P_CALL_LOV("PILT002_APAC_QE", "DUMMY", 
        "M_ITERATION_COUNT", this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_NO(), null, null, null, null, 
        (String)event);
    } catch (Exception e) {
      getErrorMap().put("current", 
        e.getMessage());
      getErrorMap().put("Product Code Suggestion", e.getMessage());
    }
    return suggestionList;
  }

  public PW_IL_PRINT getPW_IL_PRINT_BEAN()
  {
    return this.PW_IL_PRINT_BEAN;
  }

  public void setPW_IL_PRINT_BEAN(PW_IL_PRINT pW_IL_PRINT_BEAN)
  {
    this.PW_IL_PRINT_BEAN = pW_IL_PRINT_BEAN;
  }

  public List<SelectItem> getListREPORT_TYPE()
  {
    return this.listREPORT_TYPE;
  }

  public void setListREPORT_TYPE(List<SelectItem> listREPORT_TYPE)
  {
    this.listREPORT_TYPE = listREPORT_TYPE;
  }

  public List<SelectItem> getListITERATION()
  {
    return this.listITERATION;
  }

  public void setListITERATION(List<SelectItem> listITERATION)
  {
    this.listITERATION = listITERATION;
  }
}
package com.iii.pel.forms.PILM017;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION extends CommonAction {

	private CommonUtils commonUtils;
	private ControlBean controlBean;
	private int lastUpdatedRowIndex;
	private List<PM_IL_JL_AGE_FACTOR> recordList;
	private UIDataTable dataTable;
	private PM_IL_JL_AGE_FACTOR_SEARCH_PAGE PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN;

	private HtmlOutputLabel COMP_JAF_DIFF_AGE_FROM_LABEL;

	private HtmlInputText COMP_JAF_DIFF_AGE_FROM;

	private HtmlOutputLabel COMP_JAF_DIFF_AGE_TO_LABEL;

	private HtmlInputText COMP_JAF_DIFF_AGE_TO;

	private HtmlOutputLabel COMP_JAF_AGE_FACTOR_LABEL;

	private HtmlInputText COMP_JAF_AGE_FACTOR;

	private HtmlOutputLabel COMP_JAF_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_JAF_EFF_FM_DT;

	private HtmlOutputLabel COMP_JAF_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_JAF_EFF_TO_DT;

	private PM_IL_JL_AGE_FACTOR PM_IL_JL_AGE_FACTOR_BEAN;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DEL;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	public PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION() {
		PM_IL_JL_AGE_FACTOR_BEAN = new PM_IL_JL_AGE_FACTOR();
		this.PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN = new PM_IL_JL_AGE_FACTOR_SEARCH_PAGE();
		commonUtils = new CommonUtils();
		controlBean = new ControlBean();
		instantiateAllComponent();
	}

	public List<PM_IL_JL_AGE_FACTOR> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_JL_AGE_FACTOR> recordList) {
		this.recordList = recordList;
	}

	public PM_IL_JL_AGE_FACTOR_SEARCH_PAGE getPM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN() {
		return PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN(
			PM_IL_JL_AGE_FACTOR_SEARCH_PAGE pm_il_data_upload_search_page_bean) {
		PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN = pm_il_data_upload_search_page_bean;
	}

	public void onLoad(PhaseEvent event) {
		System.out.println("Fetch List");

		PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE delegate = new PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE();
		if (isBlockFlag()) {
			this.recordList = delegate.listAllRecords();
			resetSelectedRow();
			if (recordList != null && recordList.size() > 0) {
				PM_IL_JL_AGE_FACTOR_BEAN = (PM_IL_JL_AGE_FACTOR) recordList
						.get(0);
				// PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
				setPM_IL_JL_AGE_FACTOR_BEAN(PM_IL_JL_AGE_FACTOR_BEAN);
			}
			if (recordList != null && this.recordList.size() == 0) {
				getWarningMap().put("current",
						"There is no record for this search criteria");
			} else {
				getWarningMap().clear();
			}
			setBlockFlag(false);
		}
		PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
		resetAllComponent();
	}

	public void fetchButtonClick(ActionEvent event) {
		System.out.println("Fetch List");

		PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE delegate = new PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE();
		this.recordList = delegate.listAllRecords();
		if (recordList != null) {

			Iterator<PM_IL_JL_AGE_FACTOR> iterator = recordList.iterator();
			while (iterator.hasNext()) {
				PM_IL_JL_AGE_FACTOR pm_il_jl_age_factor = (PM_IL_JL_AGE_FACTOR) iterator
						.next();
				pm_il_jl_age_factor.setRowSelected(false);
			}
		}

		if (recordList != null && recordList.size() > 0) {
			PM_IL_JL_AGE_FACTOR_BEAN = (PM_IL_JL_AGE_FACTOR) recordList.get(0);
			PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
			setPM_IL_JL_AGE_FACTOR_BEAN(PM_IL_JL_AGE_FACTOR_BEAN);
		}
		if (recordList != null && this.recordList.size() == 0) {
			getWarningMap().put("current",
					"There is no record for this search criteria");
		} else {
			getWarningMap().clear();
		}

		resetAllComponent();
	}

	public void WHEN_VALIDATE_JAF_DIFF_AGE_FROM(ActionEvent AE) {
		try {
			CommonUtils.clearMaps(this);
			PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
			Integer ageto = factor.getJAF_DIFF_AGE_TO();
			Integer agefrom = factor.getJAF_DIFF_AGE_FROM();
			System.out
					.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_DIFF_AGE_FROM()>>"
							+ ageto + "" + agefrom);
			if (agefrom != null && agefrom < 0) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91022", new Object[] { "Age From" })
								.getSummary());
				getErrorMap().put(
						"JAF_DIFF_AGE_FROM",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91022", new Object[] { "Age From" })
								.getSummary());

			} else if (agefrom != null && ageto != null && agefrom > 0
					&& agefrom > ageto) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91031", new Object[] { "Age From" })
								.getSummary());
				getErrorMap().put(
						"JAF_DIFF_AGE_FROM",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91031", new Object[] { "Age From" })
								.getSummary());

			} else {

				getErrorMap().remove("JAF_DIFF_AGE_FROM");
				getErrorMap().remove("JAF_DIFF_AGE_TO");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void WHEN_VALIDATE_JAF_DIFF_AGE_TO(ActionEvent AE) {
		try {
			CommonUtils.clearMaps(this);
			PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
			Integer ageto = factor.getJAF_DIFF_AGE_TO();
			Integer agefrom = factor.getJAF_DIFF_AGE_FROM();
			System.out
					.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_DIFF_AGE_TO()>>"
							+ ageto + "" + agefrom);
			if (ageto != null && ageto < 0) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91022", new Object[] { "Age To" })
								.getSummary());
				getErrorMap().put(
						"JAF_DIFF_AGE_TO",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91022", new Object[] { "Age To" })
								.getSummary());

			} else if (ageto != null && agefrom != null && agefrom > ageto) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91032", new Object[] { "Age To" })
								.getSummary());
				getErrorMap().put(
						"JAF_DIFF_AGE_TO",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91032", new Object[] { "Age To" })
								.getSummary());

			} else {
				getErrorMap().remove("JAF_DIFF_AGE_TO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateJAF_AGE_FACTOR(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			CommonUtils.clearMaps(this);
			Double JAF_AGE_FACTOR_VALUE = (Double) value;
			PM_IL_JL_AGE_FACTOR_BEAN.setJAF_AGE_FACTOR(JAF_AGE_FACTOR_VALUE);
			PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
			Double agefacor = factor.getJAF_AGE_FACTOR();
			if (agefacor != null && agefacor < 0) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91026", new Object[] { "Age Factor" })
								.getSummary());
				getErrorMap().put(
						"JAF_AGE_FACTOR",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91026", new Object[] { "Age Factor" })
								.getSummary());
			} else {
				if (getErrorMap().isEmpty()) {
					getErrorMap().remove("JAF_AGE_FACTOR");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}

	public void validateJAF_DIFF_AGE_FROM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			CommonUtils.clearMaps(this);
			Integer JAF_DIFF_AGE_FROM = (Integer) value;
			PM_IL_JL_AGE_FACTOR_BEAN.setJAF_DIFF_AGE_FROM(JAF_DIFF_AGE_FROM);
			if (null != PM_IL_JL_AGE_FACTOR_BEAN.getJAF_DIFF_AGE_FROM()
					&& PM_IL_JL_AGE_FACTOR_BEAN.getJAF_DIFF_AGE_FROM() > 999) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.pel.errorUtil.PELErrorMessages", "2177"));
			} else {
				getWarningMap().clear();
				getErrorMap().clear();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
		}
	}

	public void validateJAF_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			CommonUtils.clearMaps(this);
			Date JAF_EFF_FM_DT = (Date) value;
			PM_IL_JL_AGE_FACTOR_BEAN.setJAF_EFF_FM_DT(JAF_EFF_FM_DT);
			Date fromdate= PM_IL_JL_AGE_FACTOR_BEAN.getJAF_EFF_FM_DT();
			Date todate= PM_IL_JL_AGE_FACTOR_BEAN.getJAF_EFF_TO_DT();
			/*if(fromdate!=null && todate!=null){
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
				String fromDateStr = format.format(fromdate);
				String toDateStr = format.format(todate);*/
				Date fDate =  CommonUtils.nvl(fromdate, new Date("01-JAN-1900"));
				Date tDate = CommonUtils.nvl(todate, new Date("31-DEC-2999"));
				
				if(fDate.after(tDate)){
					throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath, "91010"));
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}  
	}

	public void validateJAF_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value)  throws ValidatorException {

		try {
			CommonUtils.clearMaps(this);
			Date JAF_EFF_TO_DT = (Date) value;
			PM_IL_JL_AGE_FACTOR_BEAN.setJAF_EFF_TO_DT(JAF_EFF_TO_DT);
			PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
			Date fromdate = factor.getJAF_EFF_FM_DT();
			Date todate = factor.getJAF_EFF_TO_DT();
	 
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
				String fromDateStr = format.format(fromdate);
				String toDateStr = format.format(todate);
				Date fDate = format.parse(NVL(fromDateStr, "01-JAN-1900"));
				Date tDate = format.parse(NVL(toDateStr, "31-DEC-2999"));
				if (tDate.before(fDate)) {
					throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath, "91001"));

				} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  
	}

	public void validateJAF_DIFF_AGE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException  {
		try {
			CommonUtils.clearMaps(this);
			Integer JAF_DIFF_AGE_TO = (Integer) value;
			PM_IL_JL_AGE_FACTOR_BEAN.setJAF_DIFF_AGE_TO(JAF_DIFF_AGE_TO);
			PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
			Integer ageto = factor.getJAF_DIFF_AGE_TO();
			Integer agefrom = factor.getJAF_DIFF_AGE_FROM();
			if (ageto != null && ageto < 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.pel.errorUtil.PELErrorMessages", "91022"));

			} else if (null != ageto && ageto > 999) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.pel.errorUtil.PELErrorMessages", "2177"));
			} else if (ageto != null && agefrom != null && agefrom > ageto) {
				throw new ValidatorException(new FacesMessage("Age To Should be Greater than or Equal Age From"));

			} else {
				getErrorMap().clear();
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
		}
	}

	public void WHEN_VALIDATE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String WHEN_VALIDATE_JAF_EFF_FM_DT() throws ParseException {
		PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
		Date fromdate = factor.getJAF_EFF_FM_DT();
		Date todate = factor.getJAF_EFF_TO_DT();
		if (fromdate != null && todate != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			Date fDate = format.parse(NVL(fromDateStr, "01-JAN-1900"));
			Date tDate = format.parse(NVL(toDateStr, "31-DEC-2999"));
			System.out
					.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_FM_DT()>>>"
							+ fDate + "<><>" + tDate);
			if (fDate.after(tDate)) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91010", new Object[] { "From Date" })
								.getSummary());
				getErrorMap().put(
						"JAF_EFF_FM_DT",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91010", new Object[] { "From Date" })
								.getSummary());
			} else {
				if (getErrorMap().isEmpty()) {
					getErrorMap().remove("JAF_EFF_FM_DT");
				}
			}
		}
		return "";

	}

	public void WHEN_VALIDATE_JAF_EFF_TO_DT() throws Exception {
		PM_IL_JL_AGE_FACTOR factor = this.PM_IL_JL_AGE_FACTOR_BEAN;
		Date fromdate = factor.getJAF_EFF_FM_DT();
		Date todate = factor.getJAF_EFF_TO_DT();
		if (fromdate != null && todate != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			Date fDate = format.parse(NVL(fromDateStr, "01-JAN-1900"));
			Date tDate = format.parse(NVL(toDateStr, "31-DEC-2999"));
			System.out
					.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT()>>>"
							+ fDate + "" + tDate + "777" + fDate.before(tDate));
			if (fDate.after(tDate)) {
				System.out
						.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT() in if loop ");
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91010", new Object[] { "To Date" })
								.getSummary());
				getErrorMap().put(
						"JAF_EFF_TO_DT",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"91010", new Object[] { "To Date" })
								.getSummary());
			} else {
				if (getErrorMap().isEmpty()) {
					getErrorMap().remove("JAF_EFF_TO_DT");
				}
				// Commented for LastColumnListerer SHANKAR BODDULURI
				/*
				 * if (factor.getROWID() != null) { PRE_UPDATE_PILM017(); } else {
				 * PRE_INSERT_PILM017(); }
				 */
			}
		}

		System.out
				.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT()curent map "
						+ getErrorMap().get("current"));

	}

	public static String NVL(String str, String assign) {
		if ("".equals(str) || str.length() == 0) {
			str = assign;
		}
		return str;
	}

	/*
	 * public String updateOrInsertRecordLinkClicked(){
	 * 
	 * System.out.println("In to The Link");
	 * 
	 * String returnString="PM_IL_JL_AGE_FACTOR_NAVIGATOR";
	 * 
	 * String mappedBeanName="PILM017_PM_IL_JL_AGE_FACTOR_ACTION";
	 * 
	 * boolean keepLooking=true;
	 * 
	 * CommonUtils utility=new CommonUtils();
	 * 
	 * HttpSession session = utility.getSession();
	 * 
	 * //Get the action bean for the next page from session
	 * PM_IL_JL_AGE_FACTOR_ACTION
	 * actionBean=(PM_IL_JL_AGE_FACTOR_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
	 * 
	 * //if action bean is null create new object and set is session
	 * if(actionBean == null){ actionBean = new PM_IL_JL_AGE_FACTOR_ACTION();
	 * session.setAttribute(mappedBeanName, actionBean); } //get the rowid from
	 * request which is to be updated FacesContext context
	 * =FacesContext.getCurrentInstance(); Map
	 * requestParameterMap=context.getExternalContext().getRequestParameterMap();
	 * String currentRow=((String)requestParameterMap.get("CURRENT_ROWID"));
	 * //check if request is for update or insert if row id present request for
	 * update //else it is for insert if(currentRow!=null &&
	 * currentRow.length()>0){ Iterator<PM_IL_JL_AGE_FACTOR>
	 * iterator=this.recordList.iterator(); while(iterator.hasNext()&&
	 * keepLooking){ PM_IL_JL_AGE_FACTOR
	 * tempBean=((PM_IL_JL_AGE_FACTOR)iterator.next());
	 * if(currentRow.equals(tempBean.getROWID().trim())){ List fetchList=new
	 * ArrayList(); fetchList.add(tempBean); actionBean.setFetchList(fetchList);
	 * keepLooking=false; //System.out.println("tempBean.getAWDS_CURR_AGE_TO()
	 * \t"+tempBean.getAWDS_CURR_AGE_TO()); } } }else{ //clear any previous
	 * instances of the action bean that might exist in case //of insert. This
	 * will take care of resetting the fields PM_IL_JL_AGE_FACTOR_ACTION
	 * newActionBean=new PM_IL_JL_AGE_FACTOR_ACTION();
	 * session.setAttribute(mappedBeanName, newActionBean); }
	 * this.recordList=null; return returnString; }
	 */
	@SuppressWarnings("unchecked")
	public String forUpDation() throws Exception {
		PM_IL_JL_AGE_FACTOR_ACTION action = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String selectQuery = "Select ROWID, PM_IL_JL_AGE_FACTOR.* from PM_IL_JL_AGE_FACTOR where ROWID='"
				+ request.getParameter("CURRENT_ROWID") + "'";
		System.out.println("QUERY------------------>" + selectQuery);
		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_JL_AGE_FACTOR> list = handler.fetch(selectQuery,
				"com.iii.pel.forms.PILM017.PM_IL_JL_AGE_FACTOR", con);
		HttpSession session = request.getSession();
		// [BugId:TRACK_PREMIAGDC_GL.10.5-00162 : Modified code for navigating
		// screen from searching screen. : Added by : Shankar Bodduluri
		// 28-Mar-2009

		/*
		 * PM_IL_JL_AGE_FACTOR dtl = (PM_IL_JL_AGE_FACTOR) list.get(0);
		 * PM_IL_JL_AGE_FACTOR_ACTION actionBean = new
		 * PM_IL_JL_AGE_FACTOR_ACTION(); if (session != null) { Object object =
		 * session.getAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION"); if(object ==
		 * null){ session.setAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION",
		 * actionBean); } } PM_IL_JL_AGE_FACTOR_ACTION action =
		 * (PM_IL_JL_AGE_FACTOR_ACTION)
		 * session.getAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION");
		 * action.setPM_IL_JL_AGE_FACTOR_BEAN(dtl);
		 */
		// [BugId:TRACK_PREMIAGDC_GL.10.5-00162 : Modified code for navigating
		// screen from searching screen. : Added by : Shankar Bodduluri
		// 28-Mar-2009
		action = new PM_IL_JL_AGE_FACTOR_ACTION();
		action.setFetchList(list);
		session.setAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION", action);

		Iterator<PM_IL_JL_AGE_FACTOR> iterator = list.iterator();
		while (iterator.hasNext()) {
			PM_IL_JL_AGE_FACTOR pm_il_jl_age_factor = (PM_IL_JL_AGE_FACTOR) iterator
					.next();
			pm_il_jl_age_factor.setRowSelected(false);
		}

		if (list != null && list.size() > 0) {
			PM_IL_JL_AGE_FACTOR_BEAN = (PM_IL_JL_AGE_FACTOR) list.get(0);
			PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
			setPM_IL_JL_AGE_FACTOR_BEAN(PM_IL_JL_AGE_FACTOR_BEAN);
		}
		// actionBean.setUpdate(true);
		return "PM_IL_JL_AGE_FACTOR_NAVIGATOR";
	}

	public String forInsertion() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION") != null) {
			System.out
					.println("PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION.forInsertion()");
			session.removeAttribute("PILM017_PM_IL_JL_AGE_FACTOR_ACTION");
		}
		return "PM_IL_JL_AGE_FACTOR_NAVIGATOR";
	}

	/**
	 * Add Row.
	 * 
	 * @param event
	 */
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_JL_AGE_FACTOR_BEAN = null;
			if (isINSERT_ALLOWED()) {
				PM_IL_JL_AGE_FACTOR_BEAN = new PM_IL_JL_AGE_FACTOR();
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	/**
	 * Post the record.
	 * 
	 * @param ae
	 */
	public String post(ActionEvent event) {
		try {
			ControlBean controlBean = CommonUtils.getControlBean();
			PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE delegate = new PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE();
			if (this.getPM_IL_JL_AGE_FACTOR_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					new CRUDHandler().executeInsert(PM_IL_JL_AGE_FACTOR_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));

					// queryData();
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED() && validate(PM_IL_JL_AGE_FACTOR_BEAN)) {
					delegate.preInsert(PM_IL_JL_AGE_FACTOR_BEAN);
					new CRUDHandler().executeInsert(PM_IL_JL_AGE_FACTOR_BEAN,
							CommonUtils.getConnection());

					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));

					this.recordList.add(PM_IL_JL_AGE_FACTOR_BEAN);

				} else if (!isINSERT_ALLOWED()) {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			// resetAllComponent();
			// resetSelectedRow();
			PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		return null;
	}

	private boolean validate(PM_IL_JL_AGE_FACTOR pm_il_jl_age_factor_bean) {
		getErrorMap().clear();
		getWarningMap().clear();
		if (null == pm_il_jl_age_factor_bean.getJAF_DIFF_AGE_FROM()) {
			getErrorMap().put("current", "Enter Age From");
			getErrorMap().put("AgeFrom", "Enter Age From");
			return false;
		} else if (null == pm_il_jl_age_factor_bean.getJAF_DIFF_AGE_TO()) {
			getErrorMap().put("current", "Enter Age To");
			getErrorMap().put("aGEtO", "Enter Age To");
			return false;
		} else if (null == pm_il_jl_age_factor_bean.getJAF_AGE_FACTOR()) {
			getErrorMap().put("current", "Age Factor");
			getErrorMap().put("AgeFactor", "Age Factor");
			return false;
		} else if (null == pm_il_jl_age_factor_bean.getJAF_EFF_FM_DT()) {
			getErrorMap().put("current", "Effective From Date");
			getErrorMap().put("frmdat", "Effective From Date");
			return false;
		} else if (null == pm_il_jl_age_factor_bean.getJAF_EFF_TO_DT()) {
			getErrorMap().put("current", "Effective To Date");
			getErrorMap().put("todate", "Effective To Date");
			return false;
		} else {
			return true;
		}
	}

	public void deleteRow(ActionEvent ae) {
		CRUDHandler handler = new CRUDHandler();
		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_JL_AGE_FACTOR bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (this.recordList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < recordList.size();) {
					bean = (PM_IL_JL_AGE_FACTOR) recordList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						recordList.remove(bean);
						deletedRecordIndex = handler.executeDelete(bean,
								commonUtils.getConnection());
						deletedRecordList.add(deletedRecordIndex);
						commonUtils.doComitt();
					} else {
						index++;
					}
				}
				if (recordList.size() > 0) {
					setPM_IL_JL_AGE_FACTOR_BEAN((PM_IL_JL_AGE_FACTOR) recordList
							.get(0));
					PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
	}

	/**
	 * Commit the sql.
	 */
	public void saveData() {
		String message = null;
		getWarningMap().clear();
		getErrorMap().clear();
		 
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			message = Messages.getString("messageProperties",
			"errorPanel$message$save");
			getWarningMap().put("current", message);
			getWarningMap().put("SAVE",message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDetails() {
		try {
			resetSelectedRow();
			if (recordList.size() != 0) {
				PM_IL_JL_AGE_FACTOR_BEAN = (PM_IL_JL_AGE_FACTOR) dataTable
						.getRowData();
			}
			PM_IL_JL_AGE_FACTOR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_JL_AGE_FACTOR> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_JAF_AGE_FACTOR.resetValue();
		COMP_JAF_DIFF_AGE_FROM.resetValue();
		COMP_JAF_DIFF_AGE_TO.resetValue();
		COMP_JAF_EFF_FM_DT.resetValue();
		COMP_JAF_EFF_TO_DT.resetValue();
	}
	

	/**
	 * Instantiates all components in PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_JAF_DIFF_AGE_FROM				 = new HtmlInputText();
		COMP_JAF_DIFF_AGE_TO				 = new HtmlInputText();
		COMP_JAF_AGE_FACTOR				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_JAF_EFF_FM_DT				 = new HtmlCalendar();
		COMP_JAF_EFF_TO_DT				 = new HtmlCalendar();

	}



	public HtmlOutputLabel getCOMP_JAF_DIFF_AGE_FROM_LABEL() {
		return COMP_JAF_DIFF_AGE_FROM_LABEL;
	}

	public void setCOMP_JAF_DIFF_AGE_FROM_LABEL(
			HtmlOutputLabel comp_jaf_diff_age_from_label) {
		COMP_JAF_DIFF_AGE_FROM_LABEL = comp_jaf_diff_age_from_label;
	}

	public HtmlInputText getCOMP_JAF_DIFF_AGE_FROM() {
		return COMP_JAF_DIFF_AGE_FROM;
	}

	public void setCOMP_JAF_DIFF_AGE_FROM(HtmlInputText comp_jaf_diff_age_from) {
		COMP_JAF_DIFF_AGE_FROM = comp_jaf_diff_age_from;
	}

	public HtmlOutputLabel getCOMP_JAF_DIFF_AGE_TO_LABEL() {
		return COMP_JAF_DIFF_AGE_TO_LABEL;
	}

	public void setCOMP_JAF_DIFF_AGE_TO_LABEL(
			HtmlOutputLabel comp_jaf_diff_age_to_label) {
		COMP_JAF_DIFF_AGE_TO_LABEL = comp_jaf_diff_age_to_label;
	}

	public HtmlInputText getCOMP_JAF_DIFF_AGE_TO() {
		return COMP_JAF_DIFF_AGE_TO;
	}

	public void setCOMP_JAF_DIFF_AGE_TO(HtmlInputText comp_jaf_diff_age_to) {
		COMP_JAF_DIFF_AGE_TO = comp_jaf_diff_age_to;
	}

	public HtmlOutputLabel getCOMP_JAF_AGE_FACTOR_LABEL() {
		return COMP_JAF_AGE_FACTOR_LABEL;
	}

	public void setCOMP_JAF_AGE_FACTOR_LABEL(
			HtmlOutputLabel comp_jaf_age_factor_label) {
		COMP_JAF_AGE_FACTOR_LABEL = comp_jaf_age_factor_label;
	}

	public HtmlInputText getCOMP_JAF_AGE_FACTOR() {
		return COMP_JAF_AGE_FACTOR;
	}

	public void setCOMP_JAF_AGE_FACTOR(HtmlInputText comp_jaf_age_factor) {
		COMP_JAF_AGE_FACTOR = comp_jaf_age_factor;
	}

	public HtmlOutputLabel getCOMP_JAF_EFF_FM_DT_LABEL() {
		return COMP_JAF_EFF_FM_DT_LABEL;
	}

	public void setCOMP_JAF_EFF_FM_DT_LABEL(
			HtmlOutputLabel comp_jaf_eff_fm_dt_label) {
		COMP_JAF_EFF_FM_DT_LABEL = comp_jaf_eff_fm_dt_label;
	}

	public HtmlCalendar getCOMP_JAF_EFF_FM_DT() {
		return COMP_JAF_EFF_FM_DT;
	}

	public void setCOMP_JAF_EFF_FM_DT(HtmlCalendar comp_jaf_eff_fm_dt) {
		COMP_JAF_EFF_FM_DT = comp_jaf_eff_fm_dt;
	}

	public HtmlOutputLabel getCOMP_JAF_EFF_TO_DT_LABEL() {
		return COMP_JAF_EFF_TO_DT_LABEL;
	}

	public void setCOMP_JAF_EFF_TO_DT_LABEL(
			HtmlOutputLabel comp_jaf_eff_to_dt_label) {
		COMP_JAF_EFF_TO_DT_LABEL = comp_jaf_eff_to_dt_label;
	}

	public HtmlCalendar getCOMP_JAF_EFF_TO_DT() {
		return COMP_JAF_EFF_TO_DT;
	}

	public void setCOMP_JAF_EFF_TO_DT(HtmlCalendar comp_jaf_eff_to_dt) {
		COMP_JAF_EFF_TO_DT = comp_jaf_eff_to_dt;
	}

	public PM_IL_JL_AGE_FACTOR getPM_IL_JL_AGE_FACTOR_BEAN() {
		return PM_IL_JL_AGE_FACTOR_BEAN;
	}

	public void setPM_IL_JL_AGE_FACTOR_BEAN(
			PM_IL_JL_AGE_FACTOR pm_il_jl_age_factor_bean) {
		PM_IL_JL_AGE_FACTOR_BEAN = pm_il_jl_age_factor_bean;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}
}

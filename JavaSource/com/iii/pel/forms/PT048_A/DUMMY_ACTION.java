package com.iii.pel.forms.PT048_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS_LABEL;

	private HtmlInputText COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_RANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_RANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_AGENT_FM_PROCESS_DT;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_AGENT_TO_PROCESS_DT;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_NAME_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_NAME;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_NAME_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_NAME;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM_RANK_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO_RANK_CODE_DESC;

	private HtmlOutputLabel COMP_ABV_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ABV_AGENT_CODE;

	private HtmlOutputLabel COMP_ABV_BONUS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ABV_BONUS_TYPE;

	private HtmlOutputLabel COMP_ABV_BONUS_CODE_LABEL;

	private HtmlInputText COMP_ABV_BONUS_CODE;

	private HtmlOutputLabel COMP_ABV_CURR_CODE_LABEL;

	private HtmlInputText COMP_ABV_CURR_CODE;

	private HtmlOutputLabel COMP_ABV_PROCESS_YR_LABEL;

	private HtmlInputText COMP_ABV_PROCESS_YR;

	private HtmlOutputLabel COMP_ABV_PR_RATE_NR_LABEL;

	private HtmlInputText COMP_ABV_PR_RATE_NR;

	private HtmlOutputLabel COMP_ABV_PR_RATE_DR_LABEL;

	private HtmlInputText COMP_ABV_PR_RATE_DR;

	private HtmlOutputLabel COMP_ABV_FC_VALUE_LABEL;

	private HtmlInputText COMP_ABV_FC_VALUE;

	private HtmlOutputLabel COMP_UI_M_ABV_BONUS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABV_BONUS_DESC;

	private HtmlOutputLabel COMP_UI_M_ABV_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABV_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_ABV_LC_VALUE_LABEL;

	private HtmlInputText COMP_ABV_LC_VALUE;

	private HtmlOutputLabel COMP_ABV_PERIOD_FM_DT_LABEL;

	private HtmlCalendar COMP_ABV_PERIOD_FM_DT;

	private HtmlOutputLabel COMP_ABV_PERIOD_TO_DT_LABEL;

	private HtmlCalendar COMP_ABV_PERIOD_TO_DT;

	private HtmlOutputLabel COMP_ABV_PAID_DT_LABEL;

	private HtmlCalendar COMP_ABV_PAID_DT;

	private HtmlOutputLabel COMP_ABV_FRZ_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_ABV_FRZ_FLAG;
	
	private HtmlOutputLabel COMP_ABV_PAID_FLAG_LABEL;
	
	private HtmlSelectOneMenu COMP_ABV_PAID_FLAG;

	private PT_AGENT_BONUS_VALUES_2 PT_AGENT_BONUS_VALUES_2_BEAN;

	private DUMMY DUMMY_BEAN;

	private List<PT_AGENT_BONUS_VALUES_2> list = new ArrayList<PT_AGENT_BONUS_VALUES_2>();

	private HtmlCommandButton PREFORMBUTTON;

	private HtmlSuggestionBox suggestionBoxAgentFrom;

	private HtmlSuggestionBox suggestionBoxAgentTo;

	private HtmlSuggestionBox suggestionBoxAgentRankFrom;

	private HtmlSuggestionBox suggestionBoxAgentRankTo;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private boolean disabledWhenApproved;

	List agentFrom;

	List agentTo;

	List fromRank;

	List toRank;

	private UIData dataTable;

	int prevRowIndex;

	private List<SelectItem> bonusList = new ArrayList<SelectItem>();
	private List<SelectItem> flagList = new ArrayList<SelectItem>();
	private List<SelectItem> paidList = new ArrayList<SelectItem>();

	// private Map<String, String> errorMap = new HashMap<String, String>();
	// private String errorMessages;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		PT_AGENT_BONUS_VALUES_2_BEAN = new PT_AGENT_BONUS_VALUES_2();
		prevRowIndex = 0;
		// populating the drop downs
		try {
			bonusList = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PT048_A", "PT_AGENT_BONUS_VALUES_2",
					"PT_AGENT_BONUS_VALUES_2.ABV_BONUS_TYPE", "");
			flagList = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PT048_A", "PT_AGENT_BONUS_VALUES_2",
					"PT_AGENT_BONUS_VALUES_2.ABV_FRZ_FLAG", "YESNO");
			
			paidList = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PT048_A", "PT_AGENT_BONUS_VALUES_2",
					"PT_AGENT_BONUS_VALUES_2.ABV_PAID_FLAG", "YESNO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_CODE_LABEL() {
		return COMP_UI_M_AGENT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_CODE() {
		return COMP_UI_M_AGENT_FM_CODE;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_CODE_LABEL) {
		this.COMP_UI_M_AGENT_FM_CODE_LABEL = COMP_UI_M_AGENT_FM_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_CODE(HtmlInputText COMP_UI_M_AGENT_FM_CODE) {
		this.COMP_UI_M_AGENT_FM_CODE = COMP_UI_M_AGENT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_CODE_LABEL() {
		return COMP_UI_M_AGENT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_CODE() {
		return COMP_UI_M_AGENT_TO_CODE;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_CODE_LABEL) {
		this.COMP_UI_M_AGENT_TO_CODE_LABEL = COMP_UI_M_AGENT_TO_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_CODE(HtmlInputText COMP_UI_M_AGENT_TO_CODE) {
		this.COMP_UI_M_AGENT_TO_CODE = COMP_UI_M_AGENT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_RANK_CODE_LABEL() {
		return COMP_UI_M_AGENT_FM_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_RANK_CODE() {
		return COMP_UI_M_AGENT_FM_RANK_CODE;
	}

	public void setCOMP_UI_M_AGENT_FM_RANK_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_RANK_CODE_LABEL) {
		this.COMP_UI_M_AGENT_FM_RANK_CODE_LABEL = COMP_UI_M_AGENT_FM_RANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_RANK_CODE(
			HtmlInputText COMP_UI_M_AGENT_FM_RANK_CODE) {
		this.COMP_UI_M_AGENT_FM_RANK_CODE = COMP_UI_M_AGENT_FM_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_RANK_CODE_LABEL() {
		return COMP_UI_M_AGENT_TO_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_RANK_CODE() {
		return COMP_UI_M_AGENT_TO_RANK_CODE;
	}

	public void setCOMP_UI_M_AGENT_TO_RANK_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_RANK_CODE_LABEL) {
		this.COMP_UI_M_AGENT_TO_RANK_CODE_LABEL = COMP_UI_M_AGENT_TO_RANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_RANK_CODE(
			HtmlInputText COMP_UI_M_AGENT_TO_RANK_CODE) {
		this.COMP_UI_M_AGENT_TO_RANK_CODE = COMP_UI_M_AGENT_TO_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_PROCESS_DT_LABEL() {
		return COMP_UI_M_AGENT_FM_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_AGENT_FM_PROCESS_DT() {
		return COMP_UI_M_AGENT_FM_PROCESS_DT;
	}

	public void setCOMP_UI_M_AGENT_FM_PROCESS_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_PROCESS_DT_LABEL) {
		this.COMP_UI_M_AGENT_FM_PROCESS_DT_LABEL = COMP_UI_M_AGENT_FM_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_PROCESS_DT(
			HtmlCalendar COMP_UI_M_AGENT_FM_PROCESS_DT) {
		this.COMP_UI_M_AGENT_FM_PROCESS_DT = COMP_UI_M_AGENT_FM_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_PROCESS_DT_LABEL() {
		return COMP_UI_M_AGENT_TO_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_AGENT_TO_PROCESS_DT() {
		return COMP_UI_M_AGENT_TO_PROCESS_DT;
	}

	public void setCOMP_UI_M_AGENT_TO_PROCESS_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_PROCESS_DT_LABEL) {
		this.COMP_UI_M_AGENT_TO_PROCESS_DT_LABEL = COMP_UI_M_AGENT_TO_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_PROCESS_DT(
			HtmlCalendar COMP_UI_M_AGENT_TO_PROCESS_DT) {
		this.COMP_UI_M_AGENT_TO_PROCESS_DT = COMP_UI_M_AGENT_TO_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_NAME_LABEL() {
		return COMP_UI_M_AGENT_FM_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_NAME() {
		return COMP_UI_M_AGENT_FM_NAME;
	}

	public void setCOMP_UI_M_AGENT_FM_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_NAME_LABEL) {
		this.COMP_UI_M_AGENT_FM_NAME_LABEL = COMP_UI_M_AGENT_FM_NAME_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_NAME(HtmlInputText COMP_UI_M_AGENT_FM_NAME) {
		this.COMP_UI_M_AGENT_FM_NAME = COMP_UI_M_AGENT_FM_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_NAME_LABEL() {
		return COMP_UI_M_AGENT_TO_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_NAME() {
		return COMP_UI_M_AGENT_TO_NAME;
	}

	public void setCOMP_UI_M_AGENT_TO_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_NAME_LABEL) {
		this.COMP_UI_M_AGENT_TO_NAME_LABEL = COMP_UI_M_AGENT_TO_NAME_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_NAME(HtmlInputText COMP_UI_M_AGENT_TO_NAME) {
		this.COMP_UI_M_AGENT_TO_NAME = COMP_UI_M_AGENT_TO_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM_RANK_CODE_DESC() {
		return COMP_UI_M_AGENT_FM_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL = COMP_UI_M_AGENT_FM_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM_RANK_CODE_DESC(
			HtmlInputText COMP_UI_M_AGENT_FM_RANK_CODE_DESC) {
		this.COMP_UI_M_AGENT_FM_RANK_CODE_DESC = COMP_UI_M_AGENT_FM_RANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO_RANK_CODE_DESC() {
		return COMP_UI_M_AGENT_TO_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL = COMP_UI_M_AGENT_TO_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO_RANK_CODE_DESC(
			HtmlInputText COMP_UI_M_AGENT_TO_RANK_CODE_DESC) {
		this.COMP_UI_M_AGENT_TO_RANK_CODE_DESC = COMP_UI_M_AGENT_TO_RANK_CODE_DESC;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	private String ptAgentPreQuery() {
		String M_WHERE = null;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return M_WHERE;
	}

	public void populateValues(Object toDate) {
		System.out.println("\n\n Rerender is happening and populating values");
		CRUDHandler crud = new CRUDHandler();
		System.out.println("The to date from component is: "
				+ getCOMP_UI_M_AGENT_TO_PROCESS_DT().getSubmittedValue());
		if (getDUMMY_BEAN().getUI_M_AGENT_TO_PROCESS_DT() != null) {
			try {
				/*Added by Ameen on 13-06-2018 for KIC*/
				PT_AGENT_BONUS_VALUES_2_BEAN = new PT_AGENT_BONUS_VALUES_2();
				/*End*/
				// PREMIAGDC-326708 CHANGED QUERY TO TAKE VALUE FROM BEAN -
				// VIJAY ANAND - 21-08-2009

				String M_WHERE = "( ABV_AGENT_CODE BETWEEN '"
						+ getDUMMY_BEAN().getUI_M_AGENT_FM_CODE()
						+ "'  "
						+ "AND '"
						+ getDUMMY_BEAN().getUI_M_AGENT_TO_CODE()
						+ "')  "
						+ "AND (ABV_RANK_CODE BETWEEN '"
						+ getDUMMY_BEAN().getUI_M_AGENT_FM_RANK_CODE()
						+ "' AND '"
						/*+ getDUMMY_BEAN().getUI_M_AGENT_TO_CODE()*/
						+ getDUMMY_BEAN().getUI_M_AGENT_TO_RANK_CODE()
						+ "' ) "
						+ " AND ABV_PROCESS_DT BETWEEN "
						+ " '"
						+ CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
								.getUI_M_AGENT_FM_PROCESS_DT())
						+ "'"
						+ " AND "
						+ " '"
						+ CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
								.getUI_M_AGENT_TO_PROCESS_DT()) + "'";

				/*
				 * String Query = "select * from PT_AGENT_BONUS_VALUES where " +
				 * "ABV_AGENT_CODE BETWEEN '"+
				 * getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue() +"' and '"+
				 * getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue()+ "' and
				 * ABV_RANK_CODE between '"
				 * +getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue() +"'
				 * and '"+getCOMP_UI_M_AGENT_TO_RANK_CODE().getSubmittedValue() + "'
				 * and ABV_PROCESS_DT between'"+fromDate + "'and '"+endDate
				 * +"'";
				 */
				String Query = "SELECT ROWID, PT_AGENT_BONUS_VALUES.* from PT_AGENT_BONUS_VALUES WHERE "
						+ M_WHERE;
				System.out.println("\n\n Query is" + Query);
				list = crud.fetch(Query,
						"com.iii.pel.forms.PT048_A.PT_AGENT_BONUS_VALUES_2",
						getConnection());
				if (!list.isEmpty()) {
					postQueryAgentBonus();
					getAgentCodeDesc();
					whenNewRecordInstanceAgentBonus();
					/*Added by Ameen on 31-05-2018 for KIC*/
					PT_AGENT_BONUS_VALUES_2_BEAN = list.get(0);
					list.get(0).setRowSelected(true);
					/*End*/
				}
				
				/*Added by Ameen on 13-06-2018 for KIC as per Ajay sugg.*/
				fetchPolicyDtls(PT_AGENT_BONUS_VALUES_2_BEAN.getABV_AGENT_CODE());
				/*End*/
				setList(list);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public List autoCompleteAgentFromCode(Object event) {
		// COMP_UI_M_AGENT_FM_CODE.setSubmittedValue(null);
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		agentFrom = new ArrayList();
		String letter = event.toString();
		String query = null;
		try {
			if (letter.equalsIgnoreCase("*")) {
				query = "select CUST_CODE, CUST_NAME from PM_CUSTOMER where CUST_FRZ_FLAG = 'N' and rownum < 25";
			} else {
				query = "select CUST_CODE, CUST_NAME from PM_CUSTOMER where CUST_CODE LIKE"
						+ "'"
						+ letter
						+ "%'"
						+ "AND CUST_FRZ_FLAG = 'N' and rownum < 25";
			}
			rs = new CRUDHandler().executeSelectStatement(query,
					getConnection());
			while (rs.next()) {
				Agent bean = new Agent();
				bean.setCode(rs.getString(1));
				bean.setName(rs.getString(2));
				agentFrom.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentFrom;
	}

	// Bala(37618 commended following lines for PREMIA-GDC-1139247

	/*
	 * public String populateAgentFromCodeDesc(){
	 * 
	 * FacesContext ctx=FacesContext.getCurrentInstance(); UIViewRoot
	 * root=ctx.getViewRoot(); HtmlInputText text=(HtmlInputText)
	 * root.findComponent("DUMMY:UI_M_AGENT_FM_NAME"); String s=(String)
	 * getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue();
	 * 
	 * System.out.println("DUMMY_ACTION.populateAgentFromCodeDesc()###########
	 * "+s); if(!s.equalsIgnoreCase("")){ Iterator iter=agentFrom.iterator();
	 * while (iter.hasNext()) { Agent obj = (Agent) iter.next(); if
	 * (s.equals(obj.getCode())) { System.out
	 * .println("DUMMY_ACTION.populateAgentFromCodeDesc()>>> "+obj.getName());
	 * text.setSubmittedValue(obj.getName()); } } }else{
	 * text.setSubmittedValue(""); }return""; }
	 */

	public List autoCompleteAgentToCode(Object event) {
		// COMP_UI_M_AGENT_TO_CODE.setSubmittedValue(null);
		ResultSet rs = null;
		agentTo = new ArrayList();
		String letter = event.toString();
		String query = null;
		try {
			if (letter.equalsIgnoreCase("*")) {
				query = "select CUST_CODE, CUST_NAME from PM_CUSTOMER where CUST_FRZ_FLAG = 'N' and rownum < 25";
			} else {
				query = "select CUST_CODE, CUST_NAME from PM_CUSTOMER where CUST_CODE LIKE"
						+ "'"
						+ letter
						+ "%'"
						+ "AND CUST_FRZ_FLAG = 'N' and rownum < 25";
			}
			rs = new CRUDHandler().executeSelectStatement(query,
					getConnection());
			while (rs.next()) {
				Agent bean = new Agent();
				bean.setCode(rs.getString(1));
				bean.setName(rs.getString(2));
				/*
				 * [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating
				 * LOV values
				 */
				// agentFrom.add(bean);
				agentTo.add(bean);
				/*
				 * [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating
				 * LOV values ]
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentTo;
	}

	// Bala(37618 commended following lines for PREMIA-GDC-1139247
	/*
	 * public void populateAgentToCodeDesc(ActionEvent ae){
	 * 
	 * FacesContext ctx=FacesContext.getCurrentInstance(); UIViewRoot
	 * root=ctx.getViewRoot(); HtmlInputText text=(HtmlInputText)
	 * root.findComponent("DUMMY:UI_M_AGENT_TO_NAME"); String s=(String)
	 * getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue();
	 * if(!s.equalsIgnoreCase("")){ Iterator iter=agentTo.iterator(); while
	 * (iter.hasNext()) { Agent obj = (Agent) iter.next(); if
	 * (s.equals(obj.getCode())) { text.setSubmittedValue(obj.getName()); } }
	 * }else{ text.setSubmittedValue(""); } }
	 */

	// ///////////////
	public List autoCompleteAgentFromRankCode(Object event) {
		// COMP_UI_M_AGENT_FM_RANK_CODE.setSubmittedValue(null);
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		fromRank = new ArrayList();
		String letter = event.toString();
		/* [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV values */
		String query = null;
		try {

			if (letter.equalsIgnoreCase("*")) {
				query = "SELECT PC_CODE, PC_DESC FROM PM_CODES Where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
			} else {
				query = "SELECT PC_CODE, PC_DESC FROM PM_CODES Where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE LIKE "
						+ "'" + letter + "%'";
			}
			// stmt=getConnection().createStatement();
			// rs=stmt.executeQuery(query);
			rs = new CRUDHandler().executeSelectStatement(query,
					getConnection());
			while (rs.next()) {
				Rank bean = new Rank();
				bean.setCode(rs.getString(1));
				bean.setDesc(rs.getString(2));
				fromRank.add(bean);
			}
			/*
			 * BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV
			 * values ]
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fromRank;
	}

	// Bala(37618 commended following lines for PREMIA-GDC-1139247
	/*
	 * public void populateFromRankCodeDesc(ActionEvent ae){
	 * 
	 * FacesContext ctx=FacesContext.getCurrentInstance(); UIViewRoot
	 * root=ctx.getViewRoot(); HtmlInputText text=(HtmlInputText)
	 * root.findComponent("DUMMY:UI_M_AGENT_FM_RANK_CODE_DESC"); String
	 * s=(String) getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue();
	 * if(!s.equalsIgnoreCase("")){ Iterator iter=fromRank.iterator(); while
	 * (iter.hasNext()) { Rank obj = (Rank) iter.next(); if
	 * (s.equals(obj.getCode())) { text.setSubmittedValue(obj.getDesc()); } }
	 * }else{ text.setSubmittedValue(""); } }
	 */
	/** ********************************** */

	public List autoCompleteAgentToRankCode(Object event) {
		// COMP_UI_M_AGENT_TO_RANK_CODE.setSubmittedValue(null);
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		toRank = new ArrayList();
		String letter = event.toString();
		/* [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV values */
		String query = null;
		try {
			if (letter.equalsIgnoreCase("*")) {
				query = "SELECT PC_CODE, PC_DESC FROM PM_CODES Where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
			} else {
				query = "SELECT PC_CODE, PC_DESC FROM PM_CODES Where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE LIKE "
						+ "'" + letter + "%'";
			}
			// stmt=getConnection().createStatement();
			// rs=stmt.executeQuery(query);
			rs = new CRUDHandler().executeSelectStatement(query,
					getConnection());
			while (rs.next()) {
				Rank bean = new Rank();
				bean.setCode(rs.getString(1));
				bean.setDesc(rs.getString(2));
				toRank.add(bean);
			}
			/*
			 * BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV
			 * values ]
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toRank;
	}

	// Bala(37618 commended following lines for PREMIA-GDC-1139247
	/*
	 * public void populateToRankCodeDesc(ActionEvent ae){
	 * 
	 * FacesContext ctx=FacesContext.getCurrentInstance(); UIViewRoot
	 * root=ctx.getViewRoot(); HtmlInputText text=(HtmlInputText)
	 * root.findComponent("DUMMY:UI_M_AGENT_TO_RANK_CODE_DESC"); String
	 * s=(String) getCOMP_UI_M_AGENT_TO_RANK_CODE().getSubmittedValue();
	 * if(!s.equalsIgnoreCase("")){ Iterator iter=toRank.iterator(); while
	 * (iter.hasNext()) { Rank obj = (Rank) iter.next(); if
	 * (s.equals(obj.getCode())) { text.setSubmittedValue(obj.getDesc()); } }
	 * }else{ text.setSubmittedValue(""); } }
	 */
	private Connection getConnection() throws Exception {
		return CommonUtils.getConnection();
	}

	public String BONUS_APPROVAL() {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		System.out.println("\n\n DUMMY_ACTION.BONUS_APPROVAL()");
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				(String) getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue());
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				(String) getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue());
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				(String) getCOMP_UI_M_AGENT_TO_RANK_CODE().getSubmittedValue());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
						.getUI_M_AGENT_FM_PROCESS_DT()));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
						.getUI_M_AGENT_TO_PROCESS_DT()));

		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			ArrayList list = procHandler.execute(paramList, getConnection(),
					"P9ILPK_AGENT_BONUS.BONUS_APPROVAL");
			new CommonUtils().doComitt();
			if (!list.isEmpty() && list.size() > 0) {
				getWarningMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"91071").getSummary());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				ErrorHelpUtil.getErrorsforProcedureButtons(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						getCOMP_UI_M_BUT_APPROVE(), getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public String preForm() {
		String query1 = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE PARA_ID = 'BASE.CURR'";
		ResultSet rs1 = null;
		System.out.println("\n\n ++++++++++++++++++++  PRE-FORM is called");

		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
			STD_PRE_FORM();
			rs1 = getHandler().executeSelectStatement(query1,
					CommonUtils.getConnection());
			if (rs1.next()) {
				getDUMMY_BEAN().setUI_M_BASE_CURR(rs1.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		getPREFORMBUTTON().setDisabled(true);
		return null;
	}

	private void STD_PRE_FORM() {
		// P_GET_LOGO;
		// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		FacesContext ctx = FacesContext.getCurrentInstance();
		ControlBean controlBean = CommonUtils.getControlBean();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()\n---------->\n"
				+ session.toString() + "\n----------");
		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		controlBean.setM_PROG_NAME("PT048_A");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)"
				+ (String) session.get("GLOBAL.M_NAME"));
		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "
				+ controlBean.getM_LANG_CODE() + "\t"
				+ controlBean.getM_COMP_CODE() + "\t"
				+ controlBean.getM_PARA_1());
		/**
		 * GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN
		 * RECORD GROUP *
		 */
		/*
		 * M_MODULE_NAME :=
		 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
		 * COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ; M_TITLE:=
		 * NAME_IN('CTRL.M_USER_ID') ||' '||NAME_IN('CTRL.M_SCR_NAME')||'
		 * '||TO_CHAR(SYSDATE,'DD/MM/YY');
		 * SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
		 * HIDE_VIEW('ABOUT'); M_FIRST_BLOCK :=
		 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY( CURRENT_FORM_NAME),
		 * FIRSTBLOCK) ;
		 * 
		 * LOOP IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE'
		 * THEN IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; IF
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN IF
		 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; IF
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN IF
		 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; M_FIRST_BLOCK :=
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ; IF M_FIRST_BLOCK IN
		 * ('DUAL','CTRL','BUTTON_PALETTE') THEN EXIT ; END IF ; END LOOP ;
		 * 
		 * RG_ID := FIND_GROUP('RG_HINT') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; RG_ID :=
		 * FIND_GROUP('RG_ALERT_MSG') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; LOAD_BP;
		 * ENABLE_BUTTONS ; IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
		 * LOAD_BALOON_LABEL; END IF; END;
		 */
		session.put("controlBean", controlBean);
	}

	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public HtmlSuggestionBox getSuggestionBoxAgentFrom() {
		return suggestionBoxAgentFrom;
	}

	public void setSuggestionBoxAgentFrom(
			HtmlSuggestionBox suggestionBoxAgentFrom) {
		this.suggestionBoxAgentFrom = suggestionBoxAgentFrom;
	}

	public HtmlSuggestionBox getSuggestionBoxAgentTo() {
		return suggestionBoxAgentTo;
	}

	public void setSuggestionBoxAgentTo(HtmlSuggestionBox suggestionBoxAgentTo) {
		this.suggestionBoxAgentTo = suggestionBoxAgentTo;
	}

	public HtmlSuggestionBox getSuggestionBoxAgentRankFrom() {
		return suggestionBoxAgentRankFrom;
	}

	public void setSuggestionBoxAgentRankFrom(
			HtmlSuggestionBox suggestionBoxAgentRankFrom) {
		this.suggestionBoxAgentRankFrom = suggestionBoxAgentRankFrom;
	}

	public HtmlSuggestionBox getSuggestionBoxAgentRankTo() {
		return suggestionBoxAgentRankTo;
	}

	public void setSuggestionBoxAgentRankTo(
			HtmlSuggestionBox suggestionBoxAgentRankTo) {
		this.suggestionBoxAgentRankTo = suggestionBoxAgentRankTo;
	}

	public void setList(List<PT_AGENT_BONUS_VALUES_2> list) {
		this.list = list;
	}

	public List getList() {
		return list;
	}

	public void validateUI_M_AGENT_FM_CODE(ActionEvent e) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if ("".equals(getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue())) {
			System.out.println("DUMMY_ACTION.validateUI_M_AGENT_FM_CODE()");
			getCOMP_UI_M_AGENT_FM_CODE().setSubmittedValue("0");
		}
		String s = (String) getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue();
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		HtmlInputText text = (HtmlInputText) root
				.findComponent("DUMMY:UI_M_AGENT_FM_NAME");
		System.out
				.println("DUMMY_ACTION.populateAgentFromCodeDesc()########### "
						+ s);
		/*Added by Ameen on 30-05-2018 for KIC to set agent code*/
		DUMMY_BEAN.setUI_M_AGENT_FM_CODE(s);
		/*End*/
		if (!s.equalsIgnoreCase("")
				&& !"0"
						.equals(getCOMP_UI_M_AGENT_FM_CODE()
								.getSubmittedValue())) {
			Iterator iter = agentFrom.iterator();
			while (iter.hasNext()) {
				Agent obj = (Agent) iter.next();
				if (s.equals(obj.getCode())) {
					System.out
							.println("DUMMY_ACTION.populateAgentFromCodeDesc()>>> "
									+ obj.getName());
					text.setSubmittedValue(obj.getName());

					session.setAttribute("agent", obj.getName());

				}
			}
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_TO_CODE");
		} else {
			text.setSubmittedValue("");
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_TO_CODE");
		}

		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateUI_M_AGENT_TO_CODE(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if (((String) getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue()).trim()
				.equals("0")) {
			getCOMP_UI_M_AGENT_TO_CODE().setSubmittedValue("zzzzzzz");
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_FM_RANK_CODE");
			// System.out.println("DUMMY_ACTION.validateUI_M_AGENT_TO_CODE()IN
			// IF LOOP");
			/*
			 * [ BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Defaulting
			 * the From Field value when To field is empty.
			 */
		} else if ("".equals(input.getSubmittedValue())) {
			/*
			 * BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Defaulting the
			 * From Field value when To field is empty. ]
			 */
			getCOMP_UI_M_AGENT_TO_CODE().setSubmittedValue(
					getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue());
			getCOMP_UI_M_AGENT_TO_NAME().setSubmittedValue(
					session.getAttribute("agent"));
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_FM_RANK_CODE");
			// System.out.println("DUMMY_ACTION.validateUI_M_AGENT_TO_CODE()>>>>>>
			// ELSE IF LOOOP "+getCOMP_UI_M_AGENT_FM_NAME().getSubmittedValue()
			// +DUMMY_BEAN.getUI_M_AGENT_FM_NAME());
			// System.out.println("DUMMY_ACTION.validateUI_M_AGENT_TO_CODE()
			// "+(HtmlInputText)
			// root.findComponent("DUMMY:UI_M_AGENT_FM_NAME"));

		}
		/*
		 * [ BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Fetching the
		 * Description
		 */
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		HtmlInputText text = (HtmlInputText) root
				.findComponent("DUMMY:UI_M_AGENT_TO_NAME");
		String s = (String) getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue();
		/*Added by Ameen on 30-05-2018 for KIC to set agent code*/
		DUMMY_BEAN.setUI_M_AGENT_TO_CODE(s);
		/*End*/
		if (!s.equalsIgnoreCase("")
				&& !"zzzzzzz".equals(getCOMP_UI_M_AGENT_TO_CODE()
						.getSubmittedValue())) {
			if (agentTo != null) {
				Iterator iter = agentTo.iterator();
				while (iter.hasNext()) {
					Agent obj = (Agent) iter.next();
					if (s.equals(obj.getCode())) {
						text.setSubmittedValue(obj.getName());
					}
				}
			}
		} else {
			text.setSubmittedValue("");
		}
		/*
		 * BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Fetching the
		 * Description ]
		 */
		System.out.println("dummy_action:  validateUI_M_AGENT_TO_CODE");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_AGENT_FM_RANK_CODE(ActionEvent e) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if ("".equals(getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue())) {
			getCOMP_UI_M_AGENT_FM_RANK_CODE().setSubmittedValue("0");
		}
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		HtmlInputText text = (HtmlInputText) root
				.findComponent("DUMMY:UI_M_AGENT_FM_RANK_CODE_DESC");
		String s = (String) getCOMP_UI_M_AGENT_FM_RANK_CODE()
				.getSubmittedValue();
		/*Added by Ameen on 30-05-2018 for KIC to set agent code*/
		DUMMY_BEAN.setUI_M_AGENT_FM_RANK_CODE(s);
		/*End*/
		if (!s.equalsIgnoreCase("")
				&& !"0".equals(getCOMP_UI_M_AGENT_FM_RANK_CODE()
						.getSubmittedValue())) {
			/*
			 * [ BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Null value
			 * checking
			 */
			if (fromRank != null) {
				Iterator iter = fromRank.iterator();
				while (iter.hasNext()) {
					Rank obj = (Rank) iter.next();
					if (s.equals(obj.getCode())) {
						text.setSubmittedValue(obj.getDesc());
						session.setAttribute("rank", obj.getDesc());
					}
				}
			}
			/*
			 * BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Null value
			 * checking ]
			 */
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_TO_RANK_CODE");
		} else {
			text.setSubmittedValue("");
			DUMMY_BEAN.setFocus("DUMMY:UI_M_AGENT_TO_RANK_CODE");
		}
		UIInput input = (UIInput) e.getComponent().getParent();

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_AGENT_TO_RANK_CODE(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if ("0".equals(getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue())) {
			getCOMP_UI_M_AGENT_TO_RANK_CODE().setSubmittedValue("zzzzzzz");
			/*
			 * [BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Defaulting
			 * the From Field value when To field is empty.
			 */
		} else if ("".equals(input.getSubmittedValue())) {
			/*
			 * [BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Defaulting
			 * the From Field value when To field is empty.]
			 */
			getCOMP_UI_M_AGENT_TO_RANK_CODE().setSubmittedValue(
					getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue());
			getCOMP_UI_M_AGENT_TO_RANK_CODE_DESC().setSubmittedValue(
					session.getAttribute("rank"));
		}

		/*
		 * [BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Fetching the
		 * description
		 */
		FacesContext ctx = FacesContext.getCurrentInstance();
		UIViewRoot root = ctx.getViewRoot();
		HtmlInputText text = (HtmlInputText) root
				.findComponent("DUMMY:UI_M_AGENT_TO_RANK_CODE_DESC");
		String s = (String) getCOMP_UI_M_AGENT_TO_RANK_CODE()
				.getSubmittedValue();
		/*Added by Ameen on 30-05-2018 for KIC to set agent code*/
		DUMMY_BEAN.setUI_M_AGENT_TO_RANK_CODE(s);
		/*End*/
		if (!s.equalsIgnoreCase("")
				&& !"zzzzzzz".equals(getCOMP_UI_M_AGENT_TO_RANK_CODE()
						.getSubmittedValue())) {
			if (toRank != null) {
				Iterator iter = toRank.iterator();
				while (iter.hasNext()) {
					Rank obj = (Rank) iter.next();
					if (s.equals(obj.getCode())) {
						text.setSubmittedValue(obj.getDesc());
					}
				}
			}
		} else {
			text.setSubmittedValue("");
		}
		/*
		 * [BugId:PREMIAGDC-INTERNALFIX-0029 Deepika 04-Feb-09 Fetching the
		 * description
		 */
		// UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * [ BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always
	 * be <= To date
	 */
	public void fireForDateValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always be <=
	 * To date ]
	 */

	/*
	 * [ BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always
	 * be <= To date
	 */
	public void validateUI_M_AGENT_FM_PROCESS_DT(FacesContext fc,
			UIComponent component, Object value) throws Exception {

		System.out.println("DUMMY_ACTION.onTaboutFromDate()000000 "
				+ DUMMY_BEAN.getUI_M_AGENT_FM_PROCESS_DT());
		if (value != null) {
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			Date fromDate = htmlCalendar.getAsDate(htmlCalendar
					.getSubmittedValue());
			System.out.println("DUMMY_ACTION.validatorForFromDate() "
					+ fromDate);
			DUMMY_BEAN.setUI_M_AGENT_FM_PROCESS_DT(fromDate);
			if (DUMMY_BEAN.getUI_M_AGENT_TO_PROCESS_DT() != null) {
				Date toDate = DUMMY_BEAN.getUI_M_AGENT_TO_PROCESS_DT();
				if (fromDate.after(toDate)) {
					System.out
							.println("DUMMY_ACTION.validatorForFromDate() GOT ");
					FacesMessage errorMessage = Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71145");
					throw new ValidatorException(errorMessage);
					// getErrorMap().put("current",errorMessage.getSummary());

				}
			}

		}

		/*
		 * UIInput input = (UIInput) e.getComponent().getParent();
		 * System.out.println("dummy_action: validateUI_M_AGENT_FM_PROCESS_DT");
		 * 
		 * ErrorHelpUtil.validate(input, getErrorMap());
		 */
	}

	/*
	 * BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always be <=
	 * To date ]
	 */

	/*
	 * [ BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always
	 * be <= To date
	 */
	// public void onTaboutFromDate(ActionEvent ae){}
	public void fireToDateValidation(ActionEvent actionEvent) {
		System.out.println("The to date entered is: "
				+ getCOMP_UI_M_AGENT_TO_PROCESS_DT().getSubmittedValue());
		Object toDate = getCOMP_UI_M_AGENT_TO_PROCESS_DT().getSubmittedValue();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		//populateValues(toDate);
	}

	public void validatorToFromDate(FacesContext context,
			UIComponent component, Object value1) throws ValidatorException {
		if (value1 != null) {
			Date fm_date = (Date) value1;
			/*Added by Ameen on 30-05-2018 for KIC to set agent code*/
			DUMMY_BEAN.setUI_M_AGENT_TO_PROCESS_DT(fm_date);
			/*End*/
			if (getDUMMY_BEAN().getUI_M_AGENT_TO_PROCESS_DT() != null) {
				if (fm_date
						.after(getDUMMY_BEAN().getUI_M_AGENT_TO_PROCESS_DT())) {
					/*
					 * HtmlCalendar htmlCalendar = (HtmlCalendar) component; //
					 * Date toDate =
					 * htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
					 * Date toDate = (Date)value1;
					 * DUMMY_BEAN.setUI_M_AGENT_TO_PROCESS_DT(toDate); Date
					 * fromDate=DUMMY_BEAN.getUI_M_AGENT_FM_PROCESS_DT();
					 * System.out.println("DUMMY_ACTION.validatorForFromDate()
					 * "+fromDate);
					 * if(DUMMY_BEAN.getUI_M_AGENT_TO_PROCESS_DT()!=null){
					 * if(fromDate.after(toDate)) {
					 */System.out
							.println("DUMMY_ACTION.validatorForFromDate() GOT ");
					FacesMessage errorMessage = Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71145");
					throw new ValidatorException(errorMessage);
					// getErrorMap().put("current",errorMessage.getSummary());
				}
				populateValues(DUMMY_BEAN.getUI_M_AGENT_TO_PROCESS_DT());
			}
		}
	}

	/*
	 * BugId:PREMIAGDC-AGENCY-0023 Deepika 04-Feb-09 From date should always be <=
	 * To date ]
	 */
	public void validateUI_M_AGENT_TO_PROCESS_DT(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		System.out.println("dummy_action:  validateUI_M_AGENT_TO_PROCESS_DT");

		ErrorHelpUtil.validate(input, getErrorMap());

		// System.out.println("\n\n Rerender is happening and populating
		// values");
		// CRUDHandler crud = new CRUDHandler();
		/*
		 * try{ String fromDate = (String)
		 * getCOMP_UI_M_AGENT_FM_PROCESS_DT().getSubmittedValue();
		 * 
		 * String endDate = (String)
		 * getCOMP_UI_M_AGENT_TO_PROCESS_DT().getSubmittedValue();
		 * 
		 * 
		 * String Query = "select * from PT_AGENT_BONUS_VALUES where " +
		 * "ABV_AGENT_CODE BETWEEN '"+
		 * getCOMP_UI_M_AGENT_FM_CODE().getSubmittedValue() +"' and '"+
		 * getCOMP_UI_M_AGENT_TO_CODE().getSubmittedValue()+ "' and
		 * ABV_RANK_CODE between '"
		 * +getCOMP_UI_M_AGENT_FM_RANK_CODE().getSubmittedValue() +"' and
		 * '"+getCOMP_UI_M_AGENT_TO_RANK_CODE().getSubmittedValue() + "' and
		 * ABV_PROCESS_DT between'"+fromDate + "'and '"+endDate +"'";
		 * 
		 * if(!"".equals(getCOMP_UI_M_AGENT_TO_PROCESS_DT().getSubmittedValue()) && !
		 * "".equals(getCOMP_UI_M_AGENT_FM_PROCESS_DT().getSubmittedValue())){
		 * String Query = "select ROWID, PT_AGENT_BONUS_VALUES.* from
		 * PT_AGENT_BONUS_VALUES"; System.out.println("\n\n in todate tabout
		 * Query is"+ Query); list = crud.fetch(Query,
		 * "com.iii.pel.forms.PT048_A.PT_AGENT_BONUS_VALUES_2",
		 * getConnection()); PT_AGENT_BONUS_VALUES_2 b =
		 * (PT_AGENT_BONUS_VALUES_2)list.get(0); System.out .println("The rowid
		 * is: "+b.getROWID()+b.getABV_AGENT_CODE()); setList(list); }
		 * }catch(Exception e1){ e1.printStackTrace(); }
		 */
	}

	/*
	 * public List getBonusList() { if (bonusList.size() ==0){
	 * bonusList.clear(); FacesContext fc = FacesContext.getCurrentInstance();
	 * ServletContext context = (ServletContext) fc.getExternalContext()
	 * .getContext(); SimpleConnectionAgent connectionAgent =
	 * (SimpleConnectionAgent) context .getAttribute("connectionAgent");
	 * Connection con; try { con = connectionAgent.getConnection("123");
	 * ResultSet rs = con.createStatement().executeQuery("SELECT PS_CODE_DESC,
	 * PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'AGT_BONUS' ORDER BY 1");
	 * while(rs.next()){ bonusList.add(new SelectItem(rs.getString(1))); } }
	 * catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 *  } return bonusList; }
	 */

	/*
	 * public void setBonusList(List bonusList) { this.bonusList = bonusList; }
	 */

	/*
	 * public List<SelectItem> getFlagList() { if (flagList.size() ==0){
	 * flagList.clear(); flagList.add(new SelectItem("No")); flagList.add(new
	 * SelectItem("Yes")); }
	 * 
	 * return flagList; }
	 * 
	 * public void setFlagList(List<SelectItem> flagList) { this.flagList =
	 * flagList; }
	 */

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	// PREMIAGDC-326708 The Below Method Added For Defaulting Values from Agent
	// Bonus Processing
	// Vijay Anand. 21-08-2009

	public void populateDataforBonusApproval(PhaseEvent event) {
		/*
		 * commeneted by Ameen on 30-05-2018 for KIC to set agent code
		 * DUMMY_BEAN.setUI_M_AGENT_FM_CODE((String) CommonUtils
				.getGlobalObject("GLOBAL.PP047A_AGENT_FROM"));
		DUMMY_BEAN.setUI_M_AGENT_TO_CODE((String) CommonUtils
				.getGlobalObject("GLOBAL.PP047A_AGENT_TO"));
		DUMMY_BEAN.setUI_M_AGENT_FM_PROCESS_DT((Date) CommonUtils
				.getGlobalObject("GLOBAL.PP047A_PROD_FM_DT"));
		DUMMY_BEAN.setUI_M_AGENT_TO_PROCESS_DT((Date) CommonUtils
				.getGlobalObject("GLOBAL.PP047A_PROD_TO_DT"));
		DUMMY_BEAN.setUI_M_AGENT_FM_RANK_CODE("0");
		DUMMY_BEAN.setUI_M_AGENT_TO_RANK_CODE("zzzzzzzzz");
		populateValues(DUMMY_BEAN.getUI_M_AGENT_TO_PROCESS_DT());*/
		/*Added by pidugu raj dt: 10-10-2018 for KICLIFEQC-1772920 as suggested by janani*/
		try{
		String M_WHERE = "( ABV_AGENT_CODE BETWEEN '"
				+ getDUMMY_BEAN().getUI_M_AGENT_FM_CODE()
				+ "'  "
				+ "AND '"
				+ getDUMMY_BEAN().getUI_M_AGENT_TO_CODE()
				+ "')  "
				+ "AND (ABV_RANK_CODE BETWEEN '"
				+ getDUMMY_BEAN().getUI_M_AGENT_FM_RANK_CODE()
				+ "' AND '"
				/*+ getDUMMY_BEAN().getUI_M_AGENT_TO_CODE()*/
				+ getDUMMY_BEAN().getUI_M_AGENT_TO_RANK_CODE()
				+ "' ) "
				+ " AND ABV_PROCESS_DT BETWEEN "
				+ " '"
				+ CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
						.getUI_M_AGENT_FM_PROCESS_DT())
				+ "'"
				+ " AND "
				+ " '"
				+ CommonUtils.dateToStringFormatter(getDUMMY_BEAN()
						.getUI_M_AGENT_TO_PROCESS_DT()) + "'";

	
		String Query = "SELECT ROWID, PT_AGENT_BONUS_VALUES.* from PT_AGENT_BONUS_VALUES WHERE "
				+ M_WHERE;
		System.out.println("\n\n Query is" + Query);
		CRUDHandler crud = new CRUDHandler();
		list = crud.fetch(Query,
				"com.iii.pel.forms.PT048_A.PT_AGENT_BONUS_VALUES_2",
				getConnection());
		if(list != null && !list.isEmpty()){
			setList(list);
		}
		}
		
		
		catch(Exception e){
			e.printStackTrace();
		}
		/*End Added by pidugu raj dt: 10-10-2018 for KICLIFEQC-1772920 as suggested by janani*/
	}

	public void gridtabListener() {
		System.out.println("\n\n Inside the gridtabListener method");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_AGENT_BONUS_VALUES_2 gridValueBean = null;
		System.out.println("   " + currRowIndex + "  " + prevRowIndex);
		try {
			if (currRowIndex != prevRowIndex) {
				System.out.println("GRID TAB LISTENER");
				// Get the bean based on row index
				gridValueBean = (PT_AGENT_BONUS_VALUES_2) list
						.get(prevRowIndex);

				// Update the record to database
				if (gridValueBean.getROWID() != null) {
					System.out.println("Update action is called");
					CRUDHandler handler = new CRUDHandler();
					handler.executeUpdate(gridValueBean, getConnection());
					System.out.println("The ROWID to be updated is:  "
							+ gridValueBean.getROWID()
							+ gridValueBean.getABV_PERIOD_FM_DT());
					getErrorMap().put("somekey",
							rowUpdated + " record updated.");
					getErrorMap().put("current",
							rowUpdated + " record updated.");
					getConnection().commit();
				}
				// Update previous row index
				prevRowIndex = currRowIndex;
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}
		return;
	}

	public void gridABV_AGENT_CODEValidate(ActionEvent e) {
		String value = getCurrentValue(e);
		System.out.println("\n\n ABV_AGENT_CODE Action Listener is called    "
				+ getDataTable().getRowIndex());
		int rowIndex = getDataTable().getRowIndex();
		System.out.println("\n\n ABV_AGENT_CODE Action Listener is called    "
				+ rowIndex + "   " + value);
		list.get(rowIndex).setABV_AGENT_CODE(value);
		gridtabListener();
	}

	public void gridABV_FC_VALUEValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_FC_VALUE(Double.parseDouble(value));
		gridtabListener();
	}

	public void gridABV_LC_VALUEValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_LC_VALUE(Double.parseDouble(value));
		gridtabListener();
	}

	public void gridABV_PERIOD_FM_DTValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		System.out
				.println("DUMMY_ACTION.gridABV_PERIOD_FM_DTValidate() value is:  "
						+ value);
		int rowIndex = getDataTable().getRowIndex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			list.get(rowIndex).setABV_PERIOD_FM_DT(sdf.parse(value));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		gridtabListener();
	}

	public void gridABV_PERIOD_TO_DTValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			list.get(rowIndex).setABV_PERIOD_TO_DT(sdf.parse(value));
		} catch (Exception e1) {

		}
		gridtabListener();
	}

	public void gridABV_PAID_DTValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			list.get(rowIndex).setABV_PAID_DT(sdf.parse(value));
		} catch (Exception e1) {

		}
		gridtabListener();
	}

	public void gridABV_BONUS_CODEValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_BONUS_CODE(value);
		gridtabListener();
	}

	public void gridABV_CURR_CODEValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_CURR_CODE(value);
		gridtabListener();
	}

	public void gridABV_BONUS_TYPEValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentComboBoxValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_BONUS_TYPE(value);
		gridtabListener();
	}

	public void gridABV_FRZ_FLAGValidate(ActionEvent e) {
		System.out.println("\n\n Action Listener is called");
		String value = getCurrentComboBoxValue(e);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setABV_FRZ_FLAG(value);
		gridtabListener();
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + input.getId());
			}
		}
		return value;
	}

	public String getCurrentComboBoxValue(ActionEvent event) {
		String value = null;
		System.out.println("The listbox coomponent is:  "
				+ event.getComponent().getParent().getClass());
		HtmlSelectOneMenu selectMenu = (HtmlSelectOneMenu) event.getComponent()
				.getParent();
		value = (String) selectMenu.getSubmittedValue();
		/*
		 * selecton input = null; if(event != null){ input = (UIInput)
		 * event.getComponent().getParent(); if(input != null){ value = (String)
		 * input.getSubmittedValue(); System.out.println("Value in input field:
		 * "+input.getId()); } }
		 */
		return value;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	private void postQueryAgentBonus() {
		String query1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE  CUST_CODE = ?";
		String query2 = "SELECT ABS_DESC FROM PM_AGENT_BONUS_SETUP WHERE ABS_CODE = ?";
		String M_CUST_NAME = null;
		ResultSet rs2 = null;
		try {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setUI_M_ABV_CURR_CODE_DESC(
						L_VAL_CURR(list.get(i).getABV_CURR_CODE(), "", "N",
								"N", ""));
				Object[] values = { list.get(i).getABV_BONUS_CODE() };
				rs2 = getHandler().executeSelectStatement(query2,
						CommonUtils.getConnection(), values);
				if (rs2.next()) {
					list.get(i).setUI_M_ABV_BONUS_DESC(rs2.getString(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getLocalizedMessage());
			getErrorMap().put("details", e.getLocalizedMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String L_VAL_CURR(String P_CURR_CODE, String P_CURR_NAME,
			String P_NAME_FLAG, String P_ERR_FLAG, String P_CUST_CODE) {
		String M_NAME = null, M_BL_NAME = null, M_FRZ_FLAG = null, M_CUST_CODE = null;
		String query1 = "SELECT DECODE(?,'N',CURR_NAME,CURR_SHORT_NAME), "
				+ "DECODE(?,'N',CURR_BL_NAME,CURR_BL_SHORT_NAME), CURR_FRZ_FLAG "
				+ "FROM PM_CURRENCY " + "WHERE  CURR_CODE = ? "
				+ "AND CURR_CODE IN ( SELECT CCUR_CURR_CODE FROM PM_CUST_CURR "
				+ "WHERE  CCUR_CURR_CODE = CURR_CODE "
				+ "AND CCUR_CUST_CODE = NVL(?, CCUR_CUST_CODE))";
		ResultSet rs1 = null;
		try {
			M_CUST_CODE = P_CUST_CODE;

			Object[] values = { P_NAME_FLAG, P_NAME_FLAG, P_CURR_CODE,
					M_CUST_CODE };
			rs1 = getHandler().executeSelectStatement(query1,
					CommonUtils.getConnection(), values);
			if (rs1.next()) {
				M_NAME = rs1.getString(1);
				M_BL_NAME = rs1.getString(2);
				M_FRZ_FLAG = rs1.getString(3);
			} else {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					getErrorMap()
							.put(
									"current",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"1605").getSummary());
					getErrorMap()
							.put(
									"details",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"1605").getSummary());
					if ("E".equalsIgnoreCase(P_ERR_FLAG)) {
						throw new ValidatorException(
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"1605"));
					}
				}
			}
			if ("Y".equalsIgnoreCase(M_FRZ_FLAG)) {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					getErrorMap()
							.put(
									"current",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"1023").getSummary());
					getErrorMap()
							.put(
									"details",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"1023").getSummary());
					if ("E".equalsIgnoreCase(P_ERR_FLAG)) {
						throw new ValidatorException(
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"1023"));
					}
				}
			}

			/*
			 * if("1".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4,
			 * 5)) ||
			 * "ENG".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"))){
			 * P_CURR_NAME = M_NAME; }else{ P_CURR_NAME = M_BL_NAME; }
			 */
		} catch (ValidatorException ve) {
			ve.printStackTrace();
			throw ve;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (DBException dbe) {
			dbe.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return P_CURR_NAME;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	private void getAgentCodeDesc() {
		String query1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		String M_CUST_NAME = null;
		ResultSet rs1 = null;
		try {
			for (int i = 0; i < list.size(); i++) {
				Object[] values = { list.get(i).getABV_AGENT_CODE() };
				rs1 = getHandler().executeSelectStatement(query1,
						CommonUtils.getConnection(), values);
				if (rs1.next()) {
					list.get(i).setUI_M_ABV_AGENT_CODE_DESC_BONUS(
							rs1.getString(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void whenNewRecordInstanceAgentBonus() {
		String query1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		String M_CURR_ITEM = null, M_TEMP_ITEM = null;
		try {
			for (int i = 0; i < getList().size(); i++) {
				if ("Y".equalsIgnoreCase(list.get(i).getABV_PAID_FLAG())) {
					setDisabledWhenApproved(true);
				} else {
					setDisabledWhenApproved(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (list.size() != 0) {
				PT_AGENT_BONUS_VALUES_2_BEAN = (PT_AGENT_BONUS_VALUES_2) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_BONUS_VALUES_2_BEAN.setRowSelected(true);
			// Reset selection for other beans
			
			/*Added by Ameen on 13-06-2018 for KIC as per Ajay sugg.*/
			fetchPolicyDtls(PT_AGENT_BONUS_VALUES_2_BEAN.getABV_AGENT_CODE());
			/*End*/

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_AGENT_BONUS_VALUES_2> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS.resetValue();
		COMP_ABV_BONUS_CODE.resetValue();
		COMP_ABV_CURR_CODE.resetValue();
		COMP_ABV_PROCESS_YR.resetValue();
		COMP_ABV_PR_RATE_NR.resetValue();
		COMP_ABV_PR_RATE_DR.resetValue();
		COMP_UI_M_ABV_BONUS_DESC.resetValue();
		COMP_UI_M_ABV_CURR_CODE_DESC.resetValue();
		COMP_ABV_PERIOD_FM_DT.resetValue();
		COMP_ABV_PERIOD_TO_DT.resetValue();
		
		/*Added by ganesh on 02-06-2018 */
		
		COMP_ABV_AGENT_CODE.resetValue();
		COMP_ABV_BONUS_TYPE.resetValue();
		COMP_ABV_FC_VALUE.resetValue();
		COMP_ABV_LC_VALUE.resetValue();
		COMP_ABV_PAID_DT.resetValue();
		COMP_ABV_FRZ_FLAG.resetValue();
		
		/*end*/

	}

	public boolean isDisabledWhenApproved() {
		return disabledWhenApproved;
	}

	public void setDisabledWhenApproved(boolean disabledWhenApproved) {
		this.disabledWhenApproved = disabledWhenApproved;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABV_AGENT_CODE_DESC_BONUS_LABEL() {
		return COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS_LABEL;
	}

	public void setCOMP_UI_M_ABV_AGENT_CODE_DESC_BONUS_LABEL(
			HtmlOutputLabel comp_ui_m_abv_agent_code_desc_bonus_label) {
		COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS_LABEL = comp_ui_m_abv_agent_code_desc_bonus_label;
	}

	public HtmlInputText getCOMP_UI_M_ABV_AGENT_CODE_DESC_BONUS() {
		return COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS;
	}

	public void setCOMP_UI_M_ABV_AGENT_CODE_DESC_BONUS(
			HtmlInputText comp_ui_m_abv_agent_code_desc_bonus) {
		COMP_UI_M_ABV_AGENT_CODE_DESC_BONUS = comp_ui_m_abv_agent_code_desc_bonus;
	}

	public List getAgentFrom() {
		return agentFrom;
	}

	public void setAgentFrom(List agentFrom) {
		this.agentFrom = agentFrom;
	}

	public List getAgentTo() {
		return agentTo;
	}

	public void setAgentTo(List agentTo) {
		this.agentTo = agentTo;
	}

	public List getFromRank() {
		return fromRank;
	}

	public void setFromRank(List fromRank) {
		this.fromRank = fromRank;
	}

	public List getToRank() {
		return toRank;
	}

	public void setToRank(List toRank) {
		this.toRank = toRank;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public HtmlOutputLabel getCOMP_ABV_AGENT_CODE_LABEL() {
		return COMP_ABV_AGENT_CODE_LABEL;
	}

	public void setCOMP_ABV_AGENT_CODE_LABEL(
			HtmlOutputLabel comp_abv_agent_code_label) {
		COMP_ABV_AGENT_CODE_LABEL = comp_abv_agent_code_label;
	}

	public HtmlInputText getCOMP_ABV_AGENT_CODE() {
		return COMP_ABV_AGENT_CODE;
	}

	public void setCOMP_ABV_AGENT_CODE(HtmlInputText comp_abv_agent_code) {
		COMP_ABV_AGENT_CODE = comp_abv_agent_code;
	}

	public HtmlOutputLabel getCOMP_ABV_BONUS_TYPE_LABEL() {
		return COMP_ABV_BONUS_TYPE_LABEL;
	}

	public void setCOMP_ABV_BONUS_TYPE_LABEL(
			HtmlOutputLabel comp_abv_bonus_type_label) {
		COMP_ABV_BONUS_TYPE_LABEL = comp_abv_bonus_type_label;
	}

	public HtmlSelectOneMenu getCOMP_ABV_BONUS_TYPE() {
		return COMP_ABV_BONUS_TYPE;
	}

	public void setCOMP_ABV_BONUS_TYPE(HtmlSelectOneMenu comp_abv_bonus_type) {
		COMP_ABV_BONUS_TYPE = comp_abv_bonus_type;
	}

	public HtmlOutputLabel getCOMP_ABV_BONUS_CODE_LABEL() {
		return COMP_ABV_BONUS_CODE_LABEL;
	}

	public void setCOMP_ABV_BONUS_CODE_LABEL(
			HtmlOutputLabel comp_abv_bonus_code_label) {
		COMP_ABV_BONUS_CODE_LABEL = comp_abv_bonus_code_label;
	}

	public HtmlInputText getCOMP_ABV_BONUS_CODE() {
		return COMP_ABV_BONUS_CODE;
	}

	public void setCOMP_ABV_BONUS_CODE(HtmlInputText comp_abv_bonus_code) {
		COMP_ABV_BONUS_CODE = comp_abv_bonus_code;
	}

	public HtmlOutputLabel getCOMP_ABV_CURR_CODE_LABEL() {
		return COMP_ABV_CURR_CODE_LABEL;
	}

	public void setCOMP_ABV_CURR_CODE_LABEL(
			HtmlOutputLabel comp_abv_curr_code_label) {
		COMP_ABV_CURR_CODE_LABEL = comp_abv_curr_code_label;
	}

	public HtmlInputText getCOMP_ABV_CURR_CODE() {
		return COMP_ABV_CURR_CODE;
	}

	public void setCOMP_ABV_CURR_CODE(HtmlInputText comp_abv_curr_code) {
		COMP_ABV_CURR_CODE = comp_abv_curr_code;
	}

	public HtmlOutputLabel getCOMP_ABV_PROCESS_YR_LABEL() {
		return COMP_ABV_PROCESS_YR_LABEL;
	}

	public void setCOMP_ABV_PROCESS_YR_LABEL(
			HtmlOutputLabel comp_abv_process_yr_label) {
		COMP_ABV_PROCESS_YR_LABEL = comp_abv_process_yr_label;
	}

	public HtmlInputText getCOMP_ABV_PROCESS_YR() {
		return COMP_ABV_PROCESS_YR;
	}

	public void setCOMP_ABV_PROCESS_YR(HtmlInputText comp_abv_process_yr) {
		COMP_ABV_PROCESS_YR = comp_abv_process_yr;
	}

	public HtmlOutputLabel getCOMP_ABV_PR_RATE_NR_LABEL() {
		return COMP_ABV_PR_RATE_NR_LABEL;
	}

	public void setCOMP_ABV_PR_RATE_NR_LABEL(
			HtmlOutputLabel comp_abv_pr_rate_nr_label) {
		COMP_ABV_PR_RATE_NR_LABEL = comp_abv_pr_rate_nr_label;
	}

	public HtmlInputText getCOMP_ABV_PR_RATE_NR() {
		return COMP_ABV_PR_RATE_NR;
	}

	public void setCOMP_ABV_PR_RATE_NR(HtmlInputText comp_abv_pr_rate_nr) {
		COMP_ABV_PR_RATE_NR = comp_abv_pr_rate_nr;
	}

	public HtmlOutputLabel getCOMP_ABV_PR_RATE_DR_LABEL() {
		return COMP_ABV_PR_RATE_DR_LABEL;
	}

	public void setCOMP_ABV_PR_RATE_DR_LABEL(
			HtmlOutputLabel comp_abv_pr_rate_dr_label) {
		COMP_ABV_PR_RATE_DR_LABEL = comp_abv_pr_rate_dr_label;
	}

	public HtmlInputText getCOMP_ABV_PR_RATE_DR() {
		return COMP_ABV_PR_RATE_DR;
	}

	public void setCOMP_ABV_PR_RATE_DR(HtmlInputText comp_abv_pr_rate_dr) {
		COMP_ABV_PR_RATE_DR = comp_abv_pr_rate_dr;
	}

	public HtmlOutputLabel getCOMP_ABV_FC_VALUE_LABEL() {
		return COMP_ABV_FC_VALUE_LABEL;
	}

	public void setCOMP_ABV_FC_VALUE_LABEL(
			HtmlOutputLabel comp_abv_fc_value_label) {
		COMP_ABV_FC_VALUE_LABEL = comp_abv_fc_value_label;
	}

	public HtmlInputText getCOMP_ABV_FC_VALUE() {
		return COMP_ABV_FC_VALUE;
	}

	public void setCOMP_ABV_FC_VALUE(HtmlInputText comp_abv_fc_value) {
		COMP_ABV_FC_VALUE = comp_abv_fc_value;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABV_BONUS_DESC_LABEL() {
		return COMP_UI_M_ABV_BONUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABV_BONUS_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_abv_bonus_desc_label) {
		COMP_UI_M_ABV_BONUS_DESC_LABEL = comp_ui_m_abv_bonus_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_ABV_BONUS_DESC() {
		return COMP_UI_M_ABV_BONUS_DESC;
	}

	public void setCOMP_UI_M_ABV_BONUS_DESC(
			HtmlInputText comp_ui_m_abv_bonus_desc) {
		COMP_UI_M_ABV_BONUS_DESC = comp_ui_m_abv_bonus_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABV_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_ABV_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABV_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_abv_curr_code_desc_label) {
		COMP_UI_M_ABV_CURR_CODE_DESC_LABEL = comp_ui_m_abv_curr_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_ABV_CURR_CODE_DESC() {
		return COMP_UI_M_ABV_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_ABV_CURR_CODE_DESC(
			HtmlInputText comp_ui_m_abv_curr_code_desc) {
		COMP_UI_M_ABV_CURR_CODE_DESC = comp_ui_m_abv_curr_code_desc;
	}

	public HtmlOutputLabel getCOMP_ABV_LC_VALUE_LABEL() {
		return COMP_ABV_LC_VALUE_LABEL;
	}

	public void setCOMP_ABV_LC_VALUE_LABEL(
			HtmlOutputLabel comp_abv_lc_value_label) {
		COMP_ABV_LC_VALUE_LABEL = comp_abv_lc_value_label;
	}

	public HtmlInputText getCOMP_ABV_LC_VALUE() {
		return COMP_ABV_LC_VALUE;
	}

	public void setCOMP_ABV_LC_VALUE(HtmlInputText comp_abv_lc_value) {
		COMP_ABV_LC_VALUE = comp_abv_lc_value;
	}

	public HtmlOutputLabel getCOMP_ABV_PERIOD_FM_DT_LABEL() {
		return COMP_ABV_PERIOD_FM_DT_LABEL;
	}

	public void setCOMP_ABV_PERIOD_FM_DT_LABEL(
			HtmlOutputLabel comp_abv_period_fm_dt_label) {
		COMP_ABV_PERIOD_FM_DT_LABEL = comp_abv_period_fm_dt_label;
	}

	public HtmlCalendar getCOMP_ABV_PERIOD_FM_DT() {
		return COMP_ABV_PERIOD_FM_DT;
	}

	public void setCOMP_ABV_PERIOD_FM_DT(HtmlCalendar comp_abv_period_fm_dt) {
		COMP_ABV_PERIOD_FM_DT = comp_abv_period_fm_dt;
	}

	public HtmlOutputLabel getCOMP_ABV_PERIOD_TO_DT_LABEL() {
		return COMP_ABV_PERIOD_TO_DT_LABEL;
	}

	public void setCOMP_ABV_PERIOD_TO_DT_LABEL(
			HtmlOutputLabel comp_abv_period_to_dt_label) {
		COMP_ABV_PERIOD_TO_DT_LABEL = comp_abv_period_to_dt_label;
	}

	public HtmlCalendar getCOMP_ABV_PERIOD_TO_DT() {
		return COMP_ABV_PERIOD_TO_DT;
	}

	public void setCOMP_ABV_PERIOD_TO_DT(HtmlCalendar comp_abv_period_to_dt) {
		COMP_ABV_PERIOD_TO_DT = comp_abv_period_to_dt;
	}

	public HtmlOutputLabel getCOMP_ABV_PAID_DT_LABEL() {
		return COMP_ABV_PAID_DT_LABEL;
	}

	public void setCOMP_ABV_PAID_DT_LABEL(HtmlOutputLabel comp_abv_paid_dt_label) {
		COMP_ABV_PAID_DT_LABEL = comp_abv_paid_dt_label;
	}

	public HtmlCalendar getCOMP_ABV_PAID_DT() {
		return COMP_ABV_PAID_DT;
	}

	public void setCOMP_ABV_PAID_DT(HtmlCalendar comp_abv_paid_dt) {
		COMP_ABV_PAID_DT = comp_abv_paid_dt;
	}

	public HtmlOutputLabel getCOMP_ABV_FRZ_FLAG_LABEL() {
		return COMP_ABV_FRZ_FLAG_LABEL;
	}

	public void setCOMP_ABV_FRZ_FLAG_LABEL(
			HtmlOutputLabel comp_abv_frz_flag_label) {
		COMP_ABV_FRZ_FLAG_LABEL = comp_abv_frz_flag_label;
	}

	public HtmlSelectOneMenu getCOMP_ABV_FRZ_FLAG() {
		return COMP_ABV_FRZ_FLAG;
	}

	public void setCOMP_ABV_FRZ_FLAG(HtmlSelectOneMenu comp_abv_frz_flag) {
		COMP_ABV_FRZ_FLAG = comp_abv_frz_flag;
	}

	public PT_AGENT_BONUS_VALUES_2 getPT_AGENT_BONUS_VALUES_2_BEAN() {
		return PT_AGENT_BONUS_VALUES_2_BEAN;
	}

	public void setPT_AGENT_BONUS_VALUES_2_BEAN(
			PT_AGENT_BONUS_VALUES_2 pt_agent_bonus_values_2_bean) {
		PT_AGENT_BONUS_VALUES_2_BEAN = pt_agent_bonus_values_2_bean;
	}
	
	public List<SelectItem> getBonusList() {
		if (bonusList.size() == 0) {
			bonusList.clear();
			try {
				bonusList = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bonusList;
	}

	public void setBonusList(List<SelectItem> bonusList) {
		this.bonusList = bonusList;
	}
	
	public List<SelectItem> getFlagList() {
		if (flagList.size() == 0) {
			flagList.clear();
			try {
				flagList = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flagList;
	}

	public void setFlagList(List<SelectItem> flagList) {
		this.flagList = flagList;
	}

	/**
	 * @return the cOMP_ABV_PAID_FLAG_LABEL
	 */
	public HtmlOutputLabel getCOMP_ABV_PAID_FLAG_LABEL() {
		return COMP_ABV_PAID_FLAG_LABEL;
	}

	/**
	 * @param comp_abv_paid_flag_label the cOMP_ABV_PAID_FLAG_LABEL to set
	 */
	public void setCOMP_ABV_PAID_FLAG_LABEL(HtmlOutputLabel comp_abv_paid_flag_label) {
		COMP_ABV_PAID_FLAG_LABEL = comp_abv_paid_flag_label;
	}

	/**
	 * @return the cOMP_ABV_PAID_FLAG
	 */
	public HtmlSelectOneMenu getCOMP_ABV_PAID_FLAG() {
		return COMP_ABV_PAID_FLAG;
	}

	/**
	 * @param comp_abv_paid_flag the cOMP_ABV_PAID_FLAG to set
	 */
	public void setCOMP_ABV_PAID_FLAG(HtmlSelectOneMenu comp_abv_paid_flag) {
		COMP_ABV_PAID_FLAG = comp_abv_paid_flag;
	}

	/**
	 * @return the paidList
	 */
	public List<SelectItem> getPaidList() {
		if (paidList.size() == 0) {
			paidList.clear();
			try {
				paidList = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return paidList;
	}

	/**
	 * @param paidList the paidList to set
	 */
	public void setPaidList(List<SelectItem> paidList) {
		this.paidList = paidList;
	}
	
	/*Added by Ameen on 13-06-2018 for KIC as per Ajay Sugg.*/
	
	private UIData dataTablePolicy;
	
	private List<PT_AGENT_BONUS_POL_DTL> policyList = new ArrayList<PT_AGENT_BONUS_POL_DTL>();	
	
	public UIData getDataTablePolicy() {
		return dataTablePolicy;
	}

	public void setDataTablePolicy(UIData dataTablePolicy) {
		this.dataTablePolicy = dataTablePolicy;
	}

	public List<PT_AGENT_BONUS_POL_DTL> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<PT_AGENT_BONUS_POL_DTL> policyList) {
		this.policyList = policyList;
	}

	public void fetchPolicyDtls(String agentCode){
		
		/*Commented and modified by Janani on 18.06.2018 for KIC */
		
		/*String polQry="SELECT ABPD_POL_NO, DECODE(ABPD_PREM_TYPE, 'N', 'New Business', 'I', 'Installment') ABPD_PREM_TYPE, "
				+ "ABPD_PROD_CODE, ABPD_SHARE_PERC, ABPD_LC_INV_PREM FROM PT_AGENT_BONUS_POL_DTL WHERE"
				+ " ABPD_AGENT_CODE = ?";*/
		
		String polQry="SELECT DISTINCT ABPD_POL_NO, DECODE(ABPD_PREM_TYPE, 'N', 'New Business', 'I', 'Installment') ABPD_PREM_TYPE, "
				+ "ABPD_PROD_CODE, ABPD_SHARE_PERC, ABPD_LC_INV_PREM FROM PT_AGENT_BONUS_POL_DTL WHERE"
				+ " ABPD_AGENT_CODE = ?";
		
		/*End*/
		
		
		ResultSet rs = null;
		try {
			rs = new CRUDHandler().executeSelectStatement(polQry, CommonUtils.getConnection(),new Object[]{agentCode});
			PT_AGENT_BONUS_POL_DTL PT_AGENT_BONUS_POL_DTL_BEAN = null;
			if(!policyList.isEmpty()){
				policyList.clear();
			}
			while(rs.next()){
				PT_AGENT_BONUS_POL_DTL_BEAN = new PT_AGENT_BONUS_POL_DTL();
				
				PT_AGENT_BONUS_POL_DTL_BEAN.setABPD_POL_NO(rs.getString("ABPD_POL_NO"));
				PT_AGENT_BONUS_POL_DTL_BEAN.setABPD_PREM_TYPE(rs.getString("ABPD_PREM_TYPE"));
				PT_AGENT_BONUS_POL_DTL_BEAN.setABPD_PROD_CODE(rs.getString("ABPD_PROD_CODE"));
				PT_AGENT_BONUS_POL_DTL_BEAN.setABPD_SHARE_PERC(rs.getString("ABPD_SHARE_PERC"));
				PT_AGENT_BONUS_POL_DTL_BEAN.setABPD_LC_INV_PREM(rs.getString("ABPD_LC_INV_PREM"));
				
				policyList.add(PT_AGENT_BONUS_POL_DTL_BEAN);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*End*/

}

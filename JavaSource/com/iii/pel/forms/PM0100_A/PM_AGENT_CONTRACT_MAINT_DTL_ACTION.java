package com.iii.pel.forms.PM0100_A;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_CONTRACT_MAINT_DTL_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_ACMD_RANK_CODE_LABEL;

	private HtmlInputText COMP_ACMD_RANK_CODE;

	private HtmlOutputLabel COMP_ACMD_PROD_TYPE_LABEL;

	private  HtmlSelectOneMenu COMP_ACMD_PROD_TYPE;

	private HtmlOutputLabel COMP_ACMD_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMD_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMD_LC_NBPICK_FYC_LABEL;

	private HtmlInputText COMP_ACMD_LC_NBPICK_FYC;

	private HtmlOutputLabel COMP_ACMD_LC_PICKUP_FYC_LABEL;

	private HtmlInputText COMP_ACMD_LC_PICKUP_FYC;

	private HtmlOutputLabel COMP_ACMD_LC_NBSUB_FYC_LABEL;

	private HtmlInputText COMP_ACMD_LC_NBSUB_FYC;

	private HtmlOutputLabel COMP_ACMD_LC_TOT_FYC_LABEL;

	private HtmlInputText COMP_ACMD_LC_TOT_FYC;

	private HtmlOutputLabel COMP_ACMD_MANPOWER_LABEL;

	private HtmlInputText COMP_ACMD_MANPOWER;

	private HtmlOutputLabel COMP_ACMD_PRODN_YEAR_LABEL;

	private HtmlInputText COMP_ACMD_PRODN_YEAR;

	private HtmlOutputLabel COMP_ACMD_FM_DT_LABEL;

	private HtmlCalendar COMP_ACMD_FM_DT;

	private HtmlOutputLabel COMP_ACMD_TO_DT_LABEL;

	private HtmlCalendar COMP_ACMD_TO_DT;

	private HtmlOutputLabel COMP_ACMD_ACT_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMD_ACT_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMD_ACT_LC_FYC_LABEL;

	private HtmlInputText COMP_ACMD_ACT_LC_FYC;

	private HtmlInputText COMP_UI_M_ACMD_RANK_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_RANK_CODE_LOV;

	private PM_AGENT_CONTRACT_MAINT_DTL PM_AGENT_CONTRACT_MAINT_DTL_BEAN;

	private HtmlCommandButton PREFORMBUTTON;	

	private List list;

	private HtmlSuggestionBox suggestionBox;

	private boolean update=false;

	private List ACMD_PROD_TYPE_List=new ArrayList();



	private Connection con;
	private static String CLIENTID=null;

	public HtmlSuggestionBox getSuggestionBox() {
		return suggestionBox;
	}

	public void setSuggestionBox(HtmlSuggestionBox suggestionBox) {
		this.suggestionBox = suggestionBox;
	}

	public PM_AGENT_CONTRACT_MAINT_DTL_ACTION() {
		PM_AGENT_CONTRACT_MAINT_DTL_BEAN = new PM_AGENT_CONTRACT_MAINT_DTL();
		CLIENTID="LIFEALL"+System.currentTimeMillis();
	}

	public HtmlOutputLabel getCOMP_ACMD_RANK_CODE_LABEL() {
		return COMP_ACMD_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_RANK_CODE() {
		return COMP_ACMD_RANK_CODE;
	}

	public void setCOMP_ACMD_RANK_CODE_LABEL(HtmlOutputLabel COMP_ACMD_RANK_CODE_LABEL) {
		this.COMP_ACMD_RANK_CODE_LABEL = COMP_ACMD_RANK_CODE_LABEL;
	}

	public void setCOMP_ACMD_RANK_CODE(HtmlInputText COMP_ACMD_RANK_CODE) {
		this.COMP_ACMD_RANK_CODE = COMP_ACMD_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_ACMD_PROD_TYPE_LABEL() {
		return COMP_ACMD_PROD_TYPE_LABEL;
	}



	public void setCOMP_ACMD_PROD_TYPE_LABEL(HtmlOutputLabel COMP_ACMD_PROD_TYPE_LABEL) {
		this.COMP_ACMD_PROD_TYPE_LABEL = COMP_ACMD_PROD_TYPE_LABEL;
	}



	public HtmlOutputLabel getCOMP_ACMD_NO_OF_POL_LABEL() {
		return COMP_ACMD_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_NO_OF_POL() {
		return COMP_ACMD_NO_OF_POL;
	}

	public void setCOMP_ACMD_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMD_NO_OF_POL_LABEL) {
		this.COMP_ACMD_NO_OF_POL_LABEL = COMP_ACMD_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMD_NO_OF_POL(HtmlInputText COMP_ACMD_NO_OF_POL) {
		this.COMP_ACMD_NO_OF_POL = COMP_ACMD_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMD_LC_NBPICK_FYC_LABEL() {
		return COMP_ACMD_LC_NBPICK_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_LC_NBPICK_FYC() {
		return COMP_ACMD_LC_NBPICK_FYC;
	}

	public void setCOMP_ACMD_LC_NBPICK_FYC_LABEL(HtmlOutputLabel COMP_ACMD_LC_NBPICK_FYC_LABEL) {
		this.COMP_ACMD_LC_NBPICK_FYC_LABEL = COMP_ACMD_LC_NBPICK_FYC_LABEL;
	}

	public void setCOMP_ACMD_LC_NBPICK_FYC(HtmlInputText COMP_ACMD_LC_NBPICK_FYC) {
		this.COMP_ACMD_LC_NBPICK_FYC = COMP_ACMD_LC_NBPICK_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMD_LC_PICKUP_FYC_LABEL() {
		return COMP_ACMD_LC_PICKUP_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_LC_PICKUP_FYC() {
		return COMP_ACMD_LC_PICKUP_FYC;
	}

	public void setCOMP_ACMD_LC_PICKUP_FYC_LABEL(HtmlOutputLabel COMP_ACMD_LC_PICKUP_FYC_LABEL) {
		this.COMP_ACMD_LC_PICKUP_FYC_LABEL = COMP_ACMD_LC_PICKUP_FYC_LABEL;
	}

	public void setCOMP_ACMD_LC_PICKUP_FYC(HtmlInputText COMP_ACMD_LC_PICKUP_FYC) {
		this.COMP_ACMD_LC_PICKUP_FYC = COMP_ACMD_LC_PICKUP_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMD_LC_NBSUB_FYC_LABEL() {
		return COMP_ACMD_LC_NBSUB_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_LC_NBSUB_FYC() {
		return COMP_ACMD_LC_NBSUB_FYC;
	}

	public void setCOMP_ACMD_LC_NBSUB_FYC_LABEL(HtmlOutputLabel COMP_ACMD_LC_NBSUB_FYC_LABEL) {
		this.COMP_ACMD_LC_NBSUB_FYC_LABEL = COMP_ACMD_LC_NBSUB_FYC_LABEL;
	}

	public void setCOMP_ACMD_LC_NBSUB_FYC(HtmlInputText COMP_ACMD_LC_NBSUB_FYC) {
		this.COMP_ACMD_LC_NBSUB_FYC = COMP_ACMD_LC_NBSUB_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMD_LC_TOT_FYC_LABEL() {
		return COMP_ACMD_LC_TOT_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_LC_TOT_FYC() {
		return COMP_ACMD_LC_TOT_FYC;
	}

	public void setCOMP_ACMD_LC_TOT_FYC_LABEL(HtmlOutputLabel COMP_ACMD_LC_TOT_FYC_LABEL) {
		this.COMP_ACMD_LC_TOT_FYC_LABEL = COMP_ACMD_LC_TOT_FYC_LABEL;
	}

	public void setCOMP_ACMD_LC_TOT_FYC(HtmlInputText COMP_ACMD_LC_TOT_FYC) {
		this.COMP_ACMD_LC_TOT_FYC = COMP_ACMD_LC_TOT_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMD_MANPOWER_LABEL() {
		return COMP_ACMD_MANPOWER_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_MANPOWER() {
		return COMP_ACMD_MANPOWER;
	}

	public void setCOMP_ACMD_MANPOWER_LABEL(HtmlOutputLabel COMP_ACMD_MANPOWER_LABEL) {
		this.COMP_ACMD_MANPOWER_LABEL = COMP_ACMD_MANPOWER_LABEL;
	}

	public void setCOMP_ACMD_MANPOWER(HtmlInputText COMP_ACMD_MANPOWER) {
		this.COMP_ACMD_MANPOWER = COMP_ACMD_MANPOWER;
	}

	public HtmlOutputLabel getCOMP_ACMD_PRODN_YEAR_LABEL() {
		return COMP_ACMD_PRODN_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_PRODN_YEAR() {
		return COMP_ACMD_PRODN_YEAR;
	}

	public void setCOMP_ACMD_PRODN_YEAR_LABEL(HtmlOutputLabel COMP_ACMD_PRODN_YEAR_LABEL) {
		this.COMP_ACMD_PRODN_YEAR_LABEL = COMP_ACMD_PRODN_YEAR_LABEL;
	}

	public void setCOMP_ACMD_PRODN_YEAR(HtmlInputText COMP_ACMD_PRODN_YEAR) {
		this.COMP_ACMD_PRODN_YEAR = COMP_ACMD_PRODN_YEAR;
	}

	public HtmlOutputLabel getCOMP_ACMD_FM_DT_LABEL() {
		return COMP_ACMD_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ACMD_FM_DT() {
		return COMP_ACMD_FM_DT;
	}

	public void setCOMP_ACMD_FM_DT_LABEL(HtmlOutputLabel COMP_ACMD_FM_DT_LABEL) {
		this.COMP_ACMD_FM_DT_LABEL = COMP_ACMD_FM_DT_LABEL;
	}

	public void setCOMP_ACMD_FM_DT(HtmlCalendar COMP_ACMD_FM_DT) {
		this.COMP_ACMD_FM_DT = COMP_ACMD_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ACMD_TO_DT_LABEL() {
		return COMP_ACMD_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ACMD_TO_DT() {
		return COMP_ACMD_TO_DT;
	}

	public void setCOMP_ACMD_TO_DT_LABEL(HtmlOutputLabel COMP_ACMD_TO_DT_LABEL) {
		this.COMP_ACMD_TO_DT_LABEL = COMP_ACMD_TO_DT_LABEL;
	}

	public void setCOMP_ACMD_TO_DT(HtmlCalendar COMP_ACMD_TO_DT) {
		this.COMP_ACMD_TO_DT = COMP_ACMD_TO_DT;
	}

	public HtmlOutputLabel getCOMP_ACMD_ACT_NO_OF_POL_LABEL() {
		return COMP_ACMD_ACT_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_ACT_NO_OF_POL() {
		return COMP_ACMD_ACT_NO_OF_POL;
	}

	public void setCOMP_ACMD_ACT_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMD_ACT_NO_OF_POL_LABEL) {
		this.COMP_ACMD_ACT_NO_OF_POL_LABEL = COMP_ACMD_ACT_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMD_ACT_NO_OF_POL(HtmlInputText COMP_ACMD_ACT_NO_OF_POL) {
		this.COMP_ACMD_ACT_NO_OF_POL = COMP_ACMD_ACT_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMD_ACT_LC_FYC_LABEL() {
		return COMP_ACMD_ACT_LC_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMD_ACT_LC_FYC() {
		return COMP_ACMD_ACT_LC_FYC;
	}

	public void setCOMP_ACMD_ACT_LC_FYC_LABEL(HtmlOutputLabel COMP_ACMD_ACT_LC_FYC_LABEL) {
		this.COMP_ACMD_ACT_LC_FYC_LABEL = COMP_ACMD_ACT_LC_FYC_LABEL;
	}

	public void setCOMP_ACMD_ACT_LC_FYC(HtmlInputText COMP_ACMD_ACT_LC_FYC) {
		this.COMP_ACMD_ACT_LC_FYC = COMP_ACMD_ACT_LC_FYC;
	}

	public HtmlInputText getCOMP_UI_M_ACMD_RANK_CODE_DESC() {
		return COMP_UI_M_ACMD_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_ACMD_RANK_CODE_DESC(HtmlInputText COMP_UI_M_ACMD_RANK_CODE_DESC) {
		this.COMP_UI_M_ACMD_RANK_CODE_DESC = COMP_UI_M_ACMD_RANK_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RANK_CODE_LOV() {
		return COMP_UI_M_BUT_RANK_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_RANK_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_RANK_CODE_LOV) {
		this.COMP_UI_M_BUT_RANK_CODE_LOV = COMP_UI_M_BUT_RANK_CODE_LOV;
	}

	public PM_AGENT_CONTRACT_MAINT_DTL getPM_AGENT_CONTRACT_MAINT_DTL_BEAN() {
		return PM_AGENT_CONTRACT_MAINT_DTL_BEAN;
	}

	public void setPM_AGENT_CONTRACT_MAINT_DTL_BEAN(PM_AGENT_CONTRACT_MAINT_DTL PM_AGENT_CONTRACT_MAINT_DTL_BEAN) {
		this.PM_AGENT_CONTRACT_MAINT_DTL_BEAN = PM_AGENT_CONTRACT_MAINT_DTL_BEAN;
	}

	public String preInsert() throws Exception{
		String check="";
		CRUDHandler handler = new CRUDHandler();		
		Date fromDate = (Date) getCOMP_ACMD_FM_DT().getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String fmDate = sdf.format(fromDate);		
		Date endDate = (Date) getCOMP_ACMD_TO_DT().getValue();
		String toDate = sdf.format(endDate);	

		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preInsert() *********"+fromDate);
		String sqlQuery = "SELECT ROWID FROM PM_AGENT_CONTRACT_MAINT_DTL WHERE ACMD_RANK_CODE='"+PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_RANK_CODE()+"'AND   (((ACMD_FM_DT BETWEEN '"+fmDate+"' AND '"+toDate+"' ) OR (ACMD_TO_DT BETWEEN '"+fmDate+"' AND '"+toDate+"' )) OR  (('"+fmDate+"' BETWEEN ACMD_FM_DT AND ACMD_TO_DT ) OR ('"+toDate+"'   BETWEEN ACMD_FM_DT AND ACMD_TO_DT ) ) ) ";
		System.out.println("\n\n  The SQL query is:   "+sqlQuery);

		ResultSet result;
		try {
			result = handler.executeSelectStatement(sqlQuery,getConnection());
			if(result.next()){
				System.out.println("\n\n ERROR:  Combination Already Exists.  Please reenter");
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "60018"));
				//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "60018"));
				//check="false";
			}
			result.close();
			String userID = (String)getSession().get("GLOBAL.M_USER_ID");
			System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preInsert(uID) "+userID);
			PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_CR_UID(userID);
			String qry = "SELECT SYSDATE FROM DUAL";
//			CRUDHandler handler = new CRUDHandler();
			ResultSet rs = null;

			rs = handler.executeSelectStatement(qry, getConnection());
			if(rs.next()){
				PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_CR_DT(rs.getDate(1));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}return check;
	}

	/*public String save() {
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preInsert() >>>>>>>> ");
		if(isUpdate()){
			System.out
			.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preInsert()");
			try {
				preUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			Connection con = null;
			try {
				con = getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println("\n\n The Connection object got when creating a record is"+con);	
			CRUDHandler handler = new CRUDHandler();
			String test=preInsert();				
			if(!test.equals("false")){
				int i;
				try {
					i = handler.executeInsert(PM_AGENT_CONTRACT_MAINT_DTL_BEAN, con);
					if (i!=0){
						getWarningMap().put("current", i +" Record inserted");
					}
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		

		getCOMP_ACMD_ACT_NO_OF_POL().setReadonly(true);
		getCOMP_ACMD_LC_NBPICK_FYC().setReadonly(true);
		getCOMP_ACMD_LC_NBSUB_FYC().setReadonly(true);
		getCOMP_ACMD_LC_TOT_FYC().setReadonly(true);
		getCOMP_ACMD_MANPOWER().setReadonly(true);
		getCOMP_ACMD_PRODN_YEAR().setReadonly(true);
		getCOMP_ACMD_NO_OF_POL().setReadonly(true);
		getCOMP_ACMD_ACT_LC_FYC().setReadonly(true);
		getCOMP_ACMD_LC_PICKUP_FYC().setReadonly(true);

		return null;
	}*/
	
	public String save() {
		try {
		    if (getPM_AGENT_CONTRACT_MAINT_DTL_BEAN().getROWID() != null) {
			preUpdate();
			new CRUDHandler().executeInsert(getPM_AGENT_CONTRACT_MAINT_DTL_BEAN(),
				CommonUtils.getConnection());
		    } else {
			preInsert();
			new CRUDHandler().executeInsert(getPM_AGENT_CONTRACT_MAINT_DTL_BEAN(),
				CommonUtils.getConnection());
		    }
		    CommonUtils.getConnection().commit();
		    getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
		    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    e.getMessage());
		    getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	 }
		
	public String deleteAction() {
		try {
			if (getPM_AGENT_CONTRACT_MAINT_DTL_BEAN().getROWID() != null) {
				if (isDELETE_ALLOWED()) {
					new CRUDHandler().executeDelete(
							PM_AGENT_CONTRACT_MAINT_DTL_BEAN, CommonUtils
									.getConnection());
					getWarningMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					resetAllComponents();
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
				PM_AGENT_CONTRACT_MAINT_DTL_BEAN = new PM_AGENT_CONTRACT_MAINT_DTL();
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
		return null;
	}
	
	public void resetAllComponents(){
		getCOMP_ACMD_ACT_LC_FYC().resetValue();
		getCOMP_ACMD_ACT_NO_OF_POL().resetValue();
		getCOMP_ACMD_FM_DT().resetValue();
		getCOMP_ACMD_LC_NBPICK_FYC().resetValue();
		getCOMP_ACMD_LC_NBSUB_FYC().resetValue();
		getCOMP_ACMD_LC_PICKUP_FYC().resetValue();
		getCOMP_ACMD_LC_TOT_FYC().resetValue();
		getCOMP_ACMD_MANPOWER().resetValue();
		getCOMP_ACMD_NO_OF_POL().resetValue();
		getCOMP_ACMD_PROD_TYPE().resetValue();
		getCOMP_ACMD_PRODN_YEAR().resetValue();
		getCOMP_ACMD_RANK_CODE().resetValue();
		getCOMP_UI_M_ACMD_RANK_CODE_DESC().resetValue();
		getCOMP_ACMD_TO_DT().resetValue();
	}
	/*public String deleteAction() throws Exception{
		Connection con = getConnection();
		System.out.println("\n\n The Connection object got when creating a record is"+con);	
		CRUDHandler handler = new CRUDHandler();		
		java.sql.Statement stmt = con.createStatement();		
		Date fromDate = (Date) getCOMP_ACMD_FM_DT().getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String fmDate = sdf.format(fromDate);		
		Date endDate = (Date) getCOMP_ACMD_TO_DT().getValue();
		String toDate = sdf.format(endDate);	
		int i = handler.executeDelete(PM_AGENT_CONTRACT_MAINT_DTL_BEAN, con);
		con.commit();
		System.out.println("\n\n The number of rows affected is:  "+i);
		return null;
	}*/


	public void preUpdate() throws Exception{
		Connection con = CommonUtils.getConnection();
		//PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_CR_UID("PREMIA11");
		//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_UPD_DT(new CommonUtils().getCurrentDate());

		/*System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preUpdate() ^^^^^^^^^"+PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_ACT_LC_FYC() +" "+PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_FM_DT() +" "+PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getROWID() );
		//PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_PROD_TYPE((String) getCOMP_ACMD_PROD_TYPE().getValue());
		String rankCode = getPM_AGENT_CONTRACT_MAINT_DTL_BEAN().getACMD_RANK_CODE();
		System.out.println("Rank Code >>>>>>>>>>>>= "+rankCode);
		CRUDHandler handler = new CRUDHandler();
		int i=handler.executeUpdate(getPM_AGENT_CONTRACT_MAINT_DTL_BEAN(), con);
		if (i!=0){
			getWarningMap().put("current", i +" Record updated");
		}
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preUpdate()^^^^^^^^^ "+i);

		con.commit();
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.preUpdate() CONNECTION COMITTED");
*/		/*getCOMP_ACMD_ACT_NO_OF_POL().setReadonly(true);
		getCOMP_ACMD_LC_NBPICK_FYC().setReadonly(true);
		getCOMP_ACMD_LC_NBSUB_FYC().setReadonly(true);
		getCOMP_ACMD_LC_TOT_FYC().setReadonly(true);
		getCOMP_ACMD_MANPOWER().setReadonly(true);
		getCOMP_ACMD_PRODN_YEAR().setReadonly(true);
		getCOMP_ACMD_NO_OF_POL().setReadonly(true);
		getCOMP_ACMD_ACT_LC_FYC().setReadonly(true);
		getCOMP_ACMD_LC_PICKUP_FYC().setReadonly(true);*/

	}


	public String readRecord() throws Exception{
		System.out.println("\n\n readRecord() method is called");
		CRUDHandler handler = new CRUDHandler();
		List list = handler.fetch("select * from PM_AGENT_CONTRACT_MAINT_DTL", "com.iii.pel.forms.PM0100_A.PM_AGENT_CONTRACT_MAINT_DTL", getConnection());
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			PM_AGENT_CONTRACT_MAINT_DTL object = (PM_AGENT_CONTRACT_MAINT_DTL) iterator.next();
			System.out
			.println("The retrieved values are  :"+object.getACMD_CR_DT()+"  "+object.getACMD_CR_UID());			
		}
		return null;
	}

	public void preForm(PhaseEvent ae){
		//getWarningMap().clear();
		if(isUpdate()){
			//bala for PREMIA-GDC-1139224 
			/*getCOMP_ACMD_ACT_NO_OF_POL().setReadonly(true);
			getCOMP_ACMD_LC_NBPICK_FYC().setReadonly(true);
			getCOMP_ACMD_LC_NBSUB_FYC().setReadonly(true);
			getCOMP_ACMD_LC_TOT_FYC().setReadonly(true);
			getCOMP_ACMD_MANPOWER().setReadonly(true);
			getCOMP_ACMD_PRODN_YEAR().setReadonly(true);
			getCOMP_ACMD_NO_OF_POL().setReadonly(true);
			getCOMP_ACMD_ACT_LC_FYC().setReadonly(true);
			getCOMP_ACMD_LC_PICKUP_FYC().setReadonly(true);*/

			/*String prodType = "";
			if("P".equalsIgnoreCase(PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_PROD_TYPE())){
				prodType = "Personal";
			}if("DG".equalsIgnoreCase(PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_PROD_TYPE())){
				prodType = "Direct Group";
			}if("G".equalsIgnoreCase(PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_PROD_TYPE())){
				prodType = "Group";
			}

			System.out.println("\n\n The combobox value set is:*********  "+prodType);
			getCOMP_ACMD_PROD_TYPE().setValue(prodType);
			getCOMP_ACMD_PROD_TYPE().setSubmittedValue(null);*/
		}
		if(isBlockFlag()){
			System.out.println("\n\n ++++++++++++++++++++  PRE-FORM is called");
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("GLOBAL.M_FAILURE", "FALSE");

			STD_PRE_FORM();

			//executeP_VAL_FINAL_PARAMETER();

			// CALL STD_PRE_FORM (PROCEDURE);

			whenCreateRecord();
			setBlockFlag(false);

		}



		//getPREFORMBUTTON().setDisabled(true);
		//return null;
	}

	private void whenCreateRecord(){
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.whenCreateRecord()");
		getCOMP_ACMD_PROD_TYPE().setValue("P");
		//getCOMP_ACMD_PROD_TYPE().updateModel(FacesContext.getCurrentInstance());		
		//getCOMP_ACMD_PROD_TYPE().setSubmittedValue(null);
	}

	/*private void executeP_VAL_FINAL_PARAMETER(){
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.prepareOracleParam()\n------------! \n");
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", "BASE.CURR");
		OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT", "fgdsfINR");
		OracleParameter param3 = new OracleParameter("in2","STRING","IN", "E");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			ArrayList list = procHandler.execute(paramList, getConnection(), "P_VAL_FINAL_PARAMETER");
			System.out
			.println("The Procedure output is **************:"+list.get(0));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}*/

	public static Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}
	public void validateACMDRANKCODE(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();

		ErrorHelpUtil.validate(input, getErrorMap()); 	
	}
	public void ACMDRANKCODEVALIDATOR(FacesContext context, UIComponent component,Object value1) throws Exception{
		//implemented on by bala 06-Nov-2008
		String M_DUMMY_X="";
		ArrayList<String> list; 
		PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_RANK_CODE((String) value1);
		String CURSORC1="SELECT 'X' FROM PM_CODES WHERE PC_TYPE ='AGNRANK' AND PC_CODE = ?";
		if(! "".equals((String)getCOMP_ACMD_RANK_CODE().getSubmittedValue())){
			String rankcode = PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_RANK_CODE();
			PreparedStatement ps=getConnection().prepareStatement(CURSORC1);
			ps.setString(1, rankcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				M_DUMMY_X=rs.getString(1);
			}
			if("".equals(M_DUMMY_X)){
				getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91344", new Object[]{"Rank Code"}).getSummary());
				//getErrorMap().put("current", "Invalide Rank Code");
				return;  
			}
			
			list = new DBProcedures().P_VAL_CODES("AGNRANK", rankcode, null, "N", "E");
			if( list.size() > 0 && list.get(0) != null){
			PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setUI_M_ACMD_RANK_CODE_DESC(list.get(0));
			}
		}
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMDRANKCODEVALIDATOR() ******");	 



	}


	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	private void STD_PRE_FORM(){

		FacesContext ctx = FacesContext.getCurrentInstance();
		ControlBean controlBean = CommonUtils.getControlBean();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
		controlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		controlBean.setM_PROG_NAME("PM0100_A");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.STD_PRE_FORM()--- \n "+controlBean.getM_LANG_CODE()+"\t"+controlBean.getM_COMP_CODE()+"\t"+controlBean.getM_PARA_1());
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
		/* M_MODULE_NAME := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
   COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
   M_TITLE:= NAME_IN('CTRL.M_USER_ID') ||'                 '||NAME_IN('CTRL.M_SCR_NAME')||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
   HIDE_VIEW('ABOUT');
   M_FIRST_BLOCK := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
                         CURRENT_FORM_NAME), FIRSTBLOCK) ;

   LOOP
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
         EXIT ;
      END IF ;
   END LOOP ;

   RG_ID	:= FIND_GROUP('RG_HINT') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   LOAD_BP;
   ENABLE_BUTTONS ;
   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
      LOAD_BALOON_LABEL;
   END IF;
END;*/
		session.put("controlBean", controlBean);
	}

	public List autoComplete(Object event){
		//COMP_ACMD_RANK_CODE.setSubmittedValue(null);
		java.sql.Statement stmt=null;
		list=new ArrayList();
		ResultSet rs=null;
		String letter=event.toString();
		try {
			if(letter.equalsIgnoreCase("*")){
				System.out
				.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.autoComplete()");
//				String query="select name1,desc1 from cust_catg where name1 like '"+letter+"%'";
				String query="SELECT PC_CODE, DECODE('N','N',PC_DESC ,'L',NVL(PC_LONG_DESC,PC_DESC),PC_DESC), DECODE('N','N',PC_BL_DESC ,'L',NVL(PC_BL_LONG_DESC,PC_DESC),PC_BL_DESC),PC_FRZ_FLAG FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
				System.out
				.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.autoComplete()---QUERY----["+query+"]");
				stmt=getConnection().createStatement();
				rs=stmt.executeQuery(query);
				/*else{
//				String query="select name1,desc1 from cust_catg where name1 like '"+letter+"%'";
				String query="select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where MAIN_ACNT_CODE like '"+letter+"%'";
				stmt=getConnection().createStatement();
				rs=stmt.executeQuery(query);
			}*/
				while(rs.next()){
					LOVBean1 bean=new LOVBean1(rs.getString(1),rs.getString(2));
					list.add(bean);
				}}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void populateDesc(ActionEvent ae){

		FacesContext ctx=FacesContext.getCurrentInstance();
		UIViewRoot root=ctx.getViewRoot();
		HtmlInputText text=(HtmlInputText) root.findComponent("PM_AGENT_CONTRACT_MAINT_DTL:UI_M_ACMD_RANK_CODE_DESC");
		String s=(String) getCOMP_ACMD_RANK_CODE().getSubmittedValue();
		if(!s.equalsIgnoreCase("")){
			Iterator iter=list.iterator();
			while (iter.hasNext()) {
				LOVBean1 obj = (LOVBean1) iter.next();
				if (s.equals(obj.getName())) {
					text.setSubmittedValue(obj.getDesc());
				}
			}
		}else{
			text.setSubmittedValue("");
		}
		/*****************************************************************************************/
		/*FacesContext ctx=FacesContext.getCurrentInstance();
		UIViewRoot root=ctx.getViewRoot();
		HtmlInputText text=(HtmlInputText) root.findComponent("test:suggestDesc");

//		System.out.println("LOVExample1.populateDesc()");
		String s=(String) getInputBox().getSubmittedValue();
		try {

			String query="select desc1 from cust_catg where name1 = '"+s+"'";
			Statement stmt=getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(query);

			while(rs.next()){
				text.setSubmittedValue(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*****************************************************************************************/
	}

	public void valueChanged(ActionEvent e){
		//System.out.println("\n\n PM_AGENT_CONTRACT_MAINT_DTL_ACTION.valueChanged()"+e.getComponent().getParent().getAttributes().get("value"));
	} 

	public void validateNO_OF_POL(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void ACMD_ACT_NO_OF_POLVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_ACT_NO_OF_POL().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_ACT_NO_OF_POLVALIDATOR()"+value);
		try{
			i = Double.valueOf(value);
		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Enter value for Account Number of Policies in the range from 0 to 99999"));
		}
		if(i<0 || i>99999){
			throw new ValidatorException(new FacesMessage("Enter value for Account Number of Policies in the range from 0 to 99999"));

		}
	}

	public void validateACMD_NO_OF_POL(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_NO_OF_POL().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateACMD_NO_OF_POL() value "+value);
		try{
			i = Double.valueOf(value);
		}catch(NumberFormatException e1){
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91345", new Object[]{"Number of Policies"}).getSummary());
			//throw new ValidatorException(new FacesMessage("The value must be in the range 0 to 100000")); 

		}
		if(i<0 || i>99999){
			//throw new ValidatorException(new FacesMessage("The value must be in the range 0 to 100000"));
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91345", new Object[]{"Number of Policies"}).getSummary());
		}
	}


	public void validateACMD_LC_NBPICK_FYC(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ACMD_LC_NBPICK_FYCVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		double i = 0;
		String value = (String) getCOMP_ACMD_LC_NBPICK_FYC().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_LC_NBPICK_FYCVALIDATOR() >>>>> value "+value);
		try{
			i = Double.valueOf(value).doubleValue();
			String fmt = Double.toString(i);
			String pos = fmt.trim();
			String fmtValue = pos.substring(pos.indexOf("."));
			System.out
			.println("\n\n >>>>>>>>>>>>>>>>:"+fmtValue);
			if(fmtValue.length()>4){
				throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
				//getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91346", new Object[]{"NB Pickup FYC"}).getSummary());
			}
		}catch(NumberFormatException e1){
			//throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91346", new Object[]{"NB Pickup FYC"}).getSummary());
		}
		if(i<0 || i>99999999999999.999){
			//throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91346", new Object[]{"NB Pickup FYC"}).getSummary());
		}
	}


	




	public void ACMD_ACT_LC_FYCVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		double i = 0;
		String value = (String) getCOMP_ACMD_ACT_LC_FYC().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_ACT_LC_FYCVALIDATOR() "+value);
		try{
			i = Double.valueOf(value).doubleValue();
		}catch(NumberFormatException e1){
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91346", new Object[]{"NB Pickup FYC"}).getSummary());
			//throw new ValidatorException(new FacesMessage("Enter value for ACT LC Total FYC in the range from 0 to 99999999999999.999"));			
		}
		if(i<0 || i>99999999999999.999){
			getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91346", new Object[]{"NB Pickup FYC"}).getSummary());
			//throw new ValidatorException(new FacesMessage("Enter value for ACT LC Total FYC in the range from 0 to 99999999999999.999"));
		}
	}	

	public void validateACMD_LC_PICKUP_FYC(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void ACMD_LC_PICKUP_FYCVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_LC_PICKUP_FYC().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_LC_PICKUP_FYCVALIDATOR() "+value);
		try{
			i = Double.valueOf(value).doubleValue();
			String fmt = Double.toString(i);
			String pos = fmt.trim();
			String fmtValue = pos.substring(pos.indexOf("."));
			System.out
			.println("\n\n >>>>>>>>>>>>>>>>:"+fmtValue);
			if(fmtValue.length()>4){
				throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
			}
		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));			
		}
		if(i<0 || i>99999999999999.999){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
		}
	}
	public void validateACMD_LC_NBSUB_FYC(ActionEvent e){
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateACMD_LC_NBSUB_FYC()");
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ACMD_LC_NBSUB_FYCVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_LC_NBSUB_FYC().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_LC_NBSUB_FYCVALIDATOR() "+value);
		try{
			i = Double.valueOf(value);
			String fmt = Double.toString(i);
			String pos = fmt.trim();
			String fmtValue = pos.substring(pos.indexOf("."));
			System.out
			.println("\n\n >>>>>>>>>>>>>>>>:"+fmtValue);
			if(fmtValue.length()>4){
				throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
			}

		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));			
		}
		if(i<0 || i>99999999999999.999){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
		}
	}


	public void validateACMD_LC_TOT_FYC(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ACMD_LC_TOT_FYCVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_LC_TOT_FYC().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_LC_TOT_FYCVALIDATOR() "+value);
		try{
			i = Double.valueOf(value);
			String fmt = Double.toString(i);
			String pos = fmt.trim();
			String fmtValue = pos.substring(pos.indexOf("."));
			System.out
			.println("\n\n >>>>>>>>>>>>>>>>:"+fmtValue);
			if(fmtValue.length()>4){
				throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
			}
		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));			
		}
		if(i<0 || i>99999999999999.999){
			throw new ValidatorException(new FacesMessage("Field must be of form 99999999999999.999"));
		}
	}

	public void validateACMD_MANPOWER(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ACMD_MANPOWERVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_MANPOWER().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_MANPOWERVALIDATOR() "+value);
		try{
			i = Double.valueOf(value) ;
		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Field must be of form 9999"));			
		}
		if(i<0 || i>99999){
			throw new ValidatorException(new FacesMessage("Field must be of form 9999"));
		}
	}

	public void validateACMD_PRODN_YEAR(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void ACMD_PRODN_YEARVALIDATOR(FacesContext context, UIComponent component,
			Object value1) throws ValidatorException{
		Double i = 0.0;
		String value = (String) getCOMP_ACMD_PRODN_YEAR().getSubmittedValue(); 
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.ACMD_PRODN_YEARVALIDATOR() "+value);
		try{
			i = Double.valueOf(value);
		}catch(NumberFormatException e1){
			throw new ValidatorException(new FacesMessage("Production Year must be of form 9999"));			
		}
		if(i<0 || i>9999){
			System.out.println("Excpetion is thrown in check block here:::::::::::::::::::::;");
			throw new ValidatorException(new FacesMessage("Production Year must be of form 9999"));
		}
	}

	public void validateACMD_FM_DT(ActionEvent e) throws Exception{
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateACMD_FM_DT()>>>>^^^^" + "iiii "+getCOMP_ACMD_FM_DT().getSubmittedValue());

			UIInput input = (UIInput) e.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		

	}



	public void validateACMD_TO_DT(ActionEvent e) throws Exception{
		UIInput input = (UIInput) e.getComponent().getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateACMD_TO_DT()  <<<<<<< "+input);

		ErrorHelpUtil.validate(input, getErrorMap());
		//}
	}

	public void validateACMD_ACT_NO_OF_POL(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateNO_OF_POL()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateACMD_ACT_LC_FYC(ActionEvent e){
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent();
		System.out
		.println("PM_AGENT_CONTRACT_MAINT_DTL_ACTION.validateACMD_ACT_LC_FYC()");

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public List  getACMD_PROD_TYPE_List() throws Exception {
		if (ACMD_PROD_TYPE_List.size() ==0){ 
			ACMD_PROD_TYPE_List.clear();
			ACMD_PROD_TYPE_List = ListItemUtil.getDropDownListValue(getConnection(), "PM0100_A", "PM_AGENT_CONTRACT_MAINT_DTL", "PM_AGENT_CONTRACT_MAINT_DTL.ACMD_PROD_TYPE", "AGT_PROD_TYP");
		}

		return ACMD_PROD_TYPE_List;
	}

	public void setACMD_PROD_TYPE_List(List list) {
		ACMD_PROD_TYPE_List = list;
	}

	public HtmlSelectOneMenu getCOMP_ACMD_PROD_TYPE() {
		return COMP_ACMD_PROD_TYPE;
	}

	public void setCOMP_ACMD_PROD_TYPE(HtmlSelectOneMenu comp_acmd_prod_type) {
		COMP_ACMD_PROD_TYPE = comp_acmd_prod_type;
	}
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	
	
	public void ACMD_FM_DTVALIDATOR(FacesContext context, UIComponent component,Object value) throws ValidatorException{
		try {
			PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_FM_DT((Date)value);
			WHEN_VALIDATE_PROD_EFF_FM_DT((Date)value, PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_TO_DT());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void ACMD_TO_DTVALIDATOR(FacesContext context, UIComponent component,Object value) throws ValidatorException{
		try {
			PM_AGENT_CONTRACT_MAINT_DTL_BEAN.setACMD_TO_DT((Date)value);
			WHEN_VALIDATE_PROD_EFF_TO_DT((Date)value, PM_AGENT_CONTRACT_MAINT_DTL_BEAN.getACMD_FM_DT());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	
	public void WHEN_VALIDATE_PROD_EFF_FM_DT(Date PROD_EFF_FM_DT, Date PROD_EFF_TO_DT) throws Exception{
		if(PROD_EFF_FM_DT != null){
			if(PROD_EFF_TO_DT != null){
				if(PROD_EFF_FM_DT.after(PROD_EFF_TO_DT)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19004"));
				}
			}
		}
	}
	public void WHEN_VALIDATE_PROD_EFF_TO_DT(Date PROD_EFF_TO_DT, Date PROD_EFF_FM_DT) throws Exception{
		if(PROD_EFF_TO_DT != null){
			if(PROD_EFF_FM_DT != null){
			if(PROD_EFF_TO_DT.before(PROD_EFF_FM_DT)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19004"));
			}
		}
		}
	}
	
	 public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		    }
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	
}

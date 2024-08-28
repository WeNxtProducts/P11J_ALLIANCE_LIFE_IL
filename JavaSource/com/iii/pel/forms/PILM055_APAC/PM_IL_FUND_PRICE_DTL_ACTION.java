package com.iii.pel.forms.PILM055_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UICalendar;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FUND_PRICE_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FPD_FS_CODE_LABEL;

	private HtmlInputText COMP_FPD_FS_CODE;

	private HtmlOutputLabel COMP_FPD_SELL_UNIT_RATE_LABEL;

	private HtmlInputText COMP_FPD_SELL_UNIT_RATE;

	private HtmlOutputLabel COMP_FPD_BUY_UNIT_RATE_LABEL;

	private HtmlInputText COMP_FPD_BUY_UNIT_RATE;

	private HtmlOutputLabel COMP_FPD_UNIT_RATE_PER_LABEL;

	private HtmlInputText COMP_FPD_UNIT_RATE_PER;

	private HtmlOutputLabel COMP_FPD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_FPD_EFF_FM_DT;

	private HtmlOutputLabel COMP_FPD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_FPD_EFF_TO_DT;

	private PM_IL_FUND_PRICE_DTL PM_IL_FUND_PRICE_DTL_BEAN;

	private UIDataTable datatable;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String errmsg = null;

	// For Filter by

	private String filterByFPD_BUY_UNIT_RATE;

	private String filterByFPD_SELL_UNIT_RATE;
	
	private String filterByFPD_EFF_TO_DT;

	private HtmlSelectBooleanCheckbox checkBox;

	CRUDHandler handler = new CRUDHandler();

	Connection con;

	ControlBean ctrlbean = new ControlBean();

	ServletContext context;

	int rowIndex = 0;
	
	public CompositeAction PILM055_APAC_CompositeAction;

	List<PM_IL_FUND_PRICE_DTL> BeanList = new ArrayList<PM_IL_FUND_PRICE_DTL>();
	private int lastUpdateRowIndex;
	Map session = FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap();

	
	ArrayList<PM_IL_FUND_PRICE_DTL> rowCheck = new ArrayList<PM_IL_FUND_PRICE_DTL>();
/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
	public  PM_IL_FUND_PRICE_DTL_ACTION() {

		instantiateAllComponent();
		setListItemValues();
		/*End*/
		//FacesContext context = FacesContext.getCurrentInstance();
		PM_IL_FUND_PRICE_DTL_BEAN = new PM_IL_FUND_PRICE_DTL();
		/*ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_FUND_SETUP_ACTION actionBean = (PM_IL_FUND_SETUP_ACTION) resolver
				.getValue(context.getELContext(), null,
						"PILM055_APAC_PM_IL_FUND_SETUP_ACTION");
		PM_IL_FUND_SETUP valueBean = actionBean.getPM_IL_FUND_SETUP_BEAN();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(valueBean.getFS_CODE());
		String fpd_fs_code = valueBean.getFS_CODE();
		PM_IL_FUND_PRICE_DTL_BEAN.setFPD_FS_CODE(fpd_fs_code);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE());
		session.put("FPD_FS_CODE", PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE());
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		try {
			populateVal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	public void getDetails() {
		try {
			if (BeanList.size() != 0) {
				PM_IL_FUND_PRICE_DTL_BEAN = (PM_IL_FUND_PRICE_DTL) datatable
						.getRowData();
				/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
				System.out.println("PM_IL_FUND_PRICE_DTL_BEAN       "+PM_IL_FUND_PRICE_DTL_BEAN.getFPD_APPRV_FLAG());
				checkFreeze();
				/*End*/
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_FPD_SELL_UNIT_RATE.resetValue();
		COMP_FPD_UNIT_RATE_PER.resetValue();
		COMP_FPD_BUY_UNIT_RATE.resetValue();
		COMP_FPD_EFF_FM_DT.resetValue();
		COMP_FPD_EFF_TO_DT.resetValue();
		COMP_FPD_APPRV_FLAG.resetValue();
		COMP_FPD_APPRV_DT.resetValue();
		/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
		 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
		 *
		 */
		COMP_FPD_UNIT_PRICE_RATE.resetValue();
		/*End*/
	}
	
	
	

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_FUND_PRICE_DTL> iterator = BeanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void populateVal() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException, DBException {

		FacesContext context = FacesContext.getCurrentInstance();
		String FS_CODE = PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE();

		con = CommonUtils.getConnection();
		// con.commit();
		String selectQuery = "SELECT PM_IL_FUND_PRICE_DTL.ROWID,PM_IL_FUND_PRICE_DTL.* FROM  PM_IL_FUND_PRICE_DTL  where FPD_FS_CODE ='"
				+ FS_CODE + "'";
		System.out.println("selectQuery========" + selectQuery);
		List<PM_IL_FUND_PRICE_DTL> list = handler.fetch(selectQuery,
				"com.iii.pel.forms.PILM055_APAC.PM_IL_FUND_PRICE_DTL", con);

		/*
		 * for (int index = 0; index < list.size(); index++) {
		 * PM_IL_FUND_PRICE_DTL gridValueBean = (PM_IL_FUND_PRICE_DTL) list
		 * .get(index); BeanList.add(gridValueBean); }
		 */

		// Added for grid value alignment in proper
		PM_IL_FUND_PRICE_DTL PM_IL_FUND_PRICE_DTL_BEAN = null;
		Iterator<PM_IL_FUND_PRICE_DTL> it = list.iterator();
		while (it.hasNext()) {
			PM_IL_FUND_PRICE_DTL_BEAN = it.next();
			PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(false);
		}

		this.setBeanList(list);
		if (list.size() > 0) {
			this.setPM_IL_FUND_PRICE_DTL_BEAN(list.get(0));
			this.getPM_IL_FUND_PRICE_DTL_BEAN().setRowSelected(true);
		}

		// actionBean.set(newList);

	}

	public HtmlOutputLabel getCOMP_FPD_SELL_UNIT_RATE_LABEL() {
		return COMP_FPD_SELL_UNIT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_FPD_SELL_UNIT_RATE() {
		return COMP_FPD_SELL_UNIT_RATE;
	}

	public void setCOMP_FPD_SELL_UNIT_RATE_LABEL(
			HtmlOutputLabel COMP_FPD_SELL_UNIT_RATE_LABEL) {
		this.COMP_FPD_SELL_UNIT_RATE_LABEL = COMP_FPD_SELL_UNIT_RATE_LABEL;
	}

	public void setCOMP_FPD_SELL_UNIT_RATE(HtmlInputText COMP_FPD_SELL_UNIT_RATE) {
		this.COMP_FPD_SELL_UNIT_RATE = COMP_FPD_SELL_UNIT_RATE;
	}

	public HtmlOutputLabel getCOMP_FPD_BUY_UNIT_RATE_LABEL() {
		return COMP_FPD_BUY_UNIT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_FPD_BUY_UNIT_RATE() {
		return COMP_FPD_BUY_UNIT_RATE;
	}

	public void setCOMP_FPD_BUY_UNIT_RATE_LABEL(
			HtmlOutputLabel COMP_FPD_BUY_UNIT_RATE_LABEL) {
		this.COMP_FPD_BUY_UNIT_RATE_LABEL = COMP_FPD_BUY_UNIT_RATE_LABEL;
	}

	public void setCOMP_FPD_BUY_UNIT_RATE(HtmlInputText COMP_FPD_BUY_UNIT_RATE) {
		this.COMP_FPD_BUY_UNIT_RATE = COMP_FPD_BUY_UNIT_RATE;
	}

	public HtmlOutputLabel getCOMP_FPD_UNIT_RATE_PER_LABEL() {
		return COMP_FPD_UNIT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_FPD_UNIT_RATE_PER() {
		return COMP_FPD_UNIT_RATE_PER;
	}

	public void setCOMP_FPD_UNIT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_FPD_UNIT_RATE_PER_LABEL) {
		this.COMP_FPD_UNIT_RATE_PER_LABEL = COMP_FPD_UNIT_RATE_PER_LABEL;
	}

	public void setCOMP_FPD_UNIT_RATE_PER(HtmlInputText COMP_FPD_UNIT_RATE_PER) {
		this.COMP_FPD_UNIT_RATE_PER = COMP_FPD_UNIT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_FPD_EFF_FM_DT_LABEL() {
		return COMP_FPD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FPD_EFF_FM_DT() {
		return COMP_FPD_EFF_FM_DT;
	}

	public void setCOMP_FPD_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_FPD_EFF_FM_DT_LABEL) {
		this.COMP_FPD_EFF_FM_DT_LABEL = COMP_FPD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_FPD_EFF_FM_DT(HtmlCalendar COMP_FPD_EFF_FM_DT) {
		this.COMP_FPD_EFF_FM_DT = COMP_FPD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_FPD_EFF_TO_DT_LABEL() {
		return COMP_FPD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FPD_EFF_TO_DT() {
		return COMP_FPD_EFF_TO_DT;
	}

	public void setCOMP_FPD_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_FPD_EFF_TO_DT_LABEL) {
		this.COMP_FPD_EFF_TO_DT_LABEL = COMP_FPD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_FPD_EFF_TO_DT(HtmlCalendar COMP_FPD_EFF_TO_DT) {
		this.COMP_FPD_EFF_TO_DT = COMP_FPD_EFF_TO_DT;
	}

	public PM_IL_FUND_PRICE_DTL getPM_IL_FUND_PRICE_DTL_BEAN() {
		return PM_IL_FUND_PRICE_DTL_BEAN;
	}

	public void setPM_IL_FUND_PRICE_DTL_BEAN(
			PM_IL_FUND_PRICE_DTL PM_IL_FUND_PRICE_DTL_BEAN) {
		this.PM_IL_FUND_PRICE_DTL_BEAN = PM_IL_FUND_PRICE_DTL_BEAN;
	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_FUND_PRICE_DTL_BEAN = null;
			/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
			disableComponents(false);
			String User_Apprv_YN=User_Apprv(PILM055_APAC_CompositeAction);
			if(!("Y".equalsIgnoreCase(User_Apprv_YN))){
				COMP_FPD_APPRV_FLAG.setDisabled(true);
			}
			/*End*/
			if (isINSERT_ALLOWED()) {
				PM_IL_FUND_PRICE_DTL_BEAN = new PM_IL_FUND_PRICE_DTL();
				if(BeanList.size() > 0){
					PM_IL_FUND_PRICE_DTL dtlBean = BeanList.get(BeanList.size()-1);
					PM_IL_FUND_PRICE_DTL_BEAN.setFPD_EFF_FM_DT(getDate());
					PM_IL_FUND_PRICE_DTL_BEAN.setFPD_UNIT_RATE_PER(1.0);
					this.getCOMP_FPD_EFF_FM_DT().setDisabled(true);
				}else{
					this.getCOMP_FPD_EFF_FM_DT().setDisabled(false);
				}
				//PM_IL_FUND_PRICE_DTL_BEAN.setFPD_UNIT_RATE_PER(1.0);
				//BeanList.add(PM_IL_FUND_PRICE_DTL_BEAN);
				resetAllComponent();
				resetSelectedRow();
				PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(true);
				
				
				
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
	
	
	
	private Date getDate() throws Exception{
		Date fmDate = null;
		Date inputDate = null;
		Connection connection = null;
		ResultSet resultSet = null,resultSet2 = null;
		String c1 = "select FPD_EFF_TO_DT from PM_IL_FUND_PRICE_DTL where FPD_FS_CODE = ? " +
					"  order by FPD_EFF_FM_DT asc ";
		String query="SELECT ?+1 FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			resultSet2 = new CRUDHandler().executeSelectStatement(c1, connection,new Object[]{PILM055_APAC_CompositeAction.getParentAction().getPM_IL_FUND_SETUP_BEAN().getFS_CODE()});
			while(resultSet2.next()){
				inputDate = resultSet2.getDate(1);
			}
			if(inputDate != null){
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{inputDate});
			if(resultSet.next()){
				fmDate = resultSet.getDate(1);
			}
			}
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet2);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return fmDate;
	}


	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_FUND_PRICE_DTL_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				BeanList.remove(PM_IL_FUND_PRICE_DTL_BEAN);
				if (BeanList.size() > 0) {
					PM_IL_FUND_PRICE_DTL_BEAN = BeanList.get(0);
				} else if (BeanList.size() == 0) {

					AddRow(null);
				}

				resetAllComponent();
				PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(true);
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

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public List<PM_IL_FUND_PRICE_DTL> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PM_IL_FUND_PRICE_DTL> beanList) {
		BeanList = beanList;
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public void SaveRecord() throws Exception {
		con.commit();
		getWarningMap().put("current", "1 Rows Saved Sucessfully");
		
		// getErrorMap().put(arg0, arg1);
		// con.close();
	}

	
	/*Added by saranya for Fund unit price allocation - Hands on point on 02-03-2017*/
	public void Approval_Mail_To_Supervisor()
	{
		try {
			CRUDHandler handler =null;	
	
			handler =new CRUDHandler();
			/*String query="  SELECT ASD_USER_ID,USER_EMAIL_ID FROM PM_IL_APPR_SETUP_DET,MENU_USER "
					+ "WHERE ASD_CODE = 'IL_FUND'AND ASD_USER_ID = USER_ID"
					+ "AND '203' BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE"
					+ "AND ASD_CHAR_VALUE = 'Y'";
			ResultSet  resultSet1= null;
			String Mail_To=null;
			String path=resourceBundleApp.getString("path");
			resultSet1 = handler.executeSelectStatement(query, dbConnection,new Object[] {});
			if (resultSet1.next()) {
				System.out.println("enter into Final remainder mail schedule");*/
				Email_Procedure_Call.emailTriggerProcCall("000", "FND", null, "F", null,CommonUtils.getConnection());
			//}
		


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*End*/
	/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
	public int validatepost(CompositeAction compositeAction) throws SQLException, DBException
	{
		int fromCount =0,toCount=0,totalCount = 0;
		String fromDateQuery = null,toDateQuery=null;
		ResultSet fromRS = null,toRS = null;
		if(PM_IL_FUND_PRICE_DTL_BEAN.getROWID() == null)
		{
			 	fromDateQuery = "select count(*) from PM_IL_FUND_PRICE_DTL where FPD_EFF_FM_DT between to_date(?,'dd/MM/rrrr') "
						+ "and to_date(?,'dd/MM/rrrr') and fpd_fs_code= ?   ";
				 toDateQuery = "select count(*) from PM_IL_FUND_PRICE_DTL where FPD_EFF_TO_DT between to_date(?,'dd/MM/rrrr') "
						+ "and to_date(?,'dd/MM/rrrr')  and fpd_fs_code= ? ";
				 
				 fromRS = new CRUDHandler().executeSelectStatement(fromDateQuery, CommonUtils.getConnection(),
							new Object[]{CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT()),
						CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT()),compositeAction.getParentAction().getPM_IL_FUND_SETUP_BEAN().getFS_CODE()});
					toRS = new CRUDHandler().executeSelectStatement(fromDateQuery, CommonUtils.getConnection(),
							new Object[]{CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT()),
						CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT()),compositeAction.getParentAction().getPM_IL_FUND_SETUP_BEAN().getFS_CODE()});
				 
		}
		else
		{
			fromDateQuery = "select count(*) from PM_IL_FUND_PRICE_DTL where FPD_EFF_FM_DT between to_date(?,'dd/MM/rrrr') "
					+ "and to_date(?,'dd/MM/rrrr')  and fpd_fs_code= ?  and rowid != ?";
			 toDateQuery = "select count(*) from PM_IL_FUND_PRICE_DTL where FPD_EFF_TO_DT between to_date(?,'dd/MM/rrrr') "
					+ "and to_date(?,'dd/MM/rrrr')  and fpd_fs_code= ?   and rowid != ?";
			 
			 fromRS = new CRUDHandler().executeSelectStatement(fromDateQuery, CommonUtils.getConnection(),
						new Object[]{CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT()),
					CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT()),compositeAction.getParentAction().getPM_IL_FUND_SETUP_BEAN().getFS_CODE(),PM_IL_FUND_PRICE_DTL_BEAN.getROWID()});
				toRS = new CRUDHandler().executeSelectStatement(fromDateQuery, CommonUtils.getConnection(),
						new Object[]{CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT()),
					CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT()),compositeAction.getParentAction().getPM_IL_FUND_SETUP_BEAN().getFS_CODE(),PM_IL_FUND_PRICE_DTL_BEAN.getROWID()});
		}
		
		
		System.out.println("Date values are     "+CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT())
				+"      "+CommonUtils.dateToStringFormat(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT()));
		
		
		while(fromRS.next())
		{
			fromCount = fromRS.getInt(1);
		}
		while(toRS.next())
		{
			toCount = toRS.getInt(1);
		}
		System.out.println("fromCount      "+fromCount+" toCount   "+toCount);
		totalCount = fromCount+toCount;
		
		return totalCount;
	}
	/*End*/
	
	public void post(ActionEvent ae) {
        CommonUtils.clearMaps(this);
		try {
			String fpd_fs_code = CommonUtils.getGlobalVariable("FS_CODE");
			PM_IL_FUND_PRICE_DTL_BEAN.setFPD_FS_CODE(
					fpd_fs_code);
			/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
			System.out.println("Rowid       "+PM_IL_FUND_PRICE_DTL_BEAN.getROWID());
			int totalCount = validatepost(PILM055_APAC_CompositeAction);
			System.out.println("totalCount            "+totalCount);
			/*End*/
			if (PM_IL_FUND_PRICE_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/		
					if(totalCount == 0)
					{
						new CRUDHandler().executeUpdate(PM_IL_FUND_PRICE_DTL_BEAN,
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
					}
					else
					{
						getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"Record Already Exists");
						getErrorMap().put(
								"post",
								"Record Already Exists");
					}
					/*End*/
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

				if (isINSERT_ALLOWED()) {
					if(totalCount == 0)
					{
						PM_IL_FUND_PRICE_DTL_PRE_INSERT();
						new CRUDHandler().executeInsert(PM_IL_FUND_PRICE_DTL_BEAN,
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
						BeanList.add(0, PM_IL_FUND_PRICE_DTL_BEAN);
					}
					else
					{

						getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"Record Already Exists");
						getErrorMap().put(
								"post",
								"Record Already Exists");
					
					}
				} else {
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
			resetAllComponent();
			resetSelectedRow();
			PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void UpdateRecord() throws Exception {
		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.UpdateRecord()");
		con = CommonUtils.getConnection();
		PM_IL_FUND_PRICE_DTL_BEAN = BeanList.get(rowIndex);
		handler.executeUpdate(PM_IL_FUND_PRICE_DTL_BEAN, con);
		con.commit();
		// con.close();
	}

	/*
	 * public Connection getConnection() throws Exception{ context
	 * =(ServletContext)
	 * FacesContext.getCurrentInstance().getExternalContext().getContext(); con =
	 * ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");
	 * return con; }
	 */

	/*
	 * public void OnGotFocus(ActionEvent ae){
	 * System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.OnGotFocus()"); rowIndex =
	 * getDatatable().getRowIndex();
	 * System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.OnFocus()-Row_index Is"
	 * +rowIndex); }
	 */

	public String checkBoxStatus() {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.checkBoxStatus()-Inside");
		rowCheck.add((PM_IL_FUND_PRICE_DTL) datatable.getRowData());
		return "";
	}

	/*
	 * public String getCurrentValue(ActionEvent event){
	 * System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.getCurrentValue()");
	 * String value = null; UIInput input = null;
	 * 
	 * if(event != null){ input = (UIInput) event.getComponent().getParent();
	 * if(input != null){ value = (String) input.getSubmittedValue();
	 * System.out.println("Value in input field: "+value); } } return value; }
	 */

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		// gridtabListener();
	}

	// [ Commented for grid implementation change, Added by: S.Mallika, Dated:
	// 13-Feb-2009
	/*
	 * public void gridtabListener(){
	 * 
	 * int currRowIndex = getDatatable().getRowIndex(); int rowUpdated = 0;
	 * DataGridValueBean gridValueBean = null;
	 * System.out.println(lastUpdatedRowIndex+" "+currRowIndex+"
	 * "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){
	 * System.out.println("GRID TAB LISTENER"); // Get the bean based on row
	 * index gridValueBean = (DataGridValueBean)dataTableList.get(prevRowIndex);
	 *  // Update the record to database if(gridValueBean.getROWID()!=null) {
	 * rowUpdated = dataGridDelegate.updateData(gridValueBean);
	 * errorMap.put("somekey", rowUpdated+" record updated.");
	 * errorMap.put("current", rowUpdated+" record updated."); }else {
	 * gridValueBean.setRSA_PLAN_CODE("dee"); rowUpdated =
	 * dataGridDelegate.updateData(gridValueBean); errorMap.put("somekey",
	 * rowUpdated+" record inserted."); errorMap.put("current", rowUpdated+"
	 * record inserted.");
	 *  }
	 *  // Update previous row index prevRowIndex = currRowIndex; } } } } catch
	 * (Exception e1) { // TODO Put error mechanism to display user that
	 * something happened wrong while updating data e1.printStackTrace(); }
	 * 
	 * return ; }
	 */

	// Commented for grid implementation change, Added by: S.Mallika, Dated:
	// 13-Feb-2009 ]

	public int getRowIndex() {
		int rowindex = getDatatable().getRowIndex();
		return rowindex;
	}

	public void vaildateValues(String value) {
		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.vaildateValues()");
		System.out.println("ValueIs" + value);

		int length = value.length();
		String restricting_pattern = "[a-z]|[A-Z]|[0-9]";
		Pattern p = Pattern.compile(restricting_pattern);
		Matcher m = p.matcher(value);
		int count = 0;
		while (m.find()) {
			System.out.println("Inside While");
			++count;
		}
		if (count != length) {
			System.out.println("WRFWQRRRRRRRR");
			getErrorMap().put("current",
					"Value Should be Numeric and Non-Negative");
		} else {
			getErrorMap().clear();
		}
	}
	public void FPD_SELL_UNIT_RATE_validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_FUND_PRICE_DTL_BEAN().setFPD_SELL_UNIT_RATE((Double)value);
			FPD_SELL_UNIT_RATE_WHEN_VALIDATE_ITEM();
			//COMP_FPD_BUY_UNIT_RATE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	
	
	public void FPD_SELL_UNIT_RATE_WHEN_VALIDATE_ITEM() {
		PM_IL_FUND_PRICE_DTL_BEAN
				.setFPD_BUY_UNIT_RATE(PM_IL_FUND_PRICE_DTL_BEAN
						.getFPD_SELL_UNIT_RATE());
	}

	public void FPD_BUY_UNIT_RATE_WHEN_VALIDATE_ITEM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.FPD_BUY_UNIT_RATE_WHEN_VALIDATE_ITEM()");

		String FPD_BUY_UNIT_RATE = getCurrentValue(event);
		System.out.println("FPD_BUY_UNIT_RATE*********" + FPD_BUY_UNIT_RATE);

		int length = FPD_BUY_UNIT_RATE.length();
		String restricting_pattern = "[a-z]|[A-Z]|[0-9]|[.]";
		Pattern p = Pattern.compile(restricting_pattern);
		Matcher m = p.matcher(FPD_BUY_UNIT_RATE);
		int count = 0;
		while (m.find()) {
			System.out.println("Inside While");
			++count;
		}
		if (count != length) {
			System.out.println("WRFWQRRRRRRRR");
			getErrorMap().put("current",
					"Value Should be Numeric and Non-Negative");
		} else {
			getErrorMap().clear();
		}

		if (getErrorMap().size() == 0) {
			Double DOUBLE_FPD_BUY_UNIT_RATE = Double
					.parseDouble(FPD_BUY_UNIT_RATE);
			PM_IL_FUND_PRICE_DTL_BEAN
					.setFPD_BUY_UNIT_RATE(DOUBLE_FPD_BUY_UNIT_RATE);
		} else {
			System.out.println("Sorry Error Is Teher");
		}
	}

	public void copyValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		/*
		 * System.out.println("Validation*********");
		 * System.out.println(COMP_FPD_SELL_UNIT_RATE.getSubmittedValue());
		 * System.out.println(COMP_FPD_SELL_UNIT_RATE.getValue());
		 * if(COMP_FPD_SELL_UNIT_RATE.getSubmittedValue()!=null) {
		 * System.out.println("Condition is Success**************"); String
		 * sellUnitRate=(String)COMP_FPD_SELL_UNIT_RATE.getSubmittedValue();
		 * getPM_IL_FUND_PRICE_DTL_BEAN().setFPD_SELL_UNIT_RATE(Double.parseDouble(sellUnitRate));
		 * //COMP_FPD_BUY_UNIT_RATE.setValue(sellUnitRate);
		 *  }
		 */}
	
	public void chkUnitPriceYn(CompositeAction compositeAction)
			throws Exception {
		String C1 = "SELECT PAF_PROD_CODE FROM PM_IL_PROD_APPL_FUND WHERE PAF_FUND_CODE=?";
		String C2 = "SELECT ASD_CHAR_VALUE "
				+ "FROM   PM_IL_APPR_SETUP_DET "
				+ "WHERE  ASD_CODE = 'NAV_KEY_YN' "
				+ "AND    ASD_USER_ID = ? "
				+ "AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String m_unitprice = null;
		String prod_code = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			Connection con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { compositeAction.getParentAction()
							.getPM_IL_FUND_SETUP_BEAN().getFS_CODE() });
			while (rs1.next()) {
				prod_code = rs1.getString(1);

				rs2 = handler.executeSelectStatement(C2, con, new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
						prod_code });
				while (rs2.next()) {
					m_unitprice = rs2.getString(1);
				}
				if ("N".equalsIgnoreCase(m_unitprice)) {
					COMP_FPD_BUY_UNIT_RATE.setDisabled(true);
					COMP_FPD_SELL_UNIT_RATE.setDisabled(true);
					throw new Exception(
							"User not authorized to change the UnitPrice for the product"
									+ prod_code);
				} else {
					COMP_FPD_BUY_UNIT_RATE.setDisabled(false);
					COMP_FPD_SELL_UNIT_RATE.setDisabled(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public Date customizedstringToDate(String dateString) {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.customizedstringToDate()-Inside");

		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = new SimpleDateFormat(PELConstants.pelDateFormat)
					.parse(dateString);
			long sqlDateLong = date.getTime();
			sqlDate = new java.sql.Date(sqlDateLong);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}

	public Date db_customizedstringToDate(String dateString) {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.db_customizedstringToDate()"
						+ dateString);

		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = new SimpleDateFormat("dd-MMM-yyyy").parse(dateString);
			long sqlDateLong = date.getTime();
			sqlDate = new java.sql.Date(sqlDateLong);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}

	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.getCurrentValue()-event"
						+ event);
		java.util.Date util_date = null;

		String value = null;
		UIInput input = null;
		UICalendar calender = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			System.out
					.println("PM_IL_FUND_PRICE_DTL_ACTION.getCurrentValue()-input"
							+ input);
			if (input != null) {
				if (input instanceof UICalendar) {
					// System.out.println("INSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS-99"+input.getSubmittedValue());
					String dateString = input.getSubmittedValue().toString();
					System.out.println("---------dateString" + dateString);

					java.sql.Date sql_date = (java.sql.Date) customizedstringToDate(dateString);
					try {
						util_date = CommonUtils.sqlToUtilDate(sql_date);
						System.out
								.println("util_date+++++++++++++" + util_date);
					} catch (ParseException pe) {
						pe.printStackTrace();
					}
					// java.util.Date val =
					// (java.util.Date)input.getSubmittedValue();
					// System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.getCurrentValue()-val"+val);

					value = format_Date(util_date);
					System.out.println("VALUEEEEEEEE" + value);
					return value;
				}

				value = input.getSubmittedValue().toString();
				System.out
						.println("PM_IL_FUND_PRICE_DTL_ACTION.getCurrentValue()-value"
								+ value);
			}
		}
		return value;
	}

	public String format_Date(java.util.Date date) {
		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.format_Date()-date"
				+ date);
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(PELConstants.pelDateFormat);

		result = sdf.format(date).toString();
		System.out.println("Formatted Date is = " + result);
		return result;
	}

	public String format_dbDate(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date).toString();
		return result;
	}

	public void validateFPD_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		CommonUtils.clearMaps(this);
		Date DATE_EFF_FM_DT = (Date) value;
		try {
			if (DATE_EFF_FM_DT != null) {
				if (DATE_EFF_FM_DT.after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "2181"));
				}
			}
			COMP_FPD_EFF_FM_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}

	public boolean dateGreaterthenOrEqualTo(java.util.Date date1,
			java.util.Date date2) {

		boolean flag = false;
		if (date1.after(date2) || date1.equals(date2)) {
			flag = true;
		}
		System.out.println("FLAG IS" + flag);
		return flag;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public Date StringToDate(String dateString) {
		System.out.println("DateString Is" + dateString);

		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = new SimpleDateFormat(PELConstants.pelDateFormat)
					.parse(dateString);
			long sqlDateLong = date.getTime();
			sqlDate = new java.sql.Date(sqlDateLong);
			System.out.println("CommonUtils.stringToDate()-sqlDate" + sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}

	public void whenValidateFPD_EFF_FM_DT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		if (input.isValid()) {
			this.PM_IL_FUND_PRICE_DTL_BEAN.setFPD_EFF_FM_DT((Date) input
					.getValue());
		}
	}

	public void whenValidateFPD_EFF_TO_DT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		if (input.isValid()) {
			this.PM_IL_FUND_PRICE_DTL_BEAN.setFPD_EFF_TO_DT((Date) input
					.getValue());
		}
	}

	public void validateFPD_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			Date DATE_FPD_EFF_FM_DT = PM_IL_FUND_PRICE_DTL_BEAN
					.getFPD_EFF_FM_DT();
			Date DATE_FPD_EFF_TO_DT = (Date) value;
			if (DATE_FPD_EFF_TO_DT != null) {
				System.out
						.println("PM_IL_FUND_PRICE_DTL_ACTION.FPD_EFF_TO_DT_WHEN_VALIDATE_ITEM()-Condition");
				if (DATE_FPD_EFF_TO_DT.before(DATE_FPD_EFF_FM_DT)) {
					getErrorMap().put(
							"current",
							Messages.getMessage(
									"com.iii.premia.common.errorUtil.PELErrorMessages",
									"91001").getDetail());
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1050"));
				} else {
					getErrorMap().clear();
				}
			}
			COMP_FPD_EFF_TO_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}

	public boolean dateLessthen(java.util.Date date1, java.util.Date date2) {

		boolean flag = false;
		if (date1.before(date2)) {
			flag = true;
		}
		System.out.println("Flag" + flag);
		return flag;
	}

	public boolean dateLessthenOrEqualTo(java.util.Date date1,
			java.util.Date date2) {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.dateLessthenOrEqualTo()");
		boolean flag = false;
		if (date1.before(date2) || date1.equals(date2)) {
			flag = true;
		}
		System.out.println("Flag" + flag);
		return flag;
	}

	public void onLoad(PhaseEvent event) {
		try{
			//CommonUtils.clearMaps(this);
			
			if(isBlockFlag()){
				getWarningMap().clear();
				getErrorMap().clear();
				
				populateValues();
				if(PM_IL_FUND_PRICE_DTL_BEAN.getROWID() == null){
					PM_IL_FUND_PRICE_DTL_WHEN_CREATE_RECORD();
					System.out.println("flag onload :"+PM_IL_FUND_PRICE_DTL_BEAN.getFPD_APPRV_FLAG());
				}
				/*Added by saranya for  Fund unit price allocation - Hands on point on 28-02-2017*/
				COMP_FPD_APPRV_DT.setDisabled(true);
				String User_Apprv_YN=User_Apprv(PILM055_APAC_CompositeAction);
				if("Y".equalsIgnoreCase(User_Apprv_YN)){
					COMP_FPD_APPRV_FLAG.setDisabled(false);
				}
				
				PM_IL_FUND_PRICE_DTL_WHEN_NEW_RECORD_INSTANCE();
				chkUnitPriceYn(PILM055_APAC_CompositeAction);
				System.out.println("values :"+User_Apprv_YN +"flag :"+ PILM055_APAC_CompositeAction.getChildAction().getPM_IL_FUND_PRICE_DTL_BEAN().getFPD_APPRV_FLAG());
				
				/*End*/
				setBlockFlag(false);
			}
	       
			//PM_IL_FUND_PRICE_DTL_PRE_BLOCK();
			
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
	public void disableComponents(boolean disabled)
	{

		COMP_FPD_SELL_UNIT_RATE.setDisabled(disabled);
		COMP_FPD_BUY_UNIT_RATE.setDisabled(disabled);
		COMP_FPD_EFF_TO_DT.setDisabled(disabled);
		COMP_FPD_APPRV_FLAG.setDisabled(disabled);
		/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
		 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
		 *
		 */
		COMP_FPD_UNIT_PRICE_RATE.setDisabled(disabled);
		/*End*/
	
	}
	public void checkFreeze()
	{
		String User_Apprv_YN=User_Apprv(PILM055_APAC_CompositeAction);
		System.out.println("Values are     "+PILM055_APAC_CompositeAction.getChildAction().getPM_IL_FUND_PRICE_DTL_BEAN().getFPD_APPRV_FLAG()+"     "+User_Apprv_YN);
		if(PILM055_APAC_CompositeAction.getChildAction().getPM_IL_FUND_PRICE_DTL_BEAN().getFPD_APPRV_FLAG() != null
				&& PILM055_APAC_CompositeAction.getChildAction().getPM_IL_FUND_PRICE_DTL_BEAN().getFPD_APPRV_FLAG().equalsIgnoreCase("Y"))
		{
			if(!(User_Apprv_YN==null))
			{
				if(User_Apprv_YN.equalsIgnoreCase("Y"))
				{
					
					disableComponents(false);
				}else{
					disableComponents(true);
				}
				
			}
		}
	}
	/*End*/
	
	public void populateValues() throws Exception  {
		
		String FS_CODE = CommonUtils.getGlobalVariable("FS_CODE");
		String selectQuery = "SELECT PM_IL_FUND_PRICE_DTL.ROWID,PM_IL_FUND_PRICE_DTL.* FROM PM_IL_FUND_PRICE_DTL where FPD_FS_CODE ='"+FS_CODE+"' order by FPD_EFF_FM_DT asc ";
		List<PM_IL_FUND_PRICE_DTL> list;
		try {
			Connection con =CommonUtils.getConnection();
			list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM055_APAC.PM_IL_FUND_PRICE_DTL",con);
			this.setBeanList(list);
			PM_IL_FUND_PRICE_DTL PM_IL_FUND_PRICE_DTL_BEAN = null;
			Iterator<PM_IL_FUND_PRICE_DTL> it = list.iterator();
			while(it.hasNext()){
				PM_IL_FUND_PRICE_DTL_BEAN = it.next();
				PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(false);
			}
			if (list.size()>0){					
				this.setPM_IL_FUND_PRICE_DTL_BEAN(list.get(0));
				this.getCOMP_FPD_EFF_FM_DT().setDisabled(true);
				this.getPM_IL_FUND_PRICE_DTL_BEAN().setRowSelected(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw e;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
		
		
		//actionBean.setBeanList(newList);
	}
	
	
	public void LastColumnListener() {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.LastColumnListener()-Inside");
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		try {
			PM_IL_FUND_PRICE_DTL valueBean = null;
			int RowIndex = getDatatable().getRowIndex();

			valueBean = BeanList.get(RowIndex);
			con = CommonUtils.getConnection();
			System.out
					.println("PM_IL_FUND_PRICE_DTL_ACTION.LastColumnListener()-ValueBean"
							+ valueBean.getFPD_EFF_FM_DT());
			System.out.println("The Row Id Is--Vijay" + valueBean.getROWID());

			// con = getConnection();

			System.out.println("The Bean Lists Is" + BeanList.get(rowIndex));
			PM_IL_FUND_PRICE_DTL_BEAN = BeanList.get(rowIndex);

			System.out.println("THE FPD FS CODE IS "
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE());
			System.out.println("LastColumnListener(Unit)"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_UNIT_RATE_PER());
			System.out.println("LastColumnListener(sell) "
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_SELL_UNIT_RATE());
			System.out.println("LastColumnListener(buy) "
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_BUY_UNIT_RATE());
			System.out.println("LastColumnListener(from)"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT());
			System.out.println("LastColumnListener(to)"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT());
			System.out
					.println("#########################################################");
			System.out.println("PM_IL_FUND_PRICE_DTL_BEAN"
					+ session.get("FPD_FS_CODE").toString());
			String fpd_fs_code = session.get("FPD_FS_CODE").toString();
			System.out
					.println("#########################################################");
			PM_IL_FUND_PRICE_DTL_BEAN.setFPD_FS_CODE(fpd_fs_code);
			valueBean.setFPD_FS_CODE(fpd_fs_code);
			valueBean.setFPD_EFF_FM_DT(PM_IL_FUND_PRICE_DTL_BEAN
					.getFPD_EFF_FM_DT());
			valueBean.setFPD_EFF_TO_DT(PM_IL_FUND_PRICE_DTL_BEAN
					.getFPD_EFF_TO_DT());
			System.out.println("THE FROM DATE FIELD IS"
					+ valueBean.getFPD_EFF_FM_DT());
			System.out.println("THE TO DATE FROM VALUE BEAN IS "
					+ valueBean.getFPD_EFF_TO_DT());

			if (valueBean.getROWID() != null) {
				System.out.println("UPdattion Is Done");
				System.out
						.println("PM_IL_FUND_PRICE_DTL_ACTION.LastColumnListener()-Inside");
				if (getErrorMap().isEmpty()) {
					System.out.println("eRROR MAP IS EMPTY");
					int n = handler.executeUpdate(valueBean, con);
					System.out.println("NO ROWS UPDATED" + n);
					SaveRecord();
					getWarningMap().put("current", n + " Rows Updated");
				}
				// con.commit();
				// con.close();
			} else {
				System.out
						.println("PM_IL_FUND_PRICE_DTL_ACTION.LastColumnListener()-Inside22222222");
				PM_IL_FUND_PRICE_DTL_PRE_INSERT();
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println(valueBean.getFPD_FS_CODE());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");

				if (getErrorMap().isEmpty()) {
					System.out.println("EEEEEEEEEEEEEEE");
					int n = handler.executeInsert(valueBean, con);
					SaveRecord();
					getWarningMap().put("current", n + " Rows Inserted");
					// gsdg
					System.out.println("No Of Rows Inserted Is" + n);
					// con.commit();
					// con.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PM_IL_FUND_PRICE_DTL_WHEN_CREATE_RECORD() {

		PM_IL_FUND_PRICE_DTL_BEAN = new PM_IL_FUND_PRICE_DTL();
		PM_IL_FUND_PRICE_DTL_BEAN.setFPD_UNIT_RATE_PER(1.0);
		/*Added by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
		PM_IL_FUND_PRICE_DTL_BEAN.setFPD_APPRV_FLAG("N");
		/*End*/
		
	}

	
	
	public void PM_IL_FUND_PRICE_DTL_WHEN_NEW_RECORD_INSTANCE() {

		
			COMP_FPD_UNIT_RATE_PER.setDisabled(true);
		
		//}
	}

	/*public void PM_IL_FUND_PRICE_DTL_PRE_BLOCK() {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.PM_IL_FUND_PRICE_DTL_PRE_BLOCK()");
		ctrlbean.setM_DELETE_MSG_FLAG("Y");
	}*/

	public void PM_IL_FUND_PRICE_DTL_PRE_INSERT() throws Exception {
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.PM_IL_FUND_PRICE_DTL_PRE_INSERT()-Inside");
		L_UNIQUE_MOD_PROD();
		/*ctrlbean.setM_LANG_CODE((String) session.get("GLOBAL.M_LANG_CODE"));
		System.out
				.println("PM_IL_FUND_PRICE_DTL_ACTION.PM_IL_FUND_PRICE_DTL_PRE_INSERT()-LANG_CODE"
						+ ctrlbean.getM_LANG_CODE());*/
		// [ Removed Hard coded user id: added by: Shankar bodduluri Dated:
		// 19-Mar-2009 ]

		PM_IL_FUND_PRICE_DTL_BEAN.setFPD_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		PM_IL_FUND_PRICE_DTL_BEAN.setFPD_CR_DT(new CommonUtils()
				.getCurrentDate());

	}

	public Map<String, Object> getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}



	public void L_UNIQUE_MOD_PROD() {
		try {
			Connection con = CommonUtils.getConnection();
			FacesContext context = FacesContext.getCurrentInstance();
			String M_DUMMY = null;

			// PM_IL_FUND_PRICE_DTL bean = (PM_IL_FUND_PRICE_DTL)
			// datatable.getRowData();
			System.out.println("L_UNIQUE_MOD_PROD() Called...");
			// String Q_COMP_FPD_EFF_FM_DT =
			// getCOMP_FPD_EFF_FM_DT().getSubmittedValue().toString();
			System.out.println("BBBBBBBBBBBBBBBBB"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_BUY_UNIT_RATE());
			System.out
					.println("SSSSSSSSSSSSSSSSS"
							+ (String) getCOMP_FPD_SELL_UNIT_RATE()
									.getSubmittedValue());
			System.out
					.println("PM_IL_FUND_PRICE_DTL_ACTION.L_UNIQUE_MOD_PROD()>>>> "
							+ getCOMP_FPD_EFF_FM_DT()
									.getAsDate(
											getCOMP_FPD_EFF_FM_DT()
													.getSubmittedValue()));

			// String from_Date =
			// format_Date1(PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT());
			String from_Date = format_Date1(getCOMP_FPD_EFF_FM_DT().getAsDate(
					PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_FM_DT()));
			System.out.println("from_Date = " + from_Date);

			System.out
					.println("PM_IL_FUND_PRICE_DTL_ACTION.L_UNIQUE_MOD_PROD() "
							+ (String) getCOMP_FPD_EFF_TO_DT()
									.getSubmittedValue());
			// String to_Date =
			// format_Date1((java.sql.Date)PM_IL_FUND_PRICE_DTL_BEAN.getFPD_EFF_TO_DT());
			String to_Date = format_Date1(getCOMP_FPD_EFF_TO_DT().getAsDate(
					getCOMP_FPD_EFF_TO_DT().getSubmittedValue()));
			System.out.println("to_Date" + to_Date);

			String selectQuery_1 = "SELECT 'X' FROM  PM_IL_FUND_PRICE_DTL  WHERE  FPD_FS_CODE  = '"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE()
					+ "'"
					+ "AND  (( '"
					+ from_Date
					+ "'"
					+ " BETWEEN FPD_EFF_FM_DT  AND  FPD_EFF_TO_DT  OR '"
					+ to_Date
					+ "'"
					+ " BETWEEN FPD_EFF_FM_DT  AND  FPD_EFF_TO_DT)  OR ('"
					+ from_Date
					+ "'"
					+ " <"
					+ " FPD_EFF_FM_DT  AND '"
					+ to_Date + "'" + ">" + " FPD_EFF_TO_DT ))";
			System.out.println("selectQuery_1>>>>>>>" + selectQuery_1);
			ResultSet rs1 = null;
			rs1 = handler.executeSelectStatement(selectQuery_1, con);

			System.out
					.println("PM_IL_FUND_PRICE_DTL_ACTION.L_UNIQUE_MOD_PROD()-rrrrrrrrr"
							+ PM_IL_FUND_PRICE_DTL_BEAN.getROWID());

			String temp = "";
			if (PM_IL_FUND_PRICE_DTL_BEAN.getROWID() != null) {

				temp = " ROWID  <>  '" + PM_IL_FUND_PRICE_DTL_BEAN.getROWID()
						+ "'";
				System.out.println("If Satisfied- temp is " + temp);

			} else {
				temp = " ROWID  <>  " + PM_IL_FUND_PRICE_DTL_BEAN.getROWID();
				System.out.println("ELse Satisfied temp is " + temp);
			}

			String selectQuery_2 = "SELECT 'X' FROM  PM_IL_FUND_PRICE_DTL  WHERE "
					+ " FPD_FS_CODE  = '"
					+ PM_IL_FUND_PRICE_DTL_BEAN.getFPD_FS_CODE()
					+ "'"
					+ " AND (( '"
					+ from_Date
					+ "'"
					+ " BETWEEN FPD_EFF_FM_DT  AND"
					+ " FPD_EFF_TO_DT  OR '"
					+ to_Date
					+ "'"
					+ " BETWEEN FPD_EFF_FM_DT  AND  FPD_EFF_TO_DT)  OR ( '"
					+ from_Date
					+ "'"
					+ " < FPD_EFF_FM_DT  AND '"
					+ to_Date
					+ "'" + " > FPD_EFF_TO_DT))  AND" + temp;

			System.out.println("selectQuery_2<<<<<<<<<<()" + selectQuery_2);
			ResultSet rs2 = null;
			rs2 = handler.executeSelectStatement(selectQuery_2, con);
			/*
			 * if(:SYSTEM.RECORD_STATUS=="INSERT") {
			 */

			PM_IL_FUND_SETUP_SEARCH_PAGE action = (PM_IL_FUND_SETUP_SEARCH_PAGE) getSession()
					.get("PILM055_APAC_PM_IL_FUND_SETUP_SEARCH_PAGE");

			/*
			 * ELResolver resolver = context.getApplication().getELResolver();
			 * PM_IL_FUND_SETUP_SEARCH_PAGE actionBean=
			 * (PM_IL_FUND_SETUP_SEARCH_PAGE)resolver.getValue(context.getELContext(),
			 * null, "PILM055_APAC_PM_IL_FUND_SETUP_SEARCH_PAGE");
			 */
			// PM_IL_FUND_SETUP valueBean =
			// actionBean.getPM_IL_FUND_SETUP_BEAN()
			// if(action.isINSERT_ALLOWED())
			System.out.println("INSERT IS ALLLOWEDDDDDDDD ???????"
					+ action.isINSERT_ALLOWED());
			if (action.isINSERT_ALLOWED()) {
				System.out
						.println("##############The Mode Is Insert#######################");
				if (rs1.next()) {
					System.out.println("Inside result set");
					M_DUMMY = rs1.getString(1);
					System.out.println("DUMMYYYYYYYYYY" + M_DUMMY);
				}
				rs1.close();
				if (M_DUMMY != null) {

					if (M_DUMMY.equals("X")) {
						System.out.println("Error Is  Going To Pop>>>>>>>>");
						getErrorMap()
								.put(
										"current",
										Messages
												.getMessage(
														"com.iii.premia.common.errorUtil.PELErrorMessages",
														"91049").getDetail());
						// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91049,:CTRL.M_LANG_CODE);
						// throw new FORM_TRIGGER_FAILURE();
					} else {
						System.out.println("CLERING THE ERROR MAP >>>>>>>>");
						getErrorMap().clear();
					}
				}
				System.out
						.println("PM_IL_FUND_PRICE_DTL_ACTION.L_UNIQUE_MOD_PROD()-HHHHHHHHHHHHHHHHH");
			} else {

				System.out
						.println("***************The Mode Is Different*********************");
				if (rs2.next()) {
					System.out.println("Inside result set");
					M_DUMMY = rs2.getString(1);
					System.out.println("DUMMYYYYYYYYYY" + M_DUMMY);
				}
				rs2.close();
				if (M_DUMMY != null) {

					if (M_DUMMY.equals("X")) {
						System.out.println("Error Is Going To POP+++++++");
						getErrorMap()
								.put(
										"current",
										Messages
												.getMessage(
														"com.iii.premia.common.errorUtil.PELErrorMessages",
														"91049").getDetail());
						// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91049,:CTRL.M_LANG_CODE);
						// throw new FORM_TRIGGER_FAILURE();
					} else {
						System.out.println("CLERING THE ERROR MAP >>>>>>>>");
						getErrorMap().clear();
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String format_Date1(java.util.Date date) {
		System.out.println("Date inside >>> " + date);
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date).toString();
		return result;
	}

	public String STD_MESSAGE_ROUTINE(String errorCode, String P_LANG_CODE) {
		try {
			String query = "SELECT DECODE('"
					+ P_LANG_CODE
					+ "', 'ENG', EM_ENG_MSG, EM_FOR_MSG),EM_ERR_FLAG FROM PP_ERROR_MESSAGE WHERE EM_ERR_NO = '"
					+ errorCode + "'";
			System.out.println("query88888888888888" + query);
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection());
			while (resultSet.next()) {
				errmsg = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println("PM_IL_FUND_SETUP_ACTION.STD_MESSAGE_ROUTINE()-errmsg"
						+ errmsg);
		return errmsg;
	}

	public HtmlOutputLabel getCOMP_FPD_FS_CODE_LABEL() {
		return COMP_FPD_FS_CODE_LABEL;
	}

	public void setCOMP_FPD_FS_CODE_LABEL(HtmlOutputLabel comp_fpd_fs_code_label) {
		COMP_FPD_FS_CODE_LABEL = comp_fpd_fs_code_label;
	}

	public HtmlInputText getCOMP_FPD_FS_CODE() {
		return COMP_FPD_FS_CODE;
	}

	public void setCOMP_FPD_FS_CODE(HtmlInputText comp_fpd_fs_code) {
		COMP_FPD_FS_CODE = comp_fpd_fs_code;
	}

	public ControlBean getCtrlbean() {
		return ctrlbean;
	}

	public void setCtrlbean(ControlBean ctrlbean) {
		this.ctrlbean = ctrlbean;
	}

	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}

	/**
	 * Instantiates all components in PM_IL_FUND_PRICE_DTL_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_FPD_FS_CODE = new HtmlInputText();
		COMP_FPD_SELL_UNIT_RATE = new HtmlInputText();
		COMP_FPD_BUY_UNIT_RATE = new HtmlInputText();
		COMP_FPD_UNIT_RATE_PER = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_FPD_EFF_FM_DT = new HtmlCalendar();
		COMP_FPD_EFF_TO_DT = new HtmlCalendar();
		
		/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
		 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
		 *
		 */
		COMP_FPD_UNIT_PRICE_RATE_LABEL = new HtmlOutputLabel();
		COMP_FPD_UNIT_PRICE_RATE       = new HtmlInputText();
		/*End*/

	}

	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	// [ Added for grid implementation change, Added by: S.Mallika, Dated:
	// 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	/*
	 * public String saveCurrentRecord(){ String outcome = null; int rowIndex =
	 * datatable.getRowIndex();
	 * 
	 * try{ if(rowIndex > -1){ // Calling last Column listener
	 * LastColumnListener(); }else{
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * Messages.getString(PELConstants.pelMessagePropertiesPath,
	 * "IL_GRID$INVALID_ROW_INDEX$message")); } }catch(Exception exc){
	 * exc.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * exc.getMessage()); }
	 * 
	 * return outcome; }
	 */
	/*Modified by saranya for Fund unit price allocation - Hands on point on 03-03-2017*/
	public void saveCurrentRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (getPM_IL_FUND_PRICE_DTL_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_IL_FUND_PRICE_DTL_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeUpdate(getPM_IL_FUND_PRICE_DTL_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",
					message);
			System.out.println("message  :"+message);
			/*Added by saranya for  Fund unit price allocation - Hands on point on 28-02-2017*/
			String User_Apprv_YN=User_Apprv(PILM055_APAC_CompositeAction);
			if("N".equalsIgnoreCase(User_Apprv_YN)){
			Approval_Mail_To_Supervisor();
			}
			/*End*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + e.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + e.getMessage());
		}
	}
	
	// Added for grid implementation change, Added by: S.Mallika, Dated:
	// 13-Feb-2009 ]

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByFPD_BUY_UNIT_RATE() {
		return filterByFPD_BUY_UNIT_RATE;
	}

	public void setFilterByFPD_BUY_UNIT_RATE(String filterByFPD_BUY_UNIT_RATE) {
		this.filterByFPD_BUY_UNIT_RATE = filterByFPD_BUY_UNIT_RATE;
	}

	public String getFilterByFPD_SELL_UNIT_RATE() {
		return filterByFPD_SELL_UNIT_RATE;
	}

	public void setFilterByFPD_SELL_UNIT_RATE(String filterByFPD_SELL_UNIT_RATE) {
		this.filterByFPD_SELL_UNIT_RATE = filterByFPD_SELL_UNIT_RATE;
	}

	public CompositeAction getPILM055_APAC_CompositeAction() {
		return PILM055_APAC_CompositeAction;
	}

	public void setPILM055_APAC_CompositeAction(CompositeAction compositeAction) {
		PILM055_APAC_CompositeAction = compositeAction;
	}

	public String getFilterByFPD_EFF_TO_DT() {
		return filterByFPD_EFF_TO_DT;
	}

	public void setFilterByFPD_EFF_TO_DT(String filterByFPD_EFF_TO_DT) {
		this.filterByFPD_EFF_TO_DT = filterByFPD_EFF_TO_DT;
	}
/*Added by saranya for  Fund unit price allocation - Hands on point on 27-02-2017*/
	
	public HtmlOutputLabel COMP_FPD_APPRV_FLAG_LABEL;
	
	public HtmlSelectOneMenu COMP_FPD_APPRV_FLAG;
	
	public HtmlOutputLabel COMP_FPD_APPRV_DT_LABEL;
	
	public HtmlCalendar COMP_FPD_APPRV_DT;
	
	private List<SelectItem> listFPD_APPRV_FLAG = new ArrayList<SelectItem>();
	
	public HtmlOutputLabel getCOMP_FPD_APPRV_DT_LABEL() {
		return COMP_FPD_APPRV_DT_LABEL;
	}

	public void setCOMP_FPD_APPRV_DT_LABEL(HtmlOutputLabel cOMP_FPD_APPRV_DT_LABEL) {
		COMP_FPD_APPRV_DT_LABEL = cOMP_FPD_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FPD_APPRV_DT() {
		return COMP_FPD_APPRV_DT;
	}

	public void setCOMP_FPD_APPRV_DT(HtmlCalendar cOMP_FPD_APPRV_DT) {
		COMP_FPD_APPRV_DT = cOMP_FPD_APPRV_DT;
	}


	public List<SelectItem> getListFPD_APPRV_FLAG() {
		return listFPD_APPRV_FLAG;
	}

	public void setListFPD_APPRV_FLAG(List<SelectItem> listFPD_APPRV_FLAG) {
		this.listFPD_APPRV_FLAG = listFPD_APPRV_FLAG;
	}

	public HtmlOutputLabel getCOMP_FPD_APPRV_FLAG_LABEL() {
		return COMP_FPD_APPRV_FLAG_LABEL;
	}

	public void setCOMP_FPD_APPRV_FLAG_LABEL(
			HtmlOutputLabel cOMP_FPD_APPRV_FLAG_LABEL) {
		COMP_FPD_APPRV_FLAG_LABEL = cOMP_FPD_APPRV_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FPD_APPRV_FLAG() {
		return COMP_FPD_APPRV_FLAG;
	}

	public void setCOMP_FPD_APPRV_FLAG(HtmlSelectOneMenu cOMP_FPD_APPRV_FLAG) {
		COMP_FPD_APPRV_FLAG = cOMP_FPD_APPRV_FLAG;
	}
	
	public void validateFPD_APPRV_FLAG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try{
			String CurValue=(String)value;
			/*PM_IL_FUND_PRICE_DTL_BEAN.setFPD_APPRV_FLAG(CurValue);*/
			String User_Apprv_YN=User_Apprv(PILM055_APAC_CompositeAction);
			User_Apprv_YN = CommonUtils.nvl(User_Apprv_YN,"N");
			System.out.println("CurValue     "+CurValue);
			if(User_Apprv_YN.equalsIgnoreCase("Y")){
				COMP_FPD_APPRV_FLAG.setDisabled(false);
				PM_IL_FUND_PRICE_DTL_BEAN.setFPD_APPRV_FLAG(CurValue);
				PM_IL_FUND_PRICE_DTL_BEAN.setFPD_APPRV_DT(new CommonUtils().getCurrentDate());
				System.out.println("Approval Date :"+PM_IL_FUND_PRICE_DTL_BEAN.getFPD_APPRV_DT());
			}else{
				throw new Exception(
						"User not authorized to change the Approval Flag");
			}
		
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_CREDIT_DISCOUNT_PERC",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			setListFPD_APPRV_FLAG(ListItemUtil.getDropDownListValue(connection,
					"PILM055_APAC", "PM_IL_FUND_PRICE_DTL",
					"PM_IL_FUND_PRICE_DTL.FPD_APPRV_FLAG", "YESNO"));

	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
	 public void validateFPD_APPRV_DT(FacesContext facesContext,
			 UIComponent component, Object value) throws ValidatorException {
		 CommonUtils.clearMaps(this);
		
		 try {
			 PM_IL_FUND_PRICE_DTL_BEAN.setFPD_APPRV_DT((Date) value);
			 System.out.println("Approval Date :"+PM_IL_FUND_PRICE_DTL_BEAN.getFPD_APPRV_DT());
			
		 } catch (Exception exception) {
			 exception.printStackTrace();
			 throw new ValidatorException(new FacesMessage(exception
					 .getMessage()));
		 } finally {
			 try {
				 ErrorHelpUtil.getWarningForProcedure(CommonUtils
						 .getConnection(), "POL_START_DT", getWarningMap());
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 public String User_Apprv(CompositeAction compositeAction) {

		 String C1 = "SELECT PAF_PROD_CODE FROM PM_IL_PROD_APPL_FUND WHERE PAF_FUND_CODE=?";
		 String C2 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID = ?"
				+ " AND ASD_CODE = 'IL_FUND' AND ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE";

		 String User_Apprv_YN = null;
		 Connection connection = null;
		 String PROD_CODE=null;
		 ResultSet rs = null;
		 ResultSet rs1 = null;
			try {
			 connection = CommonUtils.getConnection();
			 rs1 = handler.executeSelectStatement(C1, connection,new Object[] { compositeAction.getParentAction()
								.getPM_IL_FUND_SETUP_BEAN().getFS_CODE() });
				while (rs1.next()) {
					PROD_CODE = rs1.getString(1);
					/*System.out.println("prod_code  :"+PROD_CODE);
					System.out.println("user_id :"+ CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));*/
					rs = new CRUDHandler().executeSelectStatement(C2, connection,
					 new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),PROD_CODE });
					if(rs.next()) {
						User_Apprv_YN = rs.getString(1);
						
					}
					if("Y".equalsIgnoreCase(User_Apprv_YN))
						break;
				}
			
			} catch (Exception e) {
			 e.printStackTrace();
		 } 
		 return CommonUtils.nvl(User_Apprv_YN,"N");
	 }
	
	/*End*/
	 
	 
	/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
	 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
	 *
	 */
	
	 private HtmlOutputLabel COMP_FPD_UNIT_PRICE_RATE_LABEL;
	 private HtmlInputText COMP_FPD_UNIT_PRICE_RATE;

	 public HtmlOutputLabel getCOMP_FPD_UNIT_PRICE_RATE_LABEL() {
		 return COMP_FPD_UNIT_PRICE_RATE_LABEL;
	 }

	 public void setCOMP_FPD_UNIT_PRICE_RATE_LABEL(
			 HtmlOutputLabel cOMP_FPD_UNIT_PRICE_RATE_LABEL) {
		 COMP_FPD_UNIT_PRICE_RATE_LABEL = cOMP_FPD_UNIT_PRICE_RATE_LABEL;
	 }

	 public HtmlInputText getCOMP_FPD_UNIT_PRICE_RATE() {
		 return COMP_FPD_UNIT_PRICE_RATE;
	 }

	 public void setCOMP_FPD_UNIT_PRICE_RATE(HtmlInputText cOMP_FPD_UNIT_PRICE_RATE) {
		 COMP_FPD_UNIT_PRICE_RATE = cOMP_FPD_UNIT_PRICE_RATE;
	 }

	 public void validateFPD_UNIT_PRICE_RATE(FacesContext facesContext,
			 UIComponent component, Object value) throws ValidatorException {
		 CommonUtils.clearMaps(this);

		 try {
			 PM_IL_FUND_PRICE_DTL_BEAN.setFPD_UNIT_PRICE_RATE((Double) value);


		 } catch (Exception exception) {
			 exception.printStackTrace();
			 throw new ValidatorException(new FacesMessage(exception
					 .getMessage()));
		 } finally {
			 try {
				 ErrorHelpUtil.getWarningForProcedure(CommonUtils
						 .getConnection(), "FPD_UNIT_PRICE_RATE", getWarningMap());
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }

	/*End*/
	
}

//}


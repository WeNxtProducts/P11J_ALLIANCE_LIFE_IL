package com.iii.pel.forms.PILT018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.VembuExceptionConstants;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PT_IL_BROK_ADV_DTL_ACTION extends CommonAction{
	
	
	private HtmlOutputLabel COMP_BAD_DUE_DT_LABEL;

	private HtmlCalendar COMP_BAD_DUE_DT;

	private HtmlOutputLabel COMP_BAD_REMARKS_LABEL;

	private HtmlInputText COMP_BAD_REMARKS;

	private HtmlOutputLabel COMP_BAD_FC_AMT_LABEL;

	private HtmlInputText COMP_BAD_FC_AMT;

	private HtmlOutputLabel COMP_BAD_LC_AMT_LABEL;

	private HtmlInputText COMP_BAD_LC_AMT;

	private HtmlOutputLabel COMP_BAD_TXN_CODE_LABEL;

	private HtmlInputText COMP_BAD_TXN_CODE;

	private HtmlOutputLabel COMP_BAD_PAID_DT_LABEL;

	private HtmlCalendar COMP_BAD_PAID_DT;

	private HtmlOutputLabel COMP_BAD_FC_COMM_AMT_LABEL;

	private HtmlInputText COMP_BAD_FC_COMM_AMT;

	private HtmlOutputLabel COMP_BAD_DOC_NO_LABEL;

	private HtmlInputText COMP_BAD_DOC_NO;

	private HtmlOutputLabel COMP_BAD_LC_COMM_AMT_LABEL;

	private HtmlInputText COMP_BAD_LC_COMM_AMT;

	private HtmlOutputLabel COMP_BAD_DOC_DT_LABEL;

	private HtmlCalendar COMP_BAD_DOC_DT;

	private HtmlOutputLabel COMP_BAD_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_BAD_STATUS;
	
	private HtmlCommandButton COMP_UI_M_BUT_APPOVE_DTL;

	private PT_IL_BROK_ADV_DTL PT_IL_BROK_ADV_DTL_BEAN;
	private HtmlCommandButton test;
	
	private String filterByBAD_FC_AMT;
	
	private String filterByBAD_LC_AMT;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	private UIData dataTable;
	private int currPage;
	private int recordsPerPage = 5;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	public CompositeAction compositeAction;
	private boolean compApproveDisabled;
	ArrayList<PT_IL_BROK_ADV_DTL> beanList = new ArrayList<PT_IL_BROK_ADV_DTL>();
	
	

	public ArrayList<PT_IL_BROK_ADV_DTL> getBeanList() {
		return beanList;
	}

	public void setBeanList(ArrayList<PT_IL_BROK_ADV_DTL> beanList) {
		this.beanList = beanList;
	}
	
	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}
	
	public PT_IL_BROK_ADV_DTL_ACTION() {
		PT_IL_BROK_ADV_DTL_BEAN = new PT_IL_BROK_ADV_DTL();
		instantiateAllComponent();
		
	}

	public HtmlOutputLabel getCOMP_BAD_DUE_DT_LABEL() {
		return COMP_BAD_DUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAD_DUE_DT() {
		return COMP_BAD_DUE_DT;
	}

	public void setCOMP_BAD_DUE_DT_LABEL(HtmlOutputLabel COMP_BAD_DUE_DT_LABEL) {
		this.COMP_BAD_DUE_DT_LABEL = COMP_BAD_DUE_DT_LABEL;
	}

	public void setCOMP_BAD_DUE_DT(HtmlCalendar COMP_BAD_DUE_DT) {
		this.COMP_BAD_DUE_DT = COMP_BAD_DUE_DT;
	}

	public HtmlOutputLabel getCOMP_BAD_REMARKS_LABEL() {
		return COMP_BAD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_BAD_REMARKS() {
		return COMP_BAD_REMARKS;
	}

	public void setCOMP_BAD_REMARKS_LABEL(HtmlOutputLabel COMP_BAD_REMARKS_LABEL) {
		this.COMP_BAD_REMARKS_LABEL = COMP_BAD_REMARKS_LABEL;
	}

	public void setCOMP_BAD_REMARKS(HtmlInputText COMP_BAD_REMARKS) {
		this.COMP_BAD_REMARKS = COMP_BAD_REMARKS;
	}

	public HtmlOutputLabel getCOMP_BAD_FC_AMT_LABEL() {
		return COMP_BAD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAD_FC_AMT() {
		return COMP_BAD_FC_AMT;
	}

	public void setCOMP_BAD_FC_AMT_LABEL(HtmlOutputLabel COMP_BAD_FC_AMT_LABEL) {
		this.COMP_BAD_FC_AMT_LABEL = COMP_BAD_FC_AMT_LABEL;
	}

	public void setCOMP_BAD_FC_AMT(HtmlInputText COMP_BAD_FC_AMT) {
		this.COMP_BAD_FC_AMT = COMP_BAD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_BAD_LC_AMT_LABEL() {
		return COMP_BAD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAD_LC_AMT() {
		return COMP_BAD_LC_AMT;
	}

	public void setCOMP_BAD_LC_AMT_LABEL(HtmlOutputLabel COMP_BAD_LC_AMT_LABEL) {
		this.COMP_BAD_LC_AMT_LABEL = COMP_BAD_LC_AMT_LABEL;
	}

	public void setCOMP_BAD_LC_AMT(HtmlInputText COMP_BAD_LC_AMT) {
		this.COMP_BAD_LC_AMT = COMP_BAD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_BAD_TXN_CODE_LABEL() {
		return COMP_BAD_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAD_TXN_CODE() {
		return COMP_BAD_TXN_CODE;
	}

	public void setCOMP_BAD_TXN_CODE_LABEL(HtmlOutputLabel COMP_BAD_TXN_CODE_LABEL) {
		this.COMP_BAD_TXN_CODE_LABEL = COMP_BAD_TXN_CODE_LABEL;
	}

	public void setCOMP_BAD_TXN_CODE(HtmlInputText COMP_BAD_TXN_CODE) {
		this.COMP_BAD_TXN_CODE = COMP_BAD_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_BAD_PAID_DT_LABEL() {
		return COMP_BAD_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAD_PAID_DT() {
		return COMP_BAD_PAID_DT;
	}

	public void setCOMP_BAD_PAID_DT_LABEL(HtmlOutputLabel COMP_BAD_PAID_DT_LABEL) {
		this.COMP_BAD_PAID_DT_LABEL = COMP_BAD_PAID_DT_LABEL;
	}

	public void setCOMP_BAD_PAID_DT(HtmlCalendar COMP_BAD_PAID_DT) {
		this.COMP_BAD_PAID_DT = COMP_BAD_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_BAD_FC_COMM_AMT_LABEL() {
		return COMP_BAD_FC_COMM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAD_FC_COMM_AMT() {
		return COMP_BAD_FC_COMM_AMT;
	}

	public void setCOMP_BAD_FC_COMM_AMT_LABEL(HtmlOutputLabel COMP_BAD_FC_COMM_AMT_LABEL) {
		this.COMP_BAD_FC_COMM_AMT_LABEL = COMP_BAD_FC_COMM_AMT_LABEL;
	}

	public void setCOMP_BAD_FC_COMM_AMT(HtmlInputText COMP_BAD_FC_COMM_AMT) {
		this.COMP_BAD_FC_COMM_AMT = COMP_BAD_FC_COMM_AMT;
	}

	public HtmlOutputLabel getCOMP_BAD_DOC_NO_LABEL() {
		return COMP_BAD_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_BAD_DOC_NO() {
		return COMP_BAD_DOC_NO;
	}

	public void setCOMP_BAD_DOC_NO_LABEL(HtmlOutputLabel COMP_BAD_DOC_NO_LABEL) {
		this.COMP_BAD_DOC_NO_LABEL = COMP_BAD_DOC_NO_LABEL;
	}

	public void setCOMP_BAD_DOC_NO(HtmlInputText COMP_BAD_DOC_NO) {
		this.COMP_BAD_DOC_NO = COMP_BAD_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_BAD_LC_COMM_AMT_LABEL() {
		return COMP_BAD_LC_COMM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BAD_LC_COMM_AMT() {
		return COMP_BAD_LC_COMM_AMT;
	}

	public void setCOMP_BAD_LC_COMM_AMT_LABEL(HtmlOutputLabel COMP_BAD_LC_COMM_AMT_LABEL) {
		this.COMP_BAD_LC_COMM_AMT_LABEL = COMP_BAD_LC_COMM_AMT_LABEL;
	}

	public void setCOMP_BAD_LC_COMM_AMT(HtmlInputText COMP_BAD_LC_COMM_AMT) {
		this.COMP_BAD_LC_COMM_AMT = COMP_BAD_LC_COMM_AMT;
	}

	public HtmlOutputLabel getCOMP_BAD_DOC_DT_LABEL() {
		return COMP_BAD_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BAD_DOC_DT() {
		return COMP_BAD_DOC_DT;
	}

	public void setCOMP_BAD_DOC_DT_LABEL(HtmlOutputLabel COMP_BAD_DOC_DT_LABEL) {
		this.COMP_BAD_DOC_DT_LABEL = COMP_BAD_DOC_DT_LABEL;
	}

	public void setCOMP_BAD_DOC_DT(HtmlCalendar COMP_BAD_DOC_DT) {
		this.COMP_BAD_DOC_DT = COMP_BAD_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_BAD_STATUS_LABEL() {
		return COMP_BAD_STATUS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAD_STATUS() {
		return COMP_BAD_STATUS;
	}

	public void setCOMP_BAD_STATUS_LABEL(HtmlOutputLabel COMP_BAD_STATUS_LABEL) {
		this.COMP_BAD_STATUS_LABEL = COMP_BAD_STATUS_LABEL;
	}

	public void setCOMP_BAD_STATUS(HtmlSelectOneMenu COMP_BAD_STATUS) {
		this.COMP_BAD_STATUS = COMP_BAD_STATUS;
	}

	public PT_IL_BROK_ADV_DTL getPT_IL_BROK_ADV_DTL_BEAN() {
		return PT_IL_BROK_ADV_DTL_BEAN;
	}

	public void setPT_IL_BROK_ADV_DTL_BEAN(PT_IL_BROK_ADV_DTL PT_IL_BROK_ADV_DTL_BEAN) {
		this.PT_IL_BROK_ADV_DTL_BEAN = PT_IL_BROK_ADV_DTL_BEAN;
	}
	 CRUDHandler handler = new CRUDHandler();
	
private List<SelectItem> SELECT_BAD_STATUS_LIST = new ArrayList<SelectItem>() ;
	
	
	public List<SelectItem> getSELECT_BAD_STATUS_LIST() throws Exception {		
		  if (SELECT_BAD_STATUS_LIST.size() ==0){ 
			  SELECT_BAD_STATUS_LIST.clear();
			  Connection conn = getConnection();
			  SELECT_BAD_STATUS_LIST = ListItemUtil.getDropDownListValue(conn, "PILT018","PT_IL_BROK_ADV_DTL","PT_IL_BROK_ADV_DTL.BAD_STATUS", "YESNO");
			}
		return SELECT_BAD_STATUS_LIST;
	}

	public void setSELECT_BAD_STATUS_LIST(List<SelectItem> apat_code_list4) {
		SELECT_BAD_STATUS_LIST = apat_code_list4;
	}
	
	
	public Connection getConnection() throws Exception{
		Connection connection = CommonUtils.getConnection();
		return connection;
	}
	
	
	public void preForm(PhaseEvent ae)throws Exception{
		try {
			when_create_record();
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("preForm", e.getMessage());
		}
	}
	
	
	public void executeQuery(CompositeAction compositeAction) throws Exception{
		 CRUDHandler handler = new CRUDHandler();
		 ResultSet resultSet = null;
		 String selectQuery = "SELECT ROWID,PT_IL_BROK_ADV_DTL.* FROM PT_IL_BROK_ADV_DTL WHERE BAD_BAH_SYS_ID = ? AND ROWNUM < 61";
		try{
			Connection conn =getConnection();
			Object[] objects = {compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_SYS_ID()};
			resultSet = handler.executeSelectStatement(selectQuery, conn, objects);
			if(!beanList.isEmpty()){
				beanList.clear();
			}

			while(resultSet.next()){
				PT_IL_BROK_ADV_DTL PT_IL_BROK_ADV_DTL_BEAN = new PT_IL_BROK_ADV_DTL();
				PT_IL_BROK_ADV_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_SYS_ID(resultSet.getLong("BAD_SYS_ID"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_BAH_SYS_ID(resultSet.getLong("BAD_BAH_SYS_ID"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_DUE_DT(resultSet.getDate("BAD_DUE_DT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_PAID_DT(resultSet.getDate("BAD_PAID_DT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_AMT(resultSet.getDouble("BAD_FC_AMT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_AMT(resultSet.getDouble("BAD_LC_AMT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT(resultSet.getDouble("BAD_FC_COMM_AMT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT(resultSet.getDouble("BAD_LC_COMM_AMT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_STATUS(resultSet.getString("BAD_STATUS"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_REMARKS(resultSet.getString("BAD_REMARKS"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_DT(resultSet.getDate("BAD_CR_DT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_UID(resultSet.getString("BAD_CR_UID"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_DT(resultSet.getDate("BAD_UPD_DT"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_UID(resultSet.getString("BAD_UPD_UID"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_TXN_CODE(resultSet.getString("BAD_TXN_CODE"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_DOC_NO(resultSet.getDouble("BAD_DOC_NO"));
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_DOC_DT(resultSet.getDate("BAD_DOC_DT"));
				beanList.add(PT_IL_BROK_ADV_DTL_BEAN);
			}
			PT_IL_BROK_ADV_DTL PT_IL_BROK_ADV_DTL_BEAN = null;
			Iterator<PT_IL_BROK_ADV_DTL> it = beanList.iterator();
			while(it.hasNext()){
				PT_IL_BROK_ADV_DTL_BEAN = it.next();
				PT_IL_BROK_ADV_DTL_BEAN.setRowSelected(false);
			}
			if (beanList.size()>0){					
				this.setPT_IL_BROK_ADV_DTL_BEAN(beanList.get(0));
				this.getPT_IL_BROK_ADV_DTL_BEAN().setRowSelected(true);
			}
		}
		catch(Exception er){
			er.printStackTrace();
			throw new Exception(er.getMessage());
		}
	}
			
		


	public UIData getDataTable() {
		return dataTable;
	}
	
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	
	public void bad_due_dt_setting(ActionEvent event) {
		String date = getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex();
	}
		
	/**
	 * 
	 * @param fc
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 * @throws SQLException
	 * @throws Exception
	 */
	 public void bad_due_dt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		 try {
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_DUE_DT((Date) value);
			if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_DUE_DT() != null && PT_IL_BROK_ADV_DTL_BEAN.getBAD_DUE_DT().before(
				compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_PYMT_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91230"));
			}
		 } catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	 
	 
	 public void bad_fc_amt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		 PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_AMT((Double)value);
		 ArrayList<OracleParameter> list = null;
		 try{
			 if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT() <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014", new Object[] { "Repayment FC Amount","Greater than Zero" }));
			}
			 
		  list =P_VAL_ROUND_AMT(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CURR_CODE(),PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT(), "V");
		  if (list.size() != 0  && !(list.isEmpty())) {
			  PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_AMT((Double)list.get(0).getValueObject());
		  }
		  PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_AMT(CommonUtils.nvl(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT(),0)* CommonUtils.nvl(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(),0));
		  list.clear();
		  P_VAL_FC_LC_TOLERANCE(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT(), PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT(),compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(), "E");
		  COMP_BAD_LC_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
		  COMP_BAD_LC_AMT.resetValue();
		 }catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 } 
	 }
			    		
	 public void bad_lc_amt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		
		 PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_AMT((Double)value);
		 ArrayList<OracleParameter> list = null;
		 try{
			 if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT() <= 0) {
				 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014", new Object[] { "Repayment FC Amount","Greater than Zero" }));
			 }
			 list =P_VAL_ROUND_AMT(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CURR_CODE(),PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT(), "R");
			 if (list.size() != 0  && !(list.isEmpty())) {
				 PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_AMT((Double)list.get(0).getValueObject());
			 }
			 list.clear();
			 P_VAL_FC_LC_TOLERANCE(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT(), PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT(),compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(), "E");
			 COMP_BAD_LC_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
			 COMP_BAD_LC_AMT.resetValue();
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	}
	 
	 
	 public void bad_paid_dt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		 try {
			 PT_IL_BROK_ADV_DTL_BEAN.setBAD_PAID_DT((Date) value);
			 if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_PAID_DT() != null && PT_IL_BROK_ADV_DTL_BEAN.getBAD_PAID_DT().after(new CommonUtils().getCurrentDate())) {
				 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Amount Paid Date","Not Null and Less than or Equal to System Date"}));
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }
	 }

		
	 
	 public void bad_fc_comm_amt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		 PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT((Double)value);
		 ArrayList<OracleParameter> list = null;
		 try{
			 if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT() <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014", new Object[] { "Repayment FC Amount","Greater than Zero" }));
			}
			 
		  list =P_VAL_ROUND_AMT(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CURR_CODE(),PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT(), "V");
		  if (list.size() != 0  && !(list.isEmpty())) {
			  PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT((Double)list.get(0).getValueObject());
		  }
		  PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT(CommonUtils.nvl(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT(),0)* CommonUtils.nvl(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(),0));
		  list.clear();
		  P_VAL_FC_LC_TOLERANCE(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT(), PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_COMM_AMT(),compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(), "E");
		  COMP_BAD_FC_COMM_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_COMM_AMT());
		  COMP_BAD_FC_COMM_AMT.resetValue();
		 }catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 } 
	    }
	 
	  
	 public void bad_lc_comm_amt_when_validate_item(FacesContext fc, UIComponent component,Object value){
		 	Connection conn = null;
		 	PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT((Double)value);
		 	ArrayList<OracleParameter> list = null;
		 	try{
		 		if(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_COMM_AMT() <= 0){
		 			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Repayment Commission LC Amount","Greater than Zero"}));
		 		}

		 		list  = P_VAL_ROUND_AMT(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CURR_CODE(),PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_COMM_AMT(), "V");
		 		if (list != null  && !(list.isEmpty()) ) {
					PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT((Double)list.get(0).getValueObject());
				}
		 		
		 		P_VAL_FC_LC_TOLERANCE(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT(), 
		 							  PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_COMM_AMT(),
		 							  compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_EXCH_RATE(),"E");
		        		           
	      
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	 
	 /**
	  * 
	  * 
	  */
	 public void bad_status_validator(FacesContext fc, UIComponent component,Object value){
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_STATUS((String)value);
		try {
			if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_PAID_DT() == null) {
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_PAID_DT(new CommonUtils().getCurrentDate());
				getCOMP_BAD_PAID_DT().resetValue();
			}
			if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT() != PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT()) {
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT());
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
				COMP_BAD_FC_COMM_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT());
				COMP_BAD_LC_COMM_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
				COMP_BAD_FC_COMM_AMT.resetValue();
				COMP_BAD_LC_COMM_AMT.resetValue();
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	 
	 public void bad_status_when_list_changed(ActionEvent event){
		String value = getCurrentValue(event);
		if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_PAID_DT() == null) {
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_PAID_DT(new Date());
			getCOMP_BAD_PAID_DT().resetValue();
		}
		if (PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT() != PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_COMM_AMT()) {
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT());
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
			COMP_BAD_FC_COMM_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_FC_AMT());
			COMP_BAD_LC_COMM_AMT.setSubmittedValue(PT_IL_BROK_ADV_DTL_BEAN.getBAD_LC_AMT());
			COMP_BAD_FC_COMM_AMT.resetValue();
			COMP_BAD_LC_COMM_AMT.resetValue();
		}
	}

	 public void pre_insert() throws Exception{
	        Long sys_id=null;
	        ResultSet vembu_C1=null;
	        try{
	            String sql_C1="SELECT PIL_BAD_SYS_ID.NEXTVAL FROM  DUAL  ";
	            vembu_C1 = new CRUDHandler().executeSelectStatement(sql_C1, CommonUtils.getConnection());
	            if(vembu_C1.next()){
	            	sys_id=vembu_C1.getLong(1);
	            }
	           PT_IL_BROK_ADV_DTL_BEAN.setBAD_SYS_ID(sys_id);
	           PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_UID(CommonUtils.getControlBean().getM_USER_ID()); 
	           PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_DT(new CommonUtils().getCurrentDate());
	        }catch(Exception e){
	            e.printStackTrace();
	           throw new Exception(e.getMessage());
	        }finally{CommonUtils.closeCursor(vembu_C1);}
	 }
	       
	 
	 public void pre_update(PT_IL_BROK_ADV_DTL divnBean) throws Exception{
		 try {
			 PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID()); 
			 PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_DT(new CommonUtils().getCurrentDate());
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
		}
	 }
	    	

	 public void when_create_record() throws Exception {
	        try{
	        	PT_IL_BROK_ADV_DTL_BEAN.setBAD_STATUS("N");
	            PT_IL_BROK_ADV_DTL_BEAN.setBAD_FC_COMM_AMT(0.0);
	            PT_IL_BROK_ADV_DTL_BEAN.setBAD_LC_COMM_AMT(0.0);
	        }catch(Exception e){
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }
	    }
	 
	 public void when_PressSave_Button(){
		String message = null;
		 try{
			 CommonUtils.getConnection().commit();
			 message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
			 getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			 getWarningMap().put("Save", message);
		 }catch(Exception e){
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			 getErrorMap().put("Save", e.getMessage());

		 }
	 }
	 
	 
	 public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String message = null; 
		 try {
			 if (isINSERT_ALLOWED()) {
				 PT_IL_BROK_ADV_DTL_BEAN = new PT_IL_BROK_ADV_DTL();
				 resetAllComponent();
				 resetSelectedRow();
			 } else {
				 message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed");
				 getErrorMap().put("addRow",message);
				 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			 }
		 } catch (Exception exc) {
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			 getErrorMap().put("addRow", exc.getMessage());
		 }
	 }



		public void deleteRow(ActionEvent event) {
			CommonUtils.clearMaps(this);
			String message = null;
			try {
				if (isDELETE_ALLOWED()) {
					new CRUDHandler().executeDelete(PT_IL_BROK_ADV_DTL_BEAN,CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					message =Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete") ; 
					getWarningMap().put("deleteRow",message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
					beanList.remove(PT_IL_BROK_ADV_DTL_BEAN);
					if (beanList.size() > 0) {
						PT_IL_BROK_ADV_DTL_BEAN = beanList.get(0);
					} else if (beanList.size() == 0) {
						addRow(null);
					}
					resetAllComponent();
					PT_IL_BROK_ADV_DTL_BEAN.setRowSelected(true);
				} else {
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
					getErrorMap().put("deleteRow",message);
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				}
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("deleteRow", exc.getMessage());
			}
		}

		public void postRecord(ActionEvent event) {
			CommonUtils.clearMaps(this);
			String message = null;
			try {
				if (PT_IL_BROK_ADV_DTL_BEAN.getROWID() == null) {
					if (isINSERT_ALLOWED()) {
						preInsert(compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN());
						new CRUDHandler().executeInsert(PT_IL_BROK_ADV_DTL_BEAN,CommonUtils.getConnection());
						message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
						getWarningMap().put("postRecord",message);
						beanList.add(PT_IL_BROK_ADV_DTL_BEAN);
					} else {
						throw new Exception(Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
					}
				} else if (PT_IL_BROK_ADV_DTL_BEAN.getROWID() != null) {
					if (isUPDATE_ALLOWED()) {
						new CRUDHandler().executeUpdate(PT_IL_BROK_ADV_DTL_BEAN,CommonUtils.getConnection());
						message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$Grid$update");
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
						getWarningMap().put("postRecord",message);
					} else {
						throw new Exception(Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$updatenotallowed"));
					}
				}
				PT_IL_BROK_ADV_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("postRecord",exc.getMessage());
		}
	}
	 
	 public void when_new_record_instance(CompositeAction compositeAction){
	        
		 if("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_BROK_ADV_DTL_BEAN.getBAD_RECOVER_FLAG(), "N"))){
			 disableAllComponent(false);
		 }else{
			 disableAllComponent(false);
		 }
	      
	    }

	 public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}
	
	public void bad_doc_dt_when_validate_item(FacesContext fc,UIComponent component, Object value){
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_DOC_DT((Date) value);
	}
		
		 
	
	
	
	public void preInsert(PT_IL_BROK_ADV_HDR PT_IL_BROK_ADV_HDR_BEAN) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 = "SELECT PIL_BAD_SYS_ID.NEXTVAL  FROM DUAL";
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if(resultSet.next()){
				PT_IL_BROK_ADV_DTL_BEAN.setBAD_SYS_ID(resultSet.getLong(1));
			}
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_BAH_SYS_ID(PT_IL_BROK_ADV_HDR_BEAN.getBAH_SYS_ID());
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_DT(new Date());
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			
		}catch(Exception exception){
			throw exception;
		}
	}
	
	private void preUpdate() throws Exception{
		try{
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_BROK_ADV_DTL_BEAN.setBAD_UPD_UID(CommonUtils.getControlBean().getM_USER_DISP());
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void bad_remarks_when_validate_item(FacesContext fc,UIComponent component, Object value) {
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_REMARKS((String) value);
	}
	
	public void bad_txn_code_when_validate_item(FacesContext fc,UIComponent component, Object value){
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_TXN_CODE((String)value);
	}
	
	public void bad_doc_no_when_validate_item(FacesContext fc,UIComponent component, Object value){
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_DOC_NO((Double)value);
	}
	
	public void bad_doc_date_when_validate_item(FacesContext fc,UIComponent component, Object value) {
		PT_IL_BROK_ADV_DTL_BEAN.setBAD_DOC_DT((Date)value);
	}
	
	
	public void onLoad(PhaseEvent e) {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				executeQuery(compositeAction);
				if (PT_IL_BROK_ADV_DTL_BEAN.getROWID() != null) {
					//postQuery(PT_IL_BROK_ADV_HDR_BEAN);
				} else {
					when_create_record();
				}
				when_new_record_instance(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,ex.getMessage());
			getErrorMap().put("onLoad", ex.getMessage());
		}
	}
	
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			String message ="";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String approveButtonPressed(){
		Connection connection = null;
		try {
			Long SYSID = compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().getBAH_SYS_ID();
			BROK_REPAY_APPROVE(SYSID);
			CommonUtils.getConnection().commit();
			for(PT_IL_BROK_ADV_DTL tempBean : beanList ){
				if ("Y".equals(tempBean.getBAD_STATUS())) {
					tempBean.setStatusDisble(true);
					tempBean.setRemarksDisble(true);
				}else{
					tempBean.setStatusDisble(false);
					tempBean.setRemarksDisble(false);
				}
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath,"91071"));
			getWarningMap().put("Approve",Messages.getString(PELConstants.pelErrorMessagePath,"91071"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("Approve",e.getMessage());
		} 
		return "";
	}

	
	public HtmlCommandButton getCOMP_UI_M_BUT_APPOVE_DTL() {
		return COMP_UI_M_BUT_APPOVE_DTL;
	}

	public void setCOMP_UI_M_BUT_APPOVE_DTL(
			HtmlCommandButton comp_ui_m_but_appove_dtl) {
		COMP_UI_M_BUT_APPOVE_DTL = comp_ui_m_but_appove_dtl;
	}

	public boolean isCompApproveDisabled() {
		return compApproveDisabled;
	}

	public void setCompApproveDisabled(boolean compApproveDisabled) {
		this.compApproveDisabled = compApproveDisabled;
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_BROK_ADV_DTL_BEAN = (PT_IL_BROK_ADV_DTL) dataTable.getRowData();
			PT_IL_BROK_ADV_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	
	private void resetSelectedRow() {
		Iterator<PT_IL_BROK_ADV_DTL> iterator = beanList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_BAD_DUE_DT.resetValue();
		COMP_BAD_FC_AMT.resetValue();
		COMP_BAD_LC_AMT.resetValue();
		COMP_BAD_PAID_DT.resetValue();
		COMP_BAD_FC_COMM_AMT.resetValue();
		COMP_BAD_LC_COMM_AMT.resetValue();
		COMP_BAD_STATUS.resetValue();
		COMP_BAD_REMARKS.resetValue();
		COMP_BAD_TXN_CODE.resetValue();
		COMP_BAD_DOC_NO.resetValue();
		COMP_BAD_DOC_DT.resetValue();
		
	}

	public String getFilterByBAD_FC_AMT() {
		return filterByBAD_FC_AMT;
	}

	
	public void setFilterByBAD_FC_AMT(String filterByBAD_FC_AMT) {
		this.filterByBAD_FC_AMT = filterByBAD_FC_AMT;
	}

	public String getFilterByBAD_LC_AMT() {
		return filterByBAD_LC_AMT;
	}

	public void setFilterByBAD_LC_AMT(String filterByBAD_LC_AMT) {
		this.filterByBAD_LC_AMT = filterByBAD_LC_AMT;
	}

	
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}
 
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

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

	
	public CompositeAction getCompositeAction() {
		return compositeAction;
	}

	
	public void setCompositeAction(CompositeAction compositeAction) {
		this.compositeAction = compositeAction;
	}
	

	
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_BAD_REMARKS				 = new HtmlInputText();
		COMP_BAD_FC_AMT					 = new HtmlInputText();
		COMP_BAD_LC_AMT					 = new HtmlInputText();
		COMP_BAD_TXN_CODE				 = new HtmlInputText();
		COMP_BAD_FC_COMM_AMT				 = new HtmlInputText();
		COMP_BAD_DOC_NO					 = new HtmlInputText();
		COMP_BAD_LC_COMM_AMT				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_BAD_STATUS					 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_BAD_DUE_DT					 = new HtmlCalendar();
		COMP_BAD_PAID_DT				 = new HtmlCalendar();
		COMP_BAD_DOC_DT					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_APPOVE_DTL			 = new HtmlCommandButton();
		test						 = new HtmlCommandButton();

	}


	/**
	 * Disables all components in PT_IL_BROK_ADV_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_BAD_REMARKS.setDisabled(disabled);
		COMP_BAD_FC_AMT.setDisabled(disabled);
		COMP_BAD_LC_AMT.setDisabled(disabled);
		COMP_BAD_TXN_CODE.setDisabled(disabled);
		COMP_BAD_FC_COMM_AMT.setDisabled(disabled);
		COMP_BAD_DOC_NO.setDisabled(disabled);
		COMP_BAD_LC_COMM_AMT.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_BAD_STATUS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_BAD_DUE_DT.setDisabled(disabled);
		COMP_BAD_PAID_DT.setDisabled(disabled);
		COMP_BAD_DOC_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_APPOVE_DTL.setDisabled(disabled);
		test.setDisabled(disabled);

	}
	
	
    /**
    *
    * @param P_CURR_CODE-IN
    * @param P_AMT-IN OUT
    * @param P_VAL_ROUND-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_VAL_ROUND_AMT(
                    Object P_CURR_CODE,
         Object P_AMT,
         Object P_VAL_ROUND) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_AMT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VAL_ROUND);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P_VAL_ROUND_AMT");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

  
  
  /**
  *
  * @param P_FC_VAL-IN
  * @param P_LC_VAL-IN
  * @param P_EXGE_RATE-IN
  * @param P_ERR_FLAG-IN
  *
  * @return ArrayList of type Oracle Parameter
  * @throws Exception
  */
public ArrayList<OracleParameter> P_VAL_FC_LC_TOLERANCE(
                  Object P_FC_VAL,
       Object P_LC_VAL,
       Object P_EXGE_RATE,
       Object P_ERR_FLAG) throws ProcedureException {
     Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_VAL);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_VAL);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_EXGE_RATE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
        parameterList.add(param4);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.executeProc(parameterList, connection,
               "P_VAL_FC_LC_TOLERANCE");
     } catch(Exception e) {
     	ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
     }
    return outputList;
}



/**
*
* @param P_BAD_BAH_SYS_ID-IN
*
* @return ArrayList of type Oracle Parameter
* @throws Exception
*/
public ArrayList<OracleParameter> BROK_REPAY_APPROVE(
                Object P_BAD_BAH_SYS_ID) throws ProcedureException {
   Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_BAD_BAH_SYS_ID);
      parameterList.add(param1);

     OracleProcedureHandler procHandler = new OracleProcedureHandler();
      outputList = procHandler.executeProc(parameterList, connection,
             "P9ILPK_BROKER_ADVANCE_PYMT.BROK_REPAY_APPROVE");
   } catch(Exception e) {
   	ErrorHelpUtil.getErrorForProcedure(connection);
          throw new ProcedureException(e.getMessage());
   }
  return outputList;
}


}

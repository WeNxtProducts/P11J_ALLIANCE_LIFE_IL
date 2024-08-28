package com.iii.pel.forms.PILP014;

import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP091_APAC.PILP091_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILP091_APAC.PS_IL_CONT_PAID_HDR;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class CTRL1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BD_BM_SLNO_LABEL;

	private HtmlInputText COMP_BD_BM_SLNO;
	
	private HtmlOutputLabel COMP_BD_BM_EXEC_SEQ_LABEL;
	
	private HtmlOutputLabel COMP_GROUP_ID_LABEL;
	
	private HtmlSelectOneMenu COMP_GROUP_ID;

	private HtmlInputText COMP_BD_BM_EXEC_SEQ;
	
	private HtmlOutputLabel COMP_UI_M_BD_PROC_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BD_PROC_DESC;
	
	private HtmlOutputLabel COMP_BD_BM_PROC_CALL_LABEL;

	private HtmlInputText COMP_BD_BM_PROC_CALL;
	
	private HtmlOutputLabel COMP_BD_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_BD_STATUS;
	
	private HtmlCommandButton COMP_BUTTON_FETCH;
	
	private HtmlCommandButton COMP_BUTTON_PROCESS;
	
	private HtmlCommandButton COMP_BUTTON_VIEW_LOG;
	
	private HtmlCommandButton COMP_BUTTON_CLEAR;
	
	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private CTRL1 CTRL1_BEAN;
	
	private UIData dataTable;
	
	private boolean processFlag;
	
	private List<CTRL1> dataList_CTRL1 = new ArrayList<CTRL1>();
	
	private List<SelectItem> listBD_STATUS = new ArrayList<SelectItem>();
	
	private List<SelectItem> listGROUP_ID = new ArrayList<SelectItem>();
	
	public CTRL1_ACTION() {
		CTRL1_BEAN = new CTRL1();
		prepareDropDownList();
	}

	public CTRL1 getCTRL1_BEAN() {
		return CTRL1_BEAN;
	}

	public void setCTRL1_BEAN(CTRL1 ctrl1_bean) {
		CTRL1_BEAN = ctrl1_bean;
	}

	

	public HtmlCommandButton getCOMP_BUTTON_FETCH() {
		return COMP_BUTTON_FETCH;
	}

	public void setCOMP_BUTTON_FETCH(HtmlCommandButton comp_button_fetch) {
		COMP_BUTTON_FETCH = comp_button_fetch;
	}

	public HtmlCommandButton getCOMP_BUTTON_PROCESS() {
		return COMP_BUTTON_PROCESS;
	}

	public void setCOMP_BUTTON_PROCESS(HtmlCommandButton comp_button_process) {
		COMP_BUTTON_PROCESS = comp_button_process;
	}

	public HtmlCommandButton getCOMP_BUTTON_VIEW_LOG() {
		return COMP_BUTTON_VIEW_LOG;
	}

	public void setCOMP_BUTTON_VIEW_LOG(HtmlCommandButton comp_button_view_log) {
		COMP_BUTTON_VIEW_LOG = comp_button_view_log;
	}

	public void clearMap(){
		getErrorMap().clear();
		getWarningMap().clear();
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				when_new_record_instance();
				setBlockFlag(false);
			}
			if(processFlag){
				/*Commented by pidugu raj dt: 02-12-2020 as suggested by kuzhandaivel for Month-End Processing
				 * COMP_BUTTON_PROCESS.setDisabled(true);*/
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}

	}
	
	public void when_new_record_instance(){
		try{
		CTRL1_BEAN.setUI_M_PROCESS_DT(new CommonUtils().getCurrentDate());
		processFlag= false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void fetchButtonAction()throws Exception{
	
	String selectStatement = "SELECT ROWID, PP_BATCH_DTLS.* FROM PP_BATCH_DTLS WHERE BD_BH_SYS_ID = ?  " ;
	String DescQuery = "SELECT BM_PROC_DESC FROM PM_BATCH_MASTER WHERE BM_SLNO= ? ";
	String currentDtls ="SELECT BH_SYS_ID FROM PP_BATCH_HDR WHERE BH_RUNDATE = ? AND BH_GROUP_ID = ?";
	String checkInsert = "SELECT 'X' FROM PP_BATCH_HDR WHERE BH_RUNDATE = ? AND BH_GROUP_ID = ?";
	String ProcessDisable = "SELECT BH_SYS_ID FROM PP_BATCH_HDR WHERE BH_RUNDATE = ? AND BH_GROUP_ID = ? AND BH_STATUS ='C'";
	Connection connection = null;
	ResultSet resultSet = null;
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	ResultSet resultSet4 = null;
	ResultSet resultSet5 = null;
	Integer BH_SYS_ID = 0;
	String value =null;
	getDataList_CTRL1().clear();
	try {
		clearMap();
		connection = CommonUtils.getConnection();
		CTRL1_HELPER helper = new  CTRL1_HELPER();
		resultSet4 = new CRUDHandler().executeSelectStatement(
				checkInsert, connection,new Object[]{CTRL1_BEAN.getUI_M_PROCESS_DT(),CTRL1_BEAN.getUI_M_GROUP_ID()});
		if(resultSet4.next()){
			value = resultSet4.getString(1);
		}else{
			helper.EOD_FETCH((Date)CTRL1_BEAN.getUI_M_PROCESS_DT(), CTRL1_BEAN.getUI_M_GROUP_ID());
		}
		resultSet3 = new CRUDHandler().executeSelectStatement(
				currentDtls, connection,new Object[]{CTRL1_BEAN.getUI_M_PROCESS_DT(),CTRL1_BEAN.getUI_M_GROUP_ID()});
		if(resultSet3.next()){
			BH_SYS_ID = resultSet3.getInt(1);
		}
		resultSet = new CRUDHandler().executeSelectStatement(
				selectStatement, connection,new Object[]{BH_SYS_ID});
		while (resultSet.next()) {
			CTRL1 CTRL1_BEAN = new CTRL1();
			CTRL1_BEAN.setROWID(resultSet.getString("ROWID"));
			CTRL1_BEAN.setBD_SYS_ID(resultSet.getInt("BD_SYS_ID"));
			CTRL1_BEAN.setBD_BM_SL_NO(resultSet.getInt("BD_BM_SL_NO"));
			CTRL1_BEAN.setBD_BM_EXEC_SEQ(resultSet.getInt("BD_BM_EXEC_SEQ"));
			resultSet2 = new CRUDHandler().executeSelectStatement(
					DescQuery, connection,new Object[]{CTRL1_BEAN.getBD_BM_SL_NO()});
			if(resultSet2.next()){
				CTRL1_BEAN.setUI_M_BD_PROC_DESC(resultSet2.getString(1));
			}
			CTRL1_BEAN.setBD_STATUS(resultSet.getString("BD_STATUS"));
			getDataList_CTRL1().add(
					CTRL1_BEAN);
		}
		resultSet5=new CRUDHandler().executeSelectStatement(ProcessDisable, connection,new Object[]{CTRL1_BEAN.getUI_M_PROCESS_DT(),CTRL1_BEAN.getUI_M_GROUP_ID()});
		if(resultSet5.next()){
			/*Commented by pidugu raj dt: 02-12-2020 as suggested by kuzhandaivel for Month-End Processing
			COMP_BUTTON_PROCESS.setDisabled(true);
			COMP_BD_BM_EXEC_SEQ.setDisabled(true);
			COMP_BD_STATUS.setDisabled(true);
			 * End
			 */
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void clearButtonAction()throws Exception{
		try{
			clearMap();
			Connection connection = CommonUtils.getConnection();
			String deleteQuery = "DELETE FROM PP_BATCH_STATUS WHERE BE_CR_DT BETWEEN ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1) AND LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1))";
			new CRUDHandler().executeDeleteStatement(deleteQuery, connection);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Last Month Datas are Deleted");
			getWarningMap().put("Process", "Last Month Datas are Deleted");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void processButtonAction()throws Exception{
		String Query = "SELECT BH_SYS_ID FROM PP_BATCH_HDR WHERE BH_RUNDATE = ? ";
		Integer sysId = 0;
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			clearMap();
			connection = CommonUtils.getConnection();
			CTRL1_HELPER helper = new  CTRL1_HELPER();
			resultSet = new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{CTRL1_BEAN.getUI_M_PROCESS_DT()});
			if(resultSet.next()){
				sysId = resultSet.getInt(1);
			}
			helper.PROCESS_BUTTON((Date)CTRL1_BEAN.getUI_M_PROCESS_DT(),sysId);
			processFlag = true;
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Successfully Completed");
			getWarningMap().put("Process", "Process Successfully Completed");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String backButton(){
		return "PILP014";
	}
	
	public void saveRecord(){
		try{
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void postRecord(ActionEvent event) {
		try {
			if (CTRL1_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(CTRL1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_CTRL1.add(CTRL1_BEAN);
				}
				else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (CTRL1_BEAN.getROWID() != null){
			   if(isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(CTRL1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
			   else{
				   throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
			   }

			   CTRL1_BEAN.setRowSelected(true);
		} 
		}catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			CTRL1_BEAN = (CTRL1) dataTable
					.getRowData();
			CTRL1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	public void validateExecSeq(FacesContext context, UIComponent component,
			Object value) throws ValidatorException{
		try{
			CTRL1_HELPER helper = new CTRL1_HELPER();
			if(!(value.equals(CTRL1_BEAN.getBD_BM_EXEC_SEQ()))){
				int val = (Integer)value;
				helper.validateSeq(val,CTRL1_BEAN.getBD_SYS_ID());
			}
		}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private void resetAllComponent() {
		COMP_BD_BM_SLNO.resetValue(); 
		COMP_BD_BM_EXEC_SEQ.resetValue();
		COMP_UI_M_BD_PROC_DESC.resetValue();
		COMP_BD_STATUS.resetValue();
	}
	
	private void resetSelectedRow() {
		Iterator<CTRL1> CTRL1_ITR = dataList_CTRL1
				.iterator();
		while (CTRL1_ITR.hasNext()) {
			CTRL1_ITR.next().setRowSelected(false);
		}
	}
	
	public String viewLog(){
		CommonUtils.setGlobalObject("BD_SYS_ID", CTRL1_BEAN.getBD_SYS_ID());
		return "PILP014_CTRL";
	}

	
	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}

	public List<CTRL1> getDataList_CTRL1() {
		return dataList_CTRL1;
	}

	public void setDataList_CTRL1(List<CTRL1> dataList_CTRL1) {
		this.dataList_CTRL1 = dataList_CTRL1;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void dateValidate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException{
		
		Date val = (Date)value;
		CTRL1_HELPER helper = new CTRL1_HELPER();
		try {
			/*Commented by pidugu raj dt: 02-12-2020 as suggested by kuzhandaivel for Month-End Processing
			helper.whenDateValidator(val);
			 * End
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<SelectItem> getListBD_STATUS() {
		if (listBD_STATUS.size() == 0) {
			listBD_STATUS.clear();
			try {
				listBD_STATUS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBD_STATUS;
	}

	private void prepareDropDownList() {

		try {
			setListBD_STATUS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP014",
					"DUMMY",
					"DUMMY.M_POL_CANCEL_PROCESS", "YESNO"));
			setListGROUP_ID(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP014",
					"CTRL1",
					"CTRL1.M_GROUP_ID", "M_GROUP_ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setListBD_STATUS(List<SelectItem> listBD_STATUS) {
		this.listBD_STATUS = listBD_STATUS;
	}

	public HtmlOutputLabel getCOMP_BD_BM_SLNO_LABEL() {
		return COMP_BD_BM_SLNO_LABEL;
	}

	public void setCOMP_BD_BM_SLNO_LABEL(HtmlOutputLabel comp_bd_bm_slno_label) {
		COMP_BD_BM_SLNO_LABEL = comp_bd_bm_slno_label;
	}

	public HtmlInputText getCOMP_BD_BM_SLNO() {
		return COMP_BD_BM_SLNO;
	}

	public void setCOMP_BD_BM_SLNO(HtmlInputText comp_bd_bm_slno) {
		COMP_BD_BM_SLNO = comp_bd_bm_slno;
	}

	public HtmlOutputLabel getCOMP_BD_BM_EXEC_SEQ_LABEL() {
		return COMP_BD_BM_EXEC_SEQ_LABEL;
	}

	public void setCOMP_BD_BM_EXEC_SEQ_LABEL(
			HtmlOutputLabel comp_bd_bm_exec_seq_label) {
		COMP_BD_BM_EXEC_SEQ_LABEL = comp_bd_bm_exec_seq_label;
	}

	public HtmlInputText getCOMP_BD_BM_EXEC_SEQ() {
		return COMP_BD_BM_EXEC_SEQ;
	}

	public void setCOMP_BD_BM_EXEC_SEQ(HtmlInputText comp_bd_bm_exec_seq) {
		COMP_BD_BM_EXEC_SEQ = comp_bd_bm_exec_seq;
	}

	public HtmlOutputLabel getCOMP_UI_M_BD_PROC_DESC_LABEL() {
		return COMP_UI_M_BD_PROC_DESC_LABEL;
	}

	public void setCOMP_UI_M_BD_PROC_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_bd_proc_desc_label) {
		COMP_UI_M_BD_PROC_DESC_LABEL = comp_ui_m_bd_proc_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_BD_PROC_DESC() {
		return COMP_UI_M_BD_PROC_DESC;
	}

	public void setCOMP_UI_M_BD_PROC_DESC(HtmlInputText comp_ui_m_bd_proc_desc) {
		COMP_UI_M_BD_PROC_DESC = comp_ui_m_bd_proc_desc;
	}

	public HtmlOutputLabel getCOMP_BD_BM_PROC_CALL_LABEL() {
		return COMP_BD_BM_PROC_CALL_LABEL;
	}

	public void setCOMP_BD_BM_PROC_CALL_LABEL(
			HtmlOutputLabel comp_bd_bm_proc_call_label) {
		COMP_BD_BM_PROC_CALL_LABEL = comp_bd_bm_proc_call_label;
	}

	public HtmlInputText getCOMP_BD_BM_PROC_CALL() {
		return COMP_BD_BM_PROC_CALL;
	}

	public void setCOMP_BD_BM_PROC_CALL(HtmlInputText comp_bd_bm_proc_call) {
		COMP_BD_BM_PROC_CALL = comp_bd_bm_proc_call;
	}

	public HtmlOutputLabel getCOMP_BD_STATUS_LABEL() {
		return COMP_BD_STATUS_LABEL;
	}

	public void setCOMP_BD_STATUS_LABEL(HtmlOutputLabel comp_bd_status_label) {
		COMP_BD_STATUS_LABEL = comp_bd_status_label;
	}

	public HtmlSelectOneMenu getCOMP_BD_STATUS() {
		return COMP_BD_STATUS;
	}

	public void setCOMP_BD_STATUS(HtmlSelectOneMenu comp_bd_status) {
		COMP_BD_STATUS = comp_bd_status;
	}

	public HtmlCommandButton getCOMP_BUTTON_CLEAR() {
		return COMP_BUTTON_CLEAR;
	}

	public void setCOMP_BUTTON_CLEAR(HtmlCommandButton comp_button_clear) {
		COMP_BUTTON_CLEAR = comp_button_clear;
	}

	public List<SelectItem> getListGROUP_ID() {
		if (listGROUP_ID.size() == 0) {
			listGROUP_ID.clear();
			try {
				listGROUP_ID = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listGROUP_ID;
	}

	public void setListGROUP_ID(List<SelectItem> listGROUP_ID) {
		this.listGROUP_ID = listGROUP_ID;
	}

	public HtmlOutputLabel getCOMP_GROUP_ID_LABEL() {
		return COMP_GROUP_ID_LABEL;
	}

	public void setCOMP_GROUP_ID_LABEL(HtmlOutputLabel comp_group_id_label) {
		COMP_GROUP_ID_LABEL = comp_group_id_label;
	}

	public HtmlSelectOneMenu getCOMP_GROUP_ID() {
		return COMP_GROUP_ID;
	}

	public void setCOMP_GROUP_ID(HtmlSelectOneMenu comp_group_id) {
		COMP_GROUP_ID = comp_group_id;
	}

	public boolean isProcessFlag() {
		return processFlag;
	}

	public void setProcessFlag(boolean processFlag) {
		this.processFlag = processFlag;
	}
	

}

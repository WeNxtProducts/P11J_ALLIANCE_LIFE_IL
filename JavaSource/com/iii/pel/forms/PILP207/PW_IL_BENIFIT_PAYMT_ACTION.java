package com.iii.pel.forms.PILP207;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.ARRAY;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP078.PT_IL_ADJ_HEAD;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PW_IL_BENIFIT_PAYMT_ACTION extends CommonAction {

	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("messageProperties_PILP206");

	public PILP207_COMPOSITE_ACTION compositeAction;

	private PW_IL_BENIFIT_PAYMT_HELPER helper;


	private HtmlOutputLabel COMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PIBP_PAYMENT_FM_DT;

	private HtmlOutputLabel COMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PIBP_PAYMENT_TO_DT;

	private HtmlOutputLabel COMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PIBP_RE_GEN_FM_DT;

	private HtmlOutputLabel COMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PIBP_RE_GEN_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_TXT_FILE;
	private HtmlCommandButton COMP_UI_M_RE_GEN_TXT_FILE;

	private HtmlSelectManyCheckbox COMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX ; 
	private HtmlSelectManyListbox COMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX;

	

	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;

	private String redirectUrl;
	
	StringBuffer url=null;

	private PW_IL_BENIFIT_PAYMT PW_IL_BENIFIT_PAYMT_BEAN;

	private PW_IL_BENIFIT_PAYMT_DELEGATE delegate;

	private UIData dataTable;


	private List<PW_IL_BENIFIT_PAYMT> dataList_PW_IL_BENIFIT_PAYMT = new ArrayList<PW_IL_BENIFIT_PAYMT>();

	private List<SelectItem>listRE_GEN_FILE_NAME = new ArrayList<SelectItem>();

	

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}
	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}
	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}


	public HtmlOutputLabel getCOMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL() {
		return COMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL;
	}
	public void setCOMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL(
			HtmlOutputLabel cOMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL) {
		COMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL = cOMP_UI_M_PIBP_RE_GEN_FM_DT_LABEL;
	}
	public HtmlCalendar getCOMP_UI_M_PIBP_RE_GEN_FM_DT() {
		return COMP_UI_M_PIBP_RE_GEN_FM_DT;
	}
	public void setCOMP_UI_M_PIBP_RE_GEN_FM_DT(
			HtmlCalendar cOMP_UI_M_PIBP_RE_GEN_FM_DT) {
		COMP_UI_M_PIBP_RE_GEN_FM_DT = cOMP_UI_M_PIBP_RE_GEN_FM_DT;
	}
	public HtmlOutputLabel getCOMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL() {
		return COMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL;
	}
	public void setCOMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL(
			HtmlOutputLabel cOMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL) {
		COMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL = cOMP_UI_M_PIBP_RE_GEN_TO_DT_LABEL;
	}
	public HtmlCalendar getCOMP_UI_M_PIBP_RE_GEN_TO_DT() {
		return COMP_UI_M_PIBP_RE_GEN_TO_DT;
	}
	public void setCOMP_UI_M_PIBP_RE_GEN_TO_DT(
			HtmlCalendar cOMP_UI_M_PIBP_RE_GEN_TO_DT) {
		COMP_UI_M_PIBP_RE_GEN_TO_DT = cOMP_UI_M_PIBP_RE_GEN_TO_DT;
	}
	public HtmlCommandButton getCOMP_UI_M_RE_GEN_TXT_FILE() {
		return COMP_UI_M_RE_GEN_TXT_FILE;
	}
	public void setCOMP_UI_M_RE_GEN_TXT_FILE(
			HtmlCommandButton cOMP_UI_M_RE_GEN_TXT_FILE) {
		COMP_UI_M_RE_GEN_TXT_FILE = cOMP_UI_M_RE_GEN_TXT_FILE;
	}


	public HtmlOutputLabel getCOMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL() {
		return COMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL;
	}
	public void setCOMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL(
			HtmlOutputLabel cOMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL) {
		COMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL = cOMP_UI_M_PIBP_PAYMENT_FM_DT_LABEL;
	}
	public HtmlCalendar getCOMP_UI_M_PIBP_PAYMENT_FM_DT() {
		return COMP_UI_M_PIBP_PAYMENT_FM_DT;
	}
	public void setCOMP_UI_M_PIBP_PAYMENT_FM_DT(
			HtmlCalendar cOMP_UI_M_PIBP_PAYMENT_FM_DT) {
		COMP_UI_M_PIBP_PAYMENT_FM_DT = cOMP_UI_M_PIBP_PAYMENT_FM_DT;
	}
	public HtmlOutputLabel getCOMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL() {
		return COMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL;
	}
	public void setCOMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL(
			HtmlOutputLabel cOMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL) {
		COMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL = cOMP_UI_M_PIBP_PAYMENT_TO_DT_LABEL;
	}
	public HtmlCalendar getCOMP_UI_M_PIBP_PAYMENT_TO_DT() {
		return COMP_UI_M_PIBP_PAYMENT_TO_DT;
	}
	public void setCOMP_UI_M_PIBP_PAYMENT_TO_DT(
			HtmlCalendar cOMP_UI_M_PIBP_PAYMENT_TO_DT) {
		COMP_UI_M_PIBP_PAYMENT_TO_DT = cOMP_UI_M_PIBP_PAYMENT_TO_DT;
	}
	public HtmlCommandButton getCOMP_UI_M_TXT_FILE() {
		return COMP_UI_M_TXT_FILE;
	}
	public void setCOMP_UI_M_TXT_FILE(HtmlCommandButton cOMP_UI_M_TXT_FILE) {
		COMP_UI_M_TXT_FILE = cOMP_UI_M_TXT_FILE;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton cOMP_UI_M_BUT_OK) {
		COMP_UI_M_BUT_OK = cOMP_UI_M_BUT_OK;
	}
	
	public HtmlSelectManyListbox getCOMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX() {
		return COMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX;
	}
	public void setCOMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX(
			HtmlSelectManyListbox cOMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX) {
		COMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX = cOMP_UI_M_RE_GEN_FILE_NAME_LIST_BOX;
	}
	
	public HtmlSelectManyCheckbox getCOMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX() {
		return COMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX;
	}
	public void setCOMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX(
			HtmlSelectManyCheckbox cOMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX) {
		COMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX = cOMP_UI_M_RE_GEN_FILE_NAME_CHECK_BOX;
	}
	public PW_IL_BENIFIT_PAYMT_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PW_IL_BENIFIT_PAYMT_HELPER helper) {
		this.helper = helper;
	}


	public PW_IL_BENIFIT_PAYMT getPW_IL_BENIFIT_PAYMT_BEAN() {
		return PW_IL_BENIFIT_PAYMT_BEAN;
	}
	public void setPW_IL_BENIFIT_PAYMT_BEAN(
			PW_IL_BENIFIT_PAYMT pW_IL_BENIFIT_PAYMT_BEAN) {
		PW_IL_BENIFIT_PAYMT_BEAN = pW_IL_BENIFIT_PAYMT_BEAN;
	}
	public PW_IL_BENIFIT_PAYMT_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PW_IL_BENIFIT_PAYMT_DELEGATE delegate) {
		this.delegate = delegate;
	}

	


	public List<SelectItem> getListRE_GEN_FILE_NAME() {
		return listRE_GEN_FILE_NAME;
	}
	public void setListRE_GEN_FILE_NAME(List<SelectItem> listRE_GEN_FILE_NAME) {
		this.listRE_GEN_FILE_NAME = listRE_GEN_FILE_NAME;
	}

	public PW_IL_BENIFIT_PAYMT_ACTION(){
		PW_IL_BENIFIT_PAYMT_BEAN = new PW_IL_BENIFIT_PAYMT();
		delegate = new PW_IL_BENIFIT_PAYMT_DELEGATE();
		helper = new PW_IL_BENIFIT_PAYMT_HELPER();

	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public List<PW_IL_BENIFIT_PAYMT> getDataList_PW_IL_BENIFIT_PAYMT() {
		return dataList_PW_IL_BENIFIT_PAYMT;
	}
	public void setDataList_PW_IL_BENIFIT_PAYMT(
			List<PW_IL_BENIFIT_PAYMT> dataList_PW_IL_BENIFIT_PAYMT) {
		this.dataList_PW_IL_BENIFIT_PAYMT = dataList_PW_IL_BENIFIT_PAYMT;
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				getErrorMap().clear();
				getWarningMap().clear();
				//helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PW_IL_BENIFIT_PAYMT_BEAN = (PW_IL_BENIFIT_PAYMT) dataTable.getRowData();
			PW_IL_BENIFIT_PAYMT_BEAN.setRowSelected(true);
			//resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		Iterator<PW_IL_BENIFIT_PAYMT> PW_IL_BENIFIT_PAYMT = dataList_PW_IL_BENIFIT_PAYMT.iterator();
		while (PW_IL_BENIFIT_PAYMT.hasNext()) {
			PW_IL_BENIFIT_PAYMT.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_PIBP_PAYMENT_TO_DT.resetValue();
		COMP_UI_M_PIBP_PAYMENT_FM_DT.resetValue();

	}


	public String whenButtonPressedUI_M_BUT_OK(ActionEvent ae) throws Exception{
		try {
			P_PAYNET_PROCESS(CommonUtils.dateToStringFormatter(PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_FM_DT()),
					CommonUtils.dateToStringFormatter(PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_TO_DT()));
			helper.executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("WRITE", e.getMessage());

			// TODO: handle exception
		}
		return "";
	}

	public String FetchRegenerateRecord(ActionEvent ae) throws Exception{
		try {
			helper.re_generate_executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("WRITE", e.getMessage());

			// TODO: handle exception
		}
		return "";
	}



	public ArrayList<OracleParameter> P_PAYNET_PROCESS(String P_PAID_DT_FM,String P_PAID_DT_TO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT_TO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_PROCESS.P_PAYNET_PROCESS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	String PAID_DATE_FM=null;
	String PAID_DATE_TO=null;
	public void validateUI_M_PIBP_PAYMENT_FM_DT(FacesContext context,
			UIComponent component, Object value)  {
		Date CurValue = (Date) value;
		try {
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_PAYMENT_FM_DT(CurValue);
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_RE_GEN_FM_DT(CurValue);
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			PAID_DATE_FM = simpleDateFormat1.format(CurValue);
			System.out.println("CurValue Date  :"+PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_FM_DT());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Premtype", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PIBP_PAYMENT_TO_DT(FacesContext context,
			UIComponent component, Object value)  {
		Date CurValue = (Date) value;
		try {
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_PAYMENT_TO_DT(CurValue);
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_RE_GEN_TO_DT(CurValue);
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			PAID_DATE_TO = simpleDateFormat1.format(CurValue);
			System.out.println("CurValue Date  :"+PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_TO_DT());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Premtype", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PIBP_RE_GEN_FM_DT(FacesContext context,
			UIComponent component, Object value)  {
		Date CurValue = (Date) value;
		try {
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_RE_GEN_FM_DT(CurValue);
			System.out.println("setUI_M_PIBP_RE_GEN_FM_DT   :"+PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_RE_GEN_FM_DT());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Premtype", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PIBP_RE_GEN_TO_DT(FacesContext context,
			UIComponent component, Object value)  {
		Date CurValue = (Date) value;
		try {
			PW_IL_BENIFIT_PAYMT_BEAN.setUI_M_PIBP_RE_GEN_TO_DT(CurValue);
			System.out.println("setUI_M_PIBP_RE_GEN_TO_DT   :"+PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_RE_GEN_TO_DT());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Premtype", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	
	public String ExcelFileGenerate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		Connection connection = null;
		try 
		{
			connection = CommonUtils.getConnection();

			/*Added flag by ganesh on 12-03-2018 for shceduler process */
			writePaynetProcess(connection,CommonUtils.dateToStringFormat(PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_FM_DT()),
					CommonUtils.dateToStringFormat(PW_IL_BENIFIT_PAYMT_BEAN.getUI_M_PIBP_PAYMENT_TO_DT()),"N");

			String message ="CSV file generated succesfully";
			getWarningMap().put("writeFile",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	public String callReportModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		return null;
	}

	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}


	public String regeneratepageValidate() 
	{	
		String outCome = null;
		try {

			outCome ="PILP207_Regenerate_Page";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return outCome;
	}


	public String Regenerate_Process() 
	{	
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Enter the Regenerate_Process   : ");
			System.out.println("RE_GEN_FILE_NAME   : "+PW_IL_BENIFIT_PAYMT_BEAN.getRE_GEN_FILE_NAME());

			writePaynetProcessRegenerate(connection,PW_IL_BENIFIT_PAYMT_BEAN.getRE_GEN_FILE_NAME());

			String message ="CSV file RE-Generated succesfully";
			getWarningMap().put("writeFile",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;

	}

	/*Added static by ganesh on 26-02-2018 for servlet scheduler*/
	public static void writePaynetProcess(Connection con,String Req_From_Date , String Req_To_Date, String pathFlag) throws ParseException{

		String excelGenPath = "";
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsPath =null;
		int Todatal_Days= numberOfDays(Req_From_Date,Req_To_Date);

		try{
			for(int i=0;i<=Todatal_Days;i++)
			{
				Workbook workbook = (Workbook) new HSSFWorkbook();

				Sheet studentsSheet = workbook.createSheet("Paynet");

				HSSFCellStyle borderStyle=(HSSFCellStyle) workbook.createCellStyle();
				borderStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

				int rowIndex = 0;
				Row firstRow = studentsSheet.createRow(rowIndex++);
				int cellIndex = 0;

				CellStyle firststyle = workbook.createCellStyle();
				firststyle.setBorderTop(CellStyle.BORDER_THIN);
				firststyle.setBorderBottom(CellStyle.BORDER_THIN);
				firststyle.setBorderLeft(CellStyle.BORDER_THIN);
				firststyle.setBorderRight(CellStyle.BORDER_THIN);

				CellStyle totalStyle = workbook.createCellStyle();

				Cell firstCell1 = firstRow.createCell(cellIndex++);
				firstCell1.setCellValue("Client ID");
				firstCell1.setCellStyle(firststyle);

				Cell firstCell2 = firstRow.createCell(cellIndex++);
				firstCell2.setCellValue("Policy ID");
				firstCell2.setCellStyle(firststyle);

				Cell firstCell3 = firstRow.createCell(cellIndex++);
				firstCell3.setCellValue("Client Name");
				firstCell3.setCellStyle(firststyle);

				Cell firstCell4 = firstRow.createCell(cellIndex++);
				firstCell4.setCellValue("Account Number");
				firstCell4.setCellStyle(firststyle);

				Cell firstCell5 = firstRow.createCell(cellIndex++);
				firstCell5.setCellValue("Account Type");
				firstCell5.setCellStyle(firststyle);

				Cell firstCell6 = firstRow.createCell(cellIndex++);
				firstCell6.setCellValue("Bank Code");
				firstCell6.setCellStyle(firststyle);

				Cell firstCell7 = firstRow.createCell(cellIndex++);
				firstCell7.setCellValue("Branch Sort Code");
				firstCell7.setCellStyle(firststyle);

				Cell firstCell8 = firstRow.createCell(cellIndex++);
				firstCell8.setCellValue("Account Name");
				firstCell8.setCellStyle(firststyle);

				Cell firstCell9 = firstRow.createCell(cellIndex++);
				firstCell9.setCellValue("Payment Date");
				firstCell9.setCellStyle(firststyle);

				Cell firstCell10 = firstRow.createCell(cellIndex++);
				firstCell10.setCellValue("Amount");
				firstCell10.setCellStyle(firststyle);

				Cell firstCell11 = firstRow.createCell(cellIndex++);
				firstCell11.setCellValue("Product");
				firstCell11.setCellStyle(firststyle);

				Cell firstCell12 = firstRow.createCell(cellIndex++);
				firstCell12.setCellValue("Life Type");
				firstCell12.setCellStyle(firststyle);

				Cell firstCell13 = firstRow.createCell(cellIndex++);
				firstCell13.setCellValue("Company");
				firstCell13.setCellStyle(firststyle);

				Cell firstCell14 = firstRow.createCell(cellIndex++);
				firstCell14.setCellValue("Gross Amount");
				firstCell14.setCellStyle(firststyle);

				Cell firstCell15 = firstRow.createCell(cellIndex++);
				firstCell15.setCellValue("Medical Aid Deductions");
				firstCell15.setCellStyle(firststyle);

				Cell firstCell16 = firstRow.createCell(cellIndex++);
				firstCell16.setCellValue("Policy Premiums");
				firstCell16.setCellStyle(firststyle);

				Cell firstCell17 = firstRow.createCell(cellIndex++);
				firstCell17.setCellValue("PAYE");
				firstCell17.setCellStyle(firststyle);

				/*Commented by dhinesh on 13-03-2018 from onsite
				 */
				/*Cell firstCell18 = firstRow.createCell(cellIndex++);
				firstCell18.setCellValue("Lost Policy Fees");
				firstCell18.setCellStyle(firststyle);


				Cell firstCell19 = firstRow.createCell(cellIndex++);
				firstCell19.setCellValue("Processing Fees");
				firstCell19.setCellStyle(firststyle);

				Cell firstCell20 = firstRow.createCell(cellIndex++);
				firstCell20.setCellValue("Bank Transfer Fees");
				firstCell20.setCellStyle(firststyle);

				Cell secondCell1 = firstRow.createCell(cellIndex++);
				secondCell1.setCellValue("Outstanding Loans");
				secondCell1.setCellStyle(firststyle);


				Cell secondCell2 = firstRow.createCell(cellIndex++);
				secondCell2.setCellValue("Other Charges (to be specified)");
				secondCell2.setCellStyle(firststyle);*/
				/*end*/


				Cell secondCell3 = firstRow.createCell(cellIndex++);
				secondCell3.setCellValue("Net Amount");
				secondCell3.setCellStyle(firststyle);
				String FromDate = null;
				String Todate   = null;


				String FetchDateQuery="select to_date(?,'dd/mm/yyyy')+"+i+" as FileDate  from dual";
				String MainQuery="SELECT * FROM  PW_IL_BENIFIT_PAYMT  where trunc(PIBP_PAYMENT_DT) = to_date(?,'dd/mm/yyyy')";
				String update_Query = "update PW_IL_BENIFIT_PAYMT  set pibp_file_name  = ? where  trunc(PIBP_PAYMENT_DT) = to_date(?,'dd/mm/yyyy')" ;
				Date Fetchpayment_dt= null;

				ResultSet res=new CRUDHandler().executeSelectStatement(FetchDateQuery, con,new Object[]{ Req_From_Date });
				String MainQyery_Var= null;
				if(res.next()){
					Fetchpayment_dt = res.getDate("FileDate");

					try {
						rs = new CRUDHandler().executeSelectStatement(MainQuery,con,new Object[]{ CommonUtils.dateToStringFormatter(Fetchpayment_dt)});

						while(rs.next())
						{
							System.out.println("inside resultset while ::"+rowIndex);
							Row row = studentsSheet.createRow(rowIndex++);
							cellIndex = 0;

							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_CLIENT_ID"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_POLICY_ID"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_CLIENT_NAME"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_NUMBER"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_TYPE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BANK_CODE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BRANCH_SHORT_CODE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_NAME"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PAYMENT_DT"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_AMOUNT"));
							
							/*MOdified by Janani on 12.09.2017 for ZBILQC-1732129*/
							/*row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LIFE_TYPE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROD_CODE"));*/
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROD_CODE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LIFE_TYPE"));
							/*End*/
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_COMPANY"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_GROSS_AMOUNT"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_MED_AID_DEDUCTION"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_POL_PREMIUM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PAYE"));
							/*Commented by dhinesh on 13-03-2018 not required*/
							/*row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LOST_POL_FEES"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROCSS_FEES"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BANK_TRANSFER_FEES"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_OUT_STANDING_LOAN"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_OTHRS_CHARGE"));*/
							/*end*/
							row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_NET_AMOUNT"));

							MainQyery_Var = "T";
						}
						System.out.println("cellindex"+cellIndex);
						if("T".equalsIgnoreCase(CommonUtils.nvl(MainQyery_Var,"F")))
						{
							for(int a = 0 ;a<cellIndex;a++){
								studentsSheet.autoSizeColumn(a);
							}
							MainQyery_Var = "F";
							try {

								String PaynetFileName = Paynet_Proc_FileName(CommonUtils.dateToStringFormatter(Fetchpayment_dt));
								System.out.println("PaynetFileName ==>>>>"+PaynetFileName);
								
								/*Added by ganesh on 10-03-2018 for report scheduler*/
								String dir = System.getProperty("user.home");
								if("Y".equalsIgnoreCase(pathFlag)){
									String pathQuery = "select ps_code_desc from pp_system where ps_type = ?";
									rsPath = new CRUDHandler().executeSelectStatement(pathQuery, con, new Object[]{"EOD_REP_PATH"});
									if(rsPath.next()){
										dir = rsPath.getString(1);
									}
								}
								/*end*/
								
						        System.out.println("current dir = " + dir);
						        
						        //int rootindex = dir.indexOf(File.separator);
						        
						        //System.out.println(dir.substring(0, rootindex));
						        
						        File filedir = new File(dir+File.separator+"PAYNET PROCESS");
						        /*Added by ganesh on 10-03-2018 for report scheduler*/
						        if("Y".equalsIgnoreCase(pathFlag)){
						        	filedir = new File(dir);
						        }
						        /*end*/
						        
						        if(!filedir.exists()){
						        	filedir.mkdir();
						        }
												
								String rootpath = dir+File.separator+"PAYNET PROCESS"+File.separator;
								/*Added by ganesh on 10-03-2018 for report scheduler*/
								if("Y".equalsIgnoreCase(pathFlag)){
									rootpath = dir;
						        }
								/*end*/
								
								System.out.println("Root Path        "+rootpath);
								
								
								String directory=rootpath ; /*resourceBundleDatabase.getString("DEFAULT_FILE_SAVE"); */
								

								PaynetFileName = PaynetFileName.replace("-","_");
								System.out.println("directory ==>>>"+directory);
								excelGenPath=rootpath+""+PaynetFileName+".CSV";
								System.out.println("PaynetFileName ==>>>>"+PaynetFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);

								FileOutputStream fos = new FileOutputStream(excelGenPath);
								workbook.write(fos);
								fos.close();
								rowIndex=1;

								new CRUDHandler().executeUpdateStatement(update_Query, con,
										new Object[] {PaynetFileName,CommonUtils.dateToStringFormatter(Fetchpayment_dt) });
								con.commit();

								System.out.println(excelGenPath + " is successfully written");
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//return "";
	}

	public void writePaynetProcessRegenerate(Connection con,String[] array_Regenerate_File) throws ParseException{

		String excelGenPath = "";
		Connection conn = null;
		ResultSet rs = null;
		int Total_File = array_Regenerate_File.length;
		try{
			for(int i=0;i<Total_File;i++)
			{
				Workbook workbook = (Workbook) new HSSFWorkbook();

				Sheet studentsSheet = workbook.createSheet("RI_Bordeaux");

				HSSFCellStyle borderStyle=(HSSFCellStyle) workbook.createCellStyle();
				borderStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				borderStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

				int rowIndex = 0;
				Row firstRow = studentsSheet.createRow(rowIndex++);
				int cellIndex = 0;


				CellStyle firststyle = workbook.createCellStyle();
				firststyle.setBorderTop(CellStyle.BORDER_THIN);
				firststyle.setBorderBottom(CellStyle.BORDER_THIN);
				firststyle.setBorderLeft(CellStyle.BORDER_THIN);
				firststyle.setBorderRight(CellStyle.BORDER_THIN);

				//total row style

				CellStyle totalStyle = workbook.createCellStyle();

				Cell firstCell1 = firstRow.createCell(cellIndex++);
				firstCell1.setCellValue("Client ID");
				firstCell1.setCellStyle(firststyle);

				Cell firstCell2 = firstRow.createCell(cellIndex++);
				firstCell2.setCellValue("Policy ID");
				firstCell2.setCellStyle(firststyle);

				Cell firstCell3 = firstRow.createCell(cellIndex++);
				firstCell3.setCellValue("Client Name");
				firstCell3.setCellStyle(firststyle);

				Cell firstCell4 = firstRow.createCell(cellIndex++);
				firstCell4.setCellValue("Account Number");
				firstCell4.setCellStyle(firststyle);

				Cell firstCell5 = firstRow.createCell(cellIndex++);
				firstCell5.setCellValue("Account Type");
				firstCell5.setCellStyle(firststyle);

				Cell firstCell6 = firstRow.createCell(cellIndex++);
				firstCell6.setCellValue("Bank Code");
				firstCell6.setCellStyle(firststyle);

				Cell firstCell7 = firstRow.createCell(cellIndex++);
				firstCell7.setCellValue("Branch Sort Code");
				firstCell7.setCellStyle(firststyle);

				Cell firstCell8 = firstRow.createCell(cellIndex++);
				firstCell8.setCellValue("Account Name");
				firstCell8.setCellStyle(firststyle);

				Cell firstCell9 = firstRow.createCell(cellIndex++);
				firstCell9.setCellValue("Payment Date");
				firstCell9.setCellStyle(firststyle);

				Cell firstCell10 = firstRow.createCell(cellIndex++);
				firstCell10.setCellValue("Amount");
				firstCell10.setCellStyle(firststyle);

				Cell firstCell11 = firstRow.createCell(cellIndex++);
				firstCell11.setCellValue("Product");
				firstCell11.setCellStyle(firststyle);

				Cell firstCell12 = firstRow.createCell(cellIndex++);
				firstCell12.setCellValue("Life Type");
				firstCell12.setCellStyle(firststyle);

				Cell firstCell13 = firstRow.createCell(cellIndex++);
				firstCell13.setCellValue("Company");
				firstCell13.setCellStyle(firststyle);

				Cell firstCell14 = firstRow.createCell(cellIndex++);
				firstCell14.setCellValue("Gross Amount");
				firstCell14.setCellStyle(firststyle);

				Cell firstCell15 = firstRow.createCell(cellIndex++);
				firstCell15.setCellValue("Medical Aid Deductions");
				firstCell15.setCellStyle(firststyle);

				Cell firstCell16 = firstRow.createCell(cellIndex++);
				firstCell16.setCellValue("Policy Premiums");
				firstCell16.setCellStyle(firststyle);

				Cell firstCell17 = firstRow.createCell(cellIndex++);
				firstCell17.setCellValue("PAYE");
				firstCell17.setCellStyle(firststyle);

				Cell firstCell18 = firstRow.createCell(cellIndex++);
				firstCell18.setCellValue("Lost Policy Fees");
				firstCell18.setCellStyle(firststyle);


				Cell firstCell19 = firstRow.createCell(cellIndex++);
				firstCell19.setCellValue("Processing Fees");
				firstCell19.setCellStyle(firststyle);

				Cell firstCell20 = firstRow.createCell(cellIndex++);
				firstCell20.setCellValue("Bank Transfer Fees");
				firstCell20.setCellStyle(firststyle);

				Cell secondCell1 = firstRow.createCell(cellIndex++);
				secondCell1.setCellValue("Outstanding Loans");
				secondCell1.setCellStyle(firststyle);


				Cell secondCell2 = firstRow.createCell(cellIndex++);
				secondCell2.setCellValue("Other Charges (to be specified)");
				secondCell2.setCellStyle(firststyle);


				Cell secondCell3 = firstRow.createCell(cellIndex++);
				secondCell3.setCellValue("Net Amount");
				secondCell3.setCellStyle(firststyle);


				String MainQuery="SELECT * FROM  PW_IL_BENIFIT_PAYMT  where PIBP_FILE_NAME = ? ";
				String MainQyery_Var = null;
				try {
					rs = new CRUDHandler().executeSelectStatement(MainQuery,con,new Object[]{array_Regenerate_File[i]});

					while(rs.next())
					{
						System.out.println("inside resultset while ::"+rowIndex);
						Row row = studentsSheet.createRow(rowIndex++);
						cellIndex = 0;

						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_CLIENT_ID"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_POLICY_ID"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_CLIENT_NAME"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_NUMBER"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_TYPE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BANK_CODE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BRANCH_SHORT_CODE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_ACC_NAME"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PAYMENT_DT"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_AMOUNT"));
										

						/*MOdified by Janani on 12.09.2017 for ZBILQC-1732129*/
						/*row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LIFE_TYPE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROD_CODE"));*/
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROD_CODE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LIFE_TYPE"));
						/*End*/
						
						
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_COMPANY"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_GROSS_AMOUNT"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_MED_AID_DEDUCTION"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_POL_PREMIUM"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PAYE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_LOST_POL_FEES"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_PROCSS_FEES"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_BANK_TRANSFER_FEES"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_OUT_STANDING_LOAN"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_OTHRS_CHARGE"));
						row.createCell(cellIndex++).setCellValue(rs.getString("PIBP_NET_AMOUNT"));

						MainQyery_Var = "T";
					}
					System.out.println("cellindex"+cellIndex);
					if("T".equalsIgnoreCase(CommonUtils.nvl(MainQyery_Var,"F")))
					{
						for(int a = 0 ;a<cellIndex;a++){
							studentsSheet.autoSizeColumn(a);
						}
						MainQyery_Var = "F";
						try {

							String PaynetFileName = array_Regenerate_File[i];
							System.out.println("PaynetFileName ==>>>>"+PaynetFileName);
							final String dir = System.getProperty("user.dir");
					        System.out.println("current dir = " + dir);
					        
					        int rootindex = dir.indexOf(File.separator);
					        
					        System.out.println(dir.substring(0, rootindex));
					        
					        File filedir = new File(dir.substring(0, rootindex)+File.separator+"PAYNET PROCESS");
					        
					        if(!filedir.exists()){
					        	filedir.mkdir();
					        }
											
							String rootpath = dir.substring(0, rootindex)+File.separator+"PAYNET PROCESS"+File.separator;
							
							System.out.println("Root Path        "+rootpath);
							
							
							String directory=rootpath ; /*resourceBundleDatabase.getString("DEFAULT_FILE_SAVE"); */
							

							PaynetFileName = PaynetFileName.replace("-","_");
							System.out.println("directory ==>>>"+directory);
							excelGenPath=rootpath+""+PaynetFileName+".CSV";
							System.out.println("PaynetFileName ==>>>>"+PaynetFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);

							System.out.println("PaynetFileName ==>>>>"+PaynetFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);

							FileOutputStream fos = new FileOutputStream(excelGenPath);
							workbook.write(fos);
							fos.close();
							rowIndex=1;

							/*new CRUDHandler().executeUpdateStatement(update_Query, con,
										new Object[] {PaynetFileName,CommonUtils.dateToStringFormatter(Fetchpayment_dt) });
								con.commit();*/

							System.out.println(excelGenPath + " is successfully written");
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//return "";
	}

	/*Added static by ganesh on 26-02-2018 for servlet scheduler*/
	public static String Paynet_Proc_FileName(String fileName){

		/*DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date date = new Date();
		String today=dateFormat.format(fileName);*/
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String time=sdf.format(cal.getTime());
		fileName="Paynet"+"_"+fileName+"_"+time;
		//System.out.println("filename =====>>>>>>>>"+fileName);
		return fileName;
	}
	/*Added static by ganesh on 26-02-2018 for servlet scheduler*/
	public static int numberOfDays(String fromDate,String toDate)
	{    
		java.util.Calendar cal1 = new java.util.GregorianCalendar();
		java.util.Calendar cal2 = new java.util.GregorianCalendar();

		//split year, month and days from the date using StringBuffer.
		StringBuffer sBuffer = new StringBuffer(fromDate);
		String yearFrom = sBuffer.substring(6,10);
		String monFrom = sBuffer.substring(0,2);
		String ddFrom = sBuffer.substring(3,5);
		int intYearFrom = Integer.parseInt(yearFrom);
		int intMonFrom = Integer.parseInt(monFrom);
		int intDdFrom = Integer.parseInt(ddFrom);

		// set the fromDate in java.util.Calendar
		cal1.set(intYearFrom, intDdFrom, intMonFrom);

		//split year, month and days from the date using StringBuffer.
		StringBuffer sBuffer1 = new StringBuffer(toDate);
		String yearTo = sBuffer1.substring(6,10);
		String monTo = sBuffer1.substring(0,2);
		String ddTo = sBuffer1.substring(3,5);
		int intYearTo = Integer.parseInt(yearTo);
		int intMonTo = Integer.parseInt(monTo);
		int intDdTo = Integer.parseInt(ddTo);

		// set the toDate in java.util.Calendar
		cal2.set(intYearTo, intDdTo ,intMonTo);

		//call method daysBetween to get the number of days between two dates
		int days = daysBetween(cal1.getTime(),cal2.getTime());
		return days;
	}

	//This method is called by the above method numberOfDays
	/*Added static by ganesh on 26-02-2018 for servlet scheduler*/
	public static int daysBetween(Date d1, Date d2)
	{
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}


	public String backButton() {
		String outcome = null;
try {
	outcome = "PILP207_PW_IL_BENIFIT_PAYMT";
} catch (Exception e) {
	// TODO: handle exception
}
return outcome;
	}

}


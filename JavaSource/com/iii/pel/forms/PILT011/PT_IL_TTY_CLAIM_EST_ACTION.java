package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;




import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TTY_CLAIM_EST_ACTION extends CommonAction{
	private HtmlOutputLabel COMP_TCE_CCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_TCE_CCD_COVER_CODE;

	private HtmlOutputLabel COMP_TCE_TREATY_CODE_LABEL;

	private HtmlInputText COMP_TCE_TREATY_CODE;

	private HtmlOutputLabel COMP_TCE_UW_YEAR_LABEL;

	private HtmlInputText COMP_TCE_UW_YEAR;

	private HtmlOutputLabel COMP_TCE_CLAIM_LOSS_DT_LABEL;

	private HtmlCalendar COMP_TCE_CLAIM_LOSS_DT;

	private HtmlOutputLabel COMP_TCE_RETN_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCE_RETN_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCE_QS_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCE_QS_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCE_1S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCE_1S_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCE_2S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCE_2S_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCE_3S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCE_3S_LC_CLM_EST;
	
	private HtmlInputText COMP_UI_M_COVER_DESC_3;

	private PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN;
	
	private PT_IL_TTY_CLAIM_EST_HELPER helper= new PT_IL_TTY_CLAIM_EST_HELPER();
	
	private HtmlCommandButton COMP_UI_M_BUT_HIST;

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	private ControlBean controlBean = null;
	public CRUDHandler handler = null;
	private Connection connection;
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private UIDataTable treatyTable;
	private HtmlSelectBooleanCheckbox checkBox;
	private List<PT_IL_TTY_CLAIM_EST> claimEstList = new ArrayList<PT_IL_TTY_CLAIM_EST>();
	private int rowIndex;
	private int lastRowIdx;
	private int prevRowIdx;
	
	public PILT011_COMPOSITE_ACTION compositeAction;
	
	public PT_IL_TTY_CLAIM_EST_ACTION() {
		PT_IL_TTY_CLAIM_EST_BEAN = new PT_IL_TTY_CLAIM_EST();
		handler = new CRUDHandler();
		controlBean = CommonUtils.getControlBean();
		getPT_IL_TTY_CLAIM_EST_Dtls();
	}
	/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 17/02/2017*/
	public void onLoad(PhaseEvent event){
		try {
			if(isFormFlag()){
				
				setFormFlag(false);
			}
			
			/*Added by Janani on 23.08.2017 for ZBILQC-1732254*/
			
			setBlockFlag(true);
			
			/*End*/
			if (isBlockFlag()) {
				System.out.println("*************** ONLOAD IS CALLED **********");
				helper.executeQuery(compositeAction);
				/* added by raja on 18-08-2017 for ZBILQC-1722999 */
				helper.pre_form(PT_IL_TTY_CLAIM_EST_BEAN,compositeAction);
				/*end*/
				System.out.println("pol_no  :"+PT_IL_TTY_CLAIM_EST_BEAN.getUI_M_POL_NO_1());
				System.out.println("claim_no  :"+PT_IL_TTY_CLAIM_EST_BEAN.getUI_M_CLM_NO_1());
				//getPT_IL_TTY_CLAIM_EST_Dtls();
				COMP_UI_M_POL_NO_1.resetValue();
				COMP_UI_M_CLM_NO_1.resetValue();
				/* added by raja on 18-08-2017 for ZBILQC-1722999 */
				COMP_FCE_CLAIM_CURR_CODE.resetValue();
				COMP_UI_M_CURR_DESC_1.resetValue();
				
				if(PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_COVER_CODE()!=null)
				{
				String Query="select COVER_DESC from pm_il_cover where COVER_CODE=?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_COVER_CODE()});
				while(rs.next())
				{
					PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_COVER_DESC_3(rs.getString("COVER_DESC"));
				}
				}
				/*end*/
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/*End*/
	
	public HtmlCommandButton getCOMP_UI_M_BUT_HIST() {
		return COMP_UI_M_BUT_HIST;
	}

	public void setCOMP_UI_M_BUT_HIST(HtmlCommandButton comp_ui_m_but_hist) {
		COMP_UI_M_BUT_HIST = comp_ui_m_but_hist;
	}

	public HtmlOutputLabel getCOMP_TCE_CCD_COVER_CODE_LABEL() {
		return COMP_TCE_CCD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TCE_CCD_COVER_CODE() {
		return COMP_TCE_CCD_COVER_CODE;
	}

	public void setCOMP_TCE_CCD_COVER_CODE_LABEL(HtmlOutputLabel COMP_TCE_CCD_COVER_CODE_LABEL) {
		this.COMP_TCE_CCD_COVER_CODE_LABEL = COMP_TCE_CCD_COVER_CODE_LABEL;
	}

	public void setCOMP_TCE_CCD_COVER_CODE(HtmlInputText COMP_TCE_CCD_COVER_CODE) {
		this.COMP_TCE_CCD_COVER_CODE = COMP_TCE_CCD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_TCE_TREATY_CODE_LABEL() {
		return COMP_TCE_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TCE_TREATY_CODE() {
		return COMP_TCE_TREATY_CODE;
	}

	public void setCOMP_TCE_TREATY_CODE_LABEL(HtmlOutputLabel COMP_TCE_TREATY_CODE_LABEL) {
		this.COMP_TCE_TREATY_CODE_LABEL = COMP_TCE_TREATY_CODE_LABEL;
	}

	public void setCOMP_TCE_TREATY_CODE(HtmlInputText COMP_TCE_TREATY_CODE) {
		this.COMP_TCE_TREATY_CODE = COMP_TCE_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_TCE_UW_YEAR_LABEL() {
		return COMP_TCE_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_TCE_UW_YEAR() {
		return COMP_TCE_UW_YEAR;
	}

	public void setCOMP_TCE_UW_YEAR_LABEL(HtmlOutputLabel COMP_TCE_UW_YEAR_LABEL) {
		this.COMP_TCE_UW_YEAR_LABEL = COMP_TCE_UW_YEAR_LABEL;
	}

	public void setCOMP_TCE_UW_YEAR(HtmlInputText COMP_TCE_UW_YEAR) {
		this.COMP_TCE_UW_YEAR = COMP_TCE_UW_YEAR;
	}

	public HtmlOutputLabel getCOMP_TCE_CLAIM_LOSS_DT_LABEL() {
		return COMP_TCE_CLAIM_LOSS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TCE_CLAIM_LOSS_DT() {
		return COMP_TCE_CLAIM_LOSS_DT;
	}

	public void setCOMP_TCE_CLAIM_LOSS_DT_LABEL(HtmlOutputLabel COMP_TCE_CLAIM_LOSS_DT_LABEL) {
		this.COMP_TCE_CLAIM_LOSS_DT_LABEL = COMP_TCE_CLAIM_LOSS_DT_LABEL;
	}

	public void setCOMP_TCE_CLAIM_LOSS_DT(HtmlCalendar COMP_TCE_CLAIM_LOSS_DT) {
		this.COMP_TCE_CLAIM_LOSS_DT = COMP_TCE_CLAIM_LOSS_DT;
	}

	public HtmlOutputLabel getCOMP_TCE_RETN_LC_CLM_EST_LABEL() {
		return COMP_TCE_RETN_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCE_RETN_LC_CLM_EST() {
		return COMP_TCE_RETN_LC_CLM_EST;
	}

	public void setCOMP_TCE_RETN_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCE_RETN_LC_CLM_EST_LABEL) {
		this.COMP_TCE_RETN_LC_CLM_EST_LABEL = COMP_TCE_RETN_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCE_RETN_LC_CLM_EST(HtmlInputText COMP_TCE_RETN_LC_CLM_EST) {
		this.COMP_TCE_RETN_LC_CLM_EST = COMP_TCE_RETN_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCE_QS_LC_CLM_EST_LABEL() {
		return COMP_TCE_QS_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCE_QS_LC_CLM_EST() {
		return COMP_TCE_QS_LC_CLM_EST;
	}

	public void setCOMP_TCE_QS_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCE_QS_LC_CLM_EST_LABEL) {
		this.COMP_TCE_QS_LC_CLM_EST_LABEL = COMP_TCE_QS_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCE_QS_LC_CLM_EST(HtmlInputText COMP_TCE_QS_LC_CLM_EST) {
		this.COMP_TCE_QS_LC_CLM_EST = COMP_TCE_QS_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCE_1S_LC_CLM_EST_LABEL() {
		return COMP_TCE_1S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCE_1S_LC_CLM_EST() {
		return COMP_TCE_1S_LC_CLM_EST;
	}

	public void setCOMP_TCE_1S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCE_1S_LC_CLM_EST_LABEL) {
		this.COMP_TCE_1S_LC_CLM_EST_LABEL = COMP_TCE_1S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCE_1S_LC_CLM_EST(HtmlInputText COMP_TCE_1S_LC_CLM_EST) {
		this.COMP_TCE_1S_LC_CLM_EST = COMP_TCE_1S_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCE_2S_LC_CLM_EST_LABEL() {
		return COMP_TCE_2S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCE_2S_LC_CLM_EST() {
		return COMP_TCE_2S_LC_CLM_EST;
	}

	public void setCOMP_TCE_2S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCE_2S_LC_CLM_EST_LABEL) {
		this.COMP_TCE_2S_LC_CLM_EST_LABEL = COMP_TCE_2S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCE_2S_LC_CLM_EST(HtmlInputText COMP_TCE_2S_LC_CLM_EST) {
		this.COMP_TCE_2S_LC_CLM_EST = COMP_TCE_2S_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCE_3S_LC_CLM_EST_LABEL() {
		return COMP_TCE_3S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCE_3S_LC_CLM_EST() {
		return COMP_TCE_3S_LC_CLM_EST;
	}

	public void setCOMP_TCE_3S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCE_3S_LC_CLM_EST_LABEL) {
		this.COMP_TCE_3S_LC_CLM_EST_LABEL = COMP_TCE_3S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCE_3S_LC_CLM_EST(HtmlInputText COMP_TCE_3S_LC_CLM_EST) {
		this.COMP_TCE_3S_LC_CLM_EST = COMP_TCE_3S_LC_CLM_EST;
	}

	public PT_IL_TTY_CLAIM_EST getPT_IL_TTY_CLAIM_EST_BEAN() {
		return PT_IL_TTY_CLAIM_EST_BEAN;
	}

	public void setPT_IL_TTY_CLAIM_EST_BEAN(PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN) {
		this.PT_IL_TTY_CLAIM_EST_BEAN = PT_IL_TTY_CLAIM_EST_BEAN;
	}
	public UIDataTable getTreatyTable() {
		return treatyTable;
	}

	public void setTreatyTable(UIDataTable treatyTable) {
		this.treatyTable = treatyTable;
	}

	public void checkBoxStatus(ActionEvent actionEvent){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int rowIndex = getTreatyTable().getRowIndex();
		PT_IL_TTY_CLAIM_EST_BEAN = claimEstList.get(rowIndex);
		if(PT_IL_TTY_CLAIM_EST_BEAN.isCHECK_BOX()){
			session.put("TREATY_CODE", PT_IL_TTY_CLAIM_EST_BEAN.getTCE_TREATY_CODE());
			session.put("TCEH_CCD_SYS_ID", PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_SYS_ID());
		}else{
			session.put("TREATY_CODE", "");
			session.put("TCEH_CCD_SYS_ID", "");
		}
	}

	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	public List<PT_IL_TTY_CLAIM_EST> getClaimEstList() {
		return claimEstList;
	}

	public void setClaimEstList(List<PT_IL_TTY_CLAIM_EST> claimEstList) {
		this.claimEstList = claimEstList;
	}
	public void PT_IL_TTY_CLAIM_EST_WHEN_NEW_BLOCK_INSTANCE(){
		//NULL;
	}
	
	public void PT_IL_TTY_CLAIM_EST_POST_QUERY(){
		P_VAL_COVER();
	}
	
	public void P_VAL_COVER(){
		if(getClaimEstList()!=null && getClaimEstList().size()>0){
			PT_IL_TTY_CLAIM_EST_BEAN.setTCE_CCD_COVER_CODE(getClaimEstList().get(0).getTCE_CCD_COVER_CODE());
			try{
				
				/* added by raja on 18-08-2017 for ZBILQC-1722999 */
			/*paramList.clear();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_COVER_CODE());
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",null);
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","N");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN",controlBean.getM_LANG_CODE());		
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			List outParamList;
			try {
				outParamList = procHandler.execute(paramList, getConnection(), "P_VAL_COVER");
				OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
				PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_COVER_DESC_3(planDescPar.getValue());*/
			
String Query="select COVER_DESC from pm_il_cover where COVER_CODE=?";
ResultSet rs=new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_COVER_CODE()});
while(rs.next())
{
	PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_COVER_DESC_3(rs.getString("COVER_DESC"));
}

/*end*/
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public String M_BUT_HIST_WHEN_BUTTON_PRESSED(){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if(session.get("TREATY_CODE") == null || session.get("TREATY_CODE").toString().equals("")){
			PT_IL_TTY_CLAIM_EST_BEAN = claimEstList.get(0);
			session.put("TREATY_CODE", PT_IL_TTY_CLAIM_EST_BEAN.getTCE_TREATY_CODE());
			session.put("TCEH_CCD_SYS_ID", PT_IL_TTY_CLAIM_EST_BEAN.getTCE_CCD_SYS_ID());
		}
		return "RIDetails";
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC_3() {
		return COMP_UI_M_COVER_DESC_3;
	}

	public void setCOMP_UI_M_COVER_DESC_3(HtmlInputText comp_ui_m_cover_desc_3) {
		COMP_UI_M_COVER_DESC_3 = comp_ui_m_cover_desc_3;
	}
	
	public void getPT_IL_TTY_CLAIM_EST_Dtls(){
		PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = getPT_IL_FAC_CLAIM_EST_BEAN();
		String coverCode = PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE();
		String sysId = PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID();
		String selectQuery = null;
		if(coverCode != null || !"".equals(coverCode )){
			selectQuery = "SELECT ROWID,PT_IL_TTY_CLAIM_EST.* FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CCD_COVER_CODE = '" +coverCode+"' AND TCE_CLAIM_SYS_ID = "+sysId+"";
		}else{
			selectQuery = "SELECT ROWID,PT_IL_TTY_CLAIM_EST.* FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CLAIM_SYS_ID = "+sysId+"";
		}
		try {
			System.out.println("selectQuery--------------------------"+selectQuery);
			claimEstList = handler.fetch(selectQuery, "com.iii.pel.forms.PILT011.PT_IL_TTY_CLAIM_EST", getConnection());
			PT_IL_TTY_CLAIM_EST_POST_QUERY();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public PT_IL_FAC_CLAIM_EST getPT_IL_FAC_CLAIM_EST_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_EST_ACTION claimPaidAction = (PT_IL_FAC_CLAIM_EST_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_EST_ACTION");
		PT_IL_FAC_CLAIM_EST claimEstBean= null;
		if(claimPaidAction!=null){
			claimEstBean= claimPaidAction.getPT_IL_FAC_CLAIM_EST_BEAN();
		}else{
			claimPaidAction = new PT_IL_FAC_CLAIM_EST_ACTION();
			claimEstBean= claimPaidAction.getPT_IL_FAC_CLAIM_EST_BEAN();
		}
		return claimEstBean;
	}
	public void addRow(ActionEvent ae){
		claimEstList.add(new PT_IL_TTY_CLAIM_EST());
	}
	public void saveRecord() throws Exception{
		connection = getConnection();
		connection.commit();
	}

	public void COVER_CODERowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_CCD_COVER_CODE(value);
			dataColoumListener();
		}
	}

	public void TREATY_CODERowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_TREATY_CODE(value);
			dataColoumListener();
		}
	}

	public void UW_YEARRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			/* added by raja on 18-08-2017 for ZBILQC-1722999 */
			claimEstList.get(rowIndex).setTCE_UW_YEAR(Integer.parseInt(value));
			/*end*/
			dataColoumListener();
		}
	}

	public void CLAIM_LOSS_DTRowListener(ActionEvent actionEvent){
		//getCurrentValue(actionEvent);
		
		HtmlCalendar inputCalendar = (HtmlCalendar) actionEvent.getComponent().getParent();
		Date value = (Date) inputCalendar.getAsDate(inputCalendar.getSubmittedValue());
		
		if(value == null )
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_CLAIM_LOSS_DT(value);
			dataColoumListener();
		}
	}

	public void RETN_LC_CLM_ESTRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_RETN_LC_CLM_EST(Double.parseDouble(value));
			dataColoumListener();
		}
	}

	public void QS_LC_CLM_ESTRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_QS_LC_CLM_EST(Double.parseDouble(value));
			dataColoumListener();
		}
	}

	public void TCE_1S_LC_CLM_ESTRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_1S_LC_CLM_EST(Double.parseDouble(value));
			dataColoumListener();
		}
	}

	public void TCE_2S_LC_CLM_ESTRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_2S_LC_CLM_EST(Double.parseDouble(value));
			dataColoumListener();
		}
	}

	public void lastRowListener(ActionEvent actionEvent){
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String value = (String)inputText.getSubmittedValue();
		if(value == null || value.trim().isEmpty())
		{
			System.out.println("value should not be null");
		}
		else{
			int rowIndex = getTreatyTable().getRowIndex();
			claimEstList.get(rowIndex).setTCE_3S_LC_CLM_EST(Double.parseDouble(value));
			lastColomnListener();
		}
	}
	public void lastColomnListener(){
		PT_IL_FAC_CLAIM_EST claim_Est_Bean = getPT_IL_FAC_CLAIM_EST_BEAN();
		int curRowIdx = getTreatyTable().getRowIndex();
		claimEstList.get(curRowIdx).setTCE_CLAIM_SYS_ID(claim_Est_Bean.getFCE_CLAIM_SYS_ID());
		claimEstList.get(curRowIdx).setTCE_CCD_SYS_ID(Double.valueOf(claim_Est_Bean.getFCE_CCD_SYS_ID()));
		int updatedRow = 0;
		PT_IL_TTY_CLAIM_EST dtlBean = null;
		
		try{
			dtlBean = (PT_IL_TTY_CLAIM_EST)claimEstList.get(curRowIdx);
			if(dtlBean.getROWID()!=null){
				updatedRow = handler.executeUpdate(dtlBean, getConnection());
				
				getWarningMap().put("somekey", updatedRow+" record updated.");
				getWarningMap().put("current", updatedRow+" record updated.");
			}else{
				updatedRow = handler.executeInsert(dtlBean, getConnection());
				getWarningMap().put("somekey", updatedRow+" record updated.");
				getWarningMap().put("current", updatedRow+" record updated.");
			}
			lastRowIdx = curRowIdx;

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	public void dataColoumListener(){
		PT_IL_FAC_CLAIM_EST claim_Est_Bean = getPT_IL_FAC_CLAIM_EST_BEAN();
		int curRowIdx = getTreatyTable().getRowIndex();
		claimEstList.get(curRowIdx).setTCE_CLAIM_SYS_ID(claim_Est_Bean.getFCE_CLAIM_SYS_ID());
		claimEstList.get(curRowIdx).setTCE_CCD_SYS_ID(Double.valueOf(claim_Est_Bean.getFCE_CCD_SYS_ID()));
		int updatedRow = 0;
		PT_IL_TTY_CLAIM_EST dtlBean = null; 
		try{
			if(lastRowIdx!=-1){
				if(lastRowIdx!=prevRowIdx){
					if(prevRowIdx!=lastRowIdx){
						dtlBean = (PT_IL_TTY_CLAIM_EST)claimEstList.get(prevRowIdx);
						if(dtlBean.getROWID()!=null){
							updatedRow = handler.executeUpdate(dtlBean, getConnection());
							getWarningMap().put("somekey", updatedRow+" record updated.");
							getWarningMap().put("current", updatedRow+" record updated.");
						}else{
							updatedRow = handler.executeInsert(dtlBean, getConnection());
							getWarningMap().put("somekey", updatedRow+" record updated.");
							getWarningMap().put("current", updatedRow+" record updated.");
						}
						prevRowIdx = curRowIdx;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 18-02-2017*/
	public String UI_M_BUT_ESTIMATE_WHEN_BUTTON_PRESSED() {
		return "RIDetailsPage";
		
	}
	/*End*/
/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 17/02/2017*/
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			//resetSelectedRow();
			PT_IL_TTY_CLAIM_EST_BEAN = (PT_IL_TTY_CLAIM_EST) treatyTable
					.getRowData();
			PT_IL_TTY_CLAIM_EST_BEAN.setRowSelected(true);
			
			//resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
/*	private void resetSelectedRow() {
	Iterator<PT_IL_TTY_CLAIM_EST> PT_IL_TTY_CLAIM_EST_ITR = ClaimEstList
			.iterator();
	while (PT_IL_TTY_CLAIM_EST_ITR.hasNext()) {
		PT_IL_TTY_CLAIM_EST_ITR.next().setRowSelected(false);
	}
}*/
	
	private HtmlInputText COMP_UI_M_POL_NO_1;
	
	private HtmlInputText COMP_UI_M_CLM_NO_1;
	
	private HtmlOutputLabel COMP_UI_M_CLM_NO_1_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_POL_NO_1_LABEL;
	
	public HtmlOutputLabel getCOMP_UI_M_CLM_NO_1_LABEL() {
		return COMP_UI_M_CLM_NO_1_LABEL;
	}
	public void setCOMP_UI_M_CLM_NO_1_LABEL(HtmlOutputLabel cOMP_UI_M_CLM_NO_1_LABEL) {
		COMP_UI_M_CLM_NO_1_LABEL = cOMP_UI_M_CLM_NO_1_LABEL;
	}
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_1_LABEL() {
		return COMP_UI_M_POL_NO_1_LABEL;
	}
	public void setCOMP_UI_M_POL_NO_1_LABEL(HtmlOutputLabel cOMP_UI_M_POL_NO_1_LABEL) {
		COMP_UI_M_POL_NO_1_LABEL = cOMP_UI_M_POL_NO_1_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_POL_NO_1() {
		return COMP_UI_M_POL_NO_1;
	}
	public void setCOMP_UI_M_POL_NO_1(HtmlInputText cOMP_UI_M_POL_NO_1) {
		COMP_UI_M_POL_NO_1 = cOMP_UI_M_POL_NO_1;
	}
	public HtmlInputText getCOMP_UI_M_CLM_NO_1() {
		return COMP_UI_M_CLM_NO_1;
	}
	public void setCOMP_UI_M_CLM_NO_1(HtmlInputText cOMP_UI_M_CLM_NO_1) {
		COMP_UI_M_CLM_NO_1 = cOMP_UI_M_CLM_NO_1;
	}
	/*End*/
	/* added by raja on 18-08-2017 for ZBILQC-1722999 */
	
	private HtmlOutputLabel COMP_FCE_CLAIM_CURR_CODE_LABEL;
	private HtmlInputText COMP_FCE_CLAIM_CURR_CODE;
	private HtmlInputText COMP_UI_M_CURR_DESC_1;

	public HtmlOutputLabel getCOMP_FCE_CLAIM_CURR_CODE_LABEL() {
		return COMP_FCE_CLAIM_CURR_CODE_LABEL;
	}
	public void setCOMP_FCE_CLAIM_CURR_CODE_LABEL(
			HtmlOutputLabel cOMP_FCE_CLAIM_CURR_CODE_LABEL) {
		COMP_FCE_CLAIM_CURR_CODE_LABEL = cOMP_FCE_CLAIM_CURR_CODE_LABEL;
	}
	public HtmlInputText getCOMP_FCE_CLAIM_CURR_CODE() {
		return COMP_FCE_CLAIM_CURR_CODE;
	}
	public void setCOMP_FCE_CLAIM_CURR_CODE(HtmlInputText cOMP_FCE_CLAIM_CURR_CODE) {
		COMP_FCE_CLAIM_CURR_CODE = cOMP_FCE_CLAIM_CURR_CODE;
	}
	public HtmlInputText getCOMP_UI_M_CURR_DESC_1() {
		return COMP_UI_M_CURR_DESC_1;
	}
	public void setCOMP_UI_M_CURR_DESC_1(HtmlInputText cOMP_UI_M_CURR_DESC_1) {
		COMP_UI_M_CURR_DESC_1 = cOMP_UI_M_CURR_DESC_1;
	}
	
	/*end*/
	/*added by gopi for kic on 23/03/2019*/
	public int CVR_GROUP_CODE() {
		ArrayList<String> lovList = new ArrayList<String>();
		String query = "SELECT COUNT(*)COVER_COUNT FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID=? ";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		int cover_count=0;
		Long CLM_SYS_ID =Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString());
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			values = new Object[]{CLM_SYS_ID};
			resultSet = handler.executeSelectStatement(query, connection,values);
			while(resultSet.next()){
				cover_count=resultSet.getInt("COVER_COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cover_count;
	}
	
	//end
	
	
	
}

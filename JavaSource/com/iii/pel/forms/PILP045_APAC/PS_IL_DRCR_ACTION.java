package com.iii.pel.forms.PILP045_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_A_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_DRCR_ACTION extends CommonAction{

	private HtmlCommandButton preFormButton;

	private HtmlOutputLabel COMP_DRCR_CHQ_NO_LABEL;

	private HtmlInputText COMP_DRCR_CHQ_NO;

	private HtmlOutputLabel COMP_DRCR_CHQ_DT_LABEL;

	private HtmlCalendar COMP_DRCR_CHQ_DT;

	private HtmlOutputLabel COMP_DRCR_BANK_NAME_LABEL;

	private HtmlInputText COMP_DRCR_BANK_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_OK;

	private HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_CANCEL;

	private PS_IL_DRCR PS_IL_DRCR_BEAN;


	private String M_FILE;
	private String M_SYSDATE;
	private String M_TITLE;
	private String M_BASE_CURR;

	private String INSERT_PROPERTY;
	private String UPDATE_PROPERTY;
	private String DELETE_PROPERTY;	

	GNMNF002_A_APAC gnmfoo2_a_apac = null;
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Map<String,Object> session = null;
	String M_PARA_1;
	Connection con;
	BUTTON_PALETTE button_palette = null;
	CRUDHandler handler = new CRUDHandler();


	String blockName = null;
	boolean notifyValueChanged ;

	public PS_IL_DRCR_ACTION() {
		PS_IL_DRCR_BEAN = new PS_IL_DRCR();
		PRE_FORM();
	}

	public HtmlOutputLabel getCOMP_DRCR_CHQ_NO_LABEL() {
		return COMP_DRCR_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CHQ_NO() {
		return COMP_DRCR_CHQ_NO;
	}

	public void setCOMP_DRCR_CHQ_NO_LABEL(HtmlOutputLabel COMP_DRCR_CHQ_NO_LABEL) {
		this.COMP_DRCR_CHQ_NO_LABEL = COMP_DRCR_CHQ_NO_LABEL;
	}

	public void setCOMP_DRCR_CHQ_NO(HtmlInputText COMP_DRCR_CHQ_NO) {
		this.COMP_DRCR_CHQ_NO = COMP_DRCR_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_CHQ_DT_LABEL() {
		return COMP_DRCR_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DRCR_CHQ_DT() {
		return COMP_DRCR_CHQ_DT;
	}

	public void setCOMP_DRCR_CHQ_DT_LABEL(HtmlOutputLabel COMP_DRCR_CHQ_DT_LABEL) {
		this.COMP_DRCR_CHQ_DT_LABEL = COMP_DRCR_CHQ_DT_LABEL;
	}

	public void setCOMP_DRCR_CHQ_DT(HtmlCalendar COMP_DRCR_CHQ_DT) {
		this.COMP_DRCR_CHQ_DT = COMP_DRCR_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_DRCR_BANK_NAME_LABEL() {
		return COMP_DRCR_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_BANK_NAME() {
		return COMP_DRCR_BANK_NAME;
	}

	public void setCOMP_DRCR_BANK_NAME_LABEL(HtmlOutputLabel COMP_DRCR_BANK_NAME_LABEL) {
		this.COMP_DRCR_BANK_NAME_LABEL = COMP_DRCR_BANK_NAME_LABEL;
	}

	public void setCOMP_DRCR_BANK_NAME(HtmlInputText COMP_DRCR_BANK_NAME) {
		this.COMP_DRCR_BANK_NAME = COMP_DRCR_BANK_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PS_DRCR_OK() {
		return COMP_UI_M_BUT_PS_DRCR_OK;
	}

	public void setCOMP_UI_M_BUT_PS_DRCR_OK(HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_OK) {
		this.COMP_UI_M_BUT_PS_DRCR_OK = COMP_UI_M_BUT_PS_DRCR_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PS_DRCR_CANCEL() {
		return COMP_UI_M_BUT_PS_DRCR_CANCEL;
	}

	public void setCOMP_UI_M_BUT_PS_DRCR_CANCEL(HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_CANCEL) {
		this.COMP_UI_M_BUT_PS_DRCR_CANCEL = COMP_UI_M_BUT_PS_DRCR_CANCEL;
	}

	public PS_IL_DRCR getPS_IL_DRCR_BEAN() {
		return PS_IL_DRCR_BEAN;
	}

	public void setPS_IL_DRCR_BEAN(PS_IL_DRCR PS_IL_DRCR_BEAN) {
		this.PS_IL_DRCR_BEAN = PS_IL_DRCR_BEAN;
	}

	public HtmlCommandButton getPreFormButton() {
		return preFormButton;
	}

	public void setPreFormButton(HtmlCommandButton preFormButton) {
		this.preFormButton = preFormButton;
	}



	public Connection getConnection() throws Exception{
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
		}catch(Exception er){
			er.printStackTrace();
		}
		
		return connection;
	}

	public String getSystemDate(){
		String sysDate = null;
		ResultSet resultSet = null;
		try {
			String query = "SELECT TO_CHAR(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = executeQuery(query);
			while(resultSet.next()){
				sysDate = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The SYS Date == "+sysDate);
		return sysDate;
	}


	public String PRE_FORM(){
		ResultSet moduleResultSet = null;
		button_palette = new BUTTON_PALETTE();
		try{
			preFormButton = new HtmlCommandButton();
			gnmfoo2_a_apac =new GNMNF002_A_APAC();
			
			gnmfoo2_a_apac.executePreFormCursors();
			String moduleIDQuery = "SELECT * FROM MENU_MENUS WHERE MENU_ACTION LIKE 'PILP045_APAC'";
			moduleResultSet = executeQuery(moduleIDQuery);
			while(moduleResultSet.next()){
				System.out.println("The M_PARA_1 ONE IS [ "+moduleResultSet.getString("MENU_PARAMETER_1")+" ]");
				M_PARA_1 = moduleResultSet.getString("MENU_PARAMETER_1");
			}
			setM_PARA_1(M_PARA_1);
			//STD_PRE_FORM();	
			setM_SYSDATE(getSystemDate());
			moduleResultSet.close();
		}catch(Exception er){
			er.printStackTrace();
		}
		getPreFormButton().setDisabled(true);
		return null;
	}

	public String GET_APPLICATION_PROPERTY(String CURRENT_FORM){
		return "PILP045_APAC";
	}



	public void STD_PRE_FORM(){
		
		ControlBean controlBean = CommonUtils.getControlBean();
		try{
			button_palette.setM_RUN_DATE(getSystemDate());	
			button_palette.setM_COMP_NAME(gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_NAME").toString().substring(1,gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_COMP_NAME").toString().length()));
			controlBean.setM_SCR_NAME(gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_NAME").toString().substring(gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_COMP_NAME").toString().length()+1,gnmfoo2_a_apac.globalParameters().get("GLOBAL.M_SCR_NAME").toString().length()));
			this.session.put("GLOBAL.M_FAILURE", "FALSE");
			controlBean.setM_GOFLD_NAME(null);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+session.get("GLOBAL.M_DFLT_VALUES").toString().length());
			session.put("GLOBAL.M_MODULE_NAME","PILP045_APAC" );
			M_TITLE = controlBean.getM_USER_ID()+"  "+controlBean.getM_SCR_NAME()+"  "+getSystemDate(); 
			setM_TITLE(M_TITLE);
			getBLOCK_PROPERTY((String)session.get("GLOBAL.M_MODULE_NAME"));
		}catch(Exception er){
			er.printStackTrace();
		}
		WHEN_NEW_BLOCK_INSTANCE();
	}

	public void getBLOCK_PROPERTY(String BLOCK_NAME) {
		if(!"".equalsIgnoreCase(BLOCK_NAME)){
			setINSERT_PROPERTY(CHECK_BLOCK_PROPERTY(BLOCK_NAME,1, 1) ? "INSERT ALLOWED" : "INSERT NOT ALLOWED");
			setUPDATE_PROPERTY(CHECK_BLOCK_PROPERTY(BLOCK_NAME,2, 1) ? "UPDATE ALLOWED" : "UPDATE NOT ALLOWED");
			setDELETE_PROPERTY(CHECK_BLOCK_PROPERTY(BLOCK_NAME,2, 1) ? "DELETE ALLOWED" : "DELETE NOT ALLOWED");
		}else{
			System.out.println("No BLOCK NAME");
		}

		
	}

	public boolean CHECK_BLOCK_PROPERTY(String BLOCK_NAME,int startIndex,int length){
		if(BLOCK_NAME.substring(startIndex-1, (startIndex-1+length)).equals("Y")){
			return true;
		}else{
			return false;
		}
	}
		public void setBLOCK_PROPERTY(String block_property,String property_state) {
		
	}

	public void setFormTitle(String title){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			HtmlForm form = (HtmlForm) context.getViewRoot().findComponent("PS_IL_DRCR");
			if(form != null){
				form.setTitle("Sundara Pandian");
				form.setPrependId(true);
			}else{
				throw new Exception("NOTHING TO SET");
			}
		}catch(Exception er){
			er.printStackTrace();

		}
	}

	
	
	
	public void WHEN_NEW_BLOCK_INSTANCE(){
		EXECUTE_QUERY();
	}
	
	public void EXECUTE_QUERY(){
		CRUDHandler handler = new CRUDHandler();
		List queryResultList = null;
		String selectQuery = "SELECT * FROM PS_IL_DRCR WHERE DRCR_POL_NO LIKE '%TEST11011011%'";
		
		try{
		con = getConnection();
		System.out.println("The Select Query is ........................."+selectQuery);
		queryResultList = handler.fetch(selectQuery, "com.iii.pel.forms.PILP045_APAC.PS_IL_DRCR", con);
		if(queryResultList != null){
		for(Iterator iterator = queryResultList.iterator();iterator.hasNext();){
			PS_IL_DRCR_BEAN = (PS_IL_DRCR) iterator.next();
		}
		}else{
			throw new Exception("ERROR ON RESULTSET");
		}
		
		}catch(Exception er){
			er.printStackTrace();
		}
	}
	
	
	public void isValueChanged(ValueChangeEvent valueChangeEvent){
		String oldValue = (String)valueChangeEvent.getOldValue();
		String newValue = (String)valueChangeEvent.getNewValue();
		if(!oldValue.equals(newValue)){
			notifyValueChanged=true;
		}else {
			notifyValueChanged=false;
		}
	}
	
	public void okButtonListener(ActionEvent okButtonActionEvent){
		updateDatas();
	}
	
	public void cancelButtonListener(ActionEvent cancelButtonActionEvent ){
		System.out.println("-----------SECOND--------------");
		blockName = "PRINT";
		GO_BLOCK();
		
	}

	
	public String GO_BLOCK(){
		System.out.println("--------------------FIRST-------------------");
		if(!"".equals(blockName)){
			return "PRINT_BLOCK_FOUND";
		}
		return "BLOCK_NOT_FOUND";
	}
	
	public boolean updateDatas(){
		String updateQuery = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			con =  getConnection();
			if(notifyValueChanged == true){
				updateQuery = "UPDATE PS_IL_DRCR SET DRCR_CHQ_NO = '"+PS_IL_DRCR_BEAN.getDRCR_CHQ_NO()+"' , " +
				"DRCR_CHQ_DT ='"+convertDate(PS_IL_DRCR_BEAN.getDRCR_CHQ_DT())+"',DRCR_BANK_NAME = '"+PS_IL_DRCR_BEAN.getDRCR_BANK_NAME()+
				"' WHERE  DRCR_POL_SYS_ID = "+PS_IL_DRCR_BEAN.getDRCR_POL_SYS_ID()+" AND DRCR_END_NO_IDX " +
				"= "+PS_IL_DRCR_BEAN.getDRCR_END_NO_IDX();
				System.out.println("The UPDATE QUERY IS "+updateQuery);
				handler.executeUpdateStatement(updateQuery, con);
				con.commit();
			}
		}catch(Exception er){
			er.printStackTrace();
		}
		notifyValueChanged = false;
		return true;
	}
	
	public static String convertDate(java.util.Date d ) {
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(d).toString();
		return result;
	} 
	
	public ResultSet executeQuery(String query){
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			con = getConnection();
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
		}catch(Exception er){
			er.printStackTrace();
		}
		return resultSet;
	}


	public String getM_FILE() {
		return M_FILE;
	}

	public void setM_FILE(String m_file) {
		M_FILE = m_file;
	}

	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}

	public String getM_BASE_CURR() {
		return M_BASE_CURR;
	}

	public void setM_BASE_CURR(String m_base_curr) {
		M_BASE_CURR = m_base_curr;
	}

	public String getM_SYSDATE() {
		return M_SYSDATE;
	}

	public void setM_SYSDATE(String m_sysdate) {
		M_SYSDATE = m_sysdate;
	}

	public String getM_PARA_1() {
		return M_PARA_1;
	}

	public void setM_PARA_1(String m_para_1) {
		M_PARA_1 = m_para_1;
	}

	public String getINSERT_PROPERTY() {
		return INSERT_PROPERTY;
	}

	public void setINSERT_PROPERTY(String insert_property) {
		INSERT_PROPERTY = insert_property;
	}

	public String getUPDATE_PROPERTY() {
		return UPDATE_PROPERTY;
	}

	public void setUPDATE_PROPERTY(String update_property) {
		UPDATE_PROPERTY = update_property;
	}

	public String getDELETE_PROPERTY() {
		return DELETE_PROPERTY;
	}

	public void setDELETE_PROPERTY(String delete_property) {
		DELETE_PROPERTY = delete_property;
	}

}

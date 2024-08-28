package com.iii.premia.common.notes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlAjaxRepeat;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.UISuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.MailManager.MailCreater;
import com.iii.pel.forms.MailManager.MailVO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class NotesAction extends CommonAction{
	
	private List <PCOM_NOTES_MASTER>      dataTableList;
	private UIDataTable              dataTableComponent;
	
	private HtmlAjaxRepeat ajaxRepeat;
	
	private final int                maxUploadsAllowed    = 20;
	private int                      currPage;
	private int                      recordsPerPage       = 5;
	private String                   remarksContent;
	private String                   seperator;
	
	//Fields for navigation
	private String                   transactionId;
	private String                   screenId;
	private String                   outCome;
	Map<String, String>              errorMap;
	
	private final int modalPanelHeight=200;
	private final int modalPanelWidth=180;
	
	private PCOM_NOTES_MASTER notes;
	
	public NotesAction(){
		notes = new PCOM_NOTES_MASTER();
		dataTableList = new ArrayList<PCOM_NOTES_MASTER>();
		
	}
	
	/*public NotesAction
		(String transactionId, String transactionType, String outCome, Map<String, String> errorMap){
		
		this.transactionId=transactionId;
		this.transactionType=transactionType;
		this.outCome=outCome;
		this.errorMap=errorMap;
		currPage=1;
		CommonUtils.setGlobalObject("NotesActionBean", this);
	}*/
	
	
	public void prepareUploadedNotesList() throws Exception{
		
		NotesDelegate delegate=new NotesDelegate();
		this.dataTableList=delegate.getUploadedNotesData(screenId,transactionId);
		for(PCOM_NOTES_MASTER notesBean : dataTableList){
			delegate.getTaggedUserDataList(notesBean);
		}
		delegate.defaultDistinctTaggedUser(screenId, transactionId, this);
	}
	
	public String goToNotes(){
		String returnString=null;
		FacesContext context = FacesContext.getCurrentInstance();
		outCome = FacesContext.getCurrentInstance(). getExternalContext()
		.getRequestParameterMap().get("returnPageOutcome");
		screenId = FacesContext.getCurrentInstance(). getExternalContext()
		.getRequestParameterMap().get("screenId");
		transactionId = FacesContext.getCurrentInstance(). getExternalContext()
		.getRequestParameterMap().get("transactionId");
		/*Map<String, Object> map = context.getExternalContext().getSessionMap();
		Object menuAction = map.get("GLOBAL.MENU_ACTION");*/
		try {
			if(transactionId!= null && !transactionId.trim().isEmpty()){
				returnString = "gotoNotes";
				prepareUploadedNotesList();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(errorMap!=null){
				errorMap.put("current",e.getMessage());
				errorMap.put("someKey",e.getMessage());
				returnString=null;
			}
		}
		return returnString;
	}
	
	public String goBack(){
		// Remove Action bean from Session before back to Calling page
		new CommonUtils().getSession().removeAttribute("NotesActionBean");
		return outCome;
	}
	
	
	public int getMaxUploadsAllowed() {
		
		return maxUploadsAllowed;
	}
	
	public List<PCOM_NOTES_MASTER> getDataTableList() {
		
		return dataTableList;
	}

	public void setDataTableList(List<PCOM_NOTES_MASTER> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIDataTable getDataTableComponent() {
		return dataTableComponent;
	}

	public void setDataTableComponent(UIDataTable dataTableComponent) {
		this.dataTableComponent = dataTableComponent;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
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
	
	public void setRemark(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String remarks=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTableComponent.getRowIndex();
		PCOM_NOTES_MASTER valueBean=(PCOM_NOTES_MASTER)dataTableList.get(currentIndex);
		valueBean.setPNM_NOTES_CONTENT(remarks);
	}
	
	public int getModalPanelHeight() {
		return modalPanelHeight;
	}

	public int getModalPanelWidth() {
		return modalPanelWidth;
	}

	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = "";
		//int rowIndex = dataTableComponent.getRowIndex();
		Connection connection = null;
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet = null;
		int count = 0;
		try{
			connection = CommonUtils.getConnection();
			if(notes.getROWID() == null){
				resultSet = handler.executeSelectStatement(Notes_QueryConstants.preInsert_Query, connection);
				if(resultSet.next()){
					notes.setPNM_SYS_ID(resultSet.getLong(1));
				}
				notes.setPNM_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				notes.setPNM_SCREEN_ID(screenId);
				notes.setPNM_TRANSACTION_ID(transactionId);
				notes.setPNM_CR_TIMESTAMP(new CommonUtils().getCurrentDate());
				handler.executeInsert(notes, connection);
				for(PCOM_NOTES_TAGGED_USERS tempBean : notes.getTaggedUsersList()){
					tempBean.setPNTU_SYS_ID(notes.getPNM_SYS_ID());
					tempBean.setPNTU_SEQ_NO(1);
					handler.executeInsert(tempBean, connection);
				}
				dataTableList.add(0,notes);
				connection.commit();
				manageEmail(notes);
				setNotes(new PCOM_NOTES_MASTER());
				getNotes().setTaggedUsersList(new ArrayList<PCOM_NOTES_TAGGED_USERS>());
				new NotesDelegate().defaultDistinctTaggedUser(screenId, transactionId, this);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
				getWarningMap().put("saveCurrentRecord",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
				
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put("current", exc.getMessage());
		}
		return outcome;
	}

	public String getRemarksContent() {
		return remarksContent;
	}

	public void setRemarksContent(String remarksContent) {
		this.remarksContent = remarksContent;
	}

	public PCOM_NOTES_MASTER getNotes() {
		return notes;
	}

	public void setNotes(PCOM_NOTES_MASTER notes) {
		this.notes = notes;
	}
	
	//LOV
	public List<LovBean> lovUser_List(Object obj) throws Exception{
		String user = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if("*".equals(user)){
			object = new Object[]{};
			query = Notes_QueryConstants.USER_LIST_LOV;
		}else{
			object = new Object[]{user+"%",user+"%"};
			query = Notes_QueryConstants.USER_LIST_LOV_LIKE;
		}
		suggestionList = new NotesDelegate().prepareLovList(getLovQuery(query, notes.getTaggedUsersList()), object);
		return suggestionList;
	}
	
	 private String getLovQuery(String query, ArrayList<PCOM_NOTES_TAGGED_USERS> arrayList) {
	        Object[] strArr = arrayList.toArray();
	        String temp="";
	        if(arrayList.size()>0) {
	            for(int i=0;i<strArr.length;i++) {
	            	String userID = ((PCOM_NOTES_TAGGED_USERS)strArr[i]).getPNTU_TAGGED_USER();
	                if(i!=strArr.length-1)
	                    temp = temp+"'"+userID+"',";
	                else
	                    temp = temp+"'"+userID+"'";
	            }
	            query = query + " AND USER_ID  NOT IN ("+temp+")";
	        }
	        return query;
	    }
	
	public void userList_ActionListener(ActionEvent event) {
		UISuggestionBox suggestionBox = ((UISuggestionBox)event.getComponent().getParent());
		LovBean lovBean = (LovBean) ((UISuggestionBox)event.getComponent().getParent()).getRowData();
		PCOM_NOTES_TAGGED_USERS taggedUserBean = new PCOM_NOTES_TAGGED_USERS();
		taggedUserBean.setPNTU_TAGGED_USER(lovBean.getLovCode());
		this.getNotes().getTaggedUsersList().add(taggedUserBean);
		
		//Commented By Amit Kumar , the same is Handled In LOV query itself to suppress the tagged user in LOV itself
		/*if(getNotes().getTaggedUsersList().size() > 0){
			for(PCOM_NOTES_TAGGED_USERS userBean : getNotes().getTaggedUsersList()){
				if(userBean.getPNTU_TAGGED_USER().equals(lovBean.getLovCode())){
					getWarningMap().put("Current", "User Already Tagged ! ");
					getWarningMap().put("userList_ActionListener", "User Already Tagged ! ");
				}else{
					PCOM_NOTES_TAGGED_USERS taggedUserBean = new PCOM_NOTES_TAGGED_USERS();
					taggedUserBean.setPNTU_TAGGED_USER(lovBean.getLovCode());
					this.getNotes().getTaggedUsersList().add(taggedUserBean);
				}
			}
		}else{
			PCOM_NOTES_TAGGED_USERS taggedUserBean = new PCOM_NOTES_TAGGED_USERS();
			taggedUserBean.setPNTU_TAGGED_USER(lovBean.getLovCode());
			this.getNotes().getTaggedUsersList().add(taggedUserBean);
		}*/
		
		HtmlInputText inputText = (HtmlInputText) suggestionBox.getParent().findComponent(suggestionBox.getFor());
		inputText.setSubmittedValue("");
		inputText.resetValue();
	}
	
	public void onDelete(ActionEvent event){
		//getAjaxRepeat().getValue();
		this.getNotes().getTaggedUsersList().remove(getAjaxRepeat().getRowIndex());
	}

	public HtmlAjaxRepeat getAjaxRepeat() {
		return ajaxRepeat;
	}

	public void setAjaxRepeat(HtmlAjaxRepeat ajaxRepeat) {
		this.ajaxRepeat = ajaxRepeat;
	}
	
	public ArrayList<String> getUserMailIdList(PCOM_NOTES_MASTER notesBean) throws Exception{
		ArrayList<String> mailList = new ArrayList<String>();
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String userEmail = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			for(PCOM_NOTES_TAGGED_USERS taggedUserBean : notesBean.getTaggedUsersList()){
				resultSet = handler.executeSelectStatement(Notes_QueryConstants.USER_MAIL_ID, 
						connection, new Object[]{taggedUserBean.getPNTU_TAGGED_USER()});
				if(resultSet.next()){
					userEmail = resultSet.getString(1);
				}
				mailList.add(userEmail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mailList;
	}
	
	public void manageEmail(PCOM_NOTES_MASTER notesBean) throws Exception {

		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;

		String docNo = null;
		MailVO mailVO = null;
		MailCreater creater = new MailCreater();;

		try {
			connection = CommonUtils.getConnection();

			mailVO = new MailVO();
			if(notesBean.getTaggedUsersList()!= null 
					&& notesBean.getTaggedUsersList().size() > 0){
				List<String> list = new ArrayList<String>();
				list.addAll(getUserMailIdList(notesBean));
				list.add(getUnderWriterMailId());
				mailVO.setToList(list);
			}
			mailVO.setBccList(null);
			mailVO.setCcList(null);

			mailVO.setSubject(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.subject"));
			mailVO.setTitle(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.title"));
			mailVO.setLocation(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.location"));
			//mailVO.setEventFromDate(CommonUtils.addDaysToDate(notesBean.getPOL_PPW_EFF_TO_DT(), -4));
			//mailVO.setEventToDate(notesBean.getPOL_PPW_EFF_TO_DT());
			mailVO.setDescription(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.description", new Object[] {screenId, transactionId }));
			mailVO.setFileList(null);
			mailVO.setFromId(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.from.id"));
			mailVO.setFromName(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.from.name"));
			mailVO.setMessageBody(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.body", new Object[] {screenId, transactionId }));
			mailVO.setPriority(Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.remarks.priority"));

			creater.sendMail(mailVO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			CommonUtils.closeCursor(resultSet3);
			CommonUtils.closeCursor(resultSet4);
		}

	}

	/**
	 * Prepares and return split mails separated with ';'
	 * @param combinedMailIds ';' separated mail ids as String
	 * @return	ArrayList<String>	list of mails
	 */
	public ArrayList<String> prepareMailList(String combinedMailIds){
		ArrayList<String> mailList = new ArrayList<String>();
		StringTokenizer tokenizer = null;
		String delimeter = ";";

		if(combinedMailIds != null){
			tokenizer = new StringTokenizer(combinedMailIds, delimeter);
			while(tokenizer.hasMoreTokens()){
				mailList.add(tokenizer.nextToken());
			}
		}

		return mailList;
	}

	public String getUnderWriterMailId(){
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String userMailId = null;
		String userId = null;
		String query = "SELECT USER_EMAIL FROM MENU_USER WHERE USER_ID=?";

		try {
			connection = CommonUtils.getConnection();
			userId = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			if(userId != null){
				resultSet = handler.executeSelectStatement(query, connection, 
						new Object[]{userId});
				if(resultSet.next()){
					userMailId = resultSet.getString("USER_EMAIL");
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userMailId;
	}

	public String getSeperator() {
		return seperator;
	}

	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
}

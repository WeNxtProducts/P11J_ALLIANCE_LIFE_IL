package com.iii.premia.common.notes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.PhaseEvent;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;

public class NotesHomeAction extends CommonAction{
	
	private List <PCOM_NOTES_MASTER>      dataTableList;
	private UIDataTable              dataTableComponent;
	
	private String                   remarksContent;
	private String                   seperator;
	
	
	private PCOM_NOTES_MASTER notesBean;
	
	public PCOM_NOTES_MASTER getNotesBean() {
		return notesBean;
	}

	public void setNotesBean(PCOM_NOTES_MASTER notesBean) {
		this.notesBean = notesBean;
	}

	public NotesHomeAction(){
		notesBean = new PCOM_NOTES_MASTER();
		dataTableList = new ArrayList<PCOM_NOTES_MASTER>();
		
	}
	
	public void prepareUploadedNotesList() throws Exception{
		NotesDelegate delegate=new NotesDelegate();
		this.dataTableList=delegate.getApplicableNotesData();
		if(dataTableList != null && dataTableList.size() > 0){
			for(PCOM_NOTES_MASTER notesBean : dataTableList){
				delegate.getTaggedUserDataList(notesBean);
			}
		}
	}
	
	public UIDataTable getDataTableComponent() {
		return dataTableComponent;
	}

	public void setDataTableComponent(UIDataTable dataTableComponent) {
		this.dataTableComponent = dataTableComponent;
	}

	public List<PCOM_NOTES_MASTER> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PCOM_NOTES_MASTER> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public String getRemarksContent() {
		return remarksContent;
	}

	public void setRemarksContent(String remarksContent) {
		this.remarksContent = remarksContent;
	}

	public String getSeperator() {
		return seperator;
	}

	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
	
	public void onLoad(PhaseEvent event){
		try {
			prepareUploadedNotesList();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}
}

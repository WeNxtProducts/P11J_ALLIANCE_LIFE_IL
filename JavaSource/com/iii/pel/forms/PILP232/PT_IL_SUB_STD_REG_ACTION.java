package com.iii.pel.forms.PILP232;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIScrollableDataTable;
import org.richfaces.component.html.HtmlFileUpload;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class  PT_IL_SUB_STD_REG_ACTION extends CommonAction{

	private HtmlFileUpload COMP_FILE_PATH;
	private HtmlOutputLabel COMP_FILE_PATH_LABEL;
	private HtmlAjaxCommandButton COMP_UI_M_BUT_EMP_UPLOAD;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_UPLOAD;
	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private HtmlPanelGroup COMP_TOTAL_RECORDS;

	private PT_IL_SUB_STD_REG_DTLS PT_IL_SUB_STD_REG_DTLS_BEAN;


	private Boolean UPLOAD_DISABLE = true;
	private Boolean PROCESS_DISABLE = true;


	public HtmlPanelGroup getCOMP_TOTAL_RECORDS() {
		return COMP_TOTAL_RECORDS;
	}

	public void setCOMP_TOTAL_RECORDS(HtmlPanelGroup cOMP_TOTAL_RECORDS) {
		COMP_TOTAL_RECORDS = cOMP_TOTAL_RECORDS;
	}


	private UIScrollableDataTable dataTable;

	public UIScrollableDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIScrollableDataTable dataTable) {
		this.dataTable = dataTable;
	}


	private List<PT_IL_SUB_STD_REG> subStdDataList = new ArrayList<PT_IL_SUB_STD_REG>();

	
	public List<PT_IL_SUB_STD_REG> getSubStdDataList() {
		return subStdDataList;
	}

	public void setSubStdDataList(List<PT_IL_SUB_STD_REG> subStdDataList) {
		this.subStdDataList = subStdDataList;
	}

	public PT_IL_SUB_STD_REG_ACTION() {
		// TODO Auto-generated constructor stub
		PT_IL_SUB_STD_REG_DTLS_BEAN=new PT_IL_SUB_STD_REG_DTLS();
		instantiateAllComponent();
	} 


	public HtmlFileUpload getCOMP_FILE_PATH() {
		return COMP_FILE_PATH;
	}
	public void setCOMP_FILE_PATH(HtmlFileUpload comp_file_path) {
		COMP_FILE_PATH = comp_file_path;
	}
	public HtmlOutputLabel getCOMP_FILE_PATH_LABEL() {
		return COMP_FILE_PATH_LABEL;
	}
	public void setCOMP_FILE_PATH_LABEL(HtmlOutputLabel comp_file_path_label) {
		COMP_FILE_PATH_LABEL = comp_file_path_label;
	}
	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_EMP_UPLOAD() {
		return COMP_UI_M_BUT_EMP_UPLOAD;
	}
	public void setCOMP_UI_M_BUT_EMP_UPLOAD(
			HtmlAjaxCommandButton comp_ui_m_but_emp_upload) {
		COMP_UI_M_BUT_EMP_UPLOAD = comp_ui_m_but_emp_upload;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_OCC_UPLOAD() {
		return COMP_UI_M_BUT_OCC_UPLOAD;
	}
	public void setCOMP_UI_M_BUT_OCC_UPLOAD(
			HtmlCommandButton comp_ui_m_but_occ_upload) {
		COMP_UI_M_BUT_OCC_UPLOAD = comp_ui_m_but_occ_upload;
	}

	public void uploadButtonAction() {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();

		//	PP_UPLOAD_FILE_DTLS_HELPER helper = new PP_UPLOAD_FILE_DTLS_HELPER();
		//	System.out.println("FILE "+PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH().toString() );
		PT_IL_SUB_STD_REG_HELPER pw_il_upload_helper = new PT_IL_SUB_STD_REG_HELPER();
		try {
			if(PT_IL_SUB_STD_REG_DTLS_BEAN.getFILE_PATH()!=null) {
				pw_il_upload_helper.UPLOAD_WBP(this);

			}
			else if(PT_IL_SUB_STD_REG_DTLS_BEAN.getFILE_PATH()==null){
				//setPROCESS_DISABLE(true);
			}
			setUPLOAD_DISABLE(true);			
			// .readExcelFile(	PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH().toString() );
			message = "Uploaded Successfully..";
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Upload", message);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UPLOAD",
					e.getMessage());
		}

		//return message;
	}
	
	public void uploadButtonAction(ActionEvent ae) {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();

		//	PP_UPLOAD_FILE_DTLS_HELPER helper = new PP_UPLOAD_FILE_DTLS_HELPER();
		//	System.out.println("FILE "+PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH().toString() );
		PT_IL_SUB_STD_REG_HELPER pw_il_upload_helper = new PT_IL_SUB_STD_REG_HELPER();
		try {
			if(PT_IL_SUB_STD_REG_DTLS_BEAN.getFILE_PATH()!=null) {
				pw_il_upload_helper.UPLOAD_WBP(this);

			}
			else if(PT_IL_SUB_STD_REG_DTLS_BEAN.getFILE_PATH()==null){
				//setPROCESS_DISABLE(true);
			}
			setUPLOAD_DISABLE(true);			
			// .readExcelFile(	PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH().toString() );
			message = "Uploaded Successfully..";
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Upload", message);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UPLOAD",
					e.getMessage());
		}

		//return message;
	}

	public String  processButtonAction() {
		String outCome=null;
		try {
			if("PGLT002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
				CommonUtils.setGlobalVariable("CALLING_FORM", "PGLT002");
				CommonUtils.setGlobalVariable("SUB_CALLING_FORM", "PGLP050_APAC");
			}
			else{
				CommonUtils.setGlobalVariable("GLOBAL.M_POLICY_NO",null);
				CommonUtils.setGlobalVariable("CALLING_FORM", "PGLP050_APAC");
			}
			outCome = "PGLP038_APAC";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROCESS",
					e.getMessage());
		}

		return outCome;
	}


	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				setSubStdDataList(new ArrayList<PT_IL_SUB_STD_REG>());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void uploadListener(UploadEvent event){
		CommonUtils.clearMaps(this);
		UploadItem item =  event.getUploadItem();

		if(item.getFileName()!=null){
			PT_IL_SUB_STD_REG_DTLS_BEAN.setFILE_PATH(item.getFile());
			PT_IL_SUB_STD_REG_DTLS_BEAN.setFILE_NAME(item.getFileName());
			setUPLOAD_DISABLE(false);	
			//setPROCESS_DISABLE(false);
		} else {
			setUPLOAD_DISABLE(true);
		}
	}

	public void clearUploadData(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		PT_IL_SUB_STD_REG_DTLS_BEAN = new PT_IL_SUB_STD_REG_DTLS();
		subStdDataList = new ArrayList<PT_IL_SUB_STD_REG>();
		System.out.println("subStdDataList size           "+subStdDataList.size());
		setUPLOAD_DISABLE(true);
		setPROCESS_DISABLE(true);
	}

	public String clearUploadData() {
		PT_IL_SUB_STD_REG_DTLS_BEAN = new PT_IL_SUB_STD_REG_DTLS();
		setUPLOAD_DISABLE(true);
		setPROCESS_DISABLE(true);
		return null;
	}
	public Boolean getUPLOAD_DISABLE() {
		return UPLOAD_DISABLE;
	}
	public void setUPLOAD_DISABLE(Boolean upload_disable) {
		UPLOAD_DISABLE = upload_disable;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}
	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}
	public Boolean getPROCESS_DISABLE() {
		return PROCESS_DISABLE;
	}
	public void setPROCESS_DISABLE(Boolean process_disable) {
		PROCESS_DISABLE = process_disable;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}
	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public PT_IL_SUB_STD_REG_DTLS getPT_IL_SUB_STD_REG_DTLS_BEAN() {
		return PT_IL_SUB_STD_REG_DTLS_BEAN;
	}


	public void setPT_IL_SUB_STD_REG_DTLS_BEAN(
			PT_IL_SUB_STD_REG_DTLS pT_IL_SUB_STD_REG_DTLS_BEAN) {
		PT_IL_SUB_STD_REG_DTLS_BEAN = pT_IL_SUB_STD_REG_DTLS_BEAN;
	}

	
		

	public void instantiateAllComponent(){
		COMP_FILE_PATH=new HtmlFileUpload();
		COMP_FILE_PATH_LABEL=new HtmlOutputLabel();
		COMP_UI_M_BUT_EMP_UPLOAD =new HtmlAjaxCommandButton();
		COMP_UI_M_BUT_OCC_UPLOAD =new HtmlCommandButton();
		COMP_UI_M_BUT_PROCESS =new HtmlCommandButton();
		COMP_UI_M_BUT_MAIN=new HtmlCommandButton();
	}


}

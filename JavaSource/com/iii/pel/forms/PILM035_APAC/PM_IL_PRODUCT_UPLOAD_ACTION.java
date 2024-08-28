package com.iii.pel.forms.PILM035_APAC;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlFileUpload;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import com.iii.pel.forms.PILP017.PW_IL_UPLOAD_FILE_DTLS;
import com.iii.pel.forms.PILP017.PW_IL_UPLOAD_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PRODUCT_UPLOAD_ACTION extends CommonAction {
	
	
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;
	
	

	
	private HtmlFileUpload COMP_FILE_PATH;
	private HtmlOutputLabel COMP_FILE_PATH_LABEL;
	private HtmlAjaxCommandButton COMP_UI_M_BUT_EMP_UPLOAD;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_UPLOAD;
	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;
	
	private PM_IL_PROD_UPLOAD_FILE_DTLS PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN;
	private PM_IL_PROD_UPLOAD_HELPER PM_IL_PROD_UPLOAD_HELPER_BEAN;
	
	private Boolean UPLOAD_DISABLE = true;
	private Boolean PROCESS_DISABLE = true;
	
	public PM_IL_PRODUCT_UPLOAD_ACTION() {
		// TODO Auto-generated constructor stub
		PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN=new PM_IL_PROD_UPLOAD_FILE_DTLS();
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
	
	public String uploadButtonAction() {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		

		PM_IL_PROD_UPLOAD_HELPER PM_IL_PROD_UPLOAD_HELPER_BEAN = new PM_IL_PROD_UPLOAD_HELPER();
		try {
			
			if(PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH()!=null) {
				PM_IL_PROD_UPLOAD_HELPER_BEAN.UPLOAD_WBP(this);
				
			}
			else if(PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH()==null){
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
		
		return message;
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
	public String mainButtonAction(){
		String outCome="";
		try{
			  if("PGLT002".equals(CommonUtils.getGlobalVariable("CALLING_FORM")) &&
			                         CommonUtils.getGlobalVariable("GLOBAL.M_POLICY_NO") != null ){
			
				outCome ="policyEntry";
			}
			 
		}catch(Exception e){
			e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			 getErrorMap().put("MAIN", e.getMessage());
			
		}
		return outCome;
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
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
			PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.setFILE_PATH(item.getFile());
			PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.setFILE_NAME(item.getFileName());
			 setUPLOAD_DISABLE(false);	
			 //setPROCESS_DISABLE(false);
		} else {
			setUPLOAD_DISABLE(true);
		}
	}
	
	public void clearUploadData(ActionEvent actionEvent) {
		 CommonUtils.clearMaps(this);
		 PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN = new PM_IL_PROD_UPLOAD_FILE_DTLS();
		 setUPLOAD_DISABLE(true);
		 setPROCESS_DISABLE(true);
	}
	
	 public String clearUploadData() {
		 PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN = new PM_IL_PROD_UPLOAD_FILE_DTLS();
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

	public PM_IL_PROD_UPLOAD_FILE_DTLS getPM_IL_PROD_UPLOAD_FILE_DTLS_BEAN() {
		return PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN;
	}


	public void setPM_IL_PROD_UPLOAD_FILE_DTLS_BEAN(
			PM_IL_PROD_UPLOAD_FILE_DTLS pM_IL_PROD_UPLOAD_FILE_DTLS_BEAN) {
		PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN = pM_IL_PROD_UPLOAD_FILE_DTLS_BEAN;
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


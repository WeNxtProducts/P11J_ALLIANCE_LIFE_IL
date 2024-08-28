package com.iii.pel.forms.PP100_1APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PP_UPLOAD_FILE_DTLS_ACTION extends CommonAction {

	
	private HtmlOutputLabel COMP_FILE_PATH_LABEL;
	
	private PP_UPLOAD_FILE_DTLS PP_UPLOAD_FILE_DTLS_BEAN;

	public PP100_1APAC_COMPOSITE_ACTION compositeAction;

	private PP_UPLOAD_FILE_DTLS_HELPER helper;

	public PP_UPLOAD_FILE_DTLS_ACTION() {

		PP_UPLOAD_FILE_DTLS_BEAN = new PP_UPLOAD_FILE_DTLS();
		helper = new PP_UPLOAD_FILE_DTLS_HELPER();
	}

	public PP_UPLOAD_FILE_DTLS getPP_UPLOAD_FILE_DTLS_BEAN() {
		return PP_UPLOAD_FILE_DTLS_BEAN;
	}

	public void setPP_UPLOAD_FILE_DTLS_BEAN(
			PP_UPLOAD_FILE_DTLS PP_UPLOAD_FILE_DTLS_BEAN) {
		this.PP_UPLOAD_FILE_DTLS_BEAN = PP_UPLOAD_FILE_DTLS_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPP_UPLOAD_FILE_DTLS_BEAN().getROWID() != null) {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_FILE_PATH_LABEL() {
		return COMP_FILE_PATH_LABEL;
	}

	public void setCOMP_FILE_PATH_LABEL(HtmlOutputLabel comp_file_path_label) {
		COMP_FILE_PATH_LABEL = comp_file_path_label;
	}
	
	public void uploadListener(UploadEvent event){
		 CommonUtils.clearMaps(this);
		UploadItem item =  event.getUploadItem();

		if(item.getFileName()!=null){
			PP_UPLOAD_FILE_DTLS_BEAN.setFILE_PATH(item.getFile());
			PP_UPLOAD_FILE_DTLS_BEAN.setFILE_NAME(item.getFileName());
			 //setUPLOAD_DISABLE(false);	
			 //setPROCESS_DISABLE(false);
		} else {
			//setUPLOAD_DISABLE(true);
		}
	}
	
	public void clearUploadData(ActionEvent actionEvent) {
		 CommonUtils.clearMaps(this);
		 PP_UPLOAD_FILE_DTLS_BEAN = new PP_UPLOAD_FILE_DTLS();
		 //setUPLOAD_DISABLE(true);
		 //setPROCESS_DISABLE(true);
	}

	
	
	public String UploadData(){
		System.out.println("Inside Upload Button 1");
		if(PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH() != null){
			try {
				helper.INSERT_XL_PW_TABLES(PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH() ,this);
				CommonUtils.doComitt();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Completed Successfully");
				getWarningMap().put("CURRENT", "Process Completed Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}
		}else{
			
		}
		return "";
	}
	
}

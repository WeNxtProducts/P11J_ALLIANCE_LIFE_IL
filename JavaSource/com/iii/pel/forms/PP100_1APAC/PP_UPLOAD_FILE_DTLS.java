package com.iii.pel.forms.PP100_1APAC;

import java.io.File;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_UPLOAD_FILE_DTLS")
public class PP_UPLOAD_FILE_DTLS extends BaseValueBean {

	@Column(name="UFD_FORMAT_ID")
	private String UFD_FORMAT_ID;

	@Column(name="UFD_FORMAT_DESC")
	private String UFD_FORMAT_DESC;

	@Column(name="UFD_FILE_TYPE")
	private String UFD_FILE_TYPE;

	@Column(name="UFD_DELIMETER")
	private String UFD_DELIMETER;

	@Column(name="UFD_DEST_TABLE")
	private String UFD_DEST_TABLE;

	@Column(name="UFD_DATE_FORMAT")
	private String UFD_DATE_FORMAT;

	@Column(name="UFD_TAB_TYPE")
	private String UFD_TAB_TYPE;
	
	private File FILE_PATH;
	private String FILE_NAME;
	
	private int length ;

	public void setUFD_FORMAT_ID(String UFD_FORMAT_ID) {
		this.UFD_FORMAT_ID = UFD_FORMAT_ID;
	}
	public String getUFD_FORMAT_ID() {
		 return UFD_FORMAT_ID;
	}
	public void setUFD_FILE_TYPE(String UFD_FILE_TYPE) {
		this.UFD_FILE_TYPE = UFD_FILE_TYPE;
	}
	public String getUFD_FILE_TYPE() {
		 return UFD_FILE_TYPE;
	}
	public void setUFD_FORMAT_DESC(String UFD_FORMAT_DESC) {
		this.UFD_FORMAT_DESC = UFD_FORMAT_DESC;
	}
	public String getUFD_FORMAT_DESC() {
		 return UFD_FORMAT_DESC;
	}
	public void setUFD_DATE_FORMAT(String UFD_DATE_FORMAT) {
		this.UFD_DATE_FORMAT = UFD_DATE_FORMAT;
	}
	public String getUFD_DATE_FORMAT() {
		 return UFD_DATE_FORMAT;
	}
	public void setUFD_TAB_TYPE(String UFD_TAB_TYPE) {
		this.UFD_TAB_TYPE = UFD_TAB_TYPE;
	}
	public String getUFD_TAB_TYPE() {
		 return UFD_TAB_TYPE;
	}
	public void setUFD_DEST_TABLE(String UFD_DEST_TABLE) {
		this.UFD_DEST_TABLE = UFD_DEST_TABLE;
	}
	public String getUFD_DEST_TABLE() {
		 return UFD_DEST_TABLE;
	}
	public String getUFD_DELIMETER() {
		return UFD_DELIMETER;
	}
	public void setUFD_DELIMETER(String ufd_delimeter) {
		UFD_DELIMETER = ufd_delimeter;
	}
	public File getFILE_PATH() {
		return FILE_PATH;
	}
	public void setFILE_PATH(File file_path) {
		FILE_PATH = file_path;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String file_name) {
		FILE_NAME = file_name;
	}
	public int getLength() {
        if ( getFILE_NAME().length()>0){
            return getFILE_NAME().length();
        }else 
        {
            return 0;
        }
    }
	
	public void setLength(int length) {
		this.length = length;
	}
	

}
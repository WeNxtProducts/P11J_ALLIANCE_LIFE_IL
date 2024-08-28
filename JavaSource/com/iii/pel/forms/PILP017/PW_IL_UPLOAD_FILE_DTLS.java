package com.iii.pel.forms.PILP017;

import java.io.File;

import com.iii.premia.common.bean.BaseValueBean;

public class PW_IL_UPLOAD_FILE_DTLS extends BaseValueBean{

	private String UFD_FORMAT_ID;                                                                                                                                                                                  
	private String UFD_FORMAT_DESC;                                                                                                                                                                                
	private String UFD_FILE_TYPE;                                                                                                                                                                                  
	private String UFD_DELIMETER ;                                                                                                                                                                                       
	private String UFD_DEST_TABLE;                                                                                                                                                                                  
	private String UFD_DATE_FORMAT;                                                                                                                                                                                  
	private String UFD_TAB_TYPE ;
	private int length ;
	
	private File FILE_PATH;
	private String FILE_NAME;
	
    public int getLength() {
        if ( getFILE_NAME().length()>0){
            return getFILE_NAME().length();
        }else 
        {
            return 0;
        }
    }


	public String getUFD_FORMAT_ID() {
		return UFD_FORMAT_ID;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void setFILE_NAME(String file_name) {
		FILE_NAME = file_name;
	}

	public void setUFD_FORMAT_ID(String ufd_format_id) {
		UFD_FORMAT_ID = ufd_format_id;
	}

	public String getUFD_FORMAT_DESC() {
		return UFD_FORMAT_DESC;
	}

	public void setUFD_FORMAT_DESC(String ufd_format_desc) {
		UFD_FORMAT_DESC = ufd_format_desc;
	}

	public String getUFD_FILE_TYPE() {
		return UFD_FILE_TYPE;
	}

	public void setUFD_FILE_TYPE(String ufd_file_type) {
		UFD_FILE_TYPE = ufd_file_type;
	}

	public String getUFD_DELIMETER() {
		return UFD_DELIMETER;
	}

	public void setUFD_DELIMETER(String ufd_delimeter) {
		UFD_DELIMETER = ufd_delimeter;
	}

	public String getUFD_DEST_TABLE() {
		return UFD_DEST_TABLE;
	}

	public void setUFD_DEST_TABLE(String ufd_dest_table) {
		UFD_DEST_TABLE = ufd_dest_table;
	}

	public String getUFD_DATE_FORMAT() {
		return UFD_DATE_FORMAT;
	}

	public void setUFD_DATE_FORMAT(String ufd_date_format) {
		UFD_DATE_FORMAT = ufd_date_format;
	}

	public String getUFD_TAB_TYPE() {
		return UFD_TAB_TYPE;
	}

	public void setUFD_TAB_TYPE(String ufd_tab_type) {
		UFD_TAB_TYPE = ufd_tab_type;
	}

	public File getFILE_PATH() {
		return FILE_PATH;
	}

	public void setFILE_PATH(File file_path) {
		FILE_PATH = file_path;
	}


	public void setLength(int length) {
		this.length = length;
	}
 
}

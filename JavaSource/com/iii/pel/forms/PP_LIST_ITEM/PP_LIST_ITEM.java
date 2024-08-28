package com.iii.pel.forms.PP_LIST_ITEM;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_LIST_ITEM")
public class PP_LIST_ITEM extends BaseValueBean{
	
	@Column(name="LI_MODULE_NAME")
	private String LI_MODULE_NAME;
	
	@Column(name="LI_BLOCK_NAME")
	private String LI_BLOCK_NAME;
	
	@Column(name="LI_ITEM_NAME")
	private String LI_ITEM_NAME;
	
	@Column(name="LI_SYS_PARAM")
	private String LI_SYS_PARAM;
	
	@Column(name="LI_REMARKS")
	private String LI_REMARKS;
	
	@Column(name="LI_EXTERNAL_TABLE_YN")
	private String LI_EXTERNAL_TABLE_YN;
	
	@Column(name="LI_WHERE_CLAUSE")
	private String LI_WHERE_CLAUSE;
	
	@Column(name="LI_DFLT_VALUE")
	private String LI_DFLT_VALUE;
	
	private boolean checkBoxSelected = false;

	private boolean extarnalCheckBox = false;
	
	public String getLI_MODULE_NAME() {
		return LI_MODULE_NAME;
	}

	public void setLI_MODULE_NAME(String li_module_name) {
		LI_MODULE_NAME = li_module_name;
	}

	public String getLI_BLOCK_NAME() {
		return LI_BLOCK_NAME;
	}

	public void setLI_BLOCK_NAME(String li_block_name) {
		LI_BLOCK_NAME = li_block_name;
	}

	public String getLI_ITEM_NAME() {
		return LI_ITEM_NAME;
	}

	public void setLI_ITEM_NAME(String li_item_name) {
		LI_ITEM_NAME = li_item_name;
	}

	public String getLI_SYS_PARAM() {
		return LI_SYS_PARAM;
	}

	public void setLI_SYS_PARAM(String li_sys_param) {
		LI_SYS_PARAM = li_sys_param;
	}

	public String getLI_REMARKS() {
		return LI_REMARKS;
	}

	public void setLI_REMARKS(String li_remarks) {
		LI_REMARKS = li_remarks;
	}

	public String getLI_EXTERNAL_TABLE_YN() {
		return LI_EXTERNAL_TABLE_YN;
	}

	public void setLI_EXTERNAL_TABLE_YN(String li_external_table_yn) {
		LI_EXTERNAL_TABLE_YN = li_external_table_yn;
		if(li_external_table_yn!=null && li_external_table_yn.equals("Y"))
			checkBoxSelected = true;
		else
			checkBoxSelected = false;
	}

	public String getLI_WHERE_CLAUSE() {
		return LI_WHERE_CLAUSE;
	}

	public void setLI_WHERE_CLAUSE(String li_where_clause) {
		LI_WHERE_CLAUSE = li_where_clause;
	}

	public String getLI_DFLT_VALUE() {
		return LI_DFLT_VALUE;
	}

	public void setLI_DFLT_VALUE(String li_dflt_value) {
		LI_DFLT_VALUE = li_dflt_value;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
		if(checkBoxSelected)
			LI_EXTERNAL_TABLE_YN ="Y";
		else
			LI_EXTERNAL_TABLE_YN ="N";
	}
	

	public boolean isExtarnalCheckBox() {
		return extarnalCheckBox;
	}

	public void setExtarnalCheckBox(boolean extarnalCheckBox) {
		this.extarnalCheckBox = extarnalCheckBox;
	}
}

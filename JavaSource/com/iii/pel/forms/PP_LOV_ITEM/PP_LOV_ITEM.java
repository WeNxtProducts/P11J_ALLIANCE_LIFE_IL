package com.iii.pel.forms.PP_LOV_ITEM;

import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PGIM_LOV_DEFN")
public class PP_LOV_ITEM extends BaseValueBean{
	
	@Column(name="PLD_PROG_CODE")
	private String PLD_PROG_CODE;
	
	@Column(name="PLD_BLOCK_NAME")
	private String PLD_BLOCK_NAME;
	
	@Column(name="PLD_FIELD_NAME")
	private String PLD_FIELD_NAME;
	
	@Column(name="PLD_LOV_TITLE")
	private String PLD_LOV_TITLE;
	
	@Column(name="PLD_LOV_TITLE_BL")
	private String PLD_LOV_TITLE_BL;
	
	@Column(name="PLD_LOV_SELECT_STMT")
	private String PLD_LOV_SELECT_STMT;
	
	@Column(name="PLD_COLUMN_HEAD")
	private String PLD_COLUMN_HEAD;
	
	@Column(name="PLD_COLUMN_HEAD_BL")
	private String PLD_COLUMN_HEAD_BL;
	
	@Column(name="PLD_PARA_COL_1")
	private String PLD_PARA_COL_1;
	
	@Column(name="PLD_PARA_COL_2")
	private String PLD_PARA_COL_2;
	
	@Column(name="PLD_PARA_COL_3")
	private String PLD_PARA_COL_3;
	
	@Column(name="PLD_PARA_COL_4")
	private String PLD_PARA_COL_4;
	
	@Column(name="PLD_PARA_COL_5")
	private String PLD_PARA_COL_5;
	
	@Column(name="PLD_CR_UID")
	private String PLD_CR_UID;
	
	@Column(name="PLD_CR_DT")
	private Date PLD_CR_DT;
	
	@Column(name="PLD_LOV_NO_OF_COLUMN")
	private Double PLD_LOV_NO_OF_COLUMN;
	
	private boolean checkBoxSelected;
	
	public String getPLD_PROG_CODE() {
		return PLD_PROG_CODE;
	}

	public void setPLD_PROG_CODE(String pld_prog_code) {
		PLD_PROG_CODE = pld_prog_code;
	}

	public String getPLD_BLOCK_NAME() {
		return PLD_BLOCK_NAME;
	}

	public void setPLD_BLOCK_NAME(String pld_block_name) {
		PLD_BLOCK_NAME = pld_block_name;
	}

	public String getPLD_FIELD_NAME() {
		return PLD_FIELD_NAME;
	}

	public void setPLD_FIELD_NAME(String pld_field_name) {
		PLD_FIELD_NAME = pld_field_name;
	}

	public String getPLD_LOV_TITLE() {
		return PLD_LOV_TITLE;
	}

	public void setPLD_LOV_TITLE(String pld_lov_title) {
		PLD_LOV_TITLE = pld_lov_title;
	}

	public String getPLD_LOV_TITLE_BL() {
		return PLD_LOV_TITLE_BL;
	}

	public void setPLD_LOV_TITLE_BL(String pld_lov_title_bl) {
		PLD_LOV_TITLE_BL = pld_lov_title_bl;
	}

	public String getPLD_LOV_SELECT_STMT() {
		return PLD_LOV_SELECT_STMT;
	}

	public void setPLD_LOV_SELECT_STMT(String pld_lov_select_stmt) {
		PLD_LOV_SELECT_STMT = pld_lov_select_stmt;
	}

	public String getPLD_COLUMN_HEAD() {
		return PLD_COLUMN_HEAD;
	}

	public void setPLD_COLUMN_HEAD(String pld_column_head) {
		PLD_COLUMN_HEAD = pld_column_head;
	}

	public String getPLD_COLUMN_HEAD_BL() {
		return PLD_COLUMN_HEAD_BL;
	}

	public void setPLD_COLUMN_HEAD_BL(String pld_column_head_bl) {
		PLD_COLUMN_HEAD_BL = pld_column_head_bl;
	}

	public String getPLD_PARA_COL_1() {
		return PLD_PARA_COL_1;
	}

	public void setPLD_PARA_COL_1(String pld_para_col_1) {
		PLD_PARA_COL_1 = pld_para_col_1;
	}

	public String getPLD_PARA_COL_2() {
		return PLD_PARA_COL_2;
	}

	public void setPLD_PARA_COL_2(String pld_para_col_2) {
		PLD_PARA_COL_2 = pld_para_col_2;
	}

	public String getPLD_PARA_COL_3() {
		return PLD_PARA_COL_3;
	}

	public void setPLD_PARA_COL_3(String pld_para_col_3) {
		PLD_PARA_COL_3 = pld_para_col_3;
	}

	public String getPLD_PARA_COL_4() {
		return PLD_PARA_COL_4;
	}

	public void setPLD_PARA_COL_4(String pld_para_col_4) {
		PLD_PARA_COL_4 = pld_para_col_4;
	}

	public String getPLD_PARA_COL_5() {
		return PLD_PARA_COL_5;
	}

	public void setPLD_PARA_COL_5(String pld_para_col_5) {
		PLD_PARA_COL_5 = pld_para_col_5;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	public String getPLD_CR_UID() {
		return PLD_CR_UID;
	}

	public void setPLD_CR_UID(String pld_cr_uid) {
		PLD_CR_UID = pld_cr_uid;
	}

	public Date getPLD_CR_DT() {
		return PLD_CR_DT;
	}

	public void setPLD_CR_DT(Date pld_cr_dt) throws ParseException {
		PLD_CR_DT = pld_cr_dt;
	}

	public Double getPLD_LOV_NO_OF_COLUMN() {
		return PLD_LOV_NO_OF_COLUMN;
	}

	public void setPLD_LOV_NO_OF_COLUMN(Double pld_lov_no_of_column) {
		PLD_LOV_NO_OF_COLUMN = pld_lov_no_of_column;
	}

}

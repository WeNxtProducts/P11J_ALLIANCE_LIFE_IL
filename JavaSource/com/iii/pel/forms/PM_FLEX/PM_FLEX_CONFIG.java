package com.iii.pel.forms.PM_FLEX;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="IM_PROG_FIELD_DEFN")
public class PM_FLEX_CONFIG extends BaseValueBean {

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="PFD_PROG_CODE")
	private String IFD_PROG_CODE;
	
	private String UI_IFD_PROG_CODE;
	
	@Column(name="PFD_PB_BLK_NAME")
	private String IFD_PB_BLK_NAME;
	
	private String UI_IFD_PB_BLK_NAME;
	
	@Column(name="PFD_FLD_NAME")
	private String IFD_PBF_FLD_NAME;
	
	//IFD_PROMPT use for caption..
	@Column(name="PFD_PROMPT")
	private String IFD_PROMPT;
	//IFD_PROMPT use for caption..
	
	
	@Column(name="PFD_HIDE_YN_NUM")
	private Integer IFD_HIDE_YN_NUM;
	private Boolean UI_IFD_HIDE_YN_NUM;
	
	@Column(name="PFD_ENTERABLE_YN_NUM")
	private Integer PFD_ENTERABLE_YN_NUM;
	private Boolean UI_PFD_ENTERABLE_YN_NUM;
	
	@Column(name="PFD_UPDATEABLE_YN_NUM")
	private Integer PFD_UPDATEABLE_YN_NUM;
	private Boolean UI_PFD_UPDATEABLE_YN_NUM;
	
	@Column(name="PFD_MANDATORY_YN_NUM")
	private Integer IFD_MANDATORY_YN_NUM;
	private Boolean UI_IFD_MANDATORY_YN_NUM;
	
	@Column(name="PFD_DATA_TYPE")
	private String IFD_DATA_TYPE;
	
	@Column(name="PFD_FLD_LEN")
	private Integer IFD_FLD_LEN;
	
	@Column(name="PFD_DFLT_VALUE")
	private String IFD_DFLT_VALUE;
	
	@Column(name="PFD_UPD_UID")
	private String PFD_UPD_UID;
	
	@Column(name="PFD_UPD_DT")
	private Date PFD_UPD_DT ; 

	public String getPFD_UPD_UID() {
		return PFD_UPD_UID;
	}

	public void setPFD_UPD_UID(String pfd_upd_uid) {
		PFD_UPD_UID = pfd_upd_uid;
	}

	public Date getPFD_UPD_DT() {
		return PFD_UPD_DT;
	}

	public void setPFD_UPD_DT(Date pfd_upd_dt) {
		PFD_UPD_DT = pfd_upd_dt;
	}

	public String getIFD_PROG_CODE() {
		return IFD_PROG_CODE;
	}

	public void setIFD_PROG_CODE(String ifd_prog_code) {
		IFD_PROG_CODE = ifd_prog_code;
	}

	public String getIFD_PB_BLK_NAME() {
		return IFD_PB_BLK_NAME;
	}

	public void setIFD_PB_BLK_NAME(String ifd_pb_blk_name) {
		IFD_PB_BLK_NAME = ifd_pb_blk_name;
	}

	public String getIFD_PBF_FLD_NAME() {
		return IFD_PBF_FLD_NAME;
	}

	public void setIFD_PBF_FLD_NAME(String ifd_pbf_fld_name) {
		IFD_PBF_FLD_NAME = ifd_pbf_fld_name;
	}

	public String getIFD_PROMPT() {
		return IFD_PROMPT;
	}

	public void setIFD_PROMPT(String ifd_prompt) {
		IFD_PROMPT = ifd_prompt;
	}

	public Integer getIFD_HIDE_YN_NUM() {
		return IFD_HIDE_YN_NUM;
	}

	public void setIFD_HIDE_YN_NUM(Integer ifd_hide_yn_num) {
		if(ifd_hide_yn_num == 1){
			setUI_IFD_HIDE_YN_NUM(true);
		}else{
			setUI_IFD_HIDE_YN_NUM(false);
		}
		IFD_HIDE_YN_NUM = ifd_hide_yn_num;
	}

	public Boolean getUI_IFD_HIDE_YN_NUM() {
		
		return UI_IFD_HIDE_YN_NUM;
	}

	public void setUI_IFD_HIDE_YN_NUM(Boolean ui_ifd_hide_yn_num) {
		UI_IFD_HIDE_YN_NUM = ui_ifd_hide_yn_num;
	}

	public Integer getIFD_MANDATORY_YN_NUM() {
		return IFD_MANDATORY_YN_NUM;
	}

	public void setIFD_MANDATORY_YN_NUM(Integer ifd_mandatory_yn_num) {
		if(ifd_mandatory_yn_num == 1){
			setUI_IFD_MANDATORY_YN_NUM(true);
		}else{
			setUI_IFD_MANDATORY_YN_NUM(false);
		}
		IFD_MANDATORY_YN_NUM = ifd_mandatory_yn_num;
	}

	public Boolean getUI_IFD_MANDATORY_YN_NUM() {
		return UI_IFD_MANDATORY_YN_NUM;
	}

	public void setUI_IFD_MANDATORY_YN_NUM(Boolean ui_ifd_mandatory_yn_num) {
		UI_IFD_MANDATORY_YN_NUM = ui_ifd_mandatory_yn_num;
	}

	public String getIFD_DATA_TYPE() {
		return IFD_DATA_TYPE;
	}

	public void setIFD_DATA_TYPE(String ifd_data_type) {
		IFD_DATA_TYPE = ifd_data_type;
	}

	public Integer getIFD_FLD_LEN() {
		return IFD_FLD_LEN;
	}

	public void setIFD_FLD_LEN(Integer ifd_fld_len) {
		IFD_FLD_LEN = ifd_fld_len;
	}

	public String getIFD_DFLT_VALUE() {
		return IFD_DFLT_VALUE;
	}

	public void setIFD_DFLT_VALUE(String ifd_dflt_value) {
		IFD_DFLT_VALUE = ifd_dflt_value;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getUI_IFD_PROG_CODE() {
		return UI_IFD_PROG_CODE;
	}

	public void setUI_IFD_PROG_CODE(String ui_ifd_prog_code) {
		UI_IFD_PROG_CODE = ui_ifd_prog_code;
	}

	public String getUI_IFD_PB_BLK_NAME() {
		return UI_IFD_PB_BLK_NAME;
	}

	public void setUI_IFD_PB_BLK_NAME(String ui_ifd_pb_blk_name) {
		UI_IFD_PB_BLK_NAME = ui_ifd_pb_blk_name;
	}

	public Integer getPFD_ENTERABLE_YN_NUM() {
		return PFD_ENTERABLE_YN_NUM;
	}

	public void setPFD_ENTERABLE_YN_NUM(Integer pfd_enterable_yn_num) {
		if(pfd_enterable_yn_num == 1){
			setUI_PFD_ENTERABLE_YN_NUM(true);
		}else{
			setUI_PFD_ENTERABLE_YN_NUM(false);
		}
		PFD_ENTERABLE_YN_NUM = pfd_enterable_yn_num;
	}

	public Boolean getUI_PFD_ENTERABLE_YN_NUM() {
		return UI_PFD_ENTERABLE_YN_NUM;
	}

	public void setUI_PFD_ENTERABLE_YN_NUM(Boolean ui_pfd_enterable_yn_num) {
		UI_PFD_ENTERABLE_YN_NUM = ui_pfd_enterable_yn_num;
	}

	public Integer getPFD_UPDATEABLE_YN_NUM() {
		return PFD_UPDATEABLE_YN_NUM;
	}

	public void setPFD_UPDATEABLE_YN_NUM(Integer pfd_updateable_yn_num) {
		if(pfd_updateable_yn_num == 1){
			setUI_PFD_UPDATEABLE_YN_NUM(true);
		}else{
			setUI_PFD_UPDATEABLE_YN_NUM(false);
		}
		PFD_UPDATEABLE_YN_NUM = pfd_updateable_yn_num;
	}

	public Boolean getUI_PFD_UPDATEABLE_YN_NUM() {
		return UI_PFD_UPDATEABLE_YN_NUM;
	}

	public void setUI_PFD_UPDATEABLE_YN_NUM(Boolean ui_pfd_updateable_yn_num) {
		UI_PFD_UPDATEABLE_YN_NUM = ui_pfd_updateable_yn_num;
	}
}

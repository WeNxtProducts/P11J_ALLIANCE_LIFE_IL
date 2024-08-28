package com.iii.pel.forms.PILT018;

import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_BROK_ADV_DTL")
public class PT_IL_BROK_ADV_DTL extends BaseValueBean{

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="BAD_SYS_ID")
	private Long BAD_SYS_ID;
	
	@Column(name="BAD_CR_DT")
	private Date BAD_CR_DT;
	@Column(name="BAD_CR_UID")
	private String BAD_CR_UID;
	
	@Column(name="BAD_DUE_DT")
	private Date BAD_DUE_DT;

	@Column(name="BAD_REMARKS")
	private String BAD_REMARKS;

	@Column(name="BAD_FC_AMT")
	private Double BAD_FC_AMT;

	@Column(name="BAD_LC_AMT")
	private Double BAD_LC_AMT;

	@Column(name="BAD_TXN_CODE")
	private String BAD_TXN_CODE;

	@Column(name="BAD_PAID_DT")
	private Date BAD_PAID_DT;

	@Column(name="BAD_FC_COMM_AMT")
	private Double BAD_FC_COMM_AMT;

	@Column(name="BAD_DOC_NO")
	private Double BAD_DOC_NO;

	@Column(name="BAD_LC_COMM_AMT")
	private Double BAD_LC_COMM_AMT;

	@Column(name="BAD_DOC_DT")
	private Date BAD_DOC_DT;

	@Column(name="BAD_STATUS")
	private String BAD_STATUS;
	
	@Column(name="BAD_UPD_UID")
	private String BAD_UPD_UID;
	
	@Column(name="BAD_UPD_DT")
	private Date BAD_UPD_DT;

	private String DIVN_CODE;
	
	private String DIVN_CODE_DESC;
	
	private List<String>BAD_STATUS_LIST;
	
	private boolean CHECK_BOX;
	
	@Column(name="BAD_BAH_SYS_ID")
	private Long BAD_BAH_SYS_ID;
	
	@Column(name="BAD_RECOVER_FLAG")
	private String BAD_RECOVER_FLAG;
	
	/**[BugId:PREMIAGDC-AGENCY-0093 S.Mallika 02-Mar-09 For handling enabling & disabling of
	 *  status filed in Detail Block.*/
	
	private boolean statusDisble = false;
	
	private boolean remarksDisble = false;
	
	/** BugId:PREMIAGDC-AGENCY-0093 S.Mallika 02-Mar-09]	*/
	

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getBAD_DUE_DT() {
		 return BAD_DUE_DT;
	}

	public void setBAD_DUE_DT(Date BAD_DUE_DT) {
		this.BAD_DUE_DT = BAD_DUE_DT;
	}

	public String getBAD_REMARKS() {
		return BAD_REMARKS;
	}

	public void setBAD_REMARKS(String BAD_REMARKS) {
		this.BAD_REMARKS = BAD_REMARKS;
	}

	public Double getBAD_FC_AMT() {
		return BAD_FC_AMT;
	}

	public void setBAD_FC_AMT(Double BAD_FC_AMT) {
		this.BAD_FC_AMT = BAD_FC_AMT;
	}

	public Double getBAD_LC_AMT() {
		return BAD_LC_AMT;
	}

	public void setBAD_LC_AMT(Double BAD_LC_AMT) {
		this.BAD_LC_AMT = BAD_LC_AMT;
	}

	public String getBAD_TXN_CODE() {
		return BAD_TXN_CODE;
	}

	public void setBAD_TXN_CODE(String BAD_TXN_CODE) {
		this.BAD_TXN_CODE = BAD_TXN_CODE;
	}

	public Date getBAD_PAID_DT() {
		 return BAD_PAID_DT;
	}

	public void setBAD_PAID_DT(Date BAD_PAID_DT) {
		this.BAD_PAID_DT = BAD_PAID_DT;
	}

	public Double getBAD_FC_COMM_AMT() {
		return BAD_FC_COMM_AMT;
	}

	public void setBAD_FC_COMM_AMT(Double BAD_FC_COMM_AMT) {
		this.BAD_FC_COMM_AMT = BAD_FC_COMM_AMT;
	}

	public Double getBAD_DOC_NO() {
		return BAD_DOC_NO;
	}

	public void setBAD_DOC_NO(Double BAD_DOC_NO) {
		this.BAD_DOC_NO = BAD_DOC_NO;
	}

	public Double getBAD_LC_COMM_AMT() {
		return BAD_LC_COMM_AMT;
	}

	public void setBAD_LC_COMM_AMT(Double BAD_LC_COMM_AMT) {
		this.BAD_LC_COMM_AMT = BAD_LC_COMM_AMT;
	}

	public Date getBAD_DOC_DT() {
		 return BAD_DOC_DT;
	}

	public void setBAD_DOC_DT(Date BAD_DOC_DT) {
		this.BAD_DOC_DT = BAD_DOC_DT;
	}

	public String getBAD_STATUS() {
		return BAD_STATUS;
	}

	public void setBAD_STATUS(String BAD_STATUS) {
		this.BAD_STATUS = BAD_STATUS;
	}

	public String getDIVN_CODE() {
		return DIVN_CODE;
	}

	public void setDIVN_CODE(String divn_code) {
		DIVN_CODE = divn_code;
	}

	public String getDIVN_CODE_DESC() {
		return DIVN_CODE_DESC;
	}

	public void setDIVN_CODE_DESC(String divn_code_desc) {
		DIVN_CODE_DESC = divn_code_desc;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getBAD_CR_UID() {
		return BAD_CR_UID;
	}

	public void setBAD_CR_UID(String bad_cr_uid) {
		BAD_CR_UID = bad_cr_uid;
	}

	public Date getBAD_CR_DT() {
		return BAD_CR_DT;
	}

	public void setBAD_CR_DT(Date bad_cr_dt) {
		BAD_CR_DT = bad_cr_dt;
	}

	public List<String> getBAD_STATUS_LIST() {
		return BAD_STATUS_LIST;
	}

	public void setBAD_STATUS_LIST(List<String> bad_status_list) {
		BAD_STATUS_LIST = bad_status_list;
	}

	

	/**
	 * @return the bAD_SYS_ID
	 */
	public Long getBAD_SYS_ID() {
		return BAD_SYS_ID;
	}

	/**
	 * @param bad_sys_id the bAD_SYS_ID to set
	 */
	public void setBAD_SYS_ID(Long bad_sys_id) {
		BAD_SYS_ID = bad_sys_id;
	}

	/**
	 * @return the bAD_BAH_SYS_ID
	 */
	public Long getBAD_BAH_SYS_ID() {
		return BAD_BAH_SYS_ID;
	}

	/**
	 * @param bad_bah_sys_id the bAD_BAH_SYS_ID to set
	 */
	public void setBAD_BAH_SYS_ID(Long bad_bah_sys_id) {
		BAD_BAH_SYS_ID = bad_bah_sys_id;
	}

	/**[BugId:PREMIAGDC-AGENCY-0093 S.Mallika 02-Mar-09 For handling enabling & disabling of
	 *  status filed in Detail Block.*/
	
	public boolean isStatusDisble() {
		return statusDisble;
	}

	public void setStatusDisble(boolean statusDisble) {
		this.statusDisble = statusDisble;
	}

	public boolean isRemarksDisble() {
		return remarksDisble;
	}

	public void setRemarksDisble(boolean remarksDisble) {
		this.remarksDisble = remarksDisble;
	}

	/**
	 * @return the bAD_UPD_UID
	 */
	public String getBAD_UPD_UID() {
		return BAD_UPD_UID;
	}

	/**
	 * @param bad_upd_uid the bAD_UPD_UID to set
	 */
	public void setBAD_UPD_UID(String bad_upd_uid) {
		BAD_UPD_UID = bad_upd_uid;
	}

	
	public void setBAD_UPD_DT(Date bad_upd_dt) {
		BAD_UPD_DT = bad_upd_dt;
	}

	/**
	 * @return the bAD_UPD_DT
	 */
	public Date getBAD_UPD_DT() {
		return BAD_UPD_DT;
	}

	/**
	 * @return the bAD_RECOVER_FLAG
	 */
	public String getBAD_RECOVER_FLAG() {
		return BAD_RECOVER_FLAG;
	}

	/**
	 * @param bad_recover_flag the bAD_RECOVER_FLAG to set
	 */
	public void setBAD_RECOVER_FLAG(String bad_recover_flag) {
		BAD_RECOVER_FLAG = bad_recover_flag;
	}
	
	/** BugId:PREMIAGDC-AGENCY-0093 S.Mallika 02-Mar-09]	*/

}

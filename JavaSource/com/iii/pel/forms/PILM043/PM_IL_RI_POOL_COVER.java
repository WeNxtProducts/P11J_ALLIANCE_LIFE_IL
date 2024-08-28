package com.iii.pel.forms.PILM043;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RI_POOL_COVER")
public class PM_IL_RI_POOL_COVER extends BaseValueBean {
	
	private boolean CHECK_BOX;

	private String UI_M_DUMMY_RPCVR_CODE;

	private String UI_M_DUMMY_RPCVR_CODE_DESC;

	@Column(name="RPCVR_CODE")
	private String RPCVR_CODE;
	
	@Column(name="RPCVR_RPS_CODE")
	private String RPCVR_RPS_CODE;

	@Column(name="RPCVR_CR_DT")
	private Date RPCVR_CR_DT;
	
	@Column(name="RPCVR_CR_UID")
	private String RPCVR_CR_UID;
	
	@Column(name="RPCVR_UPD_DT")
	private Date RPCVR_UPD_DT;
	
	@Column(name="RPCVR_UPD_UID")
	private String RPCVR_UPD_UID;
	
	private String UI_M_RPCVR_CODE_DESC;

	@Column(name="RPCVR_SHARE_PERC")
	private Double RPCVR_SHARE_PERC;

	private String UI_M_RCC_RPCVR_CODE_DESC;

	private boolean CHECKBOX;

	public String getUI_M_DUMMY_RPCVR_CODE() {
		return UI_M_DUMMY_RPCVR_CODE;
	}

	public void setUI_M_DUMMY_RPCVR_CODE(String UI_M_DUMMY_RPCVR_CODE) {
		this.UI_M_DUMMY_RPCVR_CODE = UI_M_DUMMY_RPCVR_CODE;
	}

	public String getUI_M_DUMMY_RPCVR_CODE_DESC() {
		return UI_M_DUMMY_RPCVR_CODE_DESC;
	}

	public void setUI_M_DUMMY_RPCVR_CODE_DESC(String UI_M_DUMMY_RPCVR_CODE_DESC) {
		this.UI_M_DUMMY_RPCVR_CODE_DESC = UI_M_DUMMY_RPCVR_CODE_DESC;
	}

	public String getRPCVR_CODE() {
		return RPCVR_CODE;
	}

	public void setRPCVR_CODE(String RPCVR_CODE) {
		this.RPCVR_CODE = RPCVR_CODE;
	}

	public String getUI_M_RPCVR_CODE_DESC() {
		return UI_M_RPCVR_CODE_DESC;
	}

	public void setUI_M_RPCVR_CODE_DESC(String UI_M_RPCVR_CODE_DESC) {
		this.UI_M_RPCVR_CODE_DESC = UI_M_RPCVR_CODE_DESC;
	}

	public Double getRPCVR_SHARE_PERC() {
		return RPCVR_SHARE_PERC;
	}

	public void setRPCVR_SHARE_PERC(Double RPCVR_SHARE_PERC) {
		this.RPCVR_SHARE_PERC = RPCVR_SHARE_PERC;
	}

	public String getUI_M_RCC_RPCVR_CODE_DESC() {
		return UI_M_RCC_RPCVR_CODE_DESC;
	}

	public void setUI_M_RCC_RPCVR_CODE_DESC(String UI_M_RCC_RPCVR_CODE_DESC) {
		this.UI_M_RCC_RPCVR_CODE_DESC = UI_M_RCC_RPCVR_CODE_DESC;
	}
	
	public String getRPCVR_CR_UID() {
		return RPCVR_CR_UID;
	}

	public void setRPCVR_CR_UID(String RPCVR_CR_UID) {
		this.RPCVR_CR_UID = RPCVR_CR_UID;
	}
	

	public String getRPCVR_RPS_CODE() {
		return RPCVR_RPS_CODE;
	}

	public void setRPCVR_RPS_CODE(String RPCVR_RPS_CODE) {
		this.RPCVR_RPS_CODE = RPCVR_RPS_CODE;
	}
	
	
	
	public Date getRPCVR_CR_DT() {
		return RPCVR_CR_DT;
	}

	public void setRPCVR_CR_DT(Date RPCVR_CR_DT) {
		this.RPCVR_CR_DT = RPCVR_CR_DT;
	}
	
	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	/**
	 * @return the rPCVR_UPD_DT
	 */
	public Date getRPCVR_UPD_DT() {
		return RPCVR_UPD_DT;
	}

	/**
	 * @param rpcvr_upd_dt the rPCVR_UPD_DT to set
	 */
	public void setRPCVR_UPD_DT(Date rpcvr_upd_dt) {
		RPCVR_UPD_DT = rpcvr_upd_dt;
	}

	/**
	 * @return the rPCVR_UPD_UID
	 */
	public String getRPCVR_UPD_UID() {
		return RPCVR_UPD_UID;
	}

	/**
	 * @param rpcvr_upd_uid the rPCVR_UPD_UID to set
	 */
	public void setRPCVR_UPD_UID(String rpcvr_upd_uid) {
		RPCVR_UPD_UID = rpcvr_upd_uid;
	}

	
	
	
	
}

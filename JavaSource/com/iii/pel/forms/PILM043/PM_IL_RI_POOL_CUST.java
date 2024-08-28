package com.iii.pel.forms.PILM043;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RI_POOL_CUST")
public class PM_IL_RI_POOL_CUST extends BaseValueBean {

	
	@Column(name="RPCUST_CODE")
	private String RPCUST_CODE;
	
	@Column(name="RPCUST_CR_DT")
	private Date RPCUST_CR_DT;
	
	private boolean CHECK_BOX;
	
	@Column(name="RPCUST_CR_UID")
	private String RPCUST_CR_UID;
	
	@Column(name="RPCUST_RPS_CODE")
	private String RPCUST_RPS_CODE;
	
	@Column(name="RPCUST_RPCVR_CODE")
	private String RPCUST_RPCVR_CODE;
	
	private String UI_M_RPCUST_CODE_DESC;

	@Column(name="RPCUST_SHARE_PERC")
	private Double RPCUST_SHARE_PERC;

	@Column(name="RPCUST_NEW_COMM")
	private Double RPCUST_NEW_COMM;

	@Column(name="RPCUST_REN_COMM")
	private Double RPCUST_REN_COMM;

	@Column(name="RPCUST_NEW_TAX")
	private Double RPCUST_NEW_TAX;

	@Column(name="RPCUST_REN_TAX")
	private Double RPCUST_REN_TAX;

	private String UI_M_RCC_RPCUST_CODE_DESC;

	@Column(name="RPCUST_RETRO_SHARE_PERC")
	private Double RPCUST_RETRO_SHARE_PERC;

	@Column(name="RPCUST_RETRO_NEW_COMM")
	private Double RPCUST_RETRO_NEW_COMM;

	@Column(name="RPCUST_RETRO_REN_COMM")
	private Double RPCUST_RETRO_REN_COMM;

	@Column(name="RPCUST_RETRO_NEW_TAX")
	private Double RPCUST_RETRO_NEW_TAX;

	@Column(name="RPCUST_RETRO_REN_TAX")
	private Double RPCUST_RETRO_REN_TAX;

	@Column(name="RPCUST_UPD_DT")
	private Date RPCUST_UPD_DT;
	
	@Column(name="RPCUST_UPD_UID")
	private String RPCUST_UPD_UID;
	
	private boolean CHECKBOX;
	
	private String storedCoverCode;

	public String getStoredCoverCode() {
		return storedCoverCode;
	}

	public void setStoredCoverCode(String storedCoverCode) {
		this.storedCoverCode = storedCoverCode;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getRPCUST_CODE() {
		return RPCUST_CODE;
	}

	public void setRPCUST_CODE(String RPCUST_CODE) {
		this.RPCUST_CODE = RPCUST_CODE;
	}

	public String getUI_M_RPCUST_CODE_DESC() {
		return UI_M_RPCUST_CODE_DESC;
	}

	public void setUI_M_RPCUST_CODE_DESC(String UI_M_RPCUST_CODE_DESC) {
		this.UI_M_RPCUST_CODE_DESC = UI_M_RPCUST_CODE_DESC;
	}

	public Double getRPCUST_SHARE_PERC() {
		return RPCUST_SHARE_PERC;
	}

	public void setRPCUST_SHARE_PERC(Double RPCUST_SHARE_PERC) {
		this.RPCUST_SHARE_PERC = RPCUST_SHARE_PERC;
	}

	public Double getRPCUST_NEW_COMM() {
		return RPCUST_NEW_COMM;
	}

	public void setRPCUST_NEW_COMM(Double RPCUST_NEW_COMM) {
		this.RPCUST_NEW_COMM = RPCUST_NEW_COMM;
	}

	public Double getRPCUST_REN_COMM() {
		return RPCUST_REN_COMM;
	}

	public void setRPCUST_REN_COMM(Double RPCUST_REN_COMM) {
		this.RPCUST_REN_COMM = RPCUST_REN_COMM;
	}

	public Double getRPCUST_NEW_TAX() {
		return RPCUST_NEW_TAX;
	}

	public void setRPCUST_NEW_TAX(Double RPCUST_NEW_TAX) {
		this.RPCUST_NEW_TAX = RPCUST_NEW_TAX;
	}

	public Double getRPCUST_REN_TAX() {
		return RPCUST_REN_TAX;
	}

	public void setRPCUST_REN_TAX(Double RPCUST_REN_TAX) {
		this.RPCUST_REN_TAX = RPCUST_REN_TAX;
	}

	public String getUI_M_RCC_RPCUST_CODE_DESC() {
		return UI_M_RCC_RPCUST_CODE_DESC;
	}

	public void setUI_M_RCC_RPCUST_CODE_DESC(String UI_M_RCC_RPCUST_CODE_DESC) {
		this.UI_M_RCC_RPCUST_CODE_DESC = UI_M_RCC_RPCUST_CODE_DESC;
	}

	public Double getRPCUST_RETRO_SHARE_PERC() {
		return RPCUST_RETRO_SHARE_PERC;
	}

	public void setRPCUST_RETRO_SHARE_PERC(Double RPCUST_RETRO_SHARE_PERC) {
		this.RPCUST_RETRO_SHARE_PERC = RPCUST_RETRO_SHARE_PERC;
	}

	public Double getRPCUST_RETRO_NEW_COMM() {
		return RPCUST_RETRO_NEW_COMM;
	}

	public void setRPCUST_RETRO_NEW_COMM(Double RPCUST_RETRO_NEW_COMM) {
		this.RPCUST_RETRO_NEW_COMM = RPCUST_RETRO_NEW_COMM;
	}

	public Double getRPCUST_RETRO_REN_COMM() {
		return RPCUST_RETRO_REN_COMM;
	}

	public void setRPCUST_RETRO_REN_COMM(Double RPCUST_RETRO_REN_COMM) {
		this.RPCUST_RETRO_REN_COMM = RPCUST_RETRO_REN_COMM;
	}

	public Double getRPCUST_RETRO_NEW_TAX() {
		return RPCUST_RETRO_NEW_TAX;
	}

	public void setRPCUST_RETRO_NEW_TAX(Double RPCUST_RETRO_NEW_TAX) {
		this.RPCUST_RETRO_NEW_TAX = RPCUST_RETRO_NEW_TAX;
	}

	public Double getRPCUST_RETRO_REN_TAX() {
		return RPCUST_RETRO_REN_TAX;
	}

	public void setRPCUST_RETRO_REN_TAX(Double RPCUST_RETRO_REN_TAX) {
		this.RPCUST_RETRO_REN_TAX = RPCUST_RETRO_REN_TAX;
	}

	public Date getRPCUST_CR_DT() {
		return RPCUST_CR_DT;
	}

	public void setRPCUST_CR_DT(Date RPCUST_CR_DT) {
		this.RPCUST_CR_DT = RPCUST_CR_DT;
	}

	public String getRPCUST_CR_UID() {
		return RPCUST_CR_UID;
	}

	public void setRPCUST_CR_UID(String RPCUST_CR_UID) {
		this.RPCUST_CR_UID = RPCUST_CR_UID;
	}

	public String getRPCUST_RPS_CODE() {
		return RPCUST_RPS_CODE;
	}

	public void setRPCUST_RPS_CODE(String RPCUST_RPS_CODE) {
		this.RPCUST_RPS_CODE = RPCUST_RPS_CODE;
	}

	public String getRPCUST_RPCVR_CODE() {
		return RPCUST_RPCVR_CODE;
	}

	public void setRPCUST_RPCVR_CODE(String RPCUST_RPCVR_CODE) {
		this.RPCUST_RPCVR_CODE = RPCUST_RPCVR_CODE;
	}
	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}



	/**
	 * @return the rPCUST_UPD_DT
	 */
	public Date getRPCUST_UPD_DT() {
		return RPCUST_UPD_DT;
	}

	/**
	 * @param rpcust_upd_dt the rPCUST_UPD_DT to set
	 */
	public void setRPCUST_UPD_DT(Date rpcust_upd_dt) {
		RPCUST_UPD_DT = rpcust_upd_dt;
	}

	/**
	 * @return the rPCUST_UPD_UID
	 */
	public String getRPCUST_UPD_UID() {
		return RPCUST_UPD_UID;
	}

	/**
	 * @param rpcust_upd_uid the rPCUST_UPD_UID to set
	 */
	public void setRPCUST_UPD_UID(String rpcust_upd_uid) {
		RPCUST_UPD_UID = rpcust_upd_uid;
	}
}

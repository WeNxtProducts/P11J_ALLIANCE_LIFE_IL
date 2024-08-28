package com.iii.pel.forms.PILQ106_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PT_IL_UNIT_FUND_REG_HDR")
public class PT_IL_UNIT_FUND_REG_HDR extends BaseValueBean {
	private Date PC_SCHD_PYMT_DT;
	private Date PC_PAID_DT;
	
	@Column(name = "UFRH_SYS_ID")
	private Long UFRH_SYS_ID;

	@Column(name = "UFRH_POL_SYS_ID")
	private Long UFRH_POL_SYS_ID;

	@Column(name = "UFRH_POL_NO")
	private String UFRH_POL_NO;

	@Column(name = "UFRH_TRANS_SYS_ID")
	private Long UFRH_TRANS_SYS_ID;

	@Column(name = "UFRH_TYPE")
	private String UFRH_TYPE;

	@Column(name = "UFRH_TRAN_DT")
	private Date UFRH_TRAN_DT;

	@Column(name = "UFRH_MONTH")
	private Double UFRH_MONTH;

	@Column(name = "UFRH_YEAR")
	private Double UFRH_YEAR;

	@Column(name = "UFRH_PREM_LC_AMT")
	private Double UFRH_PREM_LC_AMT;

	@Column(name = "UFRH_COMM_LC_AMT")
	private Double UFRH_COMM_LC_AMT;

	@Column(name = "UFRH_RISK_LC_AMT")
	private Double UFRH_RISK_LC_AMT;

	@Column(name = "UFRH_CHARGE_LC_AMT")
	private Double UFRH_CHARGE_LC_AMT;

	@Column(name = "UFRH_INV_LC_AMT")
	private Double UFRH_INV_LC_AMT;

	@Column(name = "UFRH_SELL_LC_AMT")
	private Double UFRH_SELL_LC_AMT;

	@Column(name = "UFRH_BUY_LC_AMT")
	private Double UFRH_BUY_LC_AMT;

	@Column(name = "UFRH_CR_UID")
	private String UFRH_CR_UID;

	@Column(name = "UFRH_CR_DT")
	private Date UFRH_CR_DT;

	@Column(name = "UFRH_UPD_UID")
	private String UFRH_UPD_UID;

	@Column(name = "UFRH_UPD_DT")
	private Date UFRH_UPD_DT;

	@Column(name = "UFRH_BUY_SEL")
	private String UFRH_BUY_SEL;

	@Column(name = "UFRH_REMAIN_LC_AMT")
	private Double UFRH_REMAIN_LC_AMT;

	@Column(name = "UFRH_PC_SYS_ID")
	private Long UFRH_PC_SYS_ID;

	@Column(name = "UFRH_AC_GEN_YN")
	private String UFRH_AC_GEN_YN;

	@Column(name = "UFRH_DEL_FLAG")
	private String UFRH_DEL_FLAG;

	public void setUFRH_CR_UID(String UFRH_CR_UID) {
		this.UFRH_CR_UID = UFRH_CR_UID;
	}

	public String getUFRH_CR_UID() {
		return UFRH_CR_UID;
	}

	public void setUFRH_MONTH(Double UFRH_MONTH) {
		this.UFRH_MONTH = UFRH_MONTH;
	}

	public Double getUFRH_MONTH() {
		return UFRH_MONTH;
	}

	public void setUFRH_CR_DT(Date UFRH_CR_DT) {
		this.UFRH_CR_DT = UFRH_CR_DT;
	}

	public Date getUFRH_CR_DT() {
		return UFRH_CR_DT;
	}

	public void setUFRH_TYPE(String UFRH_TYPE) {
		this.UFRH_TYPE = UFRH_TYPE;
	}

	public String getUFRH_TYPE() {
		return UFRH_TYPE;
	}

	public void setUFRH_CHARGE_LC_AMT(Double UFRH_CHARGE_LC_AMT) {
		this.UFRH_CHARGE_LC_AMT = UFRH_CHARGE_LC_AMT;
	}

	public Double getUFRH_CHARGE_LC_AMT() {
		return UFRH_CHARGE_LC_AMT;
	}

	public void setUFRH_SELL_LC_AMT(Double UFRH_SELL_LC_AMT) {
		this.UFRH_SELL_LC_AMT = UFRH_SELL_LC_AMT;
	}

	public Double getUFRH_SELL_LC_AMT() {
		return UFRH_SELL_LC_AMT;
	}

	public void setUFRH_TRANS_SYS_ID(Long UFRH_TRANS_SYS_ID) {
		this.UFRH_TRANS_SYS_ID = UFRH_TRANS_SYS_ID;
	}

	public Long getUFRH_TRANS_SYS_ID() {
		return UFRH_TRANS_SYS_ID;
	}

	public void setUFRH_INV_LC_AMT(Double UFRH_INV_LC_AMT) {
		this.UFRH_INV_LC_AMT = UFRH_INV_LC_AMT;
	}

	public Double getUFRH_INV_LC_AMT() {
		return UFRH_INV_LC_AMT;
	}

	public void setUFRH_PC_SYS_ID(Long UFRH_PC_SYS_ID) {
		this.UFRH_PC_SYS_ID = UFRH_PC_SYS_ID;
	}

	public Long getUFRH_PC_SYS_ID() {
		return UFRH_PC_SYS_ID;
	}

	public void setUFRH_BUY_SEL(String UFRH_BUY_SEL) {
		this.UFRH_BUY_SEL = UFRH_BUY_SEL;
	}

	public String getUFRH_BUY_SEL() {
		return UFRH_BUY_SEL;
	}

	public void setUFRH_BUY_LC_AMT(Double UFRH_BUY_LC_AMT) {
		this.UFRH_BUY_LC_AMT = UFRH_BUY_LC_AMT;
	}

	public Double getUFRH_BUY_LC_AMT() {
		return UFRH_BUY_LC_AMT;
	}

	public void setUFRH_UPD_DT(Date UFRH_UPD_DT) {
		this.UFRH_UPD_DT = UFRH_UPD_DT;
	}

	public Date getUFRH_UPD_DT() {
		return UFRH_UPD_DT;
	}

	public void setUFRH_PREM_LC_AMT(Double UFRH_PREM_LC_AMT) {
		this.UFRH_PREM_LC_AMT = UFRH_PREM_LC_AMT;
	}

	public Double getUFRH_PREM_LC_AMT() {
		return UFRH_PREM_LC_AMT;
	}

	public void setUFRH_UPD_UID(String UFRH_UPD_UID) {
		this.UFRH_UPD_UID = UFRH_UPD_UID;
	}

	public String getUFRH_UPD_UID() {
		return UFRH_UPD_UID;
	}

	public void setUFRH_POL_SYS_ID(Long UFRH_POL_SYS_ID) {
		this.UFRH_POL_SYS_ID = UFRH_POL_SYS_ID;
	}

	public Long getUFRH_POL_SYS_ID() {
		return UFRH_POL_SYS_ID;
	}

	public void setUFRH_RISK_LC_AMT(Double UFRH_RISK_LC_AMT) {
		this.UFRH_RISK_LC_AMT = UFRH_RISK_LC_AMT;
	}

	public Double getUFRH_RISK_LC_AMT() {
		return UFRH_RISK_LC_AMT;
	}

	public void setUFRH_REMAIN_LC_AMT(Double UFRH_REMAIN_LC_AMT) {
		this.UFRH_REMAIN_LC_AMT = UFRH_REMAIN_LC_AMT;
	}

	public Double getUFRH_REMAIN_LC_AMT() {
		return UFRH_REMAIN_LC_AMT;
	}

	public void setUFRH_SYS_ID(Long UFRH_SYS_ID) {
		this.UFRH_SYS_ID = UFRH_SYS_ID;
	}

	public Long getUFRH_SYS_ID() {
		return UFRH_SYS_ID;
	}

	public void setUFRH_AC_GEN_YN(String UFRH_AC_GEN_YN) {
		this.UFRH_AC_GEN_YN = UFRH_AC_GEN_YN;
	}

	public String getUFRH_AC_GEN_YN() {
		return UFRH_AC_GEN_YN;
	}

	public void setUFRH_TRAN_DT(Date UFRH_TRAN_DT) {
		this.UFRH_TRAN_DT = UFRH_TRAN_DT;
	}

	public Date getUFRH_TRAN_DT() {
		return UFRH_TRAN_DT;
	}

	public void setUFRH_COMM_LC_AMT(Double UFRH_COMM_LC_AMT) {
		this.UFRH_COMM_LC_AMT = UFRH_COMM_LC_AMT;
	}

	public Double getUFRH_COMM_LC_AMT() {
		return UFRH_COMM_LC_AMT;
	}

	public void setUFRH_POL_NO(String UFRH_POL_NO) {
		this.UFRH_POL_NO = UFRH_POL_NO;
	}

	public String getUFRH_POL_NO() {
		return UFRH_POL_NO;
	}

	public void setUFRH_DEL_FLAG(String UFRH_DEL_FLAG) {
		this.UFRH_DEL_FLAG = UFRH_DEL_FLAG;
	}

	public String getUFRH_DEL_FLAG() {
		return UFRH_DEL_FLAG;
	}

	public void setUFRH_YEAR(Double UFRH_YEAR) {
		this.UFRH_YEAR = UFRH_YEAR;
	}

	public Double getUFRH_YEAR() {
		return UFRH_YEAR;
	}

	public String getGRID_PC_SCHD_PYMT_DT(){
		return CommonUtils.dateToPELStringFormatter(PC_SCHD_PYMT_DT);
	}
	public Date getPC_SCHD_PYMT_DT() {
		return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date pc_schd_pymt_dt) {
		PC_SCHD_PYMT_DT = pc_schd_pymt_dt;
	}

	public String getGRID_PC_PAID_DT(){
		return CommonUtils.dateToPELStringFormatter(PC_PAID_DT);
	}
	public Date getPC_PAID_DT() {
		return PC_PAID_DT;
	}

	public void setPC_PAID_DT(Date pc_paid_dt) {
		PC_PAID_DT = pc_paid_dt;
	}

}

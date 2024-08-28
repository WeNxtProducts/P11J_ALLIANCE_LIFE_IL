package com.iii.pel.forms.PILP091_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PS_IL_CONT_PAID_HDR")
public class PS_IL_CONT_PAID_HDR extends BaseValueBean {

	@Column(name = "CPH_SYS_ID")
	private Integer CPH_SYS_ID;

	@Column(name = "CPH_POL_SYS_ID")
	private Integer CPH_POL_SYS_ID;

	@Column(name = "CPH_POL_NO")
	private String CPH_POL_NO;

	@Column(name = "CPH_PRO_DT")
	private Date CPH_PRO_DT;

	@Column(name = "CPH_ACNT_YEAR")
	private Double CPH_ACNT_YEAR;

	@Column(name = "CPH_SUSP_PROFIT")
	private Double CPH_SUSP_PROFIT;

	@Column(name = "CPH_PSA_AMT")
	private Double CPH_PSA_AMT;

	@Column(name = "CPH_GFTA_AMT")
	private Double CPH_GFTA_AMT;

	@Column(name = "CPH_PA_PROFIT")
	private Double CPH_PA_PROFIT;

	@Column(name = "CPH_FREEZE_FLAG")
	private String CPH_FREEZE_FLAG;

	@Column(name = "CPH_GFTA_PROFIT")
	private Double CPH_GFTA_PROFIT;

	@Column(name = "CPH_CONFIRM_FLAG")
	private String CPH_CONFIRM_FLAG;

	@Column(name = "CPH_PROD_CODE")
	private String CPH_PROD_CODE;

	@Column(name = "CPH_APPROVE_YN")
	private String CPH_APPROVE_YN;

	public void setCPH_POL_NO(String CPH_POL_NO) {
		this.CPH_POL_NO = CPH_POL_NO;
	}

	public String getCPH_POL_NO() {
		return CPH_POL_NO;
	}

	public void setCPH_CONFIRM_FLAG(String CPH_CONFIRM_FLAG) {
		this.CPH_CONFIRM_FLAG = CPH_CONFIRM_FLAG;
	}

	public String getCPH_CONFIRM_FLAG() {
		return CPH_CONFIRM_FLAG;
	}

	public void setCPH_SUSP_PROFIT(Double CPH_SUSP_PROFIT) {
		this.CPH_SUSP_PROFIT = CPH_SUSP_PROFIT;
	}

	public Double getCPH_SUSP_PROFIT() {
		return CPH_SUSP_PROFIT;
	}

	public void setCPH_PROD_CODE(String CPH_PROD_CODE) {
		this.CPH_PROD_CODE = CPH_PROD_CODE;
	}

	public String getCPH_PROD_CODE() {
		return CPH_PROD_CODE;
	}

	public void setCPH_GFTA_PROFIT(Double CPH_GFTA_PROFIT) {
		this.CPH_GFTA_PROFIT = CPH_GFTA_PROFIT;
	}

	public Double getCPH_GFTA_PROFIT() {
		return CPH_GFTA_PROFIT;
	}

	public void setCPH_PSA_AMT(Double CPH_PSA_AMT) {
		this.CPH_PSA_AMT = CPH_PSA_AMT;
	}

	public Double getCPH_PSA_AMT() {
		return CPH_PSA_AMT;
	}

	public void setCPH_PRO_DT(Date CPH_PRO_DT) {
		this.CPH_PRO_DT = CPH_PRO_DT;
	}

	public Date getCPH_PRO_DT() {
		return CPH_PRO_DT;
	}

	public void setCPH_ACNT_YEAR(Double CPH_ACNT_YEAR) {
		this.CPH_ACNT_YEAR = CPH_ACNT_YEAR;
	}

	public Double getCPH_ACNT_YEAR() {
		return CPH_ACNT_YEAR;
	}

	public Integer getCPH_SYS_ID() {
		return CPH_SYS_ID;
	}

	public void setCPH_SYS_ID(Integer cph_sys_id) {
		CPH_SYS_ID = cph_sys_id;
	}

	public Integer getCPH_POL_SYS_ID() {
		return CPH_POL_SYS_ID;
	}

	public void setCPH_POL_SYS_ID(Integer cph_pol_sys_id) {
		CPH_POL_SYS_ID = cph_pol_sys_id;
	}

	public void setCPH_PA_PROFIT(Double CPH_PA_PROFIT) {
		this.CPH_PA_PROFIT = CPH_PA_PROFIT;
	}

	public Double getCPH_PA_PROFIT() {
		return CPH_PA_PROFIT;
	}

	public void setCPH_FREEZE_FLAG(String CPH_FREEZE_FLAG) {
		this.CPH_FREEZE_FLAG = CPH_FREEZE_FLAG;
	}

	public String getCPH_FREEZE_FLAG() {
		return CPH_FREEZE_FLAG;
	}

	public void setCPH_APPROVE_YN(String CPH_APPROVE_YN) {
		this.CPH_APPROVE_YN = CPH_APPROVE_YN;
	}

	public String getCPH_APPROVE_YN() {
		return CPH_APPROVE_YN;
	}

	public void setCPH_GFTA_AMT(Double CPH_GFTA_AMT) {
		this.CPH_GFTA_AMT = CPH_GFTA_AMT;
	}

	public Double getCPH_GFTA_AMT() {
		return CPH_GFTA_AMT;
	}

}

package com.iii.pel.forms.PILT027;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_TOP_UP")
public class PT_IL_TOP_UP_1 extends BaseValueBean {

	@Column(name="TU_POL_NO")
	private String TU_POL_NO;

	@Column(name="TU_LC_TOPUP_DEP_AMT")
	private Double TU_LC_TOPUP_DEP_AMT;

	@Column(name="TU_LC_TOPUP_CHRG_AMT")
	private Double TU_LC_TOPUP_CHRG_AMT;

	@Column(name="TU_LC_TOPUP_NET_AMT")
	private Double TU_LC_TOPUP_NET_AMT;

	@Column(name="TU_TXN_CODE")
	private String TU_TXN_CODE;

	@Column(name="TU_DOC_NO")
	private Double TU_DOC_NO;

	@Column(name="TU_DOC_DT")
	private Date TU_DOC_DT;

	private Double UI_M_SUM_DEP;

	@Column(name="TU_REASON_CODE")
	private String TU_REASON_CODE;

	private String UI_M_REASON_DESC;

	@Column(name="TU_FLEX_01")
	private String TU_FLEX_01;

	@Column(name="TU_REMARKS")
	private String TU_REMARKS;

	@Column(name="TU_FLEX_02")
	private String TU_FLEX_02;

	private String UI_M_TU_REVERSE_FLAG;

	@Column(name="TU_FLEX_03")
	private String TU_FLEX_03;



	public String getTU_POL_NO() {
		return TU_POL_NO;
	}

	public void setTU_POL_NO(String TU_POL_NO) {
		this.TU_POL_NO = TU_POL_NO;
	}

	public Double getTU_LC_TOPUP_DEP_AMT() {
		return TU_LC_TOPUP_DEP_AMT;
	}

	public void setTU_LC_TOPUP_DEP_AMT(Double TU_LC_TOPUP_DEP_AMT) {
		this.TU_LC_TOPUP_DEP_AMT = TU_LC_TOPUP_DEP_AMT;
	}

	public Double getTU_LC_TOPUP_CHRG_AMT() {
		return TU_LC_TOPUP_CHRG_AMT;
	}

	public void setTU_LC_TOPUP_CHRG_AMT(Double TU_LC_TOPUP_CHRG_AMT) {
		this.TU_LC_TOPUP_CHRG_AMT = TU_LC_TOPUP_CHRG_AMT;
	}

	public Double getTU_LC_TOPUP_NET_AMT() {
		return TU_LC_TOPUP_NET_AMT;
	}

	public void setTU_LC_TOPUP_NET_AMT(Double TU_LC_TOPUP_NET_AMT) {
		this.TU_LC_TOPUP_NET_AMT = TU_LC_TOPUP_NET_AMT;
	}

	public String getTU_TXN_CODE() {
		return TU_TXN_CODE;
	}

	public void setTU_TXN_CODE(String TU_TXN_CODE) {
		this.TU_TXN_CODE = TU_TXN_CODE;
	}

	public Double getTU_DOC_NO() {
		return TU_DOC_NO;
	}

	public void setTU_DOC_NO(Double TU_DOC_NO) {
		this.TU_DOC_NO = TU_DOC_NO;
	}

	public Date getTU_DOC_DT() {
		 return TU_DOC_DT;
	}

	public void setTU_DOC_DT(Date TU_DOC_DT) {
		this.TU_DOC_DT = TU_DOC_DT;
	}

	public Double getUI_M_SUM_DEP() {
		return UI_M_SUM_DEP;
	}

	public void setUI_M_SUM_DEP(Double UI_M_SUM_DEP) {
		this.UI_M_SUM_DEP = UI_M_SUM_DEP;
	}

	public String getTU_REASON_CODE() {
		return TU_REASON_CODE;
	}

	public void setTU_REASON_CODE(String TU_REASON_CODE) {
		this.TU_REASON_CODE = TU_REASON_CODE;
	}

	public String getUI_M_REASON_DESC() {
		return UI_M_REASON_DESC;
	}

	public void setUI_M_REASON_DESC(String UI_M_REASON_DESC) {
		this.UI_M_REASON_DESC = UI_M_REASON_DESC;
	}

	public String getTU_FLEX_01() {
		return TU_FLEX_01;
	}

	public void setTU_FLEX_01(String TU_FLEX_01) {
		this.TU_FLEX_01 = TU_FLEX_01;
	}

	public String getTU_REMARKS() {
		return TU_REMARKS;
	}

	public void setTU_REMARKS(String TU_REMARKS) {
		this.TU_REMARKS = TU_REMARKS;
	}

	public String getTU_FLEX_02() {
		return TU_FLEX_02;
	}

	public void setTU_FLEX_02(String TU_FLEX_02) {
		this.TU_FLEX_02 = TU_FLEX_02;
	}

	public String getUI_M_TU_REVERSE_FLAG() {
		return UI_M_TU_REVERSE_FLAG;
	}

	public void setUI_M_TU_REVERSE_FLAG(String UI_M_TU_REVERSE_FLAG) {
		this.UI_M_TU_REVERSE_FLAG = UI_M_TU_REVERSE_FLAG;
	}

	public String getTU_FLEX_03() {
		return TU_FLEX_03;
	}

	public void setTU_FLEX_03(String TU_FLEX_03) {
		this.TU_FLEX_03 = TU_FLEX_03;
	}
}

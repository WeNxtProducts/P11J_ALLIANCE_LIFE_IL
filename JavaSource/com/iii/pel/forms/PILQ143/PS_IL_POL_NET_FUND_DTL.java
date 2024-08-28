package com.iii.pel.forms.PILQ143;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_POL_NET_FUND_DTL")
public class PS_IL_POL_NET_FUND_DTL extends BaseValueBean{
	
	private String UI_M_POL_NO;
	
	@Column(name="PNFD_POL_SYS_ID")
	private Long PNFD_POL_SYS_ID;
	
	@Column(name="PNFD_MONTH")
	private Integer PNFD_MONTH;
	
	@Column(name="PNFD_LC_PREM")
	private Double PNFD_LC_PREM;
	
	@Column(name="PNFD_COI_VAL")
	private Double PNFD_COI_VAL;
	
	@Column(name="PNFD_GROSS_CF_VAL")
	private Double PNFD_GROSS_CF_VAL;
	
	@Column(name="PFND_NEW_LC_SA")
	private Double PFND_NEW_LC_SA;
	
	@Column(name="PNFD_NEW_COI_VAL")
	private Double PNFD_NEW_COI_VAL;
	
	@Column(name="PNFD_NET_CF_VAL")
	private Double PNFD_NET_CF_VAL;
	
	@Column(name="PNFD_DT")
	private Date PNFD_DT;
	
	private String UI_M_PNFD_DT;
	
	public Long getPNFD_POL_SYS_ID() {
		return PNFD_POL_SYS_ID;
	}

	public void setPNFD_POL_SYS_ID(Long pNFD_POL_SYS_ID) {
		PNFD_POL_SYS_ID = pNFD_POL_SYS_ID;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String uI_M_POL_NO) {
		UI_M_POL_NO = uI_M_POL_NO;
	}

	public Integer getPNFD_MONTH() {
		return PNFD_MONTH;
	}

	public void setPNFD_MONTH(Integer pNFD_MONTH) {
		PNFD_MONTH = pNFD_MONTH;
	}

	public Double getPNFD_LC_PREM() {
		return PNFD_LC_PREM;
	}

	public void setPNFD_LC_PREM(Double pNFD_LC_PREM) {
		PNFD_LC_PREM = pNFD_LC_PREM;
	}

	public Double getPNFD_COI_VAL() {
		return PNFD_COI_VAL;
	}

	public void setPNFD_COI_VAL(Double pNFD_COI_VAL) {
		PNFD_COI_VAL = pNFD_COI_VAL;
	}

	public Double getPNFD_GROSS_CF_VAL() {
		return PNFD_GROSS_CF_VAL;
	}

	public void setPNFD_GROSS_CF_VAL(Double pNFD_GROSS_CF_VAL) {
		PNFD_GROSS_CF_VAL = pNFD_GROSS_CF_VAL;
	}

	public Double getPFND_NEW_LC_SA() {
		return PFND_NEW_LC_SA;
	}

	public void setPFND_NEW_LC_SA(Double pFND_NEW_LC_SA) {
		PFND_NEW_LC_SA = pFND_NEW_LC_SA;
	}

	public Double getPNFD_NEW_COI_VAL() {
		return PNFD_NEW_COI_VAL;
	}

	public void setPNFD_NEW_COI_VAL(Double pNFD_NEW_COI_VAL) {
		PNFD_NEW_COI_VAL = pNFD_NEW_COI_VAL;
	}

	public Double getPNFD_NET_CF_VAL() {
		return PNFD_NET_CF_VAL;
	}

	public void setPNFD_NET_CF_VAL(Double pNFD_NET_CF_VAL) {
		PNFD_NET_CF_VAL = pNFD_NET_CF_VAL;
	}

	public Date getPNFD_DT() {
		return PNFD_DT;
	}

	public void setPNFD_DT(Date pNFD_DT) {
		PNFD_DT = pNFD_DT;
	}

	public String getUI_M_PNFD_DT() {
		return UI_M_PNFD_DT;
	}

	public void setUI_M_PNFD_DT(String uI_M_PNFD_DT) {
		UI_M_PNFD_DT = uI_M_PNFD_DT;
	}

}

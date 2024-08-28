package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROP_TREATY_TYPE")
public class PM_IL_PROP_TREATY_TYPE extends BaseValueBean {

	@Column(name = "PTT_FRZ_FLAG")
	private String PTT_FRZ_FLAG;

	@Column(name = "PTT_SRNO")
	private Double PTT_SRNO;

	@Column(name = "PTT_TREATY_TYPE")
	private String PTT_TREATY_TYPE;

	private String UI_M_TREATY_DESC;

	@Column(name = "PTT_PROFIT_COMM")
	private Double PTT_PROFIT_COMM;

	@Column(name = "PTT_MGT_EXP_RATIO")
	private Double PTT_MGT_EXP_RATIO;

	@Column(name = "PTT_REINS_TAX_PERC")
	private Double PTT_REINS_TAX_PERC;

	@Column(name = "PTT_INT_ON_RES_REL")
	private Double PTT_INT_ON_RES_REL;

	@Column(name = "PTT_PREM_RES_RATIO")
	private Double PTT_PREM_RES_RATIO;

	@Column(name = "PTT_LOSS_CF_YEARS")
	private Double PTT_LOSS_CF_YEARS;

	@Column(name = "PTT_OS_CLM_RES_RATIO")
	private Double PTT_OS_CLM_RES_RATIO;

	@Column(name = "PTT_EXCLUSION")
	private String PTT_EXCLUSION;

	@Column(name = "PTT_DEPOSIT_PREM")
	private Double PTT_DEPOSIT_PREM;

	@Column(name = "PTT_NOTICE_CANCEL_DAYS")
	private Double PTT_NOTICE_CANCEL_DAYS;

	@Column(name = "PTT_ACCOUNTS_SUBMIT_PERIOD")
	private String PTT_ACCOUNTS_SUBMIT_PERIOD;

	@Column(name = "PTT_LINK_TREATY_CODE")
	private String PTT_LINK_TREATY_CODE;

	private String UI_M_LINK_TREATY_DESC;

	@Column(name = "PTT_NET_SURPLUS_AMT")
	private Double PTT_NET_SURPLUS_AMT;

	@Column(name = "PTT_ACCOUNTS_CLOSE_PERIOD")
	private String PTT_ACCOUNTS_CLOSE_PERIOD;

	@Column(name = "PTT_PREM_PF_ENT_PERC")
	private Double PTT_PREM_PF_ENT_PERC;

	@Column(name = "PTT_PREM_PF_WD_PERC")
	private Double PTT_PREM_PF_WD_PERC;

	@Column(name = "PTT_LOSS_PF_ENT_PERC")
	private Double PTT_LOSS_PF_ENT_PERC;

	@Column(name = "PTT_LOSS_PF_WD_PERC")
	private Double PTT_LOSS_PF_WD_PERC;

	@Column(name = "PTT_PT_SYS_ID")
	private Double PTT_PT_SYS_ID;

	@Column(name = "PTT_SYS_ID")
	private Double PTT_SYS_ID;

	@Column(name = "PTT_CR_UID")
	private String PTT_CR_UID;

	@Column(name = "PTT_CR_DT")
	private Date PTT_CR_DT;

	@Column(name = "PTT_UPD_UID")
	private String PTT_UPD_UID;

	@Column(name = "PTT_UPD_DT")
	private Date PTT_UPD_DT;

	private boolean selected = false;

	private boolean freeze;

	public PM_IL_PROP_TREATY_TYPE() {
		this.setPTT_ACCOUNTS_SUBMIT_PERIOD("M");
		this.setPTT_ACCOUNTS_CLOSE_PERIOD("M");
	}

	public String getPTT_FRZ_FLAG() {
		return PTT_FRZ_FLAG;
	}

	public void setPTT_FRZ_FLAG(String PTT_FRZ_FLAG) {
		this.PTT_FRZ_FLAG = PTT_FRZ_FLAG;
	}

	public Double getPTT_SRNO() {
		return PTT_SRNO;
	}

	public void setPTT_SRNO(Double PTT_SRNO) {

		this.PTT_SRNO = PTT_SRNO;
	}

	public String getPTT_TREATY_TYPE() {
		return PTT_TREATY_TYPE;
	}

	public void setPTT_TREATY_TYPE(String PTT_TREATY_TYPE) {
		this.PTT_TREATY_TYPE = PTT_TREATY_TYPE;
	}

	public String getUI_M_TREATY_DESC() {
		return UI_M_TREATY_DESC;
	}

	public void setUI_M_TREATY_DESC(String UI_M_TREATY_DESC) {
		this.UI_M_TREATY_DESC = UI_M_TREATY_DESC;
	}

	public Double getPTT_PROFIT_COMM() {
		return PTT_PROFIT_COMM;
	}

	public void setPTT_PROFIT_COMM(Double PTT_PROFIT_COMM) {
		this.PTT_PROFIT_COMM = PTT_PROFIT_COMM;
	}

	public Double getPTT_MGT_EXP_RATIO() {
		return PTT_MGT_EXP_RATIO;
	}

	public void setPTT_MGT_EXP_RATIO(Double PTT_MGT_EXP_RATIO) {
		this.PTT_MGT_EXP_RATIO = PTT_MGT_EXP_RATIO;
	}

	public Double getPTT_REINS_TAX_PERC() {
		return PTT_REINS_TAX_PERC;
	}

	public void setPTT_REINS_TAX_PERC(Double PTT_REINS_TAX_PERC) {
		this.PTT_REINS_TAX_PERC = PTT_REINS_TAX_PERC;
	}

	public Double getPTT_INT_ON_RES_REL() {
		return PTT_INT_ON_RES_REL;
	}

	public void setPTT_INT_ON_RES_REL(Double PTT_INT_ON_RES_REL) {
		this.PTT_INT_ON_RES_REL = PTT_INT_ON_RES_REL;
	}

	public Double getPTT_PREM_RES_RATIO() {
		return PTT_PREM_RES_RATIO;
	}

	public void setPTT_PREM_RES_RATIO(Double PTT_PREM_RES_RATIO) {
		this.PTT_PREM_RES_RATIO = PTT_PREM_RES_RATIO;
	}

	public Double getPTT_LOSS_CF_YEARS() {
		return PTT_LOSS_CF_YEARS;
	}

	public void setPTT_LOSS_CF_YEARS(Double PTT_LOSS_CF_YEARS) {
		this.PTT_LOSS_CF_YEARS = PTT_LOSS_CF_YEARS;
	}

	public Double getPTT_OS_CLM_RES_RATIO() {
		return PTT_OS_CLM_RES_RATIO;
	}

	public void setPTT_OS_CLM_RES_RATIO(Double PTT_OS_CLM_RES_RATIO) {
		this.PTT_OS_CLM_RES_RATIO = PTT_OS_CLM_RES_RATIO;
	}

	public String getPTT_EXCLUSION() {
		return PTT_EXCLUSION;
	}

	public void setPTT_EXCLUSION(String PTT_EXCLUSION) {
		this.PTT_EXCLUSION = PTT_EXCLUSION;
	}

	public Double getPTT_DEPOSIT_PREM() {
		return PTT_DEPOSIT_PREM;
	}

	public void setPTT_DEPOSIT_PREM(Double PTT_DEPOSIT_PREM) {
		this.PTT_DEPOSIT_PREM = PTT_DEPOSIT_PREM;
	}

	public Double getPTT_NOTICE_CANCEL_DAYS() {
		return PTT_NOTICE_CANCEL_DAYS;
	}

	public void setPTT_NOTICE_CANCEL_DAYS(Double PTT_NOTICE_CANCEL_DAYS) {
		this.PTT_NOTICE_CANCEL_DAYS = PTT_NOTICE_CANCEL_DAYS;
	}

	public String getPTT_ACCOUNTS_SUBMIT_PERIOD() {
		return PTT_ACCOUNTS_SUBMIT_PERIOD;
	}

	public void setPTT_ACCOUNTS_SUBMIT_PERIOD(String PTT_ACCOUNTS_SUBMIT_PERIOD) {
		this.PTT_ACCOUNTS_SUBMIT_PERIOD = PTT_ACCOUNTS_SUBMIT_PERIOD;
	}

	public String getPTT_LINK_TREATY_CODE() {
		return PTT_LINK_TREATY_CODE;
	}

	public void setPTT_LINK_TREATY_CODE(String PTT_LINK_TREATY_CODE) {
		this.PTT_LINK_TREATY_CODE = PTT_LINK_TREATY_CODE;
	}

	public String getUI_M_LINK_TREATY_DESC() {
		return UI_M_LINK_TREATY_DESC;
	}

	public void setUI_M_LINK_TREATY_DESC(String UI_M_LINK_TREATY_DESC) {
		this.UI_M_LINK_TREATY_DESC = UI_M_LINK_TREATY_DESC;
	}

	public Double getPTT_NET_SURPLUS_AMT() {
		return PTT_NET_SURPLUS_AMT;
	}

	public void setPTT_NET_SURPLUS_AMT(Double PTT_NET_SURPLUS_AMT) {
		this.PTT_NET_SURPLUS_AMT = PTT_NET_SURPLUS_AMT;
	}

	public String getPTT_ACCOUNTS_CLOSE_PERIOD() {
		return PTT_ACCOUNTS_CLOSE_PERIOD;
	}

	public void setPTT_ACCOUNTS_CLOSE_PERIOD(String PTT_ACCOUNTS_CLOSE_PERIOD) {
		this.PTT_ACCOUNTS_CLOSE_PERIOD = PTT_ACCOUNTS_CLOSE_PERIOD;
	}

	public Double getPTT_PREM_PF_ENT_PERC() {
		return PTT_PREM_PF_ENT_PERC;
	}

	public void setPTT_PREM_PF_ENT_PERC(Double PTT_PREM_PF_ENT_PERC) {
		this.PTT_PREM_PF_ENT_PERC = PTT_PREM_PF_ENT_PERC;
	}

	public Double getPTT_PREM_PF_WD_PERC() {
		return PTT_PREM_PF_WD_PERC;
	}

	public void setPTT_PREM_PF_WD_PERC(Double PTT_PREM_PF_WD_PERC) {
		this.PTT_PREM_PF_WD_PERC = PTT_PREM_PF_WD_PERC;
	}

	public Double getPTT_LOSS_PF_ENT_PERC() {
		return PTT_LOSS_PF_ENT_PERC;
	}

	public void setPTT_LOSS_PF_ENT_PERC(Double PTT_LOSS_PF_ENT_PERC) {
		this.PTT_LOSS_PF_ENT_PERC = PTT_LOSS_PF_ENT_PERC;
	}

	public Double getPTT_LOSS_PF_WD_PERC() {
		return PTT_LOSS_PF_WD_PERC;
	}

	public void setPTT_LOSS_PF_WD_PERC(Double PTT_LOSS_PF_WD_PERC) {
		this.PTT_LOSS_PF_WD_PERC = PTT_LOSS_PF_WD_PERC;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getPTT_PT_SYS_ID() {
		return PTT_PT_SYS_ID;
	}

	public void setPTT_PT_SYS_ID(Double ptt_pt_sys_id) {
		PTT_PT_SYS_ID = ptt_pt_sys_id;
	}

	public Double getPTT_SYS_ID() {
		System.out.println("--------->" + PTT_SYS_ID);
		return PTT_SYS_ID;
	}

	public void setPTT_SYS_ID(Double ptt_sys_id) {
		System.out.println("sysId---->" + ptt_sys_id);
		PTT_SYS_ID = ptt_sys_id;
	}

	public String getPTT_CR_UID() {
		return PTT_CR_UID;
	}

	public void setPTT_CR_UID(String ptt_cr_uid) {
		PTT_CR_UID = ptt_cr_uid;
	}

	public Date getPTT_CR_DT() {
		return PTT_CR_DT;
	}

	public void setPTT_CR_DT(Date ptt_cr_dt) {
		PTT_CR_DT = ptt_cr_dt;
	}

	public String getPTT_UPD_UID() {
		return PTT_UPD_UID;
	}

	public void setPTT_UPD_UID(String ptt_upd_uid) {
		PTT_UPD_UID = ptt_upd_uid;
	}

	public Date getPTT_UPD_DT() {
		return PTT_UPD_DT;
	}

	public void setPTT_UPD_DT(Date ptt_upd_dt) {
		PTT_UPD_DT = ptt_upd_dt;
	}

	public boolean isFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

}

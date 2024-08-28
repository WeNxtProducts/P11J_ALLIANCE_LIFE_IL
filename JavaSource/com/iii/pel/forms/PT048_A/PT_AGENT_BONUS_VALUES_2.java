package com.iii.pel.forms.PT048_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_BONUS_VALUES")
public class PT_AGENT_BONUS_VALUES_2 extends BaseValueBean{

	@Column(name="ABV_AGENT_CODE")
	private String ABV_AGENT_CODE;

	@Column(name="ABV_BONUS_TYPE")
	private String ABV_BONUS_TYPE;

	@Column(name="ABV_BONUS_CODE")
	private String ABV_BONUS_CODE;

	@Column(name="ABV_CURR_CODE")
	private String ABV_CURR_CODE;

	/*Modified by ganesh on 02-06-2018 as per sivaram suggestion*/
	/*@Column(name="ABV_PROCESS_YR")
	private Double ABV_PROCESS_YR;*/
	@Column(name="ABV_PROCESS_YR")
	private Integer ABV_PROCESS_YR;
	/*end*/

	@Column(name="ABV_PR_RATE_NR")
	private Double ABV_PR_RATE_NR;

	@Column(name="ABV_PR_RATE_DR")
	private Double ABV_PR_RATE_DR;

	@Column(name="ABV_FC_VALUE")
	private Double ABV_FC_VALUE;

	private String UI_M_ABV_BONUS_DESC;

	private String UI_M_ABV_CURR_CODE_DESC;

	@Column(name="ABV_LC_VALUE")
	private Double ABV_LC_VALUE;

	@Column(name="ABV_PERIOD_FM_DT")
	private Date ABV_PERIOD_FM_DT;

	@Column(name="ABV_PERIOD_TO_DT")
	private Date ABV_PERIOD_TO_DT;

	@Column(name="ABV_PAID_DT")
	private Date ABV_PAID_DT;

	@Column(name="ABV_FRZ_FLAG")
	private String ABV_FRZ_FLAG;
	
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="ABV_PAID_FLAG")
	private String ABV_PAID_FLAG;
	
	private String UI_M_ABV_AGENT_CODE_DESC_BONUS;

	public String getABV_AGENT_CODE() {
		return ABV_AGENT_CODE;
	}

	public void setABV_AGENT_CODE(String ABV_AGENT_CODE) {
		this.ABV_AGENT_CODE = ABV_AGENT_CODE;
	}

	public String getABV_BONUS_TYPE() {
		return ABV_BONUS_TYPE;
	}

	public void setABV_BONUS_TYPE(String ABV_BONUS_TYPE) {
		this.ABV_BONUS_TYPE = ABV_BONUS_TYPE;
	}

	public String getABV_BONUS_CODE() {
		return ABV_BONUS_CODE;
	}

	public void setABV_BONUS_CODE(String ABV_BONUS_CODE) {
		this.ABV_BONUS_CODE = ABV_BONUS_CODE;
	}

	public String getABV_CURR_CODE() {
		return ABV_CURR_CODE;
	}

	public void setABV_CURR_CODE(String ABV_CURR_CODE) {
		this.ABV_CURR_CODE = ABV_CURR_CODE;
	}

	/*Modified by ganesh on 02-06-2018 as per sivaram suggestion*/
	/*public Double getABV_PROCESS_YR() {
		return ABV_PROCESS_YR;
	}

	public void setABV_PROCESS_YR(Double ABV_PROCESS_YR) {
		this.ABV_PROCESS_YR = ABV_PROCESS_YR;
	}
*/	
	public Integer getABV_PROCESS_YR() {
		return ABV_PROCESS_YR;
	}

	public void setABV_PROCESS_YR(Integer ABV_PROCESS_YR) {
		this.ABV_PROCESS_YR = ABV_PROCESS_YR;
	}

	public Double getABV_PR_RATE_NR() {
		return ABV_PR_RATE_NR;
	}

	public void setABV_PR_RATE_NR(Double ABV_PR_RATE_NR) {
		this.ABV_PR_RATE_NR = ABV_PR_RATE_NR;
	}

	public Double getABV_PR_RATE_DR() {
		return ABV_PR_RATE_DR;
	}

	public void setABV_PR_RATE_DR(Double ABV_PR_RATE_DR) {
		this.ABV_PR_RATE_DR = ABV_PR_RATE_DR;
	}

	public Double getABV_FC_VALUE() {
		return ABV_FC_VALUE;
	}

	public void setABV_FC_VALUE(Double ABV_FC_VALUE) {
		this.ABV_FC_VALUE = ABV_FC_VALUE;
	}

	public String getUI_M_ABV_BONUS_DESC() {
		return UI_M_ABV_BONUS_DESC;
	}

	public void setUI_M_ABV_BONUS_DESC(String UI_M_ABV_BONUS_DESC) {
		this.UI_M_ABV_BONUS_DESC = UI_M_ABV_BONUS_DESC;
	}

	public String getUI_M_ABV_CURR_CODE_DESC() {
		return UI_M_ABV_CURR_CODE_DESC;
	}

	public void setUI_M_ABV_CURR_CODE_DESC(String UI_M_ABV_CURR_CODE_DESC) {
		this.UI_M_ABV_CURR_CODE_DESC = UI_M_ABV_CURR_CODE_DESC;
	}

	public Double getABV_LC_VALUE() {
		return ABV_LC_VALUE;
	}

	public void setABV_LC_VALUE(Double ABV_LC_VALUE) {
		this.ABV_LC_VALUE = ABV_LC_VALUE;
	}

	public Date getABV_PERIOD_FM_DT() {
		 return ABV_PERIOD_FM_DT;
	}

	public void setABV_PERIOD_FM_DT(Date ABV_PERIOD_FM_DT) {
		this.ABV_PERIOD_FM_DT = ABV_PERIOD_FM_DT;
	}

	public Date getABV_PERIOD_TO_DT() {
		 return ABV_PERIOD_TO_DT;
	}

	public void setABV_PERIOD_TO_DT(Date ABV_PERIOD_TO_DT) {
		this.ABV_PERIOD_TO_DT = ABV_PERIOD_TO_DT;
	}

	public Date getABV_PAID_DT() {
		 return ABV_PAID_DT;
	}

	public void setABV_PAID_DT(Date ABV_PAID_DT) {
		this.ABV_PAID_DT = ABV_PAID_DT;
	}

	public String getABV_FRZ_FLAG() {
		return ABV_FRZ_FLAG;
	}

	public void setABV_FRZ_FLAG(String ABV_FRZ_FLAG) {
		this.ABV_FRZ_FLAG = ABV_FRZ_FLAG;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getUI_M_ABV_AGENT_CODE_DESC_BONUS() {
		return UI_M_ABV_AGENT_CODE_DESC_BONUS;
	}

	public void setUI_M_ABV_AGENT_CODE_DESC_BONUS(
			String ui_m_abv_agent_code_desc_bonus) {
		UI_M_ABV_AGENT_CODE_DESC_BONUS = ui_m_abv_agent_code_desc_bonus;
	}

	public String getABV_PAID_FLAG() {
		return ABV_PAID_FLAG;
	}

	public void setABV_PAID_FLAG(String abv_paid_flag) {
		ABV_PAID_FLAG = abv_paid_flag;
	}

}

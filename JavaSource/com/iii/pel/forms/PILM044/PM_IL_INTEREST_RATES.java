package com.iii.pel.forms.PILM044;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_IL_INTEREST_RATES")
public class PM_IL_INTEREST_RATES extends BaseValueBean{
	
	/*@Column(name="IR_INT_TYPE")
	private String IR_INT_TYPE;*/
	
	@Column(name="IR_TOT_CONT_FROM")
	private Double IR_TOT_CONT_FROM;
	
	@Column(name="IR_TOT_CONT_TO")
	private Double IR_TOT_CONT_TO;
	
	private String UI_M_IR_TOT_CONT_FROM;

	private String UI_M_IR_TOT_CONT_TO;
	
	@Column(name="IR_TERM_FM")
	private Integer IR_TERM_FM;
	
	@Column(name="IR_TERM_TO")
	private Integer IR_TERM_TO;
	
	@Column(name="IR_TOT_CONT_RATE")
	private Double IR_TOT_CONT_RATE;
	
	private String UI_M_IR_TOT_CONT_RATE;
	
	@Column(name="IR_TOT_CONT_RATE_PER")
	private Integer IR_TOT_CONT_RATE_PER;
	
	@Column(name="IR_EFF_FM_DT")
	private Date IR_EFF_FM_DT;
	
	@Column(name="IR_EFF_TO_DT")
	private Date IR_EFF_TO_DT;
	
	private String UI_M_IR_EFF_FM_DT;
	
	private String UI_M_IR_EFF_TO_DT;
	
	/*@Column(name="IR_COMP_CODE")
	private String IR_COMP_CODE;*/
	
	@Column(name="IR_CR_DT")
	private Date IR_CR_DT;
	
	@Column(name="IR_CR_UID")
	private String IR_CR_UID;
	
	@Column(name="IR_UPD_DT")
	private Date IR_UPD_DT;
	
	@Column(name="IR_UPD_UID")
	private String IR_UPD_UID;
	
	private String UI_M_IR_DESC;
	
	@Column(name="IR_PROD_CODE")
	private String IR_PROD_CODE;

	/*public String getIR_INT_TYPE() {
		return IR_INT_TYPE;
	}

	public void setIR_INT_TYPE(String iR_INT_TYPE) {
		IR_INT_TYPE = iR_INT_TYPE;
	}*/

	public String getIR_PROD_CODE() {
		return IR_PROD_CODE;
	}

	public void setIR_PROD_CODE(String iR_PROD_CODE) {
		IR_PROD_CODE = iR_PROD_CODE;
	}

	public Double getIR_TOT_CONT_FROM() {
		return IR_TOT_CONT_FROM;
	}

	public void setIR_TOT_CONT_FROM(Double iR_TOT_CONT_FROM) {
		IR_TOT_CONT_FROM = iR_TOT_CONT_FROM;
	}

	public Double getIR_TOT_CONT_TO() {
		return IR_TOT_CONT_TO;
	}

	public void setIR_TOT_CONT_TO(Double iR_TOT_CONT_TO) {
		IR_TOT_CONT_TO = iR_TOT_CONT_TO;
	}

	public Integer getIR_TERM_FM() {
		return IR_TERM_FM;
	}

	public void setIR_TERM_FM(Integer iR_TERM_FM) {
		IR_TERM_FM = iR_TERM_FM;
	}

	public Integer getIR_TERM_TO() {
		return IR_TERM_TO;
	}

	public void setIR_TERM_TO(Integer iR_TERM_TO) {
		IR_TERM_TO = iR_TERM_TO;
	}

	public Double getIR_TOT_CONT_RATE() {
		return IR_TOT_CONT_RATE;
	}

	public void setIR_TOT_CONT_RATE(Double iR_TOT_CONT_RATE) {
		IR_TOT_CONT_RATE = iR_TOT_CONT_RATE;
	}

	public Integer getIR_TOT_CONT_RATE_PER() {
		return IR_TOT_CONT_RATE_PER;
	}

	public void setIR_TOT_CONT_RATE_PER(Integer iR_TOT_CONT_RATE_PER) {
		IR_TOT_CONT_RATE_PER = iR_TOT_CONT_RATE_PER;
	}

	public Date getIR_EFF_FM_DT() {
		return IR_EFF_FM_DT;
	}

	public void setIR_EFF_FM_DT(Date iR_EFF_FM_DT) {
		IR_EFF_FM_DT = iR_EFF_FM_DT;
		//setUI_M_IR_EFF_FM_DT(new SimpleDateFormat("dd/MM/yyyy").format(IR_EFF_FM_DT));
	}

	public Date getIR_EFF_TO_DT() {
		return IR_EFF_TO_DT;
	}

	public void setIR_EFF_TO_DT(Date iR_EFF_TO_DT) {
		IR_EFF_TO_DT = iR_EFF_TO_DT;
		//setUI_M_IR_EFF_TO_DT(new SimpleDateFormat("dd/MM/yyyy").format(IR_EFF_TO_DT));
	}

	/*public String getIR_COMP_CODE() {
		return IR_COMP_CODE;
	}

	public void setIR_COMP_CODE(String iR_COMP_CODE) {
		IR_COMP_CODE = iR_COMP_CODE;
	}*/

	public String getUI_M_IR_DESC() {
		return UI_M_IR_DESC;
	}

	public void setUI_M_IR_DESC(String uI_M_IR_DESC) {
		UI_M_IR_DESC = uI_M_IR_DESC;
	}

	public String getUI_M_IR_EFF_FM_DT() {
		return UI_M_IR_EFF_FM_DT;
	}

	public void setUI_M_IR_EFF_FM_DT(String uI_M_IR_EFF_FM_DT) {
		UI_M_IR_EFF_FM_DT = uI_M_IR_EFF_FM_DT;
	}

	public String getUI_M_IR_EFF_TO_DT() {
		return UI_M_IR_EFF_TO_DT;
	}

	public void setUI_M_IR_EFF_TO_DT(String uI_M_IR_EFF_TO_DT) {
		UI_M_IR_EFF_TO_DT = uI_M_IR_EFF_TO_DT;
	}

	public Date getIR_CR_DT() {
		return IR_CR_DT;
	}

	public void setIR_CR_DT(Date iR_CR_DT) {
		IR_CR_DT = iR_CR_DT;
	}

	public String getIR_CR_UID() {
		return IR_CR_UID;
	}

	public void setIR_CR_UID(String iR_CR_UID) {
		IR_CR_UID = iR_CR_UID;
	}

	public Date getIR_UPD_DT() {
		return IR_UPD_DT;
	}

	public void setIR_UPD_DT(Date iR_UPD_DT) {
		IR_UPD_DT = iR_UPD_DT;
	}

	public String getIR_UPD_UID() {
		return IR_UPD_UID;
	}

	public void setIR_UPD_UID(String iR_UPD_UID) {
		IR_UPD_UID = iR_UPD_UID;
	}

	public String getUI_M_IR_TOT_CONT_FROM() {
		return UI_M_IR_TOT_CONT_FROM;
	}

	public void setUI_M_IR_TOT_CONT_FROM(String uI_M_IR_TOT_CONT_FROM) {
		UI_M_IR_TOT_CONT_FROM = uI_M_IR_TOT_CONT_FROM;
	}

	public String getUI_M_IR_TOT_CONT_TO() {
		return UI_M_IR_TOT_CONT_TO;
	}

	public void setUI_M_IR_TOT_CONT_TO(String uI_M_IR_TOT_CONT_TO) {
		UI_M_IR_TOT_CONT_TO = uI_M_IR_TOT_CONT_TO;
	}

	public String getUI_M_IR_TOT_CONT_RATE() {
		return UI_M_IR_TOT_CONT_RATE;
	}

	public void setUI_M_IR_TOT_CONT_RATE(String uI_M_IR_TOT_CONT_RATE) {
		UI_M_IR_TOT_CONT_RATE = uI_M_IR_TOT_CONT_RATE;
	}

}

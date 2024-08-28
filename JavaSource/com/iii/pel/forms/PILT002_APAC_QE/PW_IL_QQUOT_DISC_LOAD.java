package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PW_IL_QQUOT_DISC_LOAD")
public class PW_IL_QQUOT_DISC_LOAD extends BaseValueBean {
	
	


	
	@Column(name="QQDL_SYS_ID")
	private Long QQDL_SYS_ID;
	
	@Column(name="QQDL_QUOT_SYS_ID")
	private Long QQDL_QUOT_SYS_ID;
	
	@Column(name="QQDL_DISC_LOAD_TYPE")
	private String QQDL_DISC_LOAD_TYPE;
	
	@Column(name="QQDL_DISC_LOAD_CODE")
	private String QQDL_DISC_LOAD_CODE;
	
	@Column(name="QQDL_FC_DISC_LOAD_AMT")
	private Double QQDL_FC_DISC_LOAD_AMT;
	
	@Column(name="QQDL_LC_DISC_LOAD_AMT")
	private Double QQDL_LC_DISC_LOAD_AMT;
	
	
	@Column(name="QQDL_SRNO")
	private int QQDL_SRNO;
	
	public int getQQDL_SRNO() {
		return QQDL_SRNO;
	}

	public void setQQDL_SRNO(int qQDL_SRNO) {
		QQDL_SRNO = qQDL_SRNO;
	}

	@Column(name="QQDL_APPLIED_ON")
	private String QQDL_APPLIED_ON;
	
	@Column(name="QQDL_COVER_CODE")
	private String QQDL_COVER_CODE;
	
	
	private String UI_M_DISCLOAD_DESC;
	private String UI_M_APPLIED_ON_DESC;
	
	private String UI_M_QQDL_COVER_DESC;
	
	
	public String getUI_M_QQDL_COVER_DESC() {
		return UI_M_QQDL_COVER_DESC;
	}

	public void setUI_M_QQDL_COVER_DESC(String uI_M_QQDL_COVER_DESC) {
		UI_M_QQDL_COVER_DESC = uI_M_QQDL_COVER_DESC;
	}

	public String getQQDL_COVER_CODE() {
		return QQDL_COVER_CODE;
	}

	public void setQQDL_COVER_CODE(String qQDL_COVER_CODE) {
		QQDL_COVER_CODE = qQDL_COVER_CODE;
	}

	public String getUI_M_DISCLOAD_DESC() {
		return UI_M_DISCLOAD_DESC;
	}

	public void setUI_M_DISCLOAD_DESC(String uI_M_DISCLOAD_DESC) {
		UI_M_DISCLOAD_DESC = uI_M_DISCLOAD_DESC;
	}

	public String getQQDL_APPLIED_ON() {
		return QQDL_APPLIED_ON;
	}

	public void setQQDL_APPLIED_ON(String qQDL_APPLIED_ON) {
		QQDL_APPLIED_ON = qQDL_APPLIED_ON;
	}

	public Double getQQDL_RATE() {
		return QQDL_RATE;
	}

	public void setQQDL_RATE(Double qQDL_RATE) {
		QQDL_RATE = qQDL_RATE;
	}

	public String getUI_M_APPLIED_ON_DESC() {
		return UI_M_APPLIED_ON_DESC;
	}

	public void setUI_M_APPLIED_ON_DESC(String uI_M_APPLIED_ON_DESC) {
		UI_M_APPLIED_ON_DESC = uI_M_APPLIED_ON_DESC;
	}

	

	public int getQQDL_RATE_PER() {
		return QQDL_RATE_PER;
	}

	public void setQQDL_RATE_PER(int qQDL_RATE_PER) {
		QQDL_RATE_PER = qQDL_RATE_PER;
	}

	@Column(name="QQDL_RATE")
	private Double QQDL_RATE;
	
	@Column(name="QQDL_RATE_PER")
	private int QQDL_RATE_PER;

	public Long getQQDL_SYS_ID() {
		return QQDL_SYS_ID;
	}

	public void setQQDL_SYS_ID(Long qQDL_SYS_ID) {
		QQDL_SYS_ID = qQDL_SYS_ID;
	}

	

	public Long getQQDL_QUOT_SYS_ID() {
		return QQDL_QUOT_SYS_ID;
	}

	public void setQQDL_QUOT_SYS_ID(Long qQDL_QUOT_SYS_ID) {
		QQDL_QUOT_SYS_ID = qQDL_QUOT_SYS_ID;
	}

	public String getQQDL_DISC_LOAD_CODE() {
		return QQDL_DISC_LOAD_CODE;
	}

	public void setQQDL_DISC_LOAD_CODE(String qQDL_DISC_LOAD_CODE) {
		QQDL_DISC_LOAD_CODE = qQDL_DISC_LOAD_CODE;
	}

	public String getQQDL_DISC_LOAD_TYPE() {
		return QQDL_DISC_LOAD_TYPE;
	}

	public void setQQDL_DISC_LOAD_TYPE(String qQDL_DISC_LOAD_TYPE) {
		QQDL_DISC_LOAD_TYPE = qQDL_DISC_LOAD_TYPE;
	}

	public Double getQQDL_FC_DISC_LOAD_AMT() {
		return QQDL_FC_DISC_LOAD_AMT;
	}

	public void setQQDL_FC_DISC_LOAD_AMT(Double qQDL_FC_DISC_LOAD_AMT) {
		QQDL_FC_DISC_LOAD_AMT = qQDL_FC_DISC_LOAD_AMT;
	}

	public Double getQQDL_LC_DISC_LOAD_AMT() {
		return QQDL_LC_DISC_LOAD_AMT;
	}

	public void setQQDL_LC_DISC_LOAD_AMT(Double qQDL_LC_DISC_LOAD_AMT) {
		QQDL_LC_DISC_LOAD_AMT = qQDL_LC_DISC_LOAD_AMT;
	}

	
	private String UI_QQDL_RATE;
	private String UI_QQDL_RATE_PER;
	private String UI_QQDL_FC_DISC_LOAD_AMT;

	public String getUI_QQDL_RATE() {
		return UI_QQDL_RATE;
	}

	public void setUI_QQDL_RATE(String uI_QQDL_RATE) {
		UI_QQDL_RATE = uI_QQDL_RATE;
	}

	public String getUI_QQDL_RATE_PER() {
		return UI_QQDL_RATE_PER;
	}

	public void setUI_QQDL_RATE_PER(String uI_QQDL_RATE_PER) {
		UI_QQDL_RATE_PER = uI_QQDL_RATE_PER;
	}

	public String getUI_QQDL_FC_DISC_LOAD_AMT() {
		return UI_QQDL_FC_DISC_LOAD_AMT;
	}

	public void setUI_QQDL_FC_DISC_LOAD_AMT(String uI_QQDL_FC_DISC_LOAD_AMT) {
		UI_QQDL_FC_DISC_LOAD_AMT = uI_QQDL_FC_DISC_LOAD_AMT;
	}
	

}

package com.iii.pel.forms.PILP010;

import java.util.Date;

import com.iii.apps.persistence.Table;

@Table(name="")
public class FINAL {

	private Date UI_M_TXN_FM_DT;

	private Date UI_M_TXN_TO_DT;

	private String UI_M_DRCR_FM_TXN_CODE;

	private String UI_M_DRCR_TO_TXN_CODE;

	
	//for Interger error Interger data type changed into Long
	private Long UI_M_DRCR_FM_DOC_NO;

	private Long UI_M_DRCR_TO_DOC_NO;

	public Long getUI_M_DRCR_TO_DOC_NO() {
		return UI_M_DRCR_TO_DOC_NO;
	}

	public void setUI_M_DRCR_TO_DOC_NO(Long uI_M_DRCR_TO_DOC_NO) {
		UI_M_DRCR_TO_DOC_NO = uI_M_DRCR_TO_DOC_NO;
	}


	public Long getUI_M_DRCR_FM_DOC_NO() {
		return UI_M_DRCR_FM_DOC_NO;
	}

	public void setUI_M_DRCR_FM_DOC_NO(Long uI_M_DRCR_FM_DOC_NO) {
		UI_M_DRCR_FM_DOC_NO = uI_M_DRCR_FM_DOC_NO;
	}

	//end
	
	
	private String UI_M_STATUS;

	public Date getUI_M_TXN_FM_DT() {
		 return UI_M_TXN_FM_DT;
	}

	public void setUI_M_TXN_FM_DT(Date UI_M_TXN_FM_DT) {
		this.UI_M_TXN_FM_DT = UI_M_TXN_FM_DT;
	}

	public Date getUI_M_TXN_TO_DT() {
		 return UI_M_TXN_TO_DT;
	}

	public void setUI_M_TXN_TO_DT(Date UI_M_TXN_TO_DT) {
		this.UI_M_TXN_TO_DT = UI_M_TXN_TO_DT;
	}

	public String getUI_M_DRCR_FM_TXN_CODE() {
		return UI_M_DRCR_FM_TXN_CODE;
	}

	public void setUI_M_DRCR_FM_TXN_CODE(String UI_M_DRCR_FM_TXN_CODE) {
		this.UI_M_DRCR_FM_TXN_CODE = UI_M_DRCR_FM_TXN_CODE;
	}

	public String getUI_M_DRCR_TO_TXN_CODE() {
		return UI_M_DRCR_TO_TXN_CODE;
	}

	public void setUI_M_DRCR_TO_TXN_CODE(String UI_M_DRCR_TO_TXN_CODE) {
		this.UI_M_DRCR_TO_TXN_CODE = UI_M_DRCR_TO_TXN_CODE;
	}



	
		public String getUI_M_STATUS() {
		return UI_M_STATUS;
	}

	public void setUI_M_STATUS(String UI_M_STATUS) {
		this.UI_M_STATUS = UI_M_STATUS;
	}
}

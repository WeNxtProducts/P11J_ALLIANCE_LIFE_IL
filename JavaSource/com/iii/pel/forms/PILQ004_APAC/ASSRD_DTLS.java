package com.iii.pel.forms.PILQ004_APAC;

import com.iii.apps.persistence.Table;

@Table(name="")
public class ASSRD_DTLS {

	private String POAD_ASSR_CODE;

	private String POAD_ASSURED_NAME;

	private String POAD_ASSRD_REF_ID1;

	private String POAD_ASSRD_REF_ID2;



	public String getPOAD_ASSR_CODE() {
		return POAD_ASSR_CODE;
	}

	public void setPOAD_ASSR_CODE(String POAD_ASSR_CODE) {
		this.POAD_ASSR_CODE = POAD_ASSR_CODE;
	}

	public String getPOAD_ASSURED_NAME() {
		return POAD_ASSURED_NAME;
	}

	public void setPOAD_ASSURED_NAME(String POAD_ASSURED_NAME) {
		this.POAD_ASSURED_NAME = POAD_ASSURED_NAME;
	}

	public String getPOAD_ASSRD_REF_ID1() {
		return POAD_ASSRD_REF_ID1;
	}

	public void setPOAD_ASSRD_REF_ID1(String POAD_ASSRD_REF_ID1) {
		this.POAD_ASSRD_REF_ID1 = POAD_ASSRD_REF_ID1;
	}

	public String getPOAD_ASSRD_REF_ID2() {
		return POAD_ASSRD_REF_ID2;
	}

	public void setPOAD_ASSRD_REF_ID2(String POAD_ASSRD_REF_ID2) {
		this.POAD_ASSRD_REF_ID2 = POAD_ASSRD_REF_ID2;
	}
}

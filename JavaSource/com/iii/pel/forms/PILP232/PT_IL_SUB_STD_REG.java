package com.iii.pel.forms.PILP232;


import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_SUB_STD_REG")
public class PT_IL_SUB_STD_REG extends BaseValueBean implements OracleArrayGenerator{

	@Column(name="PSSR_SURNAME")
	private String PSSR_SURNAME;

	@Column(name="PSSR_FIRST_NAME")
	private String PSSR_FIRST_NAME;

	@Column(name="PSSR_NATIONAL_ID")
	private String PSSR_NATIONAL_ID;

	@Column(name="PSSR_DOB")
	private  String PSSR_DOB;

	@Column(name="PSSR_OFCO")
	private String PSSR_OFCO;

	@Column(name="PSSR_DEC_DATE")
	private String PSSR_DEC_DATE;

	@Column(name="PSSR_REFNO")
	private String PSSR_REFNO;

	@Column(name="PSSR_MEM_DTLS")
	private String PSSR_MEM_DTLS;

	@Column(name="PSSR_CR_DT")
	private String PSSR_CR_DT;

	public String getPSSR_DOB() {
		return PSSR_DOB;
	}

	public void setPSSR_DOB(String pSSR_DOB) {
		PSSR_DOB = pSSR_DOB;
	}

	public String getPSSR_DEC_DATE() {
		return PSSR_DEC_DATE;
	}

	public void setPSSR_DEC_DATE(String pSSR_DEC_DATE) {
		PSSR_DEC_DATE = pSSR_DEC_DATE;
	}

	@Column(name="PSSR_CR_UID")
	private String PSSR_CR_UID;

	public String getPSSR_SURNAME() {
		return PSSR_SURNAME;
	}

	public void setPSSR_SURNAME(String pSSR_SURNAME) {
		PSSR_SURNAME = pSSR_SURNAME;
	}

	public String getPSSR_FIRST_NAME() {
		return PSSR_FIRST_NAME;
	}

	public void setPSSR_FIRST_NAME(String pSSR_FIRST_NAME) {
		PSSR_FIRST_NAME = pSSR_FIRST_NAME;
	}

	public String getPSSR_NATIONAL_ID() {
		return PSSR_NATIONAL_ID;
	}

	public void setPSSR_NATIONAL_ID(String pSSR_NATIONAL_ID) {
		PSSR_NATIONAL_ID = pSSR_NATIONAL_ID;
	}


	public String getPSSR_OFCO() {
		return PSSR_OFCO;
	}

	public void setPSSR_OFCO(String pSSR_OFCO) {
		PSSR_OFCO = pSSR_OFCO;
	}


	
	public String getPSSR_REFNO() {
		return PSSR_REFNO;
	}

	public void setPSSR_REFNO(String pSSR_REFNO) {
		PSSR_REFNO = pSSR_REFNO;
	}

	public String getPSSR_CR_DT() {
		return PSSR_CR_DT;
	}

	public void setPSSR_CR_DT(String pSSR_CR_DT) {
		PSSR_CR_DT = pSSR_CR_DT;
	}

	public String getPSSR_CR_UID() {
		return PSSR_CR_UID;
	}

	public void setPSSR_CR_UID(String pSSR_CR_UID) {
		PSSR_CR_UID = pSSR_CR_UID;
	}

	public String getPSSR_MEM_DTLS() {
		return PSSR_MEM_DTLS;
	}

	public void setPSSR_MEM_DTLS(String pSSR_MEM_DTLS) {
		PSSR_MEM_DTLS = pSSR_MEM_DTLS;
	}

	@Override
	public Object[] getOracleArray() {
		return new Object[]{
				PSSR_SURNAME,
				PSSR_FIRST_NAME,
				PSSR_NATIONAL_ID,
				PSSR_DOB,
				PSSR_OFCO,
				PSSR_DEC_DATE,
				PSSR_REFNO,
				PSSR_MEM_DTLS,
				PSSR_CR_DT,
				PSSR_CR_UID
		};
	}

	
	
	
	
}

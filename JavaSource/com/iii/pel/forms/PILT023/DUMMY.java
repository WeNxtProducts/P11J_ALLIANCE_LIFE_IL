package com.iii.pel.forms.PILT023;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {
	
	@Column(name="")
	private String MFD_CLINIC_CODE;
	
	@Column(name="")
	private String WM_CLINIC_CODE_DESC;

	public String getMFD_CLINIC_CODE() {
		return MFD_CLINIC_CODE;
	}

	public void setMFD_CLINIC_CODE(String mFD_CLINIC_CODE) {
		MFD_CLINIC_CODE = mFD_CLINIC_CODE;
	}

	public String getWM_CLINIC_CODE_DESC() {
		return WM_CLINIC_CODE_DESC;
	}

	public void setWM_CLINIC_CODE_DESC(String wM_CLINIC_CODE_DESC) {
		WM_CLINIC_CODE_DESC = wM_CLINIC_CODE_DESC;
	}
	
	

}

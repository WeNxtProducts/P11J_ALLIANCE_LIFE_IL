package com.iii.premia.common.commonimpl.sso.ssomanager;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_APPLICATION_DTLS")
public class PM_APPLICATION_DTLS extends BaseValueBean {
	@Column(name = "PAD_APPL_CODE")
	private String PAD_APPL_CODE;
	@Column(name = "PAD_APPL_DESC")
	private String PAD_APPL_DESC;
	@Column(name = "PAD_APPL_URL")
	private String PAD_APPL_URL;
	
	public String getPAD_APPL_CODE() {
		return PAD_APPL_CODE;
	}
	public void setPAD_APPL_CODE(String pad_appl_code) {
		PAD_APPL_CODE = pad_appl_code;
	}
	public String getPAD_APPL_DESC() {
		return PAD_APPL_DESC;
	}
	public void setPAD_APPL_DESC(String pad_appl_desc) {
		PAD_APPL_DESC = pad_appl_desc;
	}
	public String getPAD_APPL_URL() {
		return PAD_APPL_URL;
	}
	public void setPAD_APPL_URL(String pad_appl_url) {
		PAD_APPL_URL = pad_appl_url;
	}
}

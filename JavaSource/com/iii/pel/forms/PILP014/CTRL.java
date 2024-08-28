package com.iii.pel.forms.PILP014;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_BATCH_STATUS")
public class CTRL extends BaseValueBean {

	@Column(name="BE_POL_NO")
	private String BE_POL_NO;

	@Column(name="BE_ERR_CODE")
	private String BE_ERR_CODE;
	
	@Column(name="BE_ERR_DESC")
	private String BE_ERR_DESC;

	public String getBE_POL_NO() {
		return BE_POL_NO;
	}

	public void setBE_POL_NO(String be_pol_no) {
		BE_POL_NO = be_pol_no;
	}

	public String getBE_ERR_CODE() {
		return BE_ERR_CODE;
	}

	public void setBE_ERR_CODE(String be_err_code) {
		BE_ERR_CODE = be_err_code;
	}

	public String getBE_ERR_DESC() {
		return BE_ERR_DESC;
	}

	public void setBE_ERR_DESC(String be_err_desc) {
		BE_ERR_DESC = be_err_desc;
	}
	
	
}

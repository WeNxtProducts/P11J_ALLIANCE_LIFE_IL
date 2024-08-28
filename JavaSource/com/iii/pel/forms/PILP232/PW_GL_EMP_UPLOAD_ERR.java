package com.iii.pel.forms.PILP232;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PW_GL_EMP_UPLOAD_ERR")
public class PW_GL_EMP_UPLOAD_ERR extends BaseValueBean {

	@Column(name="PEMP_ID")
	private String PEMP_ID;

	@Column(name="PEMP_REF_NO")
	private String PEMP_REF_NO;

	@Column(name="PEMP_ERR_NO")
	private Long PEMP_ERR_NO;

	@Column(name="PEMP_ERR_MSG")
	private String PEMP_ERR_MSG;

	@Column(name="PEMP_CR_DT")
	private Date PEMP_CR_DT;

	@Column(name="PEMP_CR_UID")
	private String PEMP_CR_UID;
	
	private String M_WHERE;

	public String getM_WHERE() {
		return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
		M_WHERE = m_where;
	}

	public Date getPEMP_CR_DT() {
		return PEMP_CR_DT;
	}

	public void setPEMP_CR_DT(Date pemp_cr_dt) {
		PEMP_CR_DT = pemp_cr_dt;
	}

	public String getPEMP_CR_UID() {
		return PEMP_CR_UID;
	}

	public void setPEMP_CR_UID(String pemp_cr_uid) {
		PEMP_CR_UID = pemp_cr_uid;
	}

	public String getPEMP_ID() {
		return PEMP_ID;
	}

	public void setPEMP_ID(String PEMP_ID) {
		this.PEMP_ID = PEMP_ID;
	}

	public String getPEMP_REF_NO() {
		return PEMP_REF_NO;
	}

	public void setPEMP_REF_NO(String PEMP_REF_NO) {
		this.PEMP_REF_NO = PEMP_REF_NO;
	}

	public Long getPEMP_ERR_NO() {
		return PEMP_ERR_NO;
	}

	public void setPEMP_ERR_NO(Long PEMP_ERR_NO) {
		this.PEMP_ERR_NO = PEMP_ERR_NO;
	}

	public String getPEMP_ERR_MSG() {
		return PEMP_ERR_MSG;
	}

	public void setPEMP_ERR_MSG(String PEMP_ERR_MSG) {
		this.PEMP_ERR_MSG = PEMP_ERR_MSG;
	}
}

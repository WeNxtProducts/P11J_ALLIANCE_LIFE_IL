package com.iii.pel.forms.PILP080;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_MEDEX_FEE_DTL")
public class PT_IL_MEDEX_FEE_DTL extends BaseValueBean {

	@Column(name="MFD_SYS_ID")
	private Long MFD_SYS_ID;

	@Column(name="MFD_POL_SYS_ID")
	private Long MFD_POL_SYS_ID;

	@Column(name="MFD_POAD_SYS_ID")
	private Long MFD_POAD_SYS_ID;

	@Column(name="MFD_CLINIC_CODE")
	private String MFD_CLINIC_CODE;

	@Column(name="MFD_CUST_CODE")
	private String MFD_CUST_CODE;

	@Column(name="MFD_POL_NO")
	private String MFD_POL_NO;

	@Column(name="MFD_PROP_NO")
	private String MFD_PROP_NO;

	@Column(name="MFD_POL_CONT_CODE")
	private String MFD_POL_CONT_CODE;

	@Column(name="MFD_EXAM_CODE")
	private String MFD_EXAM_CODE;

	@Column(name="MFD_EXAM_DT")
	private Date MFD_EXAM_DT;

	@Column(name="MFD_CURR_CODE")
	private String MFD_CURR_CODE;

	@Column(name="MFD_FC_VALUE")
	private Double MFD_FC_VALUE;

	@Column(name="MFD_LC_VALUE")
	private Double MFD_LC_VALUE;

	@Column(name="MFD_PYMT_TO")
	private String MFD_PYMT_TO;

	@Column(name="MFD_INV_REF_NO")
	private String MFD_INV_REF_NO;

	@Column(name="MFD_PAID_FLAG")
	private String MFD_PAID_FLAG;

	@Column(name="MFD_FRZ_FLAG")
	private String MFD_FRZ_FLAG;

	@Column(name="MFD_REMARKS")
	private String MFD_REMARKS;

	@Column(name="MFD_ACNT_TXN_CODE")
	private String MFD_ACNT_TXN_CODE;

	@Column(name="MFD_ACNT_DOC_NO")
	private Double MFD_ACNT_DOC_NO;

	@Column(name="MFD_ACNT_DOC_DT")
	private Date MFD_ACNT_DOC_DT;

	@Column(name="MFD_CR_DT")
	private Date MFD_CR_DT;

	@Column(name="MFD_CR_UID")
	private String MFD_CR_UID;

	@Column(name="MFD_UPD_DT")
	private Date MFD_UPD_DT;

	@Column(name="MFD_UPD_UID")
	private String MFD_UPD_UID;

	@Column(name="MFD_END_NO_IDX")
	private Double MFD_END_NO_IDX;
	
	@Column(name="MFD_FLEX_05")
	private Long MFD_FLEX_05;

	public void setMFD_EXAM_CODE(String MFD_EXAM_CODE) {
		this.MFD_EXAM_CODE = MFD_EXAM_CODE;
	}
	public String getMFD_EXAM_CODE() {
		 return MFD_EXAM_CODE;
	}
	public void setMFD_POL_SYS_ID(Long MFD_POL_SYS_ID) {
		this.MFD_POL_SYS_ID = MFD_POL_SYS_ID;
	}
	public Long getMFD_POL_SYS_ID() {
		 return MFD_POL_SYS_ID;
	}
	public void setMFD_FC_VALUE(Double MFD_FC_VALUE) {
		this.MFD_FC_VALUE = MFD_FC_VALUE;
	}
	public Double getMFD_FC_VALUE() {
		 return MFD_FC_VALUE;
	}
	public void setMFD_ACNT_DOC_NO(Double MFD_ACNT_DOC_NO) {
		this.MFD_ACNT_DOC_NO = MFD_ACNT_DOC_NO;
	}
	public Double getMFD_ACNT_DOC_NO() {
		 return MFD_ACNT_DOC_NO;
	}
	public void setMFD_EXAM_DT(Date MFD_EXAM_DT) {
		this.MFD_EXAM_DT = MFD_EXAM_DT;
	}
	public Date getMFD_EXAM_DT() {
		 return MFD_EXAM_DT;
	}
	public void setMFD_CLINIC_CODE(String MFD_CLINIC_CODE) {
		this.MFD_CLINIC_CODE = MFD_CLINIC_CODE;
	}
	public String getMFD_CLINIC_CODE() {
		 return MFD_CLINIC_CODE;
	}
	public void setMFD_PYMT_TO(String MFD_PYMT_TO) {
		this.MFD_PYMT_TO = MFD_PYMT_TO;
	}
	public String getMFD_PYMT_TO() {
		 return MFD_PYMT_TO;
	}
	public void setMFD_CR_DT(Date MFD_CR_DT) {
		this.MFD_CR_DT = MFD_CR_DT;
	}
	public Date getMFD_CR_DT() {
		 return MFD_CR_DT;
	}
	public void setMFD_UPD_DT(Date MFD_UPD_DT) {
		this.MFD_UPD_DT = MFD_UPD_DT;
	}
	public Date getMFD_UPD_DT() {
		 return MFD_UPD_DT;
	}
	public void setMFD_POL_NO(String MFD_POL_NO) {
		this.MFD_POL_NO = MFD_POL_NO;
	}
	public String getMFD_POL_NO() {
		 return MFD_POL_NO;
	}
	public void setMFD_END_NO_IDX(Double MFD_END_NO_IDX) {
		this.MFD_END_NO_IDX = MFD_END_NO_IDX;
	}
	public Double getMFD_END_NO_IDX() {
		 return MFD_END_NO_IDX;
	}
	public void setMFD_INV_REF_NO(String MFD_INV_REF_NO) {
		this.MFD_INV_REF_NO = MFD_INV_REF_NO;
	}
	public String getMFD_INV_REF_NO() {
		 return MFD_INV_REF_NO;
	}
	public void setMFD_REMARKS(String MFD_REMARKS) {
		this.MFD_REMARKS = MFD_REMARKS;
	}
	public String getMFD_REMARKS() {
		 return MFD_REMARKS;
	}
	public void setMFD_POAD_SYS_ID(Long MFD_POAD_SYS_ID) {
		this.MFD_POAD_SYS_ID = MFD_POAD_SYS_ID;
	}
	public Long getMFD_POAD_SYS_ID() {
		 return MFD_POAD_SYS_ID;
	}
	public void setMFD_ACNT_TXN_CODE(String MFD_ACNT_TXN_CODE) {
		this.MFD_ACNT_TXN_CODE = MFD_ACNT_TXN_CODE;
	}
	public String getMFD_ACNT_TXN_CODE() {
		 return MFD_ACNT_TXN_CODE;
	}
	public void setMFD_CURR_CODE(String MFD_CURR_CODE) {
		this.MFD_CURR_CODE = MFD_CURR_CODE;
	}
	public String getMFD_CURR_CODE() {
		 return MFD_CURR_CODE;
	}
	public void setMFD_ACNT_DOC_DT(Date MFD_ACNT_DOC_DT) {
		this.MFD_ACNT_DOC_DT = MFD_ACNT_DOC_DT;
	}
	public Date getMFD_ACNT_DOC_DT() {
		 return MFD_ACNT_DOC_DT;
	}
	public void setMFD_CR_UID(String MFD_CR_UID) {
		this.MFD_CR_UID = MFD_CR_UID;
	}
	public String getMFD_CR_UID() {
		 return MFD_CR_UID;
	}
	public void setMFD_LC_VALUE(Double MFD_LC_VALUE) {
		this.MFD_LC_VALUE = MFD_LC_VALUE;
	}
	public Double getMFD_LC_VALUE() {
		 return MFD_LC_VALUE;
	}
	public void setMFD_CUST_CODE(String MFD_CUST_CODE) {
		this.MFD_CUST_CODE = MFD_CUST_CODE;
	}
	public String getMFD_CUST_CODE() {
		 return MFD_CUST_CODE;
	}
	public void setMFD_UPD_UID(String MFD_UPD_UID) {
		this.MFD_UPD_UID = MFD_UPD_UID;
	}
	public String getMFD_UPD_UID() {
		 return MFD_UPD_UID;
	}
	public void setMFD_PAID_FLAG(String MFD_PAID_FLAG) {
		this.MFD_PAID_FLAG = MFD_PAID_FLAG;
	}
	public String getMFD_PAID_FLAG() {
		 return MFD_PAID_FLAG;
	}
	public void setMFD_SYS_ID(Long MFD_SYS_ID) {
		this.MFD_SYS_ID = MFD_SYS_ID;
	}
	public Long getMFD_SYS_ID() {
		 return MFD_SYS_ID;
	}
	public void setMFD_POL_CONT_CODE(String MFD_POL_CONT_CODE) {
		this.MFD_POL_CONT_CODE = MFD_POL_CONT_CODE;
	}
	public String getMFD_POL_CONT_CODE() {
		 return MFD_POL_CONT_CODE;
	}
	public void setMFD_PROP_NO(String MFD_PROP_NO) {
		this.MFD_PROP_NO = MFD_PROP_NO;
	}
	public String getMFD_PROP_NO() {
		 return MFD_PROP_NO;
	}
	public void setMFD_FRZ_FLAG(String MFD_FRZ_FLAG) {
		this.MFD_FRZ_FLAG = MFD_FRZ_FLAG;
	}
	public String getMFD_FRZ_FLAG() {
		 return MFD_FRZ_FLAG;
	}
	public Long getMFD_FLEX_05() {
		return MFD_FLEX_05;
	}
	public void setMFD_FLEX_05(Long mfd_flex_05) {
		MFD_FLEX_05 = mfd_flex_05;
	}

}
package com.iii.pel.forms.PILT023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PT_IL_MEDEX_FEE_DTL")
public class PT_IL_MEDEX_FEE_DTL extends BaseValueBean{

	@Column(name="MFD_SYS_ID")
	private long MFD_SYS_ID;
	
	@Column(name="MFD_POL_SYS_ID")
	private long MFD_POL_SYS_ID;
	
	@Column(name="MFD_CR_UID")
	private String MFD_CR_UID;
	
	@Column(name="MFD_CR_DT")
	private Date MFD_CR_DT;
	
	@Column(name="MFD_POAD_SYS_ID")
	private long MFD_POAD_SYS_ID;
	
	@Column(name="MFD_CLINIC_CODE")
	private String MFD_CLINIC_CODE;
	
	@Column(name="MFD_PROP_NO")
	private String MFD_PROP_NO;

	//@Column(name="NEW_ICNO")
	private String NEW_ICNO;

	//@Column(name="OLD_ICNO")
	private String OLD_ICNO;

	@Column(name="MFD_EXAM_CODE")
	private String MFD_EXAM_CODE;

	@Column(name="MFD_EXAM_DT")
	private Date MFD_EXAM_DT;

	@Column(name="MFD_CURR_CODE")
	private String MFD_CURR_CODE;

	@Column(name="MFD_FC_VALUE")
	private Double MFD_FC_VALUE;

	@Column(name="MFD_INV_REF_NO")
	private String MFD_INV_REF_NO;

	@Column(name="MFD_PYMT_TO")
	private String MFD_PYMT_TO;

	@Column(name="MFD_FRZ_FLAG")
	private String MFD_FRZ_FLAG;
	
	@Column(name="MFD_LC_VALUE")
	private Double MFD_LC_VALUE;

	@Column(name="MFD_POL_NO")
	private String MFD_POL_NO;

	@Column(name="MFD_POL_CONT_CODE")
	private String MFD_POL_CONT_CODE;
	
	//@Column(name="M_MFD_POL_CONT_NAME")
	private String WM_MFD_POL_CONT_NAME;

	//@Column(name="M_MFD_EXAM_CODE_DESC")
	private String WM_MFD_EXAM_CODE_DESC;

	//@Column(name="M_MFD_CURR_CODE_DESC")
	private String WM_MFD_CURR_CODE_DESC;

	@Column(name="MFD_REMARKS")
	private String MFD_REMARKS;
	
	private String WM_STATUS;
	
	private String WM_APPRV_STATUS;
	
	private String WM_APPRV_DT;
	/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
	private String WM_FREEZE_YN_ALL;
	


	public String getWM_FREEZE_YN_ALL() {
		return WM_FREEZE_YN_ALL;
	}

	public void setWM_FREEZE_YN_ALL(String wM_FREEZE_YN_ALL) {
		WM_FREEZE_YN_ALL = wM_FREEZE_YN_ALL;
	}
/* End */
	public String getMFD_PROP_NO() {
		return MFD_PROP_NO;
	}

	public void setMFD_PROP_NO(String mFD_PROP_NO) {
		MFD_PROP_NO = mFD_PROP_NO;
	}

	public String getNEW_ICNO() {
		return NEW_ICNO;
	}

	public void setNEW_ICNO(String nEW_ICNO) {
		NEW_ICNO = nEW_ICNO;
	}

	public String getOLD_ICNO() {
		return OLD_ICNO;
	}

	public void setOLD_ICNO(String oLD_ICNO) {
		OLD_ICNO = oLD_ICNO;
	}

	public String getMFD_EXAM_CODE() {
		return MFD_EXAM_CODE;
	}

	public void setMFD_EXAM_CODE(String mFD_EXAM_CODE) {
		MFD_EXAM_CODE = mFD_EXAM_CODE;
	}

	public Date getMFD_EXAM_DT() {
		return MFD_EXAM_DT;
	}

	public void setMFD_EXAM_DT(Date mFD_EXAM_DT) {
		MFD_EXAM_DT = mFD_EXAM_DT;
	}

	public String getMFD_CURR_CODE() {
		return MFD_CURR_CODE;
	}

	public void setMFD_CURR_CODE(String mFD_CURR_CODE) {
		MFD_CURR_CODE = mFD_CURR_CODE;
	}

	public Double getMFD_FC_VALUE() {
		return MFD_FC_VALUE;
	}

	public void setMFD_FC_VALUE(Double mFD_FC_VALUE) {
		MFD_FC_VALUE = mFD_FC_VALUE;
	}

	public String getMFD_INV_REF_NO() {
		return MFD_INV_REF_NO;
	}

	public void setMFD_INV_REF_NO(String mFD_INV_REF_NO) {
		MFD_INV_REF_NO = mFD_INV_REF_NO;
	}

	public String getMFD_PYMT_TO() {
		return MFD_PYMT_TO;
	}

	public void setMFD_PYMT_TO(String mFD_PYMT_TO) {
		MFD_PYMT_TO = mFD_PYMT_TO;
	}

	public String getMFD_FRZ_FLAG() {
		return MFD_FRZ_FLAG;
	}

	public void setMFD_FRZ_FLAG(String mFD_FRZ_FLAG) {
		MFD_FRZ_FLAG = mFD_FRZ_FLAG;
	}

	public Double getMFD_LC_VALUE() {
		return MFD_LC_VALUE;
	}

	public void setMFD_LC_VALUE(Double mFD_LC_VALUE) {
		MFD_LC_VALUE = mFD_LC_VALUE;
	}

	public String getMFD_POL_NO() {
		return MFD_POL_NO;
	}

	public void setMFD_POL_NO(String mFD_POL_NO) {
		MFD_POL_NO = mFD_POL_NO;
	}

	public String getMFD_POL_CONT_CODE() {
		return MFD_POL_CONT_CODE;
	}

	public void setMFD_POL_CONT_CODE(String mFD_POL_CONT_CODE) {
		MFD_POL_CONT_CODE = mFD_POL_CONT_CODE;
	}

	public String getWM_MFD_POL_CONT_NAME() {
		return WM_MFD_POL_CONT_NAME;
	}

	public void setWM_MFD_POL_CONT_NAME(String wM_MFD_POL_CONT_NAME) {
		WM_MFD_POL_CONT_NAME = wM_MFD_POL_CONT_NAME;
	}

	public String getWM_MFD_EXAM_CODE_DESC() {
		return WM_MFD_EXAM_CODE_DESC;
	}

	public void setWM_MFD_EXAM_CODE_DESC(String wM_MFD_EXAM_CODE_DESC) {
		WM_MFD_EXAM_CODE_DESC = wM_MFD_EXAM_CODE_DESC;
	}

	public String getWM_MFD_CURR_CODE_DESC() {
		return WM_MFD_CURR_CODE_DESC;
	}

	public void setWM_MFD_CURR_CODE_DESC(String wM_MFD_CURR_CODE_DESC) {
		WM_MFD_CURR_CODE_DESC = wM_MFD_CURR_CODE_DESC;
	}

	public String getMFD_REMARKS() {
		return MFD_REMARKS;
	}

	public void setMFD_REMARKS(String mFD_REMARKS) {
		MFD_REMARKS = mFD_REMARKS;
	}

	public long getMFD_SYS_ID() {
		return MFD_SYS_ID;
	}

	public void setMFD_SYS_ID(long mFD_SYS_ID) {
		MFD_SYS_ID = mFD_SYS_ID;
	}

	public long getMFD_POL_SYS_ID() {
		return MFD_POL_SYS_ID;
	}

	public void setMFD_POL_SYS_ID(long mFD_POL_SYS_ID) {
		MFD_POL_SYS_ID = mFD_POL_SYS_ID;
	}

	public String getMFD_CR_UID() {
		return MFD_CR_UID;
	}

	public void setMFD_CR_UID(String mFD_CR_UID) {
		MFD_CR_UID = mFD_CR_UID;
	}

	public Date getMFD_CR_DT() {
		return MFD_CR_DT;
	}

	public void setMFD_CR_DT(Date mFD_CR_DT) {
		MFD_CR_DT = mFD_CR_DT;
	}

	public long getMFD_POAD_SYS_ID() {
		return MFD_POAD_SYS_ID;
	}

	public void setMFD_POAD_SYS_ID(long mFD_POAD_SYS_ID) {
		MFD_POAD_SYS_ID = mFD_POAD_SYS_ID;
	}

	public String getWM_STATUS() {
		return WM_STATUS;
	}

	public void setWM_STATUS(String wM_STATUS) {
		WM_STATUS = wM_STATUS;
	}

	public String getMFD_CLINIC_CODE() {
		return MFD_CLINIC_CODE;
	}

	public void setMFD_CLINIC_CODE(String mFD_CLINIC_CODE) {
		MFD_CLINIC_CODE = mFD_CLINIC_CODE;
	}

	public String getWM_APPRV_STATUS() {
		return WM_APPRV_STATUS;
	}

	public void setWM_APPRV_STATUS(String wM_APPRV_STATUS) {
		WM_APPRV_STATUS = wM_APPRV_STATUS;
	}

	public String getWM_APPRV_DT() {
		return WM_APPRV_DT;
	}

	public void setWM_APPRV_DT(String wM_APPRV_DT) {
		WM_APPRV_DT = wM_APPRV_DT;
	}
	
	@Column(name="MFD_CUST_CODE")
	private String MFD_CUST_CODE;


	public String getMFD_CUST_CODE() {
		return MFD_CUST_CODE;
	}

	public void setMFD_CUST_CODE(String mFD_CUST_CODE) {
		MFD_CUST_CODE = mFD_CUST_CODE;
	}
	
	/*Added by saritha on 16-11-2017 for ssp call id ZBILQC-1736304*/
	
	@Column(name="MFD_UPD_DT")
	private Date MFD_UPD_DT;

	public Date getMFD_UPD_DT() {
		return MFD_UPD_DT;
	}

	public void setMFD_UPD_DT(Date mFD_UPD_DT) {
		MFD_UPD_DT = mFD_UPD_DT;
	}

	@Column(name="MFD_PAID_FLAG")
	private String MFD_PAID_FLAG;

	public String getMFD_PAID_FLAG() {
		return MFD_PAID_FLAG;
	}

	public void setMFD_PAID_FLAG(String mFD_PAID_FLAG) {
		MFD_PAID_FLAG = mFD_PAID_FLAG;
	}

	/*End*/
	
	/*Added by Ameen on 04-12-2017 for ZBLIFE-1458892*/
	
	@Column(name="MFD_FLEX_01")
	private String MFD_FLEX_01;
	
	private String UI_M_MFD_BANK_DESC;
	
	@Column(name="MFD_FLEX_02")
	private String MFD_FLEX_02;
	
	@Column(name="MFD_FLEX_03")
	private String MFD_FLEX_03;
	
	@Column(name="MFD_FLEX_04")
	private String MFD_FLEX_04;
	
	@Column(name="MFD_FLEX_05")
	private String MFD_FLEX_05;
	
	@Column(name="MFD_FLEX_06")
	private String MFD_FLEX_06;
	
	private String UI_M_DIVN_CODE;

	public String getMFD_FLEX_01() {
		return MFD_FLEX_01;
	}

	public void setMFD_FLEX_01(String mFD_FLEX_01) {
		MFD_FLEX_01 = mFD_FLEX_01;
	}
	
	public String getUI_M_MFD_BANK_DESC() {
		return UI_M_MFD_BANK_DESC;
	}

	public void setUI_M_MFD_BANK_DESC(String uI_M_MFD_BANK_DESC) {
		UI_M_MFD_BANK_DESC = uI_M_MFD_BANK_DESC;
	}

	public String getMFD_FLEX_02() {
		return MFD_FLEX_02;
	}

	public void setMFD_FLEX_02(String mFD_FLEX_02) {
		MFD_FLEX_02 = mFD_FLEX_02;
	}

	public String getMFD_FLEX_03() {
		return MFD_FLEX_03;
	}

	public void setMFD_FLEX_03(String mFD_FLEX_03) {
		MFD_FLEX_03 = mFD_FLEX_03;
	}

	public String getMFD_FLEX_04() {
		return MFD_FLEX_04;
	}

	public void setMFD_FLEX_04(String mFD_FLEX_04) {
		MFD_FLEX_04 = mFD_FLEX_04;
	}

	public String getMFD_FLEX_05() {
		return MFD_FLEX_05;
	}

	public void setMFD_FLEX_05(String mFD_FLEX_05) {
		MFD_FLEX_05 = mFD_FLEX_05;
	}

	public String getMFD_FLEX_06() {
		return MFD_FLEX_06;
	}

	public void setMFD_FLEX_06(String mFD_FLEX_06) {
		MFD_FLEX_06 = mFD_FLEX_06;
	}

	public String getUI_M_DIVN_CODE() {
		return UI_M_DIVN_CODE;
	}

	public void setUI_M_DIVN_CODE(String uI_M_DIVN_CODE) {
		UI_M_DIVN_CODE = uI_M_DIVN_CODE;
	}
	
	/*End*/
	
	/*Added by saritha on 26-04-2018 for KIC Medical Clinic Payment Issues*/
	
	@Column(name="MFD_FROM_DT")
	private Date MFD_FROM_DT ;
	
	@Column(name="MFD_TO_DT")
	private Date MFD_TO_DT ;
	
	public Date getMFD_FROM_DT() {
		return MFD_FROM_DT;
	}

	public void setMFD_FROM_DT(Date mFD_FROM_DT) {
		MFD_FROM_DT = mFD_FROM_DT;
	}

	public Date getMFD_TO_DT() {
		return MFD_TO_DT;
	}

	public void setMFD_TO_DT(Date mFD_TO_DT) {
		MFD_TO_DT = mFD_TO_DT;
	}

	/*End*/
	
	
	/*Added by saritha on 09-05-2018 */
	private Double UI_M_TOTAL_PAID_AMT;

	public Double getUI_M_TOTAL_PAID_AMT() {
		return UI_M_TOTAL_PAID_AMT;
	}

	public void setUI_M_TOTAL_PAID_AMT(Double uI_M_TOTAL_PAID_AMT) {
		UI_M_TOTAL_PAID_AMT = uI_M_TOTAL_PAID_AMT;
	}
	
	private boolean DEF_YN_ALL;
	
	public boolean isDEF_YN_ALL() {
		return DEF_YN_ALL;
	}

	public void setDEF_YN_ALL(boolean dEF_YN_ALL) {
		DEF_YN_ALL = dEF_YN_ALL;
	}
	
}

package com.iii.pel.forms.PILP070;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PW_SAL_POL_DTLS")
public class PW_SAL_POL_DTLS extends BaseValueBean {
	

	@Column(name="PSP_POL_NO")
	private String  PSP_POL_NO;
	
	
	@Column(name="PSP_CID_NO")
	private String  PSP_CID_NO;
	
	
	@Column(name="PSP_SCHD_PYMT_DT")
	private Date  PSP_SCHD_PYMT_DT;
	
	
	@Column(name="PSP_PC_FC_PREM")
	private Double  PSP_PC_FC_PREM;
	
	@Column(name="PSP_CHK_FLAG")
	private String PSP_CHK_FLAG;
	
	
	@Column(name="PSP_PC_SYS_ID")
	private Long PSP_PC_SYS_ID;
	
	@Column(name="PSP_POL_SYS_ID")
	private Long PSP_POL_SYS_ID;
	
	private Double UI_M_DUE_PREM;
	
	
	private String UI_PS_PROC_MON;
	
	private String UI_PS_PROC_YEAR;
	
	
	private String UI_PS_EMPLOYER_CODE;
	
	
	private String UI_PS_REF_NO;
	
	private String UI_PSP_SCHD_PYMT_DT;
	
	
	private Date UI_PS_PROC_DT;
	
	
	private String UI_MICR_CODE;


	public Date getUI_PS_PROC_DT() {
		return UI_PS_PROC_DT;
	}


	public void setUI_PS_PROC_DT(Date ui_ps_proc_dt) {
		UI_PS_PROC_DT = ui_ps_proc_dt;
	}


	public String getUI_PSP_SCHD_PYMT_DT() {
		return UI_PSP_SCHD_PYMT_DT;
	}


	public void setUI_PSP_SCHD_PYMT_DT(String ui_psp_schd_pymt_dt) {
		UI_PSP_SCHD_PYMT_DT = ui_psp_schd_pymt_dt;
	}


	public String getPSP_POL_NO() {
		return PSP_POL_NO;
	}


	public void setPSP_POL_NO(String psp_pol_no) {
		PSP_POL_NO = psp_pol_no;
	}


	public String getPSP_CID_NO() {
		return PSP_CID_NO;
	}


	public void setPSP_CID_NO(String psp_cid_no) {
		PSP_CID_NO = psp_cid_no;
	}


	public Date getPSP_SCHD_PYMT_DT() {
		return PSP_SCHD_PYMT_DT;
	}


	public void setPSP_SCHD_PYMT_DT(Date psp_schd_pymt_dt) {
		setUI_PSP_SCHD_PYMT_DT(CommonUtils.dateToPELStringFormatter(psp_schd_pymt_dt));
		PSP_SCHD_PYMT_DT = psp_schd_pymt_dt;
	}


	public Double getPSP_PC_FC_PREM() {
		return PSP_PC_FC_PREM;
	}


	public void setPSP_PC_FC_PREM(Double psp_pc_fc_prem) {
		PSP_PC_FC_PREM = psp_pc_fc_prem;
	}


	


	public Double getUI_M_DUE_PREM() {
		return UI_M_DUE_PREM;
	}


	public void setUI_M_DUE_PREM(Double ui_m_due_prem) {
		UI_M_DUE_PREM = ui_m_due_prem;
	}


	public String getUI_PS_PROC_MON() {
		return UI_PS_PROC_MON;
	}


	public void setUI_PS_PROC_MON(String ui_ps_proc_mon) {
		UI_PS_PROC_MON = ui_ps_proc_mon;
	}


	public String getUI_PS_PROC_YEAR() {
		return UI_PS_PROC_YEAR;
	}


	public void setUI_PS_PROC_YEAR(String ui_ps_proc_year) {
		UI_PS_PROC_YEAR = ui_ps_proc_year;
	}


	public String getUI_PS_EMPLOYER_CODE() {
		return UI_PS_EMPLOYER_CODE;
	}


	public void setUI_PS_EMPLOYER_CODE(String ui_ps_employer_code) {
		UI_PS_EMPLOYER_CODE = ui_ps_employer_code;
	}


	public String getUI_PS_REF_NO() {
		return UI_PS_REF_NO;
	}


	public void setUI_PS_REF_NO(String ui_ps_ref_no) {
		UI_PS_REF_NO = ui_ps_ref_no;
	}


	public String getPSP_CHK_FLAG() {
		return PSP_CHK_FLAG;
	}


	public void setPSP_CHK_FLAG(String psp_chk_flag) {
		PSP_CHK_FLAG = psp_chk_flag;
	}


	public Long getPSP_PC_SYS_ID() {
		return PSP_PC_SYS_ID;
	}


	public void setPSP_PC_SYS_ID(Long psp_pc_sys_id) {
		PSP_PC_SYS_ID = psp_pc_sys_id;
	}


	public Long getPSP_POL_SYS_ID() {
		return PSP_POL_SYS_ID;
	}


	public void setPSP_POL_SYS_ID(Long psp_pol_sys_id) {
		PSP_POL_SYS_ID = psp_pol_sys_id;
	}


	public String getUI_MICR_CODE() {
		return UI_MICR_CODE;
	}


	public void setUI_MICR_CODE(String ui_micr_code) {
		UI_MICR_CODE = ui_micr_code;
	}

/*added by sankaranarayanan on 05/04/2017*/
	
	private String UI_MAP_CODE;
	private String UI_MAP_CODE_DESC;
	private String UI_PAY_MODE;


	public String getUI_MAP_CODE() {
		return UI_MAP_CODE;
	}


	public void setUI_MAP_CODE(String uI_MAP_CODE) {
		UI_MAP_CODE = uI_MAP_CODE;
	}


	public String getUI_MAP_CODE_DESC() {
		return UI_MAP_CODE_DESC;
	}


	public void setUI_MAP_CODE_DESC(String uI_MAP_CODE_DESC) {
		UI_MAP_CODE_DESC = uI_MAP_CODE_DESC;
	}


	public String getUI_PAY_MODE() {
		return UI_PAY_MODE;
	}


	public void setUI_PAY_MODE(String uI_PAY_MODE) {
		UI_PAY_MODE = uI_PAY_MODE;
	}
/*end*/
	
	/*added by raja on 10-04-2017*/
	private boolean DEF_YN_ALL;


	public boolean isDEF_YN_ALL() {
		return DEF_YN_ALL;
	}


	public void setDEF_YN_ALL(boolean dEF_YN_ALL) {
		DEF_YN_ALL = dEF_YN_ALL;
	}
	
	
	@Column(name="PSP_POL_DUE_NO")
	private Integer PSP_POL_DUE_NO;


	public Integer getPSP_POL_DUE_NO() {
		return PSP_POL_DUE_NO;
	}


	public void setPSP_POL_DUE_NO(Integer pSP_POL_DUE_NO) {
		PSP_POL_DUE_NO = pSP_POL_DUE_NO;
	}
	
	@Column(name="PSP_PC_LC_PREM")
	private Double PSP_PC_LC_PREM ;


	public Double getPSP_PC_LC_PREM() {
		return PSP_PC_LC_PREM;
	}


	public void setPSP_PC_LC_PREM(Double pSP_PC_LC_PREM) {
		PSP_PC_LC_PREM = pSP_PC_LC_PREM;
	}
	
	
}

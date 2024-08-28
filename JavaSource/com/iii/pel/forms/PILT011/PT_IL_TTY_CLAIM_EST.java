package com.iii.pel.forms.PILT011;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_TTY_CLAIM_EST")
public class PT_IL_TTY_CLAIM_EST extends BaseValueBean {
	
	private boolean CHECK_BOX;
	
	private String UI_M_COVER_DESC_3;

	@Column(name="TCE_CCD_COVER_CODE")
	private String TCE_CCD_COVER_CODE;

	@Column(name="TCE_TREATY_CODE")
	private String TCE_TREATY_CODE;

	/* added by raja on 18-08-2017 for ZBILQC-1722999 */
	@Column(name="TCE_UW_YEAR")
	private int TCE_UW_YEAR;
	/*END*/
	
	@Column(name="TCE_CLAIM_LOSS_DT")
	private Date TCE_CLAIM_LOSS_DT;

	@Column(name="TCE_RETN_LC_CLM_EST")
	private Double TCE_RETN_LC_CLM_EST;

	@Column(name="TCE_QS_LC_CLM_EST")
	private Double TCE_QS_LC_CLM_EST;

	@Column(name="TCE_1S_LC_CLM_EST")
	private Double TCE_1S_LC_CLM_EST;

	@Column(name="TCE_2S_LC_CLM_EST")
	private Double TCE_2S_LC_CLM_EST;

	@Column(name="TCE_3S_LC_CLM_EST")
	private Double TCE_3S_LC_CLM_EST;

	@Column(name="TCE_CLAIM_SYS_ID")
	private Double TCE_CLAIM_SYS_ID;
	
	@Column(name="TCE_CCD_SYS_ID")
	private Double TCE_CCD_SYS_ID;
	/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
	private String UI_M_POL_NO_2;
	
	private String UI_M_CLM_NO_2;
	
	private String UI_M_POL_NO_1;
	
	private String UI_M_CLM_NO_1;
	
	public String getUI_M_POL_NO_2() {
		return UI_M_POL_NO_2;
	}

	public void setUI_M_POL_NO_2(String uI_M_POL_NO_2) {
		UI_M_POL_NO_2 = uI_M_POL_NO_2;
	}

	public String getUI_M_CLM_NO_2() {
		return UI_M_CLM_NO_2;
	}

	public void setUI_M_CLM_NO_2(String uI_M_CLM_NO_2) {
		UI_M_CLM_NO_2 = uI_M_CLM_NO_2;
	}

	public String getUI_M_POL_NO_1() {
		return UI_M_POL_NO_1;
	}

	public void setUI_M_POL_NO_1(String uI_M_POL_NO_1) {
		UI_M_POL_NO_1 = uI_M_POL_NO_1;
	}

	public String getUI_M_CLM_NO_1() {
		return UI_M_CLM_NO_1;
	}

	public void setUI_M_CLM_NO_1(String uI_M_CLM_NO_1) {
		UI_M_CLM_NO_1 = uI_M_CLM_NO_1;
	}

	public Double getTCE_CLAIM_SYS_ID() {
		return TCE_CLAIM_SYS_ID;
	}

	public void setTCE_CLAIM_SYS_ID(Double tce_claim_sys_id) {
		TCE_CLAIM_SYS_ID = tce_claim_sys_id;
	}

	public Double getTCE_CCD_SYS_ID() {
		return TCE_CCD_SYS_ID;
	}

	public void setTCE_CCD_SYS_ID(Double tce_ccd_sys_id) {
		TCE_CCD_SYS_ID = tce_ccd_sys_id;
	}

	public String getTCE_CCD_COVER_CODE() {
		return TCE_CCD_COVER_CODE;
	}

	public void setTCE_CCD_COVER_CODE(String TCE_CCD_COVER_CODE) {
		this.TCE_CCD_COVER_CODE = TCE_CCD_COVER_CODE;
	}

	public String getTCE_TREATY_CODE() {
		return TCE_TREATY_CODE;
	}

	public void setTCE_TREATY_CODE(String TCE_TREATY_CODE) {
		this.TCE_TREATY_CODE = TCE_TREATY_CODE;
	}

	

	public int getTCE_UW_YEAR() {
		return TCE_UW_YEAR;
	}

	public void setTCE_UW_YEAR(int tCE_UW_YEAR) {
		TCE_UW_YEAR = tCE_UW_YEAR;
	}

	public Date getTCE_CLAIM_LOSS_DT() {
		 return TCE_CLAIM_LOSS_DT;
	}

	/* added by raja on 18-08-2017 for ZBILQC-1722999 */
	public void setTCE_CLAIM_LOSS_DT(Date TCE_CLAIM_LOSS_DT) {
		setTCE_CLAIM_LOSS_DT_FT(new SimpleDateFormat("dd-MM-yyyy").format(TCE_CLAIM_LOSS_DT).toString());
		this.TCE_CLAIM_LOSS_DT = TCE_CLAIM_LOSS_DT;
		/*END*/
	}

	public Double getTCE_RETN_LC_CLM_EST() {
		return TCE_RETN_LC_CLM_EST;
	}

	public void setTCE_RETN_LC_CLM_EST(Double TCE_RETN_LC_CLM_EST) {
		this.TCE_RETN_LC_CLM_EST = TCE_RETN_LC_CLM_EST;
	}

	public Double getTCE_QS_LC_CLM_EST() {
		return TCE_QS_LC_CLM_EST;
	}

	public void setTCE_QS_LC_CLM_EST(Double TCE_QS_LC_CLM_EST) {
		this.TCE_QS_LC_CLM_EST = TCE_QS_LC_CLM_EST;
	}

	public Double getTCE_1S_LC_CLM_EST() {
		return TCE_1S_LC_CLM_EST;
	}

	public void setTCE_1S_LC_CLM_EST(Double TCE_1S_LC_CLM_EST) {
		this.TCE_1S_LC_CLM_EST = TCE_1S_LC_CLM_EST;
	}

	public Double getTCE_2S_LC_CLM_EST() {
		return TCE_2S_LC_CLM_EST;
	}

	public void setTCE_2S_LC_CLM_EST(Double TCE_2S_LC_CLM_EST) {
		this.TCE_2S_LC_CLM_EST = TCE_2S_LC_CLM_EST;
	}

	public Double getTCE_3S_LC_CLM_EST() {
		return TCE_3S_LC_CLM_EST;
	}

	public void setTCE_3S_LC_CLM_EST(Double TCE_3S_LC_CLM_EST) {
		this.TCE_3S_LC_CLM_EST = TCE_3S_LC_CLM_EST;
	}

	public String getUI_M_COVER_DESC_3() {
		return UI_M_COVER_DESC_3;
	}

	public void setUI_M_COVER_DESC_3(String ui_m_cover_desc_3) {
		UI_M_COVER_DESC_3 = ui_m_cover_desc_3;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}
	
	/* added by raja on 18-08-2017 for ZBILQC-1722999 */
	private String TCE_CLAIM_LOSS_DT_FT;

	public String getTCE_CLAIM_LOSS_DT_FT() {
		return TCE_CLAIM_LOSS_DT_FT;
	}

	public void setTCE_CLAIM_LOSS_DT_FT(String tCE_CLAIM_LOSS_DT_FT) {
		TCE_CLAIM_LOSS_DT_FT = tCE_CLAIM_LOSS_DT_FT;
	}

	private String FCE_CLAIM_CURR_CODE;

	public String getFCE_CLAIM_CURR_CODE() {
		return FCE_CLAIM_CURR_CODE;
	}

	public void setFCE_CLAIM_CURR_CODE(String fCE_CLAIM_CURR_CODE) {
		FCE_CLAIM_CURR_CODE = fCE_CLAIM_CURR_CODE;
	}
	
	private String UI_M_CURR_DESC_1;

	public String getUI_M_CURR_DESC_1() {
		return UI_M_CURR_DESC_1;
	}

	public void setUI_M_CURR_DESC_1(String uI_M_CURR_DESC_1) {
		UI_M_CURR_DESC_1 = uI_M_CURR_DESC_1;
	}
	
	/*END*/
	
}

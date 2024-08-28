package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

/*Commented  by Janani on 08.03.2017 
 * 
 * 
 * import org.apache.poi.hssf.record.formula.functions.Int;*/

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_COVER_DTLS")
public class PT_IL_CLAIM_COVER_DTLS extends BaseValueBean {
	
	@Column(name="CCD_SYS_ID")
	private Long CCD_SYS_ID;
	
	@Column(name="CCD_CLAIM_SYS_ID")
	private Long CCD_CLAIM_SYS_ID;

	@Column(name="CCD_CR_UID")
	private String CCD_CR_UID;

	@Column(name="CCD_CR_DT")
	private Date CCD_CR_DT;

	@Column(name="CCD_UPD_UID")
	private String CCD_UPD_UID;

	@Column(name="CCD_UPD_DT")
	private Date CCD_UPD_DT;
	
	@Column(name="CCD_CLOSE_FLAG")
	private String CCD_CLOSE_FLAG;
	
	@Column(name="CCD_RESERVE_GEN_FLAG")
	private String CCD_RESERVE_GEN_FLAG;
	
	@Column(name="CCD_FITR_YN")
	private String CCD_FITR_YN;

	@Column(name="CCD_CLOSE_DT")
	private Date CCD_CLOSE_DT;

	@Column(name="CCD_COVER_CODE")
	private String CCD_COVER_CODE;

	@Column(name="CCD_LOSS_TYPE")
	private String CCD_LOSS_TYPE;

	@Column(name="CCD_DISAB_TYPE")
	private String CCD_DISAB_TYPE;

	@Column(name="CCD_PERIOD")
	private Integer CCD_PERIOD;

	@Column(name="CCD_NO_OF_DAYS")
	private Integer CCD_NO_OF_DAYS;

	@Column(name="CCD_RATE")
	private Double CCD_RATE;

	@Column(name="CCD_RATE_PER")
	private Double CCD_RATE_PER;

	@Column(name="CCD_FC_EST_AMT")
	private Double CCD_FC_EST_AMT;

	@Column(name="CCD_FRZ_FLAG")
	private String CCD_FRZ_FLAG;

	@Column(name="CCD_CONFIRM_FLAG")
	private String CCD_CONFIRM_FLAG;

	@Column(name="CCD_RESERVE_DT")
	private Date CCD_RESERVE_DT;

	@Column(name="CCD_PERIOD_UNIT")
	private String CCD_PERIOD_UNIT;

	@Column(name="CCD_LC_EST_AMT")
	private Double CCD_LC_EST_AMT;

	@Column(name="CCD_SET_FLAG")
	private String CCD_SET_FLAG;

	@Column(name="CCD_CLAIM_PAY_TO")
	private String CCD_CLAIM_PAY_TO;
	
	private String CCD_PROD_CODE;
	
	private String COVER_TYPE;

	private String CCD_COVER_GROUP_CODE;

	private String CCD_CLAIM_ILL_TYPE;
	
	private String UI_M_CCD_COVER_CODE_DESC;

	private String UI_M_CCD_LOSS_TYPE_DESC;

	private String UI_M_CCD_DISAB_TYPE_DESC;
	
	private String UI_M_CCD_PROD_CODE_DESC;
	
	private Double UI_M_REFUND_SERV_FEE;
	
	private Double UI_M_REFUND_WAK_FEE;
	
	private Double UI_M_REFUND_RISK_PREM;
	
	private Double CCDH_O_LC_EST_AMT;
	
	private Double COVER_SA_CALC;
	
	private String M_CCD_COVER_CLASS = null;
	
	private Double M_CCD_WOP_SA;
	
	private Double M_EST_CHECK;



	

	/**
	 * @return the m_EST_CHECK
	 */
	public Double getM_EST_CHECK() {
		return M_EST_CHECK;
	}

	/**
	 * @param m_est_check the m_EST_CHECK to set
	 */
	public void setM_EST_CHECK(Double m_est_check) {
		M_EST_CHECK = m_est_check;
	}

	/**
	 * @return the m_CCD_WOP_SA
	 */
	public Double getM_CCD_WOP_SA() {
		return M_CCD_WOP_SA;
	}

	/**
	 * @param m_ccd_wop_sa the m_CCD_WOP_SA to set
	 */
	public void setM_CCD_WOP_SA(Double m_ccd_wop_sa) {
		M_CCD_WOP_SA = m_ccd_wop_sa;
	}

	/**
	 * @return the m_CCD_COVER_CLASS
	 */
	public String getM_CCD_COVER_CLASS() {
		return M_CCD_COVER_CLASS;
	}

	/**
	 * @param m_ccd_cover_class the m_CCD_COVER_CLASS to set
	 */
	public void setM_CCD_COVER_CLASS(String m_ccd_cover_class) {
		M_CCD_COVER_CLASS = m_ccd_cover_class;
	}

	/**
	 * @return the cOVER_SA_CALC
	 */
	public Double getCOVER_SA_CALC() {
		return COVER_SA_CALC;
	}

	/**
	 * @param cover_sa_calc the cOVER_SA_CALC to set
	 */
	public void setCOVER_SA_CALC(Double cover_sa_calc) {
		COVER_SA_CALC = cover_sa_calc;
	}

	/**
	 * @return the cCDH_O_LC_EST_AMT
	 */
	public Double getCCDH_O_LC_EST_AMT() {
		return CCDH_O_LC_EST_AMT;
	}

	/**
	 * @param ccdh_o_lc_est_amt the cCDH_O_LC_EST_AMT to set
	 */
	public void setCCDH_O_LC_EST_AMT(Double ccdh_o_lc_est_amt) {
		CCDH_O_LC_EST_AMT = ccdh_o_lc_est_amt;
	}

	


	/**
	 * @return the cCD_SYS_ID
	 */
	public Long getCCD_SYS_ID() {
		return CCD_SYS_ID;
	}

	/**
	 * @param ccd_sys_id the cCD_SYS_ID to set
	 */
	public void setCCD_SYS_ID(Long ccd_sys_id) {
		CCD_SYS_ID = ccd_sys_id;
	}

	/**
	 * @return the cCD_CR_UID
	 */
	public String getCCD_CR_UID() {
		return CCD_CR_UID;
	}

	/**
	 * @param ccd_cr_uid the cCD_CR_UID to set
	 */
	public void setCCD_CR_UID(String ccd_cr_uid) {
		CCD_CR_UID = ccd_cr_uid;
	}

	/**
	 * @return the cCD_CR_DT
	 */
	public Date getCCD_CR_DT() {
		return CCD_CR_DT;
	}

	/**
	 * @param ccd_cr_dt the cCD_CR_DT to set
	 */
	public void setCCD_CR_DT(Date ccd_cr_dt) {
		CCD_CR_DT = ccd_cr_dt;
	}

	/**
	 * @return the cCD_UPD_UID
	 */
	public String getCCD_UPD_UID() {
		return CCD_UPD_UID;
	}

	/**
	 * @param ccd_upd_uid the cCD_UPD_UID to set
	 */
	public void setCCD_UPD_UID(String ccd_upd_uid) {
		CCD_UPD_UID = ccd_upd_uid;
	}

	/**
	 * @return the cCD_UPD_DT
	 */
	public Date getCCD_UPD_DT() {
		return CCD_UPD_DT;
	}

	/**
	 * @param ccd_upd_dt the cCD_UPD_DT to set
	 */
	public void setCCD_UPD_DT(Date ccd_upd_dt) {
		CCD_UPD_DT = ccd_upd_dt;
	}

	/**
	 * @return the cCD_CLOSE_FLAG
	 */
	public String getCCD_CLOSE_FLAG() {
		return CCD_CLOSE_FLAG;
	}

	/**
	 * @param ccd_close_flag the cCD_CLOSE_FLAG to set
	 */
	public void setCCD_CLOSE_FLAG(String ccd_close_flag) {
		CCD_CLOSE_FLAG = ccd_close_flag;
	}

	/**
	 * @return the cCD_RESERVE_GEN_FLAG
	 */
	public String getCCD_RESERVE_GEN_FLAG() {
		return CCD_RESERVE_GEN_FLAG;
	}

	/**
	 * @param ccd_reserve_gen_flag the cCD_RESERVE_GEN_FLAG to set
	 */
	public void setCCD_RESERVE_GEN_FLAG(String ccd_reserve_gen_flag) {
		CCD_RESERVE_GEN_FLAG = ccd_reserve_gen_flag;
	}

	/**
	 * @return the cCD_FITR_YN
	 */
	public String getCCD_FITR_YN() {
		return CCD_FITR_YN;
	}

	/**
	 * @param ccd_fitr_yn the cCD_FITR_YN to set
	 */
	public void setCCD_FITR_YN(String ccd_fitr_yn) {
		CCD_FITR_YN = ccd_fitr_yn;
	}

	/**
	 * @return the cCD_PROD_CODE
	 */
	public String getCCD_PROD_CODE() {
		return CCD_PROD_CODE;
	}

	/**
	 * @param ccd_prod_code the cCD_PROD_CODE to set
	 */
	public void setCCD_PROD_CODE(String ccd_prod_code) {
		CCD_PROD_CODE = ccd_prod_code;
	}

	/**
	 * @return the cCD_COVER_GROUP_CODE
	 */
	public String getCCD_COVER_GROUP_CODE() {
		return CCD_COVER_GROUP_CODE;
	}

	/**
	 * @param ccd_cover_group_code the cCD_COVER_GROUP_CODE to set
	 */
	public void setCCD_COVER_GROUP_CODE(String ccd_cover_group_code) {
		CCD_COVER_GROUP_CODE = ccd_cover_group_code;
	}

	/**
	 * @return the cCD_CLAIM_ILL_TYPE
	 */
	public String getCCD_CLAIM_ILL_TYPE() {
		return CCD_CLAIM_ILL_TYPE;
	}

	/**
	 * @param ccd_claim_ill_type the cCD_CLAIM_ILL_TYPE to set
	 */
	public void setCCD_CLAIM_ILL_TYPE(String ccd_claim_ill_type) {
		CCD_CLAIM_ILL_TYPE = ccd_claim_ill_type;
	}

	/**
	 * @return the uI_M_CCD_PROD_CODE_DESC
	 */
	public String getUI_M_CCD_PROD_CODE_DESC() {
		return UI_M_CCD_PROD_CODE_DESC;
	}

	/**
	 * @param ui_m_ccd_prod_code_desc the uI_M_CCD_PROD_CODE_DESC to set
	 */
	public void setUI_M_CCD_PROD_CODE_DESC(String ui_m_ccd_prod_code_desc) {
		UI_M_CCD_PROD_CODE_DESC = ui_m_ccd_prod_code_desc;
	}

	public Date getCCD_CLOSE_DT() {
		 return CCD_CLOSE_DT;
	}

	public void setCCD_CLOSE_DT(Date CCD_CLOSE_DT) {
		this.CCD_CLOSE_DT = CCD_CLOSE_DT;
	}

	public String getCCD_COVER_CODE() {
		return CCD_COVER_CODE;
	}

	public void setCCD_COVER_CODE(String CCD_COVER_CODE) {
		this.CCD_COVER_CODE = CCD_COVER_CODE;
	}

	public String getCCD_LOSS_TYPE() {
		return CCD_LOSS_TYPE;
	}

	public void setCCD_LOSS_TYPE(String CCD_LOSS_TYPE) {
		this.CCD_LOSS_TYPE = CCD_LOSS_TYPE;
	}

	public String getCCD_DISAB_TYPE() {
		return CCD_DISAB_TYPE;
	}

	public void setCCD_DISAB_TYPE(String CCD_DISAB_TYPE) {
		this.CCD_DISAB_TYPE = CCD_DISAB_TYPE;
	}

	public Integer getCCD_PERIOD() {
		return CCD_PERIOD;
	}

	public void setCCD_PERIOD(Integer ccd_period) {
		CCD_PERIOD = ccd_period;
	}

	public Integer getCCD_NO_OF_DAYS() {
		return CCD_NO_OF_DAYS;
	}

	public void setCCD_NO_OF_DAYS(Integer ccd_no_of_days) {
		CCD_NO_OF_DAYS = ccd_no_of_days;
	}

	public Double getCCD_RATE() {
		return CCD_RATE;
	}

	public void setCCD_RATE(Double CCD_RATE) {
		this.CCD_RATE = CCD_RATE;
	}

	public Double getCCD_RATE_PER() {
		return CCD_RATE_PER;
	}

	public void setCCD_RATE_PER(Double CCD_RATE_PER) {
		this.CCD_RATE_PER = CCD_RATE_PER;
	}

	public Double getCCD_FC_EST_AMT() {
		return CCD_FC_EST_AMT;
	}

	public void setCCD_FC_EST_AMT(Double CCD_FC_EST_AMT) {
		this.CCD_FC_EST_AMT = CCD_FC_EST_AMT;
	}

	public String getCCD_FRZ_FLAG() {
		return CCD_FRZ_FLAG;
	}

	public void setCCD_FRZ_FLAG(String CCD_FRZ_FLAG) {
		this.CCD_FRZ_FLAG = CCD_FRZ_FLAG;
	}

	public String getCCD_CONFIRM_FLAG() {
		return CCD_CONFIRM_FLAG;
	}

	public void setCCD_CONFIRM_FLAG(String CCD_CONFIRM_FLAG) {
		this.CCD_CONFIRM_FLAG = CCD_CONFIRM_FLAG;
	}

	public Date getCCD_RESERVE_DT() {
		 return CCD_RESERVE_DT;
	}

	public void setCCD_RESERVE_DT(Date CCD_RESERVE_DT) {
		this.CCD_RESERVE_DT = CCD_RESERVE_DT;
	}

	public String getCCD_PERIOD_UNIT() {
		return CCD_PERIOD_UNIT;
	}

	public void setCCD_PERIOD_UNIT(String CCD_PERIOD_UNIT) {
		this.CCD_PERIOD_UNIT = CCD_PERIOD_UNIT;
	}

	public Double getCCD_LC_EST_AMT() {
		return CCD_LC_EST_AMT;
	}

	public void setCCD_LC_EST_AMT(Double CCD_LC_EST_AMT) {
		this.CCD_LC_EST_AMT = CCD_LC_EST_AMT;
	}

	public String getCCD_SET_FLAG() {
		return CCD_SET_FLAG;
	}

	public void setCCD_SET_FLAG(String CCD_SET_FLAG) {
		this.CCD_SET_FLAG = CCD_SET_FLAG;
	}

	public String getCCD_CLAIM_PAY_TO() {
		return CCD_CLAIM_PAY_TO;
	}

	public void setCCD_CLAIM_PAY_TO(String CCD_CLAIM_PAY_TO) {
		this.CCD_CLAIM_PAY_TO = CCD_CLAIM_PAY_TO;
	}

	public String getUI_M_CCD_COVER_CODE_DESC() {
		return UI_M_CCD_COVER_CODE_DESC;
	}

	public void setUI_M_CCD_COVER_CODE_DESC(String UI_M_CCD_COVER_CODE_DESC) {
		this.UI_M_CCD_COVER_CODE_DESC = UI_M_CCD_COVER_CODE_DESC;
	}

	public String getUI_M_CCD_LOSS_TYPE_DESC() {
		return UI_M_CCD_LOSS_TYPE_DESC;
	}

	public void setUI_M_CCD_LOSS_TYPE_DESC(String UI_M_CCD_LOSS_TYPE_DESC) {
		this.UI_M_CCD_LOSS_TYPE_DESC = UI_M_CCD_LOSS_TYPE_DESC;
	}

	public String getUI_M_CCD_DISAB_TYPE_DESC() {
		return UI_M_CCD_DISAB_TYPE_DESC;
	}

	public void setUI_M_CCD_DISAB_TYPE_DESC(String UI_M_CCD_DISAB_TYPE_DESC) {
		this.UI_M_CCD_DISAB_TYPE_DESC = UI_M_CCD_DISAB_TYPE_DESC;
	}

	/**
	 * @return the cOVER_TYPE
	 */
	public String getCOVER_TYPE() {
		return COVER_TYPE;
	}

	/**
	 * @param cover_type the cOVER_TYPE to set
	 */
	public void setCOVER_TYPE(String cover_type) {
		COVER_TYPE = cover_type;
	}

	/**
	 * @return the cCD_CLAIM_SYS_ID
	 */
	public Long getCCD_CLAIM_SYS_ID() {
		return CCD_CLAIM_SYS_ID;
	}

	/**
	 * @param ccd_claim_sys_id the cCD_CLAIM_SYS_ID to set
	 */
	public void setCCD_CLAIM_SYS_ID(Long ccd_claim_sys_id) {
		CCD_CLAIM_SYS_ID = ccd_claim_sys_id;
	}

	public Double getUI_M_REFUND_SERV_FEE() {
		return UI_M_REFUND_SERV_FEE;
	}

	public void setUI_M_REFUND_SERV_FEE(Double ui_m_refund_serv_fee) {
		UI_M_REFUND_SERV_FEE = ui_m_refund_serv_fee;
	}

	public Double getUI_M_REFUND_WAK_FEE() {
		return UI_M_REFUND_WAK_FEE;
	}

	public void setUI_M_REFUND_WAK_FEE(Double ui_m_refund_wak_fee) {
		UI_M_REFUND_WAK_FEE = ui_m_refund_wak_fee;
	}

	public Double getUI_M_REFUND_RISK_PREM() {
		return UI_M_REFUND_RISK_PREM;
	}

	public void setUI_M_REFUND_RISK_PREM(Double ui_m_refund_risk_prem) {
		UI_M_REFUND_RISK_PREM = ui_m_refund_risk_prem;
	}
	//ADDED BY AMEEN ON 15-03-2017 AS PER VINOTH SUGG.
		@Column(name="CCD_EMAIL")
		private String CCD_EMAIL;

		public String getCCD_EMAIL() {
			return CCD_EMAIL;
		}

		public void setCCD_EMAIL(String cCD_EMAIL) {
			CCD_EMAIL = cCD_EMAIL;
		}
		//END
		
		/*added by raja on 19-06-2017 discussed with siva sir*/
		private boolean flag;

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		
		/*end*/
}

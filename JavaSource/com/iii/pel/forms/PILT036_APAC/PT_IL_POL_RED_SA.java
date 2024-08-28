package com.iii.pel.forms.PILT036_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_RED_SA")
public class PT_IL_POL_RED_SA extends BaseValueBean {
	
	@Column(name="PRS_SYS_ID")
	private Long PRS_SYS_ID;   
	
	@Column(name="PRS_POL_SYS_ID")
	private Long  PRS_POL_SYS_ID; 
	
	@Column(name="PRS_END_NO_IDX")
	private Integer PRS_END_NO_IDX;       
	    
	 
	@Column(name="PRS_ORG_FC_SA")
	private Double PRS_ORG_FC_SA     ;
	
	@Column(name="PRS_ORG_LC_SA")
	private Double PRS_ORG_LC_SA     ;
	
	@Column(name="PRS_ORG_INCOR_FC_SA")
	private Double PRS_ORG_INCOR_FC_SA ;
	
	@Column(name="PRS_ORG_INCOR_LC_SA")
	private Double PRS_ORG_INCOR_LC_SA; 
	 
	 
	@Column(name="PRS_LC_SURR_AMT")
	private Double PRS_LC_SURR_AMT ;
	
	@Column(name="PRS_FC_SURR_AMT")
	private Double PRS_FC_SURR_AMT; 


	

	@Column(name="PRS_COVER_CODE")
	private String PRS_COVER_CODE;

	private String UI_M_PRS_COVER_CODE_DESC;

	@Column(name="PRS_MONTH")
	private Integer PRS_MONTH;

	@Column(name="PRS_FC_SA")
	private Double PRS_FC_SA;

	@Column(name="PRS_LC_SA")
	private Double PRS_LC_SA;

	@Column(name="PRS_INCOR_FC_SA")
	private Double PRS_INCOR_FC_SA;

	@Column(name="PRS_INCOR_LC_SA")
	private Double PRS_INCOR_LC_SA;

	@Column(name="PRS_CR_DT")
	private Date PRS_CR_DT;     
	
	@Column(name="PRS_CR_UID")
	private String  PRS_CR_UID; 
	
	@Column(name="PRS_UPD_DT")
	private Date PRS_UPD_DT;       
	
	@Column(name="PRS_UPD_UID")
	private String PRS_UPD_UID; 

	
	
	
/*Added By Dhinesh 2.7.2016*/
    
    @Column(name = "PRS_FC_SA")
    private String PRS_FC_SA_UI;
    
    @Column(name = "PRS_LC_SA")
    private String PRS_LC_SA_UI;
    
    @Column(name = "PRS_INCOR_FC_SA")
    private String PRS_INCOR_FC_SA_UI;
    
    @Column(name = "PRS_INCOR_LC_SA")
    private String PRS_INCOR_LC_SA_UI;
    
    
    
    public String getPRS_FC_SA_UI() {
		return PRS_FC_SA_UI;
	}

	public void setPRS_FC_SA_UI(String pRS_FC_SA_UI) {
		PRS_FC_SA_UI = pRS_FC_SA_UI;
	}

	public String getPRS_LC_SA_UI() {
		return PRS_LC_SA_UI;
	}

	public void setPRS_LC_SA_UI(String pRS_LC_SA_UI) {
		PRS_LC_SA_UI = pRS_LC_SA_UI;
	}

	public String getPRS_INCOR_FC_SA_UI() {
		return PRS_INCOR_FC_SA_UI;
	}

	public void setPRS_INCOR_FC_SA_UI(String pRS_INCOR_FC_SA_UI) {
		PRS_INCOR_FC_SA_UI = pRS_INCOR_FC_SA_UI;
	}

	public String getPRS_INCOR_LC_SA_UI() {
		return PRS_INCOR_LC_SA_UI;
	}

	public void setPRS_INCOR_LC_SA_UI(String pRS_INCOR_LC_SA_UI) {
		PRS_INCOR_LC_SA_UI = pRS_INCOR_LC_SA_UI;
	}
    
   
    
    /*End*/

	public String getPRS_COVER_CODE() {
		return PRS_COVER_CODE;
	}

	public void setPRS_COVER_CODE(String PRS_COVER_CODE) {
		this.PRS_COVER_CODE = PRS_COVER_CODE;
	}

	public String getUI_M_PRS_COVER_CODE_DESC() {
		return UI_M_PRS_COVER_CODE_DESC;
	}

	public void setUI_M_PRS_COVER_CODE_DESC(String UI_M_PRS_COVER_CODE_DESC) {
		this.UI_M_PRS_COVER_CODE_DESC = UI_M_PRS_COVER_CODE_DESC;
	}

	public Integer getPRS_MONTH() {
		return PRS_MONTH;
	}

	public void setPRS_MONTH(Integer PRS_MONTH) {
		this.PRS_MONTH = PRS_MONTH;
	}

	public Double getPRS_FC_SA() {
		return PRS_FC_SA;
	}

	public void setPRS_FC_SA(Double PRS_FC_SA) {
		this.PRS_FC_SA = PRS_FC_SA;
	}

	public Double getPRS_LC_SA() {
		return PRS_LC_SA;
	}

	public void setPRS_LC_SA(Double PRS_LC_SA) {
		this.PRS_LC_SA = PRS_LC_SA;
	}

	public Double getPRS_INCOR_FC_SA() {
		return PRS_INCOR_FC_SA;
	}

	public void setPRS_INCOR_FC_SA(Double PRS_INCOR_FC_SA) {
		this.PRS_INCOR_FC_SA = PRS_INCOR_FC_SA;
	}

	public Double getPRS_INCOR_LC_SA() {
		return PRS_INCOR_LC_SA;
	}

	public void setPRS_INCOR_LC_SA(Double PRS_INCOR_LC_SA) {
		this.PRS_INCOR_LC_SA = PRS_INCOR_LC_SA;
	}

	public Long getPRS_SYS_ID() {
		return PRS_SYS_ID;
	}

	public void setPRS_SYS_ID(Long prs_sys_id) {
		PRS_SYS_ID = prs_sys_id;
	}

	public Long getPRS_POL_SYS_ID() {
		return PRS_POL_SYS_ID;
	}

	public void setPRS_POL_SYS_ID(Long prs_pol_sys_id) {
		PRS_POL_SYS_ID = prs_pol_sys_id;
	}

	public Integer getPRS_END_NO_IDX() {
		return PRS_END_NO_IDX;
	}

	public void setPRS_END_NO_IDX(Integer prs_end_no_idx) {
		PRS_END_NO_IDX = prs_end_no_idx;
	}

	public Double getPRS_ORG_FC_SA() {
		return PRS_ORG_FC_SA;
	}

	public void setPRS_ORG_FC_SA(Double prs_org_fc_sa) {
		PRS_ORG_FC_SA = prs_org_fc_sa;
	}

	public Double getPRS_ORG_LC_SA() {
		return PRS_ORG_LC_SA;
	}

	public void setPRS_ORG_LC_SA(Double prs_org_lc_sa) {
		PRS_ORG_LC_SA = prs_org_lc_sa;
	}

	public Double getPRS_ORG_INCOR_FC_SA() {
		return PRS_ORG_INCOR_FC_SA;
	}

	public void setPRS_ORG_INCOR_FC_SA(Double prs_org_incor_fc_sa) {
		PRS_ORG_INCOR_FC_SA = prs_org_incor_fc_sa;
	}

	public Double getPRS_ORG_INCOR_LC_SA() {
		return PRS_ORG_INCOR_LC_SA;
	}

	public void setPRS_ORG_INCOR_LC_SA(Double prs_org_incor_lc_sa) {
		PRS_ORG_INCOR_LC_SA = prs_org_incor_lc_sa;
	}

	public Double getPRS_LC_SURR_AMT() {
		return PRS_LC_SURR_AMT;
	}

	public void setPRS_LC_SURR_AMT(Double prs_lc_surr_amt) {
		PRS_LC_SURR_AMT = prs_lc_surr_amt;
	}

	public Double getPRS_FC_SURR_AMT() {
		return PRS_FC_SURR_AMT;
	}

	public void setPRS_FC_SURR_AMT(Double prs_fc_surr_amt) {
		PRS_FC_SURR_AMT = prs_fc_surr_amt;
	}

	public Date getPRS_CR_DT() {
		return PRS_CR_DT;
	}

	public void setPRS_CR_DT(Date prs_cr_dt) {
		PRS_CR_DT = prs_cr_dt;
	}

	public String getPRS_CR_UID() {
		return PRS_CR_UID;
	}

	public void setPRS_CR_UID(String prs_cr_uid) {
		PRS_CR_UID = prs_cr_uid;
	}

	public Date getPRS_UPD_DT() {
		return PRS_UPD_DT;
	}

	public void setPRS_UPD_DT(Date prs_upd_dt) {
		PRS_UPD_DT = prs_upd_dt;
	}

	public String getPRS_UPD_UID() {
		return PRS_UPD_UID;
	}

	public void setPRS_UPD_UID(String prs_upd_uid) {
		PRS_UPD_UID = prs_upd_uid;
	}
}
package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BENEFICIARY")
public class PT_IL_POL_BENEFICIARY extends BaseValueBean {

	@Column(name="PBEN_SYS_ID")
	private Long PBEN_SYS_ID;

	@Column(name="PBEN_POL_SYS_ID")
	private Long PBEN_POL_SYS_ID;

	@Column(name="PBEN_SR_NO")
	private Integer PBEN_SR_NO;

	@Column(name="PBEN_BNF_TYPE")
	private String PBEN_BNF_TYPE;

	@Column(name="PBEN_BNF_NAME")
	private String PBEN_BNF_NAME;

	@Column(name="PBEN_BNF_NAME_BL")
	private String PBEN_BNF_NAME_BL;

	@Column(name="PBEN_PERC")
	private Double PBEN_PERC;

	@Column(name="PBEN_RELATION_CODE")
	private String PBEN_RELATION_CODE;

	@Column(name="PBEN_ADDRESS_1")
	private String PBEN_ADDRESS_1;

	@Column(name="PBEN_ADDRESS_2")
	private String PBEN_ADDRESS_2;

	@Column(name="PBEN_ADDRESS_3")
	private String PBEN_ADDRESS_3;

	@Column(name="PBEN_ADDRESS_4")
	private String PBEN_ADDRESS_4;

	@Column(name="PBEN_ADDRESS_5")
	private String PBEN_ADDRESS_5;

	@Column(name="PBEN_ADDRESS_1_BL")
	private String PBEN_ADDRESS_1_BL;

	@Column(name="PBEN_ADDRESS_2_BL")
	private String PBEN_ADDRESS_2_BL;

	@Column(name="PBEN_ADDRESS_3_BL")
	private String PBEN_ADDRESS_3_BL;

	@Column(name="PBEN_ADDRESS_4_BL")
	private String PBEN_ADDRESS_4_BL;

	@Column(name="PBEN_ADDRESS_5_BL")
	private String PBEN_ADDRESS_5_BL;

	@Column(name="PBEN_REMARKS")
	private String PBEN_REMARKS;

	@Column(name="PBEN_REMARKS_BL")
	private String PBEN_REMARKS_BL;

	@Column(name="PBEN_CR_UID")
	private String PBEN_CR_UID;

	@Column(name="PBEN_CR_DT")
	private Date PBEN_CR_DT;

	@Column(name="PBEN_UPD_UID")
	private String PBEN_UPD_UID;

	@Column(name="PBEN_UPD_DT")
	private Date PBEN_UPD_DT;

	@Column(name="PBEN_CATG_CODE")
	private String PBEN_CATG_CODE;

	@Column(name="PBEN_AGE")
	private Integer PBEN_AGE;

	@Column(name="PBEN_GUARDIAN_NAME")
	private String PBEN_GUARDIAN_NAME;

	@Column(name="PBEN_DEL_FLAG")
	private String PBEN_DEL_FLAG;

	@Column(name="PBEN_REF_ID1")
	private String PBEN_REF_ID1;

	@Column(name="PBEN_REF_ID2")
	private String PBEN_REF_ID2;

	private String UI_M_CATG_DESC;
	
	private String UI_M_PBEN_TYPE_DESC;
	private Double UI_M_SUM_PBEN_PERC;
	
	private String UI_M_PBEN_RELATION_DESC;
	
	
	//ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND DIRECT CREDIT. 
	
	@Column(name="PBEN_MICR_CODE")
	private Long PBEN_MICR_CODE;
	
	
	@Column(name="PBEN_ACNT_NO")
	private Long PBEN_ACNT_NO;
	
	private String UI_M_CBAD_ACNT_NO;
	
	private String UI_M_CITY_CODE;
	
	private String UI_M_CITY_CODE_DESC;
	
	private String UI_M_BANK_CODE;
	
	private String UI_M_BANK_CODE_DESC;
	
	private String UI_M_BRANCH_CODE;
	
	private String UI_M_BRANCH_CODE_DESC;
	
	
	//ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND DIRECT CREDIT. 
	
	
	public void setPBEN_ADDRESS_1_BL(String PBEN_ADDRESS_1_BL) {
		this.PBEN_ADDRESS_1_BL = PBEN_ADDRESS_1_BL;
	}
	public String getPBEN_ADDRESS_1_BL() {
		 return PBEN_ADDRESS_1_BL;
	}
	public void setPBEN_ADDRESS_2_BL(String PBEN_ADDRESS_2_BL) {
		this.PBEN_ADDRESS_2_BL = PBEN_ADDRESS_2_BL;
	}
	public String getPBEN_ADDRESS_2_BL() {
		 return PBEN_ADDRESS_2_BL;
	}
	public void setUI_M_CATG_DESC(String UI_M_CATG_DESC) {
		this.UI_M_CATG_DESC = UI_M_CATG_DESC;
	}
	public String getUI_M_CATG_DESC() {
		 return UI_M_CATG_DESC;
	}
	public void setPBEN_SR_NO(Integer PBEN_SR_NO) {
		this.PBEN_SR_NO = PBEN_SR_NO;
	}
	public Integer getPBEN_SR_NO() {
		 return PBEN_SR_NO;
	}
	public void setPBEN_REMARKS(String PBEN_REMARKS) {
		this.PBEN_REMARKS = PBEN_REMARKS;
	}
	public String getPBEN_REMARKS() {
		 return PBEN_REMARKS;
	}
	public void setUI_M_PBEN_TYPE_DESC(String UI_M_PBEN_TYPE_DESC) {
		this.UI_M_PBEN_TYPE_DESC = UI_M_PBEN_TYPE_DESC;
	}
	public String getUI_M_PBEN_TYPE_DESC() {
		 return UI_M_PBEN_TYPE_DESC;
	}
	public void setUI_M_PBEN_RELATION_DESC(String UI_M_PBEN_RELATION_DESC) {
		this.UI_M_PBEN_RELATION_DESC = UI_M_PBEN_RELATION_DESC;
	}
	public String getUI_M_PBEN_RELATION_DESC() {
		 return UI_M_PBEN_RELATION_DESC;
	}
	public void setPBEN_UPD_UID(String PBEN_UPD_UID) {
		this.PBEN_UPD_UID = PBEN_UPD_UID;
	}
	public String getPBEN_UPD_UID() {
		 return PBEN_UPD_UID;
	}
	public void setPBEN_RELATION_CODE(String PBEN_RELATION_CODE) {
		this.PBEN_RELATION_CODE = PBEN_RELATION_CODE;
	}
	public String getPBEN_RELATION_CODE() {
		 return PBEN_RELATION_CODE;
	}
	public void setPBEN_BNF_TYPE(String PBEN_BNF_TYPE) {
		this.PBEN_BNF_TYPE = PBEN_BNF_TYPE;
	}
	public String getPBEN_BNF_TYPE() {
		 return PBEN_BNF_TYPE;
	}
	public void setPBEN_ADDRESS_2(String PBEN_ADDRESS_2) {
		this.PBEN_ADDRESS_2 = PBEN_ADDRESS_2;
	}
	public String getPBEN_ADDRESS_2() {
		 return PBEN_ADDRESS_2;
	}
	public void setPBEN_ADDRESS_1(String PBEN_ADDRESS_1) {
		this.PBEN_ADDRESS_1 = PBEN_ADDRESS_1;
	}
	public String getPBEN_ADDRESS_1() {
		 return PBEN_ADDRESS_1;
	}
	public void setPBEN_AGE(Integer PBEN_AGE) {
		this.PBEN_AGE = PBEN_AGE;
	}
	public Integer getPBEN_AGE() {
		 return PBEN_AGE;
	}
	public void setPBEN_ADDRESS_5(String PBEN_ADDRESS_5) {
		this.PBEN_ADDRESS_5 = PBEN_ADDRESS_5;
	}
	public String getPBEN_ADDRESS_5() {
		 return PBEN_ADDRESS_5;
	}
	public void setPBEN_BNF_NAME_BL(String PBEN_BNF_NAME_BL) {
		this.PBEN_BNF_NAME_BL = PBEN_BNF_NAME_BL;
	}
	public String getPBEN_BNF_NAME_BL() {
		 return PBEN_BNF_NAME_BL;
	}
	public void setPBEN_BNF_NAME(String PBEN_BNF_NAME) {
		this.PBEN_BNF_NAME = PBEN_BNF_NAME;
	}
	public String getPBEN_BNF_NAME() {
		 return PBEN_BNF_NAME;
	}
	public void setPBEN_REF_ID2(String PBEN_REF_ID2) {
		this.PBEN_REF_ID2 = PBEN_REF_ID2;
	}
	public String getPBEN_REF_ID2() {
		 return PBEN_REF_ID2;
	}
	public void setPBEN_GUARDIAN_NAME(String PBEN_GUARDIAN_NAME) {
		this.PBEN_GUARDIAN_NAME = PBEN_GUARDIAN_NAME;
	}
	public String getPBEN_GUARDIAN_NAME() {
		 return PBEN_GUARDIAN_NAME;
	}
	public void setPBEN_ADDRESS_4(String PBEN_ADDRESS_4) {
		this.PBEN_ADDRESS_4 = PBEN_ADDRESS_4;
	}
	public String getPBEN_ADDRESS_4() {
		 return PBEN_ADDRESS_4;
	}
	public void setPBEN_REF_ID1(String PBEN_REF_ID1) {
		this.PBEN_REF_ID1 = PBEN_REF_ID1;
	}
	public String getPBEN_REF_ID1() {
		 return PBEN_REF_ID1;
	}
	public void setPBEN_ADDRESS_3(String PBEN_ADDRESS_3) {
		this.PBEN_ADDRESS_3 = PBEN_ADDRESS_3;
	}
	public String getPBEN_ADDRESS_3() {
		 return PBEN_ADDRESS_3;
	}
	public void setPBEN_ADDRESS_5_BL(String PBEN_ADDRESS_5_BL) {
		this.PBEN_ADDRESS_5_BL = PBEN_ADDRESS_5_BL;
	}
	public String getPBEN_ADDRESS_5_BL() {
		 return PBEN_ADDRESS_5_BL;
	}
	public void setPBEN_SYS_ID(Long PBEN_SYS_ID) {
		this.PBEN_SYS_ID = PBEN_SYS_ID;
	}
	public Long getPBEN_SYS_ID() {
		 return PBEN_SYS_ID;
	}
	public void setPBEN_CR_DT(Date PBEN_CR_DT) {
		this.PBEN_CR_DT = PBEN_CR_DT;
	}
	public Date getPBEN_CR_DT() {
		 return PBEN_CR_DT;
	}
	public void setPBEN_UPD_DT(Date PBEN_UPD_DT) {
		this.PBEN_UPD_DT = PBEN_UPD_DT;
	}
	public Date getPBEN_UPD_DT() {
		 return PBEN_UPD_DT;
	}
	public void setPBEN_CR_UID(String PBEN_CR_UID) {
		this.PBEN_CR_UID = PBEN_CR_UID;
	}
	public String getPBEN_CR_UID() {
		 return PBEN_CR_UID;
	}
	public void setPBEN_POL_SYS_ID(Long PBEN_POL_SYS_ID) {
		this.PBEN_POL_SYS_ID = PBEN_POL_SYS_ID;
	}
	public Long getPBEN_POL_SYS_ID() {
		 return PBEN_POL_SYS_ID;
	}
	public void setPBEN_DEL_FLAG(String PBEN_DEL_FLAG) {
		this.PBEN_DEL_FLAG = PBEN_DEL_FLAG;
	}
	public String getPBEN_DEL_FLAG() {
		 return PBEN_DEL_FLAG;
	}
	public void setPBEN_ADDRESS_3_BL(String PBEN_ADDRESS_3_BL) {
		this.PBEN_ADDRESS_3_BL = PBEN_ADDRESS_3_BL;
	}
	public String getPBEN_ADDRESS_3_BL() {
		 return PBEN_ADDRESS_3_BL;
	}
	public void setPBEN_REMARKS_BL(String PBEN_REMARKS_BL) {
		this.PBEN_REMARKS_BL = PBEN_REMARKS_BL;
	}
	public String getPBEN_REMARKS_BL() {
		 return PBEN_REMARKS_BL;
	}
	public void setPBEN_PERC(Double PBEN_PERC) {
		this.PBEN_PERC = PBEN_PERC;
	}
	public Double getPBEN_PERC() {
		 return PBEN_PERC;
	}
	public void setPBEN_CATG_CODE(String PBEN_CATG_CODE) {
		this.PBEN_CATG_CODE = PBEN_CATG_CODE;
	}
	public String getPBEN_CATG_CODE() {
		 return PBEN_CATG_CODE;
	}
	public void setPBEN_ADDRESS_4_BL(String PBEN_ADDRESS_4_BL) {
		this.PBEN_ADDRESS_4_BL = PBEN_ADDRESS_4_BL;
	}
	public String getPBEN_ADDRESS_4_BL() {
		 return PBEN_ADDRESS_4_BL;
	}
	public Double getUI_M_SUM_PBEN_PERC() {
		return UI_M_SUM_PBEN_PERC;
	}
	public void setUI_M_SUM_PBEN_PERC(Double ui_m_sum_pben_perc) {
		UI_M_SUM_PBEN_PERC = ui_m_sum_pben_perc;
	}
	public Long getPBEN_MICR_CODE() {
		return PBEN_MICR_CODE;
	}
	public void setPBEN_MICR_CODE(Long pben_micr_code) {
		PBEN_MICR_CODE = pben_micr_code;
	}
	public String getUI_M_CBAD_ACNT_NO() {
		return UI_M_CBAD_ACNT_NO;
	}
	public void setUI_M_CBAD_ACNT_NO(String ui_m_cbad_acnt_no) {
		UI_M_CBAD_ACNT_NO = ui_m_cbad_acnt_no;
	}
	public String getUI_M_CITY_CODE() {
		return UI_M_CITY_CODE;
	}
	public void setUI_M_CITY_CODE(String ui_m_city_code) {
		UI_M_CITY_CODE = ui_m_city_code;
	}
	public String getUI_M_CITY_CODE_DESC() {
		return UI_M_CITY_CODE_DESC;
	}
	public void setUI_M_CITY_CODE_DESC(String ui_m_city_code_desc) {
		UI_M_CITY_CODE_DESC = ui_m_city_code_desc;
	}
	public String getUI_M_BANK_CODE() {
		return UI_M_BANK_CODE;
	}
	public void setUI_M_BANK_CODE(String ui_m_bank_code) {
		UI_M_BANK_CODE = ui_m_bank_code;
	}
	public String getUI_M_BANK_CODE_DESC() {
		return UI_M_BANK_CODE_DESC;
	}
	public void setUI_M_BANK_CODE_DESC(String ui_m_bank_code_desc) {
		UI_M_BANK_CODE_DESC = ui_m_bank_code_desc;
	}
	public String getUI_M_BRANCH_CODE() {
		return UI_M_BRANCH_CODE;
	}
	public void setUI_M_BRANCH_CODE(String ui_m_branch_code) {
		UI_M_BRANCH_CODE = ui_m_branch_code;
	}
	public String getUI_M_BRANCH_CODE_DESC() {
		return UI_M_BRANCH_CODE_DESC;
	}
	public void setUI_M_BRANCH_CODE_DESC(String ui_m_branch_code_desc) {
		UI_M_BRANCH_CODE_DESC = ui_m_branch_code_desc;
	}
	public Long getPBEN_ACNT_NO() {
		return PBEN_ACNT_NO;
	}
	public void setPBEN_ACNT_NO(Long pben_acnt_no) {
		PBEN_ACNT_NO = pben_acnt_no;
	}
	

	/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
	
	@Column(name="PBEN_CITY_CODE")
	private String PBEN_CITY_CODE;
	
	
	public String getPBEN_CITY_CODE() {
		return PBEN_CITY_CODE;
	}
	public void setPBEN_CITY_CODE(String pBEN_CITY_CODE) {
		PBEN_CITY_CODE = pBEN_CITY_CODE;
	}
	
	
	
	@Column(name="PBEN_BANK_CODE")
	private String PBEN_BANK_CODE;
	
	public String getPBEN_BANK_CODE() {
		return PBEN_BANK_CODE;
	}
	public void setPBEN_BANK_CODE(String pBEN_BANK_CODE) {
		PBEN_BANK_CODE = pBEN_BANK_CODE;
	}
 
	
	@Column(name="PBEN_DIVISION")
	private String PBEN_DIVISION;


	public String getPBEN_DIVISION() {
		return PBEN_DIVISION;
	}
	public void setPBEN_DIVISION(String pBEN_DIVISION) {
		PBEN_DIVISION = pBEN_DIVISION;
	} 

/*End*/
	/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
	@Column(name="PBEN_GUAR_REL_CODE")
	private String PBEN_GUAR_REL_CODE;

	
	private String PBEN_GUAR_REL_DESC;

	public String getPBEN_GUAR_REL_CODE() {
		return PBEN_GUAR_REL_CODE;
	}
	public void setPBEN_GUAR_REL_CODE(String pBEN_GUAR_REL_CODE) {
		PBEN_GUAR_REL_CODE = pBEN_GUAR_REL_CODE;
	}
	public String getPBEN_GUAR_REL_DESC() {
		return PBEN_GUAR_REL_DESC;
	}
	public void setPBEN_GUAR_REL_DESC(String pBEN_GUAR_REL_DESC) {
		PBEN_GUAR_REL_DESC = pBEN_GUAR_REL_DESC;
	}
	/*End*/
	/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	@Column(name="PBEN_DOB")
	private Date PBEN_DOB;
	
	@Column(name="PBEN_EFF_FM_DT")
	private Date PBEN_EFF_FM_DT;
	
	@Column(name="PBEN_EFF_TO_DT")
	private Date PBEN_EFF_TO_DT;
	
	
	@Column(name="PBEN_BNF_CODE")
	private String PBEN_BNF_CODE;


	public Date getPBEN_DOB() {
		return PBEN_DOB;
	}
	public void setPBEN_DOB(Date pBEN_DOB) {
		PBEN_DOB = pBEN_DOB;
	}
	public Date getPBEN_EFF_FM_DT() {
		return PBEN_EFF_FM_DT;
	}
	public void setPBEN_EFF_FM_DT(Date pBEN_EFF_FM_DT) {
		PBEN_EFF_FM_DT = pBEN_EFF_FM_DT;
	}
	public Date getPBEN_EFF_TO_DT() {
		return PBEN_EFF_TO_DT;
	}
	public void setPBEN_EFF_TO_DT(Date pBEN_EFF_TO_DT) {
		PBEN_EFF_TO_DT = pBEN_EFF_TO_DT;
	}
	public String getPBEN_BNF_CODE() {
		return PBEN_BNF_CODE;
	}
	public void setPBEN_BNF_CODE(String pBEN_BNF_CODE) {
		PBEN_BNF_CODE = pBEN_BNF_CODE;
	}
	
	
	/* end */
	//ADDED BY AMEEN ON 15-03-2017 AS PER VINOTH SUGG.
		@Column(name="PBEN_EMAIL")
		private String PBEN_EMAIL;

		public String getPBEN_EMAIL() {
			return PBEN_EMAIL;
		}
		
		public void setPBEN_EMAIL(String pBEN_EMAIL) {
			PBEN_EMAIL = pBEN_EMAIL;
		}
		
		//End
		
		/*Added by ganesh on 04-09-2017 */
		@Column(name="PBEN_REC_TYPE")
		private Integer PBEN_REC_TYPE;


		public Integer getPBEN_REC_TYPE() {
			return PBEN_REC_TYPE;
		}
		public void setPBEN_REC_TYPE(Integer pBEN_REC_TYPE) {
			PBEN_REC_TYPE = pBEN_REC_TYPE;
		}
		/*end*/
		
		/*Newly added by pidugu raj dt: 16-09-2020 for Guardian national Id*/
		@Column(name="PBEN_GUARDIAN_NATN_ID")
		private String PBEN_GUARDIAN_NATN_ID;


		public String getPBEN_GUARDIAN_NATN_ID() {
			return PBEN_GUARDIAN_NATN_ID;
		}
		public void setPBEN_GUARDIAN_NATN_ID(String pBEN_GUARDIAN_NATN_ID) {
			PBEN_GUARDIAN_NATN_ID = pBEN_GUARDIAN_NATN_ID;
		}
		/*End*/
		/*Newly added by pidugu raj dt: 22-09-2020 for Guardian Natinal Id type*/
		@Column(name="PBEN_GUARDIAN_ID_TYPE")
		private String PBEN_GUARDIAN_ID_TYPE;

		@Column(name="PBEN_BENEF_ID_TYPE")
		private String PBEN_BENEF_ID_TYPE;


		public String getPBEN_GUARDIAN_ID_TYPE() {
			return PBEN_GUARDIAN_ID_TYPE;
		}
		public void setPBEN_GUARDIAN_ID_TYPE(String pBEN_GUARDIAN_ID_TYPE) {
			PBEN_GUARDIAN_ID_TYPE = pBEN_GUARDIAN_ID_TYPE;
		}
		public String getPBEN_BENEF_ID_TYPE() {
			return PBEN_BENEF_ID_TYPE;
		}
		public void setPBEN_BENEF_ID_TYPE(String pBEN_BENEF_ID_TYPE) {
			PBEN_BENEF_ID_TYPE = pBEN_BENEF_ID_TYPE;
		}
		
		/*End*/
		
		/*Newly added by pidugu raj dt: 28-09-2020 for Beneficiary Mobile number in Alliance IL*/
		@Column(name="PBEN_MOBILE_NO")
		private Integer PBEN_MOBILE_NO;
		
		@Column(name="PBEN_AREA_CODE")
		private String PBEN_AREA_CODE;


		/*public int getPBEN_MOBILE_NO() {
			return PBEN_MOBILE_NO;
		}
		public void setPBEN_MOBILE_NO(int pBEN_MOBILE_NO) {
			PBEN_MOBILE_NO = pBEN_MOBILE_NO;
		}*/
		public Integer getPBEN_MOBILE_NO() {
			return PBEN_MOBILE_NO;
		}
		public void setPBEN_MOBILE_NO(Integer pBEN_MOBILE_NO) {
			PBEN_MOBILE_NO = pBEN_MOBILE_NO;
		}
		
		public String getPBEN_AREA_CODE() {
			return PBEN_AREA_CODE;
		}
		
		public void setPBEN_AREA_CODE(String pBEN_AREA_CODE) {
			PBEN_AREA_CODE = pBEN_AREA_CODE;
		}
		/*End Newly added by pidugu raj dt: 28-09-2020 for Beneficiary Mobile number in Alliance IL*/
		
		/*Newly added by pidugu raj dt: 06-10-2020 for Alliance IL 1780152*/
		@Column(name="PBEN_REL_OTHER")
		private String PBEN_REL_OTHER;


		public String getPBEN_REL_OTHER() {
			return PBEN_REL_OTHER;
		}
		public void setPBEN_REL_OTHER(String pBEN_REL_OTHER) {
			PBEN_REL_OTHER = pBEN_REL_OTHER;
		}
		
		
		
		
}

package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PT_IL_POL_FUNERAL_MEMB_DTLS")
public class PT_IL_POL_FUNERAL_MEMB_DTLS extends BaseValueBean{
	
	@Column(name="PFMD_CUST_CODE")
	private String PFMD_CUST_CODE;
	
	@Column(name="PFMD_CUST_DESC")
	private String PFMD_CUST_DESC;
	
	@Column(name="PFMD_RELATION_TYPE")
	private String PFMD_RELATION_TYPE;
	
	@Column(name="PFMD_MEMB_DOB")
	private Date PFMD_MEMB_DOB;
	
	@Column(name="PFMD_MEMB_AGE")
	private int PFMD_MEMB_AGE;
	
	@Column(name="PFMD_SA")
	private double PFMD_SA;
	
	@Column(name="PFMD_PREMIUM")
	private double PFMD_PREMIUM;
	
	@Column(name="PFMD_CURR_ASSR")
	private String PFMD_CURR_ASSR;
	private boolean PFMD_CURR_ASSR_UI;
	
	@Column(name="PFMD_WOP")
	private String PFMD_WOP;
	private boolean PFMD_WOP_UI; 
	
	@Column(name="PFMD_STATUS")
	private String PFMD_STATUS;
	private boolean PFMD_STATUS_UI; 

	@Column(name="PFMD_POL_SYS_ID")
	private long PFMD_POL_SYS_ID;
	
	@Column(name="PFMD_SYS_ID")
	private long PFMD_SYS_ID;
	

	@Column(name="PFMD_CR_DT")
	private Date PFMD_CR_DT;
	
	@Column(name="PFMD_CR_UID")
	private String PFMD_CR_UID;
	
	@Column(name="PFMD_UPD_DT")
	private Date PFMD_UPD_DT;
	
	@Column(name="PFMD_UPD_UID")
	private String PFMD_UPD_UID;
	
	private String PFMD_ADDRESS1;
	private String PFMD_ADDRESS2;
	private String PFMD_ADDRESS3;
	private String PFMD_PHONE;
	private String PFMD_CANTACT;
	private String PFMD_RELATION_DESC;
	
	
	
	public String getPFMD_RELATION_DESC() {
		return PFMD_RELATION_DESC;
	}

	

	public boolean isPFMD_CURR_ASSR_UI() {
		return PFMD_CURR_ASSR_UI;
	}

	public void setPFMD_CURR_ASSR_UI(boolean pFMD_CURR_ASSR_UI) {
		PFMD_CURR_ASSR_UI = pFMD_CURR_ASSR_UI;
		
		if(pFMD_CURR_ASSR_UI)
		{
			setPFMD_CURR_ASSR("Y");
		}
		else
		{
			setPFMD_CURR_ASSR("N");
		}
	}

	public boolean isPFMD_WOP_UI() {
		return PFMD_WOP_UI;
	}

	public void setPFMD_WOP_UI(boolean pFMD_WOP_UI) {
		PFMD_WOP_UI = pFMD_WOP_UI;

		if(pFMD_WOP_UI)
		{
			setPFMD_WOP("Y");
		}
		else
		{
			setPFMD_WOP("N");
		}
	}

	public boolean isPFMD_STATUS_UI() {
		return PFMD_STATUS_UI;
	}

	public void setPFMD_STATUS_UI(boolean pFMD_STATUS_UI) {
		PFMD_STATUS_UI = pFMD_STATUS_UI;
		if(pFMD_STATUS_UI)
		{
			setPFMD_STATUS("Y");
		}
		else
		{
			setPFMD_STATUS("N");
		}
	}

	public Date getPFMD_UPD_DT() {
		return PFMD_UPD_DT;
	}

	public void setPFMD_UPD_DT(Date pFMD_UPD_DT) {
		PFMD_UPD_DT = pFMD_UPD_DT;
	}

	public String getPFMD_UPD_UID() {
		return PFMD_UPD_UID;
	}

	public void setPFMD_UPD_UID(String pFMD_UPD_UID) {
		PFMD_UPD_UID = pFMD_UPD_UID;
	}

	public Date getPFMD_CR_DT() {
		return PFMD_CR_DT;
	}

	public void setPFMD_CR_DT(Date pFMD_CR_DT) {
		PFMD_CR_DT = pFMD_CR_DT;
	}

	public String getPFMD_CR_UID() {
		return PFMD_CR_UID;
	}

	public void setPFMD_CR_UID(String pFMD_CR_UID) {
		PFMD_CR_UID = pFMD_CR_UID;
	}

	
	public long getPFMD_POL_SYS_ID() {
		return PFMD_POL_SYS_ID;
	}

	public void setPFMD_POL_SYS_ID(long pFMD_POL_SYS_ID) {
		PFMD_POL_SYS_ID = pFMD_POL_SYS_ID;
	}

	public long getPFMD_SYS_ID() {
		return PFMD_SYS_ID;
	}

	public void setPFMD_SYS_ID(long pFMD_SYS_ID) {
		PFMD_SYS_ID = pFMD_SYS_ID;
	}

	public String getPFMD_STATUS() {
		return PFMD_STATUS;
	}

	public void setPFMD_STATUS(String pFMD_STATUS) {
		PFMD_STATUS = pFMD_STATUS;
	}

	public String getPFMD_ADDRESS1() {
		return PFMD_ADDRESS1;
	}

	public void setPFMD_ADDRESS1(String pFMD_ADDRESS1) {
		PFMD_ADDRESS1 = pFMD_ADDRESS1;
	}

	public String getPFMD_ADDRESS2() {
		return PFMD_ADDRESS2;
	}

	public void setPFMD_ADDRESS2(String pFMD_ADDRESS2) {
		PFMD_ADDRESS2 = pFMD_ADDRESS2;
	}

	public String getPFMD_ADDRESS3() {
		return PFMD_ADDRESS3;
	}

	public void setPFMD_ADDRESS3(String pFMD_ADDRESS3) {
		PFMD_ADDRESS3 = pFMD_ADDRESS3;
	}

	public String getPFMD_PHONE() {
		return PFMD_PHONE;
	}

	public void setPFMD_PHONE(String pFMD_PHONE) {
		PFMD_PHONE = pFMD_PHONE;
	}

	public String getPFMD_CANTACT() {
		return PFMD_CANTACT;
	}

	public void setPFMD_CANTACT(String pFMD_CANTACT) {
		PFMD_CANTACT = pFMD_CANTACT;
	}

	public String getPFMD_CUST_CODE() {
		return PFMD_CUST_CODE;
	}

	public void setPFMD_CUST_CODE(String pFMD_CUST_CODE) {
		PFMD_CUST_CODE = pFMD_CUST_CODE;
	}

	public String getPFMD_CUST_DESC() {
		return PFMD_CUST_DESC;
	}

	public void setPFMD_CUST_DESC(String pFMD_CUST_DESC) {
		PFMD_CUST_DESC = pFMD_CUST_DESC;
	}

	public String getPFMD_RELATION_TYPE() {
		return PFMD_RELATION_TYPE;
	}

	public void setPFMD_RELATION_TYPE(String pFMD_RELATION_TYPE) {
		PFMD_RELATION_TYPE = pFMD_RELATION_TYPE;
	}

	public Date getPFMD_MEMB_DOB() {
		return PFMD_MEMB_DOB;
	}

	public void setPFMD_MEMB_DOB(Date pFMD_MEMB_DOB) {
		PFMD_MEMB_DOB = pFMD_MEMB_DOB;
	}

	
	public int getPFMD_MEMB_AGE() {
		return PFMD_MEMB_AGE;
	}

	public void setPFMD_MEMB_AGE(int pFMD_MEMB_AGE) {
		PFMD_MEMB_AGE = pFMD_MEMB_AGE;
	}

	

	public double getPFMD_SA() {
		return PFMD_SA;
	}

	public void setPFMD_SA(double pFMD_SA) {
		PFMD_SA = pFMD_SA;
	}

	public double getPFMD_PREMIUM() {
		return PFMD_PREMIUM;
	}

	public void setPFMD_PREMIUM(double pFMD_PREMIUM) {
		PFMD_PREMIUM = pFMD_PREMIUM;
	}

	public String getPFMD_CURR_ASSR() {
		return PFMD_CURR_ASSR;
	}

	public void setPFMD_CURR_ASSR(String pFMD_CURR_ASSR) {
		PFMD_CURR_ASSR = pFMD_CURR_ASSR;
	}

	public String getPFMD_WOP() {
		return PFMD_WOP;
	}

	public void setPFMD_WOP(String pFMD_WOP) {
		PFMD_WOP = pFMD_WOP;
	}



	public void setPFMD_RELATION_DESC(String pFMD_RELATION_DESC) {
		PFMD_RELATION_DESC = pFMD_RELATION_DESC;
	}

	/*added by gopi for showing description for relation type on 01/02/17*/
	@Column(name="PFMD_MEMB_TYPE")
	private String PFMD_MEMB_TYPE;



	public String getPFMD_MEMB_TYPE() {
		return PFMD_MEMB_TYPE;
	}



	public void setPFMD_MEMB_TYPE(String pFMD_MEMB_TYPE) {
		PFMD_MEMB_TYPE = pFMD_MEMB_TYPE;
	}
	private String PFMD_MEMB_TYPE_DESC;



	public String getPFMD_MEMB_TYPE_DESC() {
		return PFMD_MEMB_TYPE_DESC;
	}



	public void setPFMD_MEMB_TYPE_DESC(String pFMD_MEMB_TYPE_DESC) {
		PFMD_MEMB_TYPE_DESC = pFMD_MEMB_TYPE_DESC;
	}
	
	/*end*/
	
	
	/*@Column(name="PFMD_RELATION_TYPE")
	private String PFMD_RELATION_TYPE;
	
	@Column(name="PFMD_RELATION_TYPE")
	private String PFMD_RELATION_TYPE;
	
	@Column(name="PFMD_RELATION_TYPE")
	private String PFMD_RELATION_TYPE;
	
	@Column(name="PFMD_RELATION_TYPE")
	private String PFMD_RELATION_TYPE;*/
	
	@Column(name="PFMD_AGE_PROOF_FLAG")
	private String PFMD_AGE_PROOF_FLAG;
	
	@Column(name="PFMD_AGE_PROOF_OTHERS")
	private String PFMD_AGE_PROOF_OTHERS;
	
	@Column(name="PFMD_HIV_TEST_YN")
	private String PFMD_HIV_TEST_YN;
	
	@Column(name="PFMD_LC_THRESHOLD_LMT")
	private double PFMD_LC_THRESHOLD_LMT;


	private String UI_M_NATIONAL_ID;
	
	
	
	public String getUI_M_NATIONAL_ID() {
		return UI_M_NATIONAL_ID;
	}



	public void setUI_M_NATIONAL_ID(String uI_M_NATIONAL_ID) {
		UI_M_NATIONAL_ID = uI_M_NATIONAL_ID;
	}



	public String getPFMD_AGE_PROOF_FLAG() {
		return PFMD_AGE_PROOF_FLAG;
	}



	public void setPFMD_AGE_PROOF_FLAG(String pFMD_AGE_PROOF_FLAG) {
		PFMD_AGE_PROOF_FLAG = pFMD_AGE_PROOF_FLAG;
	}



	public String getPFMD_AGE_PROOF_OTHERS() {
		return PFMD_AGE_PROOF_OTHERS;
	}



	public void setPFMD_AGE_PROOF_OTHERS(String pFMD_AGE_PROOF_OTHERS) {
		PFMD_AGE_PROOF_OTHERS = pFMD_AGE_PROOF_OTHERS;
	}



	public String getPFMD_HIV_TEST_YN() {
		return PFMD_HIV_TEST_YN;
	}



	public void setPFMD_HIV_TEST_YN(String pFMD_HIV_TEST_YN) {
		PFMD_HIV_TEST_YN = pFMD_HIV_TEST_YN;
	}



	public double getPFMD_LC_THRESHOLD_LMT() {
		return PFMD_LC_THRESHOLD_LMT;
	}



	public void setPFMD_LC_THRESHOLD_LMT(double pFMD_LC_THRESHOLD_LMT) {
		PFMD_LC_THRESHOLD_LMT = pFMD_LC_THRESHOLD_LMT;
	}
	
	
	/*Added by sankara narayanan on 22/04/2017 for Hospital Cash  Plan */
	@Column(name="PFMD_GENDER")
	private String PFMD_GENDER;
	@Column(name="PFMD_SMOKER_TEST_YN")
	private String PFMD_SMOKER_TEST_YN;
	private Integer PFMD_NO_OF_DAYS;
    private String UI_M_PFMD_GENDER_DESC;
  








	public String getUI_M_PFMD_GENDER_DESC() {
	return UI_M_PFMD_GENDER_DESC;
}



public void setUI_M_PFMD_GENDER_DESC(String uI_M_PFMD_GENDER_DESC) {
	UI_M_PFMD_GENDER_DESC = uI_M_PFMD_GENDER_DESC;
}



	public String getPFMD_GENDER() {
		return PFMD_GENDER;
	}



	public void setPFMD_GENDER(String pFMD_GENDER) {
		PFMD_GENDER = pFMD_GENDER;
	}



	public String getPFMD_SMOKER_TEST_YN() {
		return PFMD_SMOKER_TEST_YN;
	}



	public void setPFMD_SMOKER_TEST_YN(String pFMD_SMOKER_TEST_YN) {
		PFMD_SMOKER_TEST_YN = pFMD_SMOKER_TEST_YN;
	}



	public Integer getPFMD_NO_OF_DAYS() {
		return PFMD_NO_OF_DAYS;
	}



	public void setPFMD_NO_OF_DAYS(Integer pFMD_NO_OF_DAYS) {
		PFMD_NO_OF_DAYS = pFMD_NO_OF_DAYS;
	}
	
	
	
	
	
	/*end*/
	
	/*added by raja on 17-05-2017 for addition of dependant*/
	
	@Column(name="PFMD_REC_TYPE")
	private int PFMD_REC_TYPE;



	public int getPFMD_REC_TYPE() {
		return PFMD_REC_TYPE;
	}



	public void setPFMD_REC_TYPE(int pFMD_REC_TYPE) {
		PFMD_REC_TYPE = pFMD_REC_TYPE;
	}
	
	private String deleted;



	public String getDeleted() {
		return deleted;
	}



	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
/*end*/
	
	/* Added by R. Raja on 01-06-2017 for deletion endorsement*/
	@Column(name="PFMD_DEL_FLAG")
	private String PFMD_DEL_FLAG;



	public String getPFMD_DEL_FLAG() {
		return PFMD_DEL_FLAG;
	}



	public void setPFMD_DEL_FLAG(String pFMD_DEL_FLAG) {
		PFMD_DEL_FLAG = pFMD_DEL_FLAG;
	}


	/*end*/
	
	private String UI_M_PFMD_MEMB_DOB ;

	public String getUI_M_PFMD_MEMB_DOB() {
		return UI_M_PFMD_MEMB_DOB;
	}

	public void setUI_M_PFMD_MEMB_DOB(String uI_M_PFMD_MEMB_DOB) {
		UI_M_PFMD_MEMB_DOB = uI_M_PFMD_MEMB_DOB;
	} 
	
	/*Added by Ameen on 12-07-2017 for ZBILQC-1731204*/
	@Column(name="PFMD_BASIC_RATE")
	private double PFMD_BASIC_RATE;

	public double getPFMD_BASIC_RATE() {
		return PFMD_BASIC_RATE;
	}

	public void setPFMD_BASIC_RATE(double pFMD_BASIC_RATE) {
		PFMD_BASIC_RATE = pFMD_BASIC_RATE;
	}

	/*End*/
	
	/*Added by Ameen on 01-11-2017 for ZBLIFE-1449096*/
	@Column(name="PFMD_EFF_FM_DT")
	private Date PFMD_EFF_FM_DT;
	
	@Column(name="PFMD_EFF_TO_DT")
	private Date PFMD_EFF_TO_DT;

	public Date getPFMD_EFF_FM_DT() {
		return PFMD_EFF_FM_DT;
	}

	public void setPFMD_EFF_FM_DT(Date pFMD_EFF_FM_DT) {
		PFMD_EFF_FM_DT = pFMD_EFF_FM_DT;
	}

	public Date getPFMD_EFF_TO_DT() {
		return PFMD_EFF_TO_DT;
	}

	public void setPFMD_EFF_TO_DT(Date pFMD_EFF_TO_DT) {
		PFMD_EFF_TO_DT = pFMD_EFF_TO_DT;
	}
	
	/*END*/
	
	/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
	private String UI_M_PFMD_RELATION_DESC;



	public String getUI_M_PFMD_RELATION_DESC() {
		return UI_M_PFMD_RELATION_DESC;
	}



	public void setUI_M_PFMD_RELATION_DESC(String uI_M_PFMD_RELATION_DESC) {
		UI_M_PFMD_RELATION_DESC = uI_M_PFMD_RELATION_DESC;
	}
	/*end*/

	/*Added By Dhinesh on 05-06-2018 for FLA Funeral Changes*/
	@Column(name="PFMD_PREM_CALC_TYPE")
	private String PFMD_PREM_CALC_TYPE;

	public String getPFMD_PREM_CALC_TYPE() {
		return PFMD_PREM_CALC_TYPE;
	}

	public void setPFMD_PREM_CALC_TYPE(String pFMD_PREM_CALC_TYPE) {
		PFMD_PREM_CALC_TYPE = pFMD_PREM_CALC_TYPE;
	}
	
	
	/*End*/
	
}

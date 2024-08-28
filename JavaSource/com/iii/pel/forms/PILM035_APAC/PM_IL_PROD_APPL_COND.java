package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_COND")
public class PM_IL_PROD_APPL_COND extends BaseValueBean{

	@Column(name="PACOND_PROD_CODE")
	private String PACOND_PROD_CODE;

	@Column(name="PACOND_COND_CODE")
	private String PACOND_COND_CODE;

	@Column(name="PACOND_CR_DT")
	private Date PACOND_CR_DT;

	@Column(name="PACOND_CR_UID")
	private String PACOND_CR_UID;

	@Column(name="PACOND_UPD_DT")
	private Date PACOND_UPD_DT;

	@Column(name="PACOND_UPD_UID")
	private String PACOND_UPD_UID;
	
	
	private String UI_M_PACOND_COND_CODE_DESC;

	public String getPACOND_PROD_CODE() {
		 return PACOND_PROD_CODE;
	}

	public void setPACOND_PROD_CODE(String PACOND_PROD_CODE) {
		this.PACOND_PROD_CODE = PACOND_PROD_CODE;
	}

	public String getPACOND_COND_CODE() {
		 return PACOND_COND_CODE;
	}

	public void setPACOND_COND_CODE(String PACOND_COND_CODE) {
		this.PACOND_COND_CODE = PACOND_COND_CODE;
	}

	public Date getPACOND_CR_DT() {
		 return PACOND_CR_DT;
	}

	public void setPACOND_CR_DT(Date PACOND_CR_DT) {
		this.PACOND_CR_DT = PACOND_CR_DT;
	}

	public String getPACOND_CR_UID() {
		 return PACOND_CR_UID;
	}

	public void setPACOND_CR_UID(String PACOND_CR_UID) {
		this.PACOND_CR_UID = PACOND_CR_UID;
	}

	public Date getPACOND_UPD_DT() {
		 return PACOND_UPD_DT;
	}

	public void setPACOND_UPD_DT(Date PACOND_UPD_DT) {
		this.PACOND_UPD_DT = PACOND_UPD_DT;
	}

	public String getPACOND_UPD_UID() {
		 return PACOND_UPD_UID;
	}

	public void setPACOND_UPD_UID(String PACOND_UPD_UID) {
		this.PACOND_UPD_UID = PACOND_UPD_UID;
	}


	public String getUI_M_PACOND_COND_CODE_DESC() {
		return UI_M_PACOND_COND_CODE_DESC;
	}

	public void setUI_M_PACOND_COND_CODE_DESC(String ui_m_pacond_cond_code_desc) {
		UI_M_PACOND_COND_CODE_DESC = ui_m_pacond_cond_code_desc;
	}

	@Column(name="PACOND_DFLT_YN")
	private String PACOND_DFLT_YN;
	
	@Column(name="PACOND_FLEX_01")
	private String PACOND_FLEX_01;
	
	@Column(name="PACOND_COVER_CODE")
	private String PACOND_COVER_CODE;
	
	@Column(name="PACOND_DISP_SEQ_NO")
	private int PACOND_DISP_SEQ_NO;
	
	private int myPage = 1;

    public void initialise()
    {
        this.setMyPage(0);
    }

    public int getMyPage()
    {
        return myPage;
    }

    public void setMyPage(int page)
    {
        this.myPage = page;
    }
 

	public int getPACOND_DISP_SEQ_NO() {
		return PACOND_DISP_SEQ_NO;
	}

	public void setPACOND_DISP_SEQ_NO(int pACOND_DISP_SEQ_NO) {
		PACOND_DISP_SEQ_NO = pACOND_DISP_SEQ_NO;
	}

	public String getPACOND_DFLT_YN() {
		return PACOND_DFLT_YN;
	}

	public void setPACOND_DFLT_YN(String pACOND_DFLT_YN) {
		PACOND_DFLT_YN = pACOND_DFLT_YN;
	}

	public String getPACOND_FLEX_01() {
		return PACOND_FLEX_01;
	}

	public void setPACOND_FLEX_01(String pACOND_FLEX_01) {
		PACOND_FLEX_01 = pACOND_FLEX_01;
	}

	public String getPACOND_COVER_CODE() {
		return PACOND_COVER_CODE;
	}

	public void setPACOND_COVER_CODE(String pACOND_COVER_CODE) {
		PACOND_COVER_CODE = pACOND_COVER_CODE;
	}
	
	
	
	/*added by raja on 21-03-2017 for set description*/
	private String UI_M_PACOND_COVER_CODE_DESC;

	public String getUI_M_PACOND_COVER_CODE_DESC() {
		return UI_M_PACOND_COVER_CODE_DESC;
	}

	public void setUI_M_PACOND_COVER_CODE_DESC(String uI_M_PACOND_COVER_CODE_DESC) {
		UI_M_PACOND_COVER_CODE_DESC = uI_M_PACOND_COVER_CODE_DESC;
	}
	
	/*end*/

	
	
	
}

package com.iii.pel.forms.PILP075;

import java.math.BigDecimal;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_POL_CANC_REFN")
public class PT_IL_POL_CANC_REFN extends BaseValueBean 
{


	
	@Column(name="PCF_POL_NO")
	private String PCF_POL_NO;  //POLICY NO

	@Column(name="PCF_REFUND_DATE")
	private Date PCF_REFUND_DATE ;   // REFUND DATE 

	@Column(name="PCF_MONT_ELAP")
	private int PCF_MONT_ELAP; //MONTH ELAPSED

	@Column(name="PCF_POL_CONT_CODE")
	private String PCF_POL_CONT_CODE;  // Assured code 

	@Column(name="PCF_POL_ISSUE_DT")
	private Date PCF_POL_ISSUE_DT;  //Commencement Date

	@Column(name="PCF_COMM_LC_RFND")
	private Double PCF_COMM_LC_RFND ; //Commission Recovery
	
	@Column(name="PCF_FLEX_07")
	private String PCF_FLEX_07 ;
	
	public Double getPCF_COMM_LC_RFND() {
		return PCF_COMM_LC_RFND;
	}

	public void setPCF_COMM_LC_RFND(Double pCF_COMM_LC_RFND) {
		PCF_COMM_LC_RFND = pCF_COMM_LC_RFND;
	}

	
	@Column(name="PCF_FLEX_09")
	private String PCF_FLEX_09 ;
	
	
	@Column(name="PCF_FLEX_11")
	private Double PCF_FLEX_11 ;
	
	@Column(name="PCF_FLEX_01")
	private String PCF_FLEX_01;
	
	
	
	public String getPCF_FLEX_01() {
		return PCF_FLEX_01;
	}

	public void setPCF_FLEX_01(String pCF_FLEX_01) {
		PCF_FLEX_01 = pCF_FLEX_01;
	}

	
	
	
	@Column(name="PCF_MED_FEE_LC")
	private Double PCF_MED_FEE_LC ;
	
	
	
	@Column(name="PCF_SYS_ID")
	private int PCF_SYS_ID;
	
	@Column(name="PCF_CR_DT")
	private Date PCF_CR_DT;
	
	@Column(name="PCF_CR_UID")
	private String PCF_CR_UID;
	
	@Column(name="PCF_POL_SYS_ID")
	private int PCF_POL_SYS_ID;
	
	@Column(name="PCF_STATUS")
	private String PCF_STATUS;

	public String getPCF_STATUS() {
		return PCF_STATUS;
	}

	public void setPCF_STATUS(String pCF_STATUS) {
		PCF_STATUS = pCF_STATUS;
	}

	public int getPCF_POL_SYS_ID() {
		return PCF_POL_SYS_ID;
	}

	public void setPCF_POL_SYS_ID(int pCF_POL_SYS_ID) {
		PCF_POL_SYS_ID = pCF_POL_SYS_ID;
	}

	public int getPCF_SYS_ID() {
		return PCF_SYS_ID;
	}

	public void setPCF_SYS_ID(int pCF_SYS_ID) {
		PCF_SYS_ID = pCF_SYS_ID;
	}

	public Date getPCF_CR_DT() {
		return PCF_CR_DT;
	}

	public void setPCF_CR_DT(Date pCF_CR_DT) {
		PCF_CR_DT = pCF_CR_DT;
	}

	public String getPCF_CR_UID() {
		return PCF_CR_UID;
	}

	public void setPCF_CR_UID(String pCF_CR_UID) {
		PCF_CR_UID = pCF_CR_UID;
	}

	

	public String getPCF_POL_NO() {
		return PCF_POL_NO;
	}

	public void setPCF_POL_NO(String pCF_POL_NO) {
		PCF_POL_NO = pCF_POL_NO;
	}

	public Date getPCF_REFUND_DATE() {
		return PCF_REFUND_DATE;
	}

	public void setPCF_REFUND_DATE(Date pCF_REFUND_DATE) {
		PCF_REFUND_DATE = pCF_REFUND_DATE;
	}

	public int getPCF_MONT_ELAP() {
		return PCF_MONT_ELAP;
	}

	public void setPCF_MONT_ELAP(int pCF_MONT_ELAP) {
		PCF_MONT_ELAP = pCF_MONT_ELAP;
	}


	public String getPCF_POL_CONT_CODE() {
		return PCF_POL_CONT_CODE;
	}

	public void setPCF_POL_CONT_CODE(String pCF_POL_CONT_CODE) {
		PCF_POL_CONT_CODE = pCF_POL_CONT_CODE;
	}

	public Date getPCF_POL_ISSUE_DT() {
		return PCF_POL_ISSUE_DT;
	}

	public void setPCF_POL_ISSUE_DT(Date pCF_POL_ISSUE_DT) {
		PCF_POL_ISSUE_DT = pCF_POL_ISSUE_DT;
	}



	

	public String getPCF_FLEX_07() {
		return PCF_FLEX_07;
	}

	public void setPCF_FLEX_07(String pCF_FLEX_07) {
		PCF_FLEX_07 = pCF_FLEX_07;
	}

	public String getPCF_FLEX_09() {
		return PCF_FLEX_09;
	}

	public void setPCF_FLEX_09(String pCF_FLEX_09) {
		PCF_FLEX_09 = pCF_FLEX_09;
	}


	public Double getPCF_FLEX_11() {
		return PCF_FLEX_11;
	}

	public void setPCF_FLEX_11(Double pCF_FLEX_11) {
		PCF_FLEX_11 = pCF_FLEX_11;
	}

	
	
	public Double getPCF_MED_FEE_LC() {
		return PCF_MED_FEE_LC;
	}

	public void setPCF_MED_FEE_LC(Double pCF_MED_FEE_LC) {
		PCF_MED_FEE_LC = pCF_MED_FEE_LC;
	}
	
	/*Modified by Ram on 27/11/2016 for Display values in 3 Decimal Parts*/
	@Column(name="PCF_PAID_PREM_LC")
	private String PCF_PAID_PREM_LC ;  //Premium Amount Paid 
	public String getPCF_PAID_PREM_LC() {
		return PCF_PAID_PREM_LC;
	}

	public void setPCF_PAID_PREM_LC(String pCF_PAID_PREM_LC) {
		
		 
		pCF_PAID_PREM_LC = Decimal_Convert(pCF_PAID_PREM_LC);
	 
		
		PCF_PAID_PREM_LC = pCF_PAID_PREM_LC;
	}
	
	
	@Column(name="PCF_DOC_FEE_LC")
	private String PCF_DOC_FEE_LC ;
	
	public String getPCF_DOC_FEE_LC() {
		return PCF_DOC_FEE_LC;
	}

	public void setPCF_DOC_FEE_LC(String pCF_DOC_FEE_LC) {
		/*Added by Ram on 27/11/2016 for Display values in 3 Decimal Parts*/
		PCF_DOC_FEE_LC = Decimal_Convert(pCF_DOC_FEE_LC);
		/*End*/
		//PCF_DOC_FEE_LC = pCF_DOC_FEE_LC;
	}
	
	@Column(name="PCF_FLEX_12")
	private String PCF_FLEX_12 ;
	
	public String getPCF_FLEX_12() {
		return PCF_FLEX_12;
	}

	public void setPCF_FLEX_12(String pCF_FLEX_12) {
		PCF_FLEX_12 = Decimal_Convert(pCF_FLEX_12);
	}

	@Column(name="PCF_FLEX_08")
	private String PCF_FLEX_08 ;   //POLICY SUM ASSURED
	

	public String getPCF_FLEX_08() {
		return PCF_FLEX_08;
	}

	public void setPCF_FLEX_08(String pCF_FLEX_08) {
		PCF_FLEX_08 = Decimal_Convert(pCF_FLEX_08);
	}

	@Column(name="PCF_MEI_REF_FC")
	private String PCF_MEI_REF_FC ;
	

	public String getPCF_MEI_REF_FC() {
		return PCF_MEI_REF_FC;
	}

	public void setPCF_MEI_REF_FC(String pCF_MEI_REF_FC) {
		PCF_MEI_REF_FC = Decimal_Convert(pCF_MEI_REF_FC);
	}

	
/*End*/
	
	/*Added by Ram on 27/11/2016 for Display values in 3 Decimal Parts*/
	public String Decimal_Convert(String Value)
	{
	if(Value != null)
	{
	int decimalPlaces=0;
	System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
	decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
	System.out.println("decimalPlaces   : "+decimalPlaces);


	BigDecimal bd = new BigDecimal(Value);
	bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);

	return bd.toString();
	}
	else
	{
	return "0.000";
	}
	} 

	/*End*/
	
	
	/*Newly Added By Dhinesh on 27.3.2017*/
	@Column(name="PCF_COMM_FC_RFND")
	private Double PCF_COMM_FC_RFND ;	
	@Column(name="PCF_MEI_REF_LC")
	private String PCF_MEI_REF_LC ;
		
	public Double getPCF_COMM_FC_RFND() {
		return PCF_COMM_FC_RFND;
	}

	public void setPCF_COMM_FC_RFND(Double pCF_COMM_FC_RFND) {
		PCF_COMM_FC_RFND = pCF_COMM_FC_RFND;
	}
	public String getPCF_MEI_REF_LC() {
		return PCF_MEI_REF_LC;
	}

	public void setPCF_MEI_REF_LC(String pCF_MEI_REF_LC) {
		PCF_MEI_REF_LC = pCF_MEI_REF_LC;
	}
/*End*/
}

package com.iii.pel.forms.PILT017;

import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {


    private String BASE_CURR_CODE;
    
    private String PD_REMARKS;
    
    private String PD_ADDR_01;
    
    private String PD_ADDR_02;

    private String PD_ADDR_03;
    
    private String PD_CUST_NAME;
    
    

    public String getPD_CUST_NAME() {
		return PD_CUST_NAME;
	}

	public void setPD_CUST_NAME(String pd_cust_name) {
		PD_CUST_NAME = pd_cust_name;
	}

	public String getBASE_CURR_CODE() {
        return BASE_CURR_CODE;
    }

    public void setBASE_CURR_CODE(String base_curr_code) {
        BASE_CURR_CODE = base_curr_code;
    }

	public String getPD_REMARKS() {
		return PD_REMARKS;
	}

	public void setPD_REMARKS(String pd_remarks) {
		PD_REMARKS = pd_remarks;
	}

	public String getPD_ADDR_03() {
		return PD_ADDR_03;
	}

	public void setPD_ADDR_03(String pd_addr_03) {
		PD_ADDR_03 = pd_addr_03;
	}

	public String getPD_ADDR_02() {
		return PD_ADDR_02;
	}

	public void setPD_ADDR_02(String pd_addr_02) {
		PD_ADDR_02 = pd_addr_02;
	}

	public String getPD_ADDR_01() {
		return PD_ADDR_01;
	}

	public void setPD_ADDR_01(String pd_addr_01) {
		PD_ADDR_01 = pd_addr_01;
	}
    
	public static void main(String[] args) {
	    String str = "DilesA";
	    int i = str.substring(str.length()-1).charAt(0);
	    String condition = " I CC C1 C2 C3 C4 C5 C6 ";
		String PD_PAY_MODE = "C7";
	    if (condition.contains(" " + PD_PAY_MODE + " ")) {
		
		System.out.println("if "+PD_PAY_MODE);
		
	    }
	    System.out.println(i);
	}
}

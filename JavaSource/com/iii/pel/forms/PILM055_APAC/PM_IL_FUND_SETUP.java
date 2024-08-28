package com.iii.pel.forms.PILM055_APAC;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_FUND_SETUP")
public class PM_IL_FUND_SETUP extends BaseValueBean {
	
	@Column(name="FS_CR_DT")
	private Date FS_CR_DT;
	
	@Column(name="FS_CR_UID")
	private String FS_CR_UID;
	
	@Column(name="FS_UPD_DT")
	private Date FS_UPD_DT;
	
	@Column(name="FS_UPD_UID")
	private String FS_UPD_UID;

	@Column(name="FS_MIN_WD_LC_AMT")
	private Double FS_MIN_WD_LC_AMT;

	@Column(name="FS_MIN_DAY_WD")
	private Integer FS_MIN_DAY_WD;

	@Column(name="FS_MIN_WD_BAL_LC_AMT")
	private Double FS_MIN_WD_BAL_LC_AMT;

	@Column(name="FS_DUR_FOR_WD")
	private Integer FS_DUR_FOR_WD;

	@Column(name="FS_SW_MAX_NO")
	private Integer FS_SW_MAX_NO;

	@Column(name="FS_SW_WAIT_PERIOD")
	private Integer FS_SW_WAIT_PERIOD;

	@Column(name="FS_SW_MIN_BAL_LC_AMT")
	private Double FS_SW_MIN_BAL_LC_AMT;

	@Column(name="FS_DUR_FOR_SW")
	private Integer FS_DUR_FOR_SW;

	@Column(name="FS_FRZ_YN")
	private String FS_FRZ_YN = "N";
	
	private boolean FS_FRZ_YN_VALUE;

	@Column(name="FS_CODE")
	private String FS_CODE;

	@Column(name="FS_DESC")
	private String FS_DESC;

	@Column(name="FS_SHORT_DESC")
	private String FS_SHORT_DESC;

	@Column(name="FS_LONG_DESC")
	private String FS_LONG_DESC;

	@Column(name="FS_BL_DESC")
	private String FS_BL_DESC;

	@Column(name="FS_BL_SHORT_DESC")
	private String FS_BL_SHORT_DESC;

	@Column(name="FS_FUND_TYPE")
	private String FS_FUND_TYPE;

	@Column(name="FS_FRAC_UNIT_YN")
	private String FS_FRAC_UNIT_YN;

	@Column(name="FS_EFF_FM_DT")
	private Date FS_EFF_FM_DT;

	@Column(name="FS_EFF_TO_DT")
	private Date FS_EFF_TO_DT;

	@Column(name="FS_ROUND_OPTION")
	private String FS_ROUND_OPTION;
	
	@Column(name="FS_ROUND_VALUE")
	private Integer FS_ROUND_VALUE;
	
	private boolean CHECK_BOX;



	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getFS_FRZ_YN() {
		return FS_FRZ_YN;
	}

	public void setFS_FRZ_YN(String FS_FRZ_YN) {
		if("Y".equalsIgnoreCase(FS_FRZ_YN)){
			FS_FRZ_YN_VALUE = true;
		} else {
			FS_FRZ_YN_VALUE = false;
		}
		this.FS_FRZ_YN = FS_FRZ_YN;
	}

	public String getFS_CODE() {
		return FS_CODE;
	}

	public void setFS_CODE(String FS_CODE) {
		this.FS_CODE = FS_CODE;
	}

	public String getFS_DESC() {
		return FS_DESC;
	}

	public void setFS_DESC(String FS_DESC) {
		this.FS_DESC = FS_DESC;
	}

	public String getFS_SHORT_DESC() {
		return FS_SHORT_DESC;
	}

	public void setFS_SHORT_DESC(String FS_SHORT_DESC) {
		this.FS_SHORT_DESC = FS_SHORT_DESC;
	}

	public String getFS_LONG_DESC() {
		return FS_LONG_DESC;
	}

	public void setFS_LONG_DESC(String FS_LONG_DESC) {
		this.FS_LONG_DESC = FS_LONG_DESC;
	}

	public String getFS_BL_DESC() {
		return FS_BL_DESC;
	}

	public void setFS_BL_DESC(String FS_BL_DESC) {
		this.FS_BL_DESC = FS_BL_DESC;
	}

	public String getFS_BL_SHORT_DESC() {
		return FS_BL_SHORT_DESC;
	}

	public void setFS_BL_SHORT_DESC(String FS_BL_SHORT_DESC) {
		this.FS_BL_SHORT_DESC = FS_BL_SHORT_DESC;
	}

	public String getFS_FUND_TYPE() {
		return FS_FUND_TYPE;
	}

	public void setFS_FUND_TYPE(String FS_FUND_TYPE) {
		this.FS_FUND_TYPE = FS_FUND_TYPE;
	}

	public String getFS_FRAC_UNIT_YN() {
		return FS_FRAC_UNIT_YN;
	}

	public void setFS_FRAC_UNIT_YN(String FS_FRAC_UNIT_YN) {
		this.FS_FRAC_UNIT_YN = FS_FRAC_UNIT_YN;
	}

	public Date getFS_EFF_FM_DT() {
		 return FS_EFF_FM_DT;
	}

	public void setFS_EFF_FM_DT(Date FS_EFF_FM_DT) {
		this.FS_EFF_FM_DT = FS_EFF_FM_DT;
	}

	public Date getFS_EFF_TO_DT() {
		 return FS_EFF_TO_DT;
	}

	public void setFS_EFF_TO_DT(Date FS_EFF_TO_DT) {
		this.FS_EFF_TO_DT = FS_EFF_TO_DT;
	}

	public String getFS_ROUND_OPTION() {
		return FS_ROUND_OPTION;
	}

	public void setFS_ROUND_OPTION(String FS_ROUND_OPTION) {
		this.FS_ROUND_OPTION = FS_ROUND_OPTION;
	}

	public Integer getFS_ROUND_VALUE() {
		return FS_ROUND_VALUE;
	}

	public void setFS_ROUND_VALUE(Integer fs_round_value) {
		FS_ROUND_VALUE = fs_round_value;
	}

	public Date getFS_CR_DT() {
		return FS_CR_DT;
	}

	public void setFS_CR_DT(Date fs_cr_dt) {
		FS_CR_DT = fs_cr_dt;
	}

	public String getFS_CR_UID() {
		return FS_CR_UID;
	}

	public void setFS_CR_UID(String fs_cr_uid) {
		FS_CR_UID = fs_cr_uid;
	}


	public Double getFS_MIN_WD_LC_AMT() {
		/*COMMENTED BY SUJATHA TO FIX LIFE_JAVA-1662352 
		 * if(FS_MIN_WD_LC_AMT!=null){
			
		if(FS_MIN_WD_LC_AMT==0){
			FS_MIN_WD_LC_AMT=null;
		}
		}*/
		return FS_MIN_WD_LC_AMT;
	}

	public void setFS_MIN_WD_LC_AMT(Double fs_min_wd_lc_amt) {
		FS_MIN_WD_LC_AMT = fs_min_wd_lc_amt;
	}

	public Integer getFS_MIN_DAY_WD() {
		/*COMMENTED BY SUJATHA TO FIX LIFE_JAVA-1662352 
		 * if(FS_MIN_DAY_WD!=null){
			if(FS_MIN_DAY_WD==0){
			FS_MIN_DAY_WD=null;
		 }
		}*/
		return FS_MIN_DAY_WD;
	}

	public void setFS_MIN_DAY_WD(Integer fs_min_day_wd) {
		FS_MIN_DAY_WD = fs_min_day_wd;
	}

	public Double getFS_MIN_WD_BAL_LC_AMT() {
		
		/*if(FS_MIN_WD_BAL_LC_AMT!=null){
		if(FS_MIN_WD_BAL_LC_AMT==0) {
			FS_MIN_WD_BAL_LC_AMT = null;
		}
		}*/
		return FS_MIN_WD_BAL_LC_AMT;
	}

	public void setFS_MIN_WD_BAL_LC_AMT(Double fs_min_wd_bal_lc_amt) {
		FS_MIN_WD_BAL_LC_AMT = fs_min_wd_bal_lc_amt;
	}

	public Integer getFS_DUR_FOR_WD() {
		/*COMMENTED BY SUJATHA TO FIX LIFE_JAVA-1662352 
		 * if(FS_DUR_FOR_WD!=null){
		if(FS_DUR_FOR_WD==0){
			FS_DUR_FOR_WD=null;
		}
		}*/
		return FS_DUR_FOR_WD;
	}

	public void setFS_DUR_FOR_WD(Integer fs_dur_for_wd) {
		FS_DUR_FOR_WD = fs_dur_for_wd;
	}

	public Integer getFS_SW_MAX_NO() {
		/*if(FS_SW_MAX_NO!=null){
		if(FS_SW_MAX_NO==0){
			FS_SW_MAX_NO=null;
		}
		}*/
		return FS_SW_MAX_NO;
	}

	public void setFS_SW_MAX_NO(Integer fs_sw_max_no) {
		FS_SW_MAX_NO = fs_sw_max_no;
	}

	public Integer getFS_SW_WAIT_PERIOD() {
		/*if(FS_SW_WAIT_PERIOD!=null){
		if(FS_SW_WAIT_PERIOD==0){
			FS_SW_WAIT_PERIOD=null;
		}
		}*/
		return FS_SW_WAIT_PERIOD;
	}

	public void setFS_SW_WAIT_PERIOD(Integer fs_sw_wait_period) {
		FS_SW_WAIT_PERIOD = fs_sw_wait_period;
	}

	public Double getFS_SW_MIN_BAL_LC_AMT() {
		FacesContext fc = FacesContext.getCurrentInstance();
		System.out.println("PM_IL_FUND_SETUP.getFS_SW_MIN_BAL_LC_AMT(-Inside)"+FS_SW_MIN_BAL_LC_AMT);
		
		if(FS_SW_MIN_BAL_LC_AMT!=null){
			System.out.println("NOT NULL");
			String temp = FS_SW_MIN_BAL_LC_AMT.toString();
			int length = temp.length();
			System.out.println("The Length Is" + length);
			int ind = temp.indexOf(".");
			String newString = temp.substring(0,ind);
			String freshString = temp.substring(ind);
			System.out.println("THE FIRST STRING IS " + newString);
			System.out.println("THE SECOND STRING IS" + freshString);
			
			System.out.println("FErshString_lenght"+freshString.length());
			System.out.println("freshString.charAt(0)" + freshString.charAt(0));
			System.out.println("freshString.charAt(1)" + freshString.charAt(1));
			
		   List chComponent = fc.getViewRoot().getChildren();
		   Iterator <UIComponent> it = chComponent.listIterator();
		   
		   
		   while(it.hasNext()){
			   System.out.println("it-Values"+it.next().toString());
		   }
		   
		    int childcount = fc.getViewRoot().getChildCount();
		    System.out.println("childcount  Iss"+childcount);
		   
		   Map<String,Object> attributeMap   =  fc.getViewRoot().getAttributes();
		   System.out.println("The Size Is "+ attributeMap .size());
		   
		   
		   
		  /* for (int i = 0; i < attributeMap.size(); i++) {*/
			   Set set=attributeMap.keySet();
			   Iterator ite=set.iterator();
			   while (ite.hasNext()) {
				   System.out.println("Inside While Loop");
				String key=(String) ite.next();
				System.out.println(attributeMap.get(key));
				
			}
			  /* System.out.println("PM_IL_FUND_SETUP.getFS_SW_MIN_BAL_LC_AMT()");
			   System.out.println(attributeMap.);*/
			
		
		   
		   
		   
		   
		   
		   
		    
		    
		    
		    
			/*if(freshString.charAt(1)!='0'){
				System.out.println("Fun >>>>>>>>>>>>>>>>");
				return FS_SW_MIN_BAL_LC_AMT;
			}*/
				
	        
	         
			/*Double tempdou = Double.parseDouble(newString);
			System.out.println("AAAAAAAAAAAAAAAAAA"+tempdou);
			FS_SW_MIN_BAL_LC_AMT = tempdou;*/
		}
		System.out.println("PM_IL_FUND_SETUP.getFS_SW_MIN_BAL_LC_AMT()-FS_SW_MIN_BAL_LC_AMT"+FS_SW_MIN_BAL_LC_AMT);
		return FS_SW_MIN_BAL_LC_AMT;
	}	
		
	

	public void setFS_SW_MIN_BAL_LC_AMT(Double fs_sw_min_bal_lc_amt) {
		FS_SW_MIN_BAL_LC_AMT = fs_sw_min_bal_lc_amt;
	}

	public Integer getFS_DUR_FOR_SW() {
		/*if(FS_DUR_FOR_SW!=null){
		if(FS_DUR_FOR_SW==0){
			FS_DUR_FOR_SW=null;
		}
		}*/
		return FS_DUR_FOR_SW;
		
	}

	public void setFS_DUR_FOR_SW(Integer fs_dur_for_sw) {
		FS_DUR_FOR_SW = fs_dur_for_sw;
	}

	public boolean isFS_FRZ_YN_VALUE() {
		return FS_FRZ_YN_VALUE;
	}

	public void setFS_FRZ_YN_VALUE(boolean fs_frz_yn_value) {
		FS_FRZ_YN_VALUE = fs_frz_yn_value;
	}

	public Date getFS_UPD_DT() {
		return FS_UPD_DT;
	}

	public void setFS_UPD_DT(Date fs_upd_dt) {
		FS_UPD_DT = fs_upd_dt;
	}

	public String getFS_UPD_UID() {
		return FS_UPD_UID;
	}

	public void setFS_UPD_UID(String fs_upd_uid) {
		FS_UPD_UID = fs_upd_uid;
	}

	
}

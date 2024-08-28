package com.iii.pel.jasperreports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class ReportParamSetup {

	
	public PARAM_LIST paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info,String reportId){
		
		String methodCorrespondingToReportId=new CommonUtils().propertyManager(PELConstants.pelReportsPropertiesFile,reportId);
		System.out.println("Method Name :"+methodCorrespondingToReportId);
		ReportParamSetup reportParamSetup=new ReportParamSetup();
		try {
			param_list=(PARAM_LIST)CommonUtils.invokeMethod(reportParamSetup,methodCorrespondingToReportId,param_list,ip_rep_info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return param_list;
		
	}
	public PARAM_LIST PILR_REP043_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(changeDateformat(ip_rep_info.getREP_VALUE_7()));
		param_list.setParmValue08(changeDateformat(ip_rep_info.getREP_VALUE_8()));
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());

		CommonUtils.objectSysout(param_list);
		
		return param_list;
	}

	
	public PARAM_LIST PILR_REP026_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
		param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		
		
		return param_list;
	}
public PARAM_LIST PILR_REP136_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_9());
		
		//<!--[ BugId:PREMIAGDC-000071 Siva Phanikumar.Keerthi 25-Feb-09 
		  //    modified the ParamValue09 and ParamValue10.These properties taken for the Date -->
		param_list.setParmValue09(changeDateformat(ip_rep_info.getREP_VALUE_10()));
		param_list.setParmValue10(changeDateformat(ip_rep_info.getREP_VALUE_11()));
		
		//<!-- BugId:PREMIAGDC-000071 Siva Phanikumar.Keerthi 25-Feb-09 
		  //    modified the ParamValue09 and ParamValue10.These properties taken for the Date -->]
		
		return param_list;
	}
	
	public PARAM_LIST PILR_REP009_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
		param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		
		
		return param_list;
	}
	
	public PARAM_LIST PILR_REP008_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
	param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}

	public PARAM_LIST PILR_REP046_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
	param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}


	public PARAM_LIST PILR_REP027_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
	param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}
	public PARAM_LIST PILR_REP034_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(changeDateformat(ip_rep_info.getREP_VALUE_9()));
		param_list.setParmValue10(changeDateformat(ip_rep_info.getREP_VALUE_10()));
		
		
		return param_list;
		}
	public PARAM_LIST PILR_REP029_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}

	public PARAM_LIST PILR_REP032_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){

		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}

	public PARAM_LIST PILR_REP041_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}
	
	public PARAM_LIST PILR_REP047_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
	param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}

	public PARAM_LIST PILR_REP048_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(changeDateformat(ip_rep_info.getREP_VALUE_7()));
		param_list.setParmValue08(changeDateformat(ip_rep_info.getREP_VALUE_8()));

		return param_list;
	}

	public PARAM_LIST PILR_REP037_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
	param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}


	public PARAM_LIST PILR_SCH01_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
	
	param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
	param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
	param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
	param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
	param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
	param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
	param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
	param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
	param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
	param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
	param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
	param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
	param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
	
	
	return param_list;
	}
	public PARAM_LIST PILR_REP033_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}

	public PARAM_LIST PILR_REP028_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {

		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(changeDateformat(ip_rep_info.getREP_VALUE_9()));
		param_list.setParmValue10(changeDateformat(ip_rep_info.getREP_VALUE_10()));

		return param_list;
	}
	
	public PARAM_LIST PILR_REP025_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(changeDateformat(ip_rep_info.getREP_VALUE_9()));
		param_list.setParmValue10(changeDateformat(ip_rep_info.getREP_VALUE_10()));
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		CommonUtils.objectSysout(param_list);
		return param_list;
		}
	
	public PARAM_LIST PILR_REP031_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
		param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		CommonUtils.objectSysout(param_list);
		return param_list;
		}
	
	public PARAM_LIST PILR_REP040_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
		param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		CommonUtils.objectSysout(param_list);
		return param_list;
		}


	public PARAM_LIST PILR_REP042_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {
		param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}
	public PARAM_LIST PILR_REP049_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {

		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());

		return param_list;
	}
	
public PARAM_LIST PILR_REP045_paramSetup(PARAM_LIST param_list,IP_REP_INFO ip_rep_info){
		
		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
		param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
		param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
		param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
		param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
		param_list.setParmValue09(ip_rep_info.getREP_VALUE_9());
		param_list.setParmValue10(ip_rep_info.getREP_VALUE_10());
		param_list.setParmValue11(ip_rep_info.getREP_VALUE_11());
		param_list.setParmValue12(ip_rep_info.getREP_VALUE_12());
		param_list.setParmValue13(ip_rep_info.getREP_VALUE_13());
		param_list.setParmValue14(ip_rep_info.getREP_VALUE_14());
		param_list.setParmValue15(ip_rep_info.getREP_VALUE_15());
		param_list.setParmValue16(ip_rep_info.getREP_VALUE_16());
		param_list.setParmValue17(ip_rep_info.getREP_VALUE_17());
		param_list.setParmValue18(ip_rep_info.getREP_VALUE_18());
		param_list.setParmValue19(ip_rep_info.getREP_VALUE_19());
		param_list.setParmValue20(ip_rep_info.getREP_VALUE_20());
		CommonUtils.objectSysout(param_list);
		return param_list;
		}

public PARAM_LIST PILR_REP036_paramSetup(PARAM_LIST param_list,
		IP_REP_INFO ip_rep_info) {

	param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
	param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	CommonUtils.objectSysout(param_list);

	return param_list;
}

public PARAM_LIST PILR_REP030_paramSetup(PARAM_LIST param_list,
		IP_REP_INFO ip_rep_info) {

	param_list.setParmValue01(ip_rep_info.getREP_VALUE_1());
	param_list.setParmValue02(ip_rep_info.getREP_VALUE_2());
	param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
	param_list.setParmValue04(ip_rep_info.getREP_VALUE_4());
	param_list.setParmValue05(ip_rep_info.getREP_VALUE_5());
	param_list.setParmValue06(ip_rep_info.getREP_VALUE_6());
	param_list.setParmValue07(ip_rep_info.getREP_VALUE_7());
	param_list.setParmValue08(ip_rep_info.getREP_VALUE_8());
	param_list.setParmValue09(changeDateformat(ip_rep_info.getREP_VALUE_9()));
	param_list.setParmValue10(changeDateformat(ip_rep_info.getREP_VALUE_10()));
	CommonUtils.objectSysout(param_list);

	return param_list;
}
	
/*	public String changeDateformat(String dateString){
		String returnDateString=null;
		
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		
		
		String sqlQuery=Reports_SQL_Query_Constants.CHANGE_DATE_FORMAT;
		
		try {
			Connection connection=CommonUtils.getConnectionForServlet();
			resultSet=handler.executeSelectStatement(sqlQuery, connection, new Object[]{dateString,PELConstants.pelDateFormat});
			if(resultSet.next()){
				returnDateString=resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	
		
		return returnDateString;
	}*/
	
	//Method modified as connection for servlet helper method was creating problem thus logic handled in java --Varun [50663]
	public String changeDateformat(String dateString){
		String returnDateString=null;
		
		SimpleDateFormat sdfSource=null;
		Date date=null;
		try {
			sdfSource = new SimpleDateFormat(PELConstants.dbDateFormat);
			date=sdfSource.parse(dateString);
			sdfSource=new SimpleDateFormat(PELConstants.pelDateFormat);
			returnDateString=sdfSource.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return returnDateString;
	}

	public PARAM_LIST PILR_REP044_paramSetup(PARAM_LIST param_list,
			IP_REP_INFO ip_rep_info) {

		param_list.setParmValue01(changeDateformat(ip_rep_info.getREP_VALUE_1()));
		param_list.setParmValue02(changeDateformat(ip_rep_info.getREP_VALUE_2()));
		param_list.setParmValue03(ip_rep_info.getREP_VALUE_3());
		CommonUtils.objectSysout(param_list);

		return param_list;
	}
	
}

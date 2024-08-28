package com.iii.pel.forms.PILM034;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_IL_TAR_DTL_HELPER {
	PILM034Procedures dbProcedures = new PILM034Procedures();
	CommonUtils utils = new CommonUtils();
	public void executeQuery(PILM034_COMPOSITE_ACTION compositeAction, 
			String TH_CODE, String TH_PARAM_TYPE) throws Exception {
		new PM_IL_TAR_DTL_DELEGATE().executeSelectStatement(compositeAction, TH_CODE, TH_PARAM_TYPE);

		List<PM_IL_TAR_DTL> dataList = compositeAction.
		getPM_IL_TAR_DTL_ACTION_BEAN().getDataList_PM_IL_TAR_DTL();
		if(dataList!=null && dataList.size() > 0){
			PM_IL_TAR_DTL PM_IL_TAR_DTL_BEAN = dataList.get(0);
			PM_IL_TAR_DTL_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_TAR_DTL_ACTION_BEAN()
			.setPM_IL_TAR_DTL_BEAN(PM_IL_TAR_DTL_BEAN);
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PM_IL_TAR_HDR pm_il_tar_hdr, BP bp, 
			PM_IL_TAR_DTL_ACTION pm_il_tar_dtl_action, 
			PP_LIST_ITEM_VALUES pp_list_item_values, PM_IL_TAR_DTL_DUMMY pm_il_tar_dtl_dummy) throws Exception{
		int M_COUNT = 0, count = 0;
		String M_COL_NAME1 = null;
		String M_COL_NAME2 = null;
		String M_OUT_DTYPE = null;
		String M_OUT_CAP = null;
		String M_COL_NAME_ONLY1 = null;
		String M_COL_NAME_ONLY2 = null;
		int M_XPOS_LAST_PARA = 0;
		int M_WIDTH_LAST_PARA = 0;
		int M_XPOS_RATE = 0;
		int M_XPOS_LAST_BP = 0;
		int M_WIDTH_LAST_BP = 0;
		int M_XPOS_RATE_BP = 0;
		int M_XPOS_FMDT = 0;
		int M_XPOS_TODT = 0;
		int M_XPOS_BAR = 0;
		int M_XPOS_MINIMUM = 0;
		int M_XPOS_MAXIMUM = 0;
		HashMap<String, String> mType1 = null;
		ArrayList<String> outList = null;
		String fieldName = "TD_PARAM_0";
		Method methodDisabled = null;
		Method methodRequired = null;
		Method methodVisible = null;
		Method method = null;
		Boolean visible;
		Boolean required;
		Boolean disabled;
		UIInput input = null;
		UIOutput output = null;

		//preUpdate(pm_il_tar_dtl_action.getPM_IL_TAR_DTL_BEAN());
		CommonUtils.setGlobalVariable("GLOBAL.M_COUNT", "0");
		try{
			mType1 = new HashMap<String, String>();
			mType1.put("1", new String("" + pm_il_tar_hdr.getTH_PARA_01()));
			mType1.put("2", new String("" + pm_il_tar_hdr.getTH_PARA_02()));
			mType1.put("3", new String("" + pm_il_tar_hdr.getTH_PARA_03()));
			mType1.put("4", new String("" + pm_il_tar_hdr.getTH_PARA_04()));
			mType1.put("5", new String("" + pm_il_tar_hdr.getTH_PARA_05()));
			mType1.put("6", new String("" + pm_il_tar_hdr.getTH_PARA_06()));
			mType1.put("7", new String("" + pm_il_tar_hdr.getTH_PARA_07()));
			mType1.put("8", new String("" + pm_il_tar_hdr.getTH_PARA_08()));
			mType1.put("9", new String("" + pm_il_tar_hdr.getTH_PARA_09()));
			mType1.put("10", new String("" + pm_il_tar_hdr.getTH_PARA_10()));
			for (int M_VAR1 = 1; M_VAR1 <= 9; M_VAR1++) {
				if (!"0".equalsIgnoreCase((String) mType1.get("" + M_VAR1))) {
					count = Integer.parseInt(CommonUtils.getGlobalVariable("GLOBAL.M_COUNT"));
					CommonUtils.setGlobalVariable("GLOBAL.M_COUNT", String.valueOf(count+1));
				} else {
					break;
				}
			}
			M_COUNT = Integer.parseInt(CommonUtils.getGlobalVariable("GLOBAL.M_COUNT"));
			for(int mvar = 1; mvar <= 9; mvar++){
				methodVisible = BP.class.getDeclaredMethod("is" + fieldName + 
						mvar + "_VISIBLE");
				visible = (Boolean) methodVisible.invoke(bp);
				if(visible == true){
					methodVisible = BP.class.getDeclaredMethod("set" + fieldName
							+ mvar + "_VISIBLE", boolean.class);
					methodVisible.invoke(bp, false);
				}
				//Added for reseting the fields
				else{
					methodVisible = BP.class.getDeclaredMethod("set" + fieldName
							+ mvar + "_VISIBLE", boolean.class);
					methodVisible.invoke(bp, true);
				}

				methodRequired = BP.class.getDeclaredMethod("is" + fieldName + 
						mvar + "_REQUIRED");
				required = (Boolean) methodRequired.invoke(bp);
				if(required == true){
					methodRequired = BP.class.getDeclaredMethod("set" + fieldName + 
							mvar + "_REQUIRED", boolean.class);
					methodRequired.invoke(bp, false);
				}
				//Added for reseting the fields
				else{
					methodRequired = BP.class.getDeclaredMethod("set" + fieldName + 
							mvar + "_REQUIRED", boolean.class);
					methodRequired.invoke(bp, true);
				}
			}

			if(bp.isTD_PARAM_10_VISIBLE() == true){
				bp.setTD_PARAM_10_VISIBLE(false);
			}
			//Added for reseting the fields
			else{
				bp.setTD_PARAM_10_VISIBLE(true);
			}

			PM_IL_TAR_DTL pm_il_tar_dtl = pm_il_tar_dtl_action.getPM_IL_TAR_DTL_BEAN();
			for(int mvar = 1; mvar <= M_COUNT; mvar++){
				if(mvar != 10){
					M_COL_NAME1 = "PM_IL_TAR_DTL.TD_PARA_0" + mvar+ "_FM";
					M_COL_NAME2 = "PM_IL_TAR_DTL.TD_PARA_0" + mvar+ "_TO";
					M_COL_NAME_ONLY1 = "TD_PARA_0" + mvar;// + "_FM";//M_COL_NAME1.substring(15);
					M_COL_NAME_ONLY2 = "TD_PARA_0" + mvar;// + "_FM";//M_COL_NAME2.substring(15);
					methodVisible = BP.class.getDeclaredMethod("is" + fieldName + 
							mvar + "_VISIBLE");
					visible = (Boolean) methodVisible.invoke(bp);
					if(visible == false){
						methodVisible = BP.class.getDeclaredMethod("set" + fieldName
								+ mvar + "_VISIBLE", boolean.class);
						methodVisible.invoke(bp, true);
						methodRequired = BP.class.getDeclaredMethod("set" + fieldName
								+ mvar + "_REQUIRED", boolean.class);
						methodRequired.invoke(bp, true);
						methodDisabled = BP.class.getDeclaredMethod("set" + fieldName + 
								mvar + "_DISABLED", boolean.class);
						methodDisabled.invoke(bp, false);
						outList = dbProcedures.GET_DATA_CAP(M_COL_NAME1, pm_il_tar_hdr.getTH_CODE(), 
								pp_list_item_values.getLIV_CODE(), M_OUT_DTYPE,M_OUT_CAP);
						if(outList.size() > 0 && outList.get(0)!= null){
							M_OUT_DTYPE = outList.get(0);
							M_OUT_CAP = outList.get(1);
						method = PM_IL_TAR_DTL_DUMMY.class.getDeclaredMethod(
								"setTH_PARA_DAT_0"+mvar, String.class);
						method.invoke(pm_il_tar_dtl_dummy, M_OUT_DTYPE);
						method = PM_IL_TAR_DTL_ACTION.class.getDeclaredMethod(
								"getCOMP_TD_PARA_0"+mvar+"_FM_LABEL");
						output =  (UIOutput) method.invoke(pm_il_tar_dtl_action);
						output.setValue(M_OUT_CAP+" From");
						
						/*ADDED BY GOPI*/
						String parameterKey =getSerialNo(M_OUT_CAP);
						/*
						 * removed on 2-06-2016 || parameterKey.equals("14") this MOP parameter not to change to LOV other can change to LOV
						 */
						if(parameterKey.equals("48")||parameterKey.equals("14")||parameterKey.equals("50")||parameterKey.equals("4")||parameterKey.equals("11")||parameterKey.equals("25")||parameterKey.equals("94")){
						CommonUtils.setGlobalVariable("KEY",parameterKey);							
						Class noparams[] = {};							
						Method method2 = PM_IL_TAR_DTL_ACTION.class.getDeclaredMethod("PARA_0"+mvar+"_SUGG",noparams);
						method2.invoke(pm_il_tar_dtl_action, null);
						}


						method = PM_IL_TAR_DTL_ACTION.class.getDeclaredMethod(
								"getCOMP_TD_PARA_0"+mvar+"_TO_LABEL");
						output =  (UIOutput) method.invoke(pm_il_tar_dtl_action);
						output.setValue(M_OUT_CAP+" To");
						}
					}
					//Added for reseting the fields
					else{
						methodVisible = BP.class.getDeclaredMethod("set" + fieldName
								+ mvar + "_VISIBLE", boolean.class);
						methodVisible.invoke(bp, false);
						methodRequired = BP.class.getDeclaredMethod("set" + fieldName
								+ mvar + "_REQUIRED", boolean.class);
						methodRequired.invoke(bp, false);
						methodDisabled = BP.class.getDeclaredMethod("set" + fieldName + 
								mvar + "_DISABLED", boolean.class);
						methodDisabled.invoke(bp, true);
					}

				}else{
					if(bp.isTD_PARAM_10_VISIBLE() == false){
						bp.setTD_PARAM_10_VISIBLE(true);
					}
					//Added for reseting the fields
					else{
						bp.setTD_PARAM_10_VISIBLE(false);
					}
					if(bp.isTD_PARAM_10_DISABLED() == true){
						bp.setTD_PARAM_10_DISABLED(false);
					}
					//Added for reseting the fields
					else{
						bp.setTD_PARAM_10_DISABLED(true);
					}
					if(bp.isTD_PARAM_10_REQUIRED() == false){
						bp.setTD_PARAM_10_REQUIRED(true);
					}
					//Added for reseting the fields
					else{
						bp.setTD_PARAM_10_REQUIRED(false);
					}
					outList = dbProcedures.GET_DATA_CAP("PM_IL_TAR_DTL.TD_PARA_10_FM", 
							pm_il_tar_hdr.getTH_CODE(), pp_list_item_values.getLIV_CODE(), 
							M_OUT_DTYPE,M_OUT_CAP);
					M_OUT_DTYPE = outList.get(0);
					M_OUT_CAP = outList.get(1);
					pm_il_tar_dtl_dummy.setTH_PARA_DAT_10(M_OUT_DTYPE);
					pm_il_tar_dtl_action.getCOMP_TD_PARA_10_FM_LABEL().setValue(M_OUT_CAP+" From");
					pm_il_tar_dtl_action.getCOMP_TD_PARA_10_TO_LABEL().setValue(M_OUT_CAP+" To");
				}
			}
			if("V".equals(pm_il_tar_dtl.getTD_PARAM_TYPE())){
				pm_il_tar_dtl_action.getCOMP_TD_MINIMUM().setRendered(true);
				pm_il_tar_dtl_action.getCOMP_TD_MAXIMUM().setRendered(true);
				pm_il_tar_dtl_action.getCOMP_TD_MINIMUM_LABEL().setRendered(true);
				pm_il_tar_dtl_action.getCOMP_TD_MAXIMUM_LABEL().setRendered(true);
				bp.setTD_MIN_MAX_VISIBLE(true);

			}else{
				pm_il_tar_dtl_action.getCOMP_TD_MINIMUM().setRendered(false);
				pm_il_tar_dtl_action.getCOMP_TD_MAXIMUM().setRendered(false);
				pm_il_tar_dtl_action.getCOMP_TD_MINIMUM_LABEL().setRendered(false);
				pm_il_tar_dtl_action.getCOMP_TD_MAXIMUM_LABEL().setRendered(false);
				bp.setTD_MIN_MAX_VISIBLE(false);
			}
			if("CR".equals(pm_il_tar_dtl.getTD_PARAM_TYPE())){
				pm_il_tar_dtl_action.getCOMP_TD_CHAR_RATE().setRendered(true);
				pm_il_tar_dtl_action.getCOMP_TD_CHAR_RATE_LABEL().setRendered(true);
				bp.setTD_CHAR_RATE_VISIBLE(true);

			}else{
				pm_il_tar_dtl_action.getCOMP_TD_CHAR_RATE().setRendered(false);
				pm_il_tar_dtl_action.getCOMP_TD_CHAR_RATE_LABEL().setRendered(false);
				bp.setTD_CHAR_RATE_VISIBLE(false);
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEMTD_PARA_FM(String TD_PARA_FM, String TD_PARA_TO,
			String dummyValue) throws Exception{
		String M_FLD_NAME = null;	
		Date enteredFromDate = null;
		Date enteredToDate = null;
		double chkNo1 = 0;
		double chkNo2 = 0;
		try{
			if(TD_PARA_FM!= null){
				M_FLD_NAME = TD_PARA_FM;
				if(!("".equals(CommonUtils.nvl(TD_PARA_FM, "")))){
					dbProcedures.L_CHK_DATA_TYPE(M_FLD_NAME, dummyValue);
				}

				if("D".equals(dummyValue)){
					enteredFromDate = CommonUtils.stringToDate(TD_PARA_FM);
					if(TD_PARA_TO!= null){
						enteredToDate = CommonUtils.stringToDate(TD_PARA_TO);
						if (enteredFromDate.after(enteredToDate)) {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath, "91010"));
						}
					}
				}
				if("N".equals(dummyValue)){
					chkNo1 = Double.parseDouble(TD_PARA_FM);
					if(chkNo1 < 0){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91026"));
					}
					if(TD_PARA_TO!= null){
						chkNo2 = Double.parseDouble(TD_PARA_TO);
						if(chkNo1 > chkNo2){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91054"));
						}
					}
				}
				if("C".equals(dummyValue)){
					if(TD_PARA_FM.charAt(0) >= 65 && TD_PARA_FM.charAt(0) <=90){
						if(TD_PARA_FM.compareTo(TD_PARA_TO) > 0){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91054"));
						}
					}else{
						if(TD_PARA_TO != null){
							chkNo1 = Double.parseDouble(TD_PARA_FM);
							chkNo2 = Double.parseDouble(TD_PARA_TO);
							if(chkNo1 > chkNo2){
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath, "91054"));
							}
						}
					}
				}
			}
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEMTD_PARA_TO(String TD_PARA_FM, String TD_PARA_TO,
			String dummyValue) throws Exception {
		String M_FLD_NAME = null;	
		Date enteredFromDate = null;
		Date enteredToDate = null;
		double chkNo1 = 0;
		double chkNo2 = 0;
		try{
			if(TD_PARA_TO!= null){
				M_FLD_NAME = TD_PARA_TO;
				if(!("".equals(CommonUtils.nvl(TD_PARA_FM, "")))){
					dbProcedures.L_CHK_DATA_TYPE(M_FLD_NAME, dummyValue);
				}

				if("D".equals(dummyValue)){
					enteredToDate = CommonUtils.stringToDate(TD_PARA_TO);
					if(TD_PARA_FM!= null){
						enteredFromDate = CommonUtils.stringToDate(TD_PARA_FM);
						if (enteredFromDate.after(enteredToDate)) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91001"));
						}
					}
				}
				if("N".equals(dummyValue)){
					chkNo1 = Double.parseDouble(TD_PARA_TO);
					if(chkNo1 < 0){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91026"));
					}
					if(TD_PARA_FM!= null){
						chkNo2 = Double.parseDouble(TD_PARA_FM);
						if(chkNo2 > chkNo1){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "80015"));
						}
					}
				}
				if("C".equals(dummyValue)){
					if(TD_PARA_FM.charAt(0) >= 65 && TD_PARA_FM.charAt(0) <=90){
						if(TD_PARA_FM.compareTo(TD_PARA_TO) > 0){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "80015"));
						}
					}else{
						if(TD_PARA_FM != null){
							chkNo1 = Double.parseDouble(TD_PARA_FM);
							chkNo2 = Double.parseDouble(TD_PARA_TO);
							if(chkNo1 > chkNo2){
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath, "80015"));
							}
						}
					}
				}
			}
		}catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_VALIDATE_ITEM_TD_RATE(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		if(pm_il_tar_dtl.getTD_RATE() < 0){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
		}
	}
	public void WHEN_VALIDATE_ITEM_TD_CHAR_RATE(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		if(pm_il_tar_dtl.getTD_RATE() < 0){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
		}
	}
	public void WHEN_VALIDATE_ITEM_TD_MIN(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String d1 = "1900/01/01";
		String d2 = "2999/12/31";

		Date tempFmDt = CommonUtils.newStringToDate(d1);
		Date tempToDt = CommonUtils.newStringToDate(d2);
		java.util.Date fromDate = null;
		java.util.Date toDate = null;

		fromDate = pm_il_tar_dtl.getTD_EFF_FM_DT();
		toDate = pm_il_tar_dtl.getTD_EFF_TO_DT();
		if(toDate!=null){
			if (fromDate.after(tempFmDt) && fromDate.before(tempToDt)) {
				if (fromDate.after(toDate)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			} 
		}
	}

	public void WHEN_VALIDATE_ITEM_TD_MAX(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String d1 = "1900/01/01";
		String d2 = "2999/12/31";

		Date tempFmDt = CommonUtils.newStringToDate(d1);
		Date tempToDt = CommonUtils.newStringToDate(d2);
		java.util.Date fromDate = null;
		java.util.Date toDate = null;

		fromDate = pm_il_tar_dtl.getTD_EFF_FM_DT();
		toDate = pm_il_tar_dtl.getTD_EFF_TO_DT();
		if(fromDate!=null){
			if (fromDate.after(tempFmDt) && fromDate.before(tempToDt)) {
				if (fromDate.after(toDate)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			} 
		}
	}

	public void WHEN_VALIDATE_ITEM_TD_EFF_FM_DT(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String d1 = "1900/01/01";
		String d2 = "2999/12/31";

		Date tempFmDt = CommonUtils.newStringToDate(d1);
		Date tempToDt = CommonUtils.newStringToDate(d2);
		java.util.Date fromDate = null;
		java.util.Date toDate = null;

		fromDate = pm_il_tar_dtl.getTD_EFF_FM_DT();
		toDate = pm_il_tar_dtl.getTD_EFF_TO_DT();
		if(toDate!=null){
			if (fromDate.after(tempFmDt) && fromDate.before(tempToDt)) {
				if (fromDate.after(toDate)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			} 
		}
	}

	public void WHEN_VALIDATE_ITEM_TD_EFF_TO_DT(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String d1 = "1900/01/01";
		String d2 = "2999/12/31";

		Date tempFmDt = CommonUtils.newStringToDate(d1);
		Date tempToDt = CommonUtils.newStringToDate(d2);
		java.util.Date fromDate = null;
		java.util.Date toDate = null;

		fromDate = pm_il_tar_dtl.getTD_EFF_FM_DT();
		toDate = pm_il_tar_dtl.getTD_EFF_TO_DT();
		if(fromDate!=null){
			if (fromDate.after(tempFmDt) && fromDate.before(tempToDt)) {
				if (fromDate.after(toDate)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			} 
		}
	}

	public void preInsert(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String M_VAR = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet=null;
		String query = null;
		String uid = null;
		Object values[] = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			query=PILM034_QUERYCONSTANTS.PM_IL_TAR_DTL_pre_insert_update;

			values = new Object[68];

			values[0]=pm_il_tar_dtl.getTD_PARAM_TYPE();
			values[1]=pm_il_tar_dtl.getTD_TH_CODE();
			values[2]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[3]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[4]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[5]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[6]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[7]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[8]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[9]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[10]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[11]=pm_il_tar_dtl.getTD_PARA_02_TO();
			values[12]=pm_il_tar_dtl.getTD_PARA_02_TO();
			values[13]=pm_il_tar_dtl.getTD_PARA_02_TO();

			values[14]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[15]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[16]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[17]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[18]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[19]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[20]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[21]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[22]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[23]= pm_il_tar_dtl.getTD_PARA_04_TO();
			values[24]= pm_il_tar_dtl.getTD_PARA_04_TO();
			values[25]= pm_il_tar_dtl.getTD_PARA_04_TO();

			values[26]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[27]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[28]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[29]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[30]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[31]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[32]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[33]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[34]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[35]=pm_il_tar_dtl.getTD_PARA_06_TO();
			values[36]=pm_il_tar_dtl.getTD_PARA_06_TO();
			values[37]=pm_il_tar_dtl.getTD_PARA_06_TO();

			values[38]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[39]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[40]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[41]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[42]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[43]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[44]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[45]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[46]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[47]=pm_il_tar_dtl.getTD_PARA_08_TO();
			values[48]=pm_il_tar_dtl.getTD_PARA_08_TO();
			values[49]=pm_il_tar_dtl.getTD_PARA_08_TO();

			values[50]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[51]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[52]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[53]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[54]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[55]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[56]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[57]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[58]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[59]=pm_il_tar_dtl.getTD_PARA_10_TO();
			values[60]=pm_il_tar_dtl.getTD_PARA_10_TO();
			values[61]=pm_il_tar_dtl.getTD_PARA_10_TO();

			values[62]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[63]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[64]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[65]=pm_il_tar_dtl.getTD_EFF_TO_DT();
			values[66]=pm_il_tar_dtl.getTD_EFF_TO_DT();
			values[67]=pm_il_tar_dtl.getTD_EFF_TO_DT();

			resultSet = handler.executeSelectStatement(query, connection, values);

			if(resultSet.next()){
				M_VAR = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91011")); 
			}
			pm_il_tar_dtl.setTD_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			pm_il_tar_dtl.setTD_CR_DT(utils.getCurrentDate());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			if(resultSet != null){
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	public void preUpdate(PM_IL_TAR_DTL pm_il_tar_dtl) throws Exception{
		String M_VAR = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet=null;
		String C1 = null;
		String uid = null;
		String updateString = " AND ROWID != ?";
		Object values[]=null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1=PILM034_QUERYCONSTANTS.PM_IL_TAR_DTL_pre_insert_update;
			C1 = C1+updateString;

			values = new Object[69];

			values[0]=pm_il_tar_dtl.getTD_PARAM_TYPE();
			values[1]=pm_il_tar_dtl.getTD_TH_CODE();
			values[2]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[3]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[4]=pm_il_tar_dtl.getTD_PARA_01_FM();
			values[5]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[6]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[7]=pm_il_tar_dtl.getTD_PARA_01_TO();
			values[8]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[9]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[10]=pm_il_tar_dtl.getTD_PARA_02_FM();
			values[11]=pm_il_tar_dtl.getTD_PARA_02_TO();
			values[12]=pm_il_tar_dtl.getTD_PARA_02_TO();
			values[13]=pm_il_tar_dtl.getTD_PARA_02_TO();

			values[14]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[15]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[16]= pm_il_tar_dtl.getTD_PARA_03_FM();
			values[17]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[18]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[19]= pm_il_tar_dtl.getTD_PARA_03_TO();
			values[20]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[21]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[22]= pm_il_tar_dtl.getTD_PARA_04_FM();
			values[23]= pm_il_tar_dtl.getTD_PARA_04_TO();
			values[24]= pm_il_tar_dtl.getTD_PARA_04_TO();
			values[25]= pm_il_tar_dtl.getTD_PARA_04_TO();

			values[26]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[27]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[28]=pm_il_tar_dtl.getTD_PARA_05_FM();
			values[29]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[30]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[31]=pm_il_tar_dtl.getTD_PARA_05_TO();
			values[32]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[33]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[34]=pm_il_tar_dtl.getTD_PARA_06_FM();
			values[35]=pm_il_tar_dtl.getTD_PARA_06_TO();
			values[36]=pm_il_tar_dtl.getTD_PARA_06_TO();
			values[37]=pm_il_tar_dtl.getTD_PARA_06_TO();

			values[38]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[39]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[40]=pm_il_tar_dtl.getTD_PARA_07_FM();
			values[41]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[42]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[43]=pm_il_tar_dtl.getTD_PARA_07_TO();
			values[44]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[45]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[46]=pm_il_tar_dtl.getTD_PARA_08_FM();
			values[47]=pm_il_tar_dtl.getTD_PARA_08_TO();
			values[48]=pm_il_tar_dtl.getTD_PARA_08_TO();
			values[49]=pm_il_tar_dtl.getTD_PARA_08_TO();

			values[50]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[51]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[52]=pm_il_tar_dtl.getTD_PARA_09_FM();
			values[53]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[54]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[55]=pm_il_tar_dtl.getTD_PARA_09_TO();
			values[56]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[57]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[58]=pm_il_tar_dtl.getTD_PARA_10_FM();
			values[59]=pm_il_tar_dtl.getTD_PARA_10_TO();
			values[60]=pm_il_tar_dtl.getTD_PARA_10_TO();
			values[61]=pm_il_tar_dtl.getTD_PARA_10_TO();

			values[62]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[63]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[64]=pm_il_tar_dtl.getTD_EFF_FM_DT();
			values[65]=pm_il_tar_dtl.getTD_EFF_TO_DT();
			values[66]=pm_il_tar_dtl.getTD_EFF_TO_DT();
			values[67]=pm_il_tar_dtl.getTD_EFF_TO_DT();
			values[68]=pm_il_tar_dtl.getROWID();

			resultSet = handler.executeSelectStatement(C1, connection, values);

			if(resultSet.next()){
				M_VAR = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91011")); 
			}
			pm_il_tar_dtl.setTD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			pm_il_tar_dtl.setTD_UPD_DT(utils.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		finally{
			if(resultSet != null){
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	
/*added by gopi*/
	
	public String getSerialNo(String id) throws Exception
	{
		System.out.println("************************Welcome to getSerialNo*************************");
		CRUDHandler handler;
		String query=null;
		ResultSet resultSet = null;
		String serial_no="";
		
		
		try{
			handler = new CRUDHandler();
			query="select TP_SRNO from pm_il_tar_param  where TP_CAPTION=?";
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(),new Object[] {id});
					
			
			while(resultSet.next())
			{
			
				serial_no =resultSet.getString("TP_SRNO");
			}
		}catch (Exception e) {
			System.out.println(e);
	
	}
		System.out.println("---------------------RESULT OF SERIAL NO--------------------------->"+serial_no);
		return serial_no;
	
	}
	
}
	
	
	


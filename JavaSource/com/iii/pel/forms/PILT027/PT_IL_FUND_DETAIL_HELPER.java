package com.iii.pel.forms.PILT027;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY_DELEGATE;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_DETAIL_HELPER {

	public void when_validate_tu_cust_code() {

		ResultSet rs = null;
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String C1 = "SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE  FS_CODE ='"
				+ actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
						.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_CODE() + "' ";

		try {
			if (actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
					.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_CODE() != null) {
				rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (rs.next()) {
					String FS_DESC = rs.getString("FS_DESC");
					actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
							.getPT_IL_FUND_DETAIL_BEAN().setUI_M_FUND_DESC(
									FS_DESC);
					actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
							.getCOMP_TOFD_FUND_CODE()
							.setSubmittedValue(FS_DESC);

				} else {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "91423");
					throw new ValidatorException(new FacesMessage(message));
				}
				rs.close();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void when_validate_tofd_fund_perc() {
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		int temp = 0;

		try {
			temp = actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
					.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_PERC();
			if (temp <= 0 || temp > 100) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "71070");
				throw new ValidatorException(new FacesMessage(message));
			}
			/*Added by Janani on 11.10.2018 for KIC 
			issue : Top Up - The fund choice needs to be editable…currently its default and min 10% has to be in liq fund*/
			else
			{
				
				BigDecimal IL_FUND_VAL = (BigDecimal)CommonUtils.getPPSystemParameterValue("IL_FUND_VAL");
				
				

				System.out.println("IL_FUND_VAL              "+IL_FUND_VAL+"     getTOFD_FUND_PERC   "+ actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
						.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_PERC());
				/*Newly added by pidugu raj dt: 12-10-2018 as per vijay suggestion*/
				if(actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
						.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_CODE().equalsIgnoreCase("LIQUID FUND")){
				/*End Newly added by pidugu raj dt: 12-10-2018 as per vijay suggestion*/
				if(actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
						.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_PERC() < IL_FUND_VAL.intValue() ){
				/*if(actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
						.getPT_IL_FUND_DETAIL_BEAN().getTOFD_FUND_PERC() < IL_FUND_VAL )
				{*/
					throw new Exception("Liquid fund Percentage cannot be less than "+IL_FUND_VAL);
				}
				/*Newly added by pidugu raj dt: 12-10-2018 as per vijay suggestion*/
				}
				/*End Newly added by pidugu raj dt: 12-10-2018 as per vijay suggestion*/
				
			}
			/*End*/


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		

	}

	public void setPolDetails(PT_IL_FUND_DETAIL pt_il_fund_detail_bean) {

		ResultSet rs = null;
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String POL_PROD_CODE = null;
		Date POL_START_DATE = null;
		Date POL_EXP_DATE = null;

		String C1 = "SELECT POL_PROD_CODE, POL_START_DT, POL_EXPIRY_DT FROM PT_IL_POLICY WHERE POL_NO ='"
				+ actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
						.getPT_IL_TOP_UP_BEAN().getTU_POL_NO() + "' ";

		try {
			if (actionBean.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_POL_NO() != null) {
				rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (rs.next()) {
					POL_PROD_CODE = rs.getString("POL_PROD_CODE");
					POL_START_DATE = rs.getDate("POL_START_DT");
					POL_EXP_DATE = rs.getDate("POL_EXPIRY_DT");
					actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
							.getPT_IL_FUND_DETAIL_BEAN().setM_POL_START_DT(
									POL_START_DATE);

					actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
							.getPT_IL_FUND_DETAIL_BEAN().setM_POL_EXPIRY_DT(
									POL_EXP_DATE);

					actionBean.getPT_IL_FUND_DETAIL_ACTION_BEAN()
							.getPT_IL_FUND_DETAIL_BEAN().setM_POL_PROD_CODE(
									POL_PROD_CODE);

					/*
					 * CURSOR C2 IS SELECT PROD_FUND_ALLOWED FROM PM_IL_PRODUCT
					 * WHERE PROD_CODE = :DUMMY.M_POL_PROD_CODE;
					 * 
					 * BEGIN IF C1%ISOPEN THEN CLOSE C1; END IF;
					 * 
					 * OPEN C1; FETCH C1 INTO :DUMMY.M_POL_PROD_CODE,
					 * :DUMMY.M_POL_START_DT, :DUMMY.M_POL_EXPIRY_DT; CLOSE C1;
					 * 
					 * IF C2%ISOPEN THEN CLOSE C2; END IF; OPEN C2; FETCH C2
					 * INTO M_PROD_FUND_ALLOWED; CLOSE C2;
					 * 
					 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
					 * COPY('P','CTRL.M_COMM_DEL') ;
					 * COPY('20','SYSTEM.MESSAGE_LEVEL'); POST;
					 * COPY('','CTRL.M_COMM_DEL') ;
					 * COPY('0','SYSTEM.MESSAGE_LEVEL'); END IF;
					 * 
					 * IF :PT_IL_TOPUP_FUND_DTL.TOFD_FUND_CODE IS NOT NULL THEN
					 * IF M_PROD_FUND_ALLOWED = 'M' THEN
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_FUND_PERC',REQUIRED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_FM_DT',REQUIRED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_TO_DT',REQUIRED,PROPERTY_TRUE);
					 * ELSIF M_PROD_FUND_ALLOWED = 'S' THEN
					 * :PT_IL_TOPUP_FUND_DTL.TOFD_FUND_PERC := 100;
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_FUND_PERC',INSERT_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_FUND_PERC',UPDATE_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_FM_DT',INSERT_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_FM_DT',UPDATE_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_TO_DT',INSERT_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_TOPUP_FUND_DTL.TOFD_EFF_TO_DT',UPDATE_ALLOWED,PROPERTY_FALSE);
					 * END IF; END IF; END;
					 */

				} else {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "91423");
					throw new ValidatorException(new FacesMessage(message));
				}
				rs.close();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void preQuery(PT_IL_FUND_DETAIL PT_IL_FUND_DETAIL_BEAN){
		try {
			PT_IL_FUND_DETAIL_BEAN.setTOFD_EFF_FM_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeQuery(PILT027_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_FUND_DETAIL_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PT_IL_FUND_DETAIL> dataList = compositeAction
		.getPT_IL_FUND_DETAIL_ACTION_BEAN()
		.getDataList();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_FUND_DETAIL PT_IL_FUND_DETAIL_BEAN = dataList.get(0);
			PT_IL_FUND_DETAIL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_FUND_DETAIL_ACTION_BEAN()
			.setPT_IL_FUND_DETAIL_BEAN(PT_IL_FUND_DETAIL_BEAN);
		}
	}
}

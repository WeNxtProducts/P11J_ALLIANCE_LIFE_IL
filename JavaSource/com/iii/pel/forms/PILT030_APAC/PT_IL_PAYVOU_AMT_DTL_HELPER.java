package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT027.PILT027_COMPOSITE_ACTION;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_AMT_DTL_HELPER {

	public void executeQuery() {
		String query = "SELECT ROWID,PAD_SYS_ID,PAD_PAH_SYS_ID,PAD_CUST_CODE,PAD_CURR_CODE,"
				+ "PAD_FC_CR_TOT_AMT,PAD_LC_CR_TOT_AMT,PAD_FC_DR_TOT_AMT,PAD_LC_DR_TOT_AMT,"
				+ "PAD_FC_BAL_AMT,PAD_LC_BAL_AMT,PAD_LC_INVESTMENT_AMT,PAD_LC_RISK_AMT "
				+ "FROM PT_IL_PAYVOU_AMT_DTL " + "WHERE PAD_PAH_SYS_ID=? ";
		CRUDHandler handler = new CRUDHandler();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE
				.getPayVouHdrActionInstance();
		PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		PT_IL_PAYVOU_AMT_DTL_ACTION amtDtlAction = PILT030_APAC_ACTION_INSTANCE
				.getPayVouAmtDtlActionInstance();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		Integer M_PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN()
				.getPAH_SYS_ID();
		System.out.println(query);
		System.out.println("M_PAH_SYS_ID***************&&&&&&&&&&&&&&&&"
				+ M_PAH_SYS_ID);
		List<PT_IL_PAYVOU_AMT_DTL> dataList = new ArrayList<PT_IL_PAYVOU_AMT_DTL>();
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { M_PAH_SYS_ID });
			while (rst.next()) {
				PT_IL_PAYVOU_AMT_DTL amtDtlBean = new PT_IL_PAYVOU_AMT_DTL();
				amtDtlBean.setROWID(rst.getString(1));
				amtDtlBean.setPAD_SYS_ID(rst.getInt("PAD_SYS_ID"));
				amtDtlBean.setPAD_PAH_SYS_ID(rst.getInt("PAD_PAH_SYS_ID"));
				amtDtlBean.setPAD_CUST_CODE(rst.getString("PAD_CUST_CODE"));
				amtDtlBean.setPAD_CURR_CODE(rst.getString("PAD_CURR_CODE"));
				amtDtlBean.setPAD_FC_CR_TOT_AMT(rst
						.getDouble("PAD_FC_CR_TOT_AMT"));
				amtDtlBean.setPAD_LC_CR_TOT_AMT(rst
						.getDouble("PAD_LC_CR_TOT_AMT"));
				amtDtlBean.setPAD_FC_DR_TOT_AMT(rst
						.getDouble("PAD_FC_DR_TOT_AMT"));
				amtDtlBean.setPAD_LC_DR_TOT_AMT(rst
						.getDouble("PAD_LC_DR_TOT_AMT"));
				amtDtlBean.setPAD_FC_BAL_AMT(rst.getDouble("PAD_FC_BAL_AMT"));
				amtDtlBean.setPAD_LC_BAL_AMT(rst.getDouble("PAD_LC_BAL_AMT"));
				amtDtlBean.setPAD_LC_INVESTMENT_AMT(rst
						.getDouble("PAD_LC_INVESTMENT_AMT"));
				amtDtlBean.setPAD_LC_RISK_AMT(rst.getDouble("PAD_LC_RISK_AMT"));
				postQuery(amtDtlBean);
				amtDtlAction.setPT_IL_PAYVOU_AMT_DTL_BEAN(amtDtlBean);
				// amtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN().setRowSelected(true);
				dataList.add(amtDtlBean);
			}

			// Logic For Default Population
			PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN = null;
			Iterator<PT_IL_PAYVOU_AMT_DTL> it = dataList.iterator();

			while (it.hasNext()) {
				PT_IL_PAYVOU_AMT_DTL_BEAN = it.next();
				PT_IL_PAYVOU_AMT_DTL_BEAN.setRowSelected(false);
			}
			amtDtlAction.setPT_IL_PAYVOU_AMT_DTL_LIST(dataList);
			if (dataList.size() > 0) {
				amtDtlAction.setPT_IL_PAYVOU_AMT_DTL_BEAN(dataList.get(0));
				amtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN()
						.setRowSelected(true);
			}

			CommonUtils.closeCursor(rst);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void postQuery(PT_IL_PAYVOU_AMT_DTL amtDtlBean) {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		String PAD_CUST_CODE = amtDtlBean.getPAD_CUST_CODE();
		String M_PAD_CUST_DESC = amtDtlBean.getUI_M_PAD_CUST_DESC();
		ArrayList<OracleParameter> outputList = new PILT030_APAC_PROCEDURE()
				.P_VAL_CUST(connection, PAD_CUST_CODE, M_PAD_CUST_DESC, "N",
						"N", null);
		M_PAD_CUST_DESC = outputList.get(0).getValue();
		amtDtlBean.setUI_M_PAD_CUST_DESC(M_PAD_CUST_DESC);
	}

	public void whenNewBlockInstance() {
		executeQuery();
	}

	public void preUpdate(PT_IL_PAYVOU_AMT_DTL amtDtlBean) {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		amtDtlBean.setPAD_CR_UID(ctrlBean.getM_USER_ID());
		amtDtlBean.setPAD_CR_DT(Calendar.getInstance().getTime());
	}

	public void preInsert(PT_IL_PAYVOU_AMT_DTL amtDtlBean) {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		CommonUtils utility=new CommonUtils();
		String mappedBeanName="PILT030_APAC_COMPOSITE_ACTION";
		PILT030_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILT030_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		Integer id=compositeActionBean.getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION().getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();	
		amtDtlBean.setPAD_PAH_SYS_ID(id);
		amtDtlBean.setPAD_SYS_ID(id);
		amtDtlBean.setPAD_CR_UID(ctrlBean.getM_USER_ID());
		amtDtlBean.setPAD_CR_DT(Calendar.getInstance().getTime());
	}

	public int saveRecord(PT_IL_PAYVOU_AMT_DTL amtDtlBean)
			throws ValidatorException {
		int result = 0;
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		try {
			handler.executeInsert(amtDtlBean, connection);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return result;
	}

}

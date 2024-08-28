package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_AGENT_BONUS_RATES_HELPER {

	public void whenCreateRecord() {

		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
		if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("Q")) {
			compAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN()
					.getPM_AGENT_BONUS_RATES_BEAN().setABR_PERIOD("1");
		} else if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("M")) {

			compAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN()
					.getPM_AGENT_BONUS_RATES_BEAN().setABR_PERIOD("5");
		} else if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("Y")) {
			compAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN()
					.getPM_AGENT_BONUS_RATES_BEAN().setABR_PERIOD("6");
		}

	}

	// NOT REQUIRED
	public void newBlockInstance() {

		/*
		 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN :CTRL.M_COMM_DEL := 'P';
		 * POST; :CTRL.M_COMM_DEL := NULL; --:PM_AGENT_BONUS_RATES.M_DUMMY_DESC :=
		 * :PM_AGENT_BONUS_RATES.M_DUMMY_DESC; :PM_AGENT_BONUS_RATES.ABR_UPD_UID :=
		 * :PM_AGENT_BONUS_RATES.ABR_UPD_UID;
		 * 
		 * END IF;
		 */
	}

	// NOT REQUIRED
	public void preBlock() {

		/*
		 * IF FORM_FAILURE THEN :GLOBAL.M_FAILURE := 'TRUE'; END IF;
		 * :CTRL.M_DELETE_MSG_FLAG := 'Y';
		 */

	}

	public void validateABR_YTD_FYC_FM(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		try {
			if (pm_agent_bonus_rates.getABR_YTD_FYC_FM() == null
					|| MigratingFunctions.nvl(pm_agent_bonus_rates
							.getABR_YTD_FYC_FM(), 0) < 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
			} else if (pm_agent_bonus_rates.getABR_YTD_FYC_TO() != null) {

				if (MigratingFunctions.nvl(
						pm_agent_bonus_rates.getABR_YTD_FYC_FM(), 0) > MigratingFunctions
						.nvl(pm_agent_bonus_rates.getABR_YTD_FYC_TO(), 0)) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void validateABR_YTD_FYC_TO(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		if (pm_agent_bonus_rates.getABR_YTD_FYC_TO() == null
				|| MigratingFunctions.nvl(pm_agent_bonus_rates
						.getABR_YTD_FYC_TO(), 0) < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
		} else if (pm_agent_bonus_rates.getABR_YTD_FYC_TO() != null) {

			if (MigratingFunctions.nvl(
					pm_agent_bonus_rates.getABR_YTD_FYC_FM(), 0) > MigratingFunctions
					.nvl(pm_agent_bonus_rates.getABR_YTD_FYC_TO(), 0)) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
			}

		}

	}

	public void validateABR_NO_OF_POL_FM(
			PM_AGENT_BONUS_RATES pm_agent_bonus_rates) throws Exception {

		if (pm_agent_bonus_rates.getABR_NO_OF_POL_FM() == null
				|| MigratingFunctions.nvl(pm_agent_bonus_rates
						.getABR_NO_OF_POL_FM(), 0) < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
		} else if (pm_agent_bonus_rates.getABR_NO_OF_POL_TO() != null) {

			if (MigratingFunctions.nvl(pm_agent_bonus_rates
					.getABR_NO_OF_POL_FM(), 0) > MigratingFunctions.nvl(
					pm_agent_bonus_rates.getABR_NO_OF_POL_TO(), 0)) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
			}

		}

	}

	public void validateABR_NO_OF_POL_TO(
			PM_AGENT_BONUS_RATES pm_agent_bonus_rates) throws Exception {

		if (pm_agent_bonus_rates.getABR_NO_OF_POL_TO() == null
				|| MigratingFunctions.nvl(pm_agent_bonus_rates
						.getABR_NO_OF_POL_TO(), 0) < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
		} else if (pm_agent_bonus_rates.getABR_NO_OF_POL_FM() != null) {

			if (MigratingFunctions.nvl(pm_agent_bonus_rates
					.getABR_NO_OF_POL_FM(), 0) > MigratingFunctions.nvl(
					pm_agent_bonus_rates.getABR_NO_OF_POL_TO(), 0)) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "80015"));
			}

		}

	}

	public void validateABR_PERIOD(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws ValidatorException {

		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
		
		if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("M")) {
			

			if (!pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase("5")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91237"));
			}

		}

		else if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("Q")) {

			if (!pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase("1")
					&& !pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase(
							"2")
					&& !pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase(
							"3")
					&& !pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase(
							"4")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91237"));
			}

		}

		else if (compAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN()
				.getPM_AGENT_BONUS_SETUP_BEAN().getABS_BONUS_FREQ()
				.equalsIgnoreCase("Y")) {

			if (!pm_agent_bonus_rates.getABR_PERIOD().equalsIgnoreCase("6")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91237"));
			}

		}

	}

	public void validateABR_RATE(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		if (pm_agent_bonus_rates.getABR_RATE() == null
				|| MigratingFunctions
						.nvl(pm_agent_bonus_rates.getABR_RATE(), 0) < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "71038"));
		}

	}

	public void validateABR_RATE_PER(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		if (pm_agent_bonus_rates.getABR_RATE_PER() == null
				|| MigratingFunctions.nvl(pm_agent_bonus_rates
						.getABR_RATE_PER(), 0) <= 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91026"));
		}

	}

	public void validateABR_EFF_FM_DT(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		if (pm_agent_bonus_rates.getABR_EFF_FM_DT() != null
				&& pm_agent_bonus_rates.getABR_EFF_TO_DT() != null) {
			if (pm_agent_bonus_rates.getABR_EFF_FM_DT().after(
					pm_agent_bonus_rates.getABR_EFF_TO_DT())) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91001"));
			}
		}
	}

	public void validateABR_EFF_TO_DT(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		if (pm_agent_bonus_rates.getABR_EFF_FM_DT() != null
				&& pm_agent_bonus_rates.getABR_EFF_TO_DT() != null) {
			if (pm_agent_bonus_rates.getABR_EFF_FM_DT().after(
					pm_agent_bonus_rates.getABR_EFF_TO_DT())) {

				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91001"));
			}
		}

	}
	
	public void execute_query(PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PM_AGENT_BONUS_APPL_RANKS applRanksValueBean = compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().getPM_AGENT_BONUS_APPL_RANKS_BEAN();
		PM_AGENT_BONUS_RATES pm_agent_bonus_rates=null;
		ArrayList<PM_AGENT_BONUS_RATES> agentBonusRatesList = null;
		String absCode=applRanksValueBean.getABAR_ABS_CODE();
		String rankCode=applRanksValueBean.getABAR_RANK_CODE();
		/*ABAR_AGENT_NEW parameter added by Ameen on 10-08-2018 for KICLIFEQC-1760174*/
		String agentNewYN = applRanksValueBean.getABAR_AGENT_NEW();
		/*END*/
		try {
			compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
			connection = CommonUtils.getConnection();
			System.out.println("absCode :"+absCode);
			agentBonusRatesList=new ArrayList<PM_AGENT_BONUS_RATES>();
			resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_RATES_FETCH_RECORDS_FOR_ABR_CODE_AND_ABR_RANK_CODE, connection, new Object[]{absCode,rankCode,agentNewYN});
			
			while(resultSet.next()){
				pm_agent_bonus_rates=new PM_AGENT_BONUS_RATES();
				pm_agent_bonus_rates.setROWID(resultSet.getString("ROWID"));
				pm_agent_bonus_rates.setABR_ABS_CODE(resultSet.getString("ABR_ABS_CODE"));
				pm_agent_bonus_rates.setABR_RANK_CODE(resultSet.getString("ABR_RANK_CODE"));
				pm_agent_bonus_rates.setABR_YTD_FYC_FM(resultSet.getDouble("ABR_YTD_FYC_FM"));
				pm_agent_bonus_rates.setABR_YTD_FYC_TO(resultSet.getDouble("ABR_YTD_FYC_TO"));
				pm_agent_bonus_rates.setABR_NO_OF_POL_FM(resultSet.getInt("ABR_NO_OF_POL_FM"));
				pm_agent_bonus_rates.setABR_NO_OF_POL_TO(resultSet.getInt("ABR_NO_OF_POL_TO"));
				pm_agent_bonus_rates.setABR_PERIOD(resultSet.getString("ABR_PERIOD"));
				pm_agent_bonus_rates.setABR_RATE(resultSet.getDouble("ABR_RATE"));
				pm_agent_bonus_rates.setABR_RATE_PER(resultSet.getDouble("ABR_RATE_PER"));
				pm_agent_bonus_rates.setABR_EFF_FM_DT(resultSet.getDate("ABR_EFF_FM_DT"));
				pm_agent_bonus_rates.setABR_EFF_TO_DT(resultSet.getDate("ABR_EFF_TO_DT"));
				pm_agent_bonus_rates.setABR_CR_DT(resultSet.getDate("ABR_CR_DT"));
				pm_agent_bonus_rates.setABR_CR_UID(resultSet.getString("ABR_CR_UID"));
				pm_agent_bonus_rates.setABR_UPD_DT(resultSet.getDate("ABR_UPD_DT"));
				pm_agent_bonus_rates.setABR_UPD_UID(resultSet.getString("ABR_UPD_UID"));
				/*Modified by ganesh on 02-06-2018 as suggested by sivaram*/
				pm_agent_bonus_rates.setABR_APPLIED_ON(resultSet.getString("ABR_APPLIED_ON"));
				pm_agent_bonus_rates.setABR_FORMULA_CODE(resultSet.getString("ABR_FORMULA_CODE"));
				pm_agent_bonus_rates.setABR_MAX_LIMIT(resultSet.getLong("ABR_MAX_LIMIT"));
				pm_agent_bonus_rates.setUI_M_ABR_FORMULA_CODE_DESC(fetchFormulaDesc(resultSet.getString("ABR_FORMULA_CODE")));
				/*END*/
				/*added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
				pm_agent_bonus_rates.setABR_NO_OF_MON_FM(resultSet.getInt("ABR_NO_OF_MON_FM"));
				pm_agent_bonus_rates.setABR_NO_OF_MON_TO(resultSet.getInt("ABR_NO_OF_MON_TO"));
				/*END*/
				
				agentBonusRatesList.add(pm_agent_bonus_rates);
			}
			compositeAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN().setDataListPM_AGENT_BONUS_RATES(agentBonusRatesList);
			if(agentBonusRatesList.size() > 0){
				compositeAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN().setPM_AGENT_BONUS_RATES_BEAN(agentBonusRatesList.get(0));
				compositeAction.getPM_AGENT_BONUS_RATES_ACTION_BEAN().getPM_AGENT_BONUS_RATES_BEAN().setRowSelected(true);
			}
		
		}catch (DBException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void whenCreateRecord(PM_AGENT_BONUS_RATES pm_agent_bonus_rates){
	
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = (PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION");
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN();
		
		String bonusFreq=pm_agent_bonus_setup.getABS_BONUS_FREQ();
		if("Q".equals(bonusFreq)){
			pm_agent_bonus_rates.setABR_PERIOD("1");
		}else if("M".equals(bonusFreq)){
			pm_agent_bonus_rates.setABR_PERIOD("5");
		}else if("Y".equals(bonusFreq)){
			pm_agent_bonus_rates.setABR_PERIOD("6");
		}
		
	}
	public void pre_insert(PM_AGENT_BONUS_RATES pm_agent_bonus_rates,PM_AGENT_BONUS_SETUP PM_AGENT_BONUS_SETUP_BEAN,
			     PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks_bean)throws ValidatorException{
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			String query=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_RATES_PRE_INSERT_QUERY;
			if(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE() != null){
				pm_agent_bonus_rates.setABR_ABS_CODE(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE());
			}
			if(pm_agent_bonus_appl_ranks_bean.getABAR_RANK_CODE() != null){
				pm_agent_bonus_rates.setABR_RANK_CODE(pm_agent_bonus_appl_ranks_bean.getABAR_RANK_CODE());
			}
			String absCOde=pm_agent_bonus_rates.getABR_ABS_CODE();
			String rankCode=pm_agent_bonus_rates.getABR_RANK_CODE();
			String abrPeriod=pm_agent_bonus_rates.getABR_PERIOD();
			Double ytdFycFm=pm_agent_bonus_rates.getABR_YTD_FYC_FM();
			Double ytdFycTo=pm_agent_bonus_rates.getABR_YTD_FYC_TO();
			Integer noOfPolFm=pm_agent_bonus_rates.getABR_NO_OF_POL_FM();
			Integer noOfPolTo=pm_agent_bonus_rates.getABR_NO_OF_POL_TO();
			Date effFrmDate=pm_agent_bonus_rates.getABR_EFF_FM_DT();
			Date effToDate=pm_agent_bonus_rates.getABR_EFF_TO_DT();
			Object[] object={absCOde,rankCode,abrPeriod,ytdFycFm,ytdFycTo,ytdFycFm,
								ytdFycTo,ytdFycFm,ytdFycTo,noOfPolFm,noOfPolTo,noOfPolFm,
								noOfPolTo,noOfPolFm,noOfPolTo,effFrmDate,effToDate,
								effFrmDate,effToDate,effFrmDate,effToDate};
			if(absCOde==null ||rankCode==null){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "19050"));
			}
			/*Commented by ganesh on 13-06-2018, not to validate as suggested by ajoy*/
			/*else {
				resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_RATES_PRE_INSERT_QUERY,
															connection, object);
				if(resultSet.next()){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
				}
			}*/
			/*end*/
		} catch (DBException e) {
			e.printStackTrace();
		} /*catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void pre_update(PM_AGENT_BONUS_RATES pm_agent_bonus_rates,PM_AGENT_BONUS_SETUP PM_AGENT_BONUS_SETUP_BEAN,
		     PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks_bean)throws ValidatorException{
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		try {
			Connection connection=CommonUtils.getConnection();
			if(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE() != null){
				pm_agent_bonus_rates.setABR_ABS_CODE(PM_AGENT_BONUS_SETUP_BEAN.getABS_CODE());
			}
			if(pm_agent_bonus_appl_ranks_bean.getABAR_RANK_CODE() != null){
				pm_agent_bonus_rates.setABR_RANK_CODE(pm_agent_bonus_appl_ranks_bean.getABAR_RANK_CODE());
			}
			String query=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_RATES_PRE_UPDTAE_QUERY;
			String absCOde=pm_agent_bonus_rates.getABR_ABS_CODE();
			String rankCode=pm_agent_bonus_rates.getABR_RANK_CODE();
			String abrPeriod=pm_agent_bonus_rates.getABR_PERIOD();
			Double ytdFycFm=pm_agent_bonus_rates.getABR_YTD_FYC_FM();
			Double ytdFycTo=pm_agent_bonus_rates.getABR_YTD_FYC_TO();
			Integer noOfPolFm=pm_agent_bonus_rates.getABR_NO_OF_POL_FM();
			Integer noOfPolTo=pm_agent_bonus_rates.getABR_NO_OF_POL_TO();
			Date effFrmDate=pm_agent_bonus_rates.getABR_EFF_FM_DT();
			Date effToDate=pm_agent_bonus_rates.getABR_EFF_TO_DT();
			String rowId=pm_agent_bonus_rates.getROWID();
			Object[] object={absCOde,rankCode,abrPeriod,ytdFycFm,ytdFycTo,ytdFycFm,
								ytdFycTo,ytdFycFm,ytdFycTo,noOfPolFm,noOfPolTo,noOfPolFm,
								noOfPolTo,noOfPolFm,noOfPolTo,effFrmDate,effToDate,
								effFrmDate,effToDate,effFrmDate,effToDate,rowId};
			if(absCOde==null ||rankCode==null){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "19050"));
			}
			/*Commented by ganesh on 13-06-2018, not to validate as suggested by ajoy*/
			/*else {
				resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_RATES_PRE_UPDTAE_QUERY,
						connection, object);
				if(resultSet.next()){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91049"));
				}
			}*/
			/*end*/
		} catch (DBException e) {
			e.printStackTrace();
		} /*catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*Modified by ganesh on 02-06-2018 as suggested by sivaram*/
	private String fetchFormulaDesc(String formulaCode) {
		String formulaDesc = "";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		String selectQuery = "SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE = ?";

		try {
			con = CommonUtils.getConnection();
			values = new Object[] { formulaCode };
			rs = handler.executeSelectStatement(selectQuery, con, values);
			if (rs.next()) {
				formulaDesc = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e2) {
				}
			}
		}
		return formulaDesc;
	}
	
}

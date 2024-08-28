package com.iii.pel.forms.PILM037;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class COPY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL;

	private HtmlInputText COMP_UI_M_BSET_PLAN_CODE_SOURCE;

	private HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE;

	private HtmlOutputLabel COMP_UI_M_BSET_YEAR_FROM_LABEL;

	private HtmlInputText COMP_UI_M_BSET_YEAR_FROM;

	private HtmlOutputLabel COMP_UI_M_BSET_YEAR_TO_LABEL;

	private HtmlInputText COMP_UI_M_BSET_YEAR_TO;

	private HtmlOutputLabel COMP_UI_M_BSET_PLAN_CODE_DEST_LABEL;

	private HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DEST;

	private HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DESC_DEST;

	private HtmlCommandButton COMP_UI_M_BUT_BSET_PLAN_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private COPY COPY_BEAN;

	public PILM037_COMPOSITE_ACTION compositeAction;

	ArrayList<com.iii.premia.common.bean.LovBean> list = new ArrayList<com.iii.premia.common.bean.LovBean>();

	public COPY_ACTION() {
		COPY_BEAN = new COPY();
		instaciateAllComponents();
	}

	public HtmlOutputLabel getCOMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL() {
		return COMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSET_PLAN_CODE_SOURCE() {
		return COMP_UI_M_BSET_PLAN_CODE_SOURCE;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL(
			HtmlOutputLabel COMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL) {
		this.COMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL = COMP_UI_M_BSET_PLAN_CODE_SOURCE_LABEL;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_SOURCE(
			HtmlInputText COMP_UI_M_BSET_PLAN_CODE_SOURCE) {
		this.COMP_UI_M_BSET_PLAN_CODE_SOURCE = COMP_UI_M_BSET_PLAN_CODE_SOURCE;
	}

	public HtmlInputText getCOMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE() {
		return COMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE(
			HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE) {
		this.COMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE = COMP_UI_M_BSET_PLAN_CODE_DESC_SOURCE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BSET_YEAR_FROM_LABEL() {
		return COMP_UI_M_BSET_YEAR_FROM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSET_YEAR_FROM() {
		return COMP_UI_M_BSET_YEAR_FROM;
	}

	public void setCOMP_UI_M_BSET_YEAR_FROM_LABEL(
			HtmlOutputLabel COMP_UI_M_BSET_YEAR_FROM_LABEL) {
		this.COMP_UI_M_BSET_YEAR_FROM_LABEL = COMP_UI_M_BSET_YEAR_FROM_LABEL;
	}

	public void setCOMP_UI_M_BSET_YEAR_FROM(
			HtmlInputText COMP_UI_M_BSET_YEAR_FROM) {
		this.COMP_UI_M_BSET_YEAR_FROM = COMP_UI_M_BSET_YEAR_FROM;
	}

	public HtmlOutputLabel getCOMP_UI_M_BSET_YEAR_TO_LABEL() {
		return COMP_UI_M_BSET_YEAR_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSET_YEAR_TO() {
		return COMP_UI_M_BSET_YEAR_TO;
	}

	public void setCOMP_UI_M_BSET_YEAR_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_BSET_YEAR_TO_LABEL) {
		this.COMP_UI_M_BSET_YEAR_TO_LABEL = COMP_UI_M_BSET_YEAR_TO_LABEL;
	}

	public void setCOMP_UI_M_BSET_YEAR_TO(HtmlInputText COMP_UI_M_BSET_YEAR_TO) {
		this.COMP_UI_M_BSET_YEAR_TO = COMP_UI_M_BSET_YEAR_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_BSET_PLAN_CODE_DEST_LABEL() {
		return COMP_UI_M_BSET_PLAN_CODE_DEST_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSET_PLAN_CODE_DEST() {
		return COMP_UI_M_BSET_PLAN_CODE_DEST;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_DEST_LABEL(
			HtmlOutputLabel COMP_UI_M_BSET_PLAN_CODE_DEST_LABEL) {
		this.COMP_UI_M_BSET_PLAN_CODE_DEST_LABEL = COMP_UI_M_BSET_PLAN_CODE_DEST_LABEL;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_DEST(
			HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DEST) {
		this.COMP_UI_M_BSET_PLAN_CODE_DEST = COMP_UI_M_BSET_PLAN_CODE_DEST;
	}

	public HtmlInputText getCOMP_UI_M_BSET_PLAN_CODE_DESC_DEST() {
		return COMP_UI_M_BSET_PLAN_CODE_DESC_DEST;
	}

	public void setCOMP_UI_M_BSET_PLAN_CODE_DESC_DEST(
			HtmlInputText COMP_UI_M_BSET_PLAN_CODE_DESC_DEST) {
		this.COMP_UI_M_BSET_PLAN_CODE_DESC_DEST = COMP_UI_M_BSET_PLAN_CODE_DESC_DEST;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BSET_PLAN_CODE_LOV() {
		return COMP_UI_M_BUT_BSET_PLAN_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_BSET_PLAN_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_BSET_PLAN_CODE_LOV) {
		this.COMP_UI_M_BUT_BSET_PLAN_CODE_LOV = COMP_UI_M_BUT_BSET_PLAN_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public COPY getCOPY_BEAN() {
		return COPY_BEAN;
	}

	public void setCOPY_BEAN(COPY COPY_BEAN) {
		this.COPY_BEAN = COPY_BEAN;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_BSET_PLAN_CODE_DEST(
			Object value) {
		ListItemUtil listItemUtil = null;
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILM037", "DUMMY",
					"M_BSET_PLAN_CODE_DEST", null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareLovCommCode", e.getMessage());
		}
		return list;
	}

	public void validateM_BSET_YEAR_FROM(FacesContext context,
			UIComponent component, Object value) {
		try {
			Integer valueObject = (Integer) value;
			COPY_BEAN.setUI_M_BSET_YEAR_FROM(valueObject);
			M_BSET_YEAR_FROM_Validate(COPY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateM_BSET_YEAR_TO(FacesContext context,
			UIComponent component, Object value) {
		try {
			Integer valueObject = (Integer) value;
			COPY_BEAN.setUI_M_BSET_YEAR_TO(valueObject);
			M_BSET_YEAR_TO_Validate(COPY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateM_BSET_PLAN_CODE_DEST(FacesContext context,
			UIComponent component, Object value) {
		try {
			COPY_BEAN.setUI_M_BSET_PLAN_CODE_DEST((String) value);
			M_BSET_PLAN_CODE_DEST(COPY_BEAN);
			COMP_UI_M_BSET_PLAN_CODE_DESC_DEST.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void M_BSET_PLAN_CODE_DEST(COPY COPY_BEAN) throws Exception {
		String desc = null;
		try {
			if (COPY_BEAN.getUI_M_BSET_PLAN_CODE_DEST() != null) {
				desc = L_VAL_PLAN(COPY_BEAN.getUI_M_BSET_PLAN_CODE_DEST());
				COPY_BEAN.setUI_M_BSET_PLAN_CODE_DESC_DEST(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public String L_VAL_PLAN(String code) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String M_TEMP = null;
		String C1 = "SELECT  COVER_DESC FROM  PM_IL_COVER  WHERE  COVER_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					connection, new Object[] { code });
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71008"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

		return M_TEMP;
	}

	public void M_BSET_YEAR_FROM_Validate(COPY COPY_BEAN) throws Exception {
		try {
			if (COPY_BEAN.getUI_M_BSET_YEAR_FROM() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Year From  > 0" }));
			}
			if (COPY_BEAN.getUI_M_BSET_YEAR_TO() != null) {
				if (COPY_BEAN.getUI_M_BSET_YEAR_FROM() > COPY_BEAN
						.getUI_M_BSET_YEAR_TO()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Year From <= Year To " }));
				}
			}
			if (COPY_BEAN.getUI_M_BSET_YEAR_FROM() < 1990
					|| COPY_BEAN.getUI_M_BSET_YEAR_FROM() > 2999) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Year From >= 1900 And Year To <= 2999" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void M_BSET_YEAR_TO_Validate(COPY COPY_BEAN) throws Exception {
		try {
			if (COPY_BEAN.getUI_M_BSET_YEAR_TO() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Year To  > 0" }));
			}
			if (COPY_BEAN.getUI_M_BSET_YEAR_FROM() != null) {
				if (COPY_BEAN.getUI_M_BSET_YEAR_FROM() > COPY_BEAN
						.getUI_M_BSET_YEAR_TO()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Year From <= Year To " }));
				}
			}
			if (COPY_BEAN.getUI_M_BSET_YEAR_TO() < 1990
					|| COPY_BEAN.getUI_M_BSET_YEAR_TO() > 2999) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Year From >= 1900 And Year To <= 2999" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public PILM037_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM037_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public String OKButton() throws Exception {
		String M_TEMP = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		String desc = null;
		PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN = null;

		String C1 = "SELECT 'X' FROM  PM_IL_BONUS_SETUP "
				+ "  WHERE BSET_YEAR BETWEEN NVL(? ,'1900')   AND   NVL(? ,'2999')";
		String C2 = "SELECT  ROWID, PM_IL_BONUS_SETUP.*  FROM  PM_IL_BONUS_SETUP  WHERE   BSET_PLAN_CODE = ?  ";
		try {
			if (COPY_BEAN.getUI_M_BSET_PLAN_CODE_DEST() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Destination Plan Code","Entered"}));
			}
			if (COPY_BEAN.getUI_M_BSET_PLAN_CODE_DESC_DEST() == null) {
				desc = compositeAction.getCOPY_ACTION_BEAN().L_VAL_PLAN(
						COPY_BEAN.getUI_M_BSET_PLAN_CODE_DEST());
				COPY_BEAN.setUI_M_BSET_PLAN_CODE_DESC_DEST(desc);
			}
			if (COPY_BEAN.getUI_M_BSET_PLAN_CODE_DEST().equals(
					compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN()
							.getPM_IL_BONUS_SETUP_BEAN().getBSET_PLAN_CODE())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91041",
						new Object[]{"Bonus Code for this Plan"}));
			}
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					connection, new Object[] {
							COPY_BEAN.getUI_M_BSET_YEAR_FROM(),
							COPY_BEAN.getUI_M_BSET_YEAR_TO() });
			if(resultSet !=null){
				 compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getTableList().clear();
			}
			
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
				PILM037_L_COPY_BONUS(COPY_BEAN.getUI_M_BSET_YEAR_FROM(),
						COPY_BEAN.getUI_M_BSET_YEAR_TO(), COPY_BEAN
								.getUI_M_BSET_PLAN_CODE_SOURCE(), COPY_BEAN
								.getUI_M_BSET_PLAN_CODE_DEST(), CommonUtils
								.getControlBean().getUSER_ID());
				resultSet2 = new CRUDHandler().executeSelectStatement(C2,
						connection, new Object[] { COPY_BEAN
								.getUI_M_BSET_PLAN_CODE_DEST() });
				
				while (resultSet2.next()) {
				
					PM_IL_BONUS_SETUP_BEAN = new PM_IL_BONUS_SETUP();
					PM_IL_BONUS_SETUP_BEAN.setROWID(resultSet2
							.getString("ROWID"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(resultSet2
							.getString("BSET_PLAN_CODE"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_CODE(resultSet2
							.getString("BSET_BONUS_CODE"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR(resultSet2
							.getInt("BSET_YEAR"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE(resultSet2
							.getDouble("BSET_RATE"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER(resultSet2
							.getDouble("BSET_RATE_PER"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_CR_DT(resultSet2
							.getDate("BSET_CR_DT"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_CR_UID(resultSet2
							.getString("BSET_CR_UID"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_DT(resultSet2
							.getDate("BSET_UPD_DT"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_UID(resultSet2
							.getString("BSET_UPD_UID"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_GIVEN_IN(resultSet2
							.getString("BSET_BONUS_GIVEN_IN"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_APPLIED_ON(resultSet2
							.getString("BSET_APPLIED_ON"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_UNIT_PUR_YN(resultSet2
							.getString("BSET_UNIT_PUR_YN"));
					PM_IL_BONUS_SETUP_BEAN.setBSET_BUY_SELL(resultSet2
							.getString("BSET_BUY_SELL"));
					 new PILM037_Helper().postQuery(PM_IL_BONUS_SETUP_BEAN);
					   compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getTableList().add(PM_IL_BONUS_SETUP_BEAN);
					  
				}


			}

			if(null!=PM_IL_BONUS_SETUP_BEAN){
			/*if (null != PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE()) {
				PM_IL_BONUS_SETUP_BEAN
						.setUI_M_PLAN_CODE_DESC(L_VAL_PLAN(PM_IL_BONUS_SETUP_BEAN
								.getBSET_PLAN_CODE()));
			}
			String desc1 = new PILM037_Helper().L_VAL_BONUS(
					PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE(), "E");
			
			PM_IL_BONUS_SETUP_BEAN.setUI_M_BSET_BONUS_CODE_DESC(desc1);
			*/
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN()
					.setPM_IL_BONUS_SETUP_BEAN(PM_IL_BONUS_SETUP_BEAN );
			
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Copy Completed Successfully");
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getWarningMap()
			.put("COPY",
					"Copy Completed Successfully");
			}

		} catch (DBException e) {
			e.printStackTrace();
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put("UPDATE", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put("UPDATE", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put("UPDATE", e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet2);
		}

		return "bonusSetUp";
	}

	public String okButtonAction() {
		try {
			OKButton();
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getErrorMap()
					.put("UPDATE", e.getMessage());
		}
		return "bonusSetUp";

	}

	/**
	 * 
	 * @param P_M_YEAR_1-IN
	 * @param P_M_YEAR_2-IN
	 * @param P_M_PLAN_CODE_1-IN
	 * @param P_M_PLAN_CODE_2-IN
	 * @param P_M_USER_ID-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> PILM037_L_COPY_BONUS(Object P_M_YEAR_1,
			Object P_M_YEAR_2, Object P_M_PLAN_CODE_1, Object P_M_PLAN_CODE_2,
			Object P_M_USER_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_M_YEAR_1);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_M_YEAR_2);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_M_PLAN_CODE_1);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_M_PLAN_CODE_2);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_M_USER_ID);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PILM037_L_COPY_BONUS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public String returnHead() {
		return "bonusSetUp";
	}

	public void instaciateAllComponents() {
		COMP_UI_M_BSET_YEAR_FROM = new HtmlInputText();
		COMP_UI_M_BSET_YEAR_TO = new HtmlInputText();
		COMP_UI_M_BSET_PLAN_CODE_DESC_DEST = new HtmlInputText();
	}

}

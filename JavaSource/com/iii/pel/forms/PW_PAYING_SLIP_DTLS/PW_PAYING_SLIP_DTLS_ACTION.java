package com.iii.pel.forms.PW_PAYING_SLIP_DTLS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT017.COMPOSITE_ACTION_BEAN;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PW_PAYING_SLIP_DTLS_ACTION extends CommonAction {
	
	public COMPOSITE_ACTION_BEAN compositeAction;
	
	private HtmlOutputLabel COMP_ROWID_LABEL;

	private HtmlInputText COMP_ROWID;

	private HtmlOutputLabel COMP_PSL_SYS_ID_LABEL;

	private HtmlInputText COMP_PSL_SYS_ID;

	private HtmlOutputLabel COMP_PSL_CHK_NO_LABEL;

	private HtmlInputText COMP_PSL_CHK_NO;

	private HtmlOutputLabel COMP_PSL_CHK_DATE_LABEL;

	private HtmlCalendar COMP_PSL_CHK_DATE;

	private HtmlOutputLabel COMP_PSL_CHK_AMT_LABEL;

	private HtmlInputText COMP_PSL_CHK_AMT;

	private HtmlOutputLabel COMP_PSL_BANK_NAME_LABEL;

	private HtmlInputText COMP_PSL_BANK_NAME;

	private HtmlOutputLabel COMP_PSL_BANK_LOC_LABEL;

	private HtmlInputText COMP_PSL_BANK_LOC;

	private HtmlOutputLabel COMP_PSL_CHK_TYPE_LABEL;

	private HtmlInputText COMP_PSL_CHK_TYPE;

	private PW_PAYING_SLIP_DTLS_BEAN PW_PAYING_SLIP_DTLS_BEAN;
	
	
	
	

	public PW_PAYING_SLIP_DTLS_ACTION() {
		PW_PAYING_SLIP_DTLS_BEAN = new PW_PAYING_SLIP_DTLS_BEAN();
		instantiateAllComponent();
	}

	public PW_PAYING_SLIP_DTLS_BEAN getPW_PAYING_SLIP_DTLS_BEAN() {
		return PW_PAYING_SLIP_DTLS_BEAN;
	}

	public void setPW_PAYING_SLIP_DTLS_BEAN(
			PW_PAYING_SLIP_DTLS_BEAN pw_paying_slip_dtls_bean) {
		PW_PAYING_SLIP_DTLS_BEAN = pw_paying_slip_dtls_bean;
	}

	public HtmlOutputLabel getCOMP_ROWID_LABEL() {
		return COMP_ROWID_LABEL;
	}

	public void setCOMP_ROWID_LABEL(HtmlOutputLabel comp_rowid_label) {
		COMP_ROWID_LABEL = comp_rowid_label;
	}

	public HtmlInputText getCOMP_ROWID() {
		return COMP_ROWID;
	}

	public void setCOMP_ROWID(HtmlInputText comp_rowid) {
		COMP_ROWID = comp_rowid;
	}

	public HtmlOutputLabel getCOMP_PSL_SYS_ID_LABEL() {
		return COMP_PSL_SYS_ID_LABEL;
	}

	public void setCOMP_PSL_SYS_ID_LABEL(HtmlOutputLabel comp_psl_sys_id_label) {
		COMP_PSL_SYS_ID_LABEL = comp_psl_sys_id_label;
	}

	public HtmlInputText getCOMP_PSL_SYS_ID() {
		return COMP_PSL_SYS_ID;
	}

	public void setCOMP_PSL_SYS_ID(HtmlInputText comp_psl_sys_id) {
		COMP_PSL_SYS_ID = comp_psl_sys_id;
	}

	public HtmlOutputLabel getCOMP_PSL_CHK_NO_LABEL() {
		return COMP_PSL_CHK_NO_LABEL;
	}

	public void setCOMP_PSL_CHK_NO_LABEL(HtmlOutputLabel comp_psl_chk_no_label) {
		COMP_PSL_CHK_NO_LABEL = comp_psl_chk_no_label;
	}

	public HtmlInputText getCOMP_PSL_CHK_NO() {
		return COMP_PSL_CHK_NO;
	}

	public void setCOMP_PSL_CHK_NO(HtmlInputText comp_psl_chk_no) {
		COMP_PSL_CHK_NO = comp_psl_chk_no;
	}

	public HtmlOutputLabel getCOMP_PSL_CHK_DATE_LABEL() {
		return COMP_PSL_CHK_DATE_LABEL;
	}

	public void setCOMP_PSL_CHK_DATE_LABEL(HtmlOutputLabel comp_psl_chk_date_label) {
		COMP_PSL_CHK_DATE_LABEL = comp_psl_chk_date_label;
	}

	public HtmlCalendar getCOMP_PSL_CHK_DATE() {
		return COMP_PSL_CHK_DATE;
	}

	public void setCOMP_PSL_CHK_DATE(HtmlCalendar comp_psl_chk_date) {
		COMP_PSL_CHK_DATE = comp_psl_chk_date;
	}

	public HtmlOutputLabel getCOMP_PSL_CHK_AMT_LABEL() {
		return COMP_PSL_CHK_AMT_LABEL;
	}

	public void setCOMP_PSL_CHK_AMT_LABEL(HtmlOutputLabel comp_psl_chk_amt_label) {
		COMP_PSL_CHK_AMT_LABEL = comp_psl_chk_amt_label;
	}

	public HtmlInputText getCOMP_PSL_CHK_AMT() {
		return COMP_PSL_CHK_AMT;
	}

	public void setCOMP_PSL_CHK_AMT(HtmlInputText comp_psl_chk_amt) {
		COMP_PSL_CHK_AMT = comp_psl_chk_amt;
	}

	public HtmlOutputLabel getCOMP_PSL_BANK_NAME_LABEL() {
		return COMP_PSL_BANK_NAME_LABEL;
	}

	public void setCOMP_PSL_BANK_NAME_LABEL(HtmlOutputLabel comp_psl_bank_name_label) {
		COMP_PSL_BANK_NAME_LABEL = comp_psl_bank_name_label;
	}

	public HtmlInputText getCOMP_PSL_BANK_NAME() {
		return COMP_PSL_BANK_NAME;
	}

	public void setCOMP_PSL_BANK_NAME(HtmlInputText comp_psl_bank_name) {
		COMP_PSL_BANK_NAME = comp_psl_bank_name;
	}

	public HtmlOutputLabel getCOMP_PSL_BANK_LOC_LABEL() {
		return COMP_PSL_BANK_LOC_LABEL;
	}

	public void setCOMP_PSL_BANK_LOC_LABEL(HtmlOutputLabel comp_psl_bank_loc_label) {
		COMP_PSL_BANK_LOC_LABEL = comp_psl_bank_loc_label;
	}

	public HtmlInputText getCOMP_PSL_BANK_LOC() {
		return COMP_PSL_BANK_LOC;
	}

	public void setCOMP_PSL_BANK_LOC(HtmlInputText comp_psl_bank_loc) {
		COMP_PSL_BANK_LOC = comp_psl_bank_loc;
	}

	public HtmlOutputLabel getCOMP_PSL_CHK_TYPE_LABEL() {
		return COMP_PSL_CHK_TYPE_LABEL;
	}

	public void setCOMP_PSL_CHK_TYPE_LABEL(HtmlOutputLabel comp_psl_chk_type_label) {
		COMP_PSL_CHK_TYPE_LABEL = comp_psl_chk_type_label;
	}

	public HtmlInputText getCOMP_PSL_CHK_TYPE() {
		return COMP_PSL_CHK_TYPE;
	}

	public void setCOMP_PSL_CHK_TYPE(HtmlInputText comp_psl_chk_type) {
		COMP_PSL_CHK_TYPE = comp_psl_chk_type;
	}

	
	
	public void fireFieldValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}
	//[ Added by vinoj as suggested by Akash
	public void chkMICRCode(Long micrCode) throws Exception{
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{micrCode});
			if(resultSet.next()){
				//return x
			}else{
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					"micrCode",
					e.getMessage());
			///throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					"micrCode",
					e.getMessage());
			//throw e;
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					"micrCode",
					e.getMessage());
			//throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	
	String citycode=null;
	String bankcode=null;
	String branchcode=null;
	
	public void  validatePSL_CHK_NO(FacesContext context,UIComponent component,Object value) throws ValidatorException{
		
	try{
		Long value_1 = (Long) value;
		chkMICRCode(value_1);
		getPW_PAYING_SLIP_DTLS_BEAN().setPSL_CHK_NO(value_1 );
		String str= String.valueOf(getPW_PAYING_SLIP_DTLS_BEAN().getPSL_CHK_NO());
		System.out.println("------>"+str.length());
		if(str.length() > 9 || str.length() < 9){
			throw new Exception("Enter valid MICR No.");
		}
		
		
		 citycode=str.substring(0, 3);
		 bankcode=str.substring(3, 6);
		 branchcode=str.substring(6, 9);
		System.out.println(""+citycode);
		System.out.println(""+bankcode);
		System.out.println(""+branchcode);
	
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01(citycode);
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02(bankcode);
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03(branchcode);
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_01_DESC(getCityDesc(citycode));
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(getBankDesc(bankcode));
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_03_DESC(getBranchDesc(branchcode, bankcode, citycode));
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_01_DESC().resetValue();
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_02_DESC().resetValue();
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_03_DESC().resetValue();
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_01().resetValue();
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_02().resetValue();
		compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_03().resetValue();
		
		}
		catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getErrorMap().put(
					"micrCode",
					e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validateAddr01(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01((String)value);
			desc= getCityDesc((String)value);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_01_DESC(desc);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_01_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateAddr02(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02((String)value);
			desc= getBankDesc((String)value);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(desc);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_02_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateAddr03(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03((String)value);
			desc= getBranchDesc((String)value,bankcode,citycode);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_03_DESC(desc);
			compositeAction.getPT_IL_PYMT_DTLS_ACTION().getCOMP_PD_ADDR_03_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String getCityDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_CITY_DESC  FROM PM_BANK_DTLS WHERE PMD_CITY_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	
	public String getBankDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	public String getBranchDesc(String branchCode ,String bank ,String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BRANCH_NAME  FROM PM_BANK_DTLS WHERE PMD_BRANCH_CODE = ?  " +
					" AND PMD_BANK_CODE = ? AND PMD_CITY_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{branchCode,bank,cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	public void preInsert(PW_PAYING_SLIP_DTLS_BEAN workBean) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		String sysParamter = null;
		CRUDHandler handler = new CRUDHandler();
		String query_1="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='IL_LOC_CITY'";
		String query="SELECT P9ILPK_PSL_HDR_SYS_ID.NEXTVAL FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			if(resultSet.next()){
				workBean.setPSL_SYS_ID(resultSet.getLong(1));
			}
			resultSet2 = new CRUDHandler().executeSelectStatement(query_1, connection);
			if(resultSet2.next()){
				sysParamter = resultSet2.getString(1);
				if(sysParamter.equals(compositeAction.getPT_IL_PYMT_DTLS_ACTION()
						.getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_01())){
					workBean.setPSL_CHK_TYPE("L");
				}else{
					workBean.setPSL_CHK_TYPE("O");
				}
			}else{
				workBean.setPSL_CHK_TYPE("O");
			}
			workBean.setPSL_HDR_SYS_ID(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_SYS_ID());
			workBean.setPSL_BANK_LOC(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_01());
			workBean.setPSL_BANK_NAME(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_02());
			workBean.setPSL_CHK_DATE(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_CHQ_DT());
			workBean.setPSL_CHK_AMT(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_FC_AMT());
			workBean.setPSL_BANK_CITY(compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_03());
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void executeQuery() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT ROWID ,PW_PAYING_SLIP_DTLS.* FROM  PW_PAYING_SLIP_DTLS WHERE PSL_HDR_SYS_ID = ? ";
		PW_PAYING_SLIP_DTLS_BEAN workBean = new PW_PAYING_SLIP_DTLS_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection , new Object[]{compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().getPD_SYS_ID()});
			if(resultSet.next()){
				workBean.setROWID(resultSet.getString("rowid"));
				workBean.setPSL_BANK_LOC(resultSet.getString("psl_bank_loc"));
				workBean.setPSL_BANK_NAME(resultSet.getString("psl_bank_name"));
				workBean.setPSL_CHK_DATE(resultSet.getDate("psl_chk_date"));
				workBean.setPSL_CHK_NO(resultSet.getLong("psl_chk_no"));
			}
			compositeAction.getPW_PAYING_SLIP_DTLS_ACTION().setPW_PAYING_SLIP_DTLS_BEAN(workBean);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	

	/**
	 * Instantiates all components in PW_PAYING_SLIP_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_ROWID					 = new HtmlInputText();
		COMP_PSL_SYS_ID					 = new HtmlInputText();
		COMP_PSL_CHK_NO					 = new HtmlInputText();
		COMP_PSL_CHK_AMT				 = new HtmlInputText();
		COMP_PSL_BANK_NAME				 = new HtmlInputText();
		COMP_PSL_BANK_LOC				 = new HtmlInputText();
		COMP_PSL_CHK_TYPE				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_PSL_CHK_DATE				 = new HtmlCalendar();

	}
	

	/**
	 * Resets all components in PW_PAYING_SLIP_DTLS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_ROWID.resetValue();
		COMP_PSL_SYS_ID.resetValue();
		COMP_PSL_CHK_NO.resetValue();
		COMP_PSL_CHK_AMT.resetValue();
		COMP_PSL_BANK_NAME.resetValue();
		COMP_PSL_BANK_LOC.resetValue();
		COMP_PSL_CHK_TYPE.resetValue();

		// Reseting HtmlCalendar
		COMP_PSL_CHK_DATE.resetValue();

	}




	
}
	
	
	
	
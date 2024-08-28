package com.iii.pel.forms.PILQ101;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.pel.utils.PILPK_PILT002;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_PREM_COLL_ACTION extends CommonAction{

	
	///
	private HtmlCommandButton COMP_PC_PROCESS;
	public HtmlCommandButton getCOMP_PC_PROCESS() {
		return COMP_PC_PROCESS;
	}

	public void setCOMP_PC_PROCESS(HtmlCommandButton cOMP_PC_PROCESS) {
		COMP_PC_PROCESS = cOMP_PC_PROCESS;
	}
	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE;

	private HtmlOutputLabel COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_GROSS_PREM_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_GROSS_PREM_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_CHARGE_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_CHARGE_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_CHARGE_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_CHARGE_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_CHARGE_REMDR_SUM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_CHARGE_REMDR_SUM;

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;
	
	List<PT_IL_PREM_COLL> beanList = new ArrayList<PT_IL_PREM_COLL>();
	
	P9ILPK_PREM_COLL p9ilpk_prem_coll=new P9ILPK_PREM_COLL();
	
	private UIDataTable datatable;
	
	private UIDataTable datatable2;
	
	private UIDataTable datatable3;

	public UIDataTable getDatatable2() {
		return datatable2;
	}

	public void setDatatable2(UIDataTable datatable2) {
		this.datatable2 = datatable2;
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public PT_IL_PREM_COLL_ACTION() {
		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
		/*Added by saritha ON 14-Feb-2017 for instantiateAllComponent added ssp call id ZBILQC-1719657 */
		instantiateAllComponent();
		/*End*/
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_CHARGE_LABEL() {
		return COMP_PC_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_CHARGE() {
		return COMP_PC_FC_CHARGE;
	}

	public void setCOMP_PC_FC_CHARGE_LABEL(HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL) {
		this.COMP_PC_FC_CHARGE_LABEL = COMP_PC_FC_CHARGE_LABEL;
	}

	public void setCOMP_PC_FC_CHARGE(HtmlInputText COMP_PC_FC_CHARGE) {
		this.COMP_PC_FC_CHARGE = COMP_PC_FC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_LABEL() {
		return COMP_PC_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE() {
		return COMP_PC_LC_CHARGE;
	}

	public void setCOMP_PC_LC_CHARGE_LABEL(HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL) {
		this.COMP_PC_LC_CHARGE_LABEL = COMP_PC_LC_CHARGE_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE(HtmlInputText COMP_PC_LC_CHARGE) {
		this.COMP_PC_LC_CHARGE = COMP_PC_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL() {
		return COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_GROSS_PREM_SUM() {
		return COMP_UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public void setCOMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL) {
		this.COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL = COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_GROSS_PREM_SUM(HtmlInputText COMP_UI_M_PC_FC_GROSS_PREM_SUM) {
		this.COMP_UI_M_PC_FC_GROSS_PREM_SUM = COMP_UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL() {
		return COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_GROSS_PREM_SUM() {
		return COMP_UI_M_PC_LC_GROSS_PREM_SUM;
	}

	public void setCOMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL) {
		this.COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL = COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_GROSS_PREM_SUM(HtmlInputText COMP_UI_M_PC_LC_GROSS_PREM_SUM) {
		this.COMP_UI_M_PC_LC_GROSS_PREM_SUM = COMP_UI_M_PC_LC_GROSS_PREM_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_CHARGE_SUM_LABEL() {
		return COMP_UI_M_PC_FC_CHARGE_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_CHARGE_SUM() {
		return COMP_UI_M_PC_FC_CHARGE_SUM;
	}

	public void setCOMP_UI_M_PC_FC_CHARGE_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_FC_CHARGE_SUM_LABEL) {
		this.COMP_UI_M_PC_FC_CHARGE_SUM_LABEL = COMP_UI_M_PC_FC_CHARGE_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_CHARGE_SUM(HtmlInputText COMP_UI_M_PC_FC_CHARGE_SUM) {
		this.COMP_UI_M_PC_FC_CHARGE_SUM = COMP_UI_M_PC_FC_CHARGE_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_CHARGE_SUM_LABEL() {
		return COMP_UI_M_PC_LC_CHARGE_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_CHARGE_SUM() {
		return COMP_UI_M_PC_LC_CHARGE_SUM;
	}

	public void setCOMP_UI_M_PC_LC_CHARGE_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_LC_CHARGE_SUM_LABEL) {
		this.COMP_UI_M_PC_LC_CHARGE_SUM_LABEL = COMP_UI_M_PC_LC_CHARGE_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_CHARGE_SUM(HtmlInputText COMP_UI_M_PC_LC_CHARGE_SUM) {
		this.COMP_UI_M_PC_LC_CHARGE_SUM = COMP_UI_M_PC_LC_CHARGE_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL() {
		return COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM() {
		return COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM;
	}

	public void setCOMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL) {
		this.COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL = COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM(HtmlInputText COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM) {
		this.COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM = COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL() {
		return COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM() {
		return COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM;
	}

	public void setCOMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL) {
		this.COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL = COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM(HtmlInputText COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM) {
		this.COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM = COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL() {
		return COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_CHARGE_REMDR_SUM() {
		return COMP_UI_M_PC_FC_CHARGE_REMDR_SUM;
	}

	public void setCOMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL) {
		this.COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL = COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_CHARGE_REMDR_SUM(HtmlInputText COMP_UI_M_PC_FC_CHARGE_REMDR_SUM) {
		this.COMP_UI_M_PC_FC_CHARGE_REMDR_SUM = COMP_UI_M_PC_FC_CHARGE_REMDR_SUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL() {
		return COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_CHARGE_REMDR_SUM() {
		return COMP_UI_M_PC_LC_CHARGE_REMDR_SUM;
	}

	public void setCOMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL(HtmlOutputLabel COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL) {
		this.COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL = COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_CHARGE_REMDR_SUM(HtmlInputText COMP_UI_M_PC_LC_CHARGE_REMDR_SUM) {
		this.COMP_UI_M_PC_LC_CHARGE_REMDR_SUM = COMP_UI_M_PC_LC_CHARGE_REMDR_SUM;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		return "";
	}
     
	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_POLICY_ACTION setupAction = (PT_IL_POLICY_ACTION) sessionMap.get("PILQ101_PT_IL_POLICY_ACTION");
		return setupAction;
	}
	String POL_STATUS =null;
	
/*	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				//PT_IL_POLICY_ACTION_BEAN.onLoad(event);
				
				String POL_STATUS = PT_IL_POLICY_ACTION_BEAN.getPT_IL_POLICY_BEAN().getPOL_STATUS();
                System.out.println("POL_STATUS  :::::::::::"+POL_STATUS);
				}				
			setBlockFlag(false);	
			}
		  catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ONLOAD", e.getMessage());
		}
	}
*/
	public UIDataTable getDatatable3() {
		return datatable3;
	}

	public void setDatatable3(UIDataTable datatable3) {
		this.datatable3 = datatable3;
	}

	public void executeSelectStatement () throws Exception { 
		String selectStatement = null;
		Connection connection=null;
		ResultSet resultSet=null;
		Object[] obj = {};
		Double m_tot=0.0;
		
		ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = null;
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_POLICY_ACTION setupAction = (PT_IL_POLICY_ACTION) sessionMap.get("PILQ101_PT_IL_POLICY_ACTION");
		if(setupAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()!= null){
			/*
			 * modified by Ameen on 27-11-2017 rein end. for paidup policy
			 * selectStatement="SELECT ROWID,PC_SYS_ID,PC_SCHD_PYMT_DT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM, " +
							" PC_FC_CHARGE,PC_LC_CHARGE FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_SCHD_PYMT_DT <=? AND NVL(PC_PAID_FLAG,'N') = 'N'";*/
			selectStatement="SELECT ROWID,PC_SYS_ID,PC_SCHD_PYMT_DT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM, " +
					" PC_FC_CHARGE,PC_LC_CHARGE FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_SCHD_PYMT_DT <=? AND NVL(PC_PAID_FLAG,'N') <> 'A'";
			obj = new Object[]{setupAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),setupAction.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT()};
		}else{
			selectStatement="SELECT ROWID,PC_SYS_ID,PC_SCHD_PYMT_DT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM, " +
			" PC_FC_CHARGE,PC_LC_CHARGE FROM PT_IL_PREM_COLL WHERE PC_PAID_FLAG = 'N' " +
			" AND PC_SCHD_PYMT_DT <= ? ";
			obj = new Object[]{setupAction.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT()};
		}
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection, obj );
			beanList.clear();
			while (resultSet.next()) {
				PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
				PT_IL_PREM_COLL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PREM_COLL_BEAN.setPC_SCHD_PYMT_DT(resultSet
						.getDate("PC_SCHD_PYMT_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_GROSS_PREM(resultSet
						.getDouble("PC_FC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_GROSS_PREM(resultSet
						.getDouble("PC_LC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE(resultSet
						.getDouble("PC_FC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE(resultSet
						.getDouble("PC_LC_CHARGE"));
				/*Added By saranya For The ssp Call ID : FALCONQC-1715539 */
				String PC_FC_GROSS_PREM=PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM().toString();
				String PC_LC_GROSS_PREM=PT_IL_PREM_COLL_BEAN.getPC_LC_GROSS_PREM().toString();
				String PC_FC_CHARG=PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE().toString();
				String PC_LC_CHARG=PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE().toString();
				PT_IL_PREM_COLL_BEAN.setUI_PC_FC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_FC_GROSS_PREM));
				PT_IL_PREM_COLL_BEAN.setUI_PC_LC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_LC_GROSS_PREM));
				PT_IL_PREM_COLL_BEAN.setUI_PC_FC_CHARGE(CommonUtils.Decimal_Convert(PC_FC_CHARG));
				PT_IL_PREM_COLL_BEAN.setUI_PC_LC_CHARGE(CommonUtils.Decimal_Convert(PC_LC_CHARG));
				/*End*/
				PT_IL_PREM_COLL_BEAN.setPC_SYS_ID(resultSet
						.getLong("PC_SYS_ID"));
				listUnpaid = p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(
						setupAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), setupAction
								.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT(),
						null, null, null, null);
				if (listUnpaid.size() > 0) {
					if (listUnpaid.get(2).getValueObject() != null) {
						m_tot = m_tot
								+ (Double) listUnpaid.get(2).getValueObject();
						CommonUtils.ROUND(m_tot, 2);
						setupAction.getPT_IL_POLICY_BEAN().setUI_M_INTEREST(
								m_tot);
						System.out.println("interest  --->"+setupAction.getPT_IL_POLICY_BEAN().getUI_M_INTEREST());
					}
				}
				beanList.add(PT_IL_PREM_COLL_BEAN);
			}
			
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	}

	public List<PT_IL_PREM_COLL> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PT_IL_PREM_COLL> beanList) {
		this.beanList = beanList;
	} 
	
	public String populate_details() throws Exception{
	/*	String POL_STATUS=PT_IL_POLICY_ACTION_BEAN.getPT_IL_POLICY_BEAN().getPOL_STATUS();
		System.out.println("PT_IL_POLICY_BEAN  --------> :::"+POL_STATUS);
		if("L".equalsIgnoreCase(CommonUtils.nvl(POL_STATUS, "N")))
		{*/
		
		PT_IL_POLICY_ACTION setupAction = 
			(PT_IL_POLICY_ACTION) new CommonUtils().getMappedBeanFromSession("PILQ101_PT_IL_POLICY_ACTION");
		
		/*Added by saritha ON 14-Feb-2017 for Re-instatement Quotation(E-mail Trigger) ssp call id ZBILQC-1719657 */
		
		Connection connection = null;
		ResultSet resultSet = null;
		String product_code=null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		String message = "";
		/*End*/
		try {

			String POL_STATUS=setupAction.getPT_IL_POLICY_BEAN().getPOL_STATUS();
			System.out.println("POL_STATUS   ------->"+POL_STATUS);
			/*
			 * modified by Ameen on 27-11-2017 rein end. for paidup policy
			 * if("L".equalsIgnoreCase(POL_STATUS))*/
			
			/*Added by Janani on 25.01.2018 as per Gaurav suggestion*/
			
			/*if("L".equalsIgnoreCase(POL_STATUS) || "P".equalsIgnoreCase(POL_STATUS))*/
			
			if("L".equalsIgnoreCase(POL_STATUS) || "P".equalsIgnoreCase(POL_STATUS) || 
					(setupAction.getPT_IL_POLICY_BEAN().getPOL_ADDL_STATUS().equalsIgnoreCase("pup")) && 
   					setupAction.getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("a"))
					
			
			/*End*/
			{
			CREATE_RENW_REC_TILL_SM_DT(setupAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(), setupAction.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT());
			executeSelectStatement();
			setupAction.POST_QUERY_SUM();
			
			/*Added by saritha ON 14-Feb-2017 for Re-instatement Quotation(E-mail Send) ssp call id ZBILQC-1719657 */
			//added for email trigger  
			CommonUtils commonUtils = new CommonUtils();
			PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");

			System.out.println("pol no::::"+setupAction.getPT_IL_POLICY_BEAN().getPOL_NO());
			String C1 ="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO=?";
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {setupAction.getPT_IL_POLICY_BEAN().getPOL_NO()});
			while(resultSet.next()) {
				product_code =resultSet.getString("POL_PROD_CODE");
				System.out.println("product code::::"+product_code);
			}

			long pol_sys_id = setupAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();

			String P_CUST_TYPE=" ";
			/*if(getMAIL_SEND_TO().equalsIgnoreCase("CUSTOMER")){
					P_CUST_TYPE="C";
		    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BROKER")){
		    		P_CUST_TYPE="A";
		    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BOTH")){
		    		P_CUST_TYPE="B";;
		    	}*/

			/*Commented by ganesh on 16-08-2017 for ZBILQC-1719657, as suggested by Mr.Vikram no need to handle mail on process button 
			 * String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"REI",String.valueOf(pol_sys_id),"C","");
			message = message + emailStatusMessage;*/

			/*End*/
			}
			
			else
			{
//				//throw new ValidatorException("It is not a Lapsed Policy");
//				throw new ValidatorException(new FacesMessage("It is not a Lapsed Policy"));
				getErrorMap().put("current", "It is not a Lapsed Policy");
			}
		} catch (Exception e) {
			e.printStackTrace();
			setupAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			setupAction.getErrorMap().put("POPULATE_DETAILS", e.getMessage());
		}
		
		
		return null;
		
	}
	
	
	
	public ArrayList<OracleParameter> CREATE_RENW_REC_TILL_SM_DT(Object P_POL_SYS_ID,Object P_RENW_DATE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
		    parameterList.add(param1);
		    OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_RENW_DATE);
		    parameterList.add(param2);
			
			 OracleProcedureHandler procHandler = new OracleProcedureHandler();
		     outputList = procHandler.executeProc(parameterList, connection,
		            "P9ILPK_PROCESS.CREATE_RENW_REC_TILL_SM_DT");
		}catch(Exception e){
			ErrorHelpUtil.getErrorForProcedure(connection);
		    throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}
	/*Added By saranya For The ssp Call ID : FALCONQC-1715539 */
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=3;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
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
	/*end*/
	
	/*Added by saritha ON 14-Feb-2017 for instantiateAllComponent added ssp call id ZBILQC-1719657 */
	
	public void instantiateAllComponent() {
	
	COMP_PC_SCHD_PYMT_DT_LABEL=new HtmlOutputLabel();
	COMP_PC_SCHD_PYMT_DT= new HtmlCalendar();
	COMP_PC_FC_GROSS_PREM_LABEL =new HtmlOutputLabel();
	COMP_PC_FC_GROSS_PREM =new HtmlInputText();
	COMP_PC_LC_GROSS_PREM_LABEL=new HtmlOutputLabel();
	COMP_PC_LC_GROSS_PREM = new HtmlInputText();
	COMP_PC_FC_CHARGE_LABEL=new HtmlOutputLabel();
	COMP_PC_FC_CHARGE=new HtmlInputText();
	COMP_PC_LC_CHARGE_LABEL =new HtmlOutputLabel();
	COMP_PC_LC_CHARGE =new HtmlInputText();
	COMP_UI_M_PC_FC_GROSS_PREM_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_FC_GROSS_PREM_SUM =new HtmlInputText();
	COMP_UI_M_PC_LC_GROSS_PREM_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_LC_GROSS_PREM_SUM =new HtmlInputText();
	COMP_UI_M_PC_FC_CHARGE_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_FC_CHARGE_SUM =new HtmlInputText();
	COMP_UI_M_PC_LC_CHARGE_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_LC_CHARGE_SUM=new HtmlInputText();
	COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_FC_GROSS_PREM_REMDR_SUM=new HtmlInputText();
	COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_LC_GROSS_PREM_REMDR_SUM=new HtmlInputText();
	COMP_UI_M_PC_FC_CHARGE_REMDR_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_FC_CHARGE_REMDR_SUM=new HtmlInputText();
	COMP_UI_M_PC_LC_CHARGE_REMDR_SUM_LABEL=new HtmlOutputLabel();
	COMP_UI_M_PC_LC_CHARGE_REMDR_SUM=new HtmlInputText();

	}
	
	/*End*/
}

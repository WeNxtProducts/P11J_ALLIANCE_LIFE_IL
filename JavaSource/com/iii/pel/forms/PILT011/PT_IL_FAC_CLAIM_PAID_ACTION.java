package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_PAID_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_POL_NO_2_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_2;

	private HtmlOutputLabel COMP_UI_M_CLM_NO_2_LABEL;

	private HtmlInputText COMP_UI_M_CLM_NO_2;

	private HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_2_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC_2;

	private HtmlOutputLabel COMP_FCP_CP_PAID_DT_LABEL;

	private HtmlCalendar COMP_FCP_CP_PAID_DT;

	private HtmlOutputLabel COMP_UI_M_CUST_NAME_2_LABEL;

	private HtmlInputText COMP_UI_M_CUST_NAME_2;

	private HtmlOutputLabel COMP_UI_M_CURR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_CURR_DESC_2_LABEL;

	private HtmlInputText COMP_UI_M_CURR_DESC_2;

	private HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_ESTIMATE;

	private PT_IL_FAC_CLAIM_PAID PT_IL_FAC_CLAIM_PAID_BEAN;
	//private PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN;
	
	

	private CRUDHandler handler = null;
	private Connection connection = null;
	private ResultSet resultSet = null;
	private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private Long M_FCE_SYS_ID;
	private String DEFAULT_WHERE;
	private String query = "";
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	
	public PILT011_COMPOSITE_ACTION compositeAction;
	
	
	public PT_IL_FAC_CLAIM_PAID_ACTION() {
		PT_IL_FAC_CLAIM_PAID_BEAN = new PT_IL_FAC_CLAIM_PAID();
		handler = new CRUDHandler();
	}
	
	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public Long getM_FCE_SYS_ID() {
		return M_FCE_SYS_ID;
	}

	public void setM_FCE_SYS_ID(Long m_fce_sys_id) {
		M_FCE_SYS_ID = m_fce_sys_id;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_2_LABEL() {
		return COMP_UI_M_POL_NO_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_2() {
		return COMP_UI_M_POL_NO_2;
	}

	public void setCOMP_UI_M_POL_NO_2_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_2_LABEL) {
		this.COMP_UI_M_POL_NO_2_LABEL = COMP_UI_M_POL_NO_2_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_2(HtmlInputText COMP_UI_M_POL_NO_2) {
		this.COMP_UI_M_POL_NO_2 = COMP_UI_M_POL_NO_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLM_NO_2_LABEL() {
		return COMP_UI_M_CLM_NO_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLM_NO_2() {
		return COMP_UI_M_CLM_NO_2;
	}

	public void setCOMP_UI_M_CLM_NO_2_LABEL(HtmlOutputLabel COMP_UI_M_CLM_NO_2_LABEL) {
		this.COMP_UI_M_CLM_NO_2_LABEL = COMP_UI_M_CLM_NO_2_LABEL;
	}

	public void setCOMP_UI_M_CLM_NO_2(HtmlInputText COMP_UI_M_CLM_NO_2) {
		this.COMP_UI_M_CLM_NO_2 = COMP_UI_M_CLM_NO_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_CODE_LABEL() {
		return COMP_UI_M_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_CODE() {
		return COMP_UI_M_COVER_CODE;
	}

	public void setCOMP_UI_M_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL) {
		this.COMP_UI_M_COVER_CODE_LABEL = COMP_UI_M_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_COVER_CODE(HtmlInputText COMP_UI_M_COVER_CODE) {
		this.COMP_UI_M_COVER_CODE = COMP_UI_M_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_2_LABEL() {
		return COMP_UI_M_COVER_DESC_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC_2() {
		return COMP_UI_M_COVER_DESC_2;
	}

	public void setCOMP_UI_M_COVER_DESC_2_LABEL(HtmlOutputLabel COMP_UI_M_COVER_DESC_2_LABEL) {
		this.COMP_UI_M_COVER_DESC_2_LABEL = COMP_UI_M_COVER_DESC_2_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC_2(HtmlInputText COMP_UI_M_COVER_DESC_2) {
		this.COMP_UI_M_COVER_DESC_2 = COMP_UI_M_COVER_DESC_2;
	}

	public HtmlOutputLabel getCOMP_FCP_CP_PAID_DT_LABEL() {
		return COMP_FCP_CP_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FCP_CP_PAID_DT() {
		return COMP_FCP_CP_PAID_DT;
	}

	public void setCOMP_FCP_CP_PAID_DT_LABEL(HtmlOutputLabel COMP_FCP_CP_PAID_DT_LABEL) {
		this.COMP_FCP_CP_PAID_DT_LABEL = COMP_FCP_CP_PAID_DT_LABEL;
	}

	public void setCOMP_FCP_CP_PAID_DT(HtmlCalendar COMP_FCP_CP_PAID_DT) {
		this.COMP_FCP_CP_PAID_DT = COMP_FCP_CP_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_2_LABEL() {
		return COMP_UI_M_CUST_NAME_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME_2() {
		return COMP_UI_M_CUST_NAME_2;
	}

	public void setCOMP_UI_M_CUST_NAME_2_LABEL(HtmlOutputLabel COMP_UI_M_CUST_NAME_2_LABEL) {
		this.COMP_UI_M_CUST_NAME_2_LABEL = COMP_UI_M_CUST_NAME_2_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME_2(HtmlInputText COMP_UI_M_CUST_NAME_2) {
		this.COMP_UI_M_CUST_NAME_2 = COMP_UI_M_CUST_NAME_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_CODE_LABEL() {
		return COMP_UI_M_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_CODE() {
		return COMP_UI_M_CURR_CODE;
	}

	public void setCOMP_UI_M_CURR_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CURR_CODE_LABEL) {
		this.COMP_UI_M_CURR_CODE_LABEL = COMP_UI_M_CURR_CODE_LABEL;
	}

	public void setCOMP_UI_M_CURR_CODE(HtmlInputText COMP_UI_M_CURR_CODE) {
		this.COMP_UI_M_CURR_CODE = COMP_UI_M_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_DESC_2_LABEL() {
		return COMP_UI_M_CURR_DESC_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_DESC_2() {
		return COMP_UI_M_CURR_DESC_2;
	}

	public void setCOMP_UI_M_CURR_DESC_2_LABEL(HtmlOutputLabel COMP_UI_M_CURR_DESC_2_LABEL) {
		this.COMP_UI_M_CURR_DESC_2_LABEL = COMP_UI_M_CURR_DESC_2_LABEL;
	}

	public void setCOMP_UI_M_CURR_DESC_2(HtmlInputText COMP_UI_M_CURR_DESC_2) {
		this.COMP_UI_M_CURR_DESC_2 = COMP_UI_M_CURR_DESC_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SETTLEMENT() {
		return COMP_UI_M_BUT_SETTLEMENT;
	}

	public void setCOMP_UI_M_BUT_SETTLEMENT(HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT) {
		this.COMP_UI_M_BUT_SETTLEMENT = COMP_UI_M_BUT_SETTLEMENT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_ESTIMATE() {
		return COMP_UI_M_BUT_FAC_ESTIMATE;
	}

	public void setCOMP_UI_M_BUT_FAC_ESTIMATE(HtmlCommandButton COMP_UI_M_BUT_FAC_ESTIMATE) {
		this.COMP_UI_M_BUT_FAC_ESTIMATE = COMP_UI_M_BUT_FAC_ESTIMATE;
	}

	public PT_IL_FAC_CLAIM_PAID getPT_IL_FAC_CLAIM_PAID_BEAN() {
		return PT_IL_FAC_CLAIM_PAID_BEAN;
	}

	public void setPT_IL_FAC_CLAIM_PAID_BEAN(PT_IL_FAC_CLAIM_PAID PT_IL_FAC_CLAIM_PAID_BEAN) {
		this.PT_IL_FAC_CLAIM_PAID_BEAN = PT_IL_FAC_CLAIM_PAID_BEAN;
	}
	
	public void PT_IL_FAC_CLAIM_PAID_PRE_INSERT(){
		PT_IL_FAC_CLAIM_PAID_BEAN.setFCP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PT_IL_FAC_CLAIM_PAID_BEAN.setFCP_CR_DT(getSystemDate());
	}
	
	public void PT_IL_FAC_CLAIM_PAID_POST_QUERY(){
		PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_EST_BEAN();
		PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_POL_NO_2(PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_POL_NO_1());
		PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_CLM_NO_2(PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_CLM_NO_1());
		connection = getConnection(); 
		if (CommonUtils.getGlobalVariable("CALLING_FORM") != null) {
			if(CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT006_APAC") || CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT012")){
				setM_FCE_SYS_ID(PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID());
//			M_FCE_SYS_ID := :PT_IL_FAC_CLAIM_EST.FCE_SYS_ID;
			}else if(CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT007")){
				//setM_FCE_SYS_ID(PT_IL_FAC_CLAIM_PAID_BEAN.getFCP_FCE_SYS_ID());
				setM_FCE_SYS_ID(((Long) CommonUtils.getGlobalObject("M_FCE_SYS_ID")));
			}
		}
		
		String C1 = "SELECT PT_IL_FAC_CLAIM_EST.* FROM PT_IL_FAC_CLAIM_EST WHERE FCE_SYS_ID = ? " ;
		try {
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID()});
			if(resultSet != null){
				while(resultSet.next()){
					PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_COVER_CODE(resultSet.getString("FCE_CCD_COVER_CODE"));
					PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_CURR_CODE(resultSet.getString("FCE_CLAIM_CURR_CODE"));
					PT_IL_FAC_CLAIM_PAID_BEAN.setM_COVER_CODE(resultSet.getString("FCE_CCD_COVER_CODE"));
					PT_IL_FAC_CLAIM_PAID_BEAN.setM_CURR_CODE(resultSet.getString("FCE_CLAIM_CURR_CODE"));
				}
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P_VAL_COVER();
		P_VAL_CURR();
	    String C2="select FCP_SYS_ID,FCP_CP_PAID_DT,FCP_FCE_SYS_ID from PT_IL_FAC_CLAIM_PAID where FCP_FCE_SYS_ID = ? ";
		try {
			resultSet = handler.executeSelectStatement(C2, connection,new Object[]{PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID()});
			if(resultSet != null){
				while(resultSet.next()){
					PT_IL_FAC_CLAIM_PAID_BEAN.setFCP_SYS_ID(resultSet.getString(1));
					PT_IL_FAC_CLAIM_PAID_BEAN.setFCP_CP_PAID_DT(resultSet.getDate("FCP_CP_PAID_DT"));
					PT_IL_FAC_CLAIM_PAID_BEAN.setFCP_FCE_SYS_ID(resultSet.getLong(3));
				}
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void P_VAL_COVER(){
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",PT_IL_FAC_CLAIM_PAID_BEAN.getM_COVER_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in3","STRING","IN",null);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","N");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN",CommonUtils.getControlBean().getM_LANG_CODE());		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
		List outParamList;
		try {
			outParamList = procHandler.execute(paramList, connection, "P_VAL_COVER");
			OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
			PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_COVER_DESC_2(planDescPar.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void P_VAL_CURR(){
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",PT_IL_FAC_CLAIM_PAID_BEAN.getM_CURR_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in3","STRING","IN","N");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",CommonUtils.getControlBean().getM_LANG_CODE());		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
		List outParamList;
		try {
			outParamList = procHandler.execute(paramList, connection, "P_VAL_CURR");
			OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
			PT_IL_FAC_CLAIM_PAID_BEAN.setUI_M_CURR_DESC_2(planDescPar.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*public PT_IL_FAC_CLAIM_EST getPT_IL_FAC_CLAIM_EST_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_EST_ACTION claimESTAction = (PT_IL_FAC_CLAIM_EST_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_EST_ACTION");
		PT_IL_FAC_CLAIM_EST claimEstBean= claimESTAction.getPT_IL_FAC_CLAIM_EST_BEAN();
		return claimEstBean;
	}*/
	
	/*public void PT_IL_FAC_CLAIM_PAID_PRE_QUERY(){
		PT_IL_FAC_CLAIM_EST claimEstBean =getPT_IL_FAC_CLAIM_EST_BEAN();
		if (CommonUtils.getGlobalVariable("CALLING_FORM") != null) {
		if(CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT006_APAC") || CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT012")){
			setDEFAULT_WHERE("FCP_FCE_SYS_ID = "+claimEstBean.getFCE_SYS_ID()); 
		}
		}
	}*/
	public void PT_IL_FAC_CLAIM_PAID_PRE_DELETE(){
		connection = getConnection();
		query = "DELETE FROM PT_IL_FAC_CLAIM_PART_CUST_PAID WHERE FCPCP_FCP_SYS_ID = '"+PT_IL_FAC_CLAIM_PAID_BEAN.getFCP_SYS_ID()+"'";
		try {
			handler.executeDeleteStatement(query, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PT_IL_FAC_CLAIM_PAID_ON_POPULATE_DETAILS(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            String RECSTAT=:SYSTEM.RECORD_STATUS;
            String STARTITM=:SYSTEM.CURSOR_ITEM;
            RELATION REL_ID;
            if((RECSTAT.equals(""+"NEW") || RECSTAT.equals(""+"INSERT")))
            {
            }
            if(((:PT_IL_FAC_CLAIM_PAID.FCP_SYS_ID != null)))
            {
                REL_ID=FIND_RELATION.FIND_RELATION("PT_IL_FAC_CLAIM_PAID.PT_IL_FAC_CLAIM_PAID_PART_CUST");
                QUERY_MASTER_DETAILS.QUERY_MASTER_DETAILS(REL_ID,"PT_IL_FAC_CLAIM_PART_CUST_PAID");
            }
            if((:SYSTEM.CURSOR_ITEM!=STARTITM))
            {
                GO_ITEM.GO_ITEM(STARTITM);
                CHECK_PACKAGE_FAILURE.CHECK_PACKAGE_FAILURE();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/	
	}

	public String UI_M_BUT_FAC_ESTIMATE_BUTTON_PRESSED(){
		setBlockFlag(true);
		return "fac_estimate";
	}
	 
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public Date getSystemDate(){
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysDate;
	}
	
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			try {
				//executeQuery();
				//if(PT_IL_FAC_CLAIM_PAID_BEAN.getROWID() != null){
					PT_IL_FAC_CLAIM_PAID_POST_QUERY();
					executeQuery();
					compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().PT_IL_FAC_CLAIM_PART_CUST_PAID_POST_QUERY();
	
					if (compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().
					          getClaimPaidCustList().size() > 0) {
						PT_IL_FAC_CLAIM_PART_CUST_PAID PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().
				          getClaimPaidCustList()
								.get(0);
						PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setRowSelected(true);
						compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().setPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN(PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN);
						compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().resetAllComponent();
						
					}
				//}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
			setBlockFlag(false);
		}
		
	}
	
	
	public void executeQuery() throws Exception {
		String selectQuery = "SELECT FCPCP_SYS_ID,PT_IL_FAC_CLAIM_PART_CUST_PAID.* " +
				"FROM PT_IL_FAC_CLAIM_PART_CUST_PAID WHERE FCPCP_FCP_SYS_ID = ? AND FCPCP_FCPCE_SYS_ID=?" ;
		PT_IL_FAC_CLAIM_PART_CUST_PAID PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().getPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
	//	PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_EST_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery,
						connection, new Object[]{PT_IL_FAC_CLAIM_PAID_BEAN.getFCP_SYS_ID(),compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN().getFCPCE_SYS_ID()});
			if(compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().
	          getClaimPaidCustList().size() > 0){
				compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().
		          getClaimPaidCustList().clear();
			}
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = new PT_IL_FAC_CLAIM_PART_CUST_PAID();
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_SYS_ID(resultSet.getLong("FCPCP_SYS_ID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_FCP_SYS_ID(resultSet.getLong("FCPCP_FCP_SYS_ID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_FCPCE_SYS_ID(resultSet.getLong("FCPCP_FCPCE_SYS_ID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CUST_CODE(resultSet.getString("FCPCP_CUST_CODE"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_FC_CLM_PAID(resultSet.getDouble("FCPCP_FC_CLM_PAID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_LC_CLM_PAID(resultSet.getDouble("FCPCP_LC_CLM_PAID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_RETRO_FC_CLM_PAID(resultSet.getDouble("FCPCP_RETRO_FC_CLM_PAID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_RETRO_LC_CLM_PAID(resultSet.getDouble("FCPCP_RETRO_LC_CLM_PAID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CP_REF_SYS_ID(resultSet.getLong("FCPCP_CP_REF_SYS_ID"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CR_DT(resultSet.getDate("FCPCP_CR_DT"));
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CR_UID(resultSet.getString("FCPCP_CR_UID"));
				//compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().PT_IL_FAC_CLAIM_PART_CUST_PAID_POST_QUERY();
				compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION_BEAN().
				          getClaimPaidCustList().add(PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}
			catch (Exception e) {
			}
		}
	}

	public PILT011_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT011_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	

}

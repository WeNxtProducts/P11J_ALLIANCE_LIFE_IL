package com.iii.pel.forms.PT051_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PT_AGENT_BUDGET_RANK_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_ABGTR_RANK_CODE_LABEL;

	private HtmlInputText COMP_ABGTR_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ABGTR_RANK_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ABGTR_RANK_NAME;

	private HtmlOutputLabel COMP_ABGTR_SHARE_PERC_LABEL;

	private HtmlInputText COMP_ABGTR_SHARE_PERC;

	private HtmlCommandButton COMP_UI_M_BUT_ALLOC;
	
	private HtmlCommandButton COMP_UI_M_BUT_ADD;
	
	private HtmlCommandButton COMP_UI_M_BUT_DELETE;
	
	private HtmlCommandButton COMP_UI_M_BUT_POST;

	private PT_AGENT_BUDGET_RANK PT_AGENT_BUDGET_RANK_BEAN;

	private UIData rankDataTable;
	private ArrayList<PT_AGENT_BUDGET_RANK> rankList=new ArrayList<PT_AGENT_BUDGET_RANK>();
	private int prevRowIndex;
	private int currPage;
	private int lastUpdatedRowIndex;
	private int recordsPerPage = 5;
	
	public PT051_A_COMPOSITE_ACTION compositeAction;


	public PT_AGENT_BUDGET_RANK_ACTION() {
		PT_AGENT_BUDGET_RANK_BEAN = new PT_AGENT_BUDGET_RANK();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_ABGTR_RANK_CODE_LABEL() {
		return COMP_ABGTR_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABGTR_RANK_CODE() {
		return COMP_ABGTR_RANK_CODE;
	}

	public void setCOMP_ABGTR_RANK_CODE_LABEL(HtmlOutputLabel COMP_ABGTR_RANK_CODE_LABEL) {
		this.COMP_ABGTR_RANK_CODE_LABEL = COMP_ABGTR_RANK_CODE_LABEL;
	}

	public void setCOMP_ABGTR_RANK_CODE(HtmlInputText COMP_ABGTR_RANK_CODE) {
		this.COMP_ABGTR_RANK_CODE = COMP_ABGTR_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGTR_RANK_NAME_LABEL() {
		return COMP_UI_M_ABGTR_RANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABGTR_RANK_NAME() {
		return COMP_UI_M_ABGTR_RANK_NAME;
	}

	public void setCOMP_UI_M_ABGTR_RANK_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ABGTR_RANK_NAME_LABEL) {
		this.COMP_UI_M_ABGTR_RANK_NAME_LABEL = COMP_UI_M_ABGTR_RANK_NAME_LABEL;
	}

	public void setCOMP_UI_M_ABGTR_RANK_NAME(HtmlInputText COMP_UI_M_ABGTR_RANK_NAME) {
		this.COMP_UI_M_ABGTR_RANK_NAME = COMP_UI_M_ABGTR_RANK_NAME;
	}

	public HtmlOutputLabel getCOMP_ABGTR_SHARE_PERC_LABEL() {
		return COMP_ABGTR_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_ABGTR_SHARE_PERC() {
		return COMP_ABGTR_SHARE_PERC;
	}

	public void setCOMP_ABGTR_SHARE_PERC_LABEL(HtmlOutputLabel COMP_ABGTR_SHARE_PERC_LABEL) {
		this.COMP_ABGTR_SHARE_PERC_LABEL = COMP_ABGTR_SHARE_PERC_LABEL;
	}

	public void setCOMP_ABGTR_SHARE_PERC(HtmlInputText COMP_ABGTR_SHARE_PERC) {
		this.COMP_ABGTR_SHARE_PERC = COMP_ABGTR_SHARE_PERC;
	}

	public PT_AGENT_BUDGET_RANK getPT_AGENT_BUDGET_RANK_BEAN() {
		return PT_AGENT_BUDGET_RANK_BEAN;
	}

	public void setPT_AGENT_BUDGET_RANK_BEAN(PT_AGENT_BUDGET_RANK PT_AGENT_BUDGET_RANK_BEAN) {
		this.PT_AGENT_BUDGET_RANK_BEAN = PT_AGENT_BUDGET_RANK_BEAN;
	}



	public UIData getRankDataTable() {
		return rankDataTable;
	}

	public void setRankDataTable(UIData rankDataTable) {
		this.rankDataTable = rankDataTable;
	}

	public ArrayList<PT_AGENT_BUDGET_RANK> getRankList() {
		/*	if(rankList.size()==0){     //for empty 5 rows
			for(int i=0;i<5;i++){
				PT_AGENT_BUDGET_RANK rank=new PT_AGENT_BUDGET_RANK();
				rankList.add(rank);
			}
		}*/
		return rankList;
	}

	public void setRankList(ArrayList<PT_AGENT_BUDGET_RANK> ListrankList) {
		this.rankList = ListrankList;
	}




	//lov for Rank Code
	public List rankCodeLov(Object obj) {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.amCodeLov()");
		List list = new ArrayList();

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;

		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK'"
				+ " AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND ROWNUM < 20 ORDER BY PC_CODE";
		try {
			if (obj.toString().equals("*")) {
				con = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(query, con);
				while (rs.next()) {
					PT_AGENT_BUDGET_RANK_LOV lovBean = new PT_AGENT_BUDGET_RANK_LOV();
					lovBean.setPC_CODE(rs.getString("PC_CODE"));
					lovBean.setPC_DESC(rs.getString("PC_DESC"));
					list.add(lovBean);
				}
			}else{
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK'"
					+ " AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND (PC_CODE LIKE '%"+obj.toString()+"%' OR PC_DESC LIKE '%"+obj.toString()+"%' ) AND ROWNUM < 20 ORDER BY PC_CODE";
				con = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(query, con);
				while (rs.next()) {
					PT_AGENT_BUDGET_RANK_LOV lovBean = new PT_AGENT_BUDGET_RANK_LOV();
					lovBean.setPC_CODE(rs.getString("PC_CODE"));
					lovBean.setPC_DESC(rs.getString("PC_DESC"));
					list.add(lovBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception exception) {
			}
		}
		return list;
	}

	

	public String removeRow() {
		PT_AGENT_BUDGET_RANK bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		getWarningMap().clear();
		getErrorMap().clear();

		try{
			if (rankList != null && rankList.size()>0) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < rankList.size();) {
					bean = rankList.get(index);
					if (bean.isCheckBoxSelected()) {
						rankList.remove(bean);
						deletedRecordIndex = deleteRankDetails(bean);
						deletedRecordList.add(deletedRecordIndex);
					} else {
						index++;
					}
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				}
				lastUpdatedRowIndex = -1;
			}
		}catch (Exception exc){
			getErrorMap().put("current", exc.getMessage());
		}

		return "";
	}


	public String  lastColumnListener() throws Exception{
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getRankDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;
		PT_AGENT_BUDGET_RANK gridValueBean = null;
		getWarningMap().clear();
		getErrorMap().clear();
		try {
			gridValueBean = (PT_AGENT_BUDGET_RANK)rankList.get(currRowIndex);
			if(gridValueBean.getROWID()== null){
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				preInsert(gridValueBean);
				rowUpdated = insertData(gridValueBean);
				if (rowUpdated == 1) {
					getWarningMap().put("current", message);
				}
			}else{
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				preUpdate(gridValueBean);
				rowUpdated = updateData(gridValueBean);
				if (rowUpdated == 1) {
					getWarningMap().put("current", message);
				}
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			getErrorMap().put("current", e1.getMessage());
		}

		return "" ;
	}


	public int updateData(PT_AGENT_BUDGET_RANK dataGridBean) throws Exception{
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			Connection connection=CommonUtils.getConnection();
			preUpdate(dataGridBean);
			rowUpdated = dbHandler.executeUpdate(dataGridBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int insertData(PT_AGENT_BUDGET_RANK dataGridBean) throws Exception{
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			Connection connection=CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	/*******************************   BLOCK  TRIGGERS ************************************/

	/*public void postQuery() throws Exception{
		try{
			for(int i=0; i < rankList.size(); i++){
				L_VAL_CODES("AGNRANK", rankList.get(i).getABGTR_RANK_CODE(), 
						rankList.get(i).getUI_M_ABGTR_RANK_NAME(), "N", "N", "");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/

	public void preInsert(PT_AGENT_BUDGET_RANK rankBean) throws Exception{

		String preInsertQuery = "SELECT PAG_ABGTR_SYS_ID.NEXTVAL FROM DUAL";
		Double M_PAGR_ABGT_SYS_ID = null;
		ResultSet rs = null;
		try{
			rs=getHandler().executeSelectStatement(preInsertQuery, CommonUtils.getConnection());
			if(rs.next()){
				M_PAGR_ABGT_SYS_ID = rs.getDouble(1);
			}
			rankBean.setABGTR_SYS_ID(M_PAGR_ABGT_SYS_ID);
			rankBean.setABGTR_CR_DT(new Date());
			rankBean.setABGTR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public void preUpdate(PT_AGENT_BUDGET_RANK rankBean) throws Exception {
		rankBean.setABGTR_UPD_DT(new Date());
		rankBean.setABGTR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		/*System.out.println("PT_AGENT_BUDGET_RANK_ACTION.preUpdate()");
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rsDate=handler.executeSelectStatement("SELECT SYSDATE FROM DUAL", connection);
		if(rsDate.next())
		PT_AGENT_BUDGET_RANK_BEAN.setABGTR_UPD_DT(rsDate.getDate(1));
		PT_AGENT_BUDGET_RANK_BEAN.setABGTR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());*/  

	}
	
	public void onLoad(PhaseEvent ae) throws Exception {
		try{
			if(isFormFlag()){
				setFormFlag(false);
			}
			if(isBlockFlag()){
				preBlock();
				//whenNewBlockInstance(sysId);
				executeQuery();
				if(PT_AGENT_BUDGET_RANK_BEAN.getROWID()!=null){
					//postQuery(agentCode);
				}else{
					
				}
				setBlockFlag(false);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	/**
	 * 
	 */
	public void whenCreateRecord(){
		compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().setABGT_MODULE_ID("IL");
	}
	
	public void preBlock() {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.preBlock()");
//		IF FORM_FAILURE THEN
//		:GLOBAL.M_FAILURE := 'TRUE';
//		END IF;
//		:CTRL.M_DELETE_MSG_FLAG := 'Y';
	}
	public void whenNewBlockInstance(Double sysId) throws Exception {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.whenNewBlockInstance() Sys Id: "+sysId);
		String query = "SELECT ROWID, PT_AGENT_BUDGET_RANK.* FROM PT_AGENT_BUDGET_RANK WHERE ABGTR_ABGT_SYS_ID = '"+sysId+"'";
		String rankCodeName=null;
		try{
			/*List<PT_AGENT_BUDGET_RANK> list = getHandler().fetch(query, "com.iii.pel.forms.PT051_A.PT_AGENT_BUDGET_RANK", CommonUtils.getConnection());
			if(!list.isEmpty()){
				System.out.println("The size of list for RANK Block: "+list.size());
				setRankList(list);
			}*/
			
			ResultSet rs3 = getHandler().executeSelectStatement(query, CommonUtils.getConnection());
			PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) (new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION"));
			PT_AGENT_BUDGET_RANK_ACTION budgetAction1 = compositeAction.getPT_AGENT_BUDGET_RANK_ACTION_BEAN();
			ArrayList<PT_AGENT_BUDGET_RANK> budgetRankList=budgetAction1.getRankList();
			if(!budgetAction1.getRankList().isEmpty()){
				budgetAction1.getRankList().clear();
			}
			while(rs3.next()){
				PT_AGENT_BUDGET_RANK rank=new PT_AGENT_BUDGET_RANK();
				rank.setROWID(rs3.getString("ROWID"));
				rank.setABGTR_RANK_CODE(rs3.getString("ABGTR_RANK_CODE"));
				rank.setABGTR_SHARE_PERC(rs3.getDouble("ABGTR_SHARE_PERC"));
				rank.setABGTR_SYS_ID(rs3.getDouble("ABGTR_SYS_ID"));
//				rank.setUI_M_ABGTR_RANK_NAME(rankName(rs3.getString(2)));
//				rank.setABGTR_SYS_ID(ABGTR_SYS_ID);
				rank.setABGTR_ABGT_SYS_ID(rs3.getDouble("ABGTR_ABGT_SYS_ID"));
				rank.setABGTR_CR_DT(rs3.getDate("ABGTR_CR_DT"));
				rank.setABGTR_CR_UID(rs3.getString("ABGTR_CR_UID"));
				rank.setRowSelected(false);
				//post Query code added by Varun[50663]
				rankCodeName=L_VAL_CODES("AGNRANK", rank.getABGTR_RANK_CODE(), rank.getUI_M_ABGTR_RANK_NAME(), "N","N" , null);
				if(rankCodeName!=null){
					rank.setUI_M_ABGTR_RANK_NAME(rankCodeName);
				}
				
				budgetRankList.add(rank);
			}			
			budgetAction1.setRankList(budgetRankList);
			if(budgetRankList.size()>0)
			{
				budgetAction1.setPT_AGENT_BUDGET_RANK_BEAN(budgetRankList.get(0));
				budgetAction1.getPT_AGENT_BUDGET_RANK_BEAN().setRowSelected(true);					
			}
			budgetAction1.resetAllComponent();
			System.out.println("The size of rank list: "+getRankList().size());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT051_A_COMPOSITE_ACTION", compositeAction);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	/**
	 * 
	 * @throws Exception
	 */
		public void executeQuery() throws Exception {
			String query = "SELECT ROWID, PT_AGENT_BUDGET_RANK.* FROM PT_AGENT_BUDGET_RANK WHERE ABGTR_ABGT_SYS_ID = ? ";
			String rankCodeName=null;
			Connection connection = null;
			CRUDHandler handler = null;
			ResultSet rs3 = null;
			
			try{
				handler = new CRUDHandler();
				
				rs3= handler.executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID()});
				if(rankList!=null &&!rankList.isEmpty()){
					rankList.clear();
				}
				while(rs3.next()){
					PT_AGENT_BUDGET_RANK rank=new PT_AGENT_BUDGET_RANK();
					rank.setROWID(rs3.getString("ROWID"));
					rank.setABGTR_RANK_CODE(rs3.getString("ABGTR_RANK_CODE"));
					rank.setABGTR_SHARE_PERC(rs3.getDouble("ABGTR_SHARE_PERC"));
					rank.setABGTR_SYS_ID(rs3.getDouble("ABGTR_SYS_ID"));
					rank.setABGTR_ABGT_SYS_ID(rs3.getDouble("ABGTR_ABGT_SYS_ID"));
					rank.setABGTR_CR_DT(rs3.getDate("ABGTR_CR_DT"));
					rank.setABGTR_CR_UID(rs3.getString("ABGTR_CR_UID"));
					//post Query code added by Varun[50663]
					rankCodeName=L_VAL_CODES("AGNRANK", rank.getABGTR_RANK_CODE(), rank.getUI_M_ABGTR_RANK_NAME(), "N","N" , null);
					if(rankCodeName!=null){
						rank.setUI_M_ABGTR_RANK_NAME(rankCodeName);
					}
					
					rankList.add(rank);
				}			
				if(rankList!=null &&
						rankList.size()>0)
				{
					PT_AGENT_BUDGET_RANK pt_agent_budget_rank = rankList.get(0);
					pt_agent_budget_rank.setRowSelected(true);
					setPT_AGENT_BUDGET_RANK_BEAN(pt_agent_budget_rank);					
				}
				resetAllComponent();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{CommonUtils.closeCursor(rs3);}catch(Exception exception){}
			}
	}

	/*******************************   FIELD(ITEM)  TRIGGERS ***********************************
	 * @throws Exception */
	/*public void ABGTR_AGENT_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_AGENT_CODE_WhenValidateItem()...");		
		try {
			PT_AGENT_BUDGET_RANK rank = (PT_AGENT_BUDGET_RANK) rankDataTable.getRowData();
			Connection connection=CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK' " +
			" AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND PC_CODE='"+rank.getABGTR_RANK_CODE()+"'";

			ResultSet rs=handler.executeSelectStatement(query, connection);
			if(rs.next()){
				getCOMP_UI_M_ABGTR_RANK_NAME().setSubmittedValue(rs.getString(2));
				System.out.println("Rank Name = "+rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
//		return "";
	}*/

	public void ABGTR_AGENT_CODE_WhenValidateItem(ActionEvent event){
		
		//[Method is added for new data Grid implementation.Byy the Phanikumar dated:16-Feb-2009
		CommonUtils.clearMaps(this);
		
		
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_AGENT_CODE_WhenValidateItem()...");
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void abgtrAgentCodevalidator(FacesContext context, UIComponent component, Object value) throws Exception {
		String M_C1FOUND="";
		try {
			//PT_AGENT_BUDGET_RANK rank = this.getPT_AGENT_BUDGET_RANK_BEAN();//rankList.get(rankDataTable.getRowIndex());
			Connection connection=CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			Double ABGT_SYS_ID = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID();
			PT_AGENT_BUDGET_RANK_BEAN.setABGTR_ABGT_SYS_ID(ABGT_SYS_ID);

			System.out.println("The value entered by user: "+value+" and SYS ID: "+PT_AGENT_BUDGET_RANK_BEAN.getABGTR_ABGT_SYS_ID());
			PT_AGENT_BUDGET_RANK_BEAN.setABGTR_RANK_CODE(value.toString());
			Object[] values = {PT_AGENT_BUDGET_RANK_BEAN.getABGTR_ABGT_SYS_ID(),value};
			String query="SELECT ROWID FROM PT_AGENT_BUDGET_RANK WHERE ABGTR_ABGT_SYS_ID = ? " +
			"AND ABGTR_RANK_CODE = ?";
			/*String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK' " +
				" AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND PC_CODE='"+rank.getABGTR_RANK_CODE()+"'";*/

			if(!"".equals(PT_AGENT_BUDGET_RANK_BEAN.getABGTR_RANK_CODE())){
				PT_AGENT_BUDGET_RANK_BEAN.setUI_M_ABGTR_RANK_NAME(L_VAL_CODES("AGNRANK",value.toString(),
						PT_AGENT_BUDGET_RANK_BEAN.getUI_M_ABGTR_RANK_NAME(),"N","E",""));
				getCOMP_UI_M_ABGTR_RANK_NAME().resetValue();
				ResultSet rs=handler.executeSelectStatement(query, connection, values);
				if(rs.next()){
					M_C1FOUND = (rs.getString(1));
					System.out.println("Rank Name = "+rs.getString(1));
				}
				System.out.println("The value of M_C1FOUND is: "+M_C1FOUND);
				/*if(!"".equalsIgnoreCase(M_C1FOUND)){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91273"));
				}*/
				if(!"".equalsIgnoreCase(M_C1FOUND)){
					System.out.println("11111111");
					if(CommonUtils.isDuplicate(PT_AGENT_BUDGET_RANK_BEAN.getROWID(), M_C1FOUND)){
						System.out.println("2222222");
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91273"));
					}/*else if(!"".equalsIgnoreCase(M_C1FOUND)){
						System.out.println("3333333");
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91273"));
					}*/
				}
				System.out.println("The M_C1FOUND value is: "+M_C1FOUND);
				/*if(rankList.size() > 0){
					for(int i=0; (i< rankList.size() && i != rankDataTable.getRowIndex()); i++){
						if(value.toString().trim().equalsIgnoreCase(rankList.get(i).getABGTR_RANK_CODE())){
							throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91273"));
						}
					}
				}*/
			}
		}/*catch(ValidatorException vexc){
			throw vexc;
		}*/catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String L_VAL_CODES(String P_CODE_TYPE, String P_CODE, String P_CODE_DESC, String P_NAME_FLAG,
			String P_ERR_FLAG, String P_CLASS_CODE) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		String M_NAME = null;
		String M_BL_NAME = null;
		String M_FRZ_FLAG = null;
		String M_DESC = null;
		Integer M_VALUE = -1;
		String M_CLASS_CODE = null;

		Object[] values = null;
		ArrayList<Object> resultList = null;
		String message = null;
		String query = "SELECT DECODE(?,'N',PC_DESC ,'L',NVL(PC_LONG_DESC,PC_DESC),PC_DESC) AS AL_NAME, "
			+ "DECODE(?,'N',PC_BL_DESC ,'L',NVL(PC_BL_LONG_DESC,PC_DESC),PC_BL_DESC) AS AL_BL_NAME, "
			+ "PC_FRZ_FLAG " 
			+ "FROM   PM_CODES "
			+ "WHERE  PC_TYPE = ? "
			+ "AND    PC_CODE = ? " 
			+ "AND    NVL(PC_CLASS_CODE,'*******') = NVL(? ,'*******')";
		try{

			resultList = L_VAL_SYSTEM("CODES", P_CODE_TYPE, M_DESC, "E", M_VALUE) ;
			if(resultList != null && resultList.size()>0){
				M_DESC = (String)resultList.get(0);
				M_VALUE = (Integer)resultList.get(1);
			}

			/* IF P_VALUE IS '1' - Class code is required
			else Class code is not required */
			if(MigratingFunctions.nvl(M_VALUE, 0) == 1){
				M_CLASS_CODE = P_CLASS_CODE;
			}else{
				M_CLASS_CODE = null;
			}

			connection = CommonUtils.getConnection();
			values = new Object[]{P_NAME_FLAG, P_NAME_FLAG, P_CODE_TYPE, P_CODE, M_CLASS_CODE};
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next()){
				M_NAME = resultSet.getString("AL_NAME");
				M_BL_NAME = resultSet.getString("AL_BL_NAME");
				M_FRZ_FLAG = resultSet.getString("PC_FRZ_FLAG");
			}else{
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					message = Messages.getString(PELConstants.pelErrorMessagePath, "1010");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(message);
					}
				}
			}

			if("Y".equals(M_FRZ_FLAG)){
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					message = Messages.getString(PELConstants.pelErrorMessagePath, "1020");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(message);
					}
				}
			}
			/*PM075_A_COMPOSITE_ACTION pm075_a_composite_action=(PM075_A_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM075_A_COMPOSITE_ACTION");*/
			ControlBean controlBean = CommonUtils.getControlBean();

			/*if("ENG".equals(CommonUtils.getGlobalVariable("M_LANG_CODE")) || 
					"1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))){*/
			if("ENG".equals(controlBean.getM_LANG_CODE())){
				P_CODE_DESC = M_NAME;
			}
			else{
				P_CODE_DESC = M_BL_NAME;
			}
			/*if("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))
					|| "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
				P_CODE_DESC = M_NAME;
			}else{
				P_CODE_DESC = M_BL_NAME;
			}*/
		}catch(DBException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);} catch(Exception e){}
		}
		return P_CODE_DESC;
	}

	private ArrayList<Object> L_VAL_SYSTEM(String P_TYPE, String P_CODE, String P_CODE_DESC, String P_ERR_FLAG, int P_VALUE) 
	throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String message = null;

		String M_NAME = null;
		String M_BL_NAME = null;
		int M_VALUE = -1;
		ArrayList<Object> resultList = null;
		Object[] values = {P_TYPE, P_CODE};
		String query = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE  = ? " +
		"AND PS_CODE  = ?";
		try{

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next()){
				M_NAME = resultSet.getString("PS_CODE_DESC");
				M_BL_NAME = resultSet.getString("PS_BL_CODE_DESC");
				M_VALUE = resultSet.getInt("PS_VALUE");
			}else{
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					message = Messages.getString(PELConstants.pelErrorMessagePath, "1000", new String[]{P_TYPE, P_CODE} );
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(message);
					}
				}
			}
//			PM075_A_COMPOSITE_ACTION pm075_a_composite_action=(PM075_A_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM075_A_COMPOSITE_ACTION");
			ControlBean controlBean=CommonUtils.getControlBean();
//			if("ENG".equals(CommonUtils.getGlobalVariable("M_LANG_CODE")) || 
//			"1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))){
			if("ENG".equals(controlBean.getM_LANG_CODE())){			
				P_CODE_DESC = M_NAME;
			}
			else{
				P_CODE_DESC = M_BL_NAME;
			}

			/*if("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))
					|| "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
				P_CODE_DESC = M_NAME;
			}else{
				P_CODE_DESC = M_BL_NAME;
			}*/

			P_VALUE = M_VALUE;

			resultList = new ArrayList<Object>();
			resultList.add(P_CODE_DESC);
			resultList.add(P_VALUE);
		}catch(DBException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return resultList;
	}	

	/*		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK' " +
			" AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND PC_CODE='"+PT_AGENT_BUDGET_RANK_BEAN.getABGTR_RANK_CODE()+"'";
		ResultSet rs=handler.executeSelectStatement(query, connection);
		if(rs.next()){
		getCOMP_UI_M_ABGTR_RANK_NAME().setSubmittedValue(rs.getString(1));
		System.out.println("PT_AGENT_BUDGET_RANK_--"+rs.getString(1));
		}
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_AGENT_CODE_WhenValidateItem()...END");*/

	/*String sql_C1="SELECT 'X' FROM  PT_AGENT_BUDGET_RANK  WHERE  " +
				"ABGTR_ABGT_SYS_ID  = '"+PT_AGENT_BUDGET_RANK_BEAN.getABGTR_ABGT_SYS_ID()+"'  AND" +
				" ABGTR_RANK_CODE  = '"+PT_AGENT_BUDGET_RANK_BEAN.getABGTR_RANK_CODE()+"'";
        ResultSet vembu_C1=null;
        String M_C1FOUND=null;
        if(PT_AGENT_BUDGET_RANK_BEAN.getABGTR_RANK_CODE()!= null)
        {
        	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
        	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
       		paramList.add(new OracleParameter("in1","STRING","IN", "AGNRANK"));
       		paramList.add(new OracleParameter("in1","STRING","IN", PT_AGENT_BUDGET_RANK_BEAN.getABGTR_RANK_CODE()));
       		paramList.add(new OracleParameter("in1","STRING","IN OUT", PT_AGENT_BUDGET_RANK_BEAN.getUI_M_ABGTR_RANK_NAME()));
       		paramList.add(new OracleParameter("in1","STRING","IN", "N"));
       		paramList.add(new OracleParameter("in1","STRING","IN", "N"));
       		paramList.add(new OracleParameter("in1","STRING","IN", null));
       		OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
    			try {
        			list = ora_Handler.execute(paramList, connection, "L_VAL_CODES");
        			System.out.println("NO OF VAL CODES>>>>>>>---"+list.get(0));
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
            if(vembu_C1!=null)
            {
                vembu_C1.close();
            }
            vembu_C1=handler.executeSelectStatement(sql_C1,connection);
            if(vembu_C1.next())
            {
                M_C1FOUND=vembu_C1.getString(1);
            }
            vembu_C1.close();
            if(M_C1FOUND != null)
            {
            	getErrorMap().put("current",Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91273").getDetail());
            }
        }
	 */
	public void ABGTR_SHARE_PERC_WhenValidateItem(ActionEvent event) {
		//[Method is added for new data Grid implementation.Byy the Phanikumar dated:16-Feb-2009
		CommonUtils.clearMaps(this);
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_AGENT_CODE_WhenValidateItem()...");
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		try{
		//[lastColumnListener Method is commented by the Phanikumar dated 16-Feb-2009 for the new Data Grid
			//lastColumnListener();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void ABGTR_SHARE_PERC_Validator(FacesContext context, UIComponent component, Object value) throws Exception {
		String perShare = value.toString();
		//int rowIndex = getRankDataTable().getRowIndex();
		//PT_AGENT_BUDGET_RANK bean = rankList.get(rowIndex);
		 this.getPT_AGENT_BUDGET_RANK_BEAN().setABGTR_SHARE_PERC(Double.parseDouble(perShare));
	       String Share=this.getPT_AGENT_BUDGET_RANK_BEAN().getABGTR_SHARE_PERC().toString();	
		 try {
			System.out.println("The value entered in the rank grid: "+value);
			//if (!perShare.isEmpty() && perShare != null) {
			if(PT_AGENT_BUDGET_RANK_BEAN.getABGTR_SHARE_PERC()< 0){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
			}
			if (!Share.isEmpty() && Share != null) {
			if (Double.parseDouble(Share) >100) {
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91274"));

//					getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "91274"));
//					getErrorMap().put("details", Messages.getString(PELConstants.pelErrorMessagePath, "91274"));
				} else {
//					getErrorMap().clear();
					//bean.setABGTR_SHARE_PERC(Double.parseDouble(Share));
					
				}
			}
		} catch (NumberFormatException exc) {
			getErrorMap().put("current",Messages.getString("messageProperties_PT051_A","PT051_A$PT_AGENT_BUDGET$ABGTR_SHARE_PERC$numbermessage"));
		}catch(ValidatorException vexc){
			throw vexc;
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
		/*	System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_SHARE_PERC_WhenValidateItem()");
		PT_AGENT_BUDGET_RANK rankTest = (PT_AGENT_BUDGET_RANK) rankDataTable.getRowData();
		System.out.println(" ABGT_SYS_ID = "+rankTest.getABGTR_SYS_ID());
		System.out.println("  ABGTR_ABGT_SYS_ID = "+rankTest.getABGTR_ABGT_SYS_ID());
		System.out.println("  ABGTR_CR_DT = "+rankTest.getABGTR_CR_DT());
		System.out.println("  ABGTR_CR_UID = "+rankTest.getABGTR_CR_UID());
		System.out.println(" ROWID = "+rankTest.getROWID());*/

		/*	System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_SHARE_PERC_WhenValidateItem()");
		if(PT_AGENT_BUDGET_RANK_BEAN.getABGTR_SHARE_PERC() != null)
			if(PT_AGENT_BUDGET_RANK_BEAN.getABGTR_SHARE_PERC() > 100)
				getErrorMap().put("current",Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91274").getDetail());*/
	}

	public void checkBoxStatus(ActionEvent actionEvent)
	{
		//[Method is added for new data Grid implementation.Byy the Phanikumar dated:16-Feb-2009
		CommonUtils.clearMaps(this);
		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getRankDataTable().getRowIndex();
		rankList.get(rowIndex).setCheckBoxSelected(check);
	}

	public String getCurrentValue(ActionEvent event){
		//[Method is added for new data Grid implementation.Byy the Phanikumar dated:16-Feb-2009
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;

		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String)input.getSubmittedValue();
			}
		}
		return value;
	}

	public void checkBox_action(ActionEvent event){
		//gridtabListener();
	}
	
	public void deleteRow() {
		try {
			CommonUtils.clearMaps(this);
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PT_AGENT_BUDGET_RANK_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				rankList.remove(PT_AGENT_BUDGET_RANK_BEAN);
				if (rankList.size() > 0) {

					PT_AGENT_BUDGET_RANK_BEAN = rankList.get(0);
				} else if (rankList.size() == 0) {

					addRow();
				}

				resetAllComponent();
				PT_AGENT_BUDGET_RANK_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public int deleteRankDetails(PT_AGENT_BUDGET_RANK bean) {

		Connection connection;
		CRUDHandler handler =null;

		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			if(connection != null){
				handler = new CRUDHandler();
				deletedRows = handler.executeDelete(bean, connection);
			}
		} catch (DBException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
//[gridTabListener is commented by the Phanikumar dated 16-Feb-2009 for the new Data Grid Implementation
	/*public void gridtabListener() {
		int currRowIndex = getRankDataTable().getRowIndex();
		PT_AGENT_BUDGET_RANK detailsBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != 0) {
						if (currRowIndex != prevRowIndex) {
							detailsBean = new PT_AGENT_BUDGET_RANK();
							detailsBean = (PT_AGENT_BUDGET_RANK) rankList
							.get(prevRowIndex);
							if (detailsBean.getROWID() == null) {
								preInsert(detailsBean);
							} else {
								preUpdate(detailsBean);
							}
							updateData(detailsBean);
							prevRowIndex = currRowIndex;
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}*/
	//gridTabListener is commented by the Phanikumar dated 16-Feb-2009 for the new Data Grid Implementation]
	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	

	public String allocateButtonPressed() {
		String outcome = "NAVIGATE_TO_AGENT_BUDGET_BREAKUP";//Changed navigation string as this is mapped in faces config-Varun[50663]
		String M_DUMMY = null;
		ResultSet resultSet = null;
		CommonUtils commonUtils = new CommonUtils();
		
		OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
		
		PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION");
		PT_AGENT_BUDGET_ACTION budgetAction = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN();
		PT_AGENT_BUDGET budgetBean = budgetAction.getPT_AGENT_BUDGET_BEAN();
		Double budgetSysId = budgetBean.getABGT_SYS_ID();
		System.out.println("sysid------------------------->"+budgetSysId);
		String selectQuery = "SELECT 'X' FROM   PT_AGENT_BUDGET_BREAKUP WHERE  ABGTB_ABGT_SYS_ID = ?";
		try{
			callL_CHK_RANK_SHARE_PERC_SUM_Proc(budgetSysId);
			CommonUtils com = new CommonUtils();
			Object[] values = {budgetSysId};
			resultSet = getHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection(), values);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
			}
			
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			paramList.add(new OracleParameter("in1","STRING","IN",budgetSysId+""));
			procedureHandler.execute(paramList, CommonUtils.getConnection(), "P9ILPK_AGENCY_BUDGET.GEN_BUDGET_BREAKUP_REC");
			com.doComitt();
			
			procedureHandler.execute(paramList, CommonUtils.getConnection(), "P9ILPK_AGENCY_BUDGET.GEN_BUDGET_MON_BREAKUP_REC");
			com.doComitt();
			
			//--** PART MOVED AS THIS WILL FETCH THE DETAILS*--*//
			compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN().whenNewBlockInstance(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID());
			
			//IF PART COMMENTED AS POST QUERY SHOULD BE CALLED EVERY TIME --VARUN[50663]
			//if("QUERY_UPDATE".equalsIgnoreCase(CommonUtils.getGlobalVariable("PT051_A_MODE"))){
			compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN().postQuery();
			//}
			//-**- VARUN[50663]//
			
			if ( "X".equals(MigratingFunctions.nvl(M_DUMMY, "Y"))) {
				Object[] object = {budgetBean.getUI_M_ABGT_AGENCY_CODE()};
				String agencycode=compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getUI_M_ABGT_AGENCY_CODE();
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91277",new Object[]{agencycode}));
				
			}

			/*// Set current tab
			PT051_A_SEARCH_PAGE_ACTION searchAction = (PT051_A_SEARCH_PAGE_ACTION) commonUtils.getMappedBeanFromSession("PT051_A_SEARCH_PAGE_ACTION");
			if(searchAction != null){
				 searchAction.getTabbedBar().setTabClicked(PT051_A_SEARCH_PAGE_ACTION.AGENT_DETAILS);
			 }*/
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT051_A_COMPOSITE_ACTION", compositeAction);
		}catch(ValidatorException vde){
			getErrorMap().put("current", vde.getMessage());
			getErrorMap().put("details", vde.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			outcome = null;
			try {
				ErrorHelpUtil.getErrorsforProcedureButtons(CommonUtils.getConnection(), FacesContext.getCurrentInstance(), getCOMP_UI_M_BUT_ALLOC(), getErrorMap());
			}catch (DBException e1) {
				e1.printStackTrace();
			}
		}
		
		return outcome;
	}
	
	

	public void callL_CHK_RANK_SHARE_PERC_SUM_Proc(Double budgetSysId) {
		ResultSet resultSet = null;
		Double M_TOT_ABGTR_SHARE_PERC = 0.0;
		String selectQuery = "SELECT SUM(NVL(ABGTR_SHARE_PERC,0)) FROM PT_AGENT_BUDGET_RANK " +
				             "WHERE PT_AGENT_BUDGET_RANK.ABGTR_ABGT_SYS_ID = ?";
		try{
			Object[] values = {budgetSysId};
			resultSet = getHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection(), values);
			if (resultSet.next()) {
				M_TOT_ABGTR_SHARE_PERC = resultSet.getDouble(1);
			}
			System.out.println("M_TOT_ABGTR_SHARE_PERC----------------->"+M_TOT_ABGTR_SHARE_PERC);
			if (M_TOT_ABGTR_SHARE_PERC > 100) {
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91274"));
			}
		}catch(ValidatorException ve) {
			throw ve;
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(DBException dbe){
			dbe.printStackTrace();
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ALLOC() {
		return COMP_UI_M_BUT_ALLOC;
	}

	public void setCOMP_UI_M_BUT_ALLOC(HtmlCommandButton comp_ui_m_but_alloc) {
		COMP_UI_M_BUT_ALLOC = comp_ui_m_but_alloc;
	}
	// [ Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = rankDataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Manoj Kumar Sahu, Dated: 12-Feb-2009 ]
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_AGENT_BUDGET_RANK_BEAN = (PT_AGENT_BUDGET_RANK) rankDataTable.getRowData();
			PT_AGENT_BUDGET_RANK_BEAN.setRowSelected(true);
			
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_AGENT_BUDGET_RANK> iterator = rankList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void addRow() {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {

				PT_AGENT_BUDGET_RANK_BEAN = new PT_AGENT_BUDGET_RANK();
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}
	
	

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void post() {	

		try {
			if (PT_AGENT_BUDGET_RANK_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpdate(this.PT_AGENT_BUDGET_RANK_BEAN);
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_RANK_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					preInsert(this.PT_AGENT_BUDGET_RANK_BEAN);
					
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_RANK_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					rankList.add(PT_AGENT_BUDGET_RANK_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_BUDGET_RANK_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
     
	public void resetAllComponent() {
		COMP_ABGTR_RANK_CODE.resetValue();
		COMP_UI_M_ABGTR_RANK_NAME.resetValue();
		COMP_ABGTR_SHARE_PERC.resetValue();	

	}

	
	

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	/**
	 * @return the cOMP_UI_M_BUT_ADD
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_ADD() {
		return COMP_UI_M_BUT_ADD;
	}

	/**
	 * @param comp_ui_m_but_add the cOMP_UI_M_BUT_ADD to set
	 */
	public void setCOMP_UI_M_BUT_ADD(HtmlCommandButton comp_ui_m_but_add) {
		COMP_UI_M_BUT_ADD = comp_ui_m_but_add;
	}

	/**
	 * @return the cOMP_UI_M_BUT_DELETE
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_DELETE() {
		return COMP_UI_M_BUT_DELETE;
	}

	/**
	 * @param comp_ui_m_but_delete the cOMP_UI_M_BUT_DELETE to set
	 */
	public void setCOMP_UI_M_BUT_DELETE(HtmlCommandButton comp_ui_m_but_delete) {
		COMP_UI_M_BUT_DELETE = comp_ui_m_but_delete;
	}

	/**
	 * @return the cOMP_UI_M_BUT_POST
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_POST() {
		return COMP_UI_M_BUT_POST;
	}

	/**
	 * @param comp_ui_m_but_post the cOMP_UI_M_BUT_POST to set
	 */
	public void setCOMP_UI_M_BUT_POST(HtmlCommandButton comp_ui_m_but_post) {
		COMP_UI_M_BUT_POST = comp_ui_m_but_post;
	}

	/**
	 * @return the compositeAction
	 */
	public PT051_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PT051_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	

	/**
	 * Instantiates all components in PT_AGENT_BUDGET_RANK_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_ABGTR_RANK_CODE				 = new HtmlInputText();
		COMP_UI_M_ABGTR_RANK_NAME			 = new HtmlInputText();
		COMP_ABGTR_SHARE_PERC				 = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_ALLOC				 = new HtmlCommandButton();
		COMP_UI_M_BUT_ADD				 = new HtmlCommandButton();
		COMP_UI_M_BUT_DELETE				 = new HtmlCommandButton();
		COMP_UI_M_BUT_POST				 = new HtmlCommandButton();

	}


}

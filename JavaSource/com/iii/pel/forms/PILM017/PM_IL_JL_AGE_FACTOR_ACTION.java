package com.iii.pel.forms.PILM017;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_JL_AGE_FACTOR_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_JAF_DIFF_AGE_FROM_LABEL;

	private HtmlInputText COMP_JAF_DIFF_AGE_FROM;

	private HtmlOutputLabel COMP_JAF_DIFF_AGE_TO_LABEL;

	private HtmlInputText COMP_JAF_DIFF_AGE_TO;

	private HtmlOutputLabel COMP_JAF_AGE_FACTOR_LABEL;

	private HtmlInputText COMP_JAF_AGE_FACTOR;

	private HtmlOutputLabel COMP_JAF_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_JAF_EFF_FM_DT;

	private HtmlOutputLabel COMP_JAF_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_JAF_EFF_TO_DT;

	private PM_IL_JL_AGE_FACTOR PM_IL_JL_AGE_FACTOR_BEAN;

	private List<PM_IL_JL_AGE_FACTOR> fetchList = new ArrayList<PM_IL_JL_AGE_FACTOR>();

	private UIDataTable dataTable;
	private PM_IL_JL_AGE_FACTOR getTest;

	private int rowIndex ;

	private HtmlCommandButton dummy;

	public HtmlCommandButton getDummy() {
		return dummy;
	}

	public void setDummy(HtmlCommandButton dummy) {
		this.dummy = dummy;
	}

	public PM_IL_JL_AGE_FACTOR_ACTION() {
		PM_IL_JL_AGE_FACTOR_BEAN=new PM_IL_JL_AGE_FACTOR();
		//fetchList.add(PM_IL_JL_AGE_FACTOR_BEAN);
		//executePreform(null);
	}

	public HtmlOutputLabel getCOMP_JAF_DIFF_AGE_FROM_LABEL() {
		return COMP_JAF_DIFF_AGE_FROM_LABEL;
	}

	public HtmlInputText getCOMP_JAF_DIFF_AGE_FROM() {
		return COMP_JAF_DIFF_AGE_FROM;
	}

	public void setCOMP_JAF_DIFF_AGE_FROM_LABEL(HtmlOutputLabel COMP_JAF_DIFF_AGE_FROM_LABEL) {
		this.COMP_JAF_DIFF_AGE_FROM_LABEL = COMP_JAF_DIFF_AGE_FROM_LABEL;
	}

	public void setCOMP_JAF_DIFF_AGE_FROM(HtmlInputText COMP_JAF_DIFF_AGE_FROM) {
		this.COMP_JAF_DIFF_AGE_FROM = COMP_JAF_DIFF_AGE_FROM;
	}

	public HtmlOutputLabel getCOMP_JAF_DIFF_AGE_TO_LABEL() {
		return COMP_JAF_DIFF_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_JAF_DIFF_AGE_TO() {
		return COMP_JAF_DIFF_AGE_TO;
	}

	public void setCOMP_JAF_DIFF_AGE_TO_LABEL(HtmlOutputLabel COMP_JAF_DIFF_AGE_TO_LABEL) {
		this.COMP_JAF_DIFF_AGE_TO_LABEL = COMP_JAF_DIFF_AGE_TO_LABEL;
	}

	public void setCOMP_JAF_DIFF_AGE_TO(HtmlInputText COMP_JAF_DIFF_AGE_TO) {
		this.COMP_JAF_DIFF_AGE_TO = COMP_JAF_DIFF_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_JAF_AGE_FACTOR_LABEL() {
		return COMP_JAF_AGE_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_JAF_AGE_FACTOR() {
		return COMP_JAF_AGE_FACTOR;
	}

	public void setCOMP_JAF_AGE_FACTOR_LABEL(HtmlOutputLabel COMP_JAF_AGE_FACTOR_LABEL) {
		this.COMP_JAF_AGE_FACTOR_LABEL = COMP_JAF_AGE_FACTOR_LABEL;
	}

	public void setCOMP_JAF_AGE_FACTOR(HtmlInputText COMP_JAF_AGE_FACTOR) {
		this.COMP_JAF_AGE_FACTOR = COMP_JAF_AGE_FACTOR;
	}

	public HtmlOutputLabel getCOMP_JAF_EFF_FM_DT_LABEL() {
		return COMP_JAF_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_JAF_EFF_FM_DT() {
		return COMP_JAF_EFF_FM_DT;
	}

	public void setCOMP_JAF_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_JAF_EFF_FM_DT_LABEL) {
		this.COMP_JAF_EFF_FM_DT_LABEL = COMP_JAF_EFF_FM_DT_LABEL;
	}

	public void setCOMP_JAF_EFF_FM_DT(HtmlCalendar COMP_JAF_EFF_FM_DT) {
		this.COMP_JAF_EFF_FM_DT = COMP_JAF_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_JAF_EFF_TO_DT_LABEL() {
		return COMP_JAF_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_JAF_EFF_TO_DT() {
		return COMP_JAF_EFF_TO_DT;
	}

	public void setCOMP_JAF_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_JAF_EFF_TO_DT_LABEL) {
		this.COMP_JAF_EFF_TO_DT_LABEL = COMP_JAF_EFF_TO_DT_LABEL;
	}

	public void setCOMP_JAF_EFF_TO_DT(HtmlCalendar COMP_JAF_EFF_TO_DT) {
		this.COMP_JAF_EFF_TO_DT = COMP_JAF_EFF_TO_DT;
	}

	public PM_IL_JL_AGE_FACTOR getPM_IL_JL_AGE_FACTOR_BEAN() {
		return PM_IL_JL_AGE_FACTOR_BEAN;
	}

	public void setPM_IL_JL_AGE_FACTOR_BEAN(PM_IL_JL_AGE_FACTOR PM_IL_JL_AGE_FACTOR_BEAN) {
		this.PM_IL_JL_AGE_FACTOR_BEAN = PM_IL_JL_AGE_FACTOR_BEAN;
	}


	public void AddRow(ActionEvent ae) {
		System.out.println("PM_IL_JL_AGE_FACTOR_ACTION.AddRow()-AddRow");
		fetchList.add(new PM_IL_JL_AGE_FACTOR());
	}

	public String checkBoxStatus(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		System.out.println("check");
		return "";
	}

	public void  Save(ActionEvent event){
		try{
			CommonUtils.clearMaps(this);
				getConnection().commit();
		}catch(Exception er){
			er.printStackTrace();

		}
	}

	public void fetchGrid(ActionEvent actionEvent){
		Fetch();
	}

	//Fetch the Date
	public List Fetch(){
		System.out.println("Fetching the data ");
		CRUDHandler handler = new CRUDHandler();
		try {
			fetchList = handler.fetch("select rowid,PM_IL_JL_AGE_FACTOR.* from PM_IL_JL_AGE_FACTOR" , "com.iii.pel.forms.PILM017.PM_IL_JL_AGE_FACTOR", getConnection());
			System.out.println("LIST---------------------------->"+fetchList.get(0).getROWID());
		} catch (Exception e) {

			e.printStackTrace();
		} 

		return fetchList;	
	}

	//End of Fetch Data

	// Update Context

	/*public String Update(){
		System.out.println("Inside the Update ");
		CRUDHandler handler = new CRUDHandler();
		PM_IL_JL_AGE_FACTOR bean;
		int rowUpdated = 0;
		try {
			bean = fetchList.get(getRowIndex());
			System.out.println("The ROW ID IS "+bean.getROWID());
			rowUpdated = handler.executeUpdate(bean, getConnection());
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}	
		bean =new PM_IL_JL_AGE_FACTOR();
	return "";	
	}*/

	//End of Update Context

	//Delete Context
	public String Delete(){
		System.out.println("Inside the Delete ");
		CRUDHandler handler = new CRUDHandler();
		PM_IL_JL_AGE_FACTOR bean;

		int rowDeleted = 0;
		try {
			if(fetchList != null){
				for(int index =0 ;index<fetchList.size();){
					bean = fetchList.get(index);
					System.out.println("ValueBean" +bean.toString());
					System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+bean.isCHECK_BOX());
					if(bean.isCHECK_BOX()){
						fetchList.remove(bean);
						int n = handler.executeDelete(bean, getConnection());
						System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.deleteRow()-n"+n);
						getConnection().commit();
						if(n>0){
							getWarningMap().put("current",n+" record deleted");
						}
					}else{
						System.out.println("Else_Part_In_Action");
						index++;
					}
				}
			}
		}catch (Exception e) {
			getErrorMap().put("current", "record not deleted");
			// TODO Auto-generated catch block
			e.printStackTrace();					
		}	
		PM_IL_JL_AGE_FACTOR_BEAN =new PM_IL_JL_AGE_FACTOR();
		return "";	
	}

	public void focusing(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		System.out.println("The Row Index is "+	 getDataTable().getRowIndex());
		setRowIndex(getDataTable().getRowIndex());
	}
	//End of Delete Context
	public Connection getConnection() throws Exception{
		/*FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context =null;
		SimpleConnectionAgent connectionAgent = null;
		Connection connection = null;
		try{
			context = (ServletContext)fc.getExternalContext().getContext();
			connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
			connection =connectionAgent.getConnection("12345"); 

		}catch(Exception er){
			er.printStackTrace();
		}
		return connection; */
		return CommonUtils.getConnection();
	}

	/*public String lastColumnListener(){
		try{ 
			CRUDHandler handler = new CRUDHandler();
			PM_IL_JL_AGE_FACTOR  bean = null;
			bean = fetchList.get(getDataTable().getRowIndex());
			int rowUpdated=0;
			if(bean.getROWID()!= null){
				rowUpdated = handler.executeUpdate(PM_IL_JL_AGE_FACTOR_BEAN, getConnection());
				if(rowUpdated > 0){
					String message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
					getWarningMap().put("current", message);
				}
			}else{
				rowUpdated = handler.executeInsert(bean, getConnection());
				if(rowUpdated > 0){
					String message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
					getWarningMap().put("current", message);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			getErrorMap().put("current", "can not inserted/updated");
		}return "";
	}*/

	public void lastColumnListener(){
		Connection connection = null;
		CRUDHandler handler = null;
		String rowId = null;
		int rowIndex = getDataTable().getRowIndex();
		PM_IL_JL_AGE_FACTOR factorBean = null;
		String successMessage = null;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				factorBean = fetchList.get(rowIndex);
				rowId = factorBean.getROWID();
				handler = new CRUDHandler();
				if (rowId != null) {
					PRE_UPDATE_PILM017();
					successMessage=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
				} else {
					PRE_INSERT_PILM017();
					successMessage=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
				}
				handler.executeInsert(factorBean, connection);
				getWarningMap().put("current", successMessage);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PM_IL_JL_AGE_FACTOR> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PM_IL_JL_AGE_FACTOR> fetchList) {
		this.fetchList = fetchList;
	}
	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public void executePreform(ActionEvent ae){
		getWarningMap().clear();
		Map<String, Object> session =FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
		//session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		//session.put("GLOBAL.M_USER_ID", "PREMIA");
		//session.put("GLOBAL.M_NAME", "PILM017");
		//session.put("GLOBAL.M_LANG_CODE", "ENG");
		//session.put("GLOBAL.M_PARA_1", "");
		//session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR2");
		//session.put("GLOBAL.M_MODULE_NAME", "Joint Life Age Factor");
		//session.put("GLOBAL.M_DFLT_VALUES", "00101    01");
		STD_PRE_FORM();
		getDummy().setDisabled(true);
	}
	public void STD_PRE_FORM(){
		ControlBean ctrlBean = CommonUtils.getControlBean();
		Map<String, Object> session =FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
		System.out.println("PM_IL_AGE_SLAB_ACTION.STD_PRE_FORM()???????? "+(String)session.get("GLOBAL.M_USER_ID"));
		//ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		//ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		//ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
	//	ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		//ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("PM_AGENT_BONUS_SETUP_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
		//ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		//session.put("ctrlbean", ctrlBean);
		System.out.println("PM_AGENT_BONUS_SETUP_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}
	public void PRE_INSERT_PILM017(){
		if( getErrorMap().size()>0){
			return;
		}
		try {

			ControlBean ctrlbean=CommonUtils.getControlBean();
			PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
			Date fromdate= factor.getJAF_EFF_FM_DT();
			Date todate= factor.getJAF_EFF_TO_DT();
			Integer ageto=factor.getJAF_DIFF_AGE_TO();
			Integer agefrom=factor.getJAF_DIFF_AGE_FROM();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			if(agefrom!=null && ageto!=null && fromDateStr!=null && toDateStr!=null ){
				String CURSORC1="SELECT 'X' FROM   PM_IL_JL_AGE_FACTOR "+
				"WHERE  (NVL(?,'01-JAN-1900')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900') OR NVL(?,'01-JAN-1900')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900')) "+
				"AND     NVL(?,'01-JAN-1900')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999') "+
				"AND     NVL(?,'31-DEC-2999')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900') "+
				"AND    (NVL(?,'31-DEC-2999')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999') OR NVL(?,'31-DEC-2999')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999'))"+
				"AND    (? >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM  OR ?  <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM) "+
				"AND     ? <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO "+
				"AND     ?   >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM "+
				"AND    (?   <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO    OR ?    >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO)";

				String M_DUMMY ="";
				PreparedStatement ps=CommonUtils.getConnection().prepareStatement(CURSORC1);
				ps.setString(1, fromDateStr);
				ps.setString(2, fromDateStr);
				ps.setString(3, fromDateStr);
				ps.setString(4, toDateStr);
				ps.setString(5,toDateStr);
				ps.setString(6, toDateStr);
				ps.setDouble(7, agefrom);
				ps.setDouble(8, agefrom);
				ps.setDouble(9, agefrom);
				ps.setDouble(10, ageto);
				ps.setDouble(11, ageto);
				ps.setDouble(12, ageto);

				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					M_DUMMY = rs.getString(1);
					System.out
							.println("############################### M_DUMMY = "
									+ M_DUMMY);
				}
				if (!"".equals(M_DUMMY) || "X".equals(M_DUMMY.trim())) {
					getErrorMap().put(
							"current",
							Messages.getMessage(
									PELConstants.pelErrorMessagePath, "91011")
									.getSummary());
					getErrorMap().put(
							"PRE_INSERT",
							Messages.getMessage(
									PELConstants.pelErrorMessagePath, "91011")
									.getSummary());
				} else {
					System.out
							.println("PM_IL_JL_AGE_FACTOR_ACTION.Pre insert %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					getErrorMap().remove("current");
					getErrorMap().remove("PRE_INSERT");
					factor.setJAF_CR_DT(new java.util.Date());
					factor.setJAF_CR_UID(ctrlbean.getM_USER_ID());
//					lastColumnListener();
				}
			}
			System.out
			.println("PM_IL_JL_AGE_FACTOR_ACTION.Pre insert   Mapppppppppp  )"+getErrorMap().get("current"));
		} catch (Exception e) {
			
		}  
	}
	public void PRE_UPDATE_PILM017() throws Exception{
		if( getErrorMap().size()>0){
			return;
		}
		try{
			Map<String, Object> session =FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			ControlBean ctrlbean=CommonUtils.getControlBean();
			PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
			Date fromdate= factor.getJAF_EFF_FM_DT();
			Date todate= factor.getJAF_EFF_TO_DT();
			Integer ageto=factor.getJAF_DIFF_AGE_TO();
			Integer agefrom=factor.getJAF_DIFF_AGE_FROM();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			if(agefrom!=null && ageto!=null && fromDateStr!=null && toDateStr!=null && factor.getROWID()!=null){
				String CURSORC1="SELECT 'X' FROM   PM_IL_JL_AGE_FACTOR "+
				"WHERE  JAF_DIFF_AGE_FROM = ? "+
				"AND    JAF_DIFF_AGE_TO   = ? "+
				"AND    (NVL(?,'01-JAN-1900')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900') OR NVL(?,'01-JAN-1900')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900')) "+
				"AND     NVL(?,'01-JAN-1900')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999') "+
				"AND     NVL(?,'31-DEC-2999')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_FM_DT,'01-JAN-1900') "+
				"AND    (NVL(?,'31-DEC-2999')  <= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999') OR NVL(?,'31-DEC-2999')  >= NVL(PM_IL_JL_AGE_FACTOR.JAF_EFF_TO_DT,'31-DEC-2999')) "+
				"AND    (? >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM  OR ?  <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM) "+
				"AND    ?  <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO "+
				"AND    ?   >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_FROM "+
				"AND    (?   <= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO OR ?  >= PM_IL_JL_AGE_FACTOR.JAF_DIFF_AGE_TO) "+
				"AND    ROWID <> ?";
				String M_DUMMY ="";
				PreparedStatement ps=CommonUtils.getConnection().prepareStatement(CURSORC1);
				ps.setDouble(1, agefrom);
				ps.setDouble(2, ageto);
				ps.setString(3, fromDateStr);
				ps.setString(4, fromDateStr);
				ps.setString(5,fromDateStr);
				ps.setString(6, toDateStr);
				ps.setString(7, toDateStr);
				ps.setString(8, toDateStr);
				ps.setDouble(9, agefrom);
				ps.setDouble(10, agefrom);
				ps.setDouble(11, agefrom);
				ps.setDouble(12, ageto);
				ps.setDouble(13, ageto);
				ps.setDouble(14, ageto);
				ps.setString(15, factor.getROWID());
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					M_DUMMY=rs.getString(1);
					System.out.println("&&&&&&&&&&&&&&&&&&&&& in preupdate M_DUMMY = "+M_DUMMY);
				}
				if(!"".equals(M_DUMMY)|| "X".equals(M_DUMMY.trim())){
					getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91011").getSummary());
					getErrorMap().put("PRE_UPDATE", Messages.getMessage(PELConstants.pelErrorMessagePath, "91011").getSummary());
				}else{
					getErrorMap().clear();
					factor.setJAF_UPD_DT(new java.util.Date());
					factor.setJAF_UPD_UID(ctrlbean.getM_USER_ID());
					//lastColumnListener();
				}}
			System.out
			.println("PM_IL_JL_AGE_FACTOR_ACTION.Pre UPDATE   Mapppppppppp  )"+getErrorMap().get("current"));
		} catch (Exception e) {

		}

	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public PM_IL_JL_AGE_FACTOR getGetTest() {
		return getTest;
	}

	public void setGetTest(PM_IL_JL_AGE_FACTOR getTest) {
		this.getTest = getTest;
	}
	public void WHEN_VALIDATE_JAF_DIFF_AGE_FROM(ActionEvent AE){
		try {
			CommonUtils.clearMaps(this);
			PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
			Integer ageto=factor.getJAF_DIFF_AGE_TO();
			Integer agefrom=factor.getJAF_DIFF_AGE_FROM();
			System.out
			.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_DIFF_AGE_FROM()>>"+ageto +""+agefrom);
			if(agefrom!=null && agefrom<0){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91022",new Object[]{"Age From"}).getSummary());
				getErrorMap().put("JAF_DIFF_AGE_FROM", Messages.getMessage(PELConstants.pelErrorMessagePath, "91022",new Object[]{"Age From"}).getSummary());

			}else if(agefrom!=null && ageto!=null && agefrom>0 && agefrom>ageto){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91031",new Object[]{"Age From"}).getSummary());
				getErrorMap().put("JAF_DIFF_AGE_FROM", Messages.getMessage(PELConstants.pelErrorMessagePath, "91031",new Object[]{"Age From"}).getSummary());

			}else{
				
				getErrorMap().remove("current");
				getErrorMap().remove("JAF_DIFF_AGE_FROM");
				getErrorMap().remove("JAF_DIFF_AGE_TO");
			}
		}catch(Exception e){
			e.printStackTrace();

		}
	}
	public void WHEN_VALIDATE_JAF_DIFF_AGE_TO(ActionEvent AE){
		try{
			CommonUtils.clearMaps(this);
			PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
			Integer ageto=factor.getJAF_DIFF_AGE_TO();
			Integer agefrom=factor.getJAF_DIFF_AGE_FROM();
			System.out
			.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_DIFF_AGE_TO()>>"+ageto +""+agefrom);
			if(ageto!=null && ageto<0 ){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91022",new Object[]{"Age To"}).getSummary());
				getErrorMap().put("JAF_DIFF_AGE_TO", Messages.getMessage(PELConstants.pelErrorMessagePath, "91022",new Object[]{"Age To"}).getSummary());

			}else if(ageto!=null && agefrom!=null && agefrom>ageto){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91032",new Object[]{"Age To"}).getSummary());
				getErrorMap().put("JAF_DIFF_AGE_TO", Messages.getMessage(PELConstants.pelErrorMessagePath, "91032",new Object[]{"Age To"}).getSummary());

			}else{
				getErrorMap().remove("current");
				getErrorMap().remove("JAF_DIFF_AGE_TO");
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void WHEN_VALIDATE_JAF_AGE_FACTOR(ActionEvent AE){
		try{
			CommonUtils.clearMaps(this);
			PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
			Double agefacor=factor.getJAF_AGE_FACTOR();
			if(agefacor!=null && agefacor<0){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91026",new Object[]{"Age Factor"}).getSummary());
				getErrorMap().put("JAF_AGE_FACTOR", Messages.getMessage(PELConstants.pelErrorMessagePath, "91026",new Object[]{"Age Factor"}).getSummary());
			}else{
				if(getErrorMap().isEmpty()){
				getErrorMap().remove("current");
				getErrorMap().remove("JAF_AGE_FACTOR");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String WHEN_VALIDATE_JAF_EFF_FM_DT() throws ParseException{
		PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
		Date fromdate= factor.getJAF_EFF_FM_DT();
		Date todate= factor.getJAF_EFF_TO_DT();
		if(fromdate!=null && todate!=null){
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			Date fDate = format.parse(NVL(fromDateStr, "01-JAN-1900"));
			Date tDate = format.parse(NVL(toDateStr, "31-DEC-2999"));
			System.out
					.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_FM_DT()>>>"+ fDate+"<><>"+tDate);
			if(fDate.after(tDate)){
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"91010",new Object[]{"From Date"}).getSummary());
				getErrorMap().put("JAF_EFF_FM_DT", Messages.getMessage(PELConstants.pelErrorMessagePath,"91010",new Object[]{"From Date"}).getSummary());
			}else{
				if(getErrorMap().isEmpty()){
				getErrorMap().remove("current");
				getErrorMap().remove("JAF_EFF_FM_DT");
				}
			}} return "";	
		 
	}
	public String WHEN_VALIDATE_JAF_EFF_TO_DT() throws Exception{
		PM_IL_JL_AGE_FACTOR factor = (PM_IL_JL_AGE_FACTOR) dataTable.getRowData();
		Date fromdate= factor.getJAF_EFF_FM_DT();
		Date todate= factor.getJAF_EFF_TO_DT();
		if(fromdate!=null && todate!=null){
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			String fromDateStr = format.format(fromdate);
			String toDateStr = format.format(todate);
			Date fDate = format.parse(NVL(fromDateStr, "01-JAN-1900"));
			Date tDate = format.parse(NVL(toDateStr, "31-DEC-2999"));
			System.out
			.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT()>>>"+fDate +""+tDate +"777"+fDate.before(tDate));
			if(fDate.after(tDate)){
				System.out
				.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT() in if loop ");
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"91010",new Object[]{"To Date"}).getSummary());
				getErrorMap().put("JAF_EFF_TO_DT", Messages.getMessage(PELConstants.pelErrorMessagePath,"91010",new Object[]{"To Date"}).getSummary());
			} else {
				if (getErrorMap().isEmpty()) {
					getErrorMap().remove("current");
					getErrorMap().remove("JAF_EFF_TO_DT");
				}
				// Commented for LastColumnListerer SHANKAR BODDULURI 
				/*if (factor.getROWID() != null) {
					PRE_UPDATE_PILM017();
				} else {
					PRE_INSERT_PILM017();
				}*/
			}
		}

		System.out
		.println("PM_IL_JL_AGE_FACTOR_ACTION.WHEN_VALIDATE_JAF_EFF_TO_DT()curent map "+getErrorMap().get("current"));
		return "";	
	}
	public static  String NVL(String str,String assign){
		if("".equals(str) || str.length()==0){
			str=assign;
		}
		return str;
	}

	public String goSearch(){
		return "PILM017SEARCH";
	}
	
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

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
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 13-Feb-2009

}

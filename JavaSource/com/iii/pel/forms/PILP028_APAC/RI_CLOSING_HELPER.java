package com.iii.pel.forms.PILP028_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class RI_CLOSING_HELPER {
	
	public Object P_SET_FIRST_FIELD(Object comp1){
	
		String M_FIELD_DATA= null; 
		if(comp1!=null){
			if(comp1 instanceof String || comp1 instanceof Integer || comp1 instanceof Double){
				M_FIELD_DATA="0";
			}
			comp1 = M_FIELD_DATA;
		}
		return comp1;
	}
	
	public void L_VAL_FROM_TO(Object comp1, Object comp2)throws Exception{
		if(comp1==null || "".equalsIgnoreCase(comp1.toString())){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80033"));
		}
		if(comp2!=null && !comp2.toString().trim().equals(""))
			if(comp2.toString().compareTo(comp1.toString()) < 0){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80034"));
			}
	}

	
	public Object P_SET_SECOND_FIELD(Object comp1, Object comp2) throws Exception{
		String M_FIELD_DATA= null, M_FIELD_DATA_1 =  null;
		try {
			
			if(comp2==null || "".equalsIgnoreCase(comp2.toString())){
				if(comp1 instanceof String || comp1 instanceof Integer || comp1 instanceof Double){
					M_FIELD_DATA="0";
					comp1 = M_FIELD_DATA;
				}
				
				if(comp1 instanceof String){
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz";
					comp2 = M_FIELD_DATA;
				}else if(comp2 instanceof Integer || comp2 instanceof Double){
					M_FIELD_DATA="9999999999999999999999";
					comp2 = M_FIELD_DATA;
				}
			}
			
			if(comp2 instanceof String){
				if(comp2.toString().compareTo(comp1.toString()) < 0 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				}
			}else{
				if(comp2 instanceof Integer){
					if(Integer.parseInt(comp1.toString()) > Integer.parseInt(comp2.toString())){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return comp2;
	}

	public void RI_CLOSING_M_RI_CLOCING_OK_BUTTON_PRESSED(RI_CLOSING_ACTION action,ActionEvent event) throws Exception{

		RI_CLOSING ri_closing = action.getRI_CLOSING_BEAN();
		Connection connection = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String M_PARAM_1 = (String) session.getAttribute("GLOBAL.M_PARAM_1");
		String fromDate1 = CommonUtils.dateToStringFormatter(ri_closing.getUI_M_RI_FM_DT());
		String toDate = CommonUtils.dateToStringFormatter(ri_closing.getUI_M_RI_TO_DT());
		try {
			connection = CommonUtils.getConnection();
			if ("C".equalsIgnoreCase(M_PARAM_1)) {
				
				P_RI_CLOSING(ri_closing.getUI_M_TREATY_CODE(),ri_closing.getUI_M_PERIOD(), 
							 ri_closing.getUI_M_SRNO(), ri_closing.getUI_M_ASSR_CODE_FM(),
							 ri_closing.getUI_M_ASSR_CODE_TO(), ri_closing.getUI_M_RI_FM_DT(),
							 ri_closing.getUI_M_RI_TO_DT());
				
				
				P_RI_CLOSE(	ri_closing.getUI_M_TREATY_CODE(),ri_closing.getUI_M_PERIOD(),
							ri_closing.getUI_M_SRNO(), ri_closing.getUI_M_ASSR_CODE_FM(), 
							ri_closing.getUI_M_ASSR_CODE_TO(),  ri_closing.getUI_M_RI_TO_DT());
				
			} else if ("O".equalsIgnoreCase(M_PARAM_1)) {
				P_RI_OPENING(ri_closing.getUI_M_TREATY_CODE(),ri_closing.getUI_M_PERIOD(), 
						 ri_closing.getUI_M_SRNO(), ri_closing.getUI_M_ASSR_CODE_FM(),
						 ri_closing.getUI_M_ASSR_CODE_TO(), ri_closing.getUI_M_RI_FM_DT(),
						 ri_closing.getUI_M_RI_TO_DT());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), action.getCOMP_UI_M_RI_CLOSING_OK().getId(), action.getErrorMap());
			
		}


	}

	public static void treatyCodeWhenValidate(String treatyCode)throws Exception, SQLException, Exception {

		CommonUtils commonUtils = new CommonUtils();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet vembu_C1 = null;
		String M_DUMMY = null;
		try {

			String sql_C1 = "SELECT 'X'  FROM  PM_IL_PROP_TREATY  WHERE  PT_TREATY_CODE  = '" + treatyCode + "' ";
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
			if (vembu_C1.next()) {
				M_DUMMY = vembu_C1.getString(1);
			}
			System.out.println("Dummy is "+M_DUMMY);
			if (M_DUMMY==null) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80024"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(vembu_C1);} catch (Exception e) {}}
	}

	public void sNoWhenValidate(String treatyCode, Integer serialNo)throws Exception, SQLException, Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet vembu_C1 = null;
		String M_DUMMY = "N";
		int M_PPTP_SUB_NO = 1;
		
		try {
			String sql_C1 = "SELECT PPTP_SUB_NO FROM  PM_IL_PROP_TREATY_PERIOD   WHERE  PPTP_PT_TREATY_CODE  =  ?  ";
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{treatyCode});
			while(vembu_C1.next()) {
				M_PPTP_SUB_NO = vembu_C1.getInt(1);
				if(serialNo == M_PPTP_SUB_NO) {
					M_DUMMY = "Y";
					break;
				}
			}
			if(M_DUMMY != null) {
				if(M_DUMMY.equals("" + "N")) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91460"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(vembu_C1);} catch (Exception e) {}}

	}

	public static void closingPeriodWhenValidate(Integer period) throws Exception, SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet vembu_C1 = null;
		try {
			Integer M_YEAR = -1;
			String sql_C1 = "SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'RRRR')) FROM  DUAL  ";
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
			if (vembu_C1.next()) {
				M_YEAR = vembu_C1.getInt(1);
			}
			vembu_C1.close();
			if (period > M_YEAR) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "20307"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(vembu_C1);} catch (Exception e) {}}
	}

	public void assrCodeWhenValidate(String assCodeFrom)throws  Exception{
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String M_DUMMY = null;
		try {
			String sql_C1 = " SELECT 'X' FROM  PM_IL_CONTRACTOR  WHERE CONT_CODE  =	 ? ";
			if (assCodeFrom != null && !assCodeFrom.equalsIgnoreCase("0")) {
				resultSet = handler.executeSelectStatement(sql_C1, connection, new Object[]{assCodeFrom});
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91121"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
	}

	public  void assrCodeToWhenValidate(String assrCodeTo)throws  Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String M_DUMMY =null;
		try {
			String sql_C1 = " SELECT 'X' FROM  PM_IL_CONTRACTOR WHERE CONT_CODE =  ? ";
			if (assrCodeTo != null && !assrCodeTo.startsWith("zzzzzzzzz")) {
				resultSet = handler.executeSelectStatement(sql_C1, connection,new Object[]{assrCodeTo});
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91121"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
	}
		
	
	public  void defaultDates(RI_CLOSING RI_CLOSING_BEAN)throws  Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_DUMMY =null;
		Integer mon_fm=0;
		Integer mon_to=0;
		
			String sql_C1 = " SELECT PPTP_MON_FM,PPTP_MON_TO FROM  PM_IL_PROP_TREATY_PERIOD WHERE PPTP_PT_TREATY_CODE = ? "+
                             " AND PPTP_SUB_NO =  ? ";
			String sql_C2= "SELECT TO_DATE('01/' || ? || '/' || ?, 'DD/MM/RRRR') FROM DUAL ";
			
			String sql_C3=" SELECT LAST_DAY(TO_DATE('01/' || ? || '/' || ?, 'DD/MM/RRRR')) FROM DUAL";
			
			try{
				connection = CommonUtils.getConnection();
				rs=handler.executeSelectStatement(sql_C1, connection, new Object []{ RI_CLOSING_BEAN.getUI_M_TREATY_CODE(),RI_CLOSING_BEAN.getUI_M_SRNO() });
				if(rs.next()){
					mon_fm=rs.getInt(1);
					mon_to=rs.getInt(2);
				}
				rs1=handler.executeSelectStatement(sql_C2, connection, new Object []{ mon_fm,RI_CLOSING_BEAN.getUI_M_PERIOD() });
				if(rs1.next()){
					RI_CLOSING_BEAN.setUI_M_RI_FM_DT(rs1.getDate(1));
				}
				rs2=handler.executeSelectStatement(sql_C3, connection, new Object []{ mon_to,RI_CLOSING_BEAN.getUI_M_PERIOD() });
				if(rs2.next()){
					RI_CLOSING_BEAN.setUI_M_RI_TO_DT(rs2.getDate(1));
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(rs);} catch (Exception e) {}}
	}


    /**
      *
      * @param P_TREATY_CODE-IN
      * @param P_YEAR-IN
      * @param P_RI_PRD-IN
      * @param P_ASSR_CODE_FM-IN
      * @param P_ASSR_CODE_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_CLOSING(
                      Object P_TREATY_CODE,
           Object P_YEAR,
           Object P_RI_PRD,
           Object P_ASSR_CODE_FM,
           Object P_ASSR_CODE_TO,
           Object P_FM_DT,
           Object P_TO_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TREATY_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_YEAR);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_RI_PRD);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_FM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_TO);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_RI_ALLOC.P_RI_CLOSING");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    
    
    /**
    *
    * @param P_TREATY_CODE-IN
    * @param P_YEAR-IN
    * @param P_RI_PRD-IN
    * @param P_ASSR_CODE_FM-IN
    * @param P_ASSR_CODE_TO-IN
    * @param P_RI_TO_DT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_RI_CLOSE(
                    Object P_TREATY_CODE,
         Object P_YEAR,
         Object P_RI_PRD,
         Object P_ASSR_CODE_FM,
         Object P_ASSR_CODE_TO,
         Object P_RI_TO_DT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TREATY_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_YEAR);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_RI_PRD);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_FM);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_TO);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_RI_TO_DT);
          parameterList.add(param6);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_RI_CLOSE.P_RI_CLOSE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }


  /**
  *
  * @param P_TREATY_CODE-IN
  * @param P_YEAR-IN
  * @param P_RI_PRD-IN
  * @param P_ASSR_CODE_FM-IN
  * @param P_ASSR_CODE_TO-IN
  * @param P_FM_DT-IN
  * @param P_TO_DT-IN
  *
  * @return ArrayList of type Oracle Parameter
  * @throws Exception
  */
public ArrayList<OracleParameter> P_RI_OPENING(
                  Object P_TREATY_CODE,
       Object P_YEAR,
       Object P_RI_PRD,
       Object P_ASSR_CODE_FM,
       Object P_ASSR_CODE_TO,
       Object P_FM_DT,
       Object P_TO_DT) throws ProcedureException {
     Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TREATY_CODE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_YEAR);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_RI_PRD);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_FM);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE_TO);
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
        parameterList.add(param7);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_RI_ALLOC.P_RI_OPENING");
     } catch(Exception e) {
     	ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
     }
    return outputList;
}

	
	
	

}
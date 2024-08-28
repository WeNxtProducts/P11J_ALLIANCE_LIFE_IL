package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_ACTION_TRIGGERS extends CommonAction{

	boolean validate_Error = false;

	public PT_IL_PREM_COLL_ACTION_TRIGGERS() {
		

	}

	String CURSOR1_PC_FC_BASIC_PREM;
	String M_DUMMY;
	CRUDHandler handler;
	Connection connection = null;

	Date PT_IL_PREM_COLL_PC_PAID_DT;

	CommonUtils util = new CommonUtils();

	DateFormat formatter;
	
	
	String PC_PAID_DT;
	String PC_SYS_ID;
	String component_Name ="Component Name";

	/*
	 * The following Triggers Look Alike in D2k Forms so its been Combined into
	 * one method 
	 * PC_FC_BASIC_PREM,PC_LC_BASIC_PREM,PC_FC_ADDL_PREM
	 * ,PC_LC_ADDL_PREM,PC_FC_LOAD_AMT ,PC_LC_LOAD_AMT PC_FC_GROSS_PREM ,PC_LC_GROSS_PREM,PC_FC_CHARGE_AMT
	 * ,PC_LC_CHARGE_AMT
	 * 
	 */
	
	
	public boolean when_Validate_Item_For_All(String component_Name) {
		
		PT_IL_POLICY pt_POLICY = new PT_IL_POLICY();

		PT_IL_PREM_COLL pt_Prem_Coll = new PT_IL_PREM_COLL();
		
		formatter = new SimpleDateFormat(PELConstants.dbDateFormat);
		
		String message;
		PC_PAID_DT = formatter.toString();
		PC_SYS_ID = pt_Prem_Coll.getPC_SYS_ID()+"";
		
		// use this component to get the name from the properties file to show in the error panel.
		this.component_Name = component_Name;
		

		CURSOR1_PC_FC_BASIC_PREM = " SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"
				+ pt_POLICY.getPOL_SYS_ID()
				+ "' AND    PC_PAID_DT   > '"
				+ PC_PAID_DT + "' AND PC_SYS_ID < '" + PC_SYS_ID + "'";

		
		if (!pt_Prem_Coll.getPC_PAID_DT().equals(null)) {
			try {
				connection = CommonUtils.getConnection();
				ResultSet rs = handler.executeSelectStatement(
						CURSOR1_PC_FC_BASIC_PREM, connection);

				while (rs.next()) {
					M_DUMMY = rs.getString(1);
					message = Messages.getString(
							PELConstants.pelErrorMessagePath, "71075");
					getErrorMap().put(component_Name, message);
					// STD_MESSAGE_ROUTINE (71075, :CTRL.M_LANG_CODE);
					validate_Error = true;
				}
			} catch (SQLException sqlException) {
				// TODO: handle exception
				sqlException.printStackTrace();
			} catch (DBException dbException) {
				// TODO: handle exception
				dbException.printStackTrace();
			}
		}

		// need to get the System date from the DB
		try {
			if (pt_Prem_Coll.getPC_PAID_DT().after(util.getCurrentDate())) {
				message = Messages.getString(
						PELConstants.pelErrorMessagePath, "71030");
				getErrorMap().put(component_Name, message);
				// STD_MESSAGE_ROUTINE (71030, :CTRL.M_LANG_CODE);
				validate_Error = true;
			}
		} catch (ParseException parseException) {
			// TODO: handle exception
			parseException.printStackTrace();
		}

		return validate_Error;
	}	
	
	
}

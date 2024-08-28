package com.iii.pel.forms.PILP_STP;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;




public class DUMMY_HELPER {
	public String ValidateUI_M_PROD(String PROD_CODE) throws Exception {
		try {
			return L_VAL_PROD(PROD_CODE);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public String  L_VAL_PROD(String  PROD_CODE) throws Exception {
		String CURSOR_C1 = "SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? " ;
		String PROD_DESC = null;
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection() , new Object[] {PROD_CODE});
			if (resultSet.next()) {
				PROD_DESC = resultSet.getString(1);
			}else {
				throw new Exception("Product Code does not Exists!Please Re-enter");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {CommonUtils.closeCursor(resultSet);}
		
		return PROD_DESC;
	}	

	
	
	
	
	public void validateUI_M_PROP_NO(String POL_NO) throws Exception {
		try {
			V_VAL_POL_CHECK(POL_NO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void V_VAL_POL_CHECK(String POL_NO) throws Exception {
		ResultSet resultSet = null;
		String Query = "SELECT POL_NO  FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection() , new Object[] {POL_NO});
			if (resultSet.next()) {
				POL_NO = resultSet.getString(1);
			}else {
				throw new Exception("Invalid Policy/Proposal!Please Re-enter");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	public void validateUI_M_TO_DT(DUMMY dummy) throws Exception{
		try {
			if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
			if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenCreateRecord(DUMMY dummy) throws Exception {
		try {
			dummy.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
			dummy.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void validateUI_M_FM_DT(DUMMY dummy) throws Exception{
		try {
			if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
			if (dummy.getUI_M_FM_DT().after(new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}

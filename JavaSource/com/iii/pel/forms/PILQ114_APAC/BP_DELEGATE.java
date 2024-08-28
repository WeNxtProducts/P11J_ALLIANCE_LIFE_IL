package com.iii.pel.forms.PILQ114_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class BP_DELEGATE {
	public void executeSelectStatement(
			PILQ114_APAC_COMPOSITE_ACTION PILQ114_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, BP.* FROM BP WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			BP BP_BEAN = new BP();
			/*while (resultSet.next()) {
				BP_BEAN.setROWID(resultSet.getString("ROWID"));
				BP_BEAN.setBPID(resultSet.getDouble("BPID"));
				BP_BEAN.setBPNAME(resultSet.getString("BPNAME"));
				BP_BEAN.setBPTYPE(resultSet.getString("BPTYPE"));
				BP_BEAN.setADDRESS1(resultSet.getString("ADDRESS1"));
				BP_BEAN.setMAKERID(resultSet.getString("MAKERID"));
				BP_BEAN.setMAKEDATE(resultSet.getDate("MAKEDATE"));
				BP_BEAN.setSTATUS(resultSet.getString("STATUS"));
				BP_BEAN.setAUTHORID(resultSet.getString("AUTHORID"));
				BP_BEAN.setAUTHDATE(resultSet.getDate("AUTHDATE"));
				BP_BEAN.setCOUNTRYCODE(resultSet.getDouble("COUNTRYCODE"));
				BP_BEAN.setSTATECODE(resultSet.getDouble("STATECODE"));
				BP_BEAN.setLOCATIONCODE(resultSet.getDouble("LOCATIONCODE"));
				BP_BEAN.setMINSCRIP(resultSet.getDouble("MINSCRIP"));
				BP_BEAN.setMAXSCRIP(resultSet.getDouble("MAXSCRIP"));
				BP_BEAN.setONESCRIPCONT(resultSet.getDouble("ONESCRIPCONT"));
				BP_BEAN.setCOMPANYID(resultSet.getDouble("COMPANYID"));
				BP_BEAN.setPROFIDEMINITYAMT(resultSet
						.getDouble("PROFIDEMINITYAMT"));
				BP_BEAN.setPARENTBPID(resultSet.getDouble("PARENTBPID"));
				BP_BEAN
						.setCG_PAYMENTMODE(resultSet
								.getDouble("CG_PAYMENTMODE"));
				BP_BEAN
						.setDDASTARTNUMBER(resultSet
								.getDouble("DDASTARTNUMBER"));
				BP_BEAN.setDDAENDNUMBER(resultSet.getDouble("DDAENDNUMBER"));
				BP_BEAN.setDDALASTNUMBER(resultSet.getDouble("DDALASTNUMBER"));
				BP_BEAN.setCG_BPNATIONALITY(resultSet
						.getDouble("CG_BPNATIONALITY"));
				BP_BEAN.setCG_BPECONOMIC(resultSet.getDouble("CG_BPECONOMIC"));
				BP_BEAN.setCG_BPSUBCATG(resultSet.getDouble("CG_BPSUBCATG"));
				BP_BEAN.setEMPLOYEDSINCE(resultSet.getDate("EMPLOYEDSINCE"));
				BP_BEAN.setLASTREVIEWED(resultSet.getDate("LASTREVIEWED"));
				BP_BEAN.setCONTACTPERSON(resultSet.getString("CONTACTPERSON"));
				BP_BEAN.setDESIGNATION(resultSet.getString("DESIGNATION"));
				BP_BEAN.setADDRESS2(resultSet.getString("ADDRESS2"));
				BP_BEAN.setADDRESS3(resultSet.getString("ADDRESS3"));
				BP_BEAN.setADDRESS4(resultSet.getString("ADDRESS4"));
				BP_BEAN.setLANDMARK(resultSet.getString("LANDMARK"));
				BP_BEAN.setZIPCODE(resultSet.getString("ZIPCODE"));
				BP_BEAN.setPHONE1(resultSet.getString("PHONE1"));
				BP_BEAN.setPHONE2(resultSet.getString("PHONE2"));
				BP_BEAN.setPAGER(resultSet.getString("PAGER"));
				BP_BEAN.setMOBILE(resultSet.getString("MOBILE"));
				BP_BEAN.setFAX(resultSet.getString("FAX"));
				BP_BEAN.setEMAIL(resultSet.getString("EMAIL"));
				BP_BEAN.setREMARKS(resultSet.getString("REMARKS"));
				BP_BEAN.setCOUNTRY(resultSet.getString("COUNTRY"));
				BP_BEAN.setSTATE(resultSet.getString("STATE"));
				BP_BEAN.setLOCATION(resultSet.getString("LOCATION"));
				BP_BEAN.setLEGACYCODE1(resultSet.getString("LEGACYCODE1"));
				BP_BEAN.setLEGACYCODE2(resultSet.getString("LEGACYCODE2"));
				BP_BEAN.setISAPPROVEDFORSUBSIDY(resultSet
						.getString("ISAPPROVEDFORSUBSIDY"));
				BP_BEAN.setACCOUNTNAME(resultSet.getString("ACCOUNTNAME"));
				BP_BEAN.setBANKCODE(resultSet.getString("BANKCODE"));
				BP_BEAN.setBRANCHCODE(resultSet.getString("BRANCHCODE"));
				BP_BEAN.setACCNO(resultSet.getString("ACCNO"));
				BP_BEAN.setCITYCODE(resultSet.getString("CITYCODE"));
				BP_BEAN.setBANKNAME(resultSet.getString("BANKNAME"));
				BP_BEAN.setLEGACYCODE3(resultSet.getString("LEGACYCODE3"));
				BP_BEAN.setBPNAME2(resultSet.getString("BPNAME2"));
				BP_BEAN.setBPNAME3(resultSet.getString("BPNAME3"));
				BP_BEAN.setTAXNUMBER(resultSet.getString("TAXNUMBER"));
				BP_BEAN.setFIRST_DIRNAME(resultSet.getString("FIRST_DIRNAME"));
				BP_BEAN
						.setSECOND_DIRNAME(resultSet
								.getString("SECOND_DIRNAME"));
				BP_BEAN.setTHIRD_DIRNAME(resultSet.getString("THIRD_DIRNAME"));
				BP_BEAN.setCHIEF_ACCOUNTANT(resultSet
						.getString("CHIEF_ACCOUNTANT"));
				BP_BEAN
						.setMIN_SAFETY_NET(resultSet
								.getDouble("MIN_SAFETY_NET"));
				BP_BEAN.setCG_BILLINGCYCLE(resultSet
						.getDouble("CG_BILLINGCYCLE"));
				BP_BEAN.setCG_CURRENCY(resultSet.getDouble("CG_CURRENCY"));
				BP_BEAN.setCG_DISTRICTCODE(resultSet
						.getDouble("CG_DISTRICTCODE"));
				BP_BEAN.setCG_IDTYPE(resultSet.getDouble("CG_IDTYPE"));
				BP_BEAN.setIDNUMBER(resultSet.getString("IDNUMBER"));
				BP_BEAN.setPOSTCODE(resultSet.getString("POSTCODE"));
				BP_BEAN.setGL_ACCNTCODE(resultSet.getString("GL_ACCNTCODE"));
				BP_BEAN.setDATAMIGCOL(resultSet.getString("DATAMIGCOL"));

			}*/
			PILQ114_APAC_COMPOSITE_ACTION_BEAN.getBP_ACTION_BEAN().setBP_BEAN(
					BP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
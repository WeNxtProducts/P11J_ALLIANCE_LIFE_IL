package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_HEAD_DELEGATE {
	
	
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		/* Modified by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 27-01-2016*/
		String selectStatement = "SELECT ROWID, PT_IL_POL_BROKER_HEAD.* FROM "
				+ "PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? ORDER BY POBH_AGENT_HEIRCHY,POBH_SRNO";
		/*End*/
		/* Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 27-01-2016*/
		String Type_query="SELECT DECODE(POBH_SRNO,1,'Basic','Override') COMM_TYPE FROM "
				+ "PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? AND POBH_BROKER_CODE = ?";
		/*End*/
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet3=null;
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_HEAD().clear();
		PT_IL_POL_BROKER_HEAD_HELPER helper = null;
		List<Double> commValuesList = new ArrayList<Double>();
		try {
			helper = new PT_IL_POL_BROKER_HEAD_HELPER();
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });

			while (resultSet.next()) {
				if (!(commValuesList.isEmpty()) && commValuesList.size() > 0) {
					commValuesList.clear();
				}

				PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();

				PT_IL_POL_BROKER_HEAD_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SYS_ID(resultSet
						.getLong("POBH_SYS_ID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_POL_SYS_ID(resultSet
						.getLong("POBH_POL_SYS_ID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CODE(resultSet
						.getString("POBH_BROKER_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COVER_CODE(resultSet
						.getString("POBH_COVER_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CURR_CODE(resultSet
						.getString("POBH_BROKER_CURR_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REMARKS(resultSet
						.getString("POBH_REMARKS"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_DEL_FLAG(resultSet
						.getString("POBH_DEL_FLAG"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_DT(resultSet
						.getDate("POBH_CR_DT"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_UID(resultSet
						.getString("POBH_CR_UID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_DT(resultSet
						.getDate("POBH_UPD_DT"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_UID(resultSet
						.getString("POBH_UPD_UID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COMM_CODE(resultSet
						.getString("POBH_COMM_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SRNO(resultSet
						.getInt("POBH_SRNO"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_APPLY_ON_SRNO(resultSet
						.getInt("POBH_APPLY_ON_SRNO"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_ACTING_AGENT_YN(resultSet
						.getString("POBH_ACTING_AGENT_YN"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_RANK_CODE(resultSet
						.getString("POBH_AGENT_RANK_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_LEVEL(resultSet
						.getInt("POBH_AGENT_LEVEL"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_MKT_CODE(resultSet
						.getString("POBH_MKT_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UNIT_CODE(resultSet
						.getString("POBH_UNIT_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_BRANCH_CODE(resultSet
						.getString("POBH_AGENCY_BRANCH_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REGION_CODE(resultSet
						.getString("POBH_REGION_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_CODE(resultSet
						.getString("POBH_AGENCY_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_RECRUITER_CODE(resultSet
						.getString("POBH_RECRUITER_CODE"));
				/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 20-12-2016	*/
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SHARE_PERC(resultSet
						.getDouble("POBH_SHARE_PERC"));
				/*eND*/
				/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_PARENT_BROKER(resultSet
						.getString("POBH_PARENT_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_HEIRCHY(resultSet
						.getString("POBH_AGENT_HEIRCHY"));
				/*End*/
				//ADDED BY SARNYA FOR EMAIL CAPTURE ON 13-04-2016
				PT_IL_POL_BROKER_HEAD_BEAN.setMAIL_ID(resultSet
						.getString("POBH_EMAIL_ID"));				
				System.out.println("value of setMAIL_ID"+PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID());
				Map<String, Object> session1 = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				session1.put("GLOBAL_BRO_MAIL_ID", PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID());
				System.out.println("global session broker id"+session1.get("GLOBAL_BRO_MAIL_ID"));
				//END
				/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-01-2017 */
				resultSet3=new CRUDHandler().executeSelectStatement(Type_query, connection,
						new Object[] {PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_POL_SYS_ID(),PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()
						});
				while(resultSet3.next()){
				
				PT_IL_POL_BROKER_HEAD_BEAN.setUI_M_COMM_TYPE(resultSet3
						.getString("COMM_TYPE"));
				}
				/*End*/

				commValuesList = helper.getCommisionVals(
						PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_POL_SYS_ID(),
						PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE(),
						PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_COVER_CODE());
				if (!(commValuesList.isEmpty()) && commValuesList.size() > 0) {
					PT_IL_POL_BROKER_HEAD_BEAN
							.setUI_M_FC_COMMISSION(commValuesList.get(0));
					PT_IL_POL_BROKER_HEAD_BEAN
							.setUI_M_LC_COMMISSION(commValuesList.get(1));
				}

				/*Added by raja on 17.04.2017 for hands-on-feedback comment*/ 
				if(PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()!=null)
				{
				String Querys="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Querys, connection, 
						new Object[]{PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()});
				while(rs.next())
				{
					PT_IL_POL_BROKER_HEAD_BEAN.setUI_M_POBH_BROKER_DESC(rs.getString("CUST_NAME"));
				}
				}
				/*ENd*/
				
				
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getDataList_PT_IL_POL_BROKER_HEAD().add(
								PT_IL_POL_BROKER_HEAD_BEAN);
			}
		}   catch (Exception exception) {
		      exception.printStackTrace();
		      throw new Exception(exception.getMessage());
		    } finally {
		      CommonUtils.closeCursor(resultSet);
		    }
		  }

}

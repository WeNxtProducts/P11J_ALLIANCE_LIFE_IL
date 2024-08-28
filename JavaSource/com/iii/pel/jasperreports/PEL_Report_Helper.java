package com.iii.pel.jasperreports;




import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;



public class PEL_Report_Helper
{
	public Map<Object,Object> before_Report_Trigger(Connection connection,String REP_KEY_NO,String lang_Code,String COMP_CODE,
													String CURR_CODE,String REP_ID	)
	{
				IP_REP_INFO ip_rep_info=new IP_REP_INFO();
				COL_LABELS  col_labels=new COL_LABELS();
				REPORT_PARAMS report_params=new REPORT_PARAMS();
				PARAM_LIST param_list=new PARAM_LIST();
				
				int RBH_ID=0;;
				ResultSet resultSet=null;
				ResultSet resultSet1=null;
				ResultSet resultSet2=null;
				ResultSet resultSet3=null;
				ResultSet resultSet4=null;
				ResultSet resultSet5=null;
				ResultSet resultSet6=null;
				
				Map<Object,Object> objectMap=null;
				
				/*String lang_Code=CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
				String COMP_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE");
				String CURR_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_CURR_CODE");
				String REP_ID=ip_rep_info.getREP_ID();*/
				try
				{
						
						CRUDHandler handler=new CRUDHandler();
						resultSet=handler.executeSelectStatement(Reports_SQL_Query_Constants.SELECT_DETAILS_FROM_IP_REP_INFO,
																	connection,
																	new Object[]{REP_KEY_NO});
						if(resultSet.next()){
							report_params.setRepName(resultSet.getString("REP_ID"));
							report_params.setLoginuserName(resultSet.getString("REP_CR_UID")); 
						}
						report_params.setLangCode(lang_Code);
						report_params.setBaseCurrCode(CURR_CODE);
						String  langCode=report_params.getLangCode();
						resultSet1=handler.executeSelectStatement(Reports_SQL_Query_Constants.PP_REPORT_BP_HEAD,
																	connection,
																	new Object[]{langCode,langCode,langCode,langCode,
																	langCode,langCode,REP_ID});
						while(resultSet1.next())
						{
							RBH_ID=resultSet1.getInt("RBH_ID");
							report_params.setRepTitle2(resultSet1.getString("C1_TITLE2"));
							report_params.setRepTitle3(resultSet1.getString("C1_TITLE3"));
							report_params.setRepRunTime(resultSet1.getString("C1_DATE"));
							report_params.setLoginuser(resultSet1.getString("C1_USER"));
							report_params.setPageno(resultSet1.getString("C1_PAGE"));
							report_params.setRepID(resultSet1.getString("C1_REPID"));
						}
						
						Object obj[]=new Object[63];
						for(int arrayIdx=0;arrayIdx<62;arrayIdx++)
						{
							obj[arrayIdx]=langCode;
						}
						obj[62]=RBH_ID;
						resultSet2=handler.executeSelectStatement(Reports_SQL_Query_Constants.PP_REPORT_BP_COL,
																		connection, obj);
						while(resultSet2.next())
						{
							col_labels.setColLabel01(resultSet2.getString("C2_HEAD1"));
							col_labels.setColLabel02(resultSet2.getString("C2_HEAD2"));
							col_labels.setColLabel03(resultSet2.getString("C2_HEAD3"));
							col_labels.setColLabel04(resultSet2.getString("C2_HEAD4"));
							col_labels.setColLabel05(resultSet2.getString("C2_HEAD5"));
							col_labels.setColLabel06(resultSet2.getString("C2_HEAD6"));
							col_labels.setColLabel07(resultSet2.getString("C2_HEAD7"));
							col_labels.setColLabel08(resultSet2.getString("C2_HEAD8"));
							col_labels.setColLabel09(resultSet2.getString("C2_HEAD9"));
							col_labels.setColLabel10(resultSet2.getString("C2_HEAD10"));
							col_labels.setColLabel11(resultSet2.getString("C2_HEAD11"));
							col_labels.setColLabel12(resultSet2.getString("C2_HEAD12"));
							col_labels.setColLabel13(resultSet2.getString("C2_HEAD13"));
							col_labels.setColLabel14(resultSet2.getString("C2_HEAD14"));
							col_labels.setColLabel15(resultSet2.getString("C2_HEAD15"));
							col_labels.setColLabel16(resultSet2.getString("C2_HEAD16"));
							col_labels.setColLabel17(resultSet2.getString("C2_HEAD17"));
							col_labels.setColLabel18(resultSet2.getString("C2_HEAD18"));
							col_labels.setColLabel19(resultSet2.getString("C2_HEAD19"));
							col_labels.setColLabel20(resultSet2.getString("C2_HEAD20"));
							col_labels.setColLabel21(resultSet2.getString("C2_HEAD21"));
							col_labels.setColLabel22(resultSet2.getString("C2_HEAD22"));
							col_labels.setColLabel23(resultSet2.getString("C2_HEAD23"));
							col_labels.setColLabel24(resultSet2.getString("C2_HEAD24"));
							col_labels.setColLabel25(resultSet2.getString("C2_HEAD25"));
							col_labels.setColLabel26(resultSet2.getString("C2_HEAD26"));
							col_labels.setColLabel27(resultSet2.getString("C2_HEAD27"));
							col_labels.setColLabel28(resultSet2.getString("C2_HEAD28"));
							col_labels.setColLabel29(resultSet2.getString("C2_HEAD29"));
							col_labels.setColLabel30(resultSet2.getString("C2_HEAD30"));
							col_labels.setColLabel31(resultSet2.getString("C2_HEAD31"));
							col_labels.setColLabel32(resultSet2.getString("C2_HEAD32"));
							col_labels.setColLabel33(resultSet2.getString("C2_HEAD33"));
							col_labels.setColLabel34(resultSet2.getString("C2_HEAD34"));
							col_labels.setColLabel35(resultSet2.getString("C2_HEAD35"));
							col_labels.setColLabel36(resultSet2.getString("C2_HEAD36"));
							col_labels.setColLabel37(resultSet2.getString("C2_HEAD37"));
							col_labels.setColLabel38(resultSet2.getString("C2_HEAD38"));
							col_labels.setColLabel39(resultSet2.getString("C2_HEAD39"));
							col_labels.setColLabel40(resultSet2.getString("C2_HEAD40"));
							col_labels.setColLabel41(resultSet2.getString("C2_HEAD41"));
							col_labels.setColLabel42(resultSet2.getString("C2_HEAD42"));
							col_labels.setColLabel43(resultSet2.getString("C2_HEAD43"));
							col_labels.setColLabel44(resultSet2.getString("C2_HEAD44"));
							col_labels.setColLabel45(resultSet2.getString("C2_HEAD45"));
							col_labels.setColLabel46(resultSet2.getString("C2_HEAD46"));
							col_labels.setColLabel47(resultSet2.getString("C2_HEAD47"));
							col_labels.setColLabel48(resultSet2.getString("C2_HEAD48"));
							col_labels.setColLabel49(resultSet2.getString("C2_HEAD49"));
							col_labels.setColLabel50(resultSet2.getString("C2_HEAD50"));
							col_labels.setColLabel51(resultSet2.getString("C2_HEAD51"));
							col_labels.setColLabel52(resultSet2.getString("C2_HEAD52"));
							col_labels.setColLabel53(resultSet2.getString("C2_HEAD53"));
							col_labels.setColLabel54(resultSet2.getString("C2_HEAD54"));
							col_labels.setColLabel55(resultSet2.getString("C2_HEAD55"));
							col_labels.setColLabel56(resultSet2.getString("C2_HEAD56"));
							col_labels.setColLabel57(resultSet2.getString("C2_HEAD57"));
							col_labels.setColLabel58(resultSet2.getString("C2_HEAD58"));
							col_labels.setColLabel59(resultSet2.getString("C2_HEAD59"));
							col_labels.setColLabel60(resultSet2.getString("C2_HEAD60"));
							col_labels.setColLabel61(resultSet2.getString("C2_HEAD61"));
							col_labels.setColLabel62(resultSet2.getString("C2_HEAD62"));
							/*col_labels.setColLabel63(resultSet2.getString("C2_HEAD63"));
							col_labels.setColLabel64(resultSet2.getString("C2_HEAD64"));
							col_labels.setColLabel65(resultSet2.getString("C2_HEAD65"));
							col_labels.setColLabel66(resultSet2.getString("C2_HEAD66"));
							col_labels.setColLabel67(resultSet2.getString("C2_HEAD67"));
							col_labels.setColLabel68(resultSet2.getString("C2_HEAD68"));
							col_labels.setColLabel69(resultSet2.getString("C2_HEAD69"));
							col_labels.setColLabel70(resultSet2.getString("C2_HEAD70"));
							col_labels.setColLabel71(resultSet2.getString("C2_HEAD71"));
							col_labels.setColLabel72(resultSet2.getString("C2_HEAD72"));
							col_labels.setColLabel73(resultSet2.getString("C2_HEAD73"));
							col_labels.setColLabel74(resultSet2.getString("C2_HEAD74"));
							col_labels.setColLabel75(resultSet2.getString("C2_HEAD75"));
							col_labels.setColLabel76(resultSet2.getString("C2_HEAD76"));
							col_labels.setColLabel77(resultSet2.getString("C2_HEAD77"));
							col_labels.setColLabel78(resultSet2.getString("C2_HEAD78"));
							col_labels.setColLabel79(resultSet2.getString("C2_HEAD79"));
							col_labels.setColLabel80(resultSet2.getString("C2_HEAD80"));
							col_labels.setColLabel81(resultSet2.getString("C2_HEAD81"));
							col_labels.setColLabel82(resultSet2.getString("C2_HEAD82"));
							col_labels.setColLabel83(resultSet2.getString("C2_HEAD83"));
							col_labels.setColLabel84(resultSet2.getString("C2_HEAD84"));
							col_labels.setColLabel85(resultSet2.getString("C2_HEAD85"));
							col_labels.setColLabel86(resultSet2.getString("C2_HEAD86"));
							col_labels.setColLabel87(resultSet2.getString("C2_HEAD87"));
							col_labels.setColLabel88(resultSet2.getString("C2_HEAD88"));
							col_labels.setColLabel89(resultSet2.getString("C2_HEAD89"));
							col_labels.setColLabel90(resultSet2.getString("C2_HEAD90"));
							col_labels.setColLabel91(resultSet2.getString("C2_HEAD91"));
							col_labels.setColLabel92(resultSet2.getString("C2_HEAD92"));
							col_labels.setColLabel93(resultSet2.getString("C2_HEAD93"));
							col_labels.setColLabel94(resultSet2.getString("C2_HEAD94"));
							col_labels.setColLabel95(resultSet2.getString("C2_HEAD95"));
							col_labels.setColLabel96(resultSet2.getString("C2_HEAD96"));
							col_labels.setColLabel97(resultSet2.getString("C2_HEAD97"));
							col_labels.setColLabel98(resultSet2.getString("C2_HEAD98"));
							col_labels.setColLabel99(resultSet2.getString("C2_HEAD99"));*/
							
						
						}
						System.out.println("col Labels :");
						CommonUtils.objectSysout(col_labels);//TODO
						resultSet3=handler.executeSelectStatement(Reports_SQL_Query_Constants.IP_REP_INFO,
																	connection,
																	new Object[]{REP_KEY_NO});
						while(resultSet3.next())
						{
							ip_rep_info.setREP_ID(REP_ID);
							ip_rep_info.setREP_KEY_NO(resultSet3.getString("REP_KEY_NO"));
												
							ip_rep_info.setREP_VALUE_1(resultSet3.getString("REP_VALUE_1"));
							ip_rep_info.setREP_VALUE_2(resultSet3.getString("REP_VALUE_2"));
							ip_rep_info.setREP_VALUE_3(resultSet3.getString("REP_VALUE_3"));
							ip_rep_info.setREP_VALUE_4(resultSet3.getString("REP_VALUE_4"));
							ip_rep_info.setREP_VALUE_5(resultSet3.getString("REP_VALUE_5"));
							ip_rep_info.setREP_VALUE_6(resultSet3.getString("REP_VALUE_6"));
							ip_rep_info.setREP_VALUE_7(resultSet3.getString("REP_VALUE_7"));
							ip_rep_info.setREP_VALUE_8(resultSet3.getString("REP_VALUE_8"));
							ip_rep_info.setREP_VALUE_9(resultSet3.getString("REP_VALUE_9"));
							ip_rep_info.setREP_VALUE_10(resultSet3.getString("REP_VALUE_10"));
							ip_rep_info.setREP_VALUE_11(resultSet3.getString("REP_VALUE_11"));
							ip_rep_info.setREP_VALUE_12(resultSet3.getString("REP_VALUE_12"));
							ip_rep_info.setREP_VALUE_13(resultSet3.getString("REP_VALUE_13"));
							ip_rep_info.setREP_VALUE_14(resultSet3.getString("REP_VALUE_14"));
							ip_rep_info.setREP_VALUE_15(resultSet3.getString("REP_VALUE_15"));
							ip_rep_info.setREP_VALUE_16(resultSet3.getString("REP_VALUE_16"));
							ip_rep_info.setREP_VALUE_17(resultSet3.getString("REP_VALUE_17"));
							ip_rep_info.setREP_VALUE_18(resultSet3.getString("REP_VALUE_18"));
							ip_rep_info.setREP_VALUE_19(resultSet3.getString("REP_VALUE_19"));
							ip_rep_info.setREP_VALUE_20(resultSet3.getString("REP_VALUE_20"));
							ip_rep_info.setREP_VALUE_21(resultSet3.getString("REP_VALUE_21"));
							ip_rep_info.setREP_VALUE_22(resultSet3.getString("REP_VALUE_22"));
							ip_rep_info.setREP_VALUE_23(resultSet3.getString("REP_VALUE_23"));
							ip_rep_info.setREP_VALUE_24(resultSet3.getString("REP_VALUE_24"));
							ip_rep_info.setREP_VALUE_25(resultSet3.getString("REP_VALUE_25"));
							ip_rep_info.setREP_VALUE_26(resultSet3.getString("REP_VALUE_26"));
							ip_rep_info.setREP_VALUE_27(resultSet3.getString("REP_VALUE_27"));
							ip_rep_info.setREP_VALUE_28(resultSet3.getString("REP_VALUE_28"));
							ip_rep_info.setREP_VALUE_29(resultSet3.getString("REP_VALUE_29"));
							ip_rep_info.setREP_VALUE_30(resultSet3.getString("REP_VALUE_30"));
							ip_rep_info.setREP_VALUE_31(resultSet3.getString("REP_VALUE_31"));
							ip_rep_info.setREP_VALUE_32(resultSet3.getString("REP_VALUE_32"));
							ip_rep_info.setREP_VALUE_33(resultSet3.getString("REP_VALUE_33"));
							ip_rep_info.setREP_VALUE_34(resultSet3.getString("REP_VALUE_34"));
							ip_rep_info.setREP_VALUE_35(resultSet3.getString("REP_VALUE_35"));
							ip_rep_info.setREP_VALUE_36(resultSet3.getString("REP_VALUE_36"));
							ip_rep_info.setREP_VALUE_37(resultSet3.getString("REP_VALUE_37"));
							ip_rep_info.setREP_VALUE_38(resultSet3.getString("REP_VALUE_38"));
							ip_rep_info.setREP_VALUE_39(resultSet3.getString("REP_VALUE_39"));
							ip_rep_info.setREP_VALUE_40(resultSet3.getString("REP_VALUE_40"));
							ip_rep_info.setREP_VALUE_41(resultSet3.getString("REP_VALUE_41"));
							ip_rep_info.setREP_VALUE_42(resultSet3.getString("REP_VALUE_42"));
							ip_rep_info.setREP_VALUE_43(resultSet3.getString("REP_VALUE_43"));
							ip_rep_info.setREP_VALUE_44(resultSet3.getString("REP_VALUE_44"));
							ip_rep_info.setREP_VALUE_45(resultSet3.getString("REP_VALUE_45"));
							ip_rep_info.setREP_VALUE_46(resultSet3.getString("REP_VALUE_46"));
							ip_rep_info.setREP_VALUE_47(resultSet3.getString("REP_VALUE_47"));
							ip_rep_info.setREP_VALUE_48(resultSet3.getString("REP_VALUE_48"));
							ip_rep_info.setREP_VALUE_49(resultSet3.getString("REP_VALUE_49"));
							ip_rep_info.setREP_VALUE_50(resultSet3.getString("REP_VALUE_50"));
							ip_rep_info.setREP_VALUE_51(resultSet3.getString("REP_VALUE_51"));
							ip_rep_info.setREP_VALUE_52(resultSet3.getString("REP_VALUE_52"));
							ip_rep_info.setREP_VALUE_53(resultSet3.getString("REP_VALUE_53"));
							ip_rep_info.setREP_VALUE_54(resultSet3.getString("REP_VALUE_54"));
							ip_rep_info.setREP_VALUE_55(resultSet3.getString("REP_VALUE_55"));
							ip_rep_info.setREP_VALUE_56(resultSet3.getString("REP_VALUE_56"));
							ip_rep_info.setREP_VALUE_57(resultSet3.getString("REP_VALUE_57"));
							ip_rep_info.setREP_VALUE_58(resultSet3.getString("REP_VALUE_58"));
							ip_rep_info.setREP_VALUE_59(resultSet3.getString("REP_VALUE_59"));
							ip_rep_info.setREP_VALUE_60(resultSet3.getString("REP_VALUE_60"));
						}
						System.out.println("IP_REP_INFO :");
						CommonUtils.objectSysout(ip_rep_info);//TODO
						resultSet4=handler.executeSelectStatement(Reports_SQL_Query_Constants.COMP_NAME,
																	connection,
																	new Object[]{langCode,COMP_CODE});
					
						while(resultSet4.next())
						{
							report_params.setRepTitle1(resultSet4.getString("COMP_NAME"));
						}
						
						
						
						report_params.setLoginDept(ip_rep_info.getREP_VALUE_59());
						report_params.setLoginDivn(ip_rep_info.getREP_VALUE_58());
						report_params.setLoginCompCode(ip_rep_info.getREP_VALUE_60());
						
						System.out.println("Report Params :");
						CommonUtils.objectSysout(report_params);//TODO
						resultSet6=handler.executeSelectStatement(Reports_SQL_Query_Constants.
																	SELECT_DETIALS_FROM_PP_REPORT_BP_PARAMETER, connection,
																	new Object[]{langCode,langCode,RBH_ID});
						 int idx = 0;
						    while(resultSet6.next()){
						        if(idx==0){
						        	param_list.setParmHead01(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead02(resultSet6.getString("HEAD2"));
						        }
						        if(idx==1){
						        	param_list.setParmHead03(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead04(resultSet6.getString("HEAD2"));
						        }
						        if(idx==2){
						        	param_list.setParmHead05(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead06(resultSet6.getString("HEAD2"));
						        }
						        if(idx==3){
						        	param_list.setParmHead07(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead08(resultSet6.getString("HEAD2"));
						        }
						        if(idx==4){
						        	param_list.setParmHead09(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead10(resultSet6.getString("HEAD2"));
						        }
						        if(idx==5){
						        	param_list.setParmHead11(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead12(resultSet6.getString("HEAD2"));
						        }
						        if(idx==6){
						        	param_list.setParmHead13(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead14(resultSet6.getString("HEAD2"));
						        }
						        if(idx==7){
						        	param_list.setParmHead15(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead16(resultSet6.getString("HEAD2"));
						        }
						        if(idx==8){
						        	param_list.setParmHead17(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead18(resultSet6.getString("HEAD2"));
						        }
						        if(idx==9){
						        	param_list.setParmHead19(resultSet6.getString("HEAD1"));
						        	param_list.setParmHead20(resultSet6.getString("HEAD2"));
						        }
						       idx++;
						       if(idx>=10){
						    	   break;
						       }
						       ReportParamSetup reportParamSetup=new ReportParamSetup();
						       reportParamSetup.paramSetup(param_list, ip_rep_info,REP_ID);
						       System.out.println("param _List :");
						       CommonUtils.objectSysout(param_list);//TODO
						    }
						    
						   objectMap=setRepParamValues(col_labels,param_list,
						    							report_params,ip_rep_info); 
					}catch (Exception e) {
						e.printStackTrace();
					}finally{
						if(resultSet1!=null){
							try {
								resultSet1.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(resultSet2!=null){
							try {
								resultSet2.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(resultSet3!=null){
							try {
								resultSet3.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(resultSet4!=null){
							try {
								resultSet4.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if(resultSet5!=null){
							try {
								resultSet5.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
				}
			
				return objectMap;	
	
		}
	
	
	public Map<Object,Object> setRepParamValues(COL_LABELS COL_LABEL,PARAM_LIST PARAM_LIST,
												REPORT_PARAMS REPORT_PARAMS,IP_REP_INFO IP_REP_INFO){
	
		Map<Object, Object> returnMap=new HashMap<Object, Object>();
		CommonUtils commonUtils=new CommonUtils();	
		returnMap.put("colLabel01", COL_LABEL.getColLabel01());
        returnMap.put("colLabel02", COL_LABEL.getColLabel02());
        returnMap.put("colLabel03", COL_LABEL.getColLabel03());
        returnMap.put("colLabel04", COL_LABEL.getColLabel04());
        returnMap.put("colLabel05", COL_LABEL.getColLabel05());
        returnMap.put("colLabel06", COL_LABEL.getColLabel06());
        returnMap.put("colLabel07", COL_LABEL.getColLabel07());
        returnMap.put("colLabel08", COL_LABEL.getColLabel08());
        returnMap.put("colLabel09", COL_LABEL.getColLabel09());
        returnMap.put("colLabel10", COL_LABEL.getColLabel10());
        returnMap.put("colLabel11", COL_LABEL.getColLabel11());
        returnMap.put("colLabel12", COL_LABEL.getColLabel12());
        returnMap.put("colLabel13", COL_LABEL.getColLabel13());
        returnMap.put("colLabel14", COL_LABEL.getColLabel14());
        returnMap.put("colLabel15", COL_LABEL.getColLabel15());
        returnMap.put("colLabel16", COL_LABEL.getColLabel16());
        returnMap.put("colLabel17", COL_LABEL.getColLabel17());
        returnMap.put("colLabel18", COL_LABEL.getColLabel18());
        returnMap.put("colLabel19", COL_LABEL.getColLabel19());
        returnMap.put("colLabel20", COL_LABEL.getColLabel20());
        returnMap.put("colLabel21", COL_LABEL.getColLabel21());
        returnMap.put("colLabel22", COL_LABEL.getColLabel22());
        returnMap.put("colLabel23", COL_LABEL.getColLabel23());
        returnMap.put("colLabel24", COL_LABEL.getColLabel24());
        returnMap.put("colLabel25", COL_LABEL.getColLabel25());
        returnMap.put("colLabel26", COL_LABEL.getColLabel26());
        returnMap.put("colLabel27", COL_LABEL.getColLabel27());
        returnMap.put("colLabel28", COL_LABEL.getColLabel28());
        returnMap.put("colLabel29", COL_LABEL.getColLabel29());
        returnMap.put("colLabel30", COL_LABEL.getColLabel30());
        returnMap.put("colLabel31", COL_LABEL.getColLabel31());
        returnMap.put("colLabel32", COL_LABEL.getColLabel32());
        returnMap.put("colLabel33", COL_LABEL.getColLabel33());
        returnMap.put("colLabel34", COL_LABEL.getColLabel34());
        returnMap.put("colLabel35", COL_LABEL.getColLabel35());
        returnMap.put("colLabel36", COL_LABEL.getColLabel36());
        returnMap.put("colLabel37", COL_LABEL.getColLabel37());
        returnMap.put("colLabel38", COL_LABEL.getColLabel38());
        returnMap.put("colLabel39", COL_LABEL.getColLabel39());
        returnMap.put("colLabel40", COL_LABEL.getColLabel40());
        returnMap.put("colLabel41", COL_LABEL.getColLabel41());
        returnMap.put("colLabel42", COL_LABEL.getColLabel42());
        returnMap.put("colLabel43", COL_LABEL.getColLabel43());
        returnMap.put("colLabel44", COL_LABEL.getColLabel44());
        returnMap.put("colLabel45", COL_LABEL.getColLabel45());
        returnMap.put("colLabel46", COL_LABEL.getColLabel46());
        returnMap.put("colLabel47", COL_LABEL.getColLabel47());
        returnMap.put("colLabel48", COL_LABEL.getColLabel48());
        returnMap.put("colLabel49", COL_LABEL.getColLabel49());
        returnMap.put("colLabel50", COL_LABEL.getColLabel50());
        returnMap.put("colLabel51", COL_LABEL.getColLabel51());
        returnMap.put("colLabel52", COL_LABEL.getColLabel52());
        returnMap.put("colLabel53", COL_LABEL.getColLabel53());
        returnMap.put("colLabel54", COL_LABEL.getColLabel54());
        returnMap.put("colLabel55", COL_LABEL.getColLabel55());
        returnMap.put("colLabel56", COL_LABEL.getColLabel56());
        returnMap.put("colLabel57", COL_LABEL.getColLabel57());
        returnMap.put("colLabel58", COL_LABEL.getColLabel58());
        returnMap.put("colLabel59", COL_LABEL.getColLabel59());
        returnMap.put("colLabel60", COL_LABEL.getColLabel60());
        returnMap.put("colLabel61", COL_LABEL.getColLabel61());
        returnMap.put("colLabel62", COL_LABEL.getColLabel62());
        returnMap.put("colLabel63", COL_LABEL.getColLabel63());
        returnMap.put("colLabel64", COL_LABEL.getColLabel64());
        returnMap.put("colLabel65", COL_LABEL.getColLabel65());
        returnMap.put("colLabel66", COL_LABEL.getColLabel66());
        returnMap.put("colLabel67", COL_LABEL.getColLabel67());
        returnMap.put("colLabel68", COL_LABEL.getColLabel68());
        returnMap.put("colLabel69", COL_LABEL.getColLabel69());
        returnMap.put("colLabel70", COL_LABEL.getColLabel70());
        returnMap.put("colLabel71", COL_LABEL.getColLabel71());
        returnMap.put("colLabel72", COL_LABEL.getColLabel72());
        returnMap.put("colLabel73", COL_LABEL.getColLabel73());
        returnMap.put("colLabel74", COL_LABEL.getColLabel74());
        returnMap.put("colLabel75", COL_LABEL.getColLabel75());
        returnMap.put("colLabel76", COL_LABEL.getColLabel76());
        returnMap.put("colLabel77", COL_LABEL.getColLabel77());
        returnMap.put("colLabel78", COL_LABEL.getColLabel78());
        returnMap.put("colLabel79", COL_LABEL.getColLabel79());
        returnMap.put("colLabel80", COL_LABEL.getColLabel80());
        returnMap.put("colLabel81", COL_LABEL.getColLabel81());
        returnMap.put("colLabel82", COL_LABEL.getColLabel82());
        returnMap.put("colLabel83", COL_LABEL.getColLabel83());
        returnMap.put("colLabel84", COL_LABEL.getColLabel84());
        returnMap.put("colLabel85", COL_LABEL.getColLabel85());
        returnMap.put("colLabel86", COL_LABEL.getColLabel86());
        returnMap.put("colLabel87", COL_LABEL.getColLabel87());
        returnMap.put("colLabel88", COL_LABEL.getColLabel88());
        returnMap.put("colLabel89", COL_LABEL.getColLabel89());
        returnMap.put("colLabel90", COL_LABEL.getColLabel90());
        returnMap.put("colLabel91", COL_LABEL.getColLabel91());
        returnMap.put("colLabel92", COL_LABEL.getColLabel92());
        returnMap.put("colLabel93", COL_LABEL.getColLabel93());
        returnMap.put("colLabel94", COL_LABEL.getColLabel94());
        returnMap.put("colLabel95", COL_LABEL.getColLabel95());
        returnMap.put("colLabel96", COL_LABEL.getColLabel96());
        returnMap.put("colLabel97", COL_LABEL.getColLabel97());
        returnMap.put("colLabel98", COL_LABEL.getColLabel98());
        returnMap.put("colLabel99", COL_LABEL.getColLabel99());
        
        returnMap.put("repKeyNo", IP_REP_INFO.getREP_KEY_NO());
        returnMap.put("repID", IP_REP_INFO.getREP_ID());
        returnMap.put("repVal01", IP_REP_INFO.getREP_VALUE_1());
        returnMap.put("repVal02", IP_REP_INFO.getREP_VALUE_2());
        returnMap.put("repVal03", IP_REP_INFO.getREP_VALUE_3());
        returnMap.put("repVal04", IP_REP_INFO.getREP_VALUE_4());
        returnMap.put("repVal05", IP_REP_INFO.getREP_VALUE_5());
        returnMap.put("repVal06", IP_REP_INFO.getREP_VALUE_6());
        returnMap.put("repVal07", IP_REP_INFO.getREP_VALUE_7());
        returnMap.put("repVal08", IP_REP_INFO.getREP_VALUE_8());
        returnMap.put("repVal09", IP_REP_INFO.getREP_VALUE_9());
        returnMap.put("repVal10", IP_REP_INFO.getREP_VALUE_10());
        returnMap.put("repVal11", IP_REP_INFO.getREP_VALUE_11());
        returnMap.put("repVal12", IP_REP_INFO.getREP_VALUE_12());
        returnMap.put("repVal13", IP_REP_INFO.getREP_VALUE_13());
        returnMap.put("repVal14", IP_REP_INFO.getREP_VALUE_14());
        returnMap.put("repVal15", IP_REP_INFO.getREP_VALUE_15());
        returnMap.put("repVal16", IP_REP_INFO.getREP_VALUE_16());
        returnMap.put("repVal17", IP_REP_INFO.getREP_VALUE_17());
        returnMap.put("repVal18", IP_REP_INFO.getREP_VALUE_18());
        returnMap.put("repVal19", IP_REP_INFO.getREP_VALUE_19());
        returnMap.put("repVal20", IP_REP_INFO.getREP_VALUE_20());
        returnMap.put("repVal21", IP_REP_INFO.getREP_VALUE_21());
        returnMap.put("repVal22", IP_REP_INFO.getREP_VALUE_22());
        returnMap.put("repVal23", IP_REP_INFO.getREP_VALUE_23());
        returnMap.put("repVal24", IP_REP_INFO.getREP_VALUE_24());
        returnMap.put("repVal25", IP_REP_INFO.getREP_VALUE_25());
        returnMap.put("repVal26", IP_REP_INFO.getREP_VALUE_26());
        returnMap.put("repVal27", IP_REP_INFO.getREP_VALUE_27());
        returnMap.put("repVal28", IP_REP_INFO.getREP_VALUE_28());
        returnMap.put("repVal29", IP_REP_INFO.getREP_VALUE_29());
        returnMap.put("repVal30", IP_REP_INFO.getREP_VALUE_30());
        returnMap.put("repVal31", IP_REP_INFO.getREP_VALUE_31());
        returnMap.put("repVal32", IP_REP_INFO.getREP_VALUE_32());
        returnMap.put("repVal33", IP_REP_INFO.getREP_VALUE_33());
        returnMap.put("repVal34", IP_REP_INFO.getREP_VALUE_34());
        returnMap.put("repVal35", IP_REP_INFO.getREP_VALUE_35());
        returnMap.put("repVal36", IP_REP_INFO.getREP_VALUE_36());
        returnMap.put("repVal37", IP_REP_INFO.getREP_VALUE_37());
        returnMap.put("repVal38", IP_REP_INFO.getREP_VALUE_38());
        returnMap.put("repVal39", IP_REP_INFO.getREP_VALUE_39());
        returnMap.put("repVal40", IP_REP_INFO.getREP_VALUE_40());
        returnMap.put("repVal41", IP_REP_INFO.getREP_VALUE_41());
        returnMap.put("repVal42", IP_REP_INFO.getREP_VALUE_42());
        returnMap.put("repVal43", IP_REP_INFO.getREP_VALUE_43());
        returnMap.put("repVal44", IP_REP_INFO.getREP_VALUE_44());
        returnMap.put("repVal45", IP_REP_INFO.getREP_VALUE_45());
        returnMap.put("repVal46", IP_REP_INFO.getREP_VALUE_46());
        returnMap.put("repVal47", IP_REP_INFO.getREP_VALUE_47());
        returnMap.put("repVal48", IP_REP_INFO.getREP_VALUE_48());
        returnMap.put("repVal49", IP_REP_INFO.getREP_VALUE_49());
        returnMap.put("repVal50", IP_REP_INFO.getREP_VALUE_50());
        returnMap.put("repVal51", IP_REP_INFO.getREP_VALUE_51());
        returnMap.put("repVal52", IP_REP_INFO.getREP_VALUE_52());
        returnMap.put("repVal53", IP_REP_INFO.getREP_VALUE_53());
        returnMap.put("repVal54", IP_REP_INFO.getREP_VALUE_54());
        returnMap.put("repVal55", IP_REP_INFO.getREP_VALUE_55());
        returnMap.put("repVal56", IP_REP_INFO.getREP_VALUE_56());
        returnMap.put("repVal57", IP_REP_INFO.getREP_VALUE_57());
        returnMap.put("repVal58", IP_REP_INFO.getREP_VALUE_58());
        returnMap.put("repVal59", IP_REP_INFO.getREP_VALUE_59());
        returnMap.put("repVal60", IP_REP_INFO.getREP_VALUE_60());
      
        returnMap.put("loginCompCode", REPORT_PARAMS.getLoginCompCode());
        returnMap.put("loginDivn", REPORT_PARAMS.getLoginDivn());
        returnMap.put("loginlang", REPORT_PARAMS.getLoginlang());
        returnMap.put("loginuser", REPORT_PARAMS.getLoginuser());
        returnMap.put("loginuserName", REPORT_PARAMS.getLoginuserName());
        returnMap.put("ctrlParm00", REPORT_PARAMS.getCtrlParm00());
        returnMap.put("ctrlParm01", REPORT_PARAMS.getCtrlParm01());
        returnMap.put("ctrlParm02", REPORT_PARAMS.getCtrlParm02());
        returnMap.put("ctrlParm03", REPORT_PARAMS.getCtrlParm03());
        returnMap.put("ctrlParm04", REPORT_PARAMS.getCtrlParm04());
        returnMap.put("ctrlParm05", REPORT_PARAMS.getCtrlParm05());
        returnMap.put("ctrlParm06", REPORT_PARAMS.getCtrlParm06());
        returnMap.put("ctrlParm07", REPORT_PARAMS.getCtrlParm07());
        returnMap.put("ctrlParm08", REPORT_PARAMS.getCtrlParm08());
        returnMap.put("ctrlParm09", REPORT_PARAMS.getCtrlParm09());
        returnMap.put("displayLogo", REPORT_PARAMS.getDisplayLogo());
        returnMap.put("paraText01", REPORT_PARAMS.getParaText01());
        returnMap.put("paraText02", REPORT_PARAMS.getParaText02());
        returnMap.put("footerText01", REPORT_PARAMS.getFooterText01());
        returnMap.put("footerText02", REPORT_PARAMS.getFooterText02());
        returnMap.put("footerText03", REPORT_PARAMS.getFooterText03());
        returnMap.put("dtlText01", REPORT_PARAMS.getDtlText01());
        returnMap.put("dtlText02", REPORT_PARAMS.getDtlText02());
        returnMap.put("displayParms", REPORT_PARAMS.getDisplayLogo());
        returnMap.put("repID", REPORT_PARAMS.getRepID());
        returnMap.put("repName", REPORT_PARAMS.getRepName());
        returnMap.put("repTitle1", REPORT_PARAMS.getRepTitle1());
        returnMap.put("repTitle2", REPORT_PARAMS.getRepTitle2());
        returnMap.put("repTitle3", REPORT_PARAMS.getRepTitle3());
        returnMap.put("repRunTime", REPORT_PARAMS.getRepRunTime());
        returnMap.put("pageno", REPORT_PARAMS.getPageno());
        returnMap.put("loginDept", REPORT_PARAMS.getLoginDept());
        returnMap.put("langCode", REPORT_PARAMS.getLangCode());
        returnMap.put("baseCurrCode", REPORT_PARAMS.getBaseCurrCode());
     /* [ Bug Fixed PREMIA-GDC-1302947 by :Varun Mathur 50663 as the kay for Param Head 1 was missing 
        inserted the same]*/
        
        returnMap.put("parmHead01", PARAM_LIST.getParmHead01());
        
        /* [ Bug Fixed PREMIA-GDC-1302947 by :Varun Mathur 50663 as the kay for Param Head 1 was missing 
        inserted the same]*/   
        returnMap.put("parmHead02", PARAM_LIST.getParmHead02());
        returnMap.put("parmHead03", PARAM_LIST.getParmHead03());
        returnMap.put("parmHead04", PARAM_LIST.getParmHead04());
        returnMap.put("parmHead05", PARAM_LIST.getParmHead05());
        returnMap.put("parmHead06", PARAM_LIST.getParmHead06());
        returnMap.put("parmHead07", PARAM_LIST.getParmHead07());
        returnMap.put("parmHead08", PARAM_LIST.getParmHead08());
        returnMap.put("parmHead09", PARAM_LIST.getParmHead09());
        returnMap.put("parmHead10", PARAM_LIST.getParmHead10());
        returnMap.put("parmHead11", PARAM_LIST.getParmHead11());
        returnMap.put("parmHead12", PARAM_LIST.getParmHead12());
        returnMap.put("parmHead13", PARAM_LIST.getParmHead13());
        returnMap.put("parmHead14", PARAM_LIST.getParmHead14());
        returnMap.put("parmHead15", PARAM_LIST.getParmHead15());
        returnMap.put("parmHead16", PARAM_LIST.getParmHead16());
        returnMap.put("parmHead17", PARAM_LIST.getParmHead17());
        returnMap.put("parmHead18", PARAM_LIST.getParmHead18());
        returnMap.put("parmHead19", PARAM_LIST.getParmHead19());
        returnMap.put("parmHead20", PARAM_LIST.getParmHead20());
        returnMap.put("parmValue01", PARAM_LIST.getParmValue01());
        returnMap.put("parmValue02", PARAM_LIST.getParmValue02());
        returnMap.put("parmValue03", PARAM_LIST.getParmValue03());
        returnMap.put("parmValue04", PARAM_LIST.getParmValue04());
        returnMap.put("parmValue05", PARAM_LIST.getParmValue05());
        returnMap.put("parmValue06", PARAM_LIST.getParmValue06());
        returnMap.put("parmValue07", PARAM_LIST.getParmValue07());
        returnMap.put("parmValue08", PARAM_LIST.getParmValue08());
        returnMap.put("parmValue09", PARAM_LIST.getParmValue09());
        returnMap.put("parmValue10", PARAM_LIST.getParmValue10());
        returnMap.put("parmValue11", PARAM_LIST.getParmValue11());
        returnMap.put("parmValue12", PARAM_LIST.getParmValue12());
        returnMap.put("parmValue13", PARAM_LIST.getParmValue13());
        returnMap.put("parmValue14", PARAM_LIST.getParmValue14());
        returnMap.put("parmValue15", PARAM_LIST.getParmValue15());
        returnMap.put("parmValue16", PARAM_LIST.getParmValue16());
        returnMap.put("parmValue17", PARAM_LIST.getParmValue17());
        returnMap.put("parmValue18", PARAM_LIST.getParmValue18());
        returnMap.put("parmValue19", PARAM_LIST.getParmValue19());
        returnMap.put("parmValue20", PARAM_LIST.getParmValue20());
        String reportTextFileName=commonUtils.propertyManager(PELConstants.pelReportsPropertiesFile, "REPORT_ID_RELATED_TEXT_PROPERTIES")
        							+IP_REP_INFO.getREP_ID()+".properties";
        System.out.println("reportTextFileName :"+reportTextFileName);
        File file=new File(reportTextFileName);
        if(file.exists()){
        	
        	String reportFilePath=commonUtils.propertyManager(PELConstants.pelReportsPropertiesFile,"REPORT_ID_PROPERTY_FILE_PATH")
        										+IP_REP_INFO.getREP_ID();
        	ResourceBundle resourceBundle=ResourceBundle.getBundle(reportFilePath);
        	Set<String> keySet=resourceBundle.keySet();
        	int setCount=keySet.size();
    		String keyText=null;
    		Iterator itr=keySet.iterator();
    		while(itr.hasNext()){
    			keyText=(String) itr.next();
    			if(keyText.trim().substring(0, 4).equals("text")){
    				returnMap.put(keyText,resourceBundle.getString(keyText));
    			}
    		}
        	
        }
      //returnMap.put("jasperBin", commonUtils.propertyManager(PELConstants.pelReportsPropertiesFile,"JASPER_BIN_PATH"));
        //The line was commented uncommented it as this key is being referred for subreport jasperBin path--Varun[50663]
        returnMap.put("jasperBin",commonUtils.propertyManager("login","JASPER_BIN_PATH"));
        returnMap.put("imagePath",commonUtils.propertyManager("login","JASPER_BIN_PATH"));
        
        // Run Date key added to specify the date and time of the report--Varun[50663]28/05/2009
        returnMap.put("rDate", getCurrentDateAndTime());
        //pelDateFormat passed to get the date format for reports--Varun[50663]28/05/2009
        returnMap.put("dateFormat", PELConstants.pelDateFormat);
        
        return returnMap;
	}
	
	public static void main(String[] args) {
		File file=new File("../PEL/JavaSource/com/iii/pel/jasperreports/PILR_SCH01.properties");
		
		System.out.println("Exists :"+file.exists());
		CommonUtils commonUtils=new CommonUtils();
		ResourceBundle resourceBundle=ResourceBundle.getBundle("com.iii.pel.jasperreports.PILR_SCH01");
		Set<String> keySet=resourceBundle.keySet();
		int setCount=keySet.size();
		String keyText=null;
		Iterator itr=keySet.iterator();
		while(itr.hasNext()){
			keyText=(String) itr.next();
			if(keyText.trim().substring(0, 4).equals("text")){
				System.out.println("Key Text  :"+keyText+" :::"+resourceBundle.getString(keyText));
			}
		}
	}
	public String propertyManager(String bundleName,String key){
    	String value=null;
    	ResourceBundle resourceBundle=ResourceBundle.getBundle(bundleName);
    	value=resourceBundle.getString(key);
    	return value;
    }
	
	
	/**
	 * Returns a current system(App-Server) date as String in 'yyyy/MM/dd   h:mm:ss a' format
	 * @return String				The String in 'yyyy/MM/dd   h:mm:ss a' format
	 * added by Varun[50663]28/05/2009
	 */
	private String getCurrentDateAndTime() {
		java.util.Date date = new java.util.Date();
		DateFormat df = new SimpleDateFormat(PELConstants.pelReportsDateAndTimeFormat);
		String stringDate = df.format(date);
		
		return stringDate;
	}
}

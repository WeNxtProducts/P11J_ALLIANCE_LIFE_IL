package com.iii.pel.forms.PILM015_APAC;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sample {

	/*public static void main(String[] args) {
		String oracleException="ORA-20100: 71004";
		System.out.println("Lets see : "+oracleException.substring(0, 4));
		String part1OracleException=oracleException.substring(0, 4);
		System.out.println("Check is on :"+oracleException.replaceFirst(part1OracleException, ""));
		String tokenOfCodeStrings=oracleException.replaceFirst(part1OracleException, "");
		StringTokenizer str=new StringTokenizer(tokenOfCodeStrings,":");
		while(str.hasMoreTokens()){
			Orcale
			System.out.println("One: "+str.nextToken());
			System.out.println("Two :"+str.nextToken());
		}
		
		
	}
	
*/	
	/*public static void main(String[] args) {
	String message="ORA-20100: 71004"+"\n"+
				"ORA-06512: at PEL_LIFE.PCOPK_GENERAL, line 396"+"\n"+
				"ORA-06512: at PEL_LIFE.P_VAL_CLASS, line 20";*/
	//System.out.println("Message :"+getErrorMessageForSQLException(message));
	/*String replacedMessage=null;
		try{
			replacedMessage=message.replace("\n", " ");
			StringTokenizer str=new StringTokenizer(replacedMessage," ");
			String notNeeded=str.nextToken();
			String errorNo=str.nextToken();
			System.out.println(" Error Message :"+CommonUtils.getErrorMessageForCode(errorNo));
			
		}catch (Exception e) {
			System.out.println("YOur Message Is Back :"+message);
		}*/
	
	
	
	
	/*public static String getErrorMessageForSQLException(SQLException sqlExceptionObject){
		String pelErrorMessage=null;
		String oracleExceptionMessage=sqlExceptionObject.getMessage();
		try{
			
			String replaceNewLinebySpace=oracleExceptionMessage.replace("\n", " ");
			StringTokenizer tokenizeBySapce=new StringTokenizer(replaceNewLinebySpace);
			tokenizeBySapce.nextToken();
			pelErrorMessage=CommonUtils.getErrorMessageForCode(tokenizeBySapce.nextToken().trim());
		}catch(Exception e){
			pelErrorMessage=oracleExceptionMessage;
		}
		
		
		return pelErrorMessage;
	}*/
	
	/*public static String getErrorCodeFromSQLMessage(String sqlExceptionMessage){
	
		String pelErrorMessage=null;
		StringTokenizer str=new StringTokenizer(sqlExceptionMessage,"\n");
		
		
			
			while(str.hasMoreTokens()){
				String oracleErrorNo=str.nextToken();
				System.out.println("Oracle Error NO :"+oracleErrorNo);
				String errorCode=str.nextToken();
				System.out.println("errorCode :"+errorCode);
				StringTokenizer strToken=new StringTokenizer(errorCode,":");
				if(strToken.hasMoreTokens()){
					String oracleError=strToken.nextToken();
					if(strToken.hasMoreTokens()){
						
						String errorString=strToken.nextToken();
						System.out.println("Error String:"+errorString.trim());
						String errorMessage=CommonUtils.getErrorMessageForCode(errorString.trim());
						if(errorMessage!=null){
							pelErrorMessage=errorMessage;
							System.out.println("ErrorMessage :"+errorMessage);
							
						}				
					}
					
				}
				
				
			}
		
		
	
	return pelErrorMessage;
}*/
	
	/*public static void main(String[] args) {
		try {
			System.out.println("Get Years :"+getTodaysDate().getYear());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/**
	 * Convert 		java.util.Date to java.sql.Date
	 * @return	 	returns date String as java.sql.Date  
	 */
	
	public static Date getTodaysDate() throws ParseException{
	 	java.util.Date date =  new java.util.Date();
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		String s = df.format(date);
		Date today = (Date) df.parse(s);
		return today;
 }
	public static String to_char(Date d, String str)
	 {
	     Calendar c = Calendar.getInstance();
	     c.setTime(d);
	     String str_old = str;
	     str = str.toLowerCase();
	     if(str.indexOf("bc") != -1)
	     {
	         Calendar _tmp = c;
	         int i = c.get(0);
	         if(i == 0)
	             str = str.replaceAll("bc", "BC");
	         else
	             str = str.replaceAll("bc", "AD");
	     }
	     if(str.indexOf("ad") != -1)
	     {
	         Calendar _tmp1 = c;
	         int i = c.get(0);
	         if(i == 0)
	             str = str.replaceAll("ad", "BC");
	         else
	             str = str.replaceAll("ad", "AD");
	     }
	     if(str.indexOf("b.c.") != -1)
	     {
	         Calendar _tmp2 = c;
	         int i = c.get(0);
	         if(i == 0)
	             str = str.replaceAll("b.c.", "B.C");
	         else
	             str = str.replaceAll("b.c.", "A.D");
	     }
	     if(str.indexOf("a.d.") != -1)
	     {
	         Calendar _tmp3 = c;
	         int i = c.get(0);
	         if(i == 0)
	             str = str.replaceAll("a.d.", "B.C");
	         else
	             str = str.replaceAll("a.d.", "A.D");
	     }
	     if(str.indexOf("day") != -1)
	     {
	         Calendar _tmp4 = c;
	         int i = c.get(7);
	         String temp = new String();
	         switch(i)
	         {
	         case 1: // '\001'
	             temp = "Sunday   ";
	             break;

	         case 2: // '\002'
	             temp = "Monday   ";
	             break;

	         case 3: // '\003'
	             temp = "Tuesday  ";
	             break;

	         case 4: // '\004'
	             temp = "Wednesday";
	             break;

	         case 5: // '\005'
	             temp = "Thusday  ";
	             break;

	         case 6: // '\006'
	             temp = "Friday   ";
	             break;

	         case 7: // '\007'
	             temp = "Saturday ";
	             break;
	         }
	         if(Character.isLowerCase(str_old.charAt(str.indexOf("day"))))
	             temp = temp.toLowerCase();
	         if(Character.isUpperCase(str_old.charAt(str.indexOf("day"))) && Character.isUpperCase(str_old.charAt(str.indexOf("day") + 1)))
	             temp = temp.toUpperCase();
	         if(str.indexOf("fm") != -1 && str.indexOf("fm") < str.indexOf("day"))
	             temp = temp.trim();
	         str = str.replaceAll("day", temp);
	     }
	     if(str.indexOf(" dy ") != -1)
	     {
	         Calendar _tmp5 = c;
	         int i = c.get(7);
	         String temp = new String();
	         switch(i)
	         {
	         case 1: // '\001'
	             temp = "Sun";
	             break;

	         case 2: // '\002'
	             temp = "Mon";
	             break;

	         case 3: // '\003'
	             temp = "Tue";
	             break;

	         case 4: // '\004'
	             temp = "Wed";
	             break;

	         case 5: // '\005'
	             temp = "Thu";
	             break;

	         case 6: // '\006'
	             temp = "Fri";
	             break;

	         case 7: // '\007'
	             temp = "Sat";
	             break;
	         }
	         if(Character.isLowerCase(str_old.charAt(str.indexOf("dy"))))
	             temp = temp.toLowerCase();
	         if(Character.isUpperCase(str_old.charAt(str.indexOf("dy"))) && Character.isUpperCase(str_old.charAt(str.indexOf("dy") + 1)))
	             temp = temp.toUpperCase();
	         str = str.replaceAll("dy", temp);
	     }
	     if(str.indexOf(" d ") != -1)
	     {
	         Calendar _tmp6 = c;
	         str = str.replaceAll(" d ", " " + c.get(7) + " ");
	     }
	     if(str.indexOf(" ddd ") != -1)
	     {
	         Calendar _tmp7 = c;
	         str = str.replaceAll(" ddd ", " " + c.get(6) + " ");
	     }
	     if(str.indexOf("hh24") != -1)
	     {
	         Calendar _tmp8 = c;
	         int time = c.get(10);
	         Calendar _tmp9 = c;
	         if(c.get(9) == 1)
	             str = str.replaceAll("hh24", (time + 12) + "");
	     }
	     if(str.indexOf("hh12") != -1)
	     {
	         Calendar _tmp10 = c;
	         str = str.replaceAll("hh12", c.get(10) + "");
	     }
	     if(str.indexOf("hh") != -1)
	     {
	         Calendar _tmp11 = c;
	         str = str.replaceAll("hh", c.get(10) + "");
	     }
	     if(str.indexOf("am") != -1)
	     {
	         Calendar _tmp12 = c;
	         int am = c.get(9);
	         if(am == 1)
	             str = str.replaceAll("am", "PM");
	         else
	             str = str.replaceAll("am", "AM");
	     } else
	     if(str.indexOf("pm") != -1)
	     {
	         Calendar _tmp13 = c;
	         int am = c.get(9);
	         if(am == 1)
	             str = str.replaceAll("pm", "PM");
	         else
	             str = str.replaceAll("pm", "AM");
	     }
	     if(str.indexOf("a.m") != -1)
	     {
	         Calendar _tmp14 = c;
	         int am = c.get(9);
	         if(am == 1)
	             str = str.replaceAll("a.m", "P.M");
	         else
	             str = str.replaceAll("a.m", "A.M");
	     } else
	     if(str.indexOf("p.m") != -1)
	     {
	         Calendar _tmp15 = c;
	         int am = c.get(9);
	         if(am == 1)
	             str = str.replaceAll("p.m", "P.M");
	         else
	             str = str.replaceAll("p.m", "A.M");
	     }
	     if(str.indexOf("ss") != -1)
	     {
	         Calendar _tmp16 = c;
	         str = str.replaceAll("ss", c.get(13) + "");
	     }
	     if(str.indexOf("mi") != -1)
	     {
	         Calendar _tmp17 = c;
	         str = str.replaceAll("mi", c.get(12) + "");
	     }
	     if(str.indexOf("month") != -1)
	     {
	         String temp = new String();
	         Calendar _tmp18 = c;
	         if(c.get(2) == 0)
	         {
	             temp = "January   ";
	         } else
	         {
	             Calendar _tmp19 = c;
	             if(c.get(2) == 1)
	             {
	                 temp = "February ";
	             } else
	             {
	                 Calendar _tmp20 = c;
	                 if(c.get(2) == 2)
	                 {
	                     temp = "March    ";
	                 } else
	                 {
	                     Calendar _tmp21 = c;
	                     if(c.get(2) == 3)
	                     {
	                         temp = "April    ";
	                     } else
	                     {
	                         Calendar _tmp22 = c;
	                         if(c.get(2) == 4)
	                         {
	                             temp = "May      ";
	                         } else
	                         {
	                             Calendar _tmp23 = c;
	                             if(c.get(2) == 5)
	                             {
	                                 temp = "June     ";
	                             } else
	                             {
	                                 Calendar _tmp24 = c;
	                                 if(c.get(2) == 6)
	                                 {
	                                     temp = "July     ";
	                                 } else
	                                 {
	                                     Calendar _tmp25 = c;
	                                     if(c.get(2) == 7)
	                                     {
	                                         temp = "August   ";
	                                     } else
	                                     {
	                                         Calendar _tmp26 = c;
	                                         if(c.get(2) == 8)
	                                         {
	                                             temp = "September";
	                                         } else
	                                         {
	                                             Calendar _tmp27 = c;
	                                             if(c.get(2) == 9)
	                                             {
	                                                 temp = "October  ";
	                                             } else
	                                             {
	                                                 Calendar _tmp28 = c;
	                                                 if(c.get(2) == 10)
	                                                 {
	                                                     temp = "November ";
	                                                 } else
	                                                 {
	                                                     Calendar _tmp29 = c;
	                                                     if(c.get(2) == 11)
	                                                         temp = "December ";
	                                                 }
	                                             }
	                                         }
	                                     }
	                                 }
	                             }
	                         }
	                     }
	                 }
	             }
	         }
	         if(Character.isLowerCase(str_old.charAt(str.indexOf("month"))))
	             temp = temp.toLowerCase();
	         if(Character.isUpperCase(str_old.charAt(str.indexOf("month"))) && Character.isUpperCase(str_old.charAt(str.indexOf("month") + 1)))
	             temp = temp.toUpperCase();
	         if(str.indexOf("fm") != -1 && str.indexOf("fm") < str.indexOf("month"))
	             temp = temp.trim();
	         str = str.replaceAll("month", temp);
	     } else
	     if(str.indexOf("mon") != -1)
	     {
	         String temp = new String();
	         Calendar _tmp30 = c;
	         if(c.get(2) == 0)
	         {
	             temp = "Jan";
	         } else
	         {
	             Calendar _tmp31 = c;
	             if(c.get(2) == 1)
	             {
	                 temp = "Feb";
	             } else
	             {
	                 Calendar _tmp32 = c;
	                 if(c.get(2) == 3)
	                 {
	                     temp = "Apr";
	                 } else
	                 {
	                     Calendar _tmp33 = c;
	                     if(c.get(2) == 4)
	                     {
	                         temp = "May";
	                     } else
	                     {
	                         Calendar _tmp34 = c;
	                         if(c.get(2) == 5)
	                         {
	                             temp = "Jun";
	                         } else
	                         {
	                             Calendar _tmp35 = c;
	                             if(c.get(2) == 6)
	                             {
	                                 temp = "Jul";
	                             } else
	                             {
	                                 Calendar _tmp36 = c;
	                                 if(c.get(2) == 7)
	                                 {
	                                     temp = "Aug";
	                                 } else
	                                 {
	                                     Calendar _tmp37 = c;
	                                     if(c.get(2) == 8)
	                                     {
	                                         temp = "Sep";
	                                     } else
	                                     {
	                                         Calendar _tmp38 = c;
	                                         if(c.get(2) == 9)
	                                         {
	                                             temp = "Oct";
	                                         } else
	                                         {
	                                             Calendar _tmp39 = c;
	                                             if(c.get(2) == 10)
	                                             {
	                                                 temp = "Nov";
	                                             } else
	                                             {
	                                                 Calendar _tmp40 = c;
	                                                 if(c.get(2) == 11)
	                                                     temp = "Dec";
	                                             }
	                                         }
	                                     }
	                                 }
	                             }
	                         }
	                     }
	                 }
	             }
	         }
	         if(Character.isLowerCase(str_old.charAt(str.indexOf("mon"))))
	             temp = temp.toLowerCase();
	         if(Character.isUpperCase(str_old.charAt(str.indexOf("mon"))) && Character.isUpperCase(str_old.charAt(str.indexOf("mon") + 1)))
	             temp = temp.toUpperCase();
	         str = str.replaceAll("mon", temp);
	     }
	     if(str.indexOf("mm") != -1)
	     {
	         Calendar _tmp41 = c;
	         str = str.replaceAll("mm", (c.get(2) + 1) + "");
	     }
	     if(str.indexOf("y,yyy") != -1)
	     {
	         Calendar _tmp42 = c;
	         String yr = c.get(1) + "";
	         yr = yr.substring(1, yr.length());
	         Calendar _tmp43 = c;
	         str = str.replaceAll("y,yyy", c.get(1) / 1000 + "," + yr + "");
	     }
	     if(str.indexOf("syyyy") != -1)
	     {
	         Calendar _tmp44 = c;
	         int i = c.get(0);
	         if(i == 0)
	         {
	             Calendar _tmp45 = c;
	             str = str.replaceAll("syyyy", -c.get(1) + "");
	         } else
	         {
	             Calendar _tmp46 = c;
	             str = str.replaceAll("syyyy", c.get(1) + "");
	         }
	     }
	     if(str.indexOf("yyyy") != -1)
	     {
	         Calendar _tmp47 = c;
	         str = str.replaceAll("yyyy", c.get(1) + "");
	     } else
	     if(str.indexOf("yyy") != -1)
	     {
	         Calendar _tmp48 = c;
	         String yr = c.get(1) + "";
	         yr = yr.substring(1, yr.length());
	         str = str.replaceAll("yyy", yr + "");
	     } else
	     if(str.indexOf("yy") != -1)
	     {
	         Calendar _tmp49 = c;
	         String yr = c.get(1) + "";
	         yr = yr.substring(2, yr.length());
	         str = str.replaceAll("yy", yr + "");
	     } else
	     if(str.indexOf("y") != -1)
	     {
	         Calendar _tmp50 = c;
	         str = str.replaceAll("y", c.get(1) % 10 + "");
	     }
	     if(str.indexOf("dd") != -1)
	     {
	         Calendar _tmp51 = c;
	         str = str.replaceAll("dd", c.get(5) + "");
	     }
	     if(str.indexOf("fm") != -1)
	         str = str.replaceAll("fm", "");
	     return str;
	 }
	
	public static java.sql.Date utilToSqlDate(java.util.Date utilDate){
		
		long sqlDateLong=utilDate.getTime();
		java.sql.Date sqlDate=new java.sql.Date(sqlDateLong);
		return sqlDate;
	}
	public static void main(String[] args) {
		java.util.Date date=(Date) new java.util.Date();
		System.out.println("Date Uitl :"+date);
		//System.out.println("SQL Date :"+utilToSqlDate(date));
		
	}
	
	
}


package com.iii.pel.forms.MailManager;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.iii.pel.forms.sms.SendingSms;
import com.iii.pel.log4j.Log4jServlet;

public class ReminderScheduler implements Job {
	private final static Logger log= Logger
			.getLogger(Log4jServlet.class);
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		System.out.println("schuly");
		log.info("ReminderScheduler begins...");
		System.out.println("ReminderScheduler begins..."+new Date());
		
		SendingSms sendingSms = new SendingSms();
		
		try {			
			sendingSms.remainderMail();
			/*Added by Ameen as per Kuzhandhai Vel sir sugg. on 05-07-2017 for ZBILQC-1725217 */
			sendingSms.claimRemaideMails();
			/*End*/
			
			
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			sendingSms.lapseremainderMail();
			/*End*/
			
			sendingSms.dailyMedicalReminder();
			
			/*added by Ameen on 14-01-2020 for VLA maturity remainder*/
			sendingSms.maturityRemainder();
			/*End*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

package com.iii.pel.forms.MailManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;

import com.iii.pel.log4j.Log4jServlet;
import com.iii.premia.common.utils.CommonUtils;


/*import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;*/




public class MailCreater {
	
	

	private static String host;
	private static String port;
	private static String authName;
	private static String authPass;

	private BodyPart messageBodyPart;

	private MimeMessage message = null;
	private static ResourceBundle resourceBundleEmail = ResourceBundle.getBundle("messageProperties");
	private final static Logger log= Logger
			.getLogger(Log4jServlet.class);
	

	public void sendMail(MailVO mailVO) throws Exception {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiii12222222222");
		log.info("inside sendmail function");
		if(mailVO.getHost()!=null){		
			log.info("Get dynamic Host");
			host=mailVO.getHost();
			System.out.println("***host***"+host);
			port=mailVO.getPort();	
		
		}else{
		
		host = resourceBundleEmail.getString("premia.broker.mail.host");
		port = "587";
		authName = resourceBundleEmail.getString("premia.broker.mail.user");
		authPass = resourceBundleEmail.getString("premia.broker.mail.password");
		log.info("Get Property file host ["+host+"]");
		
		}
		//host = "10.1.46.183";
		Properties props = System.getProperties();

		//Authenticator auth = new PopupAuthenticator();

		/*props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");*/
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		

		// Settings for gmail sender
		if("smtp.gmail.com".equalsIgnoreCase(host.trim())){
			props.put("mail.smtp.port ", "465");
			props.setProperty("mail.smtp.ssl", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.port", "465");   
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");   
			props.put("mail.smtp.socketFactory.fallback", "false");
		}
		
		/*Session session = Session.getInstance(props);*/
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    	    return new PasswordAuthentication(authName,authPass);  
		    	      }  
		    	    }); 
		message = new MimeMessage(session);
		
		

		/*message = new MimeMessage(session);*/

		// Set the from address
		if(mailVO.getFromId() == null) {
			message.setFrom(new InternetAddress(resourceBundleEmail.getString("premia.broker.mail.from"),
					resourceBundleEmail.getString("premia.broker.mail.from.name")));
		} else {
			/*
			 * 
			 * Commented by sankara narayanan for mail sent with fromname
			 * message.setFrom(new InternetAddress(mailVO.getFromId(), mailVO.getFromId()));*/
			message.setFrom(new InternetAddress(mailVO.getFromId(), resourceBundleEmail.getString("premia.broker.mail.from.name")));
		}

		// Set the to address
		for(String to : mailVO.getToList()) {
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		}

		if(mailVO.getCcList() != null) {
			for(String cc : mailVO.getCcList()) {
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			}
		}
		if(mailVO.getBccList() != null) {
			for(String bcc : mailVO.getBccList()) {
				message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
			}
		}
		// Set the subject
		if(mailVO.getSubject() != null) {
			message.setSubject(mailVO.getSubject());
		} else {
			message.setSubject(resourceBundleEmail.getString("premia.broker.mail.subject"));
		}

		// Set the content
		messageBodyPart = new MimeBodyPart();

		if(mailVO.getMessageBody() != null) {
			messageBodyPart.setText(mailVO.getMessageBody());
			/*Added  by ganesh on 03-08-2017,  ZBILQC-1731915 */
			/*messageBodyPart.setContent(mailVO.getMessageBody(), "text/plain");*/
			
			String mailContentType = "text/plain";
			if(mailVO.getMessageBody().contains("<") && mailVO.getMessageBody().contains(">")){
				mailContentType = "text/html";
			}else{
				mailContentType = "text/plain";
			}			
			messageBodyPart.setContent(mailVO.getMessageBody(), mailContentType);
			/*end*/
		} else {
			messageBodyPart.setText(resourceBundleEmail.getString("premia.broker.mail.body"));
		}

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		if(mailVO.getFileList() != null) {
			for(File file : mailVO.getFileList()) {
				if (file != null) {
					messageBodyPart = new MimeBodyPart();

					DataSource source = new FileDataSource(file);

					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(file.getName());

					multipart.addBodyPart(messageBodyPart);

				}
			}
		}
		/*Added by Sivarajan on 08-08-2018 for FSD_IL_FLA_005*/
		if(mailVO.getByteArray() != null) {			
			messageBodyPart = new MimeBodyPart();
			DataSource source = new ByteArrayDataSource(mailVO.getByteArray(), "text/pdf");
			messageBodyPart.setDataHandler(new DataHandler(source));
			Date simpledateformat = new Date();
		    String sysDate=new SimpleDateFormat("dd-MM-yyyy").format(simpledateformat);
		    sysDate = sysDate.replaceAll("-","");
			if(mailVO.getFileName() != null){
				messageBodyPart.setFileName(mailVO.getFileName().replaceAll(" ","_")+"_"+sysDate+".pdf");
			}else{
				messageBodyPart.setFileName("Report_"+sysDate+".pdf");
			}
			multipart.addBodyPart(messageBodyPart);
			//multipart.
		}
		/*End*/
		// testing for outlook calendar entry

		if(mailVO.getTitle() != null) {
			// Fill the message
			DataHandler handler = new DataHandler(new OutlookMeetingDataSource(generateICSContent(mailVO)));
			messageBodyPart.setDataHandler(handler);
			messageBodyPart.setFileName("alert.ics");
		}
		message.setContent(multipart);

		// Send message
		Transport.send(message);
		log.info("Mail Creater: Successfully Sent");
	}

	public String generateICSContent(MailVO mailVO){

		String lineSeparator = System.getProperty("line.separator");
		StringBuffer bodyBuffer = new StringBuffer();
		
		bodyBuffer.append("BEGIN:VCALENDAR");
		bodyBuffer.append(lineSeparator);
		// Need to check without prodid
		bodyBuffer.append("PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN");
		bodyBuffer.append(lineSeparator);

		bodyBuffer.append("VERSION:2.0");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("METHOD:PUBLISH");
		bodyBuffer.append(lineSeparator);
		
		// Added for ics
		bodyBuffer.append("BEGIN:VTIMEZONE");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZID:Chennai,Kolkata,Mumbai,New Delhi");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("BEGIN:STANDARD");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DTSTART:");
		bodyBuffer.append(dateFormater(mailVO.getEventToDate(), MailCreater.REF_TIME_START));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("RRULE:FREQ=YEARLY;INTERVAL=1;BYDAY=1SU;BYMONTH=11");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZOFFSETFROM:+0430");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZOFFSETTO:+0530");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZNAME:Standard Time");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("END:STANDARD");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("BEGIN:DAYLIGHT");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DTSTART:");
		bodyBuffer.append(dateFormater(mailVO.getEventToDate(), MailCreater.REF_TIME_START));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("RRULE:FREQ=YEARLY;INTERVAL=1;BYDAY=1SU;BYMONTH=11");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZOFFSETFROM:+0430");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZOFFSETTO:+0530");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TZNAME:Standard Time");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("END:DAYLIGHT");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("END:VTIMEZONE");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("BEGIN:VEVENT");
		bodyBuffer.append(lineSeparator);
		
		bodyBuffer.append("DTSTART;TZID=\"Chennai,Kolkata,Mumbai,New Delhi\":");
		bodyBuffer.append(dateFormater(mailVO.getEventToDate(), MailCreater.REF_TIME_START));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DTEND;TZID=\"Chennai,Kolkata,Mumbai,New Delhi\":");
		bodyBuffer.append(dateFormater(mailVO.getEventToDate(), MailCreater.REF_TIME_END));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("LOCATION;ENCODING=QUOTED-PRINTABLE:");
		bodyBuffer.append(mailVO.getLocation());
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("UID:60952664");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DTSTAMP:");
		bodyBuffer.append(dateFormater(mailVO.getEventToDate(), MailCreater.REF_TIME_START));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DESCRIPTION:");
		bodyBuffer.append(mailVO.getDescription() == null ? "" : mailVO.getDescription().replace("{5}", "\\n"));
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("SUMMARY;ENCODING=QUOTED-PRINTABLE:");
		bodyBuffer.append(mailVO.getTitle());
		bodyBuffer.append(lineSeparator);
		
		bodyBuffer.append("BEGIN:VALARM");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("TRIGGER:-PT10080M");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("ACTION:DISPLAY");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("DESCRIPTION:Reminder");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("END:VALARM");
		bodyBuffer.append(lineSeparator);
		
		bodyBuffer.append("END:VEVENT");
		bodyBuffer.append(lineSeparator);
		bodyBuffer.append("END:VCALENDAR");

		return bodyBuffer.toString();
	}
	
	/*static class PopupAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String userName = Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.user");//"vasl50188";//
			String password = Messages.getString(PELConstants.pelMessagePropertiesPath, "premia.broker.mail.password");//"trio125peg219";
			return new PasswordAuthentication(userName, password);
		}
	}*/

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public BodyPart getMessageBodyPart() {
		return messageBodyPart;
	}

	public void setMessageBodyPart(BodyPart messageBodyPart) {
		this.messageBodyPart = messageBodyPart;
	}

	public MimeMessage getMessage() {
		return message;
	}

	public void setMessage(MimeMessage message) {
		this.message = message;
	}

	//Constatnts for Time Reference
	public static int REF_TIME_CALENDAR = 0;
	public static int REF_TIME_START = 1;
	public static int REF_TIME_END = 2;
	/**
	 * Formats Date and time will be considered based on timeReference provided
	 * 0-	Calendar Time
	 * 1-	Start Time
	 * 2-	End Time
	 * @param date
	 * @param timeReference
	 * @return
	 */
	private String dateFormater(Date date, int timeReference) {

		StringBuffer buffer = new StringBuffer("");
		if(date != null) {
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(date);

			buffer.append(calendar.get(Calendar.YEAR));
			buffer.append((calendar.get(Calendar.MONTH) + 1) / 10 == 0 ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1));
			buffer.append((calendar.get(Calendar.DAY_OF_MONTH)) / 10 == 0 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH));
			buffer.append("T");
			if(timeReference == REF_TIME_CALENDAR){
				String hrs = (String) (calendar.get(Calendar.HOUR_OF_DAY) == 0 ? "00" : calendar.get(Calendar.HOUR_OF_DAY) + "");
				buffer.append(hrs.length() == 1 ? ("0" + hrs) : hrs);
				String min = (String) (calendar.get(Calendar.MINUTE) == 0 ? "00" : calendar.get(Calendar.MINUTE) + "");
				buffer.append(min.length() == 1 ? ("0" + min) : min);
				String sec = (String) (calendar.get(Calendar.SECOND) == 0 ? "00" : calendar.get(Calendar.SECOND) + "");
				buffer.append(sec.length() == 1 ? ("0" + sec) : sec);
			}else if(timeReference == REF_TIME_START){
				String hrs = "08";
				buffer.append(hrs.length() == 1 ? ("0" + hrs) : hrs);
				String min = "00";
				buffer.append(min.length() == 1 ? ("0" + min) : min);
				String sec = "00";
				buffer.append(sec.length() == 1 ? ("0" + sec) : sec);
			}else if(timeReference == REF_TIME_END){
				String hrs = "16";
				buffer.append(hrs.length() == 1 ? ("0" + hrs) : hrs);
				String min = "00";
				buffer.append(min.length() == 1 ? ("0" + min) : min);
				String sec = "00";
				buffer.append(sec.length() == 1 ? ("0" + sec) : sec);
			}
		}
		return buffer.toString();
	}
	
	
}

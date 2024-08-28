package com.iii.pel.forms.MailManager;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MailVO implements Serializable, Cloneable {

	private List<String> toList;

	private List<String> ccList;

	private List<String> bccList;

	private String subject;

	private String messageBody;

	private String fromId;

	private String fromName;

	private List<File> fileList;

	// for outlook event

	private Date eventFromDate;

	private Date eventToDate;

	private String description;

	private String title;

	private String priority;

	private String location;

	private String Host;
	private String Port;
	/*Added by Sivarajan on 13-08-2018 for FSD_IL_FLA_005*/
	private byte[] byteArray;
	
	
	private String fileName;
	/*End*/
	
	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
	}

	public String getPort() {
		return Port;
	}

	public void setPort(String port) {
		Port = port;
	}
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getToList() {
		return toList;
	}

	public void setToList(List<String> toList) {
		this.toList = toList;
	}

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public List<String> getBccList() {
		return bccList;
	}

	public void setBccList(List<String> bccList) {
		this.bccList = bccList;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public List<File> getFileList() {
		return fileList;
	}

	public void setFileList(List<File> fileList) {
		this.fileList = fileList;
	}

	public Date getEventFromDate() {
		return eventFromDate;
	}

	public void setEventFromDate(Date eventFromDate) {
		this.eventFromDate = eventFromDate;
	}

	public Date getEventToDate() {
		return eventToDate;
	}

	public void setEventToDate(Date eventToDate) {
		this.eventToDate = eventToDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		if (priority == null) {
			return "5";
		}
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	/*Added by Sivarajan on 13-08-2018 for FSD_IL_FLA_005*/
	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/*End*/
	
}

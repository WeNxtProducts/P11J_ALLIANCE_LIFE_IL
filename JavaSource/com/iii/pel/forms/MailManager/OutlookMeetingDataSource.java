package com.iii.pel.forms.MailManager;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;


class OutlookMeetingDataSource implements DataSource {

	private byte[] data;

	public OutlookMeetingDataSource(String data) {
		try {
			this.data = data.getBytes("UTF-8");
		} catch (UnsupportedEncodingException uex) {
		}
	}

	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(data);
	}

	public OutputStream getOutputStream() throws IOException {
		throw new IOException("Unsupported operation. We can only send Outlook Meeting invites with this handler, not receive them.");
	}

	public String getContentType() {
		return "text/calendar; method=REQUEST; charset=\"UTF-8\"";
	}

	public String getName()	{
		return "Microsoft Outlook Calendar Item";
	}
}



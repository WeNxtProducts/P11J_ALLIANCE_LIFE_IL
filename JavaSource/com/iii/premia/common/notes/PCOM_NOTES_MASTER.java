package com.iii.premia.common.notes;

import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PCOM_NOTES_MASTER")
public class PCOM_NOTES_MASTER extends BaseValueBean {

	@Column(name = "PNM_SCREEN_ID")
	private String	PNM_SCREEN_ID;
	
	@Column(name = "PNM_TRANSACTION_ID")
	private String	PNM_TRANSACTION_ID;

	@Column(name = "PNM_NOTES_CONTENT")
	private String	PNM_NOTES_CONTENT ;

	@Column(name = "PNM_SYS_ID")
	private Long PNM_SYS_ID;
	
	@Column(name = "PNM_CR_UID")
	private String PNM_CR_UID;

	private Date PNM_CR_TIMESTAMP;
	
	private String UI_PNM_CR_TIMESTAMP;
	
	
	private String imageDisplayHeight="150px";
	private String imageDisplayWidth="200px";
	private String	mime	= "text";
	
	private ArrayList<PCOM_NOTES_TAGGED_USERS> taggedUsersList;

	public PCOM_NOTES_MASTER(){
		taggedUsersList = new ArrayList<PCOM_NOTES_TAGGED_USERS>();
	}
	
	public PCOM_NOTES_MASTER(Long sysId, String screenId, String transId, String content, String crUid, Date crDate, ArrayList<PCOM_NOTES_TAGGED_USERS> tagList){
		PNM_SYS_ID = sysId;
		PNM_SCREEN_ID = screenId;
		PNM_TRANSACTION_ID = transId;
		PNM_NOTES_CONTENT = content;
		PNM_CR_UID = crUid;
		PNM_CR_TIMESTAMP = crDate;
		taggedUsersList = tagList;
	}
	
	
	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getImageDisplayHeight() {
		System.out.println("------->get imageDisplayHeight in bean: "+imageDisplayHeight);
		return imageDisplayHeight;
	}

	public void setImageDisplayHeight(String imageDisplayHeight) {
		System.out.println("------->set imageDisplayHeight in bean: "+imageDisplayHeight);
		this.imageDisplayHeight = imageDisplayHeight;
	}

	public String getImageDisplayWidth() {
		System.out.println("------->get imageDisplayWidth in bean: "+imageDisplayWidth);
		return imageDisplayWidth;
	}

	public void setImageDisplayWidth(String imageDisplayWidth) {
		System.out.println("------->set imageDisplayWidth in bean: "+imageDisplayWidth);
		this.imageDisplayWidth = imageDisplayWidth;
	}

	public String getPNM_SCREEN_ID() {
		return PNM_SCREEN_ID;
	}

	public void setPNM_SCREEN_ID(String pnm_screen_id) {
		PNM_SCREEN_ID = pnm_screen_id;
	}

	public String getPNM_TRANSACTION_ID() {
		return PNM_TRANSACTION_ID;
	}

	public void setPNM_TRANSACTION_ID(String pnm_transaction_id) {
		PNM_TRANSACTION_ID = pnm_transaction_id;
	}

	public String getPNM_NOTES_CONTENT() {
		return PNM_NOTES_CONTENT;
	}

	public void setPNM_NOTES_CONTENT(String pnm_notes_content) {
		PNM_NOTES_CONTENT = pnm_notes_content;
	}

	public Long getPNM_SYS_ID() {
		return PNM_SYS_ID;
	}

	public void setPNM_SYS_ID(Long pnm_sys_id) {
		PNM_SYS_ID = pnm_sys_id;
	}

	public String getPNM_CR_UID() {
		return PNM_CR_UID;
	}

	public void setPNM_CR_UID(String pnm_cr_uid) {
		PNM_CR_UID = pnm_cr_uid;
	}

	public Date getPNM_CR_TIMESTAMP() {
		return PNM_CR_TIMESTAMP;
	}

	public void setPNM_CR_TIMESTAMP(Date pnm_cr_timestamp) {
		PNM_CR_TIMESTAMP = pnm_cr_timestamp;
		setUI_PNM_CR_TIMESTAMP(CommonUtils.dateToPELStringFormatterWithTimeStamp(PNM_CR_TIMESTAMP));
	}

	public ArrayList<PCOM_NOTES_TAGGED_USERS> getTaggedUsersList() {
		return taggedUsersList;
	}

	public void setTaggedUsersList(
			ArrayList<PCOM_NOTES_TAGGED_USERS> taggedUsersList) {
		this.taggedUsersList = taggedUsersList;
	}
	
	public int getTagListSize(){
		return taggedUsersList.size();
	}

	public String getUI_PNM_CR_TIMESTAMP() {
		return UI_PNM_CR_TIMESTAMP;
	}

	public void setUI_PNM_CR_TIMESTAMP(String ui_pnm_cr_timestamp) {
		UI_PNM_CR_TIMESTAMP = ui_pnm_cr_timestamp;
	}


	/*// Added to handle documents icon and link
	public static String supportedDocumentExtensions = Messages.getString("messageProperties_fileUpload", 
		"FILE_UPLOAD$DOCUMENTS$SUPPORTED_FILE_EXTENSIONS").toLowerCase()+",";
	public String getImageIconForDoc(){
		String imageIconName = "document.gif";
		String docExtension = null;
		
		docExtension = getDocumentExtension();
		if(docExtension != null){
			docExtension = docExtension.toLowerCase();
			if(supportedDocumentExtensions.contains(docExtension + ","))
			if("pdf".equals(docExtension)){
				imageIconName = "pdf.gif";//docExtension.toLowerCase().concat(".gif");
			}
		}
		
		return imageIconName;
	}*/
	
	/*public boolean isImageFile(){
		boolean isAnImage = true;
		String docExtension = null;
		
		docExtension = getDocumentExtension();
		if(docExtension != null && supportedDocumentExtensions.contains(
				docExtension.toLowerCase()+",")){
			isAnImage = false;
		}
		
		return isAnImage;
	}*/
	
	/*public String getDocumentExtension(){
		String docExtension = null;
		int startIndex = -1;

		if(this.getLIMG_IMAGE_FILE() != null){
			startIndex = this.getLIMG_IMAGE_FILE().lastIndexOf(".");
			if(startIndex != -1){
				docExtension = this.getLIMG_IMAGE_FILE().substring(startIndex + 1);
			}
		}
		return docExtension;
	}*/

	
}

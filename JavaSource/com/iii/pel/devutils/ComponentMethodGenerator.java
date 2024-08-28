package com.iii.pel.devutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ComponentMethodGenerator {
	final String CLASS_CANONICAL_NAME = "com.iii.pel.forms.PILM042.PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION";
	final String[] CONSIDERED_CLASSES = {"HtmlInputText", 
										"HtmlSelectOneMenu", 
										"HtmlCalendar", 
										"HtmlCommandButton", 
										"HtmlCommandLink"};
	final String[] CONSIDERED_METHODS = {"Instantiate", 
										"Reset", 
										"Disabled"};

	/* 
	Possible values for considered classes: 
	"HtmlOutputLabel", "HtmlInputText", "HtmlSelectOneMenu", "HtmlCalendar", "HtmlCommandButton", "HtmlCommandLink"
	
	Possible values of considered methods:
	"Instantiate", "Reset", "Disabled"
	*/
	
	final String CLASS_NAME = CLASS_CANONICAL_NAME.substring(CLASS_CANONICAL_NAME.lastIndexOf(".")+1);
	final String INST_METHOD_COMMENT = "Instantiates all components in " + CLASS_NAME;
	final String RESET_METHOD_COMMENT = "Resets all components in " + CLASS_NAME;
	final String DISABLE_METHOD_COMMENT = "Disables all components in " + CLASS_NAME;
	
	final String htmlOutputLabelClass = "javax.faces.component.html.HtmlOutputLabel";
	final String htmlInputTextClass = "javax.faces.component.html.HtmlInputText";
	final String tmlSelectOneMenuClass = "javax.faces.component.html.HtmlSelectOneMenu";
	final String htmlCalendarClass = "org.richfaces.component.html.HtmlCalendar";
	final String htmlCommandButtonClass = "javax.faces.component.html.HtmlCommandButton";
	final String htmlCommandLinkClass = "javax.faces.component.html.HtmlCommandLink";
	
	final String INST_ALL_COMP_METHOD_SIGNATURE = "public void instantiateAllComponent(){";
	final String RESET_ALL_COMP_METHOD_SIGNATURE = "public void resetAllComponent(){";
	final String DISABLE_ALL_COMP_METHOD_SIGNATURE = "public void disableAllComponent(boolean disabled){";
	final String CLOSING_BRACE = "}";
	final String LINE_SEPARATOR = System.getProperty("line.separator");
	final String TAB_SEPARATOR = "\t";
	final String JAVA_DOC_TEMPLATE = TAB_SEPARATOR + "/**" + LINE_SEPARATOR 
		+ TAB_SEPARATOR + " * {0}" + LINE_SEPARATOR 
		+ TAB_SEPARATOR + " */" + LINE_SEPARATOR;
	final String INST_METHOD_JAVA_DOC = JAVA_DOC_TEMPLATE.replace("{0}", INST_METHOD_COMMENT);
	final String RESET_METHOD_JAVA_DOC = JAVA_DOC_TEMPLATE.replace("{0}", RESET_METHOD_COMMENT);
	final String DISABLE_METHOD_JAVA_DOC = JAVA_DOC_TEMPLATE.replace("{0}", DISABLE_METHOD_COMMENT);
	final int TAB_CHARS = 8;
	final int TAB_BEFORE_EQUAL = 6;
	
	ArrayList<String> htmlOutputLabelList;
	ArrayList<String> htmlInputTextList;
	ArrayList<String> htmlSelectOneMenuList;
	ArrayList<String> htmlCalendarList;
	ArrayList<String> htmlCommandButtonList;
	ArrayList<String> htmlCommandLinkList;
	
	StringBuffer buffer = null;
	
	public static void main(String args[]){
		new ComponentMethodGenerator().generateMethods();
	}
	
	private void generateMethods(){
		buffer = new StringBuffer();
		int consideredMethodsLength = CONSIDERED_METHODS.length;
		String currentMethod = null; 
		
		try {
			generateComponentList();
			for(int index=0; index<consideredMethodsLength; index++){
				currentMethod = CONSIDERED_METHODS[index];
				if("Instantiate".equals(currentMethod)){
					prepareInstantiateMethod(buffer);
				}else if("Reset".equals(currentMethod)){
					prepareResetMethod(buffer);
				}else if("Disabled".equals(currentMethod)){
					prepareDisableMethod(buffer);
				} 
			}
			System.out.println(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void prepareInstantiateMethod(StringBuffer buffer){
		int consideredClassesLength = CONSIDERED_CLASSES.length;
		String currentClass = null; 
		buffer.append(LINE_SEPARATOR);
		buffer.append(INST_METHOD_JAVA_DOC);
		buffer.append(TAB_SEPARATOR);
		buffer.append(INST_ALL_COMP_METHOD_SIGNATURE);
		buffer.append(LINE_SEPARATOR);

		for(int index=0; index<consideredClassesLength; index++){
			currentClass = CONSIDERED_CLASSES[index];
			if("HtmlOutputLabel".equals(currentClass)){
				instantiateComponentList(htmlOutputLabelList, "HtmlOutputLabel", buffer);
			}else if("HtmlInputText".equals(currentClass)){
				instantiateComponentList(htmlInputTextList, "HtmlInputText", buffer);
			}else if("HtmlSelectOneMenu".equals(currentClass)){
				instantiateComponentList(htmlSelectOneMenuList, "HtmlSelectOneMenu", buffer);
			}else if("HtmlCalendar".equals(currentClass)){
				instantiateComponentList(htmlCalendarList, "HtmlCalendar", buffer);
			}else if("HtmlCommandButton".equals(currentClass)){
				instantiateComponentList(htmlCommandButtonList, "HtmlCommandButton", buffer);
			}else if("HtmlCommandLink".equals(currentClass)){
				instantiateComponentList(htmlCommandLinkList, "HtmlCommandLink", buffer);
			} 
		}
		
		buffer.append(TAB_SEPARATOR + CLOSING_BRACE + LINE_SEPARATOR);
	}
	
	private void prepareResetMethod(StringBuffer buffer){
		buffer.append(LINE_SEPARATOR);
		buffer.append(RESET_METHOD_JAVA_DOC);
		buffer.append(TAB_SEPARATOR);
		buffer.append(RESET_ALL_COMP_METHOD_SIGNATURE);
		buffer.append(LINE_SEPARATOR);

		//instantiateComponentList(htmlOutputLabelList, "HtmlOutputLabel", buffer);
		resetComponentList(htmlInputTextList, "HtmlInputText", buffer);
		resetComponentList(htmlSelectOneMenuList, "HtmlSelectOneMenu", buffer);
		resetComponentList(htmlCalendarList, "HtmlCalendar", buffer);
		resetComponentList(htmlCommandButtonList, "HtmlCommandButton", buffer);
		resetComponentList(htmlCommandLinkList, "HtmlCommandLink", buffer);
		
		buffer.append(TAB_SEPARATOR + CLOSING_BRACE + LINE_SEPARATOR);
	}
	
	private void prepareDisableMethod(StringBuffer buffer){
		buffer.append(LINE_SEPARATOR);
		buffer.append(DISABLE_METHOD_JAVA_DOC);
		buffer.append(TAB_SEPARATOR);
		buffer.append(DISABLE_ALL_COMP_METHOD_SIGNATURE);
		buffer.append(LINE_SEPARATOR);

		//instantiateComponentList(htmlOutputLabelList, "HtmlOutputLabel", buffer);
		disableComponentList(htmlInputTextList, "HtmlInputText", buffer);
		disableComponentList(htmlSelectOneMenuList, "HtmlSelectOneMenu", buffer);
		disableComponentList(htmlCalendarList, "HtmlCalendar", buffer);
		disableComponentList(htmlCommandButtonList, "HtmlCommandButton", buffer);
		disableComponentList(htmlCommandLinkList, "HtmlCommandLink", buffer);
		
		buffer.append(TAB_SEPARATOR + CLOSING_BRACE + LINE_SEPARATOR);
	}
	
	private void instantiateComponentList(ArrayList<String> componentList, String componentType, StringBuffer buffer){
		Iterator<String> iterator = null;
		String fieldName = null;
		
		if(componentList != null && componentList.size()>0){
			buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + "// Instantiating "+componentType + LINE_SEPARATOR);
			iterator = componentList.iterator();
			while(iterator.hasNext()){
				fieldName = iterator.next();
				buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + fieldName);
				addTabsAfterComponentName(buffer, fieldName);
				buffer.append(" = new "+ componentType + "();" + LINE_SEPARATOR);
			}
			buffer.append(LINE_SEPARATOR);
		}
	}
	
	private void resetComponentList(ArrayList<String> componentList, String componentType, StringBuffer buffer){
		Iterator<String> iterator = null;
		String fieldName = null;
		
		if(componentList != null && componentList.size()>0){
			buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + "// Reseting "+componentType + LINE_SEPARATOR);
			iterator = componentList.iterator();
			while(iterator.hasNext()){
				fieldName = iterator.next();
				buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + fieldName +".resetValue();");
				buffer.append(LINE_SEPARATOR);
			}
			buffer.append(LINE_SEPARATOR);
		}
	}
	
	private void disableComponentList(ArrayList<String> componentList, String componentType, StringBuffer buffer){
		Iterator<String> iterator = null;
		String fieldName = null;
		
		if(componentList != null && componentList.size()>0){
			buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + "// Disabling "+componentType + LINE_SEPARATOR);
			iterator = componentList.iterator();
			while(iterator.hasNext()){
				fieldName = iterator.next();
				buffer.append(TAB_SEPARATOR + TAB_SEPARATOR + fieldName +".setDisabled(disabled);");
				buffer.append(LINE_SEPARATOR);
			}
			buffer.append(LINE_SEPARATOR);
		}
	}
	
	private void addTabsAfterComponentName(StringBuffer buffer, String fieldName){
		int fieldLength = fieldName.length();
		int tabUsed = fieldLength%TAB_CHARS>=0?fieldLength/TAB_CHARS:(fieldLength/8)+1;

		while(tabUsed < TAB_BEFORE_EQUAL){
			buffer.append(TAB_SEPARATOR);
			tabUsed++;
		}
	}
	
	private void generateComponentList() throws Exception{
		Class classclass = null;
		Field[] fields = null;
		Field field = null;
		String fieldClass = null;
		
		try {
			classclass = Class.forName(CLASS_CANONICAL_NAME);
			fields = classclass.getDeclaredFields();
			if(fields != null && fields.length > 0){
				instantiateComponentList();
				for(int size=fields.length, index=0; index<size; index++){
					field = fields[index];
					fieldClass = field.getType().getName();
					if(htmlOutputLabelClass.equals(fieldClass)){
						htmlOutputLabelList.add(field.getName());
					}else if(htmlInputTextClass.equals(fieldClass)){
						htmlInputTextList.add(field.getName());
					}else if(tmlSelectOneMenuClass.equals(fieldClass)){
						htmlSelectOneMenuList.add(field.getName());
					}else if(htmlCalendarClass.equals(fieldClass)){
						htmlCalendarList.add(field.getName());
					}else if(htmlCommandButtonClass.equals(fieldClass)){
						htmlCommandButtonList.add(field.getName());
					}else if(htmlCommandLinkClass.equals(fieldClass)){
						htmlCommandLinkList.add(field.getName());
					}
				}
			} else{
				throw new Exception("No Field found in the configured class: " + CLASS_CANONICAL_NAME);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private void instantiateComponentList(){
		htmlOutputLabelList = new ArrayList<String>();
		htmlInputTextList = new ArrayList<String>();
		htmlSelectOneMenuList = new ArrayList<String>();
		htmlCalendarList = new ArrayList<String>();
		htmlCommandButtonList = new ArrayList<String>();
		htmlCommandLinkList = new ArrayList<String>();
	}
}

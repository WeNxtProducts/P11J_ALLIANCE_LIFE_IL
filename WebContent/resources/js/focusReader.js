var currentFocus=null;

function setFocus(id,currid){
//alert(currentFocus);	
	if (currentFocus !=null && currentFocus == currid){	
	//alert('1st if')	
		focusElement=document.getElementById(id);		
		if (focusElement && !focusElement.disabled && focusElement.focus){			
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}
		return;
	}else if (currentFocus !=null && currentFocus != id){	
	//alert('second if')		
		focusElement=document.getElementById(currentFocus);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}
		return;
	}else if (currentFocus !=null){	
	//alert('3rd if')
		focusElement=document.getElementById(currentFocus);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}
		return;
	}else{	
	//alert('4th if')
		focusElement=document.getElementById(id);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}
		return;
	}		
}
function defaultFocus(id){
		var focusElement=document.getElementById(id);				
		if (focusElement && !focusElement.disabled && focusElement.focus){		
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}		
		return;
}
function currFocus(id){
	currentFocus=id;
}
function formatDate(id){
	var element = document.getElementById(id+'InputDate');
	value=element.value;
	var day;		
	var month;
	var year;
	var numbers;
	var separator;
	var doformating = false;
	
	if (value && value.indexOf('/') >= 0){
		separator = "/";
		//alert('Found /');
	}else if(value && value.indexOf('-') >= 0){
		separator = "-";
		//alert('Found -');
	}else if(value && value.indexOf('.') >= 0){
		separator = ".";
		//alert('Found .');
	}
	//alert('Separator: '+separator);

	if(separator != null){
		doformating = true;
		numbers = value.split(separator);
		day = numbers[0];
		month = numbers[1];
		year = numbers[2];
	}
	//alert('After split- value: ' + value + ', doformating: ' + doformating + ', Day: ' + day + ', Month: ' + month + ', Year: ' +year);
  
	if (value && value.indexOf('/')<0 && value.indexOf('-')<0 && value.indexOf('.')<0){
		doformating = true;
		day=value.substr(0,2);		
		month=value.substr(2,2);
		year=value.substr(4,4);
	}
	
	if(doformating){
		//alert('value: ' + value + ', Day: ' + day + ', Month: ' + month + ', Year: ' +year);
		if (!isNaN(day) && !isNaN(month) && !isNaN(year)) {
			//alert('Going to format date');
			// Handle two-digit year 
			if(year < 100){
				if(year < 50){
					year = 20+ trim(year) ;
				}else{
					year = 19 + trim(year);
				}
			}
			
			//alert('year: '+year);
			if(month == '08' || month == '09'){
				monthInt=parseInt(month,10);
			}else{
				monthInt=parseInt(month)
			}
			//alert('monthInt'+monthInt);
			dayInt=parseInt(day)
			yearInt=parseInt(year)
			 
		 	if (month.length<1 || monthInt<1 || monthInt>12){
				//alert("Please enter a valid month"+monthInt);
				return false;
			}
		
			if (year.length != 4 || yearInt==0  ){
			//	alert("Please enter a valid 4 digit year ");
				return false;
			}
		    var date = new Date(year, month-1, day);
			var calcomp=document.getElementById(id).component;
			val=Richfaces.Calendar.formatDate(date, calcomp.params.datePattern, calcomp.params.monthLabels, calcomp.params.monthLabelsShort);
			element.value=val;
		}
	}
}

function trim(str){
	if(!str || typeof str != 'string')
		return null;
	return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
}

function setFocusforDisable(id,currid,nextid){
//alert(currentFocus);	
		nextfocusElement=document.getElementById(nextid);
	if (currentFocus !=null && currentFocus == currid){	
	//alert('1st if');
		focusElement=document.getElementById(id);
		nextfocusElement=document.getElementById(nextid);
		if (focusElement && !focusElement.disabled && focusElement.focus){			
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}else if (nextfocusElement && !nextfocusElement.disabled && nextfocusElement.focus){			
			nextfocusElement.focus();
			if (nextfocusElement.select) nextfocusElement.select();
		}
		return;
	}else if (currentFocus !=null && currentFocus == nextid){	
	//alert('second if')		
		focusElement=document.getElementById(id);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			//alert(focusElement)
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}else if (nextfocusElement && !nextfocusElement.disabled && nextfocusElement.focus){			
			nextfocusElement.focus();
			if (nextfocusElement.select) nextfocusElement.select();
		}
		return;
	}else if (currentFocus !=null && currentFocus != id){	
	//alert('third if')		
		focusElement=document.getElementById(currentFocus);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			//alert(focusElement)
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}else if (nextfocusElement && !nextfocusElement.disabled && nextfocusElement.focus){			
			nextfocusElement.focus();
			if (nextfocusElement.select) nextfocusElement.select();
		}
		return;
	}else if (currentFocus !=null){	
	//alert('4th if')
		focusElement=document.getElementById(currentFocus);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}else if (nextfocusElement && !nextfocusElement.disabled && nextfocusElement.focus){			
			nextfocusElement.focus();
			if (nextfocusElement.select) nextfocusElement.select();
		}
		return;
	}else{	
	//alert('5th if')
		focusElement=document.getElementById(id);
		if (focusElement && !focusElement.disabled && focusElement.focus){
			focusElement.focus();
			if (focusElement.select) focusElement.select();
		}else if (nextfocusElement && !nextfocusElement.disabled && nextfocusElement.focus){			
			nextfocusElement.focus();
			if (nextfocusElement.select) nextfocusElement.select();
		}
		return;
	}		
}



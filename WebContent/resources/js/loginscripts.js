    function buttonDown(buttonelement)
    {
    // add for storing the caption into array 
    if(check == true){
    	capArr = returnArray();
    	check = false;
    	}
		//var textfield = document.getElementById('login:password');
		//var buttoncomp = document.getElementById(buttonid);
		//buttonvalue = buttoncomp.value;
		//buttoncomp.value='#';
		//textfield.value = textfield.value + buttonelement.value;
		// Changing captions
		//changeCaptions();
		
		// Hilighting caps button
		if(buttonelement.id == 'login:CpsLock'){
			alterCaps(buttonelement);
		}else if(buttonelement.id == 'login:Clr'){
			clearText();
		}else if(buttonelement.id == 'login:BackSpace'){
			clearLastChar();
		}
		else{
		
			var textfield = document.getElementById('login:password');
			textfield.value = textfield.value + buttonelement.value;
			
		}
		changeCaptions();
		return false;
    }
    
    function valueVcardDeffault(){
    //alert(document.getElementById('login:VCARD1_HEADER').innerText);
    document.getElementById('login:username').value = document.getElementById('login:VCARD1_HEADER').innerText;
    document.getElementById('login:companyCode').value = document.getElementById('login:COMPANY').innerText;
    document.getElementById('login:divisionCode').value = document.getElementById('login:BRANCH').innerText;
    document.getElementById('login:departmentCode').value = document.getElementById('login:DEPARTMENT').innerText;
 	//document.getElementById('login:sel_item').value = document.getElementById('login:LANG').innerText;
 	//var e = document.getElementById('login:sel_item');
 	
 	//alert('hi'+document.getElementById('login:LANG').innerText);
 	//var strUser = e.options[e.selectedIndex].value;
   
 	
 	document.getElementById('login:username').focus();
 	document.getElementById('login:password').focus();
 	
        }
    function buttonUp(buttonelement)
    {
		//document.getElementById(buttonid).value='A';
		restoreCaptions();
		return false;
    }
    function notallowed()
    {
    	if(event.ctrlKey || event.altKey || event.shiftKey) { 
			//alert('Shortcut keys pressed..');
    	}else{
			alert('Please use mouse only for virtual keyboard!!');
		}
		return false;
    }
    function changeCaptions(){
    	
		newValue = '#'
		var divElement=document.getElementById('login:VKB_TOP_PG');
		var divChildren = divElement.getElementsByTagName('*');
		var size=divChildren.length;
		var i=0;
		for(i=size; i >= 0; i=i-1){
		  if (divChildren[i]!=undefined)
		  	   divChildren[i].value=newValue;
		}
    }
    // function add for mozila compatibility
 	function returnArray(){
 	var arr = new Array(200);
 	var divElement=document.getElementById('login:VKB_TOP_PG');
					var divChildren = divElement.getElementsByTagName('*');
					var size=divChildren.length;
					var i=0;
					for(i=size; i >= 0; i=i-1){
						if (divChildren[i] != undefined) {
							if(divChildren[i].value != undefined){
								arr[i] = divChildren[i].value;
							}
				   	  	}
			   	  	}
 		return arr;
 	}
 
  function restoreCaptions(){
  		var divElement=document.getElementById('login:VKB_TOP_PG');
		var divChildren = divElement.getElementsByTagName('*');
		var size=divChildren.length;
		var i=0;
		for(i=size; i >= 0; i=i-1){
		 if (divChildren[i] != undefined) {
		    if(capson == false) {
		    if(capArr[i] != undefined){
		  	   //divChildren[i].value=divChildren[i].defaultValue;
		  	   divChildren[i].value=capArr[i].toLowerCase();
		  	  
		  	}
		  	}
		  	else {
		  	  if(capArr[i] != undefined){
		  	   //divChildren[i].value=(divChildren[i].defaultValue);
		  	   divChildren[i].value=capArr[i];
		  	   if(divChildren[i].value != null) {
		  	      if(divChildren[i].id != 'login:CpsLock' || divChildren[i].id != 'login:Clr' || divChildren[i].id != 'login:BackSpace')
		  	      	divChildren[i].value= divChildren[i].value.toUpperCase();
		  	     if(divChildren[i].type != null) {
		  	        if(divChildren[i].id == 'login:CpsLock' || divChildren[i].id == 'login:Clr' || divChildren[i].id == 'login:BackSpace')
		  	          {
		  	          	//divChildren[i].value=divChildren[i].defaultValue;
		  	          	divChildren[i].value=capArr[i];
		  	          }
		  	      } 
		  	   }
		  	}
		  }
        }
   	  }
    }
   
    function clearText(){
    	document.getElementById('login:password').value='';
    	return false;
    }
    function clearLastChar(){
    	var textfield = document.getElementById('login:password').value;
    	var size = textfield.length;
    	textfield = textfield.slice(0, size-1);
    	document.getElementById('login:password').value=textfield; 
    	////alert(textfield);
    	///alert(textfield.value.length());
    	///textfield = textfield.replace(/(\s+)?.$/, ''); 
    	return false;
    }
    function alterCaps(capslockbutton){
    	if(capson == false){
    		defaultButtonBgColor = capslockbutton.style.backgroundColor;
    		defaultButtonColor = capslockbutton.style.color;
    		
    		capslockbutton.style.backgroundColor = newSelectedButtonBgColor;
    		capslockbutton.style.color = newSelectedButtonColor;
    		capson = true; 
    	}else{
    		capslockbutton.style.backgroundColor = defaultButtonBgColor;
    		capslockbutton.style.color = defaultButtonColor;
    		capson = false; 
    	}
    }
    var check = true;
	var capArr = new Array(200);
    var capson = false;
    var defaultButtonColor = 'GRAY';
    var defaultButtonBgColor = 'GRAY'; 
    var newSelectedButtonColor = 'WHITE';
    var newSelectedButtonBgColor = 'RED';
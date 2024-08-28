function toggleSideBar() {
		// Initialize our object data from our XHTML divs.
		 	
        var bar = document.getElementById('sidebar');
        var barText = document.getElementById('sbText');
        var box = document.getElementById('content');
       
		// If the sidebar is expanded...
	        if (bar.style.width == '21%') {
	        	//alert('true');
	        	// Collapse it by setting its width to 15px
	            bar.style.width = '10px';
	            // Hide the sbText div so that its text isn't visible or
	            // repositioned.
	            barText.style.display = 'none';
	            // Resize the content div to its new, expanded width.
	            box.style.width = '98%';
	        // Otherwise, if the sidebar is already collapsed...
	        	
					
	        } else {
	       		//alert('Inside not width 21=====>');
	        	// Set the sidebar width back to 150.
	            bar.style.width = '21%';
	            // Make the sbText div visible again.
	            barText.style.display = 'block';
	            // Set the content div width back to 429.
	            box.style.width = '79%';
	      		
	        }
	       
      
    }
    
    function showPanelItems(toggleInt) {
		var bar = document.getElementById('sidebar');
        var barText = document.getElementById('sbText');
        var box = document.getElementById('content');
       // alert('hi'+toggleInt);
		if(toggleInt=='1'){
			if(bar!=null && barText!=null && box!=null){
				 bar.style.width = '10px';
		         barText.style.display = 'none';
		         box.style.width = '98%';
		    }
		}
		
		if(toggleInt==null){
			if(bar!=null && barText!=null && box!=null){
				 bar.style.width = '10px';
		         barText.style.display = 'none';
		         box.style.width = '98%';
		    }
		}
    }
   
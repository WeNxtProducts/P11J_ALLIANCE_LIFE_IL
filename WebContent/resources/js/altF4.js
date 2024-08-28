document.onkeydown=teclas;  
function teclas() {  
var tecla = window.event.keyCode;
var control = window.event.ctrlKey;
var alt = window.event.altKey;
var tipo=event.srcElement.type;

if (alt) {
      switch (tecla) {
            // Alt-F4
            case 115:
                  window.event.keyCode=86;  
                  window.cancelEvent=true;
                  event.cancelBubble=true;
                  event.returnValue=false;
                  event.cancel=true;
                  adios();
                  return false;  
                  break;
      }
}
}

function adios() {
             // I have to display this alert first
             // And open this window too or it wont work
	window.location.href="../../InvalidateSessionServlet" 
}

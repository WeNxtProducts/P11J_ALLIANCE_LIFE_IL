function CheckMyKeys(){
  var key = event.keyCode;
  if (key==122){ // F11 key, do something then cancel
    return cancel();
  }
  // Inline cancel function
  function cancel(){
   event.cancelBubble=true;
   event.keyCode=0;
   return false
  }
}
document.onkeydown = CheckMyKeys

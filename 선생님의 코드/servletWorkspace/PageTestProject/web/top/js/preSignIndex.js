$(document).ready(function(){
    function popup(){
        if(getCookie("dogcatCookie")!="no"){
            var child = null;

            child =
                $('#element_to_pop_up').bPopup({
                opacity: 0.6,
                positionStyle: 'fixed', //'fixed' or 'absolute'
                follow: [false, false], //x, y
                position: [120, 35] //x, y
            });

            child.focus();
        }
        return;
    }
    popup();
});


function getCookie(name){
    var nameOfCookie=name+"=";
    var x = 0;

    while( x<= document.cookie.length){
        var y = (x+nameOfCookie.length);

        if(document.cookie.substring(x,y)==nameOfCookie){
            if((endOfCookie==document.cookie.indexOf(";",y)) == -1)
                endOfCookie = document.cookie.length;
            return unescape(document.cookie.substring(y,endOfCookie));
        }

        x = document.cookie.indexOf(" ",x)+1;

        if(x==0)
            break;
    }
    return "";
}



function close_pop() {
    $('#element_to_pop_up').bPopup().close();
}

function todayClose() {
    setCookie( "dogcatCookie", "done" , 1 );
    close_pop();
}

function setCookie( name, value, expiredays){
   var todayDate = new Date();
    todayDate.setDate(todayDate.getDate()+expiredays);
    document.cookie = name + "=" + escape(value)+"; path=/; expires=" + todayDate.toGMTString() + ";";
}

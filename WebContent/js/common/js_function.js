var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;

// open hidden layer
function mopen(id)
{	
    // cancel close timer
    mcancelclosetime();

    // close old layer
    if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

    // get new layer and show it
    ddmenuitem = document.getElementById(id);
    ddmenuitem.style.visibility = 'visible';

}
// close showed layer
function mclose()
{
    if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}

// go close timer
function mclosetime()
{
    closetimer = window.setTimeout(mclose, timeout);
}

// cancel close timer
function mcancelclosetime()
{
    if(closetimer)
    {
        window.clearTimeout(closetimer);
        closetimer = null;
    }
}

// close layer when click-out
document.onclick = mclose

function getCalendarDate()
{
    var months = new Array(13);
    months[0]  = "January";
    months[1]  = "February";
    months[2]  = "March";
    months[3]  = "April";
    months[4]  = "May";
    months[5]  = "June";
    months[6]  = "July";
    months[7]  = "August";
    months[8]  = "September";
    months[9]  = "October";
    months[10] = "November";
    months[11] = "December";
    var now         = new Date();
    var monthnumber = now.getMonth();
    var monthname   = months[monthnumber];
    var monthday    = now.getDate();
    var year        = now.getYear();
    if(year < 2000) {
        year = year + 1900;
    }
    var dateString = monthname + ' ' + monthday + ', ' + year;
    return dateString;
} // function getCalendarDate()

function getClockTime()
{
    var now    = new Date();
    var hour   = now.getHours();
    var minute = now.getMinutes();
    var second = now.getSeconds();
    var ap = "AM";
    if (hour   > 11) {
        ap = "PM";
    }
    if (hour   > 12) {
        hour = hour - 12;
    }
    if (hour   == 0) {
        hour = 12;
    }
    if (hour   < 10) {
        hour   = "0" + hour;
    }
    if (minute < 10) {
        minute = "0" + minute;
    }
    if (second < 10) {
        second = "0" + second;
    }
    var timeString = hour +
    ':' +
    minute +
    ':' +
    second +
    " " +
    ap;
    return timeString;
}


//caesare06 Mikkalyn Payapag: caesare06 Mikkalyn Payapag: ccrisostomo_07 Mikkalyn Payapag: ccrisostomo_07 Mikkalyn Payapag: jbalote19 Mikkalyn Payapag: jbalote19 Mikkalyn Payapag: julius_070783 Mikkalyn Payapag: julius_070783 Mikkalyn Payapag: aisteru_maru Mikkalyn Payapag: aisteru_maru Mikkalyn Payapag: teragram825 Mikkalyn Payapag: teragram825 Mikkalyn Payapag: ricky_benitez_19 Mikkalyn Payapag: ricky_benitez_19 Mikkalyn Payapag: anna_sniper18 Mikkalyn Payapag: anna_sniper18 Mikkalyn Payapag: ernieball_26 Mikkalyn Payapag: ernieball_26 Mikkalyn Payapag: johnangeloaquino Mikkalyn Payapag: johnangeloaquino Mikkalyn Payapag: jonathan_yap@ymail.com Mikkalyn Payapag: jonathan_yap@ymail.com Mikkalyn Payapag: kimaikidommp Mikkalyn Payapag: kimaikidommp Mikkalyn Payapag: es 
//http://www.tizag.com/javascriptT/javascriptform.php
//http://codecanyon.net/item/jquery-msgbox/full_screen_preview/92626
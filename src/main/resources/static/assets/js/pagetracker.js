
function guid() {
    function _p8(s) {
        var p = (Math.random().toString(16)+"000000000").substr(2,8);
        return s ? "-" + p.substr(0,4) + "-" + p.substr(4,4) : p ;
    }
    return _p8() + _p8(true) + _p8(true) + _p8();
}

var id = localStorage.getItem("pgtid");

if (id == null) {
	id = guid();
	localStorage.setItem("pgtid", id);

	console.log("A pgtid was not found. Created a new one: " + id);
}

xhr = new(this.XMLHttpRequest || ActiveXObject)('MSXML2.XMLHTTP.3.0');
xhr.open('POST', '/pagetracker/hit?userId=' + id + "&url=" + encodeURI(document.location.pathname) + "&timestamp=" + Math.round(+new Date()/1000), true);
xhr.onreadystatechange = function() {};
xhr.send();

console.log("Hit sent to page-tracker.")

function n(n){
		return n > 9 ? "" + n: "0" + n;
	}
function planify(data) {
    for (var i = 0; i < data.columns.length; i++) {
        column = data.columns[i];
        column.searchRegex = column.search.regex;
        column.searchValue = column.search.value;
        delete(column.search);
    }
}

Date.prototype.format=function(){
	 year1=this.getFullYear();
	 month1=this.getMonth()+1; 
	 day1=this.getDate();
	 hour1=this.getHours();
	 min1=this.getMinutes();
	 sec1=this.getSeconds();
	//return n(day1)+"/"+n(month1)+"/"+year1+" - "+n(hour1)+":"+n(min1)+":"+n(sec1);
	 return n(day1)+"/"+n(month1)+"/"+year1;
};
Date.prototype.formatDetail=function(){
	 year1=this.getFullYear();
	 month1=this.getMonth()+1; 
	 day1=this.getDate();
	 hour1=this.getHours();
	 min1=this.getMinutes();
	 sec1=this.getSeconds();
	return n(day1)+"/"+n(month1)+"/"+year1+" "+n(hour1)+":"+n(min1)+":"+n(sec1);
};
$(document).ready(function() {
	function showpanel() {     
	    $(".alert-message").hide(1000);
	 }

	 // use setTimeout() to execute
	 setTimeout(showpanel, 3000);
	
});
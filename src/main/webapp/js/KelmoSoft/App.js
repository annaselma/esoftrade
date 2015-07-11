function setPrice(base,value){
	$.ajax({ // ajax call starts
	      url: base+'/product/find?id='+value, 
	      dataType: 'json', // Choosing a JSON datatype
	    })
	    .done(function(data) { // Variable data contains the data we get from serverside
	      if(data!=null){
	    	  console.log(data);
	    	  $("#price").val(data.price);
	      }
	    });
	
}

function CheckNumber(event){
	return event.charCode >= 48 && event.charCode <= 57;
}
function n(n){
		return n > 9 ? "" + n: "0" + n;
	}
function updateNotification(number){
    if(number>0){
      message="vous avez "+number+" notification(s)";
      $(".notifications-menu .label-warning").text(number);
      $(".notifications-menu .dropdown-menu .header").text(message);	
    }else{
    	message="vous n'avez aucune notification";
    	 $(".notifications-menu .dropdown-menu .header").text(message);
    }
	  
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
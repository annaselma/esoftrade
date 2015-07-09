<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!-- fullCalendar -->
<link href="${baseURL}/css/fullcalendar/fullcalendar.css"
	rel="stylesheet" type="text/css" />
	
<div class="row">
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-blue">
			<div class="inner">
				<h3>
					<c:out value="${OFBlocked}" />
				</h3>
				<p>OF en cours</p>
			</div>
			<div class="icon">
				<i class="ion ion-gear-b"></i>
			</div>
			<a href="#" class="small-box-footer"> <i class="fa fa-circle"></i>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-green">
			<div class="inner">
				<h3>
					<c:out value="${OFLate}" />
				</h3>
				<p>OF en retard</p>
			</div>
			<div class="icon">
				<i class="ion ion-alert-circled"></i>
			</div>
			<a href="#" class="small-box-footer"> <i class="fa fa-circle"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->

	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-red">
			<div class="inner">
				<h3>
					<c:out value="${OFWaiting}" />
				</h3>
				<p>OF en attente</p>
			</div>
			<div class="icon">
				<i class="ion ion-alert"></i>
			</div>
			<a href="#" class="small-box-footer"> <i class="fa fa-circle"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->

	<div class="col-lg-3 col-xs-6">
		<!-- small box -->
		<div class="small-box bg-teal">
			<div class="inner">
				<h3>
					<c:out value="${OFProcessing}" />
				</h3>
				<p>OF en cours</p>
			</div>
			<div class="icon">
				<i class="ion ion-ios7-alarm-outline"></i>
			</div>
			<a href="#" class="small-box-footer"> <i class="fa fa-circle"></i>
			</a>
		</div>
	</div>
	<!-- ./col -->
</div>
<!-- /.row -->

<div class="row">
<div class="col-lg-12">
	<div class="box box-info">
		<div class="box-header">
			Cout de fabriquation
		</div>
		<!-- /.box-header -->
		<div class="box-body ">

<div id="container2" style="height: 400px; min-width:100%; max-width:100%; margin: 0 auto"></div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>
</div>
<!-- Small boxes (Stat box) -->
<!-- Calendar -->
<div class="row">
<div class="col-lg-6">
	<div class="box box-warning">
		<div class="box-header">
			<i class="fa fa-calendar"></i>
			<div class="box-title">Planning de production</div>

			<!-- tools box -->
			<div class="pull-right box-tools"></div>
			<!-- /. tools -->
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<!--The calendar -->
			<div id="calendar"></div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>
<div class="col-lg-6">
	<div class="box box-success">
		<div class="box-header">
			<i class="fa fa-bar-chart-o"></i>
		
		</div>
		<!-- /.box-header -->
		<div class="box-body ">


<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>
</div>
<div class="row">
<div class="col-lg-6"><div class="box box-info">
		<div class="box-header">
			
		</div>
		<!-- /.box-header -->
		<div class="box-body ">
<div id="container3" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</div>
</div>
</div>
<div class="col-lg-6"><div class="box box-danger">
		<div class="box-header">
			
		</div>
		<!-- /.box-header -->
		<div class="box-body ">
<div id="container4" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</div>
</div>
</div>
</div>

			<script src="${baseURL}/js/plugins/Highcharts/Highcharts.js"></script>
<script src="${baseURL}/js/plugins/Highcharts/modules/data.js"></script>
<script src="${baseURL}/js/plugins/Highcharts/modules/drilldown.js"></script>
<script src="${baseURL}/js/plugins/Highcharts/Highcharts-more.js"></script>
<script src="${baseURL}/js/plugins/Highcharts/modules/exporting.js"></script>
<script type="text/javascript">
$(function () {
	
	function loadBubbleCharts ($data) {
    $('#container2').highcharts({

        chart: {
            type: 'bubble',
            zoomType: 'xy'
        },

        title: {
            text: 'Coût de fabrication'
        },

        series: [{
            data:$data
        }]
    });
	}
	$.ajax({
	    url: '${baseURL}/dashboard/bubble_data',
	    type: 'GET',
	    async: true,
	    dataType: "json",
	    success: function (data) {
	    	loadBubbleCharts(data);
	    }
	  });
});
</script>
<script type="text/javascript">
$(function () {
	function loadLineCharts($data) {
    $('#container').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: [{
            categories: $data[0],
            crosshair: true
        }],
        yAxis: [ { // Secondary yAxis
            title: {
                text: 'main ouvre par heure',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            labels: {
                format: '{value} DHs/h',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            opposite: true
        },
        { // Primary yAxis
            labels: {
                format: '{value} heures',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            title: {
                text: 'temps de travail',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            }
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 100,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        series: [{
            name: 'temps de travail',
            type: 'column',
            yAxis: 1,
            data: $data[1],
            tooltip: {
                valueSuffix: ' h'
            }

        }, {
            name: 'main oeuvre',
            type: 'spline',
            data: $data[2],
            tooltip: {
                valueSuffix: 'Dhs/heure '
            }
        }]
    });
	}
	$.ajax({
	    url: '${baseURL}/dashboard/line_data',
	    type: 'GET',
	    async: true,
	    dataType: "json",
	    success: function (data) {
	    	loadLineCharts(data);
	    }
	  });
});
</script>
<script type="text/javascript">   
                       /* initialize the calendar
                       -----------------------------------------------------------------*/
                      //Date for the calendar events (dummy data)
                      var date = new Date();
                      var d = date.getDate(),
                              m = date.getMonth(),
                              y = date.getFullYear();
                      function createCalendar($data){
                      $('#calendar').fullCalendar({
                          header: {
                              left: 'prev,next today',
                              center: 'title',
                              right: 'month,agendaWeek,agendaDay'
                          },
                          buttonText: {//This is to add icons to the visible buttons
                              prev: "<span class='fa fa-caret-left'></span>",
                              next: "<span class='fa fa-caret-right'></span>",
                              today: 'aujourdhui',
                              month: 'mois',
                              week: 'semaine',
                              day: 'jour'
                          },
                      //Random default events
                      events: $data,
                      editable: false,
                      droppable: false, // this allows things to be dropped onto the calendar !!!
                      
                  });
                      }//ici 
                      $.ajax({
                  	    url: '${baseURL}/dashboard/calendar_events',
                  	    type: 'GET',
                  	    async: true,
                  	    dataType: "json",
                  	    success: function (data) {
                  	    	createCalendar(data);
                  	    	console.log(data);
                  	    }
                  	  });
                      $("#add-new-event").click(function(e) {
                          e.preventDefault();
                          //Get value and make sure it is not null
                          var val = $("#new-event").val();
                          if (val.length == 0) {
                              return;
                          }

                          //Create event
                          var event = $("<div />");
                          event.css({"background-color": currColor, "border-color": currColor, "color": "#fff"}).addClass("external-event");
                          event.html(val);
                          $('#external-events').prepend(event);

                          //Add draggable funtionality
                          ini_events(event);

                          //Remove event from text input
                          $("#new-event").val("");
                      });
</script>

<!-- testPie -->

<!-- testEnd -->
<script type="text/javascript">
$(function () {
function  loadPieCharts($data){
    $('#container3').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: ''
        },
        tooltip: {
            pointFormat: ''
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: "Brands",
            colorByPoint: true,
            data: [{
                name: "ordre bloqué",
                y: $data.terminate[1]
            }, {
                name: "ordres terminé",
                y: $data.process[0]
            },
            {
                name: "ordres annulés",
                y: $data.process[2]
            }
            ]
        }]
    });
    $('#container4').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: ''
        },
        tooltip: {
            pointFormat: ''
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
        	name: "Brands",
            colorByPoint: true,
            data:[{
            name: "ordre en retard",
            y: $data.process[1]
        }, {
            name: "en attente",
            y: $data.process[2]
       
        },{
            name: "orde en cours",
            y: $data.process[0]
        }]
        }]
    });
}
$.ajax({
    url: '${baseURL}/dashboard/pie_data',
    type: 'GET',
    async: true,
    dataType: "json",
    success: function (data) {
    	loadPieCharts(data);
    }
  });
});
</script>



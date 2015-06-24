<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
                    <div class="row">
                    <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-blue">
                                <div class="inner">
                                    <h3>
                                        <c:out value="${OFBlocked}"/>
                                    </h3>
                                    <p>
                                        OF en cours
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-gear-b"></i>
                                </div>
                                <a href="#" class="small-box-footer">
                                     <i class="fa fa-circle"></i>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3>
                                        <c:out value="${OFLate}"/>
                                    </h3>
                                    <p>
                                        OF En retard
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-alert-circled"></i>
                                </div>
                                <a href="#" class="small-box-footer">
                                    <i class="fa fa-circle"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                        
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">
                                    <h3>
                                       <c:out value="${OFProcessing}"/>
                                    </h3>
                                    <p>
                                        OF en cours
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-alert"></i>
                                </div>
                                <a href="#" class="small-box-footer">
                                    <i class="fa fa-circle"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                         
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-teal">
                                <div class="inner">
                                    <h3>
                                        <c:out value="${OFWaiting}"/>
                                    </h3>
                                    <p>OF en attente
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-ios7-alarm-outline"></i>
                                </div>
                                <a href="#" class="small-box-footer">
                                   <i class="fa fa-circle"></i>
                                </a>
                            </div>
                        </div><!-- ./col -->
                    </div><!-- /.row -->
                    <!-- Small boxes (Stat box) -->
                    <!-- Calendar -->
                            <div class="box box-warning">
                                <div class="box-header">
                                    <i class="fa fa-calendar"></i>
                                    <div class="box-title">Calendar</div>
                                    
                                    <!-- tools box -->
                                    <div class="pull-right box-tools">
                                        <!-- button with a dropdown -->
                                        <div class="btn-group">
                                            <button class="btn btn-warning btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
                                            <ul class="dropdown-menu pull-right" role="menu">
                                                <li><a href="#">Add new event</a></li>
                                                <li><a href="#">Clear events</a></li>
                                                <li class="divider"></li>
                                                <li><a href="#">View calendar</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- /. tools -->                                    
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <!--The calendar -->
                                    <div id="calendar"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                            
                       <script >   
                            $('#my-tabs').tabs({
    activate: function(event, ui) {
        $('#calendar').fullCalendar('render');
    }
});
</script>
                   

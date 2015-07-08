<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<header class="header">
	<a href="#" class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
<%--   <img src="${baseURL}/img/testG.png" class="img-circle" alt="Image" style="width: 112px; height: 51px;margin-right: 17%;"> --%>
	KelmoSoft
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>
		<div class="navbar-right">
			<ul class="nav navbar-nav">
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-warning"></i> <span class="label label-warning"></span>
				</a>
					<ul class="dropdown-menu">
						<li class="header"></li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="ion ion-ios7-people info"></i>
										5 ordres de fabrication créés
								</a></li>
								<li><a href="#"> <i class="fa fa-warning danger"></i>
										3 Ordres de fabrication bloqués
								</a></li>
								<li><a href="#"> <i class="fa fa-users warning"></i> 5
										commandes de lancement d'ordre de fabrication
								</a></li>

								<li><a href="#"> <i class="ion ion-ios7-cart success"></i>
										25 sales made
								</a></li>
								<li><a href="#"> <i class="ion ion-ios7-person danger"></i>
										You changed your username
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">voir tout</a></li>
					</ul></li>
				<!-- Tasks: style can be found in dropdown.less -->
				<li class="dropdown tasks-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-tasks"></i> <span class="label label-danger"></span>
				</a>
					<ul class="dropdown-menu">
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
							</ul>
						</li>
						<li class="footer"><a href="${baseURL}/manufacturing/list">voir tous les of</a></li>
					</ul></li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-user"></i> <span class="full-name"> 
							<i class="caret"></i>
					</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header bg-light-blue"><img
							src="" class="img-circle" alt="User Image" />
							<p class="full-name">
								 <small class="date-creation">membre depuis </small>
							</p></li>
						<!-- Menu Body -->
						
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="" class="profile btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<c:url value="/j_spring_security_logout" var="logoutUrl" />

								<!-- csrt for log out-->
								<form action="${logoutUrl}" method="post" id="logoutForm">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
								<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
								<a href="javascript:formSubmit()"> <i
									class="btn btn-default btn-flat">Deconnecter</i>
								</a>

							</div>
						</li>
					</ul></li>
			</ul>
					<script type="text/javascript">
			$(document).ready(function(){
				    $.ajax({ // ajax call starts
				      url: '${baseURL}/manufacturing/task', 
				      dataType: 'json', // Choosing a JSON datatype
				    })
				    .done(function(data) { // Variable data contains the data we get from serverside
				    	console.log(data);
				      if(data!=null){
				    	  data.forEach(function(of){
				    		  res=of.id%4;
				    		  color="aqua";
				    		  switch(res){
				    		  case 1:
				    			  color="red";
				    			  break;
				    		  case 2:
				    			  color="yllow";
				    			  break;
				    		  case 3:
				    			  color="green";
				    			  break;
				    		  default:
				    			  color="aqua";
				    			  break;
				    		  }
				    	  $not="<li>"+
								"<a href='${baseURL}/manufacturing/profile?id="+of.id+"'>"+
								"<h3>"+
								of.title+"<small class='pull-right'>"+of.progress+"%</small>"+
								"</h3>"+
								"<div class='progress xs'>"+
									"<div class='progress-bar progress-bar-"+color+"'"+
										"style='width: "+of.progress+"%' role='progressbar' aria-valuenow='20'"+
										"aria-valuemin='0' aria-valuemax='100'>"+
										"<span class='sr-only'>"+of.progress+"% Complete</span>"+
									"</div>"+
								"</div>"+
						"</a>"+
						"</li>";
					   
				    	  $(".tasks-menu .dropdown-menu .menu").append($not);
					      });
				    	  }

				    });
				
				});</script>
			<script type="text/javascript">
		    var $countNot=0;
			$(document).ready(function(){
				    $.ajax({ // ajax call starts
				      url: '${baseURL}/product/notification', 
				      dataType: 'json', // Choosing a JSON datatype
				    })
				    .done(function(data) { // Variable data contains the data we get from serverside
				    	console.log(data);
				      if(data!=null){
				    	  $currentUser=data;
				    	  message="";
				    	  if(data==1){
				    		  message="un produit a atteint le sueil d'alert ";
				    		  
				    	  }
				    	  else if(data==0){
				    		  return;
				    	  }
				    	  else{
				    		  message= data +  "produits ont atteint le sueil d'alert";
				    	  }
				    	  $countNot+=1;
				    	  $not="<li><a href='${baseUrl}/product/listAlert'> <i class='ion ion-ios7-cart info'></i>"+
								   message+"</a></li>";
								   updateNotification($countNot);
					   
				    	  $(".notifications-menu .dropdown-menu .menu").prepend($not);
				      }
				    });
				
				});</script>
				<script type="text/javascript">
				var $currentUser;
			$(document).ready(function(){
				    $.ajax({ // ajax call starts
				      url: '${baseURL}/user/getCurrentUser', 
				      dataType: 'json', // Choosing a JSON datatype
				    })
				    .done(function(data) { // Variable data contains the data we get from serverside
				    	console.log(data);
				      if(data!=null){
				    	  $currentUser=data;
				    	  $(".user-menu .full-name").append(data.lastName +" "+data.name);
				    	  $picture="${baseURL}/file?id="+data.picture.id;
				    	  $profil="${baseURL}/user/profile?id="+data.id;
				    	  $date=new Date(data.createDate);
				    	  $(".user-menu .date-creation").append($date.format());
				    	  $(".user-menu img").prop("src",$picture);
				    	  $(".user-footer .profile").prop("href",$profil);
				      }
				    });
				});
			</script>
		</div>
	</nav>
</header>
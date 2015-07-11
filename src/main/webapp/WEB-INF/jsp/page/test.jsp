<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<link rel="stylesheet" href="${baseURL}/css/bootstrap.vertical-tabs.css">
<link rel="stylesheet" href="${baseURL}/css/bootstrap.vertical-tabs.min.css">
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
	
}
</style>
                 
                    <div class="col-xs-2"> <!-- required for floating -->
    <!-- Nav tabs -->
    <ul class="nav nav-tabs tabs-left">
      <li class="active"><a href="#Langue" data-toggle="tab">1.Langue</a></li>
      <li><a href="#profile" data-toggle="tab">2.Base de données</a></li>
      <li><a href="#config" data-toggle="tab">3.Configuration</a></li>
      <li><a href="#settings" data-toggle="tab">4.Settings</a></li>
       <li><a href="#finish" data-toggle="tab">5.Fin</a></li>
    </ul>
</div>

<div class="col-xs-9">
    <!-- Tab panes -->
    <div class="tab-content">
		<div class="tab-pane active" id="langue">
			<div class="row">
			<div class="" style=" padding-left: 7%; padding-top: 9%;">
				<label for="language" class="col-sm-5 control-label" >Veillez selectionner la langue à utiliser  au cours de l'installation de KelmoSoft</label>
				 <div class="col-md-4">
				 <select
					name="language" id="language_dropdown" class="form-control">
					<option value="french">Français</option>
					<option value="english">Anglais</option>
					<option value="english">arabe</option>
					<option value="english">Allemand</option>
					<option value="english">japonais</option>
					<option value="english">russe</option>
				</select></div>
				</div>
                        <button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-right: 15%; margin-top: 16%;">
									<i class="fa fa-chevron-right"></i> &nbsp;Suivant
								</button>
			</div>
		</div>
		<div class="tab-pane" id="profile"><div class="row">
			<form >
				<div class="input-group">
				<label for="language" class="col-sm-6 control-label esoft-left" >Nom de la base de données</label>
				 <div class="col-md-6">
				 <input type="text" class="form-control"/>
				 </div>
				 </div>
				 
				 <div class="input-group">
				<label for="serveur" class="col-sm-6 control-label esoft-left" >Serveur</label>
				 <div class="col-md-4">
				 <input type="text" class="form-control" style="margin-left: 96%;"/>
				 </div>
				 </div>
				 
				 <div class="input-group" style=" margin-top: 2%; ">
				<label for="porter" class="col-sm-6 control-label esoft-left" >Port</label>
				 <div class="col-md-5">
				 <input type="text" class="form-control" placeholder="80" style="margin-left: 96%;"/>
				 </div>
				 </div>
				 <div class="input-group" style=" margin-top: 2%; ">
				<label for="porter" class="col-sm-6 control-label esoft-left" >Préfixe Database</label>
				 <div class="col-md-6">
				 <input type="text" class="form-control"  placeholder="Kelmo_" style="margin-left: 31%;"/>
				 </div>
				 </div>
					<div class="checkbox" style="margin-left: 2%;">
						<label> <input type="checkbox"> Cochez cette option pour créer une base de données
						</label>
					</div>

					<button type="button" class="btn-sm btn btn-primary pull-right "
									style="margin-right: 15%; margin-top: 16%;">
									<i class="fa fa-chevron-right"></i> &nbsp;Suivant
								</button>
								<button type="button" class="btn-sm btn btn-warning pull-right "
									style="margin-right: 2%; margin-top: 16%;">
									<i class="fa fa-mail-reply t"></i> &nbsp;précedent
								</button>
				</form>

			</div></div>
      <div class="tab-pane" id="config"><form >
				<div class="input-group">
				<label for="tato" class="col-sm-6 control-label esoft-left" >Nom de l'application</label>
				 <div class="col-md-6">
				 <input type="text" class="form-control"/>
				 </div>
				 </div>
				 
				 <div class="input-group" style=" margin-top: 2%;">
				<label for="serveur" class="col-sm-6 control-label esoft-left" >Nom Utilisateur</label>
				 <div class="col-md-6">
				 <input type="text" class="form-control" style="margin-left: 30%;"/>
				 </div>
				 </div>
				 
				 <div class="input-group" style=" margin-top: 2%; ">
				<label for="porter" class="col-sm-6 control-label esoft-left" >Mot de passe</label>
				 <div class="col-md-6">
				 <input type="password" class="form-control" style="margin-left: 30%;"/>
				 </div>
				 </div>
		
<hr>

<div class="form-group">
                                            <label for="exampleInputFile">Chemin</label>
                                            <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="C:/"></div>
                                            <p class="help-block">Selectionner la destination de vos fichiers joint </p>
                                        </div>
					<button type="button" class="btn-sm btn btn-danger pull-right "
									style="margin-right: 15%; margin-top: 16%;">
									<i class="fa fa-chevron-right"></i> &nbsp;Valider
								</button>
								<button type="button" class="btn-sm btn btn-warning pull-right "
									style="margin-right: 2%; margin-top: 16%;">
									<i class="fa fa-mail-reply t"></i> &nbsp;précèdent
								</button>
				</form></div>
      <div class="tab-pane" id="settings">Settings Tab.</div>
       <div class="tab-pane" id="finish"><div class="callout callout-danger">
                                        <h4>Félicitation KelmoSoft est installé!</h4>
                                        <p>Veuillez patienter quelques instants vous serez redirigé automatiquement...</p>
                                    </div></div>
       
    </div>
</div>  
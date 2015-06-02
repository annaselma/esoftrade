<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
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
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Identité Personnelle</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="user" id="userF"
			data-toggle="validator" cssClass="form-horizontal">
			<div class="form-group form-horizontal">
			<div class="form-group" >&nbsp;<span class="error" style="margin-left: 74%;">Veuillez saisir les champs obligatoire(*)</span></div>
				<label for="lastnameField" class="col-sm-2 control-label esoft-left">Prenom:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="lastName" cssClass="form-control" />
					<form:errors path="lastName" cssClass="error" />
					
				</div>
				<label for="activ" class="col-sm-2 control-label esoft-left">compte
					activé:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:checkbox path="active" />
					<form:errors path="active" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Nom:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" />
				</div>
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date Naissance:&nbsp;<span class="error">*</span></label>

				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="birdDay" id="dp3" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="birdDay" />
				</div>
			</div>
			<hr>
			<div class="form-group">
				<label for="emailField" class="col-sm-2 control-label esoft-left">Email:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="email" cssClass="form-control"
						placeholder="exemple@hotmail.com" />
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="phoneField" class="col-sm-2 control-label esoft-left">Telephone:</label>
				<div class="col-sm-4">
					<form:input path="telephone" cssClass=" form-control" />
					<form:errors path="telephone" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="fonctionField" class="col-sm-2 control-label esoft-left">Fonction:</label>
				<div class="col-sm-4">
					<form:input path="fonction" cssClass="form-control" />
					<form:errors path="fonction" cssClass="error" />
				</div>

			</div>
            <hr>
			<div class="form-group">
				<label for="adresseField" class="col-sm-2 control-label esoft-left">Adresse:</label>
				<div class="col-sm-4">
					<form:textarea path="adresse1" rows="3" cols="50" />
					<form:errors path="adresse1" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="CPField" class="col-sm-2 control-label esoft-left">code
					Postal:</label>
				<div class="col-sm-4">
					<form:input path="zipCode" cssClass="form-control"/>
					<form:errors path="zipCode" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="cityField" class="col-sm-2 control-label esoft-left">Ville:</label>
				<div class="col-sm-4">
					<form:input path="city" cssClass="form-control" />
					<form:errors path="city" cssClass="error" />
				</div>

			</div>

			<div class="form-group">

				<label for="paysField" class="col-sm-2 control-label esoft-left">Pays:
				</label>
				<div class="col-md-4">
					<form:select path="country" cssClass="form-control  bfh-countries">

						<option value="0"></option>
						<option value="Afghanistan (AF)">Afghanistan (AF)</option>
						<option value="Afrique du Sud (ZA)">Afrique du Sud (ZA)</option>
						<option value="Albanie (AL">Albanie (AL)</option>
						<option value="Algérie (DZ)">Algérie (DZ)</option>
						<option value="Allemagne (DE)">Allemagne (DE)</option>
						<option value="Andorre (AD)">Andorre (AD)</option>
						<option value="Angola (AO)">Angola (AO)</option>
						<option value="Anguilla (AI)">Anguilla (AI)</option>
						<option value="Antarctique (AQ)">Antarctique (AQ)</option>
						<option value="Antigua-et-Barbuda (AG)">Antigua-et-Barbuda
							(AG)</option>
						<option value="Antilles néerlandaises (AN)">Antilles
							néerlandaises (AN)</option>
						<option value="Arabie Saoudite (SA)">Arabie Saoudite (SA)</option>
						<option value="Argentine (AR)">Argentine (AR)</option>
						<option value="Arménie (AM)">Arménie (AM)</option>
						<option value="Aruba (AW)">Aruba (AW)</option>
						<option value="Australie (AU)">Australie (AU)</option>
						<option value="Autriche (AT)">Autriche (AT)</option>
						<option value="Azerbaïdjan (AZ)">Azerbaïdjan (AZ)</option>
						<option value="Bahamas (BS)">Bahamas (BS)</option>
						<option value="Bahreïn (BH)">Bahreïn (BH)</option>
						<option value="Bangladesh (BD)">Bangladesh (BD)</option>
						<option value="Barbade (BB)">Barbade (BB)</option>
						<option value="Belgique (BE)">Belgique (BE)</option>
						<option value="Belize (BZ)">Belize (BZ)</option>
						<option value="Bénin (BJ)">Bénin (BJ)</option>
						<option value="Bermudes (BM)">Bermudes (BM)</option>
						<option value="Bhoutan (BT)">Bhoutan (BT)</option>
						<option value="Biélorussie (BY)">Biélorussie (BY)</option>
						<option value="Birmanie (Myanmar) (MM)">Birmanie
							(Myanmar) (MM)</option>
						<option value="Bolivie (BO)">Bolivie (BO)</option>
						<option value="Bosnie-Herzégovine (BA">Bosnie-Herzégovine
							(BA)</option>
						<option value="Botswana (BW)">Botswana (BW)</option>
						<option value="Brésil (BR)">Brésil (BR)</option>
						<option value="Brunei (BN)">Brunei (BN)</option>
						<option value="Bulgarie (BG)">Bulgarie (BG)</option>
						<option value="Burkina Faso (BF)">Burkina Faso (BF)</option>
						<option value="Burundi (BI)">Burundi (BI)</option>
						<option value="Cambodge (KH)">Cambodge (KH)</option>
						<option value="Cameroun (CM)">Cameroun (CM)</option>
						<option value="Canada (CA)">Canada (CA)</option>
						<option value="Cap-Vert (CV)">Cap-Vert (CV)</option>
						<option value="Chili (CL)">Chili (CL)</option>
						<option value="Chine (CN)">Chine (CN)</option>
						<option value="Chypre (CY)">Chypre (CY)</option>
						<option value="Colombie (CO)">Colombie (CO)</option>
						<option value="Comores (KM)">Comores (KM)</option>
						<option value="Congo (CG)">Congo (CG)</option>
						<option value="Corée du Nord (KP)">Corée du Nord (KP)</option>
						<option value="Corée du Sud (KR)">Corée du Sud (KR)</option>
						<option value="Costa Rica (CR)">Costa Rica (CR)</option>
						<option value="Côte d'Ivoire (CI)">Côte d'Ivoire (CI)</option>
						<option value="Croatie (HR)">Croatie (HR)</option>
						<option value="Cuba (CU)">Cuba (CU)</option>
						<option value="Danemark (DK)">Danemark (DK)</option>
						<option value="Djibouti (DJ)">Djibouti (DJ)</option>
						<option value="Dominique (DM)">Dominique (DM)</option>
						<option value="Egypte (EG)">Egypte (EG)</option>
						<option value="Émirats arabes unishh">Émirats arabes
							unishh (xx)</option>
						<option value="Equateur (EC)">Equateur (EC)</option>
						<option value="Erythrée (ER)">Erythrée (ER)</option>
						<option value="Espagne (ES)">Espagne (ES)</option>
						<option value="Estonie (EE)">Estonie (EE)</option>
						<option value="Etats-Unis (US)">Etats-Unis (US)</option>
						<option value="Ethiopie (ET)">Ethiopie (ET)</option>
						<option value="Finlande (FI)">Finlande (FI)</option>
						<option value="France (FR)" selected="selected">France
							(FR)</option>
						<option value="Gabon (GA)">Gabon (GA)</option>
						<option value="Gambie (GM)">Gambie (GM)</option>
						<option value="Géorgie (GE)">Géorgie (GE)</option>
						<option value="Ghana (GH)">Ghana (GH)</option>
						<option value="Gibraltar (GI)">Gibraltar (GI)</option>
						<option value="Grande-Bretagne (GB)">Grande-Bretagne (GB)</option>
						<option value="Grèce (GR)">Grèce (GR)</option>
						<option value="Grenade (GD)">Grenade (GD)</option>
						<option value="Groenland (GL)">Groenland (GL)</option>
						<option value="Guam (GU)">Guam (GU)</option>
						<option value="Guatemala (GT)">Guatemala (GT)</option>
						<option value="Guernesey (GG)">Guernesey (GG)</option>
						<option value="Guinée (GN)">Guinée (GN)</option>
						<option value="Guinée Equatoriale (GQ)">Guinée
							Equatoriale (GQ)</option>
						<option value="Guinée-Bissao (GW)">Guinée-Bissao (GW)</option>
						<option value="Guyane française (GF)">Guyane française
							(GF)</option>
						<option value="Haïti (HT)">Haïti (HT)</option>
						<option value="Honduras (HN)">Honduras (HN)</option>
						<option value="Hong Kong (HK)">Hong Kong (HK)</option>
						<option value="Hongrie (HU)">Hongrie (HU)</option>
						<option value="Ile Bouvet (BV)">Ile Bouvet (BV)</option>
						<option value="Ile Christmas (CX)">Ile Christmas (CX)</option>
						<option value="Ile Norfolk (NF)">Ile Norfolk (NF)</option>
						<option value="Ile de Man (IM)">Ile de Man (IM)</option>
						<option value="Iles Aland (AX)">Iles Aland (AX)</option>
						<option value="Iles Cayman (KY)">Iles Cayman (KY)</option>
						<option value="Iles Cook (CK)">Iles Cook (CK)</option>
						<option value="Iles Falkland (FK)">Iles Falkland (FK)</option>
						<option value="Iles Féroé (FO)">Iles Féroé (FO)</option>
						<option value="Iles Fidji (FJ)">Iles Fidji (FJ)</option>
						<option value="Iles Géorgie du Sud et Sandwich du
							Sud (GS)">Iles
							Géorgie du Sud et Sandwich du Sud (GS)</option>
						<option value="Inde (IN)">Inde (IN)</option>
						<option value="Indonésie (ID)">Indonésie (ID)</option>
						<option value="Iran (IR)">Iran (IR)</option>
						<option value="Iraq (IQ)">Iraq (IQ)</option>
						<option value="Irlande (IE)">Irlande (IE)</option>
						<option value="Islande (IS)">Islande (IS)</option>
						<option value="Israël (IL)">Israël (IL)</option>
						<option value="Italie (IT)">Italie (IT)</option>
						<option value="Jamaïque (JM)">Jamaïque (JM)</option>
						<option value="Japon (JP)">Japon (JP)</option>
						<option value="Jersey (JE)">Jersey (JE)</option>
						<option value="Jordanie (JO)">Jordanie (JO)</option>
						<option value="Kazakhstan (KZ)">Kazakhstan (KZ)</option>
						<option value="Kenya (KE)">Kenya (KE)</option>
						<option value="Kirghizistan (KG)">Kirghizistan (KG)</option>
						<option value="Kiribati (KI">Kiribati (KI)</option>
						<option value="Koweït (KW)">Koweït (KW)</option>
						<option value="Laos (LA)">Laos (LA)</option>
						<option value="Lesotho (LS)">Lesotho (LS)</option>
						<option value="Lettonie (LV)">Lettonie (LV)</option>
						<option value="Liban (LB)">Liban (LB)</option>
						<option value="Liberia (LR)">Liberia (LR)</option>
						<option value="Libye (LY)">Libye (LY)</option>
						<option value="Liechtenstein (LI)">Liechtenstein (LI)</option>
						<option value="Lituanie (LT">Lituanie (LT)</option>
						<option value="Luxembourg (LU)">Luxembourg (LU)</option>
						<option value="Macao (MO)">Macao (MO)</option>
						<option value="Macédoine (Ex-République yougoslave)
							(MK)">Macédoine
							(Ex-République yougoslave) (MK)</option>
						<option value="Madagascar (MG)">Madagascar (MG)</option>
						<option value="Malaisie (MY)">Malaisie (MY)</option>
						<option value="Malawi (MW)">Malawi (MW)</option>
						<option value="Maldives (MV)">Maldives (MV)</option>
						<option value=">Mali (ML)">Mali (ML)</option>
						<option value="Malte (MT)">Malte (MT)</option>
						<option value="Mariannes du Nord (MP)">Mariannes du Nord
							(MP)</option>
						<option value="Maroc (MA)">Maroc (MA)</option>
						<option value="Maurice (MU)">Maurice (MU)</option>
						<option value="Mauritanie (MR)">Mauritanie (MR)</option>
						<option value="Mayotte (YT)">Mayotte (YT)</option>
						<option value="Mexique (MX)">Mexique (MX)</option>
						<option value="Micronésie (FM)">Micronésie (FM)</option>
						<option value="Moldavie (MD)">Moldavie (MD)</option>
						<option value="Monaco (MC)">Monaco (MC)</option>
						<option value="Mongolie (MN">Mongolie (MN)</option>
						<option value="Monserrat (MS)">Monserrat (MS)</option>
						<option value="Monténégro (ME)">Monténégro (ME)</option>
						<option value="Mozambique (MZ)">Mozambique (MZ)</option>
						<option value="Namibie (NA)">Namibie (NA)</option>
						<option value="auru (NR)">Nauru (NR)</option>
						<option value="Népal (NP)">Népal (NP)</option>
						<option value="Nicaragua (NI)">Nicaragua (NI)</option>
						<option value="Niger (NE)">Niger (NE)</option>
						<option value="Nigeria (NG)">Nigeria (NG)</option>
						<option value="Nioué (NU)">Nioué (NU)</option>
						<option value="Norvège (NO)">Norvège (NO)</option>
						<option value="Nouvelle-Calédonie (NC)">Nouvelle-Calédonie
							(NC)</option>
						<option value="Nouvelle-Zélande (NZ)">Nouvelle-Zélande
							(NZ)</option>
						<option value="Oman (OM)">Oman (OM)</option>
						<option value="Ouganda (UG)">Ouganda (UG)</option>
						<option value="Ouzbékistan (UZ)">Ouzbékistan (UZ)</option>
						<option value="Pakistan (PK)">Pakistan (PK)</option>
						<option value="Palaos (PW)">Palaos (PW)</option>
						<option value="Panama (PA)">Panama (PA)</option>
						<option value="Papouasie-Nouvelle-Guinée (PG)">Papouasie-Nouvelle-Guinée
							(PG)</option>
						<option value="Paraguay (PY)">Paraguay (PY)</option>
						<option value="Pays-Bas (NL)">Pays-Bas (NL)</option>
						<option value="Pérou (PE)">Pérou (PE)</option>
						<option value="Philippines (PH)">Philippines (PH)</option>
						<option value="Pologne (PL)">Pologne (PL)</option>
						<option value="Polynésie française (PF)">Polynésie
							française (PF)</option>
						<option value="Porto Rico (PR)">Porto Rico (PR)</option>
						<option value="Portugal (PT)">Portugal (PT)</option>
						<option value="Qatar (QA)">Qatar (QA)</option>
						<option value="République Dominicaine (DO)">République
							Dominicaine (DO)</option>
						<option value="République Tchèque (CZ)">République
							Tchèque (CZ)</option>
						<option value="République centrafricaine (CF)">République
							centrafricaine (CF)</option>
						<option value="République démocratique du Congo (CD)">République
							démocratique du Congo (CD)</option>
						<option value="Roumanie (RO)">Roumanie (RO)</option>
						<option value="Russie (RU)">Russie (RU)</option>
						<option value="Rwanda (RW)">Rwanda (RW)</option>
						<option value="Sahara Occidental (EH)">Sahara Occidental
							(EH)</option>
						<option value="Saint-Barthélemy (BL)">Saint-Barthélemy
							(BL)</option>
						<option value="Saint-Christophe-et-Niévès (KN)">Saint-Christophe-et-Niévès
							(KN)</option>
						<option value="Saint-Marin (SM)">Saint-Marin (SM)</option>
						<option value="Saint-Martin (MF)">Saint-Martin (MF)</option>
						<option value="Saint-Pierre-et-Miquelon (PM)">Saint-Pierre-et-Miquelon
							(PM)</option>
						<option value="Saint-Siège (Vatican) (VA)">Saint-Siège
							(Vatican) (VA)</option>
						<option value="Saint-Vincent-et-les-Grenadines (VC)">Saint-Vincent-et-les-Grenadines
							(VC)</option>
						<option value="Sainte-Hélène (SH)">Sainte-Hélène (SH)</option>
						<option value="Sainte-Lucie (LC)">Sainte-Lucie (LC)</option>
						<option value="Salvador (SV)">Salvador (SV)</option>
						<option value="Samoa (WS)">Samoa (WS)</option>
						<option value="Samoa américaines (AS)">Samoa américaines
							(AS)</option>
						<option value="Sao Tomé-et-Principe (ST)">Sao
							Tomé-et-Principe (ST)</option>
						<option value="Sénégal (SN)">Sénégal (SN)</option>
						<option value="Serbie (RS)">Serbie (RS)</option>
						<option value="Seychelles (SC)">Seychelles (SC)</option>
						<option value="Sierra Leone (SL)">Sierra Leone (SL)</option>
						<option value="Singapoure (SG)">Singapoure (SG)</option>
						<option value="Slovaquie (SK)">Slovaquie (SK)</option>
						<option value="Slovénie (SI)">Slovénie (SI)</option>
						<option value="Somalie (SO)">Somalie (SO)</option>
						<option value="Soudan (SD)">Soudan (SD)</option>
						<option value="Sri Lanka (LK)">Sri Lanka (LK)</option>
						<option value="Suède (SE)">Suède (SE)</option>
						<option value="Suisse (CH)">Suisse (CH)</option>
						<option value="Suriname (SR)">Suriname (SR)</option>
						<option value="Swaziland (SZ)">Swaziland (SZ)</option>
						<option value="Syrie (SY)">Syrie (SY)</option>
						<option value="Tadjikistan (TJ)">Tadjikistan (TJ)</option>
						<option value="Taïwan (TW)">Taïwan (TW)</option>
						<option value="Tanzanie (TZ)">Tanzanie (TZ)</option>
						<option value="Tchad (TD)">Tchad (TD)</option>
						<option value="Terres australes françaises (TF)">Terres
							australes françaises (TF)</option>
						<option value=" Palestinne">Territoire Palestinne</option>
						<option
							value="Territoire britannique de l'Océan
							Indien (IO)">Territoire
							britannique de l'Océan Indien (IO)</option>
						<option value="Thaïlande (TH)">Thaïlande (TH)</option>
						<option value="217">Timor Oriental (TL)</option>
						<option value="Togo (TG)">Togo (TG)</option>
						<option value="Tokélaou (TK)">Tokélaou (TK)</option>
						<option value="Tonga (TO)">Tonga (TO)</option>
						<option value="Trinité-et-Tobago (TT)">Trinité-et-Tobago
							(TT)</option>
						<option value="Tunisie (TN)">Tunisie (TN)</option>
						<option value="Turkménistan (TM)">Turkménistan (TM)</option>
						<option value="Turquie (TR)">Turquie (TR)</option>
						<option value="Tuvalu (TV)">Tuvalu (TV)</option>
						<option value="Ukraine (UA)">Ukraine (UA)</option>
						<option value="Uruguay (UY)">Uruguay (UY)</option>
						<option value="Vanuatu (VU)">Vanuatu (VU)</option>
						<option value="Vénézuela (VE)">Vénézuela (VE)</option>
						<option value="Viêt Nam (VN)">Viêt Nam (VN)</option>
						<option value="Wallis-et-Futuna (WF)">Wallis-et-Futuna
							(WF)</option>
						<option value="Yémen (YE)">Yémen (YE)</option>
						<option value="Zambie (ZM)">Zambie (ZM)</option>
						<option value="Zimbabwe (ZW)">Zimbabwe (ZW)</option>
					</form:select>
					<form:errors path="country" cssClass="error" />
				</div>

			</div>
			<hr class="bs-docs-separator ">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label esoft-left">Login:&nbsp;<span class="error">*</span></label>
				<div class="col-sm-4">
					<form:input path="login" cssClass="form-control" />
					<form:errors path="login" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordField" class="col-sm-2 control-label esoft-left"><small>Mot
						de Passe:&nbsp;<span class="error">*</span></small></label>
				<div class="col-sm-4">
					<form:input path="password" type="password"
						cssClass="form-control input-lg" />
					<form:errors path="password" cssClass="error" />
				</div>

			</div>


			<div class="form-group">
			<button type="reset" class="btn-sm btn btn-danger btn pull-right " onclick="location.href='${baseURL}/user/list'" style="margin-right: 2%;">Annuler</button>
			<button type="submit" class="btn-sm btn btn-primary btn pull-right" style="margin-right: 1%;"><i class="fa fa-plus"></i>&nbsp;Créer</button>
			</div>
		</form:form>
	</div>
</div>
<!-- /.box-body -->
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script>
$(document).ready(function() {
	$('#dp3').datepicker({
		  format: 'dd/mm/yyyy'
	});
});
</script>

<script>
	// $("[name='active']").bootstrapSwitch({
	// 	"on-label":"actif",
	// 	"off-label":"désSactif"

	// });
	// $("[name='active']").bootstrapSwitch('setOnLabel', 'I');
	// $("[name='active']").bootstrapSwitch('setOffLabel', 'O');
</script>
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
		<h3 class="box-title">Informations Personnelle</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->

	<div class="box-body">

		<form:form method="POST" commandName="user" id="userF"
			data-toggle="validator" cssClass="form-horizontal" action="${baseURL}/user/update">
			<div class="form-group">
				<label for="nameField" class="col-sm-2 control-label esoft-left">Nom:</label>
				<div class="col-sm-4">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" />
				</div>

			</div>
			<div class="form-group form-horizontal">
				<label for="lastnameField" class="col-sm-2 control-label esoft-left">Prenom:</label>
				<div class="col-sm-4">
					<form:input path="lastName" cssClass="form-control" />
					<form:errors path="lastName" cssClass="error" />
				</div>
			</div>
			<div class="form-group form-horizontal">
				<label for="activ" class="col-sm-2 control-label esoft-left">compte
					activé:</label>
				<div class="col-sm-4">
					<form:checkbox path="active" />
					<form:errors path="active" cssClass="error" />
				</div>

			</div>

<%-- 	<form:errors path="*" cssClass="errorblock" /> --%>
			<div class="form-group">
				<label for="dateField" class="col-sm-2 control-label esoft-left">Date
					de Naissance:</label>

				<div class="input-append date col-sm-4" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy">
					<form:input path="birdDay" id="dp3" />
					<span class="add-on"><span class="fa fa-calendar" id="cal2"></span></span>
					<form:errors path="birdDay" />
				</div>
			</div>
			<div class="form-group">
				<label for="emailField" class="col-sm-2 control-label esoft-left">Email:</label>
				<div class="col-sm-4">
					<form:input path="email" cssClass="form-control"
						placeholder="exemple@hotmail.com" />
					<form:errors path="email" cssClass="error" />
				</div>
				<div class="col-sm-6">
					<p class="help-block" style="padding-left: 27%">
						<code>Inserez une photo d'utisiateur ci-dessus</code>
					</p>
				</div>
			</div>
			<div class="form-group">
				<label for="phoneField" class="col-sm-2 control-label esoft-left">Telephone:</label>
				<div class="col-sm-4">
					<form:input path="telephone" cssClass="form-control" />
					<form:errors path="telephone" cssClass="error" />
				</div>
				<div class="col-sm-6">
					<input type="file" name="picture" accept="/image*"
						style="padding-left: 36%" />
				</div>

			</div>
			<div class="form-group">
				<label for="fonctionField" class="col-sm-2 control-label esoft-left">Fonction:</label>
				<div class="col-sm-4">
					<form:input path="fonction" cssClass="form-control" />
					<form:errors path="fonction" cssClass="error" />
				</div>

			</div>

			<div class="form-group">
				<label for="adresseField" class="col-sm-2 control-label esoft-left">Adresse:</label>
				<div class="col-sm-4">
					<form:textarea path="adresse1" rows="2" cols="50" />
					<form:errors path="adresse1" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="CPField" class="col-sm-2 control-label esoft-left">code
					Postal:</label>
				<div class="col-sm-4">
					<form:input path="zipCode" cssClass="form-control input-lg" />
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
						<option value="30">Afghanistan (AF)</option>
						<option value="205">Afrique du Sud (ZA)</option>
						<option value="32">Albanie (AL)</option>
						<option value="13">Algérie (DZ)</option>
						<option value="5">Allemagne (DE)</option>
						<option value="34">Andorre (AD)</option>
						<option value="35">Angola (AO)</option>
						<option value="36">Anguilla (AI)</option>
						<option value="37">Antarctique (AQ)</option>
						<option value="38">Antigua-et-Barbuda (AG)</option>
						<option value="164">Antilles néerlandaises (AN)</option>
						<option value="26">Arabie Saoudite (SA)</option>
						<option value="23">Argentine (AR)</option>
						<option value="39">Arménie (AM)</option>
						<option value="40">Aruba (AW)</option>
						<option value="28">Australie (AU)</option>
						<option value="41">Autriche (AT)</option>
						<option value="42">Azerbaïdjan (AZ)</option>
						<option value="43">Bahamas (BS)</option>
						<option value="44">Bahreïn (BH)</option>
						<option value="45">Bangladesh (BD)</option>
						<option value="46">Barbade (BB)</option>
						<option value="2">Belgique (BE)</option>
						<option value="48">Belize (BZ)</option>
						<option value="49">Bénin (BJ)</option>
						<option value="50">Bermudes (BM)</option>
						<option value="51">Bhoutan (BT)</option>
						<option value="47">Biélorussie (BY)</option>
						<option value="160">Birmanie (Myanmar) (MM)</option>
						<option value="52">Bolivie (BO)</option>
						<option value="53">Bosnie-Herzégovine (BA)</option>
						<option value="54">Botswana (BW)</option>
						<option value="56">Brésil (BR)</option>
						<option value="58">Brunei (BN)</option>
						<option value="59">Bulgarie (BG)</option>
						<option value="60">Burkina Faso (BF)</option>
						<option value="61">Burundi (BI)</option>
						<option value="62">Cambodge (KH)</option>
						<option value="24">Cameroun (CM)</option>
						<option value="14">Canada (CA)</option>
						<option value="63">Cap-Vert (CV)</option>
						<option value="67">Chili (CL)</option>
						<option value="9">Chine (CN)</option>
						<option value="78">Chypre (CY)</option>
						<option value="70">Colombie (CO)</option>
						<option value="71">Comores (KM)</option>
						<option value="72">Congo (CG)</option>
						<option value="128">Corée du Nord (KP)</option>
						<option value="129">Corée du Sud (KR)</option>
						<option value="75">Costa Rica (CR)</option>
						<option value="21">Côte d'Ivoire (CI)</option>
						<option value="76">Croatie (HR)</option>
						<option value="77">Cuba (CU)</option>
						<option value="80">Danemark (DK)</option>
						<option value="81">Djibouti (DJ)</option>
						<option value="82">Dominique (DM)</option>
						<option value="85">Egypte (EG)</option>
						<option value="227">Émirats arabes unishh (xx)</option>
						<option value="84">Equateur (EC)</option>
						<option value="88">Erythrée (ER)</option>
						<option value="4">Espagne (ES)</option>
						<option value="89">Estonie (EE)</option>
						<option value="11">Etats-Unis (US)</option>
						<option value="90">Ethiopie (ET)</option>
						<option value="94">Finlande (FI)</option>
						<option value="1" selected="selected">France (FR)</option>
						<option value="16">Gabon (GA)</option>
						<option value="98">Gambie (GM)</option>
						<option value="99">Géorgie (GE)</option>
						<option value="100">Ghana (GH)</option>
						<option value="101">Gibraltar (GI)</option>
						<option value="7">Grande-Bretagne (GB)</option>
						<option value="102">Grèce (GR)</option>
						<option value="104">Grenade (GD)</option>
						<option value="103">Groenland (GL)</option>
						<option value="106">Guam (GU)</option>
						<option value="107">Guatemala (GT)</option>
						<option value="241">Guernesey (GG)</option>
						<option value="108">Guinée (GN)</option>
						<option value="87">Guinée Equatoriale (GQ)</option>
						<option value="109">Guinée-Bissao (GW)</option>
						<option value="95">Guyane française (GF)</option>
						<option value="111">Haïti (HT)</option>
						<option value="114">Honduras (HN)</option>
						<option value="115">Hong Kong (HK)</option>
						<option value="18">Hongrie (HU)</option>
						<option value="55">Ile Bouvet (BV)</option>
						<option value="68">Ile Christmas (CX)</option>
						<option value="171">Ile Norfolk (NF)</option>
						<option value="242">Ile de Man (IM)</option>
						<option value="31">Iles Aland (AX)</option>
						<option value="64">Iles Cayman (KY)</option>
						<option value="74">Iles Cook (CK)</option>
						<option value="91">Iles Falkland (FK)</option>
						<option value="92">Iles Féroé (FO)</option>
						<option value="93">Iles Fidji (FJ)</option>
						<option value="206">Iles Géorgie du Sud et Sandwich du
							Sud (GS)</option>
						<option value="112">Iles Heard et McDonald (HM)</option>
						<option value="149">Iles Marshall (MH)</option>
						<option value="228">Iles Mineures Eloignées des
							États-Unis (UM)</option>
						<option value="183">Iles Pitcairn (PN)</option>
						<option value="203">Iles Salomon (SB)</option>
						<option value="210">Iles Svalbard et Jan Mayen (SJ)</option>
						<option value="223">Iles Turks-et-Caicos (TC)</option>
						<option value="235">Iles Vierges Américaines (VI)</option>
						<option value="234">Iles Vierges Britanniques (VG)</option>
						<option value="69">Iles des Cocos (Keeling) (CC)</option>
						<option value="117">Inde (IN)</option>
						<option value="118">Indonésie (ID)</option>
						<option value="119">Iran (IR)</option>
						<option value="120">Iraq (IQ)</option>
						<option value="8">Irlande (IE)</option>
						<option value="116">Islande (IS)</option>
						<option value="121">Israël (IL)</option>
						<option value="3">Italie (IT)</option>
						<option value="122">Jamaïque (JM)</option>
						<option value="123">Japon (JP)</option>
						<option value="243">Jersey (JE)</option>
						<option value="124">Jordanie (JO)</option>
						<option value="125">Kazakhstan (KZ)</option>
						<option value="126">Kenya (KE)</option>
						<option value="131">Kirghizistan (KG)</option>
						<option value="127">Kiribati (KI)</option>
						<option value="130">Koweït (KW)</option>
						<option value="132">Laos (LA)</option>
						<option value="135">Lesotho (LS)</option>
						<option value="133">Lettonie (LV)</option>
						<option value="134">Liban (LB)</option>
						<option value="136">Liberia (LR)</option>
						<option value="137">Libye (LY)</option>
						<option value="138">Liechtenstein (LI)</option>
						<option value="139">Lituanie (LT)</option>
						<option value="140">Luxembourg (LU)</option>
						<option value="141">Macao (MO)</option>
						<option value="142">Macédoine (Ex-République yougoslave)
							(MK)</option>
						<option value="143">Madagascar (MG)</option>
						<option value="145">Malaisie (MY)</option>
						<option value="144">Malawi (MW)</option>
						<option value="146">Maldives (MV)</option>
						<option value="147">Mali (ML)</option>
						<option value="148">Malte (MT)</option>
						<option value="172">Mariannes du Nord (MP)</option>
						<option value="12">Maroc (MA)</option>
						<option value="152">Maurice (MU)</option>
						<option value="151">Mauritanie (MR)</option>
						<option value="153">Mayotte (YT)</option>
						<option value="154">Mexique (MX)</option>
						<option value="155">Micronésie (FM)</option>
						<option value="156">Moldavie (MD)</option>
						<option value="27">Monaco (MC)</option>
						<option value="157">Mongolie (MN)</option>
						<option value="158">Monserrat (MS)</option>
						<option value="244">Monténégro (ME)</option>
						<option value="159">Mozambique (MZ)</option>
						<option value="161">Namibie (NA)</option>
						<option value="162">Nauru (NR)</option>
						<option value="163">Népal (NP)</option>
						<option value="167">Nicaragua (NI)</option>
						<option value="168">Niger (NE)</option>
						<option value="169">Nigeria (NG)</option>
						<option value="170">Nioué (NU)</option>
						<option value="173">Norvège (NO)</option>
						<option value="165">Nouvelle-Calédonie (NC)</option>
						<option value="166">Nouvelle-Zélande (NZ)</option>
						<option value="174">Oman (OM)</option>
						<option value="225">Ouganda (UG)</option>
						<option value="230">Ouzbékistan (UZ)</option>
						<option value="175">Pakistan (PK)</option>
						<option value="176">Palaos (PW)</option>
						<option value="178">Panama (PA)</option>
						<option value="179">Papouasie-Nouvelle-Guinée (PG)</option>
						<option value="180">Paraguay (PY)</option>
						<option value="17">Pays-Bas (NL)</option>
						<option value="181">Pérou (PE)</option>
						<option value="182">Philippines (PH)</option>
						<option value="184">Pologne (PL)</option>
						<option value="96">Polynésie française (PF)</option>
						<option value="185">Porto Rico (PR)</option>
						<option value="25">Portugal (PT)</option>
						<option value="186">Qatar (QA)</option>
						<option value="83">République Dominicaine (DO)</option>
						<option value="79">République Tchèque (CZ)</option>
						<option value="65">République centrafricaine (CF)</option>
						<option value="73">République démocratique du Congo (CD)</option>
						<option value="188">Roumanie (RO)</option>
						<option value="19">Russie (RU)</option>
						<option value="189">Rwanda (RW)</option>
						<option value="237">Sahara Occidental (EH)</option>
						<option value="245">Saint-Barthélemy (BL)</option>
						<option value="191">Saint-Christophe-et-Niévès (KN)</option>
						<option value="196">Saint-Marin (SM)</option>
						<option value="246">Saint-Martin (MF)</option>
						<option value="193">Saint-Pierre-et-Miquelon (PM)</option>
						<option value="113">Saint-Siège (Vatican) (VA)</option>
						<option value="194">Saint-Vincent-et-les-Grenadines (VC)</option>
						<option value="190">Sainte-Hélène (SH)</option>
						<option value="192">Sainte-Lucie (LC)</option>
						<option value="86">Salvador (SV)</option>
						<option value="195">Samoa (WS)</option>
						<option value="33">Samoa américaines (AS)</option>
						<option value="197">Sao Tomé-et-Principe (ST)</option>
						<option value="22">Sénégal (SN)</option>
						<option value="198">Serbie (RS)</option>
						<option value="199">Seychelles (SC)</option>
						<option value="200">Sierra Leone (SL)</option>
						<option value="29">Singapoure (SG)</option>
						<option value="201">Slovaquie (SK)</option>
						<option value="202">Slovénie (SI)</option>
						<option value="204">Somalie (SO)</option>
						<option value="208">Soudan (SD)</option>
						<option value="207">Sri Lanka (LK)</option>
						<option value="20">Suède (SE)</option>
						<option value="6">Suisse (CH)</option>
						<option value="209">Suriname (SR)</option>
						<option value="211">Swaziland (SZ)</option>
						<option value="212">Syrie (SY)</option>
						<option value="214">Tadjikistan (TJ)</option>
						<option value="213">Taïwan (TW)</option>
						<option value="215">Tanzanie (TZ)</option>
						<option value="66">Tchad (TD)</option>
						<option value="97">Terres australes françaises (TF)</option>
						<option value="177">Territoire Palestinien Occupé (PS)</option>
						<option value="57">Territoire britannique de l'Océan
							Indien (IO)</option>
						<option value="216">Thaïlande (TH)</option>
						<option value="217">Timor Oriental (TL)</option>
						<option value="15">Togo (TG)</option>
						<option value="218">Tokélaou (TK)</option>
						<option value="219">Tonga (TO)</option>
						<option value="220">Trinité-et-Tobago (TT)</option>
						<option value="10">Tunisie (TN)</option>
						<option value="222">Turkménistan (TM)</option>
						<option value="221">Turquie (TR)</option>
						<option value="224">Tuvalu (TV)</option>
						<option value="226">Ukraine (UA)</option>
						<option value="229">Uruguay (UY)</option>
						<option value="231">Vanuatu (VU)</option>
						<option value="232">Vénézuela (VE)</option>
						<option value="233">Viêt Nam (VN)</option>
						<option value="236">Wallis-et-Futuna (WF)</option>
						<option value="238">Yémen (YE)</option>
						<option value="239">Zambie (ZM)</option>
						<option value="240">Zimbabwe (ZW)</option>
					</form:select>
					<form:errors path="country" cssClass="error" />
				</div>

			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label esoft-left">Login:</label>
				<div class="col-sm-4">
					<form:input path="login" cssClass="form-control" />
					<form:errors path="login" cssClass="error" />
				</div>
			</div>
			<form:hidden path="password" />
			<form:hidden path="id"/>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn pull-right">Ajouter</button>
				<button type="button" class="btn btn-default btn pull-right">Annuler</button>
			</div>
		</form:form>
	</div>
</div>
<!-- /.box-body -->
<div class="box box-solid box-primary">
	<div class="box-header">
		<h3 class="box-title">Modification de mot de passe</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<div class="box-body">
		<form:form action="${baseURL}/user/editPassword" method="POST"
			commandName="password" data-toggle="validator"
			cssClass="form-horizontal">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label esoft-left">Mot de passe</label>
				<div class="col-sm-4">
					<form:password path="password1" cssClass="form-control" />
					<form:errors path="password1" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label esoft-left">Confirmer mot de passe</label>
				<div class="col-sm-4">
					<form:password path="password2" cssClass="form-control" />
					<form:errors path="password2" cssClass="error" />
				</div>
			</div>
			<form:hidden path="id" />
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn pull-right">modifier</button>
				<button type="button" class="btn btn-default btn pull-right">Annuler</button>
			</div>
		</form:form>


	</div>
</div>
<script src="${baseURL}/js/bootstrap-datepicker.js"></script>
<script>
$(document).ready(function(){
    $('#dp3').datepicker();
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
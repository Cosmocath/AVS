<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: #FFFFFF; height: 100%;">
	<div>
		<div style="display: inline-block; float: left; padding-left: 25px;">
			<html:link href="listerProduitClient.do" title="logo">
				<img alt="logo" src="img/logo_AVS.png" style="width: 120%">
			</html:link>
		</div>
		<div style="display: inline-block; padding-left: 141px;">
			<h2>
				<logic:notPresent name="userConnected" scope="session">
					<bean:message key="HEADER.bonjourVisiteur" />
				</logic:notPresent>
				<logic:present name="userConnected" scope="session">
					<bean:message key="HEADER.bonjour" />
					<bean:write name="userConnected" property="nom" />
				</logic:present>
			</h2>
		</div>
		<div
			style="display: inline-block; float: right; padding-top: 20px; padding-right: 140px;">
			<logic:present name="userConnected" scope="session">
				<html:link href="deconnecterUser.do" title="logout">
					<img alt="logo" src="img/icone_logout.png" style="width: 40px;">
				</html:link>
			</logic:present>
			<logic:present name="userConnected" scope="session">
				<html:link href="afficherPanier.do" title="panier">
					<img alt="logo" src="img/icone_panier.png" style="width: 40px;">
				</html:link>
				<bean:write name="monPanierDto" property="quantiteTotale" />
			</logic:present>
			<logic:notPresent name="userConnected" scope="session">
				<html:link href="voirConnecterUser.do" title="login">
					<img alt="logo" src="img/icone_login.png" style="width: 40px;">
				</html:link>
			</logic:notPresent>
			<logic:notPresent name="userConnected" scope="session">
				<html:link href="voirCreerUser.do" title="Inscription">
					<img alt="logo" src="img/signup.png" style="width: 35px;">
				</html:link>
			</logic:notPresent>
		</div>
	</div>
</div>
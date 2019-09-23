<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: #4B70D3; height: 100%;">
	<div>
		<div style="display: inline;">
			<img alt="logo" src="img/logo_AVS.png">
		</div>

		<div style="float: right;">
			<logic:present name="userConnected" scope="session">
				<html:link href="deconnecterUser.do" title="logout">
					<img alt="logo" src="img/icone_logout.png">
				</html:link>
			</logic:present>
			<logic:present name="userConnected" scope="session">
				<html:link href="afficherPanier.do" title="panier">
					<img alt="logo" src="img/icone_panier.png">
				</html:link>
			</logic:present>
			<logic:notPresent name="userConnected" scope="session">
				<html:link href="voirConnecterUser.do" title="login">
					<img alt="logo" src="img/icone_login.png">
				</html:link>
			</logic:notPresent>
			<logic:notPresent name="userConnected" scope="session">
				<html:link href="#" title="Inscription">
					<img alt="logo" src="img/signup.png">
				</html:link>
			</logic:notPresent>
		</div>
	</div>
</div>
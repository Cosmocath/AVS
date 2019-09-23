<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: #4B70D3; height: 100%; padding: 10px;">
	<div>
		<div style="display: inline;">
			<img alt="logo" src="img/logo_AVS.png">
		</div>

		<div style="float: right;">
			<logic:present name="userConnected" scope="session">
				<a href="deconnecterUser.do" title="logout"><img alt="logo"
					src="img/icone_logout.png"></a>
			</logic:present>
			<logic:present name="userConnected" scope="session">
				<a href="afficherPanier.do" title="panier"><img alt="logo"
					src="img/icone_panier.png"></a>
			</logic:present>
			<logic:notPresent name="userConnected" scope="session">
				<a href="voirConnecterUser.do" title="login"><img alt="logo"
					src="img/icone_login.png"></a>
			</logic:notPresent>
			<logic:notPresent name="userConnected" scope="session">
				<a href="#" title="Inscription"><img alt="logo" src="img/signup.png"></a>
			</logic:notPresent>
		</div>
	</div>
</div>
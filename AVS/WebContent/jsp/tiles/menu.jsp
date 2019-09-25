<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">

	<html:link href="listerProduitClient.do">
		<bean:message key="MENU.ListeDesProduitsClient" />
	</html:link>
	<br />

	<logic:notPresent name="userConnected" scope="session">
		<html:link href="voirConnecterUser.do">
			<bean:message key="MENU.SeConnecter" />
		</html:link>
	</logic:notPresent>

	<logic:present name="userConnected" scope="session">
		<logic:equal name="userConnected" property="profil" value="CLIENT">
			<html:link href="listerCommande.do">
				<bean:message key="MENU.ListeDesCommandes" />
			</html:link>
			<br />
			<html:link href="deconnecterUser.do">
				<bean:message key="MENU.Deconnecter" />
			</html:link>
			<%
			    //TODO a spprimer plus tard
			%>
			<br />
			<html:link href="afficherPanier.do">
				Afficher Panier
			</html:link>
		</logic:equal>

		<logic:equal name="userConnected" property="profil"
			value="ADMINISTRATEUR">
			<html:link href="listerProduitAdmin.do">
				<bean:message key="MENU.ListeProduitAdmin" />
			</html:link>
			<br />
			<html:link href="voirCreerProduit.do">
				<bean:message key="MENU.VoirCreerProduit" />
			</html:link>
			<br />
			<br />
			<html:link href="listerCommande.do" paramName="userConnected" paramProperty="id" paramId="id">
				<bean:message key="MENU.ListeDesCommandes" />
			</html:link>
			<br />
			<br />
			<html:link href="listerUser.do">
				<bean:message key="MENU.ListerUser" />
			</html:link>
			<br />
			<html:link href="voirCreerUser.do">
				<bean:message key="MENU.CreerUser" />
			</html:link>
			<br />
			<br />
			<html:link href="deconnecterUser.do">
				<bean:message key="MENU.Deconnecter" />
			</html:link>
			<%
			    //TODO a spprimer plus tard
			%>
			<br />
			<html:link href="afficherPanier.do">
				Afficher Panier
			</html:link>
		</logic:equal>

	</logic:present>
</div>
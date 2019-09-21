<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: gray; height: 100%; padding: 10px">
	<bean:define id="contextPath" value="<%=request.getContextPath()%>" />


	<html:link href="${contextPath}/listerProduitClient.do">
		<bean:message key="MENU.ListeDesProduitsClient" />
	</html:link>
	<br>

	<logic:notPresent name="UserDto" scope="session">
		<html:link href="${contextPath}/voirConnecterUser.do">
			<bean:message key="MENU.SeConnecter" />
		</html:link>
	</logic:notPresent>


	<logic:present name="UserDto" scope="session">
		<logic:equal name="${UserDto.profil}" value="${CLIENT}">
			<html:link href="${contextPath}/listerCommande.do">
				<bean:message key="MENU.ListeDesCommandes" />
			</html:link>
			<br>
			<html:link href="${contextPath}/deconnecterUser.do">
				<bean:message key="MENU.Deconnecter" />
			</html:link>
		</logic:equal>

		<logic:equal name="${UserDto.profil}" value="${ADMINISTRATEUR}">
			<html:link href="${contextPath}/listerProduitAdmin.do">
				<bean:message key="MENU.ListeProduitAdmin" />
			</html:link>
			<br>
			<html:link href="${contextPath}/voirCreerProduit.do">
				<bean:message key="MENU.VoirCreerProduit" />
			</html:link>
			<br>
			<br>
			<html:link href="${contextPath}/listerCommande.do">
				<bean:message key="MENU.ListeDesCommandes" />
			</html:link>
			<br>
			<br>
			<html:link href="${contextPath}/listerUser.do">
				<bean:message key="MENU.listerUser" />
			</html:link>
			<br>
			<br>
			<html:link href="${contextPath}/deconnecterUser.do">
				<bean:message key="MENU.Deconnecter" />
			</html:link>
		</logic:equal>


	</logic:present>
</div>
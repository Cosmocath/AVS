<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_01.titre" /></title>

<div style="height: 100%; padding: 10px">
	<div>
		<bean:message key="USR_01.titre" />
		<html:form action="/creerUser.do" focus="mail">

			<table style="border: none;">
				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors property="error" />
				<tr>
					<td align="right"><bean:message key="USR_01.mail"></bean:message></td>
					<td align="left"><html:text property="mail" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="mail" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.nom"></bean:message></td>
					<td align="left"><html:text property="nom" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="nom" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.prenom"></bean:message></td>
					<td align="left"><html:text property="prenom" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="prenom" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.dateNaissance"></bean:message></td>
					<td align="left"><html:text property="dateNaissance" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="dateNaissance" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.password"></bean:message></td>
					<td align="left"><html:text property="password" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="password" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_01.confirmpassword"></bean:message></td>
					<td align="left"><html:text property="confirmpassword"
							size="25" maxlength="25"></html:text></td>
					<td><html:errors property="confirmpassword" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_01.adresse"></bean:message></td>
					<td align="left"><html:text property="adresse" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="adresse" /></td>
				</tr>
				<logic:present name="userConnected" scope="session">
					<tr>
						<td align="right"><bean:message key="USR_01.profil"></bean:message></td>
						<td align="left"><html:radio property="profil" value="1">Client</html:radio>
							<html:radio property="profil" value="2"></html:radio>Admininstrateur</td>
						<td><html:errors property="profil" /></td>
					</tr>
				</logic:present>

				<logic:notPresent name="userConnected" scope="session">
					<tr>
						<td align="right"><html:hidden property="profil" value="2" /></td>
						<td><html:errors property="profil" /></td>
					</tr>
				</logic:notPresent>
				<tr>
					<td align="right"><html:submit property="submit"
							value="Valider" /></td>
				</tr>
				<tr></tr>
			</table>
		</html:form>
	</div>
</div>
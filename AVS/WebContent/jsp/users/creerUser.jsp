<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_01.titre" /></title>

<div style="height: 100%;">
	<div>
		<h1>
			<bean:message key="USR_01.titre" />
		</h1>

		<logic:messagesPresent message="true">
			<html:messages id="creationUserOK" property="creationUserOK"
				message="true" header="valid.global.header"
				footer="valid.global.footer">
				<bean:write name="creationUserOK" />
			</html:messages>
		</logic:messagesPresent>

		<html:form action="/creerUser.do" focus="mail">

			<table style="border: none;">
				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors property="error" />
				<tr>
					<td align="right"><bean:message key="USR_01.mail"></bean:message></td>

					<td align="left"><html:text property="mail" size="25"
							maxlength="50"></html:text></td>
					<td><html:errors property="mail" header="errors.global.header"
							footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.nom"></bean:message></td>
					<td align="left"><html:text property="nom" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="nom" header="errors.global.header"
							footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.prenom"></bean:message></td>
					<td align="left"><html:text property="prenom" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="prenom"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.dateNaissance"></bean:message></td>
					<td align="left"><html:text property="dateNaissance" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="dateNaissance"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.password"></bean:message></td>
					<td align="left"><html:text property="password" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="password"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.confirmpassword"></bean:message></td>
					<td align="left"><html:text property="confirmpassword"
							size="25" maxlength="25"></html:text></td>
					<td><html:errors property="confirmpassword"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_01.adresse"></bean:message></td>
					<td align="left"><html:textarea property="adresse" rows="3"
							cols="50"></html:textarea></td>
					<td><html:errors property="adresse"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>

				<logic:present name="userConnected" scope="session">
					<tr>
						<td align="right"><bean:message key="USR_01.profil"></bean:message></td>
						<td align="left"><html:radio property="profil" value="2">
								<bean:message key="USR_01.profil.client" />
							</html:radio> <html:radio property="profil" value="3"></html:radio> <bean:message
								key="USR_01.profil.admin" /></td>
						<td><html:errors property="profil"
								header="errors.global.header" footer="errors.global.footer" /></td>
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
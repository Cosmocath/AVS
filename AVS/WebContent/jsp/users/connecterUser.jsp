<%@include file="/jsp/tiles/taglib.jsp" %>
<title><bean:message key="connexion.titre" /></title>

<div style="background-color: #D65858; height: 100%; padding: 10px">
<html:form action="/connecterUser.do" focus="mail">
	<div align="center">
		<table style="border:none;">
			<%-- permet d'afficher les erreurs "globales" --%>
			<html:errors property="error" />
			<tr>
				<td align="right"><bean:message key="connexion.identifiant"></bean:message></td>
				<td align="left"><html:text property="mail" size="25"
						maxlength="25" altKey="connexion.mail"></html:text></td>
				<td><html:errors property="mail" /></td>
			</tr>

			<tr>
				<td align="right"><bean:message key="connexion.password"></bean:message></td>
				<td align="left"><html:text property="password" size="25"
						maxlength="25"></html:text></td>
				<td><html:errors property="password" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit" value="Submit" /></td>
			</tr>
			<tr></tr>
		</table>
	</div>
</html:form>

<%-- Permet d'afficher les messages si present --%>
<logic:messagesPresent message="true">
	<html:messages id="connexionOK" property="connexionOK" message="true">
		<bean:write name="connexionOK" />
	</html:messages>
</logic:messagesPresent>
</div>
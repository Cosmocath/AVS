<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><bean:message key="connexion.titre" /></title>
</head>
<body>
	<br />
	<html:form action="/connecterUser.do" focus="mail">
		<table border="0" align="center">
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
				<td><html:errors property="password"/></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit" value="Submit" /></td>
			</tr>
			<tr></tr>
		</table>
	</html:form>

	<%-- Permet d'afficher les messages si present --%>
	<logic:messagesPresent message="true">
		<html:messages id="connexionOK" property="connexionOK" message="true">
			<bean:write name="connexionOK" />
		</html:messages>
	</logic:messagesPresent>

	<%-- permet d'afficher les erreurs "globales" --%>
	<html:errors property="error" />

	<br />

</body>
</html>
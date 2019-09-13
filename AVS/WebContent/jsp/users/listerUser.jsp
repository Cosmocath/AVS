<%@include file="/jsp/tiles/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><bean:message key="USR_02.titre" /></title>
</head>
<body>
	<h1>
		<bean:message key="USR_02.titre" />
	</h1>

	<%-- Permet d'afficher les messages si present (pour la suppression) --%>
	<logic:messagesPresent message="true">
		<html:messages id="deleteOK" property="deleteOK" message="true"
			header="valid.global.header" footer="valid.global.footer">
			<bean:write name="deleteOK" />
		</html:messages>
	</logic:messagesPresent>
	
	
	<%-- Permet d'afficher les messages si present (pour les modifications) --%>
	<logic:messagesPresent message="true">
		<html:messages id="editOK" property="editOK" message="true"
			header="valid.global.header" footer="valid.global.footer">
			<bean:write name="editOK" />
		</html:messages>
	</logic:messagesPresent>
	
	
	<table width="300px">
		<tr align="center">
			<th width="70%"><bean:message key="USR_02.header.consulter" /></th>
			<th width="30%"><bean:message key="USR_02.header.action" /></th>
		</tr>
		
		
		<%-- parcours de la liste des users et affichage  de quelques données--%>
		<logic:iterate name="listeUser" id="utilisateur" scope="request">
			<tr>
				<td width="70%" align="left" style="padding-left: 10px">					
						- <bean:write name="utilisateur" property="mail" />
						- <bean:write name="utilisateur" property="nom" />
						- <bean:write name="utilisateur" property="prenom" />
						- <bean:write name="utilisateur" property="date_naissance" />
						- <bean:write name="utilisateur" property="id_Profil" />										
					</td>
					
				<td width="30%" align="center"><html:link
						href="voirEditerChat.do?id=${user.id}">
						<bean:message key="lister.editer" />
					</html:link></td>
					<td width="30%" align="center"><html:link
						href="consulterUser.do?id=${user.id}">
						<bean:message key="lister.editer" />
					</html:link></td>	
			</tr>
		</logic:iterate>
	</table>
	<br />
	
</body>
</html:html>

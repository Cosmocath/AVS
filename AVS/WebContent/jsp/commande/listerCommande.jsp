<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Commande</title>
</head>
<body>
<%-- parcours de la liste des Chats et affichage leur numero de puce --%>
<%-- 	 	<logic:iterate name="listeCommande" id="id_Utilisateur" scope="request"> --%>
	 		<tr>
	 			<td width="70%" align="left" style="padding-left: 10px">
					<html:link href="consulterCommande.do?id=${commande.id_Utilisateur}">
						- <bean:write name="commande" property="id_Utilisateur"/>
					</html:link>
				</td>
				</tr>
</body>
</html:html>
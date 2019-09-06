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

	<logic:iterate name="listeCommande" id="commande" scope="request">

		<div>
			<html:link href="consulterCommande.do?id=${commande.id_Commande}">
				<bean:write name="commande" property="numero_Commande" />
			</html:link>
			<br />
			<bean:write name="commande" property="date" />
		</div>
	</logic:iterate>
</body>
</html:html>
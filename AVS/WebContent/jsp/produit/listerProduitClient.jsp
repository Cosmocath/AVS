<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><bean:message key="listerProduits.titre" /></title>
<%-- JS nécessaire pour le bouton ajouter au panier  --%>
<script type="text/javascript">
	function RedirectionJavascript() {
		//     	 alert(document.getElementById("id").value);

		// Modifier le bouton avec URL pour image
		document.location.href = "#";
	}
</script>
</head>
<body>
	<h1>
		<bean:message key="listerProduits.titre" />
	</h1>

	<logic:iterate name="listeProduits" id="produit" scope="request">
		<tr>
			<td></td>
			<td style="padding-left: 250px"><bean:write name="produit"
					property="designation" /> /<bean:write name="produit"
					property="reference" /><br /> <bean:write name="produit"
					property="description" /><br /> <bean:write name="produit"
					property="prix" /> EURO <bean:message key="produit.labelPrix" />
				<html:button property="ajout" onclick="RedirectionJavascript()">
					<bean:message key="bouton.ajouterPanier" />
				</html:button></td>
		</tr>
		<hr></hr>
	</logic:iterate>



</body>
</html:html>
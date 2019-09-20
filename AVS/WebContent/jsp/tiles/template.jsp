<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="/jsp/tiles/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body style="margin: 0px; min-height: 100%">
	<table id="ecran" width="100%" style="height: 750px" cellpadding="0px" cellspacing="0px">
		<tr>
			<td colspan="2" style="height: 10%">
			<tiles:insert attribute="header" />
			</td>
		</tr>
		<tr>
			<td width="20%" style="height: 80%">
			<tiles:insert attribute="menu" />
			</td>
			<td width="80%" style="height: 80%">
			<tiles:insert attribute="body" />
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height: 10%">
			<tiles:insert attribute="footer" />
			</td>
		</tr>
	</table>

	<script language="JavaScript">
		function tailleEcran() {

			htEcran = screen.height;
			htEcran = Math.round(htEcran * 0.855);
			document.getElementById("ecran").style.height = htEcran + "px";
		}
		tailleEcran();
	</script>

</body>
</html:html>
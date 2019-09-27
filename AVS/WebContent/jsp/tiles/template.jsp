<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="/jsp/tiles/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body id="ecran" style="height: 1000px; margin: 0px">
	<table width="100%" style="height: 100%" cellpadding="0px"
		cellspacing="0px">
		<tr>
			<td colspan="2" style="height: 10%"><tiles:insert
					attribute="header" /></td>
		</tr>
		<tr valign="top">
			<td width="20%"
				style="height: 80%; padding-top: 29px; padding-left: 14px;"><tiles:insert
					attribute="menu" /></td>
			<td width="80%" style="height: 80%"><div id="divBody"
					style="overflow-y: auto; max-height: 100px">
					<tiles:insert attribute="body" />
				</div></td>
		</tr>
		<tr>
			<td colspan="2" style="height: 5%"><tiles:insert
					attribute="footer" /></td>
		</tr>
	</table>

	<script language="JavaScript">
		function tailleEcran() {
			htEcran = screen.height;
			htEcran = Math.round(htEcran * 0.853);
			document.getElementById("ecran").style.height = htEcran + "px";
			document.getElementById("divBody").style.maxHeight = htEcran * 0.8
					+ "px";
		}
		tailleEcran();
	</script>

</body>
</html:html>
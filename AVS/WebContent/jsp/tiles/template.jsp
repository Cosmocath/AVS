<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body style="margin: 0px;">
	<table width="100%">
		<tr>
			<td height="10%" colspan="2"><tiles:insert attribute="header" />
			</td>
		</tr>
		<tr style="height: 480px;">
			<td width="20%" bgcolor="#74D658"><tiles:insert attribute="menu" />
			</td>
			<td width="80%" bgcolor="#D65858"><tiles:insert attribute="body" /></td>
		</tr>
		<tr>
			<td height="20%" colspan="2"><tiles:insert attribute="footer" />
			</td>
		</tr>
	</table>
</body>
</html>
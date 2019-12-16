<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
	<base href="/itstechadda/">
<link href="resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 
<link href="resources/assets/css/style.css" rel="stylesheet">
 
<link href="resources/assets/css/owl.carousel.css" rel="stylesheet">
<link href="resources/assets/css/owl.theme.css" rel="stylesheet">
 

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
<div id="wrapper">
            <tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute> 
            <tiles:insertAttribute name="indexbody" ignore="true"></tiles:insertAttribute>
			<tiles:insertAttribute name="footer" ignore="true"></tiles:insertAttribute> 
</div>
 
 
 
<script src="resources/ajax/libs/jquery/1.10.1/jquery.min.js"> </script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>

<script src="resources/assets/js/script.js"></script>
 
</body>

</html>
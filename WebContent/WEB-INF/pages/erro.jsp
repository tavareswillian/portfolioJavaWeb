<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Erro</title>
<link href="js/jquery/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="estilo.css" rel="stylesheet" />
<script src="js/custom.js" charset="UTF-8"></script>
</head>
<body>
	<h1>Erro!</h1>

	<div class="ui-widget">
		<p>Ocorreu um erro ao executar a ação desejada</p>
	</div>
	
	<!-- Tabs -->
	<div id="divErro" style="height: 300px">
		<c:forEach items="${errorList}" var="error">
			<p>${error}</p>
		</c:forEach>
	</div>

	<script src="js/jquery/external/jquery/jquery.js"></script>
	<script src="js/jquery/jquery-ui.js"></script>
	<script src="js/items_interface.js"></script>
</body>
</html>

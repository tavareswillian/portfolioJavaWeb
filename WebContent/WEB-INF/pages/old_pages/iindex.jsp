<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>${pageAttrib.titlePage }</title>
<link href="js/jquery/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="estilo.css" rel="stylesheet" />
<script src="js/custom.js" charset="UTF-8"></script>
</head>
<body>
	<div class="topnav">
		<c:forEach items="${menuList}" var="menu" varStatus="status">
			<%--  ${status.count}) ${item}<br/> --%>
			<a class="${menu.status }" href="${menu.url }">${menu.titulo} </a>
		</c:forEach>
		<a href="?acao=Sair" style="float: right;">Sair</a> <span
			style="float: right; color: #ff8040"> Bem
			vindo(a)&nbsp;${username}!</span>
	</div>
	<h1>${pageAttrib.titlePage }</h1>
	<div class="ui-widget">
		<p>${pageAttrib.descriPition }</p>
	</div>

	<div class="ui-widget" id="alerta" hidden="hidden"
		onclick="hide('alerta');">
		<span title="Clique para fechar esta mensagem"
			style="text-decoration: none;">
			<div class="ui-state-highlight ui-corner-all"
				style="margin-top: 20px; padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-info"
						style="float: left; margin-right: .3em;"></span> <strong>Sucesso:</strong>
					<span id="mensagemAlerta"></span>
				</p>
			</div>
		</span>
	</div>
	<div class="ui-widget" id="erro" hidden="hidden"
		onclick="hide('erro');">
		<sppan title="Clique para fechar esta mensagem"
			style="text-decoration: none;">
		<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
			<p>
				<span class="ui-icon ui-icon-alert"
					style="float: left; margin-right: .3em;"></span> <strong>Atenção:
				</strong> <span id="mensagemErro"></span>
			</p>
		</div>
		</span>
	</div>
	<br>
	<!-- Tabs -->
	<h2 class="demoHeaders">${pageAttrib.subTitlePage}</h2>
	<div id="tabs" style="height: 300px">
		<c:forEach items="${optionList}" var="option" varStatus="status">
			<ul>
				<li><a href="${option.url }">${option.title}
						<span class="${option.icon }" style="float: left; margin-right: .12em;"></span></a>
				</li>
			</ul>
			<%-- <jsp:include page ='<%=option.pagePath %>'/> --%>
		</c:forEach>
	</div>

	<script src="js/jquery/external/jquery/jquery.js"></script>
	<script src="js/jquery/jquery-ui.js"></script>
	<script>
		$("#button").button();
		$("#button-icon").button({
			icon : "ui-icon-gear",
			showLabel : false
		});

		$("#radioset").buttonset();

		$("#controlgroup").controlgroup();

		$("#tabs").tabs();

		$("#dialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Ok",
				click : function() {
					$(this).dialog("close");
				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		// Link to open the dialog
		$("#dialog-link").click(function(event) {
			$("#dialog").dialog("open");
			event.preventDefault();
		});

		$("#datepicker").datepicker({
			inline : true
		});

		$("#slider").slider({
			range : true,
			values : [ 17, 67 ]
		});

		$("#progressbar").progressbar({
			value : 20
		});

		$("#spinner").spinner();

		$("#menu").menu();

		$("#tooltip").tooltip();

		$("#selectmenu").selectmenu();

		// Hover states on the static widgets
		$("#dialog-link, #icons li").hover(function() {
			$(this).addClass("ui-state-hover");
		}, function() {
			$(this).removeClass("ui-state-hover");
		});
	</script>
</body>
</html>

<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<title>Portfólio</title>
<link href="js/jquery/jquery-ui.css" rel="stylesheet">
<link href="estilo.css" rel="stylesheet" />
<script src="js/custom.js" charset="UTF-8"></script>
</head>
<body>
	<div class="topnav">
		<a href="?acao=Cadastrar">Cadastros</a> 
		<a class="active" href="?acao=Consultar">Consultas</a>
		<a href="?acao=Configurar">Configurações</a>
		<a href="?acao=Sair" style="float: right;">Sair</a> 
		<%-- <span style="float: right; color: #ff8040"> Bem vindo(a)&nbsp;${username} </span> --%>
		<span style="float: right; color: #ff8040"> ${mensagem} </span>
	</div>
	<h1>Portifólio</h1>

	<div class="ui-widget">
		<p>Apresentação da aplicação cliente de portfólio Java</p>
	</div>

	<div class="ui-widget" id="alerta" hidden="hidden"
		onclick="hide('alerta');">
		<span title="Clique para fechar esta mensagem"
			style="text-decoration: none;">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
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
	<!-- <div class="ui-widget" hidden="hidden">
	<div class="ui-state-default ui-corner-all" style="padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
		<strong>Alert:</strong><span id="novo"></span></p>
	</div>
</div> -->
	<!-- Tabs -->
	<h2 class="demoHeaders">Consultas</h2>
	<div id="tabs" style="height: 300px">
		<ul>
			<li><a href="#usuarios">Usuários
									<span class="ui-icon ui-icon-person" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#listas">Listas
									<span class="ui-icon ui-icon-note" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#funcionalidades">Funcionalidades
									<span class="ui-icon ui-icon-wrench" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#documentos">Documentos
									<span class="ui-icon ui-icon-document" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#duvidas">Dúvidas
									<span class="ui-icon ui-icon-help" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#eventos">Eventos
									<span class="ui-icon ui-icon-calendar" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#perfis">Perfis
									<span class="ui-icon ui-icon-contact" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#permissoes">Permissões
									<span class="ui-icon ui-icon-locked" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#politicas">Políticas
									<span class="ui-icon ui-icon-suitcase" style="float: left; margin-right: .12em;"></span></a></li>
			<li><a href="#repositorios">Repositórios
									<span class="ui-icon ui-icon-folder-open" style="float: left; margin-right: .12em;"></span></a></li>

		</ul>
		<%@include file="consultas.jsp"%>
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

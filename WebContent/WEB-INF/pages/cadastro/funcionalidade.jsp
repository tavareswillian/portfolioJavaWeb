<script>
function cadastraNova(){
	var jsonFuncionalidade = {
	        "nmFuncionalidade" : $('#nmFuncionalidade').val(),
	        "dsFuncionalidade" : $('#dsFuncionalidade').val(),
	        "sourcePage" : $('#sourcePage').val(),
	        "pageLink" : $('#pageLink').val(),
	        "iconType" : $('#iconType').val()
	};
	
	cadastraFuncionalidade(JSON.stringify(jsonFuncionalidade));
}

function cadastraFuncionalidade(funcionalidade){

	var rootURL = "http://localhost:8080/funcionalidade";
	var erro = "";
	$.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : rootURL,
			dataType : "json",
			data : funcionalidade,
			success : function(){ alert('ok!');},
			error : alert(erro); // Adicionar a mensagem da exceção aqui
		});
}
</script>

<div id="funcionalidades"><!-- Controlgroup -->
<fieldset>
	<legend>Dados da nova funcionalidade</legend>
		<div id="controlgroup">
			<input type="text" Placeholder="Nome da funcionalidade" id="nmFuncionalidade"/>&nbsp;
			<input type="text" Placeholder="Descrição" id="dsFuncionalidade"/><br/>
			<input type="text" Placeholder="Caminho da página" id="sourcePage"/>&nbsp;
			<input type="text" Placeholder="Link da página" id="pageLink"/><br/>
			<!-- <input type="text" Placeholder="Tipo de icone" id="iconType"/><br/> -->
			<label for="cars">Tipo de icone: </label>
			<select id="iconType">
			  <option value="ui-icon ui-icon-person" selected>Usuário</option>
			  <option value="ui-icon ui-icon-note">Lista</option>
			  <option value="ui-icon ui-icon-wrench">Funcionalidade</option>
			  <option value="ui-icon ui-icon-documen">Documento</option>
			</select>
			<br/>
			<button onclick="cadastraNova();">Cadastrar</button>
			<button onclick="limpar('cadastroFuncionalidade');">Limpar</button>
		</div>
</fieldset>
</div>
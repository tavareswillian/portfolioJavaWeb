<div id="funcionalidade"><!-- Controlgroup -->
<fieldset>
	<legend>Dados da nova funcionalidade</legend>
		<div id="controlgroup">
			<input type="text" Placeholder="Nome da funcionalidade" id="nmFuncionalidade"/>&nbsp;
			<input type="text" Placeholder="Descri��o" id="dsFuncionalidade"/><br/>
			<input type="text" Placeholder="Caminho da p�gina" id="sourcePage"/>&nbsp;
			<input type="text" Placeholder="Link da p�gina" id="pageLink"/><br/>
			<!-- <input type="text" Placeholder="Tipo de icone" id="iconType"/><br/> -->
			<label for="cars">Tipo de icone: </label>
			<select id="iconType">
			  <option value="ui-icon ui-icon-person" selected>Usu�rio</option>
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
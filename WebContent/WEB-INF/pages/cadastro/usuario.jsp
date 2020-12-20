<div id="usuario">
<fieldset>
	<legend>Dados do novo usuário [1]</legend>
		<div id="controlgroup">
			<input type="text" Placeholder="Escolha o login" id="dsLogin"/> <label style="color: red; display: none;" id="mensagemLogin"></label><br/>
			<input type="text" Placeholder="Nome" id="nmUsuario"/> &nbsp;
			<input type="text" Placeholder="Sobrenome" id="nmSobrenome"/> <label style="color: red;" id="mensagemNomeSobrenome"></label><br />
			<input type="text" Placeholder="Senha" id="dsSenha"/> &nbsp;
			<input type="text" Placeholder="Confirme a senha" id="dsConfirmaSenha"/> <label style="color: red;" id="mensagemSenha"></label><br/>
			<button onclick="cadastrar('usuario');">Cadastrar</button>
			<button onclick="limpar('cadastroUsuario');">Limpar</button>
		</div>
</fieldset>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<html>
<head>
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css"
	type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.js"></script>
<style type="text/css">
body {
	font-family: verdana;
	font-size: 9pt;
	padding: 30px;
}
</style>
<script type="text/javascript">
	$(document).ready( //documento estiver pronto...
	function() { //faça...
		$("#janela").dialog({
			width : '400',
			modal : true,
			autoOpen : false
		});
		//criando o evento...
		$("#link").click( //ao clicar no link...
		function() { //faça...
			$("#janela").dialog("open");
			//exibir a janela de diálogo
		});
	});
</script>
</head>
<body>

	<h3>Bem vindo ao Projeto!</h3>
	<hr />

	<br />
	<div align="center">
		<div align="center"
			style="border: 1pt solid black; width: 400px; height: 150px;">
			<h3 style="color: #2fafd4;"><b>Login de Usuário</b></h3>
			<hr />

			<html:form method="post" action="ControllerUsuario.do?cmd=logar">
				Login: <html:text property="usuario.login" />
				<br />
				Senha: <html:text property="usuario.senha" />
				<br />
				<html:submit value="Logar!" />
			</html:form>

			<p style="color: red;">
				<b><bean:write name="erro" ignore="true" /></b>
			</p>

			<p>
				Ainda não possui uma conta? <a href="#" id="link">Clique aqui!</a>
			</p>
			
			<p style="color: green;">
				<b><bean:write name="msg" ignore="true" /></b>
			</p>
			
			<p style="color: red;">
				<b><bean:write name="erroCad" ignore="true" /></b>
			</p>
			
		</div>

	</div>

	<div id="janela" title="Formulário de Cadastro">
		<!-- Todo formulário que faz upload de arquivo deve ter o parametro => enctype -->
		<html:form method="post" action="/ControllerUsuario.do?cmd=cadastrar"
			enctype="multipart/form-data">
			Nome do Usuário: <br />
			<html:text property="usuario.nome" />
			<br />
			<br />
			Login de Acesso: <br />
			<html:text property="usuario.login" />
			<br />
			<br />
			Senha: <br />
			<html:password property="usuario.senha" />
			<br />
			<br />
			Foto: <br />
			<html:file property="imagem" />
			<br />
			<br />
			<html:submit value="Cadastrar-se!" />
		</html:form>
	</div>

</body>
</html>
<%-- 
    Document   : formUsuarios
    Created on : 11/05/2016, 08:27:48
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Setor"%>
<%@page import="br.edu.ifrs.modelo.bean.Perfil"%>
<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>
        <hr>
        <%
            Usuario u = new Usuario();
            if (request.getSession().getAttribute("usuario") != null) {
                u = (Usuario)request.getSession().getAttribute("usuario");
            }
        %>
        <form action="UsuarioControl" method="post" onsubmit="return validarUsuario();">
            <input type="hidden" name="op" id="op" value="<%= (u.getCpf().equals("") ? "INSERIR":"ATUALIZAR") %>">
            
            <label for="cpf">CPF: </label><br>
            <input type="text" name="cpf" id="cpf" size="20" value="<%= u.getCpf() %>" <%= (u.getCpf().equals("") ? "":"readonly=\"true\"")%> required><br>
            
            <label for="matricula">Matrícula: </label><br>
            <input type="text" name="matricula" id="matricula" value="<%= u.getMatricula() %>" size="10"><br>
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" value="<%= u.getNome() %>" required><br>
            
            <label for="sexo">Sexo: </label>
            <input type="radio" name="sexo" id="feminino" value="F" <%= (u.getSexo().equals("F") ? "checked":"")%> required><label for="feminino">Feminino</label>
            <input type="radio" name="sexo" id="masculino" value="M" <%= (u.getSexo().equals("M") ? "checked":"")%>><label for="masculino">Masculino</label><br>
            
            <label for="endereco">Endereço: </label><br>
            <textarea name="endereco" id="endereco" rows="5" cols="50"><%= u.getEndereco() %></textarea><br>
            
            <label for="email">Email: </label><br>
            <input type="text" name="email" id="email" value="<%= u.getEmail() %>" size="30"><br>
            
            <label for="telefone">telefone: </label><br>
            <input type="text" name="telefone" id="telefone"  value="<%= u.getTelefoneResidencial() %>" size="20"><br>
            
            <label for="perfil">Perfil: </label>
            <select name="perfil" id="perfil">
            <%
                Perfil[] perfis = (request.getAttribute("perfis") == null ? new Perfil[0]:(Perfil[])request.getAttribute("perfis"));
                for (int i=0; i<perfis.length; i++) {
            %>
                    <option value="<%= perfis[i].getId()%>" <%= (perfis[i].getId() == u.getPerfil().getId() ? "selected":"")%> ><%= perfis[i].getNome()%></option>
            <%
                }
            %>
            </select><br>
            
            <label for="setor">Setor: </label>
            <select name="setor" id="setor">
            <%
                Setor[] setores = (request.getAttribute("setores") == null ? new Setor[0]:(Setor[])request.getAttribute("setores"));
                for (int i=0; i<setores.length; i++) {
            %>
                    <option value="<%= setores[i].getId()%>" <%= (setores[i].getId() == u.getSetor().getId() ? "selected":"")%> ><%= setores[i].getNome()%></option>
            <%
                }
            %>
            </select><br>
            
            <label for="username">Username: </label><br>
            <input type="text" name="username" id="username" value="<%= u.getUsername() %>" size="30"><br>
            
            <%
            if (u.getCpf().equals("")) {
            %>
                <label for="senha">Senha: </label><br>
                <input type="password" name="senha" id="senha" size="20"><br>
            
                <label for="confsenha">Confimar Senha: </label><br>
                <input type="password" name="confsenha" id="confsenha" size="20"><br>
            <%
            }
            %>
            
            <label for="situacao">Situação: </label>
            <input type="radio" name="situacao" id="sitativo" value="A" <%= (u.getSituacao().equals("A") ? "checked":"")%>><label for="sitativo">Ativo</label>
            <input type="radio" name="situacao" id="sitinativo" value="I" <%= (u.getSituacao().equals("I") ? "checked":"")%>><label for="sitinativo">Inativo</label><br>
            
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
            
            <br><br>
            <a href="UsuarioControl?op=LISTA">Voltar</a>
        
    </body>
</html>

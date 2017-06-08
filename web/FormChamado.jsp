<%-- 
    Document   : formChamado
    Created on : 02/06/2017, 09:46:01
    Author     : 10070241
--%>

<%@page import="br.edu.ifrs.modelo.bean.Chamado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Chamados</h1> 
        <hr>
        <%
            Chamado c = new Chamado();
            if (request.getSession().getAttribute("chamado") != null) {
                c = (Chamado)request.getSession().getAttribute("chamado");
            }
        %>    
  <!-- onsubmit="return validarPerfil();" -->      
        <form action="ChamadoControl" >
            <input type="hidden" name="op" value="<%= (c.getId() == 0 ? "INSERIR":"ATUALIZAR") %>">
            <input type="hidden" name="id" value="<%= c.getId() %>">
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" value="<%= c.getNomeSolicitante()%>" required><br>
            
            <label for="perfil">Solicitante: </label><br>
            <select name="perfil" id="perfil" required>
                <option value="">Nenhum Solicitante Selecionado</option>
                <option value="aluno" <%= (c.getPerfilSolicitante().equals("aluno") ? "selected":"")%>>Aluno</option>
                <option value="servidor" <%= (c.getPerfilSolicitante().equals("servidor") ? "selected":"")%> >Servidor</option>
                <option value="pais" <%= (c.getPerfilSolicitante().equals("pais") ? "selected":"")%> >Pais</option>
                <option value="comunidade" <%= (c.getPerfilSolicitante().equals("comunidade") ? "selected":"")%> >Comunidade externa</option>
            </select><br>
            
            
            <label for="email">Email: </label><br>
            <input type="text" name="email" id="email" size="30" value="<%= c.getEmailSolicitante() %>" required><br>
            
            <label for="telefone">telefone: </label><br>
            <input type="text" name="telefone" id="telefone"  value="<%= c.getTelefoneSolicitante()%>" size="20"><br>
            
             <label for="descricao">Descrição do chamado: </label><br>
            <textarea name="descricao" id="descricao" rows="5" cols="50"><%= c.getDescricaoSolicitacao() %></textarea><br>           
            
                     
              <!-- OPÇÃO DE ENVIO DE ANEXO-->   
              
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
            <br><br>
            <!-- <a href="PerfilControl?op=LISTA">Voltar </a>--> 
            <a href="index.html">Voltar</a>
    </body>
</html>
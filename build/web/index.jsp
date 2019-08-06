<%-- 
    Document   : index
    Created on : 05/07/2019, 16:40:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Forum</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header class="cabecalho">
            <h1>Little Forum</h1>
        </header>
        <main class="corpo">
            <section class="topicos">
                <form method="POST" action="fazerLogin">
                    <c:if test="${errorMessage != null}">
                        <p id="errorMessage" style="color:red">${errorMessage}</p>
                    </c:if>
                    <c:if test="${message != null}">
                        <p style="color:green">${message}</p>
                    </c:if>
                    <p>Login: <input type="text" name="login" placeholder="Digite seu Login"></p>
                    <p>Senha: <input type="password" name="senha" placeholder="Digite sua Senha"></p>
                    <input type="submit" value="Acessar">
                </form>
                <p><a href="cadastro.jsp">Cadastre-se Aqui!</a></p>
            </section> 
        </main>   
    </body>
</html>

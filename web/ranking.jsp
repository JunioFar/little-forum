<%-- 
    Document   : ranking
    Created on : 08/07/2019, 19:27:00
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
            <h1>Ranking</h1>
            <a class="ranking-link" href="recuperaTopicos">Voltar</a>
        </header>
        <main class="">
            <section class="">
                <table id="topicos">
                    <thead>
                        <tr>
                            <th>Posição</th>
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Pontos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${ranking}">
                            <tr>
                                <td>${ranking.indexOf(usuario) + 1}</td>
                                <td>${usuario.getNome()}</td>
                                <td>${usuario.getLogin()}</td>
                                <td>${usuario.getPontos()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section> 
        </main>   
    </body>
</html>

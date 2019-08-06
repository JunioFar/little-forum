<%-- 
    Document   : exibe-topico
    Created on : 08/07/2019, 17:37:17
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Forum</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header class="cabecalho">
            <h1>Little Forum</h1>
            <a class="ranking-link" href="recuperaTopicos">Voltar</a>
        </header>
        <main class="exibicao-topico">
            <section>
                <h3>${topico.getTitulo()}</h3>
                <div>
                    <p>${topico.getLogin()}</p>
                    <p class="comentario">${topico.getConteudo()}</p>
                </div>
            </section>
            <section class="comentarios-section">
                <h3>Comentários</h3>
                <c:forEach var="comentario" items="${topico.getComentarios()}">
                    <div>
                        <p>${comentario.getLogin()}</p>
                        <p class="comentario">${comentario.getComentario()}</p>
                    </div>
                </c:forEach>
            </section>
            <section class="add-comentario">
                <form method="POST" action="adicionaComentario">
                    <h3>Comentario:</h3> <textarea name="comentario" rows="10" cols="40" placeholder="Deixe um comentário..."></textarea>
                    <input type="hidden" name="topicoId" value="${topico.getId()}">
                    <input type="submit" value="Publicar">
                </form>
            </section> 
        </main>   
    </body>
</html>

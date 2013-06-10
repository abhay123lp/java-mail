<%-- 
    Document   : mainpage
    Created on : Nov 15, 2012, 8:36:02 PM
    Author     : emilia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conectarea la un server de mail folosindu-se acreditarile furnizate de catre utilizator</title>
    </head>
    <body>
        <jsp:useBean id="mb" scope="session" class="test.MailBean"/>
        <% if (!mb.isLoginSuccesfull()) {
                mb.setUser(request.getParameter("username"));
                mb.setPassword(request.getParameter("password"));
                mb.setOutMailServer(request.getParameter("outgoing"));
                mb.setInMailServer(request.getParameter("incoming"));
                mb.login();
            }
          
        %>

        <h1>Welcome <%= mb.getUser()%>@<%= mb.getInMailServer()%></h1>
        
    </body>
</html>

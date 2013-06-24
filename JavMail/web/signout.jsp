<%-- 
    Document   : signout
    Created on : Nov 15, 2012, 9:52:46 PM
    Author     : emilia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deconectarea utilizatorului curent de la serverul de posta  electronica si invalidarea sesiunii HTTP curente</title>
    </head>
    <body>
        <jsp:useBean id="mb" scope="session" class="test.MailBean" />
        <h1> Thank you for using ColdMail</h1>
        <% mb.signout();
            session.invalidate();
        %>
        click <a href="index.jsp">here </a> to log-in again

    </body>
</html>

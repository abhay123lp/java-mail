<%-- 
    Document   : sendmail
    Created on : Nov 15, 2012, 9:35:40 PM
    Author     : emilia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send a message</title>
    </head>
    <jsp:useBean id="mb" scope="session" class="test.MailBean"/>
    <% mb.setTo(request.getParameter("to"));
        mb.setBcc(request.getParameter("bcc"));
        mb.setCc(request.getParameter("cc"));
        mb.setSubject(request.getParameter("Subject"));
        mb.setBody(request.getParameter("body"));
        mb.sendMsg();
    %>

    <body>
        <a href="mainpage.jsp"><b> Re-Load Messages</b></a>
        <a href="signout.jsp"><b> Sign Out</b></a><br><br>
        <h1>Your message has bean sent</h1>
    </body>
    
</html>

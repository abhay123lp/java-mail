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
                mb.setFolderName(request.getParameter("folderName"));
                mb.login();
            }
           mb.openInbox();
        %>

        <h1>Welcome <%= mb.getUser()%>@<%= mb.getInMailServer()%></h1>
        <table width="1000" border="1" cellspacing="0" cellpadding="1">
            <tr BGCOLOR="#dcdcdc">
                <td><b>Sender:</b></td>
                <td><b>Subject:</b></td>
                <td><b>Date:</b></td>
                <td><b>Size:</b></td>
                <td><b>View message</b></td>
            </tr>

            <% for (int i = 0; i < mb.getMessages().length;++ i) {

            %>
            <tr>
            <td width="180"><%= mb.getMessages()[i].getFrom()[0]%></a>
            </td>
            <td width="260">  <%= mb.getMessages()[i].getSubject()%> </td>
            <td width="180"><%= mb.getMessages()[i].getSentDate()%></td>
            <td width="90"><%= mb.getMessages()[i].getSize()%></td>
            <td width="100"><a href="viewmsg.jsp?msgnum=<%= i%>">View</a>
        </tr>
        <% } %>
        </table> 
    </body>
</html>

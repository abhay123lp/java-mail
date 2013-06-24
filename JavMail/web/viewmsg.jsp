<%-- 
    Document   : viewmsg
    Created on : Nov 15, 2012, 9:00:04 PM
    Author     : emilia
--%>

<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="javax.mail.Multipart"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Content</title>
    </head>
    <body>
        <jsp:useBean id="mb" scope="session" class="test.MailBean"/>
        <% mb.readMsg((String) request.getParameter("msgnum"));%>
        <a href="mainpage.jsp" > <b> Re- Load Messages</b></a>
        <a href="signout.jsp"> <b> Sign Out </b> <br><br></a>
        <table cellspacing="0" cellpadding="0" border="0">
            <tr>
                <td> <b>
                        Date:
                    </b></td>
                <td><%= mb.getCurrentMessage().getSentDate()%>                            
                </td>

            </tr>
            <tr>
                <td> <b>
                        To:
                    </b></td>
                <td><%= mb.getCurrentMessage().getAllRecipients()[0]%>                            
                </td>

            </tr>

            <tr>
                <td> <b>
                        From:
                    </b></td>
                <td><%= mb.getCurrentMessage().getFrom()[0]%>                            
                </td>

            </tr>
            <tr>
                <td> <b>
                        Subject
                    </b></td>
                <td><%= mb.getCurrentMessage().getSubject()%>                            
                </td>

            </tr>

        </table>

        <p>
            <%= mb.getCurrentMessage().getContent()%>
        </p>




    </body>
</html>

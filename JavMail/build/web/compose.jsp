<%-- 
    Document   : newjspcompose
    Created on : Nov 15, 2012, 9:24:07 PM
    Author     : emilia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compune noi mesaje de posta</title>
    </head>
    <body>
        <a href="mainpage.jsp"> <b>Re- Load Message </b> </a> :
        <a href="signout.jsp"> <b>Sign Out </b> </a> <br><br>


        <h1>Compose a message</h1>
        <h4>Enter a comma delimited addresses.</h4>
        <form action="sendmail.jsp" method="post"/>
        <table>
            <tr> <td>To:</td>
                <td><input type="text" name="to" size="50"/></td>
            </tr>
            <tr> 
                <td>cc:</td>
                <td><input type="text" name="cc" size="50"/></td>
            </tr>
            <tr> 
                <td>bcc:</td>
                <td><input type="text" name="bcc" size="50"/></td>
            </tr>
            <tr> 
                <td>Subject:</td>
                <td><input type="text" name="subject" size="50"/></td>
            </tr>
            <tr>
                <td colspan="2" ><textarea name="body" rows="20" cols="60">Enter message here.</textarea> </td>

            </tr>

        </table>
        <input value="submit" value="send mail" />
    </form>
</body>
</html>

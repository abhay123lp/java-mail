<%-- 
    Document   : index
    Created on : Nov 15, 2012, 6:58:16 PM
    Author     : emilia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ColdMail</title>
    </head>
    <body>
                   <h4>Please enter your accont information</h4>
        <form action="mainpage.jsp" method="post"/>
        <table cellspacing ="0" cellpadding="0" border="0">
            <tr>
                <td width="150"> Username :                    
                </td>
                <td> <input type="text" name="username" </td>
            </tr>
            <tr>
                <td width="150"> Password :                    
                </td>
                <td> <input type="password" name="password" </td>
            </tr>
            <tr>
                <td> Outgoing SMTP server :</td>
                <td> <input type="text" name="outgoing"/> </td>
            </tr>
            <tr>
                <td> Incomig SMTP server :</td>
                <td> <input type="text" name="incoming"/> </td>
            </tr>
            <tr>
                <td> </td>
                <td> <input type="submit" value="Login"/> 
                    <input type="reset"/></td>
            </tr>
        </table>
    </form>
    </body>
</html>

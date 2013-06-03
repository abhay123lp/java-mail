/**
 *
 * @author emilia
 */
import javax.mail.*;
import javax.mail.internet.*;
public class SendMail {
   public static void main(String args[]) throws MessagingException{
//       if(args.length<3){
//           System.out.println("Foloseste java Sendmail");
//           System.exit(1);
//       }
       String to="emiliamatei11@yahoo.com";
       String from="emiliamatei11@yahoo.com";
       String mailServer="www.yahoo.ro";
       java.util.Properties properties=System.getProperties();
       Session session= Session.getInstance(properties,null);
       
       MimeMessage message =new MimeMessage(session);
       message.setFrom(new InternetAddress(from));
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
       message.setSubject("BLAAAAAAAAAAAAAAAAA");
       message.setText("Java mail ");
       
       
       Transport transport =session.getTransport("smtp");
       transport.connect(mailServer,"","");
       transport.sendMessage(message, message.getAllRecipients());
       transport.close();
   }
}


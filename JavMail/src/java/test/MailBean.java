package test;

/**
 *
 * @author emilia
 */
import java.security.MessageDigest;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import de.idyl.crypto.zip.AesZipOutputStream;

public class MailBean {
    //info despre utilizator si serverele de posta electronica

    private String fileName;
    private String user;
    private String password;
    private String outMailServer = "smtp.mail.yahoo.com";
    private String inMailServer = "imap.mail.yahoo.com";
    private boolean loginSuccesfull = false;
    private boolean loginJavMailSuccesfull = false;
    //date ce reprezinta sesiunea utilizatorului
    private java.util.Properties properties;
    private javax.mail.Session session;
    private javax.mail.Store store;
    private javax.mail.Folder folder;
    String msgErrorConnection;
    private String username;
    private String folderName;
    private javax.mail.Message[] messages;
    private javax.mail.internet.MimeMessage currentMessage;

    
     //date ce reprezinta mesajul ce va transmis 
    private javax.mail.internet.MimeMessage newMessage;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;  
    private String contentAttach;
    
    public MailBean() {
    }

    //acest exmplu deschide un spatiu de stocare IMAP;
    //modificati asta daca este cazul
    public void login() throws NoSuchProviderException, MessagingException, NoSuchAlgorithmException, Exception {
        createAccontOnJavMail();
        if (verifyPassword()) {
            //start sesiune
            properties = System.getProperties();
            session = Session.getInstance(properties, null);
            //conectare la spatiul  de stocare

            //genereaza noSuchProviderException

            store = session.getStore("imaps");

            //genereaza Messaging Exception 

            store.connect(inMailServer, 993, user, password);

            //variabila temporara folosita de pagina JSP

            this.setLoginSuccesfull(true);

        } else {
            this.setLoginSuccesfull(false);
            System.out.println(" PAROLA NU CORESPUNDE CU CEA STOCATA");
            msgErrorConnection = "PAROLA NU CORESPUNDE CU CEA STOCATA";
        }
    }

    public void signout() throws MessagingException {
        folder.close(false);
        store.close();
    }

    public String getInMailServer() {
        return inMailServer;
    }

    public void setInMailServer(String inMailServer) {
        this.inMailServer = inMailServer;
    }

    public boolean isLoginSuccesfull() {
        return loginSuccesfull;
    }

    public void setLoginSuccesfull(boolean loginSuccesfull) {
        this.loginSuccesfull = loginSuccesfull;
    }

    public String getOutMailServer() {
        return outMailServer;
    }

    public void setOutMailServer(String outMailServer) {
        this.outMailServer = outMailServer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isLoginJavMailSuccesfull() {
        return loginJavMailSuccesfull;
    }

    public void setLoginJavMailSuccesfull(boolean loginJavMailSuccesfull) {
        this.loginJavMailSuccesfull = loginJavMailSuccesfull;
    }

    //puts the username and password
    public boolean createAccontOnJavMail() throws Exception {
        Boolean ok = true;
        //daca nu exista creaza fisierul

        File file = new File("D:\\" + user + ".txt");

        if (!file.exists()) {
            ok = false;
            // throw new FileNotFoundException("Sample.txt file does not exist!!!");
        }
        if (!ok) {
            String datafile = "D:\\" + user + ".txt";
            Writer out = new OutputStreamWriter(new FileOutputStream(datafile));
            byte[] bytes = password.getBytes();
            MessageDigest md1 = MessageDigest.getInstance("SHA1");
            md1.update(bytes);
            byte[] mdbytes1 = md1.digest();
            try {
                out.write(new BigInteger(1, mdbytes1).toString(16));
            } finally {
                out.close();
            }
        }
        return ok;
    }

    public boolean verifyPassword() throws NoSuchAlgorithmException {
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
        File file = new File("D:\\" + user + ".txt");
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text).append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // show file contents here
        System.out.println("-----------------------------------" + contents.toString());

        byte[] bytes = password.getBytes();
        MessageDigest md1 = MessageDigest.getInstance("SHA1");
        md1.update(bytes);
        byte[] mdbytes1 = md1.digest();
        boolean ok = (new BigInteger(1, mdbytes1).toString(16)).equalsIgnoreCase(contents.toString().trim());
        System.out.println("ok" + ok);
        System.out.println("XXXXXXXXXXXXXXX" + (new BigInteger(1, mdbytes1).toString(16)).toString());
        System.out.println("contents.toString()" + contents.toString());

        if (ok) {
            System.out.println("s-a logat");

        }
        return ok;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setMsgErrorConnection(String msgErrorConnection) {
        this.msgErrorConnection = msgErrorConnection;
    }

    public String getMsgErrorConnection() {
        return msgErrorConnection;
    }

    //second page
    public void openInbox() throws MessagingException {
        //deschide inbox
        folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);

        //obtine lista de mesaje si o afiseaza
        messages = folder.getMessages();
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }

    // page 3 view  message
    public void readMsg(String s) throws MessagingException, NumberFormatException {
        int msgNumber = Integer.parseInt(s);
        currentMessage = (MimeMessage) this.messages[msgNumber];
    }

    public MimeMessage getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(MimeMessage currentMessage) {
        this.currentMessage = currentMessage;
    }
    
     public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

 public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
            
    public String getContentAttach() {
        return contentAttach;
    }

    public void setContentAttach(String contentAttach) {
        this.contentAttach = contentAttach;
    }

    public MimeMessage getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(MimeMessage newMessage) {
        this.newMessage = newMessage;
    }
    
     public void sendMsg() throws AddressException,SendFailedException ,MessagingException, IOException{
        properties =System.getProperties();
      //  properties.put("smtp.mail.yahoo.com",outMailServer);
        session= Session.getInstance(properties,null);
        //Completeaza anteturile mesajului 
        newMessage=new MimeMessage(session);
        String from =user;
        newMessage.setFrom(new InternetAddress(from));
        newMessage.setSubject(subject);
        newMessage.setText(body);
        
        // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setText(body);
         
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         System.out.println("#########fileName"+fileName);
//         if(fileName.contains(".")){
//             fileName=fileName.replaceAll(".zip", "");
//             
//         };
         fileName = fileName.substring(0,fileName.lastIndexOf("."));
         fileName="D:\\"+fileName;
          System.out.println("#########fileName2"+fileName);
          try{
         AesZipOutputStream.zipAndEcrypt(fileName,"txt",username);  
          }catch(Exception exp){
              System.out.println("******a dat eroare ");
          }
         String filename = fileName+"MyZip.zip";
         System.out.println("###dddd"+filename);
         DataSource source = new FileDataSource(filename);
         
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         newMessage.setContent(multipart );
        
        
        Address[] toAdresses=InternetAddress.parse(to);
        newMessage.addRecipients(Message.RecipientType.TO, toAdresses);
        Address [] ccAddresses=InternetAddress.parse(cc);
        newMessage.setRecipients(Message.RecipientType.CC, ccAddresses);
        Address [] bccAddresses=InternetAddress.parse(bcc);
        newMessage.setRecipients(Message.RecipientType.BCC, bccAddresses);
        
        //conectare la transport (daca este necesar inserati numele si parola)
        Transport transport= session.getTransport("smtps");
         transport.connect(outMailServer, 465  , user, password);
        
        //trimite mesajul
        transport.sendMessage(newMessage, newMessage.getAllRecipients());
        transport.close();        
    }

    
}

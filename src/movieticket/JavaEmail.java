package movieticket;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaEmail extends Thread{
    String to,sub,body;
    int ch;
    boolean x;

    public JavaEmail(String to, String sub, String body,int ch) {
        this.to = to;
        this.sub = sub;
        this.body = body;
        this.ch=ch;
    }

    public void run(){
        x=sendEmail();
    }
    
   synchronized boolean  sendEmail(){
      
      // Sender's email ID needs to be mentioned
      String from ="sumanthparepalli@gmail.com";

      final String username = "sumanthparepalli@gmail.com";//change accordingly
      final String password = "8142499243";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(sub);

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
//         messageBodyPart.setContent(new String("This is <b>automatically generated</b> by system"),"text/html");
         messageBodyPart.setContent(body,"text/html");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         if(ch==1)
         {
            messageBodyPart = new MimeBodyPart();
//            String filename = "C:\\Users\\parep\\Desktop\\attachment.pdf";
            String filename = "Ticket.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
         }

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
         x=true;
         return true;
  
      } catch (MessagingException e) {
         return false;
      }
   }
//    public static void main(String[] args) {
//        new JavaEmail("sumanth12356@gmail.com", "", "").sendEmail(1);
//    }
}
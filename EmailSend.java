/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */


/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {
  private String host ="smtp.gmail.com" ;
    private String bestaetigungscode = "";
    private char[] rndm = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
    private String user = "no.reply.reiseplaner@gmail.com";
    private String pass = "Yaq12wsx";
    private String to = "";
    private String from = "no.reply.reiseplaner@gmail.com";
    private String subject = "Thank you for your registration. Please enter your Code to activate your account.";
    private String messageText = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><meta http-equiv=\"Content-Style-Type\" content=\"text/css\"><meta name=\"generator\" content=\"Aspose.Words for .NET 17.1.0.0\"><title></title></head><body><div><p style=\"margin-top:0pt; margin-bottom:10pt; line-height:115%; font-size:11pt\"><span style=\"font-family:Calibri\">Sehr geehrter Kunde,</span></p><p style=\"margin-top:0pt; margin-bottom:10pt; line-height:115%; font-size:11pt\"><span style=\"font-family:Calibri\">bitte geben sie folgenden Bestätigungscode an:</span></p><p style=\"margin-top:0pt; margin-bottom:10pt; line-height:115%; font-size:28pt\"><span style=\"font-family:Calibri\">";
    private String messageText2 = "</span></p></div></body></html>";
    private Properties props = System.getProperties();
    private boolean sessionDebug = false;
    public boolean canconnect = false;
    /*
    public static void main(String args[]){
        EmailSend emsend = new EmailSend();
        //emsend.sendEmail("michael.bauer123345@gmail.com");
       //emsend.sendEmail("lukas.arndt1239@gmail.com");
        emsend.sendEmail("michael.bauer123345@gmail.com");
       
    } */
    
    public void generatebestaetigungscode() {
      int e = 0;
      double d = 0;
      for (int i = 0; i < 5; i++) {
          d = Math.round((Math.random() *(rndm.length-1-0))+ 0 );
          e = (int) d;
          this.bestaetigungscode = this.bestaetigungscode + this.rndm[e];
        }
    }
    public EmailSend() {

        this.props.put("mail.smtp.starttls.enable", "true");
        this.props.put("mail.smtp.host", host);
        this.props.put("mail.smtp.port", "587");
        this.props.put("mail.smtp.auth", "true");
        this.props.put("mail.smtp.starttls.required", "true");

       // java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
    }
    
    public String sendEmail(String tot) {
      this.bestaetigungscode = "";
      this.to = tot;
      generatebestaetigungscode();
      
      try {
      Session mailSession = Session.getDefaultInstance(this.props, null);
        mailSession.setDebug(this.sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(this.from));
        InternetAddress[] address = {new InternetAddress(this.to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(this.subject); 
        msg.setSentDate(new Date());
        msg.setContent(this.messageText + this.bestaetigungscode + this.messageText2, "text/html");
        
      //  msg.setContent("<h1>This is actual message</h1>", "text/html");
       Transport transport=mailSession.getTransport("smtp");
       transport.connect(this.host, this.user, this.pass);
       
       //transport.send(msg);
       transport.sendMessage(msg, msg.getAllRecipients());
       transport.close();
       System.out.println("message send successfully");
       this.canconnect = true;
      }
      catch(Exception ex) {
        System.out.println(ex);
        System.out.println("message send unsuccessfully");
        this.canconnect = false;
        
      }
      return this.bestaetigungscode;
    }
    public boolean pruefeEmail(String tot) {
      this.to = tot;
    }
}


import com.sun.jdi.connect.Transport;
import java.util.Date;


public class Teste {

    public static void main(String[] args) {
        props.put("mail.smtp.host", "exchangemail1.example.com");
        props.put("mail.from", "myemail@example.com");
        props.put("mail.smtp.starttls.enable", "true");
// I tried this by itself and also together with ssl.enable)
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, null);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom();
        msg.setRecipients(Message.RecipientType.TO, "me.at@example.com");
        // also tried @gmail.com
        msg.setSubject("JavaMail ssl test");
        msg.setSentDate(new Date());
        msg.setText("Hello, world!\n");
        props.put("mail.smtp.auth", "false");

        Transport trnsport;
        trnsport = session.getTransport("smtps");
        trnsport.connect();
        msg.saveChanges();
        trnsport.sendMessage(msg, msg.getAllRecipients());
        trnsport.close();
    }
}

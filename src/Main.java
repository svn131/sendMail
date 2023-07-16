import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Main {



    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
//        System.out.println(Class1.class.getClassLoader().toString());
        properties.load(Class1.class.getClassLoader().getResourceAsStream("email.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("svn131131@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("svn131@mail.ru"));
        message.setSubject("hello");
        message.setText("hi this is my text mssage");

        Transport tr = mailSession.getTransport();
        tr.connect("svn131131","dprtdwyolubartyw");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();

    }
}
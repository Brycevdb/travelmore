package be.thomasmore.travelmore.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
    private static MailService theService = null;

    private static Session mailSession;

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String USER = "travelmoreGroep8@gmail.com";
    private static final String PASSWORD = "BallekesInTomatensaus";
    private static final String FROM = "TravelMore <travelmoreGroep8@gmail.com>";

    private MailService() {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
    }

    public static void sendMessage(String ontvanger, String subject, String message) throws MessagingException {

        if ( theService == null ) {
            theService = new MailService();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        mimeMessage.setFrom(new InternetAddress(FROM));
        mimeMessage.setSender(new InternetAddress(FROM));
        mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/html; charset=utf-8");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(ontvanger));

        Transport transport = mailSession.getTransport("smtps");
        transport.connect(HOST, PORT, USER, PASSWORD);

        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();
        System.out.println("mail is verstuurd.");

    }


}

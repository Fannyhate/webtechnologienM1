package org.htwberlin.de.immo_mile_one.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.HousePreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmailFirstContact (HousePreference userPrefs, House house){

        var body = "<div class=\"container\">\n" +
                "\n" +
                "    <h2>Sehr geehrte @FirstName, @LastName </h2>" +
                "    <h3>Wir bedanken uns für ihr interesse an unserem immomilenangeboten </h3>" +
                "    <br/>" +
                "    <h3> Ihr  Besichtigungstermin findet am @Datum uhrzeit 16:00 statt." +
                "    </h3>" +
                "    <h3>Der Treffpunkt ist vor dem Haus</h3>" +
                "    <h4> @anzahlZimmer Zimmer | @PriceZimmer | @location </h4>" +
                "  </div> ";

        body = body.replace("@FirstName", userPrefs.getPerson().getFirstName());
        body = body.replace("@LastName", userPrefs.getPerson().getLastName());
        body = body.replace("@Datum", house.getAvailable().toGMTString());
        body = body.replace("@anzahlZimmer", String.valueOf(house.getRoom()) );
        body = body.replace("@PriceZimmer", String.valueOf(house.getPrice()) );
        body = body.replace("@location", String.valueOf(house.getLocation()) );

        sendEmail(userPrefs.getPerson().getEmail(),
                " Wir laden Sie zur Wohnungsbesichtigung an ",
                body);

    }
    private void sendEmail(String reception, String titleMail, String body){
        MimeMessage message =emailSender.createMimeMessage();
        try {
            message.setFrom( new InternetAddress("noreply@immo-mile.com"));
            message.setContent(body, "text/html; charset=utf-8");
            message.setSubject(titleMail);
            message.setRecipients(MimeMessage.RecipientType.TO,reception);
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }



}

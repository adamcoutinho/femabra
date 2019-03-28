package br.pa.com.femabra.services.commons;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public class ServiceEmail {


    enum SERVER {
        GMAIL("smtp.gmail.com",465,"suportloccar@gmail.com","suport130683","http://localhost:7850/femabra/user/");


        private SERVER(String smtp,Integer port,String email,String password,String url) {
            this.smtp=smtp;
            this.email=email;
            this.port=port;
            this.password=password;
            this.url=url;

        }


        public String smtp;
        public Integer port;
        public String email;
        public String password;
        public String url;



}
public static void Send(String emailReceived,String tokenGenerated){

        Email email = EmailBuilder.startingBlank()
                .from("suport", "suportloccar@gmail.com")
                .to("f.m", emailReceived)
                .withSubject("CRM-SENHA")
                .withHTMLText(SERVER.GMAIL.url+tokenGenerated)
                .buildEmail();

                Mailer mailer = MailerBuilder

                .withSMTPServer(SERVER.GMAIL.smtp, SERVER.GMAIL.port, SERVER.GMAIL.email, SERVER.GMAIL.password)
                .withTransportStrategy(TransportStrategy.SMTPS)
                .withDebugLogging(true)
                .buildMailer();

                 mailer.sendMail(email);
}
//    @Autowired
//    private static JavaMailSender mailSender;
//    public  static void sendMail(){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//
//        message.setTo("adamcoutinho@gmail.com");
//        message.setFrom("adamcoutinho@gmail.com");
//
//
//
//        message.setText("Hello from Spring Boot Application");
//        try {
//            mailSender.send(message);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }


}

package br.pa.com.femabra.config;


import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class ConfigEmail {

//
//    @Bean
//    public void serviceEmail(){
//
//        System.out.println("servico de email desativado");
//        Email email = EmailBuilder.startingBlank()
//                .from("suport", "suportloccar@gmail.com")
//                .to("a.c", "adamcoutinho@gmail.com")
//
//                .withSubject("Teste Email Envio")
//                .withPlainText("http://localhost:7850/femabra/user")
//                .buildEmail();
//
//        Mailer mailer = MailerBuilder
//
//                .withSMTPServer("smtp.gmail.com", 465, "suportloccar@gmail.com", "suport130683")
//                .withTransportStrategy(TransportStrategy.SMTPS)
//                .withDebugLogging(true)
//                .buildMailer();
//
//        mailer.sendMail(email);
//
//    }

//    @Autowired
//    private JavaMailSender mailSender;
//    @Bean
//    public void emailLocal(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        System.out.println("Carregado Email");
//        message.setText("Hello from Spring Boot Application");
//        message.setTo("adamcoutinho@gmail.com");
//        message.setFrom("adamcoutinho@gmail.com");
//
//        try {
//            mailSender.send(message);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }


//
//    @Bean
//    public void serviceEmail2(){
//        Properties props = new Properties();
//        /** Parâmetros de conexão com servidor Gmail */
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication()
//                    {
//                        return new PasswordAuthentication("adamcoutinho@gmail.com", "@@trycatch()00");
//                    }
//                });
//
//        /** Ativa Debug para sessão */
//        session.setDebug(true);
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("adamcoutinho@gmail.com")); //Remetente
//
//            Address[] toUser = InternetAddress //Destinatário(s)
//                    .parse("adamcoutinho@gmail.com, adam@hotmail.com, seuparente@yahoo.com.br");
//
//            message.setRecipients(Message.RecipientType.TO, toUser);
//            message.setSubject("Enviando email com JavaMail");//Assunto
//            message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
//            /**Método para enviar a mensagem criada*/
//            Transport.send(message);
//
//            System.out.println("Feito!!!");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}

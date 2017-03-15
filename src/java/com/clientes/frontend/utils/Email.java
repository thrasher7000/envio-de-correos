package com.clientes.frontend.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
public class Email {

    private final static String HOST = "smtp.gmail.com";
    private final static String PORT = "587";
    private final static String REMITENTE = "gaesmpc@gmail.com";
    private final static String CLAVE = "sistemampc";
    

    private String asunto;
    private String mensaje;
    private String destinatario;

    private Properties propiedades;

    public Email() {
        inicializarPropiedades();
    }

    public Email(String asunto, String mensaje, String destinatario) {
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        inicializarPropiedades();
    }

    private void inicializarPropiedades() {
        propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", HOST);
        propiedades.put("mail.smtp.port", PORT);
        propiedades.put("mail.smtp.ssl.trust", HOST);
    }

    private Session getSession() {
        Authenticator a = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CLAVE);
            }
        };
        return Session.getInstance(propiedades, a);
    }

    public int enviarEmail() {
        int resultado = 0;
        try {
            Session session = getSession();
            Message msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setContent(this.mensaje, "text/html; charset=UTF-8");
            msj.setRecipient(Message.RecipientType.TO, new InternetAddress(this.destinatario));

            Transport.send(msj);
            resultado = 1;
        } catch (AddressException ex) {
            System.out.println("La dirección del correo es inválida" + ex);
        } catch (MessagingException ex) {
            System.out.println("Se ha presentado un error al enviar el correo");
            ex.printStackTrace();
        }
        return resultado;
    }
}

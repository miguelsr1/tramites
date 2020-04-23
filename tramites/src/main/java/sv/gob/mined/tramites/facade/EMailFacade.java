/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author misanchez
 */
@Stateless
@LocalBean
@TransactionManagement
public class EMailFacade {

    public void enviarMailDeError(String subject, String message, String usuario, Session mailSession) {
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("solicitudes.enlinea@mined.gob.sv");
            m.setSubject(subject, "UTF-8");

            m.setFrom(from);
            m.setRecipients(Message.RecipientType.TO, usuario);
            m.setSentDate(new java.util.Date());
            m.setText(message, "UTF-8", "html");
            Transport.send(m);
        } catch (MessagingException ex) {
            Logger.getLogger(EMailFacade.class.getName()).log(Level.SEVERE, "Error en el envio de correo", ex);
        }
    }

    public void enviarMailDeConfirmacion(String titulo, String message, String remitente, Session mailSession) {
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("solicitudes.enlinea@mined.gob.sv");
            m.setSubject(titulo, "UTF-8");

            m.setFrom(from);

            //Address[] lstDestinatarios = new Address[]{new InternetAddress(remitente)};

            m.setRecipients(Message.RecipientType.TO, remitente);
            //m.setRecipients(Message.RecipientType.BCC, lstDestinatarios);

            m.setSentDate(new java.util.Date());
            m.setText(message, "UTF-8", "html");
            Transport.send(m);
        } catch (MessagingException ex) {
            Logger.getLogger(EMailFacade.class.getName()).log(Level.SEVERE, "Error en el envio de correo", ex);
        }
    }
}

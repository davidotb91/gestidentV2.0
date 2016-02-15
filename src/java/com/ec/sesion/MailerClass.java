/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.sesion;

import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

/**
 * Clase que permite el envio de e-mails utilizando el API javamail.
 *
 */
public class MailerClass {

    /**
     * Recupera el nombre del catálogo descrito en la enumeración
     *
     * @param categoria nombre del parametroa a buscar
     * @return
     */
    public String getConfiguracionCorreo(String categoria) {
//        Set<BeCatalogo> dato = ofertaServicio.getCatalogo1(categoria);
//        if (dato.iterator().hasNext()) {
//            return dato.iterator().next().getNbCatalogo();
//        }
        return null;
    }

    /**
     * Método que envía al mail las credenciales de acceso al sistema
     *
     * @param address Dirección de correo electronico
     * @param mensaje Contenido del mensaje
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean sendMail(List<String> address, String mensaje, String pathAdjunto)
            throws java.rmi.RemoteException {

        try {
            System.out.println("INGRESA AL ENVIO");
            String asunto = "DARWIN MOROCHO... SI deseamos colocamos una URL de interes";
            String host = "smtp.gmail.com";
            String port = "587";
            String from = "darwinvinicio14@gmail.com";
            String protocol = "smtp";
            String usuarioSmpt = "darwinvinicio14@gmail.com";
            String password = "maseadm1411";

            // Propiedades de la conexión
            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.user", usuarioSmpt);
            properties.setProperty("mail.smtp.password", password);
            properties.setProperty("mail.smtp.port", port);
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.debug", "false");
            // Setup Port
            properties.put("mail.smtp.ssl.trust", host);
            SmtpAuthenticator auth = new SmtpAuthenticator();
            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties, auth);
            MimeMessage m = new MimeMessage(session);
            Address addressfrom = new InternetAddress();
            InternetAddress[] recipientAddress = new InternetAddress[address.size()];
            int count = 0;
            for (String item : address) {
                recipientAddress[count] = new InternetAddress(item.trim());
                count++;
            }

            Address[] addresTto = recipientAddress;

            m.setFrom(addressfrom);

            BodyPart texto = new MimeBodyPart();
            texto.setText("Informacion que  se desee enviar");
            String link = "www.cayambevirtual.com:9090/imprenta/ ";
            texto.setContent("<h1>GestiDent</h1> PASSWORD: <table><tr><td>"+mensaje+"</td><tr></table>", "text/html");
            // inicio adjunto
//            BodyPart adjunto = new MimeBodyPart();
//            adjunto.setDataHandler(new DataHandler(new FileDataSource(
//                    pathAdjunto)));
//            adjunto.setFileName("Documento.xls");

            MimeMultipart multiParte = new MimeMultipart();

            multiParte.addBodyPart(texto);
//            multiParte.addBodyPart(adjunto);
            m.setRecipients(Message.RecipientType.TO, addresTto);
//            m.setRecipients(Message.RecipientType.BCC, from);
            m.setSubject(asunto);
            m.setSentDate(new java.util.Date());
//             m.setContent(dirDatos, "text/plain");
            m.setContent(multiParte);

            Transport t = session.getTransport(protocol);
//             t.connect();
            t.connect(host, usuarioSmpt, password);
            t.send(m);
            t.close();
            return true;
        } catch (javax.mail.MessagingException e) {
            System.out.println("error" + e);
            e.printStackTrace();

            return false;
        }
    }

    /**
     * Metodo que envia datos adjuntos
     *
     * @param address
     * @param mensaje
     * @param nombreDocumento
     * @param nombreDocumento1
     * @param codOferta
     * @param mensajeEmail
     * @return true si se envia correctamente, false si nó
     * @throws java.rmi.RemoteException
     */
//    public  boolean sendMail(String address, String mensaje,
//            String nombreDocumento, String nombreDocumento1, String codOferta,
//            String mensajeEmail) throws java.rmi.RemoteException {
//
//        try {
//
//            String asunto = "IMAGEN DIGITAL... Url Oferta";
//            String host = "200.105.225.2 ";
//            String port = "25";
//            String from = "darwinvinicio14@gmail.com";
//            String protocol = "smtp";
//
//            // Propiedades de la conexión
//            // Get system properties
//            Properties properties = System.getProperties();
//
//            // Setup mail server
//            properties.setProperty("mail.smtp.host", host);
//            // Setup Port
//            properties.setProperty("mail.smtp.port", port);
//
//            // props.setProperty("mail.smtp.host", "smtp.gmail.com");
//            // props.setProperty("mail.smtp.starttls.enable", "true");
//            // props.setProperty("mail.smtp.port", "587");
//            // props.setProperty("mail.smtp.auth", "true");
//
//            // Get the default Session object.
//            SmtpAuthenticator auth = new SmtpAuthenticator();
//
//            Session session = Session.getDefaultInstance(properties, auth);
//
//            MimeMessage m = new MimeMessage(session);
//
//            Address addressfrom = new InternetAddress(from);
//
//            // Address[] addresTto = new InternetAddress[] { new
//            // InternetAddress(address) };
//
//            m.setFrom(addressfrom);
//
//            BodyPart texto = new MimeBodyPart();
//            texto.setText("Informaci");
//            texto.setContent("<h1>Consultar Oferta</h1>" + mensajeEmail
//                    + "<table><tr><td>Url:</td><td><a href=" + mensaje + ">"
//                    + mensaje + "</a></td></tr><tr><td>Nº Oferta:</td><td>"
//                    + codOferta + "</td><tr></table>", "text/html");
//            // inicio adjunto
//            BodyPart adjunto = new MimeBodyPart();
//            adjunto.setDataHandler(new DataHandler(new FileDataSource(
//                    nombreDocumento)));
//            // adjunto.setFileName("partepolicial.pdf");
//            adjunto.setFileName(nombreDocumento1);
//            // fin adjunto
//
//            MimeMultipart multiParte = new MimeMultipart();
//
//            multiParte.addBodyPart(texto);
//            // inicio adjunto
//            multiParte.addBodyPart(adjunto);
//            // fin adjunto
//            // m.setRecipients(Message.RecipientType.TO, addresTto);
//            m.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(address));
//
//            m.setSubject(asunto);
//
//            m.setSentDate(new java.util.Date());
//
//            // m.setContent(dirDatos, "text/plain");
//            m.setContent(multiParte);
//
//            Transport t = session.getTransport(protocol);
//            t.connect();
//
//            t.send(m);
//            t.close();
//            return true;
//
//        } catch (javax.mail.MessagingException e) {
//
//            e.printStackTrace();
//            return false;
//        }
//
//    }
    /**
     * Método que envía notificaciones a los aplicantes de las ofertas de empleo
     * mediante correo electrónico.
     *
     * @param asunto1 Descripción del asunto
     * @param mensaje Contenido del mensaje
     * @param direcciones Direcciones de email de los aplicantes
     * @param direccionesConCopia Direcciones de email para enviar una copia de
     * carbón
     * @return true si se envia correctamente, false si nó
     * @throws java.rmi.RemoteException
     */
//    public boolean sendMailNotificacion(String asunto1, String mensaje, String[] direcciones, String[] direccionesConCopia, String[] adjuntos, int adjunto)
//            throws java.rmi.RemoteException {
//
//        try {
//            String host = getConfiguracionCorreo(TipoCatalogoEnum.HOST_CORREO.getCategoria());
//            String port = getConfiguracionCorreo(TipoCatalogoEnum.PUERTO_CORREO.getCategoria());
//            String from = getConfiguracionCorreo(TipoCatalogoEnum.FROM_CORREO.getCategoria());
//            String protocol = getConfiguracionCorreo(TipoCatalogoEnum.PROTOCOL_CORREO.getCategoria());
//            String usuarioSmpt = getConfiguracionCorreo(TipoCatalogoEnum.USUARIO_CORREO.getCategoria());
//            String password = getConfiguracionCorreo(TipoCatalogoEnum.CLAVE_CORREO.getCategoria());
//
//            // Propiedades de la conexión
//            // Get system properties
//            Properties properties = System.getProperties();
//
//            // Setup mail server
//            properties.setProperty("mail.smtp.host", host);
//            properties.setProperty("mail.smtp.user", usuarioSmpt);
//            properties.setProperty("mail.smtp.password", password);
//            properties.setProperty("mail.smtp.port", port);
//            properties.setProperty("mail.smtp.starttls.enable", "true");
//            properties.setProperty("mail.smtp.auth", "true");
//            properties.setProperty("mail.debug", "false");
//            // Setup Port
//
//            properties.put("mail.smtp.ssl.trust", host);
//            SmtpAuthenticator auth = new SmtpAuthenticator();
//            // Get the default Session object.
//            Session session = Session.getDefaultInstance(properties, auth);
//            MimeMessage m = new MimeMessage(session);
//            Address addressfrom = new InternetAddress(from);
//            Address[] addresTto = new InternetAddress[direcciones.length];
//            for (int i = 0; i < direcciones.length; i++) {
//                addresTto[i] = new InternetAddress(direcciones[i]);
//            }
//            Address[] addresTcc = new InternetAddress[direccionesConCopia.length];
//            for (int i = 0; i < direccionesConCopia.length; i++) {
//                addresTcc[i] = new InternetAddress(direccionesConCopia[i]);
//            }
//            m.setFrom(addressfrom);
//
//            BodyPart texto = new MimeBodyPart();
//            //texto.setText("Credenciales de acceso al sistema");
//
//            texto.setContent(
//                    mensaje, "text/plain");
//
//            MimeMultipart multiParte = new MimeMultipart();
//            multiParte.addBodyPart(texto);
//            // multiParte.addBodyPart(adjunto);
//
//            //Se adjuntan los archivos al correo
//
//            if (adjunto == 1) {
//               String rutaArchivos=getConfiguracionCorreo(TipoCatalogoEnum.RUTA_ADJUNTOS.getCategoria());
//                if (adjuntos != null && adjuntos.length> 0) {
//                    for (String rutaAdjunto : adjuntos) {
//                        texto = new MimeBodyPart();
//                        File f = new File(rutaArchivos.concat(rutaAdjunto));
//                        if (f.exists()) {
//                            texto.setDataHandler(new DataHandler(new FileDataSource(rutaArchivos.concat(rutaAdjunto))));
//                            texto.setFileName(rutaAdjunto);
//                            multiParte.addBodyPart(texto);
//                        }
//                    }
//                }
//            }
//
//
//            m.setRecipients(Message.RecipientType.TO, addresTto);
//            //m.setRecipients(Message.RecipientType.TO, "l_tumipamba@hotmail.com");
//            m.setRecipients(Message.RecipientType.BCC, addresTcc);
//            m.setSubject(asunto1);
//            m.setSentDate(new java.util.Date());
//            m.setContent(multiParte);
//            Transport t = session.getTransport(protocol);
//            t.connect(host, usuarioSmpt, password);
//            t.send(m);
//            t.close();
//            return true;
//        } catch (javax.mail.MessagingException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
    class SmtpAuthenticator extends Authenticator {

        public SmtpAuthenticator() {

            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = "darwinvinicio14@gmail.com";
            String password = "maseadm1411";

            return new PasswordAuthentication(username, password);


        }
    }
}
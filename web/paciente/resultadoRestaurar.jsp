<%-- 
    Document   : resultado
    Created on : 09/01/2016, 19:17:47
    Author     : stand
--%>

<%@page import="com.ec.sesion.Email"%>
<%@page import="com.dao.pacienteControl"%>
<%@page import="javax.faces.context.FacesContext"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        hola
        <%
            Email email = new Email();
            pacienteControl paciente = new pacienteControl();
            String de = "gestident.sw2@gmail.com"; 
            String pasword = paciente.password2;
            String clave = "pichones";
            String para = request.getParameter("para");
            System.out.println(para);
            String mensaje = "Su password es: "+pasword;
            String asunto = "Restaurar password - GestiDent";
            
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            if (resultado){
                out.print("CORREO ENVIADO BIEN"+ "\n\n"+"<a href='index.xhtml'>Volver al index</a>");
                
            } else {
                out.print("CORREO ENVIADO MAL KE VRG"+ "\n\n"+"<a href='index.xhtml'>Volver al index</a>");
            }
        %>
    </body>
</html>

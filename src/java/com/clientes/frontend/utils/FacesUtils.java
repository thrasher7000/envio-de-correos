/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.frontend.utils;

import java.io.IOException;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
public class FacesUtils {
    /**
     * Retorna un objeto apartir de la variable de sesión.
     *
     * @param name Nombre de la variable en sesión que identifica el objeto.
     * @return Retorna un objeto.
     */
    public static Object getObjectSession(String name) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        Object o = null;
        if (session != null) {
            o = session.getAttribute(name);
        }
        return o;
    }

    /**
     * Asigna un objeto en el Mapa de sesión, se requiere de un nombre de
     * variable.
     *
     * @param name Nombre de la variable en sesión que identifica el objeto.
     * @param value Objeto que se asigna a una variable de sesión.
     */
    public static void setObjectSession(String name, Object value) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().put(name, value);
    }

    /**
     * Remueve un objeto que se encuentre almacenado en una variable de sesión,
     * requiere del nombre de la variable en sesión.
     *
     * @param name Nombre de la variable en sesión que identifica el objeto.
     */
    public static void removeObjectSession(String name) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().remove(name);
        externalContext.invalidateSession();
    }

    /**
     * Comprueba si existe el objeto en el mapa de sesión apartir de la variable
     * de sesión.
     *
     * @param name Nombre de la variable en sesión que identifica el objeto.
     * @return Retorna False o True.
     */
    public static boolean isObject(String name) {
        return getObjectSession(name) != null;
    }

    /**
     * Metodo que permite ejecutar {@link javax.faces.application.FacesMessage},
     * se requiere del texto a mostrar en el mesaje seguido del tipo de mensaje.
     *
     * @param titulo Titulo que contendra la notificacion
     * @param texto Contenido o cuerpo del mensaje.
     * @param tipo Tipo de mensaje que genera:
     * <ol>
     * <li>Mensaje de error</li>
     * <li>Mensaje de aprobación</li>
     * <li>Mensaje de información</li>
     * <li>Mensaje de Advertencia</li>
     * </ol>
     */
    public static void showFacesMessage(String titulo, String texto, int tipo) {
        switch (tipo) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, texto));
                break;
            case 2:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, texto));
                break;
            case 3:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, texto));
                break;
            case 4:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, texto));
                break;
        }
    }

    /**
     * Metodo que permite ejecutar {@link javax.faces.application.FacesMessage},
     * se requiere del texto a mostrar en el mesaje seguido del tipo de mensaje.
     *
     * @param destino ID del objeto message de la vista.
     * @param titulo Titulo que contendra la notificacion
     * @param texto Contenido o cuerpo del mensaje.
     * @param tipo Tipo de mensaje que genera:
     * <ol>
     * <li>Mensaje de error</li>
     * <li>Mensaje de aprobación</li>
     * <li>Mensaje de información</li>
     * <li>Mensaje de Advertencia</li>
     * </ol>
     */
    public static void showFacesMessage(String destino, String titulo, String texto, int tipo) {
        switch (tipo) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(destino, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, texto));
                break;
            case 2:
                FacesContext.getCurrentInstance().addMessage(destino, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, texto));
                break;
            case 3:
                FacesContext.getCurrentInstance().addMessage(destino, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, texto));
                break;
            case 4:
                FacesContext.getCurrentInstance().addMessage(destino, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, texto));
                break;
        }
    }

    /**
     * Metodo que permite redirecciónar a distintas paginas que se encuentren en
     * el folder de seguridad.
     *
     * @param direccion nombre del archivo a direccionar.
     * @throws IOException puede no encontrar la ruta
     */
    public static void redirect(String direccion) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        context.getExternalContext().redirect(request.getContextPath() + "/security/" + direccion + ".mpc");
    }

    /**
     * Metodo que permite obtener el valor en la variable de propiedades
     *
     * @param a Nombre de la variable de propiedades.
     * @param b Nombre del valor en el archivo de propiedades.
     * @return Retorna el contenido que se encuentra en el seudonimo de el
     * archivo.
     */
    public static String getBundleName(String a, String b) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, a);
        return bundle.getString(b);
    }
}

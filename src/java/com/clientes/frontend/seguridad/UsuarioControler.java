/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.frontend.seguridad;

import com.clientes.backend.entities.Usuario;
import com.clientes.backend.facades.InformacionClienteFacade;
import com.clientes.backend.facades.UsuarioFacade;
import com.clientes.frontend.clientes.CorreoUsuarioControler;
import com.clientes.frontend.clientes.InformacionClienteControler;
import com.clientes.frontend.utils.Email;
import com.clientes.frontend.utils.FacesUtils;
import com.clientes.frontend.utils.IControler;
import com.clientes.frontend.utils.Password;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Named
@RequestScoped
public class UsuarioControler implements Serializable, IControler<Usuario>{
    private static final long serialVersionUID =1L;
    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private InformacionClienteFacade informacionClienteFacade;
    @Inject
    private CorreoUsuarioControler correoUsuarioControler;
    @Inject
    private InformacionClienteControler informacionClienteControler;
    
    public UsuarioControler() {
    }
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CorreoUsuarioControler getCorreoUsuarioControler() {
        return correoUsuarioControler;
    }

    public InformacionClienteControler getInformacionClienteControler() {
        return informacionClienteControler;
    }
    
    public List<Usuario> listaUsuarios(){
        return usuarioFacade.findAll();
    }
    
    public List<Usuario> listaClientes(){
        List<Usuario> clientes = new ArrayList<>();
        for(Usuario u: listaUsuarios()){
            if(u.getTipoUsuario().equals(2)){
                clientes.add(u);
            }
        }
        return clientes;
    }
    
    public void registrarCliente(){
        usuario.setTipoUsuario(2);
        usuario.setClave(Password.generarClave(4));
        String clave = usuario.getClave();
        usuarioFacade.create(usuario);
        Usuario user = usuarioFacade.usuario(usuario);
        correoUsuarioControler.registrarCorreo(user.getIdUsuario());
        informacionClienteControler.registrarInformacion(user.getIdUsuario());
        this.sendPassword("Registro Evaluación", user, correoUsuarioControler.getCorreoUsuario().getCorreoElectronico(), clave);
    }

    public void sendPassword(String encabezado, Usuario u, String correo, String password){
        int envio;
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<h3>Usuario registrado con éxito</h3>");
        emailBody.append("<table width=\"100%\" height=\"100%\" style=");
        emailBody.append("\"background-color:transparent; border-spacing:0; border-collapse: collapse;\">");
        emailBody.append("<tbody>");
        emailBody.append("<tr>");
        emailBody.append("<td>");
        emailBody.append("Nombre");
        emailBody.append("</td>");
        emailBody.append("<td>");
        emailBody.append(informacionClienteFacade.informacionCliente(u.getIdUsuario()).getNombreApellidos());
        emailBody.append("</td>");
        emailBody.append("<tr>");
        emailBody.append("<td>");
        emailBody.append("Usuario");
        emailBody.append("</td>");
        emailBody.append("<td style=\"color:blue\">");
        emailBody.append(usuario.getNumeroCedula());
        emailBody.append("</td>");
        emailBody.append("</tr>");
        emailBody.append("<tr>");
        emailBody.append("<td>");
        emailBody.append("Contraseña");
        emailBody.append("</td>");
        emailBody.append("<td style=\"color:blue\">");
        emailBody.append(password);
        emailBody.append("</td>");
        emailBody.append("</tr>");
        emailBody.append("</tbody>");
        emailBody.append("</table>");
        emailBody.append("<h5>Se recomienda cambiar la contraseña al iniciar sesíón</h5>");
        Email e = new Email(encabezado, emailBody.toString(), correo);
        envio = e.enviarEmail();
    }
    @Override
    public Usuario getObjectByKey(Integer i) {
        return usuarioFacade.find(i);
    }
    
    public String iniciarSesion(){
        Usuario u = usuarioFacade.usuarioSesion(usuario);
        if(u!=null){
            FacesUtils.setObjectSession("usuario", usuario);
            if(u.getTipoUsuario().equals(2)){
                return "/pages/clientes/lista_clientes.cli?faces-redirect=true";
            }else {
                return "/pages/clientes/perfil.cli?faces-redirect=true";
            }
        }
        return null;
    }
    
    
}
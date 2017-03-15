/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientes.frontend.seguridad;

import com.clientes.backend.entities.Usuario;
import com.clientes.frontend.utils.FacesUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Named(value = "sesionControler")
@SessionScoped
public class SesionControler implements Serializable {
    private Usuario usuario;
    public SesionControler() {
    }
    @PostConstruct
    public void init(){
        usuario = (Usuario) FacesUtils.getObjectSession("usuario");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String cerrarSesion(){
        FacesUtils.removeObjectSession("usuario");
        return "/index.cli?faces-redirect=true";
    }
}

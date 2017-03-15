/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientes.frontend.clientes;

import com.clientes.backend.entities.CorreoUsuario;
import com.clientes.backend.facades.CorreoUsuarioFacade;
import com.clientes.frontend.utils.IControler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Named
@RequestScoped
public class CorreoUsuarioControler implements Serializable, IControler<CorreoUsuario> {

    private static final long serialVersionUID = 2L;
    private CorreoUsuario correoUsuario;
    @EJB
    private CorreoUsuarioFacade correoUsuarioFacade;

    public CorreoUsuarioControler() {
    }

    @PostConstruct
    public void init() {
        correoUsuario = new CorreoUsuario();
    }

    public CorreoUsuario getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(CorreoUsuario correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    
    public List<CorreoUsuario> listaCorreos(){
        return correoUsuarioFacade.findAll();
    }
    
    public List<CorreoUsuario> listaCorreosUsuario(Integer i){
        List<CorreoUsuario> correos = new ArrayList<>();
        for(CorreoUsuario co: this.listaCorreos()){
            if(co.getIdUsuario().equals(i)){
                correos.add(co);
            }
        }
        return correos;
    }
    public void registrarCorreo(Integer i){
        getCorreoUsuario().setIdUsuario(i);
        correoUsuarioFacade.create(correoUsuario);
    }

    @Override
    public CorreoUsuario getObjectByKey(Integer i) {
        return correoUsuarioFacade.find(i);
    }
}

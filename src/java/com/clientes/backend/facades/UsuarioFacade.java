/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.facades;

import com.clientes.backend.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ClientesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario usuarioSesion(Usuario u){
        Usuario usuario = getEntityManager().createNamedQuery("Usuario.findByNumeroCedula",Usuario.class)
                .setParameter("numeroCedula", u.getNumeroCedula()).getSingleResult();
        if(usuario.getClave().equals(u.getClave())){
            return usuario;
        }else {
            return null;
        }
    }
    public Usuario usuario(Usuario u){
        return getEntityManager().createNamedQuery("Usuario.findByNumeroCedula",Usuario.class)
                .setParameter("numeroCedula", u.getNumeroCedula()).getSingleResult();
    }
}

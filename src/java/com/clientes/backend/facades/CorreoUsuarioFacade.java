/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.facades;

import com.clientes.backend.entities.CorreoUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Stateless
public class CorreoUsuarioFacade extends AbstractFacade<CorreoUsuario> {

    @PersistenceContext(unitName = "ClientesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoUsuarioFacade() {
        super(CorreoUsuario.class);
    }

}

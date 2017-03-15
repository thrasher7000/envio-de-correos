/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.facades;

import com.clientes.backend.entities.InformacionCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Stateless
public class InformacionClienteFacade extends AbstractFacade<InformacionCliente> {

    @PersistenceContext(unitName = "ClientesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformacionClienteFacade() {
        super(InformacionCliente.class);
    }
    
    public InformacionCliente informacionCliente(Integer i){
        return getEntityManager().createNamedQuery("InformacionCliente.findByIdUsuario",InformacionCliente.class)
                .setParameter("idUsuario", i).getSingleResult();
    }

}

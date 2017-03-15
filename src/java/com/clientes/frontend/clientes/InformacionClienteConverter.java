/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.frontend.clientes;

import com.clientes.backend.entities.InformacionCliente;
import com.clientes.frontend.utils.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@FacesConverter (forClass = InformacionCliente.class)
public class InformacionClienteConverter extends AbstractConverter {

    public InformacionClienteConverter() {
        this.namedController = "informacionClienteControler";
    }
    
}

package com.clientes.frontend.clientes;

import com.clientes.backend.entities.InformacionCliente;
import com.clientes.backend.facades.InformacionClienteFacade;
import com.clientes.frontend.utils.IControler;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Named(value = "informacionClienteControler")
@RequestScoped
public class InformacionClienteControler implements Serializable, IControler<InformacionCliente>{
    private static final long serialVersionUID = 3L;
    private InformacionCliente informacionCliente;
    @EJB
    private InformacionClienteFacade informacionClienteFacade;
    public InformacionClienteControler() {
    }
    @PostConstruct
    public void init (){
        informacionCliente = new InformacionCliente();
    }

    public InformacionCliente getInformacionCliente() {
        return informacionCliente;
    }

    public void setInformacionCliente(InformacionCliente informacionCliente) {
        this.informacionCliente = informacionCliente;
    }
    
    public void registrarInformacion(Integer i){
        informacionCliente.setIdUsuario(i);
        informacionClienteFacade.create(informacionCliente);
    }

    @Override
    public InformacionCliente getObjectByKey(Integer i) {
        return informacionClienteFacade.find(i);
    }
    
}
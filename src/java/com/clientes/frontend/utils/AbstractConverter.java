/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.frontend.utils;

import com.clientes.backend.entities.IEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
public abstract class AbstractConverter implements Converter{

    protected String namedController;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            Integer key = Integer.valueOf(value);
            IControler managedBean = (IControler) context.getELContext()
                    .getELResolver()
                    .getValue(context.getELContext(), null, namedController);
            System.out.println(managedBean.getObjectByKey(key));
            return managedBean.getObjectByKey(key);
        }catch(NumberFormatException e){
            System.out.println("No se pudo convertir ha objeto. ");
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try{
            if(value instanceof IEntity){
                IEntity o = (IEntity) value;
                System.out.println(o.getPK());
                return o.getPK();
            }else{
                System.out.println("No se encontro la intancia IEntity");
                return null;
            }
        }catch(Exception e){
            System.out.println("No se pudo convertir ha String. ");
            return null;
        }
    }
    
}
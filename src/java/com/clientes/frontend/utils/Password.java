/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.frontend.utils;

import java.util.Random;

/**
 * 
 * @author Miguel Angel Rivera Niño
 */
public class Password {
  public static String generarClave(int longitudClave){
        String[] caracteres = {"A","B","C","D","E","F","G","H","Y","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        
        Random numero = new Random();
        String clave = "";
        int i;
        for(i=0; i<=longitudClave;i++){
            clave = clave + caracteres[(int)(numero.nextDouble()* caracteres.length - 1)] + (int)(numero.nextDouble()*9-1);
        }
        return clave;
    }
}

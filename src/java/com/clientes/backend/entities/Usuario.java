/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Usuario.findByInformacionUsuario", query = "SELECT u FROM Usuario u WHERE u.informacionUsuario = :informacionUsuario")
    , @NamedQuery(name = "Usuario.findByNumeroCedula", query = "SELECT u FROM Usuario u WHERE u.numeroCedula = :numeroCedula")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")})
public class Usuario implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "tipo_usuario")
    private Integer tipoUsuario;
    @Column(name = "informacion_usuario")
    private Integer informacionUsuario;
    @Size(max = 50)
    @Column(name = "numero_cedula")
    private String numeroCedula;
    @Size(max = 180)
    @Column(name = "clave")
    private String clave;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios", fetch = FetchType.EAGER)
    private CorreoUsuario correoUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios", fetch = FetchType.EAGER)
    private InformacionCliente informacionCliente;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getInformacionUsuario() {
        return informacionUsuario;
    }

    public void setInformacionUsuario(Integer informacionUsuario) {
        this.informacionUsuario = informacionUsuario;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public CorreoUsuario getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(CorreoUsuario correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public InformacionCliente getInformacionCliente() {
        return informacionCliente;
    }

    public void setInformacionCliente(InformacionCliente informacionCliente) {
        this.informacionCliente = informacionCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clientes.backend.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }

    @Override
    public String getPK() {
       return idUsuario.toString();
    }

}

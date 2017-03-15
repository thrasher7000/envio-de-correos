/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Entity
@Table(name = "correos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorreoUsuario.findAll", query = "SELECT c FROM CorreoUsuario c")
    , @NamedQuery(name = "CorreoUsuario.findByIdUsuario", query = "SELECT c FROM CorreoUsuario c WHERE c.idUsuario = :idUsuario")})
public class CorreoUsuario implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarios;

    public CorreoUsuario() {
    }

    public CorreoUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CorreoUsuario(Integer idUsuario, String correoElectronico) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
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
        if (!(object instanceof CorreoUsuario)) {
            return false;
        }
        CorreoUsuario other = (CorreoUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clientes.backend.entities.CorreoUsuario[ idUsuario=" + idUsuario + " ]";
    }

    @Override
    public String getPK() {
        return toString();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@Entity
@Table(name = "informacion_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionCliente.findAll", query = "SELECT i FROM InformacionCliente i")
    , @NamedQuery(name = "InformacionCliente.findByIdUsuario", query = "SELECT i FROM InformacionCliente i WHERE i.idUsuario = :idUsuario")
    , @NamedQuery(name = "InformacionCliente.findByNombreApellidos", query = "SELECT i FROM InformacionCliente i WHERE i.nombreApellidos = :nombreApellidos")
    , @NamedQuery(name = "InformacionCliente.findByTelefono", query = "SELECT i FROM InformacionCliente i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "InformacionCliente.findByDireccion", query = "SELECT i FROM InformacionCliente i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "InformacionCliente.findByFechaNacimiento", query = "SELECT i FROM InformacionCliente i WHERE i.fechaNacimiento = :fechaNacimiento")})
public class InformacionCliente implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_apellidos")
    private String nombreApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarios;

    public InformacionCliente() {
    }

    public InformacionCliente(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public InformacionCliente(Integer idUsuario, String nombreApellidos, String telefono, String direccion, Date fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.nombreApellidos = nombreApellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        if (!(object instanceof InformacionCliente)) {
            return false;
        }
        InformacionCliente other = (InformacionCliente) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.clientes.backend.entities.InformacionCliente[ idUsuario=" + idUsuario + " ]";
    }

    @Override
    public String getPK() {
        return idUsuario.toString();
    }

}

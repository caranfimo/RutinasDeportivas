/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "REGISTRO")
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_REGISTRO")
    private Integer idRegistro;
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    @JoinColumn(name = "ID_REGISTRO", referencedColumnName = "ID_ESPECIALISTA", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    private Especialista especialista;

    public Registro() {
    }

    public Registro(Date fechaRegistro, Especialista especialista) {
        this.idRegistro = especialista.getIdEspecialista();
        this.fechaRegistro = fechaRegistro;
        this.especialista = especialista;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
